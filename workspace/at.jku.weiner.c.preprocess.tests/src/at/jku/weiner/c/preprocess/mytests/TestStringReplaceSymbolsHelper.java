package at.jku.weiner.c.preprocess.mytests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

import at.jku.weiner.c.preprocess.utils.macros.DefinitionObjectMacro;

public class TestStringReplaceSymbolsHelper {
	
	@Test
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
	
	@Test
	public void test00() {
		final String text = "A little penguin looks at you!";
		final String symbol = "penguin";
		final String replacement = "red fox";
		final DefinitionObjectMacro macro = new DefinitionObjectMacro(symbol,
				replacement);
		final String actual = macro.resolve(text);
		Assert.assertEquals("A little red fox looks at you!", actual);
	}
	
	@Test
	public void test01() {
		final String text = "\"A little penguin looks at you!\", said a penguin researcher.";
		final String symbol = "penguin";
		final String replacement = "red fox";
		
		final DefinitionObjectMacro macro = new DefinitionObjectMacro(symbol,
				replacement);
		final String actual = macro.resolve(text);
		Assert.assertEquals(
				"\"A little penguin looks at you!\", said a red fox researcher.",
				actual);
	}
	
	@Test
	public void test02() {
		final String text = "Foo bar, \"\\\"Foo bar\\\"\", \\Foo bar";
		final String symbol = "Foo";
		final String replacement = "Bar";
		final DefinitionObjectMacro macro = new DefinitionObjectMacro(symbol,
				replacement);
		final String actual = macro.resolve(text);
		Assert.assertEquals("Bar bar, \"\\\"Foo bar\\\"\", \\Bar bar", actual);
	}
	
	@Test
	public void test04() {
		final String text = "Foo bar, \"\"Foo bar\"\", \\\\Foo bar";
		final String symbol = "Foo";
		final String replacement = "Bar";
		final DefinitionObjectMacro macro = new DefinitionObjectMacro(symbol,
				replacement);
		final String actual = macro.resolve(text);
		Assert.assertEquals("Bar bar, \"\"Bar bar\"\", \\\\Bar bar", actual);
	}
	
	@Test
	public void test05() {
		final String text = "foo = \"foo\" + \"with \\\"escaped foo\" + \"foo\" and foo;";
		final String symbol = "foo";
		final String replacement = "Bar";
		final DefinitionObjectMacro macro = new DefinitionObjectMacro(symbol,
				replacement);
		final String actual = macro.resolve(text);
		Assert.assertEquals(
				"Bar = \"foo\" + \"with \\\"escaped foo\" + \"foo\" and Bar;",
				actual);
	}
	
	@Test
	public void test06() {
		final String text = "A little penguin looks at äöüÄÖÜß?!";
		final String symbol = "äöüÄÖÜß";
		final String replacement = "you";
		final DefinitionObjectMacro macro = new DefinitionObjectMacro(symbol,
				replacement);
		final String actual = macro.resolve(text);
		Assert.assertEquals("A little penguin looks at you?!", actual);
	}
	
	@Test
	public void test07() {
		final String text = "A little penguin2 looks at you!";
		final String symbol = "penguin";
		final String replacement = "red fox";
		final DefinitionObjectMacro macro = new DefinitionObjectMacro(symbol,
				replacement);
		final String actual = macro.resolve(text);
		Assert.assertEquals("A little penguin2 looks at you!", actual);
	}
	
	@Test
	public void test08() {
		final String text = "A little penguin looks at you!";
		final String symbol = "penguin2";
		final String replacement = "red fox";
		final DefinitionObjectMacro macro = new DefinitionObjectMacro(symbol,
				replacement);
		final String actual = macro.resolve(text);
		Assert.assertEquals("A little penguin looks at you!", actual);
	}
	
	@Test
	public void test09() {
		final String text = "A little penguin looks at äöüÄÖÜ_ß1!";
		final String symbol = "äöüÄÖÜ_ß1";
		final String replacement = "you";
		final DefinitionObjectMacro macro = new DefinitionObjectMacro(symbol,
				replacement);
		final String actual = macro.resolve(text);
		Assert.assertEquals("A little penguin looks at you!", actual);
	}
	
	@Test
	public void test10() {
		final String text = "A little penguin2 looks at you!";
		final String symbol = "penguin2";
		final String replacement = "red fox";
		final DefinitionObjectMacro macro = new DefinitionObjectMacro(symbol,
				replacement);
		final String actual = macro.resolve(text);
		Assert.assertEquals("A little red fox looks at you!", actual);
	}
	
}
