/**
 */
package at.jku.weiner.c.c.impl;

import at.jku.weiner.c.c.BlockList;
import at.jku.weiner.c.c.BodyStatement;
import at.jku.weiner.c.c.CPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Body Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.impl.BodyStatementImpl#getBlockList <em>Block List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BodyStatementImpl extends StatementImpl implements BodyStatement
{
  /**
   * The cached value of the '{@link #getBlockList() <em>Block List</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBlockList()
   * @generated
   * @ordered
   */
  protected EList<BlockList> blockList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BodyStatementImpl()
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
    return CPackage.Literals.BODY_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<BlockList> getBlockList()
  {
    if (blockList == null)
    {
      blockList = new EObjectContainmentEList<BlockList>(BlockList.class, this, CPackage.BODY_STATEMENT__BLOCK_LIST);
    }
    return blockList;
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
      case CPackage.BODY_STATEMENT__BLOCK_LIST:
        return ((InternalEList<?>)getBlockList()).basicRemove(otherEnd, msgs);
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
      case CPackage.BODY_STATEMENT__BLOCK_LIST:
        return getBlockList();
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
      case CPackage.BODY_STATEMENT__BLOCK_LIST:
        getBlockList().clear();
        getBlockList().addAll((Collection<? extends BlockList>)newValue);
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
      case CPackage.BODY_STATEMENT__BLOCK_LIST:
        getBlockList().clear();
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
      case CPackage.BODY_STATEMENT__BLOCK_LIST:
        return blockList != null && !blockList.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //BodyStatementImpl
