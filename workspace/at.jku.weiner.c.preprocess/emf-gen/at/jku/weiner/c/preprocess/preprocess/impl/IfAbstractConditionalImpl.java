/**
 */
package at.jku.weiner.c.preprocess.preprocess.impl;

import at.jku.weiner.c.preprocess.preprocess.IfAbstractConditional;
import at.jku.weiner.c.preprocess.preprocess.PreprocessPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Abstract Conditional</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.IfAbstractConditionalImpl#isBranchTaken <em>Branch Taken</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfAbstractConditionalImpl extends MinimalEObjectImpl.Container implements IfAbstractConditional
{
	/**
	 * The default value of the '{@link #isBranchTaken() <em>Branch Taken</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBranchTaken()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BRANCH_TAKEN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBranchTaken() <em>Branch Taken</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBranchTaken()
	 * @generated
	 * @ordered
	 */
	protected boolean branchTaken = BRANCH_TAKEN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfAbstractConditionalImpl()
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
		return PreprocessPackage.Literals.IF_ABSTRACT_CONDITIONAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBranchTaken()
	{
		return branchTaken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBranchTaken(boolean newBranchTaken)
	{
		boolean oldBranchTaken = branchTaken;
		branchTaken = newBranchTaken;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PreprocessPackage.IF_ABSTRACT_CONDITIONAL__BRANCH_TAKEN, oldBranchTaken, branchTaken));
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
			case PreprocessPackage.IF_ABSTRACT_CONDITIONAL__BRANCH_TAKEN:
				return isBranchTaken();
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
			case PreprocessPackage.IF_ABSTRACT_CONDITIONAL__BRANCH_TAKEN:
				setBranchTaken((Boolean)newValue);
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
			case PreprocessPackage.IF_ABSTRACT_CONDITIONAL__BRANCH_TAKEN:
				setBranchTaken(BRANCH_TAKEN_EDEFAULT);
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
			case PreprocessPackage.IF_ABSTRACT_CONDITIONAL__BRANCH_TAKEN:
				return branchTaken != BRANCH_TAKEN_EDEFAULT;
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
		result.append(" (branchTaken: ");
		result.append(branchTaken);
		result.append(')');
		return result.toString();
	}

} //IfAbstractConditionalImpl
