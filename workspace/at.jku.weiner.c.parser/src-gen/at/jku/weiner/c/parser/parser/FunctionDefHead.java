/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Def Head</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.FunctionDefHead#getFunDeclSpecifiers <em>Fun Decl Specifiers</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.FunctionDefHead#getFunDeclarator <em>Fun Declarator</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.FunctionDefHead#getFunDeclaration <em>Fun Declaration</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getFunctionDefHead()
 * @model
 * @generated
 */
public interface FunctionDefHead extends EObject
{
  /**
   * Returns the value of the '<em><b>Fun Decl Specifiers</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fun Decl Specifiers</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fun Decl Specifiers</em>' containment reference.
   * @see #setFunDeclSpecifiers(FunctionDeclarationSpecifiers)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getFunctionDefHead_FunDeclSpecifiers()
   * @model containment="true"
   * @generated
   */
  FunctionDeclarationSpecifiers getFunDeclSpecifiers();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.FunctionDefHead#getFunDeclSpecifiers <em>Fun Decl Specifiers</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fun Decl Specifiers</em>' containment reference.
   * @see #getFunDeclSpecifiers()
   * @generated
   */
  void setFunDeclSpecifiers(FunctionDeclarationSpecifiers value);

  /**
   * Returns the value of the '<em><b>Fun Declarator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fun Declarator</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fun Declarator</em>' containment reference.
   * @see #setFunDeclarator(Declarator)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getFunctionDefHead_FunDeclarator()
   * @model containment="true"
   * @generated
   */
  Declarator getFunDeclarator();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.FunctionDefHead#getFunDeclarator <em>Fun Declarator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fun Declarator</em>' containment reference.
   * @see #getFunDeclarator()
   * @generated
   */
  void setFunDeclarator(Declarator value);

  /**
   * Returns the value of the '<em><b>Fun Declaration</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.parser.parser.Declaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fun Declaration</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fun Declaration</em>' containment reference list.
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getFunctionDefHead_FunDeclaration()
   * @model containment="true"
   * @generated
   */
  EList<Declaration> getFunDeclaration();

} // FunctionDefHead
