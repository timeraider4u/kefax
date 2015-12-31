/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.DeclarationSpecifier;
import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.StructOrUnionName;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypedefName;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#getName <em>Name</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#getSpecifier <em>Specifier</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#getType <em>Type</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl#getStruct <em>Struct</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeSpecifierImpl extends MinimalEObjectImpl.Container implements TypeSpecifier
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
   * The cached value of the '{@link #getSpecifier() <em>Specifier</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpecifier()
   * @generated
   * @ordered
   */
  protected DeclarationSpecifier specifier;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected TypedefName type;

  /**
   * The cached value of the '{@link #getStruct() <em>Struct</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStruct()
   * @generated
   * @ordered
   */
  protected StructOrUnionName struct;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeSpecifierImpl()
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
    return ParserPackage.Literals.TYPE_SPECIFIER;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_SPECIFIER__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeclarationSpecifier getSpecifier()
  {
    return specifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSpecifier(DeclarationSpecifier newSpecifier, NotificationChain msgs)
  {
    DeclarationSpecifier oldSpecifier = specifier;
    specifier = newSpecifier;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_SPECIFIER__SPECIFIER, oldSpecifier, newSpecifier);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSpecifier(DeclarationSpecifier newSpecifier)
  {
    if (newSpecifier != specifier)
    {
      NotificationChain msgs = null;
      if (specifier != null)
        msgs = ((InternalEObject)specifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.TYPE_SPECIFIER__SPECIFIER, null, msgs);
      if (newSpecifier != null)
        msgs = ((InternalEObject)newSpecifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.TYPE_SPECIFIER__SPECIFIER, null, msgs);
      msgs = basicSetSpecifier(newSpecifier, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_SPECIFIER__SPECIFIER, newSpecifier, newSpecifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypedefName getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(TypedefName newType, NotificationChain msgs)
  {
    TypedefName oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_SPECIFIER__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(TypedefName newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.TYPE_SPECIFIER__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.TYPE_SPECIFIER__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_SPECIFIER__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StructOrUnionName getStruct()
  {
    return struct;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStruct(StructOrUnionName newStruct, NotificationChain msgs)
  {
    StructOrUnionName oldStruct = struct;
    struct = newStruct;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_SPECIFIER__STRUCT, oldStruct, newStruct);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStruct(StructOrUnionName newStruct)
  {
    if (newStruct != struct)
    {
      NotificationChain msgs = null;
      if (struct != null)
        msgs = ((InternalEObject)struct).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.TYPE_SPECIFIER__STRUCT, null, msgs);
      if (newStruct != null)
        msgs = ((InternalEObject)newStruct).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.TYPE_SPECIFIER__STRUCT, null, msgs);
      msgs = basicSetStruct(newStruct, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_SPECIFIER__STRUCT, newStruct, newStruct));
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
      case ParserPackage.TYPE_SPECIFIER__SPECIFIER:
        return basicSetSpecifier(null, msgs);
      case ParserPackage.TYPE_SPECIFIER__TYPE:
        return basicSetType(null, msgs);
      case ParserPackage.TYPE_SPECIFIER__STRUCT:
        return basicSetStruct(null, msgs);
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
      case ParserPackage.TYPE_SPECIFIER__NAME:
        return getName();
      case ParserPackage.TYPE_SPECIFIER__SPECIFIER:
        return getSpecifier();
      case ParserPackage.TYPE_SPECIFIER__TYPE:
        return getType();
      case ParserPackage.TYPE_SPECIFIER__STRUCT:
        return getStruct();
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
      case ParserPackage.TYPE_SPECIFIER__NAME:
        setName((String)newValue);
        return;
      case ParserPackage.TYPE_SPECIFIER__SPECIFIER:
        setSpecifier((DeclarationSpecifier)newValue);
        return;
      case ParserPackage.TYPE_SPECIFIER__TYPE:
        setType((TypedefName)newValue);
        return;
      case ParserPackage.TYPE_SPECIFIER__STRUCT:
        setStruct((StructOrUnionName)newValue);
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
      case ParserPackage.TYPE_SPECIFIER__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ParserPackage.TYPE_SPECIFIER__SPECIFIER:
        setSpecifier((DeclarationSpecifier)null);
        return;
      case ParserPackage.TYPE_SPECIFIER__TYPE:
        setType((TypedefName)null);
        return;
      case ParserPackage.TYPE_SPECIFIER__STRUCT:
        setStruct((StructOrUnionName)null);
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
      case ParserPackage.TYPE_SPECIFIER__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ParserPackage.TYPE_SPECIFIER__SPECIFIER:
        return specifier != null;
      case ParserPackage.TYPE_SPECIFIER__TYPE:
        return type != null;
      case ParserPackage.TYPE_SPECIFIER__STRUCT:
        return struct != null;
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

} //TypeSpecifierImpl
