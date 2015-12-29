/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.GccAttribute;
import at.jku.weiner.c.parser.parser.GccAttributeList;
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
 * An implementation of the model object '<em><b>Gcc Attribute List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.GccAttributeListImpl#getGccAttribute <em>Gcc Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GccAttributeListImpl extends MinimalEObjectImpl.Container implements GccAttributeList
{
  /**
   * The cached value of the '{@link #getGccAttribute() <em>Gcc Attribute</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGccAttribute()
   * @generated
   * @ordered
   */
  protected EList<GccAttribute> gccAttribute;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GccAttributeListImpl()
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
    return ParserPackage.Literals.GCC_ATTRIBUTE_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GccAttribute> getGccAttribute()
  {
    if (gccAttribute == null)
    {
      gccAttribute = new EObjectContainmentEList<GccAttribute>(GccAttribute.class, this, ParserPackage.GCC_ATTRIBUTE_LIST__GCC_ATTRIBUTE);
    }
    return gccAttribute;
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
      case ParserPackage.GCC_ATTRIBUTE_LIST__GCC_ATTRIBUTE:
        return ((InternalEList<?>)getGccAttribute()).basicRemove(otherEnd, msgs);
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
      case ParserPackage.GCC_ATTRIBUTE_LIST__GCC_ATTRIBUTE:
        return getGccAttribute();
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
      case ParserPackage.GCC_ATTRIBUTE_LIST__GCC_ATTRIBUTE:
        getGccAttribute().clear();
        getGccAttribute().addAll((Collection<? extends GccAttribute>)newValue);
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
      case ParserPackage.GCC_ATTRIBUTE_LIST__GCC_ATTRIBUTE:
        getGccAttribute().clear();
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
      case ParserPackage.GCC_ATTRIBUTE_LIST__GCC_ATTRIBUTE:
        return gccAttribute != null && !gccAttribute.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //GccAttributeListImpl
