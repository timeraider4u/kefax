/**
 */
package at.jku.weiner.c.parser.parser;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Postfix Expression Suffix Array</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArray#getArrayExpr <em>Array Expr</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPostfixExpressionSuffixArray()
 * @model
 * @generated
 */
public interface PostfixExpressionSuffixArray extends PostfixExpressionSuffix
{
  /**
   * Returns the value of the '<em><b>Array Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Array Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Array Expr</em>' containment reference.
   * @see #setArrayExpr(Expression)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getPostfixExpressionSuffixArray_ArrayExpr()
   * @model containment="true"
   * @generated
   */
  Expression getArrayExpr();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArray#getArrayExpr <em>Array Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Array Expr</em>' containment reference.
   * @see #getArrayExpr()
   * @generated
   */
  void setArrayExpr(Expression value);

} // PostfixExpressionSuffixArray
