/**
 */
package at.jku.isse.ecco.kefax.dotconfig.dotconfig;

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
 * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.DotconfigFactory
 * @model kind="package"
 * @generated
 */
public interface DotconfigPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "dotconfig";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.jku.at/isse/ecco/kefax/dotconfig/Dotconfig";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "dotconfig";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DotconfigPackage eINSTANCE = at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.DotconfigPackageImpl.init();

  /**
   * The meta object id for the '{@link at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.DotConfigModelImpl <em>Dot Config Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.DotConfigModelImpl
   * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.DotconfigPackageImpl#getDotConfigModel()
   * @generated
   */
  int DOT_CONFIG_MODEL = 0;

  /**
   * The feature id for the '<em><b>Configs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOT_CONFIG_MODEL__CONFIGS = 0;

  /**
   * The number of structural features of the '<em>Dot Config Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOT_CONFIG_MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.ConfigImpl <em>Config</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.ConfigImpl
   * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.DotconfigPackageImpl#getConfig()
   * @generated
   */
  int CONFIG = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIG__NAME = 0;

  /**
   * The feature id for the '<em><b>V</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIG__V = 1;

  /**
   * The number of structural features of the '<em>Config</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIG_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.ConfigStringImpl <em>Config String</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.ConfigStringImpl
   * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.DotconfigPackageImpl#getConfigString()
   * @generated
   */
  int CONFIG_STRING = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIG_STRING__NAME = CONFIG__NAME;

  /**
   * The feature id for the '<em><b>V</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIG_STRING__V = CONFIG__V;

  /**
   * The number of structural features of the '<em>Config String</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIG_STRING_FEATURE_COUNT = CONFIG_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.ConfigLogicImpl <em>Config Logic</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.ConfigLogicImpl
   * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.DotconfigPackageImpl#getConfigLogic()
   * @generated
   */
  int CONFIG_LOGIC = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIG_LOGIC__NAME = CONFIG__NAME;

  /**
   * The feature id for the '<em><b>V</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIG_LOGIC__V = CONFIG__V;

  /**
   * The number of structural features of the '<em>Config Logic</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIG_LOGIC_FEATURE_COUNT = CONFIG_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link at.jku.isse.ecco.kefax.dotconfig.dotconfig.DotConfigModel <em>Dot Config Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dot Config Model</em>'.
   * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.DotConfigModel
   * @generated
   */
  EClass getDotConfigModel();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.isse.ecco.kefax.dotconfig.dotconfig.DotConfigModel#getConfigs <em>Configs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Configs</em>'.
   * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.DotConfigModel#getConfigs()
   * @see #getDotConfigModel()
   * @generated
   */
  EReference getDotConfigModel_Configs();

  /**
   * Returns the meta object for class '{@link at.jku.isse.ecco.kefax.dotconfig.dotconfig.Config <em>Config</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Config</em>'.
   * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.Config
   * @generated
   */
  EClass getConfig();

  /**
   * Returns the meta object for the attribute '{@link at.jku.isse.ecco.kefax.dotconfig.dotconfig.Config#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.Config#getName()
   * @see #getConfig()
   * @generated
   */
  EAttribute getConfig_Name();

  /**
   * Returns the meta object for the attribute '{@link at.jku.isse.ecco.kefax.dotconfig.dotconfig.Config#getV <em>V</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>V</em>'.
   * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.Config#getV()
   * @see #getConfig()
   * @generated
   */
  EAttribute getConfig_V();

  /**
   * Returns the meta object for class '{@link at.jku.isse.ecco.kefax.dotconfig.dotconfig.ConfigString <em>Config String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Config String</em>'.
   * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.ConfigString
   * @generated
   */
  EClass getConfigString();

  /**
   * Returns the meta object for class '{@link at.jku.isse.ecco.kefax.dotconfig.dotconfig.ConfigLogic <em>Config Logic</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Config Logic</em>'.
   * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.ConfigLogic
   * @generated
   */
  EClass getConfigLogic();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  DotconfigFactory getDotconfigFactory();

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
     * The meta object literal for the '{@link at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.DotConfigModelImpl <em>Dot Config Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.DotConfigModelImpl
     * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.DotconfigPackageImpl#getDotConfigModel()
     * @generated
     */
    EClass DOT_CONFIG_MODEL = eINSTANCE.getDotConfigModel();

    /**
     * The meta object literal for the '<em><b>Configs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOT_CONFIG_MODEL__CONFIGS = eINSTANCE.getDotConfigModel_Configs();

    /**
     * The meta object literal for the '{@link at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.ConfigImpl <em>Config</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.ConfigImpl
     * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.DotconfigPackageImpl#getConfig()
     * @generated
     */
    EClass CONFIG = eINSTANCE.getConfig();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONFIG__NAME = eINSTANCE.getConfig_Name();

    /**
     * The meta object literal for the '<em><b>V</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONFIG__V = eINSTANCE.getConfig_V();

    /**
     * The meta object literal for the '{@link at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.ConfigStringImpl <em>Config String</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.ConfigStringImpl
     * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.DotconfigPackageImpl#getConfigString()
     * @generated
     */
    EClass CONFIG_STRING = eINSTANCE.getConfigString();

    /**
     * The meta object literal for the '{@link at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.ConfigLogicImpl <em>Config Logic</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.ConfigLogicImpl
     * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.DotconfigPackageImpl#getConfigLogic()
     * @generated
     */
    EClass CONFIG_LOGIC = eINSTANCE.getConfigLogic();

  }

} //DotconfigPackage
