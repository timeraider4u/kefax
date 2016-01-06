package at.jku.weiner.c.preprocess.mytests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.jku.weiner.c.preprocess.preprocess.PreprocessFactory;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.ReplaceLine;
import at.jku.weiner.c.preprocess.utils.macros.DefinitionTable;

public class TestDefinitionTable {
	private final PreprocessFactory factory = PreprocessFactory.eINSTANCE;
	private IdentifierList list1;
	private IdentifierList list2;
	private EList<ReplaceLine> replaceLines1;
	private EList<ReplaceLine> replaceLines2;

	@Before
	public void setUp() {
		DefinitionTable.reset();
		Assert.assertEquals(0, DefinitionTable.size());
		this.list1 = this.factory.createIdentifierList();
		this.list2 = this.factory.createIdentifierList();
		this.replaceLines1 = new BasicEList<ReplaceLine>();
		this.replaceLines2 = new BasicEList<ReplaceLine>();

	}
	
	@After
	public void after() {
		DefinitionTable.reset();
		Assert.assertEquals(0, DefinitionTable.size());
	}
	
	@Test
	public void test00() {
		final String id = "ID";
		final String replaceWith = "replace with";
		
		DefinitionTable.add(id, replaceWith);
		Assert.assertEquals(1, DefinitionTable.size());
		DefinitionTable.add(id, replaceWith);
		Assert.assertEquals(1, DefinitionTable.size());
	}
	
