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

import org.eclipse.emf.ecore.EClass;

import org.eclipse.modisco.cdt.CdtPackage;
import org.eclipse.modisco.cdt.PreprocessorIfDefStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Preprocessor If Def Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PreprocessorIfDefStatementImpl extends PreprocessorConditionalImpl implements PreprocessorIfDefStatement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreprocessorIfDefStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CdtPackage.Literals.PREPROCESSOR_IF_DEF_STATEMENT;
	}

} //PreprocessorIfDefStatementImpl
