/**
 */
package at.jku.weiner.c.parser.parser;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.Statement#getStmt <em>Stmt</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getStatement()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface Statement extends PersistentEObject
{
	/**
	 * Returns the value of the '<em><b>Stmt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stmt</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stmt</em>' containment reference.
	 * @see #setStmt(Statement)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getStatement_Stmt()
	 * @model containment="true"
	 * @generated
	 */
	Statement getStmt();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.Statement#getStmt <em>Stmt</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stmt</em>' containment reference.
	 * @see #getStmt()
	 * @generated
	 */
	void setStmt(Statement value);

} // Statement
