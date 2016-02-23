/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.*;

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
public class ParserFactoryImpl extends EFactoryImpl implements ParserFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ParserFactory init()
	{
		try
		{
			ParserFactory theParserFactory = (ParserFactory)EPackage.Registry.INSTANCE.getEFactory(ParserPackage.eNS_URI);
			if (theParserFactory != null)
			{
				return theParserFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ParserFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParserFactoryImpl()
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
			case ParserPackage.EXTERNAL_DECLARATION: return (EObject)createExternalDeclaration();
			case ParserPackage.FUNCTION_DEF_HEAD: return (EObject)createFunctionDefHead();
			case ParserPackage.FUNCTION_DEFINITION: return (EObject)createFunctionDefinition();
			case ParserPackage.DECLARATION: return (EObject)createDeclaration();
			case ParserPackage.FUNCTION_DECLARATION_SPECIFIERS: return (EObject)createFunctionDeclarationSpecifiers();
			case ParserPackage.DECLARATION_SPECIFIERS: return (EObject)createDeclarationSpecifiers();
			case ParserPackage.INIT_DECLARATOR_LIST: return (EObject)createInitDeclaratorList();
			case ParserPackage.INIT_DECLARATOR: return (EObject)createInitDeclarator();
			case ParserPackage.STORAGE_CLASS_SPECIFIER: return (EObject)createStorageClassSpecifier();
			case ParserPackage.TYPE_SPECIFIER: return (EObject)createTypeSpecifier();
			case ParserPackage.TYPEDEF_NAME: return (EObject)createTypedefName();
			case ParserPackage.DECLARATION_SPECIFIER: return (EObject)createDeclarationSpecifier();
			case ParserPackage.STRUCT_OR_UNION: return (EObject)createStructOrUnion();
			case ParserPackage.STRUCT_DECLARATION_LIST: return (EObject)createStructDeclarationList();
			case ParserPackage.STRUCT_DECLARATION: return (EObject)createStructDeclaration();
			case ParserPackage.SPECIFIER_QUALIFIER_LIST: return (EObject)createSpecifierQualifierList();
			case ParserPackage.STRUCT_DECLARATOR_LIST: return (EObject)createStructDeclaratorList();
			case ParserPackage.STRUCT_DECLARATOR: return (EObject)createStructDeclarator();
			case ParserPackage.ENUMERATOR_LIST: return (EObject)createEnumeratorList();
			case ParserPackage.ENUMERATOR: return (EObject)createEnumerator();
			case ParserPackage.TYPE_QUALIFIER: return (EObject)createTypeQualifier();
			case ParserPackage.FUNCTION_SPECIFIER: return (EObject)createFunctionSpecifier();
			case ParserPackage.DECLARATOR: return (EObject)createDeclarator();
			case ParserPackage.DIRECT_DECLARATOR: return (EObject)createDirectDeclarator();
			case ParserPackage.DECLARATOR_SUFFIX: return (EObject)createDeclaratorSuffix();
			case ParserPackage.DIRECT_DECLARATOR_LAST_SUFFIX: return (EObject)createDirectDeclaratorLastSuffix();
			case ParserPackage.GCC_DECLARATOR_EXTENSION: return (EObject)createGccDeclaratorExtension();
			case ParserPackage.GCC_ATTRIBUTE_SPECIFIER: return (EObject)createGccAttributeSpecifier();
			case ParserPackage.GCC_ATTRIBUTE_LIST: return (EObject)createGccAttributeList();
			case ParserPackage.GCC_ATTRIBUTE: return (EObject)createGccAttribute();
			case ParserPackage.POINTER: return (EObject)createPointer();
			case ParserPackage.TYPE_QUALIFIER_LIST: return (EObject)createTypeQualifierList();
			case ParserPackage.PARAMETER_TYPE_LIST: return (EObject)createParameterTypeList();
			case ParserPackage.PARAMETER_LIST: return (EObject)createParameterList();
			case ParserPackage.PARAMETER_DECLARATION: return (EObject)createParameterDeclaration();
			case ParserPackage.IDENTIFIER_LIST: return (EObject)createIdentifierList();
			case ParserPackage.MY_IDENTIFIER: return (EObject)createMyIdentifier();
			case ParserPackage.TYPE_NAME: return (EObject)createTypeName();
			case ParserPackage.ABSTRACT_DECLARATOR: return (EObject)createAbstractDeclarator();
			case ParserPackage.DIRECT_ABSTRACT_DECLARATOR: return (EObject)createDirectAbstractDeclarator();
			case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX: return (EObject)createAbstractDeclaratorSuffix();
			case ParserPackage.INITIALIZER: return (EObject)createInitializer();
			case ParserPackage.INITIALIZER_LIST: return (EObject)createInitializerList();
			case ParserPackage.INIT: return (EObject)createInit();
			case ParserPackage.BLOCK_LIST: return (EObject)createBlockList();
			case ParserPackage.STATEMENT: return (EObject)createStatement();
			case ParserPackage.ASM_LINE: return (EObject)createAsmLine();
			case ParserPackage.ASM_SYMBOLIC_NAME: return (EObject)createAsmSymbolicName();
			case ParserPackage.ASM_LINE_WITH_COLON: return (EObject)createAsmLineWithColon();
			case ParserPackage.ASM_LINE_WITHOUT_COLON: return (EObject)createAsmLineWithoutColon();
			case ParserPackage.DESIGNATION: return (EObject)createDesignation();
			case ParserPackage.DESIGNATOR_LIST: return (EObject)createDesignatorList();
			case ParserPackage.DESIGNATOR: return (EObject)createDesignator();
			case ParserPackage.EXPRESSION: return (EObject)createExpression();
			case ParserPackage.POSTFIX_EXPRESSION_SUFFIX: return (EObject)createPostfixExpressionSuffix();
			case ParserPackage.ARGUMENT_EXPRESSION_LIST: return (EObject)createArgumentExpressionList();
			case ParserPackage.PARSER: return (EObject)createParser();
			case ParserPackage.STRUCT_OR_UNION_SPECIFIER: return (EObject)createStructOrUnionSpecifier();
			case ParserPackage.ENUM_SPECIFIER: return (EObject)createEnumSpecifier();
			case ParserPackage.LABELED_STATEMENT: return (EObject)createLabeledStatement();
			case ParserPackage.COMPOUND_STATEMENT: return (EObject)createCompoundStatement();
			case ParserPackage.BODY_STATEMENT: return (EObject)createBodyStatement();
			case ParserPackage.EXPRESSION_STATEMENT: return (EObject)createExpressionStatement();
			case ParserPackage.SELECTION_STATEMENT: return (EObject)createSelectionStatement();
			case ParserPackage.ITERATION_STATEMENT: return (EObject)createIterationStatement();
			case ParserPackage.JUMP_STATEMENT: return (EObject)createJumpStatement();
			case ParserPackage.ASM_STATEMENT: return (EObject)createAsmStatement();
			case ParserPackage.ASSIGNMENT_EXPRESSION: return (EObject)createAssignmentExpression();
			case ParserPackage.CONDITIONAL_EXPRESSION: return (EObject)createConditionalExpression();
			case ParserPackage.LOGICAL_OR_EXPRESSION: return (EObject)createLogicalOrExpression();
			case ParserPackage.LOGICAL_AND_EXPRESSION: return (EObject)createLogicalAndExpression();
			case ParserPackage.INCLUSIVE_OR_EXPRESSION: return (EObject)createInclusiveOrExpression();
			case ParserPackage.EXCLUSIVE_OR_EXPRESSION: return (EObject)createExclusiveOrExpression();
			case ParserPackage.AND_EXPRESSION: return (EObject)createAndExpression();
			case ParserPackage.EQUALITY_EXPRESSION: return (EObject)createEqualityExpression();
			case ParserPackage.RELATIONAL_EXPRESSION: return (EObject)createRelationalExpression();
			case ParserPackage.SHIFT_EXPRESSION: return (EObject)createShiftExpression();
			case ParserPackage.ADDITIVE_EXPRESSION: return (EObject)createAdditiveExpression();
			case ParserPackage.MULTIPLICATIVE_EXPRESSION: return (EObject)createMultiplicativeExpression();
			case ParserPackage.CAST_EXPRESSION: return (EObject)createCastExpression();
			case ParserPackage.UNARY_EXPRESSION: return (EObject)createUnaryExpression();
			case ParserPackage.POSTFIX_EXPRESSION: return (EObject)createPostfixExpression();
			case ParserPackage.POSTFIX_EXPRESSION_SUFFIX_ARRAY: return (EObject)createPostfixExpressionSuffixArray();
			case ParserPackage.POSTFIX_EXPRESSION_SUFFIX_ARGUMENT: return (EObject)createPostfixExpressionSuffixArgument();
			case ParserPackage.POSTFIX_EXPRESSION_SUFFIX_DOT: return (EObject)createPostfixExpressionSuffixDot();
			case ParserPackage.POSTFIX_EXPRESSION_SUFFIX_ARROW: return (EObject)createPostfixExpressionSuffixArrow();
			case ParserPackage.POSTFIX_EXPRESSION_SUFFIX_PLUS_PLUS: return (EObject)createPostfixExpressionSuffixPlusPlus();
			case ParserPackage.POSTFIX_EXPRESSION_SUFFIX_MINUS_MINUS: return (EObject)createPostfixExpressionSuffixMinusMinus();
			case ParserPackage.PRIMARY_EXPRESSION: return (EObject)createPrimaryExpression();
			case ParserPackage.CONSTANT_EXPRESSION: return (EObject)createConstantExpression();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalDeclaration createExternalDeclaration()
	{
		ExternalDeclarationImpl externalDeclaration = new ExternalDeclarationImpl();
		return externalDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDefHead createFunctionDefHead()
	{
		FunctionDefHeadImpl functionDefHead = new FunctionDefHeadImpl();
		return functionDefHead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDefinition createFunctionDefinition()
	{
		FunctionDefinitionImpl functionDefinition = new FunctionDefinitionImpl();
		return functionDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Declaration createDeclaration()
	{
		DeclarationImpl declaration = new DeclarationImpl();
		return declaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDeclarationSpecifiers createFunctionDeclarationSpecifiers()
	{
		FunctionDeclarationSpecifiersImpl functionDeclarationSpecifiers = new FunctionDeclarationSpecifiersImpl();
		return functionDeclarationSpecifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclarationSpecifiers createDeclarationSpecifiers()
	{
		DeclarationSpecifiersImpl declarationSpecifiers = new DeclarationSpecifiersImpl();
		return declarationSpecifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitDeclaratorList createInitDeclaratorList()
	{
		InitDeclaratorListImpl initDeclaratorList = new InitDeclaratorListImpl();
		return initDeclaratorList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitDeclarator createInitDeclarator()
	{
		InitDeclaratorImpl initDeclarator = new InitDeclaratorImpl();
		return initDeclarator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StorageClassSpecifier createStorageClassSpecifier()
	{
		StorageClassSpecifierImpl storageClassSpecifier = new StorageClassSpecifierImpl();
		return storageClassSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeSpecifier createTypeSpecifier()
	{
		TypeSpecifierImpl typeSpecifier = new TypeSpecifierImpl();
		return typeSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedefName createTypedefName()
	{
		TypedefNameImpl typedefName = new TypedefNameImpl();
		return typedefName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclarationSpecifier createDeclarationSpecifier()
	{
		DeclarationSpecifierImpl declarationSpecifier = new DeclarationSpecifierImpl();
		return declarationSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructOrUnion createStructOrUnion()
	{
		StructOrUnionImpl structOrUnion = new StructOrUnionImpl();
		return structOrUnion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructDeclarationList createStructDeclarationList()
	{
		StructDeclarationListImpl structDeclarationList = new StructDeclarationListImpl();
		return structDeclarationList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructDeclaration createStructDeclaration()
	{
		StructDeclarationImpl structDeclaration = new StructDeclarationImpl();
		return structDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecifierQualifierList createSpecifierQualifierList()
	{
		SpecifierQualifierListImpl specifierQualifierList = new SpecifierQualifierListImpl();
		return specifierQualifierList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructDeclaratorList createStructDeclaratorList()
	{
		StructDeclaratorListImpl structDeclaratorList = new StructDeclaratorListImpl();
		return structDeclaratorList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructDeclarator createStructDeclarator()
	{
		StructDeclaratorImpl structDeclarator = new StructDeclaratorImpl();
		return structDeclarator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumeratorList createEnumeratorList()
	{
		EnumeratorListImpl enumeratorList = new EnumeratorListImpl();
		return enumeratorList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enumerator createEnumerator()
	{
		EnumeratorImpl enumerator = new EnumeratorImpl();
		return enumerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeQualifier createTypeQualifier()
	{
		TypeQualifierImpl typeQualifier = new TypeQualifierImpl();
		return typeQualifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionSpecifier createFunctionSpecifier()
	{
		FunctionSpecifierImpl functionSpecifier = new FunctionSpecifierImpl();
		return functionSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Declarator createDeclarator()
	{
		DeclaratorImpl declarator = new DeclaratorImpl();
		return declarator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectDeclarator createDirectDeclarator()
	{
		DirectDeclaratorImpl directDeclarator = new DirectDeclaratorImpl();
		return directDeclarator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclaratorSuffix createDeclaratorSuffix()
	{
		DeclaratorSuffixImpl declaratorSuffix = new DeclaratorSuffixImpl();
		return declaratorSuffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectDeclaratorLastSuffix createDirectDeclaratorLastSuffix()
	{
		DirectDeclaratorLastSuffixImpl directDeclaratorLastSuffix = new DirectDeclaratorLastSuffixImpl();
		return directDeclaratorLastSuffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GccDeclaratorExtension createGccDeclaratorExtension()
	{
		GccDeclaratorExtensionImpl gccDeclaratorExtension = new GccDeclaratorExtensionImpl();
		return gccDeclaratorExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GccAttributeSpecifier createGccAttributeSpecifier()
	{
		GccAttributeSpecifierImpl gccAttributeSpecifier = new GccAttributeSpecifierImpl();
		return gccAttributeSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GccAttributeList createGccAttributeList()
	{
		GccAttributeListImpl gccAttributeList = new GccAttributeListImpl();
		return gccAttributeList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GccAttribute createGccAttribute()
	{
		GccAttributeImpl gccAttribute = new GccAttributeImpl();
		return gccAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pointer createPointer()
	{
		PointerImpl pointer = new PointerImpl();
		return pointer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeQualifierList createTypeQualifierList()
	{
		TypeQualifierListImpl typeQualifierList = new TypeQualifierListImpl();
		return typeQualifierList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterTypeList createParameterTypeList()
	{
		ParameterTypeListImpl parameterTypeList = new ParameterTypeListImpl();
		return parameterTypeList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterList createParameterList()
	{
		ParameterListImpl parameterList = new ParameterListImpl();
		return parameterList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterDeclaration createParameterDeclaration()
	{
		ParameterDeclarationImpl parameterDeclaration = new ParameterDeclarationImpl();
		return parameterDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierList createIdentifierList()
	{
		IdentifierListImpl identifierList = new IdentifierListImpl();
		return identifierList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MyIdentifier createMyIdentifier()
	{
		MyIdentifierImpl myIdentifier = new MyIdentifierImpl();
		return myIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeName createTypeName()
	{
		TypeNameImpl typeName = new TypeNameImpl();
		return typeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractDeclarator createAbstractDeclarator()
	{
		AbstractDeclaratorImpl abstractDeclarator = new AbstractDeclaratorImpl();
		return abstractDeclarator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectAbstractDeclarator createDirectAbstractDeclarator()
	{
		DirectAbstractDeclaratorImpl directAbstractDeclarator = new DirectAbstractDeclaratorImpl();
		return directAbstractDeclarator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractDeclaratorSuffix createAbstractDeclaratorSuffix()
	{
		AbstractDeclaratorSuffixImpl abstractDeclaratorSuffix = new AbstractDeclaratorSuffixImpl();
		return abstractDeclaratorSuffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Initializer createInitializer()
	{
		InitializerImpl initializer = new InitializerImpl();
		return initializer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitializerList createInitializerList()
	{
		InitializerListImpl initializerList = new InitializerListImpl();
		return initializerList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Init createInit()
	{
		InitImpl init = new InitImpl();
		return init;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockList createBlockList()
	{
		BlockListImpl blockList = new BlockListImpl();
		return blockList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statement createStatement()
	{
		StatementImpl statement = new StatementImpl();
		return statement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsmLine createAsmLine()
	{
		AsmLineImpl asmLine = new AsmLineImpl();
		return asmLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsmSymbolicName createAsmSymbolicName()
	{
		AsmSymbolicNameImpl asmSymbolicName = new AsmSymbolicNameImpl();
		return asmSymbolicName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsmLineWithColon createAsmLineWithColon()
	{
		AsmLineWithColonImpl asmLineWithColon = new AsmLineWithColonImpl();
		return asmLineWithColon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsmLineWithoutColon createAsmLineWithoutColon()
	{
		AsmLineWithoutColonImpl asmLineWithoutColon = new AsmLineWithoutColonImpl();
		return asmLineWithoutColon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Designation createDesignation()
	{
		DesignationImpl designation = new DesignationImpl();
		return designation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DesignatorList createDesignatorList()
	{
		DesignatorListImpl designatorList = new DesignatorListImpl();
		return designatorList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Designator createDesignator()
	{
		DesignatorImpl designator = new DesignatorImpl();
		return designator;
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
	public StructOrUnionSpecifier createStructOrUnionSpecifier()
	{
		StructOrUnionSpecifierImpl structOrUnionSpecifier = new StructOrUnionSpecifierImpl();
		return structOrUnionSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumSpecifier createEnumSpecifier()
	{
		EnumSpecifierImpl enumSpecifier = new EnumSpecifierImpl();
		return enumSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabeledStatement createLabeledStatement()
	{
		LabeledStatementImpl labeledStatement = new LabeledStatementImpl();
		return labeledStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompoundStatement createCompoundStatement()
	{
		CompoundStatementImpl compoundStatement = new CompoundStatementImpl();
		return compoundStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BodyStatement createBodyStatement()
	{
		BodyStatementImpl bodyStatement = new BodyStatementImpl();
		return bodyStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionStatement createExpressionStatement()
	{
		ExpressionStatementImpl expressionStatement = new ExpressionStatementImpl();
		return expressionStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectionStatement createSelectionStatement()
	{
		SelectionStatementImpl selectionStatement = new SelectionStatementImpl();
		return selectionStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterationStatement createIterationStatement()
	{
		IterationStatementImpl iterationStatement = new IterationStatementImpl();
		return iterationStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JumpStatement createJumpStatement()
	{
		JumpStatementImpl jumpStatement = new JumpStatementImpl();
		return jumpStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsmStatement createAsmStatement()
	{
		AsmStatementImpl asmStatement = new AsmStatementImpl();
		return asmStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignmentExpression createAssignmentExpression()
	{
		AssignmentExpressionImpl assignmentExpression = new AssignmentExpressionImpl();
		return assignmentExpression;
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
	public PostfixExpressionSuffixArray createPostfixExpressionSuffixArray()
	{
		PostfixExpressionSuffixArrayImpl postfixExpressionSuffixArray = new PostfixExpressionSuffixArrayImpl();
		return postfixExpressionSuffixArray;
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
	public PostfixExpressionSuffixDot createPostfixExpressionSuffixDot()
	{
		PostfixExpressionSuffixDotImpl postfixExpressionSuffixDot = new PostfixExpressionSuffixDotImpl();
		return postfixExpressionSuffixDot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostfixExpressionSuffixArrow createPostfixExpressionSuffixArrow()
	{
		PostfixExpressionSuffixArrowImpl postfixExpressionSuffixArrow = new PostfixExpressionSuffixArrowImpl();
		return postfixExpressionSuffixArrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostfixExpressionSuffixPlusPlus createPostfixExpressionSuffixPlusPlus()
	{
		PostfixExpressionSuffixPlusPlusImpl postfixExpressionSuffixPlusPlus = new PostfixExpressionSuffixPlusPlusImpl();
		return postfixExpressionSuffixPlusPlus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostfixExpressionSuffixMinusMinus createPostfixExpressionSuffixMinusMinus()
	{
		PostfixExpressionSuffixMinusMinusImpl postfixExpressionSuffixMinusMinus = new PostfixExpressionSuffixMinusMinusImpl();
		return postfixExpressionSuffixMinusMinus;
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
	public ParserPackage getParserPackage()
	{
		return (ParserPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ParserPackage getPackage()
	{
		return ParserPackage.eINSTANCE;
	}

} //ParserFactoryImpl
