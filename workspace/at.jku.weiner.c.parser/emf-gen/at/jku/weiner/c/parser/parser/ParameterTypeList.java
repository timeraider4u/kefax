/**
 */
package at.jku.weiner.c.parser.parser;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Type List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.ParameterTypeList#getList <em>List</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.ParameterTypeList#isEllipsis <em>Ellipsis</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getParameterTypeList()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface ParameterTypeList extends PersistentEObject
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
	 * @see #setList(ParameterList)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getParameterTypeList_List()
	 * @model containment="true"
	 * @generated
	 */
	ParameterList getList();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.ParameterTypeList#getList <em>List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>List</em>' containment reference.
	 * @see #getList()
	 * @generated
	 */
	void setList(ParameterList value);

	/**
	 * Returns the value of the '<em><b>Ellipsis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ellipsis</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ellipsis</em>' attribute.
	 * @see #setEllipsis(boolean)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getParameterTypeList_Ellipsis()
	 * @model
	 * @generated
	 */
	boolean isEllipsis();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.ParameterTypeList#isEllipsis <em>Ellipsis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ellipsis</em>' attribute.
	 * @see #isEllipsis()
	 * @generated
	 */
	void setEllipsis(boolean value);

} // ParameterTypeList
