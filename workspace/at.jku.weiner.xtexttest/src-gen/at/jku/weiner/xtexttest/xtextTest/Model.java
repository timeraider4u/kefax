/**
 */
package at.jku.weiner.xtexttest.xtextTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.Model#getXtextTest <em>Xtext Test</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.Model#getEmfTest <em>Emf Test</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Xtext Test</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Xtext Test</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Xtext Test</em>' containment reference.
   * @see #setXtextTest(XtextTest)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getModel_XtextTest()
   * @model containment="true"
   * @generated
   */
  XtextTest getXtextTest();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.Model#getXtextTest <em>Xtext Test</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Xtext Test</em>' containment reference.
   * @see #getXtextTest()
   * @generated
   */
  void setXtextTest(XtextTest value);

  /**
   * Returns the value of the '<em><b>Emf Test</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Emf Test</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Emf Test</em>' containment reference.
   * @see #setEmfTest(EmfTest)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getModel_EmfTest()
   * @model containment="true"
   * @generated
   */
  EmfTest getEmfTest();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.Model#getEmfTest <em>Emf Test</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Emf Test</em>' containment reference.
   * @see #getEmfTest()
   * @generated
   */
  void setEmfTest(EmfTest value);

} // Model
