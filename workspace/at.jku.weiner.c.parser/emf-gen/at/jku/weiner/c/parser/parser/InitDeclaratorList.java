/**
 */
package at.jku.weiner.c.parser.parser;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Init Declarator List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.InitDeclaratorList#getInitDeclarator <em>Init Declarator</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getInitDeclaratorList()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface InitDeclaratorList extends PersistentEObject
{
	/**
	 * Returns the value of the '<em><b>Init Declarator</b></em>' containment reference list.
	 * The list contents are of type {@link at.jku.weiner.c.parser.parser.InitDeclarator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Declarator</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Declarator</em>' containment reference list.
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getInitDeclaratorList_InitDeclarator()
	 * @model containment="true"
	 * @generated
	 */
	EList<InitDeclarator> getInitDeclarator();

} // InitDeclaratorList
