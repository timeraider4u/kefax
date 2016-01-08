/**
 */
package at.jku.weiner.c.parser.parser;

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
 * @see at.jku.weiner.c.parser.parser.ParserFactory
 * @model kind="package"
 * @generated
 */
public interface ParserPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "parser";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.jku.at/weiner/c/parser/Parser";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "parser";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ParserPackage eINSTANCE = at.jku.weiner.c.parser.parser.impl.ParserPackageImpl.init();

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.ExternalDeclarationImpl <em>External Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.ExternalDeclarationImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getExternalDeclaration()
   * @generated
   */
  int EXTERNAL_DECLARATION = 0;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.FunctionDefHeadImpl <em>Function Def Head</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.FunctionDefHeadImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getFunctionDefHead()
   * @generated
   */
  int FUNCTION_DEF_HEAD = 1;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.FunctionDefinitionImpl <em>Function Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.FunctionDefinitionImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getFunctionDefinition()
   * @generated
   */
  int FUNCTION_DEFINITION = 2;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.DeclarationImpl <em>Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.DeclarationImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getDeclaration()
   * @generated
   */
  int DECLARATION = 3;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.FunctionDeclarationSpecifiersImpl <em>Function Declaration Specifiers</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.FunctionDeclarationSpecifiersImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getFunctionDeclarationSpecifiers()
   * @generated
   */
  int FUNCTION_DECLARATION_SPECIFIERS = 4;

  /**
   * The feature id for the '<em><b>Declaration Specifier</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DECLARATION_SPECIFIERS__DECLARATION_SPECIFIER = 0;

  /**
   * The number of structural features of the '<em>Function Declaration Specifiers</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DECLARATION_SPECIFIERS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.DeclarationSpecifiersImpl <em>Declaration Specifiers</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.DeclarationSpecifiersImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getDeclarationSpecifiers()
   * @generated
   */
  int DECLARATION_SPECIFIERS = 5;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.InitDeclaratorListImpl <em>Init Declarator List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.InitDeclaratorListImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getInitDeclaratorList()
   * @generated
   */
  int INIT_DECLARATOR_LIST = 6;

  /**
   * The feature id for the '<em><b>Init Declarator</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_DECLARATOR_LIST__INIT_DECLARATOR = 0;

  /**
   * The number of structural features of the '<em>Init Declarator List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_DECLARATOR_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.InitDeclaratorImpl <em>Init Declarator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.InitDeclaratorImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getInitDeclarator()
   * @generated
   */
  int INIT_DECLARATOR = 7;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.StorageClassSpecifierImpl <em>Storage Class Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.StorageClassSpecifierImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getStorageClassSpecifier()
   * @generated
   */
  int STORAGE_CLASS_SPECIFIER = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORAGE_CLASS_SPECIFIER__NAME = 0;

  /**
   * The number of structural features of the '<em>Storage Class Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORAGE_CLASS_SPECIFIER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl <em>Type Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getTypeSpecifier()
   * @generated
   */
  int TYPE_SPECIFIER = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SPECIFIER__NAME = 0;

  /**
   * The feature id for the '<em><b>Ext Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SPECIFIER__EXT_TYPE = 1;

  /**
   * The feature id for the '<em><b>Specifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SPECIFIER__SPECIFIER = 2;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SPECIFIER__TYPE = 3;

  /**
   * The feature id for the '<em><b>Struct</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SPECIFIER__STRUCT = 4;

  /**
   * The number of structural features of the '<em>Type Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SPECIFIER_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.TypedefNameImpl <em>Typedef Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.TypedefNameImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getTypedefName()
   * @generated
   */
  int TYPEDEF_NAME = 10;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.StructOrUnionNameImpl <em>Struct Or Union Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.StructOrUnionNameImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getStructOrUnionName()
   * @generated
   */
  int STRUCT_OR_UNION_NAME = 11;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_OR_UNION_NAME__ID = 0;

  /**
   * The number of structural features of the '<em>Struct Or Union Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_OR_UNION_NAME_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.DeclarationSpecifierImpl <em>Declaration Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.DeclarationSpecifierImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getDeclarationSpecifier()
   * @generated
   */
  int DECLARATION_SPECIFIER = 12;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION_SPECIFIER__ID = 0;

  /**
   * The number of structural features of the '<em>Declaration Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION_SPECIFIER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.StructOrUnionImpl <em>Struct Or Union</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.StructOrUnionImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getStructOrUnion()
   * @generated
   */
  int STRUCT_OR_UNION = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_OR_UNION__NAME = 0;

  /**
   * The number of structural features of the '<em>Struct Or Union</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_OR_UNION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.StructDeclarationListImpl <em>Struct Declaration List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.StructDeclarationListImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getStructDeclarationList()
   * @generated
   */
  int STRUCT_DECLARATION_LIST = 14;

  /**
   * The feature id for the '<em><b>Struct Declaration</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_DECLARATION_LIST__STRUCT_DECLARATION = 0;

  /**
   * The number of structural features of the '<em>Struct Declaration List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_DECLARATION_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.StructDeclarationImpl <em>Struct Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.StructDeclarationImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getStructDeclaration()
   * @generated
   */
  int STRUCT_DECLARATION = 15;

  /**
   * The feature id for the '<em><b>List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_DECLARATION__LIST = 0;

  /**
   * The feature id for the '<em><b>Struct Declaration List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_DECLARATION__STRUCT_DECLARATION_LIST = 1;

  /**
   * The number of structural features of the '<em>Struct Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_DECLARATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.SpecifierQualifierListImpl <em>Specifier Qualifier List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.SpecifierQualifierListImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getSpecifierQualifierList()
   * @generated
   */
  int SPECIFIER_QUALIFIER_LIST = 16;

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
   * The feature id for the '<em><b>Struct Or Union Specifier</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFIER_QUALIFIER_LIST__STRUCT_OR_UNION_SPECIFIER = 2;

  /**
   * The number of structural features of the '<em>Specifier Qualifier List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFIER_QUALIFIER_LIST_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.StructDeclaratorListImpl <em>Struct Declarator List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.StructDeclaratorListImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getStructDeclaratorList()
   * @generated
   */
  int STRUCT_DECLARATOR_LIST = 17;

  /**
   * The feature id for the '<em><b>Struct Declarator</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_DECLARATOR_LIST__STRUCT_DECLARATOR = 0;

  /**
   * The number of structural features of the '<em>Struct Declarator List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_DECLARATOR_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.StructDeclaratorImpl <em>Struct Declarator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.StructDeclaratorImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getStructDeclarator()
   * @generated
   */
  int STRUCT_DECLARATOR = 18;

  /**
   * The feature id for the '<em><b>Declarator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_DECLARATOR__DECLARATOR = 0;

  /**
   * The feature id for the '<em><b>Const Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_DECLARATOR__CONST_EXPR = 1;

  /**
   * The number of structural features of the '<em>Struct Declarator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_DECLARATOR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.EnumeratorListImpl <em>Enumerator List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.EnumeratorListImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getEnumeratorList()
   * @generated
   */
  int ENUMERATOR_LIST = 19;

  /**
   * The feature id for the '<em><b>Enumerator</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATOR_LIST__ENUMERATOR = 0;

  /**
   * The feature id for the '<em><b>Last Comma</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATOR_LIST__LAST_COMMA = 1;

  /**
   * The number of structural features of the '<em>Enumerator List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATOR_LIST_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.EnumeratorImpl <em>Enumerator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.EnumeratorImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getEnumerator()
   * @generated
   */
  int ENUMERATOR = 20;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATOR__ID = 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATOR__EXPR = 1;

  /**
   * The number of structural features of the '<em>Enumerator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATOR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.TypeQualifierImpl <em>Type Qualifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.TypeQualifierImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getTypeQualifier()
   * @generated
   */
  int TYPE_QUALIFIER = 21;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.FunctionSpecifierImpl <em>Function Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.FunctionSpecifierImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getFunctionSpecifier()
   * @generated
   */
  int FUNCTION_SPECIFIER = 22;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_SPECIFIER__NAME = 0;

  /**
   * The feature id for the '<em><b>Gcc Attribute Specifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_SPECIFIER__GCC_ATTRIBUTE_SPECIFIER = 1;

  /**
   * The number of structural features of the '<em>Function Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_SPECIFIER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.DeclaratorImpl <em>Declarator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.DeclaratorImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getDeclarator()
   * @generated
   */
  int DECLARATOR = 23;

  /**
   * The feature id for the '<em><b>Pointer</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATOR__POINTER = 0;

  /**
   * The feature id for the '<em><b>Gcc Decl Ext1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATOR__GCC_DECL_EXT1 = 1;

  /**
   * The feature id for the '<em><b>Declarator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATOR__DECLARATOR = 2;

  /**
   * The feature id for the '<em><b>Gcc Decl Ext2</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATOR__GCC_DECL_EXT2 = 3;

  /**
   * The number of structural features of the '<em>Declarator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATOR_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.DirectDeclaratorImpl <em>Direct Declarator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.DirectDeclaratorImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getDirectDeclarator()
   * @generated
   */
  int DIRECT_DECLARATOR = 24;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.DeclaratorSuffixImpl <em>Declarator Suffix</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.DeclaratorSuffixImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getDeclaratorSuffix()
   * @generated
   */
  int DECLARATOR_SUFFIX = 25;

  /**
   * The feature id for the '<em><b>Type Qualifier List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST = 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATOR_SUFFIX__EXPR = 1;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATOR_SUFFIX__STATIC = 2;

  /**
   * The feature id for the '<em><b>Star</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATOR_SUFFIX__STAR = 3;

  /**
   * The feature id for the '<em><b>Last Suffix</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATOR_SUFFIX__LAST_SUFFIX = 4;

  /**
   * The number of structural features of the '<em>Declarator Suffix</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATOR_SUFFIX_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.DirectDeclaratorLastSuffixImpl <em>Direct Declarator Last Suffix</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.DirectDeclaratorLastSuffixImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getDirectDeclaratorLastSuffix()
   * @generated
   */
  int DIRECT_DECLARATOR_LAST_SUFFIX = 26;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.GccDeclaratorExtensionImpl <em>Gcc Declarator Extension</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.GccDeclaratorExtensionImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getGccDeclaratorExtension()
   * @generated
   */
  int GCC_DECLARATOR_EXTENSION = 27;

  /**
   * The feature id for the '<em><b>Asm</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GCC_DECLARATOR_EXTENSION__ASM = 0;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GCC_DECLARATOR_EXTENSION__STRING = 1;

  /**
   * The feature id for the '<em><b>Gcc Attribute Specifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GCC_DECLARATOR_EXTENSION__GCC_ATTRIBUTE_SPECIFIER = 2;

  /**
   * The number of structural features of the '<em>Gcc Declarator Extension</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GCC_DECLARATOR_EXTENSION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.GccAttributeSpecifierImpl <em>Gcc Attribute Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.GccAttributeSpecifierImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getGccAttributeSpecifier()
   * @generated
   */
  int GCC_ATTRIBUTE_SPECIFIER = 28;

  /**
   * The feature id for the '<em><b>List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GCC_ATTRIBUTE_SPECIFIER__LIST = 0;

  /**
   * The number of structural features of the '<em>Gcc Attribute Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GCC_ATTRIBUTE_SPECIFIER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.GccAttributeListImpl <em>Gcc Attribute List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.GccAttributeListImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getGccAttributeList()
   * @generated
   */
  int GCC_ATTRIBUTE_LIST = 29;

  /**
   * The feature id for the '<em><b>Gcc Attribute</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GCC_ATTRIBUTE_LIST__GCC_ATTRIBUTE = 0;

  /**
   * The number of structural features of the '<em>Gcc Attribute List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GCC_ATTRIBUTE_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.GccAttributeImpl <em>Gcc Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.GccAttributeImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getGccAttribute()
   * @generated
   */
  int GCC_ATTRIBUTE = 30;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GCC_ATTRIBUTE__ID = 0;

  /**
   * The feature id for the '<em><b>Const</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GCC_ATTRIBUTE__CONST = 1;

  /**
   * The feature id for the '<em><b>Keyword</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GCC_ATTRIBUTE__KEYWORD = 2;

  /**
   * The feature id for the '<em><b>List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GCC_ATTRIBUTE__LIST = 3;

  /**
   * The number of structural features of the '<em>Gcc Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GCC_ATTRIBUTE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.PointerImpl <em>Pointer</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.PointerImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getPointer()
   * @generated
   */
  int POINTER = 31;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.TypeQualifierListImpl <em>Type Qualifier List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.TypeQualifierListImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getTypeQualifierList()
   * @generated
   */
  int TYPE_QUALIFIER_LIST = 32;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.ParameterTypeListImpl <em>Parameter Type List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.ParameterTypeListImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getParameterTypeList()
   * @generated
   */
  int PARAMETER_TYPE_LIST = 33;

  /**
   * The feature id for the '<em><b>List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_TYPE_LIST__LIST = 0;

  /**
   * The feature id for the '<em><b>Ellipsis</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_TYPE_LIST__ELLIPSIS = 1;

  /**
   * The number of structural features of the '<em>Parameter Type List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_TYPE_LIST_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.ParameterListImpl <em>Parameter List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.ParameterListImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getParameterList()
   * @generated
   */
  int PARAMETER_LIST = 34;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.ParameterDeclarationImpl <em>Parameter Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.ParameterDeclarationImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getParameterDeclaration()
   * @generated
   */
  int PARAMETER_DECLARATION = 35;

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
   * The feature id for the '<em><b>Abstract Declator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_DECLARATION__ABSTRACT_DECLATOR = 2;

  /**
   * The number of structural features of the '<em>Parameter Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_DECLARATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.IdentifierListImpl <em>Identifier List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.IdentifierListImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getIdentifierList()
   * @generated
   */
  int IDENTIFIER_LIST = 36;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.MyIdentifierImpl <em>My Identifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.MyIdentifierImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getMyIdentifier()
   * @generated
   */
  int MY_IDENTIFIER = 37;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.TypeNameImpl <em>Type Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.TypeNameImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getTypeName()
   * @generated
   */
  int TYPE_NAME = 38;

  /**
   * The feature id for the '<em><b>List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_NAME__LIST = 0;

  /**
   * The feature id for the '<em><b>Abstract Declarator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_NAME__ABSTRACT_DECLARATOR = 1;

  /**
   * The number of structural features of the '<em>Type Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_NAME_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.AbstractDeclaratorImpl <em>Abstract Declarator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.AbstractDeclaratorImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getAbstractDeclarator()
   * @generated
   */
  int ABSTRACT_DECLARATOR = 39;

  /**
   * The feature id for the '<em><b>Pointer</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_DECLARATOR__POINTER = 0;

  /**
   * The number of structural features of the '<em>Abstract Declarator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_DECLARATOR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.InitializerImpl <em>Initializer</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.InitializerImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getInitializer()
   * @generated
   */
  int INITIALIZER = 40;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INITIALIZER__EXPR = 0;

  /**
   * The feature id for the '<em><b>List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INITIALIZER__LIST = 1;

  /**
   * The number of structural features of the '<em>Initializer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INITIALIZER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.InitializerListImpl <em>Initializer List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.InitializerListImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getInitializerList()
   * @generated
   */
  int INITIALIZER_LIST = 41;

  /**
   * The feature id for the '<em><b>Initializer</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INITIALIZER_LIST__INITIALIZER = 0;

  /**
   * The number of structural features of the '<em>Initializer List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INITIALIZER_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.BlockListImpl <em>Block List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.BlockListImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getBlockList()
   * @generated
   */
  int BLOCK_LIST = 42;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.StatementImpl <em>Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.StatementImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getStatement()
   * @generated
   */
  int STATEMENT = 43;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.AsmLineWithoutColonImpl <em>Asm Line Without Colon</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.AsmLineWithoutColonImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getAsmLineWithoutColon()
   * @generated
   */
  int ASM_LINE_WITHOUT_COLON = 44;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASM_LINE_WITHOUT_COLON__EXPR = 0;

  /**
   * The feature id for the '<em><b>Asm Lines</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASM_LINE_WITHOUT_COLON__ASM_LINES = 1;

  /**
   * The number of structural features of the '<em>Asm Line Without Colon</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASM_LINE_WITHOUT_COLON_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.AsmLineImpl <em>Asm Line</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.AsmLineImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getAsmLine()
   * @generated
   */
  int ASM_LINE = 45;

  /**
   * The feature id for the '<em><b>Comma</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASM_LINE__COMMA = 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASM_LINE__EXPR = 1;

  /**
   * The number of structural features of the '<em>Asm Line</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASM_LINE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.AsmLineWithColonImpl <em>Asm Line With Colon</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.AsmLineWithColonImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getAsmLineWithColon()
   * @generated
   */
  int ASM_LINE_WITH_COLON = 46;

  /**
   * The feature id for the '<em><b>Asm Line</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASM_LINE_WITH_COLON__ASM_LINE = 0;

  /**
   * The number of structural features of the '<em>Asm Line With Colon</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASM_LINE_WITH_COLON_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.ExpressionImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 47;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__EXPRESSION = CommonPackage.EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Expr Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__EXPR_EXPR = CommonPackage.EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = CommonPackage.EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.AssignmentOperatorImpl <em>Assignment Operator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.AssignmentOperatorImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getAssignmentOperator()
   * @generated
   */
  int ASSIGNMENT_OPERATOR = 48;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.UnaryOperatorImpl <em>Unary Operator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.UnaryOperatorImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getUnaryOperator()
   * @generated
   */
  int UNARY_OPERATOR = 49;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_OPERATOR__OP = CommonPackage.UNARY_OPERATOR__OP;

  /**
   * The number of structural features of the '<em>Unary Operator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_OPERATOR_FEATURE_COUNT = CommonPackage.UNARY_OPERATOR_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixImpl <em>Postfix Expression Suffix</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getPostfixExpressionSuffix()
   * @generated
   */
  int POSTFIX_EXPRESSION_SUFFIX = 50;

  /**
   * The number of structural features of the '<em>Postfix Expression Suffix</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION_SUFFIX_FEATURE_COUNT = CommonPackage.POSTFIX_EXPRESSION_SUFFIX_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.ArgumentExpressionListImpl <em>Argument Expression List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.ArgumentExpressionListImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getArgumentExpressionList()
   * @generated
   */
  int ARGUMENT_EXPRESSION_LIST = 51;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_EXPRESSION_LIST__EXPR = CommonPackage.ARGUMENT_EXPRESSION_LIST__EXPR;

  /**
   * The number of structural features of the '<em>Argument Expression List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_EXPRESSION_LIST_FEATURE_COUNT = CommonPackage.ARGUMENT_EXPRESSION_LIST_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.ParserImpl <em>Parser</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.ParserImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getParser()
   * @generated
   */
  int PARSER = 52;

  /**
   * The feature id for the '<em><b>External</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARSER__EXTERNAL = CommonPackage.PARSER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Parser</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARSER_FEATURE_COUNT = CommonPackage.PARSER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.StructOrUnionSpecifierImpl <em>Struct Or Union Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.StructOrUnionSpecifierImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getStructOrUnionSpecifier()
   * @generated
   */
  int STRUCT_OR_UNION_SPECIFIER = 53;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_OR_UNION_SPECIFIER__ID = DECLARATION_SPECIFIER__ID;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_OR_UNION_SPECIFIER__TYPE = DECLARATION_SPECIFIER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Struct Decl List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_OR_UNION_SPECIFIER__STRUCT_DECL_LIST = DECLARATION_SPECIFIER_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Struct Or Union Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_OR_UNION_SPECIFIER_FEATURE_COUNT = DECLARATION_SPECIFIER_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.EnumSpecifierImpl <em>Enum Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.EnumSpecifierImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getEnumSpecifier()
   * @generated
   */
  int ENUM_SPECIFIER = 54;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_SPECIFIER__ID = DECLARATION_SPECIFIER__ID;

  /**
   * The feature id for the '<em><b>Enum List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_SPECIFIER__ENUM_LIST = DECLARATION_SPECIFIER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Enum Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_SPECIFIER_FEATURE_COUNT = DECLARATION_SPECIFIER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.LabeledStatementImpl <em>Labeled Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.LabeledStatementImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getLabeledStatement()
   * @generated
   */
  int LABELED_STATEMENT = 55;

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
   * The feature id for the '<em><b>Case</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABELED_STATEMENT__CASE = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Lower</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABELED_STATEMENT__LOWER = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Higher</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABELED_STATEMENT__HIGHER = STATEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABELED_STATEMENT__EXPR = STATEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Mydefault</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABELED_STATEMENT__MYDEFAULT = STATEMENT_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>Labeled Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABELED_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 7;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.CompoundStatementImpl <em>Compound Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.CompoundStatementImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getCompoundStatement()
   * @generated
   */
  int COMPOUND_STATEMENT = 56;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.BodyStatementImpl <em>Body Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.BodyStatementImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getBodyStatement()
   * @generated
   */
  int BODY_STATEMENT = 57;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.ExpressionStatementImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getExpressionStatement()
   * @generated
   */
  int EXPRESSION_STATEMENT = 58;

  /**
   * The feature id for the '<em><b>Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_STATEMENT__STMT = STATEMENT__STMT;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Semi</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_STATEMENT__SEMI = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Expression Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.SelectionStatementImpl <em>Selection Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.SelectionStatementImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getSelectionStatement()
   * @generated
   */
  int SELECTION_STATEMENT = 59;

  /**
   * The feature id for the '<em><b>Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_STATEMENT__STMT = STATEMENT__STMT;

  /**
   * The feature id for the '<em><b>If</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_STATEMENT__IF = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_STATEMENT__EXPR = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>If Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_STATEMENT__IF_STATEMENT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Else</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_STATEMENT__ELSE = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Else Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_STATEMENT__ELSE_STATEMENT = STATEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Switch</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_STATEMENT__SWITCH = STATEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Switch Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_STATEMENT__SWITCH_STATEMENT = STATEMENT_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>Selection Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 7;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.IterationStatementImpl <em>Iteration Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.IterationStatementImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getIterationStatement()
   * @generated
   */
  int ITERATION_STATEMENT = 60;

  /**
   * The feature id for the '<em><b>Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATION_STATEMENT__STMT = STATEMENT__STMT;

  /**
   * The feature id for the '<em><b>While</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATION_STATEMENT__WHILE = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATION_STATEMENT__EXPR = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATION_STATEMENT__STATEMENT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Do</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATION_STATEMENT__DO = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Semi</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATION_STATEMENT__SEMI = STATEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>For</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATION_STATEMENT__FOR = STATEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Init Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATION_STATEMENT__INIT_EXPR = STATEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Inc Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATION_STATEMENT__INC_EXPR = STATEMENT_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Init Decl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATION_STATEMENT__INIT_DECL = STATEMENT_FEATURE_COUNT + 8;

  /**
   * The number of structural features of the '<em>Iteration Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATION_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 9;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.JumpStatementImpl <em>Jump Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.JumpStatementImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getJumpStatement()
   * @generated
   */
  int JUMP_STATEMENT = 61;

  /**
   * The feature id for the '<em><b>Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUMP_STATEMENT__STMT = STATEMENT__STMT;

  /**
   * The feature id for the '<em><b>Continue</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUMP_STATEMENT__CONTINUE = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Semi</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUMP_STATEMENT__SEMI = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Break</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUMP_STATEMENT__BREAK = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Return</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUMP_STATEMENT__RETURN = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUMP_STATEMENT__EXPR = STATEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Goto</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUMP_STATEMENT__GOTO = STATEMENT_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Jump Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUMP_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.AsmStatementImpl <em>Asm Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.AsmStatementImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getAsmStatement()
   * @generated
   */
  int ASM_STATEMENT = 62;

  /**
   * The feature id for the '<em><b>Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASM_STATEMENT__STMT = STATEMENT__STMT;

  /**
   * The feature id for the '<em><b>Asm</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASM_STATEMENT__ASM = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Volatile</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASM_STATEMENT__VOLATILE = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Asm Line1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASM_STATEMENT__ASM_LINE1 = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Asm Lines</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASM_STATEMENT__ASM_LINES = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Semi</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASM_STATEMENT__SEMI = STATEMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Asm Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASM_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.AssignmentExpressionImpl <em>Assignment Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.AssignmentExpressionImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getAssignmentExpression()
   * @generated
   */
  int ASSIGNMENT_EXPRESSION = 63;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.ConditionalExpressionImpl <em>Conditional Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.ConditionalExpressionImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getConditionalExpression()
   * @generated
   */
  int CONDITIONAL_EXPRESSION = 64;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.LogicalOrExpressionImpl <em>Logical Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.LogicalOrExpressionImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getLogicalOrExpression()
   * @generated
   */
  int LOGICAL_OR_EXPRESSION = 65;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_OR_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.LogicalAndExpressionImpl <em>Logical And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.LogicalAndExpressionImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getLogicalAndExpression()
   * @generated
   */
  int LOGICAL_AND_EXPRESSION = 66;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_AND_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.InclusiveOrExpressionImpl <em>Inclusive Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.InclusiveOrExpressionImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getInclusiveOrExpression()
   * @generated
   */
  int INCLUSIVE_OR_EXPRESSION = 67;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUSIVE_OR_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.ExclusiveOrExpressionImpl <em>Exclusive Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.ExclusiveOrExpressionImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getExclusiveOrExpression()
   * @generated
   */
  int EXCLUSIVE_OR_EXPRESSION = 68;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCLUSIVE_OR_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.AndExpressionImpl <em>And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.AndExpressionImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getAndExpression()
   * @generated
   */
  int AND_EXPRESSION = 69;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.EqualityExpressionImpl <em>Equality Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.EqualityExpressionImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getEqualityExpression()
   * @generated
   */
  int EQUALITY_EXPRESSION = 70;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.RelationalExpressionImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getRelationalExpression()
   * @generated
   */
  int RELATIONAL_EXPRESSION = 71;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.ShiftExpressionImpl <em>Shift Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.ShiftExpressionImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getShiftExpression()
   * @generated
   */
  int SHIFT_EXPRESSION = 72;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.AdditiveExpressionImpl <em>Additive Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.AdditiveExpressionImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getAdditiveExpression()
   * @generated
   */
  int ADDITIVE_EXPRESSION = 73;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.MultiplicativeExpressionImpl <em>Multiplicative Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.MultiplicativeExpressionImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getMultiplicativeExpression()
   * @generated
   */
  int MULTIPLICATIVE_EXPRESSION = 74;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

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
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.CastExpressionImpl <em>Cast Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.CastExpressionImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getCastExpression()
   * @generated
   */
  int CAST_EXPRESSION = 75;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Expr Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST_EXPRESSION__EXPR_EXPR = EXPRESSION__EXPR_EXPR;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST_EXPRESSION__TYPE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Cast Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.UnaryExpressionImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getUnaryExpression()
   * @generated
   */
  int UNARY_EXPRESSION = 76;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

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
   * The feature id for the '<em><b>Plusplus</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__PLUSPLUS = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Minusminus</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__MINUSMINUS = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Size Of</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__SIZE_OF = EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Type Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__TYPE_NAME = EXPRESSION_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Align Of</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__ALIGN_OF = EXPRESSION_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Andand</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__ANDAND = EXPRESSION_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__ID = EXPRESSION_FEATURE_COUNT + 8;

  /**
   * The number of structural features of the '<em>Unary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 9;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionImpl <em>Postfix Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.PostfixExpressionImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getPostfixExpression()
   * @generated
   */
  int POSTFIX_EXPRESSION = 77;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

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
   * The feature id for the '<em><b>Suffix</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION__SUFFIX = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Postfix Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixArrayImpl <em>Postfix Expression Suffix Array</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixArrayImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getPostfixExpressionSuffixArray()
   * @generated
   */
  int POSTFIX_EXPRESSION_SUFFIX_ARRAY = 78;

  /**
   * The feature id for the '<em><b>Array Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION_SUFFIX_ARRAY__ARRAY_EXPR = POSTFIX_EXPRESSION_SUFFIX_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Postfix Expression Suffix Array</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION_SUFFIX_ARRAY_FEATURE_COUNT = POSTFIX_EXPRESSION_SUFFIX_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixArgumentImpl <em>Postfix Expression Suffix Argument</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixArgumentImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getPostfixExpressionSuffixArgument()
   * @generated
   */
  int POSTFIX_EXPRESSION_SUFFIX_ARGUMENT = 79;

  /**
   * The feature id for the '<em><b>Argument Expression List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION_SUFFIX_ARGUMENT__ARGUMENT_EXPRESSION_LIST = POSTFIX_EXPRESSION_SUFFIX_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Postfix Expression Suffix Argument</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION_SUFFIX_ARGUMENT_FEATURE_COUNT = POSTFIX_EXPRESSION_SUFFIX_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixDotImpl <em>Postfix Expression Suffix Dot</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixDotImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getPostfixExpressionSuffixDot()
   * @generated
   */
  int POSTFIX_EXPRESSION_SUFFIX_DOT = 80;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION_SUFFIX_DOT__ID = POSTFIX_EXPRESSION_SUFFIX_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Postfix Expression Suffix Dot</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION_SUFFIX_DOT_FEATURE_COUNT = POSTFIX_EXPRESSION_SUFFIX_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixArrowImpl <em>Postfix Expression Suffix Arrow</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixArrowImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getPostfixExpressionSuffixArrow()
   * @generated
   */
  int POSTFIX_EXPRESSION_SUFFIX_ARROW = 81;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION_SUFFIX_ARROW__ID = POSTFIX_EXPRESSION_SUFFIX_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Postfix Expression Suffix Arrow</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION_SUFFIX_ARROW_FEATURE_COUNT = POSTFIX_EXPRESSION_SUFFIX_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixPlusPlusImpl <em>Postfix Expression Suffix Plus Plus</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixPlusPlusImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getPostfixExpressionSuffixPlusPlus()
   * @generated
   */
  int POSTFIX_EXPRESSION_SUFFIX_PLUS_PLUS = 82;

  /**
   * The number of structural features of the '<em>Postfix Expression Suffix Plus Plus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION_SUFFIX_PLUS_PLUS_FEATURE_COUNT = POSTFIX_EXPRESSION_SUFFIX_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixMinusMinusImpl <em>Postfix Expression Suffix Minus Minus</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixMinusMinusImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getPostfixExpressionSuffixMinusMinus()
   * @generated
   */
  int POSTFIX_EXPRESSION_SUFFIX_MINUS_MINUS = 83;

  /**
   * The number of structural features of the '<em>Postfix Expression Suffix Minus Minus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION_SUFFIX_MINUS_MINUS_FEATURE_COUNT = POSTFIX_EXPRESSION_SUFFIX_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl <em>Primary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getPrimaryExpression()
   * @generated
   */
  int PRIMARY_EXPRESSION = 84;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

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
   * The feature id for the '<em><b>String</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__STRING = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Ext</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__EXT = EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Compound Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__COMPOUND_STMT = EXPRESSION_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Builtin offsetof</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__BUILTIN_OFFSETOF = EXPRESSION_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Type Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__TYPE_NAME = EXPRESSION_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>Primary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 8;

  /**
   * The meta object id for the '{@link at.jku.weiner.c.parser.parser.impl.ConstantExpressionImpl <em>Constant Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.c.parser.parser.impl.ConstantExpressionImpl
   * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getConstantExpression()
   * @generated
   */
  int CONSTANT_EXPRESSION = 85;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Expr Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_EXPRESSION__EXPR_EXPR = EXPRESSION__EXPR_EXPR;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_EXPRESSION__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Constant Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.ExternalDeclaration <em>External Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>External Declaration</em>'.
   * @see at.jku.weiner.c.parser.parser.ExternalDeclaration
   * @generated
   */
  EClass getExternalDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.ExternalDeclaration#getFunctiondefHead <em>Functiondef Head</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Functiondef Head</em>'.
   * @see at.jku.weiner.c.parser.parser.ExternalDeclaration#getFunctiondefHead()
   * @see #getExternalDeclaration()
   * @generated
   */
  EReference getExternalDeclaration_FunctiondefHead();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.ExternalDeclaration#getFunctionDefinition <em>Function Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Function Definition</em>'.
   * @see at.jku.weiner.c.parser.parser.ExternalDeclaration#getFunctionDefinition()
   * @see #getExternalDeclaration()
   * @generated
   */
  EReference getExternalDeclaration_FunctionDefinition();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.ExternalDeclaration#getDeclaration <em>Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Declaration</em>'.
   * @see at.jku.weiner.c.parser.parser.ExternalDeclaration#getDeclaration()
   * @see #getExternalDeclaration()
   * @generated
   */
  EReference getExternalDeclaration_Declaration();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.ExternalDeclaration#getSemi <em>Semi</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Semi</em>'.
   * @see at.jku.weiner.c.parser.parser.ExternalDeclaration#getSemi()
   * @see #getExternalDeclaration()
   * @generated
   */
  EAttribute getExternalDeclaration_Semi();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.FunctionDefHead <em>Function Def Head</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Def Head</em>'.
   * @see at.jku.weiner.c.parser.parser.FunctionDefHead
   * @generated
   */
  EClass getFunctionDefHead();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.FunctionDefHead#getFunDeclSpecifiers <em>Fun Decl Specifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Fun Decl Specifiers</em>'.
   * @see at.jku.weiner.c.parser.parser.FunctionDefHead#getFunDeclSpecifiers()
   * @see #getFunctionDefHead()
   * @generated
   */
  EReference getFunctionDefHead_FunDeclSpecifiers();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.FunctionDefHead#getFunDeclarator <em>Fun Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Fun Declarator</em>'.
   * @see at.jku.weiner.c.parser.parser.FunctionDefHead#getFunDeclarator()
   * @see #getFunctionDefHead()
   * @generated
   */
  EReference getFunctionDefHead_FunDeclarator();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.FunctionDefHead#getFunDeclaration <em>Fun Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fun Declaration</em>'.
   * @see at.jku.weiner.c.parser.parser.FunctionDefHead#getFunDeclaration()
   * @see #getFunctionDefHead()
   * @generated
   */
  EReference getFunctionDefHead_FunDeclaration();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.FunctionDefinition <em>Function Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Definition</em>'.
   * @see at.jku.weiner.c.parser.parser.FunctionDefinition
   * @generated
   */
  EClass getFunctionDefinition();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.FunctionDefinition#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see at.jku.weiner.c.parser.parser.FunctionDefinition#getBody()
   * @see #getFunctionDefinition()
   * @generated
   */
  EReference getFunctionDefinition_Body();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.Declaration <em>Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Declaration</em>'.
   * @see at.jku.weiner.c.parser.parser.Declaration
   * @generated
   */
  EClass getDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.Declaration#getSpecifiers <em>Specifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Specifiers</em>'.
   * @see at.jku.weiner.c.parser.parser.Declaration#getSpecifiers()
   * @see #getDeclaration()
   * @generated
   */
  EReference getDeclaration_Specifiers();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.Declaration#getInitDeclaratorList <em>Init Declarator List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Init Declarator List</em>'.
   * @see at.jku.weiner.c.parser.parser.Declaration#getInitDeclaratorList()
   * @see #getDeclaration()
   * @generated
   */
  EReference getDeclaration_InitDeclaratorList();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.Declaration#getSemi <em>Semi</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Semi</em>'.
   * @see at.jku.weiner.c.parser.parser.Declaration#getSemi()
   * @see #getDeclaration()
   * @generated
   */
  EAttribute getDeclaration_Semi();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers <em>Function Declaration Specifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Declaration Specifiers</em>'.
   * @see at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers
   * @generated
   */
  EClass getFunctionDeclarationSpecifiers();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers#getDeclarationSpecifier <em>Declaration Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Declaration Specifier</em>'.
   * @see at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers#getDeclarationSpecifier()
   * @see #getFunctionDeclarationSpecifiers()
   * @generated
   */
  EReference getFunctionDeclarationSpecifiers_DeclarationSpecifier();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.DeclarationSpecifiers <em>Declaration Specifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Declaration Specifiers</em>'.
   * @see at.jku.weiner.c.parser.parser.DeclarationSpecifiers
   * @generated
   */
  EClass getDeclarationSpecifiers();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.DeclarationSpecifiers#getDeclarationSpecifier <em>Declaration Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Declaration Specifier</em>'.
   * @see at.jku.weiner.c.parser.parser.DeclarationSpecifiers#getDeclarationSpecifier()
   * @see #getDeclarationSpecifiers()
   * @generated
   */
  EReference getDeclarationSpecifiers_DeclarationSpecifier();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.InitDeclaratorList <em>Init Declarator List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Init Declarator List</em>'.
   * @see at.jku.weiner.c.parser.parser.InitDeclaratorList
   * @generated
   */
  EClass getInitDeclaratorList();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.InitDeclaratorList#getInitDeclarator <em>Init Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Init Declarator</em>'.
   * @see at.jku.weiner.c.parser.parser.InitDeclaratorList#getInitDeclarator()
   * @see #getInitDeclaratorList()
   * @generated
   */
  EReference getInitDeclaratorList_InitDeclarator();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.InitDeclarator <em>Init Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Init Declarator</em>'.
   * @see at.jku.weiner.c.parser.parser.InitDeclarator
   * @generated
   */
  EClass getInitDeclarator();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.InitDeclarator#getDeclarator <em>Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Declarator</em>'.
   * @see at.jku.weiner.c.parser.parser.InitDeclarator#getDeclarator()
   * @see #getInitDeclarator()
   * @generated
   */
  EReference getInitDeclarator_Declarator();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.InitDeclarator#getInitializer <em>Initializer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Initializer</em>'.
   * @see at.jku.weiner.c.parser.parser.InitDeclarator#getInitializer()
   * @see #getInitDeclarator()
   * @generated
   */
  EReference getInitDeclarator_Initializer();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.StorageClassSpecifier <em>Storage Class Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Storage Class Specifier</em>'.
   * @see at.jku.weiner.c.parser.parser.StorageClassSpecifier
   * @generated
   */
  EClass getStorageClassSpecifier();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.StorageClassSpecifier#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see at.jku.weiner.c.parser.parser.StorageClassSpecifier#getName()
   * @see #getStorageClassSpecifier()
   * @generated
   */
  EAttribute getStorageClassSpecifier_Name();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.TypeSpecifier <em>Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Specifier</em>'.
   * @see at.jku.weiner.c.parser.parser.TypeSpecifier
   * @generated
   */
  EClass getTypeSpecifier();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.TypeSpecifier#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see at.jku.weiner.c.parser.parser.TypeSpecifier#getName()
   * @see #getTypeSpecifier()
   * @generated
   */
  EAttribute getTypeSpecifier_Name();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.TypeSpecifier#getExtType <em>Ext Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ext Type</em>'.
   * @see at.jku.weiner.c.parser.parser.TypeSpecifier#getExtType()
   * @see #getTypeSpecifier()
   * @generated
   */
  EAttribute getTypeSpecifier_ExtType();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.TypeSpecifier#getSpecifier <em>Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Specifier</em>'.
   * @see at.jku.weiner.c.parser.parser.TypeSpecifier#getSpecifier()
   * @see #getTypeSpecifier()
   * @generated
   */
  EReference getTypeSpecifier_Specifier();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.TypeSpecifier#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see at.jku.weiner.c.parser.parser.TypeSpecifier#getType()
   * @see #getTypeSpecifier()
   * @generated
   */
  EReference getTypeSpecifier_Type();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.TypeSpecifier#getStruct <em>Struct</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Struct</em>'.
   * @see at.jku.weiner.c.parser.parser.TypeSpecifier#getStruct()
   * @see #getTypeSpecifier()
   * @generated
   */
  EReference getTypeSpecifier_Struct();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.TypedefName <em>Typedef Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Typedef Name</em>'.
   * @see at.jku.weiner.c.parser.parser.TypedefName
   * @generated
   */
  EClass getTypedefName();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.TypedefName#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.c.parser.parser.TypedefName#getId()
   * @see #getTypedefName()
   * @generated
   */
  EAttribute getTypedefName_Id();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.StructOrUnionName <em>Struct Or Union Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Struct Or Union Name</em>'.
   * @see at.jku.weiner.c.parser.parser.StructOrUnionName
   * @generated
   */
  EClass getStructOrUnionName();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.StructOrUnionName#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.c.parser.parser.StructOrUnionName#getId()
   * @see #getStructOrUnionName()
   * @generated
   */
  EAttribute getStructOrUnionName_Id();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.DeclarationSpecifier <em>Declaration Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Declaration Specifier</em>'.
   * @see at.jku.weiner.c.parser.parser.DeclarationSpecifier
   * @generated
   */
  EClass getDeclarationSpecifier();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.DeclarationSpecifier#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.c.parser.parser.DeclarationSpecifier#getId()
   * @see #getDeclarationSpecifier()
   * @generated
   */
  EAttribute getDeclarationSpecifier_Id();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.StructOrUnion <em>Struct Or Union</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Struct Or Union</em>'.
   * @see at.jku.weiner.c.parser.parser.StructOrUnion
   * @generated
   */
  EClass getStructOrUnion();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.StructOrUnion#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see at.jku.weiner.c.parser.parser.StructOrUnion#getName()
   * @see #getStructOrUnion()
   * @generated
   */
  EAttribute getStructOrUnion_Name();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.StructDeclarationList <em>Struct Declaration List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Struct Declaration List</em>'.
   * @see at.jku.weiner.c.parser.parser.StructDeclarationList
   * @generated
   */
  EClass getStructDeclarationList();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.StructDeclarationList#getStructDeclaration <em>Struct Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Struct Declaration</em>'.
   * @see at.jku.weiner.c.parser.parser.StructDeclarationList#getStructDeclaration()
   * @see #getStructDeclarationList()
   * @generated
   */
  EReference getStructDeclarationList_StructDeclaration();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.StructDeclaration <em>Struct Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Struct Declaration</em>'.
   * @see at.jku.weiner.c.parser.parser.StructDeclaration
   * @generated
   */
  EClass getStructDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.StructDeclaration#getList <em>List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>List</em>'.
   * @see at.jku.weiner.c.parser.parser.StructDeclaration#getList()
   * @see #getStructDeclaration()
   * @generated
   */
  EReference getStructDeclaration_List();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.StructDeclaration#getStructDeclarationList <em>Struct Declaration List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Struct Declaration List</em>'.
   * @see at.jku.weiner.c.parser.parser.StructDeclaration#getStructDeclarationList()
   * @see #getStructDeclaration()
   * @generated
   */
  EReference getStructDeclaration_StructDeclarationList();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.SpecifierQualifierList <em>Specifier Qualifier List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Specifier Qualifier List</em>'.
   * @see at.jku.weiner.c.parser.parser.SpecifierQualifierList
   * @generated
   */
  EClass getSpecifierQualifierList();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.SpecifierQualifierList#getTypeSpecifier <em>Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type Specifier</em>'.
   * @see at.jku.weiner.c.parser.parser.SpecifierQualifierList#getTypeSpecifier()
   * @see #getSpecifierQualifierList()
   * @generated
   */
  EReference getSpecifierQualifierList_TypeSpecifier();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.SpecifierQualifierList#getTypeQualifier <em>Type Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type Qualifier</em>'.
   * @see at.jku.weiner.c.parser.parser.SpecifierQualifierList#getTypeQualifier()
   * @see #getSpecifierQualifierList()
   * @generated
   */
  EReference getSpecifierQualifierList_TypeQualifier();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.SpecifierQualifierList#getStructOrUnionSpecifier <em>Struct Or Union Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Struct Or Union Specifier</em>'.
   * @see at.jku.weiner.c.parser.parser.SpecifierQualifierList#getStructOrUnionSpecifier()
   * @see #getSpecifierQualifierList()
   * @generated
   */
  EReference getSpecifierQualifierList_StructOrUnionSpecifier();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.StructDeclaratorList <em>Struct Declarator List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Struct Declarator List</em>'.
   * @see at.jku.weiner.c.parser.parser.StructDeclaratorList
   * @generated
   */
  EClass getStructDeclaratorList();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.StructDeclaratorList#getStructDeclarator <em>Struct Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Struct Declarator</em>'.
   * @see at.jku.weiner.c.parser.parser.StructDeclaratorList#getStructDeclarator()
   * @see #getStructDeclaratorList()
   * @generated
   */
  EReference getStructDeclaratorList_StructDeclarator();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.StructDeclarator <em>Struct Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Struct Declarator</em>'.
   * @see at.jku.weiner.c.parser.parser.StructDeclarator
   * @generated
   */
  EClass getStructDeclarator();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.StructDeclarator#getDeclarator <em>Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Declarator</em>'.
   * @see at.jku.weiner.c.parser.parser.StructDeclarator#getDeclarator()
   * @see #getStructDeclarator()
   * @generated
   */
  EReference getStructDeclarator_Declarator();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.StructDeclarator#getConstExpr <em>Const Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Const Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.StructDeclarator#getConstExpr()
   * @see #getStructDeclarator()
   * @generated
   */
  EReference getStructDeclarator_ConstExpr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.EnumeratorList <em>Enumerator List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enumerator List</em>'.
   * @see at.jku.weiner.c.parser.parser.EnumeratorList
   * @generated
   */
  EClass getEnumeratorList();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.EnumeratorList#getEnumerator <em>Enumerator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Enumerator</em>'.
   * @see at.jku.weiner.c.parser.parser.EnumeratorList#getEnumerator()
   * @see #getEnumeratorList()
   * @generated
   */
  EReference getEnumeratorList_Enumerator();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.EnumeratorList#isLastComma <em>Last Comma</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Last Comma</em>'.
   * @see at.jku.weiner.c.parser.parser.EnumeratorList#isLastComma()
   * @see #getEnumeratorList()
   * @generated
   */
  EAttribute getEnumeratorList_LastComma();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.Enumerator <em>Enumerator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enumerator</em>'.
   * @see at.jku.weiner.c.parser.parser.Enumerator
   * @generated
   */
  EClass getEnumerator();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.Enumerator#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.c.parser.parser.Enumerator#getId()
   * @see #getEnumerator()
   * @generated
   */
  EAttribute getEnumerator_Id();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.Enumerator#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.Enumerator#getExpr()
   * @see #getEnumerator()
   * @generated
   */
  EReference getEnumerator_Expr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.TypeQualifier <em>Type Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Qualifier</em>'.
   * @see at.jku.weiner.c.parser.parser.TypeQualifier
   * @generated
   */
  EClass getTypeQualifier();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.TypeQualifier#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see at.jku.weiner.c.parser.parser.TypeQualifier#getType()
   * @see #getTypeQualifier()
   * @generated
   */
  EAttribute getTypeQualifier_Type();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.FunctionSpecifier <em>Function Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Specifier</em>'.
   * @see at.jku.weiner.c.parser.parser.FunctionSpecifier
   * @generated
   */
  EClass getFunctionSpecifier();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.FunctionSpecifier#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see at.jku.weiner.c.parser.parser.FunctionSpecifier#getName()
   * @see #getFunctionSpecifier()
   * @generated
   */
  EAttribute getFunctionSpecifier_Name();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.FunctionSpecifier#getGccAttributeSpecifier <em>Gcc Attribute Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Gcc Attribute Specifier</em>'.
   * @see at.jku.weiner.c.parser.parser.FunctionSpecifier#getGccAttributeSpecifier()
   * @see #getFunctionSpecifier()
   * @generated
   */
  EReference getFunctionSpecifier_GccAttributeSpecifier();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.Declarator <em>Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Declarator</em>'.
   * @see at.jku.weiner.c.parser.parser.Declarator
   * @generated
   */
  EClass getDeclarator();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.Declarator#getPointer <em>Pointer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Pointer</em>'.
   * @see at.jku.weiner.c.parser.parser.Declarator#getPointer()
   * @see #getDeclarator()
   * @generated
   */
  EReference getDeclarator_Pointer();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.Declarator#getGccDeclExt1 <em>Gcc Decl Ext1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Gcc Decl Ext1</em>'.
   * @see at.jku.weiner.c.parser.parser.Declarator#getGccDeclExt1()
   * @see #getDeclarator()
   * @generated
   */
  EReference getDeclarator_GccDeclExt1();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.Declarator#getDeclarator <em>Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Declarator</em>'.
   * @see at.jku.weiner.c.parser.parser.Declarator#getDeclarator()
   * @see #getDeclarator()
   * @generated
   */
  EReference getDeclarator_Declarator();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.Declarator#getGccDeclExt2 <em>Gcc Decl Ext2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Gcc Decl Ext2</em>'.
   * @see at.jku.weiner.c.parser.parser.Declarator#getGccDeclExt2()
   * @see #getDeclarator()
   * @generated
   */
  EReference getDeclarator_GccDeclExt2();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.DirectDeclarator <em>Direct Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Direct Declarator</em>'.
   * @see at.jku.weiner.c.parser.parser.DirectDeclarator
   * @generated
   */
  EClass getDirectDeclarator();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.DirectDeclarator#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.c.parser.parser.DirectDeclarator#getId()
   * @see #getDirectDeclarator()
   * @generated
   */
  EAttribute getDirectDeclarator_Id();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.DirectDeclarator#getDeclarator <em>Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Declarator</em>'.
   * @see at.jku.weiner.c.parser.parser.DirectDeclarator#getDeclarator()
   * @see #getDirectDeclarator()
   * @generated
   */
  EReference getDirectDeclarator_Declarator();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.DirectDeclarator#getDeclaratorSuffix <em>Declarator Suffix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Declarator Suffix</em>'.
   * @see at.jku.weiner.c.parser.parser.DirectDeclarator#getDeclaratorSuffix()
   * @see #getDirectDeclarator()
   * @generated
   */
  EReference getDirectDeclarator_DeclaratorSuffix();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.DeclaratorSuffix <em>Declarator Suffix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Declarator Suffix</em>'.
   * @see at.jku.weiner.c.parser.parser.DeclaratorSuffix
   * @generated
   */
  EClass getDeclaratorSuffix();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.DeclaratorSuffix#getTypeQualifierList <em>Type Qualifier List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type Qualifier List</em>'.
   * @see at.jku.weiner.c.parser.parser.DeclaratorSuffix#getTypeQualifierList()
   * @see #getDeclaratorSuffix()
   * @generated
   */
  EReference getDeclaratorSuffix_TypeQualifierList();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.DeclaratorSuffix#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.DeclaratorSuffix#getExpr()
   * @see #getDeclaratorSuffix()
   * @generated
   */
  EReference getDeclaratorSuffix_Expr();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.DeclaratorSuffix#getStatic <em>Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Static</em>'.
   * @see at.jku.weiner.c.parser.parser.DeclaratorSuffix#getStatic()
   * @see #getDeclaratorSuffix()
   * @generated
   */
  EAttribute getDeclaratorSuffix_Static();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.DeclaratorSuffix#getStar <em>Star</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Star</em>'.
   * @see at.jku.weiner.c.parser.parser.DeclaratorSuffix#getStar()
   * @see #getDeclaratorSuffix()
   * @generated
   */
  EAttribute getDeclaratorSuffix_Star();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.DeclaratorSuffix#getLastSuffix <em>Last Suffix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Last Suffix</em>'.
   * @see at.jku.weiner.c.parser.parser.DeclaratorSuffix#getLastSuffix()
   * @see #getDeclaratorSuffix()
   * @generated
   */
  EReference getDeclaratorSuffix_LastSuffix();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix <em>Direct Declarator Last Suffix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Direct Declarator Last Suffix</em>'.
   * @see at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix
   * @generated
   */
  EClass getDirectDeclaratorLastSuffix();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix#getParameterTypeList <em>Parameter Type List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameter Type List</em>'.
   * @see at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix#getParameterTypeList()
   * @see #getDirectDeclaratorLastSuffix()
   * @generated
   */
  EReference getDirectDeclaratorLastSuffix_ParameterTypeList();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix#getIdentifierList <em>Identifier List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Identifier List</em>'.
   * @see at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix#getIdentifierList()
   * @see #getDirectDeclaratorLastSuffix()
   * @generated
   */
  EReference getDirectDeclaratorLastSuffix_IdentifierList();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.GccDeclaratorExtension <em>Gcc Declarator Extension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Gcc Declarator Extension</em>'.
   * @see at.jku.weiner.c.parser.parser.GccDeclaratorExtension
   * @generated
   */
  EClass getGccDeclaratorExtension();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.GccDeclaratorExtension#getAsm <em>Asm</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Asm</em>'.
   * @see at.jku.weiner.c.parser.parser.GccDeclaratorExtension#getAsm()
   * @see #getGccDeclaratorExtension()
   * @generated
   */
  EAttribute getGccDeclaratorExtension_Asm();

  /**
   * Returns the meta object for the attribute list '{@link at.jku.weiner.c.parser.parser.GccDeclaratorExtension#getString <em>String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>String</em>'.
   * @see at.jku.weiner.c.parser.parser.GccDeclaratorExtension#getString()
   * @see #getGccDeclaratorExtension()
   * @generated
   */
  EAttribute getGccDeclaratorExtension_String();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.GccDeclaratorExtension#getGccAttributeSpecifier <em>Gcc Attribute Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Gcc Attribute Specifier</em>'.
   * @see at.jku.weiner.c.parser.parser.GccDeclaratorExtension#getGccAttributeSpecifier()
   * @see #getGccDeclaratorExtension()
   * @generated
   */
  EReference getGccDeclaratorExtension_GccAttributeSpecifier();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.GccAttributeSpecifier <em>Gcc Attribute Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Gcc Attribute Specifier</em>'.
   * @see at.jku.weiner.c.parser.parser.GccAttributeSpecifier
   * @generated
   */
  EClass getGccAttributeSpecifier();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.GccAttributeSpecifier#getList <em>List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>List</em>'.
   * @see at.jku.weiner.c.parser.parser.GccAttributeSpecifier#getList()
   * @see #getGccAttributeSpecifier()
   * @generated
   */
  EReference getGccAttributeSpecifier_List();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.GccAttributeList <em>Gcc Attribute List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Gcc Attribute List</em>'.
   * @see at.jku.weiner.c.parser.parser.GccAttributeList
   * @generated
   */
  EClass getGccAttributeList();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.GccAttributeList#getGccAttribute <em>Gcc Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Gcc Attribute</em>'.
   * @see at.jku.weiner.c.parser.parser.GccAttributeList#getGccAttribute()
   * @see #getGccAttributeList()
   * @generated
   */
  EReference getGccAttributeList_GccAttribute();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.GccAttribute <em>Gcc Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Gcc Attribute</em>'.
   * @see at.jku.weiner.c.parser.parser.GccAttribute
   * @generated
   */
  EClass getGccAttribute();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.GccAttribute#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.c.parser.parser.GccAttribute#getId()
   * @see #getGccAttribute()
   * @generated
   */
  EAttribute getGccAttribute_Id();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.GccAttribute#getConst <em>Const</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Const</em>'.
   * @see at.jku.weiner.c.parser.parser.GccAttribute#getConst()
   * @see #getGccAttribute()
   * @generated
   */
  EAttribute getGccAttribute_Const();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.GccAttribute#getKeyword <em>Keyword</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Keyword</em>'.
   * @see at.jku.weiner.c.parser.parser.GccAttribute#getKeyword()
   * @see #getGccAttribute()
   * @generated
   */
  EAttribute getGccAttribute_Keyword();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.GccAttribute#getList <em>List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>List</em>'.
   * @see at.jku.weiner.c.parser.parser.GccAttribute#getList()
   * @see #getGccAttribute()
   * @generated
   */
  EReference getGccAttribute_List();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.Pointer <em>Pointer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pointer</em>'.
   * @see at.jku.weiner.c.parser.parser.Pointer
   * @generated
   */
  EClass getPointer();

  /**
   * Returns the meta object for the attribute list '{@link at.jku.weiner.c.parser.parser.Pointer#getStar <em>Star</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Star</em>'.
   * @see at.jku.weiner.c.parser.parser.Pointer#getStar()
   * @see #getPointer()
   * @generated
   */
  EAttribute getPointer_Star();

  /**
   * Returns the meta object for the attribute list '{@link at.jku.weiner.c.parser.parser.Pointer#getCaret <em>Caret</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Caret</em>'.
   * @see at.jku.weiner.c.parser.parser.Pointer#getCaret()
   * @see #getPointer()
   * @generated
   */
  EAttribute getPointer_Caret();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.Pointer#getTypeQualifierList <em>Type Qualifier List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type Qualifier List</em>'.
   * @see at.jku.weiner.c.parser.parser.Pointer#getTypeQualifierList()
   * @see #getPointer()
   * @generated
   */
  EReference getPointer_TypeQualifierList();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.TypeQualifierList <em>Type Qualifier List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Qualifier List</em>'.
   * @see at.jku.weiner.c.parser.parser.TypeQualifierList
   * @generated
   */
  EClass getTypeQualifierList();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.TypeQualifierList#getTypeQualifier <em>Type Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type Qualifier</em>'.
   * @see at.jku.weiner.c.parser.parser.TypeQualifierList#getTypeQualifier()
   * @see #getTypeQualifierList()
   * @generated
   */
  EReference getTypeQualifierList_TypeQualifier();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.ParameterTypeList <em>Parameter Type List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Type List</em>'.
   * @see at.jku.weiner.c.parser.parser.ParameterTypeList
   * @generated
   */
  EClass getParameterTypeList();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.ParameterTypeList#getList <em>List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>List</em>'.
   * @see at.jku.weiner.c.parser.parser.ParameterTypeList#getList()
   * @see #getParameterTypeList()
   * @generated
   */
  EReference getParameterTypeList_List();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.ParameterTypeList#isEllipsis <em>Ellipsis</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ellipsis</em>'.
   * @see at.jku.weiner.c.parser.parser.ParameterTypeList#isEllipsis()
   * @see #getParameterTypeList()
   * @generated
   */
  EAttribute getParameterTypeList_Ellipsis();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.ParameterList <em>Parameter List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter List</em>'.
   * @see at.jku.weiner.c.parser.parser.ParameterList
   * @generated
   */
  EClass getParameterList();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.ParameterList#getParameterDeclaration <em>Parameter Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameter Declaration</em>'.
   * @see at.jku.weiner.c.parser.parser.ParameterList#getParameterDeclaration()
   * @see #getParameterList()
   * @generated
   */
  EReference getParameterList_ParameterDeclaration();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.ParameterDeclaration <em>Parameter Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Declaration</em>'.
   * @see at.jku.weiner.c.parser.parser.ParameterDeclaration
   * @generated
   */
  EClass getParameterDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.ParameterDeclaration#getDeclSpecifiers <em>Decl Specifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Decl Specifiers</em>'.
   * @see at.jku.weiner.c.parser.parser.ParameterDeclaration#getDeclSpecifiers()
   * @see #getParameterDeclaration()
   * @generated
   */
  EReference getParameterDeclaration_DeclSpecifiers();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.ParameterDeclaration#getDeclarator <em>Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Declarator</em>'.
   * @see at.jku.weiner.c.parser.parser.ParameterDeclaration#getDeclarator()
   * @see #getParameterDeclaration()
   * @generated
   */
  EReference getParameterDeclaration_Declarator();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.ParameterDeclaration#getAbstractDeclator <em>Abstract Declator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Abstract Declator</em>'.
   * @see at.jku.weiner.c.parser.parser.ParameterDeclaration#getAbstractDeclator()
   * @see #getParameterDeclaration()
   * @generated
   */
  EReference getParameterDeclaration_AbstractDeclator();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.IdentifierList <em>Identifier List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Identifier List</em>'.
   * @see at.jku.weiner.c.parser.parser.IdentifierList
   * @generated
   */
  EClass getIdentifierList();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.IdentifierList#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Id</em>'.
   * @see at.jku.weiner.c.parser.parser.IdentifierList#getId()
   * @see #getIdentifierList()
   * @generated
   */
  EReference getIdentifierList_Id();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.MyIdentifier <em>My Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Identifier</em>'.
   * @see at.jku.weiner.c.parser.parser.MyIdentifier
   * @generated
   */
  EClass getMyIdentifier();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.MyIdentifier#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.c.parser.parser.MyIdentifier#getId()
   * @see #getMyIdentifier()
   * @generated
   */
  EAttribute getMyIdentifier_Id();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.TypeName <em>Type Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Name</em>'.
   * @see at.jku.weiner.c.parser.parser.TypeName
   * @generated
   */
  EClass getTypeName();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.TypeName#getList <em>List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>List</em>'.
   * @see at.jku.weiner.c.parser.parser.TypeName#getList()
   * @see #getTypeName()
   * @generated
   */
  EReference getTypeName_List();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.TypeName#getAbstractDeclarator <em>Abstract Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Abstract Declarator</em>'.
   * @see at.jku.weiner.c.parser.parser.TypeName#getAbstractDeclarator()
   * @see #getTypeName()
   * @generated
   */
  EReference getTypeName_AbstractDeclarator();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.AbstractDeclarator <em>Abstract Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Declarator</em>'.
   * @see at.jku.weiner.c.parser.parser.AbstractDeclarator
   * @generated
   */
  EClass getAbstractDeclarator();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.AbstractDeclarator#getPointer <em>Pointer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Pointer</em>'.
   * @see at.jku.weiner.c.parser.parser.AbstractDeclarator#getPointer()
   * @see #getAbstractDeclarator()
   * @generated
   */
  EReference getAbstractDeclarator_Pointer();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.Initializer <em>Initializer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Initializer</em>'.
   * @see at.jku.weiner.c.parser.parser.Initializer
   * @generated
   */
  EClass getInitializer();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.Initializer#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.Initializer#getExpr()
   * @see #getInitializer()
   * @generated
   */
  EReference getInitializer_Expr();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.Initializer#getList <em>List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>List</em>'.
   * @see at.jku.weiner.c.parser.parser.Initializer#getList()
   * @see #getInitializer()
   * @generated
   */
  EReference getInitializer_List();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.InitializerList <em>Initializer List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Initializer List</em>'.
   * @see at.jku.weiner.c.parser.parser.InitializerList
   * @generated
   */
  EClass getInitializerList();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.InitializerList#getInitializer <em>Initializer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Initializer</em>'.
   * @see at.jku.weiner.c.parser.parser.InitializerList#getInitializer()
   * @see #getInitializerList()
   * @generated
   */
  EReference getInitializerList_Initializer();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.BlockList <em>Block List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Block List</em>'.
   * @see at.jku.weiner.c.parser.parser.BlockList
   * @generated
   */
  EClass getBlockList();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.BlockList#getDeclaration <em>Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Declaration</em>'.
   * @see at.jku.weiner.c.parser.parser.BlockList#getDeclaration()
   * @see #getBlockList()
   * @generated
   */
  EReference getBlockList_Declaration();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.BlockList#getStatement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statement</em>'.
   * @see at.jku.weiner.c.parser.parser.BlockList#getStatement()
   * @see #getBlockList()
   * @generated
   */
  EReference getBlockList_Statement();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement</em>'.
   * @see at.jku.weiner.c.parser.parser.Statement
   * @generated
   */
  EClass getStatement();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.Statement#getStmt <em>Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Stmt</em>'.
   * @see at.jku.weiner.c.parser.parser.Statement#getStmt()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_Stmt();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.AsmLineWithoutColon <em>Asm Line Without Colon</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Asm Line Without Colon</em>'.
   * @see at.jku.weiner.c.parser.parser.AsmLineWithoutColon
   * @generated
   */
  EClass getAsmLineWithoutColon();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.AsmLineWithoutColon#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.AsmLineWithoutColon#getExpr()
   * @see #getAsmLineWithoutColon()
   * @generated
   */
  EReference getAsmLineWithoutColon_Expr();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.AsmLineWithoutColon#getAsmLines <em>Asm Lines</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Asm Lines</em>'.
   * @see at.jku.weiner.c.parser.parser.AsmLineWithoutColon#getAsmLines()
   * @see #getAsmLineWithoutColon()
   * @generated
   */
  EReference getAsmLineWithoutColon_AsmLines();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.AsmLine <em>Asm Line</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Asm Line</em>'.
   * @see at.jku.weiner.c.parser.parser.AsmLine
   * @generated
   */
  EClass getAsmLine();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.AsmLine#isComma <em>Comma</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Comma</em>'.
   * @see at.jku.weiner.c.parser.parser.AsmLine#isComma()
   * @see #getAsmLine()
   * @generated
   */
  EAttribute getAsmLine_Comma();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.AsmLine#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.AsmLine#getExpr()
   * @see #getAsmLine()
   * @generated
   */
  EReference getAsmLine_Expr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.AsmLineWithColon <em>Asm Line With Colon</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Asm Line With Colon</em>'.
   * @see at.jku.weiner.c.parser.parser.AsmLineWithColon
   * @generated
   */
  EClass getAsmLineWithColon();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.AsmLineWithColon#getAsmLine <em>Asm Line</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Asm Line</em>'.
   * @see at.jku.weiner.c.parser.parser.AsmLineWithColon#getAsmLine()
   * @see #getAsmLineWithColon()
   * @generated
   */
  EReference getAsmLineWithColon_AsmLine();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see at.jku.weiner.c.parser.parser.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.Expression#getExprExpr <em>Expr Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.Expression#getExprExpr()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_ExprExpr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.AssignmentOperator <em>Assignment Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment Operator</em>'.
   * @see at.jku.weiner.c.parser.parser.AssignmentOperator
   * @generated
   */
  EClass getAssignmentOperator();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.AssignmentOperator#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see at.jku.weiner.c.parser.parser.AssignmentOperator#getOp()
   * @see #getAssignmentOperator()
   * @generated
   */
  EAttribute getAssignmentOperator_Op();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.UnaryOperator <em>Unary Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Operator</em>'.
   * @see at.jku.weiner.c.parser.parser.UnaryOperator
   * @generated
   */
  EClass getUnaryOperator();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.PostfixExpressionSuffix <em>Postfix Expression Suffix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Postfix Expression Suffix</em>'.
   * @see at.jku.weiner.c.parser.parser.PostfixExpressionSuffix
   * @generated
   */
  EClass getPostfixExpressionSuffix();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.ArgumentExpressionList <em>Argument Expression List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Argument Expression List</em>'.
   * @see at.jku.weiner.c.parser.parser.ArgumentExpressionList
   * @generated
   */
  EClass getArgumentExpressionList();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.Parser <em>Parser</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parser</em>'.
   * @see at.jku.weiner.c.parser.parser.Parser
   * @generated
   */
  EClass getParser();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.Parser#getExternal <em>External</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>External</em>'.
   * @see at.jku.weiner.c.parser.parser.Parser#getExternal()
   * @see #getParser()
   * @generated
   */
  EReference getParser_External();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.StructOrUnionSpecifier <em>Struct Or Union Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Struct Or Union Specifier</em>'.
   * @see at.jku.weiner.c.parser.parser.StructOrUnionSpecifier
   * @generated
   */
  EClass getStructOrUnionSpecifier();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.StructOrUnionSpecifier#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see at.jku.weiner.c.parser.parser.StructOrUnionSpecifier#getType()
   * @see #getStructOrUnionSpecifier()
   * @generated
   */
  EReference getStructOrUnionSpecifier_Type();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.StructOrUnionSpecifier#getStructDeclList <em>Struct Decl List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Struct Decl List</em>'.
   * @see at.jku.weiner.c.parser.parser.StructOrUnionSpecifier#getStructDeclList()
   * @see #getStructOrUnionSpecifier()
   * @generated
   */
  EReference getStructOrUnionSpecifier_StructDeclList();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.EnumSpecifier <em>Enum Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Specifier</em>'.
   * @see at.jku.weiner.c.parser.parser.EnumSpecifier
   * @generated
   */
  EClass getEnumSpecifier();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.EnumSpecifier#getEnumList <em>Enum List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Enum List</em>'.
   * @see at.jku.weiner.c.parser.parser.EnumSpecifier#getEnumList()
   * @see #getEnumSpecifier()
   * @generated
   */
  EReference getEnumSpecifier_EnumList();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.LabeledStatement <em>Labeled Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Labeled Statement</em>'.
   * @see at.jku.weiner.c.parser.parser.LabeledStatement
   * @generated
   */
  EClass getLabeledStatement();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.LabeledStatement#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.c.parser.parser.LabeledStatement#getId()
   * @see #getLabeledStatement()
   * @generated
   */
  EAttribute getLabeledStatement_Id();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.LabeledStatement#getLStmt <em>LStmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>LStmt</em>'.
   * @see at.jku.weiner.c.parser.parser.LabeledStatement#getLStmt()
   * @see #getLabeledStatement()
   * @generated
   */
  EReference getLabeledStatement_LStmt();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.LabeledStatement#getCase <em>Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Case</em>'.
   * @see at.jku.weiner.c.parser.parser.LabeledStatement#getCase()
   * @see #getLabeledStatement()
   * @generated
   */
  EAttribute getLabeledStatement_Case();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.LabeledStatement#getLower <em>Lower</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lower</em>'.
   * @see at.jku.weiner.c.parser.parser.LabeledStatement#getLower()
   * @see #getLabeledStatement()
   * @generated
   */
  EAttribute getLabeledStatement_Lower();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.LabeledStatement#getHigher <em>Higher</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Higher</em>'.
   * @see at.jku.weiner.c.parser.parser.LabeledStatement#getHigher()
   * @see #getLabeledStatement()
   * @generated
   */
  EAttribute getLabeledStatement_Higher();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.LabeledStatement#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.LabeledStatement#getExpr()
   * @see #getLabeledStatement()
   * @generated
   */
  EReference getLabeledStatement_Expr();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.LabeledStatement#isMydefault <em>Mydefault</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Mydefault</em>'.
   * @see at.jku.weiner.c.parser.parser.LabeledStatement#isMydefault()
   * @see #getLabeledStatement()
   * @generated
   */
  EAttribute getLabeledStatement_Mydefault();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.CompoundStatement <em>Compound Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Compound Statement</em>'.
   * @see at.jku.weiner.c.parser.parser.CompoundStatement
   * @generated
   */
  EClass getCompoundStatement();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.CompoundStatement#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see at.jku.weiner.c.parser.parser.CompoundStatement#getBody()
   * @see #getCompoundStatement()
   * @generated
   */
  EReference getCompoundStatement_Body();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.BodyStatement <em>Body Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Body Statement</em>'.
   * @see at.jku.weiner.c.parser.parser.BodyStatement
   * @generated
   */
  EClass getBodyStatement();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.BodyStatement#getBlockList <em>Block List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Block List</em>'.
   * @see at.jku.weiner.c.parser.parser.BodyStatement#getBlockList()
   * @see #getBodyStatement()
   * @generated
   */
  EReference getBodyStatement_BlockList();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.ExpressionStatement <em>Expression Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Statement</em>'.
   * @see at.jku.weiner.c.parser.parser.ExpressionStatement
   * @generated
   */
  EClass getExpressionStatement();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.ExpressionStatement#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see at.jku.weiner.c.parser.parser.ExpressionStatement#getExpression()
   * @see #getExpressionStatement()
   * @generated
   */
  EReference getExpressionStatement_Expression();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.ExpressionStatement#getSemi <em>Semi</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Semi</em>'.
   * @see at.jku.weiner.c.parser.parser.ExpressionStatement#getSemi()
   * @see #getExpressionStatement()
   * @generated
   */
  EAttribute getExpressionStatement_Semi();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.SelectionStatement <em>Selection Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Selection Statement</em>'.
   * @see at.jku.weiner.c.parser.parser.SelectionStatement
   * @generated
   */
  EClass getSelectionStatement();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.SelectionStatement#getIf <em>If</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>If</em>'.
   * @see at.jku.weiner.c.parser.parser.SelectionStatement#getIf()
   * @see #getSelectionStatement()
   * @generated
   */
  EAttribute getSelectionStatement_If();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.SelectionStatement#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.SelectionStatement#getExpr()
   * @see #getSelectionStatement()
   * @generated
   */
  EReference getSelectionStatement_Expr();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.SelectionStatement#getIfStatement <em>If Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>If Statement</em>'.
   * @see at.jku.weiner.c.parser.parser.SelectionStatement#getIfStatement()
   * @see #getSelectionStatement()
   * @generated
   */
  EReference getSelectionStatement_IfStatement();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.SelectionStatement#getElse <em>Else</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Else</em>'.
   * @see at.jku.weiner.c.parser.parser.SelectionStatement#getElse()
   * @see #getSelectionStatement()
   * @generated
   */
  EAttribute getSelectionStatement_Else();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.SelectionStatement#getElseStatement <em>Else Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else Statement</em>'.
   * @see at.jku.weiner.c.parser.parser.SelectionStatement#getElseStatement()
   * @see #getSelectionStatement()
   * @generated
   */
  EReference getSelectionStatement_ElseStatement();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.SelectionStatement#getSwitch <em>Switch</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Switch</em>'.
   * @see at.jku.weiner.c.parser.parser.SelectionStatement#getSwitch()
   * @see #getSelectionStatement()
   * @generated
   */
  EAttribute getSelectionStatement_Switch();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.SelectionStatement#getSwitchStatement <em>Switch Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Switch Statement</em>'.
   * @see at.jku.weiner.c.parser.parser.SelectionStatement#getSwitchStatement()
   * @see #getSelectionStatement()
   * @generated
   */
  EReference getSelectionStatement_SwitchStatement();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.IterationStatement <em>Iteration Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Iteration Statement</em>'.
   * @see at.jku.weiner.c.parser.parser.IterationStatement
   * @generated
   */
  EClass getIterationStatement();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.IterationStatement#getWhile <em>While</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>While</em>'.
   * @see at.jku.weiner.c.parser.parser.IterationStatement#getWhile()
   * @see #getIterationStatement()
   * @generated
   */
  EAttribute getIterationStatement_While();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.IterationStatement#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.IterationStatement#getExpr()
   * @see #getIterationStatement()
   * @generated
   */
  EReference getIterationStatement_Expr();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.IterationStatement#getStatement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Statement</em>'.
   * @see at.jku.weiner.c.parser.parser.IterationStatement#getStatement()
   * @see #getIterationStatement()
   * @generated
   */
  EReference getIterationStatement_Statement();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.IterationStatement#getDo <em>Do</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Do</em>'.
   * @see at.jku.weiner.c.parser.parser.IterationStatement#getDo()
   * @see #getIterationStatement()
   * @generated
   */
  EAttribute getIterationStatement_Do();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.IterationStatement#getSemi <em>Semi</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Semi</em>'.
   * @see at.jku.weiner.c.parser.parser.IterationStatement#getSemi()
   * @see #getIterationStatement()
   * @generated
   */
  EAttribute getIterationStatement_Semi();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.IterationStatement#getFor <em>For</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>For</em>'.
   * @see at.jku.weiner.c.parser.parser.IterationStatement#getFor()
   * @see #getIterationStatement()
   * @generated
   */
  EAttribute getIterationStatement_For();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.IterationStatement#getInitExpr <em>Init Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Init Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.IterationStatement#getInitExpr()
   * @see #getIterationStatement()
   * @generated
   */
  EReference getIterationStatement_InitExpr();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.IterationStatement#getIncExpr <em>Inc Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Inc Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.IterationStatement#getIncExpr()
   * @see #getIterationStatement()
   * @generated
   */
  EReference getIterationStatement_IncExpr();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.IterationStatement#getInitDecl <em>Init Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Init Decl</em>'.
   * @see at.jku.weiner.c.parser.parser.IterationStatement#getInitDecl()
   * @see #getIterationStatement()
   * @generated
   */
  EReference getIterationStatement_InitDecl();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.JumpStatement <em>Jump Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Jump Statement</em>'.
   * @see at.jku.weiner.c.parser.parser.JumpStatement
   * @generated
   */
  EClass getJumpStatement();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.JumpStatement#getContinue <em>Continue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Continue</em>'.
   * @see at.jku.weiner.c.parser.parser.JumpStatement#getContinue()
   * @see #getJumpStatement()
   * @generated
   */
  EAttribute getJumpStatement_Continue();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.JumpStatement#getSemi <em>Semi</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Semi</em>'.
   * @see at.jku.weiner.c.parser.parser.JumpStatement#getSemi()
   * @see #getJumpStatement()
   * @generated
   */
  EAttribute getJumpStatement_Semi();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.JumpStatement#getBreak <em>Break</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Break</em>'.
   * @see at.jku.weiner.c.parser.parser.JumpStatement#getBreak()
   * @see #getJumpStatement()
   * @generated
   */
  EAttribute getJumpStatement_Break();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.JumpStatement#getReturn <em>Return</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Return</em>'.
   * @see at.jku.weiner.c.parser.parser.JumpStatement#getReturn()
   * @see #getJumpStatement()
   * @generated
   */
  EAttribute getJumpStatement_Return();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.JumpStatement#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.JumpStatement#getExpr()
   * @see #getJumpStatement()
   * @generated
   */
  EReference getJumpStatement_Expr();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.JumpStatement#getGoto <em>Goto</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Goto</em>'.
   * @see at.jku.weiner.c.parser.parser.JumpStatement#getGoto()
   * @see #getJumpStatement()
   * @generated
   */
  EAttribute getJumpStatement_Goto();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.AsmStatement <em>Asm Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Asm Statement</em>'.
   * @see at.jku.weiner.c.parser.parser.AsmStatement
   * @generated
   */
  EClass getAsmStatement();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.AsmStatement#getAsm <em>Asm</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Asm</em>'.
   * @see at.jku.weiner.c.parser.parser.AsmStatement#getAsm()
   * @see #getAsmStatement()
   * @generated
   */
  EAttribute getAsmStatement_Asm();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.AsmStatement#getVolatile <em>Volatile</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Volatile</em>'.
   * @see at.jku.weiner.c.parser.parser.AsmStatement#getVolatile()
   * @see #getAsmStatement()
   * @generated
   */
  EAttribute getAsmStatement_Volatile();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.AsmStatement#getAsmLine1 <em>Asm Line1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Asm Line1</em>'.
   * @see at.jku.weiner.c.parser.parser.AsmStatement#getAsmLine1()
   * @see #getAsmStatement()
   * @generated
   */
  EReference getAsmStatement_AsmLine1();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.AsmStatement#getAsmLines <em>Asm Lines</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Asm Lines</em>'.
   * @see at.jku.weiner.c.parser.parser.AsmStatement#getAsmLines()
   * @see #getAsmStatement()
   * @generated
   */
  EReference getAsmStatement_AsmLines();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.AsmStatement#getSemi <em>Semi</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Semi</em>'.
   * @see at.jku.weiner.c.parser.parser.AsmStatement#getSemi()
   * @see #getAsmStatement()
   * @generated
   */
  EAttribute getAsmStatement_Semi();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.AssignmentExpression <em>Assignment Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment Expression</em>'.
   * @see at.jku.weiner.c.parser.parser.AssignmentExpression
   * @generated
   */
  EClass getAssignmentExpression();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.AssignmentExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.AssignmentExpression#getExpr()
   * @see #getAssignmentExpression()
   * @generated
   */
  EReference getAssignmentExpression_Expr();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.AssignmentExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op</em>'.
   * @see at.jku.weiner.c.parser.parser.AssignmentExpression#getOp()
   * @see #getAssignmentExpression()
   * @generated
   */
  EReference getAssignmentExpression_Op();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.AssignmentExpression#getAssignmentExpr <em>Assignment Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Assignment Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.AssignmentExpression#getAssignmentExpr()
   * @see #getAssignmentExpression()
   * @generated
   */
  EReference getAssignmentExpression_AssignmentExpr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.ConditionalExpression <em>Conditional Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Conditional Expression</em>'.
   * @see at.jku.weiner.c.parser.parser.ConditionalExpression
   * @generated
   */
  EClass getConditionalExpression();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.ConditionalExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.ConditionalExpression#getExpr()
   * @see #getConditionalExpression()
   * @generated
   */
  EReference getConditionalExpression_Expr();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.ConditionalExpression#getQExpr <em>QExpr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>QExpr</em>'.
   * @see at.jku.weiner.c.parser.parser.ConditionalExpression#getQExpr()
   * @see #getConditionalExpression()
   * @generated
   */
  EReference getConditionalExpression_QExpr();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.ConditionalExpression#getCExpr <em>CExpr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>CExpr</em>'.
   * @see at.jku.weiner.c.parser.parser.ConditionalExpression#getCExpr()
   * @see #getConditionalExpression()
   * @generated
   */
  EReference getConditionalExpression_CExpr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.LogicalOrExpression <em>Logical Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical Or Expression</em>'.
   * @see at.jku.weiner.c.parser.parser.LogicalOrExpression
   * @generated
   */
  EClass getLogicalOrExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.LogicalOrExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.LogicalOrExpression#getExpr()
   * @see #getLogicalOrExpression()
   * @generated
   */
  EReference getLogicalOrExpression_Expr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.LogicalAndExpression <em>Logical And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical And Expression</em>'.
   * @see at.jku.weiner.c.parser.parser.LogicalAndExpression
   * @generated
   */
  EClass getLogicalAndExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.LogicalAndExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.LogicalAndExpression#getExpr()
   * @see #getLogicalAndExpression()
   * @generated
   */
  EReference getLogicalAndExpression_Expr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.InclusiveOrExpression <em>Inclusive Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Inclusive Or Expression</em>'.
   * @see at.jku.weiner.c.parser.parser.InclusiveOrExpression
   * @generated
   */
  EClass getInclusiveOrExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.InclusiveOrExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.InclusiveOrExpression#getExpr()
   * @see #getInclusiveOrExpression()
   * @generated
   */
  EReference getInclusiveOrExpression_Expr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.ExclusiveOrExpression <em>Exclusive Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exclusive Or Expression</em>'.
   * @see at.jku.weiner.c.parser.parser.ExclusiveOrExpression
   * @generated
   */
  EClass getExclusiveOrExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.ExclusiveOrExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.ExclusiveOrExpression#getExpr()
   * @see #getExclusiveOrExpression()
   * @generated
   */
  EReference getExclusiveOrExpression_Expr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.AndExpression <em>And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Expression</em>'.
   * @see at.jku.weiner.c.parser.parser.AndExpression
   * @generated
   */
  EClass getAndExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.AndExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.AndExpression#getExpr()
   * @see #getAndExpression()
   * @generated
   */
  EReference getAndExpression_Expr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.EqualityExpression <em>Equality Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equality Expression</em>'.
   * @see at.jku.weiner.c.parser.parser.EqualityExpression
   * @generated
   */
  EClass getEqualityExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.EqualityExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.EqualityExpression#getExpr()
   * @see #getEqualityExpression()
   * @generated
   */
  EReference getEqualityExpression_Expr();

  /**
   * Returns the meta object for the attribute list '{@link at.jku.weiner.c.parser.parser.EqualityExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see at.jku.weiner.c.parser.parser.EqualityExpression#getOp()
   * @see #getEqualityExpression()
   * @generated
   */
  EAttribute getEqualityExpression_Op();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.RelationalExpression <em>Relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relational Expression</em>'.
   * @see at.jku.weiner.c.parser.parser.RelationalExpression
   * @generated
   */
  EClass getRelationalExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.RelationalExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.RelationalExpression#getExpr()
   * @see #getRelationalExpression()
   * @generated
   */
  EReference getRelationalExpression_Expr();

  /**
   * Returns the meta object for the attribute list '{@link at.jku.weiner.c.parser.parser.RelationalExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see at.jku.weiner.c.parser.parser.RelationalExpression#getOp()
   * @see #getRelationalExpression()
   * @generated
   */
  EAttribute getRelationalExpression_Op();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.ShiftExpression <em>Shift Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Shift Expression</em>'.
   * @see at.jku.weiner.c.parser.parser.ShiftExpression
   * @generated
   */
  EClass getShiftExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.ShiftExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.ShiftExpression#getExpr()
   * @see #getShiftExpression()
   * @generated
   */
  EReference getShiftExpression_Expr();

  /**
   * Returns the meta object for the attribute list '{@link at.jku.weiner.c.parser.parser.ShiftExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see at.jku.weiner.c.parser.parser.ShiftExpression#getOp()
   * @see #getShiftExpression()
   * @generated
   */
  EAttribute getShiftExpression_Op();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.AdditiveExpression <em>Additive Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Additive Expression</em>'.
   * @see at.jku.weiner.c.parser.parser.AdditiveExpression
   * @generated
   */
  EClass getAdditiveExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.AdditiveExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.AdditiveExpression#getExpr()
   * @see #getAdditiveExpression()
   * @generated
   */
  EReference getAdditiveExpression_Expr();

  /**
   * Returns the meta object for the attribute list '{@link at.jku.weiner.c.parser.parser.AdditiveExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see at.jku.weiner.c.parser.parser.AdditiveExpression#getOp()
   * @see #getAdditiveExpression()
   * @generated
   */
  EAttribute getAdditiveExpression_Op();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.MultiplicativeExpression <em>Multiplicative Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicative Expression</em>'.
   * @see at.jku.weiner.c.parser.parser.MultiplicativeExpression
   * @generated
   */
  EClass getMultiplicativeExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.MultiplicativeExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.MultiplicativeExpression#getExpr()
   * @see #getMultiplicativeExpression()
   * @generated
   */
  EReference getMultiplicativeExpression_Expr();

  /**
   * Returns the meta object for the attribute list '{@link at.jku.weiner.c.parser.parser.MultiplicativeExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see at.jku.weiner.c.parser.parser.MultiplicativeExpression#getOp()
   * @see #getMultiplicativeExpression()
   * @generated
   */
  EAttribute getMultiplicativeExpression_Op();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.CastExpression <em>Cast Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cast Expression</em>'.
   * @see at.jku.weiner.c.parser.parser.CastExpression
   * @generated
   */
  EClass getCastExpression();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.CastExpression#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see at.jku.weiner.c.parser.parser.CastExpression#getType()
   * @see #getCastExpression()
   * @generated
   */
  EReference getCastExpression_Type();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.CastExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.CastExpression#getExpr()
   * @see #getCastExpression()
   * @generated
   */
  EReference getCastExpression_Expr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.UnaryExpression <em>Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Expression</em>'.
   * @see at.jku.weiner.c.parser.parser.UnaryExpression
   * @generated
   */
  EClass getUnaryExpression();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.UnaryExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.UnaryExpression#getExpr()
   * @see #getUnaryExpression()
   * @generated
   */
  EReference getUnaryExpression_Expr();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.UnaryExpression#getPlusplus <em>Plusplus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Plusplus</em>'.
   * @see at.jku.weiner.c.parser.parser.UnaryExpression#getPlusplus()
   * @see #getUnaryExpression()
   * @generated
   */
  EAttribute getUnaryExpression_Plusplus();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.UnaryExpression#getMinusminus <em>Minusminus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Minusminus</em>'.
   * @see at.jku.weiner.c.parser.parser.UnaryExpression#getMinusminus()
   * @see #getUnaryExpression()
   * @generated
   */
  EAttribute getUnaryExpression_Minusminus();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.UnaryExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op</em>'.
   * @see at.jku.weiner.c.parser.parser.UnaryExpression#getOp()
   * @see #getUnaryExpression()
   * @generated
   */
  EReference getUnaryExpression_Op();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.UnaryExpression#getSizeOf <em>Size Of</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Size Of</em>'.
   * @see at.jku.weiner.c.parser.parser.UnaryExpression#getSizeOf()
   * @see #getUnaryExpression()
   * @generated
   */
  EAttribute getUnaryExpression_SizeOf();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.UnaryExpression#getTypeName <em>Type Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type Name</em>'.
   * @see at.jku.weiner.c.parser.parser.UnaryExpression#getTypeName()
   * @see #getUnaryExpression()
   * @generated
   */
  EReference getUnaryExpression_TypeName();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.UnaryExpression#getAlignOf <em>Align Of</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Align Of</em>'.
   * @see at.jku.weiner.c.parser.parser.UnaryExpression#getAlignOf()
   * @see #getUnaryExpression()
   * @generated
   */
  EAttribute getUnaryExpression_AlignOf();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.UnaryExpression#getAndand <em>Andand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Andand</em>'.
   * @see at.jku.weiner.c.parser.parser.UnaryExpression#getAndand()
   * @see #getUnaryExpression()
   * @generated
   */
  EAttribute getUnaryExpression_Andand();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.UnaryExpression#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.c.parser.parser.UnaryExpression#getId()
   * @see #getUnaryExpression()
   * @generated
   */
  EAttribute getUnaryExpression_Id();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.PostfixExpression <em>Postfix Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Postfix Expression</em>'.
   * @see at.jku.weiner.c.parser.parser.PostfixExpression
   * @generated
   */
  EClass getPostfixExpression();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.PostfixExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.PostfixExpression#getExpr()
   * @see #getPostfixExpression()
   * @generated
   */
  EReference getPostfixExpression_Expr();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.c.parser.parser.PostfixExpression#getSuffix <em>Suffix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Suffix</em>'.
   * @see at.jku.weiner.c.parser.parser.PostfixExpression#getSuffix()
   * @see #getPostfixExpression()
   * @generated
   */
  EReference getPostfixExpression_Suffix();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArray <em>Postfix Expression Suffix Array</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Postfix Expression Suffix Array</em>'.
   * @see at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArray
   * @generated
   */
  EClass getPostfixExpressionSuffixArray();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArray#getArrayExpr <em>Array Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Array Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArray#getArrayExpr()
   * @see #getPostfixExpressionSuffixArray()
   * @generated
   */
  EReference getPostfixExpressionSuffixArray_ArrayExpr();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument <em>Postfix Expression Suffix Argument</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Postfix Expression Suffix Argument</em>'.
   * @see at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument
   * @generated
   */
  EClass getPostfixExpressionSuffixArgument();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument#getArgumentExpressionList <em>Argument Expression List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Argument Expression List</em>'.
   * @see at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArgument#getArgumentExpressionList()
   * @see #getPostfixExpressionSuffixArgument()
   * @generated
   */
  EReference getPostfixExpressionSuffixArgument_ArgumentExpressionList();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.PostfixExpressionSuffixDot <em>Postfix Expression Suffix Dot</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Postfix Expression Suffix Dot</em>'.
   * @see at.jku.weiner.c.parser.parser.PostfixExpressionSuffixDot
   * @generated
   */
  EClass getPostfixExpressionSuffixDot();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.PostfixExpressionSuffixDot#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.c.parser.parser.PostfixExpressionSuffixDot#getId()
   * @see #getPostfixExpressionSuffixDot()
   * @generated
   */
  EAttribute getPostfixExpressionSuffixDot_Id();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArrow <em>Postfix Expression Suffix Arrow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Postfix Expression Suffix Arrow</em>'.
   * @see at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArrow
   * @generated
   */
  EClass getPostfixExpressionSuffixArrow();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArrow#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.c.parser.parser.PostfixExpressionSuffixArrow#getId()
   * @see #getPostfixExpressionSuffixArrow()
   * @generated
   */
  EAttribute getPostfixExpressionSuffixArrow_Id();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.PostfixExpressionSuffixPlusPlus <em>Postfix Expression Suffix Plus Plus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Postfix Expression Suffix Plus Plus</em>'.
   * @see at.jku.weiner.c.parser.parser.PostfixExpressionSuffixPlusPlus
   * @generated
   */
  EClass getPostfixExpressionSuffixPlusPlus();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.PostfixExpressionSuffixMinusMinus <em>Postfix Expression Suffix Minus Minus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Postfix Expression Suffix Minus Minus</em>'.
   * @see at.jku.weiner.c.parser.parser.PostfixExpressionSuffixMinusMinus
   * @generated
   */
  EClass getPostfixExpressionSuffixMinusMinus();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.PrimaryExpression <em>Primary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primary Expression</em>'.
   * @see at.jku.weiner.c.parser.parser.PrimaryExpression
   * @generated
   */
  EClass getPrimaryExpression();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.PrimaryExpression#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see at.jku.weiner.c.parser.parser.PrimaryExpression#getId()
   * @see #getPrimaryExpression()
   * @generated
   */
  EAttribute getPrimaryExpression_Id();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.PrimaryExpression#getConst <em>Const</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Const</em>'.
   * @see at.jku.weiner.c.parser.parser.PrimaryExpression#getConst()
   * @see #getPrimaryExpression()
   * @generated
   */
  EReference getPrimaryExpression_Const();

  /**
   * Returns the meta object for the attribute list '{@link at.jku.weiner.c.parser.parser.PrimaryExpression#getString <em>String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>String</em>'.
   * @see at.jku.weiner.c.parser.parser.PrimaryExpression#getString()
   * @see #getPrimaryExpression()
   * @generated
   */
  EAttribute getPrimaryExpression_String();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.PrimaryExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.PrimaryExpression#getExpr()
   * @see #getPrimaryExpression()
   * @generated
   */
  EReference getPrimaryExpression_Expr();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.PrimaryExpression#isExt <em>Ext</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ext</em>'.
   * @see at.jku.weiner.c.parser.parser.PrimaryExpression#isExt()
   * @see #getPrimaryExpression()
   * @generated
   */
  EAttribute getPrimaryExpression_Ext();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.PrimaryExpression#getCompoundStmt <em>Compound Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Compound Stmt</em>'.
   * @see at.jku.weiner.c.parser.parser.PrimaryExpression#getCompoundStmt()
   * @see #getPrimaryExpression()
   * @generated
   */
  EReference getPrimaryExpression_CompoundStmt();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.c.parser.parser.PrimaryExpression#isBuiltin_offsetof <em>Builtin offsetof</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Builtin offsetof</em>'.
   * @see at.jku.weiner.c.parser.parser.PrimaryExpression#isBuiltin_offsetof()
   * @see #getPrimaryExpression()
   * @generated
   */
  EAttribute getPrimaryExpression_Builtin_offsetof();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.PrimaryExpression#getTypeName <em>Type Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type Name</em>'.
   * @see at.jku.weiner.c.parser.parser.PrimaryExpression#getTypeName()
   * @see #getPrimaryExpression()
   * @generated
   */
  EReference getPrimaryExpression_TypeName();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.c.parser.parser.ConstantExpression <em>Constant Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant Expression</em>'.
   * @see at.jku.weiner.c.parser.parser.ConstantExpression
   * @generated
   */
  EClass getConstantExpression();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.c.parser.parser.ConstantExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see at.jku.weiner.c.parser.parser.ConstantExpression#getExpr()
   * @see #getConstantExpression()
   * @generated
   */
  EReference getConstantExpression_Expr();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ParserFactory getParserFactory();

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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.ExternalDeclarationImpl <em>External Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.ExternalDeclarationImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getExternalDeclaration()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.FunctionDefHeadImpl <em>Function Def Head</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.FunctionDefHeadImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getFunctionDefHead()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.FunctionDefinitionImpl <em>Function Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.FunctionDefinitionImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getFunctionDefinition()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.DeclarationImpl <em>Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.DeclarationImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getDeclaration()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.FunctionDeclarationSpecifiersImpl <em>Function Declaration Specifiers</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.FunctionDeclarationSpecifiersImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getFunctionDeclarationSpecifiers()
     * @generated
     */
    EClass FUNCTION_DECLARATION_SPECIFIERS = eINSTANCE.getFunctionDeclarationSpecifiers();

    /**
     * The meta object literal for the '<em><b>Declaration Specifier</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_DECLARATION_SPECIFIERS__DECLARATION_SPECIFIER = eINSTANCE.getFunctionDeclarationSpecifiers_DeclarationSpecifier();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.DeclarationSpecifiersImpl <em>Declaration Specifiers</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.DeclarationSpecifiersImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getDeclarationSpecifiers()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.InitDeclaratorListImpl <em>Init Declarator List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.InitDeclaratorListImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getInitDeclaratorList()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.InitDeclaratorImpl <em>Init Declarator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.InitDeclaratorImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getInitDeclarator()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.StorageClassSpecifierImpl <em>Storage Class Specifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.StorageClassSpecifierImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getStorageClassSpecifier()
     * @generated
     */
    EClass STORAGE_CLASS_SPECIFIER = eINSTANCE.getStorageClassSpecifier();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STORAGE_CLASS_SPECIFIER__NAME = eINSTANCE.getStorageClassSpecifier_Name();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl <em>Type Specifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.TypeSpecifierImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getTypeSpecifier()
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
     * The meta object literal for the '<em><b>Ext Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_SPECIFIER__EXT_TYPE = eINSTANCE.getTypeSpecifier_ExtType();

    /**
     * The meta object literal for the '<em><b>Specifier</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_SPECIFIER__SPECIFIER = eINSTANCE.getTypeSpecifier_Specifier();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_SPECIFIER__TYPE = eINSTANCE.getTypeSpecifier_Type();

    /**
     * The meta object literal for the '<em><b>Struct</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_SPECIFIER__STRUCT = eINSTANCE.getTypeSpecifier_Struct();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.TypedefNameImpl <em>Typedef Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.TypedefNameImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getTypedefName()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.StructOrUnionNameImpl <em>Struct Or Union Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.StructOrUnionNameImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getStructOrUnionName()
     * @generated
     */
    EClass STRUCT_OR_UNION_NAME = eINSTANCE.getStructOrUnionName();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRUCT_OR_UNION_NAME__ID = eINSTANCE.getStructOrUnionName_Id();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.DeclarationSpecifierImpl <em>Declaration Specifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.DeclarationSpecifierImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getDeclarationSpecifier()
     * @generated
     */
    EClass DECLARATION_SPECIFIER = eINSTANCE.getDeclarationSpecifier();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECLARATION_SPECIFIER__ID = eINSTANCE.getDeclarationSpecifier_Id();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.StructOrUnionImpl <em>Struct Or Union</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.StructOrUnionImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getStructOrUnion()
     * @generated
     */
    EClass STRUCT_OR_UNION = eINSTANCE.getStructOrUnion();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRUCT_OR_UNION__NAME = eINSTANCE.getStructOrUnion_Name();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.StructDeclarationListImpl <em>Struct Declaration List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.StructDeclarationListImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getStructDeclarationList()
     * @generated
     */
    EClass STRUCT_DECLARATION_LIST = eINSTANCE.getStructDeclarationList();

    /**
     * The meta object literal for the '<em><b>Struct Declaration</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRUCT_DECLARATION_LIST__STRUCT_DECLARATION = eINSTANCE.getStructDeclarationList_StructDeclaration();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.StructDeclarationImpl <em>Struct Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.StructDeclarationImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getStructDeclaration()
     * @generated
     */
    EClass STRUCT_DECLARATION = eINSTANCE.getStructDeclaration();

    /**
     * The meta object literal for the '<em><b>List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRUCT_DECLARATION__LIST = eINSTANCE.getStructDeclaration_List();

    /**
     * The meta object literal for the '<em><b>Struct Declaration List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRUCT_DECLARATION__STRUCT_DECLARATION_LIST = eINSTANCE.getStructDeclaration_StructDeclarationList();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.SpecifierQualifierListImpl <em>Specifier Qualifier List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.SpecifierQualifierListImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getSpecifierQualifierList()
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
     * The meta object literal for the '<em><b>Struct Or Union Specifier</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFIER_QUALIFIER_LIST__STRUCT_OR_UNION_SPECIFIER = eINSTANCE.getSpecifierQualifierList_StructOrUnionSpecifier();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.StructDeclaratorListImpl <em>Struct Declarator List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.StructDeclaratorListImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getStructDeclaratorList()
     * @generated
     */
    EClass STRUCT_DECLARATOR_LIST = eINSTANCE.getStructDeclaratorList();

    /**
     * The meta object literal for the '<em><b>Struct Declarator</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRUCT_DECLARATOR_LIST__STRUCT_DECLARATOR = eINSTANCE.getStructDeclaratorList_StructDeclarator();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.StructDeclaratorImpl <em>Struct Declarator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.StructDeclaratorImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getStructDeclarator()
     * @generated
     */
    EClass STRUCT_DECLARATOR = eINSTANCE.getStructDeclarator();

    /**
     * The meta object literal for the '<em><b>Declarator</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRUCT_DECLARATOR__DECLARATOR = eINSTANCE.getStructDeclarator_Declarator();

    /**
     * The meta object literal for the '<em><b>Const Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRUCT_DECLARATOR__CONST_EXPR = eINSTANCE.getStructDeclarator_ConstExpr();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.EnumeratorListImpl <em>Enumerator List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.EnumeratorListImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getEnumeratorList()
     * @generated
     */
    EClass ENUMERATOR_LIST = eINSTANCE.getEnumeratorList();

    /**
     * The meta object literal for the '<em><b>Enumerator</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUMERATOR_LIST__ENUMERATOR = eINSTANCE.getEnumeratorList_Enumerator();

    /**
     * The meta object literal for the '<em><b>Last Comma</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUMERATOR_LIST__LAST_COMMA = eINSTANCE.getEnumeratorList_LastComma();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.EnumeratorImpl <em>Enumerator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.EnumeratorImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getEnumerator()
     * @generated
     */
    EClass ENUMERATOR = eINSTANCE.getEnumerator();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUMERATOR__ID = eINSTANCE.getEnumerator_Id();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUMERATOR__EXPR = eINSTANCE.getEnumerator_Expr();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.TypeQualifierImpl <em>Type Qualifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.TypeQualifierImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getTypeQualifier()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.FunctionSpecifierImpl <em>Function Specifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.FunctionSpecifierImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getFunctionSpecifier()
     * @generated
     */
    EClass FUNCTION_SPECIFIER = eINSTANCE.getFunctionSpecifier();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION_SPECIFIER__NAME = eINSTANCE.getFunctionSpecifier_Name();

    /**
     * The meta object literal for the '<em><b>Gcc Attribute Specifier</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_SPECIFIER__GCC_ATTRIBUTE_SPECIFIER = eINSTANCE.getFunctionSpecifier_GccAttributeSpecifier();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.DeclaratorImpl <em>Declarator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.DeclaratorImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getDeclarator()
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
     * The meta object literal for the '<em><b>Gcc Decl Ext1</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATOR__GCC_DECL_EXT1 = eINSTANCE.getDeclarator_GccDeclExt1();

    /**
     * The meta object literal for the '<em><b>Declarator</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATOR__DECLARATOR = eINSTANCE.getDeclarator_Declarator();

    /**
     * The meta object literal for the '<em><b>Gcc Decl Ext2</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATOR__GCC_DECL_EXT2 = eINSTANCE.getDeclarator_GccDeclExt2();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.DirectDeclaratorImpl <em>Direct Declarator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.DirectDeclaratorImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getDirectDeclarator()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.DeclaratorSuffixImpl <em>Declarator Suffix</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.DeclaratorSuffixImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getDeclaratorSuffix()
     * @generated
     */
    EClass DECLARATOR_SUFFIX = eINSTANCE.getDeclaratorSuffix();

    /**
     * The meta object literal for the '<em><b>Type Qualifier List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATOR_SUFFIX__TYPE_QUALIFIER_LIST = eINSTANCE.getDeclaratorSuffix_TypeQualifierList();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATOR_SUFFIX__EXPR = eINSTANCE.getDeclaratorSuffix_Expr();

    /**
     * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECLARATOR_SUFFIX__STATIC = eINSTANCE.getDeclaratorSuffix_Static();

    /**
     * The meta object literal for the '<em><b>Star</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECLARATOR_SUFFIX__STAR = eINSTANCE.getDeclaratorSuffix_Star();

    /**
     * The meta object literal for the '<em><b>Last Suffix</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATOR_SUFFIX__LAST_SUFFIX = eINSTANCE.getDeclaratorSuffix_LastSuffix();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.DirectDeclaratorLastSuffixImpl <em>Direct Declarator Last Suffix</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.DirectDeclaratorLastSuffixImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getDirectDeclaratorLastSuffix()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.GccDeclaratorExtensionImpl <em>Gcc Declarator Extension</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.GccDeclaratorExtensionImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getGccDeclaratorExtension()
     * @generated
     */
    EClass GCC_DECLARATOR_EXTENSION = eINSTANCE.getGccDeclaratorExtension();

    /**
     * The meta object literal for the '<em><b>Asm</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GCC_DECLARATOR_EXTENSION__ASM = eINSTANCE.getGccDeclaratorExtension_Asm();

    /**
     * The meta object literal for the '<em><b>String</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GCC_DECLARATOR_EXTENSION__STRING = eINSTANCE.getGccDeclaratorExtension_String();

    /**
     * The meta object literal for the '<em><b>Gcc Attribute Specifier</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GCC_DECLARATOR_EXTENSION__GCC_ATTRIBUTE_SPECIFIER = eINSTANCE.getGccDeclaratorExtension_GccAttributeSpecifier();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.GccAttributeSpecifierImpl <em>Gcc Attribute Specifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.GccAttributeSpecifierImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getGccAttributeSpecifier()
     * @generated
     */
    EClass GCC_ATTRIBUTE_SPECIFIER = eINSTANCE.getGccAttributeSpecifier();

    /**
     * The meta object literal for the '<em><b>List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GCC_ATTRIBUTE_SPECIFIER__LIST = eINSTANCE.getGccAttributeSpecifier_List();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.GccAttributeListImpl <em>Gcc Attribute List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.GccAttributeListImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getGccAttributeList()
     * @generated
     */
    EClass GCC_ATTRIBUTE_LIST = eINSTANCE.getGccAttributeList();

    /**
     * The meta object literal for the '<em><b>Gcc Attribute</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GCC_ATTRIBUTE_LIST__GCC_ATTRIBUTE = eINSTANCE.getGccAttributeList_GccAttribute();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.GccAttributeImpl <em>Gcc Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.GccAttributeImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getGccAttribute()
     * @generated
     */
    EClass GCC_ATTRIBUTE = eINSTANCE.getGccAttribute();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GCC_ATTRIBUTE__ID = eINSTANCE.getGccAttribute_Id();

    /**
     * The meta object literal for the '<em><b>Const</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GCC_ATTRIBUTE__CONST = eINSTANCE.getGccAttribute_Const();

    /**
     * The meta object literal for the '<em><b>Keyword</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GCC_ATTRIBUTE__KEYWORD = eINSTANCE.getGccAttribute_Keyword();

    /**
     * The meta object literal for the '<em><b>List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GCC_ATTRIBUTE__LIST = eINSTANCE.getGccAttribute_List();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.PointerImpl <em>Pointer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.PointerImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getPointer()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.TypeQualifierListImpl <em>Type Qualifier List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.TypeQualifierListImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getTypeQualifierList()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.ParameterTypeListImpl <em>Parameter Type List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.ParameterTypeListImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getParameterTypeList()
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
     * The meta object literal for the '<em><b>Ellipsis</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER_TYPE_LIST__ELLIPSIS = eINSTANCE.getParameterTypeList_Ellipsis();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.ParameterListImpl <em>Parameter List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.ParameterListImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getParameterList()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.ParameterDeclarationImpl <em>Parameter Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.ParameterDeclarationImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getParameterDeclaration()
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
     * The meta object literal for the '<em><b>Abstract Declator</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER_DECLARATION__ABSTRACT_DECLATOR = eINSTANCE.getParameterDeclaration_AbstractDeclator();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.IdentifierListImpl <em>Identifier List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.IdentifierListImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getIdentifierList()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.MyIdentifierImpl <em>My Identifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.MyIdentifierImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getMyIdentifier()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.TypeNameImpl <em>Type Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.TypeNameImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getTypeName()
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
     * The meta object literal for the '<em><b>Abstract Declarator</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_NAME__ABSTRACT_DECLARATOR = eINSTANCE.getTypeName_AbstractDeclarator();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.AbstractDeclaratorImpl <em>Abstract Declarator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.AbstractDeclaratorImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getAbstractDeclarator()
     * @generated
     */
    EClass ABSTRACT_DECLARATOR = eINSTANCE.getAbstractDeclarator();

    /**
     * The meta object literal for the '<em><b>Pointer</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_DECLARATOR__POINTER = eINSTANCE.getAbstractDeclarator_Pointer();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.InitializerImpl <em>Initializer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.InitializerImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getInitializer()
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
     * The meta object literal for the '<em><b>List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INITIALIZER__LIST = eINSTANCE.getInitializer_List();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.InitializerListImpl <em>Initializer List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.InitializerListImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getInitializerList()
     * @generated
     */
    EClass INITIALIZER_LIST = eINSTANCE.getInitializerList();

    /**
     * The meta object literal for the '<em><b>Initializer</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INITIALIZER_LIST__INITIALIZER = eINSTANCE.getInitializerList_Initializer();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.BlockListImpl <em>Block List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.BlockListImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getBlockList()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.StatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.StatementImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getStatement()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.AsmLineWithoutColonImpl <em>Asm Line Without Colon</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.AsmLineWithoutColonImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getAsmLineWithoutColon()
     * @generated
     */
    EClass ASM_LINE_WITHOUT_COLON = eINSTANCE.getAsmLineWithoutColon();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASM_LINE_WITHOUT_COLON__EXPR = eINSTANCE.getAsmLineWithoutColon_Expr();

    /**
     * The meta object literal for the '<em><b>Asm Lines</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASM_LINE_WITHOUT_COLON__ASM_LINES = eINSTANCE.getAsmLineWithoutColon_AsmLines();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.AsmLineImpl <em>Asm Line</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.AsmLineImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getAsmLine()
     * @generated
     */
    EClass ASM_LINE = eINSTANCE.getAsmLine();

    /**
     * The meta object literal for the '<em><b>Comma</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASM_LINE__COMMA = eINSTANCE.getAsmLine_Comma();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASM_LINE__EXPR = eINSTANCE.getAsmLine_Expr();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.AsmLineWithColonImpl <em>Asm Line With Colon</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.AsmLineWithColonImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getAsmLineWithColon()
     * @generated
     */
    EClass ASM_LINE_WITH_COLON = eINSTANCE.getAsmLineWithColon();

    /**
     * The meta object literal for the '<em><b>Asm Line</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASM_LINE_WITH_COLON__ASM_LINE = eINSTANCE.getAsmLineWithColon_AsmLine();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.ExpressionImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getExpression()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.AssignmentOperatorImpl <em>Assignment Operator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.AssignmentOperatorImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getAssignmentOperator()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.UnaryOperatorImpl <em>Unary Operator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.UnaryOperatorImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getUnaryOperator()
     * @generated
     */
    EClass UNARY_OPERATOR = eINSTANCE.getUnaryOperator();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixImpl <em>Postfix Expression Suffix</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getPostfixExpressionSuffix()
     * @generated
     */
    EClass POSTFIX_EXPRESSION_SUFFIX = eINSTANCE.getPostfixExpressionSuffix();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.ArgumentExpressionListImpl <em>Argument Expression List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.ArgumentExpressionListImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getArgumentExpressionList()
     * @generated
     */
    EClass ARGUMENT_EXPRESSION_LIST = eINSTANCE.getArgumentExpressionList();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.ParserImpl <em>Parser</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.ParserImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getParser()
     * @generated
     */
    EClass PARSER = eINSTANCE.getParser();

    /**
     * The meta object literal for the '<em><b>External</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARSER__EXTERNAL = eINSTANCE.getParser_External();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.StructOrUnionSpecifierImpl <em>Struct Or Union Specifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.StructOrUnionSpecifierImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getStructOrUnionSpecifier()
     * @generated
     */
    EClass STRUCT_OR_UNION_SPECIFIER = eINSTANCE.getStructOrUnionSpecifier();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRUCT_OR_UNION_SPECIFIER__TYPE = eINSTANCE.getStructOrUnionSpecifier_Type();

    /**
     * The meta object literal for the '<em><b>Struct Decl List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRUCT_OR_UNION_SPECIFIER__STRUCT_DECL_LIST = eINSTANCE.getStructOrUnionSpecifier_StructDeclList();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.EnumSpecifierImpl <em>Enum Specifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.EnumSpecifierImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getEnumSpecifier()
     * @generated
     */
    EClass ENUM_SPECIFIER = eINSTANCE.getEnumSpecifier();

    /**
     * The meta object literal for the '<em><b>Enum List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUM_SPECIFIER__ENUM_LIST = eINSTANCE.getEnumSpecifier_EnumList();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.LabeledStatementImpl <em>Labeled Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.LabeledStatementImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getLabeledStatement()
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
     * The meta object literal for the '<em><b>Case</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LABELED_STATEMENT__CASE = eINSTANCE.getLabeledStatement_Case();

    /**
     * The meta object literal for the '<em><b>Lower</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LABELED_STATEMENT__LOWER = eINSTANCE.getLabeledStatement_Lower();

    /**
     * The meta object literal for the '<em><b>Higher</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LABELED_STATEMENT__HIGHER = eINSTANCE.getLabeledStatement_Higher();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LABELED_STATEMENT__EXPR = eINSTANCE.getLabeledStatement_Expr();

    /**
     * The meta object literal for the '<em><b>Mydefault</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LABELED_STATEMENT__MYDEFAULT = eINSTANCE.getLabeledStatement_Mydefault();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.CompoundStatementImpl <em>Compound Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.CompoundStatementImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getCompoundStatement()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.BodyStatementImpl <em>Body Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.BodyStatementImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getBodyStatement()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.ExpressionStatementImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getExpressionStatement()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.SelectionStatementImpl <em>Selection Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.SelectionStatementImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getSelectionStatement()
     * @generated
     */
    EClass SELECTION_STATEMENT = eINSTANCE.getSelectionStatement();

    /**
     * The meta object literal for the '<em><b>If</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SELECTION_STATEMENT__IF = eINSTANCE.getSelectionStatement_If();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SELECTION_STATEMENT__EXPR = eINSTANCE.getSelectionStatement_Expr();

    /**
     * The meta object literal for the '<em><b>If Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SELECTION_STATEMENT__IF_STATEMENT = eINSTANCE.getSelectionStatement_IfStatement();

    /**
     * The meta object literal for the '<em><b>Else</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SELECTION_STATEMENT__ELSE = eINSTANCE.getSelectionStatement_Else();

    /**
     * The meta object literal for the '<em><b>Else Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SELECTION_STATEMENT__ELSE_STATEMENT = eINSTANCE.getSelectionStatement_ElseStatement();

    /**
     * The meta object literal for the '<em><b>Switch</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SELECTION_STATEMENT__SWITCH = eINSTANCE.getSelectionStatement_Switch();

    /**
     * The meta object literal for the '<em><b>Switch Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SELECTION_STATEMENT__SWITCH_STATEMENT = eINSTANCE.getSelectionStatement_SwitchStatement();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.IterationStatementImpl <em>Iteration Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.IterationStatementImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getIterationStatement()
     * @generated
     */
    EClass ITERATION_STATEMENT = eINSTANCE.getIterationStatement();

    /**
     * The meta object literal for the '<em><b>While</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ITERATION_STATEMENT__WHILE = eINSTANCE.getIterationStatement_While();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ITERATION_STATEMENT__EXPR = eINSTANCE.getIterationStatement_Expr();

    /**
     * The meta object literal for the '<em><b>Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ITERATION_STATEMENT__STATEMENT = eINSTANCE.getIterationStatement_Statement();

    /**
     * The meta object literal for the '<em><b>Do</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ITERATION_STATEMENT__DO = eINSTANCE.getIterationStatement_Do();

    /**
     * The meta object literal for the '<em><b>Semi</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ITERATION_STATEMENT__SEMI = eINSTANCE.getIterationStatement_Semi();

    /**
     * The meta object literal for the '<em><b>For</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ITERATION_STATEMENT__FOR = eINSTANCE.getIterationStatement_For();

    /**
     * The meta object literal for the '<em><b>Init Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ITERATION_STATEMENT__INIT_EXPR = eINSTANCE.getIterationStatement_InitExpr();

    /**
     * The meta object literal for the '<em><b>Inc Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ITERATION_STATEMENT__INC_EXPR = eINSTANCE.getIterationStatement_IncExpr();

    /**
     * The meta object literal for the '<em><b>Init Decl</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ITERATION_STATEMENT__INIT_DECL = eINSTANCE.getIterationStatement_InitDecl();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.JumpStatementImpl <em>Jump Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.JumpStatementImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getJumpStatement()
     * @generated
     */
    EClass JUMP_STATEMENT = eINSTANCE.getJumpStatement();

    /**
     * The meta object literal for the '<em><b>Continue</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JUMP_STATEMENT__CONTINUE = eINSTANCE.getJumpStatement_Continue();

    /**
     * The meta object literal for the '<em><b>Semi</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JUMP_STATEMENT__SEMI = eINSTANCE.getJumpStatement_Semi();

    /**
     * The meta object literal for the '<em><b>Break</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JUMP_STATEMENT__BREAK = eINSTANCE.getJumpStatement_Break();

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
     * The meta object literal for the '<em><b>Goto</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JUMP_STATEMENT__GOTO = eINSTANCE.getJumpStatement_Goto();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.AsmStatementImpl <em>Asm Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.AsmStatementImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getAsmStatement()
     * @generated
     */
    EClass ASM_STATEMENT = eINSTANCE.getAsmStatement();

    /**
     * The meta object literal for the '<em><b>Asm</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASM_STATEMENT__ASM = eINSTANCE.getAsmStatement_Asm();

    /**
     * The meta object literal for the '<em><b>Volatile</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASM_STATEMENT__VOLATILE = eINSTANCE.getAsmStatement_Volatile();

    /**
     * The meta object literal for the '<em><b>Asm Line1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASM_STATEMENT__ASM_LINE1 = eINSTANCE.getAsmStatement_AsmLine1();

    /**
     * The meta object literal for the '<em><b>Asm Lines</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASM_STATEMENT__ASM_LINES = eINSTANCE.getAsmStatement_AsmLines();

    /**
     * The meta object literal for the '<em><b>Semi</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASM_STATEMENT__SEMI = eINSTANCE.getAsmStatement_Semi();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.AssignmentExpressionImpl <em>Assignment Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.AssignmentExpressionImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getAssignmentExpression()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.ConditionalExpressionImpl <em>Conditional Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.ConditionalExpressionImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getConditionalExpression()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.LogicalOrExpressionImpl <em>Logical Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.LogicalOrExpressionImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getLogicalOrExpression()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.LogicalAndExpressionImpl <em>Logical And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.LogicalAndExpressionImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getLogicalAndExpression()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.InclusiveOrExpressionImpl <em>Inclusive Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.InclusiveOrExpressionImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getInclusiveOrExpression()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.ExclusiveOrExpressionImpl <em>Exclusive Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.ExclusiveOrExpressionImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getExclusiveOrExpression()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.AndExpressionImpl <em>And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.AndExpressionImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getAndExpression()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.EqualityExpressionImpl <em>Equality Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.EqualityExpressionImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getEqualityExpression()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.RelationalExpressionImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getRelationalExpression()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.ShiftExpressionImpl <em>Shift Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.ShiftExpressionImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getShiftExpression()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.AdditiveExpressionImpl <em>Additive Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.AdditiveExpressionImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getAdditiveExpression()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.MultiplicativeExpressionImpl <em>Multiplicative Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.MultiplicativeExpressionImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getMultiplicativeExpression()
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
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.CastExpressionImpl <em>Cast Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.CastExpressionImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getCastExpression()
     * @generated
     */
    EClass CAST_EXPRESSION = eINSTANCE.getCastExpression();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAST_EXPRESSION__TYPE = eINSTANCE.getCastExpression_Type();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAST_EXPRESSION__EXPR = eINSTANCE.getCastExpression_Expr();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.UnaryExpressionImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getUnaryExpression()
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
     * The meta object literal for the '<em><b>Plusplus</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNARY_EXPRESSION__PLUSPLUS = eINSTANCE.getUnaryExpression_Plusplus();

    /**
     * The meta object literal for the '<em><b>Minusminus</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNARY_EXPRESSION__MINUSMINUS = eINSTANCE.getUnaryExpression_Minusminus();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_EXPRESSION__OP = eINSTANCE.getUnaryExpression_Op();

    /**
     * The meta object literal for the '<em><b>Size Of</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNARY_EXPRESSION__SIZE_OF = eINSTANCE.getUnaryExpression_SizeOf();

    /**
     * The meta object literal for the '<em><b>Type Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_EXPRESSION__TYPE_NAME = eINSTANCE.getUnaryExpression_TypeName();

    /**
     * The meta object literal for the '<em><b>Align Of</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNARY_EXPRESSION__ALIGN_OF = eINSTANCE.getUnaryExpression_AlignOf();

    /**
     * The meta object literal for the '<em><b>Andand</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNARY_EXPRESSION__ANDAND = eINSTANCE.getUnaryExpression_Andand();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNARY_EXPRESSION__ID = eINSTANCE.getUnaryExpression_Id();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionImpl <em>Postfix Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.PostfixExpressionImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getPostfixExpression()
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
     * The meta object literal for the '<em><b>Suffix</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POSTFIX_EXPRESSION__SUFFIX = eINSTANCE.getPostfixExpression_Suffix();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixArrayImpl <em>Postfix Expression Suffix Array</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixArrayImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getPostfixExpressionSuffixArray()
     * @generated
     */
    EClass POSTFIX_EXPRESSION_SUFFIX_ARRAY = eINSTANCE.getPostfixExpressionSuffixArray();

    /**
     * The meta object literal for the '<em><b>Array Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POSTFIX_EXPRESSION_SUFFIX_ARRAY__ARRAY_EXPR = eINSTANCE.getPostfixExpressionSuffixArray_ArrayExpr();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixArgumentImpl <em>Postfix Expression Suffix Argument</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixArgumentImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getPostfixExpressionSuffixArgument()
     * @generated
     */
    EClass POSTFIX_EXPRESSION_SUFFIX_ARGUMENT = eINSTANCE.getPostfixExpressionSuffixArgument();

    /**
     * The meta object literal for the '<em><b>Argument Expression List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POSTFIX_EXPRESSION_SUFFIX_ARGUMENT__ARGUMENT_EXPRESSION_LIST = eINSTANCE.getPostfixExpressionSuffixArgument_ArgumentExpressionList();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixDotImpl <em>Postfix Expression Suffix Dot</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixDotImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getPostfixExpressionSuffixDot()
     * @generated
     */
    EClass POSTFIX_EXPRESSION_SUFFIX_DOT = eINSTANCE.getPostfixExpressionSuffixDot();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute POSTFIX_EXPRESSION_SUFFIX_DOT__ID = eINSTANCE.getPostfixExpressionSuffixDot_Id();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixArrowImpl <em>Postfix Expression Suffix Arrow</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixArrowImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getPostfixExpressionSuffixArrow()
     * @generated
     */
    EClass POSTFIX_EXPRESSION_SUFFIX_ARROW = eINSTANCE.getPostfixExpressionSuffixArrow();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute POSTFIX_EXPRESSION_SUFFIX_ARROW__ID = eINSTANCE.getPostfixExpressionSuffixArrow_Id();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixPlusPlusImpl <em>Postfix Expression Suffix Plus Plus</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixPlusPlusImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getPostfixExpressionSuffixPlusPlus()
     * @generated
     */
    EClass POSTFIX_EXPRESSION_SUFFIX_PLUS_PLUS = eINSTANCE.getPostfixExpressionSuffixPlusPlus();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixMinusMinusImpl <em>Postfix Expression Suffix Minus Minus</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.PostfixExpressionSuffixMinusMinusImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getPostfixExpressionSuffixMinusMinus()
     * @generated
     */
    EClass POSTFIX_EXPRESSION_SUFFIX_MINUS_MINUS = eINSTANCE.getPostfixExpressionSuffixMinusMinus();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl <em>Primary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.PrimaryExpressionImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getPrimaryExpression()
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
     * The meta object literal for the '<em><b>String</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIMARY_EXPRESSION__STRING = eINSTANCE.getPrimaryExpression_String();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_EXPRESSION__EXPR = eINSTANCE.getPrimaryExpression_Expr();

    /**
     * The meta object literal for the '<em><b>Ext</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIMARY_EXPRESSION__EXT = eINSTANCE.getPrimaryExpression_Ext();

    /**
     * The meta object literal for the '<em><b>Compound Stmt</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_EXPRESSION__COMPOUND_STMT = eINSTANCE.getPrimaryExpression_CompoundStmt();

    /**
     * The meta object literal for the '<em><b>Builtin offsetof</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIMARY_EXPRESSION__BUILTIN_OFFSETOF = eINSTANCE.getPrimaryExpression_Builtin_offsetof();

    /**
     * The meta object literal for the '<em><b>Type Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_EXPRESSION__TYPE_NAME = eINSTANCE.getPrimaryExpression_TypeName();

    /**
     * The meta object literal for the '{@link at.jku.weiner.c.parser.parser.impl.ConstantExpressionImpl <em>Constant Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.c.parser.parser.impl.ConstantExpressionImpl
     * @see at.jku.weiner.c.parser.parser.impl.ParserPackageImpl#getConstantExpression()
     * @generated
     */
    EClass CONSTANT_EXPRESSION = eINSTANCE.getConstantExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTANT_EXPRESSION__EXPR = eINSTANCE.getConstantExpression_Expr();

  }

} //ParserPackage
