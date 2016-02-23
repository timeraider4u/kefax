/**
 */
package at.jku.weiner.c.parser.parser;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.ConditionalExpression#getQExpr <em>QExpr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.ConditionalExpression#getCExpr <em>CExpr</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getConditionalExpression()
 * @model
 * @generated
 */
public interface ConditionalExpression extends Expression
{
	/**
	 * Returns the value of the '<em><b>QExpr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>QExpr</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>QExpr</em>' containment reference.
	 * @see #setQExpr(Expression)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getConditionalExpression_QExpr()
	 * @model containment="true"
	 * @generated
	 */
	Expression getQExpr();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.ConditionalExpression#getQExpr <em>QExpr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>QExpr</em>' containment reference.
	 * @see #getQExpr()
	 * @generated
	 */
	void setQExpr(Expression value);

	/**
	 * Returns the value of the '<em><b>CExpr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CExpr</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CExpr</em>' containment reference.
	 * @see #setCExpr(Expression)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getConditionalExpression_CExpr()
	 * @model containment="true"
	 * @generated
	 */
	Expression getCExpr();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.ConditionalExpression#getCExpr <em>CExpr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CExpr</em>' containment reference.
	 * @see #getCExpr()
	 * @generated
	 */
	void setCExpr(Expression value);

} // ConditionalExpression
