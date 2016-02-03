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
import at.jku.weiner.c.common.common.PostfixExpressionSuffix;
import at.jku.weiner.c.common.common.RelationalExpression;
import at.jku.weiner.c.common.common.ShiftExpression;
import at.jku.weiner.c.common.common.UnaryExpression;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.utils.MyLog;
import at.jku.weiner.c.preprocess.utils.macros.DefinitionTable;

import com.google.inject.Injector;

public class ExpressionEvaluation<T> implements IExpressionWalker<T> {

	private final IExpressionVisitor<T> visitor;

	public static boolean evaluateFor(final Expression expression,
			final Injector injector, final DefinitionTable definitionTable) {
		final IExpressionVisitor<Long> evalVisitor = new ExpressionLongVisitor(
				injector, definitionTable);
		final ExpressionEvaluation<Long> evaluate2 = new ExpressionEvaluation<Long>(
				evalVisitor);
		final Long value = evaluate2.walkTo(expression);
		MyLog.trace("evaluateFor='" + value.toString() + "'");
		final boolean result = ExpressionEvaluationUtils.convertFrom(value);
		return result;
	}

	public static String evaluateFor(final Expression expression) {
		final IExpressionVisitor<String> printVisitor = new ExpressionStringVisitor();
		final ExpressionEvaluation<String> evaluate1 = new ExpressionEvaluation<String>(
				printVisitor);
		final String string = evaluate1.walkTo(expression);
		return string;
	}

	public ExpressionEvaluation(final IExpressionVisitor<T> visitor) {
		this.visitor = visitor;
	}

	@Override
	public T walkTo(final Expression expression) {
		if (expression instanceof ConditionalExpression) {
			return this.walkTo((ConditionalExpression) expression);
		} else if (expression instanceof LogicalOrExpression) {
			return this.walkTo((LogicalOrExpression) expression);
		} else if (expression instanceof LogicalAndExpression) {
			return this.walkTo((LogicalAndExpression) expression);
		} else if (expression instanceof InclusiveOrExpression) {
			return this.walkTo((InclusiveOrExpression) expression);
		} else if (expression instanceof ExclusiveOrExpression) {
			return this.walkTo((ExclusiveOrExpression) expression);
		} else if (expression instanceof AndExpression) {
			return this.walkTo((AndExpression) expression);
		} else if (expression instanceof EqualityExpression) {
			return this.walkTo((EqualityExpression) expression);
		} else if (expression instanceof RelationalExpression) {
			return this.walkTo((RelationalExpression) expression);
		} else if (expression instanceof ShiftExpression) {
			return this.walkTo((ShiftExpression) expression);
		} else if (expression instanceof AdditiveExpression) {
			return this.walkTo((AdditiveExpression) expression);
		} else if (expression instanceof MultiplicativeExpression) {
			return this.walkTo((MultiplicativeExpression) expression);
		} else if (expression instanceof UnaryExpression) {
			return this.walkTo((UnaryExpression) expression);
		} else if (expression instanceof PostfixExpression) {
			return this.walkTo((PostfixExpression) expression);
		} else if (expression instanceof PrimaryExpression) {
			return this.walkTo((PrimaryExpression) expression);
		} else if (expression instanceof at.jku.weiner.c.common.common.PrimaryExpression) {
			return this
					.walkTo((at.jku.weiner.c.common.common.PrimaryExpression) expression);
		}
		throw new IllegalArgumentException("should never get here!");
	}

	@Override
	public T walkTo(final ConditionalExpression expression) {
		final T a = this.walkTo((Expression) expression.getExpr());
		final Expression qExpr = (Expression) expression.getQExpr();
		final Expression cExpr = (Expression) expression.getCExpr();
		final T b = this.walkTo(qExpr);
		final T c = this.walkTo(cExpr);
		final T result = this.visitor.evaluateForConditionalExpression(a, b, c);
		return result;
	}

	@Override
	public T walkTo(final LogicalOrExpression expression) {
		final T left = this.walkTo(expression.getLeft());
		final T right = this.walkTo(expression.getRight());
		final T result = this.visitor.evaluateForLogicalOrExpression(left,
				right);
		return result;
	}

	@Override
	public T walkTo(final LogicalAndExpression expression) {
		final T left = this.walkTo(expression.getLeft());
		final T right = this.walkTo(expression.getRight());
		final T result = this.visitor.evaluateForLogicalAndExpression(left,
				right);
		return result;
	}

