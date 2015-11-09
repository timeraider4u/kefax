package at.jku.weiner.cpreprocess.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalCPreprocessLexer extends Lexer {
    public static final int RULE_PRAGMA=10;
    public static final int RULE_NEWLINE=4;
    public static final int RULE_LINEBREAK=12;
    public static final int RULE_DEFINE=7;
    public static final int RULE_INCLUDE=5;
    public static final int RULE_ERROR=9;
    public static final int RULE_BACKSLASH=11;
    public static final int RULE_HASH=14;
    public static final int RULE_MYCODE=6;
    public static final int RULE_UNDEF=8;
    public static final int RULE_WS=13;
    public static final int EOF=-1;

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

    // $ANTLR start "RULE_NEWLINE"
    public final void mRULE_NEWLINE() throws RecognitionException {
        try {
            int _type = RULE_NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:747:14: ( ( '\\r' | '\\n' ) )
            // InternalCPreprocess.g:747:16: ( '\\r' | '\\n' )
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
            // InternalCPreprocess.g:749:25: ( '\\\\' )
            // InternalCPreprocess.g:749:27: '\\\\'
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
            // InternalCPreprocess.g:751:25: ( ( RULE_BACKSLASH RULE_NEWLINE )+ )
            // InternalCPreprocess.g:751:27: ( RULE_BACKSLASH RULE_NEWLINE )+
            {
            // InternalCPreprocess.g:751:27: ( RULE_BACKSLASH RULE_NEWLINE )+
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
            	    // InternalCPreprocess.g:751:28: RULE_BACKSLASH RULE_NEWLINE
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
            // InternalCPreprocess.g:753:18: ( ( ' ' | '\\t' | RULE_LINEBREAK ) )
            // InternalCPreprocess.g:753:20: ( ' ' | '\\t' | RULE_LINEBREAK )
            {
            // InternalCPreprocess.g:753:20: ( ' ' | '\\t' | RULE_LINEBREAK )
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
                    // InternalCPreprocess.g:753:21: ' '
                    {
                    match(' '); 

                    }
                    break;
                case 2 :
                    // InternalCPreprocess.g:753:25: '\\t'
                    {
                    match('\t'); 

                    }
                    break;
                case 3 :
                    // InternalCPreprocess.g:753:30: RULE_LINEBREAK
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
            // InternalCPreprocess.g:755:20: ( '#' )
            // InternalCPreprocess.g:755:22: '#'
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
            // InternalCPreprocess.g:757:13: ( RULE_HASH ( RULE_WS )* 'define' ( RULE_WS )* )
            // InternalCPreprocess.g:757:15: RULE_HASH ( RULE_WS )* 'define' ( RULE_WS )*
            {
            mRULE_HASH(); 
            // InternalCPreprocess.g:757:25: ( RULE_WS )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\t'||LA3_0==' '||LA3_0=='\\') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalCPreprocess.g:757:25: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match("define"); 

            // InternalCPreprocess.g:757:43: ( RULE_WS )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\t'||LA4_0==' '||LA4_0=='\\') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalCPreprocess.g:757:43: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
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
            // InternalCPreprocess.g:759:12: ( RULE_HASH ( RULE_WS )* 'undef' ( RULE_WS )* )
            // InternalCPreprocess.g:759:14: RULE_HASH ( RULE_WS )* 'undef' ( RULE_WS )*
            {
            mRULE_HASH(); 
            // InternalCPreprocess.g:759:24: ( RULE_WS )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\t'||LA5_0==' '||LA5_0=='\\') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalCPreprocess.g:759:24: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match("undef"); 

            // InternalCPreprocess.g:759:41: ( RULE_WS )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\t'||LA6_0==' '||LA6_0=='\\') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalCPreprocess.g:759:41: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
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
            // InternalCPreprocess.g:761:14: ( RULE_HASH ( RULE_WS )* 'include' ( RULE_WS )* )
            // InternalCPreprocess.g:761:16: RULE_HASH ( RULE_WS )* 'include' ( RULE_WS )*
            {
            mRULE_HASH(); 
            // InternalCPreprocess.g:761:26: ( RULE_WS )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\t'||LA7_0==' '||LA7_0=='\\') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalCPreprocess.g:761:26: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match("include"); 

            // InternalCPreprocess.g:761:45: ( RULE_WS )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\t'||LA8_0==' '||LA8_0=='\\') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalCPreprocess.g:761:45: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
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
            // InternalCPreprocess.g:763:12: ( RULE_HASH ( RULE_WS )* 'error' ( RULE_WS )* )
            // InternalCPreprocess.g:763:14: RULE_HASH ( RULE_WS )* 'error' ( RULE_WS )*
            {
            mRULE_HASH(); 
            // InternalCPreprocess.g:763:24: ( RULE_WS )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\t'||LA9_0==' '||LA9_0=='\\') ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalCPreprocess.g:763:24: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match("error"); 

            // InternalCPreprocess.g:763:41: ( RULE_WS )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='\t'||LA10_0==' '||LA10_0=='\\') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalCPreprocess.g:763:41: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
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
            // InternalCPreprocess.g:765:13: ( RULE_HASH ( RULE_WS )* 'pragma' ( RULE_WS )* )
            // InternalCPreprocess.g:765:15: RULE_HASH ( RULE_WS )* 'pragma' ( RULE_WS )*
            {
            mRULE_HASH(); 
            // InternalCPreprocess.g:765:25: ( RULE_WS )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='\t'||LA11_0==' '||LA11_0=='\\') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalCPreprocess.g:765:25: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            match("pragma"); 

            // InternalCPreprocess.g:765:43: ( RULE_WS )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='\t'||LA12_0==' '||LA12_0=='\\') ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalCPreprocess.g:765:43: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_PRAGMA"

    // $ANTLR start "RULE_MYCODE"
    public final void mRULE_MYCODE() throws RecognitionException {
        try {
            int _type = RULE_MYCODE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:767:13: (~ ( ( RULE_HASH | RULE_NEWLINE ) ) (~ ( RULE_NEWLINE ) )* )
            // InternalCPreprocess.g:767:15: ~ ( ( RULE_HASH | RULE_NEWLINE ) ) (~ ( RULE_NEWLINE ) )*
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\"')||(input.LA(1)>='$' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalCPreprocess.g:767:43: (~ ( RULE_NEWLINE ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalCPreprocess.g:767:43: ~ ( RULE_NEWLINE )
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
            	    break loop13;
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
        // InternalCPreprocess.g:1:8: ( RULE_NEWLINE | RULE_DEFINE | RULE_UNDEF | RULE_INCLUDE | RULE_ERROR | RULE_PRAGMA | RULE_MYCODE )
        int alt14=7;
        alt14 = dfa14.predict(input);
        switch (alt14) {
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
                // InternalCPreprocess.g:1:82: RULE_MYCODE
                {
                mRULE_MYCODE(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\15\uffff";
    static final String DFA14_eofS =
        "\15\uffff";
    static final String DFA14_minS =
        "\1\0\1\uffff\1\11\1\uffff\2\11\1\12\5\uffff\1\11";
    static final String DFA14_maxS =
        "\1\uffff\1\uffff\1\165\1\uffff\2\165\1\15\5\uffff\1\165";
    static final String DFA14_acceptS =
        "\1\uffff\1\1\1\uffff\1\7\3\uffff\1\3\1\4\1\6\1\5\1\2\1\uffff";
    static final String DFA14_specialS =
        "\1\0\14\uffff}>";
    static final String[] DFA14_transitionS = {
            "\12\3\1\1\2\3\1\1\25\3\1\2\uffdc\3",
            "",
            "\1\5\26\uffff\1\4\73\uffff\1\6\7\uffff\1\13\1\12\3\uffff\1\10\6\uffff\1\11\4\uffff\1\7",
            "",
            "\1\5\26\uffff\1\4\73\uffff\1\6\7\uffff\1\13\1\12\3\uffff\1\10\6\uffff\1\11\4\uffff\1\7",
            "\1\5\26\uffff\1\4\73\uffff\1\6\7\uffff\1\13\1\12\3\uffff\1\10\6\uffff\1\11\4\uffff\1\7",
            "\1\14\2\uffff\1\14",
            "",
            "",
            "",
            "",
            "",
            "\1\5\26\uffff\1\4\73\uffff\1\6\7\uffff\1\13\1\12\3\uffff\1\10\6\uffff\1\11\4\uffff\1\7"
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( RULE_NEWLINE | RULE_DEFINE | RULE_UNDEF | RULE_INCLUDE | RULE_ERROR | RULE_PRAGMA | RULE_MYCODE );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_0 = input.LA(1);

                        s = -1;
                        if ( (LA14_0=='\n'||LA14_0=='\r') ) {s = 1;}

                        else if ( (LA14_0=='#') ) {s = 2;}

                        else if ( ((LA14_0>='\u0000' && LA14_0<='\t')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\"')||(LA14_0>='$' && LA14_0<='\uFFFF')) ) {s = 3;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}