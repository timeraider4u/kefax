/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.AsmLine;
import at.jku.weiner.c.parser.parser.AsmLineWithoutColon;
import at.jku.weiner.c.parser.parser.AsmSymbolicName;
import at.jku.weiner.c.parser.parser.Expression;
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
 * An implementation of the model object '<em><b>Asm Line Without Colon</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AsmLineWithoutColonImpl#getSym <em>Sym</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AsmLineWithoutColonImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AsmLineWithoutColonImpl#getAsmLines <em>Asm Lines</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AsmLineWithoutColonImpl extends MinimalEObjectImpl.Container implements AsmLineWithoutColon
{
  /**
   * The cached value of the '{@link #getSym() <em>Sym</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSym()
   * @generated
   * @ordered
   */
  protected AsmSymbolicName sym;

  /**
   * The cached value of the '{@link #getExpr() <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpr()
   * @generated
   * @ordered
   */
  protected Expression expr;

  /**
   * The cached value of the '{@link #getAsmLines() <em>Asm Lines</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAsmLines()
   * @generated
   * @ordered
   */
  protected EList<AsmLine> asmLines;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AsmLineWithoutColonImpl()
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
    return ParserPackage.Literals.ASM_LINE_WITHOUT_COLON;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AsmSymbolicName getSym()
  {
    return sym;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSym(AsmSymbolicName newSym, NotificationChain msgs)
  {
    AsmSymbolicName oldSym = sym;
    sym = newSym;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.ASM_LINE_WITHOUT_COLON__SYM, oldSym, newSym);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSym(AsmSymbolicName newSym)
  {
    if (newSym != sym)
    {
      NotificationChain msgs = null;
      if (sym != null)
        msgs = ((InternalEObject)sym).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ASM_LINE_WITHOUT_COLON__SYM, null, msgs);
      if (newSym != null)
        msgs = ((InternalEObject)newSym).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ASM_LINE_WITHOUT_COLON__SYM, null, msgs);
      msgs = basicSetSym(newSym, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ASM_LINE_WITHOUT_COLON__SYM, newSym, newSym));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpr()
  {
    return expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpr(Expression newExpr, NotificationChain msgs)
  {
    Expression oldExpr = expr;
    expr = newExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.ASM_LINE_WITHOUT_COLON__EXPR, oldExpr, newExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpr(Expression newExpr)
  {
    if (newExpr != expr)
    {
      NotificationChain msgs = null;
      if (expr != null)
        msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ASM_LINE_WITHOUT_COLON__EXPR, null, msgs);
      if (newExpr != null)
        msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ASM_LINE_WITHOUT_COLON__EXPR, null, msgs);
      msgs = basicSetExpr(newExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ASM_LINE_WITHOUT_COLON__EXPR, newExpr, newExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AsmLine> getAsmLines()
  {
    if (asmLines == null)
    {
      asmLines = new EObjectContainmentEList<AsmLine>(AsmLine.class, this, ParserPackage.ASM_LINE_WITHOUT_COLON__ASM_LINES);
    }
    return asmLines;
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
      case ParserPackage.ASM_LINE_WITHOUT_COLON__SYM:
        return basicSetSym(null, msgs);
      case ParserPackage.ASM_LINE_WITHOUT_COLON__EXPR:
        return basicSetExpr(null, msgs);
      case ParserPackage.ASM_LINE_WITHOUT_COLON__ASM_LINES:
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
      case ParserPackage.ASM_LINE_WITHOUT_COLON__SYM:
        return getSym();
      case ParserPackage.ASM_LINE_WITHOUT_COLON__EXPR:
        return getExpr();
      case ParserPackage.ASM_LINE_WITHOUT_COLON__ASM_LINES:
        return getAsmLines();
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
      case ParserPackage.ASM_LINE_WITHOUT_COLON__SYM:
        setSym((AsmSymbolicName)newValue);
        return;
      case ParserPackage.ASM_LINE_WITHOUT_COLON__EXPR:
        setExpr((Expression)newValue);
        return;
      case ParserPackage.ASM_LINE_WITHOUT_COLON__ASM_LINES:
        getAsmLines().clear();
        getAsmLines().addAll((Collection<? extends AsmLine>)newValue);
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
      case ParserPackage.ASM_LINE_WITHOUT_COLON__SYM:
        setSym((AsmSymbolicName)null);
        return;
      case ParserPackage.ASM_LINE_WITHOUT_COLON__EXPR:
        setExpr((Expression)null);
        return;
      case ParserPackage.ASM_LINE_WITHOUT_COLON__ASM_LINES:
        getAsmLines().clear();
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
      case ParserPackage.ASM_LINE_WITHOUT_COLON__SYM:
        return sym != null;
      case ParserPackage.ASM_LINE_WITHOUT_COLON__EXPR:
        return expr != null;
      case ParserPackage.ASM_LINE_WITHOUT_COLON__ASM_LINES:
        return asmLines != null && !asmLines.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AsmLineWithoutColonImpl
