/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.GccAttributeList;
import at.jku.weiner.c.parser.parser.GccAttributeSpecifier;
import at.jku.weiner.c.parser.parser.ParserPackage;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gcc Attribute Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.GccAttributeSpecifierImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.GccAttributeSpecifierImpl#getList <em>List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GccAttributeSpecifierImpl extends PersistentEObjectImpl implements GccAttributeSpecifier
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GccAttributeSpecifierImpl()
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
		return ParserPackage.Literals.GCC_ATTRIBUTE_SPECIFIER;
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
	public String getAttribute()
	{
		return (String)eGet(ParserPackage.Literals.GCC_ATTRIBUTE_SPECIFIER__ATTRIBUTE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute(String newAttribute)
	{
		eSet(ParserPackage.Literals.GCC_ATTRIBUTE_SPECIFIER__ATTRIBUTE, newAttribute);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GccAttributeList getList()
	{
		return (GccAttributeList)eGet(ParserPackage.Literals.GCC_ATTRIBUTE_SPECIFIER__LIST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setList(GccAttributeList newList)
	{
		eSet(ParserPackage.Literals.GCC_ATTRIBUTE_SPECIFIER__LIST, newList);
	}

} //GccAttributeSpecifierImpl
