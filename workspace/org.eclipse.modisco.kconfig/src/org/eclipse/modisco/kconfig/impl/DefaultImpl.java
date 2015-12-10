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
import org.eclipse.modisco.kconfig.Default;
import org.eclipse.modisco.kconfig.Expr;
import org.eclipse.modisco.kconfig.KconfigPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Default</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.DefaultImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.DefaultImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.impl.DefaultImpl#getIfExpr <em>If Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DefaultImpl extends MinimalEObjectImpl.Container implements Default {
	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected Expr expression;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefaultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KconfigPackage.Literals.DEFAULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Config getOwner() {
		if (eContainerFeatureID() != KconfigPackage.DEFAULT__OWNER) return null;
		return (Config)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Config newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, KconfigPackage.DEFAULT__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Config newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != KconfigPackage.DEFAULT__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, KconfigPackage.CONFIG__DEFAULTS, Config.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KconfigPackage.DEFAULT__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expr getExpression() {
		if (expression != null && expression.eIsProxy()) {
			InternalEObject oldExpression = (InternalEObject)expression;
			expression = (Expr)eResolveProxy(oldExpression);
			if (expression != oldExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KconfigPackage.DEFAULT__EXPRESSION, oldExpression, expression));
			}
		}
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expr basicGetExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(Expr newExpression) {
		Expr oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KconfigPackage.DEFAULT__EXPRESSION, oldExpression, expression));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KconfigPackage.DEFAULT__IF_EXPR, oldIfExpr, ifExpr));
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
			eNotify(new ENotificationImpl(this, Notification.SET, KconfigPackage.DEFAULT__IF_EXPR, oldIfExpr, ifExpr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KconfigPackage.DEFAULT__OWNER:
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
			case KconfigPackage.DEFAULT__OWNER:
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
			case KconfigPackage.DEFAULT__OWNER:
				return eInternalContainer().eInverseRemove(this, KconfigPackage.CONFIG__DEFAULTS, Config.class, msgs);
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
			case KconfigPackage.DEFAULT__OWNER:
				return getOwner();
			case KconfigPackage.DEFAULT__EXPRESSION:
				if (resolve) return getExpression();
				return basicGetExpression();
			case KconfigPackage.DEFAULT__IF_EXPR:
				if (resolve) return getIfExpr();
				return basicGetIfExpr();
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
			case KconfigPackage.DEFAULT__OWNER:
				setOwner((Config)newValue);
				return;
			case KconfigPackage.DEFAULT__EXPRESSION:
				setExpression((Expr)newValue);
				return;
			case KconfigPackage.DEFAULT__IF_EXPR:
				setIfExpr((Expr)newValue);
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
			case KconfigPackage.DEFAULT__OWNER:
				setOwner((Config)null);
				return;
			case KconfigPackage.DEFAULT__EXPRESSION:
				setExpression((Expr)null);
				return;
			case KconfigPackage.DEFAULT__IF_EXPR:
				setIfExpr((Expr)null);
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
			case KconfigPackage.DEFAULT__OWNER:
				return getOwner() != null;
			case KconfigPackage.DEFAULT__EXPRESSION:
				return expression != null;
			case KconfigPackage.DEFAULT__IF_EXPR:
				return ifExpr != null;
		}
		return super.eIsSet(featureID);
	}

} //DefaultImpl
