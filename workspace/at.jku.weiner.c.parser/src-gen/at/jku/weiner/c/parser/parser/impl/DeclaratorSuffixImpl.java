/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.TypeQualifierList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declarator Suffix</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DeclaratorSuffixImpl#getStatic <em>Static</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DeclaratorSuffixImpl#getTypeQualifierList <em>Type Qualifier List</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DeclaratorSuffixImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DeclaratorSuffixImpl#getStar <em>Star</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DeclaratorSuffixImpl#getLastSuffix <em>Last Suffix</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeclaratorSuffixImpl extends MinimalEObjectImpl.Container implements DeclaratorSuffix
{
  /**
   * The default value of the '{@link #getStatic() <em>Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatic()
   * @generated
   * @ordered
   */
  protected static final String STATIC_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStatic() <em>Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatic()
   * @generated
   * @ordered
   */
  protected String static_ = STATIC_EDEFAULT;

  /**
   * The cached value of the '{@link #getTypeQualifierList() <em>Type Qualifier List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeQualifierList()
   * @generated
   * @ordered
   */
  protected TypeQualifierList typeQualifierList;

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
   * The default value of the '{@link #getStar() <em>Star</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStar()
   * @generated
   * @ordered
   */
  protected static final String STAR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStar() <em>Star</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStar()
   * @generated
   * @ordered
   */
  protected String star = STAR_EDEFAULT;

  /**
   * The cached value of the '{@link #getLastSuffix() <em>Last Suffix</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLastSuffix()
   * @generated
   * @ordered
   */
  protected DirectDeclaratorLastSuffix lastSuffix;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DeclaratorSuffixImpl()
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
    return ParserPackage.Literals.DECLARATOR_SUFFIX;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStatic()
  {
    return static_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStatic(String newStatic)
  {
    String oldStatic = static_;
    static_ = newStatic;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.DECLARATOR_SUFFIX__STATIC, oldStatic, static_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeQualifierList getTypeQualifierList()
  {
    return typeQualifierList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypeQualifierList(TypeQualifierList newTypeQualifierList, NotificationChain msgs)
  {
    TypeQualifierList oldTypeQualifierList = typeQualifierList;
    typeQualifierList = newTypeQualifierList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST, oldTypeQualifierList, newTypeQualifierList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeQualifierList(TypeQualifierList newTypeQualifierList)
  {
    if (newTypeQualifierList != typeQualifierList)
    {
      NotificationChain msgs = null;
      if (typeQualifierList != null)
        msgs = ((InternalEObject)typeQualifierList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST, null, msgs);
      if (newTypeQualifierList != null)
        msgs = ((InternalEObject)newTypeQualifierList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST, null, msgs);
      msgs = basicSetTypeQualifierList(newTypeQualifierList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST, newTypeQualifierList, newTypeQualifierList));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.DECLARATOR_SUFFIX__EXPR, oldExpr, newExpr);
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
        msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.DECLARATOR_SUFFIX__EXPR, null, msgs);
      if (newExpr != null)
        msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.DECLARATOR_SUFFIX__EXPR, null, msgs);
      msgs = basicSetExpr(newExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.DECLARATOR_SUFFIX__EXPR, newExpr, newExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStar()
  {
    return star;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStar(String newStar)
  {
    String oldStar = star;
    star = newStar;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.DECLARATOR_SUFFIX__STAR, oldStar, star));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DirectDeclaratorLastSuffix getLastSuffix()
  {
    return lastSuffix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLastSuffix(DirectDeclaratorLastSuffix newLastSuffix, NotificationChain msgs)
  {
    DirectDeclaratorLastSuffix oldLastSuffix = lastSuffix;
    lastSuffix = newLastSuffix;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.DECLARATOR_SUFFIX__LAST_SUFFIX, oldLastSuffix, newLastSuffix);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLastSuffix(DirectDeclaratorLastSuffix newLastSuffix)
  {
    if (newLastSuffix != lastSuffix)
    {
      NotificationChain msgs = null;
      if (lastSuffix != null)
        msgs = ((InternalEObject)lastSuffix).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.DECLARATOR_SUFFIX__LAST_SUFFIX, null, msgs);
      if (newLastSuffix != null)
        msgs = ((InternalEObject)newLastSuffix).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.DECLARATOR_SUFFIX__LAST_SUFFIX, null, msgs);
      msgs = basicSetLastSuffix(newLastSuffix, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.DECLARATOR_SUFFIX__LAST_SUFFIX, newLastSuffix, newLastSuffix));
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
      case ParserPackage.DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST:
        return basicSetTypeQualifierList(null, msgs);
      case ParserPackage.DECLARATOR_SUFFIX__EXPR:
        return basicSetExpr(null, msgs);
      case ParserPackage.DECLARATOR_SUFFIX__LAST_SUFFIX:
        return basicSetLastSuffix(null, msgs);
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
      case ParserPackage.DECLARATOR_SUFFIX__STATIC:
        return getStatic();
      case ParserPackage.DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST:
        return getTypeQualifierList();
      case ParserPackage.DECLARATOR_SUFFIX__EXPR:
        return getExpr();
      case ParserPackage.DECLARATOR_SUFFIX__STAR:
        return getStar();
      case ParserPackage.DECLARATOR_SUFFIX__LAST_SUFFIX:
        return getLastSuffix();
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
      case ParserPackage.DECLARATOR_SUFFIX__STATIC:
        setStatic((String)newValue);
        return;
      case ParserPackage.DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST:
        setTypeQualifierList((TypeQualifierList)newValue);
        return;
      case ParserPackage.DECLARATOR_SUFFIX__EXPR:
        setExpr((Expression)newValue);
        return;
      case ParserPackage.DECLARATOR_SUFFIX__STAR:
        setStar((String)newValue);
        return;
      case ParserPackage.DECLARATOR_SUFFIX__LAST_SUFFIX:
        setLastSuffix((DirectDeclaratorLastSuffix)newValue);
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
      case ParserPackage.DECLARATOR_SUFFIX__STATIC:
        setStatic(STATIC_EDEFAULT);
        return;
      case ParserPackage.DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST:
        setTypeQualifierList((TypeQualifierList)null);
        return;
      case ParserPackage.DECLARATOR_SUFFIX__EXPR:
        setExpr((Expression)null);
        return;
      case ParserPackage.DECLARATOR_SUFFIX__STAR:
        setStar(STAR_EDEFAULT);
        return;
      case ParserPackage.DECLARATOR_SUFFIX__LAST_SUFFIX:
        setLastSuffix((DirectDeclaratorLastSuffix)null);
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
      case ParserPackage.DECLARATOR_SUFFIX__STATIC:
        return STATIC_EDEFAULT == null ? static_ != null : !STATIC_EDEFAULT.equals(static_);
      case ParserPackage.DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST:
        return typeQualifierList != null;
      case ParserPackage.DECLARATOR_SUFFIX__EXPR:
        return expr != null;
      case ParserPackage.DECLARATOR_SUFFIX__STAR:
        return STAR_EDEFAULT == null ? star != null : !STAR_EDEFAULT.equals(star);
      case ParserPackage.DECLARATOR_SUFFIX__LAST_SUFFIX:
        return lastSuffix != null;
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
    result.append(" (static: ");
    result.append(static_);
    result.append(", star: ");
    result.append(star);
    result.append(')');
    return result.toString();
  }

} //DeclaratorSuffixImpl
