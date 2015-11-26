/**
 */
package at.jku.weiner.cpreprocess.cPreprocess.impl;

import at.jku.weiner.cpreprocess.cPreprocess.CPreprocessFactory;
import at.jku.weiner.cpreprocess.cPreprocess.CPreprocessPackage;
import at.jku.weiner.cpreprocess.cPreprocess.Code;
import at.jku.weiner.cpreprocess.cPreprocess.ConditionalDirective;
import at.jku.weiner.cpreprocess.cPreprocess.DefineDirective;
import at.jku.weiner.cpreprocess.cPreprocess.DefineFunctionLikeMacro;
import at.jku.weiner.cpreprocess.cPreprocess.DefineObjectMacro;
import at.jku.weiner.cpreprocess.cPreprocess.ErrorDirective;
import at.jku.weiner.cpreprocess.cPreprocess.GroupOpt;
import at.jku.weiner.cpreprocess.cPreprocess.IdentifierList;
import at.jku.weiner.cpreprocess.cPreprocess.IfDefConditional;
import at.jku.weiner.cpreprocess.cPreprocess.IfNotDefConditional;
import at.jku.weiner.cpreprocess.cPreprocess.IncludeDirective;
import at.jku.weiner.cpreprocess.cPreprocess.Model;
import at.jku.weiner.cpreprocess.cPreprocess.NewLineLine;
import at.jku.weiner.cpreprocess.cPreprocess.NullDirective;
import at.jku.weiner.cpreprocess.cPreprocess.PragmaDirective;
import at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives;
import at.jku.weiner.cpreprocess.cPreprocess.SourceCodeLine;
import at.jku.weiner.cpreprocess.cPreprocess.TranslationUnit;
import at.jku.weiner.cpreprocess.cPreprocess.UnDefineDirective;

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
  private EClass groupOptEClass = null;

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
  private EClass defineDirectiveEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass identifierListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorDirectiveEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unDefineDirectiveEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionalDirectiveEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifDefConditionalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifNotDefConditionalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pragmaDirectiveEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nullDirectiveEClass = null;

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
  private EClass defineObjectMacroEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass defineFunctionLikeMacroEClass = null;

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
  public EReference getTranslationUnit_Group()
  {
    return (EReference)translationUnitEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGroupOpt()
  {
    return groupOptEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGroupOpt_Lines()
  {
    return (EReference)groupOptEClass.getEStructuralFeatures().get(0);
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
  public EClass getDefineDirective()
  {
    return defineDirectiveEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDefineDirective_Id()
  {
    return (EAttribute)defineDirectiveEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDefineDirective_String()
  {
    return (EAttribute)defineDirectiveEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIdentifierList()
  {
    return identifierListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIdentifierList_Id()
  {
    return (EAttribute)identifierListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorDirective()
  {
    return errorDirectiveEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorDirective_Msg()
  {
    return (EAttribute)errorDirectiveEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnDefineDirective()
  {
    return unDefineDirectiveEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnDefineDirective_Id()
  {
    return (EAttribute)unDefineDirectiveEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionalDirective()
  {
    return conditionalDirectiveEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalDirective_Conditional()
  {
    return (EReference)conditionalDirectiveEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfDefConditional()
  {
    return ifDefConditionalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIfDefConditional_Id()
  {
    return (EAttribute)ifDefConditionalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfDefConditional_Group()
  {
    return (EReference)ifDefConditionalEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfNotDefConditional()
  {
    return ifNotDefConditionalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIfNotDefConditional_Id()
  {
    return (EAttribute)ifNotDefConditionalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfNotDefConditional_Group()
  {
    return (EReference)ifNotDefConditionalEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPragmaDirective()
  {
    return pragmaDirectiveEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNullDirective()
  {
    return nullDirectiveEClass;
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
  public EClass getDefineObjectMacro()
  {
    return defineObjectMacroEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDefineFunctionLikeMacro()
  {
    return defineFunctionLikeMacroEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDefineFunctionLikeMacro_List()
  {
    return (EReference)defineFunctionLikeMacroEClass.getEStructuralFeatures().get(0);
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
    createEReference(translationUnitEClass, TRANSLATION_UNIT__GROUP);

    groupOptEClass = createEClass(GROUP_OPT);
    createEReference(groupOptEClass, GROUP_OPT__LINES);

    sourceCodeLineEClass = createEClass(SOURCE_CODE_LINE);

    includeDirectiveEClass = createEClass(INCLUDE_DIRECTIVE);
    createEAttribute(includeDirectiveEClass, INCLUDE_DIRECTIVE__STRING);

    defineDirectiveEClass = createEClass(DEFINE_DIRECTIVE);
    createEAttribute(defineDirectiveEClass, DEFINE_DIRECTIVE__ID);
    createEAttribute(defineDirectiveEClass, DEFINE_DIRECTIVE__STRING);

    identifierListEClass = createEClass(IDENTIFIER_LIST);
    createEAttribute(identifierListEClass, IDENTIFIER_LIST__ID);

    errorDirectiveEClass = createEClass(ERROR_DIRECTIVE);
    createEAttribute(errorDirectiveEClass, ERROR_DIRECTIVE__MSG);

    unDefineDirectiveEClass = createEClass(UN_DEFINE_DIRECTIVE);
    createEAttribute(unDefineDirectiveEClass, UN_DEFINE_DIRECTIVE__ID);

    conditionalDirectiveEClass = createEClass(CONDITIONAL_DIRECTIVE);
    createEReference(conditionalDirectiveEClass, CONDITIONAL_DIRECTIVE__CONDITIONAL);

    ifDefConditionalEClass = createEClass(IF_DEF_CONDITIONAL);
    createEAttribute(ifDefConditionalEClass, IF_DEF_CONDITIONAL__ID);
    createEReference(ifDefConditionalEClass, IF_DEF_CONDITIONAL__GROUP);

    ifNotDefConditionalEClass = createEClass(IF_NOT_DEF_CONDITIONAL);
    createEAttribute(ifNotDefConditionalEClass, IF_NOT_DEF_CONDITIONAL__ID);
    createEReference(ifNotDefConditionalEClass, IF_NOT_DEF_CONDITIONAL__GROUP);

    pragmaDirectiveEClass = createEClass(PRAGMA_DIRECTIVE);

    nullDirectiveEClass = createEClass(NULL_DIRECTIVE);

    preprocessorDirectivesEClass = createEClass(PREPROCESSOR_DIRECTIVES);
    createEReference(preprocessorDirectivesEClass, PREPROCESSOR_DIRECTIVES__DIRECTIVE);

    defineObjectMacroEClass = createEClass(DEFINE_OBJECT_MACRO);

    defineFunctionLikeMacroEClass = createEClass(DEFINE_FUNCTION_LIKE_MACRO);
    createEReference(defineFunctionLikeMacroEClass, DEFINE_FUNCTION_LIKE_MACRO__LIST);

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
    defineObjectMacroEClass.getESuperTypes().add(this.getDefineDirective());
    defineFunctionLikeMacroEClass.getESuperTypes().add(this.getDefineDirective());
    newLineLineEClass.getESuperTypes().add(this.getSourceCodeLine());
    codeEClass.getESuperTypes().add(this.getSourceCodeLine());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_Units(), this.getTranslationUnit(), null, "units", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(translationUnitEClass, TranslationUnit.class, "TranslationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTranslationUnit_Group(), this.getGroupOpt(), null, "group", null, 0, 1, TranslationUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(groupOptEClass, GroupOpt.class, "GroupOpt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGroupOpt_Lines(), this.getSourceCodeLine(), null, "lines", null, 0, -1, GroupOpt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sourceCodeLineEClass, SourceCodeLine.class, "SourceCodeLine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(includeDirectiveEClass, IncludeDirective.class, "IncludeDirective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIncludeDirective_String(), ecorePackage.getEString(), "string", null, 0, 1, IncludeDirective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(defineDirectiveEClass, DefineDirective.class, "DefineDirective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDefineDirective_Id(), ecorePackage.getEString(), "id", null, 0, 1, DefineDirective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDefineDirective_String(), ecorePackage.getEString(), "string", null, 0, 1, DefineDirective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(identifierListEClass, IdentifierList.class, "IdentifierList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIdentifierList_Id(), ecorePackage.getEString(), "id", null, 0, -1, IdentifierList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorDirectiveEClass, ErrorDirective.class, "ErrorDirective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getErrorDirective_Msg(), ecorePackage.getEString(), "msg", null, 0, 1, ErrorDirective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unDefineDirectiveEClass, UnDefineDirective.class, "UnDefineDirective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnDefineDirective_Id(), ecorePackage.getEString(), "id", null, 0, 1, UnDefineDirective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(conditionalDirectiveEClass, ConditionalDirective.class, "ConditionalDirective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConditionalDirective_Conditional(), ecorePackage.getEObject(), null, "conditional", null, 0, 1, ConditionalDirective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ifDefConditionalEClass, IfDefConditional.class, "IfDefConditional", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIfDefConditional_Id(), ecorePackage.getEString(), "id", null, 0, 1, IfDefConditional.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfDefConditional_Group(), this.getGroupOpt(), null, "group", null, 0, 1, IfDefConditional.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ifNotDefConditionalEClass, IfNotDefConditional.class, "IfNotDefConditional", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIfNotDefConditional_Id(), ecorePackage.getEString(), "id", null, 0, 1, IfNotDefConditional.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfNotDefConditional_Group(), this.getGroupOpt(), null, "group", null, 0, 1, IfNotDefConditional.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pragmaDirectiveEClass, PragmaDirective.class, "PragmaDirective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(nullDirectiveEClass, NullDirective.class, "NullDirective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(preprocessorDirectivesEClass, PreprocessorDirectives.class, "PreprocessorDirectives", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPreprocessorDirectives_Directive(), ecorePackage.getEObject(), null, "directive", null, 0, 1, PreprocessorDirectives.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(defineObjectMacroEClass, DefineObjectMacro.class, "DefineObjectMacro", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(defineFunctionLikeMacroEClass, DefineFunctionLikeMacro.class, "DefineFunctionLikeMacro", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDefineFunctionLikeMacro_List(), this.getIdentifierList(), null, "list", null, 0, 1, DefineFunctionLikeMacro.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(newLineLineEClass, NewLineLine.class, "NewLineLine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(codeEClass, Code.class, "Code", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCode_Code(), ecorePackage.getEString(), "code", null, 0, 1, Code.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //CPreprocessPackageImpl
