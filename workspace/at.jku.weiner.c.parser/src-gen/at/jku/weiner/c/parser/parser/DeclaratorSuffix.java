/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Declarator Suffix</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.DeclaratorSuffix#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.DeclaratorSuffix#getLastSuffix <em>Last Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getDeclaratorSuffix()
 * @model
 * @generated
 */
public interface DeclaratorSuffix extends EObject
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
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getDeclaratorSuffix_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.DeclaratorSuffix#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expression value);

  /**
   * Returns the value of the '<em><b>Last Suffix</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Last Suffix</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Last Suffix</em>' containment reference.
   * @see #setLastSuffix(DirectDeclaratorLastSuffix)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getDeclaratorSuffix_LastSuffix()
   * @model containment="true"
   * @generated
   */
  DirectDeclaratorLastSuffix getLastSuffix();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.DeclaratorSuffix#getLastSuffix <em>Last Suffix</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Last Suffix</em>' containment reference.
   * @see #getLastSuffix()
   * @generated
   */
  void setLastSuffix(DirectDeclaratorLastSuffix value);

} // DeclaratorSuffix
