package at.jku.weiner.c.preprocess.mytests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.jku.weiner.c.preprocess.preprocess.PreprocessFactory;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.utils.expressions.ExpressionEvaluation;
import at.jku.weiner.c.preprocess.utils.macros.DefinitionTable;

public class TestPrimaryExpressionEvaluation {
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
		Assert.assertEquals(ExpressionEvaluation.FALSE,
				ExpressionEvaluation.evaluate(expression));
	}

	@Test
	public void testIDWhichIsDefined() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setId("FOO");
		DefinitionTable.add("FOO", "1");
		Assert.assertEquals(ExpressionEvaluation.TRUE,
				ExpressionEvaluation.evaluate(expression));
	}

	@Test
	public void testIDWhichIsEmpty2() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setId("FOO");
		DefinitionTable.add("FOO", "BAR");
		DefinitionTable.add("BAR", "0");
		Assert.assertEquals(ExpressionEvaluation.FALSE,
				ExpressionEvaluation.evaluate(expression));
	}

	@Test
	public void testIDWhichIsDefined2() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setId("FOO");
		DefinitionTable.add("FOO", "BAR");
		DefinitionTable.add("BAR", "1");
		Assert.assertEquals(ExpressionEvaluation.TRUE,
				ExpressionEvaluation.evaluate(expression));
	}

	@Test
	public void testConstantWhichIsDecimalAndIsFalse() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setConst("0");
		Assert.assertEquals(ExpressionEvaluation.FALSE,
				ExpressionEvaluation.evaluate(expression));
	}

	@Test
	public void testConstantWhichIsDecimalAndIsTrue() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setConst("1");
		Assert.assertEquals(ExpressionEvaluation.TRUE,
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
	public void testConstantWhichIsFloat2() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setConst("1.0");
		ExpressionEvaluation.evaluate(expression);
	}

	@Test(expected = NumberFormatException.class)
	public void testConstantWhichIsString() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setConst("\"hello\"");
		ExpressionEvaluation.evaluate(expression);
	}

	@Test
	public void testConstantWhichIsBinary() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setConst("0b001");
		final int result = ExpressionEvaluation.evaluate(expression);
		Assert.assertEquals(ExpressionEvaluation.TRUE, result);
	}

}