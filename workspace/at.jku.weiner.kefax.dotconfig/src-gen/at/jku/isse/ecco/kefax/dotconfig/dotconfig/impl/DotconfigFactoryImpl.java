/**
 */
package at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl;

import at.jku.isse.ecco.kefax.dotconfig.dotconfig.*;

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
public class DotconfigFactoryImpl extends EFactoryImpl implements DotconfigFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static DotconfigFactory init()
  {
    try
    {
      DotconfigFactory theDotconfigFactory = (DotconfigFactory)EPackage.Registry.INSTANCE.getEFactory(DotconfigPackage.eNS_URI);
      if (theDotconfigFactory != null)
      {
        return theDotconfigFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new DotconfigFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DotconfigFactoryImpl()
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
      case DotconfigPackage.DOT_CONFIG_MODEL: return createDotConfigModel();
      case DotconfigPackage.CONFIG: return createConfig();
      case DotconfigPackage.CONFIG_STRING: return createConfigString();
      case DotconfigPackage.CONFIG_LOGIC: return createConfigLogic();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DotConfigModel createDotConfigModel()
  {
    DotConfigModelImpl dotConfigModel = new DotConfigModelImpl();
    return dotConfigModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Config createConfig()
  {
    ConfigImpl config = new ConfigImpl();
    return config;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConfigString createConfigString()
  {
    ConfigStringImpl configString = new ConfigStringImpl();
    return configString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConfigLogic createConfigLogic()
  {
    ConfigLogicImpl configLogic = new ConfigLogicImpl();
    return configLogic;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DotconfigPackage getDotconfigPackage()
  {
    return (DotconfigPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static DotconfigPackage getPackage()
  {
    return DotconfigPackage.eINSTANCE;
  }

} //DotconfigFactoryImpl
