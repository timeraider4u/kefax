/**
 */
package at.jku.weiner.c.common.common.impl;

import at.jku.weiner.c.common.common.CommonPackage;
import at.jku.weiner.c.common.common.Expression;
import at.jku.weiner.c.common.common.RelationalExpression;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relational Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.common.common.impl.RelationalExpressionImpl#getOp <em>Op</em>}</li>
 *   <li>{@link at.jku.weiner.c.common.common.impl.RelationalExpressionImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link at.jku.weiner.c.common.common.impl.RelationalExpressionImpl#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationalExpressionImpl extends ExpressionImpl implements RelationalExpression
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationalExpressionImpl()
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
		return CommonPackage.Literals.RELATIONAL_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOp()
	{
		return (String)eGet(CommonPackage.Literals.RELATIONAL_EXPRESSION__OP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOp(String newOp)
	{
		eSet(CommonPackage.Literals.RELATIONAL_EXPRESSION__OP, newOp);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getLeft()
	{
		return (Expression)eGet(CommonPackage.Literals.RELATIONAL_EXPRESSION__LEFT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeft(Expression newLeft)
	{
		eSet(CommonPackage.Literals.RELATIONAL_EXPRESSION__LEFT, newLeft);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getRight()
	{
		return (Expression)eGet(CommonPackage.Literals.RELATIONAL_EXPRESSION__RIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRight(Expression newRight)
	{
		eSet(CommonPackage.Literals.RELATIONAL_EXPRESSION__RIGHT, newRight);
	}

} //RelationalExpressionImpl
