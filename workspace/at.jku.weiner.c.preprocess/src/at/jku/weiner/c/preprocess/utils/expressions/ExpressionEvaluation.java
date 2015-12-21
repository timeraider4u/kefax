package at.jku.weiner.c.preprocess.utils.expressions;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.google.inject.Injector;

import at.jku.weiner.c.common.common.AdditiveExpression;
import at.jku.weiner.c.common.common.AndExpression;
import at.jku.weiner.c.common.common.ArgumentExpressionList;
import at.jku.weiner.c.common.common.CastExpression;
import at.jku.weiner.c.common.common.ConditionalExpression;
import at.jku.weiner.c.common.common.ConstantExpression;
import at.jku.weiner.c.common.common.EqualityExpression;
import at.jku.weiner.c.common.common.ExclusiveOrExpression;
import at.jku.weiner.c.common.common.Expression;
import at.jku.weiner.c.common.common.InclusiveOrExpression;
import at.jku.weiner.c.common.common.LogicalAndExpression;
import at.jku.weiner.c.common.common.LogicalOrExpression;
import at.jku.weiner.c.common.common.MultiplicativeExpression;
import at.jku.weiner.c.common.common.PostfixExpression;
import at.jku.weiner.c.common.common.PostfixExpressionSuffix;
import at.jku.weiner.c.common.common.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;
import at.jku.weiner.c.common.common.RelationalExpression;
import at.jku.weiner.c.common.common.ShiftExpression;
import at.jku.weiner.c.common.common.UnaryExpression;
import at.jku.weiner.c.common.common.UnaryOperator;
import at.jku.weiner.c.preprocess.utils.macros.DefinitionTable;

public class ExpressionEvaluation implements IExpressionWalker<Integer> {

	public static final Integer TRUE = 1;
	public static final Integer FALSE = 0;

	private final boolean advanced;
	private final ResourceSet set;

	public static boolean evaluateFor(final Expression expression,
			final ResourceSet set, final boolean advanced) {
		final ExpressionEvaluation evaluate = new ExpressionEvaluation(set,
				advanced);
		final Integer value = evaluate.walkTo(expression);
		final boolean result = ExpressionEvaluationUtils.convertFrom(value);
		return result;
	}

	public ExpressionEvaluation(final ResourceSet set, final boolean advanced) {
		this.set = set;
		this.advanced = advanced;
	}

	@Override
	public Integer walkTo(final Expression expression) {
		if (expression instanceof ConstantExpression) {
			return this.walkTo((ConstantExpression) expression);
		} else if (expression instanceof ConditionalExpression) {
			return this.walkTo((ConditionalExpression) expression);
		} else if (expression instanceof LogicalOrExpression) {
			return this.walkTo((LogicalOrExpression) expression);
		} else if (expression instanceof LogicalAndExpression) {
			return this.walkTo((LogicalAndExpression) expression);
		} else if (expression instanceof InclusiveOrExpression) {
			return this.walkTo((InclusiveOrExpression) expression);
		} else if (expression instanceof ExclusiveOrExpression) {
			return this.walkTo((ExclusiveOrExpression) expression);
		} else if (expression instanceof AndExpression) {
			return this.walkTo((AndExpression) expression);
		} else if (expression instanceof EqualityExpression) {
			return this.walkTo((EqualityExpression) expression);
		} else if (expression instanceof RelationalExpression) {
			return this.walkTo((RelationalExpression) expression);
		} else if (expression instanceof ShiftExpression) {
			return this.walkTo((ShiftExpression) expression);
		} else if (expression instanceof AdditiveExpression) {
			return this.walkTo((AdditiveExpression) expression);
		} else if (expression instanceof MultiplicativeExpression) {
			return this.walkTo((MultiplicativeExpression) expression);
		} else if (expression instanceof CastExpression) {
			return this.walkTo((CastExpression) expression);
		} else if (expression instanceof UnaryExpression) {
			return this.walkTo((UnaryExpression) expression);
		} else if (expression instanceof PostfixExpression) {
			return this.walkTo((PostfixExpression) expression);
		} else if (expression instanceof PrimaryExpression) {
			return this.walkTo((PrimaryExpression) expression);
		}
		return this.walkTo((Expression) expression.getExpression());
	}

	@Override
	public Integer walkTo(final ConstantExpression expression) {
		final int result = this.walkTo((Expression) expression.getExpr());
		return result;
	}

