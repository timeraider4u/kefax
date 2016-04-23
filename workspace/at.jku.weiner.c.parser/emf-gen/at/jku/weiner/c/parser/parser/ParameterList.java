/**
 */
package at.jku.weiner.c.parser.parser;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.ParameterList#getParameterDeclaration <em>Parameter Declaration</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getParameterList()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface ParameterList extends PersistentEObject
{
	/**
	 * Returns the value of the '<em><b>Parameter Declaration</b></em>' containment reference list.
	 * The list contents are of type {@link at.jku.weiner.c.parser.parser.ParameterDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Declaration</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Declaration</em>' containment reference list.
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getParameterList_ParameterDeclaration()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterDeclaration> getParameterDeclaration();

} // ParameterList
