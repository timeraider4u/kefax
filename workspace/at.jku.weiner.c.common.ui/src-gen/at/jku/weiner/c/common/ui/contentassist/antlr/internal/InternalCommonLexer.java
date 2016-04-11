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
	public static final int RULE_BIN_LITERAL=4;
	public static final int RULE_BLOCK_COMMENT=5;
	public static final int RULE_CARRIAGERETURN=6;
	public static final int RULE_CHAR_LITERAL=7;
	public static final int RULE_DECIMAL_LITERAL=8;
	public static final int RULE_ESCAPE_SEQUENCE=9;
	public static final int RULE_EXPONENT=10;
	public static final int RULE_FLOAT_LITERAL=11;
	public static final int RULE_FLOAT_TYPE_SUFFIX=12;
	public static final int RULE_FORM_FEED=13;
	public static final int RULE_HEX_DIGIT=14;
	public static final int RULE_HEX_ESCAPE=15;
	public static final int RULE_HEX_LITERAL=16;
	public static final int RULE_HEX_PREFIX=17;
	public static final int RULE_ID=18;
	public static final int RULE_IDENTIFIER=19;
	public static final int RULE_IGNORED=20;
	public static final int RULE_INTEGER_TYPE_SUFFIX=21;
	public static final int RULE_LETTER=22;
	public static final int RULE_LINEBREAK=23;
	public static final int RULE_LINEFEED=24;
	public static final int RULE_LINE_COMMENT=25;
	public static final int RULE_LINE_END=26;
	public static final int RULE_LONG_LONG_SUFFIX=27;
	public static final int RULE_LONG_SUFFIX=28;
	public static final int RULE_NEWLINE=29;
	public static final int RULE_OCTAL_ESCAPE=30;
	public static final int RULE_OCTAL_LITERAL=31;
	public static final int RULE_SKW_AND=32;
	public static final int RULE_SKW_ANDAND=33;
	public static final int RULE_SKW_ASSIGN=34;
	public static final int RULE_SKW_BACKSLASH=35;
	public static final int RULE_SKW_CARET=36;
	public static final int RULE_SKW_COLON=37;
	public static final int RULE_SKW_COMMA=38;
	public static final int RULE_SKW_DIV=39;
	public static final int RULE_SKW_DOLLAR=40;
	public static final int RULE_SKW_DOT=41;
	public static final int RULE_SKW_DOUBLEQUOTE=42;
	public static final int RULE_SKW_EQUAL=43;
	public static final int RULE_SKW_GREATER=44;
	public static final int RULE_SKW_GREATEREQUAL=45;
	public static final int RULE_SKW_LEFTBRACE=46;
	public static final int RULE_SKW_LEFTBRACKET=47;
	public static final int RULE_SKW_LEFTPAREN=48;
	public static final int RULE_SKW_LEFTSHIFT=49;
	public static final int RULE_SKW_LESS=50;
	public static final int RULE_SKW_LESSEQUAL=51;
	public static final int RULE_SKW_MINUS=52;
	public static final int RULE_SKW_MINUSMINUS=53;
	public static final int RULE_SKW_MOD=54;
	public static final int RULE_SKW_NOT=55;
	public static final int RULE_SKW_NOTEQUAL=56;
	public static final int RULE_SKW_OR=57;
	public static final int RULE_SKW_OROR=58;
	public static final int RULE_SKW_PLUS=59;
	public static final int RULE_SKW_PLUSPLUS=60;
	public static final int RULE_SKW_QUESTION=61;
	public static final int RULE_SKW_RIGHTBRACE=62;
	public static final int RULE_SKW_RIGHTBRACKET=63;
	public static final int RULE_SKW_RIGHTPAREN=64;
	public static final int RULE_SKW_RIGHTSHIFT=65;
	public static final int RULE_SKW_SEMI=66;
	public static final int RULE_SKW_SINGLEQUOTE=67;
	public static final int RULE_SKW_STAR=68;
	public static final int RULE_SKW_TILDE=69;
	public static final int RULE_SKW_UNDERSCORE=70;
	public static final int RULE_SPACE=71;
	public static final int RULE_SPECIAL=72;
	public static final int RULE_STRING_LITERAL=73;
	public static final int RULE_TAB=74;
	public static final int RULE_UNSIGNED_SUFFIX=75;
	public static final int RULE_WHITESPACE=76;

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
			// InternalCommon.g:4552:14: ( '&' )
			// InternalCommon.g:4552:16: '&'
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
			// InternalCommon.g:4554:17: ( RULE_SKW_AND RULE_SKW_AND )
			// InternalCommon.g:4554:19: RULE_SKW_AND RULE_SKW_AND
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
			// InternalCommon.g:4556:17: ( '=' )
			// InternalCommon.g:4556:19: '='
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
			// InternalCommon.g:4558:20: ( '\\\\' )
			// InternalCommon.g:4558:22: '\\\\'
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
			// InternalCommon.g:4560:16: ( '^' )
			// InternalCommon.g:4560:18: '^'
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
			// InternalCommon.g:4562:16: ( ',' )
			// InternalCommon.g:4562:18: ','
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
			// InternalCommon.g:4564:16: ( ':' )
			// InternalCommon.g:4564:18: ':'
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
			// InternalCommon.g:4566:14: ( '/' )
			// InternalCommon.g:4566:16: '/'
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
			// InternalCommon.g:4568:26: ( '$' )
			// InternalCommon.g:4568:28: '$'
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
			// InternalCommon.g:4570:14: ( '.' )
			// InternalCommon.g:4570:16: '.'
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
			// InternalCommon.g:4572:22: ( '\"' )
			// InternalCommon.g:4572:24: '\"'
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
			// InternalCommon.g:4574:16: ( RULE_SKW_ASSIGN RULE_SKW_ASSIGN )
			// InternalCommon.g:4574:18: RULE_SKW_ASSIGN RULE_SKW_ASSIGN
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
			// InternalCommon.g:4576:18: ( '>' )
			// InternalCommon.g:4576:20: '>'
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
			// InternalCommon.g:4578:23: ( RULE_SKW_GREATER RULE_SKW_ASSIGN )
			// InternalCommon.g:4578:25: RULE_SKW_GREATER RULE_SKW_ASSIGN
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
			// InternalCommon.g:4580:20: ( '{' )
			// InternalCommon.g:4580:22: '{'
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
			// InternalCommon.g:4582:22: ( '[' )
			// InternalCommon.g:4582:24: '['
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
			// InternalCommon.g:4584:20: ( '(' )
			// InternalCommon.g:4584:22: '('
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
			// InternalCommon.g:4586:20: ( RULE_SKW_LESS RULE_SKW_LESS )
			// InternalCommon.g:4586:22: RULE_SKW_LESS RULE_SKW_LESS
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
			// InternalCommon.g:4588:15: ( '<' )
			// InternalCommon.g:4588:17: '<'
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
			// InternalCommon.g:4590:20: ( RULE_SKW_LESS RULE_SKW_ASSIGN )
			// InternalCommon.g:4590:22: RULE_SKW_LESS RULE_SKW_ASSIGN
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
			// InternalCommon.g:4592:16: ( '-' )
			// InternalCommon.g:4592:18: '-'
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
			// InternalCommon.g:4594:21: ( RULE_SKW_MINUS RULE_SKW_MINUS )
			// InternalCommon.g:4594:23: RULE_SKW_MINUS RULE_SKW_MINUS
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
			// InternalCommon.g:4596:14: ( '%' )
			// InternalCommon.g:4596:16: '%'
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
			// InternalCommon.g:4598:14: ( '!' )
			// InternalCommon.g:4598:16: '!'
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
			// InternalCommon.g:4600:19: ( RULE_SKW_NOT RULE_SKW_ASSIGN )
			// InternalCommon.g:4600:21: RULE_SKW_NOT RULE_SKW_ASSIGN
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
			// InternalCommon.g:4602:13: ( '|' )
			// InternalCommon.g:4602:15: '|'
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
			// InternalCommon.g:4604:15: ( RULE_SKW_OR RULE_SKW_OR )
			// InternalCommon.g:4604:17: RULE_SKW_OR RULE_SKW_OR
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
			// InternalCommon.g:4606:15: ( '+' )
			// InternalCommon.g:4606:17: '+'
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
			// InternalCommon.g:4608:19: ( RULE_SKW_PLUS RULE_SKW_PLUS )
			// InternalCommon.g:4608:21: RULE_SKW_PLUS RULE_SKW_PLUS
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
			// InternalCommon.g:4610:19: ( '?' )
			// InternalCommon.g:4610:21: '?'
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
			// InternalCommon.g:4612:21: ( '}' )
			// InternalCommon.g:4612:23: '}'
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
			// InternalCommon.g:4614:23: ( ']' )
			// InternalCommon.g:4614:25: ']'
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
			// InternalCommon.g:4616:21: ( ')' )
			// InternalCommon.g:4616:23: ')'
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
			// InternalCommon.g:4618:21: ( RULE_SKW_GREATER RULE_SKW_GREATER )
			// InternalCommon.g:4618:23: RULE_SKW_GREATER RULE_SKW_GREATER
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
			// InternalCommon.g:4620:15: ( ';' )
			// InternalCommon.g:4620:17: ';'
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
			// InternalCommon.g:4622:22: ( '\\'' )
			// InternalCommon.g:4622:24: '\\''
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
			// InternalCommon.g:4624:15: ( '*' )
			// InternalCommon.g:4624:17: '*'
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
			// InternalCommon.g:4626:16: ( '~' )
			// InternalCommon.g:4626:18: '~'
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
			// InternalCommon.g:4628:30: ( '_' )
			// InternalCommon.g:4628:32: '_'
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
			// InternalCommon.g:4630:9: ( RULE_IDENTIFIER )
			// InternalCommon.g:4630:11: RULE_IDENTIFIER
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
			// InternalCommon.g:4632:26: ( RULE_LETTER ( RULE_LETTER | '0' .. '9' )* )
			// InternalCommon.g:4632:28: RULE_LETTER ( RULE_LETTER | '0' .. '9' )*
			{
			mRULE_LETTER(); 

			// InternalCommon.g:4632:40: ( RULE_LETTER | '0' .. '9' )*
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
			// InternalCommon.g:4634:22: ( ( RULE_SKW_DOLLAR | 'A' .. 'Z' | 'a' .. 'z' | RULE_SKW_UNDERSCORE ) )
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
			// InternalCommon.g:4636:19: ( ( 'L' )? RULE_SKW_SINGLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) | RULE_LINEBREAK ) RULE_SKW_SINGLEQUOTE )
			// InternalCommon.g:4636:21: ( 'L' )? RULE_SKW_SINGLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) | RULE_LINEBREAK ) RULE_SKW_SINGLEQUOTE
			{
			// InternalCommon.g:4636:21: ( 'L' )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='L') ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// InternalCommon.g:4636:21: 'L'
					{
					match('L'); 
					}
					break;

			}

			mRULE_SKW_SINGLEQUOTE(); 

			// InternalCommon.g:4636:47: ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) | RULE_LINEBREAK )
			int alt3=3;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='\\') ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1=='\"'||LA3_1=='\''||(LA3_1 >= '0' && LA3_1 <= '7')||LA3_1=='\\'||LA3_1=='b'||LA3_1=='f'||LA3_1=='n'||LA3_1=='r'||LA3_1=='t'||LA3_1=='x') ) {
					alt3=1;
				}
				else if ( (LA3_1=='\n'||LA3_1=='\r') ) {
					alt3=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( ((LA3_0 >= '\u0000' && LA3_0 <= '&')||(LA3_0 >= '(' && LA3_0 <= '[')||(LA3_0 >= ']' && LA3_0 <= '\uFFFF')) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// InternalCommon.g:4636:48: RULE_ESCAPE_SEQUENCE
					{
					mRULE_ESCAPE_SEQUENCE(); 

					}
					break;
				case 2 :
					// InternalCommon.g:4636:69: ~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) )
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
				case 3 :
					// InternalCommon.g:4636:114: RULE_LINEBREAK
					{
					mRULE_LINEBREAK(); 

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
			// InternalCommon.g:4638:21: ( RULE_SKW_DOUBLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) | RULE_LINEBREAK )* RULE_SKW_DOUBLEQUOTE )
			// InternalCommon.g:4638:23: RULE_SKW_DOUBLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) | RULE_LINEBREAK )* RULE_SKW_DOUBLEQUOTE
			{
			mRULE_SKW_DOUBLEQUOTE(); 

			// InternalCommon.g:4638:44: ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) | RULE_LINEBREAK )*
			loop4:
			while (true) {
				int alt4=4;
				int LA4_0 = input.LA(1);
				if ( (LA4_0=='\\') ) {
					int LA4_2 = input.LA(2);
					if ( (LA4_2=='\"'||LA4_2=='\''||(LA4_2 >= '0' && LA4_2 <= '7')||LA4_2=='\\'||LA4_2=='b'||LA4_2=='f'||LA4_2=='n'||LA4_2=='r'||LA4_2=='t'||LA4_2=='x') ) {
						alt4=1;
					}
					else if ( (LA4_2=='\n'||LA4_2=='\r') ) {
						alt4=3;
					}

				}
				else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '!')||(LA4_0 >= '#' && LA4_0 <= '[')||(LA4_0 >= ']' && LA4_0 <= '\uFFFF')) ) {
					alt4=2;
				}

				switch (alt4) {
				case 1 :
					// InternalCommon.g:4638:45: RULE_ESCAPE_SEQUENCE
					{
					mRULE_ESCAPE_SEQUENCE(); 

					}
					break;
				case 2 :
					// InternalCommon.g:4638:66: ~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) )
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
				case 3 :
					// InternalCommon.g:4638:111: RULE_LINEBREAK
					{
					mRULE_LINEBREAK(); 

					}
					break;

				default :
					break loop4;
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
			// InternalCommon.g:4640:18: ( RULE_HEX_PREFIX ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )? )
			// InternalCommon.g:4640:20: RULE_HEX_PREFIX ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )?
			{
			mRULE_HEX_PREFIX(); 

			// InternalCommon.g:4640:36: ( RULE_HEX_DIGIT )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'F')||(LA5_0 >= 'a' && LA5_0 <= 'f')) ) {
					alt5=1;
				}

				switch (alt5) {
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
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			// InternalCommon.g:4640:52: ( RULE_INTEGER_TYPE_SUFFIX )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0=='L'||LA6_0=='U'||LA6_0=='l'||LA6_0=='u') ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// InternalCommon.g:4640:52: RULE_INTEGER_TYPE_SUFFIX
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

	// $ANTLR start "RULE_HEX_PREFIX"
	public final void mRULE_HEX_PREFIX() throws RecognitionException {
		try {
			// InternalCommon.g:4642:26: ( '0' ( 'x' | 'X' ) )
			// InternalCommon.g:4642:28: '0' ( 'x' | 'X' )
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
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_HEX_PREFIX"

	// $ANTLR start "RULE_DECIMAL_LITERAL"
	public final void mRULE_DECIMAL_LITERAL() throws RecognitionException {
		try {
			int _type = RULE_DECIMAL_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:4644:22: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( RULE_INTEGER_TYPE_SUFFIX )? )
			// InternalCommon.g:4644:24: ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( RULE_INTEGER_TYPE_SUFFIX )?
			{
			// InternalCommon.g:4644:24: ( '0' | '1' .. '9' ( '0' .. '9' )* )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0=='0') ) {
				alt8=1;
			}
			else if ( ((LA8_0 >= '1' && LA8_0 <= '9')) ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// InternalCommon.g:4644:25: '0'
					{
					match('0'); 
					}
					break;
				case 2 :
					// InternalCommon.g:4644:29: '1' .. '9' ( '0' .. '9' )*
					{
					matchRange('1','9'); 
					// InternalCommon.g:4644:38: ( '0' .. '9' )*
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
							alt7=1;
						}

						switch (alt7) {
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
							break loop7;
						}
					}

					}
					break;

			}

			// InternalCommon.g:4644:51: ( RULE_INTEGER_TYPE_SUFFIX )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0=='L'||LA9_0=='U'||LA9_0=='l'||LA9_0=='u') ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// InternalCommon.g:4644:51: RULE_INTEGER_TYPE_SUFFIX
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
			// InternalCommon.g:4646:20: ( '0' ( '0' .. '7' )+ ( RULE_INTEGER_TYPE_SUFFIX )? )
			// InternalCommon.g:4646:22: '0' ( '0' .. '7' )+ ( RULE_INTEGER_TYPE_SUFFIX )?
			{
			match('0'); 
			// InternalCommon.g:4646:26: ( '0' .. '7' )+
			int cnt10=0;
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= '0' && LA10_0 <= '7')) ) {
					alt10=1;
				}

				switch (alt10) {
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
					if ( cnt10 >= 1 ) break loop10;
					EarlyExitException eee = new EarlyExitException(10, input);
					throw eee;
				}
				cnt10++;
			}

			// InternalCommon.g:4646:38: ( RULE_INTEGER_TYPE_SUFFIX )?
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0=='L'||LA11_0=='U'||LA11_0=='l'||LA11_0=='u') ) {
				alt11=1;
			}
			switch (alt11) {
				case 1 :
					// InternalCommon.g:4646:38: RULE_INTEGER_TYPE_SUFFIX
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
			// InternalCommon.g:4648:18: ( ( '0b' | '0B' ) ( '0' .. '1' )+ )
			// InternalCommon.g:4648:20: ( '0b' | '0B' ) ( '0' .. '1' )+
			{
			// InternalCommon.g:4648:20: ( '0b' | '0B' )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0=='0') ) {
				int LA12_1 = input.LA(2);
				if ( (LA12_1=='b') ) {
					alt12=1;
				}
				else if ( (LA12_1=='B') ) {
					alt12=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 12, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// InternalCommon.g:4648:21: '0b'
					{
					match("0b"); 

					}
					break;
				case 2 :
					// InternalCommon.g:4648:26: '0B'
					{
					match("0B"); 

					}
					break;

			}

			// InternalCommon.g:4648:32: ( '0' .. '1' )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( ((LA13_0 >= '0' && LA13_0 <= '1')) ) {
					alt13=1;
				}

				switch (alt13) {
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
					if ( cnt13 >= 1 ) break loop13;
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
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
			// InternalCommon.g:4650:25: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
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
			// InternalCommon.g:4652:35: ( ( RULE_UNSIGNED_SUFFIX ( RULE_LONG_SUFFIX )? | RULE_UNSIGNED_SUFFIX RULE_LONG_LONG_SUFFIX | RULE_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )? | RULE_LONG_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )? ) )
			// InternalCommon.g:4652:37: ( RULE_UNSIGNED_SUFFIX ( RULE_LONG_SUFFIX )? | RULE_UNSIGNED_SUFFIX RULE_LONG_LONG_SUFFIX | RULE_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )? | RULE_LONG_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )? )
			{
			// InternalCommon.g:4652:37: ( RULE_UNSIGNED_SUFFIX ( RULE_LONG_SUFFIX )? | RULE_UNSIGNED_SUFFIX RULE_LONG_LONG_SUFFIX | RULE_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )? | RULE_LONG_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )? )
			int alt17=4;
			switch ( input.LA(1) ) {
			case 'U':
			case 'u':
				{
				switch ( input.LA(2) ) {
				case 'l':
					{
					int LA17_5 = input.LA(3);
					if ( (LA17_5=='l') ) {
						alt17=2;
					}

					else {
						alt17=1;
					}

					}
					break;
				case 'L':
					{
					int LA17_6 = input.LA(3);
					if ( (LA17_6=='L') ) {
						alt17=2;
					}

					else {
						alt17=1;
					}

					}
					break;
				default:
					alt17=1;
				}
				}
				break;
			case 'l':
				{
				int LA17_2 = input.LA(2);
				if ( (LA17_2=='l') ) {
					alt17=4;
				}

				else {
					alt17=3;
				}

				}
				break;
			case 'L':
				{
				int LA17_3 = input.LA(2);
				if ( (LA17_3=='L') ) {
					alt17=4;
				}

				else {
					alt17=3;
				}

				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}
			switch (alt17) {
				case 1 :
					// InternalCommon.g:4652:38: RULE_UNSIGNED_SUFFIX ( RULE_LONG_SUFFIX )?
					{
					mRULE_UNSIGNED_SUFFIX(); 

					// InternalCommon.g:4652:59: ( RULE_LONG_SUFFIX )?
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
				case 2 :
					// InternalCommon.g:4652:77: RULE_UNSIGNED_SUFFIX RULE_LONG_LONG_SUFFIX
					{
					mRULE_UNSIGNED_SUFFIX(); 

					mRULE_LONG_LONG_SUFFIX(); 

					}
					break;
				case 3 :
					// InternalCommon.g:4652:120: RULE_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )?
					{
					mRULE_LONG_SUFFIX(); 

					// InternalCommon.g:4652:137: ( RULE_UNSIGNED_SUFFIX )?
					int alt15=2;
					int LA15_0 = input.LA(1);
					if ( (LA15_0=='U'||LA15_0=='u') ) {
						alt15=1;
					}
					switch (alt15) {
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

					}
					break;
				case 4 :
					// InternalCommon.g:4652:159: RULE_LONG_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )?
					{
					mRULE_LONG_LONG_SUFFIX(); 

					// InternalCommon.g:4652:181: ( RULE_UNSIGNED_SUFFIX )?
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0=='U'||LA16_0=='u') ) {
						alt16=1;
					}
					switch (alt16) {
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

	// $ANTLR start "RULE_UNSIGNED_SUFFIX"
	public final void mRULE_UNSIGNED_SUFFIX() throws RecognitionException {
		try {
			// InternalCommon.g:4654:31: ( ( 'u' | 'U' ) )
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

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_UNSIGNED_SUFFIX"

	// $ANTLR start "RULE_LONG_SUFFIX"
	public final void mRULE_LONG_SUFFIX() throws RecognitionException {
		try {
			// InternalCommon.g:4656:27: ( ( 'l' | 'L' ) )
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

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_LONG_SUFFIX"

	// $ANTLR start "RULE_LONG_LONG_SUFFIX"
	public final void mRULE_LONG_LONG_SUFFIX() throws RecognitionException {
		try {
			// InternalCommon.g:4658:32: ( ( 'll' | 'LL' ) )
			// InternalCommon.g:4658:34: ( 'll' | 'LL' )
			{
			// InternalCommon.g:4658:34: ( 'll' | 'LL' )
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0=='l') ) {
				alt18=1;
			}
			else if ( (LA18_0=='L') ) {
				alt18=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// InternalCommon.g:4658:35: 'll'
					{
					match("ll"); 

					}
					break;
				case 2 :
					// InternalCommon.g:4658:40: 'LL'
					{
					match("LL"); 

					}
					break;

			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_LONG_LONG_SUFFIX"

	// $ANTLR start "RULE_FLOAT_LITERAL"
	public final void mRULE_FLOAT_LITERAL() throws RecognitionException {
		try {
			int _type = RULE_FLOAT_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:4660:20: ( ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX ) )
			// InternalCommon.g:4660:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )
			{
			// InternalCommon.g:4660:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )
			int alt30=4;
			alt30 = dfa30.predict(input);
			switch (alt30) {
				case 1 :
					// InternalCommon.g:4660:23: ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )?
					{
					// InternalCommon.g:4660:23: ( '0' .. '9' )+
					int cnt19=0;
					loop19:
					while (true) {
						int alt19=2;
						int LA19_0 = input.LA(1);
						if ( ((LA19_0 >= '0' && LA19_0 <= '9')) ) {
							alt19=1;
						}

						switch (alt19) {
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
							if ( cnt19 >= 1 ) break loop19;
							EarlyExitException eee = new EarlyExitException(19, input);
							throw eee;
						}
						cnt19++;
					}

					mRULE_SKW_DOT(); 

					// InternalCommon.g:4660:48: ( '0' .. '9' )*
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
							break loop20;
						}
					}

					// InternalCommon.g:4660:60: ( RULE_EXPONENT )?
					int alt21=2;
					int LA21_0 = input.LA(1);
					if ( (LA21_0=='E'||LA21_0=='e') ) {
						alt21=1;
					}
					switch (alt21) {
						case 1 :
							// InternalCommon.g:4660:60: RULE_EXPONENT
							{
							mRULE_EXPONENT(); 

							}
							break;

					}

					// InternalCommon.g:4660:75: ( RULE_FLOAT_TYPE_SUFFIX )?
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
				case 2 :
					// InternalCommon.g:4660:99: RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )?
					{
					mRULE_SKW_DOT(); 

					// InternalCommon.g:4660:112: ( '0' .. '9' )+
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

					// InternalCommon.g:4660:124: ( RULE_EXPONENT )?
					int alt24=2;
					int LA24_0 = input.LA(1);
					if ( (LA24_0=='E'||LA24_0=='e') ) {
						alt24=1;
					}
					switch (alt24) {
						case 1 :
							// InternalCommon.g:4660:124: RULE_EXPONENT
							{
							mRULE_EXPONENT(); 

							}
							break;

					}

					// InternalCommon.g:4660:139: ( RULE_FLOAT_TYPE_SUFFIX )?
					int alt25=2;
					int LA25_0 = input.LA(1);
					if ( (LA25_0=='D'||LA25_0=='F'||LA25_0=='d'||LA25_0=='f') ) {
						alt25=1;
					}
					switch (alt25) {
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
					// InternalCommon.g:4660:163: ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )?
					{
					// InternalCommon.g:4660:163: ( '0' .. '9' )+
					int cnt26=0;
					loop26:
					while (true) {
						int alt26=2;
						int LA26_0 = input.LA(1);
						if ( ((LA26_0 >= '0' && LA26_0 <= '9')) ) {
							alt26=1;
						}

						switch (alt26) {
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
							if ( cnt26 >= 1 ) break loop26;
							EarlyExitException eee = new EarlyExitException(26, input);
							throw eee;
						}
						cnt26++;
					}

					mRULE_EXPONENT(); 

					// InternalCommon.g:4660:189: ( RULE_FLOAT_TYPE_SUFFIX )?
					int alt27=2;
					int LA27_0 = input.LA(1);
					if ( (LA27_0=='D'||LA27_0=='F'||LA27_0=='d'||LA27_0=='f') ) {
						alt27=1;
					}
					switch (alt27) {
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
					// InternalCommon.g:4660:213: ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX
					{
					// InternalCommon.g:4660:213: ( '0' .. '9' )+
					int cnt28=0;
					loop28:
					while (true) {
						int alt28=2;
						int LA28_0 = input.LA(1);
						if ( ((LA28_0 >= '0' && LA28_0 <= '9')) ) {
							alt28=1;
						}

						switch (alt28) {
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
							if ( cnt28 >= 1 ) break loop28;
							EarlyExitException eee = new EarlyExitException(28, input);
							throw eee;
						}
						cnt28++;
					}

					// InternalCommon.g:4660:225: ( RULE_EXPONENT )?
					int alt29=2;
					int LA29_0 = input.LA(1);
					if ( (LA29_0=='E'||LA29_0=='e') ) {
						alt29=1;
					}
					switch (alt29) {
						case 1 :
							// InternalCommon.g:4660:225: RULE_EXPONENT
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
			// InternalCommon.g:4662:24: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
			// InternalCommon.g:4662:26: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// InternalCommon.g:4662:36: ( '+' | '-' )?
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0=='+'||LA31_0=='-') ) {
				alt31=1;
			}
			switch (alt31) {
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

			// InternalCommon.g:4662:47: ( '0' .. '9' )+
			int cnt32=0;
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( ((LA32_0 >= '0' && LA32_0 <= '9')) ) {
					alt32=1;
				}

				switch (alt32) {
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
					if ( cnt32 >= 1 ) break loop32;
					EarlyExitException eee = new EarlyExitException(32, input);
					throw eee;
				}
				cnt32++;
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
			// InternalCommon.g:4664:33: ( ( 'f' | 'F' | 'd' | 'D' ) )
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
			// InternalCommon.g:4666:31: ( ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE | RULE_HEX_ESCAPE ) )
			// InternalCommon.g:4666:33: ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE | RULE_HEX_ESCAPE )
			{
			// InternalCommon.g:4666:33: ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE | RULE_HEX_ESCAPE )
			int alt33=3;
			int LA33_0 = input.LA(1);
			if ( (LA33_0=='\\') ) {
				switch ( input.LA(2) ) {
				case '\"':
				case '\'':
				case '\\':
				case 'b':
				case 'f':
				case 'n':
				case 'r':
				case 't':
					{
					alt33=1;
					}
					break;
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
					{
					alt33=2;
					}
					break;
				case 'x':
					{
					alt33=3;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 33, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 33, 0, input);
				throw nvae;
			}

			switch (alt33) {
				case 1 :
					// InternalCommon.g:4666:34: RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH )
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
					// InternalCommon.g:4666:119: RULE_OCTAL_ESCAPE
					{
					mRULE_OCTAL_ESCAPE(); 

					}
					break;
				case 3 :
					// InternalCommon.g:4666:137: RULE_HEX_ESCAPE
					{
					mRULE_HEX_ESCAPE(); 

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
			// InternalCommon.g:4668:28: ( ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' ) )
			// InternalCommon.g:4668:30: ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' )
			{
			// InternalCommon.g:4668:30: ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' )
			int alt34=3;
			int LA34_0 = input.LA(1);
			if ( (LA34_0=='\\') ) {
				int LA34_1 = input.LA(2);
				if ( ((LA34_1 >= '0' && LA34_1 <= '3')) ) {
					int LA34_2 = input.LA(3);
					if ( ((LA34_2 >= '0' && LA34_2 <= '7')) ) {
						int LA34_4 = input.LA(4);
						if ( ((LA34_4 >= '0' && LA34_4 <= '7')) ) {
							alt34=1;
						}

						else {
							alt34=2;
						}

					}

					else {
						alt34=3;
					}

				}
				else if ( ((LA34_1 >= '4' && LA34_1 <= '7')) ) {
					int LA34_3 = input.LA(3);
					if ( ((LA34_3 >= '0' && LA34_3 <= '7')) ) {
						alt34=2;
					}

					else {
						alt34=3;
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 34, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 34, 0, input);
				throw nvae;
			}

			switch (alt34) {
				case 1 :
					// InternalCommon.g:4668:31: RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7'
					{
					mRULE_SKW_BACKSLASH(); 

					matchRange('0','3'); 
					matchRange('0','7'); 
					matchRange('0','7'); 
					}
					break;
				case 2 :
					// InternalCommon.g:4668:77: RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7'
					{
					mRULE_SKW_BACKSLASH(); 

					matchRange('0','7'); 
					matchRange('0','7'); 
					}
					break;
				case 3 :
					// InternalCommon.g:4668:114: RULE_SKW_BACKSLASH '0' .. '7'
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

	// $ANTLR start "RULE_HEX_ESCAPE"
	public final void mRULE_HEX_ESCAPE() throws RecognitionException {
		try {
			// InternalCommon.g:4670:26: ( RULE_SKW_BACKSLASH 'x' ( RULE_HEX_DIGIT )+ )
			// InternalCommon.g:4670:28: RULE_SKW_BACKSLASH 'x' ( RULE_HEX_DIGIT )+
			{
			mRULE_SKW_BACKSLASH(); 

			match('x'); 
			// InternalCommon.g:4670:51: ( RULE_HEX_DIGIT )+
			int cnt35=0;
			loop35:
			while (true) {
				int alt35=2;
				int LA35_0 = input.LA(1);
				if ( ((LA35_0 >= '0' && LA35_0 <= '9')||(LA35_0 >= 'A' && LA35_0 <= 'F')||(LA35_0 >= 'a' && LA35_0 <= 'f')) ) {
					alt35=1;
				}

				switch (alt35) {
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
					if ( cnt35 >= 1 ) break loop35;
					EarlyExitException eee = new EarlyExitException(35, input);
					throw eee;
				}
				cnt35++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_HEX_ESCAPE"

	// $ANTLR start "RULE_LINEFEED"
	public final void mRULE_LINEFEED() throws RecognitionException {
		try {
			// InternalCommon.g:4672:24: ( '\\n' )
			// InternalCommon.g:4672:26: '\\n'
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
			// InternalCommon.g:4674:30: ( '\\r' )
			// InternalCommon.g:4674:32: '\\r'
			{
			match('\r'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_CARRIAGERETURN"

	// $ANTLR start "RULE_LINE_END"
	public final void mRULE_LINE_END() throws RecognitionException {
		try {
			// InternalCommon.g:4676:24: ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) )
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
	// $ANTLR end "RULE_LINE_END"

	// $ANTLR start "RULE_LINEBREAK"
	public final void mRULE_LINEBREAK() throws RecognitionException {
		try {
			// InternalCommon.g:4678:25: ( RULE_SKW_BACKSLASH RULE_LINE_END )
			// InternalCommon.g:4678:27: RULE_SKW_BACKSLASH RULE_LINE_END
			{
			mRULE_SKW_BACKSLASH(); 

			mRULE_LINE_END(); 

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_LINEBREAK"

	// $ANTLR start "RULE_NEWLINE"
	public final void mRULE_NEWLINE() throws RecognitionException {
		try {
			int _type = RULE_NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:4680:14: ( RULE_LINE_END )
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

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_NEWLINE"

	// $ANTLR start "RULE_SPACE"
	public final void mRULE_SPACE() throws RecognitionException {
		try {
			// InternalCommon.g:4682:21: ( ' ' )
			// InternalCommon.g:4682:23: ' '
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
			// InternalCommon.g:4684:19: ( '\\t' )
			// InternalCommon.g:4684:21: '\\t'
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
			// InternalCommon.g:4686:17: ( ( RULE_SPACE | RULE_TAB ) )
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
			// InternalCommon.g:4688:29: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// InternalCommon.g:4688:31: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// InternalCommon.g:4688:36: ( options {greedy=false; } : . )*
			loop36:
			while (true) {
				int alt36=2;
				int LA36_0 = input.LA(1);
				if ( (LA36_0=='*') ) {
					int LA36_1 = input.LA(2);
					if ( (LA36_1=='/') ) {
						alt36=2;
					}
					else if ( ((LA36_1 >= '\u0000' && LA36_1 <= '.')||(LA36_1 >= '0' && LA36_1 <= '\uFFFF')) ) {
						alt36=1;
					}

				}
				else if ( ((LA36_0 >= '\u0000' && LA36_0 <= ')')||(LA36_0 >= '+' && LA36_0 <= '\uFFFF')) ) {
					alt36=1;
				}

				switch (alt36) {
				case 1 :
					// InternalCommon.g:4688:64: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop36;
				}
			}

			match("*/"); 

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_BLOCK_COMMENT"

	// $ANTLR start "RULE_LINE_COMMENT"
	public final void mRULE_LINE_COMMENT() throws RecognitionException {
		try {
			// InternalCommon.g:4690:28: ( '//' (~ ( RULE_LINE_END ) )* )
			// InternalCommon.g:4690:30: '//' (~ ( RULE_LINE_END ) )*
			{
			match("//"); 

			// InternalCommon.g:4690:35: (~ ( RULE_LINE_END ) )*
			loop37:
			while (true) {
				int alt37=2;
				int LA37_0 = input.LA(1);
				if ( ((LA37_0 >= '\u0000' && LA37_0 <= '\t')||(LA37_0 >= '\u000B' && LA37_0 <= '\f')||(LA37_0 >= '\u000E' && LA37_0 <= '\uFFFF')) ) {
					alt37=1;
				}

				switch (alt37) {
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
					break loop37;
				}
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_LINE_COMMENT"

	// $ANTLR start "RULE_FORM_FEED"
	public final void mRULE_FORM_FEED() throws RecognitionException {
		try {
			// InternalCommon.g:4692:25: ( '\\f' )
			// InternalCommon.g:4692:27: '\\f'
			{
			match('\f'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_FORM_FEED"

	// $ANTLR start "RULE_IGNORED"
	public final void mRULE_IGNORED() throws RecognitionException {
		try {
			int _type = RULE_IGNORED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:4694:14: ( ( RULE_LINEBREAK | RULE_BLOCK_COMMENT | RULE_LINE_COMMENT | RULE_FORM_FEED ) )
			// InternalCommon.g:4694:16: ( RULE_LINEBREAK | RULE_BLOCK_COMMENT | RULE_LINE_COMMENT | RULE_FORM_FEED )
			{
			// InternalCommon.g:4694:16: ( RULE_LINEBREAK | RULE_BLOCK_COMMENT | RULE_LINE_COMMENT | RULE_FORM_FEED )
			int alt38=4;
			switch ( input.LA(1) ) {
			case '\\':
				{
				alt38=1;
				}
				break;
			case '/':
				{
				int LA38_2 = input.LA(2);
				if ( (LA38_2=='*') ) {
					alt38=2;
				}
				else if ( (LA38_2=='/') ) {
					alt38=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 38, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case '\f':
				{
				alt38=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 38, 0, input);
				throw nvae;
			}
			switch (alt38) {
				case 1 :
					// InternalCommon.g:4694:17: RULE_LINEBREAK
					{
					mRULE_LINEBREAK(); 

					}
					break;
				case 2 :
					// InternalCommon.g:4694:32: RULE_BLOCK_COMMENT
					{
					mRULE_BLOCK_COMMENT(); 

					}
					break;
				case 3 :
					// InternalCommon.g:4694:51: RULE_LINE_COMMENT
					{
					mRULE_LINE_COMMENT(); 

					}
					break;
				case 4 :
					// InternalCommon.g:4694:69: RULE_FORM_FEED
					{
					mRULE_FORM_FEED(); 

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
	// $ANTLR end "RULE_IGNORED"

	// $ANTLR start "RULE_SPECIAL"
	public final void mRULE_SPECIAL() throws RecognitionException {
		try {
			int _type = RULE_SPECIAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCommon.g:4696:14: ( . )
			// InternalCommon.g:4696:16: .
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
		// InternalCommon.g:1:8: ( RULE_SKW_AND | RULE_SKW_ANDAND | RULE_SKW_ASSIGN | RULE_SKW_BACKSLASH | RULE_SKW_CARET | RULE_SKW_COMMA | RULE_SKW_COLON | RULE_SKW_DIV | RULE_SKW_DOT | RULE_SKW_DOUBLEQUOTE | RULE_SKW_EQUAL | RULE_SKW_GREATER | RULE_SKW_GREATEREQUAL | RULE_SKW_LEFTBRACE | RULE_SKW_LEFTBRACKET | RULE_SKW_LEFTPAREN | RULE_SKW_LEFTSHIFT | RULE_SKW_LESS | RULE_SKW_LESSEQUAL | RULE_SKW_MINUS | RULE_SKW_MINUSMINUS | RULE_SKW_MOD | RULE_SKW_NOT | RULE_SKW_NOTEQUAL | RULE_SKW_OR | RULE_SKW_OROR | RULE_SKW_PLUS | RULE_SKW_PLUSPLUS | RULE_SKW_QUESTION | RULE_SKW_RIGHTBRACE | RULE_SKW_RIGHTBRACKET | RULE_SKW_RIGHTPAREN | RULE_SKW_RIGHTSHIFT | RULE_SKW_SEMI | RULE_SKW_SINGLEQUOTE | RULE_SKW_STAR | RULE_SKW_TILDE | RULE_ID | RULE_CHAR_LITERAL | RULE_STRING_LITERAL | RULE_HEX_LITERAL | RULE_DECIMAL_LITERAL | RULE_OCTAL_LITERAL | RULE_BIN_LITERAL | RULE_FLOAT_LITERAL | RULE_NEWLINE | RULE_WHITESPACE | RULE_IGNORED | RULE_SPECIAL )
		int alt39=49;
		alt39 = dfa39.predict(input);
		switch (alt39) {
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
				// InternalCommon.g:1:771: RULE_NEWLINE
				{
				mRULE_NEWLINE(); 

				}
				break;
			case 47 :
				// InternalCommon.g:1:784: RULE_WHITESPACE
				{
				mRULE_WHITESPACE(); 

				}
				break;
			case 48 :
				// InternalCommon.g:1:800: RULE_IGNORED
				{
				mRULE_IGNORED(); 

				}
				break;
			case 49 :
				// InternalCommon.g:1:813: RULE_SPECIAL
				{
				mRULE_SPECIAL(); 

				}
				break;

		}
	}


	protected DFA30 dfa30 = new DFA30(this);
	protected DFA39 dfa39 = new DFA39(this);
	static final String DFA30_eotS =
		"\7\uffff\1\10\2\uffff";
	static final String DFA30_eofS =
		"\12\uffff";
	static final String DFA30_minS =
		"\2\56\2\uffff\1\53\1\uffff\2\60\2\uffff";
	static final String DFA30_maxS =
		"\1\71\1\146\2\uffff\1\71\1\uffff\1\71\1\146\2\uffff";
	static final String DFA30_acceptS =
		"\2\uffff\1\2\1\1\1\uffff\1\4\2\uffff\2\3";
	static final String DFA30_specialS =
		"\12\uffff}>";
	static final String[] DFA30_transitionS = {
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

	static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
	static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
	static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
	static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
	static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
	static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
	static final short[][] DFA30_transition;

	static {
		int numStates = DFA30_transitionS.length;
		DFA30_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
		}
	}

	protected class DFA30 extends DFA {

		public DFA30(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 30;
			this.eot = DFA30_eot;
			this.eof = DFA30_eof;
			this.min = DFA30_min;
			this.max = DFA30_max;
			this.accept = DFA30_accept;
			this.special = DFA30_special;
			this.transition = DFA30_transition;
		}
		@Override
		public String getDescription() {
			return "4660:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )";
		}
	}

	static final String DFA39_eotS =
		"\1\uffff\1\44\1\46\1\50\3\uffff\1\55\1\56\1\60\1\62\3\uffff\1\70\1\73\1\uffff\1\76\1\100\1\102\5\uffff\1\111\2\uffff\1\115\1\uffff\2\120\61\uffff\1\125\1\120\3\uffff";
	static final String DFA39_eofS =
		"\126\uffff";
	static final String DFA39_minS =
		"\1\0\1\46\1\75\1\12\3\uffff\1\52\1\60\1\0\1\75\3\uffff\1\74\1\55\1\uffff\1\75\1\174\1\53\5\uffff\1\0\2\uffff\1\47\1\uffff\2\56\61\uffff\2\56\3\uffff";
	static final String DFA39_maxS =
		"\1\uffff\1\46\1\75\1\15\3\uffff\1\57\1\71\1\uffff\1\76\3\uffff\1\75\1\55\1\uffff\1\75\1\174\1\53\5\uffff\1\uffff\2\uffff\1\47\1\uffff\1\170\1\146\61\uffff\2\146\3\uffff";
	static final String DFA39_acceptS =
		"\4\uffff\1\5\1\6\1\7\4\uffff\1\16\1\17\1\20\2\uffff\1\26\3\uffff\1\35\1\36\1\37\1\40\1\42\1\uffff\1\44\1\45\1\uffff\1\46\2\uffff\1\56\1\57\1\60\1\61\1\1\1\2\1\3\1\13\1\4\1\60\1\5\1\6\1\7\1\10\1\11\1\55\1\12\1\50\1\14\1\15\1\41\1\16\1\17\1\20\1\22\1\21\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\42\1\43\1\47\1\44\1\45\1\46\1\51\1\54\1\52\2\uffff\1\56\1\57\1\53";
	static final String DFA39_specialS =
		"\1\0\10\uffff\1\1\17\uffff\1\2\74\uffff}>";
	static final String[] DFA39_transitionS = {
			"\11\43\1\41\1\40\1\43\1\42\1\40\22\43\1\41\1\21\1\11\1\43\1\35\1\20\1\1\1\31\1\15\1\27\1\32\1\23\1\5\1\17\1\10\1\7\1\36\11\37\1\6\1\30\1\16\1\2\1\12\1\24\1\43\13\35\1\34\16\35\1\14\1\3\1\26\1\4\1\35\1\43\32\35\1\13\1\22\1\25\1\33\uff81\43",
			"\1\45",
			"\1\47",
			"\1\51\2\uffff\1\51",
			"",
			"",
			"",
			"\1\51\4\uffff\1\51",
			"\12\57",
			"\0\61",
			"\1\63\1\64",
			"",
			"",
			"",
			"\1\71\1\72",
			"\1\74",
			"",
			"\1\77",
			"\1\101",
			"\1\103",
			"",
			"",
			"",
			"",
			"",
			"\47\112\1\uffff\uffd8\112",
			"",
			"",
			"\1\112",
			"",
			"\1\57\1\uffff\10\121\2\57\10\uffff\1\117\1\uffff\3\57\21\uffff\1\116\11\uffff\1\117\1\uffff\3\57\21\uffff\1\116",
			"\1\57\1\uffff\12\122\12\uffff\3\57\35\uffff\3\57",
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
			"\1\57\1\uffff\10\121\2\57\12\uffff\3\57\35\uffff\3\57",
			"\1\57\1\uffff\12\122\12\uffff\3\57\35\uffff\3\57",
			"",
			"",
			""
	};

	static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
	static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
	static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
	static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
	static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
	static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
	static final short[][] DFA39_transition;

	static {
		int numStates = DFA39_transitionS.length;
		DFA39_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
		}
	}

	protected class DFA39 extends DFA {

		public DFA39(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 39;
			this.eot = DFA39_eot;
			this.eof = DFA39_eof;
			this.min = DFA39_min;
			this.max = DFA39_max;
			this.accept = DFA39_accept;
			this.special = DFA39_special;
			this.transition = DFA39_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( RULE_SKW_AND | RULE_SKW_ANDAND | RULE_SKW_ASSIGN | RULE_SKW_BACKSLASH | RULE_SKW_CARET | RULE_SKW_COMMA | RULE_SKW_COLON | RULE_SKW_DIV | RULE_SKW_DOT | RULE_SKW_DOUBLEQUOTE | RULE_SKW_EQUAL | RULE_SKW_GREATER | RULE_SKW_GREATEREQUAL | RULE_SKW_LEFTBRACE | RULE_SKW_LEFTBRACKET | RULE_SKW_LEFTPAREN | RULE_SKW_LEFTSHIFT | RULE_SKW_LESS | RULE_SKW_LESSEQUAL | RULE_SKW_MINUS | RULE_SKW_MINUSMINUS | RULE_SKW_MOD | RULE_SKW_NOT | RULE_SKW_NOTEQUAL | RULE_SKW_OR | RULE_SKW_OROR | RULE_SKW_PLUS | RULE_SKW_PLUSPLUS | RULE_SKW_QUESTION | RULE_SKW_RIGHTBRACE | RULE_SKW_RIGHTBRACKET | RULE_SKW_RIGHTPAREN | RULE_SKW_RIGHTSHIFT | RULE_SKW_SEMI | RULE_SKW_SINGLEQUOTE | RULE_SKW_STAR | RULE_SKW_TILDE | RULE_ID | RULE_CHAR_LITERAL | RULE_STRING_LITERAL | RULE_HEX_LITERAL | RULE_DECIMAL_LITERAL | RULE_OCTAL_LITERAL | RULE_BIN_LITERAL | RULE_FLOAT_LITERAL | RULE_NEWLINE | RULE_WHITESPACE | RULE_IGNORED | RULE_SPECIAL );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA39_0 = input.LA(1);
						s = -1;
						if ( (LA39_0=='&') ) {s = 1;}
						else if ( (LA39_0=='=') ) {s = 2;}
						else if ( (LA39_0=='\\') ) {s = 3;}
						else if ( (LA39_0=='^') ) {s = 4;}
						else if ( (LA39_0==',') ) {s = 5;}
						else if ( (LA39_0==':') ) {s = 6;}
						else if ( (LA39_0=='/') ) {s = 7;}
						else if ( (LA39_0=='.') ) {s = 8;}
						else if ( (LA39_0=='\"') ) {s = 9;}
						else if ( (LA39_0=='>') ) {s = 10;}
						else if ( (LA39_0=='{') ) {s = 11;}
						else if ( (LA39_0=='[') ) {s = 12;}
						else if ( (LA39_0=='(') ) {s = 13;}
						else if ( (LA39_0=='<') ) {s = 14;}
						else if ( (LA39_0=='-') ) {s = 15;}
						else if ( (LA39_0=='%') ) {s = 16;}
						else if ( (LA39_0=='!') ) {s = 17;}
						else if ( (LA39_0=='|') ) {s = 18;}
						else if ( (LA39_0=='+') ) {s = 19;}
						else if ( (LA39_0=='?') ) {s = 20;}
						else if ( (LA39_0=='}') ) {s = 21;}
						else if ( (LA39_0==']') ) {s = 22;}
						else if ( (LA39_0==')') ) {s = 23;}
						else if ( (LA39_0==';') ) {s = 24;}
						else if ( (LA39_0=='\'') ) {s = 25;}
						else if ( (LA39_0=='*') ) {s = 26;}
						else if ( (LA39_0=='~') ) {s = 27;}
						else if ( (LA39_0=='L') ) {s = 28;}
						else if ( (LA39_0=='$'||(LA39_0 >= 'A' && LA39_0 <= 'K')||(LA39_0 >= 'M' && LA39_0 <= 'Z')||LA39_0=='_'||(LA39_0 >= 'a' && LA39_0 <= 'z')) ) {s = 29;}
						else if ( (LA39_0=='0') ) {s = 30;}
						else if ( ((LA39_0 >= '1' && LA39_0 <= '9')) ) {s = 31;}
						else if ( (LA39_0=='\n'||LA39_0=='\r') ) {s = 32;}
						else if ( (LA39_0=='\t'||LA39_0==' ') ) {s = 33;}
						else if ( (LA39_0=='\f') ) {s = 34;}
						else if ( ((LA39_0 >= '\u0000' && LA39_0 <= '\b')||LA39_0=='\u000B'||(LA39_0 >= '\u000E' && LA39_0 <= '\u001F')||LA39_0=='#'||LA39_0=='@'||LA39_0=='`'||(LA39_0 >= '\u007F' && LA39_0 <= '\uFFFF')) ) {s = 35;}
						if ( s>=0 ) return s;
						break;
					case 1 : 
						int LA39_9 = input.LA(1);
						s = -1;
						if ( ((LA39_9 >= '\u0000' && LA39_9 <= '\uFFFF')) ) {s = 49;}
						else s = 48;
						if ( s>=0 ) return s;
						break;
					case 2 : 
						int LA39_25 = input.LA(1);
						s = -1;
						if ( ((LA39_25 >= '\u0000' && LA39_25 <= '&')||(LA39_25 >= '(' && LA39_25 <= '\uFFFF')) ) {s = 74;}
						else s = 73;
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 39, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
