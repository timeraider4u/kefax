package at.jku.weiner.xtexttest.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXtextTestLexer extends Lexer {
    public static final int RULE_SRCTEXT=9;
    public static final int RULE_ID=23;
    public static final int RULE_RIGHTPAREN=16;
    public static final int RULE_ASSIGNASDATALIST=19;
    public static final int RULE_ANY_OTHER=28;
    public static final int RULE_LANGUAGE=5;
    public static final int RULE_EXPECTED=21;
    public static final int RULE_FILE=12;
    public static final int RULE_IDENTIFIER=6;
    public static final int RULE_COMMA=15;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=26;
    public static final int RULE_ML_COMMENT=25;
    public static final int RULE_LEFTPAREN=14;
    public static final int RULE_PACKAGE=4;
    public static final int RULE_SOURCE=8;
    public static final int RULE_STRING=11;
    public static final int RULE_ASSIGNASSINGLE=10;
    public static final int RULE_ASSIGNASLIST=17;
    public static final int RULE_LEXER=13;
    public static final int RULE_POINT=7;
    public static final int RULE_OUTPUT=20;
    public static final int RULE_INT=24;
    public static final int RULE_ASSIGNASSTRING=18;
    public static final int RULE_WS=27;
    public static final int RULE_ISSAMEASINPUTFILE=22;

    // delegates
    // delegators

    public InternalXtextTestLexer() {;} 
    public InternalXtextTestLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalXtextTestLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalXtextTest.g"; }

    // $ANTLR start "RULE_PACKAGE"
    public final void mRULE_PACKAGE() throws RecognitionException {
        try {
            int _type = RULE_PACKAGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:998:14: ( 'package' )
            // InternalXtextTest.g:998:16: 'package'
            {
            match("package"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_PACKAGE"

    // $ANTLR start "RULE_LANGUAGE"
    public final void mRULE_LANGUAGE() throws RecognitionException {
        try {
            int _type = RULE_LANGUAGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:1000:15: ( 'language' )
            // InternalXtextTest.g:1000:17: 'language'
            {
            match("language"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LANGUAGE"

    // $ANTLR start "RULE_POINT"
    public final void mRULE_POINT() throws RecognitionException {
        try {
            int _type = RULE_POINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:1002:12: ( '.' )
            // InternalXtextTest.g:1002:14: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_POINT"

    // $ANTLR start "RULE_SOURCE"
    public final void mRULE_SOURCE() throws RecognitionException {
        try {
            int _type = RULE_SOURCE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:1004:13: ( 'source' )
            // InternalXtextTest.g:1004:15: 'source'
            {
            match("source"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SOURCE"

    // $ANTLR start "RULE_SRCTEXT"
    public final void mRULE_SRCTEXT() throws RecognitionException {
        try {
            int _type = RULE_SRCTEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:1006:14: ( 'text' )
            // InternalXtextTest.g:1006:16: 'text'
            {
            match("text"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SRCTEXT"

    // $ANTLR start "RULE_FILE"
    public final void mRULE_FILE() throws RecognitionException {
        try {
            int _type = RULE_FILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:1008:11: ( 'file' )
            // InternalXtextTest.g:1008:13: 'file'
            {
            match("file"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_FILE"

    // $ANTLR start "RULE_LEXER"
    public final void mRULE_LEXER() throws RecognitionException {
        try {
            int _type = RULE_LEXER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:1010:12: ( 'lexer-tokens' )
            // InternalXtextTest.g:1010:14: 'lexer-tokens'
            {
            match("lexer-tokens"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LEXER"

    // $ANTLR start "RULE_OUTPUT"
    public final void mRULE_OUTPUT() throws RecognitionException {
        try {
            int _type = RULE_OUTPUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:1012:13: ( 'output' )
            // InternalXtextTest.g:1012:15: 'output'
            {
            match("output"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_OUTPUT"

    // $ANTLR start "RULE_EXPECTED"
    public final void mRULE_EXPECTED() throws RecognitionException {
        try {
            int _type = RULE_EXPECTED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:1014:15: ( 'expected' )
            // InternalXtextTest.g:1014:17: 'expected'
            {
            match("expected"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EXPECTED"

    // $ANTLR start "RULE_ISSAMEASINPUTFILE"
    public final void mRULE_ISSAMEASINPUTFILE() throws RecognitionException {
        try {
            int _type = RULE_ISSAMEASINPUTFILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:1016:24: ( 'isSameAsInputFile' )
            // InternalXtextTest.g:1016:26: 'isSameAsInputFile'
            {
            match("isSameAsInputFile"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ISSAMEASINPUTFILE"

    // $ANTLR start "RULE_LEFTPAREN"
    public final void mRULE_LEFTPAREN() throws RecognitionException {
        try {
            int _type = RULE_LEFTPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:1018:16: ( '(' )
            // InternalXtextTest.g:1018:18: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LEFTPAREN"

    // $ANTLR start "RULE_RIGHTPAREN"
    public final void mRULE_RIGHTPAREN() throws RecognitionException {
        try {
            int _type = RULE_RIGHTPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:1020:17: ( ')' )
            // InternalXtextTest.g:1020:19: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_RIGHTPAREN"

    // $ANTLR start "RULE_ASSIGNASSINGLE"
    public final void mRULE_ASSIGNASSINGLE() throws RecognitionException {
        try {
            int _type = RULE_ASSIGNASSINGLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:1022:21: ( '=' )
            // InternalXtextTest.g:1022:23: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ASSIGNASSINGLE"

    // $ANTLR start "RULE_ASSIGNASLIST"
    public final void mRULE_ASSIGNASLIST() throws RecognitionException {
        try {
            int _type = RULE_ASSIGNASLIST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:1024:19: ( '+=' )
            // InternalXtextTest.g:1024:21: '+='
            {
            match("+="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ASSIGNASLIST"

    // $ANTLR start "RULE_ASSIGNASSTRING"
    public final void mRULE_ASSIGNASSTRING() throws RecognitionException {
        try {
            int _type = RULE_ASSIGNASSTRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:1026:21: ( '++' )
            // InternalXtextTest.g:1026:23: '++'
            {
            match("++"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ASSIGNASSTRING"

    // $ANTLR start "RULE_ASSIGNASDATALIST"
    public final void mRULE_ASSIGNASDATALIST() throws RecognitionException {
        try {
            int _type = RULE_ASSIGNASDATALIST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:1028:23: ( '+*' )
            // InternalXtextTest.g:1028:25: '+*'
            {
            match("+*"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ASSIGNASDATALIST"

    // $ANTLR start "RULE_COMMA"
    public final void mRULE_COMMA() throws RecognitionException {
        try {
            int _type = RULE_COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:1030:12: ( ',' )
            // InternalXtextTest.g:1030:14: ','
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

    // $ANTLR start "RULE_IDENTIFIER"
    public final void mRULE_IDENTIFIER() throws RecognitionException {
        try {
            int _type = RULE_IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:1032:17: ( RULE_ID )
            // InternalXtextTest.g:1032:19: RULE_ID
            {
            mRULE_ID(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_IDENTIFIER"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            // InternalXtextTest.g:1034:18: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalXtextTest.g:1034:20: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalXtextTest.g:1034:20: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalXtextTest.g:1034:20: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalXtextTest.g:1034:49: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalXtextTest.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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

        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:1036:10: ( ( '0' .. '9' )+ )
            // InternalXtextTest.g:1036:12: ( '0' .. '9' )+
            {
            // InternalXtextTest.g:1036:12: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalXtextTest.g:1036:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:1038:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalXtextTest.g:1038:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalXtextTest.g:1038:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\"') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalXtextTest.g:1038:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalXtextTest.g:1038:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalXtextTest.g:1038:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalXtextTest.g:1038:28: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop4;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalXtextTest.g:1038:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalXtextTest.g:1038:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalXtextTest.g:1038:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalXtextTest.g:1038:61: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop5;
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

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:1040:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalXtextTest.g:1040:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalXtextTest.g:1040:24: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFF')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalXtextTest.g:1040:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:1042:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalXtextTest.g:1042:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalXtextTest.g:1042:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalXtextTest.g:1042:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop8;
                }
            } while (true);

            // InternalXtextTest.g:1042:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalXtextTest.g:1042:41: ( '\\r' )? '\\n'
                    {
                    // InternalXtextTest.g:1042:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalXtextTest.g:1042:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

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
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:1044:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalXtextTest.g:1044:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalXtextTest.g:1044:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalXtextTest.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:1046:16: ( . )
            // InternalXtextTest.g:1046:18: .
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
        // InternalXtextTest.g:1:8: ( RULE_PACKAGE | RULE_LANGUAGE | RULE_POINT | RULE_SOURCE | RULE_SRCTEXT | RULE_FILE | RULE_LEXER | RULE_OUTPUT | RULE_EXPECTED | RULE_ISSAMEASINPUTFILE | RULE_LEFTPAREN | RULE_RIGHTPAREN | RULE_ASSIGNASSINGLE | RULE_ASSIGNASLIST | RULE_ASSIGNASSTRING | RULE_ASSIGNASDATALIST | RULE_COMMA | RULE_IDENTIFIER | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=24;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // InternalXtextTest.g:1:10: RULE_PACKAGE
                {
                mRULE_PACKAGE(); 

                }
                break;
            case 2 :
                // InternalXtextTest.g:1:23: RULE_LANGUAGE
                {
                mRULE_LANGUAGE(); 

                }
                break;
            case 3 :
                // InternalXtextTest.g:1:37: RULE_POINT
                {
                mRULE_POINT(); 

                }
                break;
            case 4 :
                // InternalXtextTest.g:1:48: RULE_SOURCE
                {
                mRULE_SOURCE(); 

                }
                break;
            case 5 :
                // InternalXtextTest.g:1:60: RULE_SRCTEXT
                {
                mRULE_SRCTEXT(); 

                }
                break;
            case 6 :
                // InternalXtextTest.g:1:73: RULE_FILE
                {
                mRULE_FILE(); 

                }
                break;
            case 7 :
                // InternalXtextTest.g:1:83: RULE_LEXER
                {
                mRULE_LEXER(); 

                }
                break;
            case 8 :
                // InternalXtextTest.g:1:94: RULE_OUTPUT
                {
                mRULE_OUTPUT(); 

                }
                break;
            case 9 :
                // InternalXtextTest.g:1:106: RULE_EXPECTED
                {
                mRULE_EXPECTED(); 

                }
                break;
            case 10 :
                // InternalXtextTest.g:1:120: RULE_ISSAMEASINPUTFILE
                {
                mRULE_ISSAMEASINPUTFILE(); 

                }
                break;
            case 11 :
                // InternalXtextTest.g:1:143: RULE_LEFTPAREN
                {
                mRULE_LEFTPAREN(); 

                }
                break;
            case 12 :
                // InternalXtextTest.g:1:158: RULE_RIGHTPAREN
                {
                mRULE_RIGHTPAREN(); 

                }
                break;
            case 13 :
                // InternalXtextTest.g:1:174: RULE_ASSIGNASSINGLE
                {
                mRULE_ASSIGNASSINGLE(); 

                }
                break;
            case 14 :
                // InternalXtextTest.g:1:194: RULE_ASSIGNASLIST
                {
                mRULE_ASSIGNASLIST(); 

                }
                break;
            case 15 :
                // InternalXtextTest.g:1:212: RULE_ASSIGNASSTRING
                {
                mRULE_ASSIGNASSTRING(); 

                }
                break;
            case 16 :
                // InternalXtextTest.g:1:232: RULE_ASSIGNASDATALIST
                {
                mRULE_ASSIGNASDATALIST(); 

                }
                break;
            case 17 :
                // InternalXtextTest.g:1:254: RULE_COMMA
                {
                mRULE_COMMA(); 

                }
                break;
            case 18 :
                // InternalXtextTest.g:1:265: RULE_IDENTIFIER
                {
                mRULE_IDENTIFIER(); 

                }
                break;
            case 19 :
                // InternalXtextTest.g:1:281: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 20 :
                // InternalXtextTest.g:1:290: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 21 :
                // InternalXtextTest.g:1:302: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 22 :
                // InternalXtextTest.g:1:318: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 23 :
                // InternalXtextTest.g:1:334: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 24 :
                // InternalXtextTest.g:1:342: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\2\30\1\uffff\6\30\3\uffff\1\26\1\uffff\1\26\2\uffff\3\26\2\uffff\1\30\1\uffff\2\30\1\uffff\6\30\14\uffff\15\30\1\104\1\105\7\30\2\uffff\5\30\1\uffff\1\122\1\123\2\30\1\126\1\30\2\uffff\2\30\1\uffff\1\132\1\133\1\30\2\uffff\10\30\1\145\1\uffff";
    static final String DFA12_eofS =
        "\146\uffff";
    static final String DFA12_minS =
        "\1\0\2\141\1\uffff\1\157\1\145\1\151\1\165\1\170\1\163\3\uffff\1\52\1\uffff\1\101\2\uffff\2\0\1\52\2\uffff\1\143\1\uffff\1\156\1\170\1\uffff\1\165\1\170\1\154\1\164\1\160\1\123\14\uffff\1\153\1\147\1\145\1\162\1\164\1\145\1\160\1\145\2\141\1\165\1\162\1\143\2\60\1\165\1\143\1\155\1\147\1\141\1\55\1\145\2\uffff\2\164\2\145\1\147\1\uffff\2\60\1\145\1\101\1\60\1\145\2\uffff\1\144\1\163\1\uffff\2\60\1\111\2\uffff\1\156\1\160\1\165\1\164\1\106\1\151\1\154\1\145\1\60\1\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\141\1\145\1\uffff\1\157\1\145\1\151\1\165\1\170\1\163\3\uffff\1\75\1\uffff\1\172\2\uffff\2\uffff\1\57\2\uffff\1\143\1\uffff\1\156\1\170\1\uffff\1\165\1\170\1\154\1\164\1\160\1\123\14\uffff\1\153\1\147\1\145\1\162\1\164\1\145\1\160\1\145\2\141\1\165\1\162\1\143\2\172\1\165\1\143\1\155\1\147\1\141\1\55\1\145\2\uffff\2\164\2\145\1\147\1\uffff\2\172\1\145\1\101\1\172\1\145\2\uffff\1\144\1\163\1\uffff\2\172\1\111\2\uffff\1\156\1\160\1\165\1\164\1\106\1\151\1\154\1\145\1\172\1\uffff";
    static final String DFA12_acceptS =
        "\3\uffff\1\3\6\uffff\1\13\1\14\1\15\1\uffff\1\21\1\uffff\1\22\1\23\3\uffff\1\27\1\30\1\uffff\1\22\2\uffff\1\3\6\uffff\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\23\1\24\1\25\1\26\1\27\26\uffff\1\5\1\6\5\uffff\1\7\6\uffff\1\4\1\10\2\uffff\1\1\3\uffff\1\2\1\11\11\uffff\1\12";
    static final String DFA12_specialS =
        "\1\0\21\uffff\1\2\1\1\122\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\26\2\25\2\26\1\25\22\26\1\25\1\26\1\22\4\26\1\23\1\12\1\13\1\26\1\15\1\16\1\26\1\3\1\24\12\21\3\26\1\14\3\26\32\20\3\26\1\17\1\20\1\26\4\20\1\10\1\6\2\20\1\11\2\20\1\2\2\20\1\7\1\1\2\20\1\4\1\5\6\20\uff85\26",
            "\1\27",
            "\1\31\3\uffff\1\32",
            "",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\40",
            "\1\41",
            "",
            "",
            "",
            "\1\47\1\46\21\uffff\1\45",
            "",
            "\32\30\4\uffff\1\30\1\uffff\32\30",
            "",
            "",
            "\0\52",
            "\0\52",
            "\1\53\4\uffff\1\54",
            "",
            "",
            "\1\56",
            "",
            "\1\57",
            "\1\60",
            "",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
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
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "",
            "",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\124",
            "\1\125",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\127",
            "",
            "",
            "\1\130",
            "\1\131",
            "",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\134",
            "",
            "",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( RULE_PACKAGE | RULE_LANGUAGE | RULE_POINT | RULE_SOURCE | RULE_SRCTEXT | RULE_FILE | RULE_LEXER | RULE_OUTPUT | RULE_EXPECTED | RULE_ISSAMEASINPUTFILE | RULE_LEFTPAREN | RULE_RIGHTPAREN | RULE_ASSIGNASSINGLE | RULE_ASSIGNASLIST | RULE_ASSIGNASSTRING | RULE_ASSIGNASDATALIST | RULE_COMMA | RULE_IDENTIFIER | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='p') ) {s = 1;}

                        else if ( (LA12_0=='l') ) {s = 2;}

                        else if ( (LA12_0=='.') ) {s = 3;}

                        else if ( (LA12_0=='s') ) {s = 4;}

                        else if ( (LA12_0=='t') ) {s = 5;}

                        else if ( (LA12_0=='f') ) {s = 6;}

                        else if ( (LA12_0=='o') ) {s = 7;}

                        else if ( (LA12_0=='e') ) {s = 8;}

                        else if ( (LA12_0=='i') ) {s = 9;}

                        else if ( (LA12_0=='(') ) {s = 10;}

                        else if ( (LA12_0==')') ) {s = 11;}

                        else if ( (LA12_0=='=') ) {s = 12;}

                        else if ( (LA12_0=='+') ) {s = 13;}

                        else if ( (LA12_0==',') ) {s = 14;}

                        else if ( (LA12_0=='^') ) {s = 15;}

                        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='d')||(LA12_0>='g' && LA12_0<='h')||(LA12_0>='j' && LA12_0<='k')||(LA12_0>='m' && LA12_0<='n')||(LA12_0>='q' && LA12_0<='r')||(LA12_0>='u' && LA12_0<='z')) ) {s = 16;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 17;}

                        else if ( (LA12_0=='\"') ) {s = 18;}

                        else if ( (LA12_0=='\'') ) {s = 19;}

                        else if ( (LA12_0=='/') ) {s = 20;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 21;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||LA12_0=='*'||LA12_0=='-'||(LA12_0>=':' && LA12_0<='<')||(LA12_0>='>' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFF')) ) {s = 22;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_19 = input.LA(1);

                        s = -1;
                        if ( ((LA12_19>='\u0000' && LA12_19<='\uFFFF')) ) {s = 42;}

                        else s = 22;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_18 = input.LA(1);

                        s = -1;
                        if ( ((LA12_18>='\u0000' && LA12_18<='\uFFFF')) ) {s = 42;}

                        else s = 22;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}