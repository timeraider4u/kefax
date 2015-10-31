/**
 */
package at.jku.weiner.c.c.impl;

import at.jku.weiner.c.c.CPackage;
import at.jku.weiner.c.c.DeclarationSpecifier;
import at.jku.weiner.c.c.SpecifierQualifierList;
import at.jku.weiner.c.c.TypeQualifier;
import at.jku.weiner.c.c.TypeSpecifier;

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
 * An implementation of the model object '<em><b>Specifier Qualifier List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.impl.SpecifierQualifierListImpl#getTypeSpecifier <em>Type Specifier</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.SpecifierQualifierListImpl#getTypeQualifier <em>Type Qualifier</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.SpecifierQualifierListImpl#getStructOrUnionSpecifier <em>Struct Or Union Specifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpecifierQualifierListImpl extends MinimalEObjectImpl.Container implements SpecifierQualifierList
{
  /**
   * The cached value of the '{@link #getTypeSpecifier() <em>Type Specifier</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeSpecifier()
   * @generated
   * @ordered
   */
  protected EList<TypeSpecifier> typeSpecifier;

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
   * The cached value of the '{@link #getStructOrUnionSpecifier() <em>Struct Or Union Specifier</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStructOrUnionSpecifier()
   * @generated
   * @ordered
   */
  protected EList<DeclarationSpecifier> structOrUnionSpecifier;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SpecifierQualifierListImpl()
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
    return CPackage.Literals.SPECIFIER_QUALIFIER_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TypeSpecifier> getTypeSpecifier()
  {
    if (typeSpecifier == null)
    {
      typeSpecifier = new EObjectContainmentEList<TypeSpecifier>(TypeSpecifier.class, this, CPackage.SPECIFIER_QUALIFIER_LIST__TYPE_SPECIFIER);
    }
    return typeSpecifier;
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
      typeQualifier = new EObjectContainmentEList<TypeQualifier>(TypeQualifier.class, this, CPackage.SPECIFIER_QUALIFIER_LIST__TYPE_QUALIFIER);
    }
    return typeQualifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<DeclarationSpecifier> getStructOrUnionSpecifier()
  {
    if (structOrUnionSpecifier == null)
    {
      structOrUnionSpecifier = new EObjectContainmentEList<DeclarationSpecifier>(DeclarationSpecifier.class, this, CPackage.SPECIFIER_QUALIFIER_LIST__STRUCT_OR_UNION_SPECIFIER);
    }
    return structOrUnionSpecifier;
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
      case CPackage.SPECIFIER_QUALIFIER_LIST__TYPE_SPECIFIER:
        return ((InternalEList<?>)getTypeSpecifier()).basicRemove(otherEnd, msgs);
      case CPackage.SPECIFIER_QUALIFIER_LIST__TYPE_QUALIFIER:
        return ((InternalEList<?>)getTypeQualifier()).basicRemove(otherEnd, msgs);
      case CPackage.SPECIFIER_QUALIFIER_LIST__STRUCT_OR_UNION_SPECIFIER:
        return ((InternalEList<?>)getStructOrUnionSpecifier()).basicRemove(otherEnd, msgs);
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
      case CPackage.SPECIFIER_QUALIFIER_LIST__TYPE_SPECIFIER:
        return getTypeSpecifier();
      case CPackage.SPECIFIER_QUALIFIER_LIST__TYPE_QUALIFIER:
        return getTypeQualifier();
      case CPackage.SPECIFIER_QUALIFIER_LIST__STRUCT_OR_UNION_SPECIFIER:
        return getStructOrUnionSpecifier();
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
      case CPackage.SPECIFIER_QUALIFIER_LIST__TYPE_SPECIFIER:
        getTypeSpecifier().clear();
        getTypeSpecifier().addAll((Collection<? extends TypeSpecifier>)newValue);
        return;
      case CPackage.SPECIFIER_QUALIFIER_LIST__TYPE_QUALIFIER:
        getTypeQualifier().clear();
        getTypeQualifier().addAll((Collection<? extends TypeQualifier>)newValue);
        return;
      case CPackage.SPECIFIER_QUALIFIER_LIST__STRUCT_OR_UNION_SPECIFIER:
        getStructOrUnionSpecifier().clear();
        getStructOrUnionSpecifier().addAll((Collection<? extends DeclarationSpecifier>)newValue);
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
      case CPackage.SPECIFIER_QUALIFIER_LIST__TYPE_SPECIFIER:
        getTypeSpecifier().clear();
        return;
      case CPackage.SPECIFIER_QUALIFIER_LIST__TYPE_QUALIFIER:
        getTypeQualifier().clear();
        return;
      case CPackage.SPECIFIER_QUALIFIER_LIST__STRUCT_OR_UNION_SPECIFIER:
        getStructOrUnionSpecifier().clear();
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
      case CPackage.SPECIFIER_QUALIFIER_LIST__TYPE_SPECIFIER:
        return typeSpecifier != null && !typeSpecifier.isEmpty();
      case CPackage.SPECIFIER_QUALIFIER_LIST__TYPE_QUALIFIER:
        return typeQualifier != null && !typeQualifier.isEmpty();
      case CPackage.SPECIFIER_QUALIFIER_LIST__STRUCT_OR_UNION_SPECIFIER:
        return structOrUnionSpecifier != null && !structOrUnionSpecifier.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SpecifierQualifierListImpl
