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

} // EnumeratorList
