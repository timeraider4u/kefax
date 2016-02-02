/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.AssignmentExpression;
import at.jku.weiner.c.parser.parser.AssignmentOperator;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.ParserPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assignment Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AssignmentExpressionImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AssignmentExpressionImpl#getOp <em>Op</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AssignmentExpressionImpl#getAssignmentExpr <em>Assignment Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssignmentExpressionImpl extends ExpressionImpl implements AssignmentExpression
{
  /**
   * The cached value of the '{@link #getExpr() <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpr()
   * @generated
   * @ordered
   */
  protected Expression expr;

  /**
   * The cached value of the '{@link #getOp() <em>Op</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOp()
   * @generated
   * @ordered
   */
  protected AssignmentOperator op;

  /**
   * The cached value of the '{@link #getAssignmentExpr() <em>Assignment Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssignmentExpr()
   * @generated
   * @ordered
   */
  protected Expression assignmentExpr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssignmentExpressionImpl()
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
    return ParserPackage.Literals.ASSIGNMENT_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpr()
  {
    return expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpr(Expression newExpr, NotificationChain msgs)
  {
    Expression oldExpr = expr;
    expr = newExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.ASSIGNMENT_EXPRESSION__EXPR, oldExpr, newExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpr(Expression newExpr)
  {
    if (newExpr != expr)
    {
      NotificationChain msgs = null;
      if (expr != null)
        msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ASSIGNMENT_EXPRESSION__EXPR, null, msgs);
      if (newExpr != null)
        msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ASSIGNMENT_EXPRESSION__EXPR, null, msgs);
      msgs = basicSetExpr(newExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ASSIGNMENT_EXPRESSION__EXPR, newExpr, newExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentOperator getOp()
  {
    return op;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOp(AssignmentOperator newOp, NotificationChain msgs)
  {
    AssignmentOperator oldOp = op;
    op = newOp;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.ASSIGNMENT_EXPRESSION__OP, oldOp, newOp);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOp(AssignmentOperator newOp)
  {
    if (newOp != op)
    {
      NotificationChain msgs = null;
      if (op != null)
        msgs = ((InternalEObject)op).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ASSIGNMENT_EXPRESSION__OP, null, msgs);
      if (newOp != null)
        msgs = ((InternalEObject)newOp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ASSIGNMENT_EXPRESSION__OP, null, msgs);
      msgs = basicSetOp(newOp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ASSIGNMENT_EXPRESSION__OP, newOp, newOp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getAssignmentExpr()
  {
    return assignmentExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAssignmentExpr(Expression newAssignmentExpr, NotificationChain msgs)
  {
    Expression oldAssignmentExpr = assignmentExpr;
    assignmentExpr = newAssignmentExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPR, oldAssignmentExpr, newAssignmentExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssignmentExpr(Expression newAssignmentExpr)
  {
    if (newAssignmentExpr != assignmentExpr)
    {
      NotificationChain msgs = null;
      if (assignmentExpr != null)
        msgs = ((InternalEObject)assignmentExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPR, null, msgs);
      if (newAssignmentExpr != null)
        msgs = ((InternalEObject)newAssignmentExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPR, null, msgs);
      msgs = basicSetAssignmentExpr(newAssignmentExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPR, newAssignmentExpr, newAssignmentExpr));
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
      case ParserPackage.ASSIGNMENT_EXPRESSION__EXPR:
        return basicSetExpr(null, msgs);
      case ParserPackage.ASSIGNMENT_EXPRESSION__OP:
        return basicSetOp(null, msgs);
      case ParserPackage.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPR:
        return basicSetAssignmentExpr(null, msgs);
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
      case ParserPackage.ASSIGNMENT_EXPRESSION__EXPR:
        return getExpr();
      case ParserPackage.ASSIGNMENT_EXPRESSION__OP:
        return getOp();
      case ParserPackage.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPR:
        return getAssignmentExpr();
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
      case ParserPackage.ASSIGNMENT_EXPRESSION__EXPR:
        setExpr((Expression)newValue);
        return;
      case ParserPackage.ASSIGNMENT_EXPRESSION__OP:
        setOp((AssignmentOperator)newValue);
        return;
      case ParserPackage.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPR:
        setAssignmentExpr((Expression)newValue);
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
      case ParserPackage.ASSIGNMENT_EXPRESSION__EXPR:
        setExpr((Expression)null);
        return;
      case ParserPackage.ASSIGNMENT_EXPRESSION__OP:
        setOp((AssignmentOperator)null);
        return;
      case ParserPackage.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPR:
        setAssignmentExpr((Expression)null);
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
      case ParserPackage.ASSIGNMENT_EXPRESSION__EXPR:
        return expr != null;
      case ParserPackage.ASSIGNMENT_EXPRESSION__OP:
        return op != null;
      case ParserPackage.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPR:
        return assignmentExpr != null;
    }
    return super.eIsSet(featureID);
  }

} //AssignmentExpressionImpl
