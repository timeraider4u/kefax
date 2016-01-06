/**
 */
package at.jku.weiner.c.preprocess.preprocess.impl;

import at.jku.weiner.c.preprocess.preprocess.PreprocessPackage;
import at.jku.weiner.c.preprocess.preprocess.ReplaceLine;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Replace Line</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.ReplaceLineImpl#getString <em>String</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.ReplaceLineImpl#getId <em>Id</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.ReplaceLineImpl#isConcatenate <em>Concatenate</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReplaceLineImpl extends MinimalEObjectImpl.Container implements ReplaceLine
{
	/**
	 * The default value of the '{@link #getString() <em>String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getString()
	 * @generated
	 * @ordered
	 */
	protected static final String STRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getString() <em>String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getString()
	 * @generated
	 * @ordered
	 */
	protected String string = STRING_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #isConcatenate() <em>Concatenate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConcatenate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONCATENATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isConcatenate() <em>Concatenate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConcatenate()
	 * @generated
	 * @ordered
	 */
	protected boolean concatenate = CONCATENATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReplaceLineImpl()
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
		return PreprocessPackage.Literals.REPLACE_LINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getString()
	{
		return string;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setString(String newString)
	{
		String oldString = string;
		string = newString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PreprocessPackage.REPLACE_LINE__STRING, oldString, string));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId)
	{
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PreprocessPackage.REPLACE_LINE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConcatenate()
	{
		return concatenate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcatenate(boolean newConcatenate)
	{
		boolean oldConcatenate = concatenate;
		concatenate = newConcatenate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PreprocessPackage.REPLACE_LINE__CONCATENATE, oldConcatenate, concatenate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case PreprocessPackage.REPLACE_LINE__STRING:
				return getString();
			case PreprocessPackage.REPLACE_LINE__ID:
				return getId();
			case PreprocessPackage.REPLACE_LINE__CONCATENATE:
				return isConcatenate();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case PreprocessPackage.REPLACE_LINE__STRING:
				setString((String)newValue);
				return;
			case PreprocessPackage.REPLACE_LINE__ID:
				setId((String)newValue);
				return;
			case PreprocessPackage.REPLACE_LINE__CONCATENATE:
				setConcatenate((Boolean)newValue);
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
		switch (featureID)
		{
			case PreprocessPackage.REPLACE_LINE__STRING:
				setString(STRING_EDEFAULT);
				return;
			case PreprocessPackage.REPLACE_LINE__ID:
				setId(ID_EDEFAULT);
				return;
			case PreprocessPackage.REPLACE_LINE__CONCATENATE:
				setConcatenate(CONCATENATE_EDEFAULT);
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
		switch (featureID)
		{
			case PreprocessPackage.REPLACE_LINE__STRING:
				return STRING_EDEFAULT == null ? string != null : !STRING_EDEFAULT.equals(string);
			case PreprocessPackage.REPLACE_LINE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case PreprocessPackage.REPLACE_LINE__CONCATENATE:
				return concatenate != CONCATENATE_EDEFAULT;
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
		result.append(" (string: ");
		result.append(string);
		result.append(", id: ");
		result.append(id);
		result.append(", concatenate: ");
		result.append(concatenate);
		result.append(')');
		return result.toString();
	}

} //ReplaceLineImpl
