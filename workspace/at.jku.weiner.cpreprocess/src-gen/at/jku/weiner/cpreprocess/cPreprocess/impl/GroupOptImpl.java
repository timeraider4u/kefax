/**
 */
package at.jku.weiner.cpreprocess.cPreprocess.impl;

import at.jku.weiner.cpreprocess.cPreprocess.CPreprocessPackage;
import at.jku.weiner.cpreprocess.cPreprocess.GroupOpt;
import at.jku.weiner.cpreprocess.cPreprocess.SourceCodeLine;

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
 * An implementation of the model object '<em><b>Group Opt</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.cpreprocess.cPreprocess.impl.GroupOptImpl#getLines <em>Lines</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GroupOptImpl extends MinimalEObjectImpl.Container implements GroupOpt
{
  /**
   * The cached value of the '{@link #getLines() <em>Lines</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLines()
   * @generated
   * @ordered
   */
  protected EList<SourceCodeLine> lines;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GroupOptImpl()
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
    return CPreprocessPackage.Literals.GROUP_OPT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SourceCodeLine> getLines()
  {
    if (lines == null)
    {
      lines = new EObjectContainmentEList<SourceCodeLine>(SourceCodeLine.class, this, CPreprocessPackage.GROUP_OPT__LINES);
    }
    return lines;
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
      case CPreprocessPackage.GROUP_OPT__LINES:
        return ((InternalEList<?>)getLines()).basicRemove(otherEnd, msgs);
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
      case CPreprocessPackage.GROUP_OPT__LINES:
        return getLines();
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
      case CPreprocessPackage.GROUP_OPT__LINES:
        getLines().clear();
        getLines().addAll((Collection<? extends SourceCodeLine>)newValue);
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
      case CPreprocessPackage.GROUP_OPT__LINES:
        getLines().clear();
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
      case CPreprocessPackage.GROUP_OPT__LINES:
        return lines != null && !lines.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //GroupOptImpl
