/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.GccDeclaratorExtension;
import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.Pointer;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declarator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DeclaratorImpl#getPointer <em>Pointer</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DeclaratorImpl#getGccDeclExt1 <em>Gcc Decl Ext1</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DeclaratorImpl#getDeclarator <em>Declarator</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DeclaratorImpl#getGccDeclExt2 <em>Gcc Decl Ext2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeclaratorImpl extends PersistentEObjectImpl implements Declarator
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeclaratorImpl()
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
		return ParserPackage.Literals.DECLARATOR;
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
	public Pointer getPointer()
	{
		return (Pointer)eGet(ParserPackage.Literals.DECLARATOR__POINTER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointer(Pointer newPointer)
	{
		eSet(ParserPackage.Literals.DECLARATOR__POINTER, newPointer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<GccDeclaratorExtension> getGccDeclExt1()
	{
		return (EList<GccDeclaratorExtension>)eGet(ParserPackage.Literals.DECLARATOR__GCC_DECL_EXT1, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectDeclarator getDeclarator()
	{
		return (DirectDeclarator)eGet(ParserPackage.Literals.DECLARATOR__DECLARATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclarator(DirectDeclarator newDeclarator)
	{
		eSet(ParserPackage.Literals.DECLARATOR__DECLARATOR, newDeclarator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<GccDeclaratorExtension> getGccDeclExt2()
	{
		return (EList<GccDeclaratorExtension>)eGet(ParserPackage.Literals.DECLARATOR__GCC_DECL_EXT2, true);
	}

} //DeclaratorImpl
