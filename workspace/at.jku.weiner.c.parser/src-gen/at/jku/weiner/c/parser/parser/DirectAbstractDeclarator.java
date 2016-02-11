/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Direct Abstract Declarator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.DirectAbstractDeclarator#getDeclarator <em>Declarator</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.DirectAbstractDeclarator#getGccDeclExt <em>Gcc Decl Ext</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.DirectAbstractDeclarator#getAbstractDeclaratorSuffix <em>Abstract Declarator Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getDirectAbstractDeclarator()
 * @model
 * @generated
 */
public interface DirectAbstractDeclarator extends EObject
{
  /**
   * Returns the value of the '<em><b>Declarator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Declarator</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Declarator</em>' containment reference.
   * @see #setDeclarator(AbstractDeclarator)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getDirectAbstractDeclarator_Declarator()
   * @model containment="true"
   * @generated
   */
  AbstractDeclarator getDeclarator();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.DirectAbstractDeclarator#getDeclarator <em>Declarator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Declarator</em>' containment reference.
   * @see #getDeclarator()
   * @generated
   */
  void setDeclarator(AbstractDeclarator value);

  /**
   * Returns the value of the '<em><b>Gcc Decl Ext</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.parser.parser.GccDeclaratorExtension}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Gcc Decl Ext</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Gcc Decl Ext</em>' containment reference list.
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getDirectAbstractDeclarator_GccDeclExt()
   * @model containment="true"
   * @generated
   */
  EList<GccDeclaratorExtension> getGccDeclExt();

  /**
   * Returns the value of the '<em><b>Abstract Declarator Suffix</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.parser.parser.AbstractDeclaratorSuffix}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Abstract Declarator Suffix</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract Declarator Suffix</em>' containment reference list.
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getDirectAbstractDeclarator_AbstractDeclaratorSuffix()
   * @model containment="true"
   * @generated
   */
  EList<AbstractDeclaratorSuffix> getAbstractDeclaratorSuffix();

} // DirectAbstractDeclarator
