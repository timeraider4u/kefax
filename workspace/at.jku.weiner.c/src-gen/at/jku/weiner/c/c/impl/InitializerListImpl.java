/**
 */
package at.jku.weiner.c.c.impl;

import at.jku.weiner.c.c.CPackage;
import at.jku.weiner.c.c.Initializer;
import at.jku.weiner.c.c.InitializerList;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Initializer List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.impl.InitializerListImpl#getInitializer <em>Initializer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InitializerListImpl extends MinimalEObjectImpl.Container implements InitializerList
{
  /**
   * The cached value of the '{@link #getInitializer() <em>Initializer</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitializer()
   * @generated
   * @ordered
   */
  protected EList<Initializer> initializer;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InitializerListImpl()
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
    return CPackage.Literals.INITIALIZER_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Initializer> getInitializer()
  {
    if (initializer == null)
    {
      initializer = new EObjectContainmentEList<Initializer>(Initializer.class, this, CPackage.INITIALIZER_LIST__INITIALIZER);
    }
    return initializer;
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
      case CPackage.INITIALIZER_LIST__INITIALIZER:
        return ((InternalEList<?>)getInitializer()).basicRemove(otherEnd, msgs);
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
      case CPackage.INITIALIZER_LIST__INITIALIZER:
        return getInitializer();
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
      case CPackage.INITIALIZER_LIST__INITIALIZER:
        getInitializer().clear();
        getInitializer().addAll((Collection<? extends Initializer>)newValue);
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
      case CPackage.INITIALIZER_LIST__INITIALIZER:
        getInitializer().clear();
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
      case CPackage.INITIALIZER_LIST__INITIALIZER:
        return initializer != null && !initializer.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //InitializerListImpl
