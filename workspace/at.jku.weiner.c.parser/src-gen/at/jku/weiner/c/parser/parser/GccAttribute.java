/**
 */
package at.jku.weiner.c.parser.parser;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gcc Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.parser.parser.GccAttribute#getId <em>Id</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.GccAttribute#getConst <em>Const</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.GccAttribute#getKeyword <em>Keyword</em>}</li>
 *   <li>{@link at.jku.weiner.c.parser.parser.GccAttribute#getList <em>List</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.parser.parser.ParserPackage#getGccAttribute()
 * @model
 * @generated
 */
public interface GccAttribute extends EObject
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
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getGccAttribute_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.GccAttribute#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Const</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Const</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Const</em>' attribute.
   * @see #setConst(String)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getGccAttribute_Const()
   * @model
   * @generated
   */
  String getConst();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.GccAttribute#getConst <em>Const</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Const</em>' attribute.
   * @see #getConst()
   * @generated
   */
  void setConst(String value);

  /**
   * Returns the value of the '<em><b>Keyword</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Keyword</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Keyword</em>' attribute.
   * @see #setKeyword(String)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getGccAttribute_Keyword()
   * @model
   * @generated
   */
  String getKeyword();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.GccAttribute#getKeyword <em>Keyword</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Keyword</em>' attribute.
   * @see #getKeyword()
   * @generated
   */
  void setKeyword(String value);

  /**
   * Returns the value of the '<em><b>List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>List</em>' containment reference.
   * @see #setList(ArgumentExpressionList)
   * @see at.jku.weiner.c.parser.parser.ParserPackage#getGccAttribute_List()
   * @model containment="true"
   * @generated
   */
  ArgumentExpressionList getList();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.parser.parser.GccAttribute#getList <em>List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>List</em>' containment reference.
   * @see #getList()
   * @generated
   */
  void setList(ArgumentExpressionList value);

} // GccAttribute
