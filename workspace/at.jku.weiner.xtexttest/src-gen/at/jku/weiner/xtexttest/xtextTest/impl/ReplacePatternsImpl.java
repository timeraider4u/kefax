/**
 */
package at.jku.weiner.xtexttest.xtextTest.impl;

import at.jku.weiner.xtexttest.xtextTest.ReplacePatterns;
import at.jku.weiner.xtexttest.xtextTest.XtextTestPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Replace Patterns</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.ReplacePatternsImpl#getRegex <em>Regex</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.ReplacePatternsImpl#getReplace <em>Replace</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReplacePatternsImpl extends MinimalEObjectImpl.Container implements ReplacePatterns
{
  /**
   * The default value of the '{@link #getRegex() <em>Regex</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRegex()
   * @generated
   * @ordered
   */
  protected static final String REGEX_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRegex() <em>Regex</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRegex()
   * @generated
   * @ordered
   */
  protected String regex = REGEX_EDEFAULT;

  /**
   * The default value of the '{@link #getReplace() <em>Replace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReplace()
   * @generated
   * @ordered
   */
  protected static final String REPLACE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getReplace() <em>Replace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReplace()
   * @generated
   * @ordered
   */
  protected String replace = REPLACE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReplacePatternsImpl()
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
    return XtextTestPackage.Literals.REPLACE_PATTERNS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRegex()
  {
    return regex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRegex(String newRegex)
  {
    String oldRegex = regex;
    regex = newRegex;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.REPLACE_PATTERNS__REGEX, oldRegex, regex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getReplace()
  {
    return replace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReplace(String newReplace)
  {
    String oldReplace = replace;
    replace = newReplace;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.REPLACE_PATTERNS__REPLACE, oldReplace, replace));
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
      case XtextTestPackage.REPLACE_PATTERNS__REGEX:
        return getRegex();
      case XtextTestPackage.REPLACE_PATTERNS__REPLACE:
        return getReplace();
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
      case XtextTestPackage.REPLACE_PATTERNS__REGEX:
        setRegex((String)newValue);
        return;
      case XtextTestPackage.REPLACE_PATTERNS__REPLACE:
        setReplace((String)newValue);
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
      case XtextTestPackage.REPLACE_PATTERNS__REGEX:
        setRegex(REGEX_EDEFAULT);
        return;
      case XtextTestPackage.REPLACE_PATTERNS__REPLACE:
        setReplace(REPLACE_EDEFAULT);
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
      case XtextTestPackage.REPLACE_PATTERNS__REGEX:
        return REGEX_EDEFAULT == null ? regex != null : !REGEX_EDEFAULT.equals(regex);
      case XtextTestPackage.REPLACE_PATTERNS__REPLACE:
        return REPLACE_EDEFAULT == null ? replace != null : !REPLACE_EDEFAULT.equals(replace);
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
    result.append(" (regex: ");
    result.append(regex);
    result.append(", replace: ");
    result.append(replace);
    result.append(')');
    return result.toString();
  }

} //ReplacePatternsImpl
