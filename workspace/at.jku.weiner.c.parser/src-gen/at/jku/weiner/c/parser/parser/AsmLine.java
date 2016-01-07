/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Asm Line</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.AsmLine#isComma <em>Comma</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.AsmLine#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getAsmLine()
 * @model
 * @generated
 */
public interface AsmLine extends EObject
{
  /**
   * Returns the value of the '<em><b>Comma</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Comma</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comma</em>' attribute.
   * @see #setComma(boolean)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getAsmLine_Comma()
   * @model
   * @generated
   */
  boolean isComma();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.AsmLine#isComma <em>Comma</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Comma</em>' attribute.
   * @see #isComma()
   * @generated
   */
  void setComma(boolean value);

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
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getAsmLine_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.AsmLine#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expression value);

} // AsmLine
