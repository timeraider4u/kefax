/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Asm Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.AsmStatement#getAsm <em>Asm</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.AsmStatement#getVolatile <em>Volatile</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.AsmStatement#getAsmLine1 <em>Asm Line1</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.AsmStatement#getAsmLines <em>Asm Lines</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.AsmStatement#getSemi <em>Semi</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getAsmStatement()
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
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getAsmStatement_Asm()
   * @model
   * @generated
   */
  String getAsm();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.AsmStatement#getAsm <em>Asm</em>}' attribute.
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
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getAsmStatement_Volatile()
   * @model
   * @generated
   */
  String getVolatile();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.AsmStatement#getVolatile <em>Volatile</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Volatile</em>' attribute.
   * @see #getVolatile()
   * @generated
   */
  void setVolatile(String value);

  /**
   * Returns the value of the '<em><b>Asm Line1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Asm Line1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Asm Line1</em>' containment reference.
   * @see #setAsmLine1(AsmLineWithoutColon)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getAsmStatement_AsmLine1()
   * @model containment="true"
   * @generated
   */
  AsmLineWithoutColon getAsmLine1();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.AsmStatement#getAsmLine1 <em>Asm Line1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Asm Line1</em>' containment reference.
   * @see #getAsmLine1()
   * @generated
   */
  void setAsmLine1(AsmLineWithoutColon value);

  /**
   * Returns the value of the '<em><b>Asm Lines</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.parser.parser.AsmLineWithColon}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Asm Lines</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Asm Lines</em>' containment reference list.
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getAsmStatement_AsmLines()
   * @model containment="true"
   * @generated
   */
  EList<AsmLineWithColon> getAsmLines();

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
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getAsmStatement_Semi()
   * @model
   * @generated
   */
  String getSemi();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.AsmStatement#getSemi <em>Semi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Semi</em>' attribute.
   * @see #getSemi()
   * @generated
   */
  void setSemi(String value);

} // AsmStatement
