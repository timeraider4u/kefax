package at.jku.weiner.c.preprocess.mytests;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import at.jku.weiner.c.preprocess.preprocess.PreprocessFactory;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.ReplaceLine;
import at.jku.weiner.c.preprocess.utils.macros.DefinitionTable;

public class TestStringification {
	
	private final PreprocessFactory factory = PreprocessFactory.eINSTANCE;
	private EList<ReplaceLine> replaceLines;

	@Before
	public void setUp() {
		DefinitionTable.reset();
		this.replaceLines = new BasicEList<ReplaceLine>();
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
		final ReplaceLine line = this.factory.createReplaceLine();
		line.setString("X");
		line.setId("X");
		this.replaceLines.add(line);
		DefinitionTable.addFunctionMacro("FOO", list, this.replaceLines);
		final String code = "FOO(5)";
		final String replace = DefinitionTable.resolve(code);
		Assert.assertEquals("5 \"5\"", replace);
	}

	@Test
	public void testStringification2() {
		final IdentifierList list = PreprocessFactory.eINSTANCE
				.createIdentifierList();
		list.getId().add("X");

		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString("X");
		line1.setId("X");
		this.replaceLines.add(line1);
		final ReplaceLine line2 = this.factory.createReplaceLine();
		line2.setString("X");
		line2.setId("X");
		this.replaceLines.add(line2);
		final ReplaceLine line3 = this.factory.createReplaceLine();
		line3.setString("X");
		line3.setId("X");
		this.replaceLines.add(line3);
		DefinitionTable.addFunctionMacro("FOO", list, this.replaceLines);
		final String code = "FOO( 56 )";
		final String replace = DefinitionTable.resolve(code);
		Assert.assertEquals("56 \"56\" 56 \"56\" 56 \"56\"", replace);
	}

	@Test
	public void testStringification3() {
		final IdentifierList list = PreprocessFactory.eINSTANCE
				.createIdentifierList();
		list.getId().add("AB");

		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString("AB");
		line1.setId("AB");
		this.replaceLines.add(line1);
		final ReplaceLine line2 = this.factory.createReplaceLine();
		line2.setString("AB");
		line2.setId("AB");
		this.replaceLines.add(line2);
		DefinitionTable.addFunctionMacro("FOO", list, this.replaceLines);
		final String code = "FOO(57)";
		final String replace = DefinitionTable.resolve(code);
		Assert.assertEquals("57 \"57\" 57 \"57\"", replace);
	}
	
	@Test
	@Ignore
	public void testStringification4() {
		final IdentifierList list = PreprocessFactory.eINSTANCE
				.createIdentifierList();
		list.getId().add("AB");
		// DefinitionTable
		// .addFunctionMacro(
		// "FOO",
		// "AB##AB, AB-#AB (AB##AB), #AB, \"# AB, AB ## AB\", AB # AB, AB ## AB",
		// list);
		final String code = "FOO(57)";
		final String replace = DefinitionTable.resolve(code);
		Assert.assertEquals(
				"5757, 57-\"57\" (5757), \"57\", \"# AB, AB ## AB\", 57 \"57\", 5757",
				replace);
	}
	
}
