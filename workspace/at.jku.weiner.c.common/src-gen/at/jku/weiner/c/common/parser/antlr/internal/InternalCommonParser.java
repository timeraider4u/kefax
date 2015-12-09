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
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SKW_AND", "RULE_SKW_ANDAND", 
		"RULE_SKW_ASSIGN", "RULE_SKW_BACKSLASH", "RULE_SKW_CARET", "RULE_SKW_COLON", 
		"RULE_SKW_COMMA", "RULE_SKW_DIV", "RULE_SKW_DOLLAR", "RULE_SKW_DOT", "RULE_SKW_DOUBLEQUOTE", 
		"RULE_SKW_EQUAL", "RULE_SKW_GREATER", "RULE_SKW_GREATEREQUAL", "RULE_SKW_LEFTBRACE", 
		"RULE_SKW_LEFTBRACKET", "RULE_SKW_LEFTPAREN", "RULE_SKW_LEFTSHIFT", "RULE_SKW_LESS", 
		"RULE_SKW_LESSEQUAL", "RULE_SKW_MINUS", "RULE_SKW_MINUSMINUS", "RULE_SKW_MOD", 
		"RULE_SKW_NOT", "RULE_SKW_NOTEQUAL", "RULE_SKW_OR", "RULE_SKW_OROR", "RULE_SKW_PLUS", 
		"RULE_SKW_PLUSPLUS", "RULE_SKW_QUESTION", "RULE_SKW_RIGHTBRACE", "RULE_SKW_RIGHTBRACKET", 
		"RULE_SKW_RIGHTPAREN", "RULE_SKW_RIGHTSHIFT", "RULE_SKW_SEMI", "RULE_SKW_SINGLEQUOTE", 
		"RULE_SKW_STAR", "RULE_SKW_TILDE", "RULE_SKW_UNDERSCORE", "RULE_SPECIAL"
	};
	public static final int EOF=-1;
	public static final int RULE_SKW_AND=4;
	public static final int RULE_SKW_ANDAND=5;
	public static final int RULE_SKW_ASSIGN=6;
	public static final int RULE_SKW_BACKSLASH=7;
	public static final int RULE_SKW_CARET=8;
	public static final int RULE_SKW_COLON=9;
	public static final int RULE_SKW_COMMA=10;
	public static final int RULE_SKW_DIV=11;
	public static final int RULE_SKW_DOLLAR=12;
	public static final int RULE_SKW_DOT=13;
	public static final int RULE_SKW_DOUBLEQUOTE=14;
	public static final int RULE_SKW_EQUAL=15;
	public static final int RULE_SKW_GREATER=16;
	public static final int RULE_SKW_GREATEREQUAL=17;
	public static final int RULE_SKW_LEFTBRACE=18;
	public static final int RULE_SKW_LEFTBRACKET=19;
	public static final int RULE_SKW_LEFTPAREN=20;
	public static final int RULE_SKW_LEFTSHIFT=21;
	public static final int RULE_SKW_LESS=22;
	public static final int RULE_SKW_LESSEQUAL=23;
	public static final int RULE_SKW_MINUS=24;
	public static final int RULE_SKW_MINUSMINUS=25;
	public static final int RULE_SKW_MOD=26;
	public static final int RULE_SKW_NOT=27;
	public static final int RULE_SKW_NOTEQUAL=28;
	public static final int RULE_SKW_OR=29;
	public static final int RULE_SKW_OROR=30;
	public static final int RULE_SKW_PLUS=31;
	public static final int RULE_SKW_PLUSPLUS=32;
	public static final int RULE_SKW_QUESTION=33;
	public static final int RULE_SKW_RIGHTBRACE=34;
	public static final int RULE_SKW_RIGHTBRACKET=35;
	public static final int RULE_SKW_RIGHTPAREN=36;
	public static final int RULE_SKW_RIGHTSHIFT=37;
	public static final int RULE_SKW_SEMI=38;
	public static final int RULE_SKW_SINGLEQUOTE=39;
	public static final int RULE_SKW_STAR=40;
	public static final int RULE_SKW_TILDE=41;
	public static final int RULE_SKW_UNDERSCORE=42;
	public static final int RULE_SPECIAL=43;

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

	// Delegated rules



	public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
}
