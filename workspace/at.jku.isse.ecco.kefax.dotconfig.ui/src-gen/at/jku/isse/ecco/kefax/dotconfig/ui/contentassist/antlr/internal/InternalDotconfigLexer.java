package at.jku.isse.ecco.kefax.dotconfig.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDotconfigLexer extends Lexer {
    public static final int RULE_STRING=7;
    public static final int RULE_S_INT=6;
    public static final int RULE_NLI=4;
    public static final int RULE_STR_D=13;
    public static final int RULE_LOGIC_SYM=10;
    public static final int RULE_SL_COMMENT_NOT=11;
    public static final int RULE_S_HEX=5;
    public static final int RULE_EQ=8;
    public static final int RULE_STR_S=14;
    public static final int RULE_SYMBOL=9;
    public static final int RULE_ESC=15;
    public static final int RULE_SL_COMMENT=16;
    public static final int EOF=-1;
    public static final int RULE_WSS=12;

    // delegates
    // delegators

    public InternalDotconfigLexer() {;} 
    public InternalDotconfigLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalDotconfigLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g"; }

    // $ANTLR start "RULE_NLI"
    public final void mRULE_NLI() throws RecognitionException {
        try {
            int _type = RULE_NLI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:843:10: ( '\\n' )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:843:12: '\\n'
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

    // $ANTLR start "RULE_WSS"
    public final void mRULE_WSS() throws RecognitionException {
        try {
            int _type = RULE_WSS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:845:10: ( ( ' ' | '\\t' )+ )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:845:12: ( ' ' | '\\t' )+
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:845:12: ( ' ' | '\\t' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\t'||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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

    // $ANTLR start "RULE_EQ"
    public final void mRULE_EQ() throws RecognitionException {
        try {
            int _type = RULE_EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:847:9: ( '=' )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:847:11: '='
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

    // $ANTLR start "RULE_LOGIC_SYM"
    public final void mRULE_LOGIC_SYM() throws RecognitionException {
        try {
            int _type = RULE_LOGIC_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:849:16: ( ( 'y' | 'n' | 'm' ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:849:18: ( 'y' | 'n' | 'm' )
            {
            if ( (input.LA(1)>='m' && input.LA(1)<='n')||input.LA(1)=='y' ) {
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
    // $ANTLR end "RULE_LOGIC_SYM"

    // $ANTLR start "RULE_S_HEX"
    public final void mRULE_S_HEX() throws RecognitionException {
        try {
            int _type = RULE_S_HEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:851:12: ( '0' ( 'x' | 'X' ) ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+ )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:851:14: '0' ( 'x' | 'X' ) ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:851:28: ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='F')||(LA2_0>='a' && LA2_0<='f')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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
    // $ANTLR end "RULE_S_HEX"

    // $ANTLR start "RULE_S_INT"
    public final void mRULE_S_INT() throws RecognitionException {
        try {
            int _type = RULE_S_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:853:12: ( ( '-' )? ( '0' .. '9' )+ )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:853:14: ( '-' )? ( '0' .. '9' )+
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:853:14: ( '-' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='-') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:853:14: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:853:19: ( '0' .. '9' )+
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
            	    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:853:20: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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
    // $ANTLR end "RULE_S_INT"

    // $ANTLR start "RULE_SYMBOL"
    public final void mRULE_SYMBOL() throws RecognitionException {
        try {
            int _type = RULE_SYMBOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:855:13: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+ )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:855:15: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:855:15: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:
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
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SYMBOL"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:857:13: ( ( '\"' RULE_STR_D '\"' | '\\'' RULE_STR_S '\\'' ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:857:15: ( '\"' RULE_STR_D '\"' | '\\'' RULE_STR_S '\\'' )
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:857:15: ( '\"' RULE_STR_D '\"' | '\\'' RULE_STR_S '\\'' )
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
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:857:16: '\"' RULE_STR_D '\"'
                    {
                    match('\"'); 
                    mRULE_STR_D(); 
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:857:35: '\\'' RULE_STR_S '\\''
                    {
                    match('\''); 
                    mRULE_STR_S(); 
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

    // $ANTLR start "RULE_STR_D"
    public final void mRULE_STR_D() throws RecognitionException {
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:859:21: ( ( RULE_ESC | ~ ( ( '\\\\' | '\"' ) ) )* )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:859:23: ( RULE_ESC | ~ ( ( '\\\\' | '\"' ) ) )*
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:859:23: ( RULE_ESC | ~ ( ( '\\\\' | '\"' ) ) )*
            loop7:
            do {
                int alt7=3;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\\') ) {
                    alt7=1;
                }
                else if ( ((LA7_0>='\u0000' && LA7_0<='!')||(LA7_0>='#' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                    alt7=2;
                }


                switch (alt7) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:859:24: RULE_ESC
            	    {
            	    mRULE_ESC(); 

            	    }
            	    break;
            	case 2 :
            	    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:859:33: ~ ( ( '\\\\' | '\"' ) )
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
            	    break loop7;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_STR_D"

    // $ANTLR start "RULE_STR_S"
    public final void mRULE_STR_S() throws RecognitionException {
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:861:21: ( ( RULE_ESC | ~ ( ( '\\\\' | '\\'' ) ) )* )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:861:23: ( RULE_ESC | ~ ( ( '\\\\' | '\\'' ) ) )*
            {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:861:23: ( RULE_ESC | ~ ( ( '\\\\' | '\\'' ) ) )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\\') ) {
                    alt8=1;
                }
                else if ( ((LA8_0>='\u0000' && LA8_0<='&')||(LA8_0>='(' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:861:24: RULE_ESC
            	    {
            	    mRULE_ESC(); 

            	    }
            	    break;
            	case 2 :
            	    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:861:33: ~ ( ( '\\\\' | '\\'' ) )
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
            	    break loop8;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_STR_S"

    // $ANTLR start "RULE_ESC"
    public final void mRULE_ESC() throws RecognitionException {
        try {
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:863:19: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:863:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
            {
            match('\\'); 
            if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
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
    // $ANTLR end "RULE_ESC"

    // $ANTLR start "RULE_SL_COMMENT_NOT"
    public final void mRULE_SL_COMMENT_NOT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT_NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:865:21: ( '# ' RULE_SYMBOL ' is not set' )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:865:23: '# ' RULE_SYMBOL ' is not set'
            {
            match("# "); 

            mRULE_SYMBOL(); 
            match(" is not set"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT_NOT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:867:17: ( '#' (~ ( '\\n' ) )* )
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:867:19: '#' (~ ( '\\n' ) )*
            {
            match('#'); 
            // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:867:23: (~ ( '\\n' ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:867:23: ~ ( '\\n' )
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
            	    break loop9;
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

    public void mTokens() throws RecognitionException {
        // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:1:8: ( RULE_NLI | RULE_WSS | RULE_EQ | RULE_LOGIC_SYM | RULE_S_HEX | RULE_S_INT | RULE_SYMBOL | RULE_STRING | RULE_SL_COMMENT_NOT | RULE_SL_COMMENT )
        int alt10=10;
        alt10 = dfa10.predict(input);
        switch (alt10) {
            case 1 :
                // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:1:10: RULE_NLI
                {
                mRULE_NLI(); 

                }
                break;
            case 2 :
                // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:1:19: RULE_WSS
                {
                mRULE_WSS(); 

                }
                break;
            case 3 :
                // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:1:28: RULE_EQ
                {
                mRULE_EQ(); 

                }
                break;
            case 4 :
                // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:1:36: RULE_LOGIC_SYM
                {
                mRULE_LOGIC_SYM(); 

                }
                break;
            case 5 :
                // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:1:51: RULE_S_HEX
                {
                mRULE_S_HEX(); 

                }
                break;
            case 6 :
                // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:1:62: RULE_S_INT
                {
                mRULE_S_INT(); 

                }
                break;
            case 7 :
                // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:1:73: RULE_SYMBOL
                {
                mRULE_SYMBOL(); 

                }
                break;
            case 8 :
                // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:1:85: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 9 :
                // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:1:97: RULE_SL_COMMENT_NOT
                {
                mRULE_SL_COMMENT_NOT(); 

                }
                break;
            case 10 :
                // ../at.jku.isse.ecco.kefax.dotconfig.ui/src-gen/at/jku/isse/ecco/kefax/dotconfig/ui/contentassist/antlr/internal/InternalDotconfig.g:1:117: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\4\uffff\1\13\1\6\1\uffff\1\6\2\uffff\1\16\1\uffff\1\10\1\16\1\uffff\1\21\1\16\1\uffff\12\16\1\35\1\uffff";
    static final String DFA10_eofS =
        "\36\uffff";
    static final String DFA10_minS =
        "\1\11\3\uffff\2\60\1\uffff\1\60\2\uffff\1\40\1\uffff\2\60\1\uffff\1\60\1\40\1\uffff\1\151\1\163\1\40\1\156\1\157\1\164\1\40\1\163\1\145\1\164\1\0\1\uffff";
    static final String DFA10_maxS =
        "\1\172\3\uffff\2\172\1\uffff\1\172\2\uffff\1\40\1\uffff\1\146\1\172\1\uffff\2\172\1\uffff\1\151\1\163\1\40\1\156\1\157\1\164\1\40\1\163\1\145\1\164\1\uffff\1\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\1\2\1\3\2\uffff\1\6\1\uffff\1\7\1\10\1\uffff\1\4\2\uffff\1\12\2\uffff\1\5\13\uffff\1\11";
    static final String DFA10_specialS =
        "\34\uffff\1\0\1\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\2\1\1\25\uffff\1\2\1\uffff\1\11\1\12\3\uffff\1\11\5\uffff\1\6\2\uffff\1\5\11\7\3\uffff\1\3\3\uffff\32\10\4\uffff\1\10\1\uffff\14\10\2\4\12\10\1\4\1\10",
            "",
            "",
            "",
            "\12\10\7\uffff\32\10\4\uffff\1\10\1\uffff\32\10",
            "\12\7\7\uffff\27\10\1\14\2\10\4\uffff\1\10\1\uffff\27\10\1\14\2\10",
            "",
            "\12\7\7\uffff\32\10\4\uffff\1\10\1\uffff\32\10",
            "",
            "",
            "\1\15",
            "",
            "\12\17\7\uffff\6\17\32\uffff\6\17",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "",
            "\12\17\7\uffff\6\17\24\10\4\uffff\1\10\1\uffff\6\17\24\10",
            "\1\22\17\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\27",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\34",
            "\12\16\1\uffff\ufff5\16",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( RULE_NLI | RULE_WSS | RULE_EQ | RULE_LOGIC_SYM | RULE_S_HEX | RULE_S_INT | RULE_SYMBOL | RULE_STRING | RULE_SL_COMMENT_NOT | RULE_SL_COMMENT );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA10_28 = input.LA(1);

                        s = -1;
                        if ( ((LA10_28>='\u0000' && LA10_28<='\t')||(LA10_28>='\u000B' && LA10_28<='\uFFFF')) ) {s = 14;}

                        else s = 29;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 10, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}