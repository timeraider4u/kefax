/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.Pointer;
import at.jku.weiner.c.parser.parser.TypeQualifierList;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pointer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PointerImpl#getStar <em>Star</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PointerImpl#getCaret <em>Caret</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PointerImpl#getTypeQualifierList <em>Type Qualifier List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PointerImpl extends PersistentEObjectImpl implements Pointer
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PointerImpl()
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
		return ParserPackage.Literals.POINTER;
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
	public EList<String> getStar()
	{
		return (EList<String>)eGet(ParserPackage.Literals.POINTER__STAR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getCaret()
	{
		return (EList<String>)eGet(ParserPackage.Literals.POINTER__CARET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<TypeQualifierList> getTypeQualifierList()
	{
		return (EList<TypeQualifierList>)eGet(ParserPackage.Literals.POINTER__TYPE_QUALIFIER_LIST, true);
	}

} //PointerImpl
