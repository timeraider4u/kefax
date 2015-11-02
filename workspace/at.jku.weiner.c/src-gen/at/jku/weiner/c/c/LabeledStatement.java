/**
 */
package at.jku.weiner.c.c;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Labeled Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.LabeledStatement#getId <em>Id</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.LabeledStatement#getLStmt <em>LStmt</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.LabeledStatement#getCase <em>Case</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.LabeledStatement#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.LabeledStatement#getDefault <em>Default</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.c.CPackage#getLabeledStatement()
 * @model
 * @generated
 */
public interface LabeledStatement extends Statement
{
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
   * @see at.jku.weiner.c.c.CPackage#getLabeledStatement_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.LabeledStatement#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

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
   * @see at.jku.weiner.c.c.CPackage#getLabeledStatement_LStmt()
   * @model containment="true"
   * @generated
   */
  Statement getLStmt();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.LabeledStatement#getLStmt <em>LStmt</em>}' containment reference.
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
   * @see at.jku.weiner.c.c.CPackage#getLabeledStatement_Case()
   * @model
   * @generated
   */
  String getCase();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.LabeledStatement#getCase <em>Case</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Case</em>' attribute.
   * @see #getCase()
   * @generated
   */
  void setCase(String value);

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
   * @see at.jku.weiner.c.c.CPackage#getLabeledStatement_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.LabeledStatement#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expression value);

  /**
   * Returns the value of the '<em><b>Default</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default</em>' attribute.
   * @see #setDefault(String)
   * @see at.jku.weiner.c.c.CPackage#getLabeledStatement_Default()
   * @model
   * @generated
   */
  String getDefault();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.LabeledStatement#getDefault <em>Default</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default</em>' attribute.
   * @see #getDefault()
   * @generated
   */
  void setDefault(String value);

} // LabeledStatement
