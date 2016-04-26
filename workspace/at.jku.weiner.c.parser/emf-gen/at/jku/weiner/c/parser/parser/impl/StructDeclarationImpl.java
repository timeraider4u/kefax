/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.StructDeclaration;
import at.jku.weiner.c.parser.parser.StructDeclaratorList;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Struct Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.StructDeclarationImpl#getList <em>List</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.StructDeclarationImpl#getStructDeclarationList <em>Struct Declaration List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructDeclarationImpl extends PersistentEObjectImpl implements StructDeclaration
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructDeclarationImpl()
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
		return ParserPackage.Literals.STRUCT_DECLARATION;
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
	public SpecifierQualifierList getList()
	{
		return (SpecifierQualifierList)eGet(ParserPackage.Literals.STRUCT_DECLARATION__LIST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setList(SpecifierQualifierList newList)
	{
		eSet(ParserPackage.Literals.STRUCT_DECLARATION__LIST, newList);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructDeclaratorList getStructDeclarationList()
	{
		return (StructDeclaratorList)eGet(ParserPackage.Literals.STRUCT_DECLARATION__STRUCT_DECLARATION_LIST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStructDeclarationList(StructDeclaratorList newStructDeclarationList)
	{
		eSet(ParserPackage.Literals.STRUCT_DECLARATION__STRUCT_DECLARATION_LIST, newStructDeclarationList);
	}

} //StructDeclarationImpl
