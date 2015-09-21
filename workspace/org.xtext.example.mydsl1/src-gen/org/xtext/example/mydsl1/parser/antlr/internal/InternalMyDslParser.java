package org.xtext.example.mydsl1.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.mydsl1.services.MyDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyDslParser extends AbstractInternalAntlrParser {
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
	public AbstractInternalAntlrParser[] getDelegates() {
		return new AbstractInternalAntlrParser[] {};
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
	 	
	    public InternalMyDslParser(TokenStream input, MyDslGrammarAccess grammarAccess) {
	        this(input);
	        this.grammarAccess = grammarAccess;
	        registerRules(grammarAccess.getGrammar());
	    }
	    
	    @Override
	    protected String getFirstRuleName() {
	    	return "Model";	
	   	}
	   	
	   	@Override
	   	protected MyDslGrammarAccess getGrammarAccess() {
	   		return grammarAccess;
	   	}



	// $ANTLR start "entryRuleModel"
	// InternalMyDsl.g:70:1: entryRuleModel returns [EObject current=null] :iv_ruleModel= ruleModel EOF ;
	public final EObject entryRuleModel() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleModel =null;

		try {
			// InternalMyDsl.g:71:2: (iv_ruleModel= ruleModel EOF )
			// InternalMyDsl.g:72:2: iv_ruleModel= ruleModel EOF
			{
			 newCompositeNode(grammarAccess.getModelRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleModel=ruleModel();
			state._fsp--;

			 current =iv_ruleModel; 
			match(input,EOF,FOLLOW_2); 
			}

		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleModel"



	// $ANTLR start "ruleModel"
	// InternalMyDsl.g:79:1: ruleModel returns [EObject current=null] : ( () ( (lv_greetings_1_0= ruleGreeting ) )+ ) ;
	public final EObject ruleModel() throws RecognitionException {
		EObject current = null;


		EObject lv_greetings_1_0 =null;

		 enterRule();
		   		
		    
		try {
			// InternalMyDsl.g:85:7: ( ( () ( (lv_greetings_1_0= ruleGreeting ) )+ ) )
			// InternalMyDsl.g:87:5: ( () ( (lv_greetings_1_0= ruleGreeting ) )+ )
			{
			// InternalMyDsl.g:87:5: ( () ( (lv_greetings_1_0= ruleGreeting ) )+ )
			// InternalMyDsl.g:88:5: () ( (lv_greetings_1_0= ruleGreeting ) )+
			{
			// InternalMyDsl.g:88:5: ()
			// InternalMyDsl.g:89:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getModelAccess().getModelAction_0(),
			            current);
			    
			}

			// InternalMyDsl.g:97:3: ( (lv_greetings_1_0= ruleGreeting ) )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==12) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// InternalMyDsl.g:98:3: (lv_greetings_1_0= ruleGreeting )
					{
					// InternalMyDsl.g:98:3: (lv_greetings_1_0= ruleGreeting )
					// InternalMyDsl.g:99:3: lv_greetings_1_0= ruleGreeting
					{
					 
						        newCompositeNode(grammarAccess.getModelAccess().getGreetingsGreetingParserRuleCall_1_0()); 
						    
					pushFollow(FOLLOW_3);
					lv_greetings_1_0=ruleGreeting();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getModelRule());
						        }
					       		add(
					       			current, 
					       			"greetings",
					        		lv_greetings_1_0, 
					        		"org.xtext.example.mydsl1.MyDsl.Greeting");
						        afterParserOrEnumRuleCall();
						    
					}

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

			}

			 leaveRule();
			    		
			     
		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleModel"



	// $ANTLR start "entryRuleGreeting"
	// InternalMyDsl.g:127:1: entryRuleGreeting returns [EObject current=null] :iv_ruleGreeting= ruleGreeting EOF ;
	public final EObject entryRuleGreeting() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleGreeting =null;

		try {
			// InternalMyDsl.g:128:2: (iv_ruleGreeting= ruleGreeting EOF )
			// InternalMyDsl.g:129:2: iv_ruleGreeting= ruleGreeting EOF
			{
			 newCompositeNode(grammarAccess.getGreetingRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleGreeting=ruleGreeting();
			state._fsp--;

			 current =iv_ruleGreeting; 
			match(input,EOF,FOLLOW_2); 
			}

		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleGreeting"



	// $ANTLR start "ruleGreeting"
	// InternalMyDsl.g:136:1: ruleGreeting returns [EObject current=null] : ( () otherlv_1= 'Hello' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '!' ( (lv_test_4_0= ruleTest ) ) ( rulePre )? ( (lv_reset_6_0= ruleReset ) )? ( (lv_inc_7_0= ruleInc ) )* ( (lv_dynamic_8_0= ruleDynamic ) )? ) ;
	public final EObject ruleGreeting() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token lv_name_2_0=null;
		Token otherlv_3=null;
		EObject lv_test_4_0 =null;
		EObject lv_reset_6_0 =null;
		EObject lv_inc_7_0 =null;
		EObject lv_dynamic_8_0 =null;

		 enterRule();
		   		System.out.println("Greeting - initRuleAction");
		    
		try {
			// InternalMyDsl.g:142:7: ( ( () otherlv_1= 'Hello' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '!' ( (lv_test_4_0= ruleTest ) ) ( rulePre )? ( (lv_reset_6_0= ruleReset ) )? ( (lv_inc_7_0= ruleInc ) )* ( (lv_dynamic_8_0= ruleDynamic ) )? ) )
			// InternalMyDsl.g:144:5: ( () otherlv_1= 'Hello' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '!' ( (lv_test_4_0= ruleTest ) ) ( rulePre )? ( (lv_reset_6_0= ruleReset ) )? ( (lv_inc_7_0= ruleInc ) )* ( (lv_dynamic_8_0= ruleDynamic ) )? )
			{
			// InternalMyDsl.g:144:5: ( () otherlv_1= 'Hello' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '!' ( (lv_test_4_0= ruleTest ) ) ( rulePre )? ( (lv_reset_6_0= ruleReset ) )? ( (lv_inc_7_0= ruleInc ) )* ( (lv_dynamic_8_0= ruleDynamic ) )? )
			// InternalMyDsl.g:145:5: () otherlv_1= 'Hello' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '!' ( (lv_test_4_0= ruleTest ) ) ( rulePre )? ( (lv_reset_6_0= ruleReset ) )? ( (lv_inc_7_0= ruleInc ) )* ( (lv_dynamic_8_0= ruleDynamic ) )?
			{
			// InternalMyDsl.g:145:5: ()
			// InternalMyDsl.g:146:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getGreetingAccess().getGreetingAction_0(),
			            current);
			    
			}

			otherlv_1=(Token)match(input,12,FOLLOW_4); 

			    	newLeafNode(otherlv_1, grammarAccess.getGreetingAccess().getHelloKeyword_1());
			    
			// InternalMyDsl.g:161:3: ( (lv_name_2_0= RULE_ID ) )
			// InternalMyDsl.g:162:3: (lv_name_2_0= RULE_ID )
			{
			// InternalMyDsl.g:162:3: (lv_name_2_0= RULE_ID )
			// InternalMyDsl.g:163:3: lv_name_2_0= RULE_ID
			{
			lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_5); 

						newLeafNode(lv_name_2_0, grammarAccess.getGreetingAccess().getNameIDTerminalRuleCall_2_0()); 
					

				        if (current==null) {
				            current = createModelElement(grammarAccess.getGreetingRule());
				        }
			       		setWithLastConsumed(
			       			current, 
			       			"name",
			        		lv_name_2_0, 
			        		"org.eclipse.xtext.common.Terminals.ID");
				    
			}

			}

			System.out.println("preAction-Hello");
			otherlv_3=(Token)match(input,11,FOLLOW_6); 

			    	newLeafNode(otherlv_3, grammarAccess.getGreetingAccess().getExclamationMarkKeyword_3());
			    
			System.out.println("postAction-Hello");
			// InternalMyDsl.g:191:3: ( (lv_test_4_0= ruleTest ) )
			// InternalMyDsl.g:192:3: (lv_test_4_0= ruleTest )
			{
			// InternalMyDsl.g:192:3: (lv_test_4_0= ruleTest )
			// InternalMyDsl.g:193:3: lv_test_4_0= ruleTest
			{
			 
				        newCompositeNode(grammarAccess.getGreetingAccess().getTestTestParserRuleCall_4_0()); 
				    
			pushFollow(FOLLOW_7);
			lv_test_4_0=ruleTest();
			state._fsp--;


				        if (current==null) {
				            current = createModelElementForParent(grammarAccess.getGreetingRule());
				        }
			       		set(
			       			current, 
			       			"test",
			        		lv_test_4_0, 
			        		"org.xtext.example.mydsl1.MyDsl.Test");
				        afterParserOrEnumRuleCall();
				    
			}

			}

			// InternalMyDsl.g:212:5: ( rulePre )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==15) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// InternalMyDsl.g:213:5: rulePre
					{
					 
					        newCompositeNode(grammarAccess.getGreetingAccess().getPreParserRuleCall_5()); 
					    
					pushFollow(FOLLOW_8);
					rulePre();
					state._fsp--;

					 
					        afterParserOrEnumRuleCall();
					    
					}
					break;

			}

			// InternalMyDsl.g:223:3: ( (lv_reset_6_0= ruleReset ) )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==16) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// InternalMyDsl.g:224:3: (lv_reset_6_0= ruleReset )
					{
					// InternalMyDsl.g:224:3: (lv_reset_6_0= ruleReset )
					// InternalMyDsl.g:225:3: lv_reset_6_0= ruleReset
					{
					 
						        newCompositeNode(grammarAccess.getGreetingAccess().getResetResetParserRuleCall_6_0()); 
						    
					pushFollow(FOLLOW_9);
					lv_reset_6_0=ruleReset();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getGreetingRule());
						        }
					       		set(
					       			current, 
					       			"reset",
					        		lv_reset_6_0, 
					        		"org.xtext.example.mydsl1.MyDsl.Reset");
						        afterParserOrEnumRuleCall();
						    
					}

					}
					break;

			}

			// InternalMyDsl.g:244:3: ( (lv_inc_7_0= ruleInc ) )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==14) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// InternalMyDsl.g:245:3: (lv_inc_7_0= ruleInc )
					{
					// InternalMyDsl.g:245:3: (lv_inc_7_0= ruleInc )
					// InternalMyDsl.g:246:3: lv_inc_7_0= ruleInc
					{
					 
						        newCompositeNode(grammarAccess.getGreetingAccess().getIncIncParserRuleCall_7_0()); 
						    
					pushFollow(FOLLOW_9);
					lv_inc_7_0=ruleInc();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getGreetingRule());
						        }
					       		add(
					       			current, 
					       			"inc",
					        		lv_inc_7_0, 
					        		"org.xtext.example.mydsl1.MyDsl.Inc");
						        afterParserOrEnumRuleCall();
						    
					}

					}
					break;

				default :
					break loop4;
				}
			}

			// InternalMyDsl.g:265:3: ( (lv_dynamic_8_0= ruleDynamic ) )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==17) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// InternalMyDsl.g:266:3: (lv_dynamic_8_0= ruleDynamic )
					{
					// InternalMyDsl.g:266:3: (lv_dynamic_8_0= ruleDynamic )
					// InternalMyDsl.g:267:3: lv_dynamic_8_0= ruleDynamic
					{
					 
						        newCompositeNode(grammarAccess.getGreetingAccess().getDynamicDynamicParserRuleCall_8_0()); 
						    
					pushFollow(FOLLOW_2);
					lv_dynamic_8_0=ruleDynamic();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getGreetingRule());
						        }
					       		set(
					       			current, 
					       			"dynamic",
					        		lv_dynamic_8_0, 
					        		"org.xtext.example.mydsl1.MyDsl.Dynamic");
						        afterParserOrEnumRuleCall();
						    
					}

					}
					break;

			}

			}

			}

			 leaveRule();
			    		System.out.println("Greeting - afterRuleaction");
			     
		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleGreeting"



	// $ANTLR start "entryRuleTest"
	// InternalMyDsl.g:295:1: entryRuleTest returns [EObject current=null] :iv_ruleTest= ruleTest EOF ;
	public final EObject entryRuleTest() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleTest =null;

		try {
			// InternalMyDsl.g:296:2: (iv_ruleTest= ruleTest EOF )
			// InternalMyDsl.g:297:2: iv_ruleTest= ruleTest EOF
			{
			 newCompositeNode(grammarAccess.getTestRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleTest=ruleTest();
			state._fsp--;

			 current =iv_ruleTest; 
			match(input,EOF,FOLLOW_2); 
			}

		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleTest"



	// $ANTLR start "ruleTest"
	// InternalMyDsl.g:304:1: ruleTest returns [EObject current=null] : (otherlv_0= 'Test' ( (lv_name_1_0= RULE_ID ) ) ) ;
	public final EObject ruleTest() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		Token lv_name_1_0=null;

		 enterRule();
		   		System.out.println("test-in");
		    
		try {
			// InternalMyDsl.g:310:7: ( (otherlv_0= 'Test' ( (lv_name_1_0= RULE_ID ) ) ) )
			// InternalMyDsl.g:312:2: (otherlv_0= 'Test' ( (lv_name_1_0= RULE_ID ) ) )
			{
			// InternalMyDsl.g:312:2: (otherlv_0= 'Test' ( (lv_name_1_0= RULE_ID ) ) )
			// InternalMyDsl.g:313:2: otherlv_0= 'Test' ( (lv_name_1_0= RULE_ID ) )
			{
			otherlv_0=(Token)match(input,13,FOLLOW_4); 

			    	newLeafNode(otherlv_0, grammarAccess.getTestAccess().getTestKeyword_0());
			    
			System.out.println("preAction-Test");
			// InternalMyDsl.g:321:3: ( (lv_name_1_0= RULE_ID ) )
			// InternalMyDsl.g:322:3: (lv_name_1_0= RULE_ID )
			{
			// InternalMyDsl.g:322:3: (lv_name_1_0= RULE_ID )
			// InternalMyDsl.g:323:3: lv_name_1_0= RULE_ID
			{
			lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

						newLeafNode(lv_name_1_0, grammarAccess.getTestAccess().getNameIDTerminalRuleCall_1_0()); 
					

				        if (current==null) {
				            current = createModelElement(grammarAccess.getTestRule());
				        }
			       		setWithLastConsumed(
			       			current, 
			       			"name",
			        		lv_name_1_0, 
			        		"org.eclipse.xtext.common.Terminals.ID");
				    
			}

			}

			System.out.println("postAction-Test");
			}

			}

			 leaveRule();
			    		
			     
		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleTest"



	// $ANTLR start "entryRulePre"
	// InternalMyDsl.g:352:1: entryRulePre returns [String current=null] :iv_rulePre= rulePre EOF ;
	public final String entryRulePre() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_rulePre =null;

		try {
			// InternalMyDsl.g:353:2: (iv_rulePre= rulePre EOF )
			// InternalMyDsl.g:354:2: iv_rulePre= rulePre EOF
			{
			 newCompositeNode(grammarAccess.getPreRule()); 
			pushFollow(FOLLOW_1);
			iv_rulePre=rulePre();
			state._fsp--;

			 current =iv_rulePre.getText(); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRulePre"



	// $ANTLR start "rulePre"
	// InternalMyDsl.g:361:1: rulePre returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'pre' ;
	public final AntlrDatatypeRuleToken rulePre() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;

		 enterRule(); 
		    
		try {
			// InternalMyDsl.g:364:28: (kw= 'pre' )
			// InternalMyDsl.g:366:2: kw= 'pre'
			{
			kw=(Token)match(input,15,FOLLOW_2); 

			        current.merge(kw);
			        newLeafNode(kw, grammarAccess.getPreAccess().getPreKeyword()); 
			    
			}

			 leaveRule(); 
		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "rulePre"



	// $ANTLR start "entryRuleReset"
	// InternalMyDsl.g:379:1: entryRuleReset returns [EObject current=null] :iv_ruleReset= ruleReset EOF ;
	public final EObject entryRuleReset() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleReset =null;

		try {
			// InternalMyDsl.g:380:2: (iv_ruleReset= ruleReset EOF )
			// InternalMyDsl.g:381:2: iv_ruleReset= ruleReset EOF
			{
			 newCompositeNode(grammarAccess.getResetRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleReset=ruleReset();
			state._fsp--;

			 current =iv_ruleReset; 
			match(input,EOF,FOLLOW_2); 
			}

		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleReset"



	// $ANTLR start "ruleReset"
	// InternalMyDsl.g:388:1: ruleReset returns [EObject current=null] : ( (lv_reset_0_0= 'reset' ) ) ;
	public final EObject ruleReset() throws RecognitionException {
		EObject current = null;


		Token lv_reset_0_0=null;

		 enterRule();
		   		
		    
		try {
			// InternalMyDsl.g:394:7: ( ( (lv_reset_0_0= 'reset' ) ) )
			// InternalMyDsl.g:396:3: ( (lv_reset_0_0= 'reset' ) )
			{
			// InternalMyDsl.g:396:3: ( (lv_reset_0_0= 'reset' ) )
			// InternalMyDsl.g:397:3: (lv_reset_0_0= 'reset' )
			{
			// InternalMyDsl.g:397:3: (lv_reset_0_0= 'reset' )
			// InternalMyDsl.g:398:3: lv_reset_0_0= 'reset'
			{
			lv_reset_0_0=(Token)match(input,16,FOLLOW_2); 

			        newLeafNode(lv_reset_0_0, grammarAccess.getResetAccess().getResetResetKeyword_0());
			    

				        if (current==null) {
				            current = createModelElement(grammarAccess.getResetRule());
				        }
			       		setWithLastConsumed(current, "reset", lv_reset_0_0, "reset");
				    
			}

			}

			org.xtext.example.mydsl1.TestScope.reset();
			}

			 leaveRule();
			    		
			     
		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleReset"



	// $ANTLR start "entryRuleInc"
	// InternalMyDsl.g:425:1: entryRuleInc returns [EObject current=null] :iv_ruleInc= ruleInc EOF ;
	public final EObject entryRuleInc() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleInc =null;

		try {
			// InternalMyDsl.g:426:2: (iv_ruleInc= ruleInc EOF )
			// InternalMyDsl.g:427:2: iv_ruleInc= ruleInc EOF
			{
			 newCompositeNode(grammarAccess.getIncRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleInc=ruleInc();
			state._fsp--;

			 current =iv_ruleInc; 
			match(input,EOF,FOLLOW_2); 
			}

		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleInc"



	// $ANTLR start "ruleInc"
	// InternalMyDsl.g:434:1: ruleInc returns [EObject current=null] : ( (lv_inc_0_0= 'inc' ) ) ;
	public final EObject ruleInc() throws RecognitionException {
		EObject current = null;


		Token lv_inc_0_0=null;

		 enterRule();
		   		
		    
		try {
			// InternalMyDsl.g:440:7: ( ( (lv_inc_0_0= 'inc' ) ) )
			// InternalMyDsl.g:442:3: ( (lv_inc_0_0= 'inc' ) )
			{
			// InternalMyDsl.g:442:3: ( (lv_inc_0_0= 'inc' ) )
			// InternalMyDsl.g:443:3: (lv_inc_0_0= 'inc' )
			{
			// InternalMyDsl.g:443:3: (lv_inc_0_0= 'inc' )
			// InternalMyDsl.g:444:3: lv_inc_0_0= 'inc'
			{
			lv_inc_0_0=(Token)match(input,14,FOLLOW_2); 

			        newLeafNode(lv_inc_0_0, grammarAccess.getIncAccess().getIncIncKeyword_0());
			    

				        if (current==null) {
				            current = createModelElement(grammarAccess.getIncRule());
				        }
			       		setWithLastConsumed(current, "inc", lv_inc_0_0, "inc");
				    
			}

			}

			org.xtext.example.mydsl1.TestScope.inc();
			}

			 leaveRule();
			    		
			     
		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleInc"



	// $ANTLR start "entryRuleDynamic"
	// InternalMyDsl.g:471:1: entryRuleDynamic returns [EObject current=null] :iv_ruleDynamic= ruleDynamic EOF ;
	public final EObject entryRuleDynamic() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleDynamic =null;

		try {
			// InternalMyDsl.g:472:2: (iv_ruleDynamic= ruleDynamic EOF )
			// InternalMyDsl.g:473:2: iv_ruleDynamic= ruleDynamic EOF
			{
			 newCompositeNode(grammarAccess.getDynamicRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleDynamic=ruleDynamic();
			state._fsp--;

			 current =iv_ruleDynamic; 
			match(input,EOF,FOLLOW_2); 
			}

		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleDynamic"



	// $ANTLR start "ruleDynamic"
	// InternalMyDsl.g:480:1: ruleDynamic returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeA ) ) | ( (lv_type_1_0= ruleTypeB ) ) ) ;
	public final EObject ruleDynamic() throws RecognitionException {
		EObject current = null;


		EObject lv_type_0_0 =null;
		EObject lv_type_1_0 =null;

		 enterRule();
		   		
		    
		try {
			// InternalMyDsl.g:486:7: ( ( ( (lv_type_0_0= ruleTypeA ) ) | ( (lv_type_1_0= ruleTypeB ) ) ) )
			// InternalMyDsl.g:488:3: ( ( (lv_type_0_0= ruleTypeA ) ) | ( (lv_type_1_0= ruleTypeB ) ) )
			{
			// InternalMyDsl.g:488:3: ( ( (lv_type_0_0= ruleTypeA ) ) | ( (lv_type_1_0= ruleTypeB ) ) )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==17) ) {
				int LA6_1 = input.LA(2);
				if ( (!(((org.xtext.example.mydsl1.TestScope.isValid())))) ) {
					alt6=1;
				}
				else if ( ((org.xtext.example.mydsl1.TestScope.isValid())) ) {
					alt6=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 6, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// InternalMyDsl.g:489:3: ( (lv_type_0_0= ruleTypeA ) )
					{
					// InternalMyDsl.g:489:3: ( (lv_type_0_0= ruleTypeA ) )
					// InternalMyDsl.g:490:3: (lv_type_0_0= ruleTypeA )
					{
					// InternalMyDsl.g:490:3: (lv_type_0_0= ruleTypeA )
					// InternalMyDsl.g:491:3: lv_type_0_0= ruleTypeA
					{
					 
						        newCompositeNode(grammarAccess.getDynamicAccess().getTypeTypeAParserRuleCall_0_0()); 
						    
					pushFollow(FOLLOW_2);
					lv_type_0_0=ruleTypeA();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getDynamicRule());
						        }
					       		set(
					       			current, 
					       			"type",
					        		lv_type_0_0, 
					        		"org.xtext.example.mydsl1.MyDsl.TypeA");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;
				case 2 :
					// InternalMyDsl.g:511:3: ( (lv_type_1_0= ruleTypeB ) )
					{
					// InternalMyDsl.g:511:3: ( (lv_type_1_0= ruleTypeB ) )
					// InternalMyDsl.g:512:3: (lv_type_1_0= ruleTypeB )
					{
					// InternalMyDsl.g:512:3: (lv_type_1_0= ruleTypeB )
					// InternalMyDsl.g:513:3: lv_type_1_0= ruleTypeB
					{
					 
						        newCompositeNode(grammarAccess.getDynamicAccess().getTypeTypeBParserRuleCall_1_0()); 
						    
					pushFollow(FOLLOW_2);
					lv_type_1_0=ruleTypeB();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getDynamicRule());
						        }
					       		set(
					       			current, 
					       			"type",
					        		lv_type_1_0, 
					        		"org.xtext.example.mydsl1.MyDsl.TypeB");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;

			}

			}

			 leaveRule();
			    		
			     
		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleDynamic"



	// $ANTLR start "entryRuleTypeA"
	// InternalMyDsl.g:541:1: entryRuleTypeA returns [EObject current=null] :iv_ruleTypeA= ruleTypeA EOF ;
	public final EObject entryRuleTypeA() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleTypeA =null;

		try {
			// InternalMyDsl.g:542:2: (iv_ruleTypeA= ruleTypeA EOF )
			// InternalMyDsl.g:543:2: iv_ruleTypeA= ruleTypeA EOF
			{
			 newCompositeNode(grammarAccess.getTypeARule()); 
			pushFollow(FOLLOW_1);
			iv_ruleTypeA=ruleTypeA();
			state._fsp--;

			 current =iv_ruleTypeA; 
			match(input,EOF,FOLLOW_2); 
			}

		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleTypeA"



	// $ANTLR start "ruleTypeA"
	// InternalMyDsl.g:550:1: ruleTypeA returns [EObject current=null] : ( (lv_type_0_0= 'type' ) ) ;
	public final EObject ruleTypeA() throws RecognitionException {
		EObject current = null;


		Token lv_type_0_0=null;

		 enterRule();
		   		
		    
		try {
			// InternalMyDsl.g:556:7: ( ( (lv_type_0_0= 'type' ) ) )
			// InternalMyDsl.g:558:3: ( (lv_type_0_0= 'type' ) )
			{
			// InternalMyDsl.g:558:3: ( (lv_type_0_0= 'type' ) )
			// InternalMyDsl.g:559:3: (lv_type_0_0= 'type' )
			{
			// InternalMyDsl.g:559:3: (lv_type_0_0= 'type' )
			// InternalMyDsl.g:560:3: lv_type_0_0= 'type'
			{
			lv_type_0_0=(Token)match(input,17,FOLLOW_2); 

			        newLeafNode(lv_type_0_0, grammarAccess.getTypeAAccess().getTypeTypeKeyword_0());
			    

				        if (current==null) {
				            current = createModelElement(grammarAccess.getTypeARule());
				        }
			       		setWithLastConsumed(current, "type", lv_type_0_0, "type");
				    
			}

			}

			System.out.println("TypeA");
			}

			 leaveRule();
			    		
			     
		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleTypeA"



	// $ANTLR start "entryRuleTypeB"
	// InternalMyDsl.g:587:1: entryRuleTypeB returns [EObject current=null] :iv_ruleTypeB= ruleTypeB EOF ;
	public final EObject entryRuleTypeB() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleTypeB =null;

		try {
			// InternalMyDsl.g:588:2: (iv_ruleTypeB= ruleTypeB EOF )
			// InternalMyDsl.g:589:2: iv_ruleTypeB= ruleTypeB EOF
			{
			 newCompositeNode(grammarAccess.getTypeBRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleTypeB=ruleTypeB();
			state._fsp--;

			 current =iv_ruleTypeB; 
			match(input,EOF,FOLLOW_2); 
			}

		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleTypeB"



	// $ANTLR start "ruleTypeB"
	// InternalMyDsl.g:596:1: ruleTypeB returns [EObject current=null] :{...}? ( (lv_type_0_0= 'type' ) ) ;
	public final EObject ruleTypeB() throws RecognitionException {
		EObject current = null;


		Token lv_type_0_0=null;

		 enterRule();
		   		
		    
		try {
			// InternalMyDsl.g:602:7: ({...}? ( (lv_type_0_0= 'type' ) ) )
			// InternalMyDsl.g:603:1: {...}? ( (lv_type_0_0= 'type' ) )
			{
			if ( !((org.xtext.example.mydsl1.TestScope.isValid())) ) {
				throw new FailedPredicateException(input, "ruleTypeB", "org.xtext.example.mydsl1.TestScope.isValid()");
			}
			// InternalMyDsl.g:605:3: ( (lv_type_0_0= 'type' ) )
			// InternalMyDsl.g:606:3: (lv_type_0_0= 'type' )
			{
			// InternalMyDsl.g:606:3: (lv_type_0_0= 'type' )
			// InternalMyDsl.g:607:3: lv_type_0_0= 'type'
			{
			lv_type_0_0=(Token)match(input,17,FOLLOW_2); 

			        newLeafNode(lv_type_0_0, grammarAccess.getTypeBAccess().getTypeTypeKeyword_0());
			    

				        if (current==null) {
				            current = createModelElement(grammarAccess.getTypeBRule());
				        }
			       		setWithLastConsumed(current, "type", lv_type_0_0, "type");
				    
			}

			}

			System.out.println("TypeB");
			}

			 leaveRule();
			    		
			     
		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleTypeB"

	// Delegated rules



	public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000003C002L});
	public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000034002L});
	public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000024002L});
}
