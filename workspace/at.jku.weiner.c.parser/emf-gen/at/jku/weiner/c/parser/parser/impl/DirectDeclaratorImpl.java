/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.ParserPackage;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Direct Declarator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DirectDeclaratorImpl#getIdent <em>Ident</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DirectDeclaratorImpl#getDeclarator <em>Declarator</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DirectDeclaratorImpl#getDeclaratorSuffix <em>Declarator Suffix</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DirectDeclaratorImpl extends PersistentEObjectImpl implements DirectDeclarator
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DirectDeclaratorImpl()
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
		return ParserPackage.Literals.DIRECT_DECLARATOR;
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
	public String getIdent()
	{
		return (String)eGet(ParserPackage.Literals.DIRECT_DECLARATOR__IDENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdent(String newIdent)
	{
		eSet(ParserPackage.Literals.DIRECT_DECLARATOR__IDENT, newIdent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Declarator getDeclarator()
	{
		return (Declarator)eGet(ParserPackage.Literals.DIRECT_DECLARATOR__DECLARATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclarator(Declarator newDeclarator)
	{
		eSet(ParserPackage.Literals.DIRECT_DECLARATOR__DECLARATOR, newDeclarator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<DeclaratorSuffix> getDeclaratorSuffix()
	{
		return (EList<DeclaratorSuffix>)eGet(ParserPackage.Literals.DIRECT_DECLARATOR__DECLARATOR_SUFFIX, true);
	}

} //DirectDeclaratorImpl
