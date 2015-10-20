package at.jku.weiner.c.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__123=123;
	public static final int T__124=124;
	public static final int T__125=125;
	public static final int RULE_AND=4;
	public static final int RULE_ANDAND=5;
	public static final int RULE_ANDASSIGN=6;
	public static final int RULE_ARROW=7;
	public static final int RULE_ASSIGN=8;
	public static final int RULE_BACKSLASH=9;
	public static final int RULE_BIN_LITERAL=10;
	public static final int RULE_BLOCK_COMMENT=11;
	public static final int RULE_CARET=12;
	public static final int RULE_CHAR_LITERAL=13;
	public static final int RULE_COLON=14;
	public static final int RULE_COMMA=15;
	public static final int RULE_DECIMAL_LITERAL=16;
	public static final int RULE_DIV=17;
	public static final int RULE_DIVASSIGN=18;
	public static final int RULE_DOT=19;
	public static final int RULE_DOUBLEQUOTE=20;
	public static final int RULE_ELLIPSIS=21;
	public static final int RULE_EQUAL=22;
	public static final int RULE_ESCAPE_SEQUENCE=23;
	public static final int RULE_EXPONENT=24;
	public static final int RULE_FLOAT_LITERAL=25;
	public static final int RULE_FLOAT_TYPE_SUFFIX=26;
	public static final int RULE_GREATER=27;
	public static final int RULE_GREATEREQUAL=28;
	public static final int RULE_HEX_DIGIT=29;
	public static final int RULE_HEX_LITERAL=30;
	public static final int RULE_ID=31;
	public static final int RULE_IDENTIFIER=32;
	public static final int RULE_INTEGER_TYPE_SUFFIX=33;
	public static final int RULE_KW_ALIGNAS=34;
	public static final int RULE_KW_ALIGNOF=35;
	public static final int RULE_KW_ASM=36;
	public static final int RULE_KW_ATOMIC=37;
	public static final int RULE_KW_AUTO=38;
	public static final int RULE_KW_BOOL=39;
	public static final int RULE_KW_BREAK=40;
	public static final int RULE_KW_CASE=41;
	public static final int RULE_KW_CHAR=42;
	public static final int RULE_KW_COMPLEX=43;
	public static final int RULE_KW_CONST=44;
	public static final int RULE_KW_CONTINUE=45;
	public static final int RULE_KW_DEFAULT=46;
	public static final int RULE_KW_DO=47;
	public static final int RULE_KW_DOUBLE=48;
	public static final int RULE_KW_ELSE=49;
	public static final int RULE_KW_ENUM=50;
	public static final int RULE_KW_EXTERN=51;
	public static final int RULE_KW_FLOAT=52;
	public static final int RULE_KW_FOR=53;
	public static final int RULE_KW_GENERIC=54;
	public static final int RULE_KW_GOTO=55;
	public static final int RULE_KW_IF=56;
	public static final int RULE_KW_IMAGINARY=57;
	public static final int RULE_KW_INLINE=58;
	public static final int RULE_KW_INT=59;
	public static final int RULE_KW_LONG=60;
	public static final int RULE_KW_NORETURN=61;
	public static final int RULE_KW_PRAGMA=62;
	public static final int RULE_KW_REGISTER=63;
	public static final int RULE_KW_RESTRICT=64;
	public static final int RULE_KW_RETURN=65;
	public static final int RULE_KW_SHORT=66;
	public static final int RULE_KW_SIGNED=67;
	public static final int RULE_KW_SIZEOF=68;
	public static final int RULE_KW_STATIC=69;
	public static final int RULE_KW_STATICASSERT=70;
	public static final int RULE_KW_STRUCT=71;
	public static final int RULE_KW_SWITCH=72;
	public static final int RULE_KW_THREADLOCAL=73;
	public static final int RULE_KW_TYPEDEF=74;
	public static final int RULE_KW_UNDERSCORE=75;
	public static final int RULE_KW_UNION=76;
	public static final int RULE_KW_UNSIGNED=77;
	public static final int RULE_KW_VOID=78;
	public static final int RULE_KW_VOLATILE=79;
	public static final int RULE_KW_WHILE=80;
	public static final int RULE_LEFTBRACE=81;
	public static final int RULE_LEFTBRACKET=82;
	public static final int RULE_LEFTPAREN=83;
	public static final int RULE_LEFTSHIFT=84;
	public static final int RULE_LEFTSHIFTASSIGN=85;
	public static final int RULE_LESS=86;
	public static final int RULE_LESSEQUAL=87;
	public static final int RULE_LETTER=88;
	public static final int RULE_LINEDIRECTIVE=89;
	public static final int RULE_LINE_COMMENT=90;
	public static final int RULE_MINUS=91;
	public static final int RULE_MINUSASSIGN=92;
	public static final int RULE_MINUSMINUS=93;
	public static final int RULE_MOD=94;
	public static final int RULE_MODASSIGN=95;
	public static final int RULE_NEWLINE=96;
	public static final int RULE_NOT=97;
	public static final int RULE_NOTEQUAL=98;
	public static final int RULE_OCTAL_ESCAPE=99;
	public static final int RULE_OCTAL_LITERAL=100;
	public static final int RULE_OR=101;
	public static final int RULE_ORASSIGN=102;
	public static final int RULE_OROR=103;
	public static final int RULE_PLUS=104;
	public static final int RULE_PLUSASSIGN=105;
	public static final int RULE_PLUSPLUS=106;
	public static final int RULE_PRAGMADIRECTIVE=107;
	public static final int RULE_QUESTION=108;
	public static final int RULE_RIGHTBRACE=109;
	public static final int RULE_RIGHTBRACKET=110;
	public static final int RULE_RIGHTPAREN=111;
	public static final int RULE_RIGHTSHIFT=112;
	public static final int RULE_RIGHTSHIFTASSIGN=113;
	public static final int RULE_SEMI=114;
	public static final int RULE_SINGLEQUOTE=115;
	public static final int RULE_STAR=116;
	public static final int RULE_STARASSIGN=117;
	public static final int RULE_STRING_LITERAL=118;
	public static final int RULE_TILDE=119;
	public static final int RULE_UNICODE_ESCAPE=120;
	public static final int RULE_WHITESPACE=121;
	public static final int RULE_XORASSIGN=122;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public InternalCLexer() {} 
	public InternalCLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public InternalCLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "InternalC.g"; }

	// $ANTLR start "T__123"
	public final void mT__123() throws RecognitionException {
		try {
			int _type = T__123;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:15:8: ( '__m128' )
			// InternalC.g:15:10: '__m128'
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
	// $ANTLR end "T__123"

	// $ANTLR start "T__124"
	public final void mT__124() throws RecognitionException {
		try {
			int _type = T__124;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:16:8: ( '__m128d' )
			// InternalC.g:16:10: '__m128d'
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
	// $ANTLR end "T__124"

	// $ANTLR start "T__125"
	public final void mT__125() throws RecognitionException {
		try {
			int _type = T__125;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:17:8: ( '__m128i' )
			// InternalC.g:17:10: '__m128i'
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
	// $ANTLR end "T__125"

	// $ANTLR start "RULE_KW_UNDERSCORE"
	public final void mRULE_KW_UNDERSCORE() throws RecognitionException {
		try {
			int _type = RULE_KW_UNDERSCORE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:5926:20: ( '_' )
			// InternalC.g:5926:22: '_'
			{
			match('_'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_UNDERSCORE"

	// $ANTLR start "RULE_KW_AUTO"
	public final void mRULE_KW_AUTO() throws RecognitionException {
		try {
			int _type = RULE_KW_AUTO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:5928:14: ( 'auto' )
			// InternalC.g:5928:16: 'auto'
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
			// InternalC.g:5930:15: ( 'break' )
			// InternalC.g:5930:17: 'break'
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
			// InternalC.g:5932:14: ( 'case' )
			// InternalC.g:5932:16: 'case'
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
			// InternalC.g:5934:14: ( 'char' )
			// InternalC.g:5934:16: 'char'
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
			// InternalC.g:5936:15: ( 'const' )
			// InternalC.g:5936:17: 'const'
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
			// InternalC.g:5938:18: ( 'continue' )
			// InternalC.g:5938:20: 'continue'
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
			// InternalC.g:5940:17: ( 'default' )
			// InternalC.g:5940:19: 'default'
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
			// InternalC.g:5942:12: ( 'do' )
			// InternalC.g:5942:14: 'do'
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
			// InternalC.g:5944:16: ( 'double' )
			// InternalC.g:5944:18: 'double'
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
			// InternalC.g:5946:14: ( 'else' )
			// InternalC.g:5946:16: 'else'
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
			// InternalC.g:5948:14: ( 'enum' )
			// InternalC.g:5948:16: 'enum'
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
			// InternalC.g:5950:16: ( 'extern' )
			// InternalC.g:5950:18: 'extern'
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
			// InternalC.g:5952:15: ( 'float' )
			// InternalC.g:5952:17: 'float'
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
			// InternalC.g:5954:13: ( 'for' )
			// InternalC.g:5954:15: 'for'
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
			// InternalC.g:5956:14: ( 'goto' )
			// InternalC.g:5956:16: 'goto'
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
			// InternalC.g:5958:12: ( 'if' )
			// InternalC.g:5958:14: 'if'
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
			// InternalC.g:5960:16: ( 'inline' )
			// InternalC.g:5960:18: 'inline'
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
			// InternalC.g:5962:13: ( 'int' )
			// InternalC.g:5962:15: 'int'
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
			// InternalC.g:5964:14: ( 'long' )
			// InternalC.g:5964:16: 'long'
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
			// InternalC.g:5966:18: ( 'register' )
			// InternalC.g:5966:20: 'register'
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
			// InternalC.g:5968:18: ( 'restrict' )
			// InternalC.g:5968:20: 'restrict'
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
			// InternalC.g:5970:16: ( 'return' )
			// InternalC.g:5970:18: 'return'
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
			// InternalC.g:5972:15: ( 'short' )
			// InternalC.g:5972:17: 'short'
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
			// InternalC.g:5974:16: ( 'signed' )
			// InternalC.g:5974:18: 'signed'
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
			// InternalC.g:5976:16: ( 'sizeof' )
			// InternalC.g:5976:18: 'sizeof'
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
			// InternalC.g:5978:16: ( 'static' )
			// InternalC.g:5978:18: 'static'
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
			// InternalC.g:5980:16: ( 'struct' )
			// InternalC.g:5980:18: 'struct'
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
			// InternalC.g:5982:16: ( 'switch' )
			// InternalC.g:5982:18: 'switch'
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
			// InternalC.g:5984:17: ( 'typedef' )
			// InternalC.g:5984:19: 'typedef'
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
			// InternalC.g:5986:15: ( 'union' )
			// InternalC.g:5986:17: 'union'
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
			// InternalC.g:5988:18: ( 'unsigned' )
			// InternalC.g:5988:20: 'unsigned'
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
			// InternalC.g:5990:14: ( 'void' )
			// InternalC.g:5990:16: 'void'
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
			// InternalC.g:5992:18: ( 'volatile' )
			// InternalC.g:5992:20: 'volatile'
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
			// InternalC.g:5994:15: ( 'while' )
			// InternalC.g:5994:17: 'while'
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
			// InternalC.g:5996:17: ( '_Alignas' )
			// InternalC.g:5996:19: '_Alignas'
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
			// InternalC.g:5998:17: ( '_Alignof' )
			// InternalC.g:5998:19: '_Alignof'
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

	// $ANTLR start "RULE_KW_ASM"
	public final void mRULE_KW_ASM() throws RecognitionException {
		try {
			int _type = RULE_KW_ASM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6000:13: ( 'asm' )
			// InternalC.g:6000:15: 'asm'
			{
			match("asm"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_ASM"

	// $ANTLR start "RULE_KW_ATOMIC"
	public final void mRULE_KW_ATOMIC() throws RecognitionException {
		try {
			int _type = RULE_KW_ATOMIC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6002:16: ( '_Atomic' )
			// InternalC.g:6002:18: '_Atomic'
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
			// InternalC.g:6004:14: ( '_Bool' )
			// InternalC.g:6004:16: '_Bool'
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
			// InternalC.g:6006:17: ( '_Complex' )
			// InternalC.g:6006:19: '_Complex'
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
			// InternalC.g:6008:17: ( '_Generic' )
			// InternalC.g:6008:19: '_Generic'
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
			// InternalC.g:6010:19: ( '_Imaginary' )
			// InternalC.g:6010:21: '_Imaginary'
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
			// InternalC.g:6012:18: ( '_Noreturn' )
			// InternalC.g:6012:20: '_Noreturn'
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
			// InternalC.g:6014:22: ( '_Static_assert' )
			// InternalC.g:6014:24: '_Static_assert'
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
			// InternalC.g:6016:21: ( '_Thread_local' )
			// InternalC.g:6016:23: '_Thread_local'
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
			// InternalC.g:6018:25: ( 'pragma' )
			// InternalC.g:6018:27: 'pragma'
			{
			match("pragma"); 

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_PRAGMA"

	// $ANTLR start "RULE_LEFTPAREN"
	public final void mRULE_LEFTPAREN() throws RecognitionException {
		try {
			int _type = RULE_LEFTPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6020:16: ( '(' )
			// InternalC.g:6020:18: '('
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
	// $ANTLR end "RULE_LEFTPAREN"

	// $ANTLR start "RULE_RIGHTPAREN"
	public final void mRULE_RIGHTPAREN() throws RecognitionException {
		try {
			int _type = RULE_RIGHTPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6022:17: ( ')' )
			// InternalC.g:6022:19: ')'
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
	// $ANTLR end "RULE_RIGHTPAREN"

	// $ANTLR start "RULE_LEFTBRACKET"
	public final void mRULE_LEFTBRACKET() throws RecognitionException {
		try {
			int _type = RULE_LEFTBRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6024:18: ( '[' )
			// InternalC.g:6024:20: '['
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
	// $ANTLR end "RULE_LEFTBRACKET"

	// $ANTLR start "RULE_RIGHTBRACKET"
	public final void mRULE_RIGHTBRACKET() throws RecognitionException {
		try {
			int _type = RULE_RIGHTBRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6026:19: ( ']' )
			// InternalC.g:6026:21: ']'
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
	// $ANTLR end "RULE_RIGHTBRACKET"

	// $ANTLR start "RULE_LEFTBRACE"
	public final void mRULE_LEFTBRACE() throws RecognitionException {
		try {
			int _type = RULE_LEFTBRACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6028:16: ( '{' )
			// InternalC.g:6028:18: '{'
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
	// $ANTLR end "RULE_LEFTBRACE"

	// $ANTLR start "RULE_RIGHTBRACE"
	public final void mRULE_RIGHTBRACE() throws RecognitionException {
		try {
			int _type = RULE_RIGHTBRACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6030:17: ( '}' )
			// InternalC.g:6030:19: '}'
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
	// $ANTLR end "RULE_RIGHTBRACE"

	// $ANTLR start "RULE_LESS"
	public final void mRULE_LESS() throws RecognitionException {
		try {
			int _type = RULE_LESS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6032:11: ( '<' )
			// InternalC.g:6032:13: '<'
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
	// $ANTLR end "RULE_LESS"

	// $ANTLR start "RULE_LESSEQUAL"
	public final void mRULE_LESSEQUAL() throws RecognitionException {
		try {
			int _type = RULE_LESSEQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6034:16: ( RULE_LESS RULE_ASSIGN )
			// InternalC.g:6034:18: RULE_LESS RULE_ASSIGN
			{
			mRULE_LESS(); 

			mRULE_ASSIGN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_LESSEQUAL"

	// $ANTLR start "RULE_GREATER"
	public final void mRULE_GREATER() throws RecognitionException {
		try {
			int _type = RULE_GREATER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6036:14: ( '>' )
			// InternalC.g:6036:16: '>'
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
	// $ANTLR end "RULE_GREATER"

	// $ANTLR start "RULE_GREATEREQUAL"
	public final void mRULE_GREATEREQUAL() throws RecognitionException {
		try {
			int _type = RULE_GREATEREQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6038:19: ( RULE_GREATER RULE_ASSIGN )
			// InternalC.g:6038:21: RULE_GREATER RULE_ASSIGN
			{
			mRULE_GREATER(); 

			mRULE_ASSIGN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_GREATEREQUAL"

	// $ANTLR start "RULE_LEFTSHIFT"
	public final void mRULE_LEFTSHIFT() throws RecognitionException {
		try {
			int _type = RULE_LEFTSHIFT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6040:16: ( RULE_LESS RULE_LESS )
			// InternalC.g:6040:18: RULE_LESS RULE_LESS
			{
			mRULE_LESS(); 

			mRULE_LESS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_LEFTSHIFT"

	// $ANTLR start "RULE_RIGHTSHIFT"
	public final void mRULE_RIGHTSHIFT() throws RecognitionException {
		try {
			int _type = RULE_RIGHTSHIFT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6042:17: ( RULE_GREATER RULE_GREATER )
			// InternalC.g:6042:19: RULE_GREATER RULE_GREATER
			{
			mRULE_GREATER(); 

			mRULE_GREATER(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_RIGHTSHIFT"

	// $ANTLR start "RULE_PLUS"
	public final void mRULE_PLUS() throws RecognitionException {
		try {
			int _type = RULE_PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6044:11: ( '+' )
			// InternalC.g:6044:13: '+'
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
	// $ANTLR end "RULE_PLUS"

	// $ANTLR start "RULE_PLUSPLUS"
	public final void mRULE_PLUSPLUS() throws RecognitionException {
		try {
			int _type = RULE_PLUSPLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6046:15: ( RULE_PLUS RULE_PLUS )
			// InternalC.g:6046:17: RULE_PLUS RULE_PLUS
			{
			mRULE_PLUS(); 

			mRULE_PLUS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_PLUSPLUS"

	// $ANTLR start "RULE_MINUS"
	public final void mRULE_MINUS() throws RecognitionException {
		try {
			int _type = RULE_MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6048:12: ( '-' )
			// InternalC.g:6048:14: '-'
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
	// $ANTLR end "RULE_MINUS"

	// $ANTLR start "RULE_MINUSMINUS"
	public final void mRULE_MINUSMINUS() throws RecognitionException {
		try {
			int _type = RULE_MINUSMINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6050:17: ( RULE_MINUS RULE_MINUS )
			// InternalC.g:6050:19: RULE_MINUS RULE_MINUS
			{
			mRULE_MINUS(); 

			mRULE_MINUS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_MINUSMINUS"

	// $ANTLR start "RULE_STAR"
	public final void mRULE_STAR() throws RecognitionException {
		try {
			int _type = RULE_STAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6052:11: ( '*' )
			// InternalC.g:6052:13: '*'
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
	// $ANTLR end "RULE_STAR"

	// $ANTLR start "RULE_DIV"
	public final void mRULE_DIV() throws RecognitionException {
		try {
			int _type = RULE_DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6054:10: ( '/' )
			// InternalC.g:6054:12: '/'
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
	// $ANTLR end "RULE_DIV"

	// $ANTLR start "RULE_MOD"
	public final void mRULE_MOD() throws RecognitionException {
		try {
			int _type = RULE_MOD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6056:10: ( '%' )
			// InternalC.g:6056:12: '%'
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
	// $ANTLR end "RULE_MOD"

	// $ANTLR start "RULE_AND"
	public final void mRULE_AND() throws RecognitionException {
		try {
			int _type = RULE_AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6058:10: ( '&' )
			// InternalC.g:6058:12: '&'
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
	// $ANTLR end "RULE_AND"

	// $ANTLR start "RULE_ANDAND"
	public final void mRULE_ANDAND() throws RecognitionException {
		try {
			int _type = RULE_ANDAND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6060:13: ( RULE_AND RULE_AND )
			// InternalC.g:6060:15: RULE_AND RULE_AND
			{
			mRULE_AND(); 

			mRULE_AND(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_ANDAND"

	// $ANTLR start "RULE_OR"
	public final void mRULE_OR() throws RecognitionException {
		try {
			int _type = RULE_OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6062:9: ( '|' )
			// InternalC.g:6062:11: '|'
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
	// $ANTLR end "RULE_OR"

	// $ANTLR start "RULE_OROR"
	public final void mRULE_OROR() throws RecognitionException {
		try {
			int _type = RULE_OROR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6064:11: ( RULE_OR RULE_OR )
			// InternalC.g:6064:13: RULE_OR RULE_OR
			{
			mRULE_OR(); 

			mRULE_OR(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_OROR"

	// $ANTLR start "RULE_CARET"
	public final void mRULE_CARET() throws RecognitionException {
		try {
			int _type = RULE_CARET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6066:12: ( '^' )
			// InternalC.g:6066:14: '^'
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
	// $ANTLR end "RULE_CARET"

	// $ANTLR start "RULE_NOT"
	public final void mRULE_NOT() throws RecognitionException {
		try {
			int _type = RULE_NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6068:10: ( '!' )
			// InternalC.g:6068:12: '!'
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
	// $ANTLR end "RULE_NOT"

	// $ANTLR start "RULE_TILDE"
	public final void mRULE_TILDE() throws RecognitionException {
		try {
			int _type = RULE_TILDE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6070:12: ( '~' )
			// InternalC.g:6070:14: '~'
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
	// $ANTLR end "RULE_TILDE"

	// $ANTLR start "RULE_QUESTION"
	public final void mRULE_QUESTION() throws RecognitionException {
		try {
			int _type = RULE_QUESTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6072:15: ( '?' )
			// InternalC.g:6072:17: '?'
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
	// $ANTLR end "RULE_QUESTION"

	// $ANTLR start "RULE_COLON"
	public final void mRULE_COLON() throws RecognitionException {
		try {
			int _type = RULE_COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6074:12: ( ':' )
			// InternalC.g:6074:14: ':'
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
	// $ANTLR end "RULE_COLON"

	// $ANTLR start "RULE_SEMI"
	public final void mRULE_SEMI() throws RecognitionException {
		try {
			int _type = RULE_SEMI;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6076:11: ( ';' )
			// InternalC.g:6076:13: ';'
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
	// $ANTLR end "RULE_SEMI"

	// $ANTLR start "RULE_COMMA"
	public final void mRULE_COMMA() throws RecognitionException {
		try {
			int _type = RULE_COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6078:12: ( ',' )
			// InternalC.g:6078:14: ','
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
	// $ANTLR end "RULE_COMMA"

	// $ANTLR start "RULE_ASSIGN"
	public final void mRULE_ASSIGN() throws RecognitionException {
		try {
			int _type = RULE_ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6080:13: ( '=' )
			// InternalC.g:6080:15: '='
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
	// $ANTLR end "RULE_ASSIGN"

	// $ANTLR start "RULE_STARASSIGN"
	public final void mRULE_STARASSIGN() throws RecognitionException {
		try {
			int _type = RULE_STARASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6082:17: ( RULE_STAR RULE_ASSIGN )
			// InternalC.g:6082:19: RULE_STAR RULE_ASSIGN
			{
			mRULE_STAR(); 

			mRULE_ASSIGN(); 

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
			// InternalC.g:6084:16: ( RULE_DIV RULE_ASSIGN )
			// InternalC.g:6084:18: RULE_DIV RULE_ASSIGN
			{
			mRULE_DIV(); 

			mRULE_ASSIGN(); 

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
			// InternalC.g:6086:16: ( RULE_MOD RULE_ASSIGN )
			// InternalC.g:6086:18: RULE_MOD RULE_ASSIGN
			{
			mRULE_MOD(); 

			mRULE_ASSIGN(); 

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
			// InternalC.g:6088:17: ( RULE_PLUS RULE_ASSIGN )
			// InternalC.g:6088:19: RULE_PLUS RULE_ASSIGN
			{
			mRULE_PLUS(); 

			mRULE_ASSIGN(); 

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
			// InternalC.g:6090:18: ( RULE_MINUS RULE_ASSIGN )
			// InternalC.g:6090:20: RULE_MINUS RULE_ASSIGN
			{
			mRULE_MINUS(); 

			mRULE_ASSIGN(); 

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
			// InternalC.g:6092:22: ( RULE_LEFTSHIFT RULE_ASSIGN )
			// InternalC.g:6092:24: RULE_LEFTSHIFT RULE_ASSIGN
			{
			mRULE_LEFTSHIFT(); 

			mRULE_ASSIGN(); 

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
			// InternalC.g:6094:23: ( RULE_RIGHTSHIFT RULE_ASSIGN )
			// InternalC.g:6094:25: RULE_RIGHTSHIFT RULE_ASSIGN
			{
			mRULE_RIGHTSHIFT(); 

			mRULE_ASSIGN(); 

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
			// InternalC.g:6096:16: ( RULE_AND RULE_ASSIGN )
			// InternalC.g:6096:18: RULE_AND RULE_ASSIGN
			{
			mRULE_AND(); 

			mRULE_ASSIGN(); 

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
			// InternalC.g:6098:16: ( RULE_CARET RULE_ASSIGN )
			// InternalC.g:6098:18: RULE_CARET RULE_ASSIGN
			{
			mRULE_CARET(); 

			mRULE_ASSIGN(); 

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
			// InternalC.g:6100:15: ( RULE_OR RULE_ASSIGN )
			// InternalC.g:6100:17: RULE_OR RULE_ASSIGN
			{
			mRULE_OR(); 

			mRULE_ASSIGN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_ORASSIGN"

	// $ANTLR start "RULE_EQUAL"
	public final void mRULE_EQUAL() throws RecognitionException {
		try {
			int _type = RULE_EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6102:12: ( RULE_ASSIGN RULE_ASSIGN )
			// InternalC.g:6102:14: RULE_ASSIGN RULE_ASSIGN
			{
			mRULE_ASSIGN(); 

			mRULE_ASSIGN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_EQUAL"

	// $ANTLR start "RULE_NOTEQUAL"
	public final void mRULE_NOTEQUAL() throws RecognitionException {
		try {
			int _type = RULE_NOTEQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6104:15: ( RULE_NOT RULE_ASSIGN )
			// InternalC.g:6104:17: RULE_NOT RULE_ASSIGN
			{
			mRULE_NOT(); 

			mRULE_ASSIGN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_NOTEQUAL"

	// $ANTLR start "RULE_ARROW"
	public final void mRULE_ARROW() throws RecognitionException {
		try {
			int _type = RULE_ARROW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6106:12: ( RULE_MINUS RULE_GREATER )
			// InternalC.g:6106:14: RULE_MINUS RULE_GREATER
			{
			mRULE_MINUS(); 

			mRULE_GREATER(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_ARROW"

	// $ANTLR start "RULE_DOT"
	public final void mRULE_DOT() throws RecognitionException {
		try {
			// InternalC.g:6108:19: ( '.' )
			// InternalC.g:6108:21: '.'
			{
			match('.'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_DOT"

	// $ANTLR start "RULE_ELLIPSIS"
	public final void mRULE_ELLIPSIS() throws RecognitionException {
		try {
			int _type = RULE_ELLIPSIS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6110:15: ( RULE_DOT RULE_DOT RULE_DOT )
			// InternalC.g:6110:17: RULE_DOT RULE_DOT RULE_DOT
			{
			mRULE_DOT(); 

			mRULE_DOT(); 

			mRULE_DOT(); 

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
			int _type = RULE_SINGLEQUOTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6112:18: ( '\\'' )
			// InternalC.g:6112:20: '\\''
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
	// $ANTLR end "RULE_SINGLEQUOTE"

	// $ANTLR start "RULE_DOUBLEQUOTE"
	public final void mRULE_DOUBLEQUOTE() throws RecognitionException {
		try {
			int _type = RULE_DOUBLEQUOTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6114:18: ( '\"' )
			// InternalC.g:6114:20: '\"'
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
	// $ANTLR end "RULE_DOUBLEQUOTE"

	// $ANTLR start "RULE_BACKSLASH"
	public final void mRULE_BACKSLASH() throws RecognitionException {
		try {
			int _type = RULE_BACKSLASH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6116:16: ( '\\\\' )
			// InternalC.g:6116:18: '\\\\'
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
	// $ANTLR end "RULE_BACKSLASH"

	// $ANTLR start "RULE_ID"
	public final void mRULE_ID() throws RecognitionException {
		try {
			int _type = RULE_ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6118:9: ( RULE_IDENTIFIER )
			// InternalC.g:6118:11: RULE_IDENTIFIER
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
			// InternalC.g:6120:26: ( RULE_LETTER ( RULE_LETTER | '0' .. '9' )* )
			// InternalC.g:6120:28: RULE_LETTER ( RULE_LETTER | '0' .. '9' )*
			{
			mRULE_LETTER(); 

			// InternalC.g:6120:40: ( RULE_LETTER | '0' .. '9' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0=='$'||(LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// InternalC.g:
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
			// InternalC.g:6122:22: ( ( '$' | 'A' .. 'Z' | 'a' .. 'z' | '_' ) )
			// InternalC.g:
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
			// InternalC.g:6124:19: ( '\\'' ( RULE_ESCAPE_SEQUENCE |~ ( ( '\\'' | '\\\\' ) ) ) '\\'' )
			// InternalC.g:6124:21: '\\'' ( RULE_ESCAPE_SEQUENCE |~ ( ( '\\'' | '\\\\' ) ) ) '\\''
			{
			match('\''); 
			// InternalC.g:6124:26: ( RULE_ESCAPE_SEQUENCE |~ ( ( '\\'' | '\\\\' ) ) )
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
					// InternalC.g:6124:27: RULE_ESCAPE_SEQUENCE
					{
					mRULE_ESCAPE_SEQUENCE(); 

					}
					break;
				case 2 :
					// InternalC.g:6124:48: ~ ( ( '\\'' | '\\\\' ) )
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

			match('\''); 
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
			// InternalC.g:6126:21: ( '\"' ( RULE_ESCAPE_SEQUENCE |~ ( ( '\\\\' | '\"' ) ) )* '\"' )
			// InternalC.g:6126:23: '\"' ( RULE_ESCAPE_SEQUENCE |~ ( ( '\\\\' | '\"' ) ) )* '\"'
			{
			match('\"'); 
			// InternalC.g:6126:27: ( RULE_ESCAPE_SEQUENCE |~ ( ( '\\\\' | '\"' ) ) )*
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
					// InternalC.g:6126:28: RULE_ESCAPE_SEQUENCE
					{
					mRULE_ESCAPE_SEQUENCE(); 

					}
					break;
				case 2 :
					// InternalC.g:6126:49: ~ ( ( '\\\\' | '\"' ) )
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

			match('\"'); 
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
			// InternalC.g:6128:18: ( '0' ( 'x' | 'X' ) ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )? )
			// InternalC.g:6128:20: '0' ( 'x' | 'X' ) ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )?
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
			// InternalC.g:6128:34: ( RULE_HEX_DIGIT )+
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
					// InternalC.g:
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

			// InternalC.g:6128:50: ( RULE_INTEGER_TYPE_SUFFIX )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='L'||LA5_0=='U'||LA5_0=='l'||LA5_0=='u') ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// InternalC.g:6128:50: RULE_INTEGER_TYPE_SUFFIX
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
			// InternalC.g:6130:22: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( RULE_INTEGER_TYPE_SUFFIX )? )
			// InternalC.g:6130:24: ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( RULE_INTEGER_TYPE_SUFFIX )?
			{
			// InternalC.g:6130:24: ( '0' | '1' .. '9' ( '0' .. '9' )* )
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
					// InternalC.g:6130:25: '0'
					{
					match('0'); 
					}
					break;
				case 2 :
					// InternalC.g:6130:29: '1' .. '9' ( '0' .. '9' )*
					{
					matchRange('1','9'); 
					// InternalC.g:6130:38: ( '0' .. '9' )*
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
							alt6=1;
						}

						switch (alt6) {
						case 1 :
							// InternalC.g:
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

			// InternalC.g:6130:51: ( RULE_INTEGER_TYPE_SUFFIX )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0=='L'||LA8_0=='U'||LA8_0=='l'||LA8_0=='u') ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// InternalC.g:6130:51: RULE_INTEGER_TYPE_SUFFIX
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
			// InternalC.g:6132:20: ( '0' ( '0' .. '7' )+ ( RULE_INTEGER_TYPE_SUFFIX )? )
			// InternalC.g:6132:22: '0' ( '0' .. '7' )+ ( RULE_INTEGER_TYPE_SUFFIX )?
			{
			match('0'); 
			// InternalC.g:6132:26: ( '0' .. '7' )+
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
					// InternalC.g:
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

			// InternalC.g:6132:38: ( RULE_INTEGER_TYPE_SUFFIX )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='L'||LA10_0=='U'||LA10_0=='l'||LA10_0=='u') ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// InternalC.g:6132:38: RULE_INTEGER_TYPE_SUFFIX
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
			// InternalC.g:6134:18: ( ( '0b' | '0B' ) ( '0' .. '1' )+ )
			// InternalC.g:6134:20: ( '0b' | '0B' ) ( '0' .. '1' )+
			{
			// InternalC.g:6134:20: ( '0b' | '0B' )
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
					// InternalC.g:6134:21: '0b'
					{
					match("0b"); 

					}
					break;
				case 2 :
					// InternalC.g:6134:26: '0B'
					{
					match("0B"); 

					}
					break;

			}

			// InternalC.g:6134:32: ( '0' .. '1' )+
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
					// InternalC.g:
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
			// InternalC.g:6136:25: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
			// InternalC.g:
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
			// InternalC.g:6138:35: ( ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? ) )
			// InternalC.g:6138:37: ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? )
			{
			// InternalC.g:6138:37: ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? )
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
					// InternalC.g:6138:38: ( 'u' | 'U' )? ( 'l' | 'L' )
					{
					// InternalC.g:6138:38: ( 'u' | 'U' )?
					int alt13=2;
					int LA13_0 = input.LA(1);
					if ( (LA13_0=='U'||LA13_0=='u') ) {
						alt13=1;
					}
					switch (alt13) {
						case 1 :
							// InternalC.g:
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
					// InternalC.g:6138:59: ( 'u' | 'U' ) ( 'l' | 'L' )?
					{
					if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// InternalC.g:6138:69: ( 'l' | 'L' )?
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0=='L'||LA14_0=='l') ) {
						alt14=1;
					}
					switch (alt14) {
						case 1 :
							// InternalC.g:
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
			// InternalC.g:6140:20: ( ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | '.' ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX ) )
			// InternalC.g:6140:22: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | '.' ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )
			{
			// InternalC.g:6140:22: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | '.' ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )
			int alt27=4;
			alt27 = dfa27.predict(input);
			switch (alt27) {
				case 1 :
					// InternalC.g:6140:23: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )?
					{
					// InternalC.g:6140:23: ( '0' .. '9' )+
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
							// InternalC.g:
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

					match('.'); 
					// InternalC.g:6140:39: ( '0' .. '9' )*
					loop17:
					while (true) {
						int alt17=2;
						int LA17_0 = input.LA(1);
						if ( ((LA17_0 >= '0' && LA17_0 <= '9')) ) {
							alt17=1;
						}

						switch (alt17) {
						case 1 :
							// InternalC.g:
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

					// InternalC.g:6140:51: ( RULE_EXPONENT )?
					int alt18=2;
					int LA18_0 = input.LA(1);
					if ( (LA18_0=='E'||LA18_0=='e') ) {
						alt18=1;
					}
					switch (alt18) {
						case 1 :
							// InternalC.g:6140:51: RULE_EXPONENT
							{
							mRULE_EXPONENT(); 

							}
							break;

					}

					// InternalC.g:6140:66: ( RULE_FLOAT_TYPE_SUFFIX )?
					int alt19=2;
					int LA19_0 = input.LA(1);
					if ( (LA19_0=='D'||LA19_0=='F'||LA19_0=='d'||LA19_0=='f') ) {
						alt19=1;
					}
					switch (alt19) {
						case 1 :
							// InternalC.g:
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
					// InternalC.g:6140:90: '.' ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )?
					{
					match('.'); 
					// InternalC.g:6140:94: ( '0' .. '9' )+
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
							// InternalC.g:
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

					// InternalC.g:6140:106: ( RULE_EXPONENT )?
					int alt21=2;
					int LA21_0 = input.LA(1);
					if ( (LA21_0=='E'||LA21_0=='e') ) {
						alt21=1;
					}
					switch (alt21) {
						case 1 :
							// InternalC.g:6140:106: RULE_EXPONENT
							{
							mRULE_EXPONENT(); 

							}
							break;

					}

					// InternalC.g:6140:121: ( RULE_FLOAT_TYPE_SUFFIX )?
					int alt22=2;
					int LA22_0 = input.LA(1);
					if ( (LA22_0=='D'||LA22_0=='F'||LA22_0=='d'||LA22_0=='f') ) {
						alt22=1;
					}
					switch (alt22) {
						case 1 :
							// InternalC.g:
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
					// InternalC.g:6140:145: ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )?
					{
					// InternalC.g:6140:145: ( '0' .. '9' )+
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
							// InternalC.g:
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

					// InternalC.g:6140:171: ( RULE_FLOAT_TYPE_SUFFIX )?
					int alt24=2;
					int LA24_0 = input.LA(1);
					if ( (LA24_0=='D'||LA24_0=='F'||LA24_0=='d'||LA24_0=='f') ) {
						alt24=1;
					}
					switch (alt24) {
						case 1 :
							// InternalC.g:
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
					// InternalC.g:6140:195: ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX
					{
					// InternalC.g:6140:195: ( '0' .. '9' )+
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
							// InternalC.g:
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

					// InternalC.g:6140:207: ( RULE_EXPONENT )?
					int alt26=2;
					int LA26_0 = input.LA(1);
					if ( (LA26_0=='E'||LA26_0=='e') ) {
						alt26=1;
					}
					switch (alt26) {
						case 1 :
							// InternalC.g:6140:207: RULE_EXPONENT
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
			// InternalC.g:6142:24: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
			// InternalC.g:6142:26: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// InternalC.g:6142:36: ( '+' | '-' )?
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0=='+'||LA28_0=='-') ) {
				alt28=1;
			}
			switch (alt28) {
				case 1 :
					// InternalC.g:
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

			// InternalC.g:6142:47: ( '0' .. '9' )+
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
					// InternalC.g:
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
			// InternalC.g:6144:33: ( ( 'f' | 'F' | 'd' | 'D' ) )
			// InternalC.g:
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
			// InternalC.g:6146:31: ( ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | RULE_OCTAL_ESCAPE ) )
			// InternalC.g:6146:33: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | RULE_OCTAL_ESCAPE )
			{
			// InternalC.g:6146:33: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | RULE_OCTAL_ESCAPE )
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
					// InternalC.g:6146:34: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
					{
					match('\\'); 
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
					// InternalC.g:6146:75: RULE_OCTAL_ESCAPE
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
			// InternalC.g:6148:28: ( ( '\\\\' '0' .. '3' '0' .. '7' '0' .. '7' | '\\\\' '0' .. '7' '0' .. '7' | '\\\\' '0' .. '7' ) )
			// InternalC.g:6148:30: ( '\\\\' '0' .. '3' '0' .. '7' '0' .. '7' | '\\\\' '0' .. '7' '0' .. '7' | '\\\\' '0' .. '7' )
			{
			// InternalC.g:6148:30: ( '\\\\' '0' .. '3' '0' .. '7' '0' .. '7' | '\\\\' '0' .. '7' '0' .. '7' | '\\\\' '0' .. '7' )
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
					// InternalC.g:6148:31: '\\\\' '0' .. '3' '0' .. '7' '0' .. '7'
					{
					match('\\'); 
					matchRange('0','3'); 
					matchRange('0','7'); 
					matchRange('0','7'); 
					}
					break;
				case 2 :
					// InternalC.g:6148:63: '\\\\' '0' .. '7' '0' .. '7'
					{
					match('\\'); 
					matchRange('0','7'); 
					matchRange('0','7'); 
					}
					break;
				case 3 :
					// InternalC.g:6148:86: '\\\\' '0' .. '7'
					{
					match('\\'); 
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
			// InternalC.g:6150:30: ( '\\\\' 'u' RULE_HEX_DIGIT RULE_HEX_DIGIT RULE_HEX_DIGIT RULE_HEX_DIGIT )
			// InternalC.g:6150:32: '\\\\' 'u' RULE_HEX_DIGIT RULE_HEX_DIGIT RULE_HEX_DIGIT RULE_HEX_DIGIT
			{
			match('\\'); 
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
			// InternalC.g:6152:20: ( '#' ( RULE_WHITESPACE )? RULE_DECIMAL_LITERAL ( RULE_WHITESPACE )? RULE_STRING_LITERAL (~ ( RULE_NEWLINE ) )* )
			// InternalC.g:6152:22: '#' ( RULE_WHITESPACE )? RULE_DECIMAL_LITERAL ( RULE_WHITESPACE )? RULE_STRING_LITERAL (~ ( RULE_NEWLINE ) )*
			{
			match('#'); 
			// InternalC.g:6152:26: ( RULE_WHITESPACE )?
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0=='\t'||LA32_0==' ') ) {
				alt32=1;
			}
			switch (alt32) {
				case 1 :
					// InternalC.g:6152:26: RULE_WHITESPACE
					{
					mRULE_WHITESPACE(); 

					}
					break;

			}

			mRULE_DECIMAL_LITERAL(); 

			// InternalC.g:6152:64: ( RULE_WHITESPACE )?
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( (LA33_0=='\t'||LA33_0==' ') ) {
				alt33=1;
			}
			switch (alt33) {
				case 1 :
					// InternalC.g:6152:64: RULE_WHITESPACE
					{
					mRULE_WHITESPACE(); 

					}
					break;

			}

			mRULE_STRING_LITERAL(); 

			// InternalC.g:6152:101: (~ ( RULE_NEWLINE ) )*
			loop34:
			while (true) {
				int alt34=2;
				int LA34_0 = input.LA(1);
				if ( ((LA34_0 >= '\u0000' && LA34_0 <= '\t')||(LA34_0 >= '\u000B' && LA34_0 <= '\f')||(LA34_0 >= '\u000E' && LA34_0 <= '\uFFFF')) ) {
					alt34=1;
				}

				switch (alt34) {
				case 1 :
					// InternalC.g:
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
					break loop34;
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

	// $ANTLR start "RULE_PRAGMADIRECTIVE"
	public final void mRULE_PRAGMADIRECTIVE() throws RecognitionException {
		try {
			int _type = RULE_PRAGMADIRECTIVE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6154:22: ( '#' ( RULE_WHITESPACE )? RULE_KW_PRAGMA RULE_WHITESPACE (~ ( RULE_NEWLINE ) )* )
			// InternalC.g:6154:24: '#' ( RULE_WHITESPACE )? RULE_KW_PRAGMA RULE_WHITESPACE (~ ( RULE_NEWLINE ) )*
			{
			match('#'); 
			// InternalC.g:6154:28: ( RULE_WHITESPACE )?
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0=='\t'||LA35_0==' ') ) {
				alt35=1;
			}
			switch (alt35) {
				case 1 :
					// InternalC.g:6154:28: RULE_WHITESPACE
					{
					mRULE_WHITESPACE(); 

					}
					break;

			}

			mRULE_KW_PRAGMA(); 

			mRULE_WHITESPACE(); 

			// InternalC.g:6154:76: (~ ( RULE_NEWLINE ) )*
			loop36:
			while (true) {
				int alt36=2;
				int LA36_0 = input.LA(1);
				if ( ((LA36_0 >= '\u0000' && LA36_0 <= '\t')||(LA36_0 >= '\u000B' && LA36_0 <= '\f')||(LA36_0 >= '\u000E' && LA36_0 <= '\uFFFF')) ) {
					alt36=1;
				}

				switch (alt36) {
				case 1 :
					// InternalC.g:
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
					break loop36;
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
	// $ANTLR end "RULE_PRAGMADIRECTIVE"

	// $ANTLR start "RULE_WHITESPACE"
	public final void mRULE_WHITESPACE() throws RecognitionException {
		try {
			int _type = RULE_WHITESPACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalC.g:6156:17: ( ( ' ' | '\\t' )+ )
			// InternalC.g:6156:19: ( ' ' | '\\t' )+
			{
			// InternalC.g:6156:19: ( ' ' | '\\t' )+
			int cnt37=0;
			loop37:
			while (true) {
				int alt37=2;
				int LA37_0 = input.LA(1);
				if ( (LA37_0=='\t'||LA37_0==' ') ) {
					alt37=1;
				}

				switch (alt37) {
				case 1 :
					// InternalC.g:
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
					if ( cnt37 >= 1 ) break loop37;
					EarlyExitException eee = new EarlyExitException(37, input);
					throw eee;
				}
				cnt37++;
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
			// InternalC.g:6158:20: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// InternalC.g:6158:22: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// InternalC.g:6158:27: ( options {greedy=false; } : . )*
			loop38:
			while (true) {
				int alt38=2;
				int LA38_0 = input.LA(1);
				if ( (LA38_0=='*') ) {
					int LA38_1 = input.LA(2);
					if ( (LA38_1=='/') ) {
						alt38=2;
					}
					else if ( ((LA38_1 >= '\u0000' && LA38_1 <= '.')||(LA38_1 >= '0' && LA38_1 <= '\uFFFF')) ) {
						alt38=1;
					}

				}
				else if ( ((LA38_0 >= '\u0000' && LA38_0 <= ')')||(LA38_0 >= '+' && LA38_0 <= '\uFFFF')) ) {
					alt38=1;
				}

				switch (alt38) {
				case 1 :
					// InternalC.g:6158:55: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop38;
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
			// InternalC.g:6160:19: ( '//' (~ ( RULE_NEWLINE ) )* )
			// InternalC.g:6160:21: '//' (~ ( RULE_NEWLINE ) )*
			{
			match("//"); 

			// InternalC.g:6160:26: (~ ( RULE_NEWLINE ) )*
			loop39:
			while (true) {
				int alt39=2;
				int LA39_0 = input.LA(1);
				if ( ((LA39_0 >= '\u0000' && LA39_0 <= '\t')||(LA39_0 >= '\u000B' && LA39_0 <= '\f')||(LA39_0 >= '\u000E' && LA39_0 <= '\uFFFF')) ) {
					alt39=1;
				}

				switch (alt39) {
				case 1 :
					// InternalC.g:
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
					break loop39;
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
			// InternalC.g:6162:14: ( ( '\\r' | '\\n' ) )
			// InternalC.g:
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

	@Override
	public void mTokens() throws RecognitionException {
		// InternalC.g:1:8: ( T__123 | T__124 | T__125 | RULE_KW_UNDERSCORE | RULE_KW_AUTO | RULE_KW_BREAK | RULE_KW_CASE | RULE_KW_CHAR | RULE_KW_CONST | RULE_KW_CONTINUE | RULE_KW_DEFAULT | RULE_KW_DO | RULE_KW_DOUBLE | RULE_KW_ELSE | RULE_KW_ENUM | RULE_KW_EXTERN | RULE_KW_FLOAT | RULE_KW_FOR | RULE_KW_GOTO | RULE_KW_IF | RULE_KW_INLINE | RULE_KW_INT | RULE_KW_LONG | RULE_KW_REGISTER | RULE_KW_RESTRICT | RULE_KW_RETURN | RULE_KW_SHORT | RULE_KW_SIGNED | RULE_KW_SIZEOF | RULE_KW_STATIC | RULE_KW_STRUCT | RULE_KW_SWITCH | RULE_KW_TYPEDEF | RULE_KW_UNION | RULE_KW_UNSIGNED | RULE_KW_VOID | RULE_KW_VOLATILE | RULE_KW_WHILE | RULE_KW_ALIGNAS | RULE_KW_ALIGNOF | RULE_KW_ASM | RULE_KW_ATOMIC | RULE_KW_BOOL | RULE_KW_COMPLEX | RULE_KW_GENERIC | RULE_KW_IMAGINARY | RULE_KW_NORETURN | RULE_KW_STATICASSERT | RULE_KW_THREADLOCAL | RULE_LEFTPAREN | RULE_RIGHTPAREN | RULE_LEFTBRACKET | RULE_RIGHTBRACKET | RULE_LEFTBRACE | RULE_RIGHTBRACE | RULE_LESS | RULE_LESSEQUAL | RULE_GREATER | RULE_GREATEREQUAL | RULE_LEFTSHIFT | RULE_RIGHTSHIFT | RULE_PLUS | RULE_PLUSPLUS | RULE_MINUS | RULE_MINUSMINUS | RULE_STAR | RULE_DIV | RULE_MOD | RULE_AND | RULE_ANDAND | RULE_OR | RULE_OROR | RULE_CARET | RULE_NOT | RULE_TILDE | RULE_QUESTION | RULE_COLON | RULE_SEMI | RULE_COMMA | RULE_ASSIGN | RULE_STARASSIGN | RULE_DIVASSIGN | RULE_MODASSIGN | RULE_PLUSASSIGN | RULE_MINUSASSIGN | RULE_LEFTSHIFTASSIGN | RULE_RIGHTSHIFTASSIGN | RULE_ANDASSIGN | RULE_XORASSIGN | RULE_ORASSIGN | RULE_EQUAL | RULE_NOTEQUAL | RULE_ARROW | RULE_ELLIPSIS | RULE_SINGLEQUOTE | RULE_DOUBLEQUOTE | RULE_BACKSLASH | RULE_ID | RULE_CHAR_LITERAL | RULE_STRING_LITERAL | RULE_HEX_LITERAL | RULE_DECIMAL_LITERAL | RULE_OCTAL_LITERAL | RULE_BIN_LITERAL | RULE_FLOAT_LITERAL | RULE_LINEDIRECTIVE | RULE_PRAGMADIRECTIVE | RULE_WHITESPACE | RULE_BLOCK_COMMENT | RULE_LINE_COMMENT | RULE_NEWLINE )
		int alt40=111;
		alt40 = dfa40.predict(input);
		switch (alt40) {
			case 1 :
				// InternalC.g:1:10: T__123
				{
				mT__123(); 

				}
				break;
			case 2 :
				// InternalC.g:1:17: T__124
				{
				mT__124(); 

				}
				break;
			case 3 :
				// InternalC.g:1:24: T__125
				{
				mT__125(); 

				}
				break;
			case 4 :
				// InternalC.g:1:31: RULE_KW_UNDERSCORE
				{
				mRULE_KW_UNDERSCORE(); 

				}
				break;
			case 5 :
				// InternalC.g:1:50: RULE_KW_AUTO
				{
				mRULE_KW_AUTO(); 

				}
				break;
			case 6 :
				// InternalC.g:1:63: RULE_KW_BREAK
				{
				mRULE_KW_BREAK(); 

				}
				break;
			case 7 :
				// InternalC.g:1:77: RULE_KW_CASE
				{
				mRULE_KW_CASE(); 

				}
				break;
			case 8 :
				// InternalC.g:1:90: RULE_KW_CHAR
				{
				mRULE_KW_CHAR(); 

				}
				break;
			case 9 :
				// InternalC.g:1:103: RULE_KW_CONST
				{
				mRULE_KW_CONST(); 

				}
				break;
			case 10 :
				// InternalC.g:1:117: RULE_KW_CONTINUE
				{
				mRULE_KW_CONTINUE(); 

				}
				break;
			case 11 :
				// InternalC.g:1:134: RULE_KW_DEFAULT
				{
				mRULE_KW_DEFAULT(); 

				}
				break;
			case 12 :
				// InternalC.g:1:150: RULE_KW_DO
				{
				mRULE_KW_DO(); 

				}
				break;
			case 13 :
				// InternalC.g:1:161: RULE_KW_DOUBLE
				{
				mRULE_KW_DOUBLE(); 

				}
				break;
			case 14 :
				// InternalC.g:1:176: RULE_KW_ELSE
				{
				mRULE_KW_ELSE(); 

				}
				break;
			case 15 :
				// InternalC.g:1:189: RULE_KW_ENUM
				{
				mRULE_KW_ENUM(); 

				}
				break;
			case 16 :
				// InternalC.g:1:202: RULE_KW_EXTERN
				{
				mRULE_KW_EXTERN(); 

				}
				break;
			case 17 :
				// InternalC.g:1:217: RULE_KW_FLOAT
				{
				mRULE_KW_FLOAT(); 

				}
				break;
			case 18 :
				// InternalC.g:1:231: RULE_KW_FOR
				{
				mRULE_KW_FOR(); 

				}
				break;
			case 19 :
				// InternalC.g:1:243: RULE_KW_GOTO
				{
				mRULE_KW_GOTO(); 

				}
				break;
			case 20 :
				// InternalC.g:1:256: RULE_KW_IF
				{
				mRULE_KW_IF(); 

				}
				break;
			case 21 :
				// InternalC.g:1:267: RULE_KW_INLINE
				{
				mRULE_KW_INLINE(); 

				}
				break;
			case 22 :
				// InternalC.g:1:282: RULE_KW_INT
				{
				mRULE_KW_INT(); 

				}
				break;
			case 23 :
				// InternalC.g:1:294: RULE_KW_LONG
				{
				mRULE_KW_LONG(); 

				}
				break;
			case 24 :
				// InternalC.g:1:307: RULE_KW_REGISTER
				{
				mRULE_KW_REGISTER(); 

				}
				break;
			case 25 :
				// InternalC.g:1:324: RULE_KW_RESTRICT
				{
				mRULE_KW_RESTRICT(); 

				}
				break;
			case 26 :
				// InternalC.g:1:341: RULE_KW_RETURN
				{
				mRULE_KW_RETURN(); 

				}
				break;
			case 27 :
				// InternalC.g:1:356: RULE_KW_SHORT
				{
				mRULE_KW_SHORT(); 

				}
				break;
			case 28 :
				// InternalC.g:1:370: RULE_KW_SIGNED
				{
				mRULE_KW_SIGNED(); 

				}
				break;
			case 29 :
				// InternalC.g:1:385: RULE_KW_SIZEOF
				{
				mRULE_KW_SIZEOF(); 

				}
				break;
			case 30 :
				// InternalC.g:1:400: RULE_KW_STATIC
				{
				mRULE_KW_STATIC(); 

				}
				break;
			case 31 :
				// InternalC.g:1:415: RULE_KW_STRUCT
				{
				mRULE_KW_STRUCT(); 

				}
				break;
			case 32 :
				// InternalC.g:1:430: RULE_KW_SWITCH
				{
				mRULE_KW_SWITCH(); 

				}
				break;
			case 33 :
				// InternalC.g:1:445: RULE_KW_TYPEDEF
				{
				mRULE_KW_TYPEDEF(); 

				}
				break;
			case 34 :
				// InternalC.g:1:461: RULE_KW_UNION
				{
				mRULE_KW_UNION(); 

				}
				break;
			case 35 :
				// InternalC.g:1:475: RULE_KW_UNSIGNED
				{
				mRULE_KW_UNSIGNED(); 

				}
				break;
			case 36 :
				// InternalC.g:1:492: RULE_KW_VOID
				{
				mRULE_KW_VOID(); 

				}
				break;
			case 37 :
				// InternalC.g:1:505: RULE_KW_VOLATILE
				{
				mRULE_KW_VOLATILE(); 

				}
				break;
			case 38 :
				// InternalC.g:1:522: RULE_KW_WHILE
				{
				mRULE_KW_WHILE(); 

				}
				break;
			case 39 :
				// InternalC.g:1:536: RULE_KW_ALIGNAS
				{
				mRULE_KW_ALIGNAS(); 

				}
				break;
			case 40 :
				// InternalC.g:1:552: RULE_KW_ALIGNOF
				{
				mRULE_KW_ALIGNOF(); 

				}
				break;
			case 41 :
				// InternalC.g:1:568: RULE_KW_ASM
				{
				mRULE_KW_ASM(); 

				}
				break;
			case 42 :
				// InternalC.g:1:580: RULE_KW_ATOMIC
				{
				mRULE_KW_ATOMIC(); 

				}
				break;
			case 43 :
				// InternalC.g:1:595: RULE_KW_BOOL
				{
				mRULE_KW_BOOL(); 

				}
				break;
			case 44 :
				// InternalC.g:1:608: RULE_KW_COMPLEX
				{
				mRULE_KW_COMPLEX(); 

				}
				break;
			case 45 :
				// InternalC.g:1:624: RULE_KW_GENERIC
				{
				mRULE_KW_GENERIC(); 

				}
				break;
			case 46 :
				// InternalC.g:1:640: RULE_KW_IMAGINARY
				{
				mRULE_KW_IMAGINARY(); 

				}
				break;
			case 47 :
				// InternalC.g:1:658: RULE_KW_NORETURN
				{
				mRULE_KW_NORETURN(); 

				}
				break;
			case 48 :
				// InternalC.g:1:675: RULE_KW_STATICASSERT
				{
				mRULE_KW_STATICASSERT(); 

				}
				break;
			case 49 :
				// InternalC.g:1:696: RULE_KW_THREADLOCAL
				{
				mRULE_KW_THREADLOCAL(); 

				}
				break;
			case 50 :
				// InternalC.g:1:716: RULE_LEFTPAREN
				{
				mRULE_LEFTPAREN(); 

				}
				break;
			case 51 :
				// InternalC.g:1:731: RULE_RIGHTPAREN
				{
				mRULE_RIGHTPAREN(); 

				}
				break;
			case 52 :
				// InternalC.g:1:747: RULE_LEFTBRACKET
				{
				mRULE_LEFTBRACKET(); 

				}
				break;
			case 53 :
				// InternalC.g:1:764: RULE_RIGHTBRACKET
				{
				mRULE_RIGHTBRACKET(); 

				}
				break;
			case 54 :
				// InternalC.g:1:782: RULE_LEFTBRACE
				{
				mRULE_LEFTBRACE(); 

				}
				break;
			case 55 :
				// InternalC.g:1:797: RULE_RIGHTBRACE
				{
				mRULE_RIGHTBRACE(); 

				}
				break;
			case 56 :
				// InternalC.g:1:813: RULE_LESS
				{
				mRULE_LESS(); 

				}
				break;
			case 57 :
				// InternalC.g:1:823: RULE_LESSEQUAL
				{
				mRULE_LESSEQUAL(); 

				}
				break;
			case 58 :
				// InternalC.g:1:838: RULE_GREATER
				{
				mRULE_GREATER(); 

				}
				break;
			case 59 :
				// InternalC.g:1:851: RULE_GREATEREQUAL
				{
				mRULE_GREATEREQUAL(); 

				}
				break;
			case 60 :
				// InternalC.g:1:869: RULE_LEFTSHIFT
				{
				mRULE_LEFTSHIFT(); 

				}
				break;
			case 61 :
				// InternalC.g:1:884: RULE_RIGHTSHIFT
				{
				mRULE_RIGHTSHIFT(); 

				}
				break;
			case 62 :
				// InternalC.g:1:900: RULE_PLUS
				{
				mRULE_PLUS(); 

				}
				break;
			case 63 :
				// InternalC.g:1:910: RULE_PLUSPLUS
				{
				mRULE_PLUSPLUS(); 

				}
				break;
			case 64 :
				// InternalC.g:1:924: RULE_MINUS
				{
				mRULE_MINUS(); 

				}
				break;
			case 65 :
				// InternalC.g:1:935: RULE_MINUSMINUS
				{
				mRULE_MINUSMINUS(); 

				}
				break;
			case 66 :
				// InternalC.g:1:951: RULE_STAR
				{
				mRULE_STAR(); 

				}
				break;
			case 67 :
				// InternalC.g:1:961: RULE_DIV
				{
				mRULE_DIV(); 

				}
				break;
			case 68 :
				// InternalC.g:1:970: RULE_MOD
				{
				mRULE_MOD(); 

				}
				break;
			case 69 :
				// InternalC.g:1:979: RULE_AND
				{
				mRULE_AND(); 

				}
				break;
			case 70 :
				// InternalC.g:1:988: RULE_ANDAND
				{
				mRULE_ANDAND(); 

				}
				break;
			case 71 :
				// InternalC.g:1:1000: RULE_OR
				{
				mRULE_OR(); 

				}
				break;
			case 72 :
				// InternalC.g:1:1008: RULE_OROR
				{
				mRULE_OROR(); 

				}
				break;
			case 73 :
				// InternalC.g:1:1018: RULE_CARET
				{
				mRULE_CARET(); 

				}
				break;
			case 74 :
				// InternalC.g:1:1029: RULE_NOT
				{
				mRULE_NOT(); 

				}
				break;
			case 75 :
				// InternalC.g:1:1038: RULE_TILDE
				{
				mRULE_TILDE(); 

				}
				break;
			case 76 :
				// InternalC.g:1:1049: RULE_QUESTION
				{
				mRULE_QUESTION(); 

				}
				break;
			case 77 :
				// InternalC.g:1:1063: RULE_COLON
				{
				mRULE_COLON(); 

				}
				break;
			case 78 :
				// InternalC.g:1:1074: RULE_SEMI
				{
				mRULE_SEMI(); 

				}
				break;
			case 79 :
				// InternalC.g:1:1084: RULE_COMMA
				{
				mRULE_COMMA(); 

				}
				break;
			case 80 :
				// InternalC.g:1:1095: RULE_ASSIGN
				{
				mRULE_ASSIGN(); 

				}
				break;
			case 81 :
				// InternalC.g:1:1107: RULE_STARASSIGN
				{
				mRULE_STARASSIGN(); 

				}
				break;
			case 82 :
				// InternalC.g:1:1123: RULE_DIVASSIGN
				{
				mRULE_DIVASSIGN(); 

				}
				break;
			case 83 :
				// InternalC.g:1:1138: RULE_MODASSIGN
				{
				mRULE_MODASSIGN(); 

				}
				break;
			case 84 :
				// InternalC.g:1:1153: RULE_PLUSASSIGN
				{
				mRULE_PLUSASSIGN(); 

				}
				break;
			case 85 :
				// InternalC.g:1:1169: RULE_MINUSASSIGN
				{
				mRULE_MINUSASSIGN(); 

				}
				break;
			case 86 :
				// InternalC.g:1:1186: RULE_LEFTSHIFTASSIGN
				{
				mRULE_LEFTSHIFTASSIGN(); 

				}
				break;
			case 87 :
				// InternalC.g:1:1207: RULE_RIGHTSHIFTASSIGN
				{
				mRULE_RIGHTSHIFTASSIGN(); 

				}
				break;
			case 88 :
				// InternalC.g:1:1229: RULE_ANDASSIGN
				{
				mRULE_ANDASSIGN(); 

				}
				break;
			case 89 :
				// InternalC.g:1:1244: RULE_XORASSIGN
				{
				mRULE_XORASSIGN(); 

				}
				break;
			case 90 :
				// InternalC.g:1:1259: RULE_ORASSIGN
				{
				mRULE_ORASSIGN(); 

				}
				break;
			case 91 :
				// InternalC.g:1:1273: RULE_EQUAL
				{
				mRULE_EQUAL(); 

				}
				break;
			case 92 :
				// InternalC.g:1:1284: RULE_NOTEQUAL
				{
				mRULE_NOTEQUAL(); 

				}
				break;
			case 93 :
				// InternalC.g:1:1298: RULE_ARROW
				{
				mRULE_ARROW(); 

				}
				break;
			case 94 :
				// InternalC.g:1:1309: RULE_ELLIPSIS
				{
				mRULE_ELLIPSIS(); 

				}
				break;
			case 95 :
				// InternalC.g:1:1323: RULE_SINGLEQUOTE
				{
				mRULE_SINGLEQUOTE(); 

				}
				break;
			case 96 :
				// InternalC.g:1:1340: RULE_DOUBLEQUOTE
				{
				mRULE_DOUBLEQUOTE(); 

				}
				break;
			case 97 :
				// InternalC.g:1:1357: RULE_BACKSLASH
				{
				mRULE_BACKSLASH(); 

				}
				break;
			case 98 :
				// InternalC.g:1:1372: RULE_ID
				{
				mRULE_ID(); 

				}
				break;
			case 99 :
				// InternalC.g:1:1380: RULE_CHAR_LITERAL
				{
				mRULE_CHAR_LITERAL(); 

				}
				break;
			case 100 :
				// InternalC.g:1:1398: RULE_STRING_LITERAL
				{
				mRULE_STRING_LITERAL(); 

				}
				break;
			case 101 :
				// InternalC.g:1:1418: RULE_HEX_LITERAL
				{
				mRULE_HEX_LITERAL(); 

				}
				break;
			case 102 :
				// InternalC.g:1:1435: RULE_DECIMAL_LITERAL
				{
				mRULE_DECIMAL_LITERAL(); 

				}
				break;
			case 103 :
				// InternalC.g:1:1456: RULE_OCTAL_LITERAL
				{
				mRULE_OCTAL_LITERAL(); 

				}
				break;
			case 104 :
				// InternalC.g:1:1475: RULE_BIN_LITERAL
				{
				mRULE_BIN_LITERAL(); 

				}
				break;
			case 105 :
				// InternalC.g:1:1492: RULE_FLOAT_LITERAL
				{
				mRULE_FLOAT_LITERAL(); 

				}
				break;
			case 106 :
				// InternalC.g:1:1511: RULE_LINEDIRECTIVE
				{
				mRULE_LINEDIRECTIVE(); 

				}
				break;
			case 107 :
				// InternalC.g:1:1530: RULE_PRAGMADIRECTIVE
				{
				mRULE_PRAGMADIRECTIVE(); 

				}
				break;
			case 108 :
				// InternalC.g:1:1551: RULE_WHITESPACE
				{
				mRULE_WHITESPACE(); 

				}
				break;
			case 109 :
				// InternalC.g:1:1567: RULE_BLOCK_COMMENT
				{
				mRULE_BLOCK_COMMENT(); 

				}
				break;
			case 110 :
				// InternalC.g:1:1586: RULE_LINE_COMMENT
				{
				mRULE_LINE_COMMENT(); 

				}
				break;
			case 111 :
				// InternalC.g:1:1604: RULE_NEWLINE
				{
				mRULE_NEWLINE(); 

				}
				break;

		}
	}


	protected DFA27 dfa27 = new DFA27(this);
	protected DFA40 dfa40 = new DFA40(this);
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
			return "6140:22: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | '.' ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )";
		}
	}


	static final String DFA40_eotS =
		"\1\uffff\1\73\17\54\6\uffff\1\126\1\131\1\134\1\137\1\143\1\147\1\151\1\153\1\156\1\161\1\163\5\uffff\1\165\1\uffff\1\171\1\173\2\uffff\2\177\3\uffff\11\54\1\uffff\7\54\1\u0097\6\54\1\u009e\13\54\2\uffff\1\u00b1\2\uffff\1\u00b3\44\uffff\1\u00b5\1\177\3\uffff\13\54\1\u00c1\6\54\1\uffff\4\54\1\u00cd\1\54\1\uffff\1\54\1\u00d0\20\54\5\uffff\12\54\1\u00eb\1\uffff\1\54\1\u00ed\1\u00ee\4\54\1\u00f3\1\u00f4\2\54\1\uffff\1\u00f7\1\54\1\uffff\1\u00f9\14\54\1\u0106\5\54\1\u010c\6\54\1\uffff\1\u0113\2\uffff\1\u0114\3\54\2\uffff\1\54\1\u0119\1\uffff\1\54\1\uffff\3\54\1\u011e\6\54\1\u0125\1\54\1\uffff\1\54\1\u0128\1\u012b\2\54\1\uffff\6\54\2\uffff\2\54\1\u0137\1\u0138\1\uffff\1\u0139\2\54\1\u013c\1\uffff\1\u013d\1\u013e\1\u013f\1\u0140\1\u0141\1\54\1\uffff\2\54\1\uffff\1\u0145\1\u0146\1\uffff\2\54\1\u0149\7\54\1\u0151\3\uffff\2\54\6\uffff\1\u0154\2\54\2\uffff\1\u0157\1\u0158\1\uffff\1\u0159\1\u015a\4\54\1\u015f\1\uffff\1\u0160\1\u0161\1\uffff\1\u0162\1\u0163\4\uffff\1\54\1\u0165\2\54\5\uffff\1\u0168\1\uffff\2\54\1\uffff\5\54\1\u0170\1\u0171\2\uffff";
	static final String DFA40_eofS =
		"\u0172\uffff";
	static final String DFA40_minS =
		"\1\11\1\44\1\163\1\162\1\141\1\145\2\154\1\157\1\146\1\157\1\145\1\150\1\171\1\156\1\157\1\150\6\uffff\1\74\1\75\1\53\1\55\1\75\1\52\1\75\1\46\3\75\5\uffff\1\75\1\56\2\0\2\uffff\2\56\1\11\2\uffff\1\155\1\154\2\157\1\145\1\155\1\157\1\164\1\150\1\uffff\1\164\1\155\1\145\1\163\1\141\1\156\1\146\1\44\1\163\1\165\1\164\1\157\1\162\1\164\1\44\1\154\1\156\1\147\1\157\1\147\1\141\1\151\1\160\3\151\2\uffff\1\75\2\uffff\1\75\44\uffff\2\56\1\11\2\uffff\1\61\1\151\2\157\1\155\1\156\1\141\1\162\1\141\1\162\1\157\1\44\1\141\1\145\1\162\1\163\1\141\1\142\1\uffff\1\145\1\155\1\145\1\141\1\44\1\157\1\uffff\1\151\1\44\1\147\1\151\1\164\1\165\1\162\1\156\1\145\1\164\1\165\1\164\1\145\1\157\1\151\1\144\1\141\1\154\5\uffff\1\62\1\147\1\155\1\154\1\160\1\145\1\147\1\145\1\164\1\145\1\44\1\uffff\1\153\2\44\1\164\1\151\1\165\1\154\2\44\1\162\1\164\1\uffff\1\44\1\156\1\uffff\1\44\1\163\2\162\1\164\1\145\1\157\1\151\2\143\1\144\1\156\1\147\1\44\1\164\1\145\1\70\1\156\1\151\1\44\1\154\1\162\1\151\1\164\1\151\1\141\1\uffff\1\44\2\uffff\1\44\1\156\1\154\1\145\2\uffff\1\156\1\44\1\uffff\1\145\1\uffff\1\164\1\151\1\156\1\44\1\144\1\146\1\143\1\164\1\150\1\145\1\44\1\156\1\uffff\1\151\2\44\1\141\1\143\1\uffff\1\145\1\151\1\156\1\165\1\143\1\144\2\uffff\1\165\1\164\2\44\1\uffff\1\44\1\145\1\143\1\44\1\uffff\5\44\1\146\1\uffff\1\145\1\154\1\uffff\2\44\1\uffff\1\163\1\146\1\44\1\170\1\143\1\141\1\162\2\137\1\145\1\44\3\uffff\1\162\1\164\6\uffff\1\44\1\144\1\145\2\uffff\2\44\1\uffff\2\44\1\162\1\156\1\141\1\154\1\44\1\uffff\2\44\1\uffff\2\44\4\uffff\1\171\1\44\1\163\1\157\5\uffff\1\44\1\uffff\1\163\1\143\1\uffff\1\145\1\141\1\162\1\154\1\164\2\44\2\uffff";
	static final String DFA40_maxS =
		"\1\176\1\172\1\165\1\162\2\157\1\170\2\157\1\156\1\157\1\145\1\167\1\171\1\156\1\157\1\150\6\uffff\1\75\1\76\1\75\1\76\4\75\1\174\2\75\5\uffff\1\75\1\71\2\uffff\2\uffff\1\170\1\146\1\160\2\uffff\1\155\1\164\2\157\1\145\1\155\1\157\1\164\1\150\1\uffff\1\164\1\155\1\145\1\163\1\141\1\156\1\146\1\172\1\163\1\165\1\164\1\157\1\162\1\164\1\172\1\164\1\156\1\164\1\157\1\172\1\162\1\151\1\160\1\163\1\154\1\151\2\uffff\1\75\2\uffff\1\75\44\uffff\2\146\1\160\2\uffff\1\61\1\151\2\157\1\155\1\156\1\141\1\162\1\141\1\162\1\157\1\172\1\141\1\145\1\162\1\164\1\141\1\142\1\uffff\1\145\1\155\1\145\1\141\1\172\1\157\1\uffff\1\151\1\172\1\147\1\151\1\164\1\165\1\162\1\156\1\145\1\164\1\165\1\164\1\145\1\157\1\151\1\144\1\141\1\154\5\uffff\1\62\1\147\1\155\1\154\1\160\1\145\1\147\1\145\1\164\1\145\1\172\1\uffff\1\153\2\172\1\164\1\151\1\165\1\154\2\172\1\162\1\164\1\uffff\1\172\1\156\1\uffff\1\172\1\163\2\162\1\164\1\145\1\157\1\151\2\143\1\144\1\156\1\147\1\172\1\164\1\145\1\70\1\156\1\151\1\172\1\154\1\162\1\151\1\164\1\151\1\141\1\uffff\1\172\2\uffff\1\172\1\156\1\154\1\145\2\uffff\1\156\1\172\1\uffff\1\145\1\uffff\1\164\1\151\1\156\1\172\1\144\1\146\1\143\1\164\1\150\1\145\1\172\1\156\1\uffff\1\151\2\172\1\157\1\143\1\uffff\1\145\1\151\1\156\1\165\1\143\1\144\2\uffff\1\165\1\164\2\172\1\uffff\1\172\1\145\1\143\1\172\1\uffff\5\172\1\146\1\uffff\1\145\1\154\1\uffff\2\172\1\uffff\1\163\1\146\1\172\1\170\1\143\1\141\1\162\2\137\1\145\1\172\3\uffff\1\162\1\164\6\uffff\1\172\1\144\1\145\2\uffff\2\172\1\uffff\2\172\1\162\1\156\1\141\1\154\1\172\1\uffff\2\172\1\uffff\2\172\4\uffff\1\171\1\172\1\163\1\157\5\uffff\1\172\1\uffff\1\163\1\143\1\uffff\1\145\1\141\1\162\1\154\1\164\2\172\2\uffff";
	static final String DFA40_acceptS =
		"\21\uffff\1\62\1\63\1\64\1\65\1\66\1\67\13\uffff\1\113\1\114\1\115\1\116\1\117\4\uffff\1\141\1\142\3\uffff\1\154\1\157\11\uffff\1\4\32\uffff\1\70\1\71\1\uffff\1\72\1\73\1\uffff\1\76\1\77\1\124\1\100\1\101\1\125\1\135\1\102\1\121\1\155\1\156\1\103\1\122\1\104\1\123\1\105\1\106\1\130\1\107\1\110\1\132\1\111\1\131\1\112\1\134\1\120\1\133\1\136\1\151\1\137\1\143\1\140\1\144\1\145\1\150\1\146\3\uffff\1\152\1\153\22\uffff\1\14\6\uffff\1\24\22\uffff\1\74\1\126\1\75\1\127\1\147\13\uffff\1\51\13\uffff\1\22\2\uffff\1\26\32\uffff\1\5\1\uffff\1\7\1\10\4\uffff\1\16\1\17\2\uffff\1\23\1\uffff\1\27\14\uffff\1\44\5\uffff\1\53\6\uffff\1\6\1\11\4\uffff\1\21\4\uffff\1\33\6\uffff\1\42\2\uffff\1\46\2\uffff\1\1\13\uffff\1\15\1\20\1\25\2\uffff\1\32\1\34\1\35\1\36\1\37\1\40\3\uffff\1\2\1\3\2\uffff\1\52\7\uffff\1\13\2\uffff\1\41\2\uffff\1\47\1\50\1\54\1\55\4\uffff\1\12\1\30\1\31\1\43\1\45\1\uffff\1\57\2\uffff\1\56\7\uffff\1\61\1\60";
	static final String DFA40_specialS =
		"\51\uffff\1\1\1\0\u0147\uffff}>";
	static final String[] DFA40_transitionS = {
			"\1\60\1\61\2\uffff\1\61\22\uffff\1\60\1\41\1\52\1\57\1\54\1\35\1\36\1\51\1\21\1\22\1\33\1\31\1\46\1\32\1\50\1\34\1\55\11\56\1\44\1\45\1\27\1\47\1\30\1\43\1\uffff\32\54\1\23\1\53\1\24\1\40\1\1\1\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\54\1\11\2\54\1\12\5\54\1\13\1\14\1\15\1\16\1\17\1\20\3\54\1\25\1\37\1\26\1\42",
			"\1\54\13\uffff\12\54\7\uffff\1\63\1\64\1\65\3\54\1\66\1\54\1\67\4\54\1\70\4\54\1\71\1\72\6\54\4\uffff\1\62\1\uffff\32\54",
			"\1\75\1\uffff\1\74",
			"\1\76",
			"\1\77\6\uffff\1\100\6\uffff\1\101",
			"\1\102\11\uffff\1\103",
			"\1\104\1\uffff\1\105\11\uffff\1\106",
			"\1\107\2\uffff\1\110",
			"\1\111",
			"\1\112\7\uffff\1\113",
			"\1\114",
			"\1\115",
			"\1\116\1\117\12\uffff\1\120\2\uffff\1\121",
			"\1\122",
			"\1\123",
			"\1\124",
			"\1\125",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\130\1\127",
			"\1\132\1\133",
			"\1\135\21\uffff\1\136",
			"\1\140\17\uffff\1\141\1\142",
			"\1\144",
			"\1\145\4\uffff\1\146\15\uffff\1\150",
			"\1\152",
			"\1\154\26\uffff\1\155",
			"\1\160\76\uffff\1\157",
			"\1\162",
			"\1\164",
			"",
			"",
			"",
			"",
			"",
			"\1\166",
			"\1\167\1\uffff\12\170",
			"\47\172\1\uffff\uffd8\172",
			"\0\174",
			"",
			"",
			"\1\170\1\uffff\10\u0080\2\170\10\uffff\1\176\1\uffff\3\170\21\uffff\1\175\11\uffff\1\176\1\uffff\3\170\21\uffff\1\175",
			"\1\170\1\uffff\12\u0081\12\uffff\3\170\35\uffff\3\170",
			"\1\u0082\26\uffff\1\u0082\17\uffff\12\u0083\66\uffff\1\u0084",
			"",
			"",
			"\1\u0085",
			"\1\u0086\7\uffff\1\u0087",
			"\1\u0088",
			"\1\u0089",
			"\1\u008a",
			"\1\u008b",
			"\1\u008c",
			"\1\u008d",
			"\1\u008e",
			"",
			"\1\u008f",
			"\1\u0090",
			"\1\u0091",
			"\1\u0092",
			"\1\u0093",
			"\1\u0094",
			"\1\u0095",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\24\54\1\u0096\5\54",
			"\1\u0098",
			"\1\u0099",
			"\1\u009a",
			"\1\u009b",
			"\1\u009c",
			"\1\u009d",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\u009f\7\uffff\1\u00a0",
			"\1\u00a1",
			"\1\u00a2\13\uffff\1\u00a3\1\u00a4",
			"\1\u00a5",
			"\1\u00a6\22\uffff\1\u00a7",
			"\1\u00a8\20\uffff\1\u00a9",
			"\1\u00aa",
			"\1\u00ab",
			"\1\u00ac\11\uffff\1\u00ad",
			"\1\u00ae\2\uffff\1\u00af",
			"\1\u00b0",
			"",
			"",
			"\1\u00b2",
			"",
			"",
			"\1\u00b4",
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
			"\1\170\1\uffff\10\u0080\2\170\12\uffff\3\170\35\uffff\3\170",
			"\1\170\1\uffff\12\u0081\12\uffff\3\170\35\uffff\3\170",
			"\1\u0082\26\uffff\1\u0082\17\uffff\12\u0083\66\uffff\1\u0084",
			"",
			"",
			"\1\u00b6",
			"\1\u00b7",
			"\1\u00b8",
			"\1\u00b9",
			"\1\u00ba",
			"\1\u00bb",
			"\1\u00bc",
			"\1\u00bd",
			"\1\u00be",
			"\1\u00bf",
			"\1\u00c0",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\u00c2",
			"\1\u00c3",
			"\1\u00c4",
			"\1\u00c5\1\u00c6",
			"\1\u00c7",
			"\1\u00c8",
			"",
			"\1\u00c9",
			"\1\u00ca",
			"\1\u00cb",
			"\1\u00cc",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\u00ce",
			"",
			"\1\u00cf",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\u00d1",
			"\1\u00d2",
			"\1\u00d3",
			"\1\u00d4",
			"\1\u00d5",
			"\1\u00d6",
			"\1\u00d7",
			"\1\u00d8",
			"\1\u00d9",
			"\1\u00da",
			"\1\u00db",
			"\1\u00dc",
			"\1\u00dd",
			"\1\u00de",
			"\1\u00df",
			"\1\u00e0",
			"",
			"",
			"",
			"",
			"",
			"\1\u00e1",
			"\1\u00e2",
			"\1\u00e3",
			"\1\u00e4",
			"\1\u00e5",
			"\1\u00e6",
			"\1\u00e7",
			"\1\u00e8",
			"\1\u00e9",
			"\1\u00ea",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"",
			"\1\u00ec",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\u00ef",
			"\1\u00f0",
			"\1\u00f1",
			"\1\u00f2",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\u00f5",
			"\1\u00f6",
			"",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\u00f8",
			"",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\u00fa",
			"\1\u00fb",
			"\1\u00fc",
			"\1\u00fd",
			"\1\u00fe",
			"\1\u00ff",
			"\1\u0100",
			"\1\u0101",
			"\1\u0102",
			"\1\u0103",
			"\1\u0104",
			"\1\u0105",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\u0107",
			"\1\u0108",
			"\1\u0109",
			"\1\u010a",
			"\1\u010b",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\u010d",
			"\1\u010e",
			"\1\u010f",
			"\1\u0110",
			"\1\u0111",
			"\1\u0112",
			"",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"",
			"",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\u0115",
			"\1\u0116",
			"\1\u0117",
			"",
			"",
			"\1\u0118",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"",
			"\1\u011a",
			"",
			"\1\u011b",
			"\1\u011c",
			"\1\u011d",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\u011f",
			"\1\u0120",
			"\1\u0121",
			"\1\u0122",
			"\1\u0123",
			"\1\u0124",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\u0126",
			"",
			"\1\u0127",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\3\54\1\u0129\4\54\1\u012a\21\54",
			"\1\u012c\15\uffff\1\u012d",
			"\1\u012e",
			"",
			"\1\u012f",
			"\1\u0130",
			"\1\u0131",
			"\1\u0132",
			"\1\u0133",
			"\1\u0134",
			"",
			"",
			"\1\u0135",
			"\1\u0136",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\u013a",
			"\1\u013b",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\u0142",
			"",
			"\1\u0143",
			"\1\u0144",
			"",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"",
			"\1\u0147",
			"\1\u0148",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\u014a",
			"\1\u014b",
			"\1\u014c",
			"\1\u014d",
			"\1\u014e",
			"\1\u014f",
			"\1\u0150",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"",
			"",
			"",
			"\1\u0152",
			"\1\u0153",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\u0155",
			"\1\u0156",
			"",
			"",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\u015b",
			"\1\u015c",
			"\1\u015d",
			"\1\u015e",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"",
			"",
			"",
			"",
			"\1\u0164",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\u0166",
			"\1\u0167",
			"",
			"",
			"",
			"",
			"",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"",
			"\1\u0169",
			"\1\u016a",
			"",
			"\1\u016b",
			"\1\u016c",
			"\1\u016d",
			"\1\u016e",
			"\1\u016f",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
			"",
			""
	};

	static final short[] DFA40_eot = DFA.unpackEncodedString(DFA40_eotS);
	static final short[] DFA40_eof = DFA.unpackEncodedString(DFA40_eofS);
	static final char[] DFA40_min = DFA.unpackEncodedStringToUnsignedChars(DFA40_minS);
	static final char[] DFA40_max = DFA.unpackEncodedStringToUnsignedChars(DFA40_maxS);
	static final short[] DFA40_accept = DFA.unpackEncodedString(DFA40_acceptS);
	static final short[] DFA40_special = DFA.unpackEncodedString(DFA40_specialS);
	static final short[][] DFA40_transition;

	static {
		int numStates = DFA40_transitionS.length;
		DFA40_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA40_transition[i] = DFA.unpackEncodedString(DFA40_transitionS[i]);
		}
	}

	protected class DFA40 extends DFA {

		public DFA40(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 40;
			this.eot = DFA40_eot;
			this.eof = DFA40_eof;
			this.min = DFA40_min;
			this.max = DFA40_max;
			this.accept = DFA40_accept;
			this.special = DFA40_special;
			this.transition = DFA40_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__123 | T__124 | T__125 | RULE_KW_UNDERSCORE | RULE_KW_AUTO | RULE_KW_BREAK | RULE_KW_CASE | RULE_KW_CHAR | RULE_KW_CONST | RULE_KW_CONTINUE | RULE_KW_DEFAULT | RULE_KW_DO | RULE_KW_DOUBLE | RULE_KW_ELSE | RULE_KW_ENUM | RULE_KW_EXTERN | RULE_KW_FLOAT | RULE_KW_FOR | RULE_KW_GOTO | RULE_KW_IF | RULE_KW_INLINE | RULE_KW_INT | RULE_KW_LONG | RULE_KW_REGISTER | RULE_KW_RESTRICT | RULE_KW_RETURN | RULE_KW_SHORT | RULE_KW_SIGNED | RULE_KW_SIZEOF | RULE_KW_STATIC | RULE_KW_STRUCT | RULE_KW_SWITCH | RULE_KW_TYPEDEF | RULE_KW_UNION | RULE_KW_UNSIGNED | RULE_KW_VOID | RULE_KW_VOLATILE | RULE_KW_WHILE | RULE_KW_ALIGNAS | RULE_KW_ALIGNOF | RULE_KW_ASM | RULE_KW_ATOMIC | RULE_KW_BOOL | RULE_KW_COMPLEX | RULE_KW_GENERIC | RULE_KW_IMAGINARY | RULE_KW_NORETURN | RULE_KW_STATICASSERT | RULE_KW_THREADLOCAL | RULE_LEFTPAREN | RULE_RIGHTPAREN | RULE_LEFTBRACKET | RULE_RIGHTBRACKET | RULE_LEFTBRACE | RULE_RIGHTBRACE | RULE_LESS | RULE_LESSEQUAL | RULE_GREATER | RULE_GREATEREQUAL | RULE_LEFTSHIFT | RULE_RIGHTSHIFT | RULE_PLUS | RULE_PLUSPLUS | RULE_MINUS | RULE_MINUSMINUS | RULE_STAR | RULE_DIV | RULE_MOD | RULE_AND | RULE_ANDAND | RULE_OR | RULE_OROR | RULE_CARET | RULE_NOT | RULE_TILDE | RULE_QUESTION | RULE_COLON | RULE_SEMI | RULE_COMMA | RULE_ASSIGN | RULE_STARASSIGN | RULE_DIVASSIGN | RULE_MODASSIGN | RULE_PLUSASSIGN | RULE_MINUSASSIGN | RULE_LEFTSHIFTASSIGN | RULE_RIGHTSHIFTASSIGN | RULE_ANDASSIGN | RULE_XORASSIGN | RULE_ORASSIGN | RULE_EQUAL | RULE_NOTEQUAL | RULE_ARROW | RULE_ELLIPSIS | RULE_SINGLEQUOTE | RULE_DOUBLEQUOTE | RULE_BACKSLASH | RULE_ID | RULE_CHAR_LITERAL | RULE_STRING_LITERAL | RULE_HEX_LITERAL | RULE_DECIMAL_LITERAL | RULE_OCTAL_LITERAL | RULE_BIN_LITERAL | RULE_FLOAT_LITERAL | RULE_LINEDIRECTIVE | RULE_PRAGMADIRECTIVE | RULE_WHITESPACE | RULE_BLOCK_COMMENT | RULE_LINE_COMMENT | RULE_NEWLINE );";
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

			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 40, _s, input);
			error(nvae);
			throw nvae;
		}
			private int specialState0(int s, IntStream _input) {
				IntStream input = _input;
				int LA40_42 = input.LA(1);
				s = -1;
				if ( ((LA40_42 >= '\u0000' && LA40_42 <= '\uFFFF')) ) {s = 124;}
				else s = 123;
				//if ( s>=0 ) return s;
				//break;
				return s;
			}

			private int specialState1(int s, IntStream _input) {
				IntStream input = _input;
				int LA40_41 = input.LA(1);
				s = -1;
				if ( ((LA40_41 >= '\u0000' && LA40_41 <= '&')||(LA40_41 >= '(' && LA40_41 <= '\uFFFF')) ) {s = 122;}
				else s = 121;
				//if ( s>=0 ) return s;
				//break;
				return s;
			}

	}


}