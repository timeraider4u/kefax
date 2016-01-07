/**
 */
package at.jku.weiner.c.preprocess.preprocess;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#isDefined <em>Defined</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#getId <em>Id</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#getConst <em>Const</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getPrimaryExpression()
 * @model
 * @generated
 */
public interface PrimaryExpression extends Expression
{
	/**
	 * Returns the value of the '<em><b>Defined</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defined</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defined</em>' attribute.
	 * @see #setDefined(boolean)
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getPrimaryExpression_Defined()
	 * @model
	 * @generated
	 */
	boolean isDefined();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#isDefined <em>Defined</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defined</em>' attribute.
	 * @see #isDefined()
	 * @generated
	 */
	void setDefined(boolean value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getPrimaryExpression_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

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
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getPrimaryExpression_Const()
	 * @model
	 * @generated
	 */
	String getConst();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#getConst <em>Const</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Const</em>' attribute.
	 * @see #getConst()
	 * @generated
	 */
	void setConst(String value);

	/**
	 * Returns the value of the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expr</em>' containment reference.
	 * @see #setExpr(at.jku.weiner.c.common.common.Expression)
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getPrimaryExpression_Expr()
	 * @model containment="true"
	 * @generated
	 */
	at.jku.weiner.c.common.common.Expression getExpr();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#getExpr <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr</em>' containment reference.
	 * @see #getExpr()
	 * @generated
	 */
	void setExpr(at.jku.weiner.c.common.common.Expression value);

} // PrimaryExpression
