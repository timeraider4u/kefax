/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.SelectionStatement;
import at.jku.weiner.c.parser.parser.Statement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Selection Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.SelectionStatementImpl#getIf <em>If</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.SelectionStatementImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.SelectionStatementImpl#getIfStatement <em>If Statement</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.SelectionStatementImpl#getElse <em>Else</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.SelectionStatementImpl#getElseStatement <em>Else Statement</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.SelectionStatementImpl#getSwitch <em>Switch</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.SelectionStatementImpl#getSwitchStatement <em>Switch Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SelectionStatementImpl extends StatementImpl implements SelectionStatement
{
  /**
   * The default value of the '{@link #getIf() <em>If</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIf()
   * @generated
   * @ordered
   */
  protected static final String IF_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getIf() <em>If</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIf()
   * @generated
   * @ordered
   */
  protected String if_ = IF_EDEFAULT;

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
   * The cached value of the '{@link #getIfStatement() <em>If Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIfStatement()
   * @generated
   * @ordered
   */
  protected Statement ifStatement;

  /**
   * The default value of the '{@link #getElse() <em>Else</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElse()
   * @generated
   * @ordered
   */
  protected static final String ELSE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getElse() <em>Else</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElse()
   * @generated
   * @ordered
   */
  protected String else_ = ELSE_EDEFAULT;

  /**
   * The cached value of the '{@link #getElseStatement() <em>Else Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseStatement()
   * @generated
   * @ordered
   */
  protected Statement elseStatement;

  /**
   * The default value of the '{@link #getSwitch() <em>Switch</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSwitch()
   * @generated
   * @ordered
   */
  protected static final String SWITCH_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSwitch() <em>Switch</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSwitch()
   * @generated
   * @ordered
   */
  protected String switch_ = SWITCH_EDEFAULT;

  /**
   * The cached value of the '{@link #getSwitchStatement() <em>Switch Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSwitchStatement()
   * @generated
   * @ordered
   */
  protected Statement switchStatement;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SelectionStatementImpl()
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
    return ParserPackage.Literals.SELECTION_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getIf()
  {
    return if_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIf(String newIf)
  {
    String oldIf = if_;
    if_ = newIf;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.SELECTION_STATEMENT__IF, oldIf, if_));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.SELECTION_STATEMENT__EXPR, oldExpr, newExpr);
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
        msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.SELECTION_STATEMENT__EXPR, null, msgs);
      if (newExpr != null)
        msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.SELECTION_STATEMENT__EXPR, null, msgs);
      msgs = basicSetExpr(newExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.SELECTION_STATEMENT__EXPR, newExpr, newExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statement getIfStatement()
  {
    return ifStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIfStatement(Statement newIfStatement, NotificationChain msgs)
  {
    Statement oldIfStatement = ifStatement;
    ifStatement = newIfStatement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.SELECTION_STATEMENT__IF_STATEMENT, oldIfStatement, newIfStatement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIfStatement(Statement newIfStatement)
  {
    if (newIfStatement != ifStatement)
    {
      NotificationChain msgs = null;
      if (ifStatement != null)
        msgs = ((InternalEObject)ifStatement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.SELECTION_STATEMENT__IF_STATEMENT, null, msgs);
      if (newIfStatement != null)
        msgs = ((InternalEObject)newIfStatement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.SELECTION_STATEMENT__IF_STATEMENT, null, msgs);
      msgs = basicSetIfStatement(newIfStatement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.SELECTION_STATEMENT__IF_STATEMENT, newIfStatement, newIfStatement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getElse()
  {
    return else_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElse(String newElse)
  {
    String oldElse = else_;
    else_ = newElse;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.SELECTION_STATEMENT__ELSE, oldElse, else_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statement getElseStatement()
  {
    return elseStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElseStatement(Statement newElseStatement, NotificationChain msgs)
  {
    Statement oldElseStatement = elseStatement;
    elseStatement = newElseStatement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.SELECTION_STATEMENT__ELSE_STATEMENT, oldElseStatement, newElseStatement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElseStatement(Statement newElseStatement)
  {
    if (newElseStatement != elseStatement)
    {
      NotificationChain msgs = null;
      if (elseStatement != null)
        msgs = ((InternalEObject)elseStatement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.SELECTION_STATEMENT__ELSE_STATEMENT, null, msgs);
      if (newElseStatement != null)
        msgs = ((InternalEObject)newElseStatement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.SELECTION_STATEMENT__ELSE_STATEMENT, null, msgs);
      msgs = basicSetElseStatement(newElseStatement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.SELECTION_STATEMENT__ELSE_STATEMENT, newElseStatement, newElseStatement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSwitch()
  {
    return switch_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSwitch(String newSwitch)
  {
    String oldSwitch = switch_;
    switch_ = newSwitch;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.SELECTION_STATEMENT__SWITCH, oldSwitch, switch_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statement getSwitchStatement()
  {
    return switchStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSwitchStatement(Statement newSwitchStatement, NotificationChain msgs)
  {
    Statement oldSwitchStatement = switchStatement;
    switchStatement = newSwitchStatement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.SELECTION_STATEMENT__SWITCH_STATEMENT, oldSwitchStatement, newSwitchStatement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSwitchStatement(Statement newSwitchStatement)
  {
    if (newSwitchStatement != switchStatement)
    {
      NotificationChain msgs = null;
      if (switchStatement != null)
        msgs = ((InternalEObject)switchStatement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.SELECTION_STATEMENT__SWITCH_STATEMENT, null, msgs);
      if (newSwitchStatement != null)
        msgs = ((InternalEObject)newSwitchStatement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.SELECTION_STATEMENT__SWITCH_STATEMENT, null, msgs);
      msgs = basicSetSwitchStatement(newSwitchStatement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.SELECTION_STATEMENT__SWITCH_STATEMENT, newSwitchStatement, newSwitchStatement));
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
      case ParserPackage.SELECTION_STATEMENT__EXPR:
        return basicSetExpr(null, msgs);
      case ParserPackage.SELECTION_STATEMENT__IF_STATEMENT:
        return basicSetIfStatement(null, msgs);
      case ParserPackage.SELECTION_STATEMENT__ELSE_STATEMENT:
        return basicSetElseStatement(null, msgs);
      case ParserPackage.SELECTION_STATEMENT__SWITCH_STATEMENT:
        return basicSetSwitchStatement(null, msgs);
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
      case ParserPackage.SELECTION_STATEMENT__IF:
        return getIf();
      case ParserPackage.SELECTION_STATEMENT__EXPR:
        return getExpr();
      case ParserPackage.SELECTION_STATEMENT__IF_STATEMENT:
        return getIfStatement();
      case ParserPackage.SELECTION_STATEMENT__ELSE:
        return getElse();
      case ParserPackage.SELECTION_STATEMENT__ELSE_STATEMENT:
        return getElseStatement();
      case ParserPackage.SELECTION_STATEMENT__SWITCH:
        return getSwitch();
      case ParserPackage.SELECTION_STATEMENT__SWITCH_STATEMENT:
        return getSwitchStatement();
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
      case ParserPackage.SELECTION_STATEMENT__IF:
        setIf((String)newValue);
        return;
      case ParserPackage.SELECTION_STATEMENT__EXPR:
        setExpr((Expression)newValue);
        return;
      case ParserPackage.SELECTION_STATEMENT__IF_STATEMENT:
        setIfStatement((Statement)newValue);
        return;
      case ParserPackage.SELECTION_STATEMENT__ELSE:
        setElse((String)newValue);
        return;
      case ParserPackage.SELECTION_STATEMENT__ELSE_STATEMENT:
        setElseStatement((Statement)newValue);
        return;
      case ParserPackage.SELECTION_STATEMENT__SWITCH:
        setSwitch((String)newValue);
        return;
      case ParserPackage.SELECTION_STATEMENT__SWITCH_STATEMENT:
        setSwitchStatement((Statement)newValue);
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
      case ParserPackage.SELECTION_STATEMENT__IF:
        setIf(IF_EDEFAULT);
        return;
      case ParserPackage.SELECTION_STATEMENT__EXPR:
        setExpr((Expression)null);
        return;
      case ParserPackage.SELECTION_STATEMENT__IF_STATEMENT:
        setIfStatement((Statement)null);
        return;
      case ParserPackage.SELECTION_STATEMENT__ELSE:
        setElse(ELSE_EDEFAULT);
        return;
      case ParserPackage.SELECTION_STATEMENT__ELSE_STATEMENT:
        setElseStatement((Statement)null);
        return;
      case ParserPackage.SELECTION_STATEMENT__SWITCH:
        setSwitch(SWITCH_EDEFAULT);
        return;
      case ParserPackage.SELECTION_STATEMENT__SWITCH_STATEMENT:
        setSwitchStatement((Statement)null);
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
      case ParserPackage.SELECTION_STATEMENT__IF:
        return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
      case ParserPackage.SELECTION_STATEMENT__EXPR:
        return expr != null;
      case ParserPackage.SELECTION_STATEMENT__IF_STATEMENT:
        return ifStatement != null;
      case ParserPackage.SELECTION_STATEMENT__ELSE:
        return ELSE_EDEFAULT == null ? else_ != null : !ELSE_EDEFAULT.equals(else_);
      case ParserPackage.SELECTION_STATEMENT__ELSE_STATEMENT:
        return elseStatement != null;
      case ParserPackage.SELECTION_STATEMENT__SWITCH:
        return SWITCH_EDEFAULT == null ? switch_ != null : !SWITCH_EDEFAULT.equals(switch_);
      case ParserPackage.SELECTION_STATEMENT__SWITCH_STATEMENT:
        return switchStatement != null;
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
    result.append(" (if: ");
    result.append(if_);
    result.append(", else: ");
    result.append(else_);
    result.append(", switch: ");
    result.append(switch_);
    result.append(')');
    return result.toString();
  }

} //SelectionStatementImpl
