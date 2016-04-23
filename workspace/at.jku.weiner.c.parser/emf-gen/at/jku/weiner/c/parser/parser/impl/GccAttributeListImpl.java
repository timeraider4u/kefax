/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.GccAttribute;
import at.jku.weiner.c.parser.parser.GccAttributeList;
import at.jku.weiner.c.parser.parser.ParserPackage;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gcc Attribute List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.GccAttributeListImpl#getGccAttribute <em>Gcc Attribute</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GccAttributeListImpl extends PersistentEObjectImpl implements GccAttributeList
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GccAttributeListImpl()
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
		return ParserPackage.Literals.GCC_ATTRIBUTE_LIST;
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
	public EList<GccAttribute> getGccAttribute()
	{
		return (EList<GccAttribute>)eGet(ParserPackage.Literals.GCC_ATTRIBUTE_LIST__GCC_ATTRIBUTE, true);
	}

} //GccAttributeListImpl
