/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.Enumerator;
import at.jku.weiner.c.parser.parser.EnumeratorList;
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
 * An implementation of the model object '<em><b>Enumerator List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.EnumeratorListImpl#getEnumerator <em>Enumerator</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.EnumeratorListImpl#isLastComma <em>Last Comma</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumeratorListImpl extends MinimalEObjectImpl.Container implements EnumeratorList
{
  /**
   * The cached value of the '{@link #getEnumerator() <em>Enumerator</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumerator()
   * @generated
   * @ordered
   */
  protected EList<Enumerator> enumerator;

  /**
   * The default value of the '{@link #isLastComma() <em>Last Comma</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLastComma()
   * @generated
   * @ordered
   */
  protected static final boolean LAST_COMMA_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isLastComma() <em>Last Comma</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLastComma()
   * @generated
   * @ordered
   */
  protected boolean lastComma = LAST_COMMA_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnumeratorListImpl()
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
    return ParserPackage.Literals.ENUMERATOR_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Enumerator> getEnumerator()
  {
    if (enumerator == null)
    {
      enumerator = new EObjectContainmentEList<Enumerator>(Enumerator.class, this, ParserPackage.ENUMERATOR_LIST__ENUMERATOR);
    }
    return enumerator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isLastComma()
  {
    return lastComma;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLastComma(boolean newLastComma)
  {
    boolean oldLastComma = lastComma;
    lastComma = newLastComma;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ENUMERATOR_LIST__LAST_COMMA, oldLastComma, lastComma));
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
      case ParserPackage.ENUMERATOR_LIST__ENUMERATOR:
        return ((InternalEList<?>)getEnumerator()).basicRemove(otherEnd, msgs);
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
      case ParserPackage.ENUMERATOR_LIST__ENUMERATOR:
        return getEnumerator();
      case ParserPackage.ENUMERATOR_LIST__LAST_COMMA:
        return isLastComma();
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
      case ParserPackage.ENUMERATOR_LIST__ENUMERATOR:
        getEnumerator().clear();
        getEnumerator().addAll((Collection<? extends Enumerator>)newValue);
        return;
      case ParserPackage.ENUMERATOR_LIST__LAST_COMMA:
        setLastComma((Boolean)newValue);
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
      case ParserPackage.ENUMERATOR_LIST__ENUMERATOR:
        getEnumerator().clear();
        return;
      case ParserPackage.ENUMERATOR_LIST__LAST_COMMA:
        setLastComma(LAST_COMMA_EDEFAULT);
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
      case ParserPackage.ENUMERATOR_LIST__ENUMERATOR:
        return enumerator != null && !enumerator.isEmpty();
      case ParserPackage.ENUMERATOR_LIST__LAST_COMMA:
        return lastComma != LAST_COMMA_EDEFAULT;
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
    result.append(" (lastComma: ");
    result.append(lastComma);
    result.append(')');
    return result.toString();
  }

} //EnumeratorListImpl
