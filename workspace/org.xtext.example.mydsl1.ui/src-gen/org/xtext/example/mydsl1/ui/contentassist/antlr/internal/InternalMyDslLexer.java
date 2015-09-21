package org.xtext.example.mydsl1.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyDslLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int RULE_ANY_OTHER=4;
	public static final int RULE_ID=5;
	public static final int RULE_INT=6;
	public static final int RULE_ML_COMMENT=7;
	public static final int RULE_SL_COMMENT=8;
	public static final int RULE_STRING=9;
	public static final int RULE_WS=10;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public InternalMyDslLexer() {} 
	public InternalMyDslLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public InternalMyDslLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "InternalMyDsl.g"; }

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalMyDsl.g:15:7: ( '!' )
			// InternalMyDsl.g:15:9: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__11"

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalMyDsl.g:16:7: ( 'Hello' )
			// InternalMyDsl.g:16:9: 'Hello'
			{
			match("Hello"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalMyDsl.g:17:7: ( 'Test' )
			// InternalMyDsl.g:17:9: 'Test'
			{
			match("Test"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalMyDsl.g:18:7: ( 'inc' )
			// InternalMyDsl.g:18:9: 'inc'
			{
			match("inc"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalMyDsl.g:19:7: ( 'pre' )
			// InternalMyDsl.g:19:9: 'pre'
			{
			match("pre"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalMyDsl.g:20:7: ( 'reset' )
			// InternalMyDsl.g:20:9: 'reset'
			{
			match("reset"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalMyDsl.g:21:7: ( 'type' )
			// InternalMyDsl.g:21:9: 'type'
			{
			match("type"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__17"

	// $ANTLR start "RULE_ID"
	public final void mRULE_ID() throws RecognitionException {
		try {
			int _type = RULE_ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalMyDsl.g:1109:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
			// InternalMyDsl.g:1109:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
			{
			// InternalMyDsl.g:1109:11: ( '^' )?
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0=='^') ) {
				alt1=1;
			}
			switch (alt1) {
				case 1 :
					// InternalMyDsl.g:1109:11: '^'
					{
					match('^'); 
					}
					break;

			}

			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// InternalMyDsl.g:1109:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// InternalMyDsl.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
					break loop2;
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

	// $ANTLR start "RULE_INT"
	public final void mRULE_INT() throws RecognitionException {
		try {
			int _type = RULE_INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalMyDsl.g:1111:10: ( ( '0' .. '9' )+ )
			// InternalMyDsl.g:1111:12: ( '0' .. '9' )+
			{
			// InternalMyDsl.g:1111:12: ( '0' .. '9' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// InternalMyDsl.g:
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
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
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

	// $ANTLR start "RULE_STRING"
	public final void mRULE_STRING() throws RecognitionException {
		try {
			int _type = RULE_STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalMyDsl.g:1113:13: ( ( '\"' ( '\\\\' . |~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . |~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
			// InternalMyDsl.g:1113:15: ( '\"' ( '\\\\' . |~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . |~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
			{
			// InternalMyDsl.g:1113:15: ( '\"' ( '\\\\' . |~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . |~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
					// InternalMyDsl.g:1113:16: '\"' ( '\\\\' . |~ ( ( '\\\\' | '\"' ) ) )* '\"'
					{
					match('\"'); 
					// InternalMyDsl.g:1113:20: ( '\\\\' . |~ ( ( '\\\\' | '\"' ) ) )*
					loop4:
					while (true) {
						int alt4=3;
						int LA4_0 = input.LA(1);
						if ( (LA4_0=='\\') ) {
							alt4=1;
						}
						else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '!')||(LA4_0 >= '#' && LA4_0 <= '[')||(LA4_0 >= ']' && LA4_0 <= '\uFFFF')) ) {
							alt4=2;
						}

						switch (alt4) {
						case 1 :
							// InternalMyDsl.g:1113:21: '\\\\' .
							{
							match('\\'); 
							matchAny(); 
							}
							break;
						case 2 :
							// InternalMyDsl.g:1113:28: ~ ( ( '\\\\' | '\"' ) )
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
							break loop4;
						}
					}

					match('\"'); 
					}
					break;
				case 2 :
					// InternalMyDsl.g:1113:48: '\\'' ( '\\\\' . |~ ( ( '\\\\' | '\\'' ) ) )* '\\''
					{
					match('\''); 
					// InternalMyDsl.g:1113:53: ( '\\\\' . |~ ( ( '\\\\' | '\\'' ) ) )*
					loop5:
					while (true) {
						int alt5=3;
						int LA5_0 = input.LA(1);
						if ( (LA5_0=='\\') ) {
							alt5=1;
						}
						else if ( ((LA5_0 >= '\u0000' && LA5_0 <= '&')||(LA5_0 >= '(' && LA5_0 <= '[')||(LA5_0 >= ']' && LA5_0 <= '\uFFFF')) ) {
							alt5=2;
						}

						switch (alt5) {
						case 1 :
							// InternalMyDsl.g:1113:54: '\\\\' .
							{
							match('\\'); 
							matchAny(); 
							}
							break;
						case 2 :
							// InternalMyDsl.g:1113:61: ~ ( ( '\\\\' | '\\'' ) )
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
							break loop5;
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

	// $ANTLR start "RULE_ML_COMMENT"
	public final void mRULE_ML_COMMENT() throws RecognitionException {
		try {
			int _type = RULE_ML_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalMyDsl.g:1115:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// InternalMyDsl.g:1115:19: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// InternalMyDsl.g:1115:24: ( options {greedy=false; } : . )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0=='*') ) {
					int LA7_1 = input.LA(2);
					if ( (LA7_1=='/') ) {
						alt7=2;
					}
					else if ( ((LA7_1 >= '\u0000' && LA7_1 <= '.')||(LA7_1 >= '0' && LA7_1 <= '\uFFFF')) ) {
						alt7=1;
					}

				}
				else if ( ((LA7_0 >= '\u0000' && LA7_0 <= ')')||(LA7_0 >= '+' && LA7_0 <= '\uFFFF')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// InternalMyDsl.g:1115:52: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop7;
				}
			}

			match("*/"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_ML_COMMENT"

	// $ANTLR start "RULE_SL_COMMENT"
	public final void mRULE_SL_COMMENT() throws RecognitionException {
		try {
			int _type = RULE_SL_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalMyDsl.g:1117:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
			// InternalMyDsl.g:1117:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
			{
			match("//"); 

			// InternalMyDsl.g:1117:24: (~ ( ( '\\n' | '\\r' ) ) )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '\u0000' && LA8_0 <= '\t')||(LA8_0 >= '\u000B' && LA8_0 <= '\f')||(LA8_0 >= '\u000E' && LA8_0 <= '\uFFFF')) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// InternalMyDsl.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
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
					break loop8;
				}
			}

			// InternalMyDsl.g:1117:40: ( ( '\\r' )? '\\n' )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='\n'||LA10_0=='\r') ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// InternalMyDsl.g:1117:41: ( '\\r' )? '\\n'
					{
					// InternalMyDsl.g:1117:41: ( '\\r' )?
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0=='\r') ) {
						alt9=1;
					}
					switch (alt9) {
						case 1 :
							// InternalMyDsl.g:1117:41: '\\r'
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
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SL_COMMENT"

	// $ANTLR start "RULE_WS"
	public final void mRULE_WS() throws RecognitionException {
		try {
			int _type = RULE_WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalMyDsl.g:1119:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
			// InternalMyDsl.g:1119:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
			{
			// InternalMyDsl.g:1119:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( ((LA11_0 >= '\t' && LA11_0 <= '\n')||LA11_0=='\r'||LA11_0==' ') ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// InternalMyDsl.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
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
					if ( cnt11 >= 1 ) break loop11;
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
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

	// $ANTLR start "RULE_ANY_OTHER"
	public final void mRULE_ANY_OTHER() throws RecognitionException {
		try {
			int _type = RULE_ANY_OTHER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalMyDsl.g:1121:16: ( . )
			// InternalMyDsl.g:1121:18: .
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
		// InternalMyDsl.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
		int alt12=14;
		int LA12_0 = input.LA(1);
		if ( (LA12_0=='!') ) {
			alt12=1;
		}
		else if ( (LA12_0=='H') ) {
			int LA12_2 = input.LA(2);
			if ( (LA12_2=='e') ) {
				int LA12_17 = input.LA(3);
				if ( (LA12_17=='l') ) {
					int LA12_29 = input.LA(4);
					if ( (LA12_29=='l') ) {
						int LA12_35 = input.LA(5);
						if ( (LA12_35=='o') ) {
							int LA12_41 = input.LA(6);
							if ( ((LA12_41 >= '0' && LA12_41 <= '9')||(LA12_41 >= 'A' && LA12_41 <= 'Z')||LA12_41=='_'||(LA12_41 >= 'a' && LA12_41 <= 'z')) ) {
								alt12=8;
							}

							else {
								alt12=2;
							}

						}

						else {
							alt12=8;
						}

					}

					else {
						alt12=8;
					}

				}

				else {
					alt12=8;
				}

			}

			else {
				alt12=8;
			}

		}
		else if ( (LA12_0=='T') ) {
			int LA12_3 = input.LA(2);
			if ( (LA12_3=='e') ) {
				int LA12_19 = input.LA(3);
				if ( (LA12_19=='s') ) {
					int LA12_30 = input.LA(4);
					if ( (LA12_30=='t') ) {
						int LA12_36 = input.LA(5);
						if ( ((LA12_36 >= '0' && LA12_36 <= '9')||(LA12_36 >= 'A' && LA12_36 <= 'Z')||LA12_36=='_'||(LA12_36 >= 'a' && LA12_36 <= 'z')) ) {
							alt12=8;
						}

						else {
							alt12=3;
						}

					}

					else {
						alt12=8;
					}

				}

				else {
					alt12=8;
				}

			}

			else {
				alt12=8;
			}

		}
		else if ( (LA12_0=='i') ) {
			int LA12_4 = input.LA(2);
			if ( (LA12_4=='n') ) {
				int LA12_20 = input.LA(3);
				if ( (LA12_20=='c') ) {
					int LA12_31 = input.LA(4);
					if ( ((LA12_31 >= '0' && LA12_31 <= '9')||(LA12_31 >= 'A' && LA12_31 <= 'Z')||LA12_31=='_'||(LA12_31 >= 'a' && LA12_31 <= 'z')) ) {
						alt12=8;
					}

					else {
						alt12=4;
					}

				}

				else {
					alt12=8;
				}

			}

			else {
				alt12=8;
			}

		}
		else if ( (LA12_0=='p') ) {
			int LA12_5 = input.LA(2);
			if ( (LA12_5=='r') ) {
				int LA12_21 = input.LA(3);
				if ( (LA12_21=='e') ) {
					int LA12_32 = input.LA(4);
					if ( ((LA12_32 >= '0' && LA12_32 <= '9')||(LA12_32 >= 'A' && LA12_32 <= 'Z')||LA12_32=='_'||(LA12_32 >= 'a' && LA12_32 <= 'z')) ) {
						alt12=8;
					}

					else {
						alt12=5;
					}

				}

				else {
					alt12=8;
				}

			}

			else {
				alt12=8;
			}

		}
		else if ( (LA12_0=='r') ) {
			int LA12_6 = input.LA(2);
			if ( (LA12_6=='e') ) {
				int LA12_22 = input.LA(3);
				if ( (LA12_22=='s') ) {
					int LA12_33 = input.LA(4);
					if ( (LA12_33=='e') ) {
						int LA12_39 = input.LA(5);
						if ( (LA12_39=='t') ) {
							int LA12_43 = input.LA(6);
							if ( ((LA12_43 >= '0' && LA12_43 <= '9')||(LA12_43 >= 'A' && LA12_43 <= 'Z')||LA12_43=='_'||(LA12_43 >= 'a' && LA12_43 <= 'z')) ) {
								alt12=8;
							}

							else {
								alt12=6;
							}

						}

						else {
							alt12=8;
						}

					}

					else {
						alt12=8;
					}

				}

				else {
					alt12=8;
				}

			}

			else {
				alt12=8;
			}

		}
		else if ( (LA12_0=='t') ) {
			int LA12_7 = input.LA(2);
			if ( (LA12_7=='y') ) {
				int LA12_23 = input.LA(3);
				if ( (LA12_23=='p') ) {
					int LA12_34 = input.LA(4);
					if ( (LA12_34=='e') ) {
						int LA12_40 = input.LA(5);
						if ( ((LA12_40 >= '0' && LA12_40 <= '9')||(LA12_40 >= 'A' && LA12_40 <= 'Z')||LA12_40=='_'||(LA12_40 >= 'a' && LA12_40 <= 'z')) ) {
							alt12=8;
						}

						else {
							alt12=7;
						}

					}

					else {
						alt12=8;
					}

				}

				else {
					alt12=8;
				}

			}

			else {
				alt12=8;
			}

		}
		else if ( (LA12_0=='^') ) {
			int LA12_8 = input.LA(2);
			if ( ((LA12_8 >= 'A' && LA12_8 <= 'Z')||LA12_8=='_'||(LA12_8 >= 'a' && LA12_8 <= 'z')) ) {
				alt12=8;
			}

			else {
				alt12=14;
			}

		}
		else if ( ((LA12_0 >= 'A' && LA12_0 <= 'G')||(LA12_0 >= 'I' && LA12_0 <= 'S')||(LA12_0 >= 'U' && LA12_0 <= 'Z')||LA12_0=='_'||(LA12_0 >= 'a' && LA12_0 <= 'h')||(LA12_0 >= 'j' && LA12_0 <= 'o')||LA12_0=='q'||LA12_0=='s'||(LA12_0 >= 'u' && LA12_0 <= 'z')) ) {
			alt12=8;
		}
		else if ( ((LA12_0 >= '0' && LA12_0 <= '9')) ) {
			alt12=9;
		}
		else if ( (LA12_0=='\"') ) {
			int LA12_11 = input.LA(2);
			if ( ((LA12_11 >= '\u0000' && LA12_11 <= '\uFFFF')) ) {
				alt12=10;
			}

			else {
				alt12=14;
			}

		}
		else if ( (LA12_0=='\'') ) {
			int LA12_12 = input.LA(2);
			if ( ((LA12_12 >= '\u0000' && LA12_12 <= '\uFFFF')) ) {
				alt12=10;
			}

			else {
				alt12=14;
			}

		}
		else if ( (LA12_0=='/') ) {
			switch ( input.LA(2) ) {
			case '*':
				{
				alt12=11;
				}
				break;
			case '/':
				{
				alt12=12;
				}
				break;
			default:
				alt12=14;
			}
		}
		else if ( ((LA12_0 >= '\t' && LA12_0 <= '\n')||LA12_0=='\r'||LA12_0==' ') ) {
			alt12=13;
		}
		else if ( ((LA12_0 >= '\u0000' && LA12_0 <= '\b')||(LA12_0 >= '\u000B' && LA12_0 <= '\f')||(LA12_0 >= '\u000E' && LA12_0 <= '\u001F')||(LA12_0 >= '#' && LA12_0 <= '&')||(LA12_0 >= '(' && LA12_0 <= '.')||(LA12_0 >= ':' && LA12_0 <= '@')||(LA12_0 >= '[' && LA12_0 <= ']')||LA12_0=='`'||(LA12_0 >= '{' && LA12_0 <= '\uFFFF')) ) {
			alt12=14;
		}

		else {
			NoViableAltException nvae =
				new NoViableAltException("", 12, 0, input);
			throw nvae;
		}

		switch (alt12) {
			case 1 :
				// InternalMyDsl.g:1:10: T__11
				{
				mT__11(); 

				}
				break;
			case 2 :
				// InternalMyDsl.g:1:16: T__12
				{
				mT__12(); 

				}
				break;
			case 3 :
				// InternalMyDsl.g:1:22: T__13
				{
				mT__13(); 

				}
				break;
			case 4 :
				// InternalMyDsl.g:1:28: T__14
				{
				mT__14(); 

				}
				break;
			case 5 :
				// InternalMyDsl.g:1:34: T__15
				{
				mT__15(); 

				}
				break;
			case 6 :
				// InternalMyDsl.g:1:40: T__16
				{
				mT__16(); 

				}
				break;
			case 7 :
				// InternalMyDsl.g:1:46: T__17
				{
				mT__17(); 

				}
				break;
			case 8 :
				// InternalMyDsl.g:1:52: RULE_ID
				{
				mRULE_ID(); 

				}
				break;
			case 9 :
				// InternalMyDsl.g:1:60: RULE_INT
				{
				mRULE_INT(); 

				}
				break;
			case 10 :
				// InternalMyDsl.g:1:69: RULE_STRING
				{
				mRULE_STRING(); 

				}
				break;
			case 11 :
				// InternalMyDsl.g:1:81: RULE_ML_COMMENT
				{
				mRULE_ML_COMMENT(); 

				}
				break;
			case 12 :
				// InternalMyDsl.g:1:97: RULE_SL_COMMENT
				{
				mRULE_SL_COMMENT(); 

				}
				break;
			case 13 :
				// InternalMyDsl.g:1:113: RULE_WS
				{
				mRULE_WS(); 

				}
				break;
			case 14 :
				// InternalMyDsl.g:1:121: RULE_ANY_OTHER
				{
				mRULE_ANY_OTHER(); 

				}
				break;

		}
	}



}
