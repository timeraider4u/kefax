/**
 */
package at.jku.weiner.c.preprocess.preprocess;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Abstract Conditional</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.IfAbstractConditional#isBranchTaken <em>Branch Taken</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.IfAbstractConditional#getGroup <em>Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getIfAbstractConditional()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface IfAbstractConditional extends PersistentEObject
{
	/**
	 * Returns the value of the '<em><b>Branch Taken</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branch Taken</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branch Taken</em>' attribute.
	 * @see #setBranchTaken(boolean)
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getIfAbstractConditional_BranchTaken()
	 * @model
	 * @generated
	 */
	boolean isBranchTaken();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.IfAbstractConditional#isBranchTaken <em>Branch Taken</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Branch Taken</em>' attribute.
	 * @see #isBranchTaken()
	 * @generated
	 */
	void setBranchTaken(boolean value);

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
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getIfAbstractConditional_Group()
	 * @model containment="true"
	 * @generated
	 */
	GroupOpt getGroup();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.IfAbstractConditional#getGroup <em>Group</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group</em>' containment reference.
	 * @see #getGroup()
	 * @generated
	 */
	void setGroup(GroupOpt value);

} // IfAbstractConditional
