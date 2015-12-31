/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.ExternalDeclaration#getFunctiondefHead <em>Functiondef Head</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.ExternalDeclaration#getFunctionDefinition <em>Function Definition</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.ExternalDeclaration#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.ExternalDeclaration#getSemi <em>Semi</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getExternalDeclaration()
 * @model
 * @generated
 */
public interface ExternalDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Functiondef Head</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Functiondef Head</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Functiondef Head</em>' containment reference.
   * @see #setFunctiondefHead(FunctionDefHead)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getExternalDeclaration_FunctiondefHead()
   * @model containment="true"
   * @generated
   */
  FunctionDefHead getFunctiondefHead();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.ExternalDeclaration#getFunctiondefHead <em>Functiondef Head</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Functiondef Head</em>' containment reference.
   * @see #getFunctiondefHead()
   * @generated
   */
  void setFunctiondefHead(FunctionDefHead value);

  /**
   * Returns the value of the '<em><b>Function Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function Definition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function Definition</em>' containment reference.
   * @see #setFunctionDefinition(FunctionDefinition)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getExternalDeclaration_FunctionDefinition()
   * @model containment="true"
   * @generated
   */
  FunctionDefinition getFunctionDefinition();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.ExternalDeclaration#getFunctionDefinition <em>Function Definition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function Definition</em>' containment reference.
   * @see #getFunctionDefinition()
   * @generated
   */
  void setFunctionDefinition(FunctionDefinition value);

  /**
   * Returns the value of the '<em><b>Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Declaration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Declaration</em>' containment reference.
   * @see #setDeclaration(Declaration)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getExternalDeclaration_Declaration()
   * @model containment="true"
   * @generated
   */
  Declaration getDeclaration();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.ExternalDeclaration#getDeclaration <em>Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Declaration</em>' containment reference.
   * @see #getDeclaration()
   * @generated
   */
  void setDeclaration(Declaration value);

  /**
   * Returns the value of the '<em><b>Semi</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Semi</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Semi</em>' attribute.
   * @see #setSemi(String)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getExternalDeclaration_Semi()
   * @model
   * @generated
   */
  String getSemi();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.ExternalDeclaration#getSemi <em>Semi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Semi</em>' attribute.
   * @see #getSemi()
   * @generated
   */
  void setSemi(String value);

} // ExternalDeclaration
