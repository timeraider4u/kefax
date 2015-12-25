package at.jku.weiner.c.preprocess.utils.expressions;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import at.jku.weiner.c.common.common.AdditiveExpression;
import at.jku.weiner.c.common.common.AndExpression;
import at.jku.weiner.c.common.common.CastExpression;
import at.jku.weiner.c.common.common.ConditionalExpression;
import at.jku.weiner.c.common.common.ConstantExpression;
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
import at.jku.weiner.c.common.common.UnaryOperator;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;

import com.google.inject.Injector;

public class ExpressionEvaluation<T> implements IExpressionWalker<T> {
	
	private final IExpressionVisitor<T> visitor;
	
	public static boolean evaluateFor(final Expression expression,
			final Injector injector, final boolean advanced) {
		final String string = ExpressionEvaluation.evaluateFor(expression);
		// System.out.println("evaluateFor='" + string + "'");
		
		final IExpressionVisitor<Long> evalVisitor = new ExpressionLongVisitor(
				injector, advanced);
		final ExpressionEvaluation<Long> evaluate2 = new ExpressionEvaluation<Long>(
				evalVisitor);
		final Long value = evaluate2.walkTo(expression);
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
		if (expression instanceof ConstantExpression) {
			return this.walkTo((ConstantExpression) expression);
		} else if (expression instanceof ConditionalExpression) {
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
		} else if (expression instanceof CastExpression) {
			return this.walkTo((CastExpression) expression);
		} else if (expression instanceof UnaryExpression) {
			return this.walkTo((UnaryExpression) expression);
		} else if (expression instanceof PostfixExpression) {
			return this.walkTo((PostfixExpression) expression);
		} else if (expression instanceof PrimaryExpression) {
			return this.walkTo((PrimaryExpression) expression);
		}
		return this.walkTo((Expression) expression.getExpression());
	}
	
	@Override
	public T walkTo(final ConstantExpression expression) {
		final T result = this.walkTo((Expression) expression.getExpr());
		return result;
	}
	
	@Override
	public T walkTo(final ConditionalExpression expression) {
		final T a = this.walkTo((Expression) expression.getExpr());
		final Expression qExpr = (Expression) expression.getQExpr();
		final Expression cExpr = (Expression) expression.getCExpr();
		if ((qExpr == null) || (cExpr == null)) {
			return a;
		}
		final T b = this.walkTo(qExpr);
		final T c = this.walkTo(cExpr);
		final T result = this.visitor.evaluateForConditionalExpression(a, b, c);
		return result;
	}
	
	@Override
	public T walkTo(final LogicalOrExpression expression) {
		final EList<Expression> list = expression.getExpr();
		T result = this.walkTo(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			final T next = this.walkTo(list.get(i));
			result = this.visitor.evaluateForLogicalOrExpression(result, next);
		}
		return result;
	}
	
	@Override
	public T walkTo(final LogicalAndExpression expression) {
		final EList<Expression> list = expression.getExpr();
		T result = this.walkTo(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			final T next = this.walkTo(list.get(i));
			result = this.visitor.evaluateForLogicalAndExpression(result, next);
		}
		return result;
	}
	
	@Override
	public T walkTo(final InclusiveOrExpression expression) {
		final EList<Expression> list = expression.getExpr();
		T result = this.walkTo(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			final T next = this.walkTo(list.get(i));
			result = this.visitor
					.evaluateForInclusiveOrExpression(result, next);
		}
		return result;
	}
	
	@Override
	public T walkTo(final ExclusiveOrExpression expression) {
		final EList<Expression> list = expression.getExpr();
		T result = this.walkTo(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			final T next = this.walkTo(list.get(i));
			result = this.visitor
					.evaluateForExclusiveOrExpression(result, next);
		}
		return result;
	}
	
	@Override
	public T walkTo(final AndExpression expression) {
		final EList<Expression> list = expression.getExpr();
		T result = this.walkTo(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			final T next = this.walkTo(list.get(i));
			result = this.visitor.evaluateForAndExpression(result, next);
		}
		return result;
	}
	
	@Override
	public T walkTo(final EqualityExpression expression) {
		final EList<Expression> list = expression.getExpr();
		T result = this.walkTo(list.get(0));
		final EList<String> ops = expression.getOp();
		ExpressionEvaluationUtils.checkLists(list, ops, "equlity");
		for (int i = 0; i < ops.size(); i++) {
			final T next = this.walkTo(list.get(i + 1));
			final String op = ops.get(i);
			result = this.visitor.evaluateForEqualityExpression(result, next,
					op);
		}
		return result;
	}
	
