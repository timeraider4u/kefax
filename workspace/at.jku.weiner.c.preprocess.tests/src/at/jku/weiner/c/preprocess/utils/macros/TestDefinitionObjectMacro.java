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
		final MacroRanges ranges = new MacroRanges(0, code.size());
		Assert.assertEquals(5, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(0, ranges.currIndex);
		Assert.assertEquals(5, ranges.stopIndex);
		Assert.assertEquals(0, ranges.changedElements);
		this.definitionTable.resolve(0, code, ranges);
		Assert.assertEquals(9, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(9, ranges.currIndex);
		Assert.assertEquals(9, ranges.stopIndex);
		Assert.assertEquals(4, ranges.changedElements);
	}

	@Test
	public void testSimpleReplacement2() {
		final List<Token> code = this.lexerUtils.getTokens("FOO BAR BAZ");
		final MacroRanges ranges = new MacroRanges(0, 2);
		this.definitionTable.add("BAR", "X Y Z");
		Assert.assertEquals(5, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(0, ranges.currIndex);
		Assert.assertEquals(2, ranges.stopIndex);
		Assert.assertEquals(0, ranges.changedElements);
		this.definitionTable.resolve(0, code, ranges);
		Assert.assertEquals(5, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(2, ranges.currIndex);
		Assert.assertEquals(2, ranges.stopIndex);
		Assert.assertEquals(0, ranges.changedElements);
	}

	@Test
	public void testSimpleReplacement3() {
		final List<Token> code = this.lexerUtils.getTokens("FOO BAR BAZ");
		final MacroRanges ranges = new MacroRanges(2, 3);
		this.definitionTable.add("BAR", "X Y Z");
		Assert.assertEquals(5, code.size());
		Assert.assertEquals(2, ranges.startIndex);
		Assert.assertEquals(2, ranges.currIndex);
		Assert.assertEquals(3, ranges.stopIndex);
		Assert.assertEquals(0, ranges.changedElements);
		this.definitionTable.resolve(0, code, ranges);
		Assert.assertEquals(9, code.size());
		Assert.assertEquals(2, ranges.startIndex);
		Assert.assertEquals(7, ranges.currIndex);
		Assert.assertEquals(7, ranges.stopIndex);
		Assert.assertEquals(4, ranges.changedElements);
	}

	@Test
	public void testSimpleReplacement4() {
		this.definitionTable.add("BAR", "");
		final List<Token> code = this.lexerUtils.getTokens("FOO BAR BAZ");
		final MacroRanges ranges = new MacroRanges(0, code.size());
		Assert.assertEquals(5, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(0, ranges.currIndex);
		Assert.assertEquals(5, ranges.stopIndex);
		Assert.assertEquals(0, ranges.changedElements);
		this.definitionTable.resolve(0, code, ranges);
		Assert.assertEquals(4, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(4, ranges.currIndex);
		Assert.assertEquals(4, ranges.stopIndex);
		Assert.assertEquals(-1, ranges.changedElements);
	}

	@Test
	public void testSimpleReplacement5() {
		this.definitionTable.add("BAR", "");
		final List<Token> code = this.lexerUtils.getTokens("FOO BAR BAZ");
		final MacroRanges ranges = new MacroRanges(0, 2);
		Assert.assertEquals(5, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(0, ranges.currIndex);
		Assert.assertEquals(2, ranges.stopIndex);
		Assert.assertEquals(0, ranges.changedElements);
		this.definitionTable.resolve(0, code, ranges);
		Assert.assertEquals(5, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(2, ranges.currIndex);
		Assert.assertEquals(2, ranges.stopIndex);
		Assert.assertEquals(0, ranges.changedElements);
	}

	@Test
	public void testSimpleReplacement6() {
		this.definitionTable.add("BAR", "");
		final List<Token> code = this.lexerUtils.getTokens("FOO BAR BAZ");
		final MacroRanges ranges = new MacroRanges(2, 3);
		Assert.assertEquals(5, code.size());
		Assert.assertEquals(2, ranges.startIndex);
		Assert.assertEquals(2, ranges.currIndex);
		Assert.assertEquals(3, ranges.stopIndex);
		Assert.assertEquals(0, ranges.changedElements);
		this.definitionTable.resolve(0, code, ranges);
		Assert.assertEquals(4, code.size());
		Assert.assertEquals(2, ranges.startIndex);
		Assert.assertEquals(2, ranges.currIndex);
		Assert.assertEquals(2, ranges.stopIndex);
		Assert.assertEquals(-1, ranges.changedElements);
	}

}
