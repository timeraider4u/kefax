/**
 */
package at.jku.weiner.c.preprocess.preprocess.impl;

import at.jku.weiner.c.preprocess.preprocess.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PreprocessFactoryImpl extends EFactoryImpl implements PreprocessFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PreprocessFactory init()
  {
    try
    {
      PreprocessFactory thePreprocessFactory = (PreprocessFactory)EPackage.Registry.INSTANCE.getEFactory(PreprocessPackage.eNS_URI);
      if (thePreprocessFactory != null)
      {
        return thePreprocessFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new PreprocessFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PreprocessFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case PreprocessPackage.MODEL: return createModel();
      case PreprocessPackage.TRANSLATION_UNIT: return createTranslationUnit();
      case PreprocessPackage.GROUP_OPT: return createGroupOpt();
      case PreprocessPackage.SOURCE_CODE_LINE: return createSourceCodeLine();
      case PreprocessPackage.INCLUDE_DIRECTIVE: return createIncludeDirective();
      case PreprocessPackage.DEFINE_DIRECTIVE: return createDefineDirective();
      case PreprocessPackage.IDENTIFIER_LIST: return createIdentifierList();
      case PreprocessPackage.ERROR_DIRECTIVE: return createErrorDirective();
      case PreprocessPackage.WARNING_DIRECTIVE: return createWarningDirective();
      case PreprocessPackage.UN_DEFINE_DIRECTIVE: return createUnDefineDirective();
      case PreprocessPackage.CONDITIONAL_DIRECTIVE: return createConditionalDirective();
      case PreprocessPackage.IF_CONDITIONAL: return createIfConditional();
      case PreprocessPackage.IF_DEF_CONDITIONAL: return createIfDefConditional();
      case PreprocessPackage.IF_NOT_DEF_CONDITIONAL: return createIfNotDefConditional();
      case PreprocessPackage.EL_IF_CONDITIONAL: return createElIfConditional();
      case PreprocessPackage.ELSE_CONDITIONAL: return createElseConditional();
      case PreprocessPackage.PRAGMA_DIRECTIVE: return createPragmaDirective();
      case PreprocessPackage.NULL_DIRECTIVE: return createNullDirective();
      case PreprocessPackage.SHADOW_EXPRESSION: return createShadowExpression();
      case PreprocessPackage.EXPRESSION: return createExpression();
      case PreprocessPackage.UNARY_OPERATOR: return createUnaryOperator();
      case PreprocessPackage.PREPROCESSOR_DIRECTIVES: return createPreprocessorDirectives();
      case PreprocessPackage.DEFINE_OBJECT_MACRO: return createDefineObjectMacro();
      case PreprocessPackage.DEFINE_FUNCTION_LIKE_MACRO: return createDefineFunctionLikeMacro();
      case PreprocessPackage.NEW_LINE_LINE: return createNewLineLine();
      case PreprocessPackage.CODE: return createCode();
      case PreprocessPackage.CONSTANT_EXPRESSION: return createConstantExpression();
      case PreprocessPackage.CONDITIONAL_EXPRESSION: return createConditionalExpression();
      case PreprocessPackage.LOGICAL_OR_EXPRESSION: return createLogicalOrExpression();
      case PreprocessPackage.LOGICAL_AND_EXPRESSION: return createLogicalAndExpression();
      case PreprocessPackage.INCLUSIVE_OR_EXPRESSION: return createInclusiveOrExpression();
      case PreprocessPackage.EXCLUSIVE_OR_EXPRESSION: return createExclusiveOrExpression();
      case PreprocessPackage.AND_EXPRESSION: return createAndExpression();
      case PreprocessPackage.EQUALITY_EXPRESSION: return createEqualityExpression();
      case PreprocessPackage.RELATIONAL_EXPRESSION: return createRelationalExpression();
      case PreprocessPackage.SHIFT_EXPRESSION: return createShiftExpression();
      case PreprocessPackage.ADDITIVE_EXPRESSION: return createAdditiveExpression();
      case PreprocessPackage.MULTIPLICATIVE_EXPRESSION: return createMultiplicativeExpression();
      case PreprocessPackage.CAST_EXPRESSION: return createCastExpression();
      case PreprocessPackage.UNARY_EXPRESSION: return createUnaryExpression();
      case PreprocessPackage.POSTFIX_EXPRESSION: return createPostfixExpression();
      case PreprocessPackage.PRIMARY_EXPRESSION: return createPrimaryExpression();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TranslationUnit createTranslationUnit()
  {
    TranslationUnitImpl translationUnit = new TranslationUnitImpl();
    return translationUnit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GroupOpt createGroupOpt()
  {
    GroupOptImpl groupOpt = new GroupOptImpl();
    return groupOpt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SourceCodeLine createSourceCodeLine()
  {
    SourceCodeLineImpl sourceCodeLine = new SourceCodeLineImpl();
    return sourceCodeLine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IncludeDirective createIncludeDirective()
  {
    IncludeDirectiveImpl includeDirective = new IncludeDirectiveImpl();
    return includeDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefineDirective createDefineDirective()
  {
    DefineDirectiveImpl defineDirective = new DefineDirectiveImpl();
    return defineDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IdentifierList createIdentifierList()
  {
    IdentifierListImpl identifierList = new IdentifierListImpl();
    return identifierList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorDirective createErrorDirective()
  {
    ErrorDirectiveImpl errorDirective = new ErrorDirectiveImpl();
    return errorDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WarningDirective createWarningDirective()
  {
    WarningDirectiveImpl warningDirective = new WarningDirectiveImpl();
    return warningDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnDefineDirective createUnDefineDirective()
  {
    UnDefineDirectiveImpl unDefineDirective = new UnDefineDirectiveImpl();
    return unDefineDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalDirective createConditionalDirective()
  {
    ConditionalDirectiveImpl conditionalDirective = new ConditionalDirectiveImpl();
    return conditionalDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfConditional createIfConditional()
  {
    IfConditionalImpl ifConditional = new IfConditionalImpl();
    return ifConditional;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfDefConditional createIfDefConditional()
  {
    IfDefConditionalImpl ifDefConditional = new IfDefConditionalImpl();
    return ifDefConditional;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfNotDefConditional createIfNotDefConditional()
  {
    IfNotDefConditionalImpl ifNotDefConditional = new IfNotDefConditionalImpl();
    return ifNotDefConditional;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElIfConditional createElIfConditional()
  {
    ElIfConditionalImpl elIfConditional = new ElIfConditionalImpl();
    return elIfConditional;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElseConditional createElseConditional()
  {
    ElseConditionalImpl elseConditional = new ElseConditionalImpl();
    return elseConditional;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PragmaDirective createPragmaDirective()
  {
    PragmaDirectiveImpl pragmaDirective = new PragmaDirectiveImpl();
    return pragmaDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NullDirective createNullDirective()
  {
    NullDirectiveImpl nullDirective = new NullDirectiveImpl();
    return nullDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShadowExpression createShadowExpression()
  {
    ShadowExpressionImpl shadowExpression = new ShadowExpressionImpl();
    return shadowExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryOperator createUnaryOperator()
  {
    UnaryOperatorImpl unaryOperator = new UnaryOperatorImpl();
    return unaryOperator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PreprocessorDirectives createPreprocessorDirectives()
  {
    PreprocessorDirectivesImpl preprocessorDirectives = new PreprocessorDirectivesImpl();
    return preprocessorDirectives;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefineObjectMacro createDefineObjectMacro()
  {
    DefineObjectMacroImpl defineObjectMacro = new DefineObjectMacroImpl();
    return defineObjectMacro;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefineFunctionLikeMacro createDefineFunctionLikeMacro()
  {
    DefineFunctionLikeMacroImpl defineFunctionLikeMacro = new DefineFunctionLikeMacroImpl();
    return defineFunctionLikeMacro;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NewLineLine createNewLineLine()
  {
    NewLineLineImpl newLineLine = new NewLineLineImpl();
    return newLineLine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Code createCode()
  {
    CodeImpl code = new CodeImpl();
    return code;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstantExpression createConstantExpression()
  {
    ConstantExpressionImpl constantExpression = new ConstantExpressionImpl();
    return constantExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalExpression createConditionalExpression()
  {
    ConditionalExpressionImpl conditionalExpression = new ConditionalExpressionImpl();
    return conditionalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalOrExpression createLogicalOrExpression()
  {
    LogicalOrExpressionImpl logicalOrExpression = new LogicalOrExpressionImpl();
    return logicalOrExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalAndExpression createLogicalAndExpression()
  {
    LogicalAndExpressionImpl logicalAndExpression = new LogicalAndExpressionImpl();
    return logicalAndExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InclusiveOrExpression createInclusiveOrExpression()
  {
    InclusiveOrExpressionImpl inclusiveOrExpression = new InclusiveOrExpressionImpl();
    return inclusiveOrExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExclusiveOrExpression createExclusiveOrExpression()
  {
    ExclusiveOrExpressionImpl exclusiveOrExpression = new ExclusiveOrExpressionImpl();
    return exclusiveOrExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AndExpression createAndExpression()
  {
    AndExpressionImpl andExpression = new AndExpressionImpl();
    return andExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityExpression createEqualityExpression()
  {
    EqualityExpressionImpl equalityExpression = new EqualityExpressionImpl();
    return equalityExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationalExpression createRelationalExpression()
  {
    RelationalExpressionImpl relationalExpression = new RelationalExpressionImpl();
    return relationalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShiftExpression createShiftExpression()
  {
    ShiftExpressionImpl shiftExpression = new ShiftExpressionImpl();
    return shiftExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdditiveExpression createAdditiveExpression()
  {
    AdditiveExpressionImpl additiveExpression = new AdditiveExpressionImpl();
    return additiveExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicativeExpression createMultiplicativeExpression()
  {
    MultiplicativeExpressionImpl multiplicativeExpression = new MultiplicativeExpressionImpl();
    return multiplicativeExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CastExpression createCastExpression()
  {
    CastExpressionImpl castExpression = new CastExpressionImpl();
    return castExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryExpression createUnaryExpression()
  {
    UnaryExpressionImpl unaryExpression = new UnaryExpressionImpl();
    return unaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PostfixExpression createPostfixExpression()
  {
    PostfixExpressionImpl postfixExpression = new PostfixExpressionImpl();
    return postfixExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimaryExpression createPrimaryExpression()
  {
    PrimaryExpressionImpl primaryExpression = new PrimaryExpressionImpl();
    return primaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PreprocessPackage getPreprocessPackage()
  {
    return (PreprocessPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static PreprocessPackage getPackage()
  {
    return PreprocessPackage.eINSTANCE;
  }

} //PreprocessFactoryImpl
