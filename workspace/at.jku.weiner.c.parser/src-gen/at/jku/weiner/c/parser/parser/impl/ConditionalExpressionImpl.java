/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.ConditionalExpression;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.ParserPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.ConditionalExpressionImpl#getQExpr <em>QExpr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.ConditionalExpressionImpl#getCExpr <em>CExpr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionalExpressionImpl extends ExpressionImpl implements ConditionalExpression
{
  /**
   * The cached value of the '{@link #getQExpr() <em>QExpr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQExpr()
   * @generated
   * @ordered
   */
  protected Expression qExpr;

  /**
   * The cached value of the '{@link #getCExpr() <em>CExpr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCExpr()
   * @generated
   * @ordered
   */
  protected Expression cExpr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConditionalExpressionImpl()
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
    return ParserPackage.Literals.CONDITIONAL_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getQExpr()
  {
    return qExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQExpr(Expression newQExpr, NotificationChain msgs)
  {
    Expression oldQExpr = qExpr;
    qExpr = newQExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.CONDITIONAL_EXPRESSION__QEXPR, oldQExpr, newQExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQExpr(Expression newQExpr)
  {
    if (newQExpr != qExpr)
    {
      NotificationChain msgs = null;
      if (qExpr != null)
        msgs = ((InternalEObject)qExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.CONDITIONAL_EXPRESSION__QEXPR, null, msgs);
      if (newQExpr != null)
        msgs = ((InternalEObject)newQExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.CONDITIONAL_EXPRESSION__QEXPR, null, msgs);
      msgs = basicSetQExpr(newQExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.CONDITIONAL_EXPRESSION__QEXPR, newQExpr, newQExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getCExpr()
  {
    return cExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCExpr(Expression newCExpr, NotificationChain msgs)
  {
    Expression oldCExpr = cExpr;
    cExpr = newCExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.CONDITIONAL_EXPRESSION__CEXPR, oldCExpr, newCExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCExpr(Expression newCExpr)
  {
    if (newCExpr != cExpr)
    {
      NotificationChain msgs = null;
      if (cExpr != null)
        msgs = ((InternalEObject)cExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.CONDITIONAL_EXPRESSION__CEXPR, null, msgs);
      if (newCExpr != null)
        msgs = ((InternalEObject)newCExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.CONDITIONAL_EXPRESSION__CEXPR, null, msgs);
      msgs = basicSetCExpr(newCExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.CONDITIONAL_EXPRESSION__CEXPR, newCExpr, newCExpr));
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
      case ParserPackage.CONDITIONAL_EXPRESSION__QEXPR:
        return basicSetQExpr(null, msgs);
      case ParserPackage.CONDITIONAL_EXPRESSION__CEXPR:
        return basicSetCExpr(null, msgs);
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
      case ParserPackage.CONDITIONAL_EXPRESSION__QEXPR:
        return getQExpr();
      case ParserPackage.CONDITIONAL_EXPRESSION__CEXPR:
        return getCExpr();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ParserPackage.CONDITIONAL_EXPRESSION__QEXPR:
        setQExpr((Expression)newValue);
        return;
      case ParserPackage.CONDITIONAL_EXPRESSION__CEXPR:
        setCExpr((Expression)newValue);
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
      case ParserPackage.CONDITIONAL_EXPRESSION__QEXPR:
        setQExpr((Expression)null);
        return;
      case ParserPackage.CONDITIONAL_EXPRESSION__CEXPR:
        setCExpr((Expression)null);
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
      case ParserPackage.CONDITIONAL_EXPRESSION__QEXPR:
        return qExpr != null;
      case ParserPackage.CONDITIONAL_EXPRESSION__CEXPR:
        return cExpr != null;
    }
    return super.eIsSet(featureID);
  }

} //ConditionalExpressionImpl
