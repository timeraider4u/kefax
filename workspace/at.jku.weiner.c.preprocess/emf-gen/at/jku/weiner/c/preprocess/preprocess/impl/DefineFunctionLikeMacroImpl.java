/**
 */
package at.jku.weiner.c.preprocess.preprocess.impl;

import at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro;
import at.jku.weiner.c.preprocess.preprocess.IdentifierList;
import at.jku.weiner.c.preprocess.preprocess.PreprocessPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Define Function Like Macro</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.DefineFunctionLikeMacroImpl#getList <em>List</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.DefineFunctionLikeMacroImpl#getString <em>String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DefineFunctionLikeMacroImpl extends DefineDirectiveImpl implements DefineFunctionLikeMacro
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefineFunctionLikeMacroImpl()
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
		return PreprocessPackage.Literals.DEFINE_FUNCTION_LIKE_MACRO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierList getList()
	{
		return (IdentifierList)eGet(PreprocessPackage.Literals.DEFINE_FUNCTION_LIKE_MACRO__LIST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setList(IdentifierList newList)
	{
		eSet(PreprocessPackage.Literals.DEFINE_FUNCTION_LIKE_MACRO__LIST, newList);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getString()
	{
		return (String)eGet(PreprocessPackage.Literals.DEFINE_FUNCTION_LIKE_MACRO__STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setString(String newString)
	{
		eSet(PreprocessPackage.Literals.DEFINE_FUNCTION_LIKE_MACRO__STRING, newString);
	}

} //DefineFunctionLikeMacroImpl
