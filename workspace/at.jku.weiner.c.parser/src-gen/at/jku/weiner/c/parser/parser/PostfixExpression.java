/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Postfix Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.PostfixExpression#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.PostfixExpression#getSuffix <em>Suffix</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPostfixExpression()
 * @model
 * @generated
 */
public interface PostfixExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.parser.parser.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expr</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference list.
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getPostfixExpression_Expr()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getExpr();

  /**
   * Returns the value of the '<em><b>Suffix</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.parser.parser.PostfixExpressionSuffix}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Suffix</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Suffix</em>' containment reference list.
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getPostfixExpression_Suffix()
   * @model containment="true"
   * @generated
   */
  EList<PostfixExpressionSuffix> getSuffix();

} // PostfixExpression
