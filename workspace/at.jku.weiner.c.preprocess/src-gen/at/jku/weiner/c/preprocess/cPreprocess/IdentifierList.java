/**
 */
package at.jku.weiner.c.preprocess.cPreprocess;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifier List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.cPreprocess.IdentifierList#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.preprocess.cPreprocess.CPreprocessPackage#getIdentifierList()
 * @model
 * @generated
 */
public interface IdentifierList extends EObject
{
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute list.
   * @see at.jku.weiner.c.preprocess.cPreprocess.CPreprocessPackage#getIdentifierList_Id()
   * @model unique="false"
   * @generated
   */
  EList<String> getId();

} // IdentifierList
