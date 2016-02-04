/**
 */
package at.jku.weiner.kefax.kbuild.kbuild.impl;

import at.jku.weiner.kefax.kbuild.kbuild.KbuildPackage;
import at.jku.weiner.kefax.kbuild.kbuild.ObjectVariable;
import at.jku.weiner.kefax.kbuild.kbuild.Variable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectVariableImpl#getValue <em>Value</em>}</li>
 *   <li>{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectVariableImpl#getAdditional <em>Additional</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectVariableImpl extends ValueImpl implements ObjectVariable
{
  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected Variable value;

  /**
   * The default value of the '{@link #getAdditional() <em>Additional</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdditional()
   * @generated
   * @ordered
   */
  protected static final String ADDITIONAL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAdditional() <em>Additional</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdditional()
   * @generated
   * @ordered
   */
  protected String additional = ADDITIONAL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ObjectVariableImpl()
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
    return KbuildPackage.Literals.OBJECT_VARIABLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(Variable newValue, NotificationChain msgs)
  {
    Variable oldValue = value;
    value = newValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KbuildPackage.OBJECT_VARIABLE__VALUE, oldValue, newValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(Variable newValue)
  {
    if (newValue != value)
    {
      NotificationChain msgs = null;
      if (value != null)
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KbuildPackage.OBJECT_VARIABLE__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KbuildPackage.OBJECT_VARIABLE__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, KbuildPackage.OBJECT_VARIABLE__VALUE, newValue, newValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAdditional()
  {
    return additional;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdditional(String newAdditional)
  {
    String oldAdditional = additional;
    additional = newAdditional;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, KbuildPackage.OBJECT_VARIABLE__ADDITIONAL, oldAdditional, additional));
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
      case KbuildPackage.OBJECT_VARIABLE__VALUE:
        return basicSetValue(null, msgs);
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
      case KbuildPackage.OBJECT_VARIABLE__VALUE:
        return getValue();
      case KbuildPackage.OBJECT_VARIABLE__ADDITIONAL:
        return getAdditional();
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
      case KbuildPackage.OBJECT_VARIABLE__VALUE:
        setValue((Variable)newValue);
        return;
      case KbuildPackage.OBJECT_VARIABLE__ADDITIONAL:
        setAdditional((String)newValue);
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
      case KbuildPackage.OBJECT_VARIABLE__VALUE:
        setValue((Variable)null);
        return;
      case KbuildPackage.OBJECT_VARIABLE__ADDITIONAL:
        setAdditional(ADDITIONAL_EDEFAULT);
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
      case KbuildPackage.OBJECT_VARIABLE__VALUE:
        return value != null;
      case KbuildPackage.OBJECT_VARIABLE__ADDITIONAL:
        return ADDITIONAL_EDEFAULT == null ? additional != null : !ADDITIONAL_EDEFAULT.equals(additional);
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
    result.append(" (additional: ");
    result.append(additional);
    result.append(')');
    return result.toString();
  }

} //ObjectVariableImpl
