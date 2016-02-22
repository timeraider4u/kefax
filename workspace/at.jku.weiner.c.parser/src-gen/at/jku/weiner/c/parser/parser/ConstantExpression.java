/**
 */
package at.jku.weiner.c.parser.parser;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constant Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.ConstantExpression#getRestrict <em>Restrict</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.ConstantExpression#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getConstantExpression()
 * @model
 * @generated
 */
public interface ConstantExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Restrict</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Restrict</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Restrict</em>' attribute.
   * @see #setRestrict(String)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getConstantExpression_Restrict()
   * @model
   * @generated
   */
  String getRestrict();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.ConstantExpression#getRestrict <em>Restrict</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Restrict</em>' attribute.
   * @see #getRestrict()
   * @generated
   */
  void setRestrict(String value);

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
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getConstantExpression_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.ConstantExpression#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expression value);

} // ConstantExpression
