/**
 */
package at.jku.weiner.c.preprocess.preprocess;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pragma Directive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.PragmaDirective#getPragma <em>Pragma</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getPragmaDirective()
 * @model
 * @generated
 */
public interface PragmaDirective extends EObject
{
	/**
	 * Returns the value of the '<em><b>Pragma</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pragma</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pragma</em>' attribute.
	 * @see #setPragma(String)
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getPragmaDirective_Pragma()
	 * @model
	 * @generated
	 */
	String getPragma();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.PragmaDirective#getPragma <em>Pragma</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pragma</em>' attribute.
	 * @see #getPragma()
	 * @generated
	 */
	void setPragma(String value);

} // PragmaDirective
