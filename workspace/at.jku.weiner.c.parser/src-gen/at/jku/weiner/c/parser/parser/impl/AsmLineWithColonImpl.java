/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.ParserPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Asm Line With Colon</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AsmLineWithColonImpl#isColon <em>Colon</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AsmLineWithColonImpl extends AsmLineImpl implements AsmLineWithColon
{
  /**
   * The default value of the '{@link #isColon() <em>Colon</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isColon()
   * @generated
   * @ordered
   */
  protected static final boolean COLON_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isColon() <em>Colon</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isColon()
   * @generated
   * @ordered
   */
  protected boolean colon = COLON_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AsmLineWithColonImpl()
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
    return ParserPackage.Literals.ASM_LINE_WITH_COLON;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isColon()
  {
    return colon;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setColon(boolean newColon)
  {
    boolean oldColon = colon;
    colon = newColon;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ASM_LINE_WITH_COLON__COLON, oldColon, colon));
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
      case ParserPackage.ASM_LINE_WITH_COLON__COLON:
        return isColon();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ParserPackage.ASM_LINE_WITH_COLON__COLON:
        setColon((Boolean)newValue);
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
      case ParserPackage.ASM_LINE_WITH_COLON__COLON:
        setColon(COLON_EDEFAULT);
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
      case ParserPackage.ASM_LINE_WITH_COLON__COLON:
        return colon != COLON_EDEFAULT;
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
    result.append(" (colon: ");
    result.append(colon);
    result.append(')');
    return result.toString();
  }

} //AsmLineWithColonImpl
