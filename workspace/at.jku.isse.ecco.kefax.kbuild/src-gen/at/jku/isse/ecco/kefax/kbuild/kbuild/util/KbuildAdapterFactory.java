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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see at.jku.isse.ecco.kefax.kbuild.kbuild.KbuildPackage
 * @generated
 */
public class KbuildAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static KbuildPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public KbuildAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = KbuildPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected KbuildSwitch<Adapter> modelSwitch =
    new KbuildSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseBuildEntry(BuildEntry object)
      {
        return createBuildEntryAdapter();
      }
      @Override
      public Adapter caseEntry(Entry object)
      {
        return createEntryAdapter();
      }
      @Override
      public Adapter caseIf(If object)
      {
        return createIfAdapter();
      }
      @Override
      public Adapter caseObject_Y(Object_Y object)
      {
        return createObject_YAdapter();
      }
      @Override
      public Adapter caseObject_M(Object_M object)
      {
        return createObject_MAdapter();
      }
      @Override
      public Adapter caseAssign(Assign object)
      {
        return createAssignAdapter();
      }
      @Override
      public Adapter caseAssignExtra(AssignExtra object)
      {
        return createAssignExtraAdapter();
      }
      @Override
      public Adapter caseValues(Values object)
      {
        return createValuesAdapter();
      }
      @Override
      public Adapter caseValue(Value object)
      {
        return createValueAdapter();
      }
      @Override
      public Adapter caseVariable(Variable object)
      {
        return createVariableAdapter();
      }
      @Override
      public Adapter caseShellCmd(ShellCmd object)
      {
        return createShellCmdAdapter();
      }
      @Override
      public Adapter caseShellPart(ShellPart object)
      {
        return createShellPartAdapter();
      }
      @Override
      public Adapter caseVarSlashSym(VarSlashSym object)
      {
        return createVarSlashSymAdapter();
      }
      @Override
      public Adapter caseIfEq(IfEq object)
      {
        return createIfEqAdapter();
      }
      @Override
      public Adapter caseIfNEq(IfNEq object)
      {
        return createIfNEqAdapter();
      }
      @Override
      public Adapter caseIfndef(Ifndef object)
      {
        return createIfndefAdapter();
      }
      @Override
      public Adapter caseHostProgram(HostProgram object)
      {
        return createHostProgramAdapter();
      }
      @Override
      public Adapter caseObject(at.jku.isse.ecco.kefax.kbuild.kbuild.Object object)
      {
        return createObjectAdapter();
      }
      @Override
      public Adapter caseTarget(Target object)
      {
        return createTargetAdapter();
      }
      @Override
      public Adapter caseMyVariable(MyVariable object)
      {
        return createMyVariableAdapter();
      }
      @Override
      public Adapter caseObj_y(Obj_y object)
      {
        return createObj_yAdapter();
      }
      @Override
      public Adapter caseObj_m(Obj_m object)
      {
        return createObj_mAdapter();
      }
      @Override
      public Adapter caseObjectFile(ObjectFile object)
      {
        return createObjectFileAdapter();
      }
      @Override
      public Adapter caseObjectSingleFile(ObjectSingleFile object)
      {
        return createObjectSingleFileAdapter();
      }
      @Override
      public Adapter caseObjectVariable(ObjectVariable object)
      {
        return createObjectVariableAdapter();
      }
      @Override
      public Adapter caseObjectShellCmd(ObjectShellCmd object)
      {
        return createObjectShellCmdAdapter();
      }
      @Override
      public Adapter caseObjectString(ObjectString object)
      {
        return createObjectStringAdapter();
      }
      @Override
      public Adapter caseObjectShellChar(ObjectShellChar object)
      {
        return createObjectShellCharAdapter();
      }
      @Override
      public Adapter caseObjectDir(ObjectDir object)
      {
        return createObjectDirAdapter();
      }
      @Override
      public Adapter caseInclude(Include object)
      {
        return createIncludeAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.BuildEntry <em>Build Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.BuildEntry
   * @generated
   */
  public Adapter createBuildEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.Entry <em>Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.Entry
   * @generated
   */
  public Adapter createEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.If <em>If</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.If
   * @generated
   */
  public Adapter createIfAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.Object_Y <em>Object Y</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.Object_Y
   * @generated
   */
  public Adapter createObject_YAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.Object_M <em>Object M</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.Object_M
   * @generated
   */
  public Adapter createObject_MAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.Assign <em>Assign</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.Assign
   * @generated
   */
  public Adapter createAssignAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.AssignExtra <em>Assign Extra</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.AssignExtra
   * @generated
   */
  public Adapter createAssignExtraAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.Values <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.Values
   * @generated
   */
  public Adapter createValuesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.Value
   * @generated
   */
  public Adapter createValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.Variable
   * @generated
   */
  public Adapter createVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.ShellCmd <em>Shell Cmd</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.ShellCmd
   * @generated
   */
  public Adapter createShellCmdAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.ShellPart <em>Shell Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.ShellPart
   * @generated
   */
  public Adapter createShellPartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.VarSlashSym <em>Var Slash Sym</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.VarSlashSym
   * @generated
   */
  public Adapter createVarSlashSymAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.IfEq <em>If Eq</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.IfEq
   * @generated
   */
  public Adapter createIfEqAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.IfNEq <em>If NEq</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.IfNEq
   * @generated
   */
  public Adapter createIfNEqAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.Ifndef <em>Ifndef</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.Ifndef
   * @generated
   */
  public Adapter createIfndefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.HostProgram <em>Host Program</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.HostProgram
   * @generated
   */
  public Adapter createHostProgramAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.Object <em>Object</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.Object
   * @generated
   */
  public Adapter createObjectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.Target <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.Target
   * @generated
   */
  public Adapter createTargetAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.MyVariable <em>My Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.MyVariable
   * @generated
   */
  public Adapter createMyVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.Obj_y <em>Obj y</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.Obj_y
   * @generated
   */
  public Adapter createObj_yAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.Obj_m <em>Obj m</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.Obj_m
   * @generated
   */
  public Adapter createObj_mAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.ObjectFile <em>Object File</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.ObjectFile
   * @generated
   */
  public Adapter createObjectFileAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.ObjectSingleFile <em>Object Single File</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.ObjectSingleFile
   * @generated
   */
  public Adapter createObjectSingleFileAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.ObjectVariable <em>Object Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.ObjectVariable
   * @generated
   */
  public Adapter createObjectVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.ObjectShellCmd <em>Object Shell Cmd</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.ObjectShellCmd
   * @generated
   */
  public Adapter createObjectShellCmdAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.ObjectString <em>Object String</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.ObjectString
   * @generated
   */
  public Adapter createObjectStringAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.ObjectShellChar <em>Object Shell Char</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.ObjectShellChar
   * @generated
   */
  public Adapter createObjectShellCharAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.ObjectDir <em>Object Dir</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.ObjectDir
   * @generated
   */
  public Adapter createObjectDirAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.jku.isse.ecco.kefax.kbuild.kbuild.Include <em>Include</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.jku.isse.ecco.kefax.kbuild.kbuild.Include
   * @generated
   */
  public Adapter createIncludeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //KbuildAdapterFactory
