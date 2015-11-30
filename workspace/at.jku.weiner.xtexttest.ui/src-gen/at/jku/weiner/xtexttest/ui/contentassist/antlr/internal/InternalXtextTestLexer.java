package at.jku.weiner.xtexttest.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXtextTestLexer extends Lexer {
    public static final int RULE_SRCTEXT=13;
    public static final int RULE_ID=35;
    public static final int RULE_RIGHTPAREN=18;
    public static final int RULE_METHOD_KW=29;
    public static final int RULE_PATTERNS=25;
    public static final int RULE_ASSIGNASDATALIST=16;
    public static final int RULE_ANY_OTHER=39;
    public static final int RULE_SPLITLEXER=9;
    public static final int RULE_ASSIGNASBOOL=22;
    public static final int RULE_LANGUAGE=8;
    public static final int RULE_ISNULL=33;
    public static final int RULE_EXPECTED=24;
    public static final int RULE_FILE=14;
    public static final int RULE_COMMA=19;
    public static final int RULE_IDENTIFIER=4;
    public static final int RULE_AFTER_KW=30;
    public static final int RULE_SL_COMMENT=37;
    public static final int EOF=-1;
    public static final int RULE_TRUE=5;
    public static final int RULE_BEFORE_KW=27;
    public static final int RULE_ML_COMMENT=36;
    public static final int RULE_LEFTPAREN=17;
    public static final int RULE_SOURCE=12;
    public static final int RULE_PACKAGE=7;
    public static final int RULE_FALSE=6;
    public static final int RULE_STRING=31;
    public static final int RULE_ASSIGNASSINGLE=10;
    public static final int RULE_ASSIGNASLIST=20;
    public static final int RULE_EXCEPTIONS=26;
    public static final int RULE_LEXER=15;
    public static final int RULE_POINT=11;
    public static final int RULE_OUTPUT=23;
    public static final int RULE_INT=32;
    public static final int RULE_CLASS_KW=28;
    public static final int RULE_ASSIGNASSTRING=21;
    public static final int RULE_WS=38;
    public static final int RULE_ISSAMEASINPUTFILE=34;

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
            // InternalXtextTest.g:4764:14: ( 'package' )
            // InternalXtextTest.g:4764:16: 'package'
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
            // InternalXtextTest.g:4766:15: ( 'language' )
            // InternalXtextTest.g:4766:17: 'language'
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
            // InternalXtextTest.g:4768:12: ( '.' )
            // InternalXtextTest.g:4768:14: '.'
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

    // $ANTLR start "RULE_SPLITLEXER"
    public final void mRULE_SPLITLEXER() throws RecognitionException {
        try {
            int _type = RULE_SPLITLEXER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:4770:17: ( 'split-lexer' )
            // InternalXtextTest.g:4770:19: 'split-lexer'
            {
            match("split-lexer"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SPLITLEXER"

    // $ANTLR start "RULE_SOURCE"
    public final void mRULE_SOURCE() throws RecognitionException {
        try {
            int _type = RULE_SOURCE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:4772:13: ( 'source' )
            // InternalXtextTest.g:4772:15: 'source'
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
            // InternalXtextTest.g:4774:14: ( 'text' )
            // InternalXtextTest.g:4774:16: 'text'
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
            // InternalXtextTest.g:4776:11: ( 'file' )
            // InternalXtextTest.g:4776:13: 'file'
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
            // InternalXtextTest.g:4778:12: ( 'lexer-tokens' )
            // InternalXtextTest.g:4778:14: 'lexer-tokens'
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
            // InternalXtextTest.g:4780:13: ( 'output' )
            // InternalXtextTest.g:4780:15: 'output'
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
            // InternalXtextTest.g:4782:15: ( 'expected' )
            // InternalXtextTest.g:4782:17: 'expected'
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
            // InternalXtextTest.g:4784:24: ( 'isSameAsInputFile' )
            // InternalXtextTest.g:4784:26: 'isSameAsInputFile'
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

    // $ANTLR start "RULE_PATTERNS"
    public final void mRULE_PATTERNS() throws RecognitionException {
        try {
            int _type = RULE_PATTERNS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:4786:15: ( 'replacePatterns' )
            // InternalXtextTest.g:4786:17: 'replacePatterns'
            {
            match("replacePatterns"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_PATTERNS"

    // $ANTLR start "RULE_EXCEPTIONS"
    public final void mRULE_EXCEPTIONS() throws RecognitionException {
        try {
            int _type = RULE_EXCEPTIONS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:4788:17: ( 'exceptions' )
            // InternalXtextTest.g:4788:19: 'exceptions'
            {
            match("exceptions"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EXCEPTIONS"

    // $ANTLR start "RULE_BEFORE_KW"
    public final void mRULE_BEFORE_KW() throws RecognitionException {
        try {
            int _type = RULE_BEFORE_KW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:4790:16: ( 'before' )
            // InternalXtextTest.g:4790:18: 'before'
            {
            match("before"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BEFORE_KW"

    // $ANTLR start "RULE_AFTER_KW"
    public final void mRULE_AFTER_KW() throws RecognitionException {
        try {
            int _type = RULE_AFTER_KW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:4792:15: ( 'after' )
            // InternalXtextTest.g:4792:17: 'after'
            {
            match("after"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_AFTER_KW"

    // $ANTLR start "RULE_CLASS_KW"
    public final void mRULE_CLASS_KW() throws RecognitionException {
        try {
            int _type = RULE_CLASS_KW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:4794:15: ( 'class' )
            // InternalXtextTest.g:4794:17: 'class'
            {
            match("class"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CLASS_KW"

    // $ANTLR start "RULE_METHOD_KW"
    public final void mRULE_METHOD_KW() throws RecognitionException {
        try {
            int _type = RULE_METHOD_KW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:4796:16: ( 'method' )
            // InternalXtextTest.g:4796:18: 'method'
            {
            match("method"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_METHOD_KW"

    // $ANTLR start "RULE_ISNULL"
    public final void mRULE_ISNULL() throws RecognitionException {
        try {
            int _type = RULE_ISNULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:4798:13: ( 'isNull' )
            // InternalXtextTest.g:4798:15: 'isNull'
            {
            match("isNull"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ISNULL"

    // $ANTLR start "RULE_LEFTPAREN"
    public final void mRULE_LEFTPAREN() throws RecognitionException {
        try {
            int _type = RULE_LEFTPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:4800:16: ( '(' )
            // InternalXtextTest.g:4800:18: '('
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
            // InternalXtextTest.g:4802:17: ( ')' )
            // InternalXtextTest.g:4802:19: ')'
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

    // $ANTLR start "RULE_ASSIGNASBOOL"
    public final void mRULE_ASSIGNASBOOL() throws RecognitionException {
        try {
            int _type = RULE_ASSIGNASBOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:4804:19: ( '?=' )
            // InternalXtextTest.g:4804:21: '?='
            {
            match("?="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ASSIGNASBOOL"

    // $ANTLR start "RULE_TRUE"
    public final void mRULE_TRUE() throws RecognitionException {
        try {
            int _type = RULE_TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:4806:11: ( 'true' )
            // InternalXtextTest.g:4806:13: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_TRUE"

    // $ANTLR start "RULE_FALSE"
    public final void mRULE_FALSE() throws RecognitionException {
        try {
            int _type = RULE_FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:4808:12: ( 'false' )
            // InternalXtextTest.g:4808:14: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_FALSE"

    // $ANTLR start "RULE_ASSIGNASSINGLE"
    public final void mRULE_ASSIGNASSINGLE() throws RecognitionException {
        try {
            int _type = RULE_ASSIGNASSINGLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXtextTest.g:4810:21: ( '=' )
            // InternalXtextTest.g:4810:23: '='
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
            // InternalXtextTest.g:4812:19: ( '+=' )
            // InternalXtextTest.g:4812:21: '+='
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
            // InternalXtextTest.g:4814:21: ( '++' )
            // InternalXtextTest.g:4814:23: '++'
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
            // InternalXtextTest.g:4816:23: ( '+*' )
            // InternalXtextTest.g:4816:25: '+*'
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
            // InternalXtextTest.g:4818:12: ( ',' )
            // InternalXtextTest.g:4818:14: ','
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
            // InternalXtextTest.g:4820:17: ( RULE_ID )
            // InternalXtextTest.g:4820:19: RULE_ID
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
            // InternalXtextTest.g:4822:18: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalXtextTest.g:4822:20: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalXtextTest.g:4822:20: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalXtextTest.g:4822:20: '^'
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

            // InternalXtextTest.g:4822:49: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
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
            // InternalXtextTest.g:4824:10: ( ( '0' .. '9' )+ )
            // InternalXtextTest.g:4824:12: ( '0' .. '9' )+
            {
            // InternalXtextTest.g:4824:12: ( '0' .. '9' )+
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
            	    // InternalXtextTest.g:4824:13: '0' .. '9'
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
            // InternalXtextTest.g:4826:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalXtextTest.g:4826:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalXtextTest.g:4826:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalXtextTest.g:4826:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalXtextTest.g:4826:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalXtextTest.g:4826:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalXtextTest.g:4826:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalXtextTest.g:4826:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalXtextTest.g:4826:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalXtextTest.g:4826:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalXtextTest.g:4826:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalXtextTest.g:4828:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalXtextTest.g:4828:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalXtextTest.g:4828:24: ( options {greedy=false; } : . )*
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
            	    // InternalXtextTest.g:4828:52: .
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
            // InternalXtextTest.g:4830:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalXtextTest.g:4830:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalXtextTest.g:4830:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalXtextTest.g:4830:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalXtextTest.g:4830:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalXtextTest.g:4830:41: ( '\\r' )? '\\n'
                    {
                    // InternalXtextTest.g:4830:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalXtextTest.g:4830:41: '\\r'
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
            // InternalXtextTest.g:4832:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalXtextTest.g:4832:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalXtextTest.g:4832:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            // InternalXtextTest.g:4834:16: ( . )
            // InternalXtextTest.g:4834:18: .
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
        // InternalXtextTest.g:1:8: ( RULE_PACKAGE | RULE_LANGUAGE | RULE_POINT | RULE_SPLITLEXER | RULE_SOURCE | RULE_SRCTEXT | RULE_FILE | RULE_LEXER | RULE_OUTPUT | RULE_EXPECTED | RULE_ISSAMEASINPUTFILE | RULE_PATTERNS | RULE_EXCEPTIONS | RULE_BEFORE_KW | RULE_AFTER_KW | RULE_CLASS_KW | RULE_METHOD_KW | RULE_ISNULL | RULE_LEFTPAREN | RULE_RIGHTPAREN | RULE_ASSIGNASBOOL | RULE_TRUE | RULE_FALSE | RULE_ASSIGNASSINGLE | RULE_ASSIGNASLIST | RULE_ASSIGNASSTRING | RULE_ASSIGNASDATALIST | RULE_COMMA | RULE_IDENTIFIER | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=35;
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
                // InternalXtextTest.g:1:48: RULE_SPLITLEXER
                {
                mRULE_SPLITLEXER(); 

                }
                break;
            case 5 :
                // InternalXtextTest.g:1:64: RULE_SOURCE
                {
                mRULE_SOURCE(); 

                }
                break;
            case 6 :
                // InternalXtextTest.g:1:76: RULE_SRCTEXT
                {
                mRULE_SRCTEXT(); 

                }
                break;
            case 7 :
                // InternalXtextTest.g:1:89: RULE_FILE
                {
                mRULE_FILE(); 

                }
                break;
            case 8 :
                // InternalXtextTest.g:1:99: RULE_LEXER
                {
                mRULE_LEXER(); 

                }
                break;
            case 9 :
                // InternalXtextTest.g:1:110: RULE_OUTPUT
                {
                mRULE_OUTPUT(); 

                }
                break;
            case 10 :
                // InternalXtextTest.g:1:122: RULE_EXPECTED
                {
                mRULE_EXPECTED(); 

                }
                break;
            case 11 :
                // InternalXtextTest.g:1:136: RULE_ISSAMEASINPUTFILE
                {
                mRULE_ISSAMEASINPUTFILE(); 

                }
                break;
            case 12 :
                // InternalXtextTest.g:1:159: RULE_PATTERNS
                {
                mRULE_PATTERNS(); 

                }
                break;
            case 13 :
                // InternalXtextTest.g:1:173: RULE_EXCEPTIONS
                {
                mRULE_EXCEPTIONS(); 

                }
                break;
            case 14 :
                // InternalXtextTest.g:1:189: RULE_BEFORE_KW
                {
                mRULE_BEFORE_KW(); 

                }
                break;
            case 15 :
                // InternalXtextTest.g:1:204: RULE_AFTER_KW
                {
                mRULE_AFTER_KW(); 

                }
                break;
            case 16 :
                // InternalXtextTest.g:1:218: RULE_CLASS_KW
                {
                mRULE_CLASS_KW(); 

                }
                break;
            case 17 :
                // InternalXtextTest.g:1:232: RULE_METHOD_KW
                {
                mRULE_METHOD_KW(); 

                }
                break;
            case 18 :
                // InternalXtextTest.g:1:247: RULE_ISNULL
                {
                mRULE_ISNULL(); 

                }
                break;
            case 19 :
                // InternalXtextTest.g:1:259: RULE_LEFTPAREN
                {
                mRULE_LEFTPAREN(); 

                }
                break;
            case 20 :
                // InternalXtextTest.g:1:274: RULE_RIGHTPAREN
                {
                mRULE_RIGHTPAREN(); 

                }
                break;
            case 21 :
                // InternalXtextTest.g:1:290: RULE_ASSIGNASBOOL
                {
                mRULE_ASSIGNASBOOL(); 

                }
                break;
            case 22 :
                // InternalXtextTest.g:1:308: RULE_TRUE
                {
                mRULE_TRUE(); 

                }
                break;
            case 23 :
                // InternalXtextTest.g:1:318: RULE_FALSE
                {
                mRULE_FALSE(); 

                }
                break;
            case 24 :
                // InternalXtextTest.g:1:329: RULE_ASSIGNASSINGLE
                {
                mRULE_ASSIGNASSINGLE(); 

                }
                break;
            case 25 :
                // InternalXtextTest.g:1:349: RULE_ASSIGNASLIST
                {
                mRULE_ASSIGNASLIST(); 

                }
                break;
            case 26 :
                // InternalXtextTest.g:1:367: RULE_ASSIGNASSTRING
                {
                mRULE_ASSIGNASSTRING(); 

                }
                break;
            case 27 :
                // InternalXtextTest.g:1:387: RULE_ASSIGNASDATALIST
                {
                mRULE_ASSIGNASDATALIST(); 

                }
                break;
            case 28 :
                // InternalXtextTest.g:1:409: RULE_COMMA
                {
                mRULE_COMMA(); 

                }
                break;
            case 29 :
                // InternalXtextTest.g:1:420: RULE_IDENTIFIER
                {
                mRULE_IDENTIFIER(); 

                }
                break;
            case 30 :
                // InternalXtextTest.g:1:436: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 31 :
                // InternalXtextTest.g:1:445: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 32 :
                // InternalXtextTest.g:1:457: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 33 :
                // InternalXtextTest.g:1:473: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 34 :
                // InternalXtextTest.g:1:489: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 35 :
                // InternalXtextTest.g:1:497: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\2\36\1\uffff\13\36\2\uffff\1\34\1\uffff\1\34\1\uffff\1\34\2\uffff\3\34\2\uffff\1\36\1\uffff\2\36\1\uffff\16\36\15\uffff\30\36\1\150\1\151\1\152\20\36\3\uffff\1\173\7\36\1\u0083\1\u0084\3\36\2\uffff\1\u0088\1\uffff\1\u0089\3\36\1\u008d\1\36\1\u008f\2\uffff\1\u0090\1\u0091\1\36\2\uffff\3\36\1\uffff\1\36\3\uffff\1\u0097\1\u0098\3\36\2\uffff\3\36\1\u009f\2\36\1\uffff\11\36\1\u00ab\1\36\1\uffff\1\u00ad\1\uffff";
    static final String DFA12_eofS =
        "\u00ae\uffff";
    static final String DFA12_minS =
        "\1\0\2\141\1\uffff\1\157\1\145\1\141\1\165\1\170\1\163\2\145\1\146\1\154\1\145\2\uffff\1\75\1\uffff\1\52\1\uffff\1\101\2\uffff\2\0\1\52\2\uffff\1\143\1\uffff\1\156\1\170\1\uffff\1\154\1\165\1\170\1\165\2\154\1\164\1\143\1\116\1\160\1\146\1\164\1\141\1\164\15\uffff\1\153\1\147\1\145\1\151\1\162\1\164\2\145\1\163\1\160\2\145\1\141\1\165\1\154\1\157\1\145\1\163\1\150\1\141\1\165\1\162\1\164\1\143\3\60\1\145\1\165\1\143\1\160\1\155\1\154\1\141\2\162\1\163\1\157\1\147\1\141\2\55\1\145\3\uffff\1\60\3\164\1\145\1\154\1\143\1\145\2\60\1\144\1\145\1\147\2\uffff\1\60\1\uffff\1\60\1\145\1\151\1\101\1\60\1\145\1\60\2\uffff\2\60\1\145\2\uffff\1\144\1\157\1\163\1\uffff\1\120\3\uffff\2\60\1\156\1\111\1\141\2\uffff\1\163\1\156\1\164\1\60\1\160\1\164\1\uffff\1\165\1\145\1\164\1\162\1\106\1\156\1\151\1\163\1\154\1\60\1\145\1\uffff\1\60\1\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\141\1\145\1\uffff\1\160\1\162\1\151\1\165\1\170\1\163\2\145\1\146\1\154\1\145\2\uffff\1\75\1\uffff\1\75\1\uffff\1\172\2\uffff\2\uffff\1\57\2\uffff\1\143\1\uffff\1\156\1\170\1\uffff\1\154\1\165\1\170\1\165\2\154\1\164\1\160\1\123\1\160\1\146\1\164\1\141\1\164\15\uffff\1\153\1\147\1\145\1\151\1\162\1\164\2\145\1\163\1\160\2\145\1\141\1\165\1\154\1\157\1\145\1\163\1\150\1\141\1\165\1\162\1\164\1\143\3\172\1\145\1\165\1\143\1\160\1\155\1\154\1\141\2\162\1\163\1\157\1\147\1\141\2\55\1\145\3\uffff\1\172\3\164\1\145\1\154\1\143\1\145\2\172\1\144\1\145\1\147\2\uffff\1\172\1\uffff\1\172\1\145\1\151\1\101\1\172\1\145\1\172\2\uffff\2\172\1\145\2\uffff\1\144\1\157\1\163\1\uffff\1\120\3\uffff\2\172\1\156\1\111\1\141\2\uffff\1\163\1\156\1\164\1\172\1\160\1\164\1\uffff\1\165\1\145\1\164\1\162\1\106\1\156\1\151\1\163\1\154\1\172\1\145\1\uffff\1\172\1\uffff";
    static final String DFA12_acceptS =
        "\3\uffff\1\3\13\uffff\1\23\1\24\1\uffff\1\30\1\uffff\1\34\1\uffff\1\35\1\36\3\uffff\1\42\1\43\1\uffff\1\35\2\uffff\1\3\16\uffff\1\23\1\24\1\25\1\30\1\31\1\32\1\33\1\34\1\36\1\37\1\40\1\41\1\42\53\uffff\1\6\1\26\1\7\15\uffff\1\10\1\4\1\uffff\1\27\7\uffff\1\17\1\20\3\uffff\1\5\1\11\3\uffff\1\22\1\uffff\1\16\1\21\1\1\5\uffff\1\2\1\12\6\uffff\1\15\13\uffff\1\14\1\uffff\1\13";
    static final String DFA12_specialS =
        "\1\2\27\uffff\1\1\1\0\u0094\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\34\2\33\2\34\1\33\22\34\1\33\1\34\1\30\4\34\1\31\1\17\1\20\1\34\1\23\1\24\1\34\1\3\1\32\12\27\3\34\1\22\1\34\1\21\1\34\32\26\3\34\1\25\1\26\1\34\1\14\1\13\1\15\1\26\1\10\1\6\2\26\1\11\2\26\1\2\1\16\1\26\1\7\1\1\1\26\1\12\1\4\1\5\6\26\uff85\34",
            "\1\35",
            "\1\37\3\uffff\1\40",
            "",
            "\1\43\1\42",
            "\1\44\14\uffff\1\45",
            "\1\47\7\uffff\1\46",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "",
            "",
            "\1\62",
            "",
            "\1\66\1\65\21\uffff\1\64",
            "",
            "\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "",
            "\0\71",
            "\0\71",
            "\1\72\4\uffff\1\73",
            "",
            "",
            "\1\75",
            "",
            "\1\76",
            "\1\77",
            "",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\110\14\uffff\1\107",
            "\1\112\4\uffff\1\111",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
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
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "",
            "",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u008e",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u0092",
            "",
            "",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "",
            "\1\u0096",
            "",
            "",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "",
            "",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u00a0",
            "\1\u00a1",
            "",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u00ac",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
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
            return "1:1: Tokens : ( RULE_PACKAGE | RULE_LANGUAGE | RULE_POINT | RULE_SPLITLEXER | RULE_SOURCE | RULE_SRCTEXT | RULE_FILE | RULE_LEXER | RULE_OUTPUT | RULE_EXPECTED | RULE_ISSAMEASINPUTFILE | RULE_PATTERNS | RULE_EXCEPTIONS | RULE_BEFORE_KW | RULE_AFTER_KW | RULE_CLASS_KW | RULE_METHOD_KW | RULE_ISNULL | RULE_LEFTPAREN | RULE_RIGHTPAREN | RULE_ASSIGNASBOOL | RULE_TRUE | RULE_FALSE | RULE_ASSIGNASSINGLE | RULE_ASSIGNASLIST | RULE_ASSIGNASSTRING | RULE_ASSIGNASDATALIST | RULE_COMMA | RULE_IDENTIFIER | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_25 = input.LA(1);

                        s = -1;
                        if ( ((LA12_25>='\u0000' && LA12_25<='\uFFFF')) ) {s = 57;}

                        else s = 28;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_24 = input.LA(1);

                        s = -1;
                        if ( ((LA12_24>='\u0000' && LA12_24<='\uFFFF')) ) {s = 57;}

                        else s = 28;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
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

                        else if ( (LA12_0=='r') ) {s = 10;}

                        else if ( (LA12_0=='b') ) {s = 11;}

                        else if ( (LA12_0=='a') ) {s = 12;}

                        else if ( (LA12_0=='c') ) {s = 13;}

                        else if ( (LA12_0=='m') ) {s = 14;}

                        else if ( (LA12_0=='(') ) {s = 15;}

                        else if ( (LA12_0==')') ) {s = 16;}

                        else if ( (LA12_0=='?') ) {s = 17;}

                        else if ( (LA12_0=='=') ) {s = 18;}

                        else if ( (LA12_0=='+') ) {s = 19;}

                        else if ( (LA12_0==',') ) {s = 20;}

                        else if ( (LA12_0=='^') ) {s = 21;}

                        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||LA12_0=='d'||(LA12_0>='g' && LA12_0<='h')||(LA12_0>='j' && LA12_0<='k')||LA12_0=='n'||LA12_0=='q'||(LA12_0>='u' && LA12_0<='z')) ) {s = 22;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 23;}

                        else if ( (LA12_0=='\"') ) {s = 24;}

                        else if ( (LA12_0=='\'') ) {s = 25;}

                        else if ( (LA12_0=='/') ) {s = 26;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 27;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||LA12_0=='*'||LA12_0=='-'||(LA12_0>=':' && LA12_0<='<')||LA12_0=='>'||LA12_0=='@'||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFF')) ) {s = 28;}

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