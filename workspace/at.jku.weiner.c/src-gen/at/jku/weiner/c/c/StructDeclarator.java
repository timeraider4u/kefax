/**
 */
package at.jku.weiner.c.c;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Struct Declarator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.StructDeclarator#getDeclarator <em>Declarator</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.StructDeclarator#getConstExpr <em>Const Expr</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.c.CPackage#getStructDeclarator()
 * @model
 * @generated
 */
public interface StructDeclarator extends EObject
{
  /**
   * Returns the value of the '<em><b>Declarator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Declarator</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Declarator</em>' containment reference.
   * @see #setDeclarator(Declarator)
   * @see at.jku.weiner.c.c.CPackage#getStructDeclarator_Declarator()
   * @model containment="true"
   * @generated
   */
  Declarator getDeclarator();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.StructDeclarator#getDeclarator <em>Declarator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Declarator</em>' containment reference.
   * @see #getDeclarator()
   * @generated
   */
  void setDeclarator(Declarator value);

  /**
   * Returns the value of the '<em><b>Const Expr</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.c.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Const Expr</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Const Expr</em>' containment reference list.
   * @see at.jku.weiner.c.c.CPackage#getStructDeclarator_ConstExpr()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getConstExpr();

} // StructDeclarator
