/**
 */
package at.jku.weiner.c.common.common.impl;

import at.jku.weiner.c.common.common.ArgumentExpressionList;
import at.jku.weiner.c.common.common.CommonPackage;
import at.jku.weiner.c.common.common.Expression;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Argument Expression List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.common.common.impl.ArgumentExpressionListImpl#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArgumentExpressionListImpl extends PersistentEObjectImpl implements ArgumentExpressionList
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArgumentExpressionListImpl()
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
		return CommonPackage.Literals.ARGUMENT_EXPRESSION_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount()
	{
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Expression> getExpr()
	{
		return (EList<Expression>)eGet(CommonPackage.Literals.ARGUMENT_EXPRESSION_LIST__EXPR, true);
	}

} //ArgumentExpressionListImpl
