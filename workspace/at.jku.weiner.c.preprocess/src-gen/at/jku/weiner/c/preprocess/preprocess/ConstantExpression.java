/**
 */
package at.jku.weiner.c.preprocess.preprocess;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constant Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.ConstantExpression#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getConstantExpression()
 * @model
 * @generated
 */
public interface ConstantExpression extends ShadowExpression
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
   * @see #setExpr(ConditionalExpression)
   * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getConstantExpression_Expr()
   * @model containment="true"
   * @generated
   */
  ConditionalExpression getExpr();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.ConstantExpression#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(ConditionalExpression value);

} // ConstantExpression
