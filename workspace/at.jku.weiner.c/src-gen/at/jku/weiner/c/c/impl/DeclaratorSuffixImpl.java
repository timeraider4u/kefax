/**
 */
package at.jku.weiner.c.c.impl;

import at.jku.weiner.c.c.CPackage;
import at.jku.weiner.c.c.DeclaratorSuffix;
import at.jku.weiner.c.c.DirectDeclaratorLastSuffix;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declarator Suffix</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.impl.DeclaratorSuffixImpl#getLastSuffix <em>Last Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeclaratorSuffixImpl extends MinimalEObjectImpl.Container implements DeclaratorSuffix
{
  /**
   * The cached value of the '{@link #getLastSuffix() <em>Last Suffix</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLastSuffix()
   * @generated
   * @ordered
   */
  protected DirectDeclaratorLastSuffix lastSuffix;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DeclaratorSuffixImpl()
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
    return CPackage.Literals.DECLARATOR_SUFFIX;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DirectDeclaratorLastSuffix getLastSuffix()
  {
    return lastSuffix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLastSuffix(DirectDeclaratorLastSuffix newLastSuffix, NotificationChain msgs)
  {
    DirectDeclaratorLastSuffix oldLastSuffix = lastSuffix;
    lastSuffix = newLastSuffix;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CPackage.DECLARATOR_SUFFIX__LAST_SUFFIX, oldLastSuffix, newLastSuffix);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLastSuffix(DirectDeclaratorLastSuffix newLastSuffix)
  {
    if (newLastSuffix != lastSuffix)
    {
      NotificationChain msgs = null;
      if (lastSuffix != null)
        msgs = ((InternalEObject)lastSuffix).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CPackage.DECLARATOR_SUFFIX__LAST_SUFFIX, null, msgs);
      if (newLastSuffix != null)
        msgs = ((InternalEObject)newLastSuffix).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CPackage.DECLARATOR_SUFFIX__LAST_SUFFIX, null, msgs);
      msgs = basicSetLastSuffix(newLastSuffix, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.DECLARATOR_SUFFIX__LAST_SUFFIX, newLastSuffix, newLastSuffix));
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
      case CPackage.DECLARATOR_SUFFIX__LAST_SUFFIX:
        return basicSetLastSuffix(null, msgs);
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
      case CPackage.DECLARATOR_SUFFIX__LAST_SUFFIX:
        return getLastSuffix();
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
      case CPackage.DECLARATOR_SUFFIX__LAST_SUFFIX:
        setLastSuffix((DirectDeclaratorLastSuffix)newValue);
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
      case CPackage.DECLARATOR_SUFFIX__LAST_SUFFIX:
        setLastSuffix((DirectDeclaratorLastSuffix)null);
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
      case CPackage.DECLARATOR_SUFFIX__LAST_SUFFIX:
        return lastSuffix != null;
    }
    return super.eIsSet(featureID);
  }

} //DeclaratorSuffixImpl
