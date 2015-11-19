/**
 */
package at.jku.weiner.xtexttest.xtextTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>My Tokens</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.MyTokens#getToken <em>Token</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.MyTokens#getCount <em>Count</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getMyTokens()
 * @model
 * @generated
 */
public interface MyTokens extends EObject
{
  /**
   * Returns the value of the '<em><b>Token</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Token</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Token</em>' attribute.
   * @see #setToken(String)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getMyTokens_Token()
   * @model
   * @generated
   */
  String getToken();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.MyTokens#getToken <em>Token</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Token</em>' attribute.
   * @see #getToken()
   * @generated
   */
  void setToken(String value);

  /**
   * Returns the value of the '<em><b>Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Count</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Count</em>' attribute.
   * @see #setCount(int)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getMyTokens_Count()
   * @model
   * @generated
   */
  int getCount();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.MyTokens#getCount <em>Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Count</em>' attribute.
   * @see #getCount()
   * @generated
   */
  void setCount(int value);

} // MyTokens
