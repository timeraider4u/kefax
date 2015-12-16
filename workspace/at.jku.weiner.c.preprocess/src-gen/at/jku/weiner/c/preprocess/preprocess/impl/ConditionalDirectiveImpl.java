/**
 */
package at.jku.weiner.c.preprocess.preprocess.impl;

import at.jku.weiner.c.preprocess.preprocess.ConditionalDirective;
import at.jku.weiner.c.preprocess.preprocess.ElIfConditional;
import at.jku.weiner.c.preprocess.preprocess.ElseConditional;
import at.jku.weiner.c.preprocess.preprocess.PreprocessPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Directive</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.ConditionalDirectiveImpl#getConditional <em>Conditional</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.ConditionalDirectiveImpl#getElifs <em>Elifs</em>}</li>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.ConditionalDirectiveImpl#getElse <em>Else</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionalDirectiveImpl extends MinimalEObjectImpl.Container implements ConditionalDirective
{
  /**
   * The cached value of the '{@link #getConditional() <em>Conditional</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConditional()
   * @generated
   * @ordered
   */
  protected EObject conditional;

  /**
   * The cached value of the '{@link #getElifs() <em>Elifs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElifs()
   * @generated
   * @ordered
   */
  protected EList<ElIfConditional> elifs;

  /**
   * The cached value of the '{@link #getElse() <em>Else</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElse()
   * @generated
   * @ordered
   */
  protected ElseConditional else_;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConditionalDirectiveImpl()
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
    return PreprocessPackage.Literals.CONDITIONAL_DIRECTIVE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getConditional()
  {
    return conditional;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConditional(EObject newConditional, NotificationChain msgs)
  {
    EObject oldConditional = conditional;
    conditional = newConditional;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PreprocessPackage.CONDITIONAL_DIRECTIVE__CONDITIONAL, oldConditional, newConditional);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConditional(EObject newConditional)
  {
    if (newConditional != conditional)
    {
      NotificationChain msgs = null;
      if (conditional != null)
        msgs = ((InternalEObject)conditional).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PreprocessPackage.CONDITIONAL_DIRECTIVE__CONDITIONAL, null, msgs);
      if (newConditional != null)
        msgs = ((InternalEObject)newConditional).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PreprocessPackage.CONDITIONAL_DIRECTIVE__CONDITIONAL, null, msgs);
      msgs = basicSetConditional(newConditional, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PreprocessPackage.CONDITIONAL_DIRECTIVE__CONDITIONAL, newConditional, newConditional));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ElIfConditional> getElifs()
  {
    if (elifs == null)
    {
      elifs = new EObjectContainmentEList<ElIfConditional>(ElIfConditional.class, this, PreprocessPackage.CONDITIONAL_DIRECTIVE__ELIFS);
    }
    return elifs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElseConditional getElse()
  {
    return else_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElse(ElseConditional newElse, NotificationChain msgs)
  {
    ElseConditional oldElse = else_;
    else_ = newElse;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PreprocessPackage.CONDITIONAL_DIRECTIVE__ELSE, oldElse, newElse);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElse(ElseConditional newElse)
  {
    if (newElse != else_)
    {
      NotificationChain msgs = null;
      if (else_ != null)
        msgs = ((InternalEObject)else_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PreprocessPackage.CONDITIONAL_DIRECTIVE__ELSE, null, msgs);
      if (newElse != null)
        msgs = ((InternalEObject)newElse).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PreprocessPackage.CONDITIONAL_DIRECTIVE__ELSE, null, msgs);
      msgs = basicSetElse(newElse, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PreprocessPackage.CONDITIONAL_DIRECTIVE__ELSE, newElse, newElse));
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
      case PreprocessPackage.CONDITIONAL_DIRECTIVE__CONDITIONAL:
        return basicSetConditional(null, msgs);
      case PreprocessPackage.CONDITIONAL_DIRECTIVE__ELIFS:
        return ((InternalEList<?>)getElifs()).basicRemove(otherEnd, msgs);
      case PreprocessPackage.CONDITIONAL_DIRECTIVE__ELSE:
        return basicSetElse(null, msgs);
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
      case PreprocessPackage.CONDITIONAL_DIRECTIVE__CONDITIONAL:
        return getConditional();
      case PreprocessPackage.CONDITIONAL_DIRECTIVE__ELIFS:
        return getElifs();
      case PreprocessPackage.CONDITIONAL_DIRECTIVE__ELSE:
        return getElse();
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
      case PreprocessPackage.CONDITIONAL_DIRECTIVE__CONDITIONAL:
        setConditional((EObject)newValue);
        return;
      case PreprocessPackage.CONDITIONAL_DIRECTIVE__ELIFS:
        getElifs().clear();
        getElifs().addAll((Collection<? extends ElIfConditional>)newValue);
        return;
      case PreprocessPackage.CONDITIONAL_DIRECTIVE__ELSE:
        setElse((ElseConditional)newValue);
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
      case PreprocessPackage.CONDITIONAL_DIRECTIVE__CONDITIONAL:
        setConditional((EObject)null);
        return;
      case PreprocessPackage.CONDITIONAL_DIRECTIVE__ELIFS:
        getElifs().clear();
        return;
      case PreprocessPackage.CONDITIONAL_DIRECTIVE__ELSE:
        setElse((ElseConditional)null);
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
      case PreprocessPackage.CONDITIONAL_DIRECTIVE__CONDITIONAL:
        return conditional != null;
      case PreprocessPackage.CONDITIONAL_DIRECTIVE__ELIFS:
        return elifs != null && !elifs.isEmpty();
      case PreprocessPackage.CONDITIONAL_DIRECTIVE__ELSE:
        return else_ != null;
    }
    return super.eIsSet(featureID);
  }

} //ConditionalDirectiveImpl
