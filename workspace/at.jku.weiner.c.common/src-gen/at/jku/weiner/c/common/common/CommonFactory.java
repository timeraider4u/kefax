/**
 */
package at.jku.weiner.c.common.common;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see at.jku.weiner.c.common.common.CommonPackage
 * @generated
 */
public interface CommonFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CommonFactory eINSTANCE = at.jku.weiner.c.common.common.impl.CommonFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

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
   * Returns a new object of class '<em>Constant2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constant2</em>'.
   * @generated
   */
  Constant2 createConstant2();

  /**
   * Returns a new object of class '<em>Constant Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constant Expression</em>'.
   * @generated
   */
  ConstantExpression createConstantExpression();

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
   * Returns a new object of class '<em>Postfix Expression Suffix Argument</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Postfix Expression Suffix Argument</em>'.
   * @generated
   */
  PostfixExpressionSuffixArgument createPostfixExpressionSuffixArgument();

  /**
   * Returns a new object of class '<em>Primary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Primary Expression</em>'.
   * @generated
   */
  PrimaryExpression createPrimaryExpression();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  CommonPackage getCommonPackage();

} //CommonFactory
