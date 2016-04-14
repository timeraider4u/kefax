/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parser</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.Parser#getExternal <em>External</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getParser()
 * @model
 * @generated
 */
public interface Parser extends at.jku.weiner.c.common.common.Parser
{
	/**
	 * Returns the value of the '<em><b>External</b></em>' containment reference list.
	 * The list contents are of type {@link at.jku.weiner.c.parser.parser.ExternalDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External</em>' containment reference list.
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getParser_External()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExternalDeclaration> getExternal();

} // Parser
