/**
 */
package at.jku.weiner.c.common.common;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Argument Expression List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.common.common.ArgumentExpressionList#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.common.common.CommonPackage#getArgumentExpressionList()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface ArgumentExpressionList extends PersistentEObject
{
	/**
	 * Returns the value of the '<em><b>Expr</b></em>' containment reference list.
	 * The list contents are of type {@link at.jku.weiner.c.common.common.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expr</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expr</em>' containment reference list.
	 * @see at.jku.weiner.c.common.common.CommonPackage#getArgumentExpressionList_Expr()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getExpr();

} // ArgumentExpressionList
