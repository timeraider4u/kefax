/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.AbstractDeclarator;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.ParserPackage;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.ParameterDeclarationImpl#getDeclSpecifiers <em>Decl Specifiers</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.ParameterDeclarationImpl#getDeclarator <em>Declarator</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.ParameterDeclarationImpl#getAbstractDeclator <em>Abstract Declator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParameterDeclarationImpl extends PersistentEObjectImpl implements ParameterDeclaration
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterDeclarationImpl()
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
		return ParserPackage.Literals.PARAMETER_DECLARATION;
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
	public DeclarationSpecifiers getDeclSpecifiers()
	{
		return (DeclarationSpecifiers)eGet(ParserPackage.Literals.PARAMETER_DECLARATION__DECL_SPECIFIERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclSpecifiers(DeclarationSpecifiers newDeclSpecifiers)
	{
		eSet(ParserPackage.Literals.PARAMETER_DECLARATION__DECL_SPECIFIERS, newDeclSpecifiers);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Declarator getDeclarator()
	{
		return (Declarator)eGet(ParserPackage.Literals.PARAMETER_DECLARATION__DECLARATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclarator(Declarator newDeclarator)
	{
		eSet(ParserPackage.Literals.PARAMETER_DECLARATION__DECLARATOR, newDeclarator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractDeclarator getAbstractDeclator()
	{
		return (AbstractDeclarator)eGet(ParserPackage.Literals.PARAMETER_DECLARATION__ABSTRACT_DECLATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstractDeclator(AbstractDeclarator newAbstractDeclator)
	{
		eSet(ParserPackage.Literals.PARAMETER_DECLARATION__ABSTRACT_DECLATOR, newAbstractDeclator);
	}

} //ParameterDeclarationImpl
