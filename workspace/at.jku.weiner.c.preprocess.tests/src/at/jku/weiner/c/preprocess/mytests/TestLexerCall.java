package at.jku.weiner.c.preprocess.mytests;

import java.util.List;

import org.antlr.runtime.Token;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

import at.jku.weiner.c.preprocess.parser.antlr.internal.InternalPreprocessLexer;
import at.jku.weiner.c.preprocess.tests.PreprocessInjectorProvider;
import at.jku.weiner.c.preprocess.utils.LexerUtils;

@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class TestLexerCall {

	@Inject
	private InternalPreprocessLexer lexer;
	@Inject
	private ITokenDefProvider tokenDefProvider;
	
	private LexerUtils utils;

	@Before
	public void setUp() {
		Assert.assertNotNull(this.lexer);
		Assert.assertNotNull(this.tokenDefProvider);
		this.utils = new LexerUtils(this.lexer, this.tokenDefProvider);
		Assert.assertNotNull(this.utils);
	}

	@Test(timeout = 1000)
	public void test() {
		final String text = "FOO (bax,5);";
		final List<Token> tokens = this.utils.getTokens(text);
		Assert.assertNotNull(tokens);
		Assert.assertFalse(tokens.isEmpty());
		Assert.assertEquals(8, tokens.size());
		final Token id = tokens.get(0);
		Assert.assertEquals("FOO", id.getText());
		Assert.assertEquals(InternalPreprocessLexer.RULE_ID, id.getType());
		final Token ws = tokens.get(1);
		Assert.assertEquals(InternalPreprocessLexer.RULE_WHITESPACE,
				ws.getType());
		final Token left = tokens.get(2);
		Assert.assertEquals(InternalPreprocessLexer.RULE_SKW_LEFTPAREN,
				left.getType());
		final Token id2 = tokens.get(3);
		Assert.assertEquals(InternalPreprocessLexer.RULE_ID, id2.getType());
		final Token comma = tokens.get(4);
		Assert.assertEquals(InternalPreprocessLexer.RULE_SKW_COMMA,
				comma.getType());
		final Token dec = tokens.get(5);
		Assert.assertEquals(InternalPreprocessLexer.RULE_DECIMAL_LITERAL,
				dec.getType());
		final Token right = tokens.get(6);
		Assert.assertEquals(InternalPreprocessLexer.RULE_SKW_RIGHTPAREN,
				right.getType());
		final Token semi = tokens.get(7);
		Assert.assertEquals(InternalPreprocessLexer.RULE_SKW_SEMI,
				semi.getType());
	}

}
