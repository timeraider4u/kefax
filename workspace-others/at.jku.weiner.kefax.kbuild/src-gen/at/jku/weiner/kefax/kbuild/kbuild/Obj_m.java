/**
 */
package at.jku.weiner.kefax.kbuild.kbuild;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Obj m</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.kefax.kbuild.kbuild.Obj_m#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.kefax.kbuild.kbuild.KbuildPackage#getObj_m()
 * @model
 * @generated
 */
public interface Obj_m extends Object_M
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
   * @see #setValue(AssignExtra)
   * @see at.jku.weiner.kefax.kbuild.kbuild.KbuildPackage#getObj_m_Value()
   * @model containment="true"
   * @generated
   */
  AssignExtra getValue();

  /**
   * Sets the value of the '{@link at.jku.weiner.kefax.kbuild.kbuild.Obj_m#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(AssignExtra value);

} // Obj_m
