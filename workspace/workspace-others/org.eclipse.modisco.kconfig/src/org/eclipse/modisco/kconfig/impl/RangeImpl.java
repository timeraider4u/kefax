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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.modisco.kconfig.Config;
import org.eclipse.modisco.kconfig.Expr;
import org.eclipse.modisco.kconfig.KconfigPackage;
import org.eclipse.modisco.kconfig.Range;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.RangeImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.RangeImpl#getLowerExpr <em>Lower Expr</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.RangeImpl#getIfExpr <em>If Expr</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.RangeImpl#getUpperExpr <em>Upper Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RangeImpl extends MinimalEObjectImpl.Container implements Range {
	/**
	 * The cached value of the '{@link #getLowerExpr() <em>Lower Expr</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerExpr()
	 * @generated
	 * @ordered
	 */
	protected Expr lowerExpr;

	/**
	 * The cached value of the '{@link #getIfExpr() <em>If Expr</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIfExpr()
	 * @generated
	 * @ordered
	 */
	protected Expr ifExpr;

	/**
	 * The cached value of the '{@link #getUpperExpr() <em>Upper Expr</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperExpr()
	 * @generated
	 * @ordered
	 */
	protected Expr upperExpr;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KconfigPackage.Literals.RANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Config getOwner() {
		if (eContainerFeatureID() != KconfigPackage.RANGE__OWNER) return null;
		return (Config)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Config newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, KconfigPackage.RANGE__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Config newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != KconfigPackage.RANGE__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, KconfigPackage.CONFIG__RANGES, Config.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KconfigPackage.RANGE__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expr getLowerExpr() {
		if (lowerExpr != null && lowerExpr.eIsProxy()) {
			InternalEObject oldLowerExpr = (InternalEObject)lowerExpr;
			lowerExpr = (Expr)eResolveProxy(oldLowerExpr);
			if (lowerExpr != oldLowerExpr) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KconfigPackage.RANGE__LOWER_EXPR, oldLowerExpr, lowerExpr));
			}
		}
		return lowerExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expr basicGetLowerExpr() {
		return lowerExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerExpr(Expr newLowerExpr) {
		Expr oldLowerExpr = lowerExpr;
		lowerExpr = newLowerExpr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KconfigPackage.RANGE__LOWER_EXPR, oldLowerExpr, lowerExpr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expr getIfExpr() {
		if (ifExpr != null && ifExpr.eIsProxy()) {
			InternalEObject oldIfExpr = (InternalEObject)ifExpr;
			ifExpr = (Expr)eResolveProxy(oldIfExpr);
			if (ifExpr != oldIfExpr) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KconfigPackage.RANGE__IF_EXPR, oldIfExpr, ifExpr));
			}
		}
		return ifExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expr basicGetIfExpr() {
		return ifExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIfExpr(Expr newIfExpr) {
		Expr oldIfExpr = ifExpr;
		ifExpr = newIfExpr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KconfigPackage.RANGE__IF_EXPR, oldIfExpr, ifExpr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expr getUpperExpr() {
		if (upperExpr != null && upperExpr.eIsProxy()) {
			InternalEObject oldUpperExpr = (InternalEObject)upperExpr;
			upperExpr = (Expr)eResolveProxy(oldUpperExpr);
			if (upperExpr != oldUpperExpr) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KconfigPackage.RANGE__UPPER_EXPR, oldUpperExpr, upperExpr));
			}
		}
		return upperExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expr basicGetUpperExpr() {
		return upperExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperExpr(Expr newUpperExpr) {
		Expr oldUpperExpr = upperExpr;
		upperExpr = newUpperExpr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KconfigPackage.RANGE__UPPER_EXPR, oldUpperExpr, upperExpr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KconfigPackage.RANGE__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((Config)otherEnd, msgs);
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
			case KconfigPackage.RANGE__OWNER:
				return basicSetOwner(null, msgs);
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
			case KconfigPackage.RANGE__OWNER:
				return eInternalContainer().eInverseRemove(this, KconfigPackage.CONFIG__RANGES, Config.class, msgs);
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
			case KconfigPackage.RANGE__OWNER:
				return getOwner();
			case KconfigPackage.RANGE__LOWER_EXPR:
				if (resolve) return getLowerExpr();
				return basicGetLowerExpr();
			case KconfigPackage.RANGE__IF_EXPR:
				if (resolve) return getIfExpr();
				return basicGetIfExpr();
			case KconfigPackage.RANGE__UPPER_EXPR:
				if (resolve) return getUpperExpr();
				return basicGetUpperExpr();
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
			case KconfigPackage.RANGE__OWNER:
				setOwner((Config)newValue);
				return;
			case KconfigPackage.RANGE__LOWER_EXPR:
				setLowerExpr((Expr)newValue);
				return;
			case KconfigPackage.RANGE__IF_EXPR:
				setIfExpr((Expr)newValue);
				return;
			case KconfigPackage.RANGE__UPPER_EXPR:
				setUpperExpr((Expr)newValue);
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
			case KconfigPackage.RANGE__OWNER:
				setOwner((Config)null);
				return;
			case KconfigPackage.RANGE__LOWER_EXPR:
				setLowerExpr((Expr)null);
				return;
			case KconfigPackage.RANGE__IF_EXPR:
				setIfExpr((Expr)null);
				return;
			case KconfigPackage.RANGE__UPPER_EXPR:
				setUpperExpr((Expr)null);
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
			case KconfigPackage.RANGE__OWNER:
				return getOwner() != null;
			case KconfigPackage.RANGE__LOWER_EXPR:
				return lowerExpr != null;
			case KconfigPackage.RANGE__IF_EXPR:
				return ifExpr != null;
			case KconfigPackage.RANGE__UPPER_EXPR:
				return upperExpr != null;
		}
		return super.eIsSet(featureID);
	}

} //RangeImpl
