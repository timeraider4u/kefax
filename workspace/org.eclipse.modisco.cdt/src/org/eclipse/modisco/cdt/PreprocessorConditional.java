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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Preprocessor Conditional</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.modisco.cdt.PreprocessorConditional#isBranchTaken <em>Branch Taken</em>}</li>
 *   <li>{@link org.eclipse.modisco.cdt.PreprocessorConditional#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.modisco.cdt.CdtPackage#getPreprocessorConditional()
 * @model abstract="true"
 * @generated
 */
public interface PreprocessorConditional extends PreprocessorStatement, Scope {
	/**
	 * Returns the value of the '<em><b>Branch Taken</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branch Taken</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branch Taken</em>' attribute.
	 * @see #setBranchTaken(boolean)
	 * @see org.eclipse.modisco.cdt.CdtPackage#getPreprocessorConditional_BranchTaken()
	 * @model
	 * @generated
	 */
	boolean isBranchTaken();

	/**
	 * Sets the value of the '{@link org.eclipse.modisco.cdt.PreprocessorConditional#isBranchTaken <em>Branch Taken</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Branch Taken</em>' attribute.
	 * @see #isBranchTaken()
	 * @generated
	 */
	void setBranchTaken(boolean value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' attribute.
	 * @see #setCondition(String)
	 * @see org.eclipse.modisco.cdt.CdtPackage#getPreprocessorConditional_Condition()
	 * @model
	 * @generated
	 */
	String getCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.modisco.cdt.PreprocessorConditional#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(String value);

} // PreprocessorConditional
