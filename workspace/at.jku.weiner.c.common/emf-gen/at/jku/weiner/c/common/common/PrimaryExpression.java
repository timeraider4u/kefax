/**
 */
package at.jku.weiner.c.common.common;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.common.common.PrimaryExpression#getConst <em>Const</em>}</li>
 *   <li>{@link at.jku.weiner.c.common.common.PrimaryExpression#getIdent <em>Ident</em>}</li>
 *   <li>{@link at.jku.weiner.c.common.common.PrimaryExpression#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.common.common.PrimaryExpression#isParentheses <em>Parentheses</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.common.common.CommonPackage#getPrimaryExpression()
 * @model
 * @generated
 */
public interface PrimaryExpression extends Expression
{
	/**
	 * Returns the value of the '<em><b>Const</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Const</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Const</em>' attribute.
	 * @see #setConst(String)
	 * @see at.jku.weiner.c.common.common.CommonPackage#getPrimaryExpression_Const()
	 * @model
	 * @generated
	 */
	String getConst();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.common.common.PrimaryExpression#getConst <em>Const</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Const</em>' attribute.
	 * @see #getConst()
	 * @generated
	 */
	void setConst(String value);

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
	 * @see at.jku.weiner.c.common.common.CommonPackage#getPrimaryExpression_Ident()
	 * @model
	 * @generated
	 */
	String getIdent();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.common.common.PrimaryExpression#getIdent <em>Ident</em>}' attribute.
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
	 * @see at.jku.weiner.c.common.common.CommonPackage#getPrimaryExpression_Expr()
	 * @model containment="true"
	 * @generated
	 */
	Expression getExpr();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.common.common.PrimaryExpression#getExpr <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr</em>' containment reference.
	 * @see #getExpr()
	 * @generated
	 */
	void setExpr(Expression value);

	/**
	 * Returns the value of the '<em><b>Parentheses</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parentheses</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parentheses</em>' attribute.
	 * @see #setParentheses(boolean)
	 * @see at.jku.weiner.c.common.common.CommonPackage#getPrimaryExpression_Parentheses()
	 * @model
	 * @generated
	 */
	boolean isParentheses();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.common.common.PrimaryExpression#isParentheses <em>Parentheses</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parentheses</em>' attribute.
	 * @see #isParentheses()
	 * @generated
	 */
	void setParentheses(boolean value);

} // PrimaryExpression
