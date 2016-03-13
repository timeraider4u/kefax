/**
 */
package at.jku.weiner.c.parser.parser;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Initializer List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.InitializerList#getInit <em>Init</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getInitializerList()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface InitializerList extends PersistentEObject
{
	/**
	 * Returns the value of the '<em><b>Init</b></em>' containment reference list.
	 * The list contents are of type {@link at.jku.weiner.c.parser.parser.Init}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init</em>' containment reference list.
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getInitializerList_Init()
	 * @model containment="true"
	 * @generated
	 */
	EList<Init> getInit();

} // InitializerList
