/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.ParameterDeclaration#getDeclSpecifiers <em>Decl Specifiers</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.ParameterDeclaration#getDeclarator <em>Declarator</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getParameterDeclaration()
 * @model
 * @generated
 */
public interface ParameterDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Decl Specifiers</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Decl Specifiers</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decl Specifiers</em>' containment reference.
   * @see #setDeclSpecifiers(DeclarationSpecifiers)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getParameterDeclaration_DeclSpecifiers()
   * @model containment="true"
   * @generated
   */
  DeclarationSpecifiers getDeclSpecifiers();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.ParameterDeclaration#getDeclSpecifiers <em>Decl Specifiers</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Decl Specifiers</em>' containment reference.
   * @see #getDeclSpecifiers()
   * @generated
   */
  void setDeclSpecifiers(DeclarationSpecifiers value);

  /**
   * Returns the value of the '<em><b>Declarator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Declarator</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Declarator</em>' containment reference.
   * @see #setDeclarator(Declarator)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getParameterDeclaration_Declarator()
   * @model containment="true"
   * @generated
   */
  Declarator getDeclarator();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.ParameterDeclaration#getDeclarator <em>Declarator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Declarator</em>' containment reference.
   * @see #getDeclarator()
   * @generated
   */
  void setDeclarator(Declarator value);

} // ParameterDeclaration
