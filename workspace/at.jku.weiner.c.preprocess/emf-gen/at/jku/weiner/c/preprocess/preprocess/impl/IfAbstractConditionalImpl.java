/**
 */
package at.jku.weiner.c.preprocess.preprocess.impl;

import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.IfAbstractConditional;
import at.jku.weiner.c.preprocess.preprocess.PreprocessPackage;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Abstract Conditional</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.IfAbstractConditionalImpl#isBranchTaken <em>Branch Taken</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.IfAbstractConditionalImpl#getGroup <em>Group</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfAbstractConditionalImpl extends PersistentEObjectImpl implements IfAbstractConditional
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfAbstractConditionalImpl()
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
		return PreprocessPackage.Literals.IF_ABSTRACT_CONDITIONAL;
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
	public boolean isBranchTaken()
	{
		return (Boolean)eGet(PreprocessPackage.Literals.IF_ABSTRACT_CONDITIONAL__BRANCH_TAKEN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBranchTaken(boolean newBranchTaken)
	{
		eSet(PreprocessPackage.Literals.IF_ABSTRACT_CONDITIONAL__BRANCH_TAKEN, newBranchTaken);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GroupOpt getGroup()
	{
		return (GroupOpt)eGet(PreprocessPackage.Literals.IF_ABSTRACT_CONDITIONAL__GROUP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroup(GroupOpt newGroup)
	{
		eSet(PreprocessPackage.Literals.IF_ABSTRACT_CONDITIONAL__GROUP, newGroup);
	}

} //IfAbstractConditionalImpl
