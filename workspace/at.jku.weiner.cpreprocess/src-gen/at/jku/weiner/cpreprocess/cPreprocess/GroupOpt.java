/**
 */
package at.jku.weiner.cpreprocess.cPreprocess;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group Opt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.cpreprocess.cPreprocess.GroupOpt#getLines <em>Lines</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.cpreprocess.cPreprocess.CPreprocessPackage#getGroupOpt()
 * @model
 * @generated
 */
public interface GroupOpt extends EObject
{
  /**
   * Returns the value of the '<em><b>Lines</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.cpreprocess.cPreprocess.SourceCodeLine}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lines</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lines</em>' containment reference list.
   * @see at.jku.weiner.cpreprocess.cPreprocess.CPreprocessPackage#getGroupOpt_Lines()
   * @model containment="true"
   * @generated
   */
  EList<SourceCodeLine> getLines();

} // GroupOpt
