/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.TypeName;
import at.jku.weiner.c.parser.parser.UnaryExpression;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.UnaryExpressionImpl#getPlusplus <em>Plusplus</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.UnaryExpressionImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.UnaryExpressionImpl#getMinusminus <em>Minusminus</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.UnaryExpressionImpl#getOp <em>Op</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.UnaryExpressionImpl#getSizeOf <em>Size Of</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.UnaryExpressionImpl#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.UnaryExpressionImpl#getAlignOf <em>Align Of</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.UnaryExpressionImpl#getAndand <em>Andand</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.UnaryExpressionImpl#getIdent <em>Ident</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnaryExpressionImpl extends ExpressionImpl implements UnaryExpression
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnaryExpressionImpl()
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
		return ParserPackage.Literals.UNARY_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPlusplus()
	{
		return (String)eGet(ParserPackage.Literals.UNARY_EXPRESSION__PLUSPLUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlusplus(String newPlusplus)
	{
		eSet(ParserPackage.Literals.UNARY_EXPRESSION__PLUSPLUS, newPlusplus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpr()
	{
		return (Expression)eGet(ParserPackage.Literals.UNARY_EXPRESSION__EXPR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpr(Expression newExpr)
	{
		eSet(ParserPackage.Literals.UNARY_EXPRESSION__EXPR, newExpr);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinusminus()
	{
		return (String)eGet(ParserPackage.Literals.UNARY_EXPRESSION__MINUSMINUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinusminus(String newMinusminus)
	{
		eSet(ParserPackage.Literals.UNARY_EXPRESSION__MINUSMINUS, newMinusminus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOp()
	{
		return (String)eGet(ParserPackage.Literals.UNARY_EXPRESSION__OP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOp(String newOp)
	{
		eSet(ParserPackage.Literals.UNARY_EXPRESSION__OP, newOp);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSizeOf()
	{
		return (String)eGet(ParserPackage.Literals.UNARY_EXPRESSION__SIZE_OF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSizeOf(String newSizeOf)
	{
		eSet(ParserPackage.Literals.UNARY_EXPRESSION__SIZE_OF, newSizeOf);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeName getTypeName()
	{
		return (TypeName)eGet(ParserPackage.Literals.UNARY_EXPRESSION__TYPE_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeName(TypeName newTypeName)
	{
		eSet(ParserPackage.Literals.UNARY_EXPRESSION__TYPE_NAME, newTypeName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAlignOf()
	{
		return (String)eGet(ParserPackage.Literals.UNARY_EXPRESSION__ALIGN_OF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlignOf(String newAlignOf)
	{
		eSet(ParserPackage.Literals.UNARY_EXPRESSION__ALIGN_OF, newAlignOf);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAndand()
	{
		return (String)eGet(ParserPackage.Literals.UNARY_EXPRESSION__ANDAND, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAndand(String newAndand)
	{
		eSet(ParserPackage.Literals.UNARY_EXPRESSION__ANDAND, newAndand);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdent()
	{
		return (String)eGet(ParserPackage.Literals.UNARY_EXPRESSION__IDENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdent(String newIdent)
	{
		eSet(ParserPackage.Literals.UNARY_EXPRESSION__IDENT, newIdent);
	}

} //UnaryExpressionImpl
