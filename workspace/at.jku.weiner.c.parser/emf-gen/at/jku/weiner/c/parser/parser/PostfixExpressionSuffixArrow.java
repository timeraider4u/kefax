/**
 */
package at.jku.weiner.c.parser.parser;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Postfix Expression Suffix Arrow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArrow#getIdent <em>Ident</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPostfixExpressionSuffixArrow()
 * @model
 * @generated
 */
public interface PostfixExpressionSuffixArrow extends PostfixExpressionSuffix
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
	 * @see at.jku.weiner.c.parser.parser.ParserPackage#getPostfixExpressionSuffixArrow_Ident()
	 * @model
	 * @generated
	 */
	String getIdent();

	/**
	 * Sets the value of the '{@link at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArrow#getIdent <em>Ident</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ident</em>' attribute.
	 * @see #getIdent()
	 * @generated
	 */
	void setIdent(String value);

} // PostfixExpressionSuffixArrow
