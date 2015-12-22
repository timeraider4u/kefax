package at.jku.weiner.c.preprocess.mytests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.jku.weiner.c.common.CommonStandaloneSetup;
import at.jku.weiner.c.common.common.UnaryOperator;
import at.jku.weiner.c.preprocess.utils.expressions.ExpressionEvaluation;
import at.jku.weiner.c.preprocess.utils.expressions.ExpressionLongVisitor;
import at.jku.weiner.c.preprocess.utils.expressions.IExpressionVisitor;
import at.jku.weiner.c.preprocess.utils.macros.DefinitionTable;

import com.google.inject.Injector;

public class TestExpressionEvaluation {

	private UnaryOperator unaryOperatorPlus;
	private UnaryOperator unaryOperatorMinus;
	private UnaryOperator unaryOperatorNot;

	private TestExpressionHelper helperZero;
	private TestExpressionHelper helperOne;
	private TestExpressionHelper helperTwo;
	private TestExpressionHelper helperThree;
	private TestExpressionHelper helperFour;

	private ExpressionEvaluation<Long> evaluater;

	@Before
	public void setUp() throws Exception {
		DefinitionTable.reset();
		Assert.assertEquals(0, DefinitionTable.size());
		this.helperZero = new TestExpressionHelper(ExpressionLongVisitor.FALSE);
		this.helperOne = new TestExpressionHelper(ExpressionLongVisitor.TRUE);
		this.helperTwo = new TestExpressionHelper(2);
		this.helperThree = new TestExpressionHelper(3);
		this.helperFour = new TestExpressionHelper(4);

		this.unaryOperatorPlus = this.helperZero.factory2.createUnaryOperator();
		this.unaryOperatorPlus.setOp("+");
		this.unaryOperatorMinus = this.helperZero.factory2
				.createUnaryOperator();
		this.unaryOperatorMinus.setOp("-");
		this.unaryOperatorNot = this.helperZero.factory2.createUnaryOperator();
		this.unaryOperatorNot.setOp("!");

		final Injector injector = this.getInjector();
		final IExpressionVisitor<Long> visitor = new ExpressionLongVisitor(
				injector, false);
		this.evaluater = new ExpressionEvaluation<Long>(visitor);
	}

	private Injector getInjector() {
		// only do when we are executing tests,
		// but not when in Eclipse environment

		final CommonStandaloneSetup setup = new CommonStandaloneSetup();
		final Injector injector = setup.createInjectorAndDoEMFRegistration();
		return injector;
	}

	@After
	public void tearDown() throws Exception {
		DefinitionTable.reset();
		Assert.assertEquals(0, DefinitionTable.size());
	}

