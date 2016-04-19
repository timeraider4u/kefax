/**
 */
package at.jku.weiner.c.cmdarguments.cmdArgs;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getMacro <em>Macro</em>}</li>
 *   <li>{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#isIncDir <em>Inc Dir</em>}</li>
 *   <li>{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getUseIncDir <em>Use Inc Dir</em>}</li>
 *   <li>{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#isIncSys <em>Inc Sys</em>}</li>
 *   <li>{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#isNostdinc <em>Nostdinc</em>}</li>
 *   <li>{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getInclude <em>Include</em>}</li>
 *   <li>{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getOut <em>Out</em>}</li>
 *   <li>{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getLang <em>Lang</em>}</li>
 *   <li>{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getOption <em>Option</em>}</li>
 *   <li>{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getIn <em>In</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getArgument()
 * @model
 * @generated
 */
public interface Argument extends EObject
{
  /**
   * Returns the value of the '<em><b>Macro</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Macro</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Macro</em>' containment reference.
   * @see #setMacro(Macro)
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getArgument_Macro()
   * @model containment="true"
   * @generated
   */
  Macro getMacro();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getMacro <em>Macro</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Macro</em>' containment reference.
   * @see #getMacro()
   * @generated
   */
  void setMacro(Macro value);

  /**
   * Returns the value of the '<em><b>Inc Dir</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inc Dir</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inc Dir</em>' attribute.
   * @see #setIncDir(boolean)
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getArgument_IncDir()
   * @model
   * @generated
   */
  boolean isIncDir();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#isIncDir <em>Inc Dir</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Inc Dir</em>' attribute.
   * @see #isIncDir()
   * @generated
   */
  void setIncDir(boolean value);

  /**
   * Returns the value of the '<em><b>Use Inc Dir</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Inc Dir</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Use Inc Dir</em>' containment reference.
   * @see #setUseIncDir(PathCmd)
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getArgument_UseIncDir()
   * @model containment="true"
   * @generated
   */
  PathCmd getUseIncDir();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getUseIncDir <em>Use Inc Dir</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Use Inc Dir</em>' containment reference.
   * @see #getUseIncDir()
   * @generated
   */
  void setUseIncDir(PathCmd value);

  /**
   * Returns the value of the '<em><b>Inc Sys</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inc Sys</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inc Sys</em>' attribute.
   * @see #setIncSys(boolean)
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getArgument_IncSys()
   * @model
   * @generated
   */
  boolean isIncSys();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#isIncSys <em>Inc Sys</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Inc Sys</em>' attribute.
   * @see #isIncSys()
   * @generated
   */
  void setIncSys(boolean value);

  /**
   * Returns the value of the '<em><b>Nostdinc</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nostdinc</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nostdinc</em>' attribute.
   * @see #setNostdinc(boolean)
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getArgument_Nostdinc()
   * @model
   * @generated
   */
  boolean isNostdinc();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#isNostdinc <em>Nostdinc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Nostdinc</em>' attribute.
   * @see #isNostdinc()
   * @generated
   */
  void setNostdinc(boolean value);

  /**
   * Returns the value of the '<em><b>Include</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Include</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Include</em>' containment reference.
   * @see #setInclude(PathCmd)
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getArgument_Include()
   * @model containment="true"
   * @generated
   */
  PathCmd getInclude();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getInclude <em>Include</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Include</em>' containment reference.
   * @see #getInclude()
   * @generated
   */
  void setInclude(PathCmd value);

  /**
   * Returns the value of the '<em><b>Out</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Out</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Out</em>' containment reference.
   * @see #setOut(PathCmd)
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getArgument_Out()
   * @model containment="true"
   * @generated
   */
  PathCmd getOut();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getOut <em>Out</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Out</em>' containment reference.
   * @see #getOut()
   * @generated
   */
  void setOut(PathCmd value);

  /**
   * Returns the value of the '<em><b>Lang</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lang</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lang</em>' containment reference.
   * @see #setLang(PathCmd)
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getArgument_Lang()
   * @model containment="true"
   * @generated
   */
  PathCmd getLang();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getLang <em>Lang</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lang</em>' containment reference.
   * @see #getLang()
   * @generated
   */
  void setLang(PathCmd value);

  /**
   * Returns the value of the '<em><b>Option</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Option</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Option</em>' attribute.
   * @see #setOption(String)
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getArgument_Option()
   * @model
   * @generated
   */
  String getOption();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getOption <em>Option</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Option</em>' attribute.
   * @see #getOption()
   * @generated
   */
  void setOption(String value);

  /**
   * Returns the value of the '<em><b>In</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>In</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>In</em>' attribute.
   * @see #setIn(String)
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsPackage#getArgument_In()
   * @model
   * @generated
   */
  String getIn();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getIn <em>In</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>In</em>' attribute.
   * @see #getIn()
   * @generated
   */
  void setIn(String value);

} // Argument
