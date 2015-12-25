package at.jku.weiner.c.preprocess.mytests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import at.jku.weiner.c.preprocess.utils.macros.DefinitionFunctionMacro;
import at.jku.weiner.c.preprocess.utils.macros.MacroParentheseNotClosedYetException;

public class TestMacroParentheseHelper {
	
	private final static String MACRO_NAME = "foo";
	private final static String VALUE = "X Y Z";

	@Test
	public void test00() {
		final List<String> params = new ArrayList<String>();
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME,
				TestMacroParentheseHelper.VALUE, params);

		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "();post";
		final String actual = macro.resolve(code);
		final String expected = "pre;X Y Z;post";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void test01() {
		final List<String> params = new ArrayList<String>();
		params.add("X");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME,
				TestMacroParentheseHelper.VALUE, params);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(55);post";
		final String actual = macro.resolve(code);
		final String expected = "pre;55 Y Z;post";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test02() {
		final List<String> params = new ArrayList<String>();
		params.add("X");
		params.add("Y");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME,
				TestMacroParentheseHelper.VALUE, params);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(3, (5));post";
		final String actual = macro.resolve(code);
		final String expected = "pre;3 (5) Z;post";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void test03Params() {
		final List<String> params = new ArrayList<String>();
		params.add("X");
		params.add("Y");
		params.add("Z");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME,
				TestMacroParentheseHelper.VALUE, params);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "((3), ((5), (3)), (3, (3), ((5))) );post";
		final String actual = macro.resolve(code);
		final String expected = "pre;(3) ((5), (3)) (3, (3), ((5)));post";
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = MacroParentheseNotClosedYetException.class)
	public void test03() {
		final List<String> params = new ArrayList<String>();
		params.add("X");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME,
				TestMacroParentheseHelper.VALUE, params);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(;post";
		macro.resolve(code);
	}

	@Test
	public void test04() {
		final List<String> params = new ArrayList<String>();
		params.add("X");
		params.add("Y");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME,
				TestMacroParentheseHelper.VALUE, params);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(A,());post";
		final String actual = macro.resolve(code);
		final String expected = "pre;A () Z;post";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testA() {
		final List<String> params = new ArrayList<String>();
		params.add("X");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME,
				TestMacroParentheseHelper.VALUE, params);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(bar);post";
		final String actual = macro.resolve(code);
		final String expected = "pre;bar Y Z;post";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testB() {
		final List<String> params = new ArrayList<String>();
		params.add("X");
		params.add("Y");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME,
				TestMacroParentheseHelper.VALUE, params);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(0,bar);post";
		final String actual = macro.resolve(code);
		final String expected = "pre;0 bar Z;post";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testC() {
		final List<String> params = new ArrayList<String>();
		params.add("X");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME,
				TestMacroParentheseHelper.VALUE, params);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(((bar)));post";
		final String actual = macro.resolve(code);
		final String expected = "pre;((bar)) Y Z;post";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testD() {
		final List<String> params = new ArrayList<String>();
		params.add("X");
		params.add("Y");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME,
				TestMacroParentheseHelper.VALUE, params);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "((0),(bar));post";
		final String actual = macro.resolve(code);
		final String expected = "pre;(0) (bar) Z;post";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testE() {
		final List<String> params = new ArrayList<String>();
		params.add("X");
		params.add("Y");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME,
				TestMacroParentheseHelper.VALUE, params);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(0,bar)(1);post";
		final String actual = macro.resolve(code);
		final String expected = "pre;0 bar Z(1);post";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testF() {
		final List<String> params = new ArrayList<String>();
		params.add("X");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME,
				TestMacroParentheseHelper.VALUE, params);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(0)(1);post";
		final String actual = macro.resolve(code);
		final String expected = "pre;0 Y Z(1);post";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testG() {
		final List<String> params = new ArrayList<String>();
		params.add("X");
		params.add("Y");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME,
				TestMacroParentheseHelper.VALUE, params);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ " (a,b);post";
		final String actual = macro.resolve(code);
		final String expected = "pre;a b Z;post";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testH() {
		final List<String> params = new ArrayList<String>();
		params.add("X");
		params.add("Y");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME,
				TestMacroParentheseHelper.VALUE, params);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ " ((0,b),bar);post";
		final String actual = macro.resolve(code);
		final String expected = "pre;(0,b) bar Z;post";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testI() {
		final List<String> params = new ArrayList<String>();
		params.add("X");
		params.add("Y");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME,
				TestMacroParentheseHelper.VALUE, params);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(1,(bar,b));post";
		final String actual = macro.resolve(code);
		final String expected = "pre;1 (bar,b) Z;post";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testJ() {
		final List<String> params = new ArrayList<String>();
		params.add("X");
		params.add("Y");
		params.add("Z");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME,
				TestMacroParentheseHelper.VALUE, params);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(foobar1,(foo1,bar2),(foobar2)) (foo2,bar2);post";
		final String actual = macro.resolve(code);
		final String expected = "pre;foobar1 (foo1,bar2) (foobar2) (foo2,bar2);post";
		Assert.assertEquals(expected, actual);
	}

}
