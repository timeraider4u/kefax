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
		Assert.assertEquals(4, helper.getIndex());
		Assert.assertFalse(helper.hasMoreParams());
	}

	@Test
	public void test01() {
		final MacroParentheseHelper helper = new MacroParentheseHelper(
				"3, (5));", 0);
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("3", helper.getNextParam());
		Assert.assertEquals(2, helper.getIndex());
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("(5)", helper.getNextParam());
		Assert.assertEquals(7, helper.getIndex());
		Assert.assertFalse(helper.hasMoreParams());
	}

	@Test
	public void test02() {
		final MacroParentheseHelper helper = new MacroParentheseHelper(
				"(3), ((5), (3)), (3, (3), ((5))) );", 0);
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("(3)", helper.getNextParam());
		Assert.assertEquals(4, helper.getIndex());
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("((5), (3))", helper.getNextParam());
		Assert.assertEquals(16, helper.getIndex());

		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("(3, (3), ((5)))", helper.getNextParam());
		Assert.assertEquals(34, helper.getIndex());

		Assert.assertFalse(helper.hasMoreParams());
	}

	@Test
	public void test03() {
		final MacroParentheseHelper helper = new MacroParentheseHelper(");", 0);
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("", helper.getNextParam());
		Assert.assertEquals(1, helper.getIndex());
		Assert.assertFalse(helper.hasMoreParams());
	}

	@Test
	public void test04() {
		final MacroParentheseHelper helper = new MacroParentheseHelper(",());",
				0);
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("", helper.getNextParam());
		Assert.assertEquals(1, helper.getIndex());
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("()", helper.getNextParam());
		Assert.assertEquals(4, helper.getIndex());
		Assert.assertFalse(helper.hasMoreParams());
	}

	@Test
	public void testA() {
		final MacroParentheseHelper helper = new MacroParentheseHelper("bar);",
				0);
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("bar", helper.getNextParam());
		Assert.assertEquals(4, helper.getIndex());
		Assert.assertFalse(helper.hasMoreParams());
	}

	@Test
	public void testB() {
		final MacroParentheseHelper helper = new MacroParentheseHelper(
				"0,bar);", 0);
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("0", helper.getNextParam());
		Assert.assertEquals(2, helper.getIndex());
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("bar", helper.getNextParam());
		Assert.assertEquals(6, helper.getIndex());
		Assert.assertFalse(helper.hasMoreParams());
	}

	@Test
	public void testC() {
		final MacroParentheseHelper helper = new MacroParentheseHelper(
				"((bar)));", 0);
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("((bar))", helper.getNextParam());
		Assert.assertEquals(8, helper.getIndex());
		Assert.assertFalse(helper.hasMoreParams());
	}

	@Test
	public void testD() {
		final MacroParentheseHelper helper = new MacroParentheseHelper(
				"(0),(bar));", 0);
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("(0)", helper.getNextParam());
		Assert.assertEquals(4, helper.getIndex());
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("(bar)", helper.getNextParam());
		Assert.assertEquals(10, helper.getIndex());
		Assert.assertFalse(helper.hasMoreParams());
	}

	@Test
	public void testE() {
		final MacroParentheseHelper helper = new MacroParentheseHelper(
				"0,bar)(1);", 0);
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("0", helper.getNextParam());
		Assert.assertEquals(2, helper.getIndex());
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("bar", helper.getNextParam());
		Assert.assertEquals(6, helper.getIndex());
		Assert.assertFalse(helper.hasMoreParams());
	}

	@Test
	public void testF() {
		final MacroParentheseHelper helper = new MacroParentheseHelper(
				"0)(1);", 0);
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("0", helper.getNextParam());
		Assert.assertEquals(2, helper.getIndex());
		Assert.assertFalse(helper.hasMoreParams());
	}

	@Test
	public void testG() {
		final MacroParentheseHelper helper = new MacroParentheseHelper(
				" (a,b))", 0);
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("(a,b)", helper.getNextParam());
		Assert.assertEquals(7, helper.getIndex());
		Assert.assertFalse(helper.hasMoreParams());
	}

	@Test
	public void testH() {
		final MacroParentheseHelper helper = new MacroParentheseHelper(
				" (0,b),bar)", 0);
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("(0,b)", helper.getNextParam());
		Assert.assertEquals(7, helper.getIndex());
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("bar", helper.getNextParam());
		Assert.assertEquals(11, helper.getIndex());
		Assert.assertFalse(helper.hasMoreParams());
	}

	@Test
	public void testI() {
		final MacroParentheseHelper helper = new MacroParentheseHelper(
				"1,(bar,b))", 0);
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("1", helper.getNextParam());
		Assert.assertEquals(2, helper.getIndex());
		Assert.assertTrue(helper.hasMoreParams());
		Assert.assertEquals("(bar,b)", helper.getNextParam());
		Assert.assertEquals(10, helper.getIndex());
		Assert.assertFalse(helper.hasMoreParams());
	}
}
