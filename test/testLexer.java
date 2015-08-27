// $ANTLR 3.1.3 November 23, 2014 21:33:05 test.g 2015-08-27 23:30:21

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class testLexer extends Lexer {
    public static final int MY=4;
    public static final int EOF=-1;

    // delegates
    // delegators

    public testLexer() {;} 
    public testLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public testLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "test.g"; }

    // $ANTLR start "MY"
    public final void mMY() throws RecognitionException {
        try {
            int _type = MY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // test.g:15:3: ( 'my' )
            // test.g:15:5: 'my'
            {
            match("my"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MY"

    public void mTokens() throws RecognitionException {
        // test.g:1:8: ( MY )
        // test.g:1:10: MY
        {
        mMY(); 

        }


    }


 

}