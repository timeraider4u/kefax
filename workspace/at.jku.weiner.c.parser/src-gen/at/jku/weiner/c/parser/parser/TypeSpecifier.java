/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.TypeSpecifier#getName <em>Name</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.TypeSpecifier#getExtType <em>Ext Type</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.TypeSpecifier#getSpecifier <em>Specifier</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.TypeSpecifier#getType <em>Type</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.TypeSpecifier#getTypeOf <em>Type Of</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.TypeSpecifier#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.TypeSpecifier#getConstExpr <em>Const Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getTypeSpecifier()
 * @model
 * @generated
 */
public interface TypeSpecifier extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getTypeSpecifier_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.TypeSpecifier#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Ext Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ext Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ext Type</em>' attribute.
   * @see #setExtType(String)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getTypeSpecifier_ExtType()
   * @model
   * @generated
   */
  String getExtType();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.TypeSpecifier#getExtType <em>Ext Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ext Type</em>' attribute.
   * @see #getExtType()
   * @generated
   */
  void setExtType(String value);

  /**
   * Returns the value of the '<em><b>Specifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Specifier</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Specifier</em>' containment reference.
   * @see #setSpecifier(DeclarationSpecifier)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getTypeSpecifier_Specifier()
   * @model containment="true"
   * @generated
   */
  DeclarationSpecifier getSpecifier();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.TypeSpecifier#getSpecifier <em>Specifier</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Specifier</em>' containment reference.
   * @see #getSpecifier()
   * @generated
   */
  void setSpecifier(DeclarationSpecifier value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(TypedefName)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getTypeSpecifier_Type()
   * @model containment="true"
   * @generated
   */
  TypedefName getType();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.TypeSpecifier#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(TypedefName value);

  /**
   * Returns the value of the '<em><b>Type Of</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Of</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Of</em>' attribute.
   * @see #setTypeOf(String)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getTypeSpecifier_TypeOf()
   * @model
   * @generated
   */
  String getTypeOf();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.TypeSpecifier#getTypeOf <em>Type Of</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Of</em>' attribute.
   * @see #getTypeOf()
   * @generated
   */
  void setTypeOf(String value);

  /**
   * Returns the value of the '<em><b>Type Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Name</em>' containment reference.
   * @see #setTypeName(TypeName)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getTypeSpecifier_TypeName()
   * @model containment="true"
   * @generated
   */
  TypeName getTypeName();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.TypeSpecifier#getTypeName <em>Type Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Name</em>' containment reference.
   * @see #getTypeName()
   * @generated
   */
  void setTypeName(TypeName value);

  /**
   * Returns the value of the '<em><b>Const Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Const Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Const Expr</em>' containment reference.
   * @see #setConstExpr(Expression)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getTypeSpecifier_ConstExpr()
   * @model containment="true"
   * @generated
   */
  Expression getConstExpr();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.TypeSpecifier#getConstExpr <em>Const Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Const Expr</em>' containment reference.
   * @see #getConstExpr()
   * @generated
   */
  void setConstExpr(Expression value);

} // TypeSpecifier
