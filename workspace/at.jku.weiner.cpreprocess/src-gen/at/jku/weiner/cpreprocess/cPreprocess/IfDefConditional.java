/**
 */
package at.jku.weiner.cpreprocess.cPreprocess;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Def Conditional</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.cpreprocess.cPreprocess.IfDefConditional#getId <em>Id</em>}</li>
 *   <li>{@link at.jku.weiner.cpreprocess.cPreprocess.IfDefConditional#getGroup <em>Group</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.cpreprocess.cPreprocess.CPreprocessPackage#getIfDefConditional()
 * @model
 * @generated
 */
public interface IfDefConditional extends EObject
{
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see at.jku.weiner.cpreprocess.cPreprocess.CPreprocessPackage#getIfDefConditional_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link at.jku.weiner.cpreprocess.cPreprocess.IfDefConditional#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Group</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group</em>' containment reference.
   * @see #setGroup(GroupOpt)
   * @see at.jku.weiner.cpreprocess.cPreprocess.CPreprocessPackage#getIfDefConditional_Group()
   * @model containment="true"
   * @generated
   */
  GroupOpt getGroup();

  /**
   * Sets the value of the '{@link at.jku.weiner.cpreprocess.cPreprocess.IfDefConditional#getGroup <em>Group</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Group</em>' containment reference.
   * @see #getGroup()
   * @generated
   */
  void setGroup(GroupOpt value);

} // IfDefConditional
