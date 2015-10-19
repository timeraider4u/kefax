/**
 */
package at.jku.weiner.c.c;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.AssignmentOperator#getOp <em>Op</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.c.CPackage#getAssignmentOperator()
 * @model
 * @generated
 */
public interface AssignmentOperator extends EObject
{
  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see #setOp(String)
   * @see at.jku.weiner.c.c.CPackage#getAssignmentOperator_Op()
   * @model
   * @generated
   */
  String getOp();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.AssignmentOperator#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see #getOp()
   * @generated
   */
  void setOp(String value);

} // AssignmentOperator
