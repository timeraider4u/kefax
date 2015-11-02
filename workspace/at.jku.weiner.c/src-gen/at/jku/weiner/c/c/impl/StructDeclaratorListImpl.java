/**
 */
package at.jku.weiner.c.c.impl;

import at.jku.weiner.c.c.CPackage;
import at.jku.weiner.c.c.StructDeclarator;
import at.jku.weiner.c.c.StructDeclaratorList;

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
 * An implementation of the model object '<em><b>Struct Declarator List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.impl.StructDeclaratorListImpl#getStructDeclarator <em>Struct Declarator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructDeclaratorListImpl extends MinimalEObjectImpl.Container implements StructDeclaratorList
{
  /**
   * The cached value of the '{@link #getStructDeclarator() <em>Struct Declarator</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStructDeclarator()
   * @generated
   * @ordered
   */
  protected EList<StructDeclarator> structDeclarator;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StructDeclaratorListImpl()
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
    return CPackage.Literals.STRUCT_DECLARATOR_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StructDeclarator> getStructDeclarator()
  {
    if (structDeclarator == null)
    {
      structDeclarator = new EObjectContainmentEList<StructDeclarator>(StructDeclarator.class, this, CPackage.STRUCT_DECLARATOR_LIST__STRUCT_DECLARATOR);
    }
    return structDeclarator;
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
      case CPackage.STRUCT_DECLARATOR_LIST__STRUCT_DECLARATOR:
        return ((InternalEList<?>)getStructDeclarator()).basicRemove(otherEnd, msgs);
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
      case CPackage.STRUCT_DECLARATOR_LIST__STRUCT_DECLARATOR:
        return getStructDeclarator();
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
      case CPackage.STRUCT_DECLARATOR_LIST__STRUCT_DECLARATOR:
        getStructDeclarator().clear();
        getStructDeclarator().addAll((Collection<? extends StructDeclarator>)newValue);
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
      case CPackage.STRUCT_DECLARATOR_LIST__STRUCT_DECLARATOR:
        getStructDeclarator().clear();
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
      case CPackage.STRUCT_DECLARATOR_LIST__STRUCT_DECLARATOR:
        return structDeclarator != null && !structDeclarator.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //StructDeclaratorListImpl
