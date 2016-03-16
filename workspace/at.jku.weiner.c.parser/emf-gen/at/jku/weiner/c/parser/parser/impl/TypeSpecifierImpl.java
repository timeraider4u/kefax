/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.DeclarationSpecifier;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.GccAttributeSpecifier;
import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.TypeName;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#getName <em>Name</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#getExtType <em>Ext Type</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#getSpecifier <em>Specifier</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#getType <em>Type</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#getTypeOf <em>Type Of</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#getConstExpr <em>Const Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#isBuiltinChooseExpr <em>Builtin Choose Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#getExpr1 <em>Expr1</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#getExpr2 <em>Expr2</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#getGccAttributeSpecifier <em>Gcc Attribute Specifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeSpecifierImpl extends PersistentEObjectImpl implements TypeSpecifier
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeSpecifierImpl()
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
		return ParserPackage.Literals.TYPE_SPECIFIER;
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
		return (String)eGet(ParserPackage.Literals.TYPE_SPECIFIER__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName)
	{
		eSet(ParserPackage.Literals.TYPE_SPECIFIER__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExtType()
	{
		return (String)eGet(ParserPackage.Literals.TYPE_SPECIFIER__EXT_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtType(String newExtType)
	{
		eSet(ParserPackage.Literals.TYPE_SPECIFIER__EXT_TYPE, newExtType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclarationSpecifier getSpecifier()
	{
		return (DeclarationSpecifier)eGet(ParserPackage.Literals.TYPE_SPECIFIER__SPECIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecifier(DeclarationSpecifier newSpecifier)
	{
		eSet(ParserPackage.Literals.TYPE_SPECIFIER__SPECIFIER, newSpecifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedefName getType()
	{
		return (TypedefName)eGet(ParserPackage.Literals.TYPE_SPECIFIER__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(TypedefName newType)
	{
		eSet(ParserPackage.Literals.TYPE_SPECIFIER__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTypeOf()
	{
		return (String)eGet(ParserPackage.Literals.TYPE_SPECIFIER__TYPE_OF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeOf(String newTypeOf)
	{
		eSet(ParserPackage.Literals.TYPE_SPECIFIER__TYPE_OF, newTypeOf);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeName getTypeName()
	{
		return (TypeName)eGet(ParserPackage.Literals.TYPE_SPECIFIER__TYPE_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeName(TypeName newTypeName)
	{
		eSet(ParserPackage.Literals.TYPE_SPECIFIER__TYPE_NAME, newTypeName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getConstExpr()
	{
		return (Expression)eGet(ParserPackage.Literals.TYPE_SPECIFIER__CONST_EXPR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstExpr(Expression newConstExpr)
	{
		eSet(ParserPackage.Literals.TYPE_SPECIFIER__CONST_EXPR, newConstExpr);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBuiltinChooseExpr()
	{
		return (Boolean)eGet(ParserPackage.Literals.TYPE_SPECIFIER__BUILTIN_CHOOSE_EXPR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBuiltinChooseExpr(boolean newBuiltinChooseExpr)
	{
		eSet(ParserPackage.Literals.TYPE_SPECIFIER__BUILTIN_CHOOSE_EXPR, newBuiltinChooseExpr);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpr1()
	{
		return (Expression)eGet(ParserPackage.Literals.TYPE_SPECIFIER__EXPR1, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpr1(Expression newExpr1)
	{
		eSet(ParserPackage.Literals.TYPE_SPECIFIER__EXPR1, newExpr1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpr2()
	{
		return (Expression)eGet(ParserPackage.Literals.TYPE_SPECIFIER__EXPR2, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpr2(Expression newExpr2)
	{
		eSet(ParserPackage.Literals.TYPE_SPECIFIER__EXPR2, newExpr2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GccAttributeSpecifier getGccAttributeSpecifier()
	{
		return (GccAttributeSpecifier)eGet(ParserPackage.Literals.TYPE_SPECIFIER__GCC_ATTRIBUTE_SPECIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGccAttributeSpecifier(GccAttributeSpecifier newGccAttributeSpecifier)
	{
		eSet(ParserPackage.Literals.TYPE_SPECIFIER__GCC_ATTRIBUTE_SPECIFIER, newGccAttributeSpecifier);
	}

} //TypeSpecifierImpl
