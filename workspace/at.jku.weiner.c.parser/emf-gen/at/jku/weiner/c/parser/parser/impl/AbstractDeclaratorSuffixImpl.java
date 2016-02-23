/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.AbstractDeclaratorSuffix;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.GccDeclaratorExtension;
import at.jku.weiner.c.parser.parser.ParameterTypeList;
import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.TypeQualifierList;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Declarator Suffix</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AbstractDeclaratorSuffixImpl#getTypeQualifierList <em>Type Qualifier List</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AbstractDeclaratorSuffixImpl#getAssignmentExpr <em>Assignment Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AbstractDeclaratorSuffixImpl#getTypeQualifierListOrig <em>Type Qualifier List Orig</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AbstractDeclaratorSuffixImpl#getParameterTypeList <em>Parameter Type List</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AbstractDeclaratorSuffixImpl#getGccDeclExt <em>Gcc Decl Ext</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbstractDeclaratorSuffixImpl extends PersistentEObjectImpl implements AbstractDeclaratorSuffix
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractDeclaratorSuffixImpl()
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
		return ParserPackage.Literals.ABSTRACT_DECLARATOR_SUFFIX;
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
	public TypeQualifierList getTypeQualifierList()
	{
		return (TypeQualifierList)eGet(ParserPackage.Literals.ABSTRACT_DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeQualifierList(TypeQualifierList newTypeQualifierList)
	{
		eSet(ParserPackage.Literals.ABSTRACT_DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST, newTypeQualifierList);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Expression> getAssignmentExpr()
	{
		return (EList<Expression>)eGet(ParserPackage.Literals.ABSTRACT_DECLARATOR_SUFFIX__ASSIGNMENT_EXPR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeQualifierList getTypeQualifierListOrig()
	{
		return (TypeQualifierList)eGet(ParserPackage.Literals.ABSTRACT_DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST_ORIG, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeQualifierListOrig(TypeQualifierList newTypeQualifierListOrig)
	{
		eSet(ParserPackage.Literals.ABSTRACT_DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST_ORIG, newTypeQualifierListOrig);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterTypeList getParameterTypeList()
	{
		return (ParameterTypeList)eGet(ParserPackage.Literals.ABSTRACT_DECLARATOR_SUFFIX__PARAMETER_TYPE_LIST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterTypeList(ParameterTypeList newParameterTypeList)
	{
		eSet(ParserPackage.Literals.ABSTRACT_DECLARATOR_SUFFIX__PARAMETER_TYPE_LIST, newParameterTypeList);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<GccDeclaratorExtension> getGccDeclExt()
	{
		return (EList<GccDeclaratorExtension>)eGet(ParserPackage.Literals.ABSTRACT_DECLARATOR_SUFFIX__GCC_DECL_EXT, true);
	}

} //AbstractDeclaratorSuffixImpl
