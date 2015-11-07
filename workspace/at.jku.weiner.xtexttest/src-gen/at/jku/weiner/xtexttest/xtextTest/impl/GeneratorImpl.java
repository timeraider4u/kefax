/**
 */
package at.jku.weiner.xtexttest.xtextTest.impl;

import at.jku.weiner.xtexttest.xtextTest.Generator;
import at.jku.weiner.xtexttest.xtextTest.XtextTestPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.GeneratorImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.GeneratorImpl#getExpected <em>Expected</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.impl.GeneratorImpl#isIsSameAsInputFile <em>Is Same As Input File</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GeneratorImpl extends MinimalEObjectImpl.Container implements Generator
{
  /**
   * The default value of the '{@link #getOutput() <em>Output</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutput()
   * @generated
   * @ordered
   */
  protected static final String OUTPUT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOutput() <em>Output</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutput()
   * @generated
   * @ordered
   */
  protected String output = OUTPUT_EDEFAULT;

  /**
   * The default value of the '{@link #getExpected() <em>Expected</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpected()
   * @generated
   * @ordered
   */
  protected static final String EXPECTED_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExpected() <em>Expected</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpected()
   * @generated
   * @ordered
   */
  protected String expected = EXPECTED_EDEFAULT;

  /**
   * The default value of the '{@link #isIsSameAsInputFile() <em>Is Same As Input File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsSameAsInputFile()
   * @generated
   * @ordered
   */
  protected static final boolean IS_SAME_AS_INPUT_FILE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsSameAsInputFile() <em>Is Same As Input File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsSameAsInputFile()
   * @generated
   * @ordered
   */
  protected boolean isSameAsInputFile = IS_SAME_AS_INPUT_FILE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GeneratorImpl()
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
    return XtextTestPackage.Literals.GENERATOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOutput()
  {
    return output;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOutput(String newOutput)
  {
    String oldOutput = output;
    output = newOutput;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.GENERATOR__OUTPUT, oldOutput, output));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExpected()
  {
    return expected;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpected(String newExpected)
  {
    String oldExpected = expected;
    expected = newExpected;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.GENERATOR__EXPECTED, oldExpected, expected));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsSameAsInputFile()
  {
    return isSameAsInputFile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsSameAsInputFile(boolean newIsSameAsInputFile)
  {
    boolean oldIsSameAsInputFile = isSameAsInputFile;
    isSameAsInputFile = newIsSameAsInputFile;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.GENERATOR__IS_SAME_AS_INPUT_FILE, oldIsSameAsInputFile, isSameAsInputFile));
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
      case XtextTestPackage.GENERATOR__OUTPUT:
        return getOutput();
      case XtextTestPackage.GENERATOR__EXPECTED:
        return getExpected();
      case XtextTestPackage.GENERATOR__IS_SAME_AS_INPUT_FILE:
        return isIsSameAsInputFile();
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
      case XtextTestPackage.GENERATOR__OUTPUT:
        setOutput((String)newValue);
        return;
      case XtextTestPackage.GENERATOR__EXPECTED:
        setExpected((String)newValue);
        return;
      case XtextTestPackage.GENERATOR__IS_SAME_AS_INPUT_FILE:
        setIsSameAsInputFile((Boolean)newValue);
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
      case XtextTestPackage.GENERATOR__OUTPUT:
        setOutput(OUTPUT_EDEFAULT);
        return;
      case XtextTestPackage.GENERATOR__EXPECTED:
        setExpected(EXPECTED_EDEFAULT);
        return;
      case XtextTestPackage.GENERATOR__IS_SAME_AS_INPUT_FILE:
        setIsSameAsInputFile(IS_SAME_AS_INPUT_FILE_EDEFAULT);
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
      case XtextTestPackage.GENERATOR__OUTPUT:
        return OUTPUT_EDEFAULT == null ? output != null : !OUTPUT_EDEFAULT.equals(output);
      case XtextTestPackage.GENERATOR__EXPECTED:
        return EXPECTED_EDEFAULT == null ? expected != null : !EXPECTED_EDEFAULT.equals(expected);
      case XtextTestPackage.GENERATOR__IS_SAME_AS_INPUT_FILE:
        return isSameAsInputFile != IS_SAME_AS_INPUT_FILE_EDEFAULT;
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
    result.append(" (output: ");
    result.append(output);
    result.append(", expected: ");
    result.append(expected);
    result.append(", isSameAsInputFile: ");
    result.append(isSameAsInputFile);
    result.append(')');
    return result.toString();
  }

} //GeneratorImpl
