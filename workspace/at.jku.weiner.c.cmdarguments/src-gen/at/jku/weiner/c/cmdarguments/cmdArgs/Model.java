/**
 */
package at.jku.weiner.c.cmdarguments.cmdArgs;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.cmdarguments.cmdArgs.Model#getLines <em>Lines</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Lines</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lines</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lines</em>' containment reference list.
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getModel_Lines()
   * @model containment="true"
   * @generated
   */
  EList<CmdLine> getLines();

} // Model
