/**
 */
package at.jku.weiner.c.c.impl;

import at.jku.weiner.c.c.CPackage;
import at.jku.weiner.c.c.LabeledStatement;
import at.jku.weiner.c.c.Statement;

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
 *   <li>{@link at.jku.weiner.c.c.impl.LabeledStatementImpl#getId <em>Id</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.LabeledStatementImpl#getLStmt <em>LStmt</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.LabeledStatementImpl#getDefault <em>Default</em>}</li>
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
    return CPackage.Literals.LABELED_STATEMENT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.LABELED_STATEMENT__ID, oldId, id));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CPackage.LABELED_STATEMENT__LSTMT, oldLStmt, newLStmt);
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
        msgs = ((InternalEObject)lStmt).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CPackage.LABELED_STATEMENT__LSTMT, null, msgs);
      if (newLStmt != null)
        msgs = ((InternalEObject)newLStmt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CPackage.LABELED_STATEMENT__LSTMT, null, msgs);
      msgs = basicSetLStmt(newLStmt, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.LABELED_STATEMENT__LSTMT, newLStmt, newLStmt));
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
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.LABELED_STATEMENT__DEFAULT, oldDefault, default_));
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
      case CPackage.LABELED_STATEMENT__LSTMT:
        return basicSetLStmt(null, msgs);
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
      case CPackage.LABELED_STATEMENT__ID:
        return getId();
      case CPackage.LABELED_STATEMENT__LSTMT:
        return getLStmt();
      case CPackage.LABELED_STATEMENT__DEFAULT:
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
      case CPackage.LABELED_STATEMENT__ID:
        setId((String)newValue);
        return;
      case CPackage.LABELED_STATEMENT__LSTMT:
        setLStmt((Statement)newValue);
        return;
      case CPackage.LABELED_STATEMENT__DEFAULT:
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
      case CPackage.LABELED_STATEMENT__ID:
        setId(ID_EDEFAULT);
        return;
      case CPackage.LABELED_STATEMENT__LSTMT:
        setLStmt((Statement)null);
        return;
      case CPackage.LABELED_STATEMENT__DEFAULT:
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
      case CPackage.LABELED_STATEMENT__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case CPackage.LABELED_STATEMENT__LSTMT:
        return lStmt != null;
      case CPackage.LABELED_STATEMENT__DEFAULT:
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
    result.append(", default: ");
    result.append(default_);
    result.append(')');
    return result.toString();
  }

} //LabeledStatementImpl
