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
 * A representation of the model object '<em><b>Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.modisco.kconfig.Config#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.Config#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.Config#getHelpText <em>Help Text</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.Config#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.Config#getDepends <em>Depends</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.Config#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.Config#getDefinedIn <em>Defined In</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.Config#getPrompt <em>Prompt</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.Config#getDefaults <em>Defaults</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.Config#getSelects <em>Selects</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.Config#getRanges <em>Ranges</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.Config#getOptions <em>Options</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.modisco.kconfig.KconfigPackage#getConfig()
 * @model
 * @generated
 */
public interface Config extends EObject {
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
	 * @see org.eclipse.modisco.kconfig.KconfigPackage#getConfig_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.modisco.kconfig.Config#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.modisco.kconfig.ConfigType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.modisco.kconfig.ConfigType
	 * @see #setType(ConfigType)
	 * @see org.eclipse.modisco.kconfig.KconfigPackage#getConfig_Type()
	 * @model
	 * @generated
	 */
	ConfigType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.modisco.kconfig.Config#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.modisco.kconfig.ConfigType
	 * @see #getType()
	 * @generated
	 */
	void setType(ConfigType value);

	/**
	 * Returns the value of the '<em><b>Help Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Help Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Help Text</em>' attribute.
	 * @see #setHelpText(String)
	 * @see org.eclipse.modisco.kconfig.KconfigPackage#getConfig_HelpText()
	 * @model
	 * @generated
	 */
	String getHelpText();

	/**
	 * Sets the value of the '{@link org.eclipse.modisco.kconfig.Config#getHelpText <em>Help Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Help Text</em>' attribute.
	 * @see #getHelpText()
	 * @generated
	 */
	void setHelpText(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.modisco.kconfig.KconfigPackage#getConfig_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.modisco.kconfig.Config#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Depends</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.modisco.kconfig.Depend}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.modisco.kconfig.Depend#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depends</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depends</em>' containment reference list.
	 * @see org.eclipse.modisco.kconfig.KconfigPackage#getConfig_Depends()
	 * @see org.eclipse.modisco.kconfig.Depend#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Depend> getDepends();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.modisco.kconfig.Model#getConfigs <em>Configs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Model)
	 * @see org.eclipse.modisco.kconfig.KconfigPackage#getConfig_Owner()
	 * @see org.eclipse.modisco.kconfig.Model#getConfigs
	 * @model opposite="configs" transient="false"
	 * @generated
	 */
	Model getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.modisco.kconfig.Config#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Model value);

	/**
	 * Returns the value of the '<em><b>Defined In</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.modisco.kconfig.TranslationUnit#getConfigs <em>Configs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defined In</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defined In</em>' reference.
	 * @see #setDefinedIn(TranslationUnit)
	 * @see org.eclipse.modisco.kconfig.KconfigPackage#getConfig_DefinedIn()
	 * @see org.eclipse.modisco.kconfig.TranslationUnit#getConfigs
	 * @model opposite="configs"
	 * @generated
	 */
	TranslationUnit getDefinedIn();

	/**
	 * Sets the value of the '{@link org.eclipse.modisco.kconfig.Config#getDefinedIn <em>Defined In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defined In</em>' reference.
	 * @see #getDefinedIn()
	 * @generated
	 */
	void setDefinedIn(TranslationUnit value);

	/**
	 * Returns the value of the '<em><b>Prompt</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.modisco.kconfig.Prompt#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prompt</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prompt</em>' containment reference.
	 * @see #setPrompt(Prompt)
	 * @see org.eclipse.modisco.kconfig.KconfigPackage#getConfig_Prompt()
	 * @see org.eclipse.modisco.kconfig.Prompt#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	Prompt getPrompt();

	/**
	 * Sets the value of the '{@link org.eclipse.modisco.kconfig.Config#getPrompt <em>Prompt</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prompt</em>' containment reference.
	 * @see #getPrompt()
	 * @generated
	 */
	void setPrompt(Prompt value);

	/**
	 * Returns the value of the '<em><b>Defaults</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.modisco.kconfig.Default}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.modisco.kconfig.Default#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defaults</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defaults</em>' containment reference list.
	 * @see org.eclipse.modisco.kconfig.KconfigPackage#getConfig_Defaults()
	 * @see org.eclipse.modisco.kconfig.Default#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Default> getDefaults();

	/**
	 * Returns the value of the '<em><b>Selects</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.modisco.kconfig.Select}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.modisco.kconfig.Select#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selects</em>' containment reference list.
	 * @see org.eclipse.modisco.kconfig.KconfigPackage#getConfig_Selects()
	 * @see org.eclipse.modisco.kconfig.Select#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Select> getSelects();

	/**
	 * Returns the value of the '<em><b>Ranges</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.modisco.kconfig.Range}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.modisco.kconfig.Range#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ranges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ranges</em>' containment reference list.
	 * @see org.eclipse.modisco.kconfig.KconfigPackage#getConfig_Ranges()
	 * @see org.eclipse.modisco.kconfig.Range#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Range> getRanges();

	/**
	 * Returns the value of the '<em><b>Options</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.modisco.kconfig.Option}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.modisco.kconfig.Option#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Options</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' containment reference list.
	 * @see org.eclipse.modisco.kconfig.KconfigPackage#getConfig_Options()
	 * @see org.eclipse.modisco.kconfig.Option#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Option> getOptions();

} // Config
