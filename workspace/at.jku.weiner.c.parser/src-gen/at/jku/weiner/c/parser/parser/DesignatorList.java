/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Designator List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.DesignatorList#getDesignator <em>Designator</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getDesignatorList()
 * @model
 * @generated
 */
public interface DesignatorList extends EObject
{
  /**
   * Returns the value of the '<em><b>Designator</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.parser.parser.Designator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Designator</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Designator</em>' containment reference list.
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getDesignatorList_Designator()
   * @model containment="true"
   * @generated
   */
  EList<Designator> getDesignator();

} // DesignatorList
