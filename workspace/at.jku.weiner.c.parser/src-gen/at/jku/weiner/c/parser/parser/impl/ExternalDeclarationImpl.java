/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.Declaration;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.FunctionDefHead;
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.ParserPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.ExternalDeclarationImpl#getFunctiondefHead <em>Functiondef Head</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.ExternalDeclarationImpl#getFunctionDefinition <em>Function Definition</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.ExternalDeclarationImpl#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.ExternalDeclarationImpl#getSemi <em>Semi</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalDeclarationImpl extends MinimalEObjectImpl.Container implements ExternalDeclaration
{
  /**
   * The cached value of the '{@link #getFunctiondefHead() <em>Functiondef Head</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunctiondefHead()
   * @generated
   * @ordered
   */
  protected FunctionDefHead functiondefHead;

  /**
   * The cached value of the '{@link #getFunctionDefinition() <em>Function Definition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunctionDefinition()
   * @generated
   * @ordered
   */
  protected FunctionDefinition functionDefinition;

  /**
   * The cached value of the '{@link #getDeclaration() <em>Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeclaration()
   * @generated
   * @ordered
   */
  protected Declaration declaration;

  /**
   * The default value of the '{@link #getSemi() <em>Semi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSemi()
   * @generated
   * @ordered
   */
  protected static final String SEMI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSemi() <em>Semi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSemi()
   * @generated
   * @ordered
   */
  protected String semi = SEMI_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExternalDeclarationImpl()
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
    return ParserPackage.Literals.EXTERNAL_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionDefHead getFunctiondefHead()
  {
    return functiondefHead;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFunctiondefHead(FunctionDefHead newFunctiondefHead, NotificationChain msgs)
  {
    FunctionDefHead oldFunctiondefHead = functiondefHead;
    functiondefHead = newFunctiondefHead;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.EXTERNAL_DECLARATION__FUNCTIONDEF_HEAD, oldFunctiondefHead, newFunctiondefHead);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunctiondefHead(FunctionDefHead newFunctiondefHead)
  {
    if (newFunctiondefHead != functiondefHead)
    {
      NotificationChain msgs = null;
      if (functiondefHead != null)
        msgs = ((InternalEObject)functiondefHead).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.EXTERNAL_DECLARATION__FUNCTIONDEF_HEAD, null, msgs);
      if (newFunctiondefHead != null)
        msgs = ((InternalEObject)newFunctiondefHead).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.EXTERNAL_DECLARATION__FUNCTIONDEF_HEAD, null, msgs);
      msgs = basicSetFunctiondefHead(newFunctiondefHead, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.EXTERNAL_DECLARATION__FUNCTIONDEF_HEAD, newFunctiondefHead, newFunctiondefHead));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionDefinition getFunctionDefinition()
  {
    return functionDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFunctionDefinition(FunctionDefinition newFunctionDefinition, NotificationChain msgs)
  {
    FunctionDefinition oldFunctionDefinition = functionDefinition;
    functionDefinition = newFunctionDefinition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.EXTERNAL_DECLARATION__FUNCTION_DEFINITION, oldFunctionDefinition, newFunctionDefinition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunctionDefinition(FunctionDefinition newFunctionDefinition)
  {
    if (newFunctionDefinition != functionDefinition)
    {
      NotificationChain msgs = null;
      if (functionDefinition != null)
        msgs = ((InternalEObject)functionDefinition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.EXTERNAL_DECLARATION__FUNCTION_DEFINITION, null, msgs);
      if (newFunctionDefinition != null)
        msgs = ((InternalEObject)newFunctionDefinition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.EXTERNAL_DECLARATION__FUNCTION_DEFINITION, null, msgs);
      msgs = basicSetFunctionDefinition(newFunctionDefinition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.EXTERNAL_DECLARATION__FUNCTION_DEFINITION, newFunctionDefinition, newFunctionDefinition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Declaration getDeclaration()
  {
    return declaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDeclaration(Declaration newDeclaration, NotificationChain msgs)
  {
    Declaration oldDeclaration = declaration;
    declaration = newDeclaration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.EXTERNAL_DECLARATION__DECLARATION, oldDeclaration, newDeclaration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDeclaration(Declaration newDeclaration)
  {
    if (newDeclaration != declaration)
    {
      NotificationChain msgs = null;
      if (declaration != null)
        msgs = ((InternalEObject)declaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.EXTERNAL_DECLARATION__DECLARATION, null, msgs);
      if (newDeclaration != null)
        msgs = ((InternalEObject)newDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.EXTERNAL_DECLARATION__DECLARATION, null, msgs);
      msgs = basicSetDeclaration(newDeclaration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.EXTERNAL_DECLARATION__DECLARATION, newDeclaration, newDeclaration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSemi()
  {
    return semi;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSemi(String newSemi)
  {
    String oldSemi = semi;
    semi = newSemi;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.EXTERNAL_DECLARATION__SEMI, oldSemi, semi));
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
      case ParserPackage.EXTERNAL_DECLARATION__FUNCTIONDEF_HEAD:
        return basicSetFunctiondefHead(null, msgs);
      case ParserPackage.EXTERNAL_DECLARATION__FUNCTION_DEFINITION:
        return basicSetFunctionDefinition(null, msgs);
      case ParserPackage.EXTERNAL_DECLARATION__DECLARATION:
        return basicSetDeclaration(null, msgs);
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
      case ParserPackage.EXTERNAL_DECLARATION__FUNCTIONDEF_HEAD:
        return getFunctiondefHead();
      case ParserPackage.EXTERNAL_DECLARATION__FUNCTION_DEFINITION:
        return getFunctionDefinition();
      case ParserPackage.EXTERNAL_DECLARATION__DECLARATION:
        return getDeclaration();
      case ParserPackage.EXTERNAL_DECLARATION__SEMI:
        return getSemi();
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
      case ParserPackage.EXTERNAL_DECLARATION__FUNCTIONDEF_HEAD:
        setFunctiondefHead((FunctionDefHead)newValue);
        return;
      case ParserPackage.EXTERNAL_DECLARATION__FUNCTION_DEFINITION:
        setFunctionDefinition((FunctionDefinition)newValue);
        return;
      case ParserPackage.EXTERNAL_DECLARATION__DECLARATION:
        setDeclaration((Declaration)newValue);
        return;
      case ParserPackage.EXTERNAL_DECLARATION__SEMI:
        setSemi((String)newValue);
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
      case ParserPackage.EXTERNAL_DECLARATION__FUNCTIONDEF_HEAD:
        setFunctiondefHead((FunctionDefHead)null);
        return;
      case ParserPackage.EXTERNAL_DECLARATION__FUNCTION_DEFINITION:
        setFunctionDefinition((FunctionDefinition)null);
        return;
      case ParserPackage.EXTERNAL_DECLARATION__DECLARATION:
        setDeclaration((Declaration)null);
        return;
      case ParserPackage.EXTERNAL_DECLARATION__SEMI:
        setSemi(SEMI_EDEFAULT);
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
      case ParserPackage.EXTERNAL_DECLARATION__FUNCTIONDEF_HEAD:
        return functiondefHead != null;
      case ParserPackage.EXTERNAL_DECLARATION__FUNCTION_DEFINITION:
        return functionDefinition != null;
      case ParserPackage.EXTERNAL_DECLARATION__DECLARATION:
        return declaration != null;
      case ParserPackage.EXTERNAL_DECLARATION__SEMI:
        return SEMI_EDEFAULT == null ? semi != null : !SEMI_EDEFAULT.equals(semi);
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
    result.append(" (semi: ");
    result.append(semi);
    result.append(')');
    return result.toString();
  }

} //ExternalDeclarationImpl
