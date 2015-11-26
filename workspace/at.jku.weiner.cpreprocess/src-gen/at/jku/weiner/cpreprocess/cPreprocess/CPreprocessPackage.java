/**
 */
package at.jku.weiner.cpreprocess.cPreprocess;

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
 * @see at.jku.weiner.cpreprocess.cPreprocess.CPreprocessFactory
 * @model kind="package"
 * @generated
 */
public interface CPreprocessPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "cPreprocess";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.jku.at/weiner/cpreprocess/CPreprocess";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "cPreprocess";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CPreprocessPackage eINSTANCE = at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl.init();

  /**
   * The meta object id for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.ModelImpl
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Units</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__UNITS = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.TranslationUnitImpl <em>Translation Unit</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.TranslationUnitImpl
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getTranslationUnit()
   * @generated
   */
  int TRANSLATION_UNIT = 1;

  /**
   * The feature id for the '<em><b>Group</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSLATION_UNIT__GROUP = 0;

  /**
   * The number of structural features of the '<em>Translation Unit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSLATION_UNIT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.GroupOptImpl <em>Group Opt</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.GroupOptImpl
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getGroupOpt()
   * @generated
   */
  int GROUP_OPT = 2;

  /**
   * The feature id for the '<em><b>Lines</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_OPT__LINES = 0;

  /**
   * The number of structural features of the '<em>Group Opt</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_OPT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.SourceCodeLineImpl <em>Source Code Line</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.SourceCodeLineImpl
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getSourceCodeLine()
   * @generated
   */
  int SOURCE_CODE_LINE = 3;

  /**
   * The number of structural features of the '<em>Source Code Line</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE_CODE_LINE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.IncludeDirectiveImpl <em>Include Directive</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.IncludeDirectiveImpl
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getIncludeDirective()
   * @generated
   */
  int INCLUDE_DIRECTIVE = 4;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_DIRECTIVE__STRING = 0;

  /**
   * The number of structural features of the '<em>Include Directive</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_DIRECTIVE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.DefineDirectiveImpl <em>Define Directive</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.DefineDirectiveImpl
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getDefineDirective()
   * @generated
   */
  int DEFINE_DIRECTIVE = 5;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_DIRECTIVE__ID = 0;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_DIRECTIVE__STRING = 1;

  /**
   * The number of structural features of the '<em>Define Directive</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_DIRECTIVE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.IdentifierListImpl <em>Identifier List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.IdentifierListImpl
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getIdentifierList()
   * @generated
   */
  int IDENTIFIER_LIST = 6;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER_LIST__ID = 0;

  /**
   * The number of structural features of the '<em>Identifier List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.ErrorDirectiveImpl <em>Error Directive</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.ErrorDirectiveImpl
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getErrorDirective()
   * @generated
   */
  int ERROR_DIRECTIVE = 7;

  /**
   * The feature id for the '<em><b>Msg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_DIRECTIVE__MSG = 0;

  /**
   * The number of structural features of the '<em>Error Directive</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_DIRECTIVE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.UnDefineDirectiveImpl <em>Un Define Directive</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.UnDefineDirectiveImpl
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getUnDefineDirective()
   * @generated
   */
  int UN_DEFINE_DIRECTIVE = 8;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UN_DEFINE_DIRECTIVE__ID = 0;

  /**
   * The number of structural features of the '<em>Un Define Directive</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UN_DEFINE_DIRECTIVE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.ConditionalDirectiveImpl <em>Conditional Directive</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.ConditionalDirectiveImpl
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getConditionalDirective()
   * @generated
   */
  int CONDITIONAL_DIRECTIVE = 9;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_DIRECTIVE__ID = 0;

  /**
   * The feature id for the '<em><b>Group</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_DIRECTIVE__GROUP = 1;

  /**
   * The number of structural features of the '<em>Conditional Directive</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_DIRECTIVE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.PragmaDirectiveImpl <em>Pragma Directive</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.PragmaDirectiveImpl
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getPragmaDirective()
   * @generated
   */
  int PRAGMA_DIRECTIVE = 10;

  /**
   * The number of structural features of the '<em>Pragma Directive</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRAGMA_DIRECTIVE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.NullDirectiveImpl <em>Null Directive</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.NullDirectiveImpl
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getNullDirective()
   * @generated
   */
  int NULL_DIRECTIVE = 11;

  /**
   * The number of structural features of the '<em>Null Directive</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NULL_DIRECTIVE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.PreprocessorDirectivesImpl <em>Preprocessor Directives</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.PreprocessorDirectivesImpl
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getPreprocessorDirectives()
   * @generated
   */
  int PREPROCESSOR_DIRECTIVES = 12;

  /**
   * The feature id for the '<em><b>Directive</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROCESSOR_DIRECTIVES__DIRECTIVE = SOURCE_CODE_LINE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Preprocessor Directives</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROCESSOR_DIRECTIVES_FEATURE_COUNT = SOURCE_CODE_LINE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.DefineObjectMacroImpl <em>Define Object Macro</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.DefineObjectMacroImpl
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getDefineObjectMacro()
   * @generated
   */
  int DEFINE_OBJECT_MACRO = 13;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_OBJECT_MACRO__ID = DEFINE_DIRECTIVE__ID;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_OBJECT_MACRO__STRING = DEFINE_DIRECTIVE__STRING;

  /**
   * The number of structural features of the '<em>Define Object Macro</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_OBJECT_MACRO_FEATURE_COUNT = DEFINE_DIRECTIVE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.DefineFunctionLikeMacroImpl <em>Define Function Like Macro</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.DefineFunctionLikeMacroImpl
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getDefineFunctionLikeMacro()
   * @generated
   */
  int DEFINE_FUNCTION_LIKE_MACRO = 14;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_FUNCTION_LIKE_MACRO__ID = DEFINE_DIRECTIVE__ID;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_FUNCTION_LIKE_MACRO__STRING = DEFINE_DIRECTIVE__STRING;

  /**
   * The feature id for the '<em><b>List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_FUNCTION_LIKE_MACRO__LIST = DEFINE_DIRECTIVE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Define Function Like Macro</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_FUNCTION_LIKE_MACRO_FEATURE_COUNT = DEFINE_DIRECTIVE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.NewLineLineImpl <em>New Line Line</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.NewLineLineImpl
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getNewLineLine()
   * @generated
   */
  int NEW_LINE_LINE = 15;

  /**
   * The number of structural features of the '<em>New Line Line</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEW_LINE_LINE_FEATURE_COUNT = SOURCE_CODE_LINE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.CodeImpl <em>Code</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CodeImpl
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getCode()
   * @generated
   */
  int CODE = 16;

  /**
   * The feature id for the '<em><b>Code</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODE__CODE = SOURCE_CODE_LINE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Code</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODE_FEATURE_COUNT = SOURCE_CODE_LINE_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link at.jku.weiner.cpreprocess.cPreprocess.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.cpreprocess.cPreprocess.Model#getUnits <em>Units</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Units</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.Model#getUnits()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Units();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.cpreprocess.cPreprocess.TranslationUnit <em>Translation Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Translation Unit</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.TranslationUnit
   * @generated
   */
  EClass getTranslationUnit();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.cpreprocess.cPreprocess.TranslationUnit#getGroup <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Group</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.TranslationUnit#getGroup()
   * @see #getTranslationUnit()
   * @generated
   */
  EReference getTranslationUnit_Group();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.cpreprocess.cPreprocess.GroupOpt <em>Group Opt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Group Opt</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.GroupOpt
   * @generated
   */
  EClass getGroupOpt();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.cpreprocess.cPreprocess.GroupOpt#getLines <em>Lines</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Lines</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.GroupOpt#getLines()
   * @see #getGroupOpt()
   * @generated
   */
  EReference getGroupOpt_Lines();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.cpreprocess.cPreprocess.SourceCodeLine <em>Source Code Line</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Source Code Line</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.SourceCodeLine
   * @generated
   */
  EClass getSourceCodeLine();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.cpreprocess.cPreprocess.IncludeDirective <em>Include Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Include Directive</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.IncludeDirective
   * @generated
   */
  EClass getIncludeDirective();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.cpreprocess.cPreprocess.IncludeDirective#getString <em>String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>String</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.IncludeDirective#getString()
   * @see #getIncludeDirective()
   * @generated
   */
  EAttribute getIncludeDirective_String();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.cpreprocess.cPreprocess.DefineDirective <em>Define Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Define Directive</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.DefineDirective
   * @generated
   */
  EClass getDefineDirective();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.cpreprocess.cPreprocess.DefineDirective#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.DefineDirective#getId()
   * @see #getDefineDirective()
   * @generated
   */
  EAttribute getDefineDirective_Id();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.cpreprocess.cPreprocess.DefineDirective#getString <em>String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>String</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.DefineDirective#getString()
   * @see #getDefineDirective()
   * @generated
   */
  EAttribute getDefineDirective_String();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.cpreprocess.cPreprocess.IdentifierList <em>Identifier List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Identifier List</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.IdentifierList
   * @generated
   */
  EClass getIdentifierList();

  /**
   * Returns the meta object for the attribute list '{@link at.jku.weiner.cpreprocess.cPreprocess.IdentifierList#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Id</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.IdentifierList#getId()
   * @see #getIdentifierList()
   * @generated
   */
  EAttribute getIdentifierList_Id();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.cpreprocess.cPreprocess.ErrorDirective <em>Error Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Error Directive</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.ErrorDirective
   * @generated
   */
  EClass getErrorDirective();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.cpreprocess.cPreprocess.ErrorDirective#getMsg <em>Msg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Msg</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.ErrorDirective#getMsg()
   * @see #getErrorDirective()
   * @generated
   */
  EAttribute getErrorDirective_Msg();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.cpreprocess.cPreprocess.UnDefineDirective <em>Un Define Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Un Define Directive</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.UnDefineDirective
   * @generated
   */
  EClass getUnDefineDirective();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.cpreprocess.cPreprocess.UnDefineDirective#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.UnDefineDirective#getId()
   * @see #getUnDefineDirective()
   * @generated
   */
  EAttribute getUnDefineDirective_Id();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.cpreprocess.cPreprocess.ConditionalDirective <em>Conditional Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Conditional Directive</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.ConditionalDirective
   * @generated
   */
  EClass getConditionalDirective();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.cpreprocess.cPreprocess.ConditionalDirective#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.ConditionalDirective#getId()
   * @see #getConditionalDirective()
   * @generated
   */
  EAttribute getConditionalDirective_Id();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.cpreprocess.cPreprocess.ConditionalDirective#getGroup <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Group</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.ConditionalDirective#getGroup()
   * @see #getConditionalDirective()
   * @generated
   */
  EReference getConditionalDirective_Group();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.cpreprocess.cPreprocess.PragmaDirective <em>Pragma Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pragma Directive</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.PragmaDirective
   * @generated
   */
  EClass getPragmaDirective();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.cpreprocess.cPreprocess.NullDirective <em>Null Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Null Directive</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.NullDirective
   * @generated
   */
  EClass getNullDirective();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives <em>Preprocessor Directives</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preprocessor Directives</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives
   * @generated
   */
  EClass getPreprocessorDirectives();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives#getDirective <em>Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Directive</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives#getDirective()
   * @see #getPreprocessorDirectives()
   * @generated
   */
  EReference getPreprocessorDirectives_Directive();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.cpreprocess.cPreprocess.DefineObjectMacro <em>Define Object Macro</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Define Object Macro</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.DefineObjectMacro
   * @generated
   */
  EClass getDefineObjectMacro();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.cpreprocess.cPreprocess.DefineFunctionLikeMacro <em>Define Function Like Macro</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Define Function Like Macro</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.DefineFunctionLikeMacro
   * @generated
   */
  EClass getDefineFunctionLikeMacro();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.cpreprocess.cPreprocess.DefineFunctionLikeMacro#getList <em>List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>List</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.DefineFunctionLikeMacro#getList()
   * @see #getDefineFunctionLikeMacro()
   * @generated
   */
  EReference getDefineFunctionLikeMacro_List();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.cpreprocess.cPreprocess.NewLineLine <em>New Line Line</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>New Line Line</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.NewLineLine
   * @generated
   */
  EClass getNewLineLine();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.cpreprocess.cPreprocess.Code <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Code</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.Code
   * @generated
   */
  EClass getCode();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.cpreprocess.cPreprocess.Code#getCode <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Code</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.Code#getCode()
   * @see #getCode()
   * @generated
   */
  EAttribute getCode_Code();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  CPreprocessFactory getCPreprocessFactory();

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
     * The meta object literal for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.ModelImpl
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Units</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__UNITS = eINSTANCE.getModel_Units();

    /**
     * The meta object literal for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.TranslationUnitImpl <em>Translation Unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.TranslationUnitImpl
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getTranslationUnit()
     * @generated
     */
    EClass TRANSLATION_UNIT = eINSTANCE.getTranslationUnit();

    /**
     * The meta object literal for the '<em><b>Group</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSLATION_UNIT__GROUP = eINSTANCE.getTranslationUnit_Group();

    /**
     * The meta object literal for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.GroupOptImpl <em>Group Opt</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.GroupOptImpl
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getGroupOpt()
     * @generated
     */
    EClass GROUP_OPT = eINSTANCE.getGroupOpt();

    /**
     * The meta object literal for the '<em><b>Lines</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GROUP_OPT__LINES = eINSTANCE.getGroupOpt_Lines();

    /**
     * The meta object literal for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.SourceCodeLineImpl <em>Source Code Line</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.SourceCodeLineImpl
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getSourceCodeLine()
     * @generated
     */
    EClass SOURCE_CODE_LINE = eINSTANCE.getSourceCodeLine();

    /**
     * The meta object literal for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.IncludeDirectiveImpl <em>Include Directive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.IncludeDirectiveImpl
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getIncludeDirective()
     * @generated
     */
    EClass INCLUDE_DIRECTIVE = eINSTANCE.getIncludeDirective();

    /**
     * The meta object literal for the '<em><b>String</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INCLUDE_DIRECTIVE__STRING = eINSTANCE.getIncludeDirective_String();

    /**
     * The meta object literal for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.DefineDirectiveImpl <em>Define Directive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.DefineDirectiveImpl
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getDefineDirective()
     * @generated
     */
    EClass DEFINE_DIRECTIVE = eINSTANCE.getDefineDirective();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DEFINE_DIRECTIVE__ID = eINSTANCE.getDefineDirective_Id();

    /**
     * The meta object literal for the '<em><b>String</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DEFINE_DIRECTIVE__STRING = eINSTANCE.getDefineDirective_String();

    /**
     * The meta object literal for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.IdentifierListImpl <em>Identifier List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.IdentifierListImpl
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getIdentifierList()
     * @generated
     */
    EClass IDENTIFIER_LIST = eINSTANCE.getIdentifierList();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IDENTIFIER_LIST__ID = eINSTANCE.getIdentifierList_Id();

    /**
     * The meta object literal for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.ErrorDirectiveImpl <em>Error Directive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.ErrorDirectiveImpl
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getErrorDirective()
     * @generated
     */
    EClass ERROR_DIRECTIVE = eINSTANCE.getErrorDirective();

    /**
     * The meta object literal for the '<em><b>Msg</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ERROR_DIRECTIVE__MSG = eINSTANCE.getErrorDirective_Msg();

    /**
     * The meta object literal for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.UnDefineDirectiveImpl <em>Un Define Directive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.UnDefineDirectiveImpl
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getUnDefineDirective()
     * @generated
     */
    EClass UN_DEFINE_DIRECTIVE = eINSTANCE.getUnDefineDirective();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UN_DEFINE_DIRECTIVE__ID = eINSTANCE.getUnDefineDirective_Id();

    /**
     * The meta object literal for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.ConditionalDirectiveImpl <em>Conditional Directive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.ConditionalDirectiveImpl
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getConditionalDirective()
     * @generated
     */
    EClass CONDITIONAL_DIRECTIVE = eINSTANCE.getConditionalDirective();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONDITIONAL_DIRECTIVE__ID = eINSTANCE.getConditionalDirective_Id();

    /**
     * The meta object literal for the '<em><b>Group</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_DIRECTIVE__GROUP = eINSTANCE.getConditionalDirective_Group();

    /**
     * The meta object literal for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.PragmaDirectiveImpl <em>Pragma Directive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.PragmaDirectiveImpl
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getPragmaDirective()
     * @generated
     */
    EClass PRAGMA_DIRECTIVE = eINSTANCE.getPragmaDirective();

    /**
     * The meta object literal for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.NullDirectiveImpl <em>Null Directive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.NullDirectiveImpl
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getNullDirective()
     * @generated
     */
    EClass NULL_DIRECTIVE = eINSTANCE.getNullDirective();

    /**
     * The meta object literal for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.PreprocessorDirectivesImpl <em>Preprocessor Directives</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.PreprocessorDirectivesImpl
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getPreprocessorDirectives()
     * @generated
     */
    EClass PREPROCESSOR_DIRECTIVES = eINSTANCE.getPreprocessorDirectives();

    /**
     * The meta object literal for the '<em><b>Directive</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREPROCESSOR_DIRECTIVES__DIRECTIVE = eINSTANCE.getPreprocessorDirectives_Directive();

    /**
     * The meta object literal for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.DefineObjectMacroImpl <em>Define Object Macro</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.DefineObjectMacroImpl
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getDefineObjectMacro()
     * @generated
     */
    EClass DEFINE_OBJECT_MACRO = eINSTANCE.getDefineObjectMacro();

    /**
     * The meta object literal for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.DefineFunctionLikeMacroImpl <em>Define Function Like Macro</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.DefineFunctionLikeMacroImpl
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getDefineFunctionLikeMacro()
     * @generated
     */
    EClass DEFINE_FUNCTION_LIKE_MACRO = eINSTANCE.getDefineFunctionLikeMacro();

    /**
     * The meta object literal for the '<em><b>List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEFINE_FUNCTION_LIKE_MACRO__LIST = eINSTANCE.getDefineFunctionLikeMacro_List();

    /**
     * The meta object literal for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.NewLineLineImpl <em>New Line Line</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.NewLineLineImpl
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getNewLineLine()
     * @generated
     */
    EClass NEW_LINE_LINE = eINSTANCE.getNewLineLine();

    /**
     * The meta object literal for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.CodeImpl <em>Code</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CodeImpl
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getCode()
     * @generated
     */
    EClass CODE = eINSTANCE.getCode();

    /**
     * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CODE__CODE = eINSTANCE.getCode_Code();

  }

} //CPreprocessPackage
