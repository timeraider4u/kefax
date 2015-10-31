/**
 */
package at.jku.weiner.c.c;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specifier Qualifier List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.SpecifierQualifierList#getTypeSpecifier <em>Type Specifier</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.SpecifierQualifierList#getTypeQualifier <em>Type Qualifier</em>}</li>
 *   <li>{@link at.jku.weiner.c.c.SpecifierQualifierList#getStructOrUnionSpecifier <em>Struct Or Union Specifier</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.c.CPackage#getSpecifierQualifierList()
 * @model
 * @generated
 */
public interface SpecifierQualifierList extends EObject
{
  /**
   * Returns the value of the '<em><b>Type Specifier</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.c.TypeSpecifier}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Specifier</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Specifier</em>' containment reference list.
   * @see at.jku.weiner.c.c.CPackage#getSpecifierQualifierList_TypeSpecifier()
   * @model containment="true"
   * @generated
   */
  EList<TypeSpecifier> getTypeSpecifier();

  /**
   * Returns the value of the '<em><b>Type Qualifier</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.c.TypeQualifier}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Qualifier</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Qualifier</em>' containment reference list.
   * @see at.jku.weiner.c.c.CPackage#getSpecifierQualifierList_TypeQualifier()
   * @model containment="true"
   * @generated
   */
  EList<TypeQualifier> getTypeQualifier();

  /**
   * Returns the value of the '<em><b>Struct Or Union Specifier</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.c.DeclarationSpecifier}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Struct Or Union Specifier</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Struct Or Union Specifier</em>' containment reference list.
   * @see at.jku.weiner.c.c.CPackage#getSpecifierQualifierList_StructOrUnionSpecifier()
   * @model containment="true"
   * @generated
   */
  EList<DeclarationSpecifier> getStructOrUnionSpecifier();

} // SpecifierQualifierList
