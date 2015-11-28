/**
 */
package at.jku.weiner.c.preprocess.preprocess.impl;

import at.jku.weiner.c.preprocess.preprocess.Expression;
import at.jku.weiner.c.preprocess.preprocess.PreprocessPackage;
import at.jku.weiner.c.preprocess.preprocess.UnaryExpression;
import at.jku.weiner.c.preprocess.preprocess.UnaryOperator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.UnaryExpressionImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.UnaryExpressionImpl#getPlusplus <em>Plusplus</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.UnaryExpressionImpl#getMinusminus <em>Minusminus</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.UnaryExpressionImpl#getOp <em>Op</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.UnaryExpressionImpl#getAndand <em>Andand</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.UnaryExpressionImpl#getId <em>Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnaryExpressionImpl extends ExpressionImpl implements UnaryExpression
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
   * The default value of the '{@link #getPlusplus() <em>Plusplus</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPlusplus()
   * @generated
   * @ordered
   */
  protected static final String PLUSPLUS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPlusplus() <em>Plusplus</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPlusplus()
   * @generated
   * @ordered
   */
  protected String plusplus = PLUSPLUS_EDEFAULT;

  /**
   * The default value of the '{@link #getMinusminus() <em>Minusminus</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMinusminus()
   * @generated
   * @ordered
   */
  protected static final String MINUSMINUS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMinusminus() <em>Minusminus</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMinusminus()
   * @generated
   * @ordered
   */
  protected String minusminus = MINUSMINUS_EDEFAULT;

  /**
   * The cached value of the '{@link #getOp() <em>Op</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOp()
   * @generated
   * @ordered
   */
  protected UnaryOperator op;

  /**
   * The default value of the '{@link #getAndand() <em>Andand</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAndand()
   * @generated
   * @ordered
   */
  protected static final String ANDAND_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAndand() <em>Andand</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAndand()
   * @generated
   * @ordered
   */
  protected String andand = ANDAND_EDEFAULT;

  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UnaryExpressionImpl()
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
    return PreprocessPackage.Literals.UNARY_EXPRESSION;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PreprocessPackage.UNARY_EXPRESSION__EXPR, oldExpr, newExpr);
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
        msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PreprocessPackage.UNARY_EXPRESSION__EXPR, null, msgs);
      if (newExpr != null)
        msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PreprocessPackage.UNARY_EXPRESSION__EXPR, null, msgs);
      msgs = basicSetExpr(newExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PreprocessPackage.UNARY_EXPRESSION__EXPR, newExpr, newExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPlusplus()
  {
    return plusplus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPlusplus(String newPlusplus)
  {
    String oldPlusplus = plusplus;
    plusplus = newPlusplus;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PreprocessPackage.UNARY_EXPRESSION__PLUSPLUS, oldPlusplus, plusplus));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMinusminus()
  {
    return minusminus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMinusminus(String newMinusminus)
  {
    String oldMinusminus = minusminus;
    minusminus = newMinusminus;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PreprocessPackage.UNARY_EXPRESSION__MINUSMINUS, oldMinusminus, minusminus));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryOperator getOp()
  {
    return op;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOp(UnaryOperator newOp, NotificationChain msgs)
  {
    UnaryOperator oldOp = op;
    op = newOp;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PreprocessPackage.UNARY_EXPRESSION__OP, oldOp, newOp);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOp(UnaryOperator newOp)
  {
    if (newOp != op)
    {
      NotificationChain msgs = null;
      if (op != null)
        msgs = ((InternalEObject)op).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PreprocessPackage.UNARY_EXPRESSION__OP, null, msgs);
      if (newOp != null)
        msgs = ((InternalEObject)newOp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PreprocessPackage.UNARY_EXPRESSION__OP, null, msgs);
      msgs = basicSetOp(newOp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PreprocessPackage.UNARY_EXPRESSION__OP, newOp, newOp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAndand()
  {
    return andand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAndand(String newAndand)
  {
    String oldAndand = andand;
    andand = newAndand;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PreprocessPackage.UNARY_EXPRESSION__ANDAND, oldAndand, andand));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(String newId)
  {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PreprocessPackage.UNARY_EXPRESSION__ID, oldId, id));
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
      case PreprocessPackage.UNARY_EXPRESSION__EXPR:
        return basicSetExpr(null, msgs);
      case PreprocessPackage.UNARY_EXPRESSION__OP:
        return basicSetOp(null, msgs);
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
      case PreprocessPackage.UNARY_EXPRESSION__EXPR:
        return getExpr();
      case PreprocessPackage.UNARY_EXPRESSION__PLUSPLUS:
        return getPlusplus();
      case PreprocessPackage.UNARY_EXPRESSION__MINUSMINUS:
        return getMinusminus();
      case PreprocessPackage.UNARY_EXPRESSION__OP:
        return getOp();
      case PreprocessPackage.UNARY_EXPRESSION__ANDAND:
        return getAndand();
      case PreprocessPackage.UNARY_EXPRESSION__ID:
        return getId();
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
      case PreprocessPackage.UNARY_EXPRESSION__EXPR:
        setExpr((Expression)newValue);
        return;
      case PreprocessPackage.UNARY_EXPRESSION__PLUSPLUS:
        setPlusplus((String)newValue);
        return;
      case PreprocessPackage.UNARY_EXPRESSION__MINUSMINUS:
        setMinusminus((String)newValue);
        return;
      case PreprocessPackage.UNARY_EXPRESSION__OP:
        setOp((UnaryOperator)newValue);
        return;
      case PreprocessPackage.UNARY_EXPRESSION__ANDAND:
        setAndand((String)newValue);
        return;
      case PreprocessPackage.UNARY_EXPRESSION__ID:
        setId((String)newValue);
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
      case PreprocessPackage.UNARY_EXPRESSION__EXPR:
        setExpr((Expression)null);
        return;
      case PreprocessPackage.UNARY_EXPRESSION__PLUSPLUS:
        setPlusplus(PLUSPLUS_EDEFAULT);
        return;
      case PreprocessPackage.UNARY_EXPRESSION__MINUSMINUS:
        setMinusminus(MINUSMINUS_EDEFAULT);
        return;
      case PreprocessPackage.UNARY_EXPRESSION__OP:
        setOp((UnaryOperator)null);
        return;
      case PreprocessPackage.UNARY_EXPRESSION__ANDAND:
        setAndand(ANDAND_EDEFAULT);
        return;
      case PreprocessPackage.UNARY_EXPRESSION__ID:
        setId(ID_EDEFAULT);
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
      case PreprocessPackage.UNARY_EXPRESSION__EXPR:
        return expr != null;
      case PreprocessPackage.UNARY_EXPRESSION__PLUSPLUS:
        return PLUSPLUS_EDEFAULT == null ? plusplus != null : !PLUSPLUS_EDEFAULT.equals(plusplus);
      case PreprocessPackage.UNARY_EXPRESSION__MINUSMINUS:
        return MINUSMINUS_EDEFAULT == null ? minusminus != null : !MINUSMINUS_EDEFAULT.equals(minusminus);
      case PreprocessPackage.UNARY_EXPRESSION__OP:
        return op != null;
      case PreprocessPackage.UNARY_EXPRESSION__ANDAND:
        return ANDAND_EDEFAULT == null ? andand != null : !ANDAND_EDEFAULT.equals(andand);
      case PreprocessPackage.UNARY_EXPRESSION__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (plusplus: ");
    result.append(plusplus);
    result.append(", minusminus: ");
    result.append(minusminus);
    result.append(", andand: ");
    result.append(andand);
    result.append(", id: ");
    result.append(id);
    result.append(')');
    return result.toString();
  }

} //UnaryExpressionImpl
