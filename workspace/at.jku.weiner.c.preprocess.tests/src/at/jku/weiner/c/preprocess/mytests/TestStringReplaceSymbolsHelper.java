package at.jku.weiner.c.preprocess.mytests;

import org.junit.Assert;
import org.junit.Test;

import at.jku.weiner.c.preprocess.utils.StringLiteralInStringLiteralsHelper;
import at.jku.weiner.c.preprocess.utils.macros.StringReplaceSymbolsHelper;
import at.jku.weiner.c.preprocess.utils.macros.StringReplaceSymbolsHelperDefaultReplace;

public class TestStringReplaceSymbolsHelper {

	@Test
	public void test00() {
		final String text = "A little penguin looks at you!";
		final String symbol = "penguin";
		final String replacement = "red fox";
		final StringReplaceSymbolsHelper helper = new StringReplaceSymbolsHelperDefaultReplace(
				symbol, replacement);
		StringLiteralInStringLiteralsHelper.iterate(text, helper);
		final String actual = helper.getText();
		Assert.assertEquals("A little red fox looks at you!", actual);
	}

	@Test
	public void test01() {
		final String text = "\"A little penguin looks at you!\", said a penguin researcher.";
		final String symbol = "penguin";
		final String replacement = "red fox";

		final StringReplaceSymbolsHelper helper = new StringReplaceSymbolsHelperDefaultReplace(
				symbol, replacement);
		StringLiteralInStringLiteralsHelper.iterate(text, helper);
		final String actual = helper.getText();
		Assert.assertEquals(
				"\"A little penguin looks at you!\", said a red fox researcher.",
				actual);
	}

	@Test
	public void test02() {
		final String text = "Foo bar, \"\\\"Foo bar\\\"\", \\Foo bar";
		final String symbol = "Foo";
		final String replacement = "Bar";
		final StringReplaceSymbolsHelper helper = new StringReplaceSymbolsHelperDefaultReplace(
				symbol, replacement);
		StringLiteralInStringLiteralsHelper.iterate(text, helper);
		final String actual = helper.getText();
		Assert.assertEquals("Bar bar, \"\\\"Foo bar\\\"\", \\Bar bar", actual);
	}

	@Test
	public void test03() {
		final String text = "Foo bar, \\\"\\\"Foo bar\\\"\\\", \\Foo bar";
		final String symbol = "Foo";
		final String replacement = "Bar";
		final StringReplaceSymbolsHelper helper = new StringReplaceSymbolsHelperDefaultReplace(
				symbol, replacement);
		StringLiteralInStringLiteralsHelper.iterate(text, helper);
		final String actual = helper.getText();
		Assert.assertEquals("Bar bar, \\\"\\\"Bar bar\\\"\\\", \\Bar bar",
				actual);
	}

	@Test
	public void test04() {
		final String text = "Foo bar, \"\"Foo bar\"\", \\\\Foo bar";
		final String symbol = "Foo";
		final String replacement = "Bar";
		final StringReplaceSymbolsHelper helper = new StringReplaceSymbolsHelperDefaultReplace(
				symbol, replacement);
		StringLiteralInStringLiteralsHelper.iterate(text, helper);
		final String actual = helper.getText();
		Assert.assertEquals("Bar bar, \"\"Bar bar\"\", \\\\Bar bar", actual);
	}

	@Test
	public void test05() {
		final String text = "foo = \"foo\" + \"with \\\"escaped foo\" + \"foo\" and foo;";
		final String symbol = "foo";
		final String replacement = "Bar";
		final StringReplaceSymbolsHelper helper = new StringReplaceSymbolsHelperDefaultReplace(
				symbol, replacement);
		StringLiteralInStringLiteralsHelper.iterate(text, helper);
		final String actual = helper.getText();
		Assert.assertEquals(
				"Bar = \"foo\" + \"with \\\"escaped foo\" + \"foo\" and Bar;",
				actual);
	}

	@Test
	public void test06() {
		final String text = "A little penguin looks at äöüÄÖÜß?!";
		final String symbol = "äöüÄÖÜß";
		final String replacement = "you";
		final StringReplaceSymbolsHelper helper = new StringReplaceSymbolsHelperDefaultReplace(
				symbol, replacement);
		StringLiteralInStringLiteralsHelper.iterate(text, helper);
		final String actual = helper.getText();
		Assert.assertEquals("A little penguin looks at you?!", actual);
	}

	@Test
	public void test07() {
		final String text = "A little penguin2 looks at you!";
		final String symbol = "penguin";
		final String replacement = "red fox";
		final StringReplaceSymbolsHelper helper = new StringReplaceSymbolsHelperDefaultReplace(
				symbol, replacement);
		StringLiteralInStringLiteralsHelper.iterate(text, helper);
		final String actual = helper.getText();
		Assert.assertEquals("A little penguin2 looks at you!", actual);
	}

	@Test
	public void test08() {
		final String text = "A little penguin looks at you!";
		final String symbol = "penguin2";
		final String replacement = "red fox";
		final StringReplaceSymbolsHelper helper = new StringReplaceSymbolsHelperDefaultReplace(
				symbol, replacement);
		StringLiteralInStringLiteralsHelper.iterate(text, helper);
		final String actual = helper.getText();
		Assert.assertEquals("A little penguin looks at you!", actual);
	}

	@Test
	public void test09() {
		final String text = "A little penguin looks at äöüÄÖÜ_ß1!";
		final String symbol = "äöüÄÖÜ_ß1";
		final String replacement = "you";
		final StringReplaceSymbolsHelper helper = new StringReplaceSymbolsHelperDefaultReplace(
				symbol, replacement);
		StringLiteralInStringLiteralsHelper.iterate(text, helper);
		final String actual = helper.getText();
		Assert.assertEquals("A little penguin looks at you!", actual);
	}

	@Test
	public void test10() {
		final String text = "A little penguin2 looks at you!";
		final String symbol = "penguin2";
		final String replacement = "red fox";
		final StringReplaceSymbolsHelper helper = new StringReplaceSymbolsHelperDefaultReplace(
				symbol, replacement);
		StringLiteralInStringLiteralsHelper.iterate(text, helper);
		final String actual = helper.getText();
		Assert.assertEquals("A little red fox looks at you!", actual);
	}

}
