/**
 */
package at.jku.weiner.c.preprocess.preprocess.impl;

import at.jku.weiner.c.preprocess.preprocess.PragmaDirective;
import at.jku.weiner.c.preprocess.preprocess.PreprocessPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pragma Directive</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.PragmaDirectiveImpl#getPragma <em>Pragma</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PragmaDirectiveImpl extends MinimalEObjectImpl.Container implements PragmaDirective
{
	/**
	 * The default value of the '{@link #getPragma() <em>Pragma</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPragma()
	 * @generated
	 * @ordered
	 */
	protected static final String PRAGMA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPragma() <em>Pragma</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPragma()
	 * @generated
	 * @ordered
	 */
	protected String pragma = PRAGMA_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PragmaDirectiveImpl()
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
		return PreprocessPackage.Literals.PRAGMA_DIRECTIVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPragma()
	{
		return pragma;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPragma(String newPragma)
	{
		String oldPragma = pragma;
		pragma = newPragma;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PreprocessPackage.PRAGMA_DIRECTIVE__PRAGMA, oldPragma, pragma));
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
			case PreprocessPackage.PRAGMA_DIRECTIVE__PRAGMA:
				return getPragma();
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
			case PreprocessPackage.PRAGMA_DIRECTIVE__PRAGMA:
				setPragma((String)newValue);
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
			case PreprocessPackage.PRAGMA_DIRECTIVE__PRAGMA:
				setPragma(PRAGMA_EDEFAULT);
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
			case PreprocessPackage.PRAGMA_DIRECTIVE__PRAGMA:
				return PRAGMA_EDEFAULT == null ? pragma != null : !PRAGMA_EDEFAULT.equals(pragma);
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
		result.append(" (pragma: ");
		result.append(pragma);
		result.append(')');
		return result.toString();
	}

} //PragmaDirectiveImpl
