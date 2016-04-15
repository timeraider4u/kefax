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
package org.eclipse.modisco.kconfig;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Translation Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.modisco.kconfig.TranslationUnit#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.TranslationUnit#getUnitOwner <em>Unit Owner</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.TranslationUnit#getFullPath <em>Full Path</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.TranslationUnit#getConfigs <em>Configs</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.TranslationUnit#getSources <em>Sources</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.modisco.kconfig.KconfigPackage#getTranslationUnit()
 * @model
 * @generated
 */
public interface TranslationUnit extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.modisco.kconfig.KconfigPackage#getTranslationUnit_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.modisco.kconfig.TranslationUnit#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Unit Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.modisco.kconfig.Model#getUnits <em>Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Owner</em>' container reference.
	 * @see #setUnitOwner(Model)
	 * @see org.eclipse.modisco.kconfig.KconfigPackage#getTranslationUnit_UnitOwner()
	 * @see org.eclipse.modisco.kconfig.Model#getUnits
	 * @model opposite="units" required="true" transient="false"
	 * @generated
	 */
	Model getUnitOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.modisco.kconfig.TranslationUnit#getUnitOwner <em>Unit Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Owner</em>' container reference.
	 * @see #getUnitOwner()
	 * @generated
	 */
	void setUnitOwner(Model value);

	/**
	 * Returns the value of the '<em><b>Full Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Full Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Full Path</em>' attribute.
	 * @see #setFullPath(String)
	 * @see org.eclipse.modisco.kconfig.KconfigPackage#getTranslationUnit_FullPath()
	 * @model
	 * @generated
	 */
	String getFullPath();

	/**
	 * Sets the value of the '{@link org.eclipse.modisco.kconfig.TranslationUnit#getFullPath <em>Full Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Full Path</em>' attribute.
	 * @see #getFullPath()
	 * @generated
	 */
	void setFullPath(String value);

	/**
	 * Returns the value of the '<em><b>Configs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.modisco.kconfig.Config}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.modisco.kconfig.Config#getDefinedIn <em>Defined In</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configs</em>' reference list.
	 * @see org.eclipse.modisco.kconfig.KconfigPackage#getTranslationUnit_Configs()
	 * @see org.eclipse.modisco.kconfig.Config#getDefinedIn
	 * @model opposite="definedIn"
	 * @generated
	 */
	EList<Config> getConfigs();

	/**
	 * Returns the value of the '<em><b>Sources</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.modisco.kconfig.TranslationUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sources</em>' reference list.
	 * @see org.eclipse.modisco.kconfig.KconfigPackage#getTranslationUnit_Sources()
	 * @model
	 * @generated
	 */
	EList<TranslationUnit> getSources();

} // TranslationUnit
