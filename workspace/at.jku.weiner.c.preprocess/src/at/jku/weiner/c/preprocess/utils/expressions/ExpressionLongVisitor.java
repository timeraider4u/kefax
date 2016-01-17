package at.jku.weiner.c.preprocess.utils.expressions;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;

import at.jku.weiner.c.common.common.ArgumentExpressionList;
import at.jku.weiner.c.common.common.Expression;
import at.jku.weiner.c.common.common.PostfixExpression;
import at.jku.weiner.c.common.common.PostfixExpressionSuffix;
import at.jku.weiner.c.common.common.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.common.common.UnaryOperator;
import at.jku.weiner.c.preprocess.utils.macros.DefinitionTable;

import com.google.inject.Injector;

public class ExpressionLongVisitor implements IExpressionVisitor<Long> {

	public static final Long TRUE = new Long(1);
	public static final Long FALSE = new Long(0);
	private final Injector injector;
	private final DefinitionTable definitionTable;
	
	public ExpressionLongVisitor(final Injector injector,
			final DefinitionTable definitionTable) {
		this.injector = injector;
		this.definitionTable = definitionTable;

	}

	@Override
	public Long evaluateForConditionalExpression(final Long a, final Long b,
			final Long c) {
		final boolean isTrue = ExpressionEvaluationUtils.convertFrom(a);
		final Long result = isTrue ? b : c;
		return result;
	}

	@Override
	public Long evaluateForLogicalOrExpression(final Long a, final Long b) {
		Long result = a;
		final boolean x = ExpressionEvaluationUtils.convertFrom(result);
		final boolean y = ExpressionEvaluationUtils.convertFrom(b);
		result = ExpressionEvaluationUtils.convertFrom(x || y);
		return result;
	}

	@Override
	public Long evaluateForLogicalAndExpression(final Long a, final Long b) {
		Long result = a;
		final boolean x = ExpressionEvaluationUtils.convertFrom(result);
		final boolean y = ExpressionEvaluationUtils.convertFrom(b);
		result = ExpressionEvaluationUtils.convertFrom(x && y);
		return result;
	}

	@Override
	public Long evaluateForInclusiveOrExpression(final Long a, final Long b) {
		final Long result = a | b;
		return result;
	}

	@Override
	public Long evaluateForExclusiveOrExpression(final Long a, final Long b) {
		final Long result = a ^ b;
		return result;
	}

	@Override
	public Long evaluateForAndExpression(final Long a, final Long b) {
		final Long result = a & b;
		return result;
	}

	@Override
	public Long evaluateForEqualityExpression(final Long a, final Long b,
			final String op) {
		Long result = null;
		switch (op) {
			case "==":
				result = ExpressionEvaluationUtils.convertFrom(a.equals(b));
				break;
			case "!=":
				result = ExpressionEvaluationUtils.convertFrom(!a.equals(b));
				break;
		}
		return result;
	}

	@Override
	public Long evaluateForRelationalExpression(final Long a, final Long b,
			final String op) {
		Long result = null;
		switch (op) {
			case "<=":
				result = ExpressionEvaluationUtils.convertFrom(a <= b);
				break;
			case "<":
				result = ExpressionEvaluationUtils.convertFrom(a < b);
				break;
			case ">":
				result = ExpressionEvaluationUtils.convertFrom(a > b);
				break;
			case ">=":
				result = ExpressionEvaluationUtils.convertFrom(a >= b);
				break;
		}
		return result;
	}

	@Override
	public Long evaluateForShiftExpression(final Long a, final Long b,
			final String op) {
		Long result = null;
		switch (op) {
			case ">>":
				result = (a >> b);
				break;
			case "<<":
				result = (a << b);
				break;
			default:
				throw new UnsupportedOperationException(
						"other operators not allowed in preprocessor conditionals!");
		}
		return result;
	}

	@Override
	public Long evaluateForAdditiveExpression(final Long a, final Long b,
			final String op) {
		Long result = null;
		switch (op) {
			case "+":
				result = a + b;
				break;
			case "-":
				result = a - b;
				break;
			default:
				throw new UnsupportedOperationException(
						"other operators not allowed in preprocessor conditionals!");
		}
		return result;
	}

