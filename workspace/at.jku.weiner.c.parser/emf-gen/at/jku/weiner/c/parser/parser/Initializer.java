/**
 */
package at.jku.weiner.c.parser.parser;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Initializer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.Initializer#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.Initializer#getList <em>List</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.Initializer#isLastComma <em>Last Comma</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getInitializer()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface Initializer extends PersistentEObject
{
	/**
	 * Returns the value of the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expr</em>' containment reference.
	 * @see #setExpr(Expression)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getInitializer_Expr()
	 * @model containment="true"
	 * @generated
	 */
	Expression getExpr();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.Initializer#getExpr <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr</em>' containment reference.
	 * @see #getExpr()
	 * @generated
	 */
	void setExpr(Expression value);

	/**
	 * Returns the value of the '<em><b>List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List</em>' containment reference.
	 * @see #setList(InitializerList)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getInitializer_List()
	 * @model containment="true"
	 * @generated
	 */
	InitializerList getList();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.Initializer#getList <em>List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>List</em>' containment reference.
	 * @see #getList()
	 * @generated
	 */
	void setList(InitializerList value);

	/**
	 * Returns the value of the '<em><b>Last Comma</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Comma</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Comma</em>' attribute.
	 * @see #setLastComma(boolean)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getInitializer_LastComma()
	 * @model
	 * @generated
	 */
	boolean isLastComma();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.Initializer#isLastComma <em>Last Comma</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Comma</em>' attribute.
	 * @see #isLastComma()
	 * @generated
	 */
	void setLastComma(boolean value);

} // Initializer
