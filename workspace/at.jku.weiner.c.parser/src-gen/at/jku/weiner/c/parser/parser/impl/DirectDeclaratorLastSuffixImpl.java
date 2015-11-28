/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.parser.parser.IdentifierList;
import at.jku.weiner.c.parser.parser.ParameterTypeList;
import at.jku.weiner.c.parser.parser.ParserPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Direct Declarator Last Suffix</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DirectDeclaratorLastSuffixImpl#getParameterTypeList <em>Parameter Type List</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DirectDeclaratorLastSuffixImpl#getIdentifierList <em>Identifier List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DirectDeclaratorLastSuffixImpl extends MinimalEObjectImpl.Container implements DirectDeclaratorLastSuffix
{
  /**
   * The cached value of the '{@link #getParameterTypeList() <em>Parameter Type List</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameterTypeList()
   * @generated
   * @ordered
   */
  protected EList<ParameterTypeList> parameterTypeList;

  /**
   * The cached value of the '{@link #getIdentifierList() <em>Identifier List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIdentifierList()
   * @generated
   * @ordered
   */
  protected IdentifierList identifierList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DirectDeclaratorLastSuffixImpl()
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
    return ParserPackage.Literals.DIRECT_DECLARATOR_LAST_SUFFIX;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ParameterTypeList> getParameterTypeList()
  {
    if (parameterTypeList == null)
    {
      parameterTypeList = new EObjectContainmentEList<ParameterTypeList>(ParameterTypeList.class, this, ParserPackage.DIRECT_DECLARATOR_LAST_SUFFIX__PARAMETER_TYPE_LIST);
    }
    return parameterTypeList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IdentifierList getIdentifierList()
  {
    return identifierList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIdentifierList(IdentifierList newIdentifierList, NotificationChain msgs)
  {
    IdentifierList oldIdentifierList = identifierList;
    identifierList = newIdentifierList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.DIRECT_DECLARATOR_LAST_SUFFIX__IDENTIFIER_LIST, oldIdentifierList, newIdentifierList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIdentifierList(IdentifierList newIdentifierList)
  {
    if (newIdentifierList != identifierList)
    {
      NotificationChain msgs = null;
      if (identifierList != null)
        msgs = ((InternalEObject)identifierList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.DIRECT_DECLARATOR_LAST_SUFFIX__IDENTIFIER_LIST, null, msgs);
      if (newIdentifierList != null)
        msgs = ((InternalEObject)newIdentifierList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.DIRECT_DECLARATOR_LAST_SUFFIX__IDENTIFIER_LIST, null, msgs);
      msgs = basicSetIdentifierList(newIdentifierList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.DIRECT_DECLARATOR_LAST_SUFFIX__IDENTIFIER_LIST, newIdentifierList, newIdentifierList));
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
      case ParserPackage.DIRECT_DECLARATOR_LAST_SUFFIX__PARAMETER_TYPE_LIST:
        return ((InternalEList<?>)getParameterTypeList()).basicRemove(otherEnd, msgs);
      case ParserPackage.DIRECT_DECLARATOR_LAST_SUFFIX__IDENTIFIER_LIST:
        return basicSetIdentifierList(null, msgs);
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
      case ParserPackage.DIRECT_DECLARATOR_LAST_SUFFIX__PARAMETER_TYPE_LIST:
        return getParameterTypeList();
      case ParserPackage.DIRECT_DECLARATOR_LAST_SUFFIX__IDENTIFIER_LIST:
        return getIdentifierList();
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
      case ParserPackage.DIRECT_DECLARATOR_LAST_SUFFIX__PARAMETER_TYPE_LIST:
        getParameterTypeList().clear();
        getParameterTypeList().addAll((Collection<? extends ParameterTypeList>)newValue);
        return;
      case ParserPackage.DIRECT_DECLARATOR_LAST_SUFFIX__IDENTIFIER_LIST:
        setIdentifierList((IdentifierList)newValue);
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
      case ParserPackage.DIRECT_DECLARATOR_LAST_SUFFIX__PARAMETER_TYPE_LIST:
        getParameterTypeList().clear();
        return;
      case ParserPackage.DIRECT_DECLARATOR_LAST_SUFFIX__IDENTIFIER_LIST:
        setIdentifierList((IdentifierList)null);
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
      case ParserPackage.DIRECT_DECLARATOR_LAST_SUFFIX__PARAMETER_TYPE_LIST:
        return parameterTypeList != null && !parameterTypeList.isEmpty();
      case ParserPackage.DIRECT_DECLARATOR_LAST_SUFFIX__IDENTIFIER_LIST:
        return identifierList != null;
    }
    return super.eIsSet(featureID);
  }

} //DirectDeclaratorLastSuffixImpl
