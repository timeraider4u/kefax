/**
 */
package at.jku.weiner.c.preprocess.preprocess;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Directive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.ConditionalDirective#getConditional <em>Conditional</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.ConditionalDirective#getElifs <em>Elifs</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.ConditionalDirective#getElse <em>Else</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getConditionalDirective()
 * @model
 * @generated
 */
public interface ConditionalDirective extends EObject
{
	/**
	 * Returns the value of the '<em><b>Conditional</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conditional</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conditional</em>' containment reference.
	 * @see #setConditional(IfAbstractConditional)
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getConditionalDirective_Conditional()
	 * @model containment="true"
	 * @generated
	 */
	IfAbstractConditional getConditional();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.ConditionalDirective#getConditional <em>Conditional</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conditional</em>' containment reference.
	 * @see #getConditional()
	 * @generated
	 */
	void setConditional(IfAbstractConditional value);

	/**
	 * Returns the value of the '<em><b>Elifs</b></em>' containment reference list.
	 * The list contents are of type {@link at.jku.weiner.c.preprocess.preprocess.ElIfConditional}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elifs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elifs</em>' containment reference list.
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getConditionalDirective_Elifs()
	 * @model containment="true"
	 * @generated
	 */
	EList<ElIfConditional> getElifs();

	/**
	 * Returns the value of the '<em><b>Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else</em>' containment reference.
	 * @see #setElse(ElseConditional)
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getConditionalDirective_Else()
	 * @model containment="true"
	 * @generated
	 */
	ElseConditional getElse();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.ConditionalDirective#getElse <em>Else</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else</em>' containment reference.
	 * @see #getElse()
	 * @generated
	 */
	void setElse(ElseConditional value);

} // ConditionalDirective
