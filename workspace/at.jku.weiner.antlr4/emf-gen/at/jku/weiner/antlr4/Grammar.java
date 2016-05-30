/**
 */
package at.jku.weiner.antlr4;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Grammar</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.antlr4.Grammar#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link at.jku.weiner.antlr4.Grammar#getRules <em>Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.antlr4.Antlr4Package#getGrammar()
 * @model
 * @generated
 */
public interface Grammar extends EObject {
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
	 * @see at.jku.weiner.antlr4.Antlr4Package#getGrammar_Identifier()
	 * @model
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link at.jku.weiner.antlr4.Grammar#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link at.jku.weiner.antlr4.Rule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see at.jku.weiner.antlr4.Antlr4Package#getGrammar_Rules()
	 * @model containment="true"
	 * @generated
	 */
	EList<Rule> getRules();

} // Grammar
