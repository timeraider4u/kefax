/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Translation Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.TranslationUnit#getExternal <em>External</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getTranslationUnit()
 * @model
 * @generated
 */
public interface TranslationUnit extends EObject
{
  /**
   * Returns the value of the '<em><b>External</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.parser.parser.ExternalDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>External</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>External</em>' containment reference list.
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getTranslationUnit_External()
   * @model containment="true"
   * @generated
   */
  EList<ExternalDeclaration> getExternal();

} // TranslationUnit
