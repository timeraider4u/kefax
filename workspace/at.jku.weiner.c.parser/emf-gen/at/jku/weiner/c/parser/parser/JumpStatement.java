/**
 */
package at.jku.weiner.c.parser.parser;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jump Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.JumpStatement#getContinue <em>Continue</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.JumpStatement#getBreak <em>Break</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.JumpStatement#getReturn <em>Return</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.JumpStatement#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.JumpStatement#getGoto <em>Goto</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getJumpStatement()
 * @model
 * @generated
 */
public interface JumpStatement extends Statement
{
	/**
	 * Returns the value of the '<em><b>Continue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Continue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Continue</em>' attribute.
	 * @see #setContinue(String)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getJumpStatement_Continue()
	 * @model
	 * @generated
	 */
	String getContinue();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.JumpStatement#getContinue <em>Continue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Continue</em>' attribute.
	 * @see #getContinue()
	 * @generated
	 */
	void setContinue(String value);

	/**
	 * Returns the value of the '<em><b>Break</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Break</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Break</em>' attribute.
	 * @see #setBreak(String)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getJumpStatement_Break()
	 * @model
	 * @generated
	 */
	String getBreak();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.JumpStatement#getBreak <em>Break</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Break</em>' attribute.
	 * @see #getBreak()
	 * @generated
	 */
	void setBreak(String value);

	/**
	 * Returns the value of the '<em><b>Return</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return</em>' attribute.
	 * @see #setReturn(String)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getJumpStatement_Return()
	 * @model
	 * @generated
	 */
	String getReturn();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.JumpStatement#getReturn <em>Return</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return</em>' attribute.
	 * @see #getReturn()
	 * @generated
	 */
	void setReturn(String value);

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
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getJumpStatement_Expr()
	 * @model containment="true"
	 * @generated
	 */
	Expression getExpr();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.JumpStatement#getExpr <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr</em>' containment reference.
	 * @see #getExpr()
	 * @generated
	 */
	void setExpr(Expression value);

	/**
	 * Returns the value of the '<em><b>Goto</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goto</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goto</em>' attribute.
	 * @see #setGoto(String)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getJumpStatement_Goto()
	 * @model
	 * @generated
	 */
	String getGoto();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.JumpStatement#getGoto <em>Goto</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Goto</em>' attribute.
	 * @see #getGoto()
	 * @generated
	 */
	void setGoto(String value);

} // JumpStatement
