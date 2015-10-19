/**
 */
package at.jku.weiner.c.c;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Direct Declarator Last Suffix</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.DirectDeclaratorLastSuffix#getParameterTypeList <em>Parameter Type List</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.DirectDeclaratorLastSuffix#getIdentifierList <em>Identifier List</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.c.CPackage#getDirectDeclaratorLastSuffix()
 * @model
 * @generated
 */
public interface DirectDeclaratorLastSuffix extends EObject
{
  /**
   * Returns the value of the '<em><b>Parameter Type List</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.c.ParameterTypeList}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter Type List</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter Type List</em>' containment reference list.
   * @see at.jku.weiner.c.c.CPackage#getDirectDeclaratorLastSuffix_ParameterTypeList()
   * @model containment="true"
   * @generated
   */
  EList<ParameterTypeList> getParameterTypeList();

  /**
   * Returns the value of the '<em><b>Identifier List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Identifier List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Identifier List</em>' containment reference.
   * @see #setIdentifierList(IdentifierList)
   * @see at.jku.weiner.c.c.CPackage#getDirectDeclaratorLastSuffix_IdentifierList()
   * @model containment="true"
   * @generated
   */
  IdentifierList getIdentifierList();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.DirectDeclaratorLastSuffix#getIdentifierList <em>Identifier List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Identifier List</em>' containment reference.
   * @see #getIdentifierList()
   * @generated
   */
  void setIdentifierList(IdentifierList value);

} // DirectDeclaratorLastSuffix
