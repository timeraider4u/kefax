/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.ParserPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declaration Specifiers</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DeclarationSpecifiersImpl#getDeclarationSpecifier <em>Declaration Specifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeclarationSpecifiersImpl extends MinimalEObjectImpl.Container implements DeclarationSpecifiers
{
  /**
   * The cached value of the '{@link #getDeclarationSpecifier() <em>Declaration Specifier</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeclarationSpecifier()
   * @generated
   * @ordered
   */
  protected EList<EObject> declarationSpecifier;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DeclarationSpecifiersImpl()
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
    return ParserPackage.Literals.DECLARATION_SPECIFIERS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EObject> getDeclarationSpecifier()
  {
    if (declarationSpecifier == null)
    {
      declarationSpecifier = new EObjectContainmentEList<EObject>(EObject.class, this, ParserPackage.DECLARATION_SPECIFIERS__DECLARATION_SPECIFIER);
    }
    return declarationSpecifier;
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
      case ParserPackage.DECLARATION_SPECIFIERS__DECLARATION_SPECIFIER:
        return ((InternalEList<?>)getDeclarationSpecifier()).basicRemove(otherEnd, msgs);
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
      case ParserPackage.DECLARATION_SPECIFIERS__DECLARATION_SPECIFIER:
        return getDeclarationSpecifier();
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
      case ParserPackage.DECLARATION_SPECIFIERS__DECLARATION_SPECIFIER:
        getDeclarationSpecifier().clear();
        getDeclarationSpecifier().addAll((Collection<? extends EObject>)newValue);
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
      case ParserPackage.DECLARATION_SPECIFIERS__DECLARATION_SPECIFIER:
        getDeclarationSpecifier().clear();
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
      case ParserPackage.DECLARATION_SPECIFIERS__DECLARATION_SPECIFIER:
        return declarationSpecifier != null && !declarationSpecifier.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //DeclarationSpecifiersImpl
