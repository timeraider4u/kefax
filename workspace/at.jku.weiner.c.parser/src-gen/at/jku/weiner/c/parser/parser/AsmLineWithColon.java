/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Asm Line With Colon</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.AsmLineWithColon#getAsmLine <em>Asm Line</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getAsmLineWithColon()
 * @model
 * @generated
 */
public interface AsmLineWithColon extends EObject
{
  /**
   * Returns the value of the '<em><b>Asm Line</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Asm Line</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Asm Line</em>' containment reference.
   * @see #setAsmLine(AsmLineWithoutColon)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getAsmLineWithColon_AsmLine()
   * @model containment="true"
   * @generated
   */
  AsmLineWithoutColon getAsmLine();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.AsmLineWithColon#getAsmLine <em>Asm Line</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Asm Line</em>' containment reference.
   * @see #getAsmLine()
   * @generated
   */
  void setAsmLine(AsmLineWithoutColon value);

} // AsmLineWithColon
