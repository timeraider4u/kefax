/**
 */
package at.jku.weiner.xtexttest.xtextTest.impl;

import at.jku.weiner.xtexttest.xtextTest.Element;
import at.jku.weiner.xtexttest.xtextTest.Inner;
import at.jku.weiner.xtexttest.xtextTest.XtextTestPackage;

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
 * An implementation of the model object '<em><b>Inner</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.InnerImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.InnerImpl#getAssign <em>Assign</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.InnerImpl#getAssignList <em>Assign List</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.InnerImpl#getValue <em>Value</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.InnerImpl#getAssignAsData <em>Assign As Data</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.InnerImpl#getAssignAsBool <em>Assign As Bool</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.InnerImpl#isIsNull <em>Is Null</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.InnerImpl#isIsNotNull <em>Is Not Null</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.InnerImpl#isIsEmpty <em>Is Empty</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InnerImpl extends MinimalEObjectImpl.Container implements Inner
{
  /**
   * The default value of the '{@link #getParameter() <em>Parameter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameter()
   * @generated
   * @ordered
   */
  protected static final String PARAMETER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getParameter() <em>Parameter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameter()
   * @generated
   * @ordered
   */
  protected String parameter = PARAMETER_EDEFAULT;

  /**
   * The cached value of the '{@link #getAssign() <em>Assign</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssign()
   * @generated
   * @ordered
   */
  protected Element assign;

  /**
   * The cached value of the '{@link #getAssignList() <em>Assign List</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssignList()
   * @generated
   * @ordered
   */
  protected EList<Element> assignList;

  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final String VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected String value = VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getAssignAsData() <em>Assign As Data</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssignAsData()
   * @generated
   * @ordered
   */
  protected static final String ASSIGN_AS_DATA_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAssignAsData() <em>Assign As Data</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssignAsData()
   * @generated
   * @ordered
   */
  protected String assignAsData = ASSIGN_AS_DATA_EDEFAULT;

  /**
   * The default value of the '{@link #getAssignAsBool() <em>Assign As Bool</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssignAsBool()
   * @generated
   * @ordered
   */
  protected static final String ASSIGN_AS_BOOL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAssignAsBool() <em>Assign As Bool</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssignAsBool()
   * @generated
   * @ordered
   */
  protected String assignAsBool = ASSIGN_AS_BOOL_EDEFAULT;

  /**
   * The default value of the '{@link #isIsNull() <em>Is Null</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsNull()
   * @generated
   * @ordered
   */
  protected static final boolean IS_NULL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsNull() <em>Is Null</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsNull()
   * @generated
   * @ordered
   */
  protected boolean isNull = IS_NULL_EDEFAULT;

  /**
   * The default value of the '{@link #isIsNotNull() <em>Is Not Null</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsNotNull()
   * @generated
   * @ordered
   */
  protected static final boolean IS_NOT_NULL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsNotNull() <em>Is Not Null</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsNotNull()
   * @generated
   * @ordered
   */
  protected boolean isNotNull = IS_NOT_NULL_EDEFAULT;

  /**
   * The default value of the '{@link #isIsEmpty() <em>Is Empty</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsEmpty()
   * @generated
   * @ordered
   */
  protected static final boolean IS_EMPTY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsEmpty() <em>Is Empty</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsEmpty()
   * @generated
   * @ordered
   */
  protected boolean isEmpty = IS_EMPTY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InnerImpl()
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
    return XtextTestPackage.Literals.INNER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getParameter()
  {
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParameter(String newParameter)
  {
    String oldParameter = parameter;
    parameter = newParameter;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.INNER__PARAMETER, oldParameter, parameter));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Element getAssign()
  {
    return assign;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAssign(Element newAssign, NotificationChain msgs)
  {
    Element oldAssign = assign;
    assign = newAssign;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtextTestPackage.INNER__ASSIGN, oldAssign, newAssign);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssign(Element newAssign)
  {
    if (newAssign != assign)
    {
      NotificationChain msgs = null;
      if (assign != null)
        msgs = ((InternalEObject)assign).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.INNER__ASSIGN, null, msgs);
      if (newAssign != null)
        msgs = ((InternalEObject)newAssign).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.INNER__ASSIGN, null, msgs);
      msgs = basicSetAssign(newAssign, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.INNER__ASSIGN, newAssign, newAssign));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Element> getAssignList()
  {
    if (assignList == null)
    {
      assignList = new EObjectContainmentEList<Element>(Element.class, this, XtextTestPackage.INNER__ASSIGN_LIST);
    }
    return assignList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(String newValue)
  {
    String oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.INNER__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAssignAsData()
  {
    return assignAsData;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssignAsData(String newAssignAsData)
  {
    String oldAssignAsData = assignAsData;
    assignAsData = newAssignAsData;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.INNER__ASSIGN_AS_DATA, oldAssignAsData, assignAsData));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAssignAsBool()
  {
    return assignAsBool;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssignAsBool(String newAssignAsBool)
  {
    String oldAssignAsBool = assignAsBool;
    assignAsBool = newAssignAsBool;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.INNER__ASSIGN_AS_BOOL, oldAssignAsBool, assignAsBool));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsNull()
  {
    return isNull;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsNull(boolean newIsNull)
  {
    boolean oldIsNull = isNull;
    isNull = newIsNull;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.INNER__IS_NULL, oldIsNull, isNull));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsNotNull()
  {
    return isNotNull;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsNotNull(boolean newIsNotNull)
  {
    boolean oldIsNotNull = isNotNull;
    isNotNull = newIsNotNull;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.INNER__IS_NOT_NULL, oldIsNotNull, isNotNull));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsEmpty()
  {
    return isEmpty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsEmpty(boolean newIsEmpty)
  {
    boolean oldIsEmpty = isEmpty;
    isEmpty = newIsEmpty;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.INNER__IS_EMPTY, oldIsEmpty, isEmpty));
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
      case XtextTestPackage.INNER__ASSIGN:
        return basicSetAssign(null, msgs);
      case XtextTestPackage.INNER__ASSIGN_LIST:
        return ((InternalEList<?>)getAssignList()).basicRemove(otherEnd, msgs);
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
      case XtextTestPackage.INNER__PARAMETER:
        return getParameter();
      case XtextTestPackage.INNER__ASSIGN:
        return getAssign();
      case XtextTestPackage.INNER__ASSIGN_LIST:
        return getAssignList();
      case XtextTestPackage.INNER__VALUE:
        return getValue();
      case XtextTestPackage.INNER__ASSIGN_AS_DATA:
        return getAssignAsData();
      case XtextTestPackage.INNER__ASSIGN_AS_BOOL:
        return getAssignAsBool();
      case XtextTestPackage.INNER__IS_NULL:
        return isIsNull();
      case XtextTestPackage.INNER__IS_NOT_NULL:
        return isIsNotNull();
      case XtextTestPackage.INNER__IS_EMPTY:
        return isIsEmpty();
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
      case XtextTestPackage.INNER__PARAMETER:
        setParameter((String)newValue);
        return;
      case XtextTestPackage.INNER__ASSIGN:
        setAssign((Element)newValue);
        return;
      case XtextTestPackage.INNER__ASSIGN_LIST:
        getAssignList().clear();
        getAssignList().addAll((Collection<? extends Element>)newValue);
        return;
      case XtextTestPackage.INNER__VALUE:
        setValue((String)newValue);
        return;
      case XtextTestPackage.INNER__ASSIGN_AS_DATA:
        setAssignAsData((String)newValue);
        return;
      case XtextTestPackage.INNER__ASSIGN_AS_BOOL:
        setAssignAsBool((String)newValue);
        return;
      case XtextTestPackage.INNER__IS_NULL:
        setIsNull((Boolean)newValue);
        return;
      case XtextTestPackage.INNER__IS_NOT_NULL:
        setIsNotNull((Boolean)newValue);
        return;
      case XtextTestPackage.INNER__IS_EMPTY:
        setIsEmpty((Boolean)newValue);
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
      case XtextTestPackage.INNER__PARAMETER:
        setParameter(PARAMETER_EDEFAULT);
        return;
      case XtextTestPackage.INNER__ASSIGN:
        setAssign((Element)null);
        return;
      case XtextTestPackage.INNER__ASSIGN_LIST:
        getAssignList().clear();
        return;
      case XtextTestPackage.INNER__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
      case XtextTestPackage.INNER__ASSIGN_AS_DATA:
        setAssignAsData(ASSIGN_AS_DATA_EDEFAULT);
        return;
      case XtextTestPackage.INNER__ASSIGN_AS_BOOL:
        setAssignAsBool(ASSIGN_AS_BOOL_EDEFAULT);
        return;
      case XtextTestPackage.INNER__IS_NULL:
        setIsNull(IS_NULL_EDEFAULT);
        return;
      case XtextTestPackage.INNER__IS_NOT_NULL:
        setIsNotNull(IS_NOT_NULL_EDEFAULT);
        return;
      case XtextTestPackage.INNER__IS_EMPTY:
        setIsEmpty(IS_EMPTY_EDEFAULT);
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
      case XtextTestPackage.INNER__PARAMETER:
        return PARAMETER_EDEFAULT == null ? parameter != null : !PARAMETER_EDEFAULT.equals(parameter);
      case XtextTestPackage.INNER__ASSIGN:
        return assign != null;
      case XtextTestPackage.INNER__ASSIGN_LIST:
        return assignList != null && !assignList.isEmpty();
      case XtextTestPackage.INNER__VALUE:
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
      case XtextTestPackage.INNER__ASSIGN_AS_DATA:
        return ASSIGN_AS_DATA_EDEFAULT == null ? assignAsData != null : !ASSIGN_AS_DATA_EDEFAULT.equals(assignAsData);
      case XtextTestPackage.INNER__ASSIGN_AS_BOOL:
        return ASSIGN_AS_BOOL_EDEFAULT == null ? assignAsBool != null : !ASSIGN_AS_BOOL_EDEFAULT.equals(assignAsBool);
      case XtextTestPackage.INNER__IS_NULL:
        return isNull != IS_NULL_EDEFAULT;
      case XtextTestPackage.INNER__IS_NOT_NULL:
        return isNotNull != IS_NOT_NULL_EDEFAULT;
      case XtextTestPackage.INNER__IS_EMPTY:
        return isEmpty != IS_EMPTY_EDEFAULT;
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
    result.append(" (parameter: ");
    result.append(parameter);
    result.append(", value: ");
    result.append(value);
    result.append(", assignAsData: ");
    result.append(assignAsData);
    result.append(", assignAsBool: ");
    result.append(assignAsBool);
    result.append(", isNull: ");
    result.append(isNull);
    result.append(", isNotNull: ");
    result.append(isNotNull);
    result.append(", isEmpty: ");
    result.append(isEmpty);
    result.append(')');
    return result.toString();
  }

} //InnerImpl
