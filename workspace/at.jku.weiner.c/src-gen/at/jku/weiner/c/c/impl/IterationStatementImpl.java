/**
 */
package at.jku.weiner.c.c.impl;

import at.jku.weiner.c.c.CPackage;
import at.jku.weiner.c.c.Expression;
import at.jku.weiner.c.c.IterationStatement;
import at.jku.weiner.c.c.Statement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iteration Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.impl.IterationStatementImpl#getWhile <em>While</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.IterationStatementImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.IterationStatementImpl#getStatement <em>Statement</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.IterationStatementImpl#getDo <em>Do</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.IterationStatementImpl#getSemi <em>Semi</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IterationStatementImpl extends StatementImpl implements IterationStatement
{
  /**
   * The default value of the '{@link #getWhile() <em>While</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWhile()
   * @generated
   * @ordered
   */
  protected static final String WHILE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getWhile() <em>While</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWhile()
   * @generated
   * @ordered
   */
  protected String while_ = WHILE_EDEFAULT;

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
   * The cached value of the '{@link #getStatement() <em>Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatement()
   * @generated
   * @ordered
   */
  protected Statement statement;

  /**
   * The default value of the '{@link #getDo() <em>Do</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDo()
   * @generated
   * @ordered
   */
  protected static final String DO_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDo() <em>Do</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDo()
   * @generated
   * @ordered
   */
  protected String do_ = DO_EDEFAULT;

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
  protected IterationStatementImpl()
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
    return CPackage.Literals.ITERATION_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getWhile()
  {
    return while_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWhile(String newWhile)
  {
    String oldWhile = while_;
    while_ = newWhile;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.ITERATION_STATEMENT__WHILE, oldWhile, while_));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CPackage.ITERATION_STATEMENT__EXPR, oldExpr, newExpr);
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
        msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CPackage.ITERATION_STATEMENT__EXPR, null, msgs);
      if (newExpr != null)
        msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CPackage.ITERATION_STATEMENT__EXPR, null, msgs);
      msgs = basicSetExpr(newExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.ITERATION_STATEMENT__EXPR, newExpr, newExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statement getStatement()
  {
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStatement(Statement newStatement, NotificationChain msgs)
  {
    Statement oldStatement = statement;
    statement = newStatement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CPackage.ITERATION_STATEMENT__STATEMENT, oldStatement, newStatement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStatement(Statement newStatement)
  {
    if (newStatement != statement)
    {
      NotificationChain msgs = null;
      if (statement != null)
        msgs = ((InternalEObject)statement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CPackage.ITERATION_STATEMENT__STATEMENT, null, msgs);
      if (newStatement != null)
        msgs = ((InternalEObject)newStatement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CPackage.ITERATION_STATEMENT__STATEMENT, null, msgs);
      msgs = basicSetStatement(newStatement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.ITERATION_STATEMENT__STATEMENT, newStatement, newStatement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDo()
  {
    return do_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDo(String newDo)
  {
    String oldDo = do_;
    do_ = newDo;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.ITERATION_STATEMENT__DO, oldDo, do_));
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
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.ITERATION_STATEMENT__SEMI, oldSemi, semi));
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
      case CPackage.ITERATION_STATEMENT__EXPR:
        return basicSetExpr(null, msgs);
      case CPackage.ITERATION_STATEMENT__STATEMENT:
        return basicSetStatement(null, msgs);
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
      case CPackage.ITERATION_STATEMENT__WHILE:
        return getWhile();
      case CPackage.ITERATION_STATEMENT__EXPR:
        return getExpr();
      case CPackage.ITERATION_STATEMENT__STATEMENT:
        return getStatement();
      case CPackage.ITERATION_STATEMENT__DO:
        return getDo();
      case CPackage.ITERATION_STATEMENT__SEMI:
        return getSemi();
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
      case CPackage.ITERATION_STATEMENT__WHILE:
        setWhile((String)newValue);
        return;
      case CPackage.ITERATION_STATEMENT__EXPR:
        setExpr((Expression)newValue);
        return;
      case CPackage.ITERATION_STATEMENT__STATEMENT:
        setStatement((Statement)newValue);
        return;
      case CPackage.ITERATION_STATEMENT__DO:
        setDo((String)newValue);
        return;
      case CPackage.ITERATION_STATEMENT__SEMI:
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
      case CPackage.ITERATION_STATEMENT__WHILE:
        setWhile(WHILE_EDEFAULT);
        return;
      case CPackage.ITERATION_STATEMENT__EXPR:
        setExpr((Expression)null);
        return;
      case CPackage.ITERATION_STATEMENT__STATEMENT:
        setStatement((Statement)null);
        return;
      case CPackage.ITERATION_STATEMENT__DO:
        setDo(DO_EDEFAULT);
        return;
      case CPackage.ITERATION_STATEMENT__SEMI:
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
      case CPackage.ITERATION_STATEMENT__WHILE:
        return WHILE_EDEFAULT == null ? while_ != null : !WHILE_EDEFAULT.equals(while_);
      case CPackage.ITERATION_STATEMENT__EXPR:
        return expr != null;
      case CPackage.ITERATION_STATEMENT__STATEMENT:
        return statement != null;
      case CPackage.ITERATION_STATEMENT__DO:
        return DO_EDEFAULT == null ? do_ != null : !DO_EDEFAULT.equals(do_);
      case CPackage.ITERATION_STATEMENT__SEMI:
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
    result.append(" (while: ");
    result.append(while_);
    result.append(", do: ");
    result.append(do_);
    result.append(", semi: ");
    result.append(semi);
    result.append(')');
    return result.toString();
  }

} //IterationStatementImpl
