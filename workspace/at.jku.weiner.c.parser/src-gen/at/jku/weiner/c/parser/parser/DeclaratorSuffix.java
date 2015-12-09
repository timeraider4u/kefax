/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Declarator Suffix</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.DeclaratorSuffix#getStatic <em>Static</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.DeclaratorSuffix#getTypeQualifierList <em>Type Qualifier List</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.DeclaratorSuffix#getExpr <em>Expr</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.DeclaratorSuffix#getStar <em>Star</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.DeclaratorSuffix#getLastSuffix <em>Last Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getDeclaratorSuffix()
 * @model
 * @generated
 */
public interface DeclaratorSuffix extends EObject
{
  /**
   * Returns the value of the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Static</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Static</em>' attribute.
   * @see #setStatic(String)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getDeclaratorSuffix_Static()
   * @model
   * @generated
   */
  String getStatic();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.DeclaratorSuffix#getStatic <em>Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Static</em>' attribute.
   * @see #getStatic()
   * @generated
   */
  void setStatic(String value);

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
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getDeclaratorSuffix_TypeQualifierList()
   * @model containment="true"
   * @generated
   */
  TypeQualifierList getTypeQualifierList();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.DeclaratorSuffix#getTypeQualifierList <em>Type Qualifier List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Qualifier List</em>' containment reference.
   * @see #getTypeQualifierList()
   * @generated
   */
  void setTypeQualifierList(TypeQualifierList value);

  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(Expression)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getDeclaratorSuffix_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.DeclaratorSuffix#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expression value);

  /**
   * Returns the value of the '<em><b>Star</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Star</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Star</em>' attribute.
   * @see #setStar(String)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getDeclaratorSuffix_Star()
   * @model
   * @generated
   */
  String getStar();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.DeclaratorSuffix#getStar <em>Star</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Star</em>' attribute.
   * @see #getStar()
   * @generated
   */
  void setStar(String value);

  /**
   * Returns the value of the '<em><b>Last Suffix</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Last Suffix</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Last Suffix</em>' containment reference.
   * @see #setLastSuffix(DirectDeclaratorLastSuffix)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getDeclaratorSuffix_LastSuffix()
   * @model containment="true"
   * @generated
   */
  DirectDeclaratorLastSuffix getLastSuffix();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.DeclaratorSuffix#getLastSuffix <em>Last Suffix</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Last Suffix</em>' containment reference.
   * @see #getLastSuffix()
   * @generated
   */
  void setLastSuffix(DirectDeclaratorLastSuffix value);

} // DeclaratorSuffix
