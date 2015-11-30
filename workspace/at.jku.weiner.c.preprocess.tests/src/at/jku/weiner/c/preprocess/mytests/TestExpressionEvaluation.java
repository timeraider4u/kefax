package at.jku.weiner.c.preprocess.mytests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.jku.weiner.c.preprocess.preprocess.UnaryOperator;
import at.jku.weiner.c.preprocess.utils.expressions.ExpressionEvaluation;
import at.jku.weiner.c.preprocess.utils.macros.DefinitionTable;

public class TestExpressionEvaluation {
	private UnaryOperator unaryOperatorPlus;
	private UnaryOperator unaryOperatorMinus;
	private UnaryOperator unaryOperatorNot;

	private TestExpressionHelper helperZero;
	private TestExpressionHelper helperOne;
	private TestExpressionHelper helperTwo;
	private TestExpressionHelper helperThree;
	private TestExpressionHelper helperFour;

	@Before
	public void setUp() throws Exception {
		DefinitionTable.reset();
		Assert.assertEquals(0, DefinitionTable.size());
		this.helperZero = new TestExpressionHelper(ExpressionEvaluation.FALSE);
		this.helperOne = new TestExpressionHelper(ExpressionEvaluation.TRUE);
		this.helperTwo = new TestExpressionHelper(2);
		this.helperThree = new TestExpressionHelper(3);
		this.helperFour = new TestExpressionHelper(4);

		this.unaryOperatorPlus = UnaryOperator.SKW_PLUS;
		this.unaryOperatorMinus = UnaryOperator.SKW_MINUS;
		this.unaryOperatorNot = UnaryOperator.SKW_NOT;
	}

	@After
	public void tearDown() throws Exception {
		DefinitionTable.reset();
		Assert.assertEquals(0, DefinitionTable.size());
	}

	@Test
	public void testPrimaryExpressionTrue() {
		Assert.assertEquals(ExpressionEvaluation.TRUE,
				ExpressionEvaluation.evaluate(this.helperOne.primaryExpression));
	}

	@Test
	public void testPrimaryExpressionFalse() {
		Assert.assertEquals(ExpressionEvaluation.FALSE, ExpressionEvaluation
				.evaluate(this.helperZero.primaryExpression));
	}

	@Test
	public void testPostfixExpressionTrue() {
		Assert.assertEquals(ExpressionEvaluation.TRUE,
				ExpressionEvaluation.evaluate(this.helperOne.postfixExpression));
	}

	@Test
	public void testPostfixExpressionFalse() {
		Assert.assertEquals(ExpressionEvaluation.FALSE,
				ExpressionEvaluation.evaluate(this.helperZero.unaryExpression1));
	}

	@Test
	public void testUnaryExpressionWithoutOperatorTrue() {
		Assert.assertEquals(ExpressionEvaluation.TRUE,
				ExpressionEvaluation.evaluate(this.helperOne.unaryExpression1));
	}

	@Test
	public void testUnaryExpressionWithoutOperatorFalse() {
		Assert.assertEquals(ExpressionEvaluation.FALSE,
				ExpressionEvaluation.evaluate(this.helperZero.unaryExpression1));
	}

	@Test
	public void testUnaryExpressionTrue1() {
		this.helperOne.unaryExpression2.setOp(this.unaryOperatorPlus);
		Assert.assertEquals(ExpressionEvaluation.TRUE,
				ExpressionEvaluation.evaluate(this.helperOne.unaryExpression2));
	}

