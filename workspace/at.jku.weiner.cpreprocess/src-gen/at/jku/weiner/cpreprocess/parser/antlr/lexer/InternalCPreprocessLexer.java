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
    public static final int RULE_PRAGMA=13;
    public static final int FRAGMENT_RULE_SKW_MINUSMINUS=119;
    public static final int FRAGMENT_RULE_SKW_ASSIGN=101;
    public static final int RULE_ID=21;
    public static final int FRAGMENT_RULE_SKW_OR=123;
    public static final int RULE_SKW_DOT=48;
    public static final int FRAGMENT_RULE_SKW_NOTEQUAL=122;
    public static final int FRAGMENT_RULE_OCTAL_LITERAL=96;
    public static final int RULE_SKW_GREATEREQUAL=52;
    public static final int RULE_SKW_PLUS=66;
    public static final int EOF=-1;
    public static final int RULE_SKW_LESS=57;
    public static final int FRAGMENT_RULE_SKW_CARET=103;
    public static final int RULE_SKW_RIGHTPAREN=71;
    public static final int RULE_ENDIF=12;
    public static final int FRAGMENT_RULE_SKW_RIGHTBRACKET=129;
    public static final int RULE_LINEBREAK=17;
    public static final int FRAGMENT_RULE_SKW_LEFTSHIFT=115;
    public static final int RULE_SKW_LESSEQUAL=58;
    public static final int RULE_DECIMAL_LITERAL=27;
    public static final int RULE_HEX_LITERAL=26;
    public static final int RULE_SKW_AND=39;
    public static final int FRAGMENT_RULE_SKW_QUESTION=127;
    public static final int RULE_OCTAL_LITERAL=28;
    public static final int RULE_SKW_COMMA=44;
    public static final int RULE_BLOCK_COMMENT=37;
    public static final int RULE_SKW_COLON=45;
    public static final int RULE_BIN_LITERAL=29;
    public static final int RULE_SKW_LEFTPAREN=55;
    public static final int FRAGMENT_RULE_SKW_SINGLEQUOTE=133;
    public static final int FRAGMENT_RULE_SKW_EQUAL=109;
    public static final int RULE_SKW_MINUS=59;
    public static final int RULE_IFDEF=10;
    public static final int FRAGMENT_RULE_IFNOTDEF=86;
    public static final int FRAGMENT_RULE_SKW_NOT=121;
    public static final int FRAGMENT_RULE_NEWLINE=89;
    public static final int RULE_SKW_EQUAL=50;
    public static final int FRAGMENT_RULE_IF=84;
    public static final int FRAGMENT_RULE_SKW_RIGHTBRACE=128;
    public static final int RULE_SKW_ANDAND=40;
    public static final int RULE_SKW_DIV=46;
    public static final int FRAGMENT_RULE_ID=91;
    public static final int RULE_HEX_DIGIT=30;
    public static final int RULE_SKW_GREATER=51;
    public static final int RULE_HASH=4;
    public static final int RULE_TAB=19;
    public static final int RULE_SKW_LEFTBRACKET=54;
    public static final int FRAGMENT_RULE_INCLUDE=80;
    public static final int FRAGMENT_RULE_SKW_LEFTPAREN=114;
    public static final int RULE_LETTER=23;
    public static final int FRAGMENT_RULE_SKW_COMMA=104;
    public static final int FRAGMENT_RULE_BIN_LITERAL=97;
    public static final int RULE_EXPONENT=33;
    public static final int RULE_DEFINE=6;
    public static final int RULE_SPECIAL=78;
    public static final int FRAGMENT_RULE_IFDEF=85;
    public static final int RULE_INCLUDE=5;
    public static final int FRAGMENT_RULE_SKW_PLUSPLUS=126;
    public static final int FRAGMENT_RULE_SKW_ANDAND=100;
    public static final int FRAGMENT_RULE_ERROR=82;
    public static final int RULE_SKW_UNDERSCORE=77;
    public static final int FRAGMENT_RULE_SKW_BACKSLASH=102;
    public static final int RULE_IF=9;
    public static final int FRAGMENT_RULE_FLOAT_LITERAL=98;
    public static final int FRAGMENT_RULE_SKW_RIGHTSHIFT=131;
    public static final int FRAGMENT_RULE_SKW_GREATER=110;
    public static final int FRAGMENT_RULE_SKW_DOUBLEQUOTE=108;
    public static final int RULE_OCTAL_ESCAPE=36;
    public static final int RULE_SKW_NOT=62;
    public static final int RULE_ESCAPE_SEQUENCE=35;
    public static final int RULE_SKW_RIGHTSHIFT=72;
    public static final int RULE_SKW_NOTEQUAL=63;
    public static final int FRAGMENT_RULE_SKW_LESS=116;
    public static final int FRAGMENT_RULE_SKW_GREATEREQUAL=111;
    public static final int RULE_SKW_RIGHTBRACE=69;
    public static final int FRAGMENT_RULE_SKW_OROR=124;
    public static final int RULE_SKW_STAR=75;
    public static final int FRAGMENT_RULE_SKW_STAR=134;
    public static final int RULE_STRING_LITERAL=25;
    public static final int FRAGMENT_RULE_ENDIF=87;
    public static final int RULE_SKW_DOUBLEQUOTE=49;
    public static final int RULE_SKW_PLUSPLUS=67;
    public static final int RULE_SKW_OROR=65;
    public static final int FRAGMENT_RULE_SKW_DIV=106;
    public static final int RULE_SKW_CARET=43;
    public static final int FRAGMENT_RULE_DEFINE=81;
    public static final int RULE_SKW_RIGHTBRACKET=70;
    public static final int FRAGMENT_RULE_CHAR_LITERAL=92;
    public static final int RULE_SPACE=18;
    public static final int FRAGMENT_RULE_STRING_LITERAL=93;
    public static final int RULE_LINEFEED=14;
    public static final int FRAGMENT_RULE_HASH=79;
    public static final int RULE_SKW_SEMI=73;
    public static final int RULE_NEWLINE=16;
    public static final int FRAGMENT_RULE_SKW_MOD=120;
    public static final int RULE_SKW_DOLLAR=47;
    public static final int RULE_SKW_LEFTSHIFT=56;
    public static final int RULE_SKW_QUESTION=68;
    public static final int RULE_ERROR=7;
    public static final int RULE_IDENTIFIER=22;
    public static final int FRAGMENT_RULE_SPECIAL=136;
    public static final int FRAGMENT_RULE_SKW_MINUS=118;
    public static final int RULE_SKW_SINGLEQUOTE=74;
    public static final int FRAGMENT_RULE_SKW_COLON=105;
    public static final int RULE_UNDEF=8;
    public static final int RULE_SKW_MOD=61;
    public static final int FRAGMENT_RULE_SKW_PLUS=125;
    public static final int FRAGMENT_RULE_HEX_LITERAL=94;
    public static final int FRAGMENT_RULE_PRAGMA=88;
    public static final int RULE_SKW_MINUSMINUS=60;
    public static final int FRAGMENT_RULE_SKW_RIGHTPAREN=130;
    public static final int FRAGMENT_RULE_SKW_LEFTBRACKET=113;
    public static final int SYNTHETIC_ALL_KEYWORDS=137;
    public static final int RULE_FLOAT_TYPE_SUFFIX=34;
    public static final int RULE_IFNOTDEF=11;
    public static final int FRAGMENT_RULE_SKW_SEMI=132;
    public static final int RULE_INTEGER_TYPE_SUFFIX=31;
    public static final int FRAGMENT_RULE_SKW_LEFTBRACE=112;
    public static final int RULE_CARRIAGERETURN=15;
    public static final int FRAGMENT_RULE_SKW_DOT=107;
    public static final int FRAGMENT_RULE_UNDEF=83;
    public static final int FRAGMENT_RULE_SKW_AND=99;
    public static final int RULE_SKW_TILDE=76;
    public static final int RULE_LINE_COMMENT=38;
    public static final int RULE_SKW_BACKSLASH=42;
    public static final int RULE_SKW_OR=64;
    public static final int FRAGMENT_RULE_DECIMAL_LITERAL=95;
    public static final int RULE_CHAR_LITERAL=24;
    public static final int FRAGMENT_RULE_WS=90;
    public static final int RULE_WS=20;
    public static final int FRAGMENT_RULE_SKW_TILDE=135;
    public static final int RULE_FLOAT_LITERAL=32;
    public static final int RULE_SKW_LEFTBRACE=53;
    public static final int FRAGMENT_RULE_SKW_LESSEQUAL=117;
    public static final int RULE_SKW_ASSIGN=41;

    // delegates
    // delegators

    public InternalCPreprocessLexer() {;} 
    public InternalCPreprocessLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalCPreprocessLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
        state.ruleMemo = new HashMap[261+1];
 
    }
    public String getGrammarFileName() { return "InternalCPreprocessLexer.g"; }

    // $ANTLR start "SYNTHETIC_ALL_KEYWORDS"
    public final void mSYNTHETIC_ALL_KEYWORDS() throws RecognitionException {
        int SYNTHETIC_ALL_KEYWORDS_StartIndex = input.index();
        try {
            int _type = SYNTHETIC_ALL_KEYWORDS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return ; }
            // InternalCPreprocessLexer.g:100:24: ( ( FRAGMENT_RULE_HASH )=> FRAGMENT_RULE_HASH | ( FRAGMENT_RULE_INCLUDE )=> FRAGMENT_RULE_INCLUDE | ( FRAGMENT_RULE_DEFINE )=> FRAGMENT_RULE_DEFINE | ( FRAGMENT_RULE_ERROR )=> FRAGMENT_RULE_ERROR | ( FRAGMENT_RULE_UNDEF )=> FRAGMENT_RULE_UNDEF | ( FRAGMENT_RULE_IF )=> FRAGMENT_RULE_IF | ( FRAGMENT_RULE_IFDEF )=> FRAGMENT_RULE_IFDEF | ( FRAGMENT_RULE_IFNOTDEF )=> FRAGMENT_RULE_IFNOTDEF | ( FRAGMENT_RULE_ENDIF )=> FRAGMENT_RULE_ENDIF | ( FRAGMENT_RULE_PRAGMA )=> FRAGMENT_RULE_PRAGMA | ( FRAGMENT_RULE_NEWLINE )=> FRAGMENT_RULE_NEWLINE | ( FRAGMENT_RULE_WS )=> FRAGMENT_RULE_WS | ( FRAGMENT_RULE_ID )=> FRAGMENT_RULE_ID | ( FRAGMENT_RULE_CHAR_LITERAL )=> FRAGMENT_RULE_CHAR_LITERAL | ( FRAGMENT_RULE_STRING_LITERAL )=> FRAGMENT_RULE_STRING_LITERAL | ( FRAGMENT_RULE_HEX_LITERAL )=> FRAGMENT_RULE_HEX_LITERAL | ( FRAGMENT_RULE_DECIMAL_LITERAL )=> FRAGMENT_RULE_DECIMAL_LITERAL | ( FRAGMENT_RULE_OCTAL_LITERAL )=> FRAGMENT_RULE_OCTAL_LITERAL | ( FRAGMENT_RULE_BIN_LITERAL )=> FRAGMENT_RULE_BIN_LITERAL | ( FRAGMENT_RULE_FLOAT_LITERAL )=> FRAGMENT_RULE_FLOAT_LITERAL | ( FRAGMENT_RULE_SKW_AND )=> FRAGMENT_RULE_SKW_AND | ( FRAGMENT_RULE_SKW_ANDAND )=> FRAGMENT_RULE_SKW_ANDAND | ( FRAGMENT_RULE_SKW_ASSIGN )=> FRAGMENT_RULE_SKW_ASSIGN | ( FRAGMENT_RULE_SKW_BACKSLASH )=> FRAGMENT_RULE_SKW_BACKSLASH | ( FRAGMENT_RULE_SKW_CARET )=> FRAGMENT_RULE_SKW_CARET | ( FRAGMENT_RULE_SKW_COMMA )=> FRAGMENT_RULE_SKW_COMMA | ( FRAGMENT_RULE_SKW_COLON )=> FRAGMENT_RULE_SKW_COLON | ( FRAGMENT_RULE_SKW_DIV )=> FRAGMENT_RULE_SKW_DIV | ( FRAGMENT_RULE_SKW_DOT )=> FRAGMENT_RULE_SKW_DOT | ( FRAGMENT_RULE_SKW_DOUBLEQUOTE )=> FRAGMENT_RULE_SKW_DOUBLEQUOTE | ( FRAGMENT_RULE_SKW_EQUAL )=> FRAGMENT_RULE_SKW_EQUAL | ( FRAGMENT_RULE_SKW_GREATER )=> FRAGMENT_RULE_SKW_GREATER | ( FRAGMENT_RULE_SKW_GREATEREQUAL )=> FRAGMENT_RULE_SKW_GREATEREQUAL | ( FRAGMENT_RULE_SKW_LEFTBRACE )=> FRAGMENT_RULE_SKW_LEFTBRACE | ( FRAGMENT_RULE_SKW_LEFTBRACKET )=> FRAGMENT_RULE_SKW_LEFTBRACKET | ( FRAGMENT_RULE_SKW_LEFTPAREN )=> FRAGMENT_RULE_SKW_LEFTPAREN | ( FRAGMENT_RULE_SKW_LEFTSHIFT )=> FRAGMENT_RULE_SKW_LEFTSHIFT | ( FRAGMENT_RULE_SKW_LESS )=> FRAGMENT_RULE_SKW_LESS | ( FRAGMENT_RULE_SKW_LESSEQUAL )=> FRAGMENT_RULE_SKW_LESSEQUAL | ( FRAGMENT_RULE_SKW_MINUS )=> FRAGMENT_RULE_SKW_MINUS | ( FRAGMENT_RULE_SKW_MINUSMINUS )=> FRAGMENT_RULE_SKW_MINUSMINUS | ( FRAGMENT_RULE_SKW_MOD )=> FRAGMENT_RULE_SKW_MOD | ( FRAGMENT_RULE_SKW_NOT )=> FRAGMENT_RULE_SKW_NOT | ( FRAGMENT_RULE_SKW_NOTEQUAL )=> FRAGMENT_RULE_SKW_NOTEQUAL | ( FRAGMENT_RULE_SKW_OR )=> FRAGMENT_RULE_SKW_OR | ( FRAGMENT_RULE_SKW_OROR )=> FRAGMENT_RULE_SKW_OROR | ( FRAGMENT_RULE_SKW_PLUS )=> FRAGMENT_RULE_SKW_PLUS | ( FRAGMENT_RULE_SKW_PLUSPLUS )=> FRAGMENT_RULE_SKW_PLUSPLUS | ( FRAGMENT_RULE_SKW_QUESTION )=> FRAGMENT_RULE_SKW_QUESTION | ( FRAGMENT_RULE_SKW_RIGHTBRACE )=> FRAGMENT_RULE_SKW_RIGHTBRACE | ( FRAGMENT_RULE_SKW_RIGHTBRACKET )=> FRAGMENT_RULE_SKW_RIGHTBRACKET | ( FRAGMENT_RULE_SKW_RIGHTPAREN )=> FRAGMENT_RULE_SKW_RIGHTPAREN | ( FRAGMENT_RULE_SKW_RIGHTSHIFT )=> FRAGMENT_RULE_SKW_RIGHTSHIFT | ( FRAGMENT_RULE_SKW_SEMI )=> FRAGMENT_RULE_SKW_SEMI | ( FRAGMENT_RULE_SKW_SINGLEQUOTE )=> FRAGMENT_RULE_SKW_SINGLEQUOTE | ( FRAGMENT_RULE_SKW_STAR )=> FRAGMENT_RULE_SKW_STAR | ( FRAGMENT_RULE_SKW_TILDE )=> FRAGMENT_RULE_SKW_TILDE | ( FRAGMENT_RULE_SPECIAL )=> FRAGMENT_RULE_SPECIAL )
            int alt1=58;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalCPreprocessLexer.g:101:2: ( FRAGMENT_RULE_HASH )=> FRAGMENT_RULE_HASH
                    {
                    mFRAGMENT_RULE_HASH(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_HASH; 
                    }

                    }
                    break;
                case 2 :
                    // InternalCPreprocessLexer.g:102:2: ( FRAGMENT_RULE_INCLUDE )=> FRAGMENT_RULE_INCLUDE
                    {
                    mFRAGMENT_RULE_INCLUDE(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_INCLUDE; 
                    }

                    }
                    break;
                case 3 :
                    // InternalCPreprocessLexer.g:103:2: ( FRAGMENT_RULE_DEFINE )=> FRAGMENT_RULE_DEFINE
                    {
                    mFRAGMENT_RULE_DEFINE(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_DEFINE; 
                    }

                    }
                    break;
                case 4 :
                    // InternalCPreprocessLexer.g:104:2: ( FRAGMENT_RULE_ERROR )=> FRAGMENT_RULE_ERROR
                    {
                    mFRAGMENT_RULE_ERROR(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_ERROR; 
                    }

                    }
                    break;
                case 5 :
                    // InternalCPreprocessLexer.g:105:2: ( FRAGMENT_RULE_UNDEF )=> FRAGMENT_RULE_UNDEF
                    {
                    mFRAGMENT_RULE_UNDEF(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_UNDEF; 
                    }

                    }
                    break;
                case 6 :
                    // InternalCPreprocessLexer.g:106:2: ( FRAGMENT_RULE_IF )=> FRAGMENT_RULE_IF
                    {
                    mFRAGMENT_RULE_IF(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_IF; 
                    }

                    }
                    break;
                case 7 :
                    // InternalCPreprocessLexer.g:107:2: ( FRAGMENT_RULE_IFDEF )=> FRAGMENT_RULE_IFDEF
                    {
                    mFRAGMENT_RULE_IFDEF(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_IFDEF; 
                    }

                    }
                    break;
                case 8 :
                    // InternalCPreprocessLexer.g:108:2: ( FRAGMENT_RULE_IFNOTDEF )=> FRAGMENT_RULE_IFNOTDEF
                    {
                    mFRAGMENT_RULE_IFNOTDEF(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_IFNOTDEF; 
                    }

                    }
                    break;
                case 9 :
                    // InternalCPreprocessLexer.g:109:2: ( FRAGMENT_RULE_ENDIF )=> FRAGMENT_RULE_ENDIF
                    {
                    mFRAGMENT_RULE_ENDIF(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_ENDIF; 
                    }

                    }
                    break;
                case 10 :
                    // InternalCPreprocessLexer.g:110:2: ( FRAGMENT_RULE_PRAGMA )=> FRAGMENT_RULE_PRAGMA
                    {
                    mFRAGMENT_RULE_PRAGMA(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_PRAGMA; 
                    }

                    }
                    break;
                case 11 :
                    // InternalCPreprocessLexer.g:111:2: ( FRAGMENT_RULE_NEWLINE )=> FRAGMENT_RULE_NEWLINE
                    {
                    mFRAGMENT_RULE_NEWLINE(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_NEWLINE; 
                    }

                    }
                    break;
                case 12 :
                    // InternalCPreprocessLexer.g:112:2: ( FRAGMENT_RULE_WS )=> FRAGMENT_RULE_WS
                    {
                    mFRAGMENT_RULE_WS(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_WS; 
                    }

                    }
                    break;
                case 13 :
                    // InternalCPreprocessLexer.g:113:2: ( FRAGMENT_RULE_ID )=> FRAGMENT_RULE_ID
                    {
                    mFRAGMENT_RULE_ID(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_ID; 
                    }

                    }
                    break;
                case 14 :
                    // InternalCPreprocessLexer.g:114:2: ( FRAGMENT_RULE_CHAR_LITERAL )=> FRAGMENT_RULE_CHAR_LITERAL
                    {
                    mFRAGMENT_RULE_CHAR_LITERAL(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_CHAR_LITERAL; 
                    }

                    }
                    break;
                case 15 :
                    // InternalCPreprocessLexer.g:115:2: ( FRAGMENT_RULE_STRING_LITERAL )=> FRAGMENT_RULE_STRING_LITERAL
                    {
                    mFRAGMENT_RULE_STRING_LITERAL(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_STRING_LITERAL; 
                    }

                    }
                    break;
                case 16 :
                    // InternalCPreprocessLexer.g:116:2: ( FRAGMENT_RULE_HEX_LITERAL )=> FRAGMENT_RULE_HEX_LITERAL
                    {
                    mFRAGMENT_RULE_HEX_LITERAL(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_HEX_LITERAL; 
                    }

                    }
                    break;
                case 17 :
                    // InternalCPreprocessLexer.g:117:2: ( FRAGMENT_RULE_DECIMAL_LITERAL )=> FRAGMENT_RULE_DECIMAL_LITERAL
                    {
                    mFRAGMENT_RULE_DECIMAL_LITERAL(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_DECIMAL_LITERAL; 
                    }

                    }
                    break;
                case 18 :
                    // InternalCPreprocessLexer.g:118:2: ( FRAGMENT_RULE_OCTAL_LITERAL )=> FRAGMENT_RULE_OCTAL_LITERAL
                    {
                    mFRAGMENT_RULE_OCTAL_LITERAL(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_OCTAL_LITERAL; 
                    }

                    }
                    break;
                case 19 :
                    // InternalCPreprocessLexer.g:119:2: ( FRAGMENT_RULE_BIN_LITERAL )=> FRAGMENT_RULE_BIN_LITERAL
                    {
                    mFRAGMENT_RULE_BIN_LITERAL(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_BIN_LITERAL; 
                    }

                    }
                    break;
                case 20 :
                    // InternalCPreprocessLexer.g:120:2: ( FRAGMENT_RULE_FLOAT_LITERAL )=> FRAGMENT_RULE_FLOAT_LITERAL
                    {
                    mFRAGMENT_RULE_FLOAT_LITERAL(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_FLOAT_LITERAL; 
                    }

                    }
                    break;
                case 21 :
                    // InternalCPreprocessLexer.g:121:2: ( FRAGMENT_RULE_SKW_AND )=> FRAGMENT_RULE_SKW_AND
                    {
                    mFRAGMENT_RULE_SKW_AND(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_AND; 
                    }

                    }
                    break;
                case 22 :
                    // InternalCPreprocessLexer.g:122:2: ( FRAGMENT_RULE_SKW_ANDAND )=> FRAGMENT_RULE_SKW_ANDAND
                    {
                    mFRAGMENT_RULE_SKW_ANDAND(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_ANDAND; 
                    }

                    }
                    break;
                case 23 :
                    // InternalCPreprocessLexer.g:123:2: ( FRAGMENT_RULE_SKW_ASSIGN )=> FRAGMENT_RULE_SKW_ASSIGN
                    {
                    mFRAGMENT_RULE_SKW_ASSIGN(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_ASSIGN; 
                    }

                    }
                    break;
                case 24 :
                    // InternalCPreprocessLexer.g:124:2: ( FRAGMENT_RULE_SKW_BACKSLASH )=> FRAGMENT_RULE_SKW_BACKSLASH
                    {
                    mFRAGMENT_RULE_SKW_BACKSLASH(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_BACKSLASH; 
                    }

                    }
                    break;
                case 25 :
                    // InternalCPreprocessLexer.g:125:2: ( FRAGMENT_RULE_SKW_CARET )=> FRAGMENT_RULE_SKW_CARET
                    {
                    mFRAGMENT_RULE_SKW_CARET(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_CARET; 
                    }

                    }
                    break;
                case 26 :
                    // InternalCPreprocessLexer.g:126:2: ( FRAGMENT_RULE_SKW_COMMA )=> FRAGMENT_RULE_SKW_COMMA
                    {
                    mFRAGMENT_RULE_SKW_COMMA(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_COMMA; 
                    }

                    }
                    break;
                case 27 :
                    // InternalCPreprocessLexer.g:127:2: ( FRAGMENT_RULE_SKW_COLON )=> FRAGMENT_RULE_SKW_COLON
                    {
                    mFRAGMENT_RULE_SKW_COLON(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_COLON; 
                    }

                    }
                    break;
                case 28 :
                    // InternalCPreprocessLexer.g:128:2: ( FRAGMENT_RULE_SKW_DIV )=> FRAGMENT_RULE_SKW_DIV
                    {
                    mFRAGMENT_RULE_SKW_DIV(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_DIV; 
                    }

                    }
                    break;
                case 29 :
                    // InternalCPreprocessLexer.g:129:2: ( FRAGMENT_RULE_SKW_DOT )=> FRAGMENT_RULE_SKW_DOT
                    {
                    mFRAGMENT_RULE_SKW_DOT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_DOT; 
                    }

                    }
                    break;
                case 30 :
                    // InternalCPreprocessLexer.g:130:2: ( FRAGMENT_RULE_SKW_DOUBLEQUOTE )=> FRAGMENT_RULE_SKW_DOUBLEQUOTE
                    {
                    mFRAGMENT_RULE_SKW_DOUBLEQUOTE(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_DOUBLEQUOTE; 
                    }

                    }
                    break;
                case 31 :
                    // InternalCPreprocessLexer.g:131:2: ( FRAGMENT_RULE_SKW_EQUAL )=> FRAGMENT_RULE_SKW_EQUAL
                    {
                    mFRAGMENT_RULE_SKW_EQUAL(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_EQUAL; 
                    }

                    }
                    break;
                case 32 :
                    // InternalCPreprocessLexer.g:132:2: ( FRAGMENT_RULE_SKW_GREATER )=> FRAGMENT_RULE_SKW_GREATER
                    {
                    mFRAGMENT_RULE_SKW_GREATER(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_GREATER; 
                    }

                    }
                    break;
                case 33 :
                    // InternalCPreprocessLexer.g:133:2: ( FRAGMENT_RULE_SKW_GREATEREQUAL )=> FRAGMENT_RULE_SKW_GREATEREQUAL
                    {
                    mFRAGMENT_RULE_SKW_GREATEREQUAL(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_GREATEREQUAL; 
                    }

                    }
                    break;
                case 34 :
                    // InternalCPreprocessLexer.g:134:2: ( FRAGMENT_RULE_SKW_LEFTBRACE )=> FRAGMENT_RULE_SKW_LEFTBRACE
                    {
                    mFRAGMENT_RULE_SKW_LEFTBRACE(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_LEFTBRACE; 
                    }

                    }
                    break;
                case 35 :
                    // InternalCPreprocessLexer.g:135:2: ( FRAGMENT_RULE_SKW_LEFTBRACKET )=> FRAGMENT_RULE_SKW_LEFTBRACKET
                    {
                    mFRAGMENT_RULE_SKW_LEFTBRACKET(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_LEFTBRACKET; 
                    }

                    }
                    break;
                case 36 :
                    // InternalCPreprocessLexer.g:136:2: ( FRAGMENT_RULE_SKW_LEFTPAREN )=> FRAGMENT_RULE_SKW_LEFTPAREN
                    {
                    mFRAGMENT_RULE_SKW_LEFTPAREN(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_LEFTPAREN; 
                    }

                    }
                    break;
                case 37 :
                    // InternalCPreprocessLexer.g:137:2: ( FRAGMENT_RULE_SKW_LEFTSHIFT )=> FRAGMENT_RULE_SKW_LEFTSHIFT
                    {
                    mFRAGMENT_RULE_SKW_LEFTSHIFT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_LEFTSHIFT; 
                    }

                    }
                    break;
                case 38 :
                    // InternalCPreprocessLexer.g:138:2: ( FRAGMENT_RULE_SKW_LESS )=> FRAGMENT_RULE_SKW_LESS
                    {
                    mFRAGMENT_RULE_SKW_LESS(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_LESS; 
                    }

                    }
                    break;
                case 39 :
                    // InternalCPreprocessLexer.g:139:2: ( FRAGMENT_RULE_SKW_LESSEQUAL )=> FRAGMENT_RULE_SKW_LESSEQUAL
                    {
                    mFRAGMENT_RULE_SKW_LESSEQUAL(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_LESSEQUAL; 
                    }

                    }
                    break;
                case 40 :
                    // InternalCPreprocessLexer.g:140:2: ( FRAGMENT_RULE_SKW_MINUS )=> FRAGMENT_RULE_SKW_MINUS
                    {
                    mFRAGMENT_RULE_SKW_MINUS(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_MINUS; 
                    }

                    }
                    break;
                case 41 :
                    // InternalCPreprocessLexer.g:141:2: ( FRAGMENT_RULE_SKW_MINUSMINUS )=> FRAGMENT_RULE_SKW_MINUSMINUS
                    {
                    mFRAGMENT_RULE_SKW_MINUSMINUS(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_MINUSMINUS; 
                    }

                    }
                    break;
                case 42 :
                    // InternalCPreprocessLexer.g:142:2: ( FRAGMENT_RULE_SKW_MOD )=> FRAGMENT_RULE_SKW_MOD
                    {
                    mFRAGMENT_RULE_SKW_MOD(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_MOD; 
                    }

                    }
                    break;
                case 43 :
                    // InternalCPreprocessLexer.g:143:2: ( FRAGMENT_RULE_SKW_NOT )=> FRAGMENT_RULE_SKW_NOT
                    {
                    mFRAGMENT_RULE_SKW_NOT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_NOT; 
                    }

                    }
                    break;
                case 44 :
                    // InternalCPreprocessLexer.g:144:2: ( FRAGMENT_RULE_SKW_NOTEQUAL )=> FRAGMENT_RULE_SKW_NOTEQUAL
                    {
                    mFRAGMENT_RULE_SKW_NOTEQUAL(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_NOTEQUAL; 
                    }

                    }
                    break;
                case 45 :
                    // InternalCPreprocessLexer.g:145:2: ( FRAGMENT_RULE_SKW_OR )=> FRAGMENT_RULE_SKW_OR
                    {
                    mFRAGMENT_RULE_SKW_OR(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_OR; 
                    }

                    }
                    break;
                case 46 :
                    // InternalCPreprocessLexer.g:146:2: ( FRAGMENT_RULE_SKW_OROR )=> FRAGMENT_RULE_SKW_OROR
                    {
                    mFRAGMENT_RULE_SKW_OROR(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_OROR; 
                    }

                    }
                    break;
                case 47 :
                    // InternalCPreprocessLexer.g:147:2: ( FRAGMENT_RULE_SKW_PLUS )=> FRAGMENT_RULE_SKW_PLUS
                    {
                    mFRAGMENT_RULE_SKW_PLUS(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_PLUS; 
                    }

                    }
                    break;
                case 48 :
                    // InternalCPreprocessLexer.g:148:2: ( FRAGMENT_RULE_SKW_PLUSPLUS )=> FRAGMENT_RULE_SKW_PLUSPLUS
                    {
                    mFRAGMENT_RULE_SKW_PLUSPLUS(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_PLUSPLUS; 
                    }

                    }
                    break;
                case 49 :
                    // InternalCPreprocessLexer.g:149:2: ( FRAGMENT_RULE_SKW_QUESTION )=> FRAGMENT_RULE_SKW_QUESTION
                    {
                    mFRAGMENT_RULE_SKW_QUESTION(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_QUESTION; 
                    }

                    }
                    break;
                case 50 :
                    // InternalCPreprocessLexer.g:150:2: ( FRAGMENT_RULE_SKW_RIGHTBRACE )=> FRAGMENT_RULE_SKW_RIGHTBRACE
                    {
                    mFRAGMENT_RULE_SKW_RIGHTBRACE(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_RIGHTBRACE; 
                    }

                    }
                    break;
                case 51 :
                    // InternalCPreprocessLexer.g:151:2: ( FRAGMENT_RULE_SKW_RIGHTBRACKET )=> FRAGMENT_RULE_SKW_RIGHTBRACKET
                    {
                    mFRAGMENT_RULE_SKW_RIGHTBRACKET(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_RIGHTBRACKET; 
                    }

                    }
                    break;
                case 52 :
                    // InternalCPreprocessLexer.g:152:2: ( FRAGMENT_RULE_SKW_RIGHTPAREN )=> FRAGMENT_RULE_SKW_RIGHTPAREN
                    {
                    mFRAGMENT_RULE_SKW_RIGHTPAREN(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_RIGHTPAREN; 
                    }

                    }
                    break;
                case 53 :
                    // InternalCPreprocessLexer.g:153:2: ( FRAGMENT_RULE_SKW_RIGHTSHIFT )=> FRAGMENT_RULE_SKW_RIGHTSHIFT
                    {
                    mFRAGMENT_RULE_SKW_RIGHTSHIFT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_RIGHTSHIFT; 
                    }

                    }
                    break;
                case 54 :
                    // InternalCPreprocessLexer.g:154:2: ( FRAGMENT_RULE_SKW_SEMI )=> FRAGMENT_RULE_SKW_SEMI
                    {
                    mFRAGMENT_RULE_SKW_SEMI(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_SEMI; 
                    }

                    }
                    break;
                case 55 :
                    // InternalCPreprocessLexer.g:155:2: ( FRAGMENT_RULE_SKW_SINGLEQUOTE )=> FRAGMENT_RULE_SKW_SINGLEQUOTE
                    {
                    mFRAGMENT_RULE_SKW_SINGLEQUOTE(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_SINGLEQUOTE; 
                    }

                    }
                    break;
                case 56 :
                    // InternalCPreprocessLexer.g:156:2: ( FRAGMENT_RULE_SKW_STAR )=> FRAGMENT_RULE_SKW_STAR
                    {
                    mFRAGMENT_RULE_SKW_STAR(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_STAR; 
                    }

                    }
                    break;
                case 57 :
                    // InternalCPreprocessLexer.g:157:2: ( FRAGMENT_RULE_SKW_TILDE )=> FRAGMENT_RULE_SKW_TILDE
                    {
                    mFRAGMENT_RULE_SKW_TILDE(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_TILDE; 
                    }

                    }
                    break;
                case 58 :
                    // InternalCPreprocessLexer.g:158:2: ( FRAGMENT_RULE_SPECIAL )=> FRAGMENT_RULE_SPECIAL
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
            // InternalCPreprocessLexer.g:163:20: ( FRAGMENT_RULE_HASH )
            // InternalCPreprocessLexer.g:163:22: FRAGMENT_RULE_HASH
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
            // InternalCPreprocessLexer.g:164:29: ( '#' )
            // InternalCPreprocessLexer.g:164:31: '#'
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
            // InternalCPreprocessLexer.g:166:23: ( FRAGMENT_RULE_INCLUDE )
            // InternalCPreprocessLexer.g:166:25: FRAGMENT_RULE_INCLUDE
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
            // InternalCPreprocessLexer.g:167:32: ( 'include' )
            // InternalCPreprocessLexer.g:167:34: 'include'
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
            // InternalCPreprocessLexer.g:169:22: ( FRAGMENT_RULE_DEFINE )
            // InternalCPreprocessLexer.g:169:24: FRAGMENT_RULE_DEFINE
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
            // InternalCPreprocessLexer.g:170:31: ( 'define' )
            // InternalCPreprocessLexer.g:170:33: 'define'
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
            // InternalCPreprocessLexer.g:172:21: ( FRAGMENT_RULE_ERROR )
            // InternalCPreprocessLexer.g:172:23: FRAGMENT_RULE_ERROR
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
            // InternalCPreprocessLexer.g:173:30: ( 'error' )
            // InternalCPreprocessLexer.g:173:32: 'error'
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
            // InternalCPreprocessLexer.g:175:21: ( FRAGMENT_RULE_UNDEF )
            // InternalCPreprocessLexer.g:175:23: FRAGMENT_RULE_UNDEF
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
            // InternalCPreprocessLexer.g:176:30: ( 'undef' )
            // InternalCPreprocessLexer.g:176:32: 'undef'
            {
            match("undef"); if (state.failed) return ;


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, FRAGMENT_RULE_UNDEF_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_UNDEF"

    // $ANTLR start "RULE_IF"
    public final void mRULE_IF() throws RecognitionException {
        int RULE_IF_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return ; }
            // InternalCPreprocessLexer.g:178:18: ( FRAGMENT_RULE_IF )
            // InternalCPreprocessLexer.g:178:20: FRAGMENT_RULE_IF
            {
            mFRAGMENT_RULE_IF(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, RULE_IF_StartIndex); }
        }
    }
    // $ANTLR end "RULE_IF"

    // $ANTLR start "FRAGMENT_RULE_IF"
    public final void mFRAGMENT_RULE_IF() throws RecognitionException {
        int FRAGMENT_RULE_IF_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return ; }
            // InternalCPreprocessLexer.g:179:27: ( 'if' )
            // InternalCPreprocessLexer.g:179:29: 'if'
            {
            match("if"); if (state.failed) return ;


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, FRAGMENT_RULE_IF_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_IF"

    // $ANTLR start "RULE_IFDEF"
    public final void mRULE_IFDEF() throws RecognitionException {
        int RULE_IFDEF_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return ; }
            // InternalCPreprocessLexer.g:181:21: ( FRAGMENT_RULE_IFDEF )
            // InternalCPreprocessLexer.g:181:23: FRAGMENT_RULE_IFDEF
            {
            mFRAGMENT_RULE_IFDEF(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, RULE_IFDEF_StartIndex); }
        }
    }
    // $ANTLR end "RULE_IFDEF"

    // $ANTLR start "FRAGMENT_RULE_IFDEF"
    public final void mFRAGMENT_RULE_IFDEF() throws RecognitionException {
        int FRAGMENT_RULE_IFDEF_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return ; }
            // InternalCPreprocessLexer.g:182:30: ( 'ifdef' )
            // InternalCPreprocessLexer.g:182:32: 'ifdef'
            {
            match("ifdef"); if (state.failed) return ;


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, FRAGMENT_RULE_IFDEF_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_IFDEF"

    // $ANTLR start "RULE_IFNOTDEF"
    public final void mRULE_IFNOTDEF() throws RecognitionException {
        int RULE_IFNOTDEF_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return ; }
            // InternalCPreprocessLexer.g:184:24: ( FRAGMENT_RULE_IFNOTDEF )
            // InternalCPreprocessLexer.g:184:26: FRAGMENT_RULE_IFNOTDEF
            {
            mFRAGMENT_RULE_IFNOTDEF(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, RULE_IFNOTDEF_StartIndex); }
        }
    }
    // $ANTLR end "RULE_IFNOTDEF"

    // $ANTLR start "FRAGMENT_RULE_IFNOTDEF"
    public final void mFRAGMENT_RULE_IFNOTDEF() throws RecognitionException {
        int FRAGMENT_RULE_IFNOTDEF_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return ; }
            // InternalCPreprocessLexer.g:185:33: ( 'ifndef' )
            // InternalCPreprocessLexer.g:185:35: 'ifndef'
            {
            match("ifndef"); if (state.failed) return ;


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, FRAGMENT_RULE_IFNOTDEF_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_IFNOTDEF"

    // $ANTLR start "RULE_ENDIF"
    public final void mRULE_ENDIF() throws RecognitionException {
        int RULE_ENDIF_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return ; }
            // InternalCPreprocessLexer.g:187:21: ( FRAGMENT_RULE_ENDIF )
            // InternalCPreprocessLexer.g:187:23: FRAGMENT_RULE_ENDIF
            {
            mFRAGMENT_RULE_ENDIF(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, RULE_ENDIF_StartIndex); }
        }
    }
    // $ANTLR end "RULE_ENDIF"

    // $ANTLR start "FRAGMENT_RULE_ENDIF"
    public final void mFRAGMENT_RULE_ENDIF() throws RecognitionException {
        int FRAGMENT_RULE_ENDIF_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return ; }
            // InternalCPreprocessLexer.g:188:30: ( 'endif' )
            // InternalCPreprocessLexer.g:188:32: 'endif'
            {
            match("endif"); if (state.failed) return ;


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, FRAGMENT_RULE_ENDIF_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_ENDIF"

    // $ANTLR start "RULE_PRAGMA"
    public final void mRULE_PRAGMA() throws RecognitionException {
        int RULE_PRAGMA_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return ; }
            // InternalCPreprocessLexer.g:190:22: ( FRAGMENT_RULE_PRAGMA )
            // InternalCPreprocessLexer.g:190:24: FRAGMENT_RULE_PRAGMA
            {
            mFRAGMENT_RULE_PRAGMA(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, RULE_PRAGMA_StartIndex); }
        }
    }
    // $ANTLR end "RULE_PRAGMA"

    // $ANTLR start "FRAGMENT_RULE_PRAGMA"
    public final void mFRAGMENT_RULE_PRAGMA() throws RecognitionException {
        int FRAGMENT_RULE_PRAGMA_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return ; }
            // InternalCPreprocessLexer.g:191:31: ( 'pragma' )
            // InternalCPreprocessLexer.g:191:33: 'pragma'
            {
            match("pragma"); if (state.failed) return ;


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, FRAGMENT_RULE_PRAGMA_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_PRAGMA"

    // $ANTLR start "RULE_LINEFEED"
    public final void mRULE_LINEFEED() throws RecognitionException {
        int RULE_LINEFEED_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return ; }
            // InternalCPreprocessLexer.g:193:24: ( '\\n' )
            // InternalCPreprocessLexer.g:193:26: '\\n'
            {
            match('\n'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 22, RULE_LINEFEED_StartIndex); }
        }
    }
    // $ANTLR end "RULE_LINEFEED"

    // $ANTLR start "RULE_CARRIAGERETURN"
    public final void mRULE_CARRIAGERETURN() throws RecognitionException {
        int RULE_CARRIAGERETURN_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return ; }
            // InternalCPreprocessLexer.g:195:30: ( '\\r' )
            // InternalCPreprocessLexer.g:195:32: '\\r'
            {
            match('\r'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, RULE_CARRIAGERETURN_StartIndex); }
        }
    }
    // $ANTLR end "RULE_CARRIAGERETURN"

    // $ANTLR start "RULE_NEWLINE"
    public final void mRULE_NEWLINE() throws RecognitionException {
        int RULE_NEWLINE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return ; }
            // InternalCPreprocessLexer.g:197:23: ( FRAGMENT_RULE_NEWLINE )
            // InternalCPreprocessLexer.g:197:25: FRAGMENT_RULE_NEWLINE
            {
            mFRAGMENT_RULE_NEWLINE(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 24, RULE_NEWLINE_StartIndex); }
        }
    }
    // $ANTLR end "RULE_NEWLINE"

    // $ANTLR start "FRAGMENT_RULE_NEWLINE"
    public final void mFRAGMENT_RULE_NEWLINE() throws RecognitionException {
        int FRAGMENT_RULE_NEWLINE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return ; }
            // InternalCPreprocessLexer.g:198:32: ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) )
            // InternalCPreprocessLexer.g:198:34: ( RULE_CARRIAGERETURN | RULE_LINEFEED )
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
            if ( state.backtracking>0 ) { memoize(input, 25, FRAGMENT_RULE_NEWLINE_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_NEWLINE"

    // $ANTLR start "RULE_LINEBREAK"
    public final void mRULE_LINEBREAK() throws RecognitionException {
        int RULE_LINEBREAK_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return ; }
            // InternalCPreprocessLexer.g:200:25: ( RULE_SKW_BACKSLASH RULE_NEWLINE )
            // InternalCPreprocessLexer.g:200:27: RULE_SKW_BACKSLASH RULE_NEWLINE
            {
            mRULE_SKW_BACKSLASH(); if (state.failed) return ;
            mRULE_NEWLINE(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 26, RULE_LINEBREAK_StartIndex); }
        }
    }
    // $ANTLR end "RULE_LINEBREAK"

    // $ANTLR start "RULE_SPACE"
    public final void mRULE_SPACE() throws RecognitionException {
        int RULE_SPACE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return ; }
            // InternalCPreprocessLexer.g:202:21: ( ' ' )
            // InternalCPreprocessLexer.g:202:23: ' '
            {
            match(' '); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, RULE_SPACE_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SPACE"

    // $ANTLR start "RULE_TAB"
    public final void mRULE_TAB() throws RecognitionException {
        int RULE_TAB_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return ; }
            // InternalCPreprocessLexer.g:204:19: ( '\\t' )
            // InternalCPreprocessLexer.g:204:21: '\\t'
            {
            match('\t'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 28, RULE_TAB_StartIndex); }
        }
    }
    // $ANTLR end "RULE_TAB"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        int RULE_WS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return ; }
            // InternalCPreprocessLexer.g:206:18: ( FRAGMENT_RULE_WS )
            // InternalCPreprocessLexer.g:206:20: FRAGMENT_RULE_WS
            {
            mFRAGMENT_RULE_WS(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, RULE_WS_StartIndex); }
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "FRAGMENT_RULE_WS"
    public final void mFRAGMENT_RULE_WS() throws RecognitionException {
        int FRAGMENT_RULE_WS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return ; }
            // InternalCPreprocessLexer.g:207:27: ( ( RULE_SPACE | RULE_TAB | RULE_LINE_COMMENT | RULE_BLOCK_COMMENT | RULE_LINEBREAK ) )
            // InternalCPreprocessLexer.g:207:29: ( RULE_SPACE | RULE_TAB | RULE_LINE_COMMENT | RULE_BLOCK_COMMENT | RULE_LINEBREAK )
            {
            // InternalCPreprocessLexer.g:207:29: ( RULE_SPACE | RULE_TAB | RULE_LINE_COMMENT | RULE_BLOCK_COMMENT | RULE_LINEBREAK )
            int alt2=5;
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
            case '/':
                {
                int LA2_3 = input.LA(2);

                if ( (LA2_3=='/') ) {
                    alt2=3;
                }
                else if ( (LA2_3=='*') ) {
                    alt2=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 3, input);

                    throw nvae;
                }
                }
                break;
            case '\\':
                {
                alt2=5;
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
                    // InternalCPreprocessLexer.g:207:30: RULE_SPACE
                    {
                    mRULE_SPACE(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // InternalCPreprocessLexer.g:207:41: RULE_TAB
                    {
                    mRULE_TAB(); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // InternalCPreprocessLexer.g:207:50: RULE_LINE_COMMENT
                    {
                    mRULE_LINE_COMMENT(); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // InternalCPreprocessLexer.g:207:68: RULE_BLOCK_COMMENT
                    {
                    mRULE_BLOCK_COMMENT(); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // InternalCPreprocessLexer.g:207:87: RULE_LINEBREAK
                    {
                    mRULE_LINEBREAK(); if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 30, FRAGMENT_RULE_WS_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_WS"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        int RULE_ID_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return ; }
            // InternalCPreprocessLexer.g:209:18: ( FRAGMENT_RULE_ID )
            // InternalCPreprocessLexer.g:209:20: FRAGMENT_RULE_ID
            {
            mFRAGMENT_RULE_ID(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 31, RULE_ID_StartIndex); }
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "FRAGMENT_RULE_ID"
    public final void mFRAGMENT_RULE_ID() throws RecognitionException {
        int FRAGMENT_RULE_ID_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return ; }
            // InternalCPreprocessLexer.g:210:27: ( RULE_IDENTIFIER )
            // InternalCPreprocessLexer.g:210:29: RULE_IDENTIFIER
            {
            mRULE_IDENTIFIER(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 32, FRAGMENT_RULE_ID_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_ID"

    // $ANTLR start "RULE_IDENTIFIER"
    public final void mRULE_IDENTIFIER() throws RecognitionException {
        int RULE_IDENTIFIER_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return ; }
            // InternalCPreprocessLexer.g:212:26: ( RULE_LETTER ( RULE_LETTER | '0' .. '9' )* )
            // InternalCPreprocessLexer.g:212:28: RULE_LETTER ( RULE_LETTER | '0' .. '9' )*
            {
            mRULE_LETTER(); if (state.failed) return ;
            // InternalCPreprocessLexer.g:212:40: ( RULE_LETTER | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='$'||(LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalCPreprocessLexer.g:
            	    {
            	    if ( input.LA(1)=='$'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 33, RULE_IDENTIFIER_StartIndex); }
        }
    }
    // $ANTLR end "RULE_IDENTIFIER"

    // $ANTLR start "RULE_LETTER"
    public final void mRULE_LETTER() throws RecognitionException {
        int RULE_LETTER_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return ; }
            // InternalCPreprocessLexer.g:214:22: ( ( RULE_SKW_DOLLAR | 'A' .. 'Z' | 'a' .. 'z' | RULE_SKW_UNDERSCORE ) )
            // InternalCPreprocessLexer.g:214:24: ( RULE_SKW_DOLLAR | 'A' .. 'Z' | 'a' .. 'z' | RULE_SKW_UNDERSCORE )
            {
            if ( input.LA(1)=='$'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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
            if ( state.backtracking>0 ) { memoize(input, 34, RULE_LETTER_StartIndex); }
        }
    }
    // $ANTLR end "RULE_LETTER"

    // $ANTLR start "RULE_CHAR_LITERAL"
    public final void mRULE_CHAR_LITERAL() throws RecognitionException {
        int RULE_CHAR_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return ; }
            // InternalCPreprocessLexer.g:216:28: ( FRAGMENT_RULE_CHAR_LITERAL )
            // InternalCPreprocessLexer.g:216:30: FRAGMENT_RULE_CHAR_LITERAL
            {
            mFRAGMENT_RULE_CHAR_LITERAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 35, RULE_CHAR_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_CHAR_LITERAL"

    // $ANTLR start "FRAGMENT_RULE_CHAR_LITERAL"
    public final void mFRAGMENT_RULE_CHAR_LITERAL() throws RecognitionException {
        int FRAGMENT_RULE_CHAR_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return ; }
            // InternalCPreprocessLexer.g:217:37: ( RULE_SKW_SINGLEQUOTE ( RULE_ESCAPE_SEQUENCE | ~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) ) RULE_SKW_SINGLEQUOTE )
            // InternalCPreprocessLexer.g:217:39: RULE_SKW_SINGLEQUOTE ( RULE_ESCAPE_SEQUENCE | ~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) ) RULE_SKW_SINGLEQUOTE
            {
            mRULE_SKW_SINGLEQUOTE(); if (state.failed) return ;
            // InternalCPreprocessLexer.g:217:60: ( RULE_ESCAPE_SEQUENCE | ~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\\') ) {
                alt4=1;
            }
            else if ( ((LA4_0>='\u0000' && LA4_0<='&')||(LA4_0>='(' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
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
                    // InternalCPreprocessLexer.g:217:61: RULE_ESCAPE_SEQUENCE
                    {
                    mRULE_ESCAPE_SEQUENCE(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // InternalCPreprocessLexer.g:217:82: ~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                        input.consume();
                    state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            mRULE_SKW_SINGLEQUOTE(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 36, FRAGMENT_RULE_CHAR_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_CHAR_LITERAL"

    // $ANTLR start "RULE_STRING_LITERAL"
    public final void mRULE_STRING_LITERAL() throws RecognitionException {
        int RULE_STRING_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return ; }
            // InternalCPreprocessLexer.g:219:30: ( FRAGMENT_RULE_STRING_LITERAL )
            // InternalCPreprocessLexer.g:219:32: FRAGMENT_RULE_STRING_LITERAL
            {
            mFRAGMENT_RULE_STRING_LITERAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 37, RULE_STRING_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_STRING_LITERAL"

    // $ANTLR start "FRAGMENT_RULE_STRING_LITERAL"
    public final void mFRAGMENT_RULE_STRING_LITERAL() throws RecognitionException {
        int FRAGMENT_RULE_STRING_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return ; }
            // InternalCPreprocessLexer.g:220:39: ( RULE_SKW_DOUBLEQUOTE ( RULE_ESCAPE_SEQUENCE | ~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) )* RULE_SKW_DOUBLEQUOTE )
            // InternalCPreprocessLexer.g:220:41: RULE_SKW_DOUBLEQUOTE ( RULE_ESCAPE_SEQUENCE | ~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) )* RULE_SKW_DOUBLEQUOTE
            {
            mRULE_SKW_DOUBLEQUOTE(); if (state.failed) return ;
            // InternalCPreprocessLexer.g:220:62: ( RULE_ESCAPE_SEQUENCE | ~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\\') ) {
                    alt5=1;
                }
                else if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalCPreprocessLexer.g:220:63: RULE_ESCAPE_SEQUENCE
            	    {
            	    mRULE_ESCAPE_SEQUENCE(); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // InternalCPreprocessLexer.g:220:84: ~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            mRULE_SKW_DOUBLEQUOTE(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 38, FRAGMENT_RULE_STRING_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_STRING_LITERAL"

    // $ANTLR start "RULE_HEX_LITERAL"
    public final void mRULE_HEX_LITERAL() throws RecognitionException {
        int RULE_HEX_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return ; }
            // InternalCPreprocessLexer.g:222:27: ( FRAGMENT_RULE_HEX_LITERAL )
            // InternalCPreprocessLexer.g:222:29: FRAGMENT_RULE_HEX_LITERAL
            {
            mFRAGMENT_RULE_HEX_LITERAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 39, RULE_HEX_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_HEX_LITERAL"

    // $ANTLR start "FRAGMENT_RULE_HEX_LITERAL"
    public final void mFRAGMENT_RULE_HEX_LITERAL() throws RecognitionException {
        int FRAGMENT_RULE_HEX_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return ; }
            // InternalCPreprocessLexer.g:223:36: ( '0' ( 'x' | 'X' ) ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )? )
            // InternalCPreprocessLexer.g:223:38: '0' ( 'x' | 'X' ) ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )?
            {
            match('0'); if (state.failed) return ;
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalCPreprocessLexer.g:223:52: ( RULE_HEX_DIGIT )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='F')||(LA6_0>='a' && LA6_0<='f')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalCPreprocessLexer.g:0:0: RULE_HEX_DIGIT
            	    {
            	    mRULE_HEX_DIGIT(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            // InternalCPreprocessLexer.g:223:68: ( RULE_INTEGER_TYPE_SUFFIX )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='L'||LA7_0=='U'||LA7_0=='l'||LA7_0=='u') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalCPreprocessLexer.g:0:0: RULE_INTEGER_TYPE_SUFFIX
                    {
                    mRULE_INTEGER_TYPE_SUFFIX(); if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 40, FRAGMENT_RULE_HEX_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_HEX_LITERAL"

    // $ANTLR start "RULE_DECIMAL_LITERAL"
    public final void mRULE_DECIMAL_LITERAL() throws RecognitionException {
        int RULE_DECIMAL_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return ; }
            // InternalCPreprocessLexer.g:225:31: ( FRAGMENT_RULE_DECIMAL_LITERAL )
            // InternalCPreprocessLexer.g:225:33: FRAGMENT_RULE_DECIMAL_LITERAL
            {
            mFRAGMENT_RULE_DECIMAL_LITERAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 41, RULE_DECIMAL_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_DECIMAL_LITERAL"

    // $ANTLR start "FRAGMENT_RULE_DECIMAL_LITERAL"
    public final void mFRAGMENT_RULE_DECIMAL_LITERAL() throws RecognitionException {
        int FRAGMENT_RULE_DECIMAL_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return ; }
            // InternalCPreprocessLexer.g:226:40: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( RULE_INTEGER_TYPE_SUFFIX )? )
            // InternalCPreprocessLexer.g:226:42: ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( RULE_INTEGER_TYPE_SUFFIX )?
            {
            // InternalCPreprocessLexer.g:226:42: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='0') ) {
                alt9=1;
            }
            else if ( ((LA9_0>='1' && LA9_0<='9')) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalCPreprocessLexer.g:226:43: '0'
                    {
                    match('0'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // InternalCPreprocessLexer.g:226:47: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); if (state.failed) return ;
                    // InternalCPreprocessLexer.g:226:56: ( '0' .. '9' )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalCPreprocessLexer.g:226:57: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalCPreprocessLexer.g:226:69: ( RULE_INTEGER_TYPE_SUFFIX )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='L'||LA10_0=='U'||LA10_0=='l'||LA10_0=='u') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalCPreprocessLexer.g:0:0: RULE_INTEGER_TYPE_SUFFIX
                    {
                    mRULE_INTEGER_TYPE_SUFFIX(); if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 42, FRAGMENT_RULE_DECIMAL_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_DECIMAL_LITERAL"

    // $ANTLR start "RULE_OCTAL_LITERAL"
    public final void mRULE_OCTAL_LITERAL() throws RecognitionException {
        int RULE_OCTAL_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return ; }
            // InternalCPreprocessLexer.g:228:29: ( FRAGMENT_RULE_OCTAL_LITERAL )
            // InternalCPreprocessLexer.g:228:31: FRAGMENT_RULE_OCTAL_LITERAL
            {
            mFRAGMENT_RULE_OCTAL_LITERAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 43, RULE_OCTAL_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_OCTAL_LITERAL"

    // $ANTLR start "FRAGMENT_RULE_OCTAL_LITERAL"
    public final void mFRAGMENT_RULE_OCTAL_LITERAL() throws RecognitionException {
        int FRAGMENT_RULE_OCTAL_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return ; }
            // InternalCPreprocessLexer.g:229:38: ( '0' ( '0' .. '7' )+ ( RULE_INTEGER_TYPE_SUFFIX )? )
            // InternalCPreprocessLexer.g:229:40: '0' ( '0' .. '7' )+ ( RULE_INTEGER_TYPE_SUFFIX )?
            {
            match('0'); if (state.failed) return ;
            // InternalCPreprocessLexer.g:229:44: ( '0' .. '7' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='7')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalCPreprocessLexer.g:229:45: '0' .. '7'
            	    {
            	    matchRange('0','7'); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            // InternalCPreprocessLexer.g:229:56: ( RULE_INTEGER_TYPE_SUFFIX )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='L'||LA12_0=='U'||LA12_0=='l'||LA12_0=='u') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalCPreprocessLexer.g:0:0: RULE_INTEGER_TYPE_SUFFIX
                    {
                    mRULE_INTEGER_TYPE_SUFFIX(); if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 44, FRAGMENT_RULE_OCTAL_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_OCTAL_LITERAL"

    // $ANTLR start "RULE_BIN_LITERAL"
    public final void mRULE_BIN_LITERAL() throws RecognitionException {
        int RULE_BIN_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return ; }
            // InternalCPreprocessLexer.g:231:27: ( FRAGMENT_RULE_BIN_LITERAL )
            // InternalCPreprocessLexer.g:231:29: FRAGMENT_RULE_BIN_LITERAL
            {
            mFRAGMENT_RULE_BIN_LITERAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 45, RULE_BIN_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_BIN_LITERAL"

    // $ANTLR start "FRAGMENT_RULE_BIN_LITERAL"
    public final void mFRAGMENT_RULE_BIN_LITERAL() throws RecognitionException {
        int FRAGMENT_RULE_BIN_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return ; }
            // InternalCPreprocessLexer.g:232:36: ( ( '0b' | '0B' ) ( '0' .. '1' )+ )
            // InternalCPreprocessLexer.g:232:38: ( '0b' | '0B' ) ( '0' .. '1' )+
            {
            // InternalCPreprocessLexer.g:232:38: ( '0b' | '0B' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='0') ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1=='b') ) {
                    alt13=1;
                }
                else if ( (LA13_1=='B') ) {
                    alt13=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalCPreprocessLexer.g:232:39: '0b'
                    {
                    match("0b"); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // InternalCPreprocessLexer.g:232:44: '0B'
                    {
                    match("0B"); if (state.failed) return ;


                    }
                    break;

            }

            // InternalCPreprocessLexer.g:232:50: ( '0' .. '1' )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='0' && LA14_0<='1')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalCPreprocessLexer.g:232:51: '0' .. '1'
            	    {
            	    matchRange('0','1'); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 46, FRAGMENT_RULE_BIN_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_BIN_LITERAL"

    // $ANTLR start "RULE_HEX_DIGIT"
    public final void mRULE_HEX_DIGIT() throws RecognitionException {
        int RULE_HEX_DIGIT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return ; }
            // InternalCPreprocessLexer.g:234:25: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // InternalCPreprocessLexer.g:234:27: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
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
            if ( state.backtracking>0 ) { memoize(input, 47, RULE_HEX_DIGIT_StartIndex); }
        }
    }
    // $ANTLR end "RULE_HEX_DIGIT"

    // $ANTLR start "RULE_INTEGER_TYPE_SUFFIX"
    public final void mRULE_INTEGER_TYPE_SUFFIX() throws RecognitionException {
        int RULE_INTEGER_TYPE_SUFFIX_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return ; }
            // InternalCPreprocessLexer.g:236:35: ( ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? ) )
            // InternalCPreprocessLexer.g:236:37: ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? )
            {
            // InternalCPreprocessLexer.g:236:37: ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='U'||LA17_0=='u') ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1=='L'||LA17_1=='l') ) {
                    int LA17_3 = input.LA(3);

                    if ( (synpred89_InternalCPreprocessLexer()) ) {
                        alt17=1;
                    }
                    else if ( (true) ) {
                        alt17=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 3, input);

                        throw nvae;
                    }
                }
                else {
                    alt17=2;}
            }
            else if ( (LA17_0=='L'||LA17_0=='l') ) {
                alt17=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalCPreprocessLexer.g:236:38: ( 'u' | 'U' )? ( 'l' | 'L' )
                    {
                    // InternalCPreprocessLexer.g:236:38: ( 'u' | 'U' )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='U'||LA15_0=='u') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // InternalCPreprocessLexer.g:
                            {
                            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                                input.consume();
                            state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }

                    if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                        input.consume();
                    state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // InternalCPreprocessLexer.g:236:59: ( 'u' | 'U' ) ( 'l' | 'L' )?
                    {
                    if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                        input.consume();
                    state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // InternalCPreprocessLexer.g:236:69: ( 'l' | 'L' )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='L'||LA16_0=='l') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalCPreprocessLexer.g:
                            {
                            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                                input.consume();
                            state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }


                    }
                    break;

            }


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 48, RULE_INTEGER_TYPE_SUFFIX_StartIndex); }
        }
    }
    // $ANTLR end "RULE_INTEGER_TYPE_SUFFIX"

    // $ANTLR start "RULE_FLOAT_LITERAL"
    public final void mRULE_FLOAT_LITERAL() throws RecognitionException {
        int RULE_FLOAT_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return ; }
            // InternalCPreprocessLexer.g:238:29: ( FRAGMENT_RULE_FLOAT_LITERAL )
            // InternalCPreprocessLexer.g:238:31: FRAGMENT_RULE_FLOAT_LITERAL
            {
            mFRAGMENT_RULE_FLOAT_LITERAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 49, RULE_FLOAT_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_FLOAT_LITERAL"

    // $ANTLR start "FRAGMENT_RULE_FLOAT_LITERAL"
    public final void mFRAGMENT_RULE_FLOAT_LITERAL() throws RecognitionException {
        int FRAGMENT_RULE_FLOAT_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return ; }
            // InternalCPreprocessLexer.g:239:38: ( ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX ) )
            // InternalCPreprocessLexer.g:239:40: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )
            {
            // InternalCPreprocessLexer.g:239:40: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )
            int alt29=4;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // InternalCPreprocessLexer.g:239:41: ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )?
                    {
                    // InternalCPreprocessLexer.g:239:41: ( '0' .. '9' )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>='0' && LA18_0<='9')) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalCPreprocessLexer.g:239:42: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);

                    mRULE_SKW_DOT(); if (state.failed) return ;
                    // InternalCPreprocessLexer.g:239:66: ( '0' .. '9' )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0>='0' && LA19_0<='9')) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalCPreprocessLexer.g:239:67: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    // InternalCPreprocessLexer.g:239:78: ( RULE_EXPONENT )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0=='E'||LA20_0=='e') ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // InternalCPreprocessLexer.g:0:0: RULE_EXPONENT
                            {
                            mRULE_EXPONENT(); if (state.failed) return ;

                            }
                            break;

                    }

                    // InternalCPreprocessLexer.g:239:93: ( RULE_FLOAT_TYPE_SUFFIX )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0=='D'||LA21_0=='F'||LA21_0=='d'||LA21_0=='f') ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // InternalCPreprocessLexer.g:0:0: RULE_FLOAT_TYPE_SUFFIX
                            {
                            mRULE_FLOAT_TYPE_SUFFIX(); if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalCPreprocessLexer.g:239:117: RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )?
                    {
                    mRULE_SKW_DOT(); if (state.failed) return ;
                    // InternalCPreprocessLexer.g:239:130: ( '0' .. '9' )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( ((LA22_0>='0' && LA22_0<='9')) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalCPreprocessLexer.g:239:131: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt22 >= 1 ) break loop22;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(22, input);
                                throw eee;
                        }
                        cnt22++;
                    } while (true);

                    // InternalCPreprocessLexer.g:239:142: ( RULE_EXPONENT )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0=='E'||LA23_0=='e') ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // InternalCPreprocessLexer.g:0:0: RULE_EXPONENT
                            {
                            mRULE_EXPONENT(); if (state.failed) return ;

                            }
                            break;

                    }

                    // InternalCPreprocessLexer.g:239:157: ( RULE_FLOAT_TYPE_SUFFIX )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0=='D'||LA24_0=='F'||LA24_0=='d'||LA24_0=='f') ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // InternalCPreprocessLexer.g:0:0: RULE_FLOAT_TYPE_SUFFIX
                            {
                            mRULE_FLOAT_TYPE_SUFFIX(); if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // InternalCPreprocessLexer.g:239:181: ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )?
                    {
                    // InternalCPreprocessLexer.g:239:181: ( '0' .. '9' )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( ((LA25_0>='0' && LA25_0<='9')) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalCPreprocessLexer.g:239:182: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt25 >= 1 ) break loop25;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(25, input);
                                throw eee;
                        }
                        cnt25++;
                    } while (true);

                    mRULE_EXPONENT(); if (state.failed) return ;
                    // InternalCPreprocessLexer.g:239:207: ( RULE_FLOAT_TYPE_SUFFIX )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0=='D'||LA26_0=='F'||LA26_0=='d'||LA26_0=='f') ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // InternalCPreprocessLexer.g:0:0: RULE_FLOAT_TYPE_SUFFIX
                            {
                            mRULE_FLOAT_TYPE_SUFFIX(); if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // InternalCPreprocessLexer.g:239:231: ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX
                    {
                    // InternalCPreprocessLexer.g:239:231: ( '0' .. '9' )+
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
                    	    // InternalCPreprocessLexer.g:239:232: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt27 >= 1 ) break loop27;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(27, input);
                                throw eee;
                        }
                        cnt27++;
                    } while (true);

                    // InternalCPreprocessLexer.g:239:243: ( RULE_EXPONENT )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0=='E'||LA28_0=='e') ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // InternalCPreprocessLexer.g:0:0: RULE_EXPONENT
                            {
                            mRULE_EXPONENT(); if (state.failed) return ;

                            }
                            break;

                    }

                    mRULE_FLOAT_TYPE_SUFFIX(); if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 50, FRAGMENT_RULE_FLOAT_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_FLOAT_LITERAL"

    // $ANTLR start "RULE_EXPONENT"
    public final void mRULE_EXPONENT() throws RecognitionException {
        int RULE_EXPONENT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return ; }
            // InternalCPreprocessLexer.g:241:24: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // InternalCPreprocessLexer.g:241:26: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalCPreprocessLexer.g:241:36: ( '+' | '-' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0=='+'||LA30_0=='-') ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalCPreprocessLexer.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                    state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // InternalCPreprocessLexer.g:241:47: ( '0' .. '9' )+
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
            	    // InternalCPreprocessLexer.g:241:48: '0' .. '9'
            	    {
            	    matchRange('0','9'); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
            } while (true);


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 51, RULE_EXPONENT_StartIndex); }
        }
    }
    // $ANTLR end "RULE_EXPONENT"

    // $ANTLR start "RULE_FLOAT_TYPE_SUFFIX"
    public final void mRULE_FLOAT_TYPE_SUFFIX() throws RecognitionException {
        int RULE_FLOAT_TYPE_SUFFIX_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return ; }
            // InternalCPreprocessLexer.g:243:33: ( ( 'f' | 'F' | 'd' | 'D' ) )
            // InternalCPreprocessLexer.g:243:35: ( 'f' | 'F' | 'd' | 'D' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
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
            if ( state.backtracking>0 ) { memoize(input, 52, RULE_FLOAT_TYPE_SUFFIX_StartIndex); }
        }
    }
    // $ANTLR end "RULE_FLOAT_TYPE_SUFFIX"

    // $ANTLR start "RULE_ESCAPE_SEQUENCE"
    public final void mRULE_ESCAPE_SEQUENCE() throws RecognitionException {
        int RULE_ESCAPE_SEQUENCE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return ; }
            // InternalCPreprocessLexer.g:245:31: ( ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE ) )
            // InternalCPreprocessLexer.g:245:33: ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE )
            {
            // InternalCPreprocessLexer.g:245:33: ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0=='\\') ) {
                int LA32_1 = input.LA(2);

                if ( ((LA32_1>='0' && LA32_1<='7')) ) {
                    alt32=2;
                }
                else if ( (LA32_1=='\"'||LA32_1=='\''||LA32_1=='\\'||LA32_1=='b'||LA32_1=='f'||LA32_1=='n'||LA32_1=='r'||LA32_1=='t') ) {
                    alt32=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 32, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalCPreprocessLexer.g:245:34: RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH )
                    {
                    mRULE_SKW_BACKSLASH(); if (state.failed) return ;
                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();
                    state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // InternalCPreprocessLexer.g:245:119: RULE_OCTAL_ESCAPE
                    {
                    mRULE_OCTAL_ESCAPE(); if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 53, RULE_ESCAPE_SEQUENCE_StartIndex); }
        }
    }
    // $ANTLR end "RULE_ESCAPE_SEQUENCE"

    // $ANTLR start "RULE_OCTAL_ESCAPE"
    public final void mRULE_OCTAL_ESCAPE() throws RecognitionException {
        int RULE_OCTAL_ESCAPE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return ; }
            // InternalCPreprocessLexer.g:247:28: ( ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' ) )
            // InternalCPreprocessLexer.g:247:30: ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' )
            {
            // InternalCPreprocessLexer.g:247:30: ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' )
            int alt33=3;
            int LA33_0 = input.LA(1);

            if ( (LA33_0=='\\') ) {
                int LA33_1 = input.LA(2);

                if ( ((LA33_1>='0' && LA33_1<='3')) ) {
                    int LA33_2 = input.LA(3);

                    if ( ((LA33_2>='0' && LA33_2<='7')) ) {
                        int LA33_4 = input.LA(4);

                        if ( ((LA33_4>='0' && LA33_4<='7')) ) {
                            alt33=1;
                        }
                        else {
                            alt33=2;}
                    }
                    else {
                        alt33=3;}
                }
                else if ( ((LA33_1>='4' && LA33_1<='7')) ) {
                    int LA33_3 = input.LA(3);

                    if ( ((LA33_3>='0' && LA33_3<='7')) ) {
                        alt33=2;
                    }
                    else {
                        alt33=3;}
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // InternalCPreprocessLexer.g:247:31: RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7'
                    {
                    mRULE_SKW_BACKSLASH(); if (state.failed) return ;
                    matchRange('0','3'); if (state.failed) return ;
                    matchRange('0','7'); if (state.failed) return ;
                    matchRange('0','7'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // InternalCPreprocessLexer.g:247:77: RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7'
                    {
                    mRULE_SKW_BACKSLASH(); if (state.failed) return ;
                    matchRange('0','7'); if (state.failed) return ;
                    matchRange('0','7'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // InternalCPreprocessLexer.g:247:114: RULE_SKW_BACKSLASH '0' .. '7'
                    {
                    mRULE_SKW_BACKSLASH(); if (state.failed) return ;
                    matchRange('0','7'); if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 54, RULE_OCTAL_ESCAPE_StartIndex); }
        }
    }
    // $ANTLR end "RULE_OCTAL_ESCAPE"

    // $ANTLR start "RULE_BLOCK_COMMENT"
    public final void mRULE_BLOCK_COMMENT() throws RecognitionException {
        int RULE_BLOCK_COMMENT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return ; }
            // InternalCPreprocessLexer.g:249:29: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalCPreprocessLexer.g:249:31: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); if (state.failed) return ;

            // InternalCPreprocessLexer.g:249:36: ( options {greedy=false; } : . )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0=='*') ) {
                    int LA34_1 = input.LA(2);

                    if ( (LA34_1=='/') ) {
                        alt34=2;
                    }
                    else if ( ((LA34_1>='\u0000' && LA34_1<='.')||(LA34_1>='0' && LA34_1<='\uFFFF')) ) {
                        alt34=1;
                    }


                }
                else if ( ((LA34_0>='\u0000' && LA34_0<=')')||(LA34_0>='+' && LA34_0<='\uFFFF')) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalCPreprocessLexer.g:249:64: .
            	    {
            	    matchAny(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            match("*/"); if (state.failed) return ;


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 55, RULE_BLOCK_COMMENT_StartIndex); }
        }
    }
    // $ANTLR end "RULE_BLOCK_COMMENT"

    // $ANTLR start "RULE_LINE_COMMENT"
    public final void mRULE_LINE_COMMENT() throws RecognitionException {
        int RULE_LINE_COMMENT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return ; }
            // InternalCPreprocessLexer.g:251:28: ( '//' (~ ( RULE_NEWLINE ) )* )
            // InternalCPreprocessLexer.g:251:30: '//' (~ ( RULE_NEWLINE ) )*
            {
            match("//"); if (state.failed) return ;

            // InternalCPreprocessLexer.g:251:35: (~ ( RULE_NEWLINE ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>='\u0000' && LA35_0<='\t')||(LA35_0>='\u000B' && LA35_0<='\f')||(LA35_0>='\u000E' && LA35_0<='\uFFFF')) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalCPreprocessLexer.g:0:0: ~ ( RULE_NEWLINE )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 56, RULE_LINE_COMMENT_StartIndex); }
        }
    }
    // $ANTLR end "RULE_LINE_COMMENT"

    // $ANTLR start "RULE_SKW_AND"
    public final void mRULE_SKW_AND() throws RecognitionException {
        int RULE_SKW_AND_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return ; }
            // InternalCPreprocessLexer.g:253:23: ( FRAGMENT_RULE_SKW_AND )
            // InternalCPreprocessLexer.g:253:25: FRAGMENT_RULE_SKW_AND
            {
            mFRAGMENT_RULE_SKW_AND(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 57, RULE_SKW_AND_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_AND"

    // $ANTLR start "FRAGMENT_RULE_SKW_AND"
    public final void mFRAGMENT_RULE_SKW_AND() throws RecognitionException {
        int FRAGMENT_RULE_SKW_AND_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return ; }
            // InternalCPreprocessLexer.g:254:32: ( '&' )
            // InternalCPreprocessLexer.g:254:34: '&'
            {
            match('&'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 58, FRAGMENT_RULE_SKW_AND_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_AND"

    // $ANTLR start "RULE_SKW_ANDAND"
    public final void mRULE_SKW_ANDAND() throws RecognitionException {
        int RULE_SKW_ANDAND_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return ; }
            // InternalCPreprocessLexer.g:256:26: ( FRAGMENT_RULE_SKW_ANDAND )
            // InternalCPreprocessLexer.g:256:28: FRAGMENT_RULE_SKW_ANDAND
            {
            mFRAGMENT_RULE_SKW_ANDAND(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 59, RULE_SKW_ANDAND_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_ANDAND"

    // $ANTLR start "FRAGMENT_RULE_SKW_ANDAND"
    public final void mFRAGMENT_RULE_SKW_ANDAND() throws RecognitionException {
        int FRAGMENT_RULE_SKW_ANDAND_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return ; }
            // InternalCPreprocessLexer.g:257:35: ( RULE_SKW_AND RULE_SKW_AND )
            // InternalCPreprocessLexer.g:257:37: RULE_SKW_AND RULE_SKW_AND
            {
            mRULE_SKW_AND(); if (state.failed) return ;
            mRULE_SKW_AND(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 60, FRAGMENT_RULE_SKW_ANDAND_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_ANDAND"

    // $ANTLR start "RULE_SKW_ASSIGN"
    public final void mRULE_SKW_ASSIGN() throws RecognitionException {
        int RULE_SKW_ASSIGN_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return ; }
            // InternalCPreprocessLexer.g:259:26: ( FRAGMENT_RULE_SKW_ASSIGN )
            // InternalCPreprocessLexer.g:259:28: FRAGMENT_RULE_SKW_ASSIGN
            {
            mFRAGMENT_RULE_SKW_ASSIGN(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 61, RULE_SKW_ASSIGN_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_ASSIGN"

    // $ANTLR start "FRAGMENT_RULE_SKW_ASSIGN"
    public final void mFRAGMENT_RULE_SKW_ASSIGN() throws RecognitionException {
        int FRAGMENT_RULE_SKW_ASSIGN_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return ; }
            // InternalCPreprocessLexer.g:260:35: ( '=' )
            // InternalCPreprocessLexer.g:260:37: '='
            {
            match('='); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 62, FRAGMENT_RULE_SKW_ASSIGN_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_ASSIGN"

    // $ANTLR start "RULE_SKW_BACKSLASH"
    public final void mRULE_SKW_BACKSLASH() throws RecognitionException {
        int RULE_SKW_BACKSLASH_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return ; }
            // InternalCPreprocessLexer.g:262:29: ( FRAGMENT_RULE_SKW_BACKSLASH )
            // InternalCPreprocessLexer.g:262:31: FRAGMENT_RULE_SKW_BACKSLASH
            {
            mFRAGMENT_RULE_SKW_BACKSLASH(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 63, RULE_SKW_BACKSLASH_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_BACKSLASH"

    // $ANTLR start "FRAGMENT_RULE_SKW_BACKSLASH"
    public final void mFRAGMENT_RULE_SKW_BACKSLASH() throws RecognitionException {
        int FRAGMENT_RULE_SKW_BACKSLASH_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return ; }
            // InternalCPreprocessLexer.g:263:38: ( '\\\\' )
            // InternalCPreprocessLexer.g:263:40: '\\\\'
            {
            match('\\'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 64, FRAGMENT_RULE_SKW_BACKSLASH_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_BACKSLASH"

    // $ANTLR start "RULE_SKW_CARET"
    public final void mRULE_SKW_CARET() throws RecognitionException {
        int RULE_SKW_CARET_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return ; }
            // InternalCPreprocessLexer.g:265:25: ( FRAGMENT_RULE_SKW_CARET )
            // InternalCPreprocessLexer.g:265:27: FRAGMENT_RULE_SKW_CARET
            {
            mFRAGMENT_RULE_SKW_CARET(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 65, RULE_SKW_CARET_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_CARET"

    // $ANTLR start "FRAGMENT_RULE_SKW_CARET"
    public final void mFRAGMENT_RULE_SKW_CARET() throws RecognitionException {
        int FRAGMENT_RULE_SKW_CARET_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return ; }
            // InternalCPreprocessLexer.g:266:34: ( '^' )
            // InternalCPreprocessLexer.g:266:36: '^'
            {
            match('^'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 66, FRAGMENT_RULE_SKW_CARET_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_CARET"

    // $ANTLR start "RULE_SKW_COMMA"
    public final void mRULE_SKW_COMMA() throws RecognitionException {
        int RULE_SKW_COMMA_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return ; }
            // InternalCPreprocessLexer.g:268:25: ( FRAGMENT_RULE_SKW_COMMA )
            // InternalCPreprocessLexer.g:268:27: FRAGMENT_RULE_SKW_COMMA
            {
            mFRAGMENT_RULE_SKW_COMMA(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 67, RULE_SKW_COMMA_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_COMMA"

    // $ANTLR start "FRAGMENT_RULE_SKW_COMMA"
    public final void mFRAGMENT_RULE_SKW_COMMA() throws RecognitionException {
        int FRAGMENT_RULE_SKW_COMMA_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return ; }
            // InternalCPreprocessLexer.g:269:34: ( ',' )
            // InternalCPreprocessLexer.g:269:36: ','
            {
            match(','); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 68, FRAGMENT_RULE_SKW_COMMA_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_COMMA"

    // $ANTLR start "RULE_SKW_COLON"
    public final void mRULE_SKW_COLON() throws RecognitionException {
        int RULE_SKW_COLON_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return ; }
            // InternalCPreprocessLexer.g:271:25: ( FRAGMENT_RULE_SKW_COLON )
            // InternalCPreprocessLexer.g:271:27: FRAGMENT_RULE_SKW_COLON
            {
            mFRAGMENT_RULE_SKW_COLON(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 69, RULE_SKW_COLON_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_COLON"

    // $ANTLR start "FRAGMENT_RULE_SKW_COLON"
    public final void mFRAGMENT_RULE_SKW_COLON() throws RecognitionException {
        int FRAGMENT_RULE_SKW_COLON_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return ; }
            // InternalCPreprocessLexer.g:272:34: ( ':' )
            // InternalCPreprocessLexer.g:272:36: ':'
            {
            match(':'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 70, FRAGMENT_RULE_SKW_COLON_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_COLON"

    // $ANTLR start "RULE_SKW_DIV"
    public final void mRULE_SKW_DIV() throws RecognitionException {
        int RULE_SKW_DIV_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return ; }
            // InternalCPreprocessLexer.g:274:23: ( FRAGMENT_RULE_SKW_DIV )
            // InternalCPreprocessLexer.g:274:25: FRAGMENT_RULE_SKW_DIV
            {
            mFRAGMENT_RULE_SKW_DIV(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 71, RULE_SKW_DIV_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_DIV"

    // $ANTLR start "FRAGMENT_RULE_SKW_DIV"
    public final void mFRAGMENT_RULE_SKW_DIV() throws RecognitionException {
        int FRAGMENT_RULE_SKW_DIV_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return ; }
            // InternalCPreprocessLexer.g:275:32: ( '/' )
            // InternalCPreprocessLexer.g:275:34: '/'
            {
            match('/'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 72, FRAGMENT_RULE_SKW_DIV_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_DIV"

    // $ANTLR start "RULE_SKW_DOLLAR"
    public final void mRULE_SKW_DOLLAR() throws RecognitionException {
        int RULE_SKW_DOLLAR_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return ; }
            // InternalCPreprocessLexer.g:277:26: ( '$' )
            // InternalCPreprocessLexer.g:277:28: '$'
            {
            match('$'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 73, RULE_SKW_DOLLAR_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_DOLLAR"

    // $ANTLR start "RULE_SKW_DOT"
    public final void mRULE_SKW_DOT() throws RecognitionException {
        int RULE_SKW_DOT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return ; }
            // InternalCPreprocessLexer.g:279:23: ( FRAGMENT_RULE_SKW_DOT )
            // InternalCPreprocessLexer.g:279:25: FRAGMENT_RULE_SKW_DOT
            {
            mFRAGMENT_RULE_SKW_DOT(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 74, RULE_SKW_DOT_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_DOT"

    // $ANTLR start "FRAGMENT_RULE_SKW_DOT"
    public final void mFRAGMENT_RULE_SKW_DOT() throws RecognitionException {
        int FRAGMENT_RULE_SKW_DOT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return ; }
            // InternalCPreprocessLexer.g:280:32: ( '.' )
            // InternalCPreprocessLexer.g:280:34: '.'
            {
            match('.'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 75, FRAGMENT_RULE_SKW_DOT_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_DOT"

    // $ANTLR start "RULE_SKW_DOUBLEQUOTE"
    public final void mRULE_SKW_DOUBLEQUOTE() throws RecognitionException {
        int RULE_SKW_DOUBLEQUOTE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return ; }
            // InternalCPreprocessLexer.g:282:31: ( FRAGMENT_RULE_SKW_DOUBLEQUOTE )
            // InternalCPreprocessLexer.g:282:33: FRAGMENT_RULE_SKW_DOUBLEQUOTE
            {
            mFRAGMENT_RULE_SKW_DOUBLEQUOTE(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 76, RULE_SKW_DOUBLEQUOTE_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_DOUBLEQUOTE"

    // $ANTLR start "FRAGMENT_RULE_SKW_DOUBLEQUOTE"
    public final void mFRAGMENT_RULE_SKW_DOUBLEQUOTE() throws RecognitionException {
        int FRAGMENT_RULE_SKW_DOUBLEQUOTE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return ; }
            // InternalCPreprocessLexer.g:283:40: ( '\"' )
            // InternalCPreprocessLexer.g:283:42: '\"'
            {
            match('\"'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 77, FRAGMENT_RULE_SKW_DOUBLEQUOTE_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_DOUBLEQUOTE"

    // $ANTLR start "RULE_SKW_EQUAL"
    public final void mRULE_SKW_EQUAL() throws RecognitionException {
        int RULE_SKW_EQUAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 78) ) { return ; }
            // InternalCPreprocessLexer.g:285:25: ( FRAGMENT_RULE_SKW_EQUAL )
            // InternalCPreprocessLexer.g:285:27: FRAGMENT_RULE_SKW_EQUAL
            {
            mFRAGMENT_RULE_SKW_EQUAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 78, RULE_SKW_EQUAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_EQUAL"

    // $ANTLR start "FRAGMENT_RULE_SKW_EQUAL"
    public final void mFRAGMENT_RULE_SKW_EQUAL() throws RecognitionException {
        int FRAGMENT_RULE_SKW_EQUAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 79) ) { return ; }
            // InternalCPreprocessLexer.g:286:34: ( RULE_SKW_ASSIGN RULE_SKW_ASSIGN )
            // InternalCPreprocessLexer.g:286:36: RULE_SKW_ASSIGN RULE_SKW_ASSIGN
            {
            mRULE_SKW_ASSIGN(); if (state.failed) return ;
            mRULE_SKW_ASSIGN(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 79, FRAGMENT_RULE_SKW_EQUAL_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_EQUAL"

    // $ANTLR start "RULE_SKW_GREATER"
    public final void mRULE_SKW_GREATER() throws RecognitionException {
        int RULE_SKW_GREATER_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 80) ) { return ; }
            // InternalCPreprocessLexer.g:288:27: ( FRAGMENT_RULE_SKW_GREATER )
            // InternalCPreprocessLexer.g:288:29: FRAGMENT_RULE_SKW_GREATER
            {
            mFRAGMENT_RULE_SKW_GREATER(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 80, RULE_SKW_GREATER_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_GREATER"

    // $ANTLR start "FRAGMENT_RULE_SKW_GREATER"
    public final void mFRAGMENT_RULE_SKW_GREATER() throws RecognitionException {
        int FRAGMENT_RULE_SKW_GREATER_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 81) ) { return ; }
            // InternalCPreprocessLexer.g:289:36: ( '>' )
            // InternalCPreprocessLexer.g:289:38: '>'
            {
            match('>'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 81, FRAGMENT_RULE_SKW_GREATER_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_GREATER"

    // $ANTLR start "RULE_SKW_GREATEREQUAL"
    public final void mRULE_SKW_GREATEREQUAL() throws RecognitionException {
        int RULE_SKW_GREATEREQUAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 82) ) { return ; }
            // InternalCPreprocessLexer.g:291:32: ( FRAGMENT_RULE_SKW_GREATEREQUAL )
            // InternalCPreprocessLexer.g:291:34: FRAGMENT_RULE_SKW_GREATEREQUAL
            {
            mFRAGMENT_RULE_SKW_GREATEREQUAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 82, RULE_SKW_GREATEREQUAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_GREATEREQUAL"

    // $ANTLR start "FRAGMENT_RULE_SKW_GREATEREQUAL"
    public final void mFRAGMENT_RULE_SKW_GREATEREQUAL() throws RecognitionException {
        int FRAGMENT_RULE_SKW_GREATEREQUAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 83) ) { return ; }
            // InternalCPreprocessLexer.g:292:41: ( RULE_SKW_GREATER RULE_SKW_ASSIGN )
            // InternalCPreprocessLexer.g:292:43: RULE_SKW_GREATER RULE_SKW_ASSIGN
            {
            mRULE_SKW_GREATER(); if (state.failed) return ;
            mRULE_SKW_ASSIGN(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 83, FRAGMENT_RULE_SKW_GREATEREQUAL_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_GREATEREQUAL"

    // $ANTLR start "RULE_SKW_LEFTBRACE"
    public final void mRULE_SKW_LEFTBRACE() throws RecognitionException {
        int RULE_SKW_LEFTBRACE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 84) ) { return ; }
            // InternalCPreprocessLexer.g:294:29: ( FRAGMENT_RULE_SKW_LEFTBRACE )
            // InternalCPreprocessLexer.g:294:31: FRAGMENT_RULE_SKW_LEFTBRACE
            {
            mFRAGMENT_RULE_SKW_LEFTBRACE(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 84, RULE_SKW_LEFTBRACE_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_LEFTBRACE"

    // $ANTLR start "FRAGMENT_RULE_SKW_LEFTBRACE"
    public final void mFRAGMENT_RULE_SKW_LEFTBRACE() throws RecognitionException {
        int FRAGMENT_RULE_SKW_LEFTBRACE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 85) ) { return ; }
            // InternalCPreprocessLexer.g:295:38: ( '{' )
            // InternalCPreprocessLexer.g:295:40: '{'
            {
            match('{'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 85, FRAGMENT_RULE_SKW_LEFTBRACE_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_LEFTBRACE"

    // $ANTLR start "RULE_SKW_LEFTBRACKET"
    public final void mRULE_SKW_LEFTBRACKET() throws RecognitionException {
        int RULE_SKW_LEFTBRACKET_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 86) ) { return ; }
            // InternalCPreprocessLexer.g:297:31: ( FRAGMENT_RULE_SKW_LEFTBRACKET )
            // InternalCPreprocessLexer.g:297:33: FRAGMENT_RULE_SKW_LEFTBRACKET
            {
            mFRAGMENT_RULE_SKW_LEFTBRACKET(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 86, RULE_SKW_LEFTBRACKET_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_LEFTBRACKET"

    // $ANTLR start "FRAGMENT_RULE_SKW_LEFTBRACKET"
    public final void mFRAGMENT_RULE_SKW_LEFTBRACKET() throws RecognitionException {
        int FRAGMENT_RULE_SKW_LEFTBRACKET_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 87) ) { return ; }
            // InternalCPreprocessLexer.g:298:40: ( '[' )
            // InternalCPreprocessLexer.g:298:42: '['
            {
            match('['); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 87, FRAGMENT_RULE_SKW_LEFTBRACKET_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_LEFTBRACKET"

    // $ANTLR start "RULE_SKW_LEFTPAREN"
    public final void mRULE_SKW_LEFTPAREN() throws RecognitionException {
        int RULE_SKW_LEFTPAREN_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 88) ) { return ; }
            // InternalCPreprocessLexer.g:300:29: ( FRAGMENT_RULE_SKW_LEFTPAREN )
            // InternalCPreprocessLexer.g:300:31: FRAGMENT_RULE_SKW_LEFTPAREN
            {
            mFRAGMENT_RULE_SKW_LEFTPAREN(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 88, RULE_SKW_LEFTPAREN_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_LEFTPAREN"

    // $ANTLR start "FRAGMENT_RULE_SKW_LEFTPAREN"
    public final void mFRAGMENT_RULE_SKW_LEFTPAREN() throws RecognitionException {
        int FRAGMENT_RULE_SKW_LEFTPAREN_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 89) ) { return ; }
            // InternalCPreprocessLexer.g:301:38: ( '(' )
            // InternalCPreprocessLexer.g:301:40: '('
            {
            match('('); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 89, FRAGMENT_RULE_SKW_LEFTPAREN_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_LEFTPAREN"

    // $ANTLR start "RULE_SKW_LEFTSHIFT"
    public final void mRULE_SKW_LEFTSHIFT() throws RecognitionException {
        int RULE_SKW_LEFTSHIFT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 90) ) { return ; }
            // InternalCPreprocessLexer.g:303:29: ( FRAGMENT_RULE_SKW_LEFTSHIFT )
            // InternalCPreprocessLexer.g:303:31: FRAGMENT_RULE_SKW_LEFTSHIFT
            {
            mFRAGMENT_RULE_SKW_LEFTSHIFT(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 90, RULE_SKW_LEFTSHIFT_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_LEFTSHIFT"

    // $ANTLR start "FRAGMENT_RULE_SKW_LEFTSHIFT"
    public final void mFRAGMENT_RULE_SKW_LEFTSHIFT() throws RecognitionException {
        int FRAGMENT_RULE_SKW_LEFTSHIFT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 91) ) { return ; }
            // InternalCPreprocessLexer.g:304:38: ( RULE_SKW_LESS RULE_SKW_LESS )
            // InternalCPreprocessLexer.g:304:40: RULE_SKW_LESS RULE_SKW_LESS
            {
            mRULE_SKW_LESS(); if (state.failed) return ;
            mRULE_SKW_LESS(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 91, FRAGMENT_RULE_SKW_LEFTSHIFT_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_LEFTSHIFT"

    // $ANTLR start "RULE_SKW_LESS"
    public final void mRULE_SKW_LESS() throws RecognitionException {
        int RULE_SKW_LESS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 92) ) { return ; }
            // InternalCPreprocessLexer.g:306:24: ( FRAGMENT_RULE_SKW_LESS )
            // InternalCPreprocessLexer.g:306:26: FRAGMENT_RULE_SKW_LESS
            {
            mFRAGMENT_RULE_SKW_LESS(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 92, RULE_SKW_LESS_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_LESS"

    // $ANTLR start "FRAGMENT_RULE_SKW_LESS"
    public final void mFRAGMENT_RULE_SKW_LESS() throws RecognitionException {
        int FRAGMENT_RULE_SKW_LESS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 93) ) { return ; }
            // InternalCPreprocessLexer.g:307:33: ( '<' )
            // InternalCPreprocessLexer.g:307:35: '<'
            {
            match('<'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 93, FRAGMENT_RULE_SKW_LESS_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_LESS"

    // $ANTLR start "RULE_SKW_LESSEQUAL"
    public final void mRULE_SKW_LESSEQUAL() throws RecognitionException {
        int RULE_SKW_LESSEQUAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 94) ) { return ; }
            // InternalCPreprocessLexer.g:309:29: ( FRAGMENT_RULE_SKW_LESSEQUAL )
            // InternalCPreprocessLexer.g:309:31: FRAGMENT_RULE_SKW_LESSEQUAL
            {
            mFRAGMENT_RULE_SKW_LESSEQUAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 94, RULE_SKW_LESSEQUAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_LESSEQUAL"

    // $ANTLR start "FRAGMENT_RULE_SKW_LESSEQUAL"
    public final void mFRAGMENT_RULE_SKW_LESSEQUAL() throws RecognitionException {
        int FRAGMENT_RULE_SKW_LESSEQUAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 95) ) { return ; }
            // InternalCPreprocessLexer.g:310:38: ( RULE_SKW_LESS RULE_SKW_ASSIGN )
            // InternalCPreprocessLexer.g:310:40: RULE_SKW_LESS RULE_SKW_ASSIGN
            {
            mRULE_SKW_LESS(); if (state.failed) return ;
            mRULE_SKW_ASSIGN(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 95, FRAGMENT_RULE_SKW_LESSEQUAL_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_LESSEQUAL"

    // $ANTLR start "RULE_SKW_MINUS"
    public final void mRULE_SKW_MINUS() throws RecognitionException {
        int RULE_SKW_MINUS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 96) ) { return ; }
            // InternalCPreprocessLexer.g:312:25: ( FRAGMENT_RULE_SKW_MINUS )
            // InternalCPreprocessLexer.g:312:27: FRAGMENT_RULE_SKW_MINUS
            {
            mFRAGMENT_RULE_SKW_MINUS(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 96, RULE_SKW_MINUS_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_MINUS"

    // $ANTLR start "FRAGMENT_RULE_SKW_MINUS"
    public final void mFRAGMENT_RULE_SKW_MINUS() throws RecognitionException {
        int FRAGMENT_RULE_SKW_MINUS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 97) ) { return ; }
            // InternalCPreprocessLexer.g:313:34: ( '-' )
            // InternalCPreprocessLexer.g:313:36: '-'
            {
            match('-'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 97, FRAGMENT_RULE_SKW_MINUS_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_MINUS"

    // $ANTLR start "RULE_SKW_MINUSMINUS"
    public final void mRULE_SKW_MINUSMINUS() throws RecognitionException {
        int RULE_SKW_MINUSMINUS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 98) ) { return ; }
            // InternalCPreprocessLexer.g:315:30: ( FRAGMENT_RULE_SKW_MINUSMINUS )
            // InternalCPreprocessLexer.g:315:32: FRAGMENT_RULE_SKW_MINUSMINUS
            {
            mFRAGMENT_RULE_SKW_MINUSMINUS(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 98, RULE_SKW_MINUSMINUS_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_MINUSMINUS"

    // $ANTLR start "FRAGMENT_RULE_SKW_MINUSMINUS"
    public final void mFRAGMENT_RULE_SKW_MINUSMINUS() throws RecognitionException {
        int FRAGMENT_RULE_SKW_MINUSMINUS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 99) ) { return ; }
            // InternalCPreprocessLexer.g:316:39: ( RULE_SKW_MINUS RULE_SKW_MINUS )
            // InternalCPreprocessLexer.g:316:41: RULE_SKW_MINUS RULE_SKW_MINUS
            {
            mRULE_SKW_MINUS(); if (state.failed) return ;
            mRULE_SKW_MINUS(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 99, FRAGMENT_RULE_SKW_MINUSMINUS_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_MINUSMINUS"

    // $ANTLR start "RULE_SKW_MOD"
    public final void mRULE_SKW_MOD() throws RecognitionException {
        int RULE_SKW_MOD_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 100) ) { return ; }
            // InternalCPreprocessLexer.g:318:23: ( FRAGMENT_RULE_SKW_MOD )
            // InternalCPreprocessLexer.g:318:25: FRAGMENT_RULE_SKW_MOD
            {
            mFRAGMENT_RULE_SKW_MOD(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 100, RULE_SKW_MOD_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_MOD"

    // $ANTLR start "FRAGMENT_RULE_SKW_MOD"
    public final void mFRAGMENT_RULE_SKW_MOD() throws RecognitionException {
        int FRAGMENT_RULE_SKW_MOD_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 101) ) { return ; }
            // InternalCPreprocessLexer.g:319:32: ( '%' )
            // InternalCPreprocessLexer.g:319:34: '%'
            {
            match('%'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 101, FRAGMENT_RULE_SKW_MOD_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_MOD"

    // $ANTLR start "RULE_SKW_NOT"
    public final void mRULE_SKW_NOT() throws RecognitionException {
        int RULE_SKW_NOT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 102) ) { return ; }
            // InternalCPreprocessLexer.g:321:23: ( FRAGMENT_RULE_SKW_NOT )
            // InternalCPreprocessLexer.g:321:25: FRAGMENT_RULE_SKW_NOT
            {
            mFRAGMENT_RULE_SKW_NOT(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 102, RULE_SKW_NOT_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_NOT"

    // $ANTLR start "FRAGMENT_RULE_SKW_NOT"
    public final void mFRAGMENT_RULE_SKW_NOT() throws RecognitionException {
        int FRAGMENT_RULE_SKW_NOT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 103) ) { return ; }
            // InternalCPreprocessLexer.g:322:32: ( '!' )
            // InternalCPreprocessLexer.g:322:34: '!'
            {
            match('!'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 103, FRAGMENT_RULE_SKW_NOT_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_NOT"

    // $ANTLR start "RULE_SKW_NOTEQUAL"
    public final void mRULE_SKW_NOTEQUAL() throws RecognitionException {
        int RULE_SKW_NOTEQUAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 104) ) { return ; }
            // InternalCPreprocessLexer.g:324:28: ( FRAGMENT_RULE_SKW_NOTEQUAL )
            // InternalCPreprocessLexer.g:324:30: FRAGMENT_RULE_SKW_NOTEQUAL
            {
            mFRAGMENT_RULE_SKW_NOTEQUAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 104, RULE_SKW_NOTEQUAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_NOTEQUAL"

    // $ANTLR start "FRAGMENT_RULE_SKW_NOTEQUAL"
    public final void mFRAGMENT_RULE_SKW_NOTEQUAL() throws RecognitionException {
        int FRAGMENT_RULE_SKW_NOTEQUAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 105) ) { return ; }
            // InternalCPreprocessLexer.g:325:37: ( RULE_SKW_NOT RULE_SKW_ASSIGN )
            // InternalCPreprocessLexer.g:325:39: RULE_SKW_NOT RULE_SKW_ASSIGN
            {
            mRULE_SKW_NOT(); if (state.failed) return ;
            mRULE_SKW_ASSIGN(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 105, FRAGMENT_RULE_SKW_NOTEQUAL_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_NOTEQUAL"

    // $ANTLR start "RULE_SKW_OR"
    public final void mRULE_SKW_OR() throws RecognitionException {
        int RULE_SKW_OR_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 106) ) { return ; }
            // InternalCPreprocessLexer.g:327:22: ( FRAGMENT_RULE_SKW_OR )
            // InternalCPreprocessLexer.g:327:24: FRAGMENT_RULE_SKW_OR
            {
            mFRAGMENT_RULE_SKW_OR(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 106, RULE_SKW_OR_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_OR"

    // $ANTLR start "FRAGMENT_RULE_SKW_OR"
    public final void mFRAGMENT_RULE_SKW_OR() throws RecognitionException {
        int FRAGMENT_RULE_SKW_OR_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 107) ) { return ; }
            // InternalCPreprocessLexer.g:328:31: ( '|' )
            // InternalCPreprocessLexer.g:328:33: '|'
            {
            match('|'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 107, FRAGMENT_RULE_SKW_OR_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_OR"

    // $ANTLR start "RULE_SKW_OROR"
    public final void mRULE_SKW_OROR() throws RecognitionException {
        int RULE_SKW_OROR_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 108) ) { return ; }
            // InternalCPreprocessLexer.g:330:24: ( FRAGMENT_RULE_SKW_OROR )
            // InternalCPreprocessLexer.g:330:26: FRAGMENT_RULE_SKW_OROR
            {
            mFRAGMENT_RULE_SKW_OROR(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 108, RULE_SKW_OROR_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_OROR"

    // $ANTLR start "FRAGMENT_RULE_SKW_OROR"
    public final void mFRAGMENT_RULE_SKW_OROR() throws RecognitionException {
        int FRAGMENT_RULE_SKW_OROR_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 109) ) { return ; }
            // InternalCPreprocessLexer.g:331:33: ( RULE_SKW_OR RULE_SKW_OR )
            // InternalCPreprocessLexer.g:331:35: RULE_SKW_OR RULE_SKW_OR
            {
            mRULE_SKW_OR(); if (state.failed) return ;
            mRULE_SKW_OR(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 109, FRAGMENT_RULE_SKW_OROR_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_OROR"

    // $ANTLR start "RULE_SKW_PLUS"
    public final void mRULE_SKW_PLUS() throws RecognitionException {
        int RULE_SKW_PLUS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 110) ) { return ; }
            // InternalCPreprocessLexer.g:333:24: ( FRAGMENT_RULE_SKW_PLUS )
            // InternalCPreprocessLexer.g:333:26: FRAGMENT_RULE_SKW_PLUS
            {
            mFRAGMENT_RULE_SKW_PLUS(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 110, RULE_SKW_PLUS_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_PLUS"

    // $ANTLR start "FRAGMENT_RULE_SKW_PLUS"
    public final void mFRAGMENT_RULE_SKW_PLUS() throws RecognitionException {
        int FRAGMENT_RULE_SKW_PLUS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 111) ) { return ; }
            // InternalCPreprocessLexer.g:334:33: ( '+' )
            // InternalCPreprocessLexer.g:334:35: '+'
            {
            match('+'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 111, FRAGMENT_RULE_SKW_PLUS_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_PLUS"

    // $ANTLR start "RULE_SKW_PLUSPLUS"
    public final void mRULE_SKW_PLUSPLUS() throws RecognitionException {
        int RULE_SKW_PLUSPLUS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 112) ) { return ; }
            // InternalCPreprocessLexer.g:336:28: ( FRAGMENT_RULE_SKW_PLUSPLUS )
            // InternalCPreprocessLexer.g:336:30: FRAGMENT_RULE_SKW_PLUSPLUS
            {
            mFRAGMENT_RULE_SKW_PLUSPLUS(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 112, RULE_SKW_PLUSPLUS_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_PLUSPLUS"

    // $ANTLR start "FRAGMENT_RULE_SKW_PLUSPLUS"
    public final void mFRAGMENT_RULE_SKW_PLUSPLUS() throws RecognitionException {
        int FRAGMENT_RULE_SKW_PLUSPLUS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 113) ) { return ; }
            // InternalCPreprocessLexer.g:337:37: ( RULE_SKW_PLUS RULE_SKW_PLUS )
            // InternalCPreprocessLexer.g:337:39: RULE_SKW_PLUS RULE_SKW_PLUS
            {
            mRULE_SKW_PLUS(); if (state.failed) return ;
            mRULE_SKW_PLUS(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 113, FRAGMENT_RULE_SKW_PLUSPLUS_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_PLUSPLUS"

    // $ANTLR start "RULE_SKW_QUESTION"
    public final void mRULE_SKW_QUESTION() throws RecognitionException {
        int RULE_SKW_QUESTION_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 114) ) { return ; }
            // InternalCPreprocessLexer.g:339:28: ( FRAGMENT_RULE_SKW_QUESTION )
            // InternalCPreprocessLexer.g:339:30: FRAGMENT_RULE_SKW_QUESTION
            {
            mFRAGMENT_RULE_SKW_QUESTION(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 114, RULE_SKW_QUESTION_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_QUESTION"

    // $ANTLR start "FRAGMENT_RULE_SKW_QUESTION"
    public final void mFRAGMENT_RULE_SKW_QUESTION() throws RecognitionException {
        int FRAGMENT_RULE_SKW_QUESTION_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 115) ) { return ; }
            // InternalCPreprocessLexer.g:340:37: ( '?' )
            // InternalCPreprocessLexer.g:340:39: '?'
            {
            match('?'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 115, FRAGMENT_RULE_SKW_QUESTION_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_QUESTION"

    // $ANTLR start "RULE_SKW_RIGHTBRACE"
    public final void mRULE_SKW_RIGHTBRACE() throws RecognitionException {
        int RULE_SKW_RIGHTBRACE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 116) ) { return ; }
            // InternalCPreprocessLexer.g:342:30: ( FRAGMENT_RULE_SKW_RIGHTBRACE )
            // InternalCPreprocessLexer.g:342:32: FRAGMENT_RULE_SKW_RIGHTBRACE
            {
            mFRAGMENT_RULE_SKW_RIGHTBRACE(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 116, RULE_SKW_RIGHTBRACE_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_RIGHTBRACE"

    // $ANTLR start "FRAGMENT_RULE_SKW_RIGHTBRACE"
    public final void mFRAGMENT_RULE_SKW_RIGHTBRACE() throws RecognitionException {
        int FRAGMENT_RULE_SKW_RIGHTBRACE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 117) ) { return ; }
            // InternalCPreprocessLexer.g:343:39: ( '}' )
            // InternalCPreprocessLexer.g:343:41: '}'
            {
            match('}'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 117, FRAGMENT_RULE_SKW_RIGHTBRACE_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_RIGHTBRACE"

    // $ANTLR start "RULE_SKW_RIGHTBRACKET"
    public final void mRULE_SKW_RIGHTBRACKET() throws RecognitionException {
        int RULE_SKW_RIGHTBRACKET_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 118) ) { return ; }
            // InternalCPreprocessLexer.g:345:32: ( FRAGMENT_RULE_SKW_RIGHTBRACKET )
            // InternalCPreprocessLexer.g:345:34: FRAGMENT_RULE_SKW_RIGHTBRACKET
            {
            mFRAGMENT_RULE_SKW_RIGHTBRACKET(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 118, RULE_SKW_RIGHTBRACKET_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_RIGHTBRACKET"

    // $ANTLR start "FRAGMENT_RULE_SKW_RIGHTBRACKET"
    public final void mFRAGMENT_RULE_SKW_RIGHTBRACKET() throws RecognitionException {
        int FRAGMENT_RULE_SKW_RIGHTBRACKET_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 119) ) { return ; }
            // InternalCPreprocessLexer.g:346:41: ( ']' )
            // InternalCPreprocessLexer.g:346:43: ']'
            {
            match(']'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 119, FRAGMENT_RULE_SKW_RIGHTBRACKET_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_RIGHTBRACKET"

    // $ANTLR start "RULE_SKW_RIGHTPAREN"
    public final void mRULE_SKW_RIGHTPAREN() throws RecognitionException {
        int RULE_SKW_RIGHTPAREN_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 120) ) { return ; }
            // InternalCPreprocessLexer.g:348:30: ( FRAGMENT_RULE_SKW_RIGHTPAREN )
            // InternalCPreprocessLexer.g:348:32: FRAGMENT_RULE_SKW_RIGHTPAREN
            {
            mFRAGMENT_RULE_SKW_RIGHTPAREN(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 120, RULE_SKW_RIGHTPAREN_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_RIGHTPAREN"

    // $ANTLR start "FRAGMENT_RULE_SKW_RIGHTPAREN"
    public final void mFRAGMENT_RULE_SKW_RIGHTPAREN() throws RecognitionException {
        int FRAGMENT_RULE_SKW_RIGHTPAREN_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 121) ) { return ; }
            // InternalCPreprocessLexer.g:349:39: ( ')' )
            // InternalCPreprocessLexer.g:349:41: ')'
            {
            match(')'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 121, FRAGMENT_RULE_SKW_RIGHTPAREN_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_RIGHTPAREN"

    // $ANTLR start "RULE_SKW_RIGHTSHIFT"
    public final void mRULE_SKW_RIGHTSHIFT() throws RecognitionException {
        int RULE_SKW_RIGHTSHIFT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 122) ) { return ; }
            // InternalCPreprocessLexer.g:351:30: ( FRAGMENT_RULE_SKW_RIGHTSHIFT )
            // InternalCPreprocessLexer.g:351:32: FRAGMENT_RULE_SKW_RIGHTSHIFT
            {
            mFRAGMENT_RULE_SKW_RIGHTSHIFT(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 122, RULE_SKW_RIGHTSHIFT_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_RIGHTSHIFT"

    // $ANTLR start "FRAGMENT_RULE_SKW_RIGHTSHIFT"
    public final void mFRAGMENT_RULE_SKW_RIGHTSHIFT() throws RecognitionException {
        int FRAGMENT_RULE_SKW_RIGHTSHIFT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 123) ) { return ; }
            // InternalCPreprocessLexer.g:352:39: ( RULE_SKW_GREATER RULE_SKW_GREATER )
            // InternalCPreprocessLexer.g:352:41: RULE_SKW_GREATER RULE_SKW_GREATER
            {
            mRULE_SKW_GREATER(); if (state.failed) return ;
            mRULE_SKW_GREATER(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 123, FRAGMENT_RULE_SKW_RIGHTSHIFT_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_RIGHTSHIFT"

    // $ANTLR start "RULE_SKW_SEMI"
    public final void mRULE_SKW_SEMI() throws RecognitionException {
        int RULE_SKW_SEMI_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 124) ) { return ; }
            // InternalCPreprocessLexer.g:354:24: ( FRAGMENT_RULE_SKW_SEMI )
            // InternalCPreprocessLexer.g:354:26: FRAGMENT_RULE_SKW_SEMI
            {
            mFRAGMENT_RULE_SKW_SEMI(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 124, RULE_SKW_SEMI_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_SEMI"

    // $ANTLR start "FRAGMENT_RULE_SKW_SEMI"
    public final void mFRAGMENT_RULE_SKW_SEMI() throws RecognitionException {
        int FRAGMENT_RULE_SKW_SEMI_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 125) ) { return ; }
            // InternalCPreprocessLexer.g:355:33: ( ';' )
            // InternalCPreprocessLexer.g:355:35: ';'
            {
            match(';'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 125, FRAGMENT_RULE_SKW_SEMI_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_SEMI"

    // $ANTLR start "RULE_SKW_SINGLEQUOTE"
    public final void mRULE_SKW_SINGLEQUOTE() throws RecognitionException {
        int RULE_SKW_SINGLEQUOTE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 126) ) { return ; }
            // InternalCPreprocessLexer.g:357:31: ( FRAGMENT_RULE_SKW_SINGLEQUOTE )
            // InternalCPreprocessLexer.g:357:33: FRAGMENT_RULE_SKW_SINGLEQUOTE
            {
            mFRAGMENT_RULE_SKW_SINGLEQUOTE(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 126, RULE_SKW_SINGLEQUOTE_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_SINGLEQUOTE"

    // $ANTLR start "FRAGMENT_RULE_SKW_SINGLEQUOTE"
    public final void mFRAGMENT_RULE_SKW_SINGLEQUOTE() throws RecognitionException {
        int FRAGMENT_RULE_SKW_SINGLEQUOTE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 127) ) { return ; }
            // InternalCPreprocessLexer.g:358:40: ( '\\'' )
            // InternalCPreprocessLexer.g:358:42: '\\''
            {
            match('\''); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 127, FRAGMENT_RULE_SKW_SINGLEQUOTE_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_SINGLEQUOTE"

    // $ANTLR start "RULE_SKW_STAR"
    public final void mRULE_SKW_STAR() throws RecognitionException {
        int RULE_SKW_STAR_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 128) ) { return ; }
            // InternalCPreprocessLexer.g:360:24: ( FRAGMENT_RULE_SKW_STAR )
            // InternalCPreprocessLexer.g:360:26: FRAGMENT_RULE_SKW_STAR
            {
            mFRAGMENT_RULE_SKW_STAR(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 128, RULE_SKW_STAR_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_STAR"

    // $ANTLR start "FRAGMENT_RULE_SKW_STAR"
    public final void mFRAGMENT_RULE_SKW_STAR() throws RecognitionException {
        int FRAGMENT_RULE_SKW_STAR_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 129) ) { return ; }
            // InternalCPreprocessLexer.g:361:33: ( '*' )
            // InternalCPreprocessLexer.g:361:35: '*'
            {
            match('*'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 129, FRAGMENT_RULE_SKW_STAR_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_STAR"

    // $ANTLR start "RULE_SKW_TILDE"
    public final void mRULE_SKW_TILDE() throws RecognitionException {
        int RULE_SKW_TILDE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 130) ) { return ; }
            // InternalCPreprocessLexer.g:363:25: ( FRAGMENT_RULE_SKW_TILDE )
            // InternalCPreprocessLexer.g:363:27: FRAGMENT_RULE_SKW_TILDE
            {
            mFRAGMENT_RULE_SKW_TILDE(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 130, RULE_SKW_TILDE_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_TILDE"

    // $ANTLR start "FRAGMENT_RULE_SKW_TILDE"
    public final void mFRAGMENT_RULE_SKW_TILDE() throws RecognitionException {
        int FRAGMENT_RULE_SKW_TILDE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 131) ) { return ; }
            // InternalCPreprocessLexer.g:364:34: ( '~' )
            // InternalCPreprocessLexer.g:364:36: '~'
            {
            match('~'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 131, FRAGMENT_RULE_SKW_TILDE_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_TILDE"

    // $ANTLR start "RULE_SKW_UNDERSCORE"
    public final void mRULE_SKW_UNDERSCORE() throws RecognitionException {
        int RULE_SKW_UNDERSCORE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 132) ) { return ; }
            // InternalCPreprocessLexer.g:366:30: ( '_' )
            // InternalCPreprocessLexer.g:366:32: '_'
            {
            match('_'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 132, RULE_SKW_UNDERSCORE_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_UNDERSCORE"

    // $ANTLR start "RULE_SPECIAL"
    public final void mRULE_SPECIAL() throws RecognitionException {
        int RULE_SPECIAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 133) ) { return ; }
            // InternalCPreprocessLexer.g:368:23: ( FRAGMENT_RULE_SPECIAL )
            // InternalCPreprocessLexer.g:368:25: FRAGMENT_RULE_SPECIAL
            {
            mFRAGMENT_RULE_SPECIAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 133, RULE_SPECIAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SPECIAL"

    // $ANTLR start "FRAGMENT_RULE_SPECIAL"
    public final void mFRAGMENT_RULE_SPECIAL() throws RecognitionException {
        int FRAGMENT_RULE_SPECIAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 134) ) { return ; }
            // InternalCPreprocessLexer.g:369:32: ( . )
            // InternalCPreprocessLexer.g:369:34: .
            {
            matchAny(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 134, FRAGMENT_RULE_SPECIAL_StartIndex); }
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
        // InternalCPreprocessLexer.g:101:2: ( FRAGMENT_RULE_HASH )
        // InternalCPreprocessLexer.g:101:3: FRAGMENT_RULE_HASH
        {
        mFRAGMENT_RULE_HASH(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalCPreprocessLexer

    // $ANTLR start synpred2_InternalCPreprocessLexer
    public final void synpred2_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:102:2: ( FRAGMENT_RULE_INCLUDE )
        // InternalCPreprocessLexer.g:102:3: FRAGMENT_RULE_INCLUDE
        {
        mFRAGMENT_RULE_INCLUDE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_InternalCPreprocessLexer

    // $ANTLR start synpred3_InternalCPreprocessLexer
    public final void synpred3_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:103:2: ( FRAGMENT_RULE_DEFINE )
        // InternalCPreprocessLexer.g:103:3: FRAGMENT_RULE_DEFINE
        {
        mFRAGMENT_RULE_DEFINE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_InternalCPreprocessLexer

    // $ANTLR start synpred4_InternalCPreprocessLexer
    public final void synpred4_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:104:2: ( FRAGMENT_RULE_ERROR )
        // InternalCPreprocessLexer.g:104:3: FRAGMENT_RULE_ERROR
        {
        mFRAGMENT_RULE_ERROR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_InternalCPreprocessLexer

    // $ANTLR start synpred5_InternalCPreprocessLexer
    public final void synpred5_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:105:2: ( FRAGMENT_RULE_UNDEF )
        // InternalCPreprocessLexer.g:105:3: FRAGMENT_RULE_UNDEF
        {
        mFRAGMENT_RULE_UNDEF(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_InternalCPreprocessLexer

    // $ANTLR start synpred6_InternalCPreprocessLexer
    public final void synpred6_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:106:2: ( FRAGMENT_RULE_IF )
        // InternalCPreprocessLexer.g:106:3: FRAGMENT_RULE_IF
        {
        mFRAGMENT_RULE_IF(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_InternalCPreprocessLexer

    // $ANTLR start synpred7_InternalCPreprocessLexer
    public final void synpred7_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:107:2: ( FRAGMENT_RULE_IFDEF )
        // InternalCPreprocessLexer.g:107:3: FRAGMENT_RULE_IFDEF
        {
        mFRAGMENT_RULE_IFDEF(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_InternalCPreprocessLexer

    // $ANTLR start synpred8_InternalCPreprocessLexer
    public final void synpred8_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:108:2: ( FRAGMENT_RULE_IFNOTDEF )
        // InternalCPreprocessLexer.g:108:3: FRAGMENT_RULE_IFNOTDEF
        {
        mFRAGMENT_RULE_IFNOTDEF(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_InternalCPreprocessLexer

    // $ANTLR start synpred9_InternalCPreprocessLexer
    public final void synpred9_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:109:2: ( FRAGMENT_RULE_ENDIF )
        // InternalCPreprocessLexer.g:109:3: FRAGMENT_RULE_ENDIF
        {
        mFRAGMENT_RULE_ENDIF(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_InternalCPreprocessLexer

    // $ANTLR start synpred10_InternalCPreprocessLexer
    public final void synpred10_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:110:2: ( FRAGMENT_RULE_PRAGMA )
        // InternalCPreprocessLexer.g:110:3: FRAGMENT_RULE_PRAGMA
        {
        mFRAGMENT_RULE_PRAGMA(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_InternalCPreprocessLexer

    // $ANTLR start synpred11_InternalCPreprocessLexer
    public final void synpred11_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:111:2: ( FRAGMENT_RULE_NEWLINE )
        // InternalCPreprocessLexer.g:111:3: FRAGMENT_RULE_NEWLINE
        {
        mFRAGMENT_RULE_NEWLINE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_InternalCPreprocessLexer

    // $ANTLR start synpred12_InternalCPreprocessLexer
    public final void synpred12_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:112:2: ( FRAGMENT_RULE_WS )
        // InternalCPreprocessLexer.g:112:3: FRAGMENT_RULE_WS
        {
        mFRAGMENT_RULE_WS(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_InternalCPreprocessLexer

    // $ANTLR start synpred13_InternalCPreprocessLexer
    public final void synpred13_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:113:2: ( FRAGMENT_RULE_ID )
        // InternalCPreprocessLexer.g:113:3: FRAGMENT_RULE_ID
        {
        mFRAGMENT_RULE_ID(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_InternalCPreprocessLexer

    // $ANTLR start synpred14_InternalCPreprocessLexer
    public final void synpred14_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:114:2: ( FRAGMENT_RULE_CHAR_LITERAL )
        // InternalCPreprocessLexer.g:114:3: FRAGMENT_RULE_CHAR_LITERAL
        {
        mFRAGMENT_RULE_CHAR_LITERAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_InternalCPreprocessLexer

    // $ANTLR start synpred15_InternalCPreprocessLexer
    public final void synpred15_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:115:2: ( FRAGMENT_RULE_STRING_LITERAL )
        // InternalCPreprocessLexer.g:115:3: FRAGMENT_RULE_STRING_LITERAL
        {
        mFRAGMENT_RULE_STRING_LITERAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_InternalCPreprocessLexer

    // $ANTLR start synpred16_InternalCPreprocessLexer
    public final void synpred16_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:116:2: ( FRAGMENT_RULE_HEX_LITERAL )
        // InternalCPreprocessLexer.g:116:3: FRAGMENT_RULE_HEX_LITERAL
        {
        mFRAGMENT_RULE_HEX_LITERAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_InternalCPreprocessLexer

    // $ANTLR start synpred17_InternalCPreprocessLexer
    public final void synpred17_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:117:2: ( FRAGMENT_RULE_DECIMAL_LITERAL )
        // InternalCPreprocessLexer.g:117:3: FRAGMENT_RULE_DECIMAL_LITERAL
        {
        mFRAGMENT_RULE_DECIMAL_LITERAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_InternalCPreprocessLexer

    // $ANTLR start synpred18_InternalCPreprocessLexer
    public final void synpred18_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:118:2: ( FRAGMENT_RULE_OCTAL_LITERAL )
        // InternalCPreprocessLexer.g:118:3: FRAGMENT_RULE_OCTAL_LITERAL
        {
        mFRAGMENT_RULE_OCTAL_LITERAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_InternalCPreprocessLexer

    // $ANTLR start synpred19_InternalCPreprocessLexer
    public final void synpred19_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:119:2: ( FRAGMENT_RULE_BIN_LITERAL )
        // InternalCPreprocessLexer.g:119:3: FRAGMENT_RULE_BIN_LITERAL
        {
        mFRAGMENT_RULE_BIN_LITERAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_InternalCPreprocessLexer

    // $ANTLR start synpred20_InternalCPreprocessLexer
    public final void synpred20_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:120:2: ( FRAGMENT_RULE_FLOAT_LITERAL )
        // InternalCPreprocessLexer.g:120:3: FRAGMENT_RULE_FLOAT_LITERAL
        {
        mFRAGMENT_RULE_FLOAT_LITERAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_InternalCPreprocessLexer

    // $ANTLR start synpred21_InternalCPreprocessLexer
    public final void synpred21_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:121:2: ( FRAGMENT_RULE_SKW_AND )
        // InternalCPreprocessLexer.g:121:3: FRAGMENT_RULE_SKW_AND
        {
        mFRAGMENT_RULE_SKW_AND(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_InternalCPreprocessLexer

    // $ANTLR start synpred22_InternalCPreprocessLexer
    public final void synpred22_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:122:2: ( FRAGMENT_RULE_SKW_ANDAND )
        // InternalCPreprocessLexer.g:122:3: FRAGMENT_RULE_SKW_ANDAND
        {
        mFRAGMENT_RULE_SKW_ANDAND(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_InternalCPreprocessLexer

    // $ANTLR start synpred23_InternalCPreprocessLexer
    public final void synpred23_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:123:2: ( FRAGMENT_RULE_SKW_ASSIGN )
        // InternalCPreprocessLexer.g:123:3: FRAGMENT_RULE_SKW_ASSIGN
        {
        mFRAGMENT_RULE_SKW_ASSIGN(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_InternalCPreprocessLexer

    // $ANTLR start synpred24_InternalCPreprocessLexer
    public final void synpred24_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:124:2: ( FRAGMENT_RULE_SKW_BACKSLASH )
        // InternalCPreprocessLexer.g:124:3: FRAGMENT_RULE_SKW_BACKSLASH
        {
        mFRAGMENT_RULE_SKW_BACKSLASH(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_InternalCPreprocessLexer

    // $ANTLR start synpred25_InternalCPreprocessLexer
    public final void synpred25_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:125:2: ( FRAGMENT_RULE_SKW_CARET )
        // InternalCPreprocessLexer.g:125:3: FRAGMENT_RULE_SKW_CARET
        {
        mFRAGMENT_RULE_SKW_CARET(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_InternalCPreprocessLexer

    // $ANTLR start synpred26_InternalCPreprocessLexer
    public final void synpred26_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:126:2: ( FRAGMENT_RULE_SKW_COMMA )
        // InternalCPreprocessLexer.g:126:3: FRAGMENT_RULE_SKW_COMMA
        {
        mFRAGMENT_RULE_SKW_COMMA(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_InternalCPreprocessLexer

    // $ANTLR start synpred27_InternalCPreprocessLexer
    public final void synpred27_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:127:2: ( FRAGMENT_RULE_SKW_COLON )
        // InternalCPreprocessLexer.g:127:3: FRAGMENT_RULE_SKW_COLON
        {
        mFRAGMENT_RULE_SKW_COLON(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_InternalCPreprocessLexer

    // $ANTLR start synpred28_InternalCPreprocessLexer
    public final void synpred28_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:128:2: ( FRAGMENT_RULE_SKW_DIV )
        // InternalCPreprocessLexer.g:128:3: FRAGMENT_RULE_SKW_DIV
        {
        mFRAGMENT_RULE_SKW_DIV(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_InternalCPreprocessLexer

    // $ANTLR start synpred29_InternalCPreprocessLexer
    public final void synpred29_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:129:2: ( FRAGMENT_RULE_SKW_DOT )
        // InternalCPreprocessLexer.g:129:3: FRAGMENT_RULE_SKW_DOT
        {
        mFRAGMENT_RULE_SKW_DOT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_InternalCPreprocessLexer

    // $ANTLR start synpred30_InternalCPreprocessLexer
    public final void synpred30_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:130:2: ( FRAGMENT_RULE_SKW_DOUBLEQUOTE )
        // InternalCPreprocessLexer.g:130:3: FRAGMENT_RULE_SKW_DOUBLEQUOTE
        {
        mFRAGMENT_RULE_SKW_DOUBLEQUOTE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_InternalCPreprocessLexer

    // $ANTLR start synpred31_InternalCPreprocessLexer
    public final void synpred31_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:131:2: ( FRAGMENT_RULE_SKW_EQUAL )
        // InternalCPreprocessLexer.g:131:3: FRAGMENT_RULE_SKW_EQUAL
        {
        mFRAGMENT_RULE_SKW_EQUAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_InternalCPreprocessLexer

    // $ANTLR start synpred32_InternalCPreprocessLexer
    public final void synpred32_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:132:2: ( FRAGMENT_RULE_SKW_GREATER )
        // InternalCPreprocessLexer.g:132:3: FRAGMENT_RULE_SKW_GREATER
        {
        mFRAGMENT_RULE_SKW_GREATER(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_InternalCPreprocessLexer

    // $ANTLR start synpred33_InternalCPreprocessLexer
    public final void synpred33_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:133:2: ( FRAGMENT_RULE_SKW_GREATEREQUAL )
        // InternalCPreprocessLexer.g:133:3: FRAGMENT_RULE_SKW_GREATEREQUAL
        {
        mFRAGMENT_RULE_SKW_GREATEREQUAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_InternalCPreprocessLexer

    // $ANTLR start synpred34_InternalCPreprocessLexer
    public final void synpred34_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:134:2: ( FRAGMENT_RULE_SKW_LEFTBRACE )
        // InternalCPreprocessLexer.g:134:3: FRAGMENT_RULE_SKW_LEFTBRACE
        {
        mFRAGMENT_RULE_SKW_LEFTBRACE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_InternalCPreprocessLexer

    // $ANTLR start synpred35_InternalCPreprocessLexer
    public final void synpred35_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:135:2: ( FRAGMENT_RULE_SKW_LEFTBRACKET )
        // InternalCPreprocessLexer.g:135:3: FRAGMENT_RULE_SKW_LEFTBRACKET
        {
        mFRAGMENT_RULE_SKW_LEFTBRACKET(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_InternalCPreprocessLexer

    // $ANTLR start synpred36_InternalCPreprocessLexer
    public final void synpred36_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:136:2: ( FRAGMENT_RULE_SKW_LEFTPAREN )
        // InternalCPreprocessLexer.g:136:3: FRAGMENT_RULE_SKW_LEFTPAREN
        {
        mFRAGMENT_RULE_SKW_LEFTPAREN(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred36_InternalCPreprocessLexer

    // $ANTLR start synpred37_InternalCPreprocessLexer
    public final void synpred37_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:137:2: ( FRAGMENT_RULE_SKW_LEFTSHIFT )
        // InternalCPreprocessLexer.g:137:3: FRAGMENT_RULE_SKW_LEFTSHIFT
        {
        mFRAGMENT_RULE_SKW_LEFTSHIFT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_InternalCPreprocessLexer

    // $ANTLR start synpred38_InternalCPreprocessLexer
    public final void synpred38_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:138:2: ( FRAGMENT_RULE_SKW_LESS )
        // InternalCPreprocessLexer.g:138:3: FRAGMENT_RULE_SKW_LESS
        {
        mFRAGMENT_RULE_SKW_LESS(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_InternalCPreprocessLexer

    // $ANTLR start synpred39_InternalCPreprocessLexer
    public final void synpred39_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:139:2: ( FRAGMENT_RULE_SKW_LESSEQUAL )
        // InternalCPreprocessLexer.g:139:3: FRAGMENT_RULE_SKW_LESSEQUAL
        {
        mFRAGMENT_RULE_SKW_LESSEQUAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_InternalCPreprocessLexer

    // $ANTLR start synpred40_InternalCPreprocessLexer
    public final void synpred40_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:140:2: ( FRAGMENT_RULE_SKW_MINUS )
        // InternalCPreprocessLexer.g:140:3: FRAGMENT_RULE_SKW_MINUS
        {
        mFRAGMENT_RULE_SKW_MINUS(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred40_InternalCPreprocessLexer

    // $ANTLR start synpred41_InternalCPreprocessLexer
    public final void synpred41_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:141:2: ( FRAGMENT_RULE_SKW_MINUSMINUS )
        // InternalCPreprocessLexer.g:141:3: FRAGMENT_RULE_SKW_MINUSMINUS
        {
        mFRAGMENT_RULE_SKW_MINUSMINUS(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred41_InternalCPreprocessLexer

    // $ANTLR start synpred42_InternalCPreprocessLexer
    public final void synpred42_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:142:2: ( FRAGMENT_RULE_SKW_MOD )
        // InternalCPreprocessLexer.g:142:3: FRAGMENT_RULE_SKW_MOD
        {
        mFRAGMENT_RULE_SKW_MOD(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_InternalCPreprocessLexer

    // $ANTLR start synpred43_InternalCPreprocessLexer
    public final void synpred43_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:143:2: ( FRAGMENT_RULE_SKW_NOT )
        // InternalCPreprocessLexer.g:143:3: FRAGMENT_RULE_SKW_NOT
        {
        mFRAGMENT_RULE_SKW_NOT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_InternalCPreprocessLexer

    // $ANTLR start synpred44_InternalCPreprocessLexer
    public final void synpred44_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:144:2: ( FRAGMENT_RULE_SKW_NOTEQUAL )
        // InternalCPreprocessLexer.g:144:3: FRAGMENT_RULE_SKW_NOTEQUAL
        {
        mFRAGMENT_RULE_SKW_NOTEQUAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_InternalCPreprocessLexer

    // $ANTLR start synpred45_InternalCPreprocessLexer
    public final void synpred45_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:145:2: ( FRAGMENT_RULE_SKW_OR )
        // InternalCPreprocessLexer.g:145:3: FRAGMENT_RULE_SKW_OR
        {
        mFRAGMENT_RULE_SKW_OR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_InternalCPreprocessLexer

    // $ANTLR start synpred46_InternalCPreprocessLexer
    public final void synpred46_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:146:2: ( FRAGMENT_RULE_SKW_OROR )
        // InternalCPreprocessLexer.g:146:3: FRAGMENT_RULE_SKW_OROR
        {
        mFRAGMENT_RULE_SKW_OROR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_InternalCPreprocessLexer

    // $ANTLR start synpred47_InternalCPreprocessLexer
    public final void synpred47_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:147:2: ( FRAGMENT_RULE_SKW_PLUS )
        // InternalCPreprocessLexer.g:147:3: FRAGMENT_RULE_SKW_PLUS
        {
        mFRAGMENT_RULE_SKW_PLUS(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_InternalCPreprocessLexer

    // $ANTLR start synpred48_InternalCPreprocessLexer
    public final void synpred48_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:148:2: ( FRAGMENT_RULE_SKW_PLUSPLUS )
        // InternalCPreprocessLexer.g:148:3: FRAGMENT_RULE_SKW_PLUSPLUS
        {
        mFRAGMENT_RULE_SKW_PLUSPLUS(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_InternalCPreprocessLexer

    // $ANTLR start synpred49_InternalCPreprocessLexer
    public final void synpred49_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:149:2: ( FRAGMENT_RULE_SKW_QUESTION )
        // InternalCPreprocessLexer.g:149:3: FRAGMENT_RULE_SKW_QUESTION
        {
        mFRAGMENT_RULE_SKW_QUESTION(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_InternalCPreprocessLexer

    // $ANTLR start synpred50_InternalCPreprocessLexer
    public final void synpred50_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:150:2: ( FRAGMENT_RULE_SKW_RIGHTBRACE )
        // InternalCPreprocessLexer.g:150:3: FRAGMENT_RULE_SKW_RIGHTBRACE
        {
        mFRAGMENT_RULE_SKW_RIGHTBRACE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_InternalCPreprocessLexer

    // $ANTLR start synpred51_InternalCPreprocessLexer
    public final void synpred51_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:151:2: ( FRAGMENT_RULE_SKW_RIGHTBRACKET )
        // InternalCPreprocessLexer.g:151:3: FRAGMENT_RULE_SKW_RIGHTBRACKET
        {
        mFRAGMENT_RULE_SKW_RIGHTBRACKET(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred51_InternalCPreprocessLexer

    // $ANTLR start synpred52_InternalCPreprocessLexer
    public final void synpred52_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:152:2: ( FRAGMENT_RULE_SKW_RIGHTPAREN )
        // InternalCPreprocessLexer.g:152:3: FRAGMENT_RULE_SKW_RIGHTPAREN
        {
        mFRAGMENT_RULE_SKW_RIGHTPAREN(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred52_InternalCPreprocessLexer

    // $ANTLR start synpred53_InternalCPreprocessLexer
    public final void synpred53_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:153:2: ( FRAGMENT_RULE_SKW_RIGHTSHIFT )
        // InternalCPreprocessLexer.g:153:3: FRAGMENT_RULE_SKW_RIGHTSHIFT
        {
        mFRAGMENT_RULE_SKW_RIGHTSHIFT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_InternalCPreprocessLexer

    // $ANTLR start synpred54_InternalCPreprocessLexer
    public final void synpred54_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:154:2: ( FRAGMENT_RULE_SKW_SEMI )
        // InternalCPreprocessLexer.g:154:3: FRAGMENT_RULE_SKW_SEMI
        {
        mFRAGMENT_RULE_SKW_SEMI(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_InternalCPreprocessLexer

    // $ANTLR start synpred55_InternalCPreprocessLexer
    public final void synpred55_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:155:2: ( FRAGMENT_RULE_SKW_SINGLEQUOTE )
        // InternalCPreprocessLexer.g:155:3: FRAGMENT_RULE_SKW_SINGLEQUOTE
        {
        mFRAGMENT_RULE_SKW_SINGLEQUOTE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred55_InternalCPreprocessLexer

    // $ANTLR start synpred56_InternalCPreprocessLexer
    public final void synpred56_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:156:2: ( FRAGMENT_RULE_SKW_STAR )
        // InternalCPreprocessLexer.g:156:3: FRAGMENT_RULE_SKW_STAR
        {
        mFRAGMENT_RULE_SKW_STAR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_InternalCPreprocessLexer

    // $ANTLR start synpred57_InternalCPreprocessLexer
    public final void synpred57_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:157:2: ( FRAGMENT_RULE_SKW_TILDE )
        // InternalCPreprocessLexer.g:157:3: FRAGMENT_RULE_SKW_TILDE
        {
        mFRAGMENT_RULE_SKW_TILDE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred57_InternalCPreprocessLexer

    // $ANTLR start synpred58_InternalCPreprocessLexer
    public final void synpred58_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:158:2: ( FRAGMENT_RULE_SPECIAL )
        // InternalCPreprocessLexer.g:158:3: FRAGMENT_RULE_SPECIAL
        {
        mFRAGMENT_RULE_SPECIAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred58_InternalCPreprocessLexer

    // $ANTLR start synpred89_InternalCPreprocessLexer
    public final void synpred89_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:236:38: ( ( 'u' | 'U' )? ( 'l' | 'L' ) )
        // InternalCPreprocessLexer.g:236:38: ( 'u' | 'U' )? ( 'l' | 'L' )
        {
        // InternalCPreprocessLexer.g:236:38: ( 'u' | 'U' )?
        int alt36=2;
        int LA36_0 = input.LA(1);

        if ( (LA36_0=='U'||LA36_0=='u') ) {
            alt36=1;
        }
        switch (alt36) {
            case 1 :
                // InternalCPreprocessLexer.g:
                {
                if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                    input.consume();
                state.failed=false;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    MismatchedSetException mse = new MismatchedSetException(null,input);
                    recover(mse);
                    throw mse;}


                }
                break;

        }

        if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
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
    // $ANTLR end synpred89_InternalCPreprocessLexer

    // $ANTLR start synpred104_InternalCPreprocessLexer
    public final void synpred104_InternalCPreprocessLexer_fragment() throws RecognitionException {   
        // InternalCPreprocessLexer.g:239:181: ( ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? )
        // InternalCPreprocessLexer.g:239:181: ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )?
        {
        // InternalCPreprocessLexer.g:239:181: ( '0' .. '9' )+
        int cnt44=0;
        loop44:
        do {
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>='0' && LA44_0<='9')) ) {
                alt44=1;
            }


            switch (alt44) {
        	case 1 :
        	    // InternalCPreprocessLexer.g:239:182: '0' .. '9'
        	    {
        	    matchRange('0','9'); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt44 >= 1 ) break loop44;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(44, input);
                    throw eee;
            }
            cnt44++;
        } while (true);

        mRULE_EXPONENT(); if (state.failed) return ;
        // InternalCPreprocessLexer.g:239:207: ( RULE_FLOAT_TYPE_SUFFIX )?
        int alt45=2;
        int LA45_0 = input.LA(1);

        if ( (LA45_0=='D'||LA45_0=='F'||LA45_0=='d'||LA45_0=='f') ) {
            alt45=1;
        }
        switch (alt45) {
            case 1 :
                // InternalCPreprocessLexer.g:0:0: RULE_FLOAT_TYPE_SUFFIX
                {
                mRULE_FLOAT_TYPE_SUFFIX(); if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred104_InternalCPreprocessLexer

    public final boolean synpred15_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_InternalCPreprocessLexer_fragment(); // can never throw exception
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
    public final boolean synpred51_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred51_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred47_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred48_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalCPreprocessLexer_fragment(); // can never throw exception
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
    public final boolean synpred42_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred41_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred41_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalCPreprocessLexer_fragment(); // can never throw exception
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
    public final boolean synpred55_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred104_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred104_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred50_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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
    public final boolean synpred32_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalCPreprocessLexer_fragment(); // can never throw exception
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
    public final boolean synpred56_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalCPreprocessLexer_fragment(); // can never throw exception
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
    public final boolean synpred16_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalCPreprocessLexer_fragment(); // can never throw exception
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
    public final boolean synpred57_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_InternalCPreprocessLexer_fragment(); // can never throw exception
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
    public final boolean synpred34_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred89_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred89_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred53_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalCPreprocessLexer_fragment(); // can never throw exception
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
    public final boolean synpred24_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred58_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred58_InternalCPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred52_InternalCPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_InternalCPreprocessLexer_fragment(); // can never throw exception
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
    protected DFA29 dfa29 = new DFA29(this);
    static final String DFA1_eotS =
        "\53\uffff\1\155\30\uffff\1\160\54\uffff";
    static final String DFA1_eofS =
        "\161\uffff";
    static final String DFA1_minS =
        "\2\0\1\146\1\145\2\156\1\162\3\0\1\52\1\12\3\0\2\56\1\60\1\46\1\75\3\0\1\75\3\0\1\74\1\55\1\0\1\75\1\174\1\53\7\0\3\uffff\1\144\30\uffff\1\56\54\uffff";
    static final String DFA1_maxS =
        "\1\uffff\1\0\1\156\1\145\1\162\1\156\1\162\3\0\1\57\1\15\1\0\2\uffff\1\170\1\146\1\71\1\46\1\75\3\0\1\76\3\0\1\75\1\55\1\0\1\75\1\174\1\53\7\0\3\uffff\1\156\30\uffff\1\165\54\uffff";
    static final String DFA1_acceptS =
        "\50\uffff\1\72\1\1\1\2\1\uffff\1\15\1\3\1\4\1\11\1\5\1\12\1\13\3\14\1\34\1\14\1\30\2\16\1\67\3\17\1\36\1\20\2\23\1\24\1\uffff\3\24\1\21\1\24\1\35\1\26\1\25\1\37\1\27\1\31\1\32\1\33\1\65\1\41\1\40\1\42\1\43\1\44\1\45\1\47\1\46\1\51\1\50\1\52\1\54\1\53\1\56\1\55\1\60\1\57\1\61\1\62\1\63\1\64\1\66\1\70\1\71\1\7\1\10\1\6\3\22";
    static final String DFA1_specialS =
        "\1\20\1\35\1\10\1\4\1\5\1\1\1\11\1\21\1\14\1\12\1\51\1\50\1\17\1\44\1\25\1\2\1\7\1\41\1\47\1\16\1\43\1\33\1\27\1\46\1\37\1\30\1\23\1\40\1\24\1\31\1\13\1\32\1\45\1\15\1\26\1\36\1\42\1\3\1\0\1\22\3\uffff\1\34\30\uffff\1\6\54\uffff}>";
    static final String[] DFA1_transitionS = {
            "\11\50\1\11\1\7\2\50\1\7\22\50\1\10\1\36\1\16\1\1\1\14\1\35\1\22\1\15\1\32\1\44\1\46\1\40\1\25\1\34\1\21\1\12\1\17\11\20\1\26\1\45\1\33\1\23\1\27\1\41\1\50\32\14\1\31\1\13\1\43\1\24\1\14\1\50\3\14\1\3\1\4\3\14\1\2\6\14\1\6\4\14\1\5\5\14\1\30\1\37\1\42\1\47\uff81\50",
            "\1\uffff",
            "\1\53\7\uffff\1\52",
            "\1\55",
            "\1\57\3\uffff\1\56",
            "\1\60",
            "\1\61",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\65\4\uffff\1\64",
            "\1\67\2\uffff\1\67",
            "\1\uffff",
            "\47\72\1\uffff\64\72\1\71\uffa3\72",
            "\42\75\1\76\71\75\1\74\uffa3\75",
            "\1\103\1\uffff\10\104\2\107\10\uffff\1\102\1\uffff\1\106\1\105\1\106\21\uffff\1\100\11\uffff\1\101\1\uffff\1\106\1\105\1\106\21\uffff\1\100",
            "\1\103\1\uffff\12\107\12\uffff\1\106\1\105\1\106\35\uffff\1\106\1\105\1\106",
            "\12\111",
            "\1\113",
            "\1\115",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\123\1\122",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\130\1\131",
            "\1\133",
            "\1\uffff",
            "\1\136",
            "\1\140",
            "\1\142",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "\1\153\11\uffff\1\154",
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
            "\1\103\1\uffff\10\104\2\107\12\uffff\1\106\1\105\1\106\5\uffff\1\157\10\uffff\1\156\16\uffff\1\106\1\105\1\106\5\uffff\1\157\10\uffff\1\156",
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
            return "100:1: SYNTHETIC_ALL_KEYWORDS : ( ( FRAGMENT_RULE_HASH )=> FRAGMENT_RULE_HASH | ( FRAGMENT_RULE_INCLUDE )=> FRAGMENT_RULE_INCLUDE | ( FRAGMENT_RULE_DEFINE )=> FRAGMENT_RULE_DEFINE | ( FRAGMENT_RULE_ERROR )=> FRAGMENT_RULE_ERROR | ( FRAGMENT_RULE_UNDEF )=> FRAGMENT_RULE_UNDEF | ( FRAGMENT_RULE_IF )=> FRAGMENT_RULE_IF | ( FRAGMENT_RULE_IFDEF )=> FRAGMENT_RULE_IFDEF | ( FRAGMENT_RULE_IFNOTDEF )=> FRAGMENT_RULE_IFNOTDEF | ( FRAGMENT_RULE_ENDIF )=> FRAGMENT_RULE_ENDIF | ( FRAGMENT_RULE_PRAGMA )=> FRAGMENT_RULE_PRAGMA | ( FRAGMENT_RULE_NEWLINE )=> FRAGMENT_RULE_NEWLINE | ( FRAGMENT_RULE_WS )=> FRAGMENT_RULE_WS | ( FRAGMENT_RULE_ID )=> FRAGMENT_RULE_ID | ( FRAGMENT_RULE_CHAR_LITERAL )=> FRAGMENT_RULE_CHAR_LITERAL | ( FRAGMENT_RULE_STRING_LITERAL )=> FRAGMENT_RULE_STRING_LITERAL | ( FRAGMENT_RULE_HEX_LITERAL )=> FRAGMENT_RULE_HEX_LITERAL | ( FRAGMENT_RULE_DECIMAL_LITERAL )=> FRAGMENT_RULE_DECIMAL_LITERAL | ( FRAGMENT_RULE_OCTAL_LITERAL )=> FRAGMENT_RULE_OCTAL_LITERAL | ( FRAGMENT_RULE_BIN_LITERAL )=> FRAGMENT_RULE_BIN_LITERAL | ( FRAGMENT_RULE_FLOAT_LITERAL )=> FRAGMENT_RULE_FLOAT_LITERAL | ( FRAGMENT_RULE_SKW_AND )=> FRAGMENT_RULE_SKW_AND | ( FRAGMENT_RULE_SKW_ANDAND )=> FRAGMENT_RULE_SKW_ANDAND | ( FRAGMENT_RULE_SKW_ASSIGN )=> FRAGMENT_RULE_SKW_ASSIGN | ( FRAGMENT_RULE_SKW_BACKSLASH )=> FRAGMENT_RULE_SKW_BACKSLASH | ( FRAGMENT_RULE_SKW_CARET )=> FRAGMENT_RULE_SKW_CARET | ( FRAGMENT_RULE_SKW_COMMA )=> FRAGMENT_RULE_SKW_COMMA | ( FRAGMENT_RULE_SKW_COLON )=> FRAGMENT_RULE_SKW_COLON | ( FRAGMENT_RULE_SKW_DIV )=> FRAGMENT_RULE_SKW_DIV | ( FRAGMENT_RULE_SKW_DOT )=> FRAGMENT_RULE_SKW_DOT | ( FRAGMENT_RULE_SKW_DOUBLEQUOTE )=> FRAGMENT_RULE_SKW_DOUBLEQUOTE | ( FRAGMENT_RULE_SKW_EQUAL )=> FRAGMENT_RULE_SKW_EQUAL | ( FRAGMENT_RULE_SKW_GREATER )=> FRAGMENT_RULE_SKW_GREATER | ( FRAGMENT_RULE_SKW_GREATEREQUAL )=> FRAGMENT_RULE_SKW_GREATEREQUAL | ( FRAGMENT_RULE_SKW_LEFTBRACE )=> FRAGMENT_RULE_SKW_LEFTBRACE | ( FRAGMENT_RULE_SKW_LEFTBRACKET )=> FRAGMENT_RULE_SKW_LEFTBRACKET | ( FRAGMENT_RULE_SKW_LEFTPAREN )=> FRAGMENT_RULE_SKW_LEFTPAREN | ( FRAGMENT_RULE_SKW_LEFTSHIFT )=> FRAGMENT_RULE_SKW_LEFTSHIFT | ( FRAGMENT_RULE_SKW_LESS )=> FRAGMENT_RULE_SKW_LESS | ( FRAGMENT_RULE_SKW_LESSEQUAL )=> FRAGMENT_RULE_SKW_LESSEQUAL | ( FRAGMENT_RULE_SKW_MINUS )=> FRAGMENT_RULE_SKW_MINUS | ( FRAGMENT_RULE_SKW_MINUSMINUS )=> FRAGMENT_RULE_SKW_MINUSMINUS | ( FRAGMENT_RULE_SKW_MOD )=> FRAGMENT_RULE_SKW_MOD | ( FRAGMENT_RULE_SKW_NOT )=> FRAGMENT_RULE_SKW_NOT | ( FRAGMENT_RULE_SKW_NOTEQUAL )=> FRAGMENT_RULE_SKW_NOTEQUAL | ( FRAGMENT_RULE_SKW_OR )=> FRAGMENT_RULE_SKW_OR | ( FRAGMENT_RULE_SKW_OROR )=> FRAGMENT_RULE_SKW_OROR | ( FRAGMENT_RULE_SKW_PLUS )=> FRAGMENT_RULE_SKW_PLUS | ( FRAGMENT_RULE_SKW_PLUSPLUS )=> FRAGMENT_RULE_SKW_PLUSPLUS | ( FRAGMENT_RULE_SKW_QUESTION )=> FRAGMENT_RULE_SKW_QUESTION | ( FRAGMENT_RULE_SKW_RIGHTBRACE )=> FRAGMENT_RULE_SKW_RIGHTBRACE | ( FRAGMENT_RULE_SKW_RIGHTBRACKET )=> FRAGMENT_RULE_SKW_RIGHTBRACKET | ( FRAGMENT_RULE_SKW_RIGHTPAREN )=> FRAGMENT_RULE_SKW_RIGHTPAREN | ( FRAGMENT_RULE_SKW_RIGHTSHIFT )=> FRAGMENT_RULE_SKW_RIGHTSHIFT | ( FRAGMENT_RULE_SKW_SEMI )=> FRAGMENT_RULE_SKW_SEMI | ( FRAGMENT_RULE_SKW_SINGLEQUOTE )=> FRAGMENT_RULE_SKW_SINGLEQUOTE | ( FRAGMENT_RULE_SKW_STAR )=> FRAGMENT_RULE_SKW_STAR | ( FRAGMENT_RULE_SKW_TILDE )=> FRAGMENT_RULE_SKW_TILDE | ( FRAGMENT_RULE_SPECIAL )=> FRAGMENT_RULE_SPECIAL );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA1_38 = input.LA(1);

                         
                        int index1_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalCPreprocessLexer()) ) {s = 105;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_38);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA1_5 = input.LA(1);

                         
                        int index1_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_5=='n') && (synpred5_InternalCPreprocessLexer())) {s = 48;}

                        else if ( (synpred13_InternalCPreprocessLexer()) ) {s = 44;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_5);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA1_15 = input.LA(1);

                         
                        int index1_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_15=='X'||LA1_15=='x') && (synpred16_InternalCPreprocessLexer())) {s = 64;}

                        else if ( (LA1_15=='b') && (synpred19_InternalCPreprocessLexer())) {s = 65;}

                        else if ( (LA1_15=='B') && (synpred19_InternalCPreprocessLexer())) {s = 66;}

                        else if ( (LA1_15=='.') && (synpred20_InternalCPreprocessLexer())) {s = 67;}

                        else if ( ((LA1_15>='0' && LA1_15<='7')) ) {s = 68;}

                        else if ( (LA1_15=='E'||LA1_15=='e') && (synpred20_InternalCPreprocessLexer())) {s = 69;}

                        else if ( (LA1_15=='D'||LA1_15=='F'||LA1_15=='d'||LA1_15=='f') && (synpred20_InternalCPreprocessLexer())) {s = 70;}

                        else if ( ((LA1_15>='8' && LA1_15<='9')) && (synpred20_InternalCPreprocessLexer())) {s = 71;}

                        else if ( (synpred17_InternalCPreprocessLexer()) ) {s = 72;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_15);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA1_37 = input.LA(1);

                         
                        int index1_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_InternalCPreprocessLexer()) ) {s = 104;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_37);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA1_3 = input.LA(1);

                         
                        int index1_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_3=='e') && (synpred3_InternalCPreprocessLexer())) {s = 45;}

                        else if ( (synpred13_InternalCPreprocessLexer()) ) {s = 44;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_3);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA1_4 = input.LA(1);

                         
                        int index1_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_4=='r') && (synpred4_InternalCPreprocessLexer())) {s = 46;}

                        else if ( (LA1_4=='n') && (synpred9_InternalCPreprocessLexer())) {s = 47;}

                        else if ( (synpred13_InternalCPreprocessLexer()) ) {s = 44;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_4);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA1_68 = input.LA(1);

                         
                        int index1_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_68=='.') && (synpred20_InternalCPreprocessLexer())) {s = 67;}

                        else if ( ((LA1_68>='0' && LA1_68<='7')) ) {s = 68;}

                        else if ( (LA1_68=='U'||LA1_68=='u') && (synpred18_InternalCPreprocessLexer())) {s = 110;}

                        else if ( (LA1_68=='L'||LA1_68=='l') && (synpred18_InternalCPreprocessLexer())) {s = 111;}

                        else if ( ((LA1_68>='8' && LA1_68<='9')) && (synpred20_InternalCPreprocessLexer())) {s = 71;}

                        else if ( (LA1_68=='E'||LA1_68=='e') && (synpred20_InternalCPreprocessLexer())) {s = 69;}

                        else if ( (LA1_68=='D'||LA1_68=='F'||LA1_68=='d'||LA1_68=='f') && (synpred20_InternalCPreprocessLexer())) {s = 70;}

                        else s = 112;

                         
                        input.seek(index1_68);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA1_16 = input.LA(1);

                         
                        int index1_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_16=='.') && (synpred20_InternalCPreprocessLexer())) {s = 67;}

                        else if ( ((LA1_16>='0' && LA1_16<='9')) && (synpred20_InternalCPreprocessLexer())) {s = 71;}

                        else if ( (LA1_16=='E'||LA1_16=='e') && (synpred20_InternalCPreprocessLexer())) {s = 69;}

                        else if ( (LA1_16=='D'||LA1_16=='F'||LA1_16=='d'||LA1_16=='f') && (synpred20_InternalCPreprocessLexer())) {s = 70;}

                        else if ( (synpred17_InternalCPreprocessLexer()) ) {s = 72;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_16);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA1_2 = input.LA(1);

                         
                        int index1_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_2=='n') && (synpred2_InternalCPreprocessLexer())) {s = 42;}

                        else if ( (LA1_2=='f') ) {s = 43;}

                        else if ( (synpred13_InternalCPreprocessLexer()) ) {s = 44;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_2);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA1_6 = input.LA(1);

                         
                        int index1_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_6=='r') && (synpred10_InternalCPreprocessLexer())) {s = 49;}

                        else if ( (synpred13_InternalCPreprocessLexer()) ) {s = 44;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_6);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA1_9 = input.LA(1);

                         
                        int index1_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalCPreprocessLexer()) ) {s = 51;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_9);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA1_30 = input.LA(1);

                         
                        int index1_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_30=='=') && (synpred44_InternalCPreprocessLexer())) {s = 94;}

                        else if ( (synpred43_InternalCPreprocessLexer()) ) {s = 95;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_30);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA1_8 = input.LA(1);

                         
                        int index1_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalCPreprocessLexer()) ) {s = 51;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_8);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA1_33 = input.LA(1);

                         
                        int index1_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_InternalCPreprocessLexer()) ) {s = 100;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_33);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA1_19 = input.LA(1);

                         
                        int index1_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_19=='=') && (synpred31_InternalCPreprocessLexer())) {s = 77;}

                        else if ( (synpred23_InternalCPreprocessLexer()) ) {s = 78;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_19);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA1_12 = input.LA(1);

                         
                        int index1_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalCPreprocessLexer()) ) {s = 44;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_12);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
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

                        else if ( (LA1_0=='\n'||LA1_0=='\r') ) {s = 7;}

                        else if ( (LA1_0==' ') ) {s = 8;}

                        else if ( (LA1_0=='\t') ) {s = 9;}

                        else if ( (LA1_0=='/') ) {s = 10;}

                        else if ( (LA1_0=='\\') ) {s = 11;}

                        else if ( (LA1_0=='$'||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='c')||(LA1_0>='f' && LA1_0<='h')||(LA1_0>='j' && LA1_0<='o')||(LA1_0>='q' && LA1_0<='t')||(LA1_0>='v' && LA1_0<='z')) ) {s = 12;}

                        else if ( (LA1_0=='\'') ) {s = 13;}

                        else if ( (LA1_0=='\"') ) {s = 14;}

                        else if ( (LA1_0=='0') ) {s = 15;}

                        else if ( ((LA1_0>='1' && LA1_0<='9')) ) {s = 16;}

                        else if ( (LA1_0=='.') ) {s = 17;}

                        else if ( (LA1_0=='&') ) {s = 18;}

                        else if ( (LA1_0=='=') ) {s = 19;}

                        else if ( (LA1_0=='^') ) {s = 20;}

                        else if ( (LA1_0==',') ) {s = 21;}

                        else if ( (LA1_0==':') ) {s = 22;}

                        else if ( (LA1_0=='>') ) {s = 23;}

                        else if ( (LA1_0=='{') ) {s = 24;}

                        else if ( (LA1_0=='[') ) {s = 25;}

                        else if ( (LA1_0=='(') ) {s = 26;}

                        else if ( (LA1_0=='<') ) {s = 27;}

                        else if ( (LA1_0=='-') ) {s = 28;}

                        else if ( (LA1_0=='%') ) {s = 29;}

                        else if ( (LA1_0=='!') ) {s = 30;}

                        else if ( (LA1_0=='|') ) {s = 31;}

                        else if ( (LA1_0=='+') ) {s = 32;}

                        else if ( (LA1_0=='?') ) {s = 33;}

                        else if ( (LA1_0=='}') ) {s = 34;}

                        else if ( (LA1_0==']') ) {s = 35;}

                        else if ( (LA1_0==')') ) {s = 36;}

                        else if ( (LA1_0==';') ) {s = 37;}

                        else if ( (LA1_0=='*') ) {s = 38;}

                        else if ( (LA1_0=='~') ) {s = 39;}

                        else if ( ((LA1_0>='\u0000' && LA1_0<='\b')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\u001F')||LA1_0=='@'||LA1_0=='`'||(LA1_0>='\u007F' && LA1_0<='\uFFFF')) && (synpred58_InternalCPreprocessLexer())) {s = 40;}

                         
                        input.seek(index1_0);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA1_7 = input.LA(1);

                         
                        int index1_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalCPreprocessLexer()) ) {s = 50;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_7);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA1_39 = input.LA(1);

                         
                        int index1_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalCPreprocessLexer()) ) {s = 106;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_39);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA1_26 = input.LA(1);

                         
                        int index1_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalCPreprocessLexer()) ) {s = 87;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_26);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA1_28 = input.LA(1);

                         
                        int index1_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_28=='-') && (synpred41_InternalCPreprocessLexer())) {s = 91;}

                        else if ( (synpred40_InternalCPreprocessLexer()) ) {s = 92;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_28);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA1_14 = input.LA(1);

                         
                        int index1_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_14=='\\') && (synpred15_InternalCPreprocessLexer())) {s = 60;}

                        else if ( ((LA1_14>='\u0000' && LA1_14<='!')||(LA1_14>='#' && LA1_14<='[')||(LA1_14>=']' && LA1_14<='\uFFFF')) && (synpred15_InternalCPreprocessLexer())) {s = 61;}

                        else if ( (LA1_14=='\"') && (synpred15_InternalCPreprocessLexer())) {s = 62;}

                        else if ( (synpred30_InternalCPreprocessLexer()) ) {s = 63;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_14);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA1_34 = input.LA(1);

                         
                        int index1_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_InternalCPreprocessLexer()) ) {s = 101;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_34);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA1_22 = input.LA(1);

                         
                        int index1_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalCPreprocessLexer()) ) {s = 81;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_22);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA1_25 = input.LA(1);

                         
                        int index1_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalCPreprocessLexer()) ) {s = 86;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA1_29 = input.LA(1);

                         
                        int index1_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_InternalCPreprocessLexer()) ) {s = 93;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_29);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA1_31 = input.LA(1);

                         
                        int index1_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_31=='|') && (synpred46_InternalCPreprocessLexer())) {s = 96;}

                        else if ( (synpred45_InternalCPreprocessLexer()) ) {s = 97;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_31);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA1_21 = input.LA(1);

                         
                        int index1_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalCPreprocessLexer()) ) {s = 80;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_21);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA1_43 = input.LA(1);

                         
                        int index1_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_43=='d') && (synpred7_InternalCPreprocessLexer())) {s = 107;}

                        else if ( (LA1_43=='n') && (synpred8_InternalCPreprocessLexer())) {s = 108;}

                        else s = 109;

                         
                        input.seek(index1_43);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA1_1 = input.LA(1);

                         
                        int index1_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalCPreprocessLexer()) ) {s = 41;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_1);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA1_35 = input.LA(1);

                         
                        int index1_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_InternalCPreprocessLexer()) ) {s = 102;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_35);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA1_24 = input.LA(1);

                         
                        int index1_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalCPreprocessLexer()) ) {s = 85;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_24);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA1_27 = input.LA(1);

                         
                        int index1_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_27=='<') && (synpred37_InternalCPreprocessLexer())) {s = 88;}

                        else if ( (LA1_27=='=') && (synpred39_InternalCPreprocessLexer())) {s = 89;}

                        else if ( (synpred38_InternalCPreprocessLexer()) ) {s = 90;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_27);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA1_17 = input.LA(1);

                         
                        int index1_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA1_17>='0' && LA1_17<='9')) && (synpred20_InternalCPreprocessLexer())) {s = 73;}

                        else if ( (synpred29_InternalCPreprocessLexer()) ) {s = 74;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_17);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA1_36 = input.LA(1);

                         
                        int index1_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_InternalCPreprocessLexer()) ) {s = 103;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_36);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA1_20 = input.LA(1);

                         
                        int index1_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_InternalCPreprocessLexer()) ) {s = 79;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_20);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA1_13 = input.LA(1);

                         
                        int index1_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_13=='\\') && (synpred14_InternalCPreprocessLexer())) {s = 57;}

                        else if ( ((LA1_13>='\u0000' && LA1_13<='&')||(LA1_13>='(' && LA1_13<='[')||(LA1_13>=']' && LA1_13<='\uFFFF')) && (synpred14_InternalCPreprocessLexer())) {s = 58;}

                        else if ( (synpred55_InternalCPreprocessLexer()) ) {s = 59;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_13);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA1_32 = input.LA(1);

                         
                        int index1_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_32=='+') && (synpred48_InternalCPreprocessLexer())) {s = 98;}

                        else if ( (synpred47_InternalCPreprocessLexer()) ) {s = 99;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_32);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA1_23 = input.LA(1);

                         
                        int index1_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_23=='>') && (synpred53_InternalCPreprocessLexer())) {s = 82;}

                        else if ( (LA1_23=='=') && (synpred33_InternalCPreprocessLexer())) {s = 83;}

                        else if ( (synpred32_InternalCPreprocessLexer()) ) {s = 84;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_23);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA1_18 = input.LA(1);

                         
                        int index1_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_18=='&') && (synpred22_InternalCPreprocessLexer())) {s = 75;}

                        else if ( (synpred21_InternalCPreprocessLexer()) ) {s = 76;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_18);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA1_11 = input.LA(1);

                         
                        int index1_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_11=='\n'||LA1_11=='\r') && (synpred12_InternalCPreprocessLexer())) {s = 55;}

                        else if ( (synpred24_InternalCPreprocessLexer()) ) {s = 56;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_11);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA1_10 = input.LA(1);

                         
                        int index1_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_10=='/') && (synpred12_InternalCPreprocessLexer())) {s = 52;}

                        else if ( (LA1_10=='*') && (synpred12_InternalCPreprocessLexer())) {s = 53;}

                        else if ( (synpred28_InternalCPreprocessLexer()) ) {s = 54;}

                        else if ( (synpred58_InternalCPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_10);
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
    static final String DFA29_eotS =
        "\7\uffff\1\10\2\uffff";
    static final String DFA29_eofS =
        "\12\uffff";
    static final String DFA29_minS =
        "\2\56\2\uffff\1\53\1\uffff\2\60\1\uffff\1\0";
    static final String DFA29_maxS =
        "\1\71\1\146\2\uffff\1\71\1\uffff\1\71\1\146\1\uffff\1\0";
    static final String DFA29_acceptS =
        "\2\uffff\1\2\1\1\1\uffff\1\4\2\uffff\1\3\1\uffff";
    static final String DFA29_specialS =
        "\11\uffff\1\0}>";
    static final String[] DFA29_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\3\1\uffff\12\1\12\uffff\1\5\1\4\1\5\35\uffff\1\5\1\4\1\5",
            "",
            "",
            "\1\6\1\uffff\1\6\2\uffff\12\7",
            "",
            "\12\7",
            "\12\7\12\uffff\1\11\1\uffff\1\11\35\uffff\1\11\1\uffff\1\11",
            "",
            "\1\uffff"
    };

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "239:40: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA29_9 = input.LA(1);

                         
                        int index29_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_InternalCPreprocessLexer()) ) {s = 8;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index29_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 29, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}