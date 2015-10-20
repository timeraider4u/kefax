/**
 */
package at.jku.weiner.c.c.impl;

import at.jku.weiner.c.c.CPackage;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.PostfixExpression;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Postfix Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.impl.PostfixExpressionImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.PostfixExpressionImpl#getArrayExpr <em>Array Expr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PostfixExpressionImpl extends ExpressionImpl implements PostfixExpression
{
  /**
   * The cached value of the '{@link #getExpr() <em>Expr</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpr()
   * @generated
   * @ordered
   */
  protected EList<Expression> expr;

  /**
   * The cached value of the '{@link #getArrayExpr() <em>Array Expr</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArrayExpr()
   * @generated
   * @ordered
   */
  protected EList<Expression> arrayExpr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PostfixExpressionImpl()
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
    return CPackage.Literals.POSTFIX_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expression> getExpr()
  {
    if (expr == null)
    {
      expr = new EObjectContainmentEList<Expression>(Expression.class, this, CPackage.POSTFIX_EXPRESSION__EXPR);
    }
    return expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expression> getArrayExpr()
  {
    if (arrayExpr == null)
    {
      arrayExpr = new EObjectContainmentEList<Expression>(Expression.class, this, CPackage.POSTFIX_EXPRESSION__ARRAY_EXPR);
    }
    return arrayExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case CPackage.POSTFIX_EXPRESSION__EXPR:
        return ((InternalEList<?>)getExpr()).basicRemove(otherEnd, msgs);
      case CPackage.POSTFIX_EXPRESSION__ARRAY_EXPR:
        return ((InternalEList<?>)getArrayExpr()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case CPackage.POSTFIX_EXPRESSION__EXPR:
        return getExpr();
      case CPackage.POSTFIX_EXPRESSION__ARRAY_EXPR:
        return getArrayExpr();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case CPackage.POSTFIX_EXPRESSION__EXPR:
        getExpr().clear();
        getExpr().addAll((Collection<? extends Expression>)newValue);
        return;
      case CPackage.POSTFIX_EXPRESSION__ARRAY_EXPR:
        getArrayExpr().clear();
        getArrayExpr().addAll((Collection<? extends Expression>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case CPackage.POSTFIX_EXPRESSION__EXPR:
        getExpr().clear();
        return;
      case CPackage.POSTFIX_EXPRESSION__ARRAY_EXPR:
        getArrayExpr().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case CPackage.POSTFIX_EXPRESSION__EXPR:
        return expr != null && !expr.isEmpty();
      case CPackage.POSTFIX_EXPRESSION__ARRAY_EXPR:
        return arrayExpr != null && !arrayExpr.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //PostfixExpressionImpl
