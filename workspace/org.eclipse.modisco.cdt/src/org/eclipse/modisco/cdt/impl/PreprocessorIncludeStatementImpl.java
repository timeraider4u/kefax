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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.modisco.cdt.CdtPackage;
import org.eclipse.modisco.cdt.PreprocessorIncludeStatement;
import org.eclipse.modisco.cdt.TranslationUnit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Preprocessor Include Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.modisco.cdt.impl.PreprocessorIncludeStatementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.modisco.cdt.impl.PreprocessorIncludeStatementImpl#isStandard <em>Standard</em>}</li>
 *   <li>{@link org.eclipse.modisco.cdt.impl.PreprocessorIncludeStatementImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.modisco.cdt.impl.PreprocessorIncludeStatementImpl#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PreprocessorIncludeStatementImpl extends EObjectImpl implements PreprocessorIncludeStatement {
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
	 * The default value of the '{@link #isStandard() <em>Standard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStandard()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STANDARD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStandard() <em>Standard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStandard()
	 * @generated
	 * @ordered
	 */
	protected boolean standard = STANDARD_EDEFAULT;

	/**
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUnit() <em>Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected TranslationUnit unit;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreprocessorIncludeStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CdtPackage.Literals.PREPROCESSOR_INCLUDE_STATEMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CdtPackage.PREPROCESSOR_INCLUDE_STATEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStandard() {
		return standard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStandard(boolean newStandard) {
		boolean oldStandard = standard;
		standard = newStandard;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CdtPackage.PREPROCESSOR_INCLUDE_STATEMENT__STANDARD, oldStandard, standard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TranslationUnit getUnit() {
		if (unit != null && unit.eIsProxy()) {
			InternalEObject oldUnit = (InternalEObject)unit;
			unit = (TranslationUnit)eResolveProxy(oldUnit);
			if (unit != oldUnit) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CdtPackage.PREPROCESSOR_INCLUDE_STATEMENT__UNIT, oldUnit, unit));
			}
		}
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TranslationUnit basicGetUnit() {
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnit(TranslationUnit newUnit) {
		TranslationUnit oldUnit = unit;
		unit = newUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CdtPackage.PREPROCESSOR_INCLUDE_STATEMENT__UNIT, oldUnit, unit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CdtPackage.PREPROCESSOR_INCLUDE_STATEMENT__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CdtPackage.PREPROCESSOR_INCLUDE_STATEMENT__NAME:
				return getName();
			case CdtPackage.PREPROCESSOR_INCLUDE_STATEMENT__STANDARD:
				return isStandard();
			case CdtPackage.PREPROCESSOR_INCLUDE_STATEMENT__PATH:
				return getPath();
			case CdtPackage.PREPROCESSOR_INCLUDE_STATEMENT__UNIT:
				if (resolve) return getUnit();
				return basicGetUnit();
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
			case CdtPackage.PREPROCESSOR_INCLUDE_STATEMENT__NAME:
				setName((String)newValue);
				return;
			case CdtPackage.PREPROCESSOR_INCLUDE_STATEMENT__STANDARD:
				setStandard((Boolean)newValue);
				return;
			case CdtPackage.PREPROCESSOR_INCLUDE_STATEMENT__PATH:
				setPath((String)newValue);
				return;
			case CdtPackage.PREPROCESSOR_INCLUDE_STATEMENT__UNIT:
				setUnit((TranslationUnit)newValue);
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
			case CdtPackage.PREPROCESSOR_INCLUDE_STATEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CdtPackage.PREPROCESSOR_INCLUDE_STATEMENT__STANDARD:
				setStandard(STANDARD_EDEFAULT);
				return;
			case CdtPackage.PREPROCESSOR_INCLUDE_STATEMENT__PATH:
				setPath(PATH_EDEFAULT);
				return;
			case CdtPackage.PREPROCESSOR_INCLUDE_STATEMENT__UNIT:
				setUnit((TranslationUnit)null);
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
			case CdtPackage.PREPROCESSOR_INCLUDE_STATEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CdtPackage.PREPROCESSOR_INCLUDE_STATEMENT__STANDARD:
				return standard != STANDARD_EDEFAULT;
			case CdtPackage.PREPROCESSOR_INCLUDE_STATEMENT__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
			case CdtPackage.PREPROCESSOR_INCLUDE_STATEMENT__UNIT:
				return unit != null;
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
		result.append(", standard: "); //$NON-NLS-1$
		result.append(standard);
		result.append(", path: "); //$NON-NLS-1$
		result.append(path);
		result.append(')');
		return result.toString();
	}

} //PreprocessorIncludeStatementImpl
