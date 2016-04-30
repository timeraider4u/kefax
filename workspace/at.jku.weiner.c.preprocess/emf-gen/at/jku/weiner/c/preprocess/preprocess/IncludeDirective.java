/**
 */
package at.jku.weiner.c.preprocess.preprocess;

import at.jku.weiner.c.common.common.TranslationUnit;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Include Directive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.IncludeDirective#getString <em>String</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.IncludeDirective#getUnit <em>Unit</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.IncludeDirective#isNext <em>Next</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getIncludeDirective()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface IncludeDirective extends PersistentEObject
{
	/**
	 * Returns the value of the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String</em>' attribute.
	 * @see #setString(String)
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getIncludeDirective_String()
	 * @model
	 * @generated
	 */
	String getString();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.IncludeDirective#getString <em>String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String</em>' attribute.
	 * @see #getString()
	 * @generated
	 */
	void setString(String value);

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
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getIncludeDirective_Unit()
	 * @model
	 * @generated
	 */
	TranslationUnit getUnit();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.IncludeDirective#getUnit <em>Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' reference.
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(TranslationUnit value);

	/**
	 * Returns the value of the '<em><b>Next</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next</em>' attribute.
	 * @see #setNext(boolean)
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getIncludeDirective_Next()
	 * @model
	 * @generated
	 */
	boolean isNext();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.IncludeDirective#isNext <em>Next</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next</em>' attribute.
	 * @see #isNext()
	 * @generated
	 */
	void setNext(boolean value);

} // IncludeDirective
