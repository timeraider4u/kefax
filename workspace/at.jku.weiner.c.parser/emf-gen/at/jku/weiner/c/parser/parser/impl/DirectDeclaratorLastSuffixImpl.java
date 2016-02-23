/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.parser.parser.IdentifierList;
import at.jku.weiner.c.parser.parser.ParameterTypeList;
import at.jku.weiner.c.parser.parser.ParserPackage;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Direct Declarator Last Suffix</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DirectDeclaratorLastSuffixImpl#getParameterTypeList <em>Parameter Type List</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DirectDeclaratorLastSuffixImpl#getIdentifierList <em>Identifier List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DirectDeclaratorLastSuffixImpl extends PersistentEObjectImpl implements DirectDeclaratorLastSuffix
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DirectDeclaratorLastSuffixImpl()
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
		return ParserPackage.Literals.DIRECT_DECLARATOR_LAST_SUFFIX;
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
	public EList<ParameterTypeList> getParameterTypeList()
	{
		return (EList<ParameterTypeList>)eGet(ParserPackage.Literals.DIRECT_DECLARATOR_LAST_SUFFIX__PARAMETER_TYPE_LIST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierList getIdentifierList()
	{
		return (IdentifierList)eGet(ParserPackage.Literals.DIRECT_DECLARATOR_LAST_SUFFIX__IDENTIFIER_LIST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifierList(IdentifierList newIdentifierList)
	{
		eSet(ParserPackage.Literals.DIRECT_DECLARATOR_LAST_SUFFIX__IDENTIFIER_LIST, newIdentifierList);
	}

} //DirectDeclaratorLastSuffixImpl
