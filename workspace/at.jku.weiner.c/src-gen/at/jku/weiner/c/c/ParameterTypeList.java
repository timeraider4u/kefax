/**
 */
package at.jku.weiner.c.c;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Type List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.ParameterTypeList#getList <em>List</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.c.CPackage#getParameterTypeList()
 * @model
 * @generated
 */
public interface ParameterTypeList extends EObject
{
  /**
   * Returns the value of the '<em><b>List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>List</em>' containment reference.
   * @see #setList(ParameterList)
   * @see at.jku.weiner.c.c.CPackage#getParameterTypeList_List()
   * @model containment="true"
   * @generated
   */
  ParameterList getList();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.ParameterTypeList#getList <em>List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>List</em>' containment reference.
   * @see #getList()
   * @generated
   */
  void setList(ParameterList value);

} // ParameterTypeList
