/**
 */
package at.jku.weiner.c.preprocess.preprocess.impl;

import at.jku.weiner.c.common.common.Expression;

import at.jku.weiner.c.preprocess.preprocess.PreprocessPackage;
import at.jku.weiner.c.preprocess.preprocess.PrimaryExpression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primary Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.PrimaryExpressionImpl#isDefined <em>Defined</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.PrimaryExpressionImpl#getId <em>Id</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.PrimaryExpressionImpl#getConst <em>Const</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.PrimaryExpressionImpl#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PrimaryExpressionImpl extends ExpressionImpl implements PrimaryExpression
{
  /**
   * The default value of the '{@link #isDefined() <em>Defined</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDefined()
   * @generated
   * @ordered
   */
  protected static final boolean DEFINED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDefined() <em>Defined</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDefined()
   * @generated
   * @ordered
   */
  protected boolean defined = DEFINED_EDEFAULT;

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
   * The default value of the '{@link #getConst() <em>Const</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConst()
   * @generated
   * @ordered
   */
  protected static final String CONST_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getConst() <em>Const</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConst()
   * @generated
   * @ordered
   */
  protected String const_ = CONST_EDEFAULT;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PrimaryExpressionImpl()
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
    return PreprocessPackage.Literals.PRIMARY_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDefined()
  {
    return defined;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefined(boolean newDefined)
  {
    boolean oldDefined = defined;
    defined = newDefined;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PreprocessPackage.PRIMARY_EXPRESSION__DEFINED, oldDefined, defined));
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
      eNotify(new ENotificationImpl(this, Notification.SET, PreprocessPackage.PRIMARY_EXPRESSION__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getConst()
  {
    return const_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConst(String newConst)
  {
    String oldConst = const_;
    const_ = newConst;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PreprocessPackage.PRIMARY_EXPRESSION__CONST, oldConst, const_));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PreprocessPackage.PRIMARY_EXPRESSION__EXPR, oldExpr, newExpr);
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
        msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PreprocessPackage.PRIMARY_EXPRESSION__EXPR, null, msgs);
      if (newExpr != null)
        msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PreprocessPackage.PRIMARY_EXPRESSION__EXPR, null, msgs);
      msgs = basicSetExpr(newExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PreprocessPackage.PRIMARY_EXPRESSION__EXPR, newExpr, newExpr));
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
      case PreprocessPackage.PRIMARY_EXPRESSION__EXPR:
        return basicSetExpr(null, msgs);
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
      case PreprocessPackage.PRIMARY_EXPRESSION__DEFINED:
        return isDefined();
      case PreprocessPackage.PRIMARY_EXPRESSION__ID:
        return getId();
      case PreprocessPackage.PRIMARY_EXPRESSION__CONST:
        return getConst();
      case PreprocessPackage.PRIMARY_EXPRESSION__EXPR:
        return getExpr();
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
      case PreprocessPackage.PRIMARY_EXPRESSION__DEFINED:
        setDefined((Boolean)newValue);
        return;
      case PreprocessPackage.PRIMARY_EXPRESSION__ID:
        setId((String)newValue);
        return;
      case PreprocessPackage.PRIMARY_EXPRESSION__CONST:
        setConst((String)newValue);
        return;
      case PreprocessPackage.PRIMARY_EXPRESSION__EXPR:
        setExpr((Expression)newValue);
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
      case PreprocessPackage.PRIMARY_EXPRESSION__DEFINED:
        setDefined(DEFINED_EDEFAULT);
        return;
      case PreprocessPackage.PRIMARY_EXPRESSION__ID:
        setId(ID_EDEFAULT);
        return;
      case PreprocessPackage.PRIMARY_EXPRESSION__CONST:
        setConst(CONST_EDEFAULT);
        return;
      case PreprocessPackage.PRIMARY_EXPRESSION__EXPR:
        setExpr((Expression)null);
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
      case PreprocessPackage.PRIMARY_EXPRESSION__DEFINED:
        return defined != DEFINED_EDEFAULT;
      case PreprocessPackage.PRIMARY_EXPRESSION__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case PreprocessPackage.PRIMARY_EXPRESSION__CONST:
        return CONST_EDEFAULT == null ? const_ != null : !CONST_EDEFAULT.equals(const_);
      case PreprocessPackage.PRIMARY_EXPRESSION__EXPR:
        return expr != null;
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
    result.append(" (defined: ");
    result.append(defined);
    result.append(", id: ");
    result.append(id);
    result.append(", const: ");
    result.append(const_);
    result.append(')');
    return result.toString();
  }

} //PrimaryExpressionImpl