	@Test
	public void testPrimaryExpressionTrue() {
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(this.helperOne.primaryExpression));
	}

	@Test
	public void testPrimaryExpressionFalse() {
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(this.helperZero.primaryExpression));
	}

	@Test
	public void testPostfixExpressionTrue() {
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(this.helperOne.postfixExpression));
	}

	@Test
	public void testPostfixExpressionFalse() {
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(this.helperZero.unaryExpression1));
	}

	@Test
	public void testUnaryExpressionWithoutOperatorTrue() {
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(this.helperOne.unaryExpression1));
	}

	@Test
	public void testUnaryExpressionWithoutOperatorFalse() {
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(this.helperZero.unaryExpression1));
	}

	@Test
	public void testUnaryExpressionTrue1() {
		this.helperOne.unaryExpression2.setOp(this.unaryOperatorPlus);
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(this.helperOne.unaryExpression2));
	}

	@Test
	public void testUnaryExpressionFalse1() {
		this.helperZero.unaryExpression2.setOp(this.unaryOperatorPlus);
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(this.helperZero.unaryExpression2));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testUnaryExpressionIllegalOperator1() {
		final UnaryOperator op = this.helperZero.factory2.createUnaryOperator();
		op.setOp("&");
		this.helperZero.unaryExpression2.setOp(op);
		this.evaluater.walkTo(this.helperZero.unaryExpression2);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testUnaryExpressionIllegalOperator2() {
		final UnaryOperator op = this.helperZero.factory2.createUnaryOperator();
		op.setOp("*");
		this.helperZero.unaryExpression2.setOp(op);
		this.evaluater.walkTo(this.helperZero.unaryExpression2);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testUnaryExpressionIllegalOperator3() {
		final UnaryOperator op = this.helperZero.factory2.createUnaryOperator();
		op.setOp("~");
		this.helperZero.unaryExpression2.setOp(op);
		this.evaluater.walkTo(this.helperZero.unaryExpression2);
	}

	@Test
	public void testUnaryExpressionTrue2() {
		this.helperOne.unaryExpression2.setOp(this.unaryOperatorMinus);
		final Long expected = new Long(-1);
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.helperOne.unaryExpression2));
	}

	@Test
	public void testUnaryExpressionFalse2() {
		this.helperZero.unaryExpression2.setOp(this.unaryOperatorMinus);
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(this.helperZero.unaryExpression2));
	}

	@Test
	public void testUnaryExpressionTrue3() {
		this.helperZero.unaryExpression2.setOp(this.unaryOperatorNot);
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(this.helperZero.unaryExpression2));
	}

	@Test
	public void testUnaryExpressionFalse3a() {
		this.helperOne.unaryExpression2.setOp(this.unaryOperatorNot);
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(this.helperOne.unaryExpression2));
	}

	@Test
	public void testUnaryExpressionFalse3b() {
		this.helperOne.primaryExpression.setConst("-1");
		this.helperOne.unaryExpression2.setOp(this.unaryOperatorNot);
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(this.helperOne.unaryExpression2));
	}

	@Test
	public void testCastExpressionTrue() {
		this.helperOne.unaryExpression2.setOp(this.unaryOperatorPlus);
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(this.helperOne.castExpression2));
	}

	@Test
	public void testCastExpressionFalse() {
		this.helperZero.unaryExpression2.setOp(this.unaryOperatorPlus);
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(this.helperZero.castExpression2));
	}

	@Test
	public void testMultiSimpleTrue() {
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(this.helperOne.multiplicateExpression));
	}

	@Test
	public void testMultiSimpleFalse() {
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(this.helperZero.multiplicateExpression));
	}

	@Test
	public void testMultiExpressionTrue() {
		this.helperThree.multiplicateExpression.getExpr().add(
				this.helperTwo.castExpression2);
		this.helperThree.multiplicateExpression.getOp().add("/");
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(this.helperThree.multiplicateExpression));
	}

	@Test
	public void testMultiExpressionFalse() {
		this.helperThree.multiplicateExpression.getExpr().add(
				this.helperTwo.castExpression2);
		this.helperThree.multiplicateExpression.getOp().add("%");
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(this.helperThree.multiplicateExpression));
	}

	@Test
	public void testMultiMulti() {
		this.helperFour.multiplicateExpression.getExpr().add(
				this.helperTwo.castExpression2);
		this.helperFour.multiplicateExpression.getOp().add("*");
		final Long expected1 = new Long(8);
		Assert.assertEquals(expected1,
				this.evaluater.walkTo(this.helperFour.multiplicateExpression));
		this.helperFour.multiplicateExpression.getExpr().add(
				this.helperThree.castExpression2);
		this.helperFour.multiplicateExpression.getOp().add("%");
		final Long expected2 = new Long(2);
		Assert.assertEquals(expected2,
				this.evaluater.walkTo(this.helperFour.multiplicateExpression));
		this.helperFour.multiplicateExpression.getExpr().add(
				this.helperOne.castExpression2);
		this.helperFour.multiplicateExpression.getOp().add("/");
		final Long expected3 = new Long(2);
		Assert.assertEquals(expected3,
				this.evaluater.walkTo(this.helperFour.multiplicateExpression));
		final TestExpressionHelper helperFive = new TestExpressionHelper(5);
		this.helperFour.multiplicateExpression.getExpr().add(
				helperFive.castExpression2);
		this.helperFour.multiplicateExpression.getOp().add("*");
		final Long expected4 = new Long(10);
		Assert.assertEquals(expected4,
				this.evaluater.walkTo(this.helperFour.multiplicateExpression));
	}

	@Test
	public void testAddTrue() {
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(this.helperOne.additiveExpression));
	}

	@Test
	public void testAddFalse() {
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(this.helperZero.additiveExpression));
	}

	@Test
	public void testAddMulti() {
		this.helperFour.additiveExpression.getExpr().add(
				this.helperTwo.multiplicateExpression);
		this.helperFour.additiveExpression.getOp().add("-");
		final Long expected1 = new Long(2);
		Assert.assertEquals(expected1,
				this.evaluater.walkTo(this.helperFour.additiveExpression));
		this.helperFour.additiveExpression.getExpr().add(
				this.helperThree.multiplicateExpression);
		this.helperFour.additiveExpression.getOp().add("+");
		final Long expected2 = new Long(5);
		Assert.assertEquals(expected2,
				this.evaluater.walkTo(this.helperFour.additiveExpression));
		this.helperFour.additiveExpression.getExpr().add(
				this.helperOne.multiplicateExpression);
		this.helperFour.additiveExpression.getOp().add("+");
		final Long expected3 = new Long(6);
		Assert.assertEquals(expected3,
				this.evaluater.walkTo(this.helperFour.additiveExpression));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddWithNotEnoughOperators() {
		this.helperFour.additiveExpression.getOp().add("-");
		this.evaluater.walkTo(this.helperFour.additiveExpression);
	}

	@Test
	public void testShift() {
		this.helperTwo.additiveExpression.getExpr().add(
				this.helperThree.multiplicateExpression);
		this.helperTwo.additiveExpression.getOp().add("+");
		final Long expected1 = new Long(5);
		Assert.assertEquals(expected1,
				this.evaluater.walkTo(this.helperTwo.shiftExpression));
		// 2 + 3 = 5
		this.helperTwo.shiftExpression.getOp().add(">>");
		this.helperTwo.shiftExpression.getExpr().add(
				this.helperOne.additiveExpression);
		// 5 >> 1 = 2
		final Long expected2 = new Long(2);
		Assert.assertEquals(expected2,
				this.evaluater.walkTo(this.helperTwo.shiftExpression));
	}

	@Test
	public void testPlainRelational() {
		final Long expected = new Long(4);
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.helperFour.shiftExpression));
	}

	@Test
	public void testRelationalSimple() {
		final Long expected = new Long(2);
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.helperTwo.relationalExpression));
	}

	@Test
	public void testRelationalSmallerThan() {
		this.helperTwo.relationalExpression.getExpr().add(
				this.helperThree.shiftExpression);
		this.helperTwo.relationalExpression.getOp().add("<");
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(this.helperTwo.relationalExpression));
	}

	@Test
	public void testRelationalMulti() {
		this.helperThree.additiveExpression.getExpr().add(
				this.helperOne.multiplicateExpression);
		this.helperThree.additiveExpression.getOp().add("+");
		this.helperFour.relationalExpression.getExpr().add(
				this.helperThree.shiftExpression);
		this.helperFour.relationalExpression.getOp().add(">=");
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(this.helperFour.relationalExpression));
		final TestExpressionHelper helperFive = new TestExpressionHelper(5);
		this.helperFour.relationalExpression.getExpr().add(
				helperFive.shiftExpression);
		this.helperFour.relationalExpression.getOp().add(">=");
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(this.helperFour.relationalExpression));
		this.helperFour.relationalExpression.getExpr().add(
				this.helperTwo.shiftExpression);
		this.helperFour.relationalExpression.getOp().add(">");
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(this.helperFour.relationalExpression));
	}

	@Test
	public void testEqualitySimple() {
		final Long expected = new Long(4);
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.helperFour.equalityExpression));
	}

	@Test
	public void testEquality() {
		final TestExpressionHelper myFour = new TestExpressionHelper(4);
		myFour.equalityExpression.getExpr().add(
				this.helperFour.relationalExpression);
		myFour.equalityExpression.getOp().add("==");
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(myFour.equalityExpression));
		myFour.equalityExpression.getExpr().add(
				this.helperThree.relationalExpression);
		myFour.equalityExpression.getOp().add("==");
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(myFour.equalityExpression));
		myFour.equalityExpression.getExpr().add(
				this.helperTwo.relationalExpression);
		myFour.equalityExpression.getOp().add("!=");
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(myFour.equalityExpression));
	}

	@Test
	public void testLogicalSimple() {
		final Long expected1 = new Long(3);
		Assert.assertEquals(expected1,
				this.evaluater.walkTo(this.helperThree.logicalOrExpression));
		final Long expected2 = new Long(4);
		Assert.assertEquals(expected2,
				this.evaluater.walkTo(this.helperFour.logicalAndExpression));
	}

	@Test
	public void testLogical() {
		final TestExpressionHelper myZero = new TestExpressionHelper(0);
		this.helperZero.logicalOrExpression.getExpr().add(
				myZero.logicalAndExpression);
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(this.helperZero.logicalOrExpression));
		this.helperOne.logicalAndExpression.getExpr().add(
				this.helperTwo.inclusiveOrExpression);
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(this.helperOne.logicalAndExpression));
		this.helperZero.logicalOrExpression.getExpr().add(
				this.helperOne.logicalAndExpression);
		// 0 || (1 && 2) ==> 1 || 1 ==> 1
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(this.helperZero.logicalOrExpression));
		final TestExpressionHelper anotherZero = new TestExpressionHelper(0);
		this.helperZero.logicalOrExpression.getExpr().add(
				anotherZero.logicalAndExpression);
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(this.helperZero.logicalOrExpression));
	}

	@Test
	public void testLong1() {
		final Long zero = new Long(0);
		Assert.assertEquals(ExpressionLongVisitor.FALSE, zero);
		Assert.assertTrue(ExpressionLongVisitor.FALSE.equals(zero));

		Assert.assertNotEquals(ExpressionLongVisitor.TRUE, zero);
		Assert.assertFalse(ExpressionLongVisitor.TRUE.equals(zero));
	}

	@Test
	public void testLong2() {
		final Long one = new Long(1);
		Assert.assertEquals(ExpressionLongVisitor.TRUE, one);
		Assert.assertTrue(ExpressionLongVisitor.TRUE.equals(one));

		Assert.assertNotEquals(ExpressionLongVisitor.FALSE, one);
		Assert.assertFalse(ExpressionLongVisitor.FALSE.equals(one));
	}
}
