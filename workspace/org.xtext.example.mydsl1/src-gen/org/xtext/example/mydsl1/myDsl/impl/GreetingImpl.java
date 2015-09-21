/**
 */
package org.xtext.example.mydsl1.myDsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.example.mydsl1.myDsl.Greeting;
import org.xtext.example.mydsl1.myDsl.Inc;
import org.xtext.example.mydsl1.myDsl.MyDslPackage;
import org.xtext.example.mydsl1.myDsl.Reset;
import org.xtext.example.mydsl1.myDsl.Test;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Greeting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl1.myDsl.impl.GreetingImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.example.mydsl1.myDsl.impl.GreetingImpl#getTest <em>Test</em>}</li>
 *   <li>{@link org.xtext.example.mydsl1.myDsl.impl.GreetingImpl#getReset <em>Reset</em>}</li>
 *   <li>{@link org.xtext.example.mydsl1.myDsl.impl.GreetingImpl#getInc <em>Inc</em>}</li>
 *   <li>{@link org.xtext.example.mydsl1.myDsl.impl.GreetingImpl#getDynamic <em>Dynamic</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GreetingImpl extends MinimalEObjectImpl.Container implements Greeting
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getTest() <em>Test</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTest()
   * @generated
   * @ordered
   */
  protected Test test;

  /**
   * The cached value of the '{@link #getReset() <em>Reset</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReset()
   * @generated
   * @ordered
   */
  protected Reset reset;

  /**
   * The cached value of the '{@link #getInc() <em>Inc</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInc()
   * @generated
   * @ordered
   */
  protected EList<Inc> inc;

  /**
   * The cached value of the '{@link #getDynamic() <em>Dynamic</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDynamic()
   * @generated
   * @ordered
   */
  protected org.xtext.example.mydsl1.myDsl.Dynamic dynamic;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GreetingImpl()
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
    return MyDslPackage.Literals.GREETING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.GREETING__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Test getTest()
  {
    return test;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTest(Test newTest, NotificationChain msgs)
  {
    Test oldTest = test;
    test = newTest;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.GREETING__TEST, oldTest, newTest);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTest(Test newTest)
  {
    if (newTest != test)
    {
      NotificationChain msgs = null;
      if (test != null)
        msgs = ((InternalEObject)test).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.GREETING__TEST, null, msgs);
      if (newTest != null)
        msgs = ((InternalEObject)newTest).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.GREETING__TEST, null, msgs);
      msgs = basicSetTest(newTest, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.GREETING__TEST, newTest, newTest));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Reset getReset()
  {
    return reset;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReset(Reset newReset, NotificationChain msgs)
  {
    Reset oldReset = reset;
    reset = newReset;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.GREETING__RESET, oldReset, newReset);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReset(Reset newReset)
  {
    if (newReset != reset)
    {
      NotificationChain msgs = null;
      if (reset != null)
        msgs = ((InternalEObject)reset).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.GREETING__RESET, null, msgs);
      if (newReset != null)
        msgs = ((InternalEObject)newReset).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.GREETING__RESET, null, msgs);
      msgs = basicSetReset(newReset, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.GREETING__RESET, newReset, newReset));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Inc> getInc()
  {
    if (inc == null)
    {
      inc = new EObjectContainmentEList<Inc>(Inc.class, this, MyDslPackage.GREETING__INC);
    }
    return inc;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.xtext.example.mydsl1.myDsl.Dynamic getDynamic()
  {
    return dynamic;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDynamic(org.xtext.example.mydsl1.myDsl.Dynamic newDynamic, NotificationChain msgs)
  {
    org.xtext.example.mydsl1.myDsl.Dynamic oldDynamic = dynamic;
    dynamic = newDynamic;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.GREETING__DYNAMIC, oldDynamic, newDynamic);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDynamic(org.xtext.example.mydsl1.myDsl.Dynamic newDynamic)
  {
    if (newDynamic != dynamic)
    {
      NotificationChain msgs = null;
      if (dynamic != null)
        msgs = ((InternalEObject)dynamic).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.GREETING__DYNAMIC, null, msgs);
      if (newDynamic != null)
        msgs = ((InternalEObject)newDynamic).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.GREETING__DYNAMIC, null, msgs);
      msgs = basicSetDynamic(newDynamic, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.GREETING__DYNAMIC, newDynamic, newDynamic));
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
      case MyDslPackage.GREETING__TEST:
        return basicSetTest(null, msgs);
      case MyDslPackage.GREETING__RESET:
        return basicSetReset(null, msgs);
      case MyDslPackage.GREETING__INC:
        return ((InternalEList<?>)getInc()).basicRemove(otherEnd, msgs);
      case MyDslPackage.GREETING__DYNAMIC:
        return basicSetDynamic(null, msgs);
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
      case MyDslPackage.GREETING__NAME:
        return getName();
      case MyDslPackage.GREETING__TEST:
        return getTest();
      case MyDslPackage.GREETING__RESET:
        return getReset();
      case MyDslPackage.GREETING__INC:
        return getInc();
      case MyDslPackage.GREETING__DYNAMIC:
        return getDynamic();
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
      case MyDslPackage.GREETING__NAME:
        setName((String)newValue);
        return;
      case MyDslPackage.GREETING__TEST:
        setTest((Test)newValue);
        return;
      case MyDslPackage.GREETING__RESET:
        setReset((Reset)newValue);
        return;
      case MyDslPackage.GREETING__INC:
        getInc().clear();
        getInc().addAll((Collection<? extends Inc>)newValue);
        return;
      case MyDslPackage.GREETING__DYNAMIC:
        setDynamic((org.xtext.example.mydsl1.myDsl.Dynamic)newValue);
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
      case MyDslPackage.GREETING__NAME:
        setName(NAME_EDEFAULT);
        return;
      case MyDslPackage.GREETING__TEST:
        setTest((Test)null);
        return;
      case MyDslPackage.GREETING__RESET:
        setReset((Reset)null);
        return;
      case MyDslPackage.GREETING__INC:
        getInc().clear();
        return;
      case MyDslPackage.GREETING__DYNAMIC:
        setDynamic((org.xtext.example.mydsl1.myDsl.Dynamic)null);
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
      case MyDslPackage.GREETING__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case MyDslPackage.GREETING__TEST:
        return test != null;
      case MyDslPackage.GREETING__RESET:
        return reset != null;
      case MyDslPackage.GREETING__INC:
        return inc != null && !inc.isEmpty();
      case MyDslPackage.GREETING__DYNAMIC:
        return dynamic != null;
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //GreetingImpl
