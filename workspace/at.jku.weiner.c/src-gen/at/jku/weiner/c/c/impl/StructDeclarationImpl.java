/**
 */
package at.jku.weiner.c.c.impl;

import at.jku.weiner.c.c.CPackage;
import at.jku.weiner.c.c.SpecifierQualifierList;
import at.jku.weiner.c.c.StructDeclaration;
import at.jku.weiner.c.c.StructDeclaratorList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Struct Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.impl.StructDeclarationImpl#getList <em>List</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.StructDeclarationImpl#getStructDeclarationList <em>Struct Declaration List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructDeclarationImpl extends MinimalEObjectImpl.Container implements StructDeclaration
{
  /**
   * The cached value of the '{@link #getList() <em>List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getList()
   * @generated
   * @ordered
   */
  protected SpecifierQualifierList list;

  /**
   * The cached value of the '{@link #getStructDeclarationList() <em>Struct Declaration List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStructDeclarationList()
   * @generated
   * @ordered
   */
  protected StructDeclaratorList structDeclarationList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StructDeclarationImpl()
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
    return CPackage.Literals.STRUCT_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpecifierQualifierList getList()
  {
    return list;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetList(SpecifierQualifierList newList, NotificationChain msgs)
  {
    SpecifierQualifierList oldList = list;
    list = newList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CPackage.STRUCT_DECLARATION__LIST, oldList, newList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setList(SpecifierQualifierList newList)
  {
    if (newList != list)
    {
      NotificationChain msgs = null;
      if (list != null)
        msgs = ((InternalEObject)list).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CPackage.STRUCT_DECLARATION__LIST, null, msgs);
      if (newList != null)
        msgs = ((InternalEObject)newList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CPackage.STRUCT_DECLARATION__LIST, null, msgs);
      msgs = basicSetList(newList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.STRUCT_DECLARATION__LIST, newList, newList));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StructDeclaratorList getStructDeclarationList()
  {
    return structDeclarationList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStructDeclarationList(StructDeclaratorList newStructDeclarationList, NotificationChain msgs)
  {
    StructDeclaratorList oldStructDeclarationList = structDeclarationList;
    structDeclarationList = newStructDeclarationList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CPackage.STRUCT_DECLARATION__STRUCT_DECLARATION_LIST, oldStructDeclarationList, newStructDeclarationList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStructDeclarationList(StructDeclaratorList newStructDeclarationList)
  {
    if (newStructDeclarationList != structDeclarationList)
    {
      NotificationChain msgs = null;
      if (structDeclarationList != null)
        msgs = ((InternalEObject)structDeclarationList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CPackage.STRUCT_DECLARATION__STRUCT_DECLARATION_LIST, null, msgs);
      if (newStructDeclarationList != null)
        msgs = ((InternalEObject)newStructDeclarationList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CPackage.STRUCT_DECLARATION__STRUCT_DECLARATION_LIST, null, msgs);
      msgs = basicSetStructDeclarationList(newStructDeclarationList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.STRUCT_DECLARATION__STRUCT_DECLARATION_LIST, newStructDeclarationList, newStructDeclarationList));
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
      case CPackage.STRUCT_DECLARATION__LIST:
        return basicSetList(null, msgs);
      case CPackage.STRUCT_DECLARATION__STRUCT_DECLARATION_LIST:
        return basicSetStructDeclarationList(null, msgs);
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
      case CPackage.STRUCT_DECLARATION__LIST:
        return getList();
      case CPackage.STRUCT_DECLARATION__STRUCT_DECLARATION_LIST:
        return getStructDeclarationList();
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
      case CPackage.STRUCT_DECLARATION__LIST:
        setList((SpecifierQualifierList)newValue);
        return;
      case CPackage.STRUCT_DECLARATION__STRUCT_DECLARATION_LIST:
        setStructDeclarationList((StructDeclaratorList)newValue);
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
      case CPackage.STRUCT_DECLARATION__LIST:
        setList((SpecifierQualifierList)null);
        return;
      case CPackage.STRUCT_DECLARATION__STRUCT_DECLARATION_LIST:
        setStructDeclarationList((StructDeclaratorList)null);
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
      case CPackage.STRUCT_DECLARATION__LIST:
        return list != null;
      case CPackage.STRUCT_DECLARATION__STRUCT_DECLARATION_LIST:
        return structDeclarationList != null;
    }
    return super.eIsSet(featureID);
  }

} //StructDeclarationImpl
