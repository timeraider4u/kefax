/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
import at.jku.weiner.c.parser.parser.ParserPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Asm Line With Colon</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AsmLineWithColonImpl#getAsmLine <em>Asm Line</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AsmLineWithColonImpl extends MinimalEObjectImpl.Container implements AsmLineWithColon
{
  /**
   * The cached value of the '{@link #getAsmLine() <em>Asm Line</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAsmLine()
   * @generated
   * @ordered
   */
  protected AsmLineWithoutColon asmLine;

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
  public AsmLineWithoutColon getAsmLine()
  {
    return asmLine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAsmLine(AsmLineWithoutColon newAsmLine, NotificationChain msgs)
  {
    AsmLineWithoutColon oldAsmLine = asmLine;
    asmLine = newAsmLine;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.ASM_LINE_WITH_COLON__ASM_LINE, oldAsmLine, newAsmLine);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAsmLine(AsmLineWithoutColon newAsmLine)
  {
    if (newAsmLine != asmLine)
    {
      NotificationChain msgs = null;
      if (asmLine != null)
        msgs = ((InternalEObject)asmLine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ASM_LINE_WITH_COLON__ASM_LINE, null, msgs);
      if (newAsmLine != null)
        msgs = ((InternalEObject)newAsmLine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ASM_LINE_WITH_COLON__ASM_LINE, null, msgs);
      msgs = basicSetAsmLine(newAsmLine, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ASM_LINE_WITH_COLON__ASM_LINE, newAsmLine, newAsmLine));
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
      case ParserPackage.ASM_LINE_WITH_COLON__ASM_LINE:
        return basicSetAsmLine(null, msgs);
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
      case ParserPackage.ASM_LINE_WITH_COLON__ASM_LINE:
        return getAsmLine();
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
      case ParserPackage.ASM_LINE_WITH_COLON__ASM_LINE:
        setAsmLine((AsmLineWithoutColon)newValue);
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
      case ParserPackage.ASM_LINE_WITH_COLON__ASM_LINE:
        setAsmLine((AsmLineWithoutColon)null);
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
      case ParserPackage.ASM_LINE_WITH_COLON__ASM_LINE:
        return asmLine != null;
    }
    return super.eIsSet(featureID);
  }

} //AsmLineWithColonImpl
