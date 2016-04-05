/**
 */
package at.jku.weiner.xtexttest.xtextTest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tokens</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.Tokens#getTokens <em>Tokens</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getTokens()
 * @model
 * @generated
 */
public interface Tokens extends EObject
{
  /**
   * Returns the value of the '<em><b>Tokens</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.xtexttest.xtextTest.MyTokens}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tokens</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tokens</em>' containment reference list.
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getTokens_Tokens()
   * @model containment="true"
   * @generated
   */
  EList<MyTokens> getTokens();

} // Tokens
