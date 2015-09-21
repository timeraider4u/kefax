/**
 */
package org.xtext.example.mydsl1.myDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl1.myDsl.Inc#getInc <em>Inc</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl1.myDsl.MyDslPackage#getInc()
 * @model
 * @generated
 */
public interface Inc extends EObject
{
  /**
   * Returns the value of the '<em><b>Inc</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inc</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inc</em>' attribute.
   * @see #setInc(String)
   * @see org.xtext.example.mydsl1.myDsl.MyDslPackage#getInc_Inc()
   * @model
   * @generated
   */
  String getInc();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl1.myDsl.Inc#getInc <em>Inc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Inc</em>' attribute.
   * @see #getInc()
   * @generated
   */
  void setInc(String value);

} // Inc
