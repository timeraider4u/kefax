/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.Designation;
import at.jku.weiner.c.parser.parser.Initializer;
import at.jku.weiner.c.parser.parser.InitializerList;
import at.jku.weiner.c.parser.parser.ParserPackage;

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
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.InitializerListImpl#getDesignation <em>Designation</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.InitializerListImpl#getInitializer <em>Initializer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InitializerListImpl extends MinimalEObjectImpl.Container implements InitializerList
{
  /**
   * The cached value of the '{@link #getDesignation() <em>Designation</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDesignation()
   * @generated
   * @ordered
   */
  protected EList<Designation> designation;

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
    return ParserPackage.Literals.INITIALIZER_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Designation> getDesignation()
  {
    if (designation == null)
    {
      designation = new EObjectContainmentEList<Designation>(Designation.class, this, ParserPackage.INITIALIZER_LIST__DESIGNATION);
    }
    return designation;
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
      initializer = new EObjectContainmentEList<Initializer>(Initializer.class, this, ParserPackage.INITIALIZER_LIST__INITIALIZER);
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
      case ParserPackage.INITIALIZER_LIST__DESIGNATION:
        return ((InternalEList<?>)getDesignation()).basicRemove(otherEnd, msgs);
      case ParserPackage.INITIALIZER_LIST__INITIALIZER:
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
      case ParserPackage.INITIALIZER_LIST__DESIGNATION:
        return getDesignation();
      case ParserPackage.INITIALIZER_LIST__INITIALIZER:
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
      case ParserPackage.INITIALIZER_LIST__DESIGNATION:
        getDesignation().clear();
        getDesignation().addAll((Collection<? extends Designation>)newValue);
        return;
      case ParserPackage.INITIALIZER_LIST__INITIALIZER:
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
      case ParserPackage.INITIALIZER_LIST__DESIGNATION:
        getDesignation().clear();
        return;
      case ParserPackage.INITIALIZER_LIST__INITIALIZER:
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
      case ParserPackage.INITIALIZER_LIST__DESIGNATION:
        return designation != null && !designation.isEmpty();
      case ParserPackage.INITIALIZER_LIST__INITIALIZER:
        return initializer != null && !initializer.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //InitializerListImpl
