/**
 */
package at.jku.weiner.c.preprocess.preprocess.impl;

import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.PreprocessPackage;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Identifier List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.IdentifierListImpl#getIdent <em>Ident</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.IdentifierListImpl#isVariadic <em>Variadic</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.IdentifierListImpl#getVarID <em>Var ID</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IdentifierListImpl extends PersistentEObjectImpl implements IdentifierList
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdentifierListImpl()
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
		return PreprocessPackage.Literals.IDENTIFIER_LIST;
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
	public EList<String> getIdent()
	{
		return (EList<String>)eGet(PreprocessPackage.Literals.IDENTIFIER_LIST__IDENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVariadic()
	{
		return (Boolean)eGet(PreprocessPackage.Literals.IDENTIFIER_LIST__VARIADIC, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariadic(boolean newVariadic)
	{
		eSet(PreprocessPackage.Literals.IDENTIFIER_LIST__VARIADIC, newVariadic);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVarID()
	{
		return (String)eGet(PreprocessPackage.Literals.IDENTIFIER_LIST__VAR_ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVarID(String newVarID)
	{
		eSet(PreprocessPackage.Literals.IDENTIFIER_LIST__VAR_ID, newVarID);
	}

} //IdentifierListImpl
