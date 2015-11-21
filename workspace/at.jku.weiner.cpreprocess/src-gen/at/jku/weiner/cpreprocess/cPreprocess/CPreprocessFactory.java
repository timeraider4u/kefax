/**
 */
package at.jku.weiner.cpreprocess.cPreprocess;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see at.jku.weiner.cpreprocess.cPreprocess.CPreprocessPackage
 * @generated
 */
public interface CPreprocessFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CPreprocessFactory eINSTANCE = at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Translation Unit</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Translation Unit</em>'.
   * @generated
   */
  TranslationUnit createTranslationUnit();

  /**
   * Returns a new object of class '<em>Group Opt</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Group Opt</em>'.
   * @generated
   */
  GroupOpt createGroupOpt();

  /**
   * Returns a new object of class '<em>Source Code Line</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Source Code Line</em>'.
   * @generated
   */
  SourceCodeLine createSourceCodeLine();

  /**
   * Returns a new object of class '<em>Include Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Include Directive</em>'.
   * @generated
   */
  IncludeDirective createIncludeDirective();

  /**
   * Returns a new object of class '<em>Define Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Define Directive</em>'.
   * @generated
   */
  DefineDirective createDefineDirective();

  /**
   * Returns a new object of class '<em>Identifier List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Identifier List</em>'.
   * @generated
   */
  IdentifierList createIdentifierList();

  /**
   * Returns a new object of class '<em>Error Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Directive</em>'.
   * @generated
   */
  ErrorDirective createErrorDirective();

  /**
   * Returns a new object of class '<em>Un Define Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Un Define Directive</em>'.
   * @generated
   */
  UnDefineDirective createUnDefineDirective();

  /**
   * Returns a new object of class '<em>Pragma Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pragma Directive</em>'.
   * @generated
   */
  PragmaDirective createPragmaDirective();

  /**
   * Returns a new object of class '<em>Null Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Null Directive</em>'.
   * @generated
   */
  NullDirective createNullDirective();

  /**
   * Returns a new object of class '<em>Preprocessor Directives</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Preprocessor Directives</em>'.
   * @generated
   */
  PreprocessorDirectives createPreprocessorDirectives();

  /**
   * Returns a new object of class '<em>Define Object Macro</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Define Object Macro</em>'.
   * @generated
   */
  DefineObjectMacro createDefineObjectMacro();

  /**
   * Returns a new object of class '<em>Define Function Like Macro</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Define Function Like Macro</em>'.
   * @generated
   */
  DefineFunctionLikeMacro createDefineFunctionLikeMacro();

  /**
   * Returns a new object of class '<em>New Line Line</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>New Line Line</em>'.
   * @generated
   */
  NewLineLine createNewLineLine();

  /**
   * Returns a new object of class '<em>Code</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Code</em>'.
   * @generated
   */
  Code createCode();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  CPreprocessPackage getCPreprocessPackage();

} //CPreprocessFactory
