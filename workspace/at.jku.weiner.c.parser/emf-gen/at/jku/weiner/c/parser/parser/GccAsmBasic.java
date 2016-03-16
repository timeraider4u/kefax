/**
 */
package at.jku.weiner.c.parser.parser;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gcc Asm Basic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.GccAsmBasic#getAsm <em>Asm</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.GccAsmBasic#getString <em>String</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getGccAsmBasic()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface GccAsmBasic extends PersistentEObject
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
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getGccAsmBasic_Asm()
	 * @model
	 * @generated
	 */
	String getAsm();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.GccAsmBasic#getAsm <em>Asm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Asm</em>' attribute.
	 * @see #getAsm()
	 * @generated
	 */
	void setAsm(String value);

	/**
	 * Returns the value of the '<em><b>String</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String</em>' attribute list.
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getGccAsmBasic_String()
	 * @model
	 * @generated
	 */
	EList<String> getString();

} // GccAsmBasic
