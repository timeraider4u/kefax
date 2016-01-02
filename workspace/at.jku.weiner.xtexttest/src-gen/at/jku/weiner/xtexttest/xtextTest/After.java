/**
 */
package at.jku.weiner.xtexttest.xtextTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>After</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.After#getCodeCall <em>Code Call</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getAfter()
 * @model
 * @generated
 */
public interface After extends EObject
{
  /**
   * Returns the value of the '<em><b>Code Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Code Call</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Code Call</em>' containment reference.
   * @see #setCodeCall(CodeCall)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getAfter_CodeCall()
   * @model containment="true"
   * @generated
   */
  CodeCall getCodeCall();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.After#getCodeCall <em>Code Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Code Call</em>' containment reference.
   * @see #getCodeCall()
   * @generated
   */
  void setCodeCall(CodeCall value);

} // After
