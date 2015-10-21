/**
 */
package at.jku.weiner.c.c;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selection Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.SelectionStatement#getIf <em>If</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.SelectionStatement#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.SelectionStatement#getIfStatement <em>If Statement</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.SelectionStatement#getElse <em>Else</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.SelectionStatement#getElseStatement <em>Else Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.c.CPackage#getSelectionStatement()
 * @model
 * @generated
 */
public interface SelectionStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>If</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>If</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>If</em>' attribute.
   * @see #setIf(String)
   * @see at.jku.weiner.c.c.CPackage#getSelectionStatement_If()
   * @model
   * @generated
   */
  String getIf();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.SelectionStatement#getIf <em>If</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>If</em>' attribute.
   * @see #getIf()
   * @generated
   */
  void setIf(String value);

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
   * @see at.jku.weiner.c.c.CPackage#getSelectionStatement_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.SelectionStatement#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expression value);

  /**
   * Returns the value of the '<em><b>If Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>If Statement</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>If Statement</em>' containment reference.
   * @see #setIfStatement(Statement)
   * @see at.jku.weiner.c.c.CPackage#getSelectionStatement_IfStatement()
   * @model containment="true"
   * @generated
   */
  Statement getIfStatement();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.SelectionStatement#getIfStatement <em>If Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>If Statement</em>' containment reference.
   * @see #getIfStatement()
   * @generated
   */
  void setIfStatement(Statement value);

  /**
   * Returns the value of the '<em><b>Else</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else</em>' attribute.
   * @see #setElse(String)
   * @see at.jku.weiner.c.c.CPackage#getSelectionStatement_Else()
   * @model
   * @generated
   */
  String getElse();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.SelectionStatement#getElse <em>Else</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else</em>' attribute.
   * @see #getElse()
   * @generated
   */
  void setElse(String value);

  /**
   * Returns the value of the '<em><b>Else Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else Statement</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else Statement</em>' containment reference.
   * @see #setElseStatement(Statement)
   * @see at.jku.weiner.c.c.CPackage#getSelectionStatement_ElseStatement()
   * @model containment="true"
   * @generated
   */
  Statement getElseStatement();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.SelectionStatement#getElseStatement <em>Else Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else Statement</em>' containment reference.
   * @see #getElseStatement()
   * @generated
   */
  void setElseStatement(Statement value);

} // SelectionStatement
