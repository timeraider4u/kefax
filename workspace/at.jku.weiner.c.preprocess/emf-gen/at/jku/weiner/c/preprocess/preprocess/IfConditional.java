/**
 */
package at.jku.weiner.c.preprocess.preprocess;

import at.jku.weiner.c.common.common.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Conditional</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.IfConditional#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getIfConditional()
 * @model
 * @generated
 */
public interface IfConditional extends IfAbstractConditional
{
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Expression)
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getIfConditional_Expression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.preprocess.preprocess.IfConditional#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

} // IfConditional
