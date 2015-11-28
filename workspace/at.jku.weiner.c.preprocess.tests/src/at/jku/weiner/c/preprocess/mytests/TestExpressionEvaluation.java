package at.jku.weiner.c.preprocess.mytests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.jku.weiner.c.preprocess.preprocess.PreprocessFactory;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.utils.expressions.ExpressionEvaluation;
import at.jku.weiner.c.preprocess.utils.macros.DefinitionTable;

public class TestExpressionEvaluation {
	private static final int FALSE = 0;
	private static final int TRUE = 1;
	private PreprocessFactory factory = PreprocessFactory.eINSTANCE;

	@Before
	public void setUp() throws Exception {
		DefinitionTable.reset();
		Assert.assertEquals(0, DefinitionTable.size());
		this.factory = PreprocessFactory.eINSTANCE;
	}

	@After
	public void tearDown() throws Exception {
		DefinitionTable.reset();
		Assert.assertEquals(0, DefinitionTable.size());
	}

	@Test
	public void testIDWhichIsEmpty() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setId("FOO");
		Assert.assertEquals(TestExpressionEvaluation.FALSE,
				ExpressionEvaluation.evaluate(expression));
	}

	@Test
	public void testIDWhichIsDefined() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setId("FOO");
		DefinitionTable.add("FOO", "1");
		Assert.assertEquals(TestExpressionEvaluation.TRUE,
				ExpressionEvaluation.evaluate(expression));
	}

	@Test
	public void testIDWhichIsEmpty2() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setId("FOO");
		DefinitionTable.add("FOO", "BAR");
		DefinitionTable.add("BAR", "0");
		Assert.assertEquals(TestExpressionEvaluation.FALSE,
				ExpressionEvaluation.evaluate(expression));
	}

	@Test
	public void testIDWhichIsDefined2() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setId("FOO");
		DefinitionTable.add("FOO", "BAR");
		DefinitionTable.add("BAR", "1");
		Assert.assertEquals(TestExpressionEvaluation.TRUE,
				ExpressionEvaluation.evaluate(expression));
	}

	@Test
	public void testConstantWhichIsDecimalAndIsFalse() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setConst("0");
		Assert.assertEquals(TestExpressionEvaluation.FALSE,
				ExpressionEvaluation.evaluate(expression));
	}

	@Test
	public void testConstantWhichIsDecimalAndIsTrue() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setConst("1");
		Assert.assertEquals(TestExpressionEvaluation.TRUE,
				ExpressionEvaluation.evaluate(expression));
	}

	@Test(expected = NumberFormatException.class)
	public void testConstantWhichIsFloat() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setConst("1.5");
		ExpressionEvaluation.evaluate(expression);
	}

	@Test(expected = NumberFormatException.class)
	public void testConstantWhichIsString() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setConst("\"hello\"");
		ExpressionEvaluation.evaluate(expression);
	}

}
