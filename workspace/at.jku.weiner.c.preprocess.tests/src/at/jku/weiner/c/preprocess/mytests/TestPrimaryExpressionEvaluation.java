package at.jku.weiner.c.preprocess.mytests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.jku.weiner.c.preprocess.preprocess.PreprocessFactory;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.tests.PreprocessInjectorProvider;
import at.jku.weiner.c.preprocess.utils.expressions.ExpressionEvaluation;
import at.jku.weiner.c.preprocess.utils.expressions.ExpressionLongVisitor;
import at.jku.weiner.c.preprocess.utils.expressions.IExpressionVisitor;
import at.jku.weiner.c.preprocess.utils.macros.DefinitionTable;

import com.google.inject.Injector;

public class TestPrimaryExpressionEvaluation {
	private PreprocessFactory factory = PreprocessFactory.eINSTANCE;
	private ExpressionEvaluation<Long> evaluater;
	
	@Before
	public void setUp() throws Exception {
		DefinitionTable.reset();
		Assert.assertEquals(0, DefinitionTable.size());
		this.factory = PreprocessFactory.eINSTANCE;
		final PreprocessInjectorProvider provider = new PreprocessInjectorProvider();
		final Injector injector = provider.getInjector();
		final IExpressionVisitor<Long> visitor = new ExpressionLongVisitor(
				injector);
		this.evaluater = new ExpressionEvaluation<Long>(visitor);
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
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(expression));
	}
	
	@Test
	public void testIDWhichIsDefined() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setId("FOO");
		DefinitionTable.add("FOO", "1");
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(expression));
	}
	
	@Test
	public void testIDWhichIsEmpty2() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setId("FOO");
		DefinitionTable.add("FOO", "BAR");
		DefinitionTable.add("BAR", "0");
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(expression));
	}
	
	@Test
	public void testIDWhichIsDefined2() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setId("FOO");
		DefinitionTable.add("FOO", "BAR");
		DefinitionTable.add("BAR", "1");
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(expression));
	}
	
	@Test
	public void testConstantWhichIsDecimalAndIsFalse() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setConst("0");
		Assert.assertEquals(ExpressionLongVisitor.FALSE,
				this.evaluater.walkTo(expression));
	}
	
	@Test
	public void testConstantWhichIsDecimalAndIsTrue() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setConst("1");
		Assert.assertEquals(ExpressionLongVisitor.TRUE,
				this.evaluater.walkTo(expression));
	}
	
	@Test
	// (expected = NumberFormatException.class)
	public void testConstantWhichIsFloat() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setConst("1.5");
		final Long result = this.evaluater.walkTo(expression);
		final Long expected = ExpressionLongVisitor.FALSE;
		Assert.assertEquals(expected, result);
	}
	
	@Test
	// (expected = NumberFormatException.class)
	public void testConstantWhichIsFloat2() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setConst("1.0");
		final Long result = this.evaluater.walkTo(expression);
		final Long expected = ExpressionLongVisitor.FALSE;
		Assert.assertEquals(expected, result);
	}
	
	@Test
	// (expected = NumberFormatException.class)
	public void testConstantWhichIsString() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setConst("\"hello\"");
		final Long result = this.evaluater.walkTo(expression);
		final Long expected = ExpressionLongVisitor.FALSE;
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void testConstantWhichIsBinary() {
		final PrimaryExpression expression = this.factory
				.createPrimaryExpression();
		expression.setConst("0b001");
		final Long result = this.evaluater.walkTo(expression);
		Assert.assertEquals(ExpressionLongVisitor.TRUE, result);
	}
	
}
