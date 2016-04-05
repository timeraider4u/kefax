/**
 */
package at.jku.weiner.c.common.common.impl;

import at.jku.weiner.c.common.common.ArgumentExpressionList;
import at.jku.weiner.c.common.common.CommonPackage;
import at.jku.weiner.c.common.common.PostfixExpressionSuffixArgument;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Postfix Expression Suffix Argument</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.common.common.impl.PostfixExpressionSuffixArgumentImpl#getArgumentExpressionList <em>Argument Expression List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PostfixExpressionSuffixArgumentImpl extends PostfixExpressionSuffixImpl implements PostfixExpressionSuffixArgument
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PostfixExpressionSuffixArgumentImpl()
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
		return CommonPackage.Literals.POSTFIX_EXPRESSION_SUFFIX_ARGUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArgumentExpressionList getArgumentExpressionList()
	{
		return (ArgumentExpressionList)eGet(CommonPackage.Literals.POSTFIX_EXPRESSION_SUFFIX_ARGUMENT__ARGUMENT_EXPRESSION_LIST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArgumentExpressionList(ArgumentExpressionList newArgumentExpressionList)
	{
		eSet(CommonPackage.Literals.POSTFIX_EXPRESSION_SUFFIX_ARGUMENT__ARGUMENT_EXPRESSION_LIST, newArgumentExpressionList);
	}

} //PostfixExpressionSuffixArgumentImpl
