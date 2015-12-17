/**
 */
package at.jku.weiner.c.preprocess.preprocess.util;

import at.jku.weiner.c.preprocess.preprocess.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage
 * @generated
 */
public class PreprocessAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static PreprocessPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PreprocessAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = PreprocessPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PreprocessSwitch<Adapter> modelSwitch =
    new PreprocessSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseTranslationUnit(TranslationUnit object)
      {
        return createTranslationUnitAdapter();
      }
      @Override
      public Adapter caseGroupOpt(GroupOpt object)
      {
        return createGroupOptAdapter();
      }
      @Override
      public Adapter caseSourceCodeLine(SourceCodeLine object)
      {
        return createSourceCodeLineAdapter();
      }
      @Override
      public Adapter caseIncludeDirective(IncludeDirective object)
      {
        return createIncludeDirectiveAdapter();
      }
      @Override
      public Adapter caseDefineDirective(DefineDirective object)
      {
        return createDefineDirectiveAdapter();
      }
      @Override
      public Adapter caseIdentifierList(IdentifierList object)
      {
        return createIdentifierListAdapter();
      }
      @Override
      public Adapter caseErrorDirective(ErrorDirective object)
      {
        return createErrorDirectiveAdapter();
      }
      @Override
      public Adapter caseWarningDirective(WarningDirective object)
      {
        return createWarningDirectiveAdapter();
      }
      @Override
      public Adapter caseUnDefineDirective(UnDefineDirective object)
      {
        return createUnDefineDirectiveAdapter();
      }
      @Override
      public Adapter caseConditionalDirective(ConditionalDirective object)
      {
        return createConditionalDirectiveAdapter();
      }
      @Override
      public Adapter caseIfConditional(IfConditional object)
      {
        return createIfConditionalAdapter();
      }
      @Override
      public Adapter caseIfDefConditional(IfDefConditional object)
      {
        return createIfDefConditionalAdapter();
      }
      @Override
      public Adapter caseIfNotDefConditional(IfNotDefConditional object)
      {
        return createIfNotDefConditionalAdapter();
      }
      @Override
      public Adapter caseElIfConditional(ElIfConditional object)
      {
        return createElIfConditionalAdapter();
      }
      @Override
      public Adapter caseElseConditional(ElseConditional object)
      {
        return createElseConditionalAdapter();
      }
      @Override
      public Adapter casePragmaDirective(PragmaDirective object)
      {
        return createPragmaDirectiveAdapter();
      }
      @Override
      public Adapter caseNullDirective(NullDirective object)
      {
        return createNullDirectiveAdapter();
      }
      @Override
      public Adapter caseShadowExpression(ShadowExpression object)
      {
        return createShadowExpressionAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseUnaryOperator(UnaryOperator object)
      {
        return createUnaryOperatorAdapter();
      }
      @Override
      public Adapter casePostfixExpressionSuffix(PostfixExpressionSuffix object)
      {
        return createPostfixExpressionSuffixAdapter();
      }
      @Override
      public Adapter caseArgumentExpressionList(ArgumentExpressionList object)
      {
        return createArgumentExpressionListAdapter();
      }
      @Override
      public Adapter casePreprocessorDirectives(PreprocessorDirectives object)
      {
        return createPreprocessorDirectivesAdapter();
      }
      @Override
      public Adapter caseDefineObjectMacro(DefineObjectMacro object)
      {
        return createDefineObjectMacroAdapter();
      }
      @Override
      public Adapter caseDefineFunctionLikeMacro(DefineFunctionLikeMacro object)
      {
        return createDefineFunctionLikeMacroAdapter();
      }
      @Override
      public Adapter caseNewLineLine(NewLineLine object)
      {
        return createNewLineLineAdapter();
      }
      @Override
      public Adapter caseCode(Code object)
      {
        return createCodeAdapter();
      }
      @Override
      public Adapter caseConstantExpression(ConstantExpression object)
      {
        return createConstantExpressionAdapter();
      }
      @Override
      public Adapter caseConditionalExpression(ConditionalExpression object)
      {
        return createConditionalExpressionAdapter();
      }
      @Override
      public Adapter caseLogicalOrExpression(LogicalOrExpression object)
      {
        return createLogicalOrExpressionAdapter();
      }
      @Override
      public Adapter caseLogicalAndExpression(LogicalAndExpression object)
      {
        return createLogicalAndExpressionAdapter();
      }
      @Override
      public Adapter caseInclusiveOrExpression(InclusiveOrExpression object)
      {
        return createInclusiveOrExpressionAdapter();
      }
      @Override
      public Adapter caseExclusiveOrExpression(ExclusiveOrExpression object)
      {
        return createExclusiveOrExpressionAdapter();
      }
      @Override
      public Adapter caseAndExpression(AndExpression object)
      {
        return createAndExpressionAdapter();
      }
      @Override
      public Adapter caseEqualityExpression(EqualityExpression object)
      {
        return createEqualityExpressionAdapter();
      }
      @Override
      public Adapter caseRelationalExpression(RelationalExpression object)
      {
        return createRelationalExpressionAdapter();
      }
      @Override
      public Adapter caseShiftExpression(ShiftExpression object)
      {
        return createShiftExpressionAdapter();
      }
      @Override
      public Adapter caseAdditiveExpression(AdditiveExpression object)
      {
        return createAdditiveExpressionAdapter();
      }
      @Override
      public Adapter caseMultiplicativeExpression(MultiplicativeExpression object)
      {
        return createMultiplicativeExpressionAdapter();
      }
      @Override
      public Adapter caseCastExpression(CastExpression object)
      {
        return createCastExpressionAdapter();
      }
      @Override
      public Adapter caseUnaryExpression(UnaryExpression object)
      {
        return createUnaryExpressionAdapter();
      }
      @Override
      public Adapter casePostfixExpression(PostfixExpression object)
      {
        return createPostfixExpressionAdapter();
      }
      @Override
      public Adapter casePostfixExpressionSuffixArgument(PostfixExpressionSuffixArgument object)
      {
        return createPostfixExpressionSuffixArgumentAdapter();
      }
      @Override
      public Adapter casePrimaryExpression(PrimaryExpression object)
      {
        return createPrimaryExpressionAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.TranslationUnit <em>Translation Unit</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.TranslationUnit
   * @generated
   */
  public Adapter createTranslationUnitAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.GroupOpt <em>Group Opt</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.GroupOpt
   * @generated
   */
  public Adapter createGroupOptAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.SourceCodeLine <em>Source Code Line</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.SourceCodeLine
   * @generated
   */
  public Adapter createSourceCodeLineAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.IncludeDirective <em>Include Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.IncludeDirective
   * @generated
   */
  public Adapter createIncludeDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.DefineDirective <em>Define Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.DefineDirective
   * @generated
   */
  public Adapter createDefineDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.IdentifierList <em>Identifier List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.IdentifierList
   * @generated
   */
  public Adapter createIdentifierListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.ErrorDirective <em>Error Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.ErrorDirective
   * @generated
   */
  public Adapter createErrorDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.WarningDirective <em>Warning Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.WarningDirective
   * @generated
   */
  public Adapter createWarningDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.UnDefineDirective <em>Un Define Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.UnDefineDirective
   * @generated
   */
  public Adapter createUnDefineDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.ConditionalDirective <em>Conditional Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.ConditionalDirective
   * @generated
   */
  public Adapter createConditionalDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.IfConditional <em>If Conditional</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.IfConditional
   * @generated
   */
  public Adapter createIfConditionalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.IfDefConditional <em>If Def Conditional</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.IfDefConditional
   * @generated
   */
  public Adapter createIfDefConditionalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.IfNotDefConditional <em>If Not Def Conditional</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.IfNotDefConditional
   * @generated
   */
  public Adapter createIfNotDefConditionalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.ElIfConditional <em>El If Conditional</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.ElIfConditional
   * @generated
   */
  public Adapter createElIfConditionalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.ElseConditional <em>Else Conditional</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.ElseConditional
   * @generated
   */
  public Adapter createElseConditionalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.PragmaDirective <em>Pragma Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.PragmaDirective
   * @generated
   */
  public Adapter createPragmaDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.NullDirective <em>Null Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.NullDirective
   * @generated
   */
  public Adapter createNullDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.ShadowExpression <em>Shadow Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.ShadowExpression
   * @generated
   */
  public Adapter createShadowExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.UnaryOperator <em>Unary Operator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.UnaryOperator
   * @generated
   */
  public Adapter createUnaryOperatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.PostfixExpressionSuffix <em>Postfix Expression Suffix</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.PostfixExpressionSuffix
   * @generated
   */
  public Adapter createPostfixExpressionSuffixAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.ArgumentExpressionList <em>Argument Expression List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.ArgumentExpressionList
   * @generated
   */
  public Adapter createArgumentExpressionListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives <em>Preprocessor Directives</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives
   * @generated
   */
  public Adapter createPreprocessorDirectivesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro <em>Define Object Macro</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro
   * @generated
   */
  public Adapter createDefineObjectMacroAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro <em>Define Function Like Macro</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro
   * @generated
   */
  public Adapter createDefineFunctionLikeMacroAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.NewLineLine <em>New Line Line</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.NewLineLine
   * @generated
   */
  public Adapter createNewLineLineAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.Code <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.Code
   * @generated
   */
  public Adapter createCodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.ConstantExpression <em>Constant Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.ConstantExpression
   * @generated
   */
  public Adapter createConstantExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.ConditionalExpression <em>Conditional Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.ConditionalExpression
   * @generated
   */
  public Adapter createConditionalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.LogicalOrExpression <em>Logical Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.LogicalOrExpression
   * @generated
   */
  public Adapter createLogicalOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.LogicalAndExpression <em>Logical And Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.LogicalAndExpression
   * @generated
   */
  public Adapter createLogicalAndExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.InclusiveOrExpression <em>Inclusive Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.InclusiveOrExpression
   * @generated
   */
  public Adapter createInclusiveOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.ExclusiveOrExpression <em>Exclusive Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.ExclusiveOrExpression
   * @generated
   */
  public Adapter createExclusiveOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.AndExpression <em>And Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.AndExpression
   * @generated
   */
  public Adapter createAndExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.EqualityExpression <em>Equality Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.EqualityExpression
   * @generated
   */
  public Adapter createEqualityExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.RelationalExpression <em>Relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.RelationalExpression
   * @generated
   */
  public Adapter createRelationalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.ShiftExpression <em>Shift Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.ShiftExpression
   * @generated
   */
  public Adapter createShiftExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.AdditiveExpression <em>Additive Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.AdditiveExpression
   * @generated
   */
  public Adapter createAdditiveExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.MultiplicativeExpression <em>Multiplicative Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.MultiplicativeExpression
   * @generated
   */
  public Adapter createMultiplicativeExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.CastExpression <em>Cast Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.CastExpression
   * @generated
   */
  public Adapter createCastExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.UnaryExpression <em>Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.UnaryExpression
   * @generated
   */
  public Adapter createUnaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.PostfixExpression <em>Postfix Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.PostfixExpression
   * @generated
   */
  public Adapter createPostfixExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.PostfixExpressionSuffixArgument <em>Postfix Expression Suffix Argument</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.PostfixExpressionSuffixArgument
   * @generated
   */
  public Adapter createPostfixExpressionSuffixArgumentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.preprocess.preprocess.PrimaryExpression <em>Primary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.preprocess.preprocess.PrimaryExpression
   * @generated
   */
  public Adapter createPrimaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //PreprocessAdapterFactory
