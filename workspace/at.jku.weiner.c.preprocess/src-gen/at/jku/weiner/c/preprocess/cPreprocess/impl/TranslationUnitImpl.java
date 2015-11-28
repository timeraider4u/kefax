/**
 */
package at.jku.weiner.c.preprocess.cPreprocess.impl;

import at.jku.weiner.c.preprocess.cPreprocess.CPreprocessPackage;
import at.jku.weiner.c.preprocess.cPreprocess.GroupOpt;
import at.jku.weiner.c.preprocess.cPreprocess.TranslationUnit;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Translation Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.cPreprocess.impl.TranslationUnitImpl#getGroup <em>Group</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TranslationUnitImpl extends MinimalEObjectImpl.Container implements TranslationUnit
{
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
  protected TranslationUnitImpl()
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
    return CPreprocessPackage.Literals.TRANSLATION_UNIT;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CPreprocessPackage.TRANSLATION_UNIT__GROUP, oldGroup, newGroup);
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
        msgs = ((InternalEObject)group).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CPreprocessPackage.TRANSLATION_UNIT__GROUP, null, msgs);
      if (newGroup != null)
        msgs = ((InternalEObject)newGroup).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CPreprocessPackage.TRANSLATION_UNIT__GROUP, null, msgs);
      msgs = basicSetGroup(newGroup, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPreprocessPackage.TRANSLATION_UNIT__GROUP, newGroup, newGroup));
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
      case CPreprocessPackage.TRANSLATION_UNIT__GROUP:
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
      case CPreprocessPackage.TRANSLATION_UNIT__GROUP:
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
      case CPreprocessPackage.TRANSLATION_UNIT__GROUP:
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
      case CPreprocessPackage.TRANSLATION_UNIT__GROUP:
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
      case CPreprocessPackage.TRANSLATION_UNIT__GROUP:
        return group != null;
    }
    return super.eIsSet(featureID);
  }

} //TranslationUnitImpl
