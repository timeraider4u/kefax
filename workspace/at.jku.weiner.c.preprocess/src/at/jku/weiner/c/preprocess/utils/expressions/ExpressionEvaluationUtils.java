package at.jku.weiner.c.preprocess.utils.expressions;

import org.eclipse.emf.common.util.EList;

import at.jku.weiner.c.preprocess.preprocess.Expression;

class ExpressionEvaluationUtils {
	private static final String errorListSizeStart = "please check expressions and"
			+ "operator lists for '";
	private static final String errorListSizeEnd = "' expressions!";

	protected static void checkLists(final EList<? extends Expression> list,
			final EList<String> ops, final String text) {
		if (ops.size() != (list.size() - 1)) {
			throw new IllegalArgumentException(
					ExpressionEvaluationUtils.errorListSizeStart + text
					+ ExpressionEvaluationUtils.errorListSizeEnd);
		}
	}

	protected static int convertFrom(final boolean value) {
		if (!value) {
			return ExpressionEvaluation.FALSE;
		}
		return ExpressionEvaluation.TRUE;
	}

	protected static boolean convertFrom(final int value) {
		if (value == ExpressionEvaluation.FALSE) {
			return false;
		}
		return true;
	}

}
