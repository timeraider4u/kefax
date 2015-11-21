package at.jku.weiner.cpreprocess.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class InternalCPreprocessLexer extends Lexer {
    public static final int FRAGMENT_RULE_HASH=28;
    public static final int RULE_PRAGMA=9;
    public static final int RULE_ID=20;
    public static final int FRAGMENT_RULE_LPAREN=34;
    public static final int RULE_NEWLINE=14;
    public static final int FRAGMENT_RULE_NEWLINE=36;
    public static final int RULE_ID_NONDIGIT=21;
    public static final int RULE_NONDIGIT_LETTER=23;
    public static final int FRAGMENT_RULE_RPAREN=35;
    public static final int FRAGMENT_RULE_ID=38;
    public static final int RULE_ERROR=7;
    public static final int RULE_HASH=4;
    public static final int FRAGMENT_RULE_SPECIAL=39;
    public static final int RULE_TAB=18;
    public static final int FRAGMENT_RULE_INCLUDE=29;
    public static final int RULE_UNDEF=8;
    public static final int EOF=-1;
    public static final int FRAGMENT_RULE_PRAGMA=33;
    public static final int RULE_HEXADECIMAL_DIGIT=26;
    public static final int SYNTHETIC_ALL_KEYWORDS=40;
    public static final int RULE_LINEBREAK=16;
    public static final int RULE_DEFINE=6;
    public static final int RULE_SPECIAL=27;
    public static final int RULE_LPAREN=10;
    public static final int RULE_CARRIAGERETURN=13;
    public static final int FRAGMENT_RULE_UNDEF=32;
    public static final int RULE_INCLUDE=5;
    public static final int RULE_BACKSLASH=15;
    public static final int FRAGMENT_RULE_ERROR=31;
    public static final int RULE_RPAREN=11;
    public static final int FRAGMENT_RULE_WS=37;
    public static final int FRAGMENT_RULE_DEFINE=30;
    public static final int RULE_WS=19;
    public static final int RULE_DIGIT=22;
    public static final int RULE_SPACE=17;
    public static final int RULE_UNIVERSAL_CHARACTER=24;
    public static final int RULE_LINEFEED=12;
    public static final int RULE_HEX_QUAD=25;

    // delegates
    // delegators

    public InternalCPreprocessLexer() {;} 
    public InternalCPreprocessLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalCPreprocessLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
        state.ruleMemo = new HashMap[61+1];
 
    }
    public String getGrammarFileName() { return "InternalCPreprocessLexer.g"; }

    // $ANTLR start "SYNTHETIC_ALL_KEYWORDS"
    public final void mSYNTHETIC_ALL_KEYWORDS() throws RecognitionException {
        int SYNTHETIC_ALL_KEYWORDS_StartIndex = input.index();
        try {
            int _type = SYNTHETIC_ALL_KEYWORDS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return ; }
            // InternalCPreprocessLexer.g:49:24: ( ( FRAGMENT_RULE_HASH )=> FRAGMENT_RULE_HASH | ( FRAGMENT_RULE_INCLUDE )=> FRAGMENT_RULE_INCLUDE | ( FRAGMENT_RULE_DEFINE )=> FRAGMENT_RULE_DEFINE | ( FRAGMENT_RULE_ERROR )=> FRAGMENT_RULE_ERROR | ( FRAGMENT_RULE_UNDEF )=> FRAGMENT_RULE_UNDEF | ( FRAGMENT_RULE_PRAGMA )=> FRAGMENT_RULE_PRAGMA | ( FRAGMENT_RULE_LPAREN )=> FRAGMENT_RULE_LPAREN | ( FRAGMENT_RULE_RPAREN )=> FRAGMENT_RULE_RPAREN | ( FRAGMENT_RULE_NEWLINE )=> FRAGMENT_RULE_NEWLINE | ( FRAGMENT_RULE_WS )=> FRAGMENT_RULE_WS | ( FRAGMENT_RULE_ID )=> FRAGMENT_RULE_ID | ( FRAGMENT_RULE_SPECIAL )=> FRAGMENT_RULE_SPECIAL )
            int alt1=12;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalCPreprocessLexer.g:50:2: ( FRAGMENT_RULE_HASH )=> FRAGMENT_RULE_HASH
                    {
                    mFRAGMENT_RULE_HASH(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_HASH; 
                    }

                    }
                    break;
                case 2 :
                    // InternalCPreprocessLexer.g:51:2: ( FRAGMENT_RULE_INCLUDE )=> FRAGMENT_RULE_INCLUDE
                    {
                    mFRAGMENT_RULE_INCLUDE(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_INCLUDE; 
                    }

                    }
                    break;
                case 3 :
                    // InternalCPreprocessLexer.g:52:2: ( FRAGMENT_RULE_DEFINE )=> FRAGMENT_RULE_DEFINE
                    {
                    mFRAGMENT_RULE_DEFINE(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_DEFINE; 
                    }

                    }
                    break;
                case 4 :
                    // InternalCPreprocessLexer.g:53:2: ( FRAGMENT_RULE_ERROR )=> FRAGMENT_RULE_ERROR
                    {
                    mFRAGMENT_RULE_ERROR(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_ERROR; 
                    }

                    }
                    break;
                case 5 :
                    // InternalCPreprocessLexer.g:54:2: ( FRAGMENT_RULE_UNDEF )=> FRAGMENT_RULE_UNDEF
                    {
                    mFRAGMENT_RULE_UNDEF(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_UNDEF; 
                    }

                    }
                    break;
                case 6 :
                    // InternalCPreprocessLexer.g:55:2: ( FRAGMENT_RULE_PRAGMA )=> FRAGMENT_RULE_PRAGMA
                    {
                    mFRAGMENT_RULE_PRAGMA(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_PRAGMA; 
                    }

                    }
                    break;
                case 7 :
                    // InternalCPreprocessLexer.g:56:2: ( FRAGMENT_RULE_LPAREN )=> FRAGMENT_RULE_LPAREN
                    {
                    mFRAGMENT_RULE_LPAREN(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_LPAREN; 
                    }

                    }
                    break;
                case 8 :
                    // InternalCPreprocessLexer.g:57:2: ( FRAGMENT_RULE_RPAREN )=> FRAGMENT_RULE_RPAREN
                    {
                    mFRAGMENT_RULE_RPAREN(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_RPAREN; 
                    }

                    }
                    break;
                case 9 :
                    // InternalCPreprocessLexer.g:58:2: ( FRAGMENT_RULE_NEWLINE )=> FRAGMENT_RULE_NEWLINE
                    {
                    mFRAGMENT_RULE_NEWLINE(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_NEWLINE; 
                    }

                    }
                    break;
                case 10 :
                    // InternalCPreprocessLexer.g:59:2: ( FRAGMENT_RULE_WS )=> FRAGMENT_RULE_WS
                    {
                    mFRAGMENT_RULE_WS(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_WS; 
                    }

                    }
                    break;
                case 11 :
                    // InternalCPreprocessLexer.g:60:2: ( FRAGMENT_RULE_ID )=> FRAGMENT_RULE_ID
                    {
                    mFRAGMENT_RULE_ID(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_ID; 
                    }

                    }
                    break;
                case 12 :
                    // InternalCPreprocessLexer.g:61:2: ( FRAGMENT_RULE_SPECIAL )=> FRAGMENT_RULE_SPECIAL
                    {
                    mFRAGMENT_RULE_SPECIAL(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SPECIAL; 
                    }

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, SYNTHETIC_ALL_KEYWORDS_StartIndex); }
        }
    }
    // $ANTLR end "SYNTHETIC_ALL_KEYWORDS"

    // $ANTLR start "RULE_HASH"
    public final void mRULE_HASH() throws RecognitionException {
        int RULE_HASH_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return ; }
            // InternalCPreprocessLexer.g:66:20: ( FRAGMENT_RULE_HASH )
            // InternalCPreprocessLexer.g:66:22: FRAGMENT_RULE_HASH
            {
            mFRAGMENT_RULE_HASH(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, RULE_HASH_StartIndex); }
        }
    }
    // $ANTLR end "RULE_HASH"

    // $ANTLR start "FRAGMENT_RULE_HASH"
    public final void mFRAGMENT_RULE_HASH() throws RecognitionException {
        int FRAGMENT_RULE_HASH_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return ; }
            // InternalCPreprocessLexer.g:67:29: ( '#' )
            // InternalCPreprocessLexer.g:67:31: '#'
            {
            match('#'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, FRAGMENT_RULE_HASH_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_HASH"

    // $ANTLR start "RULE_INCLUDE"
    public final void mRULE_INCLUDE() throws RecognitionException {
        int RULE_INCLUDE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return ; }
            // InternalCPreprocessLexer.g:69:23: ( FRAGMENT_RULE_INCLUDE )
            // InternalCPreprocessLexer.g:69:25: FRAGMENT_RULE_INCLUDE
            {
            mFRAGMENT_RULE_INCLUDE(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, RULE_INCLUDE_StartIndex); }
        }
    }
    // $ANTLR end "RULE_INCLUDE"

    // $ANTLR start "FRAGMENT_RULE_INCLUDE"
    public final void mFRAGMENT_RULE_INCLUDE() throws RecognitionException {
        int FRAGMENT_RULE_INCLUDE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return ; }
            // InternalCPreprocessLexer.g:70:32: ( 'include' )
            // InternalCPreprocessLexer.g:70:34: 'include'
            {
            match("include"); if (state.failed) return ;


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, FRAGMENT_RULE_INCLUDE_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_INCLUDE"

    // $ANTLR start "RULE_DEFINE"
    public final void mRULE_DEFINE() throws RecognitionException {
        int RULE_DEFINE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return ; }
            // InternalCPreprocessLexer.g:72:22: ( FRAGMENT_RULE_DEFINE )
            // InternalCPreprocessLexer.g:72:24: FRAGMENT_RULE_DEFINE
            {
            mFRAGMENT_RULE_DEFINE(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, RULE_DEFINE_StartIndex); }
        }
    }
    // $ANTLR end "RULE_DEFINE"

    // $ANTLR start "FRAGMENT_RULE_DEFINE"
    public final void mFRAGMENT_RULE_DEFINE() throws RecognitionException {
        int FRAGMENT_RULE_DEFINE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return ; }
            // InternalCPreprocessLexer.g:73:31: ( 'define' )
            // InternalCPreprocessLexer.g:73:33: 'define'
            {
            match("define"); if (state.failed) return ;


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, FRAGMENT_RULE_DEFINE_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_DEFINE"

    // $ANTLR start "RULE_ERROR"
    public final void mRULE_ERROR() throws RecognitionException {
        int RULE_ERROR_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return ; }
            // InternalCPreprocessLexer.g:75:21: ( FRAGMENT_RULE_ERROR )
            // InternalCPreprocessLexer.g:75:23: FRAGMENT_RULE_ERROR
            {
            mFRAGMENT_RULE_ERROR(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, RULE_ERROR_StartIndex); }
        }
    }
    // $ANTLR end "RULE_ERROR"

    // $ANTLR start "FRAGMENT_RULE_ERROR"
    public final void mFRAGMENT_RULE_ERROR() throws RecognitionException {
        int FRAGMENT_RULE_ERROR_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return ; }
            // InternalCPreprocessLexer.g:76:30: ( 'error' )
            // InternalCPreprocessLexer.g:76:32: 'error'
            {
            match("error"); if (state.failed) return ;


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, FRAGMENT_RULE_ERROR_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_ERROR"

    // $ANTLR start "RULE_UNDEF"
    public final void mRULE_UNDEF() throws RecognitionException {
        int RULE_UNDEF_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return ; }
            // InternalCPreprocessLexer.g:78:21: ( FRAGMENT_RULE_UNDEF )
            // InternalCPreprocessLexer.g:78:23: FRAGMENT_RULE_UNDEF
            {
            mFRAGMENT_RULE_UNDEF(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, RULE_UNDEF_StartIndex); }
        }
    }
    // $ANTLR end "RULE_UNDEF"

    // $ANTLR start "FRAGMENT_RULE_UNDEF"
    public final void mFRAGMENT_RULE_UNDEF() throws RecognitionException {
        int FRAGMENT_RULE_UNDEF_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return ; }
            // InternalCPreprocessLexer.g:79:30: ( 'undef' )
            // InternalCPreprocessLexer.g:79:32: 'undef'
            {
            match("undef"); if (state.failed) return ;


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, FRAGMENT_RULE_UNDEF_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_UNDEF"

    // $ANTLR start "RULE_PRAGMA"
    public final void mRULE_PRAGMA() throws RecognitionException {
        int RULE_PRAGMA_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return ; }
            // InternalCPreprocessLexer.g:81:22: ( FRAGMENT_RULE_PRAGMA )
            // InternalCPreprocessLexer.g:81:24: FRAGMENT_RULE_PRAGMA
            {
            mFRAGMENT_RULE_PRAGMA(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, RULE_PRAGMA_StartIndex); }
        }
    }
    // $ANTLR end "RULE_PRAGMA"

    // $ANTLR start "FRAGMENT_RULE_PRAGMA"
    public final void mFRAGMENT_RULE_PRAGMA() throws RecognitionException {
        int FRAGMENT_RULE_PRAGMA_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return ; }
            // InternalCPreprocessLexer.g:82:31: ( 'pragma' )
            // InternalCPreprocessLexer.g:82:33: 'pragma'
            {
            match("pragma"); if (state.failed) return ;


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, FRAGMENT_RULE_PRAGMA_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_PRAGMA"

    // $ANTLR start "RULE_LPAREN"
    public final void mRULE_LPAREN() throws RecognitionException {
        int RULE_LPAREN_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return ; }
            // InternalCPreprocessLexer.g:84:22: ( FRAGMENT_RULE_LPAREN )
            // InternalCPreprocessLexer.g:84:24: FRAGMENT_RULE_LPAREN
            {
            mFRAGMENT_RULE_LPAREN(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, RULE_LPAREN_StartIndex); }
        }
    }
    // $ANTLR end "RULE_LPAREN"

    // $ANTLR start "FRAGMENT_RULE_LPAREN"
    public final void mFRAGMENT_RULE_LPAREN() throws RecognitionException {
        int FRAGMENT_RULE_LPAREN_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return ; }
            // InternalCPreprocessLexer.g:85:31: ( '(' )
            // InternalCPreprocessLexer.g:85:33: '('
            {
            match('('); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, FRAGMENT_RULE_LPAREN_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_LPAREN"

    // $ANTLR start "RULE_RPAREN"
    public final void mRULE_RPAREN() throws RecognitionException {
        int RULE_RPAREN_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return ; }
            // InternalCPreprocessLexer.g:87:22: ( FRAGMENT_RULE_RPAREN )
            // InternalCPreprocessLexer.g:87:24: FRAGMENT_RULE_RPAREN
            {
            mFRAGMENT_RULE_RPAREN(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, RULE_RPAREN_StartIndex); }
        }
    }
    // $ANTLR end "RULE_RPAREN"

    // $ANTLR start "FRAGMENT_RULE_RPAREN"
    public final void mFRAGMENT_RULE_RPAREN() throws RecognitionException {
        int FRAGMENT_RULE_RPAREN_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return ; }
            // InternalCPreprocessLexer.g:88:31: ( ')' )
            // InternalCPreprocessLexer.g:88:33: ')'
            {
            match(')'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, FRAGMENT_RULE_RPAREN_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_RPAREN"

    // $ANTLR start "RULE_LINEFEED"
    public final void mRULE_LINEFEED() throws RecognitionException {
        int RULE_LINEFEED_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return ; }
            // InternalCPreprocessLexer.g:90:24: ( '\\n' )
            // InternalCPreprocessLexer.g:90:26: '\\n'
            {
            match('\n'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, RULE_LINEFEED_StartIndex); }
        }
    }
    // $ANTLR end "RULE_LINEFEED"

    // $ANTLR start "RULE_CARRIAGERETURN"
    public final void mRULE_CARRIAGERETURN() throws RecognitionException {
        int RULE_CARRIAGERETURN_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return ; }
            // InternalCPreprocessLexer.g:92:30: ( '\\r' )
            // InternalCPreprocessLexer.g:92:32: '\\r'
            {
            match('\r'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, RULE_CARRIAGERETURN_StartIndex); }
        }
    }
    // $ANTLR end "RULE_CARRIAGERETURN"

    // $ANTLR start "RULE_NEWLINE"
    public final void mRULE_NEWLINE() throws RecognitionException {
        int RULE_NEWLINE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return ; }
            // InternalCPreprocessLexer.g:94:23: ( FRAGMENT_RULE_NEWLINE )
            // InternalCPreprocessLexer.g:94:25: FRAGMENT_RULE_NEWLINE
            {
            mFRAGMENT_RULE_NEWLINE(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, RULE_NEWLINE_StartIndex); }
        }
    }
    // $ANTLR end "RULE_NEWLINE"

    // $ANTLR start "FRAGMENT_RULE_NEWLINE"
    public final void mFRAGMENT_RULE_NEWLINE() throws RecognitionException {
        int FRAGMENT_RULE_NEWLINE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return ; }
            // InternalCPreprocessLexer.g:95:32: ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) )
            // InternalCPreprocessLexer.g:95:34: ( RULE_CARRIAGERETURN | RULE_LINEFEED )
            {
            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, FRAGMENT_RULE_NEWLINE_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_NEWLINE"

    // $ANTLR start "RULE_BACKSLASH"
    public final void mRULE_BACKSLASH() throws RecognitionException {
        int RULE_BACKSLASH_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return ; }
            // InternalCPreprocessLexer.g:97:25: ( '\\\\' )
            // InternalCPreprocessLexer.g:97:27: '\\\\'
            {
            match('\\'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 22, RULE_BACKSLASH_StartIndex); }
        }
    }
    // $ANTLR end "RULE_BACKSLASH"

    // $ANTLR start "RULE_LINEBREAK"
    public final void mRULE_LINEBREAK() throws RecognitionException {
        int RULE_LINEBREAK_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return ; }
            // InternalCPreprocessLexer.g:99:25: ( RULE_BACKSLASH RULE_NEWLINE )
            // InternalCPreprocessLexer.g:99:27: RULE_BACKSLASH RULE_NEWLINE
            {
            mRULE_BACKSLASH(); if (state.failed) return ;
            mRULE_NEWLINE(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, RULE_LINEBREAK_StartIndex); }
        }
    }
    // $ANTLR end "RULE_LINEBREAK"

    // $ANTLR start "RULE_SPACE"
    public final void mRULE_SPACE() throws RecognitionException {
        int RULE_SPACE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return ; }
            // InternalCPreprocessLexer.g:101:21: ( ' ' )
            // InternalCPreprocessLexer.g:101:23: ' '
            {
            match(' '); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 24, RULE_SPACE_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SPACE"

    // $ANTLR start "RULE_TAB"
    public final void mRULE_TAB() throws RecognitionException {
        int RULE_TAB_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return ; }
            // InternalCPreprocessLexer.g:103:19: ( '\\t' )
            // InternalCPreprocessLexer.g:103:21: '\\t'
            {
            match('\t'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, RULE_TAB_StartIndex); }
        }
    }
    // $ANTLR end "RULE_TAB"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        int RULE_WS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return ; }
            // InternalCPreprocessLexer.g:105:18: ( FRAGMENT_RULE_WS )
            // InternalCPreprocessLexer.g:105:20: FRAGMENT_RULE_WS
            {
            mFRAGMENT_RULE_WS(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 26, RULE_WS_StartIndex); }
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "FRAGMENT_RULE_WS"
    public final void mFRAGMENT_RULE_WS() throws RecognitionException {
        int FRAGMENT_RULE_WS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return ; }
            // InternalCPreprocessLexer.g:106:27: ( ( RULE_SPACE | RULE_TAB | RULE_LINEBREAK ) )
            // InternalCPreprocessLexer.g:106:29: ( RULE_SPACE | RULE_TAB | RULE_LINEBREAK )
            {
            // InternalCPreprocessLexer.g:106:29: ( RULE_SPACE | RULE_TAB | RULE_LINEBREAK )
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalCPreprocessLexer.g:106:30: RULE_SPACE
                    {
                    mRULE_SPACE(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // InternalCPreprocessLexer.g:106:41: RULE_TAB
                    {
                    mRULE_TAB(); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // InternalCPreprocessLexer.g:106:50: RULE_LINEBREAK
                    {
                    mRULE_LINEBREAK(); if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, FRAGMENT_RULE_WS_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_WS"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        int RULE_ID_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return ; }
            // InternalCPreprocessLexer.g:108:18: ( FRAGMENT_RULE_ID )
            // InternalCPreprocessLexer.g:108:20: FRAGMENT_RULE_ID
            {
            mFRAGMENT_RULE_ID(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 28, RULE_ID_StartIndex); }
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "FRAGMENT_RULE_ID"
    public final void mFRAGMENT_RULE_ID() throws RecognitionException {
        int FRAGMENT_RULE_ID_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return ; }
            // InternalCPreprocessLexer.g:109:27: ( RULE_ID_NONDIGIT ( RULE_ID_NONDIGIT | RULE_DIGIT )* )
            // InternalCPreprocessLexer.g:109:29: RULE_ID_NONDIGIT ( RULE_ID_NONDIGIT | RULE_DIGIT )*
            {
            mRULE_ID_NONDIGIT(); if (state.failed) return ;
            // InternalCPreprocessLexer.g:109:46: ( RULE_ID_NONDIGIT | RULE_DIGIT )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='A' && LA3_0<='Z')||LA3_0=='\\'||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }
                else if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalCPreprocessLexer.g:109:47: RULE_ID_NONDIGIT
            	    {
            	    mRULE_ID_NONDIGIT(); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // InternalCPreprocessLexer.g:109:64: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, FRAGMENT_RULE_ID_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_ID"

    // $ANTLR start "RULE_ID_NONDIGIT"
    public final void mRULE_ID_NONDIGIT() throws RecognitionException {
        int RULE_ID_NONDIGIT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return ; }
            // InternalCPreprocessLexer.g:111:27: ( ( RULE_NONDIGIT_LETTER | RULE_UNIVERSAL_CHARACTER ) )
            // InternalCPreprocessLexer.g:111:29: ( RULE_NONDIGIT_LETTER | RULE_UNIVERSAL_CHARACTER )
            {
            // InternalCPreprocessLexer.g:111:29: ( RULE_NONDIGIT_LETTER | RULE_UNIVERSAL_CHARACTER )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                alt4=1;
            }
            else if ( (LA4_0=='\\') ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalCPreprocessLexer.g:111:30: RULE_NONDIGIT_LETTER
                    {
                    mRULE_NONDIGIT_LETTER(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // InternalCPreprocessLexer.g:111:51: RULE_UNIVERSAL_CHARACTER
                    {
                    mRULE_UNIVERSAL_CHARACTER(); if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 30, RULE_ID_NONDIGIT_StartIndex); }
        }
    }
    // $ANTLR end "RULE_ID_NONDIGIT"

    // $ANTLR start "RULE_DIGIT"
    public final void mRULE_DIGIT() throws RecognitionException {
        int RULE_DIGIT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return ; }
            // InternalCPreprocessLexer.g:113:21: ( '0' .. '9' )
            // InternalCPreprocessLexer.g:113:23: '0' .. '9'
            {
            matchRange('0','9'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 31, RULE_DIGIT_StartIndex); }
        }
    }
    // $ANTLR end "RULE_DIGIT"

    // $ANTLR start "RULE_NONDIGIT_LETTER"
    public final void mRULE_NONDIGIT_LETTER() throws RecognitionException {
        int RULE_NONDIGIT_LETTER_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return ; }
            // InternalCPreprocessLexer.g:115:31: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) )
            // InternalCPreprocessLexer.g:115:33: ( 'a' .. 'z' | 'A' .. 'Z' | '_' )
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 32, RULE_NONDIGIT_LETTER_StartIndex); }
        }
    }
    // $ANTLR end "RULE_NONDIGIT_LETTER"

    // $ANTLR start "RULE_UNIVERSAL_CHARACTER"
    public final void mRULE_UNIVERSAL_CHARACTER() throws RecognitionException {
        int RULE_UNIVERSAL_CHARACTER_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return ; }
            // InternalCPreprocessLexer.g:117:35: ( ( '\\\\u' RULE_HEX_QUAD | '\\\\U' RULE_HEX_QUAD RULE_HEX_QUAD ) )
            // InternalCPreprocessLexer.g:117:37: ( '\\\\u' RULE_HEX_QUAD | '\\\\U' RULE_HEX_QUAD RULE_HEX_QUAD )
            {
            // InternalCPreprocessLexer.g:117:37: ( '\\\\u' RULE_HEX_QUAD | '\\\\U' RULE_HEX_QUAD RULE_HEX_QUAD )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\\') ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1=='u') ) {
                    alt5=1;
                }
                else if ( (LA5_1=='U') ) {
                    alt5=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalCPreprocessLexer.g:117:38: '\\\\u' RULE_HEX_QUAD
                    {
                    match("\\u"); if (state.failed) return ;

                    mRULE_HEX_QUAD(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // InternalCPreprocessLexer.g:117:58: '\\\\U' RULE_HEX_QUAD RULE_HEX_QUAD
                    {
                    match("\\U"); if (state.failed) return ;

                    mRULE_HEX_QUAD(); if (state.failed) return ;
                    mRULE_HEX_QUAD(); if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 33, RULE_UNIVERSAL_CHARACTER_StartIndex); }
        }
    }
    // $ANTLR end "RULE_UNIVERSAL_CHARACTER"

    // $ANTLR start "RULE_HEX_QUAD"
    public final void mRULE_HEX_QUAD() throws RecognitionException {
        int RULE_HEX_QUAD_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return ; }
            // InternalCPreprocessLexer.g:119:24: ( RULE_HEXADECIMAL_DIGIT RULE_HEXADECIMAL_DIGIT RULE_HEXADECIMAL_DIGIT RULE_HEXADECIMAL_DIGIT )
            // InternalCPreprocessLexer.g:119:26: RULE_HEXADECIMAL_DIGIT RULE_HEXADECIMAL_DIGIT RULE_HEXADECIMAL_DIGIT RULE_HEXADECIMAL_DIGIT
            {
            mRULE_HEXADECIMAL_DIGIT(); if (state.failed) return ;
            mRULE_HEXADECIMAL_DIGIT(); if (state.failed) return ;
            mRULE_HEXADECIMAL_DIGIT(); if (state.failed) return ;
            mRULE_HEXADECIMAL_DIGIT(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 34, RULE_HEX_QUAD_StartIndex); }
        }
    }
    // $ANTLR end "RULE_HEX_QUAD"

    // $ANTLR start "RULE_HEXADECIMAL_DIGIT"
    public final void mRULE_HEXADECIMAL_DIGIT() throws RecognitionException {
        int RULE_HEXADECIMAL_DIGIT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return ; }
            // InternalCPreprocessLexer.g:121:33: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // InternalCPreprocessLexer.g:121:35: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 35, RULE_HEXADECIMAL_DIGIT_StartIndex); }
        }
    }
    // $ANTLR end "RULE_HEXADECIMAL_DIGIT"

    // $ANTLR start "RULE_SPECIAL"
    public final void mRULE_SPECIAL() throws RecognitionException {
        int RULE_SPECIAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return ; }
            // InternalCPreprocessLexer.g:123:23: ( FRAGMENT_RULE_SPECIAL )
            // InternalCPreprocessLexer.g:123:25: FRAGMENT_RULE_SPECIAL
            {
            mFRAGMENT_RULE_SPECIAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 36, RULE_SPECIAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SPECIAL"

    // $ANTLR start "FRAGMENT_RULE_SPECIAL"
    public final void mFRAGMENT_RULE_SPECIAL() throws RecognitionException {
        int FRAGMENT_RULE_SPECIAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return ; }
            // InternalCPreprocessLexer.g:124:32: ( . )
            // InternalCPreprocessLexer.g:124:34: .
            {
            matchAny(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 37, FRAGMENT_RULE_SPECIAL_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SPECIAL"

    public void mTokens() throws RecognitionException {
        // InternalCPreprocessLexer.g:1:8: ( SYNTHETIC_ALL_KEYWORDS )
        // InternalCPreprocessLexer.g:1:10: SYNTHETIC_ALL_KEYWORDS
        {
        mSYNTHETIC_ALL_KEYWORDS(); if (state.failed) return ;

        }


    }

    // $ANTLR start synpred1_InternalCPreprocessLexer
    public final void synpred1_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:50:2: ( FRAGMENT_RULE_HASH )
        // InternalCPreprocessLexer.g:50:3: FRAGMENT_RULE_HASH
        {
        mFRAGMENT_RULE_HASH(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalCPreprocessLexer

    // $ANTLR start synpred2_InternalCPreprocessLexer
    public final void synpred2_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:51:2: ( FRAGMENT_RULE_INCLUDE )
        // InternalCPreprocessLexer.g:51:3: FRAGMENT_RULE_INCLUDE
        {
        mFRAGMENT_RULE_INCLUDE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_InternalCPreprocessLexer

    // $ANTLR start synpred3_InternalCPreprocessLexer
    public final void synpred3_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:52:2: ( FRAGMENT_RULE_DEFINE )
        // InternalCPreprocessLexer.g:52:3: FRAGMENT_RULE_DEFINE
        {
        mFRAGMENT_RULE_DEFINE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_InternalCPreprocessLexer

    // $ANTLR start synpred4_InternalCPreprocessLexer
    public final void synpred4_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:53:2: ( FRAGMENT_RULE_ERROR )
        // InternalCPreprocessLexer.g:53:3: FRAGMENT_RULE_ERROR
        {
        mFRAGMENT_RULE_ERROR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_InternalCPreprocessLexer

    // $ANTLR start synpred5_InternalCPreprocessLexer
    public final void synpred5_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:54:2: ( FRAGMENT_RULE_UNDEF )
        // InternalCPreprocessLexer.g:54:3: FRAGMENT_RULE_UNDEF
        {
        mFRAGMENT_RULE_UNDEF(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_InternalCPreprocessLexer

    // $ANTLR start synpred6_InternalCPreprocessLexer
    public final void synpred6_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:55:2: ( FRAGMENT_RULE_PRAGMA )
        // InternalCPreprocessLexer.g:55:3: FRAGMENT_RULE_PRAGMA
        {
        mFRAGMENT_RULE_PRAGMA(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_InternalCPreprocessLexer

    // $ANTLR start synpred7_InternalCPreprocessLexer
    public final void synpred7_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:56:2: ( FRAGMENT_RULE_LPAREN )
        // InternalCPreprocessLexer.g:56:3: FRAGMENT_RULE_LPAREN
        {
        mFRAGMENT_RULE_LPAREN(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_InternalCPreprocessLexer

    // $ANTLR start synpred8_InternalCPreprocessLexer
    public final void synpred8_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:57:2: ( FRAGMENT_RULE_RPAREN )
        // InternalCPreprocessLexer.g:57:3: FRAGMENT_RULE_RPAREN
        {
        mFRAGMENT_RULE_RPAREN(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_InternalCPreprocessLexer

    // $ANTLR start synpred9_InternalCPreprocessLexer
    public final void synpred9_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:58:2: ( FRAGMENT_RULE_NEWLINE )
        // InternalCPreprocessLexer.g:58:3: FRAGMENT_RULE_NEWLINE
        {
        mFRAGMENT_RULE_NEWLINE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_InternalCPreprocessLexer

    // $ANTLR start synpred10_InternalCPreprocessLexer
    public final void synpred10_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:59:2: ( FRAGMENT_RULE_WS )
        // InternalCPreprocessLexer.g:59:3: FRAGMENT_RULE_WS
        {
        mFRAGMENT_RULE_WS(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_InternalCPreprocessLexer

    // $ANTLR start synpred11_InternalCPreprocessLexer
    public final void synpred11_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:60:2: ( FRAGMENT_RULE_ID )
        // InternalCPreprocessLexer.g:60:3: FRAGMENT_RULE_ID
        {
        mFRAGMENT_RULE_ID(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_InternalCPreprocessLexer

    // $ANTLR start synpred12_InternalCPreprocessLexer
    public final void synpred12_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:61:2: ( FRAGMENT_RULE_SPECIAL )
        // InternalCPreprocessLexer.g:61:3: FRAGMENT_RULE_SPECIAL
        {
        mFRAGMENT_RULE_SPECIAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_InternalCPreprocessLexer

    public final boolean synpred6_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\14\uffff\1\34\21\uffff";
    static final String DFA1_eofS =
        "\36\uffff";
    static final String DFA1_minS =
        "\2\0\1\156\1\145\1\162\1\156\1\162\5\0\1\12\1\0\20\uffff";
    static final String DFA1_maxS =
        "\1\uffff\1\0\1\156\1\145\1\162\1\156\1\162\5\0\1\165\1\0\20\uffff";
    static final String DFA1_acceptS =
        "\16\uffff\1\14\1\1\1\2\1\13\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\2\13\1\14\1\12";
    static final String DFA1_specialS =
        "\1\14\1\6\1\5\1\11\1\13\1\15\1\4\1\3\1\12\1\2\1\10\1\1\1\7\1\0\20\uffff}>";
    static final String[] DFA1_transitionS = {
            "\11\16\1\13\1\11\2\16\1\11\22\16\1\12\2\16\1\1\4\16\1\7\1\10\27\16\32\15\1\16\1\14\2\16\1\15\1\16\3\15\1\3\1\4\3\15\1\2\6\15\1\6\4\15\1\5\5\15\uff85\16",
            "\1\uffff",
            "\1\20",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\35\2\uffff\1\35\107\uffff\1\33\37\uffff\1\32",
            "\1\uffff",
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
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "49:1: SYNTHETIC_ALL_KEYWORDS : ( ( FRAGMENT_RULE_HASH )=> FRAGMENT_RULE_HASH | ( FRAGMENT_RULE_INCLUDE )=> FRAGMENT_RULE_INCLUDE | ( FRAGMENT_RULE_DEFINE )=> FRAGMENT_RULE_DEFINE | ( FRAGMENT_RULE_ERROR )=> FRAGMENT_RULE_ERROR | ( FRAGMENT_RULE_UNDEF )=> FRAGMENT_RULE_UNDEF | ( FRAGMENT_RULE_PRAGMA )=> FRAGMENT_RULE_PRAGMA | ( FRAGMENT_RULE_LPAREN )=> FRAGMENT_RULE_LPAREN | ( FRAGMENT_RULE_RPAREN )=> FRAGMENT_RULE_RPAREN | ( FRAGMENT_RULE_NEWLINE )=> FRAGMENT_RULE_NEWLINE | ( FRAGMENT_RULE_WS )=> FRAGMENT_RULE_WS | ( FRAGMENT_RULE_ID )=> FRAGMENT_RULE_ID | ( FRAGMENT_RULE_SPECIAL )=> FRAGMENT_RULE_SPECIAL );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA1_13 = input.LA(1);

                         
                        int index1_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalCPreprocessLexer()) ) {s = 27;}

                        else if ( (synpred12_InternalCPreprocessLexer()) ) {s = 28;}

                         
                        input.seek(index1_13);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA1_11 = input.LA(1);

                         
                        int index1_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalCPreprocessLexer()) ) {s = 25;}

                        else if ( (synpred12_InternalCPreprocessLexer()) ) {s = 14;}

                         
                        input.seek(index1_11);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA1_9 = input.LA(1);

                         
                        int index1_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalCPreprocessLexer()) ) {s = 24;}

                        else if ( (synpred12_InternalCPreprocessLexer()) ) {s = 14;}

                         
                        input.seek(index1_9);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA1_7 = input.LA(1);

                         
                        int index1_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalCPreprocessLexer()) ) {s = 22;}

                        else if ( (synpred12_InternalCPreprocessLexer()) ) {s = 14;}

                         
                        input.seek(index1_7);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA1_6 = input.LA(1);

                         
                        int index1_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_6=='r') && (synpred6_InternalCPreprocessLexer())) {s = 21;}

                        else if ( (synpred11_InternalCPreprocessLexer()) ) {s = 17;}

                        else if ( (synpred12_InternalCPreprocessLexer()) ) {s = 14;}

                         
                        input.seek(index1_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA1_2 = input.LA(1);

                         
                        int index1_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_2=='n') && (synpred2_InternalCPreprocessLexer())) {s = 16;}

                        else if ( (synpred11_InternalCPreprocessLexer()) ) {s = 17;}

                        else if ( (synpred12_InternalCPreprocessLexer()) ) {s = 14;}

                         
                        input.seek(index1_2);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA1_1 = input.LA(1);

                         
                        int index1_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalCPreprocessLexer()) ) {s = 15;}

                        else if ( (synpred12_InternalCPreprocessLexer()) ) {s = 14;}

                         
                        input.seek(index1_1);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA1_12 = input.LA(1);

                         
                        int index1_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_12=='u') && (synpred11_InternalCPreprocessLexer())) {s = 26;}

                        else if ( (LA1_12=='U') && (synpred11_InternalCPreprocessLexer())) {s = 27;}

                        else if ( (LA1_12=='\n'||LA1_12=='\r') && (synpred10_InternalCPreprocessLexer())) {s = 29;}

                        else s = 28;

                         
                        input.seek(index1_12);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA1_10 = input.LA(1);

                         
                        int index1_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalCPreprocessLexer()) ) {s = 25;}

                        else if ( (synpred12_InternalCPreprocessLexer()) ) {s = 14;}

                         
                        input.seek(index1_10);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA1_3 = input.LA(1);

                         
                        int index1_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_3=='e') && (synpred3_InternalCPreprocessLexer())) {s = 18;}

                        else if ( (synpred11_InternalCPreprocessLexer()) ) {s = 17;}

                        else if ( (synpred12_InternalCPreprocessLexer()) ) {s = 14;}

                         
                        input.seek(index1_3);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA1_8 = input.LA(1);

                         
                        int index1_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalCPreprocessLexer()) ) {s = 23;}

                        else if ( (synpred12_InternalCPreprocessLexer()) ) {s = 14;}

                         
                        input.seek(index1_8);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA1_4 = input.LA(1);

                         
                        int index1_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_4=='r') && (synpred4_InternalCPreprocessLexer())) {s = 19;}

                        else if ( (synpred11_InternalCPreprocessLexer()) ) {s = 17;}

                        else if ( (synpred12_InternalCPreprocessLexer()) ) {s = 14;}

                         
                        input.seek(index1_4);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA1_0 = input.LA(1);

                         
                        int index1_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_0=='#') ) {s = 1;}

                        else if ( (LA1_0=='i') ) {s = 2;}

                        else if ( (LA1_0=='d') ) {s = 3;}

                        else if ( (LA1_0=='e') ) {s = 4;}

                        else if ( (LA1_0=='u') ) {s = 5;}

                        else if ( (LA1_0=='p') ) {s = 6;}

                        else if ( (LA1_0=='(') ) {s = 7;}

                        else if ( (LA1_0==')') ) {s = 8;}

                        else if ( (LA1_0=='\n'||LA1_0=='\r') ) {s = 9;}

                        else if ( (LA1_0==' ') ) {s = 10;}

                        else if ( (LA1_0=='\t') ) {s = 11;}

                        else if ( (LA1_0=='\\') ) {s = 12;}

                        else if ( ((LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='c')||(LA1_0>='f' && LA1_0<='h')||(LA1_0>='j' && LA1_0<='o')||(LA1_0>='q' && LA1_0<='t')||(LA1_0>='v' && LA1_0<='z')) ) {s = 13;}

                        else if ( ((LA1_0>='\u0000' && LA1_0<='\b')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\u001F')||(LA1_0>='!' && LA1_0<='\"')||(LA1_0>='$' && LA1_0<='\'')||(LA1_0>='*' && LA1_0<='@')||LA1_0=='['||(LA1_0>=']' && LA1_0<='^')||LA1_0=='`'||(LA1_0>='{' && LA1_0<='\uFFFF')) && (synpred12_InternalCPreprocessLexer())) {s = 14;}

                         
                        input.seek(index1_0);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA1_5 = input.LA(1);

                         
                        int index1_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_5=='n') && (synpred5_InternalCPreprocessLexer())) {s = 20;}

                        else if ( (synpred11_InternalCPreprocessLexer()) ) {s = 17;}

                        else if ( (synpred12_InternalCPreprocessLexer()) ) {s = 14;}

                         
                        input.seek(index1_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 1, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}