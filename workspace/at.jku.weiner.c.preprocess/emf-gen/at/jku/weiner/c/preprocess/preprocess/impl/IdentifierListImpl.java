/**
 */
package at.jku.weiner.c.preprocess.preprocess.impl;

import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.PreprocessPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Identifier List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.IdentifierListImpl#getId <em>Id</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.IdentifierListImpl#isVariadic <em>Variadic</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.IdentifierListImpl#getVarID <em>Var ID</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IdentifierListImpl extends MinimalEObjectImpl.Container implements IdentifierList
{
	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected EList<String> id;

	/**
	 * The default value of the '{@link #isVariadic() <em>Variadic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVariadic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VARIADIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isVariadic() <em>Variadic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVariadic()
	 * @generated
	 * @ordered
	 */
	protected boolean variadic = VARIADIC_EDEFAULT;

	/**
	 * The default value of the '{@link #getVarID() <em>Var ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarID()
	 * @generated
	 * @ordered
	 */
	protected static final String VAR_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVarID() <em>Var ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarID()
	 * @generated
	 * @ordered
	 */
	protected String varID = VAR_ID_EDEFAULT;

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
	public EList<String> getId()
	{
		if (id == null) {
			id = new EDataTypeEList<String>(String.class, this, PreprocessPackage.IDENTIFIER_LIST__ID);
		}
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVariadic()
	{
		return variadic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariadic(boolean newVariadic)
	{
		boolean oldVariadic = variadic;
		variadic = newVariadic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PreprocessPackage.IDENTIFIER_LIST__VARIADIC, oldVariadic, variadic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVarID()
	{
		return varID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVarID(String newVarID)
	{
		String oldVarID = varID;
		varID = newVarID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PreprocessPackage.IDENTIFIER_LIST__VAR_ID, oldVarID, varID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID) {
			case PreprocessPackage.IDENTIFIER_LIST__ID:
				return getId();
			case PreprocessPackage.IDENTIFIER_LIST__VARIADIC:
				return isVariadic();
			case PreprocessPackage.IDENTIFIER_LIST__VAR_ID:
				return getVarID();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID) {
			case PreprocessPackage.IDENTIFIER_LIST__ID:
				getId().clear();
				getId().addAll((Collection<? extends String>)newValue);
				return;
			case PreprocessPackage.IDENTIFIER_LIST__VARIADIC:
				setVariadic((Boolean)newValue);
				return;
			case PreprocessPackage.IDENTIFIER_LIST__VAR_ID:
				setVarID((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID) {
			case PreprocessPackage.IDENTIFIER_LIST__ID:
				getId().clear();
				return;
			case PreprocessPackage.IDENTIFIER_LIST__VARIADIC:
				setVariadic(VARIADIC_EDEFAULT);
				return;
			case PreprocessPackage.IDENTIFIER_LIST__VAR_ID:
				setVarID(VAR_ID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID) {
			case PreprocessPackage.IDENTIFIER_LIST__ID:
				return id != null && !id.isEmpty();
			case PreprocessPackage.IDENTIFIER_LIST__VARIADIC:
				return variadic != VARIADIC_EDEFAULT;
			case PreprocessPackage.IDENTIFIER_LIST__VAR_ID:
				return VAR_ID_EDEFAULT == null ? varID != null : !VAR_ID_EDEFAULT.equals(varID);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", variadic: ");
		result.append(variadic);
		result.append(", varID: ");
		result.append(varID);
		result.append(')');
		return result.toString();
	}

} //IdentifierListImpl
