package at.jku.weiner.kefax.dotconfig.ui.contentassist.antlr.internal; 

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
import at.jku.weiner.kefax.dotconfig.services.DotconfigGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

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
    public String getGrammarFileName() { return "InternalDotconfig.g"; }


     
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
    // InternalDotconfig.g:62:1: entryRuleDotConfigModel : ruleDotConfigModel EOF ;
    public final void entryRuleDotConfigModel() throws RecognitionException {
        try {
            // InternalDotconfig.g:63:1: ( ruleDotConfigModel EOF )
            // InternalDotconfig.g:64:1: ruleDotConfigModel EOF
            {
             before(grammarAccess.getDotConfigModelRule()); 
            pushFollow(FOLLOW_1);
            ruleDotConfigModel();

            state._fsp--;

             after(grammarAccess.getDotConfigModelRule()); 
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
    // $ANTLR end "entryRuleDotConfigModel"


    // $ANTLR start "ruleDotConfigModel"
    // InternalDotconfig.g:71:1: ruleDotConfigModel : ( ( rule__DotConfigModel__Group__0 ) ) ;
    public final void ruleDotConfigModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalDotconfig.g:78:7: ( ( ( rule__DotConfigModel__Group__0 ) ) )
            // InternalDotconfig.g:80:1: ( ( rule__DotConfigModel__Group__0 ) )
            {
            // InternalDotconfig.g:80:1: ( ( rule__DotConfigModel__Group__0 ) )
            // InternalDotconfig.g:81:1: ( rule__DotConfigModel__Group__0 )
            {
             before(grammarAccess.getDotConfigModelAccess().getGroup()); 
            // InternalDotconfig.g:82:1: ( rule__DotConfigModel__Group__0 )
            // InternalDotconfig.g:82:2: rule__DotConfigModel__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DotConfigModel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDotConfigModelAccess().getGroup()); 

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
    // $ANTLR end "ruleDotConfigModel"


    // $ANTLR start "entryRuleConfig"
    // InternalDotconfig.g:97:1: entryRuleConfig : ruleConfig EOF ;
    public final void entryRuleConfig() throws RecognitionException {
        try {
            // InternalDotconfig.g:98:1: ( ruleConfig EOF )
            // InternalDotconfig.g:99:1: ruleConfig EOF
            {
             before(grammarAccess.getConfigRule()); 
            pushFollow(FOLLOW_1);
            ruleConfig();

            state._fsp--;

             after(grammarAccess.getConfigRule()); 
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
    // $ANTLR end "entryRuleConfig"


    // $ANTLR start "ruleConfig"
    // InternalDotconfig.g:106:1: ruleConfig : ( ( rule__Config__Alternatives ) ) ;
    public final void ruleConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalDotconfig.g:113:7: ( ( ( rule__Config__Alternatives ) ) )
            // InternalDotconfig.g:115:1: ( ( rule__Config__Alternatives ) )
            {
            // InternalDotconfig.g:115:1: ( ( rule__Config__Alternatives ) )
            // InternalDotconfig.g:116:1: ( rule__Config__Alternatives )
            {
             before(grammarAccess.getConfigAccess().getAlternatives()); 
            // InternalDotconfig.g:117:1: ( rule__Config__Alternatives )
            // InternalDotconfig.g:117:2: rule__Config__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Config__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getConfigAccess().getAlternatives()); 

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
    // $ANTLR end "ruleConfig"


    // $ANTLR start "entryRulevalue"
    // InternalDotconfig.g:132:1: entryRulevalue : rulevalue EOF ;
    public final void entryRulevalue() throws RecognitionException {
        try {
            // InternalDotconfig.g:133:1: ( rulevalue EOF )
            // InternalDotconfig.g:134:1: rulevalue EOF
            {
             before(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_1);
            rulevalue();

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
    // $ANTLR end "entryRulevalue"


    // $ANTLR start "rulevalue"
    // InternalDotconfig.g:141:1: rulevalue : ( ( rule__Value__Alternatives ) ) ;
    public final void rulevalue() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalDotconfig.g:148:7: ( ( ( rule__Value__Alternatives ) ) )
            // InternalDotconfig.g:150:1: ( ( rule__Value__Alternatives ) )
            {
            // InternalDotconfig.g:150:1: ( ( rule__Value__Alternatives ) )
            // InternalDotconfig.g:151:1: ( rule__Value__Alternatives )
            {
             before(grammarAccess.getValueAccess().getAlternatives()); 
            // InternalDotconfig.g:152:1: ( rule__Value__Alternatives )
            // InternalDotconfig.g:152:2: rule__Value__Alternatives
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
    // $ANTLR end "rulevalue"


    // $ANTLR start "entryRuleEol"
    // InternalDotconfig.g:167:1: entryRuleEol : ruleEol EOF ;
    public final void entryRuleEol() throws RecognitionException {
        try {
            // InternalDotconfig.g:168:1: ( ruleEol EOF )
            // InternalDotconfig.g:169:1: ruleEol EOF
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
    // InternalDotconfig.g:176:1: ruleEol : ( ( ( RULE_NLI ) ) ( ( RULE_NLI )* ) ) ;
    public final void ruleEol() throws RecognitionException {

        		int stackSize = keepStackSize();
        		/*no init found*/
            
        try {
            // InternalDotconfig.g:183:7: ( ( ( ( RULE_NLI ) ) ( ( RULE_NLI )* ) ) )
            // InternalDotconfig.g:185:1: ( ( ( RULE_NLI ) ) ( ( RULE_NLI )* ) )
            {
            // InternalDotconfig.g:185:1: ( ( ( RULE_NLI ) ) ( ( RULE_NLI )* ) )
            // InternalDotconfig.g:186:1: ( ( RULE_NLI ) ) ( ( RULE_NLI )* )
            {
            // InternalDotconfig.g:186:1: ( ( RULE_NLI ) )
            // InternalDotconfig.g:187:1: ( RULE_NLI )
            {
             before(grammarAccess.getEolAccess().getNLITerminalRuleCall()); 
            // InternalDotconfig.g:188:1: ( RULE_NLI )
            // InternalDotconfig.g:188:3: RULE_NLI
            {
            match(input,RULE_NLI,FOLLOW_3); 

            }

             after(grammarAccess.getEolAccess().getNLITerminalRuleCall()); 

            }

            // InternalDotconfig.g:191:1: ( ( RULE_NLI )* )
            // InternalDotconfig.g:192:1: ( RULE_NLI )*
            {
             before(grammarAccess.getEolAccess().getNLITerminalRuleCall()); 
            // InternalDotconfig.g:193:1: ( RULE_NLI )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_NLI) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalDotconfig.g:193:3: RULE_NLI
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


    // $ANTLR start "rule__Config__Alternatives"
    // InternalDotconfig.g:208:1: rule__Config__Alternatives : ( ( ( rule__Config__Group_0__0 ) ) | ( ( rule__Config__Group_1__0 ) ) | ( ( rule__Config__Group_2__0 ) ) );
    public final void rule__Config__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:212:1: ( ( ( rule__Config__Group_0__0 ) ) | ( ( rule__Config__Group_1__0 ) ) | ( ( rule__Config__Group_2__0 ) ) )
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
                    // InternalDotconfig.g:214:1: ( ( rule__Config__Group_0__0 ) )
                    {
                    // InternalDotconfig.g:214:1: ( ( rule__Config__Group_0__0 ) )
                    // InternalDotconfig.g:215:1: ( rule__Config__Group_0__0 )
                    {
                     before(grammarAccess.getConfigAccess().getGroup_0()); 
                    // InternalDotconfig.g:216:1: ( rule__Config__Group_0__0 )
                    // InternalDotconfig.g:216:2: rule__Config__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Config__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getConfigAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDotconfig.g:223:1: ( ( rule__Config__Group_1__0 ) )
                    {
                    // InternalDotconfig.g:223:1: ( ( rule__Config__Group_1__0 ) )
                    // InternalDotconfig.g:224:1: ( rule__Config__Group_1__0 )
                    {
                     before(grammarAccess.getConfigAccess().getGroup_1()); 
                    // InternalDotconfig.g:225:1: ( rule__Config__Group_1__0 )
                    // InternalDotconfig.g:225:2: rule__Config__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Config__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getConfigAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDotconfig.g:232:1: ( ( rule__Config__Group_2__0 ) )
                    {
                    // InternalDotconfig.g:232:1: ( ( rule__Config__Group_2__0 ) )
                    // InternalDotconfig.g:233:1: ( rule__Config__Group_2__0 )
                    {
                     before(grammarAccess.getConfigAccess().getGroup_2()); 
                    // InternalDotconfig.g:234:1: ( rule__Config__Group_2__0 )
                    // InternalDotconfig.g:234:2: rule__Config__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:245:1: rule__Value__Alternatives : ( ( RULE_S_HEX ) | ( RULE_S_INT ) | ( RULE_STRING ) );
    public final void rule__Value__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:249:1: ( ( RULE_S_HEX ) | ( RULE_S_INT ) | ( RULE_STRING ) )
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
                    // InternalDotconfig.g:251:1: ( RULE_S_HEX )
                    {
                    // InternalDotconfig.g:251:1: ( RULE_S_HEX )
                    // InternalDotconfig.g:252:1: RULE_S_HEX
                    {
                     before(grammarAccess.getValueAccess().getS_HEXTerminalRuleCall_0()); 
                    match(input,RULE_S_HEX,FOLLOW_2); 
                     after(grammarAccess.getValueAccess().getS_HEXTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDotconfig.g:260:1: ( RULE_S_INT )
                    {
                    // InternalDotconfig.g:260:1: ( RULE_S_INT )
                    // InternalDotconfig.g:261:1: RULE_S_INT
                    {
                     before(grammarAccess.getValueAccess().getS_INTTerminalRuleCall_1()); 
                    match(input,RULE_S_INT,FOLLOW_2); 
                     after(grammarAccess.getValueAccess().getS_INTTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDotconfig.g:269:1: ( RULE_STRING )
                    {
                    // InternalDotconfig.g:269:1: ( RULE_STRING )
                    // InternalDotconfig.g:270:1: RULE_STRING
                    {
                     before(grammarAccess.getValueAccess().getSTRINGTerminalRuleCall_2()); 
                    match(input,RULE_STRING,FOLLOW_2); 
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
    // InternalDotconfig.g:284:1: rule__DotConfigModel__Group__0 : rule__DotConfigModel__Group__0__Impl rule__DotConfigModel__Group__1 ;
    public final void rule__DotConfigModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:288:1: ( rule__DotConfigModel__Group__0__Impl rule__DotConfigModel__Group__1 )
            // InternalDotconfig.g:289:2: rule__DotConfigModel__Group__0__Impl rule__DotConfigModel__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__DotConfigModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:296:1: rule__DotConfigModel__Group__0__Impl : ( () ) ;
    public final void rule__DotConfigModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:300:1: ( ( () ) )
            // InternalDotconfig.g:302:1: ( () )
            {
            // InternalDotconfig.g:302:1: ( () )
            // InternalDotconfig.g:303:1: ()
            {
             before(grammarAccess.getDotConfigModelAccess().getDotConfigModelAction_0()); 
            // InternalDotconfig.g:304:1: ()
            // InternalDotconfig.g:306:1: 
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
    // InternalDotconfig.g:318:1: rule__DotConfigModel__Group__1 : rule__DotConfigModel__Group__1__Impl rule__DotConfigModel__Group__2 ;
    public final void rule__DotConfigModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:322:1: ( rule__DotConfigModel__Group__1__Impl rule__DotConfigModel__Group__2 )
            // InternalDotconfig.g:323:2: rule__DotConfigModel__Group__1__Impl rule__DotConfigModel__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__DotConfigModel__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:330:1: rule__DotConfigModel__Group__1__Impl : ( ( rule__DotConfigModel__ConfigsAssignment_1 )? ) ;
    public final void rule__DotConfigModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:334:1: ( ( ( rule__DotConfigModel__ConfigsAssignment_1 )? ) )
            // InternalDotconfig.g:336:1: ( ( rule__DotConfigModel__ConfigsAssignment_1 )? )
            {
            // InternalDotconfig.g:336:1: ( ( rule__DotConfigModel__ConfigsAssignment_1 )? )
            // InternalDotconfig.g:337:1: ( rule__DotConfigModel__ConfigsAssignment_1 )?
            {
             before(grammarAccess.getDotConfigModelAccess().getConfigsAssignment_1()); 
            // InternalDotconfig.g:338:1: ( rule__DotConfigModel__ConfigsAssignment_1 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_SYMBOL||LA4_0==RULE_SL_COMMENT_NOT) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalDotconfig.g:338:2: rule__DotConfigModel__ConfigsAssignment_1
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:350:1: rule__DotConfigModel__Group__2 : rule__DotConfigModel__Group__2__Impl rule__DotConfigModel__Group__3 ;
    public final void rule__DotConfigModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:354:1: ( rule__DotConfigModel__Group__2__Impl rule__DotConfigModel__Group__3 )
            // InternalDotconfig.g:355:2: rule__DotConfigModel__Group__2__Impl rule__DotConfigModel__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__DotConfigModel__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:362:1: rule__DotConfigModel__Group__2__Impl : ( ( rule__DotConfigModel__Group_2__0 )* ) ;
    public final void rule__DotConfigModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:366:1: ( ( ( rule__DotConfigModel__Group_2__0 )* ) )
            // InternalDotconfig.g:368:1: ( ( rule__DotConfigModel__Group_2__0 )* )
            {
            // InternalDotconfig.g:368:1: ( ( rule__DotConfigModel__Group_2__0 )* )
            // InternalDotconfig.g:369:1: ( rule__DotConfigModel__Group_2__0 )*
            {
             before(grammarAccess.getDotConfigModelAccess().getGroup_2()); 
            // InternalDotconfig.g:370:1: ( rule__DotConfigModel__Group_2__0 )*
            loop5:
            do {
                int alt5=2;
                alt5 = dfa5.predict(input);
                switch (alt5) {
            	case 1 :
            	    // InternalDotconfig.g:370:2: rule__DotConfigModel__Group_2__0
            	    {
            	    pushFollow(FOLLOW_3);
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
    // InternalDotconfig.g:382:1: rule__DotConfigModel__Group__3 : rule__DotConfigModel__Group__3__Impl ;
    public final void rule__DotConfigModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:386:1: ( rule__DotConfigModel__Group__3__Impl )
            // InternalDotconfig.g:387:2: rule__DotConfigModel__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:393:1: rule__DotConfigModel__Group__3__Impl : ( ( ruleEol )? ) ;
    public final void rule__DotConfigModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:397:1: ( ( ( ruleEol )? ) )
            // InternalDotconfig.g:399:1: ( ( ruleEol )? )
            {
            // InternalDotconfig.g:399:1: ( ( ruleEol )? )
            // InternalDotconfig.g:400:1: ( ruleEol )?
            {
             before(grammarAccess.getDotConfigModelAccess().getEolParserRuleCall_3()); 
            // InternalDotconfig.g:401:1: ( ruleEol )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_NLI) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalDotconfig.g:401:3: ruleEol
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:421:1: rule__DotConfigModel__Group_2__0 : rule__DotConfigModel__Group_2__0__Impl rule__DotConfigModel__Group_2__1 ;
    public final void rule__DotConfigModel__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:425:1: ( rule__DotConfigModel__Group_2__0__Impl rule__DotConfigModel__Group_2__1 )
            // InternalDotconfig.g:426:2: rule__DotConfigModel__Group_2__0__Impl rule__DotConfigModel__Group_2__1
            {
            pushFollow(FOLLOW_5);
            rule__DotConfigModel__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:433:1: rule__DotConfigModel__Group_2__0__Impl : ( ruleEol ) ;
    public final void rule__DotConfigModel__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:437:1: ( ( ruleEol ) )
            // InternalDotconfig.g:439:1: ( ruleEol )
            {
            // InternalDotconfig.g:439:1: ( ruleEol )
            // InternalDotconfig.g:440:1: ruleEol
            {
             before(grammarAccess.getDotConfigModelAccess().getEolParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:453:1: rule__DotConfigModel__Group_2__1 : rule__DotConfigModel__Group_2__1__Impl ;
    public final void rule__DotConfigModel__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:457:1: ( rule__DotConfigModel__Group_2__1__Impl )
            // InternalDotconfig.g:458:2: rule__DotConfigModel__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:464:1: rule__DotConfigModel__Group_2__1__Impl : ( ( rule__DotConfigModel__ConfigsAssignment_2_1 ) ) ;
    public final void rule__DotConfigModel__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:468:1: ( ( ( rule__DotConfigModel__ConfigsAssignment_2_1 ) ) )
            // InternalDotconfig.g:470:1: ( ( rule__DotConfigModel__ConfigsAssignment_2_1 ) )
            {
            // InternalDotconfig.g:470:1: ( ( rule__DotConfigModel__ConfigsAssignment_2_1 ) )
            // InternalDotconfig.g:471:1: ( rule__DotConfigModel__ConfigsAssignment_2_1 )
            {
             before(grammarAccess.getDotConfigModelAccess().getConfigsAssignment_2_1()); 
            // InternalDotconfig.g:472:1: ( rule__DotConfigModel__ConfigsAssignment_2_1 )
            // InternalDotconfig.g:472:2: rule__DotConfigModel__ConfigsAssignment_2_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:488:1: rule__Config__Group_0__0 : rule__Config__Group_0__0__Impl rule__Config__Group_0__1 ;
    public final void rule__Config__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:492:1: ( rule__Config__Group_0__0__Impl rule__Config__Group_0__1 )
            // InternalDotconfig.g:493:2: rule__Config__Group_0__0__Impl rule__Config__Group_0__1
            {
            pushFollow(FOLLOW_6);
            rule__Config__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:500:1: rule__Config__Group_0__0__Impl : ( () ) ;
    public final void rule__Config__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:504:1: ( ( () ) )
            // InternalDotconfig.g:506:1: ( () )
            {
            // InternalDotconfig.g:506:1: ( () )
            // InternalDotconfig.g:507:1: ()
            {
             before(grammarAccess.getConfigAccess().getConfigStringAction_0_0()); 
            // InternalDotconfig.g:508:1: ()
            // InternalDotconfig.g:510:1: 
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
    // InternalDotconfig.g:522:1: rule__Config__Group_0__1 : rule__Config__Group_0__1__Impl rule__Config__Group_0__2 ;
    public final void rule__Config__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:526:1: ( rule__Config__Group_0__1__Impl rule__Config__Group_0__2 )
            // InternalDotconfig.g:527:2: rule__Config__Group_0__1__Impl rule__Config__Group_0__2
            {
            pushFollow(FOLLOW_7);
            rule__Config__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:534:1: rule__Config__Group_0__1__Impl : ( ( rule__Config__NameAssignment_0_1 ) ) ;
    public final void rule__Config__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:538:1: ( ( ( rule__Config__NameAssignment_0_1 ) ) )
            // InternalDotconfig.g:540:1: ( ( rule__Config__NameAssignment_0_1 ) )
            {
            // InternalDotconfig.g:540:1: ( ( rule__Config__NameAssignment_0_1 ) )
            // InternalDotconfig.g:541:1: ( rule__Config__NameAssignment_0_1 )
            {
             before(grammarAccess.getConfigAccess().getNameAssignment_0_1()); 
            // InternalDotconfig.g:542:1: ( rule__Config__NameAssignment_0_1 )
            // InternalDotconfig.g:542:2: rule__Config__NameAssignment_0_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:554:1: rule__Config__Group_0__2 : rule__Config__Group_0__2__Impl rule__Config__Group_0__3 ;
    public final void rule__Config__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:558:1: ( rule__Config__Group_0__2__Impl rule__Config__Group_0__3 )
            // InternalDotconfig.g:559:2: rule__Config__Group_0__2__Impl rule__Config__Group_0__3
            {
            pushFollow(FOLLOW_8);
            rule__Config__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:566:1: rule__Config__Group_0__2__Impl : ( RULE_EQ ) ;
    public final void rule__Config__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:570:1: ( ( RULE_EQ ) )
            // InternalDotconfig.g:572:1: ( RULE_EQ )
            {
            // InternalDotconfig.g:572:1: ( RULE_EQ )
            // InternalDotconfig.g:573:1: RULE_EQ
            {
             before(grammarAccess.getConfigAccess().getEQTerminalRuleCall_0_2()); 
            match(input,RULE_EQ,FOLLOW_2); 
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
    // InternalDotconfig.g:586:1: rule__Config__Group_0__3 : rule__Config__Group_0__3__Impl ;
    public final void rule__Config__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:590:1: ( rule__Config__Group_0__3__Impl )
            // InternalDotconfig.g:591:2: rule__Config__Group_0__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:597:1: rule__Config__Group_0__3__Impl : ( ( rule__Config__VAssignment_0_3 ) ) ;
    public final void rule__Config__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:601:1: ( ( ( rule__Config__VAssignment_0_3 ) ) )
            // InternalDotconfig.g:603:1: ( ( rule__Config__VAssignment_0_3 ) )
            {
            // InternalDotconfig.g:603:1: ( ( rule__Config__VAssignment_0_3 ) )
            // InternalDotconfig.g:604:1: ( rule__Config__VAssignment_0_3 )
            {
             before(grammarAccess.getConfigAccess().getVAssignment_0_3()); 
            // InternalDotconfig.g:605:1: ( rule__Config__VAssignment_0_3 )
            // InternalDotconfig.g:605:2: rule__Config__VAssignment_0_3
            {
            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:625:1: rule__Config__Group_1__0 : rule__Config__Group_1__0__Impl rule__Config__Group_1__1 ;
    public final void rule__Config__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:629:1: ( rule__Config__Group_1__0__Impl rule__Config__Group_1__1 )
            // InternalDotconfig.g:630:2: rule__Config__Group_1__0__Impl rule__Config__Group_1__1
            {
            pushFollow(FOLLOW_6);
            rule__Config__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:637:1: rule__Config__Group_1__0__Impl : ( () ) ;
    public final void rule__Config__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:641:1: ( ( () ) )
            // InternalDotconfig.g:643:1: ( () )
            {
            // InternalDotconfig.g:643:1: ( () )
            // InternalDotconfig.g:644:1: ()
            {
             before(grammarAccess.getConfigAccess().getConfigLogicAction_1_0()); 
            // InternalDotconfig.g:645:1: ()
            // InternalDotconfig.g:647:1: 
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
    // InternalDotconfig.g:659:1: rule__Config__Group_1__1 : rule__Config__Group_1__1__Impl rule__Config__Group_1__2 ;
    public final void rule__Config__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:663:1: ( rule__Config__Group_1__1__Impl rule__Config__Group_1__2 )
            // InternalDotconfig.g:664:2: rule__Config__Group_1__1__Impl rule__Config__Group_1__2
            {
            pushFollow(FOLLOW_7);
            rule__Config__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:671:1: rule__Config__Group_1__1__Impl : ( ( rule__Config__NameAssignment_1_1 ) ) ;
    public final void rule__Config__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:675:1: ( ( ( rule__Config__NameAssignment_1_1 ) ) )
            // InternalDotconfig.g:677:1: ( ( rule__Config__NameAssignment_1_1 ) )
            {
            // InternalDotconfig.g:677:1: ( ( rule__Config__NameAssignment_1_1 ) )
            // InternalDotconfig.g:678:1: ( rule__Config__NameAssignment_1_1 )
            {
             before(grammarAccess.getConfigAccess().getNameAssignment_1_1()); 
            // InternalDotconfig.g:679:1: ( rule__Config__NameAssignment_1_1 )
            // InternalDotconfig.g:679:2: rule__Config__NameAssignment_1_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:691:1: rule__Config__Group_1__2 : rule__Config__Group_1__2__Impl rule__Config__Group_1__3 ;
    public final void rule__Config__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:695:1: ( rule__Config__Group_1__2__Impl rule__Config__Group_1__3 )
            // InternalDotconfig.g:696:2: rule__Config__Group_1__2__Impl rule__Config__Group_1__3
            {
            pushFollow(FOLLOW_9);
            rule__Config__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:703:1: rule__Config__Group_1__2__Impl : ( RULE_EQ ) ;
    public final void rule__Config__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:707:1: ( ( RULE_EQ ) )
            // InternalDotconfig.g:709:1: ( RULE_EQ )
            {
            // InternalDotconfig.g:709:1: ( RULE_EQ )
            // InternalDotconfig.g:710:1: RULE_EQ
            {
             before(grammarAccess.getConfigAccess().getEQTerminalRuleCall_1_2()); 
            match(input,RULE_EQ,FOLLOW_2); 
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
    // InternalDotconfig.g:723:1: rule__Config__Group_1__3 : rule__Config__Group_1__3__Impl ;
    public final void rule__Config__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:727:1: ( rule__Config__Group_1__3__Impl )
            // InternalDotconfig.g:728:2: rule__Config__Group_1__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:734:1: rule__Config__Group_1__3__Impl : ( ( rule__Config__VAssignment_1_3 ) ) ;
    public final void rule__Config__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:738:1: ( ( ( rule__Config__VAssignment_1_3 ) ) )
            // InternalDotconfig.g:740:1: ( ( rule__Config__VAssignment_1_3 ) )
            {
            // InternalDotconfig.g:740:1: ( ( rule__Config__VAssignment_1_3 ) )
            // InternalDotconfig.g:741:1: ( rule__Config__VAssignment_1_3 )
            {
             before(grammarAccess.getConfigAccess().getVAssignment_1_3()); 
            // InternalDotconfig.g:742:1: ( rule__Config__VAssignment_1_3 )
            // InternalDotconfig.g:742:2: rule__Config__VAssignment_1_3
            {
            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:762:1: rule__Config__Group_2__0 : rule__Config__Group_2__0__Impl rule__Config__Group_2__1 ;
    public final void rule__Config__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:766:1: ( rule__Config__Group_2__0__Impl rule__Config__Group_2__1 )
            // InternalDotconfig.g:767:2: rule__Config__Group_2__0__Impl rule__Config__Group_2__1
            {
            pushFollow(FOLLOW_5);
            rule__Config__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:774:1: rule__Config__Group_2__0__Impl : ( () ) ;
    public final void rule__Config__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:778:1: ( ( () ) )
            // InternalDotconfig.g:780:1: ( () )
            {
            // InternalDotconfig.g:780:1: ( () )
            // InternalDotconfig.g:781:1: ()
            {
             before(grammarAccess.getConfigAccess().getConfigLogicAction_2_0()); 
            // InternalDotconfig.g:782:1: ()
            // InternalDotconfig.g:784:1: 
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
    // InternalDotconfig.g:796:1: rule__Config__Group_2__1 : rule__Config__Group_2__1__Impl ;
    public final void rule__Config__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:800:1: ( rule__Config__Group_2__1__Impl )
            // InternalDotconfig.g:801:2: rule__Config__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:807:1: rule__Config__Group_2__1__Impl : ( ( rule__Config__NameAssignment_2_1 ) ) ;
    public final void rule__Config__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:811:1: ( ( ( rule__Config__NameAssignment_2_1 ) ) )
            // InternalDotconfig.g:813:1: ( ( rule__Config__NameAssignment_2_1 ) )
            {
            // InternalDotconfig.g:813:1: ( ( rule__Config__NameAssignment_2_1 ) )
            // InternalDotconfig.g:814:1: ( rule__Config__NameAssignment_2_1 )
            {
             before(grammarAccess.getConfigAccess().getNameAssignment_2_1()); 
            // InternalDotconfig.g:815:1: ( rule__Config__NameAssignment_2_1 )
            // InternalDotconfig.g:815:2: rule__Config__NameAssignment_2_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:832:1: rule__DotConfigModel__ConfigsAssignment_1 : ( ruleConfig ) ;
    public final void rule__DotConfigModel__ConfigsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:836:1: ( ( ruleConfig ) )
            // InternalDotconfig.g:837:1: ( ruleConfig )
            {
            // InternalDotconfig.g:837:1: ( ruleConfig )
            // InternalDotconfig.g:838:1: ruleConfig
            {
             before(grammarAccess.getDotConfigModelAccess().getConfigsConfigParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:847:1: rule__DotConfigModel__ConfigsAssignment_2_1 : ( ruleConfig ) ;
    public final void rule__DotConfigModel__ConfigsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:851:1: ( ( ruleConfig ) )
            // InternalDotconfig.g:852:1: ( ruleConfig )
            {
            // InternalDotconfig.g:852:1: ( ruleConfig )
            // InternalDotconfig.g:853:1: ruleConfig
            {
             before(grammarAccess.getDotConfigModelAccess().getConfigsConfigParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:862:1: rule__Config__NameAssignment_0_1 : ( RULE_SYMBOL ) ;
    public final void rule__Config__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:866:1: ( ( RULE_SYMBOL ) )
            // InternalDotconfig.g:867:1: ( RULE_SYMBOL )
            {
            // InternalDotconfig.g:867:1: ( RULE_SYMBOL )
            // InternalDotconfig.g:868:1: RULE_SYMBOL
            {
             before(grammarAccess.getConfigAccess().getNameSYMBOLTerminalRuleCall_0_1_0()); 
            match(input,RULE_SYMBOL,FOLLOW_2); 
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
    // InternalDotconfig.g:877:1: rule__Config__VAssignment_0_3 : ( rulevalue ) ;
    public final void rule__Config__VAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:881:1: ( ( rulevalue ) )
            // InternalDotconfig.g:882:1: ( rulevalue )
            {
            // InternalDotconfig.g:882:1: ( rulevalue )
            // InternalDotconfig.g:883:1: rulevalue
            {
             before(grammarAccess.getConfigAccess().getVValueParserRuleCall_0_3_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalDotconfig.g:892:1: rule__Config__NameAssignment_1_1 : ( RULE_SYMBOL ) ;
    public final void rule__Config__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:896:1: ( ( RULE_SYMBOL ) )
            // InternalDotconfig.g:897:1: ( RULE_SYMBOL )
            {
            // InternalDotconfig.g:897:1: ( RULE_SYMBOL )
            // InternalDotconfig.g:898:1: RULE_SYMBOL
            {
             before(grammarAccess.getConfigAccess().getNameSYMBOLTerminalRuleCall_1_1_0()); 
            match(input,RULE_SYMBOL,FOLLOW_2); 
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
    // InternalDotconfig.g:907:1: rule__Config__VAssignment_1_3 : ( RULE_LOGIC_SYM ) ;
    public final void rule__Config__VAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:911:1: ( ( RULE_LOGIC_SYM ) )
            // InternalDotconfig.g:912:1: ( RULE_LOGIC_SYM )
            {
            // InternalDotconfig.g:912:1: ( RULE_LOGIC_SYM )
            // InternalDotconfig.g:913:1: RULE_LOGIC_SYM
            {
             before(grammarAccess.getConfigAccess().getVLOGIC_SYMTerminalRuleCall_1_3_0()); 
            match(input,RULE_LOGIC_SYM,FOLLOW_2); 
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
    // InternalDotconfig.g:922:1: rule__Config__NameAssignment_2_1 : ( RULE_SL_COMMENT_NOT ) ;
    public final void rule__Config__NameAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalDotconfig.g:926:1: ( ( RULE_SL_COMMENT_NOT ) )
            // InternalDotconfig.g:927:1: ( RULE_SL_COMMENT_NOT )
            {
            // InternalDotconfig.g:927:1: ( RULE_SL_COMMENT_NOT )
            // InternalDotconfig.g:928:1: RULE_SL_COMMENT_NOT
            {
             before(grammarAccess.getConfigAccess().getNameSL_COMMENT_NOTTerminalRuleCall_2_1_0()); 
            match(input,RULE_SL_COMMENT_NOT,FOLLOW_2); 
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
            return "()* loopback of 370:1: ( rule__DotConfigModel__Group_2__0 )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000A10L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000400L});

}