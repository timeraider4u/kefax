package org.eclipse.modisco.cdt.discoverer.ast.my;

import java.util.List;

import org.eclipse.cdt.core.dom.ast.IASTBinaryExpression;
import org.eclipse.cdt.core.dom.ast.IASTExpression;
import org.eclipse.cdt.core.dom.ast.IASTFunctionCallExpression;
import org.eclipse.cdt.core.dom.ast.IASTIdExpression;
import org.eclipse.cdt.core.dom.ast.IASTInitializerClause;
import org.eclipse.cdt.core.dom.ast.IASTLiteralExpression;
import org.eclipse.cdt.core.dom.ast.IASTUnaryExpression;
import org.eclipse.emf.common.util.EList;
import org.eclipse.modisco.cdt.BinaryExpression;
import org.eclipse.modisco.cdt.Expression;
import org.eclipse.modisco.cdt.FunctionCallExpression;
import org.eclipse.modisco.cdt.FunctionDefinition;
import org.eclipse.modisco.cdt.LiteralExpression;
import org.eclipse.modisco.cdt.Operator;
import org.eclipse.modisco.cdt.Type;
import org.eclipse.modisco.cdt.UnaryExpression;
import org.eclipse.modisco.cdt.Variable;
import org.eclipse.modisco.cdt.VariableExpression;
import org.eclipse.modisco.cdt.discoverer.utils.MyStore;

public class MyExpression {

	protected static Expression lookUpExpression(final MyStore store,
			final IASTExpression expression) {
		Expression result = null;
		if (expression instanceof IASTLiteralExpression) {
			result = MyExpression.lookUpLiteralExpression(store,
					(IASTLiteralExpression) expression);
		} else if (expression instanceof IASTUnaryExpression) {
			result = MyExpression.lookUpUnaryExpression(store,
					(IASTUnaryExpression) expression);
		} else if (expression instanceof IASTBinaryExpression) {
			result = MyExpression.lookUpBinaryExpression(store,
					(IASTBinaryExpression) expression);
		} else if (expression instanceof IASTIdExpression) {
			result = MyExpression.lookUpVariableExpression(store,
					(IASTIdExpression) expression);
		} else if (expression instanceof IASTFunctionCallExpression) {
			result = MyExpression.lookUpFunctionCallExpresion(store,
					(IASTFunctionCallExpression) expression);
		}
		return result;
	}

	private static Expression lookUpLiteralExpression(final MyStore store,
			final IASTLiteralExpression expr) {
		final LiteralExpression result = store.getFactory()
				.createLiteralExpression();

		String typeName = "";
		final int cType = expr.getKind();
		final char[] eVal = expr.getValue();
		String value = new String(eVal);
		value = value.replace("'", "");
		value = value.replace("\"", "");
		switch (cType) {
		case IASTLiteralExpression.lk_char_constant:
			typeName = "char";
			break;
		case IASTLiteralExpression.lk_false:
			typeName = "bool";
			value = "false";
			break;
		case IASTLiteralExpression.lk_float_constant:
			typeName = "float";
			break;
		case IASTLiteralExpression.lk_integer_constant:
			typeName = "int";
			break;
			/*
		 * case IASTLiteralExpression.lk_nullptr: typeName= "NULL"; value =
		 * "NULL"; break;
		 */
		case IASTLiteralExpression.lk_string_literal:
			typeName = "string";
			break;
			/*
		 * case IASTLiteralExpression.lk_this: typeName= "this"; value = "this";
		 * break;
		 */
		case IASTLiteralExpression.lk_true:
			typeName = "bool";
			value = "true";
			break;
		}
		result.setValue(value);
		final Type type = MyType.lookUpTypeFor(store, typeName);
		result.setType(type);
		return result;
	}

