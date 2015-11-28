/**
 */
package at.jku.weiner.c.preprocess.preprocess;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.UnaryExpression#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.UnaryExpression#getPlusplus <em>Plusplus</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.UnaryExpression#getMinusminus <em>Minusminus</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.UnaryExpression#getOp <em>Op</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.UnaryExpression#getAndand <em>Andand</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.UnaryExpression#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getUnaryExpression()
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
   * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getUnaryExpression_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.UnaryExpression#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expression value);

  /**
   * Returns the value of the '<em><b>Plusplus</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Plusplus</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Plusplus</em>' attribute.
   * @see #setPlusplus(String)
   * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getUnaryExpression_Plusplus()
   * @model
   * @generated
   */
  String getPlusplus();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.UnaryExpression#getPlusplus <em>Plusplus</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Plusplus</em>' attribute.
   * @see #getPlusplus()
   * @generated
   */
  void setPlusplus(String value);

  /**
   * Returns the value of the '<em><b>Minusminus</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Minusminus</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Minusminus</em>' attribute.
   * @see #setMinusminus(String)
   * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getUnaryExpression_Minusminus()
   * @model
   * @generated
   */
  String getMinusminus();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.UnaryExpression#getMinusminus <em>Minusminus</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Minusminus</em>' attribute.
   * @see #getMinusminus()
   * @generated
   */
  void setMinusminus(String value);

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
   * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getUnaryExpression_Op()
   * @model containment="true"
   * @generated
   */
  UnaryOperator getOp();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.UnaryExpression#getOp <em>Op</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' containment reference.
   * @see #getOp()
   * @generated
   */
  void setOp(UnaryOperator value);

  /**
   * Returns the value of the '<em><b>Andand</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Andand</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Andand</em>' attribute.
   * @see #setAndand(String)
   * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getUnaryExpression_Andand()
   * @model
   * @generated
   */
  String getAndand();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.UnaryExpression#getAndand <em>Andand</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Andand</em>' attribute.
   * @see #getAndand()
   * @generated
   */
  void setAndand(String value);

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
   * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getUnaryExpression_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.UnaryExpression#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

} // UnaryExpression
