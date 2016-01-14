/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.AsmLine;
import at.jku.weiner.c.parser.parser.AsmSymbolicName;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.ParserPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Asm Line</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AsmLineImpl#getSym <em>Sym</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AsmLineImpl#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AsmLineImpl extends MinimalEObjectImpl.Container implements AsmLine
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AsmLineImpl()
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
    return ParserPackage.Literals.ASM_LINE;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.ASM_LINE__SYM, oldSym, newSym);
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
        msgs = ((InternalEObject)sym).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ASM_LINE__SYM, null, msgs);
      if (newSym != null)
        msgs = ((InternalEObject)newSym).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ASM_LINE__SYM, null, msgs);
      msgs = basicSetSym(newSym, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ASM_LINE__SYM, newSym, newSym));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.ASM_LINE__EXPR, oldExpr, newExpr);
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
        msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ASM_LINE__EXPR, null, msgs);
      if (newExpr != null)
        msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ASM_LINE__EXPR, null, msgs);
      msgs = basicSetExpr(newExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ASM_LINE__EXPR, newExpr, newExpr));
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
      case ParserPackage.ASM_LINE__SYM:
        return basicSetSym(null, msgs);
      case ParserPackage.ASM_LINE__EXPR:
        return basicSetExpr(null, msgs);
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
      case ParserPackage.ASM_LINE__SYM:
        return getSym();
      case ParserPackage.ASM_LINE__EXPR:
        return getExpr();
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
      case ParserPackage.ASM_LINE__SYM:
        setSym((AsmSymbolicName)newValue);
        return;
      case ParserPackage.ASM_LINE__EXPR:
        setExpr((Expression)newValue);
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
      case ParserPackage.ASM_LINE__SYM:
        setSym((AsmSymbolicName)null);
        return;
      case ParserPackage.ASM_LINE__EXPR:
        setExpr((Expression)null);
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
      case ParserPackage.ASM_LINE__SYM:
        return sym != null;
      case ParserPackage.ASM_LINE__EXPR:
        return expr != null;
    }
    return super.eIsSet(featureID);
  }

} //AsmLineImpl
