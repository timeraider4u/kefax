/**
 */
package at.jku.weiner.xtexttest.xtextTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.Import#getId <em>Id</em>}</li>
 *   <li>{@link at.jku.weiner.xtexttest.xtextTest.Import#getAlias <em>Alias</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getImport()
 * @model
 * @generated
 */
public interface Import extends EObject
{
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getImport_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.Import#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Alias</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Alias</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Alias</em>' attribute.
   * @see #setAlias(String)
   * @see at.jku.weiner.xtexttest.xtextTest.XtextTestPackage#getImport_Alias()
   * @model
   * @generated
   */
  String getAlias();

  /**
   * Sets the value of the '{@link at.jku.weiner.xtexttest.xtextTest.Import#getAlias <em>Alias</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Alias</em>' attribute.
   * @see #getAlias()
   * @generated
   */
  void setAlias(String value);

} // Import
