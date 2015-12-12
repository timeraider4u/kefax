package at.jku.weiner.c.preprocess.utils.expressions;

import org.eclipse.emf.common.util.EList;
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
import at.jku.weiner.c.preprocess.preprocess.UnaryOperator;
import at.jku.weiner.c.preprocess.utils.macros.DefinitionTable;

public class ExpressionEvaluation {

	public static final int TRUE = 1;
	public static final int FALSE = 0;

	public static boolean evaluateFor(final Expression expression) {
		final int value = ExpressionEvaluation.evaluate(expression);
		final boolean result = ExpressionEvaluationUtils.convertFrom(value);
		return result;
	}

	public static int evaluate(final Expression expression) {
		if (expression instanceof ConstantExpression) {
			return ExpressionEvaluation
					.evaluate((ConstantExpression) expression);
		} else if (expression instanceof ConditionalExpression) {
			return ExpressionEvaluation
					.evaluate((ConditionalExpression) expression);
		} else if (expression instanceof LogicalOrExpression) {
			return ExpressionEvaluation
					.evaluate((LogicalOrExpression) expression);
		} else if (expression instanceof LogicalAndExpression) {
			return ExpressionEvaluation
					.evaluate((LogicalAndExpression) expression);
		} else if (expression instanceof InclusiveOrExpression) {
			return ExpressionEvaluation
					.evaluate((InclusiveOrExpression) expression);
		} else if (expression instanceof ExclusiveOrExpression) {
			return ExpressionEvaluation
					.evaluate((ExclusiveOrExpression) expression);
		} else if (expression instanceof AndExpression) {
			return ExpressionEvaluation.evaluate((AndExpression) expression);
		} else if (expression instanceof EqualityExpression) {
			return ExpressionEvaluation
					.evaluate((EqualityExpression) expression);
		} else if (expression instanceof RelationalExpression) {
			return ExpressionEvaluation
					.evaluate((RelationalExpression) expression);
		} else if (expression instanceof ShiftExpression) {
			return ExpressionEvaluation.evaluate((ShiftExpression) expression);
		} else if (expression instanceof AdditiveExpression) {
			return ExpressionEvaluation
					.evaluate((AdditiveExpression) expression);
		} else if (expression instanceof MultiplicativeExpression) {
			return ExpressionEvaluation
					.evaluate((MultiplicativeExpression) expression);
		} else if (expression instanceof CastExpression) {
			return ExpressionEvaluation.evaluate((CastExpression) expression);
		} else if (expression instanceof UnaryExpression) {
			return ExpressionEvaluation.evaluate((UnaryExpression) expression);
		} else if (expression instanceof PostfixExpression) {
			return ExpressionEvaluation
					.evaluate((PostfixExpression) expression);
		} else if (expression instanceof PrimaryExpression) {
			return ExpressionEvaluation
					.evaluate((PrimaryExpression) expression);
		}
		return ExpressionEvaluation.evaluate((Expression) expression
				.getExpression());
	}

	public static int evaluate(final ConstantExpression expression) {
		final int result = ExpressionEvaluation.evaluate(expression.getExpr());
		return result;
	}

	public static int evaluate(final ConditionalExpression expression) {
		final int result = ExpressionEvaluation.evaluate(expression.getExpr());
		final Expression qExpr = expression.getQExpr();
		final Expression cExpr = expression.getCExpr();
		if ((qExpr == null) || (cExpr == null)) {
			return result;
		}
		final boolean a = ExpressionEvaluationUtils.convertFrom(result);
		final boolean b = ExpressionEvaluationUtils
				.convertFrom(ExpressionEvaluation.evaluate(qExpr));
		final boolean c = ExpressionEvaluationUtils
				.convertFrom(ExpressionEvaluation.evaluate(cExpr));
		final boolean total = a ? b : c;
		final int totalResult = ExpressionEvaluationUtils.convertFrom(total);
		return totalResult;
	}

