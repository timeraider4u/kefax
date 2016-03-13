/**
 */
package at.jku.weiner.c.parser.parser;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Direct Declarator Last Suffix</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix#getParameterTypeList <em>Parameter Type List</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix#getIdentifierList <em>Identifier List</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getDirectDeclaratorLastSuffix()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface DirectDeclaratorLastSuffix extends PersistentEObject
{
	/**
	 * Returns the value of the '<em><b>Parameter Type List</b></em>' containment reference list.
	 * The list contents are of type {@link at.jku.weiner.c.parser.parser.ParameterTypeList}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Type List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Type List</em>' containment reference list.
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getDirectDeclaratorLastSuffix_ParameterTypeList()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterTypeList> getParameterTypeList();

	/**
	 * Returns the value of the '<em><b>Identifier List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier List</em>' containment reference.
	 * @see #setIdentifierList(IdentifierList)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getDirectDeclaratorLastSuffix_IdentifierList()
	 * @model containment="true"
	 * @generated
	 */
	IdentifierList getIdentifierList();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix#getIdentifierList <em>Identifier List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier List</em>' containment reference.
	 * @see #getIdentifierList()
	 * @generated
	 */
	void setIdentifierList(IdentifierList value);

} // DirectDeclaratorLastSuffix
