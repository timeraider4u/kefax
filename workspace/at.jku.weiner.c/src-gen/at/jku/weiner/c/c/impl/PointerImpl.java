/**
 */
package at.jku.weiner.c.c.impl;

import at.jku.weiner.c.c.CPackage;
import at.jku.weiner.c.c.Pointer;
import at.jku.weiner.c.c.TypeQualifierList;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pointer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.impl.PointerImpl#getStar <em>Star</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.PointerImpl#getCaret <em>Caret</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.PointerImpl#getTypeQualifierList <em>Type Qualifier List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PointerImpl extends MinimalEObjectImpl.Container implements Pointer
{
  /**
   * The cached value of the '{@link #getStar() <em>Star</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStar()
   * @generated
   * @ordered
   */
  protected EList<String> star;

  /**
   * The cached value of the '{@link #getCaret() <em>Caret</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCaret()
   * @generated
   * @ordered
   */
  protected EList<String> caret;

  /**
   * The cached value of the '{@link #getTypeQualifierList() <em>Type Qualifier List</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeQualifierList()
   * @generated
   * @ordered
   */
  protected EList<TypeQualifierList> typeQualifierList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PointerImpl()
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
    return CPackage.Literals.POINTER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getStar()
  {
    if (star == null)
    {
      star = new EDataTypeEList<String>(String.class, this, CPackage.POINTER__STAR);
    }
    return star;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getCaret()
  {
    if (caret == null)
    {
      caret = new EDataTypeEList<String>(String.class, this, CPackage.POINTER__CARET);
    }
    return caret;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TypeQualifierList> getTypeQualifierList()
  {
    if (typeQualifierList == null)
    {
      typeQualifierList = new EObjectContainmentEList<TypeQualifierList>(TypeQualifierList.class, this, CPackage.POINTER__TYPE_QUALIFIER_LIST);
    }
    return typeQualifierList;
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
      case CPackage.POINTER__TYPE_QUALIFIER_LIST:
        return ((InternalEList<?>)getTypeQualifierList()).basicRemove(otherEnd, msgs);
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
      case CPackage.POINTER__STAR:
        return getStar();
      case CPackage.POINTER__CARET:
        return getCaret();
      case CPackage.POINTER__TYPE_QUALIFIER_LIST:
        return getTypeQualifierList();
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
      case CPackage.POINTER__STAR:
        getStar().clear();
        getStar().addAll((Collection<? extends String>)newValue);
        return;
      case CPackage.POINTER__CARET:
        getCaret().clear();
        getCaret().addAll((Collection<? extends String>)newValue);
        return;
      case CPackage.POINTER__TYPE_QUALIFIER_LIST:
        getTypeQualifierList().clear();
        getTypeQualifierList().addAll((Collection<? extends TypeQualifierList>)newValue);
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
      case CPackage.POINTER__STAR:
        getStar().clear();
        return;
      case CPackage.POINTER__CARET:
        getCaret().clear();
        return;
      case CPackage.POINTER__TYPE_QUALIFIER_LIST:
        getTypeQualifierList().clear();
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
      case CPackage.POINTER__STAR:
        return star != null && !star.isEmpty();
      case CPackage.POINTER__CARET:
        return caret != null && !caret.isEmpty();
      case CPackage.POINTER__TYPE_QUALIFIER_LIST:
        return typeQualifierList != null && !typeQualifierList.isEmpty();
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
    result.append(" (star: ");
    result.append(star);
    result.append(", caret: ");
    result.append(caret);
    result.append(')');
    return result.toString();
  }

} //PointerImpl
