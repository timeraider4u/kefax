package at.jku.weiner.c.preprocess.mytests;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import at.jku.weiner.c.common.log.MyLog;
import at.jku.weiner.c.preprocess.parser.antlr.internal.InternalPreprocessLexer;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.PreprocessFactory;
import at.jku.weiner.c.preprocess.tests.PreprocessInjectorProvider;
import at.jku.weiner.c.preprocess.utils.LexerUtils;
import at.jku.weiner.c.preprocess.utils.macros.DefinitionTable;
import at.jku.weiner.c.preprocess.utils.macros.MacroParentheseNotClosedYetException;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class TestMacroParentheseHelper {

	private final static String MACRO_NAME = "foo";
	private final static String VALUE = "X Y Z";
	private final static PreprocessFactory factory = PreprocessFactory.eINSTANCE;
	private String replaceLine;

	@Inject
	private InternalPreprocessLexer lexer;
	@Inject
	private ITokenDefProvider tokenDefProvider;

	private DefinitionTable definitionTable;

	@Before
	public void setUp() {
		MyLog.setLog_level(MyLog.LOG_NONE);
		final LexerUtils lexerUtils = new LexerUtils(this.lexer,
				this.tokenDefProvider);
		this.definitionTable = new DefinitionTable(lexerUtils);
		this.definitionTable.reset();

		this.replaceLine = TestMacroParentheseHelper.VALUE;
	}

	@Test(timeout = 1000)
	public void test00() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		this.definitionTable.addFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLine);

		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "();post";
		final String actual = this.definitionTable.fullResolve(code);
		final String expected = "pre;X Y Z;post";
		Assert.assertEquals(expected, actual);
	}

	@Test(timeout = 1000)
	public void test01() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		this.definitionTable.addFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLine);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(55);post";
		final String actual = this.definitionTable.fullResolve(code);
		final String expected = "pre;55 Y Z;post";
		Assert.assertEquals(expected, actual);
	}

	@Test(timeout = 1000)
	public void test02() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		params.getId().add("Y");
		this.definitionTable.addFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLine);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(3, (5));post";
		final String actual = this.definitionTable.fullResolve(code);
		final String expected = "pre;3 (5) Z;post";
		Assert.assertEquals(expected, actual);
	}

	@Test(timeout = 1000)
	public void test03Params() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		params.getId().add("Y");
		params.getId().add("Z");
		this.definitionTable.addFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLine);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "((3), ((5), (3)), (3, (3), ((5))) );post";
		final String actual = this.definitionTable.fullResolve(code);
		final String expected = "pre;(3) ((5), (3)) (3, (3), ((5)));post";
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = MacroParentheseNotClosedYetException.class, timeout = 1000)
	public void test03() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		this.definitionTable.addFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLine);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(;post";
		this.definitionTable.fullResolve(code);
	}

	@Test(timeout = 1000)
	public void test04() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		params.getId().add("Y");
		this.definitionTable.addFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLine);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(A,());post";
		final String actual = this.definitionTable.fullResolve(code);
		final String expected = "pre;A () Z;post";
		Assert.assertEquals(expected, actual);
	}

	@Test(timeout = 1000)
	public void testA() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		this.definitionTable.addFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLine);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(bar);post";
		final String actual = this.definitionTable.fullResolve(code);
		final String expected = "pre;bar Y Z;post";
		Assert.assertEquals(expected, actual);
	}

	@Test(timeout = 1000)
	public void testB() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		params.getId().add("Y");
		this.definitionTable.addFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLine);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(0,bar);post";
		final String actual = this.definitionTable.fullResolve(code);
		final String expected = "pre;0 bar Z;post";
		Assert.assertEquals(expected, actual);
	}

	@Test(timeout = 1000)
	public void testC() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		this.definitionTable.addFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLine);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(((bar)));post";
		final String actual = this.definitionTable.fullResolve(code);
		final String expected = "pre;((bar)) Y Z;post";
		Assert.assertEquals(expected, actual);
	}

	@Test(timeout = 1000)
	public void testD() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		params.getId().add("Y");
		this.definitionTable.addFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLine);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "((0),(bar));post";
		final String actual = this.definitionTable.fullResolve(code);
		final String expected = "pre;(0) (bar) Z;post";
		Assert.assertEquals(expected, actual);
	}

	@Test(timeout = 1000)
	public void testE() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		params.getId().add("Y");
		this.definitionTable.addFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLine);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(0,bar)(1);post";
		final String actual = this.definitionTable.fullResolve(code);
		final String expected = "pre;0 bar Z(1);post";
		Assert.assertEquals(expected, actual);
	}

	@Test(timeout = 1000)
	public void testF() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		this.definitionTable.addFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLine);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(0)(1);post";
		final String actual = this.definitionTable.fullResolve(code);
		final String expected = "pre;0 Y Z(1);post";
		Assert.assertEquals(expected, actual);
	}

	@Test(timeout = 1000)
	public void testG() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		params.getId().add("Y");
		this.definitionTable.addFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLine);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ " (a,b);post";
		final String actual = this.definitionTable.fullResolve(code);
		final String expected = "pre;a b Z;post";
		Assert.assertEquals(expected, actual);
	}

	@Test(timeout = 1000)
	public void testH() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		params.getId().add("Y");
		this.definitionTable.addFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLine);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ " ((0,b),bar);post";
		final String actual = this.definitionTable.fullResolve(code);
		final String expected = "pre;(0,b) bar Z;post";
		Assert.assertEquals(expected, actual);
	}

	@Test(timeout = 1000)
	public void testI() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		params.getId().add("Y");
		this.definitionTable.addFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLine);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(1,(bar,b));post";
		final String actual = this.definitionTable.fullResolve(code);
		final String expected = "pre;1 (bar,b) Z;post";
		Assert.assertEquals(expected, actual);
	}

	@Test(timeout = 1000)
	public void testJ() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		params.getId().add("Y");
		params.getId().add("Z");
		this.definitionTable.addFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLine);
		final String code = "pre;" + TestMacroParentheseHelper.MACRO_NAME
				+ "(foobar1,(foo1,bar2),(foobar2)) (foo2,bar2);post";
		final String actual = this.definitionTable.fullResolve(code);
		final String expected = "pre;foobar1 (foo1,bar2) (foobar2) (foo2,bar2);post";
		Assert.assertEquals(expected, actual);
	}

	@Test(timeout = 1000)
	public void testK() {
		final IdentifierList params = TestMacroParentheseHelper.factory
				.createIdentifierList();
		params.getId().add("X");
		params.getId().add("Y");
		params.getId().add("Z");
		this.definitionTable.addFunctionMacro(
				TestMacroParentheseHelper.MACRO_NAME, params, this.replaceLine);
		final String code = "pre;"
				+ TestMacroParentheseHelper.MACRO_NAME
				+ "(((((foobar1)))),((((foo1,bar2)))),((((foobar2) (foo2,bar2)))));post";
		final String actual = this.definitionTable.fullResolve(code);
		final String expected = "pre;((((foobar1)))) ((((foo1,bar2)))) ((((foobar2) (foo2,bar2))));post";
		Assert.assertEquals(expected, actual);
	}

}
