package at.jku.weiner.c.parser.xtexttests;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.Token;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.junit.Assert;

import at.jku.weiner.log.MyLog;

public class LexerAndParserTest extends AbstractXtextTests {

	private final Lexer lexer;
	private final AbstractAntlrParser parser;
	private final ITokenDefProvider tokenDefProvider;

	private boolean debugTokenStream = false;

	public LexerAndParserTest(final Lexer lexer,
			final AbstractAntlrParser parser,
			final ITokenDefProvider tokenDefProvider) {
		this.lexer = lexer;
		this.parser = parser;
		this.tokenDefProvider = tokenDefProvider;
	}

	public boolean isDebugTokenStream() {
		return this.debugTokenStream;
	}

	public void setDebugTokenStream(final boolean debugTokenStream) {
		this.debugTokenStream = debugTokenStream;
	}

	/**
	 * return the list of tokens created by the lexer from the given input
	 */
	public List<Token> getTokens(final String input) {
		final CharStream stream = new ANTLRStringStream(input);
		this.lexer.setCharStream(stream);
		final XtextTokenStream tokenStream = new XtextTokenStream(this.lexer,
				this.tokenDefProvider);
		// this.parser.setInitialHiddenTokens(tokenStream);
		@SuppressWarnings("unchecked")
		final List<Token> tokens = tokenStream.getTokens();
		return tokens;
	}

	/**
	 * return the name of the terminal rule for a given token
	 */
	public String getTokenType(final Token token) {
		return this.tokenDefProvider.getTokenDefMap().get(token.getType());
	}

	/**
	 * @param tokens
	 *            the tokens to debug to console
	 */
	public void debugTokens(final List<Token> tokens) {
		for (int i = 0; i < tokens.size(); i++) {
			final Token token = tokens.get(i);
			MyLog.trace(
					LexerAndParserTest.class,
					"Token type=" + this.getTokenType(token) + " text="
							+ token.getText());
		}
	}

	/**
	 * check whether an input is chopped into a list of expected token types
	 */
	public void checkTokenisation(final String input,
			final String... expectedTokenTypes) {
		this.checkTokenisation(input, true, expectedTokenTypes);
	}

	/**
	 * check whether an input is chopped into a list of expected token types
	 */
	public void checkTokenisation(final String input,
			final boolean showHiddenTokens, final String... expectedTokenTypes) {
		final List<Token> tokens = this.getTokens(input);
		final List<String> actualTokenTypes = new ArrayList<String>(
				tokens.size());
		for (int i = 0; i < tokens.size(); i++) {
			final Token token = tokens.get(i);
			if (showHiddenTokens
					|| (token.getChannel() != Token.HIDDEN_CHANNEL)) {
				actualTokenTypes.add(this.getTokenType(token));
			}
			if (this.debugTokenStream) {
				this.debugTokens(tokens);
			}
		}
		Assert.assertEquals(input, Arrays.asList(expectedTokenTypes),
				actualTokenTypes);
	}

	/**
	 * check that an input is not tokenised using a particular terminal rule
	 */
	public void failTokenisation(final String input,
			final String unExpectedTokenType) {
		final List<Token> tokens = this.getTokens(input);
		Assert.assertEquals(input, 1, tokens.size());
		final Token token = tokens.get(0);
		Assert.assertNotSame(input, unExpectedTokenType,
				this.getTokenType(token));
	}

	/**
	 * return the parse result for an input given a specific entry rule of the
	 * grammar
	 */
	public IParseResult getParseResult(final String input,
			final String entryRule) {
		final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(this
				.getGrammarAccess().getGrammar(), entryRule);
		return this.parser.parse(rule, new StringReader(input));
	}

	/**
	 * check that the input can be successfully parsed given a specific entry
	 * rule of the grammar
	 */
	public void checkParsing(final String input, final String entryRule) {
		final IParseResult la = this.getParseResult(input, entryRule);
		Assert.assertFalse(input, la.hasSyntaxErrors());
	}

	/**
	 * check that the input cannot be successfully parsed given a specific entry
	 * rule of the grammar
	 */
	public void failParsing(final String input, final String entryRule) {
		final IParseResult la = this.getParseResult(input, entryRule);
		Assert.assertFalse(input, la.hasSyntaxErrors());
	}

	/**
	 *
	 * @param ruleName
	 *            name of the terminal rule
	 * @return The name of terminal rule will be capitalised and "RULE_" will be
	 *         appended to the front of the ruleName
	 */
	public static String rule(final String ruleName) {
		return new StringBuilder("RULE_").append(ruleName.toUpperCase())
				.toString();
	}

	/**
	 * Return the rule name for a keyword, which is the keyword enclosed in
	 * single quotes
	 *
	 * @param keyword
	 *            the keyword
	 * @return the rule name for the keyword
	 */
	public static String keyword(final String keyword) {
		return new StringBuilder("'").append(keyword).append("'").toString();
	}

	/**
	 * check that input is treated as a keyword by the grammar
	 */
	public void checkKeyword(final String input) {
		this.checkTokenisation(input, LexerAndParserTest.keyword(input));
	}

	/**
	 * check that input is not treated as a keyword by the grammar
	 */
	public void failKeyword(final String keyword) {
		final List<Token> tokens = this.getTokens(keyword);
		Assert.assertEquals(keyword, 1, tokens.size());
		final String type = this.getTokenType(tokens.get(0));
		Assert.assertFalse(keyword, type.charAt(0) == '\'');
	}

	public void outputTokens(final String input) {
		final List<Token> tokens = this.getTokens(input);
		for (int i = 0; i < tokens.size(); i++) {
			final Token token = tokens.get(i);
			final String tokenType = this.getTokenType(token);
			final int tokenChannel = token.getChannel();
			MyLog.trace(LexerAndParserTest.class, "tokenType='" + tokenType
					+ "' token=" + token + "' channel='" + tokenChannel + "'");
		}
	}
}
