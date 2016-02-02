/**
 */
package at.jku.weiner.c.parser.parser.impl;

import at.jku.weiner.c.parser.parser.AbstractDeclarator;
import at.jku.weiner.c.parser.parser.AbstractDeclaratorSuffix;
import at.jku.weiner.c.parser.parser.DirectAbstractDeclarator;
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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Direct Abstract Declarator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DirectAbstractDeclaratorImpl#getDeclarator <em>Declarator</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DirectAbstractDeclaratorImpl#getGccDeclExt <em>Gcc Decl Ext</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.impl.DirectAbstractDeclaratorImpl#getAbstractDeclaratorSuffix <em>Abstract Declarator Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DirectAbstractDeclaratorImpl extends MinimalEObjectImpl.Container implements DirectAbstractDeclarator
{
  /**
   * The cached value of the '{@link #getDeclarator() <em>Declarator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeclarator()
   * @generated
   * @ordered
   */
  protected AbstractDeclarator declarator;

  /**
   * The cached value of the '{@link #getGccDeclExt() <em>Gcc Decl Ext</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGccDeclExt()
   * @generated
   * @ordered
   */
  protected EList<GccDeclaratorExtension> gccDeclExt;

  /**
   * The cached value of the '{@link #getAbstractDeclaratorSuffix() <em>Abstract Declarator Suffix</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAbstractDeclaratorSuffix()
   * @generated
   * @ordered
   */
  protected EList<AbstractDeclaratorSuffix> abstractDeclaratorSuffix;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DirectAbstractDeclaratorImpl()
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
    return ParserPackage.Literals.DIRECT_ABSTRACT_DECLARATOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractDeclarator getDeclarator()
  {
    return declarator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDeclarator(AbstractDeclarator newDeclarator, NotificationChain msgs)
  {
    AbstractDeclarator oldDeclarator = declarator;
    declarator = newDeclarator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParserPackage.DIRECT_ABSTRACT_DECLARATOR__DECLARATOR, oldDeclarator, newDeclarator);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDeclarator(AbstractDeclarator newDeclarator)
  {
    if (newDeclarator != declarator)
    {
      NotificationChain msgs = null;
      if (declarator != null)
        msgs = ((InternalEObject)declarator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParserPackage.DIRECT_ABSTRACT_DECLARATOR__DECLARATOR, null, msgs);
      if (newDeclarator != null)
        msgs = ((InternalEObject)newDeclarator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParserPackage.DIRECT_ABSTRACT_DECLARATOR__DECLARATOR, null, msgs);
      msgs = basicSetDeclarator(newDeclarator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParserPackage.DIRECT_ABSTRACT_DECLARATOR__DECLARATOR, newDeclarator, newDeclarator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GccDeclaratorExtension> getGccDeclExt()
  {
    if (gccDeclExt == null)
    {
      gccDeclExt = new EObjectContainmentEList<GccDeclaratorExtension>(GccDeclaratorExtension.class, this, ParserPackage.DIRECT_ABSTRACT_DECLARATOR__GCC_DECL_EXT);
    }
    return gccDeclExt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AbstractDeclaratorSuffix> getAbstractDeclaratorSuffix()
  {
    if (abstractDeclaratorSuffix == null)
    {
      abstractDeclaratorSuffix = new EObjectContainmentEList<AbstractDeclaratorSuffix>(AbstractDeclaratorSuffix.class, this, ParserPackage.DIRECT_ABSTRACT_DECLARATOR__ABSTRACT_DECLARATOR_SUFFIX);
    }
    return abstractDeclaratorSuffix;
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
      case ParserPackage.DIRECT_ABSTRACT_DECLARATOR__DECLARATOR:
        return basicSetDeclarator(null, msgs);
      case ParserPackage.DIRECT_ABSTRACT_DECLARATOR__GCC_DECL_EXT:
        return ((InternalEList<?>)getGccDeclExt()).basicRemove(otherEnd, msgs);
      case ParserPackage.DIRECT_ABSTRACT_DECLARATOR__ABSTRACT_DECLARATOR_SUFFIX:
        return ((InternalEList<?>)getAbstractDeclaratorSuffix()).basicRemove(otherEnd, msgs);
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
      case ParserPackage.DIRECT_ABSTRACT_DECLARATOR__DECLARATOR:
        return getDeclarator();
      case ParserPackage.DIRECT_ABSTRACT_DECLARATOR__GCC_DECL_EXT:
        return getGccDeclExt();
      case ParserPackage.DIRECT_ABSTRACT_DECLARATOR__ABSTRACT_DECLARATOR_SUFFIX:
        return getAbstractDeclaratorSuffix();
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
      case ParserPackage.DIRECT_ABSTRACT_DECLARATOR__DECLARATOR:
        setDeclarator((AbstractDeclarator)newValue);
        return;
      case ParserPackage.DIRECT_ABSTRACT_DECLARATOR__GCC_DECL_EXT:
        getGccDeclExt().clear();
        getGccDeclExt().addAll((Collection<? extends GccDeclaratorExtension>)newValue);
        return;
      case ParserPackage.DIRECT_ABSTRACT_DECLARATOR__ABSTRACT_DECLARATOR_SUFFIX:
        getAbstractDeclaratorSuffix().clear();
        getAbstractDeclaratorSuffix().addAll((Collection<? extends AbstractDeclaratorSuffix>)newValue);
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
      case ParserPackage.DIRECT_ABSTRACT_DECLARATOR__DECLARATOR:
        setDeclarator((AbstractDeclarator)null);
        return;
      case ParserPackage.DIRECT_ABSTRACT_DECLARATOR__GCC_DECL_EXT:
        getGccDeclExt().clear();
        return;
      case ParserPackage.DIRECT_ABSTRACT_DECLARATOR__ABSTRACT_DECLARATOR_SUFFIX:
        getAbstractDeclaratorSuffix().clear();
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
      case ParserPackage.DIRECT_ABSTRACT_DECLARATOR__DECLARATOR:
        return declarator != null;
      case ParserPackage.DIRECT_ABSTRACT_DECLARATOR__GCC_DECL_EXT:
        return gccDeclExt != null && !gccDeclExt.isEmpty();
      case ParserPackage.DIRECT_ABSTRACT_DECLARATOR__ABSTRACT_DECLARATOR_SUFFIX:
        return abstractDeclaratorSuffix != null && !abstractDeclaratorSuffix.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //DirectAbstractDeclaratorImpl
