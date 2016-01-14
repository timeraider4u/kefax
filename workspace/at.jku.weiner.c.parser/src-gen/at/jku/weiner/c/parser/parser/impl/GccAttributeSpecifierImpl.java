/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.GccAttributeList;
import at.jku.weiner.c.parser.parser.GccAttributeSpecifier;
import at.jku.weiner.c.parser.parser.ParserPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gcc Attribute Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.GccAttributeSpecifierImpl#getList <em>List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GccAttributeSpecifierImpl extends MinimalEObjectImpl.Container implements GccAttributeSpecifier
{
  /**
   * The cached value of the '{@link #getList() <em>List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getList()
   * @generated
   * @ordered
   */
  protected GccAttributeList list;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GccAttributeSpecifierImpl()
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
    return ParserPackage.Literals.GCC_ATTRIBUTE_SPECIFIER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GccAttributeList getList()
  {
    return list;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetList(GccAttributeList newList, NotificationChain msgs)
  {
    GccAttributeList oldList = list;
    list = newList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.GCC_ATTRIBUTE_SPECIFIER__LIST, oldList, newList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setList(GccAttributeList newList)
  {
    if (newList != list)
    {
      NotificationChain msgs = null;
      if (list != null)
        msgs = ((InternalEObject)list).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.GCC_ATTRIBUTE_SPECIFIER__LIST, null, msgs);
      if (newList != null)
        msgs = ((InternalEObject)newList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.GCC_ATTRIBUTE_SPECIFIER__LIST, null, msgs);
      msgs = basicSetList(newList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.GCC_ATTRIBUTE_SPECIFIER__LIST, newList, newList));
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
      case ParserPackage.GCC_ATTRIBUTE_SPECIFIER__LIST:
        return basicSetList(null, msgs);
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
      case ParserPackage.GCC_ATTRIBUTE_SPECIFIER__LIST:
        return getList();
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
      case ParserPackage.GCC_ATTRIBUTE_SPECIFIER__LIST:
        setList((GccAttributeList)newValue);
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
      case ParserPackage.GCC_ATTRIBUTE_SPECIFIER__LIST:
        setList((GccAttributeList)null);
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
      case ParserPackage.GCC_ATTRIBUTE_SPECIFIER__LIST:
        return list != null;
    }
    return super.eIsSet(featureID);
  }

} //GccAttributeSpecifierImpl
