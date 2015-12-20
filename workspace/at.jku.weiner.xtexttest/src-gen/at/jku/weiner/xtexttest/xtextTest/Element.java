/**
 */
package at.jku.weiner.xtexttest.xtextTest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.Element#getImporting <em>Importing</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.Element#getName <em>Name</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.Element#getInner <em>Inner</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getElement()
 * @model
 * @generated
 */
public interface Element extends EObject
{
  /**
   * Returns the value of the '<em><b>Importing</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Importing</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Importing</em>' attribute.
   * @see #setImporting(String)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getElement_Importing()
   * @model
   * @generated
   */
  String getImporting();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.Element#getImporting <em>Importing</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Importing</em>' attribute.
   * @see #getImporting()
   * @generated
   */
  void setImporting(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getElement_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.Element#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Inner</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.xtexttest.xtextTest.Inner}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inner</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inner</em>' containment reference list.
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getElement_Inner()
   * @model containment="true"
   * @generated
   */
  EList<Inner> getInner();

} // Element
