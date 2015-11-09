/**
 */
package at.jku.weiner.cpreprocess.cPreprocess.impl;

import at.jku.weiner.cpreprocess.cPreprocess.*;

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
public class CPreprocessFactoryImpl extends EFactoryImpl implements CPreprocessFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static CPreprocessFactory init()
  {
    try
    {
      CPreprocessFactory theCPreprocessFactory = (CPreprocessFactory)EPackage.Registry.INSTANCE.getEFactory(CPreprocessPackage.eNS_URI);
      if (theCPreprocessFactory != null)
      {
        return theCPreprocessFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new CPreprocessFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CPreprocessFactoryImpl()
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
      case CPreprocessPackage.MODEL: return createModel();
      case CPreprocessPackage.TRANSLATION_UNIT: return createTranslationUnit();
      case CPreprocessPackage.SOURCE_CODE_LINE: return createSourceCodeLine();
      case CPreprocessPackage.INCLUDE_DIRECTIVE: return createIncludeDirective();
      case CPreprocessPackage.PREPROCESSOR_DIRECTIVES: return createPreprocessorDirectives();
      case CPreprocessPackage.NEW_LINE_LINE: return createNewLineLine();
      case CPreprocessPackage.CODE: return createCode();
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
  public CPreprocessPackage getCPreprocessPackage()
  {
    return (CPreprocessPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static CPreprocessPackage getPackage()
  {
    return CPreprocessPackage.eINSTANCE;
  }

} //CPreprocessFactoryImpl
