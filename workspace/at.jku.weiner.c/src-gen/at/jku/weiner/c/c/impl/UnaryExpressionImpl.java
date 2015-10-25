/**
 */
package at.jku.weiner.c.c.impl;

import at.jku.weiner.c.c.CPackage;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.TypeName;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.c.UnaryOperator;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.impl.UnaryExpressionImpl#getPlusplus <em>Plusplus</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.UnaryExpressionImpl#getMinusminus <em>Minusminus</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.UnaryExpressionImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.UnaryExpressionImpl#getSizeOf <em>Size Of</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.UnaryExpressionImpl#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.UnaryExpressionImpl#getOp <em>Op</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnaryExpressionImpl extends ExpressionImpl implements UnaryExpression
{
  /**
   * The cached value of the '{@link #getPlusplus() <em>Plusplus</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPlusplus()
   * @generated
   * @ordered
   */
  protected EList<String> plusplus;

  /**
   * The cached value of the '{@link #getMinusminus() <em>Minusminus</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMinusminus()
   * @generated
   * @ordered
   */
  protected EList<String> minusminus;

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
   * The default value of the '{@link #getSizeOf() <em>Size Of</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSizeOf()
   * @generated
   * @ordered
   */
  protected static final String SIZE_OF_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSizeOf() <em>Size Of</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSizeOf()
   * @generated
   * @ordered
   */
  protected String sizeOf = SIZE_OF_EDEFAULT;

  /**
   * The cached value of the '{@link #getTypeName() <em>Type Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeName()
   * @generated
   * @ordered
   */
  protected TypeName typeName;

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
    return CPackage.Literals.UNARY_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getPlusplus()
  {
    if (plusplus == null)
    {
      plusplus = new EDataTypeEList<String>(String.class, this, CPackage.UNARY_EXPRESSION__PLUSPLUS);
    }
    return plusplus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getMinusminus()
  {
    if (minusminus == null)
    {
      minusminus = new EDataTypeEList<String>(String.class, this, CPackage.UNARY_EXPRESSION__MINUSMINUS);
    }
    return minusminus;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CPackage.UNARY_EXPRESSION__EXPR, oldExpr, newExpr);
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
        msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CPackage.UNARY_EXPRESSION__EXPR, null, msgs);
      if (newExpr != null)
        msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CPackage.UNARY_EXPRESSION__EXPR, null, msgs);
      msgs = basicSetExpr(newExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.UNARY_EXPRESSION__EXPR, newExpr, newExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSizeOf()
  {
    return sizeOf;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSizeOf(String newSizeOf)
  {
    String oldSizeOf = sizeOf;
    sizeOf = newSizeOf;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.UNARY_EXPRESSION__SIZE_OF, oldSizeOf, sizeOf));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeName getTypeName()
  {
    return typeName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypeName(TypeName newTypeName, NotificationChain msgs)
  {
    TypeName oldTypeName = typeName;
    typeName = newTypeName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CPackage.UNARY_EXPRESSION__TYPE_NAME, oldTypeName, newTypeName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeName(TypeName newTypeName)
  {
    if (newTypeName != typeName)
    {
      NotificationChain msgs = null;
      if (typeName != null)
        msgs = ((InternalEObject)typeName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CPackage.UNARY_EXPRESSION__TYPE_NAME, null, msgs);
      if (newTypeName != null)
        msgs = ((InternalEObject)newTypeName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CPackage.UNARY_EXPRESSION__TYPE_NAME, null, msgs);
      msgs = basicSetTypeName(newTypeName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.UNARY_EXPRESSION__TYPE_NAME, newTypeName, newTypeName));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CPackage.UNARY_EXPRESSION__OP, oldOp, newOp);
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
        msgs = ((InternalEObject)op).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CPackage.UNARY_EXPRESSION__OP, null, msgs);
      if (newOp != null)
        msgs = ((InternalEObject)newOp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CPackage.UNARY_EXPRESSION__OP, null, msgs);
      msgs = basicSetOp(newOp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.UNARY_EXPRESSION__OP, newOp, newOp));
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
      case CPackage.UNARY_EXPRESSION__EXPR:
        return basicSetExpr(null, msgs);
      case CPackage.UNARY_EXPRESSION__TYPE_NAME:
        return basicSetTypeName(null, msgs);
      case CPackage.UNARY_EXPRESSION__OP:
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
      case CPackage.UNARY_EXPRESSION__PLUSPLUS:
        return getPlusplus();
      case CPackage.UNARY_EXPRESSION__MINUSMINUS:
        return getMinusminus();
      case CPackage.UNARY_EXPRESSION__EXPR:
        return getExpr();
      case CPackage.UNARY_EXPRESSION__SIZE_OF:
        return getSizeOf();
      case CPackage.UNARY_EXPRESSION__TYPE_NAME:
        return getTypeName();
      case CPackage.UNARY_EXPRESSION__OP:
        return getOp();
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
      case CPackage.UNARY_EXPRESSION__PLUSPLUS:
        getPlusplus().clear();
        getPlusplus().addAll((Collection<? extends String>)newValue);
        return;
      case CPackage.UNARY_EXPRESSION__MINUSMINUS:
        getMinusminus().clear();
        getMinusminus().addAll((Collection<? extends String>)newValue);
        return;
      case CPackage.UNARY_EXPRESSION__EXPR:
        setExpr((Expression)newValue);
        return;
      case CPackage.UNARY_EXPRESSION__SIZE_OF:
        setSizeOf((String)newValue);
        return;
      case CPackage.UNARY_EXPRESSION__TYPE_NAME:
        setTypeName((TypeName)newValue);
        return;
      case CPackage.UNARY_EXPRESSION__OP:
        setOp((UnaryOperator)newValue);
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
      case CPackage.UNARY_EXPRESSION__PLUSPLUS:
        getPlusplus().clear();
        return;
      case CPackage.UNARY_EXPRESSION__MINUSMINUS:
        getMinusminus().clear();
        return;
      case CPackage.UNARY_EXPRESSION__EXPR:
        setExpr((Expression)null);
        return;
      case CPackage.UNARY_EXPRESSION__SIZE_OF:
        setSizeOf(SIZE_OF_EDEFAULT);
        return;
      case CPackage.UNARY_EXPRESSION__TYPE_NAME:
        setTypeName((TypeName)null);
        return;
      case CPackage.UNARY_EXPRESSION__OP:
        setOp((UnaryOperator)null);
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
      case CPackage.UNARY_EXPRESSION__PLUSPLUS:
        return plusplus != null && !plusplus.isEmpty();
      case CPackage.UNARY_EXPRESSION__MINUSMINUS:
        return minusminus != null && !minusminus.isEmpty();
      case CPackage.UNARY_EXPRESSION__EXPR:
        return expr != null;
      case CPackage.UNARY_EXPRESSION__SIZE_OF:
        return SIZE_OF_EDEFAULT == null ? sizeOf != null : !SIZE_OF_EDEFAULT.equals(sizeOf);
      case CPackage.UNARY_EXPRESSION__TYPE_NAME:
        return typeName != null;
      case CPackage.UNARY_EXPRESSION__OP:
        return op != null;
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
    result.append(", sizeOf: ");
    result.append(sizeOf);
    result.append(')');
    return result.toString();
  }

} //UnaryExpressionImpl
