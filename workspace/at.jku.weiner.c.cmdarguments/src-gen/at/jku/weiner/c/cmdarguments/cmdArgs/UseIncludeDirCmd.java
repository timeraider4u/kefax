/**
 */
package at.jku.weiner.c.cmdarguments.cmdArgs;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Use Include Dir Cmd</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.cmdarguments.cmdArgs.UseIncludeDirCmd#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getUseIncludeDirCmd()
 * @model
 * @generated
 */
public interface UseIncludeDirCmd extends EObject
{
  /**
   * Returns the value of the '<em><b>Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Path</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Path</em>' attribute.
   * @see #setPath(String)
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getUseIncludeDirCmd_Path()
   * @model
   * @generated
   */
  String getPath();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.UseIncludeDirCmd#getPath <em>Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Path</em>' attribute.
   * @see #getPath()
   * @generated
   */
  void setPath(String value);

} // UseIncludeDirCmd
