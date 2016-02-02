/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Init</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.Init#getDesignation <em>Designation</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.Init#getInitializer <em>Initializer</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getInit()
 * @model
 * @generated
 */
public interface Init extends EObject
{
  /**
   * Returns the value of the '<em><b>Designation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Designation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Designation</em>' containment reference.
   * @see #setDesignation(Designation)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getInit_Designation()
   * @model containment="true"
   * @generated
   */
  Designation getDesignation();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.Init#getDesignation <em>Designation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Designation</em>' containment reference.
   * @see #getDesignation()
   * @generated
   */
  void setDesignation(Designation value);

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
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getInit_Initializer()
   * @model containment="true"
   * @generated
   */
  Initializer getInitializer();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.Init#getInitializer <em>Initializer</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initializer</em>' containment reference.
   * @see #getInitializer()
   * @generated
   */
  void setInitializer(Initializer value);

} // Init
