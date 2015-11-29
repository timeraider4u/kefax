package at.jku.weiner.c.preprocess.utils.expressions;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import at.jku.weiner.c.preprocess.preprocess.CastExpression;
import at.jku.weiner.c.preprocess.preprocess.ConditionalExpression;
import at.jku.weiner.c.preprocess.preprocess.ConstantExpression;
import at.jku.weiner.c.preprocess.preprocess.Expression;
import at.jku.weiner.c.preprocess.preprocess.PostfixExpression;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.preprocess.UnaryExpression;
import at.jku.weiner.c.preprocess.preprocess.UnaryOperator;
import at.jku.weiner.c.preprocess.utils.macros.DefinitionTable;

public class ExpressionEvaluation {
	public static final int TRUE = 1;
	public static final int FALSE = 0;

	public static boolean evaluateFor(final ConstantExpression expression) {
		final int result = ExpressionEvaluation.evaluate(expression);
		return result != ExpressionEvaluation.FALSE;
	}

	public static int evaluate(final Expression expression) {
		final int result = ExpressionEvaluation.FALSE;
		return result;
	}

	public static int evaluate(final ConstantExpression expression) {
		final int result = ExpressionEvaluation.evaluate(expression.getExpr());
		return result;
	}

	public static int evaluate(final ConditionalExpression expression) {
		final int result = ExpressionEvaluation.FALSE;
		return result;
	}

	/**** **** ****/

	/**** **** ****/
	public static int evaluate(final CastExpression expression) {
		final int result = ExpressionEvaluation.evaluate(expression.getExpr());
		return result;
	}

	public static int evaluate(final UnaryExpression expression) {
		final EObject expr = expression.getExpr();
		if (expr instanceof PostfixExpression) {
			final int result = ExpressionEvaluation
					.evaluate((PostfixExpression) expr);
			return result;
		}

		final UnaryOperator op = expression.getOp();
		final int result = ExpressionEvaluation.evaluate((CastExpression) expr);
		switch (op) {
		case SKW_MINUS:
			return result * (-1);
		case SKW_NOT:
			if (result == ExpressionEvaluation.FALSE) {
				return ExpressionEvaluation.TRUE;
			}
			return ExpressionEvaluation.FALSE;
		case SKW_PLUS:
			break;
		case SKW_AND:
		case SKW_STAR:
		case SKW_TILDE:
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
			return ExpressionEvaluation.evaluateForString(id, false);
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
