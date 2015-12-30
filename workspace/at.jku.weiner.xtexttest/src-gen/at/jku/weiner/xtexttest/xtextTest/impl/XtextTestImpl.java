/**
 */
package at.jku.weiner.xtexttest.xtextTest.impl;

import at.jku.weiner.xtexttest.xtextTest.After;
import at.jku.weiner.xtexttest.xtextTest.Before;
import at.jku.weiner.xtexttest.xtextTest.Element;
import at.jku.weiner.xtexttest.xtextTest.Generator;
import at.jku.weiner.xtexttest.xtextTest.Input;
import at.jku.weiner.xtexttest.xtextTest.Tokens;
import at.jku.weiner.xtexttest.xtextTest.XtextTest;
import at.jku.weiner.xtexttest.xtextTest.XtextTestPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Xtext Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.XtextTestImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.XtextTestImpl#getLang <em>Lang</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.XtextTestImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.XtextTestImpl#getBoolean <em>Boolean</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.XtextTestImpl#getInput <em>Input</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.XtextTestImpl#getTokens <em>Tokens</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.XtextTestImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.XtextTestImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.XtextTestImpl#getBefore <em>Before</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.XtextTestImpl#getAfter <em>After</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XtextTestImpl extends MinimalEObjectImpl.Container implements XtextTest
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
   * The default value of the '{@link #getLang() <em>Lang</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLang()
   * @generated
   * @ordered
   */
  protected static final String LANG_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLang() <em>Lang</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLang()
   * @generated
   * @ordered
   */
  protected String lang = LANG_EDEFAULT;

  /**
   * The default value of the '{@link #getImports() <em>Imports</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected static final String IMPORTS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getImports() <em>Imports</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected String imports = IMPORTS_EDEFAULT;

  /**
   * The default value of the '{@link #getBoolean() <em>Boolean</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBoolean()
   * @generated
   * @ordered
   */
  protected static final String BOOLEAN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBoolean() <em>Boolean</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBoolean()
   * @generated
   * @ordered
   */
  protected String boolean_ = BOOLEAN_EDEFAULT;

  /**
   * The cached value of the '{@link #getInput() <em>Input</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInput()
   * @generated
   * @ordered
   */
  protected Input input;

  /**
   * The cached value of the '{@link #getTokens() <em>Tokens</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTokens()
   * @generated
   * @ordered
   */
  protected Tokens tokens;

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
   * The cached value of the '{@link #getOutput() <em>Output</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutput()
   * @generated
   * @ordered
   */
  protected Generator output;

  /**
   * The cached value of the '{@link #getBefore() <em>Before</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBefore()
   * @generated
   * @ordered
   */
  protected Before before;

  /**
   * The cached value of the '{@link #getAfter() <em>After</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAfter()
   * @generated
   * @ordered
   */
  protected After after;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XtextTestImpl()
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
    return XtextTestPackage.Literals.XTEXT_TEST;
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
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.XTEXT_TEST__PACKAGE, oldPackage, package_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLang()
  {
    return lang;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLang(String newLang)
  {
    String oldLang = lang;
    lang = newLang;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.XTEXT_TEST__LANG, oldLang, lang));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getImports()
  {
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImports(String newImports)
  {
    String oldImports = imports;
    imports = newImports;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.XTEXT_TEST__IMPORTS, oldImports, imports));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBoolean()
  {
    return boolean_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBoolean(String newBoolean)
  {
    String oldBoolean = boolean_;
    boolean_ = newBoolean;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.XTEXT_TEST__BOOLEAN, oldBoolean, boolean_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Input getInput()
  {
    return input;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInput(Input newInput, NotificationChain msgs)
  {
    Input oldInput = input;
    input = newInput;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtextTestPackage.XTEXT_TEST__INPUT, oldInput, newInput);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInput(Input newInput)
  {
    if (newInput != input)
    {
      NotificationChain msgs = null;
      if (input != null)
        msgs = ((InternalEObject)input).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.XTEXT_TEST__INPUT, null, msgs);
      if (newInput != null)
        msgs = ((InternalEObject)newInput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.XTEXT_TEST__INPUT, null, msgs);
      msgs = basicSetInput(newInput, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.XTEXT_TEST__INPUT, newInput, newInput));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tokens getTokens()
  {
    return tokens;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTokens(Tokens newTokens, NotificationChain msgs)
  {
    Tokens oldTokens = tokens;
    tokens = newTokens;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtextTestPackage.XTEXT_TEST__TOKENS, oldTokens, newTokens);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTokens(Tokens newTokens)
  {
    if (newTokens != tokens)
    {
      NotificationChain msgs = null;
      if (tokens != null)
        msgs = ((InternalEObject)tokens).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.XTEXT_TEST__TOKENS, null, msgs);
      if (newTokens != null)
        msgs = ((InternalEObject)newTokens).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.XTEXT_TEST__TOKENS, null, msgs);
      msgs = basicSetTokens(newTokens, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.XTEXT_TEST__TOKENS, newTokens, newTokens));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtextTestPackage.XTEXT_TEST__ROOT, oldRoot, newRoot);
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
        msgs = ((InternalEObject)root).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.XTEXT_TEST__ROOT, null, msgs);
      if (newRoot != null)
        msgs = ((InternalEObject)newRoot).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.XTEXT_TEST__ROOT, null, msgs);
      msgs = basicSetRoot(newRoot, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.XTEXT_TEST__ROOT, newRoot, newRoot));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Generator getOutput()
  {
    return output;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOutput(Generator newOutput, NotificationChain msgs)
  {
    Generator oldOutput = output;
    output = newOutput;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtextTestPackage.XTEXT_TEST__OUTPUT, oldOutput, newOutput);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOutput(Generator newOutput)
  {
    if (newOutput != output)
    {
      NotificationChain msgs = null;
      if (output != null)
        msgs = ((InternalEObject)output).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.XTEXT_TEST__OUTPUT, null, msgs);
      if (newOutput != null)
        msgs = ((InternalEObject)newOutput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.XTEXT_TEST__OUTPUT, null, msgs);
      msgs = basicSetOutput(newOutput, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.XTEXT_TEST__OUTPUT, newOutput, newOutput));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Before getBefore()
  {
    return before;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBefore(Before newBefore, NotificationChain msgs)
  {
    Before oldBefore = before;
    before = newBefore;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtextTestPackage.XTEXT_TEST__BEFORE, oldBefore, newBefore);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBefore(Before newBefore)
  {
    if (newBefore != before)
    {
      NotificationChain msgs = null;
      if (before != null)
        msgs = ((InternalEObject)before).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.XTEXT_TEST__BEFORE, null, msgs);
      if (newBefore != null)
        msgs = ((InternalEObject)newBefore).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.XTEXT_TEST__BEFORE, null, msgs);
      msgs = basicSetBefore(newBefore, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.XTEXT_TEST__BEFORE, newBefore, newBefore));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public After getAfter()
  {
    return after;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAfter(After newAfter, NotificationChain msgs)
  {
    After oldAfter = after;
    after = newAfter;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtextTestPackage.XTEXT_TEST__AFTER, oldAfter, newAfter);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAfter(After newAfter)
  {
    if (newAfter != after)
    {
      NotificationChain msgs = null;
      if (after != null)
        msgs = ((InternalEObject)after).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.XTEXT_TEST__AFTER, null, msgs);
      if (newAfter != null)
        msgs = ((InternalEObject)newAfter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.XTEXT_TEST__AFTER, null, msgs);
      msgs = basicSetAfter(newAfter, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.XTEXT_TEST__AFTER, newAfter, newAfter));
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
      case XtextTestPackage.XTEXT_TEST__INPUT:
        return basicSetInput(null, msgs);
      case XtextTestPackage.XTEXT_TEST__TOKENS:
        return basicSetTokens(null, msgs);
      case XtextTestPackage.XTEXT_TEST__ROOT:
        return basicSetRoot(null, msgs);
      case XtextTestPackage.XTEXT_TEST__OUTPUT:
        return basicSetOutput(null, msgs);
      case XtextTestPackage.XTEXT_TEST__BEFORE:
        return basicSetBefore(null, msgs);
      case XtextTestPackage.XTEXT_TEST__AFTER:
        return basicSetAfter(null, msgs);
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
      case XtextTestPackage.XTEXT_TEST__PACKAGE:
        return getPackage();
      case XtextTestPackage.XTEXT_TEST__LANG:
        return getLang();
      case XtextTestPackage.XTEXT_TEST__IMPORTS:
        return getImports();
      case XtextTestPackage.XTEXT_TEST__BOOLEAN:
        return getBoolean();
      case XtextTestPackage.XTEXT_TEST__INPUT:
        return getInput();
      case XtextTestPackage.XTEXT_TEST__TOKENS:
        return getTokens();
      case XtextTestPackage.XTEXT_TEST__ROOT:
        return getRoot();
      case XtextTestPackage.XTEXT_TEST__OUTPUT:
        return getOutput();
      case XtextTestPackage.XTEXT_TEST__BEFORE:
        return getBefore();
      case XtextTestPackage.XTEXT_TEST__AFTER:
        return getAfter();
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
      case XtextTestPackage.XTEXT_TEST__PACKAGE:
        setPackage((String)newValue);
        return;
      case XtextTestPackage.XTEXT_TEST__LANG:
        setLang((String)newValue);
        return;
      case XtextTestPackage.XTEXT_TEST__IMPORTS:
        setImports((String)newValue);
        return;
      case XtextTestPackage.XTEXT_TEST__BOOLEAN:
        setBoolean((String)newValue);
        return;
      case XtextTestPackage.XTEXT_TEST__INPUT:
        setInput((Input)newValue);
        return;
      case XtextTestPackage.XTEXT_TEST__TOKENS:
        setTokens((Tokens)newValue);
        return;
      case XtextTestPackage.XTEXT_TEST__ROOT:
        setRoot((Element)newValue);
        return;
      case XtextTestPackage.XTEXT_TEST__OUTPUT:
        setOutput((Generator)newValue);
        return;
      case XtextTestPackage.XTEXT_TEST__BEFORE:
        setBefore((Before)newValue);
        return;
      case XtextTestPackage.XTEXT_TEST__AFTER:
        setAfter((After)newValue);
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
      case XtextTestPackage.XTEXT_TEST__PACKAGE:
        setPackage(PACKAGE_EDEFAULT);
        return;
      case XtextTestPackage.XTEXT_TEST__LANG:
        setLang(LANG_EDEFAULT);
        return;
      case XtextTestPackage.XTEXT_TEST__IMPORTS:
        setImports(IMPORTS_EDEFAULT);
        return;
      case XtextTestPackage.XTEXT_TEST__BOOLEAN:
        setBoolean(BOOLEAN_EDEFAULT);
        return;
      case XtextTestPackage.XTEXT_TEST__INPUT:
        setInput((Input)null);
        return;
      case XtextTestPackage.XTEXT_TEST__TOKENS:
        setTokens((Tokens)null);
        return;
      case XtextTestPackage.XTEXT_TEST__ROOT:
        setRoot((Element)null);
        return;
      case XtextTestPackage.XTEXT_TEST__OUTPUT:
        setOutput((Generator)null);
        return;
      case XtextTestPackage.XTEXT_TEST__BEFORE:
        setBefore((Before)null);
        return;
      case XtextTestPackage.XTEXT_TEST__AFTER:
        setAfter((After)null);
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
      case XtextTestPackage.XTEXT_TEST__PACKAGE:
        return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
      case XtextTestPackage.XTEXT_TEST__LANG:
        return LANG_EDEFAULT == null ? lang != null : !LANG_EDEFAULT.equals(lang);
      case XtextTestPackage.XTEXT_TEST__IMPORTS:
        return IMPORTS_EDEFAULT == null ? imports != null : !IMPORTS_EDEFAULT.equals(imports);
      case XtextTestPackage.XTEXT_TEST__BOOLEAN:
        return BOOLEAN_EDEFAULT == null ? boolean_ != null : !BOOLEAN_EDEFAULT.equals(boolean_);
      case XtextTestPackage.XTEXT_TEST__INPUT:
        return input != null;
      case XtextTestPackage.XTEXT_TEST__TOKENS:
        return tokens != null;
      case XtextTestPackage.XTEXT_TEST__ROOT:
        return root != null;
      case XtextTestPackage.XTEXT_TEST__OUTPUT:
        return output != null;
      case XtextTestPackage.XTEXT_TEST__BEFORE:
        return before != null;
      case XtextTestPackage.XTEXT_TEST__AFTER:
        return after != null;
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
    result.append(", lang: ");
    result.append(lang);
    result.append(", imports: ");
    result.append(imports);
    result.append(", boolean: ");
    result.append(boolean_);
    result.append(')');
    return result.toString();
  }

} //XtextTestImpl
