package org.xtext.example.mydsl1.ui.contentassist.antlr.internal; 

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
import org.xtext.example.mydsl1.services.MyDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyDslParser extends AbstractInternalContentAssistParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ANY_OTHER", "RULE_ID", "RULE_INT", 
		"RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_STRING", "RULE_WS", "'!'", 
		"'Hello'", "'Test'", "'inc'", "'pre'", "'reset'", "'type'"
	};
	public static final int EOF=-1;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int RULE_ANY_OTHER=4;
	public static final int RULE_ID=5;
	public static final int RULE_INT=6;
	public static final int RULE_ML_COMMENT=7;
	public static final int RULE_SL_COMMENT=8;
	public static final int RULE_STRING=9;
	public static final int RULE_WS=10;

	// delegates
	public AbstractInternalContentAssistParser[] getDelegates() {
		return new AbstractInternalContentAssistParser[] {};
	}

	// delegators


	public InternalMyDslParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public InternalMyDslParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return InternalMyDslParser.tokenNames; }
	@Override public String getGrammarFileName() { return "InternalMyDsl.g"; }


	 
	 	private MyDslGrammarAccess grammarAccess;
	 	
	    public void setGrammarAccess(MyDslGrammarAccess grammarAccess) {
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
	// InternalMyDsl.g:63:1: entryRuleModel : ruleModel EOF ;
	public final void entryRuleModel() throws RecognitionException {
		try {
			// InternalMyDsl.g:64:1: ( ruleModel EOF )
			// InternalMyDsl.g:65:1: ruleModel EOF
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
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleModel"



	// $ANTLR start "ruleModel"
	// InternalMyDsl.g:72:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
	public final void ruleModel() throws RecognitionException {

				int stackSize = keepStackSize();
				
		    
		try {
			// InternalMyDsl.g:79:7: ( ( ( rule__Model__Group__0 ) ) )
			// InternalMyDsl.g:81:1: ( ( rule__Model__Group__0 ) )
			{
			// InternalMyDsl.g:81:1: ( ( rule__Model__Group__0 ) )
			// InternalMyDsl.g:82:1: ( rule__Model__Group__0 )
			{
			 before(grammarAccess.getModelAccess().getGroup()); 
			// InternalMyDsl.g:83:2: ( rule__Model__Group__0 )
			// InternalMyDsl.g:83:2: rule__Model__Group__0
			{
			pushFollow(FOLLOW_2);
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
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleModel"



	// $ANTLR start "entryRuleGreeting"
	// InternalMyDsl.g:97:1: entryRuleGreeting : ruleGreeting EOF ;
	public final void entryRuleGreeting() throws RecognitionException {
		try {
			// InternalMyDsl.g:98:1: ( ruleGreeting EOF )
			// InternalMyDsl.g:99:1: ruleGreeting EOF
			{
			 before(grammarAccess.getGreetingRule()); 
			pushFollow(FOLLOW_1);
			ruleGreeting();
			state._fsp--;

			 after(grammarAccess.getGreetingRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleGreeting"



	// $ANTLR start "ruleGreeting"
	// InternalMyDsl.g:106:1: ruleGreeting : ( ( rule__Greeting__Group__0 ) ) ;
	public final void ruleGreeting() throws RecognitionException {

				int stackSize = keepStackSize();
				System.out.println("Greeting - initRuleAction");
		    
		try {
			// InternalMyDsl.g:113:7: ( ( ( rule__Greeting__Group__0 ) ) )
			// InternalMyDsl.g:115:1: ( ( rule__Greeting__Group__0 ) )
			{
			// InternalMyDsl.g:115:1: ( ( rule__Greeting__Group__0 ) )
			// InternalMyDsl.g:116:1: ( rule__Greeting__Group__0 )
			{
			 before(grammarAccess.getGreetingAccess().getGroup()); 
			// InternalMyDsl.g:117:2: ( rule__Greeting__Group__0 )
			// InternalMyDsl.g:117:2: rule__Greeting__Group__0
			{
			pushFollow(FOLLOW_2);
			rule__Greeting__Group__0();
			state._fsp--;

			}

			 after(grammarAccess.getGreetingAccess().getGroup()); 
			}

			}


			    		System.out.println("Greeting - afterRuleaction");
			     
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleGreeting"



	// $ANTLR start "entryRuleTest"
	// InternalMyDsl.g:131:1: entryRuleTest : ruleTest EOF ;
	public final void entryRuleTest() throws RecognitionException {
		try {
			// InternalMyDsl.g:132:1: ( ruleTest EOF )
			// InternalMyDsl.g:133:1: ruleTest EOF
			{
			 before(grammarAccess.getTestRule()); 
			pushFollow(FOLLOW_1);
			ruleTest();
			state._fsp--;

			 after(grammarAccess.getTestRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleTest"



	// $ANTLR start "ruleTest"
	// InternalMyDsl.g:140:1: ruleTest : ( ( rule__Test__Group__0 ) ) ;
	public final void ruleTest() throws RecognitionException {

				int stackSize = keepStackSize();
				System.out.println("test-in");
		    
		try {
			// InternalMyDsl.g:147:7: ( ( ( rule__Test__Group__0 ) ) )
			// InternalMyDsl.g:149:1: ( ( rule__Test__Group__0 ) )
			{
			// InternalMyDsl.g:149:1: ( ( rule__Test__Group__0 ) )
			// InternalMyDsl.g:150:1: ( rule__Test__Group__0 )
			{
			 before(grammarAccess.getTestAccess().getGroup()); 
			// InternalMyDsl.g:151:2: ( rule__Test__Group__0 )
			// InternalMyDsl.g:151:2: rule__Test__Group__0
			{
			pushFollow(FOLLOW_2);
			rule__Test__Group__0();
			state._fsp--;

			}

			 after(grammarAccess.getTestAccess().getGroup()); 
			}

			}


			    		
			     
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleTest"



	// $ANTLR start "entryRulePre"
	// InternalMyDsl.g:165:1: entryRulePre : rulePre EOF ;
	public final void entryRulePre() throws RecognitionException {
		try {
			// InternalMyDsl.g:166:1: ( rulePre EOF )
			// InternalMyDsl.g:167:1: rulePre EOF
			{
			 before(grammarAccess.getPreRule()); 
			pushFollow(FOLLOW_1);
			rulePre();
			state._fsp--;

			 after(grammarAccess.getPreRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRulePre"



	// $ANTLR start "rulePre"
	// InternalMyDsl.g:174:1: rulePre : ( 'pre' ) ;
	public final void rulePre() throws RecognitionException {

				int stackSize = keepStackSize();
				
		    
		try {
			// InternalMyDsl.g:181:7: ( ( 'pre' ) )
			// InternalMyDsl.g:182:1: ( 'pre' )
			{
			System.out.println("pre");
			// InternalMyDsl.g:184:1: ( 'pre' )
			// InternalMyDsl.g:185:1: 'pre'
			{
			 before(grammarAccess.getPreAccess().getPreKeyword()); 
			match(input,15,FOLLOW_2); 
			 after(grammarAccess.getPreAccess().getPreKeyword()); 
			}

			System.out.println("post");
			}


			    		
			     
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rulePre"



	// $ANTLR start "entryRuleReset"
	// InternalMyDsl.g:203:1: entryRuleReset : ruleReset EOF ;
	public final void entryRuleReset() throws RecognitionException {
		try {
			// InternalMyDsl.g:204:1: ( ruleReset EOF )
			// InternalMyDsl.g:205:1: ruleReset EOF
			{
			 before(grammarAccess.getResetRule()); 
			pushFollow(FOLLOW_1);
			ruleReset();
			state._fsp--;

			 after(grammarAccess.getResetRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleReset"



	// $ANTLR start "ruleReset"
	// InternalMyDsl.g:212:1: ruleReset : ( ( rule__Reset__ResetAssignment ) ) ;
	public final void ruleReset() throws RecognitionException {

				int stackSize = keepStackSize();
				
		    
		try {
			// InternalMyDsl.g:219:7: ( ( ( rule__Reset__ResetAssignment ) ) )
			// InternalMyDsl.g:221:1: ( ( rule__Reset__ResetAssignment ) )
			{
			// InternalMyDsl.g:221:1: ( ( rule__Reset__ResetAssignment ) )
			// InternalMyDsl.g:222:1: ( rule__Reset__ResetAssignment )
			{
			 before(grammarAccess.getResetAccess().getResetAssignment()); 
			// InternalMyDsl.g:223:2: ( rule__Reset__ResetAssignment )
			// InternalMyDsl.g:223:2: rule__Reset__ResetAssignment
			{
			pushFollow(FOLLOW_2);
			rule__Reset__ResetAssignment();
			state._fsp--;

			}

			 after(grammarAccess.getResetAccess().getResetAssignment()); 
			}

			org.xtext.example.mydsl1.TestScope.reset();
			}


			    		
			     
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleReset"



	// $ANTLR start "entryRuleInc"
	// InternalMyDsl.g:238:1: entryRuleInc : ruleInc EOF ;
	public final void entryRuleInc() throws RecognitionException {
		try {
			// InternalMyDsl.g:239:1: ( ruleInc EOF )
			// InternalMyDsl.g:240:1: ruleInc EOF
			{
			 before(grammarAccess.getIncRule()); 
			pushFollow(FOLLOW_1);
			ruleInc();
			state._fsp--;

			 after(grammarAccess.getIncRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleInc"



	// $ANTLR start "ruleInc"
	// InternalMyDsl.g:247:1: ruleInc : ( ( rule__Inc__IncAssignment ) ) ;
	public final void ruleInc() throws RecognitionException {

				int stackSize = keepStackSize();
				
		    
		try {
			// InternalMyDsl.g:254:7: ( ( ( rule__Inc__IncAssignment ) ) )
			// InternalMyDsl.g:256:1: ( ( rule__Inc__IncAssignment ) )
			{
			// InternalMyDsl.g:256:1: ( ( rule__Inc__IncAssignment ) )
			// InternalMyDsl.g:257:1: ( rule__Inc__IncAssignment )
			{
			 before(grammarAccess.getIncAccess().getIncAssignment()); 
			// InternalMyDsl.g:258:2: ( rule__Inc__IncAssignment )
			// InternalMyDsl.g:258:2: rule__Inc__IncAssignment
			{
			pushFollow(FOLLOW_2);
			rule__Inc__IncAssignment();
			state._fsp--;

			}

			 after(grammarAccess.getIncAccess().getIncAssignment()); 
			}

			org.xtext.example.mydsl1.TestScope.inc();
			}


			    		
			     
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleInc"



	// $ANTLR start "entryRuleDynamic"
	// InternalMyDsl.g:273:1: entryRuleDynamic : ruleDynamic EOF ;
	public final void entryRuleDynamic() throws RecognitionException {
		try {
			// InternalMyDsl.g:274:1: ( ruleDynamic EOF )
			// InternalMyDsl.g:275:1: ruleDynamic EOF
			{
			 before(grammarAccess.getDynamicRule()); 
			pushFollow(FOLLOW_1);
			ruleDynamic();
			state._fsp--;

			 after(grammarAccess.getDynamicRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleDynamic"



	// $ANTLR start "ruleDynamic"
	// InternalMyDsl.g:282:1: ruleDynamic : ( ( rule__Dynamic__Alternatives ) ) ;
	public final void ruleDynamic() throws RecognitionException {

				int stackSize = keepStackSize();
				
		    
		try {
			// InternalMyDsl.g:289:7: ( ( ( rule__Dynamic__Alternatives ) ) )
			// InternalMyDsl.g:291:1: ( ( rule__Dynamic__Alternatives ) )
			{
			// InternalMyDsl.g:291:1: ( ( rule__Dynamic__Alternatives ) )
			// InternalMyDsl.g:292:1: ( rule__Dynamic__Alternatives )
			{
			 before(grammarAccess.getDynamicAccess().getAlternatives()); 
			// InternalMyDsl.g:293:2: ( rule__Dynamic__Alternatives )
			// InternalMyDsl.g:293:2: rule__Dynamic__Alternatives
			{
			pushFollow(FOLLOW_2);
			rule__Dynamic__Alternatives();
			state._fsp--;

			}

			 after(grammarAccess.getDynamicAccess().getAlternatives()); 
			}

			}


			    		
			     
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleDynamic"



	// $ANTLR start "entryRuleTypeA"
	// InternalMyDsl.g:307:1: entryRuleTypeA : ruleTypeA EOF ;
	public final void entryRuleTypeA() throws RecognitionException {
		try {
			// InternalMyDsl.g:308:1: ( ruleTypeA EOF )
			// InternalMyDsl.g:309:1: ruleTypeA EOF
			{
			 before(grammarAccess.getTypeARule()); 
			pushFollow(FOLLOW_1);
			ruleTypeA();
			state._fsp--;

			 after(grammarAccess.getTypeARule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleTypeA"



	// $ANTLR start "ruleTypeA"
	// InternalMyDsl.g:316:1: ruleTypeA : ( ( rule__TypeA__TypeAssignment ) ) ;
	public final void ruleTypeA() throws RecognitionException {

				int stackSize = keepStackSize();
				
		    
		try {
			// InternalMyDsl.g:323:7: ( ( ( rule__TypeA__TypeAssignment ) ) )
			// InternalMyDsl.g:325:1: ( ( rule__TypeA__TypeAssignment ) )
			{
			// InternalMyDsl.g:325:1: ( ( rule__TypeA__TypeAssignment ) )
			// InternalMyDsl.g:326:1: ( rule__TypeA__TypeAssignment )
			{
			 before(grammarAccess.getTypeAAccess().getTypeAssignment()); 
			// InternalMyDsl.g:327:2: ( rule__TypeA__TypeAssignment )
			// InternalMyDsl.g:327:2: rule__TypeA__TypeAssignment
			{
			pushFollow(FOLLOW_2);
			rule__TypeA__TypeAssignment();
			state._fsp--;

			}

			 after(grammarAccess.getTypeAAccess().getTypeAssignment()); 
			}

			System.out.println("TypeA");
			}


			    		
			     
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleTypeA"



	// $ANTLR start "entryRuleTypeB"
	// InternalMyDsl.g:342:1: entryRuleTypeB : ruleTypeB EOF ;
	public final void entryRuleTypeB() throws RecognitionException {
		try {
			// InternalMyDsl.g:343:1: ( ruleTypeB EOF )
			// InternalMyDsl.g:344:1: ruleTypeB EOF
			{
			 before(grammarAccess.getTypeBRule()); 
			pushFollow(FOLLOW_1);
			ruleTypeB();
			state._fsp--;

			 after(grammarAccess.getTypeBRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleTypeB"



	// $ANTLR start "ruleTypeB"
	// InternalMyDsl.g:351:1: ruleTypeB :{...}? ( ( rule__TypeB__TypeAssignment ) ) ;
	public final void ruleTypeB() throws RecognitionException {

				int stackSize = keepStackSize();
				
		    
		try {
			// InternalMyDsl.g:358:7: ({...}? ( ( rule__TypeB__TypeAssignment ) ) )
			// InternalMyDsl.g:359:1: {...}? ( ( rule__TypeB__TypeAssignment ) )
			{
			if ( !((org.xtext.example.mydsl1.TestScope.isValid())) ) {
				throw new FailedPredicateException(input, "ruleTypeB", "org.xtext.example.mydsl1.TestScope.isValid()");
			}
			// InternalMyDsl.g:361:1: ( ( rule__TypeB__TypeAssignment ) )
			// InternalMyDsl.g:362:1: ( rule__TypeB__TypeAssignment )
			{
			 before(grammarAccess.getTypeBAccess().getTypeAssignment()); 
			// InternalMyDsl.g:363:2: ( rule__TypeB__TypeAssignment )
			// InternalMyDsl.g:363:2: rule__TypeB__TypeAssignment
			{
			pushFollow(FOLLOW_2);
			rule__TypeB__TypeAssignment();
			state._fsp--;

			}

			 after(grammarAccess.getTypeBAccess().getTypeAssignment()); 
			}

			System.out.println("TypeB");
			}


			    		
			     
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleTypeB"



	// $ANTLR start "rule__Dynamic__Alternatives"
	// InternalMyDsl.g:378:1: rule__Dynamic__Alternatives : ( ( ( rule__Dynamic__TypeAssignment_0 ) ) | ( ( rule__Dynamic__TypeAssignment_1 ) ) );
	public final void rule__Dynamic__Alternatives() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:382:1: ( ( ( rule__Dynamic__TypeAssignment_0 ) ) | ( ( rule__Dynamic__TypeAssignment_1 ) ) )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==17) ) {
				int LA1_1 = input.LA(2);
				if ( (!(((org.xtext.example.mydsl1.TestScope.isValid())))) ) {
					alt1=1;
				}
				else if ( ((org.xtext.example.mydsl1.TestScope.isValid())) ) {
					alt1=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// InternalMyDsl.g:384:1: ( ( rule__Dynamic__TypeAssignment_0 ) )
					{
					// InternalMyDsl.g:384:1: ( ( rule__Dynamic__TypeAssignment_0 ) )
					// InternalMyDsl.g:385:1: ( rule__Dynamic__TypeAssignment_0 )
					{
					 before(grammarAccess.getDynamicAccess().getTypeAssignment_0()); 
					// InternalMyDsl.g:386:2: ( rule__Dynamic__TypeAssignment_0 )
					// InternalMyDsl.g:386:2: rule__Dynamic__TypeAssignment_0
					{
					pushFollow(FOLLOW_2);
					rule__Dynamic__TypeAssignment_0();
					state._fsp--;

					}

					 after(grammarAccess.getDynamicAccess().getTypeAssignment_0()); 
					}

					}
					break;
				case 2 :
					// InternalMyDsl.g:393:1: ( ( rule__Dynamic__TypeAssignment_1 ) )
					{
					// InternalMyDsl.g:393:1: ( ( rule__Dynamic__TypeAssignment_1 ) )
					// InternalMyDsl.g:394:1: ( rule__Dynamic__TypeAssignment_1 )
					{
					 before(grammarAccess.getDynamicAccess().getTypeAssignment_1()); 
					// InternalMyDsl.g:395:2: ( rule__Dynamic__TypeAssignment_1 )
					// InternalMyDsl.g:395:2: rule__Dynamic__TypeAssignment_1
					{
					pushFollow(FOLLOW_2);
					rule__Dynamic__TypeAssignment_1();
					state._fsp--;

					}

					 after(grammarAccess.getDynamicAccess().getTypeAssignment_1()); 
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
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Dynamic__Alternatives"



	// $ANTLR start "rule__Model__Group__0"
	// InternalMyDsl.g:408:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
	public final void rule__Model__Group__0() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:412:2: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
			// InternalMyDsl.g:413:2: rule__Model__Group__0__Impl rule__Model__Group__1
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
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Model__Group__0"



	// $ANTLR start "rule__Model__Group__0__Impl"
	// InternalMyDsl.g:420:1: rule__Model__Group__0__Impl : ( () ) ;
	public final void rule__Model__Group__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:424:1: ( ( () ) )
			// InternalMyDsl.g:426:1: ( () )
			{
			// InternalMyDsl.g:426:1: ( () )
			// InternalMyDsl.g:427:1: ()
			{
			 before(grammarAccess.getModelAccess().getModelAction_0()); 
			// InternalMyDsl.g:428:1: ()
			// InternalMyDsl.g:430:1: 
			{
			}

			 after(grammarAccess.getModelAccess().getModelAction_0()); 
			}

			}

		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Model__Group__0__Impl"



	// $ANTLR start "rule__Model__Group__1"
	// InternalMyDsl.g:442:1: rule__Model__Group__1 : rule__Model__Group__1__Impl ;
	public final void rule__Model__Group__1() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:446:2: ( rule__Model__Group__1__Impl )
			// InternalMyDsl.g:447:2: rule__Model__Group__1__Impl
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
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Model__Group__1"



	// $ANTLR start "rule__Model__Group__1__Impl"
	// InternalMyDsl.g:453:1: rule__Model__Group__1__Impl : ( ( ( rule__Model__GreetingsAssignment_1 ) ) ( ( rule__Model__GreetingsAssignment_1 )* ) ) ;
	public final void rule__Model__Group__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:457:1: ( ( ( ( rule__Model__GreetingsAssignment_1 ) ) ( ( rule__Model__GreetingsAssignment_1 )* ) ) )
			// InternalMyDsl.g:459:1: ( ( ( rule__Model__GreetingsAssignment_1 ) ) ( ( rule__Model__GreetingsAssignment_1 )* ) )
			{
			// InternalMyDsl.g:459:1: ( ( ( rule__Model__GreetingsAssignment_1 ) ) ( ( rule__Model__GreetingsAssignment_1 )* ) )
			// InternalMyDsl.g:460:1: ( ( rule__Model__GreetingsAssignment_1 ) ) ( ( rule__Model__GreetingsAssignment_1 )* )
			{
			// InternalMyDsl.g:460:1: ( ( rule__Model__GreetingsAssignment_1 ) )
			// InternalMyDsl.g:461:1: ( rule__Model__GreetingsAssignment_1 )
			{
			 before(grammarAccess.getModelAccess().getGreetingsAssignment_1()); 
			// InternalMyDsl.g:462:2: ( rule__Model__GreetingsAssignment_1 )
			// InternalMyDsl.g:462:2: rule__Model__GreetingsAssignment_1
			{
			pushFollow(FOLLOW_4);
			rule__Model__GreetingsAssignment_1();
			state._fsp--;

			}

			 after(grammarAccess.getModelAccess().getGreetingsAssignment_1()); 
			}

			// InternalMyDsl.g:465:1: ( ( rule__Model__GreetingsAssignment_1 )* )
			// InternalMyDsl.g:466:1: ( rule__Model__GreetingsAssignment_1 )*
			{
			 before(grammarAccess.getModelAccess().getGreetingsAssignment_1()); 
			// InternalMyDsl.g:467:2: ( rule__Model__GreetingsAssignment_1 )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==12) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// InternalMyDsl.g:467:2: rule__Model__GreetingsAssignment_1
					{
					pushFollow(FOLLOW_4);
					rule__Model__GreetingsAssignment_1();
					state._fsp--;

					}
					break;

				default :
					break loop2;
				}
			}

			 after(grammarAccess.getModelAccess().getGreetingsAssignment_1()); 
			}

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Model__Group__1__Impl"



	// $ANTLR start "rule__Greeting__Group__0"
	// InternalMyDsl.g:484:1: rule__Greeting__Group__0 : rule__Greeting__Group__0__Impl rule__Greeting__Group__1 ;
	public final void rule__Greeting__Group__0() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:488:2: ( rule__Greeting__Group__0__Impl rule__Greeting__Group__1 )
			// InternalMyDsl.g:489:2: rule__Greeting__Group__0__Impl rule__Greeting__Group__1
			{
			pushFollow(FOLLOW_3);
			rule__Greeting__Group__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Greeting__Group__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Greeting__Group__0"



	// $ANTLR start "rule__Greeting__Group__0__Impl"
	// InternalMyDsl.g:496:1: rule__Greeting__Group__0__Impl : ( () ) ;
	public final void rule__Greeting__Group__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:500:1: ( ( () ) )
			// InternalMyDsl.g:502:1: ( () )
			{
			// InternalMyDsl.g:502:1: ( () )
			// InternalMyDsl.g:503:1: ()
			{
			 before(grammarAccess.getGreetingAccess().getGreetingAction_0()); 
			// InternalMyDsl.g:504:1: ()
			// InternalMyDsl.g:506:1: 
			{
			}

			 after(grammarAccess.getGreetingAccess().getGreetingAction_0()); 
			}

			}

		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Greeting__Group__0__Impl"



	// $ANTLR start "rule__Greeting__Group__1"
	// InternalMyDsl.g:518:1: rule__Greeting__Group__1 : rule__Greeting__Group__1__Impl rule__Greeting__Group__2 ;
	public final void rule__Greeting__Group__1() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:522:2: ( rule__Greeting__Group__1__Impl rule__Greeting__Group__2 )
			// InternalMyDsl.g:523:2: rule__Greeting__Group__1__Impl rule__Greeting__Group__2
			{
			pushFollow(FOLLOW_5);
			rule__Greeting__Group__1__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Greeting__Group__2();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Greeting__Group__1"



	// $ANTLR start "rule__Greeting__Group__1__Impl"
	// InternalMyDsl.g:530:1: rule__Greeting__Group__1__Impl : ( 'Hello' ) ;
	public final void rule__Greeting__Group__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:534:1: ( ( 'Hello' ) )
			// InternalMyDsl.g:536:1: ( 'Hello' )
			{
			// InternalMyDsl.g:536:1: ( 'Hello' )
			// InternalMyDsl.g:537:1: 'Hello'
			{
			 before(grammarAccess.getGreetingAccess().getHelloKeyword_1()); 
			match(input,12,FOLLOW_2); 
			 after(grammarAccess.getGreetingAccess().getHelloKeyword_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Greeting__Group__1__Impl"



	// $ANTLR start "rule__Greeting__Group__2"
	// InternalMyDsl.g:552:1: rule__Greeting__Group__2 : rule__Greeting__Group__2__Impl rule__Greeting__Group__3 ;
	public final void rule__Greeting__Group__2() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:556:2: ( rule__Greeting__Group__2__Impl rule__Greeting__Group__3 )
			// InternalMyDsl.g:557:2: rule__Greeting__Group__2__Impl rule__Greeting__Group__3
			{
			pushFollow(FOLLOW_6);
			rule__Greeting__Group__2__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Greeting__Group__3();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Greeting__Group__2"



	// $ANTLR start "rule__Greeting__Group__2__Impl"
	// InternalMyDsl.g:564:1: rule__Greeting__Group__2__Impl : ( ( rule__Greeting__NameAssignment_2 ) ) ;
	public final void rule__Greeting__Group__2__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:568:1: ( ( ( rule__Greeting__NameAssignment_2 ) ) )
			// InternalMyDsl.g:570:1: ( ( rule__Greeting__NameAssignment_2 ) )
			{
			// InternalMyDsl.g:570:1: ( ( rule__Greeting__NameAssignment_2 ) )
			// InternalMyDsl.g:571:1: ( rule__Greeting__NameAssignment_2 )
			{
			 before(grammarAccess.getGreetingAccess().getNameAssignment_2()); 
			// InternalMyDsl.g:572:2: ( rule__Greeting__NameAssignment_2 )
			// InternalMyDsl.g:572:2: rule__Greeting__NameAssignment_2
			{
			pushFollow(FOLLOW_2);
			rule__Greeting__NameAssignment_2();
			state._fsp--;

			}

			 after(grammarAccess.getGreetingAccess().getNameAssignment_2()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Greeting__Group__2__Impl"



	// $ANTLR start "rule__Greeting__Group__3"
	// InternalMyDsl.g:584:1: rule__Greeting__Group__3 : rule__Greeting__Group__3__Impl rule__Greeting__Group__4 ;
	public final void rule__Greeting__Group__3() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:588:2: ( rule__Greeting__Group__3__Impl rule__Greeting__Group__4 )
			// InternalMyDsl.g:589:2: rule__Greeting__Group__3__Impl rule__Greeting__Group__4
			{
			pushFollow(FOLLOW_7);
			rule__Greeting__Group__3__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Greeting__Group__4();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Greeting__Group__3"



	// $ANTLR start "rule__Greeting__Group__3__Impl"
	// InternalMyDsl.g:596:1: rule__Greeting__Group__3__Impl : ( '!' ) ;
	public final void rule__Greeting__Group__3__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:600:1: ( ( '!' ) )
			// InternalMyDsl.g:601:1: ( '!' )
			{
			System.out.println("preAction-Hello");
			// InternalMyDsl.g:603:1: ( '!' )
			// InternalMyDsl.g:604:1: '!'
			{
			 before(grammarAccess.getGreetingAccess().getExclamationMarkKeyword_3()); 
			match(input,11,FOLLOW_2); 
			 after(grammarAccess.getGreetingAccess().getExclamationMarkKeyword_3()); 
			}

			System.out.println("postAction-Hello");
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Greeting__Group__3__Impl"



	// $ANTLR start "rule__Greeting__Group__4"
	// InternalMyDsl.g:620:1: rule__Greeting__Group__4 : rule__Greeting__Group__4__Impl rule__Greeting__Group__5 ;
	public final void rule__Greeting__Group__4() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:624:2: ( rule__Greeting__Group__4__Impl rule__Greeting__Group__5 )
			// InternalMyDsl.g:625:2: rule__Greeting__Group__4__Impl rule__Greeting__Group__5
			{
			pushFollow(FOLLOW_8);
			rule__Greeting__Group__4__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Greeting__Group__5();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Greeting__Group__4"



	// $ANTLR start "rule__Greeting__Group__4__Impl"
	// InternalMyDsl.g:632:1: rule__Greeting__Group__4__Impl : ( ( rule__Greeting__TestAssignment_4 ) ) ;
	public final void rule__Greeting__Group__4__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:636:1: ( ( ( rule__Greeting__TestAssignment_4 ) ) )
			// InternalMyDsl.g:638:1: ( ( rule__Greeting__TestAssignment_4 ) )
			{
			// InternalMyDsl.g:638:1: ( ( rule__Greeting__TestAssignment_4 ) )
			// InternalMyDsl.g:639:1: ( rule__Greeting__TestAssignment_4 )
			{
			 before(grammarAccess.getGreetingAccess().getTestAssignment_4()); 
			// InternalMyDsl.g:640:2: ( rule__Greeting__TestAssignment_4 )
			// InternalMyDsl.g:640:2: rule__Greeting__TestAssignment_4
			{
			pushFollow(FOLLOW_2);
			rule__Greeting__TestAssignment_4();
			state._fsp--;

			}

			 after(grammarAccess.getGreetingAccess().getTestAssignment_4()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Greeting__Group__4__Impl"



	// $ANTLR start "rule__Greeting__Group__5"
	// InternalMyDsl.g:652:1: rule__Greeting__Group__5 : rule__Greeting__Group__5__Impl rule__Greeting__Group__6 ;
	public final void rule__Greeting__Group__5() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:656:2: ( rule__Greeting__Group__5__Impl rule__Greeting__Group__6 )
			// InternalMyDsl.g:657:2: rule__Greeting__Group__5__Impl rule__Greeting__Group__6
			{
			pushFollow(FOLLOW_9);
			rule__Greeting__Group__5__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Greeting__Group__6();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Greeting__Group__5"



	// $ANTLR start "rule__Greeting__Group__5__Impl"
	// InternalMyDsl.g:664:1: rule__Greeting__Group__5__Impl : ( ( rulePre )? ) ;
	public final void rule__Greeting__Group__5__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:668:1: ( ( ( rulePre )? ) )
			// InternalMyDsl.g:670:1: ( ( rulePre )? )
			{
			// InternalMyDsl.g:670:1: ( ( rulePre )? )
			// InternalMyDsl.g:671:1: ( rulePre )?
			{
			 before(grammarAccess.getGreetingAccess().getPreParserRuleCall_5()); 
			// InternalMyDsl.g:672:3: ( rulePre )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==15) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// InternalMyDsl.g:672:3: rulePre
					{
					pushFollow(FOLLOW_2);
					rulePre();
					state._fsp--;

					}
					break;

			}

			 after(grammarAccess.getGreetingAccess().getPreParserRuleCall_5()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Greeting__Group__5__Impl"



	// $ANTLR start "rule__Greeting__Group__6"
	// InternalMyDsl.g:684:1: rule__Greeting__Group__6 : rule__Greeting__Group__6__Impl rule__Greeting__Group__7 ;
	public final void rule__Greeting__Group__6() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:688:2: ( rule__Greeting__Group__6__Impl rule__Greeting__Group__7 )
			// InternalMyDsl.g:689:2: rule__Greeting__Group__6__Impl rule__Greeting__Group__7
			{
			pushFollow(FOLLOW_10);
			rule__Greeting__Group__6__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Greeting__Group__7();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Greeting__Group__6"



	// $ANTLR start "rule__Greeting__Group__6__Impl"
	// InternalMyDsl.g:696:1: rule__Greeting__Group__6__Impl : ( ( rule__Greeting__ResetAssignment_6 )? ) ;
	public final void rule__Greeting__Group__6__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:700:1: ( ( ( rule__Greeting__ResetAssignment_6 )? ) )
			// InternalMyDsl.g:702:1: ( ( rule__Greeting__ResetAssignment_6 )? )
			{
			// InternalMyDsl.g:702:1: ( ( rule__Greeting__ResetAssignment_6 )? )
			// InternalMyDsl.g:703:1: ( rule__Greeting__ResetAssignment_6 )?
			{
			 before(grammarAccess.getGreetingAccess().getResetAssignment_6()); 
			// InternalMyDsl.g:704:2: ( rule__Greeting__ResetAssignment_6 )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==16) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// InternalMyDsl.g:704:2: rule__Greeting__ResetAssignment_6
					{
					pushFollow(FOLLOW_2);
					rule__Greeting__ResetAssignment_6();
					state._fsp--;

					}
					break;

			}

			 after(grammarAccess.getGreetingAccess().getResetAssignment_6()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Greeting__Group__6__Impl"



	// $ANTLR start "rule__Greeting__Group__7"
	// InternalMyDsl.g:716:1: rule__Greeting__Group__7 : rule__Greeting__Group__7__Impl rule__Greeting__Group__8 ;
	public final void rule__Greeting__Group__7() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:720:2: ( rule__Greeting__Group__7__Impl rule__Greeting__Group__8 )
			// InternalMyDsl.g:721:2: rule__Greeting__Group__7__Impl rule__Greeting__Group__8
			{
			pushFollow(FOLLOW_11);
			rule__Greeting__Group__7__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Greeting__Group__8();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Greeting__Group__7"



	// $ANTLR start "rule__Greeting__Group__7__Impl"
	// InternalMyDsl.g:728:1: rule__Greeting__Group__7__Impl : ( ( rule__Greeting__IncAssignment_7 )* ) ;
	public final void rule__Greeting__Group__7__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:732:1: ( ( ( rule__Greeting__IncAssignment_7 )* ) )
			// InternalMyDsl.g:734:1: ( ( rule__Greeting__IncAssignment_7 )* )
			{
			// InternalMyDsl.g:734:1: ( ( rule__Greeting__IncAssignment_7 )* )
			// InternalMyDsl.g:735:1: ( rule__Greeting__IncAssignment_7 )*
			{
			 before(grammarAccess.getGreetingAccess().getIncAssignment_7()); 
			// InternalMyDsl.g:736:2: ( rule__Greeting__IncAssignment_7 )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==14) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// InternalMyDsl.g:736:2: rule__Greeting__IncAssignment_7
					{
					pushFollow(FOLLOW_12);
					rule__Greeting__IncAssignment_7();
					state._fsp--;

					}
					break;

				default :
					break loop5;
				}
			}

			 after(grammarAccess.getGreetingAccess().getIncAssignment_7()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Greeting__Group__7__Impl"



	// $ANTLR start "rule__Greeting__Group__8"
	// InternalMyDsl.g:748:1: rule__Greeting__Group__8 : rule__Greeting__Group__8__Impl ;
	public final void rule__Greeting__Group__8() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:752:2: ( rule__Greeting__Group__8__Impl )
			// InternalMyDsl.g:753:2: rule__Greeting__Group__8__Impl
			{
			pushFollow(FOLLOW_2);
			rule__Greeting__Group__8__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Greeting__Group__8"



	// $ANTLR start "rule__Greeting__Group__8__Impl"
	// InternalMyDsl.g:759:1: rule__Greeting__Group__8__Impl : ( ( rule__Greeting__DynamicAssignment_8 )? ) ;
	public final void rule__Greeting__Group__8__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:763:1: ( ( ( rule__Greeting__DynamicAssignment_8 )? ) )
			// InternalMyDsl.g:765:1: ( ( rule__Greeting__DynamicAssignment_8 )? )
			{
			// InternalMyDsl.g:765:1: ( ( rule__Greeting__DynamicAssignment_8 )? )
			// InternalMyDsl.g:766:1: ( rule__Greeting__DynamicAssignment_8 )?
			{
			 before(grammarAccess.getGreetingAccess().getDynamicAssignment_8()); 
			// InternalMyDsl.g:767:2: ( rule__Greeting__DynamicAssignment_8 )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==17) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// InternalMyDsl.g:767:2: rule__Greeting__DynamicAssignment_8
					{
					pushFollow(FOLLOW_2);
					rule__Greeting__DynamicAssignment_8();
					state._fsp--;

					}
					break;

			}

			 after(grammarAccess.getGreetingAccess().getDynamicAssignment_8()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Greeting__Group__8__Impl"



	// $ANTLR start "rule__Test__Group__0"
	// InternalMyDsl.g:797:1: rule__Test__Group__0 : rule__Test__Group__0__Impl rule__Test__Group__1 ;
	public final void rule__Test__Group__0() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:801:2: ( rule__Test__Group__0__Impl rule__Test__Group__1 )
			// InternalMyDsl.g:802:2: rule__Test__Group__0__Impl rule__Test__Group__1
			{
			pushFollow(FOLLOW_5);
			rule__Test__Group__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Test__Group__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Test__Group__0"



	// $ANTLR start "rule__Test__Group__0__Impl"
	// InternalMyDsl.g:809:1: rule__Test__Group__0__Impl : ( 'Test' ) ;
	public final void rule__Test__Group__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:813:1: ( ( 'Test' ) )
			// InternalMyDsl.g:815:1: ( 'Test' )
			{
			// InternalMyDsl.g:815:1: ( 'Test' )
			// InternalMyDsl.g:816:1: 'Test'
			{
			 before(grammarAccess.getTestAccess().getTestKeyword_0()); 
			match(input,13,FOLLOW_2); 
			 after(grammarAccess.getTestAccess().getTestKeyword_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Test__Group__0__Impl"



	// $ANTLR start "rule__Test__Group__1"
	// InternalMyDsl.g:831:1: rule__Test__Group__1 : rule__Test__Group__1__Impl ;
	public final void rule__Test__Group__1() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:835:2: ( rule__Test__Group__1__Impl )
			// InternalMyDsl.g:836:2: rule__Test__Group__1__Impl
			{
			pushFollow(FOLLOW_2);
			rule__Test__Group__1__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Test__Group__1"



	// $ANTLR start "rule__Test__Group__1__Impl"
	// InternalMyDsl.g:842:1: rule__Test__Group__1__Impl : ( ( rule__Test__NameAssignment_1 ) ) ;
	public final void rule__Test__Group__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:846:1: ( ( ( rule__Test__NameAssignment_1 ) ) )
			// InternalMyDsl.g:847:1: ( ( rule__Test__NameAssignment_1 ) )
			{
			System.out.println("preAction-Test");
			// InternalMyDsl.g:849:1: ( ( rule__Test__NameAssignment_1 ) )
			// InternalMyDsl.g:850:1: ( rule__Test__NameAssignment_1 )
			{
			 before(grammarAccess.getTestAccess().getNameAssignment_1()); 
			// InternalMyDsl.g:851:2: ( rule__Test__NameAssignment_1 )
			// InternalMyDsl.g:851:2: rule__Test__NameAssignment_1
			{
			pushFollow(FOLLOW_2);
			rule__Test__NameAssignment_1();
			state._fsp--;

			}

			 after(grammarAccess.getTestAccess().getNameAssignment_1()); 
			}

			System.out.println("postAction-Test");
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Test__Group__1__Impl"



	// $ANTLR start "rule__Model__GreetingsAssignment_1"
	// InternalMyDsl.g:869:1: rule__Model__GreetingsAssignment_1 : ( ruleGreeting ) ;
	public final void rule__Model__GreetingsAssignment_1() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:873:1: ( ( ruleGreeting ) )
			// InternalMyDsl.g:874:1: ( ruleGreeting )
			{
			// InternalMyDsl.g:874:1: ( ruleGreeting )
			// InternalMyDsl.g:875:1: ruleGreeting
			{
			 before(grammarAccess.getModelAccess().getGreetingsGreetingParserRuleCall_1_0()); 
			pushFollow(FOLLOW_2);
			ruleGreeting();
			state._fsp--;

			 after(grammarAccess.getModelAccess().getGreetingsGreetingParserRuleCall_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Model__GreetingsAssignment_1"



	// $ANTLR start "rule__Greeting__NameAssignment_2"
	// InternalMyDsl.g:884:1: rule__Greeting__NameAssignment_2 : ( RULE_ID ) ;
	public final void rule__Greeting__NameAssignment_2() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:888:1: ( ( RULE_ID ) )
			// InternalMyDsl.g:889:1: ( RULE_ID )
			{
			// InternalMyDsl.g:889:1: ( RULE_ID )
			// InternalMyDsl.g:890:1: RULE_ID
			{
			 before(grammarAccess.getGreetingAccess().getNameIDTerminalRuleCall_2_0()); 
			match(input,RULE_ID,FOLLOW_2); 
			 after(grammarAccess.getGreetingAccess().getNameIDTerminalRuleCall_2_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Greeting__NameAssignment_2"



	// $ANTLR start "rule__Greeting__TestAssignment_4"
	// InternalMyDsl.g:899:1: rule__Greeting__TestAssignment_4 : ( ruleTest ) ;
	public final void rule__Greeting__TestAssignment_4() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:903:1: ( ( ruleTest ) )
			// InternalMyDsl.g:904:1: ( ruleTest )
			{
			// InternalMyDsl.g:904:1: ( ruleTest )
			// InternalMyDsl.g:905:1: ruleTest
			{
			 before(grammarAccess.getGreetingAccess().getTestTestParserRuleCall_4_0()); 
			pushFollow(FOLLOW_2);
			ruleTest();
			state._fsp--;

			 after(grammarAccess.getGreetingAccess().getTestTestParserRuleCall_4_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Greeting__TestAssignment_4"



	// $ANTLR start "rule__Greeting__ResetAssignment_6"
	// InternalMyDsl.g:914:1: rule__Greeting__ResetAssignment_6 : ( ruleReset ) ;
	public final void rule__Greeting__ResetAssignment_6() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:918:1: ( ( ruleReset ) )
			// InternalMyDsl.g:919:1: ( ruleReset )
			{
			// InternalMyDsl.g:919:1: ( ruleReset )
			// InternalMyDsl.g:920:1: ruleReset
			{
			 before(grammarAccess.getGreetingAccess().getResetResetParserRuleCall_6_0()); 
			pushFollow(FOLLOW_2);
			ruleReset();
			state._fsp--;

			 after(grammarAccess.getGreetingAccess().getResetResetParserRuleCall_6_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Greeting__ResetAssignment_6"



	// $ANTLR start "rule__Greeting__IncAssignment_7"
	// InternalMyDsl.g:929:1: rule__Greeting__IncAssignment_7 : ( ruleInc ) ;
	public final void rule__Greeting__IncAssignment_7() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:933:1: ( ( ruleInc ) )
			// InternalMyDsl.g:934:1: ( ruleInc )
			{
			// InternalMyDsl.g:934:1: ( ruleInc )
			// InternalMyDsl.g:935:1: ruleInc
			{
			 before(grammarAccess.getGreetingAccess().getIncIncParserRuleCall_7_0()); 
			pushFollow(FOLLOW_2);
			ruleInc();
			state._fsp--;

			 after(grammarAccess.getGreetingAccess().getIncIncParserRuleCall_7_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Greeting__IncAssignment_7"



	// $ANTLR start "rule__Greeting__DynamicAssignment_8"
	// InternalMyDsl.g:944:1: rule__Greeting__DynamicAssignment_8 : ( ruleDynamic ) ;
	public final void rule__Greeting__DynamicAssignment_8() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:948:1: ( ( ruleDynamic ) )
			// InternalMyDsl.g:949:1: ( ruleDynamic )
			{
			// InternalMyDsl.g:949:1: ( ruleDynamic )
			// InternalMyDsl.g:950:1: ruleDynamic
			{
			 before(grammarAccess.getGreetingAccess().getDynamicDynamicParserRuleCall_8_0()); 
			pushFollow(FOLLOW_2);
			ruleDynamic();
			state._fsp--;

			 after(grammarAccess.getGreetingAccess().getDynamicDynamicParserRuleCall_8_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Greeting__DynamicAssignment_8"



	// $ANTLR start "rule__Test__NameAssignment_1"
	// InternalMyDsl.g:959:1: rule__Test__NameAssignment_1 : ( RULE_ID ) ;
	public final void rule__Test__NameAssignment_1() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:963:1: ( ( RULE_ID ) )
			// InternalMyDsl.g:964:1: ( RULE_ID )
			{
			// InternalMyDsl.g:964:1: ( RULE_ID )
			// InternalMyDsl.g:965:1: RULE_ID
			{
			 before(grammarAccess.getTestAccess().getNameIDTerminalRuleCall_1_0()); 
			match(input,RULE_ID,FOLLOW_2); 
			 after(grammarAccess.getTestAccess().getNameIDTerminalRuleCall_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Test__NameAssignment_1"



	// $ANTLR start "rule__Reset__ResetAssignment"
	// InternalMyDsl.g:974:1: rule__Reset__ResetAssignment : ( ( 'reset' ) ) ;
	public final void rule__Reset__ResetAssignment() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:978:1: ( ( ( 'reset' ) ) )
			// InternalMyDsl.g:979:1: ( ( 'reset' ) )
			{
			// InternalMyDsl.g:979:1: ( ( 'reset' ) )
			// InternalMyDsl.g:980:1: ( 'reset' )
			{
			 before(grammarAccess.getResetAccess().getResetResetKeyword_0()); 
			// InternalMyDsl.g:982:1: ( 'reset' )
			// InternalMyDsl.g:983:1: 'reset'
			{
			 before(grammarAccess.getResetAccess().getResetResetKeyword_0()); 
			match(input,16,FOLLOW_2); 
			 after(grammarAccess.getResetAccess().getResetResetKeyword_0()); 
			}

			 after(grammarAccess.getResetAccess().getResetResetKeyword_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Reset__ResetAssignment"



	// $ANTLR start "rule__Inc__IncAssignment"
	// InternalMyDsl.g:1000:1: rule__Inc__IncAssignment : ( ( 'inc' ) ) ;
	public final void rule__Inc__IncAssignment() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:1004:1: ( ( ( 'inc' ) ) )
			// InternalMyDsl.g:1005:1: ( ( 'inc' ) )
			{
			// InternalMyDsl.g:1005:1: ( ( 'inc' ) )
			// InternalMyDsl.g:1006:1: ( 'inc' )
			{
			 before(grammarAccess.getIncAccess().getIncIncKeyword_0()); 
			// InternalMyDsl.g:1008:1: ( 'inc' )
			// InternalMyDsl.g:1009:1: 'inc'
			{
			 before(grammarAccess.getIncAccess().getIncIncKeyword_0()); 
			match(input,14,FOLLOW_2); 
			 after(grammarAccess.getIncAccess().getIncIncKeyword_0()); 
			}

			 after(grammarAccess.getIncAccess().getIncIncKeyword_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Inc__IncAssignment"



	// $ANTLR start "rule__Dynamic__TypeAssignment_0"
	// InternalMyDsl.g:1026:1: rule__Dynamic__TypeAssignment_0 : ( ruleTypeA ) ;
	public final void rule__Dynamic__TypeAssignment_0() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:1030:1: ( ( ruleTypeA ) )
			// InternalMyDsl.g:1031:1: ( ruleTypeA )
			{
			// InternalMyDsl.g:1031:1: ( ruleTypeA )
			// InternalMyDsl.g:1032:1: ruleTypeA
			{
			 before(grammarAccess.getDynamicAccess().getTypeTypeAParserRuleCall_0_0()); 
			pushFollow(FOLLOW_2);
			ruleTypeA();
			state._fsp--;

			 after(grammarAccess.getDynamicAccess().getTypeTypeAParserRuleCall_0_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Dynamic__TypeAssignment_0"



	// $ANTLR start "rule__Dynamic__TypeAssignment_1"
	// InternalMyDsl.g:1041:1: rule__Dynamic__TypeAssignment_1 : ( ruleTypeB ) ;
	public final void rule__Dynamic__TypeAssignment_1() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:1045:1: ( ( ruleTypeB ) )
			// InternalMyDsl.g:1046:1: ( ruleTypeB )
			{
			// InternalMyDsl.g:1046:1: ( ruleTypeB )
			// InternalMyDsl.g:1047:1: ruleTypeB
			{
			 before(grammarAccess.getDynamicAccess().getTypeTypeBParserRuleCall_1_0()); 
			pushFollow(FOLLOW_2);
			ruleTypeB();
			state._fsp--;

			 after(grammarAccess.getDynamicAccess().getTypeTypeBParserRuleCall_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Dynamic__TypeAssignment_1"



	// $ANTLR start "rule__TypeA__TypeAssignment"
	// InternalMyDsl.g:1056:1: rule__TypeA__TypeAssignment : ( ( 'type' ) ) ;
	public final void rule__TypeA__TypeAssignment() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:1060:1: ( ( ( 'type' ) ) )
			// InternalMyDsl.g:1061:1: ( ( 'type' ) )
			{
			// InternalMyDsl.g:1061:1: ( ( 'type' ) )
			// InternalMyDsl.g:1062:1: ( 'type' )
			{
			 before(grammarAccess.getTypeAAccess().getTypeTypeKeyword_0()); 
			// InternalMyDsl.g:1064:1: ( 'type' )
			// InternalMyDsl.g:1065:1: 'type'
			{
			 before(grammarAccess.getTypeAAccess().getTypeTypeKeyword_0()); 
			match(input,17,FOLLOW_2); 
			 after(grammarAccess.getTypeAAccess().getTypeTypeKeyword_0()); 
			}

			 after(grammarAccess.getTypeAAccess().getTypeTypeKeyword_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__TypeA__TypeAssignment"



	// $ANTLR start "rule__TypeB__TypeAssignment"
	// InternalMyDsl.g:1082:1: rule__TypeB__TypeAssignment : ( ( 'type' ) ) ;
	public final void rule__TypeB__TypeAssignment() throws RecognitionException {

				int stackSize = keepStackSize();
		    
		try {
			// InternalMyDsl.g:1086:1: ( ( ( 'type' ) ) )
			// InternalMyDsl.g:1087:1: ( ( 'type' ) )
			{
			// InternalMyDsl.g:1087:1: ( ( 'type' ) )
			// InternalMyDsl.g:1088:1: ( 'type' )
			{
			 before(grammarAccess.getTypeBAccess().getTypeTypeKeyword_0()); 
			// InternalMyDsl.g:1090:1: ( 'type' )
			// InternalMyDsl.g:1091:1: 'type'
			{
			 before(grammarAccess.getTypeBAccess().getTypeTypeKeyword_0()); 
			match(input,17,FOLLOW_2); 
			 after(grammarAccess.getTypeBAccess().getTypeTypeKeyword_0()); 
			}

			 after(grammarAccess.getTypeBAccess().getTypeTypeKeyword_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__TypeB__TypeAssignment"

	// Delegated rules



	public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000000003C000L});
	public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000034000L});
	public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000024000L});
	public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000004002L});
}