	public static int evaluate(final LogicalOrExpression expression) {
		final EList<Expression> list = expression.getExpr();
		int result = ExpressionEvaluation.evaluate(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			final int next = ExpressionEvaluation.evaluate(list.get(i));
			final boolean a = ExpressionEvaluationUtils.convertFrom(result);
			final boolean b = ExpressionEvaluationUtils.convertFrom(next);
			result = ExpressionEvaluationUtils.convertFrom(a || b);
		}
		return result;
	}

	public static int evaluate(final LogicalAndExpression expression) {
		final EList<Expression> list = expression.getExpr();
		int result = ExpressionEvaluation.evaluate(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			final int next = ExpressionEvaluation.evaluate(list.get(i));
			final boolean a = ExpressionEvaluationUtils.convertFrom(result);
			final boolean b = ExpressionEvaluationUtils.convertFrom(next);
			result = ExpressionEvaluationUtils.convertFrom(a && b);
		}
		return result;
	}

	public static int evaluate(final InclusiveOrExpression expression) {
		final EList<Expression> list = expression.getExpr();
		int result = ExpressionEvaluation.evaluate(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			final int next = ExpressionEvaluation.evaluate(list.get(i));
			result = result | next;
		}
		return result;
	}

	public static int evaluate(final ExclusiveOrExpression expression) {
		final EList<Expression> list = expression.getExpr();
		int result = ExpressionEvaluation.evaluate(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			final int next = ExpressionEvaluation.evaluate(list.get(i));
			result = result ^ next;
		}
		return result;
	}

	public static int evaluate(final AndExpression expression) {
		final EList<Expression> list = expression.getExpr();
		int result = ExpressionEvaluation.evaluate(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			final int next = ExpressionEvaluation.evaluate(list.get(i));
			result = result & next;
		}
		return result;
	}

	public static int evaluate(final EqualityExpression expression) {
		final EList<Expression> list = expression.getExpr();
		int result = ExpressionEvaluation.evaluate(list.get(0));
		final EList<String> ops = expression.getOp();
		ExpressionEvaluationUtils.checkLists(list, ops, "equlity");
		for (int i = 0; i < ops.size(); i++) {
			final int next = ExpressionEvaluation.evaluate(list.get(i + 1));
			final String op = ops.get(i);
			switch (op) {
			case "==":
				result = ExpressionEvaluationUtils.convertFrom(result == next);
				break;
			case "!=":
				result = ExpressionEvaluationUtils.convertFrom(result != next);
				break;
			}
		}
		return result;
	}

	public static int evaluate(final RelationalExpression expression) {
		final EList<Expression> list = expression.getExpr();
		int result = ExpressionEvaluation.evaluate(list.get(0));
		final EList<String> ops = expression.getOp();
		ExpressionEvaluationUtils.checkLists(list, ops, "relational");
		for (int i = 0; i < ops.size(); i++) {
			final int next = ExpressionEvaluation.evaluate(list.get(i + 1));
			final String op = ops.get(i);
			switch (op) {
			case "<=":
				result = ExpressionEvaluationUtils.convertFrom(result <= next);
				break;
			case "<":
				result = ExpressionEvaluationUtils.convertFrom(result < next);
				break;
			case ">":
				result = ExpressionEvaluationUtils.convertFrom(result > next);
				break;
			case ">=":
				result = ExpressionEvaluationUtils.convertFrom(result >= next);
				break;
			}
		}
		return result;
	}

	public static int evaluate(final ShiftExpression expression) {
		final EList<Expression> list = expression.getExpr();
		int result = ExpressionEvaluation.evaluate(list.get(0));
		final EList<String> ops = expression.getOp();
		ExpressionEvaluationUtils.checkLists(list, ops, "shift");
		for (int i = 0; i < ops.size(); i++) {
			final int next = ExpressionEvaluation.evaluate(list.get(i + 1));
			final String op = ops.get(i);
			switch (op) {
			case ">>":
				result = (result >> next);
				break;
			case "<<":
				result = (result << next);
				break;
			}
		}
		return result;
	}

