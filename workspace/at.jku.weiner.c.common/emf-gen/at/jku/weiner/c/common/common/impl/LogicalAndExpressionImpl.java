/**
 */
package at.jku.weiner.c.common.common.impl;

import at.jku.weiner.c.common.common.CommonPackage;
import at.jku.weiner.c.common.common.Expression;
import at.jku.weiner.c.common.common.LogicalAndExpression;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Logical And Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.common.common.impl.LogicalAndExpressionImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link at.jku.weiner.c.common.common.impl.LogicalAndExpressionImpl#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LogicalAndExpressionImpl extends ExpressionImpl implements LogicalAndExpression
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LogicalAndExpressionImpl()
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
		return CommonPackage.Literals.LOGICAL_AND_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getLeft()
	{
		return (Expression)eGet(CommonPackage.Literals.LOGICAL_AND_EXPRESSION__LEFT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeft(Expression newLeft)
	{
		eSet(CommonPackage.Literals.LOGICAL_AND_EXPRESSION__LEFT, newLeft);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getRight()
	{
		return (Expression)eGet(CommonPackage.Literals.LOGICAL_AND_EXPRESSION__RIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRight(Expression newRight)
	{
		eSet(CommonPackage.Literals.LOGICAL_AND_EXPRESSION__RIGHT, newRight);
	}

} //LogicalAndExpressionImpl
