/**
 */
package at.jku.weiner.c.cmdarguments.cmdArgs;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Macro</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.cmdarguments.cmdArgs.StringMacro#getMacro <em>Macro</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getStringMacro()
 * @model
 * @generated
 */
public interface StringMacro extends Macro
{
  /**
   * Returns the value of the '<em><b>Macro</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Macro</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Macro</em>' containment reference.
   * @see #setMacro(Macro)
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getStringMacro_Macro()
   * @model containment="true"
   * @generated
   */
  Macro getMacro();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.StringMacro#getMacro <em>Macro</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Macro</em>' containment reference.
   * @see #getMacro()
   * @generated
   */
  void setMacro(Macro value);

} // StringMacro
