package org.eclipse.modisco.cdt.discoverer.ast.my;

import org.eclipse.cdt.core.dom.ast.IASTCompoundStatement;
import org.eclipse.cdt.core.dom.ast.IASTExpression;
import org.eclipse.cdt.core.dom.ast.IASTExpressionStatement;
import org.eclipse.cdt.core.dom.ast.IASTNullStatement;
import org.eclipse.cdt.core.dom.ast.IASTReturnStatement;
import org.eclipse.cdt.core.dom.ast.IASTStatement;
import org.eclipse.modisco.cdt.CompoundStatement;
import org.eclipse.modisco.cdt.Expression;
import org.eclipse.modisco.cdt.ExpressionStatement;
import org.eclipse.modisco.cdt.NullStatement;
import org.eclipse.modisco.cdt.ReturnStatement;
import org.eclipse.modisco.cdt.Statement;
import org.eclipse.modisco.cdt.discoverer.utils.MyStore;

public class MyStatement {

	protected static Statement lookUpStatement(final MyStore store,
			final IASTStatement statement) {
		Statement result = null;
		if (statement instanceof IASTCompoundStatement) {
			result = MyStatement.lookUpBody(store,
					(IASTCompoundStatement) statement);

		} else if (statement instanceof IASTReturnStatement) {
			result = MyStatement.lookUpReturnStatement(store, statement);

		} else if (statement instanceof IASTExpressionStatement) {
			result = MyStatement.lookUpExpressionStatement(store,
					(IASTExpressionStatement) statement);

		} else if (statement instanceof IASTNullStatement) {
			result = MyStatement.lookUpNullStatement(store,
					(IASTNullStatement) statement);
		}
		return result;
	}

	private static CompoundStatement lookUpBody(final MyStore store,
			final IASTCompoundStatement stmt) {
		final CompoundStatement body = store.getFactory()
				.createCompoundStatement();
		store.getScope().getStatements().add(body);
		return body;
	}

	private static Statement lookUpReturnStatement(final MyStore store,
			final IASTStatement statement) {
		final ReturnStatement result = store.getFactory()
				.createReturnStatement();
		if (store.getScope() instanceof CompoundStatement) {
			final CompoundStatement body = ((CompoundStatement) store
					.getScope());
			body.getStatements().add(result);
		}
		final IASTReturnStatement ret = (IASTReturnStatement) statement;
		final Expression expr = MyExpression.lookUpExpression(store,
				ret.getReturnValue());
		result.setExpression(expr);
		return result;
	}

	private static Statement lookUpExpressionStatement(final MyStore store,
			final IASTExpressionStatement statement) {
		final ExpressionStatement result = store.getFactory()
				.createExpressionStatement();
		if (store.getScope() instanceof CompoundStatement) {
			final CompoundStatement body = ((CompoundStatement) store
					.getScope());
			body.getStatements().add(result);
		}
		final IASTExpression astExpression = statement.getExpression();
		final Expression expression = MyExpression.lookUpExpression(store,
				astExpression);
		result.setExpression(expression);
		return result;
	}

	private static Statement lookUpNullStatement(final MyStore store,
			final IASTNullStatement statement) {
		final NullStatement result = store.getFactory().createNullStatement();
		if (store.getScope() instanceof CompoundStatement) {
			final CompoundStatement body = ((CompoundStatement) store
					.getScope());
			body.getStatements().add(result);
		}
		return result;
	}

}
