/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.GccAttributeSpecifier;
import at.jku.weiner.c.parser.parser.GccDeclaratorExtension;
import at.jku.weiner.c.parser.parser.ParserPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gcc Declarator Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.GccDeclaratorExtensionImpl#getAsm <em>Asm</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.GccDeclaratorExtensionImpl#getString <em>String</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.GccDeclaratorExtensionImpl#getGccAttributeSpecifier <em>Gcc Attribute Specifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GccDeclaratorExtensionImpl extends MinimalEObjectImpl.Container implements GccDeclaratorExtension
{
  /**
   * The default value of the '{@link #getAsm() <em>Asm</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAsm()
   * @generated
   * @ordered
   */
  protected static final String ASM_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAsm() <em>Asm</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAsm()
   * @generated
   * @ordered
   */
  protected String asm = ASM_EDEFAULT;

  /**
   * The cached value of the '{@link #getString() <em>String</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getString()
   * @generated
   * @ordered
   */
  protected EList<String> string;

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
  protected GccDeclaratorExtensionImpl()
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
    return ParserPackage.Literals.GCC_DECLARATOR_EXTENSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAsm()
  {
    return asm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAsm(String newAsm)
  {
    String oldAsm = asm;
    asm = newAsm;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.GCC_DECLARATOR_EXTENSION__ASM, oldAsm, asm));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getString()
  {
    if (string == null)
    {
      string = new EDataTypeEList<String>(String.class, this, ParserPackage.GCC_DECLARATOR_EXTENSION__STRING);
    }
    return string;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.GCC_DECLARATOR_EXTENSION__GCC_ATTRIBUTE_SPECIFIER, oldGccAttributeSpecifier, newGccAttributeSpecifier);
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
        msgs = ((InternalEObject)gccAttributeSpecifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.GCC_DECLARATOR_EXTENSION__GCC_ATTRIBUTE_SPECIFIER, null, msgs);
      if (newGccAttributeSpecifier != null)
        msgs = ((InternalEObject)newGccAttributeSpecifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.GCC_DECLARATOR_EXTENSION__GCC_ATTRIBUTE_SPECIFIER, null, msgs);
      msgs = basicSetGccAttributeSpecifier(newGccAttributeSpecifier, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.GCC_DECLARATOR_EXTENSION__GCC_ATTRIBUTE_SPECIFIER, newGccAttributeSpecifier, newGccAttributeSpecifier));
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
      case ParserPackage.GCC_DECLARATOR_EXTENSION__GCC_ATTRIBUTE_SPECIFIER:
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
      case ParserPackage.GCC_DECLARATOR_EXTENSION__ASM:
        return getAsm();
      case ParserPackage.GCC_DECLARATOR_EXTENSION__STRING:
        return getString();
      case ParserPackage.GCC_DECLARATOR_EXTENSION__GCC_ATTRIBUTE_SPECIFIER:
        return getGccAttributeSpecifier();
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
      case ParserPackage.GCC_DECLARATOR_EXTENSION__ASM:
        setAsm((String)newValue);
        return;
      case ParserPackage.GCC_DECLARATOR_EXTENSION__STRING:
        getString().clear();
        getString().addAll((Collection<? extends String>)newValue);
        return;
      case ParserPackage.GCC_DECLARATOR_EXTENSION__GCC_ATTRIBUTE_SPECIFIER:
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
      case ParserPackage.GCC_DECLARATOR_EXTENSION__ASM:
        setAsm(ASM_EDEFAULT);
        return;
      case ParserPackage.GCC_DECLARATOR_EXTENSION__STRING:
        getString().clear();
        return;
      case ParserPackage.GCC_DECLARATOR_EXTENSION__GCC_ATTRIBUTE_SPECIFIER:
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
      case ParserPackage.GCC_DECLARATOR_EXTENSION__ASM:
        return ASM_EDEFAULT == null ? asm != null : !ASM_EDEFAULT.equals(asm);
      case ParserPackage.GCC_DECLARATOR_EXTENSION__STRING:
        return string != null && !string.isEmpty();
      case ParserPackage.GCC_DECLARATOR_EXTENSION__GCC_ATTRIBUTE_SPECIFIER:
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
    result.append(" (asm: ");
    result.append(asm);
    result.append(", string: ");
    result.append(string);
    result.append(')');
    return result.toString();
  }

} //GccDeclaratorExtensionImpl
