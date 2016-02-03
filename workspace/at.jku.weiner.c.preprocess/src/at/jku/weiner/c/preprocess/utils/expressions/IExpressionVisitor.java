package at.jku.weiner.c.preprocess.utils.expressions;

import at.jku.weiner.c.common.common.PostfixExpressionSuffix;

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

	public T evaluateForUnaryExpression(T resultOfCastExpression, String op);

	public T evaluateForPostfixExpression(PostfixExpressionSuffix suffix,
			String name, boolean isConst);

	public T evaluateConstant(final String constant);

	public T evaluateForId(final boolean defined, final String id);

	public T evaluateForParentheses(final T resultOfExpression);

	public T getDefaultReturn();

}
