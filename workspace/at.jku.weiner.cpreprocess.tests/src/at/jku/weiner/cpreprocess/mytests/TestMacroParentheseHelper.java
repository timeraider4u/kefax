package at.jku.weiner.cpreprocess.mytests;

import org.junit.Assert;
import org.junit.Test;

import at.jku.weiner.cpreprocess.generator.MacroParentheseHelper;

public class TestMacroParentheseHelper {

	@Test
	public void test00() {
		final MacroParentheseHelper helper = new MacroParentheseHelper("(5));",
				0);
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("(5)", helper.getNextParam());
		Assert.assertEquals(4, helper.getEndIndex());
		Assert.assertFalse(helper.hasMoreParams());
	}

	@Test
	public void test01() {
		final MacroParentheseHelper helper = new MacroParentheseHelper(
				"3, (5));", 0);
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("3", helper.getNextParam());
		Assert.assertEquals(2, helper.getEndIndex());
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("3", helper.getNextParam());
		Assert.assertEquals(7, helper.getEndIndex());
		Assert.assertFalse(helper.hasMoreParams());
	}

	@Test
	public void test02() {
		final MacroParentheseHelper helper = new MacroParentheseHelper(
				"(3), ((5), (3)), (3, (3), ((5))) );", 0);
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("(3)", helper.getNextParam());
		Assert.assertEquals(4, helper.getEndIndex());
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("((5), (3))", helper.getNextParam());
		Assert.assertEquals(16, helper.getEndIndex());

		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("(3, (3), ((5)))", helper.getNextParam());
		Assert.assertEquals(35, helper.getEndIndex());

		Assert.assertFalse(helper.hasMoreParams());
	}

	@Test
	public void test03() {
		final MacroParentheseHelper helper = new MacroParentheseHelper(");", 0);
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("", helper.getNextParam());
		Assert.assertEquals(1, helper.getEndIndex());
		Assert.assertFalse(helper.hasMoreParams());
	}

	@Test
	public void test04() {
		final MacroParentheseHelper helper = new MacroParentheseHelper(",());",
				0);
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("", helper.getNextParam());
		Assert.assertEquals(1, helper.getEndIndex());
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("()", helper.getNextParam());
		Assert.assertEquals(4, helper.getEndIndex());
		Assert.assertFalse(helper.hasMoreParams());
	}

}
