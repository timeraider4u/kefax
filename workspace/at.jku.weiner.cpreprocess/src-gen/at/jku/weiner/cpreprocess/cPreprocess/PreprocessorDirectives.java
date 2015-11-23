/**
 */
package at.jku.weiner.cpreprocess.cPreprocess;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Preprocessor Directives</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives#getDirective <em>Directive</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.cpreprocess.cPreprocess.CPreprocessPackage#getPreprocessorDirectives()
 * @model
 * @generated
 */
public interface PreprocessorDirectives extends SourceCodeLine
{
  /**
   * Returns the value of the '<em><b>Directive</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Directive</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Directive</em>' containment reference.
   * @see #setDirective(EObject)
   * @see at.jku.weiner.cpreprocess.cPreprocess.CPreprocessPackage#getPreprocessorDirectives_Directive()
   * @model containment="true"
   * @generated
   */
  EObject getDirective();

  /**
   * Sets the value of the '{@link at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives#getDirective <em>Directive</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Directive</em>' containment reference.
   * @see #getDirective()
   * @generated
   */
  void setDirective(EObject value);

} // PreprocessorDirectives
