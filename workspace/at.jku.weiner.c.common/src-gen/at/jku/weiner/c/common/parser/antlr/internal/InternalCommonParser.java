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
		"RULE_HEX_LITERAL", "RULE_ID", "RULE_IDENTIFIER", "RULE_INTEGER_TYPE_SUFFIX", 
		"RULE_LETTER", "RULE_LINEBREAK", "RULE_LINEFEED", "RULE_LINE_COMMENT", 
		"RULE_NEWLINE", "RULE_OCTAL_ESCAPE", "RULE_OCTAL_LITERAL", "RULE_SKW_AND", 
		"RULE_SKW_ANDAND", "RULE_SKW_ASSIGN", "RULE_SKW_BACKSLASH", "RULE_SKW_CARET", 
		"RULE_SKW_COLON", "RULE_SKW_COMMA", "RULE_SKW_DIV", "RULE_SKW_DOLLAR", 
		"RULE_SKW_DOT", "RULE_SKW_DOUBLEQUOTE", "RULE_SKW_EQUAL", "RULE_SKW_GREATER", 
		"RULE_SKW_GREATEREQUAL", "RULE_SKW_LEFTBRACE", "RULE_SKW_LEFTBRACKET", 
		"RULE_SKW_LEFTPAREN", "RULE_SKW_LEFTSHIFT", "RULE_SKW_LESS", "RULE_SKW_LESSEQUAL", 
		"RULE_SKW_MINUS", "RULE_SKW_MINUSMINUS", "RULE_SKW_MOD", "RULE_SKW_NOT", 
		"RULE_SKW_NOTEQUAL", "RULE_SKW_OR", "RULE_SKW_OROR", "RULE_SKW_PLUS", 
		"RULE_SKW_PLUSPLUS", "RULE_SKW_QUESTION", "RULE_SKW_RIGHTBRACE", "RULE_SKW_RIGHTBRACKET", 
		"RULE_SKW_RIGHTPAREN", "RULE_SKW_RIGHTSHIFT", "RULE_SKW_SEMI", "RULE_SKW_SINGLEQUOTE", 
		"RULE_SKW_STAR", "RULE_SKW_TILDE", "RULE_SKW_UNDERSCORE", "RULE_SPACE", 
		"RULE_SPECIAL", "RULE_STRING_LITERAL", "RULE_TAB", "RULE_WHITESPACE"
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
	public static final int RULE_HEX_LITERAL=14;
	public static final int RULE_ID=15;
	public static final int RULE_IDENTIFIER=16;
	public static final int RULE_INTEGER_TYPE_SUFFIX=17;
	public static final int RULE_LETTER=18;
	public static final int RULE_LINEBREAK=19;
	public static final int RULE_LINEFEED=20;
	public static final int RULE_LINE_COMMENT=21;
	public static final int RULE_NEWLINE=22;
	public static final int RULE_OCTAL_ESCAPE=23;
	public static final int RULE_OCTAL_LITERAL=24;
	public static final int RULE_SKW_AND=25;
	public static final int RULE_SKW_ANDAND=26;
	public static final int RULE_SKW_ASSIGN=27;
	public static final int RULE_SKW_BACKSLASH=28;
	public static final int RULE_SKW_CARET=29;
	public static final int RULE_SKW_COLON=30;
	public static final int RULE_SKW_COMMA=31;
	public static final int RULE_SKW_DIV=32;
	public static final int RULE_SKW_DOLLAR=33;
	public static final int RULE_SKW_DOT=34;
	public static final int RULE_SKW_DOUBLEQUOTE=35;
	public static final int RULE_SKW_EQUAL=36;
	public static final int RULE_SKW_GREATER=37;
	public static final int RULE_SKW_GREATEREQUAL=38;
	public static final int RULE_SKW_LEFTBRACE=39;
	public static final int RULE_SKW_LEFTBRACKET=40;
	public static final int RULE_SKW_LEFTPAREN=41;
	public static final int RULE_SKW_LEFTSHIFT=42;
	public static final int RULE_SKW_LESS=43;
	public static final int RULE_SKW_LESSEQUAL=44;
	public static final int RULE_SKW_MINUS=45;
	public static final int RULE_SKW_MINUSMINUS=46;
	public static final int RULE_SKW_MOD=47;
	public static final int RULE_SKW_NOT=48;
	public static final int RULE_SKW_NOTEQUAL=49;
	public static final int RULE_SKW_OR=50;
	public static final int RULE_SKW_OROR=51;
	public static final int RULE_SKW_PLUS=52;
	public static final int RULE_SKW_PLUSPLUS=53;
	public static final int RULE_SKW_QUESTION=54;
	public static final int RULE_SKW_RIGHTBRACE=55;
	public static final int RULE_SKW_RIGHTBRACKET=56;
	public static final int RULE_SKW_RIGHTPAREN=57;
	public static final int RULE_SKW_RIGHTSHIFT=58;
	public static final int RULE_SKW_SEMI=59;
	public static final int RULE_SKW_SINGLEQUOTE=60;
	public static final int RULE_SKW_STAR=61;
	public static final int RULE_SKW_TILDE=62;
	public static final int RULE_SKW_UNDERSCORE=63;
	public static final int RULE_SPACE=64;
	public static final int RULE_SPECIAL=65;
	public static final int RULE_STRING_LITERAL=66;
	public static final int RULE_TAB=67;
	public static final int RULE_WHITESPACE=68;

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
	    	return "Common";	
	   	}
	   	
	   	@Override
	   	protected CommonGrammarAccess getGrammarAccess() {
	   		return grammarAccess;
	   	}



	// $ANTLR start "entryRuleCommon"
	// InternalCommon.g:68:1: entryRuleCommon returns [EObject current=null] :iv_ruleCommon= ruleCommon EOF ;
	public final EObject entryRuleCommon() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleCommon =null;

		try {
			// InternalCommon.g:69:2: (iv_ruleCommon= ruleCommon EOF )
			// InternalCommon.g:70:2: iv_ruleCommon= ruleCommon EOF
			{
			 newCompositeNode(grammarAccess.getCommonRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleCommon=ruleCommon();
			state._fsp--;

			 current =iv_ruleCommon; 
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
	// $ANTLR end "entryRuleCommon"



	// $ANTLR start "ruleCommon"
	// InternalCommon.g:77:1: ruleCommon returns [EObject current=null] : () ;
	public final EObject ruleCommon() throws RecognitionException {
		EObject current = null;


		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:83:7: ( () )
			// InternalCommon.g:85:5: ()
			{
			// InternalCommon.g:85:5: ()
			// InternalCommon.g:86:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getCommonAccess().getCommonAction(),
			            current);
			    
			}

			}

			 leaveRule();
			    		/*no after found*/
			     
		}
		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleCommon"



	// $ANTLR start "entryRuleExpression"
	// InternalCommon.g:101:1: entryRuleExpression returns [EObject current=null] :iv_ruleExpression= ruleExpression EOF ;
	public final EObject entryRuleExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleExpression =null;

		 
				HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WHITESPACE", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT", "RULE_LINEBREAK");
			
		try {
			// InternalCommon.g:105:2: (iv_ruleExpression= ruleExpression EOF )
			// InternalCommon.g:106:2: iv_ruleExpression= ruleExpression EOF
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
	// InternalCommon.g:116:1: ruleExpression returns [EObject current=null] : ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) ) ;
	public final EObject ruleExpression() throws RecognitionException {
		EObject current = null;


		EObject lv_expression_1_0 =null;

		 enterRule();
		   		/*no init found*/
				HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WHITESPACE", "RULE_BLOCK_COMMENT", "RULE_LINE_COMMENT", "RULE_LINEBREAK");
		    
		try {
			// InternalCommon.g:123:7: ( ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) ) )
			// InternalCommon.g:125:5: ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) )
			{
			// InternalCommon.g:125:5: ( () ( (lv_expression_1_0= ruleConditionalExpression ) ) )
			// InternalCommon.g:126:5: () ( (lv_expression_1_0= ruleConditionalExpression ) )
			{
			// InternalCommon.g:126:5: ()
			// InternalCommon.g:127:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getExpressionAccess().getExpressionAction_0(),
			            current);
			    
			}

			// InternalCommon.g:135:3: ( (lv_expression_1_0= ruleConditionalExpression ) )
			// InternalCommon.g:136:3: (lv_expression_1_0= ruleConditionalExpression )
			{
			// InternalCommon.g:136:3: (lv_expression_1_0= ruleConditionalExpression )
			// InternalCommon.g:137:3: lv_expression_1_0= ruleConditionalExpression
			{
			 
				        newCompositeNode(grammarAccess.getExpressionAccess().getExpressionConditionalExpressionParserRuleCall_1_0()); 
				    
			pushFollow(FOLLOW_2);
			lv_expression_1_0=ruleConditionalExpression();
			state._fsp--;


				        if (current==null) {
				            current = createModelElementForParent(grammarAccess.getExpressionRule());
				        }
			       		set(
			       			current, 
			       			"expression",
			        		lv_expression_1_0, 
			        		"at.jku.weiner.c.common.Common.ConditionalExpression");
				        afterParserOrEnumRuleCall();
				    
			}

			}

			}

			}

			 leaveRule();
			    		/*no after found*/
			     
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
	// $ANTLR end "ruleExpression"



	// $ANTLR start "entryRuleConditionalExpression"
	// InternalCommon.g:170:1: entryRuleConditionalExpression returns [EObject current=null] :iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
	public final EObject entryRuleConditionalExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleConditionalExpression =null;

		try {
			// InternalCommon.g:171:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
			// InternalCommon.g:172:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
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
	// InternalCommon.g:179:1: ruleConditionalExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? ) ;
	public final EObject ruleConditionalExpression() throws RecognitionException {
		EObject current = null;


		Token this_SKW_QUESTION_2=null;
		Token this_SKW_COLON_4=null;
		EObject lv_expr_1_0 =null;
		EObject lv_qExpr_3_0 =null;
		EObject lv_cExpr_5_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:185:7: ( ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? ) )
			// InternalCommon.g:187:5: ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? )
			{
			// InternalCommon.g:187:5: ( () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )? )
			// InternalCommon.g:188:5: () ( (lv_expr_1_0= ruleLogicalOrExpression ) ) (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )?
			{
			// InternalCommon.g:188:5: ()
			// InternalCommon.g:189:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getConditionalExpressionAccess().getConditionalExpressionAction_0(),
			            current);
			    
			}

			// InternalCommon.g:197:3: ( (lv_expr_1_0= ruleLogicalOrExpression ) )
			// InternalCommon.g:198:3: (lv_expr_1_0= ruleLogicalOrExpression )
			{
			// InternalCommon.g:198:3: (lv_expr_1_0= ruleLogicalOrExpression )
			// InternalCommon.g:199:3: lv_expr_1_0= ruleLogicalOrExpression
			{
			 
				        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getExprLogicalOrExpressionParserRuleCall_1_0()); 
				    
			pushFollow(FOLLOW_3);
			lv_expr_1_0=ruleLogicalOrExpression();
			state._fsp--;


				        if (current==null) {
				            current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
				        }
			       		set(
			       			current, 
			       			"expr",
			        		lv_expr_1_0, 
			        		"at.jku.weiner.c.common.Common.LogicalOrExpression");
				        afterParserOrEnumRuleCall();
				    
			}

			}

			// InternalCommon.g:218:20: (this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) ) )?
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==RULE_SKW_QUESTION) ) {
				alt1=1;
			}
			switch (alt1) {
				case 1 :
					// InternalCommon.g:219:20: this_SKW_QUESTION_2= RULE_SKW_QUESTION ( (lv_qExpr_3_0= ruleExpression ) ) this_SKW_COLON_4= RULE_SKW_COLON ( (lv_cExpr_5_0= ruleConditionalExpression ) )
					{
					this_SKW_QUESTION_2=(Token)match(input,RULE_SKW_QUESTION,FOLLOW_4); 
					 
					    newLeafNode(this_SKW_QUESTION_2, grammarAccess.getConditionalExpressionAccess().getSKW_QUESTIONTerminalRuleCall_2_0()); 
					    
					// InternalCommon.g:226:3: ( (lv_qExpr_3_0= ruleExpression ) )
					// InternalCommon.g:227:3: (lv_qExpr_3_0= ruleExpression )
					{
					// InternalCommon.g:227:3: (lv_qExpr_3_0= ruleExpression )
					// InternalCommon.g:228:3: lv_qExpr_3_0= ruleExpression
					{
					 
						        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getQExprExpressionParserRuleCall_2_1_0()); 
						    
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
					 
					    newLeafNode(this_SKW_COLON_4, grammarAccess.getConditionalExpressionAccess().getSKW_COLONTerminalRuleCall_2_2()); 
					    
					// InternalCommon.g:254:3: ( (lv_cExpr_5_0= ruleConditionalExpression ) )
					// InternalCommon.g:255:3: (lv_cExpr_5_0= ruleConditionalExpression )
					{
					// InternalCommon.g:255:3: (lv_cExpr_5_0= ruleConditionalExpression )
					// InternalCommon.g:256:3: lv_cExpr_5_0= ruleConditionalExpression
					{
					 
						        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getCExprConditionalExpressionParserRuleCall_2_3_0()); 
						    
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
			    		/*no after found*/
			     
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
	// $ANTLR end "ruleConditionalExpression"



	// $ANTLR start "entryRuleLogicalOrExpression"
	// InternalCommon.g:286:1: entryRuleLogicalOrExpression returns [EObject current=null] :iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
	public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleLogicalOrExpression =null;

		try {
			// InternalCommon.g:287:2: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
			// InternalCommon.g:288:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
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
	// InternalCommon.g:295:1: ruleLogicalOrExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* ) ;
	public final EObject ruleLogicalOrExpression() throws RecognitionException {
		EObject current = null;


		Token this_SKW_OROR_2=null;
		EObject lv_expr_1_0 =null;
		EObject lv_expr_3_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:301:7: ( ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* ) )
			// InternalCommon.g:303:5: ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* )
			{
			// InternalCommon.g:303:5: ( () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )* )
			// InternalCommon.g:304:5: () ( (lv_expr_1_0= ruleLogicalAndExpression ) ) (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )*
			{
			// InternalCommon.g:304:5: ()
			// InternalCommon.g:305:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionAction_0(),
			            current);
			    
			}

			// InternalCommon.g:313:3: ( (lv_expr_1_0= ruleLogicalAndExpression ) )
			// InternalCommon.g:314:3: (lv_expr_1_0= ruleLogicalAndExpression )
			{
			// InternalCommon.g:314:3: (lv_expr_1_0= ruleLogicalAndExpression )
			// InternalCommon.g:315:3: lv_expr_1_0= ruleLogicalAndExpression
			{
			 
				        newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getExprLogicalAndExpressionParserRuleCall_1_0()); 
				    
			pushFollow(FOLLOW_6);
			lv_expr_1_0=ruleLogicalAndExpression();
			state._fsp--;


				        if (current==null) {
				            current = createModelElementForParent(grammarAccess.getLogicalOrExpressionRule());
				        }
			       		add(
			       			current, 
			       			"expr",
			        		lv_expr_1_0, 
			        		"at.jku.weiner.c.common.Common.LogicalAndExpression");
				        afterParserOrEnumRuleCall();
				    
			}

			}

			// InternalCommon.g:334:16: (this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) ) )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==RULE_SKW_OROR) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// InternalCommon.g:335:16: this_SKW_OROR_2= RULE_SKW_OROR ( (lv_expr_3_0= ruleLogicalAndExpression ) )
					{
					this_SKW_OROR_2=(Token)match(input,RULE_SKW_OROR,FOLLOW_4); 
					 
					    newLeafNode(this_SKW_OROR_2, grammarAccess.getLogicalOrExpressionAccess().getSKW_ORORTerminalRuleCall_2_0()); 
					    
					// InternalCommon.g:342:3: ( (lv_expr_3_0= ruleLogicalAndExpression ) )
					// InternalCommon.g:343:3: (lv_expr_3_0= ruleLogicalAndExpression )
					{
					// InternalCommon.g:343:3: (lv_expr_3_0= ruleLogicalAndExpression )
					// InternalCommon.g:344:3: lv_expr_3_0= ruleLogicalAndExpression
					{
					 
						        newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getExprLogicalAndExpressionParserRuleCall_2_1_0()); 
						    
					pushFollow(FOLLOW_6);
					lv_expr_3_0=ruleLogicalAndExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getLogicalOrExpressionRule());
						        }
					       		add(
					       			current, 
					       			"expr",
					        		lv_expr_3_0, 
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
			    		/*no after found*/
			     
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
	// $ANTLR end "ruleLogicalOrExpression"



	// $ANTLR start "entryRuleLogicalAndExpression"
	// InternalCommon.g:374:1: entryRuleLogicalAndExpression returns [EObject current=null] :iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
	public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleLogicalAndExpression =null;

		try {
			// InternalCommon.g:375:2: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
			// InternalCommon.g:376:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
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
	// InternalCommon.g:383:1: ruleLogicalAndExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* ) ;
	public final EObject ruleLogicalAndExpression() throws RecognitionException {
		EObject current = null;


		Token this_SKW_ANDAND_2=null;
		EObject lv_expr_1_0 =null;
		EObject lv_expr_3_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:389:7: ( ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* ) )
			// InternalCommon.g:391:5: ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* )
			{
			// InternalCommon.g:391:5: ( () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )* )
			// InternalCommon.g:392:5: () ( (lv_expr_1_0= ruleInclusiveOrExpression ) ) (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )*
			{
			// InternalCommon.g:392:5: ()
			// InternalCommon.g:393:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionAction_0(),
			            current);
			    
			}

			// InternalCommon.g:401:3: ( (lv_expr_1_0= ruleInclusiveOrExpression ) )
			// InternalCommon.g:402:3: (lv_expr_1_0= ruleInclusiveOrExpression )
			{
			// InternalCommon.g:402:3: (lv_expr_1_0= ruleInclusiveOrExpression )
			// InternalCommon.g:403:3: lv_expr_1_0= ruleInclusiveOrExpression
			{
			 
				        newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getExprInclusiveOrExpressionParserRuleCall_1_0()); 
				    
			pushFollow(FOLLOW_7);
			lv_expr_1_0=ruleInclusiveOrExpression();
			state._fsp--;


				        if (current==null) {
				            current = createModelElementForParent(grammarAccess.getLogicalAndExpressionRule());
				        }
			       		add(
			       			current, 
			       			"expr",
			        		lv_expr_1_0, 
			        		"at.jku.weiner.c.common.Common.InclusiveOrExpression");
				        afterParserOrEnumRuleCall();
				    
			}

			}

			// InternalCommon.g:422:18: (this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) ) )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==RULE_SKW_ANDAND) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// InternalCommon.g:423:18: this_SKW_ANDAND_2= RULE_SKW_ANDAND ( (lv_expr_3_0= ruleInclusiveOrExpression ) )
					{
					this_SKW_ANDAND_2=(Token)match(input,RULE_SKW_ANDAND,FOLLOW_4); 
					 
					    newLeafNode(this_SKW_ANDAND_2, grammarAccess.getLogicalAndExpressionAccess().getSKW_ANDANDTerminalRuleCall_2_0()); 
					    
					// InternalCommon.g:430:3: ( (lv_expr_3_0= ruleInclusiveOrExpression ) )
					// InternalCommon.g:431:3: (lv_expr_3_0= ruleInclusiveOrExpression )
					{
					// InternalCommon.g:431:3: (lv_expr_3_0= ruleInclusiveOrExpression )
					// InternalCommon.g:432:3: lv_expr_3_0= ruleInclusiveOrExpression
					{
					 
						        newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getExprInclusiveOrExpressionParserRuleCall_2_1_0()); 
						    
					pushFollow(FOLLOW_7);
					lv_expr_3_0=ruleInclusiveOrExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getLogicalAndExpressionRule());
						        }
					       		add(
					       			current, 
					       			"expr",
					        		lv_expr_3_0, 
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
			    		/*no after found*/
			     
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
	// $ANTLR end "ruleLogicalAndExpression"



	// $ANTLR start "entryRuleInclusiveOrExpression"
	// InternalCommon.g:462:1: entryRuleInclusiveOrExpression returns [EObject current=null] :iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF ;
	public final EObject entryRuleInclusiveOrExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleInclusiveOrExpression =null;

		try {
			// InternalCommon.g:463:2: (iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF )
			// InternalCommon.g:464:2: iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF
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
	// InternalCommon.g:471:1: ruleInclusiveOrExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* ) ;
	public final EObject ruleInclusiveOrExpression() throws RecognitionException {
		EObject current = null;


		Token this_SKW_OR_2=null;
		EObject lv_expr_1_0 =null;
		EObject lv_expr_3_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:477:7: ( ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* ) )
			// InternalCommon.g:479:5: ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* )
			{
			// InternalCommon.g:479:5: ( () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )* )
			// InternalCommon.g:480:5: () ( (lv_expr_1_0= ruleExclusiveOrExpression ) ) (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )*
			{
			// InternalCommon.g:480:5: ()
			// InternalCommon.g:481:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getInclusiveOrExpressionAccess().getInclusiveOrExpressionAction_0(),
			            current);
			    
			}

			// InternalCommon.g:489:3: ( (lv_expr_1_0= ruleExclusiveOrExpression ) )
			// InternalCommon.g:490:3: (lv_expr_1_0= ruleExclusiveOrExpression )
			{
			// InternalCommon.g:490:3: (lv_expr_1_0= ruleExclusiveOrExpression )
			// InternalCommon.g:491:3: lv_expr_1_0= ruleExclusiveOrExpression
			{
			 
				        newCompositeNode(grammarAccess.getInclusiveOrExpressionAccess().getExprExclusiveOrExpressionParserRuleCall_1_0()); 
				    
			pushFollow(FOLLOW_8);
			lv_expr_1_0=ruleExclusiveOrExpression();
			state._fsp--;


				        if (current==null) {
				            current = createModelElementForParent(grammarAccess.getInclusiveOrExpressionRule());
				        }
			       		add(
			       			current, 
			       			"expr",
			        		lv_expr_1_0, 
			        		"at.jku.weiner.c.common.Common.ExclusiveOrExpression");
				        afterParserOrEnumRuleCall();
				    
			}

			}

			// InternalCommon.g:510:14: (this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) ) )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==RULE_SKW_OR) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// InternalCommon.g:511:14: this_SKW_OR_2= RULE_SKW_OR ( (lv_expr_3_0= ruleExclusiveOrExpression ) )
					{
					this_SKW_OR_2=(Token)match(input,RULE_SKW_OR,FOLLOW_4); 
					 
					    newLeafNode(this_SKW_OR_2, grammarAccess.getInclusiveOrExpressionAccess().getSKW_ORTerminalRuleCall_2_0()); 
					    
					// InternalCommon.g:518:3: ( (lv_expr_3_0= ruleExclusiveOrExpression ) )
					// InternalCommon.g:519:3: (lv_expr_3_0= ruleExclusiveOrExpression )
					{
					// InternalCommon.g:519:3: (lv_expr_3_0= ruleExclusiveOrExpression )
					// InternalCommon.g:520:3: lv_expr_3_0= ruleExclusiveOrExpression
					{
					 
						        newCompositeNode(grammarAccess.getInclusiveOrExpressionAccess().getExprExclusiveOrExpressionParserRuleCall_2_1_0()); 
						    
					pushFollow(FOLLOW_8);
					lv_expr_3_0=ruleExclusiveOrExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getInclusiveOrExpressionRule());
						        }
					       		add(
					       			current, 
					       			"expr",
					        		lv_expr_3_0, 
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
			    		/*no after found*/
			     
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
	// $ANTLR end "ruleInclusiveOrExpression"



	// $ANTLR start "entryRuleExclusiveOrExpression"
	// InternalCommon.g:550:1: entryRuleExclusiveOrExpression returns [EObject current=null] :iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF ;
	public final EObject entryRuleExclusiveOrExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleExclusiveOrExpression =null;

		try {
			// InternalCommon.g:551:2: (iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF )
			// InternalCommon.g:552:2: iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF
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
	// InternalCommon.g:559:1: ruleExclusiveOrExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* ) ;
	public final EObject ruleExclusiveOrExpression() throws RecognitionException {
		EObject current = null;


		Token this_SKW_CARET_2=null;
		EObject lv_expr_1_0 =null;
		EObject lv_expr_3_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:565:7: ( ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* ) )
			// InternalCommon.g:567:5: ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* )
			{
			// InternalCommon.g:567:5: ( () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )* )
			// InternalCommon.g:568:5: () ( (lv_expr_1_0= ruleAndExpression ) ) (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )*
			{
			// InternalCommon.g:568:5: ()
			// InternalCommon.g:569:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getExclusiveOrExpressionAccess().getExclusiveOrExpressionAction_0(),
			            current);
			    
			}

			// InternalCommon.g:577:3: ( (lv_expr_1_0= ruleAndExpression ) )
			// InternalCommon.g:578:3: (lv_expr_1_0= ruleAndExpression )
			{
			// InternalCommon.g:578:3: (lv_expr_1_0= ruleAndExpression )
			// InternalCommon.g:579:3: lv_expr_1_0= ruleAndExpression
			{
			 
				        newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getExprAndExpressionParserRuleCall_1_0()); 
				    
			pushFollow(FOLLOW_9);
			lv_expr_1_0=ruleAndExpression();
			state._fsp--;


				        if (current==null) {
				            current = createModelElementForParent(grammarAccess.getExclusiveOrExpressionRule());
				        }
			       		add(
			       			current, 
			       			"expr",
			        		lv_expr_1_0, 
			        		"at.jku.weiner.c.common.Common.AndExpression");
				        afterParserOrEnumRuleCall();
				    
			}

			}

			// InternalCommon.g:598:17: (this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) ) )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==RULE_SKW_CARET) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// InternalCommon.g:599:17: this_SKW_CARET_2= RULE_SKW_CARET ( (lv_expr_3_0= ruleAndExpression ) )
					{
					this_SKW_CARET_2=(Token)match(input,RULE_SKW_CARET,FOLLOW_4); 
					 
					    newLeafNode(this_SKW_CARET_2, grammarAccess.getExclusiveOrExpressionAccess().getSKW_CARETTerminalRuleCall_2_0()); 
					    
					// InternalCommon.g:606:3: ( (lv_expr_3_0= ruleAndExpression ) )
					// InternalCommon.g:607:3: (lv_expr_3_0= ruleAndExpression )
					{
					// InternalCommon.g:607:3: (lv_expr_3_0= ruleAndExpression )
					// InternalCommon.g:608:3: lv_expr_3_0= ruleAndExpression
					{
					 
						        newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getExprAndExpressionParserRuleCall_2_1_0()); 
						    
					pushFollow(FOLLOW_9);
					lv_expr_3_0=ruleAndExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getExclusiveOrExpressionRule());
						        }
					       		add(
					       			current, 
					       			"expr",
					        		lv_expr_3_0, 
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
			    		/*no after found*/
			     
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
	// $ANTLR end "ruleExclusiveOrExpression"



	// $ANTLR start "entryRuleAndExpression"
	// InternalCommon.g:638:1: entryRuleAndExpression returns [EObject current=null] :iv_ruleAndExpression= ruleAndExpression EOF ;
	public final EObject entryRuleAndExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleAndExpression =null;

		try {
			// InternalCommon.g:639:2: (iv_ruleAndExpression= ruleAndExpression EOF )
			// InternalCommon.g:640:2: iv_ruleAndExpression= ruleAndExpression EOF
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
	// InternalCommon.g:647:1: ruleAndExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* ) ;
	public final EObject ruleAndExpression() throws RecognitionException {
		EObject current = null;


		Token this_SKW_AND_2=null;
		EObject lv_expr_1_0 =null;
		EObject lv_expr_3_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:653:7: ( ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* ) )
			// InternalCommon.g:655:5: ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* )
			{
			// InternalCommon.g:655:5: ( () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )* )
			// InternalCommon.g:656:5: () ( (lv_expr_1_0= ruleEqualityExpression ) ) (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )*
			{
			// InternalCommon.g:656:5: ()
			// InternalCommon.g:657:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getAndExpressionAccess().getAndExpressionAction_0(),
			            current);
			    
			}

			// InternalCommon.g:665:3: ( (lv_expr_1_0= ruleEqualityExpression ) )
			// InternalCommon.g:666:3: (lv_expr_1_0= ruleEqualityExpression )
			{
			// InternalCommon.g:666:3: (lv_expr_1_0= ruleEqualityExpression )
			// InternalCommon.g:667:3: lv_expr_1_0= ruleEqualityExpression
			{
			 
				        newCompositeNode(grammarAccess.getAndExpressionAccess().getExprEqualityExpressionParserRuleCall_1_0()); 
				    
			pushFollow(FOLLOW_10);
			lv_expr_1_0=ruleEqualityExpression();
			state._fsp--;


				        if (current==null) {
				            current = createModelElementForParent(grammarAccess.getAndExpressionRule());
				        }
			       		add(
			       			current, 
			       			"expr",
			        		lv_expr_1_0, 
			        		"at.jku.weiner.c.common.Common.EqualityExpression");
				        afterParserOrEnumRuleCall();
				    
			}

			}

			// InternalCommon.g:686:15: (this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) ) )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==RULE_SKW_AND) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// InternalCommon.g:687:15: this_SKW_AND_2= RULE_SKW_AND ( (lv_expr_3_0= ruleEqualityExpression ) )
					{
					this_SKW_AND_2=(Token)match(input,RULE_SKW_AND,FOLLOW_4); 
					 
					    newLeafNode(this_SKW_AND_2, grammarAccess.getAndExpressionAccess().getSKW_ANDTerminalRuleCall_2_0()); 
					    
					// InternalCommon.g:694:3: ( (lv_expr_3_0= ruleEqualityExpression ) )
					// InternalCommon.g:695:3: (lv_expr_3_0= ruleEqualityExpression )
					{
					// InternalCommon.g:695:3: (lv_expr_3_0= ruleEqualityExpression )
					// InternalCommon.g:696:3: lv_expr_3_0= ruleEqualityExpression
					{
					 
						        newCompositeNode(grammarAccess.getAndExpressionAccess().getExprEqualityExpressionParserRuleCall_2_1_0()); 
						    
					pushFollow(FOLLOW_10);
					lv_expr_3_0=ruleEqualityExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getAndExpressionRule());
						        }
					       		add(
					       			current, 
					       			"expr",
					        		lv_expr_3_0, 
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
			    		/*no after found*/
			     
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
	// $ANTLR end "ruleAndExpression"



	// $ANTLR start "entryRuleEqualityExpression"
	// InternalCommon.g:726:1: entryRuleEqualityExpression returns [EObject current=null] :iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
	public final EObject entryRuleEqualityExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleEqualityExpression =null;

		try {
			// InternalCommon.g:727:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
			// InternalCommon.g:728:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
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
	// InternalCommon.g:735:1: ruleEqualityExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* ) ;
	public final EObject ruleEqualityExpression() throws RecognitionException {
		EObject current = null;


		Token lv_op_2_0=null;
		Token lv_op_3_0=null;
		EObject lv_expr_1_0 =null;
		EObject lv_expr_4_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:741:7: ( ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* ) )
			// InternalCommon.g:743:5: ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* )
			{
			// InternalCommon.g:743:5: ( () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )* )
			// InternalCommon.g:744:5: () ( (lv_expr_1_0= ruleRelationalExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )*
			{
			// InternalCommon.g:744:5: ()
			// InternalCommon.g:745:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getEqualityExpressionAccess().getEqualityExpressionAction_0(),
			            current);
			    
			}

			// InternalCommon.g:753:3: ( (lv_expr_1_0= ruleRelationalExpression ) )
			// InternalCommon.g:754:3: (lv_expr_1_0= ruleRelationalExpression )
			{
			// InternalCommon.g:754:3: (lv_expr_1_0= ruleRelationalExpression )
			// InternalCommon.g:755:3: lv_expr_1_0= ruleRelationalExpression
			{
			 
				        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getExprRelationalExpressionParserRuleCall_1_0()); 
				    
			pushFollow(FOLLOW_11);
			lv_expr_1_0=ruleRelationalExpression();
			state._fsp--;


				        if (current==null) {
				            current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
				        }
			       		add(
			       			current, 
			       			"expr",
			        		lv_expr_1_0, 
			        		"at.jku.weiner.c.common.Common.RelationalExpression");
				        afterParserOrEnumRuleCall();
				    
			}

			}

			// InternalCommon.g:774:3: ( ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) ) )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==RULE_SKW_EQUAL||LA8_0==RULE_SKW_NOTEQUAL) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// InternalCommon.g:775:3: ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) ) ( (lv_expr_4_0= ruleRelationalExpression ) )
					{
					// InternalCommon.g:775:3: ( ( (lv_op_2_0= RULE_SKW_EQUAL ) ) | ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) ) )
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
							// InternalCommon.g:776:3: ( (lv_op_2_0= RULE_SKW_EQUAL ) )
							{
							// InternalCommon.g:776:3: ( (lv_op_2_0= RULE_SKW_EQUAL ) )
							// InternalCommon.g:777:3: (lv_op_2_0= RULE_SKW_EQUAL )
							{
							// InternalCommon.g:777:3: (lv_op_2_0= RULE_SKW_EQUAL )
							// InternalCommon.g:778:3: lv_op_2_0= RULE_SKW_EQUAL
							{
							lv_op_2_0=(Token)match(input,RULE_SKW_EQUAL,FOLLOW_4); 

										newLeafNode(lv_op_2_0, grammarAccess.getEqualityExpressionAccess().getOpSKW_EQUALTerminalRuleCall_2_0_0_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getEqualityExpressionRule());
								        }
							       		addWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_2_0, 
							        		"at.jku.weiner.c.common.Common.SKW_EQUAL");
								    
							}

							}

							}
							break;
						case 2 :
							// InternalCommon.g:798:3: ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) )
							{
							// InternalCommon.g:798:3: ( (lv_op_3_0= RULE_SKW_NOTEQUAL ) )
							// InternalCommon.g:799:3: (lv_op_3_0= RULE_SKW_NOTEQUAL )
							{
							// InternalCommon.g:799:3: (lv_op_3_0= RULE_SKW_NOTEQUAL )
							// InternalCommon.g:800:3: lv_op_3_0= RULE_SKW_NOTEQUAL
							{
							lv_op_3_0=(Token)match(input,RULE_SKW_NOTEQUAL,FOLLOW_4); 

										newLeafNode(lv_op_3_0, grammarAccess.getEqualityExpressionAccess().getOpSKW_NOTEQUALTerminalRuleCall_2_0_1_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getEqualityExpressionRule());
								        }
							       		addWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_3_0, 
							        		"at.jku.weiner.c.common.Common.SKW_NOTEQUAL");
								    
							}

							}

							}
							break;

					}

					// InternalCommon.g:821:3: ( (lv_expr_4_0= ruleRelationalExpression ) )
					// InternalCommon.g:822:3: (lv_expr_4_0= ruleRelationalExpression )
					{
					// InternalCommon.g:822:3: (lv_expr_4_0= ruleRelationalExpression )
					// InternalCommon.g:823:3: lv_expr_4_0= ruleRelationalExpression
					{
					 
						        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getExprRelationalExpressionParserRuleCall_2_1_0()); 
						    
					pushFollow(FOLLOW_11);
					lv_expr_4_0=ruleRelationalExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
						        }
					       		add(
					       			current, 
					       			"expr",
					        		lv_expr_4_0, 
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
			    		/*no after found*/
			     
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
	// $ANTLR end "ruleEqualityExpression"



	// $ANTLR start "entryRuleRelationalExpression"
	// InternalCommon.g:853:1: entryRuleRelationalExpression returns [EObject current=null] :iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
	public final EObject entryRuleRelationalExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleRelationalExpression =null;

		try {
			// InternalCommon.g:854:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
			// InternalCommon.g:855:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
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
	// InternalCommon.g:862:1: ruleRelationalExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* ) ;
	public final EObject ruleRelationalExpression() throws RecognitionException {
		EObject current = null;


		Token lv_op_2_0=null;
		Token lv_op_3_0=null;
		Token lv_op_4_0=null;
		Token lv_op_5_0=null;
		EObject lv_expr_1_0 =null;
		EObject lv_expr_6_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:868:7: ( ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* ) )
			// InternalCommon.g:870:5: ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* )
			{
			// InternalCommon.g:870:5: ( () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )* )
			// InternalCommon.g:871:5: () ( (lv_expr_1_0= ruleShiftExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )*
			{
			// InternalCommon.g:871:5: ()
			// InternalCommon.g:872:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getRelationalExpressionAccess().getRelationalExpressionAction_0(),
			            current);
			    
			}

			// InternalCommon.g:880:3: ( (lv_expr_1_0= ruleShiftExpression ) )
			// InternalCommon.g:881:3: (lv_expr_1_0= ruleShiftExpression )
			{
			// InternalCommon.g:881:3: (lv_expr_1_0= ruleShiftExpression )
			// InternalCommon.g:882:3: lv_expr_1_0= ruleShiftExpression
			{
			 
				        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getExprShiftExpressionParserRuleCall_1_0()); 
				    
			pushFollow(FOLLOW_12);
			lv_expr_1_0=ruleShiftExpression();
			state._fsp--;


				        if (current==null) {
				            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
				        }
			       		add(
			       			current, 
			       			"expr",
			        		lv_expr_1_0, 
			        		"at.jku.weiner.c.common.Common.ShiftExpression");
				        afterParserOrEnumRuleCall();
				    
			}

			}

			// InternalCommon.g:901:3: ( ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) ) )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= RULE_SKW_GREATER && LA10_0 <= RULE_SKW_GREATEREQUAL)||(LA10_0 >= RULE_SKW_LESS && LA10_0 <= RULE_SKW_LESSEQUAL)) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// InternalCommon.g:902:3: ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) ) ( (lv_expr_6_0= ruleShiftExpression ) )
					{
					// InternalCommon.g:902:3: ( ( (lv_op_2_0= RULE_SKW_LESS ) ) | ( (lv_op_3_0= RULE_SKW_GREATER ) ) | ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) ) | ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) ) )
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
							// InternalCommon.g:903:3: ( (lv_op_2_0= RULE_SKW_LESS ) )
							{
							// InternalCommon.g:903:3: ( (lv_op_2_0= RULE_SKW_LESS ) )
							// InternalCommon.g:904:3: (lv_op_2_0= RULE_SKW_LESS )
							{
							// InternalCommon.g:904:3: (lv_op_2_0= RULE_SKW_LESS )
							// InternalCommon.g:905:3: lv_op_2_0= RULE_SKW_LESS
							{
							lv_op_2_0=(Token)match(input,RULE_SKW_LESS,FOLLOW_4); 

										newLeafNode(lv_op_2_0, grammarAccess.getRelationalExpressionAccess().getOpSKW_LESSTerminalRuleCall_2_0_0_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getRelationalExpressionRule());
								        }
							       		addWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_2_0, 
							        		"at.jku.weiner.c.common.Common.SKW_LESS");
								    
							}

							}

							}
							break;
						case 2 :
							// InternalCommon.g:925:3: ( (lv_op_3_0= RULE_SKW_GREATER ) )
							{
							// InternalCommon.g:925:3: ( (lv_op_3_0= RULE_SKW_GREATER ) )
							// InternalCommon.g:926:3: (lv_op_3_0= RULE_SKW_GREATER )
							{
							// InternalCommon.g:926:3: (lv_op_3_0= RULE_SKW_GREATER )
							// InternalCommon.g:927:3: lv_op_3_0= RULE_SKW_GREATER
							{
							lv_op_3_0=(Token)match(input,RULE_SKW_GREATER,FOLLOW_4); 

										newLeafNode(lv_op_3_0, grammarAccess.getRelationalExpressionAccess().getOpSKW_GREATERTerminalRuleCall_2_0_1_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getRelationalExpressionRule());
								        }
							       		addWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_3_0, 
							        		"at.jku.weiner.c.common.Common.SKW_GREATER");
								    
							}

							}

							}
							break;
						case 3 :
							// InternalCommon.g:947:3: ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) )
							{
							// InternalCommon.g:947:3: ( (lv_op_4_0= RULE_SKW_LESSEQUAL ) )
							// InternalCommon.g:948:3: (lv_op_4_0= RULE_SKW_LESSEQUAL )
							{
							// InternalCommon.g:948:3: (lv_op_4_0= RULE_SKW_LESSEQUAL )
							// InternalCommon.g:949:3: lv_op_4_0= RULE_SKW_LESSEQUAL
							{
							lv_op_4_0=(Token)match(input,RULE_SKW_LESSEQUAL,FOLLOW_4); 

										newLeafNode(lv_op_4_0, grammarAccess.getRelationalExpressionAccess().getOpSKW_LESSEQUALTerminalRuleCall_2_0_2_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getRelationalExpressionRule());
								        }
							       		addWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_4_0, 
							        		"at.jku.weiner.c.common.Common.SKW_LESSEQUAL");
								    
							}

							}

							}
							break;
						case 4 :
							// InternalCommon.g:969:3: ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) )
							{
							// InternalCommon.g:969:3: ( (lv_op_5_0= RULE_SKW_GREATEREQUAL ) )
							// InternalCommon.g:970:3: (lv_op_5_0= RULE_SKW_GREATEREQUAL )
							{
							// InternalCommon.g:970:3: (lv_op_5_0= RULE_SKW_GREATEREQUAL )
							// InternalCommon.g:971:3: lv_op_5_0= RULE_SKW_GREATEREQUAL
							{
							lv_op_5_0=(Token)match(input,RULE_SKW_GREATEREQUAL,FOLLOW_4); 

										newLeafNode(lv_op_5_0, grammarAccess.getRelationalExpressionAccess().getOpSKW_GREATEREQUALTerminalRuleCall_2_0_3_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getRelationalExpressionRule());
								        }
							       		addWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_5_0, 
							        		"at.jku.weiner.c.common.Common.SKW_GREATEREQUAL");
								    
							}

							}

							}
							break;

					}

					// InternalCommon.g:992:3: ( (lv_expr_6_0= ruleShiftExpression ) )
					// InternalCommon.g:993:3: (lv_expr_6_0= ruleShiftExpression )
					{
					// InternalCommon.g:993:3: (lv_expr_6_0= ruleShiftExpression )
					// InternalCommon.g:994:3: lv_expr_6_0= ruleShiftExpression
					{
					 
						        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getExprShiftExpressionParserRuleCall_2_1_0()); 
						    
					pushFollow(FOLLOW_12);
					lv_expr_6_0=ruleShiftExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
						        }
					       		add(
					       			current, 
					       			"expr",
					        		lv_expr_6_0, 
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
			    		/*no after found*/
			     
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
	// $ANTLR end "ruleRelationalExpression"



	// $ANTLR start "entryRuleShiftExpression"
	// InternalCommon.g:1024:1: entryRuleShiftExpression returns [EObject current=null] :iv_ruleShiftExpression= ruleShiftExpression EOF ;
	public final EObject entryRuleShiftExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleShiftExpression =null;

		try {
			// InternalCommon.g:1025:2: (iv_ruleShiftExpression= ruleShiftExpression EOF )
			// InternalCommon.g:1026:2: iv_ruleShiftExpression= ruleShiftExpression EOF
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
	// InternalCommon.g:1033:1: ruleShiftExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* ) ;
	public final EObject ruleShiftExpression() throws RecognitionException {
		EObject current = null;


		Token lv_op_2_0=null;
		Token lv_op_3_0=null;
		EObject lv_expr_1_0 =null;
		EObject lv_expr_4_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:1039:7: ( ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* ) )
			// InternalCommon.g:1041:5: ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* )
			{
			// InternalCommon.g:1041:5: ( () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )* )
			// InternalCommon.g:1042:5: () ( (lv_expr_1_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )*
			{
			// InternalCommon.g:1042:5: ()
			// InternalCommon.g:1043:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getShiftExpressionAccess().getShiftExpressionAction_0(),
			            current);
			    
			}

			// InternalCommon.g:1051:3: ( (lv_expr_1_0= ruleAdditiveExpression ) )
			// InternalCommon.g:1052:3: (lv_expr_1_0= ruleAdditiveExpression )
			{
			// InternalCommon.g:1052:3: (lv_expr_1_0= ruleAdditiveExpression )
			// InternalCommon.g:1053:3: lv_expr_1_0= ruleAdditiveExpression
			{
			 
				        newCompositeNode(grammarAccess.getShiftExpressionAccess().getExprAdditiveExpressionParserRuleCall_1_0()); 
				    
			pushFollow(FOLLOW_13);
			lv_expr_1_0=ruleAdditiveExpression();
			state._fsp--;


				        if (current==null) {
				            current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
				        }
			       		add(
			       			current, 
			       			"expr",
			        		lv_expr_1_0, 
			        		"at.jku.weiner.c.common.Common.AdditiveExpression");
				        afterParserOrEnumRuleCall();
				    
			}

			}

			// InternalCommon.g:1072:3: ( ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) ) )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==RULE_SKW_LEFTSHIFT||LA12_0==RULE_SKW_RIGHTSHIFT) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// InternalCommon.g:1073:3: ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) ) ( (lv_expr_4_0= ruleAdditiveExpression ) )
					{
					// InternalCommon.g:1073:3: ( ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) ) | ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) ) )
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
							// InternalCommon.g:1074:3: ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) )
							{
							// InternalCommon.g:1074:3: ( (lv_op_2_0= RULE_SKW_LEFTSHIFT ) )
							// InternalCommon.g:1075:3: (lv_op_2_0= RULE_SKW_LEFTSHIFT )
							{
							// InternalCommon.g:1075:3: (lv_op_2_0= RULE_SKW_LEFTSHIFT )
							// InternalCommon.g:1076:3: lv_op_2_0= RULE_SKW_LEFTSHIFT
							{
							lv_op_2_0=(Token)match(input,RULE_SKW_LEFTSHIFT,FOLLOW_4); 

										newLeafNode(lv_op_2_0, grammarAccess.getShiftExpressionAccess().getOpSKW_LEFTSHIFTTerminalRuleCall_2_0_0_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getShiftExpressionRule());
								        }
							       		addWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_2_0, 
							        		"at.jku.weiner.c.common.Common.SKW_LEFTSHIFT");
								    
							}

							}

							}
							break;
						case 2 :
							// InternalCommon.g:1096:3: ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) )
							{
							// InternalCommon.g:1096:3: ( (lv_op_3_0= RULE_SKW_RIGHTSHIFT ) )
							// InternalCommon.g:1097:3: (lv_op_3_0= RULE_SKW_RIGHTSHIFT )
							{
							// InternalCommon.g:1097:3: (lv_op_3_0= RULE_SKW_RIGHTSHIFT )
							// InternalCommon.g:1098:3: lv_op_3_0= RULE_SKW_RIGHTSHIFT
							{
							lv_op_3_0=(Token)match(input,RULE_SKW_RIGHTSHIFT,FOLLOW_4); 

										newLeafNode(lv_op_3_0, grammarAccess.getShiftExpressionAccess().getOpSKW_RIGHTSHIFTTerminalRuleCall_2_0_1_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getShiftExpressionRule());
								        }
							       		addWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_3_0, 
							        		"at.jku.weiner.c.common.Common.SKW_RIGHTSHIFT");
								    
							}

							}

							}
							break;

					}

					// InternalCommon.g:1119:3: ( (lv_expr_4_0= ruleAdditiveExpression ) )
					// InternalCommon.g:1120:3: (lv_expr_4_0= ruleAdditiveExpression )
					{
					// InternalCommon.g:1120:3: (lv_expr_4_0= ruleAdditiveExpression )
					// InternalCommon.g:1121:3: lv_expr_4_0= ruleAdditiveExpression
					{
					 
						        newCompositeNode(grammarAccess.getShiftExpressionAccess().getExprAdditiveExpressionParserRuleCall_2_1_0()); 
						    
					pushFollow(FOLLOW_13);
					lv_expr_4_0=ruleAdditiveExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
						        }
					       		add(
					       			current, 
					       			"expr",
					        		lv_expr_4_0, 
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
			    		/*no after found*/
			     
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
	// $ANTLR end "ruleShiftExpression"



	// $ANTLR start "entryRuleAdditiveExpression"
	// InternalCommon.g:1151:1: entryRuleAdditiveExpression returns [EObject current=null] :iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
	public final EObject entryRuleAdditiveExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleAdditiveExpression =null;

		try {
			// InternalCommon.g:1152:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
			// InternalCommon.g:1153:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
	// InternalCommon.g:1160:1: ruleAdditiveExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* ) ;
	public final EObject ruleAdditiveExpression() throws RecognitionException {
		EObject current = null;


		Token lv_op_2_0=null;
		Token lv_op_3_0=null;
		EObject lv_expr_1_0 =null;
		EObject lv_expr_4_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:1166:7: ( ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* ) )
			// InternalCommon.g:1168:5: ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* )
			{
			// InternalCommon.g:1168:5: ( () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )* )
			// InternalCommon.g:1169:5: () ( (lv_expr_1_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )*
			{
			// InternalCommon.g:1169:5: ()
			// InternalCommon.g:1170:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getAdditiveExpressionAccess().getAdditiveExpressionAction_0(),
			            current);
			    
			}

			// InternalCommon.g:1178:3: ( (lv_expr_1_0= ruleMultiplicativeExpression ) )
			// InternalCommon.g:1179:3: (lv_expr_1_0= ruleMultiplicativeExpression )
			{
			// InternalCommon.g:1179:3: (lv_expr_1_0= ruleMultiplicativeExpression )
			// InternalCommon.g:1180:3: lv_expr_1_0= ruleMultiplicativeExpression
			{
			 
				        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExprMultiplicativeExpressionParserRuleCall_1_0()); 
				    
			pushFollow(FOLLOW_14);
			lv_expr_1_0=ruleMultiplicativeExpression();
			state._fsp--;


				        if (current==null) {
				            current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
				        }
			       		add(
			       			current, 
			       			"expr",
			        		lv_expr_1_0, 
			        		"at.jku.weiner.c.common.Common.MultiplicativeExpression");
				        afterParserOrEnumRuleCall();
				    
			}

			}

			// InternalCommon.g:1199:3: ( ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) ) )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==RULE_SKW_MINUS||LA14_0==RULE_SKW_PLUS) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// InternalCommon.g:1200:3: ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) ) ( (lv_expr_4_0= ruleMultiplicativeExpression ) )
					{
					// InternalCommon.g:1200:3: ( ( (lv_op_2_0= RULE_SKW_PLUS ) ) | ( (lv_op_3_0= RULE_SKW_MINUS ) ) )
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
							// InternalCommon.g:1201:3: ( (lv_op_2_0= RULE_SKW_PLUS ) )
							{
							// InternalCommon.g:1201:3: ( (lv_op_2_0= RULE_SKW_PLUS ) )
							// InternalCommon.g:1202:3: (lv_op_2_0= RULE_SKW_PLUS )
							{
							// InternalCommon.g:1202:3: (lv_op_2_0= RULE_SKW_PLUS )
							// InternalCommon.g:1203:3: lv_op_2_0= RULE_SKW_PLUS
							{
							lv_op_2_0=(Token)match(input,RULE_SKW_PLUS,FOLLOW_4); 

										newLeafNode(lv_op_2_0, grammarAccess.getAdditiveExpressionAccess().getOpSKW_PLUSTerminalRuleCall_2_0_0_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getAdditiveExpressionRule());
								        }
							       		addWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_2_0, 
							        		"at.jku.weiner.c.common.Common.SKW_PLUS");
								    
							}

							}

							}
							break;
						case 2 :
							// InternalCommon.g:1223:3: ( (lv_op_3_0= RULE_SKW_MINUS ) )
							{
							// InternalCommon.g:1223:3: ( (lv_op_3_0= RULE_SKW_MINUS ) )
							// InternalCommon.g:1224:3: (lv_op_3_0= RULE_SKW_MINUS )
							{
							// InternalCommon.g:1224:3: (lv_op_3_0= RULE_SKW_MINUS )
							// InternalCommon.g:1225:3: lv_op_3_0= RULE_SKW_MINUS
							{
							lv_op_3_0=(Token)match(input,RULE_SKW_MINUS,FOLLOW_4); 

										newLeafNode(lv_op_3_0, grammarAccess.getAdditiveExpressionAccess().getOpSKW_MINUSTerminalRuleCall_2_0_1_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getAdditiveExpressionRule());
								        }
							       		addWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_3_0, 
							        		"at.jku.weiner.c.common.Common.SKW_MINUS");
								    
							}

							}

							}
							break;

					}

					// InternalCommon.g:1246:3: ( (lv_expr_4_0= ruleMultiplicativeExpression ) )
					// InternalCommon.g:1247:3: (lv_expr_4_0= ruleMultiplicativeExpression )
					{
					// InternalCommon.g:1247:3: (lv_expr_4_0= ruleMultiplicativeExpression )
					// InternalCommon.g:1248:3: lv_expr_4_0= ruleMultiplicativeExpression
					{
					 
						        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExprMultiplicativeExpressionParserRuleCall_2_1_0()); 
						    
					pushFollow(FOLLOW_14);
					lv_expr_4_0=ruleMultiplicativeExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
						        }
					       		add(
					       			current, 
					       			"expr",
					        		lv_expr_4_0, 
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
			    		/*no after found*/
			     
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
	// $ANTLR end "ruleAdditiveExpression"



	// $ANTLR start "entryRuleMultiplicativeExpression"
	// InternalCommon.g:1278:1: entryRuleMultiplicativeExpression returns [EObject current=null] :iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
	public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleMultiplicativeExpression =null;

		try {
			// InternalCommon.g:1279:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
			// InternalCommon.g:1280:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
	// InternalCommon.g:1287:1: ruleMultiplicativeExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* ) ;
	public final EObject ruleMultiplicativeExpression() throws RecognitionException {
		EObject current = null;


		Token lv_op_2_0=null;
		Token lv_op_3_0=null;
		Token lv_op_4_0=null;
		EObject lv_expr_1_0 =null;
		EObject lv_expr_5_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:1293:7: ( ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* ) )
			// InternalCommon.g:1295:5: ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* )
			{
			// InternalCommon.g:1295:5: ( () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )* )
			// InternalCommon.g:1296:5: () ( (lv_expr_1_0= ruleCastExpression ) ) ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )*
			{
			// InternalCommon.g:1296:5: ()
			// InternalCommon.g:1297:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getMultiplicativeExpressionAccess().getMultiplicativeExpressionAction_0(),
			            current);
			    
			}

			// InternalCommon.g:1305:3: ( (lv_expr_1_0= ruleCastExpression ) )
			// InternalCommon.g:1306:3: (lv_expr_1_0= ruleCastExpression )
			{
			// InternalCommon.g:1306:3: (lv_expr_1_0= ruleCastExpression )
			// InternalCommon.g:1307:3: lv_expr_1_0= ruleCastExpression
			{
			 
				        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExprCastExpressionParserRuleCall_1_0()); 
				    
			pushFollow(FOLLOW_15);
			lv_expr_1_0=ruleCastExpression();
			state._fsp--;


				        if (current==null) {
				            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
				        }
			       		add(
			       			current, 
			       			"expr",
			        		lv_expr_1_0, 
			        		"at.jku.weiner.c.common.Common.CastExpression");
				        afterParserOrEnumRuleCall();
				    
			}

			}

			// InternalCommon.g:1326:3: ( ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) ) )*
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==RULE_SKW_DIV||LA16_0==RULE_SKW_MOD||LA16_0==RULE_SKW_STAR) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// InternalCommon.g:1327:3: ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) ) ( (lv_expr_5_0= ruleCastExpression ) )
					{
					// InternalCommon.g:1327:3: ( ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_DIV ) ) | ( (lv_op_4_0= RULE_SKW_MOD ) ) )
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
							// InternalCommon.g:1328:3: ( (lv_op_2_0= RULE_SKW_STAR ) )
							{
							// InternalCommon.g:1328:3: ( (lv_op_2_0= RULE_SKW_STAR ) )
							// InternalCommon.g:1329:3: (lv_op_2_0= RULE_SKW_STAR )
							{
							// InternalCommon.g:1329:3: (lv_op_2_0= RULE_SKW_STAR )
							// InternalCommon.g:1330:3: lv_op_2_0= RULE_SKW_STAR
							{
							lv_op_2_0=(Token)match(input,RULE_SKW_STAR,FOLLOW_4); 

										newLeafNode(lv_op_2_0, grammarAccess.getMultiplicativeExpressionAccess().getOpSKW_STARTerminalRuleCall_2_0_0_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
								        }
							       		addWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_2_0, 
							        		"at.jku.weiner.c.common.Common.SKW_STAR");
								    
							}

							}

							}
							break;
						case 2 :
							// InternalCommon.g:1350:3: ( (lv_op_3_0= RULE_SKW_DIV ) )
							{
							// InternalCommon.g:1350:3: ( (lv_op_3_0= RULE_SKW_DIV ) )
							// InternalCommon.g:1351:3: (lv_op_3_0= RULE_SKW_DIV )
							{
							// InternalCommon.g:1351:3: (lv_op_3_0= RULE_SKW_DIV )
							// InternalCommon.g:1352:3: lv_op_3_0= RULE_SKW_DIV
							{
							lv_op_3_0=(Token)match(input,RULE_SKW_DIV,FOLLOW_4); 

										newLeafNode(lv_op_3_0, grammarAccess.getMultiplicativeExpressionAccess().getOpSKW_DIVTerminalRuleCall_2_0_1_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
								        }
							       		addWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_3_0, 
							        		"at.jku.weiner.c.common.Common.SKW_DIV");
								    
							}

							}

							}
							break;
						case 3 :
							// InternalCommon.g:1372:3: ( (lv_op_4_0= RULE_SKW_MOD ) )
							{
							// InternalCommon.g:1372:3: ( (lv_op_4_0= RULE_SKW_MOD ) )
							// InternalCommon.g:1373:3: (lv_op_4_0= RULE_SKW_MOD )
							{
							// InternalCommon.g:1373:3: (lv_op_4_0= RULE_SKW_MOD )
							// InternalCommon.g:1374:3: lv_op_4_0= RULE_SKW_MOD
							{
							lv_op_4_0=(Token)match(input,RULE_SKW_MOD,FOLLOW_4); 

										newLeafNode(lv_op_4_0, grammarAccess.getMultiplicativeExpressionAccess().getOpSKW_MODTerminalRuleCall_2_0_2_0()); 
									

								        if (current==null) {
								            current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
								        }
							       		addWithLastConsumed(
							       			current, 
							       			"op",
							        		lv_op_4_0, 
							        		"at.jku.weiner.c.common.Common.SKW_MOD");
								    
							}

							}

							}
							break;

					}

					// InternalCommon.g:1395:3: ( (lv_expr_5_0= ruleCastExpression ) )
					// InternalCommon.g:1396:3: (lv_expr_5_0= ruleCastExpression )
					{
					// InternalCommon.g:1396:3: (lv_expr_5_0= ruleCastExpression )
					// InternalCommon.g:1397:3: lv_expr_5_0= ruleCastExpression
					{
					 
						        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExprCastExpressionParserRuleCall_2_1_0()); 
						    
					pushFollow(FOLLOW_15);
					lv_expr_5_0=ruleCastExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
						        }
					       		add(
					       			current, 
					       			"expr",
					        		lv_expr_5_0, 
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
			    		/*no after found*/
			     
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
	// $ANTLR end "ruleMultiplicativeExpression"



	// $ANTLR start "entryRuleCastExpression"
	// InternalCommon.g:1427:1: entryRuleCastExpression returns [EObject current=null] :iv_ruleCastExpression= ruleCastExpression EOF ;
	public final EObject entryRuleCastExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleCastExpression =null;

		try {
			// InternalCommon.g:1428:2: (iv_ruleCastExpression= ruleCastExpression EOF )
			// InternalCommon.g:1429:2: iv_ruleCastExpression= ruleCastExpression EOF
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
	// InternalCommon.g:1436:1: ruleCastExpression returns [EObject current=null] : ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
	public final EObject ruleCastExpression() throws RecognitionException {
		EObject current = null;


		EObject lv_expr_1_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:1442:7: ( ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
			// InternalCommon.g:1444:5: ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) )
			{
			// InternalCommon.g:1444:5: ( () ( (lv_expr_1_0= ruleUnaryExpression ) ) )
			// InternalCommon.g:1445:5: () ( (lv_expr_1_0= ruleUnaryExpression ) )
			{
			// InternalCommon.g:1445:5: ()
			// InternalCommon.g:1446:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getCastExpressionAccess().getCastExpressionAction_0(),
			            current);
			    
			}

			// InternalCommon.g:1454:3: ( (lv_expr_1_0= ruleUnaryExpression ) )
			// InternalCommon.g:1455:3: (lv_expr_1_0= ruleUnaryExpression )
			{
			// InternalCommon.g:1455:3: (lv_expr_1_0= ruleUnaryExpression )
			// InternalCommon.g:1456:3: lv_expr_1_0= ruleUnaryExpression
			{
			 
				        newCompositeNode(grammarAccess.getCastExpressionAccess().getExprUnaryExpressionParserRuleCall_1_0()); 
				    
			pushFollow(FOLLOW_2);
			lv_expr_1_0=ruleUnaryExpression();
			state._fsp--;


				        if (current==null) {
				            current = createModelElementForParent(grammarAccess.getCastExpressionRule());
				        }
			       		set(
			       			current, 
			       			"expr",
			        		lv_expr_1_0, 
			        		"at.jku.weiner.c.common.Common.UnaryExpression");
				        afterParserOrEnumRuleCall();
				    
			}

			}

			}

			}

			 leaveRule();
			    		/*no after found*/
			     
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
	// $ANTLR end "ruleCastExpression"



	// $ANTLR start "entryRuleUnaryExpression"
	// InternalCommon.g:1484:1: entryRuleUnaryExpression returns [EObject current=null] :iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
	public final EObject entryRuleUnaryExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleUnaryExpression =null;

		try {
			// InternalCommon.g:1485:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
			// InternalCommon.g:1486:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
	// InternalCommon.g:1493:1: ruleUnaryExpression returns [EObject current=null] : ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) ) ;
	public final EObject ruleUnaryExpression() throws RecognitionException {
		EObject current = null;


		EObject lv_expr_1_0 =null;
		EObject lv_op_2_0 =null;
		EObject lv_expr_3_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:1499:7: ( ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) ) )
			// InternalCommon.g:1501:5: ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) )
			{
			// InternalCommon.g:1501:5: ( () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) ) )
			// InternalCommon.g:1502:5: () ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) )
			{
			// InternalCommon.g:1502:5: ()
			// InternalCommon.g:1503:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getUnaryExpressionAccess().getUnaryExpressionAction_0(),
			            current);
			    
			}

			// InternalCommon.g:1511:3: ( ( (lv_expr_1_0= rulePostfixExpression ) ) | ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) ) )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==RULE_BIN_LITERAL||(LA17_0 >= RULE_CHAR_LITERAL && LA17_0 <= RULE_DECIMAL_LITERAL)||LA17_0==RULE_FLOAT_LITERAL||LA17_0==RULE_HEX_LITERAL||LA17_0==RULE_OCTAL_LITERAL||LA17_0==RULE_STRING_LITERAL) ) {
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
					// InternalCommon.g:1512:3: ( (lv_expr_1_0= rulePostfixExpression ) )
					{
					// InternalCommon.g:1512:3: ( (lv_expr_1_0= rulePostfixExpression ) )
					// InternalCommon.g:1513:3: (lv_expr_1_0= rulePostfixExpression )
					{
					// InternalCommon.g:1513:3: (lv_expr_1_0= rulePostfixExpression )
					// InternalCommon.g:1514:3: lv_expr_1_0= rulePostfixExpression
					{
					 
						        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExprPostfixExpressionParserRuleCall_1_0_0()); 
						    
					pushFollow(FOLLOW_2);
					lv_expr_1_0=rulePostfixExpression();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
						        }
					       		set(
					       			current, 
					       			"expr",
					        		lv_expr_1_0, 
					        		"at.jku.weiner.c.common.Common.PostfixExpression");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;
				case 2 :
					// InternalCommon.g:1534:3: ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) )
					{
					// InternalCommon.g:1534:3: ( ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) ) )
					// InternalCommon.g:1535:3: ( (lv_op_2_0= ruleUnaryOperator ) ) ( (lv_expr_3_0= ruleCastExpression ) )
					{
					// InternalCommon.g:1535:3: ( (lv_op_2_0= ruleUnaryOperator ) )
					// InternalCommon.g:1536:3: (lv_op_2_0= ruleUnaryOperator )
					{
					// InternalCommon.g:1536:3: (lv_op_2_0= ruleUnaryOperator )
					// InternalCommon.g:1537:3: lv_op_2_0= ruleUnaryOperator
					{
					 
						        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_1_1_0_0()); 
						    
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

					// InternalCommon.g:1556:3: ( (lv_expr_3_0= ruleCastExpression ) )
					// InternalCommon.g:1557:3: (lv_expr_3_0= ruleCastExpression )
					{
					// InternalCommon.g:1557:3: (lv_expr_3_0= ruleCastExpression )
					// InternalCommon.g:1558:3: lv_expr_3_0= ruleCastExpression
					{
					 
						        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExprCastExpressionParserRuleCall_1_1_1_0()); 
						    
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

			}

			 leaveRule();
			    		/*no after found*/
			     
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
	// $ANTLR end "ruleUnaryExpression"



	// $ANTLR start "entryRuleUnaryOperator"
	// InternalCommon.g:1590:1: entryRuleUnaryOperator returns [EObject current=null] :iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
	public final EObject entryRuleUnaryOperator() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleUnaryOperator =null;

		try {
			// InternalCommon.g:1591:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
			// InternalCommon.g:1592:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
			{
			 newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
			pushFollow(FOLLOW_1);
			iv_ruleUnaryOperator=ruleUnaryOperator();
			state._fsp--;

			 current =iv_ruleUnaryOperator; 
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
	// InternalCommon.g:1599:1: ruleUnaryOperator returns [EObject current=null] : ( ( () ( (lv_op_1_0= RULE_SKW_AND ) ) ) | ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_PLUS ) ) | ( (lv_op_4_0= RULE_SKW_MINUS ) ) | ( (lv_op_5_0= RULE_SKW_TILDE ) ) | ( (lv_op_6_0= RULE_SKW_NOT ) ) ) ;
	public final EObject ruleUnaryOperator() throws RecognitionException {
		EObject current = null;


		Token lv_op_1_0=null;
		Token lv_op_2_0=null;
		Token lv_op_3_0=null;
		Token lv_op_4_0=null;
		Token lv_op_5_0=null;
		Token lv_op_6_0=null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:1605:7: ( ( ( () ( (lv_op_1_0= RULE_SKW_AND ) ) ) | ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_PLUS ) ) | ( (lv_op_4_0= RULE_SKW_MINUS ) ) | ( (lv_op_5_0= RULE_SKW_TILDE ) ) | ( (lv_op_6_0= RULE_SKW_NOT ) ) ) )
			// InternalCommon.g:1607:5: ( ( () ( (lv_op_1_0= RULE_SKW_AND ) ) ) | ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_PLUS ) ) | ( (lv_op_4_0= RULE_SKW_MINUS ) ) | ( (lv_op_5_0= RULE_SKW_TILDE ) ) | ( (lv_op_6_0= RULE_SKW_NOT ) ) )
			{
			// InternalCommon.g:1607:5: ( ( () ( (lv_op_1_0= RULE_SKW_AND ) ) ) | ( (lv_op_2_0= RULE_SKW_STAR ) ) | ( (lv_op_3_0= RULE_SKW_PLUS ) ) | ( (lv_op_4_0= RULE_SKW_MINUS ) ) | ( (lv_op_5_0= RULE_SKW_TILDE ) ) | ( (lv_op_6_0= RULE_SKW_NOT ) ) )
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
					// InternalCommon.g:1608:5: ( () ( (lv_op_1_0= RULE_SKW_AND ) ) )
					{
					// InternalCommon.g:1608:5: ( () ( (lv_op_1_0= RULE_SKW_AND ) ) )
					// InternalCommon.g:1609:5: () ( (lv_op_1_0= RULE_SKW_AND ) )
					{
					// InternalCommon.g:1609:5: ()
					// InternalCommon.g:1610:5: 
					{

					        current = forceCreateModelElement(
					            grammarAccess.getUnaryOperatorAccess().getUnaryOperatorAction_0_0(),
					            current);
					    
					}

					// InternalCommon.g:1618:3: ( (lv_op_1_0= RULE_SKW_AND ) )
					// InternalCommon.g:1619:3: (lv_op_1_0= RULE_SKW_AND )
					{
					// InternalCommon.g:1619:3: (lv_op_1_0= RULE_SKW_AND )
					// InternalCommon.g:1620:3: lv_op_1_0= RULE_SKW_AND
					{
					lv_op_1_0=(Token)match(input,RULE_SKW_AND,FOLLOW_2); 

								newLeafNode(lv_op_1_0, grammarAccess.getUnaryOperatorAccess().getOpSKW_ANDTerminalRuleCall_0_1_0()); 
							

						        if (current==null) {
						            current = createModelElement(grammarAccess.getUnaryOperatorRule());
						        }
					       		setWithLastConsumed(
					       			current, 
					       			"op",
					        		lv_op_1_0, 
					        		"at.jku.weiner.c.common.Common.SKW_AND");
						    
					}

					}

					}

					}
					break;
				case 2 :
					// InternalCommon.g:1642:3: ( (lv_op_2_0= RULE_SKW_STAR ) )
					{
					// InternalCommon.g:1642:3: ( (lv_op_2_0= RULE_SKW_STAR ) )
					// InternalCommon.g:1643:3: (lv_op_2_0= RULE_SKW_STAR )
					{
					// InternalCommon.g:1643:3: (lv_op_2_0= RULE_SKW_STAR )
					// InternalCommon.g:1644:3: lv_op_2_0= RULE_SKW_STAR
					{
					lv_op_2_0=(Token)match(input,RULE_SKW_STAR,FOLLOW_2); 

								newLeafNode(lv_op_2_0, grammarAccess.getUnaryOperatorAccess().getOpSKW_STARTerminalRuleCall_1_0()); 
							

						        if (current==null) {
						            current = createModelElement(grammarAccess.getUnaryOperatorRule());
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
				case 3 :
					// InternalCommon.g:1664:3: ( (lv_op_3_0= RULE_SKW_PLUS ) )
					{
					// InternalCommon.g:1664:3: ( (lv_op_3_0= RULE_SKW_PLUS ) )
					// InternalCommon.g:1665:3: (lv_op_3_0= RULE_SKW_PLUS )
					{
					// InternalCommon.g:1665:3: (lv_op_3_0= RULE_SKW_PLUS )
					// InternalCommon.g:1666:3: lv_op_3_0= RULE_SKW_PLUS
					{
					lv_op_3_0=(Token)match(input,RULE_SKW_PLUS,FOLLOW_2); 

								newLeafNode(lv_op_3_0, grammarAccess.getUnaryOperatorAccess().getOpSKW_PLUSTerminalRuleCall_2_0()); 
							

						        if (current==null) {
						            current = createModelElement(grammarAccess.getUnaryOperatorRule());
						        }
					       		setWithLastConsumed(
					       			current, 
					       			"op",
					        		lv_op_3_0, 
					        		"at.jku.weiner.c.common.Common.SKW_PLUS");
						    
					}

					}

					}
					break;
				case 4 :
					// InternalCommon.g:1686:3: ( (lv_op_4_0= RULE_SKW_MINUS ) )
					{
					// InternalCommon.g:1686:3: ( (lv_op_4_0= RULE_SKW_MINUS ) )
					// InternalCommon.g:1687:3: (lv_op_4_0= RULE_SKW_MINUS )
					{
					// InternalCommon.g:1687:3: (lv_op_4_0= RULE_SKW_MINUS )
					// InternalCommon.g:1688:3: lv_op_4_0= RULE_SKW_MINUS
					{
					lv_op_4_0=(Token)match(input,RULE_SKW_MINUS,FOLLOW_2); 

								newLeafNode(lv_op_4_0, grammarAccess.getUnaryOperatorAccess().getOpSKW_MINUSTerminalRuleCall_3_0()); 
							

						        if (current==null) {
						            current = createModelElement(grammarAccess.getUnaryOperatorRule());
						        }
					       		setWithLastConsumed(
					       			current, 
					       			"op",
					        		lv_op_4_0, 
					        		"at.jku.weiner.c.common.Common.SKW_MINUS");
						    
					}

					}

					}
					break;
				case 5 :
					// InternalCommon.g:1708:3: ( (lv_op_5_0= RULE_SKW_TILDE ) )
					{
					// InternalCommon.g:1708:3: ( (lv_op_5_0= RULE_SKW_TILDE ) )
					// InternalCommon.g:1709:3: (lv_op_5_0= RULE_SKW_TILDE )
					{
					// InternalCommon.g:1709:3: (lv_op_5_0= RULE_SKW_TILDE )
					// InternalCommon.g:1710:3: lv_op_5_0= RULE_SKW_TILDE
					{
					lv_op_5_0=(Token)match(input,RULE_SKW_TILDE,FOLLOW_2); 

								newLeafNode(lv_op_5_0, grammarAccess.getUnaryOperatorAccess().getOpSKW_TILDETerminalRuleCall_4_0()); 
							

						        if (current==null) {
						            current = createModelElement(grammarAccess.getUnaryOperatorRule());
						        }
					       		setWithLastConsumed(
					       			current, 
					       			"op",
					        		lv_op_5_0, 
					        		"at.jku.weiner.c.common.Common.SKW_TILDE");
						    
					}

					}

					}
					break;
				case 6 :
					// InternalCommon.g:1730:3: ( (lv_op_6_0= RULE_SKW_NOT ) )
					{
					// InternalCommon.g:1730:3: ( (lv_op_6_0= RULE_SKW_NOT ) )
					// InternalCommon.g:1731:3: (lv_op_6_0= RULE_SKW_NOT )
					{
					// InternalCommon.g:1731:3: (lv_op_6_0= RULE_SKW_NOT )
					// InternalCommon.g:1732:3: lv_op_6_0= RULE_SKW_NOT
					{
					lv_op_6_0=(Token)match(input,RULE_SKW_NOT,FOLLOW_2); 

								newLeafNode(lv_op_6_0, grammarAccess.getUnaryOperatorAccess().getOpSKW_NOTTerminalRuleCall_5_0()); 
							

						        if (current==null) {
						            current = createModelElement(grammarAccess.getUnaryOperatorRule());
						        }
					       		setWithLastConsumed(
					       			current, 
					       			"op",
					        		lv_op_6_0, 
					        		"at.jku.weiner.c.common.Common.SKW_NOT");
						    
					}

					}

					}
					break;

			}

			}

			 leaveRule();
			    		/*no after found*/
			     
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
	// InternalCommon.g:1760:1: entryRulePostfixExpression returns [EObject current=null] :iv_rulePostfixExpression= rulePostfixExpression EOF ;
	public final EObject entryRulePostfixExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_rulePostfixExpression =null;

		try {
			// InternalCommon.g:1761:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
			// InternalCommon.g:1762:2: iv_rulePostfixExpression= rulePostfixExpression EOF
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
	// InternalCommon.g:1769:1: rulePostfixExpression returns [EObject current=null] : ( () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* ) ) ;
	public final EObject rulePostfixExpression() throws RecognitionException {
		EObject current = null;


		EObject lv_expr_1_0 =null;
		EObject lv_suffix_2_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:1775:7: ( ( () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* ) ) )
			// InternalCommon.g:1777:5: ( () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* ) )
			{
			// InternalCommon.g:1777:5: ( () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* ) )
			// InternalCommon.g:1778:5: () ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* )
			{
			// InternalCommon.g:1778:5: ()
			// InternalCommon.g:1779:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getPostfixExpressionAccess().getPostfixExpressionAction_0(),
			            current);
			    
			}

			// InternalCommon.g:1787:3: ( ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )* )
			// InternalCommon.g:1788:3: ( (lv_expr_1_0= rulePrimaryExpression ) ) ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )*
			{
			// InternalCommon.g:1788:3: ( (lv_expr_1_0= rulePrimaryExpression ) )
			// InternalCommon.g:1789:3: (lv_expr_1_0= rulePrimaryExpression )
			{
			// InternalCommon.g:1789:3: (lv_expr_1_0= rulePrimaryExpression )
			// InternalCommon.g:1790:3: lv_expr_1_0= rulePrimaryExpression
			{
			 
				        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getExprPrimaryExpressionParserRuleCall_1_0_0()); 
				    
			pushFollow(FOLLOW_16);
			lv_expr_1_0=rulePrimaryExpression();
			state._fsp--;


				        if (current==null) {
				            current = createModelElementForParent(grammarAccess.getPostfixExpressionRule());
				        }
			       		set(
			       			current, 
			       			"expr",
			        		lv_expr_1_0, 
			        		"at.jku.weiner.c.common.Common.PrimaryExpression");
				        afterParserOrEnumRuleCall();
				    
			}

			}

			// InternalCommon.g:1809:3: ( (lv_suffix_2_0= rulePostfixExpressionSuffixArgument ) )*
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==RULE_SKW_LEFTPAREN) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// InternalCommon.g:1810:3: (lv_suffix_2_0= rulePostfixExpressionSuffixArgument )
					{
					// InternalCommon.g:1810:3: (lv_suffix_2_0= rulePostfixExpressionSuffixArgument )
					// InternalCommon.g:1811:3: lv_suffix_2_0= rulePostfixExpressionSuffixArgument
					{
					 
						        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getSuffixPostfixExpressionSuffixArgumentParserRuleCall_1_1_0()); 
						    
					pushFollow(FOLLOW_16);
					lv_suffix_2_0=rulePostfixExpressionSuffixArgument();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getPostfixExpressionRule());
						        }
					       		add(
					       			current, 
					       			"suffix",
					        		lv_suffix_2_0, 
					        		"at.jku.weiner.c.common.Common.PostfixExpressionSuffixArgument");
						        afterParserOrEnumRuleCall();
						    
					}

					}
					break;

				default :
					break loop19;
				}
			}

			}

			}

			}

			 leaveRule();
			    		/*no after found*/
			     
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
	// $ANTLR end "rulePostfixExpression"



	// $ANTLR start "entryRulePostfixExpressionSuffixArgument"
	// InternalCommon.g:1841:1: entryRulePostfixExpressionSuffixArgument returns [EObject current=null] :iv_rulePostfixExpressionSuffixArgument= rulePostfixExpressionSuffixArgument EOF ;
	public final EObject entryRulePostfixExpressionSuffixArgument() throws RecognitionException {
		EObject current = null;


		EObject iv_rulePostfixExpressionSuffixArgument =null;

		try {
			// InternalCommon.g:1842:2: (iv_rulePostfixExpressionSuffixArgument= rulePostfixExpressionSuffixArgument EOF )
			// InternalCommon.g:1843:2: iv_rulePostfixExpressionSuffixArgument= rulePostfixExpressionSuffixArgument EOF
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
	// InternalCommon.g:1850:1: rulePostfixExpressionSuffixArgument returns [EObject current=null] : ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN ) ;
	public final EObject rulePostfixExpressionSuffixArgument() throws RecognitionException {
		EObject current = null;


		Token this_SKW_LEFTPAREN_1=null;
		Token this_SKW_RIGHTPAREN_3=null;
		EObject lv_argumentExpressionList_2_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:1856:7: ( ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN ) )
			// InternalCommon.g:1858:5: ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN )
			{
			// InternalCommon.g:1858:5: ( () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN )
			// InternalCommon.g:1859:5: () this_SKW_LEFTPAREN_1= RULE_SKW_LEFTPAREN ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )? this_SKW_RIGHTPAREN_3= RULE_SKW_RIGHTPAREN
			{
			// InternalCommon.g:1859:5: ()
			// InternalCommon.g:1860:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getPostfixExpressionSuffixArgumentAccess().getPostfixExpressionSuffixArgumentAction_0(),
			            current);
			    
			}

			this_SKW_LEFTPAREN_1=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_17); 
			 
			    newLeafNode(this_SKW_LEFTPAREN_1, grammarAccess.getPostfixExpressionSuffixArgumentAccess().getSKW_LEFTPARENTerminalRuleCall_1()); 
			    
			// InternalCommon.g:1875:3: ( (lv_argumentExpressionList_2_0= ruleArgumentExpressionList ) )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==RULE_BIN_LITERAL||(LA20_0 >= RULE_CHAR_LITERAL && LA20_0 <= RULE_DECIMAL_LITERAL)||LA20_0==RULE_FLOAT_LITERAL||LA20_0==RULE_HEX_LITERAL||(LA20_0 >= RULE_OCTAL_LITERAL && LA20_0 <= RULE_SKW_AND)||LA20_0==RULE_SKW_MINUS||LA20_0==RULE_SKW_NOT||LA20_0==RULE_SKW_PLUS||(LA20_0 >= RULE_SKW_STAR && LA20_0 <= RULE_SKW_TILDE)||LA20_0==RULE_STRING_LITERAL) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// InternalCommon.g:1876:3: (lv_argumentExpressionList_2_0= ruleArgumentExpressionList )
					{
					// InternalCommon.g:1876:3: (lv_argumentExpressionList_2_0= ruleArgumentExpressionList )
					// InternalCommon.g:1877:3: lv_argumentExpressionList_2_0= ruleArgumentExpressionList
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
			    		/*no after found*/
			     
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
	// $ANTLR end "rulePostfixExpressionSuffixArgument"



	// $ANTLR start "entryRuleArgumentExpressionList"
	// InternalCommon.g:1912:1: entryRuleArgumentExpressionList returns [EObject current=null] :iv_ruleArgumentExpressionList= ruleArgumentExpressionList EOF ;
	public final EObject entryRuleArgumentExpressionList() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleArgumentExpressionList =null;

		try {
			// InternalCommon.g:1913:2: (iv_ruleArgumentExpressionList= ruleArgumentExpressionList EOF )
			// InternalCommon.g:1914:2: iv_ruleArgumentExpressionList= ruleArgumentExpressionList EOF
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
	// InternalCommon.g:1921:1: ruleArgumentExpressionList returns [EObject current=null] : ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* ) ;
	public final EObject ruleArgumentExpressionList() throws RecognitionException {
		EObject current = null;


		Token this_SKW_COMMA_1=null;
		EObject lv_expr_0_0 =null;
		EObject lv_expr_2_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:1927:7: ( ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* ) )
			// InternalCommon.g:1929:3: ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* )
			{
			// InternalCommon.g:1929:3: ( ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )* )
			// InternalCommon.g:1930:3: ( (lv_expr_0_0= ruleConditionalExpression ) ) (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )*
			{
			// InternalCommon.g:1930:3: ( (lv_expr_0_0= ruleConditionalExpression ) )
			// InternalCommon.g:1931:3: (lv_expr_0_0= ruleConditionalExpression )
			{
			// InternalCommon.g:1931:3: (lv_expr_0_0= ruleConditionalExpression )
			// InternalCommon.g:1932:3: lv_expr_0_0= ruleConditionalExpression
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

			// InternalCommon.g:1951:17: (this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) ) )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==RULE_SKW_COMMA) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// InternalCommon.g:1952:17: this_SKW_COMMA_1= RULE_SKW_COMMA ( (lv_expr_2_0= ruleConditionalExpression ) )
					{
					this_SKW_COMMA_1=(Token)match(input,RULE_SKW_COMMA,FOLLOW_4); 
					 
					    newLeafNode(this_SKW_COMMA_1, grammarAccess.getArgumentExpressionListAccess().getSKW_COMMATerminalRuleCall_1_0()); 
					    
					// InternalCommon.g:1959:3: ( (lv_expr_2_0= ruleConditionalExpression ) )
					// InternalCommon.g:1960:3: (lv_expr_2_0= ruleConditionalExpression )
					{
					// InternalCommon.g:1960:3: (lv_expr_2_0= ruleConditionalExpression )
					// InternalCommon.g:1961:3: lv_expr_2_0= ruleConditionalExpression
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
			    		/*no after found*/
			     
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
	// $ANTLR end "ruleArgumentExpressionList"



	// $ANTLR start "entryRulePrimaryExpression"
	// InternalCommon.g:1991:1: entryRulePrimaryExpression returns [EObject current=null] :iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
	public final EObject entryRulePrimaryExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_rulePrimaryExpression =null;

		try {
			// InternalCommon.g:1992:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
			// InternalCommon.g:1993:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
	// InternalCommon.g:2000:1: rulePrimaryExpression returns [EObject current=null] : ( () ( ( (lv_const_1_0= ruleConstant1 ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( (lv_expr_3_0= ruleExpression ) ) this_SKW_RIGHTPAREN_4= RULE_SKW_RIGHTPAREN ) ) ;
	public final EObject rulePrimaryExpression() throws RecognitionException {
		EObject current = null;


		Token this_SKW_LEFTPAREN_2=null;
		Token this_SKW_RIGHTPAREN_4=null;
		AntlrDatatypeRuleToken lv_const_1_0 =null;
		EObject lv_expr_3_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCommon.g:2006:7: ( ( () ( ( (lv_const_1_0= ruleConstant1 ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( (lv_expr_3_0= ruleExpression ) ) this_SKW_RIGHTPAREN_4= RULE_SKW_RIGHTPAREN ) ) )
			// InternalCommon.g:2008:5: ( () ( ( (lv_const_1_0= ruleConstant1 ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( (lv_expr_3_0= ruleExpression ) ) this_SKW_RIGHTPAREN_4= RULE_SKW_RIGHTPAREN ) )
			{
			// InternalCommon.g:2008:5: ( () ( ( (lv_const_1_0= ruleConstant1 ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( (lv_expr_3_0= ruleExpression ) ) this_SKW_RIGHTPAREN_4= RULE_SKW_RIGHTPAREN ) )
			// InternalCommon.g:2009:5: () ( ( (lv_const_1_0= ruleConstant1 ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( (lv_expr_3_0= ruleExpression ) ) this_SKW_RIGHTPAREN_4= RULE_SKW_RIGHTPAREN )
			{
			// InternalCommon.g:2009:5: ()
			// InternalCommon.g:2010:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_0(),
			            current);
			    
			}

			// InternalCommon.g:2018:3: ( ( (lv_const_1_0= ruleConstant1 ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( (lv_expr_3_0= ruleExpression ) ) this_SKW_RIGHTPAREN_4= RULE_SKW_RIGHTPAREN )
			// InternalCommon.g:2019:3: ( (lv_const_1_0= ruleConstant1 ) ) this_SKW_LEFTPAREN_2= RULE_SKW_LEFTPAREN ( (lv_expr_3_0= ruleExpression ) ) this_SKW_RIGHTPAREN_4= RULE_SKW_RIGHTPAREN
			{
			// InternalCommon.g:2019:3: ( (lv_const_1_0= ruleConstant1 ) )
			// InternalCommon.g:2020:3: (lv_const_1_0= ruleConstant1 )
			{
			// InternalCommon.g:2020:3: (lv_const_1_0= ruleConstant1 )
			// InternalCommon.g:2021:3: lv_const_1_0= ruleConstant1
			{
			 
				        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getConstConstant1ParserRuleCall_1_0_0()); 
				    
			pushFollow(FOLLOW_20);
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

			this_SKW_LEFTPAREN_2=(Token)match(input,RULE_SKW_LEFTPAREN,FOLLOW_4); 
			 
			    newLeafNode(this_SKW_LEFTPAREN_2, grammarAccess.getPrimaryExpressionAccess().getSKW_LEFTPARENTerminalRuleCall_1_1()); 
			    
			// InternalCommon.g:2047:3: ( (lv_expr_3_0= ruleExpression ) )
			// InternalCommon.g:2048:3: (lv_expr_3_0= ruleExpression )
			{
			// InternalCommon.g:2048:3: (lv_expr_3_0= ruleExpression )
			// InternalCommon.g:2049:3: lv_expr_3_0= ruleExpression
			{
			 
				        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExprExpressionParserRuleCall_1_2_0()); 
				    
			pushFollow(FOLLOW_18);
			lv_expr_3_0=ruleExpression();
			state._fsp--;


				        if (current==null) {
				            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
				        }
			       		set(
			       			current, 
			       			"expr",
			        		lv_expr_3_0, 
			        		"at.jku.weiner.c.common.Common.Expression");
				        afterParserOrEnumRuleCall();
				    
			}

			}

			this_SKW_RIGHTPAREN_4=(Token)match(input,RULE_SKW_RIGHTPAREN,FOLLOW_2); 
			 
			    newLeafNode(this_SKW_RIGHTPAREN_4, grammarAccess.getPrimaryExpressionAccess().getSKW_RIGHTPARENTerminalRuleCall_1_3()); 
			    
			}

			}

			}

			 leaveRule();
			    		/*no after found*/
			     
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
	// $ANTLR end "rulePrimaryExpression"



	// $ANTLR start "entryRuleConstant1"
	// InternalCommon.g:2086:1: entryRuleConstant1 returns [String current=null] :iv_ruleConstant1= ruleConstant1 EOF ;
	public final String entryRuleConstant1() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleConstant1 =null;

		try {
			// InternalCommon.g:2087:2: (iv_ruleConstant1= ruleConstant1 EOF )
			// InternalCommon.g:2088:2: iv_ruleConstant1= ruleConstant1 EOF
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
	// InternalCommon.g:2095:1: ruleConstant1 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEX_LITERAL_0= RULE_HEX_LITERAL |this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL |this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL |this_CHAR_LITERAL_3= RULE_CHAR_LITERAL |this_STRING_LITERAL_4= RULE_STRING_LITERAL |this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL |this_BIN_LITERAL_6= RULE_BIN_LITERAL ) ;
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
			// InternalCommon.g:2098:28: ( (this_HEX_LITERAL_0= RULE_HEX_LITERAL |this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL |this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL |this_CHAR_LITERAL_3= RULE_CHAR_LITERAL |this_STRING_LITERAL_4= RULE_STRING_LITERAL |this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL |this_BIN_LITERAL_6= RULE_BIN_LITERAL ) )
			// InternalCommon.g:2099:6: (this_HEX_LITERAL_0= RULE_HEX_LITERAL |this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL |this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL |this_CHAR_LITERAL_3= RULE_CHAR_LITERAL |this_STRING_LITERAL_4= RULE_STRING_LITERAL |this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL |this_BIN_LITERAL_6= RULE_BIN_LITERAL )
			{
			// InternalCommon.g:2099:6: (this_HEX_LITERAL_0= RULE_HEX_LITERAL |this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL |this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL |this_CHAR_LITERAL_3= RULE_CHAR_LITERAL |this_STRING_LITERAL_4= RULE_STRING_LITERAL |this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL |this_BIN_LITERAL_6= RULE_BIN_LITERAL )
			int alt22=7;
			switch ( input.LA(1) ) {
			case RULE_HEX_LITERAL:
				{
				alt22=1;
				}
				break;
			case RULE_OCTAL_LITERAL:
				{
				alt22=2;
				}
				break;
			case RULE_DECIMAL_LITERAL:
				{
				alt22=3;
				}
				break;
			case RULE_CHAR_LITERAL:
				{
				alt22=4;
				}
				break;
			case RULE_STRING_LITERAL:
				{
				alt22=5;
				}
				break;
			case RULE_FLOAT_LITERAL:
				{
				alt22=6;
				}
				break;
			case RULE_BIN_LITERAL:
				{
				alt22=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}
			switch (alt22) {
				case 1 :
					// InternalCommon.g:2099:6: this_HEX_LITERAL_0= RULE_HEX_LITERAL
					{
					this_HEX_LITERAL_0=(Token)match(input,RULE_HEX_LITERAL,FOLLOW_2); 

							current.merge(this_HEX_LITERAL_0);
					    
					 
					    newLeafNode(this_HEX_LITERAL_0, grammarAccess.getConstant1Access().getHEX_LITERALTerminalRuleCall_0()); 
					    
					}
					break;
				case 2 :
					// InternalCommon.g:2107:10: this_OCTAL_LITERAL_1= RULE_OCTAL_LITERAL
					{
					this_OCTAL_LITERAL_1=(Token)match(input,RULE_OCTAL_LITERAL,FOLLOW_2); 

							current.merge(this_OCTAL_LITERAL_1);
					    
					 
					    newLeafNode(this_OCTAL_LITERAL_1, grammarAccess.getConstant1Access().getOCTAL_LITERALTerminalRuleCall_1()); 
					    
					}
					break;
				case 3 :
					// InternalCommon.g:2115:10: this_DECIMAL_LITERAL_2= RULE_DECIMAL_LITERAL
					{
					this_DECIMAL_LITERAL_2=(Token)match(input,RULE_DECIMAL_LITERAL,FOLLOW_2); 

							current.merge(this_DECIMAL_LITERAL_2);
					    
					 
					    newLeafNode(this_DECIMAL_LITERAL_2, grammarAccess.getConstant1Access().getDECIMAL_LITERALTerminalRuleCall_2()); 
					    
					}
					break;
				case 4 :
					// InternalCommon.g:2123:10: this_CHAR_LITERAL_3= RULE_CHAR_LITERAL
					{
					this_CHAR_LITERAL_3=(Token)match(input,RULE_CHAR_LITERAL,FOLLOW_2); 

							current.merge(this_CHAR_LITERAL_3);
					    
					 
					    newLeafNode(this_CHAR_LITERAL_3, grammarAccess.getConstant1Access().getCHAR_LITERALTerminalRuleCall_3()); 
					    
					}
					break;
				case 5 :
					// InternalCommon.g:2131:10: this_STRING_LITERAL_4= RULE_STRING_LITERAL
					{
					this_STRING_LITERAL_4=(Token)match(input,RULE_STRING_LITERAL,FOLLOW_2); 

							current.merge(this_STRING_LITERAL_4);
					    
					 
					    newLeafNode(this_STRING_LITERAL_4, grammarAccess.getConstant1Access().getSTRING_LITERALTerminalRuleCall_4()); 
					    
					}
					break;
				case 6 :
					// InternalCommon.g:2139:10: this_FLOAT_LITERAL_5= RULE_FLOAT_LITERAL
					{
					this_FLOAT_LITERAL_5=(Token)match(input,RULE_FLOAT_LITERAL,FOLLOW_2); 

							current.merge(this_FLOAT_LITERAL_5);
					    
					 
					    newLeafNode(this_FLOAT_LITERAL_5, grammarAccess.getConstant1Access().getFLOAT_LITERALTerminalRuleCall_5()); 
					    
					}
					break;
				case 7 :
					// InternalCommon.g:2147:10: this_BIN_LITERAL_6= RULE_BIN_LITERAL
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
	public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0040000000000002L});
	public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x6011200003004990L,0x0000000000000004L});
	public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0008000000000002L});
	public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000004000002L});
	public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000002000002L});
	public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0002001000000002L});
	public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000186000000002L});
	public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0400040000000002L});
	public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0010200000000002L});
	public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x2000800100000002L});
	public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000020000000002L});
	public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x6211200003004990L,0x0000000000000004L});
	public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000020000000000L});
}
