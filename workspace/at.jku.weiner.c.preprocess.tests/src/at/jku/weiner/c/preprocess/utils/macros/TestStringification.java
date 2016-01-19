package at.jku.weiner.c.preprocess.utils.macros;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import at.jku.weiner.c.preprocess.parser.antlr.internal.InternalPreprocessLexer;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.PreprocessFactory;
import at.jku.weiner.c.preprocess.tests.PreprocessInjectorProvider;
import at.jku.weiner.c.preprocess.utils.LexerUtils;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class TestStringification {

	private final PreprocessFactory factory = PreprocessFactory.eINSTANCE;
	private String replaceLine;

	@Inject
	private InternalPreprocessLexer lexer;
	@Inject
	private ITokenDefProvider tokenDefProvider;

	private DefinitionTable definitionTable;

	@Before
	public void setUp() {
		final LexerUtils lexerUtils = new LexerUtils(this.lexer,
				this.tokenDefProvider);
		this.definitionTable = new DefinitionTable(lexerUtils);
		this.definitionTable.reset();
		this.replaceLine = "something";
	}

	@After
	public void cleanUp() {
		this.definitionTable.reset();
	}

	@Test(timeout = 1000)
	public void testStringification1() {
		final IdentifierList list = PreprocessFactory.eINSTANCE
				.createIdentifierList();
		list.getId().add("X");
		this.replaceLine = "X #X";
		this.definitionTable.addFunctionMacro("FOO", list, this.replaceLine);
		final String code = "FOO(5)";
		final String replace = this.definitionTable.fullResolve(code);
		Assert.assertEquals("5 \"5\"", replace);
	}

	@Test(timeout = 1000)
	public void testStringification2() {
		final IdentifierList list = PreprocessFactory.eINSTANCE
				.createIdentifierList();
		list.getId().add("X");
		// define FOO(X) X #X X #X X #X
		this.replaceLine = "X #X X #X X #X";
		this.definitionTable.addFunctionMacro("FOO", list, this.replaceLine);
		final String code = "FOO( 56 )";
		final String replace = this.definitionTable.fullResolve(code);
		Assert.assertEquals("56 \"56\" 56 \"56\" 56 \"56\"", replace);
	}

	@Test(timeout = 1000)
	public void testStringification3() {
		final IdentifierList list = PreprocessFactory.eINSTANCE
				.createIdentifierList();
		list.getId().add("AB");
		this.replaceLine = "AB # AB AB #AB  ";
		this.definitionTable.addFunctionMacro("FOO", list, this.replaceLine);
		final String code = "FOO(57)";
		final String replace = this.definitionTable.fullResolve(code);
		Assert.assertEquals("57 \"57\" 57 \"57\"", replace);
	}

	@Test(timeout = 1000)
	public void testStringification4() {
		final IdentifierList list = this.factory.createIdentifierList();
		list.getId().add("AB");
		// AB##AB, AB-#AB (AB##AB), #AB, "# AB, AB ## AB", AB # AB, AB ## AB
		this.replaceLine = " AB##AB, AB-#AB (AB##AB), #AB, \"# AB, AB ## AB\", AB # AB, AB ## AB";
		this.definitionTable.addFunctionMacro("FOO", list, this.replaceLine);
		final String code = "FOO(57)";
		final String replace = this.definitionTable.fullResolve(code);
		Assert.assertEquals(
				"5757, 57-\"57\" (5757), \"57\", \"# AB, AB ## AB\", 57 \"57\", 5757",
				replace);
	}
}