	@Override
	public Long evaluateForMultiplicativeExpression(final Long a, final Long b,
			final String op) {
		Long result = null;
		switch (op) {
			case "*":
				result = a * b;
				break;
			case "/":
				result = a / b;
				break;
			case "%":
				result = a % b;
				break;
			default:
				throw new UnsupportedOperationException(
						"other operators not allowed in preprocessor conditionals!");
		}
		return result;
	}

	@Override
	public Long evaluateForUnaryExpression(final Long resultOfCastExpression,
			final UnaryOperator op) {
		switch (op.getOp()) {
			case "-":
				return resultOfCastExpression * (-1);
			case "!":
				if (ExpressionLongVisitor.FALSE.equals(resultOfCastExpression)) {
					return ExpressionLongVisitor.TRUE;
				}
				return ExpressionLongVisitor.FALSE;
			case "+":
				break;
			case "&":
			case "*":
			case "~":
			default:
				throw new UnsupportedOperationException(
						"address operators not allowed in preprocessor conditionals!");
		}
		return resultOfCastExpression;
	}

	@Override
	public Long evaluateConstant(String constant) {
		try {
			if (constant.startsWith("0b") || constant.startsWith("0B")) {
				constant = constant.substring(2);
			}
			constant = this.cutDecimalSuffix(constant);
			final Long result = Long.valueOf(constant);
			return result;
		} catch (final NumberFormatException ex) {
			return ExpressionLongVisitor.FALSE;
		}
	}

	private String cutDecimalSuffix(final String macro) {
		final int index = macro.length();
		if (macro.endsWith("l") || macro.endsWith("L") || macro.endsWith("u")
				|| macro.endsWith("U")) {
			final String sub = macro.substring(0, index - 1);
			return this.cutDecimalSuffix(sub);
		}
		return macro.substring(0, index);
	}

	@Override
	public Long evaluateForId(final boolean isDefined, final String id,
			final PostfixExpression postfix) {
		if (isDefined) {
			if (this.definitionTable.isDefined(id)) {
				return ExpressionLongVisitor.TRUE;
			}
			return ExpressionLongVisitor.FALSE;
		} else {
			final Long result = this.evaluateForString(id, false, postfix);
			return result;
		}
	}

	private Long evaluateForString(final String macroName,
			final boolean isConst, final PostfixExpression postfix) {
		final String code = this.getCode(macroName, postfix);
		final String macro = this.definitionTable.fullResolve(code);
		try {
			if (macro.matches(".*[+\\-*/%><|&^]+.*")) {
				final ExpressionParser parser = new ExpressionParser(
						this.injector);
				final Expression expression = parser.getExpression(macro);

				final IExpressionVisitor<Long> visitor = new ExpressionLongVisitor(
						this.injector, this.definitionTable); // ,
				// this.advanced);
				final ExpressionEvaluation<Long> evaluater = new ExpressionEvaluation<Long>(
						visitor);
				final Long result = evaluater.walkTo(expression);
				return result;
			} else {
				final Long result = this.evaluateConstant(macro);
				return result;
			}
		} catch (final IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	private String getCode(final String macroName,
			final PostfixExpression postfix) {
		if (postfix == null) {
			return macroName;
		}
		final EList<PostfixExpressionSuffix> list = postfix.getSuffix();
		if (list == null) {
			return macroName;
		}
		final StringBuffer result = new StringBuffer(macroName);
		for (int i = 0; i < list.size(); i++) {
			final PostfixExpressionSuffixArgument argument = (PostfixExpressionSuffixArgument) list
					.get(i);
			final ArgumentExpressionList argList = argument
					.getArgumentExpressionList();
			final EList<Expression> exprList = argList.getExpr();
			result.append("(");
			for (int j = 0; j < exprList.size(); j++) {
				if (j > 0) {
					result.append(",");
				}
				final Expression expression = exprList.get(j);
				final IExpressionVisitor<Long> visitor = new ExpressionLongVisitor(
						this.injector, this.definitionTable);
				final ExpressionEvaluation<Long> evaluater = new ExpressionEvaluation<Long>(
						visitor);
				final Long param = evaluater.walkTo(expression);
				result.append(param);
			}
			result.append(")");
		}
		return result.toString();
	}

	@Override
	public Long getDefaultReturn() {
		return ExpressionLongVisitor.FALSE;
	}

}
