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
package org.eclipse.modisco.cdt;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.modisco.cdt.FunctionDefinition#getFunctionDeclarations <em>Function Declarations</em>}</li>
 *   <li>{@link org.eclipse.modisco.cdt.FunctionDefinition#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.modisco.cdt.CdtPackage#getFunctionDefinition()
 * @model
 * @generated
 */
public interface FunctionDefinition extends Function {
	/**
	 * Returns the value of the '<em><b>Function Declarations</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.modisco.cdt.FunctionDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Declarations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Declarations</em>' reference list.
	 * @see org.eclipse.modisco.cdt.CdtPackage#getFunctionDefinition_FunctionDeclarations()
	 * @model
	 * @generated
	 */
	EList<FunctionDeclaration> getFunctionDeclarations();

	/**
	 * Returns the value of the '<em><b>Body</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' reference.
	 * @see #setBody(CompoundStatement)
	 * @see org.eclipse.modisco.cdt.CdtPackage#getFunctionDefinition_Body()
	 * @model required="true"
	 * @generated
	 */
	CompoundStatement getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.modisco.cdt.FunctionDefinition#getBody <em>Body</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(CompoundStatement value);

} // FunctionDefinition
