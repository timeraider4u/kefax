/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.ParserPackage;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declaration Specifiers</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DeclarationSpecifiersImpl#getDeclarationSpecifier <em>Declaration Specifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeclarationSpecifiersImpl extends PersistentEObjectImpl implements DeclarationSpecifiers
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeclarationSpecifiersImpl()
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
		return ParserPackage.Literals.DECLARATION_SPECIFIERS;
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
	@SuppressWarnings("unchecked")
	public EList<EObject> getDeclarationSpecifier()
	{
		return (EList<EObject>)eGet(ParserPackage.Literals.DECLARATION_SPECIFIERS__DECLARATION_SPECIFIER, true);
	}

} //DeclarationSpecifiersImpl
