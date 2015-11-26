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
    public static final int RULE_IFDEF=13;
    public static final int RULE_ID=4;
    public static final int RULE_NEWLINE=17;
    public static final int RULE_ID_NONDIGIT=27;
    public static final int RULE_NONDIGIT_LETTER=29;
    public static final int RULE_ERROR=8;
    public static final int RULE_COMMA=12;
    public static final int RULE_HASH=16;
    public static final int RULE_TAB=24;
    public static final int RULE_UNDEF=18;
    public static final int EOF=-1;
    public static final int RULE_HEXADECIMAL_DIGIT=32;
    public static final int RULE_ENDIF=14;
    public static final int RULE_LINEBREAK=22;
    public static final int RULE_DEFINE=7;
    public static final int RULE_LPAREN=10;
    public static final int RULE_SPECIAL=5;
    public static final int RULE_CARRIAGERETURN=20;
    public static final int RULE_LINE_COMMENT=25;
    public static final int RULE_INCLUDE=6;
    public static final int RULE_BACKSLASH=21;
    public static final int RULE_RPAREN=11;
    public static final int RULE_WS=15;
    public static final int RULE_DIGIT=28;
    public static final int RULE_SPACE=23;
    public static final int RULE_UNIVERSAL_CHARACTER=30;
    public static final int RULE_LINEFEED=19;
    public static final int RULE_BLOCK_COMMENT=26;
    public static final int RULE_HEX_QUAD=31;

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
            // InternalCPreprocess.g:3814:11: ( '#' )
            // InternalCPreprocess.g:3814:13: '#'
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
            // InternalCPreprocess.g:3816:14: ( 'include' )
            // InternalCPreprocess.g:3816:16: 'include'
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
            // InternalCPreprocess.g:3818:13: ( 'define' )
            // InternalCPreprocess.g:3818:15: 'define'
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
            // InternalCPreprocess.g:3820:12: ( 'error' )
            // InternalCPreprocess.g:3820:14: 'error'
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
            // InternalCPreprocess.g:3822:12: ( 'undef' )
            // InternalCPreprocess.g:3822:14: 'undef'
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

    // $ANTLR start "RULE_IFDEF"
    public final void mRULE_IFDEF() throws RecognitionException {
        try {
            int _type = RULE_IFDEF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:3824:12: ( 'ifdef' )
            // InternalCPreprocess.g:3824:14: 'ifdef'
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

    // $ANTLR start "RULE_ENDIF"
    public final void mRULE_ENDIF() throws RecognitionException {
        try {
            int _type = RULE_ENDIF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCPreprocess.g:3826:12: ( 'endif' )
            // InternalCPreprocess.g:3826:14: 'endif'
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
            // InternalCPreprocess.g:3828:13: ( 'pragma' )
            // InternalCPreprocess.g:3828:15: 'pragma'
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
            // InternalCPreprocess.g:3830:13: ( '(' )
            // InternalCPreprocess.g:3830:15: '('
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
            // InternalCPreprocess.g:3832:13: ( ')' )
            // InternalCPreprocess.g:3832:15: ')'
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
            // InternalCPreprocess.g:3834:12: ( ',' )
            // InternalCPreprocess.g:3834:14: ','
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
            // InternalCPreprocess.g:3836:24: ( '\\n' )
            // InternalCPreprocess.g:3836:26: '\\n'
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
            // InternalCPreprocess.g:3838:30: ( '\\r' )
            // InternalCPreprocess.g:3838:32: '\\r'
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
            // InternalCPreprocess.g:3840:14: ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) )
            // InternalCPreprocess.g:3840:16: ( RULE_CARRIAGERETURN | RULE_LINEFEED )
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
            // InternalCPreprocess.g:3842:25: ( '\\\\' )
            // InternalCPreprocess.g:3842:27: '\\\\'
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
            // InternalCPreprocess.g:3844:25: ( RULE_BACKSLASH RULE_NEWLINE )
            // InternalCPreprocess.g:3844:27: RULE_BACKSLASH RULE_NEWLINE
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
            // InternalCPreprocess.g:3846:21: ( ' ' )
            // InternalCPreprocess.g:3846:23: ' '
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
            // InternalCPreprocess.g:3848:19: ( '\\t' )
            // InternalCPreprocess.g:3848:21: '\\t'
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
            // InternalCPreprocess.g:3850:9: ( ( RULE_SPACE | RULE_TAB | RULE_LINE_COMMENT | RULE_BLOCK_COMMENT | RULE_LINEBREAK ) )
            // InternalCPreprocess.g:3850:11: ( RULE_SPACE | RULE_TAB | RULE_LINE_COMMENT | RULE_BLOCK_COMMENT | RULE_LINEBREAK )
            {
            // InternalCPreprocess.g:3850:11: ( RULE_SPACE | RULE_TAB | RULE_LINE_COMMENT | RULE_BLOCK_COMMENT | RULE_LINEBREAK )
            int alt1=5;
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
            case '/':
                {
                int LA1_3 = input.LA(2);

                if ( (LA1_3=='/') ) {
                    alt1=3;
                }
                else if ( (LA1_3=='*') ) {
                    alt1=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 3, input);

                    throw nvae;
                }
                }
                break;
            case '\\':
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalCPreprocess.g:3850:12: RULE_SPACE
                    {
                    mRULE_SPACE(); 

                    }
                    break;
                case 2 :
                    // InternalCPreprocess.g:3850:23: RULE_TAB
                    {
                    mRULE_TAB(); 

                    }
                    break;
                case 3 :
                    // InternalCPreprocess.g:3850:32: RULE_LINE_COMMENT
                    {
                    mRULE_LINE_COMMENT(); 

                    }
                    break;
                case 4 :
                    // InternalCPreprocess.g:3850:50: RULE_BLOCK_COMMENT
                    {
                    mRULE_BLOCK_COMMENT(); 

                    }
                    break;
                case 5 :
                    // InternalCPreprocess.g:3850:69: RULE_LINEBREAK
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
            // InternalCPreprocess.g:3852:9: ( RULE_ID_NONDIGIT ( RULE_ID_NONDIGIT | RULE_DIGIT )* )
            // InternalCPreprocess.g:3852:11: RULE_ID_NONDIGIT ( RULE_ID_NONDIGIT | RULE_DIGIT )*
            {
            mRULE_ID_NONDIGIT(); 
            // InternalCPreprocess.g:3852:28: ( RULE_ID_NONDIGIT | RULE_DIGIT )*
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
            	    // InternalCPreprocess.g:3852:29: RULE_ID_NONDIGIT
            	    {
            	    mRULE_ID_NONDIGIT(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalCPreprocess.g:3852:46: RULE_DIGIT
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
            // InternalCPreprocess.g:3854:27: ( ( RULE_NONDIGIT_LETTER | RULE_UNIVERSAL_CHARACTER ) )
            // InternalCPreprocess.g:3854:29: ( RULE_NONDIGIT_LETTER | RULE_UNIVERSAL_CHARACTER )
            {
            // InternalCPreprocess.g:3854:29: ( RULE_NONDIGIT_LETTER | RULE_UNIVERSAL_CHARACTER )
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
                    // InternalCPreprocess.g:3854:30: RULE_NONDIGIT_LETTER
                    {
                    mRULE_NONDIGIT_LETTER(); 

                    }
                    break;
                case 2 :
                    // InternalCPreprocess.g:3854:51: RULE_UNIVERSAL_CHARACTER
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
            // InternalCPreprocess.g:3856:21: ( '0' .. '9' )
            // InternalCPreprocess.g:3856:23: '0' .. '9'
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
            // InternalCPreprocess.g:3858:31: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) )
            // InternalCPreprocess.g:3858:33: ( 'a' .. 'z' | 'A' .. 'Z' | '_' )
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
            // InternalCPreprocess.g:3860:35: ( ( '\\\\u' RULE_HEX_QUAD | '\\\\U' RULE_HEX_QUAD RULE_HEX_QUAD ) )
            // InternalCPreprocess.g:3860:37: ( '\\\\u' RULE_HEX_QUAD | '\\\\U' RULE_HEX_QUAD RULE_HEX_QUAD )
            {
            // InternalCPreprocess.g:3860:37: ( '\\\\u' RULE_HEX_QUAD | '\\\\U' RULE_HEX_QUAD RULE_HEX_QUAD )
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
                    // InternalCPreprocess.g:3860:38: '\\\\u' RULE_HEX_QUAD
                    {
                    match("\\u"); 

                    mRULE_HEX_QUAD(); 

                    }
                    break;
                case 2 :
                    // InternalCPreprocess.g:3860:58: '\\\\U' RULE_HEX_QUAD RULE_HEX_QUAD
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
            // InternalCPreprocess.g:3862:24: ( RULE_HEXADECIMAL_DIGIT RULE_HEXADECIMAL_DIGIT RULE_HEXADECIMAL_DIGIT RULE_HEXADECIMAL_DIGIT )
            // InternalCPreprocess.g:3862:26: RULE_HEXADECIMAL_DIGIT RULE_HEXADECIMAL_DIGIT RULE_HEXADECIMAL_DIGIT RULE_HEXADECIMAL_DIGIT
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
            // InternalCPreprocess.g:3864:33: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // InternalCPreprocess.g:3864:35: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
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
            // InternalCPreprocess.g:3866:14: ( . )
            // InternalCPreprocess.g:3866:16: .
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

    // $ANTLR start "RULE_BLOCK_COMMENT"
    public final void mRULE_BLOCK_COMMENT() throws RecognitionException {
        try {
            // InternalCPreprocess.g:3868:29: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalCPreprocess.g:3868:31: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalCPreprocess.g:3868:36: ( options {greedy=false; } : . )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='*') ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1=='/') ) {
                        alt5=2;
                    }
                    else if ( ((LA5_1>='\u0000' && LA5_1<='.')||(LA5_1>='0' && LA5_1<='\uFFFF')) ) {
                        alt5=1;
                    }


                }
                else if ( ((LA5_0>='\u0000' && LA5_0<=')')||(LA5_0>='+' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalCPreprocess.g:3868:64: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match("*/"); 


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_BLOCK_COMMENT"

    // $ANTLR start "RULE_LINE_COMMENT"
    public final void mRULE_LINE_COMMENT() throws RecognitionException {
        try {
            // InternalCPreprocess.g:3870:28: ( '//' (~ ( RULE_NEWLINE ) )* )
            // InternalCPreprocess.g:3870:30: '//' (~ ( RULE_NEWLINE ) )*
            {
            match("//"); 

            // InternalCPreprocess.g:3870:35: (~ ( RULE_NEWLINE ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='\t')||(LA6_0>='\u000B' && LA6_0<='\f')||(LA6_0>='\u000E' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalCPreprocess.g:3870:35: ~ ( RULE_NEWLINE )
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
            	    break loop6;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_LINE_COMMENT"

    public void mTokens() throws RecognitionException {
        // InternalCPreprocess.g:1:8: ( RULE_HASH | RULE_INCLUDE | RULE_DEFINE | RULE_ERROR | RULE_UNDEF | RULE_IFDEF | RULE_ENDIF | RULE_PRAGMA | RULE_LPAREN | RULE_RPAREN | RULE_COMMA | RULE_NEWLINE | RULE_WS | RULE_ID | RULE_SPECIAL )
        int alt7=15;
        alt7 = dfa7.predict(input);
        switch (alt7) {
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
                // InternalCPreprocess.g:1:67: RULE_IFDEF
                {
                mRULE_IFDEF(); 

                }
                break;
            case 7 :
                // InternalCPreprocess.g:1:78: RULE_ENDIF
                {
                mRULE_ENDIF(); 

                }
                break;
            case 8 :
                // InternalCPreprocess.g:1:89: RULE_PRAGMA
                {
                mRULE_PRAGMA(); 

                }
                break;
            case 9 :
                // InternalCPreprocess.g:1:101: RULE_LPAREN
                {
                mRULE_LPAREN(); 

                }
                break;
            case 10 :
                // InternalCPreprocess.g:1:113: RULE_RPAREN
                {
                mRULE_RPAREN(); 

                }
                break;
            case 11 :
                // InternalCPreprocess.g:1:125: RULE_COMMA
                {
                mRULE_COMMA(); 

                }
                break;
            case 12 :
                // InternalCPreprocess.g:1:136: RULE_NEWLINE
                {
                mRULE_NEWLINE(); 

                }
                break;
            case 13 :
                // InternalCPreprocess.g:1:149: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 14 :
                // InternalCPreprocess.g:1:157: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 15 :
                // InternalCPreprocess.g:1:165: RULE_SPECIAL
                {
                mRULE_SPECIAL(); 

                }
                break;

        }

    }


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\2\uffff\5\24\6\uffff\2\20\3\uffff\2\24\1\uffff\5\24\5\uffff\17\24\1\65\1\24\1\67\1\70\1\71\2\24\1\uffff\1\74\3\uffff\1\75\1\76\3\uffff";
    static final String DFA7_eofS =
        "\77\uffff";
    static final String DFA7_minS =
        "\1\0\1\uffff\1\146\1\145\2\156\1\162\6\uffff\1\52\1\12\3\uffff\1\143\1\144\1\uffff\1\146\1\162\2\144\1\141\5\uffff\1\154\1\145\1\151\1\157\1\151\1\145\1\147\1\165\1\146\1\156\1\162\2\146\1\155\1\144\1\60\1\145\3\60\1\141\1\145\1\uffff\1\60\3\uffff\2\60\3\uffff";
    static final String DFA7_maxS =
        "\1\uffff\1\uffff\1\156\1\145\1\162\1\156\1\162\6\uffff\1\57\1\165\3\uffff\1\143\1\144\1\uffff\1\146\1\162\2\144\1\141\5\uffff\1\154\1\145\1\151\1\157\1\151\1\145\1\147\1\165\1\146\1\156\1\162\2\146\1\155\1\144\1\172\1\145\3\172\1\141\1\145\1\uffff\1\172\3\uffff\2\172\3\uffff";
    static final String DFA7_acceptS =
        "\1\uffff\1\1\5\uffff\1\11\1\12\1\13\1\14\2\15\2\uffff\1\16\1\17\1\1\2\uffff\1\16\5\uffff\1\11\1\12\1\13\1\14\1\15\26\uffff\1\6\1\uffff\1\4\1\7\1\5\2\uffff\1\3\1\10\1\2";
    static final String DFA7_specialS =
        "\1\0\76\uffff}>";
    static final String[] DFA7_transitionS = {
            "\11\20\1\14\1\12\2\20\1\12\22\20\1\13\2\20\1\1\4\20\1\7\1\10\2\20\1\11\2\20\1\15\21\20\32\17\1\20\1\16\2\20\1\17\1\20\3\17\1\3\1\4\3\17\1\2\6\17\1\6\4\17\1\5\5\17\uff85\20",
            "",
            "\1\23\7\uffff\1\22",
            "\1\25",
            "\1\27\3\uffff\1\26",
            "\1\30",
            "\1\31",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\36\4\uffff\1\36",
            "\1\36\2\uffff\1\36\107\uffff\1\24\37\uffff\1\24",
            "",
            "",
            "",
            "\1\37",
            "\1\40",
            "",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "",
            "",
            "",
            "",
            "",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
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
            "\12\24\7\uffff\32\24\1\uffff\1\24\2\uffff\1\24\1\uffff\32\24",
            "\1\66",
            "\12\24\7\uffff\32\24\1\uffff\1\24\2\uffff\1\24\1\uffff\32\24",
            "\12\24\7\uffff\32\24\1\uffff\1\24\2\uffff\1\24\1\uffff\32\24",
            "\12\24\7\uffff\32\24\1\uffff\1\24\2\uffff\1\24\1\uffff\32\24",
            "\1\72",
            "\1\73",
            "",
            "\12\24\7\uffff\32\24\1\uffff\1\24\2\uffff\1\24\1\uffff\32\24",
            "",
            "",
            "",
            "\12\24\7\uffff\32\24\1\uffff\1\24\2\uffff\1\24\1\uffff\32\24",
            "\12\24\7\uffff\32\24\1\uffff\1\24\2\uffff\1\24\1\uffff\32\24",
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
            return "1:1: Tokens : ( RULE_HASH | RULE_INCLUDE | RULE_DEFINE | RULE_ERROR | RULE_UNDEF | RULE_IFDEF | RULE_ENDIF | RULE_PRAGMA | RULE_LPAREN | RULE_RPAREN | RULE_COMMA | RULE_NEWLINE | RULE_WS | RULE_ID | RULE_SPECIAL );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_0 = input.LA(1);

                        s = -1;
                        if ( (LA7_0=='#') ) {s = 1;}

                        else if ( (LA7_0=='i') ) {s = 2;}

                        else if ( (LA7_0=='d') ) {s = 3;}

                        else if ( (LA7_0=='e') ) {s = 4;}

                        else if ( (LA7_0=='u') ) {s = 5;}

                        else if ( (LA7_0=='p') ) {s = 6;}

                        else if ( (LA7_0=='(') ) {s = 7;}

                        else if ( (LA7_0==')') ) {s = 8;}

                        else if ( (LA7_0==',') ) {s = 9;}

                        else if ( (LA7_0=='\n'||LA7_0=='\r') ) {s = 10;}

                        else if ( (LA7_0==' ') ) {s = 11;}

                        else if ( (LA7_0=='\t') ) {s = 12;}

                        else if ( (LA7_0=='/') ) {s = 13;}

                        else if ( (LA7_0=='\\') ) {s = 14;}

                        else if ( ((LA7_0>='A' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='c')||(LA7_0>='f' && LA7_0<='h')||(LA7_0>='j' && LA7_0<='o')||(LA7_0>='q' && LA7_0<='t')||(LA7_0>='v' && LA7_0<='z')) ) {s = 15;}

                        else if ( ((LA7_0>='\u0000' && LA7_0<='\b')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\u001F')||(LA7_0>='!' && LA7_0<='\"')||(LA7_0>='$' && LA7_0<='\'')||(LA7_0>='*' && LA7_0<='+')||(LA7_0>='-' && LA7_0<='.')||(LA7_0>='0' && LA7_0<='@')||LA7_0=='['||(LA7_0>=']' && LA7_0<='^')||LA7_0=='`'||(LA7_0>='{' && LA7_0<='\uFFFF')) ) {s = 16;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}