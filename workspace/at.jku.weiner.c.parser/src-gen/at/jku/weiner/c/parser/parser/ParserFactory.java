/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see at.jku.weiner.c.parser.parser.ParserPackage
 * @generated
 */
public interface ParserFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ParserFactory eINSTANCE = at.jku.weiner.c.parser.parser.impl.ParserFactoryImpl.init();

  /**
   * Returns a new object of class '<em>External Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>External Declaration</em>'.
   * @generated
   */
  ExternalDeclaration createExternalDeclaration();

  /**
   * Returns a new object of class '<em>Function Def Head</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function Def Head</em>'.
   * @generated
   */
  FunctionDefHead createFunctionDefHead();

  /**
   * Returns a new object of class '<em>Function Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function Definition</em>'.
   * @generated
   */
  FunctionDefinition createFunctionDefinition();

  /**
   * Returns a new object of class '<em>Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Declaration</em>'.
   * @generated
   */
  Declaration createDeclaration();

  /**
   * Returns a new object of class '<em>Function Declaration Specifiers</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function Declaration Specifiers</em>'.
   * @generated
   */
  FunctionDeclarationSpecifiers createFunctionDeclarationSpecifiers();

  /**
   * Returns a new object of class '<em>Declaration Specifiers</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Declaration Specifiers</em>'.
   * @generated
   */
  DeclarationSpecifiers createDeclarationSpecifiers();

  /**
   * Returns a new object of class '<em>Init Declarator List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Init Declarator List</em>'.
   * @generated
   */
  InitDeclaratorList createInitDeclaratorList();

  /**
   * Returns a new object of class '<em>Init Declarator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Init Declarator</em>'.
   * @generated
   */
  InitDeclarator createInitDeclarator();

  /**
   * Returns a new object of class '<em>Storage Class Specifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Storage Class Specifier</em>'.
   * @generated
   */
  StorageClassSpecifier createStorageClassSpecifier();

  /**
   * Returns a new object of class '<em>Type Specifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Specifier</em>'.
   * @generated
   */
  TypeSpecifier createTypeSpecifier();

  /**
   * Returns a new object of class '<em>Typedef Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Typedef Name</em>'.
   * @generated
   */
  TypedefName createTypedefName();

  /**
   * Returns a new object of class '<em>Struct Or Union Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Struct Or Union Name</em>'.
   * @generated
   */
  StructOrUnionName createStructOrUnionName();

  /**
   * Returns a new object of class '<em>Declaration Specifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Declaration Specifier</em>'.
   * @generated
   */
  DeclarationSpecifier createDeclarationSpecifier();

  /**
   * Returns a new object of class '<em>Struct Or Union</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Struct Or Union</em>'.
   * @generated
   */
  StructOrUnion createStructOrUnion();

  /**
   * Returns a new object of class '<em>Struct Declaration List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Struct Declaration List</em>'.
   * @generated
   */
  StructDeclarationList createStructDeclarationList();

  /**
   * Returns a new object of class '<em>Struct Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Struct Declaration</em>'.
   * @generated
   */
  StructDeclaration createStructDeclaration();

  /**
   * Returns a new object of class '<em>Specifier Qualifier List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Specifier Qualifier List</em>'.
   * @generated
   */
  SpecifierQualifierList createSpecifierQualifierList();

  /**
   * Returns a new object of class '<em>Struct Declarator List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Struct Declarator List</em>'.
   * @generated
   */
  StructDeclaratorList createStructDeclaratorList();

  /**
   * Returns a new object of class '<em>Struct Declarator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Struct Declarator</em>'.
   * @generated
   */
  StructDeclarator createStructDeclarator();

  /**
   * Returns a new object of class '<em>Enumerator List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enumerator List</em>'.
   * @generated
   */
  EnumeratorList createEnumeratorList();

  /**
   * Returns a new object of class '<em>Enumerator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enumerator</em>'.
   * @generated
   */
  Enumerator createEnumerator();

  /**
   * Returns a new object of class '<em>Type Qualifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Qualifier</em>'.
   * @generated
   */
  TypeQualifier createTypeQualifier();

  /**
   * Returns a new object of class '<em>Function Specifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function Specifier</em>'.
   * @generated
   */
  FunctionSpecifier createFunctionSpecifier();

  /**
   * Returns a new object of class '<em>Declarator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Declarator</em>'.
   * @generated
   */
  Declarator createDeclarator();

  /**
   * Returns a new object of class '<em>Direct Declarator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Direct Declarator</em>'.
   * @generated
   */
  DirectDeclarator createDirectDeclarator();

  /**
   * Returns a new object of class '<em>Declarator Suffix</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Declarator Suffix</em>'.
   * @generated
   */
  DeclaratorSuffix createDeclaratorSuffix();

  /**
   * Returns a new object of class '<em>Direct Declarator Last Suffix</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Direct Declarator Last Suffix</em>'.
   * @generated
   */
  DirectDeclaratorLastSuffix createDirectDeclaratorLastSuffix();

  /**
   * Returns a new object of class '<em>Gcc Declarator Extension</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Gcc Declarator Extension</em>'.
   * @generated
   */
  GccDeclaratorExtension createGccDeclaratorExtension();

  /**
   * Returns a new object of class '<em>Gcc Attribute Specifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Gcc Attribute Specifier</em>'.
   * @generated
   */
  GccAttributeSpecifier createGccAttributeSpecifier();

  /**
   * Returns a new object of class '<em>Gcc Attribute List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Gcc Attribute List</em>'.
   * @generated
   */
  GccAttributeList createGccAttributeList();

  /**
   * Returns a new object of class '<em>Gcc Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Gcc Attribute</em>'.
   * @generated
   */
  GccAttribute createGccAttribute();

  /**
   * Returns a new object of class '<em>Pointer</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pointer</em>'.
   * @generated
   */
  Pointer createPointer();

  /**
   * Returns a new object of class '<em>Type Qualifier List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Qualifier List</em>'.
   * @generated
   */
  TypeQualifierList createTypeQualifierList();

  /**
   * Returns a new object of class '<em>Parameter Type List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter Type List</em>'.
   * @generated
   */
  ParameterTypeList createParameterTypeList();

  /**
   * Returns a new object of class '<em>Parameter List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter List</em>'.
   * @generated
   */
  ParameterList createParameterList();

  /**
   * Returns a new object of class '<em>Parameter Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter Declaration</em>'.
   * @generated
   */
  ParameterDeclaration createParameterDeclaration();

  /**
   * Returns a new object of class '<em>Identifier List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Identifier List</em>'.
   * @generated
   */
  IdentifierList createIdentifierList();

  /**
   * Returns a new object of class '<em>My Identifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>My Identifier</em>'.
   * @generated
   */
  MyIdentifier createMyIdentifier();

  /**
   * Returns a new object of class '<em>Type Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Name</em>'.
   * @generated
   */
  TypeName createTypeName();

  /**
   * Returns a new object of class '<em>Abstract Declarator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Declarator</em>'.
   * @generated
   */
  AbstractDeclarator createAbstractDeclarator();

  /**
   * Returns a new object of class '<em>Initializer</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Initializer</em>'.
   * @generated
   */
  Initializer createInitializer();

  /**
   * Returns a new object of class '<em>Initializer List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Initializer List</em>'.
   * @generated
   */
  InitializerList createInitializerList();

  /**
   * Returns a new object of class '<em>Block List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Block List</em>'.
   * @generated
   */
  BlockList createBlockList();

  /**
   * Returns a new object of class '<em>Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Statement</em>'.
   * @generated
   */
  Statement createStatement();

  /**
   * Returns a new object of class '<em>Asm Line Without Colon</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Asm Line Without Colon</em>'.
   * @generated
   */
  AsmLineWithoutColon createAsmLineWithoutColon();

  /**
   * Returns a new object of class '<em>Asm Line</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Asm Line</em>'.
   * @generated
   */
  AsmLine createAsmLine();

  /**
   * Returns a new object of class '<em>Asm Line With Colon</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Asm Line With Colon</em>'.
   * @generated
   */
  AsmLineWithColon createAsmLineWithColon();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Assignment Operator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assignment Operator</em>'.
   * @generated
   */
  AssignmentOperator createAssignmentOperator();

  /**
   * Returns a new object of class '<em>Unary Operator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unary Operator</em>'.
   * @generated
   */
  UnaryOperator createUnaryOperator();

  /**
   * Returns a new object of class '<em>Postfix Expression Suffix</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Postfix Expression Suffix</em>'.
   * @generated
   */
  PostfixExpressionSuffix createPostfixExpressionSuffix();

  /**
   * Returns a new object of class '<em>Argument Expression List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Argument Expression List</em>'.
   * @generated
   */
  ArgumentExpressionList createArgumentExpressionList();

  /**
   * Returns a new object of class '<em>Parser</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parser</em>'.
   * @generated
   */
  Parser createParser();

  /**
   * Returns a new object of class '<em>Struct Or Union Specifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Struct Or Union Specifier</em>'.
   * @generated
   */
  StructOrUnionSpecifier createStructOrUnionSpecifier();

  /**
   * Returns a new object of class '<em>Enum Specifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum Specifier</em>'.
   * @generated
   */
  EnumSpecifier createEnumSpecifier();

  /**
   * Returns a new object of class '<em>Labeled Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Labeled Statement</em>'.
   * @generated
   */
  LabeledStatement createLabeledStatement();

  /**
   * Returns a new object of class '<em>Compound Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Compound Statement</em>'.
   * @generated
   */
  CompoundStatement createCompoundStatement();

  /**
   * Returns a new object of class '<em>Body Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Body Statement</em>'.
   * @generated
   */
  BodyStatement createBodyStatement();

  /**
   * Returns a new object of class '<em>Expression Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression Statement</em>'.
   * @generated
   */
  ExpressionStatement createExpressionStatement();

  /**
   * Returns a new object of class '<em>Selection Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Selection Statement</em>'.
   * @generated
   */
  SelectionStatement createSelectionStatement();

  /**
   * Returns a new object of class '<em>Iteration Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Iteration Statement</em>'.
   * @generated
   */
  IterationStatement createIterationStatement();

  /**
   * Returns a new object of class '<em>Jump Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Jump Statement</em>'.
   * @generated
   */
  JumpStatement createJumpStatement();

  /**
   * Returns a new object of class '<em>Asm Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Asm Statement</em>'.
   * @generated
   */
  AsmStatement createAsmStatement();

  /**
   * Returns a new object of class '<em>Assignment Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assignment Expression</em>'.
   * @generated
   */
  AssignmentExpression createAssignmentExpression();

  /**
   * Returns a new object of class '<em>Conditional Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Conditional Expression</em>'.
   * @generated
   */
  ConditionalExpression createConditionalExpression();

  /**
   * Returns a new object of class '<em>Logical Or Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Logical Or Expression</em>'.
   * @generated
   */
  LogicalOrExpression createLogicalOrExpression();

  /**
   * Returns a new object of class '<em>Logical And Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Logical And Expression</em>'.
   * @generated
   */
  LogicalAndExpression createLogicalAndExpression();

  /**
   * Returns a new object of class '<em>Inclusive Or Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Inclusive Or Expression</em>'.
   * @generated
   */
  InclusiveOrExpression createInclusiveOrExpression();

  /**
   * Returns a new object of class '<em>Exclusive Or Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Exclusive Or Expression</em>'.
   * @generated
   */
  ExclusiveOrExpression createExclusiveOrExpression();

  /**
   * Returns a new object of class '<em>And Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>And Expression</em>'.
   * @generated
   */
  AndExpression createAndExpression();

  /**
   * Returns a new object of class '<em>Equality Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Equality Expression</em>'.
   * @generated
   */
  EqualityExpression createEqualityExpression();

  /**
   * Returns a new object of class '<em>Relational Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Relational Expression</em>'.
   * @generated
   */
  RelationalExpression createRelationalExpression();

  /**
   * Returns a new object of class '<em>Shift Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Shift Expression</em>'.
   * @generated
   */
  ShiftExpression createShiftExpression();

  /**
   * Returns a new object of class '<em>Additive Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Additive Expression</em>'.
   * @generated
   */
  AdditiveExpression createAdditiveExpression();

  /**
   * Returns a new object of class '<em>Multiplicative Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiplicative Expression</em>'.
   * @generated
   */
  MultiplicativeExpression createMultiplicativeExpression();

  /**
   * Returns a new object of class '<em>Cast Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cast Expression</em>'.
   * @generated
   */
  CastExpression createCastExpression();

  /**
   * Returns a new object of class '<em>Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unary Expression</em>'.
   * @generated
   */
  UnaryExpression createUnaryExpression();

  /**
   * Returns a new object of class '<em>Postfix Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Postfix Expression</em>'.
   * @generated
   */
  PostfixExpression createPostfixExpression();

  /**
   * Returns a new object of class '<em>Postfix Expression Suffix Array</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Postfix Expression Suffix Array</em>'.
   * @generated
   */
  PostfixExpressionSuffixArray createPostfixExpressionSuffixArray();

  /**
   * Returns a new object of class '<em>Postfix Expression Suffix Argument</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Postfix Expression Suffix Argument</em>'.
   * @generated
   */
  PostfixExpressionSuffixArgument createPostfixExpressionSuffixArgument();

  /**
   * Returns a new object of class '<em>Postfix Expression Suffix Dot</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Postfix Expression Suffix Dot</em>'.
   * @generated
   */
  PostfixExpressionSuffixDot createPostfixExpressionSuffixDot();

  /**
   * Returns a new object of class '<em>Postfix Expression Suffix Arrow</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Postfix Expression Suffix Arrow</em>'.
   * @generated
   */
  PostfixExpressionSuffixArrow createPostfixExpressionSuffixArrow();

  /**
   * Returns a new object of class '<em>Postfix Expression Suffix Plus Plus</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Postfix Expression Suffix Plus Plus</em>'.
   * @generated
   */
  PostfixExpressionSuffixPlusPlus createPostfixExpressionSuffixPlusPlus();

  /**
   * Returns a new object of class '<em>Postfix Expression Suffix Minus Minus</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Postfix Expression Suffix Minus Minus</em>'.
   * @generated
   */
  PostfixExpressionSuffixMinusMinus createPostfixExpressionSuffixMinusMinus();

  /**
   * Returns a new object of class '<em>Primary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Primary Expression</em>'.
   * @generated
   */
  PrimaryExpression createPrimaryExpression();

  /**
   * Returns a new object of class '<em>Constant Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constant Expression</em>'.
   * @generated
   */
  ConstantExpression createConstantExpression();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ParserPackage getParserPackage();

} //ParserFactory
