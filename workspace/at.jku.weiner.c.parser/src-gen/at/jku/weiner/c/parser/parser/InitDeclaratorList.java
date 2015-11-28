/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Init Declarator List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.InitDeclaratorList#getInitDeclarator <em>Init Declarator</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getInitDeclaratorList()
 * @model
 * @generated
 */
public interface InitDeclaratorList extends EObject
{
  /**
   * Returns the value of the '<em><b>Init Declarator</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.parser.parser.InitDeclarator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Init Declarator</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Init Declarator</em>' containment reference list.
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getInitDeclaratorList_InitDeclarator()
   * @model containment="true"
   * @generated
   */
  EList<InitDeclarator> getInitDeclarator();

} // InitDeclaratorList
