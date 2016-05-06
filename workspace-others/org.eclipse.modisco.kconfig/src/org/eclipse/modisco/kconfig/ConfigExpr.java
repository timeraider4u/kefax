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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Config Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.modisco.kconfig.ConfigExpr#isNegated <em>Negated</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.ConfigExpr#getRefOnConfig <em>Ref On Config</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.modisco.kconfig.KconfigPackage#getConfigExpr()
 * @model
 * @generated
 */
public interface ConfigExpr extends Expr {
	/**
	 * Returns the value of the '<em><b>Negated</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Negated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Negated</em>' attribute.
	 * @see #setNegated(boolean)
	 * @see org.eclipse.modisco.kconfig.KconfigPackage#getConfigExpr_Negated()
	 * @model default="false"
	 * @generated
	 */
	boolean isNegated();

	/**
	 * Sets the value of the '{@link org.eclipse.modisco.kconfig.ConfigExpr#isNegated <em>Negated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Negated</em>' attribute.
	 * @see #isNegated()
	 * @generated
	 */
	void setNegated(boolean value);

	/**
	 * Returns the value of the '<em><b>Ref On Config</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref On Config</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref On Config</em>' reference.
	 * @see #setRefOnConfig(Config)
	 * @see org.eclipse.modisco.kconfig.KconfigPackage#getConfigExpr_RefOnConfig()
	 * @model
	 * @generated
	 */
	Config getRefOnConfig();

	/**
	 * Sets the value of the '{@link org.eclipse.modisco.kconfig.ConfigExpr#getRefOnConfig <em>Ref On Config</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref On Config</em>' reference.
	 * @see #getRefOnConfig()
	 * @generated
	 */
	void setRefOnConfig(Config value);

} // ConfigExpr