	@Override
	public T walkTo(final InclusiveOrExpression expression) {
		final T left = this.walkTo(expression.getLeft());
		final T right = this.walkTo(expression.getRight());
		final T result = this.visitor.evaluateForInclusiveOrExpression(left,
				right);
		return result;
	}

	@Override
	public T walkTo(final ExclusiveOrExpression expression) {
		final T left = this.walkTo(expression.getLeft());
		final T right = this.walkTo(expression.getRight());
		final T result = this.visitor.evaluateForExclusiveOrExpression(left,
				right);
		return result;
	}

	@Override
	public T walkTo(final AndExpression expression) {
		final T left = this.walkTo(expression.getLeft());
		final T right = this.walkTo(expression.getRight());
		final T result = this.visitor.evaluateForAndExpression(left, right);
		return result;
	}

	@Override
	public T walkTo(final EqualityExpression expression) {
		final T left = this.walkTo(expression.getLeft());
		final T right = this.walkTo(expression.getRight());
		final String op = expression.getOp();
		final T result = this.visitor.evaluateForEqualityExpression(left,
				right, op);
		return result;
	}

	@Override
	public T walkTo(final RelationalExpression expression) {
		final T left = this.walkTo(expression.getLeft());
		final T right = this.walkTo(expression.getRight());
		final String op = expression.getOp();
		final T result = this.visitor.evaluateForRelationalExpression(left,
				right, op);
		return result;
	}

	@Override
	public T walkTo(final ShiftExpression expression) {
		final T left = this.walkTo(expression.getLeft());
		final T right = this.walkTo(expression.getRight());
		final String op = expression.getOp();
		final T result = this.visitor.evaluateForShiftExpression(left, right,
				op);
		return result;
	}

	@Override
	public T walkTo(final AdditiveExpression expression) {
		final T left = this.walkTo(expression.getLeft());
		final T right = this.walkTo(expression.getRight());
		final String op = expression.getOp();
		final T result = this.visitor.evaluateForAdditiveExpression(left,
				right, op);
		return result;
	}

	@Override
	public T walkTo(final MultiplicativeExpression expression) {
		final T left = this.walkTo(expression.getLeft());
		final T right = this.walkTo(expression.getRight());
		final String op = expression.getOp();
		final T result = this.visitor.evaluateForMultiplicativeExpression(left,
				right, op);
		return result;
	}

	@Override
	public T walkTo(final UnaryExpression expression) {
		final T expr = this.walkTo(expression.getExpr());
		final String op = expression.getOp();
		final T result = this.visitor.evaluateForUnaryExpression(expr, op);
		return result;
	}

	@Override
	public T walkTo(final PostfixExpression expression) {
		final Expression expr = expression.getExpr();
		final PostfixExpressionSuffix suffix = expression.getSuffix();
		String name = null;
		boolean isConst = false;
		if (expr instanceof PrimaryExpression) {
			PrimaryExpression primExpr = (PrimaryExpression) expr;
			final String constant = primExpr.getConst();
			if (constant != null) {
				name = constant;
				isConst = true;
			} else {
				name = primExpr.getId();
				isConst = false;
			}
		} else {
			at.jku.weiner.c.common.common.PrimaryExpression primExpr = (at.jku.weiner.c.common.common.PrimaryExpression) expr;
			final String constant = primExpr.getConst();
			if (constant != null) {
				name = constant;
				isConst = true;
			} else {
				name = primExpr.getId();
				isConst = false;
			}
		}
		final T result = this.visitor.evaluateForPostfixExpression(suffix,
				name, isConst);
		return result;
	}

	@Override
	public T walkTo(
			final at.jku.weiner.c.common.common.PrimaryExpression expression) {
		final Expression expr = expression.getExpr();
		final String constant = expression.getConst();
		final String id = expression.getId();
		T result = this.walkTo(constant, id, expr, false);
		return result;
	}

	@Override
	public T walkTo(final PrimaryExpression expression) {
		boolean isDefined = expression.isDefined();
		final String constant = expression.getConst();
		final String id = expression.getId();
		final Expression expr = expression.getExpr();
		final T result = this.walkTo(constant, id, expr, isDefined);
		return result;
	}

	private T walkTo(final String constant, final String id,
			final Expression expr, final boolean isDefined) {
		if (constant != null) {
			final T result = this.visitor.evaluateConstant(constant);
			return result;
		} else if (id != null) {
			final T result = this.visitor.evaluateForId(isDefined, id);
			return result;
		} else if (expr != null) {
			final T result = this.walkTo(expr);
			return result;
		}
		throw new IllegalArgumentException("should never get here!");
	}

}
