/**
 */
package at.jku.weiner.kefax.kbuild.kbuild;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Values</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.kefax.kbuild.kbuild.Values#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.kefax.kbuild.kbuild.KbuildPackage#getValues()
 * @model
 * @generated
 */
public interface Values extends Assign
{
  /**
   * Returns the value of the '<em><b>Items</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.kefax.kbuild.kbuild.Value}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Items</em>' containment reference list.
   * @see at.jku.weiner.kefax.kbuild.kbuild.KbuildPackage#getValues_Items()
   * @model containment="true"
   * @generated
   */
  EList<Value> getItems();

} // Values
