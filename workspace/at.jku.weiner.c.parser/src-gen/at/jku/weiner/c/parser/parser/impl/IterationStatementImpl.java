/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.IterationStatement;
import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.Statement;

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
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.IterationStatementImpl#getWhile <em>While</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.IterationStatementImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.IterationStatementImpl#getStatement <em>Statement</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.IterationStatementImpl#getDo <em>Do</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.IterationStatementImpl#getSemi <em>Semi</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.IterationStatementImpl#getFor <em>For</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.IterationStatementImpl#getInitExpr <em>Init Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.IterationStatementImpl#getIncExpr <em>Inc Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.IterationStatementImpl#getInitDecl <em>Init Decl</em>}</li>
 * </ul>
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
   * The default value of the '{@link #getFor() <em>For</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFor()
   * @generated
   * @ordered
   */
  protected static final String FOR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFor() <em>For</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFor()
   * @generated
   * @ordered
   */
  protected String for_ = FOR_EDEFAULT;

  /**
   * The cached value of the '{@link #getInitExpr() <em>Init Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitExpr()
   * @generated
   * @ordered
   */
  protected Expression initExpr;

  /**
   * The cached value of the '{@link #getIncExpr() <em>Inc Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIncExpr()
   * @generated
   * @ordered
   */
  protected Expression incExpr;

  /**
   * The cached value of the '{@link #getInitDecl() <em>Init Decl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitDecl()
   * @generated
   * @ordered
   */
  protected Declaration initDecl;

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
    return ParserPackage.Literals.ITERATION_STATEMENT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ITERATION_STATEMENT__WHILE, oldWhile, while_));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.ITERATION_STATEMENT__EXPR, oldExpr, newExpr);
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
        msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ITERATION_STATEMENT__EXPR, null, msgs);
      if (newExpr != null)
        msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ITERATION_STATEMENT__EXPR, null, msgs);
      msgs = basicSetExpr(newExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ITERATION_STATEMENT__EXPR, newExpr, newExpr));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.ITERATION_STATEMENT__STATEMENT, oldStatement, newStatement);
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
        msgs = ((InternalEObject)statement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ITERATION_STATEMENT__STATEMENT, null, msgs);
      if (newStatement != null)
        msgs = ((InternalEObject)newStatement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ITERATION_STATEMENT__STATEMENT, null, msgs);
      msgs = basicSetStatement(newStatement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ITERATION_STATEMENT__STATEMENT, newStatement, newStatement));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ITERATION_STATEMENT__DO, oldDo, do_));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ITERATION_STATEMENT__SEMI, oldSemi, semi));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFor()
  {
    return for_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFor(String newFor)
  {
    String oldFor = for_;
    for_ = newFor;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ITERATION_STATEMENT__FOR, oldFor, for_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getInitExpr()
  {
    return initExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInitExpr(Expression newInitExpr, NotificationChain msgs)
  {
    Expression oldInitExpr = initExpr;
    initExpr = newInitExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.ITERATION_STATEMENT__INIT_EXPR, oldInitExpr, newInitExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInitExpr(Expression newInitExpr)
  {
    if (newInitExpr != initExpr)
    {
      NotificationChain msgs = null;
      if (initExpr != null)
        msgs = ((InternalEObject)initExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ITERATION_STATEMENT__INIT_EXPR, null, msgs);
      if (newInitExpr != null)
        msgs = ((InternalEObject)newInitExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ITERATION_STATEMENT__INIT_EXPR, null, msgs);
      msgs = basicSetInitExpr(newInitExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ITERATION_STATEMENT__INIT_EXPR, newInitExpr, newInitExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getIncExpr()
  {
    return incExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIncExpr(Expression newIncExpr, NotificationChain msgs)
  {
    Expression oldIncExpr = incExpr;
    incExpr = newIncExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.ITERATION_STATEMENT__INC_EXPR, oldIncExpr, newIncExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIncExpr(Expression newIncExpr)
  {
    if (newIncExpr != incExpr)
    {
      NotificationChain msgs = null;
      if (incExpr != null)
        msgs = ((InternalEObject)incExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ITERATION_STATEMENT__INC_EXPR, null, msgs);
      if (newIncExpr != null)
        msgs = ((InternalEObject)newIncExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ITERATION_STATEMENT__INC_EXPR, null, msgs);
      msgs = basicSetIncExpr(newIncExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ITERATION_STATEMENT__INC_EXPR, newIncExpr, newIncExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Declaration getInitDecl()
  {
    return initDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInitDecl(Declaration newInitDecl, NotificationChain msgs)
  {
    Declaration oldInitDecl = initDecl;
    initDecl = newInitDecl;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.ITERATION_STATEMENT__INIT_DECL, oldInitDecl, newInitDecl);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInitDecl(Declaration newInitDecl)
  {
    if (newInitDecl != initDecl)
    {
      NotificationChain msgs = null;
      if (initDecl != null)
        msgs = ((InternalEObject)initDecl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ITERATION_STATEMENT__INIT_DECL, null, msgs);
      if (newInitDecl != null)
        msgs = ((InternalEObject)newInitDecl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ITERATION_STATEMENT__INIT_DECL, null, msgs);
      msgs = basicSetInitDecl(newInitDecl, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ITERATION_STATEMENT__INIT_DECL, newInitDecl, newInitDecl));
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
      case ParserPackage.ITERATION_STATEMENT__EXPR:
        return basicSetExpr(null, msgs);
      case ParserPackage.ITERATION_STATEMENT__STATEMENT:
        return basicSetStatement(null, msgs);
      case ParserPackage.ITERATION_STATEMENT__INIT_EXPR:
        return basicSetInitExpr(null, msgs);
      case ParserPackage.ITERATION_STATEMENT__INC_EXPR:
        return basicSetIncExpr(null, msgs);
      case ParserPackage.ITERATION_STATEMENT__INIT_DECL:
        return basicSetInitDecl(null, msgs);
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
      case ParserPackage.ITERATION_STATEMENT__WHILE:
        return getWhile();
      case ParserPackage.ITERATION_STATEMENT__EXPR:
        return getExpr();
      case ParserPackage.ITERATION_STATEMENT__STATEMENT:
        return getStatement();
      case ParserPackage.ITERATION_STATEMENT__DO:
        return getDo();
      case ParserPackage.ITERATION_STATEMENT__SEMI:
        return getSemi();
      case ParserPackage.ITERATION_STATEMENT__FOR:
        return getFor();
      case ParserPackage.ITERATION_STATEMENT__INIT_EXPR:
        return getInitExpr();
      case ParserPackage.ITERATION_STATEMENT__INC_EXPR:
        return getIncExpr();
      case ParserPackage.ITERATION_STATEMENT__INIT_DECL:
        return getInitDecl();
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
      case ParserPackage.ITERATION_STATEMENT__WHILE:
        setWhile((String)newValue);
        return;
      case ParserPackage.ITERATION_STATEMENT__EXPR:
        setExpr((Expression)newValue);
        return;
      case ParserPackage.ITERATION_STATEMENT__STATEMENT:
        setStatement((Statement)newValue);
        return;
      case ParserPackage.ITERATION_STATEMENT__DO:
        setDo((String)newValue);
        return;
      case ParserPackage.ITERATION_STATEMENT__SEMI:
        setSemi((String)newValue);
        return;
      case ParserPackage.ITERATION_STATEMENT__FOR:
        setFor((String)newValue);
        return;
      case ParserPackage.ITERATION_STATEMENT__INIT_EXPR:
        setInitExpr((Expression)newValue);
        return;
      case ParserPackage.ITERATION_STATEMENT__INC_EXPR:
        setIncExpr((Expression)newValue);
        return;
      case ParserPackage.ITERATION_STATEMENT__INIT_DECL:
        setInitDecl((Declaration)newValue);
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
      case ParserPackage.ITERATION_STATEMENT__WHILE:
        setWhile(WHILE_EDEFAULT);
        return;
      case ParserPackage.ITERATION_STATEMENT__EXPR:
        setExpr((Expression)null);
        return;
      case ParserPackage.ITERATION_STATEMENT__STATEMENT:
        setStatement((Statement)null);
        return;
      case ParserPackage.ITERATION_STATEMENT__DO:
        setDo(DO_EDEFAULT);
        return;
      case ParserPackage.ITERATION_STATEMENT__SEMI:
        setSemi(SEMI_EDEFAULT);
        return;
      case ParserPackage.ITERATION_STATEMENT__FOR:
        setFor(FOR_EDEFAULT);
        return;
      case ParserPackage.ITERATION_STATEMENT__INIT_EXPR:
        setInitExpr((Expression)null);
        return;
      case ParserPackage.ITERATION_STATEMENT__INC_EXPR:
        setIncExpr((Expression)null);
        return;
      case ParserPackage.ITERATION_STATEMENT__INIT_DECL:
        setInitDecl((Declaration)null);
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
      case ParserPackage.ITERATION_STATEMENT__WHILE:
        return WHILE_EDEFAULT == null ? while_ != null : !WHILE_EDEFAULT.equals(while_);
      case ParserPackage.ITERATION_STATEMENT__EXPR:
        return expr != null;
      case ParserPackage.ITERATION_STATEMENT__STATEMENT:
        return statement != null;
      case ParserPackage.ITERATION_STATEMENT__DO:
        return DO_EDEFAULT == null ? do_ != null : !DO_EDEFAULT.equals(do_);
      case ParserPackage.ITERATION_STATEMENT__SEMI:
        return SEMI_EDEFAULT == null ? semi != null : !SEMI_EDEFAULT.equals(semi);
      case ParserPackage.ITERATION_STATEMENT__FOR:
        return FOR_EDEFAULT == null ? for_ != null : !FOR_EDEFAULT.equals(for_);
      case ParserPackage.ITERATION_STATEMENT__INIT_EXPR:
        return initExpr != null;
      case ParserPackage.ITERATION_STATEMENT__INC_EXPR:
        return incExpr != null;
      case ParserPackage.ITERATION_STATEMENT__INIT_DECL:
        return initDecl != null;
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
    result.append(", for: ");
    result.append(for_);
    result.append(')');
    return result.toString();
  }

} //IterationStatementImpl
