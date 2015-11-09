/**
 */
package at.jku.weiner.cpreprocess.cPreprocess.impl;

import at.jku.weiner.cpreprocess.cPreprocess.CPreprocessPackage;
import at.jku.weiner.cpreprocess.cPreprocess.IncludeDirective;
import at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Preprocessor Directives</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.cpreprocess.cPreprocess.impl.PreprocessorDirectivesImpl#getDirective <em>Directive</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PreprocessorDirectivesImpl extends SourceCodeLineImpl implements PreprocessorDirectives
{
  /**
   * The cached value of the '{@link #getDirective() <em>Directive</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirective()
   * @generated
   * @ordered
   */
  protected IncludeDirective directive;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PreprocessorDirectivesImpl()
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
    return CPreprocessPackage.Literals.PREPROCESSOR_DIRECTIVES;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IncludeDirective getDirective()
  {
    return directive;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDirective(IncludeDirective newDirective, NotificationChain msgs)
  {
    IncludeDirective oldDirective = directive;
    directive = newDirective;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CPreprocessPackage.PREPROCESSOR_DIRECTIVES__DIRECTIVE, oldDirective, newDirective);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDirective(IncludeDirective newDirective)
  {
    if (newDirective != directive)
    {
      NotificationChain msgs = null;
      if (directive != null)
        msgs = ((InternalEObject)directive).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CPreprocessPackage.PREPROCESSOR_DIRECTIVES__DIRECTIVE, null, msgs);
      if (newDirective != null)
        msgs = ((InternalEObject)newDirective).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CPreprocessPackage.PREPROCESSOR_DIRECTIVES__DIRECTIVE, null, msgs);
      msgs = basicSetDirective(newDirective, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPreprocessPackage.PREPROCESSOR_DIRECTIVES__DIRECTIVE, newDirective, newDirective));
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
      case CPreprocessPackage.PREPROCESSOR_DIRECTIVES__DIRECTIVE:
        return basicSetDirective(null, msgs);
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
      case CPreprocessPackage.PREPROCESSOR_DIRECTIVES__DIRECTIVE:
        return getDirective();
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
      case CPreprocessPackage.PREPROCESSOR_DIRECTIVES__DIRECTIVE:
        setDirective((IncludeDirective)newValue);
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
      case CPreprocessPackage.PREPROCESSOR_DIRECTIVES__DIRECTIVE:
        setDirective((IncludeDirective)null);
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
      case CPreprocessPackage.PREPROCESSOR_DIRECTIVES__DIRECTIVE:
        return directive != null;
    }
    return super.eIsSet(featureID);
  }

} //PreprocessorDirectivesImpl
