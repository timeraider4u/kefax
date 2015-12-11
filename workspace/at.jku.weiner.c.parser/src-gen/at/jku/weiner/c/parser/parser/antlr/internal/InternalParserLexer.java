package at.jku.weiner.c.parser.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalParserLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__128=128;
	public static final int T__129=129;
	public static final int T__130=130;
	public static final int RULE_ANDASSIGN=4;
	public static final int RULE_ARROW=5;
	public static final int RULE_BIN_LITERAL=6;
	public static final int RULE_BLOCK_COMMENT=7;
	public static final int RULE_CHAR_LITERAL=8;
	public static final int RULE_DECIMAL_LITERAL=9;
	public static final int RULE_DIVASSIGN=10;
	public static final int RULE_DOUBLEQUOTE=11;
	public static final int RULE_ELLIPSIS=12;
	public static final int RULE_ESCAPE_SEQUENCE=13;
	public static final int RULE_EXPONENT=14;
	public static final int RULE_FLOAT_LITERAL=15;
	public static final int RULE_FLOAT_TYPE_SUFFIX=16;
	public static final int RULE_HEX_DIGIT=17;
	public static final int RULE_HEX_LITERAL=18;
	public static final int RULE_ID=19;
	public static final int RULE_IDENTIFIER=20;
	public static final int RULE_INTEGER_TYPE_SUFFIX=21;
	public static final int RULE_KW_ALIGNAS=22;
	public static final int RULE_KW_ALIGNOF=23;
	public static final int RULE_KW_ASM1=24;
	public static final int RULE_KW_ASM2=25;
	public static final int RULE_KW_ATOMIC=26;
	public static final int RULE_KW_AUTO=27;
	public static final int RULE_KW_BOOL=28;
	public static final int RULE_KW_BREAK=29;
	public static final int RULE_KW_CASE=30;
	public static final int RULE_KW_CHAR=31;
	public static final int RULE_KW_COMPLEX=32;
	public static final int RULE_KW_CONST=33;
	public static final int RULE_KW_CONTINUE=34;
	public static final int RULE_KW_DEFAULT=35;
	public static final int RULE_KW_DO=36;
	public static final int RULE_KW_DOUBLE=37;
	public static final int RULE_KW_ELSE=38;
	public static final int RULE_KW_ENUM=39;
	public static final int RULE_KW_EXTERN=40;
	public static final int RULE_KW_FLOAT=41;
	public static final int RULE_KW_FOR=42;
	public static final int RULE_KW_GENERIC=43;
	public static final int RULE_KW_GOTO=44;
	public static final int RULE_KW_IF=45;
	public static final int RULE_KW_IMAGINARY=46;
	public static final int RULE_KW_INLINE=47;
	public static final int RULE_KW_INT=48;
	public static final int RULE_KW_LONG=49;
	public static final int RULE_KW_NORETURN=50;
	public static final int RULE_KW_PRAGMA=51;
	public static final int RULE_KW_REGISTER=52;
	public static final int RULE_KW_RESTRICT=53;
	public static final int RULE_KW_RETURN=54;
	public static final int RULE_KW_SHORT=55;
	public static final int RULE_KW_SIGNED=56;
	public static final int RULE_KW_SIZEOF=57;
	public static final int RULE_KW_STATIC=58;
	public static final int RULE_KW_STATICASSERT=59;
	public static final int RULE_KW_STRUCT=60;
	public static final int RULE_KW_SWITCH=61;
	public static final int RULE_KW_THREADLOCAL=62;
	public static final int RULE_KW_TYPEDEF=63;
	public static final int RULE_KW_UNION=64;
	public static final int RULE_KW_UNSIGNED=65;
	public static final int RULE_KW_VOID=66;
	public static final int RULE_KW_VOLATILE=67;
	public static final int RULE_KW_VOLATILE2=68;
	public static final int RULE_KW_WHILE=69;
	public static final int RULE_LEFTSHIFTASSIGN=70;
	public static final int RULE_LETTER=71;
	public static final int RULE_LINEDIRECTIVE=72;
	public static final int RULE_LINE_COMMENT=73;
	public static final int RULE_MINUSASSIGN=74;
	public static final int RULE_MODASSIGN=75;
	public static final int RULE_NEWLINE=76;
	public static final int RULE_OCTAL_ESCAPE=77;
	public static final int RULE_OCTAL_LITERAL=78;
	public static final int RULE_ORASSIGN=79;
	public static final int RULE_PLUSASSIGN=80;
	public static final int RULE_RIGHTSHIFTASSIGN=81;
	public static final int RULE_SINGLEQUOTE=82;
	public static final int RULE_SKW_AND=83;
	public static final int RULE_SKW_ANDAND=84;
	public static final int RULE_SKW_ASSIGN=85;
	public static final int RULE_SKW_BACKSLASH=86;
	public static final int RULE_SKW_CARET=87;
	public static final int RULE_SKW_COLON=88;
	public static final int RULE_SKW_COMMA=89;
	public static final int RULE_SKW_DIV=90;
	public static final int RULE_SKW_DOLLAR=91;
	public static final int RULE_SKW_DOT=92;
	public static final int RULE_SKW_DOUBLEQUOTE=93;
	public static final int RULE_SKW_EQUAL=94;
	public static final int RULE_SKW_GREATER=95;
	public static final int RULE_SKW_GREATEREQUAL=96;
	public static final int RULE_SKW_LEFTBRACE=97;
	public static final int RULE_SKW_LEFTBRACKET=98;
	public static final int RULE_SKW_LEFTPAREN=99;
	public static final int RULE_SKW_LEFTSHIFT=100;
	public static final int RULE_SKW_LESS=101;
	public static final int RULE_SKW_LESSEQUAL=102;
	public static final int RULE_SKW_MINUS=103;
	public static final int RULE_SKW_MINUSMINUS=104;
	public static final int RULE_SKW_MOD=105;
	public static final int RULE_SKW_NOT=106;
	public static final int RULE_SKW_NOTEQUAL=107;
	public static final int RULE_SKW_OR=108;
	public static final int RULE_SKW_OROR=109;
	public static final int RULE_SKW_PLUS=110;
	public static final int RULE_SKW_PLUSPLUS=111;
	public static final int RULE_SKW_QUESTION=112;
	public static final int RULE_SKW_RIGHTBRACE=113;
	public static final int RULE_SKW_RIGHTBRACKET=114;
	public static final int RULE_SKW_RIGHTPAREN=115;
	public static final int RULE_SKW_RIGHTSHIFT=116;
	public static final int RULE_SKW_SEMI=117;
	public static final int RULE_SKW_SINGLEQUOTE=118;
	public static final int RULE_SKW_STAR=119;
	public static final int RULE_SKW_TILDE=120;
	public static final int RULE_SKW_UNDERSCORE=121;
	public static final int RULE_SPECIAL=122;
	public static final int RULE_STARASSIGN=123;
	public static final int RULE_STRING_LITERAL=124;
	public static final int RULE_UNICODE_ESCAPE=125;
	public static final int RULE_WHITESPACE=126;
	public static final int RULE_XORASSIGN=127;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public InternalParserLexer() {} 
	public InternalParserLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public InternalParserLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "InternalParser.g"; }

	// $ANTLR start "T__128"
	public final void mT__128() throws RecognitionException {
		try {
			int _type = T__128;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:15:8: ( '__m128' )
			// InternalParser.g:15:10: '__m128'
			{
			match("__m128"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__128"

	// $ANTLR start "T__129"
	public final void mT__129() throws RecognitionException {
		try {
			int _type = T__129;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:16:8: ( '__m128d' )
			// InternalParser.g:16:10: '__m128d'
			{
			match("__m128d"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__129"

	// $ANTLR start "T__130"
	public final void mT__130() throws RecognitionException {
		try {
			int _type = T__130;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:17:8: ( '__m128i' )
			// InternalParser.g:17:10: '__m128i'
			{
			match("__m128i"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__130"

	// $ANTLR start "RULE_KW_AUTO"
	public final void mRULE_KW_AUTO() throws RecognitionException {
		try {
			int _type = RULE_KW_AUTO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:9959:14: ( 'auto' )
			// InternalParser.g:9959:16: 'auto'
			{
			match("auto"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_AUTO"

	// $ANTLR start "RULE_KW_BREAK"
	public final void mRULE_KW_BREAK() throws RecognitionException {
		try {
			int _type = RULE_KW_BREAK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:9961:15: ( 'break' )
			// InternalParser.g:9961:17: 'break'
			{
			match("break"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_BREAK"

	// $ANTLR start "RULE_KW_CASE"
	public final void mRULE_KW_CASE() throws RecognitionException {
		try {
			int _type = RULE_KW_CASE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:9963:14: ( 'case' )
			// InternalParser.g:9963:16: 'case'
			{
			match("case"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_CASE"

	// $ANTLR start "RULE_KW_CHAR"
	public final void mRULE_KW_CHAR() throws RecognitionException {
		try {
			int _type = RULE_KW_CHAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:9965:14: ( 'char' )
			// InternalParser.g:9965:16: 'char'
			{
			match("char"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_CHAR"

	// $ANTLR start "RULE_KW_CONST"
	public final void mRULE_KW_CONST() throws RecognitionException {
		try {
			int _type = RULE_KW_CONST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:9967:15: ( 'const' )
			// InternalParser.g:9967:17: 'const'
			{
			match("const"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_CONST"

	// $ANTLR start "RULE_KW_CONTINUE"
	public final void mRULE_KW_CONTINUE() throws RecognitionException {
		try {
			int _type = RULE_KW_CONTINUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:9969:18: ( 'continue' )
			// InternalParser.g:9969:20: 'continue'
			{
			match("continue"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_CONTINUE"

	// $ANTLR start "RULE_KW_DEFAULT"
	public final void mRULE_KW_DEFAULT() throws RecognitionException {
		try {
			int _type = RULE_KW_DEFAULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:9971:17: ( 'default' )
			// InternalParser.g:9971:19: 'default'
			{
			match("default"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_DEFAULT"

	// $ANTLR start "RULE_KW_DO"
	public final void mRULE_KW_DO() throws RecognitionException {
		try {
			int _type = RULE_KW_DO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:9973:12: ( 'do' )
			// InternalParser.g:9973:14: 'do'
			{
			match("do"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_DO"

	// $ANTLR start "RULE_KW_DOUBLE"
	public final void mRULE_KW_DOUBLE() throws RecognitionException {
		try {
			int _type = RULE_KW_DOUBLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:9975:16: ( 'double' )
			// InternalParser.g:9975:18: 'double'
			{
			match("double"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_DOUBLE"

	// $ANTLR start "RULE_KW_ELSE"
	public final void mRULE_KW_ELSE() throws RecognitionException {
		try {
			int _type = RULE_KW_ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:9977:14: ( 'else' )
			// InternalParser.g:9977:16: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_ELSE"

	// $ANTLR start "RULE_KW_ENUM"
	public final void mRULE_KW_ENUM() throws RecognitionException {
		try {
			int _type = RULE_KW_ENUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:9979:14: ( 'enum' )
			// InternalParser.g:9979:16: 'enum'
			{
			match("enum"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_ENUM"

	// $ANTLR start "RULE_KW_EXTERN"
	public final void mRULE_KW_EXTERN() throws RecognitionException {
		try {
			int _type = RULE_KW_EXTERN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:9981:16: ( 'extern' )
			// InternalParser.g:9981:18: 'extern'
			{
			match("extern"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_EXTERN"

	// $ANTLR start "RULE_KW_FLOAT"
	public final void mRULE_KW_FLOAT() throws RecognitionException {
		try {
			int _type = RULE_KW_FLOAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:9983:15: ( 'float' )
			// InternalParser.g:9983:17: 'float'
			{
			match("float"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_FLOAT"

	// $ANTLR start "RULE_KW_FOR"
	public final void mRULE_KW_FOR() throws RecognitionException {
		try {
			int _type = RULE_KW_FOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:9985:13: ( 'for' )
			// InternalParser.g:9985:15: 'for'
			{
			match("for"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_FOR"

	// $ANTLR start "RULE_KW_GOTO"
	public final void mRULE_KW_GOTO() throws RecognitionException {
		try {
			int _type = RULE_KW_GOTO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:9987:14: ( 'goto' )
			// InternalParser.g:9987:16: 'goto'
			{
			match("goto"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_GOTO"

	// $ANTLR start "RULE_KW_IF"
	public final void mRULE_KW_IF() throws RecognitionException {
		try {
			int _type = RULE_KW_IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:9989:12: ( 'if' )
			// InternalParser.g:9989:14: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_IF"

	// $ANTLR start "RULE_KW_INLINE"
	public final void mRULE_KW_INLINE() throws RecognitionException {
		try {
			int _type = RULE_KW_INLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:9991:16: ( 'inline' )
			// InternalParser.g:9991:18: 'inline'
			{
			match("inline"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_INLINE"

	// $ANTLR start "RULE_KW_INT"
	public final void mRULE_KW_INT() throws RecognitionException {
		try {
			int _type = RULE_KW_INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:9993:13: ( 'int' )
			// InternalParser.g:9993:15: 'int'
			{
			match("int"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_INT"

	// $ANTLR start "RULE_KW_LONG"
	public final void mRULE_KW_LONG() throws RecognitionException {
		try {
			int _type = RULE_KW_LONG;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:9995:14: ( 'long' )
			// InternalParser.g:9995:16: 'long'
			{
			match("long"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_LONG"

	// $ANTLR start "RULE_KW_REGISTER"
	public final void mRULE_KW_REGISTER() throws RecognitionException {
		try {
			int _type = RULE_KW_REGISTER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:9997:18: ( 'register' )
			// InternalParser.g:9997:20: 'register'
			{
			match("register"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_REGISTER"

	// $ANTLR start "RULE_KW_RESTRICT"
	public final void mRULE_KW_RESTRICT() throws RecognitionException {
		try {
			int _type = RULE_KW_RESTRICT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:9999:18: ( 'restrict' )
			// InternalParser.g:9999:20: 'restrict'
			{
			match("restrict"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_RESTRICT"

	// $ANTLR start "RULE_KW_RETURN"
	public final void mRULE_KW_RETURN() throws RecognitionException {
		try {
			int _type = RULE_KW_RETURN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10001:16: ( 'return' )
			// InternalParser.g:10001:18: 'return'
			{
			match("return"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_RETURN"

	// $ANTLR start "RULE_KW_SHORT"
	public final void mRULE_KW_SHORT() throws RecognitionException {
		try {
			int _type = RULE_KW_SHORT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10003:15: ( 'short' )
			// InternalParser.g:10003:17: 'short'
			{
			match("short"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_SHORT"

	// $ANTLR start "RULE_KW_SIGNED"
	public final void mRULE_KW_SIGNED() throws RecognitionException {
		try {
			int _type = RULE_KW_SIGNED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10005:16: ( 'signed' )
			// InternalParser.g:10005:18: 'signed'
			{
			match("signed"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_SIGNED"

	// $ANTLR start "RULE_KW_SIZEOF"
	public final void mRULE_KW_SIZEOF() throws RecognitionException {
		try {
			int _type = RULE_KW_SIZEOF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10007:16: ( 'sizeof' )
			// InternalParser.g:10007:18: 'sizeof'
			{
			match("sizeof"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_SIZEOF"

	// $ANTLR start "RULE_KW_STATIC"
	public final void mRULE_KW_STATIC() throws RecognitionException {
		try {
			int _type = RULE_KW_STATIC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10009:16: ( 'static' )
			// InternalParser.g:10009:18: 'static'
			{
			match("static"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_STATIC"

	// $ANTLR start "RULE_KW_STRUCT"
	public final void mRULE_KW_STRUCT() throws RecognitionException {
		try {
			int _type = RULE_KW_STRUCT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10011:16: ( 'struct' )
			// InternalParser.g:10011:18: 'struct'
			{
			match("struct"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_STRUCT"

	// $ANTLR start "RULE_KW_SWITCH"
	public final void mRULE_KW_SWITCH() throws RecognitionException {
		try {
			int _type = RULE_KW_SWITCH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10013:16: ( 'switch' )
			// InternalParser.g:10013:18: 'switch'
			{
			match("switch"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_SWITCH"

	// $ANTLR start "RULE_KW_TYPEDEF"
	public final void mRULE_KW_TYPEDEF() throws RecognitionException {
		try {
			int _type = RULE_KW_TYPEDEF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10015:17: ( 'typedef' )
			// InternalParser.g:10015:19: 'typedef'
			{
			match("typedef"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_TYPEDEF"

	// $ANTLR start "RULE_KW_UNION"
	public final void mRULE_KW_UNION() throws RecognitionException {
		try {
			int _type = RULE_KW_UNION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10017:15: ( 'union' )
			// InternalParser.g:10017:17: 'union'
			{
			match("union"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_UNION"

	// $ANTLR start "RULE_KW_UNSIGNED"
	public final void mRULE_KW_UNSIGNED() throws RecognitionException {
		try {
			int _type = RULE_KW_UNSIGNED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10019:18: ( 'unsigned' )
			// InternalParser.g:10019:20: 'unsigned'
			{
			match("unsigned"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_UNSIGNED"

	// $ANTLR start "RULE_KW_VOID"
	public final void mRULE_KW_VOID() throws RecognitionException {
		try {
			int _type = RULE_KW_VOID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10021:14: ( 'void' )
			// InternalParser.g:10021:16: 'void'
			{
			match("void"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_VOID"

	// $ANTLR start "RULE_KW_VOLATILE"
	public final void mRULE_KW_VOLATILE() throws RecognitionException {
		try {
			int _type = RULE_KW_VOLATILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10023:18: ( 'volatile' )
			// InternalParser.g:10023:20: 'volatile'
			{
			match("volatile"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_VOLATILE"

	// $ANTLR start "RULE_KW_WHILE"
	public final void mRULE_KW_WHILE() throws RecognitionException {
		try {
			int _type = RULE_KW_WHILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10025:15: ( 'while' )
			// InternalParser.g:10025:17: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_WHILE"

	// $ANTLR start "RULE_KW_ALIGNAS"
	public final void mRULE_KW_ALIGNAS() throws RecognitionException {
		try {
			int _type = RULE_KW_ALIGNAS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10027:17: ( '_Alignas' )
			// InternalParser.g:10027:19: '_Alignas'
			{
			match("_Alignas"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_ALIGNAS"

	// $ANTLR start "RULE_KW_ALIGNOF"
	public final void mRULE_KW_ALIGNOF() throws RecognitionException {
		try {
			int _type = RULE_KW_ALIGNOF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10029:17: ( '_Alignof' )
			// InternalParser.g:10029:19: '_Alignof'
			{
			match("_Alignof"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_ALIGNOF"

	// $ANTLR start "RULE_KW_ASM1"
	public final void mRULE_KW_ASM1() throws RecognitionException {
		try {
			int _type = RULE_KW_ASM1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10031:14: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'asm' )
			// InternalParser.g:10031:16: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'asm'
			{
			mRULE_SKW_UNDERSCORE(); 

			mRULE_SKW_UNDERSCORE(); 

			match("asm"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_ASM1"

	// $ANTLR start "RULE_KW_ASM2"
	public final void mRULE_KW_ASM2() throws RecognitionException {
		try {
			int _type = RULE_KW_ASM2;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10033:14: ( RULE_KW_ASM1 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE )
			// InternalParser.g:10033:16: RULE_KW_ASM1 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE
			{
			mRULE_KW_ASM1(); 

			mRULE_SKW_UNDERSCORE(); 

			mRULE_SKW_UNDERSCORE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_ASM2"

	// $ANTLR start "RULE_KW_ATOMIC"
	public final void mRULE_KW_ATOMIC() throws RecognitionException {
		try {
			int _type = RULE_KW_ATOMIC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10035:16: ( '_Atomic' )
			// InternalParser.g:10035:18: '_Atomic'
			{
			match("_Atomic"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_ATOMIC"

	// $ANTLR start "RULE_KW_BOOL"
	public final void mRULE_KW_BOOL() throws RecognitionException {
		try {
			int _type = RULE_KW_BOOL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10037:14: ( '_Bool' )
			// InternalParser.g:10037:16: '_Bool'
			{
			match("_Bool"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_BOOL"

	// $ANTLR start "RULE_KW_COMPLEX"
	public final void mRULE_KW_COMPLEX() throws RecognitionException {
		try {
			int _type = RULE_KW_COMPLEX;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10039:17: ( '_Complex' )
			// InternalParser.g:10039:19: '_Complex'
			{
			match("_Complex"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_COMPLEX"

	// $ANTLR start "RULE_KW_GENERIC"
	public final void mRULE_KW_GENERIC() throws RecognitionException {
		try {
			int _type = RULE_KW_GENERIC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10041:17: ( '_Generic' )
			// InternalParser.g:10041:19: '_Generic'
			{
			match("_Generic"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_GENERIC"

	// $ANTLR start "RULE_KW_IMAGINARY"
	public final void mRULE_KW_IMAGINARY() throws RecognitionException {
		try {
			int _type = RULE_KW_IMAGINARY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10043:19: ( '_Imaginary' )
			// InternalParser.g:10043:21: '_Imaginary'
			{
			match("_Imaginary"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_IMAGINARY"

	// $ANTLR start "RULE_KW_NORETURN"
	public final void mRULE_KW_NORETURN() throws RecognitionException {
		try {
			int _type = RULE_KW_NORETURN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10045:18: ( '_Noreturn' )
			// InternalParser.g:10045:20: '_Noreturn'
			{
			match("_Noreturn"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_NORETURN"

	// $ANTLR start "RULE_KW_STATICASSERT"
	public final void mRULE_KW_STATICASSERT() throws RecognitionException {
		try {
			int _type = RULE_KW_STATICASSERT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10047:22: ( '_Static_assert' )
			// InternalParser.g:10047:24: '_Static_assert'
			{
			match("_Static_assert"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_STATICASSERT"

	// $ANTLR start "RULE_KW_THREADLOCAL"
	public final void mRULE_KW_THREADLOCAL() throws RecognitionException {
		try {
			int _type = RULE_KW_THREADLOCAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10049:21: ( '_Thread_local' )
			// InternalParser.g:10049:23: '_Thread_local'
			{
			match("_Thread_local"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_THREADLOCAL"

	// $ANTLR start "RULE_KW_PRAGMA"
	public final void mRULE_KW_PRAGMA() throws RecognitionException {
		try {
			int _type = RULE_KW_PRAGMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10051:16: ( 'pragma' )
			// InternalParser.g:10051:18: 'pragma'
			{
			match("pragma"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_PRAGMA"

	// $ANTLR start "RULE_KW_VOLATILE2"
	public final void mRULE_KW_VOLATILE2() throws RecognitionException {
		try {
			int _type = RULE_KW_VOLATILE2;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10053:19: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_VOLATILE RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE )
			// InternalParser.g:10053:21: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_VOLATILE RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE
			{
			mRULE_SKW_UNDERSCORE(); 

			mRULE_SKW_UNDERSCORE(); 

			mRULE_KW_VOLATILE(); 

			mRULE_SKW_UNDERSCORE(); 

			mRULE_SKW_UNDERSCORE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_VOLATILE2"

	// $ANTLR start "RULE_STARASSIGN"
	public final void mRULE_STARASSIGN() throws RecognitionException {
		try {
			int _type = RULE_STARASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10055:17: ( RULE_SKW_STAR RULE_SKW_ASSIGN )
			// InternalParser.g:10055:19: RULE_SKW_STAR RULE_SKW_ASSIGN
			{
			mRULE_SKW_STAR(); 

			mRULE_SKW_ASSIGN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_STARASSIGN"

	// $ANTLR start "RULE_DIVASSIGN"
	public final void mRULE_DIVASSIGN() throws RecognitionException {
		try {
			int _type = RULE_DIVASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10057:16: ( RULE_SKW_DIV RULE_SKW_ASSIGN )
			// InternalParser.g:10057:18: RULE_SKW_DIV RULE_SKW_ASSIGN
			{
			mRULE_SKW_DIV(); 

			mRULE_SKW_ASSIGN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_DIVASSIGN"

	// $ANTLR start "RULE_MODASSIGN"
	public final void mRULE_MODASSIGN() throws RecognitionException {
		try {
			int _type = RULE_MODASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10059:16: ( RULE_SKW_MOD RULE_SKW_ASSIGN )
			// InternalParser.g:10059:18: RULE_SKW_MOD RULE_SKW_ASSIGN
			{
			mRULE_SKW_MOD(); 

			mRULE_SKW_ASSIGN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_MODASSIGN"

	// $ANTLR start "RULE_PLUSASSIGN"
	public final void mRULE_PLUSASSIGN() throws RecognitionException {
		try {
			int _type = RULE_PLUSASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10061:17: ( RULE_SKW_PLUS RULE_SKW_ASSIGN )
			// InternalParser.g:10061:19: RULE_SKW_PLUS RULE_SKW_ASSIGN
			{
			mRULE_SKW_PLUS(); 

			mRULE_SKW_ASSIGN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_PLUSASSIGN"

	// $ANTLR start "RULE_MINUSASSIGN"
	public final void mRULE_MINUSASSIGN() throws RecognitionException {
		try {
			int _type = RULE_MINUSASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10063:18: ( RULE_SKW_MINUS RULE_SKW_ASSIGN )
			// InternalParser.g:10063:20: RULE_SKW_MINUS RULE_SKW_ASSIGN
			{
			mRULE_SKW_MINUS(); 

			mRULE_SKW_ASSIGN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_MINUSASSIGN"

	// $ANTLR start "RULE_LEFTSHIFTASSIGN"
	public final void mRULE_LEFTSHIFTASSIGN() throws RecognitionException {
		try {
			int _type = RULE_LEFTSHIFTASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10065:22: ( RULE_SKW_LEFTSHIFT RULE_SKW_ASSIGN )
			// InternalParser.g:10065:24: RULE_SKW_LEFTSHIFT RULE_SKW_ASSIGN
			{
			mRULE_SKW_LEFTSHIFT(); 

			mRULE_SKW_ASSIGN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_LEFTSHIFTASSIGN"

	// $ANTLR start "RULE_RIGHTSHIFTASSIGN"
	public final void mRULE_RIGHTSHIFTASSIGN() throws RecognitionException {
		try {
			int _type = RULE_RIGHTSHIFTASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10067:23: ( RULE_SKW_RIGHTSHIFT RULE_SKW_ASSIGN )
			// InternalParser.g:10067:25: RULE_SKW_RIGHTSHIFT RULE_SKW_ASSIGN
			{
			mRULE_SKW_RIGHTSHIFT(); 

			mRULE_SKW_ASSIGN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_RIGHTSHIFTASSIGN"

	// $ANTLR start "RULE_ANDASSIGN"
	public final void mRULE_ANDASSIGN() throws RecognitionException {
		try {
			int _type = RULE_ANDASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10069:16: ( RULE_SKW_AND RULE_SKW_ASSIGN )
			// InternalParser.g:10069:18: RULE_SKW_AND RULE_SKW_ASSIGN
			{
			mRULE_SKW_AND(); 

			mRULE_SKW_ASSIGN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_ANDASSIGN"

	// $ANTLR start "RULE_XORASSIGN"
	public final void mRULE_XORASSIGN() throws RecognitionException {
		try {
			int _type = RULE_XORASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10071:16: ( RULE_SKW_CARET RULE_SKW_ASSIGN )
			// InternalParser.g:10071:18: RULE_SKW_CARET RULE_SKW_ASSIGN
			{
			mRULE_SKW_CARET(); 

			mRULE_SKW_ASSIGN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_XORASSIGN"

	// $ANTLR start "RULE_ORASSIGN"
	public final void mRULE_ORASSIGN() throws RecognitionException {
		try {
			int _type = RULE_ORASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10073:15: ( RULE_SKW_OR RULE_SKW_ASSIGN )
			// InternalParser.g:10073:17: RULE_SKW_OR RULE_SKW_ASSIGN
			{
			mRULE_SKW_OR(); 

			mRULE_SKW_ASSIGN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_ORASSIGN"

	// $ANTLR start "RULE_ARROW"
	public final void mRULE_ARROW() throws RecognitionException {
		try {
			int _type = RULE_ARROW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10075:12: ( RULE_SKW_MINUS RULE_SKW_GREATER )
			// InternalParser.g:10075:14: RULE_SKW_MINUS RULE_SKW_GREATER
			{
			mRULE_SKW_MINUS(); 

			mRULE_SKW_GREATER(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_ARROW"

	// $ANTLR start "RULE_ELLIPSIS"
	public final void mRULE_ELLIPSIS() throws RecognitionException {
		try {
			int _type = RULE_ELLIPSIS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10077:15: ( RULE_SKW_DOT RULE_SKW_DOT RULE_SKW_DOT )
			// InternalParser.g:10077:17: RULE_SKW_DOT RULE_SKW_DOT RULE_SKW_DOT
			{
			mRULE_SKW_DOT(); 

			mRULE_SKW_DOT(); 

			mRULE_SKW_DOT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_ELLIPSIS"

	// $ANTLR start "RULE_SINGLEQUOTE"
	public final void mRULE_SINGLEQUOTE() throws RecognitionException {
		try {
			// InternalParser.g:10079:27: ( '\\'' )
			// InternalParser.g:10079:29: '\\''
			{
			match('\''); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SINGLEQUOTE"

	// $ANTLR start "RULE_DOUBLEQUOTE"
	public final void mRULE_DOUBLEQUOTE() throws RecognitionException {
		try {
			// InternalParser.g:10081:27: ( '\"' )
			// InternalParser.g:10081:29: '\"'
			{
			match('\"'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_DOUBLEQUOTE"

	// $ANTLR start "RULE_ID"
	public final void mRULE_ID() throws RecognitionException {
		try {
			int _type = RULE_ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10083:9: ( RULE_IDENTIFIER )
			// InternalParser.g:10083:11: RULE_IDENTIFIER
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
			// InternalParser.g:10085:26: ( RULE_LETTER ( RULE_LETTER | '0' .. '9' )* )
			// InternalParser.g:10085:28: RULE_LETTER ( RULE_LETTER | '0' .. '9' )*
			{
			mRULE_LETTER(); 

			// InternalParser.g:10085:40: ( RULE_LETTER | '0' .. '9' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0=='$'||(LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// InternalParser.g:
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
			// InternalParser.g:10087:22: ( ( '$' | 'A' .. 'Z' | 'a' .. 'z' | RULE_SKW_UNDERSCORE ) )
			// InternalParser.g:
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
			// InternalParser.g:10089:19: ( RULE_SINGLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) ) RULE_SINGLEQUOTE )
			// InternalParser.g:10089:21: RULE_SINGLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) ) RULE_SINGLEQUOTE
			{
			mRULE_SINGLEQUOTE(); 

			// InternalParser.g:10089:38: ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) )
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
					// InternalParser.g:10089:39: RULE_ESCAPE_SEQUENCE
					{
					mRULE_ESCAPE_SEQUENCE(); 

					}
					break;
				case 2 :
					// InternalParser.g:10089:60: ~ ( ( RULE_SINGLEQUOTE | RULE_SKW_BACKSLASH ) )
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

			mRULE_SINGLEQUOTE(); 

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
			// InternalParser.g:10091:21: ( RULE_DOUBLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_BACKSLASH | RULE_DOUBLEQUOTE ) ) )* RULE_DOUBLEQUOTE )
			// InternalParser.g:10091:23: RULE_DOUBLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_BACKSLASH | RULE_DOUBLEQUOTE ) ) )* RULE_DOUBLEQUOTE
			{
			mRULE_DOUBLEQUOTE(); 

			// InternalParser.g:10091:40: ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_BACKSLASH | RULE_DOUBLEQUOTE ) ) )*
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
					// InternalParser.g:10091:41: RULE_ESCAPE_SEQUENCE
					{
					mRULE_ESCAPE_SEQUENCE(); 

					}
					break;
				case 2 :
					// InternalParser.g:10091:62: ~ ( ( RULE_SKW_BACKSLASH | RULE_DOUBLEQUOTE ) )
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

			mRULE_DOUBLEQUOTE(); 

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
			// InternalParser.g:10093:18: ( '0' ( 'x' | 'X' ) ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )? )
			// InternalParser.g:10093:20: '0' ( 'x' | 'X' ) ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )?
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
			// InternalParser.g:10093:34: ( RULE_HEX_DIGIT )+
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
					// InternalParser.g:
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

			// InternalParser.g:10093:50: ( RULE_INTEGER_TYPE_SUFFIX )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='L'||LA5_0=='U'||LA5_0=='l'||LA5_0=='u') ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// InternalParser.g:10093:50: RULE_INTEGER_TYPE_SUFFIX
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
			// InternalParser.g:10095:22: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( RULE_INTEGER_TYPE_SUFFIX )? )
			// InternalParser.g:10095:24: ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( RULE_INTEGER_TYPE_SUFFIX )?
			{
			// InternalParser.g:10095:24: ( '0' | '1' .. '9' ( '0' .. '9' )* )
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
					// InternalParser.g:10095:25: '0'
					{
					match('0'); 
					}
					break;
				case 2 :
					// InternalParser.g:10095:29: '1' .. '9' ( '0' .. '9' )*
					{
					matchRange('1','9'); 
					// InternalParser.g:10095:38: ( '0' .. '9' )*
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
							alt6=1;
						}

						switch (alt6) {
						case 1 :
							// InternalParser.g:
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

			// InternalParser.g:10095:51: ( RULE_INTEGER_TYPE_SUFFIX )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0=='L'||LA8_0=='U'||LA8_0=='l'||LA8_0=='u') ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// InternalParser.g:10095:51: RULE_INTEGER_TYPE_SUFFIX
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
			// InternalParser.g:10097:20: ( '0' ( '0' .. '7' )+ ( RULE_INTEGER_TYPE_SUFFIX )? )
			// InternalParser.g:10097:22: '0' ( '0' .. '7' )+ ( RULE_INTEGER_TYPE_SUFFIX )?
			{
			match('0'); 
			// InternalParser.g:10097:26: ( '0' .. '7' )+
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
					// InternalParser.g:
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

			// InternalParser.g:10097:38: ( RULE_INTEGER_TYPE_SUFFIX )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='L'||LA10_0=='U'||LA10_0=='l'||LA10_0=='u') ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// InternalParser.g:10097:38: RULE_INTEGER_TYPE_SUFFIX
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
			// InternalParser.g:10099:18: ( ( '0b' | '0B' ) ( '0' .. '1' )+ )
			// InternalParser.g:10099:20: ( '0b' | '0B' ) ( '0' .. '1' )+
			{
			// InternalParser.g:10099:20: ( '0b' | '0B' )
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
					// InternalParser.g:10099:21: '0b'
					{
					match("0b"); 

					}
					break;
				case 2 :
					// InternalParser.g:10099:26: '0B'
					{
					match("0B"); 

					}
					break;

			}

			// InternalParser.g:10099:32: ( '0' .. '1' )+
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
					// InternalParser.g:
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
			// InternalParser.g:10101:25: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
			// InternalParser.g:
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
			// InternalParser.g:10103:35: ( ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? ) )
			// InternalParser.g:10103:37: ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? )
			{
			// InternalParser.g:10103:37: ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? )
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
					// InternalParser.g:10103:38: ( 'u' | 'U' )? ( 'l' | 'L' )
					{
					// InternalParser.g:10103:38: ( 'u' | 'U' )?
					int alt13=2;
					int LA13_0 = input.LA(1);
					if ( (LA13_0=='U'||LA13_0=='u') ) {
						alt13=1;
					}
					switch (alt13) {
						case 1 :
							// InternalParser.g:
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
					// InternalParser.g:10103:59: ( 'u' | 'U' ) ( 'l' | 'L' )?
					{
					if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// InternalParser.g:10103:69: ( 'l' | 'L' )?
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0=='L'||LA14_0=='l') ) {
						alt14=1;
					}
					switch (alt14) {
						case 1 :
							// InternalParser.g:
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
			// InternalParser.g:10105:20: ( ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX ) )
			// InternalParser.g:10105:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )
			{
			// InternalParser.g:10105:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )
			int alt27=4;
			alt27 = dfa27.predict(input);
			switch (alt27) {
				case 1 :
					// InternalParser.g:10105:23: ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )?
					{
					// InternalParser.g:10105:23: ( '0' .. '9' )+
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
							// InternalParser.g:
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

					// InternalParser.g:10105:48: ( '0' .. '9' )*
					loop17:
					while (true) {
						int alt17=2;
						int LA17_0 = input.LA(1);
						if ( ((LA17_0 >= '0' && LA17_0 <= '9')) ) {
							alt17=1;
						}

						switch (alt17) {
						case 1 :
							// InternalParser.g:
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

					// InternalParser.g:10105:60: ( RULE_EXPONENT )?
					int alt18=2;
					int LA18_0 = input.LA(1);
					if ( (LA18_0=='E'||LA18_0=='e') ) {
						alt18=1;
					}
					switch (alt18) {
						case 1 :
							// InternalParser.g:10105:60: RULE_EXPONENT
							{
							mRULE_EXPONENT(); 

							}
							break;

					}

					// InternalParser.g:10105:75: ( RULE_FLOAT_TYPE_SUFFIX )?
					int alt19=2;
					int LA19_0 = input.LA(1);
					if ( (LA19_0=='D'||LA19_0=='F'||LA19_0=='d'||LA19_0=='f') ) {
						alt19=1;
					}
					switch (alt19) {
						case 1 :
							// InternalParser.g:
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
					// InternalParser.g:10105:99: RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )?
					{
					mRULE_SKW_DOT(); 

					// InternalParser.g:10105:112: ( '0' .. '9' )+
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
							// InternalParser.g:
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

					// InternalParser.g:10105:124: ( RULE_EXPONENT )?
					int alt21=2;
					int LA21_0 = input.LA(1);
					if ( (LA21_0=='E'||LA21_0=='e') ) {
						alt21=1;
					}
					switch (alt21) {
						case 1 :
							// InternalParser.g:10105:124: RULE_EXPONENT
							{
							mRULE_EXPONENT(); 

							}
							break;

					}

					// InternalParser.g:10105:139: ( RULE_FLOAT_TYPE_SUFFIX )?
					int alt22=2;
					int LA22_0 = input.LA(1);
					if ( (LA22_0=='D'||LA22_0=='F'||LA22_0=='d'||LA22_0=='f') ) {
						alt22=1;
					}
					switch (alt22) {
						case 1 :
							// InternalParser.g:
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
					// InternalParser.g:10105:163: ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )?
					{
					// InternalParser.g:10105:163: ( '0' .. '9' )+
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
							// InternalParser.g:
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

					// InternalParser.g:10105:189: ( RULE_FLOAT_TYPE_SUFFIX )?
					int alt24=2;
					int LA24_0 = input.LA(1);
					if ( (LA24_0=='D'||LA24_0=='F'||LA24_0=='d'||LA24_0=='f') ) {
						alt24=1;
					}
					switch (alt24) {
						case 1 :
							// InternalParser.g:
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
					// InternalParser.g:10105:213: ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX
					{
					// InternalParser.g:10105:213: ( '0' .. '9' )+
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
							// InternalParser.g:
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

					// InternalParser.g:10105:225: ( RULE_EXPONENT )?
					int alt26=2;
					int LA26_0 = input.LA(1);
					if ( (LA26_0=='E'||LA26_0=='e') ) {
						alt26=1;
					}
					switch (alt26) {
						case 1 :
							// InternalParser.g:10105:225: RULE_EXPONENT
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
			// InternalParser.g:10107:24: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
			// InternalParser.g:10107:26: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// InternalParser.g:10107:36: ( '+' | '-' )?
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0=='+'||LA28_0=='-') ) {
				alt28=1;
			}
			switch (alt28) {
				case 1 :
					// InternalParser.g:
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

			// InternalParser.g:10107:47: ( '0' .. '9' )+
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
					// InternalParser.g:
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
			// InternalParser.g:10109:33: ( ( 'f' | 'F' | 'd' | 'D' ) )
			// InternalParser.g:
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
			// InternalParser.g:10111:31: ( ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE ) )
			// InternalParser.g:10111:33: ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE )
			{
			// InternalParser.g:10111:33: ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE )
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
					// InternalParser.g:10111:34: RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SINGLEQUOTE | RULE_SKW_BACKSLASH )
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
					// InternalParser.g:10111:115: RULE_OCTAL_ESCAPE
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
			// InternalParser.g:10113:28: ( ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' ) )
			// InternalParser.g:10113:30: ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' )
			{
			// InternalParser.g:10113:30: ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' )
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
					// InternalParser.g:10113:31: RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7'
					{
					mRULE_SKW_BACKSLASH(); 

					matchRange('0','3'); 
					matchRange('0','7'); 
					matchRange('0','7'); 
					}
					break;
				case 2 :
					// InternalParser.g:10113:77: RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7'
					{
					mRULE_SKW_BACKSLASH(); 

					matchRange('0','7'); 
					matchRange('0','7'); 
					}
					break;
				case 3 :
					// InternalParser.g:10113:114: RULE_SKW_BACKSLASH '0' .. '7'
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

	// $ANTLR start "RULE_UNICODE_ESCAPE"
	public final void mRULE_UNICODE_ESCAPE() throws RecognitionException {
		try {
			// InternalParser.g:10115:30: ( RULE_SKW_BACKSLASH 'u' RULE_HEX_DIGIT RULE_HEX_DIGIT RULE_HEX_DIGIT RULE_HEX_DIGIT )
			// InternalParser.g:10115:32: RULE_SKW_BACKSLASH 'u' RULE_HEX_DIGIT RULE_HEX_DIGIT RULE_HEX_DIGIT RULE_HEX_DIGIT
			{
			mRULE_SKW_BACKSLASH(); 

			match('u'); 
			mRULE_HEX_DIGIT(); 

			mRULE_HEX_DIGIT(); 

			mRULE_HEX_DIGIT(); 

			mRULE_HEX_DIGIT(); 

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_UNICODE_ESCAPE"

	// $ANTLR start "RULE_LINEDIRECTIVE"
	public final void mRULE_LINEDIRECTIVE() throws RecognitionException {
		try {
			int _type = RULE_LINEDIRECTIVE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10117:20: ( '#' (~ ( RULE_NEWLINE ) | RULE_SKW_BACKSLASH RULE_NEWLINE )* )
			// InternalParser.g:10117:22: '#' (~ ( RULE_NEWLINE ) | RULE_SKW_BACKSLASH RULE_NEWLINE )*
			{
			match('#'); 
			// InternalParser.g:10117:26: (~ ( RULE_NEWLINE ) | RULE_SKW_BACKSLASH RULE_NEWLINE )*
			loop32:
			while (true) {
				int alt32=3;
				int LA32_0 = input.LA(1);
				if ( (LA32_0=='\\') ) {
					int LA32_2 = input.LA(2);
					if ( (LA32_2=='\n'||LA32_2=='\r') ) {
						alt32=2;
					}
					else {
						alt32=1;
					}

				}
				else if ( ((LA32_0 >= '\u0000' && LA32_0 <= '\t')||(LA32_0 >= '\u000B' && LA32_0 <= '\f')||(LA32_0 >= '\u000E' && LA32_0 <= '[')||(LA32_0 >= ']' && LA32_0 <= '\uFFFF')) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// InternalParser.g:10117:27: ~ ( RULE_NEWLINE )
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
				case 2 :
					// InternalParser.g:10117:43: RULE_SKW_BACKSLASH RULE_NEWLINE
					{
					mRULE_SKW_BACKSLASH(); 

					mRULE_NEWLINE(); 

					}
					break;

				default :
					break loop32;
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
	// $ANTLR end "RULE_LINEDIRECTIVE"

	// $ANTLR start "RULE_WHITESPACE"
	public final void mRULE_WHITESPACE() throws RecognitionException {
		try {
			int _type = RULE_WHITESPACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10119:17: ( ( ' ' | '\\t' )+ )
			// InternalParser.g:10119:19: ( ' ' | '\\t' )+
			{
			// InternalParser.g:10119:19: ( ' ' | '\\t' )+
			int cnt33=0;
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( (LA33_0=='\t'||LA33_0==' ') ) {
					alt33=1;
				}

				switch (alt33) {
				case 1 :
					// InternalParser.g:
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
					break;

				default :
					if ( cnt33 >= 1 ) break loop33;
					EarlyExitException eee = new EarlyExitException(33, input);
					throw eee;
				}
				cnt33++;
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
			// InternalParser.g:10121:20: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// InternalParser.g:10121:22: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// InternalParser.g:10121:27: ( options {greedy=false; } : . )*
			loop34:
			while (true) {
				int alt34=2;
				int LA34_0 = input.LA(1);
				if ( (LA34_0=='*') ) {
					int LA34_1 = input.LA(2);
					if ( (LA34_1=='/') ) {
						alt34=2;
					}
					else if ( ((LA34_1 >= '\u0000' && LA34_1 <= '.')||(LA34_1 >= '0' && LA34_1 <= '\uFFFF')) ) {
						alt34=1;
					}

				}
				else if ( ((LA34_0 >= '\u0000' && LA34_0 <= ')')||(LA34_0 >= '+' && LA34_0 <= '\uFFFF')) ) {
					alt34=1;
				}

				switch (alt34) {
				case 1 :
					// InternalParser.g:10121:55: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop34;
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
			// InternalParser.g:10123:19: ( '//' (~ ( RULE_NEWLINE ) )* )
			// InternalParser.g:10123:21: '//' (~ ( RULE_NEWLINE ) )*
			{
			match("//"); 

			// InternalParser.g:10123:26: (~ ( RULE_NEWLINE ) )*
			loop35:
			while (true) {
				int alt35=2;
				int LA35_0 = input.LA(1);
				if ( ((LA35_0 >= '\u0000' && LA35_0 <= '\t')||(LA35_0 >= '\u000B' && LA35_0 <= '\f')||(LA35_0 >= '\u000E' && LA35_0 <= '\uFFFF')) ) {
					alt35=1;
				}

				switch (alt35) {
				case 1 :
					// InternalParser.g:
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
					break loop35;
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

	// $ANTLR start "RULE_NEWLINE"
	public final void mRULE_NEWLINE() throws RecognitionException {
		try {
			int _type = RULE_NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10125:14: ( ( '\\r' | '\\n' ) )
			// InternalParser.g:
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

	// $ANTLR start "RULE_SKW_AND"
	public final void mRULE_SKW_AND() throws RecognitionException {
		try {
			int _type = RULE_SKW_AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10127:14: ( '&' )
			// InternalParser.g:10127:16: '&'
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
			// InternalParser.g:10129:17: ( RULE_SKW_AND RULE_SKW_AND )
			// InternalParser.g:10129:19: RULE_SKW_AND RULE_SKW_AND
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
			// InternalParser.g:10131:17: ( '=' )
			// InternalParser.g:10131:19: '='
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
			// InternalParser.g:10133:20: ( '\\\\' )
			// InternalParser.g:10133:22: '\\\\'
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
			// InternalParser.g:10135:16: ( '^' )
			// InternalParser.g:10135:18: '^'
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
			// InternalParser.g:10137:16: ( ',' )
			// InternalParser.g:10137:18: ','
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
			// InternalParser.g:10139:16: ( ':' )
			// InternalParser.g:10139:18: ':'
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
			// InternalParser.g:10141:14: ( '/' )
			// InternalParser.g:10141:16: '/'
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
			// InternalParser.g:10143:26: ( '$' )
			// InternalParser.g:10143:28: '$'
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
			// InternalParser.g:10145:14: ( '.' )
			// InternalParser.g:10145:16: '.'
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
			// InternalParser.g:10147:22: ( '\"' )
			// InternalParser.g:10147:24: '\"'
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
			// InternalParser.g:10149:16: ( RULE_SKW_ASSIGN RULE_SKW_ASSIGN )
			// InternalParser.g:10149:18: RULE_SKW_ASSIGN RULE_SKW_ASSIGN
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
			// InternalParser.g:10151:18: ( '>' )
			// InternalParser.g:10151:20: '>'
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
			// InternalParser.g:10153:23: ( RULE_SKW_GREATER RULE_SKW_ASSIGN )
			// InternalParser.g:10153:25: RULE_SKW_GREATER RULE_SKW_ASSIGN
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
			// InternalParser.g:10155:20: ( '{' )
			// InternalParser.g:10155:22: '{'
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
			// InternalParser.g:10157:22: ( '[' )
			// InternalParser.g:10157:24: '['
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
			// InternalParser.g:10159:20: ( '(' )
			// InternalParser.g:10159:22: '('
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
			// InternalParser.g:10161:20: ( RULE_SKW_LESS RULE_SKW_LESS )
			// InternalParser.g:10161:22: RULE_SKW_LESS RULE_SKW_LESS
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
			// InternalParser.g:10163:15: ( '<' )
			// InternalParser.g:10163:17: '<'
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
			// InternalParser.g:10165:20: ( RULE_SKW_LESS RULE_SKW_ASSIGN )
			// InternalParser.g:10165:22: RULE_SKW_LESS RULE_SKW_ASSIGN
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
			// InternalParser.g:10167:16: ( '-' )
			// InternalParser.g:10167:18: '-'
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
			// InternalParser.g:10169:21: ( RULE_SKW_MINUS RULE_SKW_MINUS )
			// InternalParser.g:10169:23: RULE_SKW_MINUS RULE_SKW_MINUS
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
			// InternalParser.g:10171:14: ( '%' )
			// InternalParser.g:10171:16: '%'
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
			// InternalParser.g:10173:14: ( '!' )
			// InternalParser.g:10173:16: '!'
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
			// InternalParser.g:10175:19: ( RULE_SKW_NOT RULE_SKW_ASSIGN )
			// InternalParser.g:10175:21: RULE_SKW_NOT RULE_SKW_ASSIGN
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
			// InternalParser.g:10177:13: ( '|' )
			// InternalParser.g:10177:15: '|'
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
			// InternalParser.g:10179:15: ( RULE_SKW_OR RULE_SKW_OR )
			// InternalParser.g:10179:17: RULE_SKW_OR RULE_SKW_OR
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
			// InternalParser.g:10181:15: ( '+' )
			// InternalParser.g:10181:17: '+'
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
			// InternalParser.g:10183:19: ( RULE_SKW_PLUS RULE_SKW_PLUS )
			// InternalParser.g:10183:21: RULE_SKW_PLUS RULE_SKW_PLUS
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
			// InternalParser.g:10185:19: ( '?' )
			// InternalParser.g:10185:21: '?'
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
			// InternalParser.g:10187:21: ( '}' )
			// InternalParser.g:10187:23: '}'
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
			// InternalParser.g:10189:23: ( ']' )
			// InternalParser.g:10189:25: ']'
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
			// InternalParser.g:10191:21: ( ')' )
			// InternalParser.g:10191:23: ')'
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
			// InternalParser.g:10193:21: ( RULE_SKW_GREATER RULE_SKW_GREATER )
			// InternalParser.g:10193:23: RULE_SKW_GREATER RULE_SKW_GREATER
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
			// InternalParser.g:10195:15: ( ';' )
			// InternalParser.g:10195:17: ';'
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
			// InternalParser.g:10197:22: ( '\\'' )
			// InternalParser.g:10197:24: '\\''
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
			// InternalParser.g:10199:15: ( '*' )
			// InternalParser.g:10199:17: '*'
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
			// InternalParser.g:10201:16: ( '~' )
			// InternalParser.g:10201:18: '~'
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
			// InternalParser.g:10203:30: ( '_' )
			// InternalParser.g:10203:32: '_'
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
			// InternalParser.g:10205:14: ( . )
			// InternalParser.g:10205:16: .
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
		// InternalParser.g:1:8: ( T__128 | T__129 | T__130 | RULE_KW_AUTO | RULE_KW_BREAK | RULE_KW_CASE | RULE_KW_CHAR | RULE_KW_CONST | RULE_KW_CONTINUE | RULE_KW_DEFAULT | RULE_KW_DO | RULE_KW_DOUBLE | RULE_KW_ELSE | RULE_KW_ENUM | RULE_KW_EXTERN | RULE_KW_FLOAT | RULE_KW_FOR | RULE_KW_GOTO | RULE_KW_IF | RULE_KW_INLINE | RULE_KW_INT | RULE_KW_LONG | RULE_KW_REGISTER | RULE_KW_RESTRICT | RULE_KW_RETURN | RULE_KW_SHORT | RULE_KW_SIGNED | RULE_KW_SIZEOF | RULE_KW_STATIC | RULE_KW_STRUCT | RULE_KW_SWITCH | RULE_KW_TYPEDEF | RULE_KW_UNION | RULE_KW_UNSIGNED | RULE_KW_VOID | RULE_KW_VOLATILE | RULE_KW_WHILE | RULE_KW_ALIGNAS | RULE_KW_ALIGNOF | RULE_KW_ASM1 | RULE_KW_ASM2 | RULE_KW_ATOMIC | RULE_KW_BOOL | RULE_KW_COMPLEX | RULE_KW_GENERIC | RULE_KW_IMAGINARY | RULE_KW_NORETURN | RULE_KW_STATICASSERT | RULE_KW_THREADLOCAL | RULE_KW_PRAGMA | RULE_KW_VOLATILE2 | RULE_STARASSIGN | RULE_DIVASSIGN | RULE_MODASSIGN | RULE_PLUSASSIGN | RULE_MINUSASSIGN | RULE_LEFTSHIFTASSIGN | RULE_RIGHTSHIFTASSIGN | RULE_ANDASSIGN | RULE_XORASSIGN | RULE_ORASSIGN | RULE_ARROW | RULE_ELLIPSIS | RULE_ID | RULE_CHAR_LITERAL | RULE_STRING_LITERAL | RULE_HEX_LITERAL | RULE_DECIMAL_LITERAL | RULE_OCTAL_LITERAL | RULE_BIN_LITERAL | RULE_FLOAT_LITERAL | RULE_LINEDIRECTIVE | RULE_WHITESPACE | RULE_BLOCK_COMMENT | RULE_LINE_COMMENT | RULE_NEWLINE | RULE_SKW_AND | RULE_SKW_ANDAND | RULE_SKW_ASSIGN | RULE_SKW_BACKSLASH | RULE_SKW_CARET | RULE_SKW_COMMA | RULE_SKW_COLON | RULE_SKW_DIV | RULE_SKW_DOT | RULE_SKW_DOUBLEQUOTE | RULE_SKW_EQUAL | RULE_SKW_GREATER | RULE_SKW_GREATEREQUAL | RULE_SKW_LEFTBRACE | RULE_SKW_LEFTBRACKET | RULE_SKW_LEFTPAREN | RULE_SKW_LEFTSHIFT | RULE_SKW_LESS | RULE_SKW_LESSEQUAL | RULE_SKW_MINUS | RULE_SKW_MINUSMINUS | RULE_SKW_MOD | RULE_SKW_NOT | RULE_SKW_NOTEQUAL | RULE_SKW_OR | RULE_SKW_OROR | RULE_SKW_PLUS | RULE_SKW_PLUSPLUS | RULE_SKW_QUESTION | RULE_SKW_RIGHTBRACE | RULE_SKW_RIGHTBRACKET | RULE_SKW_RIGHTPAREN | RULE_SKW_RIGHTSHIFT | RULE_SKW_SEMI | RULE_SKW_SINGLEQUOTE | RULE_SKW_STAR | RULE_SKW_TILDE | RULE_SPECIAL )
		int alt36=114;
		alt36 = dfa36.predict(input);
		switch (alt36) {
			case 1 :
				// InternalParser.g:1:10: T__128
				{
				mT__128(); 

				}
				break;
			case 2 :
				// InternalParser.g:1:17: T__129
				{
				mT__129(); 

				}
				break;
			case 3 :
				// InternalParser.g:1:24: T__130
				{
				mT__130(); 

				}
				break;
			case 4 :
				// InternalParser.g:1:31: RULE_KW_AUTO
				{
				mRULE_KW_AUTO(); 

				}
				break;
			case 5 :
				// InternalParser.g:1:44: RULE_KW_BREAK
				{
				mRULE_KW_BREAK(); 

				}
				break;
			case 6 :
				// InternalParser.g:1:58: RULE_KW_CASE
				{
				mRULE_KW_CASE(); 

				}
				break;
			case 7 :
				// InternalParser.g:1:71: RULE_KW_CHAR
				{
				mRULE_KW_CHAR(); 

				}
				break;
			case 8 :
				// InternalParser.g:1:84: RULE_KW_CONST
				{
				mRULE_KW_CONST(); 

				}
				break;
			case 9 :
				// InternalParser.g:1:98: RULE_KW_CONTINUE
				{
				mRULE_KW_CONTINUE(); 

				}
				break;
			case 10 :
				// InternalParser.g:1:115: RULE_KW_DEFAULT
				{
				mRULE_KW_DEFAULT(); 

				}
				break;
			case 11 :
				// InternalParser.g:1:131: RULE_KW_DO
				{
				mRULE_KW_DO(); 

				}
				break;
			case 12 :
				// InternalParser.g:1:142: RULE_KW_DOUBLE
				{
				mRULE_KW_DOUBLE(); 

				}
				break;
			case 13 :
				// InternalParser.g:1:157: RULE_KW_ELSE
				{
				mRULE_KW_ELSE(); 

				}
				break;
			case 14 :
				// InternalParser.g:1:170: RULE_KW_ENUM
				{
				mRULE_KW_ENUM(); 

				}
				break;
			case 15 :
				// InternalParser.g:1:183: RULE_KW_EXTERN
				{
				mRULE_KW_EXTERN(); 

				}
				break;
			case 16 :
				// InternalParser.g:1:198: RULE_KW_FLOAT
				{
				mRULE_KW_FLOAT(); 

				}
				break;
			case 17 :
				// InternalParser.g:1:212: RULE_KW_FOR
				{
				mRULE_KW_FOR(); 

				}
				break;
			case 18 :
				// InternalParser.g:1:224: RULE_KW_GOTO
				{
				mRULE_KW_GOTO(); 

				}
				break;
			case 19 :
				// InternalParser.g:1:237: RULE_KW_IF
				{
				mRULE_KW_IF(); 

				}
				break;
			case 20 :
				// InternalParser.g:1:248: RULE_KW_INLINE
				{
				mRULE_KW_INLINE(); 

				}
				break;
			case 21 :
				// InternalParser.g:1:263: RULE_KW_INT
				{
				mRULE_KW_INT(); 

				}
				break;
			case 22 :
				// InternalParser.g:1:275: RULE_KW_LONG
				{
				mRULE_KW_LONG(); 

				}
				break;
			case 23 :
				// InternalParser.g:1:288: RULE_KW_REGISTER
				{
				mRULE_KW_REGISTER(); 

				}
				break;
			case 24 :
				// InternalParser.g:1:305: RULE_KW_RESTRICT
				{
				mRULE_KW_RESTRICT(); 

				}
				break;
			case 25 :
				// InternalParser.g:1:322: RULE_KW_RETURN
				{
				mRULE_KW_RETURN(); 

				}
				break;
			case 26 :
				// InternalParser.g:1:337: RULE_KW_SHORT
				{
				mRULE_KW_SHORT(); 

				}
				break;
			case 27 :
				// InternalParser.g:1:351: RULE_KW_SIGNED
				{
				mRULE_KW_SIGNED(); 

				}
				break;
			case 28 :
				// InternalParser.g:1:366: RULE_KW_SIZEOF
				{
				mRULE_KW_SIZEOF(); 

				}
				break;
			case 29 :
				// InternalParser.g:1:381: RULE_KW_STATIC
				{
				mRULE_KW_STATIC(); 

				}
				break;
			case 30 :
				// InternalParser.g:1:396: RULE_KW_STRUCT
				{
				mRULE_KW_STRUCT(); 

				}
				break;
			case 31 :
				// InternalParser.g:1:411: RULE_KW_SWITCH
				{
				mRULE_KW_SWITCH(); 

				}
				break;
			case 32 :
				// InternalParser.g:1:426: RULE_KW_TYPEDEF
				{
				mRULE_KW_TYPEDEF(); 

				}
				break;
			case 33 :
				// InternalParser.g:1:442: RULE_KW_UNION
				{
				mRULE_KW_UNION(); 

				}
				break;
			case 34 :
				// InternalParser.g:1:456: RULE_KW_UNSIGNED
				{
				mRULE_KW_UNSIGNED(); 

				}
				break;
			case 35 :
				// InternalParser.g:1:473: RULE_KW_VOID
				{
				mRULE_KW_VOID(); 

				}
				break;
			case 36 :
				// InternalParser.g:1:486: RULE_KW_VOLATILE
				{
				mRULE_KW_VOLATILE(); 

				}
				break;
			case 37 :
				// InternalParser.g:1:503: RULE_KW_WHILE
				{
				mRULE_KW_WHILE(); 

				}
				break;
			case 38 :
				// InternalParser.g:1:517: RULE_KW_ALIGNAS
				{
				mRULE_KW_ALIGNAS(); 

				}
				break;
			case 39 :
				// InternalParser.g:1:533: RULE_KW_ALIGNOF
				{
				mRULE_KW_ALIGNOF(); 

				}
				break;
			case 40 :
				// InternalParser.g:1:549: RULE_KW_ASM1
				{
				mRULE_KW_ASM1(); 

				}
				break;
			case 41 :
				// InternalParser.g:1:562: RULE_KW_ASM2
				{
				mRULE_KW_ASM2(); 

				}
				break;
			case 42 :
				// InternalParser.g:1:575: RULE_KW_ATOMIC
				{
				mRULE_KW_ATOMIC(); 

				}
				break;
			case 43 :
				// InternalParser.g:1:590: RULE_KW_BOOL
				{
				mRULE_KW_BOOL(); 

				}
				break;
			case 44 :
				// InternalParser.g:1:603: RULE_KW_COMPLEX
				{
				mRULE_KW_COMPLEX(); 

				}
				break;
			case 45 :
				// InternalParser.g:1:619: RULE_KW_GENERIC
				{
				mRULE_KW_GENERIC(); 

				}
				break;
			case 46 :
				// InternalParser.g:1:635: RULE_KW_IMAGINARY
				{
				mRULE_KW_IMAGINARY(); 

				}
				break;
			case 47 :
				// InternalParser.g:1:653: RULE_KW_NORETURN
				{
				mRULE_KW_NORETURN(); 

				}
				break;
			case 48 :
				// InternalParser.g:1:670: RULE_KW_STATICASSERT
				{
				mRULE_KW_STATICASSERT(); 

				}
				break;
			case 49 :
				// InternalParser.g:1:691: RULE_KW_THREADLOCAL
				{
				mRULE_KW_THREADLOCAL(); 

				}
				break;
			case 50 :
				// InternalParser.g:1:711: RULE_KW_PRAGMA
				{
				mRULE_KW_PRAGMA(); 

				}
				break;
			case 51 :
				// InternalParser.g:1:726: RULE_KW_VOLATILE2
				{
				mRULE_KW_VOLATILE2(); 

				}
				break;
			case 52 :
				// InternalParser.g:1:744: RULE_STARASSIGN
				{
				mRULE_STARASSIGN(); 

				}
				break;
			case 53 :
				// InternalParser.g:1:760: RULE_DIVASSIGN
				{
				mRULE_DIVASSIGN(); 

				}
				break;
			case 54 :
				// InternalParser.g:1:775: RULE_MODASSIGN
				{
				mRULE_MODASSIGN(); 

				}
				break;
			case 55 :
				// InternalParser.g:1:790: RULE_PLUSASSIGN
				{
				mRULE_PLUSASSIGN(); 

				}
				break;
			case 56 :
				// InternalParser.g:1:806: RULE_MINUSASSIGN
				{
				mRULE_MINUSASSIGN(); 

				}
				break;
			case 57 :
				// InternalParser.g:1:823: RULE_LEFTSHIFTASSIGN
				{
				mRULE_LEFTSHIFTASSIGN(); 

				}
				break;
			case 58 :
				// InternalParser.g:1:844: RULE_RIGHTSHIFTASSIGN
				{
				mRULE_RIGHTSHIFTASSIGN(); 

				}
				break;
			case 59 :
				// InternalParser.g:1:866: RULE_ANDASSIGN
				{
				mRULE_ANDASSIGN(); 

				}
				break;
			case 60 :
				// InternalParser.g:1:881: RULE_XORASSIGN
				{
				mRULE_XORASSIGN(); 

				}
				break;
			case 61 :
				// InternalParser.g:1:896: RULE_ORASSIGN
				{
				mRULE_ORASSIGN(); 

				}
				break;
			case 62 :
				// InternalParser.g:1:910: RULE_ARROW
				{
				mRULE_ARROW(); 

				}
				break;
			case 63 :
				// InternalParser.g:1:921: RULE_ELLIPSIS
				{
				mRULE_ELLIPSIS(); 

				}
				break;
			case 64 :
				// InternalParser.g:1:935: RULE_ID
				{
				mRULE_ID(); 

				}
				break;
			case 65 :
				// InternalParser.g:1:943: RULE_CHAR_LITERAL
				{
				mRULE_CHAR_LITERAL(); 

				}
				break;
			case 66 :
				// InternalParser.g:1:961: RULE_STRING_LITERAL
				{
				mRULE_STRING_LITERAL(); 

				}
				break;
			case 67 :
				// InternalParser.g:1:981: RULE_HEX_LITERAL
				{
				mRULE_HEX_LITERAL(); 

				}
				break;
			case 68 :
				// InternalParser.g:1:998: RULE_DECIMAL_LITERAL
				{
				mRULE_DECIMAL_LITERAL(); 

				}
				break;
			case 69 :
				// InternalParser.g:1:1019: RULE_OCTAL_LITERAL
				{
				mRULE_OCTAL_LITERAL(); 

				}
				break;
			case 70 :
				// InternalParser.g:1:1038: RULE_BIN_LITERAL
				{
				mRULE_BIN_LITERAL(); 

				}
				break;
			case 71 :
				// InternalParser.g:1:1055: RULE_FLOAT_LITERAL
				{
				mRULE_FLOAT_LITERAL(); 

				}
				break;
			case 72 :
				// InternalParser.g:1:1074: RULE_LINEDIRECTIVE
				{
				mRULE_LINEDIRECTIVE(); 

				}
				break;
			case 73 :
				// InternalParser.g:1:1093: RULE_WHITESPACE
				{
				mRULE_WHITESPACE(); 

				}
				break;
			case 74 :
				// InternalParser.g:1:1109: RULE_BLOCK_COMMENT
				{
				mRULE_BLOCK_COMMENT(); 

				}
				break;
			case 75 :
				// InternalParser.g:1:1128: RULE_LINE_COMMENT
				{
				mRULE_LINE_COMMENT(); 

				}
				break;
			case 76 :
				// InternalParser.g:1:1146: RULE_NEWLINE
				{
				mRULE_NEWLINE(); 

				}
				break;
			case 77 :
				// InternalParser.g:1:1159: RULE_SKW_AND
				{
				mRULE_SKW_AND(); 

				}
				break;
			case 78 :
				// InternalParser.g:1:1172: RULE_SKW_ANDAND
				{
				mRULE_SKW_ANDAND(); 

				}
				break;
			case 79 :
				// InternalParser.g:1:1188: RULE_SKW_ASSIGN
				{
				mRULE_SKW_ASSIGN(); 

				}
				break;
			case 80 :
				// InternalParser.g:1:1204: RULE_SKW_BACKSLASH
				{
				mRULE_SKW_BACKSLASH(); 

				}
				break;
			case 81 :
				// InternalParser.g:1:1223: RULE_SKW_CARET
				{
				mRULE_SKW_CARET(); 

				}
				break;
			case 82 :
				// InternalParser.g:1:1238: RULE_SKW_COMMA
				{
				mRULE_SKW_COMMA(); 

				}
				break;
			case 83 :
				// InternalParser.g:1:1253: RULE_SKW_COLON
				{
				mRULE_SKW_COLON(); 

				}
				break;
			case 84 :
				// InternalParser.g:1:1268: RULE_SKW_DIV
				{
				mRULE_SKW_DIV(); 

				}
				break;
			case 85 :
				// InternalParser.g:1:1281: RULE_SKW_DOT
				{
				mRULE_SKW_DOT(); 

				}
				break;
			case 86 :
				// InternalParser.g:1:1294: RULE_SKW_DOUBLEQUOTE
				{
				mRULE_SKW_DOUBLEQUOTE(); 

				}
				break;
			case 87 :
				// InternalParser.g:1:1315: RULE_SKW_EQUAL
				{
				mRULE_SKW_EQUAL(); 

				}
				break;
			case 88 :
				// InternalParser.g:1:1330: RULE_SKW_GREATER
				{
				mRULE_SKW_GREATER(); 

				}
				break;
			case 89 :
				// InternalParser.g:1:1347: RULE_SKW_GREATEREQUAL
				{
				mRULE_SKW_GREATEREQUAL(); 

				}
				break;
			case 90 :
				// InternalParser.g:1:1369: RULE_SKW_LEFTBRACE
				{
				mRULE_SKW_LEFTBRACE(); 

				}
				break;
			case 91 :
				// InternalParser.g:1:1388: RULE_SKW_LEFTBRACKET
				{
				mRULE_SKW_LEFTBRACKET(); 

				}
				break;
			case 92 :
				// InternalParser.g:1:1409: RULE_SKW_LEFTPAREN
				{
				mRULE_SKW_LEFTPAREN(); 

				}
				break;
			case 93 :
				// InternalParser.g:1:1428: RULE_SKW_LEFTSHIFT
				{
				mRULE_SKW_LEFTSHIFT(); 

				}
				break;
			case 94 :
				// InternalParser.g:1:1447: RULE_SKW_LESS
				{
				mRULE_SKW_LESS(); 

				}
				break;
			case 95 :
				// InternalParser.g:1:1461: RULE_SKW_LESSEQUAL
				{
				mRULE_SKW_LESSEQUAL(); 

				}
				break;
			case 96 :
				// InternalParser.g:1:1480: RULE_SKW_MINUS
				{
				mRULE_SKW_MINUS(); 

				}
				break;
			case 97 :
				// InternalParser.g:1:1495: RULE_SKW_MINUSMINUS
				{
				mRULE_SKW_MINUSMINUS(); 

				}
				break;
			case 98 :
				// InternalParser.g:1:1515: RULE_SKW_MOD
				{
				mRULE_SKW_MOD(); 

				}
				break;
			case 99 :
				// InternalParser.g:1:1528: RULE_SKW_NOT
				{
				mRULE_SKW_NOT(); 

				}
				break;
			case 100 :
				// InternalParser.g:1:1541: RULE_SKW_NOTEQUAL
				{
				mRULE_SKW_NOTEQUAL(); 

				}
				break;
			case 101 :
				// InternalParser.g:1:1559: RULE_SKW_OR
				{
				mRULE_SKW_OR(); 

				}
				break;
			case 102 :
				// InternalParser.g:1:1571: RULE_SKW_OROR
				{
				mRULE_SKW_OROR(); 

				}
				break;
			case 103 :
				// InternalParser.g:1:1585: RULE_SKW_PLUS
				{
				mRULE_SKW_PLUS(); 

				}
				break;
			case 104 :
				// InternalParser.g:1:1599: RULE_SKW_PLUSPLUS
				{
				mRULE_SKW_PLUSPLUS(); 

				}
				break;
			case 105 :
				// InternalParser.g:1:1617: RULE_SKW_QUESTION
				{
				mRULE_SKW_QUESTION(); 

				}
				break;
			case 106 :
				// InternalParser.g:1:1635: RULE_SKW_RIGHTBRACE
				{
				mRULE_SKW_RIGHTBRACE(); 

				}
				break;
			case 107 :
				// InternalParser.g:1:1655: RULE_SKW_RIGHTBRACKET
				{
				mRULE_SKW_RIGHTBRACKET(); 

				}
				break;
			case 108 :
				// InternalParser.g:1:1677: RULE_SKW_RIGHTPAREN
				{
				mRULE_SKW_RIGHTPAREN(); 

				}
				break;
			case 109 :
				// InternalParser.g:1:1697: RULE_SKW_RIGHTSHIFT
				{
				mRULE_SKW_RIGHTSHIFT(); 

				}
				break;
			case 110 :
				// InternalParser.g:1:1717: RULE_SKW_SEMI
				{
				mRULE_SKW_SEMI(); 

				}
				break;
			case 111 :
				// InternalParser.g:1:1731: RULE_SKW_SINGLEQUOTE
				{
				mRULE_SKW_SINGLEQUOTE(); 

				}
				break;
			case 112 :
				// InternalParser.g:1:1752: RULE_SKW_STAR
				{
				mRULE_SKW_STAR(); 

				}
				break;
			case 113 :
				// InternalParser.g:1:1766: RULE_SKW_TILDE
				{
				mRULE_SKW_TILDE(); 

				}
				break;
			case 114 :
				// InternalParser.g:1:1781: RULE_SPECIAL
				{
				mRULE_SPECIAL(); 

				}
				break;

		}
	}


	protected DFA27 dfa27 = new DFA27(this);
	protected DFA36 dfa36 = new DFA36(this);
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
			return "10105:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )";
		}
	}


	static final String DFA36_eotS =
		"\1\uffff\21\75\1\130\1\134\1\136\1\140\1\143\1\147\1\152\1\155\1\160\1\162\1\165\1\uffff\1\170\1\172\2\176\3\uffff\1\u0084\6\uffff\1\u008c\7\uffff\11\75\1\uffff\6\75\1\u00a7\6\75\1\u00ae\14\75\20\uffff\1\u00c2\2\uffff\1\u00c4\23\uffff\1\u00c6\1\176\23\uffff\23\75\1\uffff\4\75\1\u00df\1\75\1\uffff\1\75\1\u00e2\21\75\5\uffff\14\75\1\u0100\1\75\1\u0102\1\u0103\4\75\1\u0108\1\u0109\2\75\1\uffff\1\u010c\1\75\1\uffff\1\u010e\14\75\1\u011b\4\75\1\u0120\3\75\1\u0125\6\75\1\uffff\1\u012c\2\uffff\1\u012d\3\75\2\uffff\1\75\1\u0132\1\uffff\1\75\1\uffff\3\75\1\u0137\6\75\1\u013e\1\75\1\uffff\1\75\1\u0141\1\75\1\u0145\1\uffff\4\75\1\uffff\6\75\2\uffff\2\75\1\u0153\1\u0154\1\uffff\1\u0155\2\75\1\u0158\1\uffff\1\u0159\1\u015a\1\u015b\1\u015c\1\u015d\1\75\1\uffff\2\75\1\uffff\1\u0161\1\u0162\1\u0163\1\uffff\1\u0164\3\75\1\u0168\7\75\1\u0170\3\uffff\2\75\6\uffff\1\u0173\2\75\4\uffff\1\75\1\u0177\1\u0178\1\uffff\1\u0179\1\u017a\4\75\1\u017f\1\uffff\1\u0180\1\u0181\1\uffff\1\u0182\1\u0183\1\75\4\uffff\1\75\1\u0186\2\75\5\uffff\1\75\1\u018a\1\uffff\3\75\1\uffff\2\75\1\u0190\2\75\1\uffff\1\75\1\u0194\1\u0195\2\uffff";
	static final String DFA36_eofS =
		"\u0196\uffff";
	static final String DFA36_minS =
		"\1\0\1\101\1\165\1\162\1\141\1\145\2\154\1\157\1\146\1\157\1\145\1\150\1\171\1\156\1\157\1\150\1\162\1\75\1\52\1\75\1\53\1\55\1\74\1\75\1\46\2\75\1\56\1\uffff\2\0\2\56\3\uffff\1\75\6\uffff\1\75\7\uffff\1\141\1\154\2\157\1\145\1\155\1\157\1\164\1\150\1\uffff\1\164\1\145\1\163\1\141\1\156\1\146\1\44\1\163\1\165\1\164\1\157\1\162\1\164\1\44\1\154\1\156\1\147\1\157\1\147\1\141\1\151\1\160\3\151\1\141\20\uffff\1\75\2\uffff\1\75\23\uffff\2\56\23\uffff\1\61\1\163\1\157\1\151\2\157\1\155\1\156\1\141\1\162\1\141\1\162\1\157\1\141\1\145\1\162\1\163\1\141\1\142\1\uffff\1\145\1\155\1\145\1\141\1\44\1\157\1\uffff\1\151\1\44\1\147\1\151\1\164\1\165\1\162\1\156\1\145\1\164\1\165\1\164\1\145\1\157\1\151\1\144\1\141\1\154\1\147\5\uffff\1\62\1\155\1\154\1\147\1\155\1\154\1\160\1\145\1\147\1\145\1\164\1\145\1\44\1\153\2\44\1\164\1\151\1\165\1\154\2\44\1\162\1\164\1\uffff\1\44\1\156\1\uffff\1\44\1\163\2\162\1\164\1\145\1\157\1\151\2\143\1\144\1\156\1\147\1\44\1\164\1\145\1\155\1\70\1\44\1\141\1\156\1\151\1\44\1\154\1\162\1\151\1\164\1\151\1\141\1\uffff\1\44\2\uffff\1\44\1\156\1\154\1\145\2\uffff\1\156\1\44\1\uffff\1\145\1\uffff\1\164\1\151\1\156\1\44\1\144\1\146\1\143\1\164\1\150\1\145\1\44\1\156\1\uffff\1\151\1\44\1\141\1\44\1\uffff\1\137\1\164\1\141\1\143\1\uffff\1\145\1\151\1\156\1\165\1\143\1\144\2\uffff\1\165\1\164\2\44\1\uffff\1\44\1\145\1\143\1\44\1\uffff\5\44\1\146\1\uffff\1\145\1\154\1\uffff\3\44\1\uffff\1\44\1\151\1\163\1\146\1\44\1\170\1\143\1\141\1\162\2\137\1\145\1\44\3\uffff\1\162\1\164\6\uffff\1\44\1\144\1\145\4\uffff\1\154\2\44\1\uffff\2\44\1\162\1\156\1\141\1\154\1\44\1\uffff\2\44\1\uffff\2\44\1\145\4\uffff\1\171\1\44\1\163\1\157\5\uffff\1\137\1\44\1\uffff\1\163\1\143\1\137\1\uffff\1\145\1\141\1\44\1\162\1\154\1\uffff\1\164\2\44\2\uffff";
	static final String DFA36_maxS =
		"\1\uffff\1\137\1\165\1\162\2\157\1\170\2\157\1\156\1\157\1\145\1\167\1\171\1\156\1\157\1\150\1\162\4\75\1\76\1\75\1\76\2\75\1\174\1\71\1\uffff\2\uffff\1\170\1\146\3\uffff\1\75\6\uffff\1\75\7\uffff\1\166\1\164\2\157\1\145\1\155\1\157\1\164\1\150\1\uffff\1\164\1\145\1\163\1\141\1\156\1\146\1\172\1\163\1\165\1\164\1\157\1\162\1\164\1\172\1\164\1\156\1\164\1\157\1\172\1\162\1\151\1\160\1\163\1\154\1\151\1\141\20\uffff\1\75\2\uffff\1\75\23\uffff\2\146\23\uffff\1\61\1\163\1\157\1\151\2\157\1\155\1\156\1\141\1\162\1\141\1\162\1\157\1\141\1\145\1\162\1\164\1\141\1\142\1\uffff\1\145\1\155\1\145\1\141\1\172\1\157\1\uffff\1\151\1\172\1\147\1\151\1\164\1\165\1\162\1\156\1\145\1\164\1\165\1\164\1\145\1\157\1\151\1\144\1\141\1\154\1\147\5\uffff\1\62\1\155\1\154\1\147\1\155\1\154\1\160\1\145\1\147\1\145\1\164\1\145\1\172\1\153\2\172\1\164\1\151\1\165\1\154\2\172\1\162\1\164\1\uffff\1\172\1\156\1\uffff\1\172\1\163\2\162\1\164\1\145\1\157\1\151\2\143\1\144\1\156\1\147\1\172\1\164\1\145\1\155\1\70\1\172\1\141\1\156\1\151\1\172\1\154\1\162\1\151\1\164\1\151\1\141\1\uffff\1\172\2\uffff\1\172\1\156\1\154\1\145\2\uffff\1\156\1\172\1\uffff\1\145\1\uffff\1\164\1\151\1\156\1\172\1\144\1\146\1\143\1\164\1\150\1\145\1\172\1\156\1\uffff\1\151\1\172\1\141\1\172\1\uffff\1\137\1\164\1\157\1\143\1\uffff\1\145\1\151\1\156\1\165\1\143\1\144\2\uffff\1\165\1\164\2\172\1\uffff\1\172\1\145\1\143\1\172\1\uffff\5\172\1\146\1\uffff\1\145\1\154\1\uffff\3\172\1\uffff\1\172\1\151\1\163\1\146\1\172\1\170\1\143\1\141\1\162\2\137\1\145\1\172\3\uffff\1\162\1\164\6\uffff\1\172\1\144\1\145\4\uffff\1\154\2\172\1\uffff\2\172\1\162\1\156\1\141\1\154\1\172\1\uffff\2\172\1\uffff\2\172\1\145\4\uffff\1\171\1\172\1\163\1\157\5\uffff\1\137\1\172\1\uffff\1\163\1\143\1\137\1\uffff\1\145\1\141\1\172\1\162\1\154\1\uffff\1\164\2\172\2\uffff";
	static final String DFA36_acceptS =
		"\35\uffff\1\100\4\uffff\1\110\1\111\1\114\1\uffff\1\120\1\122\1\123\1\132\1\133\1\134\1\uffff\1\151\1\152\1\153\1\154\1\156\1\161\1\162\11\uffff\1\100\32\uffff\1\160\1\64\1\112\1\113\1\124\1\65\1\142\1\66\1\147\1\67\1\150\1\140\1\70\1\76\1\141\1\136\1\uffff\1\137\1\130\1\uffff\1\131\1\115\1\73\1\116\1\121\1\74\1\145\1\75\1\146\1\125\1\77\1\107\1\157\1\101\1\126\1\102\1\103\1\106\1\104\2\uffff\1\110\1\111\1\114\1\117\1\127\1\120\1\122\1\123\1\132\1\133\1\134\1\143\1\144\1\151\1\152\1\153\1\154\1\156\1\161\23\uffff\1\13\6\uffff\1\23\23\uffff\1\135\1\71\1\155\1\72\1\105\30\uffff\1\21\2\uffff\1\25\35\uffff\1\4\1\uffff\1\6\1\7\4\uffff\1\15\1\16\2\uffff\1\22\1\uffff\1\26\14\uffff\1\43\4\uffff\1\50\4\uffff\1\53\6\uffff\1\5\1\10\4\uffff\1\20\4\uffff\1\32\6\uffff\1\41\2\uffff\1\45\3\uffff\1\1\15\uffff\1\14\1\17\1\24\2\uffff\1\31\1\33\1\34\1\35\1\36\1\37\3\uffff\1\62\1\2\1\3\1\51\3\uffff\1\52\7\uffff\1\12\2\uffff\1\40\3\uffff\1\46\1\47\1\54\1\55\4\uffff\1\11\1\27\1\30\1\42\1\44\2\uffff\1\57\3\uffff\1\56\5\uffff\1\63\3\uffff\1\61\1\60";
	static final String DFA36_specialS =
		"\1\1\35\uffff\1\0\1\2\u0176\uffff}>";
	static final String[] DFA36_transitionS = {
			"\11\63\1\43\1\44\2\63\1\44\22\63\1\43\1\54\1\37\1\42\1\35\1\24\1\31\1\36\1\53\1\60\1\22\1\25\1\47\1\26\1\34\1\23\1\40\11\41\1\50\1\61\1\27\1\45\1\30\1\55\1\63\32\35\1\52\1\46\1\57\1\32\1\1\1\63\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\35\1\11\2\35\1\12\3\35\1\21\1\35\1\13\1\14\1\15\1\16\1\17\1\20\3\35\1\51\1\33\1\56\1\62\uff81\63",
			"\1\65\1\66\1\67\3\uffff\1\70\1\uffff\1\71\4\uffff\1\72\4\uffff\1\73\1\74\12\uffff\1\64",
			"\1\76",
			"\1\77",
			"\1\100\6\uffff\1\101\6\uffff\1\102",
			"\1\103\11\uffff\1\104",
			"\1\105\1\uffff\1\106\11\uffff\1\107",
			"\1\110\2\uffff\1\111",
			"\1\112",
			"\1\113\7\uffff\1\114",
			"\1\115",
			"\1\116",
			"\1\117\1\120\12\uffff\1\121\2\uffff\1\122",
			"\1\123",
			"\1\124",
			"\1\125",
			"\1\126",
			"\1\127",
			"\1\131",
			"\1\132\4\uffff\1\133\15\uffff\1\135",
			"\1\137",
			"\1\142\21\uffff\1\141",
			"\1\146\17\uffff\1\144\1\145",
			"\1\150\1\151",
			"\1\154\1\153",
			"\1\157\26\uffff\1\156",
			"\1\161",
			"\1\163\76\uffff\1\164",
			"\1\166\1\uffff\12\167",
			"",
			"\47\171\1\uffff\uffd8\171",
			"\0\173",
			"\1\167\1\uffff\10\177\2\167\10\uffff\1\175\1\uffff\3\167\21\uffff\1\174\11\uffff\1\175\1\uffff\3\167\21\uffff\1\174",
			"\1\167\1\uffff\12\u0080\12\uffff\3\167\35\uffff\3\167",
			"",
			"",
			"",
			"\1\u0085",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\u008d",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\u0095\13\uffff\1\u0094\10\uffff\1\u0096",
			"\1\u0097\7\uffff\1\u0098",
			"\1\u0099",
			"\1\u009a",
			"\1\u009b",
			"\1\u009c",
			"\1\u009d",
			"\1\u009e",
			"\1\u009f",
			"",
			"\1\u00a0",
			"\1\u00a1",
			"\1\u00a2",
			"\1\u00a3",
			"\1\u00a4",
			"\1\u00a5",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\24\75\1\u00a6\5\75",
			"\1\u00a8",
			"\1\u00a9",
			"\1\u00aa",
			"\1\u00ab",
			"\1\u00ac",
			"\1\u00ad",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u00af\7\uffff\1\u00b0",
			"\1\u00b1",
			"\1\u00b2\13\uffff\1\u00b3\1\u00b4",
			"\1\u00b5",
			"\1\u00b6\22\uffff\1\u00b7",
			"\1\u00b8\20\uffff\1\u00b9",
			"\1\u00ba",
			"\1\u00bb",
			"\1\u00bc\11\uffff\1\u00bd",
			"\1\u00be\2\uffff\1\u00bf",
			"\1\u00c0",
			"\1\u00c1",
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
			"\1\u00c3",
			"",
			"",
			"\1\u00c5",
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
			"\1\167\1\uffff\10\177\2\167\12\uffff\3\167\35\uffff\3\167",
			"\1\167\1\uffff\12\u0080\12\uffff\3\167\35\uffff\3\167",
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
			"\1\u00c7",
			"\1\u00c8",
			"\1\u00c9",
			"\1\u00ca",
			"\1\u00cb",
			"\1\u00cc",
			"\1\u00cd",
			"\1\u00ce",
			"\1\u00cf",
			"\1\u00d0",
			"\1\u00d1",
			"\1\u00d2",
			"\1\u00d3",
			"\1\u00d4",
			"\1\u00d5",
			"\1\u00d6",
			"\1\u00d7\1\u00d8",
			"\1\u00d9",
			"\1\u00da",
			"",
			"\1\u00db",
			"\1\u00dc",
			"\1\u00dd",
			"\1\u00de",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u00e0",
			"",
			"\1\u00e1",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u00e3",
			"\1\u00e4",
			"\1\u00e5",
			"\1\u00e6",
			"\1\u00e7",
			"\1\u00e8",
			"\1\u00e9",
			"\1\u00ea",
			"\1\u00eb",
			"\1\u00ec",
			"\1\u00ed",
			"\1\u00ee",
			"\1\u00ef",
			"\1\u00f0",
			"\1\u00f1",
			"\1\u00f2",
			"\1\u00f3",
			"",
			"",
			"",
			"",
			"",
			"\1\u00f4",
			"\1\u00f5",
			"\1\u00f6",
			"\1\u00f7",
			"\1\u00f8",
			"\1\u00f9",
			"\1\u00fa",
			"\1\u00fb",
			"\1\u00fc",
			"\1\u00fd",
			"\1\u00fe",
			"\1\u00ff",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0101",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0104",
			"\1\u0105",
			"\1\u0106",
			"\1\u0107",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u010a",
			"\1\u010b",
			"",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u010d",
			"",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u010f",
			"\1\u0110",
			"\1\u0111",
			"\1\u0112",
			"\1\u0113",
			"\1\u0114",
			"\1\u0115",
			"\1\u0116",
			"\1\u0117",
			"\1\u0118",
			"\1\u0119",
			"\1\u011a",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u011c",
			"\1\u011d",
			"\1\u011e",
			"\1\u011f",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\u0121\1\uffff\32\75",
			"\1\u0122",
			"\1\u0123",
			"\1\u0124",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0126",
			"\1\u0127",
			"\1\u0128",
			"\1\u0129",
			"\1\u012a",
			"\1\u012b",
			"",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"",
			"",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u012e",
			"\1\u012f",
			"\1\u0130",
			"",
			"",
			"\1\u0131",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"",
			"\1\u0133",
			"",
			"\1\u0134",
			"\1\u0135",
			"\1\u0136",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0138",
			"\1\u0139",
			"\1\u013a",
			"\1\u013b",
			"\1\u013c",
			"\1\u013d",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u013f",
			"",
			"\1\u0140",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0142",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\3\75\1\u0143\4\75\1\u0144\21\75",
			"",
			"\1\u0146",
			"\1\u0147",
			"\1\u0148\15\uffff\1\u0149",
			"\1\u014a",
			"",
			"\1\u014b",
			"\1\u014c",
			"\1\u014d",
			"\1\u014e",
			"\1\u014f",
			"\1\u0150",
			"",
			"",
			"\1\u0151",
			"\1\u0152",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0156",
			"\1\u0157",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u015e",
			"",
			"\1\u015f",
			"\1\u0160",
			"",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0165",
			"\1\u0166",
			"\1\u0167",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0169",
			"\1\u016a",
			"\1\u016b",
			"\1\u016c",
			"\1\u016d",
			"\1\u016e",
			"\1\u016f",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"",
			"",
			"",
			"\1\u0171",
			"\1\u0172",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0174",
			"\1\u0175",
			"",
			"",
			"",
			"",
			"\1\u0176",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u017b",
			"\1\u017c",
			"\1\u017d",
			"\1\u017e",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0184",
			"",
			"",
			"",
			"",
			"\1\u0185",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0187",
			"\1\u0188",
			"",
			"",
			"",
			"",
			"",
			"\1\u0189",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"",
			"\1\u018b",
			"\1\u018c",
			"\1\u018d",
			"",
			"\1\u018e",
			"\1\u018f",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0191",
			"\1\u0192",
			"",
			"\1\u0193",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"",
			""
	};

	static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
	static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
	static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
	static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
	static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
	static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
	static final short[][] DFA36_transition;

	static {
		int numStates = DFA36_transitionS.length;
		DFA36_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
		}
	}

	protected class DFA36 extends DFA {

		public DFA36(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 36;
			this.eot = DFA36_eot;
			this.eof = DFA36_eof;
			this.min = DFA36_min;
			this.max = DFA36_max;
			this.accept = DFA36_accept;
			this.special = DFA36_special;
			this.transition = DFA36_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__128 | T__129 | T__130 | RULE_KW_AUTO | RULE_KW_BREAK | RULE_KW_CASE | RULE_KW_CHAR | RULE_KW_CONST | RULE_KW_CONTINUE | RULE_KW_DEFAULT | RULE_KW_DO | RULE_KW_DOUBLE | RULE_KW_ELSE | RULE_KW_ENUM | RULE_KW_EXTERN | RULE_KW_FLOAT | RULE_KW_FOR | RULE_KW_GOTO | RULE_KW_IF | RULE_KW_INLINE | RULE_KW_INT | RULE_KW_LONG | RULE_KW_REGISTER | RULE_KW_RESTRICT | RULE_KW_RETURN | RULE_KW_SHORT | RULE_KW_SIGNED | RULE_KW_SIZEOF | RULE_KW_STATIC | RULE_KW_STRUCT | RULE_KW_SWITCH | RULE_KW_TYPEDEF | RULE_KW_UNION | RULE_KW_UNSIGNED | RULE_KW_VOID | RULE_KW_VOLATILE | RULE_KW_WHILE | RULE_KW_ALIGNAS | RULE_KW_ALIGNOF | RULE_KW_ASM1 | RULE_KW_ASM2 | RULE_KW_ATOMIC | RULE_KW_BOOL | RULE_KW_COMPLEX | RULE_KW_GENERIC | RULE_KW_IMAGINARY | RULE_KW_NORETURN | RULE_KW_STATICASSERT | RULE_KW_THREADLOCAL | RULE_KW_PRAGMA | RULE_KW_VOLATILE2 | RULE_STARASSIGN | RULE_DIVASSIGN | RULE_MODASSIGN | RULE_PLUSASSIGN | RULE_MINUSASSIGN | RULE_LEFTSHIFTASSIGN | RULE_RIGHTSHIFTASSIGN | RULE_ANDASSIGN | RULE_XORASSIGN | RULE_ORASSIGN | RULE_ARROW | RULE_ELLIPSIS | RULE_ID | RULE_CHAR_LITERAL | RULE_STRING_LITERAL | RULE_HEX_LITERAL | RULE_DECIMAL_LITERAL | RULE_OCTAL_LITERAL | RULE_BIN_LITERAL | RULE_FLOAT_LITERAL | RULE_LINEDIRECTIVE | RULE_WHITESPACE | RULE_BLOCK_COMMENT | RULE_LINE_COMMENT | RULE_NEWLINE | RULE_SKW_AND | RULE_SKW_ANDAND | RULE_SKW_ASSIGN | RULE_SKW_BACKSLASH | RULE_SKW_CARET | RULE_SKW_COMMA | RULE_SKW_COLON | RULE_SKW_DIV | RULE_SKW_DOT | RULE_SKW_DOUBLEQUOTE | RULE_SKW_EQUAL | RULE_SKW_GREATER | RULE_SKW_GREATEREQUAL | RULE_SKW_LEFTBRACE | RULE_SKW_LEFTBRACKET | RULE_SKW_LEFTPAREN | RULE_SKW_LEFTSHIFT | RULE_SKW_LESS | RULE_SKW_LESSEQUAL | RULE_SKW_MINUS | RULE_SKW_MINUSMINUS | RULE_SKW_MOD | RULE_SKW_NOT | RULE_SKW_NOTEQUAL | RULE_SKW_OR | RULE_SKW_OROR | RULE_SKW_PLUS | RULE_SKW_PLUSPLUS | RULE_SKW_QUESTION | RULE_SKW_RIGHTBRACE | RULE_SKW_RIGHTBRACKET | RULE_SKW_RIGHTPAREN | RULE_SKW_RIGHTSHIFT | RULE_SKW_SEMI | RULE_SKW_SINGLEQUOTE | RULE_SKW_STAR | RULE_SKW_TILDE | RULE_SPECIAL );";
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
				new NoViableAltException(getDescription(), 36, _s, input);
			error(nvae);
			throw nvae;
		}
			private int specialState0(int s, IntStream _input) {
				IntStream input = _input;
				int LA36_30 = input.LA(1);
				s = -1;
				if ( ((LA36_30 >= '\u0000' && LA36_30 <= '&')||(LA36_30 >= '(' && LA36_30 <= '\uFFFF')) ) {s = 121;}
				else s = 120;
				//if ( s>=0 ) return s;
				//break;
				return s;
			}

			private int specialState1(int s, IntStream _input) {
				IntStream input = _input;
				int LA36_0 = input.LA(1);
				s = -1;
				if ( (LA36_0=='_') ) {s = 1;}
				else if ( (LA36_0=='a') ) {s = 2;}
				else if ( (LA36_0=='b') ) {s = 3;}
				else if ( (LA36_0=='c') ) {s = 4;}
				else if ( (LA36_0=='d') ) {s = 5;}
				else if ( (LA36_0=='e') ) {s = 6;}
				else if ( (LA36_0=='f') ) {s = 7;}
				else if ( (LA36_0=='g') ) {s = 8;}
				else if ( (LA36_0=='i') ) {s = 9;}
				else if ( (LA36_0=='l') ) {s = 10;}
				else if ( (LA36_0=='r') ) {s = 11;}
				else if ( (LA36_0=='s') ) {s = 12;}
				else if ( (LA36_0=='t') ) {s = 13;}
				else if ( (LA36_0=='u') ) {s = 14;}
				else if ( (LA36_0=='v') ) {s = 15;}
				else if ( (LA36_0=='w') ) {s = 16;}
				else if ( (LA36_0=='p') ) {s = 17;}
				else if ( (LA36_0=='*') ) {s = 18;}
				else if ( (LA36_0=='/') ) {s = 19;}
				else if ( (LA36_0=='%') ) {s = 20;}
				else if ( (LA36_0=='+') ) {s = 21;}
				else if ( (LA36_0=='-') ) {s = 22;}
				else if ( (LA36_0=='<') ) {s = 23;}
				else if ( (LA36_0=='>') ) {s = 24;}
				else if ( (LA36_0=='&') ) {s = 25;}
				else if ( (LA36_0=='^') ) {s = 26;}
				else if ( (LA36_0=='|') ) {s = 27;}
				else if ( (LA36_0=='.') ) {s = 28;}
				else if ( (LA36_0=='$'||(LA36_0 >= 'A' && LA36_0 <= 'Z')||LA36_0=='h'||(LA36_0 >= 'j' && LA36_0 <= 'k')||(LA36_0 >= 'm' && LA36_0 <= 'o')||LA36_0=='q'||(LA36_0 >= 'x' && LA36_0 <= 'z')) ) {s = 29;}
				else if ( (LA36_0=='\'') ) {s = 30;}
				else if ( (LA36_0=='\"') ) {s = 31;}
				else if ( (LA36_0=='0') ) {s = 32;}
				else if ( ((LA36_0 >= '1' && LA36_0 <= '9')) ) {s = 33;}
				else if ( (LA36_0=='#') ) {s = 34;}
				else if ( (LA36_0=='\t'||LA36_0==' ') ) {s = 35;}
				else if ( (LA36_0=='\n'||LA36_0=='\r') ) {s = 36;}
				else if ( (LA36_0=='=') ) {s = 37;}
				else if ( (LA36_0=='\\') ) {s = 38;}
				else if ( (LA36_0==',') ) {s = 39;}
				else if ( (LA36_0==':') ) {s = 40;}
				else if ( (LA36_0=='{') ) {s = 41;}
				else if ( (LA36_0=='[') ) {s = 42;}
				else if ( (LA36_0=='(') ) {s = 43;}
				else if ( (LA36_0=='!') ) {s = 44;}
				else if ( (LA36_0=='?') ) {s = 45;}
				else if ( (LA36_0=='}') ) {s = 46;}
				else if ( (LA36_0==']') ) {s = 47;}
				else if ( (LA36_0==')') ) {s = 48;}
				else if ( (LA36_0==';') ) {s = 49;}
				else if ( (LA36_0=='~') ) {s = 50;}
				else if ( ((LA36_0 >= '\u0000' && LA36_0 <= '\b')||(LA36_0 >= '\u000B' && LA36_0 <= '\f')||(LA36_0 >= '\u000E' && LA36_0 <= '\u001F')||LA36_0=='@'||LA36_0=='`'||(LA36_0 >= '\u007F' && LA36_0 <= '\uFFFF')) ) {s = 51;}
				//if ( s>=0 ) return s;
				//break;
				return s;
			}

			private int specialState2(int s, IntStream _input) {
				IntStream input = _input;
				int LA36_31 = input.LA(1);
				s = -1;
				if ( ((LA36_31 >= '\u0000' && LA36_31 <= '\uFFFF')) ) {s = 123;}
				else s = 122;
				//if ( s>=0 ) return s;
				//break;
				return s;
			}

	}


}