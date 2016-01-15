/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.AbstractDeclarator;
import at.jku.weiner.c.parser.parser.DirectAbstractDeclarator;
import at.jku.weiner.c.parser.parser.GccDeclaratorExtension;
import at.jku.weiner.c.parser.parser.ParserPackage;
import at.jku.weiner.c.parser.parser.Pointer;

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
 * An implementation of the model object '<em><b>Abstract Declarator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AbstractDeclaratorImpl#getPointer <em>Pointer</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AbstractDeclaratorImpl#getDirectAbstractDeclarator <em>Direct Abstract Declarator</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.AbstractDeclaratorImpl#getGccDeclExtAbstract <em>Gcc Decl Ext Abstract</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbstractDeclaratorImpl extends MinimalEObjectImpl.Container implements AbstractDeclarator
{
  /**
   * The cached value of the '{@link #getPointer() <em>Pointer</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPointer()
   * @generated
   * @ordered
   */
  protected Pointer pointer;

  /**
   * The cached value of the '{@link #getDirectAbstractDeclarator() <em>Direct Abstract Declarator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirectAbstractDeclarator()
   * @generated
   * @ordered
   */
  protected DirectAbstractDeclarator directAbstractDeclarator;

  /**
   * The cached value of the '{@link #getGccDeclExtAbstract() <em>Gcc Decl Ext Abstract</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGccDeclExtAbstract()
   * @generated
   * @ordered
   */
  protected EList<GccDeclaratorExtension> gccDeclExtAbstract;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AbstractDeclaratorImpl()
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
    return ParserPackage.Literals.ABSTRACT_DECLARATOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pointer getPointer()
  {
    return pointer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPointer(Pointer newPointer, NotificationChain msgs)
  {
    Pointer oldPointer = pointer;
    pointer = newPointer;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.ABSTRACT_DECLARATOR__POINTER, oldPointer, newPointer);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPointer(Pointer newPointer)
  {
    if (newPointer != pointer)
    {
      NotificationChain msgs = null;
      if (pointer != null)
        msgs = ((InternalEObject)pointer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ABSTRACT_DECLARATOR__POINTER, null, msgs);
      if (newPointer != null)
        msgs = ((InternalEObject)newPointer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ABSTRACT_DECLARATOR__POINTER, null, msgs);
      msgs = basicSetPointer(newPointer, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ABSTRACT_DECLARATOR__POINTER, newPointer, newPointer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DirectAbstractDeclarator getDirectAbstractDeclarator()
  {
    return directAbstractDeclarator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDirectAbstractDeclarator(DirectAbstractDeclarator newDirectAbstractDeclarator, NotificationChain msgs)
  {
    DirectAbstractDeclarator oldDirectAbstractDeclarator = directAbstractDeclarator;
    directAbstractDeclarator = newDirectAbstractDeclarator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.ABSTRACT_DECLARATOR__DIRECT_ABSTRACT_DECLARATOR, oldDirectAbstractDeclarator, newDirectAbstractDeclarator);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDirectAbstractDeclarator(DirectAbstractDeclarator newDirectAbstractDeclarator)
  {
    if (newDirectAbstractDeclarator != directAbstractDeclarator)
    {
      NotificationChain msgs = null;
      if (directAbstractDeclarator != null)
        msgs = ((InternalEObject)directAbstractDeclarator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ABSTRACT_DECLARATOR__DIRECT_ABSTRACT_DECLARATOR, null, msgs);
      if (newDirectAbstractDeclarator != null)
        msgs = ((InternalEObject)newDirectAbstractDeclarator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.ABSTRACT_DECLARATOR__DIRECT_ABSTRACT_DECLARATOR, null, msgs);
      msgs = basicSetDirectAbstractDeclarator(newDirectAbstractDeclarator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.ABSTRACT_DECLARATOR__DIRECT_ABSTRACT_DECLARATOR, newDirectAbstractDeclarator, newDirectAbstractDeclarator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GccDeclaratorExtension> getGccDeclExtAbstract()
  {
    if (gccDeclExtAbstract == null)
    {
      gccDeclExtAbstract = new EObjectContainmentEList<GccDeclaratorExtension>(GccDeclaratorExtension.class, this, ParserPackage.ABSTRACT_DECLARATOR__GCC_DECL_EXT_ABSTRACT);
    }
    return gccDeclExtAbstract;
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
      case ParserPackage.ABSTRACT_DECLARATOR__POINTER:
        return basicSetPointer(null, msgs);
      case ParserPackage.ABSTRACT_DECLARATOR__DIRECT_ABSTRACT_DECLARATOR:
        return basicSetDirectAbstractDeclarator(null, msgs);
      case ParserPackage.ABSTRACT_DECLARATOR__GCC_DECL_EXT_ABSTRACT:
        return ((InternalEList<?>)getGccDeclExtAbstract()).basicRemove(otherEnd, msgs);
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
      case ParserPackage.ABSTRACT_DECLARATOR__POINTER:
        return getPointer();
      case ParserPackage.ABSTRACT_DECLARATOR__DIRECT_ABSTRACT_DECLARATOR:
        return getDirectAbstractDeclarator();
      case ParserPackage.ABSTRACT_DECLARATOR__GCC_DECL_EXT_ABSTRACT:
        return getGccDeclExtAbstract();
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
      case ParserPackage.ABSTRACT_DECLARATOR__POINTER:
        setPointer((Pointer)newValue);
        return;
      case ParserPackage.ABSTRACT_DECLARATOR__DIRECT_ABSTRACT_DECLARATOR:
        setDirectAbstractDeclarator((DirectAbstractDeclarator)newValue);
        return;
      case ParserPackage.ABSTRACT_DECLARATOR__GCC_DECL_EXT_ABSTRACT:
        getGccDeclExtAbstract().clear();
        getGccDeclExtAbstract().addAll((Collection<? extends GccDeclaratorExtension>)newValue);
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
      case ParserPackage.ABSTRACT_DECLARATOR__POINTER:
        setPointer((Pointer)null);
        return;
      case ParserPackage.ABSTRACT_DECLARATOR__DIRECT_ABSTRACT_DECLARATOR:
        setDirectAbstractDeclarator((DirectAbstractDeclarator)null);
        return;
      case ParserPackage.ABSTRACT_DECLARATOR__GCC_DECL_EXT_ABSTRACT:
        getGccDeclExtAbstract().clear();
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
      case ParserPackage.ABSTRACT_DECLARATOR__POINTER:
        return pointer != null;
      case ParserPackage.ABSTRACT_DECLARATOR__DIRECT_ABSTRACT_DECLARATOR:
        return directAbstractDeclarator != null;
      case ParserPackage.ABSTRACT_DECLARATOR__GCC_DECL_EXT_ABSTRACT:
        return gccDeclExtAbstract != null && !gccDeclExtAbstract.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AbstractDeclaratorImpl
