/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.ParserPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiplicative Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.MultiplicativeExpressionImpl#getOp <em>Op</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MultiplicativeExpressionImpl extends ExpressionImpl implements MultiplicativeExpression
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiplicativeExpressionImpl()
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
		return ParserPackage.Literals.MULTIPLICATIVE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOp()
	{
		return (String)eGet(ParserPackage.Literals.MULTIPLICATIVE_EXPRESSION__OP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOp(String newOp)
	{
		eSet(ParserPackage.Literals.MULTIPLICATIVE_EXPRESSION__OP, newOp);
	}

} //MultiplicativeExpressionImpl
