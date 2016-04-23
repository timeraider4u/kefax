/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixDot;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Postfix Expression Suffix Dot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixDotImpl#getIdent <em>Ident</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PostfixExpressionSuffixDotImpl extends PostfixExpressionSuffixImpl implements PostfixExpressionSuffixDot
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PostfixExpressionSuffixDotImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return ParserPackage.Literals.POSTFIX_EXPRESSION_SUFFIX_DOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdent()
	{
		return (String)eGet(ParserPackage.Literals.POSTFIX_EXPRESSION_SUFFIX_DOT__IDENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdent(String newIdent)
	{
		eSet(ParserPackage.Literals.POSTFIX_EXPRESSION_SUFFIX_DOT__IDENT, newIdent);
	}

} //PostfixExpressionSuffixDotImpl
