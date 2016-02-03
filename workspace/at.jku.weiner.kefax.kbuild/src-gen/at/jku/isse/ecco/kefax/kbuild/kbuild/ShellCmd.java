/**
 */
package at.jku.isse.ecco.kefax.kbuild.kbuild;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shell Cmd</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.isse.ecco.kefax.kbuild.kbuild.ShellCmd#getName <em>Name</em>}</li>
 *   <li>{@link at.jku.isse.ecco.kefax.kbuild.kbuild.ShellCmd#getShellPart <em>Shell Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.isse.ecco.kefax.kbuild.kbuild.KbuildPackage#getShellCmd()
 * @model
 * @generated
 */
public interface ShellCmd extends EObject
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
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.KbuildPackage#getShellCmd_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.ShellCmd#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Shell Part</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.isse.ecco.kefax.kbuild.kbuild.ShellPart}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Shell Part</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Shell Part</em>' containment reference list.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.KbuildPackage#getShellCmd_ShellPart()
   * @model containment="true"
   * @generated
   */
  EList<ShellPart> getShellPart();

} // ShellCmd
