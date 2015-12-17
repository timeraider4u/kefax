/**
 */
package at.jku.weiner.c.preprocess.preprocess.impl;

import at.jku.weiner.c.preprocess.preprocess.ArgumentExpressionList;
import at.jku.weiner.c.preprocess.preprocess.PostfixExpressionSuffixArgument;
import at.jku.weiner.c.preprocess.preprocess.PreprocessPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Postfix Expression Suffix Argument</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.PostfixExpressionSuffixArgumentImpl#getArgumentExpressionList <em>Argument Expression List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PostfixExpressionSuffixArgumentImpl extends PostfixExpressionSuffixImpl implements PostfixExpressionSuffixArgument
{
  /**
   * The cached value of the '{@link #getArgumentExpressionList() <em>Argument Expression List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgumentExpressionList()
   * @generated
   * @ordered
   */
  protected ArgumentExpressionList argumentExpressionList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PostfixExpressionSuffixArgumentImpl()
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
    return PreprocessPackage.Literals.POSTFIX_EXPRESSION_SUFFIX_ARGUMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArgumentExpressionList getArgumentExpressionList()
  {
    return argumentExpressionList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArgumentExpressionList(ArgumentExpressionList newArgumentExpressionList, NotificationChain msgs)
  {
    ArgumentExpressionList oldArgumentExpressionList = argumentExpressionList;
    argumentExpressionList = newArgumentExpressionList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PreprocessPackage.POSTFIX_EXPRESSION_SUFFIX_ARGUMENT__ARGUMENT_EXPRESSION_LIST, oldArgumentExpressionList, newArgumentExpressionList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArgumentExpressionList(ArgumentExpressionList newArgumentExpressionList)
  {
    if (newArgumentExpressionList != argumentExpressionList)
    {
      NotificationChain msgs = null;
      if (argumentExpressionList != null)
        msgs = ((InternalEObject)argumentExpressionList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PreprocessPackage.POSTFIX_EXPRESSION_SUFFIX_ARGUMENT__ARGUMENT_EXPRESSION_LIST, null, msgs);
      if (newArgumentExpressionList != null)
        msgs = ((InternalEObject)newArgumentExpressionList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PreprocessPackage.POSTFIX_EXPRESSION_SUFFIX_ARGUMENT__ARGUMENT_EXPRESSION_LIST, null, msgs);
      msgs = basicSetArgumentExpressionList(newArgumentExpressionList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PreprocessPackage.POSTFIX_EXPRESSION_SUFFIX_ARGUMENT__ARGUMENT_EXPRESSION_LIST, newArgumentExpressionList, newArgumentExpressionList));
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
      case PreprocessPackage.POSTFIX_EXPRESSION_SUFFIX_ARGUMENT__ARGUMENT_EXPRESSION_LIST:
        return basicSetArgumentExpressionList(null, msgs);
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
      case PreprocessPackage.POSTFIX_EXPRESSION_SUFFIX_ARGUMENT__ARGUMENT_EXPRESSION_LIST:
        return getArgumentExpressionList();
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
      case PreprocessPackage.POSTFIX_EXPRESSION_SUFFIX_ARGUMENT__ARGUMENT_EXPRESSION_LIST:
        setArgumentExpressionList((ArgumentExpressionList)newValue);
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
      case PreprocessPackage.POSTFIX_EXPRESSION_SUFFIX_ARGUMENT__ARGUMENT_EXPRESSION_LIST:
        setArgumentExpressionList((ArgumentExpressionList)null);
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
      case PreprocessPackage.POSTFIX_EXPRESSION_SUFFIX_ARGUMENT__ARGUMENT_EXPRESSION_LIST:
        return argumentExpressionList != null;
    }
    return super.eIsSet(featureID);
  }

} //PostfixExpressionSuffixArgumentImpl
