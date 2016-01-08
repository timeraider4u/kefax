/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.AsmLineWithColon;
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
import at.jku.weiner.c.parser.parser.AsmStatement;
import at.jku.weiner.c.parser.parser.ParserPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Asm Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AsmStatementImpl#getAsm <em>Asm</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AsmStatementImpl#getVolatile <em>Volatile</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AsmStatementImpl#getAsmLine1 <em>Asm Line1</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AsmStatementImpl#getAsmLines <em>Asm Lines</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AsmStatementImpl#getSemi <em>Semi</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AsmStatementImpl extends StatementImpl implements AsmStatement
{
  /**
   * The default value of the '{@link #getAsm() <em>Asm</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAsm()
   * @generated
   * @ordered
   */
  protected static final String ASM_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAsm() <em>Asm</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAsm()
   * @generated
   * @ordered
   */
  protected String asm = ASM_EDEFAULT;

  /**
   * The default value of the '{@link #getVolatile() <em>Volatile</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVolatile()
   * @generated
   * @ordered
   */
  protected static final String VOLATILE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVolatile() <em>Volatile</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVolatile()
   * @generated
   * @ordered
   */
  protected String volatile_ = VOLATILE_EDEFAULT;

  /**
   * The cached value of the '{@link #getAsmLine1() <em>Asm Line1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAsmLine1()
   * @generated
   * @ordered
   */
  protected AsmLineWithoutColon asmLine1;

  /**
   * The cached value of the '{@link #getAsmLines() <em>Asm Lines</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAsmLines()
   * @generated
   * @ordered
   */
  protected EList<AsmLineWithColon> asmLines;

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
  protected AsmStatementImpl()
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
    return ParserPackage.Literals.ASM_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAsm()
  {
    return asm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAsm(String newAsm)
  {
    String oldAsm = asm;
    asm = newAsm;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ASM_STATEMENT__ASM, oldAsm, asm));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVolatile()
  {
    return volatile_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVolatile(String newVolatile)
  {
    String oldVolatile = volatile_;
    volatile_ = newVolatile;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ASM_STATEMENT__VOLATILE, oldVolatile, volatile_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AsmLineWithoutColon getAsmLine1()
  {
    return asmLine1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAsmLine1(AsmLineWithoutColon newAsmLine1, NotificationChain msgs)
  {
    AsmLineWithoutColon oldAsmLine1 = asmLine1;
    asmLine1 = newAsmLine1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.ASM_STATEMENT__ASM_LINE1, oldAsmLine1, newAsmLine1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAsmLine1(AsmLineWithoutColon newAsmLine1)
  {
    if (newAsmLine1 != asmLine1)
    {
      NotificationChain msgs = null;
      if (asmLine1 != null)
        msgs = ((InternalEObject)asmLine1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ASM_STATEMENT__ASM_LINE1, null, msgs);
      if (newAsmLine1 != null)
        msgs = ((InternalEObject)newAsmLine1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ASM_STATEMENT__ASM_LINE1, null, msgs);
      msgs = basicSetAsmLine1(newAsmLine1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ASM_STATEMENT__ASM_LINE1, newAsmLine1, newAsmLine1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AsmLineWithColon> getAsmLines()
  {
    if (asmLines == null)
    {
      asmLines = new EObjectContainmentEList<AsmLineWithColon>(AsmLineWithColon.class, this, ParserPackage.ASM_STATEMENT__ASM_LINES);
    }
    return asmLines;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ASM_STATEMENT__SEMI, oldSemi, semi));
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
      case ParserPackage.ASM_STATEMENT__ASM_LINE1:
        return basicSetAsmLine1(null, msgs);
      case ParserPackage.ASM_STATEMENT__ASM_LINES:
        return ((InternalEList<?>)getAsmLines()).basicRemove(otherEnd, msgs);
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
      case ParserPackage.ASM_STATEMENT__ASM:
        return getAsm();
      case ParserPackage.ASM_STATEMENT__VOLATILE:
        return getVolatile();
      case ParserPackage.ASM_STATEMENT__ASM_LINE1:
        return getAsmLine1();
      case ParserPackage.ASM_STATEMENT__ASM_LINES:
        return getAsmLines();
      case ParserPackage.ASM_STATEMENT__SEMI:
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
      case ParserPackage.ASM_STATEMENT__ASM:
        setAsm((String)newValue);
        return;
      case ParserPackage.ASM_STATEMENT__VOLATILE:
        setVolatile((String)newValue);
        return;
      case ParserPackage.ASM_STATEMENT__ASM_LINE1:
        setAsmLine1((AsmLineWithoutColon)newValue);
        return;
      case ParserPackage.ASM_STATEMENT__ASM_LINES:
        getAsmLines().clear();
        getAsmLines().addAll((Collection<? extends AsmLineWithColon>)newValue);
        return;
      case ParserPackage.ASM_STATEMENT__SEMI:
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
      case ParserPackage.ASM_STATEMENT__ASM:
        setAsm(ASM_EDEFAULT);
        return;
      case ParserPackage.ASM_STATEMENT__VOLATILE:
        setVolatile(VOLATILE_EDEFAULT);
        return;
      case ParserPackage.ASM_STATEMENT__ASM_LINE1:
        setAsmLine1((AsmLineWithoutColon)null);
        return;
      case ParserPackage.ASM_STATEMENT__ASM_LINES:
        getAsmLines().clear();
        return;
      case ParserPackage.ASM_STATEMENT__SEMI:
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
      case ParserPackage.ASM_STATEMENT__ASM:
        return ASM_EDEFAULT == null ? asm != null : !ASM_EDEFAULT.equals(asm);
      case ParserPackage.ASM_STATEMENT__VOLATILE:
        return VOLATILE_EDEFAULT == null ? volatile_ != null : !VOLATILE_EDEFAULT.equals(volatile_);
      case ParserPackage.ASM_STATEMENT__ASM_LINE1:
        return asmLine1 != null;
      case ParserPackage.ASM_STATEMENT__ASM_LINES:
        return asmLines != null && !asmLines.isEmpty();
      case ParserPackage.ASM_STATEMENT__SEMI:
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
    result.append(" (asm: ");
    result.append(asm);
    result.append(", volatile: ");
    result.append(volatile_);
    result.append(", semi: ");
    result.append(semi);
    result.append(')');
    return result.toString();
  }

} //AsmStatementImpl
