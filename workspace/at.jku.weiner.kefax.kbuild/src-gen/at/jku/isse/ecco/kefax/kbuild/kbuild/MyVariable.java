/**
 */
package at.jku.isse.ecco.kefax.kbuild.kbuild;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>My Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.isse.ecco.kefax.kbuild.kbuild.MyVariable#getName <em>Name</em>}</li>
 *   <li>{@link at.jku.isse.ecco.kefax.kbuild.kbuild.MyVariable#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.isse.ecco.kefax.kbuild.kbuild.KbuildPackage#getMyVariable()
 * @model
 * @generated
 */
public interface MyVariable extends BuildEntry
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
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.KbuildPackage#getMyVariable_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.MyVariable#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable</em>' containment reference.
   * @see #setVariable(Variable)
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.KbuildPackage#getMyVariable_Variable()
   * @model containment="true"
   * @generated
   */
  Variable getVariable();

  /**
   * Sets the value of the '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.MyVariable#getVariable <em>Variable</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' containment reference.
   * @see #getVariable()
   * @generated
   */
  void setVariable(Variable value);

} // MyVariable
