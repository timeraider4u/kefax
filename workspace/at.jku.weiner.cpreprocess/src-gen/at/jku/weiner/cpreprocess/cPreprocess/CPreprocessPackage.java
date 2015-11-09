/**
 */
package at.jku.weiner.cpreprocess.cPreprocess;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see at.jku.weiner.cpreprocess.cPreprocess.CPreprocessFactory
 * @model kind="package"
 * @generated
 */
public interface CPreprocessPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "cPreprocess";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.jku.at/weiner/cpreprocess/CPreprocess";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "cPreprocess";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CPreprocessPackage eINSTANCE = at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl.init();

  /**
   * The meta object id for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.ModelImpl
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Units</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__UNITS = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.TranslationUnitImpl <em>Translation Unit</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.TranslationUnitImpl
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getTranslationUnit()
   * @generated
   */
  int TRANSLATION_UNIT = 1;

  /**
   * The feature id for the '<em><b>Lines</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSLATION_UNIT__LINES = 0;

  /**
   * The number of structural features of the '<em>Translation Unit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSLATION_UNIT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.SourceCodeLineImpl <em>Source Code Line</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.SourceCodeLineImpl
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getSourceCodeLine()
   * @generated
   */
  int SOURCE_CODE_LINE = 2;

  /**
   * The number of structural features of the '<em>Source Code Line</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE_CODE_LINE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.IncludeDirectiveImpl <em>Include Directive</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.IncludeDirectiveImpl
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getIncludeDirective()
   * @generated
   */
  int INCLUDE_DIRECTIVE = 3;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_DIRECTIVE__STRING = 0;

  /**
   * The number of structural features of the '<em>Include Directive</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_DIRECTIVE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.PreprocessorDirectivesImpl <em>Preprocessor Directives</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.PreprocessorDirectivesImpl
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getPreprocessorDirectives()
   * @generated
   */
  int PREPROCESSOR_DIRECTIVES = 4;

  /**
   * The feature id for the '<em><b>Directive</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROCESSOR_DIRECTIVES__DIRECTIVE = SOURCE_CODE_LINE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Preprocessor Directives</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROCESSOR_DIRECTIVES_FEATURE_COUNT = SOURCE_CODE_LINE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.NewLineLineImpl <em>New Line Line</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.NewLineLineImpl
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getNewLineLine()
   * @generated
   */
  int NEW_LINE_LINE = 5;

  /**
   * The number of structural features of the '<em>New Line Line</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEW_LINE_LINE_FEATURE_COUNT = SOURCE_CODE_LINE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.CodeImpl <em>Code</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CodeImpl
   * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getCode()
   * @generated
   */
  int CODE = 6;

  /**
   * The feature id for the '<em><b>Code</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODE__CODE = SOURCE_CODE_LINE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Code</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODE_FEATURE_COUNT = SOURCE_CODE_LINE_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link at.jku.weiner.cpreprocess.cPreprocess.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.cpreprocess.cPreprocess.Model#getUnits <em>Units</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Units</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.Model#getUnits()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Units();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.cpreprocess.cPreprocess.TranslationUnit <em>Translation Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Translation Unit</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.TranslationUnit
   * @generated
   */
  EClass getTranslationUnit();

  /**
   * Returns the meta object for the containment reference list '{@link at.jku.weiner.cpreprocess.cPreprocess.TranslationUnit#getLines <em>Lines</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Lines</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.TranslationUnit#getLines()
   * @see #getTranslationUnit()
   * @generated
   */
  EReference getTranslationUnit_Lines();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.cpreprocess.cPreprocess.SourceCodeLine <em>Source Code Line</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Source Code Line</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.SourceCodeLine
   * @generated
   */
  EClass getSourceCodeLine();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.cpreprocess.cPreprocess.IncludeDirective <em>Include Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Include Directive</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.IncludeDirective
   * @generated
   */
  EClass getIncludeDirective();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.cpreprocess.cPreprocess.IncludeDirective#getString <em>String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>String</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.IncludeDirective#getString()
   * @see #getIncludeDirective()
   * @generated
   */
  EAttribute getIncludeDirective_String();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives <em>Preprocessor Directives</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preprocessor Directives</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives
   * @generated
   */
  EClass getPreprocessorDirectives();

  /**
   * Returns the meta object for the containment reference '{@link at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives#getDirective <em>Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Directive</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.PreprocessorDirectives#getDirective()
   * @see #getPreprocessorDirectives()
   * @generated
   */
  EReference getPreprocessorDirectives_Directive();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.cpreprocess.cPreprocess.NewLineLine <em>New Line Line</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>New Line Line</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.NewLineLine
   * @generated
   */
  EClass getNewLineLine();

  /**
   * Returns the meta object for class '{@link at.jku.weiner.cpreprocess.cPreprocess.Code <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Code</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.Code
   * @generated
   */
  EClass getCode();

  /**
   * Returns the meta object for the attribute '{@link at.jku.weiner.cpreprocess.cPreprocess.Code#getCode <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Code</em>'.
   * @see at.jku.weiner.cpreprocess.cPreprocess.Code#getCode()
   * @see #getCode()
   * @generated
   */
  EAttribute getCode_Code();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  CPreprocessFactory getCPreprocessFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.ModelImpl
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Units</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__UNITS = eINSTANCE.getModel_Units();

    /**
     * The meta object literal for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.TranslationUnitImpl <em>Translation Unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.TranslationUnitImpl
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getTranslationUnit()
     * @generated
     */
    EClass TRANSLATION_UNIT = eINSTANCE.getTranslationUnit();

    /**
     * The meta object literal for the '<em><b>Lines</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSLATION_UNIT__LINES = eINSTANCE.getTranslationUnit_Lines();

    /**
     * The meta object literal for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.SourceCodeLineImpl <em>Source Code Line</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.SourceCodeLineImpl
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getSourceCodeLine()
     * @generated
     */
    EClass SOURCE_CODE_LINE = eINSTANCE.getSourceCodeLine();

    /**
     * The meta object literal for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.IncludeDirectiveImpl <em>Include Directive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.IncludeDirectiveImpl
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getIncludeDirective()
     * @generated
     */
    EClass INCLUDE_DIRECTIVE = eINSTANCE.getIncludeDirective();

    /**
     * The meta object literal for the '<em><b>String</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INCLUDE_DIRECTIVE__STRING = eINSTANCE.getIncludeDirective_String();

    /**
     * The meta object literal for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.PreprocessorDirectivesImpl <em>Preprocessor Directives</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.PreprocessorDirectivesImpl
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getPreprocessorDirectives()
     * @generated
     */
    EClass PREPROCESSOR_DIRECTIVES = eINSTANCE.getPreprocessorDirectives();

    /**
     * The meta object literal for the '<em><b>Directive</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREPROCESSOR_DIRECTIVES__DIRECTIVE = eINSTANCE.getPreprocessorDirectives_Directive();

    /**
     * The meta object literal for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.NewLineLineImpl <em>New Line Line</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.NewLineLineImpl
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getNewLineLine()
     * @generated
     */
    EClass NEW_LINE_LINE = eINSTANCE.getNewLineLine();

    /**
     * The meta object literal for the '{@link at.jku.weiner.cpreprocess.cPreprocess.impl.CodeImpl <em>Code</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CodeImpl
     * @see at.jku.weiner.cpreprocess.cPreprocess.impl.CPreprocessPackageImpl#getCode()
     * @generated
     */
    EClass CODE = eINSTANCE.getCode();

    /**
     * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CODE__CODE = eINSTANCE.getCode_Code();

  }

} //CPreprocessPackage
