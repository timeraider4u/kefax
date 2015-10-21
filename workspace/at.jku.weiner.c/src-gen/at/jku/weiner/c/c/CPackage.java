/**
 */
package at.jku.weiner.c.c;

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
 * @see at.jku.weiner.c.c.CFactory
 * @model kind="package"
 * @generated
 */
public interface CPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "c";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.jku.at/weiner/c/C";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "c";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CPackage eINSTANCE = at.jku.weiner.c.c.impl.CPackageImpl.init();

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.ModelImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__UNIT = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.TranslationUnitImpl <em>Translation Unit</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.TranslationUnitImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getTranslationUnit()
   * @generated
   */
  int TRANSLATION_UNIT = 1;

  /**
   * The feature id for the '<em><b>External</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSLATION_UNIT__EXTERNAL = 0;

  /**
   * The number of structural features of the '<em>Translation Unit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSLATION_UNIT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.ExternalDeclarationImpl <em>External Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.ExternalDeclarationImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getExternalDeclaration()
   * @generated
   */
  int EXTERNAL_DECLARATION = 2;

  /**
   * The feature id for the '<em><b>Functiondef Head</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_DECLARATION__FUNCTIONDEF_HEAD = 0;

  /**
   * The feature id for the '<em><b>Function Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_DECLARATION__FUNCTION_DEFINITION = 1;

  /**
   * The feature id for the '<em><b>Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_DECLARATION__DECLARATION = 2;

  /**
   * The feature id for the '<em><b>Semi</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_DECLARATION__SEMI = 3;

  /**
   * The number of structural features of the '<em>External Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_DECLARATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.FunctionDefHeadImpl <em>Function Def Head</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.FunctionDefHeadImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getFunctionDefHead()
   * @generated
   */
  int FUNCTION_DEF_HEAD = 3;

  /**
   * The feature id for the '<em><b>Fun Decl Specifiers</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEF_HEAD__FUN_DECL_SPECIFIERS = 0;

  /**
   * The feature id for the '<em><b>Fun Declarator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEF_HEAD__FUN_DECLARATOR = 1;

  /**
   * The feature id for the '<em><b>Fun Declaration</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEF_HEAD__FUN_DECLARATION = 2;

  /**
   * The number of structural features of the '<em>Function Def Head</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEF_HEAD_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.FunctionDefinitionImpl <em>Function Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.FunctionDefinitionImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getFunctionDefinition()
   * @generated
   */
  int FUNCTION_DEFINITION = 4;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__BODY = 0;

  /**
   * The number of structural features of the '<em>Function Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.DeclarationImpl <em>Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.DeclarationImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getDeclaration()
   * @generated
   */
  int DECLARATION = 5;

  /**
   * The feature id for the '<em><b>Specifiers</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION__SPECIFIERS = 0;

  /**
   * The feature id for the '<em><b>Init Declarator List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION__INIT_DECLARATOR_LIST = 1;

  /**
   * The feature id for the '<em><b>Semi</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION__SEMI = 2;

  /**
   * The number of structural features of the '<em>Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.DeclarationSpecifiersImpl <em>Declaration Specifiers</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.DeclarationSpecifiersImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getDeclarationSpecifiers()
   * @generated
   */
  int DECLARATION_SPECIFIERS = 6;

  /**
   * The feature id for the '<em><b>Declaration Specifier</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION_SPECIFIERS__DECLARATION_SPECIFIER = 0;

  /**
   * The number of structural features of the '<em>Declaration Specifiers</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION_SPECIFIERS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.InitDeclaratorListImpl <em>Init Declarator List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.InitDeclaratorListImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getInitDeclaratorList()
   * @generated
   */
  int INIT_DECLARATOR_LIST = 7;

  /**
   * The feature id for the '<em><b>Init Declarator</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_DECLARATOR_LIST__INIT_DECLARATOR = 0;

  /**
   * The feature id for the '<em><b>Init Declarator2</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_DECLARATOR_LIST__INIT_DECLARATOR2 = 1;

  /**
   * The number of structural features of the '<em>Init Declarator List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_DECLARATOR_LIST_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.InitDeclaratorImpl <em>Init Declarator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.InitDeclaratorImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getInitDeclarator()
   * @generated
   */
  int INIT_DECLARATOR = 8;

  /**
   * The feature id for the '<em><b>Declarator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_DECLARATOR__DECLARATOR = 0;

  /**
   * The feature id for the '<em><b>Initializer</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_DECLARATOR__INITIALIZER = 1;

  /**
   * The number of structural features of the '<em>Init Declarator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_DECLARATOR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.StorageClassSpecifierImpl <em>Storage Class Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.StorageClassSpecifierImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getStorageClassSpecifier()
   * @generated
   */
  int STORAGE_CLASS_SPECIFIER = 9;

  /**
   * The feature id for the '<em><b>Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORAGE_CLASS_SPECIFIER__CLASS = 0;

  /**
   * The number of structural features of the '<em>Storage Class Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORAGE_CLASS_SPECIFIER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.TypeSpecifierImpl <em>Type Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.TypeSpecifierImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getTypeSpecifier()
   * @generated
   */
  int TYPE_SPECIFIER = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SPECIFIER__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SPECIFIER__TYPE = 1;

  /**
   * The number of structural features of the '<em>Type Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SPECIFIER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.TypedefNameImpl <em>Typedef Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.TypedefNameImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getTypedefName()
   * @generated
   */
  int TYPEDEF_NAME = 11;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF_NAME__ID = 0;

  /**
   * The number of structural features of the '<em>Typedef Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF_NAME_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.SpecifierQualifierListImpl <em>Specifier Qualifier List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.SpecifierQualifierListImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getSpecifierQualifierList()
   * @generated
   */
  int SPECIFIER_QUALIFIER_LIST = 12;

  /**
   * The feature id for the '<em><b>Type Specifier</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFIER_QUALIFIER_LIST__TYPE_SPECIFIER = 0;

  /**
   * The feature id for the '<em><b>Type Qualifier</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFIER_QUALIFIER_LIST__TYPE_QUALIFIER = 1;

  /**
   * The number of structural features of the '<em>Specifier Qualifier List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFIER_QUALIFIER_LIST_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.TypeQualifierImpl <em>Type Qualifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.TypeQualifierImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getTypeQualifier()
   * @generated
   */
  int TYPE_QUALIFIER = 13;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_QUALIFIER__TYPE = 0;

  /**
   * The number of structural features of the '<em>Type Qualifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_QUALIFIER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.DeclaratorImpl <em>Declarator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.DeclaratorImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getDeclarator()
   * @generated
   */
  int DECLARATOR = 14;

  /**
   * The feature id for the '<em><b>Pointer</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATOR__POINTER = 0;

  /**
   * The feature id for the '<em><b>Declarator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATOR__DECLARATOR = 1;

  /**
   * The number of structural features of the '<em>Declarator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATOR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.DirectDeclaratorImpl <em>Direct Declarator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.DirectDeclaratorImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getDirectDeclarator()
   * @generated
   */
  int DIRECT_DECLARATOR = 15;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIRECT_DECLARATOR__ID = 0;

  /**
   * The feature id for the '<em><b>Declarator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIRECT_DECLARATOR__DECLARATOR = 1;

  /**
   * The feature id for the '<em><b>Declarator Suffix</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIRECT_DECLARATOR__DECLARATOR_SUFFIX = 2;

  /**
   * The number of structural features of the '<em>Direct Declarator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIRECT_DECLARATOR_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.DeclaratorSuffixImpl <em>Declarator Suffix</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.DeclaratorSuffixImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getDeclaratorSuffix()
   * @generated
   */
  int DECLARATOR_SUFFIX = 16;

  /**
   * The feature id for the '<em><b>Last Suffix</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATOR_SUFFIX__LAST_SUFFIX = 0;

  /**
   * The number of structural features of the '<em>Declarator Suffix</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATOR_SUFFIX_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.DirectDeclaratorLastSuffixImpl <em>Direct Declarator Last Suffix</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.DirectDeclaratorLastSuffixImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getDirectDeclaratorLastSuffix()
   * @generated
   */
  int DIRECT_DECLARATOR_LAST_SUFFIX = 17;

  /**
   * The feature id for the '<em><b>Parameter Type List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIRECT_DECLARATOR_LAST_SUFFIX__PARAMETER_TYPE_LIST = 0;

  /**
   * The feature id for the '<em><b>Identifier List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIRECT_DECLARATOR_LAST_SUFFIX__IDENTIFIER_LIST = 1;

  /**
   * The number of structural features of the '<em>Direct Declarator Last Suffix</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIRECT_DECLARATOR_LAST_SUFFIX_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.PointerImpl <em>Pointer</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.PointerImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getPointer()
   * @generated
   */
  int POINTER = 18;

  /**
   * The feature id for the '<em><b>Star</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POINTER__STAR = 0;

  /**
   * The feature id for the '<em><b>Caret</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POINTER__CARET = 1;

  /**
   * The feature id for the '<em><b>Type Qualifier List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POINTER__TYPE_QUALIFIER_LIST = 2;

  /**
   * The number of structural features of the '<em>Pointer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POINTER_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.TypeQualifierListImpl <em>Type Qualifier List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.TypeQualifierListImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getTypeQualifierList()
   * @generated
   */
  int TYPE_QUALIFIER_LIST = 19;

  /**
   * The feature id for the '<em><b>Type Qualifier</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_QUALIFIER_LIST__TYPE_QUALIFIER = 0;

  /**
   * The number of structural features of the '<em>Type Qualifier List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_QUALIFIER_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.ParameterTypeListImpl <em>Parameter Type List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.ParameterTypeListImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getParameterTypeList()
   * @generated
   */
  int PARAMETER_TYPE_LIST = 20;

  /**
   * The feature id for the '<em><b>List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_TYPE_LIST__LIST = 0;

  /**
   * The number of structural features of the '<em>Parameter Type List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_TYPE_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.ParameterListImpl <em>Parameter List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.ParameterListImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getParameterList()
   * @generated
   */
  int PARAMETER_LIST = 21;

  /**
   * The feature id for the '<em><b>Parameter Declaration</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_LIST__PARAMETER_DECLARATION = 0;

  /**
   * The number of structural features of the '<em>Parameter List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.ParameterDeclarationImpl <em>Parameter Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.ParameterDeclarationImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getParameterDeclaration()
   * @generated
   */
  int PARAMETER_DECLARATION = 22;

  /**
   * The feature id for the '<em><b>Decl Specifiers</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_DECLARATION__DECL_SPECIFIERS = 0;

  /**
   * The feature id for the '<em><b>Declarator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_DECLARATION__DECLARATOR = 1;

  /**
   * The number of structural features of the '<em>Parameter Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_DECLARATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.IdentifierListImpl <em>Identifier List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.IdentifierListImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getIdentifierList()
   * @generated
   */
  int IDENTIFIER_LIST = 23;

  /**
   * The feature id for the '<em><b>Id</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER_LIST__ID = 0;

  /**
   * The number of structural features of the '<em>Identifier List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.MyIdentifierImpl <em>My Identifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.MyIdentifierImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getMyIdentifier()
   * @generated
   */
  int MY_IDENTIFIER = 24;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_IDENTIFIER__ID = 0;

  /**
   * The number of structural features of the '<em>My Identifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_IDENTIFIER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.TypeNameImpl <em>Type Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.TypeNameImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getTypeName()
   * @generated
   */
  int TYPE_NAME = 25;

  /**
   * The feature id for the '<em><b>List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_NAME__LIST = 0;

  /**
   * The number of structural features of the '<em>Type Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_NAME_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.InitializerImpl <em>Initializer</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.InitializerImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getInitializer()
   * @generated
   */
  int INITIALIZER = 26;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INITIALIZER__EXPR = 0;

  /**
   * The number of structural features of the '<em>Initializer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INITIALIZER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.StatementImpl <em>Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.StatementImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getStatement()
   * @generated
   */
  int STATEMENT = 27;

  /**
   * The feature id for the '<em><b>Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__STMT = 0;

  /**
   * The number of structural features of the '<em>Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.BlockListImpl <em>Block List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.BlockListImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getBlockList()
   * @generated
   */
  int BLOCK_LIST = 28;

  /**
   * The feature id for the '<em><b>Declaration</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_LIST__DECLARATION = 0;

  /**
   * The feature id for the '<em><b>Statement</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_LIST__STATEMENT = 1;

  /**
   * The number of structural features of the '<em>Block List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_LIST_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.ExpressionStatementImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getExpressionStatement()
   * @generated
   */
  int EXPRESSION_STATEMENT = 29;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_STATEMENT__EXPRESSION = 0;

  /**
   * The feature id for the '<em><b>Semi</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_STATEMENT__SEMI = 1;

  /**
   * The number of structural features of the '<em>Expression Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_STATEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.JumpStatementImpl <em>Jump Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.JumpStatementImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getJumpStatement()
   * @generated
   */
  int JUMP_STATEMENT = 30;

  /**
   * The feature id for the '<em><b>Return</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUMP_STATEMENT__RETURN = 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUMP_STATEMENT__EXPR = 1;

  /**
   * The feature id for the '<em><b>Semi</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUMP_STATEMENT__SEMI = 2;

  /**
   * The feature id for the '<em><b>Goto</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUMP_STATEMENT__GOTO = 3;

  /**
   * The number of structural features of the '<em>Jump Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUMP_STATEMENT_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.ExpressionImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 31;

  /**
   * The feature id for the '<em><b>Expr Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__EXPR_EXPR = 0;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.AssignmentOperatorImpl <em>Assignment Operator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.AssignmentOperatorImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getAssignmentOperator()
   * @generated
   */
  int ASSIGNMENT_OPERATOR = 32;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_OPERATOR__OP = 0;

  /**
   * The number of structural features of the '<em>Assignment Operator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_OPERATOR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.UnaryOperatorImpl <em>Unary Operator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.UnaryOperatorImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getUnaryOperator()
   * @generated
   */
  int UNARY_OPERATOR = 33;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_OPERATOR__OP = 0;

  /**
   * The number of structural features of the '<em>Unary Operator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_OPERATOR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.ArgumentExpressionListImpl <em>Argument Expression List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.ArgumentExpressionListImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getArgumentExpressionList()
   * @generated
   */
  int ARGUMENT_EXPRESSION_LIST = 34;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_EXPRESSION_LIST__EXPR = 0;

  /**
   * The number of structural features of the '<em>Argument Expression List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_EXPRESSION_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.ConstantImpl <em>Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.ConstantImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getConstant()
   * @generated
   */
  int CONSTANT = 35;

  /**
   * The feature id for the '<em><b>Hex</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__HEX = 0;

  /**
   * The feature id for the '<em><b>Oct</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__OCT = 1;

  /**
   * The feature id for the '<em><b>Dec</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__DEC = 2;

  /**
   * The feature id for the '<em><b>Ch</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__CH = 3;

  /**
   * The feature id for the '<em><b>Str</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__STR = 4;

  /**
   * The feature id for the '<em><b>Float</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__FLOAT = 5;

  /**
   * The feature id for the '<em><b>Bin</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__BIN = 6;

  /**
   * The number of structural features of the '<em>Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.LabeledStatementImpl <em>Labeled Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.LabeledStatementImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getLabeledStatement()
   * @generated
   */
  int LABELED_STATEMENT = 36;

  /**
   * The feature id for the '<em><b>Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABELED_STATEMENT__STMT = STATEMENT__STMT;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABELED_STATEMENT__ID = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>LStmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABELED_STATEMENT__LSTMT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Labeled Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABELED_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.CompoundStatementImpl <em>Compound Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.CompoundStatementImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getCompoundStatement()
   * @generated
   */
  int COMPOUND_STATEMENT = 37;

  /**
   * The feature id for the '<em><b>Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOUND_STATEMENT__STMT = STATEMENT__STMT;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOUND_STATEMENT__BODY = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Compound Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOUND_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.BodyStatementImpl <em>Body Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.BodyStatementImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getBodyStatement()
   * @generated
   */
  int BODY_STATEMENT = 38;

  /**
   * The feature id for the '<em><b>Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY_STATEMENT__STMT = STATEMENT__STMT;

  /**
   * The feature id for the '<em><b>Block List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY_STATEMENT__BLOCK_LIST = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Body Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.AssignmentExpressionImpl <em>Assignment Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.AssignmentExpressionImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getAssignmentExpression()
   * @generated
   */
  int ASSIGNMENT_EXPRESSION = 39;

  /**
   * The feature id for the '<em><b>Expr Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_EXPRESSION__EXPR_EXPR = EXPRESSION__EXPR_EXPR;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Assignment Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPR = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Assignment Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.ConditionalExpressionImpl <em>Conditional Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.ConditionalExpressionImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getConditionalExpression()
   * @generated
   */
  int CONDITIONAL_EXPRESSION = 40;

  /**
   * The feature id for the '<em><b>Expr Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__EXPR_EXPR = EXPRESSION__EXPR_EXPR;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>QExpr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__QEXPR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>CExpr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__CEXPR = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Conditional Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.LogicalOrExpressionImpl <em>Logical Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.LogicalOrExpressionImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getLogicalOrExpression()
   * @generated
   */
  int LOGICAL_OR_EXPRESSION = 41;

  /**
   * The feature id for the '<em><b>Expr Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_OR_EXPRESSION__EXPR_EXPR = EXPRESSION__EXPR_EXPR;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_OR_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Logical Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_OR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.LogicalAndExpressionImpl <em>Logical And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.LogicalAndExpressionImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getLogicalAndExpression()
   * @generated
   */
  int LOGICAL_AND_EXPRESSION = 42;

  /**
   * The feature id for the '<em><b>Expr Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_AND_EXPRESSION__EXPR_EXPR = EXPRESSION__EXPR_EXPR;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_AND_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Logical And Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_AND_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.InclusiveOrExpressionImpl <em>Inclusive Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.InclusiveOrExpressionImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getInclusiveOrExpression()
   * @generated
   */
  int INCLUSIVE_OR_EXPRESSION = 43;

  /**
   * The feature id for the '<em><b>Expr Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUSIVE_OR_EXPRESSION__EXPR_EXPR = EXPRESSION__EXPR_EXPR;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUSIVE_OR_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Inclusive Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUSIVE_OR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.ExclusiveOrExpressionImpl <em>Exclusive Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.ExclusiveOrExpressionImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getExclusiveOrExpression()
   * @generated
   */
  int EXCLUSIVE_OR_EXPRESSION = 44;

  /**
   * The feature id for the '<em><b>Expr Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCLUSIVE_OR_EXPRESSION__EXPR_EXPR = EXPRESSION__EXPR_EXPR;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCLUSIVE_OR_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Exclusive Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCLUSIVE_OR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.AndExpressionImpl <em>And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.AndExpressionImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getAndExpression()
   * @generated
   */
  int AND_EXPRESSION = 45;

  /**
   * The feature id for the '<em><b>Expr Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION__EXPR_EXPR = EXPRESSION__EXPR_EXPR;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>And Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.EqualityExpressionImpl <em>Equality Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.EqualityExpressionImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getEqualityExpression()
   * @generated
   */
  int EQUALITY_EXPRESSION = 46;

  /**
   * The feature id for the '<em><b>Expr Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__EXPR_EXPR = EXPRESSION__EXPR_EXPR;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Equality Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.RelationalExpressionImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getRelationalExpression()
   * @generated
   */
  int RELATIONAL_EXPRESSION = 47;

  /**
   * The feature id for the '<em><b>Expr Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__EXPR_EXPR = EXPRESSION__EXPR_EXPR;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Relational Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.ShiftExpressionImpl <em>Shift Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.ShiftExpressionImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getShiftExpression()
   * @generated
   */
  int SHIFT_EXPRESSION = 48;

  /**
   * The feature id for the '<em><b>Expr Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPRESSION__EXPR_EXPR = EXPRESSION__EXPR_EXPR;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Shift Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.AdditiveExpressionImpl <em>Additive Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.AdditiveExpressionImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getAdditiveExpression()
   * @generated
   */
  int ADDITIVE_EXPRESSION = 49;

  /**
   * The feature id for the '<em><b>Expr Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION__EXPR_EXPR = EXPRESSION__EXPR_EXPR;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Additive Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.MultiplicativeExpressionImpl <em>Multiplicative Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.MultiplicativeExpressionImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getMultiplicativeExpression()
   * @generated
   */
  int MULTIPLICATIVE_EXPRESSION = 50;

  /**
   * The feature id for the '<em><b>Expr Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION__EXPR_EXPR = EXPRESSION__EXPR_EXPR;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Multiplicative Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.CastExpressionImpl <em>Cast Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.CastExpressionImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getCastExpression()
   * @generated
   */
  int CAST_EXPRESSION = 51;

  /**
   * The feature id for the '<em><b>Expr Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST_EXPRESSION__EXPR_EXPR = EXPRESSION__EXPR_EXPR;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST_EXPRESSION__TYPE = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Cast Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.UnaryExpressionImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getUnaryExpression()
   * @generated
   */
  int UNARY_EXPRESSION = 52;

  /**
   * The feature id for the '<em><b>Expr Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__EXPR_EXPR = EXPRESSION__EXPR_EXPR;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Unary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.PostfixExpressionImpl <em>Postfix Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.PostfixExpressionImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getPostfixExpression()
   * @generated
   */
  int POSTFIX_EXPRESSION = 53;

  /**
   * The feature id for the '<em><b>Expr Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION__EXPR_EXPR = EXPRESSION__EXPR_EXPR;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Array Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION__ARRAY_EXPR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Argument Expression List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION__ARGUMENT_EXPRESSION_LIST = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Postfix Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.c.impl.PrimaryExpressionImpl <em>Primary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.c.impl.PrimaryExpressionImpl
   * @see at.jku.weiner.c.c.impl.CPackageImpl#getPrimaryExpression()
   * @generated
   */
  int PRIMARY_EXPRESSION = 54;

  /**
   * The feature id for the '<em><b>Expr Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__EXPR_EXPR = EXPRESSION__EXPR_EXPR;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__ID = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Const</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__CONST = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Primary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;


  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see at.jku.weiner.c.c.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.Model#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Unit</em>'.
   * @see at.jku.weiner.c.c.Model#getUnit()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Unit();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.TranslationUnit <em>Translation Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Translation Unit</em>'.
   * @see at.jku.weiner.c.c.TranslationUnit
   * @generated
   */
  EClass getTranslationUnit();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.TranslationUnit#getExternal <em>External</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>External</em>'.
   * @see at.jku.weiner.c.c.TranslationUnit#getExternal()
   * @see #getTranslationUnit()
   * @generated
   */
  EReference getTranslationUnit_External();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.ExternalDeclaration <em>External Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>External Declaration</em>'.
   * @see at.jku.weiner.c.c.ExternalDeclaration
   * @generated
   */
  EClass getExternalDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.ExternalDeclaration#getFunctiondefHead <em>Functiondef Head</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Functiondef Head</em>'.
   * @see at.jku.weiner.c.c.ExternalDeclaration#getFunctiondefHead()
   * @see #getExternalDeclaration()
   * @generated
   */
  EReference getExternalDeclaration_FunctiondefHead();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.ExternalDeclaration#getFunctionDefinition <em>Function Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Function Definition</em>'.
   * @see at.jku.weiner.c.c.ExternalDeclaration#getFunctionDefinition()
   * @see #getExternalDeclaration()
   * @generated
   */
  EReference getExternalDeclaration_FunctionDefinition();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.ExternalDeclaration#getDeclaration <em>Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Declaration</em>'.
   * @see at.jku.weiner.c.c.ExternalDeclaration#getDeclaration()
   * @see #getExternalDeclaration()
   * @generated
   */
  EReference getExternalDeclaration_Declaration();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.c.ExternalDeclaration#getSemi <em>Semi</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Semi</em>'.
   * @see at.jku.weiner.c.c.ExternalDeclaration#getSemi()
   * @see #getExternalDeclaration()
   * @generated
   */
  EAttribute getExternalDeclaration_Semi();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.FunctionDefHead <em>Function Def Head</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Def Head</em>'.
   * @see at.jku.weiner.c.c.FunctionDefHead
   * @generated
   */
  EClass getFunctionDefHead();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.FunctionDefHead#getFunDeclSpecifiers <em>Fun Decl Specifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Fun Decl Specifiers</em>'.
   * @see at.jku.weiner.c.c.FunctionDefHead#getFunDeclSpecifiers()
   * @see #getFunctionDefHead()
   * @generated
   */
  EReference getFunctionDefHead_FunDeclSpecifiers();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.FunctionDefHead#getFunDeclarator <em>Fun Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Fun Declarator</em>'.
   * @see at.jku.weiner.c.c.FunctionDefHead#getFunDeclarator()
   * @see #getFunctionDefHead()
   * @generated
   */
  EReference getFunctionDefHead_FunDeclarator();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.FunctionDefHead#getFunDeclaration <em>Fun Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fun Declaration</em>'.
   * @see at.jku.weiner.c.c.FunctionDefHead#getFunDeclaration()
   * @see #getFunctionDefHead()
   * @generated
   */
  EReference getFunctionDefHead_FunDeclaration();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.FunctionDefinition <em>Function Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Definition</em>'.
   * @see at.jku.weiner.c.c.FunctionDefinition
   * @generated
   */
  EClass getFunctionDefinition();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.FunctionDefinition#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see at.jku.weiner.c.c.FunctionDefinition#getBody()
   * @see #getFunctionDefinition()
   * @generated
   */
  EReference getFunctionDefinition_Body();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.Declaration <em>Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Declaration</em>'.
   * @see at.jku.weiner.c.c.Declaration
   * @generated
   */
  EClass getDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.Declaration#getSpecifiers <em>Specifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Specifiers</em>'.
   * @see at.jku.weiner.c.c.Declaration#getSpecifiers()
   * @see #getDeclaration()
   * @generated
   */
  EReference getDeclaration_Specifiers();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.Declaration#getInitDeclaratorList <em>Init Declarator List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Init Declarator List</em>'.
   * @see at.jku.weiner.c.c.Declaration#getInitDeclaratorList()
   * @see #getDeclaration()
   * @generated
   */
  EReference getDeclaration_InitDeclaratorList();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.c.Declaration#getSemi <em>Semi</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Semi</em>'.
   * @see at.jku.weiner.c.c.Declaration#getSemi()
   * @see #getDeclaration()
   * @generated
   */
  EAttribute getDeclaration_Semi();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.DeclarationSpecifiers <em>Declaration Specifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Declaration Specifiers</em>'.
   * @see at.jku.weiner.c.c.DeclarationSpecifiers
   * @generated
   */
  EClass getDeclarationSpecifiers();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.DeclarationSpecifiers#getDeclarationSpecifier <em>Declaration Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Declaration Specifier</em>'.
   * @see at.jku.weiner.c.c.DeclarationSpecifiers#getDeclarationSpecifier()
   * @see #getDeclarationSpecifiers()
   * @generated
   */
  EReference getDeclarationSpecifiers_DeclarationSpecifier();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.InitDeclaratorList <em>Init Declarator List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Init Declarator List</em>'.
   * @see at.jku.weiner.c.c.InitDeclaratorList
   * @generated
   */
  EClass getInitDeclaratorList();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.InitDeclaratorList#getInitDeclarator <em>Init Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Init Declarator</em>'.
   * @see at.jku.weiner.c.c.InitDeclaratorList#getInitDeclarator()
   * @see #getInitDeclaratorList()
   * @generated
   */
  EReference getInitDeclaratorList_InitDeclarator();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.InitDeclaratorList#getInitDeclarator2 <em>Init Declarator2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Init Declarator2</em>'.
   * @see at.jku.weiner.c.c.InitDeclaratorList#getInitDeclarator2()
   * @see #getInitDeclaratorList()
   * @generated
   */
  EReference getInitDeclaratorList_InitDeclarator2();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.InitDeclarator <em>Init Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Init Declarator</em>'.
   * @see at.jku.weiner.c.c.InitDeclarator
   * @generated
   */
  EClass getInitDeclarator();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.InitDeclarator#getDeclarator <em>Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Declarator</em>'.
   * @see at.jku.weiner.c.c.InitDeclarator#getDeclarator()
   * @see #getInitDeclarator()
   * @generated
   */
  EReference getInitDeclarator_Declarator();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.InitDeclarator#getInitializer <em>Initializer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Initializer</em>'.
   * @see at.jku.weiner.c.c.InitDeclarator#getInitializer()
   * @see #getInitDeclarator()
   * @generated
   */
  EReference getInitDeclarator_Initializer();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.StorageClassSpecifier <em>Storage Class Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Storage Class Specifier</em>'.
   * @see at.jku.weiner.c.c.StorageClassSpecifier
   * @generated
   */
  EClass getStorageClassSpecifier();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.c.StorageClassSpecifier#getClass_ <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Class</em>'.
   * @see at.jku.weiner.c.c.StorageClassSpecifier#getClass_()
   * @see #getStorageClassSpecifier()
   * @generated
   */
  EAttribute getStorageClassSpecifier_Class();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.TypeSpecifier <em>Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Specifier</em>'.
   * @see at.jku.weiner.c.c.TypeSpecifier
   * @generated
   */
  EClass getTypeSpecifier();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.c.TypeSpecifier#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see at.jku.weiner.c.c.TypeSpecifier#getName()
   * @see #getTypeSpecifier()
   * @generated
   */
  EAttribute getTypeSpecifier_Name();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.TypeSpecifier#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see at.jku.weiner.c.c.TypeSpecifier#getType()
   * @see #getTypeSpecifier()
   * @generated
   */
  EReference getTypeSpecifier_Type();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.TypedefName <em>Typedef Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Typedef Name</em>'.
   * @see at.jku.weiner.c.c.TypedefName
   * @generated
   */
  EClass getTypedefName();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.c.TypedefName#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.c.c.TypedefName#getId()
   * @see #getTypedefName()
   * @generated
   */
  EAttribute getTypedefName_Id();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.SpecifierQualifierList <em>Specifier Qualifier List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Specifier Qualifier List</em>'.
   * @see at.jku.weiner.c.c.SpecifierQualifierList
   * @generated
   */
  EClass getSpecifierQualifierList();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.SpecifierQualifierList#getTypeSpecifier <em>Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type Specifier</em>'.
   * @see at.jku.weiner.c.c.SpecifierQualifierList#getTypeSpecifier()
   * @see #getSpecifierQualifierList()
   * @generated
   */
  EReference getSpecifierQualifierList_TypeSpecifier();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.SpecifierQualifierList#getTypeQualifier <em>Type Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type Qualifier</em>'.
   * @see at.jku.weiner.c.c.SpecifierQualifierList#getTypeQualifier()
   * @see #getSpecifierQualifierList()
   * @generated
   */
  EReference getSpecifierQualifierList_TypeQualifier();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.TypeQualifier <em>Type Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Qualifier</em>'.
   * @see at.jku.weiner.c.c.TypeQualifier
   * @generated
   */
  EClass getTypeQualifier();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.c.TypeQualifier#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see at.jku.weiner.c.c.TypeQualifier#getType()
   * @see #getTypeQualifier()
   * @generated
   */
  EAttribute getTypeQualifier_Type();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.Declarator <em>Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Declarator</em>'.
   * @see at.jku.weiner.c.c.Declarator
   * @generated
   */
  EClass getDeclarator();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.Declarator#getPointer <em>Pointer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Pointer</em>'.
   * @see at.jku.weiner.c.c.Declarator#getPointer()
   * @see #getDeclarator()
   * @generated
   */
  EReference getDeclarator_Pointer();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.Declarator#getDeclarator <em>Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Declarator</em>'.
   * @see at.jku.weiner.c.c.Declarator#getDeclarator()
   * @see #getDeclarator()
   * @generated
   */
  EReference getDeclarator_Declarator();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.DirectDeclarator <em>Direct Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Direct Declarator</em>'.
   * @see at.jku.weiner.c.c.DirectDeclarator
   * @generated
   */
  EClass getDirectDeclarator();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.c.DirectDeclarator#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.c.c.DirectDeclarator#getId()
   * @see #getDirectDeclarator()
   * @generated
   */
  EAttribute getDirectDeclarator_Id();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.DirectDeclarator#getDeclarator <em>Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Declarator</em>'.
   * @see at.jku.weiner.c.c.DirectDeclarator#getDeclarator()
   * @see #getDirectDeclarator()
   * @generated
   */
  EReference getDirectDeclarator_Declarator();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.DirectDeclarator#getDeclaratorSuffix <em>Declarator Suffix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Declarator Suffix</em>'.
   * @see at.jku.weiner.c.c.DirectDeclarator#getDeclaratorSuffix()
   * @see #getDirectDeclarator()
   * @generated
   */
  EReference getDirectDeclarator_DeclaratorSuffix();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.DeclaratorSuffix <em>Declarator Suffix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Declarator Suffix</em>'.
   * @see at.jku.weiner.c.c.DeclaratorSuffix
   * @generated
   */
  EClass getDeclaratorSuffix();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.DeclaratorSuffix#getLastSuffix <em>Last Suffix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Last Suffix</em>'.
   * @see at.jku.weiner.c.c.DeclaratorSuffix#getLastSuffix()
   * @see #getDeclaratorSuffix()
   * @generated
   */
  EReference getDeclaratorSuffix_LastSuffix();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.DirectDeclaratorLastSuffix <em>Direct Declarator Last Suffix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Direct Declarator Last Suffix</em>'.
   * @see at.jku.weiner.c.c.DirectDeclaratorLastSuffix
   * @generated
   */
  EClass getDirectDeclaratorLastSuffix();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.DirectDeclaratorLastSuffix#getParameterTypeList <em>Parameter Type List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameter Type List</em>'.
   * @see at.jku.weiner.c.c.DirectDeclaratorLastSuffix#getParameterTypeList()
   * @see #getDirectDeclaratorLastSuffix()
   * @generated
   */
  EReference getDirectDeclaratorLastSuffix_ParameterTypeList();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.DirectDeclaratorLastSuffix#getIdentifierList <em>Identifier List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Identifier List</em>'.
   * @see at.jku.weiner.c.c.DirectDeclaratorLastSuffix#getIdentifierList()
   * @see #getDirectDeclaratorLastSuffix()
   * @generated
   */
  EReference getDirectDeclaratorLastSuffix_IdentifierList();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.Pointer <em>Pointer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pointer</em>'.
   * @see at.jku.weiner.c.c.Pointer
   * @generated
   */
  EClass getPointer();

  /**
   * Returns the meta object for the attribute list '{@link at.jku.weiner.c.c.Pointer#getStar <em>Star</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Star</em>'.
   * @see at.jku.weiner.c.c.Pointer#getStar()
   * @see #getPointer()
   * @generated
   */
  EAttribute getPointer_Star();

  /**
   * Returns the meta object for the attribute list '{@link at.jku.weiner.c.c.Pointer#getCaret <em>Caret</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Caret</em>'.
   * @see at.jku.weiner.c.c.Pointer#getCaret()
   * @see #getPointer()
   * @generated
   */
  EAttribute getPointer_Caret();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.Pointer#getTypeQualifierList <em>Type Qualifier List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type Qualifier List</em>'.
   * @see at.jku.weiner.c.c.Pointer#getTypeQualifierList()
   * @see #getPointer()
   * @generated
   */
  EReference getPointer_TypeQualifierList();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.TypeQualifierList <em>Type Qualifier List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Qualifier List</em>'.
   * @see at.jku.weiner.c.c.TypeQualifierList
   * @generated
   */
  EClass getTypeQualifierList();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.TypeQualifierList#getTypeQualifier <em>Type Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type Qualifier</em>'.
   * @see at.jku.weiner.c.c.TypeQualifierList#getTypeQualifier()
   * @see #getTypeQualifierList()
   * @generated
   */
  EReference getTypeQualifierList_TypeQualifier();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.ParameterTypeList <em>Parameter Type List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Type List</em>'.
   * @see at.jku.weiner.c.c.ParameterTypeList
   * @generated
   */
  EClass getParameterTypeList();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.ParameterTypeList#getList <em>List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>List</em>'.
   * @see at.jku.weiner.c.c.ParameterTypeList#getList()
   * @see #getParameterTypeList()
   * @generated
   */
  EReference getParameterTypeList_List();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.ParameterList <em>Parameter List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter List</em>'.
   * @see at.jku.weiner.c.c.ParameterList
   * @generated
   */
  EClass getParameterList();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.ParameterList#getParameterDeclaration <em>Parameter Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameter Declaration</em>'.
   * @see at.jku.weiner.c.c.ParameterList#getParameterDeclaration()
   * @see #getParameterList()
   * @generated
   */
  EReference getParameterList_ParameterDeclaration();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.ParameterDeclaration <em>Parameter Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Declaration</em>'.
   * @see at.jku.weiner.c.c.ParameterDeclaration
   * @generated
   */
  EClass getParameterDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.ParameterDeclaration#getDeclSpecifiers <em>Decl Specifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Decl Specifiers</em>'.
   * @see at.jku.weiner.c.c.ParameterDeclaration#getDeclSpecifiers()
   * @see #getParameterDeclaration()
   * @generated
   */
  EReference getParameterDeclaration_DeclSpecifiers();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.ParameterDeclaration#getDeclarator <em>Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Declarator</em>'.
   * @see at.jku.weiner.c.c.ParameterDeclaration#getDeclarator()
   * @see #getParameterDeclaration()
   * @generated
   */
  EReference getParameterDeclaration_Declarator();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.IdentifierList <em>Identifier List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Identifier List</em>'.
   * @see at.jku.weiner.c.c.IdentifierList
   * @generated
   */
  EClass getIdentifierList();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.IdentifierList#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Id</em>'.
   * @see at.jku.weiner.c.c.IdentifierList#getId()
   * @see #getIdentifierList()
   * @generated
   */
  EReference getIdentifierList_Id();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.MyIdentifier <em>My Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Identifier</em>'.
   * @see at.jku.weiner.c.c.MyIdentifier
   * @generated
   */
  EClass getMyIdentifier();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.c.MyIdentifier#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.c.c.MyIdentifier#getId()
   * @see #getMyIdentifier()
   * @generated
   */
  EAttribute getMyIdentifier_Id();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.TypeName <em>Type Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Name</em>'.
   * @see at.jku.weiner.c.c.TypeName
   * @generated
   */
  EClass getTypeName();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.TypeName#getList <em>List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>List</em>'.
   * @see at.jku.weiner.c.c.TypeName#getList()
   * @see #getTypeName()
   * @generated
   */
  EReference getTypeName_List();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.Initializer <em>Initializer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Initializer</em>'.
   * @see at.jku.weiner.c.c.Initializer
   * @generated
   */
  EClass getInitializer();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.Initializer#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.c.Initializer#getExpr()
   * @see #getInitializer()
   * @generated
   */
  EReference getInitializer_Expr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement</em>'.
   * @see at.jku.weiner.c.c.Statement
   * @generated
   */
  EClass getStatement();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.Statement#getStmt <em>Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Stmt</em>'.
   * @see at.jku.weiner.c.c.Statement#getStmt()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_Stmt();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.BlockList <em>Block List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Block List</em>'.
   * @see at.jku.weiner.c.c.BlockList
   * @generated
   */
  EClass getBlockList();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.BlockList#getDeclaration <em>Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Declaration</em>'.
   * @see at.jku.weiner.c.c.BlockList#getDeclaration()
   * @see #getBlockList()
   * @generated
   */
  EReference getBlockList_Declaration();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.BlockList#getStatement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statement</em>'.
   * @see at.jku.weiner.c.c.BlockList#getStatement()
   * @see #getBlockList()
   * @generated
   */
  EReference getBlockList_Statement();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.ExpressionStatement <em>Expression Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Statement</em>'.
   * @see at.jku.weiner.c.c.ExpressionStatement
   * @generated
   */
  EClass getExpressionStatement();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.ExpressionStatement#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see at.jku.weiner.c.c.ExpressionStatement#getExpression()
   * @see #getExpressionStatement()
   * @generated
   */
  EReference getExpressionStatement_Expression();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.c.ExpressionStatement#getSemi <em>Semi</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Semi</em>'.
   * @see at.jku.weiner.c.c.ExpressionStatement#getSemi()
   * @see #getExpressionStatement()
   * @generated
   */
  EAttribute getExpressionStatement_Semi();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.JumpStatement <em>Jump Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Jump Statement</em>'.
   * @see at.jku.weiner.c.c.JumpStatement
   * @generated
   */
  EClass getJumpStatement();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.c.JumpStatement#getReturn <em>Return</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Return</em>'.
   * @see at.jku.weiner.c.c.JumpStatement#getReturn()
   * @see #getJumpStatement()
   * @generated
   */
  EAttribute getJumpStatement_Return();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.JumpStatement#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.c.JumpStatement#getExpr()
   * @see #getJumpStatement()
   * @generated
   */
  EReference getJumpStatement_Expr();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.c.JumpStatement#getSemi <em>Semi</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Semi</em>'.
   * @see at.jku.weiner.c.c.JumpStatement#getSemi()
   * @see #getJumpStatement()
   * @generated
   */
  EAttribute getJumpStatement_Semi();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.c.JumpStatement#getGoto <em>Goto</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Goto</em>'.
   * @see at.jku.weiner.c.c.JumpStatement#getGoto()
   * @see #getJumpStatement()
   * @generated
   */
  EAttribute getJumpStatement_Goto();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see at.jku.weiner.c.c.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.Expression#getExprExpr <em>Expr Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr Expr</em>'.
   * @see at.jku.weiner.c.c.Expression#getExprExpr()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_ExprExpr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.AssignmentOperator <em>Assignment Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment Operator</em>'.
   * @see at.jku.weiner.c.c.AssignmentOperator
   * @generated
   */
  EClass getAssignmentOperator();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.c.AssignmentOperator#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see at.jku.weiner.c.c.AssignmentOperator#getOp()
   * @see #getAssignmentOperator()
   * @generated
   */
  EAttribute getAssignmentOperator_Op();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.UnaryOperator <em>Unary Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Operator</em>'.
   * @see at.jku.weiner.c.c.UnaryOperator
   * @generated
   */
  EClass getUnaryOperator();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.c.UnaryOperator#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see at.jku.weiner.c.c.UnaryOperator#getOp()
   * @see #getUnaryOperator()
   * @generated
   */
  EAttribute getUnaryOperator_Op();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.ArgumentExpressionList <em>Argument Expression List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Argument Expression List</em>'.
   * @see at.jku.weiner.c.c.ArgumentExpressionList
   * @generated
   */
  EClass getArgumentExpressionList();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.ArgumentExpressionList#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.c.ArgumentExpressionList#getExpr()
   * @see #getArgumentExpressionList()
   * @generated
   */
  EReference getArgumentExpressionList_Expr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.Constant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant</em>'.
   * @see at.jku.weiner.c.c.Constant
   * @generated
   */
  EClass getConstant();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.c.Constant#getHex <em>Hex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Hex</em>'.
   * @see at.jku.weiner.c.c.Constant#getHex()
   * @see #getConstant()
   * @generated
   */
  EAttribute getConstant_Hex();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.c.Constant#getOct <em>Oct</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Oct</em>'.
   * @see at.jku.weiner.c.c.Constant#getOct()
   * @see #getConstant()
   * @generated
   */
  EAttribute getConstant_Oct();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.c.Constant#getDec <em>Dec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Dec</em>'.
   * @see at.jku.weiner.c.c.Constant#getDec()
   * @see #getConstant()
   * @generated
   */
  EAttribute getConstant_Dec();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.c.Constant#getCh <em>Ch</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ch</em>'.
   * @see at.jku.weiner.c.c.Constant#getCh()
   * @see #getConstant()
   * @generated
   */
  EAttribute getConstant_Ch();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.c.Constant#getStr <em>Str</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Str</em>'.
   * @see at.jku.weiner.c.c.Constant#getStr()
   * @see #getConstant()
   * @generated
   */
  EAttribute getConstant_Str();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.c.Constant#getFloat <em>Float</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Float</em>'.
   * @see at.jku.weiner.c.c.Constant#getFloat()
   * @see #getConstant()
   * @generated
   */
  EAttribute getConstant_Float();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.c.Constant#getBin <em>Bin</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Bin</em>'.
   * @see at.jku.weiner.c.c.Constant#getBin()
   * @see #getConstant()
   * @generated
   */
  EAttribute getConstant_Bin();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.LabeledStatement <em>Labeled Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Labeled Statement</em>'.
   * @see at.jku.weiner.c.c.LabeledStatement
   * @generated
   */
  EClass getLabeledStatement();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.c.LabeledStatement#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.c.c.LabeledStatement#getId()
   * @see #getLabeledStatement()
   * @generated
   */
  EAttribute getLabeledStatement_Id();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.LabeledStatement#getLStmt <em>LStmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>LStmt</em>'.
   * @see at.jku.weiner.c.c.LabeledStatement#getLStmt()
   * @see #getLabeledStatement()
   * @generated
   */
  EReference getLabeledStatement_LStmt();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.CompoundStatement <em>Compound Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Compound Statement</em>'.
   * @see at.jku.weiner.c.c.CompoundStatement
   * @generated
   */
  EClass getCompoundStatement();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.CompoundStatement#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see at.jku.weiner.c.c.CompoundStatement#getBody()
   * @see #getCompoundStatement()
   * @generated
   */
  EReference getCompoundStatement_Body();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.BodyStatement <em>Body Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Body Statement</em>'.
   * @see at.jku.weiner.c.c.BodyStatement
   * @generated
   */
  EClass getBodyStatement();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.BodyStatement#getBlockList <em>Block List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Block List</em>'.
   * @see at.jku.weiner.c.c.BodyStatement#getBlockList()
   * @see #getBodyStatement()
   * @generated
   */
  EReference getBodyStatement_BlockList();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.AssignmentExpression <em>Assignment Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment Expression</em>'.
   * @see at.jku.weiner.c.c.AssignmentExpression
   * @generated
   */
  EClass getAssignmentExpression();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.AssignmentExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.c.AssignmentExpression#getExpr()
   * @see #getAssignmentExpression()
   * @generated
   */
  EReference getAssignmentExpression_Expr();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.AssignmentExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op</em>'.
   * @see at.jku.weiner.c.c.AssignmentExpression#getOp()
   * @see #getAssignmentExpression()
   * @generated
   */
  EReference getAssignmentExpression_Op();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.AssignmentExpression#getAssignmentExpr <em>Assignment Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Assignment Expr</em>'.
   * @see at.jku.weiner.c.c.AssignmentExpression#getAssignmentExpr()
   * @see #getAssignmentExpression()
   * @generated
   */
  EReference getAssignmentExpression_AssignmentExpr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.ConditionalExpression <em>Conditional Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Conditional Expression</em>'.
   * @see at.jku.weiner.c.c.ConditionalExpression
   * @generated
   */
  EClass getConditionalExpression();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.ConditionalExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.c.ConditionalExpression#getExpr()
   * @see #getConditionalExpression()
   * @generated
   */
  EReference getConditionalExpression_Expr();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.ConditionalExpression#getQExpr <em>QExpr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>QExpr</em>'.
   * @see at.jku.weiner.c.c.ConditionalExpression#getQExpr()
   * @see #getConditionalExpression()
   * @generated
   */
  EReference getConditionalExpression_QExpr();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.ConditionalExpression#getCExpr <em>CExpr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>CExpr</em>'.
   * @see at.jku.weiner.c.c.ConditionalExpression#getCExpr()
   * @see #getConditionalExpression()
   * @generated
   */
  EReference getConditionalExpression_CExpr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.LogicalOrExpression <em>Logical Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical Or Expression</em>'.
   * @see at.jku.weiner.c.c.LogicalOrExpression
   * @generated
   */
  EClass getLogicalOrExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.LogicalOrExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.c.LogicalOrExpression#getExpr()
   * @see #getLogicalOrExpression()
   * @generated
   */
  EReference getLogicalOrExpression_Expr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.LogicalAndExpression <em>Logical And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical And Expression</em>'.
   * @see at.jku.weiner.c.c.LogicalAndExpression
   * @generated
   */
  EClass getLogicalAndExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.LogicalAndExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.c.LogicalAndExpression#getExpr()
   * @see #getLogicalAndExpression()
   * @generated
   */
  EReference getLogicalAndExpression_Expr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.InclusiveOrExpression <em>Inclusive Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Inclusive Or Expression</em>'.
   * @see at.jku.weiner.c.c.InclusiveOrExpression
   * @generated
   */
  EClass getInclusiveOrExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.InclusiveOrExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.c.InclusiveOrExpression#getExpr()
   * @see #getInclusiveOrExpression()
   * @generated
   */
  EReference getInclusiveOrExpression_Expr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.ExclusiveOrExpression <em>Exclusive Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exclusive Or Expression</em>'.
   * @see at.jku.weiner.c.c.ExclusiveOrExpression
   * @generated
   */
  EClass getExclusiveOrExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.ExclusiveOrExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.c.ExclusiveOrExpression#getExpr()
   * @see #getExclusiveOrExpression()
   * @generated
   */
  EReference getExclusiveOrExpression_Expr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.AndExpression <em>And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Expression</em>'.
   * @see at.jku.weiner.c.c.AndExpression
   * @generated
   */
  EClass getAndExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.AndExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.c.AndExpression#getExpr()
   * @see #getAndExpression()
   * @generated
   */
  EReference getAndExpression_Expr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.EqualityExpression <em>Equality Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equality Expression</em>'.
   * @see at.jku.weiner.c.c.EqualityExpression
   * @generated
   */
  EClass getEqualityExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.EqualityExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.c.EqualityExpression#getExpr()
   * @see #getEqualityExpression()
   * @generated
   */
  EReference getEqualityExpression_Expr();

  /**
   * Returns the meta object for the attribute list '{@link at.jku.weiner.c.c.EqualityExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see at.jku.weiner.c.c.EqualityExpression#getOp()
   * @see #getEqualityExpression()
   * @generated
   */
  EAttribute getEqualityExpression_Op();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.RelationalExpression <em>Relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relational Expression</em>'.
   * @see at.jku.weiner.c.c.RelationalExpression
   * @generated
   */
  EClass getRelationalExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.RelationalExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.c.RelationalExpression#getExpr()
   * @see #getRelationalExpression()
   * @generated
   */
  EReference getRelationalExpression_Expr();

  /**
   * Returns the meta object for the attribute list '{@link at.jku.weiner.c.c.RelationalExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see at.jku.weiner.c.c.RelationalExpression#getOp()
   * @see #getRelationalExpression()
   * @generated
   */
  EAttribute getRelationalExpression_Op();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.ShiftExpression <em>Shift Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Shift Expression</em>'.
   * @see at.jku.weiner.c.c.ShiftExpression
   * @generated
   */
  EClass getShiftExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.ShiftExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.c.ShiftExpression#getExpr()
   * @see #getShiftExpression()
   * @generated
   */
  EReference getShiftExpression_Expr();

  /**
   * Returns the meta object for the attribute list '{@link at.jku.weiner.c.c.ShiftExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see at.jku.weiner.c.c.ShiftExpression#getOp()
   * @see #getShiftExpression()
   * @generated
   */
  EAttribute getShiftExpression_Op();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.AdditiveExpression <em>Additive Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Additive Expression</em>'.
   * @see at.jku.weiner.c.c.AdditiveExpression
   * @generated
   */
  EClass getAdditiveExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.AdditiveExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.c.AdditiveExpression#getExpr()
   * @see #getAdditiveExpression()
   * @generated
   */
  EReference getAdditiveExpression_Expr();

  /**
   * Returns the meta object for the attribute list '{@link at.jku.weiner.c.c.AdditiveExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see at.jku.weiner.c.c.AdditiveExpression#getOp()
   * @see #getAdditiveExpression()
   * @generated
   */
  EAttribute getAdditiveExpression_Op();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.MultiplicativeExpression <em>Multiplicative Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicative Expression</em>'.
   * @see at.jku.weiner.c.c.MultiplicativeExpression
   * @generated
   */
  EClass getMultiplicativeExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.MultiplicativeExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.c.MultiplicativeExpression#getExpr()
   * @see #getMultiplicativeExpression()
   * @generated
   */
  EReference getMultiplicativeExpression_Expr();

  /**
   * Returns the meta object for the attribute list '{@link at.jku.weiner.c.c.MultiplicativeExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see at.jku.weiner.c.c.MultiplicativeExpression#getOp()
   * @see #getMultiplicativeExpression()
   * @generated
   */
  EAttribute getMultiplicativeExpression_Op();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.CastExpression <em>Cast Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cast Expression</em>'.
   * @see at.jku.weiner.c.c.CastExpression
   * @generated
   */
  EClass getCastExpression();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.CastExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.c.CastExpression#getExpr()
   * @see #getCastExpression()
   * @generated
   */
  EReference getCastExpression_Expr();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.CastExpression#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see at.jku.weiner.c.c.CastExpression#getType()
   * @see #getCastExpression()
   * @generated
   */
  EReference getCastExpression_Type();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.UnaryExpression <em>Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Expression</em>'.
   * @see at.jku.weiner.c.c.UnaryExpression
   * @generated
   */
  EClass getUnaryExpression();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.UnaryExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.c.UnaryExpression#getExpr()
   * @see #getUnaryExpression()
   * @generated
   */
  EReference getUnaryExpression_Expr();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.UnaryExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op</em>'.
   * @see at.jku.weiner.c.c.UnaryExpression#getOp()
   * @see #getUnaryExpression()
   * @generated
   */
  EReference getUnaryExpression_Op();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.PostfixExpression <em>Postfix Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Postfix Expression</em>'.
   * @see at.jku.weiner.c.c.PostfixExpression
   * @generated
   */
  EClass getPostfixExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.PostfixExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.c.PostfixExpression#getExpr()
   * @see #getPostfixExpression()
   * @generated
   */
  EReference getPostfixExpression_Expr();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.PostfixExpression#getArrayExpr <em>Array Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Array Expr</em>'.
   * @see at.jku.weiner.c.c.PostfixExpression#getArrayExpr()
   * @see #getPostfixExpression()
   * @generated
   */
  EReference getPostfixExpression_ArrayExpr();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.c.PostfixExpression#getArgumentExpressionList <em>Argument Expression List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Argument Expression List</em>'.
   * @see at.jku.weiner.c.c.PostfixExpression#getArgumentExpressionList()
   * @see #getPostfixExpression()
   * @generated
   */
  EReference getPostfixExpression_ArgumentExpressionList();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.c.PrimaryExpression <em>Primary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primary Expression</em>'.
   * @see at.jku.weiner.c.c.PrimaryExpression
   * @generated
   */
  EClass getPrimaryExpression();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.c.PrimaryExpression#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.c.c.PrimaryExpression#getId()
   * @see #getPrimaryExpression()
   * @generated
   */
  EAttribute getPrimaryExpression_Id();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.PrimaryExpression#getConst <em>Const</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Const</em>'.
   * @see at.jku.weiner.c.c.PrimaryExpression#getConst()
   * @see #getPrimaryExpression()
   * @generated
   */
  EReference getPrimaryExpression_Const();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.c.PrimaryExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.c.PrimaryExpression#getExpr()
   * @see #getPrimaryExpression()
   * @generated
   */
  EReference getPrimaryExpression_Expr();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  CFactory getCFactory();

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
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.ModelImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__UNIT = eINSTANCE.getModel_Unit();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.TranslationUnitImpl <em>Translation Unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.TranslationUnitImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getTranslationUnit()
     * @generated
     */
    EClass TRANSLATION_UNIT = eINSTANCE.getTranslationUnit();

    /**
     * The meta object literal for the '<em><b>External</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSLATION_UNIT__EXTERNAL = eINSTANCE.getTranslationUnit_External();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.ExternalDeclarationImpl <em>External Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.ExternalDeclarationImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getExternalDeclaration()
     * @generated
     */
    EClass EXTERNAL_DECLARATION = eINSTANCE.getExternalDeclaration();

    /**
     * The meta object literal for the '<em><b>Functiondef Head</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXTERNAL_DECLARATION__FUNCTIONDEF_HEAD = eINSTANCE.getExternalDeclaration_FunctiondefHead();

    /**
     * The meta object literal for the '<em><b>Function Definition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXTERNAL_DECLARATION__FUNCTION_DEFINITION = eINSTANCE.getExternalDeclaration_FunctionDefinition();

    /**
     * The meta object literal for the '<em><b>Declaration</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXTERNAL_DECLARATION__DECLARATION = eINSTANCE.getExternalDeclaration_Declaration();

    /**
     * The meta object literal for the '<em><b>Semi</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXTERNAL_DECLARATION__SEMI = eINSTANCE.getExternalDeclaration_Semi();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.FunctionDefHeadImpl <em>Function Def Head</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.FunctionDefHeadImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getFunctionDefHead()
     * @generated
     */
    EClass FUNCTION_DEF_HEAD = eINSTANCE.getFunctionDefHead();

    /**
     * The meta object literal for the '<em><b>Fun Decl Specifiers</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_DEF_HEAD__FUN_DECL_SPECIFIERS = eINSTANCE.getFunctionDefHead_FunDeclSpecifiers();

    /**
     * The meta object literal for the '<em><b>Fun Declarator</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_DEF_HEAD__FUN_DECLARATOR = eINSTANCE.getFunctionDefHead_FunDeclarator();

    /**
     * The meta object literal for the '<em><b>Fun Declaration</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_DEF_HEAD__FUN_DECLARATION = eINSTANCE.getFunctionDefHead_FunDeclaration();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.FunctionDefinitionImpl <em>Function Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.FunctionDefinitionImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getFunctionDefinition()
     * @generated
     */
    EClass FUNCTION_DEFINITION = eINSTANCE.getFunctionDefinition();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_DEFINITION__BODY = eINSTANCE.getFunctionDefinition_Body();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.DeclarationImpl <em>Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.DeclarationImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getDeclaration()
     * @generated
     */
    EClass DECLARATION = eINSTANCE.getDeclaration();

    /**
     * The meta object literal for the '<em><b>Specifiers</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATION__SPECIFIERS = eINSTANCE.getDeclaration_Specifiers();

    /**
     * The meta object literal for the '<em><b>Init Declarator List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATION__INIT_DECLARATOR_LIST = eINSTANCE.getDeclaration_InitDeclaratorList();

    /**
     * The meta object literal for the '<em><b>Semi</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECLARATION__SEMI = eINSTANCE.getDeclaration_Semi();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.DeclarationSpecifiersImpl <em>Declaration Specifiers</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.DeclarationSpecifiersImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getDeclarationSpecifiers()
     * @generated
     */
    EClass DECLARATION_SPECIFIERS = eINSTANCE.getDeclarationSpecifiers();

    /**
     * The meta object literal for the '<em><b>Declaration Specifier</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATION_SPECIFIERS__DECLARATION_SPECIFIER = eINSTANCE.getDeclarationSpecifiers_DeclarationSpecifier();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.InitDeclaratorListImpl <em>Init Declarator List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.InitDeclaratorListImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getInitDeclaratorList()
     * @generated
     */
    EClass INIT_DECLARATOR_LIST = eINSTANCE.getInitDeclaratorList();

    /**
     * The meta object literal for the '<em><b>Init Declarator</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INIT_DECLARATOR_LIST__INIT_DECLARATOR = eINSTANCE.getInitDeclaratorList_InitDeclarator();

    /**
     * The meta object literal for the '<em><b>Init Declarator2</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INIT_DECLARATOR_LIST__INIT_DECLARATOR2 = eINSTANCE.getInitDeclaratorList_InitDeclarator2();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.InitDeclaratorImpl <em>Init Declarator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.InitDeclaratorImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getInitDeclarator()
     * @generated
     */
    EClass INIT_DECLARATOR = eINSTANCE.getInitDeclarator();

    /**
     * The meta object literal for the '<em><b>Declarator</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INIT_DECLARATOR__DECLARATOR = eINSTANCE.getInitDeclarator_Declarator();

    /**
     * The meta object literal for the '<em><b>Initializer</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INIT_DECLARATOR__INITIALIZER = eINSTANCE.getInitDeclarator_Initializer();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.StorageClassSpecifierImpl <em>Storage Class Specifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.StorageClassSpecifierImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getStorageClassSpecifier()
     * @generated
     */
    EClass STORAGE_CLASS_SPECIFIER = eINSTANCE.getStorageClassSpecifier();

    /**
     * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STORAGE_CLASS_SPECIFIER__CLASS = eINSTANCE.getStorageClassSpecifier_Class();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.TypeSpecifierImpl <em>Type Specifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.TypeSpecifierImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getTypeSpecifier()
     * @generated
     */
    EClass TYPE_SPECIFIER = eINSTANCE.getTypeSpecifier();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_SPECIFIER__NAME = eINSTANCE.getTypeSpecifier_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_SPECIFIER__TYPE = eINSTANCE.getTypeSpecifier_Type();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.TypedefNameImpl <em>Typedef Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.TypedefNameImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getTypedefName()
     * @generated
     */
    EClass TYPEDEF_NAME = eINSTANCE.getTypedefName();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPEDEF_NAME__ID = eINSTANCE.getTypedefName_Id();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.SpecifierQualifierListImpl <em>Specifier Qualifier List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.SpecifierQualifierListImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getSpecifierQualifierList()
     * @generated
     */
    EClass SPECIFIER_QUALIFIER_LIST = eINSTANCE.getSpecifierQualifierList();

    /**
     * The meta object literal for the '<em><b>Type Specifier</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFIER_QUALIFIER_LIST__TYPE_SPECIFIER = eINSTANCE.getSpecifierQualifierList_TypeSpecifier();

    /**
     * The meta object literal for the '<em><b>Type Qualifier</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFIER_QUALIFIER_LIST__TYPE_QUALIFIER = eINSTANCE.getSpecifierQualifierList_TypeQualifier();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.TypeQualifierImpl <em>Type Qualifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.TypeQualifierImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getTypeQualifier()
     * @generated
     */
    EClass TYPE_QUALIFIER = eINSTANCE.getTypeQualifier();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_QUALIFIER__TYPE = eINSTANCE.getTypeQualifier_Type();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.DeclaratorImpl <em>Declarator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.DeclaratorImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getDeclarator()
     * @generated
     */
    EClass DECLARATOR = eINSTANCE.getDeclarator();

    /**
     * The meta object literal for the '<em><b>Pointer</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATOR__POINTER = eINSTANCE.getDeclarator_Pointer();

    /**
     * The meta object literal for the '<em><b>Declarator</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATOR__DECLARATOR = eINSTANCE.getDeclarator_Declarator();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.DirectDeclaratorImpl <em>Direct Declarator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.DirectDeclaratorImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getDirectDeclarator()
     * @generated
     */
    EClass DIRECT_DECLARATOR = eINSTANCE.getDirectDeclarator();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DIRECT_DECLARATOR__ID = eINSTANCE.getDirectDeclarator_Id();

    /**
     * The meta object literal for the '<em><b>Declarator</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DIRECT_DECLARATOR__DECLARATOR = eINSTANCE.getDirectDeclarator_Declarator();

    /**
     * The meta object literal for the '<em><b>Declarator Suffix</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DIRECT_DECLARATOR__DECLARATOR_SUFFIX = eINSTANCE.getDirectDeclarator_DeclaratorSuffix();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.DeclaratorSuffixImpl <em>Declarator Suffix</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.DeclaratorSuffixImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getDeclaratorSuffix()
     * @generated
     */
    EClass DECLARATOR_SUFFIX = eINSTANCE.getDeclaratorSuffix();

    /**
     * The meta object literal for the '<em><b>Last Suffix</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATOR_SUFFIX__LAST_SUFFIX = eINSTANCE.getDeclaratorSuffix_LastSuffix();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.DirectDeclaratorLastSuffixImpl <em>Direct Declarator Last Suffix</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.DirectDeclaratorLastSuffixImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getDirectDeclaratorLastSuffix()
     * @generated
     */
    EClass DIRECT_DECLARATOR_LAST_SUFFIX = eINSTANCE.getDirectDeclaratorLastSuffix();

    /**
     * The meta object literal for the '<em><b>Parameter Type List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DIRECT_DECLARATOR_LAST_SUFFIX__PARAMETER_TYPE_LIST = eINSTANCE.getDirectDeclaratorLastSuffix_ParameterTypeList();

    /**
     * The meta object literal for the '<em><b>Identifier List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DIRECT_DECLARATOR_LAST_SUFFIX__IDENTIFIER_LIST = eINSTANCE.getDirectDeclaratorLastSuffix_IdentifierList();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.PointerImpl <em>Pointer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.PointerImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getPointer()
     * @generated
     */
    EClass POINTER = eINSTANCE.getPointer();

    /**
     * The meta object literal for the '<em><b>Star</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute POINTER__STAR = eINSTANCE.getPointer_Star();

    /**
     * The meta object literal for the '<em><b>Caret</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute POINTER__CARET = eINSTANCE.getPointer_Caret();

    /**
     * The meta object literal for the '<em><b>Type Qualifier List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POINTER__TYPE_QUALIFIER_LIST = eINSTANCE.getPointer_TypeQualifierList();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.TypeQualifierListImpl <em>Type Qualifier List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.TypeQualifierListImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getTypeQualifierList()
     * @generated
     */
    EClass TYPE_QUALIFIER_LIST = eINSTANCE.getTypeQualifierList();

    /**
     * The meta object literal for the '<em><b>Type Qualifier</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_QUALIFIER_LIST__TYPE_QUALIFIER = eINSTANCE.getTypeQualifierList_TypeQualifier();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.ParameterTypeListImpl <em>Parameter Type List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.ParameterTypeListImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getParameterTypeList()
     * @generated
     */
    EClass PARAMETER_TYPE_LIST = eINSTANCE.getParameterTypeList();

    /**
     * The meta object literal for the '<em><b>List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER_TYPE_LIST__LIST = eINSTANCE.getParameterTypeList_List();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.ParameterListImpl <em>Parameter List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.ParameterListImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getParameterList()
     * @generated
     */
    EClass PARAMETER_LIST = eINSTANCE.getParameterList();

    /**
     * The meta object literal for the '<em><b>Parameter Declaration</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER_LIST__PARAMETER_DECLARATION = eINSTANCE.getParameterList_ParameterDeclaration();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.ParameterDeclarationImpl <em>Parameter Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.ParameterDeclarationImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getParameterDeclaration()
     * @generated
     */
    EClass PARAMETER_DECLARATION = eINSTANCE.getParameterDeclaration();

    /**
     * The meta object literal for the '<em><b>Decl Specifiers</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER_DECLARATION__DECL_SPECIFIERS = eINSTANCE.getParameterDeclaration_DeclSpecifiers();

    /**
     * The meta object literal for the '<em><b>Declarator</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER_DECLARATION__DECLARATOR = eINSTANCE.getParameterDeclaration_Declarator();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.IdentifierListImpl <em>Identifier List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.IdentifierListImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getIdentifierList()
     * @generated
     */
    EClass IDENTIFIER_LIST = eINSTANCE.getIdentifierList();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IDENTIFIER_LIST__ID = eINSTANCE.getIdentifierList_Id();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.MyIdentifierImpl <em>My Identifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.MyIdentifierImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getMyIdentifier()
     * @generated
     */
    EClass MY_IDENTIFIER = eINSTANCE.getMyIdentifier();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MY_IDENTIFIER__ID = eINSTANCE.getMyIdentifier_Id();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.TypeNameImpl <em>Type Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.TypeNameImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getTypeName()
     * @generated
     */
    EClass TYPE_NAME = eINSTANCE.getTypeName();

    /**
     * The meta object literal for the '<em><b>List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_NAME__LIST = eINSTANCE.getTypeName_List();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.InitializerImpl <em>Initializer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.InitializerImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getInitializer()
     * @generated
     */
    EClass INITIALIZER = eINSTANCE.getInitializer();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INITIALIZER__EXPR = eINSTANCE.getInitializer_Expr();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.StatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.StatementImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getStatement()
     * @generated
     */
    EClass STATEMENT = eINSTANCE.getStatement();

    /**
     * The meta object literal for the '<em><b>Stmt</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__STMT = eINSTANCE.getStatement_Stmt();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.BlockListImpl <em>Block List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.BlockListImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getBlockList()
     * @generated
     */
    EClass BLOCK_LIST = eINSTANCE.getBlockList();

    /**
     * The meta object literal for the '<em><b>Declaration</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BLOCK_LIST__DECLARATION = eINSTANCE.getBlockList_Declaration();

    /**
     * The meta object literal for the '<em><b>Statement</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BLOCK_LIST__STATEMENT = eINSTANCE.getBlockList_Statement();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.ExpressionStatementImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getExpressionStatement()
     * @generated
     */
    EClass EXPRESSION_STATEMENT = eINSTANCE.getExpressionStatement();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_STATEMENT__EXPRESSION = eINSTANCE.getExpressionStatement_Expression();

    /**
     * The meta object literal for the '<em><b>Semi</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPRESSION_STATEMENT__SEMI = eINSTANCE.getExpressionStatement_Semi();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.JumpStatementImpl <em>Jump Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.JumpStatementImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getJumpStatement()
     * @generated
     */
    EClass JUMP_STATEMENT = eINSTANCE.getJumpStatement();

    /**
     * The meta object literal for the '<em><b>Return</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JUMP_STATEMENT__RETURN = eINSTANCE.getJumpStatement_Return();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JUMP_STATEMENT__EXPR = eINSTANCE.getJumpStatement_Expr();

    /**
     * The meta object literal for the '<em><b>Semi</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JUMP_STATEMENT__SEMI = eINSTANCE.getJumpStatement_Semi();

    /**
     * The meta object literal for the '<em><b>Goto</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JUMP_STATEMENT__GOTO = eINSTANCE.getJumpStatement_Goto();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.ExpressionImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '<em><b>Expr Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__EXPR_EXPR = eINSTANCE.getExpression_ExprExpr();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.AssignmentOperatorImpl <em>Assignment Operator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.AssignmentOperatorImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getAssignmentOperator()
     * @generated
     */
    EClass ASSIGNMENT_OPERATOR = eINSTANCE.getAssignmentOperator();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGNMENT_OPERATOR__OP = eINSTANCE.getAssignmentOperator_Op();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.UnaryOperatorImpl <em>Unary Operator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.UnaryOperatorImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getUnaryOperator()
     * @generated
     */
    EClass UNARY_OPERATOR = eINSTANCE.getUnaryOperator();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNARY_OPERATOR__OP = eINSTANCE.getUnaryOperator_Op();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.ArgumentExpressionListImpl <em>Argument Expression List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.ArgumentExpressionListImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getArgumentExpressionList()
     * @generated
     */
    EClass ARGUMENT_EXPRESSION_LIST = eINSTANCE.getArgumentExpressionList();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARGUMENT_EXPRESSION_LIST__EXPR = eINSTANCE.getArgumentExpressionList_Expr();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.ConstantImpl <em>Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.ConstantImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getConstant()
     * @generated
     */
    EClass CONSTANT = eINSTANCE.getConstant();

    /**
     * The meta object literal for the '<em><b>Hex</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTANT__HEX = eINSTANCE.getConstant_Hex();

    /**
     * The meta object literal for the '<em><b>Oct</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTANT__OCT = eINSTANCE.getConstant_Oct();

    /**
     * The meta object literal for the '<em><b>Dec</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTANT__DEC = eINSTANCE.getConstant_Dec();

    /**
     * The meta object literal for the '<em><b>Ch</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTANT__CH = eINSTANCE.getConstant_Ch();

    /**
     * The meta object literal for the '<em><b>Str</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTANT__STR = eINSTANCE.getConstant_Str();

    /**
     * The meta object literal for the '<em><b>Float</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTANT__FLOAT = eINSTANCE.getConstant_Float();

    /**
     * The meta object literal for the '<em><b>Bin</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTANT__BIN = eINSTANCE.getConstant_Bin();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.LabeledStatementImpl <em>Labeled Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.LabeledStatementImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getLabeledStatement()
     * @generated
     */
    EClass LABELED_STATEMENT = eINSTANCE.getLabeledStatement();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LABELED_STATEMENT__ID = eINSTANCE.getLabeledStatement_Id();

    /**
     * The meta object literal for the '<em><b>LStmt</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LABELED_STATEMENT__LSTMT = eINSTANCE.getLabeledStatement_LStmt();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.CompoundStatementImpl <em>Compound Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.CompoundStatementImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getCompoundStatement()
     * @generated
     */
    EClass COMPOUND_STATEMENT = eINSTANCE.getCompoundStatement();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPOUND_STATEMENT__BODY = eINSTANCE.getCompoundStatement_Body();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.BodyStatementImpl <em>Body Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.BodyStatementImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getBodyStatement()
     * @generated
     */
    EClass BODY_STATEMENT = eINSTANCE.getBodyStatement();

    /**
     * The meta object literal for the '<em><b>Block List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BODY_STATEMENT__BLOCK_LIST = eINSTANCE.getBodyStatement_BlockList();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.AssignmentExpressionImpl <em>Assignment Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.AssignmentExpressionImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getAssignmentExpression()
     * @generated
     */
    EClass ASSIGNMENT_EXPRESSION = eINSTANCE.getAssignmentExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT_EXPRESSION__EXPR = eINSTANCE.getAssignmentExpression_Expr();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT_EXPRESSION__OP = eINSTANCE.getAssignmentExpression_Op();

    /**
     * The meta object literal for the '<em><b>Assignment Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPR = eINSTANCE.getAssignmentExpression_AssignmentExpr();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.ConditionalExpressionImpl <em>Conditional Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.ConditionalExpressionImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getConditionalExpression()
     * @generated
     */
    EClass CONDITIONAL_EXPRESSION = eINSTANCE.getConditionalExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_EXPRESSION__EXPR = eINSTANCE.getConditionalExpression_Expr();

    /**
     * The meta object literal for the '<em><b>QExpr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_EXPRESSION__QEXPR = eINSTANCE.getConditionalExpression_QExpr();

    /**
     * The meta object literal for the '<em><b>CExpr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_EXPRESSION__CEXPR = eINSTANCE.getConditionalExpression_CExpr();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.LogicalOrExpressionImpl <em>Logical Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.LogicalOrExpressionImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getLogicalOrExpression()
     * @generated
     */
    EClass LOGICAL_OR_EXPRESSION = eINSTANCE.getLogicalOrExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_OR_EXPRESSION__EXPR = eINSTANCE.getLogicalOrExpression_Expr();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.LogicalAndExpressionImpl <em>Logical And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.LogicalAndExpressionImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getLogicalAndExpression()
     * @generated
     */
    EClass LOGICAL_AND_EXPRESSION = eINSTANCE.getLogicalAndExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_AND_EXPRESSION__EXPR = eINSTANCE.getLogicalAndExpression_Expr();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.InclusiveOrExpressionImpl <em>Inclusive Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.InclusiveOrExpressionImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getInclusiveOrExpression()
     * @generated
     */
    EClass INCLUSIVE_OR_EXPRESSION = eINSTANCE.getInclusiveOrExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INCLUSIVE_OR_EXPRESSION__EXPR = eINSTANCE.getInclusiveOrExpression_Expr();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.ExclusiveOrExpressionImpl <em>Exclusive Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.ExclusiveOrExpressionImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getExclusiveOrExpression()
     * @generated
     */
    EClass EXCLUSIVE_OR_EXPRESSION = eINSTANCE.getExclusiveOrExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXCLUSIVE_OR_EXPRESSION__EXPR = eINSTANCE.getExclusiveOrExpression_Expr();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.AndExpressionImpl <em>And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.AndExpressionImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getAndExpression()
     * @generated
     */
    EClass AND_EXPRESSION = eINSTANCE.getAndExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_EXPRESSION__EXPR = eINSTANCE.getAndExpression_Expr();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.EqualityExpressionImpl <em>Equality Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.EqualityExpressionImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getEqualityExpression()
     * @generated
     */
    EClass EQUALITY_EXPRESSION = eINSTANCE.getEqualityExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_EXPRESSION__EXPR = eINSTANCE.getEqualityExpression_Expr();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EQUALITY_EXPRESSION__OP = eINSTANCE.getEqualityExpression_Op();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.RelationalExpressionImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getRelationalExpression()
     * @generated
     */
    EClass RELATIONAL_EXPRESSION = eINSTANCE.getRelationalExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_EXPRESSION__EXPR = eINSTANCE.getRelationalExpression_Expr();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATIONAL_EXPRESSION__OP = eINSTANCE.getRelationalExpression_Op();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.ShiftExpressionImpl <em>Shift Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.ShiftExpressionImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getShiftExpression()
     * @generated
     */
    EClass SHIFT_EXPRESSION = eINSTANCE.getShiftExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SHIFT_EXPRESSION__EXPR = eINSTANCE.getShiftExpression_Expr();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SHIFT_EXPRESSION__OP = eINSTANCE.getShiftExpression_Op();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.AdditiveExpressionImpl <em>Additive Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.AdditiveExpressionImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getAdditiveExpression()
     * @generated
     */
    EClass ADDITIVE_EXPRESSION = eINSTANCE.getAdditiveExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADDITIVE_EXPRESSION__EXPR = eINSTANCE.getAdditiveExpression_Expr();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ADDITIVE_EXPRESSION__OP = eINSTANCE.getAdditiveExpression_Op();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.MultiplicativeExpressionImpl <em>Multiplicative Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.MultiplicativeExpressionImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getMultiplicativeExpression()
     * @generated
     */
    EClass MULTIPLICATIVE_EXPRESSION = eINSTANCE.getMultiplicativeExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICATIVE_EXPRESSION__EXPR = eINSTANCE.getMultiplicativeExpression_Expr();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTIPLICATIVE_EXPRESSION__OP = eINSTANCE.getMultiplicativeExpression_Op();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.CastExpressionImpl <em>Cast Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.CastExpressionImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getCastExpression()
     * @generated
     */
    EClass CAST_EXPRESSION = eINSTANCE.getCastExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAST_EXPRESSION__EXPR = eINSTANCE.getCastExpression_Expr();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAST_EXPRESSION__TYPE = eINSTANCE.getCastExpression_Type();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.UnaryExpressionImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getUnaryExpression()
     * @generated
     */
    EClass UNARY_EXPRESSION = eINSTANCE.getUnaryExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_EXPRESSION__EXPR = eINSTANCE.getUnaryExpression_Expr();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_EXPRESSION__OP = eINSTANCE.getUnaryExpression_Op();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.PostfixExpressionImpl <em>Postfix Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.PostfixExpressionImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getPostfixExpression()
     * @generated
     */
    EClass POSTFIX_EXPRESSION = eINSTANCE.getPostfixExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POSTFIX_EXPRESSION__EXPR = eINSTANCE.getPostfixExpression_Expr();

    /**
     * The meta object literal for the '<em><b>Array Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POSTFIX_EXPRESSION__ARRAY_EXPR = eINSTANCE.getPostfixExpression_ArrayExpr();

    /**
     * The meta object literal for the '<em><b>Argument Expression List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POSTFIX_EXPRESSION__ARGUMENT_EXPRESSION_LIST = eINSTANCE.getPostfixExpression_ArgumentExpressionList();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.c.impl.PrimaryExpressionImpl <em>Primary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.c.impl.PrimaryExpressionImpl
     * @see at.jku.weiner.c.c.impl.CPackageImpl#getPrimaryExpression()
     * @generated
     */
    EClass PRIMARY_EXPRESSION = eINSTANCE.getPrimaryExpression();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIMARY_EXPRESSION__ID = eINSTANCE.getPrimaryExpression_Id();

    /**
     * The meta object literal for the '<em><b>Const</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_EXPRESSION__CONST = eINSTANCE.getPrimaryExpression_Const();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_EXPRESSION__EXPR = eINSTANCE.getPrimaryExpression_Expr();

  }

} //CPackage
