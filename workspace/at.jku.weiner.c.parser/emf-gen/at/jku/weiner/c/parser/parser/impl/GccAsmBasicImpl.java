/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.GccAsmBasic;
import at.jku.weiner.c.parser.parser.ParserPackage;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gcc Asm Basic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.GccAsmBasicImpl#getAsm <em>Asm</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.GccAsmBasicImpl#getString <em>String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GccAsmBasicImpl extends PersistentEObjectImpl implements GccAsmBasic
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GccAsmBasicImpl()
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
		return ParserPackage.Literals.GCC_ASM_BASIC;
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
	public String getAsm()
	{
		return (String)eGet(ParserPackage.Literals.GCC_ASM_BASIC__ASM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAsm(String newAsm)
	{
		eSet(ParserPackage.Literals.GCC_ASM_BASIC__ASM, newAsm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getString()
	{
		return (EList<String>)eGet(ParserPackage.Literals.GCC_ASM_BASIC__STRING, true);
	}

} //GccAsmBasicImpl
