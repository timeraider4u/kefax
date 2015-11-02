/**
 */
package at.jku.weiner.c.c;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.EnumSpecifier#getEnumList <em>Enum List</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.c.CPackage#getEnumSpecifier()
 * @model
 * @generated
 */
public interface EnumSpecifier extends DeclarationSpecifier
{
  /**
   * Returns the value of the '<em><b>Enum List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enum List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enum List</em>' containment reference.
   * @see #setEnumList(EnumeratorList)
   * @see at.jku.weiner.c.c.CPackage#getEnumSpecifier_EnumList()
   * @model containment="true"
   * @generated
   */
  EnumeratorList getEnumList();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.EnumSpecifier#getEnumList <em>Enum List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enum List</em>' containment reference.
   * @see #getEnumList()
   * @generated
   */
  void setEnumList(EnumeratorList value);

} // EnumSpecifier
