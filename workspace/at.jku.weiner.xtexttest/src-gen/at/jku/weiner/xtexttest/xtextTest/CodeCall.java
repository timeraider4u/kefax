/**
 */
package at.jku.weiner.xtexttest.xtextTest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Code Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.CodeCall#getMyclass <em>Myclass</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.CodeCall#getMethod <em>Method</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.CodeCall#getParams <em>Params</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getCodeCall()
 * @model
 * @generated
 */
public interface CodeCall extends EObject
{
  /**
   * Returns the value of the '<em><b>Myclass</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Myclass</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Myclass</em>' attribute.
   * @see #setMyclass(String)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getCodeCall_Myclass()
   * @model
   * @generated
   */
  String getMyclass();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.CodeCall#getMyclass <em>Myclass</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Myclass</em>' attribute.
   * @see #getMyclass()
   * @generated
   */
  void setMyclass(String value);

  /**
   * Returns the value of the '<em><b>Method</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Method</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method</em>' attribute.
   * @see #setMethod(String)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getCodeCall_Method()
   * @model
   * @generated
   */
  String getMethod();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.CodeCall#getMethod <em>Method</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Method</em>' attribute.
   * @see #getMethod()
   * @generated
   */
  void setMethod(String value);

  /**
   * Returns the value of the '<em><b>Params</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Params</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Params</em>' attribute list.
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getCodeCall_Params()
   * @model unique="false"
   * @generated
   */
  EList<String> getParams();

} // CodeCall
