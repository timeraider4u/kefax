/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.common.common.CommonPackage;

import at.jku.weiner.c.parser.parser.AbstractDeclarator;
import at.jku.weiner.c.parser.parser.AbstractDeclaratorSuffix;
import at.jku.weiner.c.parser.parser.AdditiveExpression;
import at.jku.weiner.c.parser.parser.AndExpression;
import at.jku.weiner.c.parser.parser.ArgumentExpressionList;
import at.jku.weiner.c.parser.parser.AsmLine;
import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
import at.jku.weiner.c.parser.parser.AsmStatement;
import at.jku.weiner.c.parser.parser.AsmSymbolicName;
import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.AssignmentOperator;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.CompoundStatement;
import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.ConstantExpression;
import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifier;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.Designation;
import at.jku.weiner.c.parser.parser.Designator;
import at.jku.weiner.c.parser.parser.DesignatorList;
import at.jku.weiner.c.parser.parser.DirectAbstractDeclarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.parser.parser.EnumSpecifier;
import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.EnumeratorList;
import at.jku.weiner.c.parser.parser.EqualityExpression;
import at.jku.weiner.c.parser.parser.ExclusiveOrExpression;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.ExpressionStatement;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.FunctionDefHead;
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.FunctionSpecifier;
import at.jku.weiner.c.parser.parser.GccAttribute;
import at.jku.weiner.c.parser.parser.GccAttributeList;
import at.jku.weiner.c.parser.parser.GccAttributeSpecifier;
import at.jku.weiner.c.parser.parser.GccDeclaratorExtension;
import at.jku.weiner.c.parser.parser.IdentifierList;
import at.jku.weiner.c.parser.parser.InclusiveOrExpression;
import at.jku.weiner.c.parser.parser.Init;
import at.jku.weiner.c.parser.parser.InitDeclarator;
import at.jku.weiner.c.parser.parser.InitDeclaratorList;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.InitializerList;
import at.jku.weiner.c.parser.parser.IterationStatement;
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.LabeledStatement;
import at.jku.weiner.c.parser.parser.LogicalAndExpression;
import at.jku.weiner.c.parser.parser.LogicalOrExpression;
import at.jku.weiner.c.parser.parser.MultiplicativeExpression;
import at.jku.weiner.c.parser.parser.MyIdentifier;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.ParameterList;
import at.jku.weiner.c.parser.parser.ParameterTypeList;
import at.jku.weiner.c.parser.parser.Parser;
import at.jku.weiner.c.parser.parser.ParserFactory;
import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.Pointer;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffix;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArray;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArrow;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixDot;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixMinusMinus;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffixPlusPlus;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.RelationalExpression;
import at.jku.weiner.c.parser.parser.SelectionStatement;
import at.jku.weiner.c.parser.parser.ShiftExpression;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.StorageClassSpecifier;
import at.jku.weiner.c.parser.parser.StructDeclaration;
import at.jku.weiner.c.parser.parser.StructDeclarationList;
import at.jku.weiner.c.parser.parser.StructDeclarator;
import at.jku.weiner.c.parser.parser.StructDeclaratorList;
import at.jku.weiner.c.parser.parser.StructOrUnion;
import at.jku.weiner.c.parser.parser.StructOrUnionSpecifier;
import at.jku.weiner.c.parser.parser.TypeName;
import at.jku.weiner.c.parser.parser.TypeQualifier;
import at.jku.weiner.c.parser.parser.TypeQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.UnaryOperator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ParserPackageImpl extends EPackageImpl implements ParserPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass externalDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionDefHeadEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass declarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionDeclarationSpecifiersEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass declarationSpecifiersEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass initDeclaratorListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass initDeclaratorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass storageClassSpecifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeSpecifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typedefNameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass declarationSpecifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass structOrUnionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass structDeclarationListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass structDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass specifierQualifierListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass structDeclaratorListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass structDeclaratorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumeratorListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumeratorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeQualifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionSpecifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass declaratorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass directDeclaratorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass declaratorSuffixEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass directDeclaratorLastSuffixEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass gccDeclaratorExtensionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass gccAttributeSpecifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass gccAttributeListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass gccAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pointerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeQualifierListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterTypeListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass identifierListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myIdentifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeNameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractDeclaratorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass directAbstractDeclaratorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractDeclaratorSuffixEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass initializerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass initializerListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass initEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass blockListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass statementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass asmLineEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass asmSymbolicNameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass asmLineWithColonEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass asmLineWithoutColonEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass designationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass designatorListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass designatorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assignmentOperatorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unaryOperatorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass postfixExpressionSuffixEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass argumentExpressionListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parserEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass structOrUnionSpecifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumSpecifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass labeledStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass compoundStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bodyStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass selectionStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass iterationStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass jumpStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass asmStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assignmentExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionalExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass logicalOrExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass logicalAndExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inclusiveOrExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exclusiveOrExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass andExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass equalityExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass relationalExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass shiftExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass additiveExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiplicativeExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass castExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unaryExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass postfixExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass postfixExpressionSuffixArrayEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass postfixExpressionSuffixArgumentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass postfixExpressionSuffixDotEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass postfixExpressionSuffixArrowEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass postfixExpressionSuffixPlusPlusEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass postfixExpressionSuffixMinusMinusEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass primaryExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constantExpressionEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see at.jku.weiner.c.parser.parser.ParserPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ParserPackageImpl()
  {
    super(eNS_URI, ParserFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link ParserPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ParserPackage init()
  {
    if (isInited) return (ParserPackage)EPackage.Registry.INSTANCE.getEPackage(ParserPackage.eNS_URI);

    // Obtain or create and register package
    ParserPackageImpl theParserPackage = (ParserPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ParserPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ParserPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    CommonPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theParserPackage.createPackageContents();

    // Initialize created meta-data
    theParserPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theParserPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ParserPackage.eNS_URI, theParserPackage);
    return theParserPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExternalDeclaration()
  {
    return externalDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExternalDeclaration_FunctiondefHead()
  {
    return (EReference)externalDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExternalDeclaration_FunctionDefinition()
  {
    return (EReference)externalDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExternalDeclaration_Declaration()
  {
    return (EReference)externalDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExternalDeclaration_Semi()
  {
    return (EAttribute)externalDeclarationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunctionDefHead()
  {
    return functionDefHeadEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionDefHead_FunDeclSpecifiers()
  {
    return (EReference)functionDefHeadEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionDefHead_FunDeclarator()
  {
    return (EReference)functionDefHeadEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionDefHead_FunDeclaration()
  {
    return (EReference)functionDefHeadEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunctionDefinition()
  {
    return functionDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionDefinition_Body()
  {
    return (EReference)functionDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDeclaration()
  {
    return declarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDeclaration_Specifiers()
  {
    return (EReference)declarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDeclaration_InitDeclaratorList()
  {
    return (EReference)declarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDeclaration_Semi()
  {
    return (EAttribute)declarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunctionDeclarationSpecifiers()
  {
    return functionDeclarationSpecifiersEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionDeclarationSpecifiers_DeclarationSpecifier()
  {
    return (EReference)functionDeclarationSpecifiersEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDeclarationSpecifiers()
  {
    return declarationSpecifiersEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDeclarationSpecifiers_DeclarationSpecifier()
  {
    return (EReference)declarationSpecifiersEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInitDeclaratorList()
  {
    return initDeclaratorListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInitDeclaratorList_InitDeclarator()
  {
    return (EReference)initDeclaratorListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInitDeclarator()
  {
    return initDeclaratorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInitDeclarator_Declarator()
  {
    return (EReference)initDeclaratorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInitDeclarator_Initializer()
  {
    return (EReference)initDeclaratorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStorageClassSpecifier()
  {
    return storageClassSpecifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStorageClassSpecifier_Name()
  {
    return (EAttribute)storageClassSpecifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeSpecifier()
  {
    return typeSpecifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeSpecifier_Name()
  {
    return (EAttribute)typeSpecifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeSpecifier_ExtType()
  {
    return (EAttribute)typeSpecifierEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeSpecifier_Specifier()
  {
    return (EReference)typeSpecifierEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeSpecifier_Type()
  {
    return (EReference)typeSpecifierEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeSpecifier_TypeOf()
  {
    return (EAttribute)typeSpecifierEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeSpecifier_TypeName()
  {
    return (EReference)typeSpecifierEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeSpecifier_ConstExpr()
  {
    return (EReference)typeSpecifierEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypedefName()
  {
    return typedefNameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypedefName_Id()
  {
    return (EAttribute)typedefNameEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDeclarationSpecifier()
  {
    return declarationSpecifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDeclarationSpecifier_Id()
  {
    return (EAttribute)declarationSpecifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStructOrUnion()
  {
    return structOrUnionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStructOrUnion_Name()
  {
    return (EAttribute)structOrUnionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStructDeclarationList()
  {
    return structDeclarationListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStructDeclarationList_StructDeclaration()
  {
    return (EReference)structDeclarationListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStructDeclaration()
  {
    return structDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStructDeclaration_List()
  {
    return (EReference)structDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStructDeclaration_StructDeclarationList()
  {
    return (EReference)structDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSpecifierQualifierList()
  {
    return specifierQualifierListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSpecifierQualifierList_TypeSpecifier()
  {
    return (EReference)specifierQualifierListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSpecifierQualifierList_TypeQualifier()
  {
    return (EReference)specifierQualifierListEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStructDeclaratorList()
  {
    return structDeclaratorListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStructDeclaratorList_StructDeclarator()
  {
    return (EReference)structDeclaratorListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStructDeclarator()
  {
    return structDeclaratorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStructDeclarator_Declarator()
  {
    return (EReference)structDeclaratorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStructDeclarator_ConstExpr()
  {
    return (EReference)structDeclaratorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumeratorList()
  {
    return enumeratorListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumeratorList_Enumerator()
  {
    return (EReference)enumeratorListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEnumeratorList_LastComma()
  {
    return (EAttribute)enumeratorListEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumerator()
  {
    return enumeratorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEnumerator_Id()
  {
    return (EAttribute)enumeratorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumerator_Expr()
  {
    return (EReference)enumeratorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeQualifier()
  {
    return typeQualifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeQualifier_Type()
  {
    return (EAttribute)typeQualifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunctionSpecifier()
  {
    return functionSpecifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunctionSpecifier_Name()
  {
    return (EAttribute)functionSpecifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionSpecifier_GccAttributeSpecifier()
  {
    return (EReference)functionSpecifierEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDeclarator()
  {
    return declaratorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDeclarator_Pointer()
  {
    return (EReference)declaratorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDeclarator_GccDeclExt1()
  {
    return (EReference)declaratorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDeclarator_Declarator()
  {
    return (EReference)declaratorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDeclarator_GccDeclExt2()
  {
    return (EReference)declaratorEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDirectDeclarator()
  {
    return directDeclaratorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDirectDeclarator_Id()
  {
    return (EAttribute)directDeclaratorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDirectDeclarator_Declarator()
  {
    return (EReference)directDeclaratorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDirectDeclarator_DeclaratorSuffix()
  {
    return (EReference)directDeclaratorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDeclaratorSuffix()
  {
    return declaratorSuffixEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDeclaratorSuffix_Expr()
  {
    return (EReference)declaratorSuffixEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDeclaratorSuffix_LastSuffix()
  {
    return (EReference)declaratorSuffixEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDirectDeclaratorLastSuffix()
  {
    return directDeclaratorLastSuffixEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDirectDeclaratorLastSuffix_ParameterTypeList()
  {
    return (EReference)directDeclaratorLastSuffixEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDirectDeclaratorLastSuffix_IdentifierList()
  {
    return (EReference)directDeclaratorLastSuffixEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGccDeclaratorExtension()
  {
    return gccDeclaratorExtensionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGccDeclaratorExtension_Asm()
  {
    return (EAttribute)gccDeclaratorExtensionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGccDeclaratorExtension_String()
  {
    return (EAttribute)gccDeclaratorExtensionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGccDeclaratorExtension_GccAttributeSpecifier()
  {
    return (EReference)gccDeclaratorExtensionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGccAttributeSpecifier()
  {
    return gccAttributeSpecifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGccAttributeSpecifier_Attribute()
  {
    return (EAttribute)gccAttributeSpecifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGccAttributeSpecifier_List()
  {
    return (EReference)gccAttributeSpecifierEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGccAttributeList()
  {
    return gccAttributeListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGccAttributeList_GccAttribute()
  {
    return (EReference)gccAttributeListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGccAttribute()
  {
    return gccAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGccAttribute_Id()
  {
    return (EAttribute)gccAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGccAttribute_Const()
  {
    return (EAttribute)gccAttributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGccAttribute_Keyword()
  {
    return (EAttribute)gccAttributeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGccAttribute_List()
  {
    return (EReference)gccAttributeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPointer()
  {
    return pointerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPointer_Star()
  {
    return (EAttribute)pointerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPointer_Caret()
  {
    return (EAttribute)pointerEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPointer_TypeQualifierList()
  {
    return (EReference)pointerEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeQualifierList()
  {
    return typeQualifierListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeQualifierList_TypeQualifier()
  {
    return (EReference)typeQualifierListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameterTypeList()
  {
    return parameterTypeListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParameterTypeList_List()
  {
    return (EReference)parameterTypeListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParameterTypeList_Ellipsis()
  {
    return (EAttribute)parameterTypeListEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameterList()
  {
    return parameterListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParameterList_ParameterDeclaration()
  {
    return (EReference)parameterListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameterDeclaration()
  {
    return parameterDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParameterDeclaration_DeclSpecifiers()
  {
    return (EReference)parameterDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParameterDeclaration_Declarator()
  {
    return (EReference)parameterDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParameterDeclaration_AbstractDeclator()
  {
    return (EReference)parameterDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIdentifierList()
  {
    return identifierListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIdentifierList_Id()
  {
    return (EReference)identifierListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMyIdentifier()
  {
    return myIdentifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMyIdentifier_Id()
  {
    return (EAttribute)myIdentifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeName()
  {
    return typeNameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeName_List()
  {
    return (EReference)typeNameEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeName_AbstractDeclarator()
  {
    return (EReference)typeNameEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractDeclarator()
  {
    return abstractDeclaratorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractDeclarator_Pointer()
  {
    return (EReference)abstractDeclaratorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractDeclarator_DirectAbstractDeclarator()
  {
    return (EReference)abstractDeclaratorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractDeclarator_GccDeclExtAbstract()
  {
    return (EReference)abstractDeclaratorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDirectAbstractDeclarator()
  {
    return directAbstractDeclaratorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDirectAbstractDeclarator_Declarator()
  {
    return (EReference)directAbstractDeclaratorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDirectAbstractDeclarator_GccDeclExt()
  {
    return (EReference)directAbstractDeclaratorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDirectAbstractDeclarator_AbstractDeclaratorSuffix()
  {
    return (EReference)directAbstractDeclaratorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractDeclaratorSuffix()
  {
    return abstractDeclaratorSuffixEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractDeclaratorSuffix_TypeQualifierList()
  {
    return (EReference)abstractDeclaratorSuffixEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractDeclaratorSuffix_AssignmentExpr()
  {
    return (EReference)abstractDeclaratorSuffixEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractDeclaratorSuffix_TypeQualifierListOrig()
  {
    return (EReference)abstractDeclaratorSuffixEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractDeclaratorSuffix_ParameterTypeList()
  {
    return (EReference)abstractDeclaratorSuffixEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractDeclaratorSuffix_GccDeclExt()
  {
    return (EReference)abstractDeclaratorSuffixEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInitializer()
  {
    return initializerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInitializer_Expr()
  {
    return (EReference)initializerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInitializer_List()
  {
    return (EReference)initializerEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInitializer_LastComma()
  {
    return (EAttribute)initializerEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInitializerList()
  {
    return initializerListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInitializerList_Init()
  {
    return (EReference)initializerListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInit()
  {
    return initEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInit_Designation()
  {
    return (EReference)initEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInit_Initializer()
  {
    return (EReference)initEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBlockList()
  {
    return blockListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBlockList_Declaration()
  {
    return (EReference)blockListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBlockList_Statement()
  {
    return (EReference)blockListEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStatement()
  {
    return statementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStatement_Stmt()
  {
    return (EReference)statementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAsmLine()
  {
    return asmLineEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAsmLine_Sym()
  {
    return (EReference)asmLineEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAsmLine_Expr()
  {
    return (EReference)asmLineEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAsmSymbolicName()
  {
    return asmSymbolicNameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAsmSymbolicName_Id()
  {
    return (EAttribute)asmSymbolicNameEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAsmLineWithColon()
  {
    return asmLineWithColonEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAsmLineWithColon_AsmLine()
  {
    return (EReference)asmLineWithColonEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAsmLineWithoutColon()
  {
    return asmLineWithoutColonEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAsmLineWithoutColon_AsmLines()
  {
    return (EReference)asmLineWithoutColonEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDesignation()
  {
    return designationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDesignation_List()
  {
    return (EReference)designationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDesignatorList()
  {
    return designatorListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDesignatorList_Designator()
  {
    return (EReference)designatorListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDesignator()
  {
    return designatorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDesignator_Expr()
  {
    return (EReference)designatorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDesignator_To()
  {
    return (EReference)designatorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDesignator_Id()
  {
    return (EAttribute)designatorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_ExprExpr()
  {
    return (EReference)expressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssignmentOperator()
  {
    return assignmentOperatorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssignmentOperator_Op()
  {
    return (EAttribute)assignmentOperatorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnaryOperator()
  {
    return unaryOperatorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPostfixExpressionSuffix()
  {
    return postfixExpressionSuffixEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getArgumentExpressionList()
  {
    return argumentExpressionListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParser()
  {
    return parserEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParser_External()
  {
    return (EReference)parserEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStructOrUnionSpecifier()
  {
    return structOrUnionSpecifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStructOrUnionSpecifier_Type()
  {
    return (EReference)structOrUnionSpecifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStructOrUnionSpecifier_Braces()
  {
    return (EAttribute)structOrUnionSpecifierEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStructOrUnionSpecifier_StructDeclList()
  {
    return (EReference)structOrUnionSpecifierEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumSpecifier()
  {
    return enumSpecifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumSpecifier_EnumList()
  {
    return (EReference)enumSpecifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLabeledStatement()
  {
    return labeledStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLabeledStatement_Id()
  {
    return (EAttribute)labeledStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLabeledStatement_LStmt()
  {
    return (EReference)labeledStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLabeledStatement_Case()
  {
    return (EAttribute)labeledStatementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLabeledStatement_Lower()
  {
    return (EAttribute)labeledStatementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLabeledStatement_Higher()
  {
    return (EAttribute)labeledStatementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLabeledStatement_Expr()
  {
    return (EReference)labeledStatementEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLabeledStatement_Mydefault()
  {
    return (EAttribute)labeledStatementEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCompoundStatement()
  {
    return compoundStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCompoundStatement_Body()
  {
    return (EReference)compoundStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBodyStatement()
  {
    return bodyStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBodyStatement_BlockList()
  {
    return (EReference)bodyStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpressionStatement()
  {
    return expressionStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpressionStatement_Expression()
  {
    return (EReference)expressionStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExpressionStatement_Semi()
  {
    return (EAttribute)expressionStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSelectionStatement()
  {
    return selectionStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSelectionStatement_If()
  {
    return (EAttribute)selectionStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSelectionStatement_Expr()
  {
    return (EReference)selectionStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSelectionStatement_IfStatement()
  {
    return (EReference)selectionStatementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSelectionStatement_Else()
  {
    return (EAttribute)selectionStatementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSelectionStatement_ElseStatement()
  {
    return (EReference)selectionStatementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSelectionStatement_Switch()
  {
    return (EAttribute)selectionStatementEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSelectionStatement_SwitchStatement()
  {
    return (EReference)selectionStatementEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIterationStatement()
  {
    return iterationStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIterationStatement_While()
  {
    return (EAttribute)iterationStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIterationStatement_Expr()
  {
    return (EReference)iterationStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIterationStatement_Statement()
  {
    return (EReference)iterationStatementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIterationStatement_Do()
  {
    return (EAttribute)iterationStatementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIterationStatement_Semi()
  {
    return (EAttribute)iterationStatementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIterationStatement_For()
  {
    return (EAttribute)iterationStatementEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIterationStatement_InitExpr()
  {
    return (EReference)iterationStatementEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIterationStatement_IncExpr()
  {
    return (EReference)iterationStatementEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIterationStatement_InitDecl()
  {
    return (EReference)iterationStatementEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getJumpStatement()
  {
    return jumpStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getJumpStatement_Continue()
  {
    return (EAttribute)jumpStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getJumpStatement_Semi()
  {
    return (EAttribute)jumpStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getJumpStatement_Break()
  {
    return (EAttribute)jumpStatementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getJumpStatement_Return()
  {
    return (EAttribute)jumpStatementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getJumpStatement_Expr()
  {
    return (EReference)jumpStatementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getJumpStatement_Goto()
  {
    return (EAttribute)jumpStatementEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAsmStatement()
  {
    return asmStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAsmStatement_Asm()
  {
    return (EAttribute)asmStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAsmStatement_Volatile()
  {
    return (EAttribute)asmStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAsmStatement_AsmLine1()
  {
    return (EReference)asmStatementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAsmStatement_AsmLines()
  {
    return (EReference)asmStatementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAsmStatement_LastComma()
  {
    return (EAttribute)asmStatementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAsmStatement_Semi()
  {
    return (EAttribute)asmStatementEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssignmentExpression()
  {
    return assignmentExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssignmentExpression_Expr()
  {
    return (EReference)assignmentExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssignmentExpression_Op()
  {
    return (EReference)assignmentExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssignmentExpression_AssignmentExpr()
  {
    return (EReference)assignmentExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionalExpression()
  {
    return conditionalExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalExpression_Expr()
  {
    return (EReference)conditionalExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalExpression_QExpr()
  {
    return (EReference)conditionalExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalExpression_CExpr()
  {
    return (EReference)conditionalExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLogicalOrExpression()
  {
    return logicalOrExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLogicalOrExpression_Expr()
  {
    return (EReference)logicalOrExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLogicalAndExpression()
  {
    return logicalAndExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLogicalAndExpression_Expr()
  {
    return (EReference)logicalAndExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInclusiveOrExpression()
  {
    return inclusiveOrExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInclusiveOrExpression_Expr()
  {
    return (EReference)inclusiveOrExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExclusiveOrExpression()
  {
    return exclusiveOrExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExclusiveOrExpression_Expr()
  {
    return (EReference)exclusiveOrExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAndExpression()
  {
    return andExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndExpression_Expr()
  {
    return (EReference)andExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEqualityExpression()
  {
    return equalityExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEqualityExpression_Expr()
  {
    return (EReference)equalityExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEqualityExpression_Op()
  {
    return (EAttribute)equalityExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRelationalExpression()
  {
    return relationalExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRelationalExpression_Expr()
  {
    return (EReference)relationalExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRelationalExpression_Op()
  {
    return (EAttribute)relationalExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getShiftExpression()
  {
    return shiftExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getShiftExpression_Expr()
  {
    return (EReference)shiftExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getShiftExpression_Op()
  {
    return (EAttribute)shiftExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAdditiveExpression()
  {
    return additiveExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAdditiveExpression_Expr()
  {
    return (EReference)additiveExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAdditiveExpression_Op()
  {
    return (EAttribute)additiveExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiplicativeExpression()
  {
    return multiplicativeExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultiplicativeExpression_Expr()
  {
    return (EReference)multiplicativeExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiplicativeExpression_Op()
  {
    return (EAttribute)multiplicativeExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCastExpression()
  {
    return castExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCastExpression_Type()
  {
    return (EReference)castExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCastExpression_Expr()
  {
    return (EReference)castExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnaryExpression()
  {
    return unaryExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnaryExpression_Expr()
  {
    return (EReference)unaryExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnaryExpression_Plusplus()
  {
    return (EAttribute)unaryExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnaryExpression_Minusminus()
  {
    return (EAttribute)unaryExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnaryExpression_Op()
  {
    return (EReference)unaryExpressionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnaryExpression_SizeOf()
  {
    return (EAttribute)unaryExpressionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnaryExpression_TypeName()
  {
    return (EReference)unaryExpressionEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnaryExpression_AlignOf()
  {
    return (EAttribute)unaryExpressionEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnaryExpression_Andand()
  {
    return (EAttribute)unaryExpressionEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnaryExpression_Id()
  {
    return (EAttribute)unaryExpressionEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPostfixExpression()
  {
    return postfixExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPostfixExpression_Ext()
  {
    return (EAttribute)postfixExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPostfixExpression_TypeName()
  {
    return (EReference)postfixExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPostfixExpression_InitializerList()
  {
    return (EReference)postfixExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPostfixExpression_Comma()
  {
    return (EAttribute)postfixExpressionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPostfixExpression_Expr()
  {
    return (EReference)postfixExpressionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPostfixExpression_Suffix()
  {
    return (EReference)postfixExpressionEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPostfixExpressionSuffixArray()
  {
    return postfixExpressionSuffixArrayEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPostfixExpressionSuffixArray_ArrayExpr()
  {
    return (EReference)postfixExpressionSuffixArrayEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPostfixExpressionSuffixArgument()
  {
    return postfixExpressionSuffixArgumentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPostfixExpressionSuffixArgument_ArgumentExpressionList()
  {
    return (EReference)postfixExpressionSuffixArgumentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPostfixExpressionSuffixDot()
  {
    return postfixExpressionSuffixDotEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPostfixExpressionSuffixDot_Id()
  {
    return (EAttribute)postfixExpressionSuffixDotEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPostfixExpressionSuffixArrow()
  {
    return postfixExpressionSuffixArrowEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPostfixExpressionSuffixArrow_Id()
  {
    return (EAttribute)postfixExpressionSuffixArrowEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPostfixExpressionSuffixPlusPlus()
  {
    return postfixExpressionSuffixPlusPlusEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPostfixExpressionSuffixMinusMinus()
  {
    return postfixExpressionSuffixMinusMinusEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrimaryExpression()
  {
    return primaryExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPrimaryExpression_Id()
  {
    return (EAttribute)primaryExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrimaryExpression_Const()
  {
    return (EReference)primaryExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPrimaryExpression_String()
  {
    return (EAttribute)primaryExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrimaryExpression_Expr()
  {
    return (EReference)primaryExpressionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPrimaryExpression_Ext()
  {
    return (EAttribute)primaryExpressionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrimaryExpression_CompoundStmt()
  {
    return (EReference)primaryExpressionEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPrimaryExpression_Builtin_offsetof()
  {
    return (EAttribute)primaryExpressionEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrimaryExpression_TypeName()
  {
    return (EReference)primaryExpressionEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPrimaryExpression_Builtin_typescompatiblep()
  {
    return (EAttribute)primaryExpressionEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrimaryExpression_TypeName2()
  {
    return (EReference)primaryExpressionEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstantExpression()
  {
    return constantExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstantExpression_Expr()
  {
    return (EReference)constantExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParserFactory getParserFactory()
  {
    return (ParserFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    externalDeclarationEClass = createEClass(EXTERNAL_DECLARATION);
    createEReference(externalDeclarationEClass, EXTERNAL_DECLARATION__FUNCTIONDEF_HEAD);
    createEReference(externalDeclarationEClass, EXTERNAL_DECLARATION__FUNCTION_DEFINITION);
    createEReference(externalDeclarationEClass, EXTERNAL_DECLARATION__DECLARATION);
    createEAttribute(externalDeclarationEClass, EXTERNAL_DECLARATION__SEMI);

    functionDefHeadEClass = createEClass(FUNCTION_DEF_HEAD);
    createEReference(functionDefHeadEClass, FUNCTION_DEF_HEAD__FUN_DECL_SPECIFIERS);
    createEReference(functionDefHeadEClass, FUNCTION_DEF_HEAD__FUN_DECLARATOR);
    createEReference(functionDefHeadEClass, FUNCTION_DEF_HEAD__FUN_DECLARATION);

    functionDefinitionEClass = createEClass(FUNCTION_DEFINITION);
    createEReference(functionDefinitionEClass, FUNCTION_DEFINITION__BODY);

    declarationEClass = createEClass(DECLARATION);
    createEReference(declarationEClass, DECLARATION__SPECIFIERS);
    createEReference(declarationEClass, DECLARATION__INIT_DECLARATOR_LIST);
    createEAttribute(declarationEClass, DECLARATION__SEMI);

    functionDeclarationSpecifiersEClass = createEClass(FUNCTION_DECLARATION_SPECIFIERS);
    createEReference(functionDeclarationSpecifiersEClass, FUNCTION_DECLARATION_SPECIFIERS__DECLARATION_SPECIFIER);

    declarationSpecifiersEClass = createEClass(DECLARATION_SPECIFIERS);
    createEReference(declarationSpecifiersEClass, DECLARATION_SPECIFIERS__DECLARATION_SPECIFIER);

    initDeclaratorListEClass = createEClass(INIT_DECLARATOR_LIST);
    createEReference(initDeclaratorListEClass, INIT_DECLARATOR_LIST__INIT_DECLARATOR);

    initDeclaratorEClass = createEClass(INIT_DECLARATOR);
    createEReference(initDeclaratorEClass, INIT_DECLARATOR__DECLARATOR);
    createEReference(initDeclaratorEClass, INIT_DECLARATOR__INITIALIZER);

    storageClassSpecifierEClass = createEClass(STORAGE_CLASS_SPECIFIER);
    createEAttribute(storageClassSpecifierEClass, STORAGE_CLASS_SPECIFIER__NAME);

    typeSpecifierEClass = createEClass(TYPE_SPECIFIER);
    createEAttribute(typeSpecifierEClass, TYPE_SPECIFIER__NAME);
    createEAttribute(typeSpecifierEClass, TYPE_SPECIFIER__EXT_TYPE);
    createEReference(typeSpecifierEClass, TYPE_SPECIFIER__SPECIFIER);
    createEReference(typeSpecifierEClass, TYPE_SPECIFIER__TYPE);
    createEAttribute(typeSpecifierEClass, TYPE_SPECIFIER__TYPE_OF);
    createEReference(typeSpecifierEClass, TYPE_SPECIFIER__TYPE_NAME);
    createEReference(typeSpecifierEClass, TYPE_SPECIFIER__CONST_EXPR);

    typedefNameEClass = createEClass(TYPEDEF_NAME);
    createEAttribute(typedefNameEClass, TYPEDEF_NAME__ID);

    declarationSpecifierEClass = createEClass(DECLARATION_SPECIFIER);
    createEAttribute(declarationSpecifierEClass, DECLARATION_SPECIFIER__ID);

    structOrUnionEClass = createEClass(STRUCT_OR_UNION);
    createEAttribute(structOrUnionEClass, STRUCT_OR_UNION__NAME);

    structDeclarationListEClass = createEClass(STRUCT_DECLARATION_LIST);
    createEReference(structDeclarationListEClass, STRUCT_DECLARATION_LIST__STRUCT_DECLARATION);

    structDeclarationEClass = createEClass(STRUCT_DECLARATION);
    createEReference(structDeclarationEClass, STRUCT_DECLARATION__LIST);
    createEReference(structDeclarationEClass, STRUCT_DECLARATION__STRUCT_DECLARATION_LIST);

    specifierQualifierListEClass = createEClass(SPECIFIER_QUALIFIER_LIST);
    createEReference(specifierQualifierListEClass, SPECIFIER_QUALIFIER_LIST__TYPE_SPECIFIER);
    createEReference(specifierQualifierListEClass, SPECIFIER_QUALIFIER_LIST__TYPE_QUALIFIER);

    structDeclaratorListEClass = createEClass(STRUCT_DECLARATOR_LIST);
    createEReference(structDeclaratorListEClass, STRUCT_DECLARATOR_LIST__STRUCT_DECLARATOR);

    structDeclaratorEClass = createEClass(STRUCT_DECLARATOR);
    createEReference(structDeclaratorEClass, STRUCT_DECLARATOR__DECLARATOR);
    createEReference(structDeclaratorEClass, STRUCT_DECLARATOR__CONST_EXPR);

    enumeratorListEClass = createEClass(ENUMERATOR_LIST);
    createEReference(enumeratorListEClass, ENUMERATOR_LIST__ENUMERATOR);
    createEAttribute(enumeratorListEClass, ENUMERATOR_LIST__LAST_COMMA);

    enumeratorEClass = createEClass(ENUMERATOR);
    createEAttribute(enumeratorEClass, ENUMERATOR__ID);
    createEReference(enumeratorEClass, ENUMERATOR__EXPR);

    typeQualifierEClass = createEClass(TYPE_QUALIFIER);
    createEAttribute(typeQualifierEClass, TYPE_QUALIFIER__TYPE);

    functionSpecifierEClass = createEClass(FUNCTION_SPECIFIER);
    createEAttribute(functionSpecifierEClass, FUNCTION_SPECIFIER__NAME);
    createEReference(functionSpecifierEClass, FUNCTION_SPECIFIER__GCC_ATTRIBUTE_SPECIFIER);

    declaratorEClass = createEClass(DECLARATOR);
    createEReference(declaratorEClass, DECLARATOR__POINTER);
    createEReference(declaratorEClass, DECLARATOR__GCC_DECL_EXT1);
    createEReference(declaratorEClass, DECLARATOR__DECLARATOR);
    createEReference(declaratorEClass, DECLARATOR__GCC_DECL_EXT2);

    directDeclaratorEClass = createEClass(DIRECT_DECLARATOR);
    createEAttribute(directDeclaratorEClass, DIRECT_DECLARATOR__ID);
    createEReference(directDeclaratorEClass, DIRECT_DECLARATOR__DECLARATOR);
    createEReference(directDeclaratorEClass, DIRECT_DECLARATOR__DECLARATOR_SUFFIX);

    declaratorSuffixEClass = createEClass(DECLARATOR_SUFFIX);
    createEReference(declaratorSuffixEClass, DECLARATOR_SUFFIX__EXPR);
    createEReference(declaratorSuffixEClass, DECLARATOR_SUFFIX__LAST_SUFFIX);

    directDeclaratorLastSuffixEClass = createEClass(DIRECT_DECLARATOR_LAST_SUFFIX);
    createEReference(directDeclaratorLastSuffixEClass, DIRECT_DECLARATOR_LAST_SUFFIX__PARAMETER_TYPE_LIST);
    createEReference(directDeclaratorLastSuffixEClass, DIRECT_DECLARATOR_LAST_SUFFIX__IDENTIFIER_LIST);

    gccDeclaratorExtensionEClass = createEClass(GCC_DECLARATOR_EXTENSION);
    createEAttribute(gccDeclaratorExtensionEClass, GCC_DECLARATOR_EXTENSION__ASM);
    createEAttribute(gccDeclaratorExtensionEClass, GCC_DECLARATOR_EXTENSION__STRING);
    createEReference(gccDeclaratorExtensionEClass, GCC_DECLARATOR_EXTENSION__GCC_ATTRIBUTE_SPECIFIER);

    gccAttributeSpecifierEClass = createEClass(GCC_ATTRIBUTE_SPECIFIER);
    createEAttribute(gccAttributeSpecifierEClass, GCC_ATTRIBUTE_SPECIFIER__ATTRIBUTE);
    createEReference(gccAttributeSpecifierEClass, GCC_ATTRIBUTE_SPECIFIER__LIST);

    gccAttributeListEClass = createEClass(GCC_ATTRIBUTE_LIST);
    createEReference(gccAttributeListEClass, GCC_ATTRIBUTE_LIST__GCC_ATTRIBUTE);

    gccAttributeEClass = createEClass(GCC_ATTRIBUTE);
    createEAttribute(gccAttributeEClass, GCC_ATTRIBUTE__ID);
    createEAttribute(gccAttributeEClass, GCC_ATTRIBUTE__CONST);
    createEAttribute(gccAttributeEClass, GCC_ATTRIBUTE__KEYWORD);
    createEReference(gccAttributeEClass, GCC_ATTRIBUTE__LIST);

    pointerEClass = createEClass(POINTER);
    createEAttribute(pointerEClass, POINTER__STAR);
    createEAttribute(pointerEClass, POINTER__CARET);
    createEReference(pointerEClass, POINTER__TYPE_QUALIFIER_LIST);

    typeQualifierListEClass = createEClass(TYPE_QUALIFIER_LIST);
    createEReference(typeQualifierListEClass, TYPE_QUALIFIER_LIST__TYPE_QUALIFIER);

    parameterTypeListEClass = createEClass(PARAMETER_TYPE_LIST);
    createEReference(parameterTypeListEClass, PARAMETER_TYPE_LIST__LIST);
    createEAttribute(parameterTypeListEClass, PARAMETER_TYPE_LIST__ELLIPSIS);

    parameterListEClass = createEClass(PARAMETER_LIST);
    createEReference(parameterListEClass, PARAMETER_LIST__PARAMETER_DECLARATION);

    parameterDeclarationEClass = createEClass(PARAMETER_DECLARATION);
    createEReference(parameterDeclarationEClass, PARAMETER_DECLARATION__DECL_SPECIFIERS);
    createEReference(parameterDeclarationEClass, PARAMETER_DECLARATION__DECLARATOR);
    createEReference(parameterDeclarationEClass, PARAMETER_DECLARATION__ABSTRACT_DECLATOR);

    identifierListEClass = createEClass(IDENTIFIER_LIST);
    createEReference(identifierListEClass, IDENTIFIER_LIST__ID);

    myIdentifierEClass = createEClass(MY_IDENTIFIER);
    createEAttribute(myIdentifierEClass, MY_IDENTIFIER__ID);

    typeNameEClass = createEClass(TYPE_NAME);
    createEReference(typeNameEClass, TYPE_NAME__LIST);
    createEReference(typeNameEClass, TYPE_NAME__ABSTRACT_DECLARATOR);

    abstractDeclaratorEClass = createEClass(ABSTRACT_DECLARATOR);
    createEReference(abstractDeclaratorEClass, ABSTRACT_DECLARATOR__POINTER);
    createEReference(abstractDeclaratorEClass, ABSTRACT_DECLARATOR__DIRECT_ABSTRACT_DECLARATOR);
    createEReference(abstractDeclaratorEClass, ABSTRACT_DECLARATOR__GCC_DECL_EXT_ABSTRACT);

    directAbstractDeclaratorEClass = createEClass(DIRECT_ABSTRACT_DECLARATOR);
    createEReference(directAbstractDeclaratorEClass, DIRECT_ABSTRACT_DECLARATOR__DECLARATOR);
    createEReference(directAbstractDeclaratorEClass, DIRECT_ABSTRACT_DECLARATOR__GCC_DECL_EXT);
    createEReference(directAbstractDeclaratorEClass, DIRECT_ABSTRACT_DECLARATOR__ABSTRACT_DECLARATOR_SUFFIX);

    abstractDeclaratorSuffixEClass = createEClass(ABSTRACT_DECLARATOR_SUFFIX);
    createEReference(abstractDeclaratorSuffixEClass, ABSTRACT_DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST);
    createEReference(abstractDeclaratorSuffixEClass, ABSTRACT_DECLARATOR_SUFFIX__ASSIGNMENT_EXPR);
    createEReference(abstractDeclaratorSuffixEClass, ABSTRACT_DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST_ORIG);
    createEReference(abstractDeclaratorSuffixEClass, ABSTRACT_DECLARATOR_SUFFIX__PARAMETER_TYPE_LIST);
    createEReference(abstractDeclaratorSuffixEClass, ABSTRACT_DECLARATOR_SUFFIX__GCC_DECL_EXT);

    initializerEClass = createEClass(INITIALIZER);
    createEReference(initializerEClass, INITIALIZER__EXPR);
    createEReference(initializerEClass, INITIALIZER__LIST);
    createEAttribute(initializerEClass, INITIALIZER__LAST_COMMA);

    initializerListEClass = createEClass(INITIALIZER_LIST);
    createEReference(initializerListEClass, INITIALIZER_LIST__INIT);

    initEClass = createEClass(INIT);
    createEReference(initEClass, INIT__DESIGNATION);
    createEReference(initEClass, INIT__INITIALIZER);

    blockListEClass = createEClass(BLOCK_LIST);
    createEReference(blockListEClass, BLOCK_LIST__DECLARATION);
    createEReference(blockListEClass, BLOCK_LIST__STATEMENT);

    statementEClass = createEClass(STATEMENT);
    createEReference(statementEClass, STATEMENT__STMT);

    asmLineEClass = createEClass(ASM_LINE);
    createEReference(asmLineEClass, ASM_LINE__SYM);
    createEReference(asmLineEClass, ASM_LINE__EXPR);

    asmSymbolicNameEClass = createEClass(ASM_SYMBOLIC_NAME);
    createEAttribute(asmSymbolicNameEClass, ASM_SYMBOLIC_NAME__ID);

    asmLineWithColonEClass = createEClass(ASM_LINE_WITH_COLON);
    createEReference(asmLineWithColonEClass, ASM_LINE_WITH_COLON__ASM_LINE);

    asmLineWithoutColonEClass = createEClass(ASM_LINE_WITHOUT_COLON);
    createEReference(asmLineWithoutColonEClass, ASM_LINE_WITHOUT_COLON__ASM_LINES);

    designationEClass = createEClass(DESIGNATION);
    createEReference(designationEClass, DESIGNATION__LIST);

    designatorListEClass = createEClass(DESIGNATOR_LIST);
    createEReference(designatorListEClass, DESIGNATOR_LIST__DESIGNATOR);

    designatorEClass = createEClass(DESIGNATOR);
    createEReference(designatorEClass, DESIGNATOR__EXPR);
    createEReference(designatorEClass, DESIGNATOR__TO);
    createEAttribute(designatorEClass, DESIGNATOR__ID);

    expressionEClass = createEClass(EXPRESSION);
    createEReference(expressionEClass, EXPRESSION__EXPR_EXPR);

    assignmentOperatorEClass = createEClass(ASSIGNMENT_OPERATOR);
    createEAttribute(assignmentOperatorEClass, ASSIGNMENT_OPERATOR__OP);

    unaryOperatorEClass = createEClass(UNARY_OPERATOR);

    postfixExpressionSuffixEClass = createEClass(POSTFIX_EXPRESSION_SUFFIX);

    argumentExpressionListEClass = createEClass(ARGUMENT_EXPRESSION_LIST);

    parserEClass = createEClass(PARSER);
    createEReference(parserEClass, PARSER__EXTERNAL);

    structOrUnionSpecifierEClass = createEClass(STRUCT_OR_UNION_SPECIFIER);
    createEReference(structOrUnionSpecifierEClass, STRUCT_OR_UNION_SPECIFIER__TYPE);
    createEAttribute(structOrUnionSpecifierEClass, STRUCT_OR_UNION_SPECIFIER__BRACES);
    createEReference(structOrUnionSpecifierEClass, STRUCT_OR_UNION_SPECIFIER__STRUCT_DECL_LIST);

    enumSpecifierEClass = createEClass(ENUM_SPECIFIER);
    createEReference(enumSpecifierEClass, ENUM_SPECIFIER__ENUM_LIST);

    labeledStatementEClass = createEClass(LABELED_STATEMENT);
    createEAttribute(labeledStatementEClass, LABELED_STATEMENT__ID);
    createEReference(labeledStatementEClass, LABELED_STATEMENT__LSTMT);
    createEAttribute(labeledStatementEClass, LABELED_STATEMENT__CASE);
    createEAttribute(labeledStatementEClass, LABELED_STATEMENT__LOWER);
    createEAttribute(labeledStatementEClass, LABELED_STATEMENT__HIGHER);
    createEReference(labeledStatementEClass, LABELED_STATEMENT__EXPR);
    createEAttribute(labeledStatementEClass, LABELED_STATEMENT__MYDEFAULT);

    compoundStatementEClass = createEClass(COMPOUND_STATEMENT);
    createEReference(compoundStatementEClass, COMPOUND_STATEMENT__BODY);

    bodyStatementEClass = createEClass(BODY_STATEMENT);
    createEReference(bodyStatementEClass, BODY_STATEMENT__BLOCK_LIST);

    expressionStatementEClass = createEClass(EXPRESSION_STATEMENT);
    createEReference(expressionStatementEClass, EXPRESSION_STATEMENT__EXPRESSION);
    createEAttribute(expressionStatementEClass, EXPRESSION_STATEMENT__SEMI);

    selectionStatementEClass = createEClass(SELECTION_STATEMENT);
    createEAttribute(selectionStatementEClass, SELECTION_STATEMENT__IF);
    createEReference(selectionStatementEClass, SELECTION_STATEMENT__EXPR);
    createEReference(selectionStatementEClass, SELECTION_STATEMENT__IF_STATEMENT);
    createEAttribute(selectionStatementEClass, SELECTION_STATEMENT__ELSE);
    createEReference(selectionStatementEClass, SELECTION_STATEMENT__ELSE_STATEMENT);
    createEAttribute(selectionStatementEClass, SELECTION_STATEMENT__SWITCH);
    createEReference(selectionStatementEClass, SELECTION_STATEMENT__SWITCH_STATEMENT);

    iterationStatementEClass = createEClass(ITERATION_STATEMENT);
    createEAttribute(iterationStatementEClass, ITERATION_STATEMENT__WHILE);
    createEReference(iterationStatementEClass, ITERATION_STATEMENT__EXPR);
    createEReference(iterationStatementEClass, ITERATION_STATEMENT__STATEMENT);
    createEAttribute(iterationStatementEClass, ITERATION_STATEMENT__DO);
    createEAttribute(iterationStatementEClass, ITERATION_STATEMENT__SEMI);
    createEAttribute(iterationStatementEClass, ITERATION_STATEMENT__FOR);
    createEReference(iterationStatementEClass, ITERATION_STATEMENT__INIT_EXPR);
    createEReference(iterationStatementEClass, ITERATION_STATEMENT__INC_EXPR);
    createEReference(iterationStatementEClass, ITERATION_STATEMENT__INIT_DECL);

    jumpStatementEClass = createEClass(JUMP_STATEMENT);
    createEAttribute(jumpStatementEClass, JUMP_STATEMENT__CONTINUE);
    createEAttribute(jumpStatementEClass, JUMP_STATEMENT__SEMI);
    createEAttribute(jumpStatementEClass, JUMP_STATEMENT__BREAK);
    createEAttribute(jumpStatementEClass, JUMP_STATEMENT__RETURN);
    createEReference(jumpStatementEClass, JUMP_STATEMENT__EXPR);
    createEAttribute(jumpStatementEClass, JUMP_STATEMENT__GOTO);

    asmStatementEClass = createEClass(ASM_STATEMENT);
    createEAttribute(asmStatementEClass, ASM_STATEMENT__ASM);
    createEAttribute(asmStatementEClass, ASM_STATEMENT__VOLATILE);
    createEReference(asmStatementEClass, ASM_STATEMENT__ASM_LINE1);
    createEReference(asmStatementEClass, ASM_STATEMENT__ASM_LINES);
    createEAttribute(asmStatementEClass, ASM_STATEMENT__LAST_COMMA);
    createEAttribute(asmStatementEClass, ASM_STATEMENT__SEMI);

    assignmentExpressionEClass = createEClass(ASSIGNMENT_EXPRESSION);
    createEReference(assignmentExpressionEClass, ASSIGNMENT_EXPRESSION__EXPR);
    createEReference(assignmentExpressionEClass, ASSIGNMENT_EXPRESSION__OP);
    createEReference(assignmentExpressionEClass, ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPR);

    conditionalExpressionEClass = createEClass(CONDITIONAL_EXPRESSION);
    createEReference(conditionalExpressionEClass, CONDITIONAL_EXPRESSION__EXPR);
    createEReference(conditionalExpressionEClass, CONDITIONAL_EXPRESSION__QEXPR);
    createEReference(conditionalExpressionEClass, CONDITIONAL_EXPRESSION__CEXPR);

    logicalOrExpressionEClass = createEClass(LOGICAL_OR_EXPRESSION);
    createEReference(logicalOrExpressionEClass, LOGICAL_OR_EXPRESSION__EXPR);

    logicalAndExpressionEClass = createEClass(LOGICAL_AND_EXPRESSION);
    createEReference(logicalAndExpressionEClass, LOGICAL_AND_EXPRESSION__EXPR);

    inclusiveOrExpressionEClass = createEClass(INCLUSIVE_OR_EXPRESSION);
    createEReference(inclusiveOrExpressionEClass, INCLUSIVE_OR_EXPRESSION__EXPR);

    exclusiveOrExpressionEClass = createEClass(EXCLUSIVE_OR_EXPRESSION);
    createEReference(exclusiveOrExpressionEClass, EXCLUSIVE_OR_EXPRESSION__EXPR);

    andExpressionEClass = createEClass(AND_EXPRESSION);
    createEReference(andExpressionEClass, AND_EXPRESSION__EXPR);

    equalityExpressionEClass = createEClass(EQUALITY_EXPRESSION);
    createEReference(equalityExpressionEClass, EQUALITY_EXPRESSION__EXPR);
    createEAttribute(equalityExpressionEClass, EQUALITY_EXPRESSION__OP);

    relationalExpressionEClass = createEClass(RELATIONAL_EXPRESSION);
    createEReference(relationalExpressionEClass, RELATIONAL_EXPRESSION__EXPR);
    createEAttribute(relationalExpressionEClass, RELATIONAL_EXPRESSION__OP);

    shiftExpressionEClass = createEClass(SHIFT_EXPRESSION);
    createEReference(shiftExpressionEClass, SHIFT_EXPRESSION__EXPR);
    createEAttribute(shiftExpressionEClass, SHIFT_EXPRESSION__OP);

    additiveExpressionEClass = createEClass(ADDITIVE_EXPRESSION);
    createEReference(additiveExpressionEClass, ADDITIVE_EXPRESSION__EXPR);
    createEAttribute(additiveExpressionEClass, ADDITIVE_EXPRESSION__OP);

    multiplicativeExpressionEClass = createEClass(MULTIPLICATIVE_EXPRESSION);
    createEReference(multiplicativeExpressionEClass, MULTIPLICATIVE_EXPRESSION__EXPR);
    createEAttribute(multiplicativeExpressionEClass, MULTIPLICATIVE_EXPRESSION__OP);

    castExpressionEClass = createEClass(CAST_EXPRESSION);
    createEReference(castExpressionEClass, CAST_EXPRESSION__TYPE);
    createEReference(castExpressionEClass, CAST_EXPRESSION__EXPR);

    unaryExpressionEClass = createEClass(UNARY_EXPRESSION);
    createEReference(unaryExpressionEClass, UNARY_EXPRESSION__EXPR);
    createEAttribute(unaryExpressionEClass, UNARY_EXPRESSION__PLUSPLUS);
    createEAttribute(unaryExpressionEClass, UNARY_EXPRESSION__MINUSMINUS);
    createEReference(unaryExpressionEClass, UNARY_EXPRESSION__OP);
    createEAttribute(unaryExpressionEClass, UNARY_EXPRESSION__SIZE_OF);
    createEReference(unaryExpressionEClass, UNARY_EXPRESSION__TYPE_NAME);
    createEAttribute(unaryExpressionEClass, UNARY_EXPRESSION__ALIGN_OF);
    createEAttribute(unaryExpressionEClass, UNARY_EXPRESSION__ANDAND);
    createEAttribute(unaryExpressionEClass, UNARY_EXPRESSION__ID);

    postfixExpressionEClass = createEClass(POSTFIX_EXPRESSION);
    createEAttribute(postfixExpressionEClass, POSTFIX_EXPRESSION__EXT);
    createEReference(postfixExpressionEClass, POSTFIX_EXPRESSION__TYPE_NAME);
    createEReference(postfixExpressionEClass, POSTFIX_EXPRESSION__INITIALIZER_LIST);
    createEAttribute(postfixExpressionEClass, POSTFIX_EXPRESSION__COMMA);
    createEReference(postfixExpressionEClass, POSTFIX_EXPRESSION__EXPR);
    createEReference(postfixExpressionEClass, POSTFIX_EXPRESSION__SUFFIX);

    postfixExpressionSuffixArrayEClass = createEClass(POSTFIX_EXPRESSION_SUFFIX_ARRAY);
    createEReference(postfixExpressionSuffixArrayEClass, POSTFIX_EXPRESSION_SUFFIX_ARRAY__ARRAY_EXPR);

    postfixExpressionSuffixArgumentEClass = createEClass(POSTFIX_EXPRESSION_SUFFIX_ARGUMENT);
    createEReference(postfixExpressionSuffixArgumentEClass, POSTFIX_EXPRESSION_SUFFIX_ARGUMENT__ARGUMENT_EXPRESSION_LIST);

    postfixExpressionSuffixDotEClass = createEClass(POSTFIX_EXPRESSION_SUFFIX_DOT);
    createEAttribute(postfixExpressionSuffixDotEClass, POSTFIX_EXPRESSION_SUFFIX_DOT__ID);

    postfixExpressionSuffixArrowEClass = createEClass(POSTFIX_EXPRESSION_SUFFIX_ARROW);
    createEAttribute(postfixExpressionSuffixArrowEClass, POSTFIX_EXPRESSION_SUFFIX_ARROW__ID);

    postfixExpressionSuffixPlusPlusEClass = createEClass(POSTFIX_EXPRESSION_SUFFIX_PLUS_PLUS);

    postfixExpressionSuffixMinusMinusEClass = createEClass(POSTFIX_EXPRESSION_SUFFIX_MINUS_MINUS);

    primaryExpressionEClass = createEClass(PRIMARY_EXPRESSION);
    createEAttribute(primaryExpressionEClass, PRIMARY_EXPRESSION__ID);
    createEReference(primaryExpressionEClass, PRIMARY_EXPRESSION__CONST);
    createEAttribute(primaryExpressionEClass, PRIMARY_EXPRESSION__STRING);
    createEReference(primaryExpressionEClass, PRIMARY_EXPRESSION__EXPR);
    createEAttribute(primaryExpressionEClass, PRIMARY_EXPRESSION__EXT);
    createEReference(primaryExpressionEClass, PRIMARY_EXPRESSION__COMPOUND_STMT);
    createEAttribute(primaryExpressionEClass, PRIMARY_EXPRESSION__BUILTIN_OFFSETOF);
    createEReference(primaryExpressionEClass, PRIMARY_EXPRESSION__TYPE_NAME);
    createEAttribute(primaryExpressionEClass, PRIMARY_EXPRESSION__BUILTIN_TYPESCOMPATIBLEP);
    createEReference(primaryExpressionEClass, PRIMARY_EXPRESSION__TYPE_NAME2);

    constantExpressionEClass = createEClass(CONSTANT_EXPRESSION);
    createEReference(constantExpressionEClass, CONSTANT_EXPRESSION__EXPR);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
    CommonPackage theCommonPackage = (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    expressionEClass.getESuperTypes().add(theCommonPackage.getExpression());
    unaryOperatorEClass.getESuperTypes().add(theCommonPackage.getUnaryOperator());
    postfixExpressionSuffixEClass.getESuperTypes().add(theCommonPackage.getPostfixExpressionSuffix());
    argumentExpressionListEClass.getESuperTypes().add(theCommonPackage.getArgumentExpressionList());
    parserEClass.getESuperTypes().add(theCommonPackage.getParser());
    structOrUnionSpecifierEClass.getESuperTypes().add(this.getDeclarationSpecifier());
    enumSpecifierEClass.getESuperTypes().add(this.getDeclarationSpecifier());
    labeledStatementEClass.getESuperTypes().add(this.getStatement());
    compoundStatementEClass.getESuperTypes().add(this.getStatement());
    bodyStatementEClass.getESuperTypes().add(this.getStatement());
    expressionStatementEClass.getESuperTypes().add(this.getStatement());
    selectionStatementEClass.getESuperTypes().add(this.getStatement());
    iterationStatementEClass.getESuperTypes().add(this.getStatement());
    jumpStatementEClass.getESuperTypes().add(this.getStatement());
    asmStatementEClass.getESuperTypes().add(this.getStatement());
    assignmentExpressionEClass.getESuperTypes().add(this.getExpression());
    conditionalExpressionEClass.getESuperTypes().add(this.getExpression());
    logicalOrExpressionEClass.getESuperTypes().add(this.getExpression());
    logicalAndExpressionEClass.getESuperTypes().add(this.getExpression());
    inclusiveOrExpressionEClass.getESuperTypes().add(this.getExpression());
    exclusiveOrExpressionEClass.getESuperTypes().add(this.getExpression());
    andExpressionEClass.getESuperTypes().add(this.getExpression());
    equalityExpressionEClass.getESuperTypes().add(this.getExpression());
    relationalExpressionEClass.getESuperTypes().add(this.getExpression());
    shiftExpressionEClass.getESuperTypes().add(this.getExpression());
    additiveExpressionEClass.getESuperTypes().add(this.getExpression());
    multiplicativeExpressionEClass.getESuperTypes().add(this.getExpression());
    castExpressionEClass.getESuperTypes().add(this.getExpression());
    unaryExpressionEClass.getESuperTypes().add(this.getExpression());
    postfixExpressionEClass.getESuperTypes().add(this.getExpression());
    postfixExpressionSuffixArrayEClass.getESuperTypes().add(this.getPostfixExpressionSuffix());
    postfixExpressionSuffixArgumentEClass.getESuperTypes().add(this.getPostfixExpressionSuffix());
    postfixExpressionSuffixDotEClass.getESuperTypes().add(this.getPostfixExpressionSuffix());
    postfixExpressionSuffixArrowEClass.getESuperTypes().add(this.getPostfixExpressionSuffix());
    postfixExpressionSuffixPlusPlusEClass.getESuperTypes().add(this.getPostfixExpressionSuffix());
    postfixExpressionSuffixMinusMinusEClass.getESuperTypes().add(this.getPostfixExpressionSuffix());
    primaryExpressionEClass.getESuperTypes().add(this.getExpression());
    constantExpressionEClass.getESuperTypes().add(this.getExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(externalDeclarationEClass, ExternalDeclaration.class, "ExternalDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExternalDeclaration_FunctiondefHead(), this.getFunctionDefHead(), null, "functiondefHead", null, 0, 1, ExternalDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExternalDeclaration_FunctionDefinition(), this.getFunctionDefinition(), null, "functionDefinition", null, 0, 1, ExternalDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExternalDeclaration_Declaration(), this.getDeclaration(), null, "declaration", null, 0, 1, ExternalDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getExternalDeclaration_Semi(), theEcorePackage.getEString(), "semi", null, 0, 1, ExternalDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(functionDefHeadEClass, FunctionDefHead.class, "FunctionDefHead", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFunctionDefHead_FunDeclSpecifiers(), this.getFunctionDeclarationSpecifiers(), null, "funDeclSpecifiers", null, 0, 1, FunctionDefHead.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunctionDefHead_FunDeclarator(), this.getDeclarator(), null, "funDeclarator", null, 0, 1, FunctionDefHead.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunctionDefHead_FunDeclaration(), this.getDeclaration(), null, "funDeclaration", null, 0, -1, FunctionDefHead.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(functionDefinitionEClass, FunctionDefinition.class, "FunctionDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFunctionDefinition_Body(), this.getStatement(), null, "body", null, 0, 1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(declarationEClass, Declaration.class, "Declaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDeclaration_Specifiers(), this.getDeclarationSpecifiers(), null, "specifiers", null, 0, 1, Declaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDeclaration_InitDeclaratorList(), this.getInitDeclaratorList(), null, "initDeclaratorList", null, 0, -1, Declaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDeclaration_Semi(), theEcorePackage.getEString(), "semi", null, 0, 1, Declaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(functionDeclarationSpecifiersEClass, FunctionDeclarationSpecifiers.class, "FunctionDeclarationSpecifiers", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFunctionDeclarationSpecifiers_DeclarationSpecifier(), theEcorePackage.getEObject(), null, "declarationSpecifier", null, 0, -1, FunctionDeclarationSpecifiers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(declarationSpecifiersEClass, DeclarationSpecifiers.class, "DeclarationSpecifiers", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDeclarationSpecifiers_DeclarationSpecifier(), theEcorePackage.getEObject(), null, "declarationSpecifier", null, 0, -1, DeclarationSpecifiers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(initDeclaratorListEClass, InitDeclaratorList.class, "InitDeclaratorList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInitDeclaratorList_InitDeclarator(), this.getInitDeclarator(), null, "initDeclarator", null, 0, -1, InitDeclaratorList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(initDeclaratorEClass, InitDeclarator.class, "InitDeclarator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInitDeclarator_Declarator(), this.getDeclarator(), null, "declarator", null, 0, 1, InitDeclarator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInitDeclarator_Initializer(), this.getInitializer(), null, "initializer", null, 0, 1, InitDeclarator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(storageClassSpecifierEClass, StorageClassSpecifier.class, "StorageClassSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStorageClassSpecifier_Name(), theEcorePackage.getEString(), "name", null, 0, 1, StorageClassSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeSpecifierEClass, TypeSpecifier.class, "TypeSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTypeSpecifier_Name(), theEcorePackage.getEString(), "name", null, 0, 1, TypeSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTypeSpecifier_ExtType(), theEcorePackage.getEString(), "extType", null, 0, 1, TypeSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeSpecifier_Specifier(), this.getDeclarationSpecifier(), null, "specifier", null, 0, 1, TypeSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeSpecifier_Type(), this.getTypedefName(), null, "type", null, 0, 1, TypeSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTypeSpecifier_TypeOf(), theEcorePackage.getEString(), "typeOf", null, 0, 1, TypeSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeSpecifier_TypeName(), this.getTypeName(), null, "typeName", null, 0, 1, TypeSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeSpecifier_ConstExpr(), this.getExpression(), null, "constExpr", null, 0, 1, TypeSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typedefNameEClass, TypedefName.class, "TypedefName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTypedefName_Id(), theEcorePackage.getEString(), "id", null, 0, 1, TypedefName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(declarationSpecifierEClass, DeclarationSpecifier.class, "DeclarationSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDeclarationSpecifier_Id(), theEcorePackage.getEString(), "id", null, 0, 1, DeclarationSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(structOrUnionEClass, StructOrUnion.class, "StructOrUnion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStructOrUnion_Name(), theEcorePackage.getEString(), "name", null, 0, 1, StructOrUnion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(structDeclarationListEClass, StructDeclarationList.class, "StructDeclarationList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStructDeclarationList_StructDeclaration(), this.getStructDeclaration(), null, "structDeclaration", null, 0, -1, StructDeclarationList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(structDeclarationEClass, StructDeclaration.class, "StructDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStructDeclaration_List(), this.getSpecifierQualifierList(), null, "list", null, 0, 1, StructDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStructDeclaration_StructDeclarationList(), this.getStructDeclaratorList(), null, "structDeclarationList", null, 0, 1, StructDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(specifierQualifierListEClass, SpecifierQualifierList.class, "SpecifierQualifierList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSpecifierQualifierList_TypeSpecifier(), this.getTypeSpecifier(), null, "typeSpecifier", null, 0, -1, SpecifierQualifierList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSpecifierQualifierList_TypeQualifier(), this.getTypeQualifier(), null, "typeQualifier", null, 0, -1, SpecifierQualifierList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(structDeclaratorListEClass, StructDeclaratorList.class, "StructDeclaratorList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStructDeclaratorList_StructDeclarator(), this.getStructDeclarator(), null, "structDeclarator", null, 0, -1, StructDeclaratorList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(structDeclaratorEClass, StructDeclarator.class, "StructDeclarator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStructDeclarator_Declarator(), this.getDeclarator(), null, "declarator", null, 0, 1, StructDeclarator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStructDeclarator_ConstExpr(), this.getExpression(), null, "constExpr", null, 0, -1, StructDeclarator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(enumeratorListEClass, EnumeratorList.class, "EnumeratorList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEnumeratorList_Enumerator(), this.getEnumerator(), null, "enumerator", null, 0, -1, EnumeratorList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEnumeratorList_LastComma(), theEcorePackage.getEBoolean(), "lastComma", null, 0, 1, EnumeratorList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(enumeratorEClass, Enumerator.class, "Enumerator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEnumerator_Id(), theEcorePackage.getEString(), "id", null, 0, 1, Enumerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEnumerator_Expr(), this.getExpression(), null, "expr", null, 0, 1, Enumerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeQualifierEClass, TypeQualifier.class, "TypeQualifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTypeQualifier_Type(), theEcorePackage.getEString(), "type", null, 0, 1, TypeQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(functionSpecifierEClass, FunctionSpecifier.class, "FunctionSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFunctionSpecifier_Name(), theEcorePackage.getEString(), "name", null, 0, 1, FunctionSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunctionSpecifier_GccAttributeSpecifier(), this.getGccAttributeSpecifier(), null, "gccAttributeSpecifier", null, 0, 1, FunctionSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(declaratorEClass, Declarator.class, "Declarator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDeclarator_Pointer(), this.getPointer(), null, "pointer", null, 0, 1, Declarator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDeclarator_GccDeclExt1(), this.getGccDeclaratorExtension(), null, "gccDeclExt1", null, 0, -1, Declarator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDeclarator_Declarator(), this.getDirectDeclarator(), null, "declarator", null, 0, 1, Declarator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDeclarator_GccDeclExt2(), this.getGccDeclaratorExtension(), null, "gccDeclExt2", null, 0, -1, Declarator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(directDeclaratorEClass, DirectDeclarator.class, "DirectDeclarator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDirectDeclarator_Id(), theEcorePackage.getEString(), "id", null, 0, 1, DirectDeclarator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDirectDeclarator_Declarator(), this.getDeclarator(), null, "declarator", null, 0, 1, DirectDeclarator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDirectDeclarator_DeclaratorSuffix(), this.getDeclaratorSuffix(), null, "declaratorSuffix", null, 0, -1, DirectDeclarator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(declaratorSuffixEClass, DeclaratorSuffix.class, "DeclaratorSuffix", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDeclaratorSuffix_Expr(), this.getExpression(), null, "expr", null, 0, 1, DeclaratorSuffix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDeclaratorSuffix_LastSuffix(), this.getDirectDeclaratorLastSuffix(), null, "lastSuffix", null, 0, 1, DeclaratorSuffix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(directDeclaratorLastSuffixEClass, DirectDeclaratorLastSuffix.class, "DirectDeclaratorLastSuffix", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDirectDeclaratorLastSuffix_ParameterTypeList(), this.getParameterTypeList(), null, "parameterTypeList", null, 0, -1, DirectDeclaratorLastSuffix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDirectDeclaratorLastSuffix_IdentifierList(), this.getIdentifierList(), null, "identifierList", null, 0, 1, DirectDeclaratorLastSuffix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(gccDeclaratorExtensionEClass, GccDeclaratorExtension.class, "GccDeclaratorExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getGccDeclaratorExtension_Asm(), theEcorePackage.getEString(), "asm", null, 0, 1, GccDeclaratorExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getGccDeclaratorExtension_String(), theEcorePackage.getEString(), "string", null, 0, -1, GccDeclaratorExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGccDeclaratorExtension_GccAttributeSpecifier(), this.getGccAttributeSpecifier(), null, "gccAttributeSpecifier", null, 0, 1, GccDeclaratorExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(gccAttributeSpecifierEClass, GccAttributeSpecifier.class, "GccAttributeSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getGccAttributeSpecifier_Attribute(), theEcorePackage.getEString(), "attribute", null, 0, 1, GccAttributeSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGccAttributeSpecifier_List(), this.getGccAttributeList(), null, "list", null, 0, 1, GccAttributeSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(gccAttributeListEClass, GccAttributeList.class, "GccAttributeList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGccAttributeList_GccAttribute(), this.getGccAttribute(), null, "gccAttribute", null, 0, -1, GccAttributeList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(gccAttributeEClass, GccAttribute.class, "GccAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getGccAttribute_Id(), theEcorePackage.getEString(), "id", null, 0, 1, GccAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getGccAttribute_Const(), theEcorePackage.getEString(), "const", null, 0, 1, GccAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getGccAttribute_Keyword(), theEcorePackage.getEString(), "keyword", null, 0, 1, GccAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGccAttribute_List(), this.getArgumentExpressionList(), null, "list", null, 0, 1, GccAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pointerEClass, Pointer.class, "Pointer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPointer_Star(), theEcorePackage.getEString(), "star", null, 0, -1, Pointer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPointer_Caret(), theEcorePackage.getEString(), "caret", null, 0, -1, Pointer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPointer_TypeQualifierList(), this.getTypeQualifierList(), null, "typeQualifierList", null, 0, -1, Pointer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeQualifierListEClass, TypeQualifierList.class, "TypeQualifierList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeQualifierList_TypeQualifier(), this.getTypeQualifier(), null, "typeQualifier", null, 0, -1, TypeQualifierList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parameterTypeListEClass, ParameterTypeList.class, "ParameterTypeList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParameterTypeList_List(), this.getParameterList(), null, "list", null, 0, 1, ParameterTypeList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getParameterTypeList_Ellipsis(), theEcorePackage.getEBoolean(), "ellipsis", null, 0, 1, ParameterTypeList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parameterListEClass, ParameterList.class, "ParameterList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParameterList_ParameterDeclaration(), this.getParameterDeclaration(), null, "parameterDeclaration", null, 0, -1, ParameterList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parameterDeclarationEClass, ParameterDeclaration.class, "ParameterDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParameterDeclaration_DeclSpecifiers(), this.getDeclarationSpecifiers(), null, "declSpecifiers", null, 0, 1, ParameterDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getParameterDeclaration_Declarator(), this.getDeclarator(), null, "declarator", null, 0, 1, ParameterDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getParameterDeclaration_AbstractDeclator(), this.getAbstractDeclarator(), null, "abstractDeclator", null, 0, 1, ParameterDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(identifierListEClass, IdentifierList.class, "IdentifierList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIdentifierList_Id(), this.getMyIdentifier(), null, "id", null, 0, -1, IdentifierList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(myIdentifierEClass, MyIdentifier.class, "MyIdentifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMyIdentifier_Id(), theEcorePackage.getEString(), "id", null, 0, 1, MyIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeNameEClass, TypeName.class, "TypeName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeName_List(), this.getSpecifierQualifierList(), null, "list", null, 0, 1, TypeName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeName_AbstractDeclarator(), this.getAbstractDeclarator(), null, "abstractDeclarator", null, 0, 1, TypeName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractDeclaratorEClass, AbstractDeclarator.class, "AbstractDeclarator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAbstractDeclarator_Pointer(), this.getPointer(), null, "pointer", null, 0, 1, AbstractDeclarator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAbstractDeclarator_DirectAbstractDeclarator(), this.getDirectAbstractDeclarator(), null, "directAbstractDeclarator", null, 0, 1, AbstractDeclarator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAbstractDeclarator_GccDeclExtAbstract(), this.getGccDeclaratorExtension(), null, "gccDeclExtAbstract", null, 0, -1, AbstractDeclarator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(directAbstractDeclaratorEClass, DirectAbstractDeclarator.class, "DirectAbstractDeclarator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDirectAbstractDeclarator_Declarator(), this.getAbstractDeclarator(), null, "declarator", null, 0, 1, DirectAbstractDeclarator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDirectAbstractDeclarator_GccDeclExt(), this.getGccDeclaratorExtension(), null, "gccDeclExt", null, 0, -1, DirectAbstractDeclarator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDirectAbstractDeclarator_AbstractDeclaratorSuffix(), this.getAbstractDeclaratorSuffix(), null, "abstractDeclaratorSuffix", null, 0, -1, DirectAbstractDeclarator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractDeclaratorSuffixEClass, AbstractDeclaratorSuffix.class, "AbstractDeclaratorSuffix", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAbstractDeclaratorSuffix_TypeQualifierList(), this.getTypeQualifierList(), null, "typeQualifierList", null, 0, 1, AbstractDeclaratorSuffix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAbstractDeclaratorSuffix_AssignmentExpr(), this.getExpression(), null, "assignmentExpr", null, 0, -1, AbstractDeclaratorSuffix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAbstractDeclaratorSuffix_TypeQualifierListOrig(), this.getTypeQualifierList(), null, "typeQualifierListOrig", null, 0, 1, AbstractDeclaratorSuffix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAbstractDeclaratorSuffix_ParameterTypeList(), this.getParameterTypeList(), null, "parameterTypeList", null, 0, 1, AbstractDeclaratorSuffix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAbstractDeclaratorSuffix_GccDeclExt(), this.getGccDeclaratorExtension(), null, "gccDeclExt", null, 0, -1, AbstractDeclaratorSuffix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(initializerEClass, Initializer.class, "Initializer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInitializer_Expr(), this.getExpression(), null, "expr", null, 0, 1, Initializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInitializer_List(), this.getInitializerList(), null, "list", null, 0, 1, Initializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getInitializer_LastComma(), theEcorePackage.getEBoolean(), "lastComma", null, 0, 1, Initializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(initializerListEClass, InitializerList.class, "InitializerList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInitializerList_Init(), this.getInit(), null, "init", null, 0, -1, InitializerList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(initEClass, Init.class, "Init", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInit_Designation(), this.getDesignation(), null, "designation", null, 0, 1, Init.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInit_Initializer(), this.getInitializer(), null, "initializer", null, 0, 1, Init.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(blockListEClass, BlockList.class, "BlockList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBlockList_Declaration(), this.getDeclaration(), null, "declaration", null, 0, -1, BlockList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBlockList_Statement(), this.getStatement(), null, "statement", null, 0, -1, BlockList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(statementEClass, Statement.class, "Statement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStatement_Stmt(), this.getStatement(), null, "stmt", null, 0, 1, Statement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asmLineEClass, AsmLine.class, "AsmLine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAsmLine_Sym(), this.getAsmSymbolicName(), null, "sym", null, 0, 1, AsmLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAsmLine_Expr(), this.getExpression(), null, "expr", null, 0, 1, AsmLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asmSymbolicNameEClass, AsmSymbolicName.class, "AsmSymbolicName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAsmSymbolicName_Id(), theEcorePackage.getEString(), "id", null, 0, 1, AsmSymbolicName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asmLineWithColonEClass, AsmLineWithColon.class, "AsmLineWithColon", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAsmLineWithColon_AsmLine(), this.getAsmLineWithoutColon(), null, "asmLine", null, 0, 1, AsmLineWithColon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asmLineWithoutColonEClass, AsmLineWithoutColon.class, "AsmLineWithoutColon", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAsmLineWithoutColon_AsmLines(), this.getAsmLine(), null, "asmLines", null, 0, -1, AsmLineWithoutColon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(designationEClass, Designation.class, "Designation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDesignation_List(), this.getDesignatorList(), null, "list", null, 0, 1, Designation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(designatorListEClass, DesignatorList.class, "DesignatorList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDesignatorList_Designator(), this.getDesignator(), null, "designator", null, 0, -1, DesignatorList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(designatorEClass, Designator.class, "Designator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDesignator_Expr(), this.getExpression(), null, "expr", null, 0, 1, Designator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDesignator_To(), this.getExpression(), null, "to", null, 0, 1, Designator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDesignator_Id(), theEcorePackage.getEString(), "id", null, 0, 1, Designator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpression_ExprExpr(), this.getExpression(), null, "exprExpr", null, 0, -1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(assignmentOperatorEClass, AssignmentOperator.class, "AssignmentOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAssignmentOperator_Op(), theEcorePackage.getEString(), "op", null, 0, 1, AssignmentOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unaryOperatorEClass, UnaryOperator.class, "UnaryOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(postfixExpressionSuffixEClass, PostfixExpressionSuffix.class, "PostfixExpressionSuffix", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(argumentExpressionListEClass, ArgumentExpressionList.class, "ArgumentExpressionList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(parserEClass, Parser.class, "Parser", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParser_External(), this.getExternalDeclaration(), null, "external", null, 0, -1, Parser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(structOrUnionSpecifierEClass, StructOrUnionSpecifier.class, "StructOrUnionSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStructOrUnionSpecifier_Type(), this.getStructOrUnion(), null, "type", null, 0, 1, StructOrUnionSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStructOrUnionSpecifier_Braces(), theEcorePackage.getEBoolean(), "braces", null, 0, 1, StructOrUnionSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStructOrUnionSpecifier_StructDeclList(), this.getStructDeclarationList(), null, "structDeclList", null, 0, 1, StructOrUnionSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(enumSpecifierEClass, EnumSpecifier.class, "EnumSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEnumSpecifier_EnumList(), this.getEnumeratorList(), null, "enumList", null, 0, 1, EnumSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(labeledStatementEClass, LabeledStatement.class, "LabeledStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLabeledStatement_Id(), theEcorePackage.getEString(), "id", null, 0, 1, LabeledStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLabeledStatement_LStmt(), this.getStatement(), null, "lStmt", null, 0, 1, LabeledStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLabeledStatement_Case(), theEcorePackage.getEString(), "case", null, 0, 1, LabeledStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLabeledStatement_Lower(), theEcorePackage.getEString(), "lower", null, 0, 1, LabeledStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLabeledStatement_Higher(), theEcorePackage.getEString(), "higher", null, 0, 1, LabeledStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLabeledStatement_Expr(), this.getExpression(), null, "expr", null, 0, 1, LabeledStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLabeledStatement_Mydefault(), theEcorePackage.getEBoolean(), "mydefault", null, 0, 1, LabeledStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(compoundStatementEClass, CompoundStatement.class, "CompoundStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCompoundStatement_Body(), this.getStatement(), null, "body", null, 0, 1, CompoundStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(bodyStatementEClass, BodyStatement.class, "BodyStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBodyStatement_BlockList(), this.getBlockList(), null, "blockList", null, 0, -1, BodyStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionStatementEClass, ExpressionStatement.class, "ExpressionStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpressionStatement_Expression(), this.getExpression(), null, "expression", null, 0, 1, ExpressionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getExpressionStatement_Semi(), theEcorePackage.getEString(), "semi", null, 0, 1, ExpressionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(selectionStatementEClass, SelectionStatement.class, "SelectionStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSelectionStatement_If(), theEcorePackage.getEString(), "if", null, 0, 1, SelectionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSelectionStatement_Expr(), this.getExpression(), null, "expr", null, 0, 1, SelectionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSelectionStatement_IfStatement(), this.getStatement(), null, "ifStatement", null, 0, 1, SelectionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSelectionStatement_Else(), theEcorePackage.getEString(), "else", null, 0, 1, SelectionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSelectionStatement_ElseStatement(), this.getStatement(), null, "elseStatement", null, 0, 1, SelectionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSelectionStatement_Switch(), theEcorePackage.getEString(), "switch", null, 0, 1, SelectionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSelectionStatement_SwitchStatement(), this.getStatement(), null, "switchStatement", null, 0, 1, SelectionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(iterationStatementEClass, IterationStatement.class, "IterationStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIterationStatement_While(), theEcorePackage.getEString(), "while", null, 0, 1, IterationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIterationStatement_Expr(), this.getExpression(), null, "expr", null, 0, 1, IterationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIterationStatement_Statement(), this.getStatement(), null, "statement", null, 0, 1, IterationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIterationStatement_Do(), theEcorePackage.getEString(), "do", null, 0, 1, IterationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIterationStatement_Semi(), theEcorePackage.getEString(), "semi", null, 0, 1, IterationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIterationStatement_For(), theEcorePackage.getEString(), "for", null, 0, 1, IterationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIterationStatement_InitExpr(), this.getExpression(), null, "initExpr", null, 0, 1, IterationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIterationStatement_IncExpr(), this.getExpression(), null, "incExpr", null, 0, 1, IterationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIterationStatement_InitDecl(), this.getDeclaration(), null, "initDecl", null, 0, 1, IterationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(jumpStatementEClass, JumpStatement.class, "JumpStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getJumpStatement_Continue(), theEcorePackage.getEString(), "continue", null, 0, 1, JumpStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getJumpStatement_Semi(), theEcorePackage.getEString(), "semi", null, 0, 1, JumpStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getJumpStatement_Break(), theEcorePackage.getEString(), "break", null, 0, 1, JumpStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getJumpStatement_Return(), theEcorePackage.getEString(), "return", null, 0, 1, JumpStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getJumpStatement_Expr(), this.getExpression(), null, "expr", null, 0, 1, JumpStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getJumpStatement_Goto(), theEcorePackage.getEString(), "goto", null, 0, 1, JumpStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asmStatementEClass, AsmStatement.class, "AsmStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAsmStatement_Asm(), theEcorePackage.getEString(), "asm", null, 0, 1, AsmStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAsmStatement_Volatile(), theEcorePackage.getEString(), "volatile", null, 0, 1, AsmStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAsmStatement_AsmLine1(), this.getAsmLine(), null, "asmLine1", null, 0, 1, AsmStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAsmStatement_AsmLines(), this.getAsmLineWithColon(), null, "asmLines", null, 0, -1, AsmStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAsmStatement_LastComma(), theEcorePackage.getEBoolean(), "lastComma", null, 0, 1, AsmStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAsmStatement_Semi(), theEcorePackage.getEString(), "semi", null, 0, 1, AsmStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(assignmentExpressionEClass, AssignmentExpression.class, "AssignmentExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAssignmentExpression_Expr(), this.getExpression(), null, "expr", null, 0, 1, AssignmentExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssignmentExpression_Op(), this.getAssignmentOperator(), null, "op", null, 0, 1, AssignmentExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssignmentExpression_AssignmentExpr(), this.getExpression(), null, "assignmentExpr", null, 0, 1, AssignmentExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(conditionalExpressionEClass, ConditionalExpression.class, "ConditionalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConditionalExpression_Expr(), this.getExpression(), null, "expr", null, 0, 1, ConditionalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConditionalExpression_QExpr(), this.getExpression(), null, "qExpr", null, 0, 1, ConditionalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConditionalExpression_CExpr(), this.getExpression(), null, "cExpr", null, 0, 1, ConditionalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(logicalOrExpressionEClass, LogicalOrExpression.class, "LogicalOrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLogicalOrExpression_Expr(), this.getExpression(), null, "expr", null, 0, -1, LogicalOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(logicalAndExpressionEClass, LogicalAndExpression.class, "LogicalAndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLogicalAndExpression_Expr(), this.getExpression(), null, "expr", null, 0, -1, LogicalAndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(inclusiveOrExpressionEClass, InclusiveOrExpression.class, "InclusiveOrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInclusiveOrExpression_Expr(), this.getExpression(), null, "expr", null, 0, -1, InclusiveOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(exclusiveOrExpressionEClass, ExclusiveOrExpression.class, "ExclusiveOrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExclusiveOrExpression_Expr(), this.getExpression(), null, "expr", null, 0, -1, ExclusiveOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(andExpressionEClass, AndExpression.class, "AndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAndExpression_Expr(), this.getExpression(), null, "expr", null, 0, -1, AndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(equalityExpressionEClass, EqualityExpression.class, "EqualityExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEqualityExpression_Expr(), this.getExpression(), null, "expr", null, 0, -1, EqualityExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEqualityExpression_Op(), theEcorePackage.getEString(), "op", null, 0, -1, EqualityExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(relationalExpressionEClass, RelationalExpression.class, "RelationalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRelationalExpression_Expr(), this.getExpression(), null, "expr", null, 0, -1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRelationalExpression_Op(), theEcorePackage.getEString(), "op", null, 0, -1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(shiftExpressionEClass, ShiftExpression.class, "ShiftExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getShiftExpression_Expr(), this.getExpression(), null, "expr", null, 0, -1, ShiftExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getShiftExpression_Op(), theEcorePackage.getEString(), "op", null, 0, -1, ShiftExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(additiveExpressionEClass, AdditiveExpression.class, "AdditiveExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAdditiveExpression_Expr(), this.getExpression(), null, "expr", null, 0, -1, AdditiveExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAdditiveExpression_Op(), theEcorePackage.getEString(), "op", null, 0, -1, AdditiveExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(multiplicativeExpressionEClass, MultiplicativeExpression.class, "MultiplicativeExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMultiplicativeExpression_Expr(), this.getExpression(), null, "expr", null, 0, -1, MultiplicativeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMultiplicativeExpression_Op(), theEcorePackage.getEString(), "op", null, 0, -1, MultiplicativeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(castExpressionEClass, CastExpression.class, "CastExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCastExpression_Type(), this.getTypeName(), null, "type", null, 0, 1, CastExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCastExpression_Expr(), this.getExpression(), null, "expr", null, 0, 1, CastExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unaryExpressionEClass, UnaryExpression.class, "UnaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUnaryExpression_Expr(), this.getExpression(), null, "expr", null, 0, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnaryExpression_Plusplus(), theEcorePackage.getEString(), "plusplus", null, 0, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnaryExpression_Minusminus(), theEcorePackage.getEString(), "minusminus", null, 0, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUnaryExpression_Op(), this.getUnaryOperator(), null, "op", null, 0, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnaryExpression_SizeOf(), theEcorePackage.getEString(), "sizeOf", null, 0, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUnaryExpression_TypeName(), this.getTypeName(), null, "typeName", null, 0, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnaryExpression_AlignOf(), theEcorePackage.getEString(), "alignOf", null, 0, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnaryExpression_Andand(), theEcorePackage.getEString(), "andand", null, 0, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnaryExpression_Id(), theEcorePackage.getEString(), "id", null, 0, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(postfixExpressionEClass, PostfixExpression.class, "PostfixExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPostfixExpression_Ext(), theEcorePackage.getEBoolean(), "ext", null, 0, 1, PostfixExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPostfixExpression_TypeName(), this.getTypeName(), null, "typeName", null, 0, 1, PostfixExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPostfixExpression_InitializerList(), this.getInitializerList(), null, "initializerList", null, 0, 1, PostfixExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPostfixExpression_Comma(), theEcorePackage.getEBoolean(), "comma", null, 0, 1, PostfixExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPostfixExpression_Expr(), this.getExpression(), null, "expr", null, 0, -1, PostfixExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPostfixExpression_Suffix(), this.getPostfixExpressionSuffix(), null, "suffix", null, 0, -1, PostfixExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(postfixExpressionSuffixArrayEClass, PostfixExpressionSuffixArray.class, "PostfixExpressionSuffixArray", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPostfixExpressionSuffixArray_ArrayExpr(), this.getExpression(), null, "arrayExpr", null, 0, 1, PostfixExpressionSuffixArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(postfixExpressionSuffixArgumentEClass, PostfixExpressionSuffixArgument.class, "PostfixExpressionSuffixArgument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPostfixExpressionSuffixArgument_ArgumentExpressionList(), this.getArgumentExpressionList(), null, "argumentExpressionList", null, 0, 1, PostfixExpressionSuffixArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(postfixExpressionSuffixDotEClass, PostfixExpressionSuffixDot.class, "PostfixExpressionSuffixDot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPostfixExpressionSuffixDot_Id(), theEcorePackage.getEString(), "id", null, 0, 1, PostfixExpressionSuffixDot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(postfixExpressionSuffixArrowEClass, PostfixExpressionSuffixArrow.class, "PostfixExpressionSuffixArrow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPostfixExpressionSuffixArrow_Id(), theEcorePackage.getEString(), "id", null, 0, 1, PostfixExpressionSuffixArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(postfixExpressionSuffixPlusPlusEClass, PostfixExpressionSuffixPlusPlus.class, "PostfixExpressionSuffixPlusPlus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(postfixExpressionSuffixMinusMinusEClass, PostfixExpressionSuffixMinusMinus.class, "PostfixExpressionSuffixMinusMinus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(primaryExpressionEClass, PrimaryExpression.class, "PrimaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPrimaryExpression_Id(), theEcorePackage.getEString(), "id", null, 0, 1, PrimaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPrimaryExpression_Const(), theCommonPackage.getConstant2(), null, "const", null, 0, 1, PrimaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPrimaryExpression_String(), theEcorePackage.getEString(), "string", null, 0, -1, PrimaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPrimaryExpression_Expr(), this.getExpression(), null, "expr", null, 0, 1, PrimaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPrimaryExpression_Ext(), theEcorePackage.getEBoolean(), "ext", null, 0, 1, PrimaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPrimaryExpression_CompoundStmt(), this.getStatement(), null, "compoundStmt", null, 0, 1, PrimaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPrimaryExpression_Builtin_offsetof(), theEcorePackage.getEBoolean(), "builtin_offsetof", null, 0, 1, PrimaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPrimaryExpression_TypeName(), this.getTypeName(), null, "typeName", null, 0, 1, PrimaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPrimaryExpression_Builtin_typescompatiblep(), theEcorePackage.getEBoolean(), "builtin_typescompatiblep", null, 0, 1, PrimaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPrimaryExpression_TypeName2(), this.getTypeName(), null, "typeName2", null, 0, 1, PrimaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(constantExpressionEClass, ConstantExpression.class, "ConstantExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConstantExpression_Expr(), this.getExpression(), null, "expr", null, 0, 1, ConstantExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //ParserPackageImpl
