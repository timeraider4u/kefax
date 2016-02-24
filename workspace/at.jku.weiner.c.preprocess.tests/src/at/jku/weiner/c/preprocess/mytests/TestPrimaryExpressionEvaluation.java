package at.jku.weiner.c.preprocess.mytests;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import at.jku.weiner.c.common.log.MyLog;
import at.jku.weiner.c.preprocess.parser.antlr.internal.InternalPreprocessLexer;
import at.jku.weiner.c.preprocess.preprocess.PreprocessFactory;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.tests.PreprocessInjectorProvider;
import at.jku.weiner.c.preprocess.utils.LexerUtils;
import at.jku.weiner.c.preprocess.utils.expressions.ExpressionEvaluation;
import at.jku.weiner.c.preprocess.utils.expressions.ExpressionLongVisitor;
import at.jku.weiner.c.preprocess.utils.expressions.IExpressionVisitor;
import at.jku.weiner.c.preprocess.utils.macros.DefinitionTable;

import com.google.inject.Inject;
import com.google.inject.Injector;

@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class TestPrimaryExpressionEvaluation {
	private PreprocessFactory factory = PreprocessFactory.eINSTANCE;
	private ExpressionEvaluation<Long> evaluater;

	@Inject
	private InternalPreprocessLexer lexer;
	@Inject
	private ITokenDefProvider tokenDefProvider;

	private DefinitionTable definitionTable;

	@Before
	public void setUp() throws Exception {
		MyLog.setLog_level(MyLog.LOG_NONE);
		final LexerUtils lexerUtils = new LexerUtils(this.lexer,
				this.tokenDefProvider);
		this.definitionTable = new DefinitionTable(lexerUtils);
		this.definitionTable.reset();
		Assert.assertEquals(0, this.definitionTable.size());
		this.factory = PreprocessFactory.eINSTANCE;
		final PreprocessInjectorProvider provider = new PreprocessInjectorProvider();
		final Injector injector = provider.getInjector();
		final IExpressionVisitor<Long> visitor = new ExpressionLongVisitor(
				injector, this.definitionTable);
		this.evaluater = new ExpressionEvaluation<Long>(visitor);
	}

	@After
	public void tearDown() throws Exception {
		this.definitionTable.reset();
		Assert.assertEquals(0, this.definitionTable.size());
	}

	@Test(timeout = 1000)
	public void testIDWhichIsEmpty() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setIdent("FOO");
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(expression));
	}

	@Test(timeout = 1000)
	public void testIDWhichIsDefined() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setIdent("FOO");
		this.definitionTable.add("FOO", "1");
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(expression));
	}

	@Test(timeout = 1000)
	public void testIDWhichIsEmpty2() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setIdent("FOO");
		this.definitionTable.add("FOO", "BAR");
		this.definitionTable.add("BAR", "0");
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(expression));
	}

	@Test(timeout = 1000)
	public void testIDWhichIsDefined2() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setIdent("FOO");
		this.definitionTable.add("FOO", "BAR");
		this.definitionTable.add("BAR", "1");
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(expression));
	}

	@Test(timeout = 1000)
	public void testConstantWhichIsDecimalAndIsFalse() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setConst("0");
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(expression));
	}

	@Test(timeout = 1000)
	public void testConstantWhichIsDecimalAndIsTrue() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setConst("1");
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(expression));
	}

	@Test(timeout = 1000)
	// (expected = NumberFormatException.class)
	public void testConstantWhichIsFloat() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setConst("1.5");
		final Long result = this.evaluater.walkTo(expression);
		final Long expected = ExpressionLongVisitor.FALSE;
		Assert.assertEquals(expected, result);
	}

	@Test(timeout = 1000)
	// (expected = NumberFormatException.class)
	public void testConstantWhichIsFloat2() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setConst("1.0");
		final Long result = this.evaluater.walkTo(expression);
		final Long expected = ExpressionLongVisitor.FALSE;
		Assert.assertEquals(expected, result);
	}

	@Test(timeout = 1000)
	// (expected = NumberFormatException.class)
	public void testConstantWhichIsString() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setConst("\"hello\"");
		final Long result = this.evaluater.walkTo(expression);
		final Long expected = ExpressionLongVisitor.FALSE;
		Assert.assertEquals(expected, result);
	}

	@Test(timeout = 1000)
	public void testConstantWhichIsBinary() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setConst("0b001");
		final Long result = this.evaluater.walkTo(expression);
		Assert.assertEquals(ExpressionLongVisitor.TRUE, result);
	}

}
