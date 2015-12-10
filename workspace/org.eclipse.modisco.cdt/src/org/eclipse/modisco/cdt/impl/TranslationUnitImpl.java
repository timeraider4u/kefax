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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.modisco.cdt.CdtPackage;
import org.eclipse.modisco.cdt.Model;
import org.eclipse.modisco.cdt.Scope;
import org.eclipse.modisco.cdt.Statement;
import org.eclipse.modisco.cdt.TranslationUnit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Translation Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.modisco.cdt.impl.TranslationUnitImpl#getStatements <em>Statements</em>}</li>
 *   <li>{@link org.eclipse.modisco.cdt.impl.TranslationUnitImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.modisco.cdt.impl.TranslationUnitImpl#getUnitOwner <em>Unit Owner</em>}</li>
 *   <li>{@link org.eclipse.modisco.cdt.impl.TranslationUnitImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.modisco.cdt.impl.TranslationUnitImpl#getFullPath <em>Full Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TranslationUnitImpl extends EObjectImpl implements TranslationUnit {
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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFullPath() <em>Full Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFullPath()
	 * @generated
	 * @ordered
	 */
	protected static final String FULL_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFullPath() <em>Full Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFullPath()
	 * @generated
	 * @ordered
	 */
	protected String fullPath = FULL_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TranslationUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CdtPackage.Literals.TRANSLATION_UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Statement> getStatements() {
		if (statements == null) {
			statements = new EObjectContainmentEList<Statement>(Statement.class, this, CdtPackage.TRANSLATION_UNIT__STATEMENTS);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CdtPackage.TRANSLATION_UNIT__PARENT, oldParent, parent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CdtPackage.TRANSLATION_UNIT__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getUnitOwner() {
		if (eContainerFeatureID() != CdtPackage.TRANSLATION_UNIT__UNIT_OWNER) return null;
		return (Model)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitOwner(Model newUnitOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newUnitOwner, CdtPackage.TRANSLATION_UNIT__UNIT_OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitOwner(Model newUnitOwner) {
		if (newUnitOwner != eInternalContainer() || (eContainerFeatureID() != CdtPackage.TRANSLATION_UNIT__UNIT_OWNER && newUnitOwner != null)) {
			if (EcoreUtil.isAncestor(this, newUnitOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newUnitOwner != null)
				msgs = ((InternalEObject)newUnitOwner).eInverseAdd(this, CdtPackage.MODEL__UNITS, Model.class, msgs);
			msgs = basicSetUnitOwner(newUnitOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CdtPackage.TRANSLATION_UNIT__UNIT_OWNER, newUnitOwner, newUnitOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CdtPackage.TRANSLATION_UNIT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFullPath() {
		return fullPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFullPath(String newFullPath) {
		String oldFullPath = fullPath;
		fullPath = newFullPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CdtPackage.TRANSLATION_UNIT__FULL_PATH, oldFullPath, fullPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CdtPackage.TRANSLATION_UNIT__UNIT_OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetUnitOwner((Model)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CdtPackage.TRANSLATION_UNIT__STATEMENTS:
				return ((InternalEList<?>)getStatements()).basicRemove(otherEnd, msgs);
			case CdtPackage.TRANSLATION_UNIT__UNIT_OWNER:
				return basicSetUnitOwner(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case CdtPackage.TRANSLATION_UNIT__UNIT_OWNER:
				return eInternalContainer().eInverseRemove(this, CdtPackage.MODEL__UNITS, Model.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CdtPackage.TRANSLATION_UNIT__STATEMENTS:
				return getStatements();
			case CdtPackage.TRANSLATION_UNIT__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case CdtPackage.TRANSLATION_UNIT__UNIT_OWNER:
				return getUnitOwner();
			case CdtPackage.TRANSLATION_UNIT__NAME:
				return getName();
			case CdtPackage.TRANSLATION_UNIT__FULL_PATH:
				return getFullPath();
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
			case CdtPackage.TRANSLATION_UNIT__STATEMENTS:
				getStatements().clear();
				getStatements().addAll((Collection<? extends Statement>)newValue);
				return;
			case CdtPackage.TRANSLATION_UNIT__PARENT:
				setParent((Scope)newValue);
				return;
			case CdtPackage.TRANSLATION_UNIT__UNIT_OWNER:
				setUnitOwner((Model)newValue);
				return;
			case CdtPackage.TRANSLATION_UNIT__NAME:
				setName((String)newValue);
				return;
			case CdtPackage.TRANSLATION_UNIT__FULL_PATH:
				setFullPath((String)newValue);
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
			case CdtPackage.TRANSLATION_UNIT__STATEMENTS:
				getStatements().clear();
				return;
			case CdtPackage.TRANSLATION_UNIT__PARENT:
				setParent((Scope)null);
				return;
			case CdtPackage.TRANSLATION_UNIT__UNIT_OWNER:
				setUnitOwner((Model)null);
				return;
			case CdtPackage.TRANSLATION_UNIT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CdtPackage.TRANSLATION_UNIT__FULL_PATH:
				setFullPath(FULL_PATH_EDEFAULT);
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
			case CdtPackage.TRANSLATION_UNIT__STATEMENTS:
				return statements != null && !statements.isEmpty();
			case CdtPackage.TRANSLATION_UNIT__PARENT:
				return parent != null;
			case CdtPackage.TRANSLATION_UNIT__UNIT_OWNER:
				return getUnitOwner() != null;
			case CdtPackage.TRANSLATION_UNIT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CdtPackage.TRANSLATION_UNIT__FULL_PATH:
				return FULL_PATH_EDEFAULT == null ? fullPath != null : !FULL_PATH_EDEFAULT.equals(fullPath);
		}
		return super.eIsSet(featureID);
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
		result.append(" (name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", fullPath: "); //$NON-NLS-1$
		result.append(fullPath);
		result.append(')');
		return result.toString();
	}

} //TranslationUnitImpl
