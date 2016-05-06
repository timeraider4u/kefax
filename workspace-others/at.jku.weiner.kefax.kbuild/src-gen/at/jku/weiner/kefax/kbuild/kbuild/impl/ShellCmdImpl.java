/**
 */
package at.jku.weiner.kefax.kbuild.kbuild.impl;

import at.jku.weiner.kefax.kbuild.kbuild.KbuildPackage;
import at.jku.weiner.kefax.kbuild.kbuild.ShellCmd;
import at.jku.weiner.kefax.kbuild.kbuild.ShellPart;

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
 * An implementation of the model object '<em><b>Shell Cmd</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ShellCmdImpl#getName <em>Name</em>}</li>
 *   <li>{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ShellCmdImpl#getShellPart <em>Shell Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ShellCmdImpl extends MinimalEObjectImpl.Container implements ShellCmd
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
   * The cached value of the '{@link #getShellPart() <em>Shell Part</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShellPart()
   * @generated
   * @ordered
   */
  protected EList<ShellPart> shellPart;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ShellCmdImpl()
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
    return KbuildPackage.Literals.SHELL_CMD;
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
      eNotify(new ENotificationImpl(this, Notification.SET, KbuildPackage.SHELL_CMD__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ShellPart> getShellPart()
  {
    if (shellPart == null)
    {
      shellPart = new EObjectContainmentEList<ShellPart>(ShellPart.class, this, KbuildPackage.SHELL_CMD__SHELL_PART);
    }
    return shellPart;
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
      case KbuildPackage.SHELL_CMD__SHELL_PART:
        return ((InternalEList<?>)getShellPart()).basicRemove(otherEnd, msgs);
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
      case KbuildPackage.SHELL_CMD__NAME:
        return getName();
      case KbuildPackage.SHELL_CMD__SHELL_PART:
        return getShellPart();
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
      case KbuildPackage.SHELL_CMD__NAME:
        setName((String)newValue);
        return;
      case KbuildPackage.SHELL_CMD__SHELL_PART:
        getShellPart().clear();
        getShellPart().addAll((Collection<? extends ShellPart>)newValue);
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
      case KbuildPackage.SHELL_CMD__NAME:
        setName(NAME_EDEFAULT);
        return;
      case KbuildPackage.SHELL_CMD__SHELL_PART:
        getShellPart().clear();
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
      case KbuildPackage.SHELL_CMD__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case KbuildPackage.SHELL_CMD__SHELL_PART:
        return shellPart != null && !shellPart.isEmpty();
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

} //ShellCmdImpl
