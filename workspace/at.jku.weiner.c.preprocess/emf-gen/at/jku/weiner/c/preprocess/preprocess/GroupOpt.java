/**
 */
package at.jku.weiner.c.preprocess.preprocess;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group Opt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.GroupOpt#getLines <em>Lines</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getGroupOpt()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface GroupOpt extends PersistentEObject
{
	/**
	 * Returns the value of the '<em><b>Lines</b></em>' containment reference list.
	 * The list contents are of type {@link at.jku.weiner.c.preprocess.preprocess.SourceCodeLine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lines</em>' containment reference list.
	 * @see at.jku.weiner.c.preprocess.preprocess.PreprocessPackage#getGroupOpt_Lines()
	 * @model containment="true"
	 * @generated
	 */
	EList<SourceCodeLine> getLines();

} // GroupOpt
