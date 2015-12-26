package org.eclipse.modisco.cdt.discoverer.ast.my;

import org.eclipse.cdt.core.dom.ast.IASTEqualsInitializer;
import org.eclipse.cdt.core.dom.ast.IASTExpression;
import org.eclipse.cdt.core.dom.ast.IASTInitializer;
import org.eclipse.cdt.core.dom.ast.IASTInitializerClause;
import org.eclipse.modisco.cdt.BinaryExpression;
import org.eclipse.modisco.cdt.Expression;
import org.eclipse.modisco.cdt.ExpressionStatement;
import org.eclipse.modisco.cdt.LiteralExpression;
import org.eclipse.modisco.cdt.Operator;
import org.eclipse.modisco.cdt.Scope;
import org.eclipse.modisco.cdt.Variable;
import org.eclipse.modisco.cdt.VariableExpression;
import org.eclipse.modisco.cdt.discoverer.utils.MyStore;

public class MyInitializer {

	public static ExpressionStatement lookUp(final MyStore store,
			final IASTInitializer initializer, final Variable variable) {
		System.out.println("lookUp for " + initializer);
		if (initializer instanceof IASTEqualsInitializer) {
			final IASTInitializerClause clause = ((IASTEqualsInitializer) initializer)
					.getInitializerClause();
			System.out.println("clause=" + clause);
			final BinaryExpression expression = store.getFactory()
					.createBinaryExpression();
			final VariableExpression varExpr = store.getFactory()
					.createVariableExpression();
			final Expression expr = MyInitializer.lookUp(store, clause);
			varExpr.setVariable(variable);
			expression.setOperand1(varExpr);
			expression.setOperand2(expr);
			expression.setOperator(Operator.ASSIGN);
			final Scope scope = store.getScope();
			// final CompoundStatement stmt = (CompoundStatement) scope;
			final ExpressionStatement result = store.getFactory()
					.createExpressionStatement();
			result.setExpression(expression);
			scope.getStatements().add(result);
			// stmt.getStatements().add(result);
			return result;
		}
		return null;
	}

	public static Expression lookUp(final MyStore store,
			final IASTInitializerClause initializer) {

		if (initializer instanceof IASTExpression) {
			return MyExpression.lookUpExpression(store,
					(IASTExpression) initializer);
		}

		final LiteralExpression litExpr = store.getFactory()
				.createLiteralExpression();
		litExpr.setValue(initializer.toString());
		return litExpr;
	}

}
