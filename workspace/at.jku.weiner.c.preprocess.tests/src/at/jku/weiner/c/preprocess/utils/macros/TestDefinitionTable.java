package at.jku.weiner.c.preprocess.utils.macros;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

import at.jku.weiner.c.preprocess.preprocess.PreprocessFactory;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.ReplaceLine;
import at.jku.weiner.c.preprocess.tests.PreprocessInjectorProvider;
import at.jku.weiner.c.preprocess.utils.LexerUtils;
import at.jku.weiner.c.preprocess.utils.macros.DefinitionTable;

@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class TestDefinitionTable {
	private final PreprocessFactory factory = PreprocessFactory.eINSTANCE;
	private IdentifierList list1;
	private IdentifierList list2;
	private EList<ReplaceLine> replaceLines1;
	private EList<ReplaceLine> replaceLines2;

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
		this.replaceLines1 = new BasicEList<ReplaceLine>();
		this.replaceLines2 = new BasicEList<ReplaceLine>();
		
	}

	@After
	public void after() {
		this.definitionTable.reset();
		Assert.assertEquals(0, this.definitionTable.size());
	}

	@Test(timeout = 1000)
	public void test00() {
		final String id = "ID";
		final String replaceWith = "replace with";

		this.definitionTable.add(id, replaceWith);
		Assert.assertEquals(1, this.definitionTable.size());
		this.definitionTable.add(id, replaceWith);
		Assert.assertEquals(1, this.definitionTable.size());
	}

	@Test(timeout = 1000)
	public void test01() {
		final String replaceWith = "replace with";

		this.definitionTable.add("ID1", replaceWith);
		Assert.assertEquals(1, this.definitionTable.size());
		this.definitionTable.add("ID2", replaceWith);
		Assert.assertEquals(2, this.definitionTable.size());
	}

	@Test(expected = IllegalArgumentException.class, timeout = 1000)
	public void test02() {
		final String id = "ID";

		this.definitionTable.add(id, "replace with");
		Assert.assertEquals(1, this.definitionTable.size());
		this.definitionTable.add(id, "something else");
	}

	@Test(timeout = 1000)
	public void test03() {
		final String id = "ID";
		final String replaceWith = "replace with";
		final ReplaceLine line = this.factory.createReplaceLine();
		line.setString(replaceWith);
		this.replaceLines1.add(line);
		this.definitionTable.addFunctionMacro(id, this.list1,
				this.replaceLines1);
		Assert.assertEquals(1, this.definitionTable.size());
		this.definitionTable.addFunctionMacro(id, this.list2,
				this.replaceLines1);
		Assert.assertEquals(1, this.definitionTable.size());
	}

	@Test(timeout = 1000)
	public void test04() {
		final String id = "ID";
		final String replaceWith = "replace with";
		final String paramName = "paramName";

		this.list1.getId().add(paramName);
		this.list2.getId().add(paramName);

		final ReplaceLine line = this.factory.createReplaceLine();
		line.setString(replaceWith);
		this.replaceLines1.add(line);

		this.definitionTable.addFunctionMacro(id, this.list1,
				this.replaceLines1);
		Assert.assertEquals(1, this.definitionTable.size());
		this.definitionTable.addFunctionMacro(id, this.list2,
				this.replaceLines1);
		Assert.assertEquals(1, this.definitionTable.size());
	}

	@Test(expected = IllegalArgumentException.class, timeout = 1000)
	public void test05() {
		final String id = "ID";
		final String replace = "replace with";
		
		this.definitionTable.add(id, replace);
		Assert.assertEquals(1, this.definitionTable.size());

		final ReplaceLine line = this.factory.createReplaceLine();
		line.setString(replace);
		this.replaceLines1.add(line);
		this.definitionTable.addFunctionMacro(id, this.list1,
				this.replaceLines1);
	}

	@Test(expected = IllegalArgumentException.class, timeout = 1000)
	public void test06() {
		final String id = "ID";
		final String replace = "replace with";
		final ReplaceLine line = this.factory.createReplaceLine();
		line.setString(replace);
		this.replaceLines1.add(line);

		this.definitionTable.addFunctionMacro(id, this.list1,
				this.replaceLines1);
		Assert.assertEquals(1, this.definitionTable.size());
		this.definitionTable.add(id, replace);
	}

	@Test(expected = IllegalArgumentException.class, timeout = 1000)
	public void test07() {
		final String id = "ID";

		final ReplaceLine line = this.factory.createReplaceLine();
		line.setString("replace with");
		this.replaceLines1.add(line);

		this.definitionTable.addFunctionMacro(id, this.list1,
				this.replaceLines1);
		Assert.assertEquals(1, this.definitionTable.size());
		this.replaceLines1 = new BasicEList<ReplaceLine>();
		
		final ReplaceLine line2 = this.factory.createReplaceLine();
		line2.setString("replace with something else");
		this.replaceLines2.add(line2);

		this.definitionTable.addFunctionMacro(id, this.list2,
				this.replaceLines2);
	}

	@Test(expected = IllegalArgumentException.class, timeout = 1000)
	public void test08() {
		final String id = "ID";
		final String replace = "replace with";

		this.list2.getId().add("aParam");
		
		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString(replace);
		this.replaceLines1.add(line1);

		this.definitionTable.addFunctionMacro(id, this.list1,
				this.replaceLines1);
		Assert.assertEquals(1, this.definitionTable.size());
		this.definitionTable.addFunctionMacro(id, this.list2,
				this.replaceLines1);
	}

	@Test(expected = IllegalArgumentException.class, timeout = 1000)
	public void test09() {
		final String id = "ID";
		final String replace = "replace with";

		this.list1.getId().add("aParam");
		this.list2.getId().add("bParam");

		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString(replace);
		this.replaceLines1.add(line1);
		
		this.definitionTable.addFunctionMacro(id, this.list1,
				this.replaceLines1);
		Assert.assertEquals(1, this.definitionTable.size());
		this.definitionTable.addFunctionMacro(id, this.list2,
				this.replaceLines1);
	}

	@Test(timeout = 1000)
	public void test10() {
		final String id = "ID";
		final String replace = "replace with";

		this.list1.getId().add("aParam");
		this.list2.getId().add("aParam");
		this.list1.getId().add("bParam");
		this.list2.getId().add("bParam");
		this.list1.getId().add("cParam");
		this.list2.getId().add("cParam");
		
		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString(replace);
		this.replaceLines1.add(line1);

		this.definitionTable.addFunctionMacro(id, this.list1,
				this.replaceLines1);
		Assert.assertEquals(1, this.definitionTable.size());
		this.definitionTable.addFunctionMacro(id, this.list2,
				this.replaceLines1);
		Assert.assertEquals(1, this.definitionTable.size());
	}

	@Test(timeout = 1000)
	public void test11() {
		final String id = "ID";
		final String replace = "replace with";

		this.list1 = null;
		this.list2 = null;

		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString(replace);
		this.replaceLines1.add(line1);

		this.definitionTable.addFunctionMacro(id, this.list1,
				this.replaceLines1);
		Assert.assertEquals(1, this.definitionTable.size());
		this.definitionTable.addFunctionMacro(id, this.list2,
				this.replaceLines1);
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
		final String resolve = this.definitionTable.fullResolve(code);
		Assert.assertEquals("a little red fox looks at you!", resolve);
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		Assert.assertTrue(this.definitionTable.containsAKey(resolve));
		final String resolve2 = this.definitionTable.fullResolve(resolve);
		Assert.assertEquals("a little red cat looks at you!", resolve2);
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		Assert.assertTrue(this.definitionTable.containsAKey(resolve));
		Assert.assertFalse(this.definitionTable.containsAKey(resolve2));
	}

	@Test(timeout = 1000)
	public void testContainsAKeyAndResolve4() {
		final String code = "a little penguin() looks at you!";
		this.definitionTable.add("fox", "cat");
		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString("red fox");
		this.replaceLines1.add(line1);
		this.definitionTable.addFunctionMacro("penguin", null,
				this.replaceLines1);
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
		final String resolve = this.definitionTable.fullResolve(code);
		Assert.assertEquals("a little red fox looks at you!", resolve);
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		Assert.assertTrue(this.definitionTable.containsAKey(resolve));
		final String resolve2 = this.definitionTable.fullResolve(resolve);
		Assert.assertEquals("a little red firefox looks at you!", resolve2);
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		Assert.assertTrue(this.definitionTable.containsAKey(resolve));
		Assert.assertFalse(this.definitionTable.containsAKey(resolve2));
	}

	@Test(timeout = 1000)
	public void testContainsAKeyAndResolve6() {
		final String code = "a little penguin looks at you!";
		final String code2 = "a little penguin() looks at you!";
		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString("red fox");
		this.replaceLines1.add(line1);
		this.definitionTable.addFunctionMacro("penguin", null,
				this.replaceLines1);
		this.definitionTable.add("fox", "firefox");
		Assert.assertFalse(this.definitionTable.containsAKey(code));
		Assert.assertTrue(this.definitionTable.containsAKey(code2));
		final String resolve = this.definitionTable.fullResolve(code2);
		Assert.assertFalse(this.definitionTable.containsAKey(code));
		Assert.assertTrue(this.definitionTable.containsAKey(code2));
		Assert.assertFalse(this.definitionTable.containsAKey(resolve));
		final String resolve2 = this.definitionTable.fullResolve(resolve);
		Assert.assertEquals(resolve, resolve2);
		Assert.assertFalse(this.definitionTable.containsAKey(code));
		Assert.assertTrue(this.definitionTable.containsAKey(code2));
		Assert.assertFalse(this.definitionTable.containsAKey(resolve));
		Assert.assertFalse(this.definitionTable.containsAKey(resolve2));
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
		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString("red fox");
		this.replaceLines1.add(line1);
		this.definitionTable.addFunctionMacro("penguin", null,
				this.replaceLines1);
		this.definitionTable.add("fox", "cat");

		Assert.assertFalse(this.definitionTable.containsAKey(code));
		Assert.assertTrue(this.definitionTable.containsAKey(code2));
		final String resolve0 = this.definitionTable.fullResolve(code);
		Assert.assertEquals("a little penguin looks at you!", resolve0);
		final String resolve1 = this.definitionTable.fullResolve(code2);
		Assert.assertEquals("a little red cat looks at you!", resolve1);
		Assert.assertFalse(this.definitionTable.containsAKey(code));
		Assert.assertTrue(this.definitionTable.containsAKey(code2));
		Assert.assertFalse(this.definitionTable.containsAKey(resolve1));
		final String resolve2 = this.definitionTable.fullResolve(resolve1);
		Assert.assertFalse(this.definitionTable.containsAKey(code));
		Assert.assertTrue(this.definitionTable.containsAKey(code2));
		Assert.assertFalse(this.definitionTable.containsAKey(resolve1));
		Assert.assertFalse(this.definitionTable.containsAKey(resolve2));
		Assert.assertEquals(resolve1, resolve2);
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
		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString("firefox");
		this.replaceLines1.add(line1);
		this.definitionTable.addFunctionMacro("penguin", null,
				this.replaceLines1);
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
		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString("x");
		this.replaceLines1.add(line1);
		this.definitionTable.addFunctionMacro("penguin", list,
				this.replaceLines1);
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
		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString("x \"penguin()\"");
		this.replaceLines1.add(line1);
		this.definitionTable.addFunctionMacro("penguin", list,
				this.replaceLines1);
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
		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString("x \"x\"");
		this.replaceLines1.add(line1);
		this.definitionTable.addFunctionMacro("penguin", list,
				this.replaceLines1);
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		final String result = this.definitionTable.fullResolve(code);
		Assert.assertEquals(
				"a little \"penguin()\" firefox \"x\" \"penguin\" looks at you!",
				result);
		Assert.assertTrue(this.definitionTable.containsAKey(code));
		Assert.assertFalse(this.definitionTable.containsAKey(result));

	}

}
