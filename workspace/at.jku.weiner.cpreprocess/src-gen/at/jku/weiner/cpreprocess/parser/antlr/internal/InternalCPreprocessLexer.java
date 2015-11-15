package at.jku.weiner.cpreprocess.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalCPreprocessLexer extends Lexer {
    public static final int RULE_PRAGMA=11;
    public static final int RULE_ID=7;
    public static final int RULE_NEWLINE=4;
    public static final int RULE_ERROR=9;
    public static final int RULE_IDENTIFIER=20;
    public static final int RULE_HASH=19;
    public static final int RULE_TAB=17;
    public static final int RULE_UNDEF=8;
    public static final int EOF=-1;
    public static final int RULE_LETTER=21;
    public static final int RULE_LINEBREAK=15;
    public static final int RULE_DEFINE=6;
    public static final int RULE_CARRIAGERETURN=13;
    public static final int RULE_INCLUDE=5;
    public static final int RULE_BACKSLASH=14;
    public static final int RULE_MYCODE=10;
    public static final int RULE_WS=18;
    public static final int RULE_SPACE=16;
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
            // InternalCPreprocess.g:846:24: ( '\\n' )
            // InternalCPreprocess.g:846:26: '\\n'
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
            // InternalCPreprocess.g:848:30: ( '\\r' )
            // InternalCPreprocess.g:848:32: '\\r'
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
            // InternalCPreprocess.g:850:14: ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) )
            // InternalCPreprocess.g:850:16: ( RULE_CARRIAGERETURN | RULE_LINEFEED )
            {
            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            at.jku.weiner.cpreprocess.utils.PreLine.setNewLine();

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
            // InternalCPreprocess.g:852:25: ( '\\\\' )
            // InternalCPreprocess.g:852:27: '\\\\'
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
            // InternalCPreprocess.g:854:25: ( RULE_BACKSLASH RULE_NEWLINE )
            // InternalCPreprocess.g:854:27: RULE_BACKSLASH RULE_NEWLINE
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
            // InternalCPreprocess.g:856:21: ( ' ' )
            // InternalCPreprocess.g:856:23: ' '
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
            // InternalCPreprocess.g:858:19: ( '\\t' )
            // InternalCPreprocess.g:858:21: '\\t'
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
            // InternalCPreprocess.g:860:18: ( ( RULE_SPACE | RULE_TAB | RULE_LINEBREAK ) )
            // InternalCPreprocess.g:860:20: ( RULE_SPACE | RULE_TAB | RULE_LINEBREAK )
            {
            // InternalCPreprocess.g:860:20: ( RULE_SPACE | RULE_TAB | RULE_LINEBREAK )
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
                    // InternalCPreprocess.g:860:21: RULE_SPACE
                    {
                    mRULE_SPACE(); 

                    }
                    break;
                case 2 :
                    // InternalCPreprocess.g:860:32: RULE_TAB
                    {
                    mRULE_TAB(); 

                    }
                    break;
                case 3 :
                    // InternalCPreprocess.g:860:41: RULE_LINEBREAK
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
            // InternalCPreprocess.g:862:20: ( '#' )
            // InternalCPreprocess.g:862:22: '#'
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
            // InternalCPreprocess.g:864:13: ( ( RULE_WS )* RULE_HASH ( RULE_WS )* 'define' ( RULE_WS )+ )
            // InternalCPreprocess.g:864:15: ( RULE_WS )* RULE_HASH ( RULE_WS )* 'define' ( RULE_WS )+
            {
            // InternalCPreprocess.g:864:15: ( RULE_WS )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='\t'||LA2_0==' '||LA2_0=='\\') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalCPreprocess.g:864:15: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            mRULE_HASH(); 
            // InternalCPreprocess.g:864:34: ( RULE_WS )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\t'||LA3_0==' '||LA3_0=='\\') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalCPreprocess.g:864:34: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match("define"); 

            // InternalCPreprocess.g:864:52: ( RULE_WS )+
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
            	    // InternalCPreprocess.g:864:52: RULE_WS
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

            at.jku.weiner.cpreprocess.utils.PreLine.setPreLine(true);

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
            // InternalCPreprocess.g:866:12: ( ( RULE_WS )* RULE_HASH ( RULE_WS )* 'undef' ( RULE_WS )+ )
            // InternalCPreprocess.g:866:14: ( RULE_WS )* RULE_HASH ( RULE_WS )* 'undef' ( RULE_WS )+
            {
            // InternalCPreprocess.g:866:14: ( RULE_WS )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\t'||LA5_0==' '||LA5_0=='\\') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalCPreprocess.g:866:14: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            mRULE_HASH(); 
            // InternalCPreprocess.g:866:33: ( RULE_WS )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\t'||LA6_0==' '||LA6_0=='\\') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalCPreprocess.g:866:33: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match("undef"); 

            // InternalCPreprocess.g:866:50: ( RULE_WS )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\t'||LA7_0==' '||LA7_0=='\\') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalCPreprocess.g:866:50: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            at.jku.weiner.cpreprocess.utils.PreLine.setPreLine(true);

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
            // InternalCPreprocess.g:868:14: ( ( RULE_WS )* RULE_HASH ( RULE_WS )* 'include' ( RULE_WS )+ )
            // InternalCPreprocess.g:868:16: ( RULE_WS )* RULE_HASH ( RULE_WS )* 'include' ( RULE_WS )+
            {
            // InternalCPreprocess.g:868:16: ( RULE_WS )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\t'||LA8_0==' '||LA8_0=='\\') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalCPreprocess.g:868:16: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            mRULE_HASH(); 
            // InternalCPreprocess.g:868:35: ( RULE_WS )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\t'||LA9_0==' '||LA9_0=='\\') ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalCPreprocess.g:868:35: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match("include"); 

            // InternalCPreprocess.g:868:54: ( RULE_WS )+
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
            	    // InternalCPreprocess.g:868:54: RULE_WS
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
    // $ANTLR end "RULE_INCLUDE"

    // $ANTLR start "RULE_ERROR"
    public final void mRULE_ERROR() throws RecognitionException {
        try {
            int _type = RULE_ERROR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:870:12: ( ( RULE_WS )* RULE_HASH ( RULE_WS )* 'error' ( RULE_WS )+ )
            // InternalCPreprocess.g:870:14: ( RULE_WS )* RULE_HASH ( RULE_WS )* 'error' ( RULE_WS )+
            {
            // InternalCPreprocess.g:870:14: ( RULE_WS )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='\t'||LA11_0==' '||LA11_0=='\\') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalCPreprocess.g:870:14: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            mRULE_HASH(); 
            // InternalCPreprocess.g:870:33: ( RULE_WS )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='\t'||LA12_0==' '||LA12_0=='\\') ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalCPreprocess.g:870:33: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            match("error"); 

            // InternalCPreprocess.g:870:50: ( RULE_WS )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0=='\t'||LA13_0==' '||LA13_0=='\\') ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalCPreprocess.g:870:50: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
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
            // InternalCPreprocess.g:872:13: ( ( RULE_WS )* RULE_HASH ( RULE_WS )* 'pragma' ( RULE_WS )+ )
            // InternalCPreprocess.g:872:15: ( RULE_WS )* RULE_HASH ( RULE_WS )* 'pragma' ( RULE_WS )+
            {
            // InternalCPreprocess.g:872:15: ( RULE_WS )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0=='\t'||LA14_0==' '||LA14_0=='\\') ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalCPreprocess.g:872:15: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            mRULE_HASH(); 
            // InternalCPreprocess.g:872:34: ( RULE_WS )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0=='\t'||LA15_0==' '||LA15_0=='\\') ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalCPreprocess.g:872:34: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            match("pragma"); 

            // InternalCPreprocess.g:872:52: ( RULE_WS )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0=='\t'||LA16_0==' '||LA16_0=='\\') ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalCPreprocess.g:872:52: RULE_WS
            	    {
            	    mRULE_WS(); 

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

            at.jku.weiner.cpreprocess.utils.PreLine.setPreLine(true);

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
            // InternalCPreprocess.g:874:9: ( RULE_IDENTIFIER )
            // InternalCPreprocess.g:874:11: RULE_IDENTIFIER
            {
            mRULE_IDENTIFIER(); 
            at.jku.weiner.cpreprocess.utils.PreLine.setPreLine(false);

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
            // InternalCPreprocess.g:876:26: ( RULE_LETTER ( RULE_LETTER | '0' .. '9' )* )
            // InternalCPreprocess.g:876:28: RULE_LETTER ( RULE_LETTER | '0' .. '9' )*
            {
            mRULE_LETTER(); 
            // InternalCPreprocess.g:876:40: ( RULE_LETTER | '0' .. '9' )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0=='$'||(LA17_0>='0' && LA17_0<='9')||(LA17_0>='A' && LA17_0<='Z')||LA17_0=='_'||(LA17_0>='a' && LA17_0<='z')) ) {
                    alt17=1;
                }


                switch (alt17) {
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
            	    break loop17;
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
            // InternalCPreprocess.g:878:22: ( ( '$' | 'A' .. 'Z' | 'a' .. 'z' | '_' ) )
            // InternalCPreprocess.g:878:24: ( '$' | 'A' .. 'Z' | 'a' .. 'z' | '_' )
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

    // $ANTLR start "RULE_MYCODE"
    public final void mRULE_MYCODE() throws RecognitionException {
        try {
            int _type = RULE_MYCODE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:880:13: ({...}? =>~ ( ( RULE_HASH | RULE_CARRIAGERETURN | RULE_LINEFEED ) ) (~ ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) ) )* )
            // InternalCPreprocess.g:880:15: {...}? =>~ ( ( RULE_HASH | RULE_CARRIAGERETURN | RULE_LINEFEED ) ) (~ ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) ) )*
            {
            if ( !((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))) ) {
                throw new FailedPredicateException(input, "RULE_MYCODE", "at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input)");
            }
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\"')||(input.LA(1)>='$' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalCPreprocess.g:880:130: (~ ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>='\u0000' && LA18_0<='\t')||(LA18_0>='\u000B' && LA18_0<='\f')||(LA18_0>='\u000E' && LA18_0<='\uFFFF')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalCPreprocess.g:880:130: ~ ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) )
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
            	    break loop18;
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
        int alt19=8;
        alt19 = dfa19.predict(input);
        switch (alt19) {
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


    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA19_eotS =
        "\2\uffff\3\7\1\uffff\1\26\1\uffff\4\7\11\uffff\1\43\1\uffff\10\7\6\uffff\25\7\1\103\1\104\3\7\1\113\1\114\2\7\2\uffff\1\120\1\121\1\7\1\122\1\123\1\7\2\uffff\1\124\1\125\1\7\6\uffff";
    static final String DFA19_eofS =
        "\126\uffff";
    static final String DFA19_minS =
        "\1\0\1\uffff\2\11\1\12\1\11\1\0\1\uffff\3\11\1\12\3\11\1\12\5\uffff\2\0\2\11\1\12\1\156\1\162\1\145\1\162\1\156\2\11\1\12\1\11\1\0\1\uffff\1\143\1\162\1\146\1\141\1\144\1\154\1\157\1\151\1\147\1\145\1\165\1\162\1\156\1\155\1\146\1\144\1\11\1\145\1\141\1\11\1\145\2\0\1\12\2\11\2\0\1\12\1\11\4\0\1\12\2\0\1\12\4\0\1\12\6\0";
    static final String DFA19_maxS =
        "\1\uffff\1\uffff\2\134\1\15\1\165\1\uffff\1\uffff\1\165\2\134\1\15\1\134\2\165\1\15\5\uffff\1\uffff\1\0\2\165\1\15\1\156\1\162\1\145\1\162\1\156\2\134\1\15\1\165\1\0\1\uffff\1\143\1\162\1\146\1\141\1\144\1\154\1\157\1\151\1\147\1\145\1\165\1\162\1\156\1\155\1\146\1\144\1\134\1\145\1\141\1\134\1\145\2\uffff\1\15\2\134\2\uffff\1\15\1\134\2\0\2\uffff\1\15\2\uffff\1\15\2\0\2\uffff\1\15\6\0";
    static final String DFA19_acceptS =
        "\1\uffff\1\1\5\uffff\1\10\10\uffff\1\4\1\5\1\2\1\6\1\3\17\uffff\1\7\61\uffff";
    static final String DFA19_specialS =
        "\1\1\1\uffff\1\61\1\36\1\54\1\uffff\1\15\1\uffff\1\56\1\7\1\73\1\34\11\uffff\1\72\1\46\1\37\1\20\1\35\1\66\1\40\1\3\1\32\1\77\4\uffff\1\47\1\uffff\1\67\1\42\1\12\1\30\1\75\1\62\1\43\1\11\1\16\1\76\1\63\1\41\1\10\1\17\1\74\1\64\1\27\1\6\1\21\1\55\1\65\1\26\1\31\1\0\1\23\1\13\1\57\1\60\1\14\1\70\1\53\1\52\1\71\1\24\1\22\1\100\1\4\1\2\1\102\1\101\1\33\1\25\1\5\1\104\1\103\1\45\1\44\1\51\1\50}>";
    static final String[] DFA19_transitionS = {
            "\11\7\1\3\1\1\2\7\1\1\22\7\1\2\2\7\1\5\1\6\34\7\32\6\1\7\1\4\2\7\1\6\1\7\32\6\uff85\7",
            "",
            "\1\12\26\uffff\1\11\2\uffff\1\10\70\uffff\1\13",
            "\1\12\26\uffff\1\11\2\uffff\1\10\70\uffff\1\13",
            "\1\14\2\uffff\1\14",
            "\1\16\26\uffff\1\15\73\uffff\1\17\7\uffff\1\22\1\21\3\uffff\1\20\6\uffff\1\23\4\uffff\1\24",
            "\12\7\1\uffff\2\7\1\uffff\26\7\1\25\13\7\12\25\7\7\32\25\4\7\1\25\1\7\32\25\uff85\7",
            "",
            "\1\30\26\uffff\1\27\73\uffff\1\31\7\uffff\1\34\1\33\3\uffff\1\32\6\uffff\1\35\4\uffff\1\36",
            "\1\12\26\uffff\1\11\2\uffff\1\10\70\uffff\1\13",
            "\1\12\26\uffff\1\11\2\uffff\1\10\70\uffff\1\13",
            "\1\14\2\uffff\1\14",
            "\1\40\26\uffff\1\37\2\uffff\1\5\70\uffff\1\41",
            "\1\16\26\uffff\1\15\73\uffff\1\17\7\uffff\1\22\1\21\3\uffff\1\20\6\uffff\1\23\4\uffff\1\24",
            "\1\16\26\uffff\1\15\73\uffff\1\17\7\uffff\1\22\1\21\3\uffff\1\20\6\uffff\1\23\4\uffff\1\24",
            "\1\42\2\uffff\1\42",
            "",
            "",
            "",
            "",
            "",
            "\12\7\1\uffff\2\7\1\uffff\26\7\1\25\13\7\12\25\7\7\32\25\4\7\1\25\1\7\32\25\uff85\7",
            "\1\uffff",
            "\1\30\26\uffff\1\27\73\uffff\1\31\7\uffff\1\34\1\33\3\uffff\1\32\6\uffff\1\35\4\uffff\1\36",
            "\1\30\26\uffff\1\27\73\uffff\1\31\7\uffff\1\34\1\33\3\uffff\1\32\6\uffff\1\35\4\uffff\1\36",
            "\1\42\2\uffff\1\42",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\40\26\uffff\1\37\2\uffff\1\5\70\uffff\1\41",
            "\1\40\26\uffff\1\37\2\uffff\1\5\70\uffff\1\41",
            "\1\14\2\uffff\1\14",
            "\1\16\26\uffff\1\15\73\uffff\1\17\7\uffff\1\22\1\21\3\uffff\1\20\6\uffff\1\23\4\uffff\1\24",
            "\1\uffff",
            "",
            "\1\52",
            "\1\53",
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
            "\1\71",
            "\1\73\26\uffff\1\72\73\uffff\1\74",
            "\1\75",
            "\1\76",
            "\1\100\26\uffff\1\77\73\uffff\1\101",
            "\1\102",
            "\11\7\1\73\1\uffff\2\7\1\uffff\22\7\1\72\73\7\1\74\uffa3\7",
            "\11\7\1\73\1\uffff\2\7\1\uffff\22\7\1\72\73\7\1\74\uffa3\7",
            "\1\21\2\uffff\1\21",
            "\1\106\26\uffff\1\105\73\uffff\1\107",
            "\1\111\26\uffff\1\110\73\uffff\1\112",
            "\11\7\1\100\1\uffff\2\7\1\uffff\22\7\1\77\73\7\1\101\uffa3\7",
            "\11\7\1\100\1\uffff\2\7\1\uffff\22\7\1\77\73\7\1\101\uffa3\7",
            "\1\24\2\uffff\1\24",
            "\1\116\26\uffff\1\115\73\uffff\1\117",
            "\1\uffff",
            "\1\uffff",
            "\11\7\1\106\1\uffff\2\7\1\uffff\22\7\1\105\73\7\1\107\uffa3\7",
            "\11\7\1\106\1\uffff\2\7\1\uffff\22\7\1\105\73\7\1\107\uffa3\7",
            "\1\22\2\uffff\1\22",
            "\11\7\1\111\1\uffff\2\7\1\uffff\22\7\1\110\73\7\1\112\uffa3\7",
            "\11\7\1\111\1\uffff\2\7\1\uffff\22\7\1\110\73\7\1\112\uffa3\7",
            "\1\23\2\uffff\1\23",
            "\1\uffff",
            "\1\uffff",
            "\11\7\1\116\1\uffff\2\7\1\uffff\22\7\1\115\73\7\1\117\uffa3\7",
            "\11\7\1\116\1\uffff\2\7\1\uffff\22\7\1\115\73\7\1\117\uffa3\7",
            "\1\20\2\uffff\1\20",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff"
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( RULE_NEWLINE | RULE_DEFINE | RULE_UNDEF | RULE_INCLUDE | RULE_ERROR | RULE_PRAGMA | RULE_ID | RULE_MYCODE );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA19_60 = input.LA(1);

                         
                        int index19_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_60=='\n'||LA19_60=='\r') ) {s = 17;}

                        else s = 7;

                         
                        input.seek(index19_60);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA19_0 = input.LA(1);

                         
                        int index19_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_0=='\n'||LA19_0=='\r') ) {s = 1;}

                        else if ( (LA19_0==' ') ) {s = 2;}

                        else if ( (LA19_0=='\t') ) {s = 3;}

                        else if ( (LA19_0=='\\') ) {s = 4;}

                        else if ( (LA19_0=='#') ) {s = 5;}

                        else if ( (LA19_0=='$'||(LA19_0>='A' && LA19_0<='Z')||LA19_0=='_'||(LA19_0>='a' && LA19_0<='z')) ) {s = 6;}

                        else if ( ((LA19_0>='\u0000' && LA19_0<='\b')||(LA19_0>='\u000B' && LA19_0<='\f')||(LA19_0>='\u000E' && LA19_0<='\u001F')||(LA19_0>='!' && LA19_0<='\"')||(LA19_0>='%' && LA19_0<='@')||LA19_0=='['||(LA19_0>=']' && LA19_0<='^')||LA19_0=='`'||(LA19_0>='{' && LA19_0<='\uFFFF')) && ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input)))) {s = 7;}

                         
                        input.seek(index19_0);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA19_74 = input.LA(1);

                         
                        int index19_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_74=='\n'||LA19_74=='\r') ) {s = 19;}

                        else s = 7;

                         
                        input.seek(index19_74);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA19_28 = input.LA(1);

                         
                        int index19_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_28=='e') ) {s = 39;}

                        else s = 7;

                         
                        input.seek(index19_28);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA19_73 = input.LA(1);

                         
                        int index19_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_73==' ') ) {s = 72;}

                        else if ( (LA19_73=='\t') ) {s = 73;}

                        else if ( (LA19_73=='\\') ) {s = 74;}

                        else if ( ((LA19_73>='\u0000' && LA19_73<='\b')||(LA19_73>='\u000B' && LA19_73<='\f')||(LA19_73>='\u000E' && LA19_73<='\u001F')||(LA19_73>='!' && LA19_73<='[')||(LA19_73>=']' && LA19_73<='\uFFFF')) && ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input)))) {s = 7;}

                        else s = 83;

                         
                        input.seek(index19_73);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA19_79 = input.LA(1);

                         
                        int index19_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_79=='\n'||LA19_79=='\r') ) {s = 16;}

                        else s = 7;

                         
                        input.seek(index19_79);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA19_54 = input.LA(1);

                         
                        int index19_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_54=='e') ) {s = 61;}

                        else s = 7;

                         
                        input.seek(index19_54);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA19_9 = input.LA(1);

                         
                        int index19_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_9=='#') ) {s = 8;}

                        else if ( (LA19_9==' ') ) {s = 9;}

                        else if ( (LA19_9=='\t') ) {s = 10;}

                        else if ( (LA19_9=='\\') ) {s = 11;}

                        else s = 7;

                         
                        input.seek(index19_9);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA19_49 = input.LA(1);

                         
                        int index19_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_49=='n') ) {s = 54;}

                        else s = 7;

                         
                        input.seek(index19_49);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA19_44 = input.LA(1);

                         
                        int index19_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_44=='i') ) {s = 49;}

                        else s = 7;

                         
                        input.seek(index19_44);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA19_39 = input.LA(1);

                         
                        int index19_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_39=='f') ) {s = 44;}

                        else s = 7;

                         
                        input.seek(index19_39);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA19_62 = input.LA(1);

                         
                        int index19_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_62==' ') ) {s = 72;}

                        else if ( (LA19_62=='\t') ) {s = 73;}

                        else if ( (LA19_62=='\\') ) {s = 74;}

                        else s = 7;

                         
                        input.seek(index19_62);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA19_65 = input.LA(1);

                         
                        int index19_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_65=='\n'||LA19_65=='\r') ) {s = 20;}

                        else s = 7;

                         
                        input.seek(index19_65);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA19_6 = input.LA(1);

                         
                        int index19_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_6=='$'||(LA19_6>='0' && LA19_6<='9')||(LA19_6>='A' && LA19_6<='Z')||LA19_6=='_'||(LA19_6>='a' && LA19_6<='z')) ) {s = 21;}

                        else if ( ((LA19_6>='\u0000' && LA19_6<='\t')||(LA19_6>='\u000B' && LA19_6<='\f')||(LA19_6>='\u000E' && LA19_6<='#')||(LA19_6>='%' && LA19_6<='/')||(LA19_6>=':' && LA19_6<='@')||(LA19_6>='[' && LA19_6<='^')||LA19_6=='`'||(LA19_6>='{' && LA19_6<='\uFFFF')) && ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input)))) {s = 7;}

                        else s = 22;

                         
                        input.seek(index19_6);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA19_45 = input.LA(1);

                         
                        int index19_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_45=='g') ) {s = 50;}

                        else s = 7;

                         
                        input.seek(index19_45);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA19_50 = input.LA(1);

                         
                        int index19_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_50=='m') ) {s = 55;}

                        else s = 7;

                         
                        input.seek(index19_50);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA19_24 = input.LA(1);

                         
                        int index19_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_24=='p') ) {s = 29;}

                        else if ( (LA19_24==' ') ) {s = 23;}

                        else if ( (LA19_24=='\t') ) {s = 24;}

                        else if ( (LA19_24=='\\') ) {s = 25;}

                        else if ( (LA19_24=='i') ) {s = 26;}

                        else if ( (LA19_24=='e') ) {s = 27;}

                        else if ( (LA19_24=='d') ) {s = 28;}

                        else if ( (LA19_24=='u') ) {s = 30;}

                        else s = 7;

                         
                        input.seek(index19_24);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA19_55 = input.LA(1);

                         
                        int index19_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_55=='a') ) {s = 62;}

                        else s = 7;

                         
                        input.seek(index19_55);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA19_71 = input.LA(1);

                         
                        int index19_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_71=='\n'||LA19_71=='\r') ) {s = 18;}

                        else s = 7;

                         
                        input.seek(index19_71);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA19_61 = input.LA(1);

                         
                        int index19_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_61==' ') ) {s = 69;}

                        else if ( (LA19_61=='\t') ) {s = 70;}

                        else if ( (LA19_61=='\\') ) {s = 71;}

                        else s = 7;

                         
                        input.seek(index19_61);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA19_70 = input.LA(1);

                         
                        int index19_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_70==' ') ) {s = 69;}

                        else if ( (LA19_70=='\t') ) {s = 70;}

                        else if ( (LA19_70=='\\') ) {s = 71;}

                        else if ( ((LA19_70>='\u0000' && LA19_70<='\b')||(LA19_70>='\u000B' && LA19_70<='\f')||(LA19_70>='\u000E' && LA19_70<='\u001F')||(LA19_70>='!' && LA19_70<='[')||(LA19_70>=']' && LA19_70<='\uFFFF')) && ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input)))) {s = 7;}

                        else s = 81;

                         
                        input.seek(index19_70);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA19_78 = input.LA(1);

                         
                        int index19_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_78==' ') ) {s = 77;}

                        else if ( (LA19_78=='\t') ) {s = 78;}

                        else if ( (LA19_78=='\\') ) {s = 79;}

                        else if ( ((LA19_78>='\u0000' && LA19_78<='\b')||(LA19_78>='\u000B' && LA19_78<='\f')||(LA19_78>='\u000E' && LA19_78<='\u001F')||(LA19_78>='!' && LA19_78<='[')||(LA19_78>=']' && LA19_78<='\uFFFF')) && ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input)))) {s = 7;}

                        else s = 85;

                         
                        input.seek(index19_78);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA19_58 = input.LA(1);

                         
                        int index19_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_58==' ') ) {s = 58;}

                        else if ( (LA19_58=='\t') ) {s = 59;}

                        else if ( (LA19_58=='\\') ) {s = 60;}

                        else if ( ((LA19_58>='\u0000' && LA19_58<='\b')||(LA19_58>='\u000B' && LA19_58<='\f')||(LA19_58>='\u000E' && LA19_58<='\u001F')||(LA19_58>='!' && LA19_58<='[')||(LA19_58>=']' && LA19_58<='\uFFFF')) && ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input)))) {s = 7;}

                        else s = 67;

                         
                        input.seek(index19_58);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA19_53 = input.LA(1);

                         
                        int index19_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_53==' ') ) {s = 58;}

                        else if ( (LA19_53=='\t') ) {s = 59;}

                        else if ( (LA19_53=='\\') ) {s = 60;}

                        else s = 7;

                         
                        input.seek(index19_53);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA19_40 = input.LA(1);

                         
                        int index19_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_40=='a') ) {s = 45;}

                        else s = 7;

                         
                        input.seek(index19_40);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA19_59 = input.LA(1);

                         
                        int index19_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_59==' ') ) {s = 58;}

                        else if ( (LA19_59=='\t') ) {s = 59;}

                        else if ( (LA19_59=='\\') ) {s = 60;}

                        else if ( ((LA19_59>='\u0000' && LA19_59<='\b')||(LA19_59>='\u000B' && LA19_59<='\f')||(LA19_59>='\u000E' && LA19_59<='\u001F')||(LA19_59>='!' && LA19_59<='[')||(LA19_59>=']' && LA19_59<='\uFFFF')) && ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input)))) {s = 7;}

                        else s = 68;

                         
                        input.seek(index19_59);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA19_29 = input.LA(1);

                         
                        int index19_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_29=='r') ) {s = 40;}

                        else s = 7;

                         
                        input.seek(index19_29);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA19_77 = input.LA(1);

                         
                        int index19_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_77==' ') ) {s = 77;}

                        else if ( (LA19_77=='\t') ) {s = 78;}

                        else if ( (LA19_77=='\\') ) {s = 79;}

                        else if ( ((LA19_77>='\u0000' && LA19_77<='\b')||(LA19_77>='\u000B' && LA19_77<='\f')||(LA19_77>='\u000E' && LA19_77<='\u001F')||(LA19_77>='!' && LA19_77<='[')||(LA19_77>=']' && LA19_77<='\uFFFF')) && ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input)))) {s = 7;}

                        else s = 84;

                         
                        input.seek(index19_77);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA19_11 = input.LA(1);

                         
                        int index19_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_11=='\n'||LA19_11=='\r') ) {s = 12;}

                        else s = 7;

                         
                        input.seek(index19_11);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA19_25 = input.LA(1);

                         
                        int index19_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_25=='\n'||LA19_25=='\r') ) {s = 34;}

                        else s = 7;

                         
                        input.seek(index19_25);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA19_3 = input.LA(1);

                         
                        int index19_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_3=='#') ) {s = 8;}

                        else if ( (LA19_3==' ') ) {s = 9;}

                        else if ( (LA19_3=='\t') ) {s = 10;}

                        else if ( (LA19_3=='\\') ) {s = 11;}

                        else s = 7;

                         
                        input.seek(index19_3);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA19_23 = input.LA(1);

                         
                        int index19_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_23=='i') ) {s = 26;}

                        else if ( (LA19_23==' ') ) {s = 23;}

                        else if ( (LA19_23=='\t') ) {s = 24;}

                        else if ( (LA19_23=='\\') ) {s = 25;}

                        else if ( (LA19_23=='e') ) {s = 27;}

                        else if ( (LA19_23=='p') ) {s = 29;}

                        else if ( (LA19_23=='u') ) {s = 30;}

                        else if ( (LA19_23=='d') ) {s = 28;}

                        else s = 7;

                         
                        input.seek(index19_23);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA19_27 = input.LA(1);

                         
                        int index19_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_27=='r') ) {s = 38;}

                        else s = 7;

                         
                        input.seek(index19_27);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA19_48 = input.LA(1);

                         
                        int index19_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_48=='r') ) {s = 53;}

                        else s = 7;

                         
                        input.seek(index19_48);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA19_38 = input.LA(1);

                         
                        int index19_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_38=='r') ) {s = 43;}

                        else s = 7;

                         
                        input.seek(index19_38);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA19_43 = input.LA(1);

                         
                        int index19_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_43=='o') ) {s = 48;}

                        else s = 7;

                         
                        input.seek(index19_43);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA19_83 = input.LA(1);

                         
                        int index19_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))))) ) {s = 19;}

                        else if ( ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))) ) {s = 7;}

                         
                        input.seek(index19_83);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA19_82 = input.LA(1);

                         
                        int index19_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))))) ) {s = 19;}

                        else if ( ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))) ) {s = 7;}

                         
                        input.seek(index19_82);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA19_22 = input.LA(1);

                         
                        int index19_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))))) ) {s = 36;}

                        else if ( ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))) ) {s = 7;}

                         
                        input.seek(index19_22);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA19_35 = input.LA(1);

                         
                        int index19_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))))) ) {s = 36;}

                        else if ( ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))) ) {s = 7;}

                         
                        input.seek(index19_35);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA19_85 = input.LA(1);

                         
                        int index19_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))))) ) {s = 16;}

                        else if ( ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))) ) {s = 7;}

                         
                        input.seek(index19_85);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA19_84 = input.LA(1);

                         
                        int index19_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))))) ) {s = 16;}

                        else if ( ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))) ) {s = 7;}

                         
                        input.seek(index19_84);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA19_68 = input.LA(1);

                         
                        int index19_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))))) ) {s = 17;}

                        else if ( ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))) ) {s = 7;}

                         
                        input.seek(index19_68);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA19_67 = input.LA(1);

                         
                        int index19_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))))) ) {s = 17;}

                        else if ( ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))) ) {s = 7;}

                         
                        input.seek(index19_67);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA19_4 = input.LA(1);

                         
                        int index19_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_4=='\n'||LA19_4=='\r') ) {s = 12;}

                        else s = 7;

                         
                        input.seek(index19_4);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA19_56 = input.LA(1);

                         
                        int index19_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_56==' ') ) {s = 63;}

                        else if ( (LA19_56=='\t') ) {s = 64;}

                        else if ( (LA19_56=='\\') ) {s = 65;}

                        else s = 7;

                         
                        input.seek(index19_56);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA19_8 = input.LA(1);

                         
                        int index19_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_8==' ') ) {s = 23;}

                        else if ( (LA19_8=='\t') ) {s = 24;}

                        else if ( (LA19_8=='\\') ) {s = 25;}

                        else if ( (LA19_8=='i') ) {s = 26;}

                        else if ( (LA19_8=='e') ) {s = 27;}

                        else if ( (LA19_8=='d') ) {s = 28;}

                        else if ( (LA19_8=='p') ) {s = 29;}

                        else if ( (LA19_8=='u') ) {s = 30;}

                        else s = 7;

                         
                        input.seek(index19_8);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA19_63 = input.LA(1);

                         
                        int index19_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_63==' ') ) {s = 63;}

                        else if ( (LA19_63=='\t') ) {s = 64;}

                        else if ( (LA19_63=='\\') ) {s = 65;}

                        else if ( ((LA19_63>='\u0000' && LA19_63<='\b')||(LA19_63>='\u000B' && LA19_63<='\f')||(LA19_63>='\u000E' && LA19_63<='\u001F')||(LA19_63>='!' && LA19_63<='[')||(LA19_63>=']' && LA19_63<='\uFFFF')) && ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input)))) {s = 7;}

                        else s = 75;

                         
                        input.seek(index19_63);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA19_64 = input.LA(1);

                         
                        int index19_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_64==' ') ) {s = 63;}

                        else if ( (LA19_64=='\t') ) {s = 64;}

                        else if ( (LA19_64=='\\') ) {s = 65;}

                        else if ( ((LA19_64>='\u0000' && LA19_64<='\b')||(LA19_64>='\u000B' && LA19_64<='\f')||(LA19_64>='\u000E' && LA19_64<='\u001F')||(LA19_64>='!' && LA19_64<='[')||(LA19_64>=']' && LA19_64<='\uFFFF')) && ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input)))) {s = 7;}

                        else s = 76;

                         
                        input.seek(index19_64);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA19_2 = input.LA(1);

                         
                        int index19_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_2=='#') ) {s = 8;}

                        else if ( (LA19_2==' ') ) {s = 9;}

                        else if ( (LA19_2=='\t') ) {s = 10;}

                        else if ( (LA19_2=='\\') ) {s = 11;}

                        else s = 7;

                         
                        input.seek(index19_2);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA19_42 = input.LA(1);

                         
                        int index19_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_42=='l') ) {s = 47;}

                        else s = 7;

                         
                        input.seek(index19_42);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA19_47 = input.LA(1);

                         
                        int index19_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_47=='u') ) {s = 52;}

                        else s = 7;

                         
                        input.seek(index19_47);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA19_52 = input.LA(1);

                         
                        int index19_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_52=='d') ) {s = 57;}

                        else s = 7;

                         
                        input.seek(index19_52);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA19_57 = input.LA(1);

                         
                        int index19_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_57=='e') ) {s = 66;}

                        else s = 7;

                         
                        input.seek(index19_57);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA19_26 = input.LA(1);

                         
                        int index19_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_26=='n') ) {s = 37;}

                        else s = 7;

                         
                        input.seek(index19_26);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA19_37 = input.LA(1);

                         
                        int index19_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_37=='c') ) {s = 42;}

                        else s = 7;

                         
                        input.seek(index19_37);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA19_66 = input.LA(1);

                         
                        int index19_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_66==' ') ) {s = 77;}

                        else if ( (LA19_66=='\t') ) {s = 78;}

                        else if ( (LA19_66=='\\') ) {s = 79;}

                        else s = 7;

                         
                        input.seek(index19_66);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA19_69 = input.LA(1);

                         
                        int index19_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_69==' ') ) {s = 69;}

                        else if ( (LA19_69=='\t') ) {s = 70;}

                        else if ( (LA19_69=='\\') ) {s = 71;}

                        else if ( ((LA19_69>='\u0000' && LA19_69<='\b')||(LA19_69>='\u000B' && LA19_69<='\f')||(LA19_69>='\u000E' && LA19_69<='\u001F')||(LA19_69>='!' && LA19_69<='[')||(LA19_69>=']' && LA19_69<='\uFFFF')) && ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input)))) {s = 7;}

                        else s = 80;

                         
                        input.seek(index19_69);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA19_21 = input.LA(1);

                         
                        int index19_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_21=='$'||(LA19_21>='0' && LA19_21<='9')||(LA19_21>='A' && LA19_21<='Z')||LA19_21=='_'||(LA19_21>='a' && LA19_21<='z')) ) {s = 21;}

                        else if ( ((LA19_21>='\u0000' && LA19_21<='\t')||(LA19_21>='\u000B' && LA19_21<='\f')||(LA19_21>='\u000E' && LA19_21<='#')||(LA19_21>='%' && LA19_21<='/')||(LA19_21>=':' && LA19_21<='@')||(LA19_21>='[' && LA19_21<='^')||LA19_21=='`'||(LA19_21>='{' && LA19_21<='\uFFFF')) && ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input)))) {s = 7;}

                        else s = 35;

                         
                        input.seek(index19_21);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA19_10 = input.LA(1);

                         
                        int index19_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_10=='#') ) {s = 8;}

                        else if ( (LA19_10==' ') ) {s = 9;}

                        else if ( (LA19_10=='\t') ) {s = 10;}

                        else if ( (LA19_10=='\\') ) {s = 11;}

                        else s = 7;

                         
                        input.seek(index19_10);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA19_51 = input.LA(1);

                         
                        int index19_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_51=='f') ) {s = 56;}

                        else s = 7;

                         
                        input.seek(index19_51);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA19_41 = input.LA(1);

                         
                        int index19_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_41=='d') ) {s = 46;}

                        else s = 7;

                         
                        input.seek(index19_41);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA19_46 = input.LA(1);

                         
                        int index19_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_46=='e') ) {s = 51;}

                        else s = 7;

                         
                        input.seek(index19_46);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA19_30 = input.LA(1);

                         
                        int index19_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_30=='n') ) {s = 41;}

                        else s = 7;

                         
                        input.seek(index19_30);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA19_72 = input.LA(1);

                         
                        int index19_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_72==' ') ) {s = 72;}

                        else if ( (LA19_72=='\t') ) {s = 73;}

                        else if ( (LA19_72=='\\') ) {s = 74;}

                        else if ( ((LA19_72>='\u0000' && LA19_72<='\b')||(LA19_72>='\u000B' && LA19_72<='\f')||(LA19_72>='\u000E' && LA19_72<='\u001F')||(LA19_72>='!' && LA19_72<='[')||(LA19_72>=']' && LA19_72<='\uFFFF')) && ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input)))) {s = 7;}

                        else s = 82;

                         
                        input.seek(index19_72);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA19_76 = input.LA(1);

                         
                        int index19_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))))) ) {s = 20;}

                        else if ( ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))) ) {s = 7;}

                         
                        input.seek(index19_76);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA19_75 = input.LA(1);

                         
                        int index19_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))))) ) {s = 20;}

                        else if ( ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))) ) {s = 7;}

                         
                        input.seek(index19_75);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA19_81 = input.LA(1);

                         
                        int index19_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))))) ) {s = 18;}

                        else if ( ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))) ) {s = 7;}

                         
                        input.seek(index19_81);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA19_80 = input.LA(1);

                         
                        int index19_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))))) ) {s = 18;}

                        else if ( ((at.jku.weiner.cpreprocess.utils.PreLine.checkIfIsCode(input))) ) {s = 7;}

                         
                        input.seek(index19_80);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 19, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}