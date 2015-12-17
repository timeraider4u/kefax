package at.jku.weiner.c.preprocess.utils.expressions;

import at.jku.weiner.c.preprocess.preprocess.Expression;

public abstract class ExpressionVisitor<T> {

	public T visit(final Expression expression) {
		return null;
	}

}
