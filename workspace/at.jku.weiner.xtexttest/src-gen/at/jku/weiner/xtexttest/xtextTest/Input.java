/**
 */
package at.jku.weiner.xtexttest.xtextTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.Input#getText <em>Text</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.Input#getFile <em>File</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getInput()
 * @model
 * @generated
 */
public interface Input extends EObject
{
  /**
   * Returns the value of the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Text</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Text</em>' attribute.
   * @see #setText(String)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getInput_Text()
   * @model
   * @generated
   */
  String getText();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.Input#getText <em>Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Text</em>' attribute.
   * @see #getText()
   * @generated
   */
  void setText(String value);

  /**
   * Returns the value of the '<em><b>File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>File</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>File</em>' attribute.
   * @see #setFile(String)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getInput_File()
   * @model
   * @generated
   */
  String getFile();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.Input#getFile <em>File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>File</em>' attribute.
   * @see #getFile()
   * @generated
   */
  void setFile(String value);

} // Input
