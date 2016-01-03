/**
 */
package at.jku.weiner.c.cmdarguments.cmdArgs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdArgsFactory
 * @model kind="package"
 * @generated
 */
public interface CmdArgsPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "cmdArgs";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.jku.at/weiner/c/cmdarguments/CmdArgs";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "cmdArgs";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CmdArgsPackage eINSTANCE = at.jku.weiner.c.cmdarguments.cmdArgs.impl.CmdArgsPackageImpl.init();

  /**
   * The meta object id for the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.ModelImpl
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.CmdArgsPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Lines</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__LINES = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.impl.CmdLineImpl <em>Cmd Line</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.CmdLineImpl
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.CmdArgsPackageImpl#getCmdLine()
   * @generated
   */
  int CMD_LINE = 1;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CMD_LINE__ARGUMENTS = 0;

  /**
   * The number of structural features of the '<em>Cmd Line</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CMD_LINE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.impl.ArgumentImpl <em>Argument</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.ArgumentImpl
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.CmdArgsPackageImpl#getArgument()
   * @generated
   */
  int ARGUMENT = 2;

  /**
   * The feature id for the '<em><b>Macro</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__MACRO = 0;

  /**
   * The feature id for the '<em><b>Inc Dir</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__INC_DIR = 1;

  /**
   * The feature id for the '<em><b>Use Inc Dir</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__USE_INC_DIR = 2;

  /**
   * The feature id for the '<em><b>Inc Sys</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__INC_SYS = 3;

  /**
   * The feature id for the '<em><b>Nostdinc</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__NOSTDINC = 4;

  /**
   * The feature id for the '<em><b>Include</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__INCLUDE = 5;

  /**
   * The feature id for the '<em><b>Option</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__OPTION = 6;

  /**
   * The number of structural features of the '<em>Argument</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.impl.MacroImpl <em>Macro</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.MacroImpl
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.CmdArgsPackageImpl#getMacro()
   * @generated
   */
  int MACRO = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO__NAME = 0;

  /**
   * The number of structural features of the '<em>Macro</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.impl.PathCmdImpl <em>Path Cmd</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.PathCmdImpl
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.CmdArgsPackageImpl#getPathCmd()
   * @generated
   */
  int PATH_CMD = 4;

  /**
   * The feature id for the '<em><b>Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_CMD__PATH = 0;

  /**
   * The number of structural features of the '<em>Path Cmd</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_CMD_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.impl.SimpleMacroImpl <em>Simple Macro</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.SimpleMacroImpl
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.CmdArgsPackageImpl#getSimpleMacro()
   * @generated
   */
  int SIMPLE_MACRO = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_MACRO__NAME = MACRO__NAME;

  /**
   * The number of structural features of the '<em>Simple Macro</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_MACRO_FEATURE_COUNT = MACRO_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.impl.ObjectMacroImpl <em>Object Macro</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.ObjectMacroImpl
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.CmdArgsPackageImpl#getObjectMacro()
   * @generated
   */
  int OBJECT_MACRO = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_MACRO__NAME = MACRO__NAME;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_MACRO__VALUE = MACRO_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Object Macro</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_MACRO_FEATURE_COUNT = MACRO_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.impl.FunctionMacroImpl <em>Function Macro</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.FunctionMacroImpl
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.CmdArgsPackageImpl#getFunctionMacro()
   * @generated
   */
  int FUNCTION_MACRO = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_MACRO__NAME = MACRO__NAME;

  /**
   * The feature id for the '<em><b>Params</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_MACRO__PARAMS = MACRO_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_MACRO__VALUE = MACRO_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Function Macro</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_MACRO_FEATURE_COUNT = MACRO_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Model#getLines <em>Lines</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Lines</em>'.
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.Model#getLines()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Lines();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine <em>Cmd Line</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cmd Line</em>'.
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine
   * @generated
   */
  EClass getCmdLine();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine#getArguments <em>Arguments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Arguments</em>'.
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine#getArguments()
   * @see #getCmdLine()
   * @generated
   */
  EReference getCmdLine_Arguments();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument <em>Argument</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Argument</em>'.
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.Argument
   * @generated
   */
  EClass getArgument();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getMacro <em>Macro</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Macro</em>'.
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getMacro()
   * @see #getArgument()
   * @generated
   */
  EReference getArgument_Macro();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#isIncDir <em>Inc Dir</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Inc Dir</em>'.
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.Argument#isIncDir()
   * @see #getArgument()
   * @generated
   */
  EAttribute getArgument_IncDir();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getUseIncDir <em>Use Inc Dir</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Use Inc Dir</em>'.
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getUseIncDir()
   * @see #getArgument()
   * @generated
   */
  EReference getArgument_UseIncDir();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#isIncSys <em>Inc Sys</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Inc Sys</em>'.
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.Argument#isIncSys()
   * @see #getArgument()
   * @generated
   */
  EAttribute getArgument_IncSys();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#isNostdinc <em>Nostdinc</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Nostdinc</em>'.
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.Argument#isNostdinc()
   * @see #getArgument()
   * @generated
   */
  EAttribute getArgument_Nostdinc();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getInclude <em>Include</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Include</em>'.
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getInclude()
   * @see #getArgument()
   * @generated
   */
  EReference getArgument_Include();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getOption <em>Option</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Option</em>'.
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.Argument#getOption()
   * @see #getArgument()
   * @generated
   */
  EAttribute getArgument_Option();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Macro <em>Macro</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Macro</em>'.
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.Macro
   * @generated
   */
  EClass getMacro();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.cmdarguments.cmdArgs.Macro#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.Macro#getName()
   * @see #getMacro()
   * @generated
   */
  EAttribute getMacro_Name();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd <em>Path Cmd</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Path Cmd</em>'.
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd
   * @generated
   */
  EClass getPathCmd();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd#getPath <em>Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Path</em>'.
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd#getPath()
   * @see #getPathCmd()
   * @generated
   */
  EAttribute getPathCmd_Path();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.cmdarguments.cmdArgs.SimpleMacro <em>Simple Macro</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Macro</em>'.
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.SimpleMacro
   * @generated
   */
  EClass getSimpleMacro();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.cmdarguments.cmdArgs.ObjectMacro <em>Object Macro</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object Macro</em>'.
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.ObjectMacro
   * @generated
   */
  EClass getObjectMacro();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.cmdarguments.cmdArgs.ObjectMacro#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.ObjectMacro#getValue()
   * @see #getObjectMacro()
   * @generated
   */
  EAttribute getObjectMacro_Value();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.cmdarguments.cmdArgs.FunctionMacro <em>Function Macro</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Macro</em>'.
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.FunctionMacro
   * @generated
   */
  EClass getFunctionMacro();

  /**
   * Returns the meta object for the attribute list '{@link at.jku.weiner.c.cmdarguments.cmdArgs.FunctionMacro#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Params</em>'.
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.FunctionMacro#getParams()
   * @see #getFunctionMacro()
   * @generated
   */
  EAttribute getFunctionMacro_Params();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.cmdarguments.cmdArgs.FunctionMacro#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see at.jku.weiner.c.cmdarguments.cmdArgs.FunctionMacro#getValue()
   * @see #getFunctionMacro()
   * @generated
   */
  EAttribute getFunctionMacro_Value();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  CmdArgsFactory getCmdArgsFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.ModelImpl
     * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.CmdArgsPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Lines</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__LINES = eINSTANCE.getModel_Lines();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.impl.CmdLineImpl <em>Cmd Line</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.CmdLineImpl
     * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.CmdArgsPackageImpl#getCmdLine()
     * @generated
     */
    EClass CMD_LINE = eINSTANCE.getCmdLine();

    /**
     * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CMD_LINE__ARGUMENTS = eINSTANCE.getCmdLine_Arguments();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.impl.ArgumentImpl <em>Argument</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.ArgumentImpl
     * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.CmdArgsPackageImpl#getArgument()
     * @generated
     */
    EClass ARGUMENT = eINSTANCE.getArgument();

    /**
     * The meta object literal for the '<em><b>Macro</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARGUMENT__MACRO = eINSTANCE.getArgument_Macro();

    /**
     * The meta object literal for the '<em><b>Inc Dir</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARGUMENT__INC_DIR = eINSTANCE.getArgument_IncDir();

    /**
     * The meta object literal for the '<em><b>Use Inc Dir</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARGUMENT__USE_INC_DIR = eINSTANCE.getArgument_UseIncDir();

    /**
     * The meta object literal for the '<em><b>Inc Sys</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARGUMENT__INC_SYS = eINSTANCE.getArgument_IncSys();

    /**
     * The meta object literal for the '<em><b>Nostdinc</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARGUMENT__NOSTDINC = eINSTANCE.getArgument_Nostdinc();

    /**
     * The meta object literal for the '<em><b>Include</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARGUMENT__INCLUDE = eINSTANCE.getArgument_Include();

    /**
     * The meta object literal for the '<em><b>Option</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARGUMENT__OPTION = eINSTANCE.getArgument_Option();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.impl.MacroImpl <em>Macro</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.MacroImpl
     * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.CmdArgsPackageImpl#getMacro()
     * @generated
     */
    EClass MACRO = eINSTANCE.getMacro();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MACRO__NAME = eINSTANCE.getMacro_Name();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.impl.PathCmdImpl <em>Path Cmd</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.PathCmdImpl
     * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.CmdArgsPackageImpl#getPathCmd()
     * @generated
     */
    EClass PATH_CMD = eINSTANCE.getPathCmd();

    /**
     * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PATH_CMD__PATH = eINSTANCE.getPathCmd_Path();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.impl.SimpleMacroImpl <em>Simple Macro</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.SimpleMacroImpl
     * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.CmdArgsPackageImpl#getSimpleMacro()
     * @generated
     */
    EClass SIMPLE_MACRO = eINSTANCE.getSimpleMacro();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.impl.ObjectMacroImpl <em>Object Macro</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.ObjectMacroImpl
     * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.CmdArgsPackageImpl#getObjectMacro()
     * @generated
     */
    EClass OBJECT_MACRO = eINSTANCE.getObjectMacro();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECT_MACRO__VALUE = eINSTANCE.getObjectMacro_Value();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.cmdarguments.cmdArgs.impl.FunctionMacroImpl <em>Function Macro</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.FunctionMacroImpl
     * @see at.jku.weiner.c.cmdarguments.cmdArgs.impl.CmdArgsPackageImpl#getFunctionMacro()
     * @generated
     */
    EClass FUNCTION_MACRO = eINSTANCE.getFunctionMacro();

    /**
     * The meta object literal for the '<em><b>Params</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION_MACRO__PARAMS = eINSTANCE.getFunctionMacro_Params();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION_MACRO__VALUE = eINSTANCE.getFunctionMacro_Value();

  }

} //CmdArgsPackage
