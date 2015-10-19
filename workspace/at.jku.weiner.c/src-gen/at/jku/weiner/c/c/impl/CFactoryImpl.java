/**
 */
package at.jku.weiner.c.c.impl;

import at.jku.weiner.c.c.*;

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
public class CFactoryImpl extends EFactoryImpl implements CFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static CFactory init()
  {
    try
    {
      CFactory theCFactory = (CFactory)EPackage.Registry.INSTANCE.getEFactory(CPackage.eNS_URI);
      if (theCFactory != null)
      {
        return theCFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new CFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CFactoryImpl()
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
      case CPackage.MODEL: return createModel();
      case CPackage.TRANSLATION_UNIT: return createTranslationUnit();
      case CPackage.EXTERNAL_DECLARATION: return createExternalDeclaration();
      case CPackage.FUNCTION_DEF_HEAD: return createFunctionDefHead();
      case CPackage.FUNCTION_DEFINITION: return createFunctionDefinition();
      case CPackage.DECLARATION: return createDeclaration();
      case CPackage.DECLARATION_SPECIFIERS: return createDeclarationSpecifiers();
      case CPackage.INIT_DECLARATOR_LIST: return createInitDeclaratorList();
      case CPackage.INIT_DECLARATOR: return createInitDeclarator();
      case CPackage.STORAGE_CLASS_SPECIFIER: return createStorageClassSpecifier();
      case CPackage.TYPE_SPECIFIER: return createTypeSpecifier();
      case CPackage.TYPEDEF_NAME: return createTypedefName();
      case CPackage.SPECIFIER_QUALIFIER_LIST: return createSpecifierQualifierList();
      case CPackage.TYPE_QUALIFIER: return createTypeQualifier();
      case CPackage.DECLARATOR: return createDeclarator();
      case CPackage.DIRECT_DECLARATOR: return createDirectDeclarator();
      case CPackage.DECLARATOR_SUFFIX: return createDeclaratorSuffix();
      case CPackage.DIRECT_DECLARATOR_LAST_SUFFIX: return createDirectDeclaratorLastSuffix();
      case CPackage.POINTER: return createPointer();
      case CPackage.TYPE_QUALIFIER_LIST: return createTypeQualifierList();
      case CPackage.PARAMETER_TYPE_LIST: return createParameterTypeList();
      case CPackage.PARAMETER_LIST: return createParameterList();
      case CPackage.PARAMETER_DECLARATION: return createParameterDeclaration();
      case CPackage.IDENTIFIER_LIST: return createIdentifierList();
      case CPackage.MY_IDENTIFIER: return createMyIdentifier();
      case CPackage.TYPE_NAME: return createTypeName();
      case CPackage.INITIALIZER: return createInitializer();
      case CPackage.STATEMENT: return createStatement();
      case CPackage.BLOCK_LIST: return createBlockList();
      case CPackage.EXPRESSION_STATEMENT: return createExpressionStatement();
      case CPackage.JUMP_STATEMENT: return createJumpStatement();
      case CPackage.EXPRESSION: return createExpression();
      case CPackage.ASSIGNMENT_OPERATOR: return createAssignmentOperator();
      case CPackage.UNARY_OPERATOR: return createUnaryOperator();
      case CPackage.CONSTANT: return createConstant();
      case CPackage.COMPOUND_STATEMENT: return createCompoundStatement();
      case CPackage.BODY_STATEMENT: return createBodyStatement();
      case CPackage.ASSIGNMENT_EXPRESSION: return createAssignmentExpression();
      case CPackage.CONDITIONAL_EXPRESSION: return createConditionalExpression();
      case CPackage.LOGICAL_OR_EXPRESSION: return createLogicalOrExpression();
      case CPackage.LOGICAL_AND_EXPRESSION: return createLogicalAndExpression();
      case CPackage.INCLUSIVE_OR_EXPRESSION: return createInclusiveOrExpression();
      case CPackage.EXCLUSIVE_OR_EXPRESSION: return createExclusiveOrExpression();
      case CPackage.AND_EXPRESSION: return createAndExpression();
      case CPackage.EQUALITY_EXPRESSION: return createEqualityExpression();
      case CPackage.RELATIONAL_EXPRESSION: return createRelationalExpression();
      case CPackage.SHIFT_EXPRESSION: return createShiftExpression();
      case CPackage.ADDITIVE_EXPRESSION: return createAdditiveExpression();
      case CPackage.MULTIPLICATIVE_EXPRESSION: return createMultiplicativeExpression();
      case CPackage.CAST_EXPRESSION: return createCastExpression();
      case CPackage.UNARY_EXPRESSION: return createUnaryExpression();
      case CPackage.POSTFIX_EXPRESSION: return createPostfixExpression();
      case CPackage.PRIMARY_EXPRESSION: return createPrimaryExpression();
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
  public AssignmentOperator createAssignmentOperator()
  {
    AssignmentOperatorImpl assignmentOperator = new AssignmentOperatorImpl();
    return assignmentOperator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryOperator createUnaryOperator()
  {
    UnaryOperatorImpl unaryOperator = new UnaryOperatorImpl();
    return unaryOperator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Constant createConstant()
  {
    ConstantImpl constant = new ConstantImpl();
    return constant;
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
  public CPackage getCPackage()
  {
    return (CPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static CPackage getPackage()
  {
    return CPackage.eINSTANCE;
  }

} //CFactoryImpl
