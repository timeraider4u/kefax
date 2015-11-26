/**
 */
package at.jku.weiner.cpreprocess.cPreprocess;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Directive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.cpreprocess.cPreprocess.ErrorDirective#getMsg <em>Msg</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.cpreprocess.cPreprocess.CPreprocessPackage#getErrorDirective()
 * @model
 * @generated
 */
public interface ErrorDirective extends EObject
{
  /**
   * Returns the value of the '<em><b>Msg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Msg</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Msg</em>' attribute.
   * @see #setMsg(String)
   * @see at.jku.weiner.cpreprocess.cPreprocess.CPreprocessPackage#getErrorDirective_Msg()
   * @model
   * @generated
   */
  String getMsg();

  /**
   * Sets the value of the '{@link at.jku.weiner.cpreprocess.cPreprocess.ErrorDirective#getMsg <em>Msg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Msg</em>' attribute.
   * @see #getMsg()
   * @generated
   */
  void setMsg(String value);

} // ErrorDirective
