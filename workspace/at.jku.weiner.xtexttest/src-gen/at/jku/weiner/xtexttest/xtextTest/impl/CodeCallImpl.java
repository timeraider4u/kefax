/**
 */
package at.jku.weiner.xtexttest.xtextTest.impl;

import at.jku.weiner.xtexttest.xtextTest.CodeCall;
import at.jku.weiner.xtexttest.xtextTest.XtextTestPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Code Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.CodeCallImpl#getMyclass <em>Myclass</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.CodeCallImpl#getMethod <em>Method</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.CodeCallImpl#getParams <em>Params</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CodeCallImpl extends MinimalEObjectImpl.Container implements CodeCall
{
  /**
   * The default value of the '{@link #getMyclass() <em>Myclass</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMyclass()
   * @generated
   * @ordered
   */
  protected static final String MYCLASS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMyclass() <em>Myclass</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMyclass()
   * @generated
   * @ordered
   */
  protected String myclass = MYCLASS_EDEFAULT;

  /**
   * The default value of the '{@link #getMethod() <em>Method</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethod()
   * @generated
   * @ordered
   */
  protected static final String METHOD_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMethod() <em>Method</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethod()
   * @generated
   * @ordered
   */
  protected String method = METHOD_EDEFAULT;

  /**
   * The cached value of the '{@link #getParams() <em>Params</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParams()
   * @generated
   * @ordered
   */
  protected EList<String> params;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CodeCallImpl()
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
    return XtextTestPackage.Literals.CODE_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMyclass()
  {
    return myclass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMyclass(String newMyclass)
  {
    String oldMyclass = myclass;
    myclass = newMyclass;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.CODE_CALL__MYCLASS, oldMyclass, myclass));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMethod()
  {
    return method;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMethod(String newMethod)
  {
    String oldMethod = method;
    method = newMethod;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.CODE_CALL__METHOD, oldMethod, method));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getParams()
  {
    if (params == null)
    {
      params = new EDataTypeEList<String>(String.class, this, XtextTestPackage.CODE_CALL__PARAMS);
    }
    return params;
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
      case XtextTestPackage.CODE_CALL__MYCLASS:
        return getMyclass();
      case XtextTestPackage.CODE_CALL__METHOD:
        return getMethod();
      case XtextTestPackage.CODE_CALL__PARAMS:
        return getParams();
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
      case XtextTestPackage.CODE_CALL__MYCLASS:
        setMyclass((String)newValue);
        return;
      case XtextTestPackage.CODE_CALL__METHOD:
        setMethod((String)newValue);
        return;
      case XtextTestPackage.CODE_CALL__PARAMS:
        getParams().clear();
        getParams().addAll((Collection<? extends String>)newValue);
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
      case XtextTestPackage.CODE_CALL__MYCLASS:
        setMyclass(MYCLASS_EDEFAULT);
        return;
      case XtextTestPackage.CODE_CALL__METHOD:
        setMethod(METHOD_EDEFAULT);
        return;
      case XtextTestPackage.CODE_CALL__PARAMS:
        getParams().clear();
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
      case XtextTestPackage.CODE_CALL__MYCLASS:
        return MYCLASS_EDEFAULT == null ? myclass != null : !MYCLASS_EDEFAULT.equals(myclass);
      case XtextTestPackage.CODE_CALL__METHOD:
        return METHOD_EDEFAULT == null ? method != null : !METHOD_EDEFAULT.equals(method);
      case XtextTestPackage.CODE_CALL__PARAMS:
        return params != null && !params.isEmpty();
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
    result.append(" (myclass: ");
    result.append(myclass);
    result.append(", method: ");
    result.append(method);
    result.append(", params: ");
    result.append(params);
    result.append(')');
    return result.toString();
  }

} //CodeCallImpl
