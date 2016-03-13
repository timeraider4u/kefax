/**
 */
package at.jku.weiner.c.parser.parser;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Qualifier List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.TypeQualifierList#getTypeQualifier <em>Type Qualifier</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getTypeQualifierList()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface TypeQualifierList extends PersistentEObject
{
	/**
	 * Returns the value of the '<em><b>Type Qualifier</b></em>' containment reference list.
	 * The list contents are of type {@link at.jku.weiner.c.parser.parser.TypeQualifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Qualifier</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Qualifier</em>' containment reference list.
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getTypeQualifierList_TypeQualifier()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypeQualifier> getTypeQualifier();

} // TypeQualifierList
