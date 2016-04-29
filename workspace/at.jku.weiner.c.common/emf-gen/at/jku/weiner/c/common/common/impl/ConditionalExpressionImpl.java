/**
 */
package at.jku.weiner.c.common.common.impl;

import at.jku.weiner.c.common.common.CommonPackage;
import at.jku.weiner.c.common.common.ConditionalExpression;
import at.jku.weiner.c.common.common.Expression;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.common.common.impl.ConditionalExpressionImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.common.common.impl.ConditionalExpressionImpl#getQExpr <em>QExpr</em>}</li>
 *   <li>{@link at.jku.weiner.c.common.common.impl.ConditionalExpressionImpl#getCExpr <em>CExpr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionalExpressionImpl extends ExpressionImpl implements ConditionalExpression
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionalExpressionImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return CommonPackage.Literals.CONDITIONAL_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpr()
	{
		return (Expression)eGet(CommonPackage.Literals.CONDITIONAL_EXPRESSION__EXPR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpr(Expression newExpr)
	{
		eSet(CommonPackage.Literals.CONDITIONAL_EXPRESSION__EXPR, newExpr);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getQExpr()
	{
		return (Expression)eGet(CommonPackage.Literals.CONDITIONAL_EXPRESSION__QEXPR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQExpr(Expression newQExpr)
	{
		eSet(CommonPackage.Literals.CONDITIONAL_EXPRESSION__QEXPR, newQExpr);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getCExpr()
	{
		return (Expression)eGet(CommonPackage.Literals.CONDITIONAL_EXPRESSION__CEXPR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCExpr(Expression newCExpr)
	{
		eSet(CommonPackage.Literals.CONDITIONAL_EXPRESSION__CEXPR, newCExpr);
	}

} //ConditionalExpressionImpl
