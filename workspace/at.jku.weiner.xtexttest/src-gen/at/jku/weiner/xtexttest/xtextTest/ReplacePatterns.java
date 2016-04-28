/**
 */
package at.jku.weiner.xtexttest.xtextTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Replace Patterns</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.ReplacePatterns#getRegex <em>Regex</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.ReplacePatterns#getReplace <em>Replace</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getReplacePatterns()
 * @model
 * @generated
 */
public interface ReplacePatterns extends EObject
{
  /**
   * Returns the value of the '<em><b>Regex</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Regex</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Regex</em>' attribute.
   * @see #setRegex(String)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getReplacePatterns_Regex()
   * @model
   * @generated
   */
  String getRegex();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.ReplacePatterns#getRegex <em>Regex</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Regex</em>' attribute.
   * @see #getRegex()
   * @generated
   */
  void setRegex(String value);

  /**
   * Returns the value of the '<em><b>Replace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Replace</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Replace</em>' attribute.
   * @see #setReplace(String)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getReplacePatterns_Replace()
   * @model
   * @generated
   */
  String getReplace();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.ReplacePatterns#getReplace <em>Replace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Replace</em>' attribute.
   * @see #getReplace()
   * @generated
   */
  void setReplace(String value);

} // ReplacePatterns
