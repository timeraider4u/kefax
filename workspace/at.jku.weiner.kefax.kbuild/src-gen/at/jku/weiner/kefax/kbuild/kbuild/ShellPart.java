/**
 */
package at.jku.weiner.kefax.kbuild.kbuild;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shell Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.kefax.kbuild.kbuild.ShellPart#getVal <em>Val</em>}</li>
 *   <li>{@link at.jku.weiner.kefax.kbuild.kbuild.ShellPart#getCmd <em>Cmd</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.kefax.kbuild.kbuild.KbuildPackage#getShellPart()
 * @model
 * @generated
 */
public interface ShellPart extends EObject
{
  /**
   * Returns the value of the '<em><b>Val</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Val</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val</em>' containment reference.
   * @see #setVal(VarSlashSym)
   * @see at.jku.weiner.kefax.kbuild.kbuild.KbuildPackage#getShellPart_Val()
   * @model containment="true"
   * @generated
   */
  VarSlashSym getVal();

  /**
   * Sets the value of the '{@link at.jku.weiner.kefax.kbuild.kbuild.ShellPart#getVal <em>Val</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val</em>' containment reference.
   * @see #getVal()
   * @generated
   */
  void setVal(VarSlashSym value);

  /**
   * Returns the value of the '<em><b>Cmd</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cmd</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cmd</em>' containment reference.
   * @see #setCmd(ShellCmd)
   * @see at.jku.weiner.kefax.kbuild.kbuild.KbuildPackage#getShellPart_Cmd()
   * @model containment="true"
   * @generated
   */
  ShellCmd getCmd();

  /**
   * Sets the value of the '{@link at.jku.weiner.kefax.kbuild.kbuild.ShellPart#getCmd <em>Cmd</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cmd</em>' containment reference.
   * @see #getCmd()
   * @generated
   */
  void setCmd(ShellCmd value);

} // ShellPart
