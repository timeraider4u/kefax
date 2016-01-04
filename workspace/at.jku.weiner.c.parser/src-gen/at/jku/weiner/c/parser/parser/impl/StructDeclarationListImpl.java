/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.StructDeclaration;
import at.jku.weiner.c.parser.parser.StructDeclarationList;

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
 * An implementation of the model object '<em><b>Struct Declaration List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.StructDeclarationListImpl#getStructDeclaration <em>Struct Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructDeclarationListImpl extends MinimalEObjectImpl.Container implements StructDeclarationList
{
  /**
   * The cached value of the '{@link #getStructDeclaration() <em>Struct Declaration</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStructDeclaration()
   * @generated
   * @ordered
   */
  protected EList<StructDeclaration> structDeclaration;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StructDeclarationListImpl()
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
    return ParserPackage.Literals.STRUCT_DECLARATION_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StructDeclaration> getStructDeclaration()
  {
    if (structDeclaration == null)
    {
      structDeclaration = new EObjectContainmentEList<StructDeclaration>(StructDeclaration.class, this, ParserPackage.STRUCT_DECLARATION_LIST__STRUCT_DECLARATION);
    }
    return structDeclaration;
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
      case ParserPackage.STRUCT_DECLARATION_LIST__STRUCT_DECLARATION:
        return ((InternalEList<?>)getStructDeclaration()).basicRemove(otherEnd, msgs);
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
      case ParserPackage.STRUCT_DECLARATION_LIST__STRUCT_DECLARATION:
        return getStructDeclaration();
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
      case ParserPackage.STRUCT_DECLARATION_LIST__STRUCT_DECLARATION:
        getStructDeclaration().clear();
        getStructDeclaration().addAll((Collection<? extends StructDeclaration>)newValue);
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
      case ParserPackage.STRUCT_DECLARATION_LIST__STRUCT_DECLARATION:
        getStructDeclaration().clear();
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
      case ParserPackage.STRUCT_DECLARATION_LIST__STRUCT_DECLARATION:
        return structDeclaration != null && !structDeclaration.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //StructDeclarationListImpl
