/**
 */
package at.jku.weiner.c.parser.parser;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.FunctionSpecifier#getName <em>Name</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.FunctionSpecifier#getGccAttributeSpecifier <em>Gcc Attribute Specifier</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getFunctionSpecifier()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface FunctionSpecifier extends PersistentEObject
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getFunctionSpecifier_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.FunctionSpecifier#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Gcc Attribute Specifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gcc Attribute Specifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gcc Attribute Specifier</em>' containment reference.
	 * @see #setGccAttributeSpecifier(GccAttributeSpecifier)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getFunctionSpecifier_GccAttributeSpecifier()
	 * @model containment="true"
	 * @generated
	 */
	GccAttributeSpecifier getGccAttributeSpecifier();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.FunctionSpecifier#getGccAttributeSpecifier <em>Gcc Attribute Specifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gcc Attribute Specifier</em>' containment reference.
	 * @see #getGccAttributeSpecifier()
	 * @generated
	 */
	void setGccAttributeSpecifier(GccAttributeSpecifier value);

} // FunctionSpecifier
