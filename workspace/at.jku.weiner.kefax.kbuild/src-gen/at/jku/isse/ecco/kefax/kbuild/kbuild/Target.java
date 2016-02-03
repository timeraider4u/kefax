/**
 */
package at.jku.isse.ecco.kefax.kbuild.kbuild;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.isse.ecco.kefax.kbuild.kbuild.Target#getTarget <em>Target</em>}</li>
 *   <li>{@link at.jku.isse.ecco.kefax.kbuild.kbuild.Target#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.isse.ecco.kefax.kbuild.kbuild.KbuildPackage#getTarget()
 * @model
 * @generated
 */
public interface Target extends BuildEntry
{
  /**
   * Returns the value of the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' containment reference.
   * @see #setTarget(Values)
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.KbuildPackage#getTarget_Target()
   * @model containment="true"
   * @generated
   */
  Values getTarget();

  /**
   * Sets the value of the '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.Target#getTarget <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' containment reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(Values value);

  /**
   * Returns the value of the '<em><b>Values</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.isse.ecco.kefax.kbuild.kbuild.Values}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' containment reference list.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.KbuildPackage#getTarget_Values()
   * @model containment="true"
   * @generated
   */
  EList<Values> getValues();

} // Target
