/**
 * Copyright (c) 2010 Mia-Software.
 *    All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *   
 *   Contributors:
 *   
 *   	   Nicolas Guyomar (Mia-Software) - initial API and implementation
 */
package org.eclipse.modisco.cdt.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.modisco.cdt.CdtPackage;
import org.eclipse.modisco.cdt.PreprocessorConditional;
import org.eclipse.modisco.cdt.Scope;
import org.eclipse.modisco.cdt.Statement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Preprocessor Conditional</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.modisco.cdt.impl.PreprocessorConditionalImpl#getStatements <em>Statements</em>}</li>
 *   <li>{@link org.eclipse.modisco.cdt.impl.PreprocessorConditionalImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.modisco.cdt.impl.PreprocessorConditionalImpl#isBranchTaken <em>Branch Taken</em>}</li>
 *   <li>{@link org.eclipse.modisco.cdt.impl.PreprocessorConditionalImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PreprocessorConditionalImpl extends EObjectImpl implements PreprocessorConditional {
	/**
	 * The cached value of the '{@link #getStatements() <em>Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> statements;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected Scope parent;

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
	 * The default value of the '{@link #getCondition() <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected static final String CONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected String condition = CONDITION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreprocessorConditionalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CdtPackage.Literals.PREPROCESSOR_CONDITIONAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Statement> getStatements() {
		if (statements == null) {
			statements = new EObjectContainmentEList<Statement>(Statement.class, this, CdtPackage.PREPROCESSOR_CONDITIONAL__STATEMENTS);
		}
		return statements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scope getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (Scope)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CdtPackage.PREPROCESSOR_CONDITIONAL__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scope basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(Scope newParent) {
		Scope oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CdtPackage.PREPROCESSOR_CONDITIONAL__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBranchTaken() {
		return branchTaken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBranchTaken(boolean newBranchTaken) {
		boolean oldBranchTaken = branchTaken;
		branchTaken = newBranchTaken;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CdtPackage.PREPROCESSOR_CONDITIONAL__BRANCH_TAKEN, oldBranchTaken, branchTaken));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(String newCondition) {
		String oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CdtPackage.PREPROCESSOR_CONDITIONAL__CONDITION, oldCondition, condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CdtPackage.PREPROCESSOR_CONDITIONAL__STATEMENTS:
				return ((InternalEList<?>)getStatements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CdtPackage.PREPROCESSOR_CONDITIONAL__STATEMENTS:
				return getStatements();
			case CdtPackage.PREPROCESSOR_CONDITIONAL__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case CdtPackage.PREPROCESSOR_CONDITIONAL__BRANCH_TAKEN:
				return isBranchTaken();
			case CdtPackage.PREPROCESSOR_CONDITIONAL__CONDITION:
				return getCondition();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CdtPackage.PREPROCESSOR_CONDITIONAL__STATEMENTS:
				getStatements().clear();
				getStatements().addAll((Collection<? extends Statement>)newValue);
				return;
			case CdtPackage.PREPROCESSOR_CONDITIONAL__PARENT:
				setParent((Scope)newValue);
				return;
			case CdtPackage.PREPROCESSOR_CONDITIONAL__BRANCH_TAKEN:
				setBranchTaken((Boolean)newValue);
				return;
			case CdtPackage.PREPROCESSOR_CONDITIONAL__CONDITION:
				setCondition((String)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case CdtPackage.PREPROCESSOR_CONDITIONAL__STATEMENTS:
				getStatements().clear();
				return;
			case CdtPackage.PREPROCESSOR_CONDITIONAL__PARENT:
				setParent((Scope)null);
				return;
			case CdtPackage.PREPROCESSOR_CONDITIONAL__BRANCH_TAKEN:
				setBranchTaken(BRANCH_TAKEN_EDEFAULT);
				return;
			case CdtPackage.PREPROCESSOR_CONDITIONAL__CONDITION:
				setCondition(CONDITION_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CdtPackage.PREPROCESSOR_CONDITIONAL__STATEMENTS:
				return statements != null && !statements.isEmpty();
			case CdtPackage.PREPROCESSOR_CONDITIONAL__PARENT:
				return parent != null;
			case CdtPackage.PREPROCESSOR_CONDITIONAL__BRANCH_TAKEN:
				return branchTaken != BRANCH_TAKEN_EDEFAULT;
			case CdtPackage.PREPROCESSOR_CONDITIONAL__CONDITION:
				return CONDITION_EDEFAULT == null ? condition != null : !CONDITION_EDEFAULT.equals(condition);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Scope.class) {
			switch (derivedFeatureID) {
				case CdtPackage.PREPROCESSOR_CONDITIONAL__STATEMENTS: return CdtPackage.SCOPE__STATEMENTS;
				case CdtPackage.PREPROCESSOR_CONDITIONAL__PARENT: return CdtPackage.SCOPE__PARENT;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Scope.class) {
			switch (baseFeatureID) {
				case CdtPackage.SCOPE__STATEMENTS: return CdtPackage.PREPROCESSOR_CONDITIONAL__STATEMENTS;
				case CdtPackage.SCOPE__PARENT: return CdtPackage.PREPROCESSOR_CONDITIONAL__PARENT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (branchTaken: "); //$NON-NLS-1$
		result.append(branchTaken);
		result.append(", condition: "); //$NON-NLS-1$
		result.append(condition);
		result.append(')');
		return result.toString();
	}

} //PreprocessorConditionalImpl
