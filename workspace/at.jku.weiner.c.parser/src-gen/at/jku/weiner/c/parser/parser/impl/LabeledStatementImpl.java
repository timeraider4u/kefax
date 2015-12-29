/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.LabeledStatement;
import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.Statement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Labeled Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.LabeledStatementImpl#getId <em>Id</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.LabeledStatementImpl#getLStmt <em>LStmt</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.LabeledStatementImpl#getCase <em>Case</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.LabeledStatementImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.LabeledStatementImpl#getDefault <em>Default</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LabeledStatementImpl extends StatementImpl implements LabeledStatement
{
  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The cached value of the '{@link #getLStmt() <em>LStmt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLStmt()
   * @generated
   * @ordered
   */
  protected Statement lStmt;

  /**
   * The default value of the '{@link #getCase() <em>Case</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCase()
   * @generated
   * @ordered
   */
  protected static final String CASE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCase() <em>Case</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCase()
   * @generated
   * @ordered
   */
  protected String case_ = CASE_EDEFAULT;

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
   * The default value of the '{@link #getDefault() <em>Default</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefault()
   * @generated
   * @ordered
   */
  protected static final String DEFAULT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDefault() <em>Default</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefault()
   * @generated
   * @ordered
   */
  protected String default_ = DEFAULT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LabeledStatementImpl()
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
    return ParserPackage.Literals.LABELED_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(String newId)
  {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.LABELED_STATEMENT__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statement getLStmt()
  {
    return lStmt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLStmt(Statement newLStmt, NotificationChain msgs)
  {
    Statement oldLStmt = lStmt;
    lStmt = newLStmt;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.LABELED_STATEMENT__LSTMT, oldLStmt, newLStmt);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLStmt(Statement newLStmt)
  {
    if (newLStmt != lStmt)
    {
      NotificationChain msgs = null;
      if (lStmt != null)
        msgs = ((InternalEObject)lStmt).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.LABELED_STATEMENT__LSTMT, null, msgs);
      if (newLStmt != null)
        msgs = ((InternalEObject)newLStmt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.LABELED_STATEMENT__LSTMT, null, msgs);
      msgs = basicSetLStmt(newLStmt, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.LABELED_STATEMENT__LSTMT, newLStmt, newLStmt));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCase()
  {
    return case_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCase(String newCase)
  {
    String oldCase = case_;
    case_ = newCase;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.LABELED_STATEMENT__CASE, oldCase, case_));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.LABELED_STATEMENT__EXPR, oldExpr, newExpr);
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
        msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.LABELED_STATEMENT__EXPR, null, msgs);
      if (newExpr != null)
        msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.LABELED_STATEMENT__EXPR, null, msgs);
      msgs = basicSetExpr(newExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.LABELED_STATEMENT__EXPR, newExpr, newExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDefault()
  {
    return default_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefault(String newDefault)
  {
    String oldDefault = default_;
    default_ = newDefault;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.LABELED_STATEMENT__DEFAULT, oldDefault, default_));
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
      case ParserPackage.LABELED_STATEMENT__LSTMT:
        return basicSetLStmt(null, msgs);
      case ParserPackage.LABELED_STATEMENT__EXPR:
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
      case ParserPackage.LABELED_STATEMENT__ID:
        return getId();
      case ParserPackage.LABELED_STATEMENT__LSTMT:
        return getLStmt();
      case ParserPackage.LABELED_STATEMENT__CASE:
        return getCase();
      case ParserPackage.LABELED_STATEMENT__EXPR:
        return getExpr();
      case ParserPackage.LABELED_STATEMENT__DEFAULT:
        return getDefault();
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
      case ParserPackage.LABELED_STATEMENT__ID:
        setId((String)newValue);
        return;
      case ParserPackage.LABELED_STATEMENT__LSTMT:
        setLStmt((Statement)newValue);
        return;
      case ParserPackage.LABELED_STATEMENT__CASE:
        setCase((String)newValue);
        return;
      case ParserPackage.LABELED_STATEMENT__EXPR:
        setExpr((Expression)newValue);
        return;
      case ParserPackage.LABELED_STATEMENT__DEFAULT:
        setDefault((String)newValue);
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
      case ParserPackage.LABELED_STATEMENT__ID:
        setId(ID_EDEFAULT);
        return;
      case ParserPackage.LABELED_STATEMENT__LSTMT:
        setLStmt((Statement)null);
        return;
      case ParserPackage.LABELED_STATEMENT__CASE:
        setCase(CASE_EDEFAULT);
        return;
      case ParserPackage.LABELED_STATEMENT__EXPR:
        setExpr((Expression)null);
        return;
      case ParserPackage.LABELED_STATEMENT__DEFAULT:
        setDefault(DEFAULT_EDEFAULT);
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
      case ParserPackage.LABELED_STATEMENT__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case ParserPackage.LABELED_STATEMENT__LSTMT:
        return lStmt != null;
      case ParserPackage.LABELED_STATEMENT__CASE:
        return CASE_EDEFAULT == null ? case_ != null : !CASE_EDEFAULT.equals(case_);
      case ParserPackage.LABELED_STATEMENT__EXPR:
        return expr != null;
      case ParserPackage.LABELED_STATEMENT__DEFAULT:
        return DEFAULT_EDEFAULT == null ? default_ != null : !DEFAULT_EDEFAULT.equals(default_);
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
    result.append(" (id: ");
    result.append(id);
    result.append(", case: ");
    result.append(case_);
    result.append(", default: ");
    result.append(default_);
    result.append(')');
    return result.toString();
  }

} //LabeledStatementImpl
