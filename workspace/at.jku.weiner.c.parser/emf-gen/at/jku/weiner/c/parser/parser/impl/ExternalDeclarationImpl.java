/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.FunctionDefHead;
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.ParserPackage;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.ExternalDeclarationImpl#getFunctiondefHead <em>Functiondef Head</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.ExternalDeclarationImpl#getFunctionDefinition <em>Function Definition</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.ExternalDeclarationImpl#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.ExternalDeclarationImpl#getSemi <em>Semi</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalDeclarationImpl extends PersistentEObjectImpl implements ExternalDeclaration
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalDeclarationImpl()
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
		return ParserPackage.Literals.EXTERNAL_DECLARATION;
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
	public FunctionDefHead getFunctiondefHead()
	{
		return (FunctionDefHead)eGet(ParserPackage.Literals.EXTERNAL_DECLARATION__FUNCTIONDEF_HEAD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctiondefHead(FunctionDefHead newFunctiondefHead)
	{
		eSet(ParserPackage.Literals.EXTERNAL_DECLARATION__FUNCTIONDEF_HEAD, newFunctiondefHead);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDefinition getFunctionDefinition()
	{
		return (FunctionDefinition)eGet(ParserPackage.Literals.EXTERNAL_DECLARATION__FUNCTION_DEFINITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctionDefinition(FunctionDefinition newFunctionDefinition)
	{
		eSet(ParserPackage.Literals.EXTERNAL_DECLARATION__FUNCTION_DEFINITION, newFunctionDefinition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Declaration getDeclaration()
	{
		return (Declaration)eGet(ParserPackage.Literals.EXTERNAL_DECLARATION__DECLARATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaration(Declaration newDeclaration)
	{
		eSet(ParserPackage.Literals.EXTERNAL_DECLARATION__DECLARATION, newDeclaration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSemi()
	{
		return (String)eGet(ParserPackage.Literals.EXTERNAL_DECLARATION__SEMI, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemi(String newSemi)
	{
		eSet(ParserPackage.Literals.EXTERNAL_DECLARATION__SEMI, newSemi);
	}

} //ExternalDeclarationImpl
