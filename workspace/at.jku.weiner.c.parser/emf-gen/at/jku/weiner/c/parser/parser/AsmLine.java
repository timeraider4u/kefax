/**
 */
package at.jku.weiner.c.parser.parser;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Asm Line</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.AsmLine#getSym <em>Sym</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.AsmLine#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getAsmLine()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface AsmLine extends PersistentEObject
{
	/**
	 * Returns the value of the '<em><b>Sym</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sym</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sym</em>' containment reference.
	 * @see #setSym(AsmSymbolicName)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getAsmLine_Sym()
	 * @model containment="true"
	 * @generated
	 */
	AsmSymbolicName getSym();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.AsmLine#getSym <em>Sym</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sym</em>' containment reference.
	 * @see #getSym()
	 * @generated
	 */
	void setSym(AsmSymbolicName value);

	/**
	 * Returns the value of the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expr</em>' containment reference.
	 * @see #setExpr(Expression)
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getAsmLine_Expr()
	 * @model containment="true"
	 * @generated
	 */
	Expression getExpr();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.AsmLine#getExpr <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr</em>' containment reference.
	 * @see #getExpr()
	 * @generated
	 */
	void setExpr(Expression value);

} // AsmLine
