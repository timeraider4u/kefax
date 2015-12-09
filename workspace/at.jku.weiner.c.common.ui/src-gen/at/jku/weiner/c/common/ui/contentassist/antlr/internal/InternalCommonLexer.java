package at.jku.weiner.c.common.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCommonLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public InternalCommonLexer() {} 
	public InternalCommonLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public InternalCommonLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "InternalCommon.g"; }

	// $ANTLR start "RULE_SKW_AND"
	public final void mRULE_SKW_AND() throws RecognitionException {
		try {
			int _type = RULE_SKW_AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:104:14: ( '&' )
			// InternalCommon.g:104:16: '&'
			{
			match('&'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_AND"

	// $ANTLR start "RULE_SKW_ANDAND"
	public final void mRULE_SKW_ANDAND() throws RecognitionException {
		try {
			int _type = RULE_SKW_ANDAND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:106:17: ( RULE_SKW_AND RULE_SKW_AND )
			// InternalCommon.g:106:19: RULE_SKW_AND RULE_SKW_AND
			{
			mRULE_SKW_AND(); 

			mRULE_SKW_AND(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_ANDAND"

	// $ANTLR start "RULE_SKW_ASSIGN"
	public final void mRULE_SKW_ASSIGN() throws RecognitionException {
		try {
			int _type = RULE_SKW_ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:108:17: ( '=' )
			// InternalCommon.g:108:19: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_ASSIGN"

	// $ANTLR start "RULE_SKW_BACKSLASH"
	public final void mRULE_SKW_BACKSLASH() throws RecognitionException {
		try {
			int _type = RULE_SKW_BACKSLASH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:110:20: ( '\\\\' )
			// InternalCommon.g:110:22: '\\\\'
			{
			match('\\'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_BACKSLASH"

	// $ANTLR start "RULE_SKW_CARET"
	public final void mRULE_SKW_CARET() throws RecognitionException {
		try {
			int _type = RULE_SKW_CARET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:112:16: ( '^' )
			// InternalCommon.g:112:18: '^'
			{
			match('^'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_CARET"

	// $ANTLR start "RULE_SKW_COMMA"
	public final void mRULE_SKW_COMMA() throws RecognitionException {
		try {
			int _type = RULE_SKW_COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:114:16: ( ',' )
			// InternalCommon.g:114:18: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_COMMA"

	// $ANTLR start "RULE_SKW_COLON"
	public final void mRULE_SKW_COLON() throws RecognitionException {
		try {
			int _type = RULE_SKW_COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:116:16: ( ':' )
			// InternalCommon.g:116:18: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_COLON"

	// $ANTLR start "RULE_SKW_DIV"
	public final void mRULE_SKW_DIV() throws RecognitionException {
		try {
			int _type = RULE_SKW_DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:118:14: ( '/' )
			// InternalCommon.g:118:16: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_DIV"

	// $ANTLR start "RULE_SKW_DOLLAR"
	public final void mRULE_SKW_DOLLAR() throws RecognitionException {
		try {
			// InternalCommon.g:120:26: ( '$' )
			// InternalCommon.g:120:28: '$'
			{
			match('$'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_DOLLAR"

	// $ANTLR start "RULE_SKW_DOT"
	public final void mRULE_SKW_DOT() throws RecognitionException {
		try {
			int _type = RULE_SKW_DOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:122:14: ( '.' )
			// InternalCommon.g:122:16: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_DOT"

	// $ANTLR start "RULE_SKW_DOUBLEQUOTE"
	public final void mRULE_SKW_DOUBLEQUOTE() throws RecognitionException {
		try {
			int _type = RULE_SKW_DOUBLEQUOTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:124:22: ( '\"' )
			// InternalCommon.g:124:24: '\"'
			{
			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_DOUBLEQUOTE"

	// $ANTLR start "RULE_SKW_EQUAL"
	public final void mRULE_SKW_EQUAL() throws RecognitionException {
		try {
			int _type = RULE_SKW_EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:126:16: ( RULE_SKW_ASSIGN RULE_SKW_ASSIGN )
			// InternalCommon.g:126:18: RULE_SKW_ASSIGN RULE_SKW_ASSIGN
			{
			mRULE_SKW_ASSIGN(); 

			mRULE_SKW_ASSIGN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_EQUAL"

	// $ANTLR start "RULE_SKW_GREATER"
	public final void mRULE_SKW_GREATER() throws RecognitionException {
		try {
			int _type = RULE_SKW_GREATER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:128:18: ( '>' )
			// InternalCommon.g:128:20: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_GREATER"

	// $ANTLR start "RULE_SKW_GREATEREQUAL"
	public final void mRULE_SKW_GREATEREQUAL() throws RecognitionException {
		try {
			int _type = RULE_SKW_GREATEREQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:130:23: ( RULE_SKW_GREATER RULE_SKW_ASSIGN )
			// InternalCommon.g:130:25: RULE_SKW_GREATER RULE_SKW_ASSIGN
			{
			mRULE_SKW_GREATER(); 

			mRULE_SKW_ASSIGN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_GREATEREQUAL"

	// $ANTLR start "RULE_SKW_LEFTBRACE"
	public final void mRULE_SKW_LEFTBRACE() throws RecognitionException {
		try {
			int _type = RULE_SKW_LEFTBRACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:132:20: ( '{' )
			// InternalCommon.g:132:22: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_LEFTBRACE"

	// $ANTLR start "RULE_SKW_LEFTBRACKET"
	public final void mRULE_SKW_LEFTBRACKET() throws RecognitionException {
		try {
			int _type = RULE_SKW_LEFTBRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:134:22: ( '[' )
			// InternalCommon.g:134:24: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_LEFTBRACKET"

	// $ANTLR start "RULE_SKW_LEFTPAREN"
	public final void mRULE_SKW_LEFTPAREN() throws RecognitionException {
		try {
			int _type = RULE_SKW_LEFTPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:136:20: ( '(' )
			// InternalCommon.g:136:22: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_LEFTPAREN"

	// $ANTLR start "RULE_SKW_LEFTSHIFT"
	public final void mRULE_SKW_LEFTSHIFT() throws RecognitionException {
		try {
			int _type = RULE_SKW_LEFTSHIFT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:138:20: ( RULE_SKW_LESS RULE_SKW_LESS )
			// InternalCommon.g:138:22: RULE_SKW_LESS RULE_SKW_LESS
			{
			mRULE_SKW_LESS(); 

			mRULE_SKW_LESS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_LEFTSHIFT"

	// $ANTLR start "RULE_SKW_LESS"
	public final void mRULE_SKW_LESS() throws RecognitionException {
		try {
			int _type = RULE_SKW_LESS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:140:15: ( '<' )
			// InternalCommon.g:140:17: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_LESS"

	// $ANTLR start "RULE_SKW_LESSEQUAL"
	public final void mRULE_SKW_LESSEQUAL() throws RecognitionException {
		try {
			int _type = RULE_SKW_LESSEQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:142:20: ( RULE_SKW_LESS RULE_SKW_ASSIGN )
			// InternalCommon.g:142:22: RULE_SKW_LESS RULE_SKW_ASSIGN
			{
			mRULE_SKW_LESS(); 

			mRULE_SKW_ASSIGN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_LESSEQUAL"

	// $ANTLR start "RULE_SKW_MINUS"
	public final void mRULE_SKW_MINUS() throws RecognitionException {
		try {
			int _type = RULE_SKW_MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:144:16: ( '-' )
			// InternalCommon.g:144:18: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_MINUS"

	// $ANTLR start "RULE_SKW_MINUSMINUS"
	public final void mRULE_SKW_MINUSMINUS() throws RecognitionException {
		try {
			int _type = RULE_SKW_MINUSMINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:146:21: ( RULE_SKW_MINUS RULE_SKW_MINUS )
			// InternalCommon.g:146:23: RULE_SKW_MINUS RULE_SKW_MINUS
			{
			mRULE_SKW_MINUS(); 

			mRULE_SKW_MINUS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_MINUSMINUS"

	// $ANTLR start "RULE_SKW_MOD"
	public final void mRULE_SKW_MOD() throws RecognitionException {
		try {
			int _type = RULE_SKW_MOD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:148:14: ( '%' )
			// InternalCommon.g:148:16: '%'
			{
			match('%'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_MOD"

	// $ANTLR start "RULE_SKW_NOT"
	public final void mRULE_SKW_NOT() throws RecognitionException {
		try {
			int _type = RULE_SKW_NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:150:14: ( '!' )
			// InternalCommon.g:150:16: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_NOT"

	// $ANTLR start "RULE_SKW_NOTEQUAL"
	public final void mRULE_SKW_NOTEQUAL() throws RecognitionException {
		try {
			int _type = RULE_SKW_NOTEQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:152:19: ( RULE_SKW_NOT RULE_SKW_ASSIGN )
			// InternalCommon.g:152:21: RULE_SKW_NOT RULE_SKW_ASSIGN
			{
			mRULE_SKW_NOT(); 

			mRULE_SKW_ASSIGN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_NOTEQUAL"

	// $ANTLR start "RULE_SKW_OR"
	public final void mRULE_SKW_OR() throws RecognitionException {
		try {
			int _type = RULE_SKW_OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:154:13: ( '|' )
			// InternalCommon.g:154:15: '|'
			{
			match('|'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_OR"

	// $ANTLR start "RULE_SKW_OROR"
	public final void mRULE_SKW_OROR() throws RecognitionException {
		try {
			int _type = RULE_SKW_OROR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:156:15: ( RULE_SKW_OR RULE_SKW_OR )
			// InternalCommon.g:156:17: RULE_SKW_OR RULE_SKW_OR
			{
			mRULE_SKW_OR(); 

			mRULE_SKW_OR(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_OROR"

	// $ANTLR start "RULE_SKW_PLUS"
	public final void mRULE_SKW_PLUS() throws RecognitionException {
		try {
			int _type = RULE_SKW_PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:158:15: ( '+' )
			// InternalCommon.g:158:17: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_PLUS"

	// $ANTLR start "RULE_SKW_PLUSPLUS"
	public final void mRULE_SKW_PLUSPLUS() throws RecognitionException {
		try {
			int _type = RULE_SKW_PLUSPLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:160:19: ( RULE_SKW_PLUS RULE_SKW_PLUS )
			// InternalCommon.g:160:21: RULE_SKW_PLUS RULE_SKW_PLUS
			{
			mRULE_SKW_PLUS(); 

			mRULE_SKW_PLUS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_PLUSPLUS"

	// $ANTLR start "RULE_SKW_QUESTION"
	public final void mRULE_SKW_QUESTION() throws RecognitionException {
		try {
			int _type = RULE_SKW_QUESTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:162:19: ( '?' )
			// InternalCommon.g:162:21: '?'
			{
			match('?'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_QUESTION"

	// $ANTLR start "RULE_SKW_RIGHTBRACE"
	public final void mRULE_SKW_RIGHTBRACE() throws RecognitionException {
		try {
			int _type = RULE_SKW_RIGHTBRACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:164:21: ( '}' )
			// InternalCommon.g:164:23: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_RIGHTBRACE"

	// $ANTLR start "RULE_SKW_RIGHTBRACKET"
	public final void mRULE_SKW_RIGHTBRACKET() throws RecognitionException {
		try {
			int _type = RULE_SKW_RIGHTBRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:166:23: ( ']' )
			// InternalCommon.g:166:25: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_RIGHTBRACKET"

	// $ANTLR start "RULE_SKW_RIGHTPAREN"
	public final void mRULE_SKW_RIGHTPAREN() throws RecognitionException {
		try {
			int _type = RULE_SKW_RIGHTPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:168:21: ( ')' )
			// InternalCommon.g:168:23: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_RIGHTPAREN"

	// $ANTLR start "RULE_SKW_RIGHTSHIFT"
	public final void mRULE_SKW_RIGHTSHIFT() throws RecognitionException {
		try {
			int _type = RULE_SKW_RIGHTSHIFT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:170:21: ( RULE_SKW_GREATER RULE_SKW_GREATER )
			// InternalCommon.g:170:23: RULE_SKW_GREATER RULE_SKW_GREATER
			{
			mRULE_SKW_GREATER(); 

			mRULE_SKW_GREATER(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_RIGHTSHIFT"

	// $ANTLR start "RULE_SKW_SEMI"
	public final void mRULE_SKW_SEMI() throws RecognitionException {
		try {
			int _type = RULE_SKW_SEMI;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:172:15: ( ';' )
			// InternalCommon.g:172:17: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_SEMI"

	// $ANTLR start "RULE_SKW_SINGLEQUOTE"
	public final void mRULE_SKW_SINGLEQUOTE() throws RecognitionException {
		try {
			int _type = RULE_SKW_SINGLEQUOTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:174:22: ( '\\'' )
			// InternalCommon.g:174:24: '\\''
			{
			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_SINGLEQUOTE"

	// $ANTLR start "RULE_SKW_STAR"
	public final void mRULE_SKW_STAR() throws RecognitionException {
		try {
			int _type = RULE_SKW_STAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:176:15: ( '*' )
			// InternalCommon.g:176:17: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_STAR"

	// $ANTLR start "RULE_SKW_TILDE"
	public final void mRULE_SKW_TILDE() throws RecognitionException {
		try {
			int _type = RULE_SKW_TILDE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:178:16: ( '~' )
			// InternalCommon.g:178:18: '~'
			{
			match('~'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_TILDE"

	// $ANTLR start "RULE_SKW_UNDERSCORE"
	public final void mRULE_SKW_UNDERSCORE() throws RecognitionException {
		try {
			// InternalCommon.g:180:30: ( '_' )
			// InternalCommon.g:180:32: '_'
			{
			match('_'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_UNDERSCORE"

	// $ANTLR start "RULE_SPECIAL"
	public final void mRULE_SPECIAL() throws RecognitionException {
		try {
			int _type = RULE_SPECIAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:182:14: ( . )
			// InternalCommon.g:182:16: .
			{
			matchAny(); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SPECIAL"

	@Override
	public void mTokens() throws RecognitionException {
		// InternalCommon.g:1:8: ( RULE_SKW_AND | RULE_SKW_ANDAND | RULE_SKW_ASSIGN | RULE_SKW_BACKSLASH | RULE_SKW_CARET | RULE_SKW_COMMA | RULE_SKW_COLON | RULE_SKW_DIV | RULE_SKW_DOT | RULE_SKW_DOUBLEQUOTE | RULE_SKW_EQUAL | RULE_SKW_GREATER | RULE_SKW_GREATEREQUAL | RULE_SKW_LEFTBRACE | RULE_SKW_LEFTBRACKET | RULE_SKW_LEFTPAREN | RULE_SKW_LEFTSHIFT | RULE_SKW_LESS | RULE_SKW_LESSEQUAL | RULE_SKW_MINUS | RULE_SKW_MINUSMINUS | RULE_SKW_MOD | RULE_SKW_NOT | RULE_SKW_NOTEQUAL | RULE_SKW_OR | RULE_SKW_OROR | RULE_SKW_PLUS | RULE_SKW_PLUSPLUS | RULE_SKW_QUESTION | RULE_SKW_RIGHTBRACE | RULE_SKW_RIGHTBRACKET | RULE_SKW_RIGHTPAREN | RULE_SKW_RIGHTSHIFT | RULE_SKW_SEMI | RULE_SKW_SINGLEQUOTE | RULE_SKW_STAR | RULE_SKW_TILDE | RULE_SPECIAL )
		int alt1=38;
		alt1 = dfa1.predict(input);
		switch (alt1) {
			case 1 :
				// InternalCommon.g:1:10: RULE_SKW_AND
				{
				mRULE_SKW_AND(); 

				}
				break;
			case 2 :
				// InternalCommon.g:1:23: RULE_SKW_ANDAND
				{
				mRULE_SKW_ANDAND(); 

				}
				break;
			case 3 :
				// InternalCommon.g:1:39: RULE_SKW_ASSIGN
				{
				mRULE_SKW_ASSIGN(); 

				}
				break;
			case 4 :
				// InternalCommon.g:1:55: RULE_SKW_BACKSLASH
				{
				mRULE_SKW_BACKSLASH(); 

				}
				break;
			case 5 :
				// InternalCommon.g:1:74: RULE_SKW_CARET
				{
				mRULE_SKW_CARET(); 

				}
				break;
			case 6 :
				// InternalCommon.g:1:89: RULE_SKW_COMMA
				{
				mRULE_SKW_COMMA(); 

				}
				break;
			case 7 :
				// InternalCommon.g:1:104: RULE_SKW_COLON
				{
				mRULE_SKW_COLON(); 

				}
				break;
			case 8 :
				// InternalCommon.g:1:119: RULE_SKW_DIV
				{
				mRULE_SKW_DIV(); 

				}
				break;
			case 9 :
				// InternalCommon.g:1:132: RULE_SKW_DOT
				{
				mRULE_SKW_DOT(); 

				}
				break;
			case 10 :
				// InternalCommon.g:1:145: RULE_SKW_DOUBLEQUOTE
				{
				mRULE_SKW_DOUBLEQUOTE(); 

				}
				break;
			case 11 :
				// InternalCommon.g:1:166: RULE_SKW_EQUAL
				{
				mRULE_SKW_EQUAL(); 

				}
				break;
			case 12 :
				// InternalCommon.g:1:181: RULE_SKW_GREATER
				{
				mRULE_SKW_GREATER(); 

				}
				break;
			case 13 :
				// InternalCommon.g:1:198: RULE_SKW_GREATEREQUAL
				{
				mRULE_SKW_GREATEREQUAL(); 

				}
				break;
			case 14 :
				// InternalCommon.g:1:220: RULE_SKW_LEFTBRACE
				{
				mRULE_SKW_LEFTBRACE(); 

				}
				break;
			case 15 :
				// InternalCommon.g:1:239: RULE_SKW_LEFTBRACKET
				{
				mRULE_SKW_LEFTBRACKET(); 

				}
				break;
			case 16 :
				// InternalCommon.g:1:260: RULE_SKW_LEFTPAREN
				{
				mRULE_SKW_LEFTPAREN(); 

				}
				break;
			case 17 :
				// InternalCommon.g:1:279: RULE_SKW_LEFTSHIFT
				{
				mRULE_SKW_LEFTSHIFT(); 

				}
				break;
			case 18 :
				// InternalCommon.g:1:298: RULE_SKW_LESS
				{
				mRULE_SKW_LESS(); 

				}
				break;
			case 19 :
				// InternalCommon.g:1:312: RULE_SKW_LESSEQUAL
				{
				mRULE_SKW_LESSEQUAL(); 

				}
				break;
			case 20 :
				// InternalCommon.g:1:331: RULE_SKW_MINUS
				{
				mRULE_SKW_MINUS(); 

				}
				break;
			case 21 :
				// InternalCommon.g:1:346: RULE_SKW_MINUSMINUS
				{
				mRULE_SKW_MINUSMINUS(); 

				}
				break;
			case 22 :
				// InternalCommon.g:1:366: RULE_SKW_MOD
				{
				mRULE_SKW_MOD(); 

				}
				break;
			case 23 :
				// InternalCommon.g:1:379: RULE_SKW_NOT
				{
				mRULE_SKW_NOT(); 

				}
				break;
			case 24 :
				// InternalCommon.g:1:392: RULE_SKW_NOTEQUAL
				{
				mRULE_SKW_NOTEQUAL(); 

				}
				break;
			case 25 :
				// InternalCommon.g:1:410: RULE_SKW_OR
				{
				mRULE_SKW_OR(); 

				}
				break;
			case 26 :
				// InternalCommon.g:1:422: RULE_SKW_OROR
				{
				mRULE_SKW_OROR(); 

				}
				break;
			case 27 :
				// InternalCommon.g:1:436: RULE_SKW_PLUS
				{
				mRULE_SKW_PLUS(); 

				}
				break;
			case 28 :
				// InternalCommon.g:1:450: RULE_SKW_PLUSPLUS
				{
				mRULE_SKW_PLUSPLUS(); 

				}
				break;
			case 29 :
				// InternalCommon.g:1:468: RULE_SKW_QUESTION
				{
				mRULE_SKW_QUESTION(); 

				}
				break;
			case 30 :
				// InternalCommon.g:1:486: RULE_SKW_RIGHTBRACE
				{
				mRULE_SKW_RIGHTBRACE(); 

				}
				break;
			case 31 :
				// InternalCommon.g:1:506: RULE_SKW_RIGHTBRACKET
				{
				mRULE_SKW_RIGHTBRACKET(); 

				}
				break;
			case 32 :
				// InternalCommon.g:1:528: RULE_SKW_RIGHTPAREN
				{
				mRULE_SKW_RIGHTPAREN(); 

				}
				break;
			case 33 :
				// InternalCommon.g:1:548: RULE_SKW_RIGHTSHIFT
				{
				mRULE_SKW_RIGHTSHIFT(); 

				}
				break;
			case 34 :
				// InternalCommon.g:1:568: RULE_SKW_SEMI
				{
				mRULE_SKW_SEMI(); 

				}
				break;
			case 35 :
				// InternalCommon.g:1:582: RULE_SKW_SINGLEQUOTE
				{
				mRULE_SKW_SINGLEQUOTE(); 

				}
				break;
			case 36 :
				// InternalCommon.g:1:603: RULE_SKW_STAR
				{
				mRULE_SKW_STAR(); 

				}
				break;
			case 37 :
				// InternalCommon.g:1:617: RULE_SKW_TILDE
				{
				mRULE_SKW_TILDE(); 

				}
				break;
			case 38 :
				// InternalCommon.g:1:632: RULE_SPECIAL
				{
				mRULE_SPECIAL(); 

				}
				break;

		}
	}


	protected DFA1 dfa1 = new DFA1(this);
	static final String DFA1_eotS =
		"\1\uffff\1\35\1\37\7\uffff\1\50\3\uffff\1\56\1\61\1\uffff\1\64\1\66\1\70\56\uffff";
	static final String DFA1_eofS =
		"\102\uffff";
	static final String DFA1_minS =
		"\1\0\1\46\1\75\7\uffff\1\75\3\uffff\1\74\1\55\1\uffff\1\75\1\174\1\53\56\uffff";
	static final String DFA1_maxS =
		"\1\uffff\1\46\1\75\7\uffff\1\76\3\uffff\1\75\1\55\1\uffff\1\75\1\174\1\53\56\uffff";
	static final String DFA1_acceptS =
		"\3\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\uffff\1\16\1\17\1\20\2\uffff\1\26\3\uffff\1\35\1\36\1\37\1\40\1\42\1\43\1\44\1\45\1\46\1\1\1\2\1\3\1\13\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\14\1\15\1\41\1\16\1\17\1\20\1\22\1\21\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\42\1\43\1\44\1\45";
	static final String DFA1_specialS =
		"\1\0\101\uffff}>";
	static final String[] DFA1_transitionS = {
			"\41\34\1\21\1\11\2\34\1\20\1\1\1\31\1\15\1\27\1\32\1\23\1\5\1\17\1\10\1\7\12\34\1\6\1\30\1\16\1\2\1\12\1\24\33\34\1\14\1\3\1\26\1\4\34\34\1\13\1\22\1\25\1\33\uff81\34",
			"\1\36",
			"\1\40",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\51\1\52",
			"",
			"",
			"",
			"\1\57\1\60",
			"\1\62",
			"",
			"\1\65",
			"\1\67",
			"\1\71",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
	static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
	static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
	static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
	static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
	static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
	static final short[][] DFA1_transition;

	static {
		int numStates = DFA1_transitionS.length;
		DFA1_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
		}
	}

	protected class DFA1 extends DFA {

		public DFA1(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 1;
			this.eot = DFA1_eot;
			this.eof = DFA1_eof;
			this.min = DFA1_min;
			this.max = DFA1_max;
			this.accept = DFA1_accept;
			this.special = DFA1_special;
			this.transition = DFA1_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( RULE_SKW_AND | RULE_SKW_ANDAND | RULE_SKW_ASSIGN | RULE_SKW_BACKSLASH | RULE_SKW_CARET | RULE_SKW_COMMA | RULE_SKW_COLON | RULE_SKW_DIV | RULE_SKW_DOT | RULE_SKW_DOUBLEQUOTE | RULE_SKW_EQUAL | RULE_SKW_GREATER | RULE_SKW_GREATEREQUAL | RULE_SKW_LEFTBRACE | RULE_SKW_LEFTBRACKET | RULE_SKW_LEFTPAREN | RULE_SKW_LEFTSHIFT | RULE_SKW_LESS | RULE_SKW_LESSEQUAL | RULE_SKW_MINUS | RULE_SKW_MINUSMINUS | RULE_SKW_MOD | RULE_SKW_NOT | RULE_SKW_NOTEQUAL | RULE_SKW_OR | RULE_SKW_OROR | RULE_SKW_PLUS | RULE_SKW_PLUSPLUS | RULE_SKW_QUESTION | RULE_SKW_RIGHTBRACE | RULE_SKW_RIGHTBRACKET | RULE_SKW_RIGHTPAREN | RULE_SKW_RIGHTSHIFT | RULE_SKW_SEMI | RULE_SKW_SINGLEQUOTE | RULE_SKW_STAR | RULE_SKW_TILDE | RULE_SPECIAL );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			int _s = s;
			switch ( s ) {
					case 0 : 
						s = specialState0(s, input);
						if (s >= 0) return s;
							break;

			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 1, _s, input);
			error(nvae);
			throw nvae;
		}
			private int specialState0(int s, IntStream _input) {
				IntStream input = _input;
				int LA1_0 = input.LA(1);
				s = -1;
				if ( (LA1_0=='&') ) {s = 1;}
				else if ( (LA1_0=='=') ) {s = 2;}
				else if ( (LA1_0=='\\') ) {s = 3;}
				else if ( (LA1_0=='^') ) {s = 4;}
				else if ( (LA1_0==',') ) {s = 5;}
				else if ( (LA1_0==':') ) {s = 6;}
				else if ( (LA1_0=='/') ) {s = 7;}
				else if ( (LA1_0=='.') ) {s = 8;}
				else if ( (LA1_0=='\"') ) {s = 9;}
				else if ( (LA1_0=='>') ) {s = 10;}
				else if ( (LA1_0=='{') ) {s = 11;}
				else if ( (LA1_0=='[') ) {s = 12;}
				else if ( (LA1_0=='(') ) {s = 13;}
				else if ( (LA1_0=='<') ) {s = 14;}
				else if ( (LA1_0=='-') ) {s = 15;}
				else if ( (LA1_0=='%') ) {s = 16;}
				else if ( (LA1_0=='!') ) {s = 17;}
				else if ( (LA1_0=='|') ) {s = 18;}
				else if ( (LA1_0=='+') ) {s = 19;}
				else if ( (LA1_0=='?') ) {s = 20;}
				else if ( (LA1_0=='}') ) {s = 21;}
				else if ( (LA1_0==']') ) {s = 22;}
				else if ( (LA1_0==')') ) {s = 23;}
				else if ( (LA1_0==';') ) {s = 24;}
				else if ( (LA1_0=='\'') ) {s = 25;}
				else if ( (LA1_0=='*') ) {s = 26;}
				else if ( (LA1_0=='~') ) {s = 27;}
				else if ( ((LA1_0 >= '\u0000' && LA1_0 <= ' ')||(LA1_0 >= '#' && LA1_0 <= '$')||(LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= '@' && LA1_0 <= 'Z')||(LA1_0 >= '_' && LA1_0 <= 'z')||(LA1_0 >= '\u007F' && LA1_0 <= '\uFFFF')) ) {s = 28;}
				//if ( s>=0 ) return s;
				//break;
				return s;
			}

	}


}
