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
    public static final int RULE_ANY_OTHER=35;
    public static final int RULE_SKW_DOLLAR=12;
    public static final int RULE_KW_NOSTDINC=18;
    public static final int RULE_SKW_DOT=4;
    public static final int RULE_SKW_DIV=5;
    public static final int RULE_LINE_BREAK=33;
    public static final int EOF=-1;
    public static final int RULE_LETTER=25;
    public static final int RULE_KW_VAR=21;
    public static final int RULE_SKW_RIGHTPAREN=10;
    public static final int RULE_KW_INCLUDE=20;
    public static final int RULE_KW_DEFINE=14;
    public static final int RULE_KW_LANG=17;
    public static final int RULE_QUOTE1=27;
    public static final int RULE_SKW_HASH2=32;
    public static final int RULE_SKW_HASH1=31;
    public static final int RULE_LINE_COMMENT=34;
    public static final int RULE_KW_INCSYS=19;
    public static final int RULE_INT=26;
    public static final int RULE_SKW_BACKSLASH=13;
    public static final int RULE_SKW_COMMA=11;
    public static final int RULE_WS=30;
    public static final int RULE_DIGIT=28;
    public static final int RULE_SKW_COLON=6;
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
            int _type = RULE_SKW_BACKSLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:39:20: ( '\\\\' )
            // InternalCmdArgsLexer.g:39:22: '\\\\'
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

                if ( ((LA2_0>='-' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='\\'||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
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
            // InternalCmdArgsLexer.g:61:25: ( ( RULE_ID_PART_1 | RULE_SKW_BACKSLASH | RULE_SKW_MINUS ) )
            // InternalCmdArgsLexer.g:61:27: ( RULE_ID_PART_1 | RULE_SKW_BACKSLASH | RULE_SKW_MINUS )
            {
            // InternalCmdArgsLexer.g:61:27: ( RULE_ID_PART_1 | RULE_SKW_BACKSLASH | RULE_SKW_MINUS )
            int alt4=3;
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
            case '\\':
                {
                alt4=2;
                }
                break;
            case '-':
                {
                alt4=3;
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
                    // InternalCmdArgsLexer.g:61:43: RULE_SKW_BACKSLASH
                    {
                    mRULE_SKW_BACKSLASH(); 

                    }
                    break;
                case 3 :
                    // InternalCmdArgsLexer.g:61:62: RULE_SKW_MINUS
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

    // $ANTLR start "RULE_QUOTE1"
    public final void mRULE_QUOTE1() throws RecognitionException {
        try {
            int _type = RULE_QUOTE1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:65:13: ( '\"' )
            // InternalCmdArgsLexer.g:65:15: '\"'
            {
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_QUOTE1"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            // InternalCmdArgsLexer.g:67:19: ( ( RULE_DIGIT )+ )
            // InternalCmdArgsLexer.g:67:21: ( RULE_DIGIT )+
            {
            // InternalCmdArgsLexer.g:67:21: ( RULE_DIGIT )+
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
            	    // InternalCmdArgsLexer.g:67:21: RULE_DIGIT
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
            // InternalCmdArgsLexer.g:69:21: ( '0' .. '9' )
            // InternalCmdArgsLexer.g:69:23: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_DIGIT"

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

    // $ANTLR start "RULE_SKW_HASH1"
    public final void mRULE_SKW_HASH1() throws RecognitionException {
        try {
            // InternalCmdArgsLexer.g:75:25: ( '#' )
            // InternalCmdArgsLexer.g:75:27: '#'
            {
            match('#'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_HASH1"

    // $ANTLR start "RULE_SKW_HASH2"
    public final void mRULE_SKW_HASH2() throws RecognitionException {
        try {
            int _type = RULE_SKW_HASH2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:77:16: ( RULE_SKW_BACKSLASH RULE_SKW_HASH1 )
            // InternalCmdArgsLexer.g:77:18: RULE_SKW_BACKSLASH RULE_SKW_HASH1
            {
            mRULE_SKW_BACKSLASH(); 
            mRULE_SKW_HASH1(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SKW_HASH2"

    // $ANTLR start "RULE_LINE_BREAK"
    public final void mRULE_LINE_BREAK() throws RecognitionException {
        try {
            int _type = RULE_LINE_BREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:79:17: ( RULE_SKW_BACKSLASH RULE_NEWLINE )
            // InternalCmdArgsLexer.g:79:19: RULE_SKW_BACKSLASH RULE_NEWLINE
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
            // InternalCmdArgsLexer.g:81:19: ( RULE_SKW_HASH1 ( options {greedy=false; } : . )* RULE_NEWLINE )
            // InternalCmdArgsLexer.g:81:21: RULE_SKW_HASH1 ( options {greedy=false; } : . )* RULE_NEWLINE
            {
            mRULE_SKW_HASH1(); 
            // InternalCmdArgsLexer.g:81:36: ( options {greedy=false; } : . )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\n'||LA6_0=='\r') ) {
                    alt6=2;
                }
                else if ( ((LA6_0>='\u0000' && LA6_0<='\t')||(LA6_0>='\u000B' && LA6_0<='\f')||(LA6_0>='\u000E' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalCmdArgsLexer.g:81:64: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop6;
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
            // InternalCmdArgsLexer.g:83:16: ( . )
            // InternalCmdArgsLexer.g:83:18: .
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
        // InternalCmdArgsLexer.g:1:8: ( RULE_SKW_COLON | RULE_SKW_MINUS | RULE_SKW_ASSIGN | RULE_SKW_LEFTPAREN | RULE_SKW_RIGHTPAREN | RULE_SKW_COMMA | RULE_SKW_BACKSLASH | RULE_KW_DEFINE | RULE_KW_INCDIR | RULE_KW_OUTPUT | RULE_KW_LANG | RULE_KW_NOSTDINC | RULE_KW_INCSYS | RULE_KW_INCLUDE | RULE_KW_VAR | RULE_ID | RULE_QUOTE1 | RULE_NEWLINE | RULE_WS | RULE_SKW_HASH2 | RULE_LINE_BREAK | RULE_LINE_COMMENT | RULE_ANY_OTHER )
        int alt7=23;
        alt7 = dfa7.predict(input);
        switch (alt7) {
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
                // InternalCmdArgsLexer.g:1:110: RULE_SKW_BACKSLASH
                {
                mRULE_SKW_BACKSLASH(); 

                }
                break;
            case 8 :
                // InternalCmdArgsLexer.g:1:129: RULE_KW_DEFINE
                {
                mRULE_KW_DEFINE(); 

                }
                break;
            case 9 :
                // InternalCmdArgsLexer.g:1:144: RULE_KW_INCDIR
                {
                mRULE_KW_INCDIR(); 

                }
                break;
            case 10 :
                // InternalCmdArgsLexer.g:1:159: RULE_KW_OUTPUT
                {
                mRULE_KW_OUTPUT(); 

                }
                break;
            case 11 :
                // InternalCmdArgsLexer.g:1:174: RULE_KW_LANG
                {
                mRULE_KW_LANG(); 

                }
                break;
            case 12 :
                // InternalCmdArgsLexer.g:1:187: RULE_KW_NOSTDINC
                {
                mRULE_KW_NOSTDINC(); 

                }
                break;
            case 13 :
                // InternalCmdArgsLexer.g:1:204: RULE_KW_INCSYS
                {
                mRULE_KW_INCSYS(); 

                }
                break;
            case 14 :
                // InternalCmdArgsLexer.g:1:219: RULE_KW_INCLUDE
                {
                mRULE_KW_INCLUDE(); 

                }
                break;
            case 15 :
                // InternalCmdArgsLexer.g:1:235: RULE_KW_VAR
                {
                mRULE_KW_VAR(); 

                }
                break;
            case 16 :
                // InternalCmdArgsLexer.g:1:247: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 17 :
                // InternalCmdArgsLexer.g:1:255: RULE_QUOTE1
                {
                mRULE_QUOTE1(); 

                }
                break;
            case 18 :
                // InternalCmdArgsLexer.g:1:267: RULE_NEWLINE
                {
                mRULE_NEWLINE(); 

                }
                break;
            case 19 :
                // InternalCmdArgsLexer.g:1:280: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 20 :
                // InternalCmdArgsLexer.g:1:288: RULE_SKW_HASH2
                {
                mRULE_SKW_HASH2(); 

                }
                break;
            case 21 :
                // InternalCmdArgsLexer.g:1:303: RULE_LINE_BREAK
                {
                mRULE_LINE_BREAK(); 

                }
                break;
            case 22 :
                // InternalCmdArgsLexer.g:1:319: RULE_LINE_COMMENT
                {
                mRULE_LINE_COMMENT(); 

                }
                break;
            case 23 :
                // InternalCmdArgsLexer.g:1:337: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\2\uffff\1\25\4\uffff\1\36\2\42\1\23\7\uffff\1\23\16\uffff\1\42\1\uffff\2\42\5\uffff\15\42\1\72\1\73\1\74\3\uffff";
    static final String DFA7_eofS =
        "\75\uffff";
    static final String DFA7_minS =
        "\1\0\1\uffff\1\104\4\uffff\1\12\1\157\1\156\1\50\7\uffff\1\0\16\uffff\1\163\1\uffff\1\171\1\143\5\uffff\1\164\1\163\1\154\1\144\1\164\1\165\1\151\1\145\1\144\1\156\1\155\1\145\1\143\3\55\3\uffff";
    static final String DFA7_maxS =
        "\1\uffff\1\uffff\1\170\4\uffff\1\43\1\157\1\163\1\50\7\uffff\1\uffff\16\uffff\1\163\1\uffff\1\171\1\143\5\uffff\1\164\1\163\1\154\1\144\1\164\1\165\1\151\1\145\1\144\1\156\1\155\1\145\1\143\3\172\3\uffff";
    static final String DFA7_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\1\4\1\5\1\6\4\uffff\4\20\1\21\1\22\1\23\1\uffff\1\27\1\1\1\2\1\11\1\13\1\10\1\12\1\3\1\4\1\5\1\6\1\7\1\25\1\24\1\uffff\1\20\2\uffff\1\17\1\21\1\22\1\23\1\26\20\uffff\1\15\1\16\1\14";
    static final String DFA7_specialS =
        "\1\1\21\uffff\1\0\52\uffff}>";
    static final String[] DFA7_transitionS = {
            "\11\23\1\21\1\20\2\23\1\20\22\23\1\21\1\23\1\17\1\22\1\12\3\23\1\4\1\5\2\23\1\6\1\2\1\15\1\14\12\16\1\1\2\23\1\3\3\23\32\13\1\23\1\7\2\23\1\13\1\23\10\13\1\11\4\13\1\10\14\13\uff85\23",
            "",
            "\1\30\4\uffff\1\26\45\uffff\1\31\10\uffff\1\27",
            "",
            "",
            "",
            "",
            "\1\37\2\uffff\1\37\25\uffff\1\40",
            "\1\41",
            "\1\44\4\uffff\1\43",
            "\1\45",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\0\51",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\52",
            "",
            "\1\53",
            "\1\54",
            "",
            "",
            "",
            "",
            "",
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
            "\1\71",
            "\15\42\7\uffff\32\42\1\uffff\1\42\2\uffff\1\42\1\uffff\32\42",
            "\15\42\7\uffff\32\42\1\uffff\1\42\2\uffff\1\42\1\uffff\32\42",
            "\15\42\7\uffff\32\42\1\uffff\1\42\2\uffff\1\42\1\uffff\32\42",
            "",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( RULE_SKW_COLON | RULE_SKW_MINUS | RULE_SKW_ASSIGN | RULE_SKW_LEFTPAREN | RULE_SKW_RIGHTPAREN | RULE_SKW_COMMA | RULE_SKW_BACKSLASH | RULE_KW_DEFINE | RULE_KW_INCDIR | RULE_KW_OUTPUT | RULE_KW_LANG | RULE_KW_NOSTDINC | RULE_KW_INCSYS | RULE_KW_INCLUDE | RULE_KW_VAR | RULE_ID | RULE_QUOTE1 | RULE_NEWLINE | RULE_WS | RULE_SKW_HASH2 | RULE_LINE_BREAK | RULE_LINE_COMMENT | RULE_ANY_OTHER );";
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
                    
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }

        private int specialState0(int s, IntStream _input) {
            IntStream input = _input;
            int LA7_18 = input.LA(1);

            s = -1;
            if ( ((LA7_18>='\u0000' && LA7_18<='\uFFFF')) ) {s = 41;}

            else s = 19;

            return s;
        }

        private int specialState1(int s, IntStream _input) {
            IntStream input = _input;
            int LA7_0 = input.LA(1);

            s = -1;
            if ( (LA7_0==':') ) {s = 1;}

            else if ( (LA7_0=='-') ) {s = 2;}

            else if ( (LA7_0=='=') ) {s = 3;}

            else if ( (LA7_0=='(') ) {s = 4;}

            else if ( (LA7_0==')') ) {s = 5;}

            else if ( (LA7_0==',') ) {s = 6;}

            else if ( (LA7_0=='\\') ) {s = 7;}

            else if ( (LA7_0=='n') ) {s = 8;}

            else if ( (LA7_0=='i') ) {s = 9;}

            else if ( (LA7_0=='$') ) {s = 10;}

            else if ( ((LA7_0>='A' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='h')||(LA7_0>='j' && LA7_0<='m')||(LA7_0>='o' && LA7_0<='z')) ) {s = 11;}

            else if ( (LA7_0=='/') ) {s = 12;}

            else if ( (LA7_0=='.') ) {s = 13;}

            else if ( ((LA7_0>='0' && LA7_0<='9')) ) {s = 14;}

            else if ( (LA7_0=='\"') ) {s = 15;}

            else if ( (LA7_0=='\n'||LA7_0=='\r') ) {s = 16;}

            else if ( (LA7_0=='\t'||LA7_0==' ') ) {s = 17;}

            else if ( (LA7_0=='#') ) {s = 18;}

            else if ( ((LA7_0>='\u0000' && LA7_0<='\b')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\u001F')||LA7_0=='!'||(LA7_0>='%' && LA7_0<='\'')||(LA7_0>='*' && LA7_0<='+')||(LA7_0>=';' && LA7_0<='<')||(LA7_0>='>' && LA7_0<='@')||LA7_0=='['||(LA7_0>=']' && LA7_0<='^')||LA7_0=='`'||(LA7_0>='{' && LA7_0<='\uFFFF')) ) {s = 19;}

            return s;
        }
    }
 

}