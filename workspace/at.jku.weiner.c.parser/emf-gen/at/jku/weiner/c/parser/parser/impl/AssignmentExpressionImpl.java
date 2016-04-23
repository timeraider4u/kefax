/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.ParserPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assignment Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AssignmentExpressionImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AssignmentExpressionImpl#getOp <em>Op</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AssignmentExpressionImpl#getAssignmentExpr <em>Assignment Expr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssignmentExpressionImpl extends ExpressionImpl implements AssignmentExpression
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssignmentExpressionImpl()
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
		return ParserPackage.Literals.ASSIGNMENT_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpr()
	{
		return (Expression)eGet(ParserPackage.Literals.ASSIGNMENT_EXPRESSION__EXPR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpr(Expression newExpr)
	{
		eSet(ParserPackage.Literals.ASSIGNMENT_EXPRESSION__EXPR, newExpr);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOp()
	{
		return (String)eGet(ParserPackage.Literals.ASSIGNMENT_EXPRESSION__OP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOp(String newOp)
	{
		eSet(ParserPackage.Literals.ASSIGNMENT_EXPRESSION__OP, newOp);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getAssignmentExpr()
	{
		return (Expression)eGet(ParserPackage.Literals.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssignmentExpr(Expression newAssignmentExpr)
	{
		eSet(ParserPackage.Literals.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPR, newAssignmentExpr);
	}

} //AssignmentExpressionImpl
