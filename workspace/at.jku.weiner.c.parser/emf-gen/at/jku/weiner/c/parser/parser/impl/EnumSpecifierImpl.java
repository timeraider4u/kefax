/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.EnumSpecifier;
import at.jku.weiner.c.parser.parser.EnumeratorList;
import at.jku.weiner.c.parser.parser.ParserPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.EnumSpecifierImpl#getEnumList <em>Enum List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumSpecifierImpl extends DeclarationSpecifierImpl implements EnumSpecifier
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumSpecifierImpl()
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
		return ParserPackage.Literals.ENUM_SPECIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumeratorList getEnumList()
	{
		return (EnumeratorList)eGet(ParserPackage.Literals.ENUM_SPECIFIER__ENUM_LIST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnumList(EnumeratorList newEnumList)
	{
		eSet(ParserPackage.Literals.ENUM_SPECIFIER__ENUM_LIST, newEnumList);
	}

} //EnumSpecifierImpl
