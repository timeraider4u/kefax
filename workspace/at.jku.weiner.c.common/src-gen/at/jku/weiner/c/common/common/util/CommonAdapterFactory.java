/**
 */
package at.jku.weiner.c.common.common.util;

import at.jku.weiner.c.common.common.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see at.jku.weiner.c.common.common.CommonPackage
 * @generated
 */
public class CommonAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static CommonPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CommonAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = CommonPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CommonSwitch<Adapter> modelSwitch =
    new CommonSwitch<Adapter>()
    {
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseUnaryOperator(UnaryOperator object)
      {
        return createUnaryOperatorAdapter();
      }
      @Override
      public Adapter casePostfixExpressionSuffix(PostfixExpressionSuffix object)
      {
        return createPostfixExpressionSuffixAdapter();
      }
      @Override
      public Adapter caseArgumentExpressionList(ArgumentExpressionList object)
      {
        return createArgumentExpressionListAdapter();
      }
      @Override
      public Adapter caseConstant2(Constant2 object)
      {
        return createConstant2Adapter();
      }
      @Override
      public Adapter caseConstantExpression(ConstantExpression object)
      {
        return createConstantExpressionAdapter();
      }
      @Override
      public Adapter caseConditionalExpression(ConditionalExpression object)
      {
        return createConditionalExpressionAdapter();
      }
      @Override
      public Adapter caseLogicalOrExpression(LogicalOrExpression object)
      {
        return createLogicalOrExpressionAdapter();
      }
      @Override
      public Adapter caseLogicalAndExpression(LogicalAndExpression object)
      {
        return createLogicalAndExpressionAdapter();
      }
      @Override
      public Adapter caseInclusiveOrExpression(InclusiveOrExpression object)
      {
        return createInclusiveOrExpressionAdapter();
      }
      @Override
      public Adapter caseExclusiveOrExpression(ExclusiveOrExpression object)
      {
        return createExclusiveOrExpressionAdapter();
      }
      @Override
      public Adapter caseAndExpression(AndExpression object)
      {
        return createAndExpressionAdapter();
      }
      @Override
      public Adapter caseEqualityExpression(EqualityExpression object)
      {
        return createEqualityExpressionAdapter();
      }
      @Override
      public Adapter caseRelationalExpression(RelationalExpression object)
      {
        return createRelationalExpressionAdapter();
      }
      @Override
      public Adapter caseShiftExpression(ShiftExpression object)
      {
        return createShiftExpressionAdapter();
      }
      @Override
      public Adapter caseAdditiveExpression(AdditiveExpression object)
      {
        return createAdditiveExpressionAdapter();
      }
      @Override
      public Adapter caseMultiplicativeExpression(MultiplicativeExpression object)
      {
        return createMultiplicativeExpressionAdapter();
      }
      @Override
      public Adapter caseCastExpression(CastExpression object)
      {
        return createCastExpressionAdapter();
      }
      @Override
      public Adapter caseUnaryExpression(UnaryExpression object)
      {
        return createUnaryExpressionAdapter();
      }
      @Override
      public Adapter casePostfixExpression(PostfixExpression object)
      {
        return createPostfixExpressionAdapter();
      }
      @Override
      public Adapter casePostfixExpressionSuffixArgument(PostfixExpressionSuffixArgument object)
      {
        return createPostfixExpressionSuffixArgumentAdapter();
      }
      @Override
      public Adapter casePrimaryExpression(PrimaryExpression object)
      {
        return createPrimaryExpressionAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.common.common.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.common.common.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.common.common.UnaryOperator <em>Unary Operator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.common.common.UnaryOperator
   * @generated
   */
  public Adapter createUnaryOperatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.common.common.PostfixExpressionSuffix <em>Postfix Expression Suffix</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.common.common.PostfixExpressionSuffix
   * @generated
   */
  public Adapter createPostfixExpressionSuffixAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.common.common.ArgumentExpressionList <em>Argument Expression List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.common.common.ArgumentExpressionList
   * @generated
   */
  public Adapter createArgumentExpressionListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.common.common.Constant2 <em>Constant2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.common.common.Constant2
   * @generated
   */
  public Adapter createConstant2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.common.common.ConstantExpression <em>Constant Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.common.common.ConstantExpression
   * @generated
   */
  public Adapter createConstantExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.common.common.ConditionalExpression <em>Conditional Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.common.common.ConditionalExpression
   * @generated
   */
  public Adapter createConditionalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.common.common.LogicalOrExpression <em>Logical Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.common.common.LogicalOrExpression
   * @generated
   */
  public Adapter createLogicalOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.common.common.LogicalAndExpression <em>Logical And Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.common.common.LogicalAndExpression
   * @generated
   */
  public Adapter createLogicalAndExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.common.common.InclusiveOrExpression <em>Inclusive Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.common.common.InclusiveOrExpression
   * @generated
   */
  public Adapter createInclusiveOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.common.common.ExclusiveOrExpression <em>Exclusive Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.common.common.ExclusiveOrExpression
   * @generated
   */
  public Adapter createExclusiveOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.common.common.AndExpression <em>And Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.common.common.AndExpression
   * @generated
   */
  public Adapter createAndExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.common.common.EqualityExpression <em>Equality Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.common.common.EqualityExpression
   * @generated
   */
  public Adapter createEqualityExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.common.common.RelationalExpression <em>Relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.common.common.RelationalExpression
   * @generated
   */
  public Adapter createRelationalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.common.common.ShiftExpression <em>Shift Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.common.common.ShiftExpression
   * @generated
   */
  public Adapter createShiftExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.common.common.AdditiveExpression <em>Additive Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.common.common.AdditiveExpression
   * @generated
   */
  public Adapter createAdditiveExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.common.common.MultiplicativeExpression <em>Multiplicative Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.common.common.MultiplicativeExpression
   * @generated
   */
  public Adapter createMultiplicativeExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.common.common.CastExpression <em>Cast Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.common.common.CastExpression
   * @generated
   */
  public Adapter createCastExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.common.common.UnaryExpression <em>Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.common.common.UnaryExpression
   * @generated
   */
  public Adapter createUnaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.common.common.PostfixExpression <em>Postfix Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.common.common.PostfixExpression
   * @generated
   */
  public Adapter createPostfixExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.common.common.PostfixExpressionSuffixArgument <em>Postfix Expression Suffix Argument</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.common.common.PostfixExpressionSuffixArgument
   * @generated
   */
  public Adapter createPostfixExpressionSuffixArgumentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.weiner.c.common.common.PrimaryExpression <em>Primary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.weiner.c.common.common.PrimaryExpression
   * @generated
   */
  public Adapter createPrimaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //CommonAdapterFactory
