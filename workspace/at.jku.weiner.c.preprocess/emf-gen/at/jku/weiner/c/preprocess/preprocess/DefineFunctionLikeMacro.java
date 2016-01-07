/**
 */
package at.jku.weiner.c.preprocess.preprocess;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Define Function Like Macro</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro#getList <em>List</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro#getReplacement <em>Replacement</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getDefineFunctionLikeMacro()
 * @model
 * @generated
 */
public interface DefineFunctionLikeMacro extends DefineDirective
{
	/**
	 * Returns the value of the '<em><b>List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List</em>' containment reference.
	 * @see #setList(IdentifierList)
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getDefineFunctionLikeMacro_List()
	 * @model containment="true"
	 * @generated
	 */
	IdentifierList getList();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro#getList <em>List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>List</em>' containment reference.
	 * @see #getList()
	 * @generated
	 */
	void setList(IdentifierList value);

	/**
	 * Returns the value of the '<em><b>Replacement</b></em>' containment reference list.
	 * The list contents are of type {@link at.jku.weiner.c.preprocess.preprocess.ReplaceLine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Replacement</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Replacement</em>' containment reference list.
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getDefineFunctionLikeMacro_Replacement()
	 * @model containment="true"
	 * @generated
	 */
	EList<ReplaceLine> getReplacement();

} // DefineFunctionLikeMacro
