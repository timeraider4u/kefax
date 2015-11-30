/**
 */
package at.jku.weiner.c.preprocess.preprocess;

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
 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessFactory
 * @model kind="package"
 * @generated
 */
public interface PreprocessPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "preprocess";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.jku.at/weiner/c/preprocess/Preprocess";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "preprocess";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PreprocessPackage eINSTANCE = at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl.init();

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.ModelImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getModel()
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
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.TranslationUnitImpl <em>Translation Unit</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.TranslationUnitImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getTranslationUnit()
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
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.GroupOptImpl <em>Group Opt</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.GroupOptImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getGroupOpt()
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
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.SourceCodeLineImpl <em>Source Code Line</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.SourceCodeLineImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getSourceCodeLine()
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
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.IncludeDirectiveImpl <em>Include Directive</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.IncludeDirectiveImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getIncludeDirective()
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
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.DefineDirectiveImpl <em>Define Directive</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.DefineDirectiveImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getDefineDirective()
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
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.IdentifierListImpl <em>Identifier List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.IdentifierListImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getIdentifierList()
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
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ErrorDirectiveImpl <em>Error Directive</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.ErrorDirectiveImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getErrorDirective()
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
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.UnDefineDirectiveImpl <em>Un Define Directive</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.UnDefineDirectiveImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getUnDefineDirective()
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
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ConditionalDirectiveImpl <em>Conditional Directive</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.ConditionalDirectiveImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getConditionalDirective()
   * @generated
   */
  int CONDITIONAL_DIRECTIVE = 9;

  /**
   * The feature id for the '<em><b>Conditional</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_DIRECTIVE__CONDITIONAL = 0;

  /**
   * The number of structural features of the '<em>Conditional Directive</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_DIRECTIVE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.IfConditionalImpl <em>If Conditional</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.IfConditionalImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getIfConditional()
   * @generated
   */
  int IF_CONDITIONAL = 10;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_CONDITIONAL__EXPRESSION = 0;

  /**
   * The feature id for the '<em><b>Group</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_CONDITIONAL__GROUP = 1;

  /**
   * The number of structural features of the '<em>If Conditional</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_CONDITIONAL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.IfDefConditionalImpl <em>If Def Conditional</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.IfDefConditionalImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getIfDefConditional()
   * @generated
   */
  int IF_DEF_CONDITIONAL = 11;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_DEF_CONDITIONAL__ID = 0;

  /**
   * The feature id for the '<em><b>Group</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_DEF_CONDITIONAL__GROUP = 1;

  /**
   * The number of structural features of the '<em>If Def Conditional</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_DEF_CONDITIONAL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.IfNotDefConditionalImpl <em>If Not Def Conditional</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.IfNotDefConditionalImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getIfNotDefConditional()
   * @generated
   */
  int IF_NOT_DEF_CONDITIONAL = 12;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_NOT_DEF_CONDITIONAL__ID = 0;

  /**
   * The feature id for the '<em><b>Group</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_NOT_DEF_CONDITIONAL__GROUP = 1;

  /**
   * The number of structural features of the '<em>If Not Def Conditional</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_NOT_DEF_CONDITIONAL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.PragmaDirectiveImpl <em>Pragma Directive</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PragmaDirectiveImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getPragmaDirective()
   * @generated
   */
  int PRAGMA_DIRECTIVE = 13;

  /**
   * The number of structural features of the '<em>Pragma Directive</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRAGMA_DIRECTIVE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.NullDirectiveImpl <em>Null Directive</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.NullDirectiveImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getNullDirective()
   * @generated
   */
  int NULL_DIRECTIVE = 14;

  /**
   * The number of structural features of the '<em>Null Directive</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NULL_DIRECTIVE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ShadowExpressionImpl <em>Shadow Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.ShadowExpressionImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getShadowExpression()
   * @generated
   */
  int SHADOW_EXPRESSION = 15;

  /**
   * The number of structural features of the '<em>Shadow Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHADOW_EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.ExpressionImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 16;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__EXPRESSION = SHADOW_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = SHADOW_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.UnaryOperatorImpl <em>Unary Operator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.UnaryOperatorImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getUnaryOperator()
   * @generated
   */
  int UNARY_OPERATOR = 17;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_OPERATOR__OP = 0;

  /**
   * The number of structural features of the '<em>Unary Operator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_OPERATOR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.PreprocessorDirectivesImpl <em>Preprocessor Directives</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessorDirectivesImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getPreprocessorDirectives()
   * @generated
   */
  int PREPROCESSOR_DIRECTIVES = 18;

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
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.DefineObjectMacroImpl <em>Define Object Macro</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.DefineObjectMacroImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getDefineObjectMacro()
   * @generated
   */
  int DEFINE_OBJECT_MACRO = 19;

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
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.DefineFunctionLikeMacroImpl <em>Define Function Like Macro</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.DefineFunctionLikeMacroImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getDefineFunctionLikeMacro()
   * @generated
   */
  int DEFINE_FUNCTION_LIKE_MACRO = 20;

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
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.NewLineLineImpl <em>New Line Line</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.NewLineLineImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getNewLineLine()
   * @generated
   */
  int NEW_LINE_LINE = 21;

  /**
   * The number of structural features of the '<em>New Line Line</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEW_LINE_LINE_FEATURE_COUNT = SOURCE_CODE_LINE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.CodeImpl <em>Code</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.CodeImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getCode()
   * @generated
   */
  int CODE = 22;

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
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ConstantExpressionImpl <em>Constant Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.ConstantExpressionImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getConstantExpression()
   * @generated
   */
  int CONSTANT_EXPRESSION = 23;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Constant Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ConditionalExpressionImpl <em>Conditional Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.ConditionalExpressionImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getConditionalExpression()
   * @generated
   */
  int CONDITIONAL_EXPRESSION = 24;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>QExpr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__QEXPR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>CExpr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__CEXPR = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Conditional Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.LogicalOrExpressionImpl <em>Logical Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.LogicalOrExpressionImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getLogicalOrExpression()
   * @generated
   */
  int LOGICAL_OR_EXPRESSION = 25;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_OR_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_OR_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Logical Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_OR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.LogicalAndExpressionImpl <em>Logical And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.LogicalAndExpressionImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getLogicalAndExpression()
   * @generated
   */
  int LOGICAL_AND_EXPRESSION = 26;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_AND_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_AND_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Logical And Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_AND_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.InclusiveOrExpressionImpl <em>Inclusive Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.InclusiveOrExpressionImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getInclusiveOrExpression()
   * @generated
   */
  int INCLUSIVE_OR_EXPRESSION = 27;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUSIVE_OR_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUSIVE_OR_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Inclusive Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUSIVE_OR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ExclusiveOrExpressionImpl <em>Exclusive Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.ExclusiveOrExpressionImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getExclusiveOrExpression()
   * @generated
   */
  int EXCLUSIVE_OR_EXPRESSION = 28;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCLUSIVE_OR_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCLUSIVE_OR_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Exclusive Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCLUSIVE_OR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.AndExpressionImpl <em>And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.AndExpressionImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getAndExpression()
   * @generated
   */
  int AND_EXPRESSION = 29;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>And Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.EqualityExpressionImpl <em>Equality Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.EqualityExpressionImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getEqualityExpression()
   * @generated
   */
  int EQUALITY_EXPRESSION = 30;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Equality Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.RelationalExpressionImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getRelationalExpression()
   * @generated
   */
  int RELATIONAL_EXPRESSION = 31;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Relational Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ShiftExpressionImpl <em>Shift Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.ShiftExpressionImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getShiftExpression()
   * @generated
   */
  int SHIFT_EXPRESSION = 32;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Shift Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.AdditiveExpressionImpl <em>Additive Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.AdditiveExpressionImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getAdditiveExpression()
   * @generated
   */
  int ADDITIVE_EXPRESSION = 33;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Additive Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.MultiplicativeExpressionImpl <em>Multiplicative Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.MultiplicativeExpressionImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getMultiplicativeExpression()
   * @generated
   */
  int MULTIPLICATIVE_EXPRESSION = 34;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Multiplicative Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.CastExpressionImpl <em>Cast Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.CastExpressionImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getCastExpression()
   * @generated
   */
  int CAST_EXPRESSION = 35;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Cast Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.UnaryExpressionImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getUnaryExpression()
   * @generated
   */
  int UNARY_EXPRESSION = 36;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Unary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.PostfixExpressionImpl <em>Postfix Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PostfixExpressionImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getPostfixExpression()
   * @generated
   */
  int POSTFIX_EXPRESSION = 37;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Postfix Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.PrimaryExpressionImpl <em>Primary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PrimaryExpressionImpl
   * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getPrimaryExpression()
   * @generated
   */
  int PRIMARY_EXPRESSION = 38;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Defined</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__DEFINED = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__ID = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Const</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__CONST = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Primary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 4;


  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.preprocess.preprocess.Model#getUnits <em>Units</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Units</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.Model#getUnits()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Units();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.TranslationUnit <em>Translation Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Translation Unit</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.TranslationUnit
   * @generated
   */
  EClass getTranslationUnit();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.TranslationUnit#getGroup <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Group</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.TranslationUnit#getGroup()
   * @see #getTranslationUnit()
   * @generated
   */
  EReference getTranslationUnit_Group();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.GroupOpt <em>Group Opt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Group Opt</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.GroupOpt
   * @generated
   */
  EClass getGroupOpt();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.preprocess.preprocess.GroupOpt#getLines <em>Lines</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Lines</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.GroupOpt#getLines()
   * @see #getGroupOpt()
   * @generated
   */
  EReference getGroupOpt_Lines();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.SourceCodeLine <em>Source Code Line</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Source Code Line</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.SourceCodeLine
   * @generated
   */
  EClass getSourceCodeLine();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.IncludeDirective <em>Include Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Include Directive</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.IncludeDirective
   * @generated
   */
  EClass getIncludeDirective();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.IncludeDirective#getString <em>String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>String</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.IncludeDirective#getString()
   * @see #getIncludeDirective()
   * @generated
   */
  EAttribute getIncludeDirective_String();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.DefineDirective <em>Define Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Define Directive</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.DefineDirective
   * @generated
   */
  EClass getDefineDirective();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.DefineDirective#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.DefineDirective#getId()
   * @see #getDefineDirective()
   * @generated
   */
  EAttribute getDefineDirective_Id();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.DefineDirective#getString <em>String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>String</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.DefineDirective#getString()
   * @see #getDefineDirective()
   * @generated
   */
  EAttribute getDefineDirective_String();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.IdentifierList <em>Identifier List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Identifier List</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.IdentifierList
   * @generated
   */
  EClass getIdentifierList();

  /**
   * Returns the meta object for the attribute list '{@link at.jku.weiner.c.preprocess.preprocess.IdentifierList#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Id</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.IdentifierList#getId()
   * @see #getIdentifierList()
   * @generated
   */
  EAttribute getIdentifierList_Id();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.ErrorDirective <em>Error Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Error Directive</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.ErrorDirective
   * @generated
   */
  EClass getErrorDirective();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.ErrorDirective#getMsg <em>Msg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Msg</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.ErrorDirective#getMsg()
   * @see #getErrorDirective()
   * @generated
   */
  EAttribute getErrorDirective_Msg();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.UnDefineDirective <em>Un Define Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Un Define Directive</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.UnDefineDirective
   * @generated
   */
  EClass getUnDefineDirective();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.UnDefineDirective#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.UnDefineDirective#getId()
   * @see #getUnDefineDirective()
   * @generated
   */
  EAttribute getUnDefineDirective_Id();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.ConditionalDirective <em>Conditional Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Conditional Directive</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.ConditionalDirective
   * @generated
   */
  EClass getConditionalDirective();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.ConditionalDirective#getConditional <em>Conditional</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Conditional</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.ConditionalDirective#getConditional()
   * @see #getConditionalDirective()
   * @generated
   */
  EReference getConditionalDirective_Conditional();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.IfConditional <em>If Conditional</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Conditional</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.IfConditional
   * @generated
   */
  EClass getIfConditional();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.IfConditional#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.IfConditional#getExpression()
   * @see #getIfConditional()
   * @generated
   */
  EReference getIfConditional_Expression();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.IfConditional#getGroup <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Group</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.IfConditional#getGroup()
   * @see #getIfConditional()
   * @generated
   */
  EReference getIfConditional_Group();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.IfDefConditional <em>If Def Conditional</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Def Conditional</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.IfDefConditional
   * @generated
   */
  EClass getIfDefConditional();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.IfDefConditional#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.IfDefConditional#getId()
   * @see #getIfDefConditional()
   * @generated
   */
  EAttribute getIfDefConditional_Id();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.IfDefConditional#getGroup <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Group</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.IfDefConditional#getGroup()
   * @see #getIfDefConditional()
   * @generated
   */
  EReference getIfDefConditional_Group();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.IfNotDefConditional <em>If Not Def Conditional</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Not Def Conditional</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.IfNotDefConditional
   * @generated
   */
  EClass getIfNotDefConditional();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.IfNotDefConditional#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.IfNotDefConditional#getId()
   * @see #getIfNotDefConditional()
   * @generated
   */
  EAttribute getIfNotDefConditional_Id();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.IfNotDefConditional#getGroup <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Group</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.IfNotDefConditional#getGroup()
   * @see #getIfNotDefConditional()
   * @generated
   */
  EReference getIfNotDefConditional_Group();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.PragmaDirective <em>Pragma Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pragma Directive</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.PragmaDirective
   * @generated
   */
  EClass getPragmaDirective();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.NullDirective <em>Null Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Null Directive</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.NullDirective
   * @generated
   */
  EClass getNullDirective();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.ShadowExpression <em>Shadow Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Shadow Expression</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.ShadowExpression
   * @generated
   */
  EClass getShadowExpression();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.Expression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.Expression#getExpression()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Expression();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.UnaryOperator <em>Unary Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Operator</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.UnaryOperator
   * @generated
   */
  EClass getUnaryOperator();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.UnaryOperator#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.UnaryOperator#getOp()
   * @see #getUnaryOperator()
   * @generated
   */
  EAttribute getUnaryOperator_Op();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives <em>Preprocessor Directives</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preprocessor Directives</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives
   * @generated
   */
  EClass getPreprocessorDirectives();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives#getDirective <em>Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Directive</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives#getDirective()
   * @see #getPreprocessorDirectives()
   * @generated
   */
  EReference getPreprocessorDirectives_Directive();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro <em>Define Object Macro</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Define Object Macro</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro
   * @generated
   */
  EClass getDefineObjectMacro();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro <em>Define Function Like Macro</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Define Function Like Macro</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro
   * @generated
   */
  EClass getDefineFunctionLikeMacro();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro#getList <em>List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>List</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro#getList()
   * @see #getDefineFunctionLikeMacro()
   * @generated
   */
  EReference getDefineFunctionLikeMacro_List();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.NewLineLine <em>New Line Line</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>New Line Line</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.NewLineLine
   * @generated
   */
  EClass getNewLineLine();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.Code <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Code</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.Code
   * @generated
   */
  EClass getCode();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.Code#getCode <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Code</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.Code#getCode()
   * @see #getCode()
   * @generated
   */
  EAttribute getCode_Code();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.ConstantExpression <em>Constant Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant Expression</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.ConstantExpression
   * @generated
   */
  EClass getConstantExpression();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.ConstantExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.ConstantExpression#getExpr()
   * @see #getConstantExpression()
   * @generated
   */
  EReference getConstantExpression_Expr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.ConditionalExpression <em>Conditional Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Conditional Expression</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.ConditionalExpression
   * @generated
   */
  EClass getConditionalExpression();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.ConditionalExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.ConditionalExpression#getExpr()
   * @see #getConditionalExpression()
   * @generated
   */
  EReference getConditionalExpression_Expr();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.ConditionalExpression#getQExpr <em>QExpr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>QExpr</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.ConditionalExpression#getQExpr()
   * @see #getConditionalExpression()
   * @generated
   */
  EReference getConditionalExpression_QExpr();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.ConditionalExpression#getCExpr <em>CExpr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>CExpr</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.ConditionalExpression#getCExpr()
   * @see #getConditionalExpression()
   * @generated
   */
  EReference getConditionalExpression_CExpr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.LogicalOrExpression <em>Logical Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical Or Expression</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.LogicalOrExpression
   * @generated
   */
  EClass getLogicalOrExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.preprocess.preprocess.LogicalOrExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.LogicalOrExpression#getExpr()
   * @see #getLogicalOrExpression()
   * @generated
   */
  EReference getLogicalOrExpression_Expr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.LogicalAndExpression <em>Logical And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical And Expression</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.LogicalAndExpression
   * @generated
   */
  EClass getLogicalAndExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.preprocess.preprocess.LogicalAndExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.LogicalAndExpression#getExpr()
   * @see #getLogicalAndExpression()
   * @generated
   */
  EReference getLogicalAndExpression_Expr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.InclusiveOrExpression <em>Inclusive Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Inclusive Or Expression</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.InclusiveOrExpression
   * @generated
   */
  EClass getInclusiveOrExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.preprocess.preprocess.InclusiveOrExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.InclusiveOrExpression#getExpr()
   * @see #getInclusiveOrExpression()
   * @generated
   */
  EReference getInclusiveOrExpression_Expr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.ExclusiveOrExpression <em>Exclusive Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exclusive Or Expression</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.ExclusiveOrExpression
   * @generated
   */
  EClass getExclusiveOrExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.preprocess.preprocess.ExclusiveOrExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.ExclusiveOrExpression#getExpr()
   * @see #getExclusiveOrExpression()
   * @generated
   */
  EReference getExclusiveOrExpression_Expr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.AndExpression <em>And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Expression</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.AndExpression
   * @generated
   */
  EClass getAndExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.preprocess.preprocess.AndExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.AndExpression#getExpr()
   * @see #getAndExpression()
   * @generated
   */
  EReference getAndExpression_Expr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.EqualityExpression <em>Equality Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equality Expression</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.EqualityExpression
   * @generated
   */
  EClass getEqualityExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.preprocess.preprocess.EqualityExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.EqualityExpression#getExpr()
   * @see #getEqualityExpression()
   * @generated
   */
  EReference getEqualityExpression_Expr();

  /**
   * Returns the meta object for the attribute list '{@link at.jku.weiner.c.preprocess.preprocess.EqualityExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.EqualityExpression#getOp()
   * @see #getEqualityExpression()
   * @generated
   */
  EAttribute getEqualityExpression_Op();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.RelationalExpression <em>Relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relational Expression</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.RelationalExpression
   * @generated
   */
  EClass getRelationalExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.preprocess.preprocess.RelationalExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.RelationalExpression#getExpr()
   * @see #getRelationalExpression()
   * @generated
   */
  EReference getRelationalExpression_Expr();

  /**
   * Returns the meta object for the attribute list '{@link at.jku.weiner.c.preprocess.preprocess.RelationalExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.RelationalExpression#getOp()
   * @see #getRelationalExpression()
   * @generated
   */
  EAttribute getRelationalExpression_Op();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.ShiftExpression <em>Shift Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Shift Expression</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.ShiftExpression
   * @generated
   */
  EClass getShiftExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.preprocess.preprocess.ShiftExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.ShiftExpression#getExpr()
   * @see #getShiftExpression()
   * @generated
   */
  EReference getShiftExpression_Expr();

  /**
   * Returns the meta object for the attribute list '{@link at.jku.weiner.c.preprocess.preprocess.ShiftExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.ShiftExpression#getOp()
   * @see #getShiftExpression()
   * @generated
   */
  EAttribute getShiftExpression_Op();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.AdditiveExpression <em>Additive Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Additive Expression</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.AdditiveExpression
   * @generated
   */
  EClass getAdditiveExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.preprocess.preprocess.AdditiveExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.AdditiveExpression#getExpr()
   * @see #getAdditiveExpression()
   * @generated
   */
  EReference getAdditiveExpression_Expr();

  /**
   * Returns the meta object for the attribute list '{@link at.jku.weiner.c.preprocess.preprocess.AdditiveExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.AdditiveExpression#getOp()
   * @see #getAdditiveExpression()
   * @generated
   */
  EAttribute getAdditiveExpression_Op();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.MultiplicativeExpression <em>Multiplicative Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicative Expression</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.MultiplicativeExpression
   * @generated
   */
  EClass getMultiplicativeExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.preprocess.preprocess.MultiplicativeExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.MultiplicativeExpression#getExpr()
   * @see #getMultiplicativeExpression()
   * @generated
   */
  EReference getMultiplicativeExpression_Expr();

  /**
   * Returns the meta object for the attribute list '{@link at.jku.weiner.c.preprocess.preprocess.MultiplicativeExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.MultiplicativeExpression#getOp()
   * @see #getMultiplicativeExpression()
   * @generated
   */
  EAttribute getMultiplicativeExpression_Op();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.CastExpression <em>Cast Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cast Expression</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.CastExpression
   * @generated
   */
  EClass getCastExpression();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.CastExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.CastExpression#getExpr()
   * @see #getCastExpression()
   * @generated
   */
  EReference getCastExpression_Expr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.UnaryExpression <em>Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Expression</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.UnaryExpression
   * @generated
   */
  EClass getUnaryExpression();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.UnaryExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.UnaryExpression#getExpr()
   * @see #getUnaryExpression()
   * @generated
   */
  EReference getUnaryExpression_Expr();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.UnaryExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.UnaryExpression#getOp()
   * @see #getUnaryExpression()
   * @generated
   */
  EReference getUnaryExpression_Op();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.PostfixExpression <em>Postfix Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Postfix Expression</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.PostfixExpression
   * @generated
   */
  EClass getPostfixExpression();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.PostfixExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.PostfixExpression#getExpr()
   * @see #getPostfixExpression()
   * @generated
   */
  EReference getPostfixExpression_Expr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.PrimaryExpression <em>Primary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primary Expression</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.PrimaryExpression
   * @generated
   */
  EClass getPrimaryExpression();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#isDefined <em>Defined</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Defined</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#isDefined()
   * @see #getPrimaryExpression()
   * @generated
   */
  EAttribute getPrimaryExpression_Defined();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#getId()
   * @see #getPrimaryExpression()
   * @generated
   */
  EAttribute getPrimaryExpression_Id();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#getConst <em>Const</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Const</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#getConst()
   * @see #getPrimaryExpression()
   * @generated
   */
  EAttribute getPrimaryExpression_Const();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#getExpr()
   * @see #getPrimaryExpression()
   * @generated
   */
  EReference getPrimaryExpression_Expr();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  PreprocessFactory getPreprocessFactory();

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
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.ModelImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getModel()
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
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.TranslationUnitImpl <em>Translation Unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.TranslationUnitImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getTranslationUnit()
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
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.GroupOptImpl <em>Group Opt</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.GroupOptImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getGroupOpt()
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
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.SourceCodeLineImpl <em>Source Code Line</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.SourceCodeLineImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getSourceCodeLine()
     * @generated
     */
    EClass SOURCE_CODE_LINE = eINSTANCE.getSourceCodeLine();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.IncludeDirectiveImpl <em>Include Directive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.IncludeDirectiveImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getIncludeDirective()
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
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.DefineDirectiveImpl <em>Define Directive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.DefineDirectiveImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getDefineDirective()
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
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.IdentifierListImpl <em>Identifier List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.IdentifierListImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getIdentifierList()
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
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ErrorDirectiveImpl <em>Error Directive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.ErrorDirectiveImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getErrorDirective()
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
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.UnDefineDirectiveImpl <em>Un Define Directive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.UnDefineDirectiveImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getUnDefineDirective()
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
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ConditionalDirectiveImpl <em>Conditional Directive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.ConditionalDirectiveImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getConditionalDirective()
     * @generated
     */
    EClass CONDITIONAL_DIRECTIVE = eINSTANCE.getConditionalDirective();

    /**
     * The meta object literal for the '<em><b>Conditional</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_DIRECTIVE__CONDITIONAL = eINSTANCE.getConditionalDirective_Conditional();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.IfConditionalImpl <em>If Conditional</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.IfConditionalImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getIfConditional()
     * @generated
     */
    EClass IF_CONDITIONAL = eINSTANCE.getIfConditional();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_CONDITIONAL__EXPRESSION = eINSTANCE.getIfConditional_Expression();

    /**
     * The meta object literal for the '<em><b>Group</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_CONDITIONAL__GROUP = eINSTANCE.getIfConditional_Group();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.IfDefConditionalImpl <em>If Def Conditional</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.IfDefConditionalImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getIfDefConditional()
     * @generated
     */
    EClass IF_DEF_CONDITIONAL = eINSTANCE.getIfDefConditional();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IF_DEF_CONDITIONAL__ID = eINSTANCE.getIfDefConditional_Id();

    /**
     * The meta object literal for the '<em><b>Group</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_DEF_CONDITIONAL__GROUP = eINSTANCE.getIfDefConditional_Group();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.IfNotDefConditionalImpl <em>If Not Def Conditional</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.IfNotDefConditionalImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getIfNotDefConditional()
     * @generated
     */
    EClass IF_NOT_DEF_CONDITIONAL = eINSTANCE.getIfNotDefConditional();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IF_NOT_DEF_CONDITIONAL__ID = eINSTANCE.getIfNotDefConditional_Id();

    /**
     * The meta object literal for the '<em><b>Group</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_NOT_DEF_CONDITIONAL__GROUP = eINSTANCE.getIfNotDefConditional_Group();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.PragmaDirectiveImpl <em>Pragma Directive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PragmaDirectiveImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getPragmaDirective()
     * @generated
     */
    EClass PRAGMA_DIRECTIVE = eINSTANCE.getPragmaDirective();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.NullDirectiveImpl <em>Null Directive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.NullDirectiveImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getNullDirective()
     * @generated
     */
    EClass NULL_DIRECTIVE = eINSTANCE.getNullDirective();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ShadowExpressionImpl <em>Shadow Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.ShadowExpressionImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getShadowExpression()
     * @generated
     */
    EClass SHADOW_EXPRESSION = eINSTANCE.getShadowExpression();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.ExpressionImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__EXPRESSION = eINSTANCE.getExpression_Expression();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.UnaryOperatorImpl <em>Unary Operator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.UnaryOperatorImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getUnaryOperator()
     * @generated
     */
    EClass UNARY_OPERATOR = eINSTANCE.getUnaryOperator();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNARY_OPERATOR__OP = eINSTANCE.getUnaryOperator_Op();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.PreprocessorDirectivesImpl <em>Preprocessor Directives</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessorDirectivesImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getPreprocessorDirectives()
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
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.DefineObjectMacroImpl <em>Define Object Macro</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.DefineObjectMacroImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getDefineObjectMacro()
     * @generated
     */
    EClass DEFINE_OBJECT_MACRO = eINSTANCE.getDefineObjectMacro();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.DefineFunctionLikeMacroImpl <em>Define Function Like Macro</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.DefineFunctionLikeMacroImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getDefineFunctionLikeMacro()
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
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.NewLineLineImpl <em>New Line Line</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.NewLineLineImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getNewLineLine()
     * @generated
     */
    EClass NEW_LINE_LINE = eINSTANCE.getNewLineLine();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.CodeImpl <em>Code</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.CodeImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getCode()
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

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ConstantExpressionImpl <em>Constant Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.ConstantExpressionImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getConstantExpression()
     * @generated
     */
    EClass CONSTANT_EXPRESSION = eINSTANCE.getConstantExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTANT_EXPRESSION__EXPR = eINSTANCE.getConstantExpression_Expr();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ConditionalExpressionImpl <em>Conditional Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.ConditionalExpressionImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getConditionalExpression()
     * @generated
     */
    EClass CONDITIONAL_EXPRESSION = eINSTANCE.getConditionalExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_EXPRESSION__EXPR = eINSTANCE.getConditionalExpression_Expr();

    /**
     * The meta object literal for the '<em><b>QExpr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_EXPRESSION__QEXPR = eINSTANCE.getConditionalExpression_QExpr();

    /**
     * The meta object literal for the '<em><b>CExpr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_EXPRESSION__CEXPR = eINSTANCE.getConditionalExpression_CExpr();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.LogicalOrExpressionImpl <em>Logical Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.LogicalOrExpressionImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getLogicalOrExpression()
     * @generated
     */
    EClass LOGICAL_OR_EXPRESSION = eINSTANCE.getLogicalOrExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_OR_EXPRESSION__EXPR = eINSTANCE.getLogicalOrExpression_Expr();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.LogicalAndExpressionImpl <em>Logical And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.LogicalAndExpressionImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getLogicalAndExpression()
     * @generated
     */
    EClass LOGICAL_AND_EXPRESSION = eINSTANCE.getLogicalAndExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_AND_EXPRESSION__EXPR = eINSTANCE.getLogicalAndExpression_Expr();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.InclusiveOrExpressionImpl <em>Inclusive Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.InclusiveOrExpressionImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getInclusiveOrExpression()
     * @generated
     */
    EClass INCLUSIVE_OR_EXPRESSION = eINSTANCE.getInclusiveOrExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INCLUSIVE_OR_EXPRESSION__EXPR = eINSTANCE.getInclusiveOrExpression_Expr();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ExclusiveOrExpressionImpl <em>Exclusive Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.ExclusiveOrExpressionImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getExclusiveOrExpression()
     * @generated
     */
    EClass EXCLUSIVE_OR_EXPRESSION = eINSTANCE.getExclusiveOrExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXCLUSIVE_OR_EXPRESSION__EXPR = eINSTANCE.getExclusiveOrExpression_Expr();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.AndExpressionImpl <em>And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.AndExpressionImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getAndExpression()
     * @generated
     */
    EClass AND_EXPRESSION = eINSTANCE.getAndExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_EXPRESSION__EXPR = eINSTANCE.getAndExpression_Expr();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.EqualityExpressionImpl <em>Equality Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.EqualityExpressionImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getEqualityExpression()
     * @generated
     */
    EClass EQUALITY_EXPRESSION = eINSTANCE.getEqualityExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_EXPRESSION__EXPR = eINSTANCE.getEqualityExpression_Expr();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EQUALITY_EXPRESSION__OP = eINSTANCE.getEqualityExpression_Op();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.RelationalExpressionImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getRelationalExpression()
     * @generated
     */
    EClass RELATIONAL_EXPRESSION = eINSTANCE.getRelationalExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_EXPRESSION__EXPR = eINSTANCE.getRelationalExpression_Expr();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATIONAL_EXPRESSION__OP = eINSTANCE.getRelationalExpression_Op();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ShiftExpressionImpl <em>Shift Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.ShiftExpressionImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getShiftExpression()
     * @generated
     */
    EClass SHIFT_EXPRESSION = eINSTANCE.getShiftExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SHIFT_EXPRESSION__EXPR = eINSTANCE.getShiftExpression_Expr();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SHIFT_EXPRESSION__OP = eINSTANCE.getShiftExpression_Op();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.AdditiveExpressionImpl <em>Additive Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.AdditiveExpressionImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getAdditiveExpression()
     * @generated
     */
    EClass ADDITIVE_EXPRESSION = eINSTANCE.getAdditiveExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADDITIVE_EXPRESSION__EXPR = eINSTANCE.getAdditiveExpression_Expr();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ADDITIVE_EXPRESSION__OP = eINSTANCE.getAdditiveExpression_Op();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.MultiplicativeExpressionImpl <em>Multiplicative Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.MultiplicativeExpressionImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getMultiplicativeExpression()
     * @generated
     */
    EClass MULTIPLICATIVE_EXPRESSION = eINSTANCE.getMultiplicativeExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICATIVE_EXPRESSION__EXPR = eINSTANCE.getMultiplicativeExpression_Expr();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTIPLICATIVE_EXPRESSION__OP = eINSTANCE.getMultiplicativeExpression_Op();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.CastExpressionImpl <em>Cast Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.CastExpressionImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getCastExpression()
     * @generated
     */
    EClass CAST_EXPRESSION = eINSTANCE.getCastExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAST_EXPRESSION__EXPR = eINSTANCE.getCastExpression_Expr();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.UnaryExpressionImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getUnaryExpression()
     * @generated
     */
    EClass UNARY_EXPRESSION = eINSTANCE.getUnaryExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_EXPRESSION__EXPR = eINSTANCE.getUnaryExpression_Expr();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_EXPRESSION__OP = eINSTANCE.getUnaryExpression_Op();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.PostfixExpressionImpl <em>Postfix Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PostfixExpressionImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getPostfixExpression()
     * @generated
     */
    EClass POSTFIX_EXPRESSION = eINSTANCE.getPostfixExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POSTFIX_EXPRESSION__EXPR = eINSTANCE.getPostfixExpression_Expr();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.PrimaryExpressionImpl <em>Primary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PrimaryExpressionImpl
     * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getPrimaryExpression()
     * @generated
     */
    EClass PRIMARY_EXPRESSION = eINSTANCE.getPrimaryExpression();

    /**
     * The meta object literal for the '<em><b>Defined</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIMARY_EXPRESSION__DEFINED = eINSTANCE.getPrimaryExpression_Defined();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIMARY_EXPRESSION__ID = eINSTANCE.getPrimaryExpression_Id();

    /**
     * The meta object literal for the '<em><b>Const</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIMARY_EXPRESSION__CONST = eINSTANCE.getPrimaryExpression_Const();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_EXPRESSION__EXPR = eINSTANCE.getPrimaryExpression_Expr();

  }

} //PreprocessPackage
