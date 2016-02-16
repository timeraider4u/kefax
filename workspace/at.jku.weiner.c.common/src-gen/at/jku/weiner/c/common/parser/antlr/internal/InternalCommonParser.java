package at.jku.weiner.c.common.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import at.jku.weiner.c.common.services.CommonGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCommonParser extends AbstractInternalAntlrParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_BIN_LITERAL", "RULE_BLOCK_COMMENT", 
		"RULE_CARRIAGERETURN", "RULE_CHAR_LITERAL", "RULE_DECIMAL_LITERAL", "RULE_ESCAPE_SEQUENCE", 
		"RULE_EXPONENT", "RULE_FLOAT_LITERAL", "RULE_FLOAT_TYPE_SUFFIX", "RULE_HEX_DIGIT", 
		"RULE_HEX_ESCAPE", "RULE_HEX_LITERAL", "RULE_ID", "RULE_IDENTIFIER", "RULE_INTEGER_TYPE_SUFFIX", 
		"RULE_LETTER", "RULE_LINEBREAK", "RULE_LINEFEED", "RULE_LINE_COMMENT", 
		"RULE_LINE_END", "RULE_LONG_LONG_SUFFIX", "RULE_LONG_SUFFIX", "RULE_NEWLINE", 
		"RULE_OCTAL_ESCAPE", "RULE_OCTAL_LITERAL", "RULE_SKW_AND", "RULE_SKW_ANDAND", 
		"RULE_SKW_ASSIGN", "RULE_SKW_BACKSLASH", "RULE_SKW_CARET", "RULE_SKW_COLON", 
		"RULE_SKW_COMMA", "RULE_SKW_DIV", "RULE_SKW_DOLLAR", "RULE_SKW_DOT", "RULE_SKW_DOUBLEQUOTE", 
		"RULE_SKW_EQUAL", "RULE_SKW_GREATER", "RULE_SKW_GREATEREQUAL", "RULE_SKW_LEFTBRACE", 
		"RULE_SKW_LEFTBRACKET", "RULE_SKW_LEFTPAREN", "RULE_SKW_LEFTSHIFT", "RULE_SKW_LESS", 
		"RULE_SKW_LESSEQUAL", "RULE_SKW_MINUS", "RULE_SKW_MINUSMINUS", "RULE_SKW_MOD", 
		"RULE_SKW_NOT", "RULE_SKW_NOTEQUAL", "RULE_SKW_OR", "RULE_SKW_OROR", "RULE_SKW_PLUS", 
		"RULE_SKW_PLUSPLUS", "RULE_SKW_QUESTION", "RULE_SKW_RIGHTBRACE", "RULE_SKW_RIGHTBRACKET", 
		"RULE_SKW_RIGHTPAREN", "RULE_SKW_RIGHTSHIFT", "RULE_SKW_SEMI", "RULE_SKW_SINGLEQUOTE", 
		"RULE_SKW_STAR", "RULE_SKW_TILDE", "RULE_SKW_UNDERSCORE", "RULE_SPACE", 
		"RULE_SPECIAL", "RULE_STRING_LITERAL", "RULE_TAB", "RULE_UNSIGNED_SUFFIX", 
		"RULE_WHITESPACE"
	};
	public static final int EOF=-1;
	public static final int RULE_BIN_LITERAL=4;
	public static final int RULE_BLOCK_COMMENT=5;
	public static final int RULE_CARRIAGERETURN=6;
	public static final int RULE_CHAR_LITERAL=7;
	public static final int RULE_DECIMAL_LITERAL=8;
	public static final int RULE_ESCAPE_SEQUENCE=9;
	public static final int RULE_EXPONENT=10;
	public static final int RULE_FLOAT_LITERAL=11;
	public static final int RULE_FLOAT_TYPE_SUFFIX=12;
	public static final int RULE_HEX_DIGIT=13;
	public static final int RULE_HEX_ESCAPE=14;
	public static final int RULE_HEX_LITERAL=15;
	public static final int RULE_ID=16;
	public static final int RULE_IDENTIFIER=17;
	public static final int RULE_INTEGER_TYPE_SUFFIX=18;
	public static final int RULE_LETTER=19;
	public static final int RULE_LINEBREAK=20;
	public static final int RULE_LINEFEED=21;
	public static final int RULE_LINE_COMMENT=22;
	public static final int RULE_LINE_END=23;
	public static final int RULE_LONG_LONG_SUFFIX=24;
	public static final int RULE_LONG_SUFFIX=25;
	public static final int RULE_NEWLINE=26;
	public static final int RULE_OCTAL_ESCAPE=27;
	public static final int RULE_OCTAL_LITERAL=28;
	public static final int RULE_SKW_AND=29;
	public static final int RULE_SKW_ANDAND=30;
	public static final int RULE_SKW_ASSIGN=31;
	public static final int RULE_SKW_BACKSLASH=32;
	public static final int RULE_SKW_CARET=33;
	public static final int RULE_SKW_COLON=34;
	public static final int RULE_SKW_COMMA=35;
	public static final int RULE_SKW_DIV=36;
	public static final int RULE_SKW_DOLLAR=37;
	public static final int RULE_SKW_DOT=38;
	public static final int RULE_SKW_DOUBLEQUOTE=39;
	public static final int RULE_SKW_EQUAL=40;
	public static final int RULE_SKW_GREATER=41;
	public static final int RULE_SKW_GREATEREQUAL=42;
	public static final int RULE_SKW_LEFTBRACE=43;
	public static final int RULE_SKW_LEFTBRACKET=44;
	public static final int RULE_SKW_LEFTPAREN=45;
	public static final int RULE_SKW_LEFTSHIFT=46;
	public static final int RULE_SKW_LESS=47;
	public static final int RULE_SKW_LESSEQUAL=48;
	public static final int RULE_SKW_MINUS=49;
	public static final int RULE_SKW_MINUSMINUS=50;
	public static final int RULE_SKW_MOD=51;
	public static final int RULE_SKW_NOT=52;
	public static final int RULE_SKW_NOTEQUAL=53;
	public static final int RULE_SKW_OR=54;
	public static final int RULE_SKW_OROR=55;
	public static final int RULE_SKW_PLUS=56;
	public static final int RULE_SKW_PLUSPLUS=57;
	public static final int RULE_SKW_QUESTION=58;
	public static final int RULE_SKW_RIGHTBRACE=59;
	public static final int RULE_SKW_RIGHTBRACKET=60;
	public static final int RULE_SKW_RIGHTPAREN=61;
	public static final int RULE_SKW_RIGHTSHIFT=62;
	public static final int RULE_SKW_SEMI=63;
	public static final int RULE_SKW_SINGLEQUOTE=64;
	public static final int RULE_SKW_STAR=65;
	public static final int RULE_SKW_TILDE=66;
	public static final int RULE_SKW_UNDERSCORE=67;
	public static final int RULE_SPACE=68;
	public static final int RULE_SPECIAL=69;
	public static final int RULE_STRING_LITERAL=70;
	public static final int RULE_TAB=71;
	public static final int RULE_UNSIGNED_SUFFIX=72;
	public static final int RULE_WHITESPACE=73;

	// delegates
	public AbstractInternalAntlrParser[] getDelegates() {
		return new AbstractInternalAntlrParser[] {};
	}

	// delegators


	public InternalCommonParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public InternalCommonParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return InternalCommonParser.tokenNames; }
	@Override public String getGrammarFileName() { return "InternalCommon.g"; }



	 	private CommonGrammarAccess grammarAccess;
	 	
	    public InternalCommonParser(TokenStream input, CommonGrammarAccess grammarAccess) {
	        this(input);
	        this.grammarAccess = grammarAccess;
	        registerRules(grammarAccess.getGrammar());
	    }
	    
	    @Override
	    protected String getFirstRuleName() {
	    	return "Expression";	
	   	}
	   	
	   	@Override
	   	protected CommonGrammarAccess getGrammarAccess() {
	   		return grammarAccess;
	   	}



	// $ANTLR start "entryRuleExpression"
	// InternalCommon.g:68:1: entryRuleExpression returns [EObject current=null] :iv_ruleExpression= ruleExpression EOF ;
	public final EObject entryRuleExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleExpression =null;

		 
				HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WHITESPACE", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT", "RULE_LINEBREAK");
			
		try {
			// InternalCommon.g:72:2: (iv_ruleExpression= ruleExpression EOF )
			// InternalCommon.g:73:2: iv_ruleExpression= ruleExpression EOF
			{
			 newCompositeNode(grammarAccess.getExpressionRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleExpression=ruleExpression();
			state._fsp--;

			 current =iv_ruleExpression; 
			match(input,EOF,FOLLOW_2); 
			}

		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving

				myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "entryRuleExpression"



	// $ANTLR start "ruleExpression"
	// InternalCommon.g:83:1: ruleExpression returns [EObject current=null] :this_ConditionalExpression_0= ruleConditionalExpression ;
	public final EObject ruleExpression() throws RecognitionException {
		EObject current = null;


		EObject this_ConditionalExpression_0 =null;

		 enterRule();
		   		/*no init found*/
				HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WHITESPACE", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT", "RULE_LINEBREAK");
		    
		try {
			// InternalCommon.g:90:7: (this_ConditionalExpression_0= ruleConditionalExpression )
			// InternalCommon.g:93:5: this_ConditionalExpression_0= ruleConditionalExpression
			{
			 
			        newCompositeNode(grammarAccess.getExpressionAccess().getConditionalExpressionParserRuleCall()); 
			    
			pushFollow(FOLLOW_2);
			this_ConditionalExpression_0=ruleConditionalExpression();
			state._fsp--;

			 
			        current = this_ConditionalExpression_0; 
			        afterParserOrEnumRuleCall();
			    
			}

			 leaveRule();
			    		
			     
		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving

				myHiddenTokenState.restore();

				/*no after found*/


		}
		return current;
	}
	// $ANTLR end "ruleExpression"



	// $ANTLR start "entryRuleConditionalExpression"
	// InternalCommon.g:119:1: entryRuleConditionalExpression returns [EObject current=null] :iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
	public final EObject entryRuleConditionalExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleConditionalExpression =null;

		try {
			// InternalCommon.g:120:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
			// InternalCommon.g:121:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
			{
			 newCompositeNode(grammarAccess.getConditionalExpressionRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleConditionalExpression=ruleConditionalExpression();
			state._fsp--;

			 current =iv_ruleConditionalExpression; 
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
	// $ANTLR end "entryRuleConditionalExpression"



	// $ANTLR start "ruleConditionalExpression"
	// InternalCommon.g:128:1: ruleConditionalExpression returns [EObject current=null] : (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? ) ;
	public final EObject ruleConditionalExpression() throws RecognitionException {
		EObject current = null;


		Token this_SKW_QUESTION_2=null;
		Token this_SKW_COLON_4=null;
		EObject this_LogicalOrExpression_0 =null;
		EObject lv_qExpr_3_0 =null;
		EObject lv_cExpr_5_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:134:7: ( (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? ) )
			// InternalCommon.g:136:5: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? )
			{
			// InternalCommon.g:136:5: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? )
			// InternalCommon.g:138:5: this_LogicalOrExpression_0= ruleLogicalOrExpression ( () this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )?
			{
			 
			        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getLogicalOrExpressionParserRuleCall_0()); 
			    
			pushFollow(FOLLOW_3);
			this_LogicalOrExpression_0=ruleLogicalOrExpression();
			state._fsp--;

			 
			        current = this_LogicalOrExpression_0; 
			        afterParserOrEnumRuleCall();
			    
			// InternalCommon.g:149:5: ( () this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )?
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==RULE_SKW_QUESTION) ) {
				alt1=1;
			}
			switch (alt1) {
				case 1 :
					// InternalCommon.g:150:5: () this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) )
					{
					// InternalCommon.g:150:5: ()
					// InternalCommon.g:151:5: 
					{

					        current = forceCreateModelElementAndSet(
					            grammarAccess.getConditionalExpressionAccess().getConditionalExpressionExprAction_1_0(),
					            current);
					    
					}

					this_SKW_QUESTION_2=(Token)match(input,RULE_SKW_QUESTION,FOLLOW_4); 
					 
					    newLeafNode(this_SKW_QUESTION_2, grammarAccess.getConditionalExpressionAccess().getSKW_QUESTIONTerminalRuleCall_1_1()); 
					    
					// InternalCommon.g:166:3: ( (lv_qExpr_3_0= ruleExpression ) )
					// InternalCommon.g:167:3: (lv_qExpr_3_0= ruleExpression )
					{
					// InternalCommon.g:167:3: (lv_qExpr_3_0= ruleExpression )
					// InternalCommon.g:168:3: lv_qExpr_3_0= ruleExpression
					{
					 
						        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getQExprExpressionParserRuleCall_1_2_0()); 
						    
					pushFollow(FOLLOW_5);
					lv_qExpr_3_0=ruleExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
						        }
					       		set(
					       			current, 
					       			"qExpr",
					        		lv_qExpr_3_0, 
					        		"at.jku.weiner.c.common.Common.Expression");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					this_SKW_COLON_4=(Token)match(input,RULE_SKW_COLON,FOLLOW_4); 
					 
					    newLeafNode(this_SKW_COLON_4, grammarAccess.getConditionalExpressionAccess().getSKW_COLONTerminalRuleCall_1_3()); 
					    
					// InternalCommon.g:194:3: ( (lv_cExpr_5_0= ruleConditionalExpression ) )
					// InternalCommon.g:195:3: (lv_cExpr_5_0= ruleConditionalExpression )
					{
					// InternalCommon.g:195:3: (lv_cExpr_5_0= ruleConditionalExpression )
					// InternalCommon.g:196:3: lv_cExpr_5_0= ruleConditionalExpression
					{
					 
						        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getCExprConditionalExpressionParserRuleCall_1_4_0()); 
						    
					pushFollow(FOLLOW_2);
					lv_cExpr_5_0=ruleConditionalExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
						        }
					       		set(
					       			current, 
					       			"cExpr",
					        		lv_cExpr_5_0, 
					        		"at.jku.weiner.c.common.Common.ConditionalExpression");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;

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


				/*no after found*/


		}
		return current;
	}
	// $ANTLR end "ruleConditionalExpression"



	// $ANTLR start "entryRuleLogicalOrExpression"
	// InternalCommon.g:231:1: entryRuleLogicalOrExpression returns [EObject current=null] :iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
	public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleLogicalOrExpression =null;

		try {
			// InternalCommon.g:232:2: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
			// InternalCommon.g:233:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
			{
			 newCompositeNode(grammarAccess.getLogicalOrExpressionRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleLogicalOrExpression=ruleLogicalOrExpression();
			state._fsp--;

			 current =iv_ruleLogicalOrExpression; 
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
	// $ANTLR end "entryRuleLogicalOrExpression"



	// $ANTLR start "ruleLogicalOrExpression"
	// InternalCommon.g:240:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_SKW_OROR_2= RULE_SKW_OROR ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* ) ;
	public final EObject ruleLogicalOrExpression() throws RecognitionException {
		EObject current = null;


		Token this_SKW_OROR_2=null;
		EObject this_LogicalAndExpression_0 =null;
		EObject lv_right_3_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:246:7: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_SKW_OROR_2= RULE_SKW_OROR ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* ) )
			// InternalCommon.g:248:5: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_SKW_OROR_2= RULE_SKW_OROR ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* )
			{
			// InternalCommon.g:248:5: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_SKW_OROR_2= RULE_SKW_OROR ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* )
			// InternalCommon.g:250:5: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_SKW_OROR_2= RULE_SKW_OROR ( (lv_right_3_0= ruleLogicalAndExpression ) ) )*
			{
			 
			        newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0()); 
			    
			pushFollow(FOLLOW_6);
			this_LogicalAndExpression_0=ruleLogicalAndExpression();
			state._fsp--;

			 
			        current = this_LogicalAndExpression_0; 
			        afterParserOrEnumRuleCall();
			    
			// InternalCommon.g:261:5: ( () this_SKW_OROR_2= RULE_SKW_OROR ( (lv_right_3_0= ruleLogicalAndExpression ) ) )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==RULE_SKW_OROR) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// InternalCommon.g:262:5: () this_SKW_OROR_2= RULE_SKW_OROR ( (lv_right_3_0= ruleLogicalAndExpression ) )
					{
					// InternalCommon.g:262:5: ()
					// InternalCommon.g:263:5: 
					{

					        current = forceCreateModelElementAndSet(
					            grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftAction_1_0(),
					            current);
					    
					}

					this_SKW_OROR_2=(Token)match(input,RULE_SKW_OROR,FOLLOW_4); 
					 
					    newLeafNode(this_SKW_OROR_2, grammarAccess.getLogicalOrExpressionAccess().getSKW_ORORTerminalRuleCall_1_1()); 
					    
					// InternalCommon.g:278:3: ( (lv_right_3_0= ruleLogicalAndExpression ) )
					// InternalCommon.g:279:3: (lv_right_3_0= ruleLogicalAndExpression )
					{
					// InternalCommon.g:279:3: (lv_right_3_0= ruleLogicalAndExpression )
					// InternalCommon.g:280:3: lv_right_3_0= ruleLogicalAndExpression
					{
					 
						        newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getRightLogicalAndExpressionParserRuleCall_1_2_0()); 
						    
					pushFollow(FOLLOW_6);
					lv_right_3_0=ruleLogicalAndExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getLogicalOrExpressionRule());
						        }
					       		set(
					       			current, 
					       			"right",
					        		lv_right_3_0, 
					        		"at.jku.weiner.c.common.Common.LogicalAndExpression");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;

				default :
					break loop2;
				}
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


				/*no after found*/


		}
		return current;
	}
	// $ANTLR end "ruleLogicalOrExpression"



	// $ANTLR start "entryRuleLogicalAndExpression"
	// InternalCommon.g:315:1: entryRuleLogicalAndExpression returns [EObject current=null] :iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
	public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleLogicalAndExpression =null;

		try {
			// InternalCommon.g:316:2: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
			// InternalCommon.g:317:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
			{
			 newCompositeNode(grammarAccess.getLogicalAndExpressionRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleLogicalAndExpression=ruleLogicalAndExpression();
			state._fsp--;

			 current =iv_ruleLogicalAndExpression; 
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
	// $ANTLR end "entryRuleLogicalAndExpression"



	// $ANTLR start "ruleLogicalAndExpression"
	// InternalCommon.g:324:1: ruleLogicalAndExpression returns [EObject current=null] : (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )* ) ;
	public final EObject ruleLogicalAndExpression() throws RecognitionException {
		EObject current = null;


		Token this_SKW_ANDAND_2=null;
		EObject this_InclusiveOrExpression_0 =null;
		EObject lv_right_3_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:330:7: ( (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )* ) )
			// InternalCommon.g:332:5: (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )* )
			{
			// InternalCommon.g:332:5: (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )* )
			// InternalCommon.g:334:5: this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )*
			{
			 
			        newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getInclusiveOrExpressionParserRuleCall_0()); 
			    
			pushFollow(FOLLOW_7);
			this_InclusiveOrExpression_0=ruleInclusiveOrExpression();
			state._fsp--;

			 
			        current = this_InclusiveOrExpression_0; 
			        afterParserOrEnumRuleCall();
			    
			// InternalCommon.g:345:5: ( () this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_right_3_0= ruleInclusiveOrExpression ) ) )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==RULE_SKW_ANDAND) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// InternalCommon.g:346:5: () this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_right_3_0= ruleInclusiveOrExpression ) )
					{
					// InternalCommon.g:346:5: ()
					// InternalCommon.g:347:5: 
					{

					        current = forceCreateModelElementAndSet(
					            grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftAction_1_0(),
					            current);
					    
					}

					this_SKW_ANDAND_2=(Token)match(input,RULE_SKW_ANDAND,FOLLOW_4); 
					 
					    newLeafNode(this_SKW_ANDAND_2, grammarAccess.getLogicalAndExpressionAccess().getSKW_ANDANDTerminalRuleCall_1_1()); 
					    
					// InternalCommon.g:362:3: ( (lv_right_3_0= ruleInclusiveOrExpression ) )
					// InternalCommon.g:363:3: (lv_right_3_0= ruleInclusiveOrExpression )
					{
					// InternalCommon.g:363:3: (lv_right_3_0= ruleInclusiveOrExpression )
					// InternalCommon.g:364:3: lv_right_3_0= ruleInclusiveOrExpression
					{
					 
						        newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getRightInclusiveOrExpressionParserRuleCall_1_2_0()); 
						    
					pushFollow(FOLLOW_7);
					lv_right_3_0=ruleInclusiveOrExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getLogicalAndExpressionRule());
						        }
					       		set(
					       			current, 
					       			"right",
					        		lv_right_3_0, 
					        		"at.jku.weiner.c.common.Common.InclusiveOrExpression");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;

				default :
					break loop3;
				}
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


				/*no after found*/


		}
		return current;
	}
	// $ANTLR end "ruleLogicalAndExpression"



	// $ANTLR start "entryRuleInclusiveOrExpression"
	// InternalCommon.g:399:1: entryRuleInclusiveOrExpression returns [EObject current=null] :iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF ;
	public final EObject entryRuleInclusiveOrExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleInclusiveOrExpression =null;

		try {
			// InternalCommon.g:400:2: (iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF )
			// InternalCommon.g:401:2: iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF
			{
			 newCompositeNode(grammarAccess.getInclusiveOrExpressionRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleInclusiveOrExpression=ruleInclusiveOrExpression();
			state._fsp--;

			 current =iv_ruleInclusiveOrExpression; 
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
	// $ANTLR end "entryRuleInclusiveOrExpression"



	// $ANTLR start "ruleInclusiveOrExpression"
	// InternalCommon.g:408:1: ruleInclusiveOrExpression returns [EObject current=null] : (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () this_SKW_OR_2= RULE_SKW_OR ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )* ) ;
	public final EObject ruleInclusiveOrExpression() throws RecognitionException {
		EObject current = null;


		Token this_SKW_OR_2=null;
		EObject this_ExclusiveOrExpression_0 =null;
		EObject lv_right_3_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:414:7: ( (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () this_SKW_OR_2= RULE_SKW_OR ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )* ) )
			// InternalCommon.g:416:5: (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () this_SKW_OR_2= RULE_SKW_OR ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )* )
			{
			// InternalCommon.g:416:5: (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () this_SKW_OR_2= RULE_SKW_OR ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )* )
			// InternalCommon.g:418:5: this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () this_SKW_OR_2= RULE_SKW_OR ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )*
			{
			 
			        newCompositeNode(grammarAccess.getInclusiveOrExpressionAccess().getExclusiveOrExpressionParserRuleCall_0()); 
			    
			pushFollow(FOLLOW_8);
			this_ExclusiveOrExpression_0=ruleExclusiveOrExpression();
			state._fsp--;

			 
			        current = this_ExclusiveOrExpression_0; 
			        afterParserOrEnumRuleCall();
			    
			// InternalCommon.g:429:5: ( () this_SKW_OR_2= RULE_SKW_OR ( (lv_right_3_0= ruleExclusiveOrExpression ) ) )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==RULE_SKW_OR) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// InternalCommon.g:430:5: () this_SKW_OR_2= RULE_SKW_OR ( (lv_right_3_0= ruleExclusiveOrExpression ) )
					{
					// InternalCommon.g:430:5: ()
					// InternalCommon.g:431:5: 
					{

					        current = forceCreateModelElementAndSet(
					            grammarAccess.getInclusiveOrExpressionAccess().getInclusiveOrExpressionLeftAction_1_0(),
					            current);
					    
					}

					this_SKW_OR_2=(Token)match(input,RULE_SKW_OR,FOLLOW_4); 
					 
					    newLeafNode(this_SKW_OR_2, grammarAccess.getInclusiveOrExpressionAccess().getSKW_ORTerminalRuleCall_1_1()); 
					    
					// InternalCommon.g:446:3: ( (lv_right_3_0= ruleExclusiveOrExpression ) )
					// InternalCommon.g:447:3: (lv_right_3_0= ruleExclusiveOrExpression )
					{
					// InternalCommon.g:447:3: (lv_right_3_0= ruleExclusiveOrExpression )
					// InternalCommon.g:448:3: lv_right_3_0= ruleExclusiveOrExpression
					{
					 
						        newCompositeNode(grammarAccess.getInclusiveOrExpressionAccess().getRightExclusiveOrExpressionParserRuleCall_1_2_0()); 
						    
					pushFollow(FOLLOW_8);
					lv_right_3_0=ruleExclusiveOrExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getInclusiveOrExpressionRule());
						        }
					       		set(
					       			current, 
					       			"right",
					        		lv_right_3_0, 
					        		"at.jku.weiner.c.common.Common.ExclusiveOrExpression");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;

				default :
					break loop4;
				}
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


				/*no after found*/


		}
		return current;
	}
	// $ANTLR end "ruleInclusiveOrExpression"



	// $ANTLR start "entryRuleExclusiveOrExpression"
	// InternalCommon.g:483:1: entryRuleExclusiveOrExpression returns [EObject current=null] :iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF ;
	public final EObject entryRuleExclusiveOrExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleExclusiveOrExpression =null;

		try {
			// InternalCommon.g:484:2: (iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF )
			// InternalCommon.g:485:2: iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF
			{
			 newCompositeNode(grammarAccess.getExclusiveOrExpressionRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleExclusiveOrExpression=ruleExclusiveOrExpression();
			state._fsp--;

			 current =iv_ruleExclusiveOrExpression; 
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
	// $ANTLR end "entryRuleExclusiveOrExpression"



	// $ANTLR start "ruleExclusiveOrExpression"
	// InternalCommon.g:492:1: ruleExclusiveOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () this_SKW_CARET_2= RULE_SKW_CARET ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
	public final EObject ruleExclusiveOrExpression() throws RecognitionException {
		EObject current = null;


		Token this_SKW_CARET_2=null;
		EObject this_AndExpression_0 =null;
		EObject lv_right_3_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:498:7: ( (this_AndExpression_0= ruleAndExpression ( () this_SKW_CARET_2= RULE_SKW_CARET ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
			// InternalCommon.g:500:5: (this_AndExpression_0= ruleAndExpression ( () this_SKW_CARET_2= RULE_SKW_CARET ( (lv_right_3_0= ruleAndExpression ) ) )* )
			{
			// InternalCommon.g:500:5: (this_AndExpression_0= ruleAndExpression ( () this_SKW_CARET_2= RULE_SKW_CARET ( (lv_right_3_0= ruleAndExpression ) ) )* )
			// InternalCommon.g:502:5: this_AndExpression_0= ruleAndExpression ( () this_SKW_CARET_2= RULE_SKW_CARET ( (lv_right_3_0= ruleAndExpression ) ) )*
			{
			 
			        newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getAndExpressionParserRuleCall_0()); 
			    
			pushFollow(FOLLOW_9);
			this_AndExpression_0=ruleAndExpression();
			state._fsp--;

			 
			        current = this_AndExpression_0; 
			        afterParserOrEnumRuleCall();
			    
			// InternalCommon.g:513:5: ( () this_SKW_CARET_2= RULE_SKW_CARET ( (lv_right_3_0= ruleAndExpression ) ) )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==RULE_SKW_CARET) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// InternalCommon.g:514:5: () this_SKW_CARET_2= RULE_SKW_CARET ( (lv_right_3_0= ruleAndExpression ) )
					{
					// InternalCommon.g:514:5: ()
					// InternalCommon.g:515:5: 
					{

					        current = forceCreateModelElementAndSet(
					            grammarAccess.getExclusiveOrExpressionAccess().getExclusiveOrExpressionLeftAction_1_0(),
					            current);
					    
					}

					this_SKW_CARET_2=(Token)match(input,RULE_SKW_CARET,FOLLOW_4); 
					 
					    newLeafNode(this_SKW_CARET_2, grammarAccess.getExclusiveOrExpressionAccess().getSKW_CARETTerminalRuleCall_1_1()); 
					    
					// InternalCommon.g:530:3: ( (lv_right_3_0= ruleAndExpression ) )
					// InternalCommon.g:531:3: (lv_right_3_0= ruleAndExpression )
					{
					// InternalCommon.g:531:3: (lv_right_3_0= ruleAndExpression )
					// InternalCommon.g:532:3: lv_right_3_0= ruleAndExpression
					{
					 
						        newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0()); 
						    
					pushFollow(FOLLOW_9);
					lv_right_3_0=ruleAndExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getExclusiveOrExpressionRule());
						        }
					       		set(
					       			current, 
					       			"right",
					        		lv_right_3_0, 
					        		"at.jku.weiner.c.common.Common.AndExpression");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;

				default :
					break loop5;
				}
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


				/*no after found*/


		}
		return current;
	}
	// $ANTLR end "ruleExclusiveOrExpression"



	// $ANTLR start "entryRuleAndExpression"
	// InternalCommon.g:567:1: entryRuleAndExpression returns [EObject current=null] :iv_ruleAndExpression= ruleAndExpression EOF ;
	public final EObject entryRuleAndExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleAndExpression =null;

		try {
			// InternalCommon.g:568:2: (iv_ruleAndExpression= ruleAndExpression EOF )
			// InternalCommon.g:569:2: iv_ruleAndExpression= ruleAndExpression EOF
			{
			 newCompositeNode(grammarAccess.getAndExpressionRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleAndExpression=ruleAndExpression();
			state._fsp--;

			 current =iv_ruleAndExpression; 
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
	// $ANTLR end "entryRuleAndExpression"



	// $ANTLR start "ruleAndExpression"
	// InternalCommon.g:576:1: ruleAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( () this_SKW_AND_2= RULE_SKW_AND ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) ;
	public final EObject ruleAndExpression() throws RecognitionException {
		EObject current = null;


		Token this_SKW_AND_2=null;
		EObject this_EqualityExpression_0 =null;
		EObject lv_right_3_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:582:7: ( (this_EqualityExpression_0= ruleEqualityExpression ( () this_SKW_AND_2= RULE_SKW_AND ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) )
			// InternalCommon.g:584:5: (this_EqualityExpression_0= ruleEqualityExpression ( () this_SKW_AND_2= RULE_SKW_AND ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
			{
			// InternalCommon.g:584:5: (this_EqualityExpression_0= ruleEqualityExpression ( () this_SKW_AND_2= RULE_SKW_AND ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
			// InternalCommon.g:586:5: this_EqualityExpression_0= ruleEqualityExpression ( () this_SKW_AND_2= RULE_SKW_AND ( (lv_right_3_0= ruleEqualityExpression ) ) )*
			{
			 
			        newCompositeNode(grammarAccess.getAndExpressionAccess().getEqualityExpressionParserRuleCall_0()); 
			    
			pushFollow(FOLLOW_10);
			this_EqualityExpression_0=ruleEqualityExpression();
			state._fsp--;

			 
			        current = this_EqualityExpression_0; 
			        afterParserOrEnumRuleCall();
			    
			// InternalCommon.g:597:5: ( () this_SKW_AND_2= RULE_SKW_AND ( (lv_right_3_0= ruleEqualityExpression ) ) )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==RULE_SKW_AND) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// InternalCommon.g:598:5: () this_SKW_AND_2= RULE_SKW_AND ( (lv_right_3_0= ruleEqualityExpression ) )
					{
					// InternalCommon.g:598:5: ()
					// InternalCommon.g:599:5: 
					{

					        current = forceCreateModelElementAndSet(
					            grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0(),
					            current);
					    
					}

					this_SKW_AND_2=(Token)match(input,RULE_SKW_AND,FOLLOW_4); 
					 
					    newLeafNode(this_SKW_AND_2, grammarAccess.getAndExpressionAccess().getSKW_ANDTerminalRuleCall_1_1()); 
					    
					// InternalCommon.g:614:3: ( (lv_right_3_0= ruleEqualityExpression ) )
					// InternalCommon.g:615:3: (lv_right_3_0= ruleEqualityExpression )
					{
					// InternalCommon.g:615:3: (lv_right_3_0= ruleEqualityExpression )
					// InternalCommon.g:616:3: lv_right_3_0= ruleEqualityExpression
					{
					 
						        newCompositeNode(grammarAccess.getAndExpressionAccess().getRightEqualityExpressionParserRuleCall_1_2_0()); 
						    
					pushFollow(FOLLOW_10);
					lv_right_3_0=ruleEqualityExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getAndExpressionRule());
						        }
					       		set(
					       			current, 
					       			"right",
					        		lv_right_3_0, 
					        		"at.jku.weiner.c.common.Common.EqualityExpression");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;

				default :
					break loop6;
				}
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


				/*no after found*/


		}
		return current;
	}
	// $ANTLR end "ruleAndExpression"



	// $ANTLR start "entryRuleEqualityExpression"
	// InternalCommon.g:651:1: entryRuleEqualityExpression returns [EObject current=null] :iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
	public final EObject entryRuleEqualityExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleEqualityExpression =null;

		try {
			// InternalCommon.g:652:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
			// InternalCommon.g:653:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
			{
			 newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleEqualityExpression=ruleEqualityExpression();
			state._fsp--;

			 current =iv_ruleEqualityExpression; 
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
	// $ANTLR end "entryRuleEqualityExpression"



	// $ANTLR start "ruleEqualityExpression"
	// InternalCommon.g:660:1: ruleEqualityExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_right_4_0= ruleRelationalExpression ) ) )* ) ;
	public final EObject ruleEqualityExpression() throws RecognitionException {
		EObject current = null;


		Token lv_op_2_0=null;
		Token lv_op_3_0=null;
		EObject this_RelationalExpression_0 =null;
		EObject lv_right_4_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:666:7: ( (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_right_4_0= ruleRelationalExpression ) ) )* ) )
			// InternalCommon.g:668:5: (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_right_4_0= ruleRelationalExpression ) ) )* )
			{
			// InternalCommon.g:668:5: (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_right_4_0= ruleRelationalExpression ) ) )* )
			// InternalCommon.g:670:5: this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_right_4_0= ruleRelationalExpression ) ) )*
			{
			 
			        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRelationalExpressionParserRuleCall_0()); 
			    
			pushFollow(FOLLOW_11);
			this_RelationalExpression_0=ruleRelationalExpression();
			state._fsp--;

			 
			        current = this_RelationalExpression_0; 
			        afterParserOrEnumRuleCall();
			    
			// InternalCommon.g:681:5: ( () ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_right_4_0= ruleRelationalExpression ) ) )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==RULE_SKW_EQUAL||LA8_0==RULE_SKW_NOTEQUAL) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// InternalCommon.g:682:5: () ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_right_4_0= ruleRelationalExpression ) )
					{
					// InternalCommon.g:682:5: ()
					// InternalCommon.g:683:5: 
					{

					        current = forceCreateModelElementAndSet(
					            grammarAccess.getEqualityExpressionAccess().getEqualityExpressionLeftAction_1_0(),
					            current);
					    
					}

					// InternalCommon.g:691:3: ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) )
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==RULE_SKW_EQUAL) ) {
						alt7=1;
					}
					else if ( (LA7_0==RULE_SKW_NOTEQUAL) ) {
						alt7=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 7, 0, input);
						throw nvae;
					}

					switch (alt7) {
						case 1 :
							// InternalCommon.g:692:3: ( (lv_op_2_0= RULE_SKW_EQUAL ) )
							{
							// InternalCommon.g:692:3: ( (lv_op_2_0= RULE_SKW_EQUAL ) )
							// InternalCommon.g:693:3: (lv_op_2_0= RULE_SKW_EQUAL )
							{
							// InternalCommon.g:693:3: (lv_op_2_0= RULE_SKW_EQUAL )
							// InternalCommon.g:694:3: lv_op_2_0= RULE_SKW_EQUAL
							{
							lv_op_2_0=(Token)match(input,RULE_SKW_EQUAL,FOLLOW_4); 

										newLeafNode(lv_op_2_0, grammarAccess.getEqualityExpressionAccess().getOpSKW_EQUALTerminalRuleCall_1_1_0_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getEqualityExpressionRule());
								        }
							       		setWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_2_0, 
							        		"at.jku.weiner.c.common.Common.SKW_EQUAL");
								    
							}

							}

							}
							break;
						case 2 :
							// InternalCommon.g:714:3: ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) )
							{
							// InternalCommon.g:714:3: ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) )
							// InternalCommon.g:715:3: (lv_op_3_0= RULE_SKW_NOTEQUAL )
							{
							// InternalCommon.g:715:3: (lv_op_3_0= RULE_SKW_NOTEQUAL )
							// InternalCommon.g:716:3: lv_op_3_0= RULE_SKW_NOTEQUAL
							{
							lv_op_3_0=(Token)match(input,RULE_SKW_NOTEQUAL,FOLLOW_4); 

										newLeafNode(lv_op_3_0, grammarAccess.getEqualityExpressionAccess().getOpSKW_NOTEQUALTerminalRuleCall_1_1_1_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getEqualityExpressionRule());
								        }
							       		setWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_3_0, 
							        		"at.jku.weiner.c.common.Common.SKW_NOTEQUAL");
								    
							}

							}

							}
							break;

					}

					// InternalCommon.g:737:3: ( (lv_right_4_0= ruleRelationalExpression ) )
					// InternalCommon.g:738:3: (lv_right_4_0= ruleRelationalExpression )
					{
					// InternalCommon.g:738:3: (lv_right_4_0= ruleRelationalExpression )
					// InternalCommon.g:739:3: lv_right_4_0= ruleRelationalExpression
					{
					 
						        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightRelationalExpressionParserRuleCall_1_2_0()); 
						    
					pushFollow(FOLLOW_11);
					lv_right_4_0=ruleRelationalExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
						        }
					       		set(
					       			current, 
					       			"right",
					        		lv_right_4_0, 
					        		"at.jku.weiner.c.common.Common.RelationalExpression");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;

				default :
					break loop8;
				}
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


				/*no after found*/


		}
		return current;
	}
	// $ANTLR end "ruleEqualityExpression"



	// $ANTLR start "entryRuleRelationalExpression"
	// InternalCommon.g:774:1: entryRuleRelationalExpression returns [EObject current=null] :iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
	public final EObject entryRuleRelationalExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleRelationalExpression =null;

		try {
			// InternalCommon.g:775:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
			// InternalCommon.g:776:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
			{
			 newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleRelationalExpression=ruleRelationalExpression();
			state._fsp--;

			 current =iv_ruleRelationalExpression; 
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
	// $ANTLR end "entryRuleRelationalExpression"



	// $ANTLR start "ruleRelationalExpression"
	// InternalCommon.g:783:1: ruleRelationalExpression returns [EObject current=null] : (this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_right_6_0= ruleShiftExpression ) ) )* ) ;
	public final EObject ruleRelationalExpression() throws RecognitionException {
		EObject current = null;


		Token lv_op_2_0=null;
		Token lv_op_3_0=null;
		Token lv_op_4_0=null;
		Token lv_op_5_0=null;
		EObject this_ShiftExpression_0 =null;
		EObject lv_right_6_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:789:7: ( (this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_right_6_0= ruleShiftExpression ) ) )* ) )
			// InternalCommon.g:791:5: (this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_right_6_0= ruleShiftExpression ) ) )* )
			{
			// InternalCommon.g:791:5: (this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_right_6_0= ruleShiftExpression ) ) )* )
			// InternalCommon.g:793:5: this_ShiftExpression_0= ruleShiftExpression ( () ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_right_6_0= ruleShiftExpression ) ) )*
			{
			 
			        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getShiftExpressionParserRuleCall_0()); 
			    
			pushFollow(FOLLOW_12);
			this_ShiftExpression_0=ruleShiftExpression();
			state._fsp--;

			 
			        current = this_ShiftExpression_0; 
			        afterParserOrEnumRuleCall();
			    
			// InternalCommon.g:804:5: ( () ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_right_6_0= ruleShiftExpression ) ) )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= RULE_SKW_GREATER && LA10_0 <= RULE_SKW_GREATEREQUAL)||(LA10_0 >= RULE_SKW_LESS && LA10_0 <= RULE_SKW_LESSEQUAL)) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// InternalCommon.g:805:5: () ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_right_6_0= ruleShiftExpression ) )
					{
					// InternalCommon.g:805:5: ()
					// InternalCommon.g:806:5: 
					{

					        current = forceCreateModelElementAndSet(
					            grammarAccess.getRelationalExpressionAccess().getRelationalExpressionLeftAction_1_0(),
					            current);
					    
					}

					// InternalCommon.g:814:3: ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) )
					int alt9=4;
					switch ( input.LA(1) ) {
					case RULE_SKW_LESS:
						{
						alt9=1;
						}
						break;
					case RULE_SKW_GREATER:
						{
						alt9=2;
						}
						break;
					case RULE_SKW_LESSEQUAL:
						{
						alt9=3;
						}
						break;
					case RULE_SKW_GREATEREQUAL:
						{
						alt9=4;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 9, 0, input);
						throw nvae;
					}
					switch (alt9) {
						case 1 :
							// InternalCommon.g:815:3: ( (lv_op_2_0= RULE_SKW_LESS ) )
							{
							// InternalCommon.g:815:3: ( (lv_op_2_0= RULE_SKW_LESS ) )
							// InternalCommon.g:816:3: (lv_op_2_0= RULE_SKW_LESS )
							{
							// InternalCommon.g:816:3: (lv_op_2_0= RULE_SKW_LESS )
							// InternalCommon.g:817:3: lv_op_2_0= RULE_SKW_LESS
							{
							lv_op_2_0=(Token)match(input,RULE_SKW_LESS,FOLLOW_4); 

										newLeafNode(lv_op_2_0, grammarAccess.getRelationalExpressionAccess().getOpSKW_LESSTerminalRuleCall_1_1_0_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getRelationalExpressionRule());
								        }
							       		setWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_2_0, 
							        		"at.jku.weiner.c.common.Common.SKW_LESS");
								    
							}

							}

							}
							break;
						case 2 :
							// InternalCommon.g:837:3: ( (lv_op_3_0= RULE_SKW_GREATER ) )
							{
							// InternalCommon.g:837:3: ( (lv_op_3_0= RULE_SKW_GREATER ) )
							// InternalCommon.g:838:3: (lv_op_3_0= RULE_SKW_GREATER )
							{
							// InternalCommon.g:838:3: (lv_op_3_0= RULE_SKW_GREATER )
							// InternalCommon.g:839:3: lv_op_3_0= RULE_SKW_GREATER
							{
							lv_op_3_0=(Token)match(input,RULE_SKW_GREATER,FOLLOW_4); 

										newLeafNode(lv_op_3_0, grammarAccess.getRelationalExpressionAccess().getOpSKW_GREATERTerminalRuleCall_1_1_1_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getRelationalExpressionRule());
								        }
							       		setWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_3_0, 
							        		"at.jku.weiner.c.common.Common.SKW_GREATER");
								    
							}

							}

							}
							break;
						case 3 :
							// InternalCommon.g:859:3: ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) )
							{
							// InternalCommon.g:859:3: ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) )
							// InternalCommon.g:860:3: (lv_op_4_0= RULE_SKW_LESSEQUAL )
							{
							// InternalCommon.g:860:3: (lv_op_4_0= RULE_SKW_LESSEQUAL )
							// InternalCommon.g:861:3: lv_op_4_0= RULE_SKW_LESSEQUAL
							{
							lv_op_4_0=(Token)match(input,RULE_SKW_LESSEQUAL,FOLLOW_4); 

										newLeafNode(lv_op_4_0, grammarAccess.getRelationalExpressionAccess().getOpSKW_LESSEQUALTerminalRuleCall_1_1_2_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getRelationalExpressionRule());
								        }
							       		setWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_4_0, 
							        		"at.jku.weiner.c.common.Common.SKW_LESSEQUAL");
								    
							}

							}

							}
							break;
						case 4 :
							// InternalCommon.g:881:3: ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) )
							{
							// InternalCommon.g:881:3: ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) )
							// InternalCommon.g:882:3: (lv_op_5_0= RULE_SKW_GREATEREQUAL )
							{
							// InternalCommon.g:882:3: (lv_op_5_0= RULE_SKW_GREATEREQUAL )
							// InternalCommon.g:883:3: lv_op_5_0= RULE_SKW_GREATEREQUAL
							{
							lv_op_5_0=(Token)match(input,RULE_SKW_GREATEREQUAL,FOLLOW_4); 

										newLeafNode(lv_op_5_0, grammarAccess.getRelationalExpressionAccess().getOpSKW_GREATEREQUALTerminalRuleCall_1_1_3_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getRelationalExpressionRule());
								        }
							       		setWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_5_0, 
							        		"at.jku.weiner.c.common.Common.SKW_GREATEREQUAL");
								    
							}

							}

							}
							break;

					}

					// InternalCommon.g:904:3: ( (lv_right_6_0= ruleShiftExpression ) )
					// InternalCommon.g:905:3: (lv_right_6_0= ruleShiftExpression )
					{
					// InternalCommon.g:905:3: (lv_right_6_0= ruleShiftExpression )
					// InternalCommon.g:906:3: lv_right_6_0= ruleShiftExpression
					{
					 
						        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightShiftExpressionParserRuleCall_1_2_0()); 
						    
					pushFollow(FOLLOW_12);
					lv_right_6_0=ruleShiftExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
						        }
					       		set(
					       			current, 
					       			"right",
					        		lv_right_6_0, 
					        		"at.jku.weiner.c.common.Common.ShiftExpression");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;

				default :
					break loop10;
				}
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


				/*no after found*/


		}
		return current;
	}
	// $ANTLR end "ruleRelationalExpression"



	// $ANTLR start "entryRuleShiftExpression"
	// InternalCommon.g:941:1: entryRuleShiftExpression returns [EObject current=null] :iv_ruleShiftExpression= ruleShiftExpression EOF ;
	public final EObject entryRuleShiftExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleShiftExpression =null;

		try {
			// InternalCommon.g:942:2: (iv_ruleShiftExpression= ruleShiftExpression EOF )
			// InternalCommon.g:943:2: iv_ruleShiftExpression= ruleShiftExpression EOF
			{
			 newCompositeNode(grammarAccess.getShiftExpressionRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleShiftExpression=ruleShiftExpression();
			state._fsp--;

			 current =iv_ruleShiftExpression; 
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
	// $ANTLR end "entryRuleShiftExpression"



	// $ANTLR start "ruleShiftExpression"
	// InternalCommon.g:950:1: ruleShiftExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_right_4_0= ruleAdditiveExpression ) ) )* ) ;
	public final EObject ruleShiftExpression() throws RecognitionException {
		EObject current = null;


		Token lv_op_2_0=null;
		Token lv_op_3_0=null;
		EObject this_AdditiveExpression_0 =null;
		EObject lv_right_4_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:956:7: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_right_4_0= ruleAdditiveExpression ) ) )* ) )
			// InternalCommon.g:958:5: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_right_4_0= ruleAdditiveExpression ) ) )* )
			{
			// InternalCommon.g:958:5: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_right_4_0= ruleAdditiveExpression ) ) )* )
			// InternalCommon.g:960:5: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_right_4_0= ruleAdditiveExpression ) ) )*
			{
			 
			        newCompositeNode(grammarAccess.getShiftExpressionAccess().getAdditiveExpressionParserRuleCall_0()); 
			    
			pushFollow(FOLLOW_13);
			this_AdditiveExpression_0=ruleAdditiveExpression();
			state._fsp--;

			 
			        current = this_AdditiveExpression_0; 
			        afterParserOrEnumRuleCall();
			    
			// InternalCommon.g:971:5: ( () ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_right_4_0= ruleAdditiveExpression ) ) )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==RULE_SKW_LEFTSHIFT||LA12_0==RULE_SKW_RIGHTSHIFT) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// InternalCommon.g:972:5: () ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_right_4_0= ruleAdditiveExpression ) )
					{
					// InternalCommon.g:972:5: ()
					// InternalCommon.g:973:5: 
					{

					        current = forceCreateModelElementAndSet(
					            grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftAction_1_0(),
					            current);
					    
					}

					// InternalCommon.g:981:3: ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) )
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==RULE_SKW_LEFTSHIFT) ) {
						alt11=1;
					}
					else if ( (LA11_0==RULE_SKW_RIGHTSHIFT) ) {
						alt11=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 11, 0, input);
						throw nvae;
					}

					switch (alt11) {
						case 1 :
							// InternalCommon.g:982:3: ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) )
							{
							// InternalCommon.g:982:3: ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) )
							// InternalCommon.g:983:3: (lv_op_2_0= RULE_SKW_LEFTSHIFT )
							{
							// InternalCommon.g:983:3: (lv_op_2_0= RULE_SKW_LEFTSHIFT )
							// InternalCommon.g:984:3: lv_op_2_0= RULE_SKW_LEFTSHIFT
							{
							lv_op_2_0=(Token)match(input,RULE_SKW_LEFTSHIFT,FOLLOW_4); 

										newLeafNode(lv_op_2_0, grammarAccess.getShiftExpressionAccess().getOpSKW_LEFTSHIFTTerminalRuleCall_1_1_0_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getShiftExpressionRule());
								        }
							       		setWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_2_0, 
							        		"at.jku.weiner.c.common.Common.SKW_LEFTSHIFT");
								    
							}

							}

							}
							break;
						case 2 :
							// InternalCommon.g:1004:3: ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) )
							{
							// InternalCommon.g:1004:3: ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) )
							// InternalCommon.g:1005:3: (lv_op_3_0= RULE_SKW_RIGHTSHIFT )
							{
							// InternalCommon.g:1005:3: (lv_op_3_0= RULE_SKW_RIGHTSHIFT )
							// InternalCommon.g:1006:3: lv_op_3_0= RULE_SKW_RIGHTSHIFT
							{
							lv_op_3_0=(Token)match(input,RULE_SKW_RIGHTSHIFT,FOLLOW_4); 

										newLeafNode(lv_op_3_0, grammarAccess.getShiftExpressionAccess().getOpSKW_RIGHTSHIFTTerminalRuleCall_1_1_1_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getShiftExpressionRule());
								        }
							       		setWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_3_0, 
							        		"at.jku.weiner.c.common.Common.SKW_RIGHTSHIFT");
								    
							}

							}

							}
							break;

					}

					// InternalCommon.g:1027:3: ( (lv_right_4_0= ruleAdditiveExpression ) )
					// InternalCommon.g:1028:3: (lv_right_4_0= ruleAdditiveExpression )
					{
					// InternalCommon.g:1028:3: (lv_right_4_0= ruleAdditiveExpression )
					// InternalCommon.g:1029:3: lv_right_4_0= ruleAdditiveExpression
					{
					 
						        newCompositeNode(grammarAccess.getShiftExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_2_0()); 
						    
					pushFollow(FOLLOW_13);
					lv_right_4_0=ruleAdditiveExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
						        }
					       		set(
					       			current, 
					       			"right",
					        		lv_right_4_0, 
					        		"at.jku.weiner.c.common.Common.AdditiveExpression");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;

				default :
					break loop12;
				}
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


				/*no after found*/


		}
		return current;
	}
	// $ANTLR end "ruleShiftExpression"



	// $ANTLR start "entryRuleAdditiveExpression"
	// InternalCommon.g:1064:1: entryRuleAdditiveExpression returns [EObject current=null] :iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
	public final EObject entryRuleAdditiveExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleAdditiveExpression =null;

		try {
			// InternalCommon.g:1065:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
			// InternalCommon.g:1066:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
			{
			 newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleAdditiveExpression=ruleAdditiveExpression();
			state._fsp--;

			 current =iv_ruleAdditiveExpression; 
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
	// $ANTLR end "entryRuleAdditiveExpression"



	// $ANTLR start "ruleAdditiveExpression"
	// InternalCommon.g:1073:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_right_4_0= ruleMultiplicativeExpression ) ) )* ) ;
	public final EObject ruleAdditiveExpression() throws RecognitionException {
		EObject current = null;


		Token lv_op_2_0=null;
		Token lv_op_3_0=null;
		EObject this_MultiplicativeExpression_0 =null;
		EObject lv_right_4_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:1079:7: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_right_4_0= ruleMultiplicativeExpression ) ) )* ) )
			// InternalCommon.g:1081:5: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_right_4_0= ruleMultiplicativeExpression ) ) )* )
			{
			// InternalCommon.g:1081:5: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_right_4_0= ruleMultiplicativeExpression ) ) )* )
			// InternalCommon.g:1083:5: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_right_4_0= ruleMultiplicativeExpression ) ) )*
			{
			 
			        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0()); 
			    
			pushFollow(FOLLOW_14);
			this_MultiplicativeExpression_0=ruleMultiplicativeExpression();
			state._fsp--;

			 
			        current = this_MultiplicativeExpression_0; 
			        afterParserOrEnumRuleCall();
			    
			// InternalCommon.g:1094:5: ( () ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_right_4_0= ruleMultiplicativeExpression ) ) )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==RULE_SKW_MINUS||LA14_0==RULE_SKW_PLUS) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// InternalCommon.g:1095:5: () ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_right_4_0= ruleMultiplicativeExpression ) )
					{
					// InternalCommon.g:1095:5: ()
					// InternalCommon.g:1096:5: 
					{

					        current = forceCreateModelElementAndSet(
					            grammarAccess.getAdditiveExpressionAccess().getAdditiveExpressionLeftAction_1_0(),
					            current);
					    
					}

					// InternalCommon.g:1104:3: ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) )
					int alt13=2;
					int LA13_0 = input.LA(1);
					if ( (LA13_0==RULE_SKW_PLUS) ) {
						alt13=1;
					}
					else if ( (LA13_0==RULE_SKW_MINUS) ) {
						alt13=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 13, 0, input);
						throw nvae;
					}

					switch (alt13) {
						case 1 :
							// InternalCommon.g:1105:3: ( (lv_op_2_0= RULE_SKW_PLUS ) )
							{
							// InternalCommon.g:1105:3: ( (lv_op_2_0= RULE_SKW_PLUS ) )
							// InternalCommon.g:1106:3: (lv_op_2_0= RULE_SKW_PLUS )
							{
							// InternalCommon.g:1106:3: (lv_op_2_0= RULE_SKW_PLUS )
							// InternalCommon.g:1107:3: lv_op_2_0= RULE_SKW_PLUS
							{
							lv_op_2_0=(Token)match(input,RULE_SKW_PLUS,FOLLOW_4); 

										newLeafNode(lv_op_2_0, grammarAccess.getAdditiveExpressionAccess().getOpSKW_PLUSTerminalRuleCall_1_1_0_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getAdditiveExpressionRule());
								        }
							       		setWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_2_0, 
							        		"at.jku.weiner.c.common.Common.SKW_PLUS");
								    
							}

							}

							}
							break;
						case 2 :
							// InternalCommon.g:1127:3: ( (lv_op_3_0= RULE_SKW_MINUS ) )
							{
							// InternalCommon.g:1127:3: ( (lv_op_3_0= RULE_SKW_MINUS ) )
							// InternalCommon.g:1128:3: (lv_op_3_0= RULE_SKW_MINUS )
							{
							// InternalCommon.g:1128:3: (lv_op_3_0= RULE_SKW_MINUS )
							// InternalCommon.g:1129:3: lv_op_3_0= RULE_SKW_MINUS
							{
							lv_op_3_0=(Token)match(input,RULE_SKW_MINUS,FOLLOW_4); 

										newLeafNode(lv_op_3_0, grammarAccess.getAdditiveExpressionAccess().getOpSKW_MINUSTerminalRuleCall_1_1_1_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getAdditiveExpressionRule());
								        }
							       		setWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_3_0, 
							        		"at.jku.weiner.c.common.Common.SKW_MINUS");
								    
							}

							}

							}
							break;

					}

					// InternalCommon.g:1150:3: ( (lv_right_4_0= ruleMultiplicativeExpression ) )
					// InternalCommon.g:1151:3: (lv_right_4_0= ruleMultiplicativeExpression )
					{
					// InternalCommon.g:1151:3: (lv_right_4_0= ruleMultiplicativeExpression )
					// InternalCommon.g:1152:3: lv_right_4_0= ruleMultiplicativeExpression
					{
					 
						        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightMultiplicativeExpressionParserRuleCall_1_2_0()); 
						    
					pushFollow(FOLLOW_14);
					lv_right_4_0=ruleMultiplicativeExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
						        }
					       		set(
					       			current, 
					       			"right",
					        		lv_right_4_0, 
					        		"at.jku.weiner.c.common.Common.MultiplicativeExpression");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;

				default :
					break loop14;
				}
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


				/*no after found*/


		}
		return current;
	}
	// $ANTLR end "ruleAdditiveExpression"



	// $ANTLR start "entryRuleMultiplicativeExpression"
	// InternalCommon.g:1187:1: entryRuleMultiplicativeExpression returns [EObject current=null] :iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
	public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleMultiplicativeExpression =null;

		try {
			// InternalCommon.g:1188:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
			// InternalCommon.g:1189:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
			{
			 newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();
			state._fsp--;

			 current =iv_ruleMultiplicativeExpression; 
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
	// $ANTLR end "entryRuleMultiplicativeExpression"



	// $ANTLR start "ruleMultiplicativeExpression"
	// InternalCommon.g:1196:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_right_5_0= ruleCastExpression ) ) )* ) ;
	public final EObject ruleMultiplicativeExpression() throws RecognitionException {
		EObject current = null;


		Token lv_op_2_0=null;
		Token lv_op_3_0=null;
		Token lv_op_4_0=null;
		EObject this_CastExpression_0 =null;
		EObject lv_right_5_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:1202:7: ( (this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_right_5_0= ruleCastExpression ) ) )* ) )
			// InternalCommon.g:1204:5: (this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_right_5_0= ruleCastExpression ) ) )* )
			{
			// InternalCommon.g:1204:5: (this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_right_5_0= ruleCastExpression ) ) )* )
			// InternalCommon.g:1206:5: this_CastExpression_0= ruleCastExpression ( () ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_right_5_0= ruleCastExpression ) ) )*
			{
			 
			        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getCastExpressionParserRuleCall_0()); 
			    
			pushFollow(FOLLOW_15);
			this_CastExpression_0=ruleCastExpression();
			state._fsp--;

			 
			        current = this_CastExpression_0; 
			        afterParserOrEnumRuleCall();
			    
			// InternalCommon.g:1217:5: ( () ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_right_5_0= ruleCastExpression ) ) )*
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==RULE_SKW_DIV||LA16_0==RULE_SKW_MOD||LA16_0==RULE_SKW_STAR) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// InternalCommon.g:1218:5: () ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_right_5_0= ruleCastExpression ) )
					{
					// InternalCommon.g:1218:5: ()
					// InternalCommon.g:1219:5: 
					{

					        current = forceCreateModelElementAndSet(
					            grammarAccess.getMultiplicativeExpressionAccess().getMultiplicativeExpressionLeftAction_1_0(),
					            current);
					    
					}

					// InternalCommon.g:1227:3: ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) )
					int alt15=3;
					switch ( input.LA(1) ) {
					case RULE_SKW_STAR:
						{
						alt15=1;
						}
						break;
					case RULE_SKW_DIV:
						{
						alt15=2;
						}
						break;
					case RULE_SKW_MOD:
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
							// InternalCommon.g:1228:3: ( (lv_op_2_0= RULE_SKW_STAR ) )
							{
							// InternalCommon.g:1228:3: ( (lv_op_2_0= RULE_SKW_STAR ) )
							// InternalCommon.g:1229:3: (lv_op_2_0= RULE_SKW_STAR )
							{
							// InternalCommon.g:1229:3: (lv_op_2_0= RULE_SKW_STAR )
							// InternalCommon.g:1230:3: lv_op_2_0= RULE_SKW_STAR
							{
							lv_op_2_0=(Token)match(input,RULE_SKW_STAR,FOLLOW_4); 

										newLeafNode(lv_op_2_0, grammarAccess.getMultiplicativeExpressionAccess().getOpSKW_STARTerminalRuleCall_1_1_0_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
								        }
							       		setWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_2_0, 
							        		"at.jku.weiner.c.common.Common.SKW_STAR");
								    
							}

							}

							}
							break;
						case 2 :
							// InternalCommon.g:1250:3: ( (lv_op_3_0= RULE_SKW_DIV ) )
							{
							// InternalCommon.g:1250:3: ( (lv_op_3_0= RULE_SKW_DIV ) )
							// InternalCommon.g:1251:3: (lv_op_3_0= RULE_SKW_DIV )
							{
							// InternalCommon.g:1251:3: (lv_op_3_0= RULE_SKW_DIV )
							// InternalCommon.g:1252:3: lv_op_3_0= RULE_SKW_DIV
							{
							lv_op_3_0=(Token)match(input,RULE_SKW_DIV,FOLLOW_4); 

										newLeafNode(lv_op_3_0, grammarAccess.getMultiplicativeExpressionAccess().getOpSKW_DIVTerminalRuleCall_1_1_1_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
								        }
							       		setWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_3_0, 
							        		"at.jku.weiner.c.common.Common.SKW_DIV");
								    
							}

							}

							}
							break;
						case 3 :
							// InternalCommon.g:1272:3: ( (lv_op_4_0= RULE_SKW_MOD ) )
							{
							// InternalCommon.g:1272:3: ( (lv_op_4_0= RULE_SKW_MOD ) )
							// InternalCommon.g:1273:3: (lv_op_4_0= RULE_SKW_MOD )
							{
							// InternalCommon.g:1273:3: (lv_op_4_0= RULE_SKW_MOD )
							// InternalCommon.g:1274:3: lv_op_4_0= RULE_SKW_MOD
							{
							lv_op_4_0=(Token)match(input,RULE_SKW_MOD,FOLLOW_4); 

										newLeafNode(lv_op_4_0, grammarAccess.getMultiplicativeExpressionAccess().getOpSKW_MODTerminalRuleCall_1_1_2_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
								        }
							       		setWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_4_0, 
							        		"at.jku.weiner.c.common.Common.SKW_MOD");
								    
							}

							}

							}
							break;

					}

					// InternalCommon.g:1295:3: ( (lv_right_5_0= ruleCastExpression ) )
					// InternalCommon.g:1296:3: (lv_right_5_0= ruleCastExpression )
					{
					// InternalCommon.g:1296:3: (lv_right_5_0= ruleCastExpression )
					// InternalCommon.g:1297:3: lv_right_5_0= ruleCastExpression
					{
					 
						        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightCastExpressionParserRuleCall_1_2_0()); 
						    
					pushFollow(FOLLOW_15);
					lv_right_5_0=ruleCastExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
						        }
					       		set(
					       			current, 
					       			"right",
					        		lv_right_5_0, 
					        		"at.jku.weiner.c.common.Common.CastExpression");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;

				default :
					break loop16;
				}
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


				/*no after found*/


		}
		return current;
	}
	// $ANTLR end "ruleMultiplicativeExpression"



	// $ANTLR start "entryRuleCastExpression"
	// InternalCommon.g:1332:1: entryRuleCastExpression returns [EObject current=null] :iv_ruleCastExpression= ruleCastExpression EOF ;
	public final EObject entryRuleCastExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleCastExpression =null;

		try {
			// InternalCommon.g:1333:2: (iv_ruleCastExpression= ruleCastExpression EOF )
			// InternalCommon.g:1334:2: iv_ruleCastExpression= ruleCastExpression EOF
			{
			 newCompositeNode(grammarAccess.getCastExpressionRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleCastExpression=ruleCastExpression();
			state._fsp--;

			 current =iv_ruleCastExpression; 
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
	// $ANTLR end "entryRuleCastExpression"



	// $ANTLR start "ruleCastExpression"
	// InternalCommon.g:1341:1: ruleCastExpression returns [EObject current=null] :this_UnaryExpression_0= ruleUnaryExpression ;
	public final EObject ruleCastExpression() throws RecognitionException {
		EObject current = null;


		EObject this_UnaryExpression_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:1347:7: (this_UnaryExpression_0= ruleUnaryExpression )
			// InternalCommon.g:1350:5: this_UnaryExpression_0= ruleUnaryExpression
			{
			 
			        newCompositeNode(grammarAccess.getCastExpressionAccess().getUnaryExpressionParserRuleCall()); 
			    
			pushFollow(FOLLOW_2);
			this_UnaryExpression_0=ruleUnaryExpression();
			state._fsp--;

			 
			        current = this_UnaryExpression_0; 
			        afterParserOrEnumRuleCall();
			    
			}

			 leaveRule();
			    		
			     
		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving


				/*no after found*/


		}
		return current;
	}
	// $ANTLR end "ruleCastExpression"



	// $ANTLR start "entryRuleUnaryExpression"
	// InternalCommon.g:1373:1: entryRuleUnaryExpression returns [EObject current=null] :iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
	public final EObject entryRuleUnaryExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleUnaryExpression =null;

		try {
			// InternalCommon.g:1374:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
			// InternalCommon.g:1375:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
			{
			 newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleUnaryExpression=ruleUnaryExpression();
			state._fsp--;

			 current =iv_ruleUnaryExpression; 
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
	// $ANTLR end "entryRuleUnaryExpression"



	// $ANTLR start "ruleUnaryExpression"
	// InternalCommon.g:1382:1: ruleUnaryExpression returns [EObject current=null] : (this_PostfixExpression_0= rulePostfixExpression | ( () ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) ;
	public final EObject ruleUnaryExpression() throws RecognitionException {
		EObject current = null;


		EObject this_PostfixExpression_0 =null;
		AntlrDatatypeRuleToken lv_op_2_0 =null;
		EObject lv_expr_3_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:1388:7: ( (this_PostfixExpression_0= rulePostfixExpression | ( () ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) )
			// InternalCommon.g:1390:5: (this_PostfixExpression_0= rulePostfixExpression | ( () ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) )
			{
			// InternalCommon.g:1390:5: (this_PostfixExpression_0= rulePostfixExpression | ( () ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==RULE_BIN_LITERAL||(LA17_0 >= RULE_CHAR_LITERAL && LA17_0 <= RULE_DECIMAL_LITERAL)||LA17_0==RULE_FLOAT_LITERAL||(LA17_0 >= RULE_HEX_LITERAL && LA17_0 <= RULE_ID)||LA17_0==RULE_OCTAL_LITERAL||LA17_0==RULE_SKW_LEFTPAREN||LA17_0==RULE_STRING_LITERAL) ) {
				alt17=1;
			}
			else if ( (LA17_0==RULE_SKW_AND||LA17_0==RULE_SKW_MINUS||LA17_0==RULE_SKW_NOT||LA17_0==RULE_SKW_PLUS||(LA17_0 >= RULE_SKW_STAR && LA17_0 <= RULE_SKW_TILDE)) ) {
				alt17=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// InternalCommon.g:1392:5: this_PostfixExpression_0= rulePostfixExpression
					{
					 
					        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getPostfixExpressionParserRuleCall_0()); 
					    
					pushFollow(FOLLOW_2);
					this_PostfixExpression_0=rulePostfixExpression();
					state._fsp--;

					 
					        current = this_PostfixExpression_0; 
					        afterParserOrEnumRuleCall();
					    
					}
					break;
				case 2 :
					// InternalCommon.g:1404:5: ( () ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) )
					{
					// InternalCommon.g:1404:5: ( () ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) )
					// InternalCommon.g:1405:5: () ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) )
					{
					// InternalCommon.g:1405:5: ()
					// InternalCommon.g:1406:5: 
					{

					        current = forceCreateModelElement(
					            grammarAccess.getUnaryExpressionAccess().getUnaryExpressionAction_1_0(),
					            current);
					    
					}

					// InternalCommon.g:1414:3: ( (lv_op_2_0= ruleUnaryOperator ) )
					// InternalCommon.g:1415:3: (lv_op_2_0= ruleUnaryOperator )
					{
					// InternalCommon.g:1415:3: (lv_op_2_0= ruleUnaryOperator )
					// InternalCommon.g:1416:3: lv_op_2_0= ruleUnaryOperator
					{
					 
						        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_1_1_0()); 
						    
					pushFollow(FOLLOW_4);
					lv_op_2_0=ruleUnaryOperator();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
						        }
					       		set(
					       			current, 
					       			"op",
					        		lv_op_2_0, 
					        		"at.jku.weiner.c.common.Common.UnaryOperator");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					// InternalCommon.g:1435:3: ( (lv_expr_3_0= ruleCastExpression ) )
					// InternalCommon.g:1436:3: (lv_expr_3_0= ruleCastExpression )
					{
					// InternalCommon.g:1436:3: (lv_expr_3_0= ruleCastExpression )
					// InternalCommon.g:1437:3: lv_expr_3_0= ruleCastExpression
					{
					 
						        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExprCastExpressionParserRuleCall_1_2_0()); 
						    
					pushFollow(FOLLOW_2);
					lv_expr_3_0=ruleCastExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
						        }
					       		set(
					       			current, 
					       			"expr",
					        		lv_expr_3_0, 
					        		"at.jku.weiner.c.common.Common.CastExpression");
						        afterParserOrEnumRuleCall();
						    
					}

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


				/*no after found*/


		}
		return current;
	}
	// $ANTLR end "ruleUnaryExpression"



	// $ANTLR start "entryRuleUnaryOperator"
	// InternalCommon.g:1472:1: entryRuleUnaryOperator returns [String current=null] :iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
	public final String entryRuleUnaryOperator() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleUnaryOperator =null;

		try {
			// InternalCommon.g:1473:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
			// InternalCommon.g:1474:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
			{
			 newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleUnaryOperator=ruleUnaryOperator();
			state._fsp--;

			 current =iv_ruleUnaryOperator.getText(); 
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
	// $ANTLR end "entryRuleUnaryOperator"



	// $ANTLR start "ruleUnaryOperator"
	// InternalCommon.g:1481:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SKW_AND_0= RULE_SKW_AND |this_SKW_STAR_1= RULE_SKW_STAR |this_SKW_PLUS_2= RULE_SKW_PLUS |this_SKW_MINUS_3= RULE_SKW_MINUS |this_SKW_TILDE_4= RULE_SKW_TILDE |this_SKW_NOT_5= RULE_SKW_NOT ) ;
	public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token this_SKW_AND_0=null;
		Token this_SKW_STAR_1=null;
		Token this_SKW_PLUS_2=null;
		Token this_SKW_MINUS_3=null;
		Token this_SKW_TILDE_4=null;
		Token this_SKW_NOT_5=null;

		 enterRule(); 
		    
		try {
			// InternalCommon.g:1484:28: ( (this_SKW_AND_0= RULE_SKW_AND |this_SKW_STAR_1= RULE_SKW_STAR |this_SKW_PLUS_2= RULE_SKW_PLUS |this_SKW_MINUS_3= RULE_SKW_MINUS |this_SKW_TILDE_4= RULE_SKW_TILDE |this_SKW_NOT_5= RULE_SKW_NOT ) )
			// InternalCommon.g:1485:6: (this_SKW_AND_0= RULE_SKW_AND |this_SKW_STAR_1= RULE_SKW_STAR |this_SKW_PLUS_2= RULE_SKW_PLUS |this_SKW_MINUS_3= RULE_SKW_MINUS |this_SKW_TILDE_4= RULE_SKW_TILDE |this_SKW_NOT_5= RULE_SKW_NOT )
			{
			// InternalCommon.g:1485:6: (this_SKW_AND_0= RULE_SKW_AND |this_SKW_STAR_1= RULE_SKW_STAR |this_SKW_PLUS_2= RULE_SKW_PLUS |this_SKW_MINUS_3= RULE_SKW_MINUS |this_SKW_TILDE_4= RULE_SKW_TILDE |this_SKW_NOT_5= RULE_SKW_NOT )
			int alt18=6;
			switch ( input.LA(1) ) {
			case RULE_SKW_AND:
				{
				alt18=1;
				}
				break;
			case RULE_SKW_STAR:
				{
				alt18=2;
				}
				break;
			case RULE_SKW_PLUS:
				{
				alt18=3;
				}
				break;
			case RULE_SKW_MINUS:
				{
				alt18=4;
				}
				break;
			case RULE_SKW_TILDE:
				{
				alt18=5;
				}
				break;
			case RULE_SKW_NOT:
				{
				alt18=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}
			switch (alt18) {
				case 1 :
					// InternalCommon.g:1485:6: this_SKW_AND_0= RULE_SKW_AND
					{
					this_SKW_AND_0=(Token)match(input,RULE_SKW_AND,FOLLOW_2); 

							current.merge(this_SKW_AND_0);
					    
					 
					    newLeafNode(this_SKW_AND_0, grammarAccess.getUnaryOperatorAccess().getSKW_ANDTerminalRuleCall_0()); 
					    
					}
					break;
				case 2 :
					// InternalCommon.g:1493:10: this_SKW_STAR_1= RULE_SKW_STAR
					{
					this_SKW_STAR_1=(Token)match(input,RULE_SKW_STAR,FOLLOW_2); 

							current.merge(this_SKW_STAR_1);
					    
					 
					    newLeafNode(this_SKW_STAR_1, grammarAccess.getUnaryOperatorAccess().getSKW_STARTerminalRuleCall_1()); 
					    
					}
					break;
				case 3 :
					// InternalCommon.g:1501:10: this_SKW_PLUS_2= RULE_SKW_PLUS
					{
					this_SKW_PLUS_2=(Token)match(input,RULE_SKW_PLUS,FOLLOW_2); 

							current.merge(this_SKW_PLUS_2);
					    
					 
					    newLeafNode(this_SKW_PLUS_2, grammarAccess.getUnaryOperatorAccess().getSKW_PLUSTerminalRuleCall_2()); 
					    
					}
					break;
				case 4 :
					// InternalCommon.g:1509:10: this_SKW_MINUS_3= RULE_SKW_MINUS
					{
					this_SKW_MINUS_3=(Token)match(input,RULE_SKW_MINUS,FOLLOW_2); 

							current.merge(this_SKW_MINUS_3);
					    
					 
					    newLeafNode(this_SKW_MINUS_3, grammarAccess.getUnaryOperatorAccess().getSKW_MINUSTerminalRuleCall_3()); 
					    
					}
					break;
				case 5 :
					// InternalCommon.g:1517:10: this_SKW_TILDE_4= RULE_SKW_TILDE
					{
					this_SKW_TILDE_4=(Token)match(input,RULE_SKW_TILDE,FOLLOW_2); 

							current.merge(this_SKW_TILDE_4);
					    
					 
					    newLeafNode(this_SKW_TILDE_4, grammarAccess.getUnaryOperatorAccess().getSKW_TILDETerminalRuleCall_4()); 
					    
					}
					break;
				case 6 :
					// InternalCommon.g:1525:10: this_SKW_NOT_5= RULE_SKW_NOT
					{
					this_SKW_NOT_5=(Token)match(input,RULE_SKW_NOT,FOLLOW_2); 

							current.merge(this_SKW_NOT_5);
					    
					 
					    newLeafNode(this_SKW_NOT_5, grammarAccess.getUnaryOperatorAccess().getSKW_NOTTerminalRuleCall_5()); 
					    
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
	// $ANTLR end "ruleUnaryOperator"



	// $ANTLR start "entryRulePostfixExpression"
	// InternalCommon.g:1540:1: entryRulePostfixExpression returns [EObject current=null] :iv_rulePostfixExpression= rulePostfixExpression EOF ;
	public final EObject entryRulePostfixExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_rulePostfixExpression =null;

		try {
			// InternalCommon.g:1541:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
			// InternalCommon.g:1542:2: iv_rulePostfixExpression= rulePostfixExpression EOF
			{
			 newCompositeNode(grammarAccess.getPostfixExpressionRule()); 
			pushFollow(FOLLOW_1);
			iv_rulePostfixExpression=rulePostfixExpression();
			state._fsp--;

			 current =iv_rulePostfixExpression; 
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
	// $ANTLR end "entryRulePostfixExpression"



	// $ANTLR start "rulePostfixExpression"
	// InternalCommon.g:1549:1: rulePostfixExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) ) )* ) ;
	public final EObject rulePostfixExpression() throws RecognitionException {
		EObject current = null;


		EObject this_PrimaryExpression_0 =null;
		EObject lv_suffix_2_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:1555:7: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) ) )* ) )
			// InternalCommon.g:1557:5: (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) ) )* )
			{
			// InternalCommon.g:1557:5: (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) ) )* )
			// InternalCommon.g:1559:5: this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) ) )*
			{
			 
			        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getPrimaryExpressionParserRuleCall_0()); 
			    
			pushFollow(FOLLOW_16);
			this_PrimaryExpression_0=rulePrimaryExpression();
			state._fsp--;

			 
			        current = this_PrimaryExpression_0; 
			        afterParserOrEnumRuleCall();
			    
			// InternalCommon.g:1570:5: ( () ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) ) )*
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==RULE_SKW_LEFTPAREN) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// InternalCommon.g:1571:5: () ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )
					{
					// InternalCommon.g:1571:5: ()
					// InternalCommon.g:1572:5: 
					{

					        current = forceCreateModelElementAndSet(
					            grammarAccess.getPostfixExpressionAccess().getPostfixExpressionExprAction_1_0(),
					            current);
					    
					}

					// InternalCommon.g:1580:3: ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )
					// InternalCommon.g:1581:3: (lv_suffix_2_0= rulePostfixExpressionSuffixArgument )
					{
					// InternalCommon.g:1581:3: (lv_suffix_2_0= rulePostfixExpressionSuffixArgument )
					// InternalCommon.g:1582:3: lv_suffix_2_0= rulePostfixExpressionSuffixArgument
					{
					 
						        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getSuffixPostfixExpressionSuffixArgumentParserRuleCall_1_1_0()); 
						    
					pushFollow(FOLLOW_16);
					lv_suffix_2_0=rulePostfixExpressionSuffixArgument();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getPostfixExpressionRule());
						        }
					       		set(
					       			current, 
					       			"suffix",
					        		lv_suffix_2_0, 
					        		"at.jku.weiner.c.common.Common.PostfixExpressionSuffixArgument");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;

				default :
					break loop19;
				}
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


				/*no after found*/


		}
		return current;
	}
	// $ANTLR end "rulePostfixExpression"



	// $ANTLR start "entryRulePostfixExpressionSuffixArgument"
	// InternalCommon.g:1617:1: entryRulePostfixExpressionSuffixArgument returns [EObject current=null] :iv_rulePostfixExpressionSuffixArgument= rulePostfixExpressionSuffixArgument EOF ;
	public final EObject entryRulePostfixExpressionSuffixArgument() throws RecognitionException {
		EObject current = null;


		EObject iv_rulePostfixExpressionSuffixArgument =null;

		try {
			// InternalCommon.g:1618:2: (iv_rulePostfixExpressionSuffixArgument= rulePostfixExpressionSuffixArgument EOF )
			// InternalCommon.g:1619:2: iv_rulePostfixExpressionSuffixArgument= rulePostfixExpressionSuffixArgument EOF
			{
			 newCompositeNode(grammarAccess.getPostfixExpressionSuffixArgumentRule()); 
			pushFollow(FOLLOW_1);
			iv_rulePostfixExpressionSuffixArgument=rulePostfixExpressionSuffixArgument();
			state._fsp--;

			 current =iv_rulePostfixExpressionSuffixArgument; 
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
	// $ANTLR end "entryRulePostfixExpressionSuffixArgument"



	// $ANTLR start "rulePostfixExpressionSuffixArgument"
	// InternalCommon.g:1626:1: rulePostfixExpressionSuffixArgument returns [EObject current=null] : ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN ) ;
	public final EObject rulePostfixExpressionSuffixArgument() throws RecognitionException {
		EObject current = null;


		Token this_SKW_LEFTPAREN_1=null;
		Token this_SKW_RIGHTPAREN_3=null;
		EObject lv_argumentExpressionList_2_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:1632:7: ( ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN ) )
			// InternalCommon.g:1634:5: ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN )
			{
			// InternalCommon.g:1634:5: ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN )
			// InternalCommon.g:1635:5: () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN
			{
			// InternalCommon.g:1635:5: ()
			// InternalCommon.g:1636:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getPostfixExpressionSuffixArgumentAccess().getPostfixExpressionSuffixArgumentAction_0(),
			            current);
			    
			}

			this_SKW_LEFTPAREN_1=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_17); 
			 
			    newLeafNode(this_SKW_LEFTPAREN_1, grammarAccess.getPostfixExpressionSuffixArgumentAccess().getSKW_LEFTPARENTerminalRuleCall_1()); 
			    
			// InternalCommon.g:1651:3: ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==RULE_BIN_LITERAL||(LA20_0 >= RULE_CHAR_LITERAL && LA20_0 <= RULE_DECIMAL_LITERAL)||LA20_0==RULE_FLOAT_LITERAL||(LA20_0 >= RULE_HEX_LITERAL && LA20_0 <= RULE_ID)||(LA20_0 >= RULE_OCTAL_LITERAL && LA20_0 <= RULE_SKW_AND)||LA20_0==RULE_SKW_LEFTPAREN||LA20_0==RULE_SKW_MINUS||LA20_0==RULE_SKW_NOT||LA20_0==RULE_SKW_PLUS||(LA20_0 >= RULE_SKW_STAR && LA20_0 <= RULE_SKW_TILDE)||LA20_0==RULE_STRING_LITERAL) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// InternalCommon.g:1652:3: (lv_argumentExpressionList_2_0= ruleArgumentExpressionList )
					{
					// InternalCommon.g:1652:3: (lv_argumentExpressionList_2_0= ruleArgumentExpressionList )
					// InternalCommon.g:1653:3: lv_argumentExpressionList_2_0= ruleArgumentExpressionList
					{
					 
						        newCompositeNode(grammarAccess.getPostfixExpressionSuffixArgumentAccess().getArgumentExpressionListArgumentExpressionListParserRuleCall_2_0()); 
						    
					pushFollow(FOLLOW_18);
					lv_argumentExpressionList_2_0=ruleArgumentExpressionList();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getPostfixExpressionSuffixArgumentRule());
						        }
					       		set(
					       			current, 
					       			"argumentExpressionList",
					        		lv_argumentExpressionList_2_0, 
					        		"at.jku.weiner.c.common.Common.ArgumentExpressionList");
						        afterParserOrEnumRuleCall();
						    
					}

					}
					break;

			}

			this_SKW_RIGHTPAREN_3=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_2); 
			 
			    newLeafNode(this_SKW_RIGHTPAREN_3, grammarAccess.getPostfixExpressionSuffixArgumentAccess().getSKW_RIGHTPARENTerminalRuleCall_3()); 
			    
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


				/*no after found*/


		}
		return current;
	}
	// $ANTLR end "rulePostfixExpressionSuffixArgument"



	// $ANTLR start "entryRuleArgumentExpressionList"
	// InternalCommon.g:1693:1: entryRuleArgumentExpressionList returns [EObject current=null] :iv_ruleArgumentExpressionList= ruleArgumentExpressionList EOF ;
	public final EObject entryRuleArgumentExpressionList() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleArgumentExpressionList =null;

		try {
			// InternalCommon.g:1694:2: (iv_ruleArgumentExpressionList= ruleArgumentExpressionList EOF )
			// InternalCommon.g:1695:2: iv_ruleArgumentExpressionList= ruleArgumentExpressionList EOF
			{
			 newCompositeNode(grammarAccess.getArgumentExpressionListRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleArgumentExpressionList=ruleArgumentExpressionList();
			state._fsp--;

			 current =iv_ruleArgumentExpressionList; 
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
	// $ANTLR end "entryRuleArgumentExpressionList"



	// $ANTLR start "ruleArgumentExpressionList"
	// InternalCommon.g:1702:1: ruleArgumentExpressionList returns [EObject current=null] : ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* ) ;
	public final EObject ruleArgumentExpressionList() throws RecognitionException {
		EObject current = null;


		Token this_SKW_COMMA_1=null;
		EObject lv_expr_0_0 =null;
		EObject lv_expr_2_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:1708:7: ( ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* ) )
			// InternalCommon.g:1710:3: ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* )
			{
			// InternalCommon.g:1710:3: ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* )
			// InternalCommon.g:1711:3: ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )*
			{
			// InternalCommon.g:1711:3: ( (lv_expr_0_0= ruleConditionalExpression ) )
			// InternalCommon.g:1712:3: (lv_expr_0_0= ruleConditionalExpression )
			{
			// InternalCommon.g:1712:3: (lv_expr_0_0= ruleConditionalExpression )
			// InternalCommon.g:1713:3: lv_expr_0_0= ruleConditionalExpression
			{
			 
				        newCompositeNode(grammarAccess.getArgumentExpressionListAccess().getExprConditionalExpressionParserRuleCall_0_0()); 
				    
			pushFollow(FOLLOW_19);
			lv_expr_0_0=ruleConditionalExpression();
			state._fsp--;


				        if (current==null) {
				            current = createModelElementForParent(grammarAccess.getArgumentExpressionListRule());
				        }
			       		add(
			       			current, 
			       			"expr",
			        		lv_expr_0_0, 
			        		"at.jku.weiner.c.common.Common.ConditionalExpression");
				        afterParserOrEnumRuleCall();
				    
			}

			}

			// InternalCommon.g:1732:17: (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==RULE_SKW_COMMA) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// InternalCommon.g:1733:17: this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) )
					{
					this_SKW_COMMA_1=(Token)match(input,RULE_SKW_COMMA,FOLLOW_4); 
					 
					    newLeafNode(this_SKW_COMMA_1, grammarAccess.getArgumentExpressionListAccess().getSKW_COMMATerminalRuleCall_1_0()); 
					    
					// InternalCommon.g:1740:3: ( (lv_expr_2_0= ruleConditionalExpression ) )
					// InternalCommon.g:1741:3: (lv_expr_2_0= ruleConditionalExpression )
					{
					// InternalCommon.g:1741:3: (lv_expr_2_0= ruleConditionalExpression )
					// InternalCommon.g:1742:3: lv_expr_2_0= ruleConditionalExpression
					{
					 
						        newCompositeNode(grammarAccess.getArgumentExpressionListAccess().getExprConditionalExpressionParserRuleCall_1_1_0()); 
						    
					pushFollow(FOLLOW_19);
					lv_expr_2_0=ruleConditionalExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getArgumentExpressionListRule());
						        }
					       		add(
					       			current, 
					       			"expr",
					        		lv_expr_2_0, 
					        		"at.jku.weiner.c.common.Common.ConditionalExpression");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;

				default :
					break loop21;
				}
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


				/*no after found*/


		}
		return current;
	}
	// $ANTLR end "ruleArgumentExpressionList"



	// $ANTLR start "entryRulePrimaryExpression"
	// InternalCommon.g:1777:1: entryRulePrimaryExpression returns [EObject current=null] :iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
	public final EObject entryRulePrimaryExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_rulePrimaryExpression =null;

		try {
			// InternalCommon.g:1778:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
			// InternalCommon.g:1779:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
			{
			 newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
			pushFollow(FOLLOW_1);
			iv_rulePrimaryExpression=rulePrimaryExpression();
			state._fsp--;

			 current =iv_rulePrimaryExpression; 
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
	// $ANTLR end "entryRulePrimaryExpression"



	// $ANTLR start "rulePrimaryExpression"
	// InternalCommon.g:1786:1: rulePrimaryExpression returns [EObject current=null] : ( () ( ( (lv_const_1_0= ruleConstant1 ) ) | ( (lv_id_2_0= RULE_ID ) ) | ( ( (lv_parentheses_3_0= RULE_SKW_LEFTPAREN ) ) ( (lv_expr_4_0= ruleExpression ) ) this_SKW_RIGHTPAREN_5= RULE_SKW_RIGHTPAREN ) ) ) ;
	public final EObject rulePrimaryExpression() throws RecognitionException {
		EObject current = null;


		Token lv_id_2_0=null;
		Token lv_parentheses_3_0=null;
		Token this_SKW_RIGHTPAREN_5=null;
		AntlrDatatypeRuleToken lv_const_1_0 =null;
		EObject lv_expr_4_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:1792:7: ( ( () ( ( (lv_const_1_0= ruleConstant1 ) ) | ( (lv_id_2_0= RULE_ID ) ) | ( ( (lv_parentheses_3_0= RULE_SKW_LEFTPAREN ) ) ( (lv_expr_4_0= ruleExpression ) ) this_SKW_RIGHTPAREN_5= RULE_SKW_RIGHTPAREN ) ) ) )
			// InternalCommon.g:1794:5: ( () ( ( (lv_const_1_0= ruleConstant1 ) ) | ( (lv_id_2_0= RULE_ID ) ) | ( ( (lv_parentheses_3_0= RULE_SKW_LEFTPAREN ) ) ( (lv_expr_4_0= ruleExpression ) ) this_SKW_RIGHTPAREN_5= RULE_SKW_RIGHTPAREN ) ) )
			{
			// InternalCommon.g:1794:5: ( () ( ( (lv_const_1_0= ruleConstant1 ) ) | ( (lv_id_2_0= RULE_ID ) ) | ( ( (lv_parentheses_3_0= RULE_SKW_LEFTPAREN ) ) ( (lv_expr_4_0= ruleExpression ) ) this_SKW_RIGHTPAREN_5= RULE_SKW_RIGHTPAREN ) ) )
			// InternalCommon.g:1795:5: () ( ( (lv_const_1_0= ruleConstant1 ) ) | ( (lv_id_2_0= RULE_ID ) ) | ( ( (lv_parentheses_3_0= RULE_SKW_LEFTPAREN ) ) ( (lv_expr_4_0= ruleExpression ) ) this_SKW_RIGHTPAREN_5= RULE_SKW_RIGHTPAREN ) )
			{
			// InternalCommon.g:1795:5: ()
			// InternalCommon.g:1796:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_0(),
			            current);
			    
			}

			// InternalCommon.g:1804:3: ( ( (lv_const_1_0= ruleConstant1 ) ) | ( (lv_id_2_0= RULE_ID ) ) | ( ( (lv_parentheses_3_0= RULE_SKW_LEFTPAREN ) ) ( (lv_expr_4_0= ruleExpression ) ) this_SKW_RIGHTPAREN_5= RULE_SKW_RIGHTPAREN ) )
			int alt22=3;
			switch ( input.LA(1) ) {
			case RULE_BIN_LITERAL:
			case RULE_CHAR_LITERAL:
			case RULE_DECIMAL_LITERAL:
			case RULE_FLOAT_LITERAL:
			case RULE_HEX_LITERAL:
			case RULE_OCTAL_LITERAL:
			case RULE_STRING_LITERAL:
				{
				alt22=1;
				}
				break;
			case RULE_ID:
				{
				alt22=2;
				}
				break;
			case RULE_SKW_LEFTPAREN:
				{
				alt22=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}
			switch (alt22) {
				case 1 :
					// InternalCommon.g:1805:3: ( (lv_const_1_0= ruleConstant1 ) )
					{
					// InternalCommon.g:1805:3: ( (lv_const_1_0= ruleConstant1 ) )
					// InternalCommon.g:1806:3: (lv_const_1_0= ruleConstant1 )
					{
					// InternalCommon.g:1806:3: (lv_const_1_0= ruleConstant1 )
					// InternalCommon.g:1807:3: lv_const_1_0= ruleConstant1
					{
					 
						        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getConstConstant1ParserRuleCall_1_0_0()); 
						    
					pushFollow(FOLLOW_2);
					lv_const_1_0=ruleConstant1();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
						        }
					       		set(
					       			current, 
					       			"const",
					        		lv_const_1_0, 
					        		"at.jku.weiner.c.common.Common.Constant1");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;
				case 2 :
					// InternalCommon.g:1827:3: ( (lv_id_2_0= RULE_ID ) )
					{
					// InternalCommon.g:1827:3: ( (lv_id_2_0= RULE_ID ) )
					// InternalCommon.g:1828:3: (lv_id_2_0= RULE_ID )
					{
					// InternalCommon.g:1828:3: (lv_id_2_0= RULE_ID )
					// InternalCommon.g:1829:3: lv_id_2_0= RULE_ID
					{
					lv_id_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

								newLeafNode(lv_id_2_0, grammarAccess.getPrimaryExpressionAccess().getIdIDTerminalRuleCall_1_1_0()); 
							

						        if (current==null) {
						            current = createModelElement(grammarAccess.getPrimaryExpressionRule());
						        }
					       		setWithLastConsumed(
					       			current, 
					       			"id",
					        		lv_id_2_0, 
					        		"at.jku.weiner.c.common.Common.ID");
						    
					}

					}

					}
					break;
				case 3 :
					// InternalCommon.g:1849:3: ( ( (lv_parentheses_3_0= RULE_SKW_LEFTPAREN ) ) ( (lv_expr_4_0= ruleExpression ) ) this_SKW_RIGHTPAREN_5= RULE_SKW_RIGHTPAREN )
					{
					// InternalCommon.g:1849:3: ( ( (lv_parentheses_3_0= RULE_SKW_LEFTPAREN ) ) ( (lv_expr_4_0= ruleExpression ) ) this_SKW_RIGHTPAREN_5= RULE_SKW_RIGHTPAREN )
					// InternalCommon.g:1850:3: ( (lv_parentheses_3_0= RULE_SKW_LEFTPAREN ) ) ( (lv_expr_4_0= ruleExpression ) ) this_SKW_RIGHTPAREN_5= RULE_SKW_RIGHTPAREN
					{
					// InternalCommon.g:1850:3: ( (lv_parentheses_3_0= RULE_SKW_LEFTPAREN ) )
					// InternalCommon.g:1851:3: (lv_parentheses_3_0= RULE_SKW_LEFTPAREN )
					{
					// InternalCommon.g:1851:3: (lv_parentheses_3_0= RULE_SKW_LEFTPAREN )
					// InternalCommon.g:1852:3: lv_parentheses_3_0= RULE_SKW_LEFTPAREN
					{
					lv_parentheses_3_0=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_4); 

								newLeafNode(lv_parentheses_3_0, grammarAccess.getPrimaryExpressionAccess().getParenthesesSKW_LEFTPARENTerminalRuleCall_1_2_0_0()); 
							

						        if (current==null) {
						            current = createModelElement(grammarAccess.getPrimaryExpressionRule());
						        }
					       		setWithLastConsumed(
					       			current, 
					       			"parentheses",
					        		true, 
					        		"at.jku.weiner.c.common.Common.SKW_LEFTPAREN");
						    
					}

					}

					// InternalCommon.g:1871:3: ( (lv_expr_4_0= ruleExpression ) )
					// InternalCommon.g:1872:3: (lv_expr_4_0= ruleExpression )
					{
					// InternalCommon.g:1872:3: (lv_expr_4_0= ruleExpression )
					// InternalCommon.g:1873:3: lv_expr_4_0= ruleExpression
					{
					 
						        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExprExpressionParserRuleCall_1_2_1_0()); 
						    
					pushFollow(FOLLOW_18);
					lv_expr_4_0=ruleExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
						        }
					       		set(
					       			current, 
					       			"expr",
					        		lv_expr_4_0, 
					        		"at.jku.weiner.c.common.Common.Expression");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					this_SKW_RIGHTPAREN_5=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_2); 
					 
					    newLeafNode(this_SKW_RIGHTPAREN_5, grammarAccess.getPrimaryExpressionAccess().getSKW_RIGHTPARENTerminalRuleCall_1_2_2()); 
					    
					}

					}
					break;

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


				/*no after found*/


		}
		return current;
	}
	// $ANTLR end "rulePrimaryExpression"



	// $ANTLR start "entryRuleConstant1"
	// InternalCommon.g:1917:1: entryRuleConstant1 returns [String current=null] :iv_ruleConstant1= ruleConstant1 EOF ;
	public final String entryRuleConstant1() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleConstant1 =null;

		try {
			// InternalCommon.g:1918:2: (iv_ruleConstant1= ruleConstant1 EOF )
			// InternalCommon.g:1919:2: iv_ruleConstant1= ruleConstant1 EOF
			{
			 newCompositeNode(grammarAccess.getConstant1Rule()); 
			pushFollow(FOLLOW_1);
			iv_ruleConstant1=ruleConstant1();
			state._fsp--;

			 current =iv_ruleConstant1.getText(); 
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
	// $ANTLR end "entryRuleConstant1"



	// $ANTLR start "ruleConstant1"
	// InternalCommon.g:1926:1: ruleConstant1 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEX_LITERAL_0= RULE_HEX_LITERAL |this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL |this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL |this_CHAR_LITERAL_3= RULE_CHAR_LITERAL |this_STRING_LITERAL_4= RULE_STRING_LITERAL |this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL |this_BIN_LITERAL_6= RULE_BIN_LITERAL ) ;
	public final AntlrDatatypeRuleToken ruleConstant1() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token this_HEX_LITERAL_0=null;
		Token this_OCTAL_LITERAL_1=null;
		Token this_DECIMAL_LITERAL_2=null;
		Token this_CHAR_LITERAL_3=null;
		Token this_STRING_LITERAL_4=null;
		Token this_FLOAT_LITERAL_5=null;
		Token this_BIN_LITERAL_6=null;

		 enterRule(); 
		    
		try {
			// InternalCommon.g:1929:28: ( (this_HEX_LITERAL_0= RULE_HEX_LITERAL |this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL |this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL |this_CHAR_LITERAL_3= RULE_CHAR_LITERAL |this_STRING_LITERAL_4= RULE_STRING_LITERAL |this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL |this_BIN_LITERAL_6= RULE_BIN_LITERAL ) )
			// InternalCommon.g:1930:6: (this_HEX_LITERAL_0= RULE_HEX_LITERAL |this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL |this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL |this_CHAR_LITERAL_3= RULE_CHAR_LITERAL |this_STRING_LITERAL_4= RULE_STRING_LITERAL |this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL |this_BIN_LITERAL_6= RULE_BIN_LITERAL )
			{
			// InternalCommon.g:1930:6: (this_HEX_LITERAL_0= RULE_HEX_LITERAL |this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL |this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL |this_CHAR_LITERAL_3= RULE_CHAR_LITERAL |this_STRING_LITERAL_4= RULE_STRING_LITERAL |this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL |this_BIN_LITERAL_6= RULE_BIN_LITERAL )
			int alt23=7;
			switch ( input.LA(1) ) {
			case RULE_HEX_LITERAL:
				{
				alt23=1;
				}
				break;
			case RULE_OCTAL_LITERAL:
				{
				alt23=2;
				}
				break;
			case RULE_DECIMAL_LITERAL:
				{
				alt23=3;
				}
				break;
			case RULE_CHAR_LITERAL:
				{
				alt23=4;
				}
				break;
			case RULE_STRING_LITERAL:
				{
				alt23=5;
				}
				break;
			case RULE_FLOAT_LITERAL:
				{
				alt23=6;
				}
				break;
			case RULE_BIN_LITERAL:
				{
				alt23=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}
			switch (alt23) {
				case 1 :
					// InternalCommon.g:1930:6: this_HEX_LITERAL_0= RULE_HEX_LITERAL
					{
					this_HEX_LITERAL_0=(Token)match(input,RULE_HEX_LITERAL,FOLLOW_2); 

							current.merge(this_HEX_LITERAL_0);
					    
					 
					    newLeafNode(this_HEX_LITERAL_0, grammarAccess.getConstant1Access().getHEX_LITERALTerminalRuleCall_0()); 
					    
					}
					break;
				case 2 :
					// InternalCommon.g:1938:10: this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL
					{
					this_OCTAL_LITERAL_1=(Token)match(input,RULE_OCTAL_LITERAL,FOLLOW_2); 

							current.merge(this_OCTAL_LITERAL_1);
					    
					 
					    newLeafNode(this_OCTAL_LITERAL_1, grammarAccess.getConstant1Access().getOCTAL_LITERALTerminalRuleCall_1()); 
					    
					}
					break;
				case 3 :
					// InternalCommon.g:1946:10: this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL
					{
					this_DECIMAL_LITERAL_2=(Token)match(input,RULE_DECIMAL_LITERAL,FOLLOW_2); 

							current.merge(this_DECIMAL_LITERAL_2);
					    
					 
					    newLeafNode(this_DECIMAL_LITERAL_2, grammarAccess.getConstant1Access().getDECIMAL_LITERALTerminalRuleCall_2()); 
					    
					}
					break;
				case 4 :
					// InternalCommon.g:1954:10: this_CHAR_LITERAL_3= RULE_CHAR_LITERAL
					{
					this_CHAR_LITERAL_3=(Token)match(input,RULE_CHAR_LITERAL,FOLLOW_2); 

							current.merge(this_CHAR_LITERAL_3);
					    
					 
					    newLeafNode(this_CHAR_LITERAL_3, grammarAccess.getConstant1Access().getCHAR_LITERALTerminalRuleCall_3()); 
					    
					}
					break;
				case 5 :
					// InternalCommon.g:1962:10: this_STRING_LITERAL_4= RULE_STRING_LITERAL
					{
					this_STRING_LITERAL_4=(Token)match(input,RULE_STRING_LITERAL,FOLLOW_2); 

							current.merge(this_STRING_LITERAL_4);
					    
					 
					    newLeafNode(this_STRING_LITERAL_4, grammarAccess.getConstant1Access().getSTRING_LITERALTerminalRuleCall_4()); 
					    
					}
					break;
				case 6 :
					// InternalCommon.g:1970:10: this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL
					{
					this_FLOAT_LITERAL_5=(Token)match(input,RULE_FLOAT_LITERAL,FOLLOW_2); 

							current.merge(this_FLOAT_LITERAL_5);
					    
					 
					    newLeafNode(this_FLOAT_LITERAL_5, grammarAccess.getConstant1Access().getFLOAT_LITERALTerminalRuleCall_5()); 
					    
					}
					break;
				case 7 :
					// InternalCommon.g:1978:10: this_BIN_LITERAL_6= RULE_BIN_LITERAL
					{
					this_BIN_LITERAL_6=(Token)match(input,RULE_BIN_LITERAL,FOLLOW_2); 

							current.merge(this_BIN_LITERAL_6);
					    
					 
					    newLeafNode(this_BIN_LITERAL_6, grammarAccess.getConstant1Access().getBIN_LITERALTerminalRuleCall_6()); 
					    
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
	// $ANTLR end "ruleConstant1"

	// Delegated rules



	public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0400000000000002L});
	public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0112200030018990L,0x0000000000000046L});
	public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0080000000000002L});
	public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000040000002L});
	public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0040000000000002L});
	public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0020010000000002L});
	public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0001860000000002L});
	public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x4000400000000002L});
	public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0102000000000002L});
	public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0008001000000002L,0x0000000000000002L});
	public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000200000000002L});
	public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x2112200030018990L,0x0000000000000046L});
	public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000800000002L});
}
