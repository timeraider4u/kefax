package at.jku.weiner.c.preprocess.utils.expressions;

import org.eclipse.emf.common.util.EList;

import at.jku.weiner.c.common.common.ArgumentExpressionList;
import at.jku.weiner.c.common.common.Expression;
import at.jku.weiner.c.common.common.PostfixExpressionSuffix;
import at.jku.weiner.c.common.common.PostfixExpressionSuffixArgument;

public class ExpressionStringVisitor implements IExpressionVisitor<String> {

	@Override
	public String evaluateForConditionalExpression(final String a,
			final String b, final String c) {
		return a + "?" + b + ":" + c;
	}

	@Override
	public String evaluateForLogicalOrExpression(final String a, final String b) {
		return a + "||" + b;
	}

	@Override
	public String evaluateForLogicalAndExpression(final String a, final String b) {
		return a + "&&" + b;
	}

	@Override
	public String evaluateForInclusiveOrExpression(final String a,
			final String b) {
		return a + "|" + b;
	}

	@Override
	public String evaluateForExclusiveOrExpression(final String a,
			final String b) {
		return a + "^" + b;
	}

	@Override
	public String evaluateForAndExpression(final String a, final String b) {
		return a + "&" + b;
	}

	@Override
	public String evaluateForEqualityExpression(final String a, final String b,
			final String op) {
		return a + op.toString() + b;
	}

	@Override
	public String evaluateForRelationalExpression(final String a,
			final String b, final String op) {
		return a + op.toString() + b;
	}

	@Override
	public String evaluateForShiftExpression(final String a, final String b,
			final String op) {
		return a + op.toString() + b;
	}

	@Override
	public String evaluateForAdditiveExpression(final String a, final String b,
			final String op) {
		return a + op.toString() + b;
	}

	@Override
	public String evaluateForMultiplicativeExpression(final String a,
			final String b, final String op) {
		return a + op.toString() + b;
	}

	@Override
	public String evaluateForUnaryExpression(
			final String resultOfCastExpression, final String op) {
		return op + resultOfCastExpression;
	}

	@Override
	public String evaluateForParentheses(final String resultOfExpression) {
		return "(" + resultOfExpression + ")";
	}

	@Override
	public String evaluateConstant(final String constant) {
		return constant;
	}

	@Override
	public String evaluateForId(final boolean isDefined, final String id) {
		StringBuffer result = new StringBuffer("");
		if (isDefined) {
			result.append(" defined ");
		}
		result.append(id);
		return result.toString();
	}

	@Override
	public String evaluateForPostfixExpression(
			final PostfixExpressionSuffix suffix, final String name,
			final boolean isConst) {
		StringBuffer result = new StringBuffer("");
		result.append(name);
		if (!(suffix instanceof PostfixExpressionSuffixArgument)) {
			return result.toString();
		}
		PostfixExpressionSuffixArgument argument = (PostfixExpressionSuffixArgument) suffix;
		ArgumentExpressionList argList = argument.getArgumentExpressionList();
		if (argList == null) {
			return result.toString();
		}
		final EList<Expression> exprList = argList.getExpr();
		result.append("(");
		for (int j = 0; j < exprList.size(); j++) {
			if (j > 0) {
				result.append(",");
			}
			final Expression expression = exprList.get(j);
			final IExpressionVisitor<String> visitor = new ExpressionStringVisitor();
			final ExpressionEvaluation<String> evaluater = new ExpressionEvaluation<String>(
					visitor);
			final String param = evaluater.walkTo(expression);
			result.append(param);
		}
		result.append(")");
		return result.toString();
	}

	@Override
	public String getDefaultReturn() {
		return "";
	}

}
