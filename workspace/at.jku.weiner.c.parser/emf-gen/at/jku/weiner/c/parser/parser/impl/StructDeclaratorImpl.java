/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.StructDeclarator;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Struct Declarator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.StructDeclaratorImpl#getDeclarator <em>Declarator</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.StructDeclaratorImpl#getConstExpr <em>Const Expr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StructDeclaratorImpl extends PersistentEObjectImpl implements StructDeclarator
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructDeclaratorImpl()
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
		return ParserPackage.Literals.STRUCT_DECLARATOR;
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
	public Declarator getDeclarator()
	{
		return (Declarator)eGet(ParserPackage.Literals.STRUCT_DECLARATOR__DECLARATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclarator(Declarator newDeclarator)
	{
		eSet(ParserPackage.Literals.STRUCT_DECLARATOR__DECLARATOR, newDeclarator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Expression> getConstExpr()
	{
		return (EList<Expression>)eGet(ParserPackage.Literals.STRUCT_DECLARATOR__CONST_EXPR, true);
	}

} //StructDeclaratorImpl
