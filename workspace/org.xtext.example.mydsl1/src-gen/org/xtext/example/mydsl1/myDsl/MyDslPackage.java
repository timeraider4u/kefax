/**
 */
package org.xtext.example.mydsl1.myDsl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.xtext.example.mydsl1.myDsl.MyDslFactory
 * @model kind="package"
 * @generated
 */
public interface MyDslPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "myDsl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.xtext.org/example/mydsl1/MyDsl";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "myDsl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MyDslPackage eINSTANCE = org.xtext.example.mydsl1.myDsl.impl.MyDslPackageImpl.init();

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl1.myDsl.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl1.myDsl.impl.ModelImpl
   * @see org.xtext.example.mydsl1.myDsl.impl.MyDslPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Greetings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__GREETINGS = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl1.myDsl.impl.GreetingImpl <em>Greeting</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl1.myDsl.impl.GreetingImpl
   * @see org.xtext.example.mydsl1.myDsl.impl.MyDslPackageImpl#getGreeting()
   * @generated
   */
  int GREETING = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREETING__NAME = 0;

  /**
   * The feature id for the '<em><b>Test</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREETING__TEST = 1;

  /**
   * The feature id for the '<em><b>Reset</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREETING__RESET = 2;

  /**
   * The feature id for the '<em><b>Inc</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREETING__INC = 3;

  /**
   * The feature id for the '<em><b>Dynamic</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREETING__DYNAMIC = 4;

  /**
   * The number of structural features of the '<em>Greeting</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREETING_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl1.myDsl.impl.TestImpl <em>Test</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl1.myDsl.impl.TestImpl
   * @see org.xtext.example.mydsl1.myDsl.impl.MyDslPackageImpl#getTest()
   * @generated
   */
  int TEST = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST__NAME = 0;

  /**
   * The number of structural features of the '<em>Test</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl1.myDsl.impl.ResetImpl <em>Reset</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl1.myDsl.impl.ResetImpl
   * @see org.xtext.example.mydsl1.myDsl.impl.MyDslPackageImpl#getReset()
   * @generated
   */
  int RESET = 3;

  /**
   * The feature id for the '<em><b>Reset</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESET__RESET = 0;

  /**
   * The number of structural features of the '<em>Reset</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESET_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl1.myDsl.impl.IncImpl <em>Inc</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl1.myDsl.impl.IncImpl
   * @see org.xtext.example.mydsl1.myDsl.impl.MyDslPackageImpl#getInc()
   * @generated
   */
  int INC = 4;

  /**
   * The feature id for the '<em><b>Inc</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INC__INC = 0;

  /**
   * The number of structural features of the '<em>Inc</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INC_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl1.myDsl.impl.DynamicImpl <em>Dynamic</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl1.myDsl.impl.DynamicImpl
   * @see org.xtext.example.mydsl1.myDsl.impl.MyDslPackageImpl#getDynamic()
   * @generated
   */
  int DYNAMIC = 5;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DYNAMIC__TYPE = 0;

  /**
   * The number of structural features of the '<em>Dynamic</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DYNAMIC_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl1.myDsl.impl.TypeAImpl <em>Type A</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl1.myDsl.impl.TypeAImpl
   * @see org.xtext.example.mydsl1.myDsl.impl.MyDslPackageImpl#getTypeA()
   * @generated
   */
  int TYPE_A = 6;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_A__TYPE = 0;

  /**
   * The number of structural features of the '<em>Type A</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_A_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl1.myDsl.impl.TypeBImpl <em>Type B</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl1.myDsl.impl.TypeBImpl
   * @see org.xtext.example.mydsl1.myDsl.impl.MyDslPackageImpl#getTypeB()
   * @generated
   */
  int TYPE_B = 7;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_B__TYPE = 0;

  /**
   * The number of structural features of the '<em>Type B</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_B_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl1.myDsl.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.xtext.example.mydsl1.myDsl.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.example.mydsl1.myDsl.Model#getGreetings <em>Greetings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Greetings</em>'.
   * @see org.xtext.example.mydsl1.myDsl.Model#getGreetings()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Greetings();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl1.myDsl.Greeting <em>Greeting</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Greeting</em>'.
   * @see org.xtext.example.mydsl1.myDsl.Greeting
   * @generated
   */
  EClass getGreeting();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl1.myDsl.Greeting#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.xtext.example.mydsl1.myDsl.Greeting#getName()
   * @see #getGreeting()
   * @generated
   */
  EAttribute getGreeting_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl1.myDsl.Greeting#getTest <em>Test</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Test</em>'.
   * @see org.xtext.example.mydsl1.myDsl.Greeting#getTest()
   * @see #getGreeting()
   * @generated
   */
  EReference getGreeting_Test();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl1.myDsl.Greeting#getReset <em>Reset</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Reset</em>'.
   * @see org.xtext.example.mydsl1.myDsl.Greeting#getReset()
   * @see #getGreeting()
   * @generated
   */
  EReference getGreeting_Reset();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.example.mydsl1.myDsl.Greeting#getInc <em>Inc</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Inc</em>'.
   * @see org.xtext.example.mydsl1.myDsl.Greeting#getInc()
   * @see #getGreeting()
   * @generated
   */
  EReference getGreeting_Inc();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl1.myDsl.Greeting#getDynamic <em>Dynamic</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Dynamic</em>'.
   * @see org.xtext.example.mydsl1.myDsl.Greeting#getDynamic()
   * @see #getGreeting()
   * @generated
   */
  EReference getGreeting_Dynamic();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl1.myDsl.Test <em>Test</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Test</em>'.
   * @see org.xtext.example.mydsl1.myDsl.Test
   * @generated
   */
  EClass getTest();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl1.myDsl.Test#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.xtext.example.mydsl1.myDsl.Test#getName()
   * @see #getTest()
   * @generated
   */
  EAttribute getTest_Name();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl1.myDsl.Reset <em>Reset</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reset</em>'.
   * @see org.xtext.example.mydsl1.myDsl.Reset
   * @generated
   */
  EClass getReset();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl1.myDsl.Reset#getReset <em>Reset</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Reset</em>'.
   * @see org.xtext.example.mydsl1.myDsl.Reset#getReset()
   * @see #getReset()
   * @generated
   */
  EAttribute getReset_Reset();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl1.myDsl.Inc <em>Inc</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Inc</em>'.
   * @see org.xtext.example.mydsl1.myDsl.Inc
   * @generated
   */
  EClass getInc();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl1.myDsl.Inc#getInc <em>Inc</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Inc</em>'.
   * @see org.xtext.example.mydsl1.myDsl.Inc#getInc()
   * @see #getInc()
   * @generated
   */
  EAttribute getInc_Inc();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl1.myDsl.Dynamic <em>Dynamic</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dynamic</em>'.
   * @see org.xtext.example.mydsl1.myDsl.Dynamic
   * @generated
   */
  EClass getDynamic();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl1.myDsl.Dynamic#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.xtext.example.mydsl1.myDsl.Dynamic#getType()
   * @see #getDynamic()
   * @generated
   */
  EReference getDynamic_Type();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl1.myDsl.TypeA <em>Type A</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type A</em>'.
   * @see org.xtext.example.mydsl1.myDsl.TypeA
   * @generated
   */
  EClass getTypeA();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl1.myDsl.TypeA#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.xtext.example.mydsl1.myDsl.TypeA#getType()
   * @see #getTypeA()
   * @generated
   */
  EAttribute getTypeA_Type();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl1.myDsl.TypeB <em>Type B</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type B</em>'.
   * @see org.xtext.example.mydsl1.myDsl.TypeB
   * @generated
   */
  EClass getTypeB();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl1.myDsl.TypeB#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.xtext.example.mydsl1.myDsl.TypeB#getType()
   * @see #getTypeB()
   * @generated
   */
  EAttribute getTypeB_Type();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  MyDslFactory getMyDslFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl1.myDsl.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl1.myDsl.impl.ModelImpl
     * @see org.xtext.example.mydsl1.myDsl.impl.MyDslPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Greetings</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__GREETINGS = eINSTANCE.getModel_Greetings();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl1.myDsl.impl.GreetingImpl <em>Greeting</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl1.myDsl.impl.GreetingImpl
     * @see org.xtext.example.mydsl1.myDsl.impl.MyDslPackageImpl#getGreeting()
     * @generated
     */
    EClass GREETING = eINSTANCE.getGreeting();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GREETING__NAME = eINSTANCE.getGreeting_Name();

    /**
     * The meta object literal for the '<em><b>Test</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GREETING__TEST = eINSTANCE.getGreeting_Test();

    /**
     * The meta object literal for the '<em><b>Reset</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GREETING__RESET = eINSTANCE.getGreeting_Reset();

    /**
     * The meta object literal for the '<em><b>Inc</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GREETING__INC = eINSTANCE.getGreeting_Inc();

    /**
     * The meta object literal for the '<em><b>Dynamic</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GREETING__DYNAMIC = eINSTANCE.getGreeting_Dynamic();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl1.myDsl.impl.TestImpl <em>Test</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl1.myDsl.impl.TestImpl
     * @see org.xtext.example.mydsl1.myDsl.impl.MyDslPackageImpl#getTest()
     * @generated
     */
    EClass TEST = eINSTANCE.getTest();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEST__NAME = eINSTANCE.getTest_Name();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl1.myDsl.impl.ResetImpl <em>Reset</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl1.myDsl.impl.ResetImpl
     * @see org.xtext.example.mydsl1.myDsl.impl.MyDslPackageImpl#getReset()
     * @generated
     */
    EClass RESET = eINSTANCE.getReset();

    /**
     * The meta object literal for the '<em><b>Reset</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESET__RESET = eINSTANCE.getReset_Reset();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl1.myDsl.impl.IncImpl <em>Inc</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl1.myDsl.impl.IncImpl
     * @see org.xtext.example.mydsl1.myDsl.impl.MyDslPackageImpl#getInc()
     * @generated
     */
    EClass INC = eINSTANCE.getInc();

    /**
     * The meta object literal for the '<em><b>Inc</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INC__INC = eINSTANCE.getInc_Inc();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl1.myDsl.impl.DynamicImpl <em>Dynamic</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl1.myDsl.impl.DynamicImpl
     * @see org.xtext.example.mydsl1.myDsl.impl.MyDslPackageImpl#getDynamic()
     * @generated
     */
    EClass DYNAMIC = eINSTANCE.getDynamic();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DYNAMIC__TYPE = eINSTANCE.getDynamic_Type();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl1.myDsl.impl.TypeAImpl <em>Type A</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl1.myDsl.impl.TypeAImpl
     * @see org.xtext.example.mydsl1.myDsl.impl.MyDslPackageImpl#getTypeA()
     * @generated
     */
    EClass TYPE_A = eINSTANCE.getTypeA();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_A__TYPE = eINSTANCE.getTypeA_Type();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl1.myDsl.impl.TypeBImpl <em>Type B</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl1.myDsl.impl.TypeBImpl
     * @see org.xtext.example.mydsl1.myDsl.impl.MyDslPackageImpl#getTypeB()
     * @generated
     */
    EClass TYPE_B = eINSTANCE.getTypeB();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_B__TYPE = eINSTANCE.getTypeB_Type();

  }

} //MyDslPackage
