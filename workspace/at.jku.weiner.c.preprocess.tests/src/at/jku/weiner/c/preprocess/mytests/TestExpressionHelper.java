package at.jku.weiner.c.preprocess.mytests;

import at.jku.weiner.c.common.common.AdditiveExpression;
import at.jku.weiner.c.common.common.AndExpression;
import at.jku.weiner.c.common.common.CastExpression;
import at.jku.weiner.c.common.common.CommonFactory;
import at.jku.weiner.c.common.common.EqualityExpression;
import at.jku.weiner.c.common.common.ExclusiveOrExpression;
import at.jku.weiner.c.common.common.InclusiveOrExpression;
import at.jku.weiner.c.common.common.LogicalAndExpression;
import at.jku.weiner.c.common.common.LogicalOrExpression;
import at.jku.weiner.c.common.common.MultiplicativeExpression;
import at.jku.weiner.c.common.common.PostfixExpression;
import at.jku.weiner.c.preprocess.preprocess.PreprocessFactory;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.common.common.RelationalExpression;
import at.jku.weiner.c.common.common.ShiftExpression;
import at.jku.weiner.c.common.common.UnaryExpression;
import at.jku.weiner.c.common.common.UnaryOperator;

public class TestExpressionHelper {
	protected final PreprocessFactory factory1 = PreprocessFactory.eINSTANCE;
	protected final CommonFactory factory2 = CommonFactory.eINSTANCE;

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

	public TestExpressionHelper(final Integer literal) {
		this(literal.intValue());
	}

	public TestExpressionHelper(final int literal) {
		this.primaryExpression = this.factory1.createPrimaryExpression();
		this.primaryExpression.setId("" + literal);
		this.postfixExpression = this.factory2.createPostfixExpression();
		this.postfixExpression.setExpr(this.primaryExpression);
		this.unaryExpression1 = this.factory2.createUnaryExpression();
		this.unaryExpression1.setExpr(this.postfixExpression);
		this.castExpression1 = this.factory2.createCastExpression();
		this.castExpression1.setExpr(this.unaryExpression1);
		this.unaryExpression2 = this.factory2.createUnaryExpression();
		this.unaryExpression2.setExpr(this.castExpression1);
		final UnaryOperator op = this.factory2.createUnaryOperator();
		op.setOp("+");
		this.unaryExpression2.setOp(op);
		this.castExpression2 = this.factory2.createCastExpression();
		this.castExpression2.setExpr(this.unaryExpression2);
		this.multiplicateExpression = this.factory2
				.createMultiplicativeExpression();
		this.multiplicateExpression.getExpr().add(this.castExpression2);
		this.additiveExpression = this.factory2.createAdditiveExpression();
		this.additiveExpression.getExpr().add(this.multiplicateExpression);
		this.shiftExpression = this.factory2.createShiftExpression();
		this.shiftExpression.getExpr().add(this.additiveExpression);
		this.relationalExpression = this.factory2.createRelationalExpression();
		this.relationalExpression.getExpr().add(this.shiftExpression);
		this.equalityExpression = this.factory2.createEqualityExpression();
		this.equalityExpression.getExpr().add(this.relationalExpression);
		this.andExpression = this.factory2.createAndExpression();
		this.andExpression.getExpr().add(this.equalityExpression);
		this.exclusiveOrExpression = this.factory2
				.createExclusiveOrExpression();
		this.exclusiveOrExpression.getExpr().add(this.andExpression);
		this.inclusiveOrExpression = this.factory2
				.createInclusiveOrExpression();
		this.inclusiveOrExpression.getExpr().add(this.exclusiveOrExpression);
		this.logicalAndExpression = this.factory2.createLogicalAndExpression();
		this.logicalAndExpression.getExpr().add(this.inclusiveOrExpression);
		this.logicalOrExpression = this.factory2.createLogicalOrExpression();
		this.logicalOrExpression.getExpr().add(this.logicalAndExpression);
	}

}
