/**
 */
package at.jku.weiner.c.c;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.AssignmentExpression#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.AssignmentExpression#getOp <em>Op</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.AssignmentExpression#getAssignmentExpr <em>Assignment Expr</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.c.CPackage#getAssignmentExpression()
 * @model
 * @generated
 */
public interface AssignmentExpression extends Expression
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
   * @see at.jku.weiner.c.c.CPackage#getAssignmentExpression_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.AssignmentExpression#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expression value);

  /**
   * Returns the value of the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' containment reference.
   * @see #setOp(AssignmentOperator)
   * @see at.jku.weiner.c.c.CPackage#getAssignmentExpression_Op()
   * @model containment="true"
   * @generated
   */
  AssignmentOperator getOp();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.AssignmentExpression#getOp <em>Op</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' containment reference.
   * @see #getOp()
   * @generated
   */
  void setOp(AssignmentOperator value);

  /**
   * Returns the value of the '<em><b>Assignment Expr</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.c.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assignment Expr</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assignment Expr</em>' containment reference list.
   * @see at.jku.weiner.c.c.CPackage#getAssignmentExpression_AssignmentExpr()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getAssignmentExpr();

} // AssignmentExpression
