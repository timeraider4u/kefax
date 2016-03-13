/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.GccAttributeSpecifier;
import at.jku.weiner.c.parser.parser.GccDeclaratorExtension;
import at.jku.weiner.c.parser.parser.ParserPackage;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gcc Declarator Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.GccDeclaratorExtensionImpl#getAsm <em>Asm</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.GccDeclaratorExtensionImpl#getString <em>String</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.GccDeclaratorExtensionImpl#getGccAttributeSpecifier <em>Gcc Attribute Specifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GccDeclaratorExtensionImpl extends PersistentEObjectImpl implements GccDeclaratorExtension
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GccDeclaratorExtensionImpl()
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
		return ParserPackage.Literals.GCC_DECLARATOR_EXTENSION;
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
	public String getAsm()
	{
		return (String)eGet(ParserPackage.Literals.GCC_DECLARATOR_EXTENSION__ASM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAsm(String newAsm)
	{
		eSet(ParserPackage.Literals.GCC_DECLARATOR_EXTENSION__ASM, newAsm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getString()
	{
		return (EList<String>)eGet(ParserPackage.Literals.GCC_DECLARATOR_EXTENSION__STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GccAttributeSpecifier getGccAttributeSpecifier()
	{
		return (GccAttributeSpecifier)eGet(ParserPackage.Literals.GCC_DECLARATOR_EXTENSION__GCC_ATTRIBUTE_SPECIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGccAttributeSpecifier(GccAttributeSpecifier newGccAttributeSpecifier)
	{
		eSet(ParserPackage.Literals.GCC_DECLARATOR_EXTENSION__GCC_ATTRIBUTE_SPECIFIER, newGccAttributeSpecifier);
	}

} //GccDeclaratorExtensionImpl
