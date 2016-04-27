/**
 */
package at.jku.weiner.c.cmdarguments.cmdArgs;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Macro</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.cmdarguments.cmdArgs.ObjectMacro#getName <em>Name</em>}</li>
 *   <li>{@link at.jku.weiner.c.cmdarguments.cmdArgs.ObjectMacro#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getObjectMacro()
 * @model
 * @generated
 */
public interface ObjectMacro extends Macro
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
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getObjectMacro_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.ObjectMacro#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getObjectMacro_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.ObjectMacro#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

} // ObjectMacro
