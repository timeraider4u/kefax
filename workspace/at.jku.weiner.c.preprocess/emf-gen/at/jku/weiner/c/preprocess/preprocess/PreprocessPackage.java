/**
 */
package at.jku.weiner.c.preprocess.preprocess;

import at.jku.weiner.c.common.common.CommonPackage;

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
 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessFactory
 * @model kind="package"
 * @generated
 */
public interface PreprocessPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "preprocess";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.jku.at/weiner/c/preprocess/Preprocess";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "preprocess";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PreprocessPackage eINSTANCE = at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl.init();

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.GroupOptImpl <em>Group Opt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.GroupOptImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getGroupOpt()
	 * @generated
	 */
	int GROUP_OPT = 0;

	/**
	 * The feature id for the '<em><b>Lines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_OPT__LINES = 0;

	/**
	 * The number of structural features of the '<em>Group Opt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_OPT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.SourceCodeLineImpl <em>Source Code Line</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.SourceCodeLineImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getSourceCodeLine()
	 * @generated
	 */
	int SOURCE_CODE_LINE = 1;

	/**
	 * The number of structural features of the '<em>Source Code Line</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_CODE_LINE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.IncludeDirectiveImpl <em>Include Directive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.IncludeDirectiveImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getIncludeDirective()
	 * @generated
	 */
	int INCLUDE_DIRECTIVE = 2;

	/**
	 * The feature id for the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_DIRECTIVE__STRING = 0;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_DIRECTIVE__UNIT = 1;

	/**
	 * The feature id for the '<em><b>Next</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_DIRECTIVE__NEXT = 2;

	/**
	 * The number of structural features of the '<em>Include Directive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_DIRECTIVE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.DefineDirectiveImpl <em>Define Directive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.DefineDirectiveImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getDefineDirective()
	 * @generated
	 */
	int DEFINE_DIRECTIVE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINE_DIRECTIVE__ID = 0;

	/**
	 * The number of structural features of the '<em>Define Directive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINE_DIRECTIVE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.IdentifierListImpl <em>Identifier List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.IdentifierListImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getIdentifierList()
	 * @generated
	 */
	int IDENTIFIER_LIST = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_LIST__ID = 0;

	/**
	 * The feature id for the '<em><b>Variadic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_LIST__VARIADIC = 1;

	/**
	 * The feature id for the '<em><b>Var ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_LIST__VAR_ID = 2;

	/**
	 * The number of structural features of the '<em>Identifier List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_LIST_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ErrorDirectiveImpl <em>Error Directive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.ErrorDirectiveImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getErrorDirective()
	 * @generated
	 */
	int ERROR_DIRECTIVE = 5;

	/**
	 * The feature id for the '<em><b>Msg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DIRECTIVE__MSG = 0;

	/**
	 * The number of structural features of the '<em>Error Directive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DIRECTIVE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.WarningDirectiveImpl <em>Warning Directive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.WarningDirectiveImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getWarningDirective()
	 * @generated
	 */
	int WARNING_DIRECTIVE = 6;

	/**
	 * The feature id for the '<em><b>Msg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WARNING_DIRECTIVE__MSG = 0;

	/**
	 * The number of structural features of the '<em>Warning Directive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WARNING_DIRECTIVE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.UnDefineDirectiveImpl <em>Un Define Directive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.UnDefineDirectiveImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getUnDefineDirective()
	 * @generated
	 */
	int UN_DEFINE_DIRECTIVE = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UN_DEFINE_DIRECTIVE__ID = 0;

	/**
	 * The number of structural features of the '<em>Un Define Directive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UN_DEFINE_DIRECTIVE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ConditionalDirectiveImpl <em>Conditional Directive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.ConditionalDirectiveImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getConditionalDirective()
	 * @generated
	 */
	int CONDITIONAL_DIRECTIVE = 8;

	/**
	 * The feature id for the '<em><b>Conditional</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_DIRECTIVE__CONDITIONAL = 0;

	/**
	 * The feature id for the '<em><b>Elifs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_DIRECTIVE__ELIFS = 1;

	/**
	 * The feature id for the '<em><b>Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_DIRECTIVE__ELSE = 2;

	/**
	 * The feature id for the '<em><b>Branch Taken</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_DIRECTIVE__BRANCH_TAKEN = 3;

	/**
	 * The number of structural features of the '<em>Conditional Directive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_DIRECTIVE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.IfAbstractConditionalImpl <em>If Abstract Conditional</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.IfAbstractConditionalImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getIfAbstractConditional()
	 * @generated
	 */
	int IF_ABSTRACT_CONDITIONAL = 24;

	/**
	 * The feature id for the '<em><b>Branch Taken</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_ABSTRACT_CONDITIONAL__BRANCH_TAKEN = 0;

	/**
	 * The feature id for the '<em><b>Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_ABSTRACT_CONDITIONAL__GROUP = 1;

	/**
	 * The number of structural features of the '<em>If Abstract Conditional</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_ABSTRACT_CONDITIONAL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.IfConditionalImpl <em>If Conditional</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.IfConditionalImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getIfConditional()
	 * @generated
	 */
	int IF_CONDITIONAL = 9;

	/**
	 * The feature id for the '<em><b>Branch Taken</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_CONDITIONAL__BRANCH_TAKEN = IF_ABSTRACT_CONDITIONAL__BRANCH_TAKEN;

	/**
	 * The feature id for the '<em><b>Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_CONDITIONAL__GROUP = IF_ABSTRACT_CONDITIONAL__GROUP;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_CONDITIONAL__EXPRESSION = IF_ABSTRACT_CONDITIONAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>If Conditional</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_CONDITIONAL_FEATURE_COUNT = IF_ABSTRACT_CONDITIONAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.IfDefConditionalImpl <em>If Def Conditional</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.IfDefConditionalImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getIfDefConditional()
	 * @generated
	 */
	int IF_DEF_CONDITIONAL = 10;

	/**
	 * The feature id for the '<em><b>Branch Taken</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_DEF_CONDITIONAL__BRANCH_TAKEN = IF_ABSTRACT_CONDITIONAL__BRANCH_TAKEN;

	/**
	 * The feature id for the '<em><b>Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_DEF_CONDITIONAL__GROUP = IF_ABSTRACT_CONDITIONAL__GROUP;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_DEF_CONDITIONAL__ID = IF_ABSTRACT_CONDITIONAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>If Def Conditional</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_DEF_CONDITIONAL_FEATURE_COUNT = IF_ABSTRACT_CONDITIONAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.IfNotDefConditionalImpl <em>If Not Def Conditional</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.IfNotDefConditionalImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getIfNotDefConditional()
	 * @generated
	 */
	int IF_NOT_DEF_CONDITIONAL = 11;

	/**
	 * The feature id for the '<em><b>Branch Taken</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_NOT_DEF_CONDITIONAL__BRANCH_TAKEN = IF_ABSTRACT_CONDITIONAL__BRANCH_TAKEN;

	/**
	 * The feature id for the '<em><b>Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_NOT_DEF_CONDITIONAL__GROUP = IF_ABSTRACT_CONDITIONAL__GROUP;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_NOT_DEF_CONDITIONAL__ID = IF_ABSTRACT_CONDITIONAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>If Not Def Conditional</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_NOT_DEF_CONDITIONAL_FEATURE_COUNT = IF_ABSTRACT_CONDITIONAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ElIfConditionalImpl <em>El If Conditional</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.ElIfConditionalImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getElIfConditional()
	 * @generated
	 */
	int EL_IF_CONDITIONAL = 12;

	/**
	 * The feature id for the '<em><b>Branch Taken</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EL_IF_CONDITIONAL__BRANCH_TAKEN = IF_ABSTRACT_CONDITIONAL__BRANCH_TAKEN;

	/**
	 * The feature id for the '<em><b>Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EL_IF_CONDITIONAL__GROUP = IF_ABSTRACT_CONDITIONAL__GROUP;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EL_IF_CONDITIONAL__EXPRESSION = IF_ABSTRACT_CONDITIONAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>El If Conditional</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EL_IF_CONDITIONAL_FEATURE_COUNT = IF_ABSTRACT_CONDITIONAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ElseConditionalImpl <em>Else Conditional</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.ElseConditionalImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getElseConditional()
	 * @generated
	 */
	int ELSE_CONDITIONAL = 13;

	/**
	 * The feature id for the '<em><b>Branch Taken</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELSE_CONDITIONAL__BRANCH_TAKEN = IF_ABSTRACT_CONDITIONAL__BRANCH_TAKEN;

	/**
	 * The feature id for the '<em><b>Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELSE_CONDITIONAL__GROUP = IF_ABSTRACT_CONDITIONAL__GROUP;

	/**
	 * The number of structural features of the '<em>Else Conditional</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELSE_CONDITIONAL_FEATURE_COUNT = IF_ABSTRACT_CONDITIONAL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.PragmaDirectiveImpl <em>Pragma Directive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PragmaDirectiveImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getPragmaDirective()
	 * @generated
	 */
	int PRAGMA_DIRECTIVE = 14;

	/**
	 * The feature id for the '<em><b>Pragma</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRAGMA_DIRECTIVE__PRAGMA = 0;

	/**
	 * The number of structural features of the '<em>Pragma Directive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRAGMA_DIRECTIVE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.NullDirectiveImpl <em>Null Directive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.NullDirectiveImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getNullDirective()
	 * @generated
	 */
	int NULL_DIRECTIVE = 15;

	/**
	 * The number of structural features of the '<em>Null Directive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_DIRECTIVE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.PreprocessImpl <em>Preprocess</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getPreprocess()
	 * @generated
	 */
	int PREPROCESS = 16;

	/**
	 * The feature id for the '<em><b>Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREPROCESS__GROUP = CommonPackage.PREPROCESS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Preprocess</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREPROCESS_FEATURE_COUNT = CommonPackage.PREPROCESS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.GroupOpt2Impl <em>Group Opt2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.GroupOpt2Impl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getGroupOpt2()
	 * @generated
	 */
	int GROUP_OPT2 = 17;

	/**
	 * The feature id for the '<em><b>Lines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_OPT2__LINES = GROUP_OPT__LINES;

	/**
	 * The number of structural features of the '<em>Group Opt2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_OPT2_FEATURE_COUNT = GROUP_OPT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.PreprocessorDirectivesImpl <em>Preprocessor Directives</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessorDirectivesImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getPreprocessorDirectives()
	 * @generated
	 */
	int PREPROCESSOR_DIRECTIVES = 18;

	/**
	 * The feature id for the '<em><b>Directive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREPROCESSOR_DIRECTIVES__DIRECTIVE = SOURCE_CODE_LINE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Preprocessor Directives</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREPROCESSOR_DIRECTIVES_FEATURE_COUNT = SOURCE_CODE_LINE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.DefineObjectMacroImpl <em>Define Object Macro</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.DefineObjectMacroImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getDefineObjectMacro()
	 * @generated
	 */
	int DEFINE_OBJECT_MACRO = 19;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINE_OBJECT_MACRO__ID = DEFINE_DIRECTIVE__ID;

	/**
	 * The feature id for the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINE_OBJECT_MACRO__STRING = DEFINE_DIRECTIVE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Define Object Macro</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINE_OBJECT_MACRO_FEATURE_COUNT = DEFINE_DIRECTIVE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.DefineFunctionLikeMacroImpl <em>Define Function Like Macro</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.DefineFunctionLikeMacroImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getDefineFunctionLikeMacro()
	 * @generated
	 */
	int DEFINE_FUNCTION_LIKE_MACRO = 20;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINE_FUNCTION_LIKE_MACRO__ID = DEFINE_DIRECTIVE__ID;

	/**
	 * The feature id for the '<em><b>List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINE_FUNCTION_LIKE_MACRO__LIST = DEFINE_DIRECTIVE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINE_FUNCTION_LIKE_MACRO__STRING = DEFINE_DIRECTIVE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Define Function Like Macro</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINE_FUNCTION_LIKE_MACRO_FEATURE_COUNT = DEFINE_DIRECTIVE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.NewLineLineImpl <em>New Line Line</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.NewLineLineImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getNewLineLine()
	 * @generated
	 */
	int NEW_LINE_LINE = 21;

	/**
	 * The number of structural features of the '<em>New Line Line</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_LINE_LINE_FEATURE_COUNT = SOURCE_CODE_LINE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.CodeImpl <em>Code</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.CodeImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getCode()
	 * @generated
	 */
	int CODE = 22;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE__CODE = SOURCE_CODE_LINE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Code</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_FEATURE_COUNT = SOURCE_CODE_LINE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.ExpressionImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 25;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = CommonPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.PrimaryExpressionImpl <em>Primary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PrimaryExpressionImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getPrimaryExpression()
	 * @generated
	 */
	int PRIMARY_EXPRESSION = 23;

	/**
	 * The feature id for the '<em><b>Defined</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_EXPRESSION__DEFINED = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_EXPRESSION__ID = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Const</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_EXPRESSION__CONST = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parentheses</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_EXPRESSION__PARENTHESES = EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Primary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.LineDirectiveImpl <em>Line Directive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.LineDirectiveImpl
	 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getLineDirective()
	 * @generated
	 */
	int LINE_DIRECTIVE = 26;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_DIRECTIVE__LINE = 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_DIRECTIVE__PATH = 1;

	/**
	 * The number of structural features of the '<em>Line Directive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_DIRECTIVE_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.GroupOpt <em>Group Opt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group Opt</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.GroupOpt
	 * @generated
	 */
	EClass getGroupOpt();

	/**
	 * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.preprocess.preprocess.GroupOpt#getLines <em>Lines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lines</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.GroupOpt#getLines()
	 * @see #getGroupOpt()
	 * @generated
	 */
	EReference getGroupOpt_Lines();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.SourceCodeLine <em>Source Code Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Code Line</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.SourceCodeLine
	 * @generated
	 */
	EClass getSourceCodeLine();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.IncludeDirective <em>Include Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Include Directive</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.IncludeDirective
	 * @generated
	 */
	EClass getIncludeDirective();

	/**
	 * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.IncludeDirective#getString <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.IncludeDirective#getString()
	 * @see #getIncludeDirective()
	 * @generated
	 */
	EAttribute getIncludeDirective_String();

	/**
	 * Returns the meta object for the reference '{@link at.jku.weiner.c.preprocess.preprocess.IncludeDirective#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Unit</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.IncludeDirective#getUnit()
	 * @see #getIncludeDirective()
	 * @generated
	 */
	EReference getIncludeDirective_Unit();

	/**
	 * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.IncludeDirective#isNext <em>Next</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Next</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.IncludeDirective#isNext()
	 * @see #getIncludeDirective()
	 * @generated
	 */
	EAttribute getIncludeDirective_Next();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.DefineDirective <em>Define Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Define Directive</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.DefineDirective
	 * @generated
	 */
	EClass getDefineDirective();

	/**
	 * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.DefineDirective#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.DefineDirective#getId()
	 * @see #getDefineDirective()
	 * @generated
	 */
	EAttribute getDefineDirective_Id();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.IdentifierList <em>Identifier List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifier List</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.IdentifierList
	 * @generated
	 */
	EClass getIdentifierList();

	/**
	 * Returns the meta object for the attribute list '{@link at.jku.weiner.c.preprocess.preprocess.IdentifierList#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Id</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.IdentifierList#getId()
	 * @see #getIdentifierList()
	 * @generated
	 */
	EAttribute getIdentifierList_Id();

	/**
	 * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.IdentifierList#isVariadic <em>Variadic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variadic</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.IdentifierList#isVariadic()
	 * @see #getIdentifierList()
	 * @generated
	 */
	EAttribute getIdentifierList_Variadic();

	/**
	 * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.IdentifierList#getVarID <em>Var ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Var ID</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.IdentifierList#getVarID()
	 * @see #getIdentifierList()
	 * @generated
	 */
	EAttribute getIdentifierList_VarID();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.ErrorDirective <em>Error Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Directive</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.ErrorDirective
	 * @generated
	 */
	EClass getErrorDirective();

	/**
	 * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.ErrorDirective#getMsg <em>Msg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Msg</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.ErrorDirective#getMsg()
	 * @see #getErrorDirective()
	 * @generated
	 */
	EAttribute getErrorDirective_Msg();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.WarningDirective <em>Warning Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Warning Directive</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.WarningDirective
	 * @generated
	 */
	EClass getWarningDirective();

	/**
	 * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.WarningDirective#getMsg <em>Msg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Msg</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.WarningDirective#getMsg()
	 * @see #getWarningDirective()
	 * @generated
	 */
	EAttribute getWarningDirective_Msg();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.UnDefineDirective <em>Un Define Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Un Define Directive</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.UnDefineDirective
	 * @generated
	 */
	EClass getUnDefineDirective();

	/**
	 * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.UnDefineDirective#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.UnDefineDirective#getId()
	 * @see #getUnDefineDirective()
	 * @generated
	 */
	EAttribute getUnDefineDirective_Id();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.ConditionalDirective <em>Conditional Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditional Directive</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.ConditionalDirective
	 * @generated
	 */
	EClass getConditionalDirective();

	/**
	 * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.ConditionalDirective#getConditional <em>Conditional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Conditional</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.ConditionalDirective#getConditional()
	 * @see #getConditionalDirective()
	 * @generated
	 */
	EReference getConditionalDirective_Conditional();

	/**
	 * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.preprocess.preprocess.ConditionalDirective#getElifs <em>Elifs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elifs</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.ConditionalDirective#getElifs()
	 * @see #getConditionalDirective()
	 * @generated
	 */
	EReference getConditionalDirective_Elifs();

	/**
	 * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.ConditionalDirective#getElse <em>Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.ConditionalDirective#getElse()
	 * @see #getConditionalDirective()
	 * @generated
	 */
	EReference getConditionalDirective_Else();

	/**
	 * Returns the meta object for the reference '{@link at.jku.weiner.c.preprocess.preprocess.ConditionalDirective#getBranchTaken <em>Branch Taken</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Branch Taken</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.ConditionalDirective#getBranchTaken()
	 * @see #getConditionalDirective()
	 * @generated
	 */
	EReference getConditionalDirective_BranchTaken();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.IfConditional <em>If Conditional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Conditional</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.IfConditional
	 * @generated
	 */
	EClass getIfConditional();

	/**
	 * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.IfConditional#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.IfConditional#getExpression()
	 * @see #getIfConditional()
	 * @generated
	 */
	EReference getIfConditional_Expression();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.IfDefConditional <em>If Def Conditional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Def Conditional</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.IfDefConditional
	 * @generated
	 */
	EClass getIfDefConditional();

	/**
	 * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.IfDefConditional#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.IfDefConditional#getId()
	 * @see #getIfDefConditional()
	 * @generated
	 */
	EAttribute getIfDefConditional_Id();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.IfNotDefConditional <em>If Not Def Conditional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Not Def Conditional</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.IfNotDefConditional
	 * @generated
	 */
	EClass getIfNotDefConditional();

	/**
	 * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.IfNotDefConditional#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.IfNotDefConditional#getId()
	 * @see #getIfNotDefConditional()
	 * @generated
	 */
	EAttribute getIfNotDefConditional_Id();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.ElIfConditional <em>El If Conditional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>El If Conditional</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.ElIfConditional
	 * @generated
	 */
	EClass getElIfConditional();

	/**
	 * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.ElIfConditional#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.ElIfConditional#getExpression()
	 * @see #getElIfConditional()
	 * @generated
	 */
	EReference getElIfConditional_Expression();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.ElseConditional <em>Else Conditional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Else Conditional</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.ElseConditional
	 * @generated
	 */
	EClass getElseConditional();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.PragmaDirective <em>Pragma Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pragma Directive</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.PragmaDirective
	 * @generated
	 */
	EClass getPragmaDirective();

	/**
	 * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.PragmaDirective#getPragma <em>Pragma</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pragma</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.PragmaDirective#getPragma()
	 * @see #getPragmaDirective()
	 * @generated
	 */
	EAttribute getPragmaDirective_Pragma();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.NullDirective <em>Null Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Directive</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.NullDirective
	 * @generated
	 */
	EClass getNullDirective();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.Preprocess <em>Preprocess</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Preprocess</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.Preprocess
	 * @generated
	 */
	EClass getPreprocess();

	/**
	 * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.Preprocess#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Group</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.Preprocess#getGroup()
	 * @see #getPreprocess()
	 * @generated
	 */
	EReference getPreprocess_Group();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.GroupOpt2 <em>Group Opt2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group Opt2</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.GroupOpt2
	 * @generated
	 */
	EClass getGroupOpt2();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives <em>Preprocessor Directives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Preprocessor Directives</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives
	 * @generated
	 */
	EClass getPreprocessorDirectives();

	/**
	 * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives#getDirective <em>Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Directive</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives#getDirective()
	 * @see #getPreprocessorDirectives()
	 * @generated
	 */
	EReference getPreprocessorDirectives_Directive();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro <em>Define Object Macro</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Define Object Macro</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro
	 * @generated
	 */
	EClass getDefineObjectMacro();

	/**
	 * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro#getString <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.DefineObjectMacro#getString()
	 * @see #getDefineObjectMacro()
	 * @generated
	 */
	EAttribute getDefineObjectMacro_String();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro <em>Define Function Like Macro</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Define Function Like Macro</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro
	 * @generated
	 */
	EClass getDefineFunctionLikeMacro();

	/**
	 * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro#getList <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>List</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro#getList()
	 * @see #getDefineFunctionLikeMacro()
	 * @generated
	 */
	EReference getDefineFunctionLikeMacro_List();

	/**
	 * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro#getString <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.DefineFunctionLikeMacro#getString()
	 * @see #getDefineFunctionLikeMacro()
	 * @generated
	 */
	EAttribute getDefineFunctionLikeMacro_String();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.NewLineLine <em>New Line Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Line Line</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.NewLineLine
	 * @generated
	 */
	EClass getNewLineLine();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.Code <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.Code
	 * @generated
	 */
	EClass getCode();

	/**
	 * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.Code#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.Code#getCode()
	 * @see #getCode()
	 * @generated
	 */
	EAttribute getCode_Code();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.PrimaryExpression <em>Primary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primary Expression</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.PrimaryExpression
	 * @generated
	 */
	EClass getPrimaryExpression();

	/**
	 * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#isDefined <em>Defined</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Defined</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#isDefined()
	 * @see #getPrimaryExpression()
	 * @generated
	 */
	EAttribute getPrimaryExpression_Defined();

	/**
	 * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#getId()
	 * @see #getPrimaryExpression()
	 * @generated
	 */
	EAttribute getPrimaryExpression_Id();

	/**
	 * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#getConst <em>Const</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Const</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#getConst()
	 * @see #getPrimaryExpression()
	 * @generated
	 */
	EAttribute getPrimaryExpression_Const();

	/**
	 * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#getExpr()
	 * @see #getPrimaryExpression()
	 * @generated
	 */
	EReference getPrimaryExpression_Expr();

	/**
	 * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#isParentheses <em>Parentheses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parentheses</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.PrimaryExpression#isParentheses()
	 * @see #getPrimaryExpression()
	 * @generated
	 */
	EAttribute getPrimaryExpression_Parentheses();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.IfAbstractConditional <em>If Abstract Conditional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Abstract Conditional</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.IfAbstractConditional
	 * @generated
	 */
	EClass getIfAbstractConditional();

	/**
	 * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.IfAbstractConditional#isBranchTaken <em>Branch Taken</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Branch Taken</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.IfAbstractConditional#isBranchTaken()
	 * @see #getIfAbstractConditional()
	 * @generated
	 */
	EAttribute getIfAbstractConditional_BranchTaken();

	/**
	 * Returns the meta object for the containment reference '{@link at.jku.weiner.c.preprocess.preprocess.IfAbstractConditional#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Group</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.IfAbstractConditional#getGroup()
	 * @see #getIfAbstractConditional()
	 * @generated
	 */
	EReference getIfAbstractConditional_Group();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link at.jku.weiner.c.preprocess.preprocess.LineDirective <em>Line Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line Directive</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.LineDirective
	 * @generated
	 */
	EClass getLineDirective();

	/**
	 * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.LineDirective#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.LineDirective#getLine()
	 * @see #getLineDirective()
	 * @generated
	 */
	EAttribute getLineDirective_Line();

	/**
	 * Returns the meta object for the attribute '{@link at.jku.weiner.c.preprocess.preprocess.LineDirective#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see at.jku.weiner.c.preprocess.preprocess.LineDirective#getPath()
	 * @see #getLineDirective()
	 * @generated
	 */
	EAttribute getLineDirective_Path();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PreprocessFactory getPreprocessFactory();

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
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.GroupOptImpl <em>Group Opt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.GroupOptImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getGroupOpt()
		 * @generated
		 */
		EClass GROUP_OPT = eINSTANCE.getGroupOpt();

		/**
		 * The meta object literal for the '<em><b>Lines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP_OPT__LINES = eINSTANCE.getGroupOpt_Lines();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.SourceCodeLineImpl <em>Source Code Line</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.SourceCodeLineImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getSourceCodeLine()
		 * @generated
		 */
		EClass SOURCE_CODE_LINE = eINSTANCE.getSourceCodeLine();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.IncludeDirectiveImpl <em>Include Directive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.IncludeDirectiveImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getIncludeDirective()
		 * @generated
		 */
		EClass INCLUDE_DIRECTIVE = eINSTANCE.getIncludeDirective();

		/**
		 * The meta object literal for the '<em><b>String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INCLUDE_DIRECTIVE__STRING = eINSTANCE.getIncludeDirective_String();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INCLUDE_DIRECTIVE__UNIT = eINSTANCE.getIncludeDirective_Unit();

		/**
		 * The meta object literal for the '<em><b>Next</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INCLUDE_DIRECTIVE__NEXT = eINSTANCE.getIncludeDirective_Next();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.DefineDirectiveImpl <em>Define Directive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.DefineDirectiveImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getDefineDirective()
		 * @generated
		 */
		EClass DEFINE_DIRECTIVE = eINSTANCE.getDefineDirective();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFINE_DIRECTIVE__ID = eINSTANCE.getDefineDirective_Id();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.IdentifierListImpl <em>Identifier List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.IdentifierListImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getIdentifierList()
		 * @generated
		 */
		EClass IDENTIFIER_LIST = eINSTANCE.getIdentifierList();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIER_LIST__ID = eINSTANCE.getIdentifierList_Id();

		/**
		 * The meta object literal for the '<em><b>Variadic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIER_LIST__VARIADIC = eINSTANCE.getIdentifierList_Variadic();

		/**
		 * The meta object literal for the '<em><b>Var ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIER_LIST__VAR_ID = eINSTANCE.getIdentifierList_VarID();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ErrorDirectiveImpl <em>Error Directive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.ErrorDirectiveImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getErrorDirective()
		 * @generated
		 */
		EClass ERROR_DIRECTIVE = eINSTANCE.getErrorDirective();

		/**
		 * The meta object literal for the '<em><b>Msg</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_DIRECTIVE__MSG = eINSTANCE.getErrorDirective_Msg();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.WarningDirectiveImpl <em>Warning Directive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.WarningDirectiveImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getWarningDirective()
		 * @generated
		 */
		EClass WARNING_DIRECTIVE = eINSTANCE.getWarningDirective();

		/**
		 * The meta object literal for the '<em><b>Msg</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WARNING_DIRECTIVE__MSG = eINSTANCE.getWarningDirective_Msg();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.UnDefineDirectiveImpl <em>Un Define Directive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.UnDefineDirectiveImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getUnDefineDirective()
		 * @generated
		 */
		EClass UN_DEFINE_DIRECTIVE = eINSTANCE.getUnDefineDirective();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UN_DEFINE_DIRECTIVE__ID = eINSTANCE.getUnDefineDirective_Id();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ConditionalDirectiveImpl <em>Conditional Directive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.ConditionalDirectiveImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getConditionalDirective()
		 * @generated
		 */
		EClass CONDITIONAL_DIRECTIVE = eINSTANCE.getConditionalDirective();

		/**
		 * The meta object literal for the '<em><b>Conditional</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_DIRECTIVE__CONDITIONAL = eINSTANCE.getConditionalDirective_Conditional();

		/**
		 * The meta object literal for the '<em><b>Elifs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_DIRECTIVE__ELIFS = eINSTANCE.getConditionalDirective_Elifs();

		/**
		 * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_DIRECTIVE__ELSE = eINSTANCE.getConditionalDirective_Else();

		/**
		 * The meta object literal for the '<em><b>Branch Taken</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_DIRECTIVE__BRANCH_TAKEN = eINSTANCE.getConditionalDirective_BranchTaken();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.IfConditionalImpl <em>If Conditional</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.IfConditionalImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getIfConditional()
		 * @generated
		 */
		EClass IF_CONDITIONAL = eINSTANCE.getIfConditional();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_CONDITIONAL__EXPRESSION = eINSTANCE.getIfConditional_Expression();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.IfDefConditionalImpl <em>If Def Conditional</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.IfDefConditionalImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getIfDefConditional()
		 * @generated
		 */
		EClass IF_DEF_CONDITIONAL = eINSTANCE.getIfDefConditional();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IF_DEF_CONDITIONAL__ID = eINSTANCE.getIfDefConditional_Id();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.IfNotDefConditionalImpl <em>If Not Def Conditional</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.IfNotDefConditionalImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getIfNotDefConditional()
		 * @generated
		 */
		EClass IF_NOT_DEF_CONDITIONAL = eINSTANCE.getIfNotDefConditional();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IF_NOT_DEF_CONDITIONAL__ID = eINSTANCE.getIfNotDefConditional_Id();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ElIfConditionalImpl <em>El If Conditional</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.ElIfConditionalImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getElIfConditional()
		 * @generated
		 */
		EClass EL_IF_CONDITIONAL = eINSTANCE.getElIfConditional();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EL_IF_CONDITIONAL__EXPRESSION = eINSTANCE.getElIfConditional_Expression();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ElseConditionalImpl <em>Else Conditional</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.ElseConditionalImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getElseConditional()
		 * @generated
		 */
		EClass ELSE_CONDITIONAL = eINSTANCE.getElseConditional();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.PragmaDirectiveImpl <em>Pragma Directive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PragmaDirectiveImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getPragmaDirective()
		 * @generated
		 */
		EClass PRAGMA_DIRECTIVE = eINSTANCE.getPragmaDirective();

		/**
		 * The meta object literal for the '<em><b>Pragma</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRAGMA_DIRECTIVE__PRAGMA = eINSTANCE.getPragmaDirective_Pragma();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.NullDirectiveImpl <em>Null Directive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.NullDirectiveImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getNullDirective()
		 * @generated
		 */
		EClass NULL_DIRECTIVE = eINSTANCE.getNullDirective();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.PreprocessImpl <em>Preprocess</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getPreprocess()
		 * @generated
		 */
		EClass PREPROCESS = eINSTANCE.getPreprocess();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREPROCESS__GROUP = eINSTANCE.getPreprocess_Group();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.GroupOpt2Impl <em>Group Opt2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.GroupOpt2Impl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getGroupOpt2()
		 * @generated
		 */
		EClass GROUP_OPT2 = eINSTANCE.getGroupOpt2();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.PreprocessorDirectivesImpl <em>Preprocessor Directives</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessorDirectivesImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getPreprocessorDirectives()
		 * @generated
		 */
		EClass PREPROCESSOR_DIRECTIVES = eINSTANCE.getPreprocessorDirectives();

		/**
		 * The meta object literal for the '<em><b>Directive</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREPROCESSOR_DIRECTIVES__DIRECTIVE = eINSTANCE.getPreprocessorDirectives_Directive();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.DefineObjectMacroImpl <em>Define Object Macro</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.DefineObjectMacroImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getDefineObjectMacro()
		 * @generated
		 */
		EClass DEFINE_OBJECT_MACRO = eINSTANCE.getDefineObjectMacro();

		/**
		 * The meta object literal for the '<em><b>String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFINE_OBJECT_MACRO__STRING = eINSTANCE.getDefineObjectMacro_String();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.DefineFunctionLikeMacroImpl <em>Define Function Like Macro</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.DefineFunctionLikeMacroImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getDefineFunctionLikeMacro()
		 * @generated
		 */
		EClass DEFINE_FUNCTION_LIKE_MACRO = eINSTANCE.getDefineFunctionLikeMacro();

		/**
		 * The meta object literal for the '<em><b>List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFINE_FUNCTION_LIKE_MACRO__LIST = eINSTANCE.getDefineFunctionLikeMacro_List();

		/**
		 * The meta object literal for the '<em><b>String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFINE_FUNCTION_LIKE_MACRO__STRING = eINSTANCE.getDefineFunctionLikeMacro_String();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.NewLineLineImpl <em>New Line Line</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.NewLineLineImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getNewLineLine()
		 * @generated
		 */
		EClass NEW_LINE_LINE = eINSTANCE.getNewLineLine();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.CodeImpl <em>Code</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.CodeImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getCode()
		 * @generated
		 */
		EClass CODE = eINSTANCE.getCode();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE__CODE = eINSTANCE.getCode_Code();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.PrimaryExpressionImpl <em>Primary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PrimaryExpressionImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getPrimaryExpression()
		 * @generated
		 */
		EClass PRIMARY_EXPRESSION = eINSTANCE.getPrimaryExpression();

		/**
		 * The meta object literal for the '<em><b>Defined</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMARY_EXPRESSION__DEFINED = eINSTANCE.getPrimaryExpression_Defined();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMARY_EXPRESSION__ID = eINSTANCE.getPrimaryExpression_Id();

		/**
		 * The meta object literal for the '<em><b>Const</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMARY_EXPRESSION__CONST = eINSTANCE.getPrimaryExpression_Const();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMARY_EXPRESSION__EXPR = eINSTANCE.getPrimaryExpression_Expr();

		/**
		 * The meta object literal for the '<em><b>Parentheses</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMARY_EXPRESSION__PARENTHESES = eINSTANCE.getPrimaryExpression_Parentheses();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.IfAbstractConditionalImpl <em>If Abstract Conditional</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.IfAbstractConditionalImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getIfAbstractConditional()
		 * @generated
		 */
		EClass IF_ABSTRACT_CONDITIONAL = eINSTANCE.getIfAbstractConditional();

		/**
		 * The meta object literal for the '<em><b>Branch Taken</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IF_ABSTRACT_CONDITIONAL__BRANCH_TAKEN = eINSTANCE.getIfAbstractConditional_BranchTaken();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_ABSTRACT_CONDITIONAL__GROUP = eINSTANCE.getIfAbstractConditional_Group();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.ExpressionImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link at.jku.weiner.c.preprocess.preprocess.impl.LineDirectiveImpl <em>Line Directive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.LineDirectiveImpl
		 * @see at.jku.weiner.c.preprocess.preprocess.impl.PreprocessPackageImpl#getLineDirective()
		 * @generated
		 */
		EClass LINE_DIRECTIVE = eINSTANCE.getLineDirective();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINE_DIRECTIVE__LINE = eINSTANCE.getLineDirective_Line();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINE_DIRECTIVE__PATH = eINSTANCE.getLineDirective_Path();

	}

} //PreprocessPackage
