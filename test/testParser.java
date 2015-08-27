// $ANTLR 3.1.3 November 23, 2014 21:33:05 test.g 2015-08-27 23:30:21

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class testParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "MY"
    };
    public static final int MY=4;
    public static final int EOF=-1;

    // delegates
    // delegators


        public testParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public testParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return testParser.tokenNames; }
    public String getGrammarFileName() { return "test.g"; }



    // $ANTLR start "test"
    // test.g:3:1: test : ( foobar )+ ;
    public final void test() throws RecognitionException {
        try {
            // test.g:3:5: ( ( foobar )+ )
            // test.g:3:7: ( foobar )+
            {
            // test.g:3:7: ( foobar )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==MY) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // test.g:3:8: foobar
            	    {
            	    pushFollow(FOLLOW_foobar_in_test10);
            	    foobar();

            	    state._fsp--;


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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "test"


    // $ANTLR start "foobar"
    // test.g:5:1: foobar : ( foo | bar ) ;
    public final void foobar() throws RecognitionException {
        try {
            // test.g:5:7: ( ( foo | bar ) )
            // test.g:7:2: ( foo | bar )
            {
            // test.g:7:2: ( foo | bar )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==MY) ) {
                int LA2_1 = input.LA(2);

                if ( ((true/*stupidPredicate*/)) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // test.g:7:3: foo
                    {
                    pushFollow(FOLLOW_foo_in_foobar24);
                    foo();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // test.g:8:4: bar
                    {
                    pushFollow(FOLLOW_bar_in_foobar30);
                    bar();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "foobar"


    // $ANTLR start "foo"
    // test.g:12:1: foo : {...}? MY ;
    public final void foo() throws RecognitionException {
        try {
            // test.g:12:4: ({...}? MY )
            // test.g:12:6: {...}? MY
            {
            if ( !((true/*stupidPredicate*/)) ) {
                throw new FailedPredicateException(input, "foo", "true/*stupidPredicate*/");
            }
            match(input,MY,FOLLOW_MY_in_foo43); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "foo"


    // $ANTLR start "bar"
    // test.g:13:1: bar : MY ;
    public final void bar() throws RecognitionException {
        try {
            // test.g:13:4: ( MY )
            // test.g:13:6: MY
            {
            match(input,MY,FOLLOW_MY_in_bar49); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "bar"

    // Delegated rules


 

    public static final BitSet FOLLOW_foobar_in_test10 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_foo_in_foobar24 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bar_in_foobar30 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MY_in_foo43 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MY_in_bar49 = new BitSet(new long[]{0x0000000000000002L});

}