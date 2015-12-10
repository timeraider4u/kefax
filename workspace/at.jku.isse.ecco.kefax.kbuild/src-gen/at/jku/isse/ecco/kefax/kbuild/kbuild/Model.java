/**
 */
package at.jku.isse.ecco.kefax.kbuild.kbuild;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.isse.ecco.kefax.kbuild.kbuild.Model#getBuildEntry <em>Build Entry</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.isse.ecco.kefax.kbuild.kbuild.KbuildPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Build Entry</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.isse.ecco.kefax.kbuild.kbuild.BuildEntry}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Build Entry</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Build Entry</em>' containment reference list.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.KbuildPackage#getModel_BuildEntry()
   * @model containment="true"
   * @generated
   */
  EList<BuildEntry> getBuildEntry();

} // Model
