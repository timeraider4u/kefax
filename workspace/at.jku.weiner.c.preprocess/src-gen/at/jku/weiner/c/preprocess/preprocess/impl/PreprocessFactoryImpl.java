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
      case PreprocessPackage.EXPRESSION: return createExpression();
      case PreprocessPackage.PREPROCESS: return createPreprocess();
      case PreprocessPackage.GROUP_OPT2: return createGroupOpt2();
      case PreprocessPackage.PREPROCESSOR_DIRECTIVES: return createPreprocessorDirectives();
      case PreprocessPackage.DEFINE_OBJECT_MACRO: return createDefineObjectMacro();
      case PreprocessPackage.DEFINE_FUNCTION_LIKE_MACRO: return createDefineFunctionLikeMacro();
      case PreprocessPackage.NEW_LINE_LINE: return createNewLineLine();
      case PreprocessPackage.CODE: return createCode();
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
  public Preprocess createPreprocess()
  {
    PreprocessImpl preprocess = new PreprocessImpl();
    return preprocess;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GroupOpt2 createGroupOpt2()
  {
    GroupOpt2Impl groupOpt2 = new GroupOpt2Impl();
    return groupOpt2;
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
