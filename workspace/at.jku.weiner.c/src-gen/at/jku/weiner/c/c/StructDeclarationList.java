/**
 */
package at.jku.weiner.c.c;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Struct Declaration List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.StructDeclarationList#getStructDeclaration <em>Struct Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.c.CPackage#getStructDeclarationList()
 * @model
 * @generated
 */
public interface StructDeclarationList extends EObject
{
  /**
   * Returns the value of the '<em><b>Struct Declaration</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.c.StructDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Struct Declaration</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Struct Declaration</em>' containment reference list.
   * @see at.jku.weiner.c.c.CPackage#getStructDeclarationList_StructDeclaration()
   * @model containment="true"
   * @generated
   */
  EList<StructDeclaration> getStructDeclaration();

} // StructDeclarationList
