/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.ParserPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.ParameterDeclarationImpl#getDeclSpecifiers <em>Decl Specifiers</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.ParameterDeclarationImpl#getDeclarator <em>Declarator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterDeclarationImpl extends MinimalEObjectImpl.Container implements ParameterDeclaration
{
  /**
   * The cached value of the '{@link #getDeclSpecifiers() <em>Decl Specifiers</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeclSpecifiers()
   * @generated
   * @ordered
   */
  protected DeclarationSpecifiers declSpecifiers;

  /**
   * The cached value of the '{@link #getDeclarator() <em>Declarator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeclarator()
   * @generated
   * @ordered
   */
  protected Declarator declarator;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ParameterDeclarationImpl()
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
    return ParserPackage.Literals.PARAMETER_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeclarationSpecifiers getDeclSpecifiers()
  {
    return declSpecifiers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDeclSpecifiers(DeclarationSpecifiers newDeclSpecifiers, NotificationChain msgs)
  {
    DeclarationSpecifiers oldDeclSpecifiers = declSpecifiers;
    declSpecifiers = newDeclSpecifiers;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.PARAMETER_DECLARATION__DECL_SPECIFIERS, oldDeclSpecifiers, newDeclSpecifiers);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDeclSpecifiers(DeclarationSpecifiers newDeclSpecifiers)
  {
    if (newDeclSpecifiers != declSpecifiers)
    {
      NotificationChain msgs = null;
      if (declSpecifiers != null)
        msgs = ((InternalEObject)declSpecifiers).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.PARAMETER_DECLARATION__DECL_SPECIFIERS, null, msgs);
      if (newDeclSpecifiers != null)
        msgs = ((InternalEObject)newDeclSpecifiers).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.PARAMETER_DECLARATION__DECL_SPECIFIERS, null, msgs);
      msgs = basicSetDeclSpecifiers(newDeclSpecifiers, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.PARAMETER_DECLARATION__DECL_SPECIFIERS, newDeclSpecifiers, newDeclSpecifiers));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Declarator getDeclarator()
  {
    return declarator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDeclarator(Declarator newDeclarator, NotificationChain msgs)
  {
    Declarator oldDeclarator = declarator;
    declarator = newDeclarator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.PARAMETER_DECLARATION__DECLARATOR, oldDeclarator, newDeclarator);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDeclarator(Declarator newDeclarator)
  {
    if (newDeclarator != declarator)
    {
      NotificationChain msgs = null;
      if (declarator != null)
        msgs = ((InternalEObject)declarator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.PARAMETER_DECLARATION__DECLARATOR, null, msgs);
      if (newDeclarator != null)
        msgs = ((InternalEObject)newDeclarator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.PARAMETER_DECLARATION__DECLARATOR, null, msgs);
      msgs = basicSetDeclarator(newDeclarator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.PARAMETER_DECLARATION__DECLARATOR, newDeclarator, newDeclarator));
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
      case ParserPackage.PARAMETER_DECLARATION__DECL_SPECIFIERS:
        return basicSetDeclSpecifiers(null, msgs);
      case ParserPackage.PARAMETER_DECLARATION__DECLARATOR:
        return basicSetDeclarator(null, msgs);
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
      case ParserPackage.PARAMETER_DECLARATION__DECL_SPECIFIERS:
        return getDeclSpecifiers();
      case ParserPackage.PARAMETER_DECLARATION__DECLARATOR:
        return getDeclarator();
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
      case ParserPackage.PARAMETER_DECLARATION__DECL_SPECIFIERS:
        setDeclSpecifiers((DeclarationSpecifiers)newValue);
        return;
      case ParserPackage.PARAMETER_DECLARATION__DECLARATOR:
        setDeclarator((Declarator)newValue);
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
      case ParserPackage.PARAMETER_DECLARATION__DECL_SPECIFIERS:
        setDeclSpecifiers((DeclarationSpecifiers)null);
        return;
      case ParserPackage.PARAMETER_DECLARATION__DECLARATOR:
        setDeclarator((Declarator)null);
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
      case ParserPackage.PARAMETER_DECLARATION__DECL_SPECIFIERS:
        return declSpecifiers != null;
      case ParserPackage.PARAMETER_DECLARATION__DECLARATOR:
        return declarator != null;
    }
    return super.eIsSet(featureID);
  }

} //ParameterDeclarationImpl
