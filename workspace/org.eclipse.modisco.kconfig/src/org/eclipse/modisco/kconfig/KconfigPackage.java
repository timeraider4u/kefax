/**
 * Copyright (c) 2010 Mia-Software.
 *    All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *   
 *   Contributors:
 *   
 *   	   Nicolas Guyomar (Mia-Software) - initial API and implementation
 */
package org.eclipse.modisco.kconfig;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.modisco.kconfig.KconfigFactory
 * @model kind="package"
 * @generated
 */
public interface KconfigPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "kconfig"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/MoDisco/KCONFIG/0.1.incubation/kconfig"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "kconfig"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KconfigPackage eINSTANCE = org.eclipse.modisco.kconfig.impl.KconfigPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.modisco.kconfig.impl.TranslationUnitImpl <em>Translation Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.modisco.kconfig.impl.TranslationUnitImpl
	 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getTranslationUnit()
	 * @generated
	 */
	int TRANSLATION_UNIT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSLATION_UNIT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Unit Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSLATION_UNIT__UNIT_OWNER = 1;

	/**
	 * The feature id for the '<em><b>Full Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSLATION_UNIT__FULL_PATH = 2;

	/**
	 * The feature id for the '<em><b>Configs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSLATION_UNIT__CONFIGS = 3;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSLATION_UNIT__SOURCES = 4;

	/**
	 * The number of structural features of the '<em>Translation Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSLATION_UNIT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.modisco.kconfig.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.modisco.kconfig.impl.ModelImpl
	 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 1;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__UNITS = 0;

	/**
	 * The feature id for the '<em><b>Configs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__CONFIGS = 1;

	/**
	 * The feature id for the '<em><b>Full Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__FULL_PATH = 2;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.modisco.kconfig.impl.ConfigImpl <em>Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.modisco.kconfig.impl.ConfigImpl
	 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getConfig()
	 * @generated
	 */
	int CONFIG = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Help Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG__HELP_TEXT = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG__DESCRIPTION = 3;

	/**
	 * The feature id for the '<em><b>Depends</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG__DEPENDS = 4;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG__OWNER = 5;

	/**
	 * The feature id for the '<em><b>Defined In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG__DEFINED_IN = 6;

	/**
	 * The feature id for the '<em><b>Prompt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG__PROMPT = 7;

	/**
	 * The feature id for the '<em><b>Defaults</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG__DEFAULTS = 8;

	/**
	 * The feature id for the '<em><b>Selects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG__SELECTS = 9;

	/**
	 * The feature id for the '<em><b>Ranges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG__RANGES = 10;

	/**
	 * The feature id for the '<em><b>Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG__OPTIONS = 11;

	/**
	 * The number of structural features of the '<em>Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_FEATURE_COUNT = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.modisco.kconfig.Expr <em>Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.modisco.kconfig.Expr
	 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getExpr()
	 * @generated
	 */
	int EXPR = 3;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR__OWNER = 0;

	/**
	 * The number of structural features of the '<em>Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.modisco.kconfig.impl.ConfigExprImpl <em>Config Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.modisco.kconfig.impl.ConfigExprImpl
	 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getConfigExpr()
	 * @generated
	 */
	int CONFIG_EXPR = 4;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_EXPR__OWNER = EXPR__OWNER;

	/**
	 * The feature id for the '<em><b>Negated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_EXPR__NEGATED = EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ref On Config</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_EXPR__REF_ON_CONFIG = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Config Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.modisco.kconfig.impl.PromptImpl <em>Prompt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.modisco.kconfig.impl.PromptImpl
	 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getPrompt()
	 * @generated
	 */
	int PROMPT = 5;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT__OWNER = 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT__EXPRESSION = 1;

	/**
	 * The number of structural features of the '<em>Prompt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.modisco.kconfig.impl.DependImpl <em>Depend</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.modisco.kconfig.impl.DependImpl
	 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getDepend()
	 * @generated
	 */
	int DEPEND = 6;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPEND__OWNER = 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPEND__EXPRESSION = 1;

	/**
	 * The number of structural features of the '<em>Depend</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPEND_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.modisco.kconfig.impl.DefaultImpl <em>Default</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.modisco.kconfig.impl.DefaultImpl
	 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getDefault()
	 * @generated
	 */
	int DEFAULT = 7;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT__OWNER = 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT__EXPRESSION = 1;

	/**
	 * The feature id for the '<em><b>If Expr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT__IF_EXPR = 2;

	/**
	 * The number of structural features of the '<em>Default</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.modisco.kconfig.impl.TristateExprImpl <em>Tristate Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.modisco.kconfig.impl.TristateExprImpl
	 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getTristateExpr()
	 * @generated
	 */
	int TRISTATE_EXPR = 8;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRISTATE_EXPR__OWNER = EXPR__OWNER;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRISTATE_EXPR__VALUE = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tristate Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRISTATE_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.modisco.kconfig.impl.LiteralExprImpl <em>Literal Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.modisco.kconfig.impl.LiteralExprImpl
	 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getLiteralExpr()
	 * @generated
	 */
	int LITERAL_EXPR = 9;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXPR__OWNER = EXPR__OWNER;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXPR__VALUE = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.modisco.kconfig.impl.SelectImpl <em>Select</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.modisco.kconfig.impl.SelectImpl
	 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getSelect()
	 * @generated
	 */
	int SELECT = 10;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT__OWNER = 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT__EXPRESSION = 1;

	/**
	 * The feature id for the '<em><b>If Expr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT__IF_EXPR = 2;

	/**
	 * The number of structural features of the '<em>Select</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.modisco.kconfig.impl.RangeImpl <em>Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.modisco.kconfig.impl.RangeImpl
	 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getRange()
	 * @generated
	 */
	int RANGE = 11;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE__OWNER = 0;

	/**
	 * The feature id for the '<em><b>Lower Expr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE__LOWER_EXPR = 1;

	/**
	 * The feature id for the '<em><b>If Expr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE__IF_EXPR = 2;

	/**
	 * The feature id for the '<em><b>Upper Expr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE__UPPER_EXPR = 3;

	/**
	 * The number of structural features of the '<em>Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.modisco.kconfig.impl.OptionImpl <em>Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.modisco.kconfig.impl.OptionImpl
	 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getOption()
	 * @generated
	 */
	int OPTION = 12;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__OWNER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__VALUE = 2;

	/**
	 * The number of structural features of the '<em>Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.modisco.kconfig.impl.BooleanExprImpl <em>Boolean Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.modisco.kconfig.impl.BooleanExprImpl
	 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getBooleanExpr()
	 * @generated
	 */
	int BOOLEAN_EXPR = 13;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPR__OWNER = EXPR__OWNER;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPR__RIGHT = EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPR__LEFT = EXPR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPR__TYPE = EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Boolean Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.modisco.kconfig.ConfigType <em>Config Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.modisco.kconfig.ConfigType
	 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getConfigType()
	 * @generated
	 */
	int CONFIG_TYPE = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.modisco.kconfig.TristateValue <em>Tristate Value</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.modisco.kconfig.TristateValue
	 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getTristateValue()
	 * @generated
	 */
	int TRISTATE_VALUE = 15;


	/**
	 * The meta object id for the '{@link org.eclipse.modisco.kconfig.BooleanExprType <em>Boolean Expr Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.modisco.kconfig.BooleanExprType
	 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getBooleanExprType()
	 * @generated
	 */
	int BOOLEAN_EXPR_TYPE = 16;


	/**
	 * Returns the meta object for class '{@link org.eclipse.modisco.kconfig.TranslationUnit <em>Translation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Translation Unit</em>'.
	 * @see org.eclipse.modisco.kconfig.TranslationUnit
	 * @generated
	 */
	EClass getTranslationUnit();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.modisco.kconfig.TranslationUnit#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.modisco.kconfig.TranslationUnit#getName()
	 * @see #getTranslationUnit()
	 * @generated
	 */
	EAttribute getTranslationUnit_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.modisco.kconfig.TranslationUnit#getUnitOwner <em>Unit Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Unit Owner</em>'.
	 * @see org.eclipse.modisco.kconfig.TranslationUnit#getUnitOwner()
	 * @see #getTranslationUnit()
	 * @generated
	 */
	EReference getTranslationUnit_UnitOwner();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.modisco.kconfig.TranslationUnit#getFullPath <em>Full Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Full Path</em>'.
	 * @see org.eclipse.modisco.kconfig.TranslationUnit#getFullPath()
	 * @see #getTranslationUnit()
	 * @generated
	 */
	EAttribute getTranslationUnit_FullPath();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.modisco.kconfig.TranslationUnit#getConfigs <em>Configs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Configs</em>'.
	 * @see org.eclipse.modisco.kconfig.TranslationUnit#getConfigs()
	 * @see #getTranslationUnit()
	 * @generated
	 */
	EReference getTranslationUnit_Configs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.modisco.kconfig.TranslationUnit#getSources <em>Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sources</em>'.
	 * @see org.eclipse.modisco.kconfig.TranslationUnit#getSources()
	 * @see #getTranslationUnit()
	 * @generated
	 */
	EReference getTranslationUnit_Sources();

	/**
	 * Returns the meta object for class '{@link org.eclipse.modisco.kconfig.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see org.eclipse.modisco.kconfig.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.modisco.kconfig.Model#getUnits <em>Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Units</em>'.
	 * @see org.eclipse.modisco.kconfig.Model#getUnits()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Units();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.modisco.kconfig.Model#getConfigs <em>Configs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Configs</em>'.
	 * @see org.eclipse.modisco.kconfig.Model#getConfigs()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Configs();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.modisco.kconfig.Model#getFullPath <em>Full Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Full Path</em>'.
	 * @see org.eclipse.modisco.kconfig.Model#getFullPath()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_FullPath();

	/**
	 * Returns the meta object for class '{@link org.eclipse.modisco.kconfig.Config <em>Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Config</em>'.
	 * @see org.eclipse.modisco.kconfig.Config
	 * @generated
	 */
	EClass getConfig();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.modisco.kconfig.Config#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.modisco.kconfig.Config#getName()
	 * @see #getConfig()
	 * @generated
	 */
	EAttribute getConfig_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.modisco.kconfig.Config#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.modisco.kconfig.Config#getType()
	 * @see #getConfig()
	 * @generated
	 */
	EAttribute getConfig_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.modisco.kconfig.Config#getHelpText <em>Help Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Help Text</em>'.
	 * @see org.eclipse.modisco.kconfig.Config#getHelpText()
	 * @see #getConfig()
	 * @generated
	 */
	EAttribute getConfig_HelpText();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.modisco.kconfig.Config#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.modisco.kconfig.Config#getDescription()
	 * @see #getConfig()
	 * @generated
	 */
	EAttribute getConfig_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.modisco.kconfig.Config#getDepends <em>Depends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Depends</em>'.
	 * @see org.eclipse.modisco.kconfig.Config#getDepends()
	 * @see #getConfig()
	 * @generated
	 */
	EReference getConfig_Depends();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.modisco.kconfig.Config#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.modisco.kconfig.Config#getOwner()
	 * @see #getConfig()
	 * @generated
	 */
	EReference getConfig_Owner();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.modisco.kconfig.Config#getDefinedIn <em>Defined In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Defined In</em>'.
	 * @see org.eclipse.modisco.kconfig.Config#getDefinedIn()
	 * @see #getConfig()
	 * @generated
	 */
	EReference getConfig_DefinedIn();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.modisco.kconfig.Config#getPrompt <em>Prompt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Prompt</em>'.
	 * @see org.eclipse.modisco.kconfig.Config#getPrompt()
	 * @see #getConfig()
	 * @generated
	 */
	EReference getConfig_Prompt();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.modisco.kconfig.Config#getDefaults <em>Defaults</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Defaults</em>'.
	 * @see org.eclipse.modisco.kconfig.Config#getDefaults()
	 * @see #getConfig()
	 * @generated
	 */
	EReference getConfig_Defaults();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.modisco.kconfig.Config#getSelects <em>Selects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Selects</em>'.
	 * @see org.eclipse.modisco.kconfig.Config#getSelects()
	 * @see #getConfig()
	 * @generated
	 */
	EReference getConfig_Selects();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.modisco.kconfig.Config#getRanges <em>Ranges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ranges</em>'.
	 * @see org.eclipse.modisco.kconfig.Config#getRanges()
	 * @see #getConfig()
	 * @generated
	 */
	EReference getConfig_Ranges();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.modisco.kconfig.Config#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Options</em>'.
	 * @see org.eclipse.modisco.kconfig.Config#getOptions()
	 * @see #getConfig()
	 * @generated
	 */
	EReference getConfig_Options();

	/**
	 * Returns the meta object for class '{@link org.eclipse.modisco.kconfig.Expr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expr</em>'.
	 * @see org.eclipse.modisco.kconfig.Expr
	 * @generated
	 */
	EClass getExpr();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.modisco.kconfig.Expr#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see org.eclipse.modisco.kconfig.Expr#getOwner()
	 * @see #getExpr()
	 * @generated
	 */
	EReference getExpr_Owner();

	/**
	 * Returns the meta object for class '{@link org.eclipse.modisco.kconfig.ConfigExpr <em>Config Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Config Expr</em>'.
	 * @see org.eclipse.modisco.kconfig.ConfigExpr
	 * @generated
	 */
	EClass getConfigExpr();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.modisco.kconfig.ConfigExpr#isNegated <em>Negated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Negated</em>'.
	 * @see org.eclipse.modisco.kconfig.ConfigExpr#isNegated()
	 * @see #getConfigExpr()
	 * @generated
	 */
	EAttribute getConfigExpr_Negated();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.modisco.kconfig.ConfigExpr#getRefOnConfig <em>Ref On Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref On Config</em>'.
	 * @see org.eclipse.modisco.kconfig.ConfigExpr#getRefOnConfig()
	 * @see #getConfigExpr()
	 * @generated
	 */
	EReference getConfigExpr_RefOnConfig();

	/**
	 * Returns the meta object for class '{@link org.eclipse.modisco.kconfig.Prompt <em>Prompt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prompt</em>'.
	 * @see org.eclipse.modisco.kconfig.Prompt
	 * @generated
	 */
	EClass getPrompt();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.modisco.kconfig.Prompt#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.modisco.kconfig.Prompt#getOwner()
	 * @see #getPrompt()
	 * @generated
	 */
	EReference getPrompt_Owner();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.modisco.kconfig.Prompt#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expression</em>'.
	 * @see org.eclipse.modisco.kconfig.Prompt#getExpression()
	 * @see #getPrompt()
	 * @generated
	 */
	EReference getPrompt_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.modisco.kconfig.Depend <em>Depend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Depend</em>'.
	 * @see org.eclipse.modisco.kconfig.Depend
	 * @generated
	 */
	EClass getDepend();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.modisco.kconfig.Depend#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.modisco.kconfig.Depend#getOwner()
	 * @see #getDepend()
	 * @generated
	 */
	EReference getDepend_Owner();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.modisco.kconfig.Depend#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expression</em>'.
	 * @see org.eclipse.modisco.kconfig.Depend#getExpression()
	 * @see #getDepend()
	 * @generated
	 */
	EReference getDepend_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.modisco.kconfig.Default <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default</em>'.
	 * @see org.eclipse.modisco.kconfig.Default
	 * @generated
	 */
	EClass getDefault();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.modisco.kconfig.Default#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.modisco.kconfig.Default#getOwner()
	 * @see #getDefault()
	 * @generated
	 */
	EReference getDefault_Owner();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.modisco.kconfig.Default#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expression</em>'.
	 * @see org.eclipse.modisco.kconfig.Default#getExpression()
	 * @see #getDefault()
	 * @generated
	 */
	EReference getDefault_Expression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.modisco.kconfig.Default#getIfExpr <em>If Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>If Expr</em>'.
	 * @see org.eclipse.modisco.kconfig.Default#getIfExpr()
	 * @see #getDefault()
	 * @generated
	 */
	EReference getDefault_IfExpr();

	/**
	 * Returns the meta object for class '{@link org.eclipse.modisco.kconfig.TristateExpr <em>Tristate Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tristate Expr</em>'.
	 * @see org.eclipse.modisco.kconfig.TristateExpr
	 * @generated
	 */
	EClass getTristateExpr();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.modisco.kconfig.TristateExpr#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.modisco.kconfig.TristateExpr#getValue()
	 * @see #getTristateExpr()
	 * @generated
	 */
	EAttribute getTristateExpr_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.modisco.kconfig.LiteralExpr <em>Literal Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Expr</em>'.
	 * @see org.eclipse.modisco.kconfig.LiteralExpr
	 * @generated
	 */
	EClass getLiteralExpr();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.modisco.kconfig.LiteralExpr#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.modisco.kconfig.LiteralExpr#getValue()
	 * @see #getLiteralExpr()
	 * @generated
	 */
	EAttribute getLiteralExpr_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.modisco.kconfig.Select <em>Select</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Select</em>'.
	 * @see org.eclipse.modisco.kconfig.Select
	 * @generated
	 */
	EClass getSelect();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.modisco.kconfig.Select#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.modisco.kconfig.Select#getOwner()
	 * @see #getSelect()
	 * @generated
	 */
	EReference getSelect_Owner();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.modisco.kconfig.Select#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expression</em>'.
	 * @see org.eclipse.modisco.kconfig.Select#getExpression()
	 * @see #getSelect()
	 * @generated
	 */
	EReference getSelect_Expression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.modisco.kconfig.Select#getIfExpr <em>If Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>If Expr</em>'.
	 * @see org.eclipse.modisco.kconfig.Select#getIfExpr()
	 * @see #getSelect()
	 * @generated
	 */
	EReference getSelect_IfExpr();

	/**
	 * Returns the meta object for class '{@link org.eclipse.modisco.kconfig.Range <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Range</em>'.
	 * @see org.eclipse.modisco.kconfig.Range
	 * @generated
	 */
	EClass getRange();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.modisco.kconfig.Range#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.modisco.kconfig.Range#getOwner()
	 * @see #getRange()
	 * @generated
	 */
	EReference getRange_Owner();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.modisco.kconfig.Range#getLowerExpr <em>Lower Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lower Expr</em>'.
	 * @see org.eclipse.modisco.kconfig.Range#getLowerExpr()
	 * @see #getRange()
	 * @generated
	 */
	EReference getRange_LowerExpr();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.modisco.kconfig.Range#getIfExpr <em>If Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>If Expr</em>'.
	 * @see org.eclipse.modisco.kconfig.Range#getIfExpr()
	 * @see #getRange()
	 * @generated
	 */
	EReference getRange_IfExpr();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.modisco.kconfig.Range#getUpperExpr <em>Upper Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Upper Expr</em>'.
	 * @see org.eclipse.modisco.kconfig.Range#getUpperExpr()
	 * @see #getRange()
	 * @generated
	 */
	EReference getRange_UpperExpr();

	/**
	 * Returns the meta object for class '{@link org.eclipse.modisco.kconfig.Option <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Option</em>'.
	 * @see org.eclipse.modisco.kconfig.Option
	 * @generated
	 */
	EClass getOption();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.modisco.kconfig.Option#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.modisco.kconfig.Option#getOwner()
	 * @see #getOption()
	 * @generated
	 */
	EReference getOption_Owner();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.modisco.kconfig.Option#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.modisco.kconfig.Option#getName()
	 * @see #getOption()
	 * @generated
	 */
	EAttribute getOption_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.modisco.kconfig.Option#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.modisco.kconfig.Option#getValue()
	 * @see #getOption()
	 * @generated
	 */
	EAttribute getOption_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.modisco.kconfig.BooleanExpr <em>Boolean Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Expr</em>'.
	 * @see org.eclipse.modisco.kconfig.BooleanExpr
	 * @generated
	 */
	EClass getBooleanExpr();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.modisco.kconfig.BooleanExpr#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see org.eclipse.modisco.kconfig.BooleanExpr#getRight()
	 * @see #getBooleanExpr()
	 * @generated
	 */
	EReference getBooleanExpr_Right();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.modisco.kconfig.BooleanExpr#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see org.eclipse.modisco.kconfig.BooleanExpr#getLeft()
	 * @see #getBooleanExpr()
	 * @generated
	 */
	EReference getBooleanExpr_Left();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.modisco.kconfig.BooleanExpr#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.modisco.kconfig.BooleanExpr#getType()
	 * @see #getBooleanExpr()
	 * @generated
	 */
	EAttribute getBooleanExpr_Type();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.modisco.kconfig.ConfigType <em>Config Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Config Type</em>'.
	 * @see org.eclipse.modisco.kconfig.ConfigType
	 * @generated
	 */
	EEnum getConfigType();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.modisco.kconfig.TristateValue <em>Tristate Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Tristate Value</em>'.
	 * @see org.eclipse.modisco.kconfig.TristateValue
	 * @generated
	 */
	EEnum getTristateValue();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.modisco.kconfig.BooleanExprType <em>Boolean Expr Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Boolean Expr Type</em>'.
	 * @see org.eclipse.modisco.kconfig.BooleanExprType
	 * @generated
	 */
	EEnum getBooleanExprType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	KconfigFactory getKconfigFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.modisco.kconfig.impl.TranslationUnitImpl <em>Translation Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.modisco.kconfig.impl.TranslationUnitImpl
		 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getTranslationUnit()
		 * @generated
		 */
		EClass TRANSLATION_UNIT = eINSTANCE.getTranslationUnit();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSLATION_UNIT__NAME = eINSTANCE.getTranslationUnit_Name();

		/**
		 * The meta object literal for the '<em><b>Unit Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSLATION_UNIT__UNIT_OWNER = eINSTANCE.getTranslationUnit_UnitOwner();

		/**
		 * The meta object literal for the '<em><b>Full Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSLATION_UNIT__FULL_PATH = eINSTANCE.getTranslationUnit_FullPath();

		/**
		 * The meta object literal for the '<em><b>Configs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSLATION_UNIT__CONFIGS = eINSTANCE.getTranslationUnit_Configs();

		/**
		 * The meta object literal for the '<em><b>Sources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSLATION_UNIT__SOURCES = eINSTANCE.getTranslationUnit_Sources();

		/**
		 * The meta object literal for the '{@link org.eclipse.modisco.kconfig.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.modisco.kconfig.impl.ModelImpl
		 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getModel()
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
		 * The meta object literal for the '<em><b>Configs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__CONFIGS = eINSTANCE.getModel_Configs();

		/**
		 * The meta object literal for the '<em><b>Full Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__FULL_PATH = eINSTANCE.getModel_FullPath();

		/**
		 * The meta object literal for the '{@link org.eclipse.modisco.kconfig.impl.ConfigImpl <em>Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.modisco.kconfig.impl.ConfigImpl
		 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getConfig()
		 * @generated
		 */
		EClass CONFIG = eINSTANCE.getConfig();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIG__NAME = eINSTANCE.getConfig_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIG__TYPE = eINSTANCE.getConfig_Type();

		/**
		 * The meta object literal for the '<em><b>Help Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIG__HELP_TEXT = eINSTANCE.getConfig_HelpText();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIG__DESCRIPTION = eINSTANCE.getConfig_Description();

		/**
		 * The meta object literal for the '<em><b>Depends</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIG__DEPENDS = eINSTANCE.getConfig_Depends();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIG__OWNER = eINSTANCE.getConfig_Owner();

		/**
		 * The meta object literal for the '<em><b>Defined In</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIG__DEFINED_IN = eINSTANCE.getConfig_DefinedIn();

		/**
		 * The meta object literal for the '<em><b>Prompt</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIG__PROMPT = eINSTANCE.getConfig_Prompt();

		/**
		 * The meta object literal for the '<em><b>Defaults</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIG__DEFAULTS = eINSTANCE.getConfig_Defaults();

		/**
		 * The meta object literal for the '<em><b>Selects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIG__SELECTS = eINSTANCE.getConfig_Selects();

		/**
		 * The meta object literal for the '<em><b>Ranges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIG__RANGES = eINSTANCE.getConfig_Ranges();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIG__OPTIONS = eINSTANCE.getConfig_Options();

		/**
		 * The meta object literal for the '{@link org.eclipse.modisco.kconfig.Expr <em>Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.modisco.kconfig.Expr
		 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getExpr()
		 * @generated
		 */
		EClass EXPR = eINSTANCE.getExpr();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPR__OWNER = eINSTANCE.getExpr_Owner();

		/**
		 * The meta object literal for the '{@link org.eclipse.modisco.kconfig.impl.ConfigExprImpl <em>Config Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.modisco.kconfig.impl.ConfigExprImpl
		 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getConfigExpr()
		 * @generated
		 */
		EClass CONFIG_EXPR = eINSTANCE.getConfigExpr();

		/**
		 * The meta object literal for the '<em><b>Negated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIG_EXPR__NEGATED = eINSTANCE.getConfigExpr_Negated();

		/**
		 * The meta object literal for the '<em><b>Ref On Config</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIG_EXPR__REF_ON_CONFIG = eINSTANCE.getConfigExpr_RefOnConfig();

		/**
		 * The meta object literal for the '{@link org.eclipse.modisco.kconfig.impl.PromptImpl <em>Prompt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.modisco.kconfig.impl.PromptImpl
		 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getPrompt()
		 * @generated
		 */
		EClass PROMPT = eINSTANCE.getPrompt();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROMPT__OWNER = eINSTANCE.getPrompt_Owner();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROMPT__EXPRESSION = eINSTANCE.getPrompt_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.modisco.kconfig.impl.DependImpl <em>Depend</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.modisco.kconfig.impl.DependImpl
		 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getDepend()
		 * @generated
		 */
		EClass DEPEND = eINSTANCE.getDepend();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPEND__OWNER = eINSTANCE.getDepend_Owner();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPEND__EXPRESSION = eINSTANCE.getDepend_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.modisco.kconfig.impl.DefaultImpl <em>Default</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.modisco.kconfig.impl.DefaultImpl
		 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getDefault()
		 * @generated
		 */
		EClass DEFAULT = eINSTANCE.getDefault();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT__OWNER = eINSTANCE.getDefault_Owner();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT__EXPRESSION = eINSTANCE.getDefault_Expression();

		/**
		 * The meta object literal for the '<em><b>If Expr</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT__IF_EXPR = eINSTANCE.getDefault_IfExpr();

		/**
		 * The meta object literal for the '{@link org.eclipse.modisco.kconfig.impl.TristateExprImpl <em>Tristate Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.modisco.kconfig.impl.TristateExprImpl
		 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getTristateExpr()
		 * @generated
		 */
		EClass TRISTATE_EXPR = eINSTANCE.getTristateExpr();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRISTATE_EXPR__VALUE = eINSTANCE.getTristateExpr_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.modisco.kconfig.impl.LiteralExprImpl <em>Literal Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.modisco.kconfig.impl.LiteralExprImpl
		 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getLiteralExpr()
		 * @generated
		 */
		EClass LITERAL_EXPR = eINSTANCE.getLiteralExpr();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_EXPR__VALUE = eINSTANCE.getLiteralExpr_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.modisco.kconfig.impl.SelectImpl <em>Select</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.modisco.kconfig.impl.SelectImpl
		 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getSelect()
		 * @generated
		 */
		EClass SELECT = eINSTANCE.getSelect();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT__OWNER = eINSTANCE.getSelect_Owner();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT__EXPRESSION = eINSTANCE.getSelect_Expression();

		/**
		 * The meta object literal for the '<em><b>If Expr</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT__IF_EXPR = eINSTANCE.getSelect_IfExpr();

		/**
		 * The meta object literal for the '{@link org.eclipse.modisco.kconfig.impl.RangeImpl <em>Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.modisco.kconfig.impl.RangeImpl
		 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getRange()
		 * @generated
		 */
		EClass RANGE = eINSTANCE.getRange();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RANGE__OWNER = eINSTANCE.getRange_Owner();

		/**
		 * The meta object literal for the '<em><b>Lower Expr</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RANGE__LOWER_EXPR = eINSTANCE.getRange_LowerExpr();

		/**
		 * The meta object literal for the '<em><b>If Expr</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RANGE__IF_EXPR = eINSTANCE.getRange_IfExpr();

		/**
		 * The meta object literal for the '<em><b>Upper Expr</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RANGE__UPPER_EXPR = eINSTANCE.getRange_UpperExpr();

		/**
		 * The meta object literal for the '{@link org.eclipse.modisco.kconfig.impl.OptionImpl <em>Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.modisco.kconfig.impl.OptionImpl
		 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getOption()
		 * @generated
		 */
		EClass OPTION = eINSTANCE.getOption();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTION__OWNER = eINSTANCE.getOption_Owner();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION__NAME = eINSTANCE.getOption_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION__VALUE = eINSTANCE.getOption_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.modisco.kconfig.impl.BooleanExprImpl <em>Boolean Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.modisco.kconfig.impl.BooleanExprImpl
		 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getBooleanExpr()
		 * @generated
		 */
		EClass BOOLEAN_EXPR = eINSTANCE.getBooleanExpr();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_EXPR__RIGHT = eINSTANCE.getBooleanExpr_Right();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_EXPR__LEFT = eINSTANCE.getBooleanExpr_Left();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_EXPR__TYPE = eINSTANCE.getBooleanExpr_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.modisco.kconfig.ConfigType <em>Config Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.modisco.kconfig.ConfigType
		 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getConfigType()
		 * @generated
		 */
		EEnum CONFIG_TYPE = eINSTANCE.getConfigType();

		/**
		 * The meta object literal for the '{@link org.eclipse.modisco.kconfig.TristateValue <em>Tristate Value</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.modisco.kconfig.TristateValue
		 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getTristateValue()
		 * @generated
		 */
		EEnum TRISTATE_VALUE = eINSTANCE.getTristateValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.modisco.kconfig.BooleanExprType <em>Boolean Expr Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.modisco.kconfig.BooleanExprType
		 * @see org.eclipse.modisco.kconfig.impl.KconfigPackageImpl#getBooleanExprType()
		 * @generated
		 */
		EEnum BOOLEAN_EXPR_TYPE = eINSTANCE.getBooleanExprType();

	}

} //KconfigPackage
