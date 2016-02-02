/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.Designation;
import at.jku.weiner.c.parser.parser.Init;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.ParserPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Init</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.InitImpl#getDesignation <em>Designation</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.InitImpl#getInitializer <em>Initializer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InitImpl extends MinimalEObjectImpl.Container implements Init
{
  /**
   * The cached value of the '{@link #getDesignation() <em>Designation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDesignation()
   * @generated
   * @ordered
   */
  protected Designation designation;

  /**
   * The cached value of the '{@link #getInitializer() <em>Initializer</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitializer()
   * @generated
   * @ordered
   */
  protected Initializer initializer;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InitImpl()
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
    return ParserPackage.Literals.INIT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Designation getDesignation()
  {
    return designation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDesignation(Designation newDesignation, NotificationChain msgs)
  {
    Designation oldDesignation = designation;
    designation = newDesignation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.INIT__DESIGNATION, oldDesignation, newDesignation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDesignation(Designation newDesignation)
  {
    if (newDesignation != designation)
    {
      NotificationChain msgs = null;
      if (designation != null)
        msgs = ((InternalEObject)designation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.INIT__DESIGNATION, null, msgs);
      if (newDesignation != null)
        msgs = ((InternalEObject)newDesignation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.INIT__DESIGNATION, null, msgs);
      msgs = basicSetDesignation(newDesignation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.INIT__DESIGNATION, newDesignation, newDesignation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Initializer getInitializer()
  {
    return initializer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInitializer(Initializer newInitializer, NotificationChain msgs)
  {
    Initializer oldInitializer = initializer;
    initializer = newInitializer;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.INIT__INITIALIZER, oldInitializer, newInitializer);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInitializer(Initializer newInitializer)
  {
    if (newInitializer != initializer)
    {
      NotificationChain msgs = null;
      if (initializer != null)
        msgs = ((InternalEObject)initializer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.INIT__INITIALIZER, null, msgs);
      if (newInitializer != null)
        msgs = ((InternalEObject)newInitializer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.INIT__INITIALIZER, null, msgs);
      msgs = basicSetInitializer(newInitializer, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.INIT__INITIALIZER, newInitializer, newInitializer));
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
      case ParserPackage.INIT__DESIGNATION:
        return basicSetDesignation(null, msgs);
      case ParserPackage.INIT__INITIALIZER:
        return basicSetInitializer(null, msgs);
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
      case ParserPackage.INIT__DESIGNATION:
        return getDesignation();
      case ParserPackage.INIT__INITIALIZER:
        return getInitializer();
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
      case ParserPackage.INIT__DESIGNATION:
        setDesignation((Designation)newValue);
        return;
      case ParserPackage.INIT__INITIALIZER:
        setInitializer((Initializer)newValue);
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
      case ParserPackage.INIT__DESIGNATION:
        setDesignation((Designation)null);
        return;
      case ParserPackage.INIT__INITIALIZER:
        setInitializer((Initializer)null);
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
      case ParserPackage.INIT__DESIGNATION:
        return designation != null;
      case ParserPackage.INIT__INITIALIZER:
        return initializer != null;
    }
    return super.eIsSet(featureID);
  }

} //InitImpl
