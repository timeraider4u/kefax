/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Declarator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.AbstractDeclarator#getPointer <em>Pointer</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.AbstractDeclarator#getDirectAbstractDeclarator <em>Direct Abstract Declarator</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.AbstractDeclarator#getGccDeclExtAbstract <em>Gcc Decl Ext Abstract</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getAbstractDeclarator()
 * @model
 * @generated
 */
public interface AbstractDeclarator extends EObject
{
  /**
   * Returns the value of the '<em><b>Pointer</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pointer</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pointer</em>' containment reference.
   * @see #setPointer(Pointer)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getAbstractDeclarator_Pointer()
   * @model containment="true"
   * @generated
   */
  Pointer getPointer();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.AbstractDeclarator#getPointer <em>Pointer</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pointer</em>' containment reference.
   * @see #getPointer()
   * @generated
   */
  void setPointer(Pointer value);

  /**
   * Returns the value of the '<em><b>Direct Abstract Declarator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Direct Abstract Declarator</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Direct Abstract Declarator</em>' containment reference.
   * @see #setDirectAbstractDeclarator(DirectAbstractDeclarator)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getAbstractDeclarator_DirectAbstractDeclarator()
   * @model containment="true"
   * @generated
   */
  DirectAbstractDeclarator getDirectAbstractDeclarator();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.AbstractDeclarator#getDirectAbstractDeclarator <em>Direct Abstract Declarator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Direct Abstract Declarator</em>' containment reference.
   * @see #getDirectAbstractDeclarator()
   * @generated
   */
  void setDirectAbstractDeclarator(DirectAbstractDeclarator value);

  /**
   * Returns the value of the '<em><b>Gcc Decl Ext Abstract</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.parser.parser.GccDeclaratorExtension}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Gcc Decl Ext Abstract</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Gcc Decl Ext Abstract</em>' containment reference list.
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getAbstractDeclarator_GccDeclExtAbstract()
   * @model containment="true"
   * @generated
   */
  EList<GccDeclaratorExtension> getGccDeclExtAbstract();

} // AbstractDeclarator
