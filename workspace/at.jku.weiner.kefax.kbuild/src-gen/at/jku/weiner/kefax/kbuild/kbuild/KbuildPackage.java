/**
 */
package at.jku.weiner.kefax.kbuild.kbuild;

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
 * @see at.jku.weiner.kefax.kbuild.kbuild.KbuildFactory
 * @model kind="package"
 * @generated
 */
public interface KbuildPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "kbuild";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.jku.at/weiner/kefax/kbuild/Kbuild";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "kbuild";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  KbuildPackage eINSTANCE = at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl.init();

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ModelImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Build Entry</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__BUILD_ENTRY = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.BuildEntryImpl <em>Build Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.BuildEntryImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getBuildEntry()
   * @generated
   */
  int BUILD_ENTRY = 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUILD_ENTRY__VALUE = 0;

  /**
   * The number of structural features of the '<em>Build Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUILD_ENTRY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.EntryImpl <em>Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.EntryImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getEntry()
   * @generated
   */
  int ENTRY = 2;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY__VARIABLE = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY__VALUE = 1;

  /**
   * The number of structural features of the '<em>Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.IfImpl <em>If</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.IfImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getIf()
   * @generated
   */
  int IF = 3;

  /**
   * The feature id for the '<em><b>Shell</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF__SHELL = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF__VALUE = 1;

  /**
   * The feature id for the '<em><b>Elsevalue</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF__ELSEVALUE = 2;

  /**
   * The number of structural features of the '<em>If</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.Object_YImpl <em>Object Y</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.Object_YImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getObject_Y()
   * @generated
   */
  int OBJECT_Y = 4;

  /**
   * The number of structural features of the '<em>Object Y</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_Y_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.Object_MImpl <em>Object M</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.Object_MImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getObject_M()
   * @generated
   */
  int OBJECT_M = 5;

  /**
   * The number of structural features of the '<em>Object M</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_M_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.AssignExtraImpl <em>Assign Extra</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.AssignExtraImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getAssignExtra()
   * @generated
   */
  int ASSIGN_EXTRA = 7;

  /**
   * The number of structural features of the '<em>Assign Extra</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGN_EXTRA_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.AssignImpl <em>Assign</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.AssignImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getAssign()
   * @generated
   */
  int ASSIGN = 6;

  /**
   * The number of structural features of the '<em>Assign</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGN_FEATURE_COUNT = ASSIGN_EXTRA_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ValuesImpl <em>Values</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ValuesImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getValues()
   * @generated
   */
  int VALUES = 8;

  /**
   * The feature id for the '<em><b>Items</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUES__ITEMS = ASSIGN_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Values</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUES_FEATURE_COUNT = ASSIGN_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ValueImpl <em>Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ValueImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getValue()
   * @generated
   */
  int VALUE = 9;

  /**
   * The number of structural features of the '<em>Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.VariableImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 10;

  /**
   * The feature id for the '<em><b>Shell</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__SHELL = IF__SHELL;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__VALUE = IF__VALUE;

  /**
   * The feature id for the '<em><b>Elsevalue</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__ELSEVALUE = IF__ELSEVALUE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__NAME = IF_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = IF_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ShellCmdImpl <em>Shell Cmd</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ShellCmdImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getShellCmd()
   * @generated
   */
  int SHELL_CMD = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHELL_CMD__NAME = 0;

  /**
   * The feature id for the '<em><b>Shell Part</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHELL_CMD__SHELL_PART = 1;

  /**
   * The number of structural features of the '<em>Shell Cmd</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHELL_CMD_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ShellPartImpl <em>Shell Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ShellPartImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getShellPart()
   * @generated
   */
  int SHELL_PART = 12;

  /**
   * The feature id for the '<em><b>Val</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHELL_PART__VAL = 0;

  /**
   * The feature id for the '<em><b>Cmd</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHELL_PART__CMD = 1;

  /**
   * The number of structural features of the '<em>Shell Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHELL_PART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.VarSlashSymImpl <em>Var Slash Sym</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.VarSlashSymImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getVarSlashSym()
   * @generated
   */
  int VAR_SLASH_SYM = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_SLASH_SYM__NAME = 0;

  /**
   * The number of structural features of the '<em>Var Slash Sym</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_SLASH_SYM_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.IfEqImpl <em>If Eq</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.IfEqImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getIfEq()
   * @generated
   */
  int IF_EQ = 14;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EQ__VALUE = BUILD_ENTRY__VALUE;

  /**
   * The number of structural features of the '<em>If Eq</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EQ_FEATURE_COUNT = BUILD_ENTRY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.IfNEqImpl <em>If NEq</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.IfNEqImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getIfNEq()
   * @generated
   */
  int IF_NEQ = 15;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_NEQ__VALUE = BUILD_ENTRY__VALUE;

  /**
   * The number of structural features of the '<em>If NEq</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_NEQ_FEATURE_COUNT = BUILD_ENTRY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.IfndefImpl <em>Ifndef</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.IfndefImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getIfndef()
   * @generated
   */
  int IFNDEF = 16;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IFNDEF__VALUE = BUILD_ENTRY__VALUE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IFNDEF__NAME = BUILD_ENTRY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Ifndef</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IFNDEF_FEATURE_COUNT = BUILD_ENTRY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.HostProgramImpl <em>Host Program</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.HostProgramImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getHostProgram()
   * @generated
   */
  int HOST_PROGRAM = 17;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HOST_PROGRAM__VALUE = BUILD_ENTRY__VALUE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HOST_PROGRAM__NAME = BUILD_ENTRY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HOST_PROGRAM__VARIABLE = BUILD_ENTRY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Inner</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HOST_PROGRAM__INNER = BUILD_ENTRY_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Host Program</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HOST_PROGRAM_FEATURE_COUNT = BUILD_ENTRY_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectImpl <em>Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getObject()
   * @generated
   */
  int OBJECT = 18;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT__VALUE = BUILD_ENTRY__VALUE;

  /**
   * The number of structural features of the '<em>Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_FEATURE_COUNT = BUILD_ENTRY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.TargetImpl <em>Target</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.TargetImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getTarget()
   * @generated
   */
  int TARGET = 19;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET__VALUE = BUILD_ENTRY__VALUE;

  /**
   * The feature id for the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET__TARGET = BUILD_ENTRY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET__VALUES = BUILD_ENTRY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Target</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_FEATURE_COUNT = BUILD_ENTRY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.MyVariableImpl <em>My Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.MyVariableImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getMyVariable()
   * @generated
   */
  int MY_VARIABLE = 20;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_VARIABLE__VALUE = BUILD_ENTRY__VALUE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_VARIABLE__NAME = BUILD_ENTRY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_VARIABLE__VARIABLE = BUILD_ENTRY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>My Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_VARIABLE_FEATURE_COUNT = BUILD_ENTRY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.Obj_yImpl <em>Obj y</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.Obj_yImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getObj_y()
   * @generated
   */
  int OBJ_Y = 21;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJ_Y__VALUE = OBJECT_Y_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Obj y</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJ_Y_FEATURE_COUNT = OBJECT_Y_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.Obj_mImpl <em>Obj m</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.Obj_mImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getObj_m()
   * @generated
   */
  int OBJ_M = 22;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJ_M__VALUE = OBJECT_M_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Obj m</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJ_M_FEATURE_COUNT = OBJECT_M_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectFileImpl <em>Object File</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectFileImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getObjectFile()
   * @generated
   */
  int OBJECT_FILE = 23;

  /**
   * The number of structural features of the '<em>Object File</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_FILE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectSingleFileImpl <em>Object Single File</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectSingleFileImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getObjectSingleFile()
   * @generated
   */
  int OBJECT_SINGLE_FILE = 24;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_SINGLE_FILE__NAME = VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Object Single File</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_SINGLE_FILE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectVariableImpl <em>Object Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectVariableImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getObjectVariable()
   * @generated
   */
  int OBJECT_VARIABLE = 25;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_VARIABLE__VALUE = VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Additional</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_VARIABLE__ADDITIONAL = VALUE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Object Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_VARIABLE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectShellCmdImpl <em>Object Shell Cmd</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectShellCmdImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getObjectShellCmd()
   * @generated
   */
  int OBJECT_SHELL_CMD = 26;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_SHELL_CMD__VALUE = VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Object Shell Cmd</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_SHELL_CMD_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectStringImpl <em>Object String</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectStringImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getObjectString()
   * @generated
   */
  int OBJECT_STRING = 27;

  /**
   * The number of structural features of the '<em>Object String</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_STRING_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectShellCharImpl <em>Object Shell Char</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectShellCharImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getObjectShellChar()
   * @generated
   */
  int OBJECT_SHELL_CHAR = 28;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_SHELL_CHAR__VALUE = VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Object Shell Char</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_SHELL_CHAR_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectDirImpl <em>Object Dir</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectDirImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getObjectDir()
   * @generated
   */
  int OBJECT_DIR = 29;

  /**
   * The number of structural features of the '<em>Object Dir</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_DIR_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.IncludeImpl <em>Include</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.IncludeImpl
   * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getInclude()
   * @generated
   */
  int INCLUDE = 30;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE__NAME = SHELL_CMD__NAME;

  /**
   * The feature id for the '<em><b>Shell Part</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE__SHELL_PART = SHELL_CMD__SHELL_PART;

  /**
   * The number of structural features of the '<em>Include</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_FEATURE_COUNT = SHELL_CMD_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.kefax.kbuild.kbuild.Model#getBuildEntry <em>Build Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Build Entry</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.Model#getBuildEntry()
   * @see #getModel()
   * @generated
   */
  EReference getModel_BuildEntry();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.BuildEntry <em>Build Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Build Entry</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.BuildEntry
   * @generated
   */
  EClass getBuildEntry();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.kefax.kbuild.kbuild.BuildEntry#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.BuildEntry#getValue()
   * @see #getBuildEntry()
   * @generated
   */
  EReference getBuildEntry_Value();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.Entry <em>Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entry</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.Entry
   * @generated
   */
  EClass getEntry();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.kefax.kbuild.kbuild.Entry#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.Entry#getVariable()
   * @see #getEntry()
   * @generated
   */
  EReference getEntry_Variable();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.kefax.kbuild.kbuild.Entry#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.Entry#getValue()
   * @see #getEntry()
   * @generated
   */
  EReference getEntry_Value();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.If <em>If</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.If
   * @generated
   */
  EClass getIf();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.kefax.kbuild.kbuild.If#getShell <em>Shell</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Shell</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.If#getShell()
   * @see #getIf()
   * @generated
   */
  EReference getIf_Shell();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.kefax.kbuild.kbuild.If#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.If#getValue()
   * @see #getIf()
   * @generated
   */
  EReference getIf_Value();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.kefax.kbuild.kbuild.If#getElsevalue <em>Elsevalue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Elsevalue</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.If#getElsevalue()
   * @see #getIf()
   * @generated
   */
  EReference getIf_Elsevalue();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.Object_Y <em>Object Y</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object Y</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.Object_Y
   * @generated
   */
  EClass getObject_Y();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.Object_M <em>Object M</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object M</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.Object_M
   * @generated
   */
  EClass getObject_M();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.Assign <em>Assign</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assign</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.Assign
   * @generated
   */
  EClass getAssign();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.AssignExtra <em>Assign Extra</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assign Extra</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.AssignExtra
   * @generated
   */
  EClass getAssignExtra();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.Values <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Values</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.Values
   * @generated
   */
  EClass getValues();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.kefax.kbuild.kbuild.Values#getItems <em>Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Items</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.Values#getItems()
   * @see #getValues()
   * @generated
   */
  EReference getValues_Items();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.Value
   * @generated
   */
  EClass getValue();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.ShellCmd <em>Shell Cmd</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Shell Cmd</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.ShellCmd
   * @generated
   */
  EClass getShellCmd();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.kefax.kbuild.kbuild.ShellCmd#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.ShellCmd#getName()
   * @see #getShellCmd()
   * @generated
   */
  EAttribute getShellCmd_Name();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.kefax.kbuild.kbuild.ShellCmd#getShellPart <em>Shell Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Shell Part</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.ShellCmd#getShellPart()
   * @see #getShellCmd()
   * @generated
   */
  EReference getShellCmd_ShellPart();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.ShellPart <em>Shell Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Shell Part</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.ShellPart
   * @generated
   */
  EClass getShellPart();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.kefax.kbuild.kbuild.ShellPart#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Val</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.ShellPart#getVal()
   * @see #getShellPart()
   * @generated
   */
  EReference getShellPart_Val();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.kefax.kbuild.kbuild.ShellPart#getCmd <em>Cmd</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Cmd</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.ShellPart#getCmd()
   * @see #getShellPart()
   * @generated
   */
  EReference getShellPart_Cmd();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.VarSlashSym <em>Var Slash Sym</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Slash Sym</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.VarSlashSym
   * @generated
   */
  EClass getVarSlashSym();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.kefax.kbuild.kbuild.VarSlashSym#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.VarSlashSym#getName()
   * @see #getVarSlashSym()
   * @generated
   */
  EAttribute getVarSlashSym_Name();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.IfEq <em>If Eq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Eq</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.IfEq
   * @generated
   */
  EClass getIfEq();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.IfNEq <em>If NEq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If NEq</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.IfNEq
   * @generated
   */
  EClass getIfNEq();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.Ifndef <em>Ifndef</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ifndef</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.Ifndef
   * @generated
   */
  EClass getIfndef();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.kefax.kbuild.kbuild.Ifndef#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.Ifndef#getName()
   * @see #getIfndef()
   * @generated
   */
  EAttribute getIfndef_Name();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.HostProgram <em>Host Program</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Host Program</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.HostProgram
   * @generated
   */
  EClass getHostProgram();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.kefax.kbuild.kbuild.HostProgram#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.HostProgram#getName()
   * @see #getHostProgram()
   * @generated
   */
  EAttribute getHostProgram_Name();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.kefax.kbuild.kbuild.HostProgram#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.HostProgram#getVariable()
   * @see #getHostProgram()
   * @generated
   */
  EReference getHostProgram_Variable();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.kefax.kbuild.kbuild.HostProgram#getInner <em>Inner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Inner</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.HostProgram#getInner()
   * @see #getHostProgram()
   * @generated
   */
  EReference getHostProgram_Inner();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.Object <em>Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.Object
   * @generated
   */
  EClass getObject();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.Target <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Target</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.Target
   * @generated
   */
  EClass getTarget();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.kefax.kbuild.kbuild.Target#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.Target#getTarget()
   * @see #getTarget()
   * @generated
   */
  EReference getTarget_Target();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.kefax.kbuild.kbuild.Target#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Values</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.Target#getValues()
   * @see #getTarget()
   * @generated
   */
  EReference getTarget_Values();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.MyVariable <em>My Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Variable</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.MyVariable
   * @generated
   */
  EClass getMyVariable();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.kefax.kbuild.kbuild.MyVariable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.MyVariable#getName()
   * @see #getMyVariable()
   * @generated
   */
  EAttribute getMyVariable_Name();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.kefax.kbuild.kbuild.MyVariable#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.MyVariable#getVariable()
   * @see #getMyVariable()
   * @generated
   */
  EReference getMyVariable_Variable();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.Obj_y <em>Obj y</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Obj y</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.Obj_y
   * @generated
   */
  EClass getObj_y();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.kefax.kbuild.kbuild.Obj_y#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.Obj_y#getValue()
   * @see #getObj_y()
   * @generated
   */
  EReference getObj_y_Value();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.Obj_m <em>Obj m</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Obj m</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.Obj_m
   * @generated
   */
  EClass getObj_m();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.kefax.kbuild.kbuild.Obj_m#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.Obj_m#getValue()
   * @see #getObj_m()
   * @generated
   */
  EReference getObj_m_Value();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.ObjectFile <em>Object File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object File</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.ObjectFile
   * @generated
   */
  EClass getObjectFile();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.ObjectSingleFile <em>Object Single File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object Single File</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.ObjectSingleFile
   * @generated
   */
  EClass getObjectSingleFile();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.kefax.kbuild.kbuild.ObjectSingleFile#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.ObjectSingleFile#getName()
   * @see #getObjectSingleFile()
   * @generated
   */
  EAttribute getObjectSingleFile_Name();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.ObjectVariable <em>Object Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object Variable</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.ObjectVariable
   * @generated
   */
  EClass getObjectVariable();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.kefax.kbuild.kbuild.ObjectVariable#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.ObjectVariable#getValue()
   * @see #getObjectVariable()
   * @generated
   */
  EReference getObjectVariable_Value();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.kefax.kbuild.kbuild.ObjectVariable#getAdditional <em>Additional</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Additional</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.ObjectVariable#getAdditional()
   * @see #getObjectVariable()
   * @generated
   */
  EAttribute getObjectVariable_Additional();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.ObjectShellCmd <em>Object Shell Cmd</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object Shell Cmd</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.ObjectShellCmd
   * @generated
   */
  EClass getObjectShellCmd();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.kefax.kbuild.kbuild.ObjectShellCmd#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.ObjectShellCmd#getValue()
   * @see #getObjectShellCmd()
   * @generated
   */
  EReference getObjectShellCmd_Value();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.ObjectString <em>Object String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object String</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.ObjectString
   * @generated
   */
  EClass getObjectString();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.ObjectShellChar <em>Object Shell Char</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object Shell Char</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.ObjectShellChar
   * @generated
   */
  EClass getObjectShellChar();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.kefax.kbuild.kbuild.ObjectShellChar#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.ObjectShellChar#getValue()
   * @see #getObjectShellChar()
   * @generated
   */
  EAttribute getObjectShellChar_Value();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.ObjectDir <em>Object Dir</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object Dir</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.ObjectDir
   * @generated
   */
  EClass getObjectDir();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.kefax.kbuild.kbuild.Include <em>Include</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Include</em>'.
   * @see at.jku.weiner.kefax.kbuild.kbuild.Include
   * @generated
   */
  EClass getInclude();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  KbuildFactory getKbuildFactory();

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
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ModelImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Build Entry</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__BUILD_ENTRY = eINSTANCE.getModel_BuildEntry();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.BuildEntryImpl <em>Build Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.BuildEntryImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getBuildEntry()
     * @generated
     */
    EClass BUILD_ENTRY = eINSTANCE.getBuildEntry();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BUILD_ENTRY__VALUE = eINSTANCE.getBuildEntry_Value();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.EntryImpl <em>Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.EntryImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getEntry()
     * @generated
     */
    EClass ENTRY = eINSTANCE.getEntry();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTRY__VARIABLE = eINSTANCE.getEntry_Variable();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTRY__VALUE = eINSTANCE.getEntry_Value();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.IfImpl <em>If</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.IfImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getIf()
     * @generated
     */
    EClass IF = eINSTANCE.getIf();

    /**
     * The meta object literal for the '<em><b>Shell</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF__SHELL = eINSTANCE.getIf_Shell();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF__VALUE = eINSTANCE.getIf_Value();

    /**
     * The meta object literal for the '<em><b>Elsevalue</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF__ELSEVALUE = eINSTANCE.getIf_Elsevalue();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.Object_YImpl <em>Object Y</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.Object_YImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getObject_Y()
     * @generated
     */
    EClass OBJECT_Y = eINSTANCE.getObject_Y();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.Object_MImpl <em>Object M</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.Object_MImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getObject_M()
     * @generated
     */
    EClass OBJECT_M = eINSTANCE.getObject_M();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.AssignImpl <em>Assign</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.AssignImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getAssign()
     * @generated
     */
    EClass ASSIGN = eINSTANCE.getAssign();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.AssignExtraImpl <em>Assign Extra</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.AssignExtraImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getAssignExtra()
     * @generated
     */
    EClass ASSIGN_EXTRA = eINSTANCE.getAssignExtra();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ValuesImpl <em>Values</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ValuesImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getValues()
     * @generated
     */
    EClass VALUES = eINSTANCE.getValues();

    /**
     * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUES__ITEMS = eINSTANCE.getValues_Items();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ValueImpl <em>Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ValueImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getValue()
     * @generated
     */
    EClass VALUE = eINSTANCE.getValue();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.VariableImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getVariable()
     * @generated
     */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ShellCmdImpl <em>Shell Cmd</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ShellCmdImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getShellCmd()
     * @generated
     */
    EClass SHELL_CMD = eINSTANCE.getShellCmd();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SHELL_CMD__NAME = eINSTANCE.getShellCmd_Name();

    /**
     * The meta object literal for the '<em><b>Shell Part</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SHELL_CMD__SHELL_PART = eINSTANCE.getShellCmd_ShellPart();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ShellPartImpl <em>Shell Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ShellPartImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getShellPart()
     * @generated
     */
    EClass SHELL_PART = eINSTANCE.getShellPart();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SHELL_PART__VAL = eINSTANCE.getShellPart_Val();

    /**
     * The meta object literal for the '<em><b>Cmd</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SHELL_PART__CMD = eINSTANCE.getShellPart_Cmd();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.VarSlashSymImpl <em>Var Slash Sym</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.VarSlashSymImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getVarSlashSym()
     * @generated
     */
    EClass VAR_SLASH_SYM = eINSTANCE.getVarSlashSym();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VAR_SLASH_SYM__NAME = eINSTANCE.getVarSlashSym_Name();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.IfEqImpl <em>If Eq</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.IfEqImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getIfEq()
     * @generated
     */
    EClass IF_EQ = eINSTANCE.getIfEq();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.IfNEqImpl <em>If NEq</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.IfNEqImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getIfNEq()
     * @generated
     */
    EClass IF_NEQ = eINSTANCE.getIfNEq();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.IfndefImpl <em>Ifndef</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.IfndefImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getIfndef()
     * @generated
     */
    EClass IFNDEF = eINSTANCE.getIfndef();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IFNDEF__NAME = eINSTANCE.getIfndef_Name();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.HostProgramImpl <em>Host Program</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.HostProgramImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getHostProgram()
     * @generated
     */
    EClass HOST_PROGRAM = eINSTANCE.getHostProgram();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HOST_PROGRAM__NAME = eINSTANCE.getHostProgram_Name();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HOST_PROGRAM__VARIABLE = eINSTANCE.getHostProgram_Variable();

    /**
     * The meta object literal for the '<em><b>Inner</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HOST_PROGRAM__INNER = eINSTANCE.getHostProgram_Inner();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectImpl <em>Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getObject()
     * @generated
     */
    EClass OBJECT = eINSTANCE.getObject();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.TargetImpl <em>Target</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.TargetImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getTarget()
     * @generated
     */
    EClass TARGET = eINSTANCE.getTarget();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TARGET__TARGET = eINSTANCE.getTarget_Target();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TARGET__VALUES = eINSTANCE.getTarget_Values();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.MyVariableImpl <em>My Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.MyVariableImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getMyVariable()
     * @generated
     */
    EClass MY_VARIABLE = eINSTANCE.getMyVariable();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MY_VARIABLE__NAME = eINSTANCE.getMyVariable_Name();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_VARIABLE__VARIABLE = eINSTANCE.getMyVariable_Variable();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.Obj_yImpl <em>Obj y</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.Obj_yImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getObj_y()
     * @generated
     */
    EClass OBJ_Y = eINSTANCE.getObj_y();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJ_Y__VALUE = eINSTANCE.getObj_y_Value();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.Obj_mImpl <em>Obj m</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.Obj_mImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getObj_m()
     * @generated
     */
    EClass OBJ_M = eINSTANCE.getObj_m();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJ_M__VALUE = eINSTANCE.getObj_m_Value();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectFileImpl <em>Object File</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectFileImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getObjectFile()
     * @generated
     */
    EClass OBJECT_FILE = eINSTANCE.getObjectFile();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectSingleFileImpl <em>Object Single File</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectSingleFileImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getObjectSingleFile()
     * @generated
     */
    EClass OBJECT_SINGLE_FILE = eINSTANCE.getObjectSingleFile();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECT_SINGLE_FILE__NAME = eINSTANCE.getObjectSingleFile_Name();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectVariableImpl <em>Object Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectVariableImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getObjectVariable()
     * @generated
     */
    EClass OBJECT_VARIABLE = eINSTANCE.getObjectVariable();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT_VARIABLE__VALUE = eINSTANCE.getObjectVariable_Value();

    /**
     * The meta object literal for the '<em><b>Additional</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECT_VARIABLE__ADDITIONAL = eINSTANCE.getObjectVariable_Additional();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectShellCmdImpl <em>Object Shell Cmd</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectShellCmdImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getObjectShellCmd()
     * @generated
     */
    EClass OBJECT_SHELL_CMD = eINSTANCE.getObjectShellCmd();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT_SHELL_CMD__VALUE = eINSTANCE.getObjectShellCmd_Value();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectStringImpl <em>Object String</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectStringImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getObjectString()
     * @generated
     */
    EClass OBJECT_STRING = eINSTANCE.getObjectString();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectShellCharImpl <em>Object Shell Char</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectShellCharImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getObjectShellChar()
     * @generated
     */
    EClass OBJECT_SHELL_CHAR = eINSTANCE.getObjectShellChar();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECT_SHELL_CHAR__VALUE = eINSTANCE.getObjectShellChar_Value();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectDirImpl <em>Object Dir</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.ObjectDirImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getObjectDir()
     * @generated
     */
    EClass OBJECT_DIR = eINSTANCE.getObjectDir();

    /**
     * The meta object literal for the '{@link at.jku.weiner.kefax.kbuild.kbuild.impl.IncludeImpl <em>Include</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.IncludeImpl
     * @see at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildPackageImpl#getInclude()
     * @generated
     */
    EClass INCLUDE = eINSTANCE.getInclude();

  }

} //KbuildPackage
