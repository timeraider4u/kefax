package at.jku.weiner.c.preprocess.utils.expressions;

import org.eclipse.emf.common.util.EList;

import at.jku.weiner.c.common.common.Expression;

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

	protected static Long convertFrom(final boolean value) {
		if (!value) {
			return ExpressionLongVisitor.FALSE;
		}
		return ExpressionLongVisitor.TRUE;
	}

	protected static boolean convertFrom(final Long value) {
		if (ExpressionLongVisitor.FALSE.equals(value)) {
			return false;
		}
		return true;
	}

}
