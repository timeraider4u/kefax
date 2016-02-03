/**
 */
package at.jku.isse.ecco.kefax.kbuild.kbuild;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Values</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.isse.ecco.kefax.kbuild.kbuild.Values#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.isse.ecco.kefax.kbuild.kbuild.KbuildPackage#getValues()
 * @model
 * @generated
 */
public interface Values extends Assign
{
  /**
   * Returns the value of the '<em><b>Values</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.isse.ecco.kefax.kbuild.kbuild.Value}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' containment reference list.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.KbuildPackage#getValues_Values()
   * @model containment="true"
   * @generated
   */
  EList<Value> getValues();

} // Values
