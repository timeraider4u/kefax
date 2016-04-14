/**
 */
package at.jku.weiner.c.parser.parser;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Postfix Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.PostfixExpression#isExt <em>Ext</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.PostfixExpression#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.PostfixExpression#getInitializerList <em>Initializer List</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.PostfixExpression#isComma <em>Comma</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.PostfixExpression#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.PostfixExpression#getSuffix <em>Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPostfixExpression()
 * @model
 * @generated
 */
public interface PostfixExpression extends Expression
{
	/**
	 * Returns the value of the '<em><b>Ext</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ext</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ext</em>' attribute.
	 * @see #setExt(boolean)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPostfixExpression_Ext()
	 * @model
	 * @generated
	 */
	boolean isExt();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.PostfixExpression#isExt <em>Ext</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ext</em>' attribute.
	 * @see #isExt()
	 * @generated
	 */
	void setExt(boolean value);

	/**
	 * Returns the value of the '<em><b>Type Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Name</em>' containment reference.
	 * @see #setTypeName(TypeName)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPostfixExpression_TypeName()
	 * @model containment="true"
	 * @generated
	 */
	TypeName getTypeName();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.PostfixExpression#getTypeName <em>Type Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Name</em>' containment reference.
	 * @see #getTypeName()
	 * @generated
	 */
	void setTypeName(TypeName value);

	/**
	 * Returns the value of the '<em><b>Initializer List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initializer List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initializer List</em>' containment reference.
	 * @see #setInitializerList(InitializerList)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPostfixExpression_InitializerList()
	 * @model containment="true"
	 * @generated
	 */
	InitializerList getInitializerList();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.PostfixExpression#getInitializerList <em>Initializer List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initializer List</em>' containment reference.
	 * @see #getInitializerList()
	 * @generated
	 */
	void setInitializerList(InitializerList value);

	/**
	 * Returns the value of the '<em><b>Comma</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comma</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comma</em>' attribute.
	 * @see #setComma(boolean)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPostfixExpression_Comma()
	 * @model
	 * @generated
	 */
	boolean isComma();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.PostfixExpression#isComma <em>Comma</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comma</em>' attribute.
	 * @see #isComma()
	 * @generated
	 */
	void setComma(boolean value);

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
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPostfixExpression_Expr()
	 * @model containment="true"
	 * @generated
	 */
	Expression getExpr();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.PostfixExpression#getExpr <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr</em>' containment reference.
	 * @see #getExpr()
	 * @generated
	 */
	void setExpr(Expression value);

	/**
	 * Returns the value of the '<em><b>Suffix</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suffix</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suffix</em>' containment reference.
	 * @see #setSuffix(PostfixExpressionSuffix)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPostfixExpression_Suffix()
	 * @model containment="true"
	 * @generated
	 */
	PostfixExpressionSuffix getSuffix();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.PostfixExpression#getSuffix <em>Suffix</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suffix</em>' containment reference.
	 * @see #getSuffix()
	 * @generated
	 */
	void setSuffix(PostfixExpressionSuffix value);

} // PostfixExpression
