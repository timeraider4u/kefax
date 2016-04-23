/**
 */
package at.jku.weiner.kefax.dotconfig.dotconfig;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.kefax.dotconfig.dotconfig.Config#getName <em>Name</em>}</li>
 *   <li>{@link at.jku.weiner.kefax.dotconfig.dotconfig.Config#getV <em>V</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.kefax.dotconfig.dotconfig.DotconfigPackage#getConfig()
 * @model
 * @generated
 */
public interface Config extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see at.jku.weiner.kefax.dotconfig.dotconfig.DotconfigPackage#getConfig_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link at.jku.weiner.kefax.dotconfig.dotconfig.Config#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>V</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>V</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>V</em>' attribute.
   * @see #setV(String)
   * @see at.jku.weiner.kefax.dotconfig.dotconfig.DotconfigPackage#getConfig_V()
   * @model
   * @generated
   */
  String getV();

  /**
   * Sets the value of the '{@link at.jku.weiner.kefax.dotconfig.dotconfig.Config#getV <em>V</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>V</em>' attribute.
   * @see #getV()
   * @generated
   */
  void setV(String value);

} // Config
