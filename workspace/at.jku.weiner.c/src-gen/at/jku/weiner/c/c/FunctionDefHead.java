/**
 */
package at.jku.weiner.c.c;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Def Head</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.FunctionDefHead#getFunDeclSpecifiers <em>Fun Decl Specifiers</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.FunctionDefHead#getFunDeclarator <em>Fun Declarator</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.FunctionDefHead#getFunDeclaration <em>Fun Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.c.CPackage#getFunctionDefHead()
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
   * @see #setFunDeclSpecifiers(DeclarationSpecifiers)
   * @see at.jku.weiner.c.c.CPackage#getFunctionDefHead_FunDeclSpecifiers()
   * @model containment="true"
   * @generated
   */
  DeclarationSpecifiers getFunDeclSpecifiers();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.FunctionDefHead#getFunDeclSpecifiers <em>Fun Decl Specifiers</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fun Decl Specifiers</em>' containment reference.
   * @see #getFunDeclSpecifiers()
   * @generated
   */
  void setFunDeclSpecifiers(DeclarationSpecifiers value);

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
   * @see at.jku.weiner.c.c.CPackage#getFunctionDefHead_FunDeclarator()
   * @model containment="true"
   * @generated
   */
  Declarator getFunDeclarator();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.FunctionDefHead#getFunDeclarator <em>Fun Declarator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fun Declarator</em>' containment reference.
   * @see #getFunDeclarator()
   * @generated
   */
  void setFunDeclarator(Declarator value);

  /**
   * Returns the value of the '<em><b>Fun Declaration</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.c.Declaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fun Declaration</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fun Declaration</em>' containment reference list.
   * @see at.jku.weiner.c.c.CPackage#getFunctionDefHead_FunDeclaration()
   * @model containment="true"
   * @generated
   */
  EList<Declaration> getFunDeclaration();

} // FunctionDefHead