	@Test
	public void testUnaryExpressionFalse1() {
		this.helperZero.unaryExpression2.setOp(this.unaryOperatorPlus);
		Assert.assertEquals(ExpressionEvaluation.FALSE,
				ExpressionEvaluation.evaluate(this.helperZero.unaryExpression2));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testUnaryExpressionIllegalOperator1() {
		this.helperZero.unaryExpression2.setOp(UnaryOperator.SKW_AND);
		ExpressionEvaluation.evaluate(this.helperZero.unaryExpression2);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testUnaryExpressionIllegalOperator2() {
		this.helperZero.unaryExpression2.setOp(UnaryOperator.SKW_STAR);
		ExpressionEvaluation.evaluate(this.helperZero.unaryExpression2);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testUnaryExpressionIllegalOperator3() {
		this.helperZero.unaryExpression2.setOp(UnaryOperator.SKW_TILDE);
		ExpressionEvaluation.evaluate(this.helperZero.unaryExpression2);
	}

	@Test
	public void testUnaryExpressionTrue2() {
		this.helperOne.unaryExpression2.setOp(this.unaryOperatorMinus);
		Assert.assertEquals(-1,
				ExpressionEvaluation.evaluate(this.helperOne.unaryExpression2));
	}

	@Test
	public void testUnaryExpressionFalse2() {
		this.helperZero.unaryExpression2.setOp(this.unaryOperatorMinus);
		Assert.assertEquals(ExpressionEvaluation.FALSE,
				ExpressionEvaluation.evaluate(this.helperZero.unaryExpression2));
	}

	@Test
	public void testUnaryExpressionTrue3() {
		this.helperZero.unaryExpression2.setOp(this.unaryOperatorNot);
		Assert.assertEquals(ExpressionEvaluation.TRUE,
				ExpressionEvaluation.evaluate(this.helperZero.unaryExpression2));
	}

	@Test
	public void testUnaryExpressionFalse3a() {
		this.helperOne.unaryExpression2.setOp(this.unaryOperatorNot);
		Assert.assertEquals(ExpressionEvaluation.FALSE,
				ExpressionEvaluation.evaluate(this.helperOne.unaryExpression2));
	}

	@Test
	public void testUnaryExpressionFalse3b() {
		this.helperOne.primaryExpression.setConst("-1");
		this.helperOne.unaryExpression2.setOp(this.unaryOperatorNot);
		Assert.assertEquals(ExpressionEvaluation.FALSE,
				ExpressionEvaluation.evaluate(this.helperOne.unaryExpression2));
	}

	@Test
	public void testCastExpressionTrue() {
		this.helperOne.unaryExpression2.setOp(this.unaryOperatorPlus);
		Assert.assertEquals(ExpressionEvaluation.TRUE,
				ExpressionEvaluation.evaluate(this.helperOne.castExpression2));
	}

	@Test
	public void testCastExpressionFalse() {
		this.helperZero.unaryExpression2.setOp(this.unaryOperatorPlus);
		Assert.assertEquals(ExpressionEvaluation.FALSE,
				ExpressionEvaluation.evaluate(this.helperZero.castExpression2));
	}

	@Test
	public void testMultiSimpleTrue() {
		Assert.assertEquals(ExpressionEvaluation.TRUE, ExpressionEvaluation
				.evaluate(this.helperOne.multiplicateExpression));
	}

	@Test
	public void testMultiSimpleFalse() {
		Assert.assertEquals(ExpressionEvaluation.FALSE, ExpressionEvaluation
				.evaluate(this.helperZero.multiplicateExpression));
	}

	@Test
	public void testMultiExpressionTrue() {
		this.helperThree.multiplicateExpression.getExpr().add(
				this.helperTwo.castExpression2);
		this.helperThree.multiplicateExpression.getOp().add("/");
		Assert.assertEquals(ExpressionEvaluation.TRUE, ExpressionEvaluation
				.evaluate(this.helperThree.multiplicateExpression));
	}

	@Test
	public void testMultiExpressionFalse() {
		this.helperThree.multiplicateExpression.getExpr().add(
				this.helperTwo.castExpression2);
		this.helperThree.multiplicateExpression.getOp().add("%");
		Assert.assertEquals(ExpressionEvaluation.TRUE, ExpressionEvaluation
				.evaluate(this.helperThree.multiplicateExpression));
	}

	@Test
	public void testMultiMulti() {
		this.helperFour.multiplicateExpression.getExpr().add(
				this.helperTwo.castExpression2);
		this.helperFour.multiplicateExpression.getOp().add("*");
		Assert.assertEquals(8, ExpressionEvaluation
				.evaluate(this.helperFour.multiplicateExpression));
		this.helperFour.multiplicateExpression.getExpr().add(
				this.helperThree.castExpression2);
		this.helperFour.multiplicateExpression.getOp().add("%");
		Assert.assertEquals(2, ExpressionEvaluation
				.evaluate(this.helperFour.multiplicateExpression));
		this.helperFour.multiplicateExpression.getExpr().add(
				this.helperOne.castExpression2);
		this.helperFour.multiplicateExpression.getOp().add("/");
		Assert.assertEquals(2, ExpressionEvaluation
				.evaluate(this.helperFour.multiplicateExpression));
		final TestExpressionHelper helperFive = new TestExpressionHelper(5);
		this.helperFour.multiplicateExpression.getExpr().add(
				helperFive.castExpression2);
		this.helperFour.multiplicateExpression.getOp().add("*");
		Assert.assertEquals(10, ExpressionEvaluation
				.evaluate(this.helperFour.multiplicateExpression));
	}

	@Test
	public void testAddTrue() {
		Assert.assertEquals(ExpressionEvaluation.TRUE, ExpressionEvaluation
				.evaluate(this.helperOne.additiveExpression));
	}

	@Test
	public void testAddFalse() {
		Assert.assertEquals(ExpressionEvaluation.FALSE, ExpressionEvaluation
				.evaluate(this.helperZero.additiveExpression));
	}

	@Test
	public void testAddMulti() {
		this.helperFour.additiveExpression.getExpr().add(
				this.helperTwo.multiplicateExpression);
		this.helperFour.additiveExpression.getOp().add("-");
		Assert.assertEquals(2, ExpressionEvaluation
				.evaluate(this.helperFour.additiveExpression));
		this.helperFour.additiveExpression.getExpr().add(
				this.helperThree.multiplicateExpression);
		this.helperFour.additiveExpression.getOp().add("+");
		Assert.assertEquals(5, ExpressionEvaluation
				.evaluate(this.helperFour.additiveExpression));
		this.helperFour.additiveExpression.getExpr().add(
				this.helperOne.multiplicateExpression);
		this.helperFour.additiveExpression.getOp().add("+");
		Assert.assertEquals(6, ExpressionEvaluation
				.evaluate(this.helperFour.additiveExpression));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddWithNotEnoughOperators() {
		this.helperFour.additiveExpression.getOp().add("-");
		ExpressionEvaluation.evaluate(this.helperFour.additiveExpression);
	}

	@Test
	public void testShift() {
		this.helperTwo.additiveExpression.getExpr().add(
				this.helperThree.multiplicateExpression);
		this.helperTwo.additiveExpression.getOp().add("+");
		Assert.assertEquals(5,
				ExpressionEvaluation.evaluate(this.helperTwo.shiftExpression));
		// 2 + 3 = 5
		this.helperTwo.shiftExpression.getOp().add(">>");
		this.helperTwo.shiftExpression.getExpr().add(
				this.helperOne.additiveExpression);
		// 5 >> 1 = 2
		Assert.assertEquals(2,
				ExpressionEvaluation.evaluate(this.helperTwo.shiftExpression));
	}

	@Test
	public void testPlainRelational() {
		Assert.assertEquals(4,
				ExpressionEvaluation.evaluate(this.helperFour.shiftExpression));
	}

	@Test
	public void testRelationalSimple() {
		Assert.assertEquals(2, ExpressionEvaluation
				.evaluate(this.helperTwo.relationalExpression));
	}

	@Test
	public void testRelationalSmallerThan() {
		this.helperTwo.relationalExpression.getExpr().add(
				this.helperThree.shiftExpression);
		this.helperTwo.relationalExpression.getOp().add("<");
		Assert.assertEquals(ExpressionEvaluation.TRUE, ExpressionEvaluation
				.evaluate(this.helperTwo.relationalExpression));
	}

	@Test
	public void testRelationalMulti() {
		this.helperThree.additiveExpression.getExpr().add(
				this.helperOne.multiplicateExpression);
		this.helperThree.additiveExpression.getOp().add("+");
		this.helperFour.relationalExpression.getExpr().add(
				this.helperThree.shiftExpression);
		this.helperFour.relationalExpression.getOp().add(">=");
		Assert.assertEquals(ExpressionEvaluation.TRUE, ExpressionEvaluation
				.evaluate(this.helperFour.relationalExpression));
		final TestExpressionHelper helperFive = new TestExpressionHelper(5);
		this.helperFour.relationalExpression.getExpr().add(
				helperFive.shiftExpression);
		this.helperFour.relationalExpression.getOp().add(">=");
		Assert.assertEquals(ExpressionEvaluation.FALSE, ExpressionEvaluation
				.evaluate(this.helperFour.relationalExpression));
		this.helperFour.relationalExpression.getExpr().add(
				this.helperTwo.shiftExpression);
		this.helperFour.relationalExpression.getOp().add(">");
		Assert.assertEquals(ExpressionEvaluation.FALSE, ExpressionEvaluation
				.evaluate(this.helperFour.relationalExpression));
	}

	@Test
	public void testEqualitySimple() {
		Assert.assertEquals(4, ExpressionEvaluation
				.evaluate(this.helperFour.equalityExpression));
	}

	@Test
	public void testEquality() {
		final TestExpressionHelper myFour = new TestExpressionHelper(4);
		myFour.equalityExpression.getExpr().add(
				this.helperFour.relationalExpression);
		myFour.equalityExpression.getOp().add("==");
		Assert.assertEquals(ExpressionEvaluation.TRUE,
				ExpressionEvaluation.evaluate(myFour.equalityExpression));
		myFour.equalityExpression.getExpr().add(
				this.helperThree.relationalExpression);
		myFour.equalityExpression.getOp().add("==");
		Assert.assertEquals(ExpressionEvaluation.FALSE,
				ExpressionEvaluation.evaluate(myFour.equalityExpression));
		myFour.equalityExpression.getExpr().add(
				this.helperTwo.relationalExpression);
		myFour.equalityExpression.getOp().add("!=");
		Assert.assertEquals(ExpressionEvaluation.TRUE,
				ExpressionEvaluation.evaluate(myFour.equalityExpression));
	}

	@Test
	public void testLogicalSimple() {
		Assert.assertEquals(3, ExpressionEvaluation
				.evaluate(this.helperThree.logicalOrExpression));
		Assert.assertEquals(4, ExpressionEvaluation
				.evaluate(this.helperFour.logicalAndExpression));
	}

	@Test
	public void testLogical() {
		final TestExpressionHelper myZero = new TestExpressionHelper(0);
		this.helperZero.logicalOrExpression.getExpr().add(
				myZero.logicalAndExpression);
		Assert.assertEquals(ExpressionEvaluation.FALSE, ExpressionEvaluation
				.evaluate(this.helperZero.logicalOrExpression));
		this.helperOne.logicalAndExpression.getExpr().add(
				this.helperTwo.inclusiveOrExpression);
		Assert.assertEquals(ExpressionEvaluation.TRUE, ExpressionEvaluation
				.evaluate(this.helperOne.logicalAndExpression));
		this.helperZero.logicalOrExpression.getExpr().add(
				this.helperOne.logicalAndExpression);
		// 0 || (1 && 2) ==> 1 || 1 ==> 1
		Assert.assertEquals(ExpressionEvaluation.TRUE, ExpressionEvaluation
				.evaluate(this.helperZero.logicalOrExpression));
		final TestExpressionHelper anotherZero = new TestExpressionHelper(0);
		this.helperZero.logicalOrExpression.getExpr().add(
				anotherZero.logicalAndExpression);
		Assert.assertEquals(ExpressionEvaluation.TRUE, ExpressionEvaluation
				.evaluate(this.helperZero.logicalOrExpression));
	}

}
