/**
 */
package at.jku.weiner.c.preprocess.preprocess;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Abstract Conditional</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.IfAbstractConditional#isBranchTaken <em>Branch Taken</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getIfAbstractConditional()
 * @model
 * @generated
 */
public interface IfAbstractConditional extends EObject
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

} // IfAbstractConditional
