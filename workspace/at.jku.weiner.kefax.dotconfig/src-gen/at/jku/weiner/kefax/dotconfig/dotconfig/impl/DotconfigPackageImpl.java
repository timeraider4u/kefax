/**
 */
package at.jku.weiner.kefax.dotconfig.dotconfig.impl;

import at.jku.weiner.kefax.dotconfig.dotconfig.Config;
import at.jku.weiner.kefax.dotconfig.dotconfig.ConfigLogic;
import at.jku.weiner.kefax.dotconfig.dotconfig.ConfigString;
import at.jku.weiner.kefax.dotconfig.dotconfig.DotConfigModel;
import at.jku.weiner.kefax.dotconfig.dotconfig.DotconfigFactory;
import at.jku.weiner.kefax.dotconfig.dotconfig.DotconfigPackage;

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
public class DotconfigPackageImpl extends EPackageImpl implements DotconfigPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dotConfigModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass configEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass configStringEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass configLogicEClass = null;

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
   * @see at.jku.weiner.kefax.dotconfig.dotconfig.DotconfigPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private DotconfigPackageImpl()
  {
    super(eNS_URI, DotconfigFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link DotconfigPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static DotconfigPackage init()
  {
    if (isInited) return (DotconfigPackage)EPackage.Registry.INSTANCE.getEPackage(DotconfigPackage.eNS_URI);

    // Obtain or create and register package
    DotconfigPackageImpl theDotconfigPackage = (DotconfigPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DotconfigPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DotconfigPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theDotconfigPackage.createPackageContents();

    // Initialize created meta-data
    theDotconfigPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theDotconfigPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(DotconfigPackage.eNS_URI, theDotconfigPackage);
    return theDotconfigPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDotConfigModel()
  {
    return dotConfigModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDotConfigModel_Configs()
  {
    return (EReference)dotConfigModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConfig()
  {
    return configEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConfig_Name()
  {
    return (EAttribute)configEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConfig_V()
  {
    return (EAttribute)configEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConfigString()
  {
    return configStringEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConfigLogic()
  {
    return configLogicEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DotconfigFactory getDotconfigFactory()
  {
    return (DotconfigFactory)getEFactoryInstance();
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
    dotConfigModelEClass = createEClass(DOT_CONFIG_MODEL);
    createEReference(dotConfigModelEClass, DOT_CONFIG_MODEL__CONFIGS);

    configEClass = createEClass(CONFIG);
    createEAttribute(configEClass, CONFIG__NAME);
    createEAttribute(configEClass, CONFIG__V);

    configStringEClass = createEClass(CONFIG_STRING);

    configLogicEClass = createEClass(CONFIG_LOGIC);
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
    configStringEClass.getESuperTypes().add(this.getConfig());
    configLogicEClass.getESuperTypes().add(this.getConfig());

    // Initialize classes and features; add operations and parameters
    initEClass(dotConfigModelEClass, DotConfigModel.class, "DotConfigModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDotConfigModel_Configs(), this.getConfig(), null, "Configs", null, 0, -1, DotConfigModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(configEClass, Config.class, "Config", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getConfig_Name(), ecorePackage.getEString(), "name", null, 0, 1, Config.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getConfig_V(), ecorePackage.getEString(), "v", null, 0, 1, Config.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(configStringEClass, ConfigString.class, "ConfigString", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(configLogicEClass, ConfigLogic.class, "ConfigLogic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //DotconfigPackageImpl
