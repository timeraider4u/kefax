/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.StructDeclarationList;
import at.jku.weiner.c.parser.parser.StructOrUnion;
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Struct Or Union Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.StructOrUnionSpecifierImpl#getType <em>Type</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.StructOrUnionSpecifierImpl#isBraces <em>Braces</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.StructOrUnionSpecifierImpl#getStructDeclList <em>Struct Decl List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructOrUnionSpecifierImpl extends DeclarationSpecifierImpl implements StructOrUnionSpecifier
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructOrUnionSpecifierImpl()
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
		return ParserPackage.Literals.STRUCT_OR_UNION_SPECIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructOrUnion getType()
	{
		return (StructOrUnion)eGet(ParserPackage.Literals.STRUCT_OR_UNION_SPECIFIER__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(StructOrUnion newType)
	{
		eSet(ParserPackage.Literals.STRUCT_OR_UNION_SPECIFIER__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBraces()
	{
		return (Boolean)eGet(ParserPackage.Literals.STRUCT_OR_UNION_SPECIFIER__BRACES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBraces(boolean newBraces)
	{
		eSet(ParserPackage.Literals.STRUCT_OR_UNION_SPECIFIER__BRACES, newBraces);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructDeclarationList getStructDeclList()
	{
		return (StructDeclarationList)eGet(ParserPackage.Literals.STRUCT_OR_UNION_SPECIFIER__STRUCT_DECL_LIST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStructDeclList(StructDeclarationList newStructDeclList)
	{
		eSet(ParserPackage.Literals.STRUCT_OR_UNION_SPECIFIER__STRUCT_DECL_LIST, newStructDeclList);
	}

} //StructOrUnionSpecifierImpl
