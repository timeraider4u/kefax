/**
 */
package at.jku.weiner.c.c.impl;

import at.jku.weiner.c.c.CPackage;
import at.jku.weiner.c.c.StructDeclarationList;
import at.jku.weiner.c.c.StructOrUnion;
import at.jku.weiner.c.c.StructOrUnionSpecifier;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Struct Or Union Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.impl.StructOrUnionSpecifierImpl#getType <em>Type</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.StructOrUnionSpecifierImpl#getStructDeclList <em>Struct Decl List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructOrUnionSpecifierImpl extends DeclarationSpecifierImpl implements StructOrUnionSpecifier
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected StructOrUnion type;

  /**
   * The cached value of the '{@link #getStructDeclList() <em>Struct Decl List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStructDeclList()
   * @generated
   * @ordered
   */
  protected StructDeclarationList structDeclList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StructOrUnionSpecifierImpl()
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
    return CPackage.Literals.STRUCT_OR_UNION_SPECIFIER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StructOrUnion getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(StructOrUnion newType, NotificationChain msgs)
  {
    StructOrUnion oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CPackage.STRUCT_OR_UNION_SPECIFIER__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(StructOrUnion newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CPackage.STRUCT_OR_UNION_SPECIFIER__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CPackage.STRUCT_OR_UNION_SPECIFIER__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.STRUCT_OR_UNION_SPECIFIER__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StructDeclarationList getStructDeclList()
  {
    return structDeclList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStructDeclList(StructDeclarationList newStructDeclList, NotificationChain msgs)
  {
    StructDeclarationList oldStructDeclList = structDeclList;
    structDeclList = newStructDeclList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CPackage.STRUCT_OR_UNION_SPECIFIER__STRUCT_DECL_LIST, oldStructDeclList, newStructDeclList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStructDeclList(StructDeclarationList newStructDeclList)
  {
    if (newStructDeclList != structDeclList)
    {
      NotificationChain msgs = null;
      if (structDeclList != null)
        msgs = ((InternalEObject)structDeclList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CPackage.STRUCT_OR_UNION_SPECIFIER__STRUCT_DECL_LIST, null, msgs);
      if (newStructDeclList != null)
        msgs = ((InternalEObject)newStructDeclList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CPackage.STRUCT_OR_UNION_SPECIFIER__STRUCT_DECL_LIST, null, msgs);
      msgs = basicSetStructDeclList(newStructDeclList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.STRUCT_OR_UNION_SPECIFIER__STRUCT_DECL_LIST, newStructDeclList, newStructDeclList));
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
      case CPackage.STRUCT_OR_UNION_SPECIFIER__TYPE:
        return basicSetType(null, msgs);
      case CPackage.STRUCT_OR_UNION_SPECIFIER__STRUCT_DECL_LIST:
        return basicSetStructDeclList(null, msgs);
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
      case CPackage.STRUCT_OR_UNION_SPECIFIER__TYPE:
        return getType();
      case CPackage.STRUCT_OR_UNION_SPECIFIER__STRUCT_DECL_LIST:
        return getStructDeclList();
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
      case CPackage.STRUCT_OR_UNION_SPECIFIER__TYPE:
        setType((StructOrUnion)newValue);
        return;
      case CPackage.STRUCT_OR_UNION_SPECIFIER__STRUCT_DECL_LIST:
        setStructDeclList((StructDeclarationList)newValue);
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
      case CPackage.STRUCT_OR_UNION_SPECIFIER__TYPE:
        setType((StructOrUnion)null);
        return;
      case CPackage.STRUCT_OR_UNION_SPECIFIER__STRUCT_DECL_LIST:
        setStructDeclList((StructDeclarationList)null);
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
      case CPackage.STRUCT_OR_UNION_SPECIFIER__TYPE:
        return type != null;
      case CPackage.STRUCT_OR_UNION_SPECIFIER__STRUCT_DECL_LIST:
        return structDeclList != null;
    }
    return super.eIsSet(featureID);
  }

} //StructOrUnionSpecifierImpl
