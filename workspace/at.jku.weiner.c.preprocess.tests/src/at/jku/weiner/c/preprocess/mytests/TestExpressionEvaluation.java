package at.jku.weiner.c.preprocess.mytests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.jku.weiner.c.preprocess.preprocess.CastExpression;
import at.jku.weiner.c.preprocess.preprocess.PostfixExpression;
import at.jku.weiner.c.preprocess.preprocess.PreprocessFactory;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.preprocess.UnaryExpression;
import at.jku.weiner.c.preprocess.preprocess.UnaryOperator;
import at.jku.weiner.c.preprocess.utils.expressions.ExpressionEvaluation;
import at.jku.weiner.c.preprocess.utils.macros.DefinitionTable;

public class TestExpressionEvaluation {
	private final PreprocessFactory factory = PreprocessFactory.eINSTANCE;

	private PrimaryExpression primaryExpression;
	private PostfixExpression postfixExpression;
	private UnaryExpression unaryExpression1;
	private UnaryExpression unaryExpression2;
	private CastExpression castExpression1;
	private CastExpression castExpression2;

	private UnaryOperator unaryOperator1;
	private UnaryOperator unaryOperator2;
	private UnaryOperator unaryOperator3;

	@Before
	public void setUp() throws Exception {
		DefinitionTable.reset();
		Assert.assertEquals(0, DefinitionTable.size());
		this.primaryExpression = this.factory.createPrimaryExpression();
		this.primaryExpression.setId("1");
		this.postfixExpression = this.factory.createPostfixExpression();
		this.postfixExpression.setExpr(this.primaryExpression);
		this.unaryExpression1 = this.factory.createUnaryExpression();
		this.unaryExpression1.setExpr(this.postfixExpression);
		this.castExpression1 = this.factory.createCastExpression();
		this.castExpression1.setExpr(this.unaryExpression1);
		this.unaryExpression2 = this.factory.createUnaryExpression();
		this.unaryExpression2.setExpr(this.castExpression1);
		this.unaryOperator1 = UnaryOperator.SKW_PLUS;
		this.unaryOperator2 = UnaryOperator.SKW_MINUS;
		this.unaryOperator3 = UnaryOperator.SKW_NOT;

		this.castExpression2 = this.factory.createCastExpression();
		this.castExpression2.setExpr(this.unaryExpression2);
	}

	@After
	public void tearDown() throws Exception {
		DefinitionTable.reset();
		Assert.assertEquals(0, DefinitionTable.size());
	}

	@Test
	public void testPrimaryExpressionTrue() {
		Assert.assertEquals(ExpressionEvaluation.TRUE,
				ExpressionEvaluation.evaluate(this.primaryExpression));
	}

	@Test
	public void testPrimaryExpressionFalse() {
		this.primaryExpression.setConst("0");
		Assert.assertEquals(ExpressionEvaluation.FALSE,
				ExpressionEvaluation.evaluate(this.primaryExpression));
	}

	@Test
	public void testPostfixExpressionTrue() {
		Assert.assertEquals(ExpressionEvaluation.TRUE,
				ExpressionEvaluation.evaluate(this.postfixExpression));
	}

	@Test
	public void testPostfixExpressionFalse() {
		this.primaryExpression.setConst("0");
		Assert.assertEquals(ExpressionEvaluation.FALSE,
				ExpressionEvaluation.evaluate(this.unaryExpression1));
	}

	@Test
	public void testUnaryExpressionWithoutOperatorTrue() {

	}

	@Test
	public void testUnaryExpressionWithoutOperatorFalse() {
		this.primaryExpression.setConst("0");
		Assert.assertEquals(ExpressionEvaluation.FALSE,
				ExpressionEvaluation.evaluate(this.unaryExpression1));
	}

	@Test
	public void testUnaryExpressionTrue1() {
		this.unaryExpression2.setOp(this.unaryOperator1);
		Assert.assertEquals(ExpressionEvaluation.TRUE,
				ExpressionEvaluation.evaluate(this.unaryExpression2));
	}

	@Test
	public void testUnaryExpressionFalse1() {
		this.primaryExpression.setConst("0");
		this.unaryExpression2.setOp(this.unaryOperator1);
		Assert.assertEquals(ExpressionEvaluation.FALSE,
				ExpressionEvaluation.evaluate(this.unaryExpression2));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testUnaryExpressionIllegalOperator1() {
		this.unaryExpression2.setOp(UnaryOperator.SKW_AND);
		ExpressionEvaluation.evaluate(this.unaryExpression2);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testUnaryExpressionIllegalOperator2() {
		this.unaryExpression2.setOp(UnaryOperator.SKW_STAR);
		ExpressionEvaluation.evaluate(this.unaryExpression2);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testUnaryExpressionIllegalOperator3() {
		this.unaryExpression2.setOp(UnaryOperator.SKW_TILDE);
		ExpressionEvaluation.evaluate(this.unaryExpression2);
	}

	@Test
	public void testUnaryExpressionTrue2() {
		this.unaryExpression2.setOp(this.unaryOperator2);
		Assert.assertEquals(-1,
				ExpressionEvaluation.evaluate(this.unaryExpression2));
	}

	@Test
	public void testUnaryExpressionFalse2() {
		this.primaryExpression.setConst("0");
		this.unaryExpression2.setOp(this.unaryOperator2);
		Assert.assertEquals(ExpressionEvaluation.FALSE,
				ExpressionEvaluation.evaluate(this.unaryExpression2));
	}

	@Test
	public void testUnaryExpressionTrue3() {
		this.primaryExpression.setConst("0");
		this.unaryExpression2.setOp(this.unaryOperator3);
		Assert.assertEquals(ExpressionEvaluation.TRUE,
				ExpressionEvaluation.evaluate(this.unaryExpression2));
	}

	@Test
	public void testUnaryExpressionFalse3a() {
		this.primaryExpression.setConst("-1");
		this.unaryExpression2.setOp(this.unaryOperator3);
		Assert.assertEquals(ExpressionEvaluation.FALSE,
				ExpressionEvaluation.evaluate(this.unaryExpression2));
	}

	@Test
	public void testUnaryExpressionFalse3b() {
		this.unaryExpression2.setOp(this.unaryOperator3);
		Assert.assertEquals(ExpressionEvaluation.FALSE,
				ExpressionEvaluation.evaluate(this.unaryExpression2));
	}

	@Test
	public void testCastExpressionTrue() {
		this.unaryExpression2.setOp(this.unaryOperator1);
		Assert.assertEquals(ExpressionEvaluation.TRUE,
				ExpressionEvaluation.evaluate(this.castExpression2));
	}

	@Test
	public void testCastExpressionFalse() {
		this.primaryExpression.setConst("0");
		this.unaryExpression2.setOp(this.unaryOperator1);
		Assert.assertEquals(ExpressionEvaluation.FALSE,
				ExpressionEvaluation.evaluate(this.castExpression2));
	}
}
