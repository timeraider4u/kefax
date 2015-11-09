package at.jku.weiner.cpreprocess.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalCPreprocessLexer extends Lexer {
    public static final int RULE_NEWLINE=4;
    public static final int RULE_BACKSLASH=7;
    public static final int RULE_HASH=6;
    public static final int RULE_WHITESPACE=8;
    public static final int RULE_MYCODE=5;
    public static final int EOF=-1;
    public static final int T__9=9;

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

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:11:6: ( 'include' )
            // InternalCPreprocess.g:11:8: 'include'
            {
            match("include"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "RULE_HASH"
    public final void mRULE_HASH() throws RecognitionException {
        try {
            int _type = RULE_HASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:757:11: ( '#' )
            // InternalCPreprocess.g:757:13: '#'
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

    // $ANTLR start "RULE_BACKSLASH"
    public final void mRULE_BACKSLASH() throws RecognitionException {
        try {
            // InternalCPreprocess.g:759:25: ( '\\\\' )
            // InternalCPreprocess.g:759:27: '\\\\'
            {
            match('\\'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_BACKSLASH"

    // $ANTLR start "RULE_WHITESPACE"
    public final void mRULE_WHITESPACE() throws RecognitionException {
        try {
            int _type = RULE_WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:761:17: ( ( ' ' | '\\t' | RULE_BACKSLASH RULE_NEWLINE )+ )
            // InternalCPreprocess.g:761:19: ( ' ' | '\\t' | RULE_BACKSLASH RULE_NEWLINE )+
            {
            // InternalCPreprocess.g:761:19: ( ' ' | '\\t' | RULE_BACKSLASH RULE_NEWLINE )+
            int cnt1=0;
            loop1:
            do {
                int alt1=4;
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

                }

                switch (alt1) {
            	case 1 :
            	    // InternalCPreprocess.g:761:20: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;
            	case 2 :
            	    // InternalCPreprocess.g:761:24: '\\t'
            	    {
            	    match('\t'); 

            	    }
            	    break;
            	case 3 :
            	    // InternalCPreprocess.g:761:29: RULE_BACKSLASH RULE_NEWLINE
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WHITESPACE"

    // $ANTLR start "RULE_NEWLINE"
    public final void mRULE_NEWLINE() throws RecognitionException {
        try {
            int _type = RULE_NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:763:14: ( ( '\\r' | '\\n' ) )
            // InternalCPreprocess.g:763:16: ( '\\r' | '\\n' )
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

    // $ANTLR start "RULE_MYCODE"
    public final void mRULE_MYCODE() throws RecognitionException {
        try {
            int _type = RULE_MYCODE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:765:13: (~ ( ( RULE_HASH | RULE_NEWLINE ) ) (~ ( RULE_NEWLINE ) )* )
            // InternalCPreprocess.g:765:15: ~ ( ( RULE_HASH | RULE_NEWLINE ) ) (~ ( RULE_NEWLINE ) )*
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\"')||(input.LA(1)>='$' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalCPreprocess.g:765:43: (~ ( RULE_NEWLINE ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalCPreprocess.g:765:43: ~ ( RULE_NEWLINE )
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
    // $ANTLR end "RULE_MYCODE"

    public void mTokens() throws RecognitionException {
        // InternalCPreprocess.g:1:8: ( T__9 | RULE_HASH | RULE_WHITESPACE | RULE_NEWLINE | RULE_MYCODE )
        int alt3=5;
        alt3 = dfa3.predict(input);
        switch (alt3) {
            case 1 :
                // InternalCPreprocess.g:1:10: T__9
                {
                mT__9(); 

                }
                break;
            case 2 :
                // InternalCPreprocess.g:1:15: RULE_HASH
                {
                mRULE_HASH(); 

                }
                break;
            case 3 :
                // InternalCPreprocess.g:1:25: RULE_WHITESPACE
                {
                mRULE_WHITESPACE(); 

                }
                break;
            case 4 :
                // InternalCPreprocess.g:1:41: RULE_NEWLINE
                {
                mRULE_NEWLINE(); 

                }
                break;
            case 5 :
                // InternalCPreprocess.g:1:54: RULE_MYCODE
                {
                mRULE_MYCODE(); 

                }
                break;

        }

    }


    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS =
        "\1\uffff\1\7\1\uffff\2\11\1\7\2\uffff\1\7\1\uffff\2\11\5\7\1\22\1\uffff";
    static final String DFA3_eofS =
        "\23\uffff";
    static final String DFA3_minS =
        "\1\0\1\156\1\uffff\2\0\1\12\2\uffff\1\143\1\uffff\2\0\1\12\1\154\1\165\1\144\1\145\1\0\1\uffff";
    static final String DFA3_maxS =
        "\1\uffff\1\156\1\uffff\2\uffff\1\15\2\uffff\1\143\1\uffff\2\uffff\1\15\1\154\1\165\1\144\1\145\1\uffff\1\uffff";
    static final String DFA3_acceptS =
        "\2\uffff\1\2\3\uffff\1\4\1\5\1\uffff\1\3\10\uffff\1\1";
    static final String DFA3_specialS =
        "\1\4\2\uffff\1\3\1\5\5\uffff\1\1\1\2\5\uffff\1\0\1\uffff}>";
    static final String[] DFA3_transitionS = {
            "\11\7\1\4\1\6\2\7\1\6\22\7\1\3\2\7\1\2\70\7\1\5\14\7\1\1\uff96\7",
            "\1\10",
            "",
            "\11\7\1\13\1\uffff\2\7\1\uffff\22\7\1\12\73\7\1\14\uffa3\7",
            "\11\7\1\13\1\uffff\2\7\1\uffff\22\7\1\12\73\7\1\14\uffa3\7",
            "\1\11\2\uffff\1\11",
            "",
            "",
            "\1\15",
            "",
            "\11\7\1\13\1\uffff\2\7\1\uffff\22\7\1\12\73\7\1\14\uffa3\7",
            "\11\7\1\13\1\uffff\2\7\1\uffff\22\7\1\12\73\7\1\14\uffa3\7",
            "\1\11\2\uffff\1\11",
            "\1\16",
            "\1\17",
            "\1\20",
            "\1\21",
            "\12\7\1\uffff\2\7\1\uffff\ufff2\7",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__9 | RULE_HASH | RULE_WHITESPACE | RULE_NEWLINE | RULE_MYCODE );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA3_17 = input.LA(1);

                        s = -1;
                        if ( ((LA3_17>='\u0000' && LA3_17<='\t')||(LA3_17>='\u000B' && LA3_17<='\f')||(LA3_17>='\u000E' && LA3_17<='\uFFFF')) ) {s = 7;}

                        else s = 18;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA3_10 = input.LA(1);

                        s = -1;
                        if ( (LA3_10==' ') ) {s = 10;}

                        else if ( (LA3_10=='\t') ) {s = 11;}

                        else if ( (LA3_10=='\\') ) {s = 12;}

                        else if ( ((LA3_10>='\u0000' && LA3_10<='\b')||(LA3_10>='\u000B' && LA3_10<='\f')||(LA3_10>='\u000E' && LA3_10<='\u001F')||(LA3_10>='!' && LA3_10<='[')||(LA3_10>=']' && LA3_10<='\uFFFF')) ) {s = 7;}

                        else s = 9;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA3_11 = input.LA(1);

                        s = -1;
                        if ( (LA3_11==' ') ) {s = 10;}

                        else if ( (LA3_11=='\t') ) {s = 11;}

                        else if ( (LA3_11=='\\') ) {s = 12;}

                        else if ( ((LA3_11>='\u0000' && LA3_11<='\b')||(LA3_11>='\u000B' && LA3_11<='\f')||(LA3_11>='\u000E' && LA3_11<='\u001F')||(LA3_11>='!' && LA3_11<='[')||(LA3_11>=']' && LA3_11<='\uFFFF')) ) {s = 7;}

                        else s = 9;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA3_3 = input.LA(1);

                        s = -1;
                        if ( (LA3_3==' ') ) {s = 10;}

                        else if ( (LA3_3=='\t') ) {s = 11;}

                        else if ( (LA3_3=='\\') ) {s = 12;}

                        else if ( ((LA3_3>='\u0000' && LA3_3<='\b')||(LA3_3>='\u000B' && LA3_3<='\f')||(LA3_3>='\u000E' && LA3_3<='\u001F')||(LA3_3>='!' && LA3_3<='[')||(LA3_3>=']' && LA3_3<='\uFFFF')) ) {s = 7;}

                        else s = 9;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA3_0 = input.LA(1);

                        s = -1;
                        if ( (LA3_0=='i') ) {s = 1;}

                        else if ( (LA3_0=='#') ) {s = 2;}

                        else if ( (LA3_0==' ') ) {s = 3;}

                        else if ( (LA3_0=='\t') ) {s = 4;}

                        else if ( (LA3_0=='\\') ) {s = 5;}

                        else if ( (LA3_0=='\n'||LA3_0=='\r') ) {s = 6;}

                        else if ( ((LA3_0>='\u0000' && LA3_0<='\b')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='\u001F')||(LA3_0>='!' && LA3_0<='\"')||(LA3_0>='$' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='h')||(LA3_0>='j' && LA3_0<='\uFFFF')) ) {s = 7;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA3_4 = input.LA(1);

                        s = -1;
                        if ( (LA3_4==' ') ) {s = 10;}

                        else if ( (LA3_4=='\t') ) {s = 11;}

                        else if ( (LA3_4=='\\') ) {s = 12;}

                        else if ( ((LA3_4>='\u0000' && LA3_4<='\b')||(LA3_4>='\u000B' && LA3_4<='\f')||(LA3_4>='\u000E' && LA3_4<='\u001F')||(LA3_4>='!' && LA3_4<='[')||(LA3_4>=']' && LA3_4<='\uFFFF')) ) {s = 7;}

                        else s = 9;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 3, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}