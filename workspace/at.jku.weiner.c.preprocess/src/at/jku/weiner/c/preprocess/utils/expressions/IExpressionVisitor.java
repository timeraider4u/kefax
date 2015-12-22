package at.jku.weiner.c.preprocess.utils.expressions;

import at.jku.weiner.c.common.common.PostfixExpression;
import at.jku.weiner.c.common.common.UnaryOperator;

public interface IExpressionVisitor<T> {

	public T evaluateForConditionalExpression(T a, T b, T c);

	public T evaluateForLogicalOrExpression(T a, T b);

	public T evaluateForLogicalAndExpression(T a, T b);

	public T evaluateForInclusiveOrExpression(T a, T b);

	public T evaluateForExclusiveOrExpression(T a, T b);

	public T evaluateForAndExpression(T a, T b);

	public T evaluateForEqualityExpression(T a, T b, String op);

	public T evaluateForRelationalExpression(T a, T b, String op);

	public T evaluateForShiftExpression(T a, T b, String op);

	public T evaluateForAdditiveExpression(T a, T b, String op);

	public T evaluateForMultiplicativeExpression(T a, T b, String op);

	public T evaluateForUnaryExpression(T resultOfCastExpression,
			UnaryOperator op);

	public T evaluateConstant(final String constant);

	public T evaluateForId(boolean isDefined, final String id,
			PostfixExpression postfix);

	public T getDefaultReturn();

}
