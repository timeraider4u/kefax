/**
 */
package at.jku.weiner.c.parser.parser;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Asm Line Without Colon</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.AsmLineWithoutColon#getAsmLines <em>Asm Lines</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getAsmLineWithoutColon()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface AsmLineWithoutColon extends PersistentEObject
{
	/**
	 * Returns the value of the '<em><b>Asm Lines</b></em>' containment reference list.
	 * The list contents are of type {@link at.jku.weiner.c.parser.parser.AsmLine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Asm Lines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Asm Lines</em>' containment reference list.
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getAsmLineWithoutColon_AsmLines()
	 * @model containment="true"
	 * @generated
	 */
	EList<AsmLine> getAsmLines();

} // AsmLineWithoutColon
