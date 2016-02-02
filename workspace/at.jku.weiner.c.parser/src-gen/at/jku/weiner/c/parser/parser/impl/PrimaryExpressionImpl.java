/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.common.common.Constant2;

import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.PrimaryExpression;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.TypeName;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primary Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl#getId <em>Id</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl#getConst <em>Const</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl#getString <em>String</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl#isExt <em>Ext</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl#getCompoundStmt <em>Compound Stmt</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl#isBuiltin_offsetof <em>Builtin offsetof</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl#isBuiltin_typescompatiblep <em>Builtin typescompatiblep</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl#getTypeName2 <em>Type Name2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimaryExpressionImpl extends ExpressionImpl implements PrimaryExpression
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
   * The cached value of the '{@link #getConst() <em>Const</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConst()
   * @generated
   * @ordered
   */
  protected Constant2 const_;

  /**
   * The cached value of the '{@link #getString() <em>String</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getString()
   * @generated
   * @ordered
   */
  protected EList<String> string;

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
   * The default value of the '{@link #isExt() <em>Ext</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExt()
   * @generated
   * @ordered
   */
  protected static final boolean EXT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isExt() <em>Ext</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExt()
   * @generated
   * @ordered
   */
  protected boolean ext = EXT_EDEFAULT;

  /**
   * The cached value of the '{@link #getCompoundStmt() <em>Compound Stmt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCompoundStmt()
   * @generated
   * @ordered
   */
  protected Statement compoundStmt;

  /**
   * The default value of the '{@link #isBuiltin_offsetof() <em>Builtin offsetof</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isBuiltin_offsetof()
   * @generated
   * @ordered
   */
  protected static final boolean BUILTIN_OFFSETOF_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isBuiltin_offsetof() <em>Builtin offsetof</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isBuiltin_offsetof()
   * @generated
   * @ordered
   */
  protected boolean builtin_offsetof = BUILTIN_OFFSETOF_EDEFAULT;

  /**
   * The cached value of the '{@link #getTypeName() <em>Type Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeName()
   * @generated
   * @ordered
   */
  protected TypeName typeName;

  /**
   * The default value of the '{@link #isBuiltin_typescompatiblep() <em>Builtin typescompatiblep</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isBuiltin_typescompatiblep()
   * @generated
   * @ordered
   */
  protected static final boolean BUILTIN_TYPESCOMPATIBLEP_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isBuiltin_typescompatiblep() <em>Builtin typescompatiblep</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isBuiltin_typescompatiblep()
   * @generated
   * @ordered
   */
  protected boolean builtin_typescompatiblep = BUILTIN_TYPESCOMPATIBLEP_EDEFAULT;

  /**
   * The cached value of the '{@link #getTypeName2() <em>Type Name2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeName2()
   * @generated
   * @ordered
   */
  protected TypeName typeName2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PrimaryExpressionImpl()
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
    return ParserPackage.Literals.PRIMARY_EXPRESSION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.PRIMARY_EXPRESSION__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Constant2 getConst()
  {
    return const_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConst(Constant2 newConst, NotificationChain msgs)
  {
    Constant2 oldConst = const_;
    const_ = newConst;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.PRIMARY_EXPRESSION__CONST, oldConst, newConst);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConst(Constant2 newConst)
  {
    if (newConst != const_)
    {
      NotificationChain msgs = null;
      if (const_ != null)
        msgs = ((InternalEObject)const_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.PRIMARY_EXPRESSION__CONST, null, msgs);
      if (newConst != null)
        msgs = ((InternalEObject)newConst).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.PRIMARY_EXPRESSION__CONST, null, msgs);
      msgs = basicSetConst(newConst, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.PRIMARY_EXPRESSION__CONST, newConst, newConst));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getString()
  {
    if (string == null)
    {
      string = new EDataTypeEList<String>(String.class, this, ParserPackage.PRIMARY_EXPRESSION__STRING);
    }
    return string;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.PRIMARY_EXPRESSION__EXPR, oldExpr, newExpr);
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
        msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.PRIMARY_EXPRESSION__EXPR, null, msgs);
      if (newExpr != null)
        msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.PRIMARY_EXPRESSION__EXPR, null, msgs);
      msgs = basicSetExpr(newExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.PRIMARY_EXPRESSION__EXPR, newExpr, newExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isExt()
  {
    return ext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExt(boolean newExt)
  {
    boolean oldExt = ext;
    ext = newExt;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.PRIMARY_EXPRESSION__EXT, oldExt, ext));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statement getCompoundStmt()
  {
    return compoundStmt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCompoundStmt(Statement newCompoundStmt, NotificationChain msgs)
  {
    Statement oldCompoundStmt = compoundStmt;
    compoundStmt = newCompoundStmt;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.PRIMARY_EXPRESSION__COMPOUND_STMT, oldCompoundStmt, newCompoundStmt);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCompoundStmt(Statement newCompoundStmt)
  {
    if (newCompoundStmt != compoundStmt)
    {
      NotificationChain msgs = null;
      if (compoundStmt != null)
        msgs = ((InternalEObject)compoundStmt).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.PRIMARY_EXPRESSION__COMPOUND_STMT, null, msgs);
      if (newCompoundStmt != null)
        msgs = ((InternalEObject)newCompoundStmt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.PRIMARY_EXPRESSION__COMPOUND_STMT, null, msgs);
      msgs = basicSetCompoundStmt(newCompoundStmt, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.PRIMARY_EXPRESSION__COMPOUND_STMT, newCompoundStmt, newCompoundStmt));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isBuiltin_offsetof()
  {
    return builtin_offsetof;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBuiltin_offsetof(boolean newBuiltin_offsetof)
  {
    boolean oldBuiltin_offsetof = builtin_offsetof;
    builtin_offsetof = newBuiltin_offsetof;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.PRIMARY_EXPRESSION__BUILTIN_OFFSETOF, oldBuiltin_offsetof, builtin_offsetof));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeName getTypeName()
  {
    return typeName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypeName(TypeName newTypeName, NotificationChain msgs)
  {
    TypeName oldTypeName = typeName;
    typeName = newTypeName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.PRIMARY_EXPRESSION__TYPE_NAME, oldTypeName, newTypeName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeName(TypeName newTypeName)
  {
    if (newTypeName != typeName)
    {
      NotificationChain msgs = null;
      if (typeName != null)
        msgs = ((InternalEObject)typeName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.PRIMARY_EXPRESSION__TYPE_NAME, null, msgs);
      if (newTypeName != null)
        msgs = ((InternalEObject)newTypeName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.PRIMARY_EXPRESSION__TYPE_NAME, null, msgs);
      msgs = basicSetTypeName(newTypeName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.PRIMARY_EXPRESSION__TYPE_NAME, newTypeName, newTypeName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isBuiltin_typescompatiblep()
  {
    return builtin_typescompatiblep;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBuiltin_typescompatiblep(boolean newBuiltin_typescompatiblep)
  {
    boolean oldBuiltin_typescompatiblep = builtin_typescompatiblep;
    builtin_typescompatiblep = newBuiltin_typescompatiblep;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.PRIMARY_EXPRESSION__BUILTIN_TYPESCOMPATIBLEP, oldBuiltin_typescompatiblep, builtin_typescompatiblep));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeName getTypeName2()
  {
    return typeName2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypeName2(TypeName newTypeName2, NotificationChain msgs)
  {
    TypeName oldTypeName2 = typeName2;
    typeName2 = newTypeName2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.PRIMARY_EXPRESSION__TYPE_NAME2, oldTypeName2, newTypeName2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeName2(TypeName newTypeName2)
  {
    if (newTypeName2 != typeName2)
    {
      NotificationChain msgs = null;
      if (typeName2 != null)
        msgs = ((InternalEObject)typeName2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.PRIMARY_EXPRESSION__TYPE_NAME2, null, msgs);
      if (newTypeName2 != null)
        msgs = ((InternalEObject)newTypeName2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.PRIMARY_EXPRESSION__TYPE_NAME2, null, msgs);
      msgs = basicSetTypeName2(newTypeName2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.PRIMARY_EXPRESSION__TYPE_NAME2, newTypeName2, newTypeName2));
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
      case ParserPackage.PRIMARY_EXPRESSION__CONST:
        return basicSetConst(null, msgs);
      case ParserPackage.PRIMARY_EXPRESSION__EXPR:
        return basicSetExpr(null, msgs);
      case ParserPackage.PRIMARY_EXPRESSION__COMPOUND_STMT:
        return basicSetCompoundStmt(null, msgs);
      case ParserPackage.PRIMARY_EXPRESSION__TYPE_NAME:
        return basicSetTypeName(null, msgs);
      case ParserPackage.PRIMARY_EXPRESSION__TYPE_NAME2:
        return basicSetTypeName2(null, msgs);
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
      case ParserPackage.PRIMARY_EXPRESSION__ID:
        return getId();
      case ParserPackage.PRIMARY_EXPRESSION__CONST:
        return getConst();
      case ParserPackage.PRIMARY_EXPRESSION__STRING:
        return getString();
      case ParserPackage.PRIMARY_EXPRESSION__EXPR:
        return getExpr();
      case ParserPackage.PRIMARY_EXPRESSION__EXT:
        return isExt();
      case ParserPackage.PRIMARY_EXPRESSION__COMPOUND_STMT:
        return getCompoundStmt();
      case ParserPackage.PRIMARY_EXPRESSION__BUILTIN_OFFSETOF:
        return isBuiltin_offsetof();
      case ParserPackage.PRIMARY_EXPRESSION__TYPE_NAME:
        return getTypeName();
      case ParserPackage.PRIMARY_EXPRESSION__BUILTIN_TYPESCOMPATIBLEP:
        return isBuiltin_typescompatiblep();
      case ParserPackage.PRIMARY_EXPRESSION__TYPE_NAME2:
        return getTypeName2();
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
      case ParserPackage.PRIMARY_EXPRESSION__ID:
        setId((String)newValue);
        return;
      case ParserPackage.PRIMARY_EXPRESSION__CONST:
        setConst((Constant2)newValue);
        return;
      case ParserPackage.PRIMARY_EXPRESSION__STRING:
        getString().clear();
        getString().addAll((Collection<? extends String>)newValue);
        return;
      case ParserPackage.PRIMARY_EXPRESSION__EXPR:
        setExpr((Expression)newValue);
        return;
      case ParserPackage.PRIMARY_EXPRESSION__EXT:
        setExt((Boolean)newValue);
        return;
      case ParserPackage.PRIMARY_EXPRESSION__COMPOUND_STMT:
        setCompoundStmt((Statement)newValue);
        return;
      case ParserPackage.PRIMARY_EXPRESSION__BUILTIN_OFFSETOF:
        setBuiltin_offsetof((Boolean)newValue);
        return;
      case ParserPackage.PRIMARY_EXPRESSION__TYPE_NAME:
        setTypeName((TypeName)newValue);
        return;
      case ParserPackage.PRIMARY_EXPRESSION__BUILTIN_TYPESCOMPATIBLEP:
        setBuiltin_typescompatiblep((Boolean)newValue);
        return;
      case ParserPackage.PRIMARY_EXPRESSION__TYPE_NAME2:
        setTypeName2((TypeName)newValue);
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
      case ParserPackage.PRIMARY_EXPRESSION__ID:
        setId(ID_EDEFAULT);
        return;
      case ParserPackage.PRIMARY_EXPRESSION__CONST:
        setConst((Constant2)null);
        return;
      case ParserPackage.PRIMARY_EXPRESSION__STRING:
        getString().clear();
        return;
      case ParserPackage.PRIMARY_EXPRESSION__EXPR:
        setExpr((Expression)null);
        return;
      case ParserPackage.PRIMARY_EXPRESSION__EXT:
        setExt(EXT_EDEFAULT);
        return;
      case ParserPackage.PRIMARY_EXPRESSION__COMPOUND_STMT:
        setCompoundStmt((Statement)null);
        return;
      case ParserPackage.PRIMARY_EXPRESSION__BUILTIN_OFFSETOF:
        setBuiltin_offsetof(BUILTIN_OFFSETOF_EDEFAULT);
        return;
      case ParserPackage.PRIMARY_EXPRESSION__TYPE_NAME:
        setTypeName((TypeName)null);
        return;
      case ParserPackage.PRIMARY_EXPRESSION__BUILTIN_TYPESCOMPATIBLEP:
        setBuiltin_typescompatiblep(BUILTIN_TYPESCOMPATIBLEP_EDEFAULT);
        return;
      case ParserPackage.PRIMARY_EXPRESSION__TYPE_NAME2:
        setTypeName2((TypeName)null);
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
      case ParserPackage.PRIMARY_EXPRESSION__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case ParserPackage.PRIMARY_EXPRESSION__CONST:
        return const_ != null;
      case ParserPackage.PRIMARY_EXPRESSION__STRING:
        return string != null && !string.isEmpty();
      case ParserPackage.PRIMARY_EXPRESSION__EXPR:
        return expr != null;
      case ParserPackage.PRIMARY_EXPRESSION__EXT:
        return ext != EXT_EDEFAULT;
      case ParserPackage.PRIMARY_EXPRESSION__COMPOUND_STMT:
        return compoundStmt != null;
      case ParserPackage.PRIMARY_EXPRESSION__BUILTIN_OFFSETOF:
        return builtin_offsetof != BUILTIN_OFFSETOF_EDEFAULT;
      case ParserPackage.PRIMARY_EXPRESSION__TYPE_NAME:
        return typeName != null;
      case ParserPackage.PRIMARY_EXPRESSION__BUILTIN_TYPESCOMPATIBLEP:
        return builtin_typescompatiblep != BUILTIN_TYPESCOMPATIBLEP_EDEFAULT;
      case ParserPackage.PRIMARY_EXPRESSION__TYPE_NAME2:
        return typeName2 != null;
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
    result.append(", string: ");
    result.append(string);
    result.append(", ext: ");
    result.append(ext);
    result.append(", builtin_offsetof: ");
    result.append(builtin_offsetof);
    result.append(", builtin_typescompatiblep: ");
    result.append(builtin_typescompatiblep);
    result.append(')');
    return result.toString();
  }

} //PrimaryExpressionImpl
