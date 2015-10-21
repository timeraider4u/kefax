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
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.IterationStatement#getWhile <em>While</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.IterationStatement#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.IterationStatement#getStatement <em>Statement</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.IterationStatement#getDo <em>Do</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.IterationStatement#getSemi <em>Semi</em>}</li>
 * </ul>
 * </p>
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

} // IterationStatement
