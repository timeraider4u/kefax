/**
 */
package at.jku.weiner.c.preprocess.preprocess;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifier List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.IdentifierList#getIdent <em>Ident</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.IdentifierList#isVariadic <em>Variadic</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.IdentifierList#getVarID <em>Var ID</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getIdentifierList()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface IdentifierList extends PersistentEObject
{
	/**
	 * Returns the value of the '<em><b>Ident</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ident</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ident</em>' attribute list.
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getIdentifierList_Ident()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getIdent();

	/**
	 * Returns the value of the '<em><b>Variadic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variadic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variadic</em>' attribute.
	 * @see #setVariadic(boolean)
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getIdentifierList_Variadic()
	 * @model
	 * @generated
	 */
	boolean isVariadic();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.IdentifierList#isVariadic <em>Variadic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variadic</em>' attribute.
	 * @see #isVariadic()
	 * @generated
	 */
	void setVariadic(boolean value);

	/**
	 * Returns the value of the '<em><b>Var ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var ID</em>' attribute.
	 * @see #setVarID(String)
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getIdentifierList_VarID()
	 * @model
	 * @generated
	 */
	String getVarID();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.IdentifierList#getVarID <em>Var ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var ID</em>' attribute.
	 * @see #getVarID()
	 * @generated
	 */
	void setVarID(String value);

} // IdentifierList
