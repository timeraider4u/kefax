/**
 */
package at.jku.weiner.cpreprocess.cPreprocess.impl;

import at.jku.weiner.cpreprocess.cPreprocess.CPreprocessFactory;
import at.jku.weiner.cpreprocess.cPreprocess.CPreprocessPackage;
import at.jku.weiner.cpreprocess.cPreprocess.Code;
import at.jku.weiner.cpreprocess.cPreprocess.IncludeDirective;
import at.jku.weiner.cpreprocess.cPreprocess.Model;
import at.jku.weiner.cpreprocess.cPreprocess.NewLineLine;
import at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives;
import at.jku.weiner.cpreprocess.cPreprocess.SourceCodeLine;
import at.jku.weiner.cpreprocess.cPreprocess.TranslationUnit;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CPreprocessPackageImpl extends EPackageImpl implements CPreprocessPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass translationUnitEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sourceCodeLineEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass includeDirectiveEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preprocessorDirectivesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass newLineLineEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass codeEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see at.jku.weiner.cpreprocess.cPreprocess.CPreprocessPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private CPreprocessPackageImpl()
  {
    super(eNS_URI, CPreprocessFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link CPreprocessPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static CPreprocessPackage init()
  {
    if (isInited) return (CPreprocessPackage)EPackage.Registry.INSTANCE.getEPackage(CPreprocessPackage.eNS_URI);

    // Obtain or create and register package
    CPreprocessPackageImpl theCPreprocessPackage = (CPreprocessPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CPreprocessPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CPreprocessPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theCPreprocessPackage.createPackageContents();

    // Initialize created meta-data
    theCPreprocessPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theCPreprocessPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(CPreprocessPackage.eNS_URI, theCPreprocessPackage);
    return theCPreprocessPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Units()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTranslationUnit()
  {
    return translationUnitEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTranslationUnit_Lines()
  {
    return (EReference)translationUnitEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSourceCodeLine()
  {
    return sourceCodeLineEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIncludeDirective()
  {
    return includeDirectiveEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIncludeDirective_String()
  {
    return (EAttribute)includeDirectiveEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreprocessorDirectives()
  {
    return preprocessorDirectivesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPreprocessorDirectives_Directive()
  {
    return (EReference)preprocessorDirectivesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNewLineLine()
  {
    return newLineLineEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCode()
  {
    return codeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCode_Code()
  {
    return (EAttribute)codeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CPreprocessFactory getCPreprocessFactory()
  {
    return (CPreprocessFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    modelEClass = createEClass(MODEL);
    createEReference(modelEClass, MODEL__UNITS);

    translationUnitEClass = createEClass(TRANSLATION_UNIT);
    createEReference(translationUnitEClass, TRANSLATION_UNIT__LINES);

    sourceCodeLineEClass = createEClass(SOURCE_CODE_LINE);

    includeDirectiveEClass = createEClass(INCLUDE_DIRECTIVE);
    createEAttribute(includeDirectiveEClass, INCLUDE_DIRECTIVE__STRING);

    preprocessorDirectivesEClass = createEClass(PREPROCESSOR_DIRECTIVES);
    createEReference(preprocessorDirectivesEClass, PREPROCESSOR_DIRECTIVES__DIRECTIVE);

    newLineLineEClass = createEClass(NEW_LINE_LINE);

    codeEClass = createEClass(CODE);
    createEAttribute(codeEClass, CODE__CODE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    preprocessorDirectivesEClass.getESuperTypes().add(this.getSourceCodeLine());
    newLineLineEClass.getESuperTypes().add(this.getSourceCodeLine());
    codeEClass.getESuperTypes().add(this.getSourceCodeLine());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_Units(), this.getTranslationUnit(), null, "units", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(translationUnitEClass, TranslationUnit.class, "TranslationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTranslationUnit_Lines(), this.getSourceCodeLine(), null, "lines", null, 0, -1, TranslationUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sourceCodeLineEClass, SourceCodeLine.class, "SourceCodeLine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(includeDirectiveEClass, IncludeDirective.class, "IncludeDirective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIncludeDirective_String(), ecorePackage.getEString(), "string", null, 0, 1, IncludeDirective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(preprocessorDirectivesEClass, PreprocessorDirectives.class, "PreprocessorDirectives", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPreprocessorDirectives_Directive(), this.getIncludeDirective(), null, "directive", null, 0, 1, PreprocessorDirectives.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(newLineLineEClass, NewLineLine.class, "NewLineLine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(codeEClass, Code.class, "Code", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCode_Code(), ecorePackage.getEString(), "code", null, 0, 1, Code.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //CPreprocessPackageImpl
