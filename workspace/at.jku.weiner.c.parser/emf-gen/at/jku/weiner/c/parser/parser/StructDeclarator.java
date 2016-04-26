/**
 */
package at.jku.weiner.c.parser.parser;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Struct Declarator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.StructDeclarator#getDeclarator <em>Declarator</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.StructDeclarator#getConstExpr <em>Const Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getStructDeclarator()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface StructDeclarator extends PersistentEObject
{
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
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getStructDeclarator_Declarator()
	 * @model containment="true"
	 * @generated
	 */
	Declarator getDeclarator();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.StructDeclarator#getDeclarator <em>Declarator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declarator</em>' containment reference.
	 * @see #getDeclarator()
	 * @generated
	 */
	void setDeclarator(Declarator value);

	/**
	 * Returns the value of the '<em><b>Const Expr</b></em>' containment reference list.
	 * The list contents are of type {@link at.jku.weiner.c.parser.parser.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Const Expr</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Const Expr</em>' containment reference list.
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getStructDeclarator_ConstExpr()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getConstExpr();

} // StructDeclarator
