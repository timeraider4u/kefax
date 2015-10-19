/**
 */
package at.jku.weiner.c.c;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicative Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.MultiplicativeExpression#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.MultiplicativeExpression#getOp <em>Op</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.c.CPackage#getMultiplicativeExpression()
 * @model
 * @generated
 */
public interface MultiplicativeExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.c.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expr</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference list.
   * @see at.jku.weiner.c.c.CPackage#getMultiplicativeExpression_Expr()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getExpr();

  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute list.
   * @see at.jku.weiner.c.c.CPackage#getMultiplicativeExpression_Op()
   * @model unique="false"
   * @generated
   */
  EList<String> getOp();

} // MultiplicativeExpression
