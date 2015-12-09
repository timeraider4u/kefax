/**
 */
package at.jku.weiner.c.parser.parser;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Postfix Expression Suffix Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument#getArgumentExpressionList <em>Argument Expression List</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPostfixExpressionSuffixArgument()
 * @model
 * @generated
 */
public interface PostfixExpressionSuffixArgument extends PostfixExpressionSuffix
{
  /**
   * Returns the value of the '<em><b>Argument Expression List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Argument Expression List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Argument Expression List</em>' containment reference.
   * @see #setArgumentExpressionList(ArgumentExpressionList)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getPostfixExpressionSuffixArgument_ArgumentExpressionList()
   * @model containment="true"
   * @generated
   */
  ArgumentExpressionList getArgumentExpressionList();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument#getArgumentExpressionList <em>Argument Expression List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Argument Expression List</em>' containment reference.
   * @see #getArgumentExpressionList()
   * @generated
   */
  void setArgumentExpressionList(ArgumentExpressionList value);

} // PostfixExpressionSuffixArgument
