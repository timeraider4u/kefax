/**
 */
package at.jku.weiner.c.common.common.impl;

import at.jku.weiner.c.common.common.CommonPackage;
import at.jku.weiner.c.common.common.Parser;
import at.jku.weiner.c.common.common.Preprocess;
import at.jku.weiner.c.common.common.TranslationUnit;

import fr.inria.atlanmod.neoemf.core.impl.PersistentEObjectImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Translation Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.jku.weiner.c.common.common.impl.TranslationUnitImpl#getPreprocess <em>Preprocess</em>}</li>
 *   <li>{@link at.jku.weiner.c.common.common.impl.TranslationUnitImpl#getParser <em>Parser</em>}</li>
 *   <li>{@link at.jku.weiner.c.common.common.impl.TranslationUnitImpl#getPath <em>Path</em>}</li>
 *   <li>{@link at.jku.weiner.c.common.common.impl.TranslationUnitImpl#getAdditionalPreprocessingDirectives <em>Additional Preprocessing Directives</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TranslationUnitImpl extends PersistentEObjectImpl implements TranslationUnit
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TranslationUnitImpl()
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
		return CommonPackage.Literals.TRANSLATION_UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount()
	{
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Preprocess getPreprocess()
	{
		return (Preprocess)eGet(CommonPackage.Literals.TRANSLATION_UNIT__PREPROCESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreprocess(Preprocess newPreprocess)
	{
		eSet(CommonPackage.Literals.TRANSLATION_UNIT__PREPROCESS, newPreprocess);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parser getParser()
	{
		return (Parser)eGet(CommonPackage.Literals.TRANSLATION_UNIT__PARSER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParser(Parser newParser)
	{
		eSet(CommonPackage.Literals.TRANSLATION_UNIT__PARSER, newParser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath()
	{
		return (String)eGet(CommonPackage.Literals.TRANSLATION_UNIT__PATH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(String newPath)
	{
		eSet(CommonPackage.Literals.TRANSLATION_UNIT__PATH, newPath);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Preprocess getAdditionalPreprocessingDirectives()
	{
		return (Preprocess)eGet(CommonPackage.Literals.TRANSLATION_UNIT__ADDITIONAL_PREPROCESSING_DIRECTIVES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdditionalPreprocessingDirectives(Preprocess newAdditionalPreprocessingDirectives)
	{
		eSet(CommonPackage.Literals.TRANSLATION_UNIT__ADDITIONAL_PREPROCESSING_DIRECTIVES, newAdditionalPreprocessingDirectives);
	}

} //TranslationUnitImpl
