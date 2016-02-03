/**
 */
package at.jku.isse.ecco.kefax.kbuild.kbuild;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.isse.ecco.kefax.kbuild.kbuild.If#getShell <em>Shell</em>}</li>
 *   <li>{@link at.jku.isse.ecco.kefax.kbuild.kbuild.If#getValue <em>Value</em>}</li>
 *   <li>{@link at.jku.isse.ecco.kefax.kbuild.kbuild.If#getElsevalue <em>Elsevalue</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.isse.ecco.kefax.kbuild.kbuild.KbuildPackage#getIf()
 * @model
 * @generated
 */
public interface If extends EObject
{
  /**
   * Returns the value of the '<em><b>Shell</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Shell</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Shell</em>' containment reference.
   * @see #setShell(ShellCmd)
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.KbuildPackage#getIf_Shell()
   * @model containment="true"
   * @generated
   */
  ShellCmd getShell();

  /**
   * Sets the value of the '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.If#getShell <em>Shell</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Shell</em>' containment reference.
   * @see #getShell()
   * @generated
   */
  void setShell(ShellCmd value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(EObject)
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.KbuildPackage#getIf_Value()
   * @model containment="true"
   * @generated
   */
  EObject getValue();

  /**
   * Sets the value of the '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.If#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(EObject value);

  /**
   * Returns the value of the '<em><b>Elsevalue</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elsevalue</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elsevalue</em>' containment reference.
   * @see #setElsevalue(EObject)
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.KbuildPackage#getIf_Elsevalue()
   * @model containment="true"
   * @generated
   */
  EObject getElsevalue();

  /**
   * Sets the value of the '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.If#getElsevalue <em>Elsevalue</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Elsevalue</em>' containment reference.
   * @see #getElsevalue()
   * @generated
   */
  void setElsevalue(EObject value);

} // If
