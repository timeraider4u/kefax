/**
 */
package at.jku.weiner.c.parser.parser;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.TypeName#getList <em>List</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.TypeName#getAbstractDeclarator <em>Abstract Declarator</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getTypeName()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface TypeName extends PersistentEObject
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
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getTypeName_List()
	 * @model containment="true"
	 * @generated
	 */
	SpecifierQualifierList getList();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.TypeName#getList <em>List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>List</em>' containment reference.
	 * @see #getList()
	 * @generated
	 */
	void setList(SpecifierQualifierList value);

	/**
	 * Returns the value of the '<em><b>Abstract Declarator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract Declarator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract Declarator</em>' containment reference.
	 * @see #setAbstractDeclarator(AbstractDeclarator)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getTypeName_AbstractDeclarator()
	 * @model containment="true"
	 * @generated
	 */
	AbstractDeclarator getAbstractDeclarator();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.TypeName#getAbstractDeclarator <em>Abstract Declarator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract Declarator</em>' containment reference.
	 * @see #getAbstractDeclarator()
	 * @generated
	 */
	void setAbstractDeclarator(AbstractDeclarator value);

} // TypeName
