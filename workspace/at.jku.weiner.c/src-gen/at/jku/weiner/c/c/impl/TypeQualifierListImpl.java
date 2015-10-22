/**
 */
package at.jku.weiner.c.c.impl;

import at.jku.weiner.c.c.CPackage;
import at.jku.weiner.c.c.TypeQualifier;
import at.jku.weiner.c.c.TypeQualifierList;

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
 * An implementation of the model object '<em><b>Type Qualifier List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.impl.TypeQualifierListImpl#getTypeQualifier <em>Type Qualifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeQualifierListImpl extends MinimalEObjectImpl.Container implements TypeQualifierList
{
  /**
   * The cached value of the '{@link #getTypeQualifier() <em>Type Qualifier</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeQualifier()
   * @generated
   * @ordered
   */
  protected EList<TypeQualifier> typeQualifier;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeQualifierListImpl()
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
    return CPackage.Literals.TYPE_QUALIFIER_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TypeQualifier> getTypeQualifier()
  {
    if (typeQualifier == null)
    {
      typeQualifier = new EObjectContainmentEList<TypeQualifier>(TypeQualifier.class, this, CPackage.TYPE_QUALIFIER_LIST__TYPE_QUALIFIER);
    }
    return typeQualifier;
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
      case CPackage.TYPE_QUALIFIER_LIST__TYPE_QUALIFIER:
        return ((InternalEList<?>)getTypeQualifier()).basicRemove(otherEnd, msgs);
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
      case CPackage.TYPE_QUALIFIER_LIST__TYPE_QUALIFIER:
        return getTypeQualifier();
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
      case CPackage.TYPE_QUALIFIER_LIST__TYPE_QUALIFIER:
        getTypeQualifier().clear();
        getTypeQualifier().addAll((Collection<? extends TypeQualifier>)newValue);
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
      case CPackage.TYPE_QUALIFIER_LIST__TYPE_QUALIFIER:
        getTypeQualifier().clear();
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
      case CPackage.TYPE_QUALIFIER_LIST__TYPE_QUALIFIER:
        return typeQualifier != null && !typeQualifier.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //TypeQualifierListImpl
