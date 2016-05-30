/**
 */
package at.jku.weiner.antlr4;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.antlr4.Rule#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link at.jku.weiner.antlr4.Rule#getReferencesBy <em>References By</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.antlr4.Antlr4Package#getRule()
 * @model abstract="true"
 * @generated
 */
public interface Rule extends EObject {

	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(String)
	 * @see at.jku.weiner.antlr4.Antlr4Package#getRule_Identifier()
	 * @model
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link at.jku.weiner.antlr4.Rule#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>References By</b></em>' reference list.
	 * The list contents are of type {@link at.jku.weiner.antlr4.Rule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References By</em>' reference list.
	 * @see at.jku.weiner.antlr4.Antlr4Package#getRule_ReferencesBy()
	 * @model
	 * @generated
	 */
	EList<Rule> getReferencesBy();
} // Rule
