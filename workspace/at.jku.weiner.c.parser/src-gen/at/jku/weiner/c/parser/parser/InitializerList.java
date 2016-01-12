/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Initializer List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.InitializerList#getDesignation <em>Designation</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.InitializerList#getInitializer <em>Initializer</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getInitializerList()
 * @model
 * @generated
 */
public interface InitializerList extends EObject
{
  /**
   * Returns the value of the '<em><b>Designation</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.parser.parser.Designation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Designation</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Designation</em>' containment reference list.
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getInitializerList_Designation()
   * @model containment="true"
   * @generated
   */
  EList<Designation> getDesignation();

  /**
   * Returns the value of the '<em><b>Initializer</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.parser.parser.Initializer}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initializer</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initializer</em>' containment reference list.
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getInitializerList_Initializer()
   * @model containment="true"
   * @generated
   */
  EList<Initializer> getInitializer();

} // InitializerList
