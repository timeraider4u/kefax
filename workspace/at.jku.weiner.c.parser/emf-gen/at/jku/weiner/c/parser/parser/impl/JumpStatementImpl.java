/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.ParserPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jump Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.JumpStatementImpl#getContinue <em>Continue</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.JumpStatementImpl#getBreak <em>Break</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.JumpStatementImpl#getReturn <em>Return</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.JumpStatementImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.JumpStatementImpl#getGoto <em>Goto</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JumpStatementImpl extends StatementImpl implements JumpStatement
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JumpStatementImpl()
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
		return ParserPackage.Literals.JUMP_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContinue()
	{
		return (String)eGet(ParserPackage.Literals.JUMP_STATEMENT__CONTINUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContinue(String newContinue)
	{
		eSet(ParserPackage.Literals.JUMP_STATEMENT__CONTINUE, newContinue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBreak()
	{
		return (String)eGet(ParserPackage.Literals.JUMP_STATEMENT__BREAK, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBreak(String newBreak)
	{
		eSet(ParserPackage.Literals.JUMP_STATEMENT__BREAK, newBreak);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReturn()
	{
		return (String)eGet(ParserPackage.Literals.JUMP_STATEMENT__RETURN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturn(String newReturn)
	{
		eSet(ParserPackage.Literals.JUMP_STATEMENT__RETURN, newReturn);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpr()
	{
		return (Expression)eGet(ParserPackage.Literals.JUMP_STATEMENT__EXPR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpr(Expression newExpr)
	{
		eSet(ParserPackage.Literals.JUMP_STATEMENT__EXPR, newExpr);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGoto()
	{
		return (String)eGet(ParserPackage.Literals.JUMP_STATEMENT__GOTO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGoto(String newGoto)
	{
		eSet(ParserPackage.Literals.JUMP_STATEMENT__GOTO, newGoto);
	}

} //JumpStatementImpl
