/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.EnumSpecifier;
import at.jku.weiner.c.parser.parser.EnumeratorList;
import at.jku.weiner.c.parser.parser.ParserPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.EnumSpecifierImpl#getEnumList <em>Enum List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumSpecifierImpl extends DeclarationSpecifierImpl implements EnumSpecifier
{
  /**
   * The cached value of the '{@link #getEnumList() <em>Enum List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumList()
   * @generated
   * @ordered
   */
  protected EnumeratorList enumList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnumSpecifierImpl()
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
    return ParserPackage.Literals.ENUM_SPECIFIER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumeratorList getEnumList()
  {
    return enumList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEnumList(EnumeratorList newEnumList, NotificationChain msgs)
  {
    EnumeratorList oldEnumList = enumList;
    enumList = newEnumList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.ENUM_SPECIFIER__ENUM_LIST, oldEnumList, newEnumList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnumList(EnumeratorList newEnumList)
  {
    if (newEnumList != enumList)
    {
      NotificationChain msgs = null;
      if (enumList != null)
        msgs = ((InternalEObject)enumList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ENUM_SPECIFIER__ENUM_LIST, null, msgs);
      if (newEnumList != null)
        msgs = ((InternalEObject)newEnumList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ENUM_SPECIFIER__ENUM_LIST, null, msgs);
      msgs = basicSetEnumList(newEnumList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ENUM_SPECIFIER__ENUM_LIST, newEnumList, newEnumList));
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
      case ParserPackage.ENUM_SPECIFIER__ENUM_LIST:
        return basicSetEnumList(null, msgs);
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
      case ParserPackage.ENUM_SPECIFIER__ENUM_LIST:
        return getEnumList();
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
      case ParserPackage.ENUM_SPECIFIER__ENUM_LIST:
        setEnumList((EnumeratorList)newValue);
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
      case ParserPackage.ENUM_SPECIFIER__ENUM_LIST:
        setEnumList((EnumeratorList)null);
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
      case ParserPackage.ENUM_SPECIFIER__ENUM_LIST:
        return enumList != null;
    }
    return super.eIsSet(featureID);
  }

} //EnumSpecifierImpl
