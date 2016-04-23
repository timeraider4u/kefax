/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.ParserPackage;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declarator Suffix</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DeclaratorSuffixImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DeclaratorSuffixImpl#getLastSuffix <em>Last Suffix</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeclaratorSuffixImpl extends PersistentEObjectImpl implements DeclaratorSuffix
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeclaratorSuffixImpl()
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
		return ParserPackage.Literals.DECLARATOR_SUFFIX;
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
	public Expression getExpr()
	{
		return (Expression)eGet(ParserPackage.Literals.DECLARATOR_SUFFIX__EXPR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpr(Expression newExpr)
	{
		eSet(ParserPackage.Literals.DECLARATOR_SUFFIX__EXPR, newExpr);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectDeclaratorLastSuffix getLastSuffix()
	{
		return (DirectDeclaratorLastSuffix)eGet(ParserPackage.Literals.DECLARATOR_SUFFIX__LAST_SUFFIX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastSuffix(DirectDeclaratorLastSuffix newLastSuffix)
	{
		eSet(ParserPackage.Literals.DECLARATOR_SUFFIX__LAST_SUFFIX, newLastSuffix);
	}

} //DeclaratorSuffixImpl
