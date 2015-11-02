/**
 */
package at.jku.weiner.c.c.impl;

import at.jku.weiner.c.c.CPackage;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.c.FunctionDefHead;

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
 * An implementation of the model object '<em><b>Function Def Head</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.impl.FunctionDefHeadImpl#getFunDeclSpecifiers <em>Fun Decl Specifiers</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.FunctionDefHeadImpl#getFunDeclarator <em>Fun Declarator</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.FunctionDefHeadImpl#getFunDeclaration <em>Fun Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionDefHeadImpl extends MinimalEObjectImpl.Container implements FunctionDefHead
{
  /**
   * The cached value of the '{@link #getFunDeclSpecifiers() <em>Fun Decl Specifiers</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunDeclSpecifiers()
   * @generated
   * @ordered
   */
  protected FunctionDeclarationSpecifiers funDeclSpecifiers;

  /**
   * The cached value of the '{@link #getFunDeclarator() <em>Fun Declarator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunDeclarator()
   * @generated
   * @ordered
   */
  protected Declarator funDeclarator;

  /**
   * The cached value of the '{@link #getFunDeclaration() <em>Fun Declaration</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunDeclaration()
   * @generated
   * @ordered
   */
  protected EList<Declaration> funDeclaration;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FunctionDefHeadImpl()
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
    return CPackage.Literals.FUNCTION_DEF_HEAD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionDeclarationSpecifiers getFunDeclSpecifiers()
  {
    return funDeclSpecifiers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFunDeclSpecifiers(FunctionDeclarationSpecifiers newFunDeclSpecifiers, NotificationChain msgs)
  {
    FunctionDeclarationSpecifiers oldFunDeclSpecifiers = funDeclSpecifiers;
    funDeclSpecifiers = newFunDeclSpecifiers;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CPackage.FUNCTION_DEF_HEAD__FUN_DECL_SPECIFIERS, oldFunDeclSpecifiers, newFunDeclSpecifiers);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunDeclSpecifiers(FunctionDeclarationSpecifiers newFunDeclSpecifiers)
  {
    if (newFunDeclSpecifiers != funDeclSpecifiers)
    {
      NotificationChain msgs = null;
      if (funDeclSpecifiers != null)
        msgs = ((InternalEObject)funDeclSpecifiers).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CPackage.FUNCTION_DEF_HEAD__FUN_DECL_SPECIFIERS, null, msgs);
      if (newFunDeclSpecifiers != null)
        msgs = ((InternalEObject)newFunDeclSpecifiers).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CPackage.FUNCTION_DEF_HEAD__FUN_DECL_SPECIFIERS, null, msgs);
      msgs = basicSetFunDeclSpecifiers(newFunDeclSpecifiers, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.FUNCTION_DEF_HEAD__FUN_DECL_SPECIFIERS, newFunDeclSpecifiers, newFunDeclSpecifiers));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Declarator getFunDeclarator()
  {
    return funDeclarator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFunDeclarator(Declarator newFunDeclarator, NotificationChain msgs)
  {
    Declarator oldFunDeclarator = funDeclarator;
    funDeclarator = newFunDeclarator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CPackage.FUNCTION_DEF_HEAD__FUN_DECLARATOR, oldFunDeclarator, newFunDeclarator);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunDeclarator(Declarator newFunDeclarator)
  {
    if (newFunDeclarator != funDeclarator)
    {
      NotificationChain msgs = null;
      if (funDeclarator != null)
        msgs = ((InternalEObject)funDeclarator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CPackage.FUNCTION_DEF_HEAD__FUN_DECLARATOR, null, msgs);
      if (newFunDeclarator != null)
        msgs = ((InternalEObject)newFunDeclarator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CPackage.FUNCTION_DEF_HEAD__FUN_DECLARATOR, null, msgs);
      msgs = basicSetFunDeclarator(newFunDeclarator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.FUNCTION_DEF_HEAD__FUN_DECLARATOR, newFunDeclarator, newFunDeclarator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Declaration> getFunDeclaration()
  {
    if (funDeclaration == null)
    {
      funDeclaration = new EObjectContainmentEList<Declaration>(Declaration.class, this, CPackage.FUNCTION_DEF_HEAD__FUN_DECLARATION);
    }
    return funDeclaration;
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
      case CPackage.FUNCTION_DEF_HEAD__FUN_DECL_SPECIFIERS:
        return basicSetFunDeclSpecifiers(null, msgs);
      case CPackage.FUNCTION_DEF_HEAD__FUN_DECLARATOR:
        return basicSetFunDeclarator(null, msgs);
      case CPackage.FUNCTION_DEF_HEAD__FUN_DECLARATION:
        return ((InternalEList<?>)getFunDeclaration()).basicRemove(otherEnd, msgs);
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
      case CPackage.FUNCTION_DEF_HEAD__FUN_DECL_SPECIFIERS:
        return getFunDeclSpecifiers();
      case CPackage.FUNCTION_DEF_HEAD__FUN_DECLARATOR:
        return getFunDeclarator();
      case CPackage.FUNCTION_DEF_HEAD__FUN_DECLARATION:
        return getFunDeclaration();
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
      case CPackage.FUNCTION_DEF_HEAD__FUN_DECL_SPECIFIERS:
        setFunDeclSpecifiers((FunctionDeclarationSpecifiers)newValue);
        return;
      case CPackage.FUNCTION_DEF_HEAD__FUN_DECLARATOR:
        setFunDeclarator((Declarator)newValue);
        return;
      case CPackage.FUNCTION_DEF_HEAD__FUN_DECLARATION:
        getFunDeclaration().clear();
        getFunDeclaration().addAll((Collection<? extends Declaration>)newValue);
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
      case CPackage.FUNCTION_DEF_HEAD__FUN_DECL_SPECIFIERS:
        setFunDeclSpecifiers((FunctionDeclarationSpecifiers)null);
        return;
      case CPackage.FUNCTION_DEF_HEAD__FUN_DECLARATOR:
        setFunDeclarator((Declarator)null);
        return;
      case CPackage.FUNCTION_DEF_HEAD__FUN_DECLARATION:
        getFunDeclaration().clear();
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
      case CPackage.FUNCTION_DEF_HEAD__FUN_DECL_SPECIFIERS:
        return funDeclSpecifiers != null;
      case CPackage.FUNCTION_DEF_HEAD__FUN_DECLARATOR:
        return funDeclarator != null;
      case CPackage.FUNCTION_DEF_HEAD__FUN_DECLARATION:
        return funDeclaration != null && !funDeclaration.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FunctionDefHeadImpl
