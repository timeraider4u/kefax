/**
 */
package at.jku.isse.ecco.kefax.kbuild.kbuild.impl;

import at.jku.isse.ecco.kefax.kbuild.kbuild.Assign;
import at.jku.isse.ecco.kefax.kbuild.kbuild.AssignExtra;
import at.jku.isse.ecco.kefax.kbuild.kbuild.BuildEntry;
import at.jku.isse.ecco.kefax.kbuild.kbuild.Entry;
import at.jku.isse.ecco.kefax.kbuild.kbuild.HostProgram;
import at.jku.isse.ecco.kefax.kbuild.kbuild.If;
import at.jku.isse.ecco.kefax.kbuild.kbuild.IfEq;
import at.jku.isse.ecco.kefax.kbuild.kbuild.IfNEq;
import at.jku.isse.ecco.kefax.kbuild.kbuild.Ifndef;
import at.jku.isse.ecco.kefax.kbuild.kbuild.Include;
import at.jku.isse.ecco.kefax.kbuild.kbuild.KbuildFactory;
import at.jku.isse.ecco.kefax.kbuild.kbuild.KbuildPackage;
import at.jku.isse.ecco.kefax.kbuild.kbuild.Model;
import at.jku.isse.ecco.kefax.kbuild.kbuild.MyVariable;
import at.jku.isse.ecco.kefax.kbuild.kbuild.Obj_m;
import at.jku.isse.ecco.kefax.kbuild.kbuild.Obj_y;
import at.jku.isse.ecco.kefax.kbuild.kbuild.ObjectDir;
import at.jku.isse.ecco.kefax.kbuild.kbuild.ObjectFile;
import at.jku.isse.ecco.kefax.kbuild.kbuild.ObjectShellChar;
import at.jku.isse.ecco.kefax.kbuild.kbuild.ObjectShellCmd;
import at.jku.isse.ecco.kefax.kbuild.kbuild.ObjectSingleFile;
import at.jku.isse.ecco.kefax.kbuild.kbuild.ObjectString;
import at.jku.isse.ecco.kefax.kbuild.kbuild.ObjectVariable;
import at.jku.isse.ecco.kefax.kbuild.kbuild.Object_M;
import at.jku.isse.ecco.kefax.kbuild.kbuild.Object_Y;
import at.jku.isse.ecco.kefax.kbuild.kbuild.ShellCmd;
import at.jku.isse.ecco.kefax.kbuild.kbuild.ShellPart;
import at.jku.isse.ecco.kefax.kbuild.kbuild.Target;
import at.jku.isse.ecco.kefax.kbuild.kbuild.Value;
import at.jku.isse.ecco.kefax.kbuild.kbuild.Values;
import at.jku.isse.ecco.kefax.kbuild.kbuild.VarSlashSym;
import at.jku.isse.ecco.kefax.kbuild.kbuild.Variable;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class KbuildFactoryImpl extends EFactoryImpl implements KbuildFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static KbuildFactory init()
  {
    try
    {
      KbuildFactory theKbuildFactory = (KbuildFactory)EPackage.Registry.INSTANCE.getEFactory(KbuildPackage.eNS_URI);
      if (theKbuildFactory != null)
      {
        return theKbuildFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new KbuildFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public KbuildFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case KbuildPackage.MODEL: return createModel();
      case KbuildPackage.BUILD_ENTRY: return createBuildEntry();
      case KbuildPackage.ENTRY: return createEntry();
      case KbuildPackage.IF: return createIf();
      case KbuildPackage.OBJECT_Y: return createObject_Y();
      case KbuildPackage.OBJECT_M: return createObject_M();
      case KbuildPackage.ASSIGN: return createAssign();
      case KbuildPackage.ASSIGN_EXTRA: return createAssignExtra();
      case KbuildPackage.VALUES: return createValues();
      case KbuildPackage.VALUE: return createValue();
      case KbuildPackage.VARIABLE: return createVariable();
      case KbuildPackage.SHELL_CMD: return createShellCmd();
      case KbuildPackage.SHELL_PART: return createShellPart();
      case KbuildPackage.VAR_SLASH_SYM: return createVarSlashSym();
      case KbuildPackage.IF_EQ: return createIfEq();
      case KbuildPackage.IF_NEQ: return createIfNEq();
      case KbuildPackage.IFNDEF: return createIfndef();
      case KbuildPackage.HOST_PROGRAM: return createHostProgram();
      case KbuildPackage.OBJECT: return createObject();
      case KbuildPackage.TARGET: return createTarget();
      case KbuildPackage.MY_VARIABLE: return createMyVariable();
      case KbuildPackage.OBJ_Y: return createObj_y();
      case KbuildPackage.OBJ_M: return createObj_m();
      case KbuildPackage.OBJECT_FILE: return createObjectFile();
      case KbuildPackage.OBJECT_SINGLE_FILE: return createObjectSingleFile();
      case KbuildPackage.OBJECT_VARIABLE: return createObjectVariable();
      case KbuildPackage.OBJECT_SHELL_CMD: return createObjectShellCmd();
      case KbuildPackage.OBJECT_STRING: return createObjectString();
      case KbuildPackage.OBJECT_SHELL_CHAR: return createObjectShellChar();
      case KbuildPackage.OBJECT_DIR: return createObjectDir();
      case KbuildPackage.INCLUDE: return createInclude();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BuildEntry createBuildEntry()
  {
    BuildEntryImpl buildEntry = new BuildEntryImpl();
    return buildEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Entry createEntry()
  {
    EntryImpl entry = new EntryImpl();
    return entry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public If createIf()
  {
    IfImpl if_ = new IfImpl();
    return if_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object_Y createObject_Y()
  {
    Object_YImpl object_Y = new Object_YImpl();
    return object_Y;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object_M createObject_M()
  {
    Object_MImpl object_M = new Object_MImpl();
    return object_M;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Assign createAssign()
  {
    AssignImpl assign = new AssignImpl();
    return assign;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignExtra createAssignExtra()
  {
    AssignExtraImpl assignExtra = new AssignExtraImpl();
    return assignExtra;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Values createValues()
  {
    ValuesImpl values = new ValuesImpl();
    return values;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Value createValue()
  {
    ValueImpl value = new ValueImpl();
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable createVariable()
  {
    VariableImpl variable = new VariableImpl();
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShellCmd createShellCmd()
  {
    ShellCmdImpl shellCmd = new ShellCmdImpl();
    return shellCmd;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShellPart createShellPart()
  {
    ShellPartImpl shellPart = new ShellPartImpl();
    return shellPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VarSlashSym createVarSlashSym()
  {
    VarSlashSymImpl varSlashSym = new VarSlashSymImpl();
    return varSlashSym;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfEq createIfEq()
  {
    IfEqImpl ifEq = new IfEqImpl();
    return ifEq;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfNEq createIfNEq()
  {
    IfNEqImpl ifNEq = new IfNEqImpl();
    return ifNEq;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Ifndef createIfndef()
  {
    IfndefImpl ifndef = new IfndefImpl();
    return ifndef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HostProgram createHostProgram()
  {
    HostProgramImpl hostProgram = new HostProgramImpl();
    return hostProgram;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public at.jku.isse.ecco.kefax.kbuild.kbuild.Object createObject()
  {
    ObjectImpl object = new ObjectImpl();
    return object;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Target createTarget()
  {
    TargetImpl target = new TargetImpl();
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyVariable createMyVariable()
  {
    MyVariableImpl myVariable = new MyVariableImpl();
    return myVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Obj_y createObj_y()
  {
    Obj_yImpl obj_y = new Obj_yImpl();
    return obj_y;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Obj_m createObj_m()
  {
    Obj_mImpl obj_m = new Obj_mImpl();
    return obj_m;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectFile createObjectFile()
  {
    ObjectFileImpl objectFile = new ObjectFileImpl();
    return objectFile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectSingleFile createObjectSingleFile()
  {
    ObjectSingleFileImpl objectSingleFile = new ObjectSingleFileImpl();
    return objectSingleFile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectVariable createObjectVariable()
  {
    ObjectVariableImpl objectVariable = new ObjectVariableImpl();
    return objectVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectShellCmd createObjectShellCmd()
  {
    ObjectShellCmdImpl objectShellCmd = new ObjectShellCmdImpl();
    return objectShellCmd;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectString createObjectString()
  {
    ObjectStringImpl objectString = new ObjectStringImpl();
    return objectString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectShellChar createObjectShellChar()
  {
    ObjectShellCharImpl objectShellChar = new ObjectShellCharImpl();
    return objectShellChar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectDir createObjectDir()
  {
    ObjectDirImpl objectDir = new ObjectDirImpl();
    return objectDir;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Include createInclude()
  {
    IncludeImpl include = new IncludeImpl();
    return include;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public KbuildPackage getKbuildPackage()
  {
    return (KbuildPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static KbuildPackage getPackage()
  {
    return KbuildPackage.eINSTANCE;
  }

} //KbuildFactoryImpl
