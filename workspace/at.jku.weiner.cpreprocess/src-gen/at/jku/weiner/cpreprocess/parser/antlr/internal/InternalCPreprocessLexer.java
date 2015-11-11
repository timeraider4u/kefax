// $ANTLR 3.x InternalCPreprocess.g 2015-11-10 21:32:20

package at.jku.weiner.cpreprocess.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCPreprocessLexer extends Lexer {
	public static final int EOF=-1;
	public static final int RULE_BACKSLASH=4;
	public static final int RULE_CARRIAGERETURN=5;
	public static final int RULE_DEFINE=6;
	public static final int RULE_ERROR=7;
	public static final int RULE_HASH=8;
	public static final int RULE_ID=9;
	public static final int RULE_IDENTIFIER=10;
	public static final int RULE_INCLUDE=11;
	public static final int RULE_LETTER=12;
	public static final int RULE_LINEBREAK=13;
	public static final int RULE_LINEFEED=14;
	public static final int RULE_MYCODE=15;
	public static final int RULE_NEWLINE=16;
	public static final int RULE_NO_CODE_START=17;
	public static final int RULE_PRAGMA=18;
	public static final int RULE_UNDEF=19;
	public static final int RULE_WS=20;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public InternalCPreprocessLexer() {} 
	public InternalCPreprocessLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public InternalCPreprocessLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "InternalCPreprocess.g"; }

	// $ANTLR start "RULE_LINEFEED"
	public final void mRULE_LINEFEED() throws RecognitionException {
		try {
			// InternalCPreprocess.g:832:24: ( '\\n' )
			// InternalCPreprocess.g:832:26: '\\n'
			{
			match('\n'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_LINEFEED"

	// $ANTLR start "RULE_CARRIAGERETURN"
	public final void mRULE_CARRIAGERETURN() throws RecognitionException {
		try {
			// InternalCPreprocess.g:834:30: ( '\\r' )
			// InternalCPreprocess.g:834:32: '\\r'
			{
			match('\r'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_CARRIAGERETURN"

	// $ANTLR start "RULE_NEWLINE"
	public final void mRULE_NEWLINE() throws RecognitionException {
		try {
			int _type = RULE_NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCPreprocess.g:836:14: ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) )
			// InternalCPreprocess.g:836:16: ( RULE_CARRIAGERETURN | RULE_LINEFEED )
			{
			if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			 at.jku.weiner.cpreprocess.PreLine.setPreLine(false); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_NEWLINE"

	// $ANTLR start "RULE_BACKSLASH"
	public final void mRULE_BACKSLASH() throws RecognitionException {
		try {
			// InternalCPreprocess.g:838:25: ( '\\\\' )
			// InternalCPreprocess.g:838:27: '\\\\'
			{
			match('\\'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_BACKSLASH"

	// $ANTLR start "RULE_LINEBREAK"
	public final void mRULE_LINEBREAK() throws RecognitionException {
		try {
			// InternalCPreprocess.g:840:25: ( ( RULE_BACKSLASH RULE_NEWLINE )+ )
			// InternalCPreprocess.g:840:27: ( RULE_BACKSLASH RULE_NEWLINE )+
			{
			// InternalCPreprocess.g:840:27: ( RULE_BACKSLASH RULE_NEWLINE )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0=='\\') ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// InternalCPreprocess.g:840:28: RULE_BACKSLASH RULE_NEWLINE
					{
					mRULE_BACKSLASH(); 

					mRULE_NEWLINE(); 

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_LINEBREAK"

	// $ANTLR start "RULE_WS"
	public final void mRULE_WS() throws RecognitionException {
		try {
			// InternalCPreprocess.g:842:18: ( ( ' ' | '\\t' | RULE_LINEBREAK ) )
			// InternalCPreprocess.g:842:20: ( ' ' | '\\t' | RULE_LINEBREAK )
			{
			// InternalCPreprocess.g:842:20: ( ' ' | '\\t' | RULE_LINEBREAK )
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
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// InternalCPreprocess.g:842:21: ' '
					{
					match(' '); 
					}
					break;
				case 2 :
					// InternalCPreprocess.g:842:25: '\\t'
					{
					match('\t'); 
					}
					break;
				case 3 :
					// InternalCPreprocess.g:842:30: RULE_LINEBREAK
					{
					mRULE_LINEBREAK(); 

					}
					break;

			}

			 at.jku.weiner.cpreprocess.PreLine.setWhiteSpace(); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_WS"

	// $ANTLR start "RULE_HASH"
	public final void mRULE_HASH() throws RecognitionException {
		try {
			// InternalCPreprocess.g:844:20: ( '#' )
			// InternalCPreprocess.g:844:22: '#'
			{
			match('#'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_HASH"

	// $ANTLR start "RULE_DEFINE"
	public final void mRULE_DEFINE() throws RecognitionException {
		try {
			int _type = RULE_DEFINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCPreprocess.g:846:13: ( RULE_HASH ( RULE_WS )* 'define' ( RULE_WS )+ )
			// InternalCPreprocess.g:846:15: RULE_HASH ( RULE_WS )* 'define' ( RULE_WS )+
			{
			mRULE_HASH(); 

			// InternalCPreprocess.g:846:25: ( RULE_WS )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0=='\t'||LA3_0==' '||LA3_0=='\\') ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// InternalCPreprocess.g:846:25: RULE_WS
					{
					mRULE_WS(); 

					}
					break;

				default :
					break loop3;
				}
			}

			match("define"); 

			// InternalCPreprocess.g:846:43: ( RULE_WS )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0=='\t'||LA4_0==' '||LA4_0=='\\') ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// InternalCPreprocess.g:846:43: RULE_WS
					{
					mRULE_WS(); 

					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			 at.jku.weiner.cpreprocess.PreLine.setPreLine(true); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_DEFINE"

	// $ANTLR start "RULE_UNDEF"
	public final void mRULE_UNDEF() throws RecognitionException {
		try {
			int _type = RULE_UNDEF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCPreprocess.g:848:12: ( RULE_HASH ( RULE_WS )* 'undef' ( RULE_WS )+ )
			// InternalCPreprocess.g:848:14: RULE_HASH ( RULE_WS )* 'undef' ( RULE_WS )+
			{
			mRULE_HASH(); 

			// InternalCPreprocess.g:848:24: ( RULE_WS )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0=='\t'||LA5_0==' '||LA5_0=='\\') ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// InternalCPreprocess.g:848:24: RULE_WS
					{
					mRULE_WS(); 

					}
					break;

				default :
					break loop5;
				}
			}

			match("undef"); 

			// InternalCPreprocess.g:848:41: ( RULE_WS )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0=='\t'||LA6_0==' '||LA6_0=='\\') ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// InternalCPreprocess.g:848:41: RULE_WS
					{
					mRULE_WS(); 

					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			 at.jku.weiner.cpreprocess.PreLine.setPreLine(true); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_UNDEF"

	// $ANTLR start "RULE_INCLUDE"
	public final void mRULE_INCLUDE() throws RecognitionException {
		try {
			int _type = RULE_INCLUDE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCPreprocess.g:850:14: ( RULE_HASH ( RULE_WS )* 'include' ( RULE_WS )+ )
			// InternalCPreprocess.g:850:16: RULE_HASH ( RULE_WS )* 'include' ( RULE_WS )+
			{
			mRULE_HASH(); 

			// InternalCPreprocess.g:850:26: ( RULE_WS )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0=='\t'||LA7_0==' '||LA7_0=='\\') ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// InternalCPreprocess.g:850:26: RULE_WS
					{
					mRULE_WS(); 

					}
					break;

				default :
					break loop7;
				}
			}

			match("include"); 

			// InternalCPreprocess.g:850:45: ( RULE_WS )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0=='\t'||LA8_0==' '||LA8_0=='\\') ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// InternalCPreprocess.g:850:45: RULE_WS
					{
					mRULE_WS(); 

					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
			}

			 at.jku.weiner.cpreprocess.PreLine.setPreLine(false); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_INCLUDE"

	// $ANTLR start "RULE_ERROR"
	public final void mRULE_ERROR() throws RecognitionException {
		try {
			int _type = RULE_ERROR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCPreprocess.g:852:12: ( RULE_HASH ( RULE_WS )* 'error' ( RULE_WS )+ )
			// InternalCPreprocess.g:852:14: RULE_HASH ( RULE_WS )* 'error' ( RULE_WS )+
			{
			mRULE_HASH(); 

			// InternalCPreprocess.g:852:24: ( RULE_WS )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0=='\t'||LA9_0==' '||LA9_0=='\\') ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// InternalCPreprocess.g:852:24: RULE_WS
					{
					mRULE_WS(); 

					}
					break;

				default :
					break loop9;
				}
			}

			match("error"); 

			// InternalCPreprocess.g:852:41: ( RULE_WS )+
			int cnt10=0;
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0=='\t'||LA10_0==' '||LA10_0=='\\') ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// InternalCPreprocess.g:852:41: RULE_WS
					{
					mRULE_WS(); 

					}
					break;

				default :
					if ( cnt10 >= 1 ) break loop10;
					EarlyExitException eee = new EarlyExitException(10, input);
					throw eee;
				}
				cnt10++;
			}

			 at.jku.weiner.cpreprocess.PreLine.setPreLine(false); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_ERROR"

	// $ANTLR start "RULE_PRAGMA"
	public final void mRULE_PRAGMA() throws RecognitionException {
		try {
			int _type = RULE_PRAGMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCPreprocess.g:854:13: ( RULE_HASH ( RULE_WS )* 'pragma' ( RULE_WS )+ )
			// InternalCPreprocess.g:854:15: RULE_HASH ( RULE_WS )* 'pragma' ( RULE_WS )+
			{
			mRULE_HASH(); 

			// InternalCPreprocess.g:854:25: ( RULE_WS )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0=='\t'||LA11_0==' '||LA11_0=='\\') ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// InternalCPreprocess.g:854:25: RULE_WS
					{
					mRULE_WS(); 

					}
					break;

				default :
					break loop11;
				}
			}

			match("pragma"); 

			// InternalCPreprocess.g:854:43: ( RULE_WS )+
			int cnt12=0;
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0=='\t'||LA12_0==' '||LA12_0=='\\') ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// InternalCPreprocess.g:854:43: RULE_WS
					{
					mRULE_WS(); 

					}
					break;

				default :
					if ( cnt12 >= 1 ) break loop12;
					EarlyExitException eee = new EarlyExitException(12, input);
					throw eee;
				}
				cnt12++;
			}

			 at.jku.weiner.cpreprocess.PreLine.setPreLine(true); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_PRAGMA"

	// $ANTLR start "RULE_ID"
	public final void mRULE_ID() throws RecognitionException {
		try {
			int _type = RULE_ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCPreprocess.g:856:9: ( RULE_IDENTIFIER )
			// InternalCPreprocess.g:856:11: RULE_IDENTIFIER
			{
			mRULE_IDENTIFIER(); 

			 at.jku.weiner.cpreprocess.PreLine.setIdentifier(); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_ID"

	// $ANTLR start "RULE_IDENTIFIER"
	public final void mRULE_IDENTIFIER() throws RecognitionException {
		try {
			// InternalCPreprocess.g:858:26: ( RULE_LETTER ( RULE_LETTER | '0' .. '9' )* )
			// InternalCPreprocess.g:858:28: RULE_LETTER ( RULE_LETTER | '0' .. '9' )*
			{
			mRULE_LETTER(); 

			// InternalCPreprocess.g:858:40: ( RULE_LETTER | '0' .. '9' )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0=='$'||(LA13_0 >= '0' && LA13_0 <= '9')||(LA13_0 >= 'A' && LA13_0 <= 'Z')||LA13_0=='_'||(LA13_0 >= 'a' && LA13_0 <= 'z')) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// InternalCPreprocess.g:
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
					break loop13;
				}
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_IDENTIFIER"

	// $ANTLR start "RULE_LETTER"
	public final void mRULE_LETTER() throws RecognitionException {
		try {
			// InternalCPreprocess.g:860:22: ( ( '$' | 'A' .. 'Z' | 'a' .. 'z' | '_' ) )
			// InternalCPreprocess.g:
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

	// $ANTLR start "RULE_NO_CODE_START"
	public final void mRULE_NO_CODE_START() throws RecognitionException {
		try {
			// InternalCPreprocess.g:862:29: ( ( RULE_NEWLINE | RULE_HASH ) )
			// InternalCPreprocess.g:862:31: ( RULE_NEWLINE | RULE_HASH )
			{
			// InternalCPreprocess.g:862:31: ( RULE_NEWLINE | RULE_HASH )
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0=='\n'||LA14_0=='\r') ) {
				alt14=1;
			}
			else if ( (LA14_0=='#') ) {
				alt14=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// InternalCPreprocess.g:862:32: RULE_NEWLINE
					{
					mRULE_NEWLINE(); 

					}
					break;
				case 2 :
					// InternalCPreprocess.g:862:45: RULE_HASH
					{
					mRULE_HASH(); 

					}
					break;

			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_NO_CODE_START"

	// $ANTLR start "RULE_MYCODE"
	public final void mRULE_MYCODE() throws RecognitionException {
		try {
			int _type = RULE_MYCODE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalCPreprocess.g:864:13: ({...}? =>~ ( ( RULE_HASH | RULE_CARRIAGERETURN | RULE_LINEFEED ) ) (~ ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) ) )* )
			// InternalCPreprocess.g:864:15: {...}? =>~ ( ( RULE_HASH | RULE_CARRIAGERETURN | RULE_LINEFEED ) ) (~ ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) ) )*
			{
			if ( !(( !at.jku.weiner.cpreprocess.PreLine.isPreLine() )) ) {
				throw new FailedPredicateException(input, "RULE_MYCODE", " !at.jku.weiner.cpreprocess.PreLine.isPreLine() ");
			}
			if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\"')||(input.LA(1) >= '$' && input.LA(1) <= '\uFFFF') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// InternalCPreprocess.g:864:118: (~ ( ( RULE_CARRIAGERETURN | RULE_LINEFEED ) ) )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( ((LA15_0 >= '\u0000' && LA15_0 <= '\t')||(LA15_0 >= '\u000B' && LA15_0 <= '\f')||(LA15_0 >= '\u000E' && LA15_0 <= '\uFFFF')) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// InternalCPreprocess.g:
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
					break loop15;
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
	// $ANTLR end "RULE_MYCODE"

	@Override
	public void mTokens() throws RecognitionException {
		// InternalCPreprocess.g:1:8: ( RULE_NEWLINE | RULE_DEFINE | RULE_UNDEF | RULE_INCLUDE | RULE_ERROR | RULE_PRAGMA | RULE_ID | RULE_MYCODE )
		int alt16=8;
		alt16 = dfa16.predict(input);
		switch (alt16) {
			case 1 :
				// InternalCPreprocess.g:1:10: RULE_NEWLINE
				{
				mRULE_NEWLINE(); 

				}
				break;
			case 2 :
				// InternalCPreprocess.g:1:23: RULE_DEFINE
				{
				mRULE_DEFINE(); 

				}
				break;
			case 3 :
				// InternalCPreprocess.g:1:35: RULE_UNDEF
				{
				mRULE_UNDEF(); 

				}
				break;
			case 4 :
				// InternalCPreprocess.g:1:46: RULE_INCLUDE
				{
				mRULE_INCLUDE(); 

				}
				break;
			case 5 :
				// InternalCPreprocess.g:1:59: RULE_ERROR
				{
				mRULE_ERROR(); 

				}
				break;
			case 6 :
				// InternalCPreprocess.g:1:70: RULE_PRAGMA
				{
				mRULE_PRAGMA(); 

				}
				break;
			case 7 :
				// InternalCPreprocess.g:1:82: RULE_ID
				{
				mRULE_ID(); 

				}
				break;
			case 8 :
				// InternalCPreprocess.g:1:90: RULE_MYCODE
				{
				mRULE_MYCODE(); 

				}
				break;

		}
	}


	protected DFA16 dfa16 = new DFA16(this);
	static final String DFA16_eotS =
		"\3\uffff\1\15\12\uffff\1\21\3\uffff";
	static final String DFA16_eofS =
		"\22\uffff";
	static final String DFA16_minS =
		"\1\0\1\uffff\1\11\1\0\1\uffff\2\11\1\12\5\uffff\2\0\1\11\1\uffff\1\0";
	static final String DFA16_maxS =
		"\1\uffff\1\uffff\1\165\1\uffff\1\uffff\2\165\1\15\5\uffff\1\0\1\uffff"+
		"\1\165\1\uffff\1\0";
	static final String DFA16_acceptS =
		"\1\uffff\1\1\2\uffff\1\10\3\uffff\1\2\1\3\1\4\1\5\1\6\3\uffff\1\7\1\uffff";
	static final String DFA16_specialS =
		"\1\1\2\uffff\1\0\11\uffff\1\4\1\2\2\uffff\1\3}>";
	static final String[] DFA16_transitionS = {
			"\12\4\1\1\2\4\1\1\25\4\1\2\1\3\34\4\32\3\4\4\1\3\1\4\32\3\uff85\4",
			"",
			"\1\6\26\uffff\1\5\73\uffff\1\7\7\uffff\1\10\1\13\3\uffff\1\12\6\uffff"+
			"\1\14\4\uffff\1\11",
			"\12\4\1\uffff\2\4\1\uffff\26\4\1\16\13\4\12\16\7\4\32\16\4\4\1\16\1"+
			"\4\32\16\uff85\4",
			"",
			"\1\6\26\uffff\1\5\73\uffff\1\7\7\uffff\1\10\1\13\3\uffff\1\12\6\uffff"+
			"\1\14\4\uffff\1\11",
			"\1\6\26\uffff\1\5\73\uffff\1\7\7\uffff\1\10\1\13\3\uffff\1\12\6\uffff"+
			"\1\14\4\uffff\1\11",
			"\1\17\2\uffff\1\17",
			"",
			"",
			"",
			"",
			"",
			"\1\uffff",
			"\12\4\1\uffff\2\4\1\uffff\26\4\1\16\13\4\12\16\7\4\32\16\4\4\1\16\1"+
			"\4\32\16\uff85\4",
			"\1\6\26\uffff\1\5\73\uffff\1\7\7\uffff\1\10\1\13\3\uffff\1\12\6\uffff"+
			"\1\14\4\uffff\1\11",
			"",
			"\1\uffff"
	};

	static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
	static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
	static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
	static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
	static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
	static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
	static final short[][] DFA16_transition;

	static {
		int numStates = DFA16_transitionS.length;
		DFA16_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
		}
	}

	protected class DFA16 extends DFA {

		public DFA16(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 16;
			this.eot = DFA16_eot;
			this.eof = DFA16_eof;
			this.min = DFA16_min;
			this.max = DFA16_max;
			this.accept = DFA16_accept;
			this.special = DFA16_special;
			this.transition = DFA16_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( RULE_NEWLINE | RULE_DEFINE | RULE_UNDEF | RULE_INCLUDE | RULE_ERROR | RULE_PRAGMA | RULE_ID | RULE_MYCODE );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			int _s = s;
			switch ( s ) {
					case 0 : 
						s = specialState0(s, input);
						if (s >= 0) return s;
							break;

					case 1 : 
						s = specialState1(s, input);
						if (s >= 0) return s;
							break;

					case 2 : 
						s = specialState2(s, input);
						if (s >= 0) return s;
							break;

					case 3 : 
						s = specialState3(s, input);
						if (s >= 0) return s;
							break;

					case 4 : 
						s = specialState4(s, input);
						if (s >= 0) return s;
							break;

			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 16, _s, input);
			error(nvae);
			throw nvae;
		}
			private int specialState0(int s, IntStream _input) {
				IntStream input = _input;
				int LA16_3 = input.LA(1);
				 
				int index16_3 = input.index();
				input.rewind();
				s = -1;
				if ( (LA16_3=='$'||(LA16_3 >= '0' && LA16_3 <= '9')||(LA16_3 >= 'A' && LA16_3 <= 'Z')||LA16_3=='_'||(LA16_3 >= 'a' && LA16_3 <= 'z')) ) {s = 14;}
				else if ( ((LA16_3 >= '\u0000' && LA16_3 <= '\t')||(LA16_3 >= '\u000B' && LA16_3 <= '\f')||(LA16_3 >= '\u000E' && LA16_3 <= '#')||(LA16_3 >= '%' && LA16_3 <= '/')||(LA16_3 >= ':' && LA16_3 <= '@')||(LA16_3 >= '[' && LA16_3 <= '^')||LA16_3=='`'||(LA16_3 >= '{' && LA16_3 <= '\uFFFF')) && (( !at.jku.weiner.cpreprocess.PreLine.isPreLine() ))) {s = 4;}
				else s = 13;
				 
				input.seek(index16_3);
				//if ( s>=0 ) return s;
				//break;
				return s;
			}

			private int specialState1(int s, IntStream _input) {
				IntStream input = _input;
				int LA16_0 = input.LA(1);
				 
				int index16_0 = input.index();
				input.rewind();
				s = -1;
				if ( (LA16_0=='\n'||LA16_0=='\r') ) {s = 1;}
				else if ( (LA16_0=='#') ) {s = 2;}
				else if ( (LA16_0=='$'||(LA16_0 >= 'A' && LA16_0 <= 'Z')||LA16_0=='_'||(LA16_0 >= 'a' && LA16_0 <= 'z')) ) {s = 3;}
				else if ( ((LA16_0 >= '\u0000' && LA16_0 <= '\t')||(LA16_0 >= '\u000B' && LA16_0 <= '\f')||(LA16_0 >= '\u000E' && LA16_0 <= '\"')||(LA16_0 >= '%' && LA16_0 <= '@')||(LA16_0 >= '[' && LA16_0 <= '^')||LA16_0=='`'||(LA16_0 >= '{' && LA16_0 <= '\uFFFF')) && (( !at.jku.weiner.cpreprocess.PreLine.isPreLine() ))) {s = 4;}
				 
				input.seek(index16_0);
				//if ( s>=0 ) return s;
				//break;
				return s;
			}

			private int specialState2(int s, IntStream _input) {
				IntStream input = _input;
				int LA16_14 = input.LA(1);
				 
				int index16_14 = input.index();
				input.rewind();
				s = -1;
				if ( (LA16_14=='$'||(LA16_14 >= '0' && LA16_14 <= '9')||(LA16_14 >= 'A' && LA16_14 <= 'Z')||LA16_14=='_'||(LA16_14 >= 'a' && LA16_14 <= 'z')) ) {s = 14;}
				else if ( ((LA16_14 >= '\u0000' && LA16_14 <= '\t')||(LA16_14 >= '\u000B' && LA16_14 <= '\f')||(LA16_14 >= '\u000E' && LA16_14 <= '#')||(LA16_14 >= '%' && LA16_14 <= '/')||(LA16_14 >= ':' && LA16_14 <= '@')||(LA16_14 >= '[' && LA16_14 <= '^')||LA16_14=='`'||(LA16_14 >= '{' && LA16_14 <= '\uFFFF')) && (( !at.jku.weiner.cpreprocess.PreLine.isPreLine() ))) {s = 4;}
				else s = 17;
				 
				input.seek(index16_14);
				//if ( s>=0 ) return s;
				//break;
				return s;
			}

			private int specialState3(int s, IntStream _input) {
				IntStream input = _input;
				int LA16_17 = input.LA(1);
				 
				int index16_17 = input.index();
				input.rewind();
				s = -1;
				if ( (!((( !at.jku.weiner.cpreprocess.PreLine.isPreLine() )))) ) {s = 16;}
				else if ( (( !at.jku.weiner.cpreprocess.PreLine.isPreLine() )) ) {s = 4;}
				 
				input.seek(index16_17);
				//if ( s>=0 ) return s;
				//break;
				return s;
			}

			private int specialState4(int s, IntStream _input) {
				IntStream input = _input;
				int LA16_13 = input.LA(1);
				 
				int index16_13 = input.index();
				input.rewind();
				s = -1;
				if ( (!((( !at.jku.weiner.cpreprocess.PreLine.isPreLine() )))) ) {s = 16;}
				else if ( (( !at.jku.weiner.cpreprocess.PreLine.isPreLine() )) ) {s = 4;}
				 
				input.seek(index16_13);
				//if ( s>=0 ) return s;
				//break;
				return s;
			}

	}


}
