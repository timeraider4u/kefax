/**
 */
package at.jku.weiner.c.preprocess.preprocess.impl;

import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.IfAbstractConditional;
import at.jku.weiner.c.preprocess.preprocess.PreprocessPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

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
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.IfAbstractConditionalImpl#getGroup <em>Group</em>}</li>
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
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected GroupOpt group;

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
	public GroupOpt getGroup()
	{
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGroup(GroupOpt newGroup, NotificationChain msgs)
	{
		GroupOpt oldGroup = group;
		group = newGroup;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PreprocessPackage.IF_ABSTRACT_CONDITIONAL__GROUP, oldGroup, newGroup);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroup(GroupOpt newGroup)
	{
		if (newGroup != group)
		{
			NotificationChain msgs = null;
			if (group != null)
				msgs = ((InternalEObject)group).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PreprocessPackage.IF_ABSTRACT_CONDITIONAL__GROUP, null, msgs);
			if (newGroup != null)
				msgs = ((InternalEObject)newGroup).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PreprocessPackage.IF_ABSTRACT_CONDITIONAL__GROUP, null, msgs);
			msgs = basicSetGroup(newGroup, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PreprocessPackage.IF_ABSTRACT_CONDITIONAL__GROUP, newGroup, newGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case PreprocessPackage.IF_ABSTRACT_CONDITIONAL__GROUP:
				return basicSetGroup(null, msgs);
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
		switch (featureID)
		{
			case PreprocessPackage.IF_ABSTRACT_CONDITIONAL__BRANCH_TAKEN:
				return isBranchTaken();
			case PreprocessPackage.IF_ABSTRACT_CONDITIONAL__GROUP:
				return getGroup();
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
			case PreprocessPackage.IF_ABSTRACT_CONDITIONAL__BRANCH_TAKEN:
				setBranchTaken((Boolean)newValue);
				return;
			case PreprocessPackage.IF_ABSTRACT_CONDITIONAL__GROUP:
				setGroup((GroupOpt)newValue);
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
			case PreprocessPackage.IF_ABSTRACT_CONDITIONAL__BRANCH_TAKEN:
				setBranchTaken(BRANCH_TAKEN_EDEFAULT);
				return;
			case PreprocessPackage.IF_ABSTRACT_CONDITIONAL__GROUP:
				setGroup((GroupOpt)null);
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
			case PreprocessPackage.IF_ABSTRACT_CONDITIONAL__BRANCH_TAKEN:
				return branchTaken != BRANCH_TAKEN_EDEFAULT;
			case PreprocessPackage.IF_ABSTRACT_CONDITIONAL__GROUP:
				return group != null;
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
