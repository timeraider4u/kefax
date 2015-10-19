/**
 */
package at.jku.weiner.c.c;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Storage Class Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.StorageClassSpecifier#getClass_ <em>Class</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.c.CPackage#getStorageClassSpecifier()
 * @model
 * @generated
 */
public interface StorageClassSpecifier extends EObject
{
  /**
   * Returns the value of the '<em><b>Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Class</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Class</em>' attribute.
   * @see #setClass(String)
   * @see at.jku.weiner.c.c.CPackage#getStorageClassSpecifier_Class()
   * @model
   * @generated
   */
  String getClass_();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.StorageClassSpecifier#getClass_ <em>Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Class</em>' attribute.
   * @see #getClass_()
   * @generated
   */
  void setClass(String value);

} // StorageClassSpecifier
