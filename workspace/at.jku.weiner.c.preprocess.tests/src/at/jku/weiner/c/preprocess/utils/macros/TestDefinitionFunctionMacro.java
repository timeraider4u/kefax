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
		Assert.assertEquals(0, ranges.getCurrentIndex());
		Assert.assertEquals(8, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		Assert.assertEquals(5, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(5, ranges.getCurrentIndex());
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
		Assert.assertEquals(0, ranges.getCurrentIndex());
		Assert.assertEquals(2, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		Assert.assertEquals(8, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(2, ranges.getCurrentIndex());
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
		Assert.assertEquals(2, ranges.getCurrentIndex());
		Assert.assertEquals(6, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		Assert.assertEquals(5, code.size());
		Assert.assertEquals(2, ranges.startIndex);
		Assert.assertEquals(3, ranges.getCurrentIndex());
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
		Assert.assertEquals(0, ranges.getCurrentIndex());
		Assert.assertEquals(40, ranges.stopIndex);
		Assert.assertEquals(0, ranges.addedElements);
		Assert.assertEquals(0, ranges.removedElements);
		this.definitionTable.resolve(0, code, ranges);
		// 40 -36+30 = 34
		Assert.assertEquals(34, code.size());
		Assert.assertEquals(0, ranges.startIndex);
		Assert.assertEquals(34, ranges.getCurrentIndex());
		Assert.assertEquals(34, ranges.stopIndex);
		// -36 + 30 = -6
		Assert.assertEquals(30, ranges.addedElements);
		Assert.assertEquals(36, ranges.removedElements);
	}
	
}
