/**
 */
package at.jku.weiner.c.parser.parser;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumerator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.Enumerator#getIdent <em>Ident</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.Enumerator#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getEnumerator()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface Enumerator extends PersistentEObject
{
	/**
	 * Returns the value of the '<em><b>Ident</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ident</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ident</em>' attribute.
	 * @see #setIdent(String)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getEnumerator_Ident()
	 * @model
	 * @generated
	 */
	String getIdent();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.Enumerator#getIdent <em>Ident</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ident</em>' attribute.
	 * @see #getIdent()
	 * @generated
	 */
	void setIdent(String value);

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
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getEnumerator_Expr()
	 * @model containment="true"
	 * @generated
	 */
	Expression getExpr();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.Enumerator#getExpr <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr</em>' containment reference.
	 * @see #getExpr()
	 * @generated
	 */
	void setExpr(Expression value);

} // Enumerator
