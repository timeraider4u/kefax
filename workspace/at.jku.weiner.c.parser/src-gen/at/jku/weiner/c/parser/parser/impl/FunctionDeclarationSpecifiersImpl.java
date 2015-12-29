/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers;
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
 * An implementation of the model object '<em><b>Function Declaration Specifiers</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.FunctionDeclarationSpecifiersImpl#getDeclarationSpecifier <em>Declaration Specifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionDeclarationSpecifiersImpl extends MinimalEObjectImpl.Container implements FunctionDeclarationSpecifiers
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
  protected FunctionDeclarationSpecifiersImpl()
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
    return ParserPackage.Literals.FUNCTION_DECLARATION_SPECIFIERS;
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
      declarationSpecifier = new EObjectContainmentEList<EObject>(EObject.class, this, ParserPackage.FUNCTION_DECLARATION_SPECIFIERS__DECLARATION_SPECIFIER);
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
      case ParserPackage.FUNCTION_DECLARATION_SPECIFIERS__DECLARATION_SPECIFIER:
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
      case ParserPackage.FUNCTION_DECLARATION_SPECIFIERS__DECLARATION_SPECIFIER:
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
      case ParserPackage.FUNCTION_DECLARATION_SPECIFIERS__DECLARATION_SPECIFIER:
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
      case ParserPackage.FUNCTION_DECLARATION_SPECIFIERS__DECLARATION_SPECIFIER:
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
      case ParserPackage.FUNCTION_DECLARATION_SPECIFIERS__DECLARATION_SPECIFIER:
        return declarationSpecifier != null && !declarationSpecifier.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FunctionDeclarationSpecifiersImpl
