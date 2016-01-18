package at.jku.weiner.c.preprocess.mytests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

import at.jku.weiner.c.preprocess.tests.PreprocessInjectorProvider;
import at.jku.weiner.c.preprocess.utils.LexerUtils;
import at.jku.weiner.c.preprocess.utils.macros.DefinitionTable;

@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class TestStringReplaceSymbolsHelper {

	@Inject
	private Lexer lexer;
	@Inject
	private ITokenDefProvider tokenDefProvider;
	
	private DefinitionTable definitionTable;
	
	@Before
	public void setUp() {
		final LexerUtils lexerUtils = new LexerUtils(this.lexer,
				this.tokenDefProvider);
		this.definitionTable = new DefinitionTable(lexerUtils);
		this.definitionTable.reset();
	}

	@Test(timeout = 1000)
	public void testSimplePattern() {
		final String text = "FOO \"FOO\" FOO \"FOO\" FOO";
		final Pattern pattern = Pattern.compile("\\bFOO\\b");
		final Matcher matcher = pattern.matcher(text);
		Assert.assertTrue(matcher.find(0));
		int index = matcher.start();
		Assert.assertTrue(matcher.find(0));
		Assert.assertEquals(0, index);
		Assert.assertTrue(matcher.find(1));
		index = matcher.start();
		Assert.assertEquals(5, index);
		Assert.assertTrue(matcher.find(6));
		index = matcher.start();
		Assert.assertEquals(10, index);
		Assert.assertTrue(matcher.find(11));
		index = matcher.start();
		Assert.assertEquals(15, index);
		Assert.assertTrue(matcher.find(16));
		index = matcher.start();
		Assert.assertEquals(20, index);
		Assert.assertFalse(matcher.find(21));
	}

	@Test(timeout = 1000)
	public void test00() {
		final String text = "A little penguin looks at you!";
		final String symbol = "penguin";
		final String replacement = "red fox";
		this.definitionTable.add(symbol, replacement);
		final String actual = this.definitionTable.fullResolve(text);
		Assert.assertEquals("A little red fox looks at you!", actual);
	}

	@Test(timeout = 1000)
	public void test01() {
		final String text = "\"A little penguin looks at you!\", said a penguin researcher.";
		final String symbol = "penguin";
		final String replacement = "red fox";

		this.definitionTable.add(symbol, replacement);
		final String actual = this.definitionTable.fullResolve(text);
		Assert.assertEquals(
				"\"A little penguin looks at you!\", said a red fox researcher.",
				actual);
	}

	@Test(timeout = 1000)
	public void test02() {
		final String text = "Foo bar, \"\\\"Foo bar\\\"\", \\Foo bar";
		final String symbol = "Foo";
		final String replacement = "Bar";
		this.definitionTable.add(symbol, replacement);
		final String actual = this.definitionTable.fullResolve(text);
		Assert.assertEquals("Bar bar, \"\\\"Foo bar\\\"\", \\Bar bar", actual);
	}

	@Test(timeout = 1000)
	public void test04() {
		final String text = "Foo bar, \"\"Foo bar\"\", \\\\Foo bar";
		final String symbol = "Foo";
		final String replacement = "Bar";
		this.definitionTable.add(symbol, replacement);
		final String actual = this.definitionTable.fullResolve(text);
		Assert.assertEquals("Bar bar, \"\"Bar bar\"\", \\\\Bar bar", actual);
	}

	@Test(timeout = 1000)
	public void test05() {
		final String text = "foo = \"foo\" + \"with \\\"escaped foo\" + \"foo\" and foo;";
		final String symbol = "foo";
		final String replacement = "Bar";
		this.definitionTable.add(symbol, replacement);
		final String actual = this.definitionTable.fullResolve(text);
		Assert.assertEquals(
				"Bar = \"foo\" + \"with \\\"escaped foo\" + \"foo\" and Bar;",
				actual);
	}

	@Test(timeout = 1000)
	public void test06() {
		final String text = "A little penguin looks at aeo_oe?!";
		final String symbol = "aeo_oe";
		final String replacement = "you";
		this.definitionTable.add(symbol, replacement);
		final String actual = this.definitionTable.fullResolve(text);
		Assert.assertEquals("A little penguin looks at you?!", actual);
	}

	@Test(timeout = 1000)
	public void test07() {
		final String text = "A little penguin2 looks at you!";
		final String symbol = "penguin";
		final String replacement = "red fox";
		this.definitionTable.add(symbol, replacement);
		final String actual = this.definitionTable.fullResolve(text);
		Assert.assertEquals("A little penguin2 looks at you!", actual);
	}

	@Test(timeout = 1000)
	public void test08() {
		final String text = "A little penguin looks at you!";
		final String symbol = "penguin2";
		final String replacement = "red fox";
		this.definitionTable.add(symbol, replacement);
		final String actual = this.definitionTable.fullResolve(text);
		Assert.assertEquals("A little penguin looks at you!", actual);
	}

	@Test(timeout = 1000)
	public void test09() {
		final String text = "A little penguin looks at ae1_2_b_3!";
		final String symbol = "ae1_2_b_3";
		final String replacement = "you";
		this.definitionTable.add(symbol, replacement);
		final String actual = this.definitionTable.fullResolve(text);
		Assert.assertEquals("A little penguin looks at you!", actual);
	}

	@Test(timeout = 1000)
	public void test10() {
		final String text = "A little penguin2 looks at you!";
		final String symbol = "penguin2";
		final String replacement = "red fox";
		this.definitionTable.add(symbol, replacement);
		final String actual = this.definitionTable.fullResolve(text);
		Assert.assertEquals("A little red fox looks at you!", actual);
	}

}
