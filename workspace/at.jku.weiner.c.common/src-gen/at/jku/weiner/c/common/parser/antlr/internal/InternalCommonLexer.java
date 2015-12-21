package at.jku.weiner.c.common.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCommonLexer extends Lexer {
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
			// InternalCommon.g:2136:14: ( '&' )
			// InternalCommon.g:2136:16: '&'
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
			// InternalCommon.g:2138:17: ( RULE_SKW_AND RULE_SKW_AND )
			// InternalCommon.g:2138:19: RULE_SKW_AND RULE_SKW_AND
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
			// InternalCommon.g:2140:17: ( '=' )
			// InternalCommon.g:2140:19: '='
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
			// InternalCommon.g:2142:20: ( '\\\\' )
			// InternalCommon.g:2142:22: '\\\\'
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
			// InternalCommon.g:2144:16: ( '^' )
			// InternalCommon.g:2144:18: '^'
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
			// InternalCommon.g:2146:16: ( ',' )
			// InternalCommon.g:2146:18: ','
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
			// InternalCommon.g:2148:16: ( ':' )
			// InternalCommon.g:2148:18: ':'
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
			// InternalCommon.g:2150:14: ( '/' )
			// InternalCommon.g:2150:16: '/'
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
			// InternalCommon.g:2152:26: ( '$' )
			// InternalCommon.g:2152:28: '$'
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
			// InternalCommon.g:2154:14: ( '.' )
			// InternalCommon.g:2154:16: '.'
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
			// InternalCommon.g:2156:22: ( '\"' )
			// InternalCommon.g:2156:24: '\"'
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
			// InternalCommon.g:2158:16: ( RULE_SKW_ASSIGN RULE_SKW_ASSIGN )
			// InternalCommon.g:2158:18: RULE_SKW_ASSIGN RULE_SKW_ASSIGN
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
			// InternalCommon.g:2160:18: ( '>' )
			// InternalCommon.g:2160:20: '>'
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
			// InternalCommon.g:2162:23: ( RULE_SKW_GREATER RULE_SKW_ASSIGN )
			// InternalCommon.g:2162:25: RULE_SKW_GREATER RULE_SKW_ASSIGN
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
			// InternalCommon.g:2164:20: ( '{' )
			// InternalCommon.g:2164:22: '{'
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
			// InternalCommon.g:2166:22: ( '[' )
			// InternalCommon.g:2166:24: '['
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
			// InternalCommon.g:2168:20: ( '(' )
			// InternalCommon.g:2168:22: '('
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
			// InternalCommon.g:2170:20: ( RULE_SKW_LESS RULE_SKW_LESS )
			// InternalCommon.g:2170:22: RULE_SKW_LESS RULE_SKW_LESS
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
			// InternalCommon.g:2172:15: ( '<' )
			// InternalCommon.g:2172:17: '<'
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
			// InternalCommon.g:2174:20: ( RULE_SKW_LESS RULE_SKW_ASSIGN )
			// InternalCommon.g:2174:22: RULE_SKW_LESS RULE_SKW_ASSIGN
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
			// InternalCommon.g:2176:16: ( '-' )
			// InternalCommon.g:2176:18: '-'
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
			// InternalCommon.g:2178:21: ( RULE_SKW_MINUS RULE_SKW_MINUS )
			// InternalCommon.g:2178:23: RULE_SKW_MINUS RULE_SKW_MINUS
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
			// InternalCommon.g:2180:14: ( '%' )
			// InternalCommon.g:2180:16: '%'
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
			// InternalCommon.g:2182:14: ( '!' )
			// InternalCommon.g:2182:16: '!'
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
			// InternalCommon.g:2184:19: ( RULE_SKW_NOT RULE_SKW_ASSIGN )
			// InternalCommon.g:2184:21: RULE_SKW_NOT RULE_SKW_ASSIGN
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
			// InternalCommon.g:2186:13: ( '|' )
			// InternalCommon.g:2186:15: '|'
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
			// InternalCommon.g:2188:15: ( RULE_SKW_OR RULE_SKW_OR )
			// InternalCommon.g:2188:17: RULE_SKW_OR RULE_SKW_OR
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
			// InternalCommon.g:2190:15: ( '+' )
			// InternalCommon.g:2190:17: '+'
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
			// InternalCommon.g:2192:19: ( RULE_SKW_PLUS RULE_SKW_PLUS )
			// InternalCommon.g:2192:21: RULE_SKW_PLUS RULE_SKW_PLUS
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
			// InternalCommon.g:2194:19: ( '?' )
			// InternalCommon.g:2194:21: '?'
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
			// InternalCommon.g:2196:21: ( '}' )
			// InternalCommon.g:2196:23: '}'
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
			// InternalCommon.g:2198:23: ( ']' )
			// InternalCommon.g:2198:25: ']'
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
			// InternalCommon.g:2200:21: ( ')' )
			// InternalCommon.g:2200:23: ')'
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
			// InternalCommon.g:2202:21: ( RULE_SKW_GREATER RULE_SKW_GREATER )
			// InternalCommon.g:2202:23: RULE_SKW_GREATER RULE_SKW_GREATER
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
			// InternalCommon.g:2204:15: ( ';' )
			// InternalCommon.g:2204:17: ';'
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
			// InternalCommon.g:2206:22: ( '\\'' )
			// InternalCommon.g:2206:24: '\\''
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
			// InternalCommon.g:2208:15: ( '*' )
			// InternalCommon.g:2208:17: '*'
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
			// InternalCommon.g:2210:16: ( '~' )
			// InternalCommon.g:2210:18: '~'
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
			// InternalCommon.g:2212:30: ( '_' )
			// InternalCommon.g:2212:32: '_'
			{
			match('_'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SKW_UNDERSCORE"

	// $ANTLR start "RULE_ID"
	public final void mRULE_ID() throws RecognitionException {
		try {
			int _type = RULE_ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:2214:9: ( RULE_IDENTIFIER )
			// InternalCommon.g:2214:11: RULE_IDENTIFIER
			{
			mRULE_IDENTIFIER(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_ID"

	// $ANTLR start "RULE_IDENTIFIER"
	public final void mRULE_IDENTIFIER() throws RecognitionException {
		try {
			// InternalCommon.g:2216:26: ( RULE_LETTER ( RULE_LETTER | '0' .. '9' )* )
			// InternalCommon.g:2216:28: RULE_LETTER ( RULE_LETTER | '0' .. '9' )*
			{
			mRULE_LETTER(); 

			// InternalCommon.g:2216:40: ( RULE_LETTER | '0' .. '9' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0=='$'||(LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// InternalCommon.g:
					{
					if ( input.LA(1)=='$'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_IDENTIFIER"

	// $ANTLR start "RULE_LETTER"
	public final void mRULE_LETTER() throws RecognitionException {
		try {
			// InternalCommon.g:2218:22: ( ( RULE_SKW_DOLLAR | 'A' .. 'Z' | 'a' .. 'z' | RULE_SKW_UNDERSCORE ) )
			// InternalCommon.g:
			{
			if ( input.LA(1)=='$'||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_LETTER"

	// $ANTLR start "RULE_CHAR_LITERAL"
	public final void mRULE_CHAR_LITERAL() throws RecognitionException {
		try {
			int _type = RULE_CHAR_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:2220:19: ( RULE_SKW_SINGLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) ) RULE_SKW_SINGLEQUOTE )
			// InternalCommon.g:2220:21: RULE_SKW_SINGLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) ) RULE_SKW_SINGLEQUOTE
			{
			mRULE_SKW_SINGLEQUOTE(); 

			// InternalCommon.g:2220:42: ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='\\') ) {
				alt2=1;
			}
			else if ( ((LA2_0 >= '\u0000' && LA2_0 <= '&')||(LA2_0 >= '(' && LA2_0 <= '[')||(LA2_0 >= ']' && LA2_0 <= '\uFFFF')) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// InternalCommon.g:2220:43: RULE_ESCAPE_SEQUENCE
					{
					mRULE_ESCAPE_SEQUENCE(); 

					}
					break;
				case 2 :
					// InternalCommon.g:2220:64: ~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			mRULE_SKW_SINGLEQUOTE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_CHAR_LITERAL"

	// $ANTLR start "RULE_STRING_LITERAL"
	public final void mRULE_STRING_LITERAL() throws RecognitionException {
		try {
			int _type = RULE_STRING_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:2222:21: ( RULE_SKW_DOUBLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) )* RULE_SKW_DOUBLEQUOTE )
			// InternalCommon.g:2222:23: RULE_SKW_DOUBLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) )* RULE_SKW_DOUBLEQUOTE
			{
			mRULE_SKW_DOUBLEQUOTE(); 

			// InternalCommon.g:2222:44: ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) )*
			loop3:
			while (true) {
				int alt3=3;
				int LA3_0 = input.LA(1);
				if ( (LA3_0=='\\') ) {
					alt3=1;
				}
				else if ( ((LA3_0 >= '\u0000' && LA3_0 <= '!')||(LA3_0 >= '#' && LA3_0 <= '[')||(LA3_0 >= ']' && LA3_0 <= '\uFFFF')) ) {
					alt3=2;
				}

				switch (alt3) {
				case 1 :
					// InternalCommon.g:2222:45: RULE_ESCAPE_SEQUENCE
					{
					mRULE_ESCAPE_SEQUENCE(); 

					}
					break;
				case 2 :
					// InternalCommon.g:2222:66: ~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop3;
				}
			}

			mRULE_SKW_DOUBLEQUOTE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_STRING_LITERAL"

	// $ANTLR start "RULE_HEX_LITERAL"
	public final void mRULE_HEX_LITERAL() throws RecognitionException {
		try {
			int _type = RULE_HEX_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:2224:18: ( '0' ( 'x' | 'X' ) ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )? )
			// InternalCommon.g:2224:20: '0' ( 'x' | 'X' ) ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )?
			{
			match('0'); 
			if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// InternalCommon.g:2224:34: ( RULE_HEX_DIGIT )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'F')||(LA4_0 >= 'a' && LA4_0 <= 'f')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// InternalCommon.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			// InternalCommon.g:2224:50: ( RULE_INTEGER_TYPE_SUFFIX )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='L'||LA5_0=='U'||LA5_0=='l'||LA5_0=='u') ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// InternalCommon.g:2224:50: RULE_INTEGER_TYPE_SUFFIX
					{
					mRULE_INTEGER_TYPE_SUFFIX(); 

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_HEX_LITERAL"

	// $ANTLR start "RULE_DECIMAL_LITERAL"
	public final void mRULE_DECIMAL_LITERAL() throws RecognitionException {
		try {
			int _type = RULE_DECIMAL_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:2226:22: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( RULE_INTEGER_TYPE_SUFFIX )? )
			// InternalCommon.g:2226:24: ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( RULE_INTEGER_TYPE_SUFFIX )?
			{
			// InternalCommon.g:2226:24: ( '0' | '1' .. '9' ( '0' .. '9' )* )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0=='0') ) {
				alt7=1;
			}
			else if ( ((LA7_0 >= '1' && LA7_0 <= '9')) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// InternalCommon.g:2226:25: '0'
					{
					match('0'); 
					}
					break;
				case 2 :
					// InternalCommon.g:2226:29: '1' .. '9' ( '0' .. '9' )*
					{
					matchRange('1','9'); 
					// InternalCommon.g:2226:38: ( '0' .. '9' )*
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
							alt6=1;
						}

						switch (alt6) {
						case 1 :
							// InternalCommon.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop6;
						}
					}

					}
					break;

			}

			// InternalCommon.g:2226:51: ( RULE_INTEGER_TYPE_SUFFIX )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0=='L'||LA8_0=='U'||LA8_0=='l'||LA8_0=='u') ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// InternalCommon.g:2226:51: RULE_INTEGER_TYPE_SUFFIX
					{
					mRULE_INTEGER_TYPE_SUFFIX(); 

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_DECIMAL_LITERAL"

	// $ANTLR start "RULE_OCTAL_LITERAL"
	public final void mRULE_OCTAL_LITERAL() throws RecognitionException {
		try {
			int _type = RULE_OCTAL_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:2228:20: ( '0' ( '0' .. '7' )+ ( RULE_INTEGER_TYPE_SUFFIX )? )
			// InternalCommon.g:2228:22: '0' ( '0' .. '7' )+ ( RULE_INTEGER_TYPE_SUFFIX )?
			{
			match('0'); 
			// InternalCommon.g:2228:26: ( '0' .. '7' )+
			int cnt9=0;
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= '0' && LA9_0 <= '7')) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// InternalCommon.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt9 >= 1 ) break loop9;
					EarlyExitException eee = new EarlyExitException(9, input);
					throw eee;
				}
				cnt9++;
			}

			// InternalCommon.g:2228:38: ( RULE_INTEGER_TYPE_SUFFIX )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='L'||LA10_0=='U'||LA10_0=='l'||LA10_0=='u') ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// InternalCommon.g:2228:38: RULE_INTEGER_TYPE_SUFFIX
					{
					mRULE_INTEGER_TYPE_SUFFIX(); 

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_OCTAL_LITERAL"

	// $ANTLR start "RULE_BIN_LITERAL"
	public final void mRULE_BIN_LITERAL() throws RecognitionException {
		try {
			int _type = RULE_BIN_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:2230:18: ( ( '0b' | '0B' ) ( '0' .. '1' )+ )
			// InternalCommon.g:2230:20: ( '0b' | '0B' ) ( '0' .. '1' )+
			{
			// InternalCommon.g:2230:20: ( '0b' | '0B' )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0=='0') ) {
				int LA11_1 = input.LA(2);
				if ( (LA11_1=='b') ) {
					alt11=1;
				}
				else if ( (LA11_1=='B') ) {
					alt11=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 11, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// InternalCommon.g:2230:21: '0b'
					{
					match("0b"); 

					}
					break;
				case 2 :
					// InternalCommon.g:2230:26: '0B'
					{
					match("0B"); 

					}
					break;

			}

			// InternalCommon.g:2230:32: ( '0' .. '1' )+
			int cnt12=0;
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( ((LA12_0 >= '0' && LA12_0 <= '1')) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// InternalCommon.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '1') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt12 >= 1 ) break loop12;
					EarlyExitException eee = new EarlyExitException(12, input);
					throw eee;
				}
				cnt12++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_BIN_LITERAL"

	// $ANTLR start "RULE_HEX_DIGIT"
	public final void mRULE_HEX_DIGIT() throws RecognitionException {
		try {
			// InternalCommon.g:2232:25: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
			// InternalCommon.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_HEX_DIGIT"

	// $ANTLR start "RULE_INTEGER_TYPE_SUFFIX"
	public final void mRULE_INTEGER_TYPE_SUFFIX() throws RecognitionException {
		try {
			// InternalCommon.g:2234:35: ( ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? ) )
			// InternalCommon.g:2234:37: ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? )
			{
			// InternalCommon.g:2234:37: ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? )
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0=='U'||LA15_0=='u') ) {
				int LA15_1 = input.LA(2);
				if ( (LA15_1=='L'||LA15_1=='l') ) {
					alt15=1;
				}

				else {
					alt15=2;
				}

			}
			else if ( (LA15_0=='L'||LA15_0=='l') ) {
				alt15=1;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}

			switch (alt15) {
				case 1 :
					// InternalCommon.g:2234:38: ( 'u' | 'U' )? ( 'l' | 'L' )
					{
					// InternalCommon.g:2234:38: ( 'u' | 'U' )?
					int alt13=2;
					int LA13_0 = input.LA(1);
					if ( (LA13_0=='U'||LA13_0=='u') ) {
						alt13=1;
					}
					switch (alt13) {
						case 1 :
							// InternalCommon.g:
							{
							if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

					}

					if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// InternalCommon.g:2234:59: ( 'u' | 'U' ) ( 'l' | 'L' )?
					{
					if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// InternalCommon.g:2234:69: ( 'l' | 'L' )?
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0=='L'||LA14_0=='l') ) {
						alt14=1;
					}
					switch (alt14) {
						case 1 :
							// InternalCommon.g:
							{
							if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

					}

					}
					break;

			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_INTEGER_TYPE_SUFFIX"

	// $ANTLR start "RULE_FLOAT_LITERAL"
	public final void mRULE_FLOAT_LITERAL() throws RecognitionException {
		try {
			int _type = RULE_FLOAT_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:2236:20: ( ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX ) )
			// InternalCommon.g:2236:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )
			{
			// InternalCommon.g:2236:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )
			int alt27=4;
			alt27 = dfa27.predict(input);
			switch (alt27) {
				case 1 :
					// InternalCommon.g:2236:23: ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )?
					{
					// InternalCommon.g:2236:23: ( '0' .. '9' )+
					int cnt16=0;
					loop16:
					while (true) {
						int alt16=2;
						int LA16_0 = input.LA(1);
						if ( ((LA16_0 >= '0' && LA16_0 <= '9')) ) {
							alt16=1;
						}

						switch (alt16) {
						case 1 :
							// InternalCommon.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt16 >= 1 ) break loop16;
							EarlyExitException eee = new EarlyExitException(16, input);
							throw eee;
						}
						cnt16++;
					}

					mRULE_SKW_DOT(); 

					// InternalCommon.g:2236:48: ( '0' .. '9' )*
					loop17:
					while (true) {
						int alt17=2;
						int LA17_0 = input.LA(1);
						if ( ((LA17_0 >= '0' && LA17_0 <= '9')) ) {
							alt17=1;
						}

						switch (alt17) {
						case 1 :
							// InternalCommon.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop17;
						}
					}

					// InternalCommon.g:2236:60: ( RULE_EXPONENT )?
					int alt18=2;
					int LA18_0 = input.LA(1);
					if ( (LA18_0=='E'||LA18_0=='e') ) {
						alt18=1;
					}
					switch (alt18) {
						case 1 :
							// InternalCommon.g:2236:60: RULE_EXPONENT
							{
							mRULE_EXPONENT(); 

							}
							break;

					}

					// InternalCommon.g:2236:75: ( RULE_FLOAT_TYPE_SUFFIX )?
					int alt19=2;
					int LA19_0 = input.LA(1);
					if ( (LA19_0=='D'||LA19_0=='F'||LA19_0=='d'||LA19_0=='f') ) {
						alt19=1;
					}
					switch (alt19) {
						case 1 :
							// InternalCommon.g:
							{
							if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

					}

					}
					break;
				case 2 :
					// InternalCommon.g:2236:99: RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )?
					{
					mRULE_SKW_DOT(); 

					// InternalCommon.g:2236:112: ( '0' .. '9' )+
					int cnt20=0;
					loop20:
					while (true) {
						int alt20=2;
						int LA20_0 = input.LA(1);
						if ( ((LA20_0 >= '0' && LA20_0 <= '9')) ) {
							alt20=1;
						}

						switch (alt20) {
						case 1 :
							// InternalCommon.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt20 >= 1 ) break loop20;
							EarlyExitException eee = new EarlyExitException(20, input);
							throw eee;
						}
						cnt20++;
					}

					// InternalCommon.g:2236:124: ( RULE_EXPONENT )?
					int alt21=2;
					int LA21_0 = input.LA(1);
					if ( (LA21_0=='E'||LA21_0=='e') ) {
						alt21=1;
					}
					switch (alt21) {
						case 1 :
							// InternalCommon.g:2236:124: RULE_EXPONENT
							{
							mRULE_EXPONENT(); 

							}
							break;

					}

					// InternalCommon.g:2236:139: ( RULE_FLOAT_TYPE_SUFFIX )?
					int alt22=2;
					int LA22_0 = input.LA(1);
					if ( (LA22_0=='D'||LA22_0=='F'||LA22_0=='d'||LA22_0=='f') ) {
						alt22=1;
					}
					switch (alt22) {
						case 1 :
							// InternalCommon.g:
							{
							if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

					}

					}
					break;
				case 3 :
					// InternalCommon.g:2236:163: ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )?
					{
					// InternalCommon.g:2236:163: ( '0' .. '9' )+
					int cnt23=0;
					loop23:
					while (true) {
						int alt23=2;
						int LA23_0 = input.LA(1);
						if ( ((LA23_0 >= '0' && LA23_0 <= '9')) ) {
							alt23=1;
						}

						switch (alt23) {
						case 1 :
							// InternalCommon.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt23 >= 1 ) break loop23;
							EarlyExitException eee = new EarlyExitException(23, input);
							throw eee;
						}
						cnt23++;
					}

					mRULE_EXPONENT(); 

					// InternalCommon.g:2236:189: ( RULE_FLOAT_TYPE_SUFFIX )?
					int alt24=2;
					int LA24_0 = input.LA(1);
					if ( (LA24_0=='D'||LA24_0=='F'||LA24_0=='d'||LA24_0=='f') ) {
						alt24=1;
					}
					switch (alt24) {
						case 1 :
							// InternalCommon.g:
							{
							if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

					}

					}
					break;
				case 4 :
					// InternalCommon.g:2236:213: ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX
					{
					// InternalCommon.g:2236:213: ( '0' .. '9' )+
					int cnt25=0;
					loop25:
					while (true) {
						int alt25=2;
						int LA25_0 = input.LA(1);
						if ( ((LA25_0 >= '0' && LA25_0 <= '9')) ) {
							alt25=1;
						}

						switch (alt25) {
						case 1 :
							// InternalCommon.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt25 >= 1 ) break loop25;
							EarlyExitException eee = new EarlyExitException(25, input);
							throw eee;
						}
						cnt25++;
					}

					// InternalCommon.g:2236:225: ( RULE_EXPONENT )?
					int alt26=2;
					int LA26_0 = input.LA(1);
					if ( (LA26_0=='E'||LA26_0=='e') ) {
						alt26=1;
					}
					switch (alt26) {
						case 1 :
							// InternalCommon.g:2236:225: RULE_EXPONENT
							{
							mRULE_EXPONENT(); 

							}
							break;

					}

					mRULE_FLOAT_TYPE_SUFFIX(); 

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_FLOAT_LITERAL"

	// $ANTLR start "RULE_EXPONENT"
	public final void mRULE_EXPONENT() throws RecognitionException {
		try {
			// InternalCommon.g:2238:24: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
			// InternalCommon.g:2238:26: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// InternalCommon.g:2238:36: ( '+' | '-' )?
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0=='+'||LA28_0=='-') ) {
				alt28=1;
			}
			switch (alt28) {
				case 1 :
					// InternalCommon.g:
					{
					if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			// InternalCommon.g:2238:47: ( '0' .. '9' )+
			int cnt29=0;
			loop29:
			while (true) {
				int alt29=2;
				int LA29_0 = input.LA(1);
				if ( ((LA29_0 >= '0' && LA29_0 <= '9')) ) {
					alt29=1;
				}

				switch (alt29) {
				case 1 :
					// InternalCommon.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt29 >= 1 ) break loop29;
					EarlyExitException eee = new EarlyExitException(29, input);
					throw eee;
				}
				cnt29++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_EXPONENT"

	// $ANTLR start "RULE_FLOAT_TYPE_SUFFIX"
	public final void mRULE_FLOAT_TYPE_SUFFIX() throws RecognitionException {
		try {
			// InternalCommon.g:2240:33: ( ( 'f' | 'F' | 'd' | 'D' ) )
			// InternalCommon.g:
			{
			if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_FLOAT_TYPE_SUFFIX"

	// $ANTLR start "RULE_ESCAPE_SEQUENCE"
	public final void mRULE_ESCAPE_SEQUENCE() throws RecognitionException {
		try {
			// InternalCommon.g:2242:31: ( ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE ) )
			// InternalCommon.g:2242:33: ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE )
			{
			// InternalCommon.g:2242:33: ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE )
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0=='\\') ) {
				int LA30_1 = input.LA(2);
				if ( (LA30_1=='\"'||LA30_1=='\''||LA30_1=='\\'||LA30_1=='b'||LA30_1=='f'||LA30_1=='n'||LA30_1=='r'||LA30_1=='t') ) {
					alt30=1;
				}
				else if ( ((LA30_1 >= '0' && LA30_1 <= '7')) ) {
					alt30=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 30, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}

			switch (alt30) {
				case 1 :
					// InternalCommon.g:2242:34: RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH )
					{
					mRULE_SKW_BACKSLASH(); 

					if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// InternalCommon.g:2242:119: RULE_OCTAL_ESCAPE
					{
					mRULE_OCTAL_ESCAPE(); 

					}
					break;

			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_ESCAPE_SEQUENCE"

	// $ANTLR start "RULE_OCTAL_ESCAPE"
	public final void mRULE_OCTAL_ESCAPE() throws RecognitionException {
		try {
			// InternalCommon.g:2244:28: ( ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' ) )
			// InternalCommon.g:2244:30: ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' )
			{
			// InternalCommon.g:2244:30: ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' )
			int alt31=3;
			int LA31_0 = input.LA(1);
			if ( (LA31_0=='\\') ) {
				int LA31_1 = input.LA(2);
				if ( ((LA31_1 >= '0' && LA31_1 <= '3')) ) {
					int LA31_2 = input.LA(3);
					if ( ((LA31_2 >= '0' && LA31_2 <= '7')) ) {
						int LA31_4 = input.LA(4);
						if ( ((LA31_4 >= '0' && LA31_4 <= '7')) ) {
							alt31=1;
						}

						else {
							alt31=2;
						}

					}

					else {
						alt31=3;
					}

				}
				else if ( ((LA31_1 >= '4' && LA31_1 <= '7')) ) {
					int LA31_3 = input.LA(3);
					if ( ((LA31_3 >= '0' && LA31_3 <= '7')) ) {
						alt31=2;
					}

					else {
						alt31=3;
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 31, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}

			switch (alt31) {
				case 1 :
					// InternalCommon.g:2244:31: RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7'
					{
					mRULE_SKW_BACKSLASH(); 

					matchRange('0','3'); 
					matchRange('0','7'); 
					matchRange('0','7'); 
					}
					break;
				case 2 :
					// InternalCommon.g:2244:77: RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7'
					{
					mRULE_SKW_BACKSLASH(); 

					matchRange('0','7'); 
					matchRange('0','7'); 
					}
					break;
				case 3 :
					// InternalCommon.g:2244:114: RULE_SKW_BACKSLASH '0' .. '7'
					{
					mRULE_SKW_BACKSLASH(); 

					matchRange('0','7'); 
					}
					break;

			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_OCTAL_ESCAPE"

	// $ANTLR start "RULE_LINEFEED"
	public final void mRULE_LINEFEED() throws RecognitionException {
		try {
			// InternalCommon.g:2246:24: ( '\\n' )
			// InternalCommon.g:2246:26: '\\n'
			{
			match('\n'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_LINEFEED"

	// $ANTLR start "RULE_CARRIAGERETURN"
	public final void mRULE_CARRIAGERETURN() throws RecognitionException {
		try {
			// InternalCommon.g:2248:30: ( '\\r' )
			// InternalCommon.g:2248:32: '\\r'
			{
			match('\r'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_CARRIAGERETURN"

	// $ANTLR start "RULE_NEWLINE"
	public final void mRULE_NEWLINE() throws RecognitionException {
		try {
			// InternalCommon.g:2250:23: ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) )
			// InternalCommon.g:
			{
			if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_NEWLINE"

	// $ANTLR start "RULE_LINEBREAK"
	public final void mRULE_LINEBREAK() throws RecognitionException {
		try {
			int _type = RULE_LINEBREAK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:2252:16: ( RULE_SKW_BACKSLASH RULE_NEWLINE )
			// InternalCommon.g:2252:18: RULE_SKW_BACKSLASH RULE_NEWLINE
			{
			mRULE_SKW_BACKSLASH(); 

			mRULE_NEWLINE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_LINEBREAK"

	// $ANTLR start "RULE_SPACE"
	public final void mRULE_SPACE() throws RecognitionException {
		try {
			// InternalCommon.g:2254:21: ( ' ' )
			// InternalCommon.g:2254:23: ' '
			{
			match(' '); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SPACE"

	// $ANTLR start "RULE_TAB"
	public final void mRULE_TAB() throws RecognitionException {
		try {
			// InternalCommon.g:2256:19: ( '\\t' )
			// InternalCommon.g:2256:21: '\\t'
			{
			match('\t'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_TAB"

	// $ANTLR start "RULE_WHITESPACE"
	public final void mRULE_WHITESPACE() throws RecognitionException {
		try {
			int _type = RULE_WHITESPACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:2258:17: ( ( RULE_SPACE | RULE_TAB ) )
			// InternalCommon.g:
			{
			if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_WHITESPACE"

	// $ANTLR start "RULE_BLOCK_COMMENT"
	public final void mRULE_BLOCK_COMMENT() throws RecognitionException {
		try {
			int _type = RULE_BLOCK_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:2260:20: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// InternalCommon.g:2260:22: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// InternalCommon.g:2260:27: ( options {greedy=false; } : . )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0=='*') ) {
					int LA32_1 = input.LA(2);
					if ( (LA32_1=='/') ) {
						alt32=2;
					}
					else if ( ((LA32_1 >= '\u0000' && LA32_1 <= '.')||(LA32_1 >= '0' && LA32_1 <= '\uFFFF')) ) {
						alt32=1;
					}

				}
				else if ( ((LA32_0 >= '\u0000' && LA32_0 <= ')')||(LA32_0 >= '+' && LA32_0 <= '\uFFFF')) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// InternalCommon.g:2260:55: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop32;
				}
			}

			match("*/"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_BLOCK_COMMENT"

	// $ANTLR start "RULE_LINE_COMMENT"
	public final void mRULE_LINE_COMMENT() throws RecognitionException {
		try {
			int _type = RULE_LINE_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:2262:19: ( '//' (~ ( RULE_NEWLINE ) )* )
			// InternalCommon.g:2262:21: '//' (~ ( RULE_NEWLINE ) )*
			{
			match("//"); 

			// InternalCommon.g:2262:26: (~ ( RULE_NEWLINE ) )*
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( ((LA33_0 >= '\u0000' && LA33_0 <= '\t')||(LA33_0 >= '\u000B' && LA33_0 <= '\f')||(LA33_0 >= '\u000E' && LA33_0 <= '\uFFFF')) ) {
					alt33=1;
				}

				switch (alt33) {
				case 1 :
					// InternalCommon.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop33;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_LINE_COMMENT"

	// $ANTLR start "RULE_SPECIAL"
	public final void mRULE_SPECIAL() throws RecognitionException {
		try {
			int _type = RULE_SPECIAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:2264:14: ( . )
			// InternalCommon.g:2264:16: .
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
		// InternalCommon.g:1:8: ( RULE_SKW_AND | RULE_SKW_ANDAND | RULE_SKW_ASSIGN | RULE_SKW_BACKSLASH | RULE_SKW_CARET | RULE_SKW_COMMA | RULE_SKW_COLON | RULE_SKW_DIV | RULE_SKW_DOT | RULE_SKW_DOUBLEQUOTE | RULE_SKW_EQUAL | RULE_SKW_GREATER | RULE_SKW_GREATEREQUAL | RULE_SKW_LEFTBRACE | RULE_SKW_LEFTBRACKET | RULE_SKW_LEFTPAREN | RULE_SKW_LEFTSHIFT | RULE_SKW_LESS | RULE_SKW_LESSEQUAL | RULE_SKW_MINUS | RULE_SKW_MINUSMINUS | RULE_SKW_MOD | RULE_SKW_NOT | RULE_SKW_NOTEQUAL | RULE_SKW_OR | RULE_SKW_OROR | RULE_SKW_PLUS | RULE_SKW_PLUSPLUS | RULE_SKW_QUESTION | RULE_SKW_RIGHTBRACE | RULE_SKW_RIGHTBRACKET | RULE_SKW_RIGHTPAREN | RULE_SKW_RIGHTSHIFT | RULE_SKW_SEMI | RULE_SKW_SINGLEQUOTE | RULE_SKW_STAR | RULE_SKW_TILDE | RULE_ID | RULE_CHAR_LITERAL | RULE_STRING_LITERAL | RULE_HEX_LITERAL | RULE_DECIMAL_LITERAL | RULE_OCTAL_LITERAL | RULE_BIN_LITERAL | RULE_FLOAT_LITERAL | RULE_LINEBREAK | RULE_WHITESPACE | RULE_BLOCK_COMMENT | RULE_LINE_COMMENT | RULE_SPECIAL )
		int alt34=50;
		alt34 = dfa34.predict(input);
		switch (alt34) {
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
				// InternalCommon.g:1:632: RULE_ID
				{
				mRULE_ID(); 

				}
				break;
			case 39 :
				// InternalCommon.g:1:640: RULE_CHAR_LITERAL
				{
				mRULE_CHAR_LITERAL(); 

				}
				break;
			case 40 :
				// InternalCommon.g:1:658: RULE_STRING_LITERAL
				{
				mRULE_STRING_LITERAL(); 

				}
				break;
			case 41 :
				// InternalCommon.g:1:678: RULE_HEX_LITERAL
				{
				mRULE_HEX_LITERAL(); 

				}
				break;
			case 42 :
				// InternalCommon.g:1:695: RULE_DECIMAL_LITERAL
				{
				mRULE_DECIMAL_LITERAL(); 

				}
				break;
			case 43 :
				// InternalCommon.g:1:716: RULE_OCTAL_LITERAL
				{
				mRULE_OCTAL_LITERAL(); 

				}
				break;
			case 44 :
				// InternalCommon.g:1:735: RULE_BIN_LITERAL
				{
				mRULE_BIN_LITERAL(); 

				}
				break;
			case 45 :
				// InternalCommon.g:1:752: RULE_FLOAT_LITERAL
				{
				mRULE_FLOAT_LITERAL(); 

				}
				break;
			case 46 :
				// InternalCommon.g:1:771: RULE_LINEBREAK
				{
				mRULE_LINEBREAK(); 

				}
				break;
			case 47 :
				// InternalCommon.g:1:786: RULE_WHITESPACE
				{
				mRULE_WHITESPACE(); 

				}
				break;
			case 48 :
				// InternalCommon.g:1:802: RULE_BLOCK_COMMENT
				{
				mRULE_BLOCK_COMMENT(); 

				}
				break;
			case 49 :
				// InternalCommon.g:1:821: RULE_LINE_COMMENT
				{
				mRULE_LINE_COMMENT(); 

				}
				break;
			case 50 :
				// InternalCommon.g:1:839: RULE_SPECIAL
				{
				mRULE_SPECIAL(); 

				}
				break;

		}
	}


	protected DFA27 dfa27 = new DFA27(this);
	protected DFA34 dfa34 = new DFA34(this);
	static final String DFA27_eotS =
		"\7\uffff\1\10\2\uffff";
	static final String DFA27_eofS =
		"\12\uffff";
	static final String DFA27_minS =
		"\2\56\2\uffff\1\53\1\uffff\2\60\2\uffff";
	static final String DFA27_maxS =
		"\1\71\1\146\2\uffff\1\71\1\uffff\1\71\1\146\2\uffff";
	static final String DFA27_acceptS =
		"\2\uffff\1\2\1\1\1\uffff\1\4\2\uffff\2\3";
	static final String DFA27_specialS =
		"\12\uffff}>";
	static final String[] DFA27_transitionS = {
			"\1\2\1\uffff\12\1",
			"\1\3\1\uffff\12\1\12\uffff\1\5\1\4\1\5\35\uffff\1\5\1\4\1\5",
			"",
			"",
			"\1\6\1\uffff\1\6\2\uffff\12\7",
			"",
			"\12\7",
			"\12\7\12\uffff\1\11\1\uffff\1\11\35\uffff\1\11\1\uffff\1\11",
			"",
			""
	};

	static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
	static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
	static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
	static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
	static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
	static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
	static final short[][] DFA27_transition;

	static {
		int numStates = DFA27_transitionS.length;
		DFA27_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
		}
	}

	protected class DFA27 extends DFA {

		public DFA27(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 27;
			this.eot = DFA27_eot;
			this.eof = DFA27_eof;
			this.min = DFA27_min;
			this.max = DFA27_max;
			this.accept = DFA27_accept;
			this.special = DFA27_special;
			this.transition = DFA27_transition;
		}
		@Override
		public String getDescription() {
			return "2236:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )";
		}
	}


	static final String DFA34_eotS =
		"\1\uffff\1\41\1\43\1\45\3\uffff\1\54\1\55\1\57\1\61\3\uffff\1\67\1\72\1\uffff\1\75\1\77\1\101\5\uffff\1\110\3\uffff\2\117\61\uffff\1\123\1\117\2\uffff";
	static final String DFA34_eofS =
		"\124\uffff";
	static final String DFA34_minS =
		"\1\0\1\46\1\75\1\12\3\uffff\1\52\1\60\1\0\1\75\3\uffff\1\74\1\55\1\uffff\1\75\1\174\1\53\5\uffff\1\0\3\uffff\2\56\61\uffff\2\56\2\uffff";
	static final String DFA34_maxS =
		"\1\uffff\1\46\1\75\1\15\3\uffff\1\57\1\71\1\uffff\1\76\3\uffff\1\75\1\55\1\uffff\1\75\1\174\1\53\5\uffff\1\uffff\3\uffff\1\170\1\146\61\uffff\2\146\2\uffff";
	static final String DFA34_acceptS =
		"\4\uffff\1\5\1\6\1\7\4\uffff\1\16\1\17\1\20\2\uffff\1\26\3\uffff\1\35\1\36\1\37\1\40\1\42\1\uffff\1\44\1\45\1\46\2\uffff\1\57\1\62\1\1\1\2\1\3\1\13\1\4\1\56\1\5\1\6\1\7\1\60\1\61\1\10\1\11\1\55\1\12\1\50\1\14\1\15\1\41\1\16\1\17\1\20\1\22\1\21\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\42\1\43\1\47\1\44\1\45\1\46\1\51\1\54\1\52\2\uffff\1\57\1\53";
	static final String DFA34_specialS =
		"\1\0\10\uffff\1\1\17\uffff\1\2\72\uffff}>";
	static final String[] DFA34_transitionS = {
			"\11\40\1\37\26\40\1\37\1\21\1\11\1\40\1\34\1\20\1\1\1\31\1\15\1\27\1\32\1\23\1\5\1\17\1\10\1\7\1\35\11\36\1\6\1\30\1\16\1\2\1\12\1\24\1\40\32\34\1\14\1\3\1\26\1\4\1\34\1\40\32\34\1\13\1\22\1\25\1\33\uff81\40",
			"\1\42",
			"\1\44",
			"\1\46\2\uffff\1\46",
			"",
			"",
			"",
			"\1\52\4\uffff\1\53",
			"\12\56",
			"\0\60",
			"\1\62\1\63",
			"",
			"",
			"",
			"\1\70\1\71",
			"\1\73",
			"",
			"\1\76",
			"\1\100",
			"\1\102",
			"",
			"",
			"",
			"",
			"",
			"\47\111\1\uffff\uffd8\111",
			"",
			"",
			"",
			"\1\56\1\uffff\10\120\2\56\10\uffff\1\116\1\uffff\3\56\21\uffff\1\115\11\uffff\1\116\1\uffff\3\56\21\uffff\1\115",
			"\1\56\1\uffff\12\121\12\uffff\3\56\35\uffff\3\56",
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
			"",
			"",
			"",
			"",
			"\1\56\1\uffff\10\120\2\56\12\uffff\3\56\35\uffff\3\56",
			"\1\56\1\uffff\12\121\12\uffff\3\56\35\uffff\3\56",
			"",
			""
	};

	static final short[] DFA34_eot = DFA.unpackEncodedString(DFA34_eotS);
	static final short[] DFA34_eof = DFA.unpackEncodedString(DFA34_eofS);
	static final char[] DFA34_min = DFA.unpackEncodedStringToUnsignedChars(DFA34_minS);
	static final char[] DFA34_max = DFA.unpackEncodedStringToUnsignedChars(DFA34_maxS);
	static final short[] DFA34_accept = DFA.unpackEncodedString(DFA34_acceptS);
	static final short[] DFA34_special = DFA.unpackEncodedString(DFA34_specialS);
	static final short[][] DFA34_transition;

	static {
		int numStates = DFA34_transitionS.length;
		DFA34_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA34_transition[i] = DFA.unpackEncodedString(DFA34_transitionS[i]);
		}
	}

	protected class DFA34 extends DFA {

		public DFA34(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 34;
			this.eot = DFA34_eot;
			this.eof = DFA34_eof;
			this.min = DFA34_min;
			this.max = DFA34_max;
			this.accept = DFA34_accept;
			this.special = DFA34_special;
			this.transition = DFA34_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( RULE_SKW_AND | RULE_SKW_ANDAND | RULE_SKW_ASSIGN | RULE_SKW_BACKSLASH | RULE_SKW_CARET | RULE_SKW_COMMA | RULE_SKW_COLON | RULE_SKW_DIV | RULE_SKW_DOT | RULE_SKW_DOUBLEQUOTE | RULE_SKW_EQUAL | RULE_SKW_GREATER | RULE_SKW_GREATEREQUAL | RULE_SKW_LEFTBRACE | RULE_SKW_LEFTBRACKET | RULE_SKW_LEFTPAREN | RULE_SKW_LEFTSHIFT | RULE_SKW_LESS | RULE_SKW_LESSEQUAL | RULE_SKW_MINUS | RULE_SKW_MINUSMINUS | RULE_SKW_MOD | RULE_SKW_NOT | RULE_SKW_NOTEQUAL | RULE_SKW_OR | RULE_SKW_OROR | RULE_SKW_PLUS | RULE_SKW_PLUSPLUS | RULE_SKW_QUESTION | RULE_SKW_RIGHTBRACE | RULE_SKW_RIGHTBRACKET | RULE_SKW_RIGHTPAREN | RULE_SKW_RIGHTSHIFT | RULE_SKW_SEMI | RULE_SKW_SINGLEQUOTE | RULE_SKW_STAR | RULE_SKW_TILDE | RULE_ID | RULE_CHAR_LITERAL | RULE_STRING_LITERAL | RULE_HEX_LITERAL | RULE_DECIMAL_LITERAL | RULE_OCTAL_LITERAL | RULE_BIN_LITERAL | RULE_FLOAT_LITERAL | RULE_LINEBREAK | RULE_WHITESPACE | RULE_BLOCK_COMMENT | RULE_LINE_COMMENT | RULE_SPECIAL );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			int _s = s;
			switch ( s ) {
					case 0 : 
						s = specialState0(s, input);
						if (s >= 0) return s;
							break;

					case 1 : 
						s = specialState1(s, input);
						if (s >= 0) return s;
							break;

					case 2 : 
						s = specialState2(s, input);
						if (s >= 0) return s;
							break;

			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 34, _s, input);
			error(nvae);
			throw nvae;
		}
			private int specialState0(int s, IntStream _input) {
				IntStream input = _input;
				int LA34_0 = input.LA(1);
				s = -1;
				if ( (LA34_0=='&') ) {s = 1;}
				else if ( (LA34_0=='=') ) {s = 2;}
				else if ( (LA34_0=='\\') ) {s = 3;}
				else if ( (LA34_0=='^') ) {s = 4;}
				else if ( (LA34_0==',') ) {s = 5;}
				else if ( (LA34_0==':') ) {s = 6;}
				else if ( (LA34_0=='/') ) {s = 7;}
				else if ( (LA34_0=='.') ) {s = 8;}
				else if ( (LA34_0=='\"') ) {s = 9;}
				else if ( (LA34_0=='>') ) {s = 10;}
				else if ( (LA34_0=='{') ) {s = 11;}
				else if ( (LA34_0=='[') ) {s = 12;}
				else if ( (LA34_0=='(') ) {s = 13;}
				else if ( (LA34_0=='<') ) {s = 14;}
				else if ( (LA34_0=='-') ) {s = 15;}
				else if ( (LA34_0=='%') ) {s = 16;}
				else if ( (LA34_0=='!') ) {s = 17;}
				else if ( (LA34_0=='|') ) {s = 18;}
				else if ( (LA34_0=='+') ) {s = 19;}
				else if ( (LA34_0=='?') ) {s = 20;}
				else if ( (LA34_0=='}') ) {s = 21;}
				else if ( (LA34_0==']') ) {s = 22;}
				else if ( (LA34_0==')') ) {s = 23;}
				else if ( (LA34_0==';') ) {s = 24;}
				else if ( (LA34_0=='\'') ) {s = 25;}
				else if ( (LA34_0=='*') ) {s = 26;}
				else if ( (LA34_0=='~') ) {s = 27;}
				else if ( (LA34_0=='$'||(LA34_0 >= 'A' && LA34_0 <= 'Z')||LA34_0=='_'||(LA34_0 >= 'a' && LA34_0 <= 'z')) ) {s = 28;}
				else if ( (LA34_0=='0') ) {s = 29;}
				else if ( ((LA34_0 >= '1' && LA34_0 <= '9')) ) {s = 30;}
				else if ( (LA34_0=='\t'||LA34_0==' ') ) {s = 31;}
				else if ( ((LA34_0 >= '\u0000' && LA34_0 <= '\b')||(LA34_0 >= '\n' && LA34_0 <= '\u001F')||LA34_0=='#'||LA34_0=='@'||LA34_0=='`'||(LA34_0 >= '\u007F' && LA34_0 <= '\uFFFF')) ) {s = 32;}
				//if ( s>=0 ) return s;
				//break;
				return s;
			}

			private int specialState1(int s, IntStream _input) {
				IntStream input = _input;
				int LA34_9 = input.LA(1);
				s = -1;
				if ( ((LA34_9 >= '\u0000' && LA34_9 <= '\uFFFF')) ) {s = 48;}
				else s = 47;
				//if ( s>=0 ) return s;
				//break;
				return s;
			}

			private int specialState2(int s, IntStream _input) {
				IntStream input = _input;
				int LA34_25 = input.LA(1);
				s = -1;
				if ( ((LA34_25 >= '\u0000' && LA34_25 <= '&')||(LA34_25 >= '(' && LA34_25 <= '\uFFFF')) ) {s = 73;}
				else s = 72;
				//if ( s>=0 ) return s;
				//break;
				return s;
			}

	}


}
