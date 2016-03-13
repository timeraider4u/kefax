/**
 */
package at.jku.weiner.c.parser.parser;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gcc Attribute List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.GccAttributeList#getGccAttribute <em>Gcc Attribute</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getGccAttributeList()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface GccAttributeList extends PersistentEObject
{
	/**
	 * Returns the value of the '<em><b>Gcc Attribute</b></em>' containment reference list.
	 * The list contents are of type {@link at.jku.weiner.c.parser.parser.GccAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gcc Attribute</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gcc Attribute</em>' containment reference list.
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getGccAttributeList_GccAttribute()
	 * @model containment="true"
	 * @generated
	 */
	EList<GccAttribute> getGccAttribute();

} // GccAttributeList
