/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.AbstractDeclarator;
import at.jku.weiner.c.parser.parser.DirectAbstractDeclarator;
import at.jku.weiner.c.parser.parser.GccDeclaratorExtension;
import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.Pointer;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Declarator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AbstractDeclaratorImpl#getPointer <em>Pointer</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AbstractDeclaratorImpl#getDirectAbstractDeclarator <em>Direct Abstract Declarator</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AbstractDeclaratorImpl#getGccDeclExtAbstract <em>Gcc Decl Ext Abstract</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbstractDeclaratorImpl extends PersistentEObjectImpl implements AbstractDeclarator
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractDeclaratorImpl()
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
		return ParserPackage.Literals.ABSTRACT_DECLARATOR;
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
		return (Pointer)eGet(ParserPackage.Literals.ABSTRACT_DECLARATOR__POINTER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointer(Pointer newPointer)
	{
		eSet(ParserPackage.Literals.ABSTRACT_DECLARATOR__POINTER, newPointer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectAbstractDeclarator getDirectAbstractDeclarator()
	{
		return (DirectAbstractDeclarator)eGet(ParserPackage.Literals.ABSTRACT_DECLARATOR__DIRECT_ABSTRACT_DECLARATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirectAbstractDeclarator(DirectAbstractDeclarator newDirectAbstractDeclarator)
	{
		eSet(ParserPackage.Literals.ABSTRACT_DECLARATOR__DIRECT_ABSTRACT_DECLARATOR, newDirectAbstractDeclarator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<GccDeclaratorExtension> getGccDeclExtAbstract()
	{
		return (EList<GccDeclaratorExtension>)eGet(ParserPackage.Literals.ABSTRACT_DECLARATOR__GCC_DECL_EXT_ABSTRACT, true);
	}

} //AbstractDeclaratorImpl
