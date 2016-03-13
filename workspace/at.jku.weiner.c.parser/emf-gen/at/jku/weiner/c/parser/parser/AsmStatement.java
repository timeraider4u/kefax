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
 *   <li>{@link at.jku.weiner.c.parser.parser.AsmStatement#isLastComma <em>Last Comma</em>}</li>
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
	 * @see #setAsmLine1(AsmLine)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getAsmStatement_AsmLine1()
	 * @model containment="true"
	 * @generated
	 */
	AsmLine getAsmLine1();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.AsmStatement#getAsmLine1 <em>Asm Line1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Asm Line1</em>' containment reference.
	 * @see #getAsmLine1()
	 * @generated
	 */
	void setAsmLine1(AsmLine value);

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
	 * Returns the value of the '<em><b>Last Comma</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Comma</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Comma</em>' attribute.
	 * @see #setLastComma(boolean)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getAsmStatement_LastComma()
	 * @model
	 * @generated
	 */
	boolean isLastComma();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.AsmStatement#isLastComma <em>Last Comma</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Comma</em>' attribute.
	 * @see #isLastComma()
	 * @generated
	 */
	void setLastComma(boolean value);

} // AsmStatement
