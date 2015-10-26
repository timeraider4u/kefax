/**
 */
package at.jku.weiner.c.c;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Struct Declarator List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.StructDeclaratorList#getStructDeclarator <em>Struct Declarator</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.c.CPackage#getStructDeclaratorList()
 * @model
 * @generated
 */
public interface StructDeclaratorList extends EObject
{
  /**
   * Returns the value of the '<em><b>Struct Declarator</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.c.StructDeclarator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Struct Declarator</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Struct Declarator</em>' containment reference list.
   * @see at.jku.weiner.c.c.CPackage#getStructDeclaratorList_StructDeclarator()
   * @model containment="true"
   * @generated
   */
  EList<StructDeclarator> getStructDeclarator();

} // StructDeclaratorList
