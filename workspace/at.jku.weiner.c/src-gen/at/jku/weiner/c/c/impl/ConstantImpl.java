/**
 */
package at.jku.weiner.c.c.impl;

import at.jku.weiner.c.c.CPackage;
import at.jku.weiner.c.c.Constant;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.impl.ConstantImpl#getHex <em>Hex</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.ConstantImpl#getOct <em>Oct</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.ConstantImpl#getDec <em>Dec</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.ConstantImpl#getCh <em>Ch</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.ConstantImpl#getStr <em>Str</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.ConstantImpl#getFloat <em>Float</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.impl.ConstantImpl#getBin <em>Bin</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstantImpl extends MinimalEObjectImpl.Container implements Constant
{
  /**
   * The default value of the '{@link #getHex() <em>Hex</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHex()
   * @generated
   * @ordered
   */
  protected static final String HEX_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getHex() <em>Hex</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHex()
   * @generated
   * @ordered
   */
  protected String hex = HEX_EDEFAULT;

  /**
   * The default value of the '{@link #getOct() <em>Oct</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOct()
   * @generated
   * @ordered
   */
  protected static final String OCT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOct() <em>Oct</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOct()
   * @generated
   * @ordered
   */
  protected String oct = OCT_EDEFAULT;

  /**
   * The default value of the '{@link #getDec() <em>Dec</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDec()
   * @generated
   * @ordered
   */
  protected static final String DEC_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDec() <em>Dec</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDec()
   * @generated
   * @ordered
   */
  protected String dec = DEC_EDEFAULT;

  /**
   * The default value of the '{@link #getCh() <em>Ch</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCh()
   * @generated
   * @ordered
   */
  protected static final String CH_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCh() <em>Ch</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCh()
   * @generated
   * @ordered
   */
  protected String ch = CH_EDEFAULT;

  /**
   * The default value of the '{@link #getStr() <em>Str</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStr()
   * @generated
   * @ordered
   */
  protected static final String STR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStr() <em>Str</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStr()
   * @generated
   * @ordered
   */
  protected String str = STR_EDEFAULT;

  /**
   * The default value of the '{@link #getFloat() <em>Float</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFloat()
   * @generated
   * @ordered
   */
  protected static final String FLOAT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFloat() <em>Float</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFloat()
   * @generated
   * @ordered
   */
  protected String float_ = FLOAT_EDEFAULT;

  /**
   * The default value of the '{@link #getBin() <em>Bin</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBin()
   * @generated
   * @ordered
   */
  protected static final String BIN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBin() <em>Bin</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBin()
   * @generated
   * @ordered
   */
  protected String bin = BIN_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConstantImpl()
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
    return CPackage.Literals.CONSTANT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getHex()
  {
    return hex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHex(String newHex)
  {
    String oldHex = hex;
    hex = newHex;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.CONSTANT__HEX, oldHex, hex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOct()
  {
    return oct;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOct(String newOct)
  {
    String oldOct = oct;
    oct = newOct;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.CONSTANT__OCT, oldOct, oct));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDec()
  {
    return dec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDec(String newDec)
  {
    String oldDec = dec;
    dec = newDec;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.CONSTANT__DEC, oldDec, dec));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCh()
  {
    return ch;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCh(String newCh)
  {
    String oldCh = ch;
    ch = newCh;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.CONSTANT__CH, oldCh, ch));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStr()
  {
    return str;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStr(String newStr)
  {
    String oldStr = str;
    str = newStr;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.CONSTANT__STR, oldStr, str));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFloat()
  {
    return float_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFloat(String newFloat)
  {
    String oldFloat = float_;
    float_ = newFloat;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.CONSTANT__FLOAT, oldFloat, float_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBin()
  {
    return bin;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBin(String newBin)
  {
    String oldBin = bin;
    bin = newBin;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CPackage.CONSTANT__BIN, oldBin, bin));
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
      case CPackage.CONSTANT__HEX:
        return getHex();
      case CPackage.CONSTANT__OCT:
        return getOct();
      case CPackage.CONSTANT__DEC:
        return getDec();
      case CPackage.CONSTANT__CH:
        return getCh();
      case CPackage.CONSTANT__STR:
        return getStr();
      case CPackage.CONSTANT__FLOAT:
        return getFloat();
      case CPackage.CONSTANT__BIN:
        return getBin();
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
      case CPackage.CONSTANT__HEX:
        setHex((String)newValue);
        return;
      case CPackage.CONSTANT__OCT:
        setOct((String)newValue);
        return;
      case CPackage.CONSTANT__DEC:
        setDec((String)newValue);
        return;
      case CPackage.CONSTANT__CH:
        setCh((String)newValue);
        return;
      case CPackage.CONSTANT__STR:
        setStr((String)newValue);
        return;
      case CPackage.CONSTANT__FLOAT:
        setFloat((String)newValue);
        return;
      case CPackage.CONSTANT__BIN:
        setBin((String)newValue);
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
      case CPackage.CONSTANT__HEX:
        setHex(HEX_EDEFAULT);
        return;
      case CPackage.CONSTANT__OCT:
        setOct(OCT_EDEFAULT);
        return;
      case CPackage.CONSTANT__DEC:
        setDec(DEC_EDEFAULT);
        return;
      case CPackage.CONSTANT__CH:
        setCh(CH_EDEFAULT);
        return;
      case CPackage.CONSTANT__STR:
        setStr(STR_EDEFAULT);
        return;
      case CPackage.CONSTANT__FLOAT:
        setFloat(FLOAT_EDEFAULT);
        return;
      case CPackage.CONSTANT__BIN:
        setBin(BIN_EDEFAULT);
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
      case CPackage.CONSTANT__HEX:
        return HEX_EDEFAULT == null ? hex != null : !HEX_EDEFAULT.equals(hex);
      case CPackage.CONSTANT__OCT:
        return OCT_EDEFAULT == null ? oct != null : !OCT_EDEFAULT.equals(oct);
      case CPackage.CONSTANT__DEC:
        return DEC_EDEFAULT == null ? dec != null : !DEC_EDEFAULT.equals(dec);
      case CPackage.CONSTANT__CH:
        return CH_EDEFAULT == null ? ch != null : !CH_EDEFAULT.equals(ch);
      case CPackage.CONSTANT__STR:
        return STR_EDEFAULT == null ? str != null : !STR_EDEFAULT.equals(str);
      case CPackage.CONSTANT__FLOAT:
        return FLOAT_EDEFAULT == null ? float_ != null : !FLOAT_EDEFAULT.equals(float_);
      case CPackage.CONSTANT__BIN:
        return BIN_EDEFAULT == null ? bin != null : !BIN_EDEFAULT.equals(bin);
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
    result.append(" (hex: ");
    result.append(hex);
    result.append(", oct: ");
    result.append(oct);
    result.append(", dec: ");
    result.append(dec);
    result.append(", ch: ");
    result.append(ch);
    result.append(", str: ");
    result.append(str);
    result.append(", float: ");
    result.append(float_);
    result.append(", bin: ");
    result.append(bin);
    result.append(')');
    return result.toString();
  }

} //ConstantImpl
