/**
 */
package at.jku.weiner.c.common.common;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.common.common.Model#getUnits <em>Units</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.common.common.CommonPackage#getModel()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface Model extends PersistentEObject
{
	/**
	 * Returns the value of the '<em><b>Units</b></em>' containment reference list.
	 * The list contents are of type {@link at.jku.weiner.c.common.common.TranslationUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Units</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Units</em>' containment reference list.
	 * @see at.jku.weiner.c.common.common.CommonPackage#getModel_Units()
	 * @model containment="true"
	 * @generated
	 */
	EList<TranslationUnit> getUnits();

} // Model
