/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Declarator Suffix</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.AbstractDeclaratorSuffix#getTypeQualifierList <em>Type Qualifier List</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.AbstractDeclaratorSuffix#getAssignmentExpr <em>Assignment Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.AbstractDeclaratorSuffix#getTypeQualifierListOrig <em>Type Qualifier List Orig</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.AbstractDeclaratorSuffix#getParameterTypeList <em>Parameter Type List</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.AbstractDeclaratorSuffix#getGccDeclExt <em>Gcc Decl Ext</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getAbstractDeclaratorSuffix()
 * @model
 * @generated
 */
public interface AbstractDeclaratorSuffix extends EObject
{
  /**
   * Returns the value of the '<em><b>Type Qualifier List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Qualifier List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Qualifier List</em>' containment reference.
   * @see #setTypeQualifierList(TypeQualifierList)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getAbstractDeclaratorSuffix_TypeQualifierList()
   * @model containment="true"
   * @generated
   */
  TypeQualifierList getTypeQualifierList();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.AbstractDeclaratorSuffix#getTypeQualifierList <em>Type Qualifier List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Qualifier List</em>' containment reference.
   * @see #getTypeQualifierList()
   * @generated
   */
  void setTypeQualifierList(TypeQualifierList value);

  /**
   * Returns the value of the '<em><b>Assignment Expr</b></em>' containment reference list.
   * The list contents are of type {@link at.jku.weiner.c.parser.parser.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assignment Expr</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assignment Expr</em>' containment reference list.
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getAbstractDeclaratorSuffix_AssignmentExpr()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getAssignmentExpr();

  /**
   * Returns the value of the '<em><b>Type Qualifier List Orig</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Qualifier List Orig</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Qualifier List Orig</em>' containment reference.
   * @see #setTypeQualifierListOrig(TypeQualifierList)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getAbstractDeclaratorSuffix_TypeQualifierListOrig()
   * @model containment="true"
   * @generated
   */
  TypeQualifierList getTypeQualifierListOrig();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.AbstractDeclaratorSuffix#getTypeQualifierListOrig <em>Type Qualifier List Orig</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Qualifier List Orig</em>' containment reference.
   * @see #getTypeQualifierListOrig()
   * @generated
   */
  void setTypeQualifierListOrig(TypeQualifierList value);

  /**
   * Returns the value of the '<em><b>Parameter Type List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter Type List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter Type List</em>' containment reference.
   * @see #setParameterTypeList(ParameterTypeList)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getAbstractDeclaratorSuffix_ParameterTypeList()
   * @model containment="true"
   * @generated
   */
  ParameterTypeList getParameterTypeList();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.AbstractDeclaratorSuffix#getParameterTypeList <em>Parameter Type List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameter Type List</em>' containment reference.
   * @see #getParameterTypeList()
   * @generated
   */
  void setParameterTypeList(ParameterTypeList value);

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
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getAbstractDeclaratorSuffix_GccDeclExt()
   * @model containment="true"
   * @generated
   */
  EList<GccDeclaratorExtension> getGccDeclExt();

} // AbstractDeclaratorSuffix
