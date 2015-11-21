/**
 */
package at.jku.weiner.cpreprocess.cPreprocess.util;

import at.jku.weiner.cpreprocess.cPreprocess.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see at.jku.weiner.cpreprocess.cPreprocess.CPreprocessPackage
 * @generated
 */
public class CPreprocessAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static CPreprocessPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CPreprocessAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = CPreprocessPackage.eINSTANCE;
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
  protected CPreprocessSwitch<Adapter> modelSwitch =
    new CPreprocessSwitch<Adapter>()
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
      public Adapter caseUnDefineDirective(UnDefineDirective object)
      {
        return createUnDefineDirectiveAdapter();
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
   * Creates a new adapter for an object of class '{@link at.jku.weiner.cpreprocess.cPreprocess.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.cpreprocess.cPreprocess.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.cpreprocess.cPreprocess.TranslationUnit <em>Translation Unit</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.cpreprocess.cPreprocess.TranslationUnit
   * @generated
   */
  public Adapter createTranslationUnitAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.cpreprocess.cPreprocess.GroupOpt <em>Group Opt</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.cpreprocess.cPreprocess.GroupOpt
   * @generated
   */
  public Adapter createGroupOptAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.cpreprocess.cPreprocess.SourceCodeLine <em>Source Code Line</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.cpreprocess.cPreprocess.SourceCodeLine
   * @generated
   */
  public Adapter createSourceCodeLineAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.cpreprocess.cPreprocess.IncludeDirective <em>Include Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.cpreprocess.cPreprocess.IncludeDirective
   * @generated
   */
  public Adapter createIncludeDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.cpreprocess.cPreprocess.DefineDirective <em>Define Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.cpreprocess.cPreprocess.DefineDirective
   * @generated
   */
  public Adapter createDefineDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.cpreprocess.cPreprocess.IdentifierList <em>Identifier List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.cpreprocess.cPreprocess.IdentifierList
   * @generated
   */
  public Adapter createIdentifierListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.cpreprocess.cPreprocess.ErrorDirective <em>Error Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.cpreprocess.cPreprocess.ErrorDirective
   * @generated
   */
  public Adapter createErrorDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.cpreprocess.cPreprocess.UnDefineDirective <em>Un Define Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.cpreprocess.cPreprocess.UnDefineDirective
   * @generated
   */
  public Adapter createUnDefineDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.cpreprocess.cPreprocess.PragmaDirective <em>Pragma Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.cpreprocess.cPreprocess.PragmaDirective
   * @generated
   */
  public Adapter createPragmaDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.cpreprocess.cPreprocess.NullDirective <em>Null Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.cpreprocess.cPreprocess.NullDirective
   * @generated
   */
  public Adapter createNullDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives <em>Preprocessor Directives</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives
   * @generated
   */
  public Adapter createPreprocessorDirectivesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.cpreprocess.cPreprocess.DefineObjectMacro <em>Define Object Macro</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.cpreprocess.cPreprocess.DefineObjectMacro
   * @generated
   */
  public Adapter createDefineObjectMacroAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.cpreprocess.cPreprocess.DefineFunctionLikeMacro <em>Define Function Like Macro</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.cpreprocess.cPreprocess.DefineFunctionLikeMacro
   * @generated
   */
  public Adapter createDefineFunctionLikeMacroAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.cpreprocess.cPreprocess.NewLineLine <em>New Line Line</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.cpreprocess.cPreprocess.NewLineLine
   * @generated
   */
  public Adapter createNewLineLineAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.cpreprocess.cPreprocess.Code <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.cpreprocess.cPreprocess.Code
   * @generated
   */
  public Adapter createCodeAdapter()
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

} //CPreprocessAdapterFactory
