package at.jku.weiner.c.preprocess.utils.expressions;

import at.jku.weiner.c.preprocess.preprocess.ConstantExpression;
import at.jku.weiner.c.preprocess.preprocess.Expression;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.preprocess.utils.macros.DefinitionTable;

public class ExpressionEvaluation {
	private static final int TRUE = 1;
	private static final int FALSE = 0;

	private static int evaluate(final ConstantExpression expression) {
		throw new UnsupportedOperationException(
				"TODO: auto-generated method stub");
	}

	public static boolean evaluateFor(final Expression expression) {
		final int result = ExpressionEvaluation.evaluate(expression);
		return result != ExpressionEvaluation.FALSE;
	}

	public static int evaluate(final Expression expression) {
		if (expression instanceof ConstantExpression) {
			return ExpressionEvaluation
					.evaluate((ConstantExpression) expression);
		} else if (expression instanceof PrimaryExpression) {
			return ExpressionEvaluation
					.evaluate((PrimaryExpression) expression);
		}
		return ExpressionEvaluation.FALSE;
	}

	private static int evaluate(final PrimaryExpression expression) {
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

	private static int evaluateForString(final String macroName, final boolean isConst) {
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
