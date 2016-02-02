/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.Declaration#getSpecifiers <em>Specifiers</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.Declaration#getInitDeclaratorList <em>Init Declarator List</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getDeclaration()
 * @model
 * @generated
 */
public interface Declaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Specifiers</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Specifiers</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Specifiers</em>' containment reference.
   * @see #setSpecifiers(DeclarationSpecifiers)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getDeclaration_Specifiers()
   * @model containment="true"
   * @generated
   */
  DeclarationSpecifiers getSpecifiers();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.Declaration#getSpecifiers <em>Specifiers</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Specifiers</em>' containment reference.
   * @see #getSpecifiers()
   * @generated
   */
  void setSpecifiers(DeclarationSpecifiers value);

  /**
   * Returns the value of the '<em><b>Init Declarator List</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.parser.parser.InitDeclaratorList}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Init Declarator List</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Init Declarator List</em>' containment reference list.
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getDeclaration_InitDeclaratorList()
   * @model containment="true"
   * @generated
   */
  EList<InitDeclaratorList> getInitDeclaratorList();

} // Declaration
