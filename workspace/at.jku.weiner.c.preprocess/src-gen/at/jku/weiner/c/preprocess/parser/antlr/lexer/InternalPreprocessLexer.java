package at.jku.weiner.c.preprocess.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class InternalPreprocessLexer extends Lexer {
    public static final int RULE_PRAGMA=14;
    public static final int FRAGMENT_RULE_SKW_MINUSMINUS=121;
    public static final int FRAGMENT_RULE_SKW_ASSIGN=103;
    public static final int RULE_ID=22;
    public static final int FRAGMENT_RULE_SKW_OR=125;
    public static final int RULE_SKW_DOT=49;
    public static final int FRAGMENT_RULE_SKW_NOTEQUAL=124;
    public static final int FRAGMENT_RULE_OCTAL_LITERAL=98;
    public static final int RULE_SKW_GREATEREQUAL=53;
    public static final int RULE_SKW_PLUS=67;
    public static final int EOF=-1;
    public static final int RULE_SKW_LESS=58;
    public static final int FRAGMENT_RULE_SKW_CARET=105;
    public static final int RULE_SKW_RIGHTPAREN=72;
    public static final int RULE_ENDIF=13;
    public static final int FRAGMENT_RULE_SKW_RIGHTBRACKET=131;
    public static final int RULE_LINEBREAK=18;
    public static final int FRAGMENT_RULE_SKW_LEFTSHIFT=117;
    public static final int RULE_SKW_LESSEQUAL=59;
    public static final int RULE_DECIMAL_LITERAL=28;
    public static final int RULE_HEX_LITERAL=27;
    public static final int RULE_SKW_AND=40;
    public static final int FRAGMENT_RULE_SKW_QUESTION=129;
    public static final int RULE_OCTAL_LITERAL=29;
    public static final int RULE_SKW_COMMA=45;
    public static final int RULE_BLOCK_COMMENT=38;
    public static final int RULE_SKW_COLON=46;
    public static final int RULE_BIN_LITERAL=30;
    public static final int RULE_SKW_LEFTPAREN=56;
    public static final int FRAGMENT_RULE_SKW_SINGLEQUOTE=135;
    public static final int FRAGMENT_RULE_SKW_EQUAL=111;
    public static final int RULE_SKW_MINUS=60;
    public static final int RULE_IFDEF=11;
    public static final int FRAGMENT_RULE_IFNOTDEF=88;
    public static final int FRAGMENT_RULE_SKW_NOT=123;
    public static final int FRAGMENT_RULE_NEWLINE=91;
    public static final int RULE_SKW_EQUAL=51;
    public static final int FRAGMENT_RULE_IF=85;
    public static final int FRAGMENT_RULE_SKW_RIGHTBRACE=130;
    public static final int RULE_SKW_ANDAND=41;
    public static final int RULE_SKW_DIV=47;
    public static final int FRAGMENT_RULE_ID=93;
    public static final int RULE_HEX_DIGIT=31;
    public static final int RULE_SKW_GREATER=52;
    public static final int RULE_HASH=4;
    public static final int RULE_TAB=20;
    public static final int RULE_SKW_LEFTBRACKET=55;
    public static final int FRAGMENT_RULE_INCLUDE=81;
    public static final int FRAGMENT_RULE_SKW_LEFTPAREN=116;
    public static final int RULE_LETTER=24;
    public static final int FRAGMENT_RULE_SKW_COMMA=106;
    public static final int FRAGMENT_RULE_BIN_LITERAL=99;
    public static final int RULE_EXPONENT=34;
    public static final int RULE_DEFINE=6;
    public static final int RULE_SPECIAL=79;
    public static final int FRAGMENT_RULE_IFDEF=87;
    public static final int RULE_INCLUDE=5;
    public static final int FRAGMENT_RULE_SKW_PLUSPLUS=128;
    public static final int FRAGMENT_RULE_SKW_ANDAND=102;
    public static final int FRAGMENT_RULE_ERROR=83;
    public static final int RULE_SKW_UNDERSCORE=78;
    public static final int FRAGMENT_RULE_SKW_BACKSLASH=104;
    public static final int RULE_IF=9;
    public static final int FRAGMENT_RULE_DEFINED=86;
    public static final int FRAGMENT_RULE_FLOAT_LITERAL=100;
    public static final int FRAGMENT_RULE_SKW_RIGHTSHIFT=133;
    public static final int FRAGMENT_RULE_SKW_GREATER=112;
    public static final int FRAGMENT_RULE_SKW_DOUBLEQUOTE=110;
    public static final int RULE_OCTAL_ESCAPE=37;
    public static final int RULE_SKW_NOT=63;
    public static final int RULE_ESCAPE_SEQUENCE=36;
    public static final int RULE_SKW_RIGHTSHIFT=73;
    public static final int RULE_DEFINED=10;
    public static final int RULE_SKW_NOTEQUAL=64;
    public static final int FRAGMENT_RULE_SKW_LESS=118;
    public static final int FRAGMENT_RULE_SKW_GREATEREQUAL=113;
    public static final int RULE_SKW_RIGHTBRACE=70;
    public static final int FRAGMENT_RULE_SKW_OROR=126;
    public static final int RULE_SKW_STAR=76;
    public static final int FRAGMENT_RULE_SKW_STAR=136;
    public static final int RULE_STRING_LITERAL=26;
    public static final int FRAGMENT_RULE_ENDIF=89;
    public static final int RULE_SKW_DOUBLEQUOTE=50;
    public static final int RULE_SKW_PLUSPLUS=68;
    public static final int RULE_SKW_OROR=66;
    public static final int FRAGMENT_RULE_SKW_DIV=108;
    public static final int RULE_SKW_CARET=44;
    public static final int FRAGMENT_RULE_DEFINE=82;
    public static final int RULE_SKW_RIGHTBRACKET=71;
    public static final int FRAGMENT_RULE_CHAR_LITERAL=94;
    public static final int RULE_SPACE=19;
    public static final int FRAGMENT_RULE_STRING_LITERAL=95;
    public static final int RULE_LINEFEED=15;
    public static final int FRAGMENT_RULE_HASH=80;
    public static final int RULE_SKW_SEMI=74;
    public static final int RULE_NEWLINE=17;
    public static final int FRAGMENT_RULE_SKW_MOD=122;
    public static final int RULE_SKW_DOLLAR=48;
    public static final int RULE_SKW_LEFTSHIFT=57;
    public static final int RULE_SKW_QUESTION=69;
    public static final int RULE_ERROR=7;
    public static final int RULE_IDENTIFIER=23;
    public static final int FRAGMENT_RULE_SPECIAL=138;
    public static final int FRAGMENT_RULE_SKW_MINUS=120;
    public static final int RULE_SKW_SINGLEQUOTE=75;
    public static final int FRAGMENT_RULE_SKW_COLON=107;
    public static final int RULE_UNDEF=8;
    public static final int RULE_SKW_MOD=62;
    public static final int FRAGMENT_RULE_SKW_PLUS=127;
    public static final int FRAGMENT_RULE_HEX_LITERAL=96;
    public static final int FRAGMENT_RULE_PRAGMA=90;
    public static final int RULE_SKW_MINUSMINUS=61;
    public static final int FRAGMENT_RULE_SKW_RIGHTPAREN=132;
    public static final int FRAGMENT_RULE_SKW_LEFTBRACKET=115;
    public static final int SYNTHETIC_ALL_KEYWORDS=139;
    public static final int RULE_FLOAT_TYPE_SUFFIX=35;
    public static final int RULE_IFNOTDEF=12;
    public static final int FRAGMENT_RULE_SKW_SEMI=134;
    public static final int RULE_INTEGER_TYPE_SUFFIX=32;
    public static final int FRAGMENT_RULE_SKW_LEFTBRACE=114;
    public static final int RULE_CARRIAGERETURN=16;
    public static final int FRAGMENT_RULE_SKW_DOT=109;
    public static final int FRAGMENT_RULE_UNDEF=84;
    public static final int FRAGMENT_RULE_SKW_AND=101;
    public static final int RULE_SKW_TILDE=77;
    public static final int RULE_LINE_COMMENT=39;
    public static final int RULE_SKW_BACKSLASH=43;
    public static final int RULE_SKW_OR=65;
    public static final int FRAGMENT_RULE_DECIMAL_LITERAL=97;
    public static final int FRAGMENT_RULE_WS=92;
    public static final int RULE_CHAR_LITERAL=25;
    public static final int RULE_WS=21;
    public static final int FRAGMENT_RULE_SKW_TILDE=137;
    public static final int RULE_FLOAT_LITERAL=33;
    public static final int RULE_SKW_LEFTBRACE=54;
    public static final int FRAGMENT_RULE_SKW_LESSEQUAL=119;
    public static final int RULE_SKW_ASSIGN=42;

    // delegates
    // delegators

    public InternalPreprocessLexer() {;} 
    public InternalPreprocessLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalPreprocessLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
        state.ruleMemo = new HashMap[264+1];
 
    }
    public String getGrammarFileName() { return "InternalPreprocessLexer.g"; }

    // $ANTLR start "SYNTHETIC_ALL_KEYWORDS"
    public final void mSYNTHETIC_ALL_KEYWORDS() throws RecognitionException {
        int SYNTHETIC_ALL_KEYWORDS_StartIndex = input.index();
        try {
            int _type = SYNTHETIC_ALL_KEYWORDS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return ; }
            // InternalPreprocessLexer.g:101:24: ( ( FRAGMENT_RULE_HASH )=> FRAGMENT_RULE_HASH | ( FRAGMENT_RULE_INCLUDE )=> FRAGMENT_RULE_INCLUDE | ( FRAGMENT_RULE_DEFINE )=> FRAGMENT_RULE_DEFINE | ( FRAGMENT_RULE_ERROR )=> FRAGMENT_RULE_ERROR | ( FRAGMENT_RULE_UNDEF )=> FRAGMENT_RULE_UNDEF | ( FRAGMENT_RULE_IF )=> FRAGMENT_RULE_IF | ( FRAGMENT_RULE_DEFINED )=> FRAGMENT_RULE_DEFINED | ( FRAGMENT_RULE_IFDEF )=> FRAGMENT_RULE_IFDEF | ( FRAGMENT_RULE_IFNOTDEF )=> FRAGMENT_RULE_IFNOTDEF | ( FRAGMENT_RULE_ENDIF )=> FRAGMENT_RULE_ENDIF | ( FRAGMENT_RULE_PRAGMA )=> FRAGMENT_RULE_PRAGMA | ( FRAGMENT_RULE_NEWLINE )=> FRAGMENT_RULE_NEWLINE | ( FRAGMENT_RULE_WS )=> FRAGMENT_RULE_WS | ( FRAGMENT_RULE_ID )=> FRAGMENT_RULE_ID | ( FRAGMENT_RULE_CHAR_LITERAL )=> FRAGMENT_RULE_CHAR_LITERAL | ( FRAGMENT_RULE_STRING_LITERAL )=> FRAGMENT_RULE_STRING_LITERAL | ( FRAGMENT_RULE_HEX_LITERAL )=> FRAGMENT_RULE_HEX_LITERAL | ( FRAGMENT_RULE_DECIMAL_LITERAL )=> FRAGMENT_RULE_DECIMAL_LITERAL | ( FRAGMENT_RULE_OCTAL_LITERAL )=> FRAGMENT_RULE_OCTAL_LITERAL | ( FRAGMENT_RULE_BIN_LITERAL )=> FRAGMENT_RULE_BIN_LITERAL | ( FRAGMENT_RULE_FLOAT_LITERAL )=> FRAGMENT_RULE_FLOAT_LITERAL | ( FRAGMENT_RULE_SKW_AND )=> FRAGMENT_RULE_SKW_AND | ( FRAGMENT_RULE_SKW_ANDAND )=> FRAGMENT_RULE_SKW_ANDAND | ( FRAGMENT_RULE_SKW_ASSIGN )=> FRAGMENT_RULE_SKW_ASSIGN | ( FRAGMENT_RULE_SKW_BACKSLASH )=> FRAGMENT_RULE_SKW_BACKSLASH | ( FRAGMENT_RULE_SKW_CARET )=> FRAGMENT_RULE_SKW_CARET | ( FRAGMENT_RULE_SKW_COMMA )=> FRAGMENT_RULE_SKW_COMMA | ( FRAGMENT_RULE_SKW_COLON )=> FRAGMENT_RULE_SKW_COLON | ( FRAGMENT_RULE_SKW_DIV )=> FRAGMENT_RULE_SKW_DIV | ( FRAGMENT_RULE_SKW_DOT )=> FRAGMENT_RULE_SKW_DOT | ( FRAGMENT_RULE_SKW_DOUBLEQUOTE )=> FRAGMENT_RULE_SKW_DOUBLEQUOTE | ( FRAGMENT_RULE_SKW_EQUAL )=> FRAGMENT_RULE_SKW_EQUAL | ( FRAGMENT_RULE_SKW_GREATER )=> FRAGMENT_RULE_SKW_GREATER | ( FRAGMENT_RULE_SKW_GREATEREQUAL )=> FRAGMENT_RULE_SKW_GREATEREQUAL | ( FRAGMENT_RULE_SKW_LEFTBRACE )=> FRAGMENT_RULE_SKW_LEFTBRACE | ( FRAGMENT_RULE_SKW_LEFTBRACKET )=> FRAGMENT_RULE_SKW_LEFTBRACKET | ( FRAGMENT_RULE_SKW_LEFTPAREN )=> FRAGMENT_RULE_SKW_LEFTPAREN | ( FRAGMENT_RULE_SKW_LEFTSHIFT )=> FRAGMENT_RULE_SKW_LEFTSHIFT | ( FRAGMENT_RULE_SKW_LESS )=> FRAGMENT_RULE_SKW_LESS | ( FRAGMENT_RULE_SKW_LESSEQUAL )=> FRAGMENT_RULE_SKW_LESSEQUAL | ( FRAGMENT_RULE_SKW_MINUS )=> FRAGMENT_RULE_SKW_MINUS | ( FRAGMENT_RULE_SKW_MINUSMINUS )=> FRAGMENT_RULE_SKW_MINUSMINUS | ( FRAGMENT_RULE_SKW_MOD )=> FRAGMENT_RULE_SKW_MOD | ( FRAGMENT_RULE_SKW_NOT )=> FRAGMENT_RULE_SKW_NOT | ( FRAGMENT_RULE_SKW_NOTEQUAL )=> FRAGMENT_RULE_SKW_NOTEQUAL | ( FRAGMENT_RULE_SKW_OR )=> FRAGMENT_RULE_SKW_OR | ( FRAGMENT_RULE_SKW_OROR )=> FRAGMENT_RULE_SKW_OROR | ( FRAGMENT_RULE_SKW_PLUS )=> FRAGMENT_RULE_SKW_PLUS | ( FRAGMENT_RULE_SKW_PLUSPLUS )=> FRAGMENT_RULE_SKW_PLUSPLUS | ( FRAGMENT_RULE_SKW_QUESTION )=> FRAGMENT_RULE_SKW_QUESTION | ( FRAGMENT_RULE_SKW_RIGHTBRACE )=> FRAGMENT_RULE_SKW_RIGHTBRACE | ( FRAGMENT_RULE_SKW_RIGHTBRACKET )=> FRAGMENT_RULE_SKW_RIGHTBRACKET | ( FRAGMENT_RULE_SKW_RIGHTPAREN )=> FRAGMENT_RULE_SKW_RIGHTPAREN | ( FRAGMENT_RULE_SKW_RIGHTSHIFT )=> FRAGMENT_RULE_SKW_RIGHTSHIFT | ( FRAGMENT_RULE_SKW_SEMI )=> FRAGMENT_RULE_SKW_SEMI | ( FRAGMENT_RULE_SKW_SINGLEQUOTE )=> FRAGMENT_RULE_SKW_SINGLEQUOTE | ( FRAGMENT_RULE_SKW_STAR )=> FRAGMENT_RULE_SKW_STAR | ( FRAGMENT_RULE_SKW_TILDE )=> FRAGMENT_RULE_SKW_TILDE | ( FRAGMENT_RULE_SPECIAL )=> FRAGMENT_RULE_SPECIAL )
            int alt1=59;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalPreprocessLexer.g:102:2: ( FRAGMENT_RULE_HASH )=> FRAGMENT_RULE_HASH
                    {
                    mFRAGMENT_RULE_HASH(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_HASH; 
                    }

                    }
                    break;
                case 2 :
                    // InternalPreprocessLexer.g:103:2: ( FRAGMENT_RULE_INCLUDE )=> FRAGMENT_RULE_INCLUDE
                    {
                    mFRAGMENT_RULE_INCLUDE(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_INCLUDE; 
                    }

                    }
                    break;
                case 3 :
                    // InternalPreprocessLexer.g:104:2: ( FRAGMENT_RULE_DEFINE )=> FRAGMENT_RULE_DEFINE
                    {
                    mFRAGMENT_RULE_DEFINE(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_DEFINE; 
                    }

                    }
                    break;
                case 4 :
                    // InternalPreprocessLexer.g:105:2: ( FRAGMENT_RULE_ERROR )=> FRAGMENT_RULE_ERROR
                    {
                    mFRAGMENT_RULE_ERROR(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_ERROR; 
                    }

                    }
                    break;
                case 5 :
                    // InternalPreprocessLexer.g:106:2: ( FRAGMENT_RULE_UNDEF )=> FRAGMENT_RULE_UNDEF
                    {
                    mFRAGMENT_RULE_UNDEF(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_UNDEF; 
                    }

                    }
                    break;
                case 6 :
                    // InternalPreprocessLexer.g:107:2: ( FRAGMENT_RULE_IF )=> FRAGMENT_RULE_IF
                    {
                    mFRAGMENT_RULE_IF(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_IF; 
                    }

                    }
                    break;
                case 7 :
                    // InternalPreprocessLexer.g:108:2: ( FRAGMENT_RULE_DEFINED )=> FRAGMENT_RULE_DEFINED
                    {
                    mFRAGMENT_RULE_DEFINED(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_DEFINED; 
                    }

                    }
                    break;
                case 8 :
                    // InternalPreprocessLexer.g:109:2: ( FRAGMENT_RULE_IFDEF )=> FRAGMENT_RULE_IFDEF
                    {
                    mFRAGMENT_RULE_IFDEF(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_IFDEF; 
                    }

                    }
                    break;
                case 9 :
                    // InternalPreprocessLexer.g:110:2: ( FRAGMENT_RULE_IFNOTDEF )=> FRAGMENT_RULE_IFNOTDEF
                    {
                    mFRAGMENT_RULE_IFNOTDEF(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_IFNOTDEF; 
                    }

                    }
                    break;
                case 10 :
                    // InternalPreprocessLexer.g:111:2: ( FRAGMENT_RULE_ENDIF )=> FRAGMENT_RULE_ENDIF
                    {
                    mFRAGMENT_RULE_ENDIF(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_ENDIF; 
                    }

                    }
                    break;
                case 11 :
                    // InternalPreprocessLexer.g:112:2: ( FRAGMENT_RULE_PRAGMA )=> FRAGMENT_RULE_PRAGMA
                    {
                    mFRAGMENT_RULE_PRAGMA(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_PRAGMA; 
                    }

                    }
                    break;
                case 12 :
                    // InternalPreprocessLexer.g:113:2: ( FRAGMENT_RULE_NEWLINE )=> FRAGMENT_RULE_NEWLINE
                    {
                    mFRAGMENT_RULE_NEWLINE(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_NEWLINE; 
                    }

                    }
                    break;
                case 13 :
                    // InternalPreprocessLexer.g:114:2: ( FRAGMENT_RULE_WS )=> FRAGMENT_RULE_WS
                    {
                    mFRAGMENT_RULE_WS(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_WS; 
                    }

                    }
                    break;
                case 14 :
                    // InternalPreprocessLexer.g:115:2: ( FRAGMENT_RULE_ID )=> FRAGMENT_RULE_ID
                    {
                    mFRAGMENT_RULE_ID(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_ID; 
                    }

                    }
                    break;
                case 15 :
                    // InternalPreprocessLexer.g:116:2: ( FRAGMENT_RULE_CHAR_LITERAL )=> FRAGMENT_RULE_CHAR_LITERAL
                    {
                    mFRAGMENT_RULE_CHAR_LITERAL(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_CHAR_LITERAL; 
                    }

                    }
                    break;
                case 16 :
                    // InternalPreprocessLexer.g:117:2: ( FRAGMENT_RULE_STRING_LITERAL )=> FRAGMENT_RULE_STRING_LITERAL
                    {
                    mFRAGMENT_RULE_STRING_LITERAL(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_STRING_LITERAL; 
                    }

                    }
                    break;
                case 17 :
                    // InternalPreprocessLexer.g:118:2: ( FRAGMENT_RULE_HEX_LITERAL )=> FRAGMENT_RULE_HEX_LITERAL
                    {
                    mFRAGMENT_RULE_HEX_LITERAL(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_HEX_LITERAL; 
                    }

                    }
                    break;
                case 18 :
                    // InternalPreprocessLexer.g:119:2: ( FRAGMENT_RULE_DECIMAL_LITERAL )=> FRAGMENT_RULE_DECIMAL_LITERAL
                    {
                    mFRAGMENT_RULE_DECIMAL_LITERAL(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_DECIMAL_LITERAL; 
                    }

                    }
                    break;
                case 19 :
                    // InternalPreprocessLexer.g:120:2: ( FRAGMENT_RULE_OCTAL_LITERAL )=> FRAGMENT_RULE_OCTAL_LITERAL
                    {
                    mFRAGMENT_RULE_OCTAL_LITERAL(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_OCTAL_LITERAL; 
                    }

                    }
                    break;
                case 20 :
                    // InternalPreprocessLexer.g:121:2: ( FRAGMENT_RULE_BIN_LITERAL )=> FRAGMENT_RULE_BIN_LITERAL
                    {
                    mFRAGMENT_RULE_BIN_LITERAL(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_BIN_LITERAL; 
                    }

                    }
                    break;
                case 21 :
                    // InternalPreprocessLexer.g:122:2: ( FRAGMENT_RULE_FLOAT_LITERAL )=> FRAGMENT_RULE_FLOAT_LITERAL
                    {
                    mFRAGMENT_RULE_FLOAT_LITERAL(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_FLOAT_LITERAL; 
                    }

                    }
                    break;
                case 22 :
                    // InternalPreprocessLexer.g:123:2: ( FRAGMENT_RULE_SKW_AND )=> FRAGMENT_RULE_SKW_AND
                    {
                    mFRAGMENT_RULE_SKW_AND(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_AND; 
                    }

                    }
                    break;
                case 23 :
                    // InternalPreprocessLexer.g:124:2: ( FRAGMENT_RULE_SKW_ANDAND )=> FRAGMENT_RULE_SKW_ANDAND
                    {
                    mFRAGMENT_RULE_SKW_ANDAND(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_ANDAND; 
                    }

                    }
                    break;
                case 24 :
                    // InternalPreprocessLexer.g:125:2: ( FRAGMENT_RULE_SKW_ASSIGN )=> FRAGMENT_RULE_SKW_ASSIGN
                    {
                    mFRAGMENT_RULE_SKW_ASSIGN(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_ASSIGN; 
                    }

                    }
                    break;
                case 25 :
                    // InternalPreprocessLexer.g:126:2: ( FRAGMENT_RULE_SKW_BACKSLASH )=> FRAGMENT_RULE_SKW_BACKSLASH
                    {
                    mFRAGMENT_RULE_SKW_BACKSLASH(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_BACKSLASH; 
                    }

                    }
                    break;
                case 26 :
                    // InternalPreprocessLexer.g:127:2: ( FRAGMENT_RULE_SKW_CARET )=> FRAGMENT_RULE_SKW_CARET
                    {
                    mFRAGMENT_RULE_SKW_CARET(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_CARET; 
                    }

                    }
                    break;
                case 27 :
                    // InternalPreprocessLexer.g:128:2: ( FRAGMENT_RULE_SKW_COMMA )=> FRAGMENT_RULE_SKW_COMMA
                    {
                    mFRAGMENT_RULE_SKW_COMMA(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_COMMA; 
                    }

                    }
                    break;
                case 28 :
                    // InternalPreprocessLexer.g:129:2: ( FRAGMENT_RULE_SKW_COLON )=> FRAGMENT_RULE_SKW_COLON
                    {
                    mFRAGMENT_RULE_SKW_COLON(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_COLON; 
                    }

                    }
                    break;
                case 29 :
                    // InternalPreprocessLexer.g:130:2: ( FRAGMENT_RULE_SKW_DIV )=> FRAGMENT_RULE_SKW_DIV
                    {
                    mFRAGMENT_RULE_SKW_DIV(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_DIV; 
                    }

                    }
                    break;
                case 30 :
                    // InternalPreprocessLexer.g:131:2: ( FRAGMENT_RULE_SKW_DOT )=> FRAGMENT_RULE_SKW_DOT
                    {
                    mFRAGMENT_RULE_SKW_DOT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_DOT; 
                    }

                    }
                    break;
                case 31 :
                    // InternalPreprocessLexer.g:132:2: ( FRAGMENT_RULE_SKW_DOUBLEQUOTE )=> FRAGMENT_RULE_SKW_DOUBLEQUOTE
                    {
                    mFRAGMENT_RULE_SKW_DOUBLEQUOTE(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_DOUBLEQUOTE; 
                    }

                    }
                    break;
                case 32 :
                    // InternalPreprocessLexer.g:133:2: ( FRAGMENT_RULE_SKW_EQUAL )=> FRAGMENT_RULE_SKW_EQUAL
                    {
                    mFRAGMENT_RULE_SKW_EQUAL(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_EQUAL; 
                    }

                    }
                    break;
                case 33 :
                    // InternalPreprocessLexer.g:134:2: ( FRAGMENT_RULE_SKW_GREATER )=> FRAGMENT_RULE_SKW_GREATER
                    {
                    mFRAGMENT_RULE_SKW_GREATER(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_GREATER; 
                    }

                    }
                    break;
                case 34 :
                    // InternalPreprocessLexer.g:135:2: ( FRAGMENT_RULE_SKW_GREATEREQUAL )=> FRAGMENT_RULE_SKW_GREATEREQUAL
                    {
                    mFRAGMENT_RULE_SKW_GREATEREQUAL(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_GREATEREQUAL; 
                    }

                    }
                    break;
                case 35 :
                    // InternalPreprocessLexer.g:136:2: ( FRAGMENT_RULE_SKW_LEFTBRACE )=> FRAGMENT_RULE_SKW_LEFTBRACE
                    {
                    mFRAGMENT_RULE_SKW_LEFTBRACE(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_LEFTBRACE; 
                    }

                    }
                    break;
                case 36 :
                    // InternalPreprocessLexer.g:137:2: ( FRAGMENT_RULE_SKW_LEFTBRACKET )=> FRAGMENT_RULE_SKW_LEFTBRACKET
                    {
                    mFRAGMENT_RULE_SKW_LEFTBRACKET(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_LEFTBRACKET; 
                    }

                    }
                    break;
                case 37 :
                    // InternalPreprocessLexer.g:138:2: ( FRAGMENT_RULE_SKW_LEFTPAREN )=> FRAGMENT_RULE_SKW_LEFTPAREN
                    {
                    mFRAGMENT_RULE_SKW_LEFTPAREN(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_LEFTPAREN; 
                    }

                    }
                    break;
                case 38 :
                    // InternalPreprocessLexer.g:139:2: ( FRAGMENT_RULE_SKW_LEFTSHIFT )=> FRAGMENT_RULE_SKW_LEFTSHIFT
                    {
                    mFRAGMENT_RULE_SKW_LEFTSHIFT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_LEFTSHIFT; 
                    }

                    }
                    break;
                case 39 :
                    // InternalPreprocessLexer.g:140:2: ( FRAGMENT_RULE_SKW_LESS )=> FRAGMENT_RULE_SKW_LESS
                    {
                    mFRAGMENT_RULE_SKW_LESS(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_LESS; 
                    }

                    }
                    break;
                case 40 :
                    // InternalPreprocessLexer.g:141:2: ( FRAGMENT_RULE_SKW_LESSEQUAL )=> FRAGMENT_RULE_SKW_LESSEQUAL
                    {
                    mFRAGMENT_RULE_SKW_LESSEQUAL(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_LESSEQUAL; 
                    }

                    }
                    break;
                case 41 :
                    // InternalPreprocessLexer.g:142:2: ( FRAGMENT_RULE_SKW_MINUS )=> FRAGMENT_RULE_SKW_MINUS
                    {
                    mFRAGMENT_RULE_SKW_MINUS(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_MINUS; 
                    }

                    }
                    break;
                case 42 :
                    // InternalPreprocessLexer.g:143:2: ( FRAGMENT_RULE_SKW_MINUSMINUS )=> FRAGMENT_RULE_SKW_MINUSMINUS
                    {
                    mFRAGMENT_RULE_SKW_MINUSMINUS(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_MINUSMINUS; 
                    }

                    }
                    break;
                case 43 :
                    // InternalPreprocessLexer.g:144:2: ( FRAGMENT_RULE_SKW_MOD )=> FRAGMENT_RULE_SKW_MOD
                    {
                    mFRAGMENT_RULE_SKW_MOD(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_MOD; 
                    }

                    }
                    break;
                case 44 :
                    // InternalPreprocessLexer.g:145:2: ( FRAGMENT_RULE_SKW_NOT )=> FRAGMENT_RULE_SKW_NOT
                    {
                    mFRAGMENT_RULE_SKW_NOT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_NOT; 
                    }

                    }
                    break;
                case 45 :
                    // InternalPreprocessLexer.g:146:2: ( FRAGMENT_RULE_SKW_NOTEQUAL )=> FRAGMENT_RULE_SKW_NOTEQUAL
                    {
                    mFRAGMENT_RULE_SKW_NOTEQUAL(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_NOTEQUAL; 
                    }

                    }
                    break;
                case 46 :
                    // InternalPreprocessLexer.g:147:2: ( FRAGMENT_RULE_SKW_OR )=> FRAGMENT_RULE_SKW_OR
                    {
                    mFRAGMENT_RULE_SKW_OR(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_OR; 
                    }

                    }
                    break;
                case 47 :
                    // InternalPreprocessLexer.g:148:2: ( FRAGMENT_RULE_SKW_OROR )=> FRAGMENT_RULE_SKW_OROR
                    {
                    mFRAGMENT_RULE_SKW_OROR(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_OROR; 
                    }

                    }
                    break;
                case 48 :
                    // InternalPreprocessLexer.g:149:2: ( FRAGMENT_RULE_SKW_PLUS )=> FRAGMENT_RULE_SKW_PLUS
                    {
                    mFRAGMENT_RULE_SKW_PLUS(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_PLUS; 
                    }

                    }
                    break;
                case 49 :
                    // InternalPreprocessLexer.g:150:2: ( FRAGMENT_RULE_SKW_PLUSPLUS )=> FRAGMENT_RULE_SKW_PLUSPLUS
                    {
                    mFRAGMENT_RULE_SKW_PLUSPLUS(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_PLUSPLUS; 
                    }

                    }
                    break;
                case 50 :
                    // InternalPreprocessLexer.g:151:2: ( FRAGMENT_RULE_SKW_QUESTION )=> FRAGMENT_RULE_SKW_QUESTION
                    {
                    mFRAGMENT_RULE_SKW_QUESTION(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_QUESTION; 
                    }

                    }
                    break;
                case 51 :
                    // InternalPreprocessLexer.g:152:2: ( FRAGMENT_RULE_SKW_RIGHTBRACE )=> FRAGMENT_RULE_SKW_RIGHTBRACE
                    {
                    mFRAGMENT_RULE_SKW_RIGHTBRACE(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_RIGHTBRACE; 
                    }

                    }
                    break;
                case 52 :
                    // InternalPreprocessLexer.g:153:2: ( FRAGMENT_RULE_SKW_RIGHTBRACKET )=> FRAGMENT_RULE_SKW_RIGHTBRACKET
                    {
                    mFRAGMENT_RULE_SKW_RIGHTBRACKET(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_RIGHTBRACKET; 
                    }

                    }
                    break;
                case 53 :
                    // InternalPreprocessLexer.g:154:2: ( FRAGMENT_RULE_SKW_RIGHTPAREN )=> FRAGMENT_RULE_SKW_RIGHTPAREN
                    {
                    mFRAGMENT_RULE_SKW_RIGHTPAREN(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_RIGHTPAREN; 
                    }

                    }
                    break;
                case 54 :
                    // InternalPreprocessLexer.g:155:2: ( FRAGMENT_RULE_SKW_RIGHTSHIFT )=> FRAGMENT_RULE_SKW_RIGHTSHIFT
                    {
                    mFRAGMENT_RULE_SKW_RIGHTSHIFT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_RIGHTSHIFT; 
                    }

                    }
                    break;
                case 55 :
                    // InternalPreprocessLexer.g:156:2: ( FRAGMENT_RULE_SKW_SEMI )=> FRAGMENT_RULE_SKW_SEMI
                    {
                    mFRAGMENT_RULE_SKW_SEMI(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_SEMI; 
                    }

                    }
                    break;
                case 56 :
                    // InternalPreprocessLexer.g:157:2: ( FRAGMENT_RULE_SKW_SINGLEQUOTE )=> FRAGMENT_RULE_SKW_SINGLEQUOTE
                    {
                    mFRAGMENT_RULE_SKW_SINGLEQUOTE(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_SINGLEQUOTE; 
                    }

                    }
                    break;
                case 57 :
                    // InternalPreprocessLexer.g:158:2: ( FRAGMENT_RULE_SKW_STAR )=> FRAGMENT_RULE_SKW_STAR
                    {
                    mFRAGMENT_RULE_SKW_STAR(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_STAR; 
                    }

                    }
                    break;
                case 58 :
                    // InternalPreprocessLexer.g:159:2: ( FRAGMENT_RULE_SKW_TILDE )=> FRAGMENT_RULE_SKW_TILDE
                    {
                    mFRAGMENT_RULE_SKW_TILDE(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _type = RULE_SKW_TILDE; 
                    }

                    }
                    break;
                case 59 :
                    // InternalPreprocessLexer.g:160:2: ( FRAGMENT_RULE_SPECIAL )=> FRAGMENT_RULE_SPECIAL
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
            // InternalPreprocessLexer.g:165:20: ( FRAGMENT_RULE_HASH )
            // InternalPreprocessLexer.g:165:22: FRAGMENT_RULE_HASH
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
            // InternalPreprocessLexer.g:166:29: ( '#' )
            // InternalPreprocessLexer.g:166:31: '#'
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
            // InternalPreprocessLexer.g:168:23: ( FRAGMENT_RULE_INCLUDE )
            // InternalPreprocessLexer.g:168:25: FRAGMENT_RULE_INCLUDE
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
            // InternalPreprocessLexer.g:169:32: ( 'include' )
            // InternalPreprocessLexer.g:169:34: 'include'
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
            // InternalPreprocessLexer.g:171:22: ( FRAGMENT_RULE_DEFINE )
            // InternalPreprocessLexer.g:171:24: FRAGMENT_RULE_DEFINE
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
            // InternalPreprocessLexer.g:172:31: ( 'define' )
            // InternalPreprocessLexer.g:172:33: 'define'
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
            // InternalPreprocessLexer.g:174:21: ( FRAGMENT_RULE_ERROR )
            // InternalPreprocessLexer.g:174:23: FRAGMENT_RULE_ERROR
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
            // InternalPreprocessLexer.g:175:30: ( 'error' )
            // InternalPreprocessLexer.g:175:32: 'error'
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
            // InternalPreprocessLexer.g:177:21: ( FRAGMENT_RULE_UNDEF )
            // InternalPreprocessLexer.g:177:23: FRAGMENT_RULE_UNDEF
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
            // InternalPreprocessLexer.g:178:30: ( 'undef' )
            // InternalPreprocessLexer.g:178:32: 'undef'
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
            // InternalPreprocessLexer.g:180:18: ( FRAGMENT_RULE_IF )
            // InternalPreprocessLexer.g:180:20: FRAGMENT_RULE_IF
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
            // InternalPreprocessLexer.g:181:27: ( 'if' )
            // InternalPreprocessLexer.g:181:29: 'if'
            {
            match("if"); if (state.failed) return ;


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, FRAGMENT_RULE_IF_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_IF"

    // $ANTLR start "RULE_DEFINED"
    public final void mRULE_DEFINED() throws RecognitionException {
        int RULE_DEFINED_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return ; }
            // InternalPreprocessLexer.g:183:23: ( FRAGMENT_RULE_DEFINED )
            // InternalPreprocessLexer.g:183:25: FRAGMENT_RULE_DEFINED
            {
            mFRAGMENT_RULE_DEFINED(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, RULE_DEFINED_StartIndex); }
        }
    }
    // $ANTLR end "RULE_DEFINED"

    // $ANTLR start "FRAGMENT_RULE_DEFINED"
    public final void mFRAGMENT_RULE_DEFINED() throws RecognitionException {
        int FRAGMENT_RULE_DEFINED_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return ; }
            // InternalPreprocessLexer.g:184:32: ( 'defined' )
            // InternalPreprocessLexer.g:184:34: 'defined'
            {
            match("defined"); if (state.failed) return ;


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, FRAGMENT_RULE_DEFINED_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_DEFINED"

    // $ANTLR start "RULE_IFDEF"
    public final void mRULE_IFDEF() throws RecognitionException {
        int RULE_IFDEF_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return ; }
            // InternalPreprocessLexer.g:186:21: ( FRAGMENT_RULE_IFDEF )
            // InternalPreprocessLexer.g:186:23: FRAGMENT_RULE_IFDEF
            {
            mFRAGMENT_RULE_IFDEF(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, RULE_IFDEF_StartIndex); }
        }
    }
    // $ANTLR end "RULE_IFDEF"

    // $ANTLR start "FRAGMENT_RULE_IFDEF"
    public final void mFRAGMENT_RULE_IFDEF() throws RecognitionException {
        int FRAGMENT_RULE_IFDEF_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return ; }
            // InternalPreprocessLexer.g:187:30: ( 'ifdef' )
            // InternalPreprocessLexer.g:187:32: 'ifdef'
            {
            match("ifdef"); if (state.failed) return ;


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, FRAGMENT_RULE_IFDEF_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_IFDEF"

    // $ANTLR start "RULE_IFNOTDEF"
    public final void mRULE_IFNOTDEF() throws RecognitionException {
        int RULE_IFNOTDEF_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return ; }
            // InternalPreprocessLexer.g:189:24: ( FRAGMENT_RULE_IFNOTDEF )
            // InternalPreprocessLexer.g:189:26: FRAGMENT_RULE_IFNOTDEF
            {
            mFRAGMENT_RULE_IFNOTDEF(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, RULE_IFNOTDEF_StartIndex); }
        }
    }
    // $ANTLR end "RULE_IFNOTDEF"

    // $ANTLR start "FRAGMENT_RULE_IFNOTDEF"
    public final void mFRAGMENT_RULE_IFNOTDEF() throws RecognitionException {
        int FRAGMENT_RULE_IFNOTDEF_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return ; }
            // InternalPreprocessLexer.g:190:33: ( 'ifndef' )
            // InternalPreprocessLexer.g:190:35: 'ifndef'
            {
            match("ifndef"); if (state.failed) return ;


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, FRAGMENT_RULE_IFNOTDEF_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_IFNOTDEF"

    // $ANTLR start "RULE_ENDIF"
    public final void mRULE_ENDIF() throws RecognitionException {
        int RULE_ENDIF_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return ; }
            // InternalPreprocessLexer.g:192:21: ( FRAGMENT_RULE_ENDIF )
            // InternalPreprocessLexer.g:192:23: FRAGMENT_RULE_ENDIF
            {
            mFRAGMENT_RULE_ENDIF(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, RULE_ENDIF_StartIndex); }
        }
    }
    // $ANTLR end "RULE_ENDIF"

    // $ANTLR start "FRAGMENT_RULE_ENDIF"
    public final void mFRAGMENT_RULE_ENDIF() throws RecognitionException {
        int FRAGMENT_RULE_ENDIF_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return ; }
            // InternalPreprocessLexer.g:193:30: ( 'endif' )
            // InternalPreprocessLexer.g:193:32: 'endif'
            {
            match("endif"); if (state.failed) return ;


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, FRAGMENT_RULE_ENDIF_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_ENDIF"

    // $ANTLR start "RULE_PRAGMA"
    public final void mRULE_PRAGMA() throws RecognitionException {
        int RULE_PRAGMA_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return ; }
            // InternalPreprocessLexer.g:195:22: ( FRAGMENT_RULE_PRAGMA )
            // InternalPreprocessLexer.g:195:24: FRAGMENT_RULE_PRAGMA
            {
            mFRAGMENT_RULE_PRAGMA(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 22, RULE_PRAGMA_StartIndex); }
        }
    }
    // $ANTLR end "RULE_PRAGMA"

    // $ANTLR start "FRAGMENT_RULE_PRAGMA"
    public final void mFRAGMENT_RULE_PRAGMA() throws RecognitionException {
        int FRAGMENT_RULE_PRAGMA_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return ; }
            // InternalPreprocessLexer.g:196:31: ( 'pragma' )
            // InternalPreprocessLexer.g:196:33: 'pragma'
            {
            match("pragma"); if (state.failed) return ;


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, FRAGMENT_RULE_PRAGMA_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_PRAGMA"

    // $ANTLR start "RULE_LINEFEED"
    public final void mRULE_LINEFEED() throws RecognitionException {
        int RULE_LINEFEED_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return ; }
            // InternalPreprocessLexer.g:198:24: ( '\\n' )
            // InternalPreprocessLexer.g:198:26: '\\n'
            {
            match('\n'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 24, RULE_LINEFEED_StartIndex); }
        }
    }
    // $ANTLR end "RULE_LINEFEED"

    // $ANTLR start "RULE_CARRIAGERETURN"
    public final void mRULE_CARRIAGERETURN() throws RecognitionException {
        int RULE_CARRIAGERETURN_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return ; }
            // InternalPreprocessLexer.g:200:30: ( '\\r' )
            // InternalPreprocessLexer.g:200:32: '\\r'
            {
            match('\r'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, RULE_CARRIAGERETURN_StartIndex); }
        }
    }
    // $ANTLR end "RULE_CARRIAGERETURN"

    // $ANTLR start "RULE_NEWLINE"
    public final void mRULE_NEWLINE() throws RecognitionException {
        int RULE_NEWLINE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return ; }
            // InternalPreprocessLexer.g:202:23: ( FRAGMENT_RULE_NEWLINE )
            // InternalPreprocessLexer.g:202:25: FRAGMENT_RULE_NEWLINE
            {
            mFRAGMENT_RULE_NEWLINE(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 26, RULE_NEWLINE_StartIndex); }
        }
    }
    // $ANTLR end "RULE_NEWLINE"

    // $ANTLR start "FRAGMENT_RULE_NEWLINE"
    public final void mFRAGMENT_RULE_NEWLINE() throws RecognitionException {
        int FRAGMENT_RULE_NEWLINE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return ; }
            // InternalPreprocessLexer.g:203:32: ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) )
            // InternalPreprocessLexer.g:203:34: ( RULE_CARRIAGERETURN | RULE_LINEFEED )
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
            if ( state.backtracking>0 ) { memoize(input, 27, FRAGMENT_RULE_NEWLINE_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_NEWLINE"

    // $ANTLR start "RULE_LINEBREAK"
    public final void mRULE_LINEBREAK() throws RecognitionException {
        int RULE_LINEBREAK_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return ; }
            // InternalPreprocessLexer.g:205:25: ( RULE_SKW_BACKSLASH RULE_NEWLINE )
            // InternalPreprocessLexer.g:205:27: RULE_SKW_BACKSLASH RULE_NEWLINE
            {
            mRULE_SKW_BACKSLASH(); if (state.failed) return ;
            mRULE_NEWLINE(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 28, RULE_LINEBREAK_StartIndex); }
        }
    }
    // $ANTLR end "RULE_LINEBREAK"

    // $ANTLR start "RULE_SPACE"
    public final void mRULE_SPACE() throws RecognitionException {
        int RULE_SPACE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return ; }
            // InternalPreprocessLexer.g:207:21: ( ' ' )
            // InternalPreprocessLexer.g:207:23: ' '
            {
            match(' '); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, RULE_SPACE_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SPACE"

    // $ANTLR start "RULE_TAB"
    public final void mRULE_TAB() throws RecognitionException {
        int RULE_TAB_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return ; }
            // InternalPreprocessLexer.g:209:19: ( '\\t' )
            // InternalPreprocessLexer.g:209:21: '\\t'
            {
            match('\t'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 30, RULE_TAB_StartIndex); }
        }
    }
    // $ANTLR end "RULE_TAB"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        int RULE_WS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return ; }
            // InternalPreprocessLexer.g:211:18: ( FRAGMENT_RULE_WS )
            // InternalPreprocessLexer.g:211:20: FRAGMENT_RULE_WS
            {
            mFRAGMENT_RULE_WS(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 31, RULE_WS_StartIndex); }
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "FRAGMENT_RULE_WS"
    public final void mFRAGMENT_RULE_WS() throws RecognitionException {
        int FRAGMENT_RULE_WS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return ; }
            // InternalPreprocessLexer.g:212:27: ( ( RULE_SPACE | RULE_TAB | RULE_LINE_COMMENT | RULE_BLOCK_COMMENT | RULE_LINEBREAK ) )
            // InternalPreprocessLexer.g:212:29: ( RULE_SPACE | RULE_TAB | RULE_LINE_COMMENT | RULE_BLOCK_COMMENT | RULE_LINEBREAK )
            {
            // InternalPreprocessLexer.g:212:29: ( RULE_SPACE | RULE_TAB | RULE_LINE_COMMENT | RULE_BLOCK_COMMENT | RULE_LINEBREAK )
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
                    // InternalPreprocessLexer.g:212:30: RULE_SPACE
                    {
                    mRULE_SPACE(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // InternalPreprocessLexer.g:212:41: RULE_TAB
                    {
                    mRULE_TAB(); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // InternalPreprocessLexer.g:212:50: RULE_LINE_COMMENT
                    {
                    mRULE_LINE_COMMENT(); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // InternalPreprocessLexer.g:212:68: RULE_BLOCK_COMMENT
                    {
                    mRULE_BLOCK_COMMENT(); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // InternalPreprocessLexer.g:212:87: RULE_LINEBREAK
                    {
                    mRULE_LINEBREAK(); if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 32, FRAGMENT_RULE_WS_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_WS"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        int RULE_ID_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return ; }
            // InternalPreprocessLexer.g:214:18: ( FRAGMENT_RULE_ID )
            // InternalPreprocessLexer.g:214:20: FRAGMENT_RULE_ID
            {
            mFRAGMENT_RULE_ID(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 33, RULE_ID_StartIndex); }
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "FRAGMENT_RULE_ID"
    public final void mFRAGMENT_RULE_ID() throws RecognitionException {
        int FRAGMENT_RULE_ID_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return ; }
            // InternalPreprocessLexer.g:215:27: ( RULE_IDENTIFIER )
            // InternalPreprocessLexer.g:215:29: RULE_IDENTIFIER
            {
            mRULE_IDENTIFIER(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 34, FRAGMENT_RULE_ID_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_ID"

    // $ANTLR start "RULE_IDENTIFIER"
    public final void mRULE_IDENTIFIER() throws RecognitionException {
        int RULE_IDENTIFIER_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return ; }
            // InternalPreprocessLexer.g:217:26: ( RULE_LETTER ( RULE_LETTER | '0' .. '9' )* )
            // InternalPreprocessLexer.g:217:28: RULE_LETTER ( RULE_LETTER | '0' .. '9' )*
            {
            mRULE_LETTER(); if (state.failed) return ;
            // InternalPreprocessLexer.g:217:40: ( RULE_LETTER | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='$'||(LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalPreprocessLexer.g:
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
            if ( state.backtracking>0 ) { memoize(input, 35, RULE_IDENTIFIER_StartIndex); }
        }
    }
    // $ANTLR end "RULE_IDENTIFIER"

    // $ANTLR start "RULE_LETTER"
    public final void mRULE_LETTER() throws RecognitionException {
        int RULE_LETTER_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return ; }
            // InternalPreprocessLexer.g:219:22: ( ( RULE_SKW_DOLLAR | 'A' .. 'Z' | 'a' .. 'z' | RULE_SKW_UNDERSCORE ) )
            // InternalPreprocessLexer.g:219:24: ( RULE_SKW_DOLLAR | 'A' .. 'Z' | 'a' .. 'z' | RULE_SKW_UNDERSCORE )
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
            if ( state.backtracking>0 ) { memoize(input, 36, RULE_LETTER_StartIndex); }
        }
    }
    // $ANTLR end "RULE_LETTER"

    // $ANTLR start "RULE_CHAR_LITERAL"
    public final void mRULE_CHAR_LITERAL() throws RecognitionException {
        int RULE_CHAR_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return ; }
            // InternalPreprocessLexer.g:221:28: ( FRAGMENT_RULE_CHAR_LITERAL )
            // InternalPreprocessLexer.g:221:30: FRAGMENT_RULE_CHAR_LITERAL
            {
            mFRAGMENT_RULE_CHAR_LITERAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 37, RULE_CHAR_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_CHAR_LITERAL"

    // $ANTLR start "FRAGMENT_RULE_CHAR_LITERAL"
    public final void mFRAGMENT_RULE_CHAR_LITERAL() throws RecognitionException {
        int FRAGMENT_RULE_CHAR_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return ; }
            // InternalPreprocessLexer.g:222:37: ( RULE_SKW_SINGLEQUOTE ( RULE_ESCAPE_SEQUENCE | ~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) ) RULE_SKW_SINGLEQUOTE )
            // InternalPreprocessLexer.g:222:39: RULE_SKW_SINGLEQUOTE ( RULE_ESCAPE_SEQUENCE | ~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) ) RULE_SKW_SINGLEQUOTE
            {
            mRULE_SKW_SINGLEQUOTE(); if (state.failed) return ;
            // InternalPreprocessLexer.g:222:60: ( RULE_ESCAPE_SEQUENCE | ~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) ) )
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
                    // InternalPreprocessLexer.g:222:61: RULE_ESCAPE_SEQUENCE
                    {
                    mRULE_ESCAPE_SEQUENCE(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // InternalPreprocessLexer.g:222:82: ~ ( ( RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) )
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
            if ( state.backtracking>0 ) { memoize(input, 38, FRAGMENT_RULE_CHAR_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_CHAR_LITERAL"

    // $ANTLR start "RULE_STRING_LITERAL"
    public final void mRULE_STRING_LITERAL() throws RecognitionException {
        int RULE_STRING_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return ; }
            // InternalPreprocessLexer.g:224:30: ( FRAGMENT_RULE_STRING_LITERAL )
            // InternalPreprocessLexer.g:224:32: FRAGMENT_RULE_STRING_LITERAL
            {
            mFRAGMENT_RULE_STRING_LITERAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 39, RULE_STRING_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_STRING_LITERAL"

    // $ANTLR start "FRAGMENT_RULE_STRING_LITERAL"
    public final void mFRAGMENT_RULE_STRING_LITERAL() throws RecognitionException {
        int FRAGMENT_RULE_STRING_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return ; }
            // InternalPreprocessLexer.g:225:39: ( RULE_SKW_DOUBLEQUOTE ( RULE_ESCAPE_SEQUENCE | ~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) )* RULE_SKW_DOUBLEQUOTE )
            // InternalPreprocessLexer.g:225:41: RULE_SKW_DOUBLEQUOTE ( RULE_ESCAPE_SEQUENCE | ~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) )* RULE_SKW_DOUBLEQUOTE
            {
            mRULE_SKW_DOUBLEQUOTE(); if (state.failed) return ;
            // InternalPreprocessLexer.g:225:62: ( RULE_ESCAPE_SEQUENCE | ~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) ) )*
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
            	    // InternalPreprocessLexer.g:225:63: RULE_ESCAPE_SEQUENCE
            	    {
            	    mRULE_ESCAPE_SEQUENCE(); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // InternalPreprocessLexer.g:225:84: ~ ( ( RULE_SKW_BACKSLASH | RULE_SKW_DOUBLEQUOTE ) )
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
            if ( state.backtracking>0 ) { memoize(input, 40, FRAGMENT_RULE_STRING_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_STRING_LITERAL"

    // $ANTLR start "RULE_HEX_LITERAL"
    public final void mRULE_HEX_LITERAL() throws RecognitionException {
        int RULE_HEX_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return ; }
            // InternalPreprocessLexer.g:227:27: ( FRAGMENT_RULE_HEX_LITERAL )
            // InternalPreprocessLexer.g:227:29: FRAGMENT_RULE_HEX_LITERAL
            {
            mFRAGMENT_RULE_HEX_LITERAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 41, RULE_HEX_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_HEX_LITERAL"

    // $ANTLR start "FRAGMENT_RULE_HEX_LITERAL"
    public final void mFRAGMENT_RULE_HEX_LITERAL() throws RecognitionException {
        int FRAGMENT_RULE_HEX_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return ; }
            // InternalPreprocessLexer.g:228:36: ( '0' ( 'x' | 'X' ) ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )? )
            // InternalPreprocessLexer.g:228:38: '0' ( 'x' | 'X' ) ( RULE_HEX_DIGIT )+ ( RULE_INTEGER_TYPE_SUFFIX )?
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

            // InternalPreprocessLexer.g:228:52: ( RULE_HEX_DIGIT )+
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
            	    // InternalPreprocessLexer.g:0:0: RULE_HEX_DIGIT
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

            // InternalPreprocessLexer.g:228:68: ( RULE_INTEGER_TYPE_SUFFIX )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='L'||LA7_0=='U'||LA7_0=='l'||LA7_0=='u') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalPreprocessLexer.g:0:0: RULE_INTEGER_TYPE_SUFFIX
                    {
                    mRULE_INTEGER_TYPE_SUFFIX(); if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 42, FRAGMENT_RULE_HEX_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_HEX_LITERAL"

    // $ANTLR start "RULE_DECIMAL_LITERAL"
    public final void mRULE_DECIMAL_LITERAL() throws RecognitionException {
        int RULE_DECIMAL_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return ; }
            // InternalPreprocessLexer.g:230:31: ( FRAGMENT_RULE_DECIMAL_LITERAL )
            // InternalPreprocessLexer.g:230:33: FRAGMENT_RULE_DECIMAL_LITERAL
            {
            mFRAGMENT_RULE_DECIMAL_LITERAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 43, RULE_DECIMAL_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_DECIMAL_LITERAL"

    // $ANTLR start "FRAGMENT_RULE_DECIMAL_LITERAL"
    public final void mFRAGMENT_RULE_DECIMAL_LITERAL() throws RecognitionException {
        int FRAGMENT_RULE_DECIMAL_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return ; }
            // InternalPreprocessLexer.g:231:40: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( RULE_INTEGER_TYPE_SUFFIX )? )
            // InternalPreprocessLexer.g:231:42: ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( RULE_INTEGER_TYPE_SUFFIX )?
            {
            // InternalPreprocessLexer.g:231:42: ( '0' | '1' .. '9' ( '0' .. '9' )* )
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
                    // InternalPreprocessLexer.g:231:43: '0'
                    {
                    match('0'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // InternalPreprocessLexer.g:231:47: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); if (state.failed) return ;
                    // InternalPreprocessLexer.g:231:56: ( '0' .. '9' )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalPreprocessLexer.g:231:57: '0' .. '9'
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

            // InternalPreprocessLexer.g:231:69: ( RULE_INTEGER_TYPE_SUFFIX )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='L'||LA10_0=='U'||LA10_0=='l'||LA10_0=='u') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalPreprocessLexer.g:0:0: RULE_INTEGER_TYPE_SUFFIX
                    {
                    mRULE_INTEGER_TYPE_SUFFIX(); if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 44, FRAGMENT_RULE_DECIMAL_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_DECIMAL_LITERAL"

    // $ANTLR start "RULE_OCTAL_LITERAL"
    public final void mRULE_OCTAL_LITERAL() throws RecognitionException {
        int RULE_OCTAL_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return ; }
            // InternalPreprocessLexer.g:233:29: ( FRAGMENT_RULE_OCTAL_LITERAL )
            // InternalPreprocessLexer.g:233:31: FRAGMENT_RULE_OCTAL_LITERAL
            {
            mFRAGMENT_RULE_OCTAL_LITERAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 45, RULE_OCTAL_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_OCTAL_LITERAL"

    // $ANTLR start "FRAGMENT_RULE_OCTAL_LITERAL"
    public final void mFRAGMENT_RULE_OCTAL_LITERAL() throws RecognitionException {
        int FRAGMENT_RULE_OCTAL_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return ; }
            // InternalPreprocessLexer.g:234:38: ( '0' ( '0' .. '7' )+ ( RULE_INTEGER_TYPE_SUFFIX )? )
            // InternalPreprocessLexer.g:234:40: '0' ( '0' .. '7' )+ ( RULE_INTEGER_TYPE_SUFFIX )?
            {
            match('0'); if (state.failed) return ;
            // InternalPreprocessLexer.g:234:44: ( '0' .. '7' )+
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
            	    // InternalPreprocessLexer.g:234:45: '0' .. '7'
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

            // InternalPreprocessLexer.g:234:56: ( RULE_INTEGER_TYPE_SUFFIX )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='L'||LA12_0=='U'||LA12_0=='l'||LA12_0=='u') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalPreprocessLexer.g:0:0: RULE_INTEGER_TYPE_SUFFIX
                    {
                    mRULE_INTEGER_TYPE_SUFFIX(); if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 46, FRAGMENT_RULE_OCTAL_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_OCTAL_LITERAL"

    // $ANTLR start "RULE_BIN_LITERAL"
    public final void mRULE_BIN_LITERAL() throws RecognitionException {
        int RULE_BIN_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return ; }
            // InternalPreprocessLexer.g:236:27: ( FRAGMENT_RULE_BIN_LITERAL )
            // InternalPreprocessLexer.g:236:29: FRAGMENT_RULE_BIN_LITERAL
            {
            mFRAGMENT_RULE_BIN_LITERAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 47, RULE_BIN_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_BIN_LITERAL"

    // $ANTLR start "FRAGMENT_RULE_BIN_LITERAL"
    public final void mFRAGMENT_RULE_BIN_LITERAL() throws RecognitionException {
        int FRAGMENT_RULE_BIN_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return ; }
            // InternalPreprocessLexer.g:237:36: ( ( '0b' | '0B' ) ( '0' .. '1' )+ )
            // InternalPreprocessLexer.g:237:38: ( '0b' | '0B' ) ( '0' .. '1' )+
            {
            // InternalPreprocessLexer.g:237:38: ( '0b' | '0B' )
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
                    // InternalPreprocessLexer.g:237:39: '0b'
                    {
                    match("0b"); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // InternalPreprocessLexer.g:237:44: '0B'
                    {
                    match("0B"); if (state.failed) return ;


                    }
                    break;

            }

            // InternalPreprocessLexer.g:237:50: ( '0' .. '1' )+
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
            	    // InternalPreprocessLexer.g:237:51: '0' .. '1'
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
            if ( state.backtracking>0 ) { memoize(input, 48, FRAGMENT_RULE_BIN_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_BIN_LITERAL"

    // $ANTLR start "RULE_HEX_DIGIT"
    public final void mRULE_HEX_DIGIT() throws RecognitionException {
        int RULE_HEX_DIGIT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return ; }
            // InternalPreprocessLexer.g:239:25: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // InternalPreprocessLexer.g:239:27: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
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
            if ( state.backtracking>0 ) { memoize(input, 49, RULE_HEX_DIGIT_StartIndex); }
        }
    }
    // $ANTLR end "RULE_HEX_DIGIT"

    // $ANTLR start "RULE_INTEGER_TYPE_SUFFIX"
    public final void mRULE_INTEGER_TYPE_SUFFIX() throws RecognitionException {
        int RULE_INTEGER_TYPE_SUFFIX_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return ; }
            // InternalPreprocessLexer.g:241:35: ( ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? ) )
            // InternalPreprocessLexer.g:241:37: ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? )
            {
            // InternalPreprocessLexer.g:241:37: ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='U'||LA17_0=='u') ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1=='L'||LA17_1=='l') ) {
                    int LA17_3 = input.LA(3);

                    if ( (synpred90_InternalPreprocessLexer()) ) {
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
                    // InternalPreprocessLexer.g:241:38: ( 'u' | 'U' )? ( 'l' | 'L' )
                    {
                    // InternalPreprocessLexer.g:241:38: ( 'u' | 'U' )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='U'||LA15_0=='u') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // InternalPreprocessLexer.g:
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
                    // InternalPreprocessLexer.g:241:59: ( 'u' | 'U' ) ( 'l' | 'L' )?
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

                    // InternalPreprocessLexer.g:241:69: ( 'l' | 'L' )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='L'||LA16_0=='l') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalPreprocessLexer.g:
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
            if ( state.backtracking>0 ) { memoize(input, 50, RULE_INTEGER_TYPE_SUFFIX_StartIndex); }
        }
    }
    // $ANTLR end "RULE_INTEGER_TYPE_SUFFIX"

    // $ANTLR start "RULE_FLOAT_LITERAL"
    public final void mRULE_FLOAT_LITERAL() throws RecognitionException {
        int RULE_FLOAT_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return ; }
            // InternalPreprocessLexer.g:243:29: ( FRAGMENT_RULE_FLOAT_LITERAL )
            // InternalPreprocessLexer.g:243:31: FRAGMENT_RULE_FLOAT_LITERAL
            {
            mFRAGMENT_RULE_FLOAT_LITERAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 51, RULE_FLOAT_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_FLOAT_LITERAL"

    // $ANTLR start "FRAGMENT_RULE_FLOAT_LITERAL"
    public final void mFRAGMENT_RULE_FLOAT_LITERAL() throws RecognitionException {
        int FRAGMENT_RULE_FLOAT_LITERAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return ; }
            // InternalPreprocessLexer.g:244:38: ( ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX ) )
            // InternalPreprocessLexer.g:244:40: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )
            {
            // InternalPreprocessLexer.g:244:40: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )
            int alt29=4;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // InternalPreprocessLexer.g:244:41: ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )?
                    {
                    // InternalPreprocessLexer.g:244:41: ( '0' .. '9' )+
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
                    	    // InternalPreprocessLexer.g:244:42: '0' .. '9'
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
                    // InternalPreprocessLexer.g:244:66: ( '0' .. '9' )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0>='0' && LA19_0<='9')) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalPreprocessLexer.g:244:67: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    // InternalPreprocessLexer.g:244:78: ( RULE_EXPONENT )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0=='E'||LA20_0=='e') ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // InternalPreprocessLexer.g:0:0: RULE_EXPONENT
                            {
                            mRULE_EXPONENT(); if (state.failed) return ;

                            }
                            break;

                    }

                    // InternalPreprocessLexer.g:244:93: ( RULE_FLOAT_TYPE_SUFFIX )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0=='D'||LA21_0=='F'||LA21_0=='d'||LA21_0=='f') ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // InternalPreprocessLexer.g:0:0: RULE_FLOAT_TYPE_SUFFIX
                            {
                            mRULE_FLOAT_TYPE_SUFFIX(); if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalPreprocessLexer.g:244:117: RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )?
                    {
                    mRULE_SKW_DOT(); if (state.failed) return ;
                    // InternalPreprocessLexer.g:244:130: ( '0' .. '9' )+
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
                    	    // InternalPreprocessLexer.g:244:131: '0' .. '9'
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

                    // InternalPreprocessLexer.g:244:142: ( RULE_EXPONENT )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0=='E'||LA23_0=='e') ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // InternalPreprocessLexer.g:0:0: RULE_EXPONENT
                            {
                            mRULE_EXPONENT(); if (state.failed) return ;

                            }
                            break;

                    }

                    // InternalPreprocessLexer.g:244:157: ( RULE_FLOAT_TYPE_SUFFIX )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0=='D'||LA24_0=='F'||LA24_0=='d'||LA24_0=='f') ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // InternalPreprocessLexer.g:0:0: RULE_FLOAT_TYPE_SUFFIX
                            {
                            mRULE_FLOAT_TYPE_SUFFIX(); if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // InternalPreprocessLexer.g:244:181: ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )?
                    {
                    // InternalPreprocessLexer.g:244:181: ( '0' .. '9' )+
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
                    	    // InternalPreprocessLexer.g:244:182: '0' .. '9'
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
                    // InternalPreprocessLexer.g:244:207: ( RULE_FLOAT_TYPE_SUFFIX )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0=='D'||LA26_0=='F'||LA26_0=='d'||LA26_0=='f') ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // InternalPreprocessLexer.g:0:0: RULE_FLOAT_TYPE_SUFFIX
                            {
                            mRULE_FLOAT_TYPE_SUFFIX(); if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // InternalPreprocessLexer.g:244:231: ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX
                    {
                    // InternalPreprocessLexer.g:244:231: ( '0' .. '9' )+
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
                    	    // InternalPreprocessLexer.g:244:232: '0' .. '9'
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

                    // InternalPreprocessLexer.g:244:243: ( RULE_EXPONENT )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0=='E'||LA28_0=='e') ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // InternalPreprocessLexer.g:0:0: RULE_EXPONENT
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
            if ( state.backtracking>0 ) { memoize(input, 52, FRAGMENT_RULE_FLOAT_LITERAL_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_FLOAT_LITERAL"

    // $ANTLR start "RULE_EXPONENT"
    public final void mRULE_EXPONENT() throws RecognitionException {
        int RULE_EXPONENT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return ; }
            // InternalPreprocessLexer.g:246:24: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // InternalPreprocessLexer.g:246:26: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
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

            // InternalPreprocessLexer.g:246:36: ( '+' | '-' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0=='+'||LA30_0=='-') ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalPreprocessLexer.g:
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

            // InternalPreprocessLexer.g:246:47: ( '0' .. '9' )+
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
            	    // InternalPreprocessLexer.g:246:48: '0' .. '9'
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
            if ( state.backtracking>0 ) { memoize(input, 53, RULE_EXPONENT_StartIndex); }
        }
    }
    // $ANTLR end "RULE_EXPONENT"

    // $ANTLR start "RULE_FLOAT_TYPE_SUFFIX"
    public final void mRULE_FLOAT_TYPE_SUFFIX() throws RecognitionException {
        int RULE_FLOAT_TYPE_SUFFIX_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return ; }
            // InternalPreprocessLexer.g:248:33: ( ( 'f' | 'F' | 'd' | 'D' ) )
            // InternalPreprocessLexer.g:248:35: ( 'f' | 'F' | 'd' | 'D' )
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
            if ( state.backtracking>0 ) { memoize(input, 54, RULE_FLOAT_TYPE_SUFFIX_StartIndex); }
        }
    }
    // $ANTLR end "RULE_FLOAT_TYPE_SUFFIX"

    // $ANTLR start "RULE_ESCAPE_SEQUENCE"
    public final void mRULE_ESCAPE_SEQUENCE() throws RecognitionException {
        int RULE_ESCAPE_SEQUENCE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return ; }
            // InternalPreprocessLexer.g:250:31: ( ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE ) )
            // InternalPreprocessLexer.g:250:33: ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE )
            {
            // InternalPreprocessLexer.g:250:33: ( RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH ) | RULE_OCTAL_ESCAPE )
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
                    // InternalPreprocessLexer.g:250:34: RULE_SKW_BACKSLASH ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | RULE_SKW_SINGLEQUOTE | RULE_SKW_BACKSLASH )
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
                    // InternalPreprocessLexer.g:250:119: RULE_OCTAL_ESCAPE
                    {
                    mRULE_OCTAL_ESCAPE(); if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 55, RULE_ESCAPE_SEQUENCE_StartIndex); }
        }
    }
    // $ANTLR end "RULE_ESCAPE_SEQUENCE"

    // $ANTLR start "RULE_OCTAL_ESCAPE"
    public final void mRULE_OCTAL_ESCAPE() throws RecognitionException {
        int RULE_OCTAL_ESCAPE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return ; }
            // InternalPreprocessLexer.g:252:28: ( ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' ) )
            // InternalPreprocessLexer.g:252:30: ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' )
            {
            // InternalPreprocessLexer.g:252:30: ( RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7' | RULE_SKW_BACKSLASH '0' .. '7' )
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
                    // InternalPreprocessLexer.g:252:31: RULE_SKW_BACKSLASH '0' .. '3' '0' .. '7' '0' .. '7'
                    {
                    mRULE_SKW_BACKSLASH(); if (state.failed) return ;
                    matchRange('0','3'); if (state.failed) return ;
                    matchRange('0','7'); if (state.failed) return ;
                    matchRange('0','7'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // InternalPreprocessLexer.g:252:77: RULE_SKW_BACKSLASH '0' .. '7' '0' .. '7'
                    {
                    mRULE_SKW_BACKSLASH(); if (state.failed) return ;
                    matchRange('0','7'); if (state.failed) return ;
                    matchRange('0','7'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // InternalPreprocessLexer.g:252:114: RULE_SKW_BACKSLASH '0' .. '7'
                    {
                    mRULE_SKW_BACKSLASH(); if (state.failed) return ;
                    matchRange('0','7'); if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 56, RULE_OCTAL_ESCAPE_StartIndex); }
        }
    }
    // $ANTLR end "RULE_OCTAL_ESCAPE"

    // $ANTLR start "RULE_BLOCK_COMMENT"
    public final void mRULE_BLOCK_COMMENT() throws RecognitionException {
        int RULE_BLOCK_COMMENT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return ; }
            // InternalPreprocessLexer.g:254:29: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalPreprocessLexer.g:254:31: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); if (state.failed) return ;

            // InternalPreprocessLexer.g:254:36: ( options {greedy=false; } : . )*
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
            	    // InternalPreprocessLexer.g:254:64: .
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
            if ( state.backtracking>0 ) { memoize(input, 57, RULE_BLOCK_COMMENT_StartIndex); }
        }
    }
    // $ANTLR end "RULE_BLOCK_COMMENT"

    // $ANTLR start "RULE_LINE_COMMENT"
    public final void mRULE_LINE_COMMENT() throws RecognitionException {
        int RULE_LINE_COMMENT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return ; }
            // InternalPreprocessLexer.g:256:28: ( '//' (~ ( RULE_NEWLINE ) )* )
            // InternalPreprocessLexer.g:256:30: '//' (~ ( RULE_NEWLINE ) )*
            {
            match("//"); if (state.failed) return ;

            // InternalPreprocessLexer.g:256:35: (~ ( RULE_NEWLINE ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>='\u0000' && LA35_0<='\t')||(LA35_0>='\u000B' && LA35_0<='\f')||(LA35_0>='\u000E' && LA35_0<='\uFFFF')) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalPreprocessLexer.g:0:0: ~ ( RULE_NEWLINE )
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
            if ( state.backtracking>0 ) { memoize(input, 58, RULE_LINE_COMMENT_StartIndex); }
        }
    }
    // $ANTLR end "RULE_LINE_COMMENT"

    // $ANTLR start "RULE_SKW_AND"
    public final void mRULE_SKW_AND() throws RecognitionException {
        int RULE_SKW_AND_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return ; }
            // InternalPreprocessLexer.g:258:23: ( FRAGMENT_RULE_SKW_AND )
            // InternalPreprocessLexer.g:258:25: FRAGMENT_RULE_SKW_AND
            {
            mFRAGMENT_RULE_SKW_AND(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 59, RULE_SKW_AND_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_AND"

    // $ANTLR start "FRAGMENT_RULE_SKW_AND"
    public final void mFRAGMENT_RULE_SKW_AND() throws RecognitionException {
        int FRAGMENT_RULE_SKW_AND_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return ; }
            // InternalPreprocessLexer.g:259:32: ( '&' )
            // InternalPreprocessLexer.g:259:34: '&'
            {
            match('&'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 60, FRAGMENT_RULE_SKW_AND_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_AND"

    // $ANTLR start "RULE_SKW_ANDAND"
    public final void mRULE_SKW_ANDAND() throws RecognitionException {
        int RULE_SKW_ANDAND_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return ; }
            // InternalPreprocessLexer.g:261:26: ( FRAGMENT_RULE_SKW_ANDAND )
            // InternalPreprocessLexer.g:261:28: FRAGMENT_RULE_SKW_ANDAND
            {
            mFRAGMENT_RULE_SKW_ANDAND(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 61, RULE_SKW_ANDAND_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_ANDAND"

    // $ANTLR start "FRAGMENT_RULE_SKW_ANDAND"
    public final void mFRAGMENT_RULE_SKW_ANDAND() throws RecognitionException {
        int FRAGMENT_RULE_SKW_ANDAND_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return ; }
            // InternalPreprocessLexer.g:262:35: ( RULE_SKW_AND RULE_SKW_AND )
            // InternalPreprocessLexer.g:262:37: RULE_SKW_AND RULE_SKW_AND
            {
            mRULE_SKW_AND(); if (state.failed) return ;
            mRULE_SKW_AND(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 62, FRAGMENT_RULE_SKW_ANDAND_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_ANDAND"

    // $ANTLR start "RULE_SKW_ASSIGN"
    public final void mRULE_SKW_ASSIGN() throws RecognitionException {
        int RULE_SKW_ASSIGN_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return ; }
            // InternalPreprocessLexer.g:264:26: ( FRAGMENT_RULE_SKW_ASSIGN )
            // InternalPreprocessLexer.g:264:28: FRAGMENT_RULE_SKW_ASSIGN
            {
            mFRAGMENT_RULE_SKW_ASSIGN(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 63, RULE_SKW_ASSIGN_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_ASSIGN"

    // $ANTLR start "FRAGMENT_RULE_SKW_ASSIGN"
    public final void mFRAGMENT_RULE_SKW_ASSIGN() throws RecognitionException {
        int FRAGMENT_RULE_SKW_ASSIGN_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return ; }
            // InternalPreprocessLexer.g:265:35: ( '=' )
            // InternalPreprocessLexer.g:265:37: '='
            {
            match('='); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 64, FRAGMENT_RULE_SKW_ASSIGN_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_ASSIGN"

    // $ANTLR start "RULE_SKW_BACKSLASH"
    public final void mRULE_SKW_BACKSLASH() throws RecognitionException {
        int RULE_SKW_BACKSLASH_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return ; }
            // InternalPreprocessLexer.g:267:29: ( FRAGMENT_RULE_SKW_BACKSLASH )
            // InternalPreprocessLexer.g:267:31: FRAGMENT_RULE_SKW_BACKSLASH
            {
            mFRAGMENT_RULE_SKW_BACKSLASH(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 65, RULE_SKW_BACKSLASH_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_BACKSLASH"

    // $ANTLR start "FRAGMENT_RULE_SKW_BACKSLASH"
    public final void mFRAGMENT_RULE_SKW_BACKSLASH() throws RecognitionException {
        int FRAGMENT_RULE_SKW_BACKSLASH_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return ; }
            // InternalPreprocessLexer.g:268:38: ( '\\\\' )
            // InternalPreprocessLexer.g:268:40: '\\\\'
            {
            match('\\'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 66, FRAGMENT_RULE_SKW_BACKSLASH_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_BACKSLASH"

    // $ANTLR start "RULE_SKW_CARET"
    public final void mRULE_SKW_CARET() throws RecognitionException {
        int RULE_SKW_CARET_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return ; }
            // InternalPreprocessLexer.g:270:25: ( FRAGMENT_RULE_SKW_CARET )
            // InternalPreprocessLexer.g:270:27: FRAGMENT_RULE_SKW_CARET
            {
            mFRAGMENT_RULE_SKW_CARET(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 67, RULE_SKW_CARET_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_CARET"

    // $ANTLR start "FRAGMENT_RULE_SKW_CARET"
    public final void mFRAGMENT_RULE_SKW_CARET() throws RecognitionException {
        int FRAGMENT_RULE_SKW_CARET_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return ; }
            // InternalPreprocessLexer.g:271:34: ( '^' )
            // InternalPreprocessLexer.g:271:36: '^'
            {
            match('^'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 68, FRAGMENT_RULE_SKW_CARET_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_CARET"

    // $ANTLR start "RULE_SKW_COMMA"
    public final void mRULE_SKW_COMMA() throws RecognitionException {
        int RULE_SKW_COMMA_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return ; }
            // InternalPreprocessLexer.g:273:25: ( FRAGMENT_RULE_SKW_COMMA )
            // InternalPreprocessLexer.g:273:27: FRAGMENT_RULE_SKW_COMMA
            {
            mFRAGMENT_RULE_SKW_COMMA(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 69, RULE_SKW_COMMA_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_COMMA"

    // $ANTLR start "FRAGMENT_RULE_SKW_COMMA"
    public final void mFRAGMENT_RULE_SKW_COMMA() throws RecognitionException {
        int FRAGMENT_RULE_SKW_COMMA_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return ; }
            // InternalPreprocessLexer.g:274:34: ( ',' )
            // InternalPreprocessLexer.g:274:36: ','
            {
            match(','); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 70, FRAGMENT_RULE_SKW_COMMA_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_COMMA"

    // $ANTLR start "RULE_SKW_COLON"
    public final void mRULE_SKW_COLON() throws RecognitionException {
        int RULE_SKW_COLON_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return ; }
            // InternalPreprocessLexer.g:276:25: ( FRAGMENT_RULE_SKW_COLON )
            // InternalPreprocessLexer.g:276:27: FRAGMENT_RULE_SKW_COLON
            {
            mFRAGMENT_RULE_SKW_COLON(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 71, RULE_SKW_COLON_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_COLON"

    // $ANTLR start "FRAGMENT_RULE_SKW_COLON"
    public final void mFRAGMENT_RULE_SKW_COLON() throws RecognitionException {
        int FRAGMENT_RULE_SKW_COLON_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return ; }
            // InternalPreprocessLexer.g:277:34: ( ':' )
            // InternalPreprocessLexer.g:277:36: ':'
            {
            match(':'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 72, FRAGMENT_RULE_SKW_COLON_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_COLON"

    // $ANTLR start "RULE_SKW_DIV"
    public final void mRULE_SKW_DIV() throws RecognitionException {
        int RULE_SKW_DIV_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return ; }
            // InternalPreprocessLexer.g:279:23: ( FRAGMENT_RULE_SKW_DIV )
            // InternalPreprocessLexer.g:279:25: FRAGMENT_RULE_SKW_DIV
            {
            mFRAGMENT_RULE_SKW_DIV(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 73, RULE_SKW_DIV_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_DIV"

    // $ANTLR start "FRAGMENT_RULE_SKW_DIV"
    public final void mFRAGMENT_RULE_SKW_DIV() throws RecognitionException {
        int FRAGMENT_RULE_SKW_DIV_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return ; }
            // InternalPreprocessLexer.g:280:32: ( '/' )
            // InternalPreprocessLexer.g:280:34: '/'
            {
            match('/'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 74, FRAGMENT_RULE_SKW_DIV_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_DIV"

    // $ANTLR start "RULE_SKW_DOLLAR"
    public final void mRULE_SKW_DOLLAR() throws RecognitionException {
        int RULE_SKW_DOLLAR_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return ; }
            // InternalPreprocessLexer.g:282:26: ( '$' )
            // InternalPreprocessLexer.g:282:28: '$'
            {
            match('$'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 75, RULE_SKW_DOLLAR_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_DOLLAR"

    // $ANTLR start "RULE_SKW_DOT"
    public final void mRULE_SKW_DOT() throws RecognitionException {
        int RULE_SKW_DOT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return ; }
            // InternalPreprocessLexer.g:284:23: ( FRAGMENT_RULE_SKW_DOT )
            // InternalPreprocessLexer.g:284:25: FRAGMENT_RULE_SKW_DOT
            {
            mFRAGMENT_RULE_SKW_DOT(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 76, RULE_SKW_DOT_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_DOT"

    // $ANTLR start "FRAGMENT_RULE_SKW_DOT"
    public final void mFRAGMENT_RULE_SKW_DOT() throws RecognitionException {
        int FRAGMENT_RULE_SKW_DOT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return ; }
            // InternalPreprocessLexer.g:285:32: ( '.' )
            // InternalPreprocessLexer.g:285:34: '.'
            {
            match('.'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 77, FRAGMENT_RULE_SKW_DOT_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_DOT"

    // $ANTLR start "RULE_SKW_DOUBLEQUOTE"
    public final void mRULE_SKW_DOUBLEQUOTE() throws RecognitionException {
        int RULE_SKW_DOUBLEQUOTE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 78) ) { return ; }
            // InternalPreprocessLexer.g:287:31: ( FRAGMENT_RULE_SKW_DOUBLEQUOTE )
            // InternalPreprocessLexer.g:287:33: FRAGMENT_RULE_SKW_DOUBLEQUOTE
            {
            mFRAGMENT_RULE_SKW_DOUBLEQUOTE(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 78, RULE_SKW_DOUBLEQUOTE_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_DOUBLEQUOTE"

    // $ANTLR start "FRAGMENT_RULE_SKW_DOUBLEQUOTE"
    public final void mFRAGMENT_RULE_SKW_DOUBLEQUOTE() throws RecognitionException {
        int FRAGMENT_RULE_SKW_DOUBLEQUOTE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 79) ) { return ; }
            // InternalPreprocessLexer.g:288:40: ( '\"' )
            // InternalPreprocessLexer.g:288:42: '\"'
            {
            match('\"'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 79, FRAGMENT_RULE_SKW_DOUBLEQUOTE_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_DOUBLEQUOTE"

    // $ANTLR start "RULE_SKW_EQUAL"
    public final void mRULE_SKW_EQUAL() throws RecognitionException {
        int RULE_SKW_EQUAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 80) ) { return ; }
            // InternalPreprocessLexer.g:290:25: ( FRAGMENT_RULE_SKW_EQUAL )
            // InternalPreprocessLexer.g:290:27: FRAGMENT_RULE_SKW_EQUAL
            {
            mFRAGMENT_RULE_SKW_EQUAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 80, RULE_SKW_EQUAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_EQUAL"

    // $ANTLR start "FRAGMENT_RULE_SKW_EQUAL"
    public final void mFRAGMENT_RULE_SKW_EQUAL() throws RecognitionException {
        int FRAGMENT_RULE_SKW_EQUAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 81) ) { return ; }
            // InternalPreprocessLexer.g:291:34: ( RULE_SKW_ASSIGN RULE_SKW_ASSIGN )
            // InternalPreprocessLexer.g:291:36: RULE_SKW_ASSIGN RULE_SKW_ASSIGN
            {
            mRULE_SKW_ASSIGN(); if (state.failed) return ;
            mRULE_SKW_ASSIGN(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 81, FRAGMENT_RULE_SKW_EQUAL_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_EQUAL"

    // $ANTLR start "RULE_SKW_GREATER"
    public final void mRULE_SKW_GREATER() throws RecognitionException {
        int RULE_SKW_GREATER_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 82) ) { return ; }
            // InternalPreprocessLexer.g:293:27: ( FRAGMENT_RULE_SKW_GREATER )
            // InternalPreprocessLexer.g:293:29: FRAGMENT_RULE_SKW_GREATER
            {
            mFRAGMENT_RULE_SKW_GREATER(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 82, RULE_SKW_GREATER_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_GREATER"

    // $ANTLR start "FRAGMENT_RULE_SKW_GREATER"
    public final void mFRAGMENT_RULE_SKW_GREATER() throws RecognitionException {
        int FRAGMENT_RULE_SKW_GREATER_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 83) ) { return ; }
            // InternalPreprocessLexer.g:294:36: ( '>' )
            // InternalPreprocessLexer.g:294:38: '>'
            {
            match('>'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 83, FRAGMENT_RULE_SKW_GREATER_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_GREATER"

    // $ANTLR start "RULE_SKW_GREATEREQUAL"
    public final void mRULE_SKW_GREATEREQUAL() throws RecognitionException {
        int RULE_SKW_GREATEREQUAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 84) ) { return ; }
            // InternalPreprocessLexer.g:296:32: ( FRAGMENT_RULE_SKW_GREATEREQUAL )
            // InternalPreprocessLexer.g:296:34: FRAGMENT_RULE_SKW_GREATEREQUAL
            {
            mFRAGMENT_RULE_SKW_GREATEREQUAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 84, RULE_SKW_GREATEREQUAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_GREATEREQUAL"

    // $ANTLR start "FRAGMENT_RULE_SKW_GREATEREQUAL"
    public final void mFRAGMENT_RULE_SKW_GREATEREQUAL() throws RecognitionException {
        int FRAGMENT_RULE_SKW_GREATEREQUAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 85) ) { return ; }
            // InternalPreprocessLexer.g:297:41: ( RULE_SKW_GREATER RULE_SKW_ASSIGN )
            // InternalPreprocessLexer.g:297:43: RULE_SKW_GREATER RULE_SKW_ASSIGN
            {
            mRULE_SKW_GREATER(); if (state.failed) return ;
            mRULE_SKW_ASSIGN(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 85, FRAGMENT_RULE_SKW_GREATEREQUAL_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_GREATEREQUAL"

    // $ANTLR start "RULE_SKW_LEFTBRACE"
    public final void mRULE_SKW_LEFTBRACE() throws RecognitionException {
        int RULE_SKW_LEFTBRACE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 86) ) { return ; }
            // InternalPreprocessLexer.g:299:29: ( FRAGMENT_RULE_SKW_LEFTBRACE )
            // InternalPreprocessLexer.g:299:31: FRAGMENT_RULE_SKW_LEFTBRACE
            {
            mFRAGMENT_RULE_SKW_LEFTBRACE(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 86, RULE_SKW_LEFTBRACE_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_LEFTBRACE"

    // $ANTLR start "FRAGMENT_RULE_SKW_LEFTBRACE"
    public final void mFRAGMENT_RULE_SKW_LEFTBRACE() throws RecognitionException {
        int FRAGMENT_RULE_SKW_LEFTBRACE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 87) ) { return ; }
            // InternalPreprocessLexer.g:300:38: ( '{' )
            // InternalPreprocessLexer.g:300:40: '{'
            {
            match('{'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 87, FRAGMENT_RULE_SKW_LEFTBRACE_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_LEFTBRACE"

    // $ANTLR start "RULE_SKW_LEFTBRACKET"
    public final void mRULE_SKW_LEFTBRACKET() throws RecognitionException {
        int RULE_SKW_LEFTBRACKET_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 88) ) { return ; }
            // InternalPreprocessLexer.g:302:31: ( FRAGMENT_RULE_SKW_LEFTBRACKET )
            // InternalPreprocessLexer.g:302:33: FRAGMENT_RULE_SKW_LEFTBRACKET
            {
            mFRAGMENT_RULE_SKW_LEFTBRACKET(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 88, RULE_SKW_LEFTBRACKET_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_LEFTBRACKET"

    // $ANTLR start "FRAGMENT_RULE_SKW_LEFTBRACKET"
    public final void mFRAGMENT_RULE_SKW_LEFTBRACKET() throws RecognitionException {
        int FRAGMENT_RULE_SKW_LEFTBRACKET_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 89) ) { return ; }
            // InternalPreprocessLexer.g:303:40: ( '[' )
            // InternalPreprocessLexer.g:303:42: '['
            {
            match('['); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 89, FRAGMENT_RULE_SKW_LEFTBRACKET_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_LEFTBRACKET"

    // $ANTLR start "RULE_SKW_LEFTPAREN"
    public final void mRULE_SKW_LEFTPAREN() throws RecognitionException {
        int RULE_SKW_LEFTPAREN_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 90) ) { return ; }
            // InternalPreprocessLexer.g:305:29: ( FRAGMENT_RULE_SKW_LEFTPAREN )
            // InternalPreprocessLexer.g:305:31: FRAGMENT_RULE_SKW_LEFTPAREN
            {
            mFRAGMENT_RULE_SKW_LEFTPAREN(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 90, RULE_SKW_LEFTPAREN_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_LEFTPAREN"

    // $ANTLR start "FRAGMENT_RULE_SKW_LEFTPAREN"
    public final void mFRAGMENT_RULE_SKW_LEFTPAREN() throws RecognitionException {
        int FRAGMENT_RULE_SKW_LEFTPAREN_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 91) ) { return ; }
            // InternalPreprocessLexer.g:306:38: ( '(' )
            // InternalPreprocessLexer.g:306:40: '('
            {
            match('('); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 91, FRAGMENT_RULE_SKW_LEFTPAREN_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_LEFTPAREN"

    // $ANTLR start "RULE_SKW_LEFTSHIFT"
    public final void mRULE_SKW_LEFTSHIFT() throws RecognitionException {
        int RULE_SKW_LEFTSHIFT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 92) ) { return ; }
            // InternalPreprocessLexer.g:308:29: ( FRAGMENT_RULE_SKW_LEFTSHIFT )
            // InternalPreprocessLexer.g:308:31: FRAGMENT_RULE_SKW_LEFTSHIFT
            {
            mFRAGMENT_RULE_SKW_LEFTSHIFT(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 92, RULE_SKW_LEFTSHIFT_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_LEFTSHIFT"

    // $ANTLR start "FRAGMENT_RULE_SKW_LEFTSHIFT"
    public final void mFRAGMENT_RULE_SKW_LEFTSHIFT() throws RecognitionException {
        int FRAGMENT_RULE_SKW_LEFTSHIFT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 93) ) { return ; }
            // InternalPreprocessLexer.g:309:38: ( RULE_SKW_LESS RULE_SKW_LESS )
            // InternalPreprocessLexer.g:309:40: RULE_SKW_LESS RULE_SKW_LESS
            {
            mRULE_SKW_LESS(); if (state.failed) return ;
            mRULE_SKW_LESS(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 93, FRAGMENT_RULE_SKW_LEFTSHIFT_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_LEFTSHIFT"

    // $ANTLR start "RULE_SKW_LESS"
    public final void mRULE_SKW_LESS() throws RecognitionException {
        int RULE_SKW_LESS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 94) ) { return ; }
            // InternalPreprocessLexer.g:311:24: ( FRAGMENT_RULE_SKW_LESS )
            // InternalPreprocessLexer.g:311:26: FRAGMENT_RULE_SKW_LESS
            {
            mFRAGMENT_RULE_SKW_LESS(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 94, RULE_SKW_LESS_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_LESS"

    // $ANTLR start "FRAGMENT_RULE_SKW_LESS"
    public final void mFRAGMENT_RULE_SKW_LESS() throws RecognitionException {
        int FRAGMENT_RULE_SKW_LESS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 95) ) { return ; }
            // InternalPreprocessLexer.g:312:33: ( '<' )
            // InternalPreprocessLexer.g:312:35: '<'
            {
            match('<'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 95, FRAGMENT_RULE_SKW_LESS_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_LESS"

    // $ANTLR start "RULE_SKW_LESSEQUAL"
    public final void mRULE_SKW_LESSEQUAL() throws RecognitionException {
        int RULE_SKW_LESSEQUAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 96) ) { return ; }
            // InternalPreprocessLexer.g:314:29: ( FRAGMENT_RULE_SKW_LESSEQUAL )
            // InternalPreprocessLexer.g:314:31: FRAGMENT_RULE_SKW_LESSEQUAL
            {
            mFRAGMENT_RULE_SKW_LESSEQUAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 96, RULE_SKW_LESSEQUAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_LESSEQUAL"

    // $ANTLR start "FRAGMENT_RULE_SKW_LESSEQUAL"
    public final void mFRAGMENT_RULE_SKW_LESSEQUAL() throws RecognitionException {
        int FRAGMENT_RULE_SKW_LESSEQUAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 97) ) { return ; }
            // InternalPreprocessLexer.g:315:38: ( RULE_SKW_LESS RULE_SKW_ASSIGN )
            // InternalPreprocessLexer.g:315:40: RULE_SKW_LESS RULE_SKW_ASSIGN
            {
            mRULE_SKW_LESS(); if (state.failed) return ;
            mRULE_SKW_ASSIGN(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 97, FRAGMENT_RULE_SKW_LESSEQUAL_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_LESSEQUAL"

    // $ANTLR start "RULE_SKW_MINUS"
    public final void mRULE_SKW_MINUS() throws RecognitionException {
        int RULE_SKW_MINUS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 98) ) { return ; }
            // InternalPreprocessLexer.g:317:25: ( FRAGMENT_RULE_SKW_MINUS )
            // InternalPreprocessLexer.g:317:27: FRAGMENT_RULE_SKW_MINUS
            {
            mFRAGMENT_RULE_SKW_MINUS(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 98, RULE_SKW_MINUS_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_MINUS"

    // $ANTLR start "FRAGMENT_RULE_SKW_MINUS"
    public final void mFRAGMENT_RULE_SKW_MINUS() throws RecognitionException {
        int FRAGMENT_RULE_SKW_MINUS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 99) ) { return ; }
            // InternalPreprocessLexer.g:318:34: ( '-' )
            // InternalPreprocessLexer.g:318:36: '-'
            {
            match('-'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 99, FRAGMENT_RULE_SKW_MINUS_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_MINUS"

    // $ANTLR start "RULE_SKW_MINUSMINUS"
    public final void mRULE_SKW_MINUSMINUS() throws RecognitionException {
        int RULE_SKW_MINUSMINUS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 100) ) { return ; }
            // InternalPreprocessLexer.g:320:30: ( FRAGMENT_RULE_SKW_MINUSMINUS )
            // InternalPreprocessLexer.g:320:32: FRAGMENT_RULE_SKW_MINUSMINUS
            {
            mFRAGMENT_RULE_SKW_MINUSMINUS(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 100, RULE_SKW_MINUSMINUS_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_MINUSMINUS"

    // $ANTLR start "FRAGMENT_RULE_SKW_MINUSMINUS"
    public final void mFRAGMENT_RULE_SKW_MINUSMINUS() throws RecognitionException {
        int FRAGMENT_RULE_SKW_MINUSMINUS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 101) ) { return ; }
            // InternalPreprocessLexer.g:321:39: ( RULE_SKW_MINUS RULE_SKW_MINUS )
            // InternalPreprocessLexer.g:321:41: RULE_SKW_MINUS RULE_SKW_MINUS
            {
            mRULE_SKW_MINUS(); if (state.failed) return ;
            mRULE_SKW_MINUS(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 101, FRAGMENT_RULE_SKW_MINUSMINUS_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_MINUSMINUS"

    // $ANTLR start "RULE_SKW_MOD"
    public final void mRULE_SKW_MOD() throws RecognitionException {
        int RULE_SKW_MOD_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 102) ) { return ; }
            // InternalPreprocessLexer.g:323:23: ( FRAGMENT_RULE_SKW_MOD )
            // InternalPreprocessLexer.g:323:25: FRAGMENT_RULE_SKW_MOD
            {
            mFRAGMENT_RULE_SKW_MOD(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 102, RULE_SKW_MOD_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_MOD"

    // $ANTLR start "FRAGMENT_RULE_SKW_MOD"
    public final void mFRAGMENT_RULE_SKW_MOD() throws RecognitionException {
        int FRAGMENT_RULE_SKW_MOD_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 103) ) { return ; }
            // InternalPreprocessLexer.g:324:32: ( '%' )
            // InternalPreprocessLexer.g:324:34: '%'
            {
            match('%'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 103, FRAGMENT_RULE_SKW_MOD_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_MOD"

    // $ANTLR start "RULE_SKW_NOT"
    public final void mRULE_SKW_NOT() throws RecognitionException {
        int RULE_SKW_NOT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 104) ) { return ; }
            // InternalPreprocessLexer.g:326:23: ( FRAGMENT_RULE_SKW_NOT )
            // InternalPreprocessLexer.g:326:25: FRAGMENT_RULE_SKW_NOT
            {
            mFRAGMENT_RULE_SKW_NOT(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 104, RULE_SKW_NOT_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_NOT"

    // $ANTLR start "FRAGMENT_RULE_SKW_NOT"
    public final void mFRAGMENT_RULE_SKW_NOT() throws RecognitionException {
        int FRAGMENT_RULE_SKW_NOT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 105) ) { return ; }
            // InternalPreprocessLexer.g:327:32: ( '!' )
            // InternalPreprocessLexer.g:327:34: '!'
            {
            match('!'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 105, FRAGMENT_RULE_SKW_NOT_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_NOT"

    // $ANTLR start "RULE_SKW_NOTEQUAL"
    public final void mRULE_SKW_NOTEQUAL() throws RecognitionException {
        int RULE_SKW_NOTEQUAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 106) ) { return ; }
            // InternalPreprocessLexer.g:329:28: ( FRAGMENT_RULE_SKW_NOTEQUAL )
            // InternalPreprocessLexer.g:329:30: FRAGMENT_RULE_SKW_NOTEQUAL
            {
            mFRAGMENT_RULE_SKW_NOTEQUAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 106, RULE_SKW_NOTEQUAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_NOTEQUAL"

    // $ANTLR start "FRAGMENT_RULE_SKW_NOTEQUAL"
    public final void mFRAGMENT_RULE_SKW_NOTEQUAL() throws RecognitionException {
        int FRAGMENT_RULE_SKW_NOTEQUAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 107) ) { return ; }
            // InternalPreprocessLexer.g:330:37: ( RULE_SKW_NOT RULE_SKW_ASSIGN )
            // InternalPreprocessLexer.g:330:39: RULE_SKW_NOT RULE_SKW_ASSIGN
            {
            mRULE_SKW_NOT(); if (state.failed) return ;
            mRULE_SKW_ASSIGN(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 107, FRAGMENT_RULE_SKW_NOTEQUAL_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_NOTEQUAL"

    // $ANTLR start "RULE_SKW_OR"
    public final void mRULE_SKW_OR() throws RecognitionException {
        int RULE_SKW_OR_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 108) ) { return ; }
            // InternalPreprocessLexer.g:332:22: ( FRAGMENT_RULE_SKW_OR )
            // InternalPreprocessLexer.g:332:24: FRAGMENT_RULE_SKW_OR
            {
            mFRAGMENT_RULE_SKW_OR(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 108, RULE_SKW_OR_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_OR"

    // $ANTLR start "FRAGMENT_RULE_SKW_OR"
    public final void mFRAGMENT_RULE_SKW_OR() throws RecognitionException {
        int FRAGMENT_RULE_SKW_OR_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 109) ) { return ; }
            // InternalPreprocessLexer.g:333:31: ( '|' )
            // InternalPreprocessLexer.g:333:33: '|'
            {
            match('|'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 109, FRAGMENT_RULE_SKW_OR_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_OR"

    // $ANTLR start "RULE_SKW_OROR"
    public final void mRULE_SKW_OROR() throws RecognitionException {
        int RULE_SKW_OROR_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 110) ) { return ; }
            // InternalPreprocessLexer.g:335:24: ( FRAGMENT_RULE_SKW_OROR )
            // InternalPreprocessLexer.g:335:26: FRAGMENT_RULE_SKW_OROR
            {
            mFRAGMENT_RULE_SKW_OROR(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 110, RULE_SKW_OROR_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_OROR"

    // $ANTLR start "FRAGMENT_RULE_SKW_OROR"
    public final void mFRAGMENT_RULE_SKW_OROR() throws RecognitionException {
        int FRAGMENT_RULE_SKW_OROR_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 111) ) { return ; }
            // InternalPreprocessLexer.g:336:33: ( RULE_SKW_OR RULE_SKW_OR )
            // InternalPreprocessLexer.g:336:35: RULE_SKW_OR RULE_SKW_OR
            {
            mRULE_SKW_OR(); if (state.failed) return ;
            mRULE_SKW_OR(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 111, FRAGMENT_RULE_SKW_OROR_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_OROR"

    // $ANTLR start "RULE_SKW_PLUS"
    public final void mRULE_SKW_PLUS() throws RecognitionException {
        int RULE_SKW_PLUS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 112) ) { return ; }
            // InternalPreprocessLexer.g:338:24: ( FRAGMENT_RULE_SKW_PLUS )
            // InternalPreprocessLexer.g:338:26: FRAGMENT_RULE_SKW_PLUS
            {
            mFRAGMENT_RULE_SKW_PLUS(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 112, RULE_SKW_PLUS_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_PLUS"

    // $ANTLR start "FRAGMENT_RULE_SKW_PLUS"
    public final void mFRAGMENT_RULE_SKW_PLUS() throws RecognitionException {
        int FRAGMENT_RULE_SKW_PLUS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 113) ) { return ; }
            // InternalPreprocessLexer.g:339:33: ( '+' )
            // InternalPreprocessLexer.g:339:35: '+'
            {
            match('+'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 113, FRAGMENT_RULE_SKW_PLUS_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_PLUS"

    // $ANTLR start "RULE_SKW_PLUSPLUS"
    public final void mRULE_SKW_PLUSPLUS() throws RecognitionException {
        int RULE_SKW_PLUSPLUS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 114) ) { return ; }
            // InternalPreprocessLexer.g:341:28: ( FRAGMENT_RULE_SKW_PLUSPLUS )
            // InternalPreprocessLexer.g:341:30: FRAGMENT_RULE_SKW_PLUSPLUS
            {
            mFRAGMENT_RULE_SKW_PLUSPLUS(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 114, RULE_SKW_PLUSPLUS_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_PLUSPLUS"

    // $ANTLR start "FRAGMENT_RULE_SKW_PLUSPLUS"
    public final void mFRAGMENT_RULE_SKW_PLUSPLUS() throws RecognitionException {
        int FRAGMENT_RULE_SKW_PLUSPLUS_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 115) ) { return ; }
            // InternalPreprocessLexer.g:342:37: ( RULE_SKW_PLUS RULE_SKW_PLUS )
            // InternalPreprocessLexer.g:342:39: RULE_SKW_PLUS RULE_SKW_PLUS
            {
            mRULE_SKW_PLUS(); if (state.failed) return ;
            mRULE_SKW_PLUS(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 115, FRAGMENT_RULE_SKW_PLUSPLUS_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_PLUSPLUS"

    // $ANTLR start "RULE_SKW_QUESTION"
    public final void mRULE_SKW_QUESTION() throws RecognitionException {
        int RULE_SKW_QUESTION_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 116) ) { return ; }
            // InternalPreprocessLexer.g:344:28: ( FRAGMENT_RULE_SKW_QUESTION )
            // InternalPreprocessLexer.g:344:30: FRAGMENT_RULE_SKW_QUESTION
            {
            mFRAGMENT_RULE_SKW_QUESTION(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 116, RULE_SKW_QUESTION_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_QUESTION"

    // $ANTLR start "FRAGMENT_RULE_SKW_QUESTION"
    public final void mFRAGMENT_RULE_SKW_QUESTION() throws RecognitionException {
        int FRAGMENT_RULE_SKW_QUESTION_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 117) ) { return ; }
            // InternalPreprocessLexer.g:345:37: ( '?' )
            // InternalPreprocessLexer.g:345:39: '?'
            {
            match('?'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 117, FRAGMENT_RULE_SKW_QUESTION_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_QUESTION"

    // $ANTLR start "RULE_SKW_RIGHTBRACE"
    public final void mRULE_SKW_RIGHTBRACE() throws RecognitionException {
        int RULE_SKW_RIGHTBRACE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 118) ) { return ; }
            // InternalPreprocessLexer.g:347:30: ( FRAGMENT_RULE_SKW_RIGHTBRACE )
            // InternalPreprocessLexer.g:347:32: FRAGMENT_RULE_SKW_RIGHTBRACE
            {
            mFRAGMENT_RULE_SKW_RIGHTBRACE(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 118, RULE_SKW_RIGHTBRACE_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_RIGHTBRACE"

    // $ANTLR start "FRAGMENT_RULE_SKW_RIGHTBRACE"
    public final void mFRAGMENT_RULE_SKW_RIGHTBRACE() throws RecognitionException {
        int FRAGMENT_RULE_SKW_RIGHTBRACE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 119) ) { return ; }
            // InternalPreprocessLexer.g:348:39: ( '}' )
            // InternalPreprocessLexer.g:348:41: '}'
            {
            match('}'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 119, FRAGMENT_RULE_SKW_RIGHTBRACE_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_RIGHTBRACE"

    // $ANTLR start "RULE_SKW_RIGHTBRACKET"
    public final void mRULE_SKW_RIGHTBRACKET() throws RecognitionException {
        int RULE_SKW_RIGHTBRACKET_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 120) ) { return ; }
            // InternalPreprocessLexer.g:350:32: ( FRAGMENT_RULE_SKW_RIGHTBRACKET )
            // InternalPreprocessLexer.g:350:34: FRAGMENT_RULE_SKW_RIGHTBRACKET
            {
            mFRAGMENT_RULE_SKW_RIGHTBRACKET(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 120, RULE_SKW_RIGHTBRACKET_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_RIGHTBRACKET"

    // $ANTLR start "FRAGMENT_RULE_SKW_RIGHTBRACKET"
    public final void mFRAGMENT_RULE_SKW_RIGHTBRACKET() throws RecognitionException {
        int FRAGMENT_RULE_SKW_RIGHTBRACKET_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 121) ) { return ; }
            // InternalPreprocessLexer.g:351:41: ( ']' )
            // InternalPreprocessLexer.g:351:43: ']'
            {
            match(']'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 121, FRAGMENT_RULE_SKW_RIGHTBRACKET_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_RIGHTBRACKET"

    // $ANTLR start "RULE_SKW_RIGHTPAREN"
    public final void mRULE_SKW_RIGHTPAREN() throws RecognitionException {
        int RULE_SKW_RIGHTPAREN_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 122) ) { return ; }
            // InternalPreprocessLexer.g:353:30: ( FRAGMENT_RULE_SKW_RIGHTPAREN )
            // InternalPreprocessLexer.g:353:32: FRAGMENT_RULE_SKW_RIGHTPAREN
            {
            mFRAGMENT_RULE_SKW_RIGHTPAREN(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 122, RULE_SKW_RIGHTPAREN_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_RIGHTPAREN"

    // $ANTLR start "FRAGMENT_RULE_SKW_RIGHTPAREN"
    public final void mFRAGMENT_RULE_SKW_RIGHTPAREN() throws RecognitionException {
        int FRAGMENT_RULE_SKW_RIGHTPAREN_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 123) ) { return ; }
            // InternalPreprocessLexer.g:354:39: ( ')' )
            // InternalPreprocessLexer.g:354:41: ')'
            {
            match(')'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 123, FRAGMENT_RULE_SKW_RIGHTPAREN_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_RIGHTPAREN"

    // $ANTLR start "RULE_SKW_RIGHTSHIFT"
    public final void mRULE_SKW_RIGHTSHIFT() throws RecognitionException {
        int RULE_SKW_RIGHTSHIFT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 124) ) { return ; }
            // InternalPreprocessLexer.g:356:30: ( FRAGMENT_RULE_SKW_RIGHTSHIFT )
            // InternalPreprocessLexer.g:356:32: FRAGMENT_RULE_SKW_RIGHTSHIFT
            {
            mFRAGMENT_RULE_SKW_RIGHTSHIFT(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 124, RULE_SKW_RIGHTSHIFT_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_RIGHTSHIFT"

    // $ANTLR start "FRAGMENT_RULE_SKW_RIGHTSHIFT"
    public final void mFRAGMENT_RULE_SKW_RIGHTSHIFT() throws RecognitionException {
        int FRAGMENT_RULE_SKW_RIGHTSHIFT_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 125) ) { return ; }
            // InternalPreprocessLexer.g:357:39: ( RULE_SKW_GREATER RULE_SKW_GREATER )
            // InternalPreprocessLexer.g:357:41: RULE_SKW_GREATER RULE_SKW_GREATER
            {
            mRULE_SKW_GREATER(); if (state.failed) return ;
            mRULE_SKW_GREATER(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 125, FRAGMENT_RULE_SKW_RIGHTSHIFT_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_RIGHTSHIFT"

    // $ANTLR start "RULE_SKW_SEMI"
    public final void mRULE_SKW_SEMI() throws RecognitionException {
        int RULE_SKW_SEMI_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 126) ) { return ; }
            // InternalPreprocessLexer.g:359:24: ( FRAGMENT_RULE_SKW_SEMI )
            // InternalPreprocessLexer.g:359:26: FRAGMENT_RULE_SKW_SEMI
            {
            mFRAGMENT_RULE_SKW_SEMI(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 126, RULE_SKW_SEMI_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_SEMI"

    // $ANTLR start "FRAGMENT_RULE_SKW_SEMI"
    public final void mFRAGMENT_RULE_SKW_SEMI() throws RecognitionException {
        int FRAGMENT_RULE_SKW_SEMI_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 127) ) { return ; }
            // InternalPreprocessLexer.g:360:33: ( ';' )
            // InternalPreprocessLexer.g:360:35: ';'
            {
            match(';'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 127, FRAGMENT_RULE_SKW_SEMI_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_SEMI"

    // $ANTLR start "RULE_SKW_SINGLEQUOTE"
    public final void mRULE_SKW_SINGLEQUOTE() throws RecognitionException {
        int RULE_SKW_SINGLEQUOTE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 128) ) { return ; }
            // InternalPreprocessLexer.g:362:31: ( FRAGMENT_RULE_SKW_SINGLEQUOTE )
            // InternalPreprocessLexer.g:362:33: FRAGMENT_RULE_SKW_SINGLEQUOTE
            {
            mFRAGMENT_RULE_SKW_SINGLEQUOTE(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 128, RULE_SKW_SINGLEQUOTE_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_SINGLEQUOTE"

    // $ANTLR start "FRAGMENT_RULE_SKW_SINGLEQUOTE"
    public final void mFRAGMENT_RULE_SKW_SINGLEQUOTE() throws RecognitionException {
        int FRAGMENT_RULE_SKW_SINGLEQUOTE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 129) ) { return ; }
            // InternalPreprocessLexer.g:363:40: ( '\\'' )
            // InternalPreprocessLexer.g:363:42: '\\''
            {
            match('\''); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 129, FRAGMENT_RULE_SKW_SINGLEQUOTE_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_SINGLEQUOTE"

    // $ANTLR start "RULE_SKW_STAR"
    public final void mRULE_SKW_STAR() throws RecognitionException {
        int RULE_SKW_STAR_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 130) ) { return ; }
            // InternalPreprocessLexer.g:365:24: ( FRAGMENT_RULE_SKW_STAR )
            // InternalPreprocessLexer.g:365:26: FRAGMENT_RULE_SKW_STAR
            {
            mFRAGMENT_RULE_SKW_STAR(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 130, RULE_SKW_STAR_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_STAR"

    // $ANTLR start "FRAGMENT_RULE_SKW_STAR"
    public final void mFRAGMENT_RULE_SKW_STAR() throws RecognitionException {
        int FRAGMENT_RULE_SKW_STAR_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 131) ) { return ; }
            // InternalPreprocessLexer.g:366:33: ( '*' )
            // InternalPreprocessLexer.g:366:35: '*'
            {
            match('*'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 131, FRAGMENT_RULE_SKW_STAR_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_STAR"

    // $ANTLR start "RULE_SKW_TILDE"
    public final void mRULE_SKW_TILDE() throws RecognitionException {
        int RULE_SKW_TILDE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 132) ) { return ; }
            // InternalPreprocessLexer.g:368:25: ( FRAGMENT_RULE_SKW_TILDE )
            // InternalPreprocessLexer.g:368:27: FRAGMENT_RULE_SKW_TILDE
            {
            mFRAGMENT_RULE_SKW_TILDE(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 132, RULE_SKW_TILDE_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_TILDE"

    // $ANTLR start "FRAGMENT_RULE_SKW_TILDE"
    public final void mFRAGMENT_RULE_SKW_TILDE() throws RecognitionException {
        int FRAGMENT_RULE_SKW_TILDE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 133) ) { return ; }
            // InternalPreprocessLexer.g:369:34: ( '~' )
            // InternalPreprocessLexer.g:369:36: '~'
            {
            match('~'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 133, FRAGMENT_RULE_SKW_TILDE_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SKW_TILDE"

    // $ANTLR start "RULE_SKW_UNDERSCORE"
    public final void mRULE_SKW_UNDERSCORE() throws RecognitionException {
        int RULE_SKW_UNDERSCORE_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 134) ) { return ; }
            // InternalPreprocessLexer.g:371:30: ( '_' )
            // InternalPreprocessLexer.g:371:32: '_'
            {
            match('_'); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 134, RULE_SKW_UNDERSCORE_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SKW_UNDERSCORE"

    // $ANTLR start "RULE_SPECIAL"
    public final void mRULE_SPECIAL() throws RecognitionException {
        int RULE_SPECIAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 135) ) { return ; }
            // InternalPreprocessLexer.g:373:23: ( FRAGMENT_RULE_SPECIAL )
            // InternalPreprocessLexer.g:373:25: FRAGMENT_RULE_SPECIAL
            {
            mFRAGMENT_RULE_SPECIAL(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 135, RULE_SPECIAL_StartIndex); }
        }
    }
    // $ANTLR end "RULE_SPECIAL"

    // $ANTLR start "FRAGMENT_RULE_SPECIAL"
    public final void mFRAGMENT_RULE_SPECIAL() throws RecognitionException {
        int FRAGMENT_RULE_SPECIAL_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 136) ) { return ; }
            // InternalPreprocessLexer.g:374:32: ( . )
            // InternalPreprocessLexer.g:374:34: .
            {
            matchAny(); if (state.failed) return ;

            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 136, FRAGMENT_RULE_SPECIAL_StartIndex); }
        }
    }
    // $ANTLR end "FRAGMENT_RULE_SPECIAL"

    public void mTokens() throws RecognitionException {
        // InternalPreprocessLexer.g:1:8: ( SYNTHETIC_ALL_KEYWORDS )
        // InternalPreprocessLexer.g:1:10: SYNTHETIC_ALL_KEYWORDS
        {
        mSYNTHETIC_ALL_KEYWORDS(); if (state.failed) return ;

        }


    }

    // $ANTLR start synpred1_InternalPreprocessLexer
    public final void synpred1_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:102:2: ( FRAGMENT_RULE_HASH )
        // InternalPreprocessLexer.g:102:3: FRAGMENT_RULE_HASH
        {
        mFRAGMENT_RULE_HASH(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalPreprocessLexer

    // $ANTLR start synpred2_InternalPreprocessLexer
    public final void synpred2_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:103:2: ( FRAGMENT_RULE_INCLUDE )
        // InternalPreprocessLexer.g:103:3: FRAGMENT_RULE_INCLUDE
        {
        mFRAGMENT_RULE_INCLUDE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_InternalPreprocessLexer

    // $ANTLR start synpred3_InternalPreprocessLexer
    public final void synpred3_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:104:2: ( FRAGMENT_RULE_DEFINE )
        // InternalPreprocessLexer.g:104:3: FRAGMENT_RULE_DEFINE
        {
        mFRAGMENT_RULE_DEFINE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_InternalPreprocessLexer

    // $ANTLR start synpred4_InternalPreprocessLexer
    public final void synpred4_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:105:2: ( FRAGMENT_RULE_ERROR )
        // InternalPreprocessLexer.g:105:3: FRAGMENT_RULE_ERROR
        {
        mFRAGMENT_RULE_ERROR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_InternalPreprocessLexer

    // $ANTLR start synpred5_InternalPreprocessLexer
    public final void synpred5_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:106:2: ( FRAGMENT_RULE_UNDEF )
        // InternalPreprocessLexer.g:106:3: FRAGMENT_RULE_UNDEF
        {
        mFRAGMENT_RULE_UNDEF(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_InternalPreprocessLexer

    // $ANTLR start synpred6_InternalPreprocessLexer
    public final void synpred6_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:107:2: ( FRAGMENT_RULE_IF )
        // InternalPreprocessLexer.g:107:3: FRAGMENT_RULE_IF
        {
        mFRAGMENT_RULE_IF(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_InternalPreprocessLexer

    // $ANTLR start synpred7_InternalPreprocessLexer
    public final void synpred7_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:108:2: ( FRAGMENT_RULE_DEFINED )
        // InternalPreprocessLexer.g:108:3: FRAGMENT_RULE_DEFINED
        {
        mFRAGMENT_RULE_DEFINED(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_InternalPreprocessLexer

    // $ANTLR start synpred8_InternalPreprocessLexer
    public final void synpred8_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:109:2: ( FRAGMENT_RULE_IFDEF )
        // InternalPreprocessLexer.g:109:3: FRAGMENT_RULE_IFDEF
        {
        mFRAGMENT_RULE_IFDEF(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_InternalPreprocessLexer

    // $ANTLR start synpred9_InternalPreprocessLexer
    public final void synpred9_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:110:2: ( FRAGMENT_RULE_IFNOTDEF )
        // InternalPreprocessLexer.g:110:3: FRAGMENT_RULE_IFNOTDEF
        {
        mFRAGMENT_RULE_IFNOTDEF(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_InternalPreprocessLexer

    // $ANTLR start synpred10_InternalPreprocessLexer
    public final void synpred10_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:111:2: ( FRAGMENT_RULE_ENDIF )
        // InternalPreprocessLexer.g:111:3: FRAGMENT_RULE_ENDIF
        {
        mFRAGMENT_RULE_ENDIF(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_InternalPreprocessLexer

    // $ANTLR start synpred11_InternalPreprocessLexer
    public final void synpred11_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:112:2: ( FRAGMENT_RULE_PRAGMA )
        // InternalPreprocessLexer.g:112:3: FRAGMENT_RULE_PRAGMA
        {
        mFRAGMENT_RULE_PRAGMA(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_InternalPreprocessLexer

    // $ANTLR start synpred12_InternalPreprocessLexer
    public final void synpred12_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:113:2: ( FRAGMENT_RULE_NEWLINE )
        // InternalPreprocessLexer.g:113:3: FRAGMENT_RULE_NEWLINE
        {
        mFRAGMENT_RULE_NEWLINE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_InternalPreprocessLexer

    // $ANTLR start synpred13_InternalPreprocessLexer
    public final void synpred13_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:114:2: ( FRAGMENT_RULE_WS )
        // InternalPreprocessLexer.g:114:3: FRAGMENT_RULE_WS
        {
        mFRAGMENT_RULE_WS(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_InternalPreprocessLexer

    // $ANTLR start synpred14_InternalPreprocessLexer
    public final void synpred14_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:115:2: ( FRAGMENT_RULE_ID )
        // InternalPreprocessLexer.g:115:3: FRAGMENT_RULE_ID
        {
        mFRAGMENT_RULE_ID(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_InternalPreprocessLexer

    // $ANTLR start synpred15_InternalPreprocessLexer
    public final void synpred15_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:116:2: ( FRAGMENT_RULE_CHAR_LITERAL )
        // InternalPreprocessLexer.g:116:3: FRAGMENT_RULE_CHAR_LITERAL
        {
        mFRAGMENT_RULE_CHAR_LITERAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_InternalPreprocessLexer

    // $ANTLR start synpred16_InternalPreprocessLexer
    public final void synpred16_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:117:2: ( FRAGMENT_RULE_STRING_LITERAL )
        // InternalPreprocessLexer.g:117:3: FRAGMENT_RULE_STRING_LITERAL
        {
        mFRAGMENT_RULE_STRING_LITERAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_InternalPreprocessLexer

    // $ANTLR start synpred17_InternalPreprocessLexer
    public final void synpred17_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:118:2: ( FRAGMENT_RULE_HEX_LITERAL )
        // InternalPreprocessLexer.g:118:3: FRAGMENT_RULE_HEX_LITERAL
        {
        mFRAGMENT_RULE_HEX_LITERAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_InternalPreprocessLexer

    // $ANTLR start synpred18_InternalPreprocessLexer
    public final void synpred18_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:119:2: ( FRAGMENT_RULE_DECIMAL_LITERAL )
        // InternalPreprocessLexer.g:119:3: FRAGMENT_RULE_DECIMAL_LITERAL
        {
        mFRAGMENT_RULE_DECIMAL_LITERAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_InternalPreprocessLexer

    // $ANTLR start synpred19_InternalPreprocessLexer
    public final void synpred19_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:120:2: ( FRAGMENT_RULE_OCTAL_LITERAL )
        // InternalPreprocessLexer.g:120:3: FRAGMENT_RULE_OCTAL_LITERAL
        {
        mFRAGMENT_RULE_OCTAL_LITERAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_InternalPreprocessLexer

    // $ANTLR start synpred20_InternalPreprocessLexer
    public final void synpred20_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:121:2: ( FRAGMENT_RULE_BIN_LITERAL )
        // InternalPreprocessLexer.g:121:3: FRAGMENT_RULE_BIN_LITERAL
        {
        mFRAGMENT_RULE_BIN_LITERAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_InternalPreprocessLexer

    // $ANTLR start synpred21_InternalPreprocessLexer
    public final void synpred21_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:122:2: ( FRAGMENT_RULE_FLOAT_LITERAL )
        // InternalPreprocessLexer.g:122:3: FRAGMENT_RULE_FLOAT_LITERAL
        {
        mFRAGMENT_RULE_FLOAT_LITERAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_InternalPreprocessLexer

    // $ANTLR start synpred22_InternalPreprocessLexer
    public final void synpred22_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:123:2: ( FRAGMENT_RULE_SKW_AND )
        // InternalPreprocessLexer.g:123:3: FRAGMENT_RULE_SKW_AND
        {
        mFRAGMENT_RULE_SKW_AND(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_InternalPreprocessLexer

    // $ANTLR start synpred23_InternalPreprocessLexer
    public final void synpred23_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:124:2: ( FRAGMENT_RULE_SKW_ANDAND )
        // InternalPreprocessLexer.g:124:3: FRAGMENT_RULE_SKW_ANDAND
        {
        mFRAGMENT_RULE_SKW_ANDAND(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_InternalPreprocessLexer

    // $ANTLR start synpred24_InternalPreprocessLexer
    public final void synpred24_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:125:2: ( FRAGMENT_RULE_SKW_ASSIGN )
        // InternalPreprocessLexer.g:125:3: FRAGMENT_RULE_SKW_ASSIGN
        {
        mFRAGMENT_RULE_SKW_ASSIGN(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_InternalPreprocessLexer

    // $ANTLR start synpred25_InternalPreprocessLexer
    public final void synpred25_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:126:2: ( FRAGMENT_RULE_SKW_BACKSLASH )
        // InternalPreprocessLexer.g:126:3: FRAGMENT_RULE_SKW_BACKSLASH
        {
        mFRAGMENT_RULE_SKW_BACKSLASH(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_InternalPreprocessLexer

    // $ANTLR start synpred26_InternalPreprocessLexer
    public final void synpred26_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:127:2: ( FRAGMENT_RULE_SKW_CARET )
        // InternalPreprocessLexer.g:127:3: FRAGMENT_RULE_SKW_CARET
        {
        mFRAGMENT_RULE_SKW_CARET(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_InternalPreprocessLexer

    // $ANTLR start synpred27_InternalPreprocessLexer
    public final void synpred27_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:128:2: ( FRAGMENT_RULE_SKW_COMMA )
        // InternalPreprocessLexer.g:128:3: FRAGMENT_RULE_SKW_COMMA
        {
        mFRAGMENT_RULE_SKW_COMMA(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_InternalPreprocessLexer

    // $ANTLR start synpred28_InternalPreprocessLexer
    public final void synpred28_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:129:2: ( FRAGMENT_RULE_SKW_COLON )
        // InternalPreprocessLexer.g:129:3: FRAGMENT_RULE_SKW_COLON
        {
        mFRAGMENT_RULE_SKW_COLON(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_InternalPreprocessLexer

    // $ANTLR start synpred29_InternalPreprocessLexer
    public final void synpred29_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:130:2: ( FRAGMENT_RULE_SKW_DIV )
        // InternalPreprocessLexer.g:130:3: FRAGMENT_RULE_SKW_DIV
        {
        mFRAGMENT_RULE_SKW_DIV(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_InternalPreprocessLexer

    // $ANTLR start synpred30_InternalPreprocessLexer
    public final void synpred30_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:131:2: ( FRAGMENT_RULE_SKW_DOT )
        // InternalPreprocessLexer.g:131:3: FRAGMENT_RULE_SKW_DOT
        {
        mFRAGMENT_RULE_SKW_DOT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_InternalPreprocessLexer

    // $ANTLR start synpred31_InternalPreprocessLexer
    public final void synpred31_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:132:2: ( FRAGMENT_RULE_SKW_DOUBLEQUOTE )
        // InternalPreprocessLexer.g:132:3: FRAGMENT_RULE_SKW_DOUBLEQUOTE
        {
        mFRAGMENT_RULE_SKW_DOUBLEQUOTE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_InternalPreprocessLexer

    // $ANTLR start synpred32_InternalPreprocessLexer
    public final void synpred32_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:133:2: ( FRAGMENT_RULE_SKW_EQUAL )
        // InternalPreprocessLexer.g:133:3: FRAGMENT_RULE_SKW_EQUAL
        {
        mFRAGMENT_RULE_SKW_EQUAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_InternalPreprocessLexer

    // $ANTLR start synpred33_InternalPreprocessLexer
    public final void synpred33_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:134:2: ( FRAGMENT_RULE_SKW_GREATER )
        // InternalPreprocessLexer.g:134:3: FRAGMENT_RULE_SKW_GREATER
        {
        mFRAGMENT_RULE_SKW_GREATER(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_InternalPreprocessLexer

    // $ANTLR start synpred34_InternalPreprocessLexer
    public final void synpred34_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:135:2: ( FRAGMENT_RULE_SKW_GREATEREQUAL )
        // InternalPreprocessLexer.g:135:3: FRAGMENT_RULE_SKW_GREATEREQUAL
        {
        mFRAGMENT_RULE_SKW_GREATEREQUAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_InternalPreprocessLexer

    // $ANTLR start synpred35_InternalPreprocessLexer
    public final void synpred35_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:136:2: ( FRAGMENT_RULE_SKW_LEFTBRACE )
        // InternalPreprocessLexer.g:136:3: FRAGMENT_RULE_SKW_LEFTBRACE
        {
        mFRAGMENT_RULE_SKW_LEFTBRACE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_InternalPreprocessLexer

    // $ANTLR start synpred36_InternalPreprocessLexer
    public final void synpred36_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:137:2: ( FRAGMENT_RULE_SKW_LEFTBRACKET )
        // InternalPreprocessLexer.g:137:3: FRAGMENT_RULE_SKW_LEFTBRACKET
        {
        mFRAGMENT_RULE_SKW_LEFTBRACKET(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred36_InternalPreprocessLexer

    // $ANTLR start synpred37_InternalPreprocessLexer
    public final void synpred37_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:138:2: ( FRAGMENT_RULE_SKW_LEFTPAREN )
        // InternalPreprocessLexer.g:138:3: FRAGMENT_RULE_SKW_LEFTPAREN
        {
        mFRAGMENT_RULE_SKW_LEFTPAREN(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_InternalPreprocessLexer

    // $ANTLR start synpred38_InternalPreprocessLexer
    public final void synpred38_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:139:2: ( FRAGMENT_RULE_SKW_LEFTSHIFT )
        // InternalPreprocessLexer.g:139:3: FRAGMENT_RULE_SKW_LEFTSHIFT
        {
        mFRAGMENT_RULE_SKW_LEFTSHIFT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_InternalPreprocessLexer

    // $ANTLR start synpred39_InternalPreprocessLexer
    public final void synpred39_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:140:2: ( FRAGMENT_RULE_SKW_LESS )
        // InternalPreprocessLexer.g:140:3: FRAGMENT_RULE_SKW_LESS
        {
        mFRAGMENT_RULE_SKW_LESS(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_InternalPreprocessLexer

    // $ANTLR start synpred40_InternalPreprocessLexer
    public final void synpred40_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:141:2: ( FRAGMENT_RULE_SKW_LESSEQUAL )
        // InternalPreprocessLexer.g:141:3: FRAGMENT_RULE_SKW_LESSEQUAL
        {
        mFRAGMENT_RULE_SKW_LESSEQUAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred40_InternalPreprocessLexer

    // $ANTLR start synpred41_InternalPreprocessLexer
    public final void synpred41_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:142:2: ( FRAGMENT_RULE_SKW_MINUS )
        // InternalPreprocessLexer.g:142:3: FRAGMENT_RULE_SKW_MINUS
        {
        mFRAGMENT_RULE_SKW_MINUS(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred41_InternalPreprocessLexer

    // $ANTLR start synpred42_InternalPreprocessLexer
    public final void synpred42_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:143:2: ( FRAGMENT_RULE_SKW_MINUSMINUS )
        // InternalPreprocessLexer.g:143:3: FRAGMENT_RULE_SKW_MINUSMINUS
        {
        mFRAGMENT_RULE_SKW_MINUSMINUS(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_InternalPreprocessLexer

    // $ANTLR start synpred43_InternalPreprocessLexer
    public final void synpred43_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:144:2: ( FRAGMENT_RULE_SKW_MOD )
        // InternalPreprocessLexer.g:144:3: FRAGMENT_RULE_SKW_MOD
        {
        mFRAGMENT_RULE_SKW_MOD(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_InternalPreprocessLexer

    // $ANTLR start synpred44_InternalPreprocessLexer
    public final void synpred44_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:145:2: ( FRAGMENT_RULE_SKW_NOT )
        // InternalPreprocessLexer.g:145:3: FRAGMENT_RULE_SKW_NOT
        {
        mFRAGMENT_RULE_SKW_NOT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_InternalPreprocessLexer

    // $ANTLR start synpred45_InternalPreprocessLexer
    public final void synpred45_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:146:2: ( FRAGMENT_RULE_SKW_NOTEQUAL )
        // InternalPreprocessLexer.g:146:3: FRAGMENT_RULE_SKW_NOTEQUAL
        {
        mFRAGMENT_RULE_SKW_NOTEQUAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_InternalPreprocessLexer

    // $ANTLR start synpred46_InternalPreprocessLexer
    public final void synpred46_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:147:2: ( FRAGMENT_RULE_SKW_OR )
        // InternalPreprocessLexer.g:147:3: FRAGMENT_RULE_SKW_OR
        {
        mFRAGMENT_RULE_SKW_OR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_InternalPreprocessLexer

    // $ANTLR start synpred47_InternalPreprocessLexer
    public final void synpred47_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:148:2: ( FRAGMENT_RULE_SKW_OROR )
        // InternalPreprocessLexer.g:148:3: FRAGMENT_RULE_SKW_OROR
        {
        mFRAGMENT_RULE_SKW_OROR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_InternalPreprocessLexer

    // $ANTLR start synpred48_InternalPreprocessLexer
    public final void synpred48_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:149:2: ( FRAGMENT_RULE_SKW_PLUS )
        // InternalPreprocessLexer.g:149:3: FRAGMENT_RULE_SKW_PLUS
        {
        mFRAGMENT_RULE_SKW_PLUS(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_InternalPreprocessLexer

    // $ANTLR start synpred49_InternalPreprocessLexer
    public final void synpred49_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:150:2: ( FRAGMENT_RULE_SKW_PLUSPLUS )
        // InternalPreprocessLexer.g:150:3: FRAGMENT_RULE_SKW_PLUSPLUS
        {
        mFRAGMENT_RULE_SKW_PLUSPLUS(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_InternalPreprocessLexer

    // $ANTLR start synpred50_InternalPreprocessLexer
    public final void synpred50_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:151:2: ( FRAGMENT_RULE_SKW_QUESTION )
        // InternalPreprocessLexer.g:151:3: FRAGMENT_RULE_SKW_QUESTION
        {
        mFRAGMENT_RULE_SKW_QUESTION(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_InternalPreprocessLexer

    // $ANTLR start synpred51_InternalPreprocessLexer
    public final void synpred51_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:152:2: ( FRAGMENT_RULE_SKW_RIGHTBRACE )
        // InternalPreprocessLexer.g:152:3: FRAGMENT_RULE_SKW_RIGHTBRACE
        {
        mFRAGMENT_RULE_SKW_RIGHTBRACE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred51_InternalPreprocessLexer

    // $ANTLR start synpred52_InternalPreprocessLexer
    public final void synpred52_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:153:2: ( FRAGMENT_RULE_SKW_RIGHTBRACKET )
        // InternalPreprocessLexer.g:153:3: FRAGMENT_RULE_SKW_RIGHTBRACKET
        {
        mFRAGMENT_RULE_SKW_RIGHTBRACKET(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred52_InternalPreprocessLexer

    // $ANTLR start synpred53_InternalPreprocessLexer
    public final void synpred53_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:154:2: ( FRAGMENT_RULE_SKW_RIGHTPAREN )
        // InternalPreprocessLexer.g:154:3: FRAGMENT_RULE_SKW_RIGHTPAREN
        {
        mFRAGMENT_RULE_SKW_RIGHTPAREN(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_InternalPreprocessLexer

    // $ANTLR start synpred54_InternalPreprocessLexer
    public final void synpred54_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:155:2: ( FRAGMENT_RULE_SKW_RIGHTSHIFT )
        // InternalPreprocessLexer.g:155:3: FRAGMENT_RULE_SKW_RIGHTSHIFT
        {
        mFRAGMENT_RULE_SKW_RIGHTSHIFT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_InternalPreprocessLexer

    // $ANTLR start synpred55_InternalPreprocessLexer
    public final void synpred55_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:156:2: ( FRAGMENT_RULE_SKW_SEMI )
        // InternalPreprocessLexer.g:156:3: FRAGMENT_RULE_SKW_SEMI
        {
        mFRAGMENT_RULE_SKW_SEMI(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred55_InternalPreprocessLexer

    // $ANTLR start synpred56_InternalPreprocessLexer
    public final void synpred56_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:157:2: ( FRAGMENT_RULE_SKW_SINGLEQUOTE )
        // InternalPreprocessLexer.g:157:3: FRAGMENT_RULE_SKW_SINGLEQUOTE
        {
        mFRAGMENT_RULE_SKW_SINGLEQUOTE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_InternalPreprocessLexer

    // $ANTLR start synpred57_InternalPreprocessLexer
    public final void synpred57_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:158:2: ( FRAGMENT_RULE_SKW_STAR )
        // InternalPreprocessLexer.g:158:3: FRAGMENT_RULE_SKW_STAR
        {
        mFRAGMENT_RULE_SKW_STAR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred57_InternalPreprocessLexer

    // $ANTLR start synpred58_InternalPreprocessLexer
    public final void synpred58_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:159:2: ( FRAGMENT_RULE_SKW_TILDE )
        // InternalPreprocessLexer.g:159:3: FRAGMENT_RULE_SKW_TILDE
        {
        mFRAGMENT_RULE_SKW_TILDE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred58_InternalPreprocessLexer

    // $ANTLR start synpred59_InternalPreprocessLexer
    public final void synpred59_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:160:2: ( FRAGMENT_RULE_SPECIAL )
        // InternalPreprocessLexer.g:160:3: FRAGMENT_RULE_SPECIAL
        {
        mFRAGMENT_RULE_SPECIAL(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred59_InternalPreprocessLexer

    // $ANTLR start synpred90_InternalPreprocessLexer
    public final void synpred90_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:241:38: ( ( 'u' | 'U' )? ( 'l' | 'L' ) )
        // InternalPreprocessLexer.g:241:38: ( 'u' | 'U' )? ( 'l' | 'L' )
        {
        // InternalPreprocessLexer.g:241:38: ( 'u' | 'U' )?
        int alt36=2;
        int LA36_0 = input.LA(1);

        if ( (LA36_0=='U'||LA36_0=='u') ) {
            alt36=1;
        }
        switch (alt36) {
            case 1 :
                // InternalPreprocessLexer.g:
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
    // $ANTLR end synpred90_InternalPreprocessLexer

    // $ANTLR start synpred105_InternalPreprocessLexer
    public final void synpred105_InternalPreprocessLexer_fragment() throws RecognitionException {   
        // InternalPreprocessLexer.g:244:181: ( ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? )
        // InternalPreprocessLexer.g:244:181: ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )?
        {
        // InternalPreprocessLexer.g:244:181: ( '0' .. '9' )+
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
        	    // InternalPreprocessLexer.g:244:182: '0' .. '9'
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
        // InternalPreprocessLexer.g:244:207: ( RULE_FLOAT_TYPE_SUFFIX )?
        int alt45=2;
        int LA45_0 = input.LA(1);

        if ( (LA45_0=='D'||LA45_0=='F'||LA45_0=='d'||LA45_0=='f') ) {
            alt45=1;
        }
        switch (alt45) {
            case 1 :
                // InternalPreprocessLexer.g:0:0: RULE_FLOAT_TYPE_SUFFIX
                {
                mRULE_FLOAT_TYPE_SUFFIX(); if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred105_InternalPreprocessLexer

    public final boolean synpred14_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred53_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred57_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred56_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred59_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred59_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred90_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred90_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred105_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred105_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred41_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred41_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred52_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred50_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred51_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred51_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred48_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred47_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_InternalPreprocessLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred58_InternalPreprocessLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred58_InternalPreprocessLexer_fragment(); // can never throw exception
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
        "\53\uffff\1\155\27\uffff\1\161\60\uffff\1\166\2\uffff";
    static final String DFA1_eofS =
        "\167\uffff";
    static final String DFA1_minS =
        "\2\0\1\146\1\145\2\156\1\162\3\0\1\52\1\12\3\0\2\56\1\60\1\46\1\75\3\0\1\75\3\0\1\74\1\55\1\0\1\75\1\174\1\53\7\0\3\uffff\1\144\1\uffff\1\146\25\uffff\1\56\52\uffff\1\151\3\uffff\1\156\1\145\1\144\2\uffff";
    static final String DFA1_maxS =
        "\1\uffff\1\0\1\156\1\145\1\162\1\156\1\162\3\0\1\57\1\15\1\0\2\uffff\1\170\1\146\1\71\1\46\1\75\3\0\1\76\3\0\1\75\1\55\1\0\1\75\1\174\1\53\7\0\3\uffff\1\156\1\uffff\1\146\25\uffff\1\165\52\uffff\1\151\3\uffff\1\156\1\145\1\144\2\uffff";
    static final String DFA1_acceptS =
        "\50\uffff\1\73\1\1\1\2\1\uffff\1\16\1\uffff\1\4\1\12\1\5\1\13\1\14\3\15\1\35\1\15\1\31\2\17\1\70\3\20\1\37\1\21\2\24\1\uffff\4\25\1\22\1\25\1\36\1\27\1\26\1\40\1\30\1\32\1\33\1\34\1\66\1\42\1\41\1\43\1\44\1\45\1\46\1\50\1\47\1\52\1\51\1\53\1\55\1\54\1\57\1\56\1\61\1\60\1\62\1\63\1\64\1\65\1\67\1\71\1\72\1\10\1\11\1\6\1\uffff\3\23\3\uffff\1\7\1\3";
    static final String DFA1_specialS =
        "\1\3\1\2\1\41\1\6\1\1\1\42\1\30\1\0\1\32\1\33\1\40\1\15\1\36\1\44\1\24\1\50\1\47\1\35\1\22\1\4\1\14\1\10\1\51\1\5\1\17\1\20\1\31\1\52\1\16\1\11\1\45\1\23\1\37\1\12\1\13\1\7\1\27\1\34\1\46\1\43\3\uffff\1\21\27\uffff\1\26\60\uffff\1\25\2\uffff}>";
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
            "\1\107\1\uffff\10\103\2\105\10\uffff\1\102\1\uffff\1\106\1\104\1\106\21\uffff\1\100\11\uffff\1\101\1\uffff\1\106\1\104\1\106\21\uffff\1\100",
            "\1\107\1\uffff\12\105\12\uffff\1\106\1\104\1\106\35\uffff\1\106\1\104\1\106",
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
            "\1\156",
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
            "\1\107\1\uffff\10\103\2\105\12\uffff\1\106\1\104\1\106\5\uffff\1\160\10\uffff\1\157\16\uffff\1\106\1\104\1\106\5\uffff\1\160\10\uffff\1\157",
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
            "\1\162",
            "",
            "",
            "",
            "\1\163",
            "\1\164",
            "\1\165",
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
            return "101:1: SYNTHETIC_ALL_KEYWORDS : ( ( FRAGMENT_RULE_HASH )=> FRAGMENT_RULE_HASH | ( FRAGMENT_RULE_INCLUDE )=> FRAGMENT_RULE_INCLUDE | ( FRAGMENT_RULE_DEFINE )=> FRAGMENT_RULE_DEFINE | ( FRAGMENT_RULE_ERROR )=> FRAGMENT_RULE_ERROR | ( FRAGMENT_RULE_UNDEF )=> FRAGMENT_RULE_UNDEF | ( FRAGMENT_RULE_IF )=> FRAGMENT_RULE_IF | ( FRAGMENT_RULE_DEFINED )=> FRAGMENT_RULE_DEFINED | ( FRAGMENT_RULE_IFDEF )=> FRAGMENT_RULE_IFDEF | ( FRAGMENT_RULE_IFNOTDEF )=> FRAGMENT_RULE_IFNOTDEF | ( FRAGMENT_RULE_ENDIF )=> FRAGMENT_RULE_ENDIF | ( FRAGMENT_RULE_PRAGMA )=> FRAGMENT_RULE_PRAGMA | ( FRAGMENT_RULE_NEWLINE )=> FRAGMENT_RULE_NEWLINE | ( FRAGMENT_RULE_WS )=> FRAGMENT_RULE_WS | ( FRAGMENT_RULE_ID )=> FRAGMENT_RULE_ID | ( FRAGMENT_RULE_CHAR_LITERAL )=> FRAGMENT_RULE_CHAR_LITERAL | ( FRAGMENT_RULE_STRING_LITERAL )=> FRAGMENT_RULE_STRING_LITERAL | ( FRAGMENT_RULE_HEX_LITERAL )=> FRAGMENT_RULE_HEX_LITERAL | ( FRAGMENT_RULE_DECIMAL_LITERAL )=> FRAGMENT_RULE_DECIMAL_LITERAL | ( FRAGMENT_RULE_OCTAL_LITERAL )=> FRAGMENT_RULE_OCTAL_LITERAL | ( FRAGMENT_RULE_BIN_LITERAL )=> FRAGMENT_RULE_BIN_LITERAL | ( FRAGMENT_RULE_FLOAT_LITERAL )=> FRAGMENT_RULE_FLOAT_LITERAL | ( FRAGMENT_RULE_SKW_AND )=> FRAGMENT_RULE_SKW_AND | ( FRAGMENT_RULE_SKW_ANDAND )=> FRAGMENT_RULE_SKW_ANDAND | ( FRAGMENT_RULE_SKW_ASSIGN )=> FRAGMENT_RULE_SKW_ASSIGN | ( FRAGMENT_RULE_SKW_BACKSLASH )=> FRAGMENT_RULE_SKW_BACKSLASH | ( FRAGMENT_RULE_SKW_CARET )=> FRAGMENT_RULE_SKW_CARET | ( FRAGMENT_RULE_SKW_COMMA )=> FRAGMENT_RULE_SKW_COMMA | ( FRAGMENT_RULE_SKW_COLON )=> FRAGMENT_RULE_SKW_COLON | ( FRAGMENT_RULE_SKW_DIV )=> FRAGMENT_RULE_SKW_DIV | ( FRAGMENT_RULE_SKW_DOT )=> FRAGMENT_RULE_SKW_DOT | ( FRAGMENT_RULE_SKW_DOUBLEQUOTE )=> FRAGMENT_RULE_SKW_DOUBLEQUOTE | ( FRAGMENT_RULE_SKW_EQUAL )=> FRAGMENT_RULE_SKW_EQUAL | ( FRAGMENT_RULE_SKW_GREATER )=> FRAGMENT_RULE_SKW_GREATER | ( FRAGMENT_RULE_SKW_GREATEREQUAL )=> FRAGMENT_RULE_SKW_GREATEREQUAL | ( FRAGMENT_RULE_SKW_LEFTBRACE )=> FRAGMENT_RULE_SKW_LEFTBRACE | ( FRAGMENT_RULE_SKW_LEFTBRACKET )=> FRAGMENT_RULE_SKW_LEFTBRACKET | ( FRAGMENT_RULE_SKW_LEFTPAREN )=> FRAGMENT_RULE_SKW_LEFTPAREN | ( FRAGMENT_RULE_SKW_LEFTSHIFT )=> FRAGMENT_RULE_SKW_LEFTSHIFT | ( FRAGMENT_RULE_SKW_LESS )=> FRAGMENT_RULE_SKW_LESS | ( FRAGMENT_RULE_SKW_LESSEQUAL )=> FRAGMENT_RULE_SKW_LESSEQUAL | ( FRAGMENT_RULE_SKW_MINUS )=> FRAGMENT_RULE_SKW_MINUS | ( FRAGMENT_RULE_SKW_MINUSMINUS )=> FRAGMENT_RULE_SKW_MINUSMINUS | ( FRAGMENT_RULE_SKW_MOD )=> FRAGMENT_RULE_SKW_MOD | ( FRAGMENT_RULE_SKW_NOT )=> FRAGMENT_RULE_SKW_NOT | ( FRAGMENT_RULE_SKW_NOTEQUAL )=> FRAGMENT_RULE_SKW_NOTEQUAL | ( FRAGMENT_RULE_SKW_OR )=> FRAGMENT_RULE_SKW_OR | ( FRAGMENT_RULE_SKW_OROR )=> FRAGMENT_RULE_SKW_OROR | ( FRAGMENT_RULE_SKW_PLUS )=> FRAGMENT_RULE_SKW_PLUS | ( FRAGMENT_RULE_SKW_PLUSPLUS )=> FRAGMENT_RULE_SKW_PLUSPLUS | ( FRAGMENT_RULE_SKW_QUESTION )=> FRAGMENT_RULE_SKW_QUESTION | ( FRAGMENT_RULE_SKW_RIGHTBRACE )=> FRAGMENT_RULE_SKW_RIGHTBRACE | ( FRAGMENT_RULE_SKW_RIGHTBRACKET )=> FRAGMENT_RULE_SKW_RIGHTBRACKET | ( FRAGMENT_RULE_SKW_RIGHTPAREN )=> FRAGMENT_RULE_SKW_RIGHTPAREN | ( FRAGMENT_RULE_SKW_RIGHTSHIFT )=> FRAGMENT_RULE_SKW_RIGHTSHIFT | ( FRAGMENT_RULE_SKW_SEMI )=> FRAGMENT_RULE_SKW_SEMI | ( FRAGMENT_RULE_SKW_SINGLEQUOTE )=> FRAGMENT_RULE_SKW_SINGLEQUOTE | ( FRAGMENT_RULE_SKW_STAR )=> FRAGMENT_RULE_SKW_STAR | ( FRAGMENT_RULE_SKW_TILDE )=> FRAGMENT_RULE_SKW_TILDE | ( FRAGMENT_RULE_SPECIAL )=> FRAGMENT_RULE_SPECIAL );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA1_7 = input.LA(1);

                         
                        int index1_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalPreprocessLexer()) ) {s = 50;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_7);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA1_4 = input.LA(1);

                         
                        int index1_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_4=='r') && (synpred4_InternalPreprocessLexer())) {s = 46;}

                        else if ( (LA1_4=='n') && (synpred10_InternalPreprocessLexer())) {s = 47;}

                        else if ( (synpred14_InternalPreprocessLexer()) ) {s = 44;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA1_1 = input.LA(1);

                         
                        int index1_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalPreprocessLexer()) ) {s = 41;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_1);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
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

                        else if ( ((LA1_0>='\u0000' && LA1_0<='\b')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\u001F')||LA1_0=='@'||LA1_0=='`'||(LA1_0>='\u007F' && LA1_0<='\uFFFF')) && (synpred59_InternalPreprocessLexer())) {s = 40;}

                         
                        input.seek(index1_0);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA1_19 = input.LA(1);

                         
                        int index1_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_19=='=') && (synpred32_InternalPreprocessLexer())) {s = 77;}

                        else if ( (synpred24_InternalPreprocessLexer()) ) {s = 78;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_19);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA1_23 = input.LA(1);

                         
                        int index1_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_23=='>') && (synpred54_InternalPreprocessLexer())) {s = 82;}

                        else if ( (LA1_23=='=') && (synpred34_InternalPreprocessLexer())) {s = 83;}

                        else if ( (synpred33_InternalPreprocessLexer()) ) {s = 84;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_23);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA1_3 = input.LA(1);

                         
                        int index1_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_3=='e') ) {s = 45;}

                        else if ( (synpred14_InternalPreprocessLexer()) ) {s = 44;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_3);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA1_35 = input.LA(1);

                         
                        int index1_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_InternalPreprocessLexer()) ) {s = 102;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_35);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA1_21 = input.LA(1);

                         
                        int index1_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalPreprocessLexer()) ) {s = 80;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_21);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA1_29 = input.LA(1);

                         
                        int index1_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalPreprocessLexer()) ) {s = 93;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_29);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA1_33 = input.LA(1);

                         
                        int index1_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_InternalPreprocessLexer()) ) {s = 100;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_33);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA1_34 = input.LA(1);

                         
                        int index1_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_InternalPreprocessLexer()) ) {s = 101;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_34);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA1_20 = input.LA(1);

                         
                        int index1_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPreprocessLexer()) ) {s = 79;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_20);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA1_11 = input.LA(1);

                         
                        int index1_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_11=='\n'||LA1_11=='\r') && (synpred13_InternalPreprocessLexer())) {s = 55;}

                        else if ( (synpred25_InternalPreprocessLexer()) ) {s = 56;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_11);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA1_28 = input.LA(1);

                         
                        int index1_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_28=='-') && (synpred42_InternalPreprocessLexer())) {s = 91;}

                        else if ( (synpred41_InternalPreprocessLexer()) ) {s = 92;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_28);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA1_24 = input.LA(1);

                         
                        int index1_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalPreprocessLexer()) ) {s = 85;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_24);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA1_25 = input.LA(1);

                         
                        int index1_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalPreprocessLexer()) ) {s = 86;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_25);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA1_43 = input.LA(1);

                         
                        int index1_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_43=='d') && (synpred8_InternalPreprocessLexer())) {s = 107;}

                        else if ( (LA1_43=='n') && (synpred9_InternalPreprocessLexer())) {s = 108;}

                        else s = 109;

                         
                        input.seek(index1_43);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA1_18 = input.LA(1);

                         
                        int index1_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_18=='&') && (synpred23_InternalPreprocessLexer())) {s = 75;}

                        else if ( (synpred22_InternalPreprocessLexer()) ) {s = 76;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_18);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA1_31 = input.LA(1);

                         
                        int index1_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_31=='|') && (synpred47_InternalPreprocessLexer())) {s = 96;}

                        else if ( (synpred46_InternalPreprocessLexer()) ) {s = 97;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_31);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA1_14 = input.LA(1);

                         
                        int index1_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_14=='\\') && (synpred16_InternalPreprocessLexer())) {s = 60;}

                        else if ( ((LA1_14>='\u0000' && LA1_14<='!')||(LA1_14>='#' && LA1_14<='[')||(LA1_14>=']' && LA1_14<='\uFFFF')) && (synpred16_InternalPreprocessLexer())) {s = 61;}

                        else if ( (LA1_14=='\"') && (synpred16_InternalPreprocessLexer())) {s = 62;}

                        else if ( (synpred31_InternalPreprocessLexer()) ) {s = 63;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_14);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA1_116 = input.LA(1);

                         
                        int index1_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_116=='d') && (synpred7_InternalPreprocessLexer())) {s = 117;}

                        else s = 118;

                         
                        input.seek(index1_116);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA1_67 = input.LA(1);

                         
                        int index1_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_67=='E'||LA1_67=='e') && (synpred21_InternalPreprocessLexer())) {s = 68;}

                        else if ( ((LA1_67>='0' && LA1_67<='7')) ) {s = 67;}

                        else if ( (LA1_67=='D'||LA1_67=='F'||LA1_67=='d'||LA1_67=='f') && (synpred21_InternalPreprocessLexer())) {s = 70;}

                        else if ( (LA1_67=='U'||LA1_67=='u') && (synpred19_InternalPreprocessLexer())) {s = 111;}

                        else if ( (LA1_67=='L'||LA1_67=='l') && (synpred19_InternalPreprocessLexer())) {s = 112;}

                        else if ( ((LA1_67>='8' && LA1_67<='9')) && (synpred21_InternalPreprocessLexer())) {s = 69;}

                        else if ( (LA1_67=='.') && (synpred21_InternalPreprocessLexer())) {s = 71;}

                        else s = 113;

                         
                        input.seek(index1_67);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA1_36 = input.LA(1);

                         
                        int index1_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_InternalPreprocessLexer()) ) {s = 103;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_36);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA1_6 = input.LA(1);

                         
                        int index1_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_6=='r') && (synpred11_InternalPreprocessLexer())) {s = 49;}

                        else if ( (synpred14_InternalPreprocessLexer()) ) {s = 44;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_6);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA1_26 = input.LA(1);

                         
                        int index1_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalPreprocessLexer()) ) {s = 87;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_26);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA1_8 = input.LA(1);

                         
                        int index1_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalPreprocessLexer()) ) {s = 51;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_8);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA1_9 = input.LA(1);

                         
                        int index1_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalPreprocessLexer()) ) {s = 51;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_9);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA1_37 = input.LA(1);

                         
                        int index1_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred55_InternalPreprocessLexer()) ) {s = 104;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_37);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA1_17 = input.LA(1);

                         
                        int index1_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA1_17>='0' && LA1_17<='9')) && (synpred21_InternalPreprocessLexer())) {s = 73;}

                        else if ( (synpred30_InternalPreprocessLexer()) ) {s = 74;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_17);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA1_12 = input.LA(1);

                         
                        int index1_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalPreprocessLexer()) ) {s = 44;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_12);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA1_32 = input.LA(1);

                         
                        int index1_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_32=='+') && (synpred49_InternalPreprocessLexer())) {s = 98;}

                        else if ( (synpred48_InternalPreprocessLexer()) ) {s = 99;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_32);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA1_10 = input.LA(1);

                         
                        int index1_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_10=='/') && (synpred13_InternalPreprocessLexer())) {s = 52;}

                        else if ( (LA1_10=='*') && (synpred13_InternalPreprocessLexer())) {s = 53;}

                        else if ( (synpred29_InternalPreprocessLexer()) ) {s = 54;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_10);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA1_2 = input.LA(1);

                         
                        int index1_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_2=='n') && (synpred2_InternalPreprocessLexer())) {s = 42;}

                        else if ( (LA1_2=='f') ) {s = 43;}

                        else if ( (synpred14_InternalPreprocessLexer()) ) {s = 44;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_2);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA1_5 = input.LA(1);

                         
                        int index1_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_5=='n') && (synpred5_InternalPreprocessLexer())) {s = 48;}

                        else if ( (synpred14_InternalPreprocessLexer()) ) {s = 44;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_5);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA1_39 = input.LA(1);

                         
                        int index1_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred58_InternalPreprocessLexer()) ) {s = 106;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_39);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA1_13 = input.LA(1);

                         
                        int index1_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_13=='\\') && (synpred15_InternalPreprocessLexer())) {s = 57;}

                        else if ( ((LA1_13>='\u0000' && LA1_13<='&')||(LA1_13>='(' && LA1_13<='[')||(LA1_13>=']' && LA1_13<='\uFFFF')) && (synpred15_InternalPreprocessLexer())) {s = 58;}

                        else if ( (synpred56_InternalPreprocessLexer()) ) {s = 59;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_13);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA1_30 = input.LA(1);

                         
                        int index1_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_30=='=') && (synpred45_InternalPreprocessLexer())) {s = 94;}

                        else if ( (synpred44_InternalPreprocessLexer()) ) {s = 95;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_30);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA1_38 = input.LA(1);

                         
                        int index1_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalPreprocessLexer()) ) {s = 105;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_38);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA1_16 = input.LA(1);

                         
                        int index1_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_16=='E'||LA1_16=='e') && (synpred21_InternalPreprocessLexer())) {s = 68;}

                        else if ( ((LA1_16>='0' && LA1_16<='9')) && (synpred21_InternalPreprocessLexer())) {s = 69;}

                        else if ( (LA1_16=='D'||LA1_16=='F'||LA1_16=='d'||LA1_16=='f') && (synpred21_InternalPreprocessLexer())) {s = 70;}

                        else if ( (LA1_16=='.') && (synpred21_InternalPreprocessLexer())) {s = 71;}

                        else if ( (synpred18_InternalPreprocessLexer()) ) {s = 72;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_16);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA1_15 = input.LA(1);

                         
                        int index1_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_15=='X'||LA1_15=='x') && (synpred17_InternalPreprocessLexer())) {s = 64;}

                        else if ( (LA1_15=='b') && (synpred20_InternalPreprocessLexer())) {s = 65;}

                        else if ( (LA1_15=='B') && (synpred20_InternalPreprocessLexer())) {s = 66;}

                        else if ( ((LA1_15>='0' && LA1_15<='7')) ) {s = 67;}

                        else if ( (LA1_15=='E'||LA1_15=='e') && (synpred21_InternalPreprocessLexer())) {s = 68;}

                        else if ( ((LA1_15>='8' && LA1_15<='9')) && (synpred21_InternalPreprocessLexer())) {s = 69;}

                        else if ( (LA1_15=='D'||LA1_15=='F'||LA1_15=='d'||LA1_15=='f') && (synpred21_InternalPreprocessLexer())) {s = 70;}

                        else if ( (LA1_15=='.') && (synpred21_InternalPreprocessLexer())) {s = 71;}

                        else if ( (synpred18_InternalPreprocessLexer()) ) {s = 72;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_15);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA1_22 = input.LA(1);

                         
                        int index1_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_InternalPreprocessLexer()) ) {s = 81;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_22);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA1_27 = input.LA(1);

                         
                        int index1_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_27=='<') && (synpred38_InternalPreprocessLexer())) {s = 88;}

                        else if ( (LA1_27=='=') && (synpred40_InternalPreprocessLexer())) {s = 89;}

                        else if ( (synpred39_InternalPreprocessLexer()) ) {s = 90;}

                        else if ( (synpred59_InternalPreprocessLexer()) ) {s = 40;}

                         
                        input.seek(index1_27);
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
        "\2\56\1\uffff\1\53\2\uffff\2\60\1\uffff\1\0";
    static final String DFA29_maxS =
        "\1\71\1\146\1\uffff\1\71\2\uffff\1\71\1\146\1\uffff\1\0";
    static final String DFA29_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\1\1\2\uffff\1\3\1\uffff";
    static final String DFA29_specialS =
        "\11\uffff\1\0}>";
    static final String[] DFA29_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\5\1\uffff\12\1\12\uffff\1\4\1\3\1\4\35\uffff\1\4\1\3\1\4",
            "",
            "\1\6\1\uffff\1\6\2\uffff\12\7",
            "",
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
            return "244:40: ( ( '0' .. '9' )+ RULE_SKW_DOT ( '0' .. '9' )* ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | RULE_SKW_DOT ( '0' .. '9' )+ ( RULE_EXPONENT )? ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ RULE_EXPONENT ( RULE_FLOAT_TYPE_SUFFIX )? | ( '0' .. '9' )+ ( RULE_EXPONENT )? RULE_FLOAT_TYPE_SUFFIX )";
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
                        if ( (synpred105_InternalPreprocessLexer()) ) {s = 8;}

                        else if ( (true) ) {s = 4;}

                         
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