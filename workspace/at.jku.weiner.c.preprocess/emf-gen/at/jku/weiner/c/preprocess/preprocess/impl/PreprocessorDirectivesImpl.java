/**
 */
package at.jku.weiner.c.preprocess.preprocess.impl;

import at.jku.weiner.c.preprocess.preprocess.PreprocessPackage;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Preprocessor Directives</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.jku.weiner.c.preprocess.preprocess.impl.PreprocessorDirectivesImpl#getDirective <em>Directive</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PreprocessorDirectivesImpl extends SourceCodeLineImpl implements PreprocessorDirectives
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreprocessorDirectivesImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return PreprocessPackage.Literals.PREPROCESSOR_DIRECTIVES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getDirective()
	{
		return (EObject)eGet(PreprocessPackage.Literals.PREPROCESSOR_DIRECTIVES__DIRECTIVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirective(EObject newDirective)
	{
		eSet(PreprocessPackage.Literals.PREPROCESSOR_DIRECTIVES__DIRECTIVE, newDirective);
	}

} //PreprocessorDirectivesImpl
