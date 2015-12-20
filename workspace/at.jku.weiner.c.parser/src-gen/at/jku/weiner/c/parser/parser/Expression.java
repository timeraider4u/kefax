/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.Expression#getExprExpr <em>Expr Expr</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getExpression()
 * @model
 * @generated
 */
public interface Expression extends at.jku.weiner.c.common.common.Expression
{
  /**
   * Returns the value of the '<em><b>Expr Expr</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.parser.parser.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expr Expr</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr Expr</em>' containment reference list.
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getExpression_ExprExpr()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getExprExpr();

} // Expression
