/**
 */
package at.jku.weiner.c.parser.parser;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Direct Declarator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.DirectDeclarator#getIdent <em>Ident</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.DirectDeclarator#getDeclarator <em>Declarator</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.DirectDeclarator#getDeclaratorSuffix <em>Declarator Suffix</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getDirectDeclarator()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface DirectDeclarator extends PersistentEObject
{
	/**
	 * Returns the value of the '<em><b>Ident</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ident</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ident</em>' attribute.
	 * @see #setIdent(String)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getDirectDeclarator_Ident()
	 * @model
	 * @generated
	 */
	String getIdent();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.DirectDeclarator#getIdent <em>Ident</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ident</em>' attribute.
	 * @see #getIdent()
	 * @generated
	 */
	void setIdent(String value);

	/**
	 * Returns the value of the '<em><b>Declarator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declarator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declarator</em>' containment reference.
	 * @see #setDeclarator(Declarator)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getDirectDeclarator_Declarator()
	 * @model containment="true"
	 * @generated
	 */
	Declarator getDeclarator();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.DirectDeclarator#getDeclarator <em>Declarator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declarator</em>' containment reference.
	 * @see #getDeclarator()
	 * @generated
	 */
	void setDeclarator(Declarator value);

	/**
	 * Returns the value of the '<em><b>Declarator Suffix</b></em>' containment reference list.
	 * The list contents are of type {@link at.jku.weiner.c.parser.parser.DeclaratorSuffix}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declarator Suffix</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declarator Suffix</em>' containment reference list.
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getDirectDeclarator_DeclaratorSuffix()
	 * @model containment="true"
	 * @generated
	 */
	EList<DeclaratorSuffix> getDeclaratorSuffix();

} // DirectDeclarator
