/**
 */
package at.jku.weiner.c.preprocess.preprocess;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Define Function Like Macro</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro#getList <em>List</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro#getString <em>String</em>}</li>
 * </ul>
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
	 * Returns the value of the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String</em>' attribute.
	 * @see #setString(String)
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getDefineFunctionLikeMacro_String()
	 * @model
	 * @generated
	 */
	String getString();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro#getString <em>String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String</em>' attribute.
	 * @see #getString()
	 * @generated
	 */
	void setString(String value);

} // DefineFunctionLikeMacro
