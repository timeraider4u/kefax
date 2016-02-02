/**
 */
package at.jku.weiner.c.parser.parser;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.UnaryExpression#getPlusplus <em>Plusplus</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.UnaryExpression#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.UnaryExpression#getMinusminus <em>Minusminus</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.UnaryExpression#getOp <em>Op</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.UnaryExpression#getSizeOf <em>Size Of</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.UnaryExpression#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.UnaryExpression#getAlignOf <em>Align Of</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.UnaryExpression#getAndand <em>Andand</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.UnaryExpression#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getUnaryExpression()
 * @model
 * @generated
 */
public interface UnaryExpression extends Expression
{
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
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getUnaryExpression_Plusplus()
   * @model
   * @generated
   */
  String getPlusplus();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.UnaryExpression#getPlusplus <em>Plusplus</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Plusplus</em>' attribute.
   * @see #getPlusplus()
   * @generated
   */
  void setPlusplus(String value);

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
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getUnaryExpression_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.UnaryExpression#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expression value);

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
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getUnaryExpression_Minusminus()
   * @model
   * @generated
   */
  String getMinusminus();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.UnaryExpression#getMinusminus <em>Minusminus</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Minusminus</em>' attribute.
   * @see #getMinusminus()
   * @generated
   */
  void setMinusminus(String value);

  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see #setOp(String)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getUnaryExpression_Op()
   * @model
   * @generated
   */
  String getOp();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.UnaryExpression#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see #getOp()
   * @generated
   */
  void setOp(String value);

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
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getUnaryExpression_SizeOf()
   * @model
   * @generated
   */
  String getSizeOf();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.UnaryExpression#getSizeOf <em>Size Of</em>}' attribute.
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
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getUnaryExpression_TypeName()
   * @model containment="true"
   * @generated
   */
  TypeName getTypeName();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.UnaryExpression#getTypeName <em>Type Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Name</em>' containment reference.
   * @see #getTypeName()
   * @generated
   */
  void setTypeName(TypeName value);

  /**
   * Returns the value of the '<em><b>Align Of</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Align Of</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Align Of</em>' attribute.
   * @see #setAlignOf(String)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getUnaryExpression_AlignOf()
   * @model
   * @generated
   */
  String getAlignOf();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.UnaryExpression#getAlignOf <em>Align Of</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Align Of</em>' attribute.
   * @see #getAlignOf()
   * @generated
   */
  void setAlignOf(String value);

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
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getUnaryExpression_Andand()
   * @model
   * @generated
   */
  String getAndand();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.UnaryExpression#getAndand <em>Andand</em>}' attribute.
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
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getUnaryExpression_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.UnaryExpression#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

} // UnaryExpression
