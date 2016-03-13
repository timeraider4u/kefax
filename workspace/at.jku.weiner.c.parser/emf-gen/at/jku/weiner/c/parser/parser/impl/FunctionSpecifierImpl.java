/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.FunctionSpecifier;
import at.jku.weiner.c.parser.parser.GccAttributeSpecifier;
import at.jku.weiner.c.parser.parser.ParserPackage;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.FunctionSpecifierImpl#getName <em>Name</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.FunctionSpecifierImpl#getGccAttributeSpecifier <em>Gcc Attribute Specifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionSpecifierImpl extends PersistentEObjectImpl implements FunctionSpecifier
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionSpecifierImpl()
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
		return ParserPackage.Literals.FUNCTION_SPECIFIER;
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
	public String getName()
	{
		return (String)eGet(ParserPackage.Literals.FUNCTION_SPECIFIER__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName)
	{
		eSet(ParserPackage.Literals.FUNCTION_SPECIFIER__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GccAttributeSpecifier getGccAttributeSpecifier()
	{
		return (GccAttributeSpecifier)eGet(ParserPackage.Literals.FUNCTION_SPECIFIER__GCC_ATTRIBUTE_SPECIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGccAttributeSpecifier(GccAttributeSpecifier newGccAttributeSpecifier)
	{
		eSet(ParserPackage.Literals.FUNCTION_SPECIFIER__GCC_ATTRIBUTE_SPECIFIER, newGccAttributeSpecifier);
	}

} //FunctionSpecifierImpl
