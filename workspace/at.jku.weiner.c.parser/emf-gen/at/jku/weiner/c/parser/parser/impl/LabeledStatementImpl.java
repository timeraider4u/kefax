/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.LabeledStatement;
import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.Statement;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Labeled Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.LabeledStatementImpl#getId <em>Id</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.LabeledStatementImpl#getLStmt <em>LStmt</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.LabeledStatementImpl#getCase <em>Case</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.LabeledStatementImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.LabeledStatementImpl#getHigher <em>Higher</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.LabeledStatementImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.LabeledStatementImpl#isMydefault <em>Mydefault</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LabeledStatementImpl extends StatementImpl implements LabeledStatement
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LabeledStatementImpl()
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
		return ParserPackage.Literals.LABELED_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId()
	{
		return (String)eGet(ParserPackage.Literals.LABELED_STATEMENT__ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId)
	{
		eSet(ParserPackage.Literals.LABELED_STATEMENT__ID, newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statement getLStmt()
	{
		return (Statement)eGet(ParserPackage.Literals.LABELED_STATEMENT__LSTMT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLStmt(Statement newLStmt)
	{
		eSet(ParserPackage.Literals.LABELED_STATEMENT__LSTMT, newLStmt);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCase()
	{
		return (String)eGet(ParserPackage.Literals.LABELED_STATEMENT__CASE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCase(String newCase)
	{
		eSet(ParserPackage.Literals.LABELED_STATEMENT__CASE, newCase);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLower()
	{
		return (String)eGet(ParserPackage.Literals.LABELED_STATEMENT__LOWER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLower(String newLower)
	{
		eSet(ParserPackage.Literals.LABELED_STATEMENT__LOWER, newLower);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHigher()
	{
		return (String)eGet(ParserPackage.Literals.LABELED_STATEMENT__HIGHER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHigher(String newHigher)
	{
		eSet(ParserPackage.Literals.LABELED_STATEMENT__HIGHER, newHigher);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpr()
	{
		return (Expression)eGet(ParserPackage.Literals.LABELED_STATEMENT__EXPR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpr(Expression newExpr)
	{
		eSet(ParserPackage.Literals.LABELED_STATEMENT__EXPR, newExpr);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMydefault()
	{
		return (Boolean)eGet(ParserPackage.Literals.LABELED_STATEMENT__MYDEFAULT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMydefault(boolean newMydefault)
	{
		eSet(ParserPackage.Literals.LABELED_STATEMENT__MYDEFAULT, newMydefault);
	}

} //LabeledStatementImpl
