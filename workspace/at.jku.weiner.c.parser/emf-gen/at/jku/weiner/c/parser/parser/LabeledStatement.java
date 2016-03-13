/**
 */
package at.jku.weiner.c.parser.parser;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Labeled Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.LabeledStatement#getIdent <em>Ident</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.LabeledStatement#getLStmt <em>LStmt</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.LabeledStatement#getCase <em>Case</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.LabeledStatement#getLower <em>Lower</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.LabeledStatement#getHigher <em>Higher</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.LabeledStatement#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.LabeledStatement#isMydefault <em>Mydefault</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getLabeledStatement()
 * @model
 * @generated
 */
public interface LabeledStatement extends Statement
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
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getLabeledStatement_Ident()
	 * @model
	 * @generated
	 */
	String getIdent();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.LabeledStatement#getIdent <em>Ident</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ident</em>' attribute.
	 * @see #getIdent()
	 * @generated
	 */
	void setIdent(String value);

	/**
	 * Returns the value of the '<em><b>LStmt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>LStmt</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>LStmt</em>' containment reference.
	 * @see #setLStmt(Statement)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getLabeledStatement_LStmt()
	 * @model containment="true"
	 * @generated
	 */
	Statement getLStmt();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.LabeledStatement#getLStmt <em>LStmt</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>LStmt</em>' containment reference.
	 * @see #getLStmt()
	 * @generated
	 */
	void setLStmt(Statement value);

	/**
	 * Returns the value of the '<em><b>Case</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Case</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Case</em>' attribute.
	 * @see #setCase(String)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getLabeledStatement_Case()
	 * @model
	 * @generated
	 */
	String getCase();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.LabeledStatement#getCase <em>Case</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Case</em>' attribute.
	 * @see #getCase()
	 * @generated
	 */
	void setCase(String value);

	/**
	 * Returns the value of the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower</em>' attribute.
	 * @see #setLower(String)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getLabeledStatement_Lower()
	 * @model
	 * @generated
	 */
	String getLower();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.LabeledStatement#getLower <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower</em>' attribute.
	 * @see #getLower()
	 * @generated
	 */
	void setLower(String value);

	/**
	 * Returns the value of the '<em><b>Higher</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Higher</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Higher</em>' attribute.
	 * @see #setHigher(String)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getLabeledStatement_Higher()
	 * @model
	 * @generated
	 */
	String getHigher();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.LabeledStatement#getHigher <em>Higher</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Higher</em>' attribute.
	 * @see #getHigher()
	 * @generated
	 */
	void setHigher(String value);

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
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getLabeledStatement_Expr()
	 * @model containment="true"
	 * @generated
	 */
	Expression getExpr();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.LabeledStatement#getExpr <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr</em>' containment reference.
	 * @see #getExpr()
	 * @generated
	 */
	void setExpr(Expression value);

	/**
	 * Returns the value of the '<em><b>Mydefault</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mydefault</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mydefault</em>' attribute.
	 * @see #setMydefault(boolean)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getLabeledStatement_Mydefault()
	 * @model
	 * @generated
	 */
	boolean isMydefault();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.LabeledStatement#isMydefault <em>Mydefault</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mydefault</em>' attribute.
	 * @see #isMydefault()
	 * @generated
	 */
	void setMydefault(boolean value);

} // LabeledStatement
