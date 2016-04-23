package at.jku.weiner.c.preprocess.mytests;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import at.jku.weiner.c.common.CommonStandaloneSetup;
import at.jku.weiner.c.common.common.AdditiveExpression;
import at.jku.weiner.c.common.common.AndExpression;
import at.jku.weiner.c.common.common.CommonFactory;
import at.jku.weiner.c.common.common.EqualityExpression;
import at.jku.weiner.c.common.common.ExclusiveOrExpression;
import at.jku.weiner.c.common.common.InclusiveOrExpression;
import at.jku.weiner.c.common.common.LogicalAndExpression;
import at.jku.weiner.c.common.common.LogicalOrExpression;
import at.jku.weiner.c.common.common.MultiplicativeExpression;
import at.jku.weiner.c.common.common.PostfixExpression;
import at.jku.weiner.c.common.common.RelationalExpression;
import at.jku.weiner.c.common.common.ShiftExpression;
import at.jku.weiner.c.common.common.UnaryExpression;
import at.jku.weiner.c.preprocess.parser.antlr.internal.InternalPreprocessLexer;
import at.jku.weiner.c.preprocess.preprocess.PreprocessFactory;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.tests.PreprocessInjectorProvider;
import at.jku.weiner.c.preprocess.utils.LexerUtils;
import at.jku.weiner.c.preprocess.utils.expressions.ExpressionEvaluation;
import at.jku.weiner.c.preprocess.utils.expressions.ExpressionLongVisitor;
import at.jku.weiner.c.preprocess.utils.expressions.IExpressionVisitor;
import at.jku.weiner.c.preprocess.utils.macros.DefinitionTable;
import at.jku.weiner.log.MyLog;

import com.google.inject.Inject;
import com.google.inject.Injector;

@RunWith(XtextRunner.class)
@InjectWith(PreprocessInjectorProvider.class)
public class TestExpressionEvaluation {

	protected final PreprocessFactory factory1 = PreprocessFactory.eINSTANCE;
	protected final CommonFactory factory2 = CommonFactory.eINSTANCE;

	private String unaryOperatorPlus;
	private String unaryOperatorMinus;
	private String unaryOperatorNot;

	private ExpressionEvaluation<Long> evaluater;

	@Inject
	private InternalPreprocessLexer lexer;
	@Inject
	private ITokenDefProvider tokenDefProvider;

	private DefinitionTable definitionTable;

	protected PrimaryExpression primaryExpression1;
	protected PrimaryExpression primaryExpression2;
	protected PrimaryExpression primaryExpression3;
	protected PrimaryExpression primaryExpression4;

	protected PostfixExpression postfixExpression;
	protected UnaryExpression unaryExpression;
	protected MultiplicativeExpression multiplicateExpression;
	protected AdditiveExpression additiveExpression;
	protected ShiftExpression shiftExpression;
	protected RelationalExpression relationalExpression;
	protected EqualityExpression equalityExpression;
	protected AndExpression andExpression;
	protected ExclusiveOrExpression exclusiveOrExpression;
	protected InclusiveOrExpression inclusiveOrExpression;
	protected LogicalAndExpression logicalAndExpression;
	protected LogicalOrExpression logicalOrExpression;

	@Before
	public void setUp() throws Exception {
		MyLog.setLog_level(MyLog.LOG_NONE);
		final LexerUtils lexerUtils = new LexerUtils(this.lexer,
				this.tokenDefProvider);
		this.definitionTable = new DefinitionTable(lexerUtils);
		this.definitionTable.reset();
		Assert.assertEquals(0, this.definitionTable.size());
		this.primaryExpression1 = this.factory1.createPrimaryExpression();
		this.primaryExpression2 = this.factory1.createPrimaryExpression();
		this.primaryExpression3 = this.factory1.createPrimaryExpression();
		this.primaryExpression4 = this.factory1.createPrimaryExpression();

		this.unaryExpression = this.factory2.createUnaryExpression();
		this.multiplicateExpression = this.factory2
				.createMultiplicativeExpression();
		this.additiveExpression = this.factory2.createAdditiveExpression();
		this.shiftExpression = this.factory2.createShiftExpression();
		this.relationalExpression = this.factory2.createRelationalExpression();
		this.equalityExpression = this.factory2.createEqualityExpression();
		this.andExpression = this.factory2.createAndExpression();
		this.exclusiveOrExpression = this.factory2
				.createExclusiveOrExpression();
		this.inclusiveOrExpression = this.factory2
				.createInclusiveOrExpression();
		this.logicalAndExpression = this.factory2.createLogicalAndExpression();
		this.logicalOrExpression = this.factory2.createLogicalOrExpression();

		this.unaryOperatorPlus = "+";
		this.unaryOperatorMinus = "-";
		this.unaryOperatorNot = "!";

		final Injector injector = this.getInjector();
		final IExpressionVisitor<Long> visitor = new ExpressionLongVisitor(
				injector, this.definitionTable);
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
		this.definitionTable.reset();
		Assert.assertEquals(0, this.definitionTable.size());
	}

