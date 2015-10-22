/**
 */
package at.jku.weiner.c.c;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compound Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.c.CompoundStatement#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see at.jku.weiner.c.c.CPackage#getCompoundStatement()
 * @model
 * @generated
 */
public interface CompoundStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(Statement)
   * @see at.jku.weiner.c.c.CPackage#getCompoundStatement_Body()
   * @model containment="true"
   * @generated
   */
  Statement getBody();

  /**
   * Sets the value of the '{@link at.jku.weiner.c.c.CompoundStatement#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(Statement value);

} // CompoundStatement
