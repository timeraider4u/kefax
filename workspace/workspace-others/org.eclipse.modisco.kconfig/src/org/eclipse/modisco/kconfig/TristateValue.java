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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Tristate Value</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.modisco.kconfig.KconfigPackage#getTristateValue()
 * @model
 * @generated
 */
public enum TristateValue implements Enumerator {
	/**
	 * The '<em><b>Y</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #Y_VALUE
	 * @generated
	 * @ordered
	 */
	Y(0, "y", "y"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>N</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #N_VALUE
	 * @generated
	 * @ordered
	 */
	N(1, "n", "n"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>M</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #M_VALUE
	 * @generated
	 * @ordered
	 */
	M(2, "m", "m"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Y</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Y</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #Y
	 * @model name="y"
	 * @generated
	 * @ordered
	 */
	public static final int Y_VALUE = 0;

	/**
	 * The '<em><b>N</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>N</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #N
	 * @model name="n"
	 * @generated
	 * @ordered
	 */
	public static final int N_VALUE = 1;

	/**
	 * The '<em><b>M</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>M</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #M
	 * @model name="m"
	 * @generated
	 * @ordered
	 */
	public static final int M_VALUE = 2;

	/**
	 * An array of all the '<em><b>Tristate Value</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TristateValue[] VALUES_ARRAY =
		new TristateValue[] {
			Y,
			N,
			M,
		};

	/**
	 * A public read-only list of all the '<em><b>Tristate Value</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TristateValue> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Tristate Value</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TristateValue get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TristateValue result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Tristate Value</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TristateValue getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TristateValue result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Tristate Value</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TristateValue get(int value) {
		switch (value) {
			case Y_VALUE: return Y;
			case N_VALUE: return N;
			case M_VALUE: return M;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TristateValue(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
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
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //TristateValue
