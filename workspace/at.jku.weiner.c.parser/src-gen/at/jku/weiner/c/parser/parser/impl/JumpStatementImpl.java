/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.ParserPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jump Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.JumpStatementImpl#getContinue <em>Continue</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.JumpStatementImpl#getSemi <em>Semi</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.JumpStatementImpl#getBreak <em>Break</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.JumpStatementImpl#getReturn <em>Return</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.JumpStatementImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.JumpStatementImpl#getGoto <em>Goto</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JumpStatementImpl extends StatementImpl implements JumpStatement
{
  /**
   * The default value of the '{@link #getContinue() <em>Continue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContinue()
   * @generated
   * @ordered
   */
  protected static final String CONTINUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getContinue() <em>Continue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContinue()
   * @generated
   * @ordered
   */
  protected String continue_ = CONTINUE_EDEFAULT;

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
   * The default value of the '{@link #getBreak() <em>Break</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBreak()
   * @generated
   * @ordered
   */
  protected static final String BREAK_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBreak() <em>Break</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBreak()
   * @generated
   * @ordered
   */
  protected String break_ = BREAK_EDEFAULT;

  /**
   * The default value of the '{@link #getReturn() <em>Return</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturn()
   * @generated
   * @ordered
   */
  protected static final String RETURN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getReturn() <em>Return</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturn()
   * @generated
   * @ordered
   */
  protected String return_ = RETURN_EDEFAULT;

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
   * The default value of the '{@link #getGoto() <em>Goto</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGoto()
   * @generated
   * @ordered
   */
  protected static final String GOTO_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getGoto() <em>Goto</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGoto()
   * @generated
   * @ordered
   */
  protected String goto_ = GOTO_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected JumpStatementImpl()
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
    return ParserPackage.Literals.JUMP_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getContinue()
  {
    return continue_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContinue(String newContinue)
  {
    String oldContinue = continue_;
    continue_ = newContinue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.JUMP_STATEMENT__CONTINUE, oldContinue, continue_));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.JUMP_STATEMENT__SEMI, oldSemi, semi));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBreak()
  {
    return break_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBreak(String newBreak)
  {
    String oldBreak = break_;
    break_ = newBreak;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.JUMP_STATEMENT__BREAK, oldBreak, break_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getReturn()
  {
    return return_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReturn(String newReturn)
  {
    String oldReturn = return_;
    return_ = newReturn;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.JUMP_STATEMENT__RETURN, oldReturn, return_));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.JUMP_STATEMENT__EXPR, oldExpr, newExpr);
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
        msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.JUMP_STATEMENT__EXPR, null, msgs);
      if (newExpr != null)
        msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.JUMP_STATEMENT__EXPR, null, msgs);
      msgs = basicSetExpr(newExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.JUMP_STATEMENT__EXPR, newExpr, newExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getGoto()
  {
    return goto_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGoto(String newGoto)
  {
    String oldGoto = goto_;
    goto_ = newGoto;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.JUMP_STATEMENT__GOTO, oldGoto, goto_));
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
      case ParserPackage.JUMP_STATEMENT__EXPR:
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
      case ParserPackage.JUMP_STATEMENT__CONTINUE:
        return getContinue();
      case ParserPackage.JUMP_STATEMENT__SEMI:
        return getSemi();
      case ParserPackage.JUMP_STATEMENT__BREAK:
        return getBreak();
      case ParserPackage.JUMP_STATEMENT__RETURN:
        return getReturn();
      case ParserPackage.JUMP_STATEMENT__EXPR:
        return getExpr();
      case ParserPackage.JUMP_STATEMENT__GOTO:
        return getGoto();
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
      case ParserPackage.JUMP_STATEMENT__CONTINUE:
        setContinue((String)newValue);
        return;
      case ParserPackage.JUMP_STATEMENT__SEMI:
        setSemi((String)newValue);
        return;
      case ParserPackage.JUMP_STATEMENT__BREAK:
        setBreak((String)newValue);
        return;
      case ParserPackage.JUMP_STATEMENT__RETURN:
        setReturn((String)newValue);
        return;
      case ParserPackage.JUMP_STATEMENT__EXPR:
        setExpr((Expression)newValue);
        return;
      case ParserPackage.JUMP_STATEMENT__GOTO:
        setGoto((String)newValue);
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
      case ParserPackage.JUMP_STATEMENT__CONTINUE:
        setContinue(CONTINUE_EDEFAULT);
        return;
      case ParserPackage.JUMP_STATEMENT__SEMI:
        setSemi(SEMI_EDEFAULT);
        return;
      case ParserPackage.JUMP_STATEMENT__BREAK:
        setBreak(BREAK_EDEFAULT);
        return;
      case ParserPackage.JUMP_STATEMENT__RETURN:
        setReturn(RETURN_EDEFAULT);
        return;
      case ParserPackage.JUMP_STATEMENT__EXPR:
        setExpr((Expression)null);
        return;
      case ParserPackage.JUMP_STATEMENT__GOTO:
        setGoto(GOTO_EDEFAULT);
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
      case ParserPackage.JUMP_STATEMENT__CONTINUE:
        return CONTINUE_EDEFAULT == null ? continue_ != null : !CONTINUE_EDEFAULT.equals(continue_);
      case ParserPackage.JUMP_STATEMENT__SEMI:
        return SEMI_EDEFAULT == null ? semi != null : !SEMI_EDEFAULT.equals(semi);
      case ParserPackage.JUMP_STATEMENT__BREAK:
        return BREAK_EDEFAULT == null ? break_ != null : !BREAK_EDEFAULT.equals(break_);
      case ParserPackage.JUMP_STATEMENT__RETURN:
        return RETURN_EDEFAULT == null ? return_ != null : !RETURN_EDEFAULT.equals(return_);
      case ParserPackage.JUMP_STATEMENT__EXPR:
        return expr != null;
      case ParserPackage.JUMP_STATEMENT__GOTO:
        return GOTO_EDEFAULT == null ? goto_ != null : !GOTO_EDEFAULT.equals(goto_);
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
    result.append(" (continue: ");
    result.append(continue_);
    result.append(", semi: ");
    result.append(semi);
    result.append(", break: ");
    result.append(break_);
    result.append(", return: ");
    result.append(return_);
    result.append(", goto: ");
    result.append(goto_);
    result.append(')');
    return result.toString();
  }

} //JumpStatementImpl
