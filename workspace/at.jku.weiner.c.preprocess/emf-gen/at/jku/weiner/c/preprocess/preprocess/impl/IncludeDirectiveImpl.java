/**
 */
package at.jku.weiner.c.preprocess.preprocess.impl;

import at.jku.weiner.c.common.common.TranslationUnit;

import at.jku.weiner.c.preprocess.preprocess.IncludeDirective;
import at.jku.weiner.c.preprocess.preprocess.PreprocessPackage;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Include Directive</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.IncludeDirectiveImpl#getString <em>String</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.IncludeDirectiveImpl#getUnit <em>Unit</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.IncludeDirectiveImpl#isNext <em>Next</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IncludeDirectiveImpl extends PersistentEObjectImpl implements IncludeDirective
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IncludeDirectiveImpl()
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
		return PreprocessPackage.Literals.INCLUDE_DIRECTIVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount()
	{
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getString()
	{
		return (String)eGet(PreprocessPackage.Literals.INCLUDE_DIRECTIVE__STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setString(String newString)
	{
		eSet(PreprocessPackage.Literals.INCLUDE_DIRECTIVE__STRING, newString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TranslationUnit getUnit()
	{
		return (TranslationUnit)eGet(PreprocessPackage.Literals.INCLUDE_DIRECTIVE__UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnit(TranslationUnit newUnit)
	{
		eSet(PreprocessPackage.Literals.INCLUDE_DIRECTIVE__UNIT, newUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNext()
	{
		return (Boolean)eGet(PreprocessPackage.Literals.INCLUDE_DIRECTIVE__NEXT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNext(boolean newNext)
	{
		eSet(PreprocessPackage.Literals.INCLUDE_DIRECTIVE__NEXT, newNext);
	}

} //IncludeDirectiveImpl
