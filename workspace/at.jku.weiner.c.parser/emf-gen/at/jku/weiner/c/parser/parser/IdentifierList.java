/**
 */
package at.jku.weiner.c.parser.parser;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifier List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.IdentifierList#getIdent <em>Ident</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getIdentifierList()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface IdentifierList extends PersistentEObject
{
	/**
	 * Returns the value of the '<em><b>Ident</b></em>' containment reference list.
	 * The list contents are of type {@link at.jku.weiner.c.parser.parser.MyIdentifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ident</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ident</em>' containment reference list.
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getIdentifierList_Ident()
	 * @model containment="true"
	 * @generated
	 */
	EList<MyIdentifier> getIdent();

} // IdentifierList
