/**
 */
package at.jku.weiner.c.common.common.impl;

import at.jku.weiner.c.common.common.CommonPackage;
import at.jku.weiner.c.common.common.Expression;
import at.jku.weiner.c.common.common.MultiplicativeExpression;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiplicative Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.common.common.impl.MultiplicativeExpressionImpl#getOp <em>Op</em>}</li>
 *   <li>{@link at.jku.weiner.c.common.common.impl.MultiplicativeExpressionImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link at.jku.weiner.c.common.common.impl.MultiplicativeExpressionImpl#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiplicativeExpressionImpl extends ExpressionImpl implements MultiplicativeExpression
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiplicativeExpressionImpl()
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
		return CommonPackage.Literals.MULTIPLICATIVE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOp()
	{
		return (String)eGet(CommonPackage.Literals.MULTIPLICATIVE_EXPRESSION__OP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOp(String newOp)
	{
		eSet(CommonPackage.Literals.MULTIPLICATIVE_EXPRESSION__OP, newOp);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getLeft()
	{
		return (Expression)eGet(CommonPackage.Literals.MULTIPLICATIVE_EXPRESSION__LEFT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeft(Expression newLeft)
	{
		eSet(CommonPackage.Literals.MULTIPLICATIVE_EXPRESSION__LEFT, newLeft);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getRight()
	{
		return (Expression)eGet(CommonPackage.Literals.MULTIPLICATIVE_EXPRESSION__RIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRight(Expression newRight)
	{
		eSet(CommonPackage.Literals.MULTIPLICATIVE_EXPRESSION__RIGHT, newRight);
	}

} //MultiplicativeExpressionImpl
