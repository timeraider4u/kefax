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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.modisco.kconfig.Config;
import org.eclipse.modisco.kconfig.ConfigExpr;
import org.eclipse.modisco.kconfig.KconfigPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Config Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.ConfigExprImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.ConfigExprImpl#isNegated <em>Negated</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.ConfigExprImpl#getRefOnConfig <em>Ref On Config</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigExprImpl extends MinimalEObjectImpl.Container implements ConfigExpr {
	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected Config owner;

	/**
	 * The default value of the '{@link #isNegated() <em>Negated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNegated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NEGATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNegated() <em>Negated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNegated()
	 * @generated
	 * @ordered
	 */
	protected boolean negated = NEGATED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRefOnConfig() <em>Ref On Config</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefOnConfig()
	 * @generated
	 * @ordered
	 */
	protected Config refOnConfig;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigExprImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KconfigPackage.Literals.CONFIG_EXPR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Config getOwner() {
		if (owner != null && owner.eIsProxy()) {
			InternalEObject oldOwner = (InternalEObject)owner;
			owner = (Config)eResolveProxy(oldOwner);
			if (owner != oldOwner) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KconfigPackage.CONFIG_EXPR__OWNER, oldOwner, owner));
			}
		}
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Config basicGetOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Config newOwner) {
		Config oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KconfigPackage.CONFIG_EXPR__OWNER, oldOwner, owner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNegated() {
		return negated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNegated(boolean newNegated) {
		boolean oldNegated = negated;
		negated = newNegated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KconfigPackage.CONFIG_EXPR__NEGATED, oldNegated, negated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Config getRefOnConfig() {
		if (refOnConfig != null && refOnConfig.eIsProxy()) {
			InternalEObject oldRefOnConfig = (InternalEObject)refOnConfig;
			refOnConfig = (Config)eResolveProxy(oldRefOnConfig);
			if (refOnConfig != oldRefOnConfig) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KconfigPackage.CONFIG_EXPR__REF_ON_CONFIG, oldRefOnConfig, refOnConfig));
			}
		}
		return refOnConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Config basicGetRefOnConfig() {
		return refOnConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefOnConfig(Config newRefOnConfig) {
		Config oldRefOnConfig = refOnConfig;
		refOnConfig = newRefOnConfig;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KconfigPackage.CONFIG_EXPR__REF_ON_CONFIG, oldRefOnConfig, refOnConfig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KconfigPackage.CONFIG_EXPR__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case KconfigPackage.CONFIG_EXPR__NEGATED:
				return isNegated();
			case KconfigPackage.CONFIG_EXPR__REF_ON_CONFIG:
				if (resolve) return getRefOnConfig();
				return basicGetRefOnConfig();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KconfigPackage.CONFIG_EXPR__OWNER:
				setOwner((Config)newValue);
				return;
			case KconfigPackage.CONFIG_EXPR__NEGATED:
				setNegated((Boolean)newValue);
				return;
			case KconfigPackage.CONFIG_EXPR__REF_ON_CONFIG:
				setRefOnConfig((Config)newValue);
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
			case KconfigPackage.CONFIG_EXPR__OWNER:
				setOwner((Config)null);
				return;
			case KconfigPackage.CONFIG_EXPR__NEGATED:
				setNegated(NEGATED_EDEFAULT);
				return;
			case KconfigPackage.CONFIG_EXPR__REF_ON_CONFIG:
				setRefOnConfig((Config)null);
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
			case KconfigPackage.CONFIG_EXPR__OWNER:
				return owner != null;
			case KconfigPackage.CONFIG_EXPR__NEGATED:
				return negated != NEGATED_EDEFAULT;
			case KconfigPackage.CONFIG_EXPR__REF_ON_CONFIG:
				return refOnConfig != null;
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
		result.append(" (negated: "); //$NON-NLS-1$
		result.append(negated);
		result.append(')');
		return result.toString();
	}

} //ConfigExprImpl
