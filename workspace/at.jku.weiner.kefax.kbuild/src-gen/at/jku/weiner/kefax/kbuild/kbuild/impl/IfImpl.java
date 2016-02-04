/**
 */
package at.jku.weiner.kefax.kbuild.kbuild.impl;

import at.jku.weiner.kefax.kbuild.kbuild.If;
import at.jku.weiner.kefax.kbuild.kbuild.KbuildPackage;
import at.jku.weiner.kefax.kbuild.kbuild.ShellCmd;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.kefax.kbuild.kbuild.impl.IfImpl#getShell <em>Shell</em>}</li>
 *   <li>{@link at.jku.weiner.kefax.kbuild.kbuild.impl.IfImpl#getValue <em>Value</em>}</li>
 *   <li>{@link at.jku.weiner.kefax.kbuild.kbuild.impl.IfImpl#getElsevalue <em>Elsevalue</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfImpl extends MinimalEObjectImpl.Container implements If
{
  /**
   * The cached value of the '{@link #getShell() <em>Shell</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShell()
   * @generated
   * @ordered
   */
  protected ShellCmd shell;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected EObject value;

  /**
   * The cached value of the '{@link #getElsevalue() <em>Elsevalue</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElsevalue()
   * @generated
   * @ordered
   */
  protected EObject elsevalue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IfImpl()
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
    return KbuildPackage.Literals.IF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShellCmd getShell()
  {
    return shell;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetShell(ShellCmd newShell, NotificationChain msgs)
  {
    ShellCmd oldShell = shell;
    shell = newShell;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KbuildPackage.IF__SHELL, oldShell, newShell);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setShell(ShellCmd newShell)
  {
    if (newShell != shell)
    {
      NotificationChain msgs = null;
      if (shell != null)
        msgs = ((InternalEObject)shell).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KbuildPackage.IF__SHELL, null, msgs);
      if (newShell != null)
        msgs = ((InternalEObject)newShell).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KbuildPackage.IF__SHELL, null, msgs);
      msgs = basicSetShell(newShell, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, KbuildPackage.IF__SHELL, newShell, newShell));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(EObject newValue, NotificationChain msgs)
  {
    EObject oldValue = value;
    value = newValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KbuildPackage.IF__VALUE, oldValue, newValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(EObject newValue)
  {
    if (newValue != value)
    {
      NotificationChain msgs = null;
      if (value != null)
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KbuildPackage.IF__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KbuildPackage.IF__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, KbuildPackage.IF__VALUE, newValue, newValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getElsevalue()
  {
    return elsevalue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElsevalue(EObject newElsevalue, NotificationChain msgs)
  {
    EObject oldElsevalue = elsevalue;
    elsevalue = newElsevalue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KbuildPackage.IF__ELSEVALUE, oldElsevalue, newElsevalue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElsevalue(EObject newElsevalue)
  {
    if (newElsevalue != elsevalue)
    {
      NotificationChain msgs = null;
      if (elsevalue != null)
        msgs = ((InternalEObject)elsevalue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KbuildPackage.IF__ELSEVALUE, null, msgs);
      if (newElsevalue != null)
        msgs = ((InternalEObject)newElsevalue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KbuildPackage.IF__ELSEVALUE, null, msgs);
      msgs = basicSetElsevalue(newElsevalue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, KbuildPackage.IF__ELSEVALUE, newElsevalue, newElsevalue));
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
      case KbuildPackage.IF__SHELL:
        return basicSetShell(null, msgs);
      case KbuildPackage.IF__VALUE:
        return basicSetValue(null, msgs);
      case KbuildPackage.IF__ELSEVALUE:
        return basicSetElsevalue(null, msgs);
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
      case KbuildPackage.IF__SHELL:
        return getShell();
      case KbuildPackage.IF__VALUE:
        return getValue();
      case KbuildPackage.IF__ELSEVALUE:
        return getElsevalue();
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
      case KbuildPackage.IF__SHELL:
        setShell((ShellCmd)newValue);
        return;
      case KbuildPackage.IF__VALUE:
        setValue((EObject)newValue);
        return;
      case KbuildPackage.IF__ELSEVALUE:
        setElsevalue((EObject)newValue);
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
      case KbuildPackage.IF__SHELL:
        setShell((ShellCmd)null);
        return;
      case KbuildPackage.IF__VALUE:
        setValue((EObject)null);
        return;
      case KbuildPackage.IF__ELSEVALUE:
        setElsevalue((EObject)null);
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
      case KbuildPackage.IF__SHELL:
        return shell != null;
      case KbuildPackage.IF__VALUE:
        return value != null;
      case KbuildPackage.IF__ELSEVALUE:
        return elsevalue != null;
    }
    return super.eIsSet(featureID);
  }

} //IfImpl
