/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.AbstractDeclarator;
import at.jku.weiner.c.parser.parser.AbstractDeclaratorSuffix;
import at.jku.weiner.c.parser.parser.DirectAbstractDeclarator;
import at.jku.weiner.c.parser.parser.GccDeclaratorExtension;
import at.jku.weiner.c.parser.parser.ParserPackage;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Direct Abstract Declarator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DirectAbstractDeclaratorImpl#getDeclarator <em>Declarator</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DirectAbstractDeclaratorImpl#getGccDeclExt <em>Gcc Decl Ext</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DirectAbstractDeclaratorImpl#getAbstractDeclaratorSuffix <em>Abstract Declarator Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DirectAbstractDeclaratorImpl extends PersistentEObjectImpl implements DirectAbstractDeclarator
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DirectAbstractDeclaratorImpl()
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
		return ParserPackage.Literals.DIRECT_ABSTRACT_DECLARATOR;
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
	public AbstractDeclarator getDeclarator()
	{
		return (AbstractDeclarator)eGet(ParserPackage.Literals.DIRECT_ABSTRACT_DECLARATOR__DECLARATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclarator(AbstractDeclarator newDeclarator)
	{
		eSet(ParserPackage.Literals.DIRECT_ABSTRACT_DECLARATOR__DECLARATOR, newDeclarator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<GccDeclaratorExtension> getGccDeclExt()
	{
		return (EList<GccDeclaratorExtension>)eGet(ParserPackage.Literals.DIRECT_ABSTRACT_DECLARATOR__GCC_DECL_EXT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AbstractDeclaratorSuffix> getAbstractDeclaratorSuffix()
	{
		return (EList<AbstractDeclaratorSuffix>)eGet(ParserPackage.Literals.DIRECT_ABSTRACT_DECLARATOR__ABSTRACT_DECLARATOR_SUFFIX, true);
	}

} //DirectAbstractDeclaratorImpl
