/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.FunctionDefHead;
import at.jku.weiner.c.parser.parser.ParserPackage;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Def Head</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.FunctionDefHeadImpl#getFunDeclSpecifiers <em>Fun Decl Specifiers</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.FunctionDefHeadImpl#getFunDeclarator <em>Fun Declarator</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.FunctionDefHeadImpl#getFunDeclaration <em>Fun Declaration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionDefHeadImpl extends PersistentEObjectImpl implements FunctionDefHead
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionDefHeadImpl()
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
		return ParserPackage.Literals.FUNCTION_DEF_HEAD;
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
	public FunctionDeclarationSpecifiers getFunDeclSpecifiers()
	{
		return (FunctionDeclarationSpecifiers)eGet(ParserPackage.Literals.FUNCTION_DEF_HEAD__FUN_DECL_SPECIFIERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunDeclSpecifiers(FunctionDeclarationSpecifiers newFunDeclSpecifiers)
	{
		eSet(ParserPackage.Literals.FUNCTION_DEF_HEAD__FUN_DECL_SPECIFIERS, newFunDeclSpecifiers);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Declarator getFunDeclarator()
	{
		return (Declarator)eGet(ParserPackage.Literals.FUNCTION_DEF_HEAD__FUN_DECLARATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunDeclarator(Declarator newFunDeclarator)
	{
		eSet(ParserPackage.Literals.FUNCTION_DEF_HEAD__FUN_DECLARATOR, newFunDeclarator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Declaration> getFunDeclaration()
	{
		return (EList<Declaration>)eGet(ParserPackage.Literals.FUNCTION_DEF_HEAD__FUN_DECLARATION, true);
	}

} //FunctionDefHeadImpl
