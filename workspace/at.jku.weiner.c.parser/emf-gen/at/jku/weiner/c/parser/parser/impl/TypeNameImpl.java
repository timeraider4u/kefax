/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.AbstractDeclarator;
import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeName;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Name</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeNameImpl#getList <em>List</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeNameImpl#getAbstractDeclarator <em>Abstract Declarator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeNameImpl extends PersistentEObjectImpl implements TypeName
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeNameImpl()
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
		return ParserPackage.Literals.TYPE_NAME;
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
		return (SpecifierQualifierList)eGet(ParserPackage.Literals.TYPE_NAME__LIST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setList(SpecifierQualifierList newList)
	{
		eSet(ParserPackage.Literals.TYPE_NAME__LIST, newList);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractDeclarator getAbstractDeclarator()
	{
		return (AbstractDeclarator)eGet(ParserPackage.Literals.TYPE_NAME__ABSTRACT_DECLARATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstractDeclarator(AbstractDeclarator newAbstractDeclarator)
	{
		eSet(ParserPackage.Literals.TYPE_NAME__ABSTRACT_DECLARATOR, newAbstractDeclarator);
	}

} //TypeNameImpl
