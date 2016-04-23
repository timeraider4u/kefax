/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.ConstantExpression;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.ParserPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constant Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.ConstantExpressionImpl#getRestrict <em>Restrict</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.ConstantExpressionImpl#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConstantExpressionImpl extends ExpressionImpl implements ConstantExpression
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstantExpressionImpl()
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
		return ParserPackage.Literals.CONSTANT_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRestrict()
	{
		return (String)eGet(ParserPackage.Literals.CONSTANT_EXPRESSION__RESTRICT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRestrict(String newRestrict)
	{
		eSet(ParserPackage.Literals.CONSTANT_EXPRESSION__RESTRICT, newRestrict);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpr()
	{
		return (Expression)eGet(ParserPackage.Literals.CONSTANT_EXPRESSION__EXPR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpr(Expression newExpr)
	{
		eSet(ParserPackage.Literals.CONSTANT_EXPRESSION__EXPR, newExpr);
	}

} //ConstantExpressionImpl
