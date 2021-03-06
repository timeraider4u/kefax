/**
 */
package at.jku.weiner.c.parser.parser;

import at.jku.weiner.c.common.common.Constant2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.PrimaryExpression#getIdent <em>Ident</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.PrimaryExpression#getConst <em>Const</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.PrimaryExpression#getString <em>String</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.PrimaryExpression#isParentheses <em>Parentheses</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.PrimaryExpression#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.PrimaryExpression#isExt <em>Ext</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.PrimaryExpression#getCompoundStmt <em>Compound Stmt</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.PrimaryExpression#isBuiltin_offsetof <em>Builtin offsetof</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.PrimaryExpression#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.PrimaryExpression#isBuiltin_typescompatiblep <em>Builtin typescompatiblep</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.PrimaryExpression#getTypeName2 <em>Type Name2</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPrimaryExpression()
 * @model
 * @generated
 */
public interface PrimaryExpression extends Expression
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
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPrimaryExpression_Ident()
	 * @model
	 * @generated
	 */
	String getIdent();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.PrimaryExpression#getIdent <em>Ident</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ident</em>' attribute.
	 * @see #getIdent()
	 * @generated
	 */
	void setIdent(String value);

	/**
	 * Returns the value of the '<em><b>Const</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Const</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Const</em>' containment reference.
	 * @see #setConst(Constant2)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPrimaryExpression_Const()
	 * @model containment="true"
	 * @generated
	 */
	Constant2 getConst();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.PrimaryExpression#getConst <em>Const</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Const</em>' containment reference.
	 * @see #getConst()
	 * @generated
	 */
	void setConst(Constant2 value);

	/**
	 * Returns the value of the '<em><b>String</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String</em>' attribute list.
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPrimaryExpression_String()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getString();

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
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPrimaryExpression_Parentheses()
	 * @model
	 * @generated
	 */
	boolean isParentheses();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.PrimaryExpression#isParentheses <em>Parentheses</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parentheses</em>' attribute.
	 * @see #isParentheses()
	 * @generated
	 */
	void setParentheses(boolean value);

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
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPrimaryExpression_Expr()
	 * @model containment="true"
	 * @generated
	 */
	Expression getExpr();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.PrimaryExpression#getExpr <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr</em>' containment reference.
	 * @see #getExpr()
	 * @generated
	 */
	void setExpr(Expression value);

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
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPrimaryExpression_Ext()
	 * @model
	 * @generated
	 */
	boolean isExt();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.PrimaryExpression#isExt <em>Ext</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ext</em>' attribute.
	 * @see #isExt()
	 * @generated
	 */
	void setExt(boolean value);

	/**
	 * Returns the value of the '<em><b>Compound Stmt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compound Stmt</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compound Stmt</em>' containment reference.
	 * @see #setCompoundStmt(Statement)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPrimaryExpression_CompoundStmt()
	 * @model containment="true"
	 * @generated
	 */
	Statement getCompoundStmt();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.PrimaryExpression#getCompoundStmt <em>Compound Stmt</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compound Stmt</em>' containment reference.
	 * @see #getCompoundStmt()
	 * @generated
	 */
	void setCompoundStmt(Statement value);

	/**
	 * Returns the value of the '<em><b>Builtin offsetof</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Builtin offsetof</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Builtin offsetof</em>' attribute.
	 * @see #setBuiltin_offsetof(boolean)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPrimaryExpression_Builtin_offsetof()
	 * @model
	 * @generated
	 */
	boolean isBuiltin_offsetof();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.PrimaryExpression#isBuiltin_offsetof <em>Builtin offsetof</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Builtin offsetof</em>' attribute.
	 * @see #isBuiltin_offsetof()
	 * @generated
	 */
	void setBuiltin_offsetof(boolean value);

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
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPrimaryExpression_TypeName()
	 * @model containment="true"
	 * @generated
	 */
	TypeName getTypeName();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.PrimaryExpression#getTypeName <em>Type Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Name</em>' containment reference.
	 * @see #getTypeName()
	 * @generated
	 */
	void setTypeName(TypeName value);

	/**
	 * Returns the value of the '<em><b>Builtin typescompatiblep</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Builtin typescompatiblep</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Builtin typescompatiblep</em>' attribute.
	 * @see #setBuiltin_typescompatiblep(boolean)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPrimaryExpression_Builtin_typescompatiblep()
	 * @model
	 * @generated
	 */
	boolean isBuiltin_typescompatiblep();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.PrimaryExpression#isBuiltin_typescompatiblep <em>Builtin typescompatiblep</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Builtin typescompatiblep</em>' attribute.
	 * @see #isBuiltin_typescompatiblep()
	 * @generated
	 */
	void setBuiltin_typescompatiblep(boolean value);

	/**
	 * Returns the value of the '<em><b>Type Name2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Name2</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Name2</em>' containment reference.
	 * @see #setTypeName2(TypeName)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPrimaryExpression_TypeName2()
	 * @model containment="true"
	 * @generated
	 */
	TypeName getTypeName2();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.PrimaryExpression#getTypeName2 <em>Type Name2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Name2</em>' containment reference.
	 * @see #getTypeName2()
	 * @generated
	 */
	void setTypeName2(TypeName value);

} // PrimaryExpression
