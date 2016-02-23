/**
 */
package at.jku.weiner.c.common.common.impl;

import at.jku.weiner.c.common.common.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommonFactoryImpl extends EFactoryImpl implements CommonFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CommonFactory init()
	{
		try
		{
			CommonFactory theCommonFactory = (CommonFactory)EPackage.Registry.INSTANCE.getEFactory(CommonPackage.eNS_URI);
			if (theCommonFactory != null)
			{
				return theCommonFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CommonFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case CommonPackage.MODEL: return (EObject)createModel();
			case CommonPackage.TRANSLATION_UNIT: return (EObject)createTranslationUnit();
			case CommonPackage.PREPROCESS: return (EObject)createPreprocess();
			case CommonPackage.PARSER: return (EObject)createParser();
			case CommonPackage.EXPRESSION: return (EObject)createExpression();
			case CommonPackage.POSTFIX_EXPRESSION_SUFFIX: return (EObject)createPostfixExpressionSuffix();
			case CommonPackage.ARGUMENT_EXPRESSION_LIST: return (EObject)createArgumentExpressionList();
			case CommonPackage.CONSTANT2: return (EObject)createConstant2();
			case CommonPackage.CONSTANT_EXPRESSION: return (EObject)createConstantExpression();
			case CommonPackage.CONDITIONAL_EXPRESSION: return (EObject)createConditionalExpression();
			case CommonPackage.LOGICAL_OR_EXPRESSION: return (EObject)createLogicalOrExpression();
			case CommonPackage.LOGICAL_AND_EXPRESSION: return (EObject)createLogicalAndExpression();
			case CommonPackage.INCLUSIVE_OR_EXPRESSION: return (EObject)createInclusiveOrExpression();
			case CommonPackage.EXCLUSIVE_OR_EXPRESSION: return (EObject)createExclusiveOrExpression();
			case CommonPackage.AND_EXPRESSION: return (EObject)createAndExpression();
			case CommonPackage.EQUALITY_EXPRESSION: return (EObject)createEqualityExpression();
			case CommonPackage.RELATIONAL_EXPRESSION: return (EObject)createRelationalExpression();
			case CommonPackage.SHIFT_EXPRESSION: return (EObject)createShiftExpression();
			case CommonPackage.ADDITIVE_EXPRESSION: return (EObject)createAdditiveExpression();
			case CommonPackage.MULTIPLICATIVE_EXPRESSION: return (EObject)createMultiplicativeExpression();
			case CommonPackage.CAST_EXPRESSION: return (EObject)createCastExpression();
			case CommonPackage.UNARY_EXPRESSION: return (EObject)createUnaryExpression();
			case CommonPackage.POSTFIX_EXPRESSION: return (EObject)createPostfixExpression();
			case CommonPackage.POSTFIX_EXPRESSION_SUFFIX_ARGUMENT: return (EObject)createPostfixExpressionSuffixArgument();
			case CommonPackage.PRIMARY_EXPRESSION: return (EObject)createPrimaryExpression();
			case CommonPackage.CONSTANT1: return (EObject)createConstant1();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model createModel()
	{
		ModelImpl model = new ModelImpl();
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TranslationUnit createTranslationUnit()
	{
		TranslationUnitImpl translationUnit = new TranslationUnitImpl();
		return translationUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Preprocess createPreprocess()
	{
		PreprocessImpl preprocess = new PreprocessImpl();
		return preprocess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parser createParser()
	{
		ParserImpl parser = new ParserImpl();
		return parser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression createExpression()
	{
		ExpressionImpl expression = new ExpressionImpl();
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostfixExpressionSuffix createPostfixExpressionSuffix()
	{
		PostfixExpressionSuffixImpl postfixExpressionSuffix = new PostfixExpressionSuffixImpl();
		return postfixExpressionSuffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArgumentExpressionList createArgumentExpressionList()
	{
		ArgumentExpressionListImpl argumentExpressionList = new ArgumentExpressionListImpl();
		return argumentExpressionList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constant2 createConstant2()
	{
		Constant2Impl constant2 = new Constant2Impl();
		return constant2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstantExpression createConstantExpression()
	{
		ConstantExpressionImpl constantExpression = new ConstantExpressionImpl();
		return constantExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalExpression createConditionalExpression()
	{
		ConditionalExpressionImpl conditionalExpression = new ConditionalExpressionImpl();
		return conditionalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalOrExpression createLogicalOrExpression()
	{
		LogicalOrExpressionImpl logicalOrExpression = new LogicalOrExpressionImpl();
		return logicalOrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalAndExpression createLogicalAndExpression()
	{
		LogicalAndExpressionImpl logicalAndExpression = new LogicalAndExpressionImpl();
		return logicalAndExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InclusiveOrExpression createInclusiveOrExpression()
	{
		InclusiveOrExpressionImpl inclusiveOrExpression = new InclusiveOrExpressionImpl();
		return inclusiveOrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExclusiveOrExpression createExclusiveOrExpression()
	{
		ExclusiveOrExpressionImpl exclusiveOrExpression = new ExclusiveOrExpressionImpl();
		return exclusiveOrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AndExpression createAndExpression()
	{
		AndExpressionImpl andExpression = new AndExpressionImpl();
		return andExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EqualityExpression createEqualityExpression()
	{
		EqualityExpressionImpl equalityExpression = new EqualityExpressionImpl();
		return equalityExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalExpression createRelationalExpression()
	{
		RelationalExpressionImpl relationalExpression = new RelationalExpressionImpl();
		return relationalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShiftExpression createShiftExpression()
	{
		ShiftExpressionImpl shiftExpression = new ShiftExpressionImpl();
		return shiftExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdditiveExpression createAdditiveExpression()
	{
		AdditiveExpressionImpl additiveExpression = new AdditiveExpressionImpl();
		return additiveExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicativeExpression createMultiplicativeExpression()
	{
		MultiplicativeExpressionImpl multiplicativeExpression = new MultiplicativeExpressionImpl();
		return multiplicativeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CastExpression createCastExpression()
	{
		CastExpressionImpl castExpression = new CastExpressionImpl();
		return castExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryExpression createUnaryExpression()
	{
		UnaryExpressionImpl unaryExpression = new UnaryExpressionImpl();
		return unaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostfixExpression createPostfixExpression()
	{
		PostfixExpressionImpl postfixExpression = new PostfixExpressionImpl();
		return postfixExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostfixExpressionSuffixArgument createPostfixExpressionSuffixArgument()
	{
		PostfixExpressionSuffixArgumentImpl postfixExpressionSuffixArgument = new PostfixExpressionSuffixArgumentImpl();
		return postfixExpressionSuffixArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryExpression createPrimaryExpression()
	{
		PrimaryExpressionImpl primaryExpression = new PrimaryExpressionImpl();
		return primaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constant1 createConstant1()
	{
		Constant1Impl constant1 = new Constant1Impl();
		return constant1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonPackage getCommonPackage()
	{
		return (CommonPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CommonPackage getPackage()
	{
		return CommonPackage.eINSTANCE;
	}

} //CommonFactoryImpl
