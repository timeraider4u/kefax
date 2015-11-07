/**
 */
package at.jku.weiner.xtexttest.xtextTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xtext Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.XtextTest#getPackage <em>Package</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.XtextTest#getLang <em>Lang</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.XtextTest#getInput <em>Input</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.XtextTest#getTokens <em>Tokens</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.XtextTest#getRoot <em>Root</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.XtextTest#getOutput <em>Output</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getXtextTest()
 * @model
 * @generated
 */
public interface XtextTest extends EObject
{
  /**
   * Returns the value of the '<em><b>Package</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Package</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Package</em>' attribute.
   * @see #setPackage(String)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getXtextTest_Package()
   * @model
   * @generated
   */
  String getPackage();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.XtextTest#getPackage <em>Package</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Package</em>' attribute.
   * @see #getPackage()
   * @generated
   */
  void setPackage(String value);

  /**
   * Returns the value of the '<em><b>Lang</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lang</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lang</em>' attribute.
   * @see #setLang(String)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getXtextTest_Lang()
   * @model
   * @generated
   */
  String getLang();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.XtextTest#getLang <em>Lang</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lang</em>' attribute.
   * @see #getLang()
   * @generated
   */
  void setLang(String value);

  /**
   * Returns the value of the '<em><b>Input</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Input</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Input</em>' containment reference.
   * @see #setInput(Input)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getXtextTest_Input()
   * @model containment="true"
   * @generated
   */
  Input getInput();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.XtextTest#getInput <em>Input</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Input</em>' containment reference.
   * @see #getInput()
   * @generated
   */
  void setInput(Input value);

  /**
   * Returns the value of the '<em><b>Tokens</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tokens</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tokens</em>' containment reference.
   * @see #setTokens(Tokens)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getXtextTest_Tokens()
   * @model containment="true"
   * @generated
   */
  Tokens getTokens();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.XtextTest#getTokens <em>Tokens</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tokens</em>' containment reference.
   * @see #getTokens()
   * @generated
   */
  void setTokens(Tokens value);

  /**
   * Returns the value of the '<em><b>Root</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Root</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Root</em>' containment reference.
   * @see #setRoot(Element)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getXtextTest_Root()
   * @model containment="true"
   * @generated
   */
  Element getRoot();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.XtextTest#getRoot <em>Root</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Root</em>' containment reference.
   * @see #getRoot()
   * @generated
   */
  void setRoot(Element value);

  /**
   * Returns the value of the '<em><b>Output</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Output</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Output</em>' containment reference.
   * @see #setOutput(Generator)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getXtextTest_Output()
   * @model containment="true"
   * @generated
   */
  Generator getOutput();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.XtextTest#getOutput <em>Output</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Output</em>' containment reference.
   * @see #getOutput()
   * @generated
   */
  void setOutput(Generator value);

} // XtextTest
