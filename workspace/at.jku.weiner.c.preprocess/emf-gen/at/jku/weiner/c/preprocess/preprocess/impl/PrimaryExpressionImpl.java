/**
 */
package at.jku.weiner.c.preprocess.preprocess.impl;

import at.jku.weiner.c.common.common.Expression;

import at.jku.weiner.c.preprocess.preprocess.PreprocessPackage;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primary Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.PrimaryExpressionImpl#isDefined <em>Defined</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.PrimaryExpressionImpl#getIdent <em>Ident</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.PrimaryExpressionImpl#getConst <em>Const</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.PrimaryExpressionImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.PrimaryExpressionImpl#isParentheses <em>Parentheses</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimaryExpressionImpl extends ExpressionImpl implements PrimaryExpression
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimaryExpressionImpl()
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
		return PreprocessPackage.Literals.PRIMARY_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDefined()
	{
		return (Boolean)eGet(PreprocessPackage.Literals.PRIMARY_EXPRESSION__DEFINED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefined(boolean newDefined)
	{
		eSet(PreprocessPackage.Literals.PRIMARY_EXPRESSION__DEFINED, newDefined);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdent()
	{
		return (String)eGet(PreprocessPackage.Literals.PRIMARY_EXPRESSION__IDENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdent(String newIdent)
	{
		eSet(PreprocessPackage.Literals.PRIMARY_EXPRESSION__IDENT, newIdent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConst()
	{
		return (String)eGet(PreprocessPackage.Literals.PRIMARY_EXPRESSION__CONST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConst(String newConst)
	{
		eSet(PreprocessPackage.Literals.PRIMARY_EXPRESSION__CONST, newConst);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpr()
	{
		return (Expression)eGet(PreprocessPackage.Literals.PRIMARY_EXPRESSION__EXPR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpr(Expression newExpr)
	{
		eSet(PreprocessPackage.Literals.PRIMARY_EXPRESSION__EXPR, newExpr);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isParentheses()
	{
		return (Boolean)eGet(PreprocessPackage.Literals.PRIMARY_EXPRESSION__PARENTHESES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentheses(boolean newParentheses)
	{
		eSet(PreprocessPackage.Literals.PRIMARY_EXPRESSION__PARENTHESES, newParentheses);
	}

} //PrimaryExpressionImpl
