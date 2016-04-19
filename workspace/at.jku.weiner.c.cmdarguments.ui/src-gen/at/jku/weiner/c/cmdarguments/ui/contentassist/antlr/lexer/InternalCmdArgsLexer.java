package at.jku.weiner.c.cmdarguments.ui.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalCmdArgsLexer extends Lexer {
    public static final int RULE_SKW_MINUS=7;
    public static final int RULE_ID=24;
    public static final int RULE_NEWLINE=29;
    public static final int RULE_ID_PART_1=22;
    public static final int RULE_KW_INCDIR=15;
    public static final int RULE_ID_PART_2=23;
    public static final int RULE_KW_OUTPUT=16;
    public static final int RULE_ANY_OTHER=34;
    public static final int RULE_SKW_DOLLAR=12;
    public static final int RULE_KW_NOSTDINC=18;
    public static final int RULE_SKW_DOT=4;
    public static final int RULE_SKW_DIV=5;
    public static final int RULE_LINE_BREAK=32;
    public static final int EOF=-1;
    public static final int RULE_LETTER=25;
    public static final int RULE_KW_VAR=21;
    public static final int RULE_SKW_RIGHTPAREN=10;
    public static final int RULE_STRING2=28;
    public static final int RULE_KW_INCLUDE=20;
    public static final int RULE_KW_DEFINE=14;
    public static final int RULE_KW_LANG=17;
    public static final int RULE_LINE_COMMENT=33;
    public static final int RULE_KW_INCSYS=19;
    public static final int RULE_INT=26;
    public static final int RULE_SKW_BACKSLASH=13;
    public static final int RULE_SKW_COMMA=11;
    public static final int RULE_WS=30;
    public static final int RULE_DIGIT=27;
    public static final int RULE_SKW_COLON=6;
    public static final int RULE_SKW_HASH=31;
    public static final int RULE_SKW_ASSIGN=8;
    public static final int RULE_SKW_LEFTPAREN=9;

    // delegates
    // delegators

    public InternalCmdArgsLexer() {;} 
    public InternalCmdArgsLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalCmdArgsLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalCmdArgsLexer.g"; }

    // $ANTLR start "RULE_SKW_DOT"
    public final void mRULE_SKW_DOT() throws RecognitionException {
        try {
            // InternalCmdArgsLexer.g:21:23: ( '.' )
            // InternalCmdArgsLexer.g:21:25: '.'
            {
            match('.'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_DOT"

    // $ANTLR start "RULE_SKW_DIV"
    public final void mRULE_SKW_DIV() throws RecognitionException {
        try {
            // InternalCmdArgsLexer.g:23:23: ( '/' )
            // InternalCmdArgsLexer.g:23:25: '/'
            {
            match('/'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_DIV"

    // $ANTLR start "RULE_SKW_COLON"
    public final void mRULE_SKW_COLON() throws RecognitionException {
        try {
            int _type = RULE_SKW_COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:25:16: ( ':' )
            // InternalCmdArgsLexer.g:25:18: ':'
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

    // $ANTLR start "RULE_SKW_MINUS"
    public final void mRULE_SKW_MINUS() throws RecognitionException {
        try {
            int _type = RULE_SKW_MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:27:16: ( '-' )
            // InternalCmdArgsLexer.g:27:18: '-'
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

    // $ANTLR start "RULE_SKW_ASSIGN"
    public final void mRULE_SKW_ASSIGN() throws RecognitionException {
        try {
            int _type = RULE_SKW_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:29:17: ( '=' )
            // InternalCmdArgsLexer.g:29:19: '='
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

    // $ANTLR start "RULE_SKW_LEFTPAREN"
    public final void mRULE_SKW_LEFTPAREN() throws RecognitionException {
        try {
            int _type = RULE_SKW_LEFTPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:31:20: ( '(' )
            // InternalCmdArgsLexer.g:31:22: '('
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

    // $ANTLR start "RULE_SKW_RIGHTPAREN"
    public final void mRULE_SKW_RIGHTPAREN() throws RecognitionException {
        try {
            int _type = RULE_SKW_RIGHTPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:33:21: ( ')' )
            // InternalCmdArgsLexer.g:33:23: ')'
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

    // $ANTLR start "RULE_SKW_COMMA"
    public final void mRULE_SKW_COMMA() throws RecognitionException {
        try {
            int _type = RULE_SKW_COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:35:16: ( ',' )
            // InternalCmdArgsLexer.g:35:18: ','
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

    // $ANTLR start "RULE_SKW_DOLLAR"
    public final void mRULE_SKW_DOLLAR() throws RecognitionException {
        try {
            // InternalCmdArgsLexer.g:37:26: ( '$' )
            // InternalCmdArgsLexer.g:37:28: '$'
            {
            match('$'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_DOLLAR"

    // $ANTLR start "RULE_SKW_BACKSLASH"
    public final void mRULE_SKW_BACKSLASH() throws RecognitionException {
        try {
            // InternalCmdArgsLexer.g:39:29: ( '\\\\' )
            // InternalCmdArgsLexer.g:39:31: '\\\\'
            {
            match('\\'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_BACKSLASH"

    // $ANTLR start "RULE_KW_DEFINE"
    public final void mRULE_KW_DEFINE() throws RecognitionException {
        try {
            int _type = RULE_KW_DEFINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:41:16: ( RULE_SKW_MINUS 'D' )
            // InternalCmdArgsLexer.g:41:18: RULE_SKW_MINUS 'D'
            {
            mRULE_SKW_MINUS(); 
            match('D'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_KW_DEFINE"

    // $ANTLR start "RULE_KW_INCDIR"
    public final void mRULE_KW_INCDIR() throws RecognitionException {
        try {
            int _type = RULE_KW_INCDIR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:43:16: ( RULE_SKW_MINUS 'I' )
            // InternalCmdArgsLexer.g:43:18: RULE_SKW_MINUS 'I'
            {
            mRULE_SKW_MINUS(); 
            match('I'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_KW_INCDIR"

    // $ANTLR start "RULE_KW_OUTPUT"
    public final void mRULE_KW_OUTPUT() throws RecognitionException {
        try {
            int _type = RULE_KW_OUTPUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:45:16: ( RULE_SKW_MINUS 'o' )
            // InternalCmdArgsLexer.g:45:18: RULE_SKW_MINUS 'o'
            {
            mRULE_SKW_MINUS(); 
            match('o'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_KW_OUTPUT"

    // $ANTLR start "RULE_KW_LANG"
    public final void mRULE_KW_LANG() throws RecognitionException {
        try {
            int _type = RULE_KW_LANG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:47:14: ( RULE_SKW_MINUS 'x' )
            // InternalCmdArgsLexer.g:47:16: RULE_SKW_MINUS 'x'
            {
            mRULE_SKW_MINUS(); 
            match('x'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_KW_LANG"

    // $ANTLR start "RULE_KW_NOSTDINC"
    public final void mRULE_KW_NOSTDINC() throws RecognitionException {
        try {
            int _type = RULE_KW_NOSTDINC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:49:18: ( 'nostdinc' )
            // InternalCmdArgsLexer.g:49:20: 'nostdinc'
            {
            match("nostdinc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_KW_NOSTDINC"

    // $ANTLR start "RULE_KW_INCSYS"
    public final void mRULE_KW_INCSYS() throws RecognitionException {
        try {
            int _type = RULE_KW_INCSYS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:51:16: ( 'isystem' )
            // InternalCmdArgsLexer.g:51:18: 'isystem'
            {
            match("isystem"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_KW_INCSYS"

    // $ANTLR start "RULE_KW_INCLUDE"
    public final void mRULE_KW_INCLUDE() throws RecognitionException {
        try {
            int _type = RULE_KW_INCLUDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:53:17: ( 'include' )
            // InternalCmdArgsLexer.g:53:19: 'include'
            {
            match("include"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_KW_INCLUDE"

    // $ANTLR start "RULE_KW_VAR"
    public final void mRULE_KW_VAR() throws RecognitionException {
        try {
            int _type = RULE_KW_VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:55:13: ( RULE_SKW_DOLLAR RULE_SKW_LEFTPAREN ( options {greedy=false; } : . )* RULE_SKW_RIGHTPAREN )
            // InternalCmdArgsLexer.g:55:15: RULE_SKW_DOLLAR RULE_SKW_LEFTPAREN ( options {greedy=false; } : . )* RULE_SKW_RIGHTPAREN
            {
            mRULE_SKW_DOLLAR(); 
            mRULE_SKW_LEFTPAREN(); 
            // InternalCmdArgsLexer.g:55:50: ( options {greedy=false; } : . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==')') ) {
                    alt1=2;
                }
                else if ( ((LA1_0>='\u0000' && LA1_0<='(')||(LA1_0>='*' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalCmdArgsLexer.g:55:78: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            mRULE_SKW_RIGHTPAREN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_KW_VAR"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:57:9: ( RULE_ID_PART_1 ( RULE_ID_PART_2 )* )
            // InternalCmdArgsLexer.g:57:11: RULE_ID_PART_1 ( RULE_ID_PART_2 )*
            {
            mRULE_ID_PART_1(); 
            // InternalCmdArgsLexer.g:57:26: ( RULE_ID_PART_2 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='-' && LA2_0<=':')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='\\'||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalCmdArgsLexer.g:57:26: RULE_ID_PART_2
            	    {
            	    mRULE_ID_PART_2(); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_ID_PART_1"
    public final void mRULE_ID_PART_1() throws RecognitionException {
        try {
            // InternalCmdArgsLexer.g:59:25: ( ( RULE_LETTER | RULE_SKW_DIV | RULE_SKW_DOT | RULE_INT ) )
            // InternalCmdArgsLexer.g:59:27: ( RULE_LETTER | RULE_SKW_DIV | RULE_SKW_DOT | RULE_INT )
            {
            // InternalCmdArgsLexer.g:59:27: ( RULE_LETTER | RULE_SKW_DIV | RULE_SKW_DOT | RULE_INT )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case '_':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt3=1;
                }
                break;
            case '/':
                {
                alt3=2;
                }
                break;
            case '.':
                {
                alt3=3;
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
            case '8':
            case '9':
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalCmdArgsLexer.g:59:28: RULE_LETTER
                    {
                    mRULE_LETTER(); 

                    }
                    break;
                case 2 :
                    // InternalCmdArgsLexer.g:59:40: RULE_SKW_DIV
                    {
                    mRULE_SKW_DIV(); 

                    }
                    break;
                case 3 :
                    // InternalCmdArgsLexer.g:59:53: RULE_SKW_DOT
                    {
                    mRULE_SKW_DOT(); 

                    }
                    break;
                case 4 :
                    // InternalCmdArgsLexer.g:59:66: RULE_INT
                    {
                    mRULE_INT(); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID_PART_1"

    // $ANTLR start "RULE_ID_PART_2"
    public final void mRULE_ID_PART_2() throws RecognitionException {
        try {
            // InternalCmdArgsLexer.g:61:25: ( ( RULE_ID_PART_1 | RULE_SKW_COLON RULE_SKW_BACKSLASH | RULE_SKW_BACKSLASH | RULE_SKW_MINUS ) )
            // InternalCmdArgsLexer.g:61:27: ( RULE_ID_PART_1 | RULE_SKW_COLON RULE_SKW_BACKSLASH | RULE_SKW_BACKSLASH | RULE_SKW_MINUS )
            {
            // InternalCmdArgsLexer.g:61:27: ( RULE_ID_PART_1 | RULE_SKW_COLON RULE_SKW_BACKSLASH | RULE_SKW_BACKSLASH | RULE_SKW_MINUS )
            int alt4=4;
            switch ( input.LA(1) ) {
            case '.':
            case '/':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case '_':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt4=1;
                }
                break;
            case ':':
                {
                alt4=2;
                }
                break;
            case '\\':
                {
                alt4=3;
                }
                break;
            case '-':
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalCmdArgsLexer.g:61:28: RULE_ID_PART_1
                    {
                    mRULE_ID_PART_1(); 

                    }
                    break;
                case 2 :
                    // InternalCmdArgsLexer.g:61:43: RULE_SKW_COLON RULE_SKW_BACKSLASH
                    {
                    mRULE_SKW_COLON(); 
                    mRULE_SKW_BACKSLASH(); 

                    }
                    break;
                case 3 :
                    // InternalCmdArgsLexer.g:61:77: RULE_SKW_BACKSLASH
                    {
                    mRULE_SKW_BACKSLASH(); 

                    }
                    break;
                case 4 :
                    // InternalCmdArgsLexer.g:61:96: RULE_SKW_MINUS
                    {
                    mRULE_SKW_MINUS(); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID_PART_2"

    // $ANTLR start "RULE_LETTER"
    public final void mRULE_LETTER() throws RecognitionException {
        try {
            // InternalCmdArgsLexer.g:63:22: ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) )
            // InternalCmdArgsLexer.g:63:24: ( 'A' .. 'Z' | 'a' .. 'z' | '_' )
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            // InternalCmdArgsLexer.g:65:19: ( ( RULE_DIGIT )+ )
            // InternalCmdArgsLexer.g:65:21: ( RULE_DIGIT )+
            {
            // InternalCmdArgsLexer.g:65:21: ( RULE_DIGIT )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalCmdArgsLexer.g:65:21: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_DIGIT"
    public final void mRULE_DIGIT() throws RecognitionException {
        try {
            // InternalCmdArgsLexer.g:67:21: ( '0' .. '9' )
            // InternalCmdArgsLexer.g:67:23: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_DIGIT"

    // $ANTLR start "RULE_STRING2"
    public final void mRULE_STRING2() throws RecognitionException {
        try {
            int _type = RULE_STRING2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:69:14: ( ( '\"' ( RULE_SKW_BACKSLASH . | ~ ( ( RULE_SKW_BACKSLASH | '\"' ) ) )* '\"' | '\\'' ( RULE_SKW_BACKSLASH . | ~ ( ( RULE_SKW_BACKSLASH | '\\'' ) ) )* '\\'' ) )
            // InternalCmdArgsLexer.g:69:16: ( '\"' ( RULE_SKW_BACKSLASH . | ~ ( ( RULE_SKW_BACKSLASH | '\"' ) ) )* '\"' | '\\'' ( RULE_SKW_BACKSLASH . | ~ ( ( RULE_SKW_BACKSLASH | '\\'' ) ) )* '\\'' )
            {
            // InternalCmdArgsLexer.g:69:16: ( '\"' ( RULE_SKW_BACKSLASH . | ~ ( ( RULE_SKW_BACKSLASH | '\"' ) ) )* '\"' | '\\'' ( RULE_SKW_BACKSLASH . | ~ ( ( RULE_SKW_BACKSLASH | '\\'' ) ) )* '\\'' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\"') ) {
                alt8=1;
            }
            else if ( (LA8_0=='\'') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalCmdArgsLexer.g:69:17: '\"' ( RULE_SKW_BACKSLASH . | ~ ( ( RULE_SKW_BACKSLASH | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalCmdArgsLexer.g:69:21: ( RULE_SKW_BACKSLASH . | ~ ( ( RULE_SKW_BACKSLASH | '\"' ) ) )*
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\\') ) {
                            alt6=1;
                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalCmdArgsLexer.g:69:22: RULE_SKW_BACKSLASH .
                    	    {
                    	    mRULE_SKW_BACKSLASH(); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalCmdArgsLexer.g:69:43: ~ ( ( RULE_SKW_BACKSLASH | '\"' ) )
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
                    	    break loop6;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalCmdArgsLexer.g:69:77: '\\'' ( RULE_SKW_BACKSLASH . | ~ ( ( RULE_SKW_BACKSLASH | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalCmdArgsLexer.g:69:82: ( RULE_SKW_BACKSLASH . | ~ ( ( RULE_SKW_BACKSLASH | '\\'' ) ) )*
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\\') ) {
                            alt7=1;
                        }
                        else if ( ((LA7_0>='\u0000' && LA7_0<='&')||(LA7_0>='(' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalCmdArgsLexer.g:69:83: RULE_SKW_BACKSLASH .
                    	    {
                    	    mRULE_SKW_BACKSLASH(); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalCmdArgsLexer.g:69:104: ~ ( ( RULE_SKW_BACKSLASH | '\\'' ) )
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

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    match('\''); 

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
    // $ANTLR end "RULE_STRING2"

    // $ANTLR start "RULE_NEWLINE"
    public final void mRULE_NEWLINE() throws RecognitionException {
        try {
            int _type = RULE_NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:71:14: ( ( '\\n' | '\\r' ) )
            // InternalCmdArgsLexer.g:71:16: ( '\\n' | '\\r' )
            {
            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
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
    // $ANTLR end "RULE_NEWLINE"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:73:9: ( ( ' ' | '\\t' ) )
            // InternalCmdArgsLexer.g:73:11: ( ' ' | '\\t' )
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
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_SKW_HASH"
    public final void mRULE_SKW_HASH() throws RecognitionException {
        try {
            // InternalCmdArgsLexer.g:75:24: ( '#' )
            // InternalCmdArgsLexer.g:75:26: '#'
            {
            match('#'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_HASH"

    // $ANTLR start "RULE_LINE_BREAK"
    public final void mRULE_LINE_BREAK() throws RecognitionException {
        try {
            int _type = RULE_LINE_BREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:77:17: ( RULE_SKW_BACKSLASH RULE_NEWLINE )
            // InternalCmdArgsLexer.g:77:19: RULE_SKW_BACKSLASH RULE_NEWLINE
            {
            mRULE_SKW_BACKSLASH(); 
            mRULE_NEWLINE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LINE_BREAK"

    // $ANTLR start "RULE_LINE_COMMENT"
    public final void mRULE_LINE_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:79:19: ( RULE_SKW_HASH ( options {greedy=false; } : . )* RULE_NEWLINE )
            // InternalCmdArgsLexer.g:79:21: RULE_SKW_HASH ( options {greedy=false; } : . )* RULE_NEWLINE
            {
            mRULE_SKW_HASH(); 
            // InternalCmdArgsLexer.g:79:35: ( options {greedy=false; } : . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\n'||LA9_0=='\r') ) {
                    alt9=2;
                }
                else if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalCmdArgsLexer.g:79:63: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            mRULE_NEWLINE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LINE_COMMENT"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:81:16: ( . )
            // InternalCmdArgsLexer.g:81:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalCmdArgsLexer.g:1:8: ( RULE_SKW_COLON | RULE_SKW_MINUS | RULE_SKW_ASSIGN | RULE_SKW_LEFTPAREN | RULE_SKW_RIGHTPAREN | RULE_SKW_COMMA | RULE_KW_DEFINE | RULE_KW_INCDIR | RULE_KW_OUTPUT | RULE_KW_LANG | RULE_KW_NOSTDINC | RULE_KW_INCSYS | RULE_KW_INCLUDE | RULE_KW_VAR | RULE_ID | RULE_STRING2 | RULE_NEWLINE | RULE_WS | RULE_LINE_BREAK | RULE_LINE_COMMENT | RULE_ANY_OTHER )
        int alt10=21;
        alt10 = dfa10.predict(input);
        switch (alt10) {
            case 1 :
                // InternalCmdArgsLexer.g:1:10: RULE_SKW_COLON
                {
                mRULE_SKW_COLON(); 

                }
                break;
            case 2 :
                // InternalCmdArgsLexer.g:1:25: RULE_SKW_MINUS
                {
                mRULE_SKW_MINUS(); 

                }
                break;
            case 3 :
                // InternalCmdArgsLexer.g:1:40: RULE_SKW_ASSIGN
                {
                mRULE_SKW_ASSIGN(); 

                }
                break;
            case 4 :
                // InternalCmdArgsLexer.g:1:56: RULE_SKW_LEFTPAREN
                {
                mRULE_SKW_LEFTPAREN(); 

                }
                break;
            case 5 :
                // InternalCmdArgsLexer.g:1:75: RULE_SKW_RIGHTPAREN
                {
                mRULE_SKW_RIGHTPAREN(); 

                }
                break;
            case 6 :
                // InternalCmdArgsLexer.g:1:95: RULE_SKW_COMMA
                {
                mRULE_SKW_COMMA(); 

                }
                break;
            case 7 :
                // InternalCmdArgsLexer.g:1:110: RULE_KW_DEFINE
                {
                mRULE_KW_DEFINE(); 

                }
                break;
            case 8 :
                // InternalCmdArgsLexer.g:1:125: RULE_KW_INCDIR
                {
                mRULE_KW_INCDIR(); 

                }
                break;
            case 9 :
                // InternalCmdArgsLexer.g:1:140: RULE_KW_OUTPUT
                {
                mRULE_KW_OUTPUT(); 

                }
                break;
            case 10 :
                // InternalCmdArgsLexer.g:1:155: RULE_KW_LANG
                {
                mRULE_KW_LANG(); 

                }
                break;
            case 11 :
                // InternalCmdArgsLexer.g:1:168: RULE_KW_NOSTDINC
                {
                mRULE_KW_NOSTDINC(); 

                }
                break;
            case 12 :
                // InternalCmdArgsLexer.g:1:185: RULE_KW_INCSYS
                {
                mRULE_KW_INCSYS(); 

                }
                break;
            case 13 :
                // InternalCmdArgsLexer.g:1:200: RULE_KW_INCLUDE
                {
                mRULE_KW_INCLUDE(); 

                }
                break;
            case 14 :
                // InternalCmdArgsLexer.g:1:216: RULE_KW_VAR
                {
                mRULE_KW_VAR(); 

                }
                break;
            case 15 :
                // InternalCmdArgsLexer.g:1:228: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 16 :
                // InternalCmdArgsLexer.g:1:236: RULE_STRING2
                {
                mRULE_STRING2(); 

                }
                break;
            case 17 :
                // InternalCmdArgsLexer.g:1:249: RULE_NEWLINE
                {
                mRULE_NEWLINE(); 

                }
                break;
            case 18 :
                // InternalCmdArgsLexer.g:1:262: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 19 :
                // InternalCmdArgsLexer.g:1:270: RULE_LINE_BREAK
                {
                mRULE_LINE_BREAK(); 

                }
                break;
            case 20 :
                // InternalCmdArgsLexer.g:1:286: RULE_LINE_COMMENT
                {
                mRULE_LINE_COMMENT(); 

                }
                break;
            case 21 :
                // InternalCmdArgsLexer.g:1:304: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\2\uffff\1\26\4\uffff\2\40\1\24\4\uffff\2\24\2\uffff\2\24\13\uffff\1\40\1\uffff\2\40\6\uffff\15\40\1\71\1\72\1\73\3\uffff";
    static final String DFA10_eofS =
        "\74\uffff";
    static final String DFA10_minS =
        "\1\0\1\uffff\1\104\4\uffff\1\157\1\156\1\50\4\uffff\2\0\2\uffff\1\12\1\0\13\uffff\1\163\1\uffff\1\171\1\143\6\uffff\1\164\1\163\1\154\1\144\1\164\1\165\1\151\1\145\1\144\1\156\1\155\1\145\1\143\3\55\3\uffff";
    static final String DFA10_maxS =
        "\1\uffff\1\uffff\1\170\4\uffff\1\157\1\163\1\50\4\uffff\2\uffff\2\uffff\1\15\1\uffff\13\uffff\1\163\1\uffff\1\171\1\143\6\uffff\1\164\1\163\1\154\1\144\1\164\1\165\1\151\1\145\1\144\1\156\1\155\1\145\1\143\3\172\3\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\1\4\1\5\1\6\3\uffff\4\17\2\uffff\1\21\1\22\2\uffff\1\25\1\1\1\2\1\12\1\10\1\11\1\7\1\3\1\4\1\5\1\6\1\uffff\1\17\2\uffff\1\16\1\20\1\21\1\22\1\23\1\24\20\uffff\1\14\1\15\1\13";
    static final String DFA10_specialS =
        "\1\2\15\uffff\1\3\1\1\3\uffff\1\0\50\uffff}>";
    static final String[] DFA10_transitionS = {
            "\11\24\1\21\1\20\2\24\1\20\22\24\1\21\1\24\1\16\1\23\1\11\2\24\1\17\1\4\1\5\2\24\1\6\1\2\1\14\1\13\12\15\1\1\2\24\1\3\3\24\32\12\1\24\1\22\2\24\1\12\1\24\10\12\1\10\4\12\1\7\14\12\uff85\24",
            "",
            "\1\32\4\uffff\1\30\45\uffff\1\31\10\uffff\1\27",
            "",
            "",
            "",
            "",
            "\1\37",
            "\1\42\4\uffff\1\41",
            "\1\43",
            "",
            "",
            "",
            "",
            "\0\44",
            "\0\44",
            "",
            "",
            "\1\47\2\uffff\1\47",
            "\0\50",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\51",
            "",
            "\1\52",
            "\1\53",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\16\40\6\uffff\32\40\1\uffff\1\40\2\uffff\1\40\1\uffff\32\40",
            "\16\40\6\uffff\32\40\1\uffff\1\40\2\uffff\1\40\1\uffff\32\40",
            "\16\40\6\uffff\32\40\1\uffff\1\40\2\uffff\1\40\1\uffff\32\40",
            "",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( RULE_SKW_COLON | RULE_SKW_MINUS | RULE_SKW_ASSIGN | RULE_SKW_LEFTPAREN | RULE_SKW_RIGHTPAREN | RULE_SKW_COMMA | RULE_KW_DEFINE | RULE_KW_INCDIR | RULE_KW_OUTPUT | RULE_KW_LANG | RULE_KW_NOSTDINC | RULE_KW_INCSYS | RULE_KW_INCLUDE | RULE_KW_VAR | RULE_ID | RULE_STRING2 | RULE_NEWLINE | RULE_WS | RULE_LINE_BREAK | RULE_LINE_COMMENT | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream input) throws NoViableAltException {
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
                    
                    case 3 : 
                        s = specialState3(s, input);
                        if (s >= 0) return s;
                        break;
                    
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 10, _s, input);
            error(nvae);
            throw nvae;
        }

        private int specialState0(int s, IntStream _input) {
            IntStream input = _input;
            int LA10_19 = input.LA(1);

            s = -1;
            if ( ((LA10_19>='\u0000' && LA10_19<='\uFFFF')) ) {s = 40;}

            else s = 20;

            return s;
        }

        private int specialState1(int s, IntStream _input) {
            IntStream input = _input;
            int LA10_15 = input.LA(1);

            s = -1;
            if ( ((LA10_15>='\u0000' && LA10_15<='\uFFFF')) ) {s = 36;}

            else s = 20;

            return s;
        }

        private int specialState2(int s, IntStream _input) {
            IntStream input = _input;
            int LA10_0 = input.LA(1);

            s = -1;
            if ( (LA10_0==':') ) {s = 1;}

            else if ( (LA10_0=='-') ) {s = 2;}

            else if ( (LA10_0=='=') ) {s = 3;}

            else if ( (LA10_0=='(') ) {s = 4;}

            else if ( (LA10_0==')') ) {s = 5;}

            else if ( (LA10_0==',') ) {s = 6;}

            else if ( (LA10_0=='n') ) {s = 7;}

            else if ( (LA10_0=='i') ) {s = 8;}

            else if ( (LA10_0=='$') ) {s = 9;}

            else if ( ((LA10_0>='A' && LA10_0<='Z')||LA10_0=='_'||(LA10_0>='a' && LA10_0<='h')||(LA10_0>='j' && LA10_0<='m')||(LA10_0>='o' && LA10_0<='z')) ) {s = 10;}

            else if ( (LA10_0=='/') ) {s = 11;}

            else if ( (LA10_0=='.') ) {s = 12;}

            else if ( ((LA10_0>='0' && LA10_0<='9')) ) {s = 13;}

            else if ( (LA10_0=='\"') ) {s = 14;}

            else if ( (LA10_0=='\'') ) {s = 15;}

            else if ( (LA10_0=='\n'||LA10_0=='\r') ) {s = 16;}

            else if ( (LA10_0=='\t'||LA10_0==' ') ) {s = 17;}

            else if ( (LA10_0=='\\') ) {s = 18;}

            else if ( (LA10_0=='#') ) {s = 19;}

            else if ( ((LA10_0>='\u0000' && LA10_0<='\b')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\u001F')||LA10_0=='!'||(LA10_0>='%' && LA10_0<='&')||(LA10_0>='*' && LA10_0<='+')||(LA10_0>=';' && LA10_0<='<')||(LA10_0>='>' && LA10_0<='@')||LA10_0=='['||(LA10_0>=']' && LA10_0<='^')||LA10_0=='`'||(LA10_0>='{' && LA10_0<='\uFFFF')) ) {s = 20;}

            return s;
        }

        private int specialState3(int s, IntStream _input) {
            IntStream input = _input;
            int LA10_14 = input.LA(1);

            s = -1;
            if ( ((LA10_14>='\u0000' && LA10_14<='\uFFFF')) ) {s = 36;}

            else s = 20;

            return s;
        }
    }
 

}