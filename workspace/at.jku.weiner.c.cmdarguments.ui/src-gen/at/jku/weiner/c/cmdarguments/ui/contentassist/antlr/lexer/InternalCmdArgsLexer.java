package at.jku.weiner.c.cmdarguments.ui.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCmdArgsLexer extends Lexer {
	public static final int EOF=-1;
	public static final int RULE_ANY_OTHER=4;
	public static final int RULE_DIGIT=5;
	public static final int RULE_ID=6;
	public static final int RULE_INT=7;
	public static final int RULE_KW_DEFINE=8;
	public static final int RULE_KW_INCDIR=9;
	public static final int RULE_KW_INCLUDE=10;
	public static final int RULE_KW_INCSYS=11;
	public static final int RULE_KW_LANG=12;
	public static final int RULE_KW_NOSTDINC=13;
	public static final int RULE_KW_OUTPUT=14;
	public static final int RULE_LETTER=15;
	public static final int RULE_LINE_COMMENT=16;
	public static final int RULE_NEWLINE=17;
	public static final int RULE_SKW_ASSIGN=18;
	public static final int RULE_SKW_COMMA=19;
	public static final int RULE_SKW_LEFTPAREN=20;
	public static final int RULE_SKW_MINUS=21;
	public static final int RULE_SKW_RIGHTPAREN=22;
	public static final int RULE_STRING=23;
	public static final int RULE_WS=24;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public InternalCmdArgsLexer() {} 
	public InternalCmdArgsLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public InternalCmdArgsLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "InternalCmdArgsLexer.g"; }

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
			// do for sure before leaving
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
			// do for sure before leaving
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
			// do for sure before leaving
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
			// do for sure before leaving
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
			// do for sure before leaving
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
			// do for sure before leaving
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
			// do for sure before leaving
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
			// do for sure before leaving
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
			// do for sure before leaving
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
			// do for sure before leaving
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
			// do for sure before leaving
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
			// do for sure before leaving
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
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0=='$'||(LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// InternalCmdArgsLexer.g:
					{
					if ( input.LA(1)=='$'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_ID"

	// $ANTLR start "RULE_LETTER"
	public final void mRULE_LETTER() throws RecognitionException {
		try {
			// InternalCmdArgsLexer.g:47:22: ( ( '$' | 'A' .. 'Z' | 'a' .. 'z' | '_' ) )
			// InternalCmdArgsLexer.g:
			{
			if ( input.LA(1)=='$'||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
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
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// InternalCmdArgsLexer.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_INT"

	// $ANTLR start "RULE_DIGIT"
	public final void mRULE_DIGIT() throws RecognitionException {
		try {
			// InternalCmdArgsLexer.g:51:21: ( '0' .. '9' )
			// InternalCmdArgsLexer.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_DIGIT"

	// $ANTLR start "RULE_STRING"
	public final void mRULE_STRING() throws RecognitionException {
		try {
			int _type = RULE_STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCmdArgsLexer.g:53:13: ( ( '\"' ( '\\\\' . |~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . |~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
			// InternalCmdArgsLexer.g:53:15: ( '\"' ( '\\\\' . |~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . |~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
			{
			// InternalCmdArgsLexer.g:53:15: ( '\"' ( '\\\\' . |~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . |~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
					// InternalCmdArgsLexer.g:53:16: '\"' ( '\\\\' . |~ ( ( '\\\\' | '\"' ) ) )* '\"'
					{
					match('\"'); 
					// InternalCmdArgsLexer.g:53:20: ( '\\\\' . |~ ( ( '\\\\' | '\"' ) ) )*
					loop3:
					while (true) {
						int alt3=3;
						int LA3_0 = input.LA(1);
						if ( (LA3_0=='\\') ) {
							alt3=1;
						}
						else if ( ((LA3_0 >= '\u0000' && LA3_0 <= '!')||(LA3_0 >= '#' && LA3_0 <= '[')||(LA3_0 >= ']' && LA3_0 <= '\uFFFF')) ) {
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
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop3;
						}
					}

					match('\"'); 
					}
					break;
				case 2 :
					// InternalCmdArgsLexer.g:53:48: '\\'' ( '\\\\' . |~ ( ( '\\\\' | '\\'' ) ) )* '\\''
					{
					match('\''); 
					// InternalCmdArgsLexer.g:53:53: ( '\\\\' . |~ ( ( '\\\\' | '\\'' ) ) )*
					loop4:
					while (true) {
						int alt4=3;
						int LA4_0 = input.LA(1);
						if ( (LA4_0=='\\') ) {
							alt4=1;
						}
						else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '&')||(LA4_0 >= '(' && LA4_0 <= '[')||(LA4_0 >= ']' && LA4_0 <= '\uFFFF')) ) {
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
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop4;
						}
					}

					match('\''); 
					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_STRING"

	// $ANTLR start "RULE_NEWLINE"
	public final void mRULE_NEWLINE() throws RecognitionException {
		try {
			int _type = RULE_NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCmdArgsLexer.g:55:14: ( ( '\\n' | '\\r' ) )
			// InternalCmdArgsLexer.g:
			{
			if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_NEWLINE"

	// $ANTLR start "RULE_WS"
	public final void mRULE_WS() throws RecognitionException {
		try {
			int _type = RULE_WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCmdArgsLexer.g:57:9: ( ( ' ' | '\\t' ) )
			// InternalCmdArgsLexer.g:
			{
			if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
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
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0=='\n'||LA6_0=='\r') ) {
					alt6=2;
				}
				else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\t')||(LA6_0 >= '\u000B' && LA6_0 <= '\f')||(LA6_0 >= '\u000E' && LA6_0 <= '\uFFFF')) ) {
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
			}

			mRULE_NEWLINE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
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
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_ANY_OTHER"

	@Override
	public void mTokens() throws RecognitionException {
		// InternalCmdArgsLexer.g:1:8: ( RULE_SKW_MINUS | RULE_SKW_ASSIGN | RULE_SKW_LEFTPAREN | RULE_SKW_RIGHTPAREN | RULE_SKW_COMMA | RULE_KW_DEFINE | RULE_KW_INCDIR | RULE_KW_OUTPUT | RULE_KW_LANG | RULE_KW_NOSTDINC | RULE_KW_INCSYS | RULE_KW_INCLUDE | RULE_ID | RULE_INT | RULE_STRING | RULE_NEWLINE | RULE_WS | RULE_LINE_COMMENT | RULE_ANY_OTHER )
		int alt7=19;
		int LA7_0 = input.LA(1);
		if ( (LA7_0=='-') ) {
			switch ( input.LA(2) ) {
			case 'D':
				{
				alt7=6;
				}
				break;
			case 'I':
				{
				alt7=7;
				}
				break;
			case 'o':
				{
				alt7=8;
				}
				break;
			case 'x':
				{
				alt7=9;
				}
				break;
			default:
				alt7=1;
			}
		}
		else if ( (LA7_0=='=') ) {
			alt7=2;
		}
		else if ( (LA7_0=='(') ) {
			alt7=3;
		}
		else if ( (LA7_0==')') ) {
			alt7=4;
		}
		else if ( (LA7_0==',') ) {
			alt7=5;
		}
		else if ( (LA7_0=='n') ) {
			int LA7_6 = input.LA(2);
			if ( (LA7_6=='o') ) {
				int LA7_25 = input.LA(3);
				if ( (LA7_25=='s') ) {
					int LA7_34 = input.LA(4);
					if ( (LA7_34=='t') ) {
						int LA7_37 = input.LA(5);
						if ( (LA7_37=='d') ) {
							int LA7_40 = input.LA(6);
							if ( (LA7_40=='i') ) {
								int LA7_43 = input.LA(7);
								if ( (LA7_43=='n') ) {
									int LA7_46 = input.LA(8);
									if ( (LA7_46=='c') ) {
										int LA7_49 = input.LA(9);
										if ( (LA7_49=='$'||(LA7_49 >= '0' && LA7_49 <= '9')||(LA7_49 >= 'A' && LA7_49 <= 'Z')||LA7_49=='_'||(LA7_49 >= 'a' && LA7_49 <= 'z')) ) {
											alt7=13;
										}

										else {
											alt7=10;
										}

									}

									else {
										alt7=13;
									}

								}

								else {
									alt7=13;
								}

							}

							else {
								alt7=13;
							}

						}

						else {
							alt7=13;
						}

					}

					else {
						alt7=13;
					}

				}

				else {
					alt7=13;
				}

			}

			else {
				alt7=13;
			}

		}
		else if ( (LA7_0=='i') ) {
			switch ( input.LA(2) ) {
			case 's':
				{
				int LA7_27 = input.LA(3);
				if ( (LA7_27=='y') ) {
					int LA7_35 = input.LA(4);
					if ( (LA7_35=='s') ) {
						int LA7_38 = input.LA(5);
						if ( (LA7_38=='t') ) {
							int LA7_41 = input.LA(6);
							if ( (LA7_41=='e') ) {
								int LA7_44 = input.LA(7);
								if ( (LA7_44=='m') ) {
									int LA7_47 = input.LA(8);
									if ( (LA7_47=='$'||(LA7_47 >= '0' && LA7_47 <= '9')||(LA7_47 >= 'A' && LA7_47 <= 'Z')||LA7_47=='_'||(LA7_47 >= 'a' && LA7_47 <= 'z')) ) {
										alt7=13;
									}

									else {
										alt7=11;
									}

								}

								else {
									alt7=13;
								}

							}

							else {
								alt7=13;
							}

						}

						else {
							alt7=13;
						}

					}

					else {
						alt7=13;
					}

				}

				else {
					alt7=13;
				}

				}
				break;
			case 'n':
				{
				int LA7_28 = input.LA(3);
				if ( (LA7_28=='c') ) {
					int LA7_36 = input.LA(4);
					if ( (LA7_36=='l') ) {
						int LA7_39 = input.LA(5);
						if ( (LA7_39=='u') ) {
							int LA7_42 = input.LA(6);
							if ( (LA7_42=='d') ) {
								int LA7_45 = input.LA(7);
								if ( (LA7_45=='e') ) {
									int LA7_48 = input.LA(8);
									if ( (LA7_48=='$'||(LA7_48 >= '0' && LA7_48 <= '9')||(LA7_48 >= 'A' && LA7_48 <= 'Z')||LA7_48=='_'||(LA7_48 >= 'a' && LA7_48 <= 'z')) ) {
										alt7=13;
									}

									else {
										alt7=12;
									}

								}

								else {
									alt7=13;
								}

							}

							else {
								alt7=13;
							}

						}

						else {
							alt7=13;
						}

					}

					else {
						alt7=13;
					}

				}

				else {
					alt7=13;
				}

				}
				break;
			default:
				alt7=13;
			}
		}
		else if ( (LA7_0=='$'||(LA7_0 >= 'A' && LA7_0 <= 'Z')||LA7_0=='_'||(LA7_0 >= 'a' && LA7_0 <= 'h')||(LA7_0 >= 'j' && LA7_0 <= 'm')||(LA7_0 >= 'o' && LA7_0 <= 'z')) ) {
			alt7=13;
		}
		else if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
			alt7=14;
		}
		else if ( (LA7_0=='\"') ) {
			int LA7_10 = input.LA(2);
			if ( ((LA7_10 >= '\u0000' && LA7_10 <= '\uFFFF')) ) {
				alt7=15;
			}

			else {
				alt7=19;
			}

		}
		else if ( (LA7_0=='\'') ) {
			int LA7_11 = input.LA(2);
			if ( ((LA7_11 >= '\u0000' && LA7_11 <= '\uFFFF')) ) {
				alt7=15;
			}

			else {
				alt7=19;
			}

		}
		else if ( (LA7_0=='\n'||LA7_0=='\r') ) {
			alt7=16;
		}
		else if ( (LA7_0=='\t'||LA7_0==' ') ) {
			alt7=17;
		}
		else if ( (LA7_0=='/') ) {
			int LA7_14 = input.LA(2);
			if ( (LA7_14=='/') ) {
				alt7=18;
			}

			else {
				alt7=19;
			}

		}
		else if ( ((LA7_0 >= '\u0000' && LA7_0 <= '\b')||(LA7_0 >= '\u000B' && LA7_0 <= '\f')||(LA7_0 >= '\u000E' && LA7_0 <= '\u001F')||LA7_0=='!'||LA7_0=='#'||(LA7_0 >= '%' && LA7_0 <= '&')||(LA7_0 >= '*' && LA7_0 <= '+')||LA7_0=='.'||(LA7_0 >= ':' && LA7_0 <= '<')||(LA7_0 >= '>' && LA7_0 <= '@')||(LA7_0 >= '[' && LA7_0 <= '^')||LA7_0=='`'||(LA7_0 >= '{' && LA7_0 <= '\uFFFF')) ) {
			alt7=19;
		}

		else {
			NoViableAltException nvae =
				new NoViableAltException("", 7, 0, input);
			throw nvae;
		}

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



}
