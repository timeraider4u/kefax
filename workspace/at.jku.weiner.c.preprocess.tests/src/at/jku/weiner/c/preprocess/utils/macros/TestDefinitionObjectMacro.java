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
import at.jku.weiner.c.preprocess.tests.PreprocessInjectorProvider;
import at.jku.weiner.c.preprocess.utils.LexerUtils;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class TestDefinitionObjectMacro {

	@Inject
	private InternalPreprocessLexer lexer;
	@Inject
	private ITokenDefProvider tokenDefProvider;

	private DefinitionTable definitionTable;
	private LexerUtils lexerUtils;

	@Before
	public void setUp() throws Exception {
		this.lexerUtils = new LexerUtils(this.lexer, this.tokenDefProvider);
		this.definitionTable = new DefinitionTable(this.lexerUtils);
		this.definitionTable.reset();
	}

	@Test
	public void testSimpleReplacement1() {
		this.definitionTable.add("BAR", "X Y Z");
		final List<Token> code = this.lexerUtils.getTokens("FOO BAR BAZ");
		final MacroRanges ranges = TestUtils.getMacroRange(0, code.size());
		Assert.assertEquals(5, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(0, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(5, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		Assert.assertEquals(9, code.size());
		final List<Token> expected = this.lexerUtils.getTokens("FOO X Y Z BAZ");
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(5, ranges.getCurrentInsertionIndex());
		Assert.assertEquals(9, ranges.stopIndex);
		Assert.assertEquals(5, ranges.addedElements);
		Assert.assertEquals(1, ranges.removedElements);
	}

	@Test
	public void testSimpleReplacement2() {
		final List<Token> code = this.lexerUtils.getTokens("FOO BAR BAZ");
		final MacroRanges ranges = TestUtils.getMacroRange(0, 2);
		this.definitionTable.add("BAR", "X Y Z");
		Assert.assertEquals(5, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		// Assert.assertEquals(0, ranges.getCurrentIndex());
		Assert.assertEquals(2, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = this.lexerUtils.getTokens("FOO BAR BAZ");
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(5, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		// Assert.assertEquals(0, ranges.getCurrentIndex());
		Assert.assertEquals(2, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
	}

	@Test
	public void testSimpleReplacement3() {
		final List<Token> code = this.lexerUtils.getTokens("FOO BAR BAZ");
		final MacroRanges ranges = TestUtils.getMacroRange(2, 3);
		this.definitionTable.add("BAR", "X Y Z");
		Assert.assertEquals(5, code.size());
		Assert.assertEquals(2, ranges.startIndex);
		// Assert.assertEquals(2, ranges.getCurrentIndex());
		Assert.assertEquals(3, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		Assert.assertEquals(9, code.size());
		final List<Token> expected = this.lexerUtils.getTokens("FOO X Y Z BAZ");
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(2, ranges.startIndex);
		// Assert.assertEquals(7, ranges.getCurrentIndex());
		Assert.assertEquals(7, ranges.stopIndex);
		Assert.assertEquals(5, ranges.addedElements);
		Assert.assertEquals(1, ranges.removedElements);
	}

	@Test
	public void testSimpleReplacement4() {
		this.definitionTable.add("BAR", "");
		final List<Token> code = this.lexerUtils.getTokens("FOO BAR BAZ");
		final MacroRanges ranges = TestUtils.getMacroRange(0, code.size());
		Assert.assertEquals(5, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		// Assert.assertEquals(0, ranges.getCurrentIndex());
		Assert.assertEquals(5, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = this.lexerUtils.getTokens("FOO  BAZ");
		expected.add(2, TokenUtils.getIDTokenForText(""));
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(5, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		// Assert.assertEquals(0, ranges.getCurrentIndex());
		Assert.assertEquals(5, ranges.stopIndex);
		Assert.assertEquals(1, ranges.addedElements);
		Assert.assertEquals(1, ranges.removedElements);
	}

	@Test
	public void testSimpleReplacement5() {
		this.definitionTable.add("BAR", "");
		final List<Token> code = this.lexerUtils.getTokens("FOO BAR BAZ");
		final MacroRanges ranges = TestUtils.getMacroRange(0, 2);
		Assert.assertEquals(5, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		// Assert.assertEquals(0, ranges.getCurrentIndex());
		Assert.assertEquals(2, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = this.lexerUtils.getTokens("FOO BAR BAZ");
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(5, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		// Assert.assertEquals(0, ranges.getCurrentIndex());
		Assert.assertEquals(2, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
	}

	@Test
	public void testSimpleReplacement6() {
		this.definitionTable.add("BAR", "");
		final List<Token> code = this.lexerUtils.getTokens("FOO BAR BAZ");
		final MacroRanges ranges = TestUtils.getMacroRange(2, 3);
		Assert.assertEquals(5, code.size());
		Assert.assertEquals(2, ranges.startIndex);
		// Assert.assertEquals(2, ranges.getCurrentIndex());
		Assert.assertEquals(3, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		final List<Token> expected = this.lexerUtils.getTokens("FOO  BAZ");
		expected.add(2, TokenUtils.getIDTokenForText(""));
		TestUtils.assertEqualsList(expected, code);
		Assert.assertEquals(5, code.size());
		Assert.assertEquals(2, ranges.startIndex);
		// Assert.assertEquals(2, ranges.getCurrentIndex());
		Assert.assertEquals(3, ranges.stopIndex);
		Assert.assertEquals(1, ranges.addedElements);
		Assert.assertEquals(1, ranges.removedElements);
	}

	@Test
	public void testSimpleReplacementEmpty() {
		final DefinitionObjectMacro macro = new DefinitionObjectMacro(
				this.definitionTable, "FOO", null);
		final List<Token> tokens = macro.getReplacementList();
		Assert.assertNotNull(tokens);
		Assert.assertEquals(1, tokens.size());
		final Token token = tokens.get(0);
		Assert.assertEquals("", token.getText());
		Assert.assertEquals(InternalPreprocessLexer.RULE_ID, token.getType());
	}

}
