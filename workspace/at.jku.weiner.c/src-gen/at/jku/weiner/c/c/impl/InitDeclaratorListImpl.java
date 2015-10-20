/**
 */
package at.jku.weiner.c.c.impl;

import at.jku.weiner.c.c.CPackage;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.InitDeclaratorList;

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
 * An implementation of the model object '<em><b>Init Declarator List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.impl.InitDeclaratorListImpl#getInitDeclarator <em>Init Declarator</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.InitDeclaratorListImpl#getInitDeclarator2 <em>Init Declarator2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InitDeclaratorListImpl extends MinimalEObjectImpl.Container implements InitDeclaratorList
{
  /**
   * The cached value of the '{@link #getInitDeclarator() <em>Init Declarator</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitDeclarator()
   * @generated
   * @ordered
   */
  protected EList<InitDeclarator> initDeclarator;

  /**
   * The cached value of the '{@link #getInitDeclarator2() <em>Init Declarator2</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitDeclarator2()
   * @generated
   * @ordered
   */
  protected EList<InitDeclarator> initDeclarator2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InitDeclaratorListImpl()
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
    return CPackage.Literals.INIT_DECLARATOR_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<InitDeclarator> getInitDeclarator()
  {
    if (initDeclarator == null)
    {
      initDeclarator = new EObjectContainmentEList<InitDeclarator>(InitDeclarator.class, this, CPackage.INIT_DECLARATOR_LIST__INIT_DECLARATOR);
    }
    return initDeclarator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<InitDeclarator> getInitDeclarator2()
  {
    if (initDeclarator2 == null)
    {
      initDeclarator2 = new EObjectContainmentEList<InitDeclarator>(InitDeclarator.class, this, CPackage.INIT_DECLARATOR_LIST__INIT_DECLARATOR2);
    }
    return initDeclarator2;
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
      case CPackage.INIT_DECLARATOR_LIST__INIT_DECLARATOR:
        return ((InternalEList<?>)getInitDeclarator()).basicRemove(otherEnd, msgs);
      case CPackage.INIT_DECLARATOR_LIST__INIT_DECLARATOR2:
        return ((InternalEList<?>)getInitDeclarator2()).basicRemove(otherEnd, msgs);
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
      case CPackage.INIT_DECLARATOR_LIST__INIT_DECLARATOR:
        return getInitDeclarator();
      case CPackage.INIT_DECLARATOR_LIST__INIT_DECLARATOR2:
        return getInitDeclarator2();
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
      case CPackage.INIT_DECLARATOR_LIST__INIT_DECLARATOR:
        getInitDeclarator().clear();
        getInitDeclarator().addAll((Collection<? extends InitDeclarator>)newValue);
        return;
      case CPackage.INIT_DECLARATOR_LIST__INIT_DECLARATOR2:
        getInitDeclarator2().clear();
        getInitDeclarator2().addAll((Collection<? extends InitDeclarator>)newValue);
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
      case CPackage.INIT_DECLARATOR_LIST__INIT_DECLARATOR:
        getInitDeclarator().clear();
        return;
      case CPackage.INIT_DECLARATOR_LIST__INIT_DECLARATOR2:
        getInitDeclarator2().clear();
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
      case CPackage.INIT_DECLARATOR_LIST__INIT_DECLARATOR:
        return initDeclarator != null && !initDeclarator.isEmpty();
      case CPackage.INIT_DECLARATOR_LIST__INIT_DECLARATOR2:
        return initDeclarator2 != null && !initDeclarator2.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //InitDeclaratorListImpl
