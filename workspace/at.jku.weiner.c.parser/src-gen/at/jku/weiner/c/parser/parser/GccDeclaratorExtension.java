/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gcc Declarator Extension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.GccDeclaratorExtension#getAsm <em>Asm</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.GccDeclaratorExtension#getString <em>String</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.GccDeclaratorExtension#getGccAttributeSpecifier <em>Gcc Attribute Specifier</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getGccDeclaratorExtension()
 * @model
 * @generated
 */
public interface GccDeclaratorExtension extends EObject
{
  /**
   * Returns the value of the '<em><b>Asm</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Asm</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Asm</em>' attribute.
   * @see #setAsm(String)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getGccDeclaratorExtension_Asm()
   * @model
   * @generated
   */
  String getAsm();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.GccDeclaratorExtension#getAsm <em>Asm</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Asm</em>' attribute.
   * @see #getAsm()
   * @generated
   */
  void setAsm(String value);

  /**
   * Returns the value of the '<em><b>String</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>String</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>String</em>' attribute list.
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getGccDeclaratorExtension_String()
   * @model unique="false"
   * @generated
   */
  EList<String> getString();

  /**
   * Returns the value of the '<em><b>Gcc Attribute Specifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Gcc Attribute Specifier</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Gcc Attribute Specifier</em>' containment reference.
   * @see #setGccAttributeSpecifier(GccAttributeSpecifier)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getGccDeclaratorExtension_GccAttributeSpecifier()
   * @model containment="true"
   * @generated
   */
  GccAttributeSpecifier getGccAttributeSpecifier();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.GccDeclaratorExtension#getGccAttributeSpecifier <em>Gcc Attribute Specifier</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Gcc Attribute Specifier</em>' containment reference.
   * @see #getGccAttributeSpecifier()
   * @generated
   */
  void setGccAttributeSpecifier(GccAttributeSpecifier value);

} // GccDeclaratorExtension
