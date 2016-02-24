/**
 */
package at.jku.weiner.c.preprocess.preprocess.impl;

import at.jku.weiner.c.preprocess.preprocess.ConditionalDirective;
import at.jku.weiner.c.preprocess.preprocess.ElIfConditional;
import at.jku.weiner.c.preprocess.preprocess.ElseConditional;
import at.jku.weiner.c.preprocess.preprocess.IfAbstractConditional;
import at.jku.weiner.c.preprocess.preprocess.PreprocessPackage;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Directive</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.ConditionalDirectiveImpl#getConditional <em>Conditional</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.ConditionalDirectiveImpl#getElifs <em>Elifs</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.ConditionalDirectiveImpl#getElse <em>Else</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.ConditionalDirectiveImpl#getBranchTaken <em>Branch Taken</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionalDirectiveImpl extends PersistentEObjectImpl implements ConditionalDirective
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionalDirectiveImpl()
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
		return PreprocessPackage.Literals.CONDITIONAL_DIRECTIVE;
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
	public IfAbstractConditional getConditional()
	{
		return (IfAbstractConditional)eGet(PreprocessPackage.Literals.CONDITIONAL_DIRECTIVE__CONDITIONAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditional(IfAbstractConditional newConditional)
	{
		eSet(PreprocessPackage.Literals.CONDITIONAL_DIRECTIVE__CONDITIONAL, newConditional);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElIfConditional> getElifs()
	{
		return (EList<ElIfConditional>)eGet(PreprocessPackage.Literals.CONDITIONAL_DIRECTIVE__ELIFS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElseConditional getElse()
	{
		return (ElseConditional)eGet(PreprocessPackage.Literals.CONDITIONAL_DIRECTIVE__ELSE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElse(ElseConditional newElse)
	{
		eSet(PreprocessPackage.Literals.CONDITIONAL_DIRECTIVE__ELSE, newElse);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfAbstractConditional getBranchTaken()
	{
		return (IfAbstractConditional)eGet(PreprocessPackage.Literals.CONDITIONAL_DIRECTIVE__BRANCH_TAKEN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBranchTaken(IfAbstractConditional newBranchTaken)
	{
		eSet(PreprocessPackage.Literals.CONDITIONAL_DIRECTIVE__BRANCH_TAKEN, newBranchTaken);
	}

} //ConditionalDirectiveImpl