	public static int evaluate(final AdditiveExpression expression) {
		final EList<Expression> list = expression.getExpr();
		int result = ExpressionEvaluation.evaluate(list.get(0));
		final EList<String> ops = expression.getOp();
		ExpressionEvaluationUtils.checkLists(list, ops, "additive");
		for (int i = 0; i < ops.size(); i++) {
			final int next = ExpressionEvaluation.evaluate(list.get(i + 1));
			final String op = ops.get(i);
			switch (op) {
			case "+":
				result = result + next;
				break;
			case "-":
				result = result - next;
				break;
			}
		}
		return result;
	}

	public static int evaluate(final MultiplicativeExpression expression) {
		final EList<Expression> list = expression.getExpr();
		int result = ExpressionEvaluation.evaluate(list.get(0));
		final EList<String> ops = expression.getOp();
		ExpressionEvaluationUtils.checkLists(list, ops, "multiplicate");
		for (int i = 0; i < ops.size(); i++) {
			final int next = ExpressionEvaluation.evaluate(list.get(i + 1));
			final String op = ops.get(i);
			switch (op) {
			case "*":
				result = result * next;
				break;
			case "/":
				result = result / next;
				break;
			case "%":
				result = result % next;
				break;
			}
		}
		return result;
	}

	public static int evaluate(final CastExpression expression) {
		final int result = ExpressionEvaluation.evaluate(expression.getExpr());
		return result;
	}

	public static int evaluate(final UnaryExpression expression) {
		final Expression expr = expression.getExpr();
		if (expr instanceof PostfixExpression) {
			final int result = ExpressionEvaluation
					.evaluate((PostfixExpression) expr);
			return result;
		}

		final UnaryOperator op = expression.getOp();
		final int result = ExpressionEvaluation.evaluate((CastExpression) expr);
		switch (op.getOp()) {
		case "-":
			return result * (-1);
		case "!":
			if (result == ExpressionEvaluation.FALSE) {
				return ExpressionEvaluation.TRUE;
			}
			return ExpressionEvaluation.FALSE;
		case "+":
			break;
		case "&":
		case "*":
		case "~":
		default:
			throw new UnsupportedOperationException(
					"address operators not allowed in preprocessor conditionals!");
		}
		return result;
	}

	public static int evaluate(final PostfixExpression expression) {
		final int result = ExpressionEvaluation
				.evaluate((PrimaryExpression) expression.getExpr());
		// PostfixExpressionSuffixes not allowed in preprocessor!!!
		return result;
	}

	public static int evaluate(final PrimaryExpression expression) {
		final String constant = expression.getConst();
		final String id = expression.getId();
		final Expression expr = expression.getExpr();
		if (constant != null) {
			return ExpressionEvaluation.evaluateForString(constant, true);
		}
		if (id != null) {
			if (expression.isDefined()) {
				if (DefinitionTable.isDefined(id)) {
					return ExpressionEvaluation.TRUE;
				}
				return ExpressionEvaluation.FALSE;
			} else {
				return ExpressionEvaluation.evaluateForString(id, false);
			}
		}
		if (expr != null) {
			return ExpressionEvaluation.evaluate(expr);
		}
		return ExpressionEvaluation.FALSE;
	}

	private static int evaluateForString(final String macroName,
			final boolean isConst) {
		String macro = DefinitionTable.resolve(macroName);
		try {
			if (macro.startsWith("0b") || macro.startsWith("0B")) {
				macro = macro.substring(2);
			}
			final int result = Integer.valueOf(macro);
			return result;
		} catch (final NumberFormatException ex) {
			if (isConst || DefinitionTable.isDefined(macroName)) {
				throw ex;
			}
		}
		return ExpressionEvaluation.FALSE;
	}

}
