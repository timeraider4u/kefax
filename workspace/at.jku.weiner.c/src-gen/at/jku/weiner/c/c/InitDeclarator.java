/**
 */
package at.jku.weiner.c.c;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Init Declarator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.InitDeclarator#getDeclarator <em>Declarator</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.InitDeclarator#getInitializer <em>Initializer</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.c.CPackage#getInitDeclarator()
 * @model
 * @generated
 */
public interface InitDeclarator extends EObject
{
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
   * @see at.jku.weiner.c.c.CPackage#getInitDeclarator_Declarator()
   * @model containment="true"
   * @generated
   */
  Declarator getDeclarator();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.InitDeclarator#getDeclarator <em>Declarator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Declarator</em>' containment reference.
   * @see #getDeclarator()
   * @generated
   */
  void setDeclarator(Declarator value);

  /**
   * Returns the value of the '<em><b>Initializer</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initializer</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initializer</em>' containment reference.
   * @see #setInitializer(Initializer)
   * @see at.jku.weiner.c.c.CPackage#getInitDeclarator_Initializer()
   * @model containment="true"
   * @generated
   */
  Initializer getInitializer();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.InitDeclarator#getInitializer <em>Initializer</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initializer</em>' containment reference.
   * @see #getInitializer()
   * @generated
   */
  void setInitializer(Initializer value);

} // InitDeclarator
