/**
 */
package at.jku.weiner.xtexttest.xtextTest;

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
 * @see at.jku.weiner.xtexttest.xtextTest.XtextTestFactory
 * @model kind="package"
 * @generated
 */
public interface XtextTestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "xtextTest";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.jku.at/weiner/xtexttest/XtextTest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "xtextTest";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  XtextTestPackage eINSTANCE = at.jku.weiner.xtexttest.xtextTest.impl.XtextTestPackageImpl.init();

  /**
   * The meta object id for the '{@link at.jku.weiner.xtexttest.xtextTest.impl.XtextTestImpl <em>Xtext Test</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.xtexttest.xtextTest.impl.XtextTestImpl
   * @see at.jku.weiner.xtexttest.xtextTest.impl.XtextTestPackageImpl#getXtextTest()
   * @generated
   */
  int XTEXT_TEST = 0;

  /**
   * The feature id for the '<em><b>Package</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XTEXT_TEST__PACKAGE = 0;

  /**
   * The feature id for the '<em><b>Lang</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XTEXT_TEST__LANG = 1;

  /**
   * The feature id for the '<em><b>Boolean</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XTEXT_TEST__BOOLEAN = 2;

  /**
   * The feature id for the '<em><b>Input</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XTEXT_TEST__INPUT = 3;

  /**
   * The feature id for the '<em><b>Tokens</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XTEXT_TEST__TOKENS = 4;

  /**
   * The feature id for the '<em><b>Root</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XTEXT_TEST__ROOT = 5;

  /**
   * The feature id for the '<em><b>Output</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XTEXT_TEST__OUTPUT = 6;

  /**
   * The feature id for the '<em><b>Before</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XTEXT_TEST__BEFORE = 7;

  /**
   * The feature id for the '<em><b>After</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XTEXT_TEST__AFTER = 8;

  /**
   * The number of structural features of the '<em>Xtext Test</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XTEXT_TEST_FEATURE_COUNT = 9;

  /**
   * The meta object id for the '{@link at.jku.weiner.xtexttest.xtextTest.impl.InputImpl <em>Input</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.xtexttest.xtextTest.impl.InputImpl
   * @see at.jku.weiner.xtexttest.xtextTest.impl.XtextTestPackageImpl#getInput()
   * @generated
   */
  int INPUT = 1;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT__TEXT = 0;

  /**
   * The feature id for the '<em><b>File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT__FILE = 1;

  /**
   * The number of structural features of the '<em>Input</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.xtexttest.xtextTest.impl.TokensImpl <em>Tokens</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.xtexttest.xtextTest.impl.TokensImpl
   * @see at.jku.weiner.xtexttest.xtextTest.impl.XtextTestPackageImpl#getTokens()
   * @generated
   */
  int TOKENS = 2;

  /**
   * The feature id for the '<em><b>Tokens</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOKENS__TOKENS = 0;

  /**
   * The number of structural features of the '<em>Tokens</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOKENS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.xtexttest.xtextTest.impl.MyTokensImpl <em>My Tokens</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.xtexttest.xtextTest.impl.MyTokensImpl
   * @see at.jku.weiner.xtexttest.xtextTest.impl.XtextTestPackageImpl#getMyTokens()
   * @generated
   */
  int MY_TOKENS = 3;

  /**
   * The feature id for the '<em><b>Token</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_TOKENS__TOKEN = 0;

  /**
   * The feature id for the '<em><b>Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_TOKENS__COUNT = 1;

  /**
   * The number of structural features of the '<em>My Tokens</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_TOKENS_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.xtexttest.xtextTest.impl.ElementImpl <em>Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.xtexttest.xtextTest.impl.ElementImpl
   * @see at.jku.weiner.xtexttest.xtextTest.impl.XtextTestPackageImpl#getElement()
   * @generated
   */
  int ELEMENT = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__NAME = 0;

  /**
   * The feature id for the '<em><b>Inner</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__INNER = 1;

  /**
   * The number of structural features of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.xtexttest.xtextTest.impl.InnerImpl <em>Inner</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.xtexttest.xtextTest.impl.InnerImpl
   * @see at.jku.weiner.xtexttest.xtextTest.impl.XtextTestPackageImpl#getInner()
   * @generated
   */
  int INNER = 5;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INNER__PARAMETER = 0;

  /**
   * The feature id for the '<em><b>Assign</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INNER__ASSIGN = 1;

  /**
   * The feature id for the '<em><b>Assign List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INNER__ASSIGN_LIST = 2;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INNER__VALUE = 3;

  /**
   * The feature id for the '<em><b>Assign As Data</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INNER__ASSIGN_AS_DATA = 4;

  /**
   * The number of structural features of the '<em>Inner</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INNER_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link at.jku.weiner.xtexttest.xtextTest.impl.GeneratorImpl <em>Generator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.xtexttest.xtextTest.impl.GeneratorImpl
   * @see at.jku.weiner.xtexttest.xtextTest.impl.XtextTestPackageImpl#getGenerator()
   * @generated
   */
  int GENERATOR = 6;

  /**
   * The feature id for the '<em><b>Output</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR__OUTPUT = 0;

  /**
   * The feature id for the '<em><b>Expected</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR__EXPECTED = 1;

  /**
   * The feature id for the '<em><b>Is Same As Input File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR__IS_SAME_AS_INPUT_FILE = 2;

  /**
   * The feature id for the '<em><b>Pattern File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR__PATTERN_FILE = 3;

  /**
   * The feature id for the '<em><b>Replace Patterns</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR__REPLACE_PATTERNS = 4;

  /**
   * The feature id for the '<em><b>Exception</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR__EXCEPTION = 5;

  /**
   * The number of structural features of the '<em>Generator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link at.jku.weiner.xtexttest.xtextTest.impl.ReplacePatternsImpl <em>Replace Patterns</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.xtexttest.xtextTest.impl.ReplacePatternsImpl
   * @see at.jku.weiner.xtexttest.xtextTest.impl.XtextTestPackageImpl#getReplacePatterns()
   * @generated
   */
  int REPLACE_PATTERNS = 7;

  /**
   * The feature id for the '<em><b>Regex</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPLACE_PATTERNS__REGEX = 0;

  /**
   * The feature id for the '<em><b>Replace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPLACE_PATTERNS__REPLACE = 1;

  /**
   * The number of structural features of the '<em>Replace Patterns</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPLACE_PATTERNS_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.xtexttest.xtextTest.impl.BeforeImpl <em>Before</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.xtexttest.xtextTest.impl.BeforeImpl
   * @see at.jku.weiner.xtexttest.xtextTest.impl.XtextTestPackageImpl#getBefore()
   * @generated
   */
  int BEFORE = 8;

  /**
   * The feature id for the '<em><b>Myclass</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEFORE__MYCLASS = 0;

  /**
   * The feature id for the '<em><b>Method</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEFORE__METHOD = 1;

  /**
   * The number of structural features of the '<em>Before</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEFORE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.xtexttest.xtextTest.impl.AfterImpl <em>After</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.xtexttest.xtextTest.impl.AfterImpl
   * @see at.jku.weiner.xtexttest.xtextTest.impl.XtextTestPackageImpl#getAfter()
   * @generated
   */
  int AFTER = 9;

  /**
   * The feature id for the '<em><b>Myclass</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFTER__MYCLASS = 0;

  /**
   * The feature id for the '<em><b>Method</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFTER__METHOD = 1;

  /**
   * The number of structural features of the '<em>After</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFTER_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link at.jku.weiner.xtexttest.xtextTest.XtextTest <em>Xtext Test</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Xtext Test</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTest
   * @generated
   */
  EClass getXtextTest();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.xtexttest.xtextTest.XtextTest#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Package</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTest#getPackage()
   * @see #getXtextTest()
   * @generated
   */
  EAttribute getXtextTest_Package();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.xtexttest.xtextTest.XtextTest#getLang <em>Lang</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lang</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTest#getLang()
   * @see #getXtextTest()
   * @generated
   */
  EAttribute getXtextTest_Lang();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.xtexttest.xtextTest.XtextTest#getBoolean <em>Boolean</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Boolean</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTest#getBoolean()
   * @see #getXtextTest()
   * @generated
   */
  EAttribute getXtextTest_Boolean();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.xtexttest.xtextTest.XtextTest#getInput <em>Input</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Input</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTest#getInput()
   * @see #getXtextTest()
   * @generated
   */
  EReference getXtextTest_Input();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.xtexttest.xtextTest.XtextTest#getTokens <em>Tokens</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Tokens</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTest#getTokens()
   * @see #getXtextTest()
   * @generated
   */
  EReference getXtextTest_Tokens();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.xtexttest.xtextTest.XtextTest#getRoot <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Root</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTest#getRoot()
   * @see #getXtextTest()
   * @generated
   */
  EReference getXtextTest_Root();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.xtexttest.xtextTest.XtextTest#getOutput <em>Output</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Output</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTest#getOutput()
   * @see #getXtextTest()
   * @generated
   */
  EReference getXtextTest_Output();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.xtexttest.xtextTest.XtextTest#getBefore <em>Before</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Before</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTest#getBefore()
   * @see #getXtextTest()
   * @generated
   */
  EReference getXtextTest_Before();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.xtexttest.xtextTest.XtextTest#getAfter <em>After</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>After</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTest#getAfter()
   * @see #getXtextTest()
   * @generated
   */
  EReference getXtextTest_After();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.xtexttest.xtextTest.Input <em>Input</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Input</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.Input
   * @generated
   */
  EClass getInput();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.xtexttest.xtextTest.Input#getText <em>Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Text</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.Input#getText()
   * @see #getInput()
   * @generated
   */
  EAttribute getInput_Text();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.xtexttest.xtextTest.Input#getFile <em>File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.Input#getFile()
   * @see #getInput()
   * @generated
   */
  EAttribute getInput_File();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.xtexttest.xtextTest.Tokens <em>Tokens</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tokens</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.Tokens
   * @generated
   */
  EClass getTokens();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.xtexttest.xtextTest.Tokens#getTokens <em>Tokens</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Tokens</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.Tokens#getTokens()
   * @see #getTokens()
   * @generated
   */
  EReference getTokens_Tokens();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.xtexttest.xtextTest.MyTokens <em>My Tokens</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Tokens</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.MyTokens
   * @generated
   */
  EClass getMyTokens();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.xtexttest.xtextTest.MyTokens#getToken <em>Token</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Token</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.MyTokens#getToken()
   * @see #getMyTokens()
   * @generated
   */
  EAttribute getMyTokens_Token();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.xtexttest.xtextTest.MyTokens#getCount <em>Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Count</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.MyTokens#getCount()
   * @see #getMyTokens()
   * @generated
   */
  EAttribute getMyTokens_Count();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.xtexttest.xtextTest.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.Element
   * @generated
   */
  EClass getElement();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.xtexttest.xtextTest.Element#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.Element#getName()
   * @see #getElement()
   * @generated
   */
  EAttribute getElement_Name();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.xtexttest.xtextTest.Element#getInner <em>Inner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Inner</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.Element#getInner()
   * @see #getElement()
   * @generated
   */
  EReference getElement_Inner();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.xtexttest.xtextTest.Inner <em>Inner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Inner</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.Inner
   * @generated
   */
  EClass getInner();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.xtexttest.xtextTest.Inner#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Parameter</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.Inner#getParameter()
   * @see #getInner()
   * @generated
   */
  EAttribute getInner_Parameter();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.xtexttest.xtextTest.Inner#getAssign <em>Assign</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Assign</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.Inner#getAssign()
   * @see #getInner()
   * @generated
   */
  EReference getInner_Assign();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.xtexttest.xtextTest.Inner#getAssignList <em>Assign List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Assign List</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.Inner#getAssignList()
   * @see #getInner()
   * @generated
   */
  EReference getInner_AssignList();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.xtexttest.xtextTest.Inner#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.Inner#getValue()
   * @see #getInner()
   * @generated
   */
  EAttribute getInner_Value();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.xtexttest.xtextTest.Inner#getAssignAsData <em>Assign As Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Assign As Data</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.Inner#getAssignAsData()
   * @see #getInner()
   * @generated
   */
  EAttribute getInner_AssignAsData();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.xtexttest.xtextTest.Generator <em>Generator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Generator</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.Generator
   * @generated
   */
  EClass getGenerator();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.xtexttest.xtextTest.Generator#getOutput <em>Output</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Output</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.Generator#getOutput()
   * @see #getGenerator()
   * @generated
   */
  EAttribute getGenerator_Output();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.xtexttest.xtextTest.Generator#getExpected <em>Expected</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expected</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.Generator#getExpected()
   * @see #getGenerator()
   * @generated
   */
  EAttribute getGenerator_Expected();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.xtexttest.xtextTest.Generator#isIsSameAsInputFile <em>Is Same As Input File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Same As Input File</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.Generator#isIsSameAsInputFile()
   * @see #getGenerator()
   * @generated
   */
  EAttribute getGenerator_IsSameAsInputFile();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.xtexttest.xtextTest.Generator#getPatternFile <em>Pattern File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Pattern File</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.Generator#getPatternFile()
   * @see #getGenerator()
   * @generated
   */
  EAttribute getGenerator_PatternFile();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.xtexttest.xtextTest.Generator#getReplacePatterns <em>Replace Patterns</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Replace Patterns</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.Generator#getReplacePatterns()
   * @see #getGenerator()
   * @generated
   */
  EReference getGenerator_ReplacePatterns();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.xtexttest.xtextTest.Generator#getException <em>Exception</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Exception</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.Generator#getException()
   * @see #getGenerator()
   * @generated
   */
  EAttribute getGenerator_Exception();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.xtexttest.xtextTest.ReplacePatterns <em>Replace Patterns</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Replace Patterns</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.ReplacePatterns
   * @generated
   */
  EClass getReplacePatterns();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.xtexttest.xtextTest.ReplacePatterns#getRegex <em>Regex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Regex</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.ReplacePatterns#getRegex()
   * @see #getReplacePatterns()
   * @generated
   */
  EAttribute getReplacePatterns_Regex();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.xtexttest.xtextTest.ReplacePatterns#getReplace <em>Replace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Replace</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.ReplacePatterns#getReplace()
   * @see #getReplacePatterns()
   * @generated
   */
  EAttribute getReplacePatterns_Replace();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.xtexttest.xtextTest.Before <em>Before</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Before</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.Before
   * @generated
   */
  EClass getBefore();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.xtexttest.xtextTest.Before#getMyclass <em>Myclass</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Myclass</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.Before#getMyclass()
   * @see #getBefore()
   * @generated
   */
  EAttribute getBefore_Myclass();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.xtexttest.xtextTest.Before#getMethod <em>Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Method</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.Before#getMethod()
   * @see #getBefore()
   * @generated
   */
  EAttribute getBefore_Method();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.xtexttest.xtextTest.After <em>After</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>After</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.After
   * @generated
   */
  EClass getAfter();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.xtexttest.xtextTest.After#getMyclass <em>Myclass</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Myclass</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.After#getMyclass()
   * @see #getAfter()
   * @generated
   */
  EAttribute getAfter_Myclass();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.xtexttest.xtextTest.After#getMethod <em>Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Method</em>'.
   * @see at.jku.weiner.xtexttest.xtextTest.After#getMethod()
   * @see #getAfter()
   * @generated
   */
  EAttribute getAfter_Method();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  XtextTestFactory getXtextTestFactory();

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
     * The meta object literal for the '{@link at.jku.weiner.xtexttest.xtextTest.impl.XtextTestImpl <em>Xtext Test</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.xtexttest.xtextTest.impl.XtextTestImpl
     * @see at.jku.weiner.xtexttest.xtextTest.impl.XtextTestPackageImpl#getXtextTest()
     * @generated
     */
    EClass XTEXT_TEST = eINSTANCE.getXtextTest();

    /**
     * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XTEXT_TEST__PACKAGE = eINSTANCE.getXtextTest_Package();

    /**
     * The meta object literal for the '<em><b>Lang</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XTEXT_TEST__LANG = eINSTANCE.getXtextTest_Lang();

    /**
     * The meta object literal for the '<em><b>Boolean</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XTEXT_TEST__BOOLEAN = eINSTANCE.getXtextTest_Boolean();

    /**
     * The meta object literal for the '<em><b>Input</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XTEXT_TEST__INPUT = eINSTANCE.getXtextTest_Input();

    /**
     * The meta object literal for the '<em><b>Tokens</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XTEXT_TEST__TOKENS = eINSTANCE.getXtextTest_Tokens();

    /**
     * The meta object literal for the '<em><b>Root</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XTEXT_TEST__ROOT = eINSTANCE.getXtextTest_Root();

    /**
     * The meta object literal for the '<em><b>Output</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XTEXT_TEST__OUTPUT = eINSTANCE.getXtextTest_Output();

    /**
     * The meta object literal for the '<em><b>Before</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XTEXT_TEST__BEFORE = eINSTANCE.getXtextTest_Before();

    /**
     * The meta object literal for the '<em><b>After</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XTEXT_TEST__AFTER = eINSTANCE.getXtextTest_After();

    /**
     * The meta object literal for the '{@link at.jku.weiner.xtexttest.xtextTest.impl.InputImpl <em>Input</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.xtexttest.xtextTest.impl.InputImpl
     * @see at.jku.weiner.xtexttest.xtextTest.impl.XtextTestPackageImpl#getInput()
     * @generated
     */
    EClass INPUT = eINSTANCE.getInput();

    /**
     * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INPUT__TEXT = eINSTANCE.getInput_Text();

    /**
     * The meta object literal for the '<em><b>File</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INPUT__FILE = eINSTANCE.getInput_File();

    /**
     * The meta object literal for the '{@link at.jku.weiner.xtexttest.xtextTest.impl.TokensImpl <em>Tokens</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.xtexttest.xtextTest.impl.TokensImpl
     * @see at.jku.weiner.xtexttest.xtextTest.impl.XtextTestPackageImpl#getTokens()
     * @generated
     */
    EClass TOKENS = eINSTANCE.getTokens();

    /**
     * The meta object literal for the '<em><b>Tokens</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TOKENS__TOKENS = eINSTANCE.getTokens_Tokens();

    /**
     * The meta object literal for the '{@link at.jku.weiner.xtexttest.xtextTest.impl.MyTokensImpl <em>My Tokens</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.xtexttest.xtextTest.impl.MyTokensImpl
     * @see at.jku.weiner.xtexttest.xtextTest.impl.XtextTestPackageImpl#getMyTokens()
     * @generated
     */
    EClass MY_TOKENS = eINSTANCE.getMyTokens();

    /**
     * The meta object literal for the '<em><b>Token</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MY_TOKENS__TOKEN = eINSTANCE.getMyTokens_Token();

    /**
     * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MY_TOKENS__COUNT = eINSTANCE.getMyTokens_Count();

    /**
     * The meta object literal for the '{@link at.jku.weiner.xtexttest.xtextTest.impl.ElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.xtexttest.xtextTest.impl.ElementImpl
     * @see at.jku.weiner.xtexttest.xtextTest.impl.XtextTestPackageImpl#getElement()
     * @generated
     */
    EClass ELEMENT = eINSTANCE.getElement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ELEMENT__NAME = eINSTANCE.getElement_Name();

    /**
     * The meta object literal for the '<em><b>Inner</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT__INNER = eINSTANCE.getElement_Inner();

    /**
     * The meta object literal for the '{@link at.jku.weiner.xtexttest.xtextTest.impl.InnerImpl <em>Inner</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.xtexttest.xtextTest.impl.InnerImpl
     * @see at.jku.weiner.xtexttest.xtextTest.impl.XtextTestPackageImpl#getInner()
     * @generated
     */
    EClass INNER = eINSTANCE.getInner();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INNER__PARAMETER = eINSTANCE.getInner_Parameter();

    /**
     * The meta object literal for the '<em><b>Assign</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INNER__ASSIGN = eINSTANCE.getInner_Assign();

    /**
     * The meta object literal for the '<em><b>Assign List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INNER__ASSIGN_LIST = eINSTANCE.getInner_AssignList();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INNER__VALUE = eINSTANCE.getInner_Value();

    /**
     * The meta object literal for the '<em><b>Assign As Data</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INNER__ASSIGN_AS_DATA = eINSTANCE.getInner_AssignAsData();

    /**
     * The meta object literal for the '{@link at.jku.weiner.xtexttest.xtextTest.impl.GeneratorImpl <em>Generator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.xtexttest.xtextTest.impl.GeneratorImpl
     * @see at.jku.weiner.xtexttest.xtextTest.impl.XtextTestPackageImpl#getGenerator()
     * @generated
     */
    EClass GENERATOR = eINSTANCE.getGenerator();

    /**
     * The meta object literal for the '<em><b>Output</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GENERATOR__OUTPUT = eINSTANCE.getGenerator_Output();

    /**
     * The meta object literal for the '<em><b>Expected</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GENERATOR__EXPECTED = eINSTANCE.getGenerator_Expected();

    /**
     * The meta object literal for the '<em><b>Is Same As Input File</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GENERATOR__IS_SAME_AS_INPUT_FILE = eINSTANCE.getGenerator_IsSameAsInputFile();

    /**
     * The meta object literal for the '<em><b>Pattern File</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GENERATOR__PATTERN_FILE = eINSTANCE.getGenerator_PatternFile();

    /**
     * The meta object literal for the '<em><b>Replace Patterns</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GENERATOR__REPLACE_PATTERNS = eINSTANCE.getGenerator_ReplacePatterns();

    /**
     * The meta object literal for the '<em><b>Exception</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GENERATOR__EXCEPTION = eINSTANCE.getGenerator_Exception();

    /**
     * The meta object literal for the '{@link at.jku.weiner.xtexttest.xtextTest.impl.ReplacePatternsImpl <em>Replace Patterns</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.xtexttest.xtextTest.impl.ReplacePatternsImpl
     * @see at.jku.weiner.xtexttest.xtextTest.impl.XtextTestPackageImpl#getReplacePatterns()
     * @generated
     */
    EClass REPLACE_PATTERNS = eINSTANCE.getReplacePatterns();

    /**
     * The meta object literal for the '<em><b>Regex</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REPLACE_PATTERNS__REGEX = eINSTANCE.getReplacePatterns_Regex();

    /**
     * The meta object literal for the '<em><b>Replace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REPLACE_PATTERNS__REPLACE = eINSTANCE.getReplacePatterns_Replace();

    /**
     * The meta object literal for the '{@link at.jku.weiner.xtexttest.xtextTest.impl.BeforeImpl <em>Before</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.xtexttest.xtextTest.impl.BeforeImpl
     * @see at.jku.weiner.xtexttest.xtextTest.impl.XtextTestPackageImpl#getBefore()
     * @generated
     */
    EClass BEFORE = eINSTANCE.getBefore();

    /**
     * The meta object literal for the '<em><b>Myclass</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BEFORE__MYCLASS = eINSTANCE.getBefore_Myclass();

    /**
     * The meta object literal for the '<em><b>Method</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BEFORE__METHOD = eINSTANCE.getBefore_Method();

    /**
     * The meta object literal for the '{@link at.jku.weiner.xtexttest.xtextTest.impl.AfterImpl <em>After</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.xtexttest.xtextTest.impl.AfterImpl
     * @see at.jku.weiner.xtexttest.xtextTest.impl.XtextTestPackageImpl#getAfter()
     * @generated
     */
    EClass AFTER = eINSTANCE.getAfter();

    /**
     * The meta object literal for the '<em><b>Myclass</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AFTER__MYCLASS = eINSTANCE.getAfter_Myclass();

    /**
     * The meta object literal for the '<em><b>Method</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AFTER__METHOD = eINSTANCE.getAfter_Method();

  }

} //XtextTestPackage
