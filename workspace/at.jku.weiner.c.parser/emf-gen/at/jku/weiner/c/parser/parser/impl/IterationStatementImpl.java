/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.IterationStatement;
import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.Statement;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iteration Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.IterationStatementImpl#getWhile <em>While</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.IterationStatementImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.IterationStatementImpl#getStatement <em>Statement</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.IterationStatementImpl#getDo <em>Do</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.IterationStatementImpl#getSemi <em>Semi</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.IterationStatementImpl#getFor <em>For</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.IterationStatementImpl#getInitExpr <em>Init Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.IterationStatementImpl#getIncExpr <em>Inc Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.IterationStatementImpl#getInitDecl <em>Init Decl</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IterationStatementImpl extends StatementImpl implements IterationStatement
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IterationStatementImpl()
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
		return ParserPackage.Literals.ITERATION_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWhile()
	{
		return (String)eGet(ParserPackage.Literals.ITERATION_STATEMENT__WHILE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhile(String newWhile)
	{
		eSet(ParserPackage.Literals.ITERATION_STATEMENT__WHILE, newWhile);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpr()
	{
		return (Expression)eGet(ParserPackage.Literals.ITERATION_STATEMENT__EXPR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpr(Expression newExpr)
	{
		eSet(ParserPackage.Literals.ITERATION_STATEMENT__EXPR, newExpr);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statement getStatement()
	{
		return (Statement)eGet(ParserPackage.Literals.ITERATION_STATEMENT__STATEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatement(Statement newStatement)
	{
		eSet(ParserPackage.Literals.ITERATION_STATEMENT__STATEMENT, newStatement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDo()
	{
		return (String)eGet(ParserPackage.Literals.ITERATION_STATEMENT__DO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDo(String newDo)
	{
		eSet(ParserPackage.Literals.ITERATION_STATEMENT__DO, newDo);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSemi()
	{
		return (String)eGet(ParserPackage.Literals.ITERATION_STATEMENT__SEMI, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemi(String newSemi)
	{
		eSet(ParserPackage.Literals.ITERATION_STATEMENT__SEMI, newSemi);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFor()
	{
		return (String)eGet(ParserPackage.Literals.ITERATION_STATEMENT__FOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFor(String newFor)
	{
		eSet(ParserPackage.Literals.ITERATION_STATEMENT__FOR, newFor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getInitExpr()
	{
		return (Expression)eGet(ParserPackage.Literals.ITERATION_STATEMENT__INIT_EXPR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitExpr(Expression newInitExpr)
	{
		eSet(ParserPackage.Literals.ITERATION_STATEMENT__INIT_EXPR, newInitExpr);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getIncExpr()
	{
		return (Expression)eGet(ParserPackage.Literals.ITERATION_STATEMENT__INC_EXPR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncExpr(Expression newIncExpr)
	{
		eSet(ParserPackage.Literals.ITERATION_STATEMENT__INC_EXPR, newIncExpr);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Declaration getInitDecl()
	{
		return (Declaration)eGet(ParserPackage.Literals.ITERATION_STATEMENT__INIT_DECL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitDecl(Declaration newInitDecl)
	{
		eSet(ParserPackage.Literals.ITERATION_STATEMENT__INIT_DECL, newInitDecl);
	}

} //IterationStatementImpl
