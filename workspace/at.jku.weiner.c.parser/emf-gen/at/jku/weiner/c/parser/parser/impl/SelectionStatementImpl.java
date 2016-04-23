/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.SelectionStatement;
import at.jku.weiner.c.parser.parser.Statement;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Selection Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.SelectionStatementImpl#getIf <em>If</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.SelectionStatementImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.SelectionStatementImpl#getIfStatement <em>If Statement</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.SelectionStatementImpl#getElse <em>Else</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.SelectionStatementImpl#getElseStatement <em>Else Statement</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.SelectionStatementImpl#getSwitch <em>Switch</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.SelectionStatementImpl#getSwitchStatement <em>Switch Statement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SelectionStatementImpl extends StatementImpl implements SelectionStatement
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SelectionStatementImpl()
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
		return ParserPackage.Literals.SELECTION_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIf()
	{
		return (String)eGet(ParserPackage.Literals.SELECTION_STATEMENT__IF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIf(String newIf)
	{
		eSet(ParserPackage.Literals.SELECTION_STATEMENT__IF, newIf);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpr()
	{
		return (Expression)eGet(ParserPackage.Literals.SELECTION_STATEMENT__EXPR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpr(Expression newExpr)
	{
		eSet(ParserPackage.Literals.SELECTION_STATEMENT__EXPR, newExpr);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statement getIfStatement()
	{
		return (Statement)eGet(ParserPackage.Literals.SELECTION_STATEMENT__IF_STATEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIfStatement(Statement newIfStatement)
	{
		eSet(ParserPackage.Literals.SELECTION_STATEMENT__IF_STATEMENT, newIfStatement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElse()
	{
		return (String)eGet(ParserPackage.Literals.SELECTION_STATEMENT__ELSE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElse(String newElse)
	{
		eSet(ParserPackage.Literals.SELECTION_STATEMENT__ELSE, newElse);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statement getElseStatement()
	{
		return (Statement)eGet(ParserPackage.Literals.SELECTION_STATEMENT__ELSE_STATEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElseStatement(Statement newElseStatement)
	{
		eSet(ParserPackage.Literals.SELECTION_STATEMENT__ELSE_STATEMENT, newElseStatement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSwitch()
	{
		return (String)eGet(ParserPackage.Literals.SELECTION_STATEMENT__SWITCH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSwitch(String newSwitch)
	{
		eSet(ParserPackage.Literals.SELECTION_STATEMENT__SWITCH, newSwitch);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statement getSwitchStatement()
	{
		return (Statement)eGet(ParserPackage.Literals.SELECTION_STATEMENT__SWITCH_STATEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSwitchStatement(Statement newSwitchStatement)
	{
		eSet(ParserPackage.Literals.SELECTION_STATEMENT__SWITCH_STATEMENT, newSwitchStatement);
	}

} //SelectionStatementImpl
