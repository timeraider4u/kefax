package at.jku.weiner.cpreprocess.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalCPreprocessLexer extends Lexer {
    public static final int RULE_PRAGMA=11;
    public static final int RULE_ID=5;
    public static final int RULE_NEWLINE=6;
    public static final int RULE_ERROR=10;
    public static final int RULE_HASH=17;
    public static final int RULE_IDENTIFIER=18;
    public static final int RULE_UNDEF=9;
    public static final int RULE_NO_CODE_START=20;
    public static final int EOF=-1;
    public static final int RULE_LETTER=19;
    public static final int RULE_LINEBREAK=15;
    public static final int RULE_DEFINE=8;
    public static final int RULE_CARRIAGERETURN=13;
    public static final int RULE_INCLUDE=7;
    public static final int RULE_BACKSLASH=14;
    public static final int RULE_MYCODE=4;
    public static final int RULE_WS=16;
    public static final int RULE_LINEFEED=12;

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

    // $ANTLR start "RULE_LINEFEED"
    public final void mRULE_LINEFEED() throws RecognitionException {
        try {
            // InternalCPreprocess.g:1670:24: ( '\\n' )
            // InternalCPreprocess.g:1670:26: '\\n'
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
            // InternalCPreprocess.g:1672:30: ( '\\r' )
            // InternalCPreprocess.g:1672:32: '\\r'
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
            // InternalCPreprocess.g:1674:14: ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) )
            // InternalCPreprocess.g:1674:16: ( RULE_CARRIAGERETURN | RULE_LINEFEED )
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
            // InternalCPreprocess.g:1676:25: ( '\\\\' )
            // InternalCPreprocess.g:1676:27: '\\\\'
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
            // InternalCPreprocess.g:1678:25: ( ( RULE_BACKSLASH RULE_NEWLINE )+ )
            // InternalCPreprocess.g:1678:27: ( RULE_BACKSLASH RULE_NEWLINE )+
            {
            // InternalCPreprocess.g:1678:27: ( RULE_BACKSLASH RULE_NEWLINE )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\\') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalCPreprocess.g:1678:28: RULE_BACKSLASH RULE_NEWLINE
            	    {
            	    mRULE_BACKSLASH(); 
            	    mRULE_NEWLINE(); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_LINEBREAK"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            // InternalCPreprocess.g:1680:18: ( ( ' ' | '\\t' | RULE_LINEBREAK ) )
            // InternalCPreprocess.g:1680:20: ( ' ' | '\\t' | RULE_LINEBREAK )
            {
            // InternalCPreprocess.g:1680:20: ( ' ' | '\\t' | RULE_LINEBREAK )
            int alt2=3;
            switch ( input.LA(1) ) {
            case ' ':
                {
                alt2=1;
                }
                break;
            case '\t':
                {
                alt2=2;
                }
                break;
            case '\\':
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalCPreprocess.g:1680:21: ' '
                    {
                    match(' '); 

                    }
                    break;
                case 2 :
                    // InternalCPreprocess.g:1680:25: '\\t'
                    {
                    match('\t'); 

                    }
                    break;
                case 3 :
                    // InternalCPreprocess.g:1680:30: RULE_LINEBREAK
                    {
                    mRULE_LINEBREAK(); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_HASH"
    public final void mRULE_HASH() throws RecognitionException {
        try {
            // InternalCPreprocess.g:1682:20: ( '#' )
            // InternalCPreprocess.g:1682:22: '#'
            {
            match('#'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_HASH"

    // $ANTLR start "RULE_DEFINE"
    public final void mRULE_DEFINE() throws RecognitionException {
        try {
            int _type = RULE_DEFINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:1684:13: ( RULE_HASH ( RULE_WS )* 'define' ( RULE_WS )+ )
            // InternalCPreprocess.g:1684:15: RULE_HASH ( RULE_WS )* 'define' ( RULE_WS )+
            {
            mRULE_HASH(); 
            // InternalCPreprocess.g:1684:25: ( RULE_WS )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\t'||LA3_0==' '||LA3_0=='\\') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalCPreprocess.g:1684:25: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match("define"); 

            // InternalCPreprocess.g:1684:43: ( RULE_WS )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\t'||LA4_0==' '||LA4_0=='\\') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalCPreprocess.g:1684:43: RULE_WS
            	    {
            	    mRULE_WS(); 

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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DEFINE"

    // $ANTLR start "RULE_UNDEF"
    public final void mRULE_UNDEF() throws RecognitionException {
        try {
            int _type = RULE_UNDEF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:1686:12: ( RULE_HASH ( RULE_WS )* 'undef' ( RULE_WS )+ )
            // InternalCPreprocess.g:1686:14: RULE_HASH ( RULE_WS )* 'undef' ( RULE_WS )+
            {
            mRULE_HASH(); 
            // InternalCPreprocess.g:1686:24: ( RULE_WS )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\t'||LA5_0==' '||LA5_0=='\\') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalCPreprocess.g:1686:24: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match("undef"); 

            // InternalCPreprocess.g:1686:41: ( RULE_WS )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\t'||LA6_0==' '||LA6_0=='\\') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalCPreprocess.g:1686:41: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_UNDEF"

    // $ANTLR start "RULE_INCLUDE"
    public final void mRULE_INCLUDE() throws RecognitionException {
        try {
            int _type = RULE_INCLUDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:1688:14: ( RULE_HASH ( RULE_WS )* 'include' ( RULE_WS )+ )
            // InternalCPreprocess.g:1688:16: RULE_HASH ( RULE_WS )* 'include' ( RULE_WS )+
            {
            mRULE_HASH(); 
            // InternalCPreprocess.g:1688:26: ( RULE_WS )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\t'||LA7_0==' '||LA7_0=='\\') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalCPreprocess.g:1688:26: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match("include"); 

            // InternalCPreprocess.g:1688:45: ( RULE_WS )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\t'||LA8_0==' '||LA8_0=='\\') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalCPreprocess.g:1688:45: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INCLUDE"

    // $ANTLR start "RULE_ERROR"
    public final void mRULE_ERROR() throws RecognitionException {
        try {
            int _type = RULE_ERROR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:1690:12: ( RULE_HASH ( RULE_WS )* 'error' ( RULE_WS )+ )
            // InternalCPreprocess.g:1690:14: RULE_HASH ( RULE_WS )* 'error' ( RULE_WS )+
            {
            mRULE_HASH(); 
            // InternalCPreprocess.g:1690:24: ( RULE_WS )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\t'||LA9_0==' '||LA9_0=='\\') ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalCPreprocess.g:1690:24: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match("error"); 

            // InternalCPreprocess.g:1690:41: ( RULE_WS )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='\t'||LA10_0==' '||LA10_0=='\\') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalCPreprocess.g:1690:41: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ERROR"

    // $ANTLR start "RULE_PRAGMA"
    public final void mRULE_PRAGMA() throws RecognitionException {
        try {
            int _type = RULE_PRAGMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:1692:13: ( RULE_HASH ( RULE_WS )* 'pragma' ( RULE_WS )+ )
            // InternalCPreprocess.g:1692:15: RULE_HASH ( RULE_WS )* 'pragma' ( RULE_WS )+
            {
            mRULE_HASH(); 
            // InternalCPreprocess.g:1692:25: ( RULE_WS )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='\t'||LA11_0==' '||LA11_0=='\\') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalCPreprocess.g:1692:25: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            match("pragma"); 

            // InternalCPreprocess.g:1692:43: ( RULE_WS )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='\t'||LA12_0==' '||LA12_0=='\\') ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalCPreprocess.g:1692:43: RULE_WS
            	    {
            	    mRULE_WS(); 

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
    // $ANTLR end "RULE_PRAGMA"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:1694:9: ( RULE_IDENTIFIER )
            // InternalCPreprocess.g:1694:11: RULE_IDENTIFIER
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
            // InternalCPreprocess.g:1696:26: ( RULE_LETTER ( RULE_LETTER | '0' .. '9' )* )
            // InternalCPreprocess.g:1696:28: RULE_LETTER ( RULE_LETTER | '0' .. '9' )*
            {
            mRULE_LETTER(); 
            // InternalCPreprocess.g:1696:40: ( RULE_LETTER | '0' .. '9' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0=='$'||(LA13_0>='0' && LA13_0<='9')||(LA13_0>='A' && LA13_0<='Z')||LA13_0=='_'||(LA13_0>='a' && LA13_0<='z')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalCPreprocess.g:
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
            	    break loop13;
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
            // InternalCPreprocess.g:1698:22: ( ( '$' | 'A' .. 'Z' | 'a' .. 'z' | '_' ) )
            // InternalCPreprocess.g:1698:24: ( '$' | 'A' .. 'Z' | 'a' .. 'z' | '_' )
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

    // $ANTLR start "RULE_NO_CODE_START"
    public final void mRULE_NO_CODE_START() throws RecognitionException {
        try {
            // InternalCPreprocess.g:1700:29: ( ( RULE_NEWLINE | RULE_HASH ) )
            // InternalCPreprocess.g:1700:31: ( RULE_NEWLINE | RULE_HASH )
            {
            if ( input.LA(1)=='\n'||input.LA(1)=='\r'||input.LA(1)=='#' ) {
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
    // $ANTLR end "RULE_NO_CODE_START"

    // $ANTLR start "RULE_MYCODE"
    public final void mRULE_MYCODE() throws RecognitionException {
        try {
            int _type = RULE_MYCODE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:1702:13: (~ ( ( RULE_HASH | RULE_CARRIAGERETURN | RULE_LINEFEED ) ) (~ ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) ) )* )
            // InternalCPreprocess.g:1702:15: ~ ( ( RULE_HASH | RULE_CARRIAGERETURN | RULE_LINEFEED ) ) (~ ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) ) )*
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\"')||(input.LA(1)>='$' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalCPreprocess.g:1702:64: (~ ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='\u0000' && LA14_0<='\t')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\uFFFF')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalCPreprocess.g:1702:64: ~ ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) )
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
            	    break loop14;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_MYCODE"

    public void mTokens() throws RecognitionException {
        // InternalCPreprocess.g:1:8: ( RULE_NEWLINE | RULE_DEFINE | RULE_UNDEF | RULE_INCLUDE | RULE_ERROR | RULE_PRAGMA | RULE_ID | RULE_MYCODE )
        int alt15=8;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // InternalCPreprocess.g:1:10: RULE_NEWLINE
                {
                mRULE_NEWLINE(); 

                }
                break;
            case 2 :
                // InternalCPreprocess.g:1:23: RULE_DEFINE
                {
                mRULE_DEFINE(); 

                }
                break;
            case 3 :
                // InternalCPreprocess.g:1:35: RULE_UNDEF
                {
                mRULE_UNDEF(); 

                }
                break;
            case 4 :
                // InternalCPreprocess.g:1:46: RULE_INCLUDE
                {
                mRULE_INCLUDE(); 

                }
                break;
            case 5 :
                // InternalCPreprocess.g:1:59: RULE_ERROR
                {
                mRULE_ERROR(); 

                }
                break;
            case 6 :
                // InternalCPreprocess.g:1:70: RULE_PRAGMA
                {
                mRULE_PRAGMA(); 

                }
                break;
            case 7 :
                // InternalCPreprocess.g:1:82: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 8 :
                // InternalCPreprocess.g:1:90: RULE_MYCODE
                {
                mRULE_MYCODE(); 

                }
                break;

        }

    }


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\3\uffff\1\15\12\uffff\1\15\1\uffff";
    static final String DFA15_eofS =
        "\20\uffff";
    static final String DFA15_minS =
        "\1\0\1\uffff\1\11\1\0\1\uffff\2\11\1\12\6\uffff\1\0\1\11";
    static final String DFA15_maxS =
        "\1\uffff\1\uffff\1\165\1\uffff\1\uffff\2\165\1\15\6\uffff\1\uffff\1\165";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\2\uffff\1\10\3\uffff\1\5\1\2\1\4\1\6\1\3\1\7\2\uffff";
    static final String DFA15_specialS =
        "\1\1\2\uffff\1\0\12\uffff\1\2\1\uffff}>";
    static final String[] DFA15_transitionS = {
            "\12\4\1\1\2\4\1\1\25\4\1\2\1\3\34\4\32\3\4\4\1\3\1\4\32\3\uff85\4",
            "",
            "\1\6\26\uffff\1\5\73\uffff\1\7\7\uffff\1\11\1\10\3\uffff\1\12\6\uffff\1\13\4\uffff\1\14",
            "\12\4\1\uffff\2\4\1\uffff\26\4\1\16\13\4\12\16\7\4\32\16\4\4\1\16\1\4\32\16\uff85\4",
            "",
            "\1\6\26\uffff\1\5\73\uffff\1\7\7\uffff\1\11\1\10\3\uffff\1\12\6\uffff\1\13\4\uffff\1\14",
            "\1\6\26\uffff\1\5\73\uffff\1\7\7\uffff\1\11\1\10\3\uffff\1\12\6\uffff\1\13\4\uffff\1\14",
            "\1\17\2\uffff\1\17",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\4\1\uffff\2\4\1\uffff\26\4\1\16\13\4\12\16\7\4\32\16\4\4\1\16\1\4\32\16\uff85\4",
            "\1\6\26\uffff\1\5\73\uffff\1\7\7\uffff\1\11\1\10\3\uffff\1\12\6\uffff\1\13\4\uffff\1\14"
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( RULE_NEWLINE | RULE_DEFINE | RULE_UNDEF | RULE_INCLUDE | RULE_ERROR | RULE_PRAGMA | RULE_ID | RULE_MYCODE );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_3 = input.LA(1);

                        s = -1;
                        if ( (LA15_3=='$'||(LA15_3>='0' && LA15_3<='9')||(LA15_3>='A' && LA15_3<='Z')||LA15_3=='_'||(LA15_3>='a' && LA15_3<='z')) ) {s = 14;}

                        else if ( ((LA15_3>='\u0000' && LA15_3<='\t')||(LA15_3>='\u000B' && LA15_3<='\f')||(LA15_3>='\u000E' && LA15_3<='#')||(LA15_3>='%' && LA15_3<='/')||(LA15_3>=':' && LA15_3<='@')||(LA15_3>='[' && LA15_3<='^')||LA15_3=='`'||(LA15_3>='{' && LA15_3<='\uFFFF')) ) {s = 4;}

                        else s = 13;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_0 = input.LA(1);

                        s = -1;
                        if ( (LA15_0=='\n'||LA15_0=='\r') ) {s = 1;}

                        else if ( (LA15_0=='#') ) {s = 2;}

                        else if ( (LA15_0=='$'||(LA15_0>='A' && LA15_0<='Z')||LA15_0=='_'||(LA15_0>='a' && LA15_0<='z')) ) {s = 3;}

                        else if ( ((LA15_0>='\u0000' && LA15_0<='\t')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\"')||(LA15_0>='%' && LA15_0<='@')||(LA15_0>='[' && LA15_0<='^')||LA15_0=='`'||(LA15_0>='{' && LA15_0<='\uFFFF')) ) {s = 4;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_14 = input.LA(1);

                        s = -1;
                        if ( (LA15_14=='$'||(LA15_14>='0' && LA15_14<='9')||(LA15_14>='A' && LA15_14<='Z')||LA15_14=='_'||(LA15_14>='a' && LA15_14<='z')) ) {s = 14;}

                        else if ( ((LA15_14>='\u0000' && LA15_14<='\t')||(LA15_14>='\u000B' && LA15_14<='\f')||(LA15_14>='\u000E' && LA15_14<='#')||(LA15_14>='%' && LA15_14<='/')||(LA15_14>=':' && LA15_14<='@')||(LA15_14>='[' && LA15_14<='^')||LA15_14=='`'||(LA15_14>='{' && LA15_14<='\uFFFF')) ) {s = 4;}

                        else s = 13;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 15, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}