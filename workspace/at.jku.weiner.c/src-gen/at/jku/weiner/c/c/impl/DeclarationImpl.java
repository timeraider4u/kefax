/**
 */
package at.jku.weiner.c.c.impl;

import at.jku.weiner.c.c.CPackage;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.InitDeclaratorList;

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
 * An implementation of the model object '<em><b>Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.impl.DeclarationImpl#getSpecifiers <em>Specifiers</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.DeclarationImpl#getInitDeclaratorList <em>Init Declarator List</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.DeclarationImpl#getSemi <em>Semi</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeclarationImpl extends MinimalEObjectImpl.Container implements Declaration
{
  /**
   * The cached value of the '{@link #getSpecifiers() <em>Specifiers</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpecifiers()
   * @generated
   * @ordered
   */
  protected DeclarationSpecifiers specifiers;

  /**
   * The cached value of the '{@link #getInitDeclaratorList() <em>Init Declarator List</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitDeclaratorList()
   * @generated
   * @ordered
   */
  protected EList<InitDeclaratorList> initDeclaratorList;

  /**
   * The default value of the '{@link #getSemi() <em>Semi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSemi()
   * @generated
   * @ordered
   */
  protected static final String SEMI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSemi() <em>Semi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSemi()
   * @generated
   * @ordered
   */
  protected String semi = SEMI_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DeclarationImpl()
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
    return CPackage.Literals.DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeclarationSpecifiers getSpecifiers()
  {
    return specifiers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSpecifiers(DeclarationSpecifiers newSpecifiers, NotificationChain msgs)
  {
    DeclarationSpecifiers oldSpecifiers = specifiers;
    specifiers = newSpecifiers;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CPackage.DECLARATION__SPECIFIERS, oldSpecifiers, newSpecifiers);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSpecifiers(DeclarationSpecifiers newSpecifiers)
  {
    if (newSpecifiers != specifiers)
    {
      NotificationChain msgs = null;
      if (specifiers != null)
        msgs = ((InternalEObject)specifiers).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CPackage.DECLARATION__SPECIFIERS, null, msgs);
      if (newSpecifiers != null)
        msgs = ((InternalEObject)newSpecifiers).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CPackage.DECLARATION__SPECIFIERS, null, msgs);
      msgs = basicSetSpecifiers(newSpecifiers, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.DECLARATION__SPECIFIERS, newSpecifiers, newSpecifiers));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<InitDeclaratorList> getInitDeclaratorList()
  {
    if (initDeclaratorList == null)
    {
      initDeclaratorList = new EObjectContainmentEList<InitDeclaratorList>(InitDeclaratorList.class, this, CPackage.DECLARATION__INIT_DECLARATOR_LIST);
    }
    return initDeclaratorList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSemi()
  {
    return semi;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSemi(String newSemi)
  {
    String oldSemi = semi;
    semi = newSemi;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.DECLARATION__SEMI, oldSemi, semi));
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
      case CPackage.DECLARATION__SPECIFIERS:
        return basicSetSpecifiers(null, msgs);
      case CPackage.DECLARATION__INIT_DECLARATOR_LIST:
        return ((InternalEList<?>)getInitDeclaratorList()).basicRemove(otherEnd, msgs);
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
      case CPackage.DECLARATION__SPECIFIERS:
        return getSpecifiers();
      case CPackage.DECLARATION__INIT_DECLARATOR_LIST:
        return getInitDeclaratorList();
      case CPackage.DECLARATION__SEMI:
        return getSemi();
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
      case CPackage.DECLARATION__SPECIFIERS:
        setSpecifiers((DeclarationSpecifiers)newValue);
        return;
      case CPackage.DECLARATION__INIT_DECLARATOR_LIST:
        getInitDeclaratorList().clear();
        getInitDeclaratorList().addAll((Collection<? extends InitDeclaratorList>)newValue);
        return;
      case CPackage.DECLARATION__SEMI:
        setSemi((String)newValue);
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
      case CPackage.DECLARATION__SPECIFIERS:
        setSpecifiers((DeclarationSpecifiers)null);
        return;
      case CPackage.DECLARATION__INIT_DECLARATOR_LIST:
        getInitDeclaratorList().clear();
        return;
      case CPackage.DECLARATION__SEMI:
        setSemi(SEMI_EDEFAULT);
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
      case CPackage.DECLARATION__SPECIFIERS:
        return specifiers != null;
      case CPackage.DECLARATION__INIT_DECLARATOR_LIST:
        return initDeclaratorList != null && !initDeclaratorList.isEmpty();
      case CPackage.DECLARATION__SEMI:
        return SEMI_EDEFAULT == null ? semi != null : !SEMI_EDEFAULT.equals(semi);
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
    result.append(" (semi: ");
    result.append(semi);
    result.append(')');
    return result.toString();
  }

} //DeclarationImpl
