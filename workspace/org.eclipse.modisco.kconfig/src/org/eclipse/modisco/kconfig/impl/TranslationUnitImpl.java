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
package org.eclipse.modisco.kconfig.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.modisco.kconfig.Config;
import org.eclipse.modisco.kconfig.KconfigPackage;
import org.eclipse.modisco.kconfig.Model;
import org.eclipse.modisco.kconfig.TranslationUnit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Translation Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.TranslationUnitImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.TranslationUnitImpl#getUnitOwner <em>Unit Owner</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.TranslationUnitImpl#getFullPath <em>Full Path</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.TranslationUnitImpl#getConfigs <em>Configs</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.TranslationUnitImpl#getSources <em>Sources</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TranslationUnitImpl extends MinimalEObjectImpl.Container implements TranslationUnit {
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
	 * The cached value of the '{@link #getConfigs() <em>Configs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigs()
	 * @generated
	 * @ordered
	 */
	protected EList<Config> configs;

	/**
	 * The cached value of the '{@link #getSources() <em>Sources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSources()
	 * @generated
	 * @ordered
	 */
	protected EList<TranslationUnit> sources;

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
		return KconfigPackage.Literals.TRANSLATION_UNIT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, KconfigPackage.TRANSLATION_UNIT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getUnitOwner() {
		if (eContainerFeatureID() != KconfigPackage.TRANSLATION_UNIT__UNIT_OWNER) return null;
		return (Model)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitOwner(Model newUnitOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newUnitOwner, KconfigPackage.TRANSLATION_UNIT__UNIT_OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitOwner(Model newUnitOwner) {
		if (newUnitOwner != eInternalContainer() || (eContainerFeatureID() != KconfigPackage.TRANSLATION_UNIT__UNIT_OWNER && newUnitOwner != null)) {
			if (EcoreUtil.isAncestor(this, newUnitOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newUnitOwner != null)
				msgs = ((InternalEObject)newUnitOwner).eInverseAdd(this, KconfigPackage.MODEL__UNITS, Model.class, msgs);
			msgs = basicSetUnitOwner(newUnitOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KconfigPackage.TRANSLATION_UNIT__UNIT_OWNER, newUnitOwner, newUnitOwner));
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
			eNotify(new ENotificationImpl(this, Notification.SET, KconfigPackage.TRANSLATION_UNIT__FULL_PATH, oldFullPath, fullPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Config> getConfigs() {
		if (configs == null) {
			configs = new EObjectWithInverseResolvingEList<Config>(Config.class, this, KconfigPackage.TRANSLATION_UNIT__CONFIGS, KconfigPackage.CONFIG__DEFINED_IN);
		}
		return configs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TranslationUnit> getSources() {
		if (sources == null) {
			sources = new EObjectResolvingEList<TranslationUnit>(TranslationUnit.class, this, KconfigPackage.TRANSLATION_UNIT__SOURCES);
		}
		return sources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KconfigPackage.TRANSLATION_UNIT__UNIT_OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetUnitOwner((Model)otherEnd, msgs);
			case KconfigPackage.TRANSLATION_UNIT__CONFIGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConfigs()).basicAdd(otherEnd, msgs);
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
			case KconfigPackage.TRANSLATION_UNIT__UNIT_OWNER:
				return basicSetUnitOwner(null, msgs);
			case KconfigPackage.TRANSLATION_UNIT__CONFIGS:
				return ((InternalEList<?>)getConfigs()).basicRemove(otherEnd, msgs);
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
			case KconfigPackage.TRANSLATION_UNIT__UNIT_OWNER:
				return eInternalContainer().eInverseRemove(this, KconfigPackage.MODEL__UNITS, Model.class, msgs);
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
			case KconfigPackage.TRANSLATION_UNIT__NAME:
				return getName();
			case KconfigPackage.TRANSLATION_UNIT__UNIT_OWNER:
				return getUnitOwner();
			case KconfigPackage.TRANSLATION_UNIT__FULL_PATH:
				return getFullPath();
			case KconfigPackage.TRANSLATION_UNIT__CONFIGS:
				return getConfigs();
			case KconfigPackage.TRANSLATION_UNIT__SOURCES:
				return getSources();
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
			case KconfigPackage.TRANSLATION_UNIT__NAME:
				setName((String)newValue);
				return;
			case KconfigPackage.TRANSLATION_UNIT__UNIT_OWNER:
				setUnitOwner((Model)newValue);
				return;
			case KconfigPackage.TRANSLATION_UNIT__FULL_PATH:
				setFullPath((String)newValue);
				return;
			case KconfigPackage.TRANSLATION_UNIT__CONFIGS:
				getConfigs().clear();
				getConfigs().addAll((Collection<? extends Config>)newValue);
				return;
			case KconfigPackage.TRANSLATION_UNIT__SOURCES:
				getSources().clear();
				getSources().addAll((Collection<? extends TranslationUnit>)newValue);
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
			case KconfigPackage.TRANSLATION_UNIT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case KconfigPackage.TRANSLATION_UNIT__UNIT_OWNER:
				setUnitOwner((Model)null);
				return;
			case KconfigPackage.TRANSLATION_UNIT__FULL_PATH:
				setFullPath(FULL_PATH_EDEFAULT);
				return;
			case KconfigPackage.TRANSLATION_UNIT__CONFIGS:
				getConfigs().clear();
				return;
			case KconfigPackage.TRANSLATION_UNIT__SOURCES:
				getSources().clear();
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
			case KconfigPackage.TRANSLATION_UNIT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case KconfigPackage.TRANSLATION_UNIT__UNIT_OWNER:
				return getUnitOwner() != null;
			case KconfigPackage.TRANSLATION_UNIT__FULL_PATH:
				return FULL_PATH_EDEFAULT == null ? fullPath != null : !FULL_PATH_EDEFAULT.equals(fullPath);
			case KconfigPackage.TRANSLATION_UNIT__CONFIGS:
				return configs != null && !configs.isEmpty();
			case KconfigPackage.TRANSLATION_UNIT__SOURCES:
				return sources != null && !sources.isEmpty();
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
