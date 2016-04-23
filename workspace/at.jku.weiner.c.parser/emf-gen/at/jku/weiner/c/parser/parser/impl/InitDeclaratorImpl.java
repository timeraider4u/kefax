/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.ParserPackage;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Init Declarator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.InitDeclaratorImpl#getDeclarator <em>Declarator</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.InitDeclaratorImpl#getInitializer <em>Initializer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InitDeclaratorImpl extends PersistentEObjectImpl implements InitDeclarator
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InitDeclaratorImpl()
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
		return ParserPackage.Literals.INIT_DECLARATOR;
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
	public Declarator getDeclarator()
	{
		return (Declarator)eGet(ParserPackage.Literals.INIT_DECLARATOR__DECLARATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclarator(Declarator newDeclarator)
	{
		eSet(ParserPackage.Literals.INIT_DECLARATOR__DECLARATOR, newDeclarator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Initializer getInitializer()
	{
		return (Initializer)eGet(ParserPackage.Literals.INIT_DECLARATOR__INITIALIZER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitializer(Initializer newInitializer)
	{
		eSet(ParserPackage.Literals.INIT_DECLARATOR__INITIALIZER, newInitializer);
	}

} //InitDeclaratorImpl
