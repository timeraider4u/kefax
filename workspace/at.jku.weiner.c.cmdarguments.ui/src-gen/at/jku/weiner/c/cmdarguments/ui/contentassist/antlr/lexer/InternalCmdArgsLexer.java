package at.jku.weiner.c.cmdarguments.ui.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalCmdArgsLexer extends Lexer {
    public static final int RULE_SKW_MINUS=4;
    public static final int RULE_ID=18;
    public static final int RULE_NEWLINE=21;
    public static final int RULE_KW_INCDIR=10;
    public static final int RULE_KW_OUTPUT=11;
    public static final int RULE_ANY_OTHER=24;
    public static final int RULE_KW_NOSTDINC=13;
    public static final int EOF=-1;
    public static final int RULE_LETTER=16;
    public static final int RULE_SKW_RIGHTPAREN=7;
    public static final int RULE_KW_INCLUDE=15;
    public static final int RULE_STRING=20;
    public static final int RULE_KW_DEFINE=9;
    public static final int RULE_KW_LANG=12;
    public static final int RULE_LINE_COMMENT=23;
    public static final int RULE_KW_INCSYS=14;
    public static final int RULE_INT=19;
    public static final int RULE_SKW_COMMA=8;
    public static final int RULE_WS=22;
    public static final int RULE_DIGIT=17;
    public static final int RULE_SKW_LEFTPAREN=6;
    public static final int RULE_SKW_ASSIGN=5;

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

    // $ANTLR start "RULE_SKW_MINUS"
    public final void mRULE_SKW_MINUS() throws RecognitionException {
        try {
            int _type = RULE_SKW_MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:21:16: ( '-' )
            // InternalCmdArgsLexer.g:21:18: '-'
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
            // InternalCmdArgsLexer.g:23:17: ( '=' )
            // InternalCmdArgsLexer.g:23:19: '='
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
            // InternalCmdArgsLexer.g:25:20: ( '(' )
            // InternalCmdArgsLexer.g:25:22: '('
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
            // InternalCmdArgsLexer.g:27:21: ( ')' )
            // InternalCmdArgsLexer.g:27:23: ')'
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
            // InternalCmdArgsLexer.g:29:16: ( ',' )
            // InternalCmdArgsLexer.g:29:18: ','
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

    // $ANTLR start "RULE_KW_DEFINE"
    public final void mRULE_KW_DEFINE() throws RecognitionException {
        try {
            int _type = RULE_KW_DEFINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:31:16: ( RULE_SKW_MINUS 'D' )
            // InternalCmdArgsLexer.g:31:18: RULE_SKW_MINUS 'D'
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
            // InternalCmdArgsLexer.g:33:16: ( RULE_SKW_MINUS 'I' )
            // InternalCmdArgsLexer.g:33:18: RULE_SKW_MINUS 'I'
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
            // InternalCmdArgsLexer.g:35:16: ( RULE_SKW_MINUS 'o' )
            // InternalCmdArgsLexer.g:35:18: RULE_SKW_MINUS 'o'
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
            // InternalCmdArgsLexer.g:37:14: ( RULE_SKW_MINUS 'x' )
            // InternalCmdArgsLexer.g:37:16: RULE_SKW_MINUS 'x'
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
            // InternalCmdArgsLexer.g:39:18: ( 'nostdinc' )
            // InternalCmdArgsLexer.g:39:20: 'nostdinc'
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
            // InternalCmdArgsLexer.g:41:16: ( 'isystem' )
            // InternalCmdArgsLexer.g:41:18: 'isystem'
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
            // InternalCmdArgsLexer.g:43:17: ( 'include' )
            // InternalCmdArgsLexer.g:43:19: 'include'
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

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:45:9: ( RULE_LETTER ( RULE_LETTER | RULE_DIGIT )* )
            // InternalCmdArgsLexer.g:45:11: RULE_LETTER ( RULE_LETTER | RULE_DIGIT )*
            {
            mRULE_LETTER(); 
            // InternalCmdArgsLexer.g:45:23: ( RULE_LETTER | RULE_DIGIT )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='$'||(LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalCmdArgsLexer.g:
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
            	    break loop1;
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

    // $ANTLR start "RULE_LETTER"
    public final void mRULE_LETTER() throws RecognitionException {
        try {
            // InternalCmdArgsLexer.g:47:22: ( ( '$' | 'A' .. 'Z' | 'a' .. 'z' | '_' ) )
            // InternalCmdArgsLexer.g:47:24: ( '$' | 'A' .. 'Z' | 'a' .. 'z' | '_' )
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

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:49:10: ( ( RULE_DIGIT )+ )
            // InternalCmdArgsLexer.g:49:12: ( RULE_DIGIT )+
            {
            // InternalCmdArgsLexer.g:49:12: ( RULE_DIGIT )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalCmdArgsLexer.g:49:12: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_DIGIT"
    public final void mRULE_DIGIT() throws RecognitionException {
        try {
            // InternalCmdArgsLexer.g:51:21: ( '0' .. '9' )
            // InternalCmdArgsLexer.g:51:23: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_DIGIT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:53:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalCmdArgsLexer.g:53:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalCmdArgsLexer.g:53:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\"') ) {
                alt5=1;
            }
            else if ( (LA5_0=='\'') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalCmdArgsLexer.g:53:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalCmdArgsLexer.g:53:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop3:
                    do {
                        int alt3=3;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0=='\\') ) {
                            alt3=1;
                        }
                        else if ( ((LA3_0>='\u0000' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='\uFFFF')) ) {
                            alt3=2;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalCmdArgsLexer.g:53:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalCmdArgsLexer.g:53:28: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop3;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalCmdArgsLexer.g:53:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalCmdArgsLexer.g:53:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='&')||(LA4_0>='(' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalCmdArgsLexer.g:53:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalCmdArgsLexer.g:53:61: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop4;
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
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_NEWLINE"
    public final void mRULE_NEWLINE() throws RecognitionException {
        try {
            int _type = RULE_NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:55:14: ( ( '\\n' | '\\r' ) )
            // InternalCmdArgsLexer.g:55:16: ( '\\n' | '\\r' )
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
            // InternalCmdArgsLexer.g:57:9: ( ( ' ' | '\\t' ) )
            // InternalCmdArgsLexer.g:57:11: ( ' ' | '\\t' )
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

    // $ANTLR start "RULE_LINE_COMMENT"
    public final void mRULE_LINE_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCmdArgsLexer.g:59:19: ( '//' ( options {greedy=false; } : . )* RULE_NEWLINE )
            // InternalCmdArgsLexer.g:59:21: '//' ( options {greedy=false; } : . )* RULE_NEWLINE
            {
            match("//"); 

            // InternalCmdArgsLexer.g:59:26: ( options {greedy=false; } : . )*
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
            	    // InternalCmdArgsLexer.g:59:54: .
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
            // InternalCmdArgsLexer.g:61:16: ( . )
            // InternalCmdArgsLexer.g:61:18: .
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
        // InternalCmdArgsLexer.g:1:8: ( RULE_SKW_MINUS | RULE_SKW_ASSIGN | RULE_SKW_LEFTPAREN | RULE_SKW_RIGHTPAREN | RULE_SKW_COMMA | RULE_KW_DEFINE | RULE_KW_INCDIR | RULE_KW_OUTPUT | RULE_KW_LANG | RULE_KW_NOSTDINC | RULE_KW_INCSYS | RULE_KW_INCLUDE | RULE_ID | RULE_INT | RULE_STRING | RULE_NEWLINE | RULE_WS | RULE_LINE_COMMENT | RULE_ANY_OTHER )
        int alt7=19;
        alt7 = dfa7.predict(input);
        switch (alt7) {
            case 1 :
                // InternalCmdArgsLexer.g:1:10: RULE_SKW_MINUS
                {
                mRULE_SKW_MINUS(); 

                }
                break;
            case 2 :
                // InternalCmdArgsLexer.g:1:25: RULE_SKW_ASSIGN
                {
                mRULE_SKW_ASSIGN(); 

                }
                break;
            case 3 :
                // InternalCmdArgsLexer.g:1:41: RULE_SKW_LEFTPAREN
                {
                mRULE_SKW_LEFTPAREN(); 

                }
                break;
            case 4 :
                // InternalCmdArgsLexer.g:1:60: RULE_SKW_RIGHTPAREN
                {
                mRULE_SKW_RIGHTPAREN(); 

                }
                break;
            case 5 :
                // InternalCmdArgsLexer.g:1:80: RULE_SKW_COMMA
                {
                mRULE_SKW_COMMA(); 

                }
                break;
            case 6 :
                // InternalCmdArgsLexer.g:1:95: RULE_KW_DEFINE
                {
                mRULE_KW_DEFINE(); 

                }
                break;
            case 7 :
                // InternalCmdArgsLexer.g:1:110: RULE_KW_INCDIR
                {
                mRULE_KW_INCDIR(); 

                }
                break;
            case 8 :
                // InternalCmdArgsLexer.g:1:125: RULE_KW_OUTPUT
                {
                mRULE_KW_OUTPUT(); 

                }
                break;
            case 9 :
                // InternalCmdArgsLexer.g:1:140: RULE_KW_LANG
                {
                mRULE_KW_LANG(); 

                }
                break;
            case 10 :
                // InternalCmdArgsLexer.g:1:153: RULE_KW_NOSTDINC
                {
                mRULE_KW_NOSTDINC(); 

                }
                break;
            case 11 :
                // InternalCmdArgsLexer.g:1:170: RULE_KW_INCSYS
                {
                mRULE_KW_INCSYS(); 

                }
                break;
            case 12 :
                // InternalCmdArgsLexer.g:1:185: RULE_KW_INCLUDE
                {
                mRULE_KW_INCLUDE(); 

                }
                break;
            case 13 :
                // InternalCmdArgsLexer.g:1:201: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 14 :
                // InternalCmdArgsLexer.g:1:209: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 15 :
                // InternalCmdArgsLexer.g:1:218: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 16 :
                // InternalCmdArgsLexer.g:1:230: RULE_NEWLINE
                {
                mRULE_NEWLINE(); 

                }
                break;
            case 17 :
                // InternalCmdArgsLexer.g:1:243: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 18 :
                // InternalCmdArgsLexer.g:1:251: RULE_LINE_COMMENT
                {
                mRULE_LINE_COMMENT(); 

                }
                break;
            case 19 :
                // InternalCmdArgsLexer.g:1:269: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\1\uffff\1\20\4\uffff\2\32\2\uffff\2\17\2\uffff\1\17\12\uffff\1\32\1\uffff\2\32\5\uffff\15\32\1\62\1\63\1\64\3\uffff";
    static final String DFA7_eofS =
        "\65\uffff";
    static final String DFA7_minS =
        "\1\0\1\104\4\uffff\1\157\1\156\2\uffff\2\0\2\uffff\1\57\12\uffff\1\163\1\uffff\1\171\1\143\5\uffff\1\164\1\163\1\154\1\144\1\164\1\165\1\151\1\145\1\144\1\156\1\155\1\145\1\143\3\44\3\uffff";
    static final String DFA7_maxS =
        "\1\uffff\1\170\4\uffff\1\157\1\163\2\uffff\2\uffff\2\uffff\1\57\12\uffff\1\163\1\uffff\1\171\1\143\5\uffff\1\164\1\163\1\154\1\144\1\164\1\165\1\151\1\145\1\144\1\156\1\155\1\145\1\143\3\172\3\uffff";
    static final String DFA7_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\2\uffff\1\15\1\16\2\uffff\1\20\1\21\1\uffff\1\23\1\1\1\11\1\7\1\6\1\10\1\2\1\3\1\4\1\5\1\uffff\1\15\2\uffff\1\16\1\17\1\20\1\21\1\22\20\uffff\1\13\1\14\1\12";
    static final String DFA7_specialS =
        "\1\1\11\uffff\1\0\1\2\51\uffff}>";
    static final String[] DFA7_transitionS = {
            "\11\17\1\15\1\14\2\17\1\14\22\17\1\15\1\17\1\12\1\17\1\10\2\17\1\13\1\3\1\4\2\17\1\5\1\1\1\17\1\16\12\11\3\17\1\2\3\17\32\10\4\17\1\10\1\17\10\10\1\7\4\10\1\6\14\10\uff85\17",
            "\1\23\4\uffff\1\22\45\uffff\1\24\10\uffff\1\21",
            "",
            "",
            "",
            "",
            "\1\31",
            "\1\34\4\uffff\1\33",
            "",
            "",
            "\0\36",
            "\0\36",
            "",
            "",
            "\1\41",
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
            "\1\42",
            "",
            "\1\43",
            "\1\44",
            "",
            "",
            "",
            "",
            "",
            "\1\45",
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
            "\1\32\13\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\32\13\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\32\13\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
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
            return "1:1: Tokens : ( RULE_SKW_MINUS | RULE_SKW_ASSIGN | RULE_SKW_LEFTPAREN | RULE_SKW_RIGHTPAREN | RULE_SKW_COMMA | RULE_KW_DEFINE | RULE_KW_INCDIR | RULE_KW_OUTPUT | RULE_KW_LANG | RULE_KW_NOSTDINC | RULE_KW_INCSYS | RULE_KW_INCLUDE | RULE_ID | RULE_INT | RULE_STRING | RULE_NEWLINE | RULE_WS | RULE_LINE_COMMENT | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_10 = input.LA(1);

                        s = -1;
                        if ( ((LA7_10>='\u0000' && LA7_10<='\uFFFF')) ) {s = 30;}

                        else s = 15;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA7_0 = input.LA(1);

                        s = -1;
                        if ( (LA7_0=='-') ) {s = 1;}

                        else if ( (LA7_0=='=') ) {s = 2;}

                        else if ( (LA7_0=='(') ) {s = 3;}

                        else if ( (LA7_0==')') ) {s = 4;}

                        else if ( (LA7_0==',') ) {s = 5;}

                        else if ( (LA7_0=='n') ) {s = 6;}

                        else if ( (LA7_0=='i') ) {s = 7;}

                        else if ( (LA7_0=='$'||(LA7_0>='A' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='h')||(LA7_0>='j' && LA7_0<='m')||(LA7_0>='o' && LA7_0<='z')) ) {s = 8;}

                        else if ( ((LA7_0>='0' && LA7_0<='9')) ) {s = 9;}

                        else if ( (LA7_0=='\"') ) {s = 10;}

                        else if ( (LA7_0=='\'') ) {s = 11;}

                        else if ( (LA7_0=='\n'||LA7_0=='\r') ) {s = 12;}

                        else if ( (LA7_0=='\t'||LA7_0==' ') ) {s = 13;}

                        else if ( (LA7_0=='/') ) {s = 14;}

                        else if ( ((LA7_0>='\u0000' && LA7_0<='\b')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\u001F')||LA7_0=='!'||LA7_0=='#'||(LA7_0>='%' && LA7_0<='&')||(LA7_0>='*' && LA7_0<='+')||LA7_0=='.'||(LA7_0>=':' && LA7_0<='<')||(LA7_0>='>' && LA7_0<='@')||(LA7_0>='[' && LA7_0<='^')||LA7_0=='`'||(LA7_0>='{' && LA7_0<='\uFFFF')) ) {s = 15;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA7_11 = input.LA(1);

                        s = -1;
                        if ( ((LA7_11>='\u0000' && LA7_11<='\uFFFF')) ) {s = 30;}

                        else s = 15;

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