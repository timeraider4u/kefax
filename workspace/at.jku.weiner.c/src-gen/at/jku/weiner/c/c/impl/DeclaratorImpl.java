/**
 */
package at.jku.weiner.c.c.impl;

import at.jku.weiner.c.c.CPackage;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declarator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.impl.DeclaratorImpl#getDeclarator <em>Declarator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeclaratorImpl extends MinimalEObjectImpl.Container implements Declarator
{
  /**
   * The cached value of the '{@link #getDeclarator() <em>Declarator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeclarator()
   * @generated
   * @ordered
   */
  protected DirectDeclarator declarator;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DeclaratorImpl()
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
    return CPackage.Literals.DECLARATOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DirectDeclarator getDeclarator()
  {
    return declarator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDeclarator(DirectDeclarator newDeclarator, NotificationChain msgs)
  {
    DirectDeclarator oldDeclarator = declarator;
    declarator = newDeclarator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CPackage.DECLARATOR__DECLARATOR, oldDeclarator, newDeclarator);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDeclarator(DirectDeclarator newDeclarator)
  {
    if (newDeclarator != declarator)
    {
      NotificationChain msgs = null;
      if (declarator != null)
        msgs = ((InternalEObject)declarator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CPackage.DECLARATOR__DECLARATOR, null, msgs);
      if (newDeclarator != null)
        msgs = ((InternalEObject)newDeclarator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CPackage.DECLARATOR__DECLARATOR, null, msgs);
      msgs = basicSetDeclarator(newDeclarator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.DECLARATOR__DECLARATOR, newDeclarator, newDeclarator));
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
      case CPackage.DECLARATOR__DECLARATOR:
        return basicSetDeclarator(null, msgs);
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
      case CPackage.DECLARATOR__DECLARATOR:
        return getDeclarator();
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
      case CPackage.DECLARATOR__DECLARATOR:
        setDeclarator((DirectDeclarator)newValue);
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
      case CPackage.DECLARATOR__DECLARATOR:
        setDeclarator((DirectDeclarator)null);
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
      case CPackage.DECLARATOR__DECLARATOR:
        return declarator != null;
    }
    return super.eIsSet(featureID);
  }

} //DeclaratorImpl
