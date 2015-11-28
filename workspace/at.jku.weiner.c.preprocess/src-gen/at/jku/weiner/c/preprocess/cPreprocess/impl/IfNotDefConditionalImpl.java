/**
 */
package at.jku.weiner.c.preprocess.cPreprocess.impl;

import at.jku.weiner.c.preprocess.cPreprocess.CPreprocessPackage;
import at.jku.weiner.c.preprocess.cPreprocess.GroupOpt;
import at.jku.weiner.c.preprocess.cPreprocess.IfNotDefConditional;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Not Def Conditional</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.cPreprocess.impl.IfNotDefConditionalImpl#getId <em>Id</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.cPreprocess.impl.IfNotDefConditionalImpl#getGroup <em>Group</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfNotDefConditionalImpl extends MinimalEObjectImpl.Container implements IfNotDefConditional
{
  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The cached value of the '{@link #getGroup() <em>Group</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroup()
   * @generated
   * @ordered
   */
  protected GroupOpt group;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IfNotDefConditionalImpl()
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
    return CPreprocessPackage.Literals.IF_NOT_DEF_CONDITIONAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(String newId)
  {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPreprocessPackage.IF_NOT_DEF_CONDITIONAL__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GroupOpt getGroup()
  {
    return group;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGroup(GroupOpt newGroup, NotificationChain msgs)
  {
    GroupOpt oldGroup = group;
    group = newGroup;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CPreprocessPackage.IF_NOT_DEF_CONDITIONAL__GROUP, oldGroup, newGroup);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGroup(GroupOpt newGroup)
  {
    if (newGroup != group)
    {
      NotificationChain msgs = null;
      if (group != null)
        msgs = ((InternalEObject)group).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CPreprocessPackage.IF_NOT_DEF_CONDITIONAL__GROUP, null, msgs);
      if (newGroup != null)
        msgs = ((InternalEObject)newGroup).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CPreprocessPackage.IF_NOT_DEF_CONDITIONAL__GROUP, null, msgs);
      msgs = basicSetGroup(newGroup, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPreprocessPackage.IF_NOT_DEF_CONDITIONAL__GROUP, newGroup, newGroup));
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
      case CPreprocessPackage.IF_NOT_DEF_CONDITIONAL__GROUP:
        return basicSetGroup(null, msgs);
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
      case CPreprocessPackage.IF_NOT_DEF_CONDITIONAL__ID:
        return getId();
      case CPreprocessPackage.IF_NOT_DEF_CONDITIONAL__GROUP:
        return getGroup();
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
      case CPreprocessPackage.IF_NOT_DEF_CONDITIONAL__ID:
        setId((String)newValue);
        return;
      case CPreprocessPackage.IF_NOT_DEF_CONDITIONAL__GROUP:
        setGroup((GroupOpt)newValue);
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
      case CPreprocessPackage.IF_NOT_DEF_CONDITIONAL__ID:
        setId(ID_EDEFAULT);
        return;
      case CPreprocessPackage.IF_NOT_DEF_CONDITIONAL__GROUP:
        setGroup((GroupOpt)null);
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
      case CPreprocessPackage.IF_NOT_DEF_CONDITIONAL__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case CPreprocessPackage.IF_NOT_DEF_CONDITIONAL__GROUP:
        return group != null;
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
    result.append(" (id: ");
    result.append(id);
    result.append(')');
    return result.toString();
  }

} //IfNotDefConditionalImpl
