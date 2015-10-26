/**
 */
package at.jku.weiner.c.c;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.UnaryExpression#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.UnaryExpression#getPlusplus <em>Plusplus</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.UnaryExpression#getMinusminus <em>Minusminus</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.UnaryExpression#getOp <em>Op</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.UnaryExpression#getSizeOf <em>Size Of</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.UnaryExpression#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.UnaryExpression#getAndand <em>Andand</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.UnaryExpression#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.c.CPackage#getUnaryExpression()
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
   * @see at.jku.weiner.c.c.CPackage#getUnaryExpression_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.UnaryExpression#getExpr <em>Expr</em>}' containment reference.
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
   * @see at.jku.weiner.c.c.CPackage#getUnaryExpression_Plusplus()
   * @model
   * @generated
   */
  String getPlusplus();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.UnaryExpression#getPlusplus <em>Plusplus</em>}' attribute.
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
   * @see at.jku.weiner.c.c.CPackage#getUnaryExpression_Minusminus()
   * @model
   * @generated
   */
  String getMinusminus();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.UnaryExpression#getMinusminus <em>Minusminus</em>}' attribute.
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
   * @see at.jku.weiner.c.c.CPackage#getUnaryExpression_Op()
   * @model containment="true"
   * @generated
   */
  UnaryOperator getOp();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.UnaryExpression#getOp <em>Op</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' containment reference.
   * @see #getOp()
   * @generated
   */
  void setOp(UnaryOperator value);

  /**
   * Returns the value of the '<em><b>Size Of</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Size Of</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Size Of</em>' attribute.
   * @see #setSizeOf(String)
   * @see at.jku.weiner.c.c.CPackage#getUnaryExpression_SizeOf()
   * @model
   * @generated
   */
  String getSizeOf();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.UnaryExpression#getSizeOf <em>Size Of</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Size Of</em>' attribute.
   * @see #getSizeOf()
   * @generated
   */
  void setSizeOf(String value);

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
   * @see at.jku.weiner.c.c.CPackage#getUnaryExpression_TypeName()
   * @model containment="true"
   * @generated
   */
  TypeName getTypeName();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.UnaryExpression#getTypeName <em>Type Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Name</em>' containment reference.
   * @see #getTypeName()
   * @generated
   */
  void setTypeName(TypeName value);

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
   * @see at.jku.weiner.c.c.CPackage#getUnaryExpression_Andand()
   * @model
   * @generated
   */
  String getAndand();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.UnaryExpression#getAndand <em>Andand</em>}' attribute.
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
   * @see at.jku.weiner.c.c.CPackage#getUnaryExpression_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.UnaryExpression#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

} // UnaryExpression