	@Override
	public T walkTo(final RelationalExpression expression) {
		final EList<Expression> list = expression.getExpr();
		T result = this.walkTo(list.get(0));
		final EList<String> ops = expression.getOp();
		ExpressionEvaluationUtils.checkLists(list, ops, "relational");
		for (int i = 0; i < ops.size(); i++) {
			final T next = this.walkTo(list.get(i + 1));
			final String op = ops.get(i);
			result = this.visitor.evaluateForRelationalExpression(result, next,
					op);
		}
		return result;
	}
	
	@Override
	public T walkTo(final ShiftExpression expression) {
		final EList<Expression> list = expression.getExpr();
		T result = this.walkTo(list.get(0));
		final EList<String> ops = expression.getOp();
		ExpressionEvaluationUtils.checkLists(list, ops, "shift");
		for (int i = 0; i < ops.size(); i++) {
			final T next = this.walkTo(list.get(i + 1));
			final String op = ops.get(i);
			result = this.visitor.evaluateForShiftExpression(result, next, op);
		}
		return result;
	}
	
	@Override
	public T walkTo(final AdditiveExpression expression) {
		final EList<Expression> list = expression.getExpr();
		T result = this.walkTo(list.get(0));
		final EList<String> ops = expression.getOp();
		ExpressionEvaluationUtils.checkLists(list, ops, "additive");
		for (int i = 0; i < ops.size(); i++) {
			final T next = this.walkTo(list.get(i + 1));
			final String op = ops.get(i);
			result = this.visitor.evaluateForAdditiveExpression(result, next,
					op);
		}
		return result;
	}
	
	@Override
	public T walkTo(final MultiplicativeExpression expression) {
		final EList<Expression> list = expression.getExpr();
		T result = this.walkTo(list.get(0));
		final EList<String> ops = expression.getOp();
		ExpressionEvaluationUtils.checkLists(list, ops, "multiplicate");
		for (int i = 0; i < ops.size(); i++) {
			final T next = this.walkTo(list.get(i + 1));
			final String op = ops.get(i);
			result = this.visitor.evaluateForMultiplicativeExpression(result,
					next, op);
		}
		return result;
	}
	
	@Override
	public T walkTo(final CastExpression expression) {
		final T result = this.walkTo(expression.getExpr());
		return result;
	}
	
	@Override
	public T walkTo(final UnaryExpression expression) {
		final Expression expr = expression.getExpr();
		if (expr instanceof PostfixExpression) {
			final T result = this.walkTo((PostfixExpression) expr);
			return result;
		}
		
		final UnaryOperator op = expression.getOp();
		final T castExprResult = this.walkTo((CastExpression) expr);
		final T result = this.visitor.evaluateForUnaryExpression(
				castExprResult, op);
		return result;
	}
	
	@Override
	public T walkTo(final PostfixExpression expression) {
		final Expression expr = expression.getExpr();
		if (expr instanceof PrimaryExpression) {
			final T result = this.walkTo((PrimaryExpression) expr);
			return result;
		} else {
			final T result = this
					.walkTo((at.jku.weiner.c.common.common.PrimaryExpression) expr);
			return result;
		}
	}
	
	@Override
	public T walkTo(
			final at.jku.weiner.c.common.common.PrimaryExpression expression) {
		final Expression expr = expression.getExpr();
		final String constant = expression.getConst();
		final String id = expression.getId();
		if (constant != null) {
			final T result = this.visitor.evaluateConstant(constant);
			return result;
		}
		if (id != null) {
			final EObject object = expression.eContainer();
			final PostfixExpression postfix = (PostfixExpression) object;
			final T result = this.visitor.evaluateForId(false, id, postfix);
			return result;
		}
		if (expr != null) {
			final T result = this.walkTo(expr);
			return result;
		}
		return this.visitor.getDefaultReturn();
	}
	
	@Override
	public T walkTo(final PrimaryExpression expression) {
		final String constant = expression.getConst();
		final String id = expression.getId();
		final Expression expr = expression.getExpr();
		if (constant != null) {
			final T result = this.visitor.evaluateConstant(constant);
			return result;
		}
		if (id != null) {
			final EObject object = expression.eContainer();
			final PostfixExpression postfix = (PostfixExpression) object;
			final boolean isDefined = expression.isDefined();
			final T result = this.visitor.evaluateForId(isDefined, id, postfix);
			return result;
		}
		if (expr != null) {
			final T result = this.walkTo(expr);
			return result;
		}
		return this.visitor.getDefaultReturn();
	}
	
}