	@Test
	public void test01() {
		final String replaceWith = "replace with";
		
		DefinitionTable.add("ID1", replaceWith);
		Assert.assertEquals(1, DefinitionTable.size());
		DefinitionTable.add("ID2", replaceWith);
		Assert.assertEquals(2, DefinitionTable.size());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test02() {
		final String id = "ID";
		
		DefinitionTable.add(id, "replace with");
		Assert.assertEquals(1, DefinitionTable.size());
		DefinitionTable.add(id, "something else");
	}
	
	public void test03() {
		final String id = "ID";
		final String replaceWith = "replace with";
		final ReplaceLine line = this.factory.createReplaceLine();
		line.setString(replaceWith);
		this.replaceLines1.add(line);
		DefinitionTable.addFunctionMacro(id, this.list1, this.replaceLines1);
		Assert.assertEquals(1, DefinitionTable.size());
		DefinitionTable.addFunctionMacro(id, this.list2, this.replaceLines1);
		Assert.assertEquals(1, DefinitionTable.size());
	}
	
	public void test04() {
		final String id = "ID";
		final String replaceWith = "replace with";
		final String paramName = "paramName";
		
		this.list1.getId().add(paramName);
		this.list2.getId().add(paramName);
		
		final ReplaceLine line = this.factory.createReplaceLine();
		line.setString(replaceWith);
		this.replaceLines1.add(line);
		
		DefinitionTable.addFunctionMacro(id, this.list1, this.replaceLines1);
		Assert.assertEquals(1, DefinitionTable.size());
		DefinitionTable.addFunctionMacro(id, this.list2, this.replaceLines1);
		Assert.assertEquals(1, DefinitionTable.size());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test05() {
		final String id = "ID";
		final String replace = "replace with";

		DefinitionTable.add(id, replace);
		Assert.assertEquals(1, DefinitionTable.size());
		
		final ReplaceLine line = this.factory.createReplaceLine();
		line.setString(replace);
		this.replaceLines1.add(line);
		DefinitionTable.addFunctionMacro(id, this.list1, this.replaceLines1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test06() {
		final String id = "ID";
		final String replace = "replace with";
		final ReplaceLine line = this.factory.createReplaceLine();
		line.setString(replace);
		this.replaceLines1.add(line);
		
		DefinitionTable.addFunctionMacro(id, this.list1, this.replaceLines1);
		Assert.assertEquals(1, DefinitionTable.size());
		DefinitionTable.add(id, replace);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test07() {
		final String id = "ID";
		
		final ReplaceLine line = this.factory.createReplaceLine();
		line.setString("replace with");
		this.replaceLines1.add(line);
		
		DefinitionTable.addFunctionMacro(id, this.list1, this.replaceLines1);
		Assert.assertEquals(1, DefinitionTable.size());
		this.replaceLines1 = new BasicEList<ReplaceLine>();

		final ReplaceLine line2 = this.factory.createReplaceLine();
		line2.setString("replace with something else");
		this.replaceLines2.add(line2);
		
		DefinitionTable.addFunctionMacro(id, this.list2, this.replaceLines2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test08() {
		final String id = "ID";
		final String replace = "replace with";
		
		this.list2.getId().add("aParam");

		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString(replace);
		this.replaceLines1.add(line1);
		
		DefinitionTable.addFunctionMacro(id, this.list1, this.replaceLines1);
		Assert.assertEquals(1, DefinitionTable.size());
		DefinitionTable.addFunctionMacro(id, this.list2, this.replaceLines1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test09() {
		final String id = "ID";
		final String replace = "replace with";
		
		this.list1.getId().add("aParam");
		this.list2.getId().add("bParam");
		
		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString(replace);
		this.replaceLines1.add(line1);

		DefinitionTable.addFunctionMacro(id, this.list1, this.replaceLines1);
		Assert.assertEquals(1, DefinitionTable.size());
		DefinitionTable.addFunctionMacro(id, this.list2, this.replaceLines1);
	}
	
	@Test
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
		
		DefinitionTable.addFunctionMacro(id, this.list1, this.replaceLines1);
		Assert.assertEquals(1, DefinitionTable.size());
		DefinitionTable.addFunctionMacro(id, this.list2, this.replaceLines1);
		Assert.assertEquals(1, DefinitionTable.size());
	}
	
	@Test
	public void test11() {
		final String id = "ID";
		final String replace = "replace with";
		
		this.list1 = null;
		this.list2 = null;
		
		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString(replace);
		this.replaceLines1.add(line1);
		
		DefinitionTable.addFunctionMacro(id, this.list1, this.replaceLines1);
		Assert.assertEquals(1, DefinitionTable.size());
		DefinitionTable.addFunctionMacro(id, this.list2, this.replaceLines1);
		Assert.assertEquals(1, DefinitionTable.size());
	}
	
	@Test
	public void testMatches1() {
		final String regex = "\\bfox\\b";
		final String text = "a little fox looks at you!";
		
		final Pattern pattern = Pattern.compile(regex);
		final Matcher matcher = pattern.matcher(text);
		
		final boolean match = matcher.find();
		Assert.assertTrue(match);
	}
	
	@Test
	public void testMatches2() {
		final String regex = "\\bfox\\b";
		final String text = "a little firefox looks at you!";
		
		final Pattern pattern = Pattern.compile(regex);
		final Matcher matcher = pattern.matcher(text);
		
		final boolean match = matcher.find();
		Assert.assertFalse(match);
	}
	
	@Test
	public void testContainsAKeyAndResolve1() {
		Assert.assertFalse(DefinitionTable
				.containsAKey("a little penguin looks at you!"));
	}
	
	@Test
	public void testContainsAKeyAndResolve2() {
		final String code = "a little penguin looks at you!";
		DefinitionTable.add("penguin", "red fox");
		Assert.assertTrue(DefinitionTable.containsAKey(code));
		final String resolve = DefinitionTable.resolve(code);
		Assert.assertTrue(DefinitionTable.containsAKey(code));
		Assert.assertFalse(DefinitionTable.containsAKey(resolve));
	}
	
	@Test
	public void testContainsAKeyAndResolve3() {
		final String code = "a little penguin looks at you!";
		DefinitionTable.add("fox", "cat");
		DefinitionTable.add("penguin", "red fox");
		Assert.assertTrue(DefinitionTable.containsAKey(code));
		final String resolve = DefinitionTable.resolve(code);
		Assert.assertEquals("a little red fox looks at you!", resolve);
		Assert.assertTrue(DefinitionTable.containsAKey(code));
		Assert.assertTrue(DefinitionTable.containsAKey(resolve));
		final String resolve2 = DefinitionTable.resolve(resolve);
		Assert.assertEquals("a little red cat looks at you!", resolve2);
		Assert.assertTrue(DefinitionTable.containsAKey(code));
		Assert.assertTrue(DefinitionTable.containsAKey(resolve));
		Assert.assertFalse(DefinitionTable.containsAKey(resolve2));
	}
	
	@Test
	public void testContainsAKeyAndResolve4() {
		final String code = "a little penguin() looks at you!";
		DefinitionTable.add("fox", "cat");
		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString("red fox");
		this.replaceLines1.add(line1);
		DefinitionTable.addFunctionMacro("penguin", null, this.replaceLines1);
		Assert.assertTrue(DefinitionTable.containsAKey(code));
		final String resolve = DefinitionTable.resolve(code);
		Assert.assertEquals("a little red fox looks at you!", resolve);
		Assert.assertTrue(DefinitionTable.containsAKey(code));
		Assert.assertTrue(DefinitionTable.containsAKey(resolve));
		final String resolve2 = DefinitionTable.resolve(resolve);
		Assert.assertEquals("a little red cat looks at you!", resolve2);
		Assert.assertTrue(DefinitionTable.containsAKey(code));
		Assert.assertTrue(DefinitionTable.containsAKey(resolve));
		Assert.assertFalse(DefinitionTable.containsAKey(resolve2));
	}
	
	@Test
	public void testContainsAKeyAndResolve5() {
		final String code = "a little penguin looks at you!";
		DefinitionTable.add("fox", "firefox");
		DefinitionTable.add("penguin", "red fox");
		Assert.assertTrue(DefinitionTable.containsAKey(code));
		final String resolve = DefinitionTable.resolve(code);
		Assert.assertEquals("a little red fox looks at you!", resolve);
		Assert.assertTrue(DefinitionTable.containsAKey(code));
		Assert.assertTrue(DefinitionTable.containsAKey(resolve));
		final String resolve2 = DefinitionTable.resolve(resolve);
		Assert.assertEquals("a little red firefox looks at you!", resolve2);
		Assert.assertTrue(DefinitionTable.containsAKey(code));
		Assert.assertTrue(DefinitionTable.containsAKey(resolve));
		Assert.assertFalse(DefinitionTable.containsAKey(resolve2));
	}
	
	@Test
	public void testContainsAKeyAndResolve6() {
		final String code = "a little penguin looks at you!";
		final String code2 = "a little penguin() looks at you!";
		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString("red fox");
		this.replaceLines1.add(line1);
		DefinitionTable.addFunctionMacro("penguin", null, this.replaceLines1);
		DefinitionTable.add("fox", "firefox");
		Assert.assertFalse(DefinitionTable.containsAKey(code));
		Assert.assertTrue(DefinitionTable.containsAKey(code2));
		final String resolve = DefinitionTable.resolve(code2);
		Assert.assertFalse(DefinitionTable.containsAKey(code));
		Assert.assertTrue(DefinitionTable.containsAKey(code2));
		Assert.assertFalse(DefinitionTable.containsAKey(resolve));
		final String resolve2 = DefinitionTable.resolve(resolve);
		Assert.assertEquals(resolve, resolve2);
		Assert.assertFalse(DefinitionTable.containsAKey(code));
		Assert.assertTrue(DefinitionTable.containsAKey(code2));
		Assert.assertFalse(DefinitionTable.containsAKey(resolve));
		Assert.assertFalse(DefinitionTable.containsAKey(resolve2));
	}
	
	@Test
	public void testContainsAKeyAndResolve7() {
		final String code = "a little penguin looks at you!";
		DefinitionTable.add("penguin", "red fox");
		DefinitionTable.add("fox", "cat");
		Assert.assertTrue(DefinitionTable.containsAKey(code));
		final String resolve = DefinitionTable.resolve(code);
		Assert.assertEquals("a little red cat looks at you!", resolve);
		Assert.assertTrue(DefinitionTable.containsAKey(code));
		Assert.assertFalse(DefinitionTable.containsAKey(resolve));
		final String resolve2 = DefinitionTable.resolve(resolve);
		Assert.assertTrue(DefinitionTable.containsAKey(code));
		Assert.assertFalse(DefinitionTable.containsAKey(resolve));
		Assert.assertFalse(DefinitionTable.containsAKey(resolve2));
		Assert.assertEquals("a little red cat looks at you!", resolve2);
	}
	
	@Test
	public void testContainsAKeyAndResolve8() {
		final String code = "a little penguin looks at you!";
		final String code2 = "a little penguin() looks at you!";
		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString("red fox");
		this.replaceLines1.add(line1);
		DefinitionTable.addFunctionMacro("penguin", null, this.replaceLines1);
		DefinitionTable.add("fox", "cat");
		
		Assert.assertFalse(DefinitionTable.containsAKey(code));
		Assert.assertTrue(DefinitionTable.containsAKey(code2));
		final String resolve0 = DefinitionTable.resolve(code);
		Assert.assertEquals("a little penguin looks at you!", resolve0);
		final String resolve1 = DefinitionTable.resolve(code2);
		Assert.assertEquals("a little red cat looks at you!", resolve1);
		Assert.assertFalse(DefinitionTable.containsAKey(code));
		Assert.assertTrue(DefinitionTable.containsAKey(code2));
		Assert.assertFalse(DefinitionTable.containsAKey(resolve1));
		final String resolve2 = DefinitionTable.resolve(resolve1);
		Assert.assertFalse(DefinitionTable.containsAKey(code));
		Assert.assertTrue(DefinitionTable.containsAKey(code2));
		Assert.assertFalse(DefinitionTable.containsAKey(resolve1));
		Assert.assertFalse(DefinitionTable.containsAKey(resolve2));
		Assert.assertEquals(resolve1, resolve2);
	}
	
	@Test
	public void testContainsAKeyAndResolve9() {
		final String code = "a little \"penguin\" looks at you!";
		DefinitionTable.add("penguin", "firefox");
		Assert.assertFalse(DefinitionTable.containsAKey(code));
		final String result = DefinitionTable.resolve(code);
		Assert.assertEquals(code, result);
	}
	
	@Test
	public void testContainsAKeyAndResolve10() {
		// note the substring "penguin" which is a string literal
		// inside this string literal
		final String code = "a little \"penguin()\" looks at you!";
		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString("firefox");
		this.replaceLines1.add(line1);
		DefinitionTable.addFunctionMacro("penguin", null, this.replaceLines1);
		Assert.assertFalse(DefinitionTable.containsAKey(code));
		final String result = DefinitionTable.resolve(code);
		Assert.assertFalse(DefinitionTable.containsAKey(code));
		Assert.assertFalse(DefinitionTable.containsAKey(result));
		Assert.assertEquals(code, result);
	}
	
	@Test
	public void testContainsAKeyAndResolve11() {
		final String code = "a little \"penguin(firefox)\" looks at you!";
		final IdentifierList list = PreprocessFactory.eINSTANCE
				.createIdentifierList();
		list.getId().add("x");
		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString("x");
		this.replaceLines1.add(line1);
		DefinitionTable.addFunctionMacro("penguin", list, this.replaceLines1);
		Assert.assertFalse(DefinitionTable.containsAKey(code));
		final String result = DefinitionTable.resolve(code);
		Assert.assertEquals(code, result);
	}
	
	@Test
	public void testContainsAKeyAndResolve12() {
		final String code = "a little penguin(firefox) looks at you!";
		final IdentifierList list = PreprocessFactory.eINSTANCE
				.createIdentifierList();
		list.getId().add("x");
		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString("x \"penguin()\"");
		this.replaceLines1.add(line1);
		DefinitionTable.addFunctionMacro("penguin", list, this.replaceLines1);
		Assert.assertTrue(DefinitionTable.containsAKey(code));
		final String result = DefinitionTable.resolve(code);
		Assert.assertEquals("a little firefox \"penguin()\" looks at you!",
				result);
		Assert.assertFalse(DefinitionTable.containsAKey(result));
	}
	
	@Test
	public void testContainsAKeyAndResolve13() {
		final String code = "a little \"penguin()\" penguin(firefox) \"penguin\" looks at you!";
		final IdentifierList list = PreprocessFactory.eINSTANCE
				.createIdentifierList();
		list.getId().add("x");
		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString("x \"x\"");
		this.replaceLines1.add(line1);
		DefinitionTable.addFunctionMacro("penguin", list, this.replaceLines1);
		Assert.assertTrue(DefinitionTable.containsAKey(code));
		final String result = DefinitionTable.resolve(code);
		Assert.assertEquals(
				"a little \"penguin()\" firefox \"x\" \"penguin\" looks at you!",
				result);
		Assert.assertTrue(DefinitionTable.containsAKey(code));
		Assert.assertFalse(DefinitionTable.containsAKey(result));
		
	}
	
}
