/**
 */
package at.jku.weiner.c.parser.parser.util;

import at.jku.weiner.c.parser.parser.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see at.jku.weiner.c.parser.parser.ParserPackage
 * @generated
 */
public class ParserSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ParserPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParserSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = ParserPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case ParserPackage.EXTERNAL_DECLARATION:
      {
        ExternalDeclaration externalDeclaration = (ExternalDeclaration)theEObject;
        T result = caseExternalDeclaration(externalDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.FUNCTION_DEF_HEAD:
      {
        FunctionDefHead functionDefHead = (FunctionDefHead)theEObject;
        T result = caseFunctionDefHead(functionDefHead);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.FUNCTION_DEFINITION:
      {
        FunctionDefinition functionDefinition = (FunctionDefinition)theEObject;
        T result = caseFunctionDefinition(functionDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.DECLARATION:
      {
        Declaration declaration = (Declaration)theEObject;
        T result = caseDeclaration(declaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.FUNCTION_DECLARATION_SPECIFIERS:
      {
        FunctionDeclarationSpecifiers functionDeclarationSpecifiers = (FunctionDeclarationSpecifiers)theEObject;
        T result = caseFunctionDeclarationSpecifiers(functionDeclarationSpecifiers);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.DECLARATION_SPECIFIERS:
      {
        DeclarationSpecifiers declarationSpecifiers = (DeclarationSpecifiers)theEObject;
        T result = caseDeclarationSpecifiers(declarationSpecifiers);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.INIT_DECLARATOR_LIST:
      {
        InitDeclaratorList initDeclaratorList = (InitDeclaratorList)theEObject;
        T result = caseInitDeclaratorList(initDeclaratorList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.INIT_DECLARATOR:
      {
        InitDeclarator initDeclarator = (InitDeclarator)theEObject;
        T result = caseInitDeclarator(initDeclarator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.STORAGE_CLASS_SPECIFIER:
      {
        StorageClassSpecifier storageClassSpecifier = (StorageClassSpecifier)theEObject;
        T result = caseStorageClassSpecifier(storageClassSpecifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.TYPE_SPECIFIER:
      {
        TypeSpecifier typeSpecifier = (TypeSpecifier)theEObject;
        T result = caseTypeSpecifier(typeSpecifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.TYPEDEF_NAME:
      {
        TypedefName typedefName = (TypedefName)theEObject;
        T result = caseTypedefName(typedefName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.DECLARATION_SPECIFIER:
      {
        DeclarationSpecifier declarationSpecifier = (DeclarationSpecifier)theEObject;
        T result = caseDeclarationSpecifier(declarationSpecifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.STRUCT_OR_UNION:
      {
        StructOrUnion structOrUnion = (StructOrUnion)theEObject;
        T result = caseStructOrUnion(structOrUnion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.STRUCT_DECLARATION_LIST:
      {
        StructDeclarationList structDeclarationList = (StructDeclarationList)theEObject;
        T result = caseStructDeclarationList(structDeclarationList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.STRUCT_DECLARATION:
      {
        StructDeclaration structDeclaration = (StructDeclaration)theEObject;
        T result = caseStructDeclaration(structDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.SPECIFIER_QUALIFIER_LIST:
      {
        SpecifierQualifierList specifierQualifierList = (SpecifierQualifierList)theEObject;
        T result = caseSpecifierQualifierList(specifierQualifierList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.STRUCT_DECLARATOR_LIST:
      {
        StructDeclaratorList structDeclaratorList = (StructDeclaratorList)theEObject;
        T result = caseStructDeclaratorList(structDeclaratorList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.STRUCT_DECLARATOR:
      {
        StructDeclarator structDeclarator = (StructDeclarator)theEObject;
        T result = caseStructDeclarator(structDeclarator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.ENUMERATOR_LIST:
      {
        EnumeratorList enumeratorList = (EnumeratorList)theEObject;
        T result = caseEnumeratorList(enumeratorList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.ENUMERATOR:
      {
        Enumerator enumerator = (Enumerator)theEObject;
        T result = caseEnumerator(enumerator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.TYPE_QUALIFIER:
      {
        TypeQualifier typeQualifier = (TypeQualifier)theEObject;
        T result = caseTypeQualifier(typeQualifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.FUNCTION_SPECIFIER:
      {
        FunctionSpecifier functionSpecifier = (FunctionSpecifier)theEObject;
        T result = caseFunctionSpecifier(functionSpecifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.DECLARATOR:
      {
        Declarator declarator = (Declarator)theEObject;
        T result = caseDeclarator(declarator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.DIRECT_DECLARATOR:
      {
        DirectDeclarator directDeclarator = (DirectDeclarator)theEObject;
        T result = caseDirectDeclarator(directDeclarator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.DECLARATOR_SUFFIX:
      {
        DeclaratorSuffix declaratorSuffix = (DeclaratorSuffix)theEObject;
        T result = caseDeclaratorSuffix(declaratorSuffix);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.DIRECT_DECLARATOR_LAST_SUFFIX:
      {
        DirectDeclaratorLastSuffix directDeclaratorLastSuffix = (DirectDeclaratorLastSuffix)theEObject;
        T result = caseDirectDeclaratorLastSuffix(directDeclaratorLastSuffix);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.GCC_DECLARATOR_EXTENSION:
      {
        GccDeclaratorExtension gccDeclaratorExtension = (GccDeclaratorExtension)theEObject;
        T result = caseGccDeclaratorExtension(gccDeclaratorExtension);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.GCC_ATTRIBUTE_SPECIFIER:
      {
        GccAttributeSpecifier gccAttributeSpecifier = (GccAttributeSpecifier)theEObject;
        T result = caseGccAttributeSpecifier(gccAttributeSpecifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.GCC_ATTRIBUTE_LIST:
      {
        GccAttributeList gccAttributeList = (GccAttributeList)theEObject;
        T result = caseGccAttributeList(gccAttributeList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.GCC_ATTRIBUTE:
      {
        GccAttribute gccAttribute = (GccAttribute)theEObject;
        T result = caseGccAttribute(gccAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.POINTER:
      {
        Pointer pointer = (Pointer)theEObject;
        T result = casePointer(pointer);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.TYPE_QUALIFIER_LIST:
      {
        TypeQualifierList typeQualifierList = (TypeQualifierList)theEObject;
        T result = caseTypeQualifierList(typeQualifierList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.PARAMETER_TYPE_LIST:
      {
        ParameterTypeList parameterTypeList = (ParameterTypeList)theEObject;
        T result = caseParameterTypeList(parameterTypeList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.PARAMETER_LIST:
      {
        ParameterList parameterList = (ParameterList)theEObject;
        T result = caseParameterList(parameterList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.PARAMETER_DECLARATION:
      {
        ParameterDeclaration parameterDeclaration = (ParameterDeclaration)theEObject;
        T result = caseParameterDeclaration(parameterDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.IDENTIFIER_LIST:
      {
        IdentifierList identifierList = (IdentifierList)theEObject;
        T result = caseIdentifierList(identifierList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.MY_IDENTIFIER:
      {
        MyIdentifier myIdentifier = (MyIdentifier)theEObject;
        T result = caseMyIdentifier(myIdentifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.TYPE_NAME:
      {
        TypeName typeName = (TypeName)theEObject;
        T result = caseTypeName(typeName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.ABSTRACT_DECLARATOR:
      {
        AbstractDeclarator abstractDeclarator = (AbstractDeclarator)theEObject;
        T result = caseAbstractDeclarator(abstractDeclarator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.INITIALIZER:
      {
        Initializer initializer = (Initializer)theEObject;
        T result = caseInitializer(initializer);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.INITIALIZER_LIST:
      {
        InitializerList initializerList = (InitializerList)theEObject;
        T result = caseInitializerList(initializerList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.BLOCK_LIST:
      {
        BlockList blockList = (BlockList)theEObject;
        T result = caseBlockList(blockList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.STATEMENT:
      {
        Statement statement = (Statement)theEObject;
        T result = caseStatement(statement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.ASM_LINE:
      {
        AsmLine asmLine = (AsmLine)theEObject;
        T result = caseAsmLine(asmLine);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.ASM_SYMBOLIC_NAME:
      {
        AsmSymbolicName asmSymbolicName = (AsmSymbolicName)theEObject;
        T result = caseAsmSymbolicName(asmSymbolicName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.ASM_LINE_WITH_COLON:
      {
        AsmLineWithColon asmLineWithColon = (AsmLineWithColon)theEObject;
        T result = caseAsmLineWithColon(asmLineWithColon);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.ASM_LINE_WITHOUT_COLON:
      {
        AsmLineWithoutColon asmLineWithoutColon = (AsmLineWithoutColon)theEObject;
        T result = caseAsmLineWithoutColon(asmLineWithoutColon);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.DESIGNATION:
      {
        Designation designation = (Designation)theEObject;
        T result = caseDesignation(designation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.DESIGNATOR_LIST:
      {
        DesignatorList designatorList = (DesignatorList)theEObject;
        T result = caseDesignatorList(designatorList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.DESIGNATOR:
      {
        Designator designator = (Designator)theEObject;
        T result = caseDesignator(designator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = caseCommon_Expression(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.ASSIGNMENT_OPERATOR:
      {
        AssignmentOperator assignmentOperator = (AssignmentOperator)theEObject;
        T result = caseAssignmentOperator(assignmentOperator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.UNARY_OPERATOR:
      {
        UnaryOperator unaryOperator = (UnaryOperator)theEObject;
        T result = caseUnaryOperator(unaryOperator);
        if (result == null) result = caseCommon_UnaryOperator(unaryOperator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.POSTFIX_EXPRESSION_SUFFIX:
      {
        PostfixExpressionSuffix postfixExpressionSuffix = (PostfixExpressionSuffix)theEObject;
        T result = casePostfixExpressionSuffix(postfixExpressionSuffix);
        if (result == null) result = caseCommon_PostfixExpressionSuffix(postfixExpressionSuffix);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.ARGUMENT_EXPRESSION_LIST:
      {
        ArgumentExpressionList argumentExpressionList = (ArgumentExpressionList)theEObject;
        T result = caseArgumentExpressionList(argumentExpressionList);
        if (result == null) result = caseCommon_ArgumentExpressionList(argumentExpressionList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.PARSER:
      {
        Parser parser = (Parser)theEObject;
        T result = caseParser(parser);
        if (result == null) result = caseCommon_Parser(parser);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.STRUCT_OR_UNION_SPECIFIER:
      {
        StructOrUnionSpecifier structOrUnionSpecifier = (StructOrUnionSpecifier)theEObject;
        T result = caseStructOrUnionSpecifier(structOrUnionSpecifier);
        if (result == null) result = caseDeclarationSpecifier(structOrUnionSpecifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.ENUM_SPECIFIER:
      {
        EnumSpecifier enumSpecifier = (EnumSpecifier)theEObject;
        T result = caseEnumSpecifier(enumSpecifier);
        if (result == null) result = caseDeclarationSpecifier(enumSpecifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.LABELED_STATEMENT:
      {
        LabeledStatement labeledStatement = (LabeledStatement)theEObject;
        T result = caseLabeledStatement(labeledStatement);
        if (result == null) result = caseStatement(labeledStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.COMPOUND_STATEMENT:
      {
        CompoundStatement compoundStatement = (CompoundStatement)theEObject;
        T result = caseCompoundStatement(compoundStatement);
        if (result == null) result = caseStatement(compoundStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.BODY_STATEMENT:
      {
        BodyStatement bodyStatement = (BodyStatement)theEObject;
        T result = caseBodyStatement(bodyStatement);
        if (result == null) result = caseStatement(bodyStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.EXPRESSION_STATEMENT:
      {
        ExpressionStatement expressionStatement = (ExpressionStatement)theEObject;
        T result = caseExpressionStatement(expressionStatement);
        if (result == null) result = caseStatement(expressionStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.SELECTION_STATEMENT:
      {
        SelectionStatement selectionStatement = (SelectionStatement)theEObject;
        T result = caseSelectionStatement(selectionStatement);
        if (result == null) result = caseStatement(selectionStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.ITERATION_STATEMENT:
      {
        IterationStatement iterationStatement = (IterationStatement)theEObject;
        T result = caseIterationStatement(iterationStatement);
        if (result == null) result = caseStatement(iterationStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.JUMP_STATEMENT:
      {
        JumpStatement jumpStatement = (JumpStatement)theEObject;
        T result = caseJumpStatement(jumpStatement);
        if (result == null) result = caseStatement(jumpStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.ASM_STATEMENT:
      {
        AsmStatement asmStatement = (AsmStatement)theEObject;
        T result = caseAsmStatement(asmStatement);
        if (result == null) result = caseStatement(asmStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.ASSIGNMENT_EXPRESSION:
      {
        AssignmentExpression assignmentExpression = (AssignmentExpression)theEObject;
        T result = caseAssignmentExpression(assignmentExpression);
        if (result == null) result = caseExpression(assignmentExpression);
        if (result == null) result = caseCommon_Expression(assignmentExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.CONDITIONAL_EXPRESSION:
      {
        ConditionalExpression conditionalExpression = (ConditionalExpression)theEObject;
        T result = caseConditionalExpression(conditionalExpression);
        if (result == null) result = caseExpression(conditionalExpression);
        if (result == null) result = caseCommon_Expression(conditionalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.LOGICAL_OR_EXPRESSION:
      {
        LogicalOrExpression logicalOrExpression = (LogicalOrExpression)theEObject;
        T result = caseLogicalOrExpression(logicalOrExpression);
        if (result == null) result = caseExpression(logicalOrExpression);
        if (result == null) result = caseCommon_Expression(logicalOrExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.LOGICAL_AND_EXPRESSION:
      {
        LogicalAndExpression logicalAndExpression = (LogicalAndExpression)theEObject;
        T result = caseLogicalAndExpression(logicalAndExpression);
        if (result == null) result = caseExpression(logicalAndExpression);
        if (result == null) result = caseCommon_Expression(logicalAndExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.INCLUSIVE_OR_EXPRESSION:
      {
        InclusiveOrExpression inclusiveOrExpression = (InclusiveOrExpression)theEObject;
        T result = caseInclusiveOrExpression(inclusiveOrExpression);
        if (result == null) result = caseExpression(inclusiveOrExpression);
        if (result == null) result = caseCommon_Expression(inclusiveOrExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.EXCLUSIVE_OR_EXPRESSION:
      {
        ExclusiveOrExpression exclusiveOrExpression = (ExclusiveOrExpression)theEObject;
        T result = caseExclusiveOrExpression(exclusiveOrExpression);
        if (result == null) result = caseExpression(exclusiveOrExpression);
        if (result == null) result = caseCommon_Expression(exclusiveOrExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.AND_EXPRESSION:
      {
        AndExpression andExpression = (AndExpression)theEObject;
        T result = caseAndExpression(andExpression);
        if (result == null) result = caseExpression(andExpression);
        if (result == null) result = caseCommon_Expression(andExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.EQUALITY_EXPRESSION:
      {
        EqualityExpression equalityExpression = (EqualityExpression)theEObject;
        T result = caseEqualityExpression(equalityExpression);
        if (result == null) result = caseExpression(equalityExpression);
        if (result == null) result = caseCommon_Expression(equalityExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.RELATIONAL_EXPRESSION:
      {
        RelationalExpression relationalExpression = (RelationalExpression)theEObject;
        T result = caseRelationalExpression(relationalExpression);
        if (result == null) result = caseExpression(relationalExpression);
        if (result == null) result = caseCommon_Expression(relationalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.SHIFT_EXPRESSION:
      {
        ShiftExpression shiftExpression = (ShiftExpression)theEObject;
        T result = caseShiftExpression(shiftExpression);
        if (result == null) result = caseExpression(shiftExpression);
        if (result == null) result = caseCommon_Expression(shiftExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.ADDITIVE_EXPRESSION:
      {
        AdditiveExpression additiveExpression = (AdditiveExpression)theEObject;
        T result = caseAdditiveExpression(additiveExpression);
        if (result == null) result = caseExpression(additiveExpression);
        if (result == null) result = caseCommon_Expression(additiveExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.MULTIPLICATIVE_EXPRESSION:
      {
        MultiplicativeExpression multiplicativeExpression = (MultiplicativeExpression)theEObject;
        T result = caseMultiplicativeExpression(multiplicativeExpression);
        if (result == null) result = caseExpression(multiplicativeExpression);
        if (result == null) result = caseCommon_Expression(multiplicativeExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.CAST_EXPRESSION:
      {
        CastExpression castExpression = (CastExpression)theEObject;
        T result = caseCastExpression(castExpression);
        if (result == null) result = caseExpression(castExpression);
        if (result == null) result = caseCommon_Expression(castExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.UNARY_EXPRESSION:
      {
        UnaryExpression unaryExpression = (UnaryExpression)theEObject;
        T result = caseUnaryExpression(unaryExpression);
        if (result == null) result = caseExpression(unaryExpression);
        if (result == null) result = caseCommon_Expression(unaryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.POSTFIX_EXPRESSION:
      {
        PostfixExpression postfixExpression = (PostfixExpression)theEObject;
        T result = casePostfixExpression(postfixExpression);
        if (result == null) result = caseExpression(postfixExpression);
        if (result == null) result = caseCommon_Expression(postfixExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.POSTFIX_EXPRESSION_SUFFIX_ARRAY:
      {
        PostfixExpressionSuffixArray postfixExpressionSuffixArray = (PostfixExpressionSuffixArray)theEObject;
        T result = casePostfixExpressionSuffixArray(postfixExpressionSuffixArray);
        if (result == null) result = casePostfixExpressionSuffix(postfixExpressionSuffixArray);
        if (result == null) result = caseCommon_PostfixExpressionSuffix(postfixExpressionSuffixArray);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.POSTFIX_EXPRESSION_SUFFIX_ARGUMENT:
      {
        PostfixExpressionSuffixArgument postfixExpressionSuffixArgument = (PostfixExpressionSuffixArgument)theEObject;
        T result = casePostfixExpressionSuffixArgument(postfixExpressionSuffixArgument);
        if (result == null) result = casePostfixExpressionSuffix(postfixExpressionSuffixArgument);
        if (result == null) result = caseCommon_PostfixExpressionSuffix(postfixExpressionSuffixArgument);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.POSTFIX_EXPRESSION_SUFFIX_DOT:
      {
        PostfixExpressionSuffixDot postfixExpressionSuffixDot = (PostfixExpressionSuffixDot)theEObject;
        T result = casePostfixExpressionSuffixDot(postfixExpressionSuffixDot);
        if (result == null) result = casePostfixExpressionSuffix(postfixExpressionSuffixDot);
        if (result == null) result = caseCommon_PostfixExpressionSuffix(postfixExpressionSuffixDot);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.POSTFIX_EXPRESSION_SUFFIX_ARROW:
      {
        PostfixExpressionSuffixArrow postfixExpressionSuffixArrow = (PostfixExpressionSuffixArrow)theEObject;
        T result = casePostfixExpressionSuffixArrow(postfixExpressionSuffixArrow);
        if (result == null) result = casePostfixExpressionSuffix(postfixExpressionSuffixArrow);
        if (result == null) result = caseCommon_PostfixExpressionSuffix(postfixExpressionSuffixArrow);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.POSTFIX_EXPRESSION_SUFFIX_PLUS_PLUS:
      {
        PostfixExpressionSuffixPlusPlus postfixExpressionSuffixPlusPlus = (PostfixExpressionSuffixPlusPlus)theEObject;
        T result = casePostfixExpressionSuffixPlusPlus(postfixExpressionSuffixPlusPlus);
        if (result == null) result = casePostfixExpressionSuffix(postfixExpressionSuffixPlusPlus);
        if (result == null) result = caseCommon_PostfixExpressionSuffix(postfixExpressionSuffixPlusPlus);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.POSTFIX_EXPRESSION_SUFFIX_MINUS_MINUS:
      {
        PostfixExpressionSuffixMinusMinus postfixExpressionSuffixMinusMinus = (PostfixExpressionSuffixMinusMinus)theEObject;
        T result = casePostfixExpressionSuffixMinusMinus(postfixExpressionSuffixMinusMinus);
        if (result == null) result = casePostfixExpressionSuffix(postfixExpressionSuffixMinusMinus);
        if (result == null) result = caseCommon_PostfixExpressionSuffix(postfixExpressionSuffixMinusMinus);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.PRIMARY_EXPRESSION:
      {
        PrimaryExpression primaryExpression = (PrimaryExpression)theEObject;
        T result = casePrimaryExpression(primaryExpression);
        if (result == null) result = caseExpression(primaryExpression);
        if (result == null) result = caseCommon_Expression(primaryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ParserPackage.CONSTANT_EXPRESSION:
      {
        ConstantExpression constantExpression = (ConstantExpression)theEObject;
        T result = caseConstantExpression(constantExpression);
        if (result == null) result = caseExpression(constantExpression);
        if (result == null) result = caseCommon_Expression(constantExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>External Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>External Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExternalDeclaration(ExternalDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function Def Head</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function Def Head</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunctionDefHead(FunctionDefHead object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunctionDefinition(FunctionDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclaration(Declaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function Declaration Specifiers</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function Declaration Specifiers</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunctionDeclarationSpecifiers(FunctionDeclarationSpecifiers object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Declaration Specifiers</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Declaration Specifiers</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclarationSpecifiers(DeclarationSpecifiers object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Init Declarator List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Init Declarator List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInitDeclaratorList(InitDeclaratorList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Init Declarator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Init Declarator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInitDeclarator(InitDeclarator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Storage Class Specifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Storage Class Specifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStorageClassSpecifier(StorageClassSpecifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Specifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Specifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeSpecifier(TypeSpecifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Typedef Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Typedef Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypedefName(TypedefName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Declaration Specifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Declaration Specifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclarationSpecifier(DeclarationSpecifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Struct Or Union</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Struct Or Union</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStructOrUnion(StructOrUnion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Struct Declaration List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Struct Declaration List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStructDeclarationList(StructDeclarationList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Struct Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Struct Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStructDeclaration(StructDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Specifier Qualifier List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Specifier Qualifier List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSpecifierQualifierList(SpecifierQualifierList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Struct Declarator List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Struct Declarator List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStructDeclaratorList(StructDeclaratorList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Struct Declarator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Struct Declarator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStructDeclarator(StructDeclarator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enumerator List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enumerator List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumeratorList(EnumeratorList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enumerator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enumerator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumerator(Enumerator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Qualifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Qualifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeQualifier(TypeQualifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function Specifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function Specifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunctionSpecifier(FunctionSpecifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Declarator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Declarator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclarator(Declarator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Direct Declarator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Direct Declarator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDirectDeclarator(DirectDeclarator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Declarator Suffix</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Declarator Suffix</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclaratorSuffix(DeclaratorSuffix object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Direct Declarator Last Suffix</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Direct Declarator Last Suffix</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDirectDeclaratorLastSuffix(DirectDeclaratorLastSuffix object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Gcc Declarator Extension</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Gcc Declarator Extension</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGccDeclaratorExtension(GccDeclaratorExtension object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Gcc Attribute Specifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Gcc Attribute Specifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGccAttributeSpecifier(GccAttributeSpecifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Gcc Attribute List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Gcc Attribute List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGccAttributeList(GccAttributeList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Gcc Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Gcc Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGccAttribute(GccAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pointer</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pointer</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePointer(Pointer object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Qualifier List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Qualifier List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeQualifierList(TypeQualifierList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter Type List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter Type List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameterTypeList(ParameterTypeList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameterList(ParameterList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameterDeclaration(ParameterDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Identifier List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Identifier List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIdentifierList(IdentifierList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>My Identifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>My Identifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMyIdentifier(MyIdentifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeName(TypeName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Declarator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Declarator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractDeclarator(AbstractDeclarator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Initializer</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Initializer</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInitializer(Initializer object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Initializer List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Initializer List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInitializerList(InitializerList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Block List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Block List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBlockList(BlockList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStatement(Statement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Asm Line</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Asm Line</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAsmLine(AsmLine object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Asm Symbolic Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Asm Symbolic Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAsmSymbolicName(AsmSymbolicName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Asm Line With Colon</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Asm Line With Colon</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAsmLineWithColon(AsmLineWithColon object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Asm Line Without Colon</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Asm Line Without Colon</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAsmLineWithoutColon(AsmLineWithoutColon object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Designation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Designation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDesignation(Designation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Designator List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Designator List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDesignatorList(DesignatorList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Designator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Designator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDesignator(Designator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression(Expression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assignment Operator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assignment Operator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssignmentOperator(AssignmentOperator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unary Operator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unary Operator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnaryOperator(UnaryOperator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Postfix Expression Suffix</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Postfix Expression Suffix</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePostfixExpressionSuffix(PostfixExpressionSuffix object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Argument Expression List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Argument Expression List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArgumentExpressionList(ArgumentExpressionList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parser</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parser</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParser(Parser object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Struct Or Union Specifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Struct Or Union Specifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStructOrUnionSpecifier(StructOrUnionSpecifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Specifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Specifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumSpecifier(EnumSpecifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Labeled Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Labeled Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLabeledStatement(LabeledStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Compound Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Compound Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCompoundStatement(CompoundStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Body Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Body Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBodyStatement(BodyStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpressionStatement(ExpressionStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Selection Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Selection Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSelectionStatement(SelectionStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Iteration Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Iteration Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIterationStatement(IterationStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Jump Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Jump Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseJumpStatement(JumpStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Asm Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Asm Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAsmStatement(AsmStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assignment Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assignment Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssignmentExpression(AssignmentExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Conditional Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Conditional Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConditionalExpression(ConditionalExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Logical Or Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Logical Or Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLogicalOrExpression(LogicalOrExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Logical And Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Logical And Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLogicalAndExpression(LogicalAndExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Inclusive Or Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Inclusive Or Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInclusiveOrExpression(InclusiveOrExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Exclusive Or Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Exclusive Or Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExclusiveOrExpression(ExclusiveOrExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>And Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>And Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAndExpression(AndExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Equality Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Equality Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEqualityExpression(EqualityExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relational Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relational Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelationalExpression(RelationalExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Shift Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Shift Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseShiftExpression(ShiftExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Additive Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Additive Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAdditiveExpression(AdditiveExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multiplicative Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multiplicative Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultiplicativeExpression(MultiplicativeExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cast Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cast Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCastExpression(CastExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnaryExpression(UnaryExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Postfix Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Postfix Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePostfixExpression(PostfixExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Postfix Expression Suffix Array</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Postfix Expression Suffix Array</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePostfixExpressionSuffixArray(PostfixExpressionSuffixArray object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Postfix Expression Suffix Argument</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Postfix Expression Suffix Argument</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePostfixExpressionSuffixArgument(PostfixExpressionSuffixArgument object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Postfix Expression Suffix Dot</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Postfix Expression Suffix Dot</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePostfixExpressionSuffixDot(PostfixExpressionSuffixDot object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Postfix Expression Suffix Arrow</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Postfix Expression Suffix Arrow</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePostfixExpressionSuffixArrow(PostfixExpressionSuffixArrow object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Postfix Expression Suffix Plus Plus</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Postfix Expression Suffix Plus Plus</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePostfixExpressionSuffixPlusPlus(PostfixExpressionSuffixPlusPlus object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Postfix Expression Suffix Minus Minus</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Postfix Expression Suffix Minus Minus</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePostfixExpressionSuffixMinusMinus(PostfixExpressionSuffixMinusMinus object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primary Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primary Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrimaryExpression(PrimaryExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constant Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constant Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstantExpression(ConstantExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommon_Expression(at.jku.weiner.c.common.common.Expression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unary Operator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unary Operator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommon_UnaryOperator(at.jku.weiner.c.common.common.UnaryOperator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Postfix Expression Suffix</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Postfix Expression Suffix</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommon_PostfixExpressionSuffix(at.jku.weiner.c.common.common.PostfixExpressionSuffix object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Argument Expression List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Argument Expression List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommon_ArgumentExpressionList(at.jku.weiner.c.common.common.ArgumentExpressionList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parser</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parser</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommon_Parser(at.jku.weiner.c.common.common.Parser object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //ParserSwitch
