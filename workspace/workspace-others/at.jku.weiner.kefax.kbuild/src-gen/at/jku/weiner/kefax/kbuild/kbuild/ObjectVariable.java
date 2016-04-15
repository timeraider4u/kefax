/**
 */
package at.jku.weiner.kefax.kbuild.kbuild;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.kefax.kbuild.kbuild.ObjectVariable#getValue <em>Value</em>}</li>
 *   <li>{@link at.jku.weiner.kefax.kbuild.kbuild.ObjectVariable#getAdditional <em>Additional</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.kefax.kbuild.kbuild.KbuildPackage#getObjectVariable()
 * @model
 * @generated
 */
public interface ObjectVariable extends Value
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
   * @see #setValue(Variable)
   * @see at.jku.weiner.kefax.kbuild.kbuild.KbuildPackage#getObjectVariable_Value()
   * @model containment="true"
   * @generated
   */
  Variable getValue();

  /**
   * Sets the value of the '{@link at.jku.weiner.kefax.kbuild.kbuild.ObjectVariable#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Variable value);

  /**
   * Returns the value of the '<em><b>Additional</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Additional</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Additional</em>' attribute.
   * @see #setAdditional(String)
   * @see at.jku.weiner.kefax.kbuild.kbuild.KbuildPackage#getObjectVariable_Additional()
   * @model
   * @generated
   */
  String getAdditional();

  /**
   * Sets the value of the '{@link at.jku.weiner.kefax.kbuild.kbuild.ObjectVariable#getAdditional <em>Additional</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Additional</em>' attribute.
   * @see #getAdditional()
   * @generated
   */
  void setAdditional(String value);

} // ObjectVariable
