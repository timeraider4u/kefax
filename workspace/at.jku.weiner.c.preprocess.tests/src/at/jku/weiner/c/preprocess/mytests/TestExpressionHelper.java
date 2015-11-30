package at.jku.weiner.c.preprocess.mytests;

import at.jku.weiner.c.preprocess.preprocess.AdditiveExpression;
import at.jku.weiner.c.preprocess.preprocess.AndExpression;
import at.jku.weiner.c.preprocess.preprocess.CastExpression;
import at.jku.weiner.c.preprocess.preprocess.EqualityExpression;
import at.jku.weiner.c.preprocess.preprocess.ExclusiveOrExpression;
import at.jku.weiner.c.preprocess.preprocess.InclusiveOrExpression;
import at.jku.weiner.c.preprocess.preprocess.LogicalAndExpression;
import at.jku.weiner.c.preprocess.preprocess.LogicalOrExpression;
import at.jku.weiner.c.preprocess.preprocess.MultiplicativeExpression;
import at.jku.weiner.c.preprocess.preprocess.PostfixExpression;
import at.jku.weiner.c.preprocess.preprocess.PreprocessFactory;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.preprocess.RelationalExpression;
import at.jku.weiner.c.preprocess.preprocess.ShiftExpression;
import at.jku.weiner.c.preprocess.preprocess.UnaryExpression;
import at.jku.weiner.c.preprocess.preprocess.UnaryOperator;

public class TestExpressionHelper {
	protected final PreprocessFactory factory = PreprocessFactory.eINSTANCE;

	protected final PrimaryExpression primaryExpression;
	protected final PostfixExpression postfixExpression;
	protected final UnaryExpression unaryExpression1;
	protected final CastExpression castExpression1;
	protected final UnaryExpression unaryExpression2;
	protected final CastExpression castExpression2;
	protected final MultiplicativeExpression multiplicateExpression;
	protected final AdditiveExpression additiveExpression;
	protected final ShiftExpression shiftExpression;
	protected final RelationalExpression relationalExpression;
	protected final EqualityExpression equalityExpression;
	protected final AndExpression andExpression;
	protected final ExclusiveOrExpression exclusiveOrExpression;
	protected final InclusiveOrExpression inclusiveOrExpression;
	protected final LogicalAndExpression logicalAndExpression;
	protected final LogicalOrExpression logicalOrExpression;

	public TestExpressionHelper(final int literal) {
		this.primaryExpression = this.factory.createPrimaryExpression();
		this.primaryExpression.setId("" + literal);
		this.postfixExpression = this.factory.createPostfixExpression();
		this.postfixExpression.setExpr(this.primaryExpression);
		this.unaryExpression1 = this.factory.createUnaryExpression();
		this.unaryExpression1.setExpr(this.postfixExpression);
		this.castExpression1 = this.factory.createCastExpression();
		this.castExpression1.setExpr(this.unaryExpression1);
		this.unaryExpression2 = this.factory.createUnaryExpression();
		this.unaryExpression2.setExpr(this.castExpression1);
		final UnaryOperator op = this.factory.createUnaryOperator();
		op.setOp("+");
		this.unaryExpression2.setOp(op);
		this.castExpression2 = this.factory.createCastExpression();
		this.castExpression2.setExpr(this.unaryExpression2);
		this.multiplicateExpression = this.factory
				.createMultiplicativeExpression();
		this.multiplicateExpression.getExpr().add(this.castExpression2);
		this.additiveExpression = this.factory.createAdditiveExpression();
		this.additiveExpression.getExpr().add(this.multiplicateExpression);
		this.shiftExpression = this.factory.createShiftExpression();
		this.shiftExpression.getExpr().add(this.additiveExpression);
		this.relationalExpression = this.factory.createRelationalExpression();
		this.relationalExpression.getExpr().add(this.shiftExpression);
		this.equalityExpression = this.factory.createEqualityExpression();
		this.equalityExpression.getExpr().add(this.relationalExpression);
		this.andExpression = this.factory.createAndExpression();
		this.andExpression.getExpr().add(this.equalityExpression);
		this.exclusiveOrExpression = this.factory.createExclusiveOrExpression();
		this.exclusiveOrExpression.getExpr().add(this.andExpression);
		this.inclusiveOrExpression = this.factory.createInclusiveOrExpression();
		this.inclusiveOrExpression.getExpr().add(this.exclusiveOrExpression);
		this.logicalAndExpression = this.factory.createLogicalAndExpression();
		this.logicalAndExpression.getExpr().add(this.inclusiveOrExpression);
		this.logicalOrExpression = this.factory.createLogicalOrExpression();
		this.logicalOrExpression.getExpr().add(this.logicalAndExpression);
	}

}
