/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
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
 * An implementation of the model object '<em><b>Declarator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DeclaratorImpl#getPointer <em>Pointer</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DeclaratorImpl#getGccDeclExt1 <em>Gcc Decl Ext1</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DeclaratorImpl#getDeclarator <em>Declarator</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DeclaratorImpl#getGccDeclExt2 <em>Gcc Decl Ext2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeclaratorImpl extends MinimalEObjectImpl.Container implements Declarator
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
   * The cached value of the '{@link #getGccDeclExt1() <em>Gcc Decl Ext1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGccDeclExt1()
   * @generated
   * @ordered
   */
  protected EList<GccDeclaratorExtension> gccDeclExt1;

  /**
   * The cached value of the '{@link #getDeclarator() <em>Declarator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeclarator()
   * @generated
   * @ordered
   */
  protected DirectDeclarator declarator;

  /**
   * The cached value of the '{@link #getGccDeclExt2() <em>Gcc Decl Ext2</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGccDeclExt2()
   * @generated
   * @ordered
   */
  protected EList<GccDeclaratorExtension> gccDeclExt2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DeclaratorImpl()
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
    return ParserPackage.Literals.DECLARATOR;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.DECLARATOR__POINTER, oldPointer, newPointer);
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
        msgs = ((InternalEObject)pointer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.DECLARATOR__POINTER, null, msgs);
      if (newPointer != null)
        msgs = ((InternalEObject)newPointer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.DECLARATOR__POINTER, null, msgs);
      msgs = basicSetPointer(newPointer, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.DECLARATOR__POINTER, newPointer, newPointer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GccDeclaratorExtension> getGccDeclExt1()
  {
    if (gccDeclExt1 == null)
    {
      gccDeclExt1 = new EObjectContainmentEList<GccDeclaratorExtension>(GccDeclaratorExtension.class, this, ParserPackage.DECLARATOR__GCC_DECL_EXT1);
    }
    return gccDeclExt1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DirectDeclarator getDeclarator()
  {
    return declarator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDeclarator(DirectDeclarator newDeclarator, NotificationChain msgs)
  {
    DirectDeclarator oldDeclarator = declarator;
    declarator = newDeclarator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.DECLARATOR__DECLARATOR, oldDeclarator, newDeclarator);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDeclarator(DirectDeclarator newDeclarator)
  {
    if (newDeclarator != declarator)
    {
      NotificationChain msgs = null;
      if (declarator != null)
        msgs = ((InternalEObject)declarator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.DECLARATOR__DECLARATOR, null, msgs);
      if (newDeclarator != null)
        msgs = ((InternalEObject)newDeclarator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.DECLARATOR__DECLARATOR, null, msgs);
      msgs = basicSetDeclarator(newDeclarator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.DECLARATOR__DECLARATOR, newDeclarator, newDeclarator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GccDeclaratorExtension> getGccDeclExt2()
  {
    if (gccDeclExt2 == null)
    {
      gccDeclExt2 = new EObjectContainmentEList<GccDeclaratorExtension>(GccDeclaratorExtension.class, this, ParserPackage.DECLARATOR__GCC_DECL_EXT2);
    }
    return gccDeclExt2;
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
      case ParserPackage.DECLARATOR__POINTER:
        return basicSetPointer(null, msgs);
      case ParserPackage.DECLARATOR__GCC_DECL_EXT1:
        return ((InternalEList<?>)getGccDeclExt1()).basicRemove(otherEnd, msgs);
      case ParserPackage.DECLARATOR__DECLARATOR:
        return basicSetDeclarator(null, msgs);
      case ParserPackage.DECLARATOR__GCC_DECL_EXT2:
        return ((InternalEList<?>)getGccDeclExt2()).basicRemove(otherEnd, msgs);
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
      case ParserPackage.DECLARATOR__POINTER:
        return getPointer();
      case ParserPackage.DECLARATOR__GCC_DECL_EXT1:
        return getGccDeclExt1();
      case ParserPackage.DECLARATOR__DECLARATOR:
        return getDeclarator();
      case ParserPackage.DECLARATOR__GCC_DECL_EXT2:
        return getGccDeclExt2();
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
      case ParserPackage.DECLARATOR__POINTER:
        setPointer((Pointer)newValue);
        return;
      case ParserPackage.DECLARATOR__GCC_DECL_EXT1:
        getGccDeclExt1().clear();
        getGccDeclExt1().addAll((Collection<? extends GccDeclaratorExtension>)newValue);
        return;
      case ParserPackage.DECLARATOR__DECLARATOR:
        setDeclarator((DirectDeclarator)newValue);
        return;
      case ParserPackage.DECLARATOR__GCC_DECL_EXT2:
        getGccDeclExt2().clear();
        getGccDeclExt2().addAll((Collection<? extends GccDeclaratorExtension>)newValue);
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
      case ParserPackage.DECLARATOR__POINTER:
        setPointer((Pointer)null);
        return;
      case ParserPackage.DECLARATOR__GCC_DECL_EXT1:
        getGccDeclExt1().clear();
        return;
      case ParserPackage.DECLARATOR__DECLARATOR:
        setDeclarator((DirectDeclarator)null);
        return;
      case ParserPackage.DECLARATOR__GCC_DECL_EXT2:
        getGccDeclExt2().clear();
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
      case ParserPackage.DECLARATOR__POINTER:
        return pointer != null;
      case ParserPackage.DECLARATOR__GCC_DECL_EXT1:
        return gccDeclExt1 != null && !gccDeclExt1.isEmpty();
      case ParserPackage.DECLARATOR__DECLARATOR:
        return declarator != null;
      case ParserPackage.DECLARATOR__GCC_DECL_EXT2:
        return gccDeclExt2 != null && !gccDeclExt2.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //DeclaratorImpl
