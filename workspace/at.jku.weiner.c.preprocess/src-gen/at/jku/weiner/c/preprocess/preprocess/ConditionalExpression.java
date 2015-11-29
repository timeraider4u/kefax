/**
 */
package at.jku.weiner.c.preprocess.preprocess;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.ConditionalExpression#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.ConditionalExpression#getQExpr <em>QExpr</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.ConditionalExpression#getCExpr <em>CExpr</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getConditionalExpression()
 * @model
 * @generated
 */
public interface ConditionalExpression extends EObject
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
   * @see #setExpr(LogicalOrExpression)
   * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getConditionalExpression_Expr()
   * @model containment="true"
   * @generated
   */
  LogicalOrExpression getExpr();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.ConditionalExpression#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(LogicalOrExpression value);

  /**
   * Returns the value of the '<em><b>QExpr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>QExpr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>QExpr</em>' containment reference.
   * @see #setQExpr(Expression)
   * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getConditionalExpression_QExpr()
   * @model containment="true"
   * @generated
   */
  Expression getQExpr();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.ConditionalExpression#getQExpr <em>QExpr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>QExpr</em>' containment reference.
   * @see #getQExpr()
   * @generated
   */
  void setQExpr(Expression value);

  /**
   * Returns the value of the '<em><b>CExpr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>CExpr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>CExpr</em>' containment reference.
   * @see #setCExpr(ConditionalExpression)
   * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getConditionalExpression_CExpr()
   * @model containment="true"
   * @generated
   */
  ConditionalExpression getCExpr();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.ConditionalExpression#getCExpr <em>CExpr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>CExpr</em>' containment reference.
   * @see #getCExpr()
   * @generated
   */
  void setCExpr(ConditionalExpression value);

} // ConditionalExpression
