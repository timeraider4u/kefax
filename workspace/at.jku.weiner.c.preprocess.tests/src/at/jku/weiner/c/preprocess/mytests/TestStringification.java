package at.jku.weiner.c.preprocess.mytests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.jku.weiner.c.preprocess.cPreprocess.CPreprocessFactory;
import at.jku.weiner.c.preprocess.cPreprocess.IdentifierList;
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
		final IdentifierList list = CPreprocessFactory.eINSTANCE
				.createIdentifierList();
		list.getId().add("X");
		DefinitionTable.addFunctionMacro("FOO", "X #X", list);
		final String code = "FOO(5)";
		final String replace = DefinitionTable.resolve(code);
		Assert.assertEquals("5 \"5\"", replace);
	}

	@Test
	public void testStringification2() {
		final IdentifierList list = CPreprocessFactory.eINSTANCE
				.createIdentifierList();
		list.getId().add("X");
		DefinitionTable.addFunctionMacro("FOO", "X #X X #X", list);
		final String code = "FOO(5)";
		final String replace = DefinitionTable.resolve(code);
		Assert.assertEquals("5 \"5\" 5 \"5\"", replace);
	}

}
