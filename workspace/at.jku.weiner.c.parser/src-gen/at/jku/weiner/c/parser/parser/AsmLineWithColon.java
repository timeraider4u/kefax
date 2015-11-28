/**
 */
package at.jku.weiner.c.parser.parser;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Asm Line With Colon</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.AsmLineWithColon#isColon <em>Colon</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getAsmLineWithColon()
 * @model
 * @generated
 */
public interface AsmLineWithColon extends AsmLine
{
  /**
   * Returns the value of the '<em><b>Colon</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Colon</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Colon</em>' attribute.
   * @see #setColon(boolean)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getAsmLineWithColon_Colon()
   * @model
   * @generated
   */
  boolean isColon();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.AsmLineWithColon#isColon <em>Colon</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Colon</em>' attribute.
   * @see #isColon()
   * @generated
   */
  void setColon(boolean value);

} // AsmLineWithColon
