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
 * A representation of the model object '<em><b>Preprocessor Include Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.modisco.cdt.PreprocessorIncludeStatement#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.modisco.cdt.PreprocessorIncludeStatement#isStandard <em>Standard</em>}</li>
 *   <li>{@link org.eclipse.modisco.cdt.PreprocessorIncludeStatement#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.modisco.cdt.PreprocessorIncludeStatement#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.modisco.cdt.CdtPackage#getPreprocessorIncludeStatement()
 * @model
 * @generated
 */
public interface PreprocessorIncludeStatement extends PreprocessorStatement {
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
	 * @see org.eclipse.modisco.cdt.CdtPackage#getPreprocessorIncludeStatement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.modisco.cdt.PreprocessorIncludeStatement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Standard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Standard</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Standard</em>' attribute.
	 * @see #setStandard(boolean)
	 * @see org.eclipse.modisco.cdt.CdtPackage#getPreprocessorIncludeStatement_Standard()
	 * @model
	 * @generated
	 */
	boolean isStandard();

	/**
	 * Sets the value of the '{@link org.eclipse.modisco.cdt.PreprocessorIncludeStatement#isStandard <em>Standard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Standard</em>' attribute.
	 * @see #isStandard()
	 * @generated
	 */
	void setStandard(boolean value);

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' reference.
	 * @see #setUnit(TranslationUnit)
	 * @see org.eclipse.modisco.cdt.CdtPackage#getPreprocessorIncludeStatement_Unit()
	 * @model
	 * @generated
	 */
	TranslationUnit getUnit();

	/**
	 * Sets the value of the '{@link org.eclipse.modisco.cdt.PreprocessorIncludeStatement#getUnit <em>Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' reference.
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(TranslationUnit value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see org.eclipse.modisco.cdt.CdtPackage#getPreprocessorIncludeStatement_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.eclipse.modisco.cdt.PreprocessorIncludeStatement#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

} // PreprocessorIncludeStatement
