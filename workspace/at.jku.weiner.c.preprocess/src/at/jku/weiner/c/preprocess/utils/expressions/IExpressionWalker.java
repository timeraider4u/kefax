package at.jku.weiner.c.preprocess.utils.expressions;

import at.jku.weiner.c.common.common.AdditiveExpression;
import at.jku.weiner.c.common.common.AndExpression;
import at.jku.weiner.c.common.common.ConditionalExpression;
import at.jku.weiner.c.common.common.EqualityExpression;
import at.jku.weiner.c.common.common.ExclusiveOrExpression;
import at.jku.weiner.c.common.common.Expression;
import at.jku.weiner.c.common.common.InclusiveOrExpression;
import at.jku.weiner.c.common.common.LogicalAndExpression;
import at.jku.weiner.c.common.common.LogicalOrExpression;
import at.jku.weiner.c.common.common.MultiplicativeExpression;
import at.jku.weiner.c.common.common.PostfixExpression;
import at.jku.weiner.c.common.common.RelationalExpression;
import at.jku.weiner.c.common.common.ShiftExpression;
import at.jku.weiner.c.common.common.UnaryExpression;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;

public interface IExpressionWalker<T> {

	// public void useVisitor(IExpressionVisitor<T> visitor);

	public T walkTo(Expression expression);

	public T walkTo(ConditionalExpression expression);

	public T walkTo(LogicalOrExpression expression);

	public T walkTo(LogicalAndExpression expression);

	public T walkTo(InclusiveOrExpression expression);

	public T walkTo(ExclusiveOrExpression expression);

	public T walkTo(AndExpression expression);

	public T walkTo(EqualityExpression expression);

	public T walkTo(RelationalExpression expression);

	public T walkTo(ShiftExpression expression);

	public T walkTo(AdditiveExpression expression);

	public T walkTo(MultiplicativeExpression expression);

	public T walkTo(UnaryExpression expression);

	public T walkTo(PostfixExpression expression);

	public T walkTo(PrimaryExpression expression);

	public T walkTo(at.jku.weiner.c.common.common.PrimaryExpression expression);

}
