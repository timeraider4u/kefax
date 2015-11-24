package at.jku.weiner.cpreprocess.mytests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.jku.weiner.cpreprocess.cPreprocess.CPreprocessFactory;
import at.jku.weiner.cpreprocess.cPreprocess.IdentifierList;
import at.jku.weiner.cpreprocess.utils.macros.DefinitionTable;

public class TestDefinitionTable {
	private IdentifierList list1;
	private IdentifierList list2;

	@Before
	public void setUp() {
		DefinitionTable.reset();
		Assert.assertEquals(0, DefinitionTable.size());
		this.list1 = CPreprocessFactory.eINSTANCE.createIdentifierList();
		this.list2 = CPreprocessFactory.eINSTANCE.createIdentifierList();
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

		DefinitionTable.addFunctionMacro(id, replaceWith, this.list1);
		Assert.assertEquals(1, DefinitionTable.size());
		DefinitionTable.addFunctionMacro(id, replaceWith, this.list2);
		Assert.assertEquals(1, DefinitionTable.size());
	}

	public void test04() {
		final String id = "ID";
		final String replaceWith = "replace with";
		final String paramName = "paramName";

		this.list1.getId().add(paramName);
		this.list2.getId().add(paramName);

		DefinitionTable.addFunctionMacro(id, replaceWith, this.list1);
		Assert.assertEquals(1, DefinitionTable.size());
		DefinitionTable.addFunctionMacro(id, replaceWith, this.list2);
		Assert.assertEquals(1, DefinitionTable.size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test05() {
		final String id = "ID";
		final String replace = "replace with";

		DefinitionTable.add(id, replace);
		Assert.assertEquals(1, DefinitionTable.size());
		DefinitionTable.addFunctionMacro(id, replace, this.list1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test06() {
		final String id = "ID";
		final String replace = "replace with";

		DefinitionTable.addFunctionMacro(id, replace, this.list1);
		Assert.assertEquals(1, DefinitionTable.size());
		DefinitionTable.add(id, replace);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test07() {
		final String id = "ID";

		DefinitionTable.addFunctionMacro(id, "replace with", this.list1);
		Assert.assertEquals(1, DefinitionTable.size());
		DefinitionTable.addFunctionMacro(id, "replace with something else",
				this.list2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test08() {
		final String id = "ID";
		final String replace = "replace with";

		this.list2.getId().add("aParam");

		DefinitionTable.addFunctionMacro(id, replace, this.list1);
		Assert.assertEquals(1, DefinitionTable.size());

		DefinitionTable.addFunctionMacro(id, replace, this.list2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test09() {
		final String id = "ID";
		final String replace = "replace with";

		this.list1.getId().add("aParam");
		this.list2.getId().add("bParam");

		DefinitionTable.addFunctionMacro(id, replace, this.list1);
		Assert.assertEquals(1, DefinitionTable.size());
		DefinitionTable.addFunctionMacro(id, replace, this.list2);
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

		DefinitionTable.addFunctionMacro(id, replace, this.list1);
		Assert.assertEquals(1, DefinitionTable.size());
		DefinitionTable.addFunctionMacro(id, replace, this.list2);
		Assert.assertEquals(1, DefinitionTable.size());
	}

	@Test
	public void test11() {
		final String id = "ID";
		final String replace = "replace with";

		this.list1 = null;
		this.list2 = null;

		DefinitionTable.addFunctionMacro(id, replace, this.list1);
		Assert.assertEquals(1, DefinitionTable.size());
		DefinitionTable.addFunctionMacro(id, replace, this.list2);
		Assert.assertEquals(1, DefinitionTable.size());
	}
}
