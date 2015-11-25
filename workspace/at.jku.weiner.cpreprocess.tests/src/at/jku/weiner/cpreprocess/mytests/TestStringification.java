package at.jku.weiner.cpreprocess.mytests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.jku.weiner.cpreprocess.cPreprocess.CPreprocessFactory;
import at.jku.weiner.cpreprocess.cPreprocess.IdentifierList;
import at.jku.weiner.cpreprocess.utils.macros.DefinitionTable;

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

}
