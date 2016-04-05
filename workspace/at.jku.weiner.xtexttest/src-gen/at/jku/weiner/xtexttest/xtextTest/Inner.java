/**
 */
package at.jku.weiner.xtexttest.xtextTest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inner</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.Inner#getParameter <em>Parameter</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.Inner#getAssign <em>Assign</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.Inner#getAssignList <em>Assign List</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.Inner#getValue <em>Value</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.Inner#getAssignAsData <em>Assign As Data</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.Inner#getAssignAsBool <em>Assign As Bool</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.Inner#isIsNull <em>Is Null</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.Inner#isIsNotNull <em>Is Not Null</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.Inner#isIsEmpty <em>Is Empty</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getInner()
 * @model
 * @generated
 */
public interface Inner extends EObject
{
  /**
   * Returns the value of the '<em><b>Parameter</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter</em>' attribute.
   * @see #setParameter(String)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getInner_Parameter()
   * @model
   * @generated
   */
  String getParameter();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.Inner#getParameter <em>Parameter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameter</em>' attribute.
   * @see #getParameter()
   * @generated
   */
  void setParameter(String value);

  /**
   * Returns the value of the '<em><b>Assign</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assign</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assign</em>' containment reference.
   * @see #setAssign(Element)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getInner_Assign()
   * @model containment="true"
   * @generated
   */
  Element getAssign();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.Inner#getAssign <em>Assign</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assign</em>' containment reference.
   * @see #getAssign()
   * @generated
   */
  void setAssign(Element value);

  /**
   * Returns the value of the '<em><b>Assign List</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.xtexttest.xtextTest.Element}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assign List</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assign List</em>' containment reference list.
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getInner_AssignList()
   * @model containment="true"
   * @generated
   */
  EList<Element> getAssignList();

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getInner_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.Inner#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

  /**
   * Returns the value of the '<em><b>Assign As Data</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assign As Data</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assign As Data</em>' attribute.
   * @see #setAssignAsData(String)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getInner_AssignAsData()
   * @model
   * @generated
   */
  String getAssignAsData();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.Inner#getAssignAsData <em>Assign As Data</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assign As Data</em>' attribute.
   * @see #getAssignAsData()
   * @generated
   */
  void setAssignAsData(String value);

  /**
   * Returns the value of the '<em><b>Assign As Bool</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assign As Bool</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assign As Bool</em>' attribute.
   * @see #setAssignAsBool(String)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getInner_AssignAsBool()
   * @model
   * @generated
   */
  String getAssignAsBool();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.Inner#getAssignAsBool <em>Assign As Bool</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assign As Bool</em>' attribute.
   * @see #getAssignAsBool()
   * @generated
   */
  void setAssignAsBool(String value);

  /**
   * Returns the value of the '<em><b>Is Null</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Null</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Null</em>' attribute.
   * @see #setIsNull(boolean)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getInner_IsNull()
   * @model
   * @generated
   */
  boolean isIsNull();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.Inner#isIsNull <em>Is Null</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Null</em>' attribute.
   * @see #isIsNull()
   * @generated
   */
  void setIsNull(boolean value);

  /**
   * Returns the value of the '<em><b>Is Not Null</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Not Null</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Not Null</em>' attribute.
   * @see #setIsNotNull(boolean)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getInner_IsNotNull()
   * @model
   * @generated
   */
  boolean isIsNotNull();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.Inner#isIsNotNull <em>Is Not Null</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Not Null</em>' attribute.
   * @see #isIsNotNull()
   * @generated
   */
  void setIsNotNull(boolean value);

  /**
   * Returns the value of the '<em><b>Is Empty</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Empty</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Empty</em>' attribute.
   * @see #setIsEmpty(boolean)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getInner_IsEmpty()
   * @model
   * @generated
   */
  boolean isIsEmpty();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.Inner#isIsEmpty <em>Is Empty</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Empty</em>' attribute.
   * @see #isIsEmpty()
   * @generated
   */
  void setIsEmpty(boolean value);

} // Inner
