/**
 */
package at.jku.weiner.c.preprocess.preprocess;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Replace Line</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.ReplaceLine#getString <em>String</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.ReplaceLine#getId <em>Id</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.ReplaceLine#isConcatenate <em>Concatenate</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getReplaceLine()
 * @model
 * @generated
 */
public interface ReplaceLine extends EObject
{
	/**
	 * Returns the value of the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String</em>' attribute.
	 * @see #setString(String)
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getReplaceLine_String()
	 * @model
	 * @generated
	 */
	String getString();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.ReplaceLine#getString <em>String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String</em>' attribute.
	 * @see #getString()
	 * @generated
	 */
	void setString(String value);

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
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getReplaceLine_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.ReplaceLine#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Concatenate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concatenate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concatenate</em>' attribute.
	 * @see #setConcatenate(boolean)
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getReplaceLine_Concatenate()
	 * @model
	 * @generated
	 */
	boolean isConcatenate();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.ReplaceLine#isConcatenate <em>Concatenate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concatenate</em>' attribute.
	 * @see #isConcatenate()
	 * @generated
	 */
	void setConcatenate(boolean value);

} // ReplaceLine
