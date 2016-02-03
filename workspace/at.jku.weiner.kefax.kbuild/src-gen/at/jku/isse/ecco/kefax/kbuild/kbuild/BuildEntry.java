/**
 */
package at.jku.isse.ecco.kefax.kbuild.kbuild;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Build Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.isse.ecco.kefax.kbuild.kbuild.BuildEntry#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.isse.ecco.kefax.kbuild.kbuild.KbuildPackage#getBuildEntry()
 * @model
 * @generated
 */
public interface BuildEntry extends EObject
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(EObject)
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.KbuildPackage#getBuildEntry_Value()
   * @model containment="true"
   * @generated
   */
  EObject getValue();

  /**
   * Sets the value of the '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.BuildEntry#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(EObject value);

} // BuildEntry