	private static Expression lookUpUnaryExpression(final MyStore store,
			final IASTUnaryExpression expr) {
		final UnaryExpression result = store.getFactory()
				.createUnaryExpression();
		final Expression operand = MyExpression.lookUpExpression(store,
				expr.getOperand());
		final Operator op = MyExpression.lookUpOperator(store,
				expr.getOperator());
		result.setOperator(op);
		result.setOperand(operand);
		return result;
	}

	private static Operator lookUpOperator(final MyStore store,
			final int operator) {
		Operator result = null;
		switch (operator) {
		case IASTUnaryExpression.op_minus:
		case IASTBinaryExpression.op_minus: {
			result = Operator.MINUS;
			break;
		}
		case IASTUnaryExpression.op_plus:
		case IASTBinaryExpression.op_plus: {
			result = Operator.PLUS;
			break;
		}
		case IASTBinaryExpression.op_assign: {
			result = Operator.ASSIGN;
			break;
		}
		default: {
			break;
		}
		}
		return result;
	}

	private static Expression lookUpBinaryExpression(final MyStore store,
			final IASTBinaryExpression expr) {
		final BinaryExpression result = store.getFactory()
				.createBinaryExpression();
		final Expression operand1 = MyExpression.lookUpExpression(store,
				expr.getOperand1());
		final Expression operand2 = MyExpression.lookUpExpression(store,
				expr.getOperand2());
		final Operator op = MyExpression.lookUpOperator(store,
				expr.getOperator());
		result.setOperator(op);
		result.setOperand1(operand1);
		result.setOperand2(operand2);
		return result;
	}

	private static Expression lookUpVariableExpression(final MyStore store,
			final IASTIdExpression expression) {
		final VariableExpression result = store.getFactory()
				.createVariableExpression();
		final String name = expression.getName().toString();
		final Variable variable = MyDeclaration.lookUpVariable(store, name);
		result.setVariable(variable);
		return result;
	}

	private static Expression lookUpFunctionCallExpresion(final MyStore store,
			final IASTFunctionCallExpression expression) {
		final FunctionCallExpression result = store.getFactory()
				.createFunctionCallExpression();
		final IASTExpression fNameExpr = expression.getFunctionNameExpression();
		// if (fNameExpr instanceof IASTIdExpression) {
		final IASTIdExpression idExpr = (IASTIdExpression) fNameExpr;
		final String name = idExpr.getName().toString();
		result.setFunctionName(name);

		final IASTInitializerClause[] clauses = expression.getArguments();
		for (int i = 0; i < clauses.length; i++) {
			final IASTInitializerClause clause = clauses[i];
			final Expression argument = MyInitializer.lookUp(store, clause);
			result.getArguments().add(argument);
		}
		final EList<Expression> parameters = result.getArguments();

		final MyLookUp<FunctionDefinition> myLookUp = new MyLookUp<FunctionDefinition>(
				FunctionDefinition.class);
		final List<FunctionDefinition> functions = myLookUp.lookUpAll(
				store.getScope(), name);
		for (int i = 0; i < functions.size(); i++) {
			final FunctionDefinition fun = functions.get(i);
			// TODO: check parameter types for matches!!!
			final boolean match = MyExpression.functionParametersMatch(
					parameters, fun);
			if (match) {
				result.setFunction(fun);
			}
		}

		return result;
	}

	private static boolean functionParametersMatch(
			final EList<Expression> parameters, final FunctionDefinition fun) {
		final EList<Variable> variables = fun.getParameters();
		if (parameters.size() != variables.size()) {
			return false;
		}
		for (int i = 0; i < variables.size(); i++) {
			final Variable varCheck = variables.get(i);
			final Type tCheck = varCheck.getType();
			final Expression expr = parameters.get(i);
			final Type type = MyExpression.getType(expr);
			if (type != tCheck) {
				return false;
			}
		}
		return true;
	}

	private static Type getType(final Expression expr) {
		if (expr instanceof LiteralExpression) {
			return ((LiteralExpression) expr).getType();
		}
		if (expr instanceof VariableExpression) {
			return ((VariableExpression) expr).getVariable().getType();
		}
		return null;
	}

}
