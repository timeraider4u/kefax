package at.jku.weiner.c.parser.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


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
	public static final int RULE_ESCAPE_SEQUENCE=12;
	public static final int RULE_EXPONENT=13;
	public static final int RULE_FLOAT_LITERAL=14;
	public static final int RULE_FLOAT_TYPE_SUFFIX=15;
	public static final int RULE_HEX_DIGIT=16;
	public static final int RULE_HEX_ESCAPE=17;
	public static final int RULE_HEX_LITERAL=18;
	public static final int RULE_ID=19;
	public static final int RULE_IDENTIFIER=20;
	public static final int RULE_INTEGER_TYPE_SUFFIX=21;
	public static final int RULE_KW_ALIGNAS=22;
	public static final int RULE_KW_ALIGNOF=23;
	public static final int RULE_KW_ASM1=24;
	public static final int RULE_KW_ASM2=25;
	public static final int RULE_KW_ASM3=26;
	public static final int RULE_KW_ATOMIC=27;
	public static final int RULE_KW_ATTRIBUTE=28;
	public static final int RULE_KW_AUTO=29;
	public static final int RULE_KW_BOOL=30;
	public static final int RULE_KW_BREAK=31;
	public static final int RULE_KW_BUILTIN_VA_LIST=32;
	public static final int RULE_KW_CASE=33;
	public static final int RULE_KW_CHAR=34;
	public static final int RULE_KW_COMPLEX=35;
	public static final int RULE_KW_CONST=36;
	public static final int RULE_KW_CONTINUE=37;
	public static final int RULE_KW_DEFAULT=38;
	public static final int RULE_KW_DO=39;
	public static final int RULE_KW_DOUBLE=40;
	public static final int RULE_KW_ELSE=41;
	public static final int RULE_KW_ENUM=42;
	public static final int RULE_KW_EXTENSION=43;
	public static final int RULE_KW_EXTERN=44;
	public static final int RULE_KW_FLOAT=45;
	public static final int RULE_KW_FOR=46;
	public static final int RULE_KW_GENERIC=47;
	public static final int RULE_KW_GOTO=48;
	public static final int RULE_KW_IF=49;
	public static final int RULE_KW_IMAGINARY=50;
	public static final int RULE_KW_INLINE1=51;
	public static final int RULE_KW_INLINE2=52;
	public static final int RULE_KW_INT=53;
	public static final int RULE_KW_LONG=54;
	public static final int RULE_KW_M128=55;
	public static final int RULE_KW_M128D=56;
	public static final int RULE_KW_M128I=57;
	public static final int RULE_KW_NORETURN=58;
	public static final int RULE_KW_PRAGMA=59;
	public static final int RULE_KW_REGISTER=60;
	public static final int RULE_KW_RESTRICT=61;
	public static final int RULE_KW_RESTRICT2=62;
	public static final int RULE_KW_RESTRICT3=63;
	public static final int RULE_KW_RETURN=64;
	public static final int RULE_KW_SHORT=65;
	public static final int RULE_KW_SIGNED1=66;
	public static final int RULE_KW_SIGNED2=67;
	public static final int RULE_KW_SIGNED3=68;
	public static final int RULE_KW_SIZEOF=69;
	public static final int RULE_KW_STATIC=70;
	public static final int RULE_KW_STATICASSERT=71;
	public static final int RULE_KW_STRUCT=72;
	public static final int RULE_KW_SWITCH=73;
	public static final int RULE_KW_THREADLOCAL=74;
	public static final int RULE_KW_TYPEDEF=75;
	public static final int RULE_KW_UNION=76;
	public static final int RULE_KW_UNSIGNED=77;
	public static final int RULE_KW_VOID=78;
	public static final int RULE_KW_VOLATILE=79;
	public static final int RULE_KW_VOLATILE2=80;
	public static final int RULE_KW_WHILE=81;
	public static final int RULE_LEFTSHIFTASSIGN=82;
	public static final int RULE_LETTER=83;
	public static final int RULE_LINEBREAK=84;
	public static final int RULE_LINEDIRECTIVE=85;
	public static final int RULE_LINEFEED=86;
	public static final int RULE_LINE_COMMENT=87;
	public static final int RULE_LINE_END=88;
	public static final int RULE_MINUSASSIGN=89;
	public static final int RULE_MODASSIGN=90;
	public static final int RULE_NEWLINE=91;
	public static final int RULE_OCTAL_ESCAPE=92;
	public static final int RULE_OCTAL_LITERAL=93;
	public static final int RULE_ORASSIGN=94;
	public static final int RULE_PLUSASSIGN=95;
	public static final int RULE_RIGHTSHIFTASSIGN=96;
	public static final int RULE_SKW_AND=97;
	public static final int RULE_SKW_ANDAND=98;
	public static final int RULE_SKW_ASSIGN=99;
	public static final int RULE_SKW_BACKSLASH=100;
	public static final int RULE_SKW_CARET=101;
	public static final int RULE_SKW_COLON=102;
	public static final int RULE_SKW_COMMA=103;
	public static final int RULE_SKW_DIV=104;
	public static final int RULE_SKW_DOLLAR=105;
	public static final int RULE_SKW_DOT=106;
	public static final int RULE_SKW_DOUBLEQUOTE=107;
	public static final int RULE_SKW_EQUAL=108;
	public static final int RULE_SKW_GREATER=109;
	public static final int RULE_SKW_GREATEREQUAL=110;
	public static final int RULE_SKW_LEFTBRACE=111;
	public static final int RULE_SKW_LEFTBRACKET=112;
	public static final int RULE_SKW_LEFTPAREN=113;
	public static final int RULE_SKW_LEFTSHIFT=114;
	public static final int RULE_SKW_LESS=115;
	public static final int RULE_SKW_LESSEQUAL=116;
	public static final int RULE_SKW_MINUS=117;
	public static final int RULE_SKW_MINUSMINUS=118;
	public static final int RULE_SKW_MOD=119;
	public static final int RULE_SKW_NOT=120;
	public static final int RULE_SKW_NOTEQUAL=121;
	public static final int RULE_SKW_OR=122;
	public static final int RULE_SKW_OROR=123;
	public static final int RULE_SKW_PLUS=124;
	public static final int RULE_SKW_PLUSPLUS=125;
	public static final int RULE_SKW_QUESTION=126;
	public static final int RULE_SKW_RIGHTBRACE=127;
	public static final int RULE_SKW_RIGHTBRACKET=128;
	public static final int RULE_SKW_RIGHTPAREN=129;
	public static final int RULE_SKW_RIGHTSHIFT=130;
	public static final int RULE_SKW_SEMI=131;
	public static final int RULE_SKW_SINGLEQUOTE=132;
	public static final int RULE_SKW_STAR=133;
	public static final int RULE_SKW_TILDE=134;
	public static final int RULE_SKW_UNDERSCORE=135;
	public static final int RULE_SPACE=136;
	public static final int RULE_SPECIAL=137;
	public static final int RULE_STARASSIGN=138;
	public static final int RULE_STRING_LITERAL=139;
	public static final int RULE_TAB=140;
	public static final int RULE_WHITESPACE=141;
	public static final int RULE_XORASSIGN=142;

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
			// InternalParser.g:24133:16: ( RULE_SKW_UNDERSCORE 'Atomic' )
			// InternalParser.g:24133:18: RULE_SKW_UNDERSCORE 'Atomic'
			{
			mRULE_SKW_UNDERSCORE(); 

			match("Atomic"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_ATOMIC"

	// $ANTLR start "RULE_KW_ATTRIBUTE"
	public final void mRULE_KW_ATTRIBUTE() throws RecognitionException {
		try {
			int _type = RULE_KW_ATTRIBUTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:24135:19: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'attribute' RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE )
			// InternalParser.g:24135:21: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'attribute' RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE
			{
			mRULE_SKW_UNDERSCORE(); 

			mRULE_SKW_UNDERSCORE(); 

			match("attribute"); 

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
	// $ANTLR end "RULE_KW_ATTRIBUTE"

	// $ANTLR start "RULE_KW_AUTO"
	public final void mRULE_KW_AUTO() throws RecognitionException {
		try {
			int _type = RULE_KW_AUTO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:24137:14: ( 'auto' )
			// InternalParser.g:24137:16: 'auto'
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
			// InternalParser.g:24139:17: ( RULE_SKW_UNDERSCORE 'Alignas' )
			// InternalParser.g:24139:19: RULE_SKW_UNDERSCORE 'Alignas'
			{
			mRULE_SKW_UNDERSCORE(); 

			match("Alignas"); 

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
			// InternalParser.g:24141:17: ( RULE_SKW_UNDERSCORE 'Alignof' )
			// InternalParser.g:24141:19: RULE_SKW_UNDERSCORE 'Alignof'
			{
			mRULE_SKW_UNDERSCORE(); 

			match("Alignof"); 

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
			// InternalParser.g:24143:14: ( 'asm' )
			// InternalParser.g:24143:16: 'asm'
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
	// $ANTLR end "RULE_KW_ASM1"

	// $ANTLR start "RULE_KW_ASM2"
	public final void mRULE_KW_ASM2() throws RecognitionException {
		try {
			int _type = RULE_KW_ASM2;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:24145:14: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_ASM1 )
			// InternalParser.g:24145:16: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_ASM1
			{
			mRULE_SKW_UNDERSCORE(); 

			mRULE_SKW_UNDERSCORE(); 

			mRULE_KW_ASM1(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_ASM2"

	// $ANTLR start "RULE_KW_ASM3"
	public final void mRULE_KW_ASM3() throws RecognitionException {
		try {
			int _type = RULE_KW_ASM3;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:24147:14: ( RULE_KW_ASM2 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE )
			// InternalParser.g:24147:16: RULE_KW_ASM2 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE
			{
			mRULE_KW_ASM2(); 

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
	// $ANTLR end "RULE_KW_ASM3"

	// $ANTLR start "RULE_KW_BOOL"
	public final void mRULE_KW_BOOL() throws RecognitionException {
		try {
			int _type = RULE_KW_BOOL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:24149:14: ( RULE_SKW_UNDERSCORE 'Bool' )
			// InternalParser.g:24149:16: RULE_SKW_UNDERSCORE 'Bool'
			{
			mRULE_SKW_UNDERSCORE(); 

			match("Bool"); 

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
			// InternalParser.g:24151:15: ( 'break' )
			// InternalParser.g:24151:17: 'break'
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
			// InternalParser.g:24153:25: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'builtin_va_list' )
			// InternalParser.g:24153:27: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'builtin_va_list'
			{
			mRULE_SKW_UNDERSCORE(); 

			mRULE_SKW_UNDERSCORE(); 

			match("builtin_va_list"); 

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
			// InternalParser.g:24155:14: ( 'case' )
			// InternalParser.g:24155:16: 'case'
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
			// InternalParser.g:24157:14: ( 'char' )
			// InternalParser.g:24157:16: 'char'
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
			// InternalParser.g:24159:17: ( RULE_SKW_UNDERSCORE 'Complex' )
			// InternalParser.g:24159:19: RULE_SKW_UNDERSCORE 'Complex'
			{
			mRULE_SKW_UNDERSCORE(); 

			match("Complex"); 

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
			// InternalParser.g:24161:15: ( 'const' )
			// InternalParser.g:24161:17: 'const'
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
			// InternalParser.g:24163:18: ( 'continue' )
			// InternalParser.g:24163:20: 'continue'
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
			// InternalParser.g:24165:17: ( 'default' )
			// InternalParser.g:24165:19: 'default'
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
			// InternalParser.g:24167:12: ( 'do' )
			// InternalParser.g:24167:14: 'do'
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
			// InternalParser.g:24169:16: ( 'double' )
			// InternalParser.g:24169:18: 'double'
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
			// InternalParser.g:24171:14: ( 'else' )
			// InternalParser.g:24171:16: 'else'
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

	// $ANTLR start "RULE_KW_EXTENSION"
	public final void mRULE_KW_EXTENSION() throws RecognitionException {
		try {
			int _type = RULE_KW_EXTENSION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:24173:19: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'extension' RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE )
			// InternalParser.g:24173:21: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'extension' RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE
			{
			mRULE_SKW_UNDERSCORE(); 

			mRULE_SKW_UNDERSCORE(); 

			match("extension"); 

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
	// $ANTLR end "RULE_KW_EXTENSION"

	// $ANTLR start "RULE_KW_ENUM"
	public final void mRULE_KW_ENUM() throws RecognitionException {
		try {
			int _type = RULE_KW_ENUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:24175:14: ( 'enum' )
			// InternalParser.g:24175:16: 'enum'
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
			// InternalParser.g:24177:16: ( 'extern' )
			// InternalParser.g:24177:18: 'extern'
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
			// InternalParser.g:24179:15: ( 'float' )
			// InternalParser.g:24179:17: 'float'
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
			// InternalParser.g:24181:13: ( 'for' )
			// InternalParser.g:24181:15: 'for'
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
			// InternalParser.g:24183:17: ( RULE_SKW_UNDERSCORE 'Generic' )
			// InternalParser.g:24183:19: RULE_SKW_UNDERSCORE 'Generic'
			{
			mRULE_SKW_UNDERSCORE(); 

			match("Generic"); 

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
			// InternalParser.g:24185:14: ( 'goto' )
			// InternalParser.g:24185:16: 'goto'
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
			// InternalParser.g:24187:12: ( 'if' )
			// InternalParser.g:24187:14: 'if'
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
			// InternalParser.g:24189:19: ( RULE_SKW_UNDERSCORE 'Imaginary' )
			// InternalParser.g:24189:21: RULE_SKW_UNDERSCORE 'Imaginary'
			{
			mRULE_SKW_UNDERSCORE(); 

			match("Imaginary"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_IMAGINARY"

	// $ANTLR start "RULE_KW_INLINE1"
	public final void mRULE_KW_INLINE1() throws RecognitionException {
		try {
			int _type = RULE_KW_INLINE1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:24191:17: ( 'inline' )
			// InternalParser.g:24191:19: 'inline'
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
	// $ANTLR end "RULE_KW_INLINE1"

	// $ANTLR start "RULE_KW_INLINE2"
	public final void mRULE_KW_INLINE2() throws RecognitionException {
		try {
			int _type = RULE_KW_INLINE2;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:24193:17: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_INLINE1 )
			// InternalParser.g:24193:19: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_INLINE1
			{
			mRULE_SKW_UNDERSCORE(); 

			mRULE_SKW_UNDERSCORE(); 

			mRULE_KW_INLINE1(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_INLINE2"

	// $ANTLR start "RULE_KW_INT"
	public final void mRULE_KW_INT() throws RecognitionException {
		try {
			int _type = RULE_KW_INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:24195:13: ( 'int' )
			// InternalParser.g:24195:15: 'int'
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
			// InternalParser.g:24197:14: ( 'long' )
			// InternalParser.g:24197:16: 'long'
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
			// InternalParser.g:24199:14: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'm128' )
			// InternalParser.g:24199:16: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'm128'
			{
			mRULE_SKW_UNDERSCORE(); 

			mRULE_SKW_UNDERSCORE(); 

			match("m128"); 

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
			// InternalParser.g:24201:15: ( RULE_KW_M128 'd' )
			// InternalParser.g:24201:17: RULE_KW_M128 'd'
			{
			mRULE_KW_M128(); 

			match('d'); 
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
			// InternalParser.g:24203:15: ( RULE_KW_M128 'i' )
			// InternalParser.g:24203:17: RULE_KW_M128 'i'
			{
			mRULE_KW_M128(); 

			match('i'); 
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
			// InternalParser.g:24205:18: ( RULE_SKW_UNDERSCORE 'Noreturn' )
			// InternalParser.g:24205:20: RULE_SKW_UNDERSCORE 'Noreturn'
			{
			mRULE_SKW_UNDERSCORE(); 

			match("Noreturn"); 

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
			// InternalParser.g:24207:16: ( 'pragma' )
			// InternalParser.g:24207:18: 'pragma'
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
			// InternalParser.g:24209:18: ( 'register' )
			// InternalParser.g:24209:20: 'register'
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
			// InternalParser.g:24211:18: ( 'restrict' )
			// InternalParser.g:24211:20: 'restrict'
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

	// $ANTLR start "RULE_KW_RESTRICT2"
	public final void mRULE_KW_RESTRICT2() throws RecognitionException {
		try {
			int _type = RULE_KW_RESTRICT2;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:24213:19: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_RESTRICT )
			// InternalParser.g:24213:21: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_RESTRICT
			{
			mRULE_SKW_UNDERSCORE(); 

			mRULE_SKW_UNDERSCORE(); 

			mRULE_KW_RESTRICT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_RESTRICT2"

	// $ANTLR start "RULE_KW_RESTRICT3"
	public final void mRULE_KW_RESTRICT3() throws RecognitionException {
		try {
			int _type = RULE_KW_RESTRICT3;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:24215:19: ( RULE_KW_RESTRICT2 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE )
			// InternalParser.g:24215:21: RULE_KW_RESTRICT2 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE
			{
			mRULE_KW_RESTRICT2(); 

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
	// $ANTLR end "RULE_KW_RESTRICT3"

	// $ANTLR start "RULE_KW_RETURN"
	public final void mRULE_KW_RETURN() throws RecognitionException {
		try {
			int _type = RULE_KW_RETURN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:24217:16: ( 'return' )
			// InternalParser.g:24217:18: 'return'
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
			// InternalParser.g:24219:15: ( 'short' )
			// InternalParser.g:24219:17: 'short'
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

	// $ANTLR start "RULE_KW_SIGNED1"
	public final void mRULE_KW_SIGNED1() throws RecognitionException {
		try {
			int _type = RULE_KW_SIGNED1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:24221:17: ( 'signed' )
			// InternalParser.g:24221:19: 'signed'
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
	// $ANTLR end "RULE_KW_SIGNED1"

	// $ANTLR start "RULE_KW_SIGNED2"
	public final void mRULE_KW_SIGNED2() throws RecognitionException {
		try {
			int _type = RULE_KW_SIGNED2;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:24223:17: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_SIGNED1 )
			// InternalParser.g:24223:19: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_SIGNED1
			{
			mRULE_SKW_UNDERSCORE(); 

			mRULE_SKW_UNDERSCORE(); 

			mRULE_KW_SIGNED1(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_SIGNED2"

	// $ANTLR start "RULE_KW_SIGNED3"
	public final void mRULE_KW_SIGNED3() throws RecognitionException {
		try {
			int _type = RULE_KW_SIGNED3;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:24225:17: ( RULE_KW_SIGNED2 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE )
			// InternalParser.g:24225:19: RULE_KW_SIGNED2 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE
			{
			mRULE_KW_SIGNED2(); 

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
	// $ANTLR end "RULE_KW_SIGNED3"

	// $ANTLR start "RULE_KW_SIZEOF"
	public final void mRULE_KW_SIZEOF() throws RecognitionException {
		try {
			int _type = RULE_KW_SIZEOF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:24227:16: ( 'sizeof' )
			// InternalParser.g:24227:18: 'sizeof'
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
			// InternalParser.g:24229:16: ( 'static' )
			// InternalParser.g:24229:18: 'static'
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
			// InternalParser.g:24231:22: ( RULE_SKW_UNDERSCORE 'Static_assert' )
			// InternalParser.g:24231:24: RULE_SKW_UNDERSCORE 'Static_assert'
			{
			mRULE_SKW_UNDERSCORE(); 

			match("Static_assert"); 

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
			// InternalParser.g:24233:16: ( 'struct' )
			// InternalParser.g:24233:18: 'struct'
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
			// InternalParser.g:24235:16: ( 'switch' )
			// InternalParser.g:24235:18: 'switch'
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
			// InternalParser.g:24237:21: ( RULE_SKW_UNDERSCORE 'Thread_local' )
			// InternalParser.g:24237:23: RULE_SKW_UNDERSCORE 'Thread_local'
			{
			mRULE_SKW_UNDERSCORE(); 

			match("Thread_local"); 

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
			// InternalParser.g:24239:17: ( 'typedef' )
			// InternalParser.g:24239:19: 'typedef'
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
			// InternalParser.g:24241:15: ( 'union' )
			// InternalParser.g:24241:17: 'union'
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
			// InternalParser.g:24243:18: ( 'unsigned' )
			// InternalParser.g:24243:20: 'unsigned'
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
			// InternalParser.g:24245:14: ( 'void' )
			// InternalParser.g:24245:16: 'void'
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
			// InternalParser.g:24247:18: ( 'volatile' )
			// InternalParser.g:24247:20: 'volatile'
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
			// InternalParser.g:24249:19: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_VOLATILE RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE )
			// InternalParser.g:24249:21: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_VOLATILE RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE
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
			// InternalParser.g:24251:15: ( 'while' )
			// InternalParser.g:24251:17: 'while'
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
			// InternalParser.g:24253:17: ( RULE_SKW_STAR RULE_SKW_ASSIGN )
			// InternalParser.g:24253:19: RULE_SKW_STAR RULE_SKW_ASSIGN
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
			// InternalParser.g:24255:16: ( RULE_SKW_DIV RULE_SKW_ASSIGN )
			// InternalParser.g:24255:18: RULE_SKW_DIV RULE_SKW_ASSIGN
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
			// InternalParser.g:24257:16: ( RULE_SKW_MOD RULE_SKW_ASSIGN )
			// InternalParser.g:24257:18: RULE_SKW_MOD RULE_SKW_ASSIGN
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
			// InternalParser.g:24259:17: ( RULE_SKW_PLUS RULE_SKW_ASSIGN )
			// InternalParser.g:24259:19: RULE_SKW_PLUS RULE_SKW_ASSIGN
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
			// InternalParser.g:24261:18: ( RULE_SKW_MINUS RULE_SKW_ASSIGN )
			// InternalParser.g:24261:20: RULE_SKW_MINUS RULE_SKW_ASSIGN
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
			// InternalParser.g:24263:22: ( RULE_SKW_LEFTSHIFT RULE_SKW_ASSIGN )
			// InternalParser.g:24263:24: RULE_SKW_LEFTSHIFT RULE_SKW_ASSIGN
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
			// InternalParser.g:24265:23: ( RULE_SKW_RIGHTSHIFT RULE_SKW_ASSIGN )
			// InternalParser.g:24265:25: RULE_SKW_RIGHTSHIFT RULE_SKW_ASSIGN
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
			// InternalParser.g:24267:16: ( RULE_SKW_AND RULE_SKW_ASSIGN )
			// InternalParser.g:24267:18: RULE_SKW_AND RULE_SKW_ASSIGN
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
			// InternalParser.g:24269:16: ( RULE_SKW_CARET RULE_SKW_ASSIGN )
			// InternalParser.g:24269:18: RULE_SKW_CARET RULE_SKW_ASSIGN
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
			// InternalParser.g:24271:15: ( RULE_SKW_OR RULE_SKW_ASSIGN )
			// InternalParser.g:24271:17: RULE_SKW_OR RULE_SKW_ASSIGN
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
			// InternalParser.g:24273:12: ( RULE_SKW_MINUS RULE_SKW_GREATER )
			// InternalParser.g:24273:14: RULE_SKW_MINUS RULE_SKW_GREATER
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

	// $ANTLR start "RULE_LINEDIRECTIVE"
	public final void mRULE_LINEDIRECTIVE() throws RecognitionException {
		try {
			int _type = RULE_LINEDIRECTIVE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:24275:20: ( '#' (~ ( RULE_NEWLINE ) | RULE_SKW_BACKSLASH RULE_NEWLINE )* )
			// InternalParser.g:24275:22: '#' (~ ( RULE_NEWLINE ) | RULE_SKW_BACKSLASH RULE_NEWLINE )*
			{
			match('#'); 
			// InternalParser.g:24275:26: (~ ( RULE_NEWLINE ) | RULE_SKW_BACKSLASH RULE_NEWLINE )*
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
					// InternalParser.g:24275:27: ~ ( RULE_NEWLINE )
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
					// InternalParser.g:24275:43: RULE_SKW_BACKSLASH RULE_NEWLINE
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
			// InternalParser.g:24277:17: ( ( ' ' | '\\t' )+ )
			// InternalParser.g:24277:19: ( ' ' | '\\t' )+
			{
			// InternalParser.g:24277:19: ( ' ' | '\\t' )+
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
			// InternalParser.g:24279:14: ( '&' )
			// InternalParser.g:24279:16: '&'
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
			// InternalParser.g:24281:17: ( RULE_SKW_AND RULE_SKW_AND )
			// InternalParser.g:24281:19: RULE_SKW_AND RULE_SKW_AND
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
			// InternalParser.g:24283:17: ( '=' )
			// InternalParser.g:24283:19: '='
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
			// InternalParser.g:24285:20: ( '\\\\' )
			// InternalParser.g:24285:22: '\\\\'
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
			// InternalParser.g:24287:16: ( '^' )
			// InternalParser.g:24287:18: '^'
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
			// InternalParser.g:24289:16: ( ',' )
			// InternalParser.g:24289:18: ','
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
			// InternalParser.g:24291:16: ( ':' )
			// InternalParser.g:24291:18: ':'
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
			// InternalParser.g:24293:14: ( '/' )
			// InternalParser.g:24293:16: '/'
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
			// InternalParser.g:24295:26: ( '$' )
			// InternalParser.g:24295:28: '$'
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
			// InternalParser.g:24297:14: ( '.' )
			// InternalParser.g:24297:16: '.'
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
			// InternalParser.g:24299:22: ( '\"' )
			// InternalParser.g:24299:24: '\"'
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
			// InternalParser.g:24301:16: ( RULE_SKW_ASSIGN RULE_SKW_ASSIGN )
			// InternalParser.g:24301:18: RULE_SKW_ASSIGN RULE_SKW_ASSIGN
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
			// InternalParser.g:24303:18: ( '>' )
			// InternalParser.g:24303:20: '>'
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
			// InternalParser.g:24305:23: ( RULE_SKW_GREATER RULE_SKW_ASSIGN )
			// InternalParser.g:24305:25: RULE_SKW_GREATER RULE_SKW_ASSIGN
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
			// InternalParser.g:24307:20: ( '{' )
			// InternalParser.g:24307:22: '{'
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
			// InternalParser.g:24309:22: ( '[' )
			// InternalParser.g:24309:24: '['
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
			// InternalParser.g:24311:20: ( '(' )
			// InternalParser.g:24311:22: '('
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
			// InternalParser.g:24313:20: ( RULE_SKW_LESS RULE_SKW_LESS )
			// InternalParser.g:24313:22: RULE_SKW_LESS RULE_SKW_LESS
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
			// InternalParser.g:24315:15: ( '<' )
			// InternalParser.g:24315:17: '<'
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
			// InternalParser.g:24317:20: ( RULE_SKW_LESS RULE_SKW_ASSIGN )
			// InternalParser.g:24317:22: RULE_SKW_LESS RULE_SKW_ASSIGN
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
			// InternalParser.g:24319:16: ( '-' )
			// InternalParser.g:24319:18: '-'
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
			// InternalParser.g:24321:21: ( RULE_SKW_MINUS RULE_SKW_MINUS )
			// InternalParser.g:24321:23: RULE_SKW_MINUS RULE_SKW_MINUS
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
			// InternalParser.g:24323:14: ( '%' )
			// InternalParser.g:24323:16: '%'
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
			// InternalParser.g:24325:14: ( '!' )
			// InternalParser.g:24325:16: '!'
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
			// InternalParser.g:24327:19: ( RULE_SKW_NOT RULE_SKW_ASSIGN )
			// InternalParser.g:24327:21: RULE_SKW_NOT RULE_SKW_ASSIGN
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
			// InternalParser.g:24329:13: ( '|' )
			// InternalParser.g:24329:15: '|'
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
			// InternalParser.g:24331:15: ( RULE_SKW_OR RULE_SKW_OR )
			// InternalParser.g:24331:17: RULE_SKW_OR RULE_SKW_OR
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
			// InternalParser.g:24333:15: ( '+' )
			// InternalParser.g:24333:17: '+'
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
			// InternalParser.g:24335:19: ( RULE_SKW_PLUS RULE_SKW_PLUS )
			// InternalParser.g:24335:21: RULE_SKW_PLUS RULE_SKW_PLUS
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
			// InternalParser.g:24337:19: ( '?' )
			// InternalParser.g:24337:21: '?'
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
			// InternalParser.g:24339:21: ( '}' )
			// InternalParser.g:24339:23: '}'
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
			// InternalParser.g:24341:23: ( ']' )
			// InternalParser.g:24341:25: ']'
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
			// InternalParser.g:24343:21: ( ')' )
			// InternalParser.g:24343:23: ')'
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
			// InternalParser.g:24345:21: ( RULE_SKW_GREATER RULE_SKW_GREATER )
			// InternalParser.g:24345:23: RULE_SKW_GREATER RULE_SKW_GREATER
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
			// InternalParser.g:24347:15: ( ';' )
			// InternalParser.g:24347:17: ';'
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
			// InternalParser.g:24349:22: ( '\\'' )
			// InternalParser.g:24349:24: '\\''
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
			// InternalParser.g:24351:15: ( '*' )
			// InternalParser.g:24351:17: '*'
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
			// InternalParser.g:24353:16: ( '~' )
			// InternalParser.g:24353:18: '~'
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
			// InternalParser.g:24355:30: ( '_' )
			// InternalParser.g:24355:32: '_'
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
			// InternalParser.g:24357:9: ( RULE_IDENTIFIER )
			// InternalParser.g:24357:11: RULE_IDENTIFIER
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
			// InternalParser.g:24359:26: ( RULE_LETTER ( RULE_LETTER | '0' .. '9' )* )
			// InternalParser.g:24359:28: RULE_LETTER ( RULE_LETTER | '0' .. '9' )*
			{
			mRULE_LETTER(); 

			// InternalParser.g:24359:40: ( RULE_LETTER | '0' .. '9' )*
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
			// InternalParser.g:24361:22: ( ( RULE_SKW_DOLLAR | 'A' .. 'Z' | 'a' .. 'z' | RULE_SKW_UNDERSCORE ) )
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
			// InternalParser.g:24363:19: ( RULE_SKW_SINGLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) ) RULE_SKW_SINGLEQUOTE )
			// InternalParser.g:24363:21: RULE_SKW_SINGLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) ) RULE_SKW_SINGLEQUOTE
			{
			mRULE_SKW_SINGLEQUOTE(); 

			// InternalParser.g:24363:42: ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) )
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
					// InternalParser.g:24363:43: RULE_ESCAPE_SEQUENCE
					{
					mRULE_ESCAPE_SEQUENCE(); 

					}
					break;
				case 2 :
					// InternalParser.g:24363:64: ~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) )
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
			// InternalParser.g:24365:21: ( RULE_SKW_DOUBLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) )* RULE_SKW_DOUBLEQUOTE )
			// InternalParser.g:24365:23: RULE_SKW_DOUBLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) )* RULE_SKW_DOUBLEQUOTE
			{
			mRULE_SKW_DOUBLEQUOTE(); 

			// InternalParser.g:24365:44: ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) )*
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
					// InternalParser.g:24365:45: RULE_ESCAPE_SEQUENCE
					{
					mRULE_ESCAPE_SEQUENCE(); 

					}
					break;
				case 2 :
					// InternalParser.g:24365:66: ~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) )
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
			// InternalParser.g:24367:18: ( '0' ( 'x' | 'X' ) ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )? )
			// InternalParser.g:24367:20: '0' ( 'x' | 'X' ) ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )?
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
			// InternalParser.g:24367:34: ( RULE_HEX_DIGIT )+
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

			// InternalParser.g:24367:50: ( RULE_INTEGER_TYPE_SUFFIX )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0=='L'||LA7_0=='U'||LA7_0=='l'||LA7_0=='u') ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// InternalParser.g:24367:50: RULE_INTEGER_TYPE_SUFFIX
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
			// InternalParser.g:24369:22: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( RULE_INTEGER_TYPE_SUFFIX )? )
			// InternalParser.g:24369:24: ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( RULE_INTEGER_TYPE_SUFFIX )?
			{
			// InternalParser.g:24369:24: ( '0' | '1' .. '9' ( '0' .. '9' )* )
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
					// InternalParser.g:24369:25: '0'
					{
					match('0'); 
					}
					break;
				case 2 :
					// InternalParser.g:24369:29: '1' .. '9' ( '0' .. '9' )*
					{
					matchRange('1','9'); 
					// InternalParser.g:24369:38: ( '0' .. '9' )*
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

			// InternalParser.g:24369:51: ( RULE_INTEGER_TYPE_SUFFIX )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='L'||LA10_0=='U'||LA10_0=='l'||LA10_0=='u') ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// InternalParser.g:24369:51: RULE_INTEGER_TYPE_SUFFIX
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
			// InternalParser.g:24371:20: ( '0' ( '0' .. '7' )+ ( RULE_INTEGER_TYPE_SUFFIX )? )
			// InternalParser.g:24371:22: '0' ( '0' .. '7' )+ ( RULE_INTEGER_TYPE_SUFFIX )?
			{
			match('0'); 
			// InternalParser.g:24371:26: ( '0' .. '7' )+
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

			// InternalParser.g:24371:38: ( RULE_INTEGER_TYPE_SUFFIX )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0=='L'||LA12_0=='U'||LA12_0=='l'||LA12_0=='u') ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// InternalParser.g:24371:38: RULE_INTEGER_TYPE_SUFFIX
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
			// InternalParser.g:24373:18: ( ( '0b' | '0B' ) ( '0' .. '1' )+ )
			// InternalParser.g:24373:20: ( '0b' | '0B' ) ( '0' .. '1' )+
			{
			// InternalParser.g:24373:20: ( '0b' | '0B' )
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
					// InternalParser.g:24373:21: '0b'
					{
					match("0b"); 

					}
					break;
				case 2 :
					// InternalParser.g:24373:26: '0B'
					{
					match("0B"); 

					}
					break;

			}

			// InternalParser.g:24373:32: ( '0' .. '1' )+
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
			// InternalParser.g:24375:25: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
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
			// InternalParser.g:24377:35: ( ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? ) )
			// InternalParser.g:24377:37: ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? )
			{
			// InternalParser.g:24377:37: ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? )
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
					// InternalParser.g:24377:38: ( 'u' | 'U' )? ( 'l' | 'L' )
					{
					// InternalParser.g:24377:38: ( 'u' | 'U' )?
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
					// InternalParser.g:24377:59: ( 'u' | 'U' ) ( 'l' | 'L' )?
					{
					if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// InternalParser.g:24377:69: ( 'l' | 'L' )?
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
			// InternalParser.g:24379:20: ( ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX ) )
			// InternalParser.g:24379:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )
			{
			// InternalParser.g:24379:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )
			int alt29=4;
			alt29 = dfa29.predict(input);
			switch (alt29) {
				case 1 :
					// InternalParser.g:24379:23: ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )?
					{
					// InternalParser.g:24379:23: ( '0' .. '9' )+
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

					// InternalParser.g:24379:48: ( '0' .. '9' )*
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

					// InternalParser.g:24379:60: ( RULE_EXPONENT )?
					int alt20=2;
					int LA20_0 = input.LA(1);
					if ( (LA20_0=='E'||LA20_0=='e') ) {
						alt20=1;
					}
					switch (alt20) {
						case 1 :
							// InternalParser.g:24379:60: RULE_EXPONENT
							{
							mRULE_EXPONENT(); 

							}
							break;

					}

					// InternalParser.g:24379:75: ( RULE_FLOAT_TYPE_SUFFIX )?
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
					// InternalParser.g:24379:99: RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )?
					{
					mRULE_SKW_DOT(); 

					// InternalParser.g:24379:112: ( '0' .. '9' )+
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

					// InternalParser.g:24379:124: ( RULE_EXPONENT )?
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0=='E'||LA23_0=='e') ) {
						alt23=1;
					}
					switch (alt23) {
						case 1 :
							// InternalParser.g:24379:124: RULE_EXPONENT
							{
							mRULE_EXPONENT(); 

							}
							break;

					}

					// InternalParser.g:24379:139: ( RULE_FLOAT_TYPE_SUFFIX )?
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
					// InternalParser.g:24379:163: ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )?
					{
					// InternalParser.g:24379:163: ( '0' .. '9' )+
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

					// InternalParser.g:24379:189: ( RULE_FLOAT_TYPE_SUFFIX )?
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
					// InternalParser.g:24379:213: ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX
					{
					// InternalParser.g:24379:213: ( '0' .. '9' )+
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

					// InternalParser.g:24379:225: ( RULE_EXPONENT )?
					int alt28=2;
					int LA28_0 = input.LA(1);
					if ( (LA28_0=='E'||LA28_0=='e') ) {
						alt28=1;
					}
					switch (alt28) {
						case 1 :
							// InternalParser.g:24379:225: RULE_EXPONENT
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
			// InternalParser.g:24381:24: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
			// InternalParser.g:24381:26: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// InternalParser.g:24381:36: ( '+' | '-' )?
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

			// InternalParser.g:24381:47: ( '0' .. '9' )+
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
			// InternalParser.g:24383:33: ( ( 'f' | 'F' | 'd' | 'D' ) )
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
			// InternalParser.g:24385:31: ( ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE | RULE_HEX_ESCAPE ) )
			// InternalParser.g:24385:33: ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE | RULE_HEX_ESCAPE )
			{
			// InternalParser.g:24385:33: ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE | RULE_HEX_ESCAPE )
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
					// InternalParser.g:24385:34: RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH )
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
					// InternalParser.g:24385:119: RULE_OCTAL_ESCAPE
					{
					mRULE_OCTAL_ESCAPE(); 

					}
					break;
				case 3 :
					// InternalParser.g:24385:137: RULE_HEX_ESCAPE
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
			// InternalParser.g:24387:28: ( ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' ) )
			// InternalParser.g:24387:30: ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' )
			{
			// InternalParser.g:24387:30: ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' )
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
					// InternalParser.g:24387:31: RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7'
					{
					mRULE_SKW_BACKSLASH(); 

					matchRange('0','3'); 
					matchRange('0','7'); 
					matchRange('0','7'); 
					}
					break;
				case 2 :
					// InternalParser.g:24387:77: RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7'
					{
					mRULE_SKW_BACKSLASH(); 

					matchRange('0','7'); 
					matchRange('0','7'); 
					}
					break;
				case 3 :
					// InternalParser.g:24387:114: RULE_SKW_BACKSLASH '0' .. '7'
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
			// InternalParser.g:24389:26: ( RULE_SKW_BACKSLASH 'x' ( RULE_HEX_DIGIT )+ )
			// InternalParser.g:24389:28: RULE_SKW_BACKSLASH 'x' ( RULE_HEX_DIGIT )+
			{
			mRULE_SKW_BACKSLASH(); 

			match('x'); 
			// InternalParser.g:24389:51: ( RULE_HEX_DIGIT )+
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
			// InternalParser.g:24391:24: ( '\\n' )
			// InternalParser.g:24391:26: '\\n'
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
			// InternalParser.g:24393:30: ( '\\r' )
			// InternalParser.g:24393:32: '\\r'
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
			// InternalParser.g:24395:24: ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) )
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
			// InternalParser.g:24397:16: ( RULE_SKW_BACKSLASH RULE_LINE_END )
			// InternalParser.g:24397:18: RULE_SKW_BACKSLASH RULE_LINE_END
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
			// InternalParser.g:24399:14: ( RULE_LINE_END )
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
			// InternalParser.g:24401:21: ( ' ' )
			// InternalParser.g:24401:23: ' '
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
			// InternalParser.g:24403:19: ( '\\t' )
			// InternalParser.g:24403:21: '\\t'
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
			// InternalParser.g:24405:20: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// InternalParser.g:24405:22: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// InternalParser.g:24405:27: ( options {greedy=false; } : . )*
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
					// InternalParser.g:24405:55: .
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
			// InternalParser.g:24407:19: ( '//' (~ ( RULE_LINE_END ) )* )
			// InternalParser.g:24407:21: '//' (~ ( RULE_LINE_END ) )*
			{
			match("//"); 

			// InternalParser.g:24407:26: (~ ( RULE_LINE_END ) )*
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
			// InternalParser.g:24409:14: ( . )
			// InternalParser.g:24409:16: .
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
		// InternalParser.g:1:8: ( RULE_KW_ATOMIC | RULE_KW_ATTRIBUTE | RULE_KW_AUTO | RULE_KW_ALIGNAS | RULE_KW_ALIGNOF | RULE_KW_ASM1 | RULE_KW_ASM2 | RULE_KW_ASM3 | RULE_KW_BOOL | RULE_KW_BREAK | RULE_KW_BUILTIN_VA_LIST | RULE_KW_CASE | RULE_KW_CHAR | RULE_KW_COMPLEX | RULE_KW_CONST | RULE_KW_CONTINUE | RULE_KW_DEFAULT | RULE_KW_DO | RULE_KW_DOUBLE | RULE_KW_ELSE | RULE_KW_EXTENSION | RULE_KW_ENUM | RULE_KW_EXTERN | RULE_KW_FLOAT | RULE_KW_FOR | RULE_KW_GENERIC | RULE_KW_GOTO | RULE_KW_IF | RULE_KW_IMAGINARY | RULE_KW_INLINE1 | RULE_KW_INLINE2 | RULE_KW_INT | RULE_KW_LONG | RULE_KW_M128 | RULE_KW_M128D | RULE_KW_M128I | RULE_KW_NORETURN | RULE_KW_PRAGMA | RULE_KW_REGISTER | RULE_KW_RESTRICT | RULE_KW_RESTRICT2 | RULE_KW_RESTRICT3 | RULE_KW_RETURN | RULE_KW_SHORT | RULE_KW_SIGNED1 | RULE_KW_SIGNED2 | RULE_KW_SIGNED3 | RULE_KW_SIZEOF | RULE_KW_STATIC | RULE_KW_STATICASSERT | RULE_KW_STRUCT | RULE_KW_SWITCH | RULE_KW_THREADLOCAL | RULE_KW_TYPEDEF | RULE_KW_UNION | RULE_KW_UNSIGNED | RULE_KW_VOID | RULE_KW_VOLATILE | RULE_KW_VOLATILE2 | RULE_KW_WHILE | RULE_STARASSIGN | RULE_DIVASSIGN | RULE_MODASSIGN | RULE_PLUSASSIGN | RULE_MINUSASSIGN | RULE_LEFTSHIFTASSIGN | RULE_RIGHTSHIFTASSIGN | RULE_ANDASSIGN | RULE_XORASSIGN | RULE_ORASSIGN | RULE_ARROW | RULE_LINEDIRECTIVE | RULE_WHITESPACE | RULE_SKW_AND | RULE_SKW_ANDAND | RULE_SKW_ASSIGN | RULE_SKW_BACKSLASH | RULE_SKW_CARET | RULE_SKW_COMMA | RULE_SKW_COLON | RULE_SKW_DIV | RULE_SKW_DOT | RULE_SKW_DOUBLEQUOTE | RULE_SKW_EQUAL | RULE_SKW_GREATER | RULE_SKW_GREATEREQUAL | RULE_SKW_LEFTBRACE | RULE_SKW_LEFTBRACKET | RULE_SKW_LEFTPAREN | RULE_SKW_LEFTSHIFT | RULE_SKW_LESS | RULE_SKW_LESSEQUAL | RULE_SKW_MINUS | RULE_SKW_MINUSMINUS | RULE_SKW_MOD | RULE_SKW_NOT | RULE_SKW_NOTEQUAL | RULE_SKW_OR | RULE_SKW_OROR | RULE_SKW_PLUS | RULE_SKW_PLUSPLUS | RULE_SKW_QUESTION | RULE_SKW_RIGHTBRACE | RULE_SKW_RIGHTBRACKET | RULE_SKW_RIGHTPAREN | RULE_SKW_RIGHTSHIFT | RULE_SKW_SEMI | RULE_SKW_SINGLEQUOTE | RULE_SKW_STAR | RULE_SKW_TILDE | RULE_ID | RULE_CHAR_LITERAL | RULE_STRING_LITERAL | RULE_HEX_LITERAL | RULE_DECIMAL_LITERAL | RULE_OCTAL_LITERAL | RULE_BIN_LITERAL | RULE_FLOAT_LITERAL | RULE_LINEBREAK | RULE_NEWLINE | RULE_BLOCK_COMMENT | RULE_LINE_COMMENT | RULE_SPECIAL )
		int alt37=123;
		alt37 = dfa37.predict(input);
		switch (alt37) {
			case 1 :
				// InternalParser.g:1:10: RULE_KW_ATOMIC
				{
				mRULE_KW_ATOMIC(); 

				}
				break;
			case 2 :
				// InternalParser.g:1:25: RULE_KW_ATTRIBUTE
				{
				mRULE_KW_ATTRIBUTE(); 

				}
				break;
			case 3 :
				// InternalParser.g:1:43: RULE_KW_AUTO
				{
				mRULE_KW_AUTO(); 

				}
				break;
			case 4 :
				// InternalParser.g:1:56: RULE_KW_ALIGNAS
				{
				mRULE_KW_ALIGNAS(); 

				}
				break;
			case 5 :
				// InternalParser.g:1:72: RULE_KW_ALIGNOF
				{
				mRULE_KW_ALIGNOF(); 

				}
				break;
			case 6 :
				// InternalParser.g:1:88: RULE_KW_ASM1
				{
				mRULE_KW_ASM1(); 

				}
				break;
			case 7 :
				// InternalParser.g:1:101: RULE_KW_ASM2
				{
				mRULE_KW_ASM2(); 

				}
				break;
			case 8 :
				// InternalParser.g:1:114: RULE_KW_ASM3
				{
				mRULE_KW_ASM3(); 

				}
				break;
			case 9 :
				// InternalParser.g:1:127: RULE_KW_BOOL
				{
				mRULE_KW_BOOL(); 

				}
				break;
			case 10 :
				// InternalParser.g:1:140: RULE_KW_BREAK
				{
				mRULE_KW_BREAK(); 

				}
				break;
			case 11 :
				// InternalParser.g:1:154: RULE_KW_BUILTIN_VA_LIST
				{
				mRULE_KW_BUILTIN_VA_LIST(); 

				}
				break;
			case 12 :
				// InternalParser.g:1:178: RULE_KW_CASE
				{
				mRULE_KW_CASE(); 

				}
				break;
			case 13 :
				// InternalParser.g:1:191: RULE_KW_CHAR
				{
				mRULE_KW_CHAR(); 

				}
				break;
			case 14 :
				// InternalParser.g:1:204: RULE_KW_COMPLEX
				{
				mRULE_KW_COMPLEX(); 

				}
				break;
			case 15 :
				// InternalParser.g:1:220: RULE_KW_CONST
				{
				mRULE_KW_CONST(); 

				}
				break;
			case 16 :
				// InternalParser.g:1:234: RULE_KW_CONTINUE
				{
				mRULE_KW_CONTINUE(); 

				}
				break;
			case 17 :
				// InternalParser.g:1:251: RULE_KW_DEFAULT
				{
				mRULE_KW_DEFAULT(); 

				}
				break;
			case 18 :
				// InternalParser.g:1:267: RULE_KW_DO
				{
				mRULE_KW_DO(); 

				}
				break;
			case 19 :
				// InternalParser.g:1:278: RULE_KW_DOUBLE
				{
				mRULE_KW_DOUBLE(); 

				}
				break;
			case 20 :
				// InternalParser.g:1:293: RULE_KW_ELSE
				{
				mRULE_KW_ELSE(); 

				}
				break;
			case 21 :
				// InternalParser.g:1:306: RULE_KW_EXTENSION
				{
				mRULE_KW_EXTENSION(); 

				}
				break;
			case 22 :
				// InternalParser.g:1:324: RULE_KW_ENUM
				{
				mRULE_KW_ENUM(); 

				}
				break;
			case 23 :
				// InternalParser.g:1:337: RULE_KW_EXTERN
				{
				mRULE_KW_EXTERN(); 

				}
				break;
			case 24 :
				// InternalParser.g:1:352: RULE_KW_FLOAT
				{
				mRULE_KW_FLOAT(); 

				}
				break;
			case 25 :
				// InternalParser.g:1:366: RULE_KW_FOR
				{
				mRULE_KW_FOR(); 

				}
				break;
			case 26 :
				// InternalParser.g:1:378: RULE_KW_GENERIC
				{
				mRULE_KW_GENERIC(); 

				}
				break;
			case 27 :
				// InternalParser.g:1:394: RULE_KW_GOTO
				{
				mRULE_KW_GOTO(); 

				}
				break;
			case 28 :
				// InternalParser.g:1:407: RULE_KW_IF
				{
				mRULE_KW_IF(); 

				}
				break;
			case 29 :
				// InternalParser.g:1:418: RULE_KW_IMAGINARY
				{
				mRULE_KW_IMAGINARY(); 

				}
				break;
			case 30 :
				// InternalParser.g:1:436: RULE_KW_INLINE1
				{
				mRULE_KW_INLINE1(); 

				}
				break;
			case 31 :
				// InternalParser.g:1:452: RULE_KW_INLINE2
				{
				mRULE_KW_INLINE2(); 

				}
				break;
			case 32 :
				// InternalParser.g:1:468: RULE_KW_INT
				{
				mRULE_KW_INT(); 

				}
				break;
			case 33 :
				// InternalParser.g:1:480: RULE_KW_LONG
				{
				mRULE_KW_LONG(); 

				}
				break;
			case 34 :
				// InternalParser.g:1:493: RULE_KW_M128
				{
				mRULE_KW_M128(); 

				}
				break;
			case 35 :
				// InternalParser.g:1:506: RULE_KW_M128D
				{
				mRULE_KW_M128D(); 

				}
				break;
			case 36 :
				// InternalParser.g:1:520: RULE_KW_M128I
				{
				mRULE_KW_M128I(); 

				}
				break;
			case 37 :
				// InternalParser.g:1:534: RULE_KW_NORETURN
				{
				mRULE_KW_NORETURN(); 

				}
				break;
			case 38 :
				// InternalParser.g:1:551: RULE_KW_PRAGMA
				{
				mRULE_KW_PRAGMA(); 

				}
				break;
			case 39 :
				// InternalParser.g:1:566: RULE_KW_REGISTER
				{
				mRULE_KW_REGISTER(); 

				}
				break;
			case 40 :
				// InternalParser.g:1:583: RULE_KW_RESTRICT
				{
				mRULE_KW_RESTRICT(); 

				}
				break;
			case 41 :
				// InternalParser.g:1:600: RULE_KW_RESTRICT2
				{
				mRULE_KW_RESTRICT2(); 

				}
				break;
			case 42 :
				// InternalParser.g:1:618: RULE_KW_RESTRICT3
				{
				mRULE_KW_RESTRICT3(); 

				}
				break;
			case 43 :
				// InternalParser.g:1:636: RULE_KW_RETURN
				{
				mRULE_KW_RETURN(); 

				}
				break;
			case 44 :
				// InternalParser.g:1:651: RULE_KW_SHORT
				{
				mRULE_KW_SHORT(); 

				}
				break;
			case 45 :
				// InternalParser.g:1:665: RULE_KW_SIGNED1
				{
				mRULE_KW_SIGNED1(); 

				}
				break;
			case 46 :
				// InternalParser.g:1:681: RULE_KW_SIGNED2
				{
				mRULE_KW_SIGNED2(); 

				}
				break;
			case 47 :
				// InternalParser.g:1:697: RULE_KW_SIGNED3
				{
				mRULE_KW_SIGNED3(); 

				}
				break;
			case 48 :
				// InternalParser.g:1:713: RULE_KW_SIZEOF
				{
				mRULE_KW_SIZEOF(); 

				}
				break;
			case 49 :
				// InternalParser.g:1:728: RULE_KW_STATIC
				{
				mRULE_KW_STATIC(); 

				}
				break;
			case 50 :
				// InternalParser.g:1:743: RULE_KW_STATICASSERT
				{
				mRULE_KW_STATICASSERT(); 

				}
				break;
			case 51 :
				// InternalParser.g:1:764: RULE_KW_STRUCT
				{
				mRULE_KW_STRUCT(); 

				}
				break;
			case 52 :
				// InternalParser.g:1:779: RULE_KW_SWITCH
				{
				mRULE_KW_SWITCH(); 

				}
				break;
			case 53 :
				// InternalParser.g:1:794: RULE_KW_THREADLOCAL
				{
				mRULE_KW_THREADLOCAL(); 

				}
				break;
			case 54 :
				// InternalParser.g:1:814: RULE_KW_TYPEDEF
				{
				mRULE_KW_TYPEDEF(); 

				}
				break;
			case 55 :
				// InternalParser.g:1:830: RULE_KW_UNION
				{
				mRULE_KW_UNION(); 

				}
				break;
			case 56 :
				// InternalParser.g:1:844: RULE_KW_UNSIGNED
				{
				mRULE_KW_UNSIGNED(); 

				}
				break;
			case 57 :
				// InternalParser.g:1:861: RULE_KW_VOID
				{
				mRULE_KW_VOID(); 

				}
				break;
			case 58 :
				// InternalParser.g:1:874: RULE_KW_VOLATILE
				{
				mRULE_KW_VOLATILE(); 

				}
				break;
			case 59 :
				// InternalParser.g:1:891: RULE_KW_VOLATILE2
				{
				mRULE_KW_VOLATILE2(); 

				}
				break;
			case 60 :
				// InternalParser.g:1:909: RULE_KW_WHILE
				{
				mRULE_KW_WHILE(); 

				}
				break;
			case 61 :
				// InternalParser.g:1:923: RULE_STARASSIGN
				{
				mRULE_STARASSIGN(); 

				}
				break;
			case 62 :
				// InternalParser.g:1:939: RULE_DIVASSIGN
				{
				mRULE_DIVASSIGN(); 

				}
				break;
			case 63 :
				// InternalParser.g:1:954: RULE_MODASSIGN
				{
				mRULE_MODASSIGN(); 

				}
				break;
			case 64 :
				// InternalParser.g:1:969: RULE_PLUSASSIGN
				{
				mRULE_PLUSASSIGN(); 

				}
				break;
			case 65 :
				// InternalParser.g:1:985: RULE_MINUSASSIGN
				{
				mRULE_MINUSASSIGN(); 

				}
				break;
			case 66 :
				// InternalParser.g:1:1002: RULE_LEFTSHIFTASSIGN
				{
				mRULE_LEFTSHIFTASSIGN(); 

				}
				break;
			case 67 :
				// InternalParser.g:1:1023: RULE_RIGHTSHIFTASSIGN
				{
				mRULE_RIGHTSHIFTASSIGN(); 

				}
				break;
			case 68 :
				// InternalParser.g:1:1045: RULE_ANDASSIGN
				{
				mRULE_ANDASSIGN(); 

				}
				break;
			case 69 :
				// InternalParser.g:1:1060: RULE_XORASSIGN
				{
				mRULE_XORASSIGN(); 

				}
				break;
			case 70 :
				// InternalParser.g:1:1075: RULE_ORASSIGN
				{
				mRULE_ORASSIGN(); 

				}
				break;
			case 71 :
				// InternalParser.g:1:1089: RULE_ARROW
				{
				mRULE_ARROW(); 

				}
				break;
			case 72 :
				// InternalParser.g:1:1100: RULE_LINEDIRECTIVE
				{
				mRULE_LINEDIRECTIVE(); 

				}
				break;
			case 73 :
				// InternalParser.g:1:1119: RULE_WHITESPACE
				{
				mRULE_WHITESPACE(); 

				}
				break;
			case 74 :
				// InternalParser.g:1:1135: RULE_SKW_AND
				{
				mRULE_SKW_AND(); 

				}
				break;
			case 75 :
				// InternalParser.g:1:1148: RULE_SKW_ANDAND
				{
				mRULE_SKW_ANDAND(); 

				}
				break;
			case 76 :
				// InternalParser.g:1:1164: RULE_SKW_ASSIGN
				{
				mRULE_SKW_ASSIGN(); 

				}
				break;
			case 77 :
				// InternalParser.g:1:1180: RULE_SKW_BACKSLASH
				{
				mRULE_SKW_BACKSLASH(); 

				}
				break;
			case 78 :
				// InternalParser.g:1:1199: RULE_SKW_CARET
				{
				mRULE_SKW_CARET(); 

				}
				break;
			case 79 :
				// InternalParser.g:1:1214: RULE_SKW_COMMA
				{
				mRULE_SKW_COMMA(); 

				}
				break;
			case 80 :
				// InternalParser.g:1:1229: RULE_SKW_COLON
				{
				mRULE_SKW_COLON(); 

				}
				break;
			case 81 :
				// InternalParser.g:1:1244: RULE_SKW_DIV
				{
				mRULE_SKW_DIV(); 

				}
				break;
			case 82 :
				// InternalParser.g:1:1257: RULE_SKW_DOT
				{
				mRULE_SKW_DOT(); 

				}
				break;
			case 83 :
				// InternalParser.g:1:1270: RULE_SKW_DOUBLEQUOTE
				{
				mRULE_SKW_DOUBLEQUOTE(); 

				}
				break;
			case 84 :
				// InternalParser.g:1:1291: RULE_SKW_EQUAL
				{
				mRULE_SKW_EQUAL(); 

				}
				break;
			case 85 :
				// InternalParser.g:1:1306: RULE_SKW_GREATER
				{
				mRULE_SKW_GREATER(); 

				}
				break;
			case 86 :
				// InternalParser.g:1:1323: RULE_SKW_GREATEREQUAL
				{
				mRULE_SKW_GREATEREQUAL(); 

				}
				break;
			case 87 :
				// InternalParser.g:1:1345: RULE_SKW_LEFTBRACE
				{
				mRULE_SKW_LEFTBRACE(); 

				}
				break;
			case 88 :
				// InternalParser.g:1:1364: RULE_SKW_LEFTBRACKET
				{
				mRULE_SKW_LEFTBRACKET(); 

				}
				break;
			case 89 :
				// InternalParser.g:1:1385: RULE_SKW_LEFTPAREN
				{
				mRULE_SKW_LEFTPAREN(); 

				}
				break;
			case 90 :
				// InternalParser.g:1:1404: RULE_SKW_LEFTSHIFT
				{
				mRULE_SKW_LEFTSHIFT(); 

				}
				break;
			case 91 :
				// InternalParser.g:1:1423: RULE_SKW_LESS
				{
				mRULE_SKW_LESS(); 

				}
				break;
			case 92 :
				// InternalParser.g:1:1437: RULE_SKW_LESSEQUAL
				{
				mRULE_SKW_LESSEQUAL(); 

				}
				break;
			case 93 :
				// InternalParser.g:1:1456: RULE_SKW_MINUS
				{
				mRULE_SKW_MINUS(); 

				}
				break;
			case 94 :
				// InternalParser.g:1:1471: RULE_SKW_MINUSMINUS
				{
				mRULE_SKW_MINUSMINUS(); 

				}
				break;
			case 95 :
				// InternalParser.g:1:1491: RULE_SKW_MOD
				{
				mRULE_SKW_MOD(); 

				}
				break;
			case 96 :
				// InternalParser.g:1:1504: RULE_SKW_NOT
				{
				mRULE_SKW_NOT(); 

				}
				break;
			case 97 :
				// InternalParser.g:1:1517: RULE_SKW_NOTEQUAL
				{
				mRULE_SKW_NOTEQUAL(); 

				}
				break;
			case 98 :
				// InternalParser.g:1:1535: RULE_SKW_OR
				{
				mRULE_SKW_OR(); 

				}
				break;
			case 99 :
				// InternalParser.g:1:1547: RULE_SKW_OROR
				{
				mRULE_SKW_OROR(); 

				}
				break;
			case 100 :
				// InternalParser.g:1:1561: RULE_SKW_PLUS
				{
				mRULE_SKW_PLUS(); 

				}
				break;
			case 101 :
				// InternalParser.g:1:1575: RULE_SKW_PLUSPLUS
				{
				mRULE_SKW_PLUSPLUS(); 

				}
				break;
			case 102 :
				// InternalParser.g:1:1593: RULE_SKW_QUESTION
				{
				mRULE_SKW_QUESTION(); 

				}
				break;
			case 103 :
				// InternalParser.g:1:1611: RULE_SKW_RIGHTBRACE
				{
				mRULE_SKW_RIGHTBRACE(); 

				}
				break;
			case 104 :
				// InternalParser.g:1:1631: RULE_SKW_RIGHTBRACKET
				{
				mRULE_SKW_RIGHTBRACKET(); 

				}
				break;
			case 105 :
				// InternalParser.g:1:1653: RULE_SKW_RIGHTPAREN
				{
				mRULE_SKW_RIGHTPAREN(); 

				}
				break;
			case 106 :
				// InternalParser.g:1:1673: RULE_SKW_RIGHTSHIFT
				{
				mRULE_SKW_RIGHTSHIFT(); 

				}
				break;
			case 107 :
				// InternalParser.g:1:1693: RULE_SKW_SEMI
				{
				mRULE_SKW_SEMI(); 

				}
				break;
			case 108 :
				// InternalParser.g:1:1707: RULE_SKW_SINGLEQUOTE
				{
				mRULE_SKW_SINGLEQUOTE(); 

				}
				break;
			case 109 :
				// InternalParser.g:1:1728: RULE_SKW_STAR
				{
				mRULE_SKW_STAR(); 

				}
				break;
			case 110 :
				// InternalParser.g:1:1742: RULE_SKW_TILDE
				{
				mRULE_SKW_TILDE(); 

				}
				break;
			case 111 :
				// InternalParser.g:1:1757: RULE_ID
				{
				mRULE_ID(); 

				}
				break;
			case 112 :
				// InternalParser.g:1:1765: RULE_CHAR_LITERAL
				{
				mRULE_CHAR_LITERAL(); 

				}
				break;
			case 113 :
				// InternalParser.g:1:1783: RULE_STRING_LITERAL
				{
				mRULE_STRING_LITERAL(); 

				}
				break;
			case 114 :
				// InternalParser.g:1:1803: RULE_HEX_LITERAL
				{
				mRULE_HEX_LITERAL(); 

				}
				break;
			case 115 :
				// InternalParser.g:1:1820: RULE_DECIMAL_LITERAL
				{
				mRULE_DECIMAL_LITERAL(); 

				}
				break;
			case 116 :
				// InternalParser.g:1:1841: RULE_OCTAL_LITERAL
				{
				mRULE_OCTAL_LITERAL(); 

				}
				break;
			case 117 :
				// InternalParser.g:1:1860: RULE_BIN_LITERAL
				{
				mRULE_BIN_LITERAL(); 

				}
				break;
			case 118 :
				// InternalParser.g:1:1877: RULE_FLOAT_LITERAL
				{
				mRULE_FLOAT_LITERAL(); 

				}
				break;
			case 119 :
				// InternalParser.g:1:1896: RULE_LINEBREAK
				{
				mRULE_LINEBREAK(); 

				}
				break;
			case 120 :
				// InternalParser.g:1:1911: RULE_NEWLINE
				{
				mRULE_NEWLINE(); 

				}
				break;
			case 121 :
				// InternalParser.g:1:1924: RULE_BLOCK_COMMENT
				{
				mRULE_BLOCK_COMMENT(); 

				}
				break;
			case 122 :
				// InternalParser.g:1:1943: RULE_LINE_COMMENT
				{
				mRULE_LINE_COMMENT(); 

				}
				break;
			case 123 :
				// InternalParser.g:1:1961: RULE_SPECIAL
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
			return "24379:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )";
		}
	}


	static final String DFA37_eotS =
		"\1\uffff\21\64\1\131\1\135\1\137\1\141\1\144\1\150\1\153\1\156\1\161\1\163\2\uffff\1\170\1\172\2\uffff\1\176\1\u0080\3\uffff\1\u0085\5\uffff\1\u008c\2\uffff\2\u0091\3\uffff\20\64\1\u00ae\6\64\1\u00b5\14\64\20\uffff\1\u00c9\2\uffff\1\u00cb\45\uffff\1\u00cd\1\u0091\1\uffff\22\64\1\u00e1\6\64\1\uffff\4\64\1\u00ed\1\64\1\uffff\1\64\1\u00f0\21\64\5\uffff\22\64\1\u0114\1\uffff\1\64\1\u0116\1\u0117\4\64\1\u011c\1\u011d\2\64\1\uffff\1\u0120\1\64\1\uffff\1\u0122\15\64\1\u0130\5\64\1\u0136\7\64\1\u013f\6\64\1\uffff\1\u0146\2\uffff\1\u0147\3\64\2\uffff\1\64\1\u014c\1\uffff\1\64\1\uffff\4\64\1\u0152\6\64\1\u0159\1\64\1\uffff\1\64\1\u015c\3\64\1\uffff\4\64\1\u0165\3\64\1\uffff\6\64\2\uffff\2\64\1\u0173\1\u0174\1\uffff\1\u0175\1\u0176\2\64\1\u0179\1\uffff\1\u017a\1\u017b\1\u017c\1\u017d\1\u017e\1\64\1\uffff\2\64\1\uffff\1\u0182\3\64\1\u0186\3\64\1\uffff\1\u018a\1\u018b\12\64\1\u0196\4\uffff\2\64\6\uffff\1\u0199\2\64\1\uffff\1\u019c\1\u019d\1\64\1\uffff\2\64\1\u01a1\2\uffff\1\64\1\u01a3\1\64\1\u01a6\1\u01a7\4\64\1\u01ac\1\uffff\1\u01ad\1\u01ae\1\uffff\1\u01af\1\u01b0\2\uffff\3\64\1\uffff\1\64\1\uffff\2\64\2\uffff\1\64\1\u01b8\2\64\5\uffff\3\64\1\u01be\1\u01c0\1\64\1\u01c2\1\uffff\5\64\1\uffff\1\64\1\uffff\1\64\1\uffff\5\64\1\u01cf\1\u01d0\2\64\1\u01d3\1\64\1\u01d5\2\uffff\1\64\1\u01d7\1\uffff\1\64\1\uffff\1\u01d9\1\uffff\1\64\1\uffff\1\64\1\u01dc\1\uffff";
	static final String DFA37_eofS =
		"\u01dd\uffff";
	static final String DFA37_minS =
		"\1\0\1\101\1\163\1\162\1\141\1\145\2\154\1\157\1\146\1\157\1\162\1\145\1\150\1\171\1\156\1\157\1\150\1\75\1\52\1\75\1\53\1\55\1\74\1\75\1\46\2\75\2\uffff\1\75\1\12\2\uffff\1\60\1\0\3\uffff\1\75\5\uffff\1\0\2\uffff\2\56\3\uffff\1\154\1\141\2\157\1\145\1\155\1\157\1\164\1\150\1\164\1\155\1\145\1\163\1\141\1\156\1\146\1\44\1\163\1\165\1\164\1\157\1\162\1\164\1\44\1\154\1\156\1\141\1\147\1\157\1\147\1\141\1\151\1\160\3\151\20\uffff\1\75\2\uffff\1\75\45\uffff\2\56\1\uffff\1\157\1\151\1\163\1\165\1\170\1\156\1\61\1\145\1\151\2\157\1\155\1\156\1\141\1\162\1\141\1\162\1\157\1\44\1\141\1\145\1\162\1\163\1\141\1\142\1\uffff\1\145\1\155\1\145\1\141\1\44\1\157\1\uffff\1\151\1\44\2\147\1\151\1\164\1\165\1\162\1\156\1\145\1\164\1\165\1\164\1\145\1\157\1\151\1\144\1\141\1\154\5\uffff\1\155\1\147\1\164\1\155\1\151\1\164\1\154\1\62\1\163\1\147\2\154\1\160\1\145\1\147\1\145\1\164\1\145\1\44\1\uffff\1\153\2\44\1\164\1\151\1\165\1\154\2\44\1\162\1\164\1\uffff\1\44\1\156\1\uffff\1\44\1\155\1\163\2\162\1\164\1\145\1\157\1\151\2\143\1\144\1\156\1\147\1\44\1\164\1\145\1\151\1\156\1\162\1\44\1\154\1\145\1\151\1\70\1\164\1\156\1\141\1\44\1\154\1\162\1\151\1\164\1\151\1\141\1\uffff\1\44\2\uffff\1\44\1\156\1\154\1\145\2\uffff\1\156\1\44\1\uffff\1\145\1\uffff\1\141\1\164\1\151\1\156\1\44\1\144\1\146\1\143\1\164\1\150\1\145\1\44\1\156\1\uffff\1\151\1\44\1\143\1\141\1\151\1\uffff\1\137\1\164\2\156\1\44\1\162\1\145\1\164\1\uffff\1\145\1\151\1\156\1\165\1\143\1\144\2\uffff\1\165\1\164\2\44\1\uffff\2\44\1\145\1\143\1\44\1\uffff\5\44\1\146\1\uffff\1\145\1\154\1\uffff\1\44\1\163\1\146\1\142\1\44\1\151\1\163\1\145\1\uffff\2\44\1\151\1\144\1\151\1\170\1\143\1\141\1\162\2\137\1\145\1\44\4\uffff\1\162\1\164\6\uffff\1\44\1\144\1\145\1\uffff\2\44\1\165\1\uffff\1\156\1\151\1\44\2\uffff\1\143\1\44\1\154\2\44\1\162\1\156\1\141\1\154\1\44\1\uffff\2\44\1\uffff\2\44\2\uffff\1\164\1\137\1\157\1\uffff\1\164\1\uffff\1\137\1\145\2\uffff\1\171\1\44\1\163\1\157\5\uffff\1\145\1\166\1\156\2\44\1\137\1\44\1\uffff\1\163\1\143\1\137\1\141\1\137\1\uffff\1\137\1\uffff\1\137\1\uffff\1\145\1\141\3\137\2\44\1\162\1\154\1\44\1\154\1\44\2\uffff\1\164\1\44\1\uffff\1\151\1\uffff\1\44\1\uffff\1\163\1\uffff\1\164\1\44\1\uffff";
	static final String DFA37_maxS =
		"\1\uffff\1\137\1\165\1\162\2\157\1\170\2\157\1\156\1\157\1\162\1\145\1\167\1\171\1\156\1\157\1\150\4\75\1\76\1\75\1\76\2\75\1\174\2\uffff\1\75\1\15\2\uffff\1\71\1\uffff\3\uffff\1\75\5\uffff\1\uffff\2\uffff\1\170\1\146\3\uffff\1\164\1\166\2\157\1\145\1\155\1\157\1\164\1\150\1\164\1\155\1\145\1\163\1\141\1\156\1\146\1\172\1\163\1\165\1\164\1\157\1\162\1\164\1\172\1\164\1\156\1\141\1\164\1\157\1\172\1\162\1\151\1\160\1\163\1\154\1\151\20\uffff\1\75\2\uffff\1\75\45\uffff\2\146\1\uffff\1\157\1\151\1\164\1\165\1\170\1\156\1\61\1\145\1\151\2\157\1\155\1\156\1\141\1\162\1\141\1\162\1\157\1\172\1\141\1\145\1\162\1\164\1\141\1\142\1\uffff\1\145\1\155\1\145\1\141\1\172\1\157\1\uffff\1\151\1\172\2\147\1\151\1\164\1\165\1\162\1\156\1\145\1\164\1\165\1\164\1\145\1\157\1\151\1\144\1\141\1\154\5\uffff\1\155\1\147\1\164\1\155\1\151\1\164\1\154\1\62\1\163\1\147\2\154\1\160\1\145\1\147\1\145\1\164\1\145\1\172\1\uffff\1\153\2\172\1\164\1\151\1\165\1\154\2\172\1\162\1\164\1\uffff\1\172\1\156\1\uffff\1\172\1\155\1\163\2\162\1\164\1\145\1\157\1\151\2\143\1\144\1\156\1\147\1\172\1\164\1\145\1\151\1\156\1\162\1\172\1\154\1\145\1\151\1\70\1\164\1\156\1\141\1\172\1\154\1\162\1\151\1\164\1\151\1\141\1\uffff\1\172\2\uffff\1\172\1\156\1\154\1\145\2\uffff\1\156\1\172\1\uffff\1\145\1\uffff\1\141\1\164\1\151\1\156\1\172\1\144\1\146\1\143\1\164\1\150\1\145\1\172\1\156\1\uffff\1\151\1\172\1\143\1\157\1\151\1\uffff\1\137\1\164\2\156\1\172\1\162\1\145\1\164\1\uffff\1\145\1\151\1\156\1\165\1\143\1\144\2\uffff\1\165\1\164\2\172\1\uffff\2\172\1\145\1\143\1\172\1\uffff\5\172\1\146\1\uffff\1\145\1\154\1\uffff\1\172\1\163\1\146\1\142\1\172\1\151\1\163\1\145\1\uffff\2\172\1\151\1\144\1\151\1\170\1\143\1\141\1\162\2\137\1\145\1\172\4\uffff\1\162\1\164\6\uffff\1\172\1\144\1\145\1\uffff\2\172\1\165\1\uffff\1\156\1\151\1\172\2\uffff\1\143\1\172\1\154\2\172\1\162\1\156\1\141\1\154\1\172\1\uffff\2\172\1\uffff\2\172\2\uffff\1\164\1\137\1\157\1\uffff\1\164\1\uffff\1\137\1\145\2\uffff\1\171\1\172\1\163\1\157\5\uffff\1\145\1\166\1\156\2\172\1\137\1\172\1\uffff\1\163\1\143\1\137\1\141\1\137\1\uffff\1\137\1\uffff\1\137\1\uffff\1\145\1\141\3\137\2\172\1\162\1\154\1\172\1\154\1\172\2\uffff\1\164\1\172\1\uffff\1\151\1\uffff\1\172\1\uffff\1\163\1\uffff\1\164\1\172\1\uffff";
	static final String DFA37_acceptS =
		"\34\uffff\1\110\1\111\2\uffff\1\117\1\120\2\uffff\1\127\1\130\1\131\1\uffff\1\146\1\147\1\150\1\151\1\153\1\uffff\1\156\1\157\2\uffff\1\170\1\173\1\157\44\uffff\1\155\1\75\1\171\1\172\1\121\1\76\1\137\1\77\1\144\1\100\1\145\1\135\1\101\1\107\1\136\1\133\1\uffff\1\134\1\125\1\uffff\1\126\1\112\1\104\1\113\1\116\1\105\1\142\1\106\1\143\1\110\1\111\1\114\1\124\1\115\1\167\1\117\1\120\1\122\1\166\1\123\1\161\1\127\1\130\1\131\1\140\1\141\1\146\1\147\1\150\1\151\1\153\1\154\1\160\1\156\1\162\1\165\1\163\2\uffff\1\170\31\uffff\1\22\6\uffff\1\34\23\uffff\1\132\1\102\1\152\1\103\1\164\23\uffff\1\6\13\uffff\1\31\2\uffff\1\40\43\uffff\1\3\1\uffff\1\14\1\15\4\uffff\1\24\1\26\2\uffff\1\33\1\uffff\1\41\15\uffff\1\71\5\uffff\1\7\10\uffff\1\11\6\uffff\1\12\1\17\4\uffff\1\30\5\uffff\1\54\6\uffff\1\67\2\uffff\1\74\10\uffff\1\42\15\uffff\1\23\1\27\1\36\1\46\2\uffff\1\53\1\55\1\60\1\61\1\63\1\64\3\uffff\1\1\3\uffff\1\10\3\uffff\1\43\1\44\12\uffff\1\21\2\uffff\1\66\2\uffff\1\4\1\5\3\uffff\1\37\1\uffff\1\56\2\uffff\1\16\1\32\4\uffff\1\20\1\47\1\50\1\70\1\72\7\uffff\1\45\5\uffff\1\51\1\uffff\1\57\1\uffff\1\35\14\uffff\1\52\1\73\2\uffff\1\2\1\uffff\1\25\1\uffff\1\65\1\uffff\1\62\2\uffff\1\13";
	static final String DFA37_specialS =
		"\1\1\42\uffff\1\0\11\uffff\1\2\u01af\uffff}>";
	static final String[] DFA37_transitionS = {
			"\11\63\1\35\1\62\2\63\1\62\22\63\1\35\1\47\1\43\1\34\1\57\1\24\1\31\1\55\1\46\1\53\1\22\1\25\1\40\1\26\1\42\1\23\1\60\11\61\1\41\1\54\1\27\1\36\1\30\1\50\1\63\32\57\1\45\1\37\1\52\1\32\1\1\1\63\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\57\1\11\2\57\1\12\3\57\1\13\1\57\1\14\1\15\1\16\1\17\1\20\1\21\3\57\1\44\1\33\1\51\1\56\uff81\63",
			"\1\65\1\67\1\70\3\uffff\1\71\1\uffff\1\72\4\uffff\1\73\4\uffff\1\74\1\75\12\uffff\1\66",
			"\1\77\1\uffff\1\76",
			"\1\100",
			"\1\101\6\uffff\1\102\6\uffff\1\103",
			"\1\104\11\uffff\1\105",
			"\1\106\1\uffff\1\107\11\uffff\1\110",
			"\1\111\2\uffff\1\112",
			"\1\113",
			"\1\114\7\uffff\1\115",
			"\1\116",
			"\1\117",
			"\1\120",
			"\1\121\1\122\12\uffff\1\123\2\uffff\1\124",
			"\1\125",
			"\1\126",
			"\1\127",
			"\1\130",
			"\1\132",
			"\1\133\4\uffff\1\134\15\uffff\1\136",
			"\1\140",
			"\1\143\21\uffff\1\142",
			"\1\147\17\uffff\1\145\1\146",
			"\1\151\1\152",
			"\1\155\1\154",
			"\1\160\26\uffff\1\157",
			"\1\162",
			"\1\164\76\uffff\1\165",
			"",
			"",
			"\1\171",
			"\1\173\2\uffff\1\173",
			"",
			"",
			"\12\177",
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
			"\1\177\1\uffff\10\u0092\2\177\10\uffff\1\u0090\1\uffff\3\177\21\uffff\1\u008f\11\uffff\1\u0090\1\uffff\3\177\21\uffff\1\u008f",
			"\1\177\1\uffff\12\u0093\12\uffff\3\177\35\uffff\3\177",
			"",
			"",
			"",
			"\1\u0096\7\uffff\1\u0095",
			"\1\u0097\1\u0098\2\uffff\1\u0099\3\uffff\1\u009a\3\uffff\1\u009b\4\uffff\1\u009c\1\u009d\2\uffff\1\u009e",
			"\1\u009f",
			"\1\u00a0",
			"\1\u00a1",
			"\1\u00a2",
			"\1\u00a3",
			"\1\u00a4",
			"\1\u00a5",
			"\1\u00a6",
			"\1\u00a7",
			"\1\u00a8",
			"\1\u00a9",
			"\1\u00aa",
			"\1\u00ab",
			"\1\u00ac",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\24\64\1\u00ad\5\64",
			"\1\u00af",
			"\1\u00b0",
			"\1\u00b1",
			"\1\u00b2",
			"\1\u00b3",
			"\1\u00b4",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u00b6\7\uffff\1\u00b7",
			"\1\u00b8",
			"\1\u00b9",
			"\1\u00ba\13\uffff\1\u00bb\1\u00bc",
			"\1\u00bd",
			"\1\u00be\22\uffff\1\u00bf",
			"\1\u00c0\20\uffff\1\u00c1",
			"\1\u00c2",
			"\1\u00c3",
			"\1\u00c4\11\uffff\1\u00c5",
			"\1\u00c6\2\uffff\1\u00c7",
			"\1\u00c8",
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
			"\1\u00ca",
			"",
			"",
			"\1\u00cc",
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
			"\1\177\1\uffff\10\u0092\2\177\12\uffff\3\177\35\uffff\3\177",
			"\1\177\1\uffff\12\u0093\12\uffff\3\177\35\uffff\3\177",
			"",
			"\1\u00ce",
			"\1\u00cf",
			"\1\u00d1\1\u00d0",
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
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u00e2",
			"\1\u00e3",
			"\1\u00e4",
			"\1\u00e5\1\u00e6",
			"\1\u00e7",
			"\1\u00e8",
			"",
			"\1\u00e9",
			"\1\u00ea",
			"\1\u00eb",
			"\1\u00ec",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u00ee",
			"",
			"\1\u00ef",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u00f1",
			"\1\u00f2",
			"\1\u00f3",
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
			"\1\u0100",
			"\1\u0101",
			"",
			"",
			"",
			"",
			"",
			"\1\u0102",
			"\1\u0103",
			"\1\u0104",
			"\1\u0105",
			"\1\u0106",
			"\1\u0107",
			"\1\u0108",
			"\1\u0109",
			"\1\u010a",
			"\1\u010b",
			"\1\u010c",
			"\1\u010d",
			"\1\u010e",
			"\1\u010f",
			"\1\u0110",
			"\1\u0111",
			"\1\u0112",
			"\1\u0113",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\u0115",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0118",
			"\1\u0119",
			"\1\u011a",
			"\1\u011b",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u011e",
			"\1\u011f",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0121",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0123",
			"\1\u0124",
			"\1\u0125",
			"\1\u0126",
			"\1\u0127",
			"\1\u0128",
			"\1\u0129",
			"\1\u012a",
			"\1\u012b",
			"\1\u012c",
			"\1\u012d",
			"\1\u012e",
			"\1\u012f",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0131",
			"\1\u0132",
			"\1\u0133",
			"\1\u0134",
			"\1\u0135",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\u0137\1\uffff\32\64",
			"\1\u0138",
			"\1\u0139",
			"\1\u013a",
			"\1\u013b",
			"\1\u013c",
			"\1\u013d",
			"\1\u013e",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0140",
			"\1\u0141",
			"\1\u0142",
			"\1\u0143",
			"\1\u0144",
			"\1\u0145",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0148",
			"\1\u0149",
			"\1\u014a",
			"",
			"",
			"\1\u014b",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\u014d",
			"",
			"\1\u014e",
			"\1\u014f",
			"\1\u0150",
			"\1\u0151",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0153",
			"\1\u0154",
			"\1\u0155",
			"\1\u0156",
			"\1\u0157",
			"\1\u0158",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u015a",
			"",
			"\1\u015b",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u015d",
			"\1\u015e\15\uffff\1\u015f",
			"\1\u0160",
			"",
			"\1\u0161",
			"\1\u0162",
			"\1\u0163",
			"\1\u0164",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\3\64\1\u0166\4\64\1\u0167\21\64",
			"\1\u0168",
			"\1\u0169",
			"\1\u016a",
			"",
			"\1\u016b",
			"\1\u016c",
			"\1\u016d",
			"\1\u016e",
			"\1\u016f",
			"\1\u0170",
			"",
			"",
			"\1\u0171",
			"\1\u0172",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0177",
			"\1\u0178",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u017f",
			"",
			"\1\u0180",
			"\1\u0181",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0183",
			"\1\u0184",
			"\1\u0185",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0187",
			"\1\u0188",
			"\1\u0189",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u018c",
			"\1\u018d",
			"\1\u018e",
			"\1\u018f",
			"\1\u0190",
			"\1\u0191",
			"\1\u0192",
			"\1\u0193",
			"\1\u0194",
			"\1\u0195",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"",
			"",
			"",
			"\1\u0197",
			"\1\u0198",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u019a",
			"\1\u019b",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u019e",
			"",
			"\1\u019f",
			"\1\u01a0",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"",
			"\1\u01a2",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\u01a4\1\uffff\32\64",
			"\1\u01a5",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u01a8",
			"\1\u01a9",
			"\1\u01aa",
			"\1\u01ab",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"",
			"\1\u01b1",
			"\1\u01b2",
			"\1\u01b3",
			"",
			"\1\u01b4",
			"",
			"\1\u01b5",
			"\1\u01b6",
			"",
			"",
			"\1\u01b7",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u01b9",
			"\1\u01ba",
			"",
			"",
			"",
			"",
			"",
			"\1\u01bb",
			"\1\u01bc",
			"\1\u01bd",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\u01bf\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u01c1",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\u01c3",
			"\1\u01c4",
			"\1\u01c5",
			"\1\u01c6",
			"\1\u01c7",
			"",
			"\1\u01c8",
			"",
			"\1\u01c9",
			"",
			"\1\u01ca",
			"\1\u01cb",
			"\1\u01cc",
			"\1\u01cd",
			"\1\u01ce",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u01d1",
			"\1\u01d2",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u01d4",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"",
			"\1\u01d6",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\u01d8",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\u01da",
			"",
			"\1\u01db",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
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
			return "1:1: Tokens : ( RULE_KW_ATOMIC | RULE_KW_ATTRIBUTE | RULE_KW_AUTO | RULE_KW_ALIGNAS | RULE_KW_ALIGNOF | RULE_KW_ASM1 | RULE_KW_ASM2 | RULE_KW_ASM3 | RULE_KW_BOOL | RULE_KW_BREAK | RULE_KW_BUILTIN_VA_LIST | RULE_KW_CASE | RULE_KW_CHAR | RULE_KW_COMPLEX | RULE_KW_CONST | RULE_KW_CONTINUE | RULE_KW_DEFAULT | RULE_KW_DO | RULE_KW_DOUBLE | RULE_KW_ELSE | RULE_KW_EXTENSION | RULE_KW_ENUM | RULE_KW_EXTERN | RULE_KW_FLOAT | RULE_KW_FOR | RULE_KW_GENERIC | RULE_KW_GOTO | RULE_KW_IF | RULE_KW_IMAGINARY | RULE_KW_INLINE1 | RULE_KW_INLINE2 | RULE_KW_INT | RULE_KW_LONG | RULE_KW_M128 | RULE_KW_M128D | RULE_KW_M128I | RULE_KW_NORETURN | RULE_KW_PRAGMA | RULE_KW_REGISTER | RULE_KW_RESTRICT | RULE_KW_RESTRICT2 | RULE_KW_RESTRICT3 | RULE_KW_RETURN | RULE_KW_SHORT | RULE_KW_SIGNED1 | RULE_KW_SIGNED2 | RULE_KW_SIGNED3 | RULE_KW_SIZEOF | RULE_KW_STATIC | RULE_KW_STATICASSERT | RULE_KW_STRUCT | RULE_KW_SWITCH | RULE_KW_THREADLOCAL | RULE_KW_TYPEDEF | RULE_KW_UNION | RULE_KW_UNSIGNED | RULE_KW_VOID | RULE_KW_VOLATILE | RULE_KW_VOLATILE2 | RULE_KW_WHILE | RULE_STARASSIGN | RULE_DIVASSIGN | RULE_MODASSIGN | RULE_PLUSASSIGN | RULE_MINUSASSIGN | RULE_LEFTSHIFTASSIGN | RULE_RIGHTSHIFTASSIGN | RULE_ANDASSIGN | RULE_XORASSIGN | RULE_ORASSIGN | RULE_ARROW | RULE_LINEDIRECTIVE | RULE_WHITESPACE | RULE_SKW_AND | RULE_SKW_ANDAND | RULE_SKW_ASSIGN | RULE_SKW_BACKSLASH | RULE_SKW_CARET | RULE_SKW_COMMA | RULE_SKW_COLON | RULE_SKW_DIV | RULE_SKW_DOT | RULE_SKW_DOUBLEQUOTE | RULE_SKW_EQUAL | RULE_SKW_GREATER | RULE_SKW_GREATEREQUAL | RULE_SKW_LEFTBRACE | RULE_SKW_LEFTBRACKET | RULE_SKW_LEFTPAREN | RULE_SKW_LEFTSHIFT | RULE_SKW_LESS | RULE_SKW_LESSEQUAL | RULE_SKW_MINUS | RULE_SKW_MINUSMINUS | RULE_SKW_MOD | RULE_SKW_NOT | RULE_SKW_NOTEQUAL | RULE_SKW_OR | RULE_SKW_OROR | RULE_SKW_PLUS | RULE_SKW_PLUSPLUS | RULE_SKW_QUESTION | RULE_SKW_RIGHTBRACE | RULE_SKW_RIGHTBRACKET | RULE_SKW_RIGHTPAREN | RULE_SKW_RIGHTSHIFT | RULE_SKW_SEMI | RULE_SKW_SINGLEQUOTE | RULE_SKW_STAR | RULE_SKW_TILDE | RULE_ID | RULE_CHAR_LITERAL | RULE_STRING_LITERAL | RULE_HEX_LITERAL | RULE_DECIMAL_LITERAL | RULE_OCTAL_LITERAL | RULE_BIN_LITERAL | RULE_FLOAT_LITERAL | RULE_LINEBREAK | RULE_NEWLINE | RULE_BLOCK_COMMENT | RULE_LINE_COMMENT | RULE_SPECIAL );";
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
				int LA37_35 = input.LA(1);
				s = -1;
				if ( ((LA37_35 >= '\u0000' && LA37_35 <= '\uFFFF')) ) {s = 129;}
				else s = 128;
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
				else if ( (LA37_0=='#') ) {s = 28;}
				else if ( (LA37_0=='\t'||LA37_0==' ') ) {s = 29;}
				else if ( (LA37_0=='=') ) {s = 30;}
				else if ( (LA37_0=='\\') ) {s = 31;}
				else if ( (LA37_0==',') ) {s = 32;}
				else if ( (LA37_0==':') ) {s = 33;}
				else if ( (LA37_0=='.') ) {s = 34;}
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
				int LA37_45 = input.LA(1);
				s = -1;
				if ( ((LA37_45 >= '\u0000' && LA37_45 <= '&')||(LA37_45 >= '(' && LA37_45 <= '\uFFFF')) ) {s = 141;}
				else s = 140;
				//if ( s>=0 ) return s;
				//break;
				return s;
			}

	}


}