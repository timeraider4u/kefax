/**
 */
package at.jku.weiner.c.parser.parser;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pointer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.Pointer#getStar <em>Star</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.Pointer#getCaret <em>Caret</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.Pointer#getTypeQualifierList <em>Type Qualifier List</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPointer()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface Pointer extends PersistentEObject
{
	/**
	 * Returns the value of the '<em><b>Star</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Star</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Star</em>' attribute list.
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPointer_Star()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getStar();

	/**
	 * Returns the value of the '<em><b>Caret</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Caret</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Caret</em>' attribute list.
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPointer_Caret()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getCaret();

	/**
	 * Returns the value of the '<em><b>Type Qualifier List</b></em>' containment reference list.
	 * The list contents are of type {@link at.jku.weiner.c.parser.parser.TypeQualifierList}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Qualifier List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Qualifier List</em>' containment reference list.
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPointer_TypeQualifierList()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypeQualifierList> getTypeQualifierList();

} // Pointer
