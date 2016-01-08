/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.FunctionSpecifier;
import at.jku.weiner.c.parser.parser.GccAttributeSpecifier;
import at.jku.weiner.c.parser.parser.ParserPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.FunctionSpecifierImpl#getName <em>Name</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.FunctionSpecifierImpl#getGccAttributeSpecifier <em>Gcc Attribute Specifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionSpecifierImpl extends MinimalEObjectImpl.Container implements FunctionSpecifier
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getGccAttributeSpecifier() <em>Gcc Attribute Specifier</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGccAttributeSpecifier()
   * @generated
   * @ordered
   */
  protected GccAttributeSpecifier gccAttributeSpecifier;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FunctionSpecifierImpl()
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
    return ParserPackage.Literals.FUNCTION_SPECIFIER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.FUNCTION_SPECIFIER__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GccAttributeSpecifier getGccAttributeSpecifier()
  {
    return gccAttributeSpecifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGccAttributeSpecifier(GccAttributeSpecifier newGccAttributeSpecifier, NotificationChain msgs)
  {
    GccAttributeSpecifier oldGccAttributeSpecifier = gccAttributeSpecifier;
    gccAttributeSpecifier = newGccAttributeSpecifier;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.FUNCTION_SPECIFIER__GCC_ATTRIBUTE_SPECIFIER, oldGccAttributeSpecifier, newGccAttributeSpecifier);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGccAttributeSpecifier(GccAttributeSpecifier newGccAttributeSpecifier)
  {
    if (newGccAttributeSpecifier != gccAttributeSpecifier)
    {
      NotificationChain msgs = null;
      if (gccAttributeSpecifier != null)
        msgs = ((InternalEObject)gccAttributeSpecifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.FUNCTION_SPECIFIER__GCC_ATTRIBUTE_SPECIFIER, null, msgs);
      if (newGccAttributeSpecifier != null)
        msgs = ((InternalEObject)newGccAttributeSpecifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.FUNCTION_SPECIFIER__GCC_ATTRIBUTE_SPECIFIER, null, msgs);
      msgs = basicSetGccAttributeSpecifier(newGccAttributeSpecifier, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.FUNCTION_SPECIFIER__GCC_ATTRIBUTE_SPECIFIER, newGccAttributeSpecifier, newGccAttributeSpecifier));
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
      case ParserPackage.FUNCTION_SPECIFIER__GCC_ATTRIBUTE_SPECIFIER:
        return basicSetGccAttributeSpecifier(null, msgs);
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
      case ParserPackage.FUNCTION_SPECIFIER__NAME:
        return getName();
      case ParserPackage.FUNCTION_SPECIFIER__GCC_ATTRIBUTE_SPECIFIER:
        return getGccAttributeSpecifier();
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
      case ParserPackage.FUNCTION_SPECIFIER__NAME:
        setName((String)newValue);
        return;
      case ParserPackage.FUNCTION_SPECIFIER__GCC_ATTRIBUTE_SPECIFIER:
        setGccAttributeSpecifier((GccAttributeSpecifier)newValue);
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
      case ParserPackage.FUNCTION_SPECIFIER__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ParserPackage.FUNCTION_SPECIFIER__GCC_ATTRIBUTE_SPECIFIER:
        setGccAttributeSpecifier((GccAttributeSpecifier)null);
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
      case ParserPackage.FUNCTION_SPECIFIER__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ParserPackage.FUNCTION_SPECIFIER__GCC_ATTRIBUTE_SPECIFIER:
        return gccAttributeSpecifier != null;
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //FunctionSpecifierImpl
