/**
 */
package at.jku.weiner.c.parser.parser;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Struct Or Union Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.StructOrUnionSpecifier#getType <em>Type</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.StructOrUnionSpecifier#isBraces <em>Braces</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.StructOrUnionSpecifier#getStructDeclList <em>Struct Decl List</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getStructOrUnionSpecifier()
 * @model
 * @generated
 */
public interface StructOrUnionSpecifier extends DeclarationSpecifier
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(StructOrUnion)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getStructOrUnionSpecifier_Type()
   * @model containment="true"
   * @generated
   */
  StructOrUnion getType();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.StructOrUnionSpecifier#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(StructOrUnion value);

  /**
   * Returns the value of the '<em><b>Braces</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Braces</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Braces</em>' attribute.
   * @see #setBraces(boolean)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getStructOrUnionSpecifier_Braces()
   * @model
   * @generated
   */
  boolean isBraces();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.StructOrUnionSpecifier#isBraces <em>Braces</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Braces</em>' attribute.
   * @see #isBraces()
   * @generated
   */
  void setBraces(boolean value);

  /**
   * Returns the value of the '<em><b>Struct Decl List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Struct Decl List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Struct Decl List</em>' containment reference.
   * @see #setStructDeclList(StructDeclarationList)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getStructOrUnionSpecifier_StructDeclList()
   * @model containment="true"
   * @generated
   */
  StructDeclarationList getStructDeclList();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.StructOrUnionSpecifier#getStructDeclList <em>Struct Decl List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Struct Decl List</em>' containment reference.
   * @see #getStructDeclList()
   * @generated
   */
  void setStructDeclList(StructDeclarationList value);

} // StructOrUnionSpecifier
