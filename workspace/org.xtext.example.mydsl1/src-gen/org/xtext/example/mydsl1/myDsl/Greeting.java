/**
 */
package org.xtext.example.mydsl1.myDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Greeting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl1.myDsl.Greeting#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.example.mydsl1.myDsl.Greeting#getTest <em>Test</em>}</li>
 *   <li>{@link org.xtext.example.mydsl1.myDsl.Greeting#getReset <em>Reset</em>}</li>
 *   <li>{@link org.xtext.example.mydsl1.myDsl.Greeting#getInc <em>Inc</em>}</li>
 *   <li>{@link org.xtext.example.mydsl1.myDsl.Greeting#getDynamic <em>Dynamic</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl1.myDsl.MyDslPackage#getGreeting()
 * @model
 * @generated
 */
public interface Greeting extends EObject
{
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
   * @see org.xtext.example.mydsl1.myDsl.MyDslPackage#getGreeting_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl1.myDsl.Greeting#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Test</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Test</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Test</em>' containment reference.
   * @see #setTest(Test)
   * @see org.xtext.example.mydsl1.myDsl.MyDslPackage#getGreeting_Test()
   * @model containment="true"
   * @generated
   */
  Test getTest();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl1.myDsl.Greeting#getTest <em>Test</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Test</em>' containment reference.
   * @see #getTest()
   * @generated
   */
  void setTest(Test value);

  /**
   * Returns the value of the '<em><b>Reset</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reset</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reset</em>' containment reference.
   * @see #setReset(Reset)
   * @see org.xtext.example.mydsl1.myDsl.MyDslPackage#getGreeting_Reset()
   * @model containment="true"
   * @generated
   */
  Reset getReset();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl1.myDsl.Greeting#getReset <em>Reset</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reset</em>' containment reference.
   * @see #getReset()
   * @generated
   */
  void setReset(Reset value);

  /**
   * Returns the value of the '<em><b>Inc</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl1.myDsl.Inc}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inc</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inc</em>' containment reference list.
   * @see org.xtext.example.mydsl1.myDsl.MyDslPackage#getGreeting_Inc()
   * @model containment="true"
   * @generated
   */
  EList<Inc> getInc();

  /**
   * Returns the value of the '<em><b>Dynamic</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dynamic</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dynamic</em>' containment reference.
   * @see #setDynamic(Dynamic)
   * @see org.xtext.example.mydsl1.myDsl.MyDslPackage#getGreeting_Dynamic()
   * @model containment="true"
   * @generated
   */
  Dynamic getDynamic();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl1.myDsl.Greeting#getDynamic <em>Dynamic</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dynamic</em>' containment reference.
   * @see #getDynamic()
   * @generated
   */
  void setDynamic(Dynamic value);

} // Greeting
