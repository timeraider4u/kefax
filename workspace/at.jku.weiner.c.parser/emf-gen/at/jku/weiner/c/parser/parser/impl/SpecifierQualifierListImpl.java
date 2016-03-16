/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeQualifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specifier Qualifier List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.SpecifierQualifierListImpl#getTypeSpecifier <em>Type Specifier</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.SpecifierQualifierListImpl#getTypeQualifier <em>Type Qualifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecifierQualifierListImpl extends PersistentEObjectImpl implements SpecifierQualifierList
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecifierQualifierListImpl()
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
		return ParserPackage.Literals.SPECIFIER_QUALIFIER_LIST;
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
	public EList<TypeSpecifier> getTypeSpecifier()
	{
		return (EList<TypeSpecifier>)eGet(ParserPackage.Literals.SPECIFIER_QUALIFIER_LIST__TYPE_SPECIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<TypeQualifier> getTypeQualifier()
	{
		return (EList<TypeQualifier>)eGet(ParserPackage.Literals.SPECIFIER_QUALIFIER_LIST__TYPE_QUALIFIER, true);
	}

} //SpecifierQualifierListImpl
