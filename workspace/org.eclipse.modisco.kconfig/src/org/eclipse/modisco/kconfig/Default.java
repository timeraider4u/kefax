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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Default</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.modisco.kconfig.Default#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.Default#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.modisco.kconfig.Default#getIfExpr <em>If Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.modisco.kconfig.KconfigPackage#getDefault()
 * @model
 * @generated
 */
public interface Default extends EObject {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.modisco.kconfig.Config#getDefaults <em>Defaults</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Config)
	 * @see org.eclipse.modisco.kconfig.KconfigPackage#getDefault_Owner()
	 * @see org.eclipse.modisco.kconfig.Config#getDefaults
	 * @model opposite="defaults" required="true" transient="false"
	 * @generated
	 */
	Config getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.modisco.kconfig.Default#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Config value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' reference.
	 * @see #setExpression(Expr)
	 * @see org.eclipse.modisco.kconfig.KconfigPackage#getDefault_Expression()
	 * @model required="true"
	 * @generated
	 */
	Expr getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.modisco.kconfig.Default#getExpression <em>Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expr value);

	/**
	 * Returns the value of the '<em><b>If Expr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>If Expr</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>If Expr</em>' reference.
	 * @see #setIfExpr(Expr)
	 * @see org.eclipse.modisco.kconfig.KconfigPackage#getDefault_IfExpr()
	 * @model
	 * @generated
	 */
	Expr getIfExpr();

	/**
	 * Sets the value of the '{@link org.eclipse.modisco.kconfig.Default#getIfExpr <em>If Expr</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If Expr</em>' reference.
	 * @see #getIfExpr()
	 * @generated
	 */
	void setIfExpr(Expr value);

} // Default
