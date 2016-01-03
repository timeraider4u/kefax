/**
 */
package at.jku.weiner.c.cmdarguments.cmdArgs;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getMacro <em>Macro</em>}</li>
 *   <li>{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getInclude <em>Include</em>}</li>
 *   <li>{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#isNostdinc <em>Nostdinc</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getArgument()
 * @model
 * @generated
 */
public interface Argument extends EObject
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
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getArgument_Macro()
   * @model containment="true"
   * @generated
   */
  Macro getMacro();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getMacro <em>Macro</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Macro</em>' containment reference.
   * @see #getMacro()
   * @generated
   */
  void setMacro(Macro value);

  /**
   * Returns the value of the '<em><b>Include</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Include</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Include</em>' containment reference.
   * @see #setInclude(IncludeCmd)
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getArgument_Include()
   * @model containment="true"
   * @generated
   */
  IncludeCmd getInclude();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getInclude <em>Include</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Include</em>' containment reference.
   * @see #getInclude()
   * @generated
   */
  void setInclude(IncludeCmd value);

  /**
   * Returns the value of the '<em><b>Nostdinc</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nostdinc</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nostdinc</em>' attribute.
   * @see #setNostdinc(boolean)
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getArgument_Nostdinc()
   * @model
   * @generated
   */
  boolean isNostdinc();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#isNostdinc <em>Nostdinc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Nostdinc</em>' attribute.
   * @see #isNostdinc()
   * @generated
   */
  void setNostdinc(boolean value);

} // Argument
