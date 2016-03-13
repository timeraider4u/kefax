/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.EnumeratorList;
import at.jku.weiner.c.parser.parser.ParserPackage;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumerator List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.EnumeratorListImpl#getEnumerator <em>Enumerator</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.EnumeratorListImpl#isLastComma <em>Last Comma</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumeratorListImpl extends PersistentEObjectImpl implements EnumeratorList
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumeratorListImpl()
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
		return ParserPackage.Literals.ENUMERATOR_LIST;
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
	public EList<Enumerator> getEnumerator()
	{
		return (EList<Enumerator>)eGet(ParserPackage.Literals.ENUMERATOR_LIST__ENUMERATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLastComma()
	{
		return (Boolean)eGet(ParserPackage.Literals.ENUMERATOR_LIST__LAST_COMMA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastComma(boolean newLastComma)
	{
		eSet(ParserPackage.Literals.ENUMERATOR_LIST__LAST_COMMA, newLastComma);
	}

} //EnumeratorListImpl
