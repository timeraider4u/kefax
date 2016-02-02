/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.AbstractDeclaratorSuffix;
import at.jku.weiner.c.parser.parser.Expression;
import at.jku.weiner.c.parser.parser.GccDeclaratorExtension;
import at.jku.weiner.c.parser.parser.ParameterTypeList;
import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.TypeQualifierList;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Declarator Suffix</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AbstractDeclaratorSuffixImpl#getTypeQualifierList <em>Type Qualifier List</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AbstractDeclaratorSuffixImpl#getAssignmentExpr <em>Assignment Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AbstractDeclaratorSuffixImpl#getTypeQualifierListOrig <em>Type Qualifier List Orig</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AbstractDeclaratorSuffixImpl#getParameterTypeList <em>Parameter Type List</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AbstractDeclaratorSuffixImpl#getGccDeclExt <em>Gcc Decl Ext</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbstractDeclaratorSuffixImpl extends MinimalEObjectImpl.Container implements AbstractDeclaratorSuffix
{
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
   * The cached value of the '{@link #getAssignmentExpr() <em>Assignment Expr</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssignmentExpr()
   * @generated
   * @ordered
   */
  protected EList<Expression> assignmentExpr;

  /**
   * The cached value of the '{@link #getTypeQualifierListOrig() <em>Type Qualifier List Orig</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeQualifierListOrig()
   * @generated
   * @ordered
   */
  protected TypeQualifierList typeQualifierListOrig;

  /**
   * The cached value of the '{@link #getParameterTypeList() <em>Parameter Type List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameterTypeList()
   * @generated
   * @ordered
   */
  protected ParameterTypeList parameterTypeList;

  /**
   * The cached value of the '{@link #getGccDeclExt() <em>Gcc Decl Ext</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGccDeclExt()
   * @generated
   * @ordered
   */
  protected EList<GccDeclaratorExtension> gccDeclExt;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AbstractDeclaratorSuffixImpl()
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
    return ParserPackage.Literals.ABSTRACT_DECLARATOR_SUFFIX;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST, oldTypeQualifierList, newTypeQualifierList);
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
        msgs = ((InternalEObject)typeQualifierList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST, null, msgs);
      if (newTypeQualifierList != null)
        msgs = ((InternalEObject)newTypeQualifierList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST, null, msgs);
      msgs = basicSetTypeQualifierList(newTypeQualifierList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST, newTypeQualifierList, newTypeQualifierList));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expression> getAssignmentExpr()
  {
    if (assignmentExpr == null)
    {
      assignmentExpr = new EObjectContainmentEList<Expression>(Expression.class, this, ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__ASSIGNMENT_EXPR);
    }
    return assignmentExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeQualifierList getTypeQualifierListOrig()
  {
    return typeQualifierListOrig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypeQualifierListOrig(TypeQualifierList newTypeQualifierListOrig, NotificationChain msgs)
  {
    TypeQualifierList oldTypeQualifierListOrig = typeQualifierListOrig;
    typeQualifierListOrig = newTypeQualifierListOrig;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST_ORIG, oldTypeQualifierListOrig, newTypeQualifierListOrig);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeQualifierListOrig(TypeQualifierList newTypeQualifierListOrig)
  {
    if (newTypeQualifierListOrig != typeQualifierListOrig)
    {
      NotificationChain msgs = null;
      if (typeQualifierListOrig != null)
        msgs = ((InternalEObject)typeQualifierListOrig).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST_ORIG, null, msgs);
      if (newTypeQualifierListOrig != null)
        msgs = ((InternalEObject)newTypeQualifierListOrig).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST_ORIG, null, msgs);
      msgs = basicSetTypeQualifierListOrig(newTypeQualifierListOrig, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST_ORIG, newTypeQualifierListOrig, newTypeQualifierListOrig));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterTypeList getParameterTypeList()
  {
    return parameterTypeList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParameterTypeList(ParameterTypeList newParameterTypeList, NotificationChain msgs)
  {
    ParameterTypeList oldParameterTypeList = parameterTypeList;
    parameterTypeList = newParameterTypeList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__PARAMETER_TYPE_LIST, oldParameterTypeList, newParameterTypeList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParameterTypeList(ParameterTypeList newParameterTypeList)
  {
    if (newParameterTypeList != parameterTypeList)
    {
      NotificationChain msgs = null;
      if (parameterTypeList != null)
        msgs = ((InternalEObject)parameterTypeList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__PARAMETER_TYPE_LIST, null, msgs);
      if (newParameterTypeList != null)
        msgs = ((InternalEObject)newParameterTypeList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__PARAMETER_TYPE_LIST, null, msgs);
      msgs = basicSetParameterTypeList(newParameterTypeList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__PARAMETER_TYPE_LIST, newParameterTypeList, newParameterTypeList));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GccDeclaratorExtension> getGccDeclExt()
  {
    if (gccDeclExt == null)
    {
      gccDeclExt = new EObjectContainmentEList<GccDeclaratorExtension>(GccDeclaratorExtension.class, this, ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__GCC_DECL_EXT);
    }
    return gccDeclExt;
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
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST:
        return basicSetTypeQualifierList(null, msgs);
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__ASSIGNMENT_EXPR:
        return ((InternalEList<?>)getAssignmentExpr()).basicRemove(otherEnd, msgs);
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST_ORIG:
        return basicSetTypeQualifierListOrig(null, msgs);
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__PARAMETER_TYPE_LIST:
        return basicSetParameterTypeList(null, msgs);
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__GCC_DECL_EXT:
        return ((InternalEList<?>)getGccDeclExt()).basicRemove(otherEnd, msgs);
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
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST:
        return getTypeQualifierList();
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__ASSIGNMENT_EXPR:
        return getAssignmentExpr();
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST_ORIG:
        return getTypeQualifierListOrig();
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__PARAMETER_TYPE_LIST:
        return getParameterTypeList();
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__GCC_DECL_EXT:
        return getGccDeclExt();
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
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST:
        setTypeQualifierList((TypeQualifierList)newValue);
        return;
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__ASSIGNMENT_EXPR:
        getAssignmentExpr().clear();
        getAssignmentExpr().addAll((Collection<? extends Expression>)newValue);
        return;
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST_ORIG:
        setTypeQualifierListOrig((TypeQualifierList)newValue);
        return;
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__PARAMETER_TYPE_LIST:
        setParameterTypeList((ParameterTypeList)newValue);
        return;
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__GCC_DECL_EXT:
        getGccDeclExt().clear();
        getGccDeclExt().addAll((Collection<? extends GccDeclaratorExtension>)newValue);
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
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST:
        setTypeQualifierList((TypeQualifierList)null);
        return;
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__ASSIGNMENT_EXPR:
        getAssignmentExpr().clear();
        return;
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST_ORIG:
        setTypeQualifierListOrig((TypeQualifierList)null);
        return;
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__PARAMETER_TYPE_LIST:
        setParameterTypeList((ParameterTypeList)null);
        return;
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__GCC_DECL_EXT:
        getGccDeclExt().clear();
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
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST:
        return typeQualifierList != null;
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__ASSIGNMENT_EXPR:
        return assignmentExpr != null && !assignmentExpr.isEmpty();
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST_ORIG:
        return typeQualifierListOrig != null;
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__PARAMETER_TYPE_LIST:
        return parameterTypeList != null;
      case ParserPackage.ABSTRACT_DECLARATOR_SUFFIX__GCC_DECL_EXT:
        return gccDeclExt != null && !gccDeclExt.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AbstractDeclaratorSuffixImpl
