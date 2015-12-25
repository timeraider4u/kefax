package at.jku.weiner.c.preprocess.mytests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.jku.weiner.c.preprocess.preprocess.PreprocessFactory;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.utils.macros.DefinitionTable;

public class TestStringification {
	
	@Before
	public void setUp() {
		DefinitionTable.reset();
	}
	
	@After
	public void cleanUp() {
		DefinitionTable.reset();
	}
	
	@Test
	public void testStringification1() {
		final IdentifierList list = PreprocessFactory.eINSTANCE
				.createIdentifierList();
		list.getId().add("X");
		DefinitionTable.addFunctionMacro("FOO", "X #X", list);
		final String code = "FOO(5)";
		final String replace = DefinitionTable.resolve(code);
		Assert.assertEquals("5 \"5\"", replace);
	}
	
	@Test
	public void testStringification2() {
		final IdentifierList list = PreprocessFactory.eINSTANCE
				.createIdentifierList();
		list.getId().add("X");
		DefinitionTable.addFunctionMacro("FOO", "X #X X #X X #X", list);
		final String code = "FOO( 56 )";
		final String replace = DefinitionTable.resolve(code);
		Assert.assertEquals("56 \"56\" 56 \"56\" 56 \"56\"", replace);
	}
	
	@Test
	public void testStringification3() {
		final IdentifierList list = PreprocessFactory.eINSTANCE
				.createIdentifierList();
		list.getId().add("AB");
		DefinitionTable.addFunctionMacro("FOO", "AB # AB AB # 	 AB", list);
		final String code = "FOO(57)";
		final String replace = DefinitionTable.resolve(code);
		Assert.assertEquals("57 \"57\" 57 \"57\"", replace);
	}

	@Test
	public void testStringification4() {
		final IdentifierList list = PreprocessFactory.eINSTANCE
				.createIdentifierList();
		list.getId().add("AB");
		DefinitionTable
		.addFunctionMacro(
				"FOO",
				"AB##AB, AB-#AB (AB##AB), #AB, \"# AB, AB ## AB\", AB # AB, AB ## AB",
				list);
		final String code = "FOO(57)";
		final String replace = DefinitionTable.resolve(code);
		Assert.assertEquals(
				"5757, 57-\"57\" (5757), \"57\", \"# AB, AB ## AB\", 57 \"57\", 5757",
				replace);
	}

}
