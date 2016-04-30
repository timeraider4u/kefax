/**
 */
package at.jku.weiner.kefax.dotconfig.dotconfig;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dot Config Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.kefax.dotconfig.dotconfig.DotConfigModel#getConfigs <em>Configs</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.kefax.dotconfig.dotconfig.DotconfigPackage#getDotConfigModel()
 * @model
 * @generated
 */
public interface DotConfigModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Configs</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.kefax.dotconfig.dotconfig.Config}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Configs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Configs</em>' containment reference list.
   * @see at.jku.weiner.kefax.dotconfig.dotconfig.DotconfigPackage#getDotConfigModel_Configs()
   * @model containment="true"
   * @generated
   */
  EList<Config> getConfigs();

} // DotConfigModel
