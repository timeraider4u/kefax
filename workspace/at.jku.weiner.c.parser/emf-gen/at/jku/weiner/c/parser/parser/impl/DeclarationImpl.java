/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.ParserPackage;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DeclarationImpl#getSpecifiers <em>Specifiers</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DeclarationImpl#getInitDeclaratorList <em>Init Declarator List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeclarationImpl extends PersistentEObjectImpl implements Declaration
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeclarationImpl()
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
		return ParserPackage.Literals.DECLARATION;
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
	public DeclarationSpecifiers getSpecifiers()
	{
		return (DeclarationSpecifiers)eGet(ParserPackage.Literals.DECLARATION__SPECIFIERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecifiers(DeclarationSpecifiers newSpecifiers)
	{
		eSet(ParserPackage.Literals.DECLARATION__SPECIFIERS, newSpecifiers);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<InitDeclaratorList> getInitDeclaratorList()
	{
		return (EList<InitDeclaratorList>)eGet(ParserPackage.Literals.DECLARATION__INIT_DECLARATOR_LIST, true);
	}

} //DeclarationImpl
