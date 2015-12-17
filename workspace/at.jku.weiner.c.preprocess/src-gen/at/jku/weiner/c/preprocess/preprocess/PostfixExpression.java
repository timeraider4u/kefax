/**
 */
package at.jku.weiner.c.preprocess.preprocess;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Postfix Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.PostfixExpression#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.PostfixExpression#getSuffix <em>Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getPostfixExpression()
 * @model
 * @generated
 */
public interface PostfixExpression extends Expression
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
   * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getPostfixExpression_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.PostfixExpression#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expression value);

  /**
   * Returns the value of the '<em><b>Suffix</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.preprocess.preprocess.PostfixExpressionSuffix}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Suffix</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Suffix</em>' containment reference list.
   * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getPostfixExpression_Suffix()
   * @model containment="true"
   * @generated
   */
  EList<PostfixExpressionSuffix> getSuffix();

} // PostfixExpression
