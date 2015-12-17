package at.jku.weiner.c.preprocess.utils.expressions;

import at.jku.weiner.c.preprocess.preprocess.AdditiveExpression;
import at.jku.weiner.c.preprocess.preprocess.AndExpression;
import at.jku.weiner.c.preprocess.preprocess.CastExpression;
import at.jku.weiner.c.preprocess.preprocess.ConditionalExpression;
import at.jku.weiner.c.preprocess.preprocess.ConstantExpression;
import at.jku.weiner.c.preprocess.preprocess.EqualityExpression;
import at.jku.weiner.c.preprocess.preprocess.ExclusiveOrExpression;
import at.jku.weiner.c.preprocess.preprocess.Expression;
import at.jku.weiner.c.preprocess.preprocess.InclusiveOrExpression;
import at.jku.weiner.c.preprocess.preprocess.LogicalAndExpression;
import at.jku.weiner.c.preprocess.preprocess.LogicalOrExpression;
import at.jku.weiner.c.preprocess.preprocess.MultiplicativeExpression;
import at.jku.weiner.c.preprocess.preprocess.PostfixExpression;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.preprocess.RelationalExpression;
import at.jku.weiner.c.preprocess.preprocess.ShiftExpression;
import at.jku.weiner.c.preprocess.preprocess.UnaryExpression;

public abstract class AbstractExpressionEvaluator<T> {

	public final T visit(final Expression expression) {
		if (expression instanceof ConstantExpression) {
			this.visit((ConstantExpression) expression);
		} else if (expression instanceof ConditionalExpression) {
			this.visit((ConditionalExpression) expression);
		} else if (expression instanceof LogicalOrExpression) {
			return this.visit((LogicalOrExpression) expression);
		} else if (expression instanceof LogicalAndExpression) {
			return this.visit((LogicalAndExpression) expression);
		} else if (expression instanceof InclusiveOrExpression) {
			return this.visit((InclusiveOrExpression) expression);
		} else if (expression instanceof ExclusiveOrExpression) {
			return this.visit((ExclusiveOrExpression) expression);
		} else if (expression instanceof AndExpression) {
			return this.visit((AndExpression) expression);
		} else if (expression instanceof EqualityExpression) {
			return this.visit((EqualityExpression) expression);
		} else if (expression instanceof RelationalExpression) {
			return this.visit((RelationalExpression) expression);
		} else if (expression instanceof ShiftExpression) {
			return this.visit((ShiftExpression) expression);
		} else if (expression instanceof AdditiveExpression) {
			return this.visit((AdditiveExpression) expression);
		} else if (expression instanceof MultiplicativeExpression) {
			return this.visit((MultiplicativeExpression) expression);
		} else if (expression instanceof CastExpression) {
			return this.visit((CastExpression) expression);
		} else if (expression instanceof UnaryExpression) {
			return this.visit((UnaryExpression) expression);
		} else if (expression instanceof PostfixExpression) {
			return this.visit((PostfixExpression) expression);
		} else if (expression instanceof PrimaryExpression) {
			return this.visit((PrimaryExpression) expression);
		}
		return this.visit((Expression) expression.getExpression());
	}

	private T visit(final ConstantExpression expression) {
		final Expression expr = expression.getExpr();
		final T temp = this.visit(expr);
		final T result = this.visit(expression, temp);
		return result;
	}

	protected T visit(final ConstantExpression expression, final T temp) {
		return temp;
	}

	private T visit(final ConditionalExpression expression) {
		final Expression expr = expression.getExpr();
		final T temp = this.visit(expr);
		final Expression qExpr = expression.getQExpr();
		final Expression cExpr = expression.getCExpr();
		if ((qExpr == null) || (cExpr == null)) {
			return temp;
		}
		final T q = this.visit(qExpr);
		final T c = this.visit(cExpr);
		final T result = this.visit(expression, temp, q, c);
		return result;
	}

	protected T visit(final ConditionalExpression expression, final T temp,
			final T q, final T c) {
		return temp;
	}

}
