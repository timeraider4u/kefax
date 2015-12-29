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
	public static final int RULE_ANDASSIGN=4;
	public static final int RULE_ARROW=5;
	public static final int RULE_BIN_LITERAL=6;
	public static final int RULE_BLOCK_COMMENT=7;
	public static final int RULE_CARRIAGERETURN=8;
	public static final int RULE_CHAR_LITERAL=9;
	public static final int RULE_DECIMAL_LITERAL=10;
	public static final int RULE_DIVASSIGN=11;
	public static final int RULE_ELLIPSIS=12;
	public static final int RULE_ESCAPE_SEQUENCE=13;
	public static final int RULE_EXPONENT=14;
	public static final int RULE_FLOAT_LITERAL=15;
	public static final int RULE_FLOAT_TYPE_SUFFIX=16;
	public static final int RULE_HEX_DIGIT=17;
	public static final int RULE_HEX_ESCAPE=18;
	public static final int RULE_HEX_LITERAL=19;
	public static final int RULE_ID=20;
	public static final int RULE_IDENTIFIER=21;
	public static final int RULE_INTEGER_TYPE_SUFFIX=22;
	public static final int RULE_KW_ALIGNAS=23;
	public static final int RULE_KW_ALIGNOF=24;
	public static final int RULE_KW_ASM1=25;
	public static final int RULE_KW_ASM2=26;
	public static final int RULE_KW_ATOMIC=27;
	public static final int RULE_KW_AUTO=28;
	public static final int RULE_KW_BOOL=29;
	public static final int RULE_KW_BREAK=30;
	public static final int RULE_KW_BUILTIN_VA_LIST=31;
	public static final int RULE_KW_CASE=32;
	public static final int RULE_KW_CHAR=33;
	public static final int RULE_KW_COMPLEX=34;
	public static final int RULE_KW_CONST=35;
	public static final int RULE_KW_CONTINUE=36;
	public static final int RULE_KW_DEFAULT=37;
	public static final int RULE_KW_DO=38;
	public static final int RULE_KW_DOUBLE=39;
	public static final int RULE_KW_ELSE=40;
	public static final int RULE_KW_ENUM=41;
	public static final int RULE_KW_EXTERN=42;
	public static final int RULE_KW_FLOAT=43;
	public static final int RULE_KW_FOR=44;
	public static final int RULE_KW_GENERIC=45;
	public static final int RULE_KW_GOTO=46;
	public static final int RULE_KW_IF=47;
	public static final int RULE_KW_IMAGINARY=48;
	public static final int RULE_KW_INLINE=49;
	public static final int RULE_KW_INT=50;
	public static final int RULE_KW_LONG=51;
	public static final int RULE_KW_M128=52;
	public static final int RULE_KW_M128D=53;
	public static final int RULE_KW_M128I=54;
	public static final int RULE_KW_NORETURN=55;
	public static final int RULE_KW_PRAGMA=56;
	public static final int RULE_KW_REGISTER=57;
	public static final int RULE_KW_RESTRICT=58;
	public static final int RULE_KW_RETURN=59;
	public static final int RULE_KW_SHORT=60;
	public static final int RULE_KW_SIGNED=61;
	public static final int RULE_KW_SIZEOF=62;
	public static final int RULE_KW_STATIC=63;
	public static final int RULE_KW_STATICASSERT=64;
	public static final int RULE_KW_STRUCT=65;
	public static final int RULE_KW_SWITCH=66;
	public static final int RULE_KW_THREADLOCAL=67;
	public static final int RULE_KW_TYPEDEF=68;
	public static final int RULE_KW_UNION=69;
	public static final int RULE_KW_UNSIGNED=70;
	public static final int RULE_KW_VOID=71;
	public static final int RULE_KW_VOLATILE=72;
	public static final int RULE_KW_VOLATILE2=73;
	public static final int RULE_KW_WHILE=74;
	public static final int RULE_LEFTSHIFTASSIGN=75;
	public static final int RULE_LETTER=76;
	public static final int RULE_LINEBREAK=77;
	public static final int RULE_LINEDIRECTIVE=78;
	public static final int RULE_LINEFEED=79;
	public static final int RULE_LINE_COMMENT=80;
	public static final int RULE_LINE_END=81;
	public static final int RULE_MINUSASSIGN=82;
	public static final int RULE_MODASSIGN=83;
	public static final int RULE_NEWLINE=84;
	public static final int RULE_OCTAL_ESCAPE=85;
	public static final int RULE_OCTAL_LITERAL=86;
	public static final int RULE_ORASSIGN=87;
	public static final int RULE_PLUSASSIGN=88;
	public static final int RULE_RIGHTSHIFTASSIGN=89;
	public static final int RULE_SKW_AND=90;
	public static final int RULE_SKW_ANDAND=91;
	public static final int RULE_SKW_ASSIGN=92;
	public static final int RULE_SKW_BACKSLASH=93;
	public static final int RULE_SKW_CARET=94;
	public static final int RULE_SKW_COLON=95;
	public static final int RULE_SKW_COMMA=96;
	public static final int RULE_SKW_DIV=97;
	public static final int RULE_SKW_DOLLAR=98;
	public static final int RULE_SKW_DOT=99;
	public static final int RULE_SKW_DOUBLEQUOTE=100;
	public static final int RULE_SKW_EQUAL=101;
	public static final int RULE_SKW_GREATER=102;
	public static final int RULE_SKW_GREATEREQUAL=103;
	public static final int RULE_SKW_LEFTBRACE=104;
	public static final int RULE_SKW_LEFTBRACKET=105;
	public static final int RULE_SKW_LEFTPAREN=106;
	public static final int RULE_SKW_LEFTSHIFT=107;
	public static final int RULE_SKW_LESS=108;
	public static final int RULE_SKW_LESSEQUAL=109;
	public static final int RULE_SKW_MINUS=110;
	public static final int RULE_SKW_MINUSMINUS=111;
	public static final int RULE_SKW_MOD=112;
	public static final int RULE_SKW_NOT=113;
	public static final int RULE_SKW_NOTEQUAL=114;
	public static final int RULE_SKW_OR=115;
	public static final int RULE_SKW_OROR=116;
	public static final int RULE_SKW_PLUS=117;
	public static final int RULE_SKW_PLUSPLUS=118;
	public static final int RULE_SKW_QUESTION=119;
	public static final int RULE_SKW_RIGHTBRACE=120;
	public static final int RULE_SKW_RIGHTBRACKET=121;
	public static final int RULE_SKW_RIGHTPAREN=122;
	public static final int RULE_SKW_RIGHTSHIFT=123;
	public static final int RULE_SKW_SEMI=124;
	public static final int RULE_SKW_SINGLEQUOTE=125;
	public static final int RULE_SKW_STAR=126;
	public static final int RULE_SKW_TILDE=127;
	public static final int RULE_SKW_UNDERSCORE=128;
	public static final int RULE_SPACE=129;
	public static final int RULE_SPECIAL=130;
	public static final int RULE_STARASSIGN=131;
	public static final int RULE_STRING_LITERAL=132;
	public static final int RULE_TAB=133;
	public static final int RULE_WHITESPACE=134;
	public static final int RULE_XORASSIGN=135;

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

	// $ANTLR start "RULE_KW_ATOMIC"
	public final void mRULE_KW_ATOMIC() throws RecognitionException {
		try {
			int _type = RULE_KW_ATOMIC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10114:16: ( '_Atomic' )
			// InternalParser.g:10114:18: '_Atomic'
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

	// $ANTLR start "RULE_KW_AUTO"
	public final void mRULE_KW_AUTO() throws RecognitionException {
		try {
			int _type = RULE_KW_AUTO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10116:14: ( 'auto' )
			// InternalParser.g:10116:16: 'auto'
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

	// $ANTLR start "RULE_KW_ALIGNAS"
	public final void mRULE_KW_ALIGNAS() throws RecognitionException {
		try {
			int _type = RULE_KW_ALIGNAS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10118:17: ( '_Alignas' )
			// InternalParser.g:10118:19: '_Alignas'
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
			// InternalParser.g:10120:17: ( '_Alignof' )
			// InternalParser.g:10120:19: '_Alignof'
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
			// InternalParser.g:10122:14: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'asm' )
			// InternalParser.g:10122:16: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'asm'
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
			// InternalParser.g:10124:14: ( RULE_KW_ASM1 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE )
			// InternalParser.g:10124:16: RULE_KW_ASM1 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE
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

	// $ANTLR start "RULE_KW_BOOL"
	public final void mRULE_KW_BOOL() throws RecognitionException {
		try {
			int _type = RULE_KW_BOOL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10126:14: ( '_Bool' )
			// InternalParser.g:10126:16: '_Bool'
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

	// $ANTLR start "RULE_KW_BREAK"
	public final void mRULE_KW_BREAK() throws RecognitionException {
		try {
			int _type = RULE_KW_BREAK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10128:15: ( 'break' )
			// InternalParser.g:10128:17: 'break'
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

	// $ANTLR start "RULE_KW_BUILTIN_VA_LIST"
	public final void mRULE_KW_BUILTIN_VA_LIST() throws RecognitionException {
		try {
			int _type = RULE_KW_BUILTIN_VA_LIST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10130:25: ( '__builtin_va_list' )
			// InternalParser.g:10130:27: '__builtin_va_list'
			{
			match("__builtin_va_list"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_BUILTIN_VA_LIST"

	// $ANTLR start "RULE_KW_CASE"
	public final void mRULE_KW_CASE() throws RecognitionException {
		try {
			int _type = RULE_KW_CASE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10132:14: ( 'case' )
			// InternalParser.g:10132:16: 'case'
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
			// InternalParser.g:10134:14: ( 'char' )
			// InternalParser.g:10134:16: 'char'
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

	// $ANTLR start "RULE_KW_COMPLEX"
	public final void mRULE_KW_COMPLEX() throws RecognitionException {
		try {
			int _type = RULE_KW_COMPLEX;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10136:17: ( '_Complex' )
			// InternalParser.g:10136:19: '_Complex'
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

	// $ANTLR start "RULE_KW_CONST"
	public final void mRULE_KW_CONST() throws RecognitionException {
		try {
			int _type = RULE_KW_CONST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10138:15: ( 'const' )
			// InternalParser.g:10138:17: 'const'
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
			// InternalParser.g:10140:18: ( 'continue' )
			// InternalParser.g:10140:20: 'continue'
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
			// InternalParser.g:10142:17: ( 'default' )
			// InternalParser.g:10142:19: 'default'
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
			// InternalParser.g:10144:12: ( 'do' )
			// InternalParser.g:10144:14: 'do'
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
			// InternalParser.g:10146:16: ( 'double' )
			// InternalParser.g:10146:18: 'double'
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
			// InternalParser.g:10148:14: ( 'else' )
			// InternalParser.g:10148:16: 'else'
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
			// InternalParser.g:10150:14: ( 'enum' )
			// InternalParser.g:10150:16: 'enum'
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
			// InternalParser.g:10152:16: ( 'extern' )
			// InternalParser.g:10152:18: 'extern'
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
			// InternalParser.g:10154:15: ( 'float' )
			// InternalParser.g:10154:17: 'float'
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
			// InternalParser.g:10156:13: ( 'for' )
			// InternalParser.g:10156:15: 'for'
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

	// $ANTLR start "RULE_KW_GENERIC"
	public final void mRULE_KW_GENERIC() throws RecognitionException {
		try {
			int _type = RULE_KW_GENERIC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10158:17: ( '_Generic' )
			// InternalParser.g:10158:19: '_Generic'
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

	// $ANTLR start "RULE_KW_GOTO"
	public final void mRULE_KW_GOTO() throws RecognitionException {
		try {
			int _type = RULE_KW_GOTO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10160:14: ( 'goto' )
			// InternalParser.g:10160:16: 'goto'
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
			// InternalParser.g:10162:12: ( 'if' )
			// InternalParser.g:10162:14: 'if'
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

	// $ANTLR start "RULE_KW_IMAGINARY"
	public final void mRULE_KW_IMAGINARY() throws RecognitionException {
		try {
			int _type = RULE_KW_IMAGINARY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10164:19: ( '_Imaginary' )
			// InternalParser.g:10164:21: '_Imaginary'
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

	// $ANTLR start "RULE_KW_INLINE"
	public final void mRULE_KW_INLINE() throws RecognitionException {
		try {
			int _type = RULE_KW_INLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10166:16: ( 'inline' )
			// InternalParser.g:10166:18: 'inline'
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
			// InternalParser.g:10168:13: ( 'int' )
			// InternalParser.g:10168:15: 'int'
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
			// InternalParser.g:10170:14: ( 'long' )
			// InternalParser.g:10170:16: 'long'
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

	// $ANTLR start "RULE_KW_M128"
	public final void mRULE_KW_M128() throws RecognitionException {
		try {
			int _type = RULE_KW_M128;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10172:14: ( '__m128' )
			// InternalParser.g:10172:16: '__m128'
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
	// $ANTLR end "RULE_KW_M128"

	// $ANTLR start "RULE_KW_M128D"
	public final void mRULE_KW_M128D() throws RecognitionException {
		try {
			int _type = RULE_KW_M128D;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10174:15: ( '__m128d' )
			// InternalParser.g:10174:17: '__m128d'
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
	// $ANTLR end "RULE_KW_M128D"

	// $ANTLR start "RULE_KW_M128I"
	public final void mRULE_KW_M128I() throws RecognitionException {
		try {
			int _type = RULE_KW_M128I;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10176:15: ( '__m128i' )
			// InternalParser.g:10176:17: '__m128i'
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
	// $ANTLR end "RULE_KW_M128I"

	// $ANTLR start "RULE_KW_NORETURN"
	public final void mRULE_KW_NORETURN() throws RecognitionException {
		try {
			int _type = RULE_KW_NORETURN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10178:18: ( '_Noreturn' )
			// InternalParser.g:10178:20: '_Noreturn'
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

	// $ANTLR start "RULE_KW_PRAGMA"
	public final void mRULE_KW_PRAGMA() throws RecognitionException {
		try {
			int _type = RULE_KW_PRAGMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10180:16: ( 'pragma' )
			// InternalParser.g:10180:18: 'pragma'
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

	// $ANTLR start "RULE_KW_REGISTER"
	public final void mRULE_KW_REGISTER() throws RecognitionException {
		try {
			int _type = RULE_KW_REGISTER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10182:18: ( 'register' )
			// InternalParser.g:10182:20: 'register'
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
			// InternalParser.g:10184:18: ( 'restrict' )
			// InternalParser.g:10184:20: 'restrict'
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
			// InternalParser.g:10186:16: ( 'return' )
			// InternalParser.g:10186:18: 'return'
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
			// InternalParser.g:10188:15: ( 'short' )
			// InternalParser.g:10188:17: 'short'
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
			// InternalParser.g:10190:16: ( 'signed' )
			// InternalParser.g:10190:18: 'signed'
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
			// InternalParser.g:10192:16: ( 'sizeof' )
			// InternalParser.g:10192:18: 'sizeof'
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
			// InternalParser.g:10194:16: ( 'static' )
			// InternalParser.g:10194:18: 'static'
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

	// $ANTLR start "RULE_KW_STATICASSERT"
	public final void mRULE_KW_STATICASSERT() throws RecognitionException {
		try {
			int _type = RULE_KW_STATICASSERT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10196:22: ( '_Static_assert' )
			// InternalParser.g:10196:24: '_Static_assert'
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

	// $ANTLR start "RULE_KW_STRUCT"
	public final void mRULE_KW_STRUCT() throws RecognitionException {
		try {
			int _type = RULE_KW_STRUCT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10198:16: ( 'struct' )
			// InternalParser.g:10198:18: 'struct'
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
			// InternalParser.g:10200:16: ( 'switch' )
			// InternalParser.g:10200:18: 'switch'
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

	// $ANTLR start "RULE_KW_THREADLOCAL"
	public final void mRULE_KW_THREADLOCAL() throws RecognitionException {
		try {
			int _type = RULE_KW_THREADLOCAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10202:21: ( '_Thread_local' )
			// InternalParser.g:10202:23: '_Thread_local'
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

	// $ANTLR start "RULE_KW_TYPEDEF"
	public final void mRULE_KW_TYPEDEF() throws RecognitionException {
		try {
			int _type = RULE_KW_TYPEDEF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10204:17: ( 'typedef' )
			// InternalParser.g:10204:19: 'typedef'
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
			// InternalParser.g:10206:15: ( 'union' )
			// InternalParser.g:10206:17: 'union'
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
			// InternalParser.g:10208:18: ( 'unsigned' )
			// InternalParser.g:10208:20: 'unsigned'
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
			// InternalParser.g:10210:14: ( 'void' )
			// InternalParser.g:10210:16: 'void'
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
			// InternalParser.g:10212:18: ( 'volatile' )
			// InternalParser.g:10212:20: 'volatile'
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

	// $ANTLR start "RULE_KW_VOLATILE2"
	public final void mRULE_KW_VOLATILE2() throws RecognitionException {
		try {
			int _type = RULE_KW_VOLATILE2;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10214:19: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_VOLATILE RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE )
			// InternalParser.g:10214:21: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_VOLATILE RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE
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

	// $ANTLR start "RULE_KW_WHILE"
	public final void mRULE_KW_WHILE() throws RecognitionException {
		try {
			int _type = RULE_KW_WHILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10216:15: ( 'while' )
			// InternalParser.g:10216:17: 'while'
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

	// $ANTLR start "RULE_STARASSIGN"
	public final void mRULE_STARASSIGN() throws RecognitionException {
		try {
			int _type = RULE_STARASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10218:17: ( RULE_SKW_STAR RULE_SKW_ASSIGN )
			// InternalParser.g:10218:19: RULE_SKW_STAR RULE_SKW_ASSIGN
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
			// InternalParser.g:10220:16: ( RULE_SKW_DIV RULE_SKW_ASSIGN )
			// InternalParser.g:10220:18: RULE_SKW_DIV RULE_SKW_ASSIGN
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
			// InternalParser.g:10222:16: ( RULE_SKW_MOD RULE_SKW_ASSIGN )
			// InternalParser.g:10222:18: RULE_SKW_MOD RULE_SKW_ASSIGN
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
			// InternalParser.g:10224:17: ( RULE_SKW_PLUS RULE_SKW_ASSIGN )
			// InternalParser.g:10224:19: RULE_SKW_PLUS RULE_SKW_ASSIGN
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
			// InternalParser.g:10226:18: ( RULE_SKW_MINUS RULE_SKW_ASSIGN )
			// InternalParser.g:10226:20: RULE_SKW_MINUS RULE_SKW_ASSIGN
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
			// InternalParser.g:10228:22: ( RULE_SKW_LEFTSHIFT RULE_SKW_ASSIGN )
			// InternalParser.g:10228:24: RULE_SKW_LEFTSHIFT RULE_SKW_ASSIGN
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
			// InternalParser.g:10230:23: ( RULE_SKW_RIGHTSHIFT RULE_SKW_ASSIGN )
			// InternalParser.g:10230:25: RULE_SKW_RIGHTSHIFT RULE_SKW_ASSIGN
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
			// InternalParser.g:10232:16: ( RULE_SKW_AND RULE_SKW_ASSIGN )
			// InternalParser.g:10232:18: RULE_SKW_AND RULE_SKW_ASSIGN
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
			// InternalParser.g:10234:16: ( RULE_SKW_CARET RULE_SKW_ASSIGN )
			// InternalParser.g:10234:18: RULE_SKW_CARET RULE_SKW_ASSIGN
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
			// InternalParser.g:10236:15: ( RULE_SKW_OR RULE_SKW_ASSIGN )
			// InternalParser.g:10236:17: RULE_SKW_OR RULE_SKW_ASSIGN
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
			// InternalParser.g:10238:12: ( RULE_SKW_MINUS RULE_SKW_GREATER )
			// InternalParser.g:10238:14: RULE_SKW_MINUS RULE_SKW_GREATER
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
			// InternalParser.g:10240:15: ( RULE_SKW_DOT RULE_SKW_DOT RULE_SKW_DOT )
			// InternalParser.g:10240:17: RULE_SKW_DOT RULE_SKW_DOT RULE_SKW_DOT
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

	// $ANTLR start "RULE_LINEDIRECTIVE"
	public final void mRULE_LINEDIRECTIVE() throws RecognitionException {
		try {
			int _type = RULE_LINEDIRECTIVE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10242:20: ( '#' (~ ( RULE_NEWLINE ) | RULE_SKW_BACKSLASH RULE_NEWLINE )* )
			// InternalParser.g:10242:22: '#' (~ ( RULE_NEWLINE ) | RULE_SKW_BACKSLASH RULE_NEWLINE )*
			{
			match('#'); 
			// InternalParser.g:10242:26: (~ ( RULE_NEWLINE ) | RULE_SKW_BACKSLASH RULE_NEWLINE )*
			loop1:
			while (true) {
				int alt1=3;
				int LA1_0 = input.LA(1);
				if ( (LA1_0=='\\') ) {
					int LA1_2 = input.LA(2);
					if ( (LA1_2=='\n'||LA1_2=='\r') ) {
						alt1=2;
					}
					else {
						alt1=1;
					}

				}
				else if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\t')||(LA1_0 >= '\u000B' && LA1_0 <= '\f')||(LA1_0 >= '\u000E' && LA1_0 <= '[')||(LA1_0 >= ']' && LA1_0 <= '\uFFFF')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// InternalParser.g:10242:27: ~ ( RULE_NEWLINE )
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
					// InternalParser.g:10242:43: RULE_SKW_BACKSLASH RULE_NEWLINE
					{
					mRULE_SKW_BACKSLASH(); 

					mRULE_NEWLINE(); 

					}
					break;

				default :
					break loop1;
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
			// InternalParser.g:10244:17: ( ( ' ' | '\\t' )+ )
			// InternalParser.g:10244:19: ( ' ' | '\\t' )+
			{
			// InternalParser.g:10244:19: ( ' ' | '\\t' )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0=='\t'||LA2_0==' ') ) {
					alt2=1;
				}

				switch (alt2) {
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
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
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

	// $ANTLR start "RULE_SKW_AND"
	public final void mRULE_SKW_AND() throws RecognitionException {
		try {
			int _type = RULE_SKW_AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10246:14: ( '&' )
			// InternalParser.g:10246:16: '&'
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
			// InternalParser.g:10248:17: ( RULE_SKW_AND RULE_SKW_AND )
			// InternalParser.g:10248:19: RULE_SKW_AND RULE_SKW_AND
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
			// InternalParser.g:10250:17: ( '=' )
			// InternalParser.g:10250:19: '='
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
			// InternalParser.g:10252:20: ( '\\\\' )
			// InternalParser.g:10252:22: '\\\\'
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
			// InternalParser.g:10254:16: ( '^' )
			// InternalParser.g:10254:18: '^'
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
			// InternalParser.g:10256:16: ( ',' )
			// InternalParser.g:10256:18: ','
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
			// InternalParser.g:10258:16: ( ':' )
			// InternalParser.g:10258:18: ':'
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
			// InternalParser.g:10260:14: ( '/' )
			// InternalParser.g:10260:16: '/'
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
			// InternalParser.g:10262:26: ( '$' )
			// InternalParser.g:10262:28: '$'
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
			// InternalParser.g:10264:14: ( '.' )
			// InternalParser.g:10264:16: '.'
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
			// InternalParser.g:10266:22: ( '\"' )
			// InternalParser.g:10266:24: '\"'
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
			// InternalParser.g:10268:16: ( RULE_SKW_ASSIGN RULE_SKW_ASSIGN )
			// InternalParser.g:10268:18: RULE_SKW_ASSIGN RULE_SKW_ASSIGN
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
			// InternalParser.g:10270:18: ( '>' )
			// InternalParser.g:10270:20: '>'
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
			// InternalParser.g:10272:23: ( RULE_SKW_GREATER RULE_SKW_ASSIGN )
			// InternalParser.g:10272:25: RULE_SKW_GREATER RULE_SKW_ASSIGN
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
			// InternalParser.g:10274:20: ( '{' )
			// InternalParser.g:10274:22: '{'
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
			// InternalParser.g:10276:22: ( '[' )
			// InternalParser.g:10276:24: '['
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
			// InternalParser.g:10278:20: ( '(' )
			// InternalParser.g:10278:22: '('
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
			// InternalParser.g:10280:20: ( RULE_SKW_LESS RULE_SKW_LESS )
			// InternalParser.g:10280:22: RULE_SKW_LESS RULE_SKW_LESS
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
			// InternalParser.g:10282:15: ( '<' )
			// InternalParser.g:10282:17: '<'
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
			// InternalParser.g:10284:20: ( RULE_SKW_LESS RULE_SKW_ASSIGN )
			// InternalParser.g:10284:22: RULE_SKW_LESS RULE_SKW_ASSIGN
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
			// InternalParser.g:10286:16: ( '-' )
			// InternalParser.g:10286:18: '-'
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
			// InternalParser.g:10288:21: ( RULE_SKW_MINUS RULE_SKW_MINUS )
			// InternalParser.g:10288:23: RULE_SKW_MINUS RULE_SKW_MINUS
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
			// InternalParser.g:10290:14: ( '%' )
			// InternalParser.g:10290:16: '%'
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
			// InternalParser.g:10292:14: ( '!' )
			// InternalParser.g:10292:16: '!'
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
			// InternalParser.g:10294:19: ( RULE_SKW_NOT RULE_SKW_ASSIGN )
			// InternalParser.g:10294:21: RULE_SKW_NOT RULE_SKW_ASSIGN
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
			// InternalParser.g:10296:13: ( '|' )
			// InternalParser.g:10296:15: '|'
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
			// InternalParser.g:10298:15: ( RULE_SKW_OR RULE_SKW_OR )
			// InternalParser.g:10298:17: RULE_SKW_OR RULE_SKW_OR
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
			// InternalParser.g:10300:15: ( '+' )
			// InternalParser.g:10300:17: '+'
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
			// InternalParser.g:10302:19: ( RULE_SKW_PLUS RULE_SKW_PLUS )
			// InternalParser.g:10302:21: RULE_SKW_PLUS RULE_SKW_PLUS
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
			// InternalParser.g:10304:19: ( '?' )
			// InternalParser.g:10304:21: '?'
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
			// InternalParser.g:10306:21: ( '}' )
			// InternalParser.g:10306:23: '}'
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
			// InternalParser.g:10308:23: ( ']' )
			// InternalParser.g:10308:25: ']'
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
			// InternalParser.g:10310:21: ( ')' )
			// InternalParser.g:10310:23: ')'
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
			// InternalParser.g:10312:21: ( RULE_SKW_GREATER RULE_SKW_GREATER )
			// InternalParser.g:10312:23: RULE_SKW_GREATER RULE_SKW_GREATER
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
			// InternalParser.g:10314:15: ( ';' )
			// InternalParser.g:10314:17: ';'
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
			// InternalParser.g:10316:22: ( '\\'' )
			// InternalParser.g:10316:24: '\\''
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
			// InternalParser.g:10318:15: ( '*' )
			// InternalParser.g:10318:17: '*'
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
			// InternalParser.g:10320:16: ( '~' )
			// InternalParser.g:10320:18: '~'
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
			// InternalParser.g:10322:30: ( '_' )
			// InternalParser.g:10322:32: '_'
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
			// InternalParser.g:10324:9: ( RULE_IDENTIFIER )
			// InternalParser.g:10324:11: RULE_IDENTIFIER
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
			// InternalParser.g:10326:26: ( RULE_LETTER ( RULE_LETTER | '0' .. '9' )* )
			// InternalParser.g:10326:28: RULE_LETTER ( RULE_LETTER | '0' .. '9' )*
			{
			mRULE_LETTER(); 

			// InternalParser.g:10326:40: ( RULE_LETTER | '0' .. '9' )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0=='$'||(LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||LA3_0=='_'||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
					alt3=1;
				}

				switch (alt3) {
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
					break loop3;
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
			// InternalParser.g:10328:22: ( ( RULE_SKW_DOLLAR | 'A' .. 'Z' | 'a' .. 'z' | RULE_SKW_UNDERSCORE ) )
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
			// InternalParser.g:10330:19: ( RULE_SKW_SINGLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) ) RULE_SKW_SINGLEQUOTE )
			// InternalParser.g:10330:21: RULE_SKW_SINGLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) ) RULE_SKW_SINGLEQUOTE
			{
			mRULE_SKW_SINGLEQUOTE(); 

			// InternalParser.g:10330:42: ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='\\') ) {
				alt4=1;
			}
			else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '&')||(LA4_0 >= '(' && LA4_0 <= '[')||(LA4_0 >= ']' && LA4_0 <= '\uFFFF')) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// InternalParser.g:10330:43: RULE_ESCAPE_SEQUENCE
					{
					mRULE_ESCAPE_SEQUENCE(); 

					}
					break;
				case 2 :
					// InternalParser.g:10330:64: ~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) )
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
			// InternalParser.g:10332:21: ( RULE_SKW_DOUBLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) )* RULE_SKW_DOUBLEQUOTE )
			// InternalParser.g:10332:23: RULE_SKW_DOUBLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) )* RULE_SKW_DOUBLEQUOTE
			{
			mRULE_SKW_DOUBLEQUOTE(); 

			// InternalParser.g:10332:44: ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) )*
			loop5:
			while (true) {
				int alt5=3;
				int LA5_0 = input.LA(1);
				if ( (LA5_0=='\\') ) {
					alt5=1;
				}
				else if ( ((LA5_0 >= '\u0000' && LA5_0 <= '!')||(LA5_0 >= '#' && LA5_0 <= '[')||(LA5_0 >= ']' && LA5_0 <= '\uFFFF')) ) {
					alt5=2;
				}

				switch (alt5) {
				case 1 :
					// InternalParser.g:10332:45: RULE_ESCAPE_SEQUENCE
					{
					mRULE_ESCAPE_SEQUENCE(); 

					}
					break;
				case 2 :
					// InternalParser.g:10332:66: ~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) )
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
					break loop5;
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
			// InternalParser.g:10334:18: ( '0' ( 'x' | 'X' ) ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )? )
			// InternalParser.g:10334:20: '0' ( 'x' | 'X' ) ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )?
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
			// InternalParser.g:10334:34: ( RULE_HEX_DIGIT )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'F')||(LA6_0 >= 'a' && LA6_0 <= 'f')) ) {
					alt6=1;
				}

				switch (alt6) {
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
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			// InternalParser.g:10334:50: ( RULE_INTEGER_TYPE_SUFFIX )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0=='L'||LA7_0=='U'||LA7_0=='l'||LA7_0=='u') ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// InternalParser.g:10334:50: RULE_INTEGER_TYPE_SUFFIX
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
			// InternalParser.g:10336:22: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( RULE_INTEGER_TYPE_SUFFIX )? )
			// InternalParser.g:10336:24: ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( RULE_INTEGER_TYPE_SUFFIX )?
			{
			// InternalParser.g:10336:24: ( '0' | '1' .. '9' ( '0' .. '9' )* )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0=='0') ) {
				alt9=1;
			}
			else if ( ((LA9_0 >= '1' && LA9_0 <= '9')) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// InternalParser.g:10336:25: '0'
					{
					match('0'); 
					}
					break;
				case 2 :
					// InternalParser.g:10336:29: '1' .. '9' ( '0' .. '9' )*
					{
					matchRange('1','9'); 
					// InternalParser.g:10336:38: ( '0' .. '9' )*
					loop8:
					while (true) {
						int alt8=2;
						int LA8_0 = input.LA(1);
						if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
							alt8=1;
						}

						switch (alt8) {
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
							break loop8;
						}
					}

					}
					break;

			}

			// InternalParser.g:10336:51: ( RULE_INTEGER_TYPE_SUFFIX )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='L'||LA10_0=='U'||LA10_0=='l'||LA10_0=='u') ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// InternalParser.g:10336:51: RULE_INTEGER_TYPE_SUFFIX
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
			// InternalParser.g:10338:20: ( '0' ( '0' .. '7' )+ ( RULE_INTEGER_TYPE_SUFFIX )? )
			// InternalParser.g:10338:22: '0' ( '0' .. '7' )+ ( RULE_INTEGER_TYPE_SUFFIX )?
			{
			match('0'); 
			// InternalParser.g:10338:26: ( '0' .. '7' )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( ((LA11_0 >= '0' && LA11_0 <= '7')) ) {
					alt11=1;
				}

				switch (alt11) {
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
					if ( cnt11 >= 1 ) break loop11;
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
			}

			// InternalParser.g:10338:38: ( RULE_INTEGER_TYPE_SUFFIX )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0=='L'||LA12_0=='U'||LA12_0=='l'||LA12_0=='u') ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// InternalParser.g:10338:38: RULE_INTEGER_TYPE_SUFFIX
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
			// InternalParser.g:10340:18: ( ( '0b' | '0B' ) ( '0' .. '1' )+ )
			// InternalParser.g:10340:20: ( '0b' | '0B' ) ( '0' .. '1' )+
			{
			// InternalParser.g:10340:20: ( '0b' | '0B' )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0=='0') ) {
				int LA13_1 = input.LA(2);
				if ( (LA13_1=='b') ) {
					alt13=1;
				}
				else if ( (LA13_1=='B') ) {
					alt13=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 13, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// InternalParser.g:10340:21: '0b'
					{
					match("0b"); 

					}
					break;
				case 2 :
					// InternalParser.g:10340:26: '0B'
					{
					match("0B"); 

					}
					break;

			}

			// InternalParser.g:10340:32: ( '0' .. '1' )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( ((LA14_0 >= '0' && LA14_0 <= '1')) ) {
					alt14=1;
				}

				switch (alt14) {
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
					if ( cnt14 >= 1 ) break loop14;
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
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
			// InternalParser.g:10342:25: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
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
			// InternalParser.g:10344:35: ( ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? ) )
			// InternalParser.g:10344:37: ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? )
			{
			// InternalParser.g:10344:37: ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0=='U'||LA17_0=='u') ) {
				int LA17_1 = input.LA(2);
				if ( (LA17_1=='L'||LA17_1=='l') ) {
					alt17=1;
				}

				else {
					alt17=2;
				}

			}
			else if ( (LA17_0=='L'||LA17_0=='l') ) {
				alt17=1;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// InternalParser.g:10344:38: ( 'u' | 'U' )? ( 'l' | 'L' )
					{
					// InternalParser.g:10344:38: ( 'u' | 'U' )?
					int alt15=2;
					int LA15_0 = input.LA(1);
					if ( (LA15_0=='U'||LA15_0=='u') ) {
						alt15=1;
					}
					switch (alt15) {
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
					// InternalParser.g:10344:59: ( 'u' | 'U' ) ( 'l' | 'L' )?
					{
					if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// InternalParser.g:10344:69: ( 'l' | 'L' )?
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0=='L'||LA16_0=='l') ) {
						alt16=1;
					}
					switch (alt16) {
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
			// InternalParser.g:10346:20: ( ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX ) )
			// InternalParser.g:10346:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )
			{
			// InternalParser.g:10346:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )
			int alt29=4;
			alt29 = dfa29.predict(input);
			switch (alt29) {
				case 1 :
					// InternalParser.g:10346:23: ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )?
					{
					// InternalParser.g:10346:23: ( '0' .. '9' )+
					int cnt18=0;
					loop18:
					while (true) {
						int alt18=2;
						int LA18_0 = input.LA(1);
						if ( ((LA18_0 >= '0' && LA18_0 <= '9')) ) {
							alt18=1;
						}

						switch (alt18) {
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
							if ( cnt18 >= 1 ) break loop18;
							EarlyExitException eee = new EarlyExitException(18, input);
							throw eee;
						}
						cnt18++;
					}

					mRULE_SKW_DOT(); 

					// InternalParser.g:10346:48: ( '0' .. '9' )*
					loop19:
					while (true) {
						int alt19=2;
						int LA19_0 = input.LA(1);
						if ( ((LA19_0 >= '0' && LA19_0 <= '9')) ) {
							alt19=1;
						}

						switch (alt19) {
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
							break loop19;
						}
					}

					// InternalParser.g:10346:60: ( RULE_EXPONENT )?
					int alt20=2;
					int LA20_0 = input.LA(1);
					if ( (LA20_0=='E'||LA20_0=='e') ) {
						alt20=1;
					}
					switch (alt20) {
						case 1 :
							// InternalParser.g:10346:60: RULE_EXPONENT
							{
							mRULE_EXPONENT(); 

							}
							break;

					}

					// InternalParser.g:10346:75: ( RULE_FLOAT_TYPE_SUFFIX )?
					int alt21=2;
					int LA21_0 = input.LA(1);
					if ( (LA21_0=='D'||LA21_0=='F'||LA21_0=='d'||LA21_0=='f') ) {
						alt21=1;
					}
					switch (alt21) {
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
					// InternalParser.g:10346:99: RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )?
					{
					mRULE_SKW_DOT(); 

					// InternalParser.g:10346:112: ( '0' .. '9' )+
					int cnt22=0;
					loop22:
					while (true) {
						int alt22=2;
						int LA22_0 = input.LA(1);
						if ( ((LA22_0 >= '0' && LA22_0 <= '9')) ) {
							alt22=1;
						}

						switch (alt22) {
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
							if ( cnt22 >= 1 ) break loop22;
							EarlyExitException eee = new EarlyExitException(22, input);
							throw eee;
						}
						cnt22++;
					}

					// InternalParser.g:10346:124: ( RULE_EXPONENT )?
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0=='E'||LA23_0=='e') ) {
						alt23=1;
					}
					switch (alt23) {
						case 1 :
							// InternalParser.g:10346:124: RULE_EXPONENT
							{
							mRULE_EXPONENT(); 

							}
							break;

					}

					// InternalParser.g:10346:139: ( RULE_FLOAT_TYPE_SUFFIX )?
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
				case 3 :
					// InternalParser.g:10346:163: ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )?
					{
					// InternalParser.g:10346:163: ( '0' .. '9' )+
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

					mRULE_EXPONENT(); 

					// InternalParser.g:10346:189: ( RULE_FLOAT_TYPE_SUFFIX )?
					int alt26=2;
					int LA26_0 = input.LA(1);
					if ( (LA26_0=='D'||LA26_0=='F'||LA26_0=='d'||LA26_0=='f') ) {
						alt26=1;
					}
					switch (alt26) {
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
					// InternalParser.g:10346:213: ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX
					{
					// InternalParser.g:10346:213: ( '0' .. '9' )+
					int cnt27=0;
					loop27:
					while (true) {
						int alt27=2;
						int LA27_0 = input.LA(1);
						if ( ((LA27_0 >= '0' && LA27_0 <= '9')) ) {
							alt27=1;
						}

						switch (alt27) {
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
							if ( cnt27 >= 1 ) break loop27;
							EarlyExitException eee = new EarlyExitException(27, input);
							throw eee;
						}
						cnt27++;
					}

					// InternalParser.g:10346:225: ( RULE_EXPONENT )?
					int alt28=2;
					int LA28_0 = input.LA(1);
					if ( (LA28_0=='E'||LA28_0=='e') ) {
						alt28=1;
					}
					switch (alt28) {
						case 1 :
							// InternalParser.g:10346:225: RULE_EXPONENT
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
			// InternalParser.g:10348:24: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
			// InternalParser.g:10348:26: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// InternalParser.g:10348:36: ( '+' | '-' )?
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0=='+'||LA30_0=='-') ) {
				alt30=1;
			}
			switch (alt30) {
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

			// InternalParser.g:10348:47: ( '0' .. '9' )+
			int cnt31=0;
			loop31:
			while (true) {
				int alt31=2;
				int LA31_0 = input.LA(1);
				if ( ((LA31_0 >= '0' && LA31_0 <= '9')) ) {
					alt31=1;
				}

				switch (alt31) {
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
					if ( cnt31 >= 1 ) break loop31;
					EarlyExitException eee = new EarlyExitException(31, input);
					throw eee;
				}
				cnt31++;
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
			// InternalParser.g:10350:33: ( ( 'f' | 'F' | 'd' | 'D' ) )
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
			// InternalParser.g:10352:31: ( ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE | RULE_HEX_ESCAPE ) )
			// InternalParser.g:10352:33: ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE | RULE_HEX_ESCAPE )
			{
			// InternalParser.g:10352:33: ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE | RULE_HEX_ESCAPE )
			int alt32=3;
			int LA32_0 = input.LA(1);
			if ( (LA32_0=='\\') ) {
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
					alt32=1;
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
					alt32=2;
					}
					break;
				case 'x':
					{
					alt32=3;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 32, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 32, 0, input);
				throw nvae;
			}

			switch (alt32) {
				case 1 :
					// InternalParser.g:10352:34: RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH )
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
					// InternalParser.g:10352:119: RULE_OCTAL_ESCAPE
					{
					mRULE_OCTAL_ESCAPE(); 

					}
					break;
				case 3 :
					// InternalParser.g:10352:137: RULE_HEX_ESCAPE
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
			// InternalParser.g:10354:28: ( ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' ) )
			// InternalParser.g:10354:30: ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' )
			{
			// InternalParser.g:10354:30: ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' )
			int alt33=3;
			int LA33_0 = input.LA(1);
			if ( (LA33_0=='\\') ) {
				int LA33_1 = input.LA(2);
				if ( ((LA33_1 >= '0' && LA33_1 <= '3')) ) {
					int LA33_2 = input.LA(3);
					if ( ((LA33_2 >= '0' && LA33_2 <= '7')) ) {
						int LA33_4 = input.LA(4);
						if ( ((LA33_4 >= '0' && LA33_4 <= '7')) ) {
							alt33=1;
						}

						else {
							alt33=2;
						}

					}

					else {
						alt33=3;
					}

				}
				else if ( ((LA33_1 >= '4' && LA33_1 <= '7')) ) {
					int LA33_3 = input.LA(3);
					if ( ((LA33_3 >= '0' && LA33_3 <= '7')) ) {
						alt33=2;
					}

					else {
						alt33=3;
					}

				}

				else {
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
					// InternalParser.g:10354:31: RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7'
					{
					mRULE_SKW_BACKSLASH(); 

					matchRange('0','3'); 
					matchRange('0','7'); 
					matchRange('0','7'); 
					}
					break;
				case 2 :
					// InternalParser.g:10354:77: RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7'
					{
					mRULE_SKW_BACKSLASH(); 

					matchRange('0','7'); 
					matchRange('0','7'); 
					}
					break;
				case 3 :
					// InternalParser.g:10354:114: RULE_SKW_BACKSLASH '0' .. '7'
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
			// InternalParser.g:10356:26: ( RULE_SKW_BACKSLASH 'x' ( RULE_HEX_DIGIT )+ )
			// InternalParser.g:10356:28: RULE_SKW_BACKSLASH 'x' ( RULE_HEX_DIGIT )+
			{
			mRULE_SKW_BACKSLASH(); 

			match('x'); 
			// InternalParser.g:10356:51: ( RULE_HEX_DIGIT )+
			int cnt34=0;
			loop34:
			while (true) {
				int alt34=2;
				int LA34_0 = input.LA(1);
				if ( ((LA34_0 >= '0' && LA34_0 <= '9')||(LA34_0 >= 'A' && LA34_0 <= 'F')||(LA34_0 >= 'a' && LA34_0 <= 'f')) ) {
					alt34=1;
				}

				switch (alt34) {
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
					if ( cnt34 >= 1 ) break loop34;
					EarlyExitException eee = new EarlyExitException(34, input);
					throw eee;
				}
				cnt34++;
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
			// InternalParser.g:10358:24: ( '\\n' )
			// InternalParser.g:10358:26: '\\n'
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
			// InternalParser.g:10360:30: ( '\\r' )
			// InternalParser.g:10360:32: '\\r'
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
			// InternalParser.g:10362:24: ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) )
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

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_LINE_END"

	// $ANTLR start "RULE_LINEBREAK"
	public final void mRULE_LINEBREAK() throws RecognitionException {
		try {
			int _type = RULE_LINEBREAK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10364:16: ( RULE_SKW_BACKSLASH RULE_LINE_END )
			// InternalParser.g:10364:18: RULE_SKW_BACKSLASH RULE_LINE_END
			{
			mRULE_SKW_BACKSLASH(); 

			mRULE_LINE_END(); 

			}

			state.type = _type;
			state.channel = _channel;
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
			// InternalParser.g:10366:14: ( RULE_LINE_END )
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

	// $ANTLR start "RULE_SPACE"
	public final void mRULE_SPACE() throws RecognitionException {
		try {
			// InternalParser.g:10368:21: ( ' ' )
			// InternalParser.g:10368:23: ' '
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
			// InternalParser.g:10370:19: ( '\\t' )
			// InternalParser.g:10370:21: '\\t'
			{
			match('\t'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_TAB"

	// $ANTLR start "RULE_BLOCK_COMMENT"
	public final void mRULE_BLOCK_COMMENT() throws RecognitionException {
		try {
			int _type = RULE_BLOCK_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10372:20: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// InternalParser.g:10372:22: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// InternalParser.g:10372:27: ( options {greedy=false; } : . )*
			loop35:
			while (true) {
				int alt35=2;
				int LA35_0 = input.LA(1);
				if ( (LA35_0=='*') ) {
					int LA35_1 = input.LA(2);
					if ( (LA35_1=='/') ) {
						alt35=2;
					}
					else if ( ((LA35_1 >= '\u0000' && LA35_1 <= '.')||(LA35_1 >= '0' && LA35_1 <= '\uFFFF')) ) {
						alt35=1;
					}

				}
				else if ( ((LA35_0 >= '\u0000' && LA35_0 <= ')')||(LA35_0 >= '+' && LA35_0 <= '\uFFFF')) ) {
					alt35=1;
				}

				switch (alt35) {
				case 1 :
					// InternalParser.g:10372:55: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop35;
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
			// InternalParser.g:10374:19: ( '//' (~ ( RULE_LINE_END ) )* )
			// InternalParser.g:10374:21: '//' (~ ( RULE_LINE_END ) )*
			{
			match("//"); 

			// InternalParser.g:10374:26: (~ ( RULE_LINE_END ) )*
			loop36:
			while (true) {
				int alt36=2;
				int LA36_0 = input.LA(1);
				if ( ((LA36_0 >= '\u0000' && LA36_0 <= '\t')||(LA36_0 >= '\u000B' && LA36_0 <= '\f')||(LA36_0 >= '\u000E' && LA36_0 <= '\uFFFF')) ) {
					alt36=1;
				}

				switch (alt36) {
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
	// $ANTLR end "RULE_LINE_COMMENT"

	// $ANTLR start "RULE_SPECIAL"
	public final void mRULE_SPECIAL() throws RecognitionException {
		try {
			int _type = RULE_SPECIAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:10376:14: ( . )
			// InternalParser.g:10376:16: .
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
		// InternalParser.g:1:8: ( RULE_KW_ATOMIC | RULE_KW_AUTO | RULE_KW_ALIGNAS | RULE_KW_ALIGNOF | RULE_KW_ASM1 | RULE_KW_ASM2 | RULE_KW_BOOL | RULE_KW_BREAK | RULE_KW_BUILTIN_VA_LIST | RULE_KW_CASE | RULE_KW_CHAR | RULE_KW_COMPLEX | RULE_KW_CONST | RULE_KW_CONTINUE | RULE_KW_DEFAULT | RULE_KW_DO | RULE_KW_DOUBLE | RULE_KW_ELSE | RULE_KW_ENUM | RULE_KW_EXTERN | RULE_KW_FLOAT | RULE_KW_FOR | RULE_KW_GENERIC | RULE_KW_GOTO | RULE_KW_IF | RULE_KW_IMAGINARY | RULE_KW_INLINE | RULE_KW_INT | RULE_KW_LONG | RULE_KW_M128 | RULE_KW_M128D | RULE_KW_M128I | RULE_KW_NORETURN | RULE_KW_PRAGMA | RULE_KW_REGISTER | RULE_KW_RESTRICT | RULE_KW_RETURN | RULE_KW_SHORT | RULE_KW_SIGNED | RULE_KW_SIZEOF | RULE_KW_STATIC | RULE_KW_STATICASSERT | RULE_KW_STRUCT | RULE_KW_SWITCH | RULE_KW_THREADLOCAL | RULE_KW_TYPEDEF | RULE_KW_UNION | RULE_KW_UNSIGNED | RULE_KW_VOID | RULE_KW_VOLATILE | RULE_KW_VOLATILE2 | RULE_KW_WHILE | RULE_STARASSIGN | RULE_DIVASSIGN | RULE_MODASSIGN | RULE_PLUSASSIGN | RULE_MINUSASSIGN | RULE_LEFTSHIFTASSIGN | RULE_RIGHTSHIFTASSIGN | RULE_ANDASSIGN | RULE_XORASSIGN | RULE_ORASSIGN | RULE_ARROW | RULE_ELLIPSIS | RULE_LINEDIRECTIVE | RULE_WHITESPACE | RULE_SKW_AND | RULE_SKW_ANDAND | RULE_SKW_ASSIGN | RULE_SKW_BACKSLASH | RULE_SKW_CARET | RULE_SKW_COMMA | RULE_SKW_COLON | RULE_SKW_DIV | RULE_SKW_DOT | RULE_SKW_DOUBLEQUOTE | RULE_SKW_EQUAL | RULE_SKW_GREATER | RULE_SKW_GREATEREQUAL | RULE_SKW_LEFTBRACE | RULE_SKW_LEFTBRACKET | RULE_SKW_LEFTPAREN | RULE_SKW_LEFTSHIFT | RULE_SKW_LESS | RULE_SKW_LESSEQUAL | RULE_SKW_MINUS | RULE_SKW_MINUSMINUS | RULE_SKW_MOD | RULE_SKW_NOT | RULE_SKW_NOTEQUAL | RULE_SKW_OR | RULE_SKW_OROR | RULE_SKW_PLUS | RULE_SKW_PLUSPLUS | RULE_SKW_QUESTION | RULE_SKW_RIGHTBRACE | RULE_SKW_RIGHTBRACKET | RULE_SKW_RIGHTPAREN | RULE_SKW_RIGHTSHIFT | RULE_SKW_SEMI | RULE_SKW_SINGLEQUOTE | RULE_SKW_STAR | RULE_SKW_TILDE | RULE_ID | RULE_CHAR_LITERAL | RULE_STRING_LITERAL | RULE_HEX_LITERAL | RULE_DECIMAL_LITERAL | RULE_OCTAL_LITERAL | RULE_BIN_LITERAL | RULE_FLOAT_LITERAL | RULE_LINEBREAK | RULE_NEWLINE | RULE_BLOCK_COMMENT | RULE_LINE_COMMENT | RULE_SPECIAL )
		int alt37=116;
		alt37 = dfa37.predict(input);
		switch (alt37) {
			case 1 :
				// InternalParser.g:1:10: RULE_KW_ATOMIC
				{
				mRULE_KW_ATOMIC(); 

				}
				break;
			case 2 :
				// InternalParser.g:1:25: RULE_KW_AUTO
				{
				mRULE_KW_AUTO(); 

				}
				break;
			case 3 :
				// InternalParser.g:1:38: RULE_KW_ALIGNAS
				{
				mRULE_KW_ALIGNAS(); 

				}
				break;
			case 4 :
				// InternalParser.g:1:54: RULE_KW_ALIGNOF
				{
				mRULE_KW_ALIGNOF(); 

				}
				break;
			case 5 :
				// InternalParser.g:1:70: RULE_KW_ASM1
				{
				mRULE_KW_ASM1(); 

				}
				break;
			case 6 :
				// InternalParser.g:1:83: RULE_KW_ASM2
				{
				mRULE_KW_ASM2(); 

				}
				break;
			case 7 :
				// InternalParser.g:1:96: RULE_KW_BOOL
				{
				mRULE_KW_BOOL(); 

				}
				break;
			case 8 :
				// InternalParser.g:1:109: RULE_KW_BREAK
				{
				mRULE_KW_BREAK(); 

				}
				break;
			case 9 :
				// InternalParser.g:1:123: RULE_KW_BUILTIN_VA_LIST
				{
				mRULE_KW_BUILTIN_VA_LIST(); 

				}
				break;
			case 10 :
				// InternalParser.g:1:147: RULE_KW_CASE
				{
				mRULE_KW_CASE(); 

				}
				break;
			case 11 :
				// InternalParser.g:1:160: RULE_KW_CHAR
				{
				mRULE_KW_CHAR(); 

				}
				break;
			case 12 :
				// InternalParser.g:1:173: RULE_KW_COMPLEX
				{
				mRULE_KW_COMPLEX(); 

				}
				break;
			case 13 :
				// InternalParser.g:1:189: RULE_KW_CONST
				{
				mRULE_KW_CONST(); 

				}
				break;
			case 14 :
				// InternalParser.g:1:203: RULE_KW_CONTINUE
				{
				mRULE_KW_CONTINUE(); 

				}
				break;
			case 15 :
				// InternalParser.g:1:220: RULE_KW_DEFAULT
				{
				mRULE_KW_DEFAULT(); 

				}
				break;
			case 16 :
				// InternalParser.g:1:236: RULE_KW_DO
				{
				mRULE_KW_DO(); 

				}
				break;
			case 17 :
				// InternalParser.g:1:247: RULE_KW_DOUBLE
				{
				mRULE_KW_DOUBLE(); 

				}
				break;
			case 18 :
				// InternalParser.g:1:262: RULE_KW_ELSE
				{
				mRULE_KW_ELSE(); 

				}
				break;
			case 19 :
				// InternalParser.g:1:275: RULE_KW_ENUM
				{
				mRULE_KW_ENUM(); 

				}
				break;
			case 20 :
				// InternalParser.g:1:288: RULE_KW_EXTERN
				{
				mRULE_KW_EXTERN(); 

				}
				break;
			case 21 :
				// InternalParser.g:1:303: RULE_KW_FLOAT
				{
				mRULE_KW_FLOAT(); 

				}
				break;
			case 22 :
				// InternalParser.g:1:317: RULE_KW_FOR
				{
				mRULE_KW_FOR(); 

				}
				break;
			case 23 :
				// InternalParser.g:1:329: RULE_KW_GENERIC
				{
				mRULE_KW_GENERIC(); 

				}
				break;
			case 24 :
				// InternalParser.g:1:345: RULE_KW_GOTO
				{
				mRULE_KW_GOTO(); 

				}
				break;
			case 25 :
				// InternalParser.g:1:358: RULE_KW_IF
				{
				mRULE_KW_IF(); 

				}
				break;
			case 26 :
				// InternalParser.g:1:369: RULE_KW_IMAGINARY
				{
				mRULE_KW_IMAGINARY(); 

				}
				break;
			case 27 :
				// InternalParser.g:1:387: RULE_KW_INLINE
				{
				mRULE_KW_INLINE(); 

				}
				break;
			case 28 :
				// InternalParser.g:1:402: RULE_KW_INT
				{
				mRULE_KW_INT(); 

				}
				break;
			case 29 :
				// InternalParser.g:1:414: RULE_KW_LONG
				{
				mRULE_KW_LONG(); 

				}
				break;
			case 30 :
				// InternalParser.g:1:427: RULE_KW_M128
				{
				mRULE_KW_M128(); 

				}
				break;
			case 31 :
				// InternalParser.g:1:440: RULE_KW_M128D
				{
				mRULE_KW_M128D(); 

				}
				break;
			case 32 :
				// InternalParser.g:1:454: RULE_KW_M128I
				{
				mRULE_KW_M128I(); 

				}
				break;
			case 33 :
				// InternalParser.g:1:468: RULE_KW_NORETURN
				{
				mRULE_KW_NORETURN(); 

				}
				break;
			case 34 :
				// InternalParser.g:1:485: RULE_KW_PRAGMA
				{
				mRULE_KW_PRAGMA(); 

				}
				break;
			case 35 :
				// InternalParser.g:1:500: RULE_KW_REGISTER
				{
				mRULE_KW_REGISTER(); 

				}
				break;
			case 36 :
				// InternalParser.g:1:517: RULE_KW_RESTRICT
				{
				mRULE_KW_RESTRICT(); 

				}
				break;
			case 37 :
				// InternalParser.g:1:534: RULE_KW_RETURN
				{
				mRULE_KW_RETURN(); 

				}
				break;
			case 38 :
				// InternalParser.g:1:549: RULE_KW_SHORT
				{
				mRULE_KW_SHORT(); 

				}
				break;
			case 39 :
				// InternalParser.g:1:563: RULE_KW_SIGNED
				{
				mRULE_KW_SIGNED(); 

				}
				break;
			case 40 :
				// InternalParser.g:1:578: RULE_KW_SIZEOF
				{
				mRULE_KW_SIZEOF(); 

				}
				break;
			case 41 :
				// InternalParser.g:1:593: RULE_KW_STATIC
				{
				mRULE_KW_STATIC(); 

				}
				break;
			case 42 :
				// InternalParser.g:1:608: RULE_KW_STATICASSERT
				{
				mRULE_KW_STATICASSERT(); 

				}
				break;
			case 43 :
				// InternalParser.g:1:629: RULE_KW_STRUCT
				{
				mRULE_KW_STRUCT(); 

				}
				break;
			case 44 :
				// InternalParser.g:1:644: RULE_KW_SWITCH
				{
				mRULE_KW_SWITCH(); 

				}
				break;
			case 45 :
				// InternalParser.g:1:659: RULE_KW_THREADLOCAL
				{
				mRULE_KW_THREADLOCAL(); 

				}
				break;
			case 46 :
				// InternalParser.g:1:679: RULE_KW_TYPEDEF
				{
				mRULE_KW_TYPEDEF(); 

				}
				break;
			case 47 :
				// InternalParser.g:1:695: RULE_KW_UNION
				{
				mRULE_KW_UNION(); 

				}
				break;
			case 48 :
				// InternalParser.g:1:709: RULE_KW_UNSIGNED
				{
				mRULE_KW_UNSIGNED(); 

				}
				break;
			case 49 :
				// InternalParser.g:1:726: RULE_KW_VOID
				{
				mRULE_KW_VOID(); 

				}
				break;
			case 50 :
				// InternalParser.g:1:739: RULE_KW_VOLATILE
				{
				mRULE_KW_VOLATILE(); 

				}
				break;
			case 51 :
				// InternalParser.g:1:756: RULE_KW_VOLATILE2
				{
				mRULE_KW_VOLATILE2(); 

				}
				break;
			case 52 :
				// InternalParser.g:1:774: RULE_KW_WHILE
				{
				mRULE_KW_WHILE(); 

				}
				break;
			case 53 :
				// InternalParser.g:1:788: RULE_STARASSIGN
				{
				mRULE_STARASSIGN(); 

				}
				break;
			case 54 :
				// InternalParser.g:1:804: RULE_DIVASSIGN
				{
				mRULE_DIVASSIGN(); 

				}
				break;
			case 55 :
				// InternalParser.g:1:819: RULE_MODASSIGN
				{
				mRULE_MODASSIGN(); 

				}
				break;
			case 56 :
				// InternalParser.g:1:834: RULE_PLUSASSIGN
				{
				mRULE_PLUSASSIGN(); 

				}
				break;
			case 57 :
				// InternalParser.g:1:850: RULE_MINUSASSIGN
				{
				mRULE_MINUSASSIGN(); 

				}
				break;
			case 58 :
				// InternalParser.g:1:867: RULE_LEFTSHIFTASSIGN
				{
				mRULE_LEFTSHIFTASSIGN(); 

				}
				break;
			case 59 :
				// InternalParser.g:1:888: RULE_RIGHTSHIFTASSIGN
				{
				mRULE_RIGHTSHIFTASSIGN(); 

				}
				break;
			case 60 :
				// InternalParser.g:1:910: RULE_ANDASSIGN
				{
				mRULE_ANDASSIGN(); 

				}
				break;
			case 61 :
				// InternalParser.g:1:925: RULE_XORASSIGN
				{
				mRULE_XORASSIGN(); 

				}
				break;
			case 62 :
				// InternalParser.g:1:940: RULE_ORASSIGN
				{
				mRULE_ORASSIGN(); 

				}
				break;
			case 63 :
				// InternalParser.g:1:954: RULE_ARROW
				{
				mRULE_ARROW(); 

				}
				break;
			case 64 :
				// InternalParser.g:1:965: RULE_ELLIPSIS
				{
				mRULE_ELLIPSIS(); 

				}
				break;
			case 65 :
				// InternalParser.g:1:979: RULE_LINEDIRECTIVE
				{
				mRULE_LINEDIRECTIVE(); 

				}
				break;
			case 66 :
				// InternalParser.g:1:998: RULE_WHITESPACE
				{
				mRULE_WHITESPACE(); 

				}
				break;
			case 67 :
				// InternalParser.g:1:1014: RULE_SKW_AND
				{
				mRULE_SKW_AND(); 

				}
				break;
			case 68 :
				// InternalParser.g:1:1027: RULE_SKW_ANDAND
				{
				mRULE_SKW_ANDAND(); 

				}
				break;
			case 69 :
				// InternalParser.g:1:1043: RULE_SKW_ASSIGN
				{
				mRULE_SKW_ASSIGN(); 

				}
				break;
			case 70 :
				// InternalParser.g:1:1059: RULE_SKW_BACKSLASH
				{
				mRULE_SKW_BACKSLASH(); 

				}
				break;
			case 71 :
				// InternalParser.g:1:1078: RULE_SKW_CARET
				{
				mRULE_SKW_CARET(); 

				}
				break;
			case 72 :
				// InternalParser.g:1:1093: RULE_SKW_COMMA
				{
				mRULE_SKW_COMMA(); 

				}
				break;
			case 73 :
				// InternalParser.g:1:1108: RULE_SKW_COLON
				{
				mRULE_SKW_COLON(); 

				}
				break;
			case 74 :
				// InternalParser.g:1:1123: RULE_SKW_DIV
				{
				mRULE_SKW_DIV(); 

				}
				break;
			case 75 :
				// InternalParser.g:1:1136: RULE_SKW_DOT
				{
				mRULE_SKW_DOT(); 

				}
				break;
			case 76 :
				// InternalParser.g:1:1149: RULE_SKW_DOUBLEQUOTE
				{
				mRULE_SKW_DOUBLEQUOTE(); 

				}
				break;
			case 77 :
				// InternalParser.g:1:1170: RULE_SKW_EQUAL
				{
				mRULE_SKW_EQUAL(); 

				}
				break;
			case 78 :
				// InternalParser.g:1:1185: RULE_SKW_GREATER
				{
				mRULE_SKW_GREATER(); 

				}
				break;
			case 79 :
				// InternalParser.g:1:1202: RULE_SKW_GREATEREQUAL
				{
				mRULE_SKW_GREATEREQUAL(); 

				}
				break;
			case 80 :
				// InternalParser.g:1:1224: RULE_SKW_LEFTBRACE
				{
				mRULE_SKW_LEFTBRACE(); 

				}
				break;
			case 81 :
				// InternalParser.g:1:1243: RULE_SKW_LEFTBRACKET
				{
				mRULE_SKW_LEFTBRACKET(); 

				}
				break;
			case 82 :
				// InternalParser.g:1:1264: RULE_SKW_LEFTPAREN
				{
				mRULE_SKW_LEFTPAREN(); 

				}
				break;
			case 83 :
				// InternalParser.g:1:1283: RULE_SKW_LEFTSHIFT
				{
				mRULE_SKW_LEFTSHIFT(); 

				}
				break;
			case 84 :
				// InternalParser.g:1:1302: RULE_SKW_LESS
				{
				mRULE_SKW_LESS(); 

				}
				break;
			case 85 :
				// InternalParser.g:1:1316: RULE_SKW_LESSEQUAL
				{
				mRULE_SKW_LESSEQUAL(); 

				}
				break;
			case 86 :
				// InternalParser.g:1:1335: RULE_SKW_MINUS
				{
				mRULE_SKW_MINUS(); 

				}
				break;
			case 87 :
				// InternalParser.g:1:1350: RULE_SKW_MINUSMINUS
				{
				mRULE_SKW_MINUSMINUS(); 

				}
				break;
			case 88 :
				// InternalParser.g:1:1370: RULE_SKW_MOD
				{
				mRULE_SKW_MOD(); 

				}
				break;
			case 89 :
				// InternalParser.g:1:1383: RULE_SKW_NOT
				{
				mRULE_SKW_NOT(); 

				}
				break;
			case 90 :
				// InternalParser.g:1:1396: RULE_SKW_NOTEQUAL
				{
				mRULE_SKW_NOTEQUAL(); 

				}
				break;
			case 91 :
				// InternalParser.g:1:1414: RULE_SKW_OR
				{
				mRULE_SKW_OR(); 

				}
				break;
			case 92 :
				// InternalParser.g:1:1426: RULE_SKW_OROR
				{
				mRULE_SKW_OROR(); 

				}
				break;
			case 93 :
				// InternalParser.g:1:1440: RULE_SKW_PLUS
				{
				mRULE_SKW_PLUS(); 

				}
				break;
			case 94 :
				// InternalParser.g:1:1454: RULE_SKW_PLUSPLUS
				{
				mRULE_SKW_PLUSPLUS(); 

				}
				break;
			case 95 :
				// InternalParser.g:1:1472: RULE_SKW_QUESTION
				{
				mRULE_SKW_QUESTION(); 

				}
				break;
			case 96 :
				// InternalParser.g:1:1490: RULE_SKW_RIGHTBRACE
				{
				mRULE_SKW_RIGHTBRACE(); 

				}
				break;
			case 97 :
				// InternalParser.g:1:1510: RULE_SKW_RIGHTBRACKET
				{
				mRULE_SKW_RIGHTBRACKET(); 

				}
				break;
			case 98 :
				// InternalParser.g:1:1532: RULE_SKW_RIGHTPAREN
				{
				mRULE_SKW_RIGHTPAREN(); 

				}
				break;
			case 99 :
				// InternalParser.g:1:1552: RULE_SKW_RIGHTSHIFT
				{
				mRULE_SKW_RIGHTSHIFT(); 

				}
				break;
			case 100 :
				// InternalParser.g:1:1572: RULE_SKW_SEMI
				{
				mRULE_SKW_SEMI(); 

				}
				break;
			case 101 :
				// InternalParser.g:1:1586: RULE_SKW_SINGLEQUOTE
				{
				mRULE_SKW_SINGLEQUOTE(); 

				}
				break;
			case 102 :
				// InternalParser.g:1:1607: RULE_SKW_STAR
				{
				mRULE_SKW_STAR(); 

				}
				break;
			case 103 :
				// InternalParser.g:1:1621: RULE_SKW_TILDE
				{
				mRULE_SKW_TILDE(); 

				}
				break;
			case 104 :
				// InternalParser.g:1:1636: RULE_ID
				{
				mRULE_ID(); 

				}
				break;
			case 105 :
				// InternalParser.g:1:1644: RULE_CHAR_LITERAL
				{
				mRULE_CHAR_LITERAL(); 

				}
				break;
			case 106 :
				// InternalParser.g:1:1662: RULE_STRING_LITERAL
				{
				mRULE_STRING_LITERAL(); 

				}
				break;
			case 107 :
				// InternalParser.g:1:1682: RULE_HEX_LITERAL
				{
				mRULE_HEX_LITERAL(); 

				}
				break;
			case 108 :
				// InternalParser.g:1:1699: RULE_DECIMAL_LITERAL
				{
				mRULE_DECIMAL_LITERAL(); 

				}
				break;
			case 109 :
				// InternalParser.g:1:1720: RULE_OCTAL_LITERAL
				{
				mRULE_OCTAL_LITERAL(); 

				}
				break;
			case 110 :
				// InternalParser.g:1:1739: RULE_BIN_LITERAL
				{
				mRULE_BIN_LITERAL(); 

				}
				break;
			case 111 :
				// InternalParser.g:1:1756: RULE_FLOAT_LITERAL
				{
				mRULE_FLOAT_LITERAL(); 

				}
				break;
			case 112 :
				// InternalParser.g:1:1775: RULE_LINEBREAK
				{
				mRULE_LINEBREAK(); 

				}
				break;
			case 113 :
				// InternalParser.g:1:1790: RULE_NEWLINE
				{
				mRULE_NEWLINE(); 

				}
				break;
			case 114 :
				// InternalParser.g:1:1803: RULE_BLOCK_COMMENT
				{
				mRULE_BLOCK_COMMENT(); 

				}
				break;
			case 115 :
				// InternalParser.g:1:1822: RULE_LINE_COMMENT
				{
				mRULE_LINE_COMMENT(); 

				}
				break;
			case 116 :
				// InternalParser.g:1:1840: RULE_SPECIAL
				{
				mRULE_SPECIAL(); 

				}
				break;

		}
	}


	protected DFA29 dfa29 = new DFA29(this);
	protected DFA37 dfa37 = new DFA37(this);
	static final String DFA29_eotS =
		"\7\uffff\1\10\2\uffff";
	static final String DFA29_eofS =
		"\12\uffff";
	static final String DFA29_minS =
		"\2\56\2\uffff\1\53\1\uffff\2\60\2\uffff";
	static final String DFA29_maxS =
		"\1\71\1\146\2\uffff\1\71\1\uffff\1\71\1\146\2\uffff";
	static final String DFA29_acceptS =
		"\2\uffff\1\2\1\1\1\uffff\1\4\2\uffff\2\3";
	static final String DFA29_specialS =
		"\12\uffff}>";
	static final String[] DFA29_transitionS = {
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

	static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
	static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
	static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
	static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
	static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
	static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
	static final short[][] DFA29_transition;

	static {
		int numStates = DFA29_transitionS.length;
		DFA29_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
		}
	}

	protected class DFA29 extends DFA {

		public DFA29(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 29;
			this.eot = DFA29_eot;
			this.eof = DFA29_eof;
			this.min = DFA29_min;
			this.max = DFA29_max;
			this.accept = DFA29_accept;
			this.special = DFA29_special;
			this.transition = DFA29_transition;
		}
		@Override
		public String getDescription() {
			return "10346:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )";
		}
	}


	static final String DFA37_eotS =
		"\1\uffff\21\75\1\130\1\134\1\136\1\140\1\143\1\147\1\152\1\155\1\160\1\162\1\165\2\uffff\1\172\1\174\2\uffff\1\u0080\3\uffff\1\u0085\5\uffff\1\u008c\2\uffff\2\u0091\2\uffff\11\75\1\uffff\6\75\1\u00a9\6\75\1\u00b0\14\75\20\uffff\1\u00c4\2\uffff\1\u00c6\46\uffff\1\u00c8\1\u0091\1\uffff\24\75\1\uffff\4\75\1\u00e2\1\75\1\uffff\1\75\1\u00e5\21\75\5\uffff\15\75\1\u0104\1\75\1\u0106\1\u0107\4\75\1\u010c\1\u010d\2\75\1\uffff\1\u0110\1\75\1\uffff\1\u0112\15\75\1\u0120\4\75\1\u0125\2\75\1\u0128\7\75\1\uffff\1\u0131\2\uffff\1\u0132\3\75\2\uffff\1\75\1\u0137\1\uffff\1\75\1\uffff\4\75\1\u013d\6\75\1\u0144\1\75\1\uffff\1\75\1\u0147\2\75\1\uffff\1\75\1\u014e\1\uffff\10\75\2\uffff\2\75\1\u0159\1\u015a\1\uffff\1\u015b\1\u015c\2\75\1\u015f\1\uffff\1\u0160\1\u0161\1\u0162\1\u0163\1\u0164\1\75\1\uffff\2\75\1\uffff\1\u0168\3\75\1\u016c\1\u016d\1\uffff\1\u016e\10\75\1\u0177\4\uffff\2\75\6\uffff\1\u017a\2\75\1\uffff\1\u017d\1\u017e\1\75\3\uffff\1\75\1\u0181\1\u0182\4\75\1\u0187\1\uffff\1\u0188\1\u0189\1\uffff\1\u018a\1\u018b\2\uffff\2\75\2\uffff\1\75\1\u018f\2\75\5\uffff\2\75\1\u0194\1\uffff\4\75\1\uffff\3\75\1\u019c\3\75\1\uffff\1\75\1\u01a1\1\75\1\u01a3\1\uffff\1\75\1\uffff\1\75\1\u01a6\1\uffff";
	static final String DFA37_eofS =
		"\u01a7\uffff";
	static final String DFA37_minS =
		"\1\0\1\101\1\165\1\162\1\141\1\145\2\154\1\157\1\146\1\157\1\162\1\145\1\150\1\171\1\156\1\157\1\150\1\75\1\52\1\75\1\53\1\55\1\74\1\75\1\46\2\75\1\56\2\uffff\1\75\1\12\2\uffff\1\0\3\uffff\1\75\5\uffff\1\0\2\uffff\2\56\2\uffff\1\154\1\157\1\141\1\157\1\145\1\155\1\157\1\164\1\150\1\uffff\1\164\1\145\1\163\1\141\1\156\1\146\1\44\1\163\1\165\1\164\1\157\1\162\1\164\1\44\1\154\1\156\1\141\1\147\1\157\1\147\1\141\1\151\1\160\3\151\20\uffff\1\75\2\uffff\1\75\46\uffff\2\56\1\uffff\1\157\1\151\1\157\1\165\1\61\1\163\1\157\1\155\1\156\1\141\1\162\1\141\1\162\1\157\1\141\1\145\1\162\1\163\1\141\1\142\1\uffff\1\145\1\155\1\145\1\141\1\44\1\157\1\uffff\1\151\1\44\2\147\1\151\1\164\1\165\1\162\1\156\1\145\1\164\1\165\1\164\1\145\1\157\1\151\1\144\1\141\1\154\5\uffff\1\155\1\147\1\154\1\151\1\62\1\155\1\154\1\160\1\145\1\147\1\145\1\164\1\145\1\44\1\153\2\44\1\164\1\151\1\165\1\154\2\44\1\162\1\164\1\uffff\1\44\1\156\1\uffff\1\44\1\155\1\163\2\162\1\164\1\145\1\157\1\151\2\143\1\144\1\156\1\147\1\44\1\164\1\145\1\151\1\156\1\44\1\154\1\70\1\44\1\141\1\154\1\162\1\151\1\164\1\151\1\141\1\uffff\1\44\2\uffff\1\44\1\156\1\154\1\145\2\uffff\1\156\1\44\1\uffff\1\145\1\uffff\1\141\1\164\1\151\1\156\1\44\1\144\1\146\1\143\1\164\1\150\1\145\1\44\1\156\1\uffff\1\151\1\44\1\143\1\141\1\uffff\1\164\1\44\1\uffff\1\137\1\164\1\145\1\151\1\156\1\165\1\143\1\144\2\uffff\1\165\1\164\2\44\1\uffff\2\44\1\145\1\143\1\44\1\uffff\5\44\1\146\1\uffff\1\145\1\154\1\uffff\1\44\1\163\1\146\1\151\2\44\1\uffff\1\44\1\151\1\170\1\143\1\141\1\162\2\137\1\145\1\44\4\uffff\1\162\1\164\6\uffff\1\44\1\144\1\145\1\uffff\2\44\1\156\3\uffff\1\154\2\44\1\162\1\156\1\141\1\154\1\44\1\uffff\2\44\1\uffff\2\44\2\uffff\1\137\1\145\2\uffff\1\171\1\44\1\163\1\157\5\uffff\1\166\1\137\1\44\1\uffff\1\163\1\143\1\141\1\137\1\uffff\1\145\1\141\1\137\1\44\1\162\2\154\1\uffff\1\164\1\44\1\151\1\44\1\uffff\1\163\1\uffff\1\164\1\44\1\uffff";
	static final String DFA37_maxS =
		"\1\uffff\1\137\1\165\1\162\2\157\1\170\2\157\1\156\1\157\1\162\1\145\1\167\1\171\1\156\1\157\1\150\4\75\1\76\1\75\1\76\2\75\1\174\1\71\2\uffff\1\75\1\15\2\uffff\1\uffff\3\uffff\1\75\5\uffff\1\uffff\2\uffff\1\170\1\146\2\uffff\1\164\1\157\1\166\1\157\1\145\1\155\1\157\1\164\1\150\1\uffff\1\164\1\145\1\163\1\141\1\156\1\146\1\172\1\163\1\165\1\164\1\157\1\162\1\164\1\172\1\164\1\156\1\141\1\164\1\157\1\172\1\162\1\151\1\160\1\163\1\154\1\151\20\uffff\1\75\2\uffff\1\75\46\uffff\2\146\1\uffff\1\157\1\151\1\157\1\165\1\61\1\163\1\157\1\155\1\156\1\141\1\162\1\141\1\162\1\157\1\141\1\145\1\162\1\164\1\141\1\142\1\uffff\1\145\1\155\1\145\1\141\1\172\1\157\1\uffff\1\151\1\172\2\147\1\151\1\164\1\165\1\162\1\156\1\145\1\164\1\165\1\164\1\145\1\157\1\151\1\144\1\141\1\154\5\uffff\1\155\1\147\1\154\1\151\1\62\1\155\1\154\1\160\1\145\1\147\1\145\1\164\1\145\1\172\1\153\2\172\1\164\1\151\1\165\1\154\2\172\1\162\1\164\1\uffff\1\172\1\156\1\uffff\1\172\1\155\1\163\2\162\1\164\1\145\1\157\1\151\2\143\1\144\1\156\1\147\1\172\1\164\1\145\1\151\1\156\1\172\1\154\1\70\1\172\1\141\1\154\1\162\1\151\1\164\1\151\1\141\1\uffff\1\172\2\uffff\1\172\1\156\1\154\1\145\2\uffff\1\156\1\172\1\uffff\1\145\1\uffff\1\141\1\164\1\151\1\156\1\172\1\144\1\146\1\143\1\164\1\150\1\145\1\172\1\156\1\uffff\1\151\1\172\1\143\1\157\1\uffff\1\164\1\172\1\uffff\1\137\1\164\1\145\1\151\1\156\1\165\1\143\1\144\2\uffff\1\165\1\164\2\172\1\uffff\2\172\1\145\1\143\1\172\1\uffff\5\172\1\146\1\uffff\1\145\1\154\1\uffff\1\172\1\163\1\146\1\151\2\172\1\uffff\1\172\1\151\1\170\1\143\1\141\1\162\2\137\1\145\1\172\4\uffff\1\162\1\164\6\uffff\1\172\1\144\1\145\1\uffff\2\172\1\156\3\uffff\1\154\2\172\1\162\1\156\1\141\1\154\1\172\1\uffff\2\172\1\uffff\2\172\2\uffff\1\137\1\145\2\uffff\1\171\1\172\1\163\1\157\5\uffff\1\166\1\137\1\172\1\uffff\1\163\1\143\1\141\1\137\1\uffff\1\145\1\141\1\137\1\172\1\162\2\154\1\uffff\1\164\1\172\1\151\1\172\1\uffff\1\163\1\uffff\1\164\1\172\1\uffff";
	static final String DFA37_acceptS =
		"\35\uffff\1\101\1\102\2\uffff\1\110\1\111\1\uffff\1\120\1\121\1\122\1\uffff\1\137\1\140\1\141\1\142\1\144\1\uffff\1\147\1\150\2\uffff\1\161\1\164\11\uffff\1\150\32\uffff\1\146\1\65\1\162\1\163\1\112\1\66\1\130\1\67\1\135\1\70\1\136\1\126\1\71\1\77\1\127\1\124\1\uffff\1\125\1\116\1\uffff\1\117\1\103\1\74\1\104\1\107\1\75\1\133\1\76\1\134\1\113\1\100\1\157\1\101\1\102\1\105\1\115\1\106\1\160\1\110\1\111\1\114\1\152\1\120\1\121\1\122\1\131\1\132\1\137\1\140\1\141\1\142\1\144\1\145\1\151\1\147\1\153\1\156\1\154\2\uffff\1\161\24\uffff\1\20\6\uffff\1\31\23\uffff\1\123\1\72\1\143\1\73\1\155\31\uffff\1\26\2\uffff\1\34\36\uffff\1\2\1\uffff\1\12\1\13\4\uffff\1\22\1\23\2\uffff\1\30\1\uffff\1\35\15\uffff\1\61\4\uffff\1\7\2\uffff\1\5\10\uffff\1\10\1\15\4\uffff\1\25\5\uffff\1\46\6\uffff\1\57\2\uffff\1\64\6\uffff\1\36\12\uffff\1\21\1\24\1\33\1\42\2\uffff\1\45\1\47\1\50\1\51\1\53\1\54\3\uffff\1\1\3\uffff\1\37\1\40\1\6\10\uffff\1\17\2\uffff\1\56\2\uffff\1\3\1\4\2\uffff\1\14\1\27\4\uffff\1\16\1\43\1\44\1\60\1\62\3\uffff\1\41\4\uffff\1\32\7\uffff\1\63\4\uffff\1\55\1\uffff\1\52\2\uffff\1\11";
	static final String DFA37_specialS =
		"\1\1\42\uffff\1\2\11\uffff\1\0\u0179\uffff}>";
	static final String[] DFA37_transitionS = {
			"\11\63\1\36\1\62\2\63\1\62\22\63\1\36\1\47\1\43\1\35\1\57\1\24\1\31\1\55\1\46\1\53\1\22\1\25\1\41\1\26\1\34\1\23\1\60\11\61\1\42\1\54\1\27\1\37\1\30\1\50\1\63\32\57\1\45\1\40\1\52\1\32\1\1\1\63\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\57\1\11\2\57\1\12\3\57\1\13\1\57\1\14\1\15\1\16\1\17\1\20\1\21\3\57\1\44\1\33\1\51\1\56\uff81\63",
			"\1\64\1\65\1\67\3\uffff\1\70\1\uffff\1\71\4\uffff\1\72\4\uffff\1\73\1\74\12\uffff\1\66",
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
			"\1\117",
			"\1\120\1\121\12\uffff\1\122\2\uffff\1\123",
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
			"",
			"\1\173",
			"\1\175\2\uffff\1\175",
			"",
			"",
			"\0\u0081",
			"",
			"",
			"",
			"\1\u0086",
			"",
			"",
			"",
			"",
			"",
			"\47\u008d\1\uffff\uffd8\u008d",
			"",
			"",
			"\1\167\1\uffff\10\u0092\2\167\10\uffff\1\u0090\1\uffff\3\167\21\uffff\1\u008f\11\uffff\1\u0090\1\uffff\3\167\21\uffff\1\u008f",
			"\1\167\1\uffff\12\u0093\12\uffff\3\167\35\uffff\3\167",
			"",
			"",
			"\1\u0096\7\uffff\1\u0095",
			"\1\u0097",
			"\1\u009a\1\u0098\12\uffff\1\u0099\10\uffff\1\u009b",
			"\1\u009c",
			"\1\u009d",
			"\1\u009e",
			"\1\u009f",
			"\1\u00a0",
			"\1\u00a1",
			"",
			"\1\u00a2",
			"\1\u00a3",
			"\1\u00a4",
			"\1\u00a5",
			"\1\u00a6",
			"\1\u00a7",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\24\75\1\u00a8\5\75",
			"\1\u00aa",
			"\1\u00ab",
			"\1\u00ac",
			"\1\u00ad",
			"\1\u00ae",
			"\1\u00af",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u00b1\7\uffff\1\u00b2",
			"\1\u00b3",
			"\1\u00b4",
			"\1\u00b5\13\uffff\1\u00b6\1\u00b7",
			"\1\u00b8",
			"\1\u00b9\22\uffff\1\u00ba",
			"\1\u00bb\20\uffff\1\u00bc",
			"\1\u00bd",
			"\1\u00be",
			"\1\u00bf\11\uffff\1\u00c0",
			"\1\u00c1\2\uffff\1\u00c2",
			"\1\u00c3",
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
			"\1\u00c5",
			"",
			"",
			"\1\u00c7",
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
			"\1\167\1\uffff\10\u0092\2\167\12\uffff\3\167\35\uffff\3\167",
			"\1\167\1\uffff\12\u0093\12\uffff\3\167\35\uffff\3\167",
			"",
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
			"\1\u00d7",
			"\1\u00d8",
			"\1\u00d9",
			"\1\u00da\1\u00db",
			"\1\u00dc",
			"\1\u00dd",
			"",
			"\1\u00de",
			"\1\u00df",
			"\1\u00e0",
			"\1\u00e1",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u00e3",
			"",
			"\1\u00e4",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
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
			"\1\u00f4",
			"\1\u00f5",
			"\1\u00f6",
			"",
			"",
			"",
			"",
			"",
			"\1\u00f7",
			"\1\u00f8",
			"\1\u00f9",
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
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0105",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0108",
			"\1\u0109",
			"\1\u010a",
			"\1\u010b",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u010e",
			"\1\u010f",
			"",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0111",
			"",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0113",
			"\1\u0114",
			"\1\u0115",
			"\1\u0116",
			"\1\u0117",
			"\1\u0118",
			"\1\u0119",
			"\1\u011a",
			"\1\u011b",
			"\1\u011c",
			"\1\u011d",
			"\1\u011e",
			"\1\u011f",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0121",
			"\1\u0122",
			"\1\u0123",
			"\1\u0124",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0126",
			"\1\u0127",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\u0129\1\uffff\32\75",
			"\1\u012a",
			"\1\u012b",
			"\1\u012c",
			"\1\u012d",
			"\1\u012e",
			"\1\u012f",
			"\1\u0130",
			"",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"",
			"",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0133",
			"\1\u0134",
			"\1\u0135",
			"",
			"",
			"\1\u0136",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"",
			"\1\u0138",
			"",
			"\1\u0139",
			"\1\u013a",
			"\1\u013b",
			"\1\u013c",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u013e",
			"\1\u013f",
			"\1\u0140",
			"\1\u0141",
			"\1\u0142",
			"\1\u0143",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0145",
			"",
			"\1\u0146",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0148",
			"\1\u0149\15\uffff\1\u014a",
			"",
			"\1\u014b",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\3\75\1\u014c\4\75\1\u014d\21\75",
			"",
			"\1\u014f",
			"\1\u0150",
			"\1\u0151",
			"\1\u0152",
			"\1\u0153",
			"\1\u0154",
			"\1\u0155",
			"\1\u0156",
			"",
			"",
			"\1\u0157",
			"\1\u0158",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u015d",
			"\1\u015e",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0165",
			"",
			"\1\u0166",
			"\1\u0167",
			"",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0169",
			"\1\u016a",
			"\1\u016b",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u016f",
			"\1\u0170",
			"\1\u0171",
			"\1\u0172",
			"\1\u0173",
			"\1\u0174",
			"\1\u0175",
			"\1\u0176",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"",
			"",
			"",
			"",
			"\1\u0178",
			"\1\u0179",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u017b",
			"\1\u017c",
			"",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u017f",
			"",
			"",
			"",
			"\1\u0180",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0183",
			"\1\u0184",
			"\1\u0185",
			"\1\u0186",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"",
			"",
			"\1\u018c",
			"\1\u018d",
			"",
			"",
			"\1\u018e",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u0190",
			"\1\u0191",
			"",
			"",
			"",
			"",
			"",
			"\1\u0192",
			"\1\u0193",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"",
			"\1\u0195",
			"\1\u0196",
			"\1\u0197",
			"\1\u0198",
			"",
			"\1\u0199",
			"\1\u019a",
			"\1\u019b",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u019d",
			"\1\u019e",
			"\1\u019f",
			"",
			"\1\u01a0",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"\1\u01a2",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			"",
			"\1\u01a4",
			"",
			"\1\u01a5",
			"\1\75\13\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
			""
	};

	static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
	static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
	static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
	static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
	static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
	static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
	static final short[][] DFA37_transition;

	static {
		int numStates = DFA37_transitionS.length;
		DFA37_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
		}
	}

	protected class DFA37 extends DFA {

		public DFA37(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 37;
			this.eot = DFA37_eot;
			this.eof = DFA37_eof;
			this.min = DFA37_min;
			this.max = DFA37_max;
			this.accept = DFA37_accept;
			this.special = DFA37_special;
			this.transition = DFA37_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( RULE_KW_ATOMIC | RULE_KW_AUTO | RULE_KW_ALIGNAS | RULE_KW_ALIGNOF | RULE_KW_ASM1 | RULE_KW_ASM2 | RULE_KW_BOOL | RULE_KW_BREAK | RULE_KW_BUILTIN_VA_LIST | RULE_KW_CASE | RULE_KW_CHAR | RULE_KW_COMPLEX | RULE_KW_CONST | RULE_KW_CONTINUE | RULE_KW_DEFAULT | RULE_KW_DO | RULE_KW_DOUBLE | RULE_KW_ELSE | RULE_KW_ENUM | RULE_KW_EXTERN | RULE_KW_FLOAT | RULE_KW_FOR | RULE_KW_GENERIC | RULE_KW_GOTO | RULE_KW_IF | RULE_KW_IMAGINARY | RULE_KW_INLINE | RULE_KW_INT | RULE_KW_LONG | RULE_KW_M128 | RULE_KW_M128D | RULE_KW_M128I | RULE_KW_NORETURN | RULE_KW_PRAGMA | RULE_KW_REGISTER | RULE_KW_RESTRICT | RULE_KW_RETURN | RULE_KW_SHORT | RULE_KW_SIGNED | RULE_KW_SIZEOF | RULE_KW_STATIC | RULE_KW_STATICASSERT | RULE_KW_STRUCT | RULE_KW_SWITCH | RULE_KW_THREADLOCAL | RULE_KW_TYPEDEF | RULE_KW_UNION | RULE_KW_UNSIGNED | RULE_KW_VOID | RULE_KW_VOLATILE | RULE_KW_VOLATILE2 | RULE_KW_WHILE | RULE_STARASSIGN | RULE_DIVASSIGN | RULE_MODASSIGN | RULE_PLUSASSIGN | RULE_MINUSASSIGN | RULE_LEFTSHIFTASSIGN | RULE_RIGHTSHIFTASSIGN | RULE_ANDASSIGN | RULE_XORASSIGN | RULE_ORASSIGN | RULE_ARROW | RULE_ELLIPSIS | RULE_LINEDIRECTIVE | RULE_WHITESPACE | RULE_SKW_AND | RULE_SKW_ANDAND | RULE_SKW_ASSIGN | RULE_SKW_BACKSLASH | RULE_SKW_CARET | RULE_SKW_COMMA | RULE_SKW_COLON | RULE_SKW_DIV | RULE_SKW_DOT | RULE_SKW_DOUBLEQUOTE | RULE_SKW_EQUAL | RULE_SKW_GREATER | RULE_SKW_GREATEREQUAL | RULE_SKW_LEFTBRACE | RULE_SKW_LEFTBRACKET | RULE_SKW_LEFTPAREN | RULE_SKW_LEFTSHIFT | RULE_SKW_LESS | RULE_SKW_LESSEQUAL | RULE_SKW_MINUS | RULE_SKW_MINUSMINUS | RULE_SKW_MOD | RULE_SKW_NOT | RULE_SKW_NOTEQUAL | RULE_SKW_OR | RULE_SKW_OROR | RULE_SKW_PLUS | RULE_SKW_PLUSPLUS | RULE_SKW_QUESTION | RULE_SKW_RIGHTBRACE | RULE_SKW_RIGHTBRACKET | RULE_SKW_RIGHTPAREN | RULE_SKW_RIGHTSHIFT | RULE_SKW_SEMI | RULE_SKW_SINGLEQUOTE | RULE_SKW_STAR | RULE_SKW_TILDE | RULE_ID | RULE_CHAR_LITERAL | RULE_STRING_LITERAL | RULE_HEX_LITERAL | RULE_DECIMAL_LITERAL | RULE_OCTAL_LITERAL | RULE_BIN_LITERAL | RULE_FLOAT_LITERAL | RULE_LINEBREAK | RULE_NEWLINE | RULE_BLOCK_COMMENT | RULE_LINE_COMMENT | RULE_SPECIAL );";
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
				new NoViableAltException(getDescription(), 37, _s, input);
			error(nvae);
			throw nvae;
		}
			private int specialState0(int s, IntStream _input) {
				IntStream input = _input;
				int LA37_45 = input.LA(1);
				s = -1;
				if ( ((LA37_45 >= '\u0000' && LA37_45 <= '&')||(LA37_45 >= '(' && LA37_45 <= '\uFFFF')) ) {s = 141;}
				else s = 140;
				//if ( s>=0 ) return s;
				//break;
				return s;
			}

			private int specialState1(int s, IntStream _input) {
				IntStream input = _input;
				int LA37_0 = input.LA(1);
				s = -1;
				if ( (LA37_0=='_') ) {s = 1;}
				else if ( (LA37_0=='a') ) {s = 2;}
				else if ( (LA37_0=='b') ) {s = 3;}
				else if ( (LA37_0=='c') ) {s = 4;}
				else if ( (LA37_0=='d') ) {s = 5;}
				else if ( (LA37_0=='e') ) {s = 6;}
				else if ( (LA37_0=='f') ) {s = 7;}
				else if ( (LA37_0=='g') ) {s = 8;}
				else if ( (LA37_0=='i') ) {s = 9;}
				else if ( (LA37_0=='l') ) {s = 10;}
				else if ( (LA37_0=='p') ) {s = 11;}
				else if ( (LA37_0=='r') ) {s = 12;}
				else if ( (LA37_0=='s') ) {s = 13;}
				else if ( (LA37_0=='t') ) {s = 14;}
				else if ( (LA37_0=='u') ) {s = 15;}
				else if ( (LA37_0=='v') ) {s = 16;}
				else if ( (LA37_0=='w') ) {s = 17;}
				else if ( (LA37_0=='*') ) {s = 18;}
				else if ( (LA37_0=='/') ) {s = 19;}
				else if ( (LA37_0=='%') ) {s = 20;}
				else if ( (LA37_0=='+') ) {s = 21;}
				else if ( (LA37_0=='-') ) {s = 22;}
				else if ( (LA37_0=='<') ) {s = 23;}
				else if ( (LA37_0=='>') ) {s = 24;}
				else if ( (LA37_0=='&') ) {s = 25;}
				else if ( (LA37_0=='^') ) {s = 26;}
				else if ( (LA37_0=='|') ) {s = 27;}
				else if ( (LA37_0=='.') ) {s = 28;}
				else if ( (LA37_0=='#') ) {s = 29;}
				else if ( (LA37_0=='\t'||LA37_0==' ') ) {s = 30;}
				else if ( (LA37_0=='=') ) {s = 31;}
				else if ( (LA37_0=='\\') ) {s = 32;}
				else if ( (LA37_0==',') ) {s = 33;}
				else if ( (LA37_0==':') ) {s = 34;}
				else if ( (LA37_0=='\"') ) {s = 35;}
				else if ( (LA37_0=='{') ) {s = 36;}
				else if ( (LA37_0=='[') ) {s = 37;}
				else if ( (LA37_0=='(') ) {s = 38;}
				else if ( (LA37_0=='!') ) {s = 39;}
				else if ( (LA37_0=='?') ) {s = 40;}
				else if ( (LA37_0=='}') ) {s = 41;}
				else if ( (LA37_0==']') ) {s = 42;}
				else if ( (LA37_0==')') ) {s = 43;}
				else if ( (LA37_0==';') ) {s = 44;}
				else if ( (LA37_0=='\'') ) {s = 45;}
				else if ( (LA37_0=='~') ) {s = 46;}
				else if ( (LA37_0=='$'||(LA37_0 >= 'A' && LA37_0 <= 'Z')||LA37_0=='h'||(LA37_0 >= 'j' && LA37_0 <= 'k')||(LA37_0 >= 'm' && LA37_0 <= 'o')||LA37_0=='q'||(LA37_0 >= 'x' && LA37_0 <= 'z')) ) {s = 47;}
				else if ( (LA37_0=='0') ) {s = 48;}
				else if ( ((LA37_0 >= '1' && LA37_0 <= '9')) ) {s = 49;}
				else if ( (LA37_0=='\n'||LA37_0=='\r') ) {s = 50;}
				else if ( ((LA37_0 >= '\u0000' && LA37_0 <= '\b')||(LA37_0 >= '\u000B' && LA37_0 <= '\f')||(LA37_0 >= '\u000E' && LA37_0 <= '\u001F')||LA37_0=='@'||LA37_0=='`'||(LA37_0 >= '\u007F' && LA37_0 <= '\uFFFF')) ) {s = 51;}
				//if ( s>=0 ) return s;
				//break;
				return s;
			}

			private int specialState2(int s, IntStream _input) {
				IntStream input = _input;
				int LA37_35 = input.LA(1);
				s = -1;
				if ( ((LA37_35 >= '\u0000' && LA37_35 <= '\uFFFF')) ) {s = 129;}
				else s = 128;
				//if ( s>=0 ) return s;
				//break;
				return s;
			}

	}


}