/**
 */
package at.jku.isse.ecco.kefax.dotconfig.dotconfig;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see at.jku.isse.ecco.kefax.dotconfig.dotconfig.DotconfigPackage
 * @generated
 */
public interface DotconfigFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DotconfigFactory eINSTANCE = at.jku.isse.ecco.kefax.dotconfig.dotconfig.impl.DotconfigFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Dot Config Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Dot Config Model</em>'.
   * @generated
   */
  DotConfigModel createDotConfigModel();

  /**
   * Returns a new object of class '<em>Config</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Config</em>'.
   * @generated
   */
  Config createConfig();

  /**
   * Returns a new object of class '<em>Config String</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Config String</em>'.
   * @generated
   */
  ConfigString createConfigString();

  /**
   * Returns a new object of class '<em>Config Logic</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Config Logic</em>'.
   * @generated
   */
  ConfigLogic createConfigLogic();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  DotconfigPackage getDotconfigPackage();

} //DotconfigFactory
