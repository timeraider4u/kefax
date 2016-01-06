package at.jku.weiner.c.preprocess.mytests;

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
		line.setString("X ");
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
		// define FOO(X) X #X X #X X #X
		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString("X ");
		line1.setId("X");
		this.replaceLines.add(line1);
		final ReplaceLine line2 = this.factory.createReplaceLine();
		line2.setString(" X ");
		line2.setId("X");
		this.replaceLines.add(line2);
		final ReplaceLine line3 = this.factory.createReplaceLine();
		line3.setString(" X ");
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
		line1.setString("AB ");
		line1.setId("AB");
		this.replaceLines.add(line1);
		final ReplaceLine line2 = this.factory.createReplaceLine();
		line2.setString(" AB ");
		line2.setId("AB");
		this.replaceLines.add(line2);
		DefinitionTable.addFunctionMacro("FOO", list, this.replaceLines);
		final String code = "FOO(57)";
		final String replace = DefinitionTable.resolve(code);
		Assert.assertEquals("57 \"57\" 57 \"57\"", replace);
	}
	
	@Test
	public void testStringification4() {
		final IdentifierList list = this.factory.createIdentifierList();
		list.getId().add("AB");
		// AB##AB, AB-#AB (AB##AB), #AB, "# AB, AB ## AB", AB # AB, AB ## AB

		// AB##
		final ReplaceLine line1 = this.factory.createReplaceLine();
		line1.setString("AB");
		line1.setConcatenate(true);
		this.replaceLines.add(line1);
		// AB, AB-#AB
		final ReplaceLine line2 = this.factory.createReplaceLine();
		line2.setString("AB, AB-");
		line2.setId("AB");
		this.replaceLines.add(line2);
		// (AB##
		final ReplaceLine line3 = this.factory.createReplaceLine();
		line3.setString(" (AB");
		line3.setConcatenate(true);
		this.replaceLines.add(line3);
		// AB), #AB
		final ReplaceLine line4 = this.factory.createReplaceLine();
		line4.setString("AB), ");
		line4.setId("AB");
		this.replaceLines.add(line4);
		DefinitionTable.addFunctionMacro("FOO", list, this.replaceLines);
		// , "# AB, AB ## AB", AB # AB
		final ReplaceLine line5 = this.factory.createReplaceLine();
		line5.setString(", \"# AB, AB ## AB\", AB ");
		line5.setId("AB");
		this.replaceLines.add(line5);
		// , AB ##
		final ReplaceLine line6 = this.factory.createReplaceLine();
		line6.setString(", AB ");
		line6.setConcatenate(true);
		this.replaceLines.add(line6);
		// AB
		final ReplaceLine line7 = this.factory.createReplaceLine();
		line7.setString(" AB");
		this.replaceLines.add(line7);
		// ...
		final String code = "FOO(57)";
		final String replace = DefinitionTable.resolve(code);
		Assert.assertEquals(
				"5757, 57-\"57\" (5757), \"57\", \"# AB, AB ## AB\", 57 \"57\", 5757",
				replace);
	}
}
