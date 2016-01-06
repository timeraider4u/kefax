package at.jku.weiner.c.preprocess.mytests;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.PreprocessFactory;
import at.jku.weiner.c.preprocess.preprocess.ReplaceLine;
import at.jku.weiner.c.preprocess.utils.macros.DefinitionFunctionMacro;
import at.jku.weiner.c.preprocess.utils.macros.MacroParentheseNotClosedYetException;

public class TestMacroParentheseHelper {
	
	private final static String MACRO_NAME = "foo";
	private final static String VALUE = "X Y Z";
	private final static PreprocessFactory factory = PreprocessFactory.eINSTANCE;
	private EList<ReplaceLine> replaceLines;

	@Before
	public void setUp() {
		this.replaceLines = new BasicEList<ReplaceLine>();
		final ReplaceLine line1 = TestMacroParentheseHelper.factory
				.createReplaceLine();
		line1.setString(TestMacroParentheseHelper.VALUE);
		this.replaceLines.add(line1);
		
	}
	
	@Test
	public void test00() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLines);
		
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "();post";
		final String actual = macro.resolve(code);
		final String expected = "pre;X Y Z;post";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void test01() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLines);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(55);post";
		final String actual = macro.resolve(code);
		final String expected = "pre;55 Y Z;post";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void test02() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		params.getId().add("Y");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLines);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(3, (5));post";
		final String actual = macro.resolve(code);
		final String expected = "pre;3 (5) Z;post";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void test03Params() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		params.getId().add("Y");
		params.getId().add("Z");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLines);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "((3), ((5), (3)), (3, (3), ((5))) );post";
		final String actual = macro.resolve(code);
		final String expected = "pre;(3) ((5), (3)) (3, (3), ((5)));post";
		Assert.assertEquals(expected, actual);
	}
	
	@Test(expected = MacroParentheseNotClosedYetException.class)
	public void test03() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLines);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(;post";
		macro.resolve(code);
	}
	
	@Test
	public void test04() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		params.getId().add("Y");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLines);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(A,());post";
		final String actual = macro.resolve(code);
		final String expected = "pre;A () Z;post";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testA() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLines);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(bar);post";
		final String actual = macro.resolve(code);
		final String expected = "pre;bar Y Z;post";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testB() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		params.getId().add("Y");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLines);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(0,bar);post";
		final String actual = macro.resolve(code);
		final String expected = "pre;0 bar Z;post";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testC() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLines);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(((bar)));post";
		final String actual = macro.resolve(code);
		final String expected = "pre;((bar)) Y Z;post";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testD() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		params.getId().add("Y");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLines);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "((0),(bar));post";
		final String actual = macro.resolve(code);
		final String expected = "pre;(0) (bar) Z;post";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testE() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		params.getId().add("Y");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLines);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(0,bar)(1);post";
		final String actual = macro.resolve(code);
		final String expected = "pre;0 bar Z(1);post";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testF() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLines);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(0)(1);post";
		final String actual = macro.resolve(code);
		final String expected = "pre;0 Y Z(1);post";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testG() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		params.getId().add("Y");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLines);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ " (a,b);post";
		final String actual = macro.resolve(code);
		final String expected = "pre;a b Z;post";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testH() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		params.getId().add("Y");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLines);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ " ((0,b),bar);post";
		final String actual = macro.resolve(code);
		final String expected = "pre;(0,b) bar Z;post";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testI() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		params.getId().add("Y");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLines);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(1,(bar,b));post";
		final String actual = macro.resolve(code);
		final String expected = "pre;1 (bar,b) Z;post";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testJ() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		params.getId().add("Y");
		params.getId().add("Z");
		final DefinitionFunctionMacro macro = new DefinitionFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLines);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(foobar1,(foo1,bar2),(foobar2)) (foo2,bar2);post";
		final String actual = macro.resolve(code);
		final String expected = "pre;foobar1 (foo1,bar2) (foobar2) (foo2,bar2);post";
		Assert.assertEquals(expected, actual);
	}
	
}
