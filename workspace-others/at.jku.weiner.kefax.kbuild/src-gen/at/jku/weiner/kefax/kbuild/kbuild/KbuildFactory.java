/**
 */
package at.jku.weiner.kefax.kbuild.kbuild;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see at.jku.weiner.kefax.kbuild.kbuild.KbuildPackage
 * @generated
 */
public interface KbuildFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  KbuildFactory eINSTANCE = at.jku.weiner.kefax.kbuild.kbuild.impl.KbuildFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Build Entry</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Build Entry</em>'.
   * @generated
   */
  BuildEntry createBuildEntry();

  /**
   * Returns a new object of class '<em>Entry</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Entry</em>'.
   * @generated
   */
  Entry createEntry();

  /**
   * Returns a new object of class '<em>If</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If</em>'.
   * @generated
   */
  If createIf();

  /**
   * Returns a new object of class '<em>Object Y</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object Y</em>'.
   * @generated
   */
  Object_Y createObject_Y();

  /**
   * Returns a new object of class '<em>Object M</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object M</em>'.
   * @generated
   */
  Object_M createObject_M();

  /**
   * Returns a new object of class '<em>Assign</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assign</em>'.
   * @generated
   */
  Assign createAssign();

  /**
   * Returns a new object of class '<em>Assign Extra</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assign Extra</em>'.
   * @generated
   */
  AssignExtra createAssignExtra();

  /**
   * Returns a new object of class '<em>Values</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Values</em>'.
   * @generated
   */
  Values createValues();

  /**
   * Returns a new object of class '<em>Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value</em>'.
   * @generated
   */
  Value createValue();

  /**
   * Returns a new object of class '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable</em>'.
   * @generated
   */
  Variable createVariable();

  /**
   * Returns a new object of class '<em>Shell Cmd</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Shell Cmd</em>'.
   * @generated
   */
  ShellCmd createShellCmd();

  /**
   * Returns a new object of class '<em>Shell Part</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Shell Part</em>'.
   * @generated
   */
  ShellPart createShellPart();

  /**
   * Returns a new object of class '<em>Var Slash Sym</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Var Slash Sym</em>'.
   * @generated
   */
  VarSlashSym createVarSlashSym();

  /**
   * Returns a new object of class '<em>If Eq</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If Eq</em>'.
   * @generated
   */
  IfEq createIfEq();

  /**
   * Returns a new object of class '<em>If NEq</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If NEq</em>'.
   * @generated
   */
  IfNEq createIfNEq();

  /**
   * Returns a new object of class '<em>Ifndef</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ifndef</em>'.
   * @generated
   */
  Ifndef createIfndef();

  /**
   * Returns a new object of class '<em>Host Program</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Host Program</em>'.
   * @generated
   */
  HostProgram createHostProgram();

  /**
   * Returns a new object of class '<em>Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object</em>'.
   * @generated
   */
  Object createObject();

  /**
   * Returns a new object of class '<em>Target</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Target</em>'.
   * @generated
   */
  Target createTarget();

  /**
   * Returns a new object of class '<em>My Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>My Variable</em>'.
   * @generated
   */
  MyVariable createMyVariable();

  /**
   * Returns a new object of class '<em>Obj y</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Obj y</em>'.
   * @generated
   */
  Obj_y createObj_y();

  /**
   * Returns a new object of class '<em>Obj m</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Obj m</em>'.
   * @generated
   */
  Obj_m createObj_m();

  /**
   * Returns a new object of class '<em>Object File</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object File</em>'.
   * @generated
   */
  ObjectFile createObjectFile();

  /**
   * Returns a new object of class '<em>Object Single File</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object Single File</em>'.
   * @generated
   */
  ObjectSingleFile createObjectSingleFile();

  /**
   * Returns a new object of class '<em>Object Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object Variable</em>'.
   * @generated
   */
  ObjectVariable createObjectVariable();

  /**
   * Returns a new object of class '<em>Object Shell Cmd</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object Shell Cmd</em>'.
   * @generated
   */
  ObjectShellCmd createObjectShellCmd();

  /**
   * Returns a new object of class '<em>Object String</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object String</em>'.
   * @generated
   */
  ObjectString createObjectString();

  /**
   * Returns a new object of class '<em>Object Shell Char</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object Shell Char</em>'.
   * @generated
   */
  ObjectShellChar createObjectShellChar();

  /**
   * Returns a new object of class '<em>Object Dir</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object Dir</em>'.
   * @generated
   */
  ObjectDir createObjectDir();

  /**
   * Returns a new object of class '<em>Include</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Include</em>'.
   * @generated
   */
  Include createInclude();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  KbuildPackage getKbuildPackage();

} //KbuildFactory
