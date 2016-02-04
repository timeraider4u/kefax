package at.jku.weiner.kefax.kbuild.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalKbuildLexer extends Lexer {
    public static final int RULE_DPOINT=9;
    public static final int RULE_SHELL_CHAR=27;
    public static final int RULE_OBJ_Y=19;
    public static final int RULE_QUOTE=33;
    public static final int RULE_OBJ_M=20;
    public static final int RULE_SEMICOLON=10;
    public static final int RULE_STR_ESC=34;
    public static final int RULE_PLUS=22;
    public static final int RULE_IFNDEF=6;
    public static final int RULE_COMMA=14;
    public static final int RULE_TAB=11;
    public static final int RULE_OBJ_START=12;
    public static final int RULE_BRACE_END=17;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=32;
    public static final int RULE_OBJ_FILE=24;
    public static final int RULE_WSS=31;
    public static final int RULE_DOLLAR=28;
    public static final int RULE_IFEQ=4;
    public static final int RULE_IFNEQ=5;
    public static final int RULE_STRING=26;
    public static final int RULE_ENDIF=8;
    public static final int RULE_NLI=30;
    public static final int RULE_M=16;
    public static final int RULE_EQ=21;
    public static final int RULE_Y=15;
    public static final int RULE_INCLUDE=29;
    public static final int RULE_BACKSLASH=23;
    public static final int RULE_SLASH=25;
    public static final int RULE_SYMBOL=7;
    public static final int RULE_ELSE=18;
    public static final int RULE_BRACE_START=13;

    // delegates
    // delegators

    public InternalKbuildLexer() {;} 
    public InternalKbuildLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalKbuildLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalKbuild.g"; }

    // $ANTLR start "RULE_NLI"
    public final void mRULE_NLI() throws RecognitionException {
        try {
            int _type = RULE_NLI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2371:10: ( '\\n' )
            // InternalKbuild.g:2371:12: '\\n'
            {
            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NLI"

    // $ANTLR start "RULE_TAB"
    public final void mRULE_TAB() throws RecognitionException {
        try {
            int _type = RULE_TAB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2373:10: ( '\\t' )
            // InternalKbuild.g:2373:12: '\\t'
            {
            match('\t'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_TAB"

    // $ANTLR start "RULE_WSS"
    public final void mRULE_WSS() throws RecognitionException {
        try {
            int _type = RULE_WSS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2375:10: ( ( ' ' )+ )
            // InternalKbuild.g:2375:12: ( ' ' )+
            {
            // InternalKbuild.g:2375:12: ( ' ' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalKbuild.g:2375:12: ' '
            	    {
            	    match(' '); 

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
    // $ANTLR end "RULE_WSS"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2377:17: ( '#' (~ ( '\\n' ) )* )
            // InternalKbuild.g:2377:19: '#' (~ ( '\\n' ) )*
            {
            match('#'); 
            // InternalKbuild.g:2377:23: (~ ( '\\n' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalKbuild.g:2377:23: ~ ( '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\uFFFF') ) {
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
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_OBJ_START"
    public final void mRULE_OBJ_START() throws RecognitionException {
        try {
            int _type = RULE_OBJ_START;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2379:16: ( 'obj-' )
            // InternalKbuild.g:2379:18: 'obj-'
            {
            match("obj-"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_OBJ_START"

    // $ANTLR start "RULE_OBJ_Y"
    public final void mRULE_OBJ_Y() throws RecognitionException {
        try {
            int _type = RULE_OBJ_Y;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2381:12: ( 'obj-y' )
            // InternalKbuild.g:2381:14: 'obj-y'
            {
            match("obj-y"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_OBJ_Y"

    // $ANTLR start "RULE_OBJ_M"
    public final void mRULE_OBJ_M() throws RecognitionException {
        try {
            int _type = RULE_OBJ_M;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2383:12: ( 'obj-m' )
            // InternalKbuild.g:2383:14: 'obj-m'
            {
            match("obj-m"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_OBJ_M"

    // $ANTLR start "RULE_IFEQ"
    public final void mRULE_IFEQ() throws RecognitionException {
        try {
            int _type = RULE_IFEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2385:11: ( 'ifeq' )
            // InternalKbuild.g:2385:13: 'ifeq'
            {
            match("ifeq"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_IFEQ"

    // $ANTLR start "RULE_IFNEQ"
    public final void mRULE_IFNEQ() throws RecognitionException {
        try {
            int _type = RULE_IFNEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2387:12: ( 'ifneq' )
            // InternalKbuild.g:2387:14: 'ifneq'
            {
            match("ifneq"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_IFNEQ"

    // $ANTLR start "RULE_IFNDEF"
    public final void mRULE_IFNDEF() throws RecognitionException {
        try {
            int _type = RULE_IFNDEF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2389:13: ( 'ifndef' )
            // InternalKbuild.g:2389:15: 'ifndef'
            {
            match("ifndef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_IFNDEF"

    // $ANTLR start "RULE_ELSE"
    public final void mRULE_ELSE() throws RecognitionException {
        try {
            int _type = RULE_ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2391:11: ( 'else' )
            // InternalKbuild.g:2391:13: 'else'
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
            // InternalKbuild.g:2393:12: ( 'endif' )
            // InternalKbuild.g:2393:14: 'endif'
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

    // $ANTLR start "RULE_Y"
    public final void mRULE_Y() throws RecognitionException {
        try {
            int _type = RULE_Y;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2395:8: ( 'y' )
            // InternalKbuild.g:2395:10: 'y'
            {
            match('y'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_Y"

    // $ANTLR start "RULE_M"
    public final void mRULE_M() throws RecognitionException {
        try {
            int _type = RULE_M;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2397:8: ( 'm' )
            // InternalKbuild.g:2397:10: 'm'
            {
            match('m'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_M"

    // $ANTLR start "RULE_OBJ_FILE"
    public final void mRULE_OBJ_FILE() throws RecognitionException {
        try {
            int _type = RULE_OBJ_FILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2399:15: ( '.o' )
            // InternalKbuild.g:2399:17: '.o'
            {
            match(".o"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_OBJ_FILE"

    // $ANTLR start "RULE_INCLUDE"
    public final void mRULE_INCLUDE() throws RecognitionException {
        try {
            int _type = RULE_INCLUDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2401:14: ( 'include' (~ ( RULE_NLI ) )+ )
            // InternalKbuild.g:2401:16: 'include' (~ ( RULE_NLI ) )+
            {
            match("include"); 

            // InternalKbuild.g:2401:26: (~ ( RULE_NLI ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalKbuild.g:2401:26: ~ ( RULE_NLI )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INCLUDE"

    // $ANTLR start "RULE_SYMBOL"
    public final void mRULE_SYMBOL() throws RecognitionException {
        try {
            int _type = RULE_SYMBOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2403:13: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' | '.' | '@' )+ )
            // InternalKbuild.g:2403:15: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' | '.' | '@' )+
            {
            // InternalKbuild.g:2403:15: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' | '.' | '@' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='-' && LA4_0<='.')||(LA4_0>='0' && LA4_0<='9')||(LA4_0>='@' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalKbuild.g:
            	    {
            	    if ( (input.LA(1)>='-' && input.LA(1)<='.')||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='@' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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
    // $ANTLR end "RULE_SYMBOL"

    // $ANTLR start "RULE_SHELL_CHAR"
    public final void mRULE_SHELL_CHAR() throws RecognitionException {
        try {
            int _type = RULE_SHELL_CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2405:17: ( ( '>' | '<' | '|' | '&' ) )
            // InternalKbuild.g:2405:19: ( '>' | '<' | '|' | '&' )
            {
            if ( input.LA(1)=='&'||input.LA(1)=='<'||input.LA(1)=='>'||input.LA(1)=='|' ) {
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
    // $ANTLR end "RULE_SHELL_CHAR"

    // $ANTLR start "RULE_DOLLAR"
    public final void mRULE_DOLLAR() throws RecognitionException {
        try {
            int _type = RULE_DOLLAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2407:13: ( '$' )
            // InternalKbuild.g:2407:15: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DOLLAR"

    // $ANTLR start "RULE_BRACE_START"
    public final void mRULE_BRACE_START() throws RecognitionException {
        try {
            int _type = RULE_BRACE_START;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2409:18: ( '(' )
            // InternalKbuild.g:2409:20: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BRACE_START"

    // $ANTLR start "RULE_BRACE_END"
    public final void mRULE_BRACE_END() throws RecognitionException {
        try {
            int _type = RULE_BRACE_END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2411:16: ( ')' )
            // InternalKbuild.g:2411:18: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BRACE_END"

    // $ANTLR start "RULE_QUOTE"
    public final void mRULE_QUOTE() throws RecognitionException {
        try {
            int _type = RULE_QUOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2413:12: ( '\"' )
            // InternalKbuild.g:2413:14: '\"'
            {
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_QUOTE"

    // $ANTLR start "RULE_PLUS"
    public final void mRULE_PLUS() throws RecognitionException {
        try {
            int _type = RULE_PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2415:11: ( '+' )
            // InternalKbuild.g:2415:13: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_PLUS"

    // $ANTLR start "RULE_DPOINT"
    public final void mRULE_DPOINT() throws RecognitionException {
        try {
            int _type = RULE_DPOINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2417:13: ( ':' )
            // InternalKbuild.g:2417:15: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DPOINT"

    // $ANTLR start "RULE_EQ"
    public final void mRULE_EQ() throws RecognitionException {
        try {
            int _type = RULE_EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2419:9: ( '=' )
            // InternalKbuild.g:2419:11: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EQ"

    // $ANTLR start "RULE_SLASH"
    public final void mRULE_SLASH() throws RecognitionException {
        try {
            int _type = RULE_SLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2421:12: ( '/' )
            // InternalKbuild.g:2421:14: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SLASH"

    // $ANTLR start "RULE_BACKSLASH"
    public final void mRULE_BACKSLASH() throws RecognitionException {
        try {
            int _type = RULE_BACKSLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2423:16: ( '\\\\' )
            // InternalKbuild.g:2423:18: '\\\\'
            {
            match('\\'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BACKSLASH"

    // $ANTLR start "RULE_COMMA"
    public final void mRULE_COMMA() throws RecognitionException {
        try {
            int _type = RULE_COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2425:12: ( ',' )
            // InternalKbuild.g:2425:14: ','
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

    // $ANTLR start "RULE_SEMICOLON"
    public final void mRULE_SEMICOLON() throws RecognitionException {
        try {
            int _type = RULE_SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2427:16: ( ';' )
            // InternalKbuild.g:2427:18: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SEMICOLON"

    // $ANTLR start "RULE_STR_ESC"
    public final void mRULE_STR_ESC() throws RecognitionException {
        try {
            // InternalKbuild.g:2429:23: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\\\' | '$' ) )
            // InternalKbuild.g:2429:25: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\\\' | '$' )
            {
            match('\\'); 
            if ( input.LA(1)=='\"'||input.LA(1)=='$'||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
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
    // $ANTLR end "RULE_STR_ESC"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKbuild.g:2431:13: ( '\"' ( RULE_STR_ESC | ~ ( ( '\"' | '\\r' | '\\n' | '\\\\' ) ) )* '\"' )
            // InternalKbuild.g:2431:15: '\"' ( RULE_STR_ESC | ~ ( ( '\"' | '\\r' | '\\n' | '\\\\' ) ) )* '\"'
            {
            match('\"'); 
            // InternalKbuild.g:2431:19: ( RULE_STR_ESC | ~ ( ( '\"' | '\\r' | '\\n' | '\\\\' ) ) )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\\') ) {
                    alt5=1;
                }
                else if ( ((LA5_0>='\u0000' && LA5_0<='\t')||(LA5_0>='\u000B' && LA5_0<='\f')||(LA5_0>='\u000E' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalKbuild.g:2431:20: RULE_STR_ESC
            	    {
            	    mRULE_STR_ESC(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalKbuild.g:2431:33: ~ ( ( '\"' | '\\r' | '\\n' | '\\\\' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    public void mTokens() throws RecognitionException {
        // InternalKbuild.g:1:8: ( RULE_NLI | RULE_TAB | RULE_WSS | RULE_SL_COMMENT | RULE_OBJ_START | RULE_OBJ_Y | RULE_OBJ_M | RULE_IFEQ | RULE_IFNEQ | RULE_IFNDEF | RULE_ELSE | RULE_ENDIF | RULE_Y | RULE_M | RULE_OBJ_FILE | RULE_INCLUDE | RULE_SYMBOL | RULE_SHELL_CHAR | RULE_DOLLAR | RULE_BRACE_START | RULE_BRACE_END | RULE_QUOTE | RULE_PLUS | RULE_DPOINT | RULE_EQ | RULE_SLASH | RULE_BACKSLASH | RULE_COMMA | RULE_SEMICOLON | RULE_STRING )
        int alt6=30;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // InternalKbuild.g:1:10: RULE_NLI
                {
                mRULE_NLI(); 

                }
                break;
            case 2 :
                // InternalKbuild.g:1:19: RULE_TAB
                {
                mRULE_TAB(); 

                }
                break;
            case 3 :
                // InternalKbuild.g:1:28: RULE_WSS
                {
                mRULE_WSS(); 

                }
                break;
            case 4 :
                // InternalKbuild.g:1:37: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 5 :
                // InternalKbuild.g:1:53: RULE_OBJ_START
                {
                mRULE_OBJ_START(); 

                }
                break;
            case 6 :
                // InternalKbuild.g:1:68: RULE_OBJ_Y
                {
                mRULE_OBJ_Y(); 

                }
                break;
            case 7 :
                // InternalKbuild.g:1:79: RULE_OBJ_M
                {
                mRULE_OBJ_M(); 

                }
                break;
            case 8 :
                // InternalKbuild.g:1:90: RULE_IFEQ
                {
                mRULE_IFEQ(); 

                }
                break;
            case 9 :
                // InternalKbuild.g:1:100: RULE_IFNEQ
                {
                mRULE_IFNEQ(); 

                }
                break;
            case 10 :
                // InternalKbuild.g:1:111: RULE_IFNDEF
                {
                mRULE_IFNDEF(); 

                }
                break;
            case 11 :
                // InternalKbuild.g:1:123: RULE_ELSE
                {
                mRULE_ELSE(); 

                }
                break;
            case 12 :
                // InternalKbuild.g:1:133: RULE_ENDIF
                {
                mRULE_ENDIF(); 

                }
                break;
            case 13 :
                // InternalKbuild.g:1:144: RULE_Y
                {
                mRULE_Y(); 

                }
                break;
            case 14 :
                // InternalKbuild.g:1:151: RULE_M
                {
                mRULE_M(); 

                }
                break;
            case 15 :
                // InternalKbuild.g:1:158: RULE_OBJ_FILE
                {
                mRULE_OBJ_FILE(); 

                }
                break;
            case 16 :
                // InternalKbuild.g:1:172: RULE_INCLUDE
                {
                mRULE_INCLUDE(); 

                }
                break;
            case 17 :
                // InternalKbuild.g:1:185: RULE_SYMBOL
                {
                mRULE_SYMBOL(); 

                }
                break;
            case 18 :
                // InternalKbuild.g:1:197: RULE_SHELL_CHAR
                {
                mRULE_SHELL_CHAR(); 

                }
                break;
            case 19 :
                // InternalKbuild.g:1:213: RULE_DOLLAR
                {
                mRULE_DOLLAR(); 

                }
                break;
            case 20 :
                // InternalKbuild.g:1:225: RULE_BRACE_START
                {
                mRULE_BRACE_START(); 

                }
                break;
            case 21 :
                // InternalKbuild.g:1:242: RULE_BRACE_END
                {
                mRULE_BRACE_END(); 

                }
                break;
            case 22 :
                // InternalKbuild.g:1:257: RULE_QUOTE
                {
                mRULE_QUOTE(); 

                }
                break;
            case 23 :
                // InternalKbuild.g:1:268: RULE_PLUS
                {
                mRULE_PLUS(); 

                }
                break;
            case 24 :
                // InternalKbuild.g:1:278: RULE_DPOINT
                {
                mRULE_DPOINT(); 

                }
                break;
            case 25 :
                // InternalKbuild.g:1:290: RULE_EQ
                {
                mRULE_EQ(); 

                }
                break;
            case 26 :
                // InternalKbuild.g:1:298: RULE_SLASH
                {
                mRULE_SLASH(); 

                }
                break;
            case 27 :
                // InternalKbuild.g:1:309: RULE_BACKSLASH
                {
                mRULE_BACKSLASH(); 

                }
                break;
            case 28 :
                // InternalKbuild.g:1:324: RULE_COMMA
                {
                mRULE_COMMA(); 

                }
                break;
            case 29 :
                // InternalKbuild.g:1:335: RULE_SEMICOLON
                {
                mRULE_SEMICOLON(); 

                }
                break;
            case 30 :
                // InternalKbuild.g:1:350: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\5\uffff\3\13\1\35\1\36\1\13\5\uffff\1\41\7\uffff\5\13\2\uffff\1\50\2\uffff\6\13\1\uffff\1\62\1\63\3\13\1\67\1\13\1\71\1\72\2\uffff\1\73\2\13\1\uffff\1\76\3\uffff\1\77\1\13\2\uffff\1\13\1\102\1\uffff";
    static final String DFA6_eofS =
        "\103\uffff";
    static final String DFA6_minS =
        "\1\11\4\uffff\1\142\1\146\1\154\2\55\1\157\5\uffff\1\0\7\uffff\1\152\1\145\1\143\1\163\1\144\2\uffff\1\55\2\uffff\1\55\1\161\1\144\1\154\1\145\1\151\1\uffff\2\55\1\161\1\145\1\165\1\55\1\146\2\55\2\uffff\1\55\1\146\1\144\1\uffff\1\55\3\uffff\1\55\1\145\2\uffff\1\0\1\55\1\uffff";
    static final String DFA6_maxS =
        "\1\174\4\uffff\1\142\2\156\2\172\1\157\5\uffff\1\uffff\7\uffff\1\152\1\156\1\143\1\163\1\144\2\uffff\1\172\2\uffff\1\55\1\161\1\145\1\154\1\145\1\151\1\uffff\2\172\1\161\1\145\1\165\1\172\1\146\2\172\2\uffff\1\172\1\146\1\144\1\uffff\1\172\3\uffff\1\172\1\145\2\uffff\1\uffff\1\172\1\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\6\uffff\1\21\1\22\1\23\1\24\1\25\1\uffff\1\27\1\30\1\31\1\32\1\33\1\34\1\35\5\uffff\1\15\1\16\1\uffff\1\36\1\26\6\uffff\1\17\11\uffff\1\5\1\10\3\uffff\1\13\1\uffff\1\6\1\7\1\11\2\uffff\1\14\1\12\2\uffff\1\20";
    static final String DFA6_specialS =
        "\20\uffff\1\0\57\uffff\1\1\2\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\2\1\1\25\uffff\1\3\1\uffff\1\20\1\4\1\15\1\uffff\1\14\1\uffff\1\16\1\17\1\uffff\1\21\1\26\1\13\1\12\1\24\12\13\1\22\1\27\1\14\1\23\1\14\1\uffff\33\13\1\uffff\1\25\2\uffff\1\13\1\uffff\4\13\1\7\3\13\1\6\3\13\1\11\1\13\1\5\11\13\1\10\1\13\1\uffff\1\14",
            "",
            "",
            "",
            "",
            "\1\30",
            "\1\31\7\uffff\1\32",
            "\1\33\1\uffff\1\34",
            "\2\13\1\uffff\12\13\6\uffff\33\13\4\uffff\1\13\1\uffff\32\13",
            "\2\13\1\uffff\12\13\6\uffff\33\13\4\uffff\1\13\1\uffff\32\13",
            "\1\37",
            "",
            "",
            "",
            "",
            "",
            "\12\40\1\uffff\2\40\1\uffff\ufff2\40",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\42",
            "\1\43\10\uffff\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "",
            "",
            "\2\13\1\uffff\12\13\6\uffff\33\13\4\uffff\1\13\1\uffff\32\13",
            "",
            "",
            "\1\51",
            "\1\52",
            "\1\54\1\53",
            "\1\55",
            "\1\56",
            "\1\57",
            "",
            "\2\13\1\uffff\12\13\6\uffff\33\13\4\uffff\1\13\1\uffff\14\13\1\61\13\13\1\60\1\13",
            "\2\13\1\uffff\12\13\6\uffff\33\13\4\uffff\1\13\1\uffff\32\13",
            "\1\64",
            "\1\65",
            "\1\66",
            "\2\13\1\uffff\12\13\6\uffff\33\13\4\uffff\1\13\1\uffff\32\13",
            "\1\70",
            "\2\13\1\uffff\12\13\6\uffff\33\13\4\uffff\1\13\1\uffff\32\13",
            "\2\13\1\uffff\12\13\6\uffff\33\13\4\uffff\1\13\1\uffff\32\13",
            "",
            "",
            "\2\13\1\uffff\12\13\6\uffff\33\13\4\uffff\1\13\1\uffff\32\13",
            "\1\74",
            "\1\75",
            "",
            "\2\13\1\uffff\12\13\6\uffff\33\13\4\uffff\1\13\1\uffff\32\13",
            "",
            "",
            "",
            "\2\13\1\uffff\12\13\6\uffff\33\13\4\uffff\1\13\1\uffff\32\13",
            "\1\100",
            "",
            "",
            "\12\102\1\uffff\42\102\2\101\1\102\12\101\6\102\33\101\4\102\1\101\1\102\32\101\uff85\102",
            "\2\101\1\uffff\12\101\6\uffff\33\101\4\uffff\1\101\1\uffff\32\101",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( RULE_NLI | RULE_TAB | RULE_WSS | RULE_SL_COMMENT | RULE_OBJ_START | RULE_OBJ_Y | RULE_OBJ_M | RULE_IFEQ | RULE_IFNEQ | RULE_IFNDEF | RULE_ELSE | RULE_ENDIF | RULE_Y | RULE_M | RULE_OBJ_FILE | RULE_INCLUDE | RULE_SYMBOL | RULE_SHELL_CHAR | RULE_DOLLAR | RULE_BRACE_START | RULE_BRACE_END | RULE_QUOTE | RULE_PLUS | RULE_DPOINT | RULE_EQ | RULE_SLASH | RULE_BACKSLASH | RULE_COMMA | RULE_SEMICOLON | RULE_STRING );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA6_16 = input.LA(1);

                        s = -1;
                        if ( ((LA6_16>='\u0000' && LA6_16<='\t')||(LA6_16>='\u000B' && LA6_16<='\f')||(LA6_16>='\u000E' && LA6_16<='\uFFFF')) ) {s = 32;}

                        else s = 33;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA6_64 = input.LA(1);

                        s = -1;
                        if ( ((LA6_64>='-' && LA6_64<='.')||(LA6_64>='0' && LA6_64<='9')||(LA6_64>='@' && LA6_64<='Z')||LA6_64=='_'||(LA6_64>='a' && LA6_64<='z')) ) {s = 65;}

                        else if ( ((LA6_64>='\u0000' && LA6_64<='\t')||(LA6_64>='\u000B' && LA6_64<=',')||LA6_64=='/'||(LA6_64>=':' && LA6_64<='?')||(LA6_64>='[' && LA6_64<='^')||LA6_64=='`'||(LA6_64>='{' && LA6_64<='\uFFFF')) ) {s = 66;}

                        else s = 11;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 6, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}