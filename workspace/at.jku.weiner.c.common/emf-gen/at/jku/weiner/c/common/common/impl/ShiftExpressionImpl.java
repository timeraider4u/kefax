/**
 */
package at.jku.weiner.c.common.common.impl;

import at.jku.weiner.c.common.common.CommonPackage;
import at.jku.weiner.c.common.common.Expression;
import at.jku.weiner.c.common.common.ShiftExpression;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Shift Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.common.common.impl.ShiftExpressionImpl#getOp <em>Op</em>}</li>
 *   <li>{@link at.jku.weiner.c.common.common.impl.ShiftExpressionImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link at.jku.weiner.c.common.common.impl.ShiftExpressionImpl#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ShiftExpressionImpl extends ExpressionImpl implements ShiftExpression
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ShiftExpressionImpl()
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
		return CommonPackage.Literals.SHIFT_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOp()
	{
		return (String)eGet(CommonPackage.Literals.SHIFT_EXPRESSION__OP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOp(String newOp)
	{
		eSet(CommonPackage.Literals.SHIFT_EXPRESSION__OP, newOp);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getLeft()
	{
		return (Expression)eGet(CommonPackage.Literals.SHIFT_EXPRESSION__LEFT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeft(Expression newLeft)
	{
		eSet(CommonPackage.Literals.SHIFT_EXPRESSION__LEFT, newLeft);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getRight()
	{
		return (Expression)eGet(CommonPackage.Literals.SHIFT_EXPRESSION__RIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRight(Expression newRight)
	{
		eSet(CommonPackage.Literals.SHIFT_EXPRESSION__RIGHT, newRight);
	}

} //ShiftExpressionImpl
