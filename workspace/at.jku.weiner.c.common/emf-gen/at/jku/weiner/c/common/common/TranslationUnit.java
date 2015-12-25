/**
 */
package at.jku.weiner.c.common.common;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Translation Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.common.common.TranslationUnit#getPreprocess <em>Preprocess</em>}</li>
 *   <li>{@link at.jku.weiner.c.common.common.TranslationUnit#getParser <em>Parser</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.common.common.CommonPackage#getTranslationUnit()
 * @model
 * @generated
 */
public interface TranslationUnit extends EObject
{
	/**
	 * Returns the value of the '<em><b>Preprocess</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preprocess</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preprocess</em>' containment reference.
	 * @see #setPreprocess(Preprocess)
	 * @see at.jku.weiner.c.common.common.CommonPackage#getTranslationUnit_Preprocess()
	 * @model containment="true"
	 * @generated
	 */
	Preprocess getPreprocess();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.common.common.TranslationUnit#getPreprocess <em>Preprocess</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preprocess</em>' containment reference.
	 * @see #getPreprocess()
	 * @generated
	 */
	void setPreprocess(Preprocess value);

	/**
	 * Returns the value of the '<em><b>Parser</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parser</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parser</em>' containment reference.
	 * @see #setParser(Parser)
	 * @see at.jku.weiner.c.common.common.CommonPackage#getTranslationUnit_Parser()
	 * @model containment="true"
	 * @generated
	 */
	Parser getParser();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.common.common.TranslationUnit#getParser <em>Parser</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parser</em>' containment reference.
	 * @see #getParser()
	 * @generated
	 */
	void setParser(Parser value);

} // TranslationUnit
