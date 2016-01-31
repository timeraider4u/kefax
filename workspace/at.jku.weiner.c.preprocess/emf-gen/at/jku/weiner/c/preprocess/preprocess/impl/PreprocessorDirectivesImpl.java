/**
 */
package at.jku.weiner.c.preprocess.preprocess.impl;

import at.jku.weiner.c.preprocess.preprocess.PreprocessPackage;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Preprocessor Directives</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.PreprocessorDirectivesImpl#getDirective <em>Directive</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PreprocessorDirectivesImpl extends SourceCodeLineImpl implements PreprocessorDirectives
{
	/**
	 * The cached value of the '{@link #getDirective() <em>Directive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirective()
	 * @generated
	 * @ordered
	 */
	protected EObject directive;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreprocessorDirectivesImpl()
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
		return PreprocessPackage.Literals.PREPROCESSOR_DIRECTIVES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getDirective()
	{
		return directive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDirective(EObject newDirective, NotificationChain msgs)
	{
		EObject oldDirective = directive;
		directive = newDirective;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PreprocessPackage.PREPROCESSOR_DIRECTIVES__DIRECTIVE, oldDirective, newDirective);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirective(EObject newDirective)
	{
		if (newDirective != directive) {
			NotificationChain msgs = null;
			if (directive != null)
				msgs = ((InternalEObject)directive).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PreprocessPackage.PREPROCESSOR_DIRECTIVES__DIRECTIVE, null, msgs);
			if (newDirective != null)
				msgs = ((InternalEObject)newDirective).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PreprocessPackage.PREPROCESSOR_DIRECTIVES__DIRECTIVE, null, msgs);
			msgs = basicSetDirective(newDirective, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PreprocessPackage.PREPROCESSOR_DIRECTIVES__DIRECTIVE, newDirective, newDirective));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID) {
			case PreprocessPackage.PREPROCESSOR_DIRECTIVES__DIRECTIVE:
				return basicSetDirective(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case PreprocessPackage.PREPROCESSOR_DIRECTIVES__DIRECTIVE:
				return getDirective();
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
		switch (featureID) {
			case PreprocessPackage.PREPROCESSOR_DIRECTIVES__DIRECTIVE:
				setDirective((EObject)newValue);
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
			case PreprocessPackage.PREPROCESSOR_DIRECTIVES__DIRECTIVE:
				setDirective((EObject)null);
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
			case PreprocessPackage.PREPROCESSOR_DIRECTIVES__DIRECTIVE:
				return directive != null;
		}
		return super.eIsSet(featureID);
	}

} //PreprocessorDirectivesImpl
