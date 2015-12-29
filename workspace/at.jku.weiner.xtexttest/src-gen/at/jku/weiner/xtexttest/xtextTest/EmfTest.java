/**
 */
package at.jku.weiner.xtexttest.xtextTest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Emf Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.EmfTest#getPackage <em>Package</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.EmfTest#getMydefault <em>Mydefault</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.EmfTest#getMyimport <em>Myimport</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.EmfTest#getCodeCall <em>Code Call</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.EmfTest#getFile <em>File</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.EmfTest#getRoot <em>Root</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getEmfTest()
 * @model
 * @generated
 */
public interface EmfTest extends EObject
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
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getEmfTest_Package()
   * @model
   * @generated
   */
  String getPackage();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.EmfTest#getPackage <em>Package</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Package</em>' attribute.
   * @see #getPackage()
   * @generated
   */
  void setPackage(String value);

  /**
   * Returns the value of the '<em><b>Mydefault</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mydefault</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mydefault</em>' attribute.
   * @see #setMydefault(String)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getEmfTest_Mydefault()
   * @model
   * @generated
   */
  String getMydefault();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.EmfTest#getMydefault <em>Mydefault</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mydefault</em>' attribute.
   * @see #getMydefault()
   * @generated
   */
  void setMydefault(String value);

  /**
   * Returns the value of the '<em><b>Myimport</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.xtexttest.xtextTest.Import}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Myimport</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Myimport</em>' containment reference list.
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getEmfTest_Myimport()
   * @model containment="true"
   * @generated
   */
  EList<Import> getMyimport();

  /**
   * Returns the value of the '<em><b>Code Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Code Call</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Code Call</em>' containment reference.
   * @see #setCodeCall(CodeCall)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getEmfTest_CodeCall()
   * @model containment="true"
   * @generated
   */
  CodeCall getCodeCall();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.EmfTest#getCodeCall <em>Code Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Code Call</em>' containment reference.
   * @see #getCodeCall()
   * @generated
   */
  void setCodeCall(CodeCall value);

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
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getEmfTest_File()
   * @model
   * @generated
   */
  String getFile();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.EmfTest#getFile <em>File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>File</em>' attribute.
   * @see #getFile()
   * @generated
   */
  void setFile(String value);

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
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getEmfTest_Root()
   * @model containment="true"
   * @generated
   */
  Element getRoot();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.EmfTest#getRoot <em>Root</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Root</em>' containment reference.
   * @see #getRoot()
   * @generated
   */
  void setRoot(Element value);

} // EmfTest
