/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.ParserPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.ConditionalExpressionImpl#getQExpr <em>QExpr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.ConditionalExpressionImpl#getCExpr <em>CExpr</em>}</li>
 * </ul>
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
		return ParserPackage.Literals.CONDITIONAL_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getQExpr()
	{
		return (Expression)eGet(ParserPackage.Literals.CONDITIONAL_EXPRESSION__QEXPR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQExpr(Expression newQExpr)
	{
		eSet(ParserPackage.Literals.CONDITIONAL_EXPRESSION__QEXPR, newQExpr);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getCExpr()
	{
		return (Expression)eGet(ParserPackage.Literals.CONDITIONAL_EXPRESSION__CEXPR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCExpr(Expression newCExpr)
	{
		eSet(ParserPackage.Literals.CONDITIONAL_EXPRESSION__CEXPR, newCExpr);
	}

} //ConditionalExpressionImpl
