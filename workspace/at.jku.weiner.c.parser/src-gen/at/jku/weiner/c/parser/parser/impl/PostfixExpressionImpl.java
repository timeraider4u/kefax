/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.InitializerList;
import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.PostfixExpression;
import at.jku.weiner.c.parser.parser.PostfixExpressionSuffix;
import at.jku.weiner.c.parser.parser.TypeName;

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
 * An implementation of the model object '<em><b>Postfix Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionImpl#isExt <em>Ext</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionImpl#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionImpl#getInitializerList <em>Initializer List</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionImpl#isComma <em>Comma</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionImpl#getSuffix <em>Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PostfixExpressionImpl extends ExpressionImpl implements PostfixExpression
{
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
   * The cached value of the '{@link #getTypeName() <em>Type Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeName()
   * @generated
   * @ordered
   */
  protected TypeName typeName;

  /**
   * The cached value of the '{@link #getInitializerList() <em>Initializer List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitializerList()
   * @generated
   * @ordered
   */
  protected InitializerList initializerList;

  /**
   * The default value of the '{@link #isComma() <em>Comma</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isComma()
   * @generated
   * @ordered
   */
  protected static final boolean COMMA_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isComma() <em>Comma</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isComma()
   * @generated
   * @ordered
   */
  protected boolean comma = COMMA_EDEFAULT;

  /**
   * The cached value of the '{@link #getExpr() <em>Expr</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpr()
   * @generated
   * @ordered
   */
  protected EList<Expression> expr;

  /**
   * The cached value of the '{@link #getSuffix() <em>Suffix</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuffix()
   * @generated
   * @ordered
   */
  protected EList<PostfixExpressionSuffix> suffix;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PostfixExpressionImpl()
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
    return ParserPackage.Literals.POSTFIX_EXPRESSION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.POSTFIX_EXPRESSION__EXT, oldExt, ext));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.POSTFIX_EXPRESSION__TYPE_NAME, oldTypeName, newTypeName);
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
        msgs = ((InternalEObject)typeName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.POSTFIX_EXPRESSION__TYPE_NAME, null, msgs);
      if (newTypeName != null)
        msgs = ((InternalEObject)newTypeName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.POSTFIX_EXPRESSION__TYPE_NAME, null, msgs);
      msgs = basicSetTypeName(newTypeName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.POSTFIX_EXPRESSION__TYPE_NAME, newTypeName, newTypeName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InitializerList getInitializerList()
  {
    return initializerList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInitializerList(InitializerList newInitializerList, NotificationChain msgs)
  {
    InitializerList oldInitializerList = initializerList;
    initializerList = newInitializerList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.POSTFIX_EXPRESSION__INITIALIZER_LIST, oldInitializerList, newInitializerList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInitializerList(InitializerList newInitializerList)
  {
    if (newInitializerList != initializerList)
    {
      NotificationChain msgs = null;
      if (initializerList != null)
        msgs = ((InternalEObject)initializerList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.POSTFIX_EXPRESSION__INITIALIZER_LIST, null, msgs);
      if (newInitializerList != null)
        msgs = ((InternalEObject)newInitializerList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.POSTFIX_EXPRESSION__INITIALIZER_LIST, null, msgs);
      msgs = basicSetInitializerList(newInitializerList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.POSTFIX_EXPRESSION__INITIALIZER_LIST, newInitializerList, newInitializerList));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isComma()
  {
    return comma;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setComma(boolean newComma)
  {
    boolean oldComma = comma;
    comma = newComma;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.POSTFIX_EXPRESSION__COMMA, oldComma, comma));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expression> getExpr()
  {
    if (expr == null)
    {
      expr = new EObjectContainmentEList<Expression>(Expression.class, this, ParserPackage.POSTFIX_EXPRESSION__EXPR);
    }
    return expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PostfixExpressionSuffix> getSuffix()
  {
    if (suffix == null)
    {
      suffix = new EObjectContainmentEList<PostfixExpressionSuffix>(PostfixExpressionSuffix.class, this, ParserPackage.POSTFIX_EXPRESSION__SUFFIX);
    }
    return suffix;
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
      case ParserPackage.POSTFIX_EXPRESSION__TYPE_NAME:
        return basicSetTypeName(null, msgs);
      case ParserPackage.POSTFIX_EXPRESSION__INITIALIZER_LIST:
        return basicSetInitializerList(null, msgs);
      case ParserPackage.POSTFIX_EXPRESSION__EXPR:
        return ((InternalEList<?>)getExpr()).basicRemove(otherEnd, msgs);
      case ParserPackage.POSTFIX_EXPRESSION__SUFFIX:
        return ((InternalEList<?>)getSuffix()).basicRemove(otherEnd, msgs);
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
      case ParserPackage.POSTFIX_EXPRESSION__EXT:
        return isExt();
      case ParserPackage.POSTFIX_EXPRESSION__TYPE_NAME:
        return getTypeName();
      case ParserPackage.POSTFIX_EXPRESSION__INITIALIZER_LIST:
        return getInitializerList();
      case ParserPackage.POSTFIX_EXPRESSION__COMMA:
        return isComma();
      case ParserPackage.POSTFIX_EXPRESSION__EXPR:
        return getExpr();
      case ParserPackage.POSTFIX_EXPRESSION__SUFFIX:
        return getSuffix();
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
      case ParserPackage.POSTFIX_EXPRESSION__EXT:
        setExt((Boolean)newValue);
        return;
      case ParserPackage.POSTFIX_EXPRESSION__TYPE_NAME:
        setTypeName((TypeName)newValue);
        return;
      case ParserPackage.POSTFIX_EXPRESSION__INITIALIZER_LIST:
        setInitializerList((InitializerList)newValue);
        return;
      case ParserPackage.POSTFIX_EXPRESSION__COMMA:
        setComma((Boolean)newValue);
        return;
      case ParserPackage.POSTFIX_EXPRESSION__EXPR:
        getExpr().clear();
        getExpr().addAll((Collection<? extends Expression>)newValue);
        return;
      case ParserPackage.POSTFIX_EXPRESSION__SUFFIX:
        getSuffix().clear();
        getSuffix().addAll((Collection<? extends PostfixExpressionSuffix>)newValue);
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
      case ParserPackage.POSTFIX_EXPRESSION__EXT:
        setExt(EXT_EDEFAULT);
        return;
      case ParserPackage.POSTFIX_EXPRESSION__TYPE_NAME:
        setTypeName((TypeName)null);
        return;
      case ParserPackage.POSTFIX_EXPRESSION__INITIALIZER_LIST:
        setInitializerList((InitializerList)null);
        return;
      case ParserPackage.POSTFIX_EXPRESSION__COMMA:
        setComma(COMMA_EDEFAULT);
        return;
      case ParserPackage.POSTFIX_EXPRESSION__EXPR:
        getExpr().clear();
        return;
      case ParserPackage.POSTFIX_EXPRESSION__SUFFIX:
        getSuffix().clear();
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
      case ParserPackage.POSTFIX_EXPRESSION__EXT:
        return ext != EXT_EDEFAULT;
      case ParserPackage.POSTFIX_EXPRESSION__TYPE_NAME:
        return typeName != null;
      case ParserPackage.POSTFIX_EXPRESSION__INITIALIZER_LIST:
        return initializerList != null;
      case ParserPackage.POSTFIX_EXPRESSION__COMMA:
        return comma != COMMA_EDEFAULT;
      case ParserPackage.POSTFIX_EXPRESSION__EXPR:
        return expr != null && !expr.isEmpty();
      case ParserPackage.POSTFIX_EXPRESSION__SUFFIX:
        return suffix != null && !suffix.isEmpty();
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
    result.append(" (ext: ");
    result.append(ext);
    result.append(", comma: ");
    result.append(comma);
    result.append(')');
    return result.toString();
  }

} //PostfixExpressionImpl
