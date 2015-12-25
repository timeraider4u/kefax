/**
 */
package at.jku.weiner.c.common.common;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.common.common.UnaryExpression#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.common.common.UnaryExpression#getOp <em>Op</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.common.common.CommonPackage#getUnaryExpression()
 * @model
 * @generated
 */
public interface UnaryExpression extends Expression
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
	 * @see at.jku.weiner.c.common.common.CommonPackage#getUnaryExpression_Expr()
	 * @model containment="true"
	 * @generated
	 */
	Expression getExpr();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.common.common.UnaryExpression#getExpr <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr</em>' containment reference.
	 * @see #getExpr()
	 * @generated
	 */
	void setExpr(Expression value);

	/**
	 * Returns the value of the '<em><b>Op</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Op</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Op</em>' containment reference.
	 * @see #setOp(UnaryOperator)
	 * @see at.jku.weiner.c.common.common.CommonPackage#getUnaryExpression_Op()
	 * @model containment="true"
	 * @generated
	 */
	UnaryOperator getOp();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.common.common.UnaryExpression#getOp <em>Op</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Op</em>' containment reference.
	 * @see #getOp()
	 * @generated
	 */
	void setOp(UnaryOperator value);

} // UnaryExpression
