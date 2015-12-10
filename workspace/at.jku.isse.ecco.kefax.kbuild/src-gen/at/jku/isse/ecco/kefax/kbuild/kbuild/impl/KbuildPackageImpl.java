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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class KbuildPackageImpl extends EPackageImpl implements KbuildPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass buildEntryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass entryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass object_YEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass object_MEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assignEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assignExtraEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valuesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass shellCmdEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass shellPartEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass varSlashSymEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifEqEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifNEqEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifndefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass hostProgramEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass targetEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myVariableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass obj_yEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass obj_mEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectFileEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectSingleFileEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectVariableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectShellCmdEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectStringEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectShellCharEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectDirEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass includeEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.KbuildPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private KbuildPackageImpl()
  {
    super(eNS_URI, KbuildFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link KbuildPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static KbuildPackage init()
  {
    if (isInited) return (KbuildPackage)EPackage.Registry.INSTANCE.getEPackage(KbuildPackage.eNS_URI);

    // Obtain or create and register package
    KbuildPackageImpl theKbuildPackage = (KbuildPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof KbuildPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new KbuildPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theKbuildPackage.createPackageContents();

    // Initialize created meta-data
    theKbuildPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theKbuildPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(KbuildPackage.eNS_URI, theKbuildPackage);
    return theKbuildPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_BuildEntry()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBuildEntry()
  {
    return buildEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBuildEntry_Value()
  {
    return (EReference)buildEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEntry()
  {
    return entryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEntry_Variable()
  {
    return (EReference)entryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEntry_Value()
  {
    return (EReference)entryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIf()
  {
    return ifEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIf_Shell()
  {
    return (EReference)ifEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIf_Value()
  {
    return (EReference)ifEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIf_Elsevalue()
  {
    return (EReference)ifEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObject_Y()
  {
    return object_YEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObject_M()
  {
    return object_MEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssign()
  {
    return assignEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssignExtra()
  {
    return assignExtraEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getValues()
  {
    return valuesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getValues_Values()
  {
    return (EReference)valuesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getValue()
  {
    return valueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariable()
  {
    return variableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getShellCmd()
  {
    return shellCmdEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getShellCmd_Name()
  {
    return (EAttribute)shellCmdEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getShellCmd_ShellPart()
  {
    return (EReference)shellCmdEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getShellPart()
  {
    return shellPartEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getShellPart_Val()
  {
    return (EReference)shellPartEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getShellPart_Cmd()
  {
    return (EReference)shellPartEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVarSlashSym()
  {
    return varSlashSymEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVarSlashSym_Name()
  {
    return (EAttribute)varSlashSymEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfEq()
  {
    return ifEqEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfNEq()
  {
    return ifNEqEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfndef()
  {
    return ifndefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIfndef_Name()
  {
    return (EAttribute)ifndefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getHostProgram()
  {
    return hostProgramEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getHostProgram_Name()
  {
    return (EAttribute)hostProgramEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getHostProgram_Variable()
  {
    return (EReference)hostProgramEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getHostProgram_Inner()
  {
    return (EReference)hostProgramEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObject()
  {
    return objectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTarget()
  {
    return targetEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTarget_Target()
  {
    return (EReference)targetEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTarget_Values()
  {
    return (EReference)targetEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMyVariable()
  {
    return myVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMyVariable_Name()
  {
    return (EAttribute)myVariableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMyVariable_Variable()
  {
    return (EReference)myVariableEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObj_y()
  {
    return obj_yEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObj_y_Value()
  {
    return (EReference)obj_yEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObj_m()
  {
    return obj_mEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObj_m_Value()
  {
    return (EReference)obj_mEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObjectFile()
  {
    return objectFileEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObjectSingleFile()
  {
    return objectSingleFileEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getObjectSingleFile_Name()
  {
    return (EAttribute)objectSingleFileEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObjectVariable()
  {
    return objectVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObjectVariable_Value()
  {
    return (EReference)objectVariableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getObjectVariable_Additional()
  {
    return (EAttribute)objectVariableEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObjectShellCmd()
  {
    return objectShellCmdEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObjectShellCmd_Value()
  {
    return (EReference)objectShellCmdEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObjectString()
  {
    return objectStringEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObjectShellChar()
  {
    return objectShellCharEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getObjectShellChar_Value()
  {
    return (EAttribute)objectShellCharEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObjectDir()
  {
    return objectDirEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInclude()
  {
    return includeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public KbuildFactory getKbuildFactory()
  {
    return (KbuildFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    modelEClass = createEClass(MODEL);
    createEReference(modelEClass, MODEL__BUILD_ENTRY);

    buildEntryEClass = createEClass(BUILD_ENTRY);
    createEReference(buildEntryEClass, BUILD_ENTRY__VALUE);

    entryEClass = createEClass(ENTRY);
    createEReference(entryEClass, ENTRY__VARIABLE);
    createEReference(entryEClass, ENTRY__VALUE);

    ifEClass = createEClass(IF);
    createEReference(ifEClass, IF__SHELL);
    createEReference(ifEClass, IF__VALUE);
    createEReference(ifEClass, IF__ELSEVALUE);

    object_YEClass = createEClass(OBJECT_Y);

    object_MEClass = createEClass(OBJECT_M);

    assignEClass = createEClass(ASSIGN);

    assignExtraEClass = createEClass(ASSIGN_EXTRA);

    valuesEClass = createEClass(VALUES);
    createEReference(valuesEClass, VALUES__VALUES);

    valueEClass = createEClass(VALUE);

    variableEClass = createEClass(VARIABLE);

    shellCmdEClass = createEClass(SHELL_CMD);
    createEAttribute(shellCmdEClass, SHELL_CMD__NAME);
    createEReference(shellCmdEClass, SHELL_CMD__SHELL_PART);

    shellPartEClass = createEClass(SHELL_PART);
    createEReference(shellPartEClass, SHELL_PART__VAL);
    createEReference(shellPartEClass, SHELL_PART__CMD);

    varSlashSymEClass = createEClass(VAR_SLASH_SYM);
    createEAttribute(varSlashSymEClass, VAR_SLASH_SYM__NAME);

    ifEqEClass = createEClass(IF_EQ);

    ifNEqEClass = createEClass(IF_NEQ);

    ifndefEClass = createEClass(IFNDEF);
    createEAttribute(ifndefEClass, IFNDEF__NAME);

    hostProgramEClass = createEClass(HOST_PROGRAM);
    createEAttribute(hostProgramEClass, HOST_PROGRAM__NAME);
    createEReference(hostProgramEClass, HOST_PROGRAM__VARIABLE);
    createEReference(hostProgramEClass, HOST_PROGRAM__INNER);

    objectEClass = createEClass(OBJECT);

    targetEClass = createEClass(TARGET);
    createEReference(targetEClass, TARGET__TARGET);
    createEReference(targetEClass, TARGET__VALUES);

    myVariableEClass = createEClass(MY_VARIABLE);
    createEAttribute(myVariableEClass, MY_VARIABLE__NAME);
    createEReference(myVariableEClass, MY_VARIABLE__VARIABLE);

    obj_yEClass = createEClass(OBJ_Y);
    createEReference(obj_yEClass, OBJ_Y__VALUE);

    obj_mEClass = createEClass(OBJ_M);
    createEReference(obj_mEClass, OBJ_M__VALUE);

    objectFileEClass = createEClass(OBJECT_FILE);

    objectSingleFileEClass = createEClass(OBJECT_SINGLE_FILE);
    createEAttribute(objectSingleFileEClass, OBJECT_SINGLE_FILE__NAME);

    objectVariableEClass = createEClass(OBJECT_VARIABLE);
    createEReference(objectVariableEClass, OBJECT_VARIABLE__VALUE);
    createEAttribute(objectVariableEClass, OBJECT_VARIABLE__ADDITIONAL);

    objectShellCmdEClass = createEClass(OBJECT_SHELL_CMD);
    createEReference(objectShellCmdEClass, OBJECT_SHELL_CMD__VALUE);

    objectStringEClass = createEClass(OBJECT_STRING);

    objectShellCharEClass = createEClass(OBJECT_SHELL_CHAR);
    createEAttribute(objectShellCharEClass, OBJECT_SHELL_CHAR__VALUE);

    objectDirEClass = createEClass(OBJECT_DIR);

    includeEClass = createEClass(INCLUDE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    assignEClass.getESuperTypes().add(this.getAssignExtra());
    valuesEClass.getESuperTypes().add(this.getAssign());
    variableEClass.getESuperTypes().add(this.getIf());
    variableEClass.getESuperTypes().add(this.getVarSlashSym());
    ifEqEClass.getESuperTypes().add(this.getBuildEntry());
    ifNEqEClass.getESuperTypes().add(this.getBuildEntry());
    ifndefEClass.getESuperTypes().add(this.getBuildEntry());
    hostProgramEClass.getESuperTypes().add(this.getBuildEntry());
    objectEClass.getESuperTypes().add(this.getBuildEntry());
    targetEClass.getESuperTypes().add(this.getBuildEntry());
    myVariableEClass.getESuperTypes().add(this.getBuildEntry());
    obj_yEClass.getESuperTypes().add(this.getObject_Y());
    obj_mEClass.getESuperTypes().add(this.getObject_M());
    objectFileEClass.getESuperTypes().add(this.getValue());
    objectSingleFileEClass.getESuperTypes().add(this.getValue());
    objectVariableEClass.getESuperTypes().add(this.getValue());
    objectShellCmdEClass.getESuperTypes().add(this.getValue());
    objectStringEClass.getESuperTypes().add(this.getValue());
    objectShellCharEClass.getESuperTypes().add(this.getValue());
    objectDirEClass.getESuperTypes().add(this.getValue());
    includeEClass.getESuperTypes().add(this.getShellCmd());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_BuildEntry(), this.getBuildEntry(), null, "buildEntry", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(buildEntryEClass, BuildEntry.class, "BuildEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBuildEntry_Value(), ecorePackage.getEObject(), null, "value", null, 0, 1, BuildEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(entryEClass, Entry.class, "Entry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEntry_Variable(), this.getVariable(), null, "variable", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEntry_Value(), this.getAssignExtra(), null, "value", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ifEClass, If.class, "If", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIf_Shell(), this.getShellCmd(), null, "shell", null, 0, 1, If.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIf_Value(), ecorePackage.getEObject(), null, "value", null, 0, 1, If.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIf_Elsevalue(), ecorePackage.getEObject(), null, "elsevalue", null, 0, 1, If.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(object_YEClass, Object_Y.class, "Object_Y", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(object_MEClass, Object_M.class, "Object_M", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(assignEClass, Assign.class, "Assign", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(assignExtraEClass, AssignExtra.class, "AssignExtra", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(valuesEClass, Values.class, "Values", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getValues_Values(), this.getValue(), null, "values", null, 0, -1, Values.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueEClass, Value.class, "Value", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(shellCmdEClass, ShellCmd.class, "ShellCmd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getShellCmd_Name(), ecorePackage.getEString(), "name", null, 0, 1, ShellCmd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getShellCmd_ShellPart(), this.getShellPart(), null, "shellPart", null, 0, -1, ShellCmd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(shellPartEClass, ShellPart.class, "ShellPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getShellPart_Val(), this.getVarSlashSym(), null, "val", null, 0, 1, ShellPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getShellPart_Cmd(), this.getShellCmd(), null, "cmd", null, 0, 1, ShellPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(varSlashSymEClass, VarSlashSym.class, "VarSlashSym", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVarSlashSym_Name(), ecorePackage.getEString(), "name", null, 0, 1, VarSlashSym.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ifEqEClass, IfEq.class, "IfEq", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(ifNEqEClass, IfNEq.class, "IfNEq", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(ifndefEClass, Ifndef.class, "Ifndef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIfndef_Name(), ecorePackage.getEString(), "name", null, 0, 1, Ifndef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(hostProgramEClass, HostProgram.class, "HostProgram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getHostProgram_Name(), ecorePackage.getEString(), "name", null, 0, 1, HostProgram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getHostProgram_Variable(), this.getVariable(), null, "variable", null, 0, 1, HostProgram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getHostProgram_Inner(), this.getAssign(), null, "inner", null, 0, 1, HostProgram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectEClass, at.jku.isse.ecco.kefax.kbuild.kbuild.Object.class, "Object", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(targetEClass, Target.class, "Target", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTarget_Target(), this.getValues(), null, "target", null, 0, 1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTarget_Values(), this.getValues(), null, "values", null, 0, -1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(myVariableEClass, MyVariable.class, "MyVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMyVariable_Name(), ecorePackage.getEString(), "name", null, 0, 1, MyVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMyVariable_Variable(), this.getVariable(), null, "variable", null, 0, 1, MyVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(obj_yEClass, Obj_y.class, "Obj_y", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getObj_y_Value(), this.getAssignExtra(), null, "value", null, 0, 1, Obj_y.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(obj_mEClass, Obj_m.class, "Obj_m", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getObj_m_Value(), this.getAssignExtra(), null, "value", null, 0, 1, Obj_m.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectFileEClass, ObjectFile.class, "ObjectFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(objectSingleFileEClass, ObjectSingleFile.class, "ObjectSingleFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getObjectSingleFile_Name(), ecorePackage.getEString(), "name", null, 0, 1, ObjectSingleFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectVariableEClass, ObjectVariable.class, "ObjectVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getObjectVariable_Value(), this.getVariable(), null, "value", null, 0, 1, ObjectVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getObjectVariable_Additional(), ecorePackage.getEString(), "additional", null, 0, 1, ObjectVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectShellCmdEClass, ObjectShellCmd.class, "ObjectShellCmd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getObjectShellCmd_Value(), this.getShellCmd(), null, "value", null, 0, 1, ObjectShellCmd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectStringEClass, ObjectString.class, "ObjectString", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(objectShellCharEClass, ObjectShellChar.class, "ObjectShellChar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getObjectShellChar_Value(), ecorePackage.getEString(), "value", null, 0, 1, ObjectShellChar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectDirEClass, ObjectDir.class, "ObjectDir", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(includeEClass, Include.class, "Include", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //KbuildPackageImpl
