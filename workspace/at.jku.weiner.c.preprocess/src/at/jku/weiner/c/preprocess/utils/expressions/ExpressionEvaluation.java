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
			return ExpressionEvaluation.evaluateForConstant(constant);
		}
		if (id != null) {
			return ExpressionEvaluation.evaluateForId(id);
		}
		if (expr != null) {
			return ExpressionEvaluation.evaluate(expr);
		}
		return ExpressionEvaluation.FALSE;
	}

	private static int evaluateForConstant(final String constant) {
		final int id = Integer.valueOf(constant);
		return id;
	}

	private static int evaluateForId(final String macroName) {
		final String macro = DefinitionTable.resolve(macroName);
		try {
			final int result = Integer.valueOf(macro);
			return result;
		} catch (final NumberFormatException ex) {
			if (DefinitionTable.isDefined(macroName)) {
				throw ex;
			}
		}
		return ExpressionEvaluation.FALSE;
	}

}
