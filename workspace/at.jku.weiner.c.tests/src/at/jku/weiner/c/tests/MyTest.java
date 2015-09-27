package at.jku.weiner.c.tests;

public class MyTest {

	public static void testTokens(final String text,
			final LexerAndParserTest test) {
		final String[] expected = new String[] { "KW_INT", "ID", "SEMI",
				"KW_INT", "ID", "SEMI" };
		for (int i = 0; i < expected.length; i++) {
			expected[i] = "RULE_" + expected[i];
		}
		test.checkTokenisation(text, false, expected);
	}

}
