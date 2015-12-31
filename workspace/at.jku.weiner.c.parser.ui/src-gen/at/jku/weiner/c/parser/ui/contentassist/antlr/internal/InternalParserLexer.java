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
	public static final int RULE_KW_ASM3=27;
	public static final int RULE_KW_ATOMIC=28;
	public static final int RULE_KW_ATTRIBUTE=29;
	public static final int RULE_KW_AUTO=30;
	public static final int RULE_KW_BOOL=31;
	public static final int RULE_KW_BREAK=32;
	public static final int RULE_KW_BUILTIN_VA_LIST=33;
	public static final int RULE_KW_CASE=34;
	public static final int RULE_KW_CHAR=35;
	public static final int RULE_KW_COMPLEX=36;
	public static final int RULE_KW_CONST=37;
	public static final int RULE_KW_CONTINUE=38;
	public static final int RULE_KW_DEFAULT=39;
	public static final int RULE_KW_DO=40;
	public static final int RULE_KW_DOUBLE=41;
	public static final int RULE_KW_ELSE=42;
	public static final int RULE_KW_ENUM=43;
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
	public static final int RULE_KW_SIGNED=66;
	public static final int RULE_KW_SIZEOF=67;
	public static final int RULE_KW_STATIC=68;
	public static final int RULE_KW_STATICASSERT=69;
	public static final int RULE_KW_STRUCT=70;
	public static final int RULE_KW_SWITCH=71;
	public static final int RULE_KW_THREADLOCAL=72;
	public static final int RULE_KW_TYPEDEF=73;
	public static final int RULE_KW_UNION=74;
	public static final int RULE_KW_UNSIGNED=75;
	public static final int RULE_KW_VOID=76;
	public static final int RULE_KW_VOLATILE=77;
	public static final int RULE_KW_VOLATILE2=78;
	public static final int RULE_KW_WHILE=79;
	public static final int RULE_LEFTSHIFTASSIGN=80;
	public static final int RULE_LETTER=81;
	public static final int RULE_LINEBREAK=82;
	public static final int RULE_LINEDIRECTIVE=83;
	public static final int RULE_LINEFEED=84;
	public static final int RULE_LINE_COMMENT=85;
	public static final int RULE_LINE_END=86;
	public static final int RULE_MINUSASSIGN=87;
	public static final int RULE_MODASSIGN=88;
	public static final int RULE_NEWLINE=89;
	public static final int RULE_OCTAL_ESCAPE=90;
	public static final int RULE_OCTAL_LITERAL=91;
	public static final int RULE_ORASSIGN=92;
	public static final int RULE_PLUSASSIGN=93;
	public static final int RULE_RIGHTSHIFTASSIGN=94;
	public static final int RULE_SKW_AND=95;
	public static final int RULE_SKW_ANDAND=96;
	public static final int RULE_SKW_ASSIGN=97;
	public static final int RULE_SKW_BACKSLASH=98;
	public static final int RULE_SKW_CARET=99;
	public static final int RULE_SKW_COLON=100;
	public static final int RULE_SKW_COMMA=101;
	public static final int RULE_SKW_DIV=102;
	public static final int RULE_SKW_DOLLAR=103;
	public static final int RULE_SKW_DOT=104;
	public static final int RULE_SKW_DOUBLEQUOTE=105;
	public static final int RULE_SKW_EQUAL=106;
	public static final int RULE_SKW_GREATER=107;
	public static final int RULE_SKW_GREATEREQUAL=108;
	public static final int RULE_SKW_LEFTBRACE=109;
	public static final int RULE_SKW_LEFTBRACKET=110;
	public static final int RULE_SKW_LEFTPAREN=111;
	public static final int RULE_SKW_LEFTSHIFT=112;
	public static final int RULE_SKW_LESS=113;
	public static final int RULE_SKW_LESSEQUAL=114;
	public static final int RULE_SKW_MINUS=115;
	public static final int RULE_SKW_MINUSMINUS=116;
	public static final int RULE_SKW_MOD=117;
	public static final int RULE_SKW_NOT=118;
	public static final int RULE_SKW_NOTEQUAL=119;
	public static final int RULE_SKW_OR=120;
	public static final int RULE_SKW_OROR=121;
	public static final int RULE_SKW_PLUS=122;
	public static final int RULE_SKW_PLUSPLUS=123;
	public static final int RULE_SKW_QUESTION=124;
	public static final int RULE_SKW_RIGHTBRACE=125;
	public static final int RULE_SKW_RIGHTBRACKET=126;
	public static final int RULE_SKW_RIGHTPAREN=127;
	public static final int RULE_SKW_RIGHTSHIFT=128;
	public static final int RULE_SKW_SEMI=129;
	public static final int RULE_SKW_SINGLEQUOTE=130;
	public static final int RULE_SKW_STAR=131;
	public static final int RULE_SKW_TILDE=132;
	public static final int RULE_SKW_UNDERSCORE=133;
	public static final int RULE_SPACE=134;
	public static final int RULE_SPECIAL=135;
	public static final int RULE_STARASSIGN=136;
	public static final int RULE_STRING_LITERAL=137;
	public static final int RULE_TAB=138;
	public static final int RULE_WHITESPACE=139;
	public static final int RULE_XORASSIGN=140;

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
			// InternalParser.g:23618:16: ( RULE_SKW_UNDERSCORE 'Atomic' )
			// InternalParser.g:23618:18: RULE_SKW_UNDERSCORE 'Atomic'
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
			// InternalParser.g:23620:19: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'attribute' RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE )
			// InternalParser.g:23620:21: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'attribute' RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE
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
			// InternalParser.g:23622:14: ( 'auto' )
			// InternalParser.g:23622:16: 'auto'
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
			// InternalParser.g:23624:17: ( RULE_SKW_UNDERSCORE 'Alignas' )
			// InternalParser.g:23624:19: RULE_SKW_UNDERSCORE 'Alignas'
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
			// InternalParser.g:23626:17: ( RULE_SKW_UNDERSCORE 'Alignof' )
			// InternalParser.g:23626:19: RULE_SKW_UNDERSCORE 'Alignof'
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
			// InternalParser.g:23628:14: ( 'asm' )
			// InternalParser.g:23628:16: 'asm'
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
			// InternalParser.g:23630:14: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_ASM1 )
			// InternalParser.g:23630:16: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_ASM1
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
			// InternalParser.g:23632:14: ( RULE_KW_ASM2 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE )
			// InternalParser.g:23632:16: RULE_KW_ASM2 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE
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
			// InternalParser.g:23634:14: ( RULE_SKW_UNDERSCORE 'Bool' )
			// InternalParser.g:23634:16: RULE_SKW_UNDERSCORE 'Bool'
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
			// InternalParser.g:23636:15: ( 'break' )
			// InternalParser.g:23636:17: 'break'
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
			// InternalParser.g:23638:25: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'builtin_va_list' )
			// InternalParser.g:23638:27: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'builtin_va_list'
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
			// InternalParser.g:23640:14: ( 'case' )
			// InternalParser.g:23640:16: 'case'
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
			// InternalParser.g:23642:14: ( 'char' )
			// InternalParser.g:23642:16: 'char'
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
			// InternalParser.g:23644:17: ( RULE_SKW_UNDERSCORE 'Complex' )
			// InternalParser.g:23644:19: RULE_SKW_UNDERSCORE 'Complex'
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
			// InternalParser.g:23646:15: ( 'const' )
			// InternalParser.g:23646:17: 'const'
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
			// InternalParser.g:23648:18: ( 'continue' )
			// InternalParser.g:23648:20: 'continue'
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
			// InternalParser.g:23650:17: ( 'default' )
			// InternalParser.g:23650:19: 'default'
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
			// InternalParser.g:23652:12: ( 'do' )
			// InternalParser.g:23652:14: 'do'
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
			// InternalParser.g:23654:16: ( 'double' )
			// InternalParser.g:23654:18: 'double'
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
			// InternalParser.g:23656:14: ( 'else' )
			// InternalParser.g:23656:16: 'else'
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
			// InternalParser.g:23658:14: ( 'enum' )
			// InternalParser.g:23658:16: 'enum'
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
			// InternalParser.g:23660:16: ( 'extern' )
			// InternalParser.g:23660:18: 'extern'
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
			// InternalParser.g:23662:15: ( 'float' )
			// InternalParser.g:23662:17: 'float'
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
			// InternalParser.g:23664:13: ( 'for' )
			// InternalParser.g:23664:15: 'for'
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
			// InternalParser.g:23666:17: ( RULE_SKW_UNDERSCORE 'Generic' )
			// InternalParser.g:23666:19: RULE_SKW_UNDERSCORE 'Generic'
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
			// InternalParser.g:23668:14: ( 'goto' )
			// InternalParser.g:23668:16: 'goto'
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
			// InternalParser.g:23670:12: ( 'if' )
			// InternalParser.g:23670:14: 'if'
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
			// InternalParser.g:23672:19: ( RULE_SKW_UNDERSCORE 'Imaginary' )
			// InternalParser.g:23672:21: RULE_SKW_UNDERSCORE 'Imaginary'
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
			// InternalParser.g:23674:17: ( 'inline' )
			// InternalParser.g:23674:19: 'inline'
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
			// InternalParser.g:23676:17: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_INLINE1 )
			// InternalParser.g:23676:19: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_INLINE1
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
			// InternalParser.g:23678:13: ( 'int' )
			// InternalParser.g:23678:15: 'int'
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
			// InternalParser.g:23680:14: ( 'long' )
			// InternalParser.g:23680:16: 'long'
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
			// InternalParser.g:23682:14: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'm128' )
			// InternalParser.g:23682:16: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'm128'
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
			// InternalParser.g:23684:15: ( RULE_KW_M128 'd' )
			// InternalParser.g:23684:17: RULE_KW_M128 'd'
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
			// InternalParser.g:23686:15: ( RULE_KW_M128 'i' )
			// InternalParser.g:23686:17: RULE_KW_M128 'i'
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
			// InternalParser.g:23688:18: ( RULE_SKW_UNDERSCORE 'Noreturn' )
			// InternalParser.g:23688:20: RULE_SKW_UNDERSCORE 'Noreturn'
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
			// InternalParser.g:23690:16: ( 'pragma' )
			// InternalParser.g:23690:18: 'pragma'
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
			// InternalParser.g:23692:18: ( 'register' )
			// InternalParser.g:23692:20: 'register'
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
			// InternalParser.g:23694:18: ( 'restrict' )
			// InternalParser.g:23694:20: 'restrict'
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
			// InternalParser.g:23696:19: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_RESTRICT )
			// InternalParser.g:23696:21: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_RESTRICT
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
			// InternalParser.g:23698:19: ( RULE_KW_RESTRICT2 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE )
			// InternalParser.g:23698:21: RULE_KW_RESTRICT2 RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE
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
			// InternalParser.g:23700:16: ( 'return' )
			// InternalParser.g:23700:18: 'return'
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
			// InternalParser.g:23702:15: ( 'short' )
			// InternalParser.g:23702:17: 'short'
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
			// InternalParser.g:23704:16: ( 'signed' )
			// InternalParser.g:23704:18: 'signed'
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
			// InternalParser.g:23706:16: ( 'sizeof' )
			// InternalParser.g:23706:18: 'sizeof'
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
			// InternalParser.g:23708:16: ( 'static' )
			// InternalParser.g:23708:18: 'static'
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
			// InternalParser.g:23710:22: ( RULE_SKW_UNDERSCORE 'Static_assert' )
			// InternalParser.g:23710:24: RULE_SKW_UNDERSCORE 'Static_assert'
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
			// InternalParser.g:23712:16: ( 'struct' )
			// InternalParser.g:23712:18: 'struct'
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
			// InternalParser.g:23714:16: ( 'switch' )
			// InternalParser.g:23714:18: 'switch'
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
			// InternalParser.g:23716:21: ( RULE_SKW_UNDERSCORE 'Thread_local' )
			// InternalParser.g:23716:23: RULE_SKW_UNDERSCORE 'Thread_local'
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
			// InternalParser.g:23718:17: ( 'typedef' )
			// InternalParser.g:23718:19: 'typedef'
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
			// InternalParser.g:23720:15: ( 'union' )
			// InternalParser.g:23720:17: 'union'
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
			// InternalParser.g:23722:18: ( 'unsigned' )
			// InternalParser.g:23722:20: 'unsigned'
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
			// InternalParser.g:23724:14: ( 'void' )
			// InternalParser.g:23724:16: 'void'
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
			// InternalParser.g:23726:18: ( 'volatile' )
			// InternalParser.g:23726:20: 'volatile'
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
			// InternalParser.g:23728:19: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_VOLATILE RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE )
			// InternalParser.g:23728:21: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE RULE_KW_VOLATILE RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE
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
			// InternalParser.g:23730:15: ( 'while' )
			// InternalParser.g:23730:17: 'while'
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
			// InternalParser.g:23732:17: ( RULE_SKW_STAR RULE_SKW_ASSIGN )
			// InternalParser.g:23732:19: RULE_SKW_STAR RULE_SKW_ASSIGN
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
			// InternalParser.g:23734:16: ( RULE_SKW_DIV RULE_SKW_ASSIGN )
			// InternalParser.g:23734:18: RULE_SKW_DIV RULE_SKW_ASSIGN
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
			// InternalParser.g:23736:16: ( RULE_SKW_MOD RULE_SKW_ASSIGN )
			// InternalParser.g:23736:18: RULE_SKW_MOD RULE_SKW_ASSIGN
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
			// InternalParser.g:23738:17: ( RULE_SKW_PLUS RULE_SKW_ASSIGN )
			// InternalParser.g:23738:19: RULE_SKW_PLUS RULE_SKW_ASSIGN
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
			// InternalParser.g:23740:18: ( RULE_SKW_MINUS RULE_SKW_ASSIGN )
			// InternalParser.g:23740:20: RULE_SKW_MINUS RULE_SKW_ASSIGN
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
			// InternalParser.g:23742:22: ( RULE_SKW_LEFTSHIFT RULE_SKW_ASSIGN )
			// InternalParser.g:23742:24: RULE_SKW_LEFTSHIFT RULE_SKW_ASSIGN
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
			// InternalParser.g:23744:23: ( RULE_SKW_RIGHTSHIFT RULE_SKW_ASSIGN )
			// InternalParser.g:23744:25: RULE_SKW_RIGHTSHIFT RULE_SKW_ASSIGN
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
			// InternalParser.g:23746:16: ( RULE_SKW_AND RULE_SKW_ASSIGN )
			// InternalParser.g:23746:18: RULE_SKW_AND RULE_SKW_ASSIGN
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
			// InternalParser.g:23748:16: ( RULE_SKW_CARET RULE_SKW_ASSIGN )
			// InternalParser.g:23748:18: RULE_SKW_CARET RULE_SKW_ASSIGN
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
			// InternalParser.g:23750:15: ( RULE_SKW_OR RULE_SKW_ASSIGN )
			// InternalParser.g:23750:17: RULE_SKW_OR RULE_SKW_ASSIGN
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
			// InternalParser.g:23752:12: ( RULE_SKW_MINUS RULE_SKW_GREATER )
			// InternalParser.g:23752:14: RULE_SKW_MINUS RULE_SKW_GREATER
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
			// InternalParser.g:23754:15: ( RULE_SKW_DOT RULE_SKW_DOT RULE_SKW_DOT )
			// InternalParser.g:23754:17: RULE_SKW_DOT RULE_SKW_DOT RULE_SKW_DOT
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
			// InternalParser.g:23756:20: ( '#' (~ ( RULE_NEWLINE ) | RULE_SKW_BACKSLASH RULE_NEWLINE )* )
			// InternalParser.g:23756:22: '#' (~ ( RULE_NEWLINE ) | RULE_SKW_BACKSLASH RULE_NEWLINE )*
			{
			match('#'); 
			// InternalParser.g:23756:26: (~ ( RULE_NEWLINE ) | RULE_SKW_BACKSLASH RULE_NEWLINE )*
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
					// InternalParser.g:23756:27: ~ ( RULE_NEWLINE )
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
					// InternalParser.g:23756:43: RULE_SKW_BACKSLASH RULE_NEWLINE
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
			// InternalParser.g:23758:17: ( ( ' ' | '\\t' )+ )
			// InternalParser.g:23758:19: ( ' ' | '\\t' )+
			{
			// InternalParser.g:23758:19: ( ' ' | '\\t' )+
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
			// InternalParser.g:23760:14: ( '&' )
			// InternalParser.g:23760:16: '&'
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
			// InternalParser.g:23762:17: ( RULE_SKW_AND RULE_SKW_AND )
			// InternalParser.g:23762:19: RULE_SKW_AND RULE_SKW_AND
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
			// InternalParser.g:23764:17: ( '=' )
			// InternalParser.g:23764:19: '='
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
			// InternalParser.g:23766:20: ( '\\\\' )
			// InternalParser.g:23766:22: '\\\\'
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
			// InternalParser.g:23768:16: ( '^' )
			// InternalParser.g:23768:18: '^'
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
			// InternalParser.g:23770:16: ( ',' )
			// InternalParser.g:23770:18: ','
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
			// InternalParser.g:23772:16: ( ':' )
			// InternalParser.g:23772:18: ':'
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
			// InternalParser.g:23774:14: ( '/' )
			// InternalParser.g:23774:16: '/'
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
			// InternalParser.g:23776:26: ( '$' )
			// InternalParser.g:23776:28: '$'
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
			// InternalParser.g:23778:14: ( '.' )
			// InternalParser.g:23778:16: '.'
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
			// InternalParser.g:23780:22: ( '\"' )
			// InternalParser.g:23780:24: '\"'
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
			// InternalParser.g:23782:16: ( RULE_SKW_ASSIGN RULE_SKW_ASSIGN )
			// InternalParser.g:23782:18: RULE_SKW_ASSIGN RULE_SKW_ASSIGN
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
			// InternalParser.g:23784:18: ( '>' )
			// InternalParser.g:23784:20: '>'
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
			// InternalParser.g:23786:23: ( RULE_SKW_GREATER RULE_SKW_ASSIGN )
			// InternalParser.g:23786:25: RULE_SKW_GREATER RULE_SKW_ASSIGN
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
			// InternalParser.g:23788:20: ( '{' )
			// InternalParser.g:23788:22: '{'
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
			// InternalParser.g:23790:22: ( '[' )
			// InternalParser.g:23790:24: '['
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
			// InternalParser.g:23792:20: ( '(' )
			// InternalParser.g:23792:22: '('
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
			// InternalParser.g:23794:20: ( RULE_SKW_LESS RULE_SKW_LESS )
			// InternalParser.g:23794:22: RULE_SKW_LESS RULE_SKW_LESS
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
			// InternalParser.g:23796:15: ( '<' )
			// InternalParser.g:23796:17: '<'
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
			// InternalParser.g:23798:20: ( RULE_SKW_LESS RULE_SKW_ASSIGN )
			// InternalParser.g:23798:22: RULE_SKW_LESS RULE_SKW_ASSIGN
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
			// InternalParser.g:23800:16: ( '-' )
			// InternalParser.g:23800:18: '-'
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
			// InternalParser.g:23802:21: ( RULE_SKW_MINUS RULE_SKW_MINUS )
			// InternalParser.g:23802:23: RULE_SKW_MINUS RULE_SKW_MINUS
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
			// InternalParser.g:23804:14: ( '%' )
			// InternalParser.g:23804:16: '%'
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
			// InternalParser.g:23806:14: ( '!' )
			// InternalParser.g:23806:16: '!'
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
			// InternalParser.g:23808:19: ( RULE_SKW_NOT RULE_SKW_ASSIGN )
			// InternalParser.g:23808:21: RULE_SKW_NOT RULE_SKW_ASSIGN
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
			// InternalParser.g:23810:13: ( '|' )
			// InternalParser.g:23810:15: '|'
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
			// InternalParser.g:23812:15: ( RULE_SKW_OR RULE_SKW_OR )
			// InternalParser.g:23812:17: RULE_SKW_OR RULE_SKW_OR
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
			// InternalParser.g:23814:15: ( '+' )
			// InternalParser.g:23814:17: '+'
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
			// InternalParser.g:23816:19: ( RULE_SKW_PLUS RULE_SKW_PLUS )
			// InternalParser.g:23816:21: RULE_SKW_PLUS RULE_SKW_PLUS
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
			// InternalParser.g:23818:19: ( '?' )
			// InternalParser.g:23818:21: '?'
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
			// InternalParser.g:23820:21: ( '}' )
			// InternalParser.g:23820:23: '}'
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
			// InternalParser.g:23822:23: ( ']' )
			// InternalParser.g:23822:25: ']'
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
			// InternalParser.g:23824:21: ( ')' )
			// InternalParser.g:23824:23: ')'
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
			// InternalParser.g:23826:21: ( RULE_SKW_GREATER RULE_SKW_GREATER )
			// InternalParser.g:23826:23: RULE_SKW_GREATER RULE_SKW_GREATER
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
			// InternalParser.g:23828:15: ( ';' )
			// InternalParser.g:23828:17: ';'
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
			// InternalParser.g:23830:22: ( '\\'' )
			// InternalParser.g:23830:24: '\\''
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
			// InternalParser.g:23832:15: ( '*' )
			// InternalParser.g:23832:17: '*'
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
			// InternalParser.g:23834:16: ( '~' )
			// InternalParser.g:23834:18: '~'
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
			// InternalParser.g:23836:30: ( '_' )
			// InternalParser.g:23836:32: '_'
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
			// InternalParser.g:23838:9: ( RULE_IDENTIFIER )
			// InternalParser.g:23838:11: RULE_IDENTIFIER
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
			// InternalParser.g:23840:26: ( RULE_LETTER ( RULE_LETTER | '0' .. '9' )* )
			// InternalParser.g:23840:28: RULE_LETTER ( RULE_LETTER | '0' .. '9' )*
			{
			mRULE_LETTER(); 

			// InternalParser.g:23840:40: ( RULE_LETTER | '0' .. '9' )*
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
			// InternalParser.g:23842:22: ( ( RULE_SKW_DOLLAR | 'A' .. 'Z' | 'a' .. 'z' | RULE_SKW_UNDERSCORE ) )
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
			// InternalParser.g:23844:19: ( RULE_SKW_SINGLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) ) RULE_SKW_SINGLEQUOTE )
			// InternalParser.g:23844:21: RULE_SKW_SINGLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) ) RULE_SKW_SINGLEQUOTE
			{
			mRULE_SKW_SINGLEQUOTE(); 

			// InternalParser.g:23844:42: ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) )
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
					// InternalParser.g:23844:43: RULE_ESCAPE_SEQUENCE
					{
					mRULE_ESCAPE_SEQUENCE(); 

					}
					break;
				case 2 :
					// InternalParser.g:23844:64: ~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) )
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
			// InternalParser.g:23846:21: ( RULE_SKW_DOUBLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) )* RULE_SKW_DOUBLEQUOTE )
			// InternalParser.g:23846:23: RULE_SKW_DOUBLEQUOTE ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) )* RULE_SKW_DOUBLEQUOTE
			{
			mRULE_SKW_DOUBLEQUOTE(); 

			// InternalParser.g:23846:44: ( RULE_ESCAPE_SEQUENCE |~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) )*
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
					// InternalParser.g:23846:45: RULE_ESCAPE_SEQUENCE
					{
					mRULE_ESCAPE_SEQUENCE(); 

					}
					break;
				case 2 :
					// InternalParser.g:23846:66: ~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) )
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
			// InternalParser.g:23848:18: ( '0' ( 'x' | 'X' ) ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )? )
			// InternalParser.g:23848:20: '0' ( 'x' | 'X' ) ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )?
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
			// InternalParser.g:23848:34: ( RULE_HEX_DIGIT )+
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

			// InternalParser.g:23848:50: ( RULE_INTEGER_TYPE_SUFFIX )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0=='L'||LA7_0=='U'||LA7_0=='l'||LA7_0=='u') ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// InternalParser.g:23848:50: RULE_INTEGER_TYPE_SUFFIX
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
			// InternalParser.g:23850:22: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( RULE_INTEGER_TYPE_SUFFIX )? )
			// InternalParser.g:23850:24: ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( RULE_INTEGER_TYPE_SUFFIX )?
			{
			// InternalParser.g:23850:24: ( '0' | '1' .. '9' ( '0' .. '9' )* )
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
					// InternalParser.g:23850:25: '0'
					{
					match('0'); 
					}
					break;
				case 2 :
					// InternalParser.g:23850:29: '1' .. '9' ( '0' .. '9' )*
					{
					matchRange('1','9'); 
					// InternalParser.g:23850:38: ( '0' .. '9' )*
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

			// InternalParser.g:23850:51: ( RULE_INTEGER_TYPE_SUFFIX )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='L'||LA10_0=='U'||LA10_0=='l'||LA10_0=='u') ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// InternalParser.g:23850:51: RULE_INTEGER_TYPE_SUFFIX
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
			// InternalParser.g:23852:20: ( '0' ( '0' .. '7' )+ ( RULE_INTEGER_TYPE_SUFFIX )? )
			// InternalParser.g:23852:22: '0' ( '0' .. '7' )+ ( RULE_INTEGER_TYPE_SUFFIX )?
			{
			match('0'); 
			// InternalParser.g:23852:26: ( '0' .. '7' )+
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

			// InternalParser.g:23852:38: ( RULE_INTEGER_TYPE_SUFFIX )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0=='L'||LA12_0=='U'||LA12_0=='l'||LA12_0=='u') ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// InternalParser.g:23852:38: RULE_INTEGER_TYPE_SUFFIX
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
			// InternalParser.g:23854:18: ( ( '0b' | '0B' ) ( '0' .. '1' )+ )
			// InternalParser.g:23854:20: ( '0b' | '0B' ) ( '0' .. '1' )+
			{
			// InternalParser.g:23854:20: ( '0b' | '0B' )
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
					// InternalParser.g:23854:21: '0b'
					{
					match("0b"); 

					}
					break;
				case 2 :
					// InternalParser.g:23854:26: '0B'
					{
					match("0B"); 

					}
					break;

			}

			// InternalParser.g:23854:32: ( '0' .. '1' )+
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
			// InternalParser.g:23856:25: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
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
			// InternalParser.g:23858:35: ( ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? ) )
			// InternalParser.g:23858:37: ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? )
			{
			// InternalParser.g:23858:37: ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? )
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
					// InternalParser.g:23858:38: ( 'u' | 'U' )? ( 'l' | 'L' )
					{
					// InternalParser.g:23858:38: ( 'u' | 'U' )?
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
					// InternalParser.g:23858:59: ( 'u' | 'U' ) ( 'l' | 'L' )?
					{
					if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// InternalParser.g:23858:69: ( 'l' | 'L' )?
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
			// InternalParser.g:23860:20: ( ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX ) )
			// InternalParser.g:23860:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )
			{
			// InternalParser.g:23860:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )
			int alt29=4;
			alt29 = dfa29.predict(input);
			switch (alt29) {
				case 1 :
					// InternalParser.g:23860:23: ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )?
					{
					// InternalParser.g:23860:23: ( '0' .. '9' )+
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

					// InternalParser.g:23860:48: ( '0' .. '9' )*
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

					// InternalParser.g:23860:60: ( RULE_EXPONENT )?
					int alt20=2;
					int LA20_0 = input.LA(1);
					if ( (LA20_0=='E'||LA20_0=='e') ) {
						alt20=1;
					}
					switch (alt20) {
						case 1 :
							// InternalParser.g:23860:60: RULE_EXPONENT
							{
							mRULE_EXPONENT(); 

							}
							break;

					}

					// InternalParser.g:23860:75: ( RULE_FLOAT_TYPE_SUFFIX )?
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
					// InternalParser.g:23860:99: RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )?
					{
					mRULE_SKW_DOT(); 

					// InternalParser.g:23860:112: ( '0' .. '9' )+
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

					// InternalParser.g:23860:124: ( RULE_EXPONENT )?
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0=='E'||LA23_0=='e') ) {
						alt23=1;
					}
					switch (alt23) {
						case 1 :
							// InternalParser.g:23860:124: RULE_EXPONENT
							{
							mRULE_EXPONENT(); 

							}
							break;

					}

					// InternalParser.g:23860:139: ( RULE_FLOAT_TYPE_SUFFIX )?
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
					// InternalParser.g:23860:163: ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )?
					{
					// InternalParser.g:23860:163: ( '0' .. '9' )+
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

					// InternalParser.g:23860:189: ( RULE_FLOAT_TYPE_SUFFIX )?
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
					// InternalParser.g:23860:213: ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX
					{
					// InternalParser.g:23860:213: ( '0' .. '9' )+
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

					// InternalParser.g:23860:225: ( RULE_EXPONENT )?
					int alt28=2;
					int LA28_0 = input.LA(1);
					if ( (LA28_0=='E'||LA28_0=='e') ) {
						alt28=1;
					}
					switch (alt28) {
						case 1 :
							// InternalParser.g:23860:225: RULE_EXPONENT
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
			// InternalParser.g:23862:24: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
			// InternalParser.g:23862:26: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// InternalParser.g:23862:36: ( '+' | '-' )?
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

			// InternalParser.g:23862:47: ( '0' .. '9' )+
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
			// InternalParser.g:23864:33: ( ( 'f' | 'F' | 'd' | 'D' ) )
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
			// InternalParser.g:23866:31: ( ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE | RULE_HEX_ESCAPE ) )
			// InternalParser.g:23866:33: ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE | RULE_HEX_ESCAPE )
			{
			// InternalParser.g:23866:33: ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE | RULE_HEX_ESCAPE )
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
					// InternalParser.g:23866:34: RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH )
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
					// InternalParser.g:23866:119: RULE_OCTAL_ESCAPE
					{
					mRULE_OCTAL_ESCAPE(); 

					}
					break;
				case 3 :
					// InternalParser.g:23866:137: RULE_HEX_ESCAPE
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
			// InternalParser.g:23868:28: ( ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' ) )
			// InternalParser.g:23868:30: ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' )
			{
			// InternalParser.g:23868:30: ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' )
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
					// InternalParser.g:23868:31: RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7'
					{
					mRULE_SKW_BACKSLASH(); 

					matchRange('0','3'); 
					matchRange('0','7'); 
					matchRange('0','7'); 
					}
					break;
				case 2 :
					// InternalParser.g:23868:77: RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7'
					{
					mRULE_SKW_BACKSLASH(); 

					matchRange('0','7'); 
					matchRange('0','7'); 
					}
					break;
				case 3 :
					// InternalParser.g:23868:114: RULE_SKW_BACKSLASH '0' .. '7'
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
			// InternalParser.g:23870:26: ( RULE_SKW_BACKSLASH 'x' ( RULE_HEX_DIGIT )+ )
			// InternalParser.g:23870:28: RULE_SKW_BACKSLASH 'x' ( RULE_HEX_DIGIT )+
			{
			mRULE_SKW_BACKSLASH(); 

			match('x'); 
			// InternalParser.g:23870:51: ( RULE_HEX_DIGIT )+
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
			// InternalParser.g:23872:24: ( '\\n' )
			// InternalParser.g:23872:26: '\\n'
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
			// InternalParser.g:23874:30: ( '\\r' )
			// InternalParser.g:23874:32: '\\r'
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
			// InternalParser.g:23876:24: ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) )
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
			// InternalParser.g:23878:16: ( RULE_SKW_BACKSLASH RULE_LINE_END )
			// InternalParser.g:23878:18: RULE_SKW_BACKSLASH RULE_LINE_END
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
			// InternalParser.g:23880:14: ( RULE_LINE_END )
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
			// InternalParser.g:23882:21: ( ' ' )
			// InternalParser.g:23882:23: ' '
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
			// InternalParser.g:23884:19: ( '\\t' )
			// InternalParser.g:23884:21: '\\t'
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
			// InternalParser.g:23886:20: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// InternalParser.g:23886:22: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// InternalParser.g:23886:27: ( options {greedy=false; } : . )*
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
					// InternalParser.g:23886:55: .
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
			// InternalParser.g:23888:19: ( '//' (~ ( RULE_LINE_END ) )* )
			// InternalParser.g:23888:21: '//' (~ ( RULE_LINE_END ) )*
			{
			match("//"); 

			// InternalParser.g:23888:26: (~ ( RULE_LINE_END ) )*
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
			// InternalParser.g:23890:14: ( . )
			// InternalParser.g:23890:16: .
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
		// InternalParser.g:1:8: ( RULE_KW_ATOMIC | RULE_KW_ATTRIBUTE | RULE_KW_AUTO | RULE_KW_ALIGNAS | RULE_KW_ALIGNOF | RULE_KW_ASM1 | RULE_KW_ASM2 | RULE_KW_ASM3 | RULE_KW_BOOL | RULE_KW_BREAK | RULE_KW_BUILTIN_VA_LIST | RULE_KW_CASE | RULE_KW_CHAR | RULE_KW_COMPLEX | RULE_KW_CONST | RULE_KW_CONTINUE | RULE_KW_DEFAULT | RULE_KW_DO | RULE_KW_DOUBLE | RULE_KW_ELSE | RULE_KW_ENUM | RULE_KW_EXTERN | RULE_KW_FLOAT | RULE_KW_FOR | RULE_KW_GENERIC | RULE_KW_GOTO | RULE_KW_IF | RULE_KW_IMAGINARY | RULE_KW_INLINE1 | RULE_KW_INLINE2 | RULE_KW_INT | RULE_KW_LONG | RULE_KW_M128 | RULE_KW_M128D | RULE_KW_M128I | RULE_KW_NORETURN | RULE_KW_PRAGMA | RULE_KW_REGISTER | RULE_KW_RESTRICT | RULE_KW_RESTRICT2 | RULE_KW_RESTRICT3 | RULE_KW_RETURN | RULE_KW_SHORT | RULE_KW_SIGNED | RULE_KW_SIZEOF | RULE_KW_STATIC | RULE_KW_STATICASSERT | RULE_KW_STRUCT | RULE_KW_SWITCH | RULE_KW_THREADLOCAL | RULE_KW_TYPEDEF | RULE_KW_UNION | RULE_KW_UNSIGNED | RULE_KW_VOID | RULE_KW_VOLATILE | RULE_KW_VOLATILE2 | RULE_KW_WHILE | RULE_STARASSIGN | RULE_DIVASSIGN | RULE_MODASSIGN | RULE_PLUSASSIGN | RULE_MINUSASSIGN | RULE_LEFTSHIFTASSIGN | RULE_RIGHTSHIFTASSIGN | RULE_ANDASSIGN | RULE_XORASSIGN | RULE_ORASSIGN | RULE_ARROW | RULE_ELLIPSIS | RULE_LINEDIRECTIVE | RULE_WHITESPACE | RULE_SKW_AND | RULE_SKW_ANDAND | RULE_SKW_ASSIGN | RULE_SKW_BACKSLASH | RULE_SKW_CARET | RULE_SKW_COMMA | RULE_SKW_COLON | RULE_SKW_DIV | RULE_SKW_DOT | RULE_SKW_DOUBLEQUOTE | RULE_SKW_EQUAL | RULE_SKW_GREATER | RULE_SKW_GREATEREQUAL | RULE_SKW_LEFTBRACE | RULE_SKW_LEFTBRACKET | RULE_SKW_LEFTPAREN | RULE_SKW_LEFTSHIFT | RULE_SKW_LESS | RULE_SKW_LESSEQUAL | RULE_SKW_MINUS | RULE_SKW_MINUSMINUS | RULE_SKW_MOD | RULE_SKW_NOT | RULE_SKW_NOTEQUAL | RULE_SKW_OR | RULE_SKW_OROR | RULE_SKW_PLUS | RULE_SKW_PLUSPLUS | RULE_SKW_QUESTION | RULE_SKW_RIGHTBRACE | RULE_SKW_RIGHTBRACKET | RULE_SKW_RIGHTPAREN | RULE_SKW_RIGHTSHIFT | RULE_SKW_SEMI | RULE_SKW_SINGLEQUOTE | RULE_SKW_STAR | RULE_SKW_TILDE | RULE_ID | RULE_CHAR_LITERAL | RULE_STRING_LITERAL | RULE_HEX_LITERAL | RULE_DECIMAL_LITERAL | RULE_OCTAL_LITERAL | RULE_BIN_LITERAL | RULE_FLOAT_LITERAL | RULE_LINEBREAK | RULE_NEWLINE | RULE_BLOCK_COMMENT | RULE_LINE_COMMENT | RULE_SPECIAL )
		int alt37=121;
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
				// InternalParser.g:1:306: RULE_KW_ENUM
				{
				mRULE_KW_ENUM(); 

				}
				break;
			case 22 :
				// InternalParser.g:1:319: RULE_KW_EXTERN
				{
				mRULE_KW_EXTERN(); 

				}
				break;
			case 23 :
				// InternalParser.g:1:334: RULE_KW_FLOAT
				{
				mRULE_KW_FLOAT(); 

				}
				break;
			case 24 :
				// InternalParser.g:1:348: RULE_KW_FOR
				{
				mRULE_KW_FOR(); 

				}
				break;
			case 25 :
				// InternalParser.g:1:360: RULE_KW_GENERIC
				{
				mRULE_KW_GENERIC(); 

				}
				break;
			case 26 :
				// InternalParser.g:1:376: RULE_KW_GOTO
				{
				mRULE_KW_GOTO(); 

				}
				break;
			case 27 :
				// InternalParser.g:1:389: RULE_KW_IF
				{
				mRULE_KW_IF(); 

				}
				break;
			case 28 :
				// InternalParser.g:1:400: RULE_KW_IMAGINARY
				{
				mRULE_KW_IMAGINARY(); 

				}
				break;
			case 29 :
				// InternalParser.g:1:418: RULE_KW_INLINE1
				{
				mRULE_KW_INLINE1(); 

				}
				break;
			case 30 :
				// InternalParser.g:1:434: RULE_KW_INLINE2
				{
				mRULE_KW_INLINE2(); 

				}
				break;
			case 31 :
				// InternalParser.g:1:450: RULE_KW_INT
				{
				mRULE_KW_INT(); 

				}
				break;
			case 32 :
				// InternalParser.g:1:462: RULE_KW_LONG
				{
				mRULE_KW_LONG(); 

				}
				break;
			case 33 :
				// InternalParser.g:1:475: RULE_KW_M128
				{
				mRULE_KW_M128(); 

				}
				break;
			case 34 :
				// InternalParser.g:1:488: RULE_KW_M128D
				{
				mRULE_KW_M128D(); 

				}
				break;
			case 35 :
				// InternalParser.g:1:502: RULE_KW_M128I
				{
				mRULE_KW_M128I(); 

				}
				break;
			case 36 :
				// InternalParser.g:1:516: RULE_KW_NORETURN
				{
				mRULE_KW_NORETURN(); 

				}
				break;
			case 37 :
				// InternalParser.g:1:533: RULE_KW_PRAGMA
				{
				mRULE_KW_PRAGMA(); 

				}
				break;
			case 38 :
				// InternalParser.g:1:548: RULE_KW_REGISTER
				{
				mRULE_KW_REGISTER(); 

				}
				break;
			case 39 :
				// InternalParser.g:1:565: RULE_KW_RESTRICT
				{
				mRULE_KW_RESTRICT(); 

				}
				break;
			case 40 :
				// InternalParser.g:1:582: RULE_KW_RESTRICT2
				{
				mRULE_KW_RESTRICT2(); 

				}
				break;
			case 41 :
				// InternalParser.g:1:600: RULE_KW_RESTRICT3
				{
				mRULE_KW_RESTRICT3(); 

				}
				break;
			case 42 :
				// InternalParser.g:1:618: RULE_KW_RETURN
				{
				mRULE_KW_RETURN(); 

				}
				break;
			case 43 :
				// InternalParser.g:1:633: RULE_KW_SHORT
				{
				mRULE_KW_SHORT(); 

				}
				break;
			case 44 :
				// InternalParser.g:1:647: RULE_KW_SIGNED
				{
				mRULE_KW_SIGNED(); 

				}
				break;
			case 45 :
				// InternalParser.g:1:662: RULE_KW_SIZEOF
				{
				mRULE_KW_SIZEOF(); 

				}
				break;
			case 46 :
				// InternalParser.g:1:677: RULE_KW_STATIC
				{
				mRULE_KW_STATIC(); 

				}
				break;
			case 47 :
				// InternalParser.g:1:692: RULE_KW_STATICASSERT
				{
				mRULE_KW_STATICASSERT(); 

				}
				break;
			case 48 :
				// InternalParser.g:1:713: RULE_KW_STRUCT
				{
				mRULE_KW_STRUCT(); 

				}
				break;
			case 49 :
				// InternalParser.g:1:728: RULE_KW_SWITCH
				{
				mRULE_KW_SWITCH(); 

				}
				break;
			case 50 :
				// InternalParser.g:1:743: RULE_KW_THREADLOCAL
				{
				mRULE_KW_THREADLOCAL(); 

				}
				break;
			case 51 :
				// InternalParser.g:1:763: RULE_KW_TYPEDEF
				{
				mRULE_KW_TYPEDEF(); 

				}
				break;
			case 52 :
				// InternalParser.g:1:779: RULE_KW_UNION
				{
				mRULE_KW_UNION(); 

				}
				break;
			case 53 :
				// InternalParser.g:1:793: RULE_KW_UNSIGNED
				{
				mRULE_KW_UNSIGNED(); 

				}
				break;
			case 54 :
				// InternalParser.g:1:810: RULE_KW_VOID
				{
				mRULE_KW_VOID(); 

				}
				break;
			case 55 :
				// InternalParser.g:1:823: RULE_KW_VOLATILE
				{
				mRULE_KW_VOLATILE(); 

				}
				break;
			case 56 :
				// InternalParser.g:1:840: RULE_KW_VOLATILE2
				{
				mRULE_KW_VOLATILE2(); 

				}
				break;
			case 57 :
				// InternalParser.g:1:858: RULE_KW_WHILE
				{
				mRULE_KW_WHILE(); 

				}
				break;
			case 58 :
				// InternalParser.g:1:872: RULE_STARASSIGN
				{
				mRULE_STARASSIGN(); 

				}
				break;
			case 59 :
				// InternalParser.g:1:888: RULE_DIVASSIGN
				{
				mRULE_DIVASSIGN(); 

				}
				break;
			case 60 :
				// InternalParser.g:1:903: RULE_MODASSIGN
				{
				mRULE_MODASSIGN(); 

				}
				break;
			case 61 :
				// InternalParser.g:1:918: RULE_PLUSASSIGN
				{
				mRULE_PLUSASSIGN(); 

				}
				break;
			case 62 :
				// InternalParser.g:1:934: RULE_MINUSASSIGN
				{
				mRULE_MINUSASSIGN(); 

				}
				break;
			case 63 :
				// InternalParser.g:1:951: RULE_LEFTSHIFTASSIGN
				{
				mRULE_LEFTSHIFTASSIGN(); 

				}
				break;
			case 64 :
				// InternalParser.g:1:972: RULE_RIGHTSHIFTASSIGN
				{
				mRULE_RIGHTSHIFTASSIGN(); 

				}
				break;
			case 65 :
				// InternalParser.g:1:994: RULE_ANDASSIGN
				{
				mRULE_ANDASSIGN(); 

				}
				break;
			case 66 :
				// InternalParser.g:1:1009: RULE_XORASSIGN
				{
				mRULE_XORASSIGN(); 

				}
				break;
			case 67 :
				// InternalParser.g:1:1024: RULE_ORASSIGN
				{
				mRULE_ORASSIGN(); 

				}
				break;
			case 68 :
				// InternalParser.g:1:1038: RULE_ARROW
				{
				mRULE_ARROW(); 

				}
				break;
			case 69 :
				// InternalParser.g:1:1049: RULE_ELLIPSIS
				{
				mRULE_ELLIPSIS(); 

				}
				break;
			case 70 :
				// InternalParser.g:1:1063: RULE_LINEDIRECTIVE
				{
				mRULE_LINEDIRECTIVE(); 

				}
				break;
			case 71 :
				// InternalParser.g:1:1082: RULE_WHITESPACE
				{
				mRULE_WHITESPACE(); 

				}
				break;
			case 72 :
				// InternalParser.g:1:1098: RULE_SKW_AND
				{
				mRULE_SKW_AND(); 

				}
				break;
			case 73 :
				// InternalParser.g:1:1111: RULE_SKW_ANDAND
				{
				mRULE_SKW_ANDAND(); 

				}
				break;
			case 74 :
				// InternalParser.g:1:1127: RULE_SKW_ASSIGN
				{
				mRULE_SKW_ASSIGN(); 

				}
				break;
			case 75 :
				// InternalParser.g:1:1143: RULE_SKW_BACKSLASH
				{
				mRULE_SKW_BACKSLASH(); 

				}
				break;
			case 76 :
				// InternalParser.g:1:1162: RULE_SKW_CARET
				{
				mRULE_SKW_CARET(); 

				}
				break;
			case 77 :
				// InternalParser.g:1:1177: RULE_SKW_COMMA
				{
				mRULE_SKW_COMMA(); 

				}
				break;
			case 78 :
				// InternalParser.g:1:1192: RULE_SKW_COLON
				{
				mRULE_SKW_COLON(); 

				}
				break;
			case 79 :
				// InternalParser.g:1:1207: RULE_SKW_DIV
				{
				mRULE_SKW_DIV(); 

				}
				break;
			case 80 :
				// InternalParser.g:1:1220: RULE_SKW_DOT
				{
				mRULE_SKW_DOT(); 

				}
				break;
			case 81 :
				// InternalParser.g:1:1233: RULE_SKW_DOUBLEQUOTE
				{
				mRULE_SKW_DOUBLEQUOTE(); 

				}
				break;
			case 82 :
				// InternalParser.g:1:1254: RULE_SKW_EQUAL
				{
				mRULE_SKW_EQUAL(); 

				}
				break;
			case 83 :
				// InternalParser.g:1:1269: RULE_SKW_GREATER
				{
				mRULE_SKW_GREATER(); 

				}
				break;
			case 84 :
				// InternalParser.g:1:1286: RULE_SKW_GREATEREQUAL
				{
				mRULE_SKW_GREATEREQUAL(); 

				}
				break;
			case 85 :
				// InternalParser.g:1:1308: RULE_SKW_LEFTBRACE
				{
				mRULE_SKW_LEFTBRACE(); 

				}
				break;
			case 86 :
				// InternalParser.g:1:1327: RULE_SKW_LEFTBRACKET
				{
				mRULE_SKW_LEFTBRACKET(); 

				}
				break;
			case 87 :
				// InternalParser.g:1:1348: RULE_SKW_LEFTPAREN
				{
				mRULE_SKW_LEFTPAREN(); 

				}
				break;
			case 88 :
				// InternalParser.g:1:1367: RULE_SKW_LEFTSHIFT
				{
				mRULE_SKW_LEFTSHIFT(); 

				}
				break;
			case 89 :
				// InternalParser.g:1:1386: RULE_SKW_LESS
				{
				mRULE_SKW_LESS(); 

				}
				break;
			case 90 :
				// InternalParser.g:1:1400: RULE_SKW_LESSEQUAL
				{
				mRULE_SKW_LESSEQUAL(); 

				}
				break;
			case 91 :
				// InternalParser.g:1:1419: RULE_SKW_MINUS
				{
				mRULE_SKW_MINUS(); 

				}
				break;
			case 92 :
				// InternalParser.g:1:1434: RULE_SKW_MINUSMINUS
				{
				mRULE_SKW_MINUSMINUS(); 

				}
				break;
			case 93 :
				// InternalParser.g:1:1454: RULE_SKW_MOD
				{
				mRULE_SKW_MOD(); 

				}
				break;
			case 94 :
				// InternalParser.g:1:1467: RULE_SKW_NOT
				{
				mRULE_SKW_NOT(); 

				}
				break;
			case 95 :
				// InternalParser.g:1:1480: RULE_SKW_NOTEQUAL
				{
				mRULE_SKW_NOTEQUAL(); 

				}
				break;
			case 96 :
				// InternalParser.g:1:1498: RULE_SKW_OR
				{
				mRULE_SKW_OR(); 

				}
				break;
			case 97 :
				// InternalParser.g:1:1510: RULE_SKW_OROR
				{
				mRULE_SKW_OROR(); 

				}
				break;
			case 98 :
				// InternalParser.g:1:1524: RULE_SKW_PLUS
				{
				mRULE_SKW_PLUS(); 

				}
				break;
			case 99 :
				// InternalParser.g:1:1538: RULE_SKW_PLUSPLUS
				{
				mRULE_SKW_PLUSPLUS(); 

				}
				break;
			case 100 :
				// InternalParser.g:1:1556: RULE_SKW_QUESTION
				{
				mRULE_SKW_QUESTION(); 

				}
				break;
			case 101 :
				// InternalParser.g:1:1574: RULE_SKW_RIGHTBRACE
				{
				mRULE_SKW_RIGHTBRACE(); 

				}
				break;
			case 102 :
				// InternalParser.g:1:1594: RULE_SKW_RIGHTBRACKET
				{
				mRULE_SKW_RIGHTBRACKET(); 

				}
				break;
			case 103 :
				// InternalParser.g:1:1616: RULE_SKW_RIGHTPAREN
				{
				mRULE_SKW_RIGHTPAREN(); 

				}
				break;
			case 104 :
				// InternalParser.g:1:1636: RULE_SKW_RIGHTSHIFT
				{
				mRULE_SKW_RIGHTSHIFT(); 

				}
				break;
			case 105 :
				// InternalParser.g:1:1656: RULE_SKW_SEMI
				{
				mRULE_SKW_SEMI(); 

				}
				break;
			case 106 :
				// InternalParser.g:1:1670: RULE_SKW_SINGLEQUOTE
				{
				mRULE_SKW_SINGLEQUOTE(); 

				}
				break;
			case 107 :
				// InternalParser.g:1:1691: RULE_SKW_STAR
				{
				mRULE_SKW_STAR(); 

				}
				break;
			case 108 :
				// InternalParser.g:1:1705: RULE_SKW_TILDE
				{
				mRULE_SKW_TILDE(); 

				}
				break;
			case 109 :
				// InternalParser.g:1:1720: RULE_ID
				{
				mRULE_ID(); 

				}
				break;
			case 110 :
				// InternalParser.g:1:1728: RULE_CHAR_LITERAL
				{
				mRULE_CHAR_LITERAL(); 

				}
				break;
			case 111 :
				// InternalParser.g:1:1746: RULE_STRING_LITERAL
				{
				mRULE_STRING_LITERAL(); 

				}
				break;
			case 112 :
				// InternalParser.g:1:1766: RULE_HEX_LITERAL
				{
				mRULE_HEX_LITERAL(); 

				}
				break;
			case 113 :
				// InternalParser.g:1:1783: RULE_DECIMAL_LITERAL
				{
				mRULE_DECIMAL_LITERAL(); 

				}
				break;
			case 114 :
				// InternalParser.g:1:1804: RULE_OCTAL_LITERAL
				{
				mRULE_OCTAL_LITERAL(); 

				}
				break;
			case 115 :
				// InternalParser.g:1:1823: RULE_BIN_LITERAL
				{
				mRULE_BIN_LITERAL(); 

				}
				break;
			case 116 :
				// InternalParser.g:1:1840: RULE_FLOAT_LITERAL
				{
				mRULE_FLOAT_LITERAL(); 

				}
				break;
			case 117 :
				// InternalParser.g:1:1859: RULE_LINEBREAK
				{
				mRULE_LINEBREAK(); 

				}
				break;
			case 118 :
				// InternalParser.g:1:1874: RULE_NEWLINE
				{
				mRULE_NEWLINE(); 

				}
				break;
			case 119 :
				// InternalParser.g:1:1887: RULE_BLOCK_COMMENT
				{
				mRULE_BLOCK_COMMENT(); 

				}
				break;
			case 120 :
				// InternalParser.g:1:1906: RULE_LINE_COMMENT
				{
				mRULE_LINE_COMMENT(); 

				}
				break;
			case 121 :
				// InternalParser.g:1:1924: RULE_SPECIAL
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
			return "23860:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )";
		}
	}


	static final String DFA37_eotS =
		"\1\uffff\21\64\1\131\1\135\1\137\1\141\1\144\1\150\1\153\1\156\1\161\1\163\1\166\2\uffff\1\173\1\175\2\uffff\1\u0081\3\uffff\1\u0086\5\uffff\1\u008d\2\uffff\2\u0092\3\uffff\20\64\1\u00ad\6\64\1\u00b4\14\64\20\uffff\1\u00c8\2\uffff\1\u00ca\46\uffff\1\u00cc\1\u0092\1\uffff\20\64\1\u00de\6\64\1\uffff\4\64\1\u00ea\1\64\1\uffff\1\64\1\u00ed\21\64\5\uffff\20\64\1\u010f\1\uffff\1\64\1\u0111\1\u0112\4\64\1\u0117\1\u0118\2\64\1\uffff\1\u011b\1\64\1\uffff\1\u011d\15\64\1\u012b\5\64\1\u0131\5\64\1\u0138\6\64\1\uffff\1\u013f\2\uffff\1\u0140\3\64\2\uffff\1\64\1\u0145\1\uffff\1\64\1\uffff\4\64\1\u014b\6\64\1\u0152\1\64\1\uffff\1\64\1\u0155\3\64\1\uffff\3\64\1\u015d\2\64\1\uffff\6\64\2\uffff\2\64\1\u016a\1\u016b\1\uffff\1\u016c\1\u016d\2\64\1\u0170\1\uffff\1\u0171\1\u0172\1\u0173\1\u0174\1\u0175\1\64\1\uffff\2\64\1\uffff\1\u0179\3\64\1\u017d\2\64\1\uffff\1\u0180\1\u0181\11\64\1\u018b\4\uffff\2\64\6\uffff\1\u018e\2\64\1\uffff\1\u0191\1\u0192\1\64\1\uffff\1\64\1\u0195\2\uffff\2\64\1\u0198\1\u0199\4\64\1\u019e\1\uffff\1\u019f\1\u01a0\1\uffff\1\u01a1\1\u01a2\2\uffff\2\64\1\uffff\2\64\2\uffff\1\64\1\u01a8\2\64\5\uffff\2\64\1\u01ad\1\64\1\u01b0\1\uffff\4\64\1\uffff\2\64\1\uffff\4\64\1\u01bb\1\u01bc\2\64\1\u01bf\1\64\2\uffff\1\64\1\u01c2\1\uffff\1\64\1\u01c4\1\uffff\1\64\1\uffff\1\64\1\u01c7\1\uffff";
	static final String DFA37_eofS =
		"\u01c8\uffff";
	static final String DFA37_minS =
		"\1\0\1\101\1\163\1\162\1\141\1\145\2\154\1\157\1\146\1\157\1\162\1\145\1\150\1\171\1\156\1\157\1\150\1\75\1\52\1\75\1\53\1\55\1\74\1\75\1\46\2\75\1\56\2\uffff\1\75\1\12\2\uffff\1\0\3\uffff\1\75\5\uffff\1\0\2\uffff\2\56\3\uffff\1\154\1\141\2\157\1\145\1\155\1\157\1\164\1\150\1\164\1\155\1\145\1\163\1\141\1\156\1\146\1\44\1\163\1\165\1\164\1\157\1\162\1\164\1\44\1\154\1\156\1\141\1\147\1\157\1\147\1\141\1\151\1\160\3\151\20\uffff\1\75\2\uffff\1\75\46\uffff\2\56\1\uffff\1\157\1\151\1\163\1\165\1\156\1\61\1\145\2\157\1\155\1\156\1\141\1\162\1\141\1\162\1\157\1\44\1\141\1\145\1\162\1\163\1\141\1\142\1\uffff\1\145\1\155\1\145\1\141\1\44\1\157\1\uffff\1\151\1\44\2\147\1\151\1\164\1\165\1\162\1\156\1\145\1\164\1\165\1\164\1\145\1\157\1\151\1\144\1\141\1\154\5\uffff\1\155\1\147\1\164\1\155\1\151\1\154\1\62\1\163\2\154\1\160\1\145\1\147\1\145\1\164\1\145\1\44\1\uffff\1\153\2\44\1\164\1\151\1\165\1\154\2\44\1\162\1\164\1\uffff\1\44\1\156\1\uffff\1\44\1\155\1\163\2\162\1\164\1\145\1\157\1\151\2\143\1\144\1\156\1\147\1\44\1\164\1\145\1\151\1\156\1\162\1\44\1\154\1\151\1\70\1\164\1\141\1\44\1\154\1\162\1\151\1\164\1\151\1\141\1\uffff\1\44\2\uffff\1\44\1\156\1\154\1\145\2\uffff\1\156\1\44\1\uffff\1\145\1\uffff\1\141\1\164\1\151\1\156\1\44\1\144\1\146\1\143\1\164\1\150\1\145\1\44\1\156\1\uffff\1\151\1\44\1\143\1\141\1\151\1\uffff\1\137\1\164\1\156\1\44\1\162\1\164\1\uffff\1\145\1\151\1\156\1\165\1\143\1\144\2\uffff\1\165\1\164\2\44\1\uffff\2\44\1\145\1\143\1\44\1\uffff\5\44\1\146\1\uffff\1\145\1\154\1\uffff\1\44\1\163\1\146\1\142\1\44\1\151\1\145\1\uffff\2\44\2\151\1\170\1\143\1\141\1\162\2\137\1\145\1\44\4\uffff\1\162\1\164\6\uffff\1\44\1\144\1\145\1\uffff\2\44\1\165\1\uffff\1\156\1\44\2\uffff\1\143\1\154\2\44\1\162\1\156\1\141\1\154\1\44\1\uffff\2\44\1\uffff\2\44\2\uffff\1\164\1\137\1\uffff\1\164\1\145\2\uffff\1\171\1\44\1\163\1\157\5\uffff\1\145\1\166\1\44\1\137\1\44\1\uffff\1\163\1\143\1\137\1\141\1\uffff\2\137\1\uffff\1\145\1\141\2\137\2\44\1\162\1\154\1\44\1\154\2\uffff\1\164\1\44\1\uffff\1\151\1\44\1\uffff\1\163\1\uffff\1\164\1\44\1\uffff";
	static final String DFA37_maxS =
		"\1\uffff\1\137\1\165\1\162\2\157\1\170\2\157\1\156\1\157\1\162\1\145\1\167\1\171\1\156\1\157\1\150\4\75\1\76\1\75\1\76\2\75\1\174\1\71\2\uffff\1\75\1\15\2\uffff\1\uffff\3\uffff\1\75\5\uffff\1\uffff\2\uffff\1\170\1\146\3\uffff\1\164\1\166\2\157\1\145\1\155\1\157\1\164\1\150\1\164\1\155\1\145\1\163\1\141\1\156\1\146\1\172\1\163\1\165\1\164\1\157\1\162\1\164\1\172\1\164\1\156\1\141\1\164\1\157\1\172\1\162\1\151\1\160\1\163\1\154\1\151\20\uffff\1\75\2\uffff\1\75\46\uffff\2\146\1\uffff\1\157\1\151\1\164\1\165\1\156\1\61\1\145\2\157\1\155\1\156\1\141\1\162\1\141\1\162\1\157\1\172\1\141\1\145\1\162\1\164\1\141\1\142\1\uffff\1\145\1\155\1\145\1\141\1\172\1\157\1\uffff\1\151\1\172\2\147\1\151\1\164\1\165\1\162\1\156\1\145\1\164\1\165\1\164\1\145\1\157\1\151\1\144\1\141\1\154\5\uffff\1\155\1\147\1\164\1\155\1\151\1\154\1\62\1\163\2\154\1\160\1\145\1\147\1\145\1\164\1\145\1\172\1\uffff\1\153\2\172\1\164\1\151\1\165\1\154\2\172\1\162\1\164\1\uffff\1\172\1\156\1\uffff\1\172\1\155\1\163\2\162\1\164\1\145\1\157\1\151\2\143\1\144\1\156\1\147\1\172\1\164\1\145\1\151\1\156\1\162\1\172\1\154\1\151\1\70\1\164\1\141\1\172\1\154\1\162\1\151\1\164\1\151\1\141\1\uffff\1\172\2\uffff\1\172\1\156\1\154\1\145\2\uffff\1\156\1\172\1\uffff\1\145\1\uffff\1\141\1\164\1\151\1\156\1\172\1\144\1\146\1\143\1\164\1\150\1\145\1\172\1\156\1\uffff\1\151\1\172\1\143\1\157\1\151\1\uffff\1\137\1\164\1\156\1\172\1\162\1\164\1\uffff\1\145\1\151\1\156\1\165\1\143\1\144\2\uffff\1\165\1\164\2\172\1\uffff\2\172\1\145\1\143\1\172\1\uffff\5\172\1\146\1\uffff\1\145\1\154\1\uffff\1\172\1\163\1\146\1\142\1\172\1\151\1\145\1\uffff\2\172\2\151\1\170\1\143\1\141\1\162\2\137\1\145\1\172\4\uffff\1\162\1\164\6\uffff\1\172\1\144\1\145\1\uffff\2\172\1\165\1\uffff\1\156\1\172\2\uffff\1\143\1\154\2\172\1\162\1\156\1\141\1\154\1\172\1\uffff\2\172\1\uffff\2\172\2\uffff\1\164\1\137\1\uffff\1\164\1\145\2\uffff\1\171\1\172\1\163\1\157\5\uffff\1\145\1\166\1\172\1\137\1\172\1\uffff\1\163\1\143\1\137\1\141\1\uffff\2\137\1\uffff\1\145\1\141\2\137\2\172\1\162\1\154\1\172\1\154\2\uffff\1\164\1\172\1\uffff\1\151\1\172\1\uffff\1\163\1\uffff\1\164\1\172\1\uffff";
	static final String DFA37_acceptS =
		"\35\uffff\1\106\1\107\2\uffff\1\115\1\116\1\uffff\1\125\1\126\1\127\1\uffff\1\144\1\145\1\146\1\147\1\151\1\uffff\1\154\1\155\2\uffff\1\166\1\171\1\155\44\uffff\1\153\1\72\1\167\1\170\1\117\1\73\1\135\1\74\1\142\1\75\1\143\1\133\1\76\1\104\1\134\1\131\1\uffff\1\132\1\123\1\uffff\1\124\1\110\1\101\1\111\1\114\1\102\1\140\1\103\1\141\1\120\1\105\1\164\1\106\1\107\1\112\1\122\1\113\1\165\1\115\1\116\1\121\1\157\1\125\1\126\1\127\1\136\1\137\1\144\1\145\1\146\1\147\1\151\1\152\1\156\1\154\1\160\1\163\1\161\2\uffff\1\166\27\uffff\1\22\6\uffff\1\33\23\uffff\1\130\1\77\1\150\1\100\1\162\21\uffff\1\6\13\uffff\1\30\2\uffff\1\37\41\uffff\1\3\1\uffff\1\14\1\15\4\uffff\1\24\1\25\2\uffff\1\32\1\uffff\1\40\15\uffff\1\66\5\uffff\1\7\6\uffff\1\11\6\uffff\1\12\1\17\4\uffff\1\27\5\uffff\1\53\6\uffff\1\64\2\uffff\1\71\7\uffff\1\41\14\uffff\1\23\1\26\1\35\1\45\2\uffff\1\52\1\54\1\55\1\56\1\60\1\61\3\uffff\1\1\3\uffff\1\10\2\uffff\1\42\1\43\11\uffff\1\21\2\uffff\1\63\2\uffff\1\4\1\5\2\uffff\1\36\2\uffff\1\16\1\31\4\uffff\1\20\1\46\1\47\1\65\1\67\5\uffff\1\44\4\uffff\1\50\2\uffff\1\34\12\uffff\1\51\1\70\2\uffff\1\2\2\uffff\1\62\1\uffff\1\57\2\uffff\1\13";
	static final String DFA37_specialS =
		"\1\1\42\uffff\1\2\11\uffff\1\0\u019a\uffff}>";
	static final String[] DFA37_transitionS = {
			"\11\63\1\36\1\62\2\63\1\62\22\63\1\36\1\47\1\43\1\35\1\57\1\24\1\31\1\55\1\46\1\53\1\22\1\25\1\41\1\26\1\34\1\23\1\60\11\61\1\42\1\54\1\27\1\37\1\30\1\50\1\63\32\57\1\45\1\40\1\52\1\32\1\1\1\63\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\57\1\11\2\57\1\12\3\57\1\13\1\57\1\14\1\15\1\16\1\17\1\20\1\21\3\57\1\44\1\33\1\51\1\56\uff81\63",
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
			"\1\167\1\uffff\12\170",
			"",
			"",
			"\1\174",
			"\1\176\2\uffff\1\176",
			"",
			"",
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
			"\1\170\1\uffff\10\u0093\2\170\10\uffff\1\u0091\1\uffff\3\170\21\uffff\1\u0090\11\uffff\1\u0091\1\uffff\3\170\21\uffff\1\u0090",
			"\1\170\1\uffff\12\u0094\12\uffff\3\170\35\uffff\3\170",
			"",
			"",
			"",
			"\1\u0097\7\uffff\1\u0096",
			"\1\u0098\1\u0099\6\uffff\1\u009a\3\uffff\1\u009b\4\uffff\1\u009c\3\uffff\1\u009d",
			"\1\u009e",
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
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\24\64\1\u00ac\5\64",
			"\1\u00ae",
			"\1\u00af",
			"\1\u00b0",
			"\1\u00b1",
			"\1\u00b2",
			"\1\u00b3",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u00b5\7\uffff\1\u00b6",
			"\1\u00b7",
			"\1\u00b8",
			"\1\u00b9\13\uffff\1\u00ba\1\u00bb",
			"\1\u00bc",
			"\1\u00bd\22\uffff\1\u00be",
			"\1\u00bf\20\uffff\1\u00c0",
			"\1\u00c1",
			"\1\u00c2",
			"\1\u00c3\11\uffff\1\u00c4",
			"\1\u00c5\2\uffff\1\u00c6",
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
			"\1\u00c9",
			"",
			"",
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
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\170\1\uffff\10\u0093\2\170\12\uffff\3\170\35\uffff\3\170",
			"\1\170\1\uffff\12\u0094\12\uffff\3\170\35\uffff\3\170",
			"",
			"\1\u00cd",
			"\1\u00ce",
			"\1\u00d0\1\u00cf",
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
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u00df",
			"\1\u00e0",
			"\1\u00e1",
			"\1\u00e2\1\u00e3",
			"\1\u00e4",
			"\1\u00e5",
			"",
			"\1\u00e6",
			"\1\u00e7",
			"\1\u00e8",
			"\1\u00e9",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u00eb",
			"",
			"\1\u00ec",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u00ee",
			"\1\u00ef",
			"\1\u00f0",
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
			"",
			"",
			"",
			"",
			"",
			"\1\u00ff",
			"\1\u0100",
			"\1\u0101",
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
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\u0110",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0113",
			"\1\u0114",
			"\1\u0115",
			"\1\u0116",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0119",
			"\1\u011a",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u011c",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u011e",
			"\1\u011f",
			"\1\u0120",
			"\1\u0121",
			"\1\u0122",
			"\1\u0123",
			"\1\u0124",
			"\1\u0125",
			"\1\u0126",
			"\1\u0127",
			"\1\u0128",
			"\1\u0129",
			"\1\u012a",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u012c",
			"\1\u012d",
			"\1\u012e",
			"\1\u012f",
			"\1\u0130",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\u0132\1\uffff\32\64",
			"\1\u0133",
			"\1\u0134",
			"\1\u0135",
			"\1\u0136",
			"\1\u0137",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0139",
			"\1\u013a",
			"\1\u013b",
			"\1\u013c",
			"\1\u013d",
			"\1\u013e",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0141",
			"\1\u0142",
			"\1\u0143",
			"",
			"",
			"\1\u0144",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\u0146",
			"",
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
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0153",
			"",
			"\1\u0154",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0156",
			"\1\u0157\15\uffff\1\u0158",
			"\1\u0159",
			"",
			"\1\u015a",
			"\1\u015b",
			"\1\u015c",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\3\64\1\u015e\4\64\1\u015f\21\64",
			"\1\u0160",
			"\1\u0161",
			"",
			"\1\u0162",
			"\1\u0163",
			"\1\u0164",
			"\1\u0165",
			"\1\u0166",
			"\1\u0167",
			"",
			"",
			"\1\u0168",
			"\1\u0169",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u016e",
			"\1\u016f",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0176",
			"",
			"\1\u0177",
			"\1\u0178",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u017a",
			"\1\u017b",
			"\1\u017c",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u017e",
			"\1\u017f",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0182",
			"\1\u0183",
			"\1\u0184",
			"\1\u0185",
			"\1\u0186",
			"\1\u0187",
			"\1\u0188",
			"\1\u0189",
			"\1\u018a",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"",
			"",
			"",
			"\1\u018c",
			"\1\u018d",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u018f",
			"\1\u0190",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u0193",
			"",
			"\1\u0194",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"",
			"\1\u0196",
			"\1\u0197",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u019a",
			"\1\u019b",
			"\1\u019c",
			"\1\u019d",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"",
			"\1\u01a3",
			"\1\u01a4",
			"",
			"\1\u01a5",
			"\1\u01a6",
			"",
			"",
			"\1\u01a7",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u01a9",
			"\1\u01aa",
			"",
			"",
			"",
			"",
			"",
			"\1\u01ab",
			"\1\u01ac",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\u01ae\1\uffff\32\64",
			"\1\u01af",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\u01b1",
			"\1\u01b2",
			"\1\u01b3",
			"\1\u01b4",
			"",
			"\1\u01b5",
			"\1\u01b6",
			"",
			"\1\u01b7",
			"\1\u01b8",
			"\1\u01b9",
			"\1\u01ba",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u01bd",
			"\1\u01be",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"\1\u01c0",
			"",
			"",
			"\1\u01c1",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\u01c3",
			"\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
			"",
			"\1\u01c5",
			"",
			"\1\u01c6",
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
			return "1:1: Tokens : ( RULE_KW_ATOMIC | RULE_KW_ATTRIBUTE | RULE_KW_AUTO | RULE_KW_ALIGNAS | RULE_KW_ALIGNOF | RULE_KW_ASM1 | RULE_KW_ASM2 | RULE_KW_ASM3 | RULE_KW_BOOL | RULE_KW_BREAK | RULE_KW_BUILTIN_VA_LIST | RULE_KW_CASE | RULE_KW_CHAR | RULE_KW_COMPLEX | RULE_KW_CONST | RULE_KW_CONTINUE | RULE_KW_DEFAULT | RULE_KW_DO | RULE_KW_DOUBLE | RULE_KW_ELSE | RULE_KW_ENUM | RULE_KW_EXTERN | RULE_KW_FLOAT | RULE_KW_FOR | RULE_KW_GENERIC | RULE_KW_GOTO | RULE_KW_IF | RULE_KW_IMAGINARY | RULE_KW_INLINE1 | RULE_KW_INLINE2 | RULE_KW_INT | RULE_KW_LONG | RULE_KW_M128 | RULE_KW_M128D | RULE_KW_M128I | RULE_KW_NORETURN | RULE_KW_PRAGMA | RULE_KW_REGISTER | RULE_KW_RESTRICT | RULE_KW_RESTRICT2 | RULE_KW_RESTRICT3 | RULE_KW_RETURN | RULE_KW_SHORT | RULE_KW_SIGNED | RULE_KW_SIZEOF | RULE_KW_STATIC | RULE_KW_STATICASSERT | RULE_KW_STRUCT | RULE_KW_SWITCH | RULE_KW_THREADLOCAL | RULE_KW_TYPEDEF | RULE_KW_UNION | RULE_KW_UNSIGNED | RULE_KW_VOID | RULE_KW_VOLATILE | RULE_KW_VOLATILE2 | RULE_KW_WHILE | RULE_STARASSIGN | RULE_DIVASSIGN | RULE_MODASSIGN | RULE_PLUSASSIGN | RULE_MINUSASSIGN | RULE_LEFTSHIFTASSIGN | RULE_RIGHTSHIFTASSIGN | RULE_ANDASSIGN | RULE_XORASSIGN | RULE_ORASSIGN | RULE_ARROW | RULE_ELLIPSIS | RULE_LINEDIRECTIVE | RULE_WHITESPACE | RULE_SKW_AND | RULE_SKW_ANDAND | RULE_SKW_ASSIGN | RULE_SKW_BACKSLASH | RULE_SKW_CARET | RULE_SKW_COMMA | RULE_SKW_COLON | RULE_SKW_DIV | RULE_SKW_DOT | RULE_SKW_DOUBLEQUOTE | RULE_SKW_EQUAL | RULE_SKW_GREATER | RULE_SKW_GREATEREQUAL | RULE_SKW_LEFTBRACE | RULE_SKW_LEFTBRACKET | RULE_SKW_LEFTPAREN | RULE_SKW_LEFTSHIFT | RULE_SKW_LESS | RULE_SKW_LESSEQUAL | RULE_SKW_MINUS | RULE_SKW_MINUSMINUS | RULE_SKW_MOD | RULE_SKW_NOT | RULE_SKW_NOTEQUAL | RULE_SKW_OR | RULE_SKW_OROR | RULE_SKW_PLUS | RULE_SKW_PLUSPLUS | RULE_SKW_QUESTION | RULE_SKW_RIGHTBRACE | RULE_SKW_RIGHTBRACKET | RULE_SKW_RIGHTPAREN | RULE_SKW_RIGHTSHIFT | RULE_SKW_SEMI | RULE_SKW_SINGLEQUOTE | RULE_SKW_STAR | RULE_SKW_TILDE | RULE_ID | RULE_CHAR_LITERAL | RULE_STRING_LITERAL | RULE_HEX_LITERAL | RULE_DECIMAL_LITERAL | RULE_OCTAL_LITERAL | RULE_BIN_LITERAL | RULE_FLOAT_LITERAL | RULE_LINEBREAK | RULE_NEWLINE | RULE_BLOCK_COMMENT | RULE_LINE_COMMENT | RULE_SPECIAL );";
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
				if ( ((LA37_45 >= '\u0000' && LA37_45 <= '&')||(LA37_45 >= '(' && LA37_45 <= '\uFFFF')) ) {s = 142;}
				else s = 141;
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
				if ( ((LA37_35 >= '\u0000' && LA37_35 <= '\uFFFF')) ) {s = 130;}
				else s = 129;
				//if ( s>=0 ) return s;
				//break;
				return s;
			}

	}


}