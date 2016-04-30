package at.jku.weiner.c.preprocess.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalPreprocessLexer extends Lexer {
    public static final int RULE_PRAGMA=23;
    public static final int RULE_ID=24;
    public static final int RULE_SKW_DOT=52;
    public static final int RULE_SKW_GREATEREQUAL=40;
    public static final int RULE_SKW_PLUS=43;
    public static final int EOF=-1;
    public static final int RULE_SKW_LESS=37;
    public static final int RULE_SKW_RIGHTPAREN=11;
    public static final int RULE_ENDIF=17;
    public static final int RULE_LINEBREAK=79;
    public static final int RULE_SKW_LESSEQUAL=39;
    public static final int RULE_UNSIGNED_SUFFIX=80;
    public static final int RULE_DECIMAL_LITERAL=64;
    public static final int RULE_HEX_LITERAL=62;
    public static final int RULE_SKW_AND=34;
    public static final int RULE_WARNING=15;
    public static final int RULE_WHITESPACE=5;
    public static final int RULE_OCTAL_LITERAL=63;
    public static final int RULE_SKW_COMMA=12;
    public static final int SUPER_NEWLINE=74;
    public static final int RULE_SKW_COLON=29;
    public static final int RULE_BLOCK_COMMENT=92;
    public static final int RULE_BIN_LITERAL=68;
    public static final int RULE_SKW_LEFTPAREN=10;
    public static final int RULE_SKW_MINUS=44;
    public static final int RULE_IFDEF=19;
    public static final int RULE_SKW_EQUAL=35;
    public static final int RULE_SKW_DIV=46;
    public static final int RULE_SKW_ANDAND=31;
    public static final int RULE_HEX_DIGIT=71;
    public static final int RULE_SKW_GREATER=38;
    public static final int RULE_HASH=6;
    public static final int RULE_HEX_ESCAPE=86;
    public static final int RULE_SKW_LEFTBRACKET=55;
    public static final int RULE_TAB=91;
    public static final int RULE_LETTER=77;
    public static final int RULE_EXPONENT=83;
    public static final int RULE_DEFINE=9;
    public static final int RULE_SPECIAL=25;
    public static final int RULE_INCLUDE=7;
    public static final int RULE_SKW_UNDERSCORE=69;
    public static final int RULE_ELIF=21;
    public static final int RULE_LINE_END=89;
    public static final int RULE_IF=18;
    public static final int RULE_HEX_PREFIX=70;
    public static final int RULE_IGNORED=95;
    public static final int RULE_OCTAL_ESCAPE=85;
    public static final int RULE_SKW_NOT=49;
    public static final int RULE_SKW_RIGHTSHIFT=42;
    public static final int RULE_ESCAPE_SEQUENCE=78;
    public static final int RULE_LONG_LONG_SUFFIX=82;
    public static final int RULE_DEFINED=26;
    public static final int RULE_SKW_NOTEQUAL=36;
    public static final int RULE_SKW_RIGHTBRACE=58;
    public static final int RULE_VA_ARGS=27;
    public static final int RULE_FORM_FEED=94;
    public static final int RULE_SKW_STAR=45;
    public static final int RULE_STRING_LITERAL=66;
    public static final int RULE_SKW_DOUBLEQUOTE=53;
    public static final int RULE_SKW_PLUSPLUS=57;
    public static final int RULE_SKW_OROR=30;
    public static final int RULE_SKW_CARET=33;
    public static final int RULE_SKW_RIGHTBRACKET=59;
    public static final int RULE_SPACE=90;
    public static final int RULE_LINE=13;
    public static final int RULE_LINEFEED=87;
    public static final int RULE_INCLUDE_NEXT=8;
    public static final int RULE_SKW_SEMI=60;
    public static final int RULE_NEWLINE=4;
    public static final int RULE_SKW_DOLLAR=75;
    public static final int RULE_SKW_LEFTSHIFT=41;
    public static final int RULE_SKW_QUESTION=28;
    public static final int RULE_ERROR=14;
    public static final int RULE_IDENTIFIER=76;
    public static final int RULE_PP_NUMBER=73;
    public static final int RULE_SKW_SINGLEQUOTE=61;
    public static final int RULE_UNDEF=16;
    public static final int RULE_SKW_MOD=47;
    public static final int RULE_SKW_MINUSMINUS=56;
    public static final int RULE_IFNOTDEF=20;
    public static final int RULE_FLOAT_TYPE_SUFFIX=84;
    public static final int RULE_INTEGER_TYPE_SUFFIX=72;
    public static final int RULE_CARRIAGERETURN=88;
    public static final int RULE_SKW_TILDE=48;
    public static final int RULE_LINE_COMMENT=93;
    public static final int RULE_SKW_OR=32;
    public static final int RULE_SKW_BACKSLASH=51;
    public static final int RULE_CHAR_LITERAL=65;
    public static final int RULE_FLOAT_LITERAL=67;
    public static final int RULE_SKW_LEFTBRACE=54;
    public static final int RULE_ELSE=22;
    public static final int RULE_LONG_SUFFIX=81;
    public static final int RULE_SKW_ASSIGN=50;

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
            // InternalPreprocess.g:5885:11: ( '#' )
            // InternalPreprocess.g:5885:13: '#'
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
            // InternalPreprocess.g:5887:14: ( 'include' )
            // InternalPreprocess.g:5887:16: 'include'
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

    // $ANTLR start "RULE_INCLUDE_NEXT"
    public final void mRULE_INCLUDE_NEXT() throws RecognitionException {
        try {
            int _type = RULE_INCLUDE_NEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5889:19: ( RULE_INCLUDE RULE_SKW_UNDERSCORE 'next' )
            // InternalPreprocess.g:5889:21: RULE_INCLUDE RULE_SKW_UNDERSCORE 'next'
            {
            mRULE_INCLUDE(); 
            mRULE_SKW_UNDERSCORE(); 
            match("next"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INCLUDE_NEXT"

    // $ANTLR start "RULE_DEFINE"
    public final void mRULE_DEFINE() throws RecognitionException {
        try {
            int _type = RULE_DEFINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5891:13: ( 'define' )
            // InternalPreprocess.g:5891:15: 'define'
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

    // $ANTLR start "RULE_LINE"
    public final void mRULE_LINE() throws RecognitionException {
        try {
            int _type = RULE_LINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5893:11: ( 'line' )
            // InternalPreprocess.g:5893:13: 'line'
            {
            match("line"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LINE"

    // $ANTLR start "RULE_ERROR"
    public final void mRULE_ERROR() throws RecognitionException {
        try {
            int _type = RULE_ERROR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5895:12: ( 'error' )
            // InternalPreprocess.g:5895:14: 'error'
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
            // InternalPreprocess.g:5897:14: ( 'warning' )
            // InternalPreprocess.g:5897:16: 'warning'
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
            // InternalPreprocess.g:5899:12: ( 'undef' )
            // InternalPreprocess.g:5899:14: 'undef'
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
            // InternalPreprocess.g:5901:9: ( 'if' )
            // InternalPreprocess.g:5901:11: 'if'
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
            // InternalPreprocess.g:5903:14: ( 'defined' )
            // InternalPreprocess.g:5903:16: 'defined'
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
            // InternalPreprocess.g:5905:12: ( 'ifdef' )
            // InternalPreprocess.g:5905:14: 'ifdef'
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
            // InternalPreprocess.g:5907:15: ( 'ifndef' )
            // InternalPreprocess.g:5907:17: 'ifndef'
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
            // InternalPreprocess.g:5909:11: ( 'elif' )
            // InternalPreprocess.g:5909:13: 'elif'
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
            // InternalPreprocess.g:5911:11: ( 'else' )
            // InternalPreprocess.g:5911:13: 'else'
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
            // InternalPreprocess.g:5913:12: ( 'endif' )
            // InternalPreprocess.g:5913:14: 'endif'
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
            // InternalPreprocess.g:5915:13: ( 'pragma' )
            // InternalPreprocess.g:5915:15: 'pragma'
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

    // $ANTLR start "RULE_VA_ARGS"
    public final void mRULE_VA_ARGS() throws RecognitionException {
        try {
            int _type = RULE_VA_ARGS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5917:14: ( RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'VA_ARGS' RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE )
            // InternalPreprocess.g:5917:16: RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE 'VA_ARGS' RULE_SKW_UNDERSCORE RULE_SKW_UNDERSCORE
            {
            mRULE_SKW_UNDERSCORE(); 
            mRULE_SKW_UNDERSCORE(); 
            match("VA_ARGS"); 

            mRULE_SKW_UNDERSCORE(); 
            mRULE_SKW_UNDERSCORE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_VA_ARGS"

    // $ANTLR start "RULE_HEX_LITERAL"
    public final void mRULE_HEX_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_HEX_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5919:18: ( ( RULE_HEX_PREFIX ( ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )? )? | ( RULE_PP_NUMBER )+ ) )
            // InternalPreprocess.g:5919:20: ( RULE_HEX_PREFIX ( ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )? )? | ( RULE_PP_NUMBER )+ )
            {
            // InternalPreprocess.g:5919:20: ( RULE_HEX_PREFIX ( ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )? )? | ( RULE_PP_NUMBER )+ )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='0') ) {
                switch ( input.LA(2) ) {
                case 'x':
                    {
                    alt5=1;
                    }
                    break;
                case 'X':
                    {
                    alt5=1;
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
                case 'A':
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
                case 'Y':
                case 'Z':
                case 'a':
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
                case 'y':
                case 'z':
                    {
                    alt5=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }

            }
            else if ( ((LA5_0>='1' && LA5_0<='9')) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalPreprocess.g:5919:21: RULE_HEX_PREFIX ( ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )? )?
                    {
                    mRULE_HEX_PREFIX(); 
                    // InternalPreprocess.g:5919:37: ( ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )? )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='F')||(LA3_0>='a' && LA3_0<='f')) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // InternalPreprocess.g:5919:38: ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )?
                            {
                            // InternalPreprocess.g:5919:38: ( RULE_HEX_DIGIT )+
                            int cnt1=0;
                            loop1:
                            do {
                                int alt1=2;
                                int LA1_0 = input.LA(1);

                                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='F')||(LA1_0>='a' && LA1_0<='f')) ) {
                                    alt1=1;
                                }


                                switch (alt1) {
                            	case 1 :
                            	    // InternalPreprocess.g:5919:38: RULE_HEX_DIGIT
                            	    {
                            	    mRULE_HEX_DIGIT(); 

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

                            // InternalPreprocess.g:5919:54: ( RULE_INTEGER_TYPE_SUFFIX )?
                            int alt2=2;
                            int LA2_0 = input.LA(1);

                            if ( (LA2_0=='L'||LA2_0=='U'||LA2_0=='l'||LA2_0=='u') ) {
                                alt2=1;
                            }
                            switch (alt2) {
                                case 1 :
                                    // InternalPreprocess.g:5919:54: RULE_INTEGER_TYPE_SUFFIX
                                    {
                                    mRULE_INTEGER_TYPE_SUFFIX(); 

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:5919:82: ( RULE_PP_NUMBER )+
                    {
                    // InternalPreprocess.g:5919:82: ( RULE_PP_NUMBER )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalPreprocess.g:5919:82: RULE_PP_NUMBER
                    	    {
                    	    mRULE_PP_NUMBER(); 

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

    // $ANTLR start "RULE_PP_NUMBER"
    public final void mRULE_PP_NUMBER() throws RecognitionException {
        try {
            // InternalPreprocess.g:5921:25: ( ( '0' '8' .. '9' ( '0' .. '9' )* | ( '0' .. '9' )+ ( 'a' | 'c' .. 'z' | 'A' | 'C' .. 'Z' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )* ) )
            // InternalPreprocess.g:5921:27: ( '0' '8' .. '9' ( '0' .. '9' )* | ( '0' .. '9' )+ ( 'a' | 'c' .. 'z' | 'A' | 'C' .. 'Z' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )* )
            {
            // InternalPreprocess.g:5921:27: ( '0' '8' .. '9' ( '0' .. '9' )* | ( '0' .. '9' )+ ( 'a' | 'c' .. 'z' | 'A' | 'C' .. 'Z' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )* )
            int alt9=2;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // InternalPreprocess.g:5921:28: '0' '8' .. '9' ( '0' .. '9' )*
                    {
                    match('0'); 
                    matchRange('8','9'); 
                    // InternalPreprocess.g:5921:41: ( '0' .. '9' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalPreprocess.g:5921:42: '0' .. '9'
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
                case 2 :
                    // InternalPreprocess.g:5921:53: ( '0' .. '9' )+ ( 'a' | 'c' .. 'z' | 'A' | 'C' .. 'Z' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )*
                    {
                    // InternalPreprocess.g:5921:53: ( '0' .. '9' )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalPreprocess.g:5921:54: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

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

                    if ( input.LA(1)=='A'||(input.LA(1)>='C' && input.LA(1)<='Z')||input.LA(1)=='a'||(input.LA(1)>='c' && input.LA(1)<='z') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // InternalPreprocess.g:5921:93: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>='0' && LA8_0<='9')||(LA8_0>='A' && LA8_0<='Z')||(LA8_0>='a' && LA8_0<='z')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalPreprocess.g:
                    	    {
                    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_PP_NUMBER"

    // $ANTLR start "RULE_NEWLINE"
    public final void mRULE_NEWLINE() throws RecognitionException {
        try {
            int _type = RULE_NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:5923:14: ( SUPER_NEWLINE )
            // InternalPreprocess.g:5923:16: SUPER_NEWLINE
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
            // InternalPreprocess.g:5925:14: ( '&' )
            // InternalPreprocess.g:5925:16: '&'
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
            // InternalPreprocess.g:5927:17: ( RULE_SKW_AND RULE_SKW_AND )
            // InternalPreprocess.g:5927:19: RULE_SKW_AND RULE_SKW_AND
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
            // InternalPreprocess.g:5929:17: ( '=' )
            // InternalPreprocess.g:5929:19: '='
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
            // InternalPreprocess.g:5931:20: ( '\\\\' )
            // InternalPreprocess.g:5931:22: '\\\\'
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
            // InternalPreprocess.g:5933:16: ( '^' )
            // InternalPreprocess.g:5933:18: '^'
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
            // InternalPreprocess.g:5935:16: ( ',' )
            // InternalPreprocess.g:5935:18: ','
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
            // InternalPreprocess.g:5937:16: ( ':' )
            // InternalPreprocess.g:5937:18: ':'
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
            // InternalPreprocess.g:5939:14: ( '/' )
            // InternalPreprocess.g:5939:16: '/'
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
            // InternalPreprocess.g:5941:26: ( '$' )
            // InternalPreprocess.g:5941:28: '$'
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
            // InternalPreprocess.g:5943:14: ( '.' )
            // InternalPreprocess.g:5943:16: '.'
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
            // InternalPreprocess.g:5945:22: ( '\"' )
            // InternalPreprocess.g:5945:24: '\"'
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
            // InternalPreprocess.g:5947:16: ( RULE_SKW_ASSIGN RULE_SKW_ASSIGN )
            // InternalPreprocess.g:5947:18: RULE_SKW_ASSIGN RULE_SKW_ASSIGN
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
            // InternalPreprocess.g:5949:18: ( '>' )
            // InternalPreprocess.g:5949:20: '>'
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
            // InternalPreprocess.g:5951:23: ( RULE_SKW_GREATER RULE_SKW_ASSIGN )
            // InternalPreprocess.g:5951:25: RULE_SKW_GREATER RULE_SKW_ASSIGN
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
            // InternalPreprocess.g:5953:20: ( '{' )
            // InternalPreprocess.g:5953:22: '{'
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
            // InternalPreprocess.g:5955:22: ( '[' )
            // InternalPreprocess.g:5955:24: '['
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
            // InternalPreprocess.g:5957:20: ( '(' )
            // InternalPreprocess.g:5957:22: '('
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
            // InternalPreprocess.g:5959:20: ( RULE_SKW_LESS RULE_SKW_LESS )
            // InternalPreprocess.g:5959:22: RULE_SKW_LESS RULE_SKW_LESS
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
            // InternalPreprocess.g:5961:15: ( '<' )
            // InternalPreprocess.g:5961:17: '<'
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
            // InternalPreprocess.g:5963:20: ( RULE_SKW_LESS RULE_SKW_ASSIGN )
            // InternalPreprocess.g:5963:22: RULE_SKW_LESS RULE_SKW_ASSIGN
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
            // InternalPreprocess.g:5965:16: ( '-' )
            // InternalPreprocess.g:5965:18: '-'
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
            // InternalPreprocess.g:5967:21: ( RULE_SKW_MINUS RULE_SKW_MINUS )
            // InternalPreprocess.g:5967:23: RULE_SKW_MINUS RULE_SKW_MINUS
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
            // InternalPreprocess.g:5969:14: ( '%' )
            // InternalPreprocess.g:5969:16: '%'
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
            // InternalPreprocess.g:5971:14: ( '!' )
            // InternalPreprocess.g:5971:16: '!'
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
            // InternalPreprocess.g:5973:19: ( RULE_SKW_NOT RULE_SKW_ASSIGN )
            // InternalPreprocess.g:5973:21: RULE_SKW_NOT RULE_SKW_ASSIGN
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
            // InternalPreprocess.g:5975:13: ( '|' )
            // InternalPreprocess.g:5975:15: '|'
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
            // InternalPreprocess.g:5977:15: ( RULE_SKW_OR RULE_SKW_OR )
            // InternalPreprocess.g:5977:17: RULE_SKW_OR RULE_SKW_OR
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
            // InternalPreprocess.g:5979:15: ( '+' )
            // InternalPreprocess.g:5979:17: '+'
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
            // InternalPreprocess.g:5981:19: ( RULE_SKW_PLUS RULE_SKW_PLUS )
            // InternalPreprocess.g:5981:21: RULE_SKW_PLUS RULE_SKW_PLUS
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
            // InternalPreprocess.g:5983:19: ( '?' )
            // InternalPreprocess.g:5983:21: '?'
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
            // InternalPreprocess.g:5985:21: ( '}' )
            // InternalPreprocess.g:5985:23: '}'
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
            // InternalPreprocess.g:5987:23: ( ']' )
            // InternalPreprocess.g:5987:25: ']'
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
            // InternalPreprocess.g:5989:21: ( ')' )
            // InternalPreprocess.g:5989:23: ')'
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
            // InternalPreprocess.g:5991:21: ( RULE_SKW_GREATER RULE_SKW_GREATER )
            // InternalPreprocess.g:5991:23: RULE_SKW_GREATER RULE_SKW_GREATER
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
            // InternalPreprocess.g:5993:15: ( ';' )
            // InternalPreprocess.g:5993:17: ';'
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
            // InternalPreprocess.g:5995:22: ( '\\'' )
            // InternalPreprocess.g:5995:24: '\\''
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
            // InternalPreprocess.g:5997:15: ( '*' )
            // InternalPreprocess.g:5997:17: '*'
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
            // InternalPreprocess.g:5999:16: ( '~' )
            // InternalPreprocess.g:5999:18: '~'
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
            // InternalPreprocess.g:6001:30: ( '_' )
            // InternalPreprocess.g:6001:32: '_'
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
            // InternalPreprocess.g:6003:9: ( RULE_IDENTIFIER )
            // InternalPreprocess.g:6003:11: RULE_IDENTIFIER
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
            // InternalPreprocess.g:6005:26: ( RULE_LETTER ( RULE_LETTER | '0' .. '9' )* )
            // InternalPreprocess.g:6005:28: RULE_LETTER ( RULE_LETTER | '0' .. '9' )*
            {
            mRULE_LETTER(); 
            // InternalPreprocess.g:6005:40: ( RULE_LETTER | '0' .. '9' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='$'||(LA10_0>='0' && LA10_0<='9')||(LA10_0>='A' && LA10_0<='Z')||LA10_0=='_'||(LA10_0>='a' && LA10_0<='z')) ) {
                    alt10=1;
                }


                switch (alt10) {
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
            	    break loop10;
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
            // InternalPreprocess.g:6007:22: ( ( RULE_SKW_DOLLAR | 'A' .. 'Z' | 'a' .. 'z' | RULE_SKW_UNDERSCORE ) )
            // InternalPreprocess.g:6007:24: ( RULE_SKW_DOLLAR | 'A' .. 'Z' | 'a' .. 'z' | RULE_SKW_UNDERSCORE )
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
            // InternalPreprocess.g:6009:19: ( ( 'L' )? RULE_SKW_SINGLEQUOTE ( RULE_ESCAPE_SEQUENCE | ~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) | RULE_LINEBREAK ) RULE_SKW_SINGLEQUOTE )
            // InternalPreprocess.g:6009:21: ( 'L' )? RULE_SKW_SINGLEQUOTE ( RULE_ESCAPE_SEQUENCE | ~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) | RULE_LINEBREAK ) RULE_SKW_SINGLEQUOTE
            {
            // InternalPreprocess.g:6009:21: ( 'L' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='L') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalPreprocess.g:6009:21: 'L'
                    {
                    match('L'); 

                    }
                    break;

            }

            mRULE_SKW_SINGLEQUOTE(); 
            // InternalPreprocess.g:6009:47: ( RULE_ESCAPE_SEQUENCE | ~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) | RULE_LINEBREAK )
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\\') ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1=='\n'||LA12_1=='\r') ) {
                    alt12=3;
                }
                else if ( (LA12_1=='\"'||LA12_1=='\''||(LA12_1>='0' && LA12_1<='7')||LA12_1=='\\'||LA12_1=='b'||LA12_1=='f'||LA12_1=='n'||LA12_1=='r'||LA12_1=='t'||LA12_1=='x') ) {
                    alt12=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA12_0>='\u0000' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='[')||(LA12_0>=']' && LA12_0<='\uFFFF')) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalPreprocess.g:6009:48: RULE_ESCAPE_SEQUENCE
                    {
                    mRULE_ESCAPE_SEQUENCE(); 

                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:6009:69: ~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) )
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
                case 3 :
                    // InternalPreprocess.g:6009:114: RULE_LINEBREAK
                    {
                    mRULE_LINEBREAK(); 

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
            // InternalPreprocess.g:6011:21: ( RULE_SKW_DOUBLEQUOTE ( RULE_ESCAPE_SEQUENCE | ~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) | RULE_LINEBREAK )* RULE_SKW_DOUBLEQUOTE )
            // InternalPreprocess.g:6011:23: RULE_SKW_DOUBLEQUOTE ( RULE_ESCAPE_SEQUENCE | ~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) | RULE_LINEBREAK )* RULE_SKW_DOUBLEQUOTE
            {
            mRULE_SKW_DOUBLEQUOTE(); 
            // InternalPreprocess.g:6011:44: ( RULE_ESCAPE_SEQUENCE | ~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) | RULE_LINEBREAK )*
            loop13:
            do {
                int alt13=4;
                int LA13_0 = input.LA(1);

                if ( (LA13_0=='\\') ) {
                    int LA13_2 = input.LA(2);

                    if ( (LA13_2=='\"'||LA13_2=='\''||(LA13_2>='0' && LA13_2<='7')||LA13_2=='\\'||LA13_2=='b'||LA13_2=='f'||LA13_2=='n'||LA13_2=='r'||LA13_2=='t'||LA13_2=='x') ) {
                        alt13=1;
                    }
                    else if ( (LA13_2=='\n'||LA13_2=='\r') ) {
                        alt13=3;
                    }


                }
                else if ( ((LA13_0>='\u0000' && LA13_0<='!')||(LA13_0>='#' && LA13_0<='[')||(LA13_0>=']' && LA13_0<='\uFFFF')) ) {
                    alt13=2;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalPreprocess.g:6011:45: RULE_ESCAPE_SEQUENCE
            	    {
            	    mRULE_ESCAPE_SEQUENCE(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalPreprocess.g:6011:66: ~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) )
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
            	case 3 :
            	    // InternalPreprocess.g:6011:111: RULE_LINEBREAK
            	    {
            	    mRULE_LINEBREAK(); 

            	    }
            	    break;

            	default :
            	    break loop13;
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

    // $ANTLR start "RULE_HEX_PREFIX"
    public final void mRULE_HEX_PREFIX() throws RecognitionException {
        try {
            // InternalPreprocess.g:6013:26: ( ( '0x' | '0X' ) )
            // InternalPreprocess.g:6013:28: ( '0x' | '0X' )
            {
            // InternalPreprocess.g:6013:28: ( '0x' | '0X' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='0') ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1=='x') ) {
                    alt14=1;
                }
                else if ( (LA14_1=='X') ) {
                    alt14=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalPreprocess.g:6013:29: '0x'
                    {
                    match("0x"); 


                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:6013:34: '0X'
                    {
                    match("0X"); 


                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX_PREFIX"

    // $ANTLR start "RULE_DECIMAL_LITERAL"
    public final void mRULE_DECIMAL_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_DECIMAL_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:6015:22: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( RULE_INTEGER_TYPE_SUFFIX )? )
            // InternalPreprocess.g:6015:24: ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( RULE_INTEGER_TYPE_SUFFIX )?
            {
            // InternalPreprocess.g:6015:24: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='0') ) {
                alt16=1;
            }
            else if ( ((LA16_0>='1' && LA16_0<='9')) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalPreprocess.g:6015:25: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:6015:29: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); 
                    // InternalPreprocess.g:6015:38: ( '0' .. '9' )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>='0' && LA15_0<='9')) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalPreprocess.g:6015:39: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalPreprocess.g:6015:51: ( RULE_INTEGER_TYPE_SUFFIX )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='L'||LA17_0=='U'||LA17_0=='l'||LA17_0=='u') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalPreprocess.g:6015:51: RULE_INTEGER_TYPE_SUFFIX
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
            // InternalPreprocess.g:6017:20: ( '0' ( '0' .. '7' )+ ( RULE_INTEGER_TYPE_SUFFIX )? )
            // InternalPreprocess.g:6017:22: '0' ( '0' .. '7' )+ ( RULE_INTEGER_TYPE_SUFFIX )?
            {
            match('0'); 
            // InternalPreprocess.g:6017:26: ( '0' .. '7' )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>='0' && LA18_0<='7')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalPreprocess.g:6017:27: '0' .. '7'
            	    {
            	    matchRange('0','7'); 

            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);

            // InternalPreprocess.g:6017:38: ( RULE_INTEGER_TYPE_SUFFIX )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='L'||LA19_0=='U'||LA19_0=='l'||LA19_0=='u') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalPreprocess.g:6017:38: RULE_INTEGER_TYPE_SUFFIX
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
            // InternalPreprocess.g:6019:18: ( ( '0b' | '0B' ) ( '0' .. '1' )+ )
            // InternalPreprocess.g:6019:20: ( '0b' | '0B' ) ( '0' .. '1' )+
            {
            // InternalPreprocess.g:6019:20: ( '0b' | '0B' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='0') ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1=='b') ) {
                    alt20=1;
                }
                else if ( (LA20_1=='B') ) {
                    alt20=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalPreprocess.g:6019:21: '0b'
                    {
                    match("0b"); 


                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:6019:26: '0B'
                    {
                    match("0B"); 


                    }
                    break;

            }

            // InternalPreprocess.g:6019:32: ( '0' .. '1' )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>='0' && LA21_0<='1')) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalPreprocess.g:6019:33: '0' .. '1'
            	    {
            	    matchRange('0','1'); 

            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
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
            // InternalPreprocess.g:6021:25: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // InternalPreprocess.g:6021:27: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
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
            // InternalPreprocess.g:6023:35: ( ( RULE_UNSIGNED_SUFFIX ( RULE_LONG_SUFFIX )? | RULE_UNSIGNED_SUFFIX RULE_LONG_LONG_SUFFIX | RULE_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )? | RULE_LONG_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )? ) )
            // InternalPreprocess.g:6023:37: ( RULE_UNSIGNED_SUFFIX ( RULE_LONG_SUFFIX )? | RULE_UNSIGNED_SUFFIX RULE_LONG_LONG_SUFFIX | RULE_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )? | RULE_LONG_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )? )
            {
            // InternalPreprocess.g:6023:37: ( RULE_UNSIGNED_SUFFIX ( RULE_LONG_SUFFIX )? | RULE_UNSIGNED_SUFFIX RULE_LONG_LONG_SUFFIX | RULE_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )? | RULE_LONG_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )? )
            int alt25=4;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // InternalPreprocess.g:6023:38: RULE_UNSIGNED_SUFFIX ( RULE_LONG_SUFFIX )?
                    {
                    mRULE_UNSIGNED_SUFFIX(); 
                    // InternalPreprocess.g:6023:59: ( RULE_LONG_SUFFIX )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0=='L'||LA22_0=='l') ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // InternalPreprocess.g:6023:59: RULE_LONG_SUFFIX
                            {
                            mRULE_LONG_SUFFIX(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:6023:77: RULE_UNSIGNED_SUFFIX RULE_LONG_LONG_SUFFIX
                    {
                    mRULE_UNSIGNED_SUFFIX(); 
                    mRULE_LONG_LONG_SUFFIX(); 

                    }
                    break;
                case 3 :
                    // InternalPreprocess.g:6023:120: RULE_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )?
                    {
                    mRULE_LONG_SUFFIX(); 
                    // InternalPreprocess.g:6023:137: ( RULE_UNSIGNED_SUFFIX )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0=='U'||LA23_0=='u') ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // InternalPreprocess.g:6023:137: RULE_UNSIGNED_SUFFIX
                            {
                            mRULE_UNSIGNED_SUFFIX(); 

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // InternalPreprocess.g:6023:159: RULE_LONG_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )?
                    {
                    mRULE_LONG_LONG_SUFFIX(); 
                    // InternalPreprocess.g:6023:181: ( RULE_UNSIGNED_SUFFIX )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0=='U'||LA24_0=='u') ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // InternalPreprocess.g:6023:181: RULE_UNSIGNED_SUFFIX
                            {
                            mRULE_UNSIGNED_SUFFIX(); 

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

    // $ANTLR start "RULE_UNSIGNED_SUFFIX"
    public final void mRULE_UNSIGNED_SUFFIX() throws RecognitionException {
        try {
            // InternalPreprocess.g:6025:31: ( ( 'u' | 'U' ) )
            // InternalPreprocess.g:6025:33: ( 'u' | 'U' )
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
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
    // $ANTLR end "RULE_UNSIGNED_SUFFIX"

    // $ANTLR start "RULE_LONG_SUFFIX"
    public final void mRULE_LONG_SUFFIX() throws RecognitionException {
        try {
            // InternalPreprocess.g:6027:27: ( ( 'l' | 'L' ) )
            // InternalPreprocess.g:6027:29: ( 'l' | 'L' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
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
    // $ANTLR end "RULE_LONG_SUFFIX"

    // $ANTLR start "RULE_LONG_LONG_SUFFIX"
    public final void mRULE_LONG_LONG_SUFFIX() throws RecognitionException {
        try {
            // InternalPreprocess.g:6029:32: ( ( 'll' | 'LL' ) )
            // InternalPreprocess.g:6029:34: ( 'll' | 'LL' )
            {
            // InternalPreprocess.g:6029:34: ( 'll' | 'LL' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0=='l') ) {
                alt26=1;
            }
            else if ( (LA26_0=='L') ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalPreprocess.g:6029:35: 'll'
                    {
                    match("ll"); 


                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:6029:40: 'LL'
                    {
                    match("LL"); 


                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_LONG_LONG_SUFFIX"

    // $ANTLR start "RULE_FLOAT_LITERAL"
    public final void mRULE_FLOAT_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_FLOAT_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:6031:20: ( ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX ) )
            // InternalPreprocess.g:6031:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )
            {
            // InternalPreprocess.g:6031:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )
            int alt38=4;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1 :
                    // InternalPreprocess.g:6031:23: ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )?
                    {
                    // InternalPreprocess.g:6031:23: ( '0' .. '9' )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( ((LA27_0>='0' && LA27_0<='9')) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalPreprocess.g:6031:24: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt27 >= 1 ) break loop27;
                                EarlyExitException eee =
                                    new EarlyExitException(27, input);
                                throw eee;
                        }
                        cnt27++;
                    } while (true);

                    mRULE_SKW_DOT(); 
                    // InternalPreprocess.g:6031:48: ( '0' .. '9' )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( ((LA28_0>='0' && LA28_0<='9')) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalPreprocess.g:6031:49: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    // InternalPreprocess.g:6031:60: ( RULE_EXPONENT )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0=='E'||LA29_0=='e') ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // InternalPreprocess.g:6031:60: RULE_EXPONENT
                            {
                            mRULE_EXPONENT(); 

                            }
                            break;

                    }

                    // InternalPreprocess.g:6031:75: ( RULE_FLOAT_TYPE_SUFFIX )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0=='D'||LA30_0=='F'||LA30_0=='d'||LA30_0=='f') ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // InternalPreprocess.g:6031:75: RULE_FLOAT_TYPE_SUFFIX
                            {
                            mRULE_FLOAT_TYPE_SUFFIX(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:6031:99: RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )?
                    {
                    mRULE_SKW_DOT(); 
                    // InternalPreprocess.g:6031:112: ( '0' .. '9' )+
                    int cnt31=0;
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( ((LA31_0>='0' && LA31_0<='9')) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalPreprocess.g:6031:113: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt31 >= 1 ) break loop31;
                                EarlyExitException eee =
                                    new EarlyExitException(31, input);
                                throw eee;
                        }
                        cnt31++;
                    } while (true);

                    // InternalPreprocess.g:6031:124: ( RULE_EXPONENT )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0=='E'||LA32_0=='e') ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // InternalPreprocess.g:6031:124: RULE_EXPONENT
                            {
                            mRULE_EXPONENT(); 

                            }
                            break;

                    }

                    // InternalPreprocess.g:6031:139: ( RULE_FLOAT_TYPE_SUFFIX )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0=='D'||LA33_0=='F'||LA33_0=='d'||LA33_0=='f') ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // InternalPreprocess.g:6031:139: RULE_FLOAT_TYPE_SUFFIX
                            {
                            mRULE_FLOAT_TYPE_SUFFIX(); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // InternalPreprocess.g:6031:163: ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )?
                    {
                    // InternalPreprocess.g:6031:163: ( '0' .. '9' )+
                    int cnt34=0;
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( ((LA34_0>='0' && LA34_0<='9')) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // InternalPreprocess.g:6031:164: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt34 >= 1 ) break loop34;
                                EarlyExitException eee =
                                    new EarlyExitException(34, input);
                                throw eee;
                        }
                        cnt34++;
                    } while (true);

                    mRULE_EXPONENT(); 
                    // InternalPreprocess.g:6031:189: ( RULE_FLOAT_TYPE_SUFFIX )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0=='D'||LA35_0=='F'||LA35_0=='d'||LA35_0=='f') ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // InternalPreprocess.g:6031:189: RULE_FLOAT_TYPE_SUFFIX
                            {
                            mRULE_FLOAT_TYPE_SUFFIX(); 

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // InternalPreprocess.g:6031:213: ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX
                    {
                    // InternalPreprocess.g:6031:213: ( '0' .. '9' )+
                    int cnt36=0;
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( ((LA36_0>='0' && LA36_0<='9')) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // InternalPreprocess.g:6031:214: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt36 >= 1 ) break loop36;
                                EarlyExitException eee =
                                    new EarlyExitException(36, input);
                                throw eee;
                        }
                        cnt36++;
                    } while (true);

                    // InternalPreprocess.g:6031:225: ( RULE_EXPONENT )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0=='E'||LA37_0=='e') ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // InternalPreprocess.g:6031:225: RULE_EXPONENT
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
            // InternalPreprocess.g:6033:24: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // InternalPreprocess.g:6033:26: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalPreprocess.g:6033:36: ( '+' | '-' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0=='+'||LA39_0=='-') ) {
                alt39=1;
            }
            switch (alt39) {
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

            // InternalPreprocess.g:6033:47: ( '0' .. '9' )+
            int cnt40=0;
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( ((LA40_0>='0' && LA40_0<='9')) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalPreprocess.g:6033:48: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt40 >= 1 ) break loop40;
                        EarlyExitException eee =
                            new EarlyExitException(40, input);
                        throw eee;
                }
                cnt40++;
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
            // InternalPreprocess.g:6035:33: ( ( 'f' | 'F' | 'd' | 'D' ) )
            // InternalPreprocess.g:6035:35: ( 'f' | 'F' | 'd' | 'D' )
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
            // InternalPreprocess.g:6037:31: ( ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE | RULE_HEX_ESCAPE ) )
            // InternalPreprocess.g:6037:33: ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE | RULE_HEX_ESCAPE )
            {
            // InternalPreprocess.g:6037:33: ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE | RULE_HEX_ESCAPE )
            int alt41=3;
            int LA41_0 = input.LA(1);

            if ( (LA41_0=='\\') ) {
                switch ( input.LA(2) ) {
                case 'x':
                    {
                    alt41=3;
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
                    alt41=1;
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
                    alt41=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalPreprocess.g:6037:34: RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH )
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
                    // InternalPreprocess.g:6037:119: RULE_OCTAL_ESCAPE
                    {
                    mRULE_OCTAL_ESCAPE(); 

                    }
                    break;
                case 3 :
                    // InternalPreprocess.g:6037:137: RULE_HEX_ESCAPE
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
            // InternalPreprocess.g:6039:28: ( ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' ) )
            // InternalPreprocess.g:6039:30: ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' )
            {
            // InternalPreprocess.g:6039:30: ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' )
            int alt42=3;
            int LA42_0 = input.LA(1);

            if ( (LA42_0=='\\') ) {
                int LA42_1 = input.LA(2);

                if ( ((LA42_1>='0' && LA42_1<='3')) ) {
                    int LA42_2 = input.LA(3);

                    if ( ((LA42_2>='0' && LA42_2<='7')) ) {
                        int LA42_4 = input.LA(4);

                        if ( ((LA42_4>='0' && LA42_4<='7')) ) {
                            alt42=1;
                        }
                        else {
                            alt42=2;}
                    }
                    else {
                        alt42=3;}
                }
                else if ( ((LA42_1>='4' && LA42_1<='7')) ) {
                    int LA42_3 = input.LA(3);

                    if ( ((LA42_3>='0' && LA42_3<='7')) ) {
                        alt42=2;
                    }
                    else {
                        alt42=3;}
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // InternalPreprocess.g:6039:31: RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7'
                    {
                    mRULE_SKW_BACKSLASH(); 
                    matchRange('0','3'); 
                    matchRange('0','7'); 
                    matchRange('0','7'); 

                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:6039:77: RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7'
                    {
                    mRULE_SKW_BACKSLASH(); 
                    matchRange('0','7'); 
                    matchRange('0','7'); 

                    }
                    break;
                case 3 :
                    // InternalPreprocess.g:6039:114: RULE_SKW_BACKSLASH '0' .. '7'
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
            // InternalPreprocess.g:6041:26: ( RULE_SKW_BACKSLASH 'x' ( RULE_HEX_DIGIT )+ )
            // InternalPreprocess.g:6041:28: RULE_SKW_BACKSLASH 'x' ( RULE_HEX_DIGIT )+
            {
            mRULE_SKW_BACKSLASH(); 
            match('x'); 
            // InternalPreprocess.g:6041:51: ( RULE_HEX_DIGIT )+
            int cnt43=0;
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( ((LA43_0>='0' && LA43_0<='9')||(LA43_0>='A' && LA43_0<='F')||(LA43_0>='a' && LA43_0<='f')) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalPreprocess.g:6041:51: RULE_HEX_DIGIT
            	    {
            	    mRULE_HEX_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt43 >= 1 ) break loop43;
                        EarlyExitException eee =
                            new EarlyExitException(43, input);
                        throw eee;
                }
                cnt43++;
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
            // InternalPreprocess.g:6043:24: ( '\\n' )
            // InternalPreprocess.g:6043:26: '\\n'
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
            // InternalPreprocess.g:6045:30: ( '\\r' )
            // InternalPreprocess.g:6045:32: '\\r'
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
            // InternalPreprocess.g:6047:24: ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) )
            // InternalPreprocess.g:6047:26: ( RULE_CARRIAGERETURN | RULE_LINEFEED )
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
            // InternalPreprocess.g:6049:25: ( RULE_SKW_BACKSLASH RULE_LINE_END )
            // InternalPreprocess.g:6049:27: RULE_SKW_BACKSLASH RULE_LINE_END
            {
            mRULE_SKW_BACKSLASH(); 
            mRULE_LINE_END(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_LINEBREAK"

    // $ANTLR start "SUPER_NEWLINE"
    public final void mSUPER_NEWLINE() throws RecognitionException {
        try {
            // InternalPreprocess.g:6051:24: ( RULE_LINE_END )
            // InternalPreprocess.g:6051:26: RULE_LINE_END
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
            // InternalPreprocess.g:6053:21: ( ' ' )
            // InternalPreprocess.g:6053:23: ' '
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
            // InternalPreprocess.g:6055:19: ( '\\t' )
            // InternalPreprocess.g:6055:21: '\\t'
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
            // InternalPreprocess.g:6057:17: ( ( RULE_SPACE | RULE_TAB ) )
            // InternalPreprocess.g:6057:19: ( RULE_SPACE | RULE_TAB )
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
            // InternalPreprocess.g:6059:29: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalPreprocess.g:6059:31: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalPreprocess.g:6059:36: ( options {greedy=false; } : . )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0=='*') ) {
                    int LA44_1 = input.LA(2);

                    if ( (LA44_1=='/') ) {
                        alt44=2;
                    }
                    else if ( ((LA44_1>='\u0000' && LA44_1<='.')||(LA44_1>='0' && LA44_1<='\uFFFF')) ) {
                        alt44=1;
                    }


                }
                else if ( ((LA44_0>='\u0000' && LA44_0<=')')||(LA44_0>='+' && LA44_0<='\uFFFF')) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalPreprocess.g:6059:64: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop44;
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
            // InternalPreprocess.g:6061:28: ( '//' (~ ( RULE_LINE_END ) )* )
            // InternalPreprocess.g:6061:30: '//' (~ ( RULE_LINE_END ) )*
            {
            match("//"); 

            // InternalPreprocess.g:6061:35: (~ ( RULE_LINE_END ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( ((LA45_0>='\u0000' && LA45_0<='\t')||(LA45_0>='\u000B' && LA45_0<='\f')||(LA45_0>='\u000E' && LA45_0<='\uFFFF')) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalPreprocess.g:6061:35: ~ ( RULE_LINE_END )
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
            	    break loop45;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_LINE_COMMENT"

    // $ANTLR start "RULE_FORM_FEED"
    public final void mRULE_FORM_FEED() throws RecognitionException {
        try {
            // InternalPreprocess.g:6063:25: ( '\\f' )
            // InternalPreprocess.g:6063:27: '\\f'
            {
            match('\f'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_FORM_FEED"

    // $ANTLR start "RULE_IGNORED"
    public final void mRULE_IGNORED() throws RecognitionException {
        try {
            int _type = RULE_IGNORED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:6065:14: ( ( RULE_LINEBREAK | RULE_BLOCK_COMMENT | RULE_LINE_COMMENT | RULE_FORM_FEED ) )
            // InternalPreprocess.g:6065:16: ( RULE_LINEBREAK | RULE_BLOCK_COMMENT | RULE_LINE_COMMENT | RULE_FORM_FEED )
            {
            // InternalPreprocess.g:6065:16: ( RULE_LINEBREAK | RULE_BLOCK_COMMENT | RULE_LINE_COMMENT | RULE_FORM_FEED )
            int alt46=4;
            switch ( input.LA(1) ) {
            case '\\':
                {
                alt46=1;
                }
                break;
            case '/':
                {
                int LA46_2 = input.LA(2);

                if ( (LA46_2=='*') ) {
                    alt46=2;
                }
                else if ( (LA46_2=='/') ) {
                    alt46=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 2, input);

                    throw nvae;
                }
                }
                break;
            case '\f':
                {
                alt46=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // InternalPreprocess.g:6065:17: RULE_LINEBREAK
                    {
                    mRULE_LINEBREAK(); 

                    }
                    break;
                case 2 :
                    // InternalPreprocess.g:6065:32: RULE_BLOCK_COMMENT
                    {
                    mRULE_BLOCK_COMMENT(); 

                    }
                    break;
                case 3 :
                    // InternalPreprocess.g:6065:51: RULE_LINE_COMMENT
                    {
                    mRULE_LINE_COMMENT(); 

                    }
                    break;
                case 4 :
                    // InternalPreprocess.g:6065:69: RULE_FORM_FEED
                    {
                    mRULE_FORM_FEED(); 

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
    // $ANTLR end "RULE_IGNORED"

    // $ANTLR start "RULE_SPECIAL"
    public final void mRULE_SPECIAL() throws RecognitionException {
        try {
            int _type = RULE_SPECIAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPreprocess.g:6067:14: ( . )
            // InternalPreprocess.g:6067:16: .
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
        // InternalPreprocess.g:1:8: ( RULE_HASH | RULE_INCLUDE | RULE_INCLUDE_NEXT | RULE_DEFINE | RULE_LINE | RULE_ERROR | RULE_WARNING | RULE_UNDEF | RULE_IF | RULE_DEFINED | RULE_IFDEF | RULE_IFNOTDEF | RULE_ELIF | RULE_ELSE | RULE_ENDIF | RULE_PRAGMA | RULE_VA_ARGS | RULE_HEX_LITERAL | RULE_NEWLINE | RULE_SKW_AND | RULE_SKW_ANDAND | RULE_SKW_ASSIGN | RULE_SKW_BACKSLASH | RULE_SKW_CARET | RULE_SKW_COMMA | RULE_SKW_COLON | RULE_SKW_DIV | RULE_SKW_DOT | RULE_SKW_DOUBLEQUOTE | RULE_SKW_EQUAL | RULE_SKW_GREATER | RULE_SKW_GREATEREQUAL | RULE_SKW_LEFTBRACE | RULE_SKW_LEFTBRACKET | RULE_SKW_LEFTPAREN | RULE_SKW_LEFTSHIFT | RULE_SKW_LESS | RULE_SKW_LESSEQUAL | RULE_SKW_MINUS | RULE_SKW_MINUSMINUS | RULE_SKW_MOD | RULE_SKW_NOT | RULE_SKW_NOTEQUAL | RULE_SKW_OR | RULE_SKW_OROR | RULE_SKW_PLUS | RULE_SKW_PLUSPLUS | RULE_SKW_QUESTION | RULE_SKW_RIGHTBRACE | RULE_SKW_RIGHTBRACKET | RULE_SKW_RIGHTPAREN | RULE_SKW_RIGHTSHIFT | RULE_SKW_SEMI | RULE_SKW_SINGLEQUOTE | RULE_SKW_STAR | RULE_SKW_TILDE | RULE_ID | RULE_CHAR_LITERAL | RULE_STRING_LITERAL | RULE_DECIMAL_LITERAL | RULE_OCTAL_LITERAL | RULE_BIN_LITERAL | RULE_FLOAT_LITERAL | RULE_WHITESPACE | RULE_IGNORED | RULE_SPECIAL )
        int alt47=66;
        alt47 = dfa47.predict(input);
        switch (alt47) {
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
                // InternalPreprocess.g:1:33: RULE_INCLUDE_NEXT
                {
                mRULE_INCLUDE_NEXT(); 

                }
                break;
            case 4 :
                // InternalPreprocess.g:1:51: RULE_DEFINE
                {
                mRULE_DEFINE(); 

                }
                break;
            case 5 :
                // InternalPreprocess.g:1:63: RULE_LINE
                {
                mRULE_LINE(); 

                }
                break;
            case 6 :
                // InternalPreprocess.g:1:73: RULE_ERROR
                {
                mRULE_ERROR(); 

                }
                break;
            case 7 :
                // InternalPreprocess.g:1:84: RULE_WARNING
                {
                mRULE_WARNING(); 

                }
                break;
            case 8 :
                // InternalPreprocess.g:1:97: RULE_UNDEF
                {
                mRULE_UNDEF(); 

                }
                break;
            case 9 :
                // InternalPreprocess.g:1:108: RULE_IF
                {
                mRULE_IF(); 

                }
                break;
            case 10 :
                // InternalPreprocess.g:1:116: RULE_DEFINED
                {
                mRULE_DEFINED(); 

                }
                break;
            case 11 :
                // InternalPreprocess.g:1:129: RULE_IFDEF
                {
                mRULE_IFDEF(); 

                }
                break;
            case 12 :
                // InternalPreprocess.g:1:140: RULE_IFNOTDEF
                {
                mRULE_IFNOTDEF(); 

                }
                break;
            case 13 :
                // InternalPreprocess.g:1:154: RULE_ELIF
                {
                mRULE_ELIF(); 

                }
                break;
            case 14 :
                // InternalPreprocess.g:1:164: RULE_ELSE
                {
                mRULE_ELSE(); 

                }
                break;
            case 15 :
                // InternalPreprocess.g:1:174: RULE_ENDIF
                {
                mRULE_ENDIF(); 

                }
                break;
            case 16 :
                // InternalPreprocess.g:1:185: RULE_PRAGMA
                {
                mRULE_PRAGMA(); 

                }
                break;
            case 17 :
                // InternalPreprocess.g:1:197: RULE_VA_ARGS
                {
                mRULE_VA_ARGS(); 

                }
                break;
            case 18 :
                // InternalPreprocess.g:1:210: RULE_HEX_LITERAL
                {
                mRULE_HEX_LITERAL(); 

                }
                break;
            case 19 :
                // InternalPreprocess.g:1:227: RULE_NEWLINE
                {
                mRULE_NEWLINE(); 

                }
                break;
            case 20 :
                // InternalPreprocess.g:1:240: RULE_SKW_AND
                {
                mRULE_SKW_AND(); 

                }
                break;
            case 21 :
                // InternalPreprocess.g:1:253: RULE_SKW_ANDAND
                {
                mRULE_SKW_ANDAND(); 

                }
                break;
            case 22 :
                // InternalPreprocess.g:1:269: RULE_SKW_ASSIGN
                {
                mRULE_SKW_ASSIGN(); 

                }
                break;
            case 23 :
                // InternalPreprocess.g:1:285: RULE_SKW_BACKSLASH
                {
                mRULE_SKW_BACKSLASH(); 

                }
                break;
            case 24 :
                // InternalPreprocess.g:1:304: RULE_SKW_CARET
                {
                mRULE_SKW_CARET(); 

                }
                break;
            case 25 :
                // InternalPreprocess.g:1:319: RULE_SKW_COMMA
                {
                mRULE_SKW_COMMA(); 

                }
                break;
            case 26 :
                // InternalPreprocess.g:1:334: RULE_SKW_COLON
                {
                mRULE_SKW_COLON(); 

                }
                break;
            case 27 :
                // InternalPreprocess.g:1:349: RULE_SKW_DIV
                {
                mRULE_SKW_DIV(); 

                }
                break;
            case 28 :
                // InternalPreprocess.g:1:362: RULE_SKW_DOT
                {
                mRULE_SKW_DOT(); 

                }
                break;
            case 29 :
                // InternalPreprocess.g:1:375: RULE_SKW_DOUBLEQUOTE
                {
                mRULE_SKW_DOUBLEQUOTE(); 

                }
                break;
            case 30 :
                // InternalPreprocess.g:1:396: RULE_SKW_EQUAL
                {
                mRULE_SKW_EQUAL(); 

                }
                break;
            case 31 :
                // InternalPreprocess.g:1:411: RULE_SKW_GREATER
                {
                mRULE_SKW_GREATER(); 

                }
                break;
            case 32 :
                // InternalPreprocess.g:1:428: RULE_SKW_GREATEREQUAL
                {
                mRULE_SKW_GREATEREQUAL(); 

                }
                break;
            case 33 :
                // InternalPreprocess.g:1:450: RULE_SKW_LEFTBRACE
                {
                mRULE_SKW_LEFTBRACE(); 

                }
                break;
            case 34 :
                // InternalPreprocess.g:1:469: RULE_SKW_LEFTBRACKET
                {
                mRULE_SKW_LEFTBRACKET(); 

                }
                break;
            case 35 :
                // InternalPreprocess.g:1:490: RULE_SKW_LEFTPAREN
                {
                mRULE_SKW_LEFTPAREN(); 

                }
                break;
            case 36 :
                // InternalPreprocess.g:1:509: RULE_SKW_LEFTSHIFT
                {
                mRULE_SKW_LEFTSHIFT(); 

                }
                break;
            case 37 :
                // InternalPreprocess.g:1:528: RULE_SKW_LESS
                {
                mRULE_SKW_LESS(); 

                }
                break;
            case 38 :
                // InternalPreprocess.g:1:542: RULE_SKW_LESSEQUAL
                {
                mRULE_SKW_LESSEQUAL(); 

                }
                break;
            case 39 :
                // InternalPreprocess.g:1:561: RULE_SKW_MINUS
                {
                mRULE_SKW_MINUS(); 

                }
                break;
            case 40 :
                // InternalPreprocess.g:1:576: RULE_SKW_MINUSMINUS
                {
                mRULE_SKW_MINUSMINUS(); 

                }
                break;
            case 41 :
                // InternalPreprocess.g:1:596: RULE_SKW_MOD
                {
                mRULE_SKW_MOD(); 

                }
                break;
            case 42 :
                // InternalPreprocess.g:1:609: RULE_SKW_NOT
                {
                mRULE_SKW_NOT(); 

                }
                break;
            case 43 :
                // InternalPreprocess.g:1:622: RULE_SKW_NOTEQUAL
                {
                mRULE_SKW_NOTEQUAL(); 

                }
                break;
            case 44 :
                // InternalPreprocess.g:1:640: RULE_SKW_OR
                {
                mRULE_SKW_OR(); 

                }
                break;
            case 45 :
                // InternalPreprocess.g:1:652: RULE_SKW_OROR
                {
                mRULE_SKW_OROR(); 

                }
                break;
            case 46 :
                // InternalPreprocess.g:1:666: RULE_SKW_PLUS
                {
                mRULE_SKW_PLUS(); 

                }
                break;
            case 47 :
                // InternalPreprocess.g:1:680: RULE_SKW_PLUSPLUS
                {
                mRULE_SKW_PLUSPLUS(); 

                }
                break;
            case 48 :
                // InternalPreprocess.g:1:698: RULE_SKW_QUESTION
                {
                mRULE_SKW_QUESTION(); 

                }
                break;
            case 49 :
                // InternalPreprocess.g:1:716: RULE_SKW_RIGHTBRACE
                {
                mRULE_SKW_RIGHTBRACE(); 

                }
                break;
            case 50 :
                // InternalPreprocess.g:1:736: RULE_SKW_RIGHTBRACKET
                {
                mRULE_SKW_RIGHTBRACKET(); 

                }
                break;
            case 51 :
                // InternalPreprocess.g:1:758: RULE_SKW_RIGHTPAREN
                {
                mRULE_SKW_RIGHTPAREN(); 

                }
                break;
            case 52 :
                // InternalPreprocess.g:1:778: RULE_SKW_RIGHTSHIFT
                {
                mRULE_SKW_RIGHTSHIFT(); 

                }
                break;
            case 53 :
                // InternalPreprocess.g:1:798: RULE_SKW_SEMI
                {
                mRULE_SKW_SEMI(); 

                }
                break;
            case 54 :
                // InternalPreprocess.g:1:812: RULE_SKW_SINGLEQUOTE
                {
                mRULE_SKW_SINGLEQUOTE(); 

                }
                break;
            case 55 :
                // InternalPreprocess.g:1:833: RULE_SKW_STAR
                {
                mRULE_SKW_STAR(); 

                }
                break;
            case 56 :
                // InternalPreprocess.g:1:847: RULE_SKW_TILDE
                {
                mRULE_SKW_TILDE(); 

                }
                break;
            case 57 :
                // InternalPreprocess.g:1:862: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 58 :
                // InternalPreprocess.g:1:870: RULE_CHAR_LITERAL
                {
                mRULE_CHAR_LITERAL(); 

                }
                break;
            case 59 :
                // InternalPreprocess.g:1:888: RULE_STRING_LITERAL
                {
                mRULE_STRING_LITERAL(); 

                }
                break;
            case 60 :
                // InternalPreprocess.g:1:908: RULE_DECIMAL_LITERAL
                {
                mRULE_DECIMAL_LITERAL(); 

                }
                break;
            case 61 :
                // InternalPreprocess.g:1:929: RULE_OCTAL_LITERAL
                {
                mRULE_OCTAL_LITERAL(); 

                }
                break;
            case 62 :
                // InternalPreprocess.g:1:948: RULE_BIN_LITERAL
                {
                mRULE_BIN_LITERAL(); 

                }
                break;
            case 63 :
                // InternalPreprocess.g:1:965: RULE_FLOAT_LITERAL
                {
                mRULE_FLOAT_LITERAL(); 

                }
                break;
            case 64 :
                // InternalPreprocess.g:1:984: RULE_WHITESPACE
                {
                mRULE_WHITESPACE(); 

                }
                break;
            case 65 :
                // InternalPreprocess.g:1:1000: RULE_IGNORED
                {
                mRULE_IGNORED(); 

                }
                break;
            case 66 :
                // InternalPreprocess.g:1:1013: RULE_SPECIAL
                {
                mRULE_SPECIAL(); 

                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA38 dfa38 = new DFA38(this);
    protected DFA47 dfa47 = new DFA47(this);
    static final String DFA9_eotS =
        "\3\uffff\2\5\1\uffff";
    static final String DFA9_eofS =
        "\6\uffff";
    static final String DFA9_minS =
        "\2\60\1\uffff\2\60\1\uffff";
    static final String DFA9_maxS =
        "\1\71\1\172\1\uffff\2\172\1\uffff";
    static final String DFA9_acceptS =
        "\2\uffff\1\2\2\uffff\1\1";
    static final String DFA9_specialS =
        "\6\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\1\11\2",
            "\10\2\2\3\7\uffff\1\2\1\uffff\30\2\6\uffff\1\2\1\uffff\30\2",
            "",
            "\12\4\7\uffff\1\2\1\uffff\30\2\6\uffff\1\2\1\uffff\30\2",
            "\12\4\7\uffff\1\2\1\uffff\30\2\6\uffff\1\2\1\uffff\30\2",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "5921:27: ( '0' '8' .. '9' ( '0' .. '9' )* | ( '0' .. '9' )+ ( 'a' | 'c' .. 'z' | 'A' | 'C' .. 'Z' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )* )";
        }
    }
    static final String DFA25_eotS =
        "\1\uffff\1\4\2\10\1\uffff\2\4\3\uffff";
    static final String DFA25_eofS =
        "\12\uffff";
    static final String DFA25_minS =
        "\2\114\1\154\1\114\1\uffff\1\154\1\114\3\uffff";
    static final String DFA25_maxS =
        "\1\165\2\154\1\114\1\uffff\1\154\1\114\3\uffff";
    static final String DFA25_acceptS =
        "\4\uffff\1\1\2\uffff\1\4\1\3\1\2";
    static final String DFA25_specialS =
        "\12\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\3\10\uffff\1\1\26\uffff\1\2\10\uffff\1\1",
            "\1\6\37\uffff\1\5",
            "\1\7",
            "\1\7",
            "",
            "\1\11",
            "\1\11",
            "",
            "",
            ""
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "6023:37: ( RULE_UNSIGNED_SUFFIX ( RULE_LONG_SUFFIX )? | RULE_UNSIGNED_SUFFIX RULE_LONG_LONG_SUFFIX | RULE_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )? | RULE_LONG_LONG_SUFFIX ( RULE_UNSIGNED_SUFFIX )? )";
        }
    }
    static final String DFA38_eotS =
        "\7\uffff\1\10\2\uffff";
    static final String DFA38_eofS =
        "\12\uffff";
    static final String DFA38_minS =
        "\2\56\1\uffff\1\53\2\uffff\2\60\2\uffff";
    static final String DFA38_maxS =
        "\1\71\1\146\1\uffff\1\71\2\uffff\1\71\1\146\2\uffff";
    static final String DFA38_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\1\1\2\uffff\2\3";
    static final String DFA38_specialS =
        "\12\uffff}>";
    static final String[] DFA38_transitionS = {
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

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "6031:22: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )";
        }
    }
    static final String DFA47_eotS =
        "\2\uffff\10\60\2\100\1\uffff\1\107\1\111\1\113\3\uffff\1\120\1\121\1\122\1\124\3\uffff\1\132\1\135\1\uffff\1\140\1\142\1\144\5\uffff\1\153\2\uffff\1\60\5\uffff\1\60\1\163\1\uffff\11\60\1\uffff\1\72\1\uffff\3\72\1\uffff\1\u0088\1\uffff\1\72\1\uffff\1\100\52\uffff\3\60\1\uffff\12\60\5\72\1\uffff\4\72\2\uffff\2\72\4\60\1\u00a8\1\60\1\u00aa\1\u00ab\5\60\1\72\3\uffff\3\72\1\uffff\2\72\1\uffff\1\60\1\u00b7\2\60\1\uffff\1\u00ba\2\uffff\1\u00bb\1\60\1\u00bd\2\60\3\uffff\2\72\1\60\1\uffff\1\u00c2\1\u00c4\2\uffff\1\60\1\uffff\1\u00c6\1\60\1\72\1\u00c8\1\uffff\1\u00ca\1\uffff\1\u00cb\1\uffff\1\60\1\uffff\1\60\2\uffff\6\60\1\u00d4\1\u00d5\2\uffff";
    static final String DFA47_eofS =
        "\u00d6\uffff";
    static final String DFA47_minS =
        "\1\0\1\uffff\1\146\1\145\1\151\1\154\1\141\1\156\1\162\1\137\2\56\1\uffff\1\46\1\75\1\12\3\uffff\1\52\1\60\1\0\1\75\3\uffff\1\74\1\55\1\uffff\1\75\1\174\1\53\5\uffff\1\0\2\uffff\1\47\5\uffff\1\143\1\44\1\uffff\1\146\1\156\1\162\1\151\1\144\1\162\1\144\1\141\1\126\1\uffff\1\56\1\uffff\1\114\1\125\1\114\1\uffff\1\56\1\uffff\1\53\1\uffff\1\56\52\uffff\1\154\1\145\1\144\1\uffff\1\151\1\145\1\157\1\146\1\145\1\151\1\156\1\145\1\147\1\101\2\56\1\154\1\114\1\125\1\uffff\1\125\1\114\1\125\1\114\1\uffff\1\56\2\60\1\165\1\146\1\145\1\156\1\44\1\162\2\44\1\146\1\151\1\146\1\155\1\137\1\56\3\uffff\1\154\1\114\1\125\1\uffff\1\125\1\60\1\uffff\1\144\1\44\1\146\1\145\1\uffff\1\44\2\uffff\1\44\1\156\1\44\1\141\1\101\3\uffff\2\60\1\145\1\uffff\2\44\2\uffff\1\147\1\uffff\1\44\1\122\1\60\1\44\1\uffff\1\44\1\uffff\1\44\1\uffff\1\107\1\uffff\1\156\2\uffff\1\123\1\145\1\137\1\170\1\137\1\164\2\44\2\uffff";
    static final String DFA47_maxS =
        "\1\uffff\1\uffff\1\156\1\145\1\151\1\162\1\141\1\156\1\162\1\137\2\172\1\uffff\1\46\1\75\1\15\3\uffff\1\57\1\71\1\uffff\1\76\3\uffff\1\75\1\55\1\uffff\1\75\1\174\1\53\5\uffff\1\uffff\2\uffff\1\47\5\uffff\1\143\1\172\1\uffff\1\146\1\156\1\162\1\163\1\144\1\162\1\144\1\141\1\126\1\uffff\1\146\1\uffff\1\154\2\165\1\uffff\1\172\1\uffff\1\71\1\uffff\1\172\52\uffff\1\154\1\145\1\144\1\uffff\1\151\1\145\1\157\1\146\1\145\1\151\1\156\1\145\1\147\1\101\2\146\1\154\1\114\1\165\1\uffff\1\165\1\154\2\165\1\uffff\1\172\2\146\1\165\1\146\1\145\1\156\1\172\1\162\2\172\1\146\1\151\1\146\1\155\1\137\1\146\3\uffff\1\154\1\114\1\165\1\uffff\1\165\1\146\1\uffff\1\144\1\172\1\146\1\145\1\uffff\1\172\2\uffff\1\172\1\156\1\172\1\141\1\101\3\uffff\2\146\1\145\1\uffff\2\172\2\uffff\1\147\1\uffff\1\172\1\122\1\146\1\172\1\uffff\1\172\1\uffff\1\172\1\uffff\1\107\1\uffff\1\156\2\uffff\1\123\1\145\1\137\1\170\1\137\1\164\2\172\2\uffff";
    static final String DFA47_acceptS =
        "\1\uffff\1\1\12\uffff\1\23\3\uffff\1\30\1\31\1\32\4\uffff\1\41\1\42\1\43\2\uffff\1\51\3\uffff\1\60\1\61\1\62\1\63\1\65\1\uffff\1\67\1\70\1\uffff\1\71\1\100\1\101\1\102\1\1\2\uffff\1\71\11\uffff\1\22\1\uffff\1\76\3\uffff\1\74\1\uffff\1\77\1\uffff\1\22\1\uffff\1\23\1\24\1\25\1\26\1\36\1\27\1\101\1\30\1\31\1\32\1\33\1\34\1\35\1\73\1\37\1\40\1\64\1\41\1\42\1\43\1\45\1\46\1\44\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63\1\65\1\66\1\72\1\67\1\70\1\100\3\uffff\1\11\17\uffff\1\22\4\uffff\1\75\21\uffff\3\22\3\uffff\1\22\2\uffff\1\22\4\uffff\1\5\1\uffff\1\15\1\16\5\uffff\3\22\3\uffff\1\13\2\uffff\1\6\1\17\1\uffff\1\10\4\uffff\1\14\1\uffff\1\4\1\uffff\1\20\1\uffff\1\2\1\uffff\1\12\1\7\10\uffff\1\21\1\3";
    static final String DFA47_specialS =
        "\1\2\24\uffff\1\1\17\uffff\1\0\u00b0\uffff}>";
    static final String[] DFA47_transitionS = {
            "\11\54\1\52\1\14\1\54\1\53\1\14\22\54\1\52\1\35\1\25\1\1\1\51\1\34\1\15\1\45\1\31\1\43\1\46\1\37\1\21\1\33\1\24\1\23\1\12\11\13\1\22\1\44\1\32\1\16\1\26\1\40\1\54\13\51\1\50\16\51\1\30\1\17\1\42\1\20\1\11\1\54\3\51\1\3\1\5\3\51\1\2\2\51\1\4\3\51\1\10\4\51\1\7\1\51\1\6\3\51\1\27\1\36\1\41\1\47\uff81\54",
            "",
            "\1\57\7\uffff\1\56",
            "\1\61",
            "\1\62",
            "\1\64\1\uffff\1\65\3\uffff\1\63",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\102\1\uffff\10\101\2\73\7\uffff\1\72\1\74\1\72\1\104\1\103\1\104\5\72\1\77\10\72\1\75\5\72\6\uffff\1\72\1\74\1\72\1\104\1\103\1\104\5\72\1\76\10\72\1\75\5\72",
            "\1\102\1\uffff\12\105\7\uffff\1\72\1\uffff\1\72\1\104\1\103\1\104\5\72\1\77\10\72\1\75\5\72\6\uffff\1\72\1\uffff\1\72\1\104\1\103\1\104\5\72\1\76\10\72\1\75\5\72",
            "",
            "\1\110",
            "\1\112",
            "\1\114\2\uffff\1\114",
            "",
            "",
            "",
            "\1\114\4\uffff\1\114",
            "\12\102",
            "\0\123",
            "\1\125\1\126",
            "",
            "",
            "",
            "\1\134\1\133",
            "\1\136",
            "",
            "\1\141",
            "\1\143",
            "\1\145",
            "",
            "",
            "",
            "",
            "",
            "\47\154\1\uffff\uffd8\154",
            "",
            "",
            "\1\154",
            "",
            "",
            "",
            "",
            "",
            "\1\160",
            "\1\60\13\uffff\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\3\60\1\161\11\60\1\162\14\60",
            "",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167\11\uffff\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "",
            "\1\102\1\uffff\1\176\11\177\12\uffff\1\104\1\103\1\104\35\uffff\1\104\1\103\1\104",
            "",
            "\1\u0081\37\uffff\1\u0080",
            "\1\u0083\26\uffff\1\u0082\10\uffff\1\u0083",
            "\1\u0084\10\uffff\1\u0083\37\uffff\1\u0083",
            "",
            "\1\102\1\uffff\10\101\2\u0089\7\uffff\1\72\1\uffff\1\72\1\104\1\103\1\104\5\72\1\u0087\10\72\1\u0085\5\72\6\uffff\1\72\1\uffff\1\72\1\104\1\103\1\104\5\72\1\u0086\10\72\1\u0085\5\72",
            "",
            "\1\102\1\uffff\1\102\2\uffff\1\u008a\11\u008b",
            "",
            "\1\102\1\uffff\12\105\7\uffff\1\72\1\uffff\1\72\1\104\1\103\1\104\5\72\1\77\10\72\1\75\5\72\6\uffff\1\72\1\uffff\1\72\1\104\1\103\1\104\5\72\1\76\10\72\1\75\5\72",
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
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\102\1\uffff\1\176\7\177\2\u0099\12\uffff\1\104\1\103\1\104\35\uffff\1\104\1\103\1\104",
            "\1\102\1\uffff\1\176\11\177\12\uffff\1\104\1\103\1\104\35\uffff\1\104\1\103\1\104",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c\37\uffff\1\u009c",
            "",
            "\1\u009c\37\uffff\1\u009c",
            "\1\u009e\37\uffff\1\u009d",
            "\1\u00a0\26\uffff\1\u009f\10\uffff\1\u00a0",
            "\1\u00a1\10\uffff\1\u00a0\37\uffff\1\u00a0",
            "",
            "\1\102\1\uffff\12\u0089\7\uffff\1\72\1\uffff\1\72\1\104\1\103\1\104\24\72\6\uffff\1\72\1\uffff\1\72\1\104\1\103\1\104\24\72",
            "\1\u008a\7\u008b\2\u00a2\12\uffff\1\u00a3\1\uffff\1\u00a3\35\uffff\1\u00a3\1\uffff\1\u00a3",
            "\1\u008a\11\u008b\12\uffff\1\u00a3\1\uffff\1\u00a3\35\uffff\1\u00a3\1\uffff\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\60\13\uffff\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00a9",
            "\1\60\13\uffff\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\60\13\uffff\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\102\1\uffff\1\176\11\177\12\uffff\1\104\1\103\1\104\35\uffff\1\104\1\103\1\104",
            "",
            "",
            "",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3\37\uffff\1\u00b3",
            "",
            "\1\u00b3\37\uffff\1\u00b3",
            "\1\u00b4\11\u00b5\12\uffff\1\u00a3\1\uffff\1\u00a3\35\uffff\1\u00a3\1\uffff\1\u00a3",
            "",
            "\1\u00b6",
            "\1\60\13\uffff\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00b8",
            "\1\u00b9",
            "",
            "\1\60\13\uffff\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "",
            "\1\60\13\uffff\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00bc",
            "\1\60\13\uffff\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00be",
            "\1\u00bf",
            "",
            "",
            "",
            "\1\u00b4\7\u00b5\2\u00c0\12\uffff\1\u00a3\1\uffff\1\u00a3\35\uffff\1\u00a3\1\uffff\1\u00a3",
            "\1\u00b4\11\u00b5\12\uffff\1\u00a3\1\uffff\1\u00a3\35\uffff\1\u00a3\1\uffff\1\u00a3",
            "\1\u00c1",
            "",
            "\1\60\13\uffff\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\60\13\uffff\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\3\60\1\u00c3\26\60",
            "",
            "",
            "\1\u00c5",
            "",
            "\1\60\13\uffff\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00c7",
            "\1\u00b4\11\u00b5\12\uffff\1\u00a3\1\uffff\1\u00a3\35\uffff\1\u00a3\1\uffff\1\u00a3",
            "\1\60\13\uffff\12\60\7\uffff\32\60\4\uffff\1\u00c9\1\uffff\32\60",
            "",
            "\1\60\13\uffff\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\1\60\13\uffff\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\1\u00cc",
            "",
            "\1\u00cd",
            "",
            "",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\60\13\uffff\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\60\13\uffff\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            ""
    };

    static final short[] DFA47_eot = DFA.unpackEncodedString(DFA47_eotS);
    static final short[] DFA47_eof = DFA.unpackEncodedString(DFA47_eofS);
    static final char[] DFA47_min = DFA.unpackEncodedStringToUnsignedChars(DFA47_minS);
    static final char[] DFA47_max = DFA.unpackEncodedStringToUnsignedChars(DFA47_maxS);
    static final short[] DFA47_accept = DFA.unpackEncodedString(DFA47_acceptS);
    static final short[] DFA47_special = DFA.unpackEncodedString(DFA47_specialS);
    static final short[][] DFA47_transition;

    static {
        int numStates = DFA47_transitionS.length;
        DFA47_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA47_transition[i] = DFA.unpackEncodedString(DFA47_transitionS[i]);
        }
    }

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = DFA47_eot;
            this.eof = DFA47_eof;
            this.min = DFA47_min;
            this.max = DFA47_max;
            this.accept = DFA47_accept;
            this.special = DFA47_special;
            this.transition = DFA47_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( RULE_HASH | RULE_INCLUDE | RULE_INCLUDE_NEXT | RULE_DEFINE | RULE_LINE | RULE_ERROR | RULE_WARNING | RULE_UNDEF | RULE_IF | RULE_DEFINED | RULE_IFDEF | RULE_IFNOTDEF | RULE_ELIF | RULE_ELSE | RULE_ENDIF | RULE_PRAGMA | RULE_VA_ARGS | RULE_HEX_LITERAL | RULE_NEWLINE | RULE_SKW_AND | RULE_SKW_ANDAND | RULE_SKW_ASSIGN | RULE_SKW_BACKSLASH | RULE_SKW_CARET | RULE_SKW_COMMA | RULE_SKW_COLON | RULE_SKW_DIV | RULE_SKW_DOT | RULE_SKW_DOUBLEQUOTE | RULE_SKW_EQUAL | RULE_SKW_GREATER | RULE_SKW_GREATEREQUAL | RULE_SKW_LEFTBRACE | RULE_SKW_LEFTBRACKET | RULE_SKW_LEFTPAREN | RULE_SKW_LEFTSHIFT | RULE_SKW_LESS | RULE_SKW_LESSEQUAL | RULE_SKW_MINUS | RULE_SKW_MINUSMINUS | RULE_SKW_MOD | RULE_SKW_NOT | RULE_SKW_NOTEQUAL | RULE_SKW_OR | RULE_SKW_OROR | RULE_SKW_PLUS | RULE_SKW_PLUSPLUS | RULE_SKW_QUESTION | RULE_SKW_RIGHTBRACE | RULE_SKW_RIGHTBRACKET | RULE_SKW_RIGHTPAREN | RULE_SKW_RIGHTSHIFT | RULE_SKW_SEMI | RULE_SKW_SINGLEQUOTE | RULE_SKW_STAR | RULE_SKW_TILDE | RULE_ID | RULE_CHAR_LITERAL | RULE_STRING_LITERAL | RULE_DECIMAL_LITERAL | RULE_OCTAL_LITERAL | RULE_BIN_LITERAL | RULE_FLOAT_LITERAL | RULE_WHITESPACE | RULE_IGNORED | RULE_SPECIAL );";
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
                    
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 47, _s, input);
            error(nvae);
            throw nvae;
        }

        private int specialState0(int s, IntStream _input) {
            IntStream input = _input;
            int LA47_37 = input.LA(1);

            s = -1;
            if ( ((LA47_37>='\u0000' && LA47_37<='&')||(LA47_37>='(' && LA47_37<='\uFFFF')) ) {s = 108;}

            else s = 107;

            return s;
        }

        private int specialState1(int s, IntStream _input) {
            IntStream input = _input;
            int LA47_21 = input.LA(1);

            s = -1;
            if ( ((LA47_21>='\u0000' && LA47_21<='\uFFFF')) ) {s = 83;}

            else s = 82;

            return s;
        }

        private int specialState2(int s, IntStream _input) {
            IntStream input = _input;
            int LA47_0 = input.LA(1);

            s = -1;
            if ( (LA47_0=='#') ) {s = 1;}

            else if ( (LA47_0=='i') ) {s = 2;}

            else if ( (LA47_0=='d') ) {s = 3;}

            else if ( (LA47_0=='l') ) {s = 4;}

            else if ( (LA47_0=='e') ) {s = 5;}

            else if ( (LA47_0=='w') ) {s = 6;}

            else if ( (LA47_0=='u') ) {s = 7;}

            else if ( (LA47_0=='p') ) {s = 8;}

            else if ( (LA47_0=='_') ) {s = 9;}

            else if ( (LA47_0=='0') ) {s = 10;}

            else if ( ((LA47_0>='1' && LA47_0<='9')) ) {s = 11;}

            else if ( (LA47_0=='\n'||LA47_0=='\r') ) {s = 12;}

            else if ( (LA47_0=='&') ) {s = 13;}

            else if ( (LA47_0=='=') ) {s = 14;}

            else if ( (LA47_0=='\\') ) {s = 15;}

            else if ( (LA47_0=='^') ) {s = 16;}

            else if ( (LA47_0==',') ) {s = 17;}

            else if ( (LA47_0==':') ) {s = 18;}

            else if ( (LA47_0=='/') ) {s = 19;}

            else if ( (LA47_0=='.') ) {s = 20;}

            else if ( (LA47_0=='\"') ) {s = 21;}

            else if ( (LA47_0=='>') ) {s = 22;}

            else if ( (LA47_0=='{') ) {s = 23;}

            else if ( (LA47_0=='[') ) {s = 24;}

            else if ( (LA47_0=='(') ) {s = 25;}

            else if ( (LA47_0=='<') ) {s = 26;}

            else if ( (LA47_0=='-') ) {s = 27;}

            else if ( (LA47_0=='%') ) {s = 28;}

            else if ( (LA47_0=='!') ) {s = 29;}

            else if ( (LA47_0=='|') ) {s = 30;}

            else if ( (LA47_0=='+') ) {s = 31;}

            else if ( (LA47_0=='?') ) {s = 32;}

            else if ( (LA47_0=='}') ) {s = 33;}

            else if ( (LA47_0==']') ) {s = 34;}

            else if ( (LA47_0==')') ) {s = 35;}

            else if ( (LA47_0==';') ) {s = 36;}

            else if ( (LA47_0=='\'') ) {s = 37;}

            else if ( (LA47_0=='*') ) {s = 38;}

            else if ( (LA47_0=='~') ) {s = 39;}

            else if ( (LA47_0=='L') ) {s = 40;}

            else if ( (LA47_0=='$'||(LA47_0>='A' && LA47_0<='K')||(LA47_0>='M' && LA47_0<='Z')||(LA47_0>='a' && LA47_0<='c')||(LA47_0>='f' && LA47_0<='h')||(LA47_0>='j' && LA47_0<='k')||(LA47_0>='m' && LA47_0<='o')||(LA47_0>='q' && LA47_0<='t')||LA47_0=='v'||(LA47_0>='x' && LA47_0<='z')) ) {s = 41;}

            else if ( (LA47_0=='\t'||LA47_0==' ') ) {s = 42;}

            else if ( (LA47_0=='\f') ) {s = 43;}

            else if ( ((LA47_0>='\u0000' && LA47_0<='\b')||LA47_0=='\u000B'||(LA47_0>='\u000E' && LA47_0<='\u001F')||LA47_0=='@'||LA47_0=='`'||(LA47_0>='\u007F' && LA47_0<='\uFFFF')) ) {s = 44;}

            return s;
        }
    }
 

}