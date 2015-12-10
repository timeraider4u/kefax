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
 * A representation of the model object '<em><b>Tristate Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.modisco.kconfig.TristateExpr#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.modisco.kconfig.KconfigPackage#getTristateExpr()
 * @model
 * @generated
 */
public interface TristateExpr extends Expr {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.modisco.kconfig.TristateValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see org.eclipse.modisco.kconfig.TristateValue
	 * @see #setValue(TristateValue)
	 * @see org.eclipse.modisco.kconfig.KconfigPackage#getTristateExpr_Value()
	 * @model
	 * @generated
	 */
	TristateValue getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.modisco.kconfig.TristateExpr#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see org.eclipse.modisco.kconfig.TristateValue
	 * @see #getValue()
	 * @generated
	 */
	void setValue(TristateValue value);

} // TristateExpr
