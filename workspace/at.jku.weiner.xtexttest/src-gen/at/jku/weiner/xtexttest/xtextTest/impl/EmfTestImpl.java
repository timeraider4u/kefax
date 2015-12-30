/**
 */
package at.jku.weiner.xtexttest.xtextTest.impl;

import at.jku.weiner.xtexttest.xtextTest.CodeCall;
import at.jku.weiner.xtexttest.xtextTest.Element;
import at.jku.weiner.xtexttest.xtextTest.EmfTest;
import at.jku.weiner.xtexttest.xtextTest.Import;
import at.jku.weiner.xtexttest.xtextTest.XtextTestPackage;

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
 * An implementation of the model object '<em><b>Emf Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.EmfTestImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.EmfTestImpl#getMydefault <em>Mydefault</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.EmfTestImpl#getMyimport <em>Myimport</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.EmfTestImpl#getCodeCall <em>Code Call</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.EmfTestImpl#getFile <em>File</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.EmfTestImpl#getRoot <em>Root</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EmfTestImpl extends MinimalEObjectImpl.Container implements EmfTest
{
  /**
   * The default value of the '{@link #getPackage() <em>Package</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackage()
   * @generated
   * @ordered
   */
  protected static final String PACKAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPackage() <em>Package</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackage()
   * @generated
   * @ordered
   */
  protected String package_ = PACKAGE_EDEFAULT;

  /**
   * The default value of the '{@link #getMydefault() <em>Mydefault</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMydefault()
   * @generated
   * @ordered
   */
  protected static final String MYDEFAULT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMydefault() <em>Mydefault</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMydefault()
   * @generated
   * @ordered
   */
  protected String mydefault = MYDEFAULT_EDEFAULT;

  /**
   * The cached value of the '{@link #getMyimport() <em>Myimport</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMyimport()
   * @generated
   * @ordered
   */
  protected EList<Import> myimport;

  /**
   * The cached value of the '{@link #getCodeCall() <em>Code Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCodeCall()
   * @generated
   * @ordered
   */
  protected CodeCall codeCall;

  /**
   * The default value of the '{@link #getFile() <em>File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFile()
   * @generated
   * @ordered
   */
  protected static final String FILE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFile() <em>File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFile()
   * @generated
   * @ordered
   */
  protected String file = FILE_EDEFAULT;

  /**
   * The cached value of the '{@link #getRoot() <em>Root</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRoot()
   * @generated
   * @ordered
   */
  protected Element root;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EmfTestImpl()
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
    return XtextTestPackage.Literals.EMF_TEST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPackage()
  {
    return package_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPackage(String newPackage)
  {
    String oldPackage = package_;
    package_ = newPackage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.EMF_TEST__PACKAGE, oldPackage, package_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMydefault()
  {
    return mydefault;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMydefault(String newMydefault)
  {
    String oldMydefault = mydefault;
    mydefault = newMydefault;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.EMF_TEST__MYDEFAULT, oldMydefault, mydefault));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Import> getMyimport()
  {
    if (myimport == null)
    {
      myimport = new EObjectContainmentEList<Import>(Import.class, this, XtextTestPackage.EMF_TEST__MYIMPORT);
    }
    return myimport;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CodeCall getCodeCall()
  {
    return codeCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCodeCall(CodeCall newCodeCall, NotificationChain msgs)
  {
    CodeCall oldCodeCall = codeCall;
    codeCall = newCodeCall;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtextTestPackage.EMF_TEST__CODE_CALL, oldCodeCall, newCodeCall);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCodeCall(CodeCall newCodeCall)
  {
    if (newCodeCall != codeCall)
    {
      NotificationChain msgs = null;
      if (codeCall != null)
        msgs = ((InternalEObject)codeCall).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.EMF_TEST__CODE_CALL, null, msgs);
      if (newCodeCall != null)
        msgs = ((InternalEObject)newCodeCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.EMF_TEST__CODE_CALL, null, msgs);
      msgs = basicSetCodeCall(newCodeCall, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.EMF_TEST__CODE_CALL, newCodeCall, newCodeCall));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFile()
  {
    return file;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFile(String newFile)
  {
    String oldFile = file;
    file = newFile;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.EMF_TEST__FILE, oldFile, file));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Element getRoot()
  {
    return root;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRoot(Element newRoot, NotificationChain msgs)
  {
    Element oldRoot = root;
    root = newRoot;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtextTestPackage.EMF_TEST__ROOT, oldRoot, newRoot);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRoot(Element newRoot)
  {
    if (newRoot != root)
    {
      NotificationChain msgs = null;
      if (root != null)
        msgs = ((InternalEObject)root).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.EMF_TEST__ROOT, null, msgs);
      if (newRoot != null)
        msgs = ((InternalEObject)newRoot).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.EMF_TEST__ROOT, null, msgs);
      msgs = basicSetRoot(newRoot, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.EMF_TEST__ROOT, newRoot, newRoot));
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
      case XtextTestPackage.EMF_TEST__MYIMPORT:
        return ((InternalEList<?>)getMyimport()).basicRemove(otherEnd, msgs);
      case XtextTestPackage.EMF_TEST__CODE_CALL:
        return basicSetCodeCall(null, msgs);
      case XtextTestPackage.EMF_TEST__ROOT:
        return basicSetRoot(null, msgs);
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
      case XtextTestPackage.EMF_TEST__PACKAGE:
        return getPackage();
      case XtextTestPackage.EMF_TEST__MYDEFAULT:
        return getMydefault();
      case XtextTestPackage.EMF_TEST__MYIMPORT:
        return getMyimport();
      case XtextTestPackage.EMF_TEST__CODE_CALL:
        return getCodeCall();
      case XtextTestPackage.EMF_TEST__FILE:
        return getFile();
      case XtextTestPackage.EMF_TEST__ROOT:
        return getRoot();
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
      case XtextTestPackage.EMF_TEST__PACKAGE:
        setPackage((String)newValue);
        return;
      case XtextTestPackage.EMF_TEST__MYDEFAULT:
        setMydefault((String)newValue);
        return;
      case XtextTestPackage.EMF_TEST__MYIMPORT:
        getMyimport().clear();
        getMyimport().addAll((Collection<? extends Import>)newValue);
        return;
      case XtextTestPackage.EMF_TEST__CODE_CALL:
        setCodeCall((CodeCall)newValue);
        return;
      case XtextTestPackage.EMF_TEST__FILE:
        setFile((String)newValue);
        return;
      case XtextTestPackage.EMF_TEST__ROOT:
        setRoot((Element)newValue);
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
      case XtextTestPackage.EMF_TEST__PACKAGE:
        setPackage(PACKAGE_EDEFAULT);
        return;
      case XtextTestPackage.EMF_TEST__MYDEFAULT:
        setMydefault(MYDEFAULT_EDEFAULT);
        return;
      case XtextTestPackage.EMF_TEST__MYIMPORT:
        getMyimport().clear();
        return;
      case XtextTestPackage.EMF_TEST__CODE_CALL:
        setCodeCall((CodeCall)null);
        return;
      case XtextTestPackage.EMF_TEST__FILE:
        setFile(FILE_EDEFAULT);
        return;
      case XtextTestPackage.EMF_TEST__ROOT:
        setRoot((Element)null);
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
      case XtextTestPackage.EMF_TEST__PACKAGE:
        return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
      case XtextTestPackage.EMF_TEST__MYDEFAULT:
        return MYDEFAULT_EDEFAULT == null ? mydefault != null : !MYDEFAULT_EDEFAULT.equals(mydefault);
      case XtextTestPackage.EMF_TEST__MYIMPORT:
        return myimport != null && !myimport.isEmpty();
      case XtextTestPackage.EMF_TEST__CODE_CALL:
        return codeCall != null;
      case XtextTestPackage.EMF_TEST__FILE:
        return FILE_EDEFAULT == null ? file != null : !FILE_EDEFAULT.equals(file);
      case XtextTestPackage.EMF_TEST__ROOT:
        return root != null;
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
    result.append(" (package: ");
    result.append(package_);
    result.append(", mydefault: ");
    result.append(mydefault);
    result.append(", file: ");
    result.append(file);
    result.append(')');
    return result.toString();
  }

} //EmfTestImpl
