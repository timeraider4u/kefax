/**
 */
package at.jku.weiner.c.preprocess.preprocess;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exclusive Or Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.ExclusiveOrExpression#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getExclusiveOrExpression()
 * @model
 * @generated
 */
public interface ExclusiveOrExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.preprocess.preprocess.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expr</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference list.
   * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getExclusiveOrExpression_Expr()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getExpr();

} // ExclusiveOrExpression