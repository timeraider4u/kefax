/**
 */
package at.jku.weiner.c.common.common;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Translation Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.common.common.TranslationUnit#getPreprocess <em>Preprocess</em>}</li>
 *   <li>{@link at.jku.weiner.c.common.common.TranslationUnit#getParser <em>Parser</em>}</li>
 *   <li>{@link at.jku.weiner.c.common.common.TranslationUnit#getPath <em>Path</em>}</li>
 *   <li>{@link at.jku.weiner.c.common.common.TranslationUnit#getAdditionalPreprocessingDirectives <em>Additional Preprocessing Directives</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.common.common.CommonPackage#getTranslationUnit()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface TranslationUnit extends PersistentEObject
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
	 * @see at.jku.weiner.c.common.common.CommonPackage#getTranslationUnit_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.common.common.TranslationUnit#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Additional Preprocessing Directives</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Additional Preprocessing Directives</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Additional Preprocessing Directives</em>' reference.
	 * @see #setAdditionalPreprocessingDirectives(Preprocess)
	 * @see at.jku.weiner.c.common.common.CommonPackage#getTranslationUnit_AdditionalPreprocessingDirectives()
	 * @model
	 * @generated
	 */
	Preprocess getAdditionalPreprocessingDirectives();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.common.common.TranslationUnit#getAdditionalPreprocessingDirectives <em>Additional Preprocessing Directives</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Additional Preprocessing Directives</em>' reference.
	 * @see #getAdditionalPreprocessingDirectives()
	 * @generated
	 */
	void setAdditionalPreprocessingDirectives(Preprocess value);

} // TranslationUnit
