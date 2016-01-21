package at.jku.weiner.c.preprocess.utils.macros;

import java.util.List;

import org.antlr.runtime.Token;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
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
public class TestDefinitionFunctionMacro {

	@Inject
	private InternalPreprocessLexer lexer;
	@Inject
	private ITokenDefProvider tokenDefProvider;

	private DefinitionTable definitionTable;
	private LexerUtils lexerUtils;
	private IdentifierList idList;

	@Before
	public void setUp() throws Exception {
		this.lexerUtils = new LexerUtils(this.lexer, this.tokenDefProvider);
		this.definitionTable = new DefinitionTable(this.lexerUtils);
		this.definitionTable.reset();
		final PreprocessFactory factory = PreprocessFactory.eINSTANCE;
		this.idList = factory.createIdentifierList();
		this.idList.getId().add("X");
	}

	@Test
	public void testSimpleReplacement1() {
		this.definitionTable.addFunctionMacro("BAR", this.idList, "#X");
		final List<Token> code = this.lexerUtils.getTokens("FOO BAR(x) BAZ");
		final MacroRanges ranges = new MacroRanges(0, code.size());
		Assert.assertEquals(8, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		// Assert.assertEquals(0, ranges.getCurrentIndex());
		Assert.assertEquals(8, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = this.lexerUtils.getTokens("FOO \"x\" BAZ");
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(5, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		// 0+ 1
		// Assert.assertEquals(1, ranges.getCurrentIndex());
		Assert.assertEquals(5, ranges.stopIndex);
		Assert.assertEquals(1, ranges.addedElements);
		Assert.assertEquals(4, ranges.removedElements);
	}

	@Test
	public void testSimpleReplacement2() {
		this.definitionTable.addFunctionMacro("BAR", this.idList, "#X");
		final List<Token> code = this.lexerUtils.getTokens("FOO BAR(x) BAZ");
		final MacroRanges ranges = new MacroRanges(0, 2);
		Assert.assertEquals(8, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		// Assert.assertEquals(0, ranges.getCurrentIndex());
		Assert.assertEquals(2, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = this.lexerUtils
				.getTokens("FOO BAR(x) BAZ");
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(8, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		// Assert.assertEquals(0, ranges.getCurrentIndex());
		Assert.assertEquals(2, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
	}

	@Test
	public void testSimpleReplacement3() {
		this.definitionTable.addFunctionMacro("BAR", this.idList, "#X");
		final List<Token> code = this.lexerUtils.getTokens("FOO BAR(x) BAZ");
		final MacroRanges ranges = new MacroRanges(2, 6);
		Assert.assertEquals(8, code.size());
		Assert.assertEquals(2, ranges.startIndex);
		// Assert.assertEquals(2, ranges.getCurrentIndex());
		Assert.assertEquals(6, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = this.lexerUtils.getTokens("FOO \"x\" BAZ");
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(5, code.size());
		Assert.assertEquals(2, ranges.startIndex);
		// Assert.assertEquals(3, ranges.getCurrentIndex());
		Assert.assertEquals(3, ranges.stopIndex);
		Assert.assertEquals(1, ranges.addedElements);
		Assert.assertEquals(4, ranges.removedElements);
	}

	@Test
	public void complexReplacement1() {
		this.idList.getId().add("Y");
		this.idList.getId().add("Z");
		this.definitionTable.addFunctionMacro("BAR", this.idList, "X Y Z");
		final List<Token> code = this.lexerUtils
				.getTokens("pre;BAR((3), ((5), (3)), (3, (3), ((5))) );post");
		final MacroRanges ranges = new MacroRanges(0, code.size());
		Assert.assertEquals(40, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		// Assert.assertEquals(0, ranges.getCurrentIndex());
		Assert.assertEquals(40, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = this.lexerUtils
				.getTokens("pre;(3) ((5), (3)) (3, (3), ((5)));post");
		TestUtils.assertEqualsList(expected, code);
		// 40 -36+30 = 34
		Assert.assertEquals(34, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		// 0 + 30 = 30
		// Assert.assertEquals(30, ranges.getCurrentIndex());
		Assert.assertEquals(34, ranges.stopIndex);
		// -36 + 30 = -6
		Assert.assertEquals(30, ranges.addedElements);
		Assert.assertEquals(36, ranges.removedElements);
	}

	@Test
	public void complexReplacement2() {
		this.idList.getId().add("Y");
		this.idList.getId().add("Z");
		this.definitionTable.addFunctionMacro("BAR", this.idList, "(X##Y)");
		final List<Token> code = this.lexerUtils
				.getTokens("BAR(5,Y,Z)BAR(X,5,Z)");
		final MacroRanges ranges = new MacroRanges(0, 8);
		Assert.assertEquals(16, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(0, ranges.getCurrentIndex());
		Assert.assertEquals(8, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = this.lexerUtils
				.getTokens("(5Y)BAR(X,5,Z)");
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(16, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(0, ranges.getCurrentIndex());
		Assert.assertEquals(2, ranges.stopIndex);
		Assert.assertEquals(2, ranges.addedElements);
		Assert.assertEquals(8, ranges.removedElements);
	}

	@Test
	public void complexReplacement3() {
		this.idList.getId().add("Y");
		this.idList.getId().add("Z");
		this.definitionTable.addFunctionMacro("BAR", this.idList, "(X##Y)");
		final List<Token> code = this.lexerUtils
				.getTokens("BAR(5,Y,Z)BAR(X,5,Z)");
		final MacroRanges ranges = new MacroRanges(8, code.size());
		Assert.assertEquals(16, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(0, ranges.getCurrentIndex());
		Assert.assertEquals(16, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = this.lexerUtils.getTokens("BAR(5,Y,ZX5");
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(16, code.size());
		Assert.assertEquals(8, ranges.startIndex);
		Assert.assertEquals(8, ranges.getCurrentIndex());
		Assert.assertEquals(16, ranges.stopIndex);
		Assert.assertEquals(2, ranges.addedElements);
		Assert.assertEquals(8, ranges.removedElements);
	}

	@Test
	public void complexReplacement4() {
		this.idList.getId().add("Y");
		this.idList.getId().add("Z");
		this.definitionTable.addFunctionMacro("BAR", this.idList, "(X##Y)");
		final List<Token> code = this.lexerUtils
				.getTokens("BAR(5,Y,Z)BAR(X,5,Z)");
		final MacroRanges ranges = new MacroRanges(0, code.size());
		Assert.assertEquals(16, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(0, ranges.getCurrentIndex());
		Assert.assertEquals(16, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = this.lexerUtils.getTokens("5YX5");
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(4, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(0, ranges.getCurrentIndex());
		Assert.assertEquals(4, ranges.stopIndex);
		Assert.assertEquals(4, ranges.addedElements);
		Assert.assertEquals(16, ranges.removedElements);
	}

	@Test
	public void complexReplacement5() {
		this.idList.getId().add("Y");
		this.idList.getId().add("Z");
		this.definitionTable.addFunctionMacro("BAR", this.idList, "(X##Y)");
		final List<Token> code = this.lexerUtils
				.getTokens("BAR(5,Y,Z) BAR(X,5,Z)");
		final MacroRanges ranges = new MacroRanges(0, code.size());
		Assert.assertEquals(16, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(0, ranges.getCurrentIndex());
		Assert.assertEquals(16, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = this.lexerUtils.getTokens("5YX5");
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(4, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(0, ranges.getCurrentIndex());
		Assert.assertEquals(4, ranges.stopIndex);
		Assert.assertEquals(2, ranges.addedElements);
		Assert.assertEquals(8, ranges.removedElements);
	}

	@Test
	public void complexReplacement6() {
		this.idList.getId().add("Y");
		this.idList.getId().add("Z");
		this.definitionTable.addFunctionMacro("BAR", this.idList, "(X##Y)");
		final List<Token> code = this.lexerUtils
				.getTokens("BAR(5,Y,Z) BAR(X,5,Z)");
		final MacroRanges ranges = new MacroRanges(8, code.size());
		Assert.assertEquals(16, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(0, ranges.getCurrentIndex());
		Assert.assertEquals(16, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = this.lexerUtils.getTokens("5YX5");
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(4, code.size());
		Assert.assertEquals(8, ranges.startIndex);
		Assert.assertEquals(10, ranges.getCurrentIndex());
		Assert.assertEquals(4, ranges.stopIndex);
		Assert.assertEquals(2, ranges.addedElements);
		Assert.assertEquals(8, ranges.removedElements);
	}
}