	@Override
	public Integer walkTo(final ConditionalExpression expression) {
		final int a = this.walkTo((Expression) expression.getExpr());
		final Expression qExpr = (Expression) expression.getQExpr();
		final Expression cExpr = (Expression) expression.getCExpr();
		if ((qExpr == null) || (cExpr == null)) {
			return a;
		}
		final Integer b = this.walkTo(qExpr);
		final Integer c = this.walkTo(cExpr);
		final boolean isTrue = ExpressionEvaluationUtils.convertFrom(a);
		final Integer result = isTrue ? b : c;
		return result;
	}

	@Override
	public Integer walkTo(final LogicalOrExpression expression) {
		final EList<Expression> list = expression.getExpr();
		int result = this.walkTo(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			final int next = this.walkTo(list.get(i));
			final boolean a = ExpressionEvaluationUtils.convertFrom(result);
			final boolean b = ExpressionEvaluationUtils.convertFrom(next);
			result = ExpressionEvaluationUtils.convertFrom(a || b);
		}
		return result;
	}

	@Override
	public Integer walkTo(final LogicalAndExpression expression) {
		final EList<Expression> list = expression.getExpr();
		int result = this.walkTo(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			final int next = this.walkTo(list.get(i));
			final boolean a = ExpressionEvaluationUtils.convertFrom(result);
			final boolean b = ExpressionEvaluationUtils.convertFrom(next);
			result = ExpressionEvaluationUtils.convertFrom(a && b);
		}
		return result;
	}

	@Override
	public Integer walkTo(final InclusiveOrExpression expression) {
		final EList<Expression> list = expression.getExpr();
		int result = this.walkTo(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			final int next = this.walkTo(list.get(i));
			result = result | next;
		}
		return result;
	}

	@Override
	public Integer walkTo(final ExclusiveOrExpression expression) {
		final EList<Expression> list = expression.getExpr();
		int result = this.walkTo(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			final int next = this.walkTo(list.get(i));
			result = result ^ next;
		}
		return result;
	}

	@Override
	public Integer walkTo(final AndExpression expression) {
		final EList<Expression> list = expression.getExpr();
		int result = this.walkTo(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			final int next = this.walkTo(list.get(i));
			result = result & next;
		}
		return result;
	}

	@Override
	public Integer walkTo(final EqualityExpression expression) {
		final EList<Expression> list = expression.getExpr();
		int result = this.walkTo(list.get(0));
		final EList<String> ops = expression.getOp();
		ExpressionEvaluationUtils.checkLists(list, ops, "equlity");
		for (int i = 0; i < ops.size(); i++) {
			final int next = this.walkTo(list.get(i + 1));
			final String op = ops.get(i);
			switch (op) {
			case "==":
				result = ExpressionEvaluationUtils.convertFrom(result == next);
				break;
			case "!=":
				result = ExpressionEvaluationUtils.convertFrom(result != next);
				break;
			}
		}
		return result;
	}

	@Override
	public Integer walkTo(final RelationalExpression expression) {
		final EList<Expression> list = expression.getExpr();
		int result = this.walkTo(list.get(0));
		final EList<String> ops = expression.getOp();
		ExpressionEvaluationUtils.checkLists(list, ops, "relational");
		for (int i = 0; i < ops.size(); i++) {
			final int next = this.walkTo(list.get(i + 1));
			final String op = ops.get(i);
			switch (op) {
			case "<=":
				result = ExpressionEvaluationUtils.convertFrom(result <= next);
				break;
			case "<":
				result = ExpressionEvaluationUtils.convertFrom(result < next);
				break;
			case ">":
				result = ExpressionEvaluationUtils.convertFrom(result > next);
				break;
			case ">=":
				result = ExpressionEvaluationUtils.convertFrom(result >= next);
				break;
			}
		}
		return result;
	}

	@Override
	public Integer walkTo(final ShiftExpression expression) {
		final EList<Expression> list = expression.getExpr();
		int result = this.walkTo(list.get(0));
		final EList<String> ops = expression.getOp();
		ExpressionEvaluationUtils.checkLists(list, ops, "shift");
		for (int i = 0; i < ops.size(); i++) {
			final int next = this.walkTo(list.get(i + 1));
			final String op = ops.get(i);
			switch (op) {
			case ">>":
				result = (result >> next);
				break;
			case "<<":
				result = (result << next);
				break;
			}
		}
		return result;
	}

	@Override
	public Integer walkTo(final AdditiveExpression expression) {
		final EList<Expression> list = expression.getExpr();
		int result = this.walkTo(list.get(0));
		final EList<String> ops = expression.getOp();
		ExpressionEvaluationUtils.checkLists(list, ops, "additive");
		for (int i = 0; i < ops.size(); i++) {
			final int next = this.walkTo(list.get(i + 1));
			final String op = ops.get(i);
			switch (op) {
			case "+":
				result = result + next;
				break;
			case "-":
				result = result - next;
				break;
			}
		}
		return result;
	}

