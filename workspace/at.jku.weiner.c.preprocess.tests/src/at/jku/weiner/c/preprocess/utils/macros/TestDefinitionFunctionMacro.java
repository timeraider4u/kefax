package at.jku.weiner.c.preprocess.utils.macros;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import at.jku.weiner.c.common.log.MyLog;
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
	private IdentifierList idList2;

	@Before
	public void setUp() throws Exception {
		MyLog.setLog_level(MyLog.LOG_NONE);
		this.lexerUtils = new LexerUtils(this.lexer, this.tokenDefProvider);
		this.definitionTable = new DefinitionTable(this.lexerUtils);
		this.definitionTable.reset();
		final PreprocessFactory factory = PreprocessFactory.eINSTANCE;
		this.idList = factory.createIdentifierList();
		this.idList.getId().add("X");
		this.idList2 = factory.createIdentifierList();
		this.idList2.getId().add("X");
	}

	@Test
	public void testSimpleReplacement1() {
		this.definitionTable.addFunctionMacro("BAR", this.idList, "#X");
		final List<Token> code = this.lexerUtils.getTokens("FOO BAR(x) BAZ");
		final MacroRanges ranges = TestUtils.getMacroRange(0, code.size());
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
		final MacroRanges ranges = TestUtils.getMacroRange(0, 2);
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
		final MacroRanges ranges = TestUtils.getMacroRange(2, 6);
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
		final MacroRanges ranges = TestUtils.getMacroRange(0, code.size());
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
		final MacroRanges ranges = TestUtils.getMacroRange(0, 8);
		Assert.assertEquals(16, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(0, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(8, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = this.lexerUtils
				.getTokens("(5Y)BAR(X,5,Z)");
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(12, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(4, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(4, ranges.stopIndex);
		Assert.assertEquals(4, ranges.addedElements);
		Assert.assertEquals(8, ranges.removedElements);
	}

	@Test
	public void complexReplacement3() {
		this.idList.getId().add("Y");
		this.idList.getId().add("Z");
		this.definitionTable.addFunctionMacro("BAR", this.idList, "(X##Y)");
		final List<Token> code = this.lexerUtils
				.getTokens("BAR(5,Y,Z)BAR(X,5,Z)");
		final MacroRanges ranges = TestUtils.getMacroRange(8, code.size());
		Assert.assertEquals(16, code.size());
		Assert.assertEquals(8, ranges.startIndex);
		Assert.assertEquals(8, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(16, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = this.lexerUtils
				.getTokens("BAR(5,Y,Z)(X5)");
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(11, code.size());
		Assert.assertEquals(8, ranges.startIndex);
		Assert.assertEquals(11, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(11, ranges.stopIndex);
		Assert.assertEquals(3, ranges.addedElements);
		Assert.assertEquals(8, ranges.removedElements);
	}

	@Test
	public void complexReplacement4() {
		this.idList.getId().add("Y");
		this.idList.getId().add("Z");
		this.definitionTable.addFunctionMacro("BAR", this.idList, "(X##Y)");
		final List<Token> code = this.lexerUtils
				.getTokens("BAR(5,Y,Z)BAR(X,5,Z)");
		final MacroRanges ranges = TestUtils.getMacroRange(0, code.size());
		Assert.assertEquals(16, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(0, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(16, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = this.lexerUtils.getTokens("(5Y)(X5)");
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(7, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(7, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(7, ranges.stopIndex);
		Assert.assertEquals(7, ranges.addedElements);
		Assert.assertEquals(16, ranges.removedElements);
	}

	@Test
	public void complexReplacement5() {
		this.idList.getId().add("Y");
		this.idList.getId().add("Z");
		this.definitionTable.addFunctionMacro("BAR", this.idList, "(X##Y)");
		final List<Token> code = this.lexerUtils
				.getTokens("BAR(5,Y,Z) BAR(X,5,Z)");
		final MacroRanges ranges = TestUtils.getMacroRange(0, 8);
		Assert.assertEquals(17, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(0, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(8, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = this.lexerUtils
				.getTokens("(5Y) BAR(X,5,Z)");
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(13, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(4, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(4, ranges.stopIndex);
		Assert.assertEquals(4, ranges.addedElements);
		Assert.assertEquals(8, ranges.removedElements);
	}

	@Test
	public void complexReplacement6() {
		this.idList.getId().add("Y");
		this.idList.getId().add("Z");
		this.definitionTable.addFunctionMacro("BAR", this.idList, "(X##Y)");
		final List<Token> code = this.lexerUtils
				.getTokens("BAR(5,Y,Z) BAR(X,5,Z)");
		final MacroRanges ranges = TestUtils.getMacroRange(9, code.size());
		Assert.assertEquals(17, code.size());
		Assert.assertEquals(9, ranges.startIndex);
		Assert.assertEquals(9, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(17, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = this.lexerUtils
				.getTokens("BAR(5,Y,Z) (X5)");
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(12, code.size());
		Assert.assertEquals(9, ranges.startIndex);
		Assert.assertEquals(12, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(12, ranges.stopIndex);
		Assert.assertEquals(3, ranges.addedElements);
		Assert.assertEquals(8, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(12, code.size());
		Assert.assertEquals(9, ranges.startIndex);
		Assert.assertEquals(12, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(12, ranges.stopIndex);
		Assert.assertEquals(3, ranges.addedElements);
		Assert.assertEquals(8, ranges.removedElements);
	}

	@Test
	public void complexReplacement7() {
		this.idList.getId().add("Y");
		this.idList.getId().add("Z");
		this.definitionTable.addFunctionMacro("BAR", this.idList, "(X##Y)");
		final List<Token> code = this.lexerUtils
				.getTokens("BAR(5,Y,Z) BAR(X,5,Z)");
		final MacroRanges ranges = TestUtils.getMacroRange(0, code.size());
		Assert.assertEquals(17, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(0, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(17, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = this.lexerUtils.getTokens("(5Y) (X5)");
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(8, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(7, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(8, ranges.stopIndex);
		Assert.assertEquals(7, ranges.addedElements);
		Assert.assertEquals(16, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(8, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(7, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(8, ranges.stopIndex);
		Assert.assertEquals(7, ranges.addedElements);
		Assert.assertEquals(16, ranges.removedElements);
	}

	@Test
	public void complexReplacement8() {
		this.idList.getId().add("Y");
		this.idList.getId().add("Z");
		this.definitionTable.addFunctionMacro("BAR", this.idList, "(X##Y)");
		final List<Token> code = this.lexerUtils
				.getTokens(" BAR(5,Y,Z) BAR(X,5,Z) ");
		final MacroRanges ranges = TestUtils.getMacroRange(0, 9);
		Assert.assertEquals(19, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(0, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(9, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = this.lexerUtils
				.getTokens(" (5Y) BAR(X,5,Z) ");
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(15, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(4, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(5, ranges.stopIndex);
		Assert.assertEquals(4, ranges.addedElements);
		Assert.assertEquals(8, ranges.removedElements);
	}

	@Test
	public void complexReplacement9() {
		this.idList.getId().add("Y");
		this.idList.getId().add("Z");
		this.definitionTable.addFunctionMacro("BAR", this.idList, "(X##Y)");
		final List<Token> code = this.lexerUtils
				.getTokens(" BAR(5,Y,Z) BAR(X,5,Z) ");
		final MacroRanges ranges = TestUtils.getMacroRange(10, code.size());
		Assert.assertEquals(19, code.size());
		Assert.assertEquals(10, ranges.startIndex);
		Assert.assertEquals(10, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(19, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = this.lexerUtils
				.getTokens(" BAR(5,Y,Z) (X5) ");
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(14, code.size());
		Assert.assertEquals(10, ranges.startIndex);
		Assert.assertEquals(13, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(14, ranges.stopIndex);
		Assert.assertEquals(3, ranges.addedElements);
		Assert.assertEquals(8, ranges.removedElements);
	}

	@Test
	public void complexReplacement10() {
		this.idList.getId().add("Y");
		this.idList.getId().add("Z");
		this.definitionTable.addFunctionMacro("BAR", this.idList, "(X##Y)");
		final List<Token> code = this.lexerUtils
				.getTokens(" BAR(5,Y,Z) BAR(X,5,Z) ");
		final MacroRanges ranges = TestUtils.getMacroRange(0, code.size());
		Assert.assertEquals(19, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(0, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(19, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = this.lexerUtils.getTokens(" (5Y) (X5) ");
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(10, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(7, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(10, ranges.stopIndex);
		Assert.assertEquals(7, ranges.addedElements);
		Assert.assertEquals(16, ranges.removedElements);
	}

	@Test
	public void complexReplacement11() {
		this.idList.getId().add("Y");
		this.idList.getId().add("Z");
		this.definitionTable.addFunctionMacro("BAR", this.idList, "(X##Y)");
		final List<Token> code = this.lexerUtils
				.getTokens(" BAR(5,Y,Z) BAR(X,5,Z) ");
		final MacroRanges ranges = TestUtils.getMacroRange(0, code.size());
		Assert.assertEquals(19, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(0, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(19, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = this.lexerUtils.getTokens(" (5Y) (X5) ");
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(10, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(7, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(10, ranges.stopIndex);
		Assert.assertEquals(7, ranges.addedElements);
		Assert.assertEquals(16, ranges.removedElements);
	}

	@Test
	public void complexDoubleReplacement1() {
		this.idList.getId().add("Y");
		this.idList2.getId().add("Y");
		this.definitionTable.addFunctionMacro("FOO", this.idList, "(X##Y)");
		this.definitionTable.addFunctionMacro("BAR", this.idList2, "FOO(X,Y))");
		final List<Token> code = this.lexerUtils.getTokens("FOO(5,R) BAR(5,5)");
		final MacroRanges ranges = TestUtils.getMacroRange(0, 6);
		Assert.assertEquals(13, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(0, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(6, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = new ArrayList<Token>();
		expected.add(new CommonToken(
				InternalPreprocessLexer.RULE_SKW_LEFTPAREN, "("));
		expected.add(new CommonToken(
				InternalPreprocessLexer.RULE_DECIMAL_LITERAL, "5"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "R"));
		expected.add(new CommonToken(
				InternalPreprocessLexer.RULE_SKW_RIGHTPAREN, ")"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "BAR"));
		expected.add(new CommonToken(
				InternalPreprocessLexer.RULE_SKW_LEFTPAREN, "("));
		expected.add(new CommonToken(
				InternalPreprocessLexer.RULE_DECIMAL_LITERAL, "5"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_SKW_COMMA,
				","));
		expected.add(new CommonToken(
				InternalPreprocessLexer.RULE_DECIMAL_LITERAL, "5"));
		expected.add(new CommonToken(
				InternalPreprocessLexer.RULE_SKW_RIGHTPAREN, ")"));

		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(11, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(4, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(4, ranges.stopIndex);
		Assert.assertEquals(4, ranges.addedElements);
		Assert.assertEquals(6, ranges.removedElements);
	}

	@Test
	public void complexDoubleReplacement2() {
		this.idList.getId().add("Y");
		this.idList2.getId().add("Y");
		this.definitionTable.addFunctionMacro("FOO", this.idList, "(X##Y)");
		this.definitionTable.addFunctionMacro("BAR", this.idList2, "FOO(X,Y)");
		final List<Token> code = this.lexerUtils.getTokens("FOO(5,R) BAR(5,5)");
		final MacroRanges ranges = TestUtils.getMacroRange(6, code.size());
		Assert.assertEquals(13, code.size());
		Assert.assertEquals(6, ranges.startIndex);
		Assert.assertEquals(6, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(13, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = new ArrayList<Token>();
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "FOO"));
		expected.add(new CommonToken(
				InternalPreprocessLexer.RULE_SKW_LEFTPAREN, "("));
		expected.add(new CommonToken(
				InternalPreprocessLexer.RULE_DECIMAL_LITERAL, "5"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_SKW_COMMA,
				","));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "R"));
		expected.add(new CommonToken(
				InternalPreprocessLexer.RULE_SKW_RIGHTPAREN, ")"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(
				InternalPreprocessLexer.RULE_SKW_LEFTPAREN, "("));
		expected.add(new CommonToken(
				InternalPreprocessLexer.RULE_DECIMAL_LITERAL, "5"));
		expected.add(new CommonToken(
				InternalPreprocessLexer.RULE_DECIMAL_LITERAL, "5"));
		expected.add(new CommonToken(
				InternalPreprocessLexer.RULE_SKW_RIGHTPAREN, ")"));
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(11, code.size());
		Assert.assertEquals(6, ranges.startIndex);
		// Assert.assertEquals(10, ranges.getCurrentIndex());
		Assert.assertEquals(11, ranges.stopIndex);
		Assert.assertEquals(10, ranges.addedElements);
		Assert.assertEquals(12, ranges.removedElements);
	}

	@Test
	public void testConcatenation1() {
		this.idList.getId().add("Y");
		this.definitionTable.addFunctionMacro("FOO", this.idList, "X:X ## Y");
		final List<Token> code = this.lexerUtils
				.getTokens("mystart FOO(foo, bar) myend");
		final MacroRanges ranges = TestUtils.getMacroRange(0, code.size());
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = new ArrayList<Token>();
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "mystart"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "foo"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_SKW_COLON,
				":"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "foobar"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "myend"));
		TestUtils.assertEqualsList(expected, code);
	}

	@Test
	public void testConcatenation2() {
		this.definitionTable.addFunctionMacro("FOO", this.idList, "foo_ ## X");
		final List<Token> code = this.lexerUtils
				.getTokens("mystart FOO(bar) myend");
		final MacroRanges ranges = TestUtils.getMacroRange(0, code.size());
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = new ArrayList<Token>();
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "mystart"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "foo_bar"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "myend"));
		TestUtils.assertEqualsList(expected, code);
	}

	@Test
	public void testConcatenation3() {
		this.definitionTable.addFunctionMacro("FOO", this.idList,
				"foo##bar##baz");
		final List<Token> code = this.lexerUtils
				.getTokens("mystart FOO(a) myend");
		final MacroRanges ranges = TestUtils.getMacroRange(0, code.size());
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = new ArrayList<Token>();
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "mystart"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID,
				"foobarbaz"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "myend"));
		TestUtils.assertEqualsList(expected, code);
	}

	@Test
	public void testConcatenation4() {
		this.definitionTable.addFunctionMacro("FOO", this.idList,
				"foo##bar##baz ## my");
		final List<Token> code = this.lexerUtils
				.getTokens("mystart FOO(a) myend");
		final MacroRanges ranges = TestUtils.getMacroRange(0, code.size());
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = new ArrayList<Token>();
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "mystart"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID,
				"foobarbazmy"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "myend"));
		TestUtils.assertEqualsList(expected, code);
	}

	@Test
	public void testConcatenation5() {
		this.definitionTable.addFunctionMacro("FOO", this.idList,
				"foo##bar##baz## my");
		final List<Token> code = this.lexerUtils
				.getTokens("mystart FOO(a) myend");
		final MacroRanges ranges = TestUtils.getMacroRange(0, code.size());
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = new ArrayList<Token>();
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "mystart"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID,
				"foobarbazmy"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "myend"));
		TestUtils.assertEqualsList(expected, code);
	}

	@Test
	public void testConcatenation6() {
		this.definitionTable.addFunctionMacro("FOO", this.idList,
				"foo##bar##baz ##my");
		final List<Token> code = this.lexerUtils
				.getTokens("mystart FOO(a) myend");
		final MacroRanges ranges = TestUtils.getMacroRange(0, code.size());
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = new ArrayList<Token>();
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "mystart"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID,
				"foobarbazmy"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "myend"));
		TestUtils.assertEqualsList(expected, code);
	}

	@Test
	public void testConcatenation7() {
		this.definitionTable.addFunctionMacro("FOO", this.idList,
				"foo##bar##baz##my");
		final List<Token> code = this.lexerUtils
				.getTokens("mystart FOO(a) myend");
		final MacroRanges ranges = TestUtils.getMacroRange(0, code.size());
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = new ArrayList<Token>();
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "mystart"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID,
				"foobarbazmy"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "myend"));
		TestUtils.assertEqualsList(expected, code);
	}

	@Test
	public void testConcatenation8() {
		this.definitionTable.addFunctionMacro("FOO", this.idList,
				"foo##bar##baz middle my##iam##us");
		final List<Token> code = this.lexerUtils
				.getTokens("mystart FOO(a) myend");
		final MacroRanges ranges = TestUtils.getMacroRange(0, code.size());
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = new ArrayList<Token>();
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "mystart"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID,
				"foobarbaz"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "middle"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "myiamus"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "myend"));
		TestUtils.assertEqualsList(expected, code);
	}

	@Test
	public void testConcatenation9() {
		this.definitionTable
				.addFunctionMacro("FOO", this.idList,
						"start X##bar##baz middle1 foo##X##that middle2 my##iam##X stop");
		final List<Token> code = this.lexerUtils
				.getTokens("mystart FOO(a) myend");
		final MacroRanges ranges = TestUtils.getMacroRange(0, code.size());
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = new ArrayList<Token>();
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "mystart"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "start"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "abarbaz"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "middle1"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID,
				"fooathat"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "middle2"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "myiama"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "stop"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "myend"));
		TestUtils.assertEqualsList(expected, code);
	}

	@Test
	public void testConcatenationVar1() {
		this.idList.setVariadic(true);
		this.definitionTable
		.addFunctionMacro(
				"FOO",
				this.idList,
				"start __VA_ARGS__##foo##bar middle1 begin##__VA_ARGS__##end, middle2 my##iam##__VA_ARGS__, stop");
		final List<Token> code = this.lexerUtils
				.getTokens("mystart FOO(a) myend");
		final MacroRanges ranges = TestUtils.getMacroRange(0, code.size());
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = new ArrayList<Token>();
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "mystart"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "start"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "foobar"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "middle1"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID,
				"beginend"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_SKW_COMMA,
				","));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "middle2"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "myiam"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_SKW_COMMA,
				","));

		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "stop"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "myend"));

		TestUtils.assertEqualsList(expected, code);
	}

	@Test
	public void testConcatenationVar2() {
		this.idList.setVariadic(true);
		this.definitionTable
		.addFunctionMacro(
				"FOO",
				this.idList,
				"start __VA_ARGS__##X##bar middle1 begin##__VA_ARGS__##X, middle2 X##iam##__VA_ARGS__, stop");
		final List<Token> code = this.lexerUtils
				.getTokens("mystart FOO(foo) myend");
		final MacroRanges ranges = TestUtils.getMacroRange(0, code.size());
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = new ArrayList<Token>();
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "mystart"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "start"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "foobar"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "middle1"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID,
				"beginfoo"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_SKW_COMMA,
				","));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "middle2"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "fooiam"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_SKW_COMMA,
				","));

		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "stop"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "myend"));
		TestUtils.assertEqualsList(expected, code);
	}

	@Test
	public void testConcatenationVarWithComma1() {
		// see
		// https://gcc.gnu.org/onlinedocs/gcc-4.5.1/gcc/Variadic-Macros.html#Variadic-Macros
		// at the bottom: "if the variable arguments are omitted or empty,
		// the `##' operator causes the preprocessor to remove the comma before
		// it"
		this.idList.setVariadic(true);
		this.idList.setVarID("Y");
		this.definitionTable.addFunctionMacro("FOO", this.idList,
				"printf(X, ##Y)");
		final List<Token> code = this.lexerUtils
				.getTokens("mystart FOO(foo) myend");
		final MacroRanges ranges = TestUtils.getMacroRange(0, code.size());
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = new ArrayList<Token>();
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "mystart"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "printf"));
		expected.add(new CommonToken(
				InternalPreprocessLexer.RULE_SKW_LEFTPAREN, "("));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "foo"));
		expected.add(new CommonToken(
				InternalPreprocessLexer.RULE_SKW_RIGHTPAREN, ")"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "myend"));
		TestUtils.assertEqualsList(expected, code);
	}

	@Test
	public void testConcatenationVarWithComma2() {
		this.idList.setVariadic(true);
		this.idList.setVarID("Y");
		this.definitionTable.addFunctionMacro("FOO", this.idList,
				"printf(X, ##Y)");
		final List<Token> code = this.lexerUtils
				.getTokens("mystart FOO(foo, bar) myend");
		final MacroRanges ranges = TestUtils.getMacroRange(0, code.size());
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = new ArrayList<Token>();
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "mystart"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "printf"));
		expected.add(new CommonToken(
				InternalPreprocessLexer.RULE_SKW_LEFTPAREN, "("));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "foo"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_SKW_COMMA,
				","));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "bar"));
		expected.add(new CommonToken(
				InternalPreprocessLexer.RULE_SKW_RIGHTPAREN, ")"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "myend"));
		TestUtils.assertEqualsList(expected, code);
	}

	@Test
	public void testConcatenationVarWithComma3() {
		this.idList.setVariadic(true);
		this.definitionTable.addFunctionMacro("FOO", this.idList,
				"printf(X, ##__VA_ARGS__)");
		final List<Token> code = this.lexerUtils
				.getTokens("mystart FOO(foo) myend");
		final MacroRanges ranges = TestUtils.getMacroRange(0, code.size());
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = new ArrayList<Token>();
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "mystart"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "printf"));
		expected.add(new CommonToken(
				InternalPreprocessLexer.RULE_SKW_LEFTPAREN, "("));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "foo"));
		expected.add(new CommonToken(
				InternalPreprocessLexer.RULE_SKW_RIGHTPAREN, ")"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "myend"));
		TestUtils.assertEqualsList(expected, code);
	}

	@Test
	public void testConcatenationVarWithComma4() {
		this.idList.setVariadic(true);
		this.definitionTable.addFunctionMacro("FOO", this.idList,
				"printf(X, ##__VA_ARGS__)");
		final List<Token> code = this.lexerUtils
				.getTokens("mystart FOO(foo, bar) myend");
		final MacroRanges ranges = TestUtils.getMacroRange(0, code.size());
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = new ArrayList<Token>();
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "mystart"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "printf"));
		expected.add(new CommonToken(
				InternalPreprocessLexer.RULE_SKW_LEFTPAREN, "("));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "foo"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_SKW_COMMA,
				","));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "bar"));
		expected.add(new CommonToken(
				InternalPreprocessLexer.RULE_SKW_RIGHTPAREN, ")"));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_WHITESPACE,
				" "));
		expected.add(new CommonToken(InternalPreprocessLexer.RULE_ID, "myend"));
		TestUtils.assertEqualsList(expected, code);
	}

}
