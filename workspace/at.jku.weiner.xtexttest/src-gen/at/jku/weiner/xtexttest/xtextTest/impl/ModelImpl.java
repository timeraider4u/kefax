/**
 */
package at.jku.weiner.xtexttest.xtextTest.impl;

import at.jku.weiner.xtexttest.xtextTest.EmfTest;
import at.jku.weiner.xtexttest.xtextTest.Model;
import at.jku.weiner.xtexttest.xtextTest.XtextTest;
import at.jku.weiner.xtexttest.xtextTest.XtextTestPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.ModelImpl#getXtextTest <em>Xtext Test</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.ModelImpl#getEmfTest <em>Emf Test</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getXtextTest() <em>Xtext Test</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXtextTest()
   * @generated
   * @ordered
   */
  protected XtextTest xtextTest;

  /**
   * The cached value of the '{@link #getEmfTest() <em>Emf Test</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEmfTest()
   * @generated
   * @ordered
   */
  protected EmfTest emfTest;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelImpl()
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
    return XtextTestPackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XtextTest getXtextTest()
  {
    return xtextTest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetXtextTest(XtextTest newXtextTest, NotificationChain msgs)
  {
    XtextTest oldXtextTest = xtextTest;
    xtextTest = newXtextTest;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtextTestPackage.MODEL__XTEXT_TEST, oldXtextTest, newXtextTest);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setXtextTest(XtextTest newXtextTest)
  {
    if (newXtextTest != xtextTest)
    {
      NotificationChain msgs = null;
      if (xtextTest != null)
        msgs = ((InternalEObject)xtextTest).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.MODEL__XTEXT_TEST, null, msgs);
      if (newXtextTest != null)
        msgs = ((InternalEObject)newXtextTest).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.MODEL__XTEXT_TEST, null, msgs);
      msgs = basicSetXtextTest(newXtextTest, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.MODEL__XTEXT_TEST, newXtextTest, newXtextTest));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EmfTest getEmfTest()
  {
    return emfTest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEmfTest(EmfTest newEmfTest, NotificationChain msgs)
  {
    EmfTest oldEmfTest = emfTest;
    emfTest = newEmfTest;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtextTestPackage.MODEL__EMF_TEST, oldEmfTest, newEmfTest);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEmfTest(EmfTest newEmfTest)
  {
    if (newEmfTest != emfTest)
    {
      NotificationChain msgs = null;
      if (emfTest != null)
        msgs = ((InternalEObject)emfTest).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.MODEL__EMF_TEST, null, msgs);
      if (newEmfTest != null)
        msgs = ((InternalEObject)newEmfTest).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.MODEL__EMF_TEST, null, msgs);
      msgs = basicSetEmfTest(newEmfTest, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.MODEL__EMF_TEST, newEmfTest, newEmfTest));
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
      case XtextTestPackage.MODEL__XTEXT_TEST:
        return basicSetXtextTest(null, msgs);
      case XtextTestPackage.MODEL__EMF_TEST:
        return basicSetEmfTest(null, msgs);
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
      case XtextTestPackage.MODEL__XTEXT_TEST:
        return getXtextTest();
      case XtextTestPackage.MODEL__EMF_TEST:
        return getEmfTest();
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
      case XtextTestPackage.MODEL__XTEXT_TEST:
        setXtextTest((XtextTest)newValue);
        return;
      case XtextTestPackage.MODEL__EMF_TEST:
        setEmfTest((EmfTest)newValue);
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
      case XtextTestPackage.MODEL__XTEXT_TEST:
        setXtextTest((XtextTest)null);
        return;
      case XtextTestPackage.MODEL__EMF_TEST:
        setEmfTest((EmfTest)null);
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
      case XtextTestPackage.MODEL__XTEXT_TEST:
        return xtextTest != null;
      case XtextTestPackage.MODEL__EMF_TEST:
        return emfTest != null;
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl
