/**
 */
package at.jku.weiner.c.c.impl;

import at.jku.weiner.c.c.BlockList;
import at.jku.weiner.c.c.CPackage;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.Statement;

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
 * An implementation of the model object '<em><b>Block List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.impl.BlockListImpl#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.BlockListImpl#getStatement <em>Statement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BlockListImpl extends MinimalEObjectImpl.Container implements BlockList
{
  /**
   * The cached value of the '{@link #getDeclaration() <em>Declaration</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeclaration()
   * @generated
   * @ordered
   */
  protected EList<Declaration> declaration;

  /**
   * The cached value of the '{@link #getStatement() <em>Statement</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatement()
   * @generated
   * @ordered
   */
  protected EList<Statement> statement;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BlockListImpl()
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
    return CPackage.Literals.BLOCK_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Declaration> getDeclaration()
  {
    if (declaration == null)
    {
      declaration = new EObjectContainmentEList<Declaration>(Declaration.class, this, CPackage.BLOCK_LIST__DECLARATION);
    }
    return declaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Statement> getStatement()
  {
    if (statement == null)
    {
      statement = new EObjectContainmentEList<Statement>(Statement.class, this, CPackage.BLOCK_LIST__STATEMENT);
    }
    return statement;
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
      case CPackage.BLOCK_LIST__DECLARATION:
        return ((InternalEList<?>)getDeclaration()).basicRemove(otherEnd, msgs);
      case CPackage.BLOCK_LIST__STATEMENT:
        return ((InternalEList<?>)getStatement()).basicRemove(otherEnd, msgs);
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
      case CPackage.BLOCK_LIST__DECLARATION:
        return getDeclaration();
      case CPackage.BLOCK_LIST__STATEMENT:
        return getStatement();
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
      case CPackage.BLOCK_LIST__DECLARATION:
        getDeclaration().clear();
        getDeclaration().addAll((Collection<? extends Declaration>)newValue);
        return;
      case CPackage.BLOCK_LIST__STATEMENT:
        getStatement().clear();
        getStatement().addAll((Collection<? extends Statement>)newValue);
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
      case CPackage.BLOCK_LIST__DECLARATION:
        getDeclaration().clear();
        return;
      case CPackage.BLOCK_LIST__STATEMENT:
        getStatement().clear();
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
      case CPackage.BLOCK_LIST__DECLARATION:
        return declaration != null && !declaration.isEmpty();
      case CPackage.BLOCK_LIST__STATEMENT:
        return statement != null && !statement.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //BlockListImpl
