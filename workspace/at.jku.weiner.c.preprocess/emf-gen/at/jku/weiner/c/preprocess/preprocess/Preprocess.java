/**
 */
package at.jku.weiner.c.preprocess.preprocess;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Preprocess</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.Preprocess#getGroup <em>Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getPreprocess()
 * @model
 * @generated
 */
public interface Preprocess extends at.jku.weiner.c.common.common.Preprocess
{
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
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getPreprocess_Group()
	 * @model containment="true"
	 * @generated
	 */
	GroupOpt getGroup();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.Preprocess#getGroup <em>Group</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group</em>' containment reference.
	 * @see #getGroup()
	 * @generated
	 */
	void setGroup(GroupOpt value);

} // Preprocess
