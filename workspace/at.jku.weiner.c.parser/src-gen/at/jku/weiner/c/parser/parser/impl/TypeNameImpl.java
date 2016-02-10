/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.AbstractDeclarator;
import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeName;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Name</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeNameImpl#getList <em>List</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.TypeNameImpl#getAbstractDeclarator <em>Abstract Declarator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeNameImpl extends MinimalEObjectImpl.Container implements TypeName
{
  /**
   * The cached value of the '{@link #getList() <em>List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getList()
   * @generated
   * @ordered
   */
  protected SpecifierQualifierList list;

  /**
   * The cached value of the '{@link #getAbstractDeclarator() <em>Abstract Declarator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAbstractDeclarator()
   * @generated
   * @ordered
   */
  protected AbstractDeclarator abstractDeclarator;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeNameImpl()
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
    return ParserPackage.Literals.TYPE_NAME;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpecifierQualifierList getList()
  {
    return list;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetList(SpecifierQualifierList newList, NotificationChain msgs)
  {
    SpecifierQualifierList oldList = list;
    list = newList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_NAME__LIST, oldList, newList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setList(SpecifierQualifierList newList)
  {
    if (newList != list)
    {
      NotificationChain msgs = null;
      if (list != null)
        msgs = ((InternalEObject)list).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.TYPE_NAME__LIST, null, msgs);
      if (newList != null)
        msgs = ((InternalEObject)newList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.TYPE_NAME__LIST, null, msgs);
      msgs = basicSetList(newList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_NAME__LIST, newList, newList));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractDeclarator getAbstractDeclarator()
  {
    return abstractDeclarator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAbstractDeclarator(AbstractDeclarator newAbstractDeclarator, NotificationChain msgs)
  {
    AbstractDeclarator oldAbstractDeclarator = abstractDeclarator;
    abstractDeclarator = newAbstractDeclarator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_NAME__ABSTRACT_DECLARATOR, oldAbstractDeclarator, newAbstractDeclarator);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAbstractDeclarator(AbstractDeclarator newAbstractDeclarator)
  {
    if (newAbstractDeclarator != abstractDeclarator)
    {
      NotificationChain msgs = null;
      if (abstractDeclarator != null)
        msgs = ((InternalEObject)abstractDeclarator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.TYPE_NAME__ABSTRACT_DECLARATOR, null, msgs);
      if (newAbstractDeclarator != null)
        msgs = ((InternalEObject)newAbstractDeclarator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.TYPE_NAME__ABSTRACT_DECLARATOR, null, msgs);
      msgs = basicSetAbstractDeclarator(newAbstractDeclarator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.TYPE_NAME__ABSTRACT_DECLARATOR, newAbstractDeclarator, newAbstractDeclarator));
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
      case ParserPackage.TYPE_NAME__LIST:
        return basicSetList(null, msgs);
      case ParserPackage.TYPE_NAME__ABSTRACT_DECLARATOR:
        return basicSetAbstractDeclarator(null, msgs);
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
      case ParserPackage.TYPE_NAME__LIST:
        return getList();
      case ParserPackage.TYPE_NAME__ABSTRACT_DECLARATOR:
        return getAbstractDeclarator();
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
      case ParserPackage.TYPE_NAME__LIST:
        setList((SpecifierQualifierList)newValue);
        return;
      case ParserPackage.TYPE_NAME__ABSTRACT_DECLARATOR:
        setAbstractDeclarator((AbstractDeclarator)newValue);
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
      case ParserPackage.TYPE_NAME__LIST:
        setList((SpecifierQualifierList)null);
        return;
      case ParserPackage.TYPE_NAME__ABSTRACT_DECLARATOR:
        setAbstractDeclarator((AbstractDeclarator)null);
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
      case ParserPackage.TYPE_NAME__LIST:
        return list != null;
      case ParserPackage.TYPE_NAME__ABSTRACT_DECLARATOR:
        return abstractDeclarator != null;
    }
    return super.eIsSet(featureID);
  }

} //TypeNameImpl
