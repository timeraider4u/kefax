/**
 */
package at.jku.weiner.c.preprocess.preprocess;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage
 * @generated
 */
public interface PreprocessFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PreprocessFactory eINSTANCE = at.jku.weiner.c.preprocess.preprocess.impl.PreprocessFactoryImpl.init();

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
	 * Returns a new object of class '<em>Warning Directive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Warning Directive</em>'.
	 * @generated
	 */
	WarningDirective createWarningDirective();

	/**
	 * Returns a new object of class '<em>Un Define Directive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Un Define Directive</em>'.
	 * @generated
	 */
	UnDefineDirective createUnDefineDirective();

	/**
	 * Returns a new object of class '<em>Conditional Directive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conditional Directive</em>'.
	 * @generated
	 */
	ConditionalDirective createConditionalDirective();

	/**
	 * Returns a new object of class '<em>If Conditional</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Conditional</em>'.
	 * @generated
	 */
	IfConditional createIfConditional();

	/**
	 * Returns a new object of class '<em>If Def Conditional</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Def Conditional</em>'.
	 * @generated
	 */
	IfDefConditional createIfDefConditional();

	/**
	 * Returns a new object of class '<em>If Not Def Conditional</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Not Def Conditional</em>'.
	 * @generated
	 */
	IfNotDefConditional createIfNotDefConditional();

	/**
	 * Returns a new object of class '<em>El If Conditional</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>El If Conditional</em>'.
	 * @generated
	 */
	ElIfConditional createElIfConditional();

	/**
	 * Returns a new object of class '<em>Else Conditional</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Else Conditional</em>'.
	 * @generated
	 */
	ElseConditional createElseConditional();

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
	 * Returns a new object of class '<em>Preprocess</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Preprocess</em>'.
	 * @generated
	 */
	Preprocess createPreprocess();

	/**
	 * Returns a new object of class '<em>Group Opt2</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Group Opt2</em>'.
	 * @generated
	 */
	GroupOpt2 createGroupOpt2();

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
	 * Returns a new object of class '<em>Primary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primary Expression</em>'.
	 * @generated
	 */
	PrimaryExpression createPrimaryExpression();

	/**
	 * Returns a new object of class '<em>If Abstract Conditional</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Abstract Conditional</em>'.
	 * @generated
	 */
	IfAbstractConditional createIfAbstractConditional();

	/**
	 * Returns a new object of class '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression</em>'.
	 * @generated
	 */
	Expression createExpression();

	/**
	 * Returns a new object of class '<em>Line Directive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Line Directive</em>'.
	 * @generated
	 */
	LineDirective createLineDirective();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PreprocessPackage getPreprocessPackage();

} //PreprocessFactory
