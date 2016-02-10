/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumerator List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.EnumeratorList#getEnumerator <em>Enumerator</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.EnumeratorList#isLastComma <em>Last Comma</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getEnumeratorList()
 * @model
 * @generated
 */
public interface EnumeratorList extends EObject
{
  /**
   * Returns the value of the '<em><b>Enumerator</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.parser.parser.Enumerator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enumerator</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enumerator</em>' containment reference list.
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getEnumeratorList_Enumerator()
   * @model containment="true"
   * @generated
   */
  EList<Enumerator> getEnumerator();

  /**
   * Returns the value of the '<em><b>Last Comma</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Last Comma</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Last Comma</em>' attribute.
   * @see #setLastComma(boolean)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getEnumeratorList_LastComma()
   * @model
   * @generated
   */
  boolean isLastComma();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.EnumeratorList#isLastComma <em>Last Comma</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Last Comma</em>' attribute.
   * @see #isLastComma()
   * @generated
   */
  void setLastComma(boolean value);

} // EnumeratorList
