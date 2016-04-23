/**
 */
package at.jku.weiner.c.parser.parser;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Struct Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.StructDeclaration#getList <em>List</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.StructDeclaration#getStructDeclarationList <em>Struct Declaration List</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getStructDeclaration()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface StructDeclaration extends PersistentEObject
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
	 * @see #setList(SpecifierQualifierList)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getStructDeclaration_List()
	 * @model containment="true"
	 * @generated
	 */
	SpecifierQualifierList getList();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.StructDeclaration#getList <em>List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>List</em>' containment reference.
	 * @see #getList()
	 * @generated
	 */
	void setList(SpecifierQualifierList value);

	/**
	 * Returns the value of the '<em><b>Struct Declaration List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Struct Declaration List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Struct Declaration List</em>' containment reference.
	 * @see #setStructDeclarationList(StructDeclaratorList)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getStructDeclaration_StructDeclarationList()
	 * @model containment="true"
	 * @generated
	 */
	StructDeclaratorList getStructDeclarationList();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.StructDeclaration#getStructDeclarationList <em>Struct Declaration List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Struct Declaration List</em>' containment reference.
	 * @see #getStructDeclarationList()
	 * @generated
	 */
	void setStructDeclarationList(StructDeclaratorList value);

} // StructDeclaration
