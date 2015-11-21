package at.jku.weiner.cpreprocess.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalCPreprocessLexer extends Lexer {
    public static final int RULE_PRAGMA=9;
    public static final int RULE_ID=4;
    public static final int RULE_NEWLINE=15;
    public static final int RULE_ID_NONDIGIT=23;
    public static final int RULE_NONDIGIT_LETTER=25;
    public static final int RULE_ERROR=8;
    public static final int RULE_COMMA=12;
    public static final int RULE_HASH=14;
    public static final int RULE_TAB=22;
    public static final int RULE_UNDEF=16;
    public static final int EOF=-1;
    public static final int RULE_HEXADECIMAL_DIGIT=28;
    public static final int RULE_LINEBREAK=20;
    public static final int RULE_DEFINE=7;
    public static final int RULE_SPECIAL=5;
    public static final int RULE_LPAREN=10;
    public static final int RULE_CARRIAGERETURN=18;
    public static final int RULE_INCLUDE=6;
    public static final int RULE_BACKSLASH=19;
    public static final int RULE_RPAREN=11;
    public static final int RULE_WS=13;
    public static final int RULE_DIGIT=24;
    public static final int RULE_SPACE=21;
    public static final int RULE_UNIVERSAL_CHARACTER=26;
    public static final int RULE_LINEFEED=17;
    public static final int RULE_HEX_QUAD=27;

    // delegates
    // delegators

    public InternalCPreprocessLexer() {;} 
    public InternalCPreprocessLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalCPreprocessLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalCPreprocess.g"; }

    // $ANTLR start "RULE_HASH"
    public final void mRULE_HASH() throws RecognitionException {
        try {
            int _type = RULE_HASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:3351:11: ( '#' )
            // InternalCPreprocess.g:3351:13: '#'
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
            // InternalCPreprocess.g:3353:14: ( 'include' )
            // InternalCPreprocess.g:3353:16: 'include'
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
            // InternalCPreprocess.g:3355:13: ( 'define' )
            // InternalCPreprocess.g:3355:15: 'define'
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
            // InternalCPreprocess.g:3357:12: ( 'error' )
            // InternalCPreprocess.g:3357:14: 'error'
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

    // $ANTLR start "RULE_UNDEF"
    public final void mRULE_UNDEF() throws RecognitionException {
        try {
            int _type = RULE_UNDEF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:3359:12: ( 'undef' )
            // InternalCPreprocess.g:3359:14: 'undef'
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

    // $ANTLR start "RULE_PRAGMA"
    public final void mRULE_PRAGMA() throws RecognitionException {
        try {
            int _type = RULE_PRAGMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:3361:13: ( 'pragma' )
            // InternalCPreprocess.g:3361:15: 'pragma'
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

    // $ANTLR start "RULE_LPAREN"
    public final void mRULE_LPAREN() throws RecognitionException {
        try {
            int _type = RULE_LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:3363:13: ( '(' )
            // InternalCPreprocess.g:3363:15: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LPAREN"

    // $ANTLR start "RULE_RPAREN"
    public final void mRULE_RPAREN() throws RecognitionException {
        try {
            int _type = RULE_RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:3365:13: ( ')' )
            // InternalCPreprocess.g:3365:15: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_RPAREN"

    // $ANTLR start "RULE_COMMA"
    public final void mRULE_COMMA() throws RecognitionException {
        try {
            int _type = RULE_COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:3367:12: ( ',' )
            // InternalCPreprocess.g:3367:14: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_COMMA"

    // $ANTLR start "RULE_LINEFEED"
    public final void mRULE_LINEFEED() throws RecognitionException {
        try {
            // InternalCPreprocess.g:3369:24: ( '\\n' )
            // InternalCPreprocess.g:3369:26: '\\n'
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
            // InternalCPreprocess.g:3371:30: ( '\\r' )
            // InternalCPreprocess.g:3371:32: '\\r'
            {
            match('\r'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_CARRIAGERETURN"

    // $ANTLR start "RULE_NEWLINE"
    public final void mRULE_NEWLINE() throws RecognitionException {
        try {
            int _type = RULE_NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:3373:14: ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) )
            // InternalCPreprocess.g:3373:16: ( RULE_CARRIAGERETURN | RULE_LINEFEED )
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

    // $ANTLR start "RULE_BACKSLASH"
    public final void mRULE_BACKSLASH() throws RecognitionException {
        try {
            // InternalCPreprocess.g:3375:25: ( '\\\\' )
            // InternalCPreprocess.g:3375:27: '\\\\'
            {
            match('\\'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_BACKSLASH"

    // $ANTLR start "RULE_LINEBREAK"
    public final void mRULE_LINEBREAK() throws RecognitionException {
        try {
            // InternalCPreprocess.g:3377:25: ( RULE_BACKSLASH RULE_NEWLINE )
            // InternalCPreprocess.g:3377:27: RULE_BACKSLASH RULE_NEWLINE
            {
            mRULE_BACKSLASH(); 
            mRULE_NEWLINE(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_LINEBREAK"

    // $ANTLR start "RULE_SPACE"
    public final void mRULE_SPACE() throws RecognitionException {
        try {
            // InternalCPreprocess.g:3379:21: ( ' ' )
            // InternalCPreprocess.g:3379:23: ' '
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
            // InternalCPreprocess.g:3381:19: ( '\\t' )
            // InternalCPreprocess.g:3381:21: '\\t'
            {
            match('\t'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_TAB"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:3383:9: ( ( RULE_SPACE | RULE_TAB | RULE_LINEBREAK ) )
            // InternalCPreprocess.g:3383:11: ( RULE_SPACE | RULE_TAB | RULE_LINEBREAK )
            {
            // InternalCPreprocess.g:3383:11: ( RULE_SPACE | RULE_TAB | RULE_LINEBREAK )
            int alt1=3;
            switch ( input.LA(1) ) {
            case ' ':
                {
                alt1=1;
                }
                break;
            case '\t':
                {
                alt1=2;
                }
                break;
            case '\\':
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalCPreprocess.g:3383:12: RULE_SPACE
                    {
                    mRULE_SPACE(); 

                    }
                    break;
                case 2 :
                    // InternalCPreprocess.g:3383:23: RULE_TAB
                    {
                    mRULE_TAB(); 

                    }
                    break;
                case 3 :
                    // InternalCPreprocess.g:3383:32: RULE_LINEBREAK
                    {
                    mRULE_LINEBREAK(); 

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
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:3385:9: ( RULE_ID_NONDIGIT ( RULE_ID_NONDIGIT | RULE_DIGIT )* )
            // InternalCPreprocess.g:3385:11: RULE_ID_NONDIGIT ( RULE_ID_NONDIGIT | RULE_DIGIT )*
            {
            mRULE_ID_NONDIGIT(); 
            // InternalCPreprocess.g:3385:28: ( RULE_ID_NONDIGIT | RULE_DIGIT )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='A' && LA2_0<='Z')||LA2_0=='\\'||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }
                else if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalCPreprocess.g:3385:29: RULE_ID_NONDIGIT
            	    {
            	    mRULE_ID_NONDIGIT(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalCPreprocess.g:3385:46: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

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

    // $ANTLR start "RULE_ID_NONDIGIT"
    public final void mRULE_ID_NONDIGIT() throws RecognitionException {
        try {
            // InternalCPreprocess.g:3387:27: ( ( RULE_NONDIGIT_LETTER | RULE_UNIVERSAL_CHARACTER ) )
            // InternalCPreprocess.g:3387:29: ( RULE_NONDIGIT_LETTER | RULE_UNIVERSAL_CHARACTER )
            {
            // InternalCPreprocess.g:3387:29: ( RULE_NONDIGIT_LETTER | RULE_UNIVERSAL_CHARACTER )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                alt3=1;
            }
            else if ( (LA3_0=='\\') ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalCPreprocess.g:3387:30: RULE_NONDIGIT_LETTER
                    {
                    mRULE_NONDIGIT_LETTER(); 

                    }
                    break;
                case 2 :
                    // InternalCPreprocess.g:3387:51: RULE_UNIVERSAL_CHARACTER
                    {
                    mRULE_UNIVERSAL_CHARACTER(); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID_NONDIGIT"

    // $ANTLR start "RULE_DIGIT"
    public final void mRULE_DIGIT() throws RecognitionException {
        try {
            // InternalCPreprocess.g:3389:21: ( '0' .. '9' )
            // InternalCPreprocess.g:3389:23: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_DIGIT"

    // $ANTLR start "RULE_NONDIGIT_LETTER"
    public final void mRULE_NONDIGIT_LETTER() throws RecognitionException {
        try {
            // InternalCPreprocess.g:3391:31: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) )
            // InternalCPreprocess.g:3391:33: ( 'a' .. 'z' | 'A' .. 'Z' | '_' )
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
    // $ANTLR end "RULE_NONDIGIT_LETTER"

    // $ANTLR start "RULE_UNIVERSAL_CHARACTER"
    public final void mRULE_UNIVERSAL_CHARACTER() throws RecognitionException {
        try {
            // InternalCPreprocess.g:3393:35: ( ( '\\\\u' RULE_HEX_QUAD | '\\\\U' RULE_HEX_QUAD RULE_HEX_QUAD ) )
            // InternalCPreprocess.g:3393:37: ( '\\\\u' RULE_HEX_QUAD | '\\\\U' RULE_HEX_QUAD RULE_HEX_QUAD )
            {
            // InternalCPreprocess.g:3393:37: ( '\\\\u' RULE_HEX_QUAD | '\\\\U' RULE_HEX_QUAD RULE_HEX_QUAD )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\\') ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1=='u') ) {
                    alt4=1;
                }
                else if ( (LA4_1=='U') ) {
                    alt4=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalCPreprocess.g:3393:38: '\\\\u' RULE_HEX_QUAD
                    {
                    match("\\u"); 

                    mRULE_HEX_QUAD(); 

                    }
                    break;
                case 2 :
                    // InternalCPreprocess.g:3393:58: '\\\\U' RULE_HEX_QUAD RULE_HEX_QUAD
                    {
                    match("\\U"); 

                    mRULE_HEX_QUAD(); 
                    mRULE_HEX_QUAD(); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_UNIVERSAL_CHARACTER"

    // $ANTLR start "RULE_HEX_QUAD"
    public final void mRULE_HEX_QUAD() throws RecognitionException {
        try {
            // InternalCPreprocess.g:3395:24: ( RULE_HEXADECIMAL_DIGIT RULE_HEXADECIMAL_DIGIT RULE_HEXADECIMAL_DIGIT RULE_HEXADECIMAL_DIGIT )
            // InternalCPreprocess.g:3395:26: RULE_HEXADECIMAL_DIGIT RULE_HEXADECIMAL_DIGIT RULE_HEXADECIMAL_DIGIT RULE_HEXADECIMAL_DIGIT
            {
            mRULE_HEXADECIMAL_DIGIT(); 
            mRULE_HEXADECIMAL_DIGIT(); 
            mRULE_HEXADECIMAL_DIGIT(); 
            mRULE_HEXADECIMAL_DIGIT(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX_QUAD"

    // $ANTLR start "RULE_HEXADECIMAL_DIGIT"
    public final void mRULE_HEXADECIMAL_DIGIT() throws RecognitionException {
        try {
            // InternalCPreprocess.g:3397:33: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // InternalCPreprocess.g:3397:35: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
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
    // $ANTLR end "RULE_HEXADECIMAL_DIGIT"

    // $ANTLR start "RULE_SPECIAL"
    public final void mRULE_SPECIAL() throws RecognitionException {
        try {
            int _type = RULE_SPECIAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:3399:14: ( . )
            // InternalCPreprocess.g:3399:16: .
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
        // InternalCPreprocess.g:1:8: ( RULE_HASH | RULE_INCLUDE | RULE_DEFINE | RULE_ERROR | RULE_UNDEF | RULE_PRAGMA | RULE_LPAREN | RULE_RPAREN | RULE_COMMA | RULE_NEWLINE | RULE_WS | RULE_ID | RULE_SPECIAL )
        int alt5=13;
        alt5 = dfa5.predict(input);
        switch (alt5) {
            case 1 :
                // InternalCPreprocess.g:1:10: RULE_HASH
                {
                mRULE_HASH(); 

                }
                break;
            case 2 :
                // InternalCPreprocess.g:1:20: RULE_INCLUDE
                {
                mRULE_INCLUDE(); 

                }
                break;
            case 3 :
                // InternalCPreprocess.g:1:33: RULE_DEFINE
                {
                mRULE_DEFINE(); 

                }
                break;
            case 4 :
                // InternalCPreprocess.g:1:45: RULE_ERROR
                {
                mRULE_ERROR(); 

                }
                break;
            case 5 :
                // InternalCPreprocess.g:1:56: RULE_UNDEF
                {
                mRULE_UNDEF(); 

                }
                break;
            case 6 :
                // InternalCPreprocess.g:1:67: RULE_PRAGMA
                {
                mRULE_PRAGMA(); 

                }
                break;
            case 7 :
                // InternalCPreprocess.g:1:79: RULE_LPAREN
                {
                mRULE_LPAREN(); 

                }
                break;
            case 8 :
                // InternalCPreprocess.g:1:91: RULE_RPAREN
                {
                mRULE_RPAREN(); 

                }
                break;
            case 9 :
                // InternalCPreprocess.g:1:103: RULE_COMMA
                {
                mRULE_COMMA(); 

                }
                break;
            case 10 :
                // InternalCPreprocess.g:1:114: RULE_NEWLINE
                {
                mRULE_NEWLINE(); 

                }
                break;
            case 11 :
                // InternalCPreprocess.g:1:127: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 12 :
                // InternalCPreprocess.g:1:135: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 13 :
                // InternalCPreprocess.g:1:143: RULE_SPECIAL
                {
                mRULE_SPECIAL(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\2\uffff\5\22\6\uffff\1\17\3\uffff\1\22\1\uffff\4\22\5\uffff\14\22\1\55\1\56\2\22\1\61\2\uffff\1\62\1\63\3\uffff";
    static final String DFA5_eofS =
        "\64\uffff";
    static final String DFA5_minS =
        "\1\0\1\uffff\1\156\1\145\1\162\1\156\1\162\6\uffff\1\12\3\uffff\1\143\1\uffff\1\146\1\162\1\144\1\141\5\uffff\1\154\1\151\1\157\1\145\1\147\1\165\1\156\1\162\1\146\1\155\1\144\1\145\2\60\1\141\1\145\1\60\2\uffff\2\60\3\uffff";
    static final String DFA5_maxS =
        "\1\uffff\1\uffff\1\156\1\145\1\162\1\156\1\162\6\uffff\1\165\3\uffff\1\143\1\uffff\1\146\1\162\1\144\1\141\5\uffff\1\154\1\151\1\157\1\145\1\147\1\165\1\156\1\162\1\146\1\155\1\144\1\145\2\172\1\141\1\145\1\172\2\uffff\2\172\3\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\1\5\uffff\1\7\1\10\1\11\1\12\2\13\1\uffff\1\14\1\15\1\1\1\uffff\1\14\4\uffff\1\7\1\10\1\11\1\12\1\13\21\uffff\1\4\1\5\2\uffff\1\3\1\6\1\2";
    static final String DFA5_specialS =
        "\1\0\63\uffff}>";
    static final String[] DFA5_transitionS = {
            "\11\17\1\14\1\12\2\17\1\12\22\17\1\13\2\17\1\1\4\17\1\7\1\10\2\17\1\11\24\17\32\16\1\17\1\15\2\17\1\16\1\17\3\16\1\3\1\4\3\16\1\2\6\16\1\6\4\16\1\5\5\16\uff85\17",
            "",
            "\1\21",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\26",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\33\2\uffff\1\33\107\uffff\1\22\37\uffff\1\22",
            "",
            "",
            "",
            "\1\34",
            "",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\40",
            "",
            "",
            "",
            "",
            "",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\12\22\7\uffff\32\22\1\uffff\1\22\2\uffff\1\22\1\uffff\32\22",
            "\12\22\7\uffff\32\22\1\uffff\1\22\2\uffff\1\22\1\uffff\32\22",
            "\1\57",
            "\1\60",
            "\12\22\7\uffff\32\22\1\uffff\1\22\2\uffff\1\22\1\uffff\32\22",
            "",
            "",
            "\12\22\7\uffff\32\22\1\uffff\1\22\2\uffff\1\22\1\uffff\32\22",
            "\12\22\7\uffff\32\22\1\uffff\1\22\2\uffff\1\22\1\uffff\32\22",
            "",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( RULE_HASH | RULE_INCLUDE | RULE_DEFINE | RULE_ERROR | RULE_UNDEF | RULE_PRAGMA | RULE_LPAREN | RULE_RPAREN | RULE_COMMA | RULE_NEWLINE | RULE_WS | RULE_ID | RULE_SPECIAL );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA5_0 = input.LA(1);

                        s = -1;
                        if ( (LA5_0=='#') ) {s = 1;}

                        else if ( (LA5_0=='i') ) {s = 2;}

                        else if ( (LA5_0=='d') ) {s = 3;}

                        else if ( (LA5_0=='e') ) {s = 4;}

                        else if ( (LA5_0=='u') ) {s = 5;}

                        else if ( (LA5_0=='p') ) {s = 6;}

                        else if ( (LA5_0=='(') ) {s = 7;}

                        else if ( (LA5_0==')') ) {s = 8;}

                        else if ( (LA5_0==',') ) {s = 9;}

                        else if ( (LA5_0=='\n'||LA5_0=='\r') ) {s = 10;}

                        else if ( (LA5_0==' ') ) {s = 11;}

                        else if ( (LA5_0=='\t') ) {s = 12;}

                        else if ( (LA5_0=='\\') ) {s = 13;}

                        else if ( ((LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='c')||(LA5_0>='f' && LA5_0<='h')||(LA5_0>='j' && LA5_0<='o')||(LA5_0>='q' && LA5_0<='t')||(LA5_0>='v' && LA5_0<='z')) ) {s = 14;}

                        else if ( ((LA5_0>='\u0000' && LA5_0<='\b')||(LA5_0>='\u000B' && LA5_0<='\f')||(LA5_0>='\u000E' && LA5_0<='\u001F')||(LA5_0>='!' && LA5_0<='\"')||(LA5_0>='$' && LA5_0<='\'')||(LA5_0>='*' && LA5_0<='+')||(LA5_0>='-' && LA5_0<='@')||LA5_0=='['||(LA5_0>=']' && LA5_0<='^')||LA5_0=='`'||(LA5_0>='{' && LA5_0<='\uFFFF')) ) {s = 15;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 5, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}