/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.common.common.Constant2;

import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.TypeName;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primary Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl#getIdent <em>Ident</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl#getConst <em>Const</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl#getString <em>String</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl#isParentheses <em>Parentheses</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl#isExt <em>Ext</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl#getCompoundStmt <em>Compound Stmt</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl#isBuiltin_offsetof <em>Builtin offsetof</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl#isBuiltin_typescompatiblep <em>Builtin typescompatiblep</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl#getTypeName2 <em>Type Name2</em>}</li>
 * </ul>
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
		return ParserPackage.Literals.PRIMARY_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdent()
	{
		return (String)eGet(ParserPackage.Literals.PRIMARY_EXPRESSION__IDENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdent(String newIdent)
	{
		eSet(ParserPackage.Literals.PRIMARY_EXPRESSION__IDENT, newIdent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constant2 getConst()
	{
		return (Constant2)eGet(ParserPackage.Literals.PRIMARY_EXPRESSION__CONST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConst(Constant2 newConst)
	{
		eSet(ParserPackage.Literals.PRIMARY_EXPRESSION__CONST, newConst);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getString()
	{
		return (EList<String>)eGet(ParserPackage.Literals.PRIMARY_EXPRESSION__STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isParentheses()
	{
		return (Boolean)eGet(ParserPackage.Literals.PRIMARY_EXPRESSION__PARENTHESES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentheses(boolean newParentheses)
	{
		eSet(ParserPackage.Literals.PRIMARY_EXPRESSION__PARENTHESES, newParentheses);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpr()
	{
		return (Expression)eGet(ParserPackage.Literals.PRIMARY_EXPRESSION__EXPR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpr(Expression newExpr)
	{
		eSet(ParserPackage.Literals.PRIMARY_EXPRESSION__EXPR, newExpr);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExt()
	{
		return (Boolean)eGet(ParserPackage.Literals.PRIMARY_EXPRESSION__EXT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExt(boolean newExt)
	{
		eSet(ParserPackage.Literals.PRIMARY_EXPRESSION__EXT, newExt);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statement getCompoundStmt()
	{
		return (Statement)eGet(ParserPackage.Literals.PRIMARY_EXPRESSION__COMPOUND_STMT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompoundStmt(Statement newCompoundStmt)
	{
		eSet(ParserPackage.Literals.PRIMARY_EXPRESSION__COMPOUND_STMT, newCompoundStmt);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBuiltin_offsetof()
	{
		return (Boolean)eGet(ParserPackage.Literals.PRIMARY_EXPRESSION__BUILTIN_OFFSETOF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBuiltin_offsetof(boolean newBuiltin_offsetof)
	{
		eSet(ParserPackage.Literals.PRIMARY_EXPRESSION__BUILTIN_OFFSETOF, newBuiltin_offsetof);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeName getTypeName()
	{
		return (TypeName)eGet(ParserPackage.Literals.PRIMARY_EXPRESSION__TYPE_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeName(TypeName newTypeName)
	{
		eSet(ParserPackage.Literals.PRIMARY_EXPRESSION__TYPE_NAME, newTypeName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBuiltin_typescompatiblep()
	{
		return (Boolean)eGet(ParserPackage.Literals.PRIMARY_EXPRESSION__BUILTIN_TYPESCOMPATIBLEP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBuiltin_typescompatiblep(boolean newBuiltin_typescompatiblep)
	{
		eSet(ParserPackage.Literals.PRIMARY_EXPRESSION__BUILTIN_TYPESCOMPATIBLEP, newBuiltin_typescompatiblep);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeName getTypeName2()
	{
		return (TypeName)eGet(ParserPackage.Literals.PRIMARY_EXPRESSION__TYPE_NAME2, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeName2(TypeName newTypeName2)
	{
		eSet(ParserPackage.Literals.PRIMARY_EXPRESSION__TYPE_NAME2, newTypeName2);
	}

} //PrimaryExpressionImpl
