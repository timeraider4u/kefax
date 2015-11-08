/**
 */
package at.jku.weiner.xtexttest.xtextTest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.Generator#getOutput <em>Output</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.Generator#getExpected <em>Expected</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.Generator#isIsSameAsInputFile <em>Is Same As Input File</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.Generator#getPatternFile <em>Pattern File</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.Generator#getReplacePatterns <em>Replace Patterns</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getGenerator()
 * @model
 * @generated
 */
public interface Generator extends EObject
{
  /**
   * Returns the value of the '<em><b>Output</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Output</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Output</em>' attribute.
   * @see #setOutput(String)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getGenerator_Output()
   * @model
   * @generated
   */
  String getOutput();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.Generator#getOutput <em>Output</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Output</em>' attribute.
   * @see #getOutput()
   * @generated
   */
  void setOutput(String value);

  /**
   * Returns the value of the '<em><b>Expected</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expected</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expected</em>' attribute.
   * @see #setExpected(String)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getGenerator_Expected()
   * @model
   * @generated
   */
  String getExpected();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.Generator#getExpected <em>Expected</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expected</em>' attribute.
   * @see #getExpected()
   * @generated
   */
  void setExpected(String value);

  /**
   * Returns the value of the '<em><b>Is Same As Input File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Same As Input File</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Same As Input File</em>' attribute.
   * @see #setIsSameAsInputFile(boolean)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getGenerator_IsSameAsInputFile()
   * @model
   * @generated
   */
  boolean isIsSameAsInputFile();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.Generator#isIsSameAsInputFile <em>Is Same As Input File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Same As Input File</em>' attribute.
   * @see #isIsSameAsInputFile()
   * @generated
   */
  void setIsSameAsInputFile(boolean value);

  /**
   * Returns the value of the '<em><b>Pattern File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pattern File</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pattern File</em>' attribute.
   * @see #setPatternFile(String)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getGenerator_PatternFile()
   * @model
   * @generated
   */
  String getPatternFile();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.Generator#getPatternFile <em>Pattern File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pattern File</em>' attribute.
   * @see #getPatternFile()
   * @generated
   */
  void setPatternFile(String value);

  /**
   * Returns the value of the '<em><b>Replace Patterns</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.xtexttest.xtextTest.ReplacePatterns}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Replace Patterns</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Replace Patterns</em>' containment reference list.
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getGenerator_ReplacePatterns()
   * @model containment="true"
   * @generated
   */
  EList<ReplacePatterns> getReplacePatterns();

} // Generator