	@Test(timeout = 1000)
	public void testPrimaryExpressionTrue() {
		this.primaryExpression1.setConst("1");
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(this.primaryExpression1));
	}

	@Test(timeout = 1000)
	public void testPrimaryExpressionFalse() {
		this.primaryExpression1.setConst("0");
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(this.primaryExpression1));
	}

	@Test(timeout = 1000)
	public void testUnaryExpressionTrue1() {
		this.primaryExpression1.setConst("1");
		this.unaryExpression.setOp(this.unaryOperatorPlus);
		this.unaryExpression.setExpr(this.primaryExpression1);
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(this.unaryExpression));
	}

	@Test(timeout = 1000)
	public void testUnaryExpressionFalse1() {
		this.primaryExpression1.setConst("0");
		this.unaryExpression.setOp(this.unaryOperatorPlus);
		this.unaryExpression.setExpr(this.primaryExpression1);
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(this.unaryExpression));
	}

	@Test(expected = UnsupportedOperationException.class, timeout = 1000)
	public void testUnaryExpressionIllegalOperator1() {
		final String op = "&";
		this.primaryExpression1.setConst("0");
		this.unaryExpression.setOp(op);
		this.unaryExpression.setExpr(this.primaryExpression1);
		this.evaluater.walkTo(this.unaryExpression);
	}

	@Test(expected = UnsupportedOperationException.class, timeout = 1000)
	public void testUnaryExpressionIllegalOperator2() {
		final String op = "*";
		this.primaryExpression1.setConst("0");
		this.unaryExpression.setOp(op);
		this.unaryExpression.setExpr(this.primaryExpression1);
		this.evaluater.walkTo(this.unaryExpression);
	}

	@Test(expected = UnsupportedOperationException.class, timeout = 1000)
	public void testUnaryExpressionIllegalOperator3() {
		final String op = "~";
		this.primaryExpression1.setConst("0");
		this.unaryExpression.setOp(op);
		this.unaryExpression.setExpr(this.primaryExpression1);
		this.evaluater.walkTo(this.unaryExpression);
	}

	@Test(timeout = 1000)
	public void testUnaryExpressionTrue2() {
		this.primaryExpression1.setConst("1");
		this.unaryExpression.setOp(this.unaryOperatorMinus);
		this.unaryExpression.setExpr(this.primaryExpression1);
		final Long expected = new Long(-1);
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.unaryExpression));
	}

	@Test(timeout = 1000)
	public void testUnaryExpressionFalse2() {
		this.primaryExpression1.setConst("0");
		this.unaryExpression.setOp(this.unaryOperatorMinus);
		this.unaryExpression.setExpr(this.primaryExpression1);
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(this.unaryExpression));
	}

	@Test(timeout = 1000)
	public void testUnaryExpressionTrue3() {
		this.primaryExpression1.setConst("0");
		this.unaryExpression.setOp(this.unaryOperatorNot);
		this.unaryExpression.setExpr(this.primaryExpression1);
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(this.unaryExpression));
	}

	@Test(timeout = 1000)
	public void testUnaryExpressionFalse3a() {
		this.primaryExpression1.setConst("1");
		this.unaryExpression.setOp(this.unaryOperatorNot);
		this.unaryExpression.setExpr(this.primaryExpression1);
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(this.unaryExpression));
	}

	@Test(timeout = 1000)
	public void testUnaryExpressionFalse3b() {
		this.primaryExpression1.setConst("-1");
		this.unaryExpression.setOp(this.unaryOperatorNot);
		this.unaryExpression.setExpr(this.primaryExpression1);
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(this.unaryExpression));
	}

	@Test(timeout = 1000)
	public void testMultiExpressionTrue() {
		this.primaryExpression1.setConst("3");
		this.primaryExpression2.setConst("2");
		this.multiplicateExpression.setLeft(this.primaryExpression1);
		this.multiplicateExpression.setOp("/");
		this.multiplicateExpression.setRight(this.primaryExpression2);
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(this.multiplicateExpression));
	}

	@Test(timeout = 1000)
	public void testMultiExpressionFalse() {
		this.primaryExpression1.setConst("3");
		this.primaryExpression2.setConst("2");
		this.multiplicateExpression.setLeft(this.primaryExpression1);
		this.multiplicateExpression.setOp("%");
		this.multiplicateExpression.setRight(this.primaryExpression2);
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(this.multiplicateExpression));
	}

	@Test(timeout = 1000)
	public void testMult1() {
		this.primaryExpression1.setConst("4");
		this.primaryExpression2.setConst("2");
		this.multiplicateExpression.setLeft(this.primaryExpression1);
		this.multiplicateExpression.setOp("*");
		this.multiplicateExpression.setRight(this.primaryExpression2);

		final Long expected = new Long(8);
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.multiplicateExpression));
	}

	@Test(timeout = 1000)
	public void testMult2() {
		this.primaryExpression1.setConst("8");
		this.primaryExpression2.setConst("3");
		this.multiplicateExpression.setLeft(this.primaryExpression1);
		this.multiplicateExpression.setOp("%");
		this.multiplicateExpression.setRight(this.primaryExpression2);

		final Long expected = new Long(2);
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.multiplicateExpression));
	}

	@Test(timeout = 1000)
	public void testMult3() {
		this.primaryExpression1.setConst("2");
		this.primaryExpression2.setConst("1");
		this.multiplicateExpression.setLeft(this.primaryExpression1);
		this.multiplicateExpression.setOp("/");
		this.multiplicateExpression.setRight(this.primaryExpression2);

		final Long expected = new Long(2);
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.multiplicateExpression));
	}

	@Test(timeout = 1000)
	public void testMult4() {
		this.primaryExpression1.setConst("2");
		this.primaryExpression2.setConst("5");
		this.multiplicateExpression.setLeft(this.primaryExpression1);
		this.multiplicateExpression.setOp("*");
		this.multiplicateExpression.setRight(this.primaryExpression2);

		final Long expected = new Long(10);
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.multiplicateExpression));
	}

	@Test(timeout = 1000)
	public void testAdd1() {
		this.primaryExpression1.setConst("4");
		this.primaryExpression2.setConst("2");
		this.additiveExpression.setLeft(this.primaryExpression1);
		this.additiveExpression.setOp("-");
		this.additiveExpression.setRight(this.primaryExpression2);

		final Long expected = new Long(2);
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.additiveExpression));
	}

	@Test(timeout = 1000)
	public void testAdd2() {
		this.primaryExpression1.setConst("2");
		this.primaryExpression2.setConst("3");
		this.additiveExpression.setLeft(this.primaryExpression1);
		this.additiveExpression.setOp("+");
		this.additiveExpression.setRight(this.primaryExpression2);

		final Long expected = new Long(5);
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.additiveExpression));
	}

	@Test(timeout = 1000)
	public void testAdd3() {
		this.primaryExpression1.setConst("5");
		this.primaryExpression2.setConst("1");
		this.additiveExpression.setLeft(this.primaryExpression1);
		this.additiveExpression.setOp("+");
		this.additiveExpression.setRight(this.primaryExpression2);

		final Long expected = new Long(6);
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.additiveExpression));
	}

	@Test(expected = IllegalArgumentException.class, timeout = 1000)
	public void testAddWithNotEnoughOperators() {
		this.additiveExpression.setLeft(this.primaryExpression1);
		this.additiveExpression.setOp("-");
		this.additiveExpression.setRight(null);
		this.evaluater.walkTo(this.additiveExpression);
	}

	@Test(timeout = 1000)
	public void testAdd4() {
		this.primaryExpression1.setConst("2");
		this.primaryExpression2.setConst("3");
		this.additiveExpression.setLeft(this.primaryExpression1);
		this.additiveExpression.setOp("+");
		this.additiveExpression.setRight(this.primaryExpression2);

		// 2 + 3 = 5
		final Long expected = new Long(5);
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.additiveExpression));
	}

	@Test(timeout = 1000)
	public void testShift1() {
		this.primaryExpression1.setConst("5");
		this.primaryExpression2.setConst("1");
		this.shiftExpression.setLeft(this.primaryExpression1);
		this.shiftExpression.setOp(">>");
		this.shiftExpression.setRight(this.primaryExpression2);

		// 5 >> 1 = 2
		final Long expected = new Long(2);
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.shiftExpression));
	}

	@Test(timeout = 1000)
	public void testRelational1() {
		this.primaryExpression1.setConst("2");
		this.primaryExpression2.setConst("3");
		this.relationalExpression.setLeft(this.primaryExpression1);
		this.relationalExpression.setOp("<");
		this.relationalExpression.setRight(this.primaryExpression2);

		// 2 < 3
		final Long expected = ExpressionLongVisitor.TRUE;
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.relationalExpression));
	}

	@Test(timeout = 1000)
	public void testRelational2() {
		this.primaryExpression1.setConst("2");
		this.primaryExpression2.setConst("3");
		this.primaryExpression3.setConst("4");
		this.additiveExpression.setLeft(this.primaryExpression1);
		this.additiveExpression.setOp("+");
		this.additiveExpression.setRight(this.primaryExpression2);
		this.relationalExpression.setLeft(this.additiveExpression);
		this.relationalExpression.setOp(">=");
		this.relationalExpression.setRight(this.primaryExpression3);

		// 2 + 3 >= 4
		final Long expected = ExpressionLongVisitor.TRUE;
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.relationalExpression));
	}

	@Test(timeout = 1000)
	public void testRelational3() {
		this.primaryExpression1.setConst("2");
		this.primaryExpression2.setConst("3");
		this.primaryExpression3.setConst("5");
		this.additiveExpression.setLeft(this.primaryExpression1);
		this.additiveExpression.setOp("+");
		this.additiveExpression.setRight(this.primaryExpression2);
		this.relationalExpression.setLeft(this.additiveExpression);
		this.relationalExpression.setOp(">=");
		this.relationalExpression.setRight(this.primaryExpression3);

		// 2 + 3 >= 5
		final Long expected = ExpressionLongVisitor.TRUE;
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.relationalExpression));
	}

	@Test(timeout = 1000)
	public void testRelational4() {
		this.primaryExpression1.setConst("2");
		this.primaryExpression2.setConst("3");
		this.primaryExpression3.setConst("6");
		this.additiveExpression.setLeft(this.primaryExpression1);
		this.additiveExpression.setOp("+");
		this.additiveExpression.setRight(this.primaryExpression2);
		this.relationalExpression.setLeft(this.additiveExpression);
		this.relationalExpression.setOp(">=");
		this.relationalExpression.setRight(this.primaryExpression3);

		// 2 + 3 >= 6
		final Long expected = ExpressionLongVisitor.FALSE;
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.relationalExpression));
	}

	@Test(timeout = 1000)
	public void testRelational5() {
		this.primaryExpression1.setConst("3");
		this.primaryExpression2.setConst("1");
		this.primaryExpression3.setConst("4");
		this.additiveExpression.setLeft(this.primaryExpression1);
		this.additiveExpression.setOp("+");
		this.additiveExpression.setRight(this.primaryExpression2);
		this.relationalExpression.setLeft(this.additiveExpression);
		this.relationalExpression.setOp(">=");
		this.relationalExpression.setRight(this.primaryExpression3);

		// 3 + 1 >= 4
		final Long expected = ExpressionLongVisitor.TRUE;
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.relationalExpression));
	}

	@Test(timeout = 1000)
	public void testRelational6() {
		this.primaryExpression1.setConst("4");
		this.primaryExpression2.setConst("5");
		this.relationalExpression.setLeft(this.primaryExpression1);
		this.relationalExpression.setOp(">=");
		this.relationalExpression.setRight(this.primaryExpression2);

		// 4 >= 5
		final Long expected = ExpressionLongVisitor.FALSE;
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.relationalExpression));
	}

	@Test(timeout = 1000)
	public void testRelational7() {
		this.primaryExpression1.setConst("4");
		this.primaryExpression2.setConst("5");
		this.relationalExpression.setLeft(this.primaryExpression1);
		this.relationalExpression.setOp(">");
		this.relationalExpression.setRight(this.primaryExpression2);

		// 4 >= 5
		final Long expected = ExpressionLongVisitor.FALSE;
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.relationalExpression));
	}

	@Test(timeout = 1000)
	public void testRelational8() {
		this.primaryExpression1.setConst("4");
		this.primaryExpression2.setConst("5");
		this.relationalExpression.setLeft(this.primaryExpression1);
		this.relationalExpression.setOp("<");
		this.relationalExpression.setRight(this.primaryExpression2);

		// 4 < 5
		final Long expected = ExpressionLongVisitor.TRUE;
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.relationalExpression));
	}

	@Test(timeout = 1000)
	public void testRelational9() {
		this.primaryExpression1.setConst("4");
		this.primaryExpression2.setConst("5");
		this.relationalExpression.setLeft(this.primaryExpression1);
		this.relationalExpression.setOp("<=");
		this.relationalExpression.setRight(this.primaryExpression2);

		// 4 <= 5
		final Long expected = ExpressionLongVisitor.TRUE;
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.relationalExpression));
	}

	@Test(timeout = 1000)
	public void testEquality1() {
		this.primaryExpression1.setConst("4");
		this.primaryExpression2.setConst("4");
		this.equalityExpression.setLeft(this.primaryExpression1);
		this.equalityExpression.setOp("==");
		this.equalityExpression.setRight(this.primaryExpression2);

		// 4 == 4
		final Long expected = ExpressionLongVisitor.TRUE;
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.equalityExpression));
	}

	@Test(timeout = 1000)
	public void testEquality2() {
		this.primaryExpression1.setConst("4");
		this.primaryExpression2.setConst("3");
		this.equalityExpression.setLeft(this.primaryExpression1);
		this.equalityExpression.setOp("==");
		this.equalityExpression.setRight(this.primaryExpression2);

		// 4 == 3
		final Long expected = ExpressionLongVisitor.FALSE;
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.equalityExpression));
	}

	@Test(timeout = 1000)
	public void testEquality3() {
		this.primaryExpression1.setConst("4");
		this.primaryExpression2.setConst("3");
		this.equalityExpression.setLeft(this.primaryExpression1);
		this.equalityExpression.setOp("!=");
		this.equalityExpression.setRight(this.primaryExpression2);

		// 4 == 3
		final Long expected = ExpressionLongVisitor.TRUE;
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.equalityExpression));
	}

	@Test(timeout = 1000)
	public void testLogicalAnd1() {
		this.primaryExpression1.setConst("1");
		this.primaryExpression2.setConst("2");
		this.logicalAndExpression.setLeft(this.primaryExpression1);
		this.logicalAndExpression.setRight(this.primaryExpression2);

		// 1 && 2
		final Long expected = new Long(1);
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.logicalAndExpression));
	}

	@Test(timeout = 1000)
	public void testLogicalOr1() {
		this.primaryExpression1.setConst("0");
		this.primaryExpression2.setConst("1");
		this.logicalOrExpression.setLeft(this.primaryExpression1);
		this.logicalOrExpression.setRight(this.primaryExpression2);

		// 0 || 1
		final Long expected = new Long(1);
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.logicalOrExpression));
	}

	@Test(timeout = 1000)
	public void testLogicalOr2() {
		this.primaryExpression1.setConst("1");
		this.primaryExpression2.setConst("1");
		this.logicalOrExpression.setLeft(this.primaryExpression1);
		this.logicalOrExpression.setRight(this.primaryExpression2);

		// 1 || 1
		final Long expected = new Long(1);
		Assert.assertEquals(expected,
				this.evaluater.walkTo(this.logicalOrExpression));
	}

	@Test(timeout = 1000)
	public void testLong1() {
		final Long zero = new Long(0);
		Assert.assertEquals(ExpressionLongVisitor.FALSE, zero);
		Assert.assertTrue(ExpressionLongVisitor.FALSE.equals(zero));

		Assert.assertNotEquals(ExpressionLongVisitor.TRUE, zero);
		Assert.assertFalse(ExpressionLongVisitor.TRUE.equals(zero));
	}

	@Test(timeout = 1000)
	public void testLong2() {
		final Long one = new Long(1);
		Assert.assertEquals(ExpressionLongVisitor.TRUE, one);
		Assert.assertTrue(ExpressionLongVisitor.TRUE.equals(one));

		Assert.assertNotEquals(ExpressionLongVisitor.FALSE, one);
		Assert.assertFalse(ExpressionLongVisitor.FALSE.equals(one));
	}

}
