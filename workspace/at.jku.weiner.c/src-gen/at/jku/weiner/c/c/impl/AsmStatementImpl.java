/**
 */
package at.jku.weiner.c.c.impl;

import at.jku.weiner.c.c.AsmStatement;
import at.jku.weiner.c.c.CPackage;
import at.jku.weiner.c.c.Expression;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Asm Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.impl.AsmStatementImpl#getVolatile <em>Volatile</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.AsmStatementImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.AsmStatementImpl#getSemi <em>Semi</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AsmStatementImpl extends StatementImpl implements AsmStatement
{
  /**
   * The default value of the '{@link #getVolatile() <em>Volatile</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVolatile()
   * @generated
   * @ordered
   */
  protected static final String VOLATILE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVolatile() <em>Volatile</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVolatile()
   * @generated
   * @ordered
   */
  protected String volatile_ = VOLATILE_EDEFAULT;

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
   * The default value of the '{@link #getSemi() <em>Semi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSemi()
   * @generated
   * @ordered
   */
  protected static final String SEMI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSemi() <em>Semi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSemi()
   * @generated
   * @ordered
   */
  protected String semi = SEMI_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AsmStatementImpl()
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
    return CPackage.Literals.ASM_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVolatile()
  {
    return volatile_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVolatile(String newVolatile)
  {
    String oldVolatile = volatile_;
    volatile_ = newVolatile;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.ASM_STATEMENT__VOLATILE, oldVolatile, volatile_));
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
      expr = new EObjectContainmentEList<Expression>(Expression.class, this, CPackage.ASM_STATEMENT__EXPR);
    }
    return expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSemi()
  {
    return semi;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSemi(String newSemi)
  {
    String oldSemi = semi;
    semi = newSemi;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.ASM_STATEMENT__SEMI, oldSemi, semi));
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
      case CPackage.ASM_STATEMENT__EXPR:
        return ((InternalEList<?>)getExpr()).basicRemove(otherEnd, msgs);
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
      case CPackage.ASM_STATEMENT__VOLATILE:
        return getVolatile();
      case CPackage.ASM_STATEMENT__EXPR:
        return getExpr();
      case CPackage.ASM_STATEMENT__SEMI:
        return getSemi();
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
      case CPackage.ASM_STATEMENT__VOLATILE:
        setVolatile((String)newValue);
        return;
      case CPackage.ASM_STATEMENT__EXPR:
        getExpr().clear();
        getExpr().addAll((Collection<? extends Expression>)newValue);
        return;
      case CPackage.ASM_STATEMENT__SEMI:
        setSemi((String)newValue);
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
      case CPackage.ASM_STATEMENT__VOLATILE:
        setVolatile(VOLATILE_EDEFAULT);
        return;
      case CPackage.ASM_STATEMENT__EXPR:
        getExpr().clear();
        return;
      case CPackage.ASM_STATEMENT__SEMI:
        setSemi(SEMI_EDEFAULT);
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
      case CPackage.ASM_STATEMENT__VOLATILE:
        return VOLATILE_EDEFAULT == null ? volatile_ != null : !VOLATILE_EDEFAULT.equals(volatile_);
      case CPackage.ASM_STATEMENT__EXPR:
        return expr != null && !expr.isEmpty();
      case CPackage.ASM_STATEMENT__SEMI:
        return SEMI_EDEFAULT == null ? semi != null : !SEMI_EDEFAULT.equals(semi);
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
    result.append(" (volatile: ");
    result.append(volatile_);
    result.append(", semi: ");
    result.append(semi);
    result.append(')');
    return result.toString();
  }

} //AsmStatementImpl
