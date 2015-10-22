/**
 */
package at.jku.weiner.c.c;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iteration Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.IterationStatement#getWhile <em>While</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.IterationStatement#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.IterationStatement#getStatement <em>Statement</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.IterationStatement#getDo <em>Do</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.IterationStatement#getSemi <em>Semi</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.IterationStatement#getFor <em>For</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.IterationStatement#getInitExpr <em>Init Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.IterationStatement#getIncExpr <em>Inc Expr</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.c.CPackage#getIterationStatement()
 * @model
 * @generated
 */
public interface IterationStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>While</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>While</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>While</em>' attribute.
   * @see #setWhile(String)
   * @see at.jku.weiner.c.c.CPackage#getIterationStatement_While()
   * @model
   * @generated
   */
  String getWhile();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.IterationStatement#getWhile <em>While</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>While</em>' attribute.
   * @see #getWhile()
   * @generated
   */
  void setWhile(String value);

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
   * @see at.jku.weiner.c.c.CPackage#getIterationStatement_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.IterationStatement#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expression value);

  /**
   * Returns the value of the '<em><b>Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statement</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statement</em>' containment reference.
   * @see #setStatement(Statement)
   * @see at.jku.weiner.c.c.CPackage#getIterationStatement_Statement()
   * @model containment="true"
   * @generated
   */
  Statement getStatement();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.IterationStatement#getStatement <em>Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Statement</em>' containment reference.
   * @see #getStatement()
   * @generated
   */
  void setStatement(Statement value);

  /**
   * Returns the value of the '<em><b>Do</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Do</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Do</em>' attribute.
   * @see #setDo(String)
   * @see at.jku.weiner.c.c.CPackage#getIterationStatement_Do()
   * @model
   * @generated
   */
  String getDo();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.IterationStatement#getDo <em>Do</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Do</em>' attribute.
   * @see #getDo()
   * @generated
   */
  void setDo(String value);

  /**
   * Returns the value of the '<em><b>Semi</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Semi</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Semi</em>' attribute.
   * @see #setSemi(String)
   * @see at.jku.weiner.c.c.CPackage#getIterationStatement_Semi()
   * @model
   * @generated
   */
  String getSemi();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.IterationStatement#getSemi <em>Semi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Semi</em>' attribute.
   * @see #getSemi()
   * @generated
   */
  void setSemi(String value);

  /**
   * Returns the value of the '<em><b>For</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>For</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>For</em>' attribute.
   * @see #setFor(String)
   * @see at.jku.weiner.c.c.CPackage#getIterationStatement_For()
   * @model
   * @generated
   */
  String getFor();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.IterationStatement#getFor <em>For</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>For</em>' attribute.
   * @see #getFor()
   * @generated
   */
  void setFor(String value);

  /**
   * Returns the value of the '<em><b>Init Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Init Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Init Expr</em>' containment reference.
   * @see #setInitExpr(Expression)
   * @see at.jku.weiner.c.c.CPackage#getIterationStatement_InitExpr()
   * @model containment="true"
   * @generated
   */
  Expression getInitExpr();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.IterationStatement#getInitExpr <em>Init Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Init Expr</em>' containment reference.
   * @see #getInitExpr()
   * @generated
   */
  void setInitExpr(Expression value);

  /**
   * Returns the value of the '<em><b>Inc Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inc Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inc Expr</em>' containment reference.
   * @see #setIncExpr(Expression)
   * @see at.jku.weiner.c.c.CPackage#getIterationStatement_IncExpr()
   * @model containment="true"
   * @generated
   */
  Expression getIncExpr();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.IterationStatement#getIncExpr <em>Inc Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Inc Expr</em>' containment reference.
   * @see #getIncExpr()
   * @generated
   */
  void setIncExpr(Expression value);

} // IterationStatement
