/**
 */
package at.jku.weiner.c.cmdarguments.cmdArgs;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cmd Line</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine#getStart <em>Start</em>}</li>
 *   <li>{@link at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getCmdLine()
 * @model
 * @generated
 */
public interface CmdLine extends EObject
{
  /**
   * Returns the value of the '<em><b>Start</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Start</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Start</em>' attribute.
   * @see #setStart(String)
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getCmdLine_Start()
   * @model
   * @generated
   */
  String getStart();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine#getStart <em>Start</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Start</em>' attribute.
   * @see #getStart()
   * @generated
   */
  void setStart(String value);

  /**
   * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arguments</em>' containment reference list.
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getCmdLine_Arguments()
   * @model containment="true"
   * @generated
   */
  EList<Argument> getArguments();

} // CmdLine
