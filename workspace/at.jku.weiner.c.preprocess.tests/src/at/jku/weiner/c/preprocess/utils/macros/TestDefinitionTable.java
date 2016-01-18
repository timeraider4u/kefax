package at.jku.weiner.c.preprocess.utils.macros;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.PreprocessFactory;
import at.jku.weiner.c.preprocess.tests.PreprocessInjectorProvider;
import at.jku.weiner.c.preprocess.utils.LexerUtils;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class TestDefinitionTable {
	private final PreprocessFactory factory = PreprocessFactory.eINSTANCE;
	private IdentifierList list1;
	private IdentifierList list2;
	private String id1;
	private String id2;
	private String replaceLine1;
	private String replaceLine2;

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
		Assert.assertEquals(0, this.definitionTable.size());
		this.list1 = this.factory.createIdentifierList();
		this.list2 = this.factory.createIdentifierList();
		this.id1 = "ID1";
		this.id2 = "ID2";
		this.replaceLine1 = "replace with";
		this.replaceLine2 = "something else";

	}

	@After
	public void after() {
		this.definitionTable.reset();
		Assert.assertEquals(0, this.definitionTable.size());
	}

	@Test(timeout = 1000)
	public void test00() {
		this.definitionTable.add(this.id1, this.replaceLine1);
		Assert.assertEquals(1, this.definitionTable.size());
		this.definitionTable.add(this.id1, this.replaceLine1);
		Assert.assertEquals(1, this.definitionTable.size());
	}

	@Test(timeout = 1000)
	public void test01() {
		this.definitionTable.add(this.id1, this.replaceLine1);
		Assert.assertEquals(1, this.definitionTable.size());
		this.definitionTable.add(this.id2, this.replaceLine1);
		Assert.assertEquals(2, this.definitionTable.size());
	}

	@Test(expected = IllegalArgumentException.class, timeout = 1000)
	public void test02() {
		this.definitionTable.add(this.id1, this.replaceLine1);
		Assert.assertEquals(1, this.definitionTable.size());
		this.definitionTable.add(this.id1, this.replaceLine2);
	}

	@Test(timeout = 1000)
	public void test03() {
		this.definitionTable.addFunctionMacro(this.id1, this.list1,
				this.replaceLine1);
		Assert.assertEquals(1, this.definitionTable.size());
		this.definitionTable.addFunctionMacro(this.id1, this.list2,
				this.replaceLine1);
		Assert.assertEquals(1, this.definitionTable.size());
	}

	@Test(timeout = 1000)
	public void test04() {
		final String paramName = "paramName";

		this.list1.getId().add(paramName);
		this.list2.getId().add(paramName);

		this.definitionTable.addFunctionMacro(this.id1, this.list1,
				this.replaceLine1);
		Assert.assertEquals(1, this.definitionTable.size());
		this.definitionTable.addFunctionMacro(this.id1, this.list2,
				this.replaceLine1);
		Assert.assertEquals(1, this.definitionTable.size());
	}

	@Test(expected = IllegalArgumentException.class, timeout = 1000)
	public void test05() {

		this.definitionTable.add(this.id1, this.replaceLine1);
		Assert.assertEquals(1, this.definitionTable.size());
		this.definitionTable.addFunctionMacro(this.id1, this.list1,
				this.replaceLine1);
	}

	@Test(expected = IllegalArgumentException.class, timeout = 1000)
	public void test06() {
		this.definitionTable.addFunctionMacro(this.id1, this.list1,
				this.replaceLine1);
		Assert.assertEquals(1, this.definitionTable.size());
		this.definitionTable.add(this.id1, this.replaceLine1);
	}

	@Test(expected = IllegalArgumentException.class, timeout = 1000)
	public void test07() {
		this.definitionTable.addFunctionMacro(this.id1, this.list1,
				this.replaceLine1);
		Assert.assertEquals(1, this.definitionTable.size());
		this.definitionTable.addFunctionMacro(this.id1, this.list2,
				this.replaceLine2);
	}

	@Test(expected = IllegalArgumentException.class, timeout = 1000)
	public void test08() {
		this.list2.getId().add("aParam");
		this.definitionTable.addFunctionMacro(this.id1, this.list1,
				this.replaceLine1);
		Assert.assertEquals(1, this.definitionTable.size());
		this.definitionTable.addFunctionMacro(this.id1, this.list2,
				this.replaceLine1);
	}

	@Test(expected = IllegalArgumentException.class, timeout = 1000)
	public void test09() {
		this.list1.getId().add("aParam");
		this.list2.getId().add("bParam");

		this.definitionTable.addFunctionMacro(this.id1, this.list1,
				this.replaceLine1);
		Assert.assertEquals(1, this.definitionTable.size());
		this.definitionTable.addFunctionMacro(this.id1, this.list2,
				this.replaceLine1);
	}

	@Test(timeout = 1000)
	public void test10() {
		this.list1.getId().add("aParam");
		this.list2.getId().add("aParam");
		this.list1.getId().add("bParam");
		this.list2.getId().add("bParam");
		this.list1.getId().add("cParam");
		this.list2.getId().add("cParam");

		this.definitionTable.addFunctionMacro(this.id1, this.list1,
				this.replaceLine1);
		Assert.assertEquals(1, this.definitionTable.size());
		this.definitionTable.addFunctionMacro(this.id1, this.list2,
				this.replaceLine1);
		Assert.assertEquals(1, this.definitionTable.size());
	}

	@Test(timeout = 1000)
	public void test11() {
		this.list1 = null;
		this.list2 = null;

		this.definitionTable.addFunctionMacro(this.id1, this.list1,
				this.replaceLine1);
		Assert.assertEquals(1, this.definitionTable.size());
		this.definitionTable.addFunctionMacro(this.id1, this.list2,
				this.replaceLine1);
		Assert.assertEquals(1, this.definitionTable.size());
	}

	@Test(timeout = 1000)
	public void testMatches1() {
		final String regex = "\\bfox\\b";
		final String text = "a little fox looks at you!";

		final Pattern pattern = Pattern.compile(regex);
		final Matcher matcher = pattern.matcher(text);

		final boolean match = matcher.find();
		Assert.assertTrue(match);
	}

	@Test(timeout = 1000)
	public void testMatches2() {
		final String regex = "\\bfox\\b";
		final String text = "a little firefox looks at you!";

		final Pattern pattern = Pattern.compile(regex);
		final Matcher matcher = pattern.matcher(text);

		final boolean match = matcher.find();
		Assert.assertFalse(match);
	}

	@Test(timeout = 1000)
	public void testContainsAKeyAndResolve1() {
		final String text = "a little penguin looks at you!";
		Assert.assertFalse(this.definitionTable.containsAKey(text));
	}

	@Test(timeout = 1000)
	public void testContainsAKeyAndResolve2() {
		final String code = "a little penguin looks at you!";
		this.definitionTable.add("penguin", "red fox");
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		final String resolve = this.definitionTable.fullResolve(code);
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		Assert.assertFalse(this.definitionTable.containsAKey(resolve));
	}

	@Test(timeout = 1000)
	public void testContainsAKeyAndResolve3() {
		final String code = "a little penguin looks at you!";
		this.definitionTable.add("fox", "cat");
		this.definitionTable.add("penguin", "red fox");
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		final String resolve2 = this.definitionTable.fullResolve(code);
		Assert.assertEquals("a little red cat looks at you!", resolve2);
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		Assert.assertFalse(this.definitionTable.containsAKey(resolve2));
	}

	@Test(timeout = 1000)
	public void testContainsAKeyAndResolve4() {
		final String code = "a little penguin() looks at you!";
		this.definitionTable.add("fox", "cat");
		this.replaceLine1 = "red fox";
		this.definitionTable.addFunctionMacro("penguin", null,
				this.replaceLine1);
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		final String resolve = this.definitionTable.fullResolve(code);
		Assert.assertEquals("a little red cat looks at you!", resolve);
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		Assert.assertFalse(this.definitionTable.containsAKey(resolve));
		final String resolve2 = this.definitionTable.fullResolve(resolve);
		Assert.assertEquals("a little red cat looks at you!", resolve2);
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		Assert.assertFalse(this.definitionTable.containsAKey(resolve));
		Assert.assertFalse(this.definitionTable.containsAKey(resolve2));
	}

	@Test(timeout = 1000)
	public void testContainsAKeyAndResolve5() {
		final String code = "a little penguin looks at you!";
		this.definitionTable.add("fox", "firefox");
		this.definitionTable.add("penguin", "red fox");
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		final String resolve2 = this.definitionTable.fullResolve(code);
		Assert.assertEquals("a little red firefox looks at you!", resolve2);
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		Assert.assertFalse(this.definitionTable.containsAKey(resolve2));
	}

	@Test(timeout = 1000)
	public void testContainsAKeyAndResolve6() {
		final String code = "a little penguin looks at you!";
		final String code2 = "a little penguin() looks at you!";
		this.replaceLine1 = "red fox";
		this.definitionTable.addFunctionMacro("penguin", null,
				this.replaceLine1);
		this.definitionTable.add("fox", "firefox");
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		Assert.assertTrue(this.definitionTable.containsAKey(code2));
		Assert.assertTrue(this.definitionTable.containsAKey(code2));
		this.definitionTable.fullResolve(code);
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		Assert.assertTrue(this.definitionTable.containsAKey(code2));
	}

	@Test(timeout = 1000)
	public void testContainsAKeyAndResolve7() {
		final String code = "a little penguin looks at you!";
		this.definitionTable.add("penguin", "red fox");
		this.definitionTable.add("fox", "cat");
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		final String resolve = this.definitionTable.fullResolve(code);
		Assert.assertEquals("a little red cat looks at you!", resolve);
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		Assert.assertFalse(this.definitionTable.containsAKey(resolve));
		final String resolve2 = this.definitionTable.fullResolve(resolve);
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		Assert.assertFalse(this.definitionTable.containsAKey(resolve));
		Assert.assertFalse(this.definitionTable.containsAKey(resolve2));
		Assert.assertEquals("a little red cat looks at you!", resolve2);
	}

	@Test(timeout = 1000)
	public void testContainsAKeyAndResolve8() {
		final String code = "a little penguin looks at you!";
		final String code2 = "a little penguin() looks at you!";
		this.replaceLine1 = "red fox";
		this.definitionTable.addFunctionMacro("penguin", null,
				this.replaceLine1);
		this.definitionTable.add("fox", "cat");

		Assert.assertTrue(this.definitionTable.containsAKey(code));
		Assert.assertTrue(this.definitionTable.containsAKey(code2));
		final String resolve2 = this.definitionTable.fullResolve(code);
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		Assert.assertTrue(this.definitionTable.containsAKey(code2));
		Assert.assertTrue(this.definitionTable.containsAKey(resolve2));
	}

	@Test(timeout = 1000)
	public void testContainsAKeyAndResolve9() {
		final String code = "a little \"penguin\" looks at you!";
		this.definitionTable.add("penguin", "firefox");
		Assert.assertFalse(this.definitionTable.containsAKey(code));
		final String result = this.definitionTable.fullResolve(code);
		Assert.assertEquals(code, result);
	}

	@Test(timeout = 1000)
	public void testContainsAKeyAndResolve10() {
		// note the substring "penguin" which is a string literal
		// inside this string literal
		final String code = "a little \"penguin()\" looks at you!";
		this.replaceLine1 = "firefox";
		this.definitionTable.addFunctionMacro("penguin", null,
				this.replaceLine1);
		Assert.assertFalse(this.definitionTable.containsAKey(code));
		final String result = this.definitionTable.fullResolve(code);
		Assert.assertFalse(this.definitionTable.containsAKey(code));
		Assert.assertFalse(this.definitionTable.containsAKey(result));
		Assert.assertEquals(code, result);
	}

	@Test(timeout = 1000)
	public void testContainsAKeyAndResolve11() {
		final String code = "a little \"penguin(firefox)\" looks at you!";
		final IdentifierList list = PreprocessFactory.eINSTANCE
				.createIdentifierList();
		list.getId().add("x");
		this.replaceLine1 = "x";
		this.definitionTable.addFunctionMacro("penguin", list,
				this.replaceLine1);
		Assert.assertFalse(this.definitionTable.containsAKey(code));
		final String result = this.definitionTable.fullResolve(code);
		Assert.assertEquals(code, result);
	}

	@Test(timeout = 1000)
	public void testContainsAKeyAndResolve12() {
		final String code = "a little penguin(firefox) looks at you!";
		final IdentifierList list = PreprocessFactory.eINSTANCE
				.createIdentifierList();
		list.getId().add("x");
		this.replaceLine1 = "x \"penguin()\"";
		this.definitionTable.addFunctionMacro("penguin", list,
				this.replaceLine1);
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		final String result = this.definitionTable.fullResolve(code);
		Assert.assertEquals("a little firefox \"penguin()\" looks at you!",
				result);
		Assert.assertFalse(this.definitionTable.containsAKey(result));
	}

	@Test(timeout = 1000)
	public void testContainsAKeyAndResolve13() {
		final String code = "a little \"penguin()\" penguin(firefox) \"penguin\" looks at you!";
		final IdentifierList list = PreprocessFactory.eINSTANCE
				.createIdentifierList();
		list.getId().add("x");
		this.replaceLine1 = "x \"x\"";
		this.definitionTable.addFunctionMacro("penguin", list,
				this.replaceLine1);
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		final String result = this.definitionTable.fullResolve(code);
		Assert.assertEquals(
				"a little \"penguin()\" firefox \"x\" \"penguin\" looks at you!",
				result);
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		Assert.assertFalse(this.definitionTable.containsAKey(result));

	}

}
