/**
 */
package at.jku.weiner.c.c;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Asm Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.AsmStatement#getAsm <em>Asm</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.AsmStatement#getVolatile <em>Volatile</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.AsmStatement#getAsmLine <em>Asm Line</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.AsmStatement#getSemi <em>Semi</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.c.CPackage#getAsmStatement()
 * @model
 * @generated
 */
public interface AsmStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Asm</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Asm</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Asm</em>' attribute.
   * @see #setAsm(String)
   * @see at.jku.weiner.c.c.CPackage#getAsmStatement_Asm()
   * @model
   * @generated
   */
  String getAsm();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.AsmStatement#getAsm <em>Asm</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Asm</em>' attribute.
   * @see #getAsm()
   * @generated
   */
  void setAsm(String value);

  /**
   * Returns the value of the '<em><b>Volatile</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Volatile</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Volatile</em>' attribute.
   * @see #setVolatile(String)
   * @see at.jku.weiner.c.c.CPackage#getAsmStatement_Volatile()
   * @model
   * @generated
   */
  String getVolatile();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.AsmStatement#getVolatile <em>Volatile</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Volatile</em>' attribute.
   * @see #getVolatile()
   * @generated
   */
  void setVolatile(String value);

  /**
   * Returns the value of the '<em><b>Asm Line</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.c.AsmLine}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Asm Line</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Asm Line</em>' containment reference list.
   * @see at.jku.weiner.c.c.CPackage#getAsmStatement_AsmLine()
   * @model containment="true"
   * @generated
   */
  EList<AsmLine> getAsmLine();

  /**
   * Returns the value of the '<em><b>Semi</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Semi</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Semi</em>' attribute.
   * @see #setSemi(String)
   * @see at.jku.weiner.c.c.CPackage#getAsmStatement_Semi()
   * @model
   * @generated
   */
  String getSemi();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.AsmStatement#getSemi <em>Semi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Semi</em>' attribute.
   * @see #getSemi()
   * @generated
   */
  void setSemi(String value);

} // AsmStatement
