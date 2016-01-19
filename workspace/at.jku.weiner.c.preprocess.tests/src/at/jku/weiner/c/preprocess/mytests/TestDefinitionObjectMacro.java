package at.jku.weiner.c.preprocess.mytests;

import java.awt.Point;
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
import at.jku.weiner.c.preprocess.utils.macros.DefinitionObjectMacro;
import at.jku.weiner.c.preprocess.utils.macros.DefinitionTable;

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
		final DefinitionObjectMacro macro = new DefinitionObjectMacro(
				this.definitionTable, "BAR", "X Y Z");
		final List<Token> code = this.lexerUtils.getTokens("FOO BAR BAZ");
		final Point point = new Point(0, code.size());
		macro.resolve(0, code, point);
		Assert.assertEquals(9, code.size());
		Assert.assertEquals(4, point.x);
		Assert.assertEquals(9, point.y);
	}

	@Test
	public void testSimpleReplacement2() {
		final DefinitionObjectMacro macro = new DefinitionObjectMacro(
				this.definitionTable, "BAR", "X Y Z");
		final List<Token> code = this.lexerUtils.getTokens("FOO BAR BAZ");
		final Point point = new Point(2, 2);
		macro.resolve(0, code, point);
		Assert.assertEquals(9, code.size());
		Assert.assertEquals(6, point.x);
		Assert.assertEquals(6, point.y);
	}

}
