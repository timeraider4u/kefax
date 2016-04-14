/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.InitializerList;
import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffix;
import at.jku.weiner.c.parser.parser.TypeName;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Postfix Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionImpl#isExt <em>Ext</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionImpl#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionImpl#getInitializerList <em>Initializer List</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionImpl#isComma <em>Comma</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionImpl#getSuffix <em>Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PostfixExpressionImpl extends ExpressionImpl implements PostfixExpression
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PostfixExpressionImpl()
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
		return ParserPackage.Literals.POSTFIX_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExt()
	{
		return (Boolean)eGet(ParserPackage.Literals.POSTFIX_EXPRESSION__EXT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExt(boolean newExt)
	{
		eSet(ParserPackage.Literals.POSTFIX_EXPRESSION__EXT, newExt);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeName getTypeName()
	{
		return (TypeName)eGet(ParserPackage.Literals.POSTFIX_EXPRESSION__TYPE_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeName(TypeName newTypeName)
	{
		eSet(ParserPackage.Literals.POSTFIX_EXPRESSION__TYPE_NAME, newTypeName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitializerList getInitializerList()
	{
		return (InitializerList)eGet(ParserPackage.Literals.POSTFIX_EXPRESSION__INITIALIZER_LIST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitializerList(InitializerList newInitializerList)
	{
		eSet(ParserPackage.Literals.POSTFIX_EXPRESSION__INITIALIZER_LIST, newInitializerList);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isComma()
	{
		return (Boolean)eGet(ParserPackage.Literals.POSTFIX_EXPRESSION__COMMA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComma(boolean newComma)
	{
		eSet(ParserPackage.Literals.POSTFIX_EXPRESSION__COMMA, newComma);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpr()
	{
		return (Expression)eGet(ParserPackage.Literals.POSTFIX_EXPRESSION__EXPR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpr(Expression newExpr)
	{
		eSet(ParserPackage.Literals.POSTFIX_EXPRESSION__EXPR, newExpr);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostfixExpressionSuffix getSuffix()
	{
		return (PostfixExpressionSuffix)eGet(ParserPackage.Literals.POSTFIX_EXPRESSION__SUFFIX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuffix(PostfixExpressionSuffix newSuffix)
	{
		eSet(ParserPackage.Literals.POSTFIX_EXPRESSION__SUFFIX, newSuffix);
	}

} //PostfixExpressionImpl
