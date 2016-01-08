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
	public static final int RULE_KW_ALIGNOF1=23;
	public static final int RULE_KW_ALIGNOF2=24;
	public static final int RULE_KW_ALIGNOF3=25;
	public static final int RULE_KW_ASM1=26;
	public static final int RULE_KW_ASM2=27;
	public static final int RULE_KW_ASM3=28;
	public static final int RULE_KW_ATOMIC=29;
	public static final int RULE_KW_ATTRIBUTE=30;
	public static final int RULE_KW_AUTO=31;
	public static final int RULE_KW_BOOL=32;
	public static final int RULE_KW_BREAK=33;
	public static final int RULE_KW_BUILTIN_OFFSETOF=34;
	public static final int RULE_KW_BUILTIN_VA_LIST=35;
	public static final int RULE_KW_CASE=36;
	public static final int RULE_KW_CHAR=37;
	public static final int RULE_KW_COMPLEX=38;
	public static final int RULE_KW_CONST=39;
	public static final int RULE_KW_CONTINUE=40;
	public static final int RULE_KW_DEFAULT=41;
	public static final int RULE_KW_DO=42;
	public static final int RULE_KW_DOUBLE=43;
	public static final int RULE_KW_ELSE=44;
	public static final int RULE_KW_ENUM=45;
	public static final int RULE_KW_EXTENSION=46;
	public static final int RULE_KW_EXTERN=47;
	public static final int RULE_KW_FLOAT=48;
	public static final int RULE_KW_FOR=49;
	public static final int RULE_KW_GENERIC=50;
	public static final int RULE_KW_GOTO=51;
	public static final int RULE_KW_IF=52;
	public static final int RULE_KW_IMAGINARY=53;
	public static final int RULE_KW_INLINE1=54;
	public static final int RULE_KW_INLINE2=55;
	public static final int RULE_KW_INLINE3=56;
	public static final int RULE_KW_INT=57;
	public static final int RULE_KW_LONG=58;
	public static final int RULE_KW_M128=59;
	public static final int RULE_KW_M128D=60;
	public static final int RULE_KW_M128I=61;
	public static final int RULE_KW_NORETURN=62;
	public static final int RULE_KW_PRAGMA=63;
	public static final int RULE_KW_REGISTER=64;
	public static final int RULE_KW_RESTRICT=65;
	public static final int RULE_KW_RESTRICT2=66;
	public static final int RULE_KW_RESTRICT3=67;
	public static final int RULE_KW_RETURN=68;
	public static final int RULE_KW_SHORT=69;
	public static final int RULE_KW_SIGNED1=70;
	public static final int RULE_KW_SIGNED2=71;
	public static final int RULE_KW_SIGNED3=72;
	public static final int RULE_KW_SIZEOF=73;
	public static final int RULE_KW_STATIC=74;
	public static final int RULE_KW_STATICASSERT=75;
	public static final int RULE_KW_STRUCT=76;
	public static final int RULE_KW_SWITCH=77;
	public static final int RULE_KW_THREADLOCAL=78;
	public static final int RULE_KW_TYPEDEF=79;
	public static final int RULE_KW_TYPEOF1=80;
	public static final int RULE_KW_TYPEOF3=81;
	public static final int RULE_KW_UNION=82;
	public static final int RULE_KW_UNSIGNED=83;
	public static final int RULE_KW_VOID=84;
	public static final int RULE_KW_VOLATILE=85;
	public static final int RULE_KW_VOLATILE2=86;
	public static final int RULE_KW_WHILE=87;
	public static final int RULE_LEFTSHIFTASSIGN=88;
	public static final int RULE_LETTER=89;
	public static final int RULE_LINEBREAK=90;
	public static final int RULE_LINEDIRECTIVE=91;
	public static final int RULE_LINEFEED=92;
	public static final int RULE_LINE_COMMENT=93;
	public static final int RULE_LINE_END=94;
	public static final int RULE_LONG_LONG_SUFFIX=95;
	public static final int RULE_LONG_SUFFIX=96;
	public static final int RULE_MINUSASSIGN=97;
	public static final int RULE_MODASSIGN=98;
	public static final int RULE_NEWLINE=99;
	public static final int RULE_OCTAL_ESCAPE=100;
	public static final int RULE_OCTAL_LITERAL=101;
	public static final int RULE_ORASSIGN=102;
	public static final int RULE_PLUSASSIGN=103;
	public static final int RULE_RIGHTSHIFTASSIGN=104;
	public static final int RULE_SKW_AND=105;
	public static final int RULE_SKW_ANDAND=106;
	public static final int RULE_SKW_ASSIGN=107;
	public static final int RULE_SKW_BACKSLASH=108;
	public static final int RULE_SKW_CARET=109;
	public static final int RULE_SKW_COLON=110;
	public static final int RULE_SKW_COMMA=111;
	public static final int RULE_SKW_DIV=112;
	public static final int RULE_SKW_DOLLAR=113;
	public static final int RULE_SKW_DOT=114;
	public static final int RULE_SKW_DOUBLEQUOTE=115;
	public static final int RULE_SKW_EQUAL=116;
	public static final int RULE_SKW_GREATER=117;
	public static final int RULE_SKW_GREATEREQUAL=118;
	public static final int RULE_SKW_LEFTBRACE=119;
	public static final int RULE_SKW_LEFTBRACKET=120;
	public static final int RULE_SKW_LEFTPAREN=121;
	public static final int RULE_SKW_LEFTSHIFT=122;
	public static final int RULE_SKW_LESS=123;
	public static final int RULE_SKW_LESSEQUAL=124;
	public static final int RULE_SKW_MINUS=125;
	public static final int RULE_SKW_MINUSMINUS=126;
	public static final int RULE_SKW_MOD=127;
	public static final int RULE_SKW_NOT=128;
	public static final int RULE_SKW_NOTEQUAL=129;
	public static final int RULE_SKW_OR=130;
	public static final int RULE_SKW_OROR=131;
	public static final int RULE_SKW_PLUS=132;
	public static final int RULE_SKW_PLUSPLUS=133;
	public static final int RULE_SKW_QUESTION=134;
	public static final int RULE_SKW_RIGHTBRACE=135;
	public static final int RULE_SKW_RIGHTBRACKET=136;
	public static final int RULE_SKW_RIGHTPAREN=137;
	public static final int RULE_SKW_RIGHTSHIFT=138;
	public static final int RULE_SKW_SEMI=139;
	public static final int RULE_SKW_SINGLEQUOTE=140;
	public static final int RULE_SKW_STAR=141;
	public static final int RULE_SKW_TILDE=142;
	public static final int RULE_SKW_UNDERSCORE=143;
	public static final int RULE_SPACE=144;
	public static final int RULE_SPECIAL=145;
	public static final int RULE_STARASSIGN=146;
	public static final int RULE_STRING_LITERAL=147;
	public static final int RULE_TAB=148;
	public static final int RULE_UNSIGNED_SUFFIX=149;
	public static final int RULE_WHITESPACE=150;
	public static final int RULE_XORASSIGN=151;

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
			// InternalParser.g:25649:16: ( RULE_SKW_UNDERSCORE 'Atomic' )
			// InternalParser.g:25649:18: RULE_SKW_UNDERSCORE 'Atomic'
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
			// InternalParser.g:25651:19: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'attribute' RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE )
			// InternalParser.g:25651:21: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'attribute' RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE
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
			// InternalParser.g:25653:14: ( 'auto' )
			// InternalParser.g:25653:16: 'auto'
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
			// InternalParser.g:25655:17: ( RULE_SKW_UNDERSCORE 'Alignas' )
			// InternalParser.g:25655:19: RULE_SKW_UNDERSCORE 'Alignas'
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

	// $ANTLR start "RULE_KW_ALIGNOF1"
	public final void mRULE_KW_ALIGNOF1() throws RecognitionException {
		try {
			int _type = RULE_KW_ALIGNOF1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:25657:18: ( 'alignof' )
			// InternalParser.g:25657:20: 'alignof'
			{
			match("alignof"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_ALIGNOF1"

	// $ANTLR start "RULE_KW_ALIGNOF2"
	public final void mRULE_KW_ALIGNOF2() throws RecognitionException {
		try {
			int _type = RULE_KW_ALIGNOF2;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:25659:18: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_ALIGNOF1 )
			// InternalParser.g:25659:20: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_ALIGNOF1
			{
			mRULE_SKW_UNDERSCORE(); 

			mRULE_SKW_UNDERSCORE(); 

			mRULE_KW_ALIGNOF1(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_ALIGNOF2"

	// $ANTLR start "RULE_KW_ALIGNOF3"
	public final void mRULE_KW_ALIGNOF3() throws RecognitionException {
		try {
			int _type = RULE_KW_ALIGNOF3;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:25661:18: ( RULE_KW_ALIGNOF2 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE )
			// InternalParser.g:25661:20: RULE_KW_ALIGNOF2 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE
			{
			mRULE_KW_ALIGNOF2(); 

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
	// $ANTLR end "RULE_KW_ALIGNOF3"

	// $ANTLR start "RULE_KW_ASM1"
	public final void mRULE_KW_ASM1() throws RecognitionException {
		try {
			int _type = RULE_KW_ASM1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:25663:14: ( 'asm' )
			// InternalParser.g:25663:16: 'asm'
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
			// InternalParser.g:25665:14: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_ASM1 )
			// InternalParser.g:25665:16: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_ASM1
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
			// InternalParser.g:25667:14: ( RULE_KW_ASM2 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE )
			// InternalParser.g:25667:16: RULE_KW_ASM2 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE
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
			// InternalParser.g:25669:14: ( RULE_SKW_UNDERSCORE 'Bool' )
			// InternalParser.g:25669:16: RULE_SKW_UNDERSCORE 'Bool'
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
			// InternalParser.g:25671:15: ( 'break' )
			// InternalParser.g:25671:17: 'break'
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
			// InternalParser.g:25673:25: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'builtin_va_list' )
			// InternalParser.g:25673:27: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'builtin_va_list'
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

	// $ANTLR start "RULE_KW_BUILTIN_OFFSETOF"
	public final void mRULE_KW_BUILTIN_OFFSETOF() throws RecognitionException {
		try {
			int _type = RULE_KW_BUILTIN_OFFSETOF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:25675:26: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'builtin_offsetof' )
			// InternalParser.g:25675:28: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'builtin_offsetof'
			{
			mRULE_SKW_UNDERSCORE(); 

			mRULE_SKW_UNDERSCORE(); 

			match("builtin_offsetof"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_BUILTIN_OFFSETOF"

	// $ANTLR start "RULE_KW_CASE"
	public final void mRULE_KW_CASE() throws RecognitionException {
		try {
			int _type = RULE_KW_CASE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:25677:14: ( 'case' )
			// InternalParser.g:25677:16: 'case'
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
			// InternalParser.g:25679:14: ( 'char' )
			// InternalParser.g:25679:16: 'char'
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
			// InternalParser.g:25681:17: ( RULE_SKW_UNDERSCORE 'Complex' )
			// InternalParser.g:25681:19: RULE_SKW_UNDERSCORE 'Complex'
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
			// InternalParser.g:25683:15: ( 'const' )
			// InternalParser.g:25683:17: 'const'
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
			// InternalParser.g:25685:18: ( 'continue' )
			// InternalParser.g:25685:20: 'continue'
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
			// InternalParser.g:25687:17: ( 'default' )
			// InternalParser.g:25687:19: 'default'
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
			// InternalParser.g:25689:12: ( 'do' )
			// InternalParser.g:25689:14: 'do'
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
			// InternalParser.g:25691:16: ( 'double' )
			// InternalParser.g:25691:18: 'double'
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
			// InternalParser.g:25693:14: ( 'else' )
			// InternalParser.g:25693:16: 'else'
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
			// InternalParser.g:25695:19: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'extension' RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE )
			// InternalParser.g:25695:21: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'extension' RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE
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
			// InternalParser.g:25697:14: ( 'enum' )
			// InternalParser.g:25697:16: 'enum'
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
			// InternalParser.g:25699:16: ( 'extern' )
			// InternalParser.g:25699:18: 'extern'
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
			// InternalParser.g:25701:15: ( 'float' )
			// InternalParser.g:25701:17: 'float'
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
			// InternalParser.g:25703:13: ( 'for' )
			// InternalParser.g:25703:15: 'for'
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
			// InternalParser.g:25705:17: ( RULE_SKW_UNDERSCORE 'Generic' )
			// InternalParser.g:25705:19: RULE_SKW_UNDERSCORE 'Generic'
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
			// InternalParser.g:25707:14: ( 'goto' )
			// InternalParser.g:25707:16: 'goto'
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
			// InternalParser.g:25709:12: ( 'if' )
			// InternalParser.g:25709:14: 'if'
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
			// InternalParser.g:25711:19: ( RULE_SKW_UNDERSCORE 'Imaginary' )
			// InternalParser.g:25711:21: RULE_SKW_UNDERSCORE 'Imaginary'
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
			// InternalParser.g:25713:17: ( 'inline' )
			// InternalParser.g:25713:19: 'inline'
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
			// InternalParser.g:25715:17: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_INLINE1 )
			// InternalParser.g:25715:19: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_INLINE1
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

	// $ANTLR start "RULE_KW_INLINE3"
	public final void mRULE_KW_INLINE3() throws RecognitionException {
		try {
			int _type = RULE_KW_INLINE3;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:25717:17: ( RULE_KW_INLINE2 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE )
			// InternalParser.g:25717:19: RULE_KW_INLINE2 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE
			{
			mRULE_KW_INLINE2(); 

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
	// $ANTLR end "RULE_KW_INLINE3"

	// $ANTLR start "RULE_KW_INT"
	public final void mRULE_KW_INT() throws RecognitionException {
		try {
			int _type = RULE_KW_INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:25719:13: ( 'int' )
			// InternalParser.g:25719:15: 'int'
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
			// InternalParser.g:25721:14: ( 'long' )
			// InternalParser.g:25721:16: 'long'
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
			// InternalParser.g:25723:14: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'm128' )
			// InternalParser.g:25723:16: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'm128'
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
			// InternalParser.g:25725:15: ( RULE_KW_M128 'd' )
			// InternalParser.g:25725:17: RULE_KW_M128 'd'
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
			// InternalParser.g:25727:15: ( RULE_KW_M128 'i' )
			// InternalParser.g:25727:17: RULE_KW_M128 'i'
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
			// InternalParser.g:25729:18: ( RULE_SKW_UNDERSCORE 'Noreturn' )
			// InternalParser.g:25729:20: RULE_SKW_UNDERSCORE 'Noreturn'
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
			// InternalParser.g:25731:16: ( 'pragma' )
			// InternalParser.g:25731:18: 'pragma'
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
			// InternalParser.g:25733:18: ( 'register' )
			// InternalParser.g:25733:20: 'register'
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
			// InternalParser.g:25735:18: ( 'restrict' )
			// InternalParser.g:25735:20: 'restrict'
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
			// InternalParser.g:25737:19: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_RESTRICT )
			// InternalParser.g:25737:21: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_RESTRICT
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
			// InternalParser.g:25739:19: ( RULE_KW_RESTRICT2 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE )
			// InternalParser.g:25739:21: RULE_KW_RESTRICT2 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE
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
			// InternalParser.g:25741:16: ( 'return' )
			// InternalParser.g:25741:18: 'return'
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
			// InternalParser.g:25743:15: ( 'short' )
			// InternalParser.g:25743:17: 'short'
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
			// InternalParser.g:25745:17: ( 'signed' )
			// InternalParser.g:25745:19: 'signed'
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
			// InternalParser.g:25747:17: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_SIGNED1 )
			// InternalParser.g:25747:19: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_SIGNED1
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
			// InternalParser.g:25749:17: ( RULE_KW_SIGNED2 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE )
			// InternalParser.g:25749:19: RULE_KW_SIGNED2 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE
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
			// InternalParser.g:25751:16: ( 'sizeof' )
			// InternalParser.g:25751:18: 'sizeof'
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
			// InternalParser.g:25753:16: ( 'static' )
			// InternalParser.g:25753:18: 'static'
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
			// InternalParser.g:25755:22: ( RULE_SKW_UNDERSCORE 'Static_assert' )
			// InternalParser.g:25755:24: RULE_SKW_UNDERSCORE 'Static_assert'
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
			// InternalParser.g:25757:16: ( 'struct' )
			// InternalParser.g:25757:18: 'struct'
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
			// InternalParser.g:25759:16: ( 'switch' )
			// InternalParser.g:25759:18: 'switch'
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
			// InternalParser.g:25761:21: ( RULE_SKW_UNDERSCORE 'Thread_local' )
			// InternalParser.g:25761:23: RULE_SKW_UNDERSCORE 'Thread_local'
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
			// InternalParser.g:25763:17: ( 'typedef' )
			// InternalParser.g:25763:19: 'typedef'
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

	// $ANTLR start "RULE_KW_TYPEOF1"
	public final void mRULE_KW_TYPEOF1() throws RecognitionException {
		try {
			int _type = RULE_KW_TYPEOF1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:25765:17: ( 'typeof' )
			// InternalParser.g:25765:19: 'typeof'
			{
			match("typeof"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_KW_TYPEOF1"

	// $ANTLR start "RULE_KW_TYPEOF3"
	public final void mRULE_KW_TYPEOF3() throws RecognitionException {
		try {
			int _type = RULE_KW_TYPEOF3;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:25767:17: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_TYPEOF1 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE )
			// InternalParser.g:25767:19: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_TYPEOF1 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE
			{
			mRULE_SKW_UNDERSCORE(); 

			mRULE_SKW_UNDERSCORE(); 

			mRULE_KW_TYPEOF1(); 

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
	// $ANTLR end "RULE_KW_TYPEOF3"

	// $ANTLR start "RULE_KW_UNION"
	public final void mRULE_KW_UNION() throws RecognitionException {
		try {
			int _type = RULE_KW_UNION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalParser.g:25769:15: ( 'union' )
			// InternalParser.g:25769:17: 'union'
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
			// InternalParser.g:25771:18: ( 'unsigned' )
			// InternalParser.g:25771:20: 'unsigned'
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
			// InternalParser.g:25773:14: ( 'void' )
			// InternalParser.g:25773:16: 'void'
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
			// InternalParser.g:25775:18: ( 'volatile' )
			// InternalParser.g:25775:20: 'volatile'
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
			// InternalParser.g:25777:19: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_VOLATILE RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE )
			// InternalParser.g:25777:21: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_VOLATILE RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE
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
			// InternalParser.g:25779:15: ( 'while' )
			// InternalParser.g:25779:17: 'while'
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
			// InternalParser.g:25781:17: ( RULE_SKW_STAR RULE_SKW_ASSIGN )
			// InternalParser.g:25781:19: RULE_SKW_STAR RULE_SKW_ASSIGN
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
			// InternalParser.g:25783:16: ( RULE_SKW_DIV RULE_SKW_ASSIGN )
			// InternalParser.g:25783:18: RULE_SKW_DIV RULE_SKW_ASSIGN
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
			// InternalParser.g:25785:16: ( RULE_SKW_MOD RULE_SKW_ASSIGN )
			// InternalParser.g:25785:18: RULE_SKW_MOD RULE_SKW_ASSIGN
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
			// InternalParser.g:25787:17: ( RULE_SKW_PLUS RULE_SKW_ASSIGN )
			// InternalParser.g:25787:19: RULE_SKW_PLUS RULE_SKW_ASSIGN
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
			// InternalParser.g:25789:18: ( RULE_SKW_MINUS RULE_SKW_ASSIGN )
			// InternalParser.g:25789:20: RULE_SKW_MINUS RULE_SKW_ASSIGN
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
			// InternalParser.g:25791:22: ( RULE_SKW_LEFTSHIFT RULE_SKW_ASSIGN )
			// InternalParser.g:25791:24: RULE_SKW_LEFTSHIFT RULE_SKW_ASSIGN
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
			// InternalParser.g:25793:23: ( RULE_SKW_RIGHTSHIFT RULE_SKW_ASSIGN )
			// InternalParser.g:25793:25: RULE_SKW_RIGHTSHIFT RULE_SKW_ASSIGN
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
			// InternalParser.g:25795:16: ( RULE_SKW_AND RULE_SKW_ASSIGN )
			// InternalParser.g:25795:18: RULE_SKW_AND RULE_SKW_ASSIGN
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
			// InternalParser.g:25797:16: ( RULE_SKW_CARET RULE_SKW_ASSIGN )
			// InternalParser.g:25797:18: RULE_SKW_CARET RULE_SKW_ASSIGN
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
			// InternalParser.g:25799:15: ( RULE_SKW_OR RULE_SKW_ASSIGN )
			// InternalParser.g:25799:17: RULE_SKW_OR RULE_SKW_ASSIGN
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
			// InternalParser.g:25801:12: ( RULE_SKW_MINUS RULE_SKW_GREATER )
			// InternalParser.g:25801:14: RULE_SKW_MINUS RULE_SKW_GREATER
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
			// InternalParser.g:25803:20: ( '#' (~ ( RULE_NEWLINE ) | RULE_SKW_BACKSLASH RULE_NEWLINE )* )
			// InternalParser.g:25803:22: '#' (~ ( RULE_NEWLINE ) | RULE_SKW_BACKSLASH RULE_NEWLINE )*
			{
			match('#'); 
			// InternalParser.g:25803:26: (~ ( RULE_NEWLINE ) | RULE_SKW_BACKSLASH RULE_NEWLINE )*
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
					// InternalParser.g:25803:27: ~ ( RULE_NEWLINE )
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
					// InternalParser.g:25803:43: RULE_SKW_BACKSLASH RULE_NEWLINE
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
			// InternalParser.g:25805:17: ( ( ' ' | '\\t' )+ )
			// InternalParser.g:25805:19: ( ' ' | '\\t' )+
			{
			// InternalParser.g:25805:19: ( ' ' | '\\t' )+
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
			// InternalParser.g:25807:14: ( '&' )
			// InternalParser.g:25807:16: '&'
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
			// InternalParser.g:25809:17: ( RULE_SKW_AND RULE_SKW_AND )
			// InternalParser.g:25809:19: RULE_SKW_AND RULE_SKW_AND
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
			// InternalParser.g:25811:17: ( '=' )
			// InternalParser.g:25811:19: '='
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
			// InternalParser.g:25813:20: ( '\\\\' )
			// InternalParser.g:25813:22: '\\\\'
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
			// InternalParser.g:25815:16: ( '^' )
			// InternalParser.g:25815:18: '^'
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
			// InternalParser.g:25817:16: ( ',' )
			// InternalParser.g:25817:18: ','
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
			// InternalParser.g:25819:16: ( ':' )
			// InternalParser.g:25819:18: ':'
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
			// InternalParser.g:25821:14: ( '/' )
			// InternalParser.g:25821:16: '/'
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
			// InternalParser.g:25823:26: ( '$' )
			// InternalParser.g:25823:28: '$'
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
			// InternalParser.g:25825:14: ( '.' )
			// InternalParser.g:25825:16: '.'
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
			// InternalParser.g:25827:22: ( '\"' )
			// InternalParser.g:25827:24: '\"'
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
			// InternalParser.g:25829:16: ( RULE_SKW_ASSIGN RULE_SKW_ASSIGN )
			// InternalParser.g:25829:18: RULE_SKW_ASSIGN RULE_SKW_ASSIGN
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
			// InternalParser.g:25831:18: ( '>' )
			// InternalParser.g:25831:20: '>'
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
			// InternalParser.g:25833:23: ( RULE_SKW_GREATER RULE_SKW_ASSIGN )
			// InternalParser.g:25833:25: RULE_SKW_GREATER RULE_SKW_ASSIGN
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
			// InternalParser.g:25835:20: ( '{' )
			// InternalParser.g:25835:22: '{'
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
			// InternalParser.g:25837:22: ( '[' )
			// InternalParser.g:25837:24: '['
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
			// InternalParser.g:25839:20: ( '(' )
			// InternalParser.g:25839:22: '('
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
			// InternalParser.g:25841:20: ( RULE_SKW_LESS RULE_SKW_LESS )
			// InternalParser.g:25841:22: RULE_SKW_LESS RULE_SKW_LESS
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
			// InternalParser.g:25843:15: ( '<' )
			// InternalParser.g:25843:17: '<'
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
			// InternalParser.g:25845:20: ( RULE_SKW_LESS RULE_SKW_ASSIGN )
			// InternalParser.g:25845:22: RULE_SKW_LESS RULE_SKW_ASSIGN
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
			// InternalParser.g:25847:16: ( '-' )
			// InternalParser.g:25847:18: '-'
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
			// InternalParser.g:25849:21: ( RULE_SKW_MINUS RULE_SKW_MINUS )
			// InternalParser.g:25849:23: RULE_SKW_MINUS RULE_SKW_MINUS
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
			// InternalParser.g:25851:14: ( '%' )
			// InternalParser.g:25851:16: '%'
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
			// InternalParser.g:25853:14: ( '!' )
			// InternalParser.g:25853:16: '!'
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
			// InternalParser.g:25855:19: ( RULE_SKW_NOT RULE_SKW_ASSIGN )
			// InternalParser.g:25855:21: RULE_SKW_NOT RULE_SKW_ASSIGN
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
			// InternalParser.g:25857:13: ( '|' )
			// InternalParser.g:25857:15: '|'
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
			// InternalParser.g:25859:15: ( RULE_SKW_OR RULE_SKW_OR )
			// InternalParser.g:25859:17: RULE_SKW_OR RULE_SKW_OR
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
			// InternalParser.g:25861:15: ( '+' )
			// InternalParser.g:25861:17: '+'
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
			// InternalParser.g:25863:19: ( RULE_SKW_PLUS RULE_SKW_PLUS )
			// InternalParser.g:25863:21: RULE_SKW_PLUS RULE_SKW_PLUS
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
			// InternalParser.g:25865:19: ( '?' )
			// InternalParser.g:25865:21: '?'
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
			// InternalParser.g:25867:21: ( '}' )
			// InternalParser.g:25867:23: '}'
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
			// InternalParser.g:25869:23: ( ']' )
			// InternalParser.g:25869:25: ']'
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
			// InternalParser.g:25871:21: ( ')' )
			// InternalParser.g:25871:23: ')'
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
			// InternalParser.g:25873:21: ( RULE_SKW_GREATER RULE_SKW_GREATER )
			// InternalParser.g:25873:23: RULE_SKW_GREATER RULE_SKW_GREATER
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
			// InternalParser.g:25875:15: ( ';' )
			// InternalParser.g:25875:17: ';'
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
			// InternalParser.g:25877:22: ( '\\'' )
			// InternalParser.g:25877:24: '\\''
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
			// InternalParser.g:25879:15: ( '*' )
			// InternalParser.g:25879:17: '*'
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
			// InternalParser.g:25881:16: ( '~' )
			// InternalParser.g:25881:18: '~'
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
			// InternalParser.g:25883:30: ( '_' )
			// InternalParser.g:25883:32: '_'
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
			// InternalParser.g:25885:9: ( RULE_IDENTIFIER )
			// InternalParser.g:25885:11: RULE_IDENTIFIER
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
			// InternalParser.g:25887:26: ( RULE_LETTER ( RULE_LETTER | '0' .. '9' )* )
			// InternalParser.g:25887:28: RULE_LETTER ( RULE_LETTER | '0' .. '9' )*
			{
			mRULE_LETTER(); 

			// InternalParser.g:25887:40: ( RULE_LETTER | '0' .. '9' )*
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
			// InternalParser.g:25889:22: ( ( RULE_SKW_DOLLAR | 'A' .. 'Z' | 'a' .. 'z' | RULE_SKW_UNDERSCORE ) )
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
			// InternalParser.g:25891:19: ( RULE_SKW_SINGLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) ) RULE_SKW_SINGLEQUOTE )
			// InternalParser.g:25891:21: RULE_SKW_SINGLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) ) RULE_SKW_SINGLEQUOTE
			{
			mRULE_SKW_SINGLEQUOTE(); 

			// InternalParser.g:25891:42: ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) )
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
					// InternalParser.g:25891:43: RULE_ESCAPE_SEQUENCE
					{
					mRULE_ESCAPE_SEQUENCE(); 

					}
					break;
				case 2 :
					// InternalParser.g:25891:64: ~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) )
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
			// InternalParser.g:25893:21: ( RULE_SKW_DOUBLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) )* RULE_SKW_DOUBLEQUOTE )
			// InternalParser.g:25893:23: RULE_SKW_DOUBLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) )* RULE_SKW_DOUBLEQUOTE
			{
			mRULE_SKW_DOUBLEQUOTE(); 

			// InternalParser.g:25893:44: ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) )*
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
					// InternalParser.g:25893:45: RULE_ESCAPE_SEQUENCE
					{
					mRULE_ESCAPE_SEQUENCE(); 

					}
					break;
				case 2 :
					// InternalParser.g:25893:66: ~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) )
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
			// InternalParser.g:25895:18: ( '0' ( 'x' | 'X' ) ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )? )
			// InternalParser.g:25895:20: '0' ( 'x' | 'X' ) ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )?
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
			// InternalParser.g:25895:34: ( RULE_HEX_DIGIT )+
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

			// InternalParser.g:25895:50: ( RULE_INTEGER_TYPE_SUFFIX )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0=='L'||LA7_0=='U'||LA7_0=='l'||LA7_0=='u') ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// InternalParser.g:25895:50: RULE_INTEGER_TYPE_SUFFIX
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
			// InternalParser.g:25897:22: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( RULE_INTEGER_TYPE_SUFFIX )? )
			// InternalParser.g:25897:24: ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( RULE_INTEGER_TYPE_SUFFIX )?
			{
			// InternalParser.g:25897:24: ( '0' | '1' .. '9' ( '0' .. '9' )* )
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
					// InternalParser.g:25897:25: '0'
					{
					match('0'); 
					}
					break;
				case 2 :
					// InternalParser.g:25897:29: '1' .. '9' ( '0' .. '9' )*
					{
					matchRange('1','9'); 
					// InternalParser.g:25897:38: ( '0' .. '9' )*
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

			// InternalParser.g:25897:51: ( RULE_INTEGER_TYPE_SUFFIX )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='L'||LA10_0=='U'||LA10_0=='l'||LA10_0=='u') ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// InternalParser.g:25897:51: RULE_INTEGER_TYPE_SUFFIX
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
			// InternalParser.g:25899:20: ( '0' ( '0' .. '7' )+ ( RULE_INTEGER_TYPE_SUFFIX )? )
			// InternalParser.g:25899:22: '0' ( '0' .. '7' )+ ( RULE_INTEGER_TYPE_SUFFIX )?
			{
			match('0'); 
			// InternalParser.g:25899:26: ( '0' .. '7' )+
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

			// InternalParser.g:25899:38: ( RULE_INTEGER_TYPE_SUFFIX )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0=='L'||LA12_0=='U'||LA12_0=='l'||LA12_0=='u') ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// InternalParser.g:25899:38: RULE_INTEGER_TYPE_SUFFIX
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
			// InternalParser.g:25901:18: ( ( '0b' | '0B' ) ( '0' .. '1' )+ )
			// InternalParser.g:25901:20: ( '0b' | '0B' ) ( '0' .. '1' )+
			{
			// InternalParser.g:25901:20: ( '0b' | '0B' )
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
					// InternalParser.g:25901:21: '0b'
					{
					match("0b"); 

					}
					break;
				case 2 :
					// InternalParser.g:25901:26: '0B'
					{
					match("0B"); 

					}
					break;

			}

			// InternalParser.g:25901:32: ( '0' .. '1' )+
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
			// InternalParser.g:25903:25: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
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
			// InternalParser.g:25905:35: ( ( RULE_UNSIGNED_SUFFIX ( RULE_LONG_SUFFIX )? | RULE_UNSIGNED_SUFFIX RULE_LONG_LONG_SUFFIX | RULE_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )? | RULE_LONG_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )? ) )
			// InternalParser.g:25905:37: ( RULE_UNSIGNED_SUFFIX ( RULE_LONG_SUFFIX )? | RULE_UNSIGNED_SUFFIX RULE_LONG_LONG_SUFFIX | RULE_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )? | RULE_LONG_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )? )
			{
			// InternalParser.g:25905:37: ( RULE_UNSIGNED_SUFFIX ( RULE_LONG_SUFFIX )? | RULE_UNSIGNED_SUFFIX RULE_LONG_LONG_SUFFIX | RULE_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )? | RULE_LONG_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )? )
			int alt18=4;
			switch ( input.LA(1) ) {
			case 'U':
			case 'u':
				{
				switch ( input.LA(2) ) {
				case 'l':
					{
					int LA18_5 = input.LA(3);
					if ( (LA18_5=='l') ) {
						alt18=2;
					}

					else {
						alt18=1;
					}

					}
					break;
				case 'L':
					{
					int LA18_6 = input.LA(3);
					if ( (LA18_6=='L') ) {
						alt18=2;
					}

					else {
						alt18=1;
					}

					}
					break;
				default:
					alt18=1;
				}
				}
				break;
			case 'l':
				{
				int LA18_2 = input.LA(2);
				if ( (LA18_2=='l') ) {
					alt18=4;
				}

				else {
					alt18=3;
				}

				}
				break;
			case 'L':
				{
				int LA18_3 = input.LA(2);
				if ( (LA18_3=='L') ) {
					alt18=4;
				}

				else {
					alt18=3;
				}

				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}
			switch (alt18) {
				case 1 :
					// InternalParser.g:25905:38: RULE_UNSIGNED_SUFFIX ( RULE_LONG_SUFFIX )?
					{
					mRULE_UNSIGNED_SUFFIX(); 

					// InternalParser.g:25905:59: ( RULE_LONG_SUFFIX )?
					int alt15=2;
					int LA15_0 = input.LA(1);
					if ( (LA15_0=='L'||LA15_0=='l') ) {
						alt15=1;
					}
					switch (alt15) {
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
				case 2 :
					// InternalParser.g:25905:77: RULE_UNSIGNED_SUFFIX RULE_LONG_LONG_SUFFIX
					{
					mRULE_UNSIGNED_SUFFIX(); 

					mRULE_LONG_LONG_SUFFIX(); 

					}
					break;
				case 3 :
					// InternalParser.g:25905:120: RULE_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )?
					{
					mRULE_LONG_SUFFIX(); 

					// InternalParser.g:25905:137: ( RULE_UNSIGNED_SUFFIX )?
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0=='U'||LA16_0=='u') ) {
						alt16=1;
					}
					switch (alt16) {
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

					}
					break;
				case 4 :
					// InternalParser.g:25905:159: RULE_LONG_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )?
					{
					mRULE_LONG_LONG_SUFFIX(); 

					// InternalParser.g:25905:181: ( RULE_UNSIGNED_SUFFIX )?
					int alt17=2;
					int LA17_0 = input.LA(1);
					if ( (LA17_0=='U'||LA17_0=='u') ) {
						alt17=1;
					}
					switch (alt17) {
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
			// InternalParser.g:25907:31: ( ( 'u' | 'U' ) )
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

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_UNSIGNED_SUFFIX"

	// $ANTLR start "RULE_LONG_SUFFIX"
	public final void mRULE_LONG_SUFFIX() throws RecognitionException {
		try {
			// InternalParser.g:25909:27: ( ( 'l' | 'L' ) )
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

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_LONG_SUFFIX"

	// $ANTLR start "RULE_LONG_LONG_SUFFIX"
	public final void mRULE_LONG_LONG_SUFFIX() throws RecognitionException {
		try {
			// InternalParser.g:25911:32: ( ( 'll' | 'LL' ) )
			// InternalParser.g:25911:34: ( 'll' | 'LL' )
			{
			// InternalParser.g:25911:34: ( 'll' | 'LL' )
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0=='l') ) {
				alt19=1;
			}
			else if ( (LA19_0=='L') ) {
				alt19=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}

			switch (alt19) {
				case 1 :
					// InternalParser.g:25911:35: 'll'
					{
					match("ll"); 

					}
					break;
				case 2 :
					// InternalParser.g:25911:40: 'LL'
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
			// InternalParser.g:25913:20: ( ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX ) )
			// InternalParser.g:25913:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )
			{
			// InternalParser.g:25913:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )
			int alt31=4;
			alt31 = dfa31.predict(input);
			switch (alt31) {
				case 1 :
					// InternalParser.g:25913:23: ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )?
					{
					// InternalParser.g:25913:23: ( '0' .. '9' )+
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

					mRULE_SKW_DOT(); 

					// InternalParser.g:25913:48: ( '0' .. '9' )*
					loop21:
					while (true) {
						int alt21=2;
						int LA21_0 = input.LA(1);
						if ( ((LA21_0 >= '0' && LA21_0 <= '9')) ) {
							alt21=1;
						}

						switch (alt21) {
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
							break loop21;
						}
					}

					// InternalParser.g:25913:60: ( RULE_EXPONENT )?
					int alt22=2;
					int LA22_0 = input.LA(1);
					if ( (LA22_0=='E'||LA22_0=='e') ) {
						alt22=1;
					}
					switch (alt22) {
						case 1 :
							// InternalParser.g:25913:60: RULE_EXPONENT
							{
							mRULE_EXPONENT(); 

							}
							break;

					}

					// InternalParser.g:25913:75: ( RULE_FLOAT_TYPE_SUFFIX )?
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0=='D'||LA23_0=='F'||LA23_0=='d'||LA23_0=='f') ) {
						alt23=1;
					}
					switch (alt23) {
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
					// InternalParser.g:25913:99: RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )?
					{
					mRULE_SKW_DOT(); 

					// InternalParser.g:25913:112: ( '0' .. '9' )+
					int cnt24=0;
					loop24:
					while (true) {
						int alt24=2;
						int LA24_0 = input.LA(1);
						if ( ((LA24_0 >= '0' && LA24_0 <= '9')) ) {
							alt24=1;
						}

						switch (alt24) {
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
							if ( cnt24 >= 1 ) break loop24;
							EarlyExitException eee = new EarlyExitException(24, input);
							throw eee;
						}
						cnt24++;
					}

					// InternalParser.g:25913:124: ( RULE_EXPONENT )?
					int alt25=2;
					int LA25_0 = input.LA(1);
					if ( (LA25_0=='E'||LA25_0=='e') ) {
						alt25=1;
					}
					switch (alt25) {
						case 1 :
							// InternalParser.g:25913:124: RULE_EXPONENT
							{
							mRULE_EXPONENT(); 

							}
							break;

					}

					// InternalParser.g:25913:139: ( RULE_FLOAT_TYPE_SUFFIX )?
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
				case 3 :
					// InternalParser.g:25913:163: ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )?
					{
					// InternalParser.g:25913:163: ( '0' .. '9' )+
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

					mRULE_EXPONENT(); 

					// InternalParser.g:25913:189: ( RULE_FLOAT_TYPE_SUFFIX )?
					int alt28=2;
					int LA28_0 = input.LA(1);
					if ( (LA28_0=='D'||LA28_0=='F'||LA28_0=='d'||LA28_0=='f') ) {
						alt28=1;
					}
					switch (alt28) {
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
					// InternalParser.g:25913:213: ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX
					{
					// InternalParser.g:25913:213: ( '0' .. '9' )+
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

					// InternalParser.g:25913:225: ( RULE_EXPONENT )?
					int alt30=2;
					int LA30_0 = input.LA(1);
					if ( (LA30_0=='E'||LA30_0=='e') ) {
						alt30=1;
					}
					switch (alt30) {
						case 1 :
							// InternalParser.g:25913:225: RULE_EXPONENT
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
			// InternalParser.g:25915:24: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
			// InternalParser.g:25915:26: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// InternalParser.g:25915:36: ( '+' | '-' )?
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0=='+'||LA32_0=='-') ) {
				alt32=1;
			}
			switch (alt32) {
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

			// InternalParser.g:25915:47: ( '0' .. '9' )+
			int cnt33=0;
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( ((LA33_0 >= '0' && LA33_0 <= '9')) ) {
					alt33=1;
				}

				switch (alt33) {
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
					if ( cnt33 >= 1 ) break loop33;
					EarlyExitException eee = new EarlyExitException(33, input);
					throw eee;
				}
				cnt33++;
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
			// InternalParser.g:25917:33: ( ( 'f' | 'F' | 'd' | 'D' ) )
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
			// InternalParser.g:25919:31: ( ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE | RULE_HEX_ESCAPE ) )
			// InternalParser.g:25919:33: ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE | RULE_HEX_ESCAPE )
			{
			// InternalParser.g:25919:33: ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE | RULE_HEX_ESCAPE )
			int alt34=3;
			int LA34_0 = input.LA(1);
			if ( (LA34_0=='\\') ) {
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
					alt34=1;
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
					alt34=2;
					}
					break;
				case 'x':
					{
					alt34=3;
					}
					break;
				default:
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
					// InternalParser.g:25919:34: RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH )
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
					// InternalParser.g:25919:119: RULE_OCTAL_ESCAPE
					{
					mRULE_OCTAL_ESCAPE(); 

					}
					break;
				case 3 :
					// InternalParser.g:25919:137: RULE_HEX_ESCAPE
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
			// InternalParser.g:25921:28: ( ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' ) )
			// InternalParser.g:25921:30: ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' )
			{
			// InternalParser.g:25921:30: ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' )
			int alt35=3;
			int LA35_0 = input.LA(1);
			if ( (LA35_0=='\\') ) {
				int LA35_1 = input.LA(2);
				if ( ((LA35_1 >= '0' && LA35_1 <= '3')) ) {
					int LA35_2 = input.LA(3);
					if ( ((LA35_2 >= '0' && LA35_2 <= '7')) ) {
						int LA35_4 = input.LA(4);
						if ( ((LA35_4 >= '0' && LA35_4 <= '7')) ) {
							alt35=1;
						}

						else {
							alt35=2;
						}

					}

					else {
						alt35=3;
					}

				}
				else if ( ((LA35_1 >= '4' && LA35_1 <= '7')) ) {
					int LA35_3 = input.LA(3);
					if ( ((LA35_3 >= '0' && LA35_3 <= '7')) ) {
						alt35=2;
					}

					else {
						alt35=3;
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 35, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 35, 0, input);
				throw nvae;
			}

			switch (alt35) {
				case 1 :
					// InternalParser.g:25921:31: RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7'
					{
					mRULE_SKW_BACKSLASH(); 

					matchRange('0','3'); 
					matchRange('0','7'); 
					matchRange('0','7'); 
					}
					break;
				case 2 :
					// InternalParser.g:25921:77: RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7'
					{
					mRULE_SKW_BACKSLASH(); 

					matchRange('0','7'); 
					matchRange('0','7'); 
					}
					break;
				case 3 :
					// InternalParser.g:25921:114: RULE_SKW_BACKSLASH '0' .. '7'
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
			// InternalParser.g:25923:26: ( RULE_SKW_BACKSLASH 'x' ( RULE_HEX_DIGIT )+ )
			// InternalParser.g:25923:28: RULE_SKW_BACKSLASH 'x' ( RULE_HEX_DIGIT )+
			{
			mRULE_SKW_BACKSLASH(); 

			match('x'); 
			// InternalParser.g:25923:51: ( RULE_HEX_DIGIT )+
			int cnt36=0;
			loop36:
			while (true) {
				int alt36=2;
				int LA36_0 = input.LA(1);
				if ( ((LA36_0 >= '0' && LA36_0 <= '9')||(LA36_0 >= 'A' && LA36_0 <= 'F')||(LA36_0 >= 'a' && LA36_0 <= 'f')) ) {
					alt36=1;
				}

				switch (alt36) {
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
					if ( cnt36 >= 1 ) break loop36;
					EarlyExitException eee = new EarlyExitException(36, input);
					throw eee;
				}
				cnt36++;
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
			// InternalParser.g:25925:24: ( '\\n' )
			// InternalParser.g:25925:26: '\\n'
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
			// InternalParser.g:25927:30: ( '\\r' )
			// InternalParser.g:25927:32: '\\r'
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
			// InternalParser.g:25929:24: ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) )
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
			// InternalParser.g:25931:16: ( RULE_SKW_BACKSLASH RULE_LINE_END )
			// InternalParser.g:25931:18: RULE_SKW_BACKSLASH RULE_LINE_END
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
			// InternalParser.g:25933:14: ( RULE_LINE_END )
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
			// InternalParser.g:25935:21: ( ' ' )
			// InternalParser.g:25935:23: ' '
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
			// InternalParser.g:25937:19: ( '\\t' )
			// InternalParser.g:25937:21: '\\t'
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
			// InternalParser.g:25939:20: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// InternalParser.g:25939:22: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// InternalParser.g:25939:27: ( options {greedy=false; } : . )*
			loop37:
			while (true) {
				int alt37=2;
				int LA37_0 = input.LA(1);
				if ( (LA37_0=='*') ) {
					int LA37_1 = input.LA(2);
					if ( (LA37_1=='/') ) {
						alt37=2;
					}
					else if ( ((LA37_1 >= '\u0000' && LA37_1 <= '.')||(LA37_1 >= '0' && LA37_1 <= '\uFFFF')) ) {
						alt37=1;
					}

				}
				else if ( ((LA37_0 >= '\u0000' && LA37_0 <= ')')||(LA37_0 >= '+' && LA37_0 <= '\uFFFF')) ) {
					alt37=1;
				}

				switch (alt37) {
				case 1 :
					// InternalParser.g:25939:55: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop37;
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
			// InternalParser.g:25941:19: ( '//' (~ ( RULE_LINE_END ) )* )
			// InternalParser.g:25941:21: '//' (~ ( RULE_LINE_END ) )*
			{
			match("//"); 

			// InternalParser.g:25941:26: (~ ( RULE_LINE_END ) )*
			loop38:
			while (true) {
				int alt38=2;
				int LA38_0 = input.LA(1);
				if ( ((LA38_0 >= '\u0000' && LA38_0 <= '\t')||(LA38_0 >= '\u000B' && LA38_0 <= '\f')||(LA38_0 >= '\u000E' && LA38_0 <= '\uFFFF')) ) {
					alt38=1;
				}

				switch (alt38) {
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
					break loop38;
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
			// InternalParser.g:25943:14: ( . )
			// InternalParser.g:25943:16: .
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
		// InternalParser.g:1:8: ( RULE_KW_ATOMIC | RULE_KW_ATTRIBUTE | RULE_KW_AUTO | RULE_KW_ALIGNAS | RULE_KW_ALIGNOF1 | RULE_KW_ALIGNOF2 | RULE_KW_ALIGNOF3 | RULE_KW_ASM1 | RULE_KW_ASM2 | RULE_KW_ASM3 | RULE_KW_BOOL | RULE_KW_BREAK | RULE_KW_BUILTIN_VA_LIST | RULE_KW_BUILTIN_OFFSETOF | RULE_KW_CASE | RULE_KW_CHAR | RULE_KW_COMPLEX | RULE_KW_CONST | RULE_KW_CONTINUE | RULE_KW_DEFAULT | RULE_KW_DO | RULE_KW_DOUBLE | RULE_KW_ELSE | RULE_KW_EXTENSION | RULE_KW_ENUM | RULE_KW_EXTERN | RULE_KW_FLOAT | RULE_KW_FOR | RULE_KW_GENERIC | RULE_KW_GOTO | RULE_KW_IF | RULE_KW_IMAGINARY | RULE_KW_INLINE1 | RULE_KW_INLINE2 | RULE_KW_INLINE3 | RULE_KW_INT | RULE_KW_LONG | RULE_KW_M128 | RULE_KW_M128D | RULE_KW_M128I | RULE_KW_NORETURN | RULE_KW_PRAGMA | RULE_KW_REGISTER | RULE_KW_RESTRICT | RULE_KW_RESTRICT2 | RULE_KW_RESTRICT3 | RULE_KW_RETURN | RULE_KW_SHORT | RULE_KW_SIGNED1 | RULE_KW_SIGNED2 | RULE_KW_SIGNED3 | RULE_KW_SIZEOF | RULE_KW_STATIC | RULE_KW_STATICASSERT | RULE_KW_STRUCT | RULE_KW_SWITCH | RULE_KW_THREADLOCAL | RULE_KW_TYPEDEF | RULE_KW_TYPEOF1 | RULE_KW_TYPEOF3 | RULE_KW_UNION | RULE_KW_UNSIGNED | RULE_KW_VOID | RULE_KW_VOLATILE | RULE_KW_VOLATILE2 | RULE_KW_WHILE | RULE_STARASSIGN | RULE_DIVASSIGN | RULE_MODASSIGN | RULE_PLUSASSIGN | RULE_MINUSASSIGN | RULE_LEFTSHIFTASSIGN | RULE_RIGHTSHIFTASSIGN | RULE_ANDASSIGN | RULE_XORASSIGN | RULE_ORASSIGN | RULE_ARROW | RULE_LINEDIRECTIVE | RULE_WHITESPACE | RULE_SKW_AND | RULE_SKW_ANDAND | RULE_SKW_ASSIGN | RULE_SKW_BACKSLASH | RULE_SKW_CARET | RULE_SKW_COMMA | RULE_SKW_COLON | RULE_SKW_DIV | RULE_SKW_DOT | RULE_SKW_DOUBLEQUOTE | RULE_SKW_EQUAL | RULE_SKW_GREATER | RULE_SKW_GREATEREQUAL | RULE_SKW_LEFTBRACE | RULE_SKW_LEFTBRACKET | RULE_SKW_LEFTPAREN | RULE_SKW_LEFTSHIFT | RULE_SKW_LESS | RULE_SKW_LESSEQUAL | RULE_SKW_MINUS | RULE_SKW_MINUSMINUS | RULE_SKW_MOD | RULE_SKW_NOT | RULE_SKW_NOTEQUAL | RULE_SKW_OR | RULE_SKW_OROR | RULE_SKW_PLUS | RULE_SKW_PLUSPLUS | RULE_SKW_QUESTION | RULE_SKW_RIGHTBRACE | RULE_SKW_RIGHTBRACKET | RULE_SKW_RIGHTPAREN | RULE_SKW_RIGHTSHIFT | RULE_SKW_SEMI | RULE_SKW_SINGLEQUOTE | RULE_SKW_STAR | RULE_SKW_TILDE | RULE_ID | RULE_CHAR_LITERAL | RULE_STRING_LITERAL | RULE_HEX_LITERAL | RULE_DECIMAL_LITERAL | RULE_OCTAL_LITERAL | RULE_BIN_LITERAL | RULE_FLOAT_LITERAL | RULE_LINEBREAK | RULE_NEWLINE | RULE_BLOCK_COMMENT | RULE_LINE_COMMENT | RULE_SPECIAL )
		int alt39=129;
		alt39 = dfa39.predict(input);
		switch (alt39) {
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
				// InternalParser.g:1:72: RULE_KW_ALIGNOF1
				{
				mRULE_KW_ALIGNOF1(); 

				}
				break;
			case 6 :
				// InternalParser.g:1:89: RULE_KW_ALIGNOF2
				{
				mRULE_KW_ALIGNOF2(); 

				}
				break;
			case 7 :
				// InternalParser.g:1:106: RULE_KW_ALIGNOF3
				{
				mRULE_KW_ALIGNOF3(); 

				}
				break;
			case 8 :
				// InternalParser.g:1:123: RULE_KW_ASM1
				{
				mRULE_KW_ASM1(); 

				}
				break;
			case 9 :
				// InternalParser.g:1:136: RULE_KW_ASM2
				{
				mRULE_KW_ASM2(); 

				}
				break;
			case 10 :
				// InternalParser.g:1:149: RULE_KW_ASM3
				{
				mRULE_KW_ASM3(); 

				}
				break;
			case 11 :
				// InternalParser.g:1:162: RULE_KW_BOOL
				{
				mRULE_KW_BOOL(); 

				}
				break;
			case 12 :
				// InternalParser.g:1:175: RULE_KW_BREAK
				{
				mRULE_KW_BREAK(); 

				}
				break;
			case 13 :
				// InternalParser.g:1:189: RULE_KW_BUILTIN_VA_LIST
				{
				mRULE_KW_BUILTIN_VA_LIST(); 

				}
				break;
			case 14 :
				// InternalParser.g:1:213: RULE_KW_BUILTIN_OFFSETOF
				{
				mRULE_KW_BUILTIN_OFFSETOF(); 

				}
				break;
			case 15 :
				// InternalParser.g:1:238: RULE_KW_CASE
				{
				mRULE_KW_CASE(); 

				}
				break;
			case 16 :
				// InternalParser.g:1:251: RULE_KW_CHAR
				{
				mRULE_KW_CHAR(); 

				}
				break;
			case 17 :
				// InternalParser.g:1:264: RULE_KW_COMPLEX
				{
				mRULE_KW_COMPLEX(); 

				}
				break;
			case 18 :
				// InternalParser.g:1:280: RULE_KW_CONST
				{
				mRULE_KW_CONST(); 

				}
				break;
			case 19 :
				// InternalParser.g:1:294: RULE_KW_CONTINUE
				{
				mRULE_KW_CONTINUE(); 

				}
				break;
			case 20 :
				// InternalParser.g:1:311: RULE_KW_DEFAULT
				{
				mRULE_KW_DEFAULT(); 

				}
				break;
			case 21 :
				// InternalParser.g:1:327: RULE_KW_DO
				{
				mRULE_KW_DO(); 

				}
				break;
			case 22 :
				// InternalParser.g:1:338: RULE_KW_DOUBLE
				{
				mRULE_KW_DOUBLE(); 

				}
				break;
			case 23 :
				// InternalParser.g:1:353: RULE_KW_ELSE
				{
				mRULE_KW_ELSE(); 

				}
				break;
			case 24 :
				// InternalParser.g:1:366: RULE_KW_EXTENSION
				{
				mRULE_KW_EXTENSION(); 

				}
				break;
			case 25 :
				// InternalParser.g:1:384: RULE_KW_ENUM
				{
				mRULE_KW_ENUM(); 

				}
				break;
			case 26 :
				// InternalParser.g:1:397: RULE_KW_EXTERN
				{
				mRULE_KW_EXTERN(); 

				}
				break;
			case 27 :
				// InternalParser.g:1:412: RULE_KW_FLOAT
				{
				mRULE_KW_FLOAT(); 

				}
				break;
			case 28 :
				// InternalParser.g:1:426: RULE_KW_FOR
				{
				mRULE_KW_FOR(); 

				}
				break;
			case 29 :
				// InternalParser.g:1:438: RULE_KW_GENERIC
				{
				mRULE_KW_GENERIC(); 

				}
				break;
			case 30 :
				// InternalParser.g:1:454: RULE_KW_GOTO
				{
				mRULE_KW_GOTO(); 

				}
				break;
			case 31 :
				// InternalParser.g:1:467: RULE_KW_IF
				{
				mRULE_KW_IF(); 

				}
				break;
			case 32 :
				// InternalParser.g:1:478: RULE_KW_IMAGINARY
				{
				mRULE_KW_IMAGINARY(); 

				}
				break;
			case 33 :
				// InternalParser.g:1:496: RULE_KW_INLINE1
				{
				mRULE_KW_INLINE1(); 

				}
				break;
			case 34 :
				// InternalParser.g:1:512: RULE_KW_INLINE2
				{
				mRULE_KW_INLINE2(); 

				}
				break;
			case 35 :
				// InternalParser.g:1:528: RULE_KW_INLINE3
				{
				mRULE_KW_INLINE3(); 

				}
				break;
			case 36 :
				// InternalParser.g:1:544: RULE_KW_INT
				{
				mRULE_KW_INT(); 

				}
				break;
			case 37 :
				// InternalParser.g:1:556: RULE_KW_LONG
				{
				mRULE_KW_LONG(); 

				}
				break;
			case 38 :
				// InternalParser.g:1:569: RULE_KW_M128
				{
				mRULE_KW_M128(); 

				}
				break;
			case 39 :
				// InternalParser.g:1:582: RULE_KW_M128D
				{
				mRULE_KW_M128D(); 

				}
				break;
			case 40 :
				// InternalParser.g:1:596: RULE_KW_M128I
				{
				mRULE_KW_M128I(); 

				}
				break;
			case 41 :
				// InternalParser.g:1:610: RULE_KW_NORETURN
				{
				mRULE_KW_NORETURN(); 

				}
				break;
			case 42 :
				// InternalParser.g:1:627: RULE_KW_PRAGMA
				{
				mRULE_KW_PRAGMA(); 

				}
				break;
			case 43 :
				// InternalParser.g:1:642: RULE_KW_REGISTER
				{
				mRULE_KW_REGISTER(); 

				}
				break;
			case 44 :
				// InternalParser.g:1:659: RULE_KW_RESTRICT
				{
				mRULE_KW_RESTRICT(); 

				}
				break;
			case 45 :
				// InternalParser.g:1:676: RULE_KW_RESTRICT2
				{
				mRULE_KW_RESTRICT2(); 

				}
				break;
			case 46 :
				// InternalParser.g:1:694: RULE_KW_RESTRICT3
				{
				mRULE_KW_RESTRICT3(); 

				}
				break;
			case 47 :
				// InternalParser.g:1:712: RULE_KW_RETURN
				{
				mRULE_KW_RETURN(); 

				}
				break;
			case 48 :
				// InternalParser.g:1:727: RULE_KW_SHORT
				{
				mRULE_KW_SHORT(); 

				}
				break;
			case 49 :
				// InternalParser.g:1:741: RULE_KW_SIGNED1
				{
				mRULE_KW_SIGNED1(); 

				}
				break;
			case 50 :
				// InternalParser.g:1:757: RULE_KW_SIGNED2
				{
				mRULE_KW_SIGNED2(); 

				}
				break;
			case 51 :
				// InternalParser.g:1:773: RULE_KW_SIGNED3
				{
				mRULE_KW_SIGNED3(); 

				}
				break;
			case 52 :
				// InternalParser.g:1:789: RULE_KW_SIZEOF
				{
				mRULE_KW_SIZEOF(); 

				}
				break;
			case 53 :
				// InternalParser.g:1:804: RULE_KW_STATIC
				{
				mRULE_KW_STATIC(); 

				}
				break;
			case 54 :
				// InternalParser.g:1:819: RULE_KW_STATICASSERT
				{
				mRULE_KW_STATICASSERT(); 

				}
				break;
			case 55 :
				// InternalParser.g:1:840: RULE_KW_STRUCT
				{
				mRULE_KW_STRUCT(); 

				}
				break;
			case 56 :
				// InternalParser.g:1:855: RULE_KW_SWITCH
				{
				mRULE_KW_SWITCH(); 

				}
				break;
			case 57 :
				// InternalParser.g:1:870: RULE_KW_THREADLOCAL
				{
				mRULE_KW_THREADLOCAL(); 

				}
				break;
			case 58 :
				// InternalParser.g:1:890: RULE_KW_TYPEDEF
				{
				mRULE_KW_TYPEDEF(); 

				}
				break;
			case 59 :
				// InternalParser.g:1:906: RULE_KW_TYPEOF1
				{
				mRULE_KW_TYPEOF1(); 

				}
				break;
			case 60 :
				// InternalParser.g:1:922: RULE_KW_TYPEOF3
				{
				mRULE_KW_TYPEOF3(); 

				}
				break;
			case 61 :
				// InternalParser.g:1:938: RULE_KW_UNION
				{
				mRULE_KW_UNION(); 

				}
				break;
			case 62 :
				// InternalParser.g:1:952: RULE_KW_UNSIGNED
				{
				mRULE_KW_UNSIGNED(); 

				}
				break;
			case 63 :
				// InternalParser.g:1:969: RULE_KW_VOID
				{
				mRULE_KW_VOID(); 

				}
				break;
			case 64 :
				// InternalParser.g:1:982: RULE_KW_VOLATILE
				{
				mRULE_KW_VOLATILE(); 

				}
				break;
			case 65 :
				// InternalParser.g:1:999: RULE_KW_VOLATILE2
				{
				mRULE_KW_VOLATILE2(); 

				}
				break;
			case 66 :
				// InternalParser.g:1:1017: RULE_KW_WHILE
				{
				mRULE_KW_WHILE(); 

				}
				break;
			case 67 :
				// InternalParser.g:1:1031: RULE_STARASSIGN
				{
				mRULE_STARASSIGN(); 

				}
				break;
			case 68 :
				// InternalParser.g:1:1047: RULE_DIVASSIGN
				{
				mRULE_DIVASSIGN(); 

				}
				break;
			case 69 :
				// InternalParser.g:1:1062: RULE_MODASSIGN
				{
				mRULE_MODASSIGN(); 

				}
				break;
			case 70 :
				// InternalParser.g:1:1077: RULE_PLUSASSIGN
				{
				mRULE_PLUSASSIGN(); 

				}
				break;
			case 71 :
				// InternalParser.g:1:1093: RULE_MINUSASSIGN
				{
				mRULE_MINUSASSIGN(); 

				}
				break;
			case 72 :
				// InternalParser.g:1:1110: RULE_LEFTSHIFTASSIGN
				{
				mRULE_LEFTSHIFTASSIGN(); 

				}
				break;
			case 73 :
				// InternalParser.g:1:1131: RULE_RIGHTSHIFTASSIGN
				{
				mRULE_RIGHTSHIFTASSIGN(); 

				}
				break;
			case 74 :
				// InternalParser.g:1:1153: RULE_ANDASSIGN
				{
				mRULE_ANDASSIGN(); 

				}
				break;
			case 75 :
				// InternalParser.g:1:1168: RULE_XORASSIGN
				{
				mRULE_XORASSIGN(); 

				}
				break;
			case 76 :
				// InternalParser.g:1:1183: RULE_ORASSIGN
				{
				mRULE_ORASSIGN(); 

				}
				break;
			case 77 :
				// InternalParser.g:1:1197: RULE_ARROW
				{
				mRULE_ARROW(); 

				}
				break;
			case 78 :
				// InternalParser.g:1:1208: RULE_LINEDIRECTIVE
				{
				mRULE_LINEDIRECTIVE(); 

				}
				break;
			case 79 :
				// InternalParser.g:1:1227: RULE_WHITESPACE
				{
				mRULE_WHITESPACE(); 

				}
				break;
			case 80 :
				// InternalParser.g:1:1243: RULE_SKW_AND
				{
				mRULE_SKW_AND(); 

				}
				break;
			case 81 :
				// InternalParser.g:1:1256: RULE_SKW_ANDAND
				{
				mRULE_SKW_ANDAND(); 

				}
				break;
			case 82 :
				// InternalParser.g:1:1272: RULE_SKW_ASSIGN
				{
				mRULE_SKW_ASSIGN(); 

				}
				break;
			case 83 :
				// InternalParser.g:1:1288: RULE_SKW_BACKSLASH
				{
				mRULE_SKW_BACKSLASH(); 

				}
				break;
			case 84 :
				// InternalParser.g:1:1307: RULE_SKW_CARET
				{
				mRULE_SKW_CARET(); 

				}
				break;
			case 85 :
				// InternalParser.g:1:1322: RULE_SKW_COMMA
				{
				mRULE_SKW_COMMA(); 

				}
				break;
			case 86 :
				// InternalParser.g:1:1337: RULE_SKW_COLON
				{
				mRULE_SKW_COLON(); 

				}
				break;
			case 87 :
				// InternalParser.g:1:1352: RULE_SKW_DIV
				{
				mRULE_SKW_DIV(); 

				}
				break;
			case 88 :
				// InternalParser.g:1:1365: RULE_SKW_DOT
				{
				mRULE_SKW_DOT(); 

				}
				break;
			case 89 :
				// InternalParser.g:1:1378: RULE_SKW_DOUBLEQUOTE
				{
				mRULE_SKW_DOUBLEQUOTE(); 

				}
				break;
			case 90 :
				// InternalParser.g:1:1399: RULE_SKW_EQUAL
				{
				mRULE_SKW_EQUAL(); 

				}
				break;
			case 91 :
				// InternalParser.g:1:1414: RULE_SKW_GREATER
				{
				mRULE_SKW_GREATER(); 

				}
				break;
			case 92 :
				// InternalParser.g:1:1431: RULE_SKW_GREATEREQUAL
				{
				mRULE_SKW_GREATEREQUAL(); 

				}
				break;
			case 93 :
				// InternalParser.g:1:1453: RULE_SKW_LEFTBRACE
				{
				mRULE_SKW_LEFTBRACE(); 

				}
				break;
			case 94 :
				// InternalParser.g:1:1472: RULE_SKW_LEFTBRACKET
				{
				mRULE_SKW_LEFTBRACKET(); 

				}
				break;
			case 95 :
				// InternalParser.g:1:1493: RULE_SKW_LEFTPAREN
				{
				mRULE_SKW_LEFTPAREN(); 

				}
				break;
			case 96 :
				// InternalParser.g:1:1512: RULE_SKW_LEFTSHIFT
				{
				mRULE_SKW_LEFTSHIFT(); 

				}
				break;
			case 97 :
				// InternalParser.g:1:1531: RULE_SKW_LESS
				{
				mRULE_SKW_LESS(); 

				}
				break;
			case 98 :
				// InternalParser.g:1:1545: RULE_SKW_LESSEQUAL
				{
				mRULE_SKW_LESSEQUAL(); 

				}
				break;
			case 99 :
				// InternalParser.g:1:1564: RULE_SKW_MINUS
				{
				mRULE_SKW_MINUS(); 

				}
				break;
			case 100 :
				// InternalParser.g:1:1579: RULE_SKW_MINUSMINUS
				{
				mRULE_SKW_MINUSMINUS(); 

				}
				break;
			case 101 :
				// InternalParser.g:1:1599: RULE_SKW_MOD
				{
				mRULE_SKW_MOD(); 

				}
				break;
			case 102 :
				// InternalParser.g:1:1612: RULE_SKW_NOT
				{
				mRULE_SKW_NOT(); 

				}
				break;
			case 103 :
				// InternalParser.g:1:1625: RULE_SKW_NOTEQUAL
				{
				mRULE_SKW_NOTEQUAL(); 

				}
				break;
			case 104 :
				// InternalParser.g:1:1643: RULE_SKW_OR
				{
				mRULE_SKW_OR(); 

				}
				break;
			case 105 :
				// InternalParser.g:1:1655: RULE_SKW_OROR
				{
				mRULE_SKW_OROR(); 

				}
				break;
			case 106 :
				// InternalParser.g:1:1669: RULE_SKW_PLUS
				{
				mRULE_SKW_PLUS(); 

				}
				break;
			case 107 :
				// InternalParser.g:1:1683: RULE_SKW_PLUSPLUS
				{
				mRULE_SKW_PLUSPLUS(); 

				}
				break;
			case 108 :
				// InternalParser.g:1:1701: RULE_SKW_QUESTION
				{
				mRULE_SKW_QUESTION(); 

				}
				break;
			case 109 :
				// InternalParser.g:1:1719: RULE_SKW_RIGHTBRACE
				{
				mRULE_SKW_RIGHTBRACE(); 

				}
				break;
			case 110 :
				// InternalParser.g:1:1739: RULE_SKW_RIGHTBRACKET
				{
				mRULE_SKW_RIGHTBRACKET(); 

				}
				break;
			case 111 :
				// InternalParser.g:1:1761: RULE_SKW_RIGHTPAREN
				{
				mRULE_SKW_RIGHTPAREN(); 

				}
				break;
			case 112 :
				// InternalParser.g:1:1781: RULE_SKW_RIGHTSHIFT
				{
				mRULE_SKW_RIGHTSHIFT(); 

				}
				break;
			case 113 :
				// InternalParser.g:1:1801: RULE_SKW_SEMI
				{
				mRULE_SKW_SEMI(); 

				}
				break;
			case 114 :
				// InternalParser.g:1:1815: RULE_SKW_SINGLEQUOTE
				{
				mRULE_SKW_SINGLEQUOTE(); 

				}
				break;
			case 115 :
				// InternalParser.g:1:1836: RULE_SKW_STAR
				{
				mRULE_SKW_STAR(); 

				}
				break;
			case 116 :
				// InternalParser.g:1:1850: RULE_SKW_TILDE
				{
				mRULE_SKW_TILDE(); 

				}
				break;
			case 117 :
				// InternalParser.g:1:1865: RULE_ID
				{
				mRULE_ID(); 

				}
				break;
			case 118 :
				// InternalParser.g:1:1873: RULE_CHAR_LITERAL
				{
				mRULE_CHAR_LITERAL(); 

				}
				break;
			case 119 :
				// InternalParser.g:1:1891: RULE_STRING_LITERAL
				{
				mRULE_STRING_LITERAL(); 

				}
				break;
			case 120 :
				// InternalParser.g:1:1911: RULE_HEX_LITERAL
				{
				mRULE_HEX_LITERAL(); 

				}
				break;
			case 121 :
				// InternalParser.g:1:1928: RULE_DECIMAL_LITERAL
				{
				mRULE_DECIMAL_LITERAL(); 

				}
				break;
			case 122 :
				// InternalParser.g:1:1949: RULE_OCTAL_LITERAL
				{
				mRULE_OCTAL_LITERAL(); 

				}
				break;
			case 123 :
				// InternalParser.g:1:1968: RULE_BIN_LITERAL
				{
				mRULE_BIN_LITERAL(); 

				}
				break;
			case 124 :
				// InternalParser.g:1:1985: RULE_FLOAT_LITERAL
				{
				mRULE_FLOAT_LITERAL(); 

				}
				break;
			case 125 :
				// InternalParser.g:1:2004: RULE_LINEBREAK
				{
				mRULE_LINEBREAK(); 

				}
				break;
			case 126 :
				// InternalParser.g:1:2019: RULE_NEWLINE
				{
				mRULE_NEWLINE(); 

				}
				break;
			case 127 :
				// InternalParser.g:1:2032: RULE_BLOCK_COMMENT
				{
				mRULE_BLOCK_COMMENT(); 

				}
				break;
			case 128 :
				// InternalParser.g:1:2051: RULE_LINE_COMMENT
				{
				mRULE_LINE_COMMENT(); 

				}
				break;
			case 129 :
				// InternalParser.g:1:2069: RULE_SPECIAL
				{
				mRULE_SPECIAL(); 

				}
				break;

		}
	}


	protected DFA31 dfa31 = new DFA31(this);
	protected DFA39 dfa39 = new DFA39(this);
	static final String DFA31_eotS =
		"\7\uffff\1\10\2\uffff";
	static final String DFA31_eofS =
		"\12\uffff";
	static final String DFA31_minS =
		"\2\56\2\uffff\1\53\1\uffff\2\60\2\uffff";
	static final String DFA31_maxS =
		"\1\71\1\146\2\uffff\1\71\1\uffff\1\71\1\146\2\uffff";
	static final String DFA31_acceptS =
		"\2\uffff\1\2\1\1\1\uffff\1\4\2\uffff\2\3";
	static final String DFA31_specialS =
		"\12\uffff}>";
	static final String[] DFA31_transitionS = {
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

	static final short[] DFA31_eot = DFA.unpackEncodedString(DFA31_eotS);
	static final short[] DFA31_eof = DFA.unpackEncodedString(DFA31_eofS);
	static final char[] DFA31_min = DFA.unpackEncodedStringToUnsignedChars(DFA31_minS);
	static final char[] DFA31_max = DFA.unpackEncodedStringToUnsignedChars(DFA31_maxS);
	static final short[] DFA31_accept = DFA.unpackEncodedString(DFA31_acceptS);
	static final short[] DFA31_special = DFA.unpackEncodedString(DFA31_specialS);
	static final short[][] DFA31_transition;

	static {
		int numStates = DFA31_transitionS.length;
		DFA31_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA31_transition[i] = DFA.unpackEncodedString(DFA31_transitionS[i]);
		}
	}

	protected class DFA31 extends DFA {

		public DFA31(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 31;
			this.eot = DFA31_eot;
			this.eof = DFA31_eof;
			this.min = DFA31_min;
			this.max = DFA31_max;
			this.accept = DFA31_accept;
			this.special = DFA31_special;
			this.transition = DFA31_transition;
		}
		@Override
		public String getDescription() {
			return "25913:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )";
		}
	}


	static final String DFA39_eotS =
		"\1\uffff\21\64\1\132\1\136\1\140\1\142\1\145\1\151\1\154\1\157\1\162\1\164\2\uffff\1\171\1\173\2\uffff\1\177\1\u0081\3\uffff\1\u0086\5\uffff\1\u008d\2\uffff\2\u0092\3\uffff\21\64\1\u00b1\6\64\1\u00b8\14\64\20\uffff\1\u00cc\2\uffff\1\u00ce\45\uffff\1\u00d0\1\u0092\1\uffff\24\64\1\u00e7\6\64\1\uffff\4\64\1\u00f3\1\64\1\uffff\1\64\1\u00f6\21\64\5\uffff\24\64\1\u011c\1\64\1\uffff\1\64\1\u011f\1\u0120\4\64\1\u0125\1\u0126\2\64\1\uffff\1\u0129\1\64\1\uffff\1\u012b\15\64\1\u013a\6\64\1\u0141\10\64\1\u014b\6\64\1\uffff\1\64\1\u0153\2\uffff\1\u0154\3\64\2\uffff\1\64\1\u0159\1\uffff\1\64\1\uffff\4\64\1\u015f\7\64\1\u0167\1\64\1\uffff\1\64\1\u016a\4\64\1\uffff\4\64\1\u0173\4\64\1\uffff\7\64\2\uffff\2\64\1\u0183\1\u0184\1\uffff\1\u0185\1\u0186\2\64\1\u0189\1\uffff\1\u018a\1\u018b\1\u018c\1\u018d\1\u018e\1\64\1\u0190\1\uffff\2\64\1\uffff\1\u0193\3\64\1\u0197\3\64\1\uffff\1\u019b\1\u019c\12\64\1\u01a7\1\64\1\u01a9\4\uffff\2\64\6\uffff\1\u01ac\1\uffff\2\64\1\uffff\1\u01af\2\64\1\uffff\2\64\1\u01b4\2\uffff\1\64\1\u01b7\2\64\1\u01bb\1\u01bc\4\64\1\uffff\1\u01c1\1\uffff\1\u01c2\1\u01c3\1\uffff\1\u01c4\1\u01c5\1\uffff\1\64\1\u01c7\2\64\1\uffff\2\64\1\uffff\3\64\2\uffff\1\64\1\u01d1\2\64\5\uffff\1\64\1\uffff\3\64\1\u01d9\1\u01da\1\u01dc\1\u01dd\1\64\1\u01df\1\uffff\3\64\1\u01e3\3\64\2\uffff\1\64\2\uffff\1\64\1\uffff\3\64\1\uffff\3\64\1\u01ef\1\u01f0\2\64\1\u01f3\2\64\1\u01f6\2\uffff\1\64\1\u01f8\1\uffff\2\64\1\uffff\1\u01fb\1\uffff\2\64\1\uffff\2\64\1\u0200\1\64\1\uffff\1\u0202\1\uffff";
	static final String DFA39_eofS =
		"\u0203\uffff";
	static final String DFA39_minS =
		"\1\0\1\101\1\154\1\162\1\141\1\145\2\154\1\157\1\146\1\157\1\162\1\145\1\150\1\171\1\156\1\157\1\150\1\75\1\52\1\75\1\53\1\55\1\74\1\75\1\46\2\75\2\uffff\1\75\1\12\2\uffff\1\60\1\0\3\uffff\1\75\5\uffff\1\0\2\uffff\2\56\3\uffff\1\154\1\141\2\157\1\145\1\155\1\157\1\164\1\150\1\164\1\151\1\155\1\145\1\163\1\141\1\156\1\146\1\44\1\163\1\165\1\164\1\157\1\162\1\164\1\44\1\154\1\156\1\141\1\147\1\157\1\147\1\141\1\151\1\160\3\151\20\uffff\1\75\2\uffff\1\75\45\uffff\2\56\1\uffff\1\157\1\151\1\154\1\165\1\170\1\156\1\61\1\145\1\151\1\171\2\157\1\155\1\156\1\141\1\162\1\141\1\162\1\157\1\147\1\44\1\141\1\145\1\162\1\163\1\141\1\142\1\uffff\1\145\1\155\1\145\1\141\1\44\1\157\1\uffff\1\151\1\44\2\147\1\151\1\164\1\165\1\162\1\156\1\145\1\164\1\165\1\164\1\145\1\157\1\151\1\144\1\141\1\154\5\uffff\1\155\1\147\1\164\1\151\1\155\1\151\1\164\1\154\1\62\1\163\1\147\1\160\2\154\1\160\1\145\1\147\1\145\1\164\1\145\1\44\1\156\1\uffff\1\153\2\44\1\164\1\151\1\165\1\154\2\44\1\162\1\164\1\uffff\1\44\1\156\1\uffff\1\44\1\155\1\163\2\162\1\164\1\145\1\157\1\151\2\143\1\144\1\156\1\147\1\44\1\164\1\145\1\151\1\156\1\162\1\147\1\44\1\154\1\145\1\151\1\70\1\164\1\156\1\145\1\141\1\44\1\154\1\162\1\151\1\164\1\151\1\141\1\uffff\1\157\1\44\2\uffff\1\44\1\156\1\154\1\145\2\uffff\1\156\1\44\1\uffff\1\145\1\uffff\1\141\1\164\1\151\1\156\1\44\1\144\1\146\1\143\1\164\1\150\1\145\1\146\1\44\1\156\1\uffff\1\151\1\44\1\143\1\141\1\151\1\156\1\uffff\1\137\1\164\2\156\1\44\1\162\1\145\1\157\1\164\1\uffff\1\145\1\151\1\156\1\165\1\143\1\144\1\146\2\uffff\1\165\1\164\2\44\1\uffff\2\44\1\145\1\143\1\44\1\uffff\5\44\1\146\1\44\1\uffff\1\145\1\154\1\uffff\1\44\1\163\1\142\1\157\1\44\1\151\1\163\1\145\1\uffff\2\44\1\151\1\144\1\146\1\151\1\170\1\143\1\141\1\162\2\137\1\44\1\145\1\44\4\uffff\1\162\1\164\6\uffff\1\44\1\uffff\1\144\1\145\1\uffff\1\44\1\165\1\146\1\uffff\1\156\1\151\1\44\2\uffff\1\143\1\44\1\137\1\154\2\44\1\162\1\156\1\141\1\154\1\uffff\1\44\1\uffff\2\44\1\uffff\2\44\1\uffff\1\164\1\44\1\137\1\157\1\uffff\1\137\1\164\1\uffff\2\137\1\145\2\uffff\1\171\1\44\1\163\1\157\5\uffff\1\145\1\uffff\1\137\1\157\1\156\4\44\1\137\1\44\1\uffff\1\163\1\143\1\137\1\44\1\141\1\146\1\137\2\uffff\1\137\2\uffff\1\137\1\uffff\1\145\1\141\1\137\1\uffff\1\137\1\146\1\137\2\44\1\162\1\154\1\44\1\154\1\163\1\44\2\uffff\1\164\1\44\1\uffff\1\151\1\145\1\uffff\1\44\1\uffff\1\163\1\164\1\uffff\1\164\1\157\1\44\1\146\1\uffff\1\44\1\uffff";
	static final String DFA39_maxS =
		"\1\uffff\1\137\1\165\1\162\2\157\1\170\2\157\1\156\1\157\1\162\1\145\1\167\1\171\1\156\1\157\1\150\4\75\1\76\1\75\1\76\2\75\1\174\2\uffff\1\75\1\15\2\uffff\1\71\1\uffff\3\uffff\1\75\5\uffff\1\uffff\2\uffff\1\170\1\146\3\uffff\1\164\1\166\2\157\1\145\1\155\1\157\1\164\1\150\1\164\1\151\1\155\1\145\1\163\1\141\1\156\1\146\1\172\1\163\1\165\1\164\1\157\1\162\1\164\1\172\1\164\1\156\1\141\1\164\1\157\1\172\1\162\1\151\1\160\1\163\1\154\1\151\20\uffff\1\75\2\uffff\1\75\45\uffff\2\146\1\uffff\1\157\1\151\1\164\1\165\1\170\1\156\1\61\1\145\1\151\1\171\2\157\1\155\1\156\1\141\1\162\1\141\1\162\1\157\1\147\1\172\1\141\1\145\1\162\1\164\1\141\1\142\1\uffff\1\145\1\155\1\145\1\141\1\172\1\157\1\uffff\1\151\1\172\2\147\1\151\1\164\1\165\1\162\1\156\1\145\1\164\1\165\1\164\1\145\1\157\1\151\1\144\1\141\1\154\5\uffff\1\155\1\147\1\164\1\151\1\155\1\151\1\164\1\154\1\62\1\163\1\147\1\160\2\154\1\160\1\145\1\147\1\145\1\164\1\145\1\172\1\156\1\uffff\1\153\2\172\1\164\1\151\1\165\1\154\2\172\1\162\1\164\1\uffff\1\172\1\156\1\uffff\1\172\1\155\1\163\2\162\1\164\1\145\1\157\1\151\2\143\1\157\1\156\1\147\1\172\1\164\1\145\1\151\1\156\1\162\1\147\1\172\1\154\1\145\1\151\1\70\1\164\1\156\1\145\1\141\1\172\1\154\1\162\1\151\1\164\1\151\1\141\1\uffff\1\157\1\172\2\uffff\1\172\1\156\1\154\1\145\2\uffff\1\156\1\172\1\uffff\1\145\1\uffff\1\141\1\164\1\151\1\156\1\172\1\144\1\146\1\143\1\164\1\150\1\145\1\146\1\172\1\156\1\uffff\1\151\1\172\1\143\1\141\1\151\1\156\1\uffff\1\137\1\164\2\156\1\172\1\162\1\145\1\157\1\164\1\uffff\1\145\1\151\1\156\1\165\1\143\1\144\1\146\2\uffff\1\165\1\164\2\172\1\uffff\2\172\1\145\1\143\1\172\1\uffff\5\172\1\146\1\172\1\uffff\1\145\1\154\1\uffff\1\172\1\163\1\142\1\157\1\172\1\151\1\163\1\145\1\uffff\2\172\1\151\1\144\1\146\1\151\1\170\1\143\1\141\1\162\2\137\1\172\1\145\1\172\4\uffff\1\162\1\164\6\uffff\1\172\1\uffff\1\144\1\145\1\uffff\1\172\1\165\1\146\1\uffff\1\156\1\151\1\172\2\uffff\1\143\1\172\1\137\1\154\2\172\1\162\1\156\1\141\1\154\1\uffff\1\172\1\uffff\2\172\1\uffff\2\172\1\uffff\1\164\1\172\1\137\1\157\1\uffff\1\137\1\164\1\uffff\2\137\1\145\2\uffff\1\171\1\172\1\163\1\157\5\uffff\1\145\1\uffff\1\137\1\166\1\156\4\172\1\137\1\172\1\uffff\1\163\1\143\1\137\1\172\1\141\1\146\1\137\2\uffff\1\137\2\uffff\1\137\1\uffff\1\145\1\141\1\137\1\uffff\1\137\1\146\1\137\2\172\1\162\1\154\1\172\1\154\1\163\1\172\2\uffff\1\164\1\172\1\uffff\1\151\1\145\1\uffff\1\172\1\uffff\1\163\1\164\1\uffff\1\164\1\157\1\172\1\146\1\uffff\1\172\1\uffff";
	static final String DFA39_acceptS =
		"\34\uffff\1\116\1\117\2\uffff\1\125\1\126\2\uffff\1\135\1\136\1\137\1\uffff\1\154\1\155\1\156\1\157\1\161\1\uffff\1\164\1\165\2\uffff\1\176\1\u0081\1\165\45\uffff\1\163\1\103\1\177\1\u0080\1\127\1\104\1\145\1\105\1\152\1\106\1\153\1\143\1\107\1\115\1\144\1\141\1\uffff\1\142\1\133\1\uffff\1\134\1\120\1\112\1\121\1\124\1\113\1\150\1\114\1\151\1\116\1\117\1\122\1\132\1\123\1\175\1\125\1\126\1\130\1\174\1\131\1\167\1\135\1\136\1\137\1\146\1\147\1\154\1\155\1\156\1\157\1\161\1\162\1\166\1\164\1\170\1\173\1\171\2\uffff\1\176\33\uffff\1\25\6\uffff\1\37\23\uffff\1\140\1\110\1\160\1\111\1\172\26\uffff\1\10\13\uffff\1\34\2\uffff\1\44\45\uffff\1\3\2\uffff\1\17\1\20\4\uffff\1\27\1\31\2\uffff\1\36\1\uffff\1\45\16\uffff\1\77\6\uffff\1\11\11\uffff\1\13\7\uffff\1\14\1\22\4\uffff\1\33\5\uffff\1\60\7\uffff\1\75\2\uffff\1\102\10\uffff\1\46\17\uffff\1\26\1\32\1\41\1\52\2\uffff\1\57\1\61\1\64\1\65\1\67\1\70\1\uffff\1\73\2\uffff\1\1\3\uffff\1\12\3\uffff\1\47\1\50\12\uffff\1\5\1\uffff\1\24\2\uffff\1\72\2\uffff\1\4\4\uffff\1\42\2\uffff\1\62\3\uffff\1\21\1\35\4\uffff\1\23\1\53\1\54\1\76\1\100\1\uffff\1\6\11\uffff\1\51\7\uffff\1\43\1\55\1\uffff\1\63\1\74\1\uffff\1\40\3\uffff\1\7\13\uffff\1\56\1\101\2\uffff\1\2\2\uffff\1\30\1\uffff\1\71\2\uffff\1\66\4\uffff\1\15\1\uffff\1\16";
	static final String DFA39_specialS =
		"\1\1\42\uffff\1\0\11\uffff\1\2\u01d5\uffff}>";
	static final String[] DFA39_transitionS = {
			"\11\63\1\35\1\62\2\63\1\62\22\63\1\35\1\47\1\43\1\34\1\57\1\24\1\31\1\55\1\46\1\53\1\22\1\25\1\40\1\26\1\42\1\23\1\60\11\61\1\41\1\54\1\27\1\36\1\30\1\50\1\63\32\57\1\45\1\37\1\52\1\32\1\1\1\63\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\57\1\11\2\57\1\12\3\57\1\13\1\57\1\14\1\15\1\16\1\17\1\20\1\21\3\57\1\44\1\33\1\51\1\56\uff81\63",
			"\1\65\1\67\1\70\3\uffff\1\71\1\uffff\1\72\4\uffff\1\73\4\uffff\1\74\1\75\12\uffff\1\66",
			"\1\77\6\uffff\1\100\1\uffff\1\76",
			"\1\101",
			"\1\102\6\uffff\1\103\6\uffff\1\104",
			"\1\105\11\uffff\1\106",
			"\1\107\1\uffff\1\110\11\uffff\1\111",
			"\1\112\2\uffff\1\113",
			"\1\114",
			"\1\115\7\uffff\1\116",
			"\1\117",
			"\1\120",
			"\1\121",
			"\1\122\1\123\12\uffff\1\124\2\uffff\1\125",
			"\1\126",
			"\1\127",
			"\1\130",
			"\1\131",
			"\1\133",
			"\1\134\4\uffff\1\135\15\uffff\1\137",
			"\1\141",
			"\1\144\21\uffff\1\143",
			"\1\150\17\uffff\1\146\1\147",
			"\1\152\1\153",
			"\1\156\1\155",
			"\1\161\26\uffff\1\160",
			"\1\163",
			"\1\165\76\uffff\1\166",
			"",
			"",
			"\1\172",
			"\1\174\2\uffff\1\174",
			"",
			"",
			"\12\u0080",
			"\0\u0082",
			"",
			"",
			"",
			"\1\u0087",
			"",
			"",
			"",
			"",
			"",
			"\47\u008e\1\uffff\uffd8\u008e",
			"",
			"",
			"\1\u0080\1\uffff\10\u0093\2\u0080\10\uffff\1\u0091\1\uffff\3\u0080\21\uffff\1\u0090\11\uffff\1\u0091\1\uffff\3\u0080\21\uffff\1\u0090",
			"\1\u0080\1\uffff\12\u0094\12\uffff\3\u0080\35\uffff\3\u0080",
			"",
			"",
			"",
			"\1\u0097\7\uffff\1\u0096",
			"\1\u0098\1\u0099\2\uffff\1\u009a\3\uffff\1\u009b\3\uffff\1\u009c\4\uffff\1\u009d\1\u009e\1\u009f\1\uffff\1\u00a0",
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
			"\1\u00ad",
			"\1\u00ae",
			"\1\u00af",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\24\64\1\u00b0\5\64",
			"\1\u00b2",
			"\1\u00b3",
			"\1\u00b4",
			"\1\u00b5",
			"\1\u00b6",
			"\1\u00b7",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u00b9\7\uffff\1\u00ba",
			"\1\u00bb",
			"\1\u00bc",
			"\1\u00bd\13\uffff\1\u00be\1\u00bf",
			"\1\u00c0",
			"\1\u00c1\22\uffff\1\u00c2",
			"\1\u00c3\20\uffff\1\u00c4",
			"\1\u00c5",
			"\1\u00c6",
			"\1\u00c7\11\uffff\1\u00c8",
			"\1\u00c9\2\uffff\1\u00ca",
			"\1\u00cb",
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
			"\1\u00cd",
			"",
			"",
			"\1\u00cf",
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
			"\1\u0080\1\uffff\10\u0093\2\u0080\12\uffff\3\u0080\35\uffff\3\u0080",
			"\1\u0080\1\uffff\12\u0094\12\uffff\3\u0080\35\uffff\3\u0080",
			"",
			"\1\u00d1",
			"\1\u00d2",
			"\1\u00d4\6\uffff\1\u00d5\1\u00d3",
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
			"\1\u00e1",
			"\1\u00e2",
			"\1\u00e3",
			"\1\u00e4",
			"\1\u00e5",
			"\1\u00e6",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u00e8",
			"\1\u00e9",
			"\1\u00ea",
			"\1\u00eb\1\u00ec",
			"\1\u00ed",
			"\1\u00ee",
			"",
			"\1\u00ef",
			"\1\u00f0",
			"\1\u00f1",
			"\1\u00f2",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u00f4",
			"",
			"\1\u00f5",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
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
			"\1\u0104",
			"\1\u0105",
			"\1\u0106",
			"\1\u0107",
			"",
			"",
			"",
			"",
			"",
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
			"\1\u0114",
			"\1\u0115",
			"\1\u0116",
			"\1\u0117",
			"\1\u0118",
			"\1\u0119",
			"\1\u011a",
			"\1\u011b",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u011d",
			"",
			"\1\u011e",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0121",
			"\1\u0122",
			"\1\u0123",
			"\1\u0124",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0127",
			"\1\u0128",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u012a",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u012c",
			"\1\u012d",
			"\1\u012e",
			"\1\u012f",
			"\1\u0130",
			"\1\u0131",
			"\1\u0132",
			"\1\u0133",
			"\1\u0134",
			"\1\u0135",
			"\1\u0136\12\uffff\1\u0137",
			"\1\u0138",
			"\1\u0139",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u013b",
			"\1\u013c",
			"\1\u013d",
			"\1\u013e",
			"\1\u013f",
			"\1\u0140",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\u0142\1\uffff\32\64",
			"\1\u0143",
			"\1\u0144",
			"\1\u0145",
			"\1\u0146",
			"\1\u0147",
			"\1\u0148",
			"\1\u0149",
			"\1\u014a",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u014c",
			"\1\u014d",
			"\1\u014e",
			"\1\u014f",
			"\1\u0150",
			"\1\u0151",
			"",
			"\1\u0152",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0155",
			"\1\u0156",
			"\1\u0157",
			"",
			"",
			"\1\u0158",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\u015a",
			"",
			"\1\u015b",
			"\1\u015c",
			"\1\u015d",
			"\1\u015e",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0160",
			"\1\u0161",
			"\1\u0162",
			"\1\u0163",
			"\1\u0164",
			"\1\u0165",
			"\1\u0166",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0168",
			"",
			"\1\u0169",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u016b",
			"\1\u016c",
			"\1\u016d",
			"\1\u016e",
			"",
			"\1\u016f",
			"\1\u0170",
			"\1\u0171",
			"\1\u0172",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\3\64\1\u0174\4\64\1\u0175\21\64",
			"\1\u0176",
			"\1\u0177",
			"\1\u0178",
			"\1\u0179",
			"",
			"\1\u017a",
			"\1\u017b",
			"\1\u017c",
			"\1\u017d",
			"\1\u017e",
			"\1\u017f",
			"\1\u0180",
			"",
			"",
			"\1\u0181",
			"\1\u0182",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0187",
			"\1\u0188",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u018f",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\u0191",
			"\1\u0192",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0194",
			"\1\u0195",
			"\1\u0196",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0198",
			"\1\u0199",
			"\1\u019a",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u019d",
			"\1\u019e",
			"\1\u019f",
			"\1\u01a0",
			"\1\u01a1",
			"\1\u01a2",
			"\1\u01a3",
			"\1\u01a4",
			"\1\u01a5",
			"\1\u01a6",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u01a8",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"",
			"",
			"",
			"\1\u01aa",
			"\1\u01ab",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\u01ad",
			"\1\u01ae",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u01b0",
			"\1\u01b1",
			"",
			"\1\u01b2",
			"\1\u01b3",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\u01b5\1\uffff\32\64",
			"",
			"",
			"\1\u01b6",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\u01b8\1\uffff\32\64",
			"\1\u01b9",
			"\1\u01ba",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u01bd",
			"\1\u01be",
			"\1\u01bf",
			"\1\u01c0",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\u01c6",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\u01c8\1\uffff\32\64",
			"\1\u01c9",
			"\1\u01ca",
			"",
			"\1\u01cb",
			"\1\u01cc",
			"",
			"\1\u01cd",
			"\1\u01ce",
			"\1\u01cf",
			"",
			"",
			"\1\u01d0",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u01d2",
			"\1\u01d3",
			"",
			"",
			"",
			"",
			"",
			"\1\u01d4",
			"",
			"\1\u01d5",
			"\1\u01d7\6\uffff\1\u01d6",
			"\1\u01d8",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\u01db\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u01de",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\u01e0",
			"\1\u01e1",
			"\1\u01e2",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u01e4",
			"\1\u01e5",
			"\1\u01e6",
			"",
			"",
			"\1\u01e7",
			"",
			"",
			"\1\u01e8",
			"",
			"\1\u01e9",
			"\1\u01ea",
			"\1\u01eb",
			"",
			"\1\u01ec",
			"\1\u01ed",
			"\1\u01ee",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u01f1",
			"\1\u01f2",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u01f4",
			"\1\u01f5",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"",
			"\1\u01f7",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\u01f9",
			"\1\u01fa",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\u01fc",
			"\1\u01fd",
			"",
			"\1\u01fe",
			"\1\u01ff",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0201",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
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
			return "1:1: Tokens : ( RULE_KW_ATOMIC | RULE_KW_ATTRIBUTE | RULE_KW_AUTO | RULE_KW_ALIGNAS | RULE_KW_ALIGNOF1 | RULE_KW_ALIGNOF2 | RULE_KW_ALIGNOF3 | RULE_KW_ASM1 | RULE_KW_ASM2 | RULE_KW_ASM3 | RULE_KW_BOOL | RULE_KW_BREAK | RULE_KW_BUILTIN_VA_LIST | RULE_KW_BUILTIN_OFFSETOF | RULE_KW_CASE | RULE_KW_CHAR | RULE_KW_COMPLEX | RULE_KW_CONST | RULE_KW_CONTINUE | RULE_KW_DEFAULT | RULE_KW_DO | RULE_KW_DOUBLE | RULE_KW_ELSE | RULE_KW_EXTENSION | RULE_KW_ENUM | RULE_KW_EXTERN | RULE_KW_FLOAT | RULE_KW_FOR | RULE_KW_GENERIC | RULE_KW_GOTO | RULE_KW_IF | RULE_KW_IMAGINARY | RULE_KW_INLINE1 | RULE_KW_INLINE2 | RULE_KW_INLINE3 | RULE_KW_INT | RULE_KW_LONG | RULE_KW_M128 | RULE_KW_M128D | RULE_KW_M128I | RULE_KW_NORETURN | RULE_KW_PRAGMA | RULE_KW_REGISTER | RULE_KW_RESTRICT | RULE_KW_RESTRICT2 | RULE_KW_RESTRICT3 | RULE_KW_RETURN | RULE_KW_SHORT | RULE_KW_SIGNED1 | RULE_KW_SIGNED2 | RULE_KW_SIGNED3 | RULE_KW_SIZEOF | RULE_KW_STATIC | RULE_KW_STATICASSERT | RULE_KW_STRUCT | RULE_KW_SWITCH | RULE_KW_THREADLOCAL | RULE_KW_TYPEDEF | RULE_KW_TYPEOF1 | RULE_KW_TYPEOF3 | RULE_KW_UNION | RULE_KW_UNSIGNED | RULE_KW_VOID | RULE_KW_VOLATILE | RULE_KW_VOLATILE2 | RULE_KW_WHILE | RULE_STARASSIGN | RULE_DIVASSIGN | RULE_MODASSIGN | RULE_PLUSASSIGN | RULE_MINUSASSIGN | RULE_LEFTSHIFTASSIGN | RULE_RIGHTSHIFTASSIGN | RULE_ANDASSIGN | RULE_XORASSIGN | RULE_ORASSIGN | RULE_ARROW | RULE_LINEDIRECTIVE | RULE_WHITESPACE | RULE_SKW_AND | RULE_SKW_ANDAND | RULE_SKW_ASSIGN | RULE_SKW_BACKSLASH | RULE_SKW_CARET | RULE_SKW_COMMA | RULE_SKW_COLON | RULE_SKW_DIV | RULE_SKW_DOT | RULE_SKW_DOUBLEQUOTE | RULE_SKW_EQUAL | RULE_SKW_GREATER | RULE_SKW_GREATEREQUAL | RULE_SKW_LEFTBRACE | RULE_SKW_LEFTBRACKET | RULE_SKW_LEFTPAREN | RULE_SKW_LEFTSHIFT | RULE_SKW_LESS | RULE_SKW_LESSEQUAL | RULE_SKW_MINUS | RULE_SKW_MINUSMINUS | RULE_SKW_MOD | RULE_SKW_NOT | RULE_SKW_NOTEQUAL | RULE_SKW_OR | RULE_SKW_OROR | RULE_SKW_PLUS | RULE_SKW_PLUSPLUS | RULE_SKW_QUESTION | RULE_SKW_RIGHTBRACE | RULE_SKW_RIGHTBRACKET | RULE_SKW_RIGHTPAREN | RULE_SKW_RIGHTSHIFT | RULE_SKW_SEMI | RULE_SKW_SINGLEQUOTE | RULE_SKW_STAR | RULE_SKW_TILDE | RULE_ID | RULE_CHAR_LITERAL | RULE_STRING_LITERAL | RULE_HEX_LITERAL | RULE_DECIMAL_LITERAL | RULE_OCTAL_LITERAL | RULE_BIN_LITERAL | RULE_FLOAT_LITERAL | RULE_LINEBREAK | RULE_NEWLINE | RULE_BLOCK_COMMENT | RULE_LINE_COMMENT | RULE_SPECIAL );";
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
				new NoViableAltException(getDescription(), 39, _s, input);
			error(nvae);
			throw nvae;
		}
			private int specialState0(int s, IntStream _input) {
				IntStream input = _input;
				int LA39_35 = input.LA(1);
				s = -1;
				if ( ((LA39_35 >= '\u0000' && LA39_35 <= '\uFFFF')) ) {s = 130;}
				else s = 129;
				//if ( s>=0 ) return s;
				//break;
				return s;
			}

			private int specialState1(int s, IntStream _input) {
				IntStream input = _input;
				int LA39_0 = input.LA(1);
				s = -1;
				if ( (LA39_0=='_') ) {s = 1;}
				else if ( (LA39_0=='a') ) {s = 2;}
				else if ( (LA39_0=='b') ) {s = 3;}
				else if ( (LA39_0=='c') ) {s = 4;}
				else if ( (LA39_0=='d') ) {s = 5;}
				else if ( (LA39_0=='e') ) {s = 6;}
				else if ( (LA39_0=='f') ) {s = 7;}
				else if ( (LA39_0=='g') ) {s = 8;}
				else if ( (LA39_0=='i') ) {s = 9;}
				else if ( (LA39_0=='l') ) {s = 10;}
				else if ( (LA39_0=='p') ) {s = 11;}
				else if ( (LA39_0=='r') ) {s = 12;}
				else if ( (LA39_0=='s') ) {s = 13;}
				else if ( (LA39_0=='t') ) {s = 14;}
				else if ( (LA39_0=='u') ) {s = 15;}
				else if ( (LA39_0=='v') ) {s = 16;}
				else if ( (LA39_0=='w') ) {s = 17;}
				else if ( (LA39_0=='*') ) {s = 18;}
				else if ( (LA39_0=='/') ) {s = 19;}
				else if ( (LA39_0=='%') ) {s = 20;}
				else if ( (LA39_0=='+') ) {s = 21;}
				else if ( (LA39_0=='-') ) {s = 22;}
				else if ( (LA39_0=='<') ) {s = 23;}
				else if ( (LA39_0=='>') ) {s = 24;}
				else if ( (LA39_0=='&') ) {s = 25;}
				else if ( (LA39_0=='^') ) {s = 26;}
				else if ( (LA39_0=='|') ) {s = 27;}
				else if ( (LA39_0=='#') ) {s = 28;}
				else if ( (LA39_0=='\t'||LA39_0==' ') ) {s = 29;}
				else if ( (LA39_0=='=') ) {s = 30;}
				else if ( (LA39_0=='\\') ) {s = 31;}
				else if ( (LA39_0==',') ) {s = 32;}
				else if ( (LA39_0==':') ) {s = 33;}
				else if ( (LA39_0=='.') ) {s = 34;}
				else if ( (LA39_0=='\"') ) {s = 35;}
				else if ( (LA39_0=='{') ) {s = 36;}
				else if ( (LA39_0=='[') ) {s = 37;}
				else if ( (LA39_0=='(') ) {s = 38;}
				else if ( (LA39_0=='!') ) {s = 39;}
				else if ( (LA39_0=='?') ) {s = 40;}
				else if ( (LA39_0=='}') ) {s = 41;}
				else if ( (LA39_0==']') ) {s = 42;}
				else if ( (LA39_0==')') ) {s = 43;}
				else if ( (LA39_0==';') ) {s = 44;}
				else if ( (LA39_0=='\'') ) {s = 45;}
				else if ( (LA39_0=='~') ) {s = 46;}
				else if ( (LA39_0=='$'||(LA39_0 >= 'A' && LA39_0 <= 'Z')||LA39_0=='h'||(LA39_0 >= 'j' && LA39_0 <= 'k')||(LA39_0 >= 'm' && LA39_0 <= 'o')||LA39_0=='q'||(LA39_0 >= 'x' && LA39_0 <= 'z')) ) {s = 47;}
				else if ( (LA39_0=='0') ) {s = 48;}
				else if ( ((LA39_0 >= '1' && LA39_0 <= '9')) ) {s = 49;}
				else if ( (LA39_0=='\n'||LA39_0=='\r') ) {s = 50;}
				else if ( ((LA39_0 >= '\u0000' && LA39_0 <= '\b')||(LA39_0 >= '\u000B' && LA39_0 <= '\f')||(LA39_0 >= '\u000E' && LA39_0 <= '\u001F')||LA39_0=='@'||LA39_0=='`'||(LA39_0 >= '\u007F' && LA39_0 <= '\uFFFF')) ) {s = 51;}
				//if ( s>=0 ) return s;
				//break;
				return s;
			}

			private int specialState2(int s, IntStream _input) {
				IntStream input = _input;
				int LA39_45 = input.LA(1);
				s = -1;
				if ( ((LA39_45 >= '\u0000' && LA39_45 <= '&')||(LA39_45 >= '(' && LA39_45 <= '\uFFFF')) ) {s = 142;}
				else s = 141;
				//if ( s>=0 ) return s;
				//break;
				return s;
			}

	}


}