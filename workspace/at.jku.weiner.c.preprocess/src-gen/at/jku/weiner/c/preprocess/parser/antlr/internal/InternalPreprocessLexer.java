package at.jku.weiner.c.preprocess.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalPreprocessLexer extends Lexer {
    public static final int RULE_PRAGMA=22;
    public static final int RULE_ID=9;
    public static final int RULE_OCTAL_ESCAPE=76;
    public static final int RULE_SKW_NOT=46;
    public static final int RULE_SKW_RIGHTSHIFT=39;
    public static final int RULE_ESCAPE_SEQUENCE=71;
    public static final int RULE_SKW_DOT=56;
    public static final int RULE_DEFINED=24;
    public static final int RULE_SKW_PLUS=40;
    public static final int RULE_SKW_GREATEREQUAL=37;
    public static final int RULE_SKW_NOTEQUAL=33;
    public static final int RULE_SKW_RIGHTBRACE=62;
    public static final int EOF=-1;
    public static final int RULE_SKW_LESS=34;
    public static final int RULE_SKW_RIGHTPAREN=11;
    public static final int RULE_SKW_STAR=42;
    public static final int RULE_ENDIF=16;
    public static final int RULE_LINEBREAK=81;
    public static final int RULE_STRING_LITERAL=51;
    public static final int RULE_SKW_PLUSPLUS=61;
    public static final int RULE_SKW_DOUBLEQUOTE=57;
    public static final int RULE_SKW_LESSEQUAL=36;
    public static final int RULE_DECIMAL_LITERAL=49;
    public static final int RULE_HEX_LITERAL=47;
    public static final int RULE_SKW_OROR=27;
    public static final int RULE_WARNING=14;
    public static final int RULE_SKW_AND=31;
    public static final int RULE_SKW_CARET=30;
    public static final int RULE_WHITESPACE=5;
    public static final int RULE_OCTAL_LITERAL=48;
    public static final int RULE_SKW_COMMA=12;
    public static final int RULE_SKW_RIGHTBRACKET=63;
    public static final int RULE_SPACE=82;
    public static final int SUPER_NEWLINE=66;
    public static final int RULE_BLOCK_COMMENT=84;
    public static final int RULE_LINEFEED=78;
    public static final int RULE_SKW_COLON=26;
    public static final int RULE_BIN_LITERAL=53;
    public static final int RULE_SKW_LEFTPAREN=10;
    public static final int RULE_SKW_MINUS=41;
    public static final int RULE_IFDEF=18;
    public static final int RULE_SKW_SEMI=64;
    public static final int RULE_NEWLINE=4;
    public static final int RULE_SKW_DOLLAR=67;
    public static final int RULE_SKW_EQUAL=32;
    public static final int RULE_SKW_LEFTSHIFT=38;
    public static final int RULE_SKW_ANDAND=28;
    public static final int RULE_SKW_QUESTION=25;
    public static final int RULE_SKW_DIV=43;
    public static final int RULE_ERROR=13;
    public static final int RULE_SKW_GREATER=35;
    public static final int RULE_HEX_DIGIT=72;
    public static final int RULE_HASH=6;
    public static final int RULE_IDENTIFIER=69;
    public static final int RULE_SKW_LEFTBRACKET=59;
    public static final int RULE_HEX_ESCAPE=77;
    public static final int RULE_TAB=83;
    public static final int RULE_SKW_SINGLEQUOTE=65;
    public static final int RULE_UNDEF=15;
    public static final int RULE_SKW_MOD=44;
    public static final int RULE_LETTER=70;
    public static final int RULE_SKW_MINUSMINUS=60;
    public static final int RULE_IFNOTDEF=19;
    public static final int RULE_FLOAT_TYPE_SUFFIX=75;
    public static final int RULE_DEFINE=8;
    public static final int RULE_INTEGER_TYPE_SUFFIX=73;
    public static final int RULE_EXPONENT=74;
    public static final int RULE_SPECIAL=23;
    public static final int RULE_CARRIAGERETURN=79;
    public static final int RULE_SKW_TILDE=45;
    public static final int RULE_LINE_COMMENT=85;
    public static final int RULE_INCLUDE=7;
    public static final int RULE_SKW_OR=29;
    public static final int RULE_SKW_BACKSLASH=55;
    public static final int RULE_SKW_UNDERSCORE=68;
    public static final int RULE_ELIF=20;
    public static final int RULE_CHAR_LITERAL=50;
    public static final int RULE_LINE_END=80;
    public static final int RULE_IF=17;
    public static final int RULE_ELSE=21;
    public static final int RULE_FLOAT_LITERAL=52;
    public static final int RULE_SKW_LEFTBRACE=58;
    public static final int RULE_SKW_ASSIGN=54;

    // delegates
    // delegators

    public InternalPreprocessLexer() {;} 
    public InternalPreprocessLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalPreprocessLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalPreprocess.g"; }

    // $ANTLR start "RULE_HASH"
    public final void mRULE_HASH() throws RecognitionException {
        try {
            int _type = RULE_HASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5382:11: ( '#' )
            // InternalPreprocess.g:5382:13: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HASH"

    // $ANTLR start "RULE_INCLUDE"
    public final void mRULE_INCLUDE() throws RecognitionException {
        try {
            int _type = RULE_INCLUDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5384:14: ( 'include' )
            // InternalPreprocess.g:5384:16: 'include'
            {
            match("include"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INCLUDE"

    // $ANTLR start "RULE_DEFINE"
    public final void mRULE_DEFINE() throws RecognitionException {
        try {
            int _type = RULE_DEFINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5386:13: ( 'define' )
            // InternalPreprocess.g:5386:15: 'define'
            {
            match("define"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DEFINE"

    // $ANTLR start "RULE_ERROR"
    public final void mRULE_ERROR() throws RecognitionException {
        try {
            int _type = RULE_ERROR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5388:12: ( 'error' )
            // InternalPreprocess.g:5388:14: 'error'
            {
            match("error"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ERROR"

    // $ANTLR start "RULE_WARNING"
    public final void mRULE_WARNING() throws RecognitionException {
        try {
            int _type = RULE_WARNING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5390:14: ( 'warning' )
            // InternalPreprocess.g:5390:16: 'warning'
            {
            match("warning"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WARNING"

    // $ANTLR start "RULE_UNDEF"
    public final void mRULE_UNDEF() throws RecognitionException {
        try {
            int _type = RULE_UNDEF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5392:12: ( 'undef' )
            // InternalPreprocess.g:5392:14: 'undef'
            {
            match("undef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_UNDEF"

    // $ANTLR start "RULE_IF"
    public final void mRULE_IF() throws RecognitionException {
        try {
            int _type = RULE_IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5394:9: ( 'if' )
            // InternalPreprocess.g:5394:11: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_IF"

    // $ANTLR start "RULE_DEFINED"
    public final void mRULE_DEFINED() throws RecognitionException {
        try {
            int _type = RULE_DEFINED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5396:14: ( 'defined' )
            // InternalPreprocess.g:5396:16: 'defined'
            {
            match("defined"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DEFINED"

    // $ANTLR start "RULE_IFDEF"
    public final void mRULE_IFDEF() throws RecognitionException {
        try {
            int _type = RULE_IFDEF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5398:12: ( 'ifdef' )
            // InternalPreprocess.g:5398:14: 'ifdef'
            {
            match("ifdef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_IFDEF"

    // $ANTLR start "RULE_IFNOTDEF"
    public final void mRULE_IFNOTDEF() throws RecognitionException {
        try {
            int _type = RULE_IFNOTDEF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5400:15: ( 'ifndef' )
            // InternalPreprocess.g:5400:17: 'ifndef'
            {
            match("ifndef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_IFNOTDEF"

    // $ANTLR start "RULE_ELIF"
    public final void mRULE_ELIF() throws RecognitionException {
        try {
            int _type = RULE_ELIF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5402:11: ( 'elif' )
            // InternalPreprocess.g:5402:13: 'elif'
            {
            match("elif"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ELIF"

    // $ANTLR start "RULE_ELSE"
    public final void mRULE_ELSE() throws RecognitionException {
        try {
            int _type = RULE_ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5404:11: ( 'else' )
            // InternalPreprocess.g:5404:13: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ELSE"

    // $ANTLR start "RULE_ENDIF"
    public final void mRULE_ENDIF() throws RecognitionException {
        try {
            int _type = RULE_ENDIF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5406:12: ( 'endif' )
            // InternalPreprocess.g:5406:14: 'endif'
            {
            match("endif"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ENDIF"

    // $ANTLR start "RULE_PRAGMA"
    public final void mRULE_PRAGMA() throws RecognitionException {
        try {
            int _type = RULE_PRAGMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5408:13: ( 'pragma' )
            // InternalPreprocess.g:5408:15: 'pragma'
            {
            match("pragma"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_PRAGMA"

    // $ANTLR start "RULE_NEWLINE"
    public final void mRULE_NEWLINE() throws RecognitionException {
        try {
            int _type = RULE_NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5410:14: ( SUPER_NEWLINE )
            // InternalPreprocess.g:5410:16: SUPER_NEWLINE
            {
            mSUPER_NEWLINE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NEWLINE"

    // $ANTLR start "RULE_SKW_AND"
    public final void mRULE_SKW_AND() throws RecognitionException {
        try {
            int _type = RULE_SKW_AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5412:14: ( '&' )
            // InternalPreprocess.g:5412:16: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_AND"

    // $ANTLR start "RULE_SKW_ANDAND"
    public final void mRULE_SKW_ANDAND() throws RecognitionException {
        try {
            int _type = RULE_SKW_ANDAND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5414:17: ( RULE_SKW_AND RULE_SKW_AND )
            // InternalPreprocess.g:5414:19: RULE_SKW_AND RULE_SKW_AND
            {
            mRULE_SKW_AND(); 
            mRULE_SKW_AND(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_ANDAND"

    // $ANTLR start "RULE_SKW_ASSIGN"
    public final void mRULE_SKW_ASSIGN() throws RecognitionException {
        try {
            int _type = RULE_SKW_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5416:17: ( '=' )
            // InternalPreprocess.g:5416:19: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_ASSIGN"

    // $ANTLR start "RULE_SKW_BACKSLASH"
    public final void mRULE_SKW_BACKSLASH() throws RecognitionException {
        try {
            int _type = RULE_SKW_BACKSLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5418:20: ( '\\\\' )
            // InternalPreprocess.g:5418:22: '\\\\'
            {
            match('\\'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_BACKSLASH"

    // $ANTLR start "RULE_SKW_CARET"
    public final void mRULE_SKW_CARET() throws RecognitionException {
        try {
            int _type = RULE_SKW_CARET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5420:16: ( '^' )
            // InternalPreprocess.g:5420:18: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_CARET"

    // $ANTLR start "RULE_SKW_COMMA"
    public final void mRULE_SKW_COMMA() throws RecognitionException {
        try {
            int _type = RULE_SKW_COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5422:16: ( ',' )
            // InternalPreprocess.g:5422:18: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_COMMA"

    // $ANTLR start "RULE_SKW_COLON"
    public final void mRULE_SKW_COLON() throws RecognitionException {
        try {
            int _type = RULE_SKW_COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5424:16: ( ':' )
            // InternalPreprocess.g:5424:18: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_COLON"

    // $ANTLR start "RULE_SKW_DIV"
    public final void mRULE_SKW_DIV() throws RecognitionException {
        try {
            int _type = RULE_SKW_DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5426:14: ( '/' )
            // InternalPreprocess.g:5426:16: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_DIV"

    // $ANTLR start "RULE_SKW_DOLLAR"
    public final void mRULE_SKW_DOLLAR() throws RecognitionException {
        try {
            // InternalPreprocess.g:5428:26: ( '$' )
            // InternalPreprocess.g:5428:28: '$'
            {
            match('$'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_DOLLAR"

    // $ANTLR start "RULE_SKW_DOT"
    public final void mRULE_SKW_DOT() throws RecognitionException {
        try {
            int _type = RULE_SKW_DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5430:14: ( '.' )
            // InternalPreprocess.g:5430:16: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_DOT"

    // $ANTLR start "RULE_SKW_DOUBLEQUOTE"
    public final void mRULE_SKW_DOUBLEQUOTE() throws RecognitionException {
        try {
            int _type = RULE_SKW_DOUBLEQUOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5432:22: ( '\"' )
            // InternalPreprocess.g:5432:24: '\"'
            {
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_DOUBLEQUOTE"

    // $ANTLR start "RULE_SKW_EQUAL"
    public final void mRULE_SKW_EQUAL() throws RecognitionException {
        try {
            int _type = RULE_SKW_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5434:16: ( RULE_SKW_ASSIGN RULE_SKW_ASSIGN )
            // InternalPreprocess.g:5434:18: RULE_SKW_ASSIGN RULE_SKW_ASSIGN
            {
            mRULE_SKW_ASSIGN(); 
            mRULE_SKW_ASSIGN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_EQUAL"

    // $ANTLR start "RULE_SKW_GREATER"
    public final void mRULE_SKW_GREATER() throws RecognitionException {
        try {
            int _type = RULE_SKW_GREATER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5436:18: ( '>' )
            // InternalPreprocess.g:5436:20: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_GREATER"

    // $ANTLR start "RULE_SKW_GREATEREQUAL"
    public final void mRULE_SKW_GREATEREQUAL() throws RecognitionException {
        try {
            int _type = RULE_SKW_GREATEREQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5438:23: ( RULE_SKW_GREATER RULE_SKW_ASSIGN )
            // InternalPreprocess.g:5438:25: RULE_SKW_GREATER RULE_SKW_ASSIGN
            {
            mRULE_SKW_GREATER(); 
            mRULE_SKW_ASSIGN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_GREATEREQUAL"

    // $ANTLR start "RULE_SKW_LEFTBRACE"
    public final void mRULE_SKW_LEFTBRACE() throws RecognitionException {
        try {
            int _type = RULE_SKW_LEFTBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5440:20: ( '{' )
            // InternalPreprocess.g:5440:22: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_LEFTBRACE"

    // $ANTLR start "RULE_SKW_LEFTBRACKET"
    public final void mRULE_SKW_LEFTBRACKET() throws RecognitionException {
        try {
            int _type = RULE_SKW_LEFTBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5442:22: ( '[' )
            // InternalPreprocess.g:5442:24: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_LEFTBRACKET"

    // $ANTLR start "RULE_SKW_LEFTPAREN"
    public final void mRULE_SKW_LEFTPAREN() throws RecognitionException {
        try {
            int _type = RULE_SKW_LEFTPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5444:20: ( '(' )
            // InternalPreprocess.g:5444:22: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_LEFTPAREN"

    // $ANTLR start "RULE_SKW_LEFTSHIFT"
    public final void mRULE_SKW_LEFTSHIFT() throws RecognitionException {
        try {
            int _type = RULE_SKW_LEFTSHIFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5446:20: ( RULE_SKW_LESS RULE_SKW_LESS )
            // InternalPreprocess.g:5446:22: RULE_SKW_LESS RULE_SKW_LESS
            {
            mRULE_SKW_LESS(); 
            mRULE_SKW_LESS(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_LEFTSHIFT"

    // $ANTLR start "RULE_SKW_LESS"
    public final void mRULE_SKW_LESS() throws RecognitionException {
        try {
            int _type = RULE_SKW_LESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5448:15: ( '<' )
            // InternalPreprocess.g:5448:17: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_LESS"

    // $ANTLR start "RULE_SKW_LESSEQUAL"
    public final void mRULE_SKW_LESSEQUAL() throws RecognitionException {
        try {
            int _type = RULE_SKW_LESSEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5450:20: ( RULE_SKW_LESS RULE_SKW_ASSIGN )
            // InternalPreprocess.g:5450:22: RULE_SKW_LESS RULE_SKW_ASSIGN
            {
            mRULE_SKW_LESS(); 
            mRULE_SKW_ASSIGN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_LESSEQUAL"

    // $ANTLR start "RULE_SKW_MINUS"
    public final void mRULE_SKW_MINUS() throws RecognitionException {
        try {
            int _type = RULE_SKW_MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5452:16: ( '-' )
            // InternalPreprocess.g:5452:18: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_MINUS"

    // $ANTLR start "RULE_SKW_MINUSMINUS"
    public final void mRULE_SKW_MINUSMINUS() throws RecognitionException {
        try {
            int _type = RULE_SKW_MINUSMINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5454:21: ( RULE_SKW_MINUS RULE_SKW_MINUS )
            // InternalPreprocess.g:5454:23: RULE_SKW_MINUS RULE_SKW_MINUS
            {
            mRULE_SKW_MINUS(); 
            mRULE_SKW_MINUS(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_MINUSMINUS"

    // $ANTLR start "RULE_SKW_MOD"
    public final void mRULE_SKW_MOD() throws RecognitionException {
        try {
            int _type = RULE_SKW_MOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5456:14: ( '%' )
            // InternalPreprocess.g:5456:16: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_MOD"

    // $ANTLR start "RULE_SKW_NOT"
    public final void mRULE_SKW_NOT() throws RecognitionException {
        try {
            int _type = RULE_SKW_NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5458:14: ( '!' )
            // InternalPreprocess.g:5458:16: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_NOT"

    // $ANTLR start "RULE_SKW_NOTEQUAL"
    public final void mRULE_SKW_NOTEQUAL() throws RecognitionException {
        try {
            int _type = RULE_SKW_NOTEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5460:19: ( RULE_SKW_NOT RULE_SKW_ASSIGN )
            // InternalPreprocess.g:5460:21: RULE_SKW_NOT RULE_SKW_ASSIGN
            {
            mRULE_SKW_NOT(); 
            mRULE_SKW_ASSIGN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_NOTEQUAL"

    // $ANTLR start "RULE_SKW_OR"
    public final void mRULE_SKW_OR() throws RecognitionException {
        try {
            int _type = RULE_SKW_OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5462:13: ( '|' )
            // InternalPreprocess.g:5462:15: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_OR"

    // $ANTLR start "RULE_SKW_OROR"
    public final void mRULE_SKW_OROR() throws RecognitionException {
        try {
            int _type = RULE_SKW_OROR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5464:15: ( RULE_SKW_OR RULE_SKW_OR )
            // InternalPreprocess.g:5464:17: RULE_SKW_OR RULE_SKW_OR
            {
            mRULE_SKW_OR(); 
            mRULE_SKW_OR(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_OROR"

    // $ANTLR start "RULE_SKW_PLUS"
    public final void mRULE_SKW_PLUS() throws RecognitionException {
        try {
            int _type = RULE_SKW_PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5466:15: ( '+' )
            // InternalPreprocess.g:5466:17: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_PLUS"

    // $ANTLR start "RULE_SKW_PLUSPLUS"
    public final void mRULE_SKW_PLUSPLUS() throws RecognitionException {
        try {
            int _type = RULE_SKW_PLUSPLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5468:19: ( RULE_SKW_PLUS RULE_SKW_PLUS )
            // InternalPreprocess.g:5468:21: RULE_SKW_PLUS RULE_SKW_PLUS
            {
            mRULE_SKW_PLUS(); 
            mRULE_SKW_PLUS(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_PLUSPLUS"

    // $ANTLR start "RULE_SKW_QUESTION"
    public final void mRULE_SKW_QUESTION() throws RecognitionException {
        try {
            int _type = RULE_SKW_QUESTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5470:19: ( '?' )
            // InternalPreprocess.g:5470:21: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_QUESTION"

    // $ANTLR start "RULE_SKW_RIGHTBRACE"
    public final void mRULE_SKW_RIGHTBRACE() throws RecognitionException {
        try {
            int _type = RULE_SKW_RIGHTBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5472:21: ( '}' )
            // InternalPreprocess.g:5472:23: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_RIGHTBRACE"

    // $ANTLR start "RULE_SKW_RIGHTBRACKET"
    public final void mRULE_SKW_RIGHTBRACKET() throws RecognitionException {
        try {
            int _type = RULE_SKW_RIGHTBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5474:23: ( ']' )
            // InternalPreprocess.g:5474:25: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_RIGHTBRACKET"

    // $ANTLR start "RULE_SKW_RIGHTPAREN"
    public final void mRULE_SKW_RIGHTPAREN() throws RecognitionException {
        try {
            int _type = RULE_SKW_RIGHTPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5476:21: ( ')' )
            // InternalPreprocess.g:5476:23: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_RIGHTPAREN"

    // $ANTLR start "RULE_SKW_RIGHTSHIFT"
    public final void mRULE_SKW_RIGHTSHIFT() throws RecognitionException {
        try {
            int _type = RULE_SKW_RIGHTSHIFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5478:21: ( RULE_SKW_GREATER RULE_SKW_GREATER )
            // InternalPreprocess.g:5478:23: RULE_SKW_GREATER RULE_SKW_GREATER
            {
            mRULE_SKW_GREATER(); 
            mRULE_SKW_GREATER(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_RIGHTSHIFT"

    // $ANTLR start "RULE_SKW_SEMI"
    public final void mRULE_SKW_SEMI() throws RecognitionException {
        try {
            int _type = RULE_SKW_SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5480:15: ( ';' )
            // InternalPreprocess.g:5480:17: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_SEMI"

    // $ANTLR start "RULE_SKW_SINGLEQUOTE"
    public final void mRULE_SKW_SINGLEQUOTE() throws RecognitionException {
        try {
            int _type = RULE_SKW_SINGLEQUOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5482:22: ( '\\'' )
            // InternalPreprocess.g:5482:24: '\\''
            {
            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_SINGLEQUOTE"

    // $ANTLR start "RULE_SKW_STAR"
    public final void mRULE_SKW_STAR() throws RecognitionException {
        try {
            int _type = RULE_SKW_STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5484:15: ( '*' )
            // InternalPreprocess.g:5484:17: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_STAR"

    // $ANTLR start "RULE_SKW_TILDE"
    public final void mRULE_SKW_TILDE() throws RecognitionException {
        try {
            int _type = RULE_SKW_TILDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5486:16: ( '~' )
            // InternalPreprocess.g:5486:18: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_TILDE"

    // $ANTLR start "RULE_SKW_UNDERSCORE"
    public final void mRULE_SKW_UNDERSCORE() throws RecognitionException {
        try {
            // InternalPreprocess.g:5488:30: ( '_' )
            // InternalPreprocess.g:5488:32: '_'
            {
            match('_'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_UNDERSCORE"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5490:9: ( RULE_IDENTIFIER )
            // InternalPreprocess.g:5490:11: RULE_IDENTIFIER
            {
            mRULE_IDENTIFIER(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_IDENTIFIER"
    public final void mRULE_IDENTIFIER() throws RecognitionException {
        try {
            // InternalPreprocess.g:5492:26: ( RULE_LETTER ( RULE_LETTER | '0' .. '9' )* )
            // InternalPreprocess.g:5492:28: RULE_LETTER ( RULE_LETTER | '0' .. '9' )*
            {
            mRULE_LETTER(); 
            // InternalPreprocess.g:5492:40: ( RULE_LETTER | '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='$'||(LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalPreprocess.g:
            	    {
            	    if ( input.LA(1)=='$'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_IDENTIFIER"

    // $ANTLR start "RULE_LETTER"
    public final void mRULE_LETTER() throws RecognitionException {
        try {
            // InternalPreprocess.g:5494:22: ( ( RULE_SKW_DOLLAR | 'A' .. 'Z' | 'a' .. 'z' | RULE_SKW_UNDERSCORE ) )
            // InternalPreprocess.g:5494:24: ( RULE_SKW_DOLLAR | 'A' .. 'Z' | 'a' .. 'z' | RULE_SKW_UNDERSCORE )
            {
            if ( input.LA(1)=='$'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_LETTER"

    // $ANTLR start "RULE_CHAR_LITERAL"
    public final void mRULE_CHAR_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_CHAR_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5496:19: ( RULE_SKW_SINGLEQUOTE ( RULE_ESCAPE_SEQUENCE | ~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) ) RULE_SKW_SINGLEQUOTE )
            // InternalPreprocess.g:5496:21: RULE_SKW_SINGLEQUOTE ( RULE_ESCAPE_SEQUENCE | ~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) ) RULE_SKW_SINGLEQUOTE
            {
            mRULE_SKW_SINGLEQUOTE(); 
            // InternalPreprocess.g:5496:42: ( RULE_ESCAPE_SEQUENCE | ~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\\') ) {
                alt2=1;
            }
            else if ( ((LA2_0>='\u0000' && LA2_0<='&')||(LA2_0>='(' && LA2_0<='[')||(LA2_0>=']' && LA2_0<='\uFFFF')) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalPreprocess.g:5496:43: RULE_ESCAPE_SEQUENCE
                    {
                    mRULE_ESCAPE_SEQUENCE(); 

                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:5496:64: ~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            mRULE_SKW_SINGLEQUOTE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CHAR_LITERAL"

    // $ANTLR start "RULE_STRING_LITERAL"
    public final void mRULE_STRING_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5498:21: ( RULE_SKW_DOUBLEQUOTE ( RULE_ESCAPE_SEQUENCE | ~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) )* RULE_SKW_DOUBLEQUOTE )
            // InternalPreprocess.g:5498:23: RULE_SKW_DOUBLEQUOTE ( RULE_ESCAPE_SEQUENCE | ~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) )* RULE_SKW_DOUBLEQUOTE
            {
            mRULE_SKW_DOUBLEQUOTE(); 
            // InternalPreprocess.g:5498:44: ( RULE_ESCAPE_SEQUENCE | ~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\\') ) {
                    alt3=1;
                }
                else if ( ((LA3_0>='\u0000' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='\uFFFF')) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalPreprocess.g:5498:45: RULE_ESCAPE_SEQUENCE
            	    {
            	    mRULE_ESCAPE_SEQUENCE(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalPreprocess.g:5498:66: ~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            mRULE_SKW_DOUBLEQUOTE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING_LITERAL"

    // $ANTLR start "RULE_HEX_LITERAL"
    public final void mRULE_HEX_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_HEX_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5500:18: ( '0' ( 'x' | 'X' ) ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )? )
            // InternalPreprocess.g:5500:20: '0' ( 'x' | 'X' ) ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )?
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalPreprocess.g:5500:34: ( RULE_HEX_DIGIT )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='F')||(LA4_0>='a' && LA4_0<='f')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalPreprocess.g:5500:34: RULE_HEX_DIGIT
            	    {
            	    mRULE_HEX_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            // InternalPreprocess.g:5500:50: ( RULE_INTEGER_TYPE_SUFFIX )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='L'||LA5_0=='U'||LA5_0=='l'||LA5_0=='u') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalPreprocess.g:5500:50: RULE_INTEGER_TYPE_SUFFIX
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
        }
    }
    // $ANTLR end "RULE_HEX_LITERAL"

    // $ANTLR start "RULE_DECIMAL_LITERAL"
    public final void mRULE_DECIMAL_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_DECIMAL_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5502:22: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( RULE_INTEGER_TYPE_SUFFIX )? )
            // InternalPreprocess.g:5502:24: ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( RULE_INTEGER_TYPE_SUFFIX )?
            {
            // InternalPreprocess.g:5502:24: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='0') ) {
                alt7=1;
            }
            else if ( ((LA7_0>='1' && LA7_0<='9')) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalPreprocess.g:5502:25: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:5502:29: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); 
                    // InternalPreprocess.g:5502:38: ( '0' .. '9' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalPreprocess.g:5502:39: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalPreprocess.g:5502:51: ( RULE_INTEGER_TYPE_SUFFIX )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='L'||LA8_0=='U'||LA8_0=='l'||LA8_0=='u') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalPreprocess.g:5502:51: RULE_INTEGER_TYPE_SUFFIX
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
        }
    }
    // $ANTLR end "RULE_DECIMAL_LITERAL"

    // $ANTLR start "RULE_OCTAL_LITERAL"
    public final void mRULE_OCTAL_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_OCTAL_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5504:20: ( '0' ( '0' .. '7' )+ ( RULE_INTEGER_TYPE_SUFFIX )? )
            // InternalPreprocess.g:5504:22: '0' ( '0' .. '7' )+ ( RULE_INTEGER_TYPE_SUFFIX )?
            {
            match('0'); 
            // InternalPreprocess.g:5504:26: ( '0' .. '7' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='7')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalPreprocess.g:5504:27: '0' .. '7'
            	    {
            	    matchRange('0','7'); 

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

            // InternalPreprocess.g:5504:38: ( RULE_INTEGER_TYPE_SUFFIX )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='L'||LA10_0=='U'||LA10_0=='l'||LA10_0=='u') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalPreprocess.g:5504:38: RULE_INTEGER_TYPE_SUFFIX
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
        }
    }
    // $ANTLR end "RULE_OCTAL_LITERAL"

    // $ANTLR start "RULE_BIN_LITERAL"
    public final void mRULE_BIN_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_BIN_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5506:18: ( ( '0b' | '0B' ) ( '0' .. '1' )+ )
            // InternalPreprocess.g:5506:20: ( '0b' | '0B' ) ( '0' .. '1' )+
            {
            // InternalPreprocess.g:5506:20: ( '0b' | '0B' )
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
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalPreprocess.g:5506:21: '0b'
                    {
                    match("0b"); 


                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:5506:26: '0B'
                    {
                    match("0B"); 


                    }
                    break;

            }

            // InternalPreprocess.g:5506:32: ( '0' .. '1' )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='0' && LA12_0<='1')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalPreprocess.g:5506:33: '0' .. '1'
            	    {
            	    matchRange('0','1'); 

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BIN_LITERAL"

    // $ANTLR start "RULE_HEX_DIGIT"
    public final void mRULE_HEX_DIGIT() throws RecognitionException {
        try {
            // InternalPreprocess.g:5508:25: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // InternalPreprocess.g:5508:27: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX_DIGIT"

    // $ANTLR start "RULE_INTEGER_TYPE_SUFFIX"
    public final void mRULE_INTEGER_TYPE_SUFFIX() throws RecognitionException {
        try {
            // InternalPreprocess.g:5510:35: ( ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? ) )
            // InternalPreprocess.g:5510:37: ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? )
            {
            // InternalPreprocess.g:5510:37: ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='U'||LA15_0=='u') ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1=='L'||LA15_1=='l') ) {
                    alt15=1;
                }
                else {
                    alt15=2;}
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
                    // InternalPreprocess.g:5510:38: ( 'u' | 'U' )? ( 'l' | 'L' )
                    {
                    // InternalPreprocess.g:5510:38: ( 'u' | 'U' )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='U'||LA13_0=='u') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // InternalPreprocess.g:
                            {
                            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }

                    if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:5510:59: ( 'u' | 'U' ) ( 'l' | 'L' )?
                    {
                    if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // InternalPreprocess.g:5510:69: ( 'l' | 'L' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='L'||LA14_0=='l') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // InternalPreprocess.g:
                            {
                            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }


                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_INTEGER_TYPE_SUFFIX"

    // $ANTLR start "RULE_FLOAT_LITERAL"
    public final void mRULE_FLOAT_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_FLOAT_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5512:20: ( ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX ) )
            // InternalPreprocess.g:5512:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )
            {
            // InternalPreprocess.g:5512:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )
            int alt27=4;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // InternalPreprocess.g:5512:23: ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )?
                    {
                    // InternalPreprocess.g:5512:23: ( '0' .. '9' )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>='0' && LA16_0<='9')) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalPreprocess.g:5512:24: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);

                    mRULE_SKW_DOT(); 
                    // InternalPreprocess.g:5512:48: ( '0' .. '9' )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( ((LA17_0>='0' && LA17_0<='9')) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalPreprocess.g:5512:49: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    // InternalPreprocess.g:5512:60: ( RULE_EXPONENT )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0=='E'||LA18_0=='e') ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // InternalPreprocess.g:5512:60: RULE_EXPONENT
                            {
                            mRULE_EXPONENT(); 

                            }
                            break;

                    }

                    // InternalPreprocess.g:5512:75: ( RULE_FLOAT_TYPE_SUFFIX )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0=='D'||LA19_0=='F'||LA19_0=='d'||LA19_0=='f') ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // InternalPreprocess.g:5512:75: RULE_FLOAT_TYPE_SUFFIX
                            {
                            mRULE_FLOAT_TYPE_SUFFIX(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:5512:99: RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )?
                    {
                    mRULE_SKW_DOT(); 
                    // InternalPreprocess.g:5512:112: ( '0' .. '9' )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( ((LA20_0>='0' && LA20_0<='9')) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalPreprocess.g:5512:113: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);

                    // InternalPreprocess.g:5512:124: ( RULE_EXPONENT )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0=='E'||LA21_0=='e') ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // InternalPreprocess.g:5512:124: RULE_EXPONENT
                            {
                            mRULE_EXPONENT(); 

                            }
                            break;

                    }

                    // InternalPreprocess.g:5512:139: ( RULE_FLOAT_TYPE_SUFFIX )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0=='D'||LA22_0=='F'||LA22_0=='d'||LA22_0=='f') ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // InternalPreprocess.g:5512:139: RULE_FLOAT_TYPE_SUFFIX
                            {
                            mRULE_FLOAT_TYPE_SUFFIX(); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // InternalPreprocess.g:5512:163: ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )?
                    {
                    // InternalPreprocess.g:5512:163: ( '0' .. '9' )+
                    int cnt23=0;
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( ((LA23_0>='0' && LA23_0<='9')) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalPreprocess.g:5512:164: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt23 >= 1 ) break loop23;
                                EarlyExitException eee =
                                    new EarlyExitException(23, input);
                                throw eee;
                        }
                        cnt23++;
                    } while (true);

                    mRULE_EXPONENT(); 
                    // InternalPreprocess.g:5512:189: ( RULE_FLOAT_TYPE_SUFFIX )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0=='D'||LA24_0=='F'||LA24_0=='d'||LA24_0=='f') ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // InternalPreprocess.g:5512:189: RULE_FLOAT_TYPE_SUFFIX
                            {
                            mRULE_FLOAT_TYPE_SUFFIX(); 

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // InternalPreprocess.g:5512:213: ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX
                    {
                    // InternalPreprocess.g:5512:213: ( '0' .. '9' )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( ((LA25_0>='0' && LA25_0<='9')) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalPreprocess.g:5512:214: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt25 >= 1 ) break loop25;
                                EarlyExitException eee =
                                    new EarlyExitException(25, input);
                                throw eee;
                        }
                        cnt25++;
                    } while (true);

                    // InternalPreprocess.g:5512:225: ( RULE_EXPONENT )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0=='E'||LA26_0=='e') ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // InternalPreprocess.g:5512:225: RULE_EXPONENT
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
        }
    }
    // $ANTLR end "RULE_FLOAT_LITERAL"

    // $ANTLR start "RULE_EXPONENT"
    public final void mRULE_EXPONENT() throws RecognitionException {
        try {
            // InternalPreprocess.g:5514:24: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // InternalPreprocess.g:5514:26: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalPreprocess.g:5514:36: ( '+' | '-' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0=='+'||LA28_0=='-') ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalPreprocess.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // InternalPreprocess.g:5514:47: ( '0' .. '9' )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>='0' && LA29_0<='9')) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalPreprocess.g:5514:48: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_EXPONENT"

    // $ANTLR start "RULE_FLOAT_TYPE_SUFFIX"
    public final void mRULE_FLOAT_TYPE_SUFFIX() throws RecognitionException {
        try {
            // InternalPreprocess.g:5516:33: ( ( 'f' | 'F' | 'd' | 'D' ) )
            // InternalPreprocess.g:5516:35: ( 'f' | 'F' | 'd' | 'D' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_FLOAT_TYPE_SUFFIX"

    // $ANTLR start "RULE_ESCAPE_SEQUENCE"
    public final void mRULE_ESCAPE_SEQUENCE() throws RecognitionException {
        try {
            // InternalPreprocess.g:5518:31: ( ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE | RULE_HEX_ESCAPE ) )
            // InternalPreprocess.g:5518:33: ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE | RULE_HEX_ESCAPE )
            {
            // InternalPreprocess.g:5518:33: ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE | RULE_HEX_ESCAPE )
            int alt30=3;
            int LA30_0 = input.LA(1);

            if ( (LA30_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt30=2;
                    }
                    break;
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt30=1;
                    }
                    break;
                case 'x':
                    {
                    alt30=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // InternalPreprocess.g:5518:34: RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH )
                    {
                    mRULE_SKW_BACKSLASH(); 
                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:5518:119: RULE_OCTAL_ESCAPE
                    {
                    mRULE_OCTAL_ESCAPE(); 

                    }
                    break;
                case 3 :
                    // InternalPreprocess.g:5518:137: RULE_HEX_ESCAPE
                    {
                    mRULE_HEX_ESCAPE(); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_ESCAPE_SEQUENCE"

    // $ANTLR start "RULE_OCTAL_ESCAPE"
    public final void mRULE_OCTAL_ESCAPE() throws RecognitionException {
        try {
            // InternalPreprocess.g:5520:28: ( ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' ) )
            // InternalPreprocess.g:5520:30: ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' )
            {
            // InternalPreprocess.g:5520:30: ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' )
            int alt31=3;
            int LA31_0 = input.LA(1);

            if ( (LA31_0=='\\') ) {
                int LA31_1 = input.LA(2);

                if ( ((LA31_1>='0' && LA31_1<='3')) ) {
                    int LA31_2 = input.LA(3);

                    if ( ((LA31_2>='0' && LA31_2<='7')) ) {
                        int LA31_4 = input.LA(4);

                        if ( ((LA31_4>='0' && LA31_4<='7')) ) {
                            alt31=1;
                        }
                        else {
                            alt31=2;}
                    }
                    else {
                        alt31=3;}
                }
                else if ( ((LA31_1>='4' && LA31_1<='7')) ) {
                    int LA31_3 = input.LA(3);

                    if ( ((LA31_3>='0' && LA31_3<='7')) ) {
                        alt31=2;
                    }
                    else {
                        alt31=3;}
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // InternalPreprocess.g:5520:31: RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7'
                    {
                    mRULE_SKW_BACKSLASH(); 
                    matchRange('0','3'); 
                    matchRange('0','7'); 
                    matchRange('0','7'); 

                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:5520:77: RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7'
                    {
                    mRULE_SKW_BACKSLASH(); 
                    matchRange('0','7'); 
                    matchRange('0','7'); 

                    }
                    break;
                case 3 :
                    // InternalPreprocess.g:5520:114: RULE_SKW_BACKSLASH '0' .. '7'
                    {
                    mRULE_SKW_BACKSLASH(); 
                    matchRange('0','7'); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_OCTAL_ESCAPE"

    // $ANTLR start "RULE_HEX_ESCAPE"
    public final void mRULE_HEX_ESCAPE() throws RecognitionException {
        try {
            // InternalPreprocess.g:5522:26: ( RULE_SKW_BACKSLASH 'x' ( RULE_HEX_DIGIT )+ )
            // InternalPreprocess.g:5522:28: RULE_SKW_BACKSLASH 'x' ( RULE_HEX_DIGIT )+
            {
            mRULE_SKW_BACKSLASH(); 
            match('x'); 
            // InternalPreprocess.g:5522:51: ( RULE_HEX_DIGIT )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>='0' && LA32_0<='9')||(LA32_0>='A' && LA32_0<='F')||(LA32_0>='a' && LA32_0<='f')) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalPreprocess.g:5522:51: RULE_HEX_DIGIT
            	    {
            	    mRULE_HEX_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX_ESCAPE"

    // $ANTLR start "RULE_LINEFEED"
    public final void mRULE_LINEFEED() throws RecognitionException {
        try {
            // InternalPreprocess.g:5524:24: ( '\\n' )
            // InternalPreprocess.g:5524:26: '\\n'
            {
            match('\n'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_LINEFEED"

    // $ANTLR start "RULE_CARRIAGERETURN"
    public final void mRULE_CARRIAGERETURN() throws RecognitionException {
        try {
            // InternalPreprocess.g:5526:30: ( '\\r' )
            // InternalPreprocess.g:5526:32: '\\r'
            {
            match('\r'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_CARRIAGERETURN"

    // $ANTLR start "RULE_LINE_END"
    public final void mRULE_LINE_END() throws RecognitionException {
        try {
            // InternalPreprocess.g:5528:24: ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) )
            // InternalPreprocess.g:5528:26: ( RULE_CARRIAGERETURN | RULE_LINEFEED )
            {
            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_LINE_END"

    // $ANTLR start "RULE_LINEBREAK"
    public final void mRULE_LINEBREAK() throws RecognitionException {
        try {
            int _type = RULE_LINEBREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5530:16: ( RULE_SKW_BACKSLASH RULE_LINE_END )
            // InternalPreprocess.g:5530:18: RULE_SKW_BACKSLASH RULE_LINE_END
            {
            mRULE_SKW_BACKSLASH(); 
            mRULE_LINE_END(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LINEBREAK"

    // $ANTLR start "SUPER_NEWLINE"
    public final void mSUPER_NEWLINE() throws RecognitionException {
        try {
            // InternalPreprocess.g:5532:24: ( RULE_LINE_END )
            // InternalPreprocess.g:5532:26: RULE_LINE_END
            {
            mRULE_LINE_END(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "SUPER_NEWLINE"

    // $ANTLR start "RULE_SPACE"
    public final void mRULE_SPACE() throws RecognitionException {
        try {
            // InternalPreprocess.g:5534:21: ( ' ' )
            // InternalPreprocess.g:5534:23: ' '
            {
            match(' '); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_SPACE"

    // $ANTLR start "RULE_TAB"
    public final void mRULE_TAB() throws RecognitionException {
        try {
            // InternalPreprocess.g:5536:19: ( '\\t' )
            // InternalPreprocess.g:5536:21: '\\t'
            {
            match('\t'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_TAB"

    // $ANTLR start "RULE_WHITESPACE"
    public final void mRULE_WHITESPACE() throws RecognitionException {
        try {
            int _type = RULE_WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5538:17: ( ( RULE_SPACE | RULE_TAB ) )
            // InternalPreprocess.g:5538:19: ( RULE_SPACE | RULE_TAB )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WHITESPACE"

    // $ANTLR start "RULE_BLOCK_COMMENT"
    public final void mRULE_BLOCK_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_BLOCK_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5540:20: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalPreprocess.g:5540:22: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalPreprocess.g:5540:27: ( options {greedy=false; } : . )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0=='*') ) {
                    int LA33_1 = input.LA(2);

                    if ( (LA33_1=='/') ) {
                        alt33=2;
                    }
                    else if ( ((LA33_1>='\u0000' && LA33_1<='.')||(LA33_1>='0' && LA33_1<='\uFFFF')) ) {
                        alt33=1;
                    }


                }
                else if ( ((LA33_0>='\u0000' && LA33_0<=')')||(LA33_0>='+' && LA33_0<='\uFFFF')) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalPreprocess.g:5540:55: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BLOCK_COMMENT"

    // $ANTLR start "RULE_LINE_COMMENT"
    public final void mRULE_LINE_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5542:19: ( '//' (~ ( RULE_LINE_END ) )* )
            // InternalPreprocess.g:5542:21: '//' (~ ( RULE_LINE_END ) )*
            {
            match("//"); 

            // InternalPreprocess.g:5542:26: (~ ( RULE_LINE_END ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>='\u0000' && LA34_0<='\t')||(LA34_0>='\u000B' && LA34_0<='\f')||(LA34_0>='\u000E' && LA34_0<='\uFFFF')) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalPreprocess.g:5542:26: ~ ( RULE_LINE_END )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LINE_COMMENT"

    // $ANTLR start "RULE_SPECIAL"
    public final void mRULE_SPECIAL() throws RecognitionException {
        try {
            int _type = RULE_SPECIAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5544:14: ( . )
            // InternalPreprocess.g:5544:16: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SPECIAL"

    public void mTokens() throws RecognitionException {
        // InternalPreprocess.g:1:8: ( RULE_HASH | RULE_INCLUDE | RULE_DEFINE | RULE_ERROR | RULE_WARNING | RULE_UNDEF | RULE_IF | RULE_DEFINED | RULE_IFDEF | RULE_IFNOTDEF | RULE_ELIF | RULE_ELSE | RULE_ENDIF | RULE_PRAGMA | RULE_NEWLINE | RULE_SKW_AND | RULE_SKW_ANDAND | RULE_SKW_ASSIGN | RULE_SKW_BACKSLASH | RULE_SKW_CARET | RULE_SKW_COMMA | RULE_SKW_COLON | RULE_SKW_DIV | RULE_SKW_DOT | RULE_SKW_DOUBLEQUOTE | RULE_SKW_EQUAL | RULE_SKW_GREATER | RULE_SKW_GREATEREQUAL | RULE_SKW_LEFTBRACE | RULE_SKW_LEFTBRACKET | RULE_SKW_LEFTPAREN | RULE_SKW_LEFTSHIFT | RULE_SKW_LESS | RULE_SKW_LESSEQUAL | RULE_SKW_MINUS | RULE_SKW_MINUSMINUS | RULE_SKW_MOD | RULE_SKW_NOT | RULE_SKW_NOTEQUAL | RULE_SKW_OR | RULE_SKW_OROR | RULE_SKW_PLUS | RULE_SKW_PLUSPLUS | RULE_SKW_QUESTION | RULE_SKW_RIGHTBRACE | RULE_SKW_RIGHTBRACKET | RULE_SKW_RIGHTPAREN | RULE_SKW_RIGHTSHIFT | RULE_SKW_SEMI | RULE_SKW_SINGLEQUOTE | RULE_SKW_STAR | RULE_SKW_TILDE | RULE_ID | RULE_CHAR_LITERAL | RULE_STRING_LITERAL | RULE_HEX_LITERAL | RULE_DECIMAL_LITERAL | RULE_OCTAL_LITERAL | RULE_BIN_LITERAL | RULE_FLOAT_LITERAL | RULE_LINEBREAK | RULE_WHITESPACE | RULE_BLOCK_COMMENT | RULE_LINE_COMMENT | RULE_SPECIAL )
        int alt35=65;
        alt35 = dfa35.predict(input);
        switch (alt35) {
            case 1 :
                // InternalPreprocess.g:1:10: RULE_HASH
                {
                mRULE_HASH(); 

                }
                break;
            case 2 :
                // InternalPreprocess.g:1:20: RULE_INCLUDE
                {
                mRULE_INCLUDE(); 

                }
                break;
            case 3 :
                // InternalPreprocess.g:1:33: RULE_DEFINE
                {
                mRULE_DEFINE(); 

                }
                break;
            case 4 :
                // InternalPreprocess.g:1:45: RULE_ERROR
                {
                mRULE_ERROR(); 

                }
                break;
            case 5 :
                // InternalPreprocess.g:1:56: RULE_WARNING
                {
                mRULE_WARNING(); 

                }
                break;
            case 6 :
                // InternalPreprocess.g:1:69: RULE_UNDEF
                {
                mRULE_UNDEF(); 

                }
                break;
            case 7 :
                // InternalPreprocess.g:1:80: RULE_IF
                {
                mRULE_IF(); 

                }
                break;
            case 8 :
                // InternalPreprocess.g:1:88: RULE_DEFINED
                {
                mRULE_DEFINED(); 

                }
                break;
            case 9 :
                // InternalPreprocess.g:1:101: RULE_IFDEF
                {
                mRULE_IFDEF(); 

                }
                break;
            case 10 :
                // InternalPreprocess.g:1:112: RULE_IFNOTDEF
                {
                mRULE_IFNOTDEF(); 

                }
                break;
            case 11 :
                // InternalPreprocess.g:1:126: RULE_ELIF
                {
                mRULE_ELIF(); 

                }
                break;
            case 12 :
                // InternalPreprocess.g:1:136: RULE_ELSE
                {
                mRULE_ELSE(); 

                }
                break;
            case 13 :
                // InternalPreprocess.g:1:146: RULE_ENDIF
                {
                mRULE_ENDIF(); 

                }
                break;
            case 14 :
                // InternalPreprocess.g:1:157: RULE_PRAGMA
                {
                mRULE_PRAGMA(); 

                }
                break;
            case 15 :
                // InternalPreprocess.g:1:169: RULE_NEWLINE
                {
                mRULE_NEWLINE(); 

                }
                break;
            case 16 :
                // InternalPreprocess.g:1:182: RULE_SKW_AND
                {
                mRULE_SKW_AND(); 

                }
                break;
            case 17 :
                // InternalPreprocess.g:1:195: RULE_SKW_ANDAND
                {
                mRULE_SKW_ANDAND(); 

                }
                break;
            case 18 :
                // InternalPreprocess.g:1:211: RULE_SKW_ASSIGN
                {
                mRULE_SKW_ASSIGN(); 

                }
                break;
            case 19 :
                // InternalPreprocess.g:1:227: RULE_SKW_BACKSLASH
                {
                mRULE_SKW_BACKSLASH(); 

                }
                break;
            case 20 :
                // InternalPreprocess.g:1:246: RULE_SKW_CARET
                {
                mRULE_SKW_CARET(); 

                }
                break;
            case 21 :
                // InternalPreprocess.g:1:261: RULE_SKW_COMMA
                {
                mRULE_SKW_COMMA(); 

                }
                break;
            case 22 :
                // InternalPreprocess.g:1:276: RULE_SKW_COLON
                {
                mRULE_SKW_COLON(); 

                }
                break;
            case 23 :
                // InternalPreprocess.g:1:291: RULE_SKW_DIV
                {
                mRULE_SKW_DIV(); 

                }
                break;
            case 24 :
                // InternalPreprocess.g:1:304: RULE_SKW_DOT
                {
                mRULE_SKW_DOT(); 

                }
                break;
            case 25 :
                // InternalPreprocess.g:1:317: RULE_SKW_DOUBLEQUOTE
                {
                mRULE_SKW_DOUBLEQUOTE(); 

                }
                break;
            case 26 :
                // InternalPreprocess.g:1:338: RULE_SKW_EQUAL
                {
                mRULE_SKW_EQUAL(); 

                }
                break;
            case 27 :
                // InternalPreprocess.g:1:353: RULE_SKW_GREATER
                {
                mRULE_SKW_GREATER(); 

                }
                break;
            case 28 :
                // InternalPreprocess.g:1:370: RULE_SKW_GREATEREQUAL
                {
                mRULE_SKW_GREATEREQUAL(); 

                }
                break;
            case 29 :
                // InternalPreprocess.g:1:392: RULE_SKW_LEFTBRACE
                {
                mRULE_SKW_LEFTBRACE(); 

                }
                break;
            case 30 :
                // InternalPreprocess.g:1:411: RULE_SKW_LEFTBRACKET
                {
                mRULE_SKW_LEFTBRACKET(); 

                }
                break;
            case 31 :
                // InternalPreprocess.g:1:432: RULE_SKW_LEFTPAREN
                {
                mRULE_SKW_LEFTPAREN(); 

                }
                break;
            case 32 :
                // InternalPreprocess.g:1:451: RULE_SKW_LEFTSHIFT
                {
                mRULE_SKW_LEFTSHIFT(); 

                }
                break;
            case 33 :
                // InternalPreprocess.g:1:470: RULE_SKW_LESS
                {
                mRULE_SKW_LESS(); 

                }
                break;
            case 34 :
                // InternalPreprocess.g:1:484: RULE_SKW_LESSEQUAL
                {
                mRULE_SKW_LESSEQUAL(); 

                }
                break;
            case 35 :
                // InternalPreprocess.g:1:503: RULE_SKW_MINUS
                {
                mRULE_SKW_MINUS(); 

                }
                break;
            case 36 :
                // InternalPreprocess.g:1:518: RULE_SKW_MINUSMINUS
                {
                mRULE_SKW_MINUSMINUS(); 

                }
                break;
            case 37 :
                // InternalPreprocess.g:1:538: RULE_SKW_MOD
                {
                mRULE_SKW_MOD(); 

                }
                break;
            case 38 :
                // InternalPreprocess.g:1:551: RULE_SKW_NOT
                {
                mRULE_SKW_NOT(); 

                }
                break;
            case 39 :
                // InternalPreprocess.g:1:564: RULE_SKW_NOTEQUAL
                {
                mRULE_SKW_NOTEQUAL(); 

                }
                break;
            case 40 :
                // InternalPreprocess.g:1:582: RULE_SKW_OR
                {
                mRULE_SKW_OR(); 

                }
                break;
            case 41 :
                // InternalPreprocess.g:1:594: RULE_SKW_OROR
                {
                mRULE_SKW_OROR(); 

                }
                break;
            case 42 :
                // InternalPreprocess.g:1:608: RULE_SKW_PLUS
                {
                mRULE_SKW_PLUS(); 

                }
                break;
            case 43 :
                // InternalPreprocess.g:1:622: RULE_SKW_PLUSPLUS
                {
                mRULE_SKW_PLUSPLUS(); 

                }
                break;
            case 44 :
                // InternalPreprocess.g:1:640: RULE_SKW_QUESTION
                {
                mRULE_SKW_QUESTION(); 

                }
                break;
            case 45 :
                // InternalPreprocess.g:1:658: RULE_SKW_RIGHTBRACE
                {
                mRULE_SKW_RIGHTBRACE(); 

                }
                break;
            case 46 :
                // InternalPreprocess.g:1:678: RULE_SKW_RIGHTBRACKET
                {
                mRULE_SKW_RIGHTBRACKET(); 

                }
                break;
            case 47 :
                // InternalPreprocess.g:1:700: RULE_SKW_RIGHTPAREN
                {
                mRULE_SKW_RIGHTPAREN(); 

                }
                break;
            case 48 :
                // InternalPreprocess.g:1:720: RULE_SKW_RIGHTSHIFT
                {
                mRULE_SKW_RIGHTSHIFT(); 

                }
                break;
            case 49 :
                // InternalPreprocess.g:1:740: RULE_SKW_SEMI
                {
                mRULE_SKW_SEMI(); 

                }
                break;
            case 50 :
                // InternalPreprocess.g:1:754: RULE_SKW_SINGLEQUOTE
                {
                mRULE_SKW_SINGLEQUOTE(); 

                }
                break;
            case 51 :
                // InternalPreprocess.g:1:775: RULE_SKW_STAR
                {
                mRULE_SKW_STAR(); 

                }
                break;
            case 52 :
                // InternalPreprocess.g:1:789: RULE_SKW_TILDE
                {
                mRULE_SKW_TILDE(); 

                }
                break;
            case 53 :
                // InternalPreprocess.g:1:804: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 54 :
                // InternalPreprocess.g:1:812: RULE_CHAR_LITERAL
                {
                mRULE_CHAR_LITERAL(); 

                }
                break;
            case 55 :
                // InternalPreprocess.g:1:830: RULE_STRING_LITERAL
                {
                mRULE_STRING_LITERAL(); 

                }
                break;
            case 56 :
                // InternalPreprocess.g:1:850: RULE_HEX_LITERAL
                {
                mRULE_HEX_LITERAL(); 

                }
                break;
            case 57 :
                // InternalPreprocess.g:1:867: RULE_DECIMAL_LITERAL
                {
                mRULE_DECIMAL_LITERAL(); 

                }
                break;
            case 58 :
                // InternalPreprocess.g:1:888: RULE_OCTAL_LITERAL
                {
                mRULE_OCTAL_LITERAL(); 

                }
                break;
            case 59 :
                // InternalPreprocess.g:1:907: RULE_BIN_LITERAL
                {
                mRULE_BIN_LITERAL(); 

                }
                break;
            case 60 :
                // InternalPreprocess.g:1:924: RULE_FLOAT_LITERAL
                {
                mRULE_FLOAT_LITERAL(); 

                }
                break;
            case 61 :
                // InternalPreprocess.g:1:943: RULE_LINEBREAK
                {
                mRULE_LINEBREAK(); 

                }
                break;
            case 62 :
                // InternalPreprocess.g:1:958: RULE_WHITESPACE
                {
                mRULE_WHITESPACE(); 

                }
                break;
            case 63 :
                // InternalPreprocess.g:1:974: RULE_BLOCK_COMMENT
                {
                mRULE_BLOCK_COMMENT(); 

                }
                break;
            case 64 :
                // InternalPreprocess.g:1:993: RULE_LINE_COMMENT
                {
                mRULE_LINE_COMMENT(); 

                }
                break;
            case 65 :
                // InternalPreprocess.g:1:1011: RULE_SPECIAL
                {
                mRULE_SPECIAL(); 

                }
                break;

        }

    }


    protected DFA27 dfa27 = new DFA27(this);
    protected DFA35 dfa35 = new DFA35(this);
    static final String DFA27_eotS =
        "\7\uffff\1\10\2\uffff";
    static final String DFA27_eofS =
        "\12\uffff";
    static final String DFA27_minS =
        "\2\56\1\uffff\1\53\2\uffff\2\60\2\uffff";
    static final String DFA27_maxS =
        "\1\71\1\146\1\uffff\1\71\2\uffff\1\71\1\146\2\uffff";
    static final String DFA27_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\1\1\2\uffff\2\3";
    static final String DFA27_specialS =
        "\12\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\5\1\uffff\12\1\12\uffff\1\4\1\3\1\4\35\uffff\1\4\1\3\1\4",
            "",
            "\1\6\1\uffff\1\6\2\uffff\12\7",
            "",
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

    class DFA27 extends DFA {

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
        public String getDescription() {
            return "5512:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )";
        }
    }
    static final String DFA35_eotS =
        "\2\uffff\6\54\1\uffff\1\65\1\67\1\71\3\uffff\1\100\1\101\1\103\1\105\3\uffff\1\113\1\116\1\uffff\1\121\1\123\1\125\5\uffff\1\134\3\uffff\2\143\3\uffff\1\54\1\151\1\uffff\7\54\56\uffff\1\162\1\uffff\1\143\1\uffff\3\54\1\uffff\10\54\1\uffff\5\54\1\u0083\1\u0084\5\54\1\u008a\2\54\1\u008d\2\uffff\1\u008e\1\54\1\u0090\2\54\1\uffff\1\u0093\1\u0095\2\uffff\1\54\1\uffff\1\u0097\1\u0098\1\uffff\1\u0099\1\uffff\1\u009a\4\uffff";
    static final String DFA35_eofS =
        "\u009b\uffff";
    static final String DFA35_minS =
        "\1\0\1\uffff\1\146\1\145\1\154\1\141\1\156\1\162\1\uffff\1\46\1\75\1\12\3\uffff\1\52\1\60\1\0\1\75\3\uffff\1\74\1\55\1\uffff\1\75\1\174\1\53\5\uffff\1\0\3\uffff\2\56\3\uffff\1\143\1\44\1\uffff\1\146\1\162\1\151\1\144\1\162\1\144\1\141\56\uffff\1\56\1\uffff\1\56\1\uffff\1\154\1\145\1\144\1\uffff\1\151\1\157\1\146\1\145\1\151\1\156\1\145\1\147\1\uffff\1\165\1\146\1\145\1\156\1\162\2\44\1\146\1\151\1\146\1\155\1\144\1\44\1\146\1\145\1\44\2\uffff\1\44\1\156\1\44\1\141\1\145\1\uffff\2\44\2\uffff\1\147\1\uffff\2\44\1\uffff\1\44\1\uffff\1\44\4\uffff";
    static final String DFA35_maxS =
        "\1\uffff\1\uffff\1\156\1\145\1\162\1\141\1\156\1\162\1\uffff\1\46\1\75\1\15\3\uffff\1\57\1\71\1\uffff\1\76\3\uffff\1\75\1\55\1\uffff\1\75\1\174\1\53\5\uffff\1\uffff\3\uffff\1\170\1\146\3\uffff\1\143\1\172\1\uffff\1\146\1\162\1\163\1\144\1\162\1\144\1\141\56\uffff\1\146\1\uffff\1\146\1\uffff\1\154\1\145\1\144\1\uffff\1\151\1\157\1\146\1\145\1\151\1\156\1\145\1\147\1\uffff\1\165\1\146\1\145\1\156\1\162\2\172\1\146\1\151\1\146\1\155\1\144\1\172\1\146\1\145\1\172\2\uffff\1\172\1\156\1\172\1\141\1\145\1\uffff\2\172\2\uffff\1\147\1\uffff\2\172\1\uffff\1\172\1\uffff\1\172\4\uffff";
    static final String DFA35_acceptS =
        "\1\uffff\1\1\6\uffff\1\17\3\uffff\1\24\1\25\1\26\4\uffff\1\35\1\36\1\37\2\uffff\1\45\3\uffff\1\54\1\55\1\56\1\57\1\61\1\uffff\1\63\1\64\1\65\2\uffff\1\76\1\101\1\1\2\uffff\1\65\7\uffff\1\17\1\20\1\21\1\22\1\32\1\23\1\75\1\24\1\25\1\26\1\77\1\100\1\27\1\30\1\74\1\31\1\67\1\33\1\34\1\60\1\35\1\36\1\37\1\41\1\40\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\61\1\62\1\66\1\63\1\64\1\70\1\73\1\uffff\1\71\1\uffff\1\76\3\uffff\1\7\10\uffff\1\72\20\uffff\1\13\1\14\5\uffff\1\11\2\uffff\1\4\1\15\1\uffff\1\6\2\uffff\1\12\1\uffff\1\3\1\uffff\1\16\1\2\1\10\1\5";
    static final String DFA35_specialS =
        "\1\0\20\uffff\1\1\17\uffff\1\2\171\uffff}>";
    static final String[] DFA35_transitionS = {
            "\11\50\1\47\1\10\2\50\1\10\22\50\1\47\1\31\1\21\1\1\1\44\1\30\1\11\1\41\1\25\1\37\1\42\1\33\1\15\1\27\1\20\1\17\1\45\11\46\1\16\1\40\1\26\1\12\1\22\1\34\1\50\32\44\1\24\1\13\1\36\1\14\1\44\1\50\3\44\1\3\1\4\3\44\1\2\6\44\1\7\4\44\1\6\1\44\1\5\3\44\1\23\1\32\1\35\1\43\uff81\50",
            "",
            "\1\53\7\uffff\1\52",
            "\1\55",
            "\1\57\1\uffff\1\60\3\uffff\1\56",
            "\1\61",
            "\1\62",
            "\1\63",
            "",
            "\1\66",
            "\1\70",
            "\1\72\2\uffff\1\72",
            "",
            "",
            "",
            "\1\76\4\uffff\1\77",
            "\12\102",
            "\0\104",
            "\1\106\1\107",
            "",
            "",
            "",
            "\1\114\1\115",
            "\1\117",
            "",
            "\1\122",
            "\1\124",
            "\1\126",
            "",
            "",
            "",
            "",
            "",
            "\47\135\1\uffff\uffd8\135",
            "",
            "",
            "",
            "\1\102\1\uffff\10\142\2\102\10\uffff\1\141\1\uffff\3\102\21\uffff\1\140\11\uffff\1\141\1\uffff\3\102\21\uffff\1\140",
            "\1\102\1\uffff\12\144\12\uffff\3\102\35\uffff\3\102",
            "",
            "",
            "",
            "\1\146",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\3\54\1\147\11\54\1\150\14\54",
            "",
            "\1\152",
            "\1\153",
            "\1\154\11\uffff\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\102\1\uffff\10\142\2\102\12\uffff\3\102\35\uffff\3\102",
            "",
            "\1\102\1\uffff\12\144\12\uffff\3\102\35\uffff\3\102",
            "",
            "\1\163",
            "\1\164",
            "\1\165",
            "",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u008b",
            "\1\u008c",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u008f",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u0091",
            "\1\u0092",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\3\54\1\u0094\26\54",
            "",
            "",
            "\1\u0096",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA35_eot = DFA.unpackEncodedString(DFA35_eotS);
    static final short[] DFA35_eof = DFA.unpackEncodedString(DFA35_eofS);
    static final char[] DFA35_min = DFA.unpackEncodedStringToUnsignedChars(DFA35_minS);
    static final char[] DFA35_max = DFA.unpackEncodedStringToUnsignedChars(DFA35_maxS);
    static final short[] DFA35_accept = DFA.unpackEncodedString(DFA35_acceptS);
    static final short[] DFA35_special = DFA.unpackEncodedString(DFA35_specialS);
    static final short[][] DFA35_transition;

    static {
        int numStates = DFA35_transitionS.length;
        DFA35_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA35_transition[i] = DFA.unpackEncodedString(DFA35_transitionS[i]);
        }
    }

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = DFA35_eot;
            this.eof = DFA35_eof;
            this.min = DFA35_min;
            this.max = DFA35_max;
            this.accept = DFA35_accept;
            this.special = DFA35_special;
            this.transition = DFA35_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( RULE_HASH | RULE_INCLUDE | RULE_DEFINE | RULE_ERROR | RULE_WARNING | RULE_UNDEF | RULE_IF | RULE_DEFINED | RULE_IFDEF | RULE_IFNOTDEF | RULE_ELIF | RULE_ELSE | RULE_ENDIF | RULE_PRAGMA | RULE_NEWLINE | RULE_SKW_AND | RULE_SKW_ANDAND | RULE_SKW_ASSIGN | RULE_SKW_BACKSLASH | RULE_SKW_CARET | RULE_SKW_COMMA | RULE_SKW_COLON | RULE_SKW_DIV | RULE_SKW_DOT | RULE_SKW_DOUBLEQUOTE | RULE_SKW_EQUAL | RULE_SKW_GREATER | RULE_SKW_GREATEREQUAL | RULE_SKW_LEFTBRACE | RULE_SKW_LEFTBRACKET | RULE_SKW_LEFTPAREN | RULE_SKW_LEFTSHIFT | RULE_SKW_LESS | RULE_SKW_LESSEQUAL | RULE_SKW_MINUS | RULE_SKW_MINUSMINUS | RULE_SKW_MOD | RULE_SKW_NOT | RULE_SKW_NOTEQUAL | RULE_SKW_OR | RULE_SKW_OROR | RULE_SKW_PLUS | RULE_SKW_PLUSPLUS | RULE_SKW_QUESTION | RULE_SKW_RIGHTBRACE | RULE_SKW_RIGHTBRACKET | RULE_SKW_RIGHTPAREN | RULE_SKW_RIGHTSHIFT | RULE_SKW_SEMI | RULE_SKW_SINGLEQUOTE | RULE_SKW_STAR | RULE_SKW_TILDE | RULE_ID | RULE_CHAR_LITERAL | RULE_STRING_LITERAL | RULE_HEX_LITERAL | RULE_DECIMAL_LITERAL | RULE_OCTAL_LITERAL | RULE_BIN_LITERAL | RULE_FLOAT_LITERAL | RULE_LINEBREAK | RULE_WHITESPACE | RULE_BLOCK_COMMENT | RULE_LINE_COMMENT | RULE_SPECIAL );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA35_0 = input.LA(1);

                        s = -1;
                        if ( (LA35_0=='#') ) {s = 1;}

                        else if ( (LA35_0=='i') ) {s = 2;}

                        else if ( (LA35_0=='d') ) {s = 3;}

                        else if ( (LA35_0=='e') ) {s = 4;}

                        else if ( (LA35_0=='w') ) {s = 5;}

                        else if ( (LA35_0=='u') ) {s = 6;}

                        else if ( (LA35_0=='p') ) {s = 7;}

                        else if ( (LA35_0=='\n'||LA35_0=='\r') ) {s = 8;}

                        else if ( (LA35_0=='&') ) {s = 9;}

                        else if ( (LA35_0=='=') ) {s = 10;}

                        else if ( (LA35_0=='\\') ) {s = 11;}

                        else if ( (LA35_0=='^') ) {s = 12;}

                        else if ( (LA35_0==',') ) {s = 13;}

                        else if ( (LA35_0==':') ) {s = 14;}

                        else if ( (LA35_0=='/') ) {s = 15;}

                        else if ( (LA35_0=='.') ) {s = 16;}

                        else if ( (LA35_0=='\"') ) {s = 17;}

                        else if ( (LA35_0=='>') ) {s = 18;}

                        else if ( (LA35_0=='{') ) {s = 19;}

                        else if ( (LA35_0=='[') ) {s = 20;}

                        else if ( (LA35_0=='(') ) {s = 21;}

                        else if ( (LA35_0=='<') ) {s = 22;}

                        else if ( (LA35_0=='-') ) {s = 23;}

                        else if ( (LA35_0=='%') ) {s = 24;}

                        else if ( (LA35_0=='!') ) {s = 25;}

                        else if ( (LA35_0=='|') ) {s = 26;}

                        else if ( (LA35_0=='+') ) {s = 27;}

                        else if ( (LA35_0=='?') ) {s = 28;}

                        else if ( (LA35_0=='}') ) {s = 29;}

                        else if ( (LA35_0==']') ) {s = 30;}

                        else if ( (LA35_0==')') ) {s = 31;}

                        else if ( (LA35_0==';') ) {s = 32;}

                        else if ( (LA35_0=='\'') ) {s = 33;}

                        else if ( (LA35_0=='*') ) {s = 34;}

                        else if ( (LA35_0=='~') ) {s = 35;}

                        else if ( (LA35_0=='$'||(LA35_0>='A' && LA35_0<='Z')||LA35_0=='_'||(LA35_0>='a' && LA35_0<='c')||(LA35_0>='f' && LA35_0<='h')||(LA35_0>='j' && LA35_0<='o')||(LA35_0>='q' && LA35_0<='t')||LA35_0=='v'||(LA35_0>='x' && LA35_0<='z')) ) {s = 36;}

                        else if ( (LA35_0=='0') ) {s = 37;}

                        else if ( ((LA35_0>='1' && LA35_0<='9')) ) {s = 38;}

                        else if ( (LA35_0=='\t'||LA35_0==' ') ) {s = 39;}

                        else if ( ((LA35_0>='\u0000' && LA35_0<='\b')||(LA35_0>='\u000B' && LA35_0<='\f')||(LA35_0>='\u000E' && LA35_0<='\u001F')||LA35_0=='@'||LA35_0=='`'||(LA35_0>='\u007F' && LA35_0<='\uFFFF')) ) {s = 40;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA35_17 = input.LA(1);

                        s = -1;
                        if ( ((LA35_17>='\u0000' && LA35_17<='\uFFFF')) ) {s = 68;}

                        else s = 67;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA35_33 = input.LA(1);

                        s = -1;
                        if ( ((LA35_33>='\u0000' && LA35_33<='&')||(LA35_33>='(' && LA35_33<='\uFFFF')) ) {s = 93;}

                        else s = 92;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 35, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}