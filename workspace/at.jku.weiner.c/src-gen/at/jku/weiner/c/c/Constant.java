/**
 */
package at.jku.weiner.c.c;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.Constant#getHex <em>Hex</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.Constant#getOct <em>Oct</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.Constant#getDec <em>Dec</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.Constant#getCh <em>Ch</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.Constant#getStr <em>Str</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.Constant#getFloat <em>Float</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.c.CPackage#getConstant()
 * @model
 * @generated
 */
public interface Constant extends EObject
{
  /**
   * Returns the value of the '<em><b>Hex</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Hex</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Hex</em>' attribute.
   * @see #setHex(String)
   * @see at.jku.weiner.c.c.CPackage#getConstant_Hex()
   * @model
   * @generated
   */
  String getHex();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.Constant#getHex <em>Hex</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Hex</em>' attribute.
   * @see #getHex()
   * @generated
   */
  void setHex(String value);

  /**
   * Returns the value of the '<em><b>Oct</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Oct</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Oct</em>' attribute.
   * @see #setOct(String)
   * @see at.jku.weiner.c.c.CPackage#getConstant_Oct()
   * @model
   * @generated
   */
  String getOct();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.Constant#getOct <em>Oct</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Oct</em>' attribute.
   * @see #getOct()
   * @generated
   */
  void setOct(String value);

  /**
   * Returns the value of the '<em><b>Dec</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dec</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dec</em>' attribute.
   * @see #setDec(String)
   * @see at.jku.weiner.c.c.CPackage#getConstant_Dec()
   * @model
   * @generated
   */
  String getDec();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.Constant#getDec <em>Dec</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dec</em>' attribute.
   * @see #getDec()
   * @generated
   */
  void setDec(String value);

  /**
   * Returns the value of the '<em><b>Ch</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ch</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ch</em>' attribute.
   * @see #setCh(String)
   * @see at.jku.weiner.c.c.CPackage#getConstant_Ch()
   * @model
   * @generated
   */
  String getCh();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.Constant#getCh <em>Ch</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ch</em>' attribute.
   * @see #getCh()
   * @generated
   */
  void setCh(String value);

  /**
   * Returns the value of the '<em><b>Str</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Str</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Str</em>' attribute.
   * @see #setStr(String)
   * @see at.jku.weiner.c.c.CPackage#getConstant_Str()
   * @model
   * @generated
   */
  String getStr();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.Constant#getStr <em>Str</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Str</em>' attribute.
   * @see #getStr()
   * @generated
   */
  void setStr(String value);

  /**
   * Returns the value of the '<em><b>Float</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Float</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Float</em>' attribute.
   * @see #setFloat(String)
   * @see at.jku.weiner.c.c.CPackage#getConstant_Float()
   * @model
   * @generated
   */
  String getFloat();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.Constant#getFloat <em>Float</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Float</em>' attribute.
   * @see #getFloat()
   * @generated
   */
  void setFloat(String value);

} // Constant
