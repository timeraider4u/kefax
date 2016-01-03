/**
 */
package at.jku.weiner.c.cmdarguments.cmdArgs.impl;

import at.jku.weiner.c.cmdarguments.cmdArgs.*;

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
public class CmdArgsFactoryImpl extends EFactoryImpl implements CmdArgsFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static CmdArgsFactory init()
  {
    try
    {
      CmdArgsFactory theCmdArgsFactory = (CmdArgsFactory)EPackage.Registry.INSTANCE.getEFactory(CmdArgsPackage.eNS_URI);
      if (theCmdArgsFactory != null)
      {
        return theCmdArgsFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new CmdArgsFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CmdArgsFactoryImpl()
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
      case CmdArgsPackage.MODEL: return createModel();
      case CmdArgsPackage.CMD_LINE: return createCmdLine();
      case CmdArgsPackage.ARGUMENT: return createArgument();
      case CmdArgsPackage.MACRO: return createMacro();
      case CmdArgsPackage.INCLUDE_CMD: return createIncludeCmd();
      case CmdArgsPackage.SIMPLE_MACRO: return createSimpleMacro();
      case CmdArgsPackage.OBJECT_MACRO: return createObjectMacro();
      case CmdArgsPackage.FUNCTION_MACRO: return createFunctionMacro();
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
  public CmdLine createCmdLine()
  {
    CmdLineImpl cmdLine = new CmdLineImpl();
    return cmdLine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Argument createArgument()
  {
    ArgumentImpl argument = new ArgumentImpl();
    return argument;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Macro createMacro()
  {
    MacroImpl macro = new MacroImpl();
    return macro;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IncludeCmd createIncludeCmd()
  {
    IncludeCmdImpl includeCmd = new IncludeCmdImpl();
    return includeCmd;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleMacro createSimpleMacro()
  {
    SimpleMacroImpl simpleMacro = new SimpleMacroImpl();
    return simpleMacro;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectMacro createObjectMacro()
  {
    ObjectMacroImpl objectMacro = new ObjectMacroImpl();
    return objectMacro;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionMacro createFunctionMacro()
  {
    FunctionMacroImpl functionMacro = new FunctionMacroImpl();
    return functionMacro;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CmdArgsPackage getCmdArgsPackage()
  {
    return (CmdArgsPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static CmdArgsPackage getPackage()
  {
    return CmdArgsPackage.eINSTANCE;
  }

} //CmdArgsFactoryImpl
