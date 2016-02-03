/**
 */
package at.jku.isse.ecco.kefax.kbuild.kbuild.util;

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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see at.jku.isse.ecco.kefax.kbuild.kbuild.KbuildPackage
 * @generated
 */
public class KbuildSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static KbuildPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public KbuildSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = KbuildPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case KbuildPackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.BUILD_ENTRY:
      {
        BuildEntry buildEntry = (BuildEntry)theEObject;
        T result = caseBuildEntry(buildEntry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.ENTRY:
      {
        Entry entry = (Entry)theEObject;
        T result = caseEntry(entry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.IF:
      {
        If if_ = (If)theEObject;
        T result = caseIf(if_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.OBJECT_Y:
      {
        Object_Y object_Y = (Object_Y)theEObject;
        T result = caseObject_Y(object_Y);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.OBJECT_M:
      {
        Object_M object_M = (Object_M)theEObject;
        T result = caseObject_M(object_M);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.ASSIGN:
      {
        Assign assign = (Assign)theEObject;
        T result = caseAssign(assign);
        if (result == null) result = caseAssignExtra(assign);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.ASSIGN_EXTRA:
      {
        AssignExtra assignExtra = (AssignExtra)theEObject;
        T result = caseAssignExtra(assignExtra);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.VALUES:
      {
        Values values = (Values)theEObject;
        T result = caseValues(values);
        if (result == null) result = caseAssign(values);
        if (result == null) result = caseAssignExtra(values);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.VALUE:
      {
        Value value = (Value)theEObject;
        T result = caseValue(value);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.VARIABLE:
      {
        Variable variable = (Variable)theEObject;
        T result = caseVariable(variable);
        if (result == null) result = caseIf(variable);
        if (result == null) result = caseVarSlashSym(variable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.SHELL_CMD:
      {
        ShellCmd shellCmd = (ShellCmd)theEObject;
        T result = caseShellCmd(shellCmd);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.SHELL_PART:
      {
        ShellPart shellPart = (ShellPart)theEObject;
        T result = caseShellPart(shellPart);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.VAR_SLASH_SYM:
      {
        VarSlashSym varSlashSym = (VarSlashSym)theEObject;
        T result = caseVarSlashSym(varSlashSym);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.IF_EQ:
      {
        IfEq ifEq = (IfEq)theEObject;
        T result = caseIfEq(ifEq);
        if (result == null) result = caseBuildEntry(ifEq);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.IF_NEQ:
      {
        IfNEq ifNEq = (IfNEq)theEObject;
        T result = caseIfNEq(ifNEq);
        if (result == null) result = caseBuildEntry(ifNEq);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.IFNDEF:
      {
        Ifndef ifndef = (Ifndef)theEObject;
        T result = caseIfndef(ifndef);
        if (result == null) result = caseBuildEntry(ifndef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.HOST_PROGRAM:
      {
        HostProgram hostProgram = (HostProgram)theEObject;
        T result = caseHostProgram(hostProgram);
        if (result == null) result = caseBuildEntry(hostProgram);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.OBJECT:
      {
        at.jku.isse.ecco.kefax.kbuild.kbuild.Object object = (at.jku.isse.ecco.kefax.kbuild.kbuild.Object)theEObject;
        T result = caseObject(object);
        if (result == null) result = caseBuildEntry(object);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.TARGET:
      {
        Target target = (Target)theEObject;
        T result = caseTarget(target);
        if (result == null) result = caseBuildEntry(target);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.MY_VARIABLE:
      {
        MyVariable myVariable = (MyVariable)theEObject;
        T result = caseMyVariable(myVariable);
        if (result == null) result = caseBuildEntry(myVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.OBJ_Y:
      {
        Obj_y obj_y = (Obj_y)theEObject;
        T result = caseObj_y(obj_y);
        if (result == null) result = caseObject_Y(obj_y);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.OBJ_M:
      {
        Obj_m obj_m = (Obj_m)theEObject;
        T result = caseObj_m(obj_m);
        if (result == null) result = caseObject_M(obj_m);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.OBJECT_FILE:
      {
        ObjectFile objectFile = (ObjectFile)theEObject;
        T result = caseObjectFile(objectFile);
        if (result == null) result = caseValue(objectFile);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.OBJECT_SINGLE_FILE:
      {
        ObjectSingleFile objectSingleFile = (ObjectSingleFile)theEObject;
        T result = caseObjectSingleFile(objectSingleFile);
        if (result == null) result = caseValue(objectSingleFile);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.OBJECT_VARIABLE:
      {
        ObjectVariable objectVariable = (ObjectVariable)theEObject;
        T result = caseObjectVariable(objectVariable);
        if (result == null) result = caseValue(objectVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.OBJECT_SHELL_CMD:
      {
        ObjectShellCmd objectShellCmd = (ObjectShellCmd)theEObject;
        T result = caseObjectShellCmd(objectShellCmd);
        if (result == null) result = caseValue(objectShellCmd);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.OBJECT_STRING:
      {
        ObjectString objectString = (ObjectString)theEObject;
        T result = caseObjectString(objectString);
        if (result == null) result = caseValue(objectString);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.OBJECT_SHELL_CHAR:
      {
        ObjectShellChar objectShellChar = (ObjectShellChar)theEObject;
        T result = caseObjectShellChar(objectShellChar);
        if (result == null) result = caseValue(objectShellChar);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.OBJECT_DIR:
      {
        ObjectDir objectDir = (ObjectDir)theEObject;
        T result = caseObjectDir(objectDir);
        if (result == null) result = caseValue(objectDir);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case KbuildPackage.INCLUDE:
      {
        Include include = (Include)theEObject;
        T result = caseInclude(include);
        if (result == null) result = caseShellCmd(include);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModel(Model object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Build Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Build Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBuildEntry(BuildEntry object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEntry(Entry object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIf(If object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Object Y</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Object Y</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObject_Y(Object_Y object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Object M</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Object M</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObject_M(Object_M object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assign</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assign</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssign(Assign object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assign Extra</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assign Extra</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssignExtra(AssignExtra object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Values</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Values</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValues(Values object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValue(Value object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariable(Variable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Shell Cmd</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Shell Cmd</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseShellCmd(ShellCmd object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Shell Part</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Shell Part</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseShellPart(ShellPart object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Var Slash Sym</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Var Slash Sym</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVarSlashSym(VarSlashSym object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If Eq</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Eq</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfEq(IfEq object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If NEq</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If NEq</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfNEq(IfNEq object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ifndef</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ifndef</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfndef(Ifndef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Host Program</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Host Program</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHostProgram(HostProgram object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Object</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Object</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObject(at.jku.isse.ecco.kefax.kbuild.kbuild.Object object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Target</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Target</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTarget(Target object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>My Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>My Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMyVariable(MyVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Obj y</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Obj y</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObj_y(Obj_y object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Obj m</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Obj m</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObj_m(Obj_m object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Object File</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Object File</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObjectFile(ObjectFile object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Object Single File</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Object Single File</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObjectSingleFile(ObjectSingleFile object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Object Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Object Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObjectVariable(ObjectVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Object Shell Cmd</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Object Shell Cmd</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObjectShellCmd(ObjectShellCmd object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Object String</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Object String</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObjectString(ObjectString object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Object Shell Char</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Object Shell Char</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObjectShellChar(ObjectShellChar object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Object Dir</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Object Dir</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObjectDir(ObjectDir object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Include</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Include</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInclude(Include object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //KbuildSwitch