	@Override
	public Integer walkTo(final MultiplicativeExpression expression) {
		final EList<Expression> list = expression.getExpr();
		int result = this.walkTo(list.get(0));
		final EList<String> ops = expression.getOp();
		ExpressionEvaluationUtils.checkLists(list, ops, "multiplicate");
		for (int i = 0; i < ops.size(); i++) {
			final int next = this.walkTo(list.get(i + 1));
			final String op = ops.get(i);
			switch (op) {
			case "*":
				result = result * next;
				break;
			case "/":
				result = result / next;
				break;
			case "%":
				result = result % next;
				break;
			}
		}
		return result;
	}

	@Override
	public Integer walkTo(final CastExpression expression) {
		final int result = this.walkTo(expression.getExpr());
		return result;
	}

	@Override
	public Integer walkTo(final UnaryExpression expression) {
		final Expression expr = expression.getExpr();
		if (expr instanceof PostfixExpression) {
			final int result = this.walkTo((PostfixExpression) expr);
			return result;
		}

		final UnaryOperator op = expression.getOp();
		final int result = this.walkTo((CastExpression) expr);
		switch (op.getOp()) {
		case "-":
			return result * (-1);
		case "!":
			if (result == ExpressionEvaluation.FALSE) {
				return ExpressionEvaluation.TRUE;
			}
			return ExpressionEvaluation.FALSE;
		case "+":
			break;
		case "&":
		case "*":
		case "~":
		default:
			throw new UnsupportedOperationException(
					"address operators not allowed in preprocessor conditionals!");
		}
		return result;
	}

	@Override
	public Integer walkTo(final PostfixExpression expression) {
		final Expression expr = expression.getExpr();
		if (expr instanceof PrimaryExpression) {
			final int result = this.walkTo((PrimaryExpression) expr);
			return result;
		} else {
			final int result = this
					.walkTo((at.jku.weiner.c.common.common.PrimaryExpression) expr);
			return result;
		}
	}

	@Override
	public Integer walkTo(
			final at.jku.weiner.c.common.common.PrimaryExpression expression) {
		final Expression expr = expression.getExpr();
		if (expr != null) {
			final Integer result = this.walkTo(expr);
			return result;
		}
		final String constant = expression.getConst();
		final Integer result = this.evaluateConstant(constant);
		return result;
	}

	@Override
	public Integer walkTo(final PrimaryExpression expression) {
		final String constant = expression.getConst();
		final String id = expression.getId();
		final Expression expr = expression.getExpr();
		if (constant != null) {
			return this.evaluateConstant(constant);
		}
		if (id != null) {
			if (expression.isDefined()) {
				if (DefinitionTable.isDefined(id)) {
					return ExpressionEvaluation.TRUE;
				}
				return ExpressionEvaluation.FALSE;
			} else {
				final EObject object = expression.eContainer();
				final PostfixExpression postfix = (PostfixExpression) object;

				return this.evaluateForString(id, false, postfix);
			}
		}
		if (expr != null) {
			return this.walkTo(expr);
		}
		return ExpressionEvaluation.FALSE;
	}

	private int evaluateConstant(String constant) {
		try {
			if (constant.startsWith("0b") || constant.startsWith("0B")) {
				constant = constant.substring(2);
			}
			constant = this.cutDecimalSuffix(constant);
			final int result = Integer.valueOf(constant);
			return result;
		} catch (final NumberFormatException ex) {
			return ExpressionEvaluation.FALSE;
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

	private int evaluateForString(final String macroName,
			final boolean isConst, final PostfixExpression postfix) {
		final String code = this.getCode(macroName, postfix);
		final String macro = DefinitionTable.resolve(code);
		try {
			if (macro.matches(".*[+\\-*/%><|&^]+.*")) {
				// System.out.println("string='" + macro + "'");
				final ExpressionParser parser = new ExpressionParser(this.set);
				final Expression expression = parser.getExpression(macro);
				final ExpressionEvaluation evaluater = new ExpressionEvaluation(
						this.set, this.advanced);
				final Integer result = evaluater.walkTo(expression);
				return result;
			} else {
				return this.evaluateConstant(macro);
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
				final ExpressionEvaluation evaluater = new ExpressionEvaluation(
						this.set, this.advanced);
				final Integer param = evaluater.walkTo(expression);
				result.append(param);
			}
			result.append(")");
		}
		return result.toString();
	}

}
