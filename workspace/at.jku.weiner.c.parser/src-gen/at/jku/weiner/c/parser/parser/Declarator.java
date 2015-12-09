/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Declarator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.Declarator#getPointer <em>Pointer</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.Declarator#getDeclarator <em>Declarator</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getDeclarator()
 * @model
 * @generated
 */
public interface Declarator extends EObject
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
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getDeclarator_Pointer()
   * @model containment="true"
   * @generated
   */
  Pointer getPointer();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.Declarator#getPointer <em>Pointer</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pointer</em>' containment reference.
   * @see #getPointer()
   * @generated
   */
  void setPointer(Pointer value);

  /**
   * Returns the value of the '<em><b>Declarator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Declarator</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Declarator</em>' containment reference.
   * @see #setDeclarator(DirectDeclarator)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getDeclarator_Declarator()
   * @model containment="true"
   * @generated
   */
  DirectDeclarator getDeclarator();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.Declarator#getDeclarator <em>Declarator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Declarator</em>' containment reference.
   * @see #getDeclarator()
   * @generated
   */
  void setDeclarator(DirectDeclarator value);

} // Declarator
