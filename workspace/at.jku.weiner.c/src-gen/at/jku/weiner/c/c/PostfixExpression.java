/**
 */
package at.jku.weiner.c.c;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Postfix Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.PostfixExpression#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.PostfixExpression#getArrayExpr <em>Array Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.PostfixExpression#getArgumentExpressionList <em>Argument Expression List</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.PostfixExpression#getDot <em>Dot</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.PostfixExpression#getId <em>Id</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.PostfixExpression#getArrow <em>Arrow</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.PostfixExpression#getPlusplus <em>Plusplus</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.PostfixExpression#getMinusminus <em>Minusminus</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.c.CPackage#getPostfixExpression()
 * @model
 * @generated
 */
public interface PostfixExpression extends Expression
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
   * @see at.jku.weiner.c.c.CPackage#getPostfixExpression_Expr()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getExpr();

  /**
   * Returns the value of the '<em><b>Array Expr</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.c.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Array Expr</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Array Expr</em>' containment reference list.
   * @see at.jku.weiner.c.c.CPackage#getPostfixExpression_ArrayExpr()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getArrayExpr();

  /**
   * Returns the value of the '<em><b>Argument Expression List</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.c.ArgumentExpressionList}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Argument Expression List</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Argument Expression List</em>' containment reference list.
   * @see at.jku.weiner.c.c.CPackage#getPostfixExpression_ArgumentExpressionList()
   * @model containment="true"
   * @generated
   */
  EList<ArgumentExpressionList> getArgumentExpressionList();

  /**
   * Returns the value of the '<em><b>Dot</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dot</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dot</em>' attribute list.
   * @see at.jku.weiner.c.c.CPackage#getPostfixExpression_Dot()
   * @model unique="false"
   * @generated
   */
  EList<String> getDot();

  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute list.
   * @see at.jku.weiner.c.c.CPackage#getPostfixExpression_Id()
   * @model unique="false"
   * @generated
   */
  EList<String> getId();

  /**
   * Returns the value of the '<em><b>Arrow</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arrow</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arrow</em>' attribute list.
   * @see at.jku.weiner.c.c.CPackage#getPostfixExpression_Arrow()
   * @model unique="false"
   * @generated
   */
  EList<String> getArrow();

  /**
   * Returns the value of the '<em><b>Plusplus</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Plusplus</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Plusplus</em>' attribute list.
   * @see at.jku.weiner.c.c.CPackage#getPostfixExpression_Plusplus()
   * @model unique="false"
   * @generated
   */
  EList<String> getPlusplus();

  /**
   * Returns the value of the '<em><b>Minusminus</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Minusminus</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Minusminus</em>' attribute list.
   * @see at.jku.weiner.c.c.CPackage#getPostfixExpression_Minusminus()
   * @model unique="false"
   * @generated
   */
  EList<String> getMinusminus();

} // PostfixExpression
